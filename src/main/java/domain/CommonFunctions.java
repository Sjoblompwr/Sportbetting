/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.util.List;
import java.util.stream.Collectors;
import org.javalite.activejdbc.Model;

/**
 * Might want to consdier making all methods static in order to avoid creating
 * an instance of this class in every domain.
 *
 * @author Dator
 */
public class CommonFunctions {

    public int getInteger(Model model, String arg) {
        return Integer.parseInt(model.getString(arg));
    }
//    public void set(Model model,String arg,String value){
//        model.set("arg",value);
//    }

    /**
     * Function for removing excess whitespace in string input. Example input: "
     * foo bar" Returns: "foo bar".
     *
     * @param s
     * @return
     */
    public static String excessWhitespaceRemover(String s) {
        s = s.trim();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                count++;
            }
            if (count == 2) {
                s = s.substring(0, i) + excessWhitespaceRemover(s.substring(i, s.length()));
            }
        }
        return s;

    }

    //Can implement error handling from sport
    public void setName(String name, Model model, int id) throws ExceptionClass {

        name = name.trim();
        name = CommonFunctions.excessWhitespaceRemover(name);

        if (name.isBlank()) {
            throw new ExceptionClass("Input may not only be whitespaces.");
        }
        if (!name.matches("[a-zA-Z]+")) {
            throw new ExceptionClass("Use of invalid characters.");
        }

        model.set("name", name);
        model.set("id", id); // This causes error in the testing phase. But works in practice, trust me :)
    }
    /**
     * Problem with current implementation, in the for loop, can't have the
     * "BetObject" be of type Model but that's what the list has to be of. Which
     * in turn leads to the call t.getName trying to call a getName function in
     * Model which doesn't exist.
     */
//        /**
//     * Current error handling; null, whitespaces and sport already existing.
//     *
//     * @param object
//     * @param model
//     * @return 
//     */
//    public boolean insert(BetObject object,Model model,List<BetObject> list) {
//        if (object.getName() == null) {
//            throw new NullPointerException("Sport name has not been assigned");
//        }
//
//        for (BetObject t : list) {
//            if (object.getName().equals(t.getName())) {
//                System.out.println("Team already exist."); //Should probebly be some sort of exception instead.
//                return false;
//            }
//        }
//        return model.insert();
//    }

    /**
     * Attitional stuff to get main to work as is.
     */
//    public  List<Model> findAll(Model model) {
//             List<Model> RecordList = model.findAll();
//        return RecordList;
//    }
//
//    public static Team findById(int x,BetObject betObject) {
//        return new Team(betObject.findById(x));
//    }
//
//    public void saveit() {
//          team.set("id", TeamRecord.count().intValue() + 1);
//        team.save();
//    }
//    
//  
}
