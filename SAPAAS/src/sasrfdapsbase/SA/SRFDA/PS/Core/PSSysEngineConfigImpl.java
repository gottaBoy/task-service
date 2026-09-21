/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.IPSSysEngineConfig;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSSysEngineCfg;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysEngineConfigImpl
extends PSObjectImpl
implements IPSSysEngineConfig {
    private static final Log log = LogFactory.getLog(PSSysEngineConfigImpl.class);
    protected PSSysEngineCfg psSysEngineCfg = null;
    private int nImpDEFRule = -1;
    private int nViewUARegMode = 0;
    private int nViewCtrlAjaxRecvRange = 0;
    private boolean bViewCtrlHandlerFirst = false;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSSysEngineCfg psSysEngineCfg) throws Exception {
        this.psSysEngineCfg = psSysEngineCfg;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psSysEngineCfg.getPSSYSENGINECFGID());
        this.setName(psSysEngineCfg.getPSSYSENGINECFGNAME());
        this.setPSObjectData(this.psSysEngineCfg);
        if (!this.psSysEngineCfg.isIMPDEFRULENull()) {
            this.nImpDEFRule = this.psSysEngineCfg.getIMPDEFRULE();
        }
        if (!this.psSysEngineCfg.isVIEWUAREGMODENull()) {
            this.nViewUARegMode = this.psSysEngineCfg.getVIEWUAREGMODE();
        }
        if (!this.psSysEngineCfg.isVIEWCTRLAJAXMODENull()) {
            this.nViewCtrlAjaxRecvRange = this.psSysEngineCfg.getVIEWCTRLAJAXMODE();
        }
        if (!this.psSysEngineCfg.isVIEWCTRLHANDLERFIRSTNull()) {
            this.bViewCtrlHandlerFirst = this.psSysEngineCfg.getVIEWCTRLHANDLERFIRST();
        }
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    public int getImpDEFRule() {
        return this.nImpDEFRule;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    public int getViewUARegMode() {
        return this.nViewUARegMode;
    }

    @Override
    public int getViewCtrlAjaxRecvRange() {
        return this.nViewCtrlAjaxRecvRange;
    }

    @Override
    public boolean isViewCtrlHandlerFirst() {
        return this.bViewCtrlHandlerFirst;
    }
}

