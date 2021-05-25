package edu.util;

import java.util.List;

/**
 * The pattern of code is X{aaa}{bbb}
 * X represents for type
 * aaa is the element contended
 * bbb is the digit code
 * */

public class UserParameters {
    public static final int MSG_CODE_INPUT_OK = 6100001;
    public static final int MSG_CODE_INPUT_REPEAT = 6100002;
    public static final int MSG_CODE_INPUT_ERROR = 6100003;
    public static final int MSG_CODE_INPUT_TIME_OUT = 6100004;

    public static final int MSG_CODE_INPUT_USERNAME = 1100001;
    public static final int MSG_CODE_INPUT_USER_PWD = 1100002;
    public static final int MSG_CODE_INPUT_DYNAMIC_CODE = 1100003;
    public static final int MSG_CODE_INPUT_EMAIL = 1100004;
    public static final int MSG_CODE_INPUT_TELEPHONE = 1100005;
    public static final int MSG_CODE_INPUT_STUDY_ID = 1100006;
    public static final int MSG_CODE_INPUT_GENDER = 1100007;
    public static final int MSG_CODE_INPUT_AGE = 1100008;
    public static final int MSG_CODE_INPUT_SOCIETY_ID = 1100009;

    public static final int MSG_CODE_STATE_SESSION = 2200001;
    public static final int MSG_CODE_STATE_OK = 2001001;
    public static final int MSG_CODE_STATE_TIME_OUT = 2001002;
    public static final int MSG_CODE_STATE_FAIL = 2001003;
    public static final int MSG_CODE_STATE_ERROR = 2001004;

    public static final int MSG_CODE_RECORD_RESULT_SINGLE = 3001001;
    public static final int MSG_CODE_RECORD_RESULT_MULTI = 3001002;

    public static final int MSG_CODE_REQUEST_SUCCESS = 3002001;
    public static final int MSG_CODE_REQUEST_FAIL = 3002002;
    public static final int MSG_CODE_REQUEST_NO_RECORD = 3002003;
    public static final int MSG_CODE_REQUEST_ERROR = 3002004;

    public static final int MSG_CODE_REQUEST_LOG_IN = 4001001;
    public static final int MSG_CODE_REQUEST_REGISTER = 4001002;
    public static final int MSG_CODE_REQUEST_DELETE = 4001003;
    public static final int MSG_CODE_REQUEST_SELECT = 4001004;
    public static final int MSG_CODE_REQUEST_UPDATE = 4001005;
    public static final int MSG_CODE_REQUEST_INSERT = 4001006;
    public static final String[] inputList=
            {"","USERNAME","PASSWORD","DYNAMIC_CODE","EMAIL",
                    "TELEPHONE","STUDY_ID","GENDER","AGE","SOCIETY_ID"};;

    public static String generateJSON(List<FrontMsg> msg_list){
        StringBuilder json = new StringBuilder();

        json.append("{");
        boolean comma_flag=false;
        int code_flag=0;
        StringBuilder content = new StringBuilder();

        for (FrontMsg element:msg_list) {
            if (content.length()>0)
                content.append(",");

            UserParameters.parseCode(element.getElement_code(),element.getState_code(), json,content,comma_flag);
            comma_flag=true;

            code_flag+=(element.getState_code() == MSG_CODE_INPUT_OK || element.getState_code() == MSG_CODE_REQUEST_SUCCESS)?0:1;
        }

        json.append(",msg_code:");
        json.append((code_flag<1)?200:606);
        json.append(",msg_content: \'");
        if (content.length()>0){
            json.append("error_inputs_list: ");
            json.append(content.toString());
        }
        json.append("\'");
        json.append("}");
        return json.toString();
    }

    private static void parseCode(int ecode, int scode, StringBuilder ret, StringBuilder cont, boolean separate){
        INPUT_TYPE element=INPUT_TYPE.NONE;
        boolean Error_flag=false;
        if (separate)
            ret.append(",");
        switch (ecode){
            case MSG_CODE_INPUT_USERNAME:element=INPUT_TYPE.USERNAME;ret.append(inputList[element.ordinal()].toLowerCase());break;
            case MSG_CODE_INPUT_USER_PWD:element=INPUT_TYPE.PASSWORD;ret.append(inputList[element.ordinal()].toLowerCase());break;
            case MSG_CODE_INPUT_DYNAMIC_CODE:element=INPUT_TYPE.DYNAMIC_CODE;ret.append(inputList[element.ordinal()].toLowerCase());break;
            case MSG_CODE_INPUT_EMAIL:element=INPUT_TYPE.EMAIL;ret.append(inputList[element.ordinal()].toLowerCase());break;
            case MSG_CODE_INPUT_TELEPHONE:element=INPUT_TYPE.TELEPHONE;ret.append(inputList[element.ordinal()].toLowerCase());break;
            case MSG_CODE_INPUT_GENDER:element=INPUT_TYPE.GENDER;ret.append(inputList[element.ordinal()].toLowerCase());break;
            case MSG_CODE_INPUT_STUDY_ID:element=INPUT_TYPE.STUDY_ID;ret.append(inputList[element.ordinal()].toLowerCase());break;
            case MSG_CODE_INPUT_SOCIETY_ID:element=INPUT_TYPE.SOCIETY_ID;ret.append(inputList[element.ordinal()].toLowerCase());break;
            case MSG_CODE_INPUT_AGE:element=INPUT_TYPE.AGE;ret.append(inputList[element.ordinal()].toLowerCase());break;
            case MSG_CODE_REQUEST_LOG_IN:ret.append("logIn");element=INPUT_TYPE.USERNAME;break;
            default:ret.append("exception");element=INPUT_TYPE.NONE;break;
        }
        ret.append(":");
        switch (scode){
            case MSG_CODE_INPUT_OK:ret.append("\'is checked\'");break;
            case MSG_CODE_REQUEST_SUCCESS:ret.append("\'is OK\'");break;
            case MSG_CODE_INPUT_REPEAT:ret.append("\'is occupied\'");Error_flag=true;break;
            case MSG_CODE_INPUT_ERROR:ret.append("\'is ERROR\'");Error_flag=true;break;
            case MSG_CODE_INPUT_TIME_OUT:ret.append("\'is TIME out\'");Error_flag=true;break;
            case MSG_CODE_REQUEST_NO_RECORD:ret.append("\'is NO exist\'");Error_flag=true;break;
            default:ret.append("\' exception \'");
        }
        cont.append(Error_flag?inputList[element.ordinal()].toLowerCase():"");
    }

public enum INPUT_TYPE {NONE,USERNAME,PASSWORD,DYNAMIC_CODE,EMAIL,TELEPHONE,STUDY_ID,GENDER,AGE,SOCIETY_ID}

}
