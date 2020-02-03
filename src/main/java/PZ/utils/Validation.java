package PZ.utils;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

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
    public static String validateNewWeapon(String name,
                                           String attack_speed,
                                           String attack_damage,
                                           String ability_power,
                                           String crit_chance,
                                           String cooldown_reduction,
                                           String mana,
                                           String mana_regen) {
        if(!attack_speed.matches("^[0-9]*$")) {
            return "niepoprawna ilość prędkości ataku";
        }
        if(!attack_damage.matches("^[0-9]*$")) {
            return "niepoprawna ilość siły ataku";
        }
        if(!ability_power.matches("^[0-9]*$")) {
            return "niepoprawna ilość siły umiejętności";
        }
        if(!crit_chance.matches("^[0-9]*$")) {
            return "niepoprawna ilość szansy na uderzenie krytyczne";
        }
        if(!cooldown_reduction.matches("^[0-9]*$")) {
            return "niepoprawna ilość skrócenia czasu odnowienia";
        }
        if(!mana.matches("^[0-9]*$")) {
            return "niepoprawna ilość dodatkowej many";
        }
        if(!mana_regen.matches("^[0-9]*$")) {
            return "niepoprawna ilość regeneracji many";
        }
        return "";
    }
}
