/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 */
package SA.SRFramework.Log;

import SA.SRFramework.Log.LogParam;
import org.apache.commons.logging.Log;

public class LoggerEx {
    public static void error(Log log, Object objInfo) {
        LoggerEx.error(log, objInfo, null, null, null, null, null, null);
    }

    public static void error(Log log, Object objInfo, Throwable arg1) {
        LoggerEx.error(log, objInfo, arg1, null, null, null, null, null);
    }

    public static void error(Log log, Object objInfo, Throwable arg1, Object obj1) {
        LoggerEx.error(log, objInfo, arg1, obj1, null, null, null, null);
    }

    public static void error(Log log, Object objInfo, Throwable arg1, Object obj1, Object obj2) {
        LoggerEx.error(log, objInfo, arg1, obj1, obj2, null, null, null);
    }

    public static void error(Log log, Object objInfo, Throwable arg1, Object obj1, Object obj2, Object obj3) {
        LoggerEx.error(log, objInfo, arg1, obj1, obj2, obj3, null, null);
    }

    public static void error(Log log, Object objInfo, Throwable arg1, Object obj1, Object obj2, Object obj3, Object obj4) {
        LoggerEx.error(log, objInfo, arg1, obj1, obj2, obj3, obj4, null);
    }

    public static void error(Log log, Object objInfo, Throwable arg1, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5) {
        log.error((Object)new LogParam(objInfo, arg1, obj1, obj2, obj3, obj4, obj5), arg1);
    }

    public static void debug(Log log, Object objInfo) {
        LoggerEx.debug(log, objInfo, null, null, null, null, null, null);
    }

    public static void debug(Log log, Object objInfo, Throwable arg1) {
        LoggerEx.debug(log, objInfo, arg1, null, null, null, null, null);
    }

    public static void debug(Log log, Object objInfo, Throwable arg1, Object obj1) {
        LoggerEx.debug(log, objInfo, arg1, obj1, null, null, null, null);
    }

    public static void debug(Log log, Object objInfo, Throwable arg1, Object obj1, Object obj2) {
        LoggerEx.debug(log, objInfo, arg1, obj1, obj2, null, null, null);
    }

    public static void debug(Log log, Object objInfo, Throwable arg1, Object obj1, Object obj2, Object obj3) {
        LoggerEx.debug(log, objInfo, arg1, obj1, obj2, obj3, null, null);
    }

    public static void debug(Log log, Object objInfo, Throwable arg1, Object obj1, Object obj2, Object obj3, Object obj4) {
        LoggerEx.debug(log, objInfo, arg1, obj1, obj2, obj3, obj4, null);
    }

    public static void debug(Log log, Object objInfo, Throwable arg1, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5) {
        log.debug((Object)new LogParam(objInfo, arg1, obj1, obj2, obj3, obj4, obj5), arg1);
    }

    public static void fatal(Log log, Object objInfo) {
        LoggerEx.fatal(log, objInfo, null, null, null, null, null, null);
    }

    public static void fatal(Log log, Object objInfo, Throwable arg1) {
        LoggerEx.fatal(log, objInfo, arg1, null, null, null, null, null);
    }

    public static void fatal(Log log, Object objInfo, Throwable arg1, Object obj1) {
        LoggerEx.fatal(log, objInfo, arg1, obj1, null, null, null, null);
    }

    public static void fatal(Log log, Object objInfo, Throwable arg1, Object obj1, Object obj2) {
        LoggerEx.fatal(log, objInfo, arg1, obj1, obj2, null, null, null);
    }

    public static void fatal(Log log, Object objInfo, Throwable arg1, Object obj1, Object obj2, Object obj3) {
        LoggerEx.fatal(log, objInfo, arg1, obj1, obj2, obj3, null, null);
    }

    public static void fatal(Log log, Object objInfo, Throwable arg1, Object obj1, Object obj2, Object obj3, Object obj4) {
        LoggerEx.fatal(log, objInfo, arg1, obj1, obj2, obj3, obj4, null);
    }

    public static void fatal(Log log, Object objInfo, Throwable arg1, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5) {
        log.fatal((Object)new LogParam(objInfo, arg1, obj1, obj2, obj3, obj4, obj5), arg1);
    }

    public static void info(Log log, Object objInfo) {
        LoggerEx.info(log, objInfo, null, null, null, null, null, null);
    }

    public static void info(Log log, Object objInfo, Throwable arg1) {
        LoggerEx.info(log, objInfo, arg1, null, null, null, null, null);
    }

    public static void info(Log log, Object objInfo, Throwable arg1, Object obj1) {
        LoggerEx.info(log, objInfo, arg1, obj1, null, null, null, null);
    }

    public static void info(Log log, Object objInfo, Throwable arg1, Object obj1, Object obj2) {
        LoggerEx.info(log, objInfo, arg1, obj1, obj2, null, null, null);
    }

    public static void info(Log log, Object objInfo, Throwable arg1, Object obj1, Object obj2, Object obj3) {
        LoggerEx.info(log, objInfo, arg1, obj1, obj2, obj3, null, null);
    }

    public static void info(Log log, Object objInfo, Throwable arg1, Object obj1, Object obj2, Object obj3, Object obj4) {
        LoggerEx.info(log, objInfo, arg1, obj1, obj2, obj3, obj4, null);
    }

    public static void info(Log log, Object objInfo, Throwable arg1, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5) {
        log.info((Object)new LogParam(objInfo, arg1, obj1, obj2, obj3, obj4, obj5), arg1);
    }

    public static void warn(Log log, Object objInfo) {
        LoggerEx.warn(log, objInfo, null, null, null, null, null, null);
    }

    public static void warn(Log log, Object objInfo, Throwable arg1) {
        LoggerEx.warn(log, objInfo, arg1, null, null, null, null, null);
    }

    public static void warn(Log log, Object objInfo, Throwable arg1, Object obj1) {
        LoggerEx.warn(log, objInfo, arg1, obj1, null, null, null, null);
    }

    public static void warn(Log log, Object objInfo, Throwable arg1, Object obj1, Object obj2) {
        LoggerEx.warn(log, objInfo, arg1, obj1, obj2, null, null, null);
    }

    public static void warn(Log log, Object objInfo, Throwable arg1, Object obj1, Object obj2, Object obj3) {
        LoggerEx.warn(log, objInfo, arg1, obj1, obj2, obj3, null, null);
    }

    public static void warn(Log log, Object objInfo, Throwable arg1, Object obj1, Object obj2, Object obj3, Object obj4) {
        LoggerEx.warn(log, objInfo, arg1, obj1, obj2, obj3, obj4, null);
    }

    public static void warn(Log log, Object objInfo, Throwable arg1, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5) {
        log.warn((Object)new LogParam(objInfo, arg1, obj1, obj2, obj3, obj4, obj5), arg1);
    }

    public static void trace(Log log, Object objInfo) {
        LoggerEx.trace(log, objInfo, null, null, null, null, null, null);
    }

    public static void trace(Log log, Object objInfo, Throwable arg1) {
        LoggerEx.trace(log, objInfo, arg1, null, null, null, null, null);
    }

    public static void trace(Log log, Object objInfo, Throwable arg1, Object obj1) {
        LoggerEx.trace(log, objInfo, arg1, obj1, null, null, null, null);
    }

    public static void trace(Log log, Object objInfo, Throwable arg1, Object obj1, Object obj2) {
        LoggerEx.trace(log, objInfo, arg1, obj1, obj2, null, null, null);
    }

    public static void trace(Log log, Object objInfo, Throwable arg1, Object obj1, Object obj2, Object obj3) {
        LoggerEx.trace(log, objInfo, arg1, obj1, obj2, obj3, null, null);
    }

    public static void trace(Log log, Object objInfo, Throwable arg1, Object obj1, Object obj2, Object obj3, Object obj4) {
        LoggerEx.trace(log, objInfo, arg1, obj1, obj2, obj3, obj4, null);
    }

    public static void trace(Log log, Object objInfo, Throwable arg1, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5) {
        log.trace((Object)new LogParam(objInfo, arg1, obj1, obj2, obj3, obj4, obj5), arg1);
    }
}

