package classes;

public class CreateUrl {
    public final static String baseuri = "https://simple-books-api.glitch.me";

    public static String getbaseuri()
    {
        return baseuri;
    }

    public static String getbaseuri(String resource)
    {
        return baseuri + resource;
    }
}
