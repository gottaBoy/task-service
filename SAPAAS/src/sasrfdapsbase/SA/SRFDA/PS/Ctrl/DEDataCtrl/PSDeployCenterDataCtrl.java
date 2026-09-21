/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFramework.DataEx.BaseDataEntity;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDeployCenterDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSDeployCenterDataCtrl.class);

    @Override
    protected void onReloadModel(BaseDataEntity dataEntity) throws Exception {
        String strPSDeployCenterId = dataEntity.getParamStringValue("PSDEPLOYCENTERID", "");
        this.getPSModelStorage().resetPSDeployCenter(strPSDeployCenterId);
    }
}

