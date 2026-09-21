/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.Chart
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  SA.SRFramework.XML.SimpleXMLWriter
 *  SA.SRFramework.XML.XMLNode
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Report.Chart;

import SA.SRFDA.Ctrl.Data.Chart;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import SA.SRFramework.XML.SimpleXMLWriter;
import SA.SRFramework.XML.XMLNode;
import java.util.Enumeration;
import java.util.Properties;
import java.util.TreeMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class BaseChartModelWriter {
    public static final String TAG_GRAPH = "graph";
    private static final Log log = LogFactory.getLog(BaseChartModelWriter.class);
    private static TreeMap<String, String> graphParams = new TreeMap();

    static {
        graphParams.put("BASEFONTSIZE", "12");
        graphParams.put("CHARTLEFTMARGIN", "20");
        graphParams.put("CHARTRIGHTMARGIN", "20");
        graphParams.put("CHARTTOPMARGIN", "20");
        graphParams.put("CHARTBOTTOMMARGIN", "20");
        graphParams.put("SHOWLEGEND", "0");
        graphParams.put("SHOWVALUES", "1");
        graphParams.put("SHOWNAMES", "1");
        graphParams.put("DECIMALPRECISION", "2");
        graphParams.put("DECIMALS", "2");
        graphParams.put("FORCEDECIMALS", "0");
        graphParams.put("SUBCAPTION", "");
        graphParams.put("XAXISNAME", "");
        graphParams.put("YAXISNAME", "");
        graphParams.put("SHOWVALUES", "1");
        graphParams.put("SHOWHOVERCAP", "1");
        graphParams.put("BGCOLOR", "ffffff");
        graphParams.put("SHOWBORDER", "0");
        graphParams.put("ANIMATION", "0");
        graphParams.put("FORMATNUMBERSCALE", "0");
        graphParams.put("FORMATNUMBER", "0");
        graphParams.put("NUMBERPREFIX", "");
        graphParams.put("NUMBERSUFFIX", "");
    }

    public String Export(ISRFDAGlobalHelper globalContext, IDEHelper iDEHelper, Chart chart, Vector<BaseDataEntity> list) {
        XMLNode xmlNode = new XMLNode();
        xmlNode.setNodeName(TAG_GRAPH);
        this.OnFillGraphNode(xmlNode, globalContext, iDEHelper, chart, list);
        this.OnExportDataModelNode(xmlNode, globalContext, iDEHelper, chart, list);
        StringBuilder sb = new StringBuilder();
        SimpleXMLWriter simpleXMLWriter = new SimpleXMLWriter(sb);
        xmlNode.Save(simpleXMLWriter);
        return sb.toString().replace("&apos;", "'");
    }

    protected void OnFillGraphNode(XMLNode graphNode, ISRFDAGlobalHelper globalContext, IDEHelper iDEHelper, Chart chart, Vector<BaseDataEntity> list) {
        for (String strKey : graphParams.keySet()) {
            graphNode.SetValue(strKey, chart.GetChartProperty(TAG_GRAPH, strKey, graphParams.get(strKey)));
        }
        Properties properties = chart.getChartProperties();
        if (properties != null) {
            Enumeration<Object> en = properties.keys();
            while (en.hasMoreElements()) {
                String strKey = en.nextElement().toString();
                String strKey2 = strKey.toUpperCase();
                if (strKey2.indexOf("GRAPH.") != 0 || graphParams.containsKey(strKey2 = strKey2.substring(6))) continue;
                graphNode.SetValue(strKey2, PropertiesHelper.GetProperty((Properties)properties, (String)strKey));
            }
        }
    }

    protected void OnExportDataModelNode(XMLNode graphNode, ISRFDAGlobalHelper globalContext, IDEHelper iDEHelper, Chart chart, Vector<BaseDataEntity> list) {
    }
}

