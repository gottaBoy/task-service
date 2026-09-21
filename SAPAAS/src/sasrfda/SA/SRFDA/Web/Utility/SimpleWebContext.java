/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.CodeList.CodeListMgr
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.SecurityEx.Web.IUserPrivilegeMgr
 *  SA.SRFramework.WebEx.SRFExAjaxActionResult
 */
package SA.SRFDA.Web.Utility;

import SA.SRFDA.Security.IUserRoleHelper;
import SA.SRFDA.Security.UserQueryModelStorage;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAConfigCache;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.CodeList.CodeListMgr;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.SecurityEx.Web.IUserPrivilegeMgr;
import SA.SRFramework.WebEx.SRFExAjaxActionResult;
import java.util.Hashtable;
import java.util.Map;
import java.util.TimeZone;

public class SimpleWebContext
implements ISRFDAWebContext {
    private ISRFDAGlobalHelper iDAGlobalHelper = null;
    private BaseDataEntity dataEntity = null;
    private String strCurPersonId = "";
    private String strCurOrgId = "";
    private String strCurOrgName = "";

    public SimpleWebContext(ISRFDAGlobalHelper iDAGlobalHelper, BaseDataEntity dataEntity) {
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.dataEntity = dataEntity;
    }

    public Object GetGlobalValue(String strKey) {
        return this.iDAGlobalHelper.GetGlobalValue(strKey);
    }

    public String GetParamValue(String strParamName) {
        return this.dataEntity.GetParamStringValue(strParamName, "");
    }

    public String GetPostValue(String strParamName) {
        return this.dataEntity.GetParamStringValue(strParamName, "");
    }

    @Override
    public String GetPostValue(String strParamName, String strDefault) {
        return this.dataEntity.GetParamStringValue(strParamName, strDefault);
    }

    public Object GetSessionValue(String strKey) {
        return null;
    }

    public boolean IsBackEndMode() {
        return false;
    }

    public void SetGlobalValue(String strKey, Object objValue) {
        this.iDAGlobalHelper.SetGlobalValue(strKey, objValue);
    }

    public void SetParamValue(String strParamName, String strParamValue) {
        this.dataEntity.SetParamValue(strParamName, (Object)strParamValue);
    }

    public void SetSessionValue(String strKey, Object objValue) {
    }

    public CodeListMgr getCodeListMgr() {
        return this.iDAGlobalHelper.getCodeListMgr();
    }

    public String getCurDeptId() {
        return null;
    }

    public String getCurDeptName() {
        return null;
    }

    public String getCurUserId() {
        return this.strCurPersonId;
    }

    public void setCurUserId(String strCurPersonId) {
        this.strCurPersonId = strCurPersonId;
    }

    public String getCurUserMode() {
        return null;
    }

    public String getCurUserName() {
        return null;
    }

    public String getRemoteAddr() {
        return null;
    }

    @Override
    public SRFDAConfigCache GetConfigCache() {
        return null;
    }

    @Override
    public String GetQueryStringWithoutDAParam(Map<String, String> daParams) {
        return null;
    }

    @Override
    public UserQueryModelStorage GetUserQueryModelStorage() {
        return null;
    }

    @Override
    public IUserRoleHelper GetUserRoleHelper() {
        return null;
    }

    @Override
    public ISRFDAGlobalHelper getGlobalHelper() {
        return this.iDAGlobalHelper;
    }

    public void Logon() {
    }

    public void Logout() {
    }

    public String getLocalization() {
        Object objValue = this.GetSessionValue("LOCALIZATION");
        if (objValue == null) {
            return "";
        }
        return (String)objValue;
    }

    public TimeZone getCurTimeZone() {
        return TimeZone.getDefault();
    }

    public String GetQueryString() {
        return null;
    }

    public void RemoveParam(String strParamName) {
        this.dataEntity.RemoveParam(strParamName);
    }

    public IUserPrivilegeMgr GetUserPrivilegeMgr() {
        return null;
    }

    public String GetLocalization(String strResId, String strResId2, String strDefault) {
        return null;
    }

    public String getCurOrgUnitId() {
        return this.strCurOrgId;
    }

    public void setCurOrgUnitId(String strValue) {
        this.strCurOrgId = strValue;
    }

    public String getCurOrgUnitName() {
        return this.strCurOrgName;
    }

    public void setCurOrgUnitName(String strValue) {
        this.strCurOrgName = strValue;
    }

    public Hashtable<String, String> GetParams() {
        return this.dataEntity.getParamList();
    }

    @Override
    public String getSRFWFMode() {
        return "";
    }

    public String getCurPagePath() {
        return "";
    }

    public String GetQueryStringWithout(String strParams) {
        return null;
    }

    public void ReloadUserPrivilege() {
    }

    public SRFExAjaxActionResult getActiveAjaxActionResult() {
        return null;
    }

    public void setActiveAjaxActionResult(SRFExAjaxActionResult ajaxActionResult) {
    }

    @Override
    public Object getAttribute(String strName) {
        return null;
    }

    @Override
    public void setAttribute(String strName, Object objValue) {
    }
}

