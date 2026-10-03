/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.CommonEx.Errors
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.IPSModelInitDataCtrl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSModelDEDataCtrl;
import SA.SRFDA.PS.Data.PSDEDBConfig;
import SA.SRFDA.PS.Data.PSDEDBSysProcCode;
import SA.SRFDA.PS.Data.PSDEFDTColumn;
import SA.SRFDA.PS.Data.PSDEFDTColumnV3;
import SA.SRFDA.PS.Data.PSDataEntity;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.CommonEx.Errors;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import java.util.Iterator;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEDBConfigDataCtrl
extends PSModelDEDataCtrl
implements IPSModelInitDataCtrl {
    private static final Log log = LogFactory.getLog(PSDEDBConfigDataCtrl.class);
    public static final String CUSTOMCALL_FIXDBCFG = "FIXDBCFG";

    @Override
    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        if (bInsert) {
            PSDEDBConfig psDEDBConfig = new PSDEDBConfig();
            psDEDBConfig.proxy(dataEntity);
            String strPSDEDBCFGNAME = psDEDBConfig.getPSDEDBCFGNAME().toUpperCase();
            psDEDBConfig.setPSDEDBCFGNAME(strPSDEDBCFGNAME);
            psDEDBConfig.setPSDEDBCFGID(Helper.GenUniqueId((String)psDEDBConfig.getPSDEID(), (String)strPSDEDBCFGNAME));
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
                Iterator<String> dbTypes = this.getPSModelStorage().getPSSystem(psDataEntity.getPSSYSTEMID()).getSupportDBTypes();
                while (dbTypes.hasNext()) {
                    String strDBType = dbTypes.next();
                    PSDEDBConfig psDEDBConfig = new PSDEDBConfig();
                    psDEDBConfig.setPSDEDBCFGNAME(strDBType);
                    psDEDBConfig.setPSDEID(psDataEntity.getPSDATAENTITYID());
                    psDEDBConfig.setPSDEDBCFGID(Helper.GenUniqueId((String)psDEDBConfig.getPSDEID(), (String)psDEDBConfig.getPSDEDBCFGNAME()));
                    callResult = this.Get(psDEDBConfig);
                    if (!Errors.IsSpecialError((int)callResult.getRetCode(), (int)3) || !(callResult = this.AutoSave(psDEDBConfig)).isError()) continue;
                    throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u4e91\u5b9e\u4f53\u6570\u636e\u5e93\u914d\u7f6e\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
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
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_FIXDBCFG, (boolean)true) == 0) {
            return this.fixDBConfig(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult fixDBConfig(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            PSDEDBConfig psDEDBConfig = new PSDEDBConfig();
            psDEDBConfig.proxy(dataEntity);
            this.onFixDBConfig(psDEDBConfig);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u4fee\u590d\u6570\u636e\u5e93\u5173\u8054\u914d\u7f6e\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onFixDBConfig(PSDEDBConfig psDEDBConfig) throws Exception {
        Vector<PSDEDBSysProcCode> psDESysProcCodeList;
        Vector<PSDEFDTColumnV3> psDEFDTColumnList;
        String srSQL = StringHelper.Format((String)" select t1.psdefieldid as PSDEFID,t1.psdefieldname as PSDEFNAME  from t_srfpsdefield t1 left join t_srfpsdefdtcol  t2 on (t1.PSDEFIELDID = t2.PSDEFID and t2.DBTYPE='%1$s' ) where t1.PSDEID='%2$s' AND t2.PSDEFDTCOLID is  null", (Object)psDEDBConfig.getPSDEDBCFGNAME(), (Object)psDEDBConfig.getPSDEID());
        CallResult callResult = BaseDEDataCtrl.SelectMulti((ISRFDAGlobalHelper)this.globalHelperEx, (String)srSQL, psDEFDTColumnList = new Vector<PSDEFDTColumnV3>(), (String)PSDEFDTColumnV3.class.getName());
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5c5e\u6027\u6570\u636e\u5217\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        if (psDEFDTColumnList.size() > 0) {
            IDEDataCtrl psDEFDTColumnDataCtrl = this.GetRelatedDataCtrl("DE2060");
            for (PSDEFDTColumnV3 psDEFDTColumn : psDEFDTColumnList) {
                psDEFDTColumn.setDBTYPE(psDEDBConfig.getPSDEDBCFGNAME());
                callResult = psDEFDTColumnDataCtrl.Save(true, (BaseDataEntity)psDEFDTColumn);
                if (!callResult.isError()) continue;
                throw new Exception(StringHelper.Format((String)"\u5efa\u7acb\u5c5e\u6027\u6570\u636e\u5217\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
        }
        if ((callResult = BaseDEDataCtrl.SelectMulti((ISRFDAGlobalHelper)this.globalHelperEx, (String)(srSQL = StringHelper.Format((String)" select t1.PSDESYSPROCID ,t1.PSDESYSPROCNAME  from t_srfpsdesysproc t1\t\t\t left join t_srfPSDESPCODE  t2 on (t1.PSDESYSPROCID = t2.PSDESYSPROCID and t2.PSDESPCODENAME='%1$s' ) where t1.PSDEID='%2$s' AND t2.PSDESPCODEID is  null", (Object)psDEDBConfig.getPSDEDBCFGNAME(), (Object)psDEDBConfig.getPSDEID())), psDESysProcCodeList = new Vector(), (String)PSDEDBSysProcCode.class.getName())).isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2 \u5b58\u50a8\u8fc7\u7a0b\u4ee3\u7801\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        if (psDESysProcCodeList.size() > 0) {
            IDEDataCtrl psDESysProcCodeDataCtrl = this.GetRelatedDataCtrl("DE2072");
            for (PSDEDBSysProcCode psDESysProcCode : psDESysProcCodeList) {
                psDESysProcCode.setPSDESPCODENAME(psDEDBConfig.getPSDEDBCFGNAME());
                callResult = psDESysProcCodeDataCtrl.Save(true, (BaseDataEntity)psDESysProcCode);
                if (!callResult.isError()) continue;
                throw new Exception(StringHelper.Format((String)"\u5efa\u7acb\u5b58\u50a8\u8fc7\u7a0b\u4ee3\u7801\u5217\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
        }
    }
}
