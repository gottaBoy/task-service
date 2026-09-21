/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.pscore.srv.util;

import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.IPSSysDevUser;
import net.ibizsys.pscore.srv.util.PSDevUserBase;

public class PSSysDevUser
extends PSDevUserBase
implements IPSSysDevUser {
    public static final PSSysDevUser ACCESSDENY = new PSSysDevUser();
    private int nAccMode = 0;
    private String strPSSystemId = null;
    private String strPSDevSlnSysId = null;
    private String strPSDevSlnTemplId = null;
    private String strPSDevSlnId = null;
    private String strPSSysModelInstId = null;
    private String strJITTaskServerUrl = null;
    private String strPSDCWorkspaceId = null;
    private boolean bEnableAPI = false;
    private String strLoginName = null;
    private String strPSDynaInstId = null;
    private String strPSDepInstId = null;

    @Override
    public int getAccMode() {
        return this.nAccMode;
    }

    @Override
    public String getPSSystemId() {
        return this.strPSSystemId;
    }

    @Override
    public String getPSDevSlnSysId() {
        return this.strPSDevSlnSysId;
    }

    @Override
    public String getPSDevSlnTemplId() {
        return this.strPSDevSlnTemplId;
    }

    @Override
    public String getPSDevSlnId() {
        return this.strPSDevSlnId;
    }

    public void setAccMode(int n) {
        this.nAccMode = n;
    }

    public void setPSSystemId(String string) {
        this.strPSSystemId = string;
    }

    public void setPSDevSlnSysId(String string) {
        this.strPSDevSlnSysId = string;
    }

    public void setPSDevSlnTemplId(String string) {
        this.strPSDevSlnTemplId = string;
    }

    public void setPSDevSlnId(String string) {
        this.strPSDevSlnId = string;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.strPSSysModelInstId;
    }

    public void setPSSysModelInstId(String string) {
        this.strPSSysModelInstId = string;
    }

    @Override
    public boolean isShareAccMode() {
        return (this.getAccMode() & 5) == 5;
    }

    @Override
    public boolean isMaintainAccMode() {
        return (this.getAccMode() & 0xB) == 11;
    }

    @Override
    public boolean isOwnerAccMode() {
        return (this.getAccMode() & 0x13) == 19;
    }

    @Override
    public String getJITTaskServerUrl() {
        if (StringHelper.isNullOrEmpty((String)this.strJITTaskServerUrl)) {
            return this.getTaskServerUrl();
        }
        return this.strJITTaskServerUrl;
    }

    public void setJITTaskServerUrl(String string) {
        this.strJITTaskServerUrl = string;
    }

    @Override
    public String getPSDCWorkspaceId() {
        return this.strPSDCWorkspaceId;
    }

    public void setPSDCWorkspaceId(String string) {
        this.strPSDCWorkspaceId = string;
    }

    @Override
    public boolean isEnableAPI() {
        return this.bEnableAPI;
    }

    public void setEnableAPI(boolean bl) {
        this.bEnableAPI = bl;
    }

    @Override
    public String getLoginName() {
        return this.strLoginName;
    }

    public void setLoginName(String string) {
        this.strLoginName = string;
    }

    @Override
    public String getPSDynaInstId() {
        return this.strPSDynaInstId;
    }

    public void setPSDynaInstId(String string) {
        this.strPSDynaInstId = string;
    }

    @Override
    public String getPSDepInstId() {
        return this.strPSDepInstId;
    }

    public void setPSDepInstId(String string) {
        this.strPSDepInstId = string;
    }
}

