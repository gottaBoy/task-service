/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.DataEntity;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethodInput;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethodReturn;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntityObject;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPIMethod;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PF.IPSPFXCodeObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;

@PSModelInterfaceMeta(title="\u5e94\u7528\u5b9e\u4f53\u65b9\u6cd5\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSAppDEMethod
extends IPSModelObject,
IPSAppDataEntityObject {
    public static final String METHODTYPE_UNKNOWN = "UNKNOWN";
    public static final String METHODTYPE_DEACTION = "DEACTION";
    public static final String METHODTYPE_FETCH = "FETCH";
    public static final String METHODTYPE_SELECT = "SELECT";
    public static final String METHODTYPE_FETCHTEMP = "FETCHTEMP";
    public static final String METHODTYPE_SELECTTEMP = "SELECTTEMP";
    public static final String METHODTYPE_WFACTION = "WFACTION";
    public static final String METHODTYPE_FILTERACTION = "FILTERACTION";
    public static final String METHODTYPE_CUSTOM = "CUSTOM";
    public static final String METHOD_FILTERGET = "FILTERGET";
    public static final String METHOD_FILTERGETDRAFT = "FILTERGETDRAFT";
    public static final String METHOD_FILTERCREATE = "FILTERCREATE";
    public static final String METHOD_FILTERUPDATE = "FILTERUPDATE";
    public static final String METHOD_FILTERSEARCH = "FILTERSEARCH";
    public static final String METHOD_FILTERREMOVE = "FILTERREMOVE";
    public static final String METHOD_FILTERFETCH = "FILTERFETCH";
    public static final String METHOD_WFSTART = "WFSTART";
    public static final String METHOD_WFSUBMIT = "WFSUBMIT";
    public static final String METHOD_WFCLOSE = "WFCLOSE";
    public static final String METHOD_WFRESTART = "WFRESTART";
    public static final String METHOD_WFROLLBACK = "WFROLLBACK";
    public static final String METHOD_WFMARKREAD = "WFMARKREAD";
    public static final String METHOD_WFGOTO = "WFGOTO";
    public static final String METHOD_WFREASSIGN = "WFREASSIGN";
    public static final String METHOD_WFSENDBACK = "WFSENDBACK";

    @Override
    public IPSAppDataEntity getPSAppDataEntity();

    public IPSDEServiceAPIMethod getPSDEServiceAPIMethod();

    @Override
    public String getCodeName();

    public String getCodeName2();

    public String getMethodType();

    public IPSPFXCodeObject getRender();

    public IPSSysPFPlugin getPSSysPFPlugin();

    public boolean isBuiltinMethod();

    public int getTempDataMode();

    public IPSAppDEMethodInput getPSAppDEMethodInput();

    public IPSAppDEMethodReturn getPSAppDEMethodReturn();

    public String getRequestPath();

    public String getRequestMethod();

    public String getRequestParamType();

    public String getRequestField();

    public boolean isNeedResourceKey();

    public boolean isNoServiceCodeName();

    public String[] getRequestFullPaths();
}

