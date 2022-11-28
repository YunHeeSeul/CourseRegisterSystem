package Ex.Global;

import java.awt.*;

//상수 클래스
public class Constants {
    public static final long SERIAL_VERSION_UID = 1L; //long이라는 타입이라서 1L이라 하는 것. 롱은 8바이트고 int는 4바이트여서 남는 공간을 채워주기 위해 L을 적어주는 것

    public final static class CMainFrame { //메인프레임에서 쓰는 constants를 정의하는 클래스
        public final static int WIDTH = 1000;
        public final static int HEIGHT = 600;
        public final static int HGAP = 50;
        public final static int VGAP = 50;

    }

    public final static class CLoginDialog { //메인프레임에서 쓰는 constants를 정의하는 클래스
        public final static int WIDTH = 900;
        public final static int HEIGHT = 900;
        public final static int LOCATION_X = 178;
        public final static int LOCATION_Y = 0;

        public final static Color LAVENDAR = Color.getHSBColor((222f/360),0.14f, 0.87f);
        public final static Color NAVY = Color.getHSBColor((220f/360),0.65f, 0.42f);
    }
}
