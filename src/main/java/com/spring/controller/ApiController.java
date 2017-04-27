package com.spring.controller;

import com.spring.CustomClasses.BirimObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class ApiController {

    @RequestMapping(value = "/recursive", method = RequestMethod.GET)
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
        return parseItems(birimObjectArrayList);

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
}
