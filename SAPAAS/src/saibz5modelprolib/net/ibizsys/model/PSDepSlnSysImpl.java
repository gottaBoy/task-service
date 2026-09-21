/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.IPSDepSlnSys
 *  net.ibizsys.model.IPSSystem
 *  net.ibizsys.model.core.IPSModelObject
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model;

import java.sql.Timestamp;
import net.ibizsys.model.IPSDepSlnSys;
import net.ibizsys.model.IPSDepSlnSysRuntime;
import net.ibizsys.model.IPSModelObjectRuntime;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.IPSSystem;
import net.ibizsys.model.IPSSystemContainer;
import net.ibizsys.model.IPSSystemRuntime;
import net.ibizsys.model.PSModelQueryHelperFactory;
import net.ibizsys.model.PSModelQueryHelperImpl;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.PSSystemImpl;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.entity.PSDepSlnSys;
import net.ibizsys.model.entity.PSSystem;
import net.ibizsys.model.util.PSSysModelInstGlobal;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDepSlnSysImpl
extends PSObjectImpl
implements IPSDepSlnSys,
IPSSystemContainer,
IPSDepSlnSysRuntime {
    private static final Log log = LogFactory.getLog(PSDepSlnSysImpl.class);
    protected PSDepSlnSys psDepSlnSys = null;
    protected IPSSystem iPSSystem = null;
    protected String strSysVersion = "";
    private long nLastActiveTime = 0L;
    private long nLastDBActiveTime = 0L;
    private int nModelInstVer = PSModelQueryHelperImpl.MAXMODELINSTVER;
    private Timestamp expriedTime = null;
    private String strPSSysModelInstId = null;
    private Object objPSSystemLock = new Object();

    public void init(IPSModelStorageContext iPSModelStorageContext, PSDepSlnSys psDepSlnSys) throws Exception {
        this.psDepSlnSys = psDepSlnSys;
        this.setPSModelStorageContext(iPSModelStorageContext);
        this.setId(psDepSlnSys.getPSDEPSLNSYSID());
        this.setName(psDepSlnSys.getPSDEPSLNSYSNAME());
        this.setPSObjectData(this.psDepSlnSys);
        this.strPSSysModelInstId = psDepSlnSys.getPSSYSMODELINSTID();
        this.reloadPSDepSlnSys(this.psDepSlnSys);
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    protected void reloadPSDepSlnSys(PSDepSlnSys psDepSlnSys) throws Exception {
        this.setId(psDepSlnSys.getPSDEPSLNSYSID());
        this.setName(psDepSlnSys.getPSDEPSLNSYSNAME());
        if (psDepSlnSys.getEXPRIEDTIME() == null) {
            this.setExpiredTime(null);
        } else {
            this.setExpiredTime(new Timestamp(psDepSlnSys.getEXPRIEDTIME().getTime()));
        }
        this.strPSSysModelInstId = psDepSlnSys.getPSSYSMODELINSTID();
        this.active();
    }

    public String getPSSystemId() {
        return this.psDepSlnSys.getPSSYSTEMID();
    }

    public synchronized IPSSystem getPSSystem() throws Exception {
        return this.getPSSystem(true);
    }

    public synchronized IPSSystem getPSSystem(boolean bCache) throws Exception {
        if (this.isExpired()) {
            throw new Exception("\u5f00\u53d1\u7cfb\u7edf\u5df2\u7ecf\u8fc7\u671f");
        }
        this.active();
        if (bCache && this.iPSSystem != null) {
            return this.iPSSystem;
        }
        PSSystem psSystem = new PSSystem();
        CallResult callResult = PSModelQueryHelperFactory.getInstance(this.getPSSysModelInstId()).getPSSystem(this.psDepSlnSys.getPSSYSTEMID(), psSystem);
        if (callResult.isError()) {
            String strInfo = StringHelper.format((String)"\u83b7\u53d6\u7cfb\u7edf\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo());
            this.log(1, this, strInfo);
            throw new Exception(strInfo);
        }
        if (this.iPSSystem != null && this.iPSSystem.getVersion() == psSystem.getMODELVER()) {
            return this.iPSSystem;
        }
        if (this.iPSSystem != null) {
            callResult = PSModelQueryHelperFactory.getInstance().getPSDepSlnSys(this.getId(), this.psDepSlnSys);
            if (callResult.isError()) {
                String strInfo = StringHelper.format((String)"\u83b7\u53d6\u5f00\u53d1\u65b9\u6848\u7cfb\u7edf\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo());
                this.log(1, this, strInfo);
                throw new Exception(strInfo);
            }
            this.reloadPSDepSlnSys(this.psDepSlnSys);
        }
        PSSystemImpl psSystemImpl = new PSSystemImpl();
        psSystemImpl.init(this.getPSModelStorageContext(), this, psSystem);
        this.iPSSystem = psSystemImpl;
        return this.iPSSystem;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.strPSSysModelInstId;
    }

    @Override
    public synchronized IPSSystem reloadPSSystem(int nLoadLevel) throws Exception {
        return this.reloadPSSystem(nLoadLevel, IPSSystemRuntime.LOADLEVEL_NONE);
    }

    @Override
    public synchronized IPSSystem reloadPSSystem(int nLoadLevel, int nAppLoadLevel) throws Exception {
        this.iPSSystem = null;
        this.active();
        if (nLoadLevel > IPSSystemRuntime.LOADLEVEL_NONE) {
            this.getPSModelQueryHelper().startLoadPSSystem(this.getPSSystemId(), nLoadLevel);
        }
        try {
            CallResult callResult = PSModelQueryHelperFactory.getInstance().getPSDepSlnSys(this.getId(), this.psDepSlnSys);
            if (callResult.isError()) {
                String strInfo = StringHelper.format((String)"\u83b7\u53d6\u5f00\u53d1\u65b9\u6848\u7cfb\u7edf\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo());
                this.log(1, this, strInfo);
                throw new Exception(strInfo);
            }
            this.reloadPSDepSlnSys(this.psDepSlnSys);
            PSSystem psSystem = new PSSystem();
            callResult = PSModelQueryHelperFactory.getInstance(this.getPSSysModelInstId()).getPSSystem(this.psDepSlnSys.getPSSYSTEMID(), psSystem);
            if (callResult.isError()) {
                String strInfo = StringHelper.format((String)"\u83b7\u53d6\u7cfb\u7edf\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo());
                this.log(1, this, strInfo);
                throw new Exception(strInfo);
            }
            PSSystemImpl psSystemImpl = new PSSystemImpl();
            psSystemImpl.init(this.getPSModelStorageContext(), this, psSystem);
            if (nLoadLevel > IPSSystemRuntime.LOADLEVEL_NONE) {
                psSystemImpl.load(nLoadLevel);
                this.getPSModelQueryHelper().stopLoadPSSystem();
            }
            this.iPSSystem = psSystemImpl;
        }
        catch (Exception ex) {
            this.log(1, this, StringHelper.format((String)"\u7cfb\u7edf\u52a0\u8f7d\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
            this.iPSSystem = null;
            if (nLoadLevel > IPSSystemRuntime.LOADLEVEL_NONE) {
                this.getPSModelQueryHelper().stopLoadPSSystem();
            }
            throw ex;
        }
        if (nLoadLevel > IPSSystemRuntime.LOADLEVEL_NONE) {
            IPSSystemRuntime.LOADLEVEL_NONE.intValue();
        }
        return this.iPSSystem;
    }

    public long getLastActiveTime() {
        return this.nLastActiveTime;
    }

    @Override
    public void uploadPSSystem() throws Exception {
    }

    public int getModelInstVer() {
        return this.nModelInstVer;
    }

    public void log(int nLogLevel, IPSModelObject iPSModelObject, String strInfo, String strUserData) {
        this.log(nLogLevel, iPSModelObject, strInfo, strUserData, null);
    }

    public void log(int nLogLevel, IPSModelObject iPSModelObject, String strInfo, String strUserData, String strUserData2) {
    }

    public void log(int nLogLevel, IPSModelObject iPSModelObject, String strInfo) {
        this.log(nLogLevel, iPSModelObject, strInfo, null, null);
    }

    public Timestamp getExpiredTime() {
        return this.expriedTime;
    }

    protected void setExpiredTime(Timestamp expriedTime) {
        this.expriedTime = expriedTime;
    }

    public void active() {
        this.nLastActiveTime = System.currentTimeMillis();
        if (this.nLastDBActiveTime + 20000L < this.nLastActiveTime) {
            this.nLastDBActiveTime = this.nLastActiveTime;
            PSSysModelInstGlobal.active(this.getPSSysModelInstId());
            try {
                PSModelQueryHelperFactory.getInstance(this.getPSSysModelInstId());
            }
            catch (Exception ex) {
                log.error((Object)ex);
            }
            IPSSystemRuntime iPSSystem = (IPSSystemRuntime)this.iPSSystem;
            if (iPSSystem != null) {
                iPSSystem.active(true);
            }
        }
    }

    public boolean isExpired() {
        if (this.getExpiredTime() == null) {
            return false;
        }
        return this.getExpiredTime().getTime() < System.currentTimeMillis();
    }

    @Override
    protected void onRefreshModelVer() {
        IPSSystem iPSSystem = this.iPSSystem;
        if (iPSSystem != null) {
            ((IPSModelObjectRuntime)iPSSystem).refreshModelVer();
        }
        super.onRefreshModelVer();
    }
}

