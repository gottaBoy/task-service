/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.util.Base64Helper
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.PS.Core.Database.IPSDBType;
import SA.SRFDA.PS.Core.Database.IPSDBType3;
import SA.SRFDA.PS.Core.Database.IPSDBType4;
import SA.SRFDA.PS.Core.Deploy.IPSDBDevInst;
import SA.SRFDA.PS.Core.DevStudio.IPSBKTaskWork;
import SA.SRFDA.PS.Core.DevStudio.PSBKTaskWorkHelper;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.PS.Data.PSDCBKTask;
import SA.SRFDA.PS.Data.PSDCDBInstBK;
import SA.SRFDA.PS.Data.PSDevCenterDBInst;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Vector;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.util.Base64Helper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDCDBInstDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSDCDBInstDataCtrl.class);
    public static final String CUSTOMCALL_GETTABLES = "GETTABLES";
    public static final String CUSTOMCALL_GETVIEWS = "GETVIEWS";
    public static final String CUSTOMCALL_EXECUTESQL = "EXECUTESQL";
    public static final String CUSTOMCALL_BACKUP = "BACKUP";
    public static final String CUSTOMCALL_OFFLINE = "OFFLINE";
    public static final String CUSTOMCALL_RESTORE = "RESTORE";
    public static final String CUSTOMCALL_ASYNCBACKUP = "ASYNCBACKUP";
    public static final String MODELTYPE_TABLE = "TABLE";
    public static final String MODELTYPE_VIEW = "VIEW";
    public static final String TAG_MODELLIST = "SRFMODELLIST";
    public static final String TAG_UPDATECOUNT = "SRFUPDATECOUNT";
    public static final String TAG_SQLERROR = "SRFSQLERROR";
    public static final String PREFIX_JITDBINST = "JITDBINST:";

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
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_GETTABLES, (boolean)true) == 0) {
            return this.getDBModels(dataEntity, MODELTYPE_TABLE);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_GETVIEWS, (boolean)true) == 0) {
            return this.getDBModels(dataEntity, MODELTYPE_VIEW);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_EXECUTESQL, (boolean)true) == 0) {
            return this.executeSQL(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_BACKUP, (boolean)true) == 0) {
            return this.backupDBInst(dataEntity, false);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_OFFLINE, (boolean)true) == 0) {
            return this.backupDBInst(dataEntity, true);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_RESTORE, (boolean)true) == 0) {
            return this.restoreDBInst(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_ASYNCBACKUP, (boolean)true) == 0) {
            return this.asyncBackupDBInst(dataEntity, false);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult getDBModels(BaseDataEntity dataEntity, String strType) {
        String strFilter = dataEntity.getParamStringValue("SRFFILTER", "");
        CallResult callResult = new CallResult();
        String strKey = dataEntity.getParamStringValue("PSDEVCENTERDBINSTID", "");
        if (StringHelper.IsNullOrEmpty((String)strKey)) {
            callResult.setRetCode(4);
            return callResult;
        }
        if (strKey.indexOf(PREFIX_JITDBINST) != 0) {
            callResult = this.Get(dataEntity);
            if (callResult.IsError()) {
                return callResult;
            }
        } else {
            String strPSDBDevInst = strKey.substring(PREFIX_JITDBINST.length());
            dataEntity.setParamValue("PSDBDEVINSTID", (Object)strPSDBDevInst);
        }
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            PSDevCenterDBInst psDevCenterDBInst = new PSDevCenterDBInst();
            psDevCenterDBInst.proxy(dataEntity);
            this.onGetDBModels(psDevCenterDBInst, strType, strFilter);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6570\u636e\u5e93\u6a21\u578b\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onGetDBModels(PSDevCenterDBInst psDevCenterDBInst, String strType, String strFilter) throws Exception {
        IPSDBDevInst iPSDBDevInst = this.getPSModelStorage().getPSDBDevInst(psDevCenterDBInst.getPSDBDEVINSTID());
        IPSDBType iPSDBType = this.getPSModelStorage().getPSDBType(iPSDBDevInst.getDBType());
        if (!(iPSDBType instanceof IPSDBType3)) {
            throw new Exception(StringHelper.Format((String)"\u6570\u636e\u5e93\u7c7b\u578b[%1$s]\u672a\u63d0\u4f9b\u6a21\u578b\u67e5\u8be2\u80fd\u529b", (Object)iPSDBType.getName()));
        }
        IPSDBType3 iPSDBType3 = (IPSDBType3)((Object)iPSDBType);
        Vector<BaseDataEntity> modelList = new Vector<BaseDataEntity>();
        if (StringHelper.Compare((String)strType, (String)MODELTYPE_TABLE, (boolean)true) == 0) {
            CallResult callResult = iPSDBType3.getTables(iPSDBDevInst, strFilter, modelList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u6570\u636e\u5e93\u6a21\u578b\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psDevCenterDBInst.set(TAG_MODELLIST, Base64Helper.encodeBytes((byte[])PSDCDBInstDataCtrl.toJsonString(modelList).getBytes()));
            return;
        }
        if (StringHelper.Compare((String)strType, (String)MODELTYPE_VIEW, (boolean)true) == 0) {
            CallResult callResult = iPSDBType3.getViews(iPSDBDevInst, strFilter, modelList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u6570\u636e\u5e93\u6a21\u578b\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psDevCenterDBInst.set(TAG_MODELLIST, Base64Helper.encodeBytes((byte[])PSDCDBInstDataCtrl.toJsonString(modelList).getBytes()));
            return;
        }
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u6570\u636e\u5e93\u6a21\u578b\u7c7b\u578b[%1$s]", (Object)strType));
    }

    public static String toJsonString(Vector<BaseDataEntity> modelList) throws Exception {
        return PSDCDBInstDataCtrl.toJsonString(modelList, false);
    }

    public static String toJsonString(Vector<BaseDataEntity> modelList, boolean bConvertTime) throws Exception {
        ArrayList<JSONObject> list = new ArrayList<JSONObject>();
        for (BaseDataEntity baseDataEntity : modelList) {
            JSONObject jo = BaseDataEntity.ToJSONObject((BaseDataEntity)baseDataEntity, (boolean)false);
            if (bConvertTime) {
                jo = DataObject.convertJSONValueTimeFmt((JSONObject)jo, (String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS.%1$tL");
            }
            list.add(jo);
        }
        return JSONArray.fromArray((Object[])list.toArray()).toString();
    }

    public CallResult executeSQL(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        String strSQL = dataEntity.getParamStringValue("SRFSQL", "");
        String strKey = dataEntity.getParamStringValue("PSDEVCENTERDBINSTID", "");
        if (StringHelper.IsNullOrEmpty((String)strKey)) {
            callResult.setRetCode(4);
            return callResult;
        }
        if (strKey.indexOf(PREFIX_JITDBINST) != 0) {
            callResult = this.Get(dataEntity);
            if (callResult.IsError()) {
                return callResult;
            }
        } else {
            String strPSDBDevInst = strKey.substring(PREFIX_JITDBINST.length());
            dataEntity.setParamValue("PSDBDEVINSTID", (Object)strPSDBDevInst);
        }
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            PSDevCenterDBInst psDevCenterDBInst = new PSDevCenterDBInst();
            psDevCenterDBInst.proxy(dataEntity);
            this.onExecuteSQL(psDevCenterDBInst, strSQL);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u6267\u884cSQL\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onExecuteSQL(PSDevCenterDBInst psDevCenterDBInst, String strSQL) throws Exception {
        IPSDBDevInst iPSDBDevInst = this.getPSModelStorage().getPSDBDevInst(psDevCenterDBInst.getPSDBDEVINSTID());
        IPSDBType iPSDBType = this.getPSModelStorage().getPSDBType(iPSDBDevInst.getDBType());
        if (!(iPSDBType instanceof IPSDBType3)) {
            throw new Exception(StringHelper.Format((String)"\u6570\u636e\u5e93\u7c7b\u578b[%1$s]\u672a\u63d0\u4f9bSQL\u6267\u884c\u80fd\u529b", (Object)iPSDBType.getName()));
        }
        IPSDBType3 iPSDBType3 = (IPSDBType3)((Object)iPSDBType);
        Vector<BaseDataEntity> modelList = new Vector<BaseDataEntity>();
        CallResult callResult = iPSDBType3.executeSQL(iPSDBDevInst, strSQL, modelList);
        if (callResult.isError()) {
            psDevCenterDBInst.set(TAG_SQLERROR, callResult.getErrorInfo());
            return;
        }
        psDevCenterDBInst.set(TAG_MODELLIST, Base64Helper.encodeBytes((byte[])PSDCDBInstDataCtrl.toJsonString(modelList, true).getBytes()));
        if (callResult.getUserObject() != null) {
            JSONObject jo = (JSONObject)callResult.getUserObject();
            psDevCenterDBInst.set(TAG_UPDATECOUNT, jo.opt("updatecount"));
            JSONArray jArray = jo.optJSONArray("columns");
            if (jArray != null) {
                psDevCenterDBInst.set("SRFCOLUMNS", Base64Helper.encodeBytes((byte[])jArray.toString().getBytes()));
            }
        }
    }

    public CallResult backupDBInst(BaseDataEntity dataEntity, boolean bOffline) {
        CallResult callResult = new CallResult();
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            final PSDevCenterDBInst psDevCenterDBInst = new PSDevCenterDBInst();
            final boolean bOffline2 = bOffline;
            psDevCenterDBInst.proxy(dataEntity);
            this.Get(psDevCenterDBInst);
            PSBKTaskWorkHelper.execute(new IPSBKTaskWork(){

                @Override
                public void execute(Object obj) throws Exception {
                    PSDCDBInstDataCtrl.this.onBackupDBInst(psDevCenterDBInst, bOffline2);
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5907\u4efd\u6570\u636e\u5e93\u5b9e\u4f8b\u4fe1\u606f\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onBackupDBInst(PSDevCenterDBInst psDevCenterDBInst, boolean bOffline) throws Exception {
        IPSDBType iPSDBType = this.getPSModelStorage().getPSDBType(psDevCenterDBInst.getDBTYPE());
        if (!(iPSDBType instanceof IPSDBType4)) {
            throw new Exception(StringHelper.Format((String)"\u6570\u636e\u5e93\u7c7b\u578b[%1$s]\u4e0d\u652f\u6301\u6b64\u64cd\u4f5c", (Object)iPSDBType.getName()));
        }
        IPSDBType4 iPSDBType4 = (IPSDBType4)((Object)iPSDBType);
        PSDCDBInstBK psDevCenterDBInstBk = new PSDCDBInstBK();
        iPSDBType4.backupDBInst("PSDEVCENTERDBINST", psDevCenterDBInst, psDevCenterDBInstBk, bOffline);
    }

    public CallResult asyncBackupDBInst(BaseDataEntity dataEntity, boolean bOffline) {
        CallResult callResult = new CallResult();
        try {
            PSDevCenterDBInst psDevCenterDBInst = new PSDevCenterDBInst();
            boolean bOffline2 = bOffline;
            psDevCenterDBInst.proxy(dataEntity);
            this.Get(psDevCenterDBInst);
            this.onAsyncBackupDBInst(psDevCenterDBInst, bOffline2);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5907\u4efd\u6570\u636e\u5e93\u5b9e\u4f8b\u4fe1\u606f\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onAsyncBackupDBInst(PSDevCenterDBInst psDevCenterDBInst, boolean bOffline) throws Exception {
        PSDCBKTask psDCBKTask = new PSDCBKTask();
        psDCBKTask.setPSDEVCENTERID(psDevCenterDBInst.getPSDEVCENTERID());
        psDCBKTask.setPSDEVCENTERNAME(psDevCenterDBInst.getPSDEVCENTERNAME());
        psDCBKTask.setPSDCBKTASKNAME(StringHelper.Format((String)"\u521b\u5efa\u5e94\u7528\u4e2d\u5fc3\u6570\u636e\u5e93\u5b9e\u4f8b[%1$s]\u5907\u4efd", (Object)psDevCenterDBInst.getPSDEVCENTERDBINSTNAME()));
        psDCBKTask.setTASKSTATE(10);
        psDCBKTask.setORDERVALUE(100);
        psDCBKTask.setTASKTYPE("BACKUPDCDBINST");
        psDCBKTask.setTASKPARAM(psDevCenterDBInst.getPSDEVCENTERDBINSTID());
        IDEDataCtrl psDCBKTaskDataCtrl = this.GetRelatedDataCtrl("DE2984");
        CallResult callResult = psDCBKTaskDataCtrl.Save(true, (BaseDataEntity)psDCBKTask);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u521b\u5efa\u5e94\u7528\u4e2d\u5fc3\u4efb\u52a1\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        this.getPSModelStorage().getPSDevCenterBKTaskGlobal().addPSDCBKTask(psDCBKTask);
    }

    public CallResult restoreDBInst(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            final PSDevCenterDBInst psDevCenterDBInst = new PSDevCenterDBInst();
            psDevCenterDBInst.proxy(dataEntity);
            this.Get(psDevCenterDBInst);
            PSBKTaskWorkHelper.execute(new IPSBKTaskWork(){

                @Override
                public void execute(Object obj) throws Exception {
                    PSDCDBInstDataCtrl.this.onRestoreDBInst(psDevCenterDBInst);
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5907\u4efd\u6a21\u578b\u5b9e\u4f8b\u7a7a\u95f4\u4fe1\u606f\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onRestoreDBInst(PSDevCenterDBInst psDevCenterDBInst) throws Exception {
        IPSDBType iPSDBType = this.getPSModelStorage().getPSDBType(psDevCenterDBInst.getDBTYPE());
        if (!(iPSDBType instanceof IPSDBType4)) {
            throw new Exception(StringHelper.Format((String)"\u6570\u636e\u5e93\u7c7b\u578b[%1$s]\u4e0d\u652f\u6301\u6b64\u64cd\u4f5c", (Object)iPSDBType.getName()));
        }
        IPSDBType4 iPSDBType4 = (IPSDBType4)((Object)iPSDBType);
    }
}

