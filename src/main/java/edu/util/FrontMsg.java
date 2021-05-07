package edu.util;

public class FrontMsg {
    private static final long serialVersionUID=115118687516227601L;
    private String msg_content;
    private int msg_code;
    private String msg_url;

    public String getMsg_content() {
        return msg_content;
    }

    public void setMsg_content(String msg_content) {
        this.msg_content = msg_content;
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

    @Override
    public String toString() {
        return "{" +
                "msg_content:'" + msg_content + '\'' +
                ", msg_code:" + msg_code +
                ", msg_url:'" + msg_url + '\'' +
                '}';
    }
}
