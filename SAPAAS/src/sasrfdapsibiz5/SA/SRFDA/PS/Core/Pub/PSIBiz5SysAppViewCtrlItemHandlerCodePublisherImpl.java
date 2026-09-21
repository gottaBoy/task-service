/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.App.View.IPSAppView
 *  SA.SRFDA.PS.Core.Control.Form.IPSDEForm
 *  SA.SRFDA.PS.Core.Control.Form.IPSDEFormItem
 *  SA.SRFDA.PS.Core.Control.Form.IPSDEFormItemUpdate
 *  SA.SRFDA.PS.Core.Control.Grid.IPSDEGrid
 *  SA.SRFDA.PS.Core.Control.Grid.IPSDEGridEditItem
 *  SA.SRFDA.PS.Core.Control.Grid.IPSDEGridEditItemUpdate
 *  SA.SRFDA.PS.Core.Control.IPSControl
 *  SA.SRFDA.PS.Data.PSSysSFCode
 *  SA.SRFramework.Utility.Helper
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.Form.IPSDEForm;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItem;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItemUpdate;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGrid;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridEditItem;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridEditItemUpdate;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysAppViewCodePublisherImpl;
import SA.SRFDA.PS.Data.PSSysSFCode;
import SA.SRFramework.Utility.Helper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;

public class PSIBiz5SysAppViewCtrlItemHandlerCodePublisherImpl
extends PSIBiz5SysAppViewCodePublisherImpl {
    @Override
    protected void onGenerateAppViewCode(IPSAppView iPSAppView, ArrayList<PSSysSFCode> list) throws Exception {
        for (IPSControl iPSControl : iPSAppView.getAllPSControls()) {
            if (!iPSControl.getPSControlType().isAjaxControl()) continue;
            this.generateControlCode(iPSControl, list);
        }
    }

    protected void generateControlCode(IPSControl iPSControl, ArrayList<PSSysSFCode> list) throws Exception {
        if (iPSControl instanceof IPSDEForm) {
            IPSDEForm iPSDEForm = (IPSDEForm)iPSControl;
            Iterator psDEFormItems = iPSDEForm.getPSDEFormItems();
            while (psDEFormItems.hasNext()) {
                IPSDEFormItem iPSDEFormItem = (IPSDEFormItem)psDEFormItems.next();
                if (StringHelper.isNullOrEmpty((String)iPSDEFormItem.getItemHandlerType())) continue;
                this.generateFormItemCode(iPSDEFormItem, list);
            }
            Iterator psDEFormItemUpdates = iPSDEForm.getPSDEFormItemUpdates();
            if (psDEFormItemUpdates != null) {
                while (psDEFormItemUpdates.hasNext()) {
                    IPSDEFormItemUpdate iPSDEFormItemUpdate = (IPSDEFormItemUpdate)psDEFormItemUpdates.next();
                    this.generateFormItemUpdateCode(iPSDEFormItemUpdate, list);
                }
            }
            return;
        }
        if (iPSControl instanceof IPSDEGrid) {
            Iterator psDEGridEditItemUpdates;
            IPSDEGrid iPSDEGrid = (IPSDEGrid)iPSControl;
            Iterator psDEGridEditItems = iPSDEGrid.getPSDEGridEditItems();
            if (psDEGridEditItems != null) {
                while (psDEGridEditItems.hasNext()) {
                    IPSDEGridEditItem iPSDEGridEditItem = (IPSDEGridEditItem)psDEGridEditItems.next();
                    if (StringHelper.isNullOrEmpty((String)iPSDEGridEditItem.getItemHandlerType())) continue;
                    this.generateGridEditItemCode(iPSDEGridEditItem, list);
                }
            }
            if ((psDEGridEditItemUpdates = iPSDEGrid.getPSDEGridEditItemUpdates()) != null) {
                while (psDEGridEditItemUpdates.hasNext()) {
                    IPSDEGridEditItemUpdate iPSDEGridEditItemUpdate = (IPSDEGridEditItemUpdate)psDEGridEditItemUpdates.next();
                    this.generateGridEditItemUpdateCode(iPSDEGridEditItemUpdate, list);
                }
            }
            return;
        }
    }

    protected void generateFormItemCode(IPSDEFormItem iPSDEFormItem, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap<String, IPSDEForm> params = new HashMap<String, IPSDEForm>();
        params.put("ctrl", iPSDEFormItem.getPSDEForm());
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(true, list != null);
        psSysSFCode.setSYSOBJID(Helper.GenUniqueId((String)iPSDEFormItem.getPSDEForm().getPSAppView().getId(), (String)iPSDEFormItem.getPSDEForm().getId(), (String)iPSDEFormItem.getName()));
        psSysSFCode.setSYSOBJNAME(iPSDEFormItem.getName());
        this.savePSSysSFCode(iPSDEFormItem, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }

    protected void generateFormItemUpdateCode(IPSDEFormItemUpdate iPSDEFormItemUpdate, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap<String, IPSDEForm> params = new HashMap<String, IPSDEForm>();
        params.put("ctrl", iPSDEFormItemUpdate.getPSDEForm());
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(true, list != null);
        psSysSFCode.setSYSOBJID(Helper.GenUniqueId((String)iPSDEFormItemUpdate.getPSDEForm().getId(), (String)iPSDEFormItemUpdate.getCodeName()));
        psSysSFCode.setSYSOBJNAME(iPSDEFormItemUpdate.getName());
        this.savePSSysSFCode(iPSDEFormItemUpdate, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }

    protected void generateGridEditItemCode(IPSDEGridEditItem iPSDEGridEditItem, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap<String, IPSDEGrid> params = new HashMap<String, IPSDEGrid>();
        params.put("ctrl", iPSDEGridEditItem.getPSDEGrid());
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(true, list != null);
        psSysSFCode.setSYSOBJID(Helper.GenUniqueId((String)iPSDEGridEditItem.getPSDEGrid().getId(), (String)iPSDEGridEditItem.getName()));
        psSysSFCode.setSYSOBJNAME(iPSDEGridEditItem.getName());
        this.savePSSysSFCode(iPSDEGridEditItem, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }

    protected void generateGridEditItemUpdateCode(IPSDEGridEditItemUpdate iPSDEGridEditItemUpdate, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap<String, IPSDEGrid> params = new HashMap<String, IPSDEGrid>();
        params.put("ctrl", iPSDEGridEditItemUpdate.getPSDEGrid());
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(true, list != null);
        psSysSFCode.setSYSOBJID(Helper.GenUniqueId((String)iPSDEGridEditItemUpdate.getPSDEGrid().getId(), (String)iPSDEGridEditItemUpdate.getCodeName()));
        psSysSFCode.setSYSOBJNAME(iPSDEGridEditItemUpdate.getName());
        this.savePSSysSFCode(iPSDEGridEditItemUpdate, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }
}

