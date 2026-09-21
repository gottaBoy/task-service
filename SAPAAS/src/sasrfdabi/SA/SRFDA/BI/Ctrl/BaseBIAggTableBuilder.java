/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEDataCtrlHelper
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.DBResult
 *  SA.SRFramework.Data.SelectResult
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.Data.BIAggTable;
import SA.SRFDA.BI.Ctrl.ISRFDABIAggTableBuilder;
import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.IDEDataCtrlHelper;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.DBResult;
import SA.SRFramework.Data.SelectResult;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class BaseBIAggTableBuilder
implements ISRFDABIAggTableBuilder {
    protected ISRFDAGlobalHelper iDAGlobalHelper = null;
    protected IDEHelper aggTableDEHelper = null;
    protected BIAggTable aggTable = null;
    private static final Log log = LogFactory.getLog(BaseBIAggTableBuilder.class);

    @Override
    public CallResult Init(ISRFDAGlobalHelper iDAGlobalHelper, BIAggTable aggTable) {
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.aggTable = aggTable;
        this.aggTableDEHelper = iDAGlobalHelper.getDAModelStorage().FindDEHelper(aggTable.getDEID());
        return this.OnInit();
    }

    protected CallResult OnInit() {
        return new CallResult();
    }

    protected String GetAggFunc(String strAggregator) {
        return strAggregator;
    }

    protected IDEDataCtrlHelper GetDEDataCtrlHelper() {
        return this.iDAGlobalHelper.getDEDataCtrlHelper(this.aggTableDEHelper.GetDBStorage());
    }

    protected CallResult CompileDBProc(String strProcName, String strSQL) {
        CallResult calLResult = new CallResult();
        try {
            SelectResult result = this.iDAGlobalHelper.getDBCaller(this.aggTableDEHelper.GetDBStorage()).CallRaw2(strSQL);
            if (result.getRetCode() != 0) {
                calLResult.From((DBResult)result);
                return calLResult;
            }
            if (this.IsDBProcExist(strProcName)) {
                calLResult.setRetCode(0);
                return calLResult;
            }
            calLResult.setRetCode(1);
            return calLResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5220\u9664\u8fc7\u7a0b[%1$s]\u51fa\u73b0\u9519\u8bef", (Object)strProcName), (Throwable)ex);
            calLResult.setRetCode(1);
            calLResult.setErrorInfo(StringHelper.Format((String)"\u5220\u9664\u8fc7\u7a0b[%1$s]\u51fa\u73b0\u9519\u8bef", (Object)strProcName));
            return calLResult;
        }
    }

    protected CallResult DropDBProc(String strProcName) {
        CallResult calLResult = new CallResult();
        try {
            if (this.IsDBProcExist(strProcName)) {
                String strSQL = this.GetDEDataCtrlHelper().GetSQL_DropProc(strProcName);
                DBResult result = this.iDAGlobalHelper.getDBCaller(this.aggTableDEHelper.GetDBStorage()).CallRaw3WithoutReturn(strSQL, null);
                if (result.getRetCode() != 0) {
                    calLResult.From(result);
                    return calLResult;
                }
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

    protected boolean IsDBProcExist(String strProcName) {
        String strSQL = this.GetDEDataCtrlHelper().GetSQL_IsProcExist(strProcName);
        BaseDataEntity rowCount = new BaseDataEntity();
        CallResult callResult = BaseDEDataCtrl.SelectSingleEx((ISRFDAGlobalHelper)this.iDAGlobalHelper, (String)this.aggTableDEHelper.GetDBStorage(), (String)strSQL, (BaseDataEntity)rowCount);
        if (callResult.getRetCode() != 0) {
            return false;
        }
        Integer nRowCnt = rowCount.GetParamIntValue("ROWCOUNT", 0);
        return nRowCnt == 1;
    }
}

