package com.todolistappspringthymeleaf;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

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

    public void updateTodoStatus(Todo todo) throws Exception {
        AtomicBoolean isUpdated = new AtomicBoolean(false);
        //safety thing to control if the thing works the way we want, its needed because we use it inside lambda function
        this.todoList.forEach(currentTodoItem -> {
          if (currentTodoItem.getId().equals(todo.getId())) {
              currentTodoItem.setStatus(todo.getStatus());
              isUpdated.set(true);
              //System.out.println(currentTodoItem);
          }
        });

        if (!isUpdated.get()) throw new Exception("Update failed,please try again!");

    }
}
