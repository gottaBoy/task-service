/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSEChartsSeries;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartSeriesImpl;
import java.util.ArrayList;
import java.util.List;
import net.ibizsys.paas.util.StringHelper;

public abstract class PSDEChartSeriesImpl2
extends PSDEChartSeriesImpl
implements IPSEChartsSeries {
    protected static Object getNumberOrString(String strValue) throws Exception {
        try {
            return Integer.parseInt(strValue);
        }
        catch (Exception ex) {
            return strValue;
        }
    }

    protected static Object getBooleanOrString(String strValue) throws Exception {
        try {
            if ("1".equalsIgnoreCase(strValue)) {
                return true;
            }
            if ("0".equalsIgnoreCase(strValue)) {
                return false;
            }
            return Boolean.parseBoolean(strValue);
        }
        catch (Exception ex) {
            return strValue;
        }
    }

    protected static Object getRadiusValue(String strValue) throws Exception {
        String[] items = strValue.split("[,]");
        if (items.length == 1) {
            return PSDEChartSeriesImpl2.getNumberOrString(items[0]);
        }
        if (items.length == 2) {
            ArrayList<Object> list = new ArrayList<Object>();
            Object objItem = PSDEChartSeriesImpl2.getNumberOrString(items[0]);
            Object objItem2 = PSDEChartSeriesImpl2.getNumberOrString(items[1]);
            list.add(objItem);
            list.add(objItem2);
            return list;
        }
        throw new Exception(StringHelper.format((String)"\u534a\u5f84[%1$s]\u683c\u5f0f\u6709\u8bef", (Object)strValue));
    }

    protected static List<Object> getCenterValue(String strValue) throws Exception {
        String[] items = strValue.split("[,]");
        ArrayList<Object> list = new ArrayList<Object>();
        if (items.length == 1) {
            Object objItem = PSDEChartSeriesImpl2.getNumberOrString(items[0]);
            list.add(objItem);
            list.add(objItem);
        } else if (items.length == 2) {
            Object objItem = PSDEChartSeriesImpl2.getNumberOrString(items[0]);
            Object objItem2 = PSDEChartSeriesImpl2.getNumberOrString(items[1]);
            list.add(objItem);
            list.add(objItem2);
        } else {
            throw new Exception(StringHelper.format((String)"\u5706\u5fc3[%1$s]\u683c\u5f0f\u6709\u8bef", (Object)strValue));
        }
        return list;
    }
}

