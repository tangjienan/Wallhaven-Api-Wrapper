import api.WallHavenWrapper;

import java.io.IOException;

/**
 * Created by donezio on 1/26/19.
 */
public class Main {
    public static void main(String[] args) throws IOException {

        WallHavenWrapper api = new WallHavenWrapper();
        api.getPicture("?");
    }
}
