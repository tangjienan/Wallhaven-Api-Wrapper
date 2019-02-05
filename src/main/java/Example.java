import api.BaseWrapper;
import api.WallHavenWrapper;
import model.Thumb;

import java.io.IOException;
import java.util.List;

/**
 * Created by donezio on 1/26/19.
 */
public class Example {


    public static void main(String[] args) throws IOException {


        BaseWrapper.Categories[] categories = new BaseWrapper.Categories[] {BaseWrapper.Categories.PEOPLE};
        WallHavenWrapper api = new api.WallHavenWrapper();
        api.setSearchKeyword("Dog");
        api.setCategories(categories);
        //api.getToplist();
        List<Thumb> list = api.searchPictures();
        list.forEach(e -> System.out.println(e));
        list = api.searchPictures();
        list.forEach(e -> System.out.println(e));

        model.Wallpaper wp = api.getPicture("6683");
        wp.printWallpaper();
        //System.out.println(wp.getAlt());
    }
}
