/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUIAction;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogic;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.Logic.IPSAppUILogic;
import SA.SRFDA.PS.Core.App.View.IPSAppViewEngine;
import SA.SRFDA.PS.Core.App.View.IPSAppViewLogic;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.View.IPSUILogic;

@PSModelInterfaceMeta(title="\u754c\u9762\u90e8\u4ef6\u903b\u8f91\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", implement="PSControlLogicProxy")
public interface IPSControlLogic
extends IPSUILogic,
IPSModelObject {
    public static final String TRIGGERTYPE_TIMER = "TIMER";
    public static final String TRIGGERTYPE_CTRLEVENT = "CTRLEVENT";
    public static final String TRIGGERTYPE_CUSTOM = "CUSTOM";
    public static final String LOGICTYPE_APPVIEWLOGIC = "APPVIEWLOGIC";
    public static final String LOGICTYPE_APPVIEWENGINE = "APPVIEWENGINE";
    public static final String LOGICTYPE_CUSTOM = "CUSTOM";
    public static final String LOGICTYPE_APPUILOGIC = "APPUILOGIC";
    public static final String LOGICTYPE_APPDEUILOGIC = "APPDEUILOGIC";
    public static final String LOGICTYPE_APPDEUIACTION = "APPDEUIACTION";
    public static final String LOGICTYPE_SCRIPT = "SCRIPT";

    public String getTriggerType();

    public String getEventNames();

    public String getEventArg();

    public String getEventArg2();

    @Override
    public String getLogicType();

    public IPSAppViewEngine getPSAppViewEngine();

    public IPSAppViewLogic getPSAppViewLogic();

    public IPSAppDataEntity getPSAppDataEntity();

    public IPSAppDEUILogic getPSAppDEUILogic();

    public IPSAppDEUIAction getPSAppDEUIAction();

    public IPSAppUILogic getPSAppUILogic();

    public String getScriptCode();

    @Override
    public String getName();

    public String getLogicTag();

    public int getTimer();

    public String getItemName();

    public String getAttrName();
}

