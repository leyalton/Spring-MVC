package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String redirectToUserList() {
        return "redirect:/users";
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        model.addAttribute("listUsers", userService.listUsers());
        return "users";
    }

    @GetMapping("/new")
    public String addUser(@ModelAttribute("userCreate") User user) {
        return "new";
    }

    @PostMapping("/new")
    public String add(@ModelAttribute("userCreate") User user) {
        userService.create(user);
        System.out.println("контроллер --- " + user);
        return "redirect:/users";
    }

    @GetMapping("/edit")
    public String getUser(@RequestParam int id, Model model) {
        System.out.println("ДААААААААААААААААААААААААААААА");
        System.out.println(id);
        model.addAttribute("userEdit", userService.getUserByID(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute("userEdit") User user) {
        userService.update(user);
        return "redirect:/users";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam int id) {
        System.out.println(id);
        userService.delete(id);
        return "redirect:/users";
    }
}
