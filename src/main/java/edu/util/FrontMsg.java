package edu.util;

public class FrontMsg {
    private static final long serialVersionUID=115118687516227601L;
    private int msg_code;
    private String msg_url;

    private int element_code;
    private int state_code;

    public FrontMsg(){
        msg_code=0;
        element_code=0;
        state_code=0;
        msg_url="";
    }
    public FrontMsg(int ecode, int scode){
        msg_code=0;
        element_code=ecode;
        state_code=scode;
        msg_url="";
    }

    public int getMsg_code() {
        return msg_code;
    }

    public void setMsg_code(int msg_code) {
        this.msg_code = msg_code;
    }

    public String getMsg_url() {
        return msg_url;
    }

    public void setMsg_url(String msg_url) {
        this.msg_url = msg_url;
    }

    public int getElement_code() {
        return element_code;
    }

    public void setElement_code(int element_code) {
        this.element_code = element_code;
    }

    public int getState_code() {
        return state_code;
    }

    public void setState_code(int state_code) {
        this.state_code = state_code;
    }

    @Override
    public String toString() {
        return "{" +
                "msg_code:" + msg_code +
                ", msg_url:'" + msg_url + '\'' +
                ", element_code:" + element_code +
                ", state_code:" + state_code +
                '}';
    }
}
