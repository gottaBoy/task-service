/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Toolbar;

import SA.SRFDA.PS.Core.Control.Toolbar.IPSDECMGroupItem;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDEContextMenuItem;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDETBGroupItem;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDETBSeperatorItem;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDETBUIActionItem;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDEToolbarItem;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSToolbarItemType;
import SA.SRFDA.PS.Core.Control.Toolbar.PSDEToolbarItemImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.View.IPSUIActionGroup;
import SA.SRFDA.PS.Data.PSDEToolbarItem;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Iterator;

public class PSDETBGroupItemImpl
extends PSDEToolbarItemImpl
implements IPSDETBGroupItem,
IPSDECMGroupItem {
    protected ArrayList<IPSDEToolbarItem> psDEToolbarItemList = new ArrayList();
    protected ArrayList<IPSDEContextMenuItem> psDEContextMenuItemList = new ArrayList();
    private int nActionLevel = 100;
    private IPSUIActionGroup iPSUIActionGroup = null;
    private String strGroupExtractMode = null;

    @Override
    protected void onInit() throws Exception {
        if (!this.psDEToolbarItem.isACTIONLEVELNull()) {
            this.nActionLevel = this.psDEToolbarItem.getACTIONLEVEL();
        }
        super.onInit();
    }

    @Override
    protected void onPreparePSDEToolbarItems() throws Exception {
        if (!StringHelper.IsNullOrEmpty((String)this.psDEToolbarItem.getPSDEUAGROUPID())) {
            if (this.iPSUIActionGroup == null) {
                if (this.getOwnedPSControl().getPSAppDataEntity() != null) {
                    this.iPSUIActionGroup = this.getOwnedPSControl().getPSAppDataEntity().getPSAppDEUIActionGroup(this.psDEToolbarItem.getPSDEUAGROUPID(), true, this.getOwnedPSControl());
                }
                if (this.iPSUIActionGroup == null) {
                    this.iPSUIActionGroup = this.getOwnedPSControl().getPSDataEntity().getPSDEUIActionGroup(this.psDEToolbarItem.getPSDEUAGROUPID());
                }
            }
            this.strGroupExtractMode = this.psDEToolbarItem.getGROUPEXTRACTMODE();
            if (StringHelper.IsNullOrEmpty((String)this.strGroupExtractMode)) {
                this.strGroupExtractMode = "ITEM";
            }
        } else {
            this.psDEToolbarItemList.clear();
            this.psDEContextMenuItemList.clear();
            ArrayList<PSDEToolbarItem> psDEToolbarItemList = this.getPSDEToolbarItemData().getChildPSDEToolbarItems(false);
            if (psDEToolbarItemList == null) {
                return;
            }
            boolean bLastSeperator = true;
            for (PSDEToolbarItem psDEToolbarItem : psDEToolbarItemList) {
                IPSDETBUIActionItem iPSDETBUIActionItem;
                IPSToolbarItemType iPSToolbarItemType = this.getPSModelStorage().getPSToolbarItemType(psDEToolbarItem.getTBITEMTYPE());
                IPSDEToolbarItem iPSDEToolbarItem = iPSToolbarItemType.createPSDEToolbarItem(psDEToolbarItem);
                iPSDEToolbarItem.init(this.getDAGlobalHelper(), this.getPSDEToolbar(), this, psDEToolbarItem);
                if (!iPSDEToolbarItem.isValid()) continue;
                if (iPSDEToolbarItem instanceof IPSDETBSeperatorItem) {
                    if (bLastSeperator) continue;
                    bLastSeperator = true;
                } else {
                    bLastSeperator = false;
                }
                if (iPSDEToolbarItem instanceof IPSDETBUIActionItem && (iPSDETBUIActionItem = (IPSDETBUIActionItem)iPSDEToolbarItem).getPSDEUIAction().isUIActionGroup(iPSDETBUIActionItem)) {
                    Iterator<IPSDEToolbarItem> childPSDEToolbarItems = iPSDETBUIActionItem.getPSDEToolbarItems();
                    if (childPSDEToolbarItems == null) continue;
                    while (childPSDEToolbarItems.hasNext()) {
                        IPSDEToolbarItem childPSDEToolbarItem = childPSDEToolbarItems.next();
                        if (childPSDEToolbarItem instanceof IPSDETBSeperatorItem) {
                            if (bLastSeperator) continue;
                            bLastSeperator = true;
                        } else {
                            bLastSeperator = false;
                        }
                        this.psDEToolbarItemList.add(childPSDEToolbarItem);
                    }
                    continue;
                }
                this.psDEToolbarItemList.add(iPSDEToolbarItem);
            }
            if (bLastSeperator && this.psDEToolbarItemList.size() > 0) {
                this.psDEToolbarItemList.remove(this.psDEToolbarItemList.size() - 1);
            }
            for (IPSDEToolbarItem iPSDEToolbarItem : this.psDEToolbarItemList) {
                this.psDEContextMenuItemList.add((IPSDEContextMenuItem)iPSDEToolbarItem);
            }
        }
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u9879\u96c6\u5408", modeltype="SA.SRFDA.PS.Core.Control.Toolbar.IPSDEToolbarItemAll", hideempty2=true, child=true, outputdoc="false")
    public Iterator<IPSDEToolbarItem> getPSDEToolbarItems() throws Exception {
        return this.psDEToolbarItemList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528", ignoredumpvalues="true")
    public boolean isValid() {
        return this.getPSUIActionGroup() != null || this.psDEToolbarItemList.size() > 0;
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u9879\u96c6\u5408", modeltype="SA.SRFDA.PS.Core.Control.Toolbar.IPSDEContextMenuItemAll", hideempty2=true, child=true, outputdoc="false")
    public Iterator<IPSDEContextMenuItem> getPSDEContextMenuItems() throws Exception {
        return this.psDEContextMenuItemList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u884c\u4e3a\u7ea7\u522b", codelist="UIActionLevel", ignoredumpvalues="100", fields={"ACTIONLEVEL"})
    public int getActionLevel() {
        return this.nActionLevel;
    }

    @Override
    @PSModelRTMeta(description="\u8fb9\u6846\u6837\u5f0f", codelist="BorderStyle", fields={"BORDERSTYLE"})
    public String getBorderStyle() {
        return this.psDEToolbarItem.getBORDERSTYLE();
    }

    @Override
    @PSModelRTMeta(description="\u6309\u94ae\u6837\u5f0f", codelist="ButtonStyle", fields={"ITEMSTYLE"})
    public String getButtonStyle() {
        return this.getItemStyle();
    }

    public void addPSDEToolbarItem(IPSDEToolbarItem iPSDEToolbarItem) {
        this.psDEToolbarItemList.add(iPSDEToolbarItem);
        if (iPSDEToolbarItem instanceof IPSDEContextMenuItem) {
            this.psDEContextMenuItemList.add((IPSDEContextMenuItem)iPSDEToolbarItem);
        }
    }

    @Override
    public void fillPSDEToolbarItems(ArrayList<IPSDEToolbarItem> psDEToolbarItemList) {
        super.fillPSDEToolbarItems(psDEToolbarItemList);
        for (IPSDEToolbarItem iPSDEToolbarItem : this.psDEToolbarItemList) {
            iPSDEToolbarItem.fillPSDEToolbarItems(psDEToolbarItemList);
        }
    }

    @Override
    public String getModelType() {
        return "PSDETBITEM";
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u7ec4\u5bf9\u8c61", child=true, fields={"PSDEUAGROUPID"})
    public IPSUIActionGroup getPSUIActionGroup() {
        return this.iPSUIActionGroup;
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u7ec4\u5c55\u5f00\u6a21\u5f0f", codelist="UGExtractMode", fields={"GROUPEXTRACTMODE"})
    public String getGroupExtractMode() {
        return this.strGroupExtractMode;
    }
}

