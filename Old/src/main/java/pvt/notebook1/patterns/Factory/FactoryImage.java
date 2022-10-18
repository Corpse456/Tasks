package pvt.notebook1.patterns.Factory;

public class FactoryImage {

    public static FactoryImage createImage (String ext) {
        if (ext.equals("gif")) return new GifImage();
        else if (ext.equals("bmp")) return new BmpImage();
        return null;
    }
}
