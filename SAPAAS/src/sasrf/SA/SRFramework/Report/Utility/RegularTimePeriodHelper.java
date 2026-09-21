/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jfree.data.time.Day
 *  org.jfree.data.time.Hour
 *  org.jfree.data.time.Minute
 *  org.jfree.data.time.Month
 *  org.jfree.data.time.Quarter
 *  org.jfree.data.time.RegularTimePeriod
 *  org.jfree.data.time.Second
 *  org.jfree.data.time.Week
 *  org.jfree.data.time.Year
 */
package SA.SRFramework.Report.Utility;

import SA.SRFramework.SASRFException;
import SA.SRFramework.Utility.DateParser;
import java.util.Date;
import org.jfree.data.time.Day;
import org.jfree.data.time.Hour;
import org.jfree.data.time.Minute;
import org.jfree.data.time.Month;
import org.jfree.data.time.Quarter;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.Second;
import org.jfree.data.time.Week;
import org.jfree.data.time.Year;

public class RegularTimePeriodHelper {
    public static RegularTimePeriod FromString(String strDateString, int timeSeriesMode) {
        try {
            Date curDate = DateParser.Parser(strDateString);
            switch (timeSeriesMode) {
                case 1: {
                    return new Second(curDate);
                }
                case 2: {
                    return new Minute(curDate);
                }
                case 3: {
                    return new Hour(curDate);
                }
                case 4: {
                    return new Day(curDate);
                }
                case 5: {
                    return new Week(curDate);
                }
                case 6: {
                    return new Month(curDate);
                }
                case 7: {
                    return new Quarter(curDate);
                }
                case 8: {
                    return new Year(curDate);
                }
            }
            throw new SASRFException("\u4e0d\u660e\u7684\u65f6\u95f4\u7c7b\u578b");
        }
        catch (Exception ex) {
            ex.printStackTrace(System.err);
            return null;
        }
    }
}

