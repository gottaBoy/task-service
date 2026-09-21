/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAQueryModelHelper
 *  SA.SRFDA.Ctrl.Data.List
 *  SA.SRFDA.Model.QueryGroupModelConfig
 *  SA.SRFDA.Report.List.ListColumnConfig
 *  SA.SRFDA.Report.List.ListConfig
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.SRFDAWebCTXHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.CallParam
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.Data.DataTypeParse
 *  SA.SRFramework.Data.SASRFDataException
 *  SA.SRFramework.Data.SelectResult
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.ISRFExWebContext
 *  SA.SRFramework.WebEx.SRFExAjaxListResult
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Report.List;

import SA.SRFDA.Ctrl.BaseDAQueryModelHelper;
import SA.SRFDA.Ctrl.Data.List;
import SA.SRFDA.Model.QueryGroupModelConfig;
import SA.SRFDA.Report.List.BaseListWriter;
import SA.SRFDA.Report.List.IListCell;
import SA.SRFDA.Report.List.ListColumnConfig;
import SA.SRFDA.Report.List.ListConfig;
import SA.SRFDA.Report.List.NormalListWriter;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAWebCTXHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.CallParam;
import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Data.DataTypeParse;
import SA.SRFramework.Data.SASRFDataException;
import SA.SRFramework.Data.SelectResult;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.ISRFExWebContext;
import SA.SRFramework.WebEx.SRFExAjaxListResult;
import java.util.Hashtable;
import java.util.TreeMap;
import java.util.Vector;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ListActionHelper {
    protected ISRFDAGlobalHelper globalHelper = null;
    protected List list = null;
    protected ISRFDAWebContext webContext = null;
    private static final Log log = LogFactory.getLog(ListActionHelper.class);
    private static Hashtable<String, BaseListWriter> listModelWriterMap = new Hashtable();

    static {
        listModelWriterMap.put("NORMAL", new NormalListWriter());
    }

    public String GetListHTML(ISRFDAWebContext webContext, ISRFDAGlobalHelper globalHelper, List list) {
        this.globalHelper = globalHelper;
        this.list = list;
        this.webContext = webContext;
        BaseDAQueryModelHelper queryModelHelper = null;
        String strQueryModelId = list.getQUERYMODELID();
        String strQueryModelIdKey = StringHelper.Format((String)"%1$s.%2$s", (Object)"QUERYMODELID", (Object)globalHelper.getDAModelDB());
        strQueryModelId = list.GetListProperty(strQueryModelIdKey, strQueryModelId);
        if (list.isENABLEDP()) {
            if (webContext != null) {
                queryModelHelper = webContext.GetUserQueryModelStorage().FindDAQueryModelHelper(strQueryModelId);
            }
        } else {
            queryModelHelper = globalHelper.getDAModelStorage().FindDAQueryModelHelper(strQueryModelId);
        }
        if (queryModelHelper == null) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e\u68c0\u7d22\u6a21\u578b[%1$s]", (Object)strQueryModelId));
            return "";
        }
        Vector userConditions = new Vector();
        queryModelHelper.FillMajorConditions(userConditions);
        StringBuilderEx script = new StringBuilderEx();
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
        queryModelHelper.FillQMDeclareParams(params, webContext, globalHelper, "");
        QueryGroupModelConfig queryGroupModelConfig = list.getQueryGroupModelConfig();
        String strTopCount = list.GetListProperty("TOPCOUNT", "200");
        int nTopCount = 0;
        if (!StringHelper.IsNullOrEmpty((String)strTopCount)) {
            Object objValue = DataTypeParse.TestInteger((String)strTopCount);
            nTopCount = (Integer)objValue;
            if (objValue != null && queryGroupModelConfig != null) {
                queryGroupModelConfig.setTopCount(nTopCount);
            }
        }
        String strSQL = "";
        if (queryGroupModelConfig != null && queryGroupModelConfig.size() != 0) {
            strSQL = queryModelHelper.GetGroupSQL(script.toString(), queryGroupModelConfig, params, this.webContext, globalHelper, "", null);
        } else {
            String strOrderField = list.GetListProperty("ORDERFIELD", "");
            String strOrderDir = list.GetListProperty("ORDERDIR", "ASC");
            strSQL = StringHelper.IsNullOrEmpty((String)strOrderField) ? script.toString() : (nTopCount == 0 ? queryModelHelper.GetSortSQL(script.toString(), strOrderField, strOrderDir, "", "") : queryModelHelper.GetPagingSQL(script.toString(), 0, nTopCount, strOrderField, strOrderDir, "", ""));
        }
        queryModelHelper.FillCallParams(params, webContext, globalHelper, "");
        strSQL = String.valueOf(queryModelHelper.GetQMDeclareScript()) + strSQL;
        strSQL = queryModelHelper.ReplaceURLParamMacro(strSQL, (ISRFExWebContext)this.webContext);
        SelectResult selectResult = this.CallSelect(queryModelHelper, strSQL, params);
        if (selectResult == null || selectResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u8bed\u53e5\u53d1\u751f\u9519\u8bef[%1$s],%2$s", (Object)strSQL, (Object)(selectResult == null ? "\u4e0d\u660e\u9519\u8bef" : selectResult.getErrorInfo())));
            return "";
        }
        String strListType = list.getLISTTYPE();
        BaseListWriter baseListWriter = this.OnGetListWriter(strListType, list);
        if (baseListWriter == null) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u5217\u8868[%1$s]\u6a21\u578b\u6784\u5efa\u5bf9\u8c61", (Object)strListType));
            return "";
        }
        if (StringHelper.IsNullOrEmpty((String)SRFDAWebCTXHelper.GetPageModel((ISRFDAWebContext)webContext))) {
            String strOutput = baseListWriter.Export(globalHelper.getDAModelStorage().FindDEHelper(list.getDEID()), webContext, globalHelper, list.GetListConfig(), selectResult.getMainTable());
            return strOutput;
        }
        SRFExAjaxListResult listResult = new SRFExAjaxListResult();
        TreeMap<String, IListCell> customObjects = new TreeMap<String, IListCell>();
        ListConfig listConfig = list.GetListConfig();
        int nReadIndex = 0;
        for (Object obj : selectResult.getMainTable().getRows()) {
            try {
                DataRow dr = (DataRow)obj;
                BaseDataEntity dataEntity = new BaseDataEntity();
                dataEntity.FromDataRow(dr);
                JSONObject jo = new JSONObject();
                dataEntity.FillJSONObject(jo, false);
                int i = 0;
                while (i < listConfig.getListColumnsConfig().size()) {
                    ListColumnConfig listColumnConfig = (ListColumnConfig)listConfig.getListColumnsConfig().get(i);
                    String strContent = BaseListWriter.GetCellValue(queryModelHelper.GetMajorDEHelper(), webContext, globalHelper, dr, listColumnConfig, customObjects);
                    jo.put(StringHelper.Format((String)"srflists%1$s", (Object)(i + 1)), (Object)strContent);
                    ++i;
                }
                listResult.getItems().add(jo);
                if (nTopCount > 0 && ++nReadIndex >= nTopCount) break;
                if (nReadIndex != 100) continue;
                log.warn((Object)StringHelper.Format((String)"\u5217\u8868\u90e8\u4ef6[%1$s|%2$s]\u8bb0\u5f55\u6570\u8d85\u8fc7100\uff0c\u8bf7\u786e\u8ba4\u6709\u65e0\u5fc5\u8981!", (Object)list.getLISTID(), (Object)list.getLISTPARAM()));
            }
            catch (Exception ex) {
                log.error((Object)ex);
            }
        }
        return listResult.ToJSONString();
    }

    protected BaseListWriter OnGetListWriter(String strListType, List list) {
        if (!StringHelper.IsNullOrEmpty((String)list.getWRITEROBJECT())) {
            if (listModelWriterMap.containsKey(list.getWRITEROBJECT())) {
                return listModelWriterMap.get(list.getWRITEROBJECT());
            }
            Object objListWriter = ObjectHelper.Create((String)list.getWRITEROBJECT());
            if (objListWriter == null) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u5217\u8868\u8f93\u51fa\u5bf9\u8c61[%1$s]", (Object)list.getWRITEROBJECT()));
                return null;
            }
            if (!(objListWriter instanceof BaseListWriter)) {
                log.error((Object)StringHelper.Format((String)"\u5217\u8868\u8f93\u51fa\u5bf9\u8c61[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)list.getWRITEROBJECT()));
                return null;
            }
            BaseListWriter baseListWriter = (BaseListWriter)objListWriter;
            listModelWriterMap.put(list.getWRITEROBJECT(), baseListWriter);
            return baseListWriter;
        }
        return listModelWriterMap.get(strListType.toUpperCase());
    }

    protected SelectResult CallSelect(BaseDAQueryModelHelper daQueryModelHelper, String strSQL, Vector<CallParam> params) {
        try {
            StringBuilderEx info = new StringBuilderEx();
            info.Append("LIST SQL\r\n%1$s\r\n", (Object)strSQL);
            if (params != null) {
                int i = 0;
                while (i < params.size()) {
                    CallParam callParam = params.get(i);
                    info.Append("\u53c2\u6570[%1$s][%2$s][%3$s]\r\n", (Object)(i + 1), (Object)callParam.getParamName(), callParam.getValue());
                    ++i;
                }
            }
            log.info((Object)info.toString());
            return this.globalHelper.getDBCaller(daQueryModelHelper.GetMajorDEHelper().GetDBStorage()).CallRaw3(strSQL, params);
        }
        catch (SASRFDataException e) {
            e.printStackTrace();
            return null;
        }
    }

    protected String GetDAModelQueryScript(BaseDAQueryModelHelper daQueryModelHelper) {
        return daQueryModelHelper.GetQueryModelScript();
    }
}

