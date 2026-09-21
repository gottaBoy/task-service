/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.BI;

import SA.SRFDA.PS.Core.App.BI.IPSAppBICubeMeasure;
import SA.SRFDA.PS.Core.App.BI.IPSAppBIReport;
import SA.SRFDA.PS.Core.App.CodeList.IPSAppCodeList;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.BI.IPSSysBIReportMeasure;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import java.util.Properties;

@PSModelInterfaceMeta(title="\u5e94\u7528\u667a\u80fd\u62a5\u8868\u6307\u6807\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSAppBIReportMeasure
extends IPSModelObject {
    public IPSAppBIReport getPSAppBIReport();

    public IPSSysBIReportMeasure getPSSysBIReportMeasure();

    public IPSAppBICubeMeasure getPSAppBICubeMeasure();

    public String getPlaceType();

    public IPSAppDEField getPSAppDEField();

    public String getMeasureType();

    public String getMeasureFormula();

    public String getMeasureTag();

    public String getMeasureName();

    public String getMeasureGroup();

    public String getJsonFormat();

    public String getAggMode();

    public IPSAppCodeList getPSAppCodeList();

    public Properties getMeasureParams();

    public String getItemTag();

    public String getItemTag2();

    public IPSAppView getDrillDownPSAppView();

    public IPSAppView getDrillDetailPSAppView();

    public String getTextTemplate();

    public String getTipTemplate();

    public int getStdDataType();
}

