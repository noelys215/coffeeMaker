import java.util.Date;
import java.util.Optional;

public class Main {


    public static void main(String[] args) {
        System.out.println(Physics.ELECTRON_MASS); // 9.1093837E-31
        System.out.println(Physics.SPEED_OF_LIGHT); // 299792458


    }
}

class Physics {

    /**
     * The speed of light in a vacuum (m/s)
     */
    public static final long SPEED_OF_LIGHT = 299_792_458;

    /**
     * Electron mass (kg)
     */
    public static final double ELECTRON_MASS = 9.1093837e-31;
}
