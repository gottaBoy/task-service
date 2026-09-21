/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSDevSlnMSDepFunc;
import SA.SRFDA.PS.Core.Deploy.PSDevSlnMSDepFuncImpl;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Data.PSDevSlnMSDepFunc;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDevSlnMSDepFuncGlobalModel
extends PSGlobalModelBase<String, PSDevSlnMSDepFunc, IPSDevSlnMSDepFunc> {
    private static final Log log = LogFactory.getLog(PSDevSlnMSDepFuncGlobalModel.class);

    @Override
    protected CallResult OnInit() {
        this.nRenewTimer = 0;
        return super.OnInit();
    }

    @Override
    protected boolean getEnableRenew() {
        return true;
    }

    @Override
    protected PSDevSlnMSDepFunc GetObject(String strPSDevSlnMSDepFuncId) {
        PSDevSlnMSDepFunc psDevSlnMSDepFunc = new PSDevSlnMSDepFunc();
        CallResult callResult = this.iPSModelHelper.getPSDevSlnMSDepFunc(strPSDevSlnMSDepFuncId, psDevSlnMSDepFunc);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5f00\u53d1\u65b9\u6848\u5fae\u670d\u52a1\u529f\u80fd\u90e8\u7f72[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDevSlnMSDepFuncId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psDevSlnMSDepFunc;
    }

    @Override
    protected IPSDevSlnMSDepFunc OnCreateModelHelper(PSDevSlnMSDepFunc vt) throws Exception {
        PSDevSlnMSDepFuncImpl iPSDevSlnMSDepFunc = new PSDevSlnMSDepFuncImpl();
        iPSDevSlnMSDepFunc.init(this.iDAGlobalHelper, null, vt);
        return iPSDevSlnMSDepFunc;
    }

    @Override
    protected Boolean TestObjectRenew(PSDevSlnMSDepFunc obj) {
        return true;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected IPSDevSlnMSDepFunc registerModel(PSDevSlnMSDepFunc vt) throws Exception {
        IPSDevSlnMSDepFunc iPSDevSlnMSDepFunc = (IPSDevSlnMSDepFunc)this.InternalGetModelHelper(vt.getPSDEVSLNMSDEPFUNCID());
        if (iPSDevSlnMSDepFunc != null) {
            return iPSDevSlnMSDepFunc;
        }
        this.setModel(vt.getPSDEVSLNMSDEPFUNCID(), vt, null);
        return (IPSDevSlnMSDepFunc)this.FindModelHelper(vt.getPSDEVSLNMSDEPFUNCID());
    }

    @Override
    protected String getObjectId(PSDevSlnMSDepFunc vt) {
        return vt.getPSDEVSLNMSDEPFUNCID();
    }
}

