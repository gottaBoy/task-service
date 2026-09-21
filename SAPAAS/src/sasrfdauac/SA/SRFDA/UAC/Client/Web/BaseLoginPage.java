/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.Data.LoginLog
 *  SA.SRFDA.Ctrl.Data.OnlineUser
 *  SA.SRFDA.Ctrl.Data.User
 *  SA.SRFDA.Ctrl.IDASubSystemHelper
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.SRFDAPage
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.DateParser
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.UAC.Client.Web;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.Data.LoginLog;
import SA.SRFDA.Ctrl.Data.OnlineUser;
import SA.SRFDA.Ctrl.Data.User;
import SA.SRFDA.Ctrl.IDASubSystemHelper;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.DateParser;
import SA.SRFramework.Utility.StringHelper;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.TimeZone;

public abstract class BaseLoginPage
extends SRFDAPage {
    private static final String QUERYSQL = "select t1.*,t2.LOGINACCOUNTID,t2.USERMODEID from T_SRFUSER t1  INNER JOIN T_SRFLOGINACCOUNT t2 On t2.USERID = t1.USERID  WHERE UPPER(t2.LOGINACCOUNTNAME) = '%1$s'  ";
    private static final String QUERYSQL2 = "select t1.*,t2.LOGINACCOUNTID,t2.USERMODEID,t2.LANGUAGE from T_SRFUSER t1  INNER JOIN T_SRFLOGINACCOUNT t2 On t2.USERID = t1.USERID  WHERE UPPER(t2.LOGINACCOUNTNAME) = '%1$s' ";
    private static final String QUERYSQL3 = "select t1.*,t2.LOGINACCOUNTID,t2.USERMODEID,t2.LANGUAGE,t2.APPUITHEME,t2.ISENABLE from T_SRFUSER t1  INNER JOIN T_SRFLOGINACCOUNT t2 On t2.USERID = t1.USERID  WHERE UPPER(t2.LOGINACCOUNTNAME) = '%1$s'  ";
    protected static IDEDataCtrl loginLogDataCtrl = null;
    protected static IDEDataCtrl onlineUserDataCtrl = null;
    protected String strServerPath = "";
    protected String strHostId = "";

    public BaseLoginPage() {
        this.setMainPage(true);
        this.setOutputDebug(false);
    }

    protected CallResult OnLoginUserName(String strLoginName) {
        TimeZone tz;
        CallResult callResult = new CallResult();
        this.getWebContext().Logout();
        User user = new User();
        String strSQL = "";
        int nDAModelVersion = this.getWebContext().getGlobalHelper().getDAModelVersion();
        strSQL = nDAModelVersion >= 10100600 ? QUERYSQL3 : (nDAModelVersion >= 10072000 ? QUERYSQL2 : QUERYSQL);
        callResult = BaseDEDataCtrl.SelectSingle((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), (String)StringHelper.Format((String)strSQL, (Object)strLoginName.toUpperCase()), (BaseDataEntity)user);
        if (callResult.IsError()) {
            callResult.setRetCode(1);
            callResult.setErrorInfo("\u7528\u6237\u767b\u5f55\u5e10\u6237\u4e0d\u5b58\u5728\uff0c\u65e0\u6cd5\u767b\u5165\u7cfb\u7edf");
            return callResult;
        }
        String strEnable = user.GetParamStringValue("ISENABLE", "1");
        if (StringHelper.Compare((String)strEnable, (String)"1", (boolean)true) != 0) {
            callResult.setRetCode(1);
            callResult.setErrorInfo("\u7528\u6237\u767b\u5f55\u5e10\u6237\u5df2\u7ecf\u88ab\u7981\u7528\uff0c\u65e0\u6cd5\u767b\u5165\u7cfb\u7edf");
            return callResult;
        }
        this.getWebContext().Logout();
        this.getWebContext().setCurUserId(user.getUSERID());
        this.getWebContext().setCurUserName(user.getUSERNAME());
        this.getWebContext().setCurUserMode(user.GetParamStringValue("USERMODEID", "DEFAULT"));
        this.getWebContext().setLocalization(user.GetParamStringValue("LANGUAGE", ""));
        this.getWebContext().setCurAppUITheme(user.GetParamStringValue("APPUITHEME", ""));
        this.getWebContext().setCurLoginName(strLoginName);
        this.getWebContext().SetSessionValue("LOGINACCOUNTID", (Object)user.GetParamStringValue("LOGINACCOUNTID", ""));
        this.getWebContext().setCurOrgUnitId("ORG_DEFAULT");
        String strTimeZone = user.getTIMEZONE();
        if (!StringHelper.IsNullOrEmpty((String)strTimeZone) && (tz = TimeZone.getTimeZone(strTimeZone)) != null) {
            this.getWebContext().setCurTimeZone(tz);
        }
        this.getWebContext().GetUserQueryModelStorage();
        this.OnPrepareSubSystem();
        this.getWebContext().Logon();
        if (nDAModelVersion >= 10113000) {
            IDEDataCtrl iDataCtrl = this.GetLoginLogDataCtrl();
            if (iDataCtrl != null) {
                LoginLog loginLog = new LoginLog();
                BaseDEDataCtrl.SetCallParamCheckKey((BaseDataEntity)loginLog, (boolean)false);
                BaseDEDataCtrl.SetCallParamRetData((BaseDataEntity)loginLog, (boolean)false);
                loginLog.setLOGINLOGID(this.getWebContext().getSessionId());
                loginLog.setLOGINLOGNAME(strLoginName);
                loginLog.setIPADDRESS(this.getWebContext().getRemoteAddr());
                loginLog.setLOGINACCOUNTID(user.GetParamStringValue("LOGINACCOUNTID", ""));
                loginLog.setSERVERADDR(this.GetServerPath());
                loginLog.SetParamValue("LOGINTIME", (Object)DateParser.GetCurTime());
                iDataCtrl.Save(true, (BaseDataEntity)loginLog);
            }
            if ((iDataCtrl = this.GetOnlineUserDataCtrl()) != null) {
                OnlineUser onlineUser = new OnlineUser();
                BaseDEDataCtrl.SetCallParamCheckKey((BaseDataEntity)onlineUser, (boolean)false);
                BaseDEDataCtrl.SetCallParamRetData((BaseDataEntity)onlineUser, (boolean)false);
                onlineUser.setONLINEUSERID(this.getWebContext().getSessionId());
                onlineUser.setONLINEUSERNAME(strLoginName);
                onlineUser.setIPADDRESS(this.getWebContext().getRemoteAddr());
                onlineUser.setUSERID(this.getWebContext().getCurUserId());
                onlineUser.SetParamValue("LOGINTIME", (Object)DateParser.GetCurTime());
                if (!StringHelper.IsNullOrEmpty((String)this.strHostId)) {
                    onlineUser.setSERVERID(this.strHostId);
                }
                iDataCtrl.Save(true, (BaseDataEntity)onlineUser);
            }
        }
        return callResult;
    }

    private final void OnPrepareSubSystem() {
        try {
            Iterator subSystemHelpers = this.getDAModelStorage().getSubSystems();
            while (subSystemHelpers.hasNext()) {
                IDASubSystemHelper iDASubSystemHelper = (IDASubSystemHelper)subSystemHelpers.next();
                iDASubSystemHelper.InitUserSession((ISRFDAWebContext)this.getWebContext());
            }
        }
        catch (Exception ex) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u51c6\u5907\u5b50\u7cfb\u7edf\u7528\u6237\u4f1a\u8bdd\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), ex);
        }
    }

    protected String GetServerPath() {
        return this.strServerPath;
    }

    protected synchronized IDEDataCtrl GetLoginLogDataCtrl() {
        if (loginLogDataCtrl == null) {
            loginLogDataCtrl = this.getDAModelStorage().FindDEDataCtrl("DE0143", "SYSTEM", null);
            String strServerName = this.getRequest().getServerName();
            int nServerPort = this.getRequest().getServerPort();
            String strServerPath2 = this.getRequest().getRequestURI();
            try {
                this.strServerPath = StringHelper.Format((String)"%4$s:%2$s/%1$s%3$s", (Object)strServerName, (Object)nServerPort, (Object)strServerPath2, (Object)InetAddress.getLocalHost().getHostAddress());
            }
            catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }
        return loginLogDataCtrl;
    }

    protected synchronized IDEDataCtrl GetOnlineUserDataCtrl() {
        if (onlineUserDataCtrl == null) {
            onlineUserDataCtrl = this.getDAModelStorage().FindDEDataCtrl("DE0054", "SYSTEM", null);
            this.strHostId = this.getWebContext().getWebExConfig().GetValue("SRFEXWEB", "HOSTID", "");
        }
        return onlineUserDataCtrl;
    }
}

