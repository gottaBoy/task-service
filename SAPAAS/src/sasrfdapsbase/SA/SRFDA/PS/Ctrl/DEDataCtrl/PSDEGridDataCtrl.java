/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.CommonEx.Errors
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.PS.Ctrl.DEDataCtrl.IPSModelInitDataCtrl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.PS.Data.PSDEGrid;
import SA.SRFDA.PS.Data.PSDataEntity;
import SA.SRFramework.CommonEx.Errors;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEGridDataCtrl
extends PSDEDataCtrl
implements IPSModelInitDataCtrl {
    private static final Log log = LogFactory.getLog(PSDEGridDataCtrl.class);

    @Override
    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        return callResult;
    }

    @Override
    public CallResult initModel(String strDEId, BaseDataEntity dataEntity, String strMode) {
        CallResult callResult = new CallResult();
        try {
            if (StringHelper.Compare((String)strDEId, (String)"DE2050", (boolean)true) == 0) {
                PSDataEntity psDataEntity = new PSDataEntity();
                psDataEntity.proxy(dataEntity);
                this.initDefaultGrid(psDataEntity);
                return callResult;
            }
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)ex.getMessage(), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void initDefaultGrid(PSDataEntity psDataEntity) throws Exception {
        String strDefaultGridId = psDataEntity.getPSDATAENTITYID();
        PSDEGrid psDEGrid = new PSDEGrid();
        psDEGrid.setPSDEGRIDID(strDefaultGridId);
        CallResult callResult = this.Get(psDEGrid);
        if (Errors.IsSpecialError((int)callResult.getRetCode(), (int)3)) {
            psDEGrid.setPSDEGRIDID(strDefaultGridId);
            psDEGrid.setPSDEID(psDataEntity.getPSDATAENTITYID());
            psDEGrid.setCODENAME("Main");
            psDEGrid.setPSDEGRIDNAME("\u4e3b\u8868\u683c");
            psDEGrid.setENABLEPAGINGBAR(1);
            psDEGrid.setPAGINGSIZE(20);
            callResult = this.Save(true, psDEGrid);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u521d\u59cb\u5316\u4e3b\u8868\u683c\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
        }
    }
}

