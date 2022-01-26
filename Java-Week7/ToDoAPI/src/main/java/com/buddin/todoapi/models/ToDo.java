
package com.buddin.todoapi.models;

/**
 *
 * @author burhan
 * @date 8 Sep 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose:
 */
public class ToDo {
    
    private int id;
    private String todo;
    private String note;
    private boolean finished;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

}
