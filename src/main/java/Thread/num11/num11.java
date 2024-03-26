package Thread.num11;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class num11 {
    public static void main(String[] args) throws InterruptedException {
        Date date1=new Date(103, Calendar.JANUARY,1);
        Date date2=new Date(105, Calendar.APRIL,2);
        Date date3=new Date(99, Calendar.DECEMBER,15);
        Date date4=new Date(100, Calendar.AUGUST,20);
        Date date5=new Date(124, Calendar.JULY,30);
        Formatter f=new Formatter("dd.MM.yyyy");
        DateThread dateThread1=new DateThread(f, date1);
        DateThread dateThread2=new DateThread(f, date2);
        DateThread dateThread3=new DateThread(f, date3);
        DateThread dateThread4=new DateThread(f, date4);
        DateThread dateThread5=new DateThread(f, date5);
        dateThread1.start();
        dateThread2.start();
        dateThread3.start();
        dateThread4.start();
        dateThread5.start();
        dateThread1.join();
        dateThread2.join();
        dateThread3.join();
        dateThread4.join();
        dateThread5.join();
    }
}
