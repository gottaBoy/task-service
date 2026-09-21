/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.Chart
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.XML.XMLNode
 */
package SA.SRFDA.Report.Chart;

import SA.SRFDA.Ctrl.Data.Chart;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Report.Chart.CategoryChartModelWriter;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.XML.XMLNode;
import java.util.TreeMap;
import java.util.Vector;

public class MSLineChartModelWriter
extends CategoryChartModelWriter {
    private static TreeMap<String, String> graphParams = new TreeMap();

    static {
        graphParams.put("numVDivlines", "1");
        graphParams.put("labelDisplay", "");
    }

    @Override
    protected void OnFillGraphNode(XMLNode graphNode, ISRFDAGlobalHelper globalContext, IDEHelper helper, Chart chart, Vector<BaseDataEntity> list) {
        super.OnFillGraphNode(graphNode, globalContext, helper, chart, list);
        for (String strKey : graphParams.keySet()) {
            graphNode.SetValue(strKey, chart.GetChartProperty("graph", strKey, graphParams.get(strKey)));
        }
    }
}

