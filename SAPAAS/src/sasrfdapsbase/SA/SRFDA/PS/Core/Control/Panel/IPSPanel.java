/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.control.panel.IPanel
 */
package SA.SRFDA.PS.Core.Control.Panel;

import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlAction;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.Layout.IPSLayoutContainer;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelField;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelItem;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelModel;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import java.util.Iterator;
import net.ibizsys.paas.control.panel.IPanel;

@PSModelInterfaceMeta(title="\u9762\u677f\u90e8\u4ef6\u6a21\u578b\u5bf9\u8c61\u57fa\u7840\u63a5\u53e3", model="PSSysViewPanel")
public interface IPSPanel
extends IPSControl,
IPSControlContainer,
IPanel,
IPSLayoutContainer {
    public static final int GETDATAMODE_INPUTDATA = 0;
    public static final int GETDATAMODE_NOINPUTDATA = 1;
    public static final int GETDATAMODE_ALWAYS = 2;
    public static final int GETDATAMODE_APPGLOBALPARAM = 3;
    public static final int GETDATAMODE_ROUTEVIEWSESSIONPARAM = 4;
    public static final int GETDATAMODE_VIEWSESSIONPARAM = 5;

    public double getPanelWidth();

    public String getLayoutMode();

    public Iterator<? extends IPSPanelItem> getRootPSPanelItems();

    public Iterator<? extends IPSPanelField> getAllPSPanelFields();

    @Override
    public String getCodeName();

    public IPSPanelField getPSPanelField(String var1) throws Exception;

    public IPSPanelField getPSPanelField(String var1, boolean var2) throws Exception;

    public Iterator<? extends IPSPanelItem> getAllPSPanelItems();

    public IPSPanelItem getPSPanelItem(String var1, boolean var2) throws Exception;

    public IPSPanelItem getPSPanelItem(String var1) throws Exception;

    public String getPanelStyle();

    public boolean isMobilePanel();

    public boolean isLayoutPanel();

    public Iterator<? extends IPSPanelModel> getPSPanelModels();

    public IPSPanelModel getPSPanelModel(String var1) throws Exception;

    public IPSPanelModel getPSPanelModel(String var1, boolean var2) throws Exception;

    public IPSControlAction getGetPSControlAction();

    public int getDataMode();

    public int getDataTimer();

    public String getDataName();
}

