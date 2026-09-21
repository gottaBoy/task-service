/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.SecurityEx.Web.IUserPrivilegeMgr
 *  SA.SRFramework.WebEx.SRFExHttpServletContext
 *  javax.servlet.ServletContext
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 */
package SA.SRFDA.Web;

import SA.SRFDA.Security.DAUserPrivilegeMgr;
import SA.SRFDA.Security.IUserRoleHelper;
import SA.SRFDA.Security.UserQueryModelStorage;
import SA.SRFDA.Security.UserRoleHelper;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAConfigCache;
import SA.SRFDA.Web.SRFDAWebContext;
import SA.SRFDA.Web.Utility.GlobalHelperEx;
import SA.SRFramework.SecurityEx.Web.IUserPrivilegeMgr;
import SA.SRFramework.WebEx.SRFExHttpServletContext;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SRFDAHttpServletContext
extends SRFExHttpServletContext
implements ISRFDAWebContext {
    public SRFDAHttpServletContext(HttpServletRequest arg0, HttpServletResponse arg1, ServletContext arg2) {
        super(arg0, arg1, arg2);
    }

    @Override
    public GlobalHelperEx getGlobalHelper() {
        return (GlobalHelperEx)this.GetGlobalValue("SRFDACONTEXTHELPER");
    }

    @Override
    public IUserRoleHelper GetUserRoleHelper() {
        Object objUserRoleHelper = this.GetSessionValue("SRFUSERROLEHELPER");
        if (objUserRoleHelper == null || !(objUserRoleHelper instanceof UserRoleHelper)) {
            UserRoleHelper userRoleHelper = new UserRoleHelper(this.getGlobalHelper(), this.getCurUserId());
            this.SetSessionValue("SRFUSERROLEHELPER", userRoleHelper);
            return userRoleHelper;
        }
        return (IUserRoleHelper)objUserRoleHelper;
    }

    @Override
    public UserQueryModelStorage GetUserQueryModelStorage() {
        Object objUserQueryModelStorage = this.GetSessionValue("SRFUSERQUERYMODELSTORAGE");
        if (objUserQueryModelStorage == null || !(objUserQueryModelStorage instanceof UserQueryModelStorage)) {
            UserQueryModelStorage userQueryModelStorage = new UserQueryModelStorage(this.GetUserRoleHelper(), this.getGlobalHelper(), this.getCurUserId());
            this.SetSessionValue("SRFUSERQUERYMODELSTORAGE", userQueryModelStorage);
            return userQueryModelStorage;
        }
        return (UserQueryModelStorage)objUserQueryModelStorage;
    }

    protected IUserPrivilegeMgr CreateUserPrivilegeMgr() {
        return new DAUserPrivilegeMgr();
    }

    @Override
    public SRFDAConfigCache GetConfigCache() {
        Object objConfigCache = this.GetSessionValue("SRFCONFIGCACHE");
        if (objConfigCache == null || !(objConfigCache instanceof SRFDAConfigCache)) {
            SRFDAConfigCache ConfigCache = new SRFDAConfigCache(this.getGlobalHelper());
            this.SetSessionValue("SRFCONFIGCACHE", ConfigCache);
            return ConfigCache;
        }
        return (SRFDAConfigCache)objConfigCache;
    }

    public String GetQueryStringWithoutDAParam() {
        return this.GetQueryStringWithoutDAParam(null);
    }

    @Override
    public String GetQueryStringWithoutDAParam(Map<String, String> daParams) {
        String strTemp = SRFDAWebContext.strDAParams;
        if (daParams != null) {
            for (String strKey : daParams.keySet()) {
                strTemp = String.valueOf(strTemp) + "|";
                strTemp = String.valueOf(strTemp) + strKey;
            }
        }
        return this.GetQueryStringWithout(strTemp);
    }

    @Override
    public String getSRFWFMode() {
        Object objWFMode = this.GetSessionValue("SRFWFMODE");
        if (objWFMode == null) {
            return "";
        }
        return objWFMode.toString();
    }

    public void ReloadUserPrivilege() {
        super.ReloadUserPrivilege();
        this.SetSessionValue("SRFUSERQUERYMODELSTORAGE", null);
        this.SetSessionValue("SRFUSERROLEHELPER", null);
        this.SetSessionValue("SRFUSERQUERYMODELSTORAGE", null);
    }

    @Override
    public Object getAttribute(String strName) {
        return null;
    }

    @Override
    public void setAttribute(String strName, Object objValue) {
    }
}

