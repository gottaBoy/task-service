/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.BI;

import SA.SRFDA.PS.Core.App.BI.IPSAppBICubeDimension;
import SA.SRFDA.PS.Core.App.BI.IPSAppBIReport;
import SA.SRFDA.PS.Core.App.CodeList.IPSAppCodeList;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.BI.IPSSysBIReportDimension;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import java.util.Properties;

@PSModelInterfaceMeta(title="\u5e94\u7528\u667a\u80fd\u62a5\u8868\u7ef4\u5ea6\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSAppBIReportDimension
extends IPSModelObject {
    public IPSAppBIReport getPSAppBIReport();

    public IPSSysBIReportDimension getPSSysBIReportDimension();

    public IPSAppBICubeDimension getPSAppBICubeDimension();

    public String getPlaceType();

    public String getPlacement();

    public IPSAppDEField getPSAppDEField();

    public IPSAppDEField getTextPSAppDEField();

    public String getDimensionTag();

    public String getDimensionName();

    public IPSAppCodeList getPSAppCodeList();

    public String getDimensionType();

    public String getDimensionFormula();

    public Properties getDimensionParams();

    public String getItemTag();

    public String getItemTag2();

    public String getTextTemplate();

    public String getTipTemplate();

    public int getStdDataType();
}

