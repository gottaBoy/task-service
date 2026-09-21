/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 */
package SA.SRFDA.PS.Web;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.Mob.IPSAppLocalDE;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.PSAppDEFormPreviewViewImpl;
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
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Core.PF.IPSPFCtrlTempl;
import SA.SRFDA.PS.Core.PF.IPSPFPubCode;
import SA.SRFDA.PS.Core.PF.IPSPFStyle;
import SA.SRFDA.PS.Core.PSTaskServerEnvImpl;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlCodePublisher;
import SA.SRFDA.PS.Core.Pub.PSPublishContextImpl;
import SA.SRFDA.PS.Data.PSAppView;
import SA.SRFDA.PS.Data.PSDEForm;
import SA.SRFDA.PS.Data.PSDEViewCtrl;
import SA.SRFDA.PS.Web.DECtrlPreviewPage;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

public class DEFormPreviewPage
extends DECtrlPreviewPage {
    protected StringBuilderEx fdLogicCodeSb = new StringBuilderEx();

    public DEFormPreviewPage() {
        this.setJSCache(false);
    }

    @Override
    protected boolean PreparePageEnv() {
        boolean bRet = super.PreparePageEnv();
        if (!bRet) {
            return false;
        }
        try {
            IPSApplication iPSApplication2;
            String strPSDevSlnSysId = this.getWebContext().GetParamValue("PSDEVSLNSYSID");
            String strPSSystemId = this.getWebContext().GetParamValue("PSSYSTEMID");
            IPSSystem iPSSystem = this.getPSSystem(strPSDevSlnSysId, strPSSystemId);
            String strPSDEFormId = this.getWebContext().GetParamValue("PSDEFORMID");
            PSDEForm psDEForm = new PSDEForm();
            CallResult callResult = this.getPSModelHelper(iPSSystem.getPSSysModelInstId()).getPSDEForm(strPSDEFormId, psDEForm);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u8868\u5355"));
            }
            IPSDataEntity iPSDataEntity = iPSSystem.getPSDataEntity(psDEForm.getPSDEID(), false);
            if (iPSDataEntity == null) {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53[%1$s]", (Object)psDEForm.getPSDEID()));
            }
            String strPFType = psDEForm.getPSPFID();
            IPSModelObject iPSApplication = null;
            Iterator<IPSApplication> apps = iPSSystem.getAllPSApps();
            while (apps.hasNext()) {
                iPSApplication2 = apps.next();
                Iterator<? extends IPSAppLocalDE> psAppLocalDEs = iPSApplication2.getAllPSAppLocalDEs();
                if (psAppLocalDEs == null) continue;
                while (psAppLocalDEs.hasNext()) {
                    IPSAppLocalDE iPSAppLocalDE = psAppLocalDEs.next();
                    if (StringHelper.Compare((String)iPSAppLocalDE.getPSDE().getId(), (String)iPSDataEntity.getId(), (boolean)true) != 0) continue;
                    iPSApplication = iPSApplication2;
                    if (iPSApplication2.getDefaultFlag()) break;
                }
                if (iPSApplication != null && iPSApplication.getDefaultFlag()) break;
            }
            if (iPSApplication == null) {
                apps = iPSSystem.getAllPSApps();
                while (apps.hasNext()) {
                    iPSApplication2 = apps.next();
                    if (iPSApplication == null) {
                        if (!StringHelper.IsNullOrEmpty((String)strPFType)) {
                            if (StringHelper.Compare((String)strPFType, (String)iPSApplication2.getPFType(), (boolean)true) != 0) continue;
                            iPSApplication = iPSApplication2;
                            continue;
                        }
                        iPSApplication = iPSApplication2;
                        continue;
                    }
                    if (!iPSApplication2.getDefaultFlag()) continue;
                    if (!StringHelper.IsNullOrEmpty((String)strPFType)) {
                        if (StringHelper.Compare((String)strPFType, (String)iPSApplication2.getPFType(), (boolean)true) != 0) continue;
                        iPSApplication = iPSApplication2;
                        break;
                    }
                    iPSApplication = iPSApplication2;
                    break;
                }
            }
            if (iPSApplication == null) {
                throw new Exception(StringHelper.Format((String)"\u8fd8\u672a\u5efa\u7acb\u5e94\u7528\u7a0b\u5e8f"));
            }
            iPSApplication = this.getPSApplication(iPSSystem, iPSApplication.getId());
            if (StringHelper.IsNullOrEmpty((String)strPFType)) {
                strPFType = iPSApplication.getPFType();
            }
            this.setPFType(strPFType);
            PSAppView psAppView = new PSAppView();
            psAppView.setPSAPPVIEWID("DEFormPreviewView");
            psAppView.setPSAPPVIEWNAME("DEFormPreviewView");
            PSDEViewCtrl psDEViewCtrl = new PSDEViewCtrl();
            psDEViewCtrl.setPSDEVIEWCTRLNAME("form");
            psDEViewCtrl.setPSDEVIEWCTRLTYPE("FORM");
            if (StringHelper.Compare((String)psDEForm.getFORMTYPE(), (String)"SEARCHFORM", (boolean)true) == 0) {
                psDEViewCtrl.setPSDEVIEWCTRLTYPE("SEARCHFORM");
            }
            psDEViewCtrl.setPSDEFORMID(psDEForm.getPSDEFORMID());
            psDEViewCtrl.setPSDEFORMNAME(psDEForm.getPSDEFORMNAME());
            PSAppDEFormPreviewViewImpl psAppDEFormPreviewViewImpl = new PSAppDEFormPreviewViewImpl();
            psAppDEFormPreviewViewImpl.init(this.getDAGlobalHelper(), (IPSApplication)iPSApplication, psAppView, iPSDataEntity, psDEViewCtrl);
            ArrayList<IPSAppView> relatedAppViewList = new ArrayList<IPSAppView>();
            psAppDEFormPreviewViewImpl.fillRelatedPSAppViews(relatedAppViewList);
            IPSPF iPSPF = iPSApplication.getPSPF();
            IPSPFStyle iPSPFStyle = iPSApplication.getPSPFStyle();
            if (iPSPF.isUseJITDesignPreview()) {
                if (iPSPF.getPSAppType().isMobileApp()) {
                    iPSPF = this.getPSModelStorage().getPSPF(PSTaskServerEnvImpl.getCurrent().getPreviewMobPFId());
                    iPSPFStyle = iPSPF.getPSPFStyle(PSTaskServerEnvImpl.getCurrent().getPreviewMobPFStyleId());
                } else {
                    iPSPF = this.getPSModelStorage().getPSPF(PSTaskServerEnvImpl.getCurrent().getPreviewPCPFId());
                    iPSPFStyle = iPSPF.getPSPFStyle(PSTaskServerEnvImpl.getCurrent().getPreviewPCPFStyleId());
                }
            }
            this.setPFType(iPSPF.getId());
            IPSControl iPSControl = psAppDEFormPreviewViewImpl.getPSControl("form");
            Iterator<IPSPFPubCode> psPFPubCodes = iPSPF.getPSPFPubCodes("VIEW");
            while (psPFPubCodes.hasNext()) {
                IPSPFPubCode item = psPFPubCodes.next();
                if (StringHelper.IsNullOrEmpty((String)item.getPreviewCode())) continue;
                String strPreviewCode = item.getPreviewCode();
                IPSPFCtrlTempl iPSPFCtrlTempl = iPSPFStyle.getPSPFCtrlTempl(iPSControl.getPSControlType(), item);
                if (iPSPFCtrlTempl == null) continue;
                PSPublishContextImpl psPublishContextImpl = new PSPublishContextImpl(this.getDAGlobalHelper(), (ISRFDAWebContext)this.getWebContext());
                IPSPFCtrlCodePublisher iPSPFCtrlCodePublisher = iPSPFCtrlTempl.getPSPFCtrlCodePublisher();
                IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlCodePublisher.generateCode(psPublishContextImpl, iPSControl);
                if (iPSGenerateCodeResult != null) {
                    this.psCodeResultMap.put(strPreviewCode, iPSGenerateCodeResult);
                }
                iPSPFCtrlCodePublisher.close();
            }
            this.genFDLogicCode((IPSDEForm)iPSControl);
        }
        catch (Exception ex) {
            this.PageLog((Object)this, 1, ex.getMessage(), ex);
            this.OutputAlertMsg(ex.getMessage(), false);
            return false;
        }
        return true;
    }

    protected void OnInitComponents() {
        super.OnInitComponents();
    }

    protected void genFDLogicCode(IPSDEForm iPSDEForm) throws Exception {
        Vector<IPSDEFDGroupLogic> psDEFDGroupLogicList = new Vector<IPSDEFDGroupLogic>();
        Iterator<IPSDEFormPage> psDEFormPages = iPSDEForm.getPSDEFormPages();
        if (psDEFormPages != null) {
            while (psDEFormPages.hasNext()) {
                IPSDEFormPage iPSDEFormPage = psDEFormPages.next();
                this.fillPSDEFDGroupLogicList(iPSDEFormPage, psDEFDGroupLogicList);
            }
        }
        ArrayList<String> formFDLogicCodeList = new ArrayList<String>();
        for (IPSDEFDGroupLogic iPSDEFDGroupLogic : psDEFDGroupLogicList) {
            formFDLogicCodeList.add(this.getPSDEFDGroupLogicCode(iPSDEFDGroupLogic));
        }
        Iterator<IPSDEFormItem> psDEFormItems = iPSDEForm.getPSDEFormItems();
        while (psDEFormItems.hasNext()) {
            IPSDEFormItem iPSDEFormItem = psDEFormItems.next();
            if (StringHelper.IsNullOrEmpty((String)iPSDEFormItem.getResetItemName())) continue;
            formFDLogicCodeList.add(this.getPSDEFIResetLogicCode(iPSDEFormItem));
        }
        for (String strCode : formFDLogicCodeList) {
            this.fdLogicCodeSb.Append(strCode);
            this.fdLogicCodeSb.Append("\r\n");
        }
    }

    public String renderFDLogicCode() {
        return this.fdLogicCodeSb.toString();
    }

    protected void fillPSDEFDGroupLogicList(IPSDEFormDetail iPSDEFormDetail, Vector<IPSDEFDGroupLogic> psDEFDGroupLogicList) throws Exception {
        block7: {
            IPSDEFormTabPanel iPSDEFormTabPanel;
            Iterator<IPSDEFormTabPage> psDEFormTabPages;
            block6: {
                IPSDEFDCatGroupLogic iPSDEFDGroupLogic = iPSDEFormDetail.getPSDEFDGroupLogic("ITEMBLANK");
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
                    IPSDEFormTabPage iPSDEFormTabPage = psDEFormTabPages.next();
                    this.fillPSDEFDGroupLogicList(iPSDEFormTabPage, psDEFDGroupLogicList);
                }
            }
        }
    }

    protected String getPSDEFDGroupLogicCode(IPSDEFDGroupLogic iPSDEFDGroupLogic) throws Exception {
        HashMap<String, String> relatedFormDetailMap = new HashMap<String, String>();
        String strCode = this.getPSDEFDLogicCode(iPSDEFDGroupLogic, relatedFormDetailMap);
        if (StringHelper.IsNullOrEmpty((String)strCode)) {
            return "";
        }
        if (relatedFormDetailMap.size() == 0) {
            return StringHelper.Format((String)"/*%1$s\u6ca1\u6709\u4efb\u4f55\u5355\u9879\u6761\u4ef6*/", (Object)iPSDEFDGroupLogic.getPSDEFormDetail().getName());
        }
        StringBuilderEx sb = new StringBuilderEx();
        sb.Append("if(fieldname==''");
        for (String strKey : relatedFormDetailMap.keySet()) {
            sb.Append("|| fieldname=='%1$s'", (Object)strKey);
        }
        sb.Append("){\r\n");
        for (String strKey : relatedFormDetailMap.keySet()) {
            sb.Append("var _%1$s=form.getFieldValue('%1$s');\r\n", (Object)strKey);
        }
        sb.Append("var ret=false;if(%1$s){ret=true;}", (Object)strCode);
        if (StringHelper.Compare((String)iPSDEFDGroupLogic.getLogicCat(), (String)"PANELVISIBLE", (boolean)true) == 0) {
            sb.Append("form.setPanelVisible('%1$s',ret);\r\n", (Object)iPSDEFDGroupLogic.getPSDEFormDetail().getName().toLowerCase());
        }
        if (StringHelper.Compare((String)iPSDEFDGroupLogic.getLogicCat(), (String)"ITEMBLANK", (boolean)true) == 0) {
            sb.Append("form.setFieldAllowBlank('%1$s',ret);\r\n", (Object)iPSDEFDGroupLogic.getPSDEFormDetail().getName().toLowerCase());
        }
        if (StringHelper.Compare((String)iPSDEFDGroupLogic.getLogicCat(), (String)"ITEMENABLE", (boolean)true) == 0) {
            sb.Append("form.setFieldDisabled('%1$s',!ret);\r\n", (Object)iPSDEFDGroupLogic.getPSDEFormDetail().getName().toLowerCase());
        }
        sb.Append("}\r\n");
        return sb.toString();
    }

    protected String getPSDEFIResetLogicCode(IPSDEFormItem iPSDEFormItem) throws Exception {
        StringBuilderEx sb = new StringBuilderEx();
        Iterator<String> resetItemNames = iPSDEFormItem.getResetItemNames();
        boolean bFirst = true;
        sb.Append("if( ");
        while (resetItemNames.hasNext()) {
            if (bFirst) {
                bFirst = false;
            } else {
                sb.Append("|| ");
            }
            String strName = resetItemNames.next();
            sb.Append("(fieldname=='%1$s') ", (Object)strName);
        }
        sb.Append(") ");
        sb.Append("form.setFieldValue('%1$s','');\r\n", (Object)iPSDEFormItem.getName());
        return sb.toString();
    }

    protected String getPSDEFDLogicCode(IPSDEFDLogic iPSDEFDLogic, HashMap<String, String> relatedFormDetailMap) throws Exception {
        if (iPSDEFDLogic instanceof IPSDEFDGroupLogic) {
            IPSDEFDGroupLogic iPSDEFDGroupLogic = (IPSDEFDGroupLogic)iPSDEFDLogic;
            ArrayList<String> codeList = new ArrayList<String>();
            Iterator<IPSDEFDLogic> psDEFDLogics = iPSDEFDGroupLogic.getPSDEFDLogics();
            if (psDEFDLogics != null) {
                while (psDEFDLogics.hasNext()) {
                    IPSDEFDLogic childPSDEFDLogic = psDEFDLogics.next();
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
            return StringHelper.Format((String)"IBiz.testCond(_%1$s,'%2$s','%3$s')", (Object)iPSDEFDSingleLogic.getDEFDName().toLowerCase(), (Object)iPSDEFDSingleLogic.getPSDBValueOPId(), (Object)iPSDEFDSingleLogic.getValue());
        }
        throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u903b\u8f91\u4ee3\u7801");
    }
}

