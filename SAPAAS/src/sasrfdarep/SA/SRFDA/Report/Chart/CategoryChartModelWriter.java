/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.Data.Chart
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.CodeList.CodeListConfig
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.XML.XMLNode
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Report.Chart;

import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.Data.Chart;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Report.Chart.BaseChartModelWriter;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.XML.XMLNode;
import java.util.TreeMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CategoryChartModelWriter
extends BaseChartModelWriter {
    private static final Log log = LogFactory.getLog(CategoryChartModelWriter.class);

    @Override
    protected void OnExportDataModelNode(XMLNode graphNode, ISRFDAGlobalHelper globalContext, IDEHelper iDEHelper, Chart chart, Vector<BaseDataEntity> list) {
        TreeMap valueMap;
        String strCodeListId;
        String strCodeListId2;
        super.OnExportDataModelNode(graphNode, globalContext, iDEHelper, chart, list);
        String strXName = chart.GetChartProperty("X", "");
        if (StringHelper.IsNullOrEmpty((String)strXName)) {
            log.error((Object)StringHelper.Format((String)"\u6307\u5b9a\u56fe\u8868\u90e8\u4ef6[%1$s]\u6ca1\u6709\u5b9a\u4e49X\u5c5e\u6027", (Object)chart.getCHARTID()));
            return;
        }
        String strXFormat = chart.GetChartProperty("X.FORMAT", "");
        String strYName = chart.GetChartProperty("Y", "");
        if (StringHelper.IsNullOrEmpty((String)strYName)) {
            log.error((Object)StringHelper.Format((String)"\u6307\u5b9a\u56fe\u8868\u90e8\u4ef6[%1$s]\u6ca1\u6709\u5b9a\u4e49Y\u5c5e\u6027", (Object)chart.getCHARTID()));
            return;
        }
        String strZName = chart.GetChartProperty("Z", "");
        if (StringHelper.IsNullOrEmpty((String)strZName)) {
            log.error((Object)StringHelper.Format((String)"\u6307\u5b9a\u56fe\u8868\u90e8\u4ef6[%1$s]\u6ca1\u6709\u5b9a\u4e49Z\u5c5e\u6027", (Object)chart.getCHARTID()));
            return;
        }
        CodeListConfig nameCodeListConfig = null;
        IDEFHelper nameDEFHelper = iDEHelper.GetDEFHelper(strXName);
        if (nameDEFHelper != null && !StringHelper.IsNullOrEmpty((String)(strCodeListId2 = nameDEFHelper.GetCodeList())) && (nameCodeListConfig = globalContext.getCodeListMgr().GetCodeListConfig(strCodeListId2)) == null) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5c5e\u6027[%1$s]\u4ee3\u7801\u5217\u8868[%2$s]\u914d\u7f6e", (Object)nameDEFHelper.GetFullName(), (Object)strCodeListId2));
            return;
        }
        CodeListConfig nameYCodeListConfig = null;
        IDEFHelper nameYDEFHelper = iDEHelper.GetDEFHelper(strYName);
        if (nameYDEFHelper != null && !StringHelper.IsNullOrEmpty((String)(strCodeListId = nameYDEFHelper.GetCodeList())) && (nameYCodeListConfig = globalContext.getCodeListMgr().GetCodeListConfig(strCodeListId)) == null) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5c5e\u6027[%1$s]\u4ee3\u7801\u5217\u8868[%2$s]\u914d\u7f6e", (Object)nameYDEFHelper.GetFullName(), (Object)strCodeListId));
            return;
        }
        Vector<String> categoryList = new Vector<String>();
        TreeMap<String, String> categoryMap = new TreeMap<String, String>();
        Vector<String> seriesNameList = new Vector<String>();
        TreeMap seriesNameMap = new TreeMap();
        for (BaseDataEntity baseDataEntity : list) {
            String strNameValue = baseDataEntity.GetParamStringValue(strXName, "");
            if (nameCodeListConfig != null) {
                strNameValue = nameCodeListConfig.GetCodeListValue(strNameValue, true);
            }
            if (!StringHelper.IsNullOrEmpty((String)strXFormat)) {
                Object objLastNameValue = baseDataEntity.GetParamValue(strXName);
                strNameValue = StringHelper.Format((String)strXFormat, (Object)objLastNameValue, (Object)strNameValue);
            }
            String strNameYValue = baseDataEntity.GetParamStringValue(strYName, "");
            if (nameYCodeListConfig != null) {
                strNameYValue = nameYCodeListConfig.GetCodeListValue(strNameYValue, true);
            }
            if (!categoryMap.containsKey(strNameValue)) {
                categoryList.add(strNameValue);
                categoryMap.put(strNameValue, "");
            }
            valueMap = null;
            if (!seriesNameMap.containsKey(strNameYValue)) {
                seriesNameList.add(strNameYValue);
                seriesNameMap.put(strNameYValue, new TreeMap());
            }
            String strValue = baseDataEntity.GetParamStringValue(strZName, "");
            valueMap = (TreeMap)seriesNameMap.get(strNameYValue);
            valueMap.put(strNameValue, strValue);
        }
        XMLNode categories = new XMLNode();
        categories.setNodeName("categories");
        graphNode.AddNode(categories);
        for (String strCategory : categoryList) {
            XMLNode param = new XMLNode();
            param.setNodeName("category");
            categories.AddNode(param);
            param.SetValue("name", strCategory);
        }
        for (String strSeries : seriesNameList) {
            XMLNode dataset = new XMLNode();
            dataset.setNodeName("dataset");
            graphNode.AddNode(dataset);
            dataset.SetValue("seriesName", strSeries);
            valueMap = (TreeMap)seriesNameMap.get(strSeries);
            for (String strCategory : categoryList) {
                XMLNode param = new XMLNode();
                param.setNodeName("set");
                dataset.AddNode(param);
                if (valueMap.containsKey(strCategory)) {
                    param.SetValue("value", (String)valueMap.get(strCategory));
                    continue;
                }
                param.SetValue("value", "");
            }
        }
    }
}

