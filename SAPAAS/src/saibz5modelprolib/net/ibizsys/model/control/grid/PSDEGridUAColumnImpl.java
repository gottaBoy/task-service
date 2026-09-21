/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.control.grid.IPSDEGridDataItem
 *  net.ibizsys.model.control.grid.IPSDEGridUAColumn
 *  net.ibizsys.model.dataentity.uiaction.IPSDEUIAction
 *  net.ibizsys.model.dataentity.uiaction.IPSDEUIActionGroup
 *  net.ibizsys.model.view.IPSUIAction
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.control.grid;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.app.view.IPSAppViewRuntime;
import net.ibizsys.model.control.grid.IPSDEGridDataItem;
import net.ibizsys.model.control.grid.IPSDEGridUAColumn;
import net.ibizsys.model.control.grid.PSDEGridColumnImpl;
import net.ibizsys.model.dataentity.uiaction.IPSDEUIAction;
import net.ibizsys.model.dataentity.uiaction.IPSDEUIActionGroup;
import net.ibizsys.model.dataentity.uiaction.IPSDEUIActionRuntime;
import net.ibizsys.model.view.IPSUIAction;
import net.ibizsys.paas.util.StringHelper;

public class PSDEGridUAColumnImpl
extends PSDEGridColumnImpl
implements IPSDEGridUAColumn {
    private IPSDEUIActionGroup iPSDEUIActionGroup = null;
    private ArrayList<IPSDEGridDataItem> psDEGridDataItemList = new ArrayList();

    @Override
    protected void onInit() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.getAlign())) {
            this.setAlign("RIGHT");
        }
        this.setEnableSort(false);
        if (!StringHelper.isNullOrEmpty((String)this.psDEGridColumn.getPSDEUAGROUPID())) {
            this.iPSDEUIActionGroup = this.getPSDEGrid().getPSDataEntity().getPSDEUIActionGroup(this.psDEGridColumn.getPSDEUAGROUPID());
            Iterator psDEUIActions = this.iPSDEUIActionGroup.getPSDEUIActions();
            if (psDEUIActions != null) {
                while (psDEUIActions.hasNext()) {
                    IPSDEUIAction iPSDEUIAction = (IPSDEUIAction)psDEUIActions.next();
                    ((IPSAppViewRuntime)this.getPSDEGrid().getPSAppView()).registerPSUIAction((IPSUIAction)iPSDEUIAction);
                }
            }
        }
        super.onInit();
    }

    public IPSDEUIActionGroup getPSDEUIActionGroup() {
        return this.iPSDEUIActionGroup;
    }

    @Override
    protected void onFillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        if (this.getPSDEUIActionGroup() == null) {
            return;
        }
        Iterator psDEUIActions = this.getPSDEUIActionGroup().getPSDEUIActions();
        if (psDEUIActions != null) {
            while (psDEUIActions.hasNext()) {
                IPSDEUIAction iPSDEUIAction = (IPSDEUIAction)psDEUIActions.next();
                IPSAppView refPSAppView = ((IPSDEUIActionRuntime)iPSDEUIAction).getFrontPSAppView(this);
                if (refPSAppView == null) continue;
                relatedAppViewList.add(refPSAppView);
            }
        }
    }

    @Override
    public Iterator<IPSDEGridDataItem> getPSDEGridDataItems() {
        if (this.psDEGridDataItemList.size() == 0) {
            return null;
        }
        return this.psDEGridDataItemList.iterator();
    }

    @Override
    public String getDataItemName() {
        return "srfkey";
    }
}

