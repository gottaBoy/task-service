/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.Data.CodeList
 *  SA.SRFDA.Ctrl.Data.DEField
 *  SA.SRFDA.Ctrl.Data.DER1N
 *  SA.SRFDA.Ctrl.Data.DERINDEX
 *  SA.SRFDA.Ctrl.Data.DataEntity
 *  SA.SRFDA.Ctrl.Data.DataGrid
 *  SA.SRFDA.Ctrl.Data.Form
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.CodeList.CodeItemConfig
 *  SA.SRFramework.CodeList.CodeListConfig
 *  SA.SRFramework.CommonEx.Errors
 *  SA.SRFramework.Data.CallParamList
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.Data.CodeList;
import SA.SRFDA.Ctrl.Data.DEField;
import SA.SRFDA.Ctrl.Data.DER1N;
import SA.SRFDA.Ctrl.Data.DERINDEX;
import SA.SRFDA.Ctrl.Data.DataEntity;
import SA.SRFDA.Ctrl.Data.DataGrid;
import SA.SRFDA.Ctrl.Data.Form;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.PS.Core.Deploy.IPSSystemDeploy;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.PS.Data.PSCodeItem;
import SA.SRFDA.PS.Data.PSCodeList;
import SA.SRFDA.PS.Data.PSDEField;
import SA.SRFDA.PS.Data.PSDER;
import SA.SRFDA.PS.Data.PSDataEntity;
import SA.SRFDA.PS.Data.PSV3Migrate;
import SA.SRFDA.PS.Data.PSV3MigrateDE;
import SA.SRFDA.PS.Data.PSV3MigrateDEForm;
import SA.SRFDA.PS.Data.PSV3MigrateDEGrid;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.CodeList.CodeItemConfig;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.CommonEx.Errors;
import SA.SRFramework.Data.CallParamList;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSV3MigrateDEDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSV3MigrateDEDataCtrl.class);
    public static final String CUSTOMCALL_SYNCBASE = "SYNCBASE";
    public static final String CUSTOMCALL_SYNCDER = "SYNCDER";
    public static final String CUSTOMCALL_SYNCCODELIST = "SYNCCODELIST";
    public static final String CUSTOMCALL_INITFORMLIST = "INITFORMLIST";
    public static final String CUSTOMCALL_INITGRIDLIST = "INITGRIDLIST";
    private static HashMap<String, String> ignoreFieldMap = new HashMap();

    static {
        ignoreFieldMap.put("DESC", "");
        ignoreFieldMap.put("DESCRIPTION", "DESCRIPTION");
    }

    @Override
    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        return callResult;
    }

    @Override
    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_SYNCBASE, (boolean)true) == 0) {
            return this.syncBaseInfo(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_SYNCDER, (boolean)true) == 0) {
            return this.syncDER(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_SYNCCODELIST, (boolean)true) == 0) {
            return this.syncCodeList(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_INITGRIDLIST, (boolean)true) == 0) {
            return this.initGridList(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_INITFORMLIST, (boolean)true) == 0) {
            return this.initFormList(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult syncBaseInfo(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            PSV3MigrateDE psV3MigrateDE = new PSV3MigrateDE();
            psV3MigrateDE.proxy(dataEntity);
            this.onSyncBaseInfo(psV3MigrateDE);
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().CommitAndBegin();
            }
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u521d\u59cb\u5316\u5b9e\u4f53\u57fa\u672c\u4fe1\u606f\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onSyncBaseInfo(PSV3MigrateDE psV3MigrateDE) throws Exception {
        String strPSSystemId = psV3MigrateDE.getPSSYSTEMID();
        IPSSystem iPSSystem = this.getPSModelStorage().getPSSystem(strPSSystemId);
        PSV3Migrate psV3Migrate = new PSV3Migrate();
        psV3Migrate.setPSV3MIGRATEID(psV3MigrateDE.getPSV3MIGRATEID());
        IDEDataCtrl psV3MigrateDataCtrl = this.GetRelatedDataCtrl("DE2900");
        CallResult callResult = psV3MigrateDataCtrl.Get((BaseDataEntity)psV3Migrate);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u8fc1\u79fb\u914d\u7f6e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        IPSSystemDeploy defaultPSSystemDeploy = iPSSystem.getDefaultPSSystemDeploy();
        Exception exception = null;
        Connection connection = defaultPSSystemDeploy.getDefaultPSSystemDeployDB().getConnection();
        try {
            try {
                String strSQL = "SELECT t1.* FROM V_SRFDATAENTITY t1 WHERE DEID=?";
                CallParamList callParamList = new CallParamList();
                callParamList.Add((Object)psV3MigrateDE.getDEID());
                DataEntity dataEntity = new DataEntity();
                callResult = BaseDEDataCtrl.SelectSingleEx((ISRFDAGlobalHelper)this.getGlobalHelper(), (Connection)connection, (String)"", (String)strSQL, (Vector)callParamList.GetList(), (BaseDataEntity)dataEntity);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                IDEDataCtrl psDataEntityDataCtrl = this.GetRelatedDataCtrl("DE2050");
                PSDataEntity psDataEntity = new PSDataEntity();
                String strPSDATAENTITYNAME = dataEntity.getDENAME().toUpperCase();
                psDataEntity.setPSDATAENTITYID(Helper.GenUniqueId((String)iPSSystem.getId(), (String)strPSDATAENTITYNAME));
                callResult = psDataEntityDataCtrl.Get((BaseDataEntity)psDataEntity);
                if (callResult.isError()) {
                    psDataEntity.setDESN(dataEntity.getDEID());
                    psDataEntity.setPSSYSTEMID(iPSSystem.getId());
                    psDataEntity.setPSDATAENTITYNAME(dataEntity.getDENAME());
                    psDataEntity.setLOGICNAME(dataEntity.getDELOGICNAME());
                    psDataEntity.setLOGICVALID(dataEntity.isLOGICVALID());
                    psDataEntity.setTABLENAME(dataEntity.getTABLENAME());
                    psDataEntity.setPSMODULEID(psV3Migrate.getPSMODULEID());
                    psDataEntity.setCODENAME(dataEntity.getDENAME());
                    callResult = psDataEntityDataCtrl.AutoSave((BaseDataEntity)psDataEntity);
                    if (callResult.isError()) {
                        throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u4e91\u5b9e\u4f53\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                    if (this.getTransactionManager() != null) {
                        this.getTransactionManager().CommitAndBegin();
                    }
                }
                strSQL = "SELECT t1.* FROM v_srfdefield t1 WHERE t1.DEID=?";
                Vector<DEField> deFieldList = new Vector<>();
                callResult = BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)this.getGlobalHelper(), (Connection)connection, (String)"", (String)strSQL, (Vector)callParamList.GetList(), deFieldList, (String)DEField.class.getName());
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u5c5e\u6027\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                IDEDataCtrl psDEFieldDataCtrl = this.GetRelatedDataCtrl("DE2051");
                for (DEField deField : deFieldList) {
                    if (ignoreFieldMap.containsKey(deField.getDEFNAME().toUpperCase()) || StringHelper.Compare((String)deField.getDATATYPE(), (String)"PICKUP", (boolean)true) == 0 || StringHelper.Compare((String)deField.getDATATYPE(), (String)"PICKUPTEXT", (boolean)true) == 0 || StringHelper.Compare((String)deField.getDATATYPE(), (String)"PICKUPDATA", (boolean)true) == 0 || StringHelper.Compare((String)deField.getDATATYPE(), (String)"INHERIT", (boolean)true) == 0) continue;
                    PSDEField psDEField = new PSDEField();
                    psDEField.setPSDEFIELDID(Helper.GenUniqueId((String)psDataEntity.getPSDATAENTITYID(), (String)deField.getDEFNAME().toUpperCase()));
                    callResult = psDEFieldDataCtrl.Get((BaseDataEntity)psDEField);
                    if (Errors.IsSpecialError((int)callResult.getRetCode(), (int)3)) {
                        psDEField.setPSDEID(psDataEntity.getPSDATAENTITYID());
                        psDEField.setDEFTYPE(deField.getDEFTYPE());
                        psDEField.setPSDENAME(psDataEntity.getPSDATAENTITYNAME());
                        psDEField.setPSDEFIELDNAME(deField.getDEFNAME().toUpperCase());
                        psDEField.setLOGICNAME(deField.getDEFLOGICNAME());
                        psDEField.setPSDATATYPEID(deField.getDATATYPE());
                        if (!deField.isLENGTHNull()) {
                            psDEField.setLENGTH(deField.getLENGTH());
                        }
                        if (!deField.isPRECISION2Null()) {
                            psDEField.setPRECISION2(deField.getPRECISION2());
                        }
                        psDEField.setALLOWEMPTY(deField.isNULLABLE());
                        psDEField.setMAJORFIELD(deField.isMAJOR() ? 1 : 0);
                        psDEField.setFKEY(deField.isFKEY());
                        psDEField.setPKEY(deField.isPKEY() ? 1 : 0);
                        psDEField.setTABLENAME(deField.getTABLENAME());
                        psDEField.setFORMULAFORMAT(deField.getFORMULAFORMAT());
                        psDEField.setFORMULAFIELDS(deField.getFORMULAFIELD());
                        int nUIAction = 0;
                        if (deField.isENABLECREATE()) {
                            nUIAction = 1;
                        }
                        if (deField.isENABLEMODIFY()) {
                            nUIAction |= 2;
                        }
                        psDEField.setENABLEUSERINPUT(nUIAction);
                        psDEField.setINDEXTYPE(deField.isINDEXTYPE());
                        if (!StringHelper.IsNullOrEmpty((String)deField.getCODELISTID())) {
                            psDEField.setPSCODELISTID(Helper.GenUniqueId((String)iPSSystem.getId(), (String)deField.getCODELISTID()));
                        }
                        if ((callResult = psDEFieldDataCtrl.Save(true, (BaseDataEntity)psDEField)).isError()) {
                            throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u4e91\u5b9e\u4f53\u5c5e\u6027[%1$S]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)psDEField.getPSDEFIELDNAME(), (Object)callResult.getErrorInfo()));
                        }
                        if (this.getTransactionManager() == null) continue;
                        this.getTransactionManager().CommitAndBegin();
                        continue;
                    }
                    if (!callResult.isOk()) continue;
                    boolean bModify = false;
                    if (!StringHelper.IsNullOrEmpty((String)deField.getCODELISTID()) && StringHelper.IsNullOrEmpty((String)psDEField.getPSCODELISTID())) {
                        bModify = true;
                        psDEField.setPSCODELISTID(Helper.GenUniqueId((String)iPSSystem.getId(), (String)deField.getCODELISTID()));
                    }
                    if (psDEField.isINDEXTYPENull() && deField.isINDEXTYPE()) {
                        psDEField.setINDEXTYPE(deField.isINDEXTYPE());
                        bModify = true;
                    }
                    if (!bModify || !(callResult = psDEFieldDataCtrl.Save(false, (BaseDataEntity)psDEField)).isError()) continue;
                    throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u4e91\u5b9e\u4f53\u5c5e\u6027[%1$S]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)psDEField.getPSDEFIELDNAME(), (Object)callResult.getErrorInfo()));
                }
            }
            catch (Exception e) {
                log.error((Object)e.getMessage(), (Throwable)e);
                exception = new Exception(e);
                connection.close();
                if (exception != null) {
                    throw exception;
                }
            }
        }
        finally {
            connection.close();
            if (exception != null) {
                throw exception;
            }
        }
    }

    public CallResult syncDER(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            PSV3MigrateDE psV3MigrateDE = new PSV3MigrateDE();
            psV3MigrateDE.proxy(dataEntity);
            this.onSyncDER(psV3MigrateDE);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u521d\u59cb\u5316\u5b9e\u4f53\u57fa\u672c\u4fe1\u606f\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onSyncDER(PSV3MigrateDE psV3MigrateDE) throws Exception {
        String strPSSystemId = psV3MigrateDE.getPSSYSTEMID();
        IPSSystem iPSSystem = this.getPSModelStorage().getPSSystem(strPSSystemId);
        IPSSystemDeploy defaultPSSystemDeploy = iPSSystem.getDefaultPSSystemDeploy();
        Exception exception = null;
        Connection connection = defaultPSSystemDeploy.getDefaultPSSystemDeployDB().getConnection();
        try {
            try {
                BaseDataEntity relatedDEField;
                int nUIAction;
                PSDEField psDEField;
                Vector<DEField> deFieldList;
                PSDataEntity psDataEntity;
                PSDER psDER;
                CallParamList callParamList = new CallParamList();
                callParamList.Add((Object)psV3MigrateDE.getDEID());
                String strSQL = "select t1.* from V_SRFDER1N t1  where t1.MINORDEID=?";
                Vector<DER1N> deDER1NList = new Vector<>();
                CallResult callResult = BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)this.getGlobalHelper(), (Connection)connection, (String)"", (String)strSQL, (Vector)callParamList.GetList(), deDER1NList, (String)DER1N.class.getName());
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u5173\u7cfb(1:N)\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                strSQL = "select t1.* from V_SRFDERINDEX t1  where t1.DEID=?";
                Vector<DERINDEX> derINDEXList = new Vector<>();
                callResult = BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)this.getGlobalHelper(), (Connection)connection, (String)"", (String)strSQL, (Vector)callParamList.GetList(), derINDEXList, (String)DERINDEX.class.getName());
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u5173\u7cfb(Index)\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                IDEHelper psDataEntityDEHelper = this.getGlobalHelper().getDAModelStorage().FindDEHelper2("DE2050");
                IDEDataCtrl psDEFieldDataCtrl = this.GetRelatedDataCtrl("DE2051");
                IDEDataCtrl psDERDataCtrl = this.GetRelatedDataCtrl("DE2052");
                IDEDataCtrl psDataEntityDataCtrl = this.GetRelatedDataCtrl("DE2050");
                for (DER1N der1N : deDER1NList) {
                    log.info((Object)StringHelper.Format((String)"\u51c6\u5907\u8fc1\u79fbDER1N[%1$s]", (Object)der1N.getDERID()));
                    psDER = new PSDER();
                    psDER.setPSSYSTEMID(iPSSystem.getId());
                    psDER.setPSDERID(Helper.GenUniqueId((String)iPSSystem.getId(), (String)der1N.getDERID()));
                    callResult = psDERDataCtrl.Get((BaseDataEntity)psDER);
                    if (Errors.IsSpecialError((int)callResult.getRetCode(), (int)3)) {
                        psDER.setDERTYPE("DER1N");
                        psDataEntity = new PSDataEntity();
                        psDataEntity.setPSSYSTEMID(iPSSystem.getId());
                        psDataEntity.setPSDATAENTITYNAME(der1N.getMAJORDENAME().toUpperCase());
                        psDataEntity.setPSDATAENTITYID(psDataEntityDEHelper.getKeyValue((BaseDataEntity)psDataEntity).toString());
                        callResult = psDataEntityDataCtrl.Get((BaseDataEntity)psDataEntity);
                        if (callResult.isError()) {
                            log.error((Object)StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728", (Object)der1N.getMAJORDENAME()));
                            continue;
                        }
                        psDER.setMAJORPSDEID(psDataEntityDEHelper.getKeyValue((BaseDataEntity)psDataEntity).toString());
                        psDER.setMAJORPSDENAME(der1N.getMAJORDENAME().toUpperCase());
                        psDataEntity.setPSDATAENTITYNAME(der1N.getMINORDENAME().toUpperCase());
                        psDataEntity.setPSDATAENTITYID(psDataEntityDEHelper.getKeyValue((BaseDataEntity)psDataEntity).toString());
                        callResult = psDataEntityDataCtrl.Get((BaseDataEntity)psDataEntity);
                        if (callResult.isError()) {
                            log.error((Object)StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728", (Object)der1N.getMINORDENAME()));
                            continue;
                        }
                        psDER.setMINORPSDEID(psDataEntityDEHelper.getKeyValue((BaseDataEntity)psDataEntity).toString());
                        psDER.setMINORPSDENAME(der1N.getMINORDENAME().toUpperCase());
                        psDER.setDERFIELDNAME(der1N.getMAJORKEYDEFNAME());
                        psDER.setDERFIELDLNAME(der1N.getDERLOGICNAME());
                        psDER.setREMOVEACTIONTYPE(2);
                        if (der1N.getREMOVEACTIONTYPE() > 0) {
                            psDER.setREMOVEACTIONTYPE(der1N.getREMOVEACTIONTYPE());
                        }
                        if ((callResult = psDERDataCtrl.Save(true, (BaseDataEntity)psDER)).isError()) {
                            throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u4e91\u5173\u7cfb\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                        }
                    }
                    strSQL = "SELECT t1.* FROM v_srfdefield t1 WHERE t1.DEID=? AND t1.DATATYPEPARAM4=?";
                    callParamList.Reset();
                    callParamList.Add((Object)psV3MigrateDE.getDEID());
                    callParamList.Add((Object)der1N.getDERID());
                    deFieldList = new Vector<>();
                    callResult = BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)this.getGlobalHelper(), (Connection)connection, (String)"", (String)strSQL, (Vector)callParamList.GetList(), deFieldList, (String)DEField.class.getName());
                    if (callResult.isError()) {
                        throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u5c5e\u6027\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                    for (DEField deField : deFieldList) {
                        psDEField = new PSDEField();
                        psDEField.setPSDEFIELDID(Helper.GenUniqueId((String)psDER.getMINORPSDEID(), (String)deField.getDEFNAME().toUpperCase()));
                        callResult = psDEFieldDataCtrl.Get((BaseDataEntity)psDEField);
                        if (!Errors.IsSpecialError((int)callResult.getRetCode(), (int)3)) continue;
                        psDEField.setPSDEID(psDER.getMINORPSDEID());
                        psDEField.setDEFTYPE(deField.getDEFTYPE());
                        psDEField.setPSDENAME(psDER.getMINORPSDENAME());
                        psDEField.setPSDEFIELDNAME(deField.getDEFNAME().toUpperCase());
                        psDEField.setLOGICNAME(deField.getDEFLOGICNAME());
                        psDEField.setPSDATATYPEID(deField.getDATATYPE());
                        if (!deField.isLENGTHNull()) {
                            psDEField.setLENGTH(deField.getLENGTH());
                        }
                        if (!deField.isPRECISION2Null()) {
                            psDEField.setPRECISION2(deField.getPRECISION2());
                        }
                        psDEField.setALLOWEMPTY(deField.isNULLABLE());
                        psDEField.setMAJORFIELD(deField.isMAJOR() ? 1 : 0);
                        psDEField.setFKEY(deField.isFKEY());
                        psDEField.setPKEY(deField.isPKEY() ? 1 : 0);
                        psDEField.setTABLENAME(deField.getTABLENAME());
                        nUIAction = 0;
                        if (deField.isENABLECREATE()) {
                            nUIAction = 1;
                        }
                        if (deField.isENABLEMODIFY()) {
                            nUIAction |= 2;
                        }
                        if (nUIAction == 0 && StringHelper.Compare((String)psDEField.getPSDATATYPEID(), (String)"PICKUPTEXT", (boolean)false) == 0) {
                            nUIAction = 3;
                        }
                        psDEField.setENABLEUSERINPUT(nUIAction);
                        psDEField.setPSDERID(psDER.getPSDERID());
                        relatedDEField = new BaseDataEntity();
                        relatedDEField.setParamValue("PSDEID", (Object)psDER.getMAJORPSDEID());
                        relatedDEField.setParamValue("PSDEFIELDNAME", (Object)deField.getRDEFNAME().toUpperCase());
                        psDEField.setDERPSDEFID(psDEFieldDataCtrl.GetDEHelper().getKeyValue(relatedDEField).toString());
                        psDEField.setDERPSDEFNAME(deField.getRDEFNAME().toUpperCase());
                        callResult = psDEFieldDataCtrl.Save(true, (BaseDataEntity)psDEField);
                        if (!callResult.isError()) continue;
                        throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u4e91\u5b9e\u4f53\u5c5e\u6027\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                    if (this.getTransactionManager() == null) continue;
                    this.getTransactionManager().CommitAndBegin();
                }
                for (DERINDEX derINDEX : derINDEXList) {
                    log.info((Object)StringHelper.Format((String)"\u51c6\u5907\u8fc1\u79fbDERINDEX[%1$s]", (Object)derINDEX.getINDEXDEID()));
                    psDER = new PSDER();
                    psDER.setPSSYSTEMID(iPSSystem.getId());
                    psDER.setPSDERID(Helper.GenUniqueId((String)iPSSystem.getId(), (String)derINDEX.getDERINDEXID()));
                    callResult = psDERDataCtrl.Get((BaseDataEntity)psDER);
                    if (Errors.IsSpecialError((int)callResult.getRetCode(), (int)3)) {
                        if (derINDEX.isINHERITMODE()) {
                            psDER.setDERTYPE("DERINHERIT");
                        } else {
                            psDER.setDERTYPE("DERINDEX");
                        }
                        psDataEntity = new PSDataEntity();
                        psDataEntity.setPSSYSTEMID(iPSSystem.getId());
                        psDataEntity.setPSDATAENTITYNAME(derINDEX.getINDEXDENAME().toUpperCase());
                        psDataEntity.setPSDATAENTITYID(psDataEntityDEHelper.getKeyValue((BaseDataEntity)psDataEntity).toString());
                        callResult = psDataEntityDataCtrl.Get((BaseDataEntity)psDataEntity);
                        if (callResult.isError()) {
                            log.error((Object)StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728", (Object)derINDEX.getINDEXDENAME()));
                            continue;
                        }
                        psDER.setMAJORPSDEID(psDataEntityDEHelper.getKeyValue((BaseDataEntity)psDataEntity).toString());
                        psDER.setMAJORPSDENAME(derINDEX.getINDEXDENAME().toUpperCase());
                        psDataEntity.setPSDATAENTITYNAME(derINDEX.getDENAME().toUpperCase());
                        psDataEntity.setPSDATAENTITYID(psDataEntityDEHelper.getKeyValue((BaseDataEntity)psDataEntity).toString());
                        callResult = psDataEntityDataCtrl.Get((BaseDataEntity)psDataEntity);
                        if (callResult.isError()) {
                            log.error((Object)StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728", (Object)derINDEX.getDENAME()));
                            continue;
                        }
                        psDER.setMINORPSDEID(psDataEntityDEHelper.getKeyValue((BaseDataEntity)psDataEntity).toString());
                        psDER.setMINORPSDENAME(derINDEX.getDENAME().toUpperCase());
                        psDER.setINDEXVALUE(derINDEX.getTYPEVALUE());
                        callResult = psDERDataCtrl.Save(true, (BaseDataEntity)psDER);
                        if (callResult.isError()) {
                            throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u4e91\u5173\u7cfb\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                        }
                    }
                    if (derINDEX.isINHERITMODE()) {
                        strSQL = "SELECT t1.* FROM v_srfdefield t1 WHERE t1.DEID=? AND t1.DATATYPE='INHERIT'";
                        callParamList.Reset();
                        callParamList.Add((Object)psV3MigrateDE.getDEID());
                        deFieldList = new Vector<>();
                        callResult = BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)this.getGlobalHelper(), (Connection)connection, (String)"", (String)strSQL, (Vector)callParamList.GetList(), deFieldList, (String)DEField.class.getName());
                        if (callResult.isError()) {
                            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u5c5e\u6027\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                        }
                        for (DEField deField : deFieldList) {
                            psDEField = new PSDEField();
                            psDEField.setPSDEFIELDID(Helper.GenUniqueId((String)psDER.getMINORPSDEID(), (String)deField.getDEFNAME().toUpperCase()));
                            callResult = psDEFieldDataCtrl.Get((BaseDataEntity)psDEField);
                            if (!Errors.IsSpecialError((int)callResult.getRetCode(), (int)3)) continue;
                            psDEField.setPSDEID(psDER.getMINORPSDEID());
                            psDEField.setDEFTYPE(deField.getDEFTYPE());
                            psDEField.setPSDENAME(psDER.getMINORPSDENAME());
                            psDEField.setPSDEFIELDNAME(deField.getDEFNAME().toUpperCase());
                            psDEField.setLOGICNAME(deField.getDEFLOGICNAME());
                            psDEField.setPSDATATYPEID(deField.getDATATYPE());
                            psDEField.setMAJORFIELD(0);
                            if (!deField.isLENGTHNull()) {
                                psDEField.setLENGTH(deField.getLENGTH());
                            }
                            if (!deField.isPRECISION2Null()) {
                                psDEField.setPRECISION2(deField.getPRECISION2());
                            }
                            psDEField.setALLOWEMPTY(deField.isNULLABLE());
                            nUIAction = 0;
                            if (deField.isENABLECREATE()) {
                                nUIAction = 1;
                            }
                            if (deField.isENABLEMODIFY()) {
                                nUIAction |= 2;
                            }
                            psDEField.setENABLEUSERINPUT(nUIAction);
                            psDEField.setPSDERID(psDER.getPSDERID());
                            relatedDEField = new BaseDataEntity();
                            relatedDEField.setParamValue("PSDEID", (Object)psDER.getMAJORPSDEID());
                            relatedDEField.setParamValue("PSDEFIELDNAME", (Object)deField.getRDEFNAME().toUpperCase());
                            psDEField.setDERPSDEFID(psDEFieldDataCtrl.GetDEHelper().getKeyValue(relatedDEField).toString());
                            psDEField.setDERPSDEFNAME(deField.getRDEFNAME().toUpperCase());
                            callResult = psDEFieldDataCtrl.Save(true, (BaseDataEntity)psDEField);
                            if (!callResult.isError()) continue;
                            throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u4e91\u5b9e\u4f53\u5c5e\u6027\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                        }
                    }
                    if (this.getTransactionManager() == null) continue;
                    this.getTransactionManager().CommitAndBegin();
                }
            }
            catch (Exception e) {
                log.error((Object)e.getMessage(), (Throwable)e);
                exception = new Exception(e);
                connection.close();
                if (exception != null) {
                    throw exception;
                }
            }
        }
        finally {
            connection.close();
            if (exception != null) {
                throw exception;
            }
        }
    }

    public CallResult syncCodeList(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            PSV3MigrateDE psV3MigrateDE = new PSV3MigrateDE();
            psV3MigrateDE.proxy(dataEntity);
            this.onSyncCodeList(psV3MigrateDE);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u521d\u59cb\u5316\u5b9e\u4f53\u4ee3\u7801\u8868\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onSyncCodeList(PSV3MigrateDE psV3MigrateDE) throws Exception {
        String strPSSystemId = psV3MigrateDE.getPSSYSTEMID();
        IPSSystem iPSSystem = this.getPSModelStorage().getPSSystem(strPSSystemId);
        IPSSystemDeploy defaultPSSystemDeploy = iPSSystem.getDefaultPSSystemDeploy();
        Exception exception = null;
        Connection connection = defaultPSSystemDeploy.getDefaultPSSystemDeployDB().getConnection();
        try {
            try {
                CallParamList callParamList = new CallParamList();
                callParamList.Add((Object)psV3MigrateDE.getDEID());
                String strSQL = "select t1.* from V_SRFCODELIST t1  where t1.DEID=?";
                Vector<CodeList> deCodeListList = new Vector<>();
                CallResult callResult = BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)this.getGlobalHelper(), (Connection)connection, (String)"", (String)strSQL, (Vector)callParamList.GetList(), deCodeListList, (String)CodeList.class.getName());
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u4ee3\u7801\u8868\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                IDEDataCtrl psCodeListDataCtrl = this.GetRelatedDataCtrl("DE2040");
                for (CodeList codeList : deCodeListList) {
                    log.info((Object)StringHelper.Format((String)"\u51c6\u5907\u8fc1\u79fbCodeList[%1$s]", (Object)codeList.getCODELISTID()));
                    PSCodeList psCodeList = new PSCodeList();
                    psCodeList.setPSCODELISTID(Helper.GenUniqueId((String)iPSSystem.getId(), (String)codeList.getCODELISTID()));
                    callResult = psCodeListDataCtrl.Get((BaseDataEntity)psCodeList);
                    if (Errors.IsSpecialError((int)callResult.getRetCode(), (int)3)) {
                        codeList.CopyTo((BaseDataEntity)psCodeList, false);
                        String strPSDATAENTITYNAME = codeList.getParamStringValue("DENAME", "").toUpperCase();
                        psCodeList.setPSDEID(Helper.GenUniqueId((String)iPSSystem.getId(), (String)strPSDATAENTITYNAME));
                        psCodeList.setPSDENAME(strPSDATAENTITYNAME);
                        psCodeList.setPSCODELISTNAME(codeList.getCODELISTNAME());
                        psCodeList.setPSSYSTEMID(iPSSystem.getId());
                        psCodeList.setCODELISTSN(codeList.getCODELISTID());
                        psCodeList.setCODENAME(StringHelper.Format((String)codeList.getCODELISTID()));
                        if (StringHelper.IsNullOrEmpty((String)codeList.getFILLER())) {
                            psCodeList.setCLTYPE("STATIC");
                        } else {
                            psCodeList.setCLTYPE("DYNAMIC");
                            psCodeList.setMEMO(codeList.getCLPARAM());
                            psCodeList.setPSDEDSID(psCodeList.getPSDEDSID());
                        }
                        callResult = psCodeListDataCtrl.Save(true, (BaseDataEntity)psCodeList);
                        if (callResult.isError()) {
                            throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u5b9e\u4f53\u4ee3\u7801\u8868\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                        }
                    }
                    if (StringHelper.Compare((String)psCodeList.getCLTYPE(), (String)"STATIC", (boolean)true) == 0) {
                        CodeListConfig codeListConfig;
                        IDEDataCtrl psCodeItemDataCtrl = this.GetRelatedDataCtrl("DE2041");
                        BaseDataEntity cond = new BaseDataEntity();
                        cond.setParamValue("PSCODELISTID", (Object)psCodeList.getPSCODELISTID());
                        Vector psCodeItemList = new Vector();
                        callResult = psCodeItemDataCtrl.Select(cond, psCodeItemList, PSCodeItem.class.getName());
                        if (callResult.isError()) {
                            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u4ee3\u7801\u8868\u4ee3\u7801\u9879\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)callResult.getErrorInfo()));
                        }
                        if (psCodeItemList.size() > 0 || (codeListConfig = this.getGlobalHelper().getCodeListMgr().GetCodeListConfig(psCodeList.getCODELISTSN())).getCodeItems() == null || codeListConfig.getCodeItems().size() == 0) continue;
                        int i = 0;
                        while (i < codeListConfig.getCodeItems().size()) {
                            CodeItemConfig codeItemConfig = (CodeItemConfig)codeListConfig.getCodeItems().get(i);
                            this.onInitPSCodeItem(psCodeList, null, codeItemConfig, i);
                            ++i;
                        }
                    }
                    if (this.getTransactionManager() == null) continue;
                    this.getTransactionManager().CommitAndBegin();
                }
            }
            catch (Exception e) {
                log.error((Object)e.getMessage(), (Throwable)e);
                exception = new Exception(e);
                connection.close();
                if (exception != null) {
                    throw exception;
                }
            }
        }
        finally {
            connection.close();
            if (exception != null) {
                throw exception;
            }
        }
    }

    protected void onInitPSCodeItem(PSCodeList psCodeList, PSCodeItem parentPSCodeItem, CodeItemConfig codeItemConfig, int nIndex) throws Exception {
        CallResult callResult;
        IDEDataCtrl psCodeItemDataCtrl = this.GetRelatedDataCtrl("DE2041");
        PSCodeItem psCodeItem = new PSCodeItem();
        psCodeItem.setPSCODELISTID(psCodeList.getPSCODELISTID());
        psCodeItem.setCODEITEMVALUE(codeItemConfig.getValue());
        psCodeItem.setPSCODEITEMNAME(codeItemConfig.getText());
        psCodeItem.setORDERVALUE(nIndex);
        if (parentPSCodeItem != null) {
            psCodeItem.setPPSCODEITEMID(parentPSCodeItem.getPSCODEITEMID());
        }
        if ((callResult = psCodeItemDataCtrl.Save(true, (BaseDataEntity)psCodeItem)).isError()) {
            throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u7cfb\u7edf\u4ee3\u7801\u8868\u4ee3\u7801\u9879\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        if (codeItemConfig.getCodeItems() == null || codeItemConfig.getCodeItems().size() == 0) {
            return;
        }
        int i = 0;
        while (i < codeItemConfig.getCodeItems().size()) {
            CodeItemConfig childCodeItemConfig = (CodeItemConfig)codeItemConfig.getCodeItems().get(i);
            this.onInitPSCodeItem(psCodeList, psCodeItem, childCodeItemConfig, i);
            ++i;
        }
    }

    public CallResult initGridList(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            PSV3MigrateDE psV3MigrateDE = new PSV3MigrateDE();
            psV3MigrateDE.proxy(dataEntity);
            this.onInitGridList(psV3MigrateDE);
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().CommitAndBegin();
            }
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u521d\u59cb\u5316\u5b9e\u4f53\u8868\u683c\u57fa\u672c\u4fe1\u606f\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onInitGridList(PSV3MigrateDE psV3MigrateDE) throws Exception {
        String strPSSystemId = psV3MigrateDE.getPSSYSTEMID();
        IPSSystem iPSSystem = this.getPSModelStorage().getPSSystem(strPSSystemId);
        PSV3Migrate psV3Migrate = new PSV3Migrate();
        psV3Migrate.setPSV3MIGRATEID(psV3MigrateDE.getPSV3MIGRATEID());
        IDEDataCtrl psV3MigrateDataCtrl = this.GetRelatedDataCtrl("DE2900");
        CallResult callResult = psV3MigrateDataCtrl.Get((BaseDataEntity)psV3Migrate);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u8fc1\u79fb\u914d\u7f6e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        IDEDataCtrl psV3MigrateDEGridDataCtrl = this.GetRelatedDataCtrl("DE2903");
        IPSSystemDeploy defaultPSSystemDeploy = iPSSystem.getDefaultPSSystemDeploy();
        Exception exception = null;
        Connection connection = defaultPSSystemDeploy.getDefaultPSSystemDeployDB().getConnection();
        try {
            try {
                String strSQL = "SELECT t1.* FROM V_SRFDATAGRID t1 WHERE DEID=?";
                CallParamList callParamList = new CallParamList();
                callParamList.Add((Object)psV3MigrateDE.getDEID());
                Vector<DataGrid> dataGridList = new Vector<>();
                callResult = BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)this.getGlobalHelper(), (Connection)connection, (String)"", (String)strSQL, (Vector)callParamList.GetList(), dataGridList, (String)DataGrid.class.getName());
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u8868\u683c\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                for (DataGrid dataGrid : dataGridList) {
                    PSV3MigrateDEGrid psV3MigrateDEGrid = new PSV3MigrateDEGrid();
                    psV3MigrateDEGrid.setPSV3MIGRATEID(psV3Migrate.getPSV3MIGRATEID());
                    psV3MigrateDEGrid.setDEGRIDID(dataGrid.getDATAGRIDID());
                    psV3MigrateDEGrid.setPSV3MGGRIDNAME(dataGrid.getDATAGRIDNAME());
                    psV3MigrateDEGrid.setDEID(dataGrid.getDEID());
                    psV3MigrateDEGrid.setDENAME(dataGrid.getParamStringValue("DATAENTITY_DENAME", ""));
                    callResult = psV3MigrateDEGridDataCtrl.AutoSave((BaseDataEntity)psV3MigrateDEGrid);
                    if (!callResult.isError()) continue;
                    throw new Exception(StringHelper.Format((String)"\u4fdd\u6301\u8fc1\u79fb\u5b9e\u4f53\u8868\u683c\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
            }
            catch (Exception e) {
                log.error((Object)e.getMessage(), (Throwable)e);
                exception = new Exception(e);
                connection.close();
                if (exception != null) {
                    throw exception;
                }
            }
        }
        finally {
            connection.close();
            if (exception != null) {
                throw exception;
            }
        }
    }

    public CallResult initFormList(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            PSV3MigrateDE psV3MigrateDE = new PSV3MigrateDE();
            psV3MigrateDE.proxy(dataEntity);
            this.onInitFormList(psV3MigrateDE);
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().CommitAndBegin();
            }
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u521d\u59cb\u5316\u5b9e\u4f53\u8868\u5355\u57fa\u672c\u4fe1\u606f\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onInitFormList(PSV3MigrateDE psV3MigrateDE) throws Exception {
        String strPSSystemId = psV3MigrateDE.getPSSYSTEMID();
        IPSSystem iPSSystem = this.getPSModelStorage().getPSSystem(strPSSystemId);
        PSV3Migrate psV3Migrate = new PSV3Migrate();
        psV3Migrate.setPSV3MIGRATEID(psV3MigrateDE.getPSV3MIGRATEID());
        IDEDataCtrl psV3MigrateDataCtrl = this.GetRelatedDataCtrl("DE2900");
        CallResult callResult = psV3MigrateDataCtrl.Get((BaseDataEntity)psV3Migrate);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u8fc1\u79fb\u914d\u7f6e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        IDEDataCtrl psV3MigrateDEFormDataCtrl = this.GetRelatedDataCtrl("DE2902");
        IPSSystemDeploy defaultPSSystemDeploy = iPSSystem.getDefaultPSSystemDeploy();
        Exception exception = null;
        Connection connection = defaultPSSystemDeploy.getDefaultPSSystemDeployDB().getConnection();
        try {
            try {
                String strSQL = "SELECT t1.* FROM V_SRFFORM t1 WHERE DEID=?";
                CallParamList callParamList = new CallParamList();
                callParamList.Add((Object)psV3MigrateDE.getDEID());
                Vector<Form> formList = new Vector<>();
                callResult = BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)this.getGlobalHelper(), (Connection)connection, (String)"", (String)strSQL, (Vector)callParamList.GetList(), formList, (String)Form.class.getName());
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u8868\u5355\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                for (Form form : formList) {
                    PSV3MigrateDEForm psV3MigrateDEForm = new PSV3MigrateDEForm();
                    psV3MigrateDEForm.setPSV3MIGRATEID(psV3Migrate.getPSV3MIGRATEID());
                    psV3MigrateDEForm.setDEFORMID(form.getFORMID());
                    psV3MigrateDEForm.setPSV3MGFORMNAME(form.getFORMNAME());
                    psV3MigrateDEForm.setDEID(form.getDEID());
                    psV3MigrateDEForm.setDENAME(form.getParamStringValue("DATAENTITY_DENAME", ""));
                    callResult = psV3MigrateDEFormDataCtrl.AutoSave((BaseDataEntity)psV3MigrateDEForm);
                    if (!callResult.isError()) continue;
                    throw new Exception(StringHelper.Format((String)"\u4fdd\u6301\u8fc1\u79fb\u5b9e\u4f53\u8868\u5355\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
            }
            catch (Exception e) {
                log.error((Object)e.getMessage(), (Throwable)e);
                exception = new Exception(e);
                connection.close();
                if (exception != null) {
                    throw exception;
                }
            }
        }
        finally {
            connection.close();
            if (exception != null) {
                throw exception;
            }
        }
    }
}
