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
import SA.SRFDA.PS.Data.PSDEGridColumn;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEGridColumnDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSDEGridColumnDataCtrl.class);

    @Override
    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        if (bInsert) {
            PSDEGridColumn psDEGridColumn = new PSDEGridColumn();
            psDEGridColumn.proxy(dataEntity);
            String strPSDEGRIDCOLNAME = psDEGridColumn.getPSDEGRIDCOLNAME();
            if (StringHelper.IsNullOrEmpty((String)strPSDEGRIDCOLNAME) && StringHelper.Compare((String)psDEGridColumn.getGRIDCOLTYPE(), (String)"DEFGRIDCOLUMN", (boolean)true) == 0) {
                psDEGridColumn.setPSDEGRIDCOLNAME(psDEGridColumn.getPSDEFNAME());
            }
        }
        return callResult;
    }
}

