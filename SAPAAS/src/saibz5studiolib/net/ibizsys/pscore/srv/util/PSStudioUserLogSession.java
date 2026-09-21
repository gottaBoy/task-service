/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.web.IWebContext
 */
package net.ibizsys.pscore.srv.util;

import java.util.ArrayList;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.pscore.srv.util.IPSStudioUser;
import net.ibizsys.pscore.srv.util.PSStudioUserLog;

public class PSStudioUserLogSession
implements IPSStudioUser {
    private String strUserId = "";
    private String strUserName = "";
    private String strLoginName = "";
    private String strOrgName = "";
    private String strOrgId = "";
    private long nLastActionTime = 0L;
    private ArrayList<PSStudioUserLog> psStudioUserLogList = new ArrayList();

    public synchronized void init(IWebContext iWebContext) {
        this.strLoginName = iWebContext.getCurLoginName();
        this.strUserId = iWebContext.getCurUserId();
        this.strUserName = iWebContext.getCurUserName();
        this.strOrgId = iWebContext.getCurOrgId();
        this.strOrgName = iWebContext.getCurOrgName();
    }

    public synchronized void logAction(IWebContext iWebContext, int n, String string) {
        PSStudioUserLog pSStudioUserLog = new PSStudioUserLog(this, iWebContext, n, string);
        if (this.psStudioUserLogList.size() > 5) {
            this.psStudioUserLogList.remove(0);
        }
        this.psStudioUserLogList.add(pSStudioUserLog);
        this.nLastActionTime = System.currentTimeMillis();
    }

    @Override
    public String getUserId() {
        return this.strUserId;
    }

    @Override
    public String getUserName() {
        return this.strUserName;
    }

    @Override
    public String getLoginName() {
        return this.strLoginName;
    }

    @Override
    public String getOrgName() {
        return this.strOrgName;
    }

    @Override
    public String getOrgId() {
        return this.strOrgId;
    }

    public synchronized void fillPSStudioUserLogList(ArrayList<PSStudioUserLog> arrayList, long l) {
        if (this.nLastActionTime < l) {
            return;
        }
        for (PSStudioUserLog pSStudioUserLog : this.psStudioUserLogList) {
            if (pSStudioUserLog.getActionTime() < l) continue;
            arrayList.add(pSStudioUserLog);
        }
    }

    public long getLastActionTime() {
        return this.nLastActionTime;
    }
}

