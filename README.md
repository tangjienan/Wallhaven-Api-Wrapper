# Wallhaven API Wrapper 
A wallhaven api wrapper in Java. It uses selenium to parse dynamic content.

# Intall
First include the [Chrome driver](http://chromedriver.chromium.org/downloads) into the project diretory. 
Then include the [JAR](https://github.com/tangjienan/Wallhaven-Api-Wrapper/blob/master/wallhaven_api_wrapper.jar) file into the project.

# How to use

Create the wrapper

```WallHavenWrapper api = new api.WallHavenWrapper();```

Set keyword to search

```api.setSearchKeyword("Dog");```

Getting a list of wallpapers

```List<Thumb> list = api.searchPictures();```

Example output:

    ID: 272394  URL: https://alpha.wallhaven.cc/wallpaper/272394 Width: 1920 Height: 1080
    ID: 201713  URL: https://alpha.wallhaven.cc/wallpaper/201713 Width: 1920 Height: 1080
    ID: 35101  URL: https://alpha.wallhaven.cc/wallpaper/35101 Width: 2197 Height: 1463
    ID: 138360  URL: https://alpha.wallhaven.cc/wallpaper/138360 Width: 1920 Height: 1080
    ID: 125989  URL: https://alpha.wallhaven.cc/wallpaper/125989 Width: 3200 Height: 2126
    ID: 19061  URL: https://alpha.wallhaven.cc/wallpaper/19061 Width: 1920 Height: 1080
    ID: 125986  URL: https://alpha.wallhaven.cc/wallpaper/125986 Width: 3200 Height: 2126
    ID: 460855  URL: https://alpha.wallhaven.cc/wallpaper/460855 Width: 1302 Height: 1500
    ID: 109769  URL: https://alpha.wallhaven.cc/wallpaper/109769 Width: 2560 Height: 1600
    ID: 298122  URL: https://alpha.wallhaven.cc/wallpaper/298122 Width: 1920 Height: 1080
    ID: 75897  URL: https://alpha.wallhaven.cc/wallpaper/75897 Width: 1920 Height: 1080

Make the ```searchPictures()``` call again to get the next page

Getting the detail for one wallpaper, use wallpaper id as input

```Wallpaper wp = api.getPicture("6688");```

    Example output
    TimeCreated:   4 years ago
    TinyUrl:   https://whvn.cc/6683
    Category:   General
    Views:   2,457
    Size:   2 MiB
    Alt:   General 3000x1293 Mass Effect Mass Effect 2 Mass Effect 3 Cerberus  Garrus Vakarian Commander Shepard Javik Ashley Williams video games science fiction digital art artwork
    Purity:   SFW
    Id:   6683
    Uploader:   ofek3212
    FullUrl:   https://wallpapers.wallhaven.cc/wallpapers/full/wallhaven-6683.jpg
    Tags:    Javik Commander Shepard Garrus Vakarian Ashley Williams science fiction Mass Effect 2 Cerberus  Mass Effect Mass Effect 3 artwork video games digital art




