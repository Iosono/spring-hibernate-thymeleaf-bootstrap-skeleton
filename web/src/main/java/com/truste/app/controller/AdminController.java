package com.truste.app.controller;

import com.truste.app.dao.UserRepository;
import com.truste.app.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController
{
    @Autowired
    UserRepository userRepo;

    @RequestMapping("/users")
    public String showRoles(@RequestParam(defaultValue = "1", required = false) int page,
                            @RequestParam(defaultValue = "10", required = false) int size,
                            Model model)
    {
        final PageRequest pageRequest = new PageRequest(page, size);
        final List<User> pagedUsers = userRepo.findAll();
        model.addAttribute("users", pagedUsers);

        return "/admin/users";
    }
}