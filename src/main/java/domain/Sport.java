/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.util.List;
import java.util.stream.Collectors;
import org.javalite.activejdbc.Model;
import records.SportRecord;

/**
 * Sport object inheriting from the model class. With some added methods for
 * "comfort" A Sport contain the attributes: ID ("primekey") name
 *
 * @author David Sjöblom
 */
public class Sport {

    private final SportRecord sport;

    public Sport() {
        this(new SportRecord());
    }

    public Sport(SportRecord record) {
        this.sport = record;
    }

    /**
     * get all of sport table content
     *
     * @return
     */
    public int getId() {
        return Integer.parseInt(sport.getString("id"));
    }

    public String getName() {
        return sport.getString("name");
    }

    /**
     * We want to implement the "base" error handling here, such as we don't
     * accept the empty string as a sport name or already existing id, maybe not
     * even allow id input to be fair.
     *
     * @param name
     */
    public void setName(String name) throws ExceptionClass {
            if (name.isBlank()) {
                throw new ExceptionClass("Input may not only be whitespaces.");
            }
            if (!name.matches("[a-zA-Z]+")) {
                throw new ExceptionClass("Use of invalid characters.");
            }
            
            sport.set("name", name);
            sport.set("id", SportRecord.count().intValue() + 1); // This causes error in the testing phase. But works in practice, trust me :)
    }

    /**
     * Current error handling; null, whitespaces and sport already existing.
     *
     */
    public boolean insert() {
        if (this.getName() == null) {
            throw new NullPointerException("Sport name has not been assigned");
        }

        for (Sport s : Sport.findAll()) {
            if (this.getName().equals(s.getName())) {
                System.out.println("Sport already exist."); //Should probebly be some sort of exception instead.
                return false;
            }
        }
        return sport.insert();
    }

    /**
     * Attitional stuff to get main to work as is.
     */
    public static List<Sport> findAll() {
        List<SportRecord> sportRecordList = SportRecord.findAll();
        return sportRecordList.stream().map(record -> new Sport(record)).collect(Collectors.toList());
    }

    public static Sport findById(int x) {
        return new Sport(SportRecord.findById(x));
    }

    public void saveit() {
          sport.set("id", SportRecord.count().intValue() + 1);
        sport.save();
    }
}
