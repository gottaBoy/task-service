/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Panel;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogic;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.Logic.IPSAppUILogic;
import SA.SRFDA.PS.Core.App.View.IPSAppViewLogic;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelItem;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogicLink;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogicNode;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogicParam;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelModel;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelObject;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u9762\u677f\u903b\u8f91\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysViewPanelLogic")
public interface IPSPanelLogic
extends IPSPanelObject,
IPSAppViewLogic {
    public static final String LOGICTRIGGER_PANELEVENT = "PANELEVENT";
    public static final String LOGICTRIGGER_CTRLEVENT = "CTRLEVENT";
    public static final String LOGICTRIGGER_CUSTOM = "CUSTOM";
    public static final String LOGICTRIGGER_TIMER = "TIMER";
    public static final String LOGICTYPE_DEUILOGIC = "DEUILOGIC";
    public static final String LOGICTYPE_APPVIEWENGINE = "APPVIEWENGINE";
    public static final String LOGICTYPE_APPVIEWUIACTION = "APPVIEWUIACTION";
    public static final String LOGICTYPE_SYSUILOGIC = "SYSUILOGIC";
    public static final String LOGICTYPE_UNKNOWN = "UNKNOWN";

    @Override
    public String getLogicTrigger();

    @Override
    public String getLogicType();

    @Override
    public String getCodeName();

    public String getLogicName();

    public IPSPanelLogicNode getStartPSPanelLogicNode();

    public Iterator<IPSPanelLogicNode> getPSPanelLogicNodes();

    public Iterator<IPSPanelLogicParam> getPSPanelLogicParams();

    public IPSPanelLogicParam getPSPanelLogicParam(String var1) throws Exception;

    public IPSPanelLogicNode getPSPanelLogicNode(String var1) throws Exception;

    public Iterator<IPSPanelLogicLink> getPSPanelLogicLinks();

    public IPSPanelItem getEventPSPanelItem();

    public String getEventName();

    public IPSPanelModel getEventPSPanelModel();

    @Override
    public IPSAppUILogic getPSAppUILogic();

    @Override
    public int getTimer();

    public String getPSPanelItemName();

    @Override
    public String getEventNames();

    @Override
    public String getEventArg();

    @Override
    public String getEventArg2();

    @Override
    public String getLogicParam();

    @Override
    public String getLogicParam2();

    @Override
    public IPSDataEntity getPSDataEntity();

    @Override
    public Object getOwner();

    @Override
    public IPSAppDataEntity getPSAppDataEntity();

    @Override
    public IPSAppDEUILogic getPSAppDEUILogic();
}

