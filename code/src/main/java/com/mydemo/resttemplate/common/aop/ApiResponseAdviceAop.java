package com.mydemo.resttemplate.common.aop;


/**
 * 对API结果改写拦截器
 */
//@Configuration
//@Aspect
public class ApiResponseAdviceAop {

//    @Pointcut("execution(public * com.mydemo.resttemplate.controller..*(..))")
//    public void httpResponse() {
//    }
//
//    /**
//     * 环切
//     */
//    @Around("httpResponse()")
//    public ApiResponseT handlerController(ProceedingJoinPoint proceedingJoinPoint) {
//        ApiResponseT apiResponse = new ApiResponseT();
//        try {
//            //获取方法的执行结果
//            Object proceed = proceedingJoinPoint.proceed();
//            //如果方法的执行结果是ReturnVO，则将该对象直接返回
//            if (proceed instanceof ApiResponseT) {
//                return (ApiResponseT) proceed;
//            }
//            apiResponse.setData(proceed);
//            apiResponse.setSuccess(true);
//
//        } catch (BizException ex) {
//            apiResponse.setErrMsg(ex.getErrorMsg());
//            apiResponse.setCode(ex.getErrorCode());
//            apiResponse.setSuccess(false);
//
//        } catch (Throwable throwable) {
//            apiResponse.setSuccess(false);
//            apiResponse.setErrMsg(throwable.getMessage());
//            apiResponse.setCode(CommonEnum.INTERNAL_SERVER_ERROR.getCode());
//        }
//        return apiResponse;
//    }
}
