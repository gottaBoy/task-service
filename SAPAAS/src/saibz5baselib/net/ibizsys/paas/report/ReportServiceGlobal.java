/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.report;

import java.util.HashMap;
import net.ibizsys.paas.report.IReportService;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ReportServiceGlobal {
    private static final Log log = LogFactory.getLog(ReportServiceGlobal.class);
    private static HashMap<String, IReportService> reportServiceMap = new HashMap();

    public static void registerReportService(String strReportServiceClsType, IReportService iReportService) {
        reportServiceMap.put(strReportServiceClsType, iReportService);
    }

    public static IReportService getReportService(Class cls) throws Exception {
        return ReportServiceGlobal.getReportService(cls.getCanonicalName());
    }

    public static IReportService getReportService(String strReportServiceClsType) throws Exception {
        IReportService iReportService = reportServiceMap.get(strReportServiceClsType);
        if (iReportService == null) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u62a5\u8868\u670d\u52a1[%1$s]", strReportServiceClsType));
        }
        return iReportService;
    }
}

