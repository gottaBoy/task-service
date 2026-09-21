/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.report;

import java.util.HashMap;
import net.ibizsys.paas.report.IPrintService;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PrintServiceGlobal {
    private static final Log log = LogFactory.getLog(PrintServiceGlobal.class);
    private static HashMap<String, IPrintService> reportServiceMap = new HashMap();

    public static void registerPrintService(String strPrintServiceClsType, IPrintService iPrintService) {
        reportServiceMap.put(strPrintServiceClsType, iPrintService);
    }

    public static IPrintService getPrintService(Class cls) throws Exception {
        return PrintServiceGlobal.getPrintService(cls.getCanonicalName());
    }

    public static IPrintService getPrintService(String strPrintServiceClsType) throws Exception {
        IPrintService iPrintService = reportServiceMap.get(strPrintServiceClsType);
        if (iPrintService == null) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6253\u5370\u670d\u52a1[%1$s]", strPrintServiceClsType));
        }
        return iPrintService;
    }
}

