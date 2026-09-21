/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogicLinkCond
 *  SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogicLinkGroupCond
 *  SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogicLinkSingleCond
 *  SA.SRFDA.PS.Core.Control.Panel.IPSPanelModel
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  freemarker.ext.beans.StringModel
 *  freemarker.template.TemplateMethodModelEx
 *  freemarker.template.TemplateModelException
 */
package SA.SRFDA.PS.Core.Pub.Base;

import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogicLinkCond;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogicLinkGroupCond;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogicLinkSingleCond;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelModel;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import freemarker.ext.beans.StringModel;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class PSLogicMethod
implements TemplateMethodModelEx {
    public Object exec(List arg0) throws TemplateModelException {
        HashMap<String, String> relatedLogicDetailMap;
        IPSPanelLogicLinkGroupCond iPSPanelLogicLinkGroupCond;
        String strCode;
        if (arg0.size() == 0) {
            return StringHelper.Format((String)"");
        }
        Object objCtrl = null;
        if (arg0.get(0) instanceof StringModel) {
            objCtrl = ((StringModel)arg0.get(0)).getWrappedObject();
        }
        if (objCtrl instanceof IPSPanelLogicLinkGroupCond && !StringHelper.IsNullOrEmpty((String)(strCode = PSLogicMethod.getPSLogicCode((IPSPanelLogicLinkCond)(iPSPanelLogicLinkGroupCond = (IPSPanelLogicLinkGroupCond)objCtrl), relatedLogicDetailMap = new HashMap<String, String>())))) {
            return strCode;
        }
        return "true";
    }

    public static String getPSLogicCode(IPSPanelLogicLinkCond iPSPanelLogicLinkCond, HashMap<String, String> relatedLogicDetailMap) {
        if (iPSPanelLogicLinkCond instanceof IPSPanelLogicLinkGroupCond) {
            IPSPanelLogicLinkGroupCond iPSPanelLogicLinkGroupCond = (IPSPanelLogicLinkGroupCond)iPSPanelLogicLinkCond;
            ArrayList<String> codeList = new ArrayList<String>();
            Iterator iPSPanelLogicLinkConds = iPSPanelLogicLinkGroupCond.getPSPanelLogicLinkConds();
            if (iPSPanelLogicLinkConds != null) {
                while (iPSPanelLogicLinkConds.hasNext()) {
                    IPSPanelLogicLinkCond childLogicLinkCond = (IPSPanelLogicLinkCond)iPSPanelLogicLinkConds.next();
                    String strCode = PSLogicMethod.getPSLogicCode(childLogicLinkCond, relatedLogicDetailMap);
                    if (StringHelper.IsNullOrEmpty((String)strCode)) continue;
                    codeList.add(strCode);
                }
            }
            if (codeList.size() == 0) {
                return "";
            }
            if (codeList.size() == 1) {
                if (iPSPanelLogicLinkGroupCond.isNotMode()) {
                    return "!" + (String)codeList.get(0);
                }
                return (String)codeList.get(0);
            }
            StringBuilderEx sb = new StringBuilderEx();
            if (iPSPanelLogicLinkGroupCond.isNotMode()) {
                sb.Append("!");
            }
            sb.Append("(");
            int i = 0;
            while (i < codeList.size()) {
                if (i != 0) {
                    if (StringHelper.Compare((String)iPSPanelLogicLinkGroupCond.getGroupOP(), (String)"AND", (boolean)true) == 0) {
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
        if (iPSPanelLogicLinkCond instanceof IPSPanelLogicLinkSingleCond) {
            String strCode = "";
            try {
                IPSPanelModel model;
                IPSPanelLogicLinkSingleCond iPSPanelLogicLinkSingleCond = (IPSPanelLogicLinkSingleCond)iPSPanelLogicLinkCond;
                relatedLogicDetailMap.put(iPSPanelLogicLinkSingleCond.getDstFieldName().toLowerCase(), "");
                String dstParamName = "";
                if (!StringHelper.IsNullOrEmpty((String)iPSPanelLogicLinkSingleCond.getDstFieldName())) {
                    dstParamName = "." + iPSPanelLogicLinkSingleCond.getDstFieldName();
                }
                dstParamName = StringHelper.Compare((String)iPSPanelLogicLinkSingleCond.getDstPanelLogicParam().getType(), (String)"PANELMODEL", (boolean)true) == 0 ? (StringHelper.Compare((String)(model = iPSPanelLogicLinkSingleCond.getDstPanelLogicParam().getPSPanelModel()).getType(), (String)"CTRLMODEL", (boolean)true) == 0 ? String.valueOf(model.getCodeName()) + (StringHelper.IsNullOrEmpty((String)dstParamName) ? ".value" : dstParamName) : "model." + model.getCodeName() + dstParamName) : String.valueOf(iPSPanelLogicLinkSingleCond.getDstPanelLogicParam().getCodeName()) + dstParamName;
                strCode = StringHelper.Format((String)"IBiz.testCond(%1$s,'%2$s','%3$s')", (Object)dstParamName, (Object)iPSPanelLogicLinkSingleCond.getCondOp(), (Object)iPSPanelLogicLinkSingleCond.getValue());
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return strCode;
        }
        return "";
    }
}

