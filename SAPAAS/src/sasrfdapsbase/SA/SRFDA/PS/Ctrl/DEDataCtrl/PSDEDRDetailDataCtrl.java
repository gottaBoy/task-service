/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.PS.Data.PSDEDRDetail;
import SA.SRFDA.PS.Data.PSDEDataRelation;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEDRDetailDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSDEDRDetailDataCtrl.class);

    @Override
    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        PSDEDRDetail psDEDRDetail = new PSDEDRDetail();
        psDEDRDetail.proxy(dataEntity);
        return callResult;
    }

    public CallResult GetDefault(ISRFDAWebContext webContext, BaseDataEntity dataEntity) {
        CallResult callResult = super.GetDefault(webContext, dataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        try {
            String strPSDEDRIdId = this.getWebContext().GetParamValue("PSDEDATARELATIONID");
            if (!StringHelper.IsNullOrEmpty((String)strPSDEDRIdId)) {
                IDEDataCtrl psDEDRDataCtrl = this.GetRelatedDataCtrl("DE2081");
                PSDEDataRelation psDEDataRelation = new PSDEDataRelation();
                psDEDataRelation.setPSDEDATARELATIONID(strPSDEDRIdId);
                callResult = psDEDRDataCtrl.Get((BaseDataEntity)psDEDataRelation);
                if (callResult.isError()) {
                    return callResult;
                }
                dataEntity.setParamValue("PSDEDRID", (Object)psDEDataRelation.getPSDEDATARELATIONID());
                dataEntity.setParamValue("PSDEID", (Object)psDEDataRelation.getPSDEID());
            }
        }
        catch (Exception e) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
            return callResult;
        }
        return callResult;
    }
}

