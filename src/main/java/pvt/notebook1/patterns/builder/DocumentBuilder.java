package pvt.notebook1.patterns.builder;

public abstract class DocumentBuilder {

    StringBuilder text = new StringBuilder();

    public abstract void createHeader (String headerText);

    public abstract void createParagraph (String parText);

    public String getText () {
        return text.toString();
    }
}
