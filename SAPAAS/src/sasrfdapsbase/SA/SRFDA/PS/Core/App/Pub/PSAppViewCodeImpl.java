/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.App.Pub;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.PSApplicationObjectImpl;
import SA.SRFDA.PS.Core.App.Pub.IPSAppViewCode;
import SA.SRFDA.PS.Core.PF.IPSPFPubCode;
import SA.SRFDA.PS.Data.PSAppViewCode;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;

public class PSAppViewCodeImpl
extends PSApplicationObjectImpl
implements IPSAppViewCode {
    protected PSAppViewCode psAppViewCode = null;
    private IPSPFPubCode iPSPFPubCode = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSApplication iPSApplication, PSAppViewCode psAppViewCode) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setPSApplication(iPSApplication);
        this.psAppViewCode = psAppViewCode;
        this.setId(this.psAppViewCode.getPSAPPVIEWCODEID());
        this.setName(this.psAppViewCode.getPSAPPVIEWCODENAME());
        this.setPSObjectData(this.psAppViewCode);
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        if (!StringHelper.IsNullOrEmpty((String)this.psAppViewCode.getPSPFPUBCODEID())) {
            this.iPSPFPubCode = this.getPSApplication().getPSPF().getPSPFPubCode(this.psAppViewCode.getPSPFPUBCODEID());
        }
        super.onInit();
    }

    @Override
    public String getModelType() {
        return "PSAPPVIEWCODE";
    }

    @Override
    public String getProjectType() {
        return this.psAppViewCode.getPRJTYPE();
    }

    @Override
    public String getUserCode() {
        return this.psAppViewCode.getUSERCODE();
    }

    @Override
    public String getFilePath() {
        return this.psAppViewCode.getCODEPATH();
    }

    @Override
    public IPSPFPubCode getPSPFPubCode() {
        return this.iPSPFPubCode;
    }
}

