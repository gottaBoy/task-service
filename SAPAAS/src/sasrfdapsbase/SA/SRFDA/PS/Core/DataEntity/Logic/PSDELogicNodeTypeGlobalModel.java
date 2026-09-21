/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAGlobalModel
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.Ctrl.BaseDAGlobalModel;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicNodeType;
import SA.SRFDA.PS.Core.DataEntity.Logic.PSDELogicNodeTypeImpl;
import SA.SRFDA.PS.Core.IPSModelHelper;
import SA.SRFDA.PS.Core.PSObjectFactory;
import SA.SRFDA.PS.Data.PSDELogicNodeType;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDELogicNodeTypeGlobalModel
extends BaseDAGlobalModel<String, PSDELogicNodeType, IPSDELogicNodeType> {
    private static final Log log = LogFactory.getLog(PSDELogicNodeTypeGlobalModel.class);
    protected IPSModelHelper iPSModelHelper = null;

    protected CallResult OnInit() {
        CallResult callResult = super.OnInit();
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            this.iPSModelHelper = PSObjectFactory.getPSModelHelper(this.iDAGlobalHelper, null);
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u521d\u59cb\u5316\u4e91\u5e73\u53f0\u5b9e\u4f53\u903b\u8f91\u8282\u70b9\u7c7b\u578b\u5168\u5c40\u6a21\u578b\u5bf9\u8c61\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
            log.error((Object)callResult.getErrorInfo(), (Throwable)ex);
            return callResult;
        }
        return callResult;
    }

    protected PSDELogicNodeType GetObject(String strPSDELogicNodeTypeId) {
        PSDELogicNodeType PSDELogicNodeType2 = new PSDELogicNodeType();
        CallResult callResult = this.iPSModelHelper.getPSDELogicNodeType(strPSDELogicNodeTypeId, PSDELogicNodeType2);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u5b9e\u4f53\u903b\u8f91\u8282\u70b9\u7c7b\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDELogicNodeTypeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSDELogicNodeType2;
    }

    protected IPSDELogicNodeType OnCreateModelHelper(PSDELogicNodeType vt) throws Exception {
        PSDELogicNodeTypeImpl iPSDELogicNodeType = new PSDELogicNodeTypeImpl();
        iPSDELogicNodeType.init(this.iDAGlobalHelper, vt);
        return iPSDELogicNodeType;
    }

    protected Boolean TestObjectRenew(PSDELogicNodeType obj) {
        return false;
    }
}

