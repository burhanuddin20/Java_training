
package com.buddin.todoapi.data;

import com.buddin.todoapi.models.ToDo;
import java.util.List;

/**
 *
 * @author burhan
 * @date 8 Sep 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose: Interface defines the CRUD operations
 */
public interface ToDoDao {
    
    
    ToDo add(ToDo todo);

    List<ToDo> getAll();

    ToDo findById(int id);

    // true if item exists and is updated
    boolean update(ToDo todo);

    // true if item exists and is deleted
    boolean deleteById(int id);

}
