/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAQueryModelHelper
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.Data.Chart
 *  SA.SRFDA.Ctrl.Utility.MacroHelper
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.CallParam
 *  SA.SRFramework.Data.DataTypeParse
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.ISRFExWebContext
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Report.Chart;

import SA.SRFDA.Ctrl.BaseDAQueryModelHelper;
import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.Data.Chart;
import SA.SRFDA.Ctrl.Utility.MacroHelper;
import SA.SRFDA.Report.Chart.BaseChartModelWriter;
import SA.SRFDA.Report.Chart.ColumnChartModelWriter;
import SA.SRFDA.Report.Chart.FunnelChartModelWriter;
import SA.SRFDA.Report.Chart.LineChartModelWriter;
import SA.SRFDA.Report.Chart.MSColumnChartModelWriter;
import SA.SRFDA.Report.Chart.MSLineChartModelWriter;
import SA.SRFDA.Report.Chart.PieChartModelWriter;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.CallParam;
import SA.SRFramework.Data.DataTypeParse;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.ISRFExWebContext;
import java.util.Hashtable;
import java.util.TreeMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ChartActionHelper {
    protected ISRFDAGlobalHelper globalHelper = null;
    protected Chart chart = null;
    protected ISRFDAWebContext webContext = null;
    private static final Log log = LogFactory.getLog(ChartActionHelper.class);
    private static Hashtable<String, BaseChartModelWriter> chartModelWriterMap = new Hashtable();

    static {
        chartModelWriterMap.put("2DPIE", new PieChartModelWriter());
        chartModelWriterMap.put("3DPIE", new PieChartModelWriter());
        chartModelWriterMap.put("FUNNEL", new FunnelChartModelWriter());
        chartModelWriterMap.put("2DCOLUMN", new ColumnChartModelWriter());
        chartModelWriterMap.put("3DCOLUMN", new ColumnChartModelWriter());
        chartModelWriterMap.put("MS2DCOLUMN", new MSColumnChartModelWriter());
        chartModelWriterMap.put("MS3DCOLUMN", new MSColumnChartModelWriter());
        chartModelWriterMap.put("LINE", new LineChartModelWriter());
        chartModelWriterMap.put("MSLINE", new MSLineChartModelWriter());
    }

    public static void RegisterChartModelWriter(String strType, BaseChartModelWriter writer) {
        chartModelWriterMap.put(strType, writer);
    }

    /*
     * Unable to fully structure code
     */
    public String GetChartXML(ISRFDAWebContext webContext, ISRFDAGlobalHelper globalHelper, Chart chart) {
        block25: {
            this.globalHelper = globalHelper;
            this.chart = chart;
            this.webContext = webContext;
            queryModelHelper = null;
            strQueryModelId = chart.getQUERYMODELID();
            strQueryModelIdKey = StringHelper.Format((String)"%1$s.%2$s", (Object)"QUERYMODELID", (Object)globalHelper.getDAModelDB());
            strQueryModelId = chart.GetChartProperty(strQueryModelIdKey, strQueryModelId);
            if (chart.isENABLEDP()) {
                if (webContext != null) {
                    queryModelHelper = webContext.GetUserQueryModelStorage().FindDAQueryModelHelper(strQueryModelId);
                }
            } else {
                queryModelHelper = globalHelper.getDAModelStorage().FindDAQueryModelHelper(strQueryModelId);
            }
            if (queryModelHelper == null) {
                ChartActionHelper.log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e\u68c0\u7d22\u6a21\u578b[%1$s]", (Object)strQueryModelId));
                return "";
            }
            userConditions = new Vector<String>();
            queryModelHelper.FillMajorConditions(userConditions);
            script = new StringBuilderEx();
            strQueryScript = this.GetDAModelQueryScript(queryModelHelper);
            if (StringHelper.IsNullOrEmpty((String)chart.getTIMEGROUPFIELD())) break block25;
            timeGroupDEF = queryModelHelper.GetMajorDEHelper().GetDEFHelper(chart.getTIMEGROUPFIELD());
            if (timeGroupDEF == null) ** GOTO lbl61
            nPos = strQueryScript.indexOf("SELECT");
            if (nPos != -1) {
                strQueryScript = "SELECT s1.TIMEDIMENSIONID AS srftdid,s1.TIMEDIMENSIONNAME AS srftdname,s1.BEGINTIME AS srftdfrom, " + strQueryScript.substring(nPos + 6);
                if (StringHelper.IsNullOrEmpty((String)queryModelHelper.GetMajorDEHelper().GetDBStorage())) {
                    strQueryScript = String.valueOf(strQueryScript) + StringHelper.Format((String)"\nLEFT OUTER JOIN t_SRFTIMEDIMENSION s1 ON %1$s >=s1.BEGINTIME AND %1$s<s1.ENDTIME \n", (Object)queryModelHelper.GetDEFieldExp(timeGroupDEF).getUserObject());
                } else {
                    tdDEHelper = globalHelper.getDAModelStorage().FindDEHelper("DE0172");
                    strQueryScript = String.valueOf(strQueryScript) + StringHelper.Format((String)"\nLEFT OUTER JOIN %2$s.t_SRFTIMEDIMENSION s1 ON %1$s >=s1.BEGINTIME AND %1$s<s1.ENDTIME \n", (Object)queryModelHelper.GetDEFieldExp(timeGroupDEF).getUserObject(), (Object)tdDEHelper.GetDBSchema());
                }
                strTimeDimensionIds = webContext.GetParamValue("srftimedimensionid");
                if (StringHelper.IsNullOrEmpty((String)strTimeDimensionIds)) {
                    strTimeDimensionIds = webContext.GetPostValue("srftimedimensionid");
                }
                if (StringHelper.IsNullOrEmpty((String)strTimeDimensionIds)) {
                    strTimeDimensionIds = chart.getDEFAULTTIMEGROUP();
                }
                if (!StringHelper.IsNullOrEmpty((String)strTimeDimensionIds)) {
                    strResults = "";
                    timeDimensionIds = strTimeDimensionIds.split("[;]");
                    i = 0;
                    while (i < timeDimensionIds.length) {
                        callResult = MacroHelper.GetValue((String)timeDimensionIds[i], (ISRFDAWebContext)webContext, (ISRFDAGlobalHelper)globalHelper, (String)webContext.getCurUserId(), null);
                        if (callResult.IsOk()) {
                            if (!StringHelper.IsNullOrEmpty((String)strResults)) {
                                strResults = String.valueOf(strResults) + ",";
                            }
                        } else {
                            ChartActionHelper.log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u8ba1\u7b97\u5b8f\u53d8\u91cf[%1$s]", (Object)timeDimensionIds[i]));
                            return "";
                        }
                        strResults = String.valueOf(strResults) + StringHelper.Format((String)"'%1$s'", (Object)callResult.getUserObject());
                        ++i;
                    }
                    userConditions.add(StringHelper.Format((String)"s1.TIMEDIMENSIONID IS NOT NULL "));
                    userConditions.add(StringHelper.Format((String)"s1.TIMEDIMENSIONID IN (%1$s)", (Object)strResults));
                } else {
                    userConditions.add("s1.TIMEDIMENSIONID='_NA_'");
                }
            } else {
                ChartActionHelper.log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u4ece\u67e5\u8be2\u8bed\u53e5\u4e2d\u5b9a\u4f4d\u7b2c\u4e00\u4e2a[SELECT]"));
                return "";
lbl61:
                // 1 sources

                ChartActionHelper.log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u65f6\u95f4\u5206\u7ec4\u5c5e\u6027[%1$s]", (Object)chart.getTIMEGROUPFIELD()));
                return "";
            }
        }
        script.Append(strQueryScript);
        if (userConditions.size() != 0) {
            script.Append(" WHERE ");
            bFirst = true;
            for (String strCondition : userConditions) {
                if (bFirst) {
                    bFirst = false;
                } else {
                    script.Append(" AND ");
                }
                script.Append("(%1$s)", (Object)strCondition);
            }
        }
        params = new Vector<CallParam>();
        queryModelHelper.FillQMDeclareParams(params, webContext, globalHelper, "");
        queryGroupModelConfig = chart.getQueryGroupModelConfig();
        if (queryGroupModelConfig == null) {
            ChartActionHelper.log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u56fe\u8868\u90e8\u4ef6[%1$s]\u6570\u636e\u5206\u7ec4\u6a21\u578b", (Object)chart.getCHARTID()));
            return "";
        }
        strTopCount = chart.GetChartProperty("TOPCOUNT", "0");
        if (!StringHelper.IsNullOrEmpty((String)strTopCount) && (objValue = DataTypeParse.TestInteger((String)strTopCount)) != null) {
            queryGroupModelConfig.setTopCount(((Integer)objValue).intValue());
        }
        strSQL = queryModelHelper.GetGroupSQL(script.toString(), queryGroupModelConfig, params, webContext, globalHelper, "", null);
        queryModelHelper.FillCallParams(params, webContext, globalHelper, "");
        strSQL = String.valueOf(queryModelHelper.GetQMDeclareScript()) + strSQL;
        strSQL = queryModelHelper.ReplaceURLParamMacro(strSQL, (ISRFExWebContext)this.webContext);
        list = new Vector<BaseDataEntity>();
        callResult = this.CallSelect(queryModelHelper, strSQL, params, list);
        if (callResult.getRetCode() != 0) {
            ChartActionHelper.log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u8bed\u53e5\u53d1\u751f\u9519\u8bef[%1$s],%2$s", (Object)strSQL, (Object)callResult.getErrorInfo()));
            return "";
        }
        callResult = this.OnAfterSelect(list);
        if (callResult.getRetCode() != 0) {
            ChartActionHelper.log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u4e4b\u540e\u586b\u5145\u7ed3\u679c\u96c6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return "";
        }
        strChartType = chart.getCHARTTYPE();
        baseChartModelWriter = this.GetChartModelWriter(strChartType);
        if (baseChartModelWriter == null) {
            ChartActionHelper.log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u56fe\u50cf[%1$s]\u6a21\u578b\u6784\u5efa\u5bf9\u8c61", (Object)strChartType));
            return "";
        }
        strOutput = baseChartModelWriter.Export(globalHelper, queryModelHelper.GetMajorDEHelper(), chart, list);
        return strOutput;
    }

    protected BaseChartModelWriter GetChartModelWriter(String strChartType) {
        BaseChartModelWriter baseChartModelWriter = chartModelWriterMap.get(strChartType.toUpperCase());
        if (baseChartModelWriter == null) {
            return null;
        }
        return baseChartModelWriter;
    }

    protected CallResult OnAfterSelect(Vector<BaseDataEntity> list) {
        return new CallResult();
    }

    protected CallResult CallSelect(BaseDAQueryModelHelper daQueryModelHelper, String strSQL, Vector<CallParam> params, Vector list) {
        StringBuilderEx info = new StringBuilderEx();
        info.Append("CHART SQL\r\n%1$s\r\n", (Object)strSQL);
        if (params != null) {
            int i = 0;
            while (i < params.size()) {
                CallParam callParam = params.get(i);
                info.Append("\u53c2\u6570[%1$s][%2$s][%3$s]\r\n", (Object)(i + 1), (Object)callParam.getParamName(), callParam.getValue());
                ++i;
            }
        }
        log.info((Object)info.toString());
        return BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)this.globalHelper, (String)daQueryModelHelper.GetMajorDEHelper().GetDBStorage(), (String)strSQL, params, (Vector)list, (String)"");
    }

    protected String GetDAModelQueryScript(BaseDAQueryModelHelper daQueryModelHelper) {
        return daQueryModelHelper.GetQueryModelScript();
    }

    protected void FillAdditionalDPCode(TreeMap<String, String> codeSets) {
    }
}

