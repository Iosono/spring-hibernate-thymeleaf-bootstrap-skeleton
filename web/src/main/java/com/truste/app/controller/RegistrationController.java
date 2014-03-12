package com.truste.app.controller;

import com.truste.app.dao.RoleRepository;
import com.truste.app.dao.UserRepository;
import com.truste.app.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/register")
public class RegistrationController
{
    @Autowired
    UserValidator validator;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @InitBinder
    public void initBinder(WebDataBinder binder)
    {
            binder.setValidator(validator);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String register(@ModelAttribute User user)
    {
        return "/user/register";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveNewUser(@Valid @ModelAttribute User user, BindingResult result)
    {
        if(result.hasErrors())
        {
            return "/user/register";
        }

        userRepository.save(user);
        return "redirect:/register/complete";

    }

    @RequestMapping(value = "/complete", method = RequestMethod.GET)
    public String registrationComplete()
    {
        return "/user/register.complete";
    }

    @ModelAttribute
    public User buildUser()
    {
        User user = new User();
        user.setEnabled(true);
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.getRoles().add(roleRepository.findOne("ROLE_USER"));
        return user;
    }

}
