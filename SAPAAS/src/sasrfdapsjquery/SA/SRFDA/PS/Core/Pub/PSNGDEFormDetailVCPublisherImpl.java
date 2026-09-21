/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Control.Form.IPSDEFDCatGroupLogic
 *  SA.SRFDA.PS.Core.Control.Form.IPSDEFDGroupLogic
 *  SA.SRFDA.PS.Core.Control.Form.IPSDEFDLogic
 *  SA.SRFDA.PS.Core.Control.Form.IPSDEFDSingleLogic
 *  SA.SRFDA.PS.Core.Control.Form.IPSDEFormDetail
 *  SA.SRFDA.PS.Core.Control.Form.IPSDEFormItem
 *  SA.SRFDA.PS.Core.Control.IPSControl
 *  SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult
 *  SA.SRFDA.PS.Core.Pub.IPSPublisherContext
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.Control.Form.IPSDEFDCatGroupLogic;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFDGroupLogic;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFDLogic;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFDSingleLogic;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormDetail;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItem;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import SA.SRFDA.PS.Core.Pub.PSNGCtrlPartCodePublisherImpl;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSNGDEFormDetailVCPublisherImpl
extends PSNGCtrlPartCodePublisherImpl {
    protected IPSDEFormDetail iPSDEFormDetail = null;

    public IPSGenerateCodeResult generateCode(IPSPublisherContext iPSPublisherContext, IPSControl iPSControl, Object object) throws Exception {
        this.iPSDEFormDetail = (IPSDEFormDetail)object;
        return super.generateCode(iPSPublisherContext, iPSControl, object);
    }

    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        String strCode;
        HashMap<String, String> relatedFormDetailMap;
        String strCode2;
        IPSDEFDCatGroupLogic iPSDEFDGroupLogic;
        super.onFillGenerateCodeParams(params);
        if (this.iPSDEFormDetail.getParentPSDEFormDetail() != null) {
            params.put("parent", this.iPSDEFormDetail.getParentPSDEFormDetail());
        }
        if ((iPSDEFDGroupLogic = this.iPSDEFormDetail.getPSDEFDGroupLogic("ITEMBLANK")) != null && !StringHelper.IsNullOrEmpty((String)(strCode2 = this.getPSDEFDLogicCode((IPSDEFDLogic)iPSDEFDGroupLogic, relatedFormDetailMap = new HashMap<String, String>())))) {
            params.put("emptycond", strCode2);
        }
        if ((iPSDEFDGroupLogic = this.iPSDEFormDetail.getPSDEFDGroupLogic("ITEMENABLE")) != null && !StringHelper.IsNullOrEmpty((String)(strCode2 = this.getPSDEFDLogicCode((IPSDEFDLogic)iPSDEFDGroupLogic, relatedFormDetailMap = new HashMap())))) {
            params.put("enablecond", strCode2);
        }
        if ((iPSDEFDGroupLogic = this.iPSDEFormDetail.getPSDEFDGroupLogic("PANELVISIBLE")) != null && !StringHelper.IsNullOrEmpty((String)(strCode2 = this.getPSDEFDLogicCode((IPSDEFDLogic)iPSDEFDGroupLogic, relatedFormDetailMap = new HashMap())))) {
            params.put("visiblecond", strCode2);
        }
        if (this.iPSDEFormDetail instanceof IPSDEFormItem && !StringHelper.IsNullOrEmpty((String)(strCode = this.getPSDEFIResetLogicCode((IPSDEFormItem)this.iPSDEFormDetail)))) {
            params.put("resetcond", strCode);
        }
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
            return StringHelper.Format((String)"IBiz.testCond(_%1$s,'%2$s','%3$s')", (Object)iPSDEFDSingleLogic.getDEFDName().toLowerCase(), (Object)iPSDEFDSingleLogic.getPSDBValueOPId(), (Object)iPSDEFDSingleLogic.getValue());
        }
        throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u903b\u8f91\u4ee3\u7801");
    }

    protected void onClose() {
        this.iPSDEFormDetail = null;
        super.onClose();
    }
}

