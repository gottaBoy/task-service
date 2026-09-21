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
package SA.SRFDA.ND.Ctrl;

import SA.SRFDA.Ctrl.BaseDAGlobalModel;
import SA.SRFDA.ND.Ctrl.INDDiskOwnerTypeHelper;
import SA.SRFDA.ND.Ctrl.INDModelHelper;
import SA.SRFDA.ND.Ctrl.INDModelStorage;
import SA.SRFDA.ND.Ctrl.NDDiskOwnerTypeHelper;
import SA.SRFDA.ND.Ctrl.NDModelHelperFactory;
import SA.SRFDA.ND.Ctrl.NDModelStorageFactory;
import SA.SRFDA.ND.Data.NDDiskOwnerType;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class NDDiskOwnerTypeGlobalModel
extends BaseDAGlobalModel<String, NDDiskOwnerType, INDDiskOwnerTypeHelper> {
    private static final Log log = LogFactory.getLog(NDDiskOwnerTypeGlobalModel.class);
    protected INDModelHelper iNDModelHelper = null;
    protected INDModelStorage iNDModelStorage = null;

    protected CallResult OnInit() {
        CallResult callResult = super.OnInit();
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            this.iNDModelHelper = NDModelHelperFactory.Create(this.iDAGlobalHelper);
            this.iNDModelStorage = NDModelStorageFactory.Create(this.iDAGlobalHelper);
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u521d\u59cb\u5316\u7f51\u76d8\u6240\u6709\u8005\u7c7b\u578b\u5168\u5c40\u6a21\u578b\u5bf9\u8c61\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
            log.error((Object)callResult.getErrorInfo(), (Throwable)ex);
            return callResult;
        }
        return callResult;
    }

    protected NDDiskOwnerType GetObject(String strNDDiskOwnerTypeId) {
        NDDiskOwnerType ndDiskOwnerType = new NDDiskOwnerType();
        CallResult callResult = this.iNDModelHelper.GetNDDiskOwnerType(strNDDiskOwnerTypeId, ndDiskOwnerType);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7f51\u76d8\u6240\u6709\u8005\u7c7b\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strNDDiskOwnerTypeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return ndDiskOwnerType;
    }

    protected INDDiskOwnerTypeHelper OnCreateModelHelper(NDDiskOwnerType vt) throws Exception {
        INDDiskOwnerTypeHelper iNDDiskOwnerTypeHelper = null;
        iNDDiskOwnerTypeHelper = StringHelper.IsNullOrEmpty((String)vt.getTYPEHELPER()) ? new NDDiskOwnerTypeHelper() : (INDDiskOwnerTypeHelper)ObjectHelper.Create((String)vt.getTYPEHELPER());
        iNDDiskOwnerTypeHelper.Init(this.iDAGlobalHelper, vt);
        return iNDDiskOwnerTypeHelper;
    }

    protected Boolean TestObjectRenew(NDDiskOwnerType obj) {
        return false;
    }
}

