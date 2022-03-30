/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domain.ExceptionClass;
import domain.Sport;

/**
 *
 * @author David Sjöblom
 */
public class AddNewSportService extends BaseService<Boolean> {

    private String name;

    public AddNewSportService(String name) {
        setName(name);
    }
    //Errorhandling for the name attribute is lower down in the stack.(CommonFunctions)
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Boolean execute() {
        Sport sport = getBroker().getSportBroker().create();
        try {
            sport.setName(name);
        } catch (ExceptionClass ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
        Boolean bool = sport.insert();
        return bool;
    }
}
