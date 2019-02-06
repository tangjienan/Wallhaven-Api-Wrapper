package model;

/**
 * Created by donezio on 1/26/19.
 */
public class Thumb {
    String id;

    String url;

    int width;

    int height;

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Thumb(int width, int height, String id, String url) {
        this.id = id;
        this.url = url;
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(id).append(" ").append(" URL: ").append(url).append(" Width: ").append(width).append(" Height: ").append(height);
        return sb.toString();
    }
}
