/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseCounterHelper
 *  SA.SRFDA.Ctrl.BaseDAQueryModelHelper
 *  SA.SRFDA.Ctrl.CounterResult
 *  SA.SRFDA.Ctrl.DefaultDAQueryModelUserContext
 *  SA.SRFDA.Ctrl.IDAActionContext
 *  SA.SRFramework.Data.CallParam
 *  SA.SRFramework.Data.DataSet
 *  SA.SRFramework.Data.SelectResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.ISRFExWebContext
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.Counter;

import SA.SRFDA.Ctrl.BaseCounterHelper;
import SA.SRFDA.Ctrl.BaseDAQueryModelHelper;
import SA.SRFDA.Ctrl.CounterResult;
import SA.SRFDA.Ctrl.DefaultDAQueryModelUserContext;
import SA.SRFDA.Ctrl.IDAActionContext;
import SA.SRFramework.Data.CallParam;
import SA.SRFramework.Data.DataSet;
import SA.SRFramework.Data.SelectResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.ISRFExWebContext;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DefaultCounterHelper
extends BaseCounterHelper {
    private static final Log log = LogFactory.getLog(DefaultCounterHelper.class);

    protected CounterResult OnCalc(IDAActionContext iDAActionContext) throws Exception {
        CounterResult counterResult = new CounterResult();
        DefaultDAQueryModelUserContext qmUserContext = null;
        String strQueryModel = this.counter.getQUERYMODELID();
        boolean bUserDP = this.counter.getENABLEUSERDP();
        String strDPDataAction = "";
        BaseDAQueryModelHelper daQueryModelHelper = null;
        daQueryModelHelper = bUserDP ? iDAActionContext.getWebContext().GetUserQueryModelStorage().FindDAQueryModelHelperEx(strQueryModel, strDPDataAction, false) : iDAActionContext.getWebContext().getGlobalHelper().getDAModelStorage().FindDAQueryModelHelper(strQueryModel);
        log.info((Object)StringHelper.Format((String)"\u67e5\u8be2 [%1$s]", (Object)strQueryModel));
        if (daQueryModelHelper == null) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u6a21\u578b\u8f85\u52a9\u5bf9\u8c61\u65e0\u6548"));
        }
        qmUserContext = new DefaultDAQueryModelUserContext();
        StringBuilderEx script = new StringBuilderEx();
        script.Append(this.GetDAModelQueryScript(iDAActionContext, daQueryModelHelper));
        Vector<String> userConditions = new Vector<String>();
        daQueryModelHelper.FillMajorConditions(userConditions);
        this.FillDAQueryModelHelperCondition(iDAActionContext, userConditions, daQueryModelHelper);
        if (userConditions.size() != 0) {
            script.Append(" WHERE ");
            boolean bFirst = true;
            for (String strCondition : userConditions) {
                if (bFirst) {
                    bFirst = false;
                } else {
                    script.Append(" AND ");
                }
                script.Append("(%1$s)", (Object)strCondition);
            }
        }
        String strCountSQL = String.valueOf(daQueryModelHelper.GetQMDeclareScript()) + qmUserContext.GetQMDeclareScript() + daQueryModelHelper.GetCountSQL(script.toString());
        strCountSQL = daQueryModelHelper.ReplaceURLParamMacro(strCountSQL, (ISRFExWebContext)iDAActionContext.getWebContext(), true);
        Vector<CallParam> list = new Vector<CallParam>();
        daQueryModelHelper.FillQMDeclareParams(list, iDAActionContext.getWebContext(), iDAActionContext.getWebContext().getGlobalHelper(), iDAActionContext.getWebContext().getCurUserId());
        qmUserContext.FillQMDeclareParams(list, iDAActionContext.getWebContext(), iDAActionContext.getWebContext().getGlobalHelper(), iDAActionContext.getWebContext().getCurUserId());
        daQueryModelHelper.FillCallParams(list, iDAActionContext.getWebContext(), iDAActionContext.getWebContext().getGlobalHelper(), iDAActionContext.getWebContext().getCurUserId());
        this.SelectAndFillCounterResult(iDAActionContext, daQueryModelHelper, strCountSQL, list, counterResult);
        return counterResult;
    }

    protected String GetDAModelQueryScript(IDAActionContext iDAActionContext, BaseDAQueryModelHelper daQueryModelHelper) {
        return daQueryModelHelper.GetQueryModelScript();
    }

    protected void FillDAQueryModelHelperCondition(IDAActionContext iDAActionContext, Vector<String> userConditions, BaseDAQueryModelHelper daQueryModelHelper) {
    }

    protected void SelectAndFillCounterResult(IDAActionContext iDAActionContext, BaseDAQueryModelHelper daQueryModelHelper, String strCountSQL, Vector<CallParam> list, CounterResult counterResult) throws Exception {
        SelectResult selectResult2 = iDAActionContext.getWebContext().getGlobalHelper().getDBCaller(daQueryModelHelper.GetMajorDEHelper().GetDBStorage()).CallRaw3(strCountSQL, list);
        if (selectResult2 == null) {
            throw new Exception("\u4e0d\u660e\u9519\u8bef");
        }
        if (selectResult2.getRetCode() != 0) {
            throw new Exception(StringHelper.Format((String)"\u8bb0\u5f55\u6570\u67e5\u8be2\u5931\u8d25\uff0c%1$s", (Object)selectResult2.getErrorInfo()));
        }
        if (selectResult2.getSelectData().getTableCount() != 1) {
            throw new Exception(StringHelper.Format((String)"\u8bb0\u5f55\u6570\u67e5\u8be2\u5931\u8d25\uff0c\u6ca1\u6709\u8fd4\u56de\u7ed3\u679c"));
        }
        DataSet dsCount = selectResult2.getSelectData();
        int nTotalRow = Integer.parseInt(dsCount.getTable(0).GetRow(0).Get("TOTALROW").toString());
        counterResult.setCount(nTotalRow);
    }
}

