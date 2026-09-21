/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Panel;

import SA.SRFDA.PS.Core.App.View.IPSUIActionItem;
import SA.SRFDA.PS.Core.Control.IPSButtonBase;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelItem;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIAction;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.View.IPSUIAction;
import SA.SRFDA.PS.Core.WF.UIAction.IPSWFUIAction;

@PSModelInterfaceMeta(title="\u9762\u677f\u6309\u94ae\u9879\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", implement="PSSysPanelButtonImpl")
@PSModelExtendMeta(extend="IPSPanelItem", typevalue={"BUTTON"})
public interface IPSPanelButton
extends IPSPanelItem,
IPSUIActionItem,
IPSButtonBase {
    public static final String ACTIONTYPE_CUSTOM = "CUSTOM";
    public static final String ACTIONTYPE_UIACTION = "UIACTION";

    public String getActionType();

    public String getPSUIActionId();

    @Override
    public IPSUIAction getPSUIAction();

    public IPSDEUIAction getPSDEUIAction();

    public IPSWFUIAction getPSWFUIAction();

    @Override
    public String getTooltip();

    public String getCaptionItemName();

    @Override
    public String getUIActionTarget();

    public IPSUIAction getInlinePSUIAction();
}

