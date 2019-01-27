package api;

import model.Wallpaper;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by donezio on 1/26/19.
 */
public class WallHavenWrapper extends BaseWrapper {


    Set<Categories> categories;

    Set<Purity> purities;

    String searchKeyWord;

    int currentPage;

    public WallHavenWrapper() {
        searchKeyWord = null;
        categories = new HashSet<Categories>();
        purities = new HashSet<Purity>();
        currentPage = 0;
    }

    public WallHavenWrapper setSearchKeyword(String keyword) {
        this.searchKeyWord = keyword;
        return this;
    }

    public WallHavenWrapper setCategories (Categories[] input) {
        for (Categories c : input) {
            categories.add(c);
        }
        return this;
    }

    public WallHavenWrapper setPurities () {
        return this;
    }

    public String createFullUrl() {
        return super.baseUrl;
    }

    /**
     *  perform api search
     */
    public void searchPictures () {

    }

    public Wallpaper getPicture(String id) {
        return null;
    }

}
