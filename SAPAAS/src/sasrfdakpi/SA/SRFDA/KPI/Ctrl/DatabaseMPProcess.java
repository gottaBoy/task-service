/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DBResult
 *  SA.SRFramework.Data.SelectResult
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  groovy.lang.Binding
 *  groovy.lang.Script
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.KPI.Ctrl;

import SA.SRFDA.KPI.Ctrl.Data.KPIMP;
import SA.SRFDA.KPI.Ctrl.ISRFKPIContext;
import SA.SRFDA.KPI.Ctrl.ISRFMPProcess;
import SA.SRFramework.Data.DBResult;
import SA.SRFramework.Data.SelectResult;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import groovy.lang.Binding;
import groovy.lang.Script;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DatabaseMPProcess
extends Script
implements ISRFMPProcess {
    private static Log log = LogFactory.getLog(DatabaseMPProcess.class);

    @Override
    public CallResult Process(KPIMP kpiMp, ISRFKPIContext context) {
        CallResult callResult = new CallResult();
        String strExpression = "";
        try {
            String strRet = "";
            Binding binding = new Binding();
            binding.setProperty("kpi", (Object)context);
            binding.setVariable("ret", (Object)strRet);
            this.setBinding(binding);
            strExpression = "ret=" + kpiMp.getFORMULA() + ";";
            strRet = (String)this.evaluate(strExpression);
            log.info((Object)StringHelper.Format((String)"KPI\u6d4b\u70b9[%1$s]\r\n%2$s", (Object)kpiMp.getKPIMPNAME(), (Object)strRet));
            BaseDataEntity baseDataEntity = new BaseDataEntity();
            callResult = this.SelectRaw(context, strRet, baseDataEntity);
            if (callResult.getRetCode() != 0) {
                log.error((Object)StringHelper.Format((String)"\u67e5\u8be2KPI\u6d4b\u70b9[%1$s]\u5931\u8d25\uff0c%2$s", (Object)kpiMp.getKPIMPNAME(), (Object)callResult.getErrorInfo()));
                return callResult;
            }
            callResult.setUserObject(baseDataEntity.get("MPSCORE"));
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u6267\u884c\u8bed\u53e5[%1$s]\u5931\u8d25", (Object)strExpression), (Throwable)ex);
            callResult.setRetCode(1);
            return callResult;
        }
    }

    public Object run() {
        return "";
    }

    protected CallResult SelectRaw(ISRFKPIContext context, String strSQL, BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            SelectResult selectResult = context.getContextHelper().getDBCaller().CallRaw2(strSQL);
            if (selectResult == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo("\u4e0d\u660e\u9519\u8bef");
                return callResult;
            }
            if (selectResult.getRetCode() != 0) {
                callResult.From((DBResult)selectResult);
                return callResult;
            }
            if (selectResult.getMainTable() == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo("\u6ca1\u6709\u8fd4\u56de\u6570\u636e\u8868\u5bf9\u8c61");
                return callResult;
            }
            if (selectResult.getMainTable().GetRowCount() == 0) {
                callResult.setRetCode(3);
                return callResult;
            }
            dataEntity.FromDataRow(selectResult.getMainTable().GetRow(0));
            callResult.setRetCode(0);
            return callResult;
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }
}

