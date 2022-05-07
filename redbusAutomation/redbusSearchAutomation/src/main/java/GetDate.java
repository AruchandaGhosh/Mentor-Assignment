
import java.text.*;
import java.util.*;

public class GetDate {

    public static String date(){

        Date date = new Date();
        SimpleDateFormat DateFor = new SimpleDateFormat(" E_DD_Mon_YYYY_hh_mm_ss_a");
        String stringDate= DateFor.format(date);
        return stringDate;

    }

}
