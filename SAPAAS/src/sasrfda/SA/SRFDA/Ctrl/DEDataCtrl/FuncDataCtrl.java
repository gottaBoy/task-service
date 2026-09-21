/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.XML.XMLNode
 */
package SA.SRFDA.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.Data.Func;
import SA.SRFDA.Ctrl.Data.Module;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.XML.XMLNode;
import java.util.Vector;

public class FuncDataCtrl
extends BaseDEDataCtrl {
    @Override
    protected CallResult OnExport(BaseDataEntity baseDataEntity, Vector<XMLNode> list, boolean bFrameOnly) {
        CallResult callResult = new CallResult();
        Func func = new Func();
        func.Proxy(baseDataEntity);
        if (!StringHelper.IsNullOrEmpty((String)func.getMODULE_ID())) {
            Module module = new Module();
            module.setMODULE_ID(func.getMODULE_ID());
            IDEDataCtrl iModuleDataCtrl = this.globalHelperEx.getDAModelStorage().FindDEDataCtrlEx("DE0012", this);
            if (iModuleDataCtrl == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0012"));
                return callResult;
            }
            callResult = iModuleDataCtrl.Export(module, list, true, bFrameOnly);
            if (callResult.IsError()) {
                return callResult;
            }
        }
        return super.OnExport(baseDataEntity, list, bFrameOnly);
    }
}

