package com.spring.controller;


import com.spring.CustomClasses.BirimObject;
import com.spring.CustomClasses.TestObject;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class HomeController {

    @ResponseBody
    @RequestMapping (value = "/recursive", method = RequestMethod.GET)
    public ArrayList<BirimObject> recursive(){
        ArrayList<BirimObject> birimObjectArrayList = new ArrayList<BirimObject>();
        birimObjectArrayList.add(new BirimObject(1,"Dota 2",0, new ArrayList<BirimObject>()));
        birimObjectArrayList.add(new BirimObject(2,"Strength",1,new ArrayList<BirimObject>()));
        birimObjectArrayList.add(new BirimObject(3,"Earthshaker",2,new ArrayList<BirimObject>()));
        birimObjectArrayList.add(new BirimObject(4,"Tiny",2,new ArrayList<BirimObject>()));
        birimObjectArrayList.add(new BirimObject(5,"Beastmaster",2,new ArrayList<BirimObject>()));
        birimObjectArrayList.add(new BirimObject(6,"Agility",1,new ArrayList<BirimObject>()));
        birimObjectArrayList.add(new BirimObject(7,"Shadow Fiend",6,new ArrayList<BirimObject>()));
        birimObjectArrayList.add(new BirimObject(8,"Drow Ranger",6,new ArrayList<BirimObject>()));
        birimObjectArrayList.add(new BirimObject(9,"Intelligence",1,new ArrayList<BirimObject>()));
        birimObjectArrayList.add(new BirimObject(10,"Invoker",9,new ArrayList<BirimObject>()));
        birimObjectArrayList.add(new BirimObject(11,"Spirits",9,new ArrayList<BirimObject>()));
        birimObjectArrayList.add(new BirimObject(12,"Storm Spirit",11,new ArrayList<BirimObject>()));
        birimObjectArrayList.add(new BirimObject(13,"Earth Spirit",11,new ArrayList<BirimObject>()));
        birimObjectArrayList.add(new BirimObject(14,"Ember Spirit",11,new ArrayList<BirimObject>()));
        //ModelAndView modelAndView = new ModelAndView("recursive");
        return /*birimObjectArrayList;//*/parseItems(birimObjectArrayList);

    }

    private ArrayList<BirimObject> parseItems (ArrayList<BirimObject> birimObjectArrayList) {
        int firstId = 0;
        BirimObject lastObject = new BirimObject(0,"",0,new ArrayList<BirimObject>());
        ArrayList<BirimObject> arrayToReturn = new ArrayList<BirimObject>();
        for (BirimObject birimObject : birimObjectArrayList){
            if (birimObject.getUstBirimId() == firstId) {
                arrayToReturn.add(birimObject);
                lastObject = birimObject;
            }else {
                addItem(lastObject,birimObjectArrayList);
            }
        }
        return arrayToReturn;
    }
    private void addItem(BirimObject object, ArrayList<BirimObject> birimObjectArrayList) {
        BirimObject parentObject = birimObjectArrayList.get(birimObjectArrayList.indexOf(object));
        for (BirimObject childObject : birimObjectArrayList) {
            if (childObject.getUstBirimId() == parentObject.getBirimId()) {
                if (!parentObject.getAltMenuler().contains(childObject)) {
                    parentObject.getAltMenuler().add(childObject);
                }
                addItem(childObject,birimObjectArrayList);
            }
        }
    }

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
       return result.hasErrors() ? new ModelAndView("testform") :
               new ModelAndView("successform");
    }

}
