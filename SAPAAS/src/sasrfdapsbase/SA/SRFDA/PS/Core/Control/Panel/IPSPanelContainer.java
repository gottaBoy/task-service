/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Panel;

import SA.SRFDA.PS.Core.Control.Panel.IPSPanelDataRegion;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelItem;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.View.IPSUIActionGroup;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u9762\u677f\u5bb9\u5668\u9879\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysViewPanelItem", implement="PSSysPanelContainerImpl")
@PSModelExtendMeta(extend="IPSPanelItem", typevalue={"CONTAINER"})
public interface IPSPanelContainer
extends IPSPanelItem,
IPSPanelDataRegion {
    public static final int TITLEBARCLOSEMODE_NONE = 0;
    public static final int TITLEBARCLOSEMODE_OPENDEFAULT = 1;
    public static final int TITLEBARCLOSEMODE_CLOSEDEFAULT = 2;

    public String getLayoutMode();

    public double[] getColumnWidths();

    public int getItemRowId(IPSPanelItem var1) throws Exception;

    public int getItemRowSpan(IPSPanelItem var1) throws Exception;

    public int getItemColId(IPSPanelItem var1) throws Exception;

    public int getItemColSpan(IPSPanelItem var1) throws Exception;

    public Iterator<IPSPanelItem> getPSPanelItems();

    public int getPSPanelItemCount();

    public IPSPanelItem getPSPanelItem(int var1) throws Exception;

    public int getLabelColSpan();

    public int getCtrlColSpan();

    public int getColumnCount();

    public int getChildColXS();

    public int getChildColSM();

    public int getChildColMD();

    public int getChildColLG();

    public String getSubCaption();

    public int getTitleBarCloseMode();

    public String getFlexDir();

    public String getFlexAlign();

    public String getFlexVAlign();

    public String getCaptionItemName();

    public String getPredefinedType();

    public IPSUIActionGroup getPSUIActionGroup();

    public String getActionGroupExtractMode();
}

