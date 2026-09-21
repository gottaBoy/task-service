/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Control.Toolbar;

import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.Menu.IPSContextMenuParam;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDEContextMenu;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDEContextMenuItem;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDEToolbarItem;
import SA.SRFDA.PS.Core.Control.Toolbar.PSDEToolbarImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Iterator;

@PSModelImplementMeta(implement="IPSControl", typevalues={"CONTEXTMENU"})
public class PSDEContextMenuImpl
extends PSDEToolbarImpl
implements IPSDEContextMenu {
    protected ArrayList<IPSDEContextMenuItem> psDEContextMenuItemList = new ArrayList();
    private Object objOwner = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSControlContainer iPSControlContainer, String strName, IPSControlParam iPSControlParam) throws Exception {
        if (iPSControlParam instanceof IPSContextMenuParam) {
            this.objOwner = ((IPSContextMenuParam)iPSControlParam).getOwner();
        }
        super.init(iDAGlobalHelper, iPSControlContainer, strName, iPSControlParam);
    }

    @Override
    protected void onPreparePSDEToolbarItems() throws Exception {
        this.psDEContextMenuItemList.clear();
        super.onPreparePSDEToolbarItems();
        for (IPSDEToolbarItem iPSDEToolbarItem : this.psDEToolbarItemList) {
            this.psDEContextMenuItemList.add((IPSDEContextMenuItem)iPSDEToolbarItem);
        }
    }

    @Override
    @Deprecated
    public Iterator<IPSDEContextMenuItem> getPSContextMenuItems() throws Exception {
        return this.psDEContextMenuItemList.iterator();
    }

    @Override
    public Iterator<IPSDEContextMenuItem> getPSDEContextMenuItems() throws Exception {
        return this.psDEContextMenuItemList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u83dc\u5355\u6240\u6709\u8005", outputdoc="false", ignorert=3)
    public Object getOwner() {
        return this.objOwner;
    }

    @Override
    protected String onGetControlType() {
        return "CONTEXTMENU";
    }

    @Override
    protected boolean isExportModelAlways() {
        return true;
    }
}

