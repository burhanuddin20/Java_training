
package com.buddin.todoapi.data;

import com.buddin.todoapi.models.ToDo;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

/**
 *
 * @author burhan
 * @date 8 Sep 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose:
 */

@Repository
@Profile("memory")
public class ToDoInMemoryDao implements ToDoDao{
    
    
    
    private static final List<ToDo> todos = new ArrayList<>();

    @Override
    public ToDo add(ToDo todo) {
        
        // use a stream to find the max int id
        int nextId = todos.stream()
                .mapToInt(i -> i.getId())
                .max()
                .orElse(0) + 1;

        todo.setId(nextId);
        todos.add(todo);
        return todo;    }

    @Override
    public List<ToDo> getAll() {
        return new ArrayList<>(todos);    
    }

    @Override
    public ToDo findById(int id) {
            return todos.stream()
                .filter(i -> i.getId() == id)
                .findFirst()
                .orElse(null);    }

    @Override
    public boolean update(ToDo todo) {
        int index = 0;
        while (index < todos.size()
                && todos.get(index).getId() != todo.getId()) {
            index++;
        }

        if (index < todos.size()) {
            todos.set(index, todo);
        }
        return index < todos.size();    }

    @Override
    public boolean deleteById(int id) {
        return todos.removeIf(i -> i.getId() == id);    }

}
