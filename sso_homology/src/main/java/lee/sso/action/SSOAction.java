package lee.sso.action;

import com.opensymphony.xwork2.ActionSupport;
import lee.sso.util.SSOCheck;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Lee
 * @since 2016/12/27
 */
public class SSOAction extends ActionSupport {

    private String username;
    private String password;
    private String gotoUrl;

    public String doLogin() {
        /*
        此处不进行数据用户数据验证，
        只关注 sso
         */
        boolean ok = SSOCheck.checkLogin(username, password);
        if (ok) {
            /*
            此处 cookie 值应为加密后的值，此处亦省去
             */
            Cookie cookie = new Cookie("ssocookie", "sso");
            cookie.setPath("/");
            HttpServletResponse response = ServletActionContext.getResponse();
            response.addCookie(cookie);
            return SUCCESS;
        }
        // 失败此处不做处理，或者返回登录页面
        return null;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGotoUrl() {
        return gotoUrl;
    }

    public void setGotoUrl(String gotoUrl) {
        this.gotoUrl = gotoUrl;
    }
}
