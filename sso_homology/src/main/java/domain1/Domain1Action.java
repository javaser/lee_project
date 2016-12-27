package domain1;

import com.opensymphony.xwork2.ActionSupport;
import lee.sso.util.SSOCheck;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Lee
 * @since 2016/12/27
 */
public class Domain1Action extends ActionSupport {

    private String gotoUrl;

    public String main() {
        HttpServletRequest request = ServletActionContext.getRequest();
        if (SSOCheck.checkCookie(request)) {
            return SUCCESS;
        }
        gotoUrl = "/domain1/main.action";
        return LOGIN;
    }

    public String getGotoUrl() {
        return gotoUrl;
    }

    public void setGotoUrl(String gotoUrl) {
        this.gotoUrl = gotoUrl;
    }
}
