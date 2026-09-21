/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Res.IPSSysViewLogic;
import SA.SRFDA.PS.Core.Res.IPSSysViewLogicParam;
import SA.SRFDA.PS.Data.PSSysViewLogicParam;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;

public class PSSysViewLogicParamImpl
extends PSObjectImpl
implements IPSSysViewLogicParam {
    protected PSSysViewLogicParam psSysViewLogicParam = null;
    private IPSSysViewLogic iPSSysViewLogic = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysViewLogic iPSSysViewLogic, PSSysViewLogicParam psSysViewLogicParam) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.iPSSysViewLogic = iPSSysViewLogic;
        this.psSysViewLogicParam = psSysViewLogicParam;
        this.setId(this.psSysViewLogicParam.getPSSYSVIEWLOGICPARAMID());
        this.setName(this.psSysViewLogicParam.getPSSYSVIEWLOGICPARAMNAME());
        this.setPSObjectData(this.psSysViewLogicParam);
        this.onInit();
    }

    @Override
    public IPSSysViewLogic getPSSysViewLogic() {
        return this.iPSSysViewLogic;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSysViewLogic().getPSSysModelInstId();
    }

    @Override
    @PSModelRTMeta(description="\u53c2\u6570\u503c2")
    public String getParamValue() {
        return this.psSysViewLogicParam.getPARAMVALUE();
    }

    @Override
    @PSModelRTMeta(description="\u53c2\u6570\u503c2")
    public String getParamValue2() {
        return this.psSysViewLogicParam.getPARAMVALUE2();
    }

    @Override
    public String getModelType() {
        return StringHelper.format((String)"%1$s$%2$s", (Object)"PSSYSVIEWLOGICPARAM", (Object)this.getPSSysViewLogic().getModelType());
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSSysViewLogic().getModelId(), (Object)this.getName());
    }
}

