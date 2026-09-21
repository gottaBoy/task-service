/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Control.Form.IPSDEFDCatGroupLogic
 *  SA.SRFDA.PS.Core.Control.Form.IPSDEFDGroupLogic
 *  SA.SRFDA.PS.Core.Control.Form.IPSDEFDLogic
 *  SA.SRFDA.PS.Core.Control.Form.IPSDEFDSingleLogic
 *  SA.SRFDA.PS.Core.Control.Form.IPSDEForm
 *  SA.SRFDA.PS.Core.Control.Form.IPSDEFormDetail
 *  SA.SRFDA.PS.Core.Control.Form.IPSDEFormGroupPanel
 *  SA.SRFDA.PS.Core.Control.Form.IPSDEFormItem
 *  SA.SRFDA.PS.Core.Control.Form.IPSDEFormPage
 *  SA.SRFDA.PS.Core.Control.Form.IPSDEFormTabPage
 *  SA.SRFDA.PS.Core.Control.Form.IPSDEFormTabPanel
 *  SA.SRFDA.PS.Core.Control.IPSControl
 *  SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult
 *  SA.SRFDA.PS.Core.Pub.IPSPFCtrlPartCodePublisher
 *  SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.PS.Core.Pub.Vue2;

import SA.SRFDA.PS.Core.Control.Form.IPSDEFDCatGroupLogic;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFDGroupLogic;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFDLogic;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFDSingleLogic;
import SA.SRFDA.PS.Core.Control.Form.IPSDEForm;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormDetail;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormGroupPanel;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItem;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormPage;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormTabPage;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormTabPanel;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlPartCodePublisher;
import SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl;
import SA.SRFDA.PS.Core.Pub.Vue2.PSVue2CtrlCodePublisherImpl;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
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
            iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(this.iPSPublisherContext, (IPSControl)this.iPSDEForm, (Object)iPSDEFormItem);
            formDetailList.add(iPSGenerateCodeResult);
        }
        iPSPFCtrlPartCodePublisher.close();
        iPSPFCtrlPartCodePublisher = this.iPSPFCtrlTempl.getPSPFCtrlTemplDetail("FORMPAGE").getPSPFCtrlPartCodePublisher();
        Iterator psDEFormPages = this.iPSDEForm.getPSDEFormPages();
        while (psDEFormPages.hasNext()) {
            iPSDEFormPage = (IPSDEFormPage)psDEFormPages.next();
            iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(this.iPSPublisherContext, (IPSControl)this.iPSDEForm, (Object)iPSDEFormPage);
            formDetailList.add(iPSGenerateCodeResult);
        }
        iPSPFCtrlPartCodePublisher.close();
        psDEFormPages = this.iPSDEForm.getPSDEFormPages();
        while (psDEFormPages.hasNext()) {
            iPSDEFormPage = (IPSDEFormPage)psDEFormPages.next();
            this.fillPSDEFormDetails((IPSDEFormDetail)iPSDEFormPage, formDetailList);
        }
        params.put("formdetails", formDetailList);
        if (StringHelper.Compare((String)this.getPSPFPubCode().getName(), (String)"MODEL", (boolean)true) == 0) {
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
                IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(this.iPSPublisherContext, (IPSControl)this.iPSDEForm, (Object)childPSDEFormDetail);
                formDetailList.add(iPSGenerateCodeResult);
                iPSPFCtrlPartCodePublisher.close();
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
                IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(this.iPSPublisherContext, (IPSControl)this.iPSDEForm, (Object)iPSDEFormTabPage);
                formDetailList.add(iPSGenerateCodeResult);
                iPSPFCtrlPartCodePublisher.close();
            }
            psDEFormTabPages = iPSDEFormTabPanel.getPSDEFormTabPages();
            while (psDEFormTabPages.hasNext()) {
                iPSDEFormTabPage = (IPSDEFormTabPage)psDEFormTabPages.next();
                this.fillPSDEFormDetails((IPSDEFormDetail)iPSDEFormTabPage, formDetailList);
            }
            return;
        }
    }

    protected void onClose() {
        this.iPSDEForm = null;
        super.onClose();
    }

    protected void fillPSDEFDGroupLogicList(IPSDEFormDetail iPSDEFormDetail, Vector<IPSDEFDGroupLogic> psDEFDGroupLogicList) throws Exception {
        block7: {
            IPSDEFormTabPanel iPSDEFormTabPanel;
            Iterator psDEFormTabPages;
            block6: {
                IPSDEFDCatGroupLogic iPSDEFDGroupLogic = iPSDEFormDetail.getPSDEFDGroupLogic("ITEMBLANK");
                if (iPSDEFDGroupLogic != null) {
                    psDEFDGroupLogicList.add((IPSDEFDGroupLogic)iPSDEFDGroupLogic);
                }
                if ((iPSDEFDGroupLogic = iPSDEFormDetail.getPSDEFDGroupLogic("ITEMENABLE")) != null) {
                    psDEFDGroupLogicList.add((IPSDEFDGroupLogic)iPSDEFDGroupLogic);
                }
                if ((iPSDEFDGroupLogic = iPSDEFormDetail.getPSDEFDGroupLogic("PANELVISIBLE")) != null) {
                    psDEFDGroupLogicList.add((IPSDEFDGroupLogic)iPSDEFDGroupLogic);
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

