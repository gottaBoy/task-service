/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core.valuetranslator;

import net.ibizsys.paas.core.valuetranslator.ValueTranslatorBase;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;

public class DateValueTranslator
extends ValueTranslatorBase {
    public static final String DATETIME = "DATE|YYYY-MM-DD HH:mm:ss";
    public static final String DATE = "DATE|YYYY-MM-DD";
    public static final String TIME = "DATE|HH:mm:ss";
    public static final String DATETIME_NOMINUTE = "DATE|YYYY-MM-DD HH";
    public static final String DATETIME_NOSECOND = "DATE|YYYY-MM-DD HH:mm";
    public static final String TIME_NOSECOND = "DATE|HH:mm";

    @Override
    public Object convert(String strValue) throws Exception {
        if (StringHelper.isNullOrEmpty(strValue)) {
            return null;
        }
        String strDataTimeString = strValue;
        if (StringHelper.compare(DATE, this.getParam(), true) == 0) {
            strDataTimeString = StringHelper.format("%1$s 00:00:00", strValue);
        } else if (StringHelper.compare(TIME, this.getParam(), true) == 0) {
            strDataTimeString = StringHelper.format("1970-01-01 %1$s", strValue);
        } else if (StringHelper.compare(DATETIME_NOMINUTE, this.getParam(), true) == 0) {
            strDataTimeString = StringHelper.format("%1$s:00:00", strValue);
        } else if (StringHelper.compare(DATETIME_NOSECOND, this.getParam(), true) == 0) {
            strDataTimeString = StringHelper.format("%1$s:00", strValue);
        } else if (StringHelper.compare(TIME_NOSECOND, this.getParam(), true) == 0) {
            strDataTimeString = StringHelper.format("1970-01-01 %1$s:00", strValue);
        }
        return DataTypeHelper.parse(5, strDataTimeString);
    }
}

