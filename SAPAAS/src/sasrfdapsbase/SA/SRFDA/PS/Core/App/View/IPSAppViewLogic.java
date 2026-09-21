/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUIAction;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogic;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.Logic.IPSAppUILogic;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewEngine;
import SA.SRFDA.PS.Core.App.View.IPSAppViewUIAction;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.View.IPSUILogic;
import SA.SRFDA.PS.Core.View.IPSViewLogic;

@PSModelInterfaceMeta(title="\u5e94\u7528\u89c6\u56fe\u903b\u8f91\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", implement="PSAppViewLogicImpl", model="PSDEViewLogic")
public interface IPSAppViewLogic
extends IPSUILogic {
    public static final String LOGICTRIGGER_TIMER = "TIMER";
    public static final String LOGICTRIGGER_VIEWEVENT = "VIEWEVENT";
    public static final String LOGICTRIGGER_CTRLEVENT = "CTRLEVENT";
    public static final String LOGICTRIGGER_CUSTOM = "CUSTOM";
    public static final String LOGICTRIGGER_ITEMVISIBLE = "ITEMVISIBLE";
    public static final String LOGICTRIGGER_ITEMENABLE = "ITEMENABLE";
    public static final String LOGICTRIGGER_ITEMBLANK = "ITEMBLANK";
    public static final String LOGICTRIGGER_ITEMDYNACLASS = "ITEMDYNACLASS";
    public static final String LOGICTRIGGER_RENDER = "RENDER";
    public static final String LOGICTRIGGER_ATTRIBUTE = "ATTRIBUTE";
    public static final String LOGICTYPE_APPVIEWLOGIC = "APPVIEWLOGIC";
    public static final String LOGICTYPE_DEUILOGIC = "DEUILOGIC";
    public static final String LOGICTYPE_APPVIEWENGINE = "APPVIEWENGINE";
    public static final String LOGICTYPE_APPVIEWUIACTION = "APPVIEWUIACTION";
    public static final String LOGICTYPE_SYSUILOGIC = "SYSUILOGIC";
    public static final String LOGICTYPE_UNKNOWN = "UNKNOWN";
    public static final String LOGICTYPE_SCRIPT = "SCRIPT";
    public static final String LOGICTYPE_APPDEUILOGIC = "APPDEUILOGIC";
    public static final String LOGICTYPE_APPDEUIACTION = "APPDEUIACTION";
    public static final String LOGICTYPE_APPUILOGIC = "APPUILOGIC";
    public static final String LOGICTYPE_PFPLUGIN = "PFPLUGIN";
    public static final String LOGICTYPE_LAYOUTPANEL = "LAYOUTPANEL";

    public String getLogicTrigger();

    public IPSViewLogic getPSViewLogic();

    public IPSAppUILogic getPSAppUILogic();

    public IPSAppViewLogic getPSAppViewLogic();

    public int getTimer();

    public String getPSViewCtrlName();

    public String getEventNames();

    public String getEventArg();

    public String getEventArg2();

    public String getAttrName();

    public String getItemName();

    public IPSAppView getPSAppView();

    public String getLogicParam();

    public String getLogicParam2();

    public IPSDataEntity getPSDataEntity();

    @Override
    public String getLogicType();

    public IPSAppViewEngine getPSAppViewEngine();

    public IPSAppViewUIAction getPSAppViewUIAction();

    public boolean isBuiltinLogic();

    public Object getOwner();

    public IPSControlContainer getPSControlContainer();

    public IPSAppDataEntity getPSAppDataEntity();

    public IPSAppDEUILogic getPSAppDEUILogic();

    public IPSAppDEUIAction getPSAppDEUIAction();

    public String getScriptCode();

    public String getPSSysViewPanelId();

    public String getPSSysPFPluginId();

    public IPSSysPFPlugin getPSSysPFPlugin();
}

