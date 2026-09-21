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
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.Database.IPSDBSysProcTempl;
import SA.SRFDA.PS.Core.Database.IPSDBType;
import SA.SRFDA.PS.Core.Pub.IPSDBSysProcCodePublisher;
import SA.SRFDA.PS.Core.Pub.PSPublishContextImpl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.IPSModelInitDataCtrl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSModelDEDataCtrl;
import SA.SRFDA.PS.Data.PSDEDBSysProc;
import SA.SRFDA.PS.Data.PSDEDBSysProcField;
import SA.SRFDA.PS.Data.PSDataEntity;
import SA.SRFramework.CommonEx.Errors;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import java.util.Iterator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEDBSysProcDataCtrl
extends PSModelDEDataCtrl
implements IPSModelInitDataCtrl {
    private static final Log log = LogFactory.getLog(PSDEDBSysProcDataCtrl.class);
    public static final String CUSTOMCALL_GENERATECODE = "GENERATECODE";
    public static final String CUSTOMCALL_SYNCDEFIELD = "SYNCDEFIELD";
    public static final String[] SysProcTypes = new String[]{"INSERT", "UPDATE", "DELETE", "GET"};

    @Override
    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        if (bInsert) {
            try {
                PSDEDBSysProc psDESysProc = new PSDEDBSysProc();
                psDESysProc.proxy(dataEntity);
                PSDataEntity psDataEntity = new PSDataEntity();
                IDEDataCtrl psDataEntityDataCtrl = this.GetRelatedDataCtrl("DE2050");
                psDataEntity.setPSDATAENTITYID(psDESysProc.getPSDEID());
                callResult = psDataEntityDataCtrl.Get((BaseDataEntity)psDataEntity);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u4e91\u5b9e\u4f53\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                String strProcName = String.valueOf(psDataEntity.getSYSTEMFLAG() ? "SP_" : "P_") + psDataEntity.getPSDATAENTITYNAME();
                if (StringHelper.Compare((String)psDESysProc.getSYSPROCTYPE(), (String)"INSERT", (boolean)true) == 0) {
                    strProcName = String.valueOf(strProcName) + "_I";
                } else if (StringHelper.Compare((String)psDESysProc.getSYSPROCTYPE(), (String)"UPDATE", (boolean)true) == 0) {
                    strProcName = String.valueOf(strProcName) + "_U";
                } else if (StringHelper.Compare((String)psDESysProc.getSYSPROCTYPE(), (String)"DELETE", (boolean)true) == 0) {
                    strProcName = String.valueOf(strProcName) + "_D";
                } else if (StringHelper.Compare((String)psDESysProc.getSYSPROCTYPE(), (String)"GET", (boolean)true) == 0) {
                    strProcName = String.valueOf(strProcName) + "_G";
                }
                boolean bDefaultMode = true;
                if (!psDESysProc.isDEFAULTMODENull()) {
                    bDefaultMode = psDESysProc.getDEFAULTMODE();
                }
                if (!bDefaultMode) {
                    strProcName = String.valueOf(strProcName) + "_";
                    strProcName = String.valueOf(strProcName) + psDESysProc.getACTIONMODE().toUpperCase();
                }
                psDESysProc.setPSDESYSPROCNAME(strProcName);
                if (bDefaultMode) {
                    psDESysProc.setPSDESYSPROCID(Helper.GenUniqueId((String)psDESysProc.getPSDEID(), (String)psDESysProc.getSYSPROCTYPE()));
                } else {
                    psDESysProc.setPSDESYSPROCID(Helper.GenUniqueId((String)psDESysProc.getPSDEID(), (String)psDESysProc.getSYSPROCTYPE(), (String)psDESysProc.getACTIONMODE()));
                }
            }
            catch (Exception ex) {
                log.error((Object)ex.getMessage(), (Throwable)ex);
                callResult.setRetCode(1);
                callResult.setErrorInfo(ex.getMessage());
                return callResult;
            }
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
            if (StringHelper.Compare((String)strDEId, (String)"DE2050", (boolean)true) == 0) {
                PSDataEntity psDataEntity = new PSDataEntity();
                psDataEntity.proxy(dataEntity);
                String[] stringArray = SysProcTypes;
                int n = SysProcTypes.length;
                int n2 = 0;
                while (n2 < n) {
                    String strProcType = stringArray[n2];
                    PSDEDBSysProc psDESysProc = new PSDEDBSysProc();
                    psDESysProc.setPSDEID(psDataEntity.getPSDATAENTITYID());
                    psDESysProc.setPSDENAME(psDataEntity.getPSDATAENTITYNAME());
                    psDESysProc.setSYSPROCTYPE(strProcType);
                    psDESysProc.setPSDESYSPROCID(Helper.GenUniqueId((String)psDESysProc.getPSDEID(), (String)psDESysProc.getSYSPROCTYPE()));
                    callResult = this.Get(psDESysProc);
                    if (Errors.IsSpecialError((int)callResult.getRetCode(), (int)3)) {
                        psDESysProc.setDEFAULTMODE(true);
                        callResult = this.AutoSave(psDESysProc);
                        if (callResult.isError()) {
                            throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u7cfb\u7edf\u5b58\u50a8\u8fc7\u7a0b\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
                        }
                    }
                    ++n2;
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
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_GENERATECODE, (boolean)true) == 0) {
            return this.generateCode(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_SYNCDEFIELD, (boolean)true) == 0) {
            return this.syncDEFields(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult generateCode(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            PSDEDBSysProc psDESysProc = new PSDEDBSysProc();
            psDESysProc.proxy(dataEntity);
            this.onGenerateCode(psDESysProc);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u53d1\u5e03\u7cfb\u7edf\u4ee3\u7801\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onGenerateCode(PSDEDBSysProc psDESysProc) throws Exception {
        IPSDataEntity iDataEntity = this.getPSModelStorage().getPSDataEntity(psDESysProc.getPSDEID());
        Iterator<String> dbTypes = iDataEntity.getPSSystem().getSupportDBTypes();
        while (dbTypes.hasNext()) {
            String strDBType = dbTypes.next();
            IPSDBType iPSDBType = this.getPSModelStorage().getPSDBType(strDBType);
            IPSDBSysProcTempl iPSDBSysProcTempl = iPSDBType.getPSDBSysProcTempl(psDESysProc.getSYSPROCTYPE());
            IPSDBSysProcCodePublisher iPSDBSysProcCodePublisher = iPSDBSysProcTempl.getPSDBSysProcCodePublisher();
            PSPublishContextImpl psPublishContextImpl = new PSPublishContextImpl((IDEDataCtrl)this);
            iPSDBSysProcCodePublisher.generateCode(psPublishContextImpl, psDESysProc);
            iPSDBSysProcCodePublisher.close();
        }
    }

    public CallResult syncDEFields(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            PSDEDBSysProc psDESysProc = new PSDEDBSysProc();
            psDESysProc.proxy(dataEntity);
            this.onSyncDEFields(psDESysProc);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u540c\u6b65\u5b9e\u4f53\u5c5e\u6027\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onSyncDEFields(PSDEDBSysProc psDESysProc) throws Exception {
        boolean bKeyOnly = false;
        if (StringHelper.Compare((String)psDESysProc.getSYSPROCTYPE(), (String)"DELETE", (boolean)true) == 0 || StringHelper.Compare((String)psDESysProc.getSYSPROCTYPE(), (String)"DELETE", (boolean)true) == 0) {
            bKeyOnly = true;
        }
        IDEDataCtrl psDEDBSPFieldDataCtrl = this.GetRelatedDataCtrl("DE2074");
        IPSDataEntity iDataEntity = this.getPSModelStorage().getPSDataEntity(psDESysProc.getPSDEID());
        Iterator<IPSDEField> psDEFields = iDataEntity.getPSDEFields();
        while (psDEFields.hasNext()) {
            IPSDEField iPSDEField = psDEFields.next();
            if (iPSDEField.isSystemReserver() || bKeyOnly && !iPSDEField.isKeyDEField()) continue;
            PSDEDBSysProcField psDEDBSysProcField = new PSDEDBSysProcField();
            psDEDBSysProcField.setPSDESYSPROCID(psDESysProc.getPSDESYSPROCID());
            psDEDBSysProcField.setPSDESYSPROCNAME(psDESysProc.getPSDESYSPROCNAME());
            psDEDBSysProcField.setPSDEFID(iPSDEField.getId());
            psDEDBSysProcField.setPSDEFNAME(iPSDEField.getName());
            CallResult callResult = psDEDBSPFieldDataCtrl.AutoSave((BaseDataEntity)psDEDBSysProcField);
            if (!callResult.isError()) continue;
            throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u5b58\u50a8\u8fc7\u7a0b\u5b9e\u4f53\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
    }
}

