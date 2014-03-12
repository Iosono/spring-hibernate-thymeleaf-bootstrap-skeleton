package com.truste.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SiteController
{
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home()
    {
        return "/home";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginForm()
    {
        return "/login";
    }

    @RequestMapping(value = "/secured", method = RequestMethod.GET)
    public String secured()
    {
        return "/secured";
    }

}
