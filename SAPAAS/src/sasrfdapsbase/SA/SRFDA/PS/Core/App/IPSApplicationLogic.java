/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogic;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.Logic.IPSAppUILogic;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.View.IPSUILogic;

@PSModelInterfaceMeta(title="\u5e94\u7528\u903b\u8f91\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", implement="PSApplicationLogicImpl")
public interface IPSApplicationLogic
extends IPSUILogic {
    public static final String TRIGGERTYPE_TIMER = "TIMER";
    public static final String TRIGGERTYPE_APPEVENT = "APPEVENT";
    public static final String TRIGGERTYPE_CUSTOM = "CUSTOM";
    public static final String LOGICTYPE_CUSTOM = "CUSTOM";
    public static final String LOGICTYPE_APPUILOGIC = "APPUILOGIC";
    public static final String LOGICTYPE_APPDEUILOGIC = "APPDEUILOGIC";
    public static final String LOGICTYPE_SCRIPT = "SCRIPT";

    public String getTriggerType();

    public String getEventNames();

    public String getEventArg();

    public String getEventArg2();

    @Override
    public String getLogicType();

    public IPSAppDataEntity getPSAppDataEntity();

    public IPSAppDEUILogic getPSAppDEUILogic();

    public IPSAppUILogic getPSAppUILogic();

    public String getScriptCode();

    @Override
    public String getName();

    public String getLogicTag();

    public int getTimer();
}

