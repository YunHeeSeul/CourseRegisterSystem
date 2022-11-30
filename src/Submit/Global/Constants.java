package Submit.Global;

import java.awt.*;

//��� Ŭ����
public class Constants {
    public static final long SERIAL_VERSION_UID = 1L; //long�̶�� Ÿ���̶� 1L�̶� �ϴ� ��. ���� 8����Ʈ�� int�� 4����Ʈ���� ���� ������ ä���ֱ� ���� L�� �����ִ� ��
    //��ư
    public final static int BUTTON_WIDTH = 100;
    public final static int BUTTON_HEIGHT = 50;

    //��
    public final static int LABEL_WIDTH = 50;
    public final static int LABEL_HEIGHT = 30;
    public final static int LABEL_COLUMNS = 10;

    //�׸� �÷�
    public final static Color LAVENDAR = Color.getHSBColor((222f/360),0.14f, 0.87f);
    public final static Color NAVY = Color.getHSBColor((220f/360),0.65f, 0.42f);

    //��Ʈ
    public final static String FONT1_NAME = "����";
    public final static int FONT1_SIZE = 30;
    public final static String FONT2_NAME = "serif";
    public final static int FONT2_SIZE = 15;

    //��� �г� size
    public final static int WIDTH = 900;
    public final static int HEIGHT = 900;

    //��� �г� ��ġ
    public final static int LOCATION_X = 178;
    public final static int LOCATION_Y = 0;

    //��� �г� layout
    public final static int LAYOUT_HGAP = 0;
    public final static int LAYOUT_WGAP = 10;

    //button �г�
    public final static int BUTTON_HGAP = 500;
    public final static int BUTTON_VGAP = 10;



    public final static class CMainFrame { //���������ӿ��� ���� constants�� �����ϴ� Ŭ����
        public final static int WIDTH = 1000;
        public final static int HEIGHT = 600;
        public final static int HGAP = 50;
        public final static int VGAP = 50;

    }

    public final static class CLoginDialog { //���������ӿ��� ���� constants�� �����ϴ� Ŭ����
        //�α��� �г�
        public final static int LOGIN_ROW = 2;
        public final static int LOGIN_COLUMN = 2;
        public final static int LOGIN_HGAP = 30;
        public final static int LOGIN_VGAP = 10;

        //inner �г�
        public final static int INNER_HGAP = 500;
        public final static int INNER_VGAP = 50;

        //button �г�
        public final static int BUTTON_ROW = 1;
        public final static int BUTTON_COLUMN = 2;
        public final static int BUTTON_HGAP = 50;
        public final static int BUTTON_VGAP = 10;

        //��Ʈ�� �г�
        public final static String INTRO_LABEL = "�������б� ������û�ý���";
    }

    public final static class CSignUPPanel{
        //signup �г�
        public final static int SIGNUP_ROW = 11;
        public final static int SIGNUP_COLUMN = 2;
        public final static int SIGNUP_HGAP = 50;
        public final static int SIGNUP_VGAP = 10;

        //inner �г�
        public final static int INNER_HGAP = 500;
        public final static int INNER_VGAP = 50;

        //���� ��
        public final static int STATUS_WIDTH = 80;
        public final static int STATUS_HEIGHT = 30;


        //��Ʈ�� �г�
        public final static String INTRO_LABEL = "�������б� �л� ���";

        //��ư
        public final static String CHECKBT = "�ߺ� Ȯ��";
        public final static int CHECKBT_WIDTH = 20;
        public final static int CHECKBT_HEIGHT = 30;
        public final static String SIGNUPBT = "���";
        public final static String CANCELBT = "���";
    }
    public final static class CImagePanel{
        public final static int X_POINT = 0;
        public final static int Y_POINT = 0;
    }
}
