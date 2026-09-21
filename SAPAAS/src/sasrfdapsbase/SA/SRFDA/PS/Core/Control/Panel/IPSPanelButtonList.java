/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Panel;

import SA.SRFDA.PS.Core.Control.Panel.IPSPanelButton;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelItem;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.View.IPSUIActionGroup;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u9762\u677f\u6309\u94ae\u5217\u8868\u9879\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", implement="PSSysPanelButtonListImpl")
@PSModelExtendMeta(extend="IPSPanelItem", typevalue={"BUTTONLIST"})
public interface IPSPanelButtonList
extends IPSPanelItem {
    public static final String BUTTONLISTTYPE_UIACTIONGROUP = "UIACTIONGROUP";
    public static final String BUTTONLISTTYPE_BUTTONS = "BUTTONS";

    public IPSUIActionGroup getPSUIActionGroup();

    public String getActionGroupExtractMode();

    public Iterator<? extends IPSPanelButton> getPSPanelButtons();

    public String getButtonListType();
}

