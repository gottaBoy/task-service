/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.IM.Ctrl.DEDataCtrl;

import SA.IM.Ctrl.DEDataCtrl.IMDEDataCtrl;
import SA.IM.Ctrl.Data.IMOrg;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;

public class IMOrgDataCtrl
extends IMDEDataCtrl {
    protected CallResult OnAfterSaveOK(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnAfterSaveOK(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        callResult = this.UpdateOrgVersion(dataEntity);
        return callResult;
    }

    protected CallResult OnAfterRemoveOK(String strActionMode, BaseDataEntity dataEntity) {
        CallResult callResult = super.OnAfterRemoveOK(strActionMode, dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        return this.UpdateOrgVersion(dataEntity);
    }

    private CallResult UpdateOrgVersion(BaseDataEntity dataEntity) {
        String strOrgId = dataEntity.GetParamStringValue("PIMORGID", "");
        if (StringHelper.IsNullOrEmpty((String)strOrgId)) {
            return new CallResult();
        }
        IMOrg org = new IMOrg();
        org.setIMORGID(strOrgId);
        return this.Save(false, org);
    }
}

