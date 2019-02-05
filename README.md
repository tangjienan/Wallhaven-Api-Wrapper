# Wallhaven API Wrapper 
A wallhaven api wrapper in Java. It uses selenium to parse dynamic content.

# Installing
First include the [Chrome driver](http://chromedriver.chromium.org/downloads) into the project diretory. 
Include the [JAR](https://github.com/tangjienan/Wallhaven-Api-Wrapper/blob/master/wallhaven_api_wrapper.jar) file into the project.

# How to use

    //Creating the wrapper
    WallHavenWrapper api = new api.WallHavenWrapper();
    //Set keyword to search
    api.setSearchKeyword("Dog");
    //Getting a list of wallpapers
    List<Thumb> list = api.searchPictures();
    //Getting the detail for one wallpaper, use wallpaper id as input
    Wallpaper wp = api.getPicture("6688");



