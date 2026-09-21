/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicGroup;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5b9e\u4f53\u754c\u9762\u903b\u8f91\u7ec4\u6210\u5458\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSCtrlLogicGrpDetail", implement="PSDEUILogicGroupDetailImpl")
public interface IPSDEUILogicGroupDetail
extends IPSModelObject {
    public static final String TRIGGERTYPE_TIMER = "TIMER";
    public static final String TRIGGERTYPE_CTRLEVENT = "CTRLEVENT";
    public static final String TRIGGERTYPE_VIEWEVENT = "VIEWEVENT";
    public static final String TRIGGERTYPE_APPEVENT = "APPEVENT";
    public static final String TRIGGERTYPE_CUSTOM = "CUSTOM";
    public static final String TRIGGERTYPE_ITEMVISIBLE = "ITEMVISIBLE";
    public static final String TRIGGERTYPE_ITEMENABLE = "ITEMENABLE";
    public static final String TRIGGERTYPE_ITEMBLANK = "ITEMBLANK";
    public static final String TRIGGERTYPE_ITEMDYNACLASS = "ITEMDYNACLASS";
    public static final String TRIGGERTYPE_RENDER = "RENDER";
    public static final String TRIGGERTYPE_ATTRIBUTE = "ATTRIBUTE";
    public static final String LOGICTYPE_DEUILOGIC = "DEUILOGIC";
    public static final String LOGICTYPE_DEUIACTION = "DEUIACTION";
    public static final String LOGICTYPE_PFPLUGIN = "PFPLUGIN";
    public static final String LOGICTYPE_SYSVIEWLOGIC = "SYSVIEWLOGIC";
    public static final String LOGICTYPE_SCRIPT = "SCRIPT";
    public static final String LOGICTYPE_LAYOUTPANEL = "LAYOUTPANEL";

    public IPSDEUILogicGroup getPSDEUILogicGroup();

    public String getTriggerType();

    public String getCtrlName();

    public String getItemName();

    public String getAttrName();

    public int getOrderValue();

    public String getEventNames();

    public String getEventArg();

    public String getEventArg2();

    public String getLogicType();

    public String getPSSysViewLogicId();

    public String getPSDEUILogicId();

    public IPSDataEntity getPSDataEntity();

    public String getLogicTag();

    public String getLogicTag2();

    public String getScriptCode();

    public int getTimer();

    public String getPSDEUIActionId();

    public String getPSSysViewPanelId();

    public String getPSSysPFPluginId();
}

