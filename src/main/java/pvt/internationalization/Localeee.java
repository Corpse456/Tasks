package pvt.internationalization;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class Localeee {

    public static void main (String[] args) throws ParseException {
        Locale[] availableLocales = Locale.getAvailableLocales();
        for (int i = 0; i < availableLocales.length; i++) {
            System.out.println(availableLocales[i].getLanguage() + ": " + availableLocales[i].getDisplayLanguage());
        }
        Locale loc = Locale.getDefault();// new Locale("be", "BY");
        System.out.println(loc.getDisplayCountry());

        NumberFormat rubFormat = NumberFormat.getCurrencyInstance(loc);
        System.out.println(rubFormat.format(15000));

        NumberFormat numFormat = NumberFormat.getNumberInstance(loc);
        Number num = numFormat.parse("10,5");
        Double n = num.doubleValue();
        System.out.println(n);

        Date now = new Date();
        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, loc);

        System.out.println(df.format(now));
        Date idate = df.parse("17 января 2018 г.");
        System.out.println(idate);

        loc = Locale.ENGLISH;
        ResourceBundle rb = ResourceBundle.getBundle("MessagesBundle", loc);
        System.out.println(rb.getString("greetings"));
        System.out.println(rb.getString("user"));
        System.out.println(rb.getString("password"));
        System.out.println(rb.getString("rus"));
    }
}
