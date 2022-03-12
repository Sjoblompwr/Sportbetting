/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import org.javalite.activejdbc.Model;

/**
 * Class contains functionallity which all "bet objects" share.
 *
 * @author David Sjöblom
 */
public class CommonFunctions {

    /**
     * Uses .getString method in Model to fetch String value of choosen
     * attribute This value is then converter to Integer.
     *
     * @param model - db domain
     * @param attribute - In form of table name
     * @return - Integer value from db
     */
    public static int getInteger(Model model, String attribute) {
        return Integer.parseInt(model.getString(attribute));
    }

    /**
     * Uses .set method in Model to set choosen attribute. Can only set integer
     * values.
     *
     * @param model - db domain
     * @param attribute - db table name
     * @param value - Integer input into db
     */
    public static void setInteger(Model model, String attribute, int value) {
        model.set(attribute, value);
    }

    /**
     * Uses .getString method in Model to fetch String value of choosen
     * attribute
     *
     * @param model - db domain
     * @return - attribute "name" as a String
     */
    public static String getName(Model model) {
        return model.getString("name");
    }

    /**
     * Uses .set method in Model, inputs attributes name & id into db. Also some
     * error handling such as which characters are allowed / whitespace remover.
     *
     * @param name - Attribute value name
     * @param model - db domain
     * @param id - Attribute value id
     * @throws ExceptionClass - extension of Exception.class, used to pass
     * useful error messages. Could be exchanged with a boolean return instead.
     */
    public static void setName(String name, Model model, int id) throws ExceptionClass {

        if (!name.matches("[a-zA-Z]+")) {
            throw new ExceptionClass("Use of invalid characters.");
        }
        name = CommonFunctions.excessWhitespaceRemover(name);

        if (name.isBlank()) {
            throw new ExceptionClass("Input may not only be whitespaces.");
        }

        model.set("name", name);
        model.set("id", id);
    }

    /**
     * Function for removing excess whitespace in string input. Example input: "
     * foo bar" Returns: "foo bar".
     *
     * @param s - Any string
     * @return - String with no consecutive whitespace
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
