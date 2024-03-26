package Thread.num11;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Formatter
{
    private  ThreadLocal<SimpleDateFormat> formatter; //= ThreadLocal.withInitial(()->new SimpleDateFormat("dd-MM-yyyy"));

    public Formatter(String string) {
        formatter = ThreadLocal.withInitial(()->new SimpleDateFormat(string));
    }

    public String format(Date date)
    {
        return formatter.get().format(date);
    }

}
