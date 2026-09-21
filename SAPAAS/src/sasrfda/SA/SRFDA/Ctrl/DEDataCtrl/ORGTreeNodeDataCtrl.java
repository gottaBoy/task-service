/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.Data.ORGUnit;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ORGTreeNodeDataCtrl
extends BaseDEDataCtrl {
    private static final Log log = LogFactory.getLog(ORGTreeNodeDataCtrl.class);

    @Override
    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            String strORGUnitId = dataEntity.GetParamStringValue("ORGUNITID", "");
            if (!StringHelper.IsNullOrEmpty((String)strORGUnitId)) {
                String strORGUnitName = dataEntity.GetParamStringValue("ORGUNITNAME", "");
                if (StringHelper.IsNullOrEmpty((String)strORGUnitName)) {
                    IDEDataCtrl orgUnitDataCtrl = this.GetRelatedDataCtrl("ORG0010");
                    ORGUnit orgUnit = new ORGUnit();
                    orgUnit.setORGUNITID(strORGUnitId);
                    callResult = orgUnitDataCtrl.Get(orgUnit);
                    if (callResult.IsError()) {
                        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u7ec4\u7ec7\u5355\u5143[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strORGUnitId, (Object)callResult.getErrorInfo()));
                        return callResult;
                    }
                    strORGUnitName = orgUnit.getORGUNITNAME();
                }
                dataEntity.SetParamValue("ORGTREENODENAME", (Object)strORGUnitName);
            }
        }
        catch (Exception ex) {
            log.error((Object)ex.getMessage(), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
        return callResult;
    }
}

