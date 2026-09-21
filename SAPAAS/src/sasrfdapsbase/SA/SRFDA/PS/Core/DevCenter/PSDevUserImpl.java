/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.DevCenter;

import SA.SRFDA.PS.Core.DevCenter.IPSDevCenter;
import SA.SRFDA.PS.Core.DevCenter.IPSDevUserRuntime;
import SA.SRFDA.PS.Core.DevCenter.PSDevCenterObjectImpl;
import SA.SRFDA.PS.Data.PSDevUser;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public class PSDevUserImpl
extends PSDevCenterObjectImpl
implements IPSDevUserRuntime {
    private PSDevUser psDevUser = null;
    private String strSessionId = "";
    private String strRemoteAddr = "";
    private long nLastActiveTime = 0L;
    private boolean bActive = false;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDevCenter iPSDevCenter, PSDevUser psDevUser) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setPSDevCenter(iPSDevCenter);
        this.psDevUser = psDevUser;
        this.setId(this.psDevUser.getPSDEVUSERID());
        this.setName(this.psDevUser.getPSDEVUSERNAME());
        this.setPSObjectData(this.psDevUser);
        this.onInit();
    }

    @Override
    public void reload() throws Exception {
    }

    @Override
    public synchronized void login(String strSessionId, String strRemoteAddr) throws Exception {
        this.strSessionId = strSessionId;
        this.strRemoteAddr = strRemoteAddr;
        this.nLastActiveTime = System.currentTimeMillis();
        this.bActive = true;
    }

    @Override
    public synchronized void active(String strSessionId, String strRemoteAddr, String strInfo, String strUserData) throws Exception {
        this.strSessionId = strSessionId;
        this.strRemoteAddr = strRemoteAddr;
        this.nLastActiveTime = System.currentTimeMillis();
        this.bActive = true;
    }

    @Override
    public synchronized void logout(String strRemoteAddr) throws Exception {
        this.strSessionId = "";
        this.strRemoteAddr = "";
        this.bActive = false;
    }

    @Override
    public String getActiveSessionId() {
        return this.strSessionId;
    }

    @Override
    public String getRemoteAddr() {
        return this.strRemoteAddr;
    }

    @Override
    public long getLastActiveTime() {
        return this.nLastActiveTime;
    }

    @Override
    public boolean isActive() {
        return this.bActive;
    }
}

