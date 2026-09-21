/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.model.IPSModelJsonExporter2
 *  net.ibizsys.model.control.toolbar.IPSDECMGroupItem
 *  net.ibizsys.model.control.toolbar.IPSDEContextMenuItem
 *  net.ibizsys.model.control.toolbar.IPSDETBGroupItem
 *  net.ibizsys.model.control.toolbar.IPSDETBSeperatorItem
 *  net.ibizsys.model.control.toolbar.IPSDETBUIActionItem
 *  net.ibizsys.model.control.toolbar.IPSDEToolbarItem
 *  net.ibizsys.paas.util.JsonNodeHelper
 */
package net.ibizsys.model.control.toolbar;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.model.IPSModelJsonExporter2;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.control.toolbar.IPSDECMGroupItem;
import net.ibizsys.model.control.toolbar.IPSDEContextMenuItem;
import net.ibizsys.model.control.toolbar.IPSDETBGroupItem;
import net.ibizsys.model.control.toolbar.IPSDETBSeperatorItem;
import net.ibizsys.model.control.toolbar.IPSDETBUIActionItem;
import net.ibizsys.model.control.toolbar.IPSDEToolbarItem;
import net.ibizsys.model.control.toolbar.IPSDEToolbarItemRuntime;
import net.ibizsys.model.control.toolbar.PSDEToolbarItemImpl;
import net.ibizsys.model.entity.PSDEToolbarItem;
import net.ibizsys.paas.util.JsonNodeHelper;

public class PSDETBGroupItemImpl
extends PSDEToolbarItemImpl
implements IPSDETBGroupItem,
IPSDECMGroupItem {
    protected ArrayList<IPSDEToolbarItem> psDEToolbarItemList = new ArrayList();
    protected ArrayList<IPSDEContextMenuItem> psDEContextMenuItemList = new ArrayList();

    @Override
    protected void onPreparePSDEToolbarItems() throws Exception {
        this.psDEToolbarItemList.clear();
        this.psDEContextMenuItemList.clear();
        ArrayList<PSDEToolbarItem> psDEToolbarItemList = this.getPSDEToolbarItemData().getChildPSDEToolbarItems(false);
        if (psDEToolbarItemList == null) {
            return;
        }
        boolean bLastSeperator = true;
        for (PSDEToolbarItem psDEToolbarItem : psDEToolbarItemList) {
            IPSDETBUIActionItem iPSDETBUIActionItem;
            IPSDEToolbarItem iPSDEToolbarItem = this.getPSModelStorageContext().createPSDEToolbarItem(this.getPSDEToolbar(), this, psDEToolbarItem);
            if (!iPSDEToolbarItem.isValid()) continue;
            if (iPSDEToolbarItem instanceof IPSDETBSeperatorItem) {
                if (bLastSeperator) continue;
                bLastSeperator = true;
            } else {
                bLastSeperator = false;
            }
            if (iPSDEToolbarItem instanceof IPSDETBUIActionItem && (iPSDETBUIActionItem = (IPSDETBUIActionItem)iPSDEToolbarItem).getPSDEUIAction().isUIActionGroup((Object)iPSDETBUIActionItem)) {
                Iterator childPSDEToolbarItems = iPSDETBUIActionItem.getPSDEToolbarItems();
                if (childPSDEToolbarItems == null) continue;
                while (childPSDEToolbarItems.hasNext()) {
                    IPSDEToolbarItem childPSDEToolbarItem = (IPSDEToolbarItem)childPSDEToolbarItems.next();
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

    @PSModelRTMeta(description="\u5b50\u9879\u96c6\u5408", modeltype="SA.SRFDA.PS.Core.Control.Toolbar.IPSDEToolbarItem", hideempty2=true)
    public Iterator<IPSDEToolbarItem> getPSDEToolbarItems() throws Exception {
        return this.psDEToolbarItemList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u662f\u5426\u6709\u6548")
    public boolean isValid() {
        return this.psDEToolbarItemList.size() > 0;
    }

    public Iterator<IPSDEContextMenuItem> getPSDEContextMenuItems() throws Exception {
        return this.psDEContextMenuItemList.iterator();
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
            ((IPSDEToolbarItemRuntime)iPSDEToolbarItem).fillPSDEToolbarItems(psDEToolbarItemList);
        }
    }

    @Override
    protected void onFillJsonObject(ObjectNode objectNode) throws Exception {
        super.onFillJsonObject(objectNode);
        ArrayList itemList = new ArrayList();
        Iterator<IPSDEToolbarItem> psDEToolbarItems = this.getPSDEToolbarItems();
        while (psDEToolbarItems.hasNext()) {
            IPSDEToolbarItem iPSDEToolbarItem = psDEToolbarItems.next();
            ((IPSModelJsonExporter2)iPSDEToolbarItem).toJsonObjects(itemList);
        }
        JsonNodeHelper.put((ObjectNode)objectNode, (String)"items", itemList);
    }
}

