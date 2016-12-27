package lee.sso.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Lee
 * @since 2016/12/27
 */
public class SSOCheck {
    public static final String USERNAME = "user";
    public static final String PASSWORD = "123";

    public static boolean checkLogin(String username, String password) {
        return username.equals(USERNAME) && password.equals(PASSWORD) ? true
                : false;
    }

    /**
     * 实际开发时应放在拦截器，此处为了方便
     *
     * @param request
     * @return
     */
    public static boolean checkCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("ssocookie") && cookie.getValue()
                        .equals("sso"))
                    return true;
            }
        }
        return false;
    }
}
