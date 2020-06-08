package com.javasm.demo.entity;

/**
 */
public class ResultMap<T> {

    public static final String SUCCESS = "操作成功";
    public static final String FAILED = "操作失败";
    public static final int SUCCESSCODE = 200;
    public static final int FAILEDCODE = 500;
    //用来封装当前请求处理的结果是成功还是失败
    private String result;

    //要返回的数据
    private T data;

    //返回的状态码
    private int code;

    /**
     * 请求成功且不需要返回数据时使用的工具方法
     *
     * @param <Type>
     * @return
     */
    public static <Type> ResultMap<Type> successWithoutData() {
        return new ResultMap<Type>(SUCCESS, SUCCESSCODE,null );
    }

    /**
     * 请求失败
     * 错误码，错误分析
     * @param <Type>
     * @return
     */
    // TODO: 2020/6/5 获得准确的错误信息 
    public static <Type> ResultMap<Type> failed() {
        return new ResultMap<Type>(FAILED, FAILEDCODE,null );
    }

    /**
     * 请求处理成功且需要返回数据时使用的工具方法
     *
     * @param data   要返回的数据
     * @param <Type>
     * @return
     */
    public static <Type> ResultMap<Type> successWithData(Type data) {
        return new ResultMap<Type>(SUCCESS, SUCCESSCODE, data);
    }

    public ResultMap() {
    }

    public ResultMap(String result,int code,T data) {
        this.result = result;
        this.data = data;
        this.code=code;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
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
    @Override
    public String toString() {
        return "ResultMap{" +
                "result='" + result + '\'' +
                ", data=" + data +
                ", code=" + code +
                '}';
    }
}
