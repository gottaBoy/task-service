/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.IPSModelInitDataCtrl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSModelDEDataCtrl;
import SA.SRFDA.PS.Data.PSDEFDTColumnV3;
import SA.SRFDA.PS.Data.PSDEField;
import SA.SRFDA.PS.Data.PSDataEntity;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import java.util.Iterator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEFDTColumnDataCtrl
extends PSModelDEDataCtrl
implements IPSModelInitDataCtrl {
    private static final Log log = LogFactory.getLog(PSDEFDTColumnDataCtrl.class);

    @Override
    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        if (bInsert) {
            PSDEFDTColumnV3 psDEFDTColumn = new PSDEFDTColumnV3();
            psDEFDTColumn.proxy(dataEntity);
            String strPSDEFNAME = psDEFDTColumn.getPSDEFNAME().toUpperCase();
            psDEFDTColumn.setPSDEFDTCOLNAME(strPSDEFNAME);
            psDEFDTColumn.setPSDEFDTCOLID(Helper.GenUniqueId((String)psDEFDTColumn.getPSDEFID(), (String)psDEFDTColumn.getDBTYPE()));
        }
        return callResult;
    }

    @Override
    protected CallResult OnAfterSaveOK(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnAfterSaveOK(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        return callResult;
    }

    protected CallResult OnBeforeRemove(String strActionMode, BaseDataEntity dataEntity) {
        return super.OnBeforeRemove(strActionMode, dataEntity);
    }

    protected CallResult OnAfterRemoveOK(String strActionMode, BaseDataEntity dataEntity) {
        return super.OnAfterRemoveOK(strActionMode, dataEntity);
    }

    @Override
    public CallResult initModel(String strDEId, BaseDataEntity dataEntity, String strMode) {
        CallResult callResult = new CallResult();
        try {
            if (StringHelper.Compare((String)strDEId, (String)"DE2051", (boolean)true) == 0) {
                PSDEField psDEField = new PSDEField();
                psDEField.proxy(dataEntity);
                PSDataEntity psDataEntity = new PSDataEntity();
                psDataEntity.setPSDATAENTITYID(psDEField.getPSDEID());
                IDEDataCtrl psDataEntityDataCtrl = this.GetRelatedDataCtrl("DE2050");
                callResult = psDataEntityDataCtrl.Get((BaseDataEntity)psDataEntity);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
                }
                IPSSystem iPSSystem = this.getPSModelStorage().getPSSystem(psDataEntity.getPSSYSTEMID());
                Iterator<String> dbTypes = iPSSystem.getSupportDBTypes();
                while (dbTypes.hasNext()) {
                    String strDBType = dbTypes.next();
                    PSDEFDTColumnV3 psDEFDTColumn = new PSDEFDTColumnV3();
                    psDEFDTColumn.setPSDEFID(psDEField.getPSDEFIELDID());
                    psDEFDTColumn.setPSDEFNAME(psDEField.getPSDEFIELDNAME());
                    psDEFDTColumn.setPSDEFDTCOLNAME(psDEField.getPSDEFIELDNAME().toUpperCase());
                    psDEFDTColumn.setDBTYPE(strDBType);
                    psDEFDTColumn.setPSDEFDTCOLID(Helper.GenUniqueId((String)psDEFDTColumn.getPSDEFID(), (String)psDEFDTColumn.getDBTYPE()));
                    callResult = this.AutoSave(psDEFDTColumn);
                    if (!callResult.isError()) continue;
                    throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u5b9e\u4f53\u5c5e\u6027\u6570\u636e\u5e93\u5b57\u6bb5\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
                }
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
}

