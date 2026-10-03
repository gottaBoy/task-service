package SA.SRFDA.Report.Chart;

import SA.SRFDA.Ctrl.BaseDAQueryModelHelper;
import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.Data.Chart;
import SA.SRFDA.Ctrl.Utility.MacroHelper;
import SA.SRFDA.Model.QueryGroupModelConfig;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.CallParam;
import SA.SRFramework.Data.DataTypeParse;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
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
   private static Hashtable<String, BaseChartModelWriter> chartModelWriterMap = new Hashtable<>();

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

   public String GetChartXML(ISRFDAWebContext webContext, ISRFDAGlobalHelper globalHelper, Chart chart) {
      this.globalHelper = globalHelper;
      this.chart = chart;
      this.webContext = webContext;
      BaseDAQueryModelHelper queryModelHelper = null;
      String strQueryModelId = chart.getQUERYMODELID();
      String strQueryModelIdKey = StringHelper.Format("%1$s.%2$s", "QUERYMODELID", globalHelper.getDAModelDB());
      strQueryModelId = chart.GetChartProperty(strQueryModelIdKey, strQueryModelId);
      if (chart.isENABLEDP()) {
         if (webContext != null) {
            queryModelHelper = webContext.GetUserQueryModelStorage().FindDAQueryModelHelper(strQueryModelId);
         }
      } else {
         queryModelHelper = globalHelper.getDAModelStorage().FindDAQueryModelHelper(strQueryModelId);
      }

      if (queryModelHelper == null) {
         log.error(StringHelper.Format("无法获取指定数据检索模型[%1$s]", strQueryModelId));
         return "";
      }

      Vector<String> userConditions = new Vector<>();
      queryModelHelper.FillMajorConditions(userConditions);
      StringBuilderEx script = new StringBuilderEx();
      String strQueryScript = this.GetDAModelQueryScript(queryModelHelper);
      if (!StringHelper.IsNullOrEmpty(chart.getTIMEGROUPFIELD())) {
         IDEFHelper timeGroupDEF = queryModelHelper.GetMajorDEHelper().GetDEFHelper(chart.getTIMEGROUPFIELD());
         if (timeGroupDEF == null) {
            log.error(StringHelper.Format("无法获取时间分组属性[%1$s]", chart.getTIMEGROUPFIELD()));
            return "";
         }

         int nPos = strQueryScript.indexOf("SELECT");
         if (nPos == -1) {
            log.error(StringHelper.Format("无法从查询语句中定位第一个[SELECT]"));
            return "";
         }

         strQueryScript = "SELECT s1.TIMEDIMENSIONID AS srftdid,s1.TIMEDIMENSIONNAME AS srftdname,s1.BEGINTIME AS srftdfrom, "
            + strQueryScript.substring(nPos + 6);
         if (StringHelper.IsNullOrEmpty(queryModelHelper.GetMajorDEHelper().GetDBStorage())) {
            strQueryScript = strQueryScript
               + StringHelper.Format(
                  "\nLEFT OUTER JOIN t_SRFTIMEDIMENSION s1 ON %1$s >=s1.BEGINTIME AND %1$s<s1.ENDTIME \n",
                  queryModelHelper.GetDEFieldExp(timeGroupDEF).getUserObject()
               );
         } else {
            IDEHelper tdDEHelper = globalHelper.getDAModelStorage().FindDEHelper("DE0172");
            strQueryScript = strQueryScript
               + StringHelper.Format(
                  "\nLEFT OUTER JOIN %2$s.t_SRFTIMEDIMENSION s1 ON %1$s >=s1.BEGINTIME AND %1$s<s1.ENDTIME \n",
                  queryModelHelper.GetDEFieldExp(timeGroupDEF).getUserObject(),
                  tdDEHelper.GetDBSchema()
               );
         }

         String strTimeDimensionIds = webContext.GetParamValue("srftimedimensionid");
         if (StringHelper.IsNullOrEmpty(strTimeDimensionIds)) {
            strTimeDimensionIds = webContext.GetPostValue("srftimedimensionid");
         }

         if (StringHelper.IsNullOrEmpty(strTimeDimensionIds)) {
            strTimeDimensionIds = chart.getDEFAULTTIMEGROUP();
         }

         if (!StringHelper.IsNullOrEmpty(strTimeDimensionIds)) {
            String strResults = "";
            String[] timeDimensionIds = strTimeDimensionIds.split("[;]");

            for (int i = 0; i < timeDimensionIds.length; i++) {
               CallResult callResult = MacroHelper.GetValue(timeDimensionIds[i], webContext, globalHelper, webContext.getCurUserId(), null);
               if (!callResult.IsOk()) {
                  log.error(StringHelper.Format("无法计算宏变量[%1$s]", timeDimensionIds[i]));
                  return "";
               }

               if (!StringHelper.IsNullOrEmpty(strResults)) {
                  strResults = strResults + ",";
               }

               strResults = strResults + StringHelper.Format("'%1$s'", callResult.getUserObject());
            }

            userConditions.add(StringHelper.Format("s1.TIMEDIMENSIONID IS NOT NULL "));
            userConditions.add(StringHelper.Format("s1.TIMEDIMENSIONID IN (%1$s)", strResults));
         } else {
            userConditions.add("s1.TIMEDIMENSIONID='_NA_'");
         }
      }

      script.Append(strQueryScript);
      if (userConditions.size() != 0) {
         script.Append(" WHERE ");
         boolean bFirst = true;

         for (String strCondition : userConditions) {
            if (bFirst) {
               bFirst = false;
            } else {
               script.Append(" AND ");
            }

            script.Append("(%1$s)", strCondition);
         }
      }

      Vector<CallParam> params = new Vector<>();
      queryModelHelper.FillQMDeclareParams(params, webContext, globalHelper, "");
      QueryGroupModelConfig queryGroupModelConfig = chart.getQueryGroupModelConfig();
      if (queryGroupModelConfig == null) {
         log.error(StringHelper.Format("无法获取指定图表部件[%1$s]数据分组模型", chart.getCHARTID()));
         return "";
      }

      String strTopCount = chart.GetChartProperty("TOPCOUNT", "0");
      if (!StringHelper.IsNullOrEmpty(strTopCount)) {
         Object objValue = DataTypeParse.TestInteger(strTopCount);
         if (objValue != null) {
            queryGroupModelConfig.setTopCount((Integer)objValue);
         }
      }

      String strSQL = queryModelHelper.GetGroupSQL(script.toString(), queryGroupModelConfig, params, webContext, globalHelper, "", null);
      queryModelHelper.FillCallParams(params, webContext, globalHelper, "");
      strSQL = queryModelHelper.GetQMDeclareScript() + strSQL;
      strSQL = queryModelHelper.ReplaceURLParamMacro(strSQL, this.webContext);
      Vector<BaseDataEntity> list = new Vector<>();
      CallResult callResult = this.CallSelect(queryModelHelper, strSQL, params, list);
      if (callResult.getRetCode() != 0) {
         log.error(StringHelper.Format("查询语句发生错误[%1$s],%2$s", strSQL, callResult.getErrorInfo()));
         return "";
      } else {
         callResult = this.OnAfterSelect(list);
         if (callResult.getRetCode() != 0) {
            log.error(StringHelper.Format("查询之后填充结果集发生错误，%1$s", callResult.getErrorInfo()));
            return "";
         } else {
            String strChartType = chart.getCHARTTYPE();
            BaseChartModelWriter baseChartModelWriter = this.GetChartModelWriter(strChartType);
            if (baseChartModelWriter == null) {
               log.error(StringHelper.Format("无法找到图像[%1$s]模型构建对象", strChartType));
               return "";
            } else {
               return baseChartModelWriter.Export(globalHelper, queryModelHelper.GetMajorDEHelper(), chart, list);
            }
         }
      }
   }

   protected BaseChartModelWriter GetChartModelWriter(String strChartType) {
      BaseChartModelWriter baseChartModelWriter = chartModelWriterMap.get(strChartType.toUpperCase());
      return baseChartModelWriter == null ? null : baseChartModelWriter;
   }

   protected CallResult OnAfterSelect(Vector<BaseDataEntity> list) {
      return new CallResult();
   }

   protected CallResult CallSelect(BaseDAQueryModelHelper daQueryModelHelper, String strSQL, Vector<CallParam> params, Vector list) {
      StringBuilderEx info = new StringBuilderEx();
      info.Append("CHART SQL\r\n%1$s\r\n", strSQL);
      if (params != null) {
         for (int i = 0; i < params.size(); i++) {
            CallParam callParam = params.get(i);
            info.Append("参数[%1$s][%2$s][%3$s]\r\n", i + 1, callParam.getParamName(), callParam.getValue());
         }
      }

      log.info(info.toString());
      return BaseDEDataCtrl.SelectMultiEx(this.globalHelper, daQueryModelHelper.GetMajorDEHelper().GetDBStorage(), strSQL, params, list, "");
   }

   protected String GetDAModelQueryScript(BaseDAQueryModelHelper daQueryModelHelper) {
      return daQueryModelHelper.GetQueryModelScript();
   }

   protected void FillAdditionalDPCode(TreeMap<String, String> codeSets) {
   }
}
