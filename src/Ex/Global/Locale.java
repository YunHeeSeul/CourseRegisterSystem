package Ex.Global;

public class Locale {
    public final static String TIME_FORMAT = "yyyy-MM-dd hh:mm";
    public final static String OK_LABEL = "확인";
    public final static String CANEL_LABEL = "취소";
    public final static int COLUMN = 10;
    public final static String WRONG = "wrong";
    public final static String NONE = "none";
    public final static String CORRECT = "correct";

    public final static String EXIT_SYSTEM_MESSAGE = "수강 신청 시스템을 종료하시겠습니까?";

    //PAccountPanel
    public final static class LAccountPanel{
        public final static String INSA_POSTFIX = "님 안녕하세요! ";//값을 한 번 할당하고 나면 바뀌지 않는 다는 것 : final
        public final static String LOGIN_TIME_PREFIX = "로그인 시간은 ";
        public final static String IPNIDA = "입니다. ";
    }


    //PLoginDialog
    public final static class LLoginDialog{
        public final static String ID_LABEL = "ID";
        public final static String PW_LABEL = "PW";
        public final static String LOGIN_BUTTON = "Login";
        public final static String SIGNUP_BUTTON = "SignUP";
        public final static String WRONG_LOGIN_MESSAGE = "아이디나 비밀번호를 잘못 입력하셨습니다.\n로그인을 다시 시도하시겠습니까?";
        public final static String WRONG_LOGIN_TITLE = "로그인";

        public final static String NONE_LOGIN_MESSAGE = "존재하지 않는 계정입니다.\n계정 생성 하시겠습니까?";
        public final static String NONE_LOGIN_TITLE = "로그인";

        public final static String CORRECT_LOGIN_MESSAGE = "존재하지 않는 계정입니다.\n계정 생성 하시겠습니까?";
        public final static String CORRECT_LOGIN_TITLE = "로그인";
    }
}
