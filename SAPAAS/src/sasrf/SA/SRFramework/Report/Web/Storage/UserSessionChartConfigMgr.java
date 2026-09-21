/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 */
package SA.SRFramework.Report.Web.Storage;

import SA.SRFramework.Report.UI.ChartConfig;
import SA.SRFramework.Report.Web.Storage.BaseChartConfigMgr;
import SA.SRFramework.Report.Web.Storage.ChartClearTaskTimer;
import SA.SRFramework.Utility.Helper;
import java.util.Date;
import java.util.Hashtable;
import javax.servlet.http.HttpServletRequest;

public class UserSessionChartConfigMgr
implements BaseChartConfigMgr {
    private Hashtable chartHashtable = null;
    private Hashtable chartTimeHashtable = null;
    private ChartClearTaskTimer chartClearTaskTimer = null;

    public static UserSessionChartConfigMgr Current(HttpServletRequest request) {
        if (request.getSession().getAttribute("SASRFUSERCHARTS") == null) {
            return null;
        }
        return (UserSessionChartConfigMgr)request.getSession().getAttribute("SASRFUSERCHARTS");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public synchronized String RegisterChart(ChartConfig chartConfig) {
        if (chartConfig == null) {
            return "";
        }
        if (this.chartHashtable == null) {
            this.chartHashtable = new Hashtable();
            this.chartTimeHashtable = new Hashtable();
        }
        String strKeyId = Helper.GenGuid();
        Hashtable hashtable = this.chartHashtable;
        synchronized (hashtable) {
            this.chartHashtable.put(strKeyId, chartConfig);
            this.chartTimeHashtable.put(strKeyId, new Date().getTime());
        }
        if (this.chartClearTaskTimer != null && !this.chartClearTaskTimer.IsTimer()) {
            this.chartClearTaskTimer = null;
        }
        if (this.chartClearTaskTimer == null) {
            this.chartClearTaskTimer = new ChartClearTaskTimer(this.chartHashtable, this.chartTimeHashtable);
        }
        return strKeyId;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public synchronized void RemoveChart(String strKey) {
        if (this.chartHashtable == null) {
            return;
        }
        Hashtable hashtable = this.chartHashtable;
        synchronized (hashtable) {
            if (this.chartHashtable.containsKey(strKey)) {
                this.chartHashtable.remove(strKey);
                this.chartTimeHashtable.remove(strKey);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public synchronized ChartConfig GetChart(String strKey) {
        if (this.chartHashtable == null) {
            return null;
        }
        Hashtable hashtable = this.chartHashtable;
        synchronized (hashtable) {
            if (this.chartHashtable.containsKey(strKey)) {
                this.chartTimeHashtable.put(strKey, new Date().getTime());
                return (ChartConfig)this.chartHashtable.get(strKey);
            }
        }
        return null;
    }
}

