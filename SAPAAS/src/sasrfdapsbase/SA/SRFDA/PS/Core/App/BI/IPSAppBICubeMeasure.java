/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.BI;

import SA.SRFDA.PS.Core.App.BI.IPSAppBICube;
import SA.SRFDA.PS.Core.App.CodeList.IPSAppCodeList;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUIAction;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.BI.IPSSysBICubeMeasure;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u5e94\u7528\u667a\u80fd\u7acb\u65b9\u4f53\u6307\u6807\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSAppBICubeMeasure
extends IPSModelObject {
    public static final String MEASURETYPE_COMMON = "COMMON";
    public static final String MEASURETYPE_CALCULATED = "CALCULATED";

    public IPSAppBICube getPSAppBICube();

    public IPSSysBICubeMeasure getPSSysBICubeMeasure();

    @Override
    public String getCodeName();

    public IPSAppDEField getPSAppDEField();

    public String getMeasureType();

    public boolean isDataItem();

    public String getMeasureFormula();

    public String getMeasureTag();

    public String getMeasureTag2();

    public String getMeasureGroup();

    public String getJsonFormat();

    public String getAggMode();

    public IPSAppCodeList getPSAppCodeList();

    public IPSAppDEUIAction getParamPSAppDEUIAction();

    public IPSAppView getDrillDownPSAppView();

    public IPSAppView getDrillDetailPSAppView();

    public String getTextTemplate();

    public String getTipTemplate();

    public int getStdDataType();
}

