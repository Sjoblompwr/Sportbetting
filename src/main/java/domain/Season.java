/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import records.SeasonRecord;

/**
 * Season object inheriting from the model class.
 *
 * @author David Sjöblom
 */
public class Season  {
    private final SeasonRecord season;
    public Season(){
        this(new SeasonRecord());
    }
    public Season(SeasonRecord record){
        this.season = record;
    }
}
