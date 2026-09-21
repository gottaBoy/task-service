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
package SA.SRFDA.PS.Core.Control.Grid;

import SA.SRFDA.Ctrl.BaseDAGlobalModel;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridColumnType;
import SA.SRFDA.PS.Core.Control.Grid.PSDEGridColumnTypeImpl;
import SA.SRFDA.PS.Core.IPSModelHelper;
import SA.SRFDA.PS.Core.PSObjectFactory;
import SA.SRFDA.PS.Data.PSDEGridColumnType;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEGridColumnTypeGlobalModel
extends BaseDAGlobalModel<String, PSDEGridColumnType, IPSDEGridColumnType> {
    private static final Log log = LogFactory.getLog(PSDEGridColumnTypeGlobalModel.class);
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
            callResult.setErrorInfo(StringHelper.Format((String)"\u521d\u59cb\u5316\u4e91\u5e73\u53f0\u5b9e\u4f53\u8868\u683c\u5217\u7c7b\u578b\u5168\u5c40\u6a21\u578b\u5bf9\u8c61\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
            log.error((Object)callResult.getErrorInfo(), (Throwable)ex);
            return callResult;
        }
        return callResult;
    }

    protected PSDEGridColumnType GetObject(String strPSDEGridColumnTypeId) {
        PSDEGridColumnType PSDEGridColumnType2 = new PSDEGridColumnType();
        CallResult callResult = this.iPSModelHelper.getPSDEGridColumnType(strPSDEGridColumnTypeId, PSDEGridColumnType2);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u5b9e\u4f53\u8868\u683c\u5217\u7c7b\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDEGridColumnTypeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSDEGridColumnType2;
    }

    protected IPSDEGridColumnType OnCreateModelHelper(PSDEGridColumnType vt) throws Exception {
        PSDEGridColumnTypeImpl iPSDEGridColumnType = new PSDEGridColumnTypeImpl();
        iPSDEGridColumnType.init(this.iDAGlobalHelper, vt);
        return iPSDEGridColumnType;
    }

    protected Boolean TestObjectRenew(PSDEGridColumnType obj) {
        return false;
    }
}

