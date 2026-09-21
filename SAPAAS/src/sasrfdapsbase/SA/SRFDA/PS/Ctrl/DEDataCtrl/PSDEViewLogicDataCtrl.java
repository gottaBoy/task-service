/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.PS.Core.View.IPSViewLogicType;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEViewLogicDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSDEViewLogicDataCtrl.class);

    public CallResult GetDefault(ISRFDAWebContext webContext, BaseDataEntity dataEntity) {
        CallResult callResult = super.GetDefault(webContext, dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        String strPSViewLogicType = webContext.GetParamValue("PSDEVIEWLOGICTYPE");
        if (!StringHelper.IsNullOrEmpty((String)strPSViewLogicType)) {
            try {
                IPSViewLogicType iPSViewLogicType = this.getPSModelStorage().getPSViewLogicType(strPSViewLogicType);
                dataEntity.setParamValue("PSDEVIEWLOGICTYPE", (Object)strPSViewLogicType);
                dataEntity.setParamValue("PSVIEWLOGICTYPEID", (Object)strPSViewLogicType);
                dataEntity.setParamValue("PSVIEWLOGICTYPENAME", (Object)iPSViewLogicType.getName());
                dataEntity.setParamValue("PSDEVIEWLOGICNAME", (Object)iPSViewLogicType.getProcessName());
            }
            catch (Exception e) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(e.getMessage());
                return callResult;
            }
        }
        return callResult;
    }
}

