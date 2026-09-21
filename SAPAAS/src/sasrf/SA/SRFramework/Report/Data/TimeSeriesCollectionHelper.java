/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jfree.data.time.Day
 *  org.jfree.data.time.Hour
 *  org.jfree.data.time.Minute
 *  org.jfree.data.time.Month
 *  org.jfree.data.time.Quarter
 *  org.jfree.data.time.Second
 *  org.jfree.data.time.TimeSeries
 *  org.jfree.data.time.TimeSeriesCollection
 *  org.jfree.data.time.Week
 *  org.jfree.data.time.Year
 */
package SA.SRFramework.Report.Data;

import SA.SRFramework.Data.BaseXYZDataHelper;
import SA.SRFramework.Data.DataItem;
import SA.SRFramework.Report.Utility.RegularTimePeriodHelper;
import java.util.ArrayList;
import java.util.Hashtable;
import org.jfree.data.time.Day;
import org.jfree.data.time.Hour;
import org.jfree.data.time.Minute;
import org.jfree.data.time.Month;
import org.jfree.data.time.Quarter;
import org.jfree.data.time.Second;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.Week;
import org.jfree.data.time.Year;

public class TimeSeriesCollectionHelper
extends BaseXYZDataHelper {
    protected int timeSeriesMode = 6;
    private ArrayList timeSeriesList = new ArrayList();
    private Hashtable keySeries = new Hashtable();

    public TimeSeriesCollectionHelper() {
    }

    public TimeSeriesCollectionHelper(int value) {
        this.timeSeriesMode = value;
    }

    private TimeSeries CreateTimeSeries(String strSeriesName) {
        switch (this.timeSeriesMode) {
            case 1: {
                return new TimeSeries(strSeriesName, Second.class);
            }
            case 2: {
                return new TimeSeries(strSeriesName, Minute.class);
            }
            case 3: {
                return new TimeSeries(strSeriesName, Hour.class);
            }
            case 4: {
                return new TimeSeries(strSeriesName, Day.class);
            }
            case 5: {
                return new TimeSeries(strSeriesName, Week.class);
            }
            case 6: {
                return new TimeSeries(strSeriesName, Month.class);
            }
            case 7: {
                return new TimeSeries(strSeriesName, Quarter.class);
            }
            case 8: {
                return new TimeSeries(strSeriesName, Year.class);
            }
        }
        return null;
    }

    @Override
    public void DataBind() throws Exception {
        super.DataBind();
        for (Object objItem : this.itemList) {
            DataItem dataItem = (DataItem)objItem;
            String strGroupKey = dataItem.getZ();
            TimeSeries timeSeries = null;
            if (this.keySeries.containsKey(strGroupKey)) {
                timeSeries = (TimeSeries)this.keySeries.get(strGroupKey);
            } else {
                timeSeries = this.CreateTimeSeries(strGroupKey);
                this.keySeries.put(strGroupKey, timeSeries);
                this.timeSeriesList.add(strGroupKey);
            }
            timeSeries.add(RegularTimePeriodHelper.FromString(dataItem.getX(), this.timeSeriesMode), Double.parseDouble(dataItem.getY()));
        }
    }

    public TimeSeriesCollection getTimeSeriesCollection() {
        TimeSeriesCollection tsc = new TimeSeriesCollection();
        int i = 0;
        while (i < this.timeSeriesList.size()) {
            String strKey = (String)this.timeSeriesList.get(i);
            if (this.keySeries.containsKey(strKey)) {
                TimeSeries timeSeries = (TimeSeries)this.keySeries.get(strKey);
                tsc.addSeries(timeSeries);
            }
            ++i;
        }
        return tsc;
    }

    public ArrayList getSeriesList() {
        return this.timeSeriesList;
    }
}

