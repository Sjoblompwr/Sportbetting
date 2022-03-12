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
 * Sport object , getting database connection throught the Record input. Which
 * Should extend Model.
 *
 * @author David Sjöblom
 */
public class Sport implements BetObject {

    private final SportRecord sport;

    /**
     *
     */
    public Sport() {
        this(new SportRecord());
    }

    /**
     *
     * @param record
     */
    public Sport(SportRecord record) {
        this.sport = record;
    }

    /**
     * get all of sport table content
     *
     * @return
     */
    public int getId() {
        return CommonFunctions.getInteger(sport, "id");
    }

    /**
     *
     * @return
     */
    public String getName() {
        return CommonFunctions.getName(sport);
    }

    /**
     * We want to implement the "base" error handling here, such as we don't
     * accept the empty string as a sport name or already existing id, maybe not
     * even allow id input to be fair.
     *
     * @param name
     * @throws domain.ExceptionClass
     */
    public void setName(String name) throws ExceptionClass {
        CommonFunctions.setName(name, sport, SportRecord.count().intValue() + 1);
    }

    /**
     * Current error handling; null, whitespaces and sport already existing.
     *
     * @return 
     * @throws domain.ExceptionClass
     */
    public boolean insert()  throws ExceptionClass{
//        if (this.getId() == 0) {
//          throw new NullPointerException("Sport id (name has not been selected) has not been assigned");
//        }
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
     * @return 
     */
    public static List<Sport> findAll() {
        List<SportRecord> sportRecordList = SportRecord.findAll();
        return sportRecordList.stream().map(record -> new Sport(record)).collect(Collectors.toList());
    }

    /**
     *
     * @param x
     * @return
     */
    public static Sport findById(int x) {
        return new Sport(SportRecord.findById(x));
    }

}
