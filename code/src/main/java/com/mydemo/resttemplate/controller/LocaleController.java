package com.mydemo.resttemplate.controller;

import com.mydemo.resttemplate.common.util.I18nUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author yst
 * @Description 国际化测试接口
 * @Date 2022/7/2 21:46
 * @Version 1.0
 */
@RestController
@RequestMapping("/locale")
public class LocaleController extends BaseController {
    public LocaleController() {

    }

    /**
     * 测试单个参数
     */
    @GetMapping(value = "/getWelcomeTip", produces = "application/json")
    public String getWelcomeTip(@RequestParam("name") String name) {
        return I18nUtil.get("user_welcome_tip", name);
    }

    /**
     * 测试多个参数
     */
    @GetMapping(value = "/getUserProfile", produces = "application/json")
    public String getUserProfile(@RequestParam("name") String name) {
        return I18nUtil.get("user_locale_profile", name, 100);
    }
}
