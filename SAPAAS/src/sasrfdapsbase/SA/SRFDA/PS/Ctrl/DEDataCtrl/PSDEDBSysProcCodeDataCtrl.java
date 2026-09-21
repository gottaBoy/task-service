/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.db.SqlParam
 *  net.ibizsys.paas.db.SqlParamList
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.Database.IPSDBSysProcTempl;
import SA.SRFDA.PS.Core.Database.IPSDBType;
import SA.SRFDA.PS.Core.Deploy.IPSDBDevInst;
import SA.SRFDA.PS.Core.Pub.IPSDBSysProcCodePublisher;
import SA.SRFDA.PS.Core.Pub.PSPublishContextImpl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.IPSModelInitDataCtrl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSModelDEDataCtrl;
import SA.SRFDA.PS.Data.PSDBProcParam;
import SA.SRFDA.PS.Data.PSDEDBSysProc;
import SA.SRFDA.PS.Data.PSDEDBSysProcCode;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import net.ibizsys.paas.db.SqlParam;
import net.ibizsys.paas.db.SqlParamList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEDBSysProcCodeDataCtrl
extends PSModelDEDataCtrl
implements IPSModelInitDataCtrl {
    private static final Log log = LogFactory.getLog(PSDEDBSysProcCodeDataCtrl.class);
    public static final String CUSTOMCALL_COMPILECODE = "COMPILECODE";
    public static final String CUSTOMCALL_GENERATECODE = "GENERATECODE";

    @Override
    protected CallResult OnBeforeSave(boolean bInsert, String strCodeMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strCodeMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        return callResult;
    }

    @Override
    protected CallResult OnAfterSaveOK(boolean bInsert, String strCodeMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnAfterSaveOK(bInsert, strCodeMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        return callResult;
    }

    protected CallResult OnBeforeRemove(String strCodeMode, BaseDataEntity dataEntity) {
        return super.OnBeforeRemove(strCodeMode, dataEntity);
    }

    protected CallResult OnAfterRemoveOK(String strCodeMode, BaseDataEntity dataEntity) {
        return super.OnAfterRemoveOK(strCodeMode, dataEntity);
    }

    @Override
    public CallResult initModel(String strDEId, BaseDataEntity dataEntity, String strMode) {
        CallResult callResult = new CallResult();
        try {
            if (StringHelper.Compare((String)strDEId, (String)"DE2070", (boolean)true) == 0) {
                PSDEDBSysProc psDESysProc = new PSDEDBSysProc();
                psDESysProc.proxy(dataEntity);
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
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_COMPILECODE, (boolean)true) == 0) {
            return this.compileCode(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_GENERATECODE, (boolean)true) == 0) {
            return this.generateCode(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult generateCode(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            PSDEDBSysProcCode psDESysProcCode = new PSDEDBSysProcCode();
            psDESysProcCode.proxy(dataEntity);
            this.onGenerateCode(psDESysProcCode);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u53d1\u5e03\u7cfb\u7edf\u4ee3\u7801\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onGenerateCode(PSDEDBSysProcCode psDESysProcCode) throws Exception {
        PSDEDBSysProc psDESysProc = new PSDEDBSysProc();
        psDESysProcCode.CopyTo(psDESysProc, true);
        IPSDBType iPSDBType = this.getPSModelStorage().getPSDBType(psDESysProcCode.getPSDESPCODENAME());
        IPSDBSysProcTempl iPSDBSysProcTempl = iPSDBType.getPSDBSysProcTempl(psDESysProcCode.getSYSPROCTYPE());
        IPSDBSysProcCodePublisher iPSDBSysProcCodePublisher = iPSDBSysProcTempl.getPSDBSysProcCodePublisher();
        PSPublishContextImpl psPublishContextImpl = new PSPublishContextImpl((IDEDataCtrl)this);
        iPSDBSysProcCodePublisher.generateCode(psPublishContextImpl, psDESysProc);
        iPSDBSysProcCodePublisher.close();
    }

    public CallResult compileCode(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            PSDEDBSysProcCode psDESysProcCode = new PSDEDBSysProcCode();
            psDESysProcCode.proxy(dataEntity);
            this.onCompileCode(psDESysProcCode);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u53d1\u5e03\u7cfb\u7edf\u4ee3\u7801\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onCompileCode(PSDEDBSysProcCode psDESysProcCode) throws Exception {
        PSDEDBSysProcCode psDESysProcCode2 = new PSDEDBSysProcCode();
        psDESysProcCode2.setPSDESPCODEID(psDESysProcCode.getPSDESPCODEID());
        IPSDataEntity iPSDataEntity = this.getPSModelStorage().getPSDataEntity(psDESysProcCode.getPSDEID());
        IPSDBDevInst iPSDBDevInst = this.getPSModelStorage().getPSDBDevInst(iPSDataEntity.getPSSystem().getPSSystemDBConfig(psDESysProcCode.getPSDESPCODENAME()).getPSDBDevInstId());
        IPSDBType iPSDBType = this.getPSModelStorage().getPSDBType(psDESysProcCode.getPSDESPCODENAME());
        CallResult callResult = iPSDBType.compileDBProc(iPSDBDevInst, psDESysProcCode.getPSDESYSPROCNAME(), psDESysProcCode.getFULLCODE());
        if (callResult.isError()) {
            psDESysProcCode2.setCOMPILEFLAG(1);
        } else {
            psDESysProcCode2.setCOMPILEFLAG(0);
        }
        callResult = this.Save(false, psDESysProcCode2);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u66f4\u65b0\u7cfb\u7edf\u8fc7\u7a0b\u7f16\u8bd1\u72b6\u6001\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        IDEDataCtrl psDBProcParamDataCtrl = this.GetRelatedDataCtrl("DE2089");
        BaseDataEntity cond = new BaseDataEntity();
        cond.setParamValue("PSDESPCODEID", (Object)psDESysProcCode2.getPSDESPCODEID());
        callResult = psDBProcParamDataCtrl.RemoveMulti(cond);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u5220\u9664\u7cfb\u7edf\u8fc7\u7a0b\u53c2\u6570\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        int nIndex = 0;
        SqlParamList sqlParamList = iPSDBType.getDBProcParamList(iPSDBDevInst, psDESysProcCode.getPSDESYSPROCNAME());
        for (SqlParam sqlParam : sqlParamList) {
            PSDBProcParam psDBProcParam = new PSDBProcParam();
            psDBProcParam.setPSDBPROCPARAMNAME(sqlParam.getParamName());
            psDBProcParam.setPSDESPCODEID(psDESysProcCode2.getPSDESPCODEID());
            psDBProcParam.setORDERVALUE(++nIndex);
            psDBProcParam.setPARAMDIR(sqlParam.getDirection());
            psDBProcParam.setJDBCTYPE(sqlParam.getDataType());
            callResult = psDBProcParamDataCtrl.Save(true, (BaseDataEntity)psDBProcParam);
            if (!callResult.isError()) continue;
            throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u7cfb\u7edf\u8fc7\u7a0b\u53c2\u6570\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
    }
}

