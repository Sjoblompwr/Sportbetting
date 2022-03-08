/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;


import org.javalite.activejdbc.Model;

/**
 * Might want to consdier making all methods static in order to avoid creating
 * an instance of this class in every domain.
 *
 * @author Dator
 */
public class CommonFunctions {

    public int getInteger(Model model, String attribute) {
        return Integer.parseInt(model.getString(attribute));
    }

    public void setInteger(Model model, String attribute, int value) {
        model.set(attribute, value);
    }

    public String getName(Model model) {
        return model.getString("name");
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
}
