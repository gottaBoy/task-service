/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.Web.ButtonClickListener
 *  SA.SRFramework.Web.SRFImgButton
 *  SA.SRFramework.Web.SRFLiteral
 *  SA.SRFramework.Web.SRFPage
 *  SA.SRFramework.Web.SRFTextBox
 *  SA.SRFramework.Web.WebContext
 *  javax.servlet.jsp.PageContext
 */
package SALicServer.Web;

import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.ButtonClickListener;
import SA.SRFramework.Web.SRFImgButton;
import SA.SRFramework.Web.SRFLiteral;
import SA.SRFramework.Web.SRFPage;
import SA.SRFramework.Web.SRFTextBox;
import SA.SRFramework.Web.WebContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.EventObject;
import java.util.Properties;
import javax.servlet.jsp.PageContext;

public class LicServerLoginPage
extends SRFPage {
    SRFTextBox tbx_LoginName = null;
    SRFTextBox tbx_LoginPassword = null;
    SRFImgButton Btn_Login1 = null;
    SRFLiteral lit_InputError = null;
    private static String SRFADMINID = "userid";
    private static String SRFADMINNAME = "username";
    private static String SRFADMINPWD = "userpwd";
    private static String DEFAULTRU = "../licadmin/uploadsrflic.jsp";
    private BaseDataEntity userInfo = new BaseDataEntity();

    protected void OnInitComponents() {
        super.OnInitComponents();
        this.lit_InputError = (SRFLiteral)this.FindControl("lit_InputError");
        this.tbx_LoginName = (SRFTextBox)this.FindControl("tbx_LoginName");
        this.tbx_LoginPassword = (SRFTextBox)this.FindControl("tbx_LoginPassword");
        this.Btn_Login1 = (SRFImgButton)this.FindControl("Btn_Login1");
        this.tbx_LoginPassword.setTextMode(2);
        this.tbx_LoginPassword.setCssClass("normalinput");
        this.tbx_LoginName.setCssClass("normalinput");
        this.Btn_Login1.addButtonClickListener((ButtonClickListener)this);
    }

    public void OnButtonClick(EventObject eventObject) {
        if (eventObject.getSource() == this.Btn_Login1) {
            this.CheckUserLogin();
            return;
        }
    }

    protected WebContext CreateWebContext(PageContext context) {
        return WebContext.Current((PageContext)context);
    }

    private boolean IsLoginMsgOK(String strUserName, String strUserPWD) {
        if (StringHelper.IsNullOrEmpty((String)strUserName) || StringHelper.IsNullOrEmpty((String)strUserPWD)) {
            return false;
        }
        String strConfig = this.pageContext.getServletContext().getRealPath("/WEB-INF/srflic/srflic.properties");
        if (StringHelper.IsNullOrEmpty((String)strConfig)) {
            return false;
        }
        Properties properties = new Properties();
        try {
            FileInputStream fis = new FileInputStream(new File(strConfig));
            properties.load(fis);
            String strAdminName = properties.getProperty(SRFADMINNAME);
            String strAdminPWD = properties.getProperty(SRFADMINPWD);
            String strAdminId = properties.getProperty(SRFADMINID);
            if (StringHelper.Compare((String)strAdminName, (String)strUserName, (boolean)true) == 0 && StringHelper.Compare((String)strAdminPWD, (String)strUserPWD, (boolean)true) == 0) {
                this.userInfo.SetParamValue("PERSONID", (Object)strAdminId);
                this.userInfo.SetParamValue("UESRNAME", (Object)strAdminName);
                return true;
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void CheckUserLogin() {
        String strLoginName = this.tbx_LoginName.getText();
        String strPassword = this.tbx_LoginPassword.getText();
        if (StringHelper.Length((String)strLoginName) == 0) {
            this.ShowPageError("\u7528\u6237\u540d\u4e0d\u80fd\u4e3a\u7a7a\uff0c\u8bf7\u8f93\u5165\uff01");
            return;
        }
        if (StringHelper.Length((String)strPassword) == 0) {
            this.ShowPageError("\u5bc6\u7801\u4e0d\u80fd\u4e3a\u7a7a\uff0c\u8bf7\u8f93\u5165\uff01");
            return;
        }
        if (!this.IsLoginMsgOK(strLoginName, strPassword)) {
            this.ShowPageError("\u7528\u6237\u540d\u6216\u5bc6\u7801\u9519\u8bef\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165\uff01");
            return;
        }
        this.getWebContext().Logout();
        this.getWebContext().setCurUserId(this.userInfo.GetParamStringValue("PERSONID", ""));
        this.getWebContext().setCurUserName(strLoginName);
        this.getWebContext().getPageContext().getSession().setAttribute("PERSONNAME", (Object)strLoginName);
        try {
            this.getResponse().sendRedirect(this.GetRU());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String GetRU() {
        String strRU = this.getWebContext().GetParamValue("RU");
        if (StringHelper.IsNullOrEmpty((String)strRU)) {
            strRU = DEFAULTRU;
        }
        return strRU;
    }

    private void ShowPageError(String strError) {
        this.lit_InputError.setText(strError);
    }
}

