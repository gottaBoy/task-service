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
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicLinkCondType;
import SA.SRFDA.PS.Core.DataEntity.Logic.PSDELogicLinkCondTypeImpl;
import SA.SRFDA.PS.Core.IPSModelHelper;
import SA.SRFDA.PS.Core.PSObjectFactory;
import SA.SRFDA.PS.Data.PSDELogicLinkCondType;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDELogicLinkCondTypeGlobalModel
extends BaseDAGlobalModel<String, PSDELogicLinkCondType, IPSDELogicLinkCondType> {
    private static final Log log = LogFactory.getLog(PSDELogicLinkCondTypeGlobalModel.class);
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
            callResult.setErrorInfo(StringHelper.Format((String)"\u521d\u59cb\u5316\u4e91\u5e73\u53f0\u5b9e\u4f53\u903b\u8f91\u8fde\u63a5\u6761\u4ef6\u7c7b\u578b\u5168\u5c40\u6a21\u578b\u5bf9\u8c61\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
            log.error((Object)callResult.getErrorInfo(), (Throwable)ex);
            return callResult;
        }
        return callResult;
    }

    protected PSDELogicLinkCondType GetObject(String strPSDELogicLinkCondTypeId) {
        PSDELogicLinkCondType PSDELogicLinkCondType2 = new PSDELogicLinkCondType();
        CallResult callResult = this.iPSModelHelper.getPSDELogicLinkCondType(strPSDELogicLinkCondTypeId, PSDELogicLinkCondType2);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u5b9e\u4f53\u903b\u8f91\u8fde\u63a5\u6761\u4ef6\u7c7b\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDELogicLinkCondTypeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSDELogicLinkCondType2;
    }

    protected IPSDELogicLinkCondType OnCreateModelHelper(PSDELogicLinkCondType vt) throws Exception {
        PSDELogicLinkCondTypeImpl iPSDELogicLinkCondType = new PSDELogicLinkCondTypeImpl();
        iPSDELogicLinkCondType.init(this.iDAGlobalHelper, vt);
        return iPSDELogicLinkCondType;
    }

    protected Boolean TestObjectRenew(PSDELogicLinkCondType obj) {
        return false;
    }
}

