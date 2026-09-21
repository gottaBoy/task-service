/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Utility;

import SA.SRFramework.Utility.StringHelper;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public final class DateParser {
    public static final long MILLISECONDS_OF_DAY = 86400000L;

    public static Date Parse(String strTimeString, TimeZone timeZone) throws ParseException, Exception {
        return DateParser.Parser(strTimeString);
    }

    public static Date Parse(String strTimeString) throws ParseException, Exception {
        return DateParser.Parser(strTimeString);
    }

    public static Date Parser(String strTimeString) throws ParseException, Exception {
        return DateParser.Parser(strTimeString, null);
    }

    public static Date Parser(String strTimeString, TimeZone timeZone) throws ParseException, Exception {
        if ((strTimeString = strTimeString.trim()).length() == 0) {
            throw new Exception("unknown date(time) string");
        }
        String[] strPart = strTimeString.split(" ");
        if (strPart.length == 2) {
            String strDate = "";
            String strTime = "";
            if (strPart[0].indexOf(":") != -1) {
                strTime = strPart[0];
                strDate = strPart[1];
            } else {
                strTime = strPart[1];
                strDate = strPart[0];
            }
            strDate = strDate.trim();
            strTime = strTime.trim();
            strDate = DateParser.GetFormatDateString(strDate);
            strTime = DateParser.GetFormatTimeString(strTime);
            SimpleDateFormat dtFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            if (timeZone != null) {
                dtFormat.setTimeZone(timeZone);
            }
            return dtFormat.parse(String.valueOf(strDate) + " " + strTime);
        }
        if (strTimeString.indexOf(":") != -1) {
            strTimeString = DateParser.GetFormatTimeString(strTimeString);
            SimpleDateFormat dtFormat = new SimpleDateFormat("HH:mm:ss");
            if (timeZone != null) {
                dtFormat.setTimeZone(timeZone);
            }
            return dtFormat.parse(strTimeString);
        }
        strTimeString = DateParser.GetFormatDateString(strTimeString);
        SimpleDateFormat dtFormat = new SimpleDateFormat("yyyy-MM-dd");
        if (timeZone != null) {
            dtFormat.setTimeZone(timeZone);
        }
        return dtFormat.parse(strTimeString);
    }

    private static String GetFormatTimeString(String strOrigin) {
        int nDotPos = strOrigin.indexOf(".");
        if (nDotPos != -1) {
            strOrigin = strOrigin.substring(0, nDotPos);
        }
        Object[] Time2 = new Object[]{0, 0, 0};
        String[] timepart = strOrigin.split(":");
        int i = 0;
        while (i < timepart.length) {
            Time2[i] = Integer.parseInt(timepart[i]);
            ++i;
        }
        return StringHelper.Format("%1$02d:%2$02d:%3$02d", Time2);
    }

    private static String GetFormatDateString(String strOrigin) throws Exception {
        return DateParser.GetFormatDateString(strOrigin, true);
    }

    private static String GetFormatDateString(String strOrigin, boolean bAdv) throws Exception {
        Object[] Date2 = new Object[]{1970, 1, 1};
        if (strOrigin.indexOf("-") != -1) {
            String[] datePart = strOrigin.split("-");
            if (datePart.length >= 1) {
                Date2[0] = Integer.parseInt(datePart[0]);
            }
            if (datePart.length >= 2) {
                Date2[1] = Integer.parseInt(datePart[1]);
            }
            if (datePart.length >= 3) {
                Date2[2] = Integer.parseInt(datePart[2]);
            }
        } else if (strOrigin.indexOf("/") != -1) {
            String[] datePart = strOrigin.split("/");
            if (datePart.length >= 1) {
                Date2[1] = Integer.parseInt(datePart[0]);
            }
            if (datePart.length >= 2) {
                Date2[2] = Integer.parseInt(datePart[1]);
            }
            if (datePart.length >= 3) {
                Date2[0] = Integer.parseInt(datePart[2]);
            }
        } else {
            if (bAdv) {
                strOrigin = strOrigin.replace(".", "-");
                strOrigin = strOrigin.replace("\u65e5", "");
                strOrigin = strOrigin.replace("\u5929", "");
                strOrigin = strOrigin.replace("\u5e74", "-");
                strOrigin = strOrigin.replace("\u6708", "-");
                return DateParser.GetFormatDateString(strOrigin, false);
            }
            throw new Exception(StringHelper.Format("\u65e0\u6cd5\u8bc6\u522b\u7684\u65f6\u95f4\u5b57\u7b26\u4e32,%1$s", strOrigin));
        }
        return StringHelper.Format("%1$04d-%2$02d-%3$02d", Date2);
    }

    public static String toTimeString(Date dt) {
        if (dt == null) {
            return "00:00:00";
        }
        return String.format("%1$tH:%1$tM:%1$tS", dt);
    }

    public static String toDateString(Date dt) {
        if (dt == null) {
            return "1970-01-01";
        }
        return String.format("%1$tY-%1$tm-%1$td", dt);
    }

    public static String toHourString(Date dt) {
        return String.format("%1$tH", dt);
    }

    public static String toYearString(Date dt) {
        return String.format("%1$tY", dt);
    }

    public static String toMonthString(Date dt) {
        return String.format("%1$tm", dt);
    }

    public static String toDayString(Date dt) {
        return String.format("%1$td", dt);
    }

    public static String toMinuteString(Date dt) {
        return String.format("%1$tM", dt);
    }

    public static String toSecondString(Date dt) {
        return String.format("%1$tS", dt);
    }

    public static String toDateTimeString(Date dt) {
        return String.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", dt);
    }

    public static java.sql.Date GetDateValue(Object objValue) {
        block6: {
            try {
                if (objValue != null) break block6;
                return null;
            }
            catch (Exception ex) {
                return null;
            }
        }
        if (objValue instanceof java.sql.Date) {
            return (java.sql.Date)objValue;
        }
        if (objValue instanceof Timestamp) {
            Timestamp ti = (Timestamp)objValue;
            return new java.sql.Date(ti.getTime());
        }
        if (objValue instanceof Date) {
            return new java.sql.Date(((Date)objValue).getTime());
        }
        return null;
    }

    public static Timestamp GetTimestampValue(Object objValue) {
        block6: {
            try {
                if (objValue != null) break block6;
                return null;
            }
            catch (Exception ex) {
                return null;
            }
        }
        if (objValue instanceof Timestamp) {
            return (Timestamp)objValue;
        }
        if (objValue instanceof java.sql.Date) {
            java.sql.Date ti = (java.sql.Date)objValue;
            return new Timestamp(ti.getTime());
        }
        if (objValue instanceof Date) {
            return new Timestamp(((Date)objValue).getTime());
        }
        return null;
    }

    public static final boolean isDateTimeType(Object objValue) {
        if (objValue == null) {
            return false;
        }
        if (objValue instanceof java.sql.Date) {
            return true;
        }
        if (objValue instanceof Timestamp) {
            return true;
        }
        return objValue instanceof Date;
    }

    public static long GetTime(Object obj) {
        if (obj instanceof Time) {
            return ((Time)obj).getTime();
        }
        if (obj instanceof java.sql.Date) {
            return ((java.sql.Date)obj).getTime();
        }
        if (obj instanceof Timestamp) {
            return ((Timestamp)obj).getTime();
        }
        if (obj instanceof Date) {
            return ((Date)obj).getTime();
        }
        return -1L;
    }

    public static final Object AdjustByTimeZone(Object objValue, TimeZone timeZone, boolean bSave) {
        if (timeZone == null || objValue == null) {
            return objValue;
        }
        long nCurTime = System.currentTimeMillis();
        int offset1 = 0;
        int offset2 = 0;
        if (bSave) {
            offset2 = TimeZone.getDefault().getOffset(nCurTime);
            offset1 = timeZone.getOffset(nCurTime);
        } else {
            offset1 = TimeZone.getDefault().getOffset(nCurTime);
            offset2 = timeZone.getOffset(nCurTime);
        }
        if (offset1 == offset2) {
            return objValue;
        }
        if (objValue instanceof Timestamp) {
            return new Timestamp(((Timestamp)objValue).getTime() - (long)offset1 + (long)offset2);
        }
        if (objValue instanceof java.sql.Date) {
            return new java.sql.Date(((java.sql.Date)objValue).getTime() - (long)offset1 + (long)offset2);
        }
        if (objValue instanceof Date) {
            return new Date(((Date)objValue).getTime() - (long)offset1 + (long)offset2);
        }
        return objValue;
    }

    public static Timestamp GetCurTime() {
        return new Timestamp(new Date().getTime());
    }
}

