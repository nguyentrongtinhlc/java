package com.example.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<Task> listTasks = taskRepository.findAll();
        model.addAttribute("listTasks", listTasks);
        model.addAttribute("task", new Task());
        return "index";
    }

    @PostMapping("/save")
    public String saveTask(@ModelAttribute("task") Task task) {
        taskRepository.save(task);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEditTask(@PathVariable("id") Long id, Model model) {
        Task task = taskRepository.findById(id).orElse(null);
        model.addAttribute("task", task);
        model.addAttribute("listTasks", taskRepository.findAll());
        return "index";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable("id") Long id) {
        taskRepository.deleteById(id);
        return "redirect:/";
    }
}