import api.BaseWrapper;
import api.WallHavenWrapper;

import java.io.IOException;
import java.util.PriorityQueue;

/**
 * Created by donezio on 1/26/19.
 */
public class Example {


    public static void main(String[] args) throws IOException {


        BaseWrapper.Categories[] categories = new BaseWrapper.Categories[] {BaseWrapper.Categories.GENERAL};
        WallHavenWrapper api = new api.WallHavenWrapper();
        api.setSearchKeyword("cars").setResolution(BaseWrapper.Resolution._1600x900);

        api.setCategories(categories);
        //api.getToplist();
        api.downloadPictures();
        api.downloadPictures();
        api.downloadPictures();
        //api.searchPictures();

//        LinkedHashMap<String, String> set = new LinkedHashMap();
//        ArrayList<String> list = new ArrayList<>();
        PriorityQueue<String> pq = new PriorityQueue<>();

        //utils.downloadPicFromUrl("hey");

        //System.out.println(wp.getAlt());
    }
}
