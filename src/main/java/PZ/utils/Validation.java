package PZ.utils;

public class Validation {
    public static String validateNewCharacter(String name, String description, String passive_ability, String q_ability, String w_ability, String e_ability, String r_ability) {
        if(name.isEmpty() || description.isEmpty() || passive_ability.isEmpty() || q_ability.isEmpty() || w_ability.isEmpty() || e_ability.isEmpty() || r_ability.isEmpty()) {
            return "Aby dodać nową postać, należy wypełnić wszystkie pola!!!";
        }
        if(name.matches("/^[A-Za-z]+$/")) {
            return "Niepoprawna nazwa postaci";
        }
        return "";
    }
}
