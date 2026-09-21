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
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSModelInitStepDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSModelInitStepDataCtrl.class);

    @Override
    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        dataEntity.setParamValue("PSDENAME", dataEntity.getParamValue("DENAME"));
        if (StringHelper.IsNullOrEmpty((String)dataEntity.getParamStringValue("PSDENAME", "")) && lastDataEntity != null) {
            dataEntity.setParamValue("PSDENAME", lastDataEntity.getParamValue("DENAME"));
        }
        return super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
    }
}

