package com.spring.controller;


import com.spring.CustomClasses.TestObject;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
public class HomeController {
    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.setDisallowedFields(new String("mobile"));
        SimpleDateFormat format = new SimpleDateFormat("yyyy**MM**dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(format,false));
    }

    @RequestMapping (value = "/testform", method = RequestMethod.GET)
    public ModelAndView home(){
        return new ModelAndView("testform");
    }

    @ModelAttribute
    public void addingCommonObjects(Model model1){
        model1.addAttribute("headerMessage", "test header message");
    }

    @RequestMapping (value = "/submitform", method = RequestMethod.POST)
    public ModelAndView submitForm (@ModelAttribute("testObjectM") TestObject testObject, BindingResult result) {
       return result.hasErrors() ? new ModelAndView("testform") : new ModelAndView("successform");
    }

}
