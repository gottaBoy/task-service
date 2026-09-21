/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppDEView;
import SA.SRFDA.PS.Core.App.View.IPSAppDEViewLogic;
import SA.SRFDA.PS.Core.App.View.IPSAppViewEngine;
import SA.SRFDA.PS.Core.App.View.IPSAppViewUIAction;
import SA.SRFDA.PS.Core.App.View.PSAppViewLogicImplBase;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Data.PSDEViewLogic;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;

public class PSAppDEViewLogicImpl
extends PSAppViewLogicImplBase
implements IPSAppDEViewLogic {
    private IPSAppDEView iPSAppDEView = null;
    private PSDEViewLogic psDEViewLogic = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSAppDEView iPSAppDEView, PSDEViewLogic psDEViewLogic, IPSAppViewEngine iPSAppViewEngine) throws Exception {
        this.setPSAppViewEngine(iPSAppViewEngine);
        this.setBuiltinLogic(true);
        this.init(iDAGlobalHelper, iPSAppDEView, psDEViewLogic);
    }

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSAppDEView iPSAppDEView, PSDEViewLogic psDEViewLogic, IPSAppViewUIAction iPSAppViewUIAction) throws Exception {
        this.setPSAppViewUIAction(iPSAppViewUIAction);
        this.setBuiltinLogic(true);
        this.init(iDAGlobalHelper, iPSAppDEView, psDEViewLogic);
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSAppDEView iPSAppDEView, PSDEViewLogic psDEViewLogic) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setOwner(iPSAppDEView);
        this.iPSAppDEView = iPSAppDEView;
        this.psDEViewLogic = psDEViewLogic;
        this.psDEViewLogic.CopyTo(this.psAppViewLogic, true);
        this.setId(this.psDEViewLogic.getPSDEVIEWLOGICID());
        this.setName(this.psDEViewLogic.getPSDEVIEWLOGICNAME());
        this.setPSObjectData(this.psDEViewLogic);
        if (StringHelper.IsNullOrEmpty((String)this.psAppViewLogic.getREFPSAPPVIEWLOGICNAME())) {
            this.psAppViewLogic.setREFPSAPPVIEWLOGICNAME(this.psDEViewLogic.getREFPSDEVIEWLOGICNAME());
        }
        this.onInit();
    }

    @Override
    public IPSDataEntity getPSDataEntity() {
        if (this.getPSAppDEView() == null) {
            return null;
        }
        return this.getPSAppDEView().getPSDataEntity();
    }

    @Override
    public IPSAppDEView getPSAppDEView() {
        return this.iPSAppDEView;
    }
}

