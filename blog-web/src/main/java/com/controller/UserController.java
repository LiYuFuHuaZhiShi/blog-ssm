package com.controller;

import com.entity.Article;
import com.entity.User;
import com.service.ArticleService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 对用户进行操作
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private ArticleService articleService;


    /*//跳转主页--AticleController
    @RequestMapping(value = "/user_toindex.action")
    public String usertoIndex(){
        return "index";
    }*/

    //跳转登陆界面
    @RequestMapping(value = "/user_tologin.action")
    public String usertoLogin() {
        return "WEB-INF/user/login";
    }

    //跳转注册界面
    @RequestMapping(value = "/user_torequest.action")
    public String usertoRequest() {
        return "WEB-INF/user/request";
    }

    //用户注册
    @RequestMapping(value = "/user_request.action")
    public String userRequest(String username, String password, String grade, MultipartFile head_pic, Model model) {
        User user = userService.addUser(username, password, grade, head_pic);//将用户保存进数据库
        if (user != null)//注册成功
            return "WEB-INF/user/login";
        else {//失败
            model.addAttribute("error", "此用户已被注册，请重新输入");
            return "WEB-INF/user/request";
        }
    }

    //用户登陆
    @RequestMapping(value = "/user_login.action", method = RequestMethod.POST)
    public String userLogin(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("grade") String grade, Model model, HttpSession session) {
        User user = userService.checkLogin(username, password, grade);
        if (user != null) {//成功
            session.setAttribute("user", user);//将用户放入session
            return "redirect:index.action";
        }
        model.addAttribute("error", "无此用户，请重新登录");
        return "WEB-INF/user/login";
    }

    //退出登陆
    @RequestMapping(value = "/logout.action")
    public String logout(HttpSession session) {
        //清除session
        session.invalidate();
        //重定向到登陆界面的跳转方法
        return "redirect:user_tologin.action";
    }


    //到用户详情界面
    @RequestMapping(value = "/toUser.action")
    public String toUser(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        //通过用户id查找到此用户的所有帖子
        List<Article> articleList = articleService.selectArticleByUid(user.getUid());
        model.addAttribute("articleList", articleList);
        return "WEB-INF/user/user";
    }


    //修改用户资料
    @RequestMapping(value = "/updateUser.action")
    public String updateUser(HttpSession session, String username, MultipartFile head_pic, Model model) {
        User user = (User) session.getAttribute("user");
        //修改用户名和头像
        User user1 = userService.updateUser(user, username, head_pic);
        model.addAttribute("user", user1);
        return "WEB-INF/user/user";
    }


}
