package cn.dr.util;

public class ResultInfo<T> {
    private T data;   //返回对象
    private int code; //状态码
    private String msg;//返回信息

    public ResultInfo(T data, int code, String msg) {
        this.data = data;
        this.code = code;
        this.msg = msg;
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
