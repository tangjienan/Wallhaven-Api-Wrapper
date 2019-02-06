import api.BaseWrapper;
import api.WallHavenWrapper;

import java.io.IOException;

/**
 * Created by donezio on 1/26/19.
 */
public class Example {


    public static void main(String[] args) throws IOException {


        BaseWrapper.Categories[] categories = new BaseWrapper.Categories[] {BaseWrapper.Categories.PEOPLE};
        WallHavenWrapper api = new api.WallHavenWrapper();
        api.setSearchKeyword("Edinburgh");
        //api.setCategories(categories);
        //api.getToplist();
        api.downloadPictures();
        //api.searchPictures();

        //utils.downloadPicFromUrl("hey");

        //System.out.println(wp.getAlt());
    }
}
