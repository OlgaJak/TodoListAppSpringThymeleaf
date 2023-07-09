package com.todolistappspringthymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

//IOC- Inversion of control
@Controller//this allows spring to takle control over your class
public class TodoController {
    private TodoService todoService;
    @Autowired
    public TodoController(TodoService todoService){
        this.todoService = todoService;
    }

    //@restcontroller is for api
    @GetMapping("/") //get request, we are saying that somebody is something for something, slash will show the page
    public String showTodoPage(@RequestParam(required = false) String status,
                               @RequestParam(required = false) String message,
                               Model model){
        model.addAttribute("status",status);
        model.addAttribute("message",message);
        model.addAttribute("todoList",this.todoService.getTodoList());
        System.out.println(status + " - " + message);
        return "todo";
    }

    @GetMapping("/learn-more")
    public String showAboutPage(){
        return "about";
    }

    @PostMapping("/add-item")
    public String addTodoItem(Todo todo){
        try{
            this.todoService.addTodo(todo);
            return "redirect:/?status=success";//for not to repeat ourselves we redirect user back to the display page
        } catch (Exception exception){
            return "redirect:/?status=failed&message="+exception.getMessage();
    }
    }

    @PostMapping("/update-status/{id}")
    public String updateTodoStatus(@PathVariable UUID id, Todo updateRequest){
        try{
            updateRequest.setId(id);
            this.todoService.updateTodoStatus(updateRequest);
//            System.out.println("To do id: " + id);
//            //use todoService to perform update
            return "redirect:/?status=success&message=update successful";
        }catch (Exception exception){
            return "redirect:/?status=failed&message=" + exception.getMessage();
        }
    }
}
