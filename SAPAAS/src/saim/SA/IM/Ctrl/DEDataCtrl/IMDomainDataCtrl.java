/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.IM.Ctrl.DEDataCtrl;

import SA.IM.Ctrl.DEDataCtrl.IMDEDataCtrl;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class IMDomainDataCtrl
extends IMDEDataCtrl {
    private static final Log log = LogFactory.getLog(IMDomainDataCtrl.class);

    protected CallResult OnAfterRemoveOK(String strActionMode, BaseDataEntity dataEntity) {
        CallResult callResult = super.OnAfterRemoveOK(strActionMode, dataEntity);
        if (callResult.IsError()) {
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        this.ResetCodeList("CODELIST_IM0015_001");
        return callResult;
    }

    protected CallResult OnAfterSaveOK(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnAfterSaveOK(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.IsError()) {
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        this.ResetCodeList("CODELIST_IM0015_001");
        return callResult;
    }

    private void ResetCodeList(String strCodeListId) {
        this.globalHelperEx.getDAModelStorage().ResetCodeListConfig(strCodeListId);
    }
}

