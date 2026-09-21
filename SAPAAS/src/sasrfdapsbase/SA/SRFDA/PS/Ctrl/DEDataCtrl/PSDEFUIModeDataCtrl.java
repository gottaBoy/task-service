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
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSModelDEDataCtrl;
import SA.SRFDA.PS.Data.PSDEFUIModeV3;
import SA.SRFDA.PS.Data.PSDEField;
import SA.SRFramework.CommonEx.Errors;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEFUIModeDataCtrl
extends PSModelDEDataCtrl
implements IPSModelInitDataCtrl {
    private static final Log log = LogFactory.getLog(PSDEFUIModeDataCtrl.class);

    @Override
    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        if (bInsert) {
            PSDEFUIModeV3 psDEFFormItem = new PSDEFUIModeV3();
            psDEFFormItem.proxy(dataEntity);
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
                PSDEFUIModeV3 psDEFFormItem = new PSDEFUIModeV3();
                psDEFFormItem.setPSDEFFORMITEMID(psDEField.getPSDEFIELDID());
                callResult = this.Get(psDEFFormItem);
                if (Errors.IsSpecialError((int)callResult.getRetCode(), (int)3)) {
                    boolean bDefault = false;
                    psDEFFormItem.Reset();
                    psDEFFormItem.setFTMODE("DEFAULT");
                    psDEFFormItem.setPSDEFID(psDEField.getPSDEFIELDID());
                    callResult = this.Select(psDEFFormItem);
                    if (Errors.IsSpecialError((int)callResult.getRetCode(), (int)3)) {
                        bDefault = true;
                    }
                    psDEFFormItem.Reset();
                    psDEFFormItem.setPSDEFFORMITEMNAME(StringHelper.Format((String)"[%1$s][%2$s]", (Object)psDEField.getPSDEFIELDNAME(), (Object)psDEField.getLOGICNAME()));
                    psDEFFormItem.setPSDEFFORMITEMID(psDEField.getPSDEFIELDID());
                    psDEFFormItem.setPSDEFID(psDEField.getPSDEFIELDID());
                    if (bDefault) {
                        psDEFFormItem.setFTMODE("DEFAULT");
                    } else {
                        psDEFFormItem.setFTMODE("CUSTOM");
                    }
                    callResult = this.Save(true, psDEFFormItem);
                    if (callResult.isError()) {
                        throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u5b9e\u4f53\u5c5e\u6027\u9ed8\u8ba4\u8868\u5355\u9879\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
                    }
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

