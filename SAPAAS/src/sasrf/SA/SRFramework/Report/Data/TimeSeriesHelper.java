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
 *  org.jfree.data.time.Week
 *  org.jfree.data.time.Year
 */
package SA.SRFramework.Report.Data;

import SA.SRFramework.Data.BaseXYDataHelper;
import SA.SRFramework.Data.DataItem;
import SA.SRFramework.Report.Utility.RegularTimePeriodHelper;
import org.jfree.data.time.Day;
import org.jfree.data.time.Hour;
import org.jfree.data.time.Minute;
import org.jfree.data.time.Month;
import org.jfree.data.time.Quarter;
import org.jfree.data.time.Second;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.Week;
import org.jfree.data.time.Year;

public class TimeSeriesHelper
extends BaseXYDataHelper {
    protected int timeSeriesMode = 6;
    protected TimeSeries timeSeries = null;

    public TimeSeriesHelper(String strSeriesName) {
        this.CreateTimeSeries(strSeriesName);
    }

    public TimeSeriesHelper(String strSeriesName, int mode) {
        this.timeSeriesMode = mode;
        this.CreateTimeSeries(strSeriesName);
    }

    private void CreateTimeSeries(String strSeriesName) {
        switch (this.timeSeriesMode) {
            case 1: {
                this.timeSeries = new TimeSeries(strSeriesName, Second.class);
                break;
            }
            case 2: {
                this.timeSeries = new TimeSeries(strSeriesName, Minute.class);
                break;
            }
            case 3: {
                this.timeSeries = new TimeSeries(strSeriesName, Hour.class);
                break;
            }
            case 4: {
                this.timeSeries = new TimeSeries(strSeriesName, Day.class);
                break;
            }
            case 5: {
                this.timeSeries = new TimeSeries(strSeriesName, Week.class);
                break;
            }
            case 6: {
                this.timeSeries = new TimeSeries(strSeriesName, Month.class);
                break;
            }
            case 7: {
                this.timeSeries = new TimeSeries(strSeriesName, Quarter.class);
                break;
            }
            case 8: {
                this.timeSeries = new TimeSeries(strSeriesName, Year.class);
                break;
            }
        }
    }

    @Override
    public void DataBind() throws Exception {
        super.DataBind();
        for (Object objItem : this.itemList) {
            DataItem dataItem = (DataItem)objItem;
            this.timeSeries.add(RegularTimePeriodHelper.FromString(dataItem.getX(), this.timeSeriesMode), Double.parseDouble(dataItem.getY()));
        }
    }

    public TimeSeries getTimeSeries() {
        return this.timeSeries;
    }
}

