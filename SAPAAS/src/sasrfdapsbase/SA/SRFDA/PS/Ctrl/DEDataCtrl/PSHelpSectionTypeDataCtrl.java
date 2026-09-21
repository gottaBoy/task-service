/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.PS.Core.Help.IPSHelpSectionType;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSHelpSectionTypeDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSHelpSectionTypeDataCtrl.class);

    @Override
    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        return callResult;
    }

    @Override
    protected void onReloadModel(BaseDataEntity dataEntity) throws Exception {
        String strPSHelpSectionTypeId = dataEntity.getParamStringValue("PSHELPSECTIONTYPEID", "");
        this.getPSModelStorage().resetPSHelpSectionType(strPSHelpSectionTypeId);
        IPSHelpSectionType iPSHelpSectionType = this.getPSModelStorage().getPSHelpSectionType(strPSHelpSectionTypeId);
    }
}

