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
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 */
package SA.SRFDA.PS.Core.Pub.Ionic;

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
import SA.SRFDA.PS.Core.Pub.Ionic.PSIonicViewCodePublisherImpl;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

public class PSIonicViewControllerCodePublisherImpl
extends PSIonicViewCodePublisherImpl {
    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
        ArrayList list = this.iPSAppView.getAllPSControls();
        if (list != null) {
            for (IPSControl iPSControl : list) {
                if (!(iPSControl instanceof IPSDEForm)) continue;
                IPSDEForm iPSDEForm = (IPSDEForm)iPSControl;
                Vector<IPSDEFDGroupLogic> psDEFDGroupLogicList = new Vector<IPSDEFDGroupLogic>();
                Iterator psDEFormPages = iPSDEForm.getPSDEFormPages();
                if (psDEFormPages != null) {
                    while (psDEFormPages.hasNext()) {
                        IPSDEFormPage iPSDEFormPage = (IPSDEFormPage)psDEFormPages.next();
                        this.fillPSDEFDGroupLogicList((IPSDEFormDetail)iPSDEFormPage, psDEFDGroupLogicList);
                    }
                }
                ArrayList<String> formFDLogicCodeList = new ArrayList<String>();
                for (IPSDEFDGroupLogic iPSDEFDGroupLogic : psDEFDGroupLogicList) {
                    formFDLogicCodeList.add(this.getPSDEFDGroupLogicCode(iPSDEFDGroupLogic));
                }
                Iterator psDEFormItems = iPSDEForm.getPSDEFormItems();
                while (psDEFormItems.hasNext()) {
                    IPSDEFormItem iPSDEFormItem = (IPSDEFormItem)psDEFormItems.next();
                    if (StringHelper.IsNullOrEmpty((String)iPSDEFormItem.getResetItemName())) continue;
                    formFDLogicCodeList.add(this.getPSDEFIResetLogicCode(iPSDEFormItem));
                }
                params.put(String.valueOf(iPSDEForm.getName()) + "_fdlogics", formFDLogicCodeList);
            }
        }
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
        sb.Append("if(fieldname==''");
        for (String strKey : relatedFormDetailMap.keySet()) {
            sb.Append("|| fieldname=='%1$s'", (Object)strKey);
        }
        sb.Append("){");
        for (String strKey : relatedFormDetailMap.keySet()) {
            sb.Append("let _%1$s=form.getFieldValue('%1$s');", (Object)strKey);
        }
        sb.Append("let ret=false;if(%1$s){ret=true;}", (Object)strCode);
        if (StringHelper.Compare((String)iPSDEFDGroupLogic.getLogicCat(), (String)"PANELVISIBLE", (boolean)true) == 0) {
            sb.Append("form.setPanelVisible('%1$s',ret);", (Object)iPSDEFDGroupLogic.getPSDEFormDetail().getName().toLowerCase());
        }
        if (StringHelper.Compare((String)iPSDEFDGroupLogic.getLogicCat(), (String)"ITEMBLANK", (boolean)true) == 0) {
            sb.Append("form.setFieldAllowBlank('%1$s',ret);", (Object)iPSDEFDGroupLogic.getPSDEFormDetail().getName().toLowerCase());
        }
        if (StringHelper.Compare((String)iPSDEFDGroupLogic.getLogicCat(), (String)"ITEMENABLE", (boolean)true) == 0) {
            sb.Append("form.setFieldDisabled('%1$s',!ret);", (Object)iPSDEFDGroupLogic.getPSDEFormDetail().getName().toLowerCase());
        }
        sb.Append("}\r\n");
        return sb.toString();
    }

    protected String getPSDEFIResetLogicCode(IPSDEFormItem iPSDEFormItem) throws Exception {
        StringBuilderEx sb = new StringBuilderEx();
        Iterator resetItemNames = iPSDEFormItem.getResetItemNames();
        boolean bFirst = true;
        sb.Append("if( ");
        while (resetItemNames.hasNext()) {
            if (bFirst) {
                bFirst = false;
            } else {
                sb.Append("|| ");
            }
            String strName = (String)resetItemNames.next();
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
            return StringHelper.Format((String)"this.IBizUtil.testCond(_%1$s,'%2$s','%3$s')", (Object)iPSDEFDSingleLogic.getDEFDName().toLowerCase(), (Object)iPSDEFDSingleLogic.getPSDBValueOPId(), (Object)iPSDEFDSingleLogic.getValue());
        }
        throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u903b\u8f91\u4ee3\u7801");
    }
}

