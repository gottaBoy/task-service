/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.controller.IViewController
 *  net.ibizsys.paas.controller.ViewController
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.IWebContext
 *  net.sf.json.JSONObject
 */
package net.ibizsys.pscore.srv.util;

import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.controller.ViewController;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.pscore.srv.util.IPSStudioUser;
import net.sf.json.JSONObject;

public class PSStudioUserLog {
    public static final Integer USERACTION_NORMAL = 1;
    public static final Integer USERACTION_LOGIN = 2;
    public static final Integer USERACTION_LOGOUT = 3;
    private String strRemoteAddr = "";
    private String strRealRemoteAddr = "";
    private long nActionTime = 0L;
    private int nActionType = USERACTION_NORMAL;
    private String strPSSystemId = "";
    private String strPSSystemName = "";
    private String strActionInfo = "";
    private IPSStudioUser iPSStudioUser = null;

    public PSStudioUserLog(IPSStudioUser iPSStudioUser, IWebContext iWebContext, int n, String string) {
        this.iPSStudioUser = iPSStudioUser;
        this.strRemoteAddr = iWebContext.getRemoteAddr();
        this.strRealRemoteAddr = iWebContext.getRealRemoteAddr();
        this.nActionTime = System.currentTimeMillis();
        this.nActionType = n;
        this.strActionInfo = string;
        if (this.nActionType == USERACTION_NORMAL) {
            IViewController iViewController;
            this.strPSSystemId = iWebContext.getAppDataValue("pssystemid");
            this.strPSSystemName = iWebContext.getAppDataValue("pssystemname");
            if (StringHelper.isNullOrEmpty((String)this.strActionInfo) && (iViewController = ViewController.getCurrent()) != null) {
                this.strActionInfo = iViewController.getTitle();
            }
        }
    }

    public long getActionTime() {
        return this.nActionTime;
    }

    public JSONObject toJSONObject() throws Exception {
        JSONObject jSONObject = new JSONObject();
        if (this.iPSStudioUser != null) {
            jSONObject.put("userid", (Object)this.iPSStudioUser.getUserId());
            jSONObject.put("username", (Object)this.iPSStudioUser.getUserName());
            jSONObject.put("loginname", (Object)this.iPSStudioUser.getLoginName());
            jSONObject.put("orgid", (Object)this.iPSStudioUser.getOrgId());
            jSONObject.put("orgname", (Object)this.iPSStudioUser.getOrgName());
        }
        if (!StringHelper.isNullOrEmpty((String)this.strRemoteAddr)) {
            jSONObject.put("remoteaddr", (Object)this.strRemoteAddr);
        }
        if (!StringHelper.isNullOrEmpty((String)this.strRealRemoteAddr)) {
            jSONObject.put("realaddr", (Object)this.strRealRemoteAddr);
        }
        jSONObject.put("actiontime", this.nActionTime);
        jSONObject.put("actiontype", this.nActionType);
        if (!StringHelper.isNullOrEmpty((String)this.strActionInfo)) {
            jSONObject.put("actioninfo", (Object)this.strActionInfo);
        }
        if (!StringHelper.isNullOrEmpty((String)this.strPSSystemName)) {
            jSONObject.put("systemname", (Object)this.strPSSystemName);
        }
        return jSONObject;
    }
}

