/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.App.IPSApplication
 *  SA.SRFDA.PS.Core.App.View.IPSAppView
 *  SA.SRFDA.PS.Core.Control.Form.IPSDEFDCatGroupLogic
 *  SA.SRFDA.PS.Core.Control.Form.IPSDEFDGroupLogic
 *  SA.SRFDA.PS.Core.Control.Form.IPSDEFDLogic
 *  SA.SRFDA.PS.Core.Control.Form.IPSDEFDSingleLogic
 *  SA.SRFDA.PS.Core.Control.Form.IPSDEForm
 *  SA.SRFDA.PS.Core.Control.Form.IPSDEFormDetail
 *  SA.SRFDA.PS.Core.Control.Form.IPSDEFormGroupPanel
 *  SA.SRFDA.PS.Core.Control.Form.IPSDEFormPage
 *  SA.SRFDA.PS.Core.Control.Form.IPSDEFormTabPage
 *  SA.SRFDA.PS.Core.Control.Form.IPSDEFormTabPanel
 *  SA.SRFDA.PS.Core.Control.IPSControl
 *  SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult
 *  SA.SRFDA.PS.Data.PSSysSFCode
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFDCatGroupLogic;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFDGroupLogic;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFDLogic;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFDSingleLogic;
import SA.SRFDA.PS.Core.Control.Form.IPSDEForm;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormDetail;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormGroupPanel;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormPage;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormTabPage;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormTabPanel;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysAppViewCodePublisherImpl;
import SA.SRFDA.PS.Data.PSSysSFCode;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

public class PSIBiz5SysAppViewCtrlModelBaseCodePublisherImpl
extends PSIBiz5SysAppViewCodePublisherImpl {
    protected HashMap<String, String> appViewCtrlMap = new HashMap();

    @Override
    protected void onGenerateCode(IPSApplication iPSApplication, ArrayList<PSSysSFCode> list) throws Exception {
        this.appViewCtrlMap.clear();
        super.onGenerateCode(iPSApplication, list);
        this.appViewCtrlMap.clear();
    }

    @Override
    protected void onGenerateAppViewCode(IPSAppView iPSAppView, ArrayList<PSSysSFCode> list) throws Exception {
        for (IPSControl iPSControl : iPSAppView.getAllPSControls()) {
            if (!iPSControl.hasCtrlModel() || !iPSControl.getPSControlType().isAjaxControl() || StringHelper.Compare((String)iPSControl.getModelScope(), (String)this.getModelScope(), (boolean)true) != 0 || this.appViewCtrlMap.containsKey(String.valueOf(iPSControl.getControlType()) + "|" + iPSControl.getId())) continue;
            this.appViewCtrlMap.put(String.valueOf(iPSControl.getControlType()) + "|" + iPSControl.getId(), "");
            this.generateControlCode(iPSControl, list);
        }
    }

    protected void generateControlCode(IPSControl iPSControl, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap<String, Object> params = new HashMap<String, Object>();
        if (iPSControl.getPSDataEntity() != null) {
            params.put("de", iPSControl.getPSDataEntity());
        }
        if (iPSControl.getPSAppDataEntity() != null) {
            params.put("appde", iPSControl.getPSAppDataEntity());
        }
        IPSGenerateCodeResult iPSGenerateCodeResult = this.generateCode(iPSControl.getControlType(), iPSControl, params);
        params.put("ctrlcode", iPSGenerateCodeResult);
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSControl, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }

    @Override
    protected void onFillGenerateCodeParams(String strType, Object obj, HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(strType, obj, params);
        if (obj instanceof IPSDEForm) {
            IPSDEFormPage iPSDEFormPage;
            IPSDEForm iPSDEForm = (IPSDEForm)obj;
            Vector<IPSDEFDGroupLogic> psDEFDGroupLogicList = new Vector<IPSDEFDGroupLogic>();
            Iterator psDEFormPages = iPSDEForm.getPSDEFormPages();
            if (psDEFormPages != null) {
                while (psDEFormPages.hasNext()) {
                    iPSDEFormPage = (IPSDEFormPage)psDEFormPages.next();
                    this.fillPSDEFDGroupLogicList((IPSDEFormDetail)iPSDEFormPage, psDEFDGroupLogicList);
                }
            }
            ArrayList<String> formFDLogicCodeList = new ArrayList<String>();
            for (IPSDEFDGroupLogic iPSDEFDGroupLogic : psDEFDGroupLogicList) {
                formFDLogicCodeList.add(this.getPSDEFDGroupLogicCode(iPSDEFDGroupLogic));
            }
            params.put("form_fdlogics", formFDLogicCodeList);
            psDEFDGroupLogicList = new Vector();
            psDEFormPages = iPSDEForm.getPSDEFormPages();
            if (psDEFormPages != null) {
                while (psDEFormPages.hasNext()) {
                    iPSDEFormPage = (IPSDEFormPage)psDEFormPages.next();
                    this.fillPSDEFDGroupLogicList2((IPSDEFormDetail)iPSDEFormPage, psDEFDGroupLogicList);
                }
            }
            formFDLogicCodeList = new ArrayList();
            for (IPSDEFDGroupLogic iPSDEFDGroupLogic : psDEFDGroupLogicList) {
                formFDLogicCodeList.add(this.getPSDEFDGroupLogicCode2(iPSDEFDGroupLogic));
            }
            params.put("form_fdlogics2", formFDLogicCodeList);
        }
    }

    protected void fillPSDEFDGroupLogicList(IPSDEFormDetail iPSDEFormDetail, Vector<IPSDEFDGroupLogic> psDEFDGroupLogicList) throws Exception {
        block5: {
            IPSDEFormTabPanel iPSDEFormTabPanel;
            Iterator psDEFormTabPages;
            block4: {
                IPSDEFDCatGroupLogic iPSDEFDGroupLogic = iPSDEFormDetail.getPSDEFDGroupLogic("ITEMBLANK");
                if (iPSDEFDGroupLogic != null) {
                    psDEFDGroupLogicList.add((IPSDEFDGroupLogic)iPSDEFDGroupLogic);
                }
                if (!(iPSDEFormDetail instanceof IPSDEFormGroupPanel)) break block4;
                IPSDEFormGroupPanel iPSDEFormGroupPanel = (IPSDEFormGroupPanel)iPSDEFormDetail;
                Iterator psDEFormDetails = iPSDEFormGroupPanel.getPSDEFormDetails();
                if (psDEFormDetails == null) break block5;
                while (psDEFormDetails.hasNext()) {
                    IPSDEFormDetail iPSDEFormDetail2 = (IPSDEFormDetail)psDEFormDetails.next();
                    this.fillPSDEFDGroupLogicList(iPSDEFormDetail2, psDEFDGroupLogicList);
                }
                break block5;
            }
            if (iPSDEFormDetail instanceof IPSDEFormTabPanel && (psDEFormTabPages = (iPSDEFormTabPanel = (IPSDEFormTabPanel)iPSDEFormDetail).getPSDEFormTabPages()) != null) {
                while (psDEFormTabPages.hasNext()) {
                    IPSDEFormTabPage iPSDEFormTabPage = (IPSDEFormTabPage)psDEFormTabPages.next();
                    this.fillPSDEFDGroupLogicList((IPSDEFormDetail)iPSDEFormTabPage, psDEFDGroupLogicList);
                }
            }
        }
    }

    protected String getPSDEFDGroupLogicCode(IPSDEFDGroupLogic iPSDEFDGroupLogic) throws Exception {
        HashMap<String, String> relatedFormDetailMap = new HashMap<String, String>();
        String strCode = this.getPSDEFDLogicCode((IPSDEFDLogic)iPSDEFDGroupLogic, relatedFormDetailMap);
        if (StringHelper.IsNullOrEmpty((String)strCode)) {
            return "";
        }
        if (relatedFormDetailMap.size() == 0) {
            return StringHelper.Format((String)"/*%1$s\u6ca1\u6709\u4efb\u4f55\u5355\u9879\u6761\u4ef6*/", (Object)iPSDEFDGroupLogic.getPSDEFormDetail().getName());
        }
        StringBuilderEx sb = new StringBuilderEx();
        sb.Append("if(!bIgnoreEmpty");
        sb.Append("){\r\n");
        for (String strKey : relatedFormDetailMap.keySet()) {
            sb.Append("Object _%1$s=iDataObject.get(\"%1$s\");\r\n", (Object)strKey);
        }
        sb.Append("if(!(%1$s)&&(iDataObject.get(\"%2$s\")==null)){\r\n", (Object)strCode, (Object)iPSDEFDGroupLogic.getPSDEFormDetail().getName());
        if (StringHelper.Compare((String)iPSDEFDGroupLogic.getLogicCat(), (String)"ITEMBLANK", (boolean)true) == 0) {
            sb.Append("IFormItem iFormItem = this.getFormItem(\"%1$s\");\r\n", (Object)iPSDEFDGroupLogic.getPSDEFormDetail().getName());
            sb.Append("formError.register(iFormItem.getName(), iFormItem.getCaption(), iFormItem.getCapLanId(), FormItemError.ERROR_EMPTY,getFormItemErrorInfo(iFormItem, FormItemError.ERROR_EMPTY));\r\n");
        }
        sb.Append("}\r\n");
        sb.Append("}\r\n");
        return sb.toString();
    }

    protected String getPSDEFDLogicCode(IPSDEFDLogic iPSDEFDLogic, HashMap<String, String> relatedFormDetailMap) throws Exception {
        if (iPSDEFDLogic instanceof IPSDEFDGroupLogic) {
            IPSDEFDGroupLogic iPSDEFDGroupLogic = (IPSDEFDGroupLogic)iPSDEFDLogic;
            ArrayList<String> codeList = new ArrayList<String>();
            Iterator psDEFDLogics = iPSDEFDGroupLogic.getPSDEFDLogics();
            if (psDEFDLogics != null) {
                while (psDEFDLogics.hasNext()) {
                    IPSDEFDLogic childPSDEFDLogic = (IPSDEFDLogic)psDEFDLogics.next();
                    String strCode = this.getPSDEFDLogicCode(childPSDEFDLogic, relatedFormDetailMap);
                    if (StringHelper.IsNullOrEmpty((String)strCode)) continue;
                    codeList.add(strCode);
                }
            }
            if (codeList.size() == 0) {
                return "";
            }
            if (codeList.size() == 1) {
                if (iPSDEFDGroupLogic.isNotMode()) {
                    return "!" + (String)codeList.get(0);
                }
                return (String)codeList.get(0);
            }
            StringBuilderEx sb = new StringBuilderEx();
            if (iPSDEFDGroupLogic.isNotMode()) {
                sb.Append("!");
            }
            sb.Append("(");
            int i = 0;
            while (i < codeList.size()) {
                if (i != 0) {
                    if (StringHelper.Compare((String)iPSDEFDGroupLogic.getGroupOP(), (String)"AND", (boolean)true) == 0) {
                        sb.Append("&&");
                    } else {
                        sb.Append("||");
                    }
                }
                String strCode = (String)codeList.get(i);
                sb.Append(strCode);
                ++i;
            }
            sb.Append(")");
            return sb.toString();
        }
        if (iPSDEFDLogic instanceof IPSDEFDSingleLogic) {
            IPSDEFDSingleLogic iPSDEFDSingleLogic = (IPSDEFDSingleLogic)iPSDEFDLogic;
            relatedFormDetailMap.put(iPSDEFDSingleLogic.getDEFDName().toLowerCase(), "");
            if (StringHelper.IsNullOrEmpty((String)iPSDEFDSingleLogic.getValue())) {
                return StringHelper.Format((String)"DataTypeHelper.testCond(_%1$s,\"%2$s\",null)", (Object)iPSDEFDSingleLogic.getDEFDName().toLowerCase(), (Object)iPSDEFDSingleLogic.getPSDBValueOPId());
            }
            return StringHelper.Format((String)"DataTypeHelper.testCond(_%1$s,\"%2$s\",\"%3$s\")", (Object)iPSDEFDSingleLogic.getDEFDName().toLowerCase(), (Object)iPSDEFDSingleLogic.getPSDBValueOPId(), (Object)iPSDEFDSingleLogic.getValue());
        }
        throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u903b\u8f91\u4ee3\u7801");
    }

    protected void fillPSDEFDGroupLogicList2(IPSDEFormDetail iPSDEFormDetail, Vector<IPSDEFDGroupLogic> psDEFDGroupLogicList) throws Exception {
        block5: {
            IPSDEFormTabPanel iPSDEFormTabPanel;
            Iterator psDEFormTabPages;
            block4: {
                IPSDEFDCatGroupLogic iPSDEFDGroupLogic = iPSDEFormDetail.getPSDEFDGroupLogic("ITEMENABLE");
                if (iPSDEFDGroupLogic != null) {
                    psDEFDGroupLogicList.add((IPSDEFDGroupLogic)iPSDEFDGroupLogic);
                }
                if (!(iPSDEFormDetail instanceof IPSDEFormGroupPanel)) break block4;
                IPSDEFormGroupPanel iPSDEFormGroupPanel = (IPSDEFormGroupPanel)iPSDEFormDetail;
                Iterator psDEFormDetails = iPSDEFormGroupPanel.getPSDEFormDetails();
                if (psDEFormDetails == null) break block5;
                while (psDEFormDetails.hasNext()) {
                    IPSDEFormDetail iPSDEFormDetail2 = (IPSDEFormDetail)psDEFormDetails.next();
                    this.fillPSDEFDGroupLogicList2(iPSDEFormDetail2, psDEFDGroupLogicList);
                }
                break block5;
            }
            if (iPSDEFormDetail instanceof IPSDEFormTabPanel && (psDEFormTabPages = (iPSDEFormTabPanel = (IPSDEFormTabPanel)iPSDEFormDetail).getPSDEFormTabPages()) != null) {
                while (psDEFormTabPages.hasNext()) {
                    IPSDEFormTabPage iPSDEFormTabPage = (IPSDEFormTabPage)psDEFormTabPages.next();
                    this.fillPSDEFDGroupLogicList2((IPSDEFormDetail)iPSDEFormTabPage, psDEFDGroupLogicList);
                }
            }
        }
    }

    protected String getPSDEFDGroupLogicCode2(IPSDEFDGroupLogic iPSDEFDGroupLogic) throws Exception {
        HashMap<String, String> relatedFormDetailMap = new HashMap<String, String>();
        String strCode = this.getPSDEFDLogicCode2((IPSDEFDLogic)iPSDEFDGroupLogic, relatedFormDetailMap);
        if (StringHelper.IsNullOrEmpty((String)strCode)) {
            return "";
        }
        if (relatedFormDetailMap.size() == 0) {
            return StringHelper.Format((String)"/*%1$s\u6ca1\u6709\u4efb\u4f55\u5355\u9879\u6761\u4ef6*/", (Object)iPSDEFDGroupLogic.getPSDEFormDetail().getName());
        }
        StringBuilderEx sb = new StringBuilderEx();
        sb.Append("if(net.ibizsys.paas.util.StringHelper.compare(iFormItem.getName(),\"%1$s\",true) == 0){\r\n", (Object)iPSDEFDGroupLogic.getPSDEFormDetail().getName());
        for (String strKey : relatedFormDetailMap.keySet()) {
            sb.Append("Object _%1$s=iDataObject.get(\"%1$s\");\r\n", (Object)strKey);
        }
        sb.Append("return (%1$s);\r\n", (Object)strCode);
        sb.Append("}\r\n");
        return sb.toString();
    }

    protected String getPSDEFDLogicCode2(IPSDEFDLogic iPSDEFDLogic, HashMap<String, String> relatedFormDetailMap) throws Exception {
        if (iPSDEFDLogic instanceof IPSDEFDGroupLogic) {
            IPSDEFDGroupLogic iPSDEFDGroupLogic = (IPSDEFDGroupLogic)iPSDEFDLogic;
            ArrayList<String> codeList = new ArrayList<String>();
            Iterator psDEFDLogics = iPSDEFDGroupLogic.getPSDEFDLogics();
            if (psDEFDLogics != null) {
                while (psDEFDLogics.hasNext()) {
                    IPSDEFDLogic childPSDEFDLogic = (IPSDEFDLogic)psDEFDLogics.next();
                    String strCode = this.getPSDEFDLogicCode2(childPSDEFDLogic, relatedFormDetailMap);
                    if (StringHelper.IsNullOrEmpty((String)strCode)) continue;
                    codeList.add(strCode);
                }
            }
            if (codeList.size() == 0) {
                return "";
            }
            if (codeList.size() == 1) {
                if (iPSDEFDGroupLogic.isNotMode()) {
                    return "!" + (String)codeList.get(0);
                }
                return (String)codeList.get(0);
            }
            StringBuilderEx sb = new StringBuilderEx();
            if (iPSDEFDGroupLogic.isNotMode()) {
                sb.Append("!");
            }
            sb.Append("(");
            int i = 0;
            while (i < codeList.size()) {
                if (i != 0) {
                    if (StringHelper.Compare((String)iPSDEFDGroupLogic.getGroupOP(), (String)"AND", (boolean)true) == 0) {
                        sb.Append("&&");
                    } else {
                        sb.Append("||");
                    }
                }
                String strCode = (String)codeList.get(i);
                sb.Append(strCode);
                ++i;
            }
            sb.Append(")");
            return sb.toString();
        }
        if (iPSDEFDLogic instanceof IPSDEFDSingleLogic) {
            IPSDEFDSingleLogic iPSDEFDSingleLogic = (IPSDEFDSingleLogic)iPSDEFDLogic;
            relatedFormDetailMap.put(iPSDEFDSingleLogic.getDEFDName().toLowerCase(), "");
            if (StringHelper.IsNullOrEmpty((String)iPSDEFDSingleLogic.getValue())) {
                return StringHelper.Format((String)"DataTypeHelper.testCond(_%1$s,\"%2$s\",null)", (Object)iPSDEFDSingleLogic.getDEFDName().toLowerCase(), (Object)iPSDEFDSingleLogic.getPSDBValueOPId());
            }
            return StringHelper.Format((String)"DataTypeHelper.testCond(_%1$s,\"%2$s\",\"%3$s\")", (Object)iPSDEFDSingleLogic.getDEFDName().toLowerCase(), (Object)iPSDEFDSingleLogic.getPSDBValueOPId(), (Object)iPSDEFDSingleLogic.getValue());
        }
        throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u903b\u8f91\u4ee3\u7801");
    }

    protected String getModelScope() {
        return "VIEW";
    }

    @Override
    protected void onClose() {
        this.appViewCtrlMap.clear();
        super.onClose();
    }
}

