package Utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * Created by donezio on 2/3/19.
 */
public class utils implements Runnable {
    // V should be string or List<String>
    public static <V>  void printHashMap(Map<String,V> map) {
        for (Map.Entry<String, V> e : map.entrySet()) {
            String str = null;
            List<String> list = null;
            System.out.print("  " + e.getKey() + ":   ");
            // Check if a String
            try {
                str = (String) e.getValue();
                System.out.print(str + " ");
            } catch (Exception exception) {}

            // Check if a List
            try {
                list = (List<String>) e.getValue();
                for(String s: list) {
                    System.out.print("  " + s + " "  );
                }
            } catch (Exception exception) {}

            System.out.println();
        }
        //System.out.println();
    }

    public static void downloadPicFromUrl(String urlString, String id) {

        //Image image = null;
        try {
            //URL url = new URL("http://userserve-ak.last.fm/serve/126/8636005.jpg");
            URL url = new URL(urlString + ".jpg");
            Image image = ImageIO.read(url.openStream());
            File outputfile = new File("/Users/macbookpro/Desktop/wallhaven_api_wrapper/downloads/" + id + ".jpg");
            ImageIO.write((RenderedImage) image, "jpg", outputfile);
        } catch (IOException e) {
            try {
                URL url = new URL(urlString + ".png");
                Image image = ImageIO.read(url.openStream());
                File outputfile = new File("/Users/macbookpro/Desktop/wallhaven_api_wrapper/downloads/" + id + ".png");
                ImageIO.write((RenderedImage) image, "jpg", outputfile);
            } catch (IOException e2) {

                System.out.println("URL : " + urlString +  " failed to download");
                System.out.println(e);
            }
        }
    }

    @Override
    public void run() {

    }
}
