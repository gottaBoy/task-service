/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.WebEx;

import SA.SRFramework.CodeList.CodeListMgr;
import SA.SRFramework.SecurityEx.Web.IUserPrivilegeMgr;
import SA.SRFramework.WebEx.SRFExAjaxActionResult;
import SA.SRFramework.WebEx.Utility.ISRFExGlobalHelper;
import java.util.Hashtable;
import java.util.TimeZone;

public interface ISRFExWebContext {
    public String getCurUserName();

    public String getCurUserId();

    public String getCurOrgUnitId();

    public String getCurOrgUnitName();

    public TimeZone getCurTimeZone();

    public String getRemoteAddr();

    public Object GetSessionValue(String var1);

    public void SetSessionValue(String var1, Object var2);

    public Object GetGlobalValue(String var1);

    public void SetGlobalValue(String var1, Object var2);

    public ISRFExGlobalHelper getGlobalHelper();

    public String GetParamValue(String var1);

    public void SetParamValue(String var1, String var2);

    public void RemoveParam(String var1);

    public CodeListMgr getCodeListMgr();

    public String getCurUserMode();

    public String getCurDeptId();

    public String getCurDeptName();

    public String GetPostValue(String var1);

    public boolean IsBackEndMode();

    public void Logout();

    public void Logon();

    public String getLocalization();

    public String GetQueryString();

    public IUserPrivilegeMgr GetUserPrivilegeMgr();

    public String GetLocalization(String var1, String var2, String var3);

    public Hashtable<String, String> GetParams();

    public String getCurPagePath();

    public String GetQueryStringWithout(String var1);

    public void ReloadUserPrivilege();

    public SRFExAjaxActionResult getActiveAjaxActionResult();

    public void setActiveAjaxActionResult(SRFExAjaxActionResult var1);
}

