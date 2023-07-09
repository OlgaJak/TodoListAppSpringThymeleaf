package com.todolistappspringthymeleaf;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class TodoService {
    private final ArrayList<Todo> todoList;

    public TodoService() {
        this.todoList = new ArrayList<>();
    }

    public Todo addTodo(Todo todo)throws Exception{
        if (todo.getDescription().isBlank()){
            throw new Exception("Please provide description");
        }
        this.todoList.add(todo);
        return todo;
    }

    public ArrayList<Todo> getTodoList(){
        return this.todoList;
    }
}
