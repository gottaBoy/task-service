/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.db.IDBFunction
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import net.ibizsys.paas.db.IDBFunction;

@PSModelIgnoreMeta
public interface IPSDBFunction
extends IDBFunction {
    public static final String SUM = "SUM";
    public static final String AVG = "AVG";
    public static final String MAX = "MAX";
    public static final String MIN = "MIN";
    public static final String COUNT = "COUNT";
    public static final String DAYOFWEEK = "DAYOFWEEK";
    public static final String DAYOFMONTH = "DAYOFMONTH";
    public static final String DAYOFYEAR = "DAYOFYEAR";
    public static final String WEEK = "WEEK";
    public static final String MONTH = "MONTH";
    public static final String QUARTER = "QUARTER";
    public static final String YEAR = "YEAR";
    public static final String HOUR = "HOUR";
    public static final String MINUTE = "MINUTE";
}

