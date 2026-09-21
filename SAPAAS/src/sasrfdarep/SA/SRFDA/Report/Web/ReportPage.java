/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAQueryModelHelper
 *  SA.SRFDA.Ctrl.Data.Report
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.SRFDAPage
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.CallParam
 *  SA.SRFramework.Data.SelectResult
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.ISRFExWebContext
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Report.Web;

import SA.SRFDA.Ctrl.BaseDAQueryModelHelper;
import SA.SRFDA.Ctrl.Data.Report;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.CallParam;
import SA.SRFramework.Data.SelectResult;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.ISRFExWebContext;
import java.io.File;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ReportPage
extends SRFDAPage {
    protected Report report = new Report();
    private static final Log log = LogFactory.getLog(ReportPage.class);

    public ReportPage() {
        this.setMainPage(true);
        this.setOutputDebug(false);
    }

    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        String strReportId = this.getWebContext().GetParamValue("REPORTID");
        if (StringHelper.IsNullOrEmpty((String)strReportId)) {
            this.PageLog((Object)this, 1, "\u6ca1\u6709\u6307\u5b9a\u62a5\u8868\u7f16\u53f7");
            return false;
        }
        CallResult callResult = this.getDAModelHelper().GetReport(strReportId, this.report);
        if (callResult.getRetCode() != 0) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u62a5\u8868[%1$s]\uff0c%2$s", (Object)strReportId, (Object)callResult.getErrorInfo()));
            return false;
        }
        return true;
    }

    protected void OnInitComponents() {
        super.OnInitComponents();
        String strQueryModelId = this.report.getQUERYMODELID();
        BaseDAQueryModelHelper queryModelHelper = this.getDAModelStorage().FindDAQueryModelHelper(strQueryModelId);
        if (queryModelHelper == null) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e\u68c0\u7d22\u6a21\u578b[%1$s]", (Object)strQueryModelId));
            return;
        }
        Vector userConditions = new Vector();
        queryModelHelper.FillMajorConditions(userConditions);
        StringBuilderEx script = new StringBuilderEx();
        script.Append(queryModelHelper.GetQMDeclareScript());
        script.Append(this.GetDAModelQueryScript(queryModelHelper));
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
        Vector<CallParam> params = new Vector<CallParam>();
        queryModelHelper.FillCallParams(params, (ISRFDAWebContext)this.getWebContext(), (ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), "");
        String strSQL = script.toString();
        strSQL = queryModelHelper.ReplaceURLParamMacro(strSQL, (ISRFExWebContext)this.webContext);
        SelectResult selectResult = this.CallSelect(script.toString(), params);
        if (selectResult.getRetCode() != 0) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u67e5\u8be2\u8bed\u53e5\u53d1\u751f\u9519\u8bef[%1$s],%2$s", (Object)strSQL, (Object)selectResult.getErrorInfo()));
            return;
        }
        String strReportPath = String.valueOf(this.getWebContext().GetAppRootPath()) + "srfreport" + File.separator + "report" + File.separator + this.report.getREPORTPATH();
        String strTempFilePath = this.GetTmpFilePath();
        TreeMap<String, String> parameters = new TreeMap<String, String>();
        parameters.put("SRFPARAM_NAME", "\u4e2d\u6587");
        this.ExportReportFile(strReportPath, strTempFilePath, parameters, selectResult);
    }

    protected void ExportReportFile(String strReportPath, String strTempPath, Map parameters, SelectResult selectResult) {
    }

    protected SelectResult CallSelect(String strSQL, Vector<CallParam> params) {
        try {
            SelectResult selectResult;
            if (params != null) {
                StringBuilderEx info = new StringBuilderEx();
                int i = 0;
                while (i < params.size()) {
                    CallParam callParam = params.get(i);
                    info.Append("\u53c2\u6570[%1$s][%2$s][%3$s]\r\n", (Object)(i + 1), (Object)callParam.getParamName(), callParam.getValue());
                    ++i;
                }
                log.info((Object)info.toString());
            }
            if ((selectResult = this.getWebContext().getDBCaller().CallRaw3(strSQL, params)) == null) {
                selectResult = new SelectResult();
                selectResult.setRetCode(1);
                selectResult.setErrorInfo("\u5185\u90e8\u53d1\u751f\u9519\u8bef");
                return selectResult;
            }
            return selectResult;
        }
        catch (Exception ex) {
            SelectResult selectResult = new SelectResult();
            selectResult.setRetCode(1);
            selectResult.setErrorInfo("\u5185\u90e8\u53d1\u751f\u9519\u8bef");
            return selectResult;
        }
    }

    protected String GetDAModelQueryScript(BaseDAQueryModelHelper daQueryModelHelper) {
        return daQueryModelHelper.GetQueryModelScript();
    }

    protected String GetTmpFilePath() {
        return StringHelper.Format((String)"%1$s%2$s", (Object)this.getWebContext().getGlobalHelper().GetTempPath(), (Object)Helper.GenGuid());
    }
}

