/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.IPSModelInit;
import SA.SRFDA.PS.Core.IPSModelInitStep;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSModelInitStep;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public class PSModelInitStepImpl
extends PSObjectImpl
implements IPSModelInitStep {
    protected IPSModelInit iPSModelInit = null;
    protected PSModelInitStep psModelInitStep = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSModelInit iPSModelInit, PSModelInitStep psModelInitStep) throws Exception {
        this.iPSModelInit = iPSModelInit;
        this.psModelInitStep = psModelInitStep;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psModelInitStep.getPSMIDETAILID());
        this.setName(psModelInitStep.getPSMIDETAILNAME());
        this.setPSObjectData(this.psModelInitStep);
        this.onInit();
    }

    @Override
    public String getInitDEId() {
        return this.psModelInitStep.getDEID();
    }

    @Override
    public String getInitAction() {
        return this.psModelInitStep.getINITMODE();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSModelInit.getPSSysModelInstId();
    }
}

