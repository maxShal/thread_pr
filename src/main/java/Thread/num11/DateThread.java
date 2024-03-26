package Thread.num11;

import java.util.Date;

public class DateThread extends Thread{

    Formatter formatter;
    Date date;

    DateThread(Formatter formatter, Date date)
    {
        this.formatter=formatter;
        this.date=date;
    }

    @Override
    public void run() {
       String result = formatter.format(date);
        System.out.println(result);
    }
}
