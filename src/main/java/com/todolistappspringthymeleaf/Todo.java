package com.todolistappspringthymeleaf;

import java.io.StringReader;
import java.util.UUID;

public class Todo {
    private UUID id;
    private TodoStatus status;

    private String description;

    public Todo() {

        this.id = UUID.randomUUID();
        this.status = TodoStatus.PENDING;
        }



    public Todo(UUID id, String description, TodoStatus status) {
        this.id = id;
        this.description = description;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public TodoStatus getStatus() {
        return status;
    }

    public void setStatus(TodoStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
