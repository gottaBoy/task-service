/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.control.form.IPSDEFDGroupLogic
 *  net.ibizsys.model.control.form.IPSDEFDLogic
 *  net.ibizsys.model.control.form.IPSDEFDSingleLogic
 *  net.ibizsys.model.control.form.IPSDEForm
 *  net.ibizsys.model.control.form.IPSDEFormDetail
 *  net.ibizsys.model.control.form.IPSDEFormGroupPanel
 *  net.ibizsys.model.control.form.IPSDEFormItem
 *  net.ibizsys.model.control.form.IPSDEFormPage
 *  net.ibizsys.model.control.form.IPSDEFormTabPage
 *  net.ibizsys.model.control.form.IPSDEFormTabPanel
 *  net.ibizsys.model.pub.IPSGenerateCodeResult
 *  net.ibizsys.model.pub.IPSPFCtrlPartCodePublisher
 *  net.ibizsys.model.pub.PSGenerateCodeResultImpl
 *  net.ibizsys.paas.util.StringHelper
 *  net.sf.json.JSONObject
 */
package net.ibizsys.model.pub.vue2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.form.IPSDEFDGroupLogic;
import net.ibizsys.model.control.form.IPSDEFDLogic;
import net.ibizsys.model.control.form.IPSDEFDSingleLogic;
import net.ibizsys.model.control.form.IPSDEForm;
import net.ibizsys.model.control.form.IPSDEFormDetail;
import net.ibizsys.model.control.form.IPSDEFormGroupPanel;
import net.ibizsys.model.control.form.IPSDEFormItem;
import net.ibizsys.model.control.form.IPSDEFormPage;
import net.ibizsys.model.control.form.IPSDEFormTabPage;
import net.ibizsys.model.control.form.IPSDEFormTabPanel;
import net.ibizsys.model.pub.IPSGenerateCodeResult;
import net.ibizsys.model.pub.IPSPFCtrlPartCodePublisher;
import net.ibizsys.model.pub.PSGenerateCodeResultImpl;
import net.ibizsys.model.pub.vue2.PSVue2CtrlCodePublisherImpl;
import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONObject;

public class PSVue2DEFormControllerCodePublisherImpl
extends PSVue2CtrlCodePublisherImpl {
    protected IPSDEForm iPSDEForm = null;

    protected PSGenerateCodeResultImpl onGenerateCode() throws Exception {
        this.iPSDEForm = (IPSDEForm)this.iPSControl;
        return super.onGenerateCode();
    }

    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        IPSDEFormPage iPSDEFormPage;
        IPSGenerateCodeResult iPSGenerateCodeResult;
        super.onFillGenerateCodeParams(params);
        ArrayList<IPSGenerateCodeResult> formDetailList = new ArrayList<IPSGenerateCodeResult>();
        IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.iPSPFCtrlTempl.getPSPFCtrlTemplDetail("HIDDENFORMITEM").getPSPFCtrlPartCodePublisher();
        Iterator psDEFormItems = this.iPSDEForm.getPSDEFormItems();
        while (psDEFormItems.hasNext()) {
            IPSDEFormItem iPSDEFormItem = (IPSDEFormItem)psDEFormItems.next();
            if (!iPSDEFormItem.isHidden()) continue;
            iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode((IPSControl)this.iPSDEForm, (Object)iPSDEFormItem);
            formDetailList.add(iPSGenerateCodeResult);
        }
        iPSPFCtrlPartCodePublisher = this.iPSPFCtrlTempl.getPSPFCtrlTemplDetail("FORMPAGE").getPSPFCtrlPartCodePublisher();
        Iterator psDEFormPages = this.iPSDEForm.getPSDEFormPages();
        while (psDEFormPages.hasNext()) {
            iPSDEFormPage = (IPSDEFormPage)psDEFormPages.next();
            iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode((IPSControl)this.iPSDEForm, (Object)iPSDEFormPage);
            formDetailList.add(iPSGenerateCodeResult);
        }
        psDEFormPages = this.iPSDEForm.getPSDEFormPages();
        while (psDEFormPages.hasNext()) {
            iPSDEFormPage = (IPSDEFormPage)psDEFormPages.next();
            this.fillPSDEFormDetails((IPSDEFormDetail)iPSDEFormPage, formDetailList);
        }
        params.put("formdetails", formDetailList);
        if (StringHelper.compare((String)this.getPSPFPubCode().getName(), (String)"MODEL", (boolean)true) == 0) {
            Vector<IPSDEFDGroupLogic> psDEFDGroupLogicList = new Vector<IPSDEFDGroupLogic>();
            psDEFormPages = this.iPSDEForm.getPSDEFormPages();
            if (psDEFormPages != null) {
                while (psDEFormPages.hasNext()) {
                    iPSDEFormPage = (IPSDEFormPage)psDEFormPages.next();
                    this.fillPSDEFDGroupLogicList((IPSDEFormDetail)iPSDEFormPage, psDEFDGroupLogicList);
                }
            }
            ArrayList<JSONObject> groupLogin = new ArrayList<JSONObject>();
            for (IPSDEFDGroupLogic iPSDEFDGroupLogic : psDEFDGroupLogicList) {
                JSONObject Obj = this.getPSDEFDGroupLogicCode(iPSDEFDGroupLogic);
                if (Obj == null) continue;
                groupLogin.add(Obj);
            }
            params.put("groupLogic", groupLogin.toString());
            ArrayList<JSONObject> formItemUpdates = new ArrayList<JSONObject>();
            Iterator items = this.iPSDEForm.getPSDEFormItems();
            while (items.hasNext()) {
                IPSDEFormItem item = (IPSDEFormItem)items.next();
                if (item == null || item.getPSDEFormItemUpdate() == null) continue;
                JSONObject obj = new JSONObject();
                obj.put(item.getName().toLowerCase(), (Object)item.getPSDEFormItemUpdate().getCodeName());
                formItemUpdates.add(obj);
            }
            params.put("formItemUpdates", formItemUpdates.toString());
        }
    }

    protected void fillPSDEFormDetails(IPSDEFormDetail iPSDEFormDetail, ArrayList<IPSGenerateCodeResult> formDetailList) throws Exception {
        if (iPSDEFormDetail instanceof IPSDEFormGroupPanel) {
            IPSDEFormDetail childPSDEFormDetail;
            IPSDEFormGroupPanel iPSDEFormGroupPanel = (IPSDEFormGroupPanel)iPSDEFormDetail;
            Iterator psDEFormDetails = iPSDEFormGroupPanel.getPSDEFormDetails();
            while (psDEFormDetails.hasNext()) {
                childPSDEFormDetail = (IPSDEFormDetail)psDEFormDetails.next();
                if (childPSDEFormDetail instanceof IPSDEFormItem && ((IPSDEFormItem)childPSDEFormDetail).isHidden()) continue;
                IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.iPSPFCtrlTempl.getPSPFCtrlTemplDetail(childPSDEFormDetail.getDetailType()).getPSPFCtrlPartCodePublisher();
                IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode((IPSControl)this.iPSDEForm, (Object)childPSDEFormDetail);
                formDetailList.add(iPSGenerateCodeResult);
            }
            psDEFormDetails = iPSDEFormGroupPanel.getPSDEFormDetails();
            while (psDEFormDetails.hasNext()) {
                childPSDEFormDetail = (IPSDEFormDetail)psDEFormDetails.next();
                this.fillPSDEFormDetails(childPSDEFormDetail, formDetailList);
            }
            return;
        }
        if (iPSDEFormDetail instanceof IPSDEFormTabPanel) {
            IPSDEFormTabPage iPSDEFormTabPage;
            IPSDEFormTabPanel iPSDEFormTabPanel = (IPSDEFormTabPanel)iPSDEFormDetail;
            Iterator psDEFormTabPages = iPSDEFormTabPanel.getPSDEFormTabPages();
            while (psDEFormTabPages.hasNext()) {
                iPSDEFormTabPage = (IPSDEFormTabPage)psDEFormTabPages.next();
                IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.iPSPFCtrlTempl.getPSPFCtrlTemplDetail(iPSDEFormTabPage.getDetailType()).getPSPFCtrlPartCodePublisher();
                IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode((IPSControl)this.iPSDEForm, (Object)iPSDEFormTabPage);
                formDetailList.add(iPSGenerateCodeResult);
            }
            psDEFormTabPages = iPSDEFormTabPanel.getPSDEFormTabPages();
            while (psDEFormTabPages.hasNext()) {
                iPSDEFormTabPage = (IPSDEFormTabPage)psDEFormTabPages.next();
                this.fillPSDEFormDetails((IPSDEFormDetail)iPSDEFormTabPage, formDetailList);
            }
            return;
        }
    }

    protected void fillPSDEFDGroupLogicList(IPSDEFormDetail iPSDEFormDetail, Vector<IPSDEFDGroupLogic> psDEFDGroupLogicList) throws Exception {
        block7: {
            IPSDEFormTabPanel iPSDEFormTabPanel;
            Iterator psDEFormTabPages;
            block6: {
                IPSDEFDGroupLogic iPSDEFDGroupLogic = iPSDEFormDetail.getPSDEFDGroupLogic("ITEMBLANK");
                if (iPSDEFDGroupLogic != null) {
                    psDEFDGroupLogicList.add(iPSDEFDGroupLogic);
                }
                if ((iPSDEFDGroupLogic = iPSDEFormDetail.getPSDEFDGroupLogic("ITEMENABLE")) != null) {
                    psDEFDGroupLogicList.add(iPSDEFDGroupLogic);
                }
                if ((iPSDEFDGroupLogic = iPSDEFormDetail.getPSDEFDGroupLogic("PANELVISIBLE")) != null) {
                    psDEFDGroupLogicList.add(iPSDEFDGroupLogic);
                }
                if (!(iPSDEFormDetail instanceof IPSDEFormGroupPanel)) break block6;
                IPSDEFormGroupPanel iPSDEFormGroupPanel = (IPSDEFormGroupPanel)iPSDEFormDetail;
                Iterator psDEFormDetails = iPSDEFormGroupPanel.getPSDEFormDetails();
                if (psDEFormDetails == null) break block7;
                while (psDEFormDetails.hasNext()) {
                    IPSDEFormDetail iPSDEFormDetail2 = (IPSDEFormDetail)psDEFormDetails.next();
                    this.fillPSDEFDGroupLogicList(iPSDEFormDetail2, psDEFDGroupLogicList);
                }
                break block7;
            }
            if (iPSDEFormDetail instanceof IPSDEFormTabPanel && (psDEFormTabPages = (iPSDEFormTabPanel = (IPSDEFormTabPanel)iPSDEFormDetail).getPSDEFormTabPages()) != null) {
                while (psDEFormTabPages.hasNext()) {
                    IPSDEFormTabPage iPSDEFormTabPage = (IPSDEFormTabPage)psDEFormTabPages.next();
                    this.fillPSDEFDGroupLogicList((IPSDEFormDetail)iPSDEFormTabPage, psDEFDGroupLogicList);
                }
            }
        }
    }

    protected JSONObject getPSDEFDGroupLogicCode(IPSDEFDGroupLogic iPSDEFDGroupLogic) throws Exception {
        JSONObject obj = new JSONObject();
        HashMap<String, String> relatedFormDetailMap = new HashMap<String, String>();
        ArrayList<JSONObject> conditions = new ArrayList<JSONObject>();
        JSONObject condition = this.getPSDEFDLogicCode((IPSDEFDLogic)iPSDEFDGroupLogic, relatedFormDetailMap);
        if (condition == null) {
            return null;
        }
        conditions.add(condition);
        if (relatedFormDetailMap.size() == 0) {
            return null;
        }
        ArrayList<String> relatedFormDetailLists = new ArrayList<String>();
        for (String name : relatedFormDetailMap.keySet()) {
            relatedFormDetailLists.add(name);
        }
        obj.put("names", relatedFormDetailLists);
        obj.put("logiccat", (Object)iPSDEFDGroupLogic.getLogicCat());
        obj.put("formname", (Object)this.iPSDEForm.getName());
        obj.put("conditions", (Object)conditions.toString());
        obj.put("itemname", (Object)iPSDEFDGroupLogic.getPSDEFormDetail().getName().toLowerCase());
        return obj;
    }

    protected JSONObject getPSDEFDLogicCode(IPSDEFDLogic iPSDEFDLogic, HashMap<String, String> relatedFormDetailMap) throws Exception {
        if (iPSDEFDLogic instanceof IPSDEFDGroupLogic) {
            JSONObject condition = new JSONObject();
            IPSDEFDGroupLogic iPSDEFDGroupLogic = (IPSDEFDGroupLogic)iPSDEFDLogic;
            ArrayList<JSONObject> _childList = new ArrayList<JSONObject>();
            Iterator psDEFDLogics = iPSDEFDGroupLogic.getPSDEFDLogics();
            if (psDEFDLogics != null) {
                while (psDEFDLogics.hasNext()) {
                    IPSDEFDLogic childPSDEFDLogic = (IPSDEFDLogic)psDEFDLogics.next();
                    JSONObject _child = this.getPSDEFDLogicCode(childPSDEFDLogic, relatedFormDetailMap);
                    if (_child == null) continue;
                    _childList.add(_child);
                }
            }
            if (_childList.size() == 0) {
                return null;
            }
            condition.put("isnotmode", iPSDEFDGroupLogic.isNotMode());
            condition.put("gruopop", (Object)iPSDEFDGroupLogic.getGroupOP());
            condition.put("items", _childList);
            condition.put("type", (Object)"group");
            return condition;
        }
        if (iPSDEFDLogic instanceof IPSDEFDSingleLogic) {
            IPSDEFDSingleLogic iPSDEFDSingleLogic = (IPSDEFDSingleLogic)iPSDEFDLogic;
            relatedFormDetailMap.put(iPSDEFDSingleLogic.getDEFDName().toLowerCase(), iPSDEFDSingleLogic.getDEFDName().toLowerCase());
            JSONObject obj = new JSONObject();
            obj.put("name", (Object)iPSDEFDSingleLogic.getDEFDName().toLowerCase());
            obj.put("dbvalueop", (Object)iPSDEFDSingleLogic.getPSDBValueOPId());
            obj.put("value", (Object)iPSDEFDSingleLogic.getValue());
            return obj;
        }
        throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u903b\u8f91\u4ee3\u7801");
    }
}

