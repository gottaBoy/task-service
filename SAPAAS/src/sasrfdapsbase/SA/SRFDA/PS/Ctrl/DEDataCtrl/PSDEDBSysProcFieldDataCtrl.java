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
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.PS.Data.PSDEDBSysProcField;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEDBSysProcFieldDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSDEDBSysProcFieldDataCtrl.class);

    @Override
    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        if (bInsert) {
            try {
                PSDEDBSysProcField psDESysProcField = new PSDEDBSysProcField();
                psDESysProcField.proxy(dataEntity);
                String strPSDEDBSysProcFieldName = StringHelper.Format((String)"%1$s/%2$s", (Object)psDESysProcField.getPSDESYSPROCNAME(), (Object)psDESysProcField.getPSDEFNAME());
                psDESysProcField.setPSDESPFIELDNAME(strPSDEDBSysProcFieldName);
            }
            catch (Exception ex) {
                log.error((Object)ex.getMessage(), (Throwable)ex);
                callResult.setRetCode(1);
                callResult.setErrorInfo(ex.getMessage());
                return callResult;
            }
        }
        return callResult;
    }
}

