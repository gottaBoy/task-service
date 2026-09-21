/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.CommonEx.Errors
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.IPSModelInitDataCtrl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSModelDEDataCtrl;
import SA.SRFDA.PS.Data.PSDEField;
import SA.SRFDA.PS.Data.PSDataEntity;
import SA.SRFramework.CommonEx.Errors;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEFieldDataCtrl
extends PSModelDEDataCtrl
implements IPSModelInitDataCtrl {
    private static final Log log = LogFactory.getLog(PSDEFieldDataCtrl.class);
    public static final String CUSTOMCALL_MAKEREALMODE = "MAKEREALMODE";
    public static final String CUSTOMCALL_MAKELINKMODE = "MAKELINKMODE";

    @Override
    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        try {
            if (bInsert) {
                PSDEField psDEField = new PSDEField();
                psDEField.proxy(dataEntity);
                PSDataEntity psDataEntity = new PSDataEntity();
                psDataEntity.setPSDATAENTITYID(psDEField.getPSDEID());
                IDEDataCtrl psDataEntityDataCtrl = this.GetRelatedDataCtrl("DE2050");
                callResult = psDataEntityDataCtrl.Get((BaseDataEntity)psDataEntity);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u4e91\u5b9e\u4f53\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                String strPSDEFIELDNAME = psDEField.getPSDEFIELDNAME().toUpperCase();
                psDEField.setPSDEFIELDNAME(strPSDEFIELDNAME);
                psDEField.setPSDEFIELDID(Helper.GenUniqueId((String)psDEField.getPSDEID(), (String)strPSDEFIELDNAME));
                if (psDEField.getDEFTYPE() == 1) {
                    psDEField.setPHYSICALFIELD(true);
                    psDEField.setTABLENAME(psDataEntity.getTABLENAME());
                } else {
                    psDEField.setPHYSICALFIELD(false);
                }
            }
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
        return callResult;
    }

    @Override
    protected CallResult OnAfterSaveOK(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnAfterSaveOK(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        if (bInsert) {
            PSDataEntity psDataEntity = new PSDataEntity();
            psDataEntity.proxy(dataEntity);
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
            if (StringHelper.Compare((String)strDEId, (String)"DE2050", (boolean)true) == 0) {
                PSDataEntity psDataEntity = new PSDataEntity();
                psDataEntity.proxy(dataEntity);
                if (!psDataEntity.getEXISTINGMODEL()) {
                    String strDEName = psDataEntity.getPSDATAENTITYNAME();
                    String strDELogicName = psDataEntity.getLOGICNAME();
                    PSDEField base_id = new PSDEField();
                    base_id.setPSDEFIELDNAME(StringHelper.Format((String)"%1$sID", (Object)strDEName));
                    base_id.setLOGICNAME(StringHelper.Format((String)"%1$s\u6807\u8bc6", (Object)strDELogicName));
                    base_id.setPSDATATYPEID("GUID");
                    base_id.setPSDEID(psDataEntity.getPSDATAENTITYID());
                    base_id.setPSDEFIELDID(Helper.GenUniqueId((String)base_id.getPSDEID(), (String)base_id.getPSDEFIELDNAME()));
                    callResult = this.Get(base_id);
                    if (Errors.IsSpecialError((int)callResult.getRetCode(), (int)3)) {
                        base_id.setTABLENAME(psDataEntity.getTABLENAME());
                        base_id.setDEFTYPE(1);
                        base_id.setALLOWEMPTY(false);
                        base_id.setLENGTH(100);
                        base_id.setMAJORFIELD(0);
                        base_id.setPKEY(1);
                        callResult = this.Save(true, base_id);
                        if (callResult.getRetCode() != 0) {
                            throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u5c5e\u6027\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                        }
                    }
                    PSDEField base_name = new PSDEField();
                    base_name.setPSDEFIELDNAME(StringHelper.Format((String)"%1$sNAME", (Object)strDEName));
                    base_name.setLOGICNAME(StringHelper.Format((String)"%1$s\u540d\u79f0", (Object)strDELogicName));
                    base_name.setTABLENAME(psDataEntity.getTABLENAME());
                    base_name.setDEFTYPE(1);
                    base_name.setPSDATATYPEID("TEXT");
                    base_name.setLENGTH(200);
                    base_name.setALLOWEMPTY(false);
                    base_name.setPSDEID(psDataEntity.getPSDATAENTITYID());
                    base_name.setPSDEFIELDID(Helper.GenUniqueId((String)base_name.getPSDEID(), (String)base_name.getPSDEFIELDNAME()));
                    callResult = this.Get(base_name);
                    if (Errors.IsSpecialError((int)callResult.getRetCode(), (int)3)) {
                        base_name.setMAJORFIELD(1);
                        base_name.setPKEY(0);
                        callResult = this.Save(true, base_name);
                        if (callResult.getRetCode() != 0) {
                            throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u5c5e\u6027\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                        }
                    }
                    if (psDataEntity.getLOGICVALID()) {
                        PSDEField validflag = new PSDEField();
                        validflag.setPSDEFIELDNAME("ENABLE");
                        validflag.setPSDEID(psDataEntity.getPSDATAENTITYID());
                        validflag.setLOGICNAME("\u903b\u8f91\u6709\u6548\u6807\u5fd7");
                        validflag.setTABLENAME(psDataEntity.getTABLENAME());
                        validflag.setDEFTYPE(1);
                        validflag.setALLOWEMPTY(false);
                        validflag.setPSDATATYPEID("YESNO");
                        validflag.setLENGTH(8);
                        validflag.setMAJORFIELD(0);
                        validflag.setPKEY(0);
                        validflag.setPSDEFIELDID(Helper.GenUniqueId((String)validflag.getPSDEID(), (String)validflag.getPSDEFIELDNAME()));
                        callResult = this.Get(validflag);
                        if (Errors.IsSpecialError((int)callResult.getRetCode(), (int)3) && (callResult = this.Save(true, validflag)).getRetCode() != 0) {
                            throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u5c5e\u6027\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                        }
                    }
                    PSDEField createman = new PSDEField();
                    createman.setPSDEFIELDNAME(StringHelper.Format((String)"CREATEMAN", (Object)strDEName));
                    createman.setPSDEID(psDataEntity.getPSDATAENTITYID());
                    createman.setLOGICNAME("\u5efa\u7acb\u4eba");
                    createman.setTABLENAME(psDataEntity.getTABLENAME());
                    createman.setDEFTYPE(1);
                    createman.setALLOWEMPTY(false);
                    createman.setPSDATATYPEID("TEXT");
                    createman.setLENGTH(60);
                    createman.setMAJORFIELD(0);
                    createman.setPKEY(0);
                    createman.setPSDEFIELDID(Helper.GenUniqueId((String)createman.getPSDEID(), (String)createman.getPSDEFIELDNAME()));
                    callResult = this.Get(createman);
                    if (Errors.IsSpecialError((int)callResult.getRetCode(), (int)3) && (callResult = this.Save(true, createman)).getRetCode() != 0) {
                        throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u5c5e\u6027\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                    PSDEField createdate = new PSDEField();
                    createdate.setPSDEFIELDNAME(StringHelper.Format((String)"CREATEDATE", (Object)strDEName));
                    createdate.setPSDEID(psDataEntity.getPSDATAENTITYID());
                    createdate.setLOGICNAME("\u5efa\u7acb\u65f6\u95f4");
                    createdate.setTABLENAME(psDataEntity.getTABLENAME());
                    createdate.setDEFTYPE(1);
                    createdate.setALLOWEMPTY(false);
                    createdate.setPSDATATYPEID("DATETIME");
                    createdate.setLENGTH(8);
                    createdate.setMAJORFIELD(0);
                    createdate.setPKEY(0);
                    createdate.setPSDEFIELDID(Helper.GenUniqueId((String)createdate.getPSDEID(), (String)createdate.getPSDEFIELDNAME()));
                    callResult = this.Get(createdate);
                    if (Errors.IsSpecialError((int)callResult.getRetCode(), (int)3) && (callResult = this.Save(true, createdate)).getRetCode() != 0) {
                        throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u5c5e\u6027\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                    PSDEField updateman = new PSDEField();
                    updateman.setPSDEFIELDNAME(StringHelper.Format((String)"UPDATEMAN", (Object)strDEName));
                    updateman.setPSDEID(psDataEntity.getPSDATAENTITYID());
                    updateman.setLOGICNAME("\u66f4\u65b0\u4eba");
                    updateman.setTABLENAME(psDataEntity.getTABLENAME());
                    updateman.setDEFTYPE(1);
                    updateman.setALLOWEMPTY(false);
                    updateman.setPSDATATYPEID("TEXT");
                    updateman.setLENGTH(60);
                    updateman.setMAJORFIELD(0);
                    updateman.setPKEY(0);
                    updateman.setPSDEFIELDID(Helper.GenUniqueId((String)updateman.getPSDEID(), (String)updateman.getPSDEFIELDNAME()));
                    callResult = this.Get(updateman);
                    if (Errors.IsSpecialError((int)callResult.getRetCode(), (int)3) && (callResult = this.Save(true, updateman)).getRetCode() != 0) {
                        throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u5c5e\u6027\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                    PSDEField updatedate = new PSDEField();
                    updatedate.setPSDEFIELDNAME(StringHelper.Format((String)"UPDATEDATE", (Object)strDEName));
                    updatedate.setPSDEID(psDataEntity.getPSDATAENTITYID());
                    updatedate.setLOGICNAME("\u66f4\u65b0\u65f6\u95f4");
                    updatedate.setTABLENAME(psDataEntity.getTABLENAME());
                    updatedate.setDEFTYPE(1);
                    updatedate.setALLOWEMPTY(false);
                    updatedate.setPSDATATYPEID("DATETIME");
                    updatedate.setLENGTH(8);
                    updatedate.setMAJORFIELD(0);
                    updatedate.setPKEY(0);
                    updatedate.setPSDEFIELDID(Helper.GenUniqueId((String)updatedate.getPSDEID(), (String)updatedate.getPSDEFIELDNAME()));
                    callResult = this.Get(updatedate);
                    if (Errors.IsSpecialError((int)callResult.getRetCode(), (int)3) && (callResult = this.Save(true, updatedate)).getRetCode() != 0) {
                        throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u5c5e\u6027\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
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

    @Override
    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_MAKEREALMODE, (boolean)true) == 0) {
            return this.makeRealMode(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_MAKELINKMODE, (boolean)true) == 0) {
            return this.makeLinkMode(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult makeRealMode(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            PSDEField psDEField = new PSDEField();
            psDEField.proxy(dataEntity);
            if (psDEField.getPHYSICALFIELD()) {
                return callResult;
            }
            if (StringHelper.Compare((String)psDEField.getPSDATATYPEID(), (String)"PICKUPDATA", (boolean)true) == 0 || StringHelper.Compare((String)psDEField.getPSDATATYPEID(), (String)"PICKUPTEXT", (boolean)true) == 0) {
                PSDataEntity psDataEntity = new PSDataEntity();
                IDEDataCtrl psDataEntityDataCtrl = this.GetRelatedDataCtrl("DE2050");
                psDataEntity.setPSDATAENTITYID(psDEField.getPSDEID());
                callResult = psDataEntityDataCtrl.Get((BaseDataEntity)psDataEntity);
                if (callResult.isError()) {
                    return callResult;
                }
                psDEField.setPHYSICALFIELD(true);
                psDEField.setDEFTYPE(1);
                psDEField.setTABLENAME(psDataEntity.getTABLENAME());
                return this.Save(false, psDEField);
            }
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u8bbe\u7f6e\u5c5e\u6027\u7269\u7406\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    public CallResult makeLinkMode(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            PSDEField psDEField = new PSDEField();
            psDEField.proxy(dataEntity);
            if (!psDEField.getPHYSICALFIELD()) {
                return callResult;
            }
            if (StringHelper.Compare((String)psDEField.getPSDATATYPEID(), (String)"PICKUPDATA", (boolean)true) == 0 || StringHelper.Compare((String)psDEField.getPSDATATYPEID(), (String)"PICKUPTEXT", (boolean)true) == 0) {
                psDEField.setPHYSICALFIELD(false);
                psDEField.setDEFTYPE(3);
                psDEField.setTABLENAME(null);
                return this.Save(false, psDEField);
            }
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u53d6\u6d88\u5c5e\u6027\u7269\u7406\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }
}

