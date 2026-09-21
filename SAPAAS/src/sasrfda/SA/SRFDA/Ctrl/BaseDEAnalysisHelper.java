/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.CallParamList
 *  SA.SRFramework.Data.DBResult
 *  SA.SRFramework.Data.SelectResult
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.Data.DEAnalysis;
import SA.SRFDA.Ctrl.IDEAnalysisHelper;
import SA.SRFDA.Ctrl.IDEDataCtrlHelper;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.CallParamList;
import SA.SRFramework.Data.DBResult;
import SA.SRFramework.Data.SelectResult;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class BaseDEAnalysisHelper
implements IDEAnalysisHelper {
    protected DEAnalysis deAnalysis;
    protected ISRFDAGlobalHelper iDAGlobalHelper;
    protected String strDBStorage = "";
    protected String strProcPreFix = "srfsp_";
    protected String strProcName = "";
    protected boolean bNeedCheckProcExist = true;
    private static final Log log = LogFactory.getLog(BaseDEAnalysisHelper.class);

    @Override
    public CallResult Init(DEAnalysis deAnalysis, ISRFDAGlobalHelper iDAGlobalHelper) {
        this.deAnalysis = deAnalysis;
        this.iDAGlobalHelper = iDAGlobalHelper;
        IDEHelper iDEHelper = iDAGlobalHelper.getDAModelStorage().FindDEHelper(deAnalysis.getDEID());
        if (iDEHelper == null) {
            CallResult callResult = new CallResult();
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)deAnalysis.getDEID()));
            return callResult;
        }
        this.strDBStorage = iDEHelper.GetDBStorage();
        this.strProcName = StringHelper.Format((String)"%1$s%2$s_%3$s_V%4$s", (Object)this.strProcPreFix, (Object)iDEHelper.getName(), (Object)deAnalysis.getPROCNAME(), (Object)deAnalysis.getANALYSISVERSION());
        return this.OnInit();
    }

    protected CallResult OnInit() {
        CallResult callResult = new CallResult();
        return callResult;
    }

    @Override
    public CallResult Execute() {
        String strSQL;
        CallResult callResult = new CallResult();
        if (!this.IsProcExist() && (callResult = this.CompileProc(strSQL = (String)callResult.getUserObject())).IsError()) {
            return callResult;
        }
        CallParamList callParamList = new CallParamList();
        callParamList.AddString("SYSTEM");
        callParamList.AddRetCode();
        callParamList.AddRetInfo();
        callParamList.AddOutputTag();
        callParamList.AddString(this.deAnalysis.getDEANALYSISID());
        try {
            SelectResult result = this.iDAGlobalHelper.getDBCaller(this.strDBStorage).CallRaw4(null, this.strProcName, callParamList.GetList());
            callResult.From((DBResult)result);
            callResult.setUserObject((Object)result);
            if (callResult.getRetCode() == 0) {
                Object objRetCode = result.getOutValues().get("SRF_RETCODE");
                Object objRetInfo = result.getOutValues().get("SRF_RETINFO");
                callResult.setRetCode(Integer.parseInt(objRetCode.toString()));
                if (objRetInfo != null) {
                    callResult.setErrorInfo(objRetInfo.toString());
                }
            }
            return callResult;
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    @Override
    public CallResult GetProcCode() {
        StringBuilderEx stringBuilder = new StringBuilderEx();
        this.APPEND_PROC_HEADER(stringBuilder);
        this.APPEND_PROC_BODY(stringBuilder);
        CallResult callResult = new CallResult();
        callResult.setRetCode(0);
        callResult.setUserObject((Object)stringBuilder.toString());
        return callResult;
    }

    @Override
    public CallResult PublishProcCode() {
        CallResult callResult = new CallResult();
        if (!this.IsProcExist()) {
            return callResult;
        }
        this.bNeedCheckProcExist = true;
        String strSQL = this.GetDEDataCtrlHelper().GetSQL_DropProc(this.strProcName);
        if (!StringHelper.IsNullOrEmpty((String)strSQL)) {
            this.DropProc(this.strProcName, strSQL);
        }
        if ((callResult = this.GetProcCode()).IsError()) {
            return callResult;
        }
        strSQL = (String)callResult.getUserObject();
        callResult = this.CompileProc(strSQL);
        this.bNeedCheckProcExist = true;
        return callResult;
    }

    protected CallResult CompileProc(String strSQL) {
        CallResult calLResult = new CallResult();
        try {
            SelectResult result = this.iDAGlobalHelper.getDBCaller(this.strDBStorage).CallRaw2(strSQL);
            if (result.getRetCode() != 0) {
                calLResult.From((DBResult)result);
                return calLResult;
            }
            if (this.IsProcExist()) {
                calLResult.setRetCode(0);
                return calLResult;
            }
            calLResult.setRetCode(1);
            return calLResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u7f16\u8bd1\u8fc7\u7a0b[%1$s]\u51fa\u73b0\u9519\u8bef", (Object)this.strProcName), (Throwable)ex);
            calLResult.setRetCode(1);
            calLResult.setErrorInfo(StringHelper.Format((String)"\u7f16\u8bd1\u8fc7\u7a0b[%1$s]\u51fa\u73b0\u9519\u8bef", (Object)this.strProcName));
            return calLResult;
        }
    }

    protected void APPEND_PROC_HEADER(StringBuilderEx stringBuilder) {
    }

    protected void APPEND_PROC_BODY(StringBuilderEx stringBuilder) {
    }

    protected IDEDataCtrlHelper GetDEDataCtrlHelper(String strDBStorage) {
        return this.iDAGlobalHelper.getDEDataCtrlHelper(strDBStorage);
    }

    protected IDEDataCtrlHelper GetDEDataCtrlHelper() {
        return this.iDAGlobalHelper.getDEDataCtrlHelper(this.strDBStorage);
    }

    protected boolean IsProcExist() {
        BaseDataEntity rowCount;
        if (!this.bNeedCheckProcExist) {
            return true;
        }
        String strSQL = this.GetDEDataCtrlHelper().GetSQL_IsProcExist(this.strProcName);
        CallResult callResult = BaseDEDataCtrl.SelectSingleEx(this.iDAGlobalHelper, this.strDBStorage, strSQL, rowCount = new BaseDataEntity());
        if (callResult.getRetCode() != 0) {
            return false;
        }
        int nRowCnt = rowCount.GetParamIntValue("ROWCOUNT", 0);
        if (nRowCnt == 1) {
            this.bNeedCheckProcExist = false;
        }
        return nRowCnt == 1;
    }

    protected CallResult DropProc(String strProcName, String strSQL) {
        CallResult calLResult = new CallResult();
        try {
            DBResult result = this.iDAGlobalHelper.getDBCaller(this.strDBStorage).CallRaw3WithoutReturn(strSQL, null);
            if (result.getRetCode() != 0) {
                calLResult.From(result);
                return calLResult;
            }
            if (this.IsProcExist()) {
                calLResult.setRetCode(1);
                return calLResult;
            }
            calLResult.setRetCode(0);
            return calLResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5220\u9664\u8fc7\u7a0b[%1$s]\u51fa\u73b0\u9519\u8bef", (Object)strProcName), (Throwable)ex);
            calLResult.setRetCode(1);
            calLResult.setErrorInfo(StringHelper.Format((String)"\u5220\u9664\u8fc7\u7a0b[%1$s]\u51fa\u73b0\u9519\u8bef", (Object)strProcName));
            return calLResult;
        }
    }

    protected String GETSQL_PROC_BODY_USERDECLARE() {
        return this.deAnalysis.getPARAMCODE().replace("\r\n", "\n");
    }

    protected String GETSQL_PROC_BODY_USERINIT() {
        return this.deAnalysis.getPARAMINITCODE().replace("\r\n", "\n");
    }

    protected String GETSQL_PROC_BODY_RUNCODE() {
        return this.deAnalysis.getQUERYCMD().replace("\r\n", "\n");
    }

    protected String GETSQL_PROC_BODY_BEFORECODE() {
        return this.deAnalysis.getBEFORECODE().replace("\r\n", "\n");
    }

    protected String GETSQL_PROC_BODY_AFTERCODE() {
        return this.deAnalysis.getAFTERCODE().replace("\r\n", "\n");
    }

    protected String GETSQL_PROC_BODY_LOOPBEFORECODE() {
        return this.deAnalysis.getLOOPBEFORECODE().replace("\r\n", "\n");
    }

    protected String GETSQL_PROC_BODY_LOOPAFTERCODE() {
        return this.deAnalysis.getLOOPAFTERCODE().replace("\r\n", "\n");
    }
}

