/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.pscore.srv.util;

import java.sql.Timestamp;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.IPSDevUserBase;

public abstract class PSDevUserBase
implements IPSDevUserBase {
    private String strPSDevCenterId = null;
    private String strPSDevCenterName = null;
    private String strPSDevUserId = null;
    private String strTaskServerUrl = null;
    private Timestamp expiredTime = null;
    private String strUserTag = null;
    private String strUserTag2 = null;
    private Object objUserTag3 = null;
    private Object objUserTag4 = null;
    private String strStudioVer = null;
    private String strStudioTag = null;
    private String strStudioTag2 = null;
    private String strPSDevUserName = null;

    @Override
    public String getPSDevUserId() {
        return this.strPSDevUserId;
    }

    public void setPSDevUserId(String string) {
        this.strPSDevUserId = string;
    }

    @Override
    public String getPSDevUserName() {
        return this.strPSDevUserName;
    }

    public void setPSDevUserName(String string) {
        this.strPSDevUserName = string;
    }

    @Override
    public String getTaskServerUrl() {
        return this.strTaskServerUrl;
    }

    @Override
    public String getPSDevCenterId() {
        return this.strPSDevCenterId;
    }

    public void setPSDevCenterId(String string) {
        this.strPSDevCenterId = string;
    }

    @Override
    public String getPSDevCenterName() {
        return this.strPSDevCenterName;
    }

    public void setPSDevCenterName(String string) {
        this.strPSDevCenterName = string;
    }

    public void setTaskServerUrl(String string) {
        this.strTaskServerUrl = string;
        if (!StringHelper.isNullOrEmpty((String)this.strTaskServerUrl)) {
            int n = this.strTaskServerUrl.length() - 1;
            if (this.strTaskServerUrl.lastIndexOf("/") == n) {
                this.strTaskServerUrl = this.strTaskServerUrl.substring(0, n);
            }
        }
    }

    @Override
    public Timestamp getExpiredTime() {
        return this.expiredTime;
    }

    public void setExpiredTime(Timestamp timestamp) {
        this.expiredTime = timestamp;
    }

    @Override
    public boolean isExpired() {
        if (this.getExpiredTime() == null) {
            return false;
        }
        return this.getExpiredTime().getTime() < System.currentTimeMillis();
    }

    @Override
    public String getUserTag() {
        return this.strUserTag;
    }

    public void setUserTag(String string) {
        this.strUserTag = string;
    }

    @Override
    public String getUserTag2() {
        return this.strUserTag2;
    }

    public void setUserTag2(String string) {
        this.strUserTag2 = string;
    }

    @Override
    public Object getUserTag3() {
        return this.objUserTag3;
    }

    public void setUserTag3(Object object) {
        this.objUserTag3 = object;
    }

    @Override
    public Object getUserTag4() {
        return this.objUserTag4;
    }

    public void setUserTag4(Object object) {
        this.objUserTag4 = object;
    }

    @Override
    public String getStudioVer() {
        return this.strStudioVer;
    }

    public void setStudioVer(String string) {
        this.strStudioVer = string;
    }

    @Override
    public String getStudioTag() {
        return this.strStudioTag;
    }

    public void setStudioTag(String string) {
        this.strStudioTag = string;
    }

    @Override
    public String getStudioTag2() {
        return this.strStudioTag2;
    }

    public void setStudioTag2(String string) {
        this.strStudioTag2 = string;
    }
}

