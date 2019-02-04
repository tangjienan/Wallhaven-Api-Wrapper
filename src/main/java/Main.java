import api.WallHavenWrapper;

import java.io.IOException;
/**
 * Created by donezio on 1/26/19.
 */
public class Main {


    public static void main(String[] args) throws IOException {

        WallHavenWrapper api = new api.WallHavenWrapper();
        //api.getToplist();
        //api.searchPictures();

        model.Wallpaper wp = api.getPicture("?");
        wp.printWallpaper();
        //System.out.println(wp.getAlt());
    }
}
