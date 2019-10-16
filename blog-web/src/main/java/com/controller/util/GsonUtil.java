package com.controller.util;

import com.google.gson.Gson;
import com.google.gson.JsonNull;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;

@Controller
public class GsonUtil {
    //采取单例模式
    private static GsonUtil gsonUtil;
    private Gson gson = new Gson();

    @PostConstruct
    public void init() {
        gsonUtil = this;
    }

    /**
     * @param src :将要被转化的对象
     * @return :转化后的JSON串
     * @MethodName : toJson
     * @Description : 将对象转为JSON串，此方法能够满足大部分需求
     */
    public String toJson(Object src) {
        if (src == null) {
            return gson.toJson(JsonNull.INSTANCE);
        }
        return gson.toJson(src);
    }

}
