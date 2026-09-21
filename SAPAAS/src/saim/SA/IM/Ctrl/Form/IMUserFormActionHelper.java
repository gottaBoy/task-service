/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Form.BaseDAFormActionHelper
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.IM.Ctrl.Form;

import SA.SRFDA.Ctrl.Form.BaseDAFormActionHelper;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;

public class IMUserFormActionHelper
extends BaseDAFormActionHelper {
    protected void OnLoadDefaultActionAfterFillDataEntity(BaseDataEntity dataEntity) {
        super.OnLoadDefaultActionAfterFillDataEntity(dataEntity);
        String strPIMOrgId = this.getWebContext().GetParamValue("N_PIMORGID_EQ");
        if (StringHelper.IsNullOrEmpty((String)strPIMOrgId)) {
            strPIMOrgId = this.getWebContext().GetParamValue("PIMORGID");
        }
        if (StringHelper.IsNullOrEmpty((String)strPIMOrgId)) {
            return;
        }
        IDEDataCtrl iDEDataCtrl = this.getPage().GetDEDataCtrl("IM0067");
        BaseDataEntity pde = new BaseDataEntity();
        pde.SetParamValue("IMORGID", (Object)strPIMOrgId);
        CallResult callResult = iDEDataCtrl.Get(pde);
        if (callResult.IsOk()) {
            dataEntity.SetParamValue("IMORGID", (Object)strPIMOrgId);
            dataEntity.SetParamValue("IMORGNAME", pde.GetParamValue("IMORGNAME"));
        }
    }
}

