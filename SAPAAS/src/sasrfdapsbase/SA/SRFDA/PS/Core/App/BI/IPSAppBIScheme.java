/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.BI;

import SA.SRFDA.PS.Core.App.BI.IPSAppBICube;
import SA.SRFDA.PS.Core.App.BI.IPSAppBIReport;
import SA.SRFDA.PS.Core.App.IPSApplicationObject;
import SA.SRFDA.PS.Core.BI.IPSSysBICube;
import SA.SRFDA.PS.Core.BI.IPSSysBIReport;
import SA.SRFDA.PS.Core.BI.IPSSysBIScheme;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u5e94\u7528\u667a\u80fd\u62a5\u8868\u4f53\u7cfb\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSAppBIScheme
extends IPSApplicationObject {
    public IPSSysBIScheme getPSSysBIScheme();

    public Iterator<IPSAppBICube> getPSAppBICubes();

    public IPSAppBICube getPSAppBICube(IPSSysBICube var1, boolean var2) throws Exception;

    public Iterator<IPSAppBIReport> getPSAppBIReports();

    public IPSAppBIReport getPSAppBIReport(IPSSysBIReport var1, boolean var2) throws Exception;

    public String getUniqueTag();
}

