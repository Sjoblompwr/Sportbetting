/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import org.javalite.activejdbc.Model;

/**
 * Team object inheriting from the model class. With some added methods for
 * "comfort"
 *
 * @author David Sjöblom
 */
public class Team extends Model {

    /**
     * get all team table content
     *
     * @return
     */
    public int getTeamID() {
        return Integer.parseInt(getString("id"));
    }

    public String getTeamName() {
        return getString("name");
    }

}
