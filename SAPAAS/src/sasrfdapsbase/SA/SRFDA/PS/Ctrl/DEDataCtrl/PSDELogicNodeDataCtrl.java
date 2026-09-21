/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.CommonEx.Errors
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.PS.Ctrl.DEDataCtrl.IPSModelInitDataCtrl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSModelDEDataCtrl;
import SA.SRFDA.PS.Data.PSDELogic;
import SA.SRFDA.PS.Data.PSDELogicNode;
import SA.SRFramework.CommonEx.Errors;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDELogicNodeDataCtrl
extends PSModelDEDataCtrl
implements IPSModelInitDataCtrl {
    private static final Log log = LogFactory.getLog(PSDELogicNodeDataCtrl.class);

    @Override
    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        return callResult;
    }

    @Override
    public CallResult initModel(String strDEId, BaseDataEntity dataEntity, String strMode) {
        CallResult callResult = new CallResult();
        try {
            if (StringHelper.Compare((String)strDEId, (String)"DE2083", (boolean)true) == 0) {
                PSDELogic psDELogic = new PSDELogic();
                psDELogic.proxy(dataEntity);
                PSDELogicNode psDELogicNode = new PSDELogicNode();
                psDELogicNode.setPSDELOGICNODEID(psDELogic.getPSDELOGICID());
                callResult = this.Get(psDELogicNode);
                if (Errors.IsSpecialError((int)callResult.getRetCode(), (int)3)) {
                    psDELogicNode.Reset();
                    psDELogicNode.setLOGICNODETYPE("BEGIN");
                    psDELogicNode.setPSDELOGICNODEID(psDELogic.getPSDELOGICID());
                    psDELogicNode.setPSDELOGICNODENAME("\u5f00\u59cb");
                    psDELogicNode.setCODENAME("Begin");
                    psDELogicNode.setPSDELOGICID(psDELogic.getPSDELOGICID());
                    psDELogicNode.setPARALLELOUTPUT(true);
                    callResult = this.Save(true, psDELogicNode);
                    if (callResult.isError()) {
                        throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u5b9e\u4f53\u903b\u8f91\u5f00\u59cb\u8282\u70b9\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
                    }
                }
            }
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)ex.getMessage(), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }
}

