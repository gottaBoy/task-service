/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.control.form.IPSDEFDGroupLogic
 *  net.ibizsys.model.control.form.IPSDEFDLogic
 *  net.ibizsys.model.control.form.IPSDEFDSingleLogic
 *  net.ibizsys.model.control.form.IPSDEFormDetail
 *  net.ibizsys.model.control.form.IPSDEFormItem
 *  net.ibizsys.model.pub.IPSGenerateCodeResult
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.pub;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.form.IPSDEFDGroupLogic;
import net.ibizsys.model.control.form.IPSDEFDLogic;
import net.ibizsys.model.control.form.IPSDEFDSingleLogic;
import net.ibizsys.model.control.form.IPSDEFormDetail;
import net.ibizsys.model.control.form.IPSDEFormItem;
import net.ibizsys.model.pub.IPSGenerateCodeResult;
import net.ibizsys.model.pub.PSNGCtrlPartCodePublisherImpl;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;

public class PSNGDEFormDetailVCPublisherImpl
extends PSNGCtrlPartCodePublisherImpl {
    protected IPSDEFormDetail iPSDEFormDetail = null;

    public IPSGenerateCodeResult generateCode(IPSControl iPSControl, Object object) throws Exception {
        this.iPSDEFormDetail = (IPSDEFormDetail)object;
        return super.generateCode(iPSControl, object);
    }

    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        String strCode;
        HashMap<String, String> relatedFormDetailMap;
        String strCode2;
        IPSDEFDGroupLogic iPSDEFDGroupLogic;
        super.onFillGenerateCodeParams(params);
        if (this.iPSDEFormDetail.getParentPSDEFormDetail() != null) {
            params.put("parent", this.iPSDEFormDetail.getParentPSDEFormDetail());
        }
        if ((iPSDEFDGroupLogic = this.iPSDEFormDetail.getPSDEFDGroupLogic("ITEMBLANK")) != null && !StringHelper.isNullOrEmpty((String)(strCode2 = this.getPSDEFDLogicCode((IPSDEFDLogic)iPSDEFDGroupLogic, relatedFormDetailMap = new HashMap<String, String>())))) {
            params.put("emptycond", strCode2);
        }
        if ((iPSDEFDGroupLogic = this.iPSDEFormDetail.getPSDEFDGroupLogic("ITEMENABLE")) != null && !StringHelper.isNullOrEmpty((String)(strCode2 = this.getPSDEFDLogicCode((IPSDEFDLogic)iPSDEFDGroupLogic, relatedFormDetailMap = new HashMap())))) {
            params.put("enablecond", strCode2);
        }
        if ((iPSDEFDGroupLogic = this.iPSDEFormDetail.getPSDEFDGroupLogic("PANELVISIBLE")) != null && !StringHelper.isNullOrEmpty((String)(strCode2 = this.getPSDEFDLogicCode((IPSDEFDLogic)iPSDEFDGroupLogic, relatedFormDetailMap = new HashMap())))) {
            params.put("visiblecond", strCode2);
        }
        if (this.iPSDEFormDetail instanceof IPSDEFormItem && !StringHelper.isNullOrEmpty((String)(strCode = this.getPSDEFIResetLogicCode((IPSDEFormItem)this.iPSDEFormDetail)))) {
            params.put("resetcond", strCode);
        }
    }

    protected String getPSDEFIResetLogicCode(IPSDEFormItem iPSDEFormItem) throws Exception {
        StringBuilderEx sb = new StringBuilderEx();
        Iterator resetItemNames = iPSDEFormItem.getResetItemNames();
        boolean bFirst = true;
        sb.append("if( ");
        while (resetItemNames.hasNext()) {
            if (bFirst) {
                bFirst = false;
            } else {
                sb.append("|| ");
            }
            String strName = (String)resetItemNames.next();
            sb.append("(fieldname=='%1$s') ", (Object)strName);
        }
        sb.append(") ");
        sb.append("form.setFieldValue('%1$s','');\r\n", (Object)iPSDEFormItem.getName());
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
                    if (StringHelper.isNullOrEmpty((String)strCode)) continue;
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
                sb.append("!");
            }
            sb.append("(");
            int i = 0;
            while (i < codeList.size()) {
                if (i != 0) {
                    if (StringHelper.compare((String)iPSDEFDGroupLogic.getGroupOP(), (String)"AND", (boolean)true) == 0) {
                        sb.append("&&");
                    } else {
                        sb.append("||");
                    }
                }
                String strCode = (String)codeList.get(i);
                sb.append(strCode);
                ++i;
            }
            sb.append(")");
            return sb.toString();
        }
        if (iPSDEFDLogic instanceof IPSDEFDSingleLogic) {
            IPSDEFDSingleLogic iPSDEFDSingleLogic = (IPSDEFDSingleLogic)iPSDEFDLogic;
            relatedFormDetailMap.put(iPSDEFDSingleLogic.getDEFDName().toLowerCase(), "");
            return StringHelper.format((String)"IBiz.testCond(_%1$s,'%2$s','%3$s')", (Object)iPSDEFDSingleLogic.getDEFDName().toLowerCase(), (Object)iPSDEFDSingleLogic.getPSDBValueOPId(), (Object)iPSDEFDSingleLogic.getValue());
        }
        throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u903b\u8f91\u4ee3\u7801");
    }
}

