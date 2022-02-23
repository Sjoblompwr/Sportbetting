/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import org.javalite.activejdbc.Model;

/**
 * Sport object inheriting from the model class. With some added methods for
 * "comfort"
 *
 * @author David Sjöblom
 */
public class Sport extends Model {

    /**
     * get all of sport table content
     *
     * @return
     */
    public int getSportID() {
        return Integer.parseInt(getString("id"));
    }

    public String getSportName() {
        return getString("name");
    }
}
