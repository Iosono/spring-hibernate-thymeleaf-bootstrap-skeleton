package com.truste.app.controller;

import com.truste.app.dao.UserRepository;
import com.truste.app.domain.User;
import com.truste.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Service
public class UserValidator implements Validator
{
    @Autowired
    Validator validator;

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean supports(Class<?> aClass)
    {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object obj, Errors errors)
    {
        validator.validate(obj, errors);

        User user = (User) obj;
        if(StringUtils.isEmpty(user.getEmail()))
        {
            if(userRepository.findByEmail(user.getEmail()) != null)
            {
                errors.rejectValue("email", "user.email.duplicate", "Duplicate User");
            }
        }
    }
}
