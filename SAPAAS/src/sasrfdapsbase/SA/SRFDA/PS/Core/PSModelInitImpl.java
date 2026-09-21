/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.IPSModelInit;
import SA.SRFDA.PS.Core.IPSModelInitStep;
import SA.SRFDA.PS.Core.PSModelInitStepImpl;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSModelInit;
import SA.SRFDA.PS.Data.PSModelInitStep;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public class PSModelInitImpl
extends PSObjectImpl
implements IPSModelInit {
    protected PSModelInit psModelInit = null;
    protected ArrayList<IPSModelInitStep> psModelInitStepList = new ArrayList();

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSModelInit psModelInit) throws Exception {
        this.psModelInit = psModelInit;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psModelInit.getPSMODELINITID());
        this.setName(psModelInit.getPSMODELINITNAME());
        this.setPSObjectData(this.psModelInit);
        this.onPrepareModelInitSteps();
        this.onInit();
    }

    protected void onPrepareModelInitSteps() throws Exception {
        Vector<PSModelInitStep> psModelInitStepList = new Vector<PSModelInitStep>();
        CallResult callResult = this.getPSModelHelper().getPSModelInitSteps(this.getId(), psModelInitStepList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u521d\u59cb\u5316\u6a21\u578b\u6b65\u9aa4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        this.psModelInitStepList.clear();
        for (PSModelInitStep psModelInitStep : psModelInitStepList) {
            PSModelInitStepImpl psModelInitStepImpl = new PSModelInitStepImpl();
            psModelInitStepImpl.init(this.getDAGlobalHelper(), this, psModelInitStep);
            this.psModelInitStepList.add(psModelInitStepImpl);
        }
    }

    @Override
    public Iterator<IPSModelInitStep> getModelInitSteps() {
        return this.psModelInitStepList.iterator();
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }
}

