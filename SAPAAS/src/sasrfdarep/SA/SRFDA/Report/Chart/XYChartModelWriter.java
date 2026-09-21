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
 *  SA.SRFramework.WebEx.SRFExWebContext
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
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.XML.XMLNode;
import java.util.TreeMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class XYChartModelWriter
extends BaseChartModelWriter {
    private static final Log log = LogFactory.getLog(XYChartModelWriter.class);

    @Override
    protected void OnExportDataModelNode(XMLNode graphNode, ISRFDAGlobalHelper globalContext, IDEHelper iDEHelper, Chart chart, Vector<BaseDataEntity> list) {
        String strCodeListId;
        super.OnExportDataModelNode(graphNode, globalContext, iDEHelper, chart, list);
        String strXName = chart.GetChartProperty("X", "");
        if (StringHelper.IsNullOrEmpty((String)strXName)) {
            log.error((Object)StringHelper.Format((String)"\u6307\u5b9a\u56fe\u8868\u90e8\u4ef6[%1$s]\u6ca1\u6709\u5b9a\u4e49X\u5c5e\u6027", (Object)chart.getCHARTID()));
            return;
        }
        String strYName = chart.GetChartProperty("Y", "");
        if (StringHelper.IsNullOrEmpty((String)strYName)) {
            log.error((Object)StringHelper.Format((String)"\u6307\u5b9a\u56fe\u8868\u90e8\u4ef6[%1$s]\u6ca1\u6709\u5b9a\u4e49Y\u5c5e\u6027", (Object)chart.getCHARTID()));
            return;
        }
        CodeListConfig nameCodeListConfig = null;
        IDEFHelper nameDEFHelper = iDEHelper.GetDEFHelper(strXName);
        if (nameDEFHelper != null && !StringHelper.IsNullOrEmpty((String)(strCodeListId = nameDEFHelper.GetCodeList())) && (nameCodeListConfig = globalContext.getCodeListMgr().GetCodeListConfig(strCodeListId)) == null) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5c5e\u6027[%1$s]\u4ee3\u7801\u5217\u8868[%2$s]\u914d\u7f6e", (Object)nameDEFHelper.GetFullName(), (Object)strCodeListId));
            return;
        }
        String strLink = chart.GetChartProperty("LINK", "");
        boolean bOutputLink = !StringHelper.IsNullOrEmpty((String)strLink);
        String strXPropertyName = this.GetXPropertyName();
        String strYValue = chart.GetChartProperty("Y.VALUE", "");
        String strXFormat = chart.GetChartProperty("X.FORMAT", "");
        String strXList = chart.GetChartProperty("X.LIST", "");
        if (StringHelper.IsNullOrEmpty((String)strXList)) {
            for (BaseDataEntity baseDataEntity : list) {
                String strNameValue;
                String strLastNameValue = strNameValue = baseDataEntity.GetParamStringValue(strXName, "");
                if (nameCodeListConfig != null) {
                    strNameValue = nameCodeListConfig.GetCodeListValue(strNameValue, true);
                }
                String strValue = baseDataEntity.GetParamStringValue(strYName, "");
                XMLNode param = new XMLNode();
                param.setNodeName("set");
                if (!StringHelper.IsNullOrEmpty((String)strXFormat)) {
                    Object objLastNameValue = baseDataEntity.GetParamValue(strXName);
                    param.SetValue(strXPropertyName, StringHelper.Format((String)strXFormat, (Object)objLastNameValue, (Object)strValue, (Object)strNameValue));
                } else {
                    param.SetValue(strXPropertyName, strNameValue);
                }
                if (StringHelper.IsNullOrEmpty((String)strYValue)) {
                    param.SetValue("value", strValue);
                } else {
                    param.SetValue("value", strYValue);
                }
                if (bOutputLink) {
                    param.SetValue("link", StringHelper.Format((String)strLink, (Object)SRFExWebContext.EncodeURLParamValue((String)strLastNameValue), (Object)SRFExWebContext.EncodeURLParamValue((String)strValue), (Object)SRFExWebContext.EncodeURLParamValue((String)strNameValue)));
                }
                graphNode.AddNode(param);
            }
        } else {
            String strNameValue;
            TreeMap<String, BaseDataEntity> nameValueMap = new TreeMap<String, BaseDataEntity>();
            for (BaseDataEntity baseDataEntity : list) {
                strNameValue = baseDataEntity.GetParamStringValue(strXName, "");
                nameValueMap.put(strNameValue, baseDataEntity);
            }
            String[] xvalues = strXList.split("[;]");
            int i = 0;
            while (i < xvalues.length) {
                strNameValue = xvalues[i];
                if (!StringHelper.IsNullOrEmpty((String)strNameValue)) {
                    String strLastNameValue = strNameValue;
                    if (nameCodeListConfig != null && StringHelper.IsNullOrEmpty((String)(strNameValue = nameCodeListConfig.GetCodeListValue(strNameValue, false)))) {
                        strNameValue = nameCodeListConfig.getEmptyText();
                    }
                    String strValue = "";
                    BaseDataEntity baseDataEntity = (BaseDataEntity)nameValueMap.get(strLastNameValue);
                    strValue = baseDataEntity == null ? chart.GetChartProperty("Y.DEFAULT", "0") : baseDataEntity.GetParamStringValue(strYName, "");
                    XMLNode param = new XMLNode();
                    param.setNodeName("set");
                    if (!StringHelper.IsNullOrEmpty((String)strXFormat)) {
                        Object objLastNameValue = null;
                        objLastNameValue = baseDataEntity != null ? baseDataEntity.GetParamValue(strXName) : strLastNameValue;
                        param.SetValue(strXPropertyName, StringHelper.Format((String)strXFormat, (Object)objLastNameValue, (Object)strValue, (Object)strNameValue));
                    } else {
                        param.SetValue(strXPropertyName, strNameValue);
                    }
                    if (StringHelper.IsNullOrEmpty((String)strYValue)) {
                        param.SetValue("value", strValue);
                    } else {
                        param.SetValue("value", strYValue);
                    }
                    if (bOutputLink) {
                        param.SetValue("link", StringHelper.Format((String)strLink, (Object)SRFExWebContext.EncodeURLParamValue((String)strLastNameValue), (Object)SRFExWebContext.EncodeURLParamValue((String)strValue), (Object)SRFExWebContext.EncodeURLParamValue((String)strNameValue)));
                    }
                    graphNode.AddNode(param);
                }
                ++i;
            }
        }
    }

    protected String GetXPropertyName() {
        return "name";
    }
}

