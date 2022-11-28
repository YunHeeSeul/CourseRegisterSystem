package Ex.Global;

import java.awt.*;

//��� Ŭ����
public class Constants {
    public static final long SERIAL_VERSION_UID = 1L; //long�̶�� Ÿ���̶� 1L�̶� �ϴ� ��. ���� 8����Ʈ�� int�� 4����Ʈ���� ���� ������ ä���ֱ� ���� L�� �����ִ� ��

    public final static class CMainFrame { //���������ӿ��� ���� constants�� �����ϴ� Ŭ����
        public final static int WIDTH = 1000;
        public final static int HEIGHT = 600;
        public final static int HGAP = 50;
        public final static int VGAP = 50;

    }

    public final static class CLoginDialog { //���������ӿ��� ���� constants�� �����ϴ� Ŭ����
        public final static int WIDTH = 900;
        public final static int HEIGHT = 900;
        public final static int LOCATION_X = 178;
        public final static int LOCATION_Y = 0;

        public final static Color LAVENDAR = Color.getHSBColor((222f/360),0.14f, 0.87f);
        public final static Color NAVY = Color.getHSBColor((220f/360),0.65f, 0.42f);
    }
}
