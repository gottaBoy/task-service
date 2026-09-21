/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.IPSDepSlnPrd;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSObjectFactory;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.PSSystemImpl;
import SA.SRFDA.PS.Data.PSDepSlnPrd;
import SA.SRFDA.PS.Data.PSSystem;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDepSlnPrdImpl
extends PSObjectImpl
implements IPSDepSlnPrd {
    private static final Log log = LogFactory.getLog(PSDepSlnPrdImpl.class);
    protected PSDepSlnPrd psDepSlnPrd = null;
    protected IPSSystem iPSSystem = null;
    private long nLastActiveTime = 0L;
    private boolean bEnableDynamicMode = false;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSDepSlnPrd psDepSlnPrd) throws Exception {
        this.psDepSlnPrd = psDepSlnPrd;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psDepSlnPrd.getPSDEPSLNPRDID());
        this.setName(psDepSlnPrd.getPSDEPSLNPRDNAME());
        this.setPSObjectData(this.psDepSlnPrd);
        this.nLastActiveTime = System.currentTimeMillis();
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.getPSSystem(false);
    }

    @Override
    public String getPSSystemId() {
        return this.psDepSlnPrd.getPSSYSTEMID();
    }

    @Override
    public synchronized IPSSystem getPSSystem() throws Exception {
        return this.getPSSystem(true);
    }

    @Override
    public synchronized IPSSystem getPSSystem(boolean bCache) throws Exception {
        this.nLastActiveTime = System.currentTimeMillis();
        if (bCache) {
            return this.iPSSystem;
        }
        PSSystem psSystem = new PSSystem();
        CallResult callResult = PSObjectFactory.getPSModelHelper(this.getDAGlobalHelper(), this.getPSSysModelInstId()).getPSSystem(this.psDepSlnPrd.getPSSYSTEMID(), psSystem);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u7cfb\u7edf\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        if (this.iPSSystem != null && this.iPSSystem.getVersion() == psSystem.getMODELVER()) {
            return this.iPSSystem;
        }
        if (this.iPSSystem != null && (callResult = PSObjectFactory.getPSModelHelper(this.getDAGlobalHelper(), null).getPSDepSlnPrd(this.getId(), this.psDepSlnPrd)).isError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u5e94\u7528\u65b9\u6848\u7cfb\u7edf\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        PSSystemImpl psSystemImpl = new PSSystemImpl();
        psSystemImpl.init(this.getDAGlobalHelper(), this, psSystem);
        this.iPSSystem = psSystemImpl;
        return this.iPSSystem;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.psDepSlnPrd.getPSSYSMODELINSTID();
    }

    @Override
    public synchronized IPSSystem reloadPSSystem(int nLoadLevel) throws Exception {
        this.nLastActiveTime = System.currentTimeMillis();
        this.iPSSystem = null;
        if (nLoadLevel > IPSSystem.LOADLEVEL_NONE) {
            this.getPSModelHelper().startLoadPSSystem(this.getPSSystemId(), nLoadLevel);
        }
        try {
            CallResult callResult = PSObjectFactory.getPSModelHelper(this.getDAGlobalHelper(), null).getPSDepSlnPrd(this.getId(), this.psDepSlnPrd);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u5e94\u7528\u65b9\u6848\u7cfb\u7edf\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            PSSystem psSystem = new PSSystem();
            callResult = PSObjectFactory.getPSModelHelper(this.getDAGlobalHelper(), this.getPSSysModelInstId()).getPSSystem(this.psDepSlnPrd.getPSSYSTEMID(), psSystem);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u7cfb\u7edf\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            PSSystemImpl psSystemImpl = new PSSystemImpl();
            psSystemImpl.init(this.getDAGlobalHelper(), this, psSystem);
            this.iPSSystem = psSystemImpl;
            if (nLoadLevel > IPSSystem.LOADLEVEL_NONE) {
                this.iPSSystem.load(nLoadLevel);
                this.getPSModelHelper().stopLoadPSSystem();
            }
        }
        catch (Exception ex) {
            if (nLoadLevel > IPSSystem.LOADLEVEL_NONE) {
                this.getPSModelHelper().stopLoadPSSystem();
            }
            throw ex;
        }
        return this.iPSSystem;
    }

    @Override
    public long getLastActiveTime() {
        return this.nLastActiveTime;
    }

    @Override
    public boolean isEnableDynamicMode() {
        return this.bEnableDynamicMode;
    }

    @Override
    protected boolean hasPSSysDynaModel() {
        return false;
    }
}

