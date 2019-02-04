package Utils;

import java.util.List;
import java.util.Map;

/**
 * Created by donezio on 2/3/19.
 */
public class utils {
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
        System.out.println();
    }

}
