package api;

import java.util.Set;

/**
 * Created by donezio on 1/26/19.
 */
public class BaseWrapper {

    enum Categories {
        GENERAL, ANIME, PEOPLE;
    }

    enum Purity {
        SFW, SKETCHY;
    }

    public static String baseUrl = "https://alpha.wallhaven.cc/";


    public String getCategoriesString(Set<Categories> input) {
        StringBuilder result = new StringBuilder();

        result.append(input.contains(Categories.GENERAL)? "1" : "0");
        result.append(input.contains(Categories.ANIME)? "1" : "0");
        result.append(input.contains(Categories.PEOPLE)? "1" : "0");

        return result.toString();
    }

    public String getPurityString(Set<Purity> input) {

        StringBuilder result = new StringBuilder();

        result.append(input.contains(Purity.SFW)? "1" : "0");
        result.append(input.contains(Purity.SKETCHY)? "1" : "0");

        return result.toString();
    }

}
