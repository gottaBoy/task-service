/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.Data.User
 *  SA.SRFDA.Web.Utility.GlobalHelperEx
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.CallParamList
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.Web.ButtonClickListener
 *  SA.SRFramework.Web.SRFImgButton
 *  SA.SRFramework.Web.SRFLiteral
 *  SA.SRFramework.Web.SRFPage
 *  SA.SRFramework.Web.SRFTextBox
 *  SA.SRFramework.Web.WebContext
 *  SA.SRFramework.WebEx.SRFExPage
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  javax.servlet.jsp.PageContext
 */
package SA.SRFDA.EAI.Web.Admin;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.Data.User;
import SA.SRFDA.Web.Utility.GlobalHelperEx;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.CallParamList;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.ButtonClickListener;
import SA.SRFramework.Web.SRFImgButton;
import SA.SRFramework.Web.SRFLiteral;
import SA.SRFramework.Web.SRFPage;
import SA.SRFramework.Web.SRFTextBox;
import SA.SRFramework.Web.WebContext;
import SA.SRFramework.WebEx.SRFExPage;
import SA.SRFramework.WebEx.SRFExWebContext;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.EventObject;
import java.util.Vector;
import javax.servlet.jsp.PageContext;

public class InternalLoginPage
extends SRFPage {
    SRFTextBox tbx_LoginName = null;
    SRFTextBox tbx_LoginPassword = null;
    SRFImgButton Btn_Login1 = null;
    SRFLiteral lit_InputError = null;
    private String url = "logindeal.jsp";

    protected void OnInitComponents() {
        this.lit_InputError = (SRFLiteral)this.FindControl("lit_InputError");
        this.tbx_LoginName = (SRFTextBox)this.FindControl("tbx_LoginName");
        this.tbx_LoginPassword = (SRFTextBox)this.FindControl("tbx_LoginPassword");
        this.Btn_Login1 = (SRFImgButton)this.FindControl("Btn_Login1");
        this.tbx_LoginPassword.setTextMode(2);
        this.tbx_LoginPassword.setCssClass("normalinput");
        this.tbx_LoginName.setCssClass("normalinput");
        this.Btn_Login1.addButtonClickListener((ButtonClickListener)this);
    }

    protected void OnLoad() {
    }

    public void OnButtonClick(EventObject eventObject) {
        if (eventObject.getSource() == this.Btn_Login1) {
            this.CheckUserLogin();
            return;
        }
    }

    protected void OnInit(PageContext context) {
    }

    protected WebContext CreateWebContext(PageContext context) {
        return WebContext.Current((PageContext)context);
    }

    private void CheckUserLogin() {
        String strLoginName = this.tbx_LoginName.getText();
        String strPassword = this.tbx_LoginPassword.getText();
        if (StringHelper.Length((String)strLoginName) == 0) {
            this.ShowPageError("\u767b\u5f55\u5e10\u6237\u4e0d\u80fd\u4e3a\u7a7a\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165");
            return;
        }
        if (StringHelper.Length((String)strPassword) == 0) {
            this.ShowPageError("\u767b\u5f55\u5bc6\u7801\u4e0d\u80fd\u4e3a\u7a7a\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165");
            return;
        }
        GlobalHelperEx globalHelperEx = (GlobalHelperEx)this.pageContext.getServletContext().getAttribute("SRFDACONTEXTHELPER");
        String strSQL = "select t1.* FROM T_SRFUSER t1 INNER JOIN T_SRFUSERLOGIN t2 ON t1.USERID=t2.USERID  where    UPPER(t2.USERLOGINNAME)= ? AND UPPER(t2.LoginPwd)= ? AND t2.USERMODE='EAI'  ";
        CallParamList callParamList = new CallParamList();
        callParamList.Add((Object)strLoginName.toUpperCase());
        callParamList.Add((Object)strPassword.toUpperCase());
        User user = new User();
        CallResult callResult = BaseDEDataCtrl.SelectSingle((ISRFDAGlobalHelper)globalHelperEx, (String)strSQL, (Vector)callParamList.GetList(), (BaseDataEntity)user);
        if (callResult.getRetCode() == 3) {
            this.ShowPageError("\u60a8\u8f93\u5165\u7684\u767b\u5f55\u5e10\u6237\u6216\u767b\u5f55\u5bc6\u7801\u6709\u8bef\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165\uff01");
            return;
        }
        if (callResult.IsError()) {
            this.ShowPageError("\u7cfb\u7edf\u53d1\u751f\u9519\u8bef\uff0c\u8bf7\u5411\u7ba1\u7406\u5458\u786e\u8ba4");
            return;
        }
        this.getWebContext().getPageContext().getSession().setAttribute("PERSONID", (Object)user.getUSERID());
        this.getWebContext().getPageContext().getSession().setAttribute("PERSONNAME", (Object)user.getUSERNAME());
        this.getWebContext().getPageContext().getSession().setAttribute("UESRMODE", (Object)"EAI");
        this.getWebContext().getPageContext().getSession().setAttribute("LOGINNAME", (Object)strLoginName);
        this.doRedirect(this.url);
    }

    protected static SRFExWebContext GetWebContext(String strWebContextObject, SRFExPage page) {
        Object obj;
        block8: {
            Method method;
            block7: {
                Class<?> cl;
                block6: {
                    try {
                        cl = Class.forName(strWebContextObject);
                        if (cl != null) break block6;
                        return null;
                    }
                    catch (Exception ex) {
                        page.PageLog((Object)page, 1, "\u65e0\u6cd5\u5efa\u7acb\u7f51\u9875\u4e0a\u4e0b\u6587\u5bf9\u8c61", (Throwable)ex);
                        return null;
                    }
                }
                Class[] paramTypes = new Class[]{SRFExPage.class};
                try {
                    method = cl.getMethod("Current", paramTypes);
                }
                catch (Exception exception) {
                    page.PageLog((Object)page, 1, "\u65e0\u6cd5\u5efa\u7acb\u7f51\u9875\u4e0a\u4e0b\u6587\u5bf9\u8c61", (Throwable)exception);
                    return null;
                }
                if (method != null) break block7;
                return null;
            }
            try {
                obj = method.invoke(null, page);
            }
            catch (Exception exception) {
                page.PageLog((Object)page, 1, "\u65e0\u6cd5\u5efa\u7acb\u7f51\u9875\u4e0a\u4e0b\u6587\u5bf9\u8c61", (Throwable)exception);
                return null;
            }
            if (obj != null) break block8;
            return null;
        }
        if (obj instanceof SRFExWebContext) {
            return (SRFExWebContext)obj;
        }
        return null;
    }

    private void ShowPageError(String strError) {
        this.lit_InputError.setText(strError);
    }

    private void doRedirect(String strUrl) {
        try {
            this.getResponse().sendRedirect(strUrl);
        }
        catch (IOException e) {
            try {
                this.getResponse().getWriter().write("\u8df3\u8f6c\u9875\u9762\u51fa\u9519");
            }
            catch (IOException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
    }
}

