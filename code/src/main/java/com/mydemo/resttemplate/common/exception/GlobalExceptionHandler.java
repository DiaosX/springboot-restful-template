package com.mydemo.resttemplate.common.exception;

import com.mydemo.resttemplate.common.base.BaseEnum;
import com.mydemo.resttemplate.common.base.BaseResp;
import com.mydemo.resttemplate.common.base.BaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 处理自定义的业务异常
     *
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = BaseException.class)
    @ResponseBody
    public BaseResp bizExceptionHandler(HttpServletRequest req, BaseException e) {
        logger.error("请求url:[{}],发生业务异常！原因是：{}", req.getRequestURI(), e.getErrMsg());
        return BaseResp.error(e.getErrCode(), e.getErrMsg());
    }

    /**
     * 处理空指针的异常
     *
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = NullPointerException.class)
    @ResponseBody
    public BaseResp exceptionHandler(HttpServletRequest req, NullPointerException e) {
        logger.error("请求url:[{}],发生空指针异常！原因是:[{}]", req.getRequestURI(), e);
        return BaseResp.error(BaseEnum.BODY_NOT_MATCH);
    }

    /**
     * 参数验证统一异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public BaseResp handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        logger.error(e.getMessage(), e);
        List<String> errorMsgList = new ArrayList<>();
        for (FieldError error : e.getBindingResult().getFieldErrors()) {
            errorMsgList.add(error.getDefaultMessage());
        }
        return BaseResp.error(String.join("|", errorMsgList));
    }

    /**
     * Validator 参数校验异常处理
     *
     * @param e 异常信息
     * @return
     */
    @ExceptionHandler(value = BindException.class)
    public BaseResp handleArgumentInValidException(BindException e) {
        List<String> errorMsgList = new ArrayList<>();
        for (FieldError error : e.getBindingResult().getFieldErrors()) {
            errorMsgList.add(error.getDefaultMessage());
        }
        return BaseResp.error(BaseEnum.PARAM_ERROR.getCode(), String.join("|", errorMsgList));
    }


    /**
     * 处理其他异常
     *
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public BaseResp exceptionHandler(HttpServletRequest req, Exception e) {
        logger.error("请求url:[{}],未知异常！原因是:[{}]", req.getRequestURI(), e);
        return BaseResp.error(BaseEnum.INTERNAL_SERVER_ERROR.getCode(), e.getMessage());
    }
}
