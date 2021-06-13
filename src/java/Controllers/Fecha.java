
package Controllers;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Fecha {
    
    public static Calendar calendar = Calendar.getInstance();
    private static String fecha;

    public Fecha() {
    }
    
    public static String Fecha(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        fecha = sdf.format(calendar.getTime());
        return fecha;
    }
    
    public static String FechaDB(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        fecha = sdf.format(calendar.getTime());
        return fecha;
    }
    
}
