/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAGlobalModel
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.WT.Ctrl;

import SA.SRFDA.Ctrl.BaseDAGlobalModel;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.WT.Ctrl.IWTAccountHelper;
import SA.WT.Ctrl.IWTModelHelper;
import SA.WT.Ctrl.IWTModelStorage;
import SA.WT.Ctrl.IWTServiceHelper;
import SA.WT.Ctrl.WTModelHelperFactory;
import SA.WT.Ctrl.WTModelStorageFactory;
import SA.WT.Data.WTServiceBase;
import java.util.Hashtable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class WTServiceGlobalModel
extends BaseDAGlobalModel<String, WTServiceBase, IWTServiceHelper> {
    private static final Log log = LogFactory.getLog(WTServiceGlobalModel.class);
    protected IWTModelHelper iWTModelHelper = null;
    protected IWTModelStorage iWTModelStorage = null;
    protected Hashtable<String, String> serviceCodeMap = new Hashtable();

    protected CallResult OnInit() {
        CallResult callResult = super.OnInit();
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            this.iWTModelHelper = WTModelHelperFactory.Create(this.iDAGlobalHelper);
            this.iWTModelStorage = WTModelStorageFactory.Create(this.iDAGlobalHelper);
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u521d\u59cb\u5316WT\u670d\u52a1\u5168\u5c40\u6a21\u578b\u5bf9\u8c61\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
            log.error((Object)callResult.getErrorInfo(), (Throwable)ex);
            return callResult;
        }
        return callResult;
    }

    protected WTServiceBase GetObject(String strWTServiceBaseId) {
        WTServiceBase wtServiceBase = new WTServiceBase();
        CallResult callResult = this.iWTModelHelper.GetWTServiceBase(strWTServiceBaseId, wtServiceBase);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9aWT\u670d\u52a1[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strWTServiceBaseId, (Object)callResult.getErrorInfo()));
            return null;
        }
        this.serviceCodeMap.put(wtServiceBase.getSERVICECODE(), wtServiceBase.getWTSERVICEBASEID());
        return wtServiceBase;
    }

    protected IWTServiceHelper OnCreateModelHelper(WTServiceBase vt) throws Exception {
        IWTServiceHelper iWTServiceHelper = null;
        iWTServiceHelper = StringHelper.IsNullOrEmpty((String)vt.getSERVICEHELPER()) ? this.iWTModelStorage.FindWTServiceType(vt.getWTSERVICEBASETYPE()).CreateWTServiceHelper() : (IWTServiceHelper)ObjectHelper.Create((String)vt.getSERVICEHELPER());
        IWTAccountHelper iWTAccountHelper = this.iWTModelStorage.FindWTAccount(vt.getWTACCOUNTID());
        iWTServiceHelper.Init(this.iDAGlobalHelper, iWTAccountHelper, vt);
        return iWTServiceHelper;
    }

    protected Boolean TestObjectRenew(WTServiceBase obj) {
        if (this.iDAGlobalHelper.getDAModelStorage().GetDAModelVersion("WT0040", (Object)obj.getWTSERVICEBASEID()) == obj.getVERSION()) {
            return false;
        }
        return true;
    }

    public IWTServiceHelper FindWTServiceByCode(String strWTServiceCode) throws Exception {
        String strWTServiceId = this.serviceCodeMap.get(strWTServiceCode);
        if (!StringHelper.IsNullOrEmpty((String)strWTServiceId)) {
            return (IWTServiceHelper)this.FindModelHelper(strWTServiceId);
        }
        WTServiceBase wtServiceBase = new WTServiceBase();
        CallResult callResult = this.iWTModelHelper.GetWTServiceBaseByCode(strWTServiceCode, wtServiceBase);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9aWT\u670d\u52a1[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strWTServiceCode, (Object)callResult.getErrorInfo()));
        }
        this.serviceCodeMap.put(wtServiceBase.getSERVICECODE(), wtServiceBase.getWTSERVICEBASEID());
        return (IWTServiceHelper)this.FindModelHelper(wtServiceBase.getWTSERVICEBASEID(), wtServiceBase);
    }
}
