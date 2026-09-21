/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Panel;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEAction;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEDataSet;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDELogic;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethod;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.Control.IPSNavigateParamContainer;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u9762\u677f\u6570\u636e\u533a\u57df\u6a21\u578b\u5bf9\u8c61\u57fa\u7840\u63a5\u53e3")
public interface IPSPanelDataRegion
extends IPSNavigateParamContainer {
    public static final String DATAREGIONTYPE_NONE = "NONE";
    public static final String DATAREGIONTYPE_LOGINFORM = "LOGINFORM";
    public static final String DATAREGIONTYPE_SINGLEDATA = "SINGLEDATA";
    public static final String DATAREGIONTYPE_MULTIDATA = "MULTIDATA";
    public static final String DATAREGIONTYPE_MULTIDATA_RAW = "MULTIDATA_RAW";
    public static final String DATAREGIONTYPE_INHERIT = "INHERIT";
    public static final String DATAREGIONTYPE_USER = "USER";
    public static final String DATASOURCETYPE_DEACTION = "DEACTION";
    public static final String DATASOURCETYPE_DEDATASET = "DEDATASET";
    public static final String DATASOURCETYPE_DELOGIC = "DELOGIC";
    public static final String DATASOURCETYPE_ACTIVEDATAPARAM = "ACTIVEDATAPARAM";
    public static final String DATASOURCETYPE_APPGLOBALPARAM = "APPGLOBALPARAM";
    public static final String DATASOURCETYPE_TOPVIEWSESSIONPARAM = "TOPVIEWSESSIONPARAM";
    public static final String DATASOURCETYPE_VIEWSESSIONPARAM = "VIEWSESSIONPARAM";
    public static final String DATASOURCETYPE_CUSTOM = "CUSTOM";

    public String getDataRegionType();

    public String getDataSourceType();

    public IPSAppDataEntity getPSAppDataEntity();

    public IPSAppDELogic getPSAppDELogic();

    public IPSAppDEAction getPSAppDEAction();

    public IPSAppDEDataSet getPSAppDEDataSet();

    public int getReloadTimer();

    public IPSAppDEMethod getPSAppDEMethod();

    public String getDataName();

    public String getScriptCode();

    public boolean isShowBusyIndicator();
}

