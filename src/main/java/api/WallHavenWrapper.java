package api;

import Utils.utils;
import model.Thumb;
import model.Wallpaper;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;

/**
 * Created by donezio on 1/26/19.
 */
public class WallHavenWrapper extends BaseWrapper {


    Set<Categories> categories;

    Set<Purity> purities;

    String searchKeyWord;

    Resolution resolution;

    int currentPage;

    WebDriver driver = new WebDriver();

    State state;

    Sorting sort = Sorting.VIEWS;

    //Set<String> resolution;

    Order order;

    public WallHavenWrapper() {
        searchKeyWord = "";
        categories = new HashSet<Categories>();
        // default
        categories.add(Categories.ANIME);
        categories.add(Categories.PEOPLE);
        categories.add(Categories.GENERAL);
        purities = new HashSet<Purity>();
        // default
        purities.add(Purity.SFW);
        //resolution = new HashSet<String>();
        //resolution.add("2560x1440");
        resolution = null;
        currentPage = 0;
        state = State.WAITING;
        currentPage = 0;
        order = Order.DESC;
    }

    public WallHavenWrapper setSearchKeyword(String keyword) {
        this.searchKeyWord = keyword;
        return this;
    }

    public WallHavenWrapper setCategories (Categories[] input) {
        categories.clear();
        for (Categories c : input) {
            categories.add(c);
        }
        return this;
    }

    public WallHavenWrapper setPurities (Purity[] input) {
        purities.clear();
        for (Purity p : input) {
            purities.add(p);
        }
        return this;
    }

    public WallHavenWrapper setResolution(Resolution resolution) {
        this.resolution = resolution;
        return this;
    }

    public String createFullUrl() {

        if (state == State.CUSTOM) {
            currentPage +=  1;
        } else {
            currentPage = 1;
        }

        String url = super.baseUrl;

        // add search
        url += "search?q=" + searchKeyWord;
        // add catergory
        url += "&categories=" + getCategoriesString(categories);
        // add purity
        url += "&purity=" + getPurityString(purities);
        // add sorting
        url += "&sorting=" + sort.getSortingString();
        // add resolution
        if (resolution != null) {
            url += "&atleast=" + resolution.name().substring(1);
        }
        // add order
        url += "&order=" + order.name().toLowerCase();
        if (currentPage != 0) {
            url += "&page=" + currentPage;
        }
        state = State.CUSTOM;

        System.out.println(url);
        return url;
    }

    public List<Thumb> getToplist() {

        String url = super.toplist;

        if (state == State.TOPLIST) {
            currentPage +=  1;
            url += "&page=" + currentPage;
        } else {
            currentPage = 1;
        }

        state = State.TOPLIST;

        return driver.getTumbsFromUrl(super.toplist);
    }

    public List<Thumb> getRandom() {

        String url = super.random;

        if (state == State.RANDOM) {
            currentPage +=  1;
            url += "&page=" + currentPage;
        } else {
            currentPage = 1;
        }

        return driver.getTumbsFromUrl(url);
    }

    public List<Thumb> getLatest() {

        String url = super.latest;

        if (state == State.LATEST) {
            currentPage +=  1;
            url += "&page=" + currentPage;
        } else {
            currentPage = 1;
        }

        return driver.getTumbsFromUrl(url);
    }

    /**
     *  perform api search
     */
    public List<Thumb> searchPictures () {
        String url = createFullUrl();
        return driver.getTumbsFromUrl(url);
        //System.out.println(url);
    }


    public void downloadPictures() {
        List<Thumb> list = searchPictures();
        int count = 1;
        ExecutorService es = Downloader.downloader();
        String baseUrl = super.fullUrl;
        for (Thumb t : list) {
//            System.out.println("Downloading the " + count++ + " wallpapers");
//            //Wallpaper wp = getPicture(t.getId());
//            System.out.println("ID" + t.getId() + " url: " + t.getUrl());
//            utils.downloadPicFromUrl(super.fullUrl + t.getId(), t.getId());

            es.submit(new Runnable(){
                @Override
                public void run(){
                    utils.downloadPicFromUrl(baseUrl + t.getId(), t.getId());
                }
            });
        }
        es.shutdown();
    }

    public Wallpaper getPicture(String id) {
        return driver.getWallpaperFromUrl(id);
    }
}
