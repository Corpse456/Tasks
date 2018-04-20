package pvt.patterns.builder;

public class HTMLBuilder extends DocumentBuilder {
    @Override
    public void createHeader (String headerText) {
        text.append("<h1>");
        text.append(headerText);
        text.append("</h1>");
    }

    @Override
    public void createParagraph (String parText) {
        text.append("<p>");
        text.append(parText);
        text.append("</p>");
    }
}
