/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.App.IPSApplication
 *  SA.SRFDA.PS.Core.App.View.IPSAppDEView
 *  SA.SRFDA.PS.Core.App.View.IPSAppView
 *  SA.SRFDA.PS.Core.Control.Form.IPSDEForm
 *  SA.SRFDA.PS.Core.Control.Form.IPSDEFormItem
 *  SA.SRFDA.PS.Core.Control.Form.IPSDEFormItemUpdate
 *  SA.SRFDA.PS.Core.Control.Grid.IPSDEGrid
 *  SA.SRFDA.PS.Core.Control.Grid.IPSDEGridEditItem
 *  SA.SRFDA.PS.Core.Control.Grid.IPSDEGridEditItemUpdate
 *  SA.SRFDA.PS.Core.Control.IPSControl
 *  SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult
 *  SA.SRFDA.PS.Data.PSSysSFCode
 *  SA.SRFramework.Utility.Helper
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.View.IPSAppDEView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.Form.IPSDEForm;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItem;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItemUpdate;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGrid;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridEditItem;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridEditItemUpdate;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysAppViewCodePublisherImpl;
import SA.SRFDA.PS.Data.PSSysSFCode;
import SA.SRFramework.Utility.Helper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;

public class PSIBiz5SysAppViewCtrlModelItemHandlerBaseCodePublisherImpl
extends PSIBiz5SysAppViewCodePublisherImpl {
    public static final String CODETEMPL_FORMITEM = "FORMITEM";
    public static final String CODETEMPL_FORMITEMUPDATE = "FORMITEMUPDATE";
    public static final String CODETEMPL_GRIDEDITITEM = "GRIDEDITITEM";
    public static final String CODETEMPL_GRIDEDITITEMUPDATE = "GRIDEDITITEMUPDATE";
    protected HashMap<String, String> appViewCtrlMap = new HashMap();

    @Override
    protected void onGenerateCode(IPSApplication iPSApplication, ArrayList<PSSysSFCode> list) throws Exception {
        this.appViewCtrlMap.clear();
        super.onGenerateCode(iPSApplication, list);
        this.appViewCtrlMap.clear();
    }

    @Override
    protected void onGenerateAppViewCode(IPSAppView iPSAppView, ArrayList<PSSysSFCode> list) throws Exception {
        if (!(iPSAppView instanceof IPSAppDEView)) {
            return;
        }
        for (IPSControl iPSControl : iPSAppView.getAllPSControls()) {
            if (!iPSControl.getPSControlType().isAjaxControl() || this.appViewCtrlMap.containsKey(String.valueOf(iPSControl.getControlType()) + "|" + iPSControl.getId()) || !this.generateControlCode2(iPSControl, list)) continue;
            this.appViewCtrlMap.put(String.valueOf(iPSControl.getControlType()) + "|" + iPSControl.getId(), "");
        }
    }

    protected boolean generateControlCode2(IPSControl iPSControl, ArrayList<PSSysSFCode> list) throws Exception {
        if (iPSControl instanceof IPSDEForm) {
            Iterator psDEFormItemUpdates;
            IPSDEForm iPSDEForm = (IPSDEForm)iPSControl;
            Iterator psDEFormItems = iPSDEForm.getPSDEFormItems();
            if (psDEFormItems != null) {
                while (psDEFormItems.hasNext()) {
                    IPSDEFormItem iPSDEFormItem = (IPSDEFormItem)psDEFormItems.next();
                    if (StringHelper.isNullOrEmpty((String)iPSDEFormItem.getItemHandlerType())) continue;
                    this.generateFormItemCode(iPSDEFormItem, list);
                }
            }
            if ((psDEFormItemUpdates = iPSDEForm.getPSDEFormItemUpdates()) != null) {
                while (psDEFormItemUpdates.hasNext()) {
                    IPSDEFormItemUpdate iPSDEFormItemUpdate = (IPSDEFormItemUpdate)psDEFormItemUpdates.next();
                    this.generateFormItemUpdateCode(iPSDEFormItemUpdate, list);
                }
            }
            return true;
        }
        if (iPSControl instanceof IPSDEGrid) {
            Iterator psDEGridEditItemUpdates;
            IPSDEGrid iPSDEGrid = (IPSDEGrid)iPSControl;
            if (!iPSDEGrid.isEnableRowEdit()) {
                return false;
            }
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
        }
        return true;
    }

    protected void generateFormItemCode(IPSDEFormItem iPSDEFormItem, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("ctrl", iPSDEFormItem.getPSDEForm());
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(true, list != null);
        psSysSFCode.setSYSOBJID(Helper.GenUniqueId((String)iPSDEFormItem.getPSDEForm().getId(), (String)iPSDEFormItem.getName()));
        psSysSFCode.setSYSOBJNAME(iPSDEFormItem.getName());
        IPSGenerateCodeResult iPSGenerateCodeResult = this.generateCode(CODETEMPL_FORMITEM, iPSDEFormItem, params);
        params.put("ctrlcode", iPSGenerateCodeResult);
        this.savePSSysSFCode(iPSDEFormItem, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }

    protected void generateFormItemUpdateCode(IPSDEFormItemUpdate iPSDEFormItemUpdate, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("ctrl", iPSDEFormItemUpdate.getPSDEForm());
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(true, list != null);
        psSysSFCode.setSYSOBJID(Helper.GenUniqueId((String)iPSDEFormItemUpdate.getPSDEForm().getId(), (String)iPSDEFormItemUpdate.getCodeName()));
        psSysSFCode.setSYSOBJNAME(iPSDEFormItemUpdate.getName());
        IPSGenerateCodeResult iPSGenerateCodeResult = this.generateCode(CODETEMPL_FORMITEMUPDATE, iPSDEFormItemUpdate, params);
        params.put("ctrlcode", iPSGenerateCodeResult);
        this.savePSSysSFCode(iPSDEFormItemUpdate, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }

    protected void generateGridEditItemCode(IPSDEGridEditItem iPSDEGridEditItem, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("ctrl", iPSDEGridEditItem.getPSDEGrid());
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(true, list != null);
        psSysSFCode.setSYSOBJID(Helper.GenUniqueId((String)iPSDEGridEditItem.getPSDEGrid().getId(), (String)iPSDEGridEditItem.getName()));
        psSysSFCode.setSYSOBJNAME(iPSDEGridEditItem.getName());
        IPSGenerateCodeResult iPSGenerateCodeResult = this.generateCode(CODETEMPL_GRIDEDITITEM, iPSDEGridEditItem, params);
        params.put("ctrlcode", iPSGenerateCodeResult);
        this.savePSSysSFCode(iPSDEGridEditItem, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }

    protected void generateGridEditItemUpdateCode(IPSDEGridEditItemUpdate iPSDEGridEditItemUpdate, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("ctrl", iPSDEGridEditItemUpdate.getPSDEGrid());
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(true, list != null);
        psSysSFCode.setSYSOBJID(Helper.GenUniqueId((String)iPSDEGridEditItemUpdate.getPSDEGrid().getId(), (String)iPSDEGridEditItemUpdate.getCodeName()));
        psSysSFCode.setSYSOBJNAME(iPSDEGridEditItemUpdate.getName());
        IPSGenerateCodeResult iPSGenerateCodeResult = this.generateCode(CODETEMPL_GRIDEDITITEMUPDATE, iPSDEGridEditItemUpdate, params);
        params.put("ctrlcode", iPSGenerateCodeResult);
        this.savePSSysSFCode(iPSDEGridEditItemUpdate, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }

    @Override
    protected void onClose() {
        this.appViewCtrlMap.clear();
        super.onClose();
    }
}

