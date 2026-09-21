/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.BI;

import SA.SRFDA.PS.Core.App.BI.IPSAppBICube;
import SA.SRFDA.PS.Core.App.BI.IPSAppBIReportDimension;
import SA.SRFDA.PS.Core.App.BI.IPSAppBIReportMeasure;
import SA.SRFDA.PS.Core.App.BI.IPSAppBIScheme;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.BI.IPSSysBIReport;
import SA.SRFDA.PS.Core.BI.IPSSysBIReportDimension;
import SA.SRFDA.PS.Core.BI.IPSSysBIReportMeasure;
import SA.SRFDA.PS.Core.Control.Panel.IPSLayoutPanel;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u5e94\u7528\u667a\u80fd\u62a5\u8868\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSAppBIReport
extends IPSModelObject {
    public IPSAppBIScheme getPSAppBIScheme();

    public IPSSysBIReport getPSSysBIReport();

    public IPSAppBICube getPSAppBICube();

    public IPSAppDataEntity getPSAppDataEntity();

    public Iterator<IPSAppBIReportDimension> getPSAppBIReportDimensions();

    public IPSAppBIReportDimension getPSAppBIReportDimension(IPSSysBIReportDimension var1) throws Exception;

    public Iterator<IPSAppBIReportMeasure> getPSAppBIReportMeasures();

    public IPSAppBIReportMeasure getPSAppBIReportMeasure(IPSSysBIReportMeasure var1) throws Exception;

    public String getReportUIModel();

    public String getReportTag();

    public String getReportTag2();

    public IPSLayoutPanel getPSLayoutPanel();

    public String getAccessKey();
}

