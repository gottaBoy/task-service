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
import SA.SRFDA.PS.Data.PSSFStyleParam;
import SA.SRFramework.DataEx.BaseDataEntity;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSFStyleParamDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSSFStyleParamDataCtrl.class);

    @Override
    protected void onReloadModel(BaseDataEntity dataEntity) throws Exception {
        PSSFStyleParam psSFStyleParam = new PSSFStyleParam();
        psSFStyleParam.proxy(dataEntity);
        this.getPSModelStorage().getPSSF(psSFStyleParam.getPSSFID()).resetPSSFStyleParam(psSFStyleParam.getPSSFSTYLEPARAMID());
    }
}

