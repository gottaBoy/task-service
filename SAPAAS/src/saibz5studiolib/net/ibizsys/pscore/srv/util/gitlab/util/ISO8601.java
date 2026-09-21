/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.DateHelper
 */
package net.ibizsys.pscore.srv.util.gitlab.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import net.ibizsys.paas.util.DateHelper;

public class ISO8601 {
    public static final String PATTERN = "yyyy-MM-dd'T'HH:mm:ssZ";
    public static final String MSEC_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
    public static final String SPACEY_PATTERN = "yyyy-MM-dd HH:mm:ss Z";
    public static final String SPACEY_MSEC_PATTERN = "yyyy-MM-dd HH:mm:ss.SSS Z";
    public static final String PATTERN_MSEC = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
    public static final String OUTPUT_PATTERN = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    public static final String OUTPUT_MSEC_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    public static final String UTC_PATTERN = "yyyy-MM-dd HH:mm:ss 'UTC'";

    public static String toString(Date date, boolean bl) {
        if (date == null) {
            return null;
        }
        long l = date.getTime();
        return bl && l % 1000L != 0L ? SafeDateFormatter.getDateFormat(OUTPUT_MSEC_PATTERN).format(date) : SafeDateFormatter.getDateFormat(OUTPUT_PATTERN).format(date);
    }

    public static String toString(Date date) {
        return ISO8601.toString(date, true);
    }

    public static Date toDate(String string) throws Exception, ParseException {
        if (string == null) {
            return null;
        }
        if ((string = string.trim()).endsWith("Z")) {
            return DateHelper.parse((String)string);
        }
        if (string.endsWith("UTC")) {
            string = string.replace("UTC", "+0000");
        }
        return DateHelper.parse((String)string);
    }

    private static final class SafeDateFormatter {
        private static final ThreadLocal<Map<String, SimpleDateFormat>> safeFormats = new ThreadLocal<Map<String, SimpleDateFormat>>(){

            @Override
            public Map<String, SimpleDateFormat> initialValue() {
                return new ConcurrentHashMap<String, SimpleDateFormat>();
            }
        };

        private SafeDateFormatter() {
        }

        private static SimpleDateFormat getDateFormat(String string) {
            Map<String, SimpleDateFormat> map = safeFormats.get();
            SimpleDateFormat simpleDateFormat = map.get(string);
            if (simpleDateFormat == null) {
                simpleDateFormat = new SimpleDateFormat(string);
                simpleDateFormat.setLenient(true);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                map.put(string, simpleDateFormat);
            }
            return simpleDateFormat;
        }
    }
}

