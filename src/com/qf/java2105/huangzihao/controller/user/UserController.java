package com.qf.java2105.huangzihao.controller.user;

import com.alibaba.fastjson.JSON;
import com.qf.java2105.huangzihao.constant.ResponseMessageConstant;
import com.qf.java2105.huangzihao.controller.BaseController;
import com.qf.java2105.huangzihao.entity.ResultVO;
import com.qf.java2105.huangzihao.factory.BeanFacotry;
import com.qf.java2105.huangzihao.pojo.User;
import com.qf.java2105.huangzihao.service.IUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户管理层模块
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/14.
 */
@WebServlet("/user")
public class UserController extends BaseController {
    
    private IUserService userService = (IUserService) BeanFacotry.getBean("userService");

    /**
     * 登录
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String inputVcode = request.getParameter("inputVcode");
        String vCode = (String) request.getSession().getAttribute("vCode");
        String destroy = request.getParameter("destroy");

        if (null != destroy && 1 == Integer.parseInt(destroy)) {
            request.getSession().removeAttribute("loginUser");
        }

        if (null == inputVcode || "".equals(inputVcode.trim()) || null == username || "".equals(username.trim())
                || null == password || "".equals(password.trim())) {
            // 如果传过来是空值，则回到登录页
            return ResponseMessageConstant.PREFIX_REDIRECT + request.getContextPath() + "/front/login.jsp";
        }

        if (!inputVcode.equalsIgnoreCase(vCode)) {
            // 如果验证不正确，则回到登录页
            return ResponseMessageConstant.PREFIX_REDIRECT + request.getContextPath() + "/front/login.jsp";
        }

        ResultVO<User> resultVO = userService.login(username, password);
        if (resultVO.getSuccess()) {
            User user = resultVO.getData();
            request.getSession().setAttribute("loginUser",user);
            return ResponseMessageConstant.PREFIX_REDIRECT + request.getContextPath() + "/front/index.jsp";
        } else {
            return ResponseMessageConstant.PREFIX_REDIRECT + request.getContextPath() + "/front/login.jsp";
        }
    }

    /**
     * 注册
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String nickname = request.getParameter("nickname");

        if (null == nickname || "".equals(nickname.trim()) || null == username || "".equals(username.trim())
                || null == password || "".equals(password.trim())) {
            // 如果传过来是空值，则回到注册页
            return ResponseMessageConstant.PREFIX_REDIRECT + request.getContextPath() + "/front/register.jsp";
        }
        
        User user = new User();
        user.setUsername(username);
        user.setNickname(nickname);
        user.setPassword(password);
        ResultVO<String> register = userService.register(user);
        if (register.getSuccess()) {
            return ResponseMessageConstant.PREFIX_REDIRECT + request.getContextPath() + "/front/login.jsp";
        } else {
            return ResponseMessageConstant.PREFIX_REDIRECT + request.getContextPath() + "/front/register.jsp";
        }

    }

    /**
     * 名字是否存在
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String exitisName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usernameVal = request.getParameter("usernameVal");
        ResultVO<String> resultVO = userService.exitisName(usernameVal);
        return JSON.toJSONString(resultVO);
    }
    
}
