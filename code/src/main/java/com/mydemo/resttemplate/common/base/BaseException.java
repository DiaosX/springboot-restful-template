package com.mydemo.resttemplate.common.base;

public class BaseException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * 错误码
     */
    protected String errCode;
    /**
     * 错误信息
     */
    protected String errMsg;

    public BaseException() {
        super();
    }

    public BaseException(IBaseEnum error) {
        super(error.getCode());
        this.errCode = error.getCode();
        this.errMsg = error.getMsg();
    }

    public BaseException(IBaseEnum error, Throwable cause) {
        super(error.getCode(), cause);
        this.errCode = error.getCode();
        this.errMsg = error.getMsg();
    }

    public BaseException(String errMsg) {
        super(errMsg);
        this.errMsg = errMsg;
    }

    public BaseException(String errCode, String errMsg) {
        super(errCode);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public BaseException(String errCode, String errMsg, Throwable cause) {
        super(errCode, cause);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }


    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}
