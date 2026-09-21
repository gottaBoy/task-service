/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.IPSModel;
import SA.SRFDA.PS.Core.IPSModelHelper;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Core.PSModelImpl;
import SA.SRFDA.PS.Core.PSObjectFactory;
import SA.SRFDA.PS.Data.PSModel;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSModelGlobalModel
extends PSGlobalModelBase<String, PSModel, IPSModel> {
    private static final Log log = LogFactory.getLog(PSModelGlobalModel.class);
    protected IPSModelHelper iPSModelHelper = null;

    @Override
    protected CallResult OnInit() {
        this.bEnableEmptyMap = true;
        CallResult callResult = super.OnInit();
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            this.iPSModelHelper = PSObjectFactory.getPSModelHelper(this.iDAGlobalHelper, null);
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u521d\u59cb\u5316\u4e91\u5e73\u53f0\u6a21\u578b\u5168\u5c40\u6a21\u578b\u5bf9\u8c61\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
            log.error((Object)callResult.getErrorInfo(), (Throwable)ex);
            return callResult;
        }
        return callResult;
    }

    @Override
    protected PSModel GetObject(String strPSModelId) {
        PSModel PSModel2 = new PSModel();
        CallResult callResult = this.iPSModelHelper.getPSModel(strPSModelId, PSModel2);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u6a21\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSModelId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSModel2;
    }

    @Override
    protected IPSModel OnCreateModelHelper(PSModel vt) throws Exception {
        IPSModel iPSModel = null;
        iPSModel = StringHelper.IsNullOrEmpty((String)vt.getTYPEOBJ()) ? new PSModelImpl() : (IPSModel)ObjectHelper.Create((String)vt.getTYPEOBJ());
        iPSModel.init(this.iDAGlobalHelper, vt);
        return iPSModel;
    }

    @Override
    protected Boolean TestObjectRenew(PSModel obj) {
        return false;
    }

    @Override
    protected String getObjectId(PSModel vt) {
        return vt.getPSMODELID();
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }
}

