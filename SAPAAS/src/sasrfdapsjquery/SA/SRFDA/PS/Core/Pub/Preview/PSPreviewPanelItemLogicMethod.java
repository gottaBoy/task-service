/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Control.Panel.IPSPanel
 *  SA.SRFDA.PS.Core.Control.Panel.IPSPanelItemGroupLogic
 *  SA.SRFDA.PS.Core.Control.Panel.IPSPanelItemLogic
 *  SA.SRFDA.PS.Core.Control.Panel.IPSPanelItemSingleLogic
 *  SA.SRFDA.PS.Core.Control.Panel.IPSPanelModel
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  freemarker.ext.beans.StringModel
 *  freemarker.template.TemplateMethodModelEx
 *  freemarker.template.TemplateModelException
 */
package SA.SRFDA.PS.Core.Pub.Preview;

import SA.SRFDA.PS.Core.Control.Panel.IPSPanel;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelItemGroupLogic;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelItemLogic;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelItemSingleLogic;
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

public class PSPreviewPanelItemLogicMethod
implements TemplateMethodModelEx {
    public Object exec(List arg0) throws TemplateModelException {
        HashMap<String, String> relatedPanelItemDetailMap;
        IPSPanelItemGroupLogic iPSPanelItemGroupLogic;
        String strCode;
        if (arg0.size() == 0) {
            return StringHelper.Format((String)"");
        }
        Object objCtrl = null;
        if (arg0.get(0) instanceof StringModel) {
            objCtrl = ((StringModel)arg0.get(0)).getWrappedObject();
        }
        if (objCtrl instanceof IPSPanelItemGroupLogic && !StringHelper.IsNullOrEmpty((String)(strCode = PSPreviewPanelItemLogicMethod.getPSLogicCode((IPSPanelItemLogic)(iPSPanelItemGroupLogic = (IPSPanelItemGroupLogic)objCtrl), relatedPanelItemDetailMap = new HashMap<String, String>())))) {
            return strCode;
        }
        return "";
    }

    public static String getPSLogicCode(IPSPanelItemLogic iPSPanelItemLogic, HashMap<String, String> relatedPanelItemDetailMap) {
        if (iPSPanelItemLogic instanceof IPSPanelItemGroupLogic) {
            IPSPanelItemGroupLogic iPSPanelItemGroupLogic = (IPSPanelItemGroupLogic)iPSPanelItemLogic;
            ArrayList<String> codeList = new ArrayList<String>();
            Iterator iPSPanelItemLogics = iPSPanelItemGroupLogic.getPSPanelItemLogics();
            if (iPSPanelItemLogics != null) {
                while (iPSPanelItemLogics.hasNext()) {
                    IPSPanelItemLogic childPanelItemLogic = (IPSPanelItemLogic)iPSPanelItemLogics.next();
                    String strCode = PSPreviewPanelItemLogicMethod.getPSLogicCode(childPanelItemLogic, relatedPanelItemDetailMap);
                    if (StringHelper.IsNullOrEmpty((String)strCode)) continue;
                    codeList.add(strCode);
                }
            }
            if (codeList.size() == 0) {
                return "";
            }
            if (codeList.size() == 1) {
                if (iPSPanelItemGroupLogic.isNotMode()) {
                    return "!" + (String)codeList.get(0);
                }
                return (String)codeList.get(0);
            }
            StringBuilderEx sb = new StringBuilderEx();
            if (iPSPanelItemGroupLogic.isNotMode()) {
                sb.Append("!");
            }
            sb.Append("(");
            int i = 0;
            while (i < codeList.size()) {
                if (i != 0) {
                    if (StringHelper.Compare((String)iPSPanelItemGroupLogic.getGroupOP(), (String)"AND", (boolean)true) == 0) {
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
        if (iPSPanelItemLogic instanceof IPSPanelItemSingleLogic) {
            String strCode = "";
            try {
                IPSPanelItemSingleLogic iPSPanelItemSingleLogic = (IPSPanelItemSingleLogic)iPSPanelItemLogic;
                relatedPanelItemDetailMap.put(iPSPanelItemSingleLogic.getDstModelField().toLowerCase(), "");
                String dstParamName = "";
                if (!StringHelper.IsNullOrEmpty((String)iPSPanelItemSingleLogic.getDstModelField())) {
                    dstParamName = "." + iPSPanelItemSingleLogic.getDstModelField();
                }
                IPSPanelModel model = iPSPanelItemSingleLogic.getDstPSPanelModel();
                String logicName = "model." + model.getCodeName() + dstParamName;
                String strScope = "";
                IPSPanel panel = model.getPSPanel();
                if (!panel.isLayoutPanel()) {
                    if (StringHelper.Compare((String)model.getType(), (String)"CTRLMODEL", (boolean)true) == 0) {
                        logicName = String.valueOf(model.getCodeName()) + (StringHelper.IsNullOrEmpty((String)dstParamName) ? ".value" : dstParamName);
                    }
                    strScope = StringHelper.Format((String)"ctrl.%1$s.", (Object)panel.getName());
                }
                strCode = StringHelper.Format((String)"ctrl.testCond(%1$s%2$s,'%3$s','%4$s')", (Object)strScope, (Object)logicName, (Object)iPSPanelItemSingleLogic.getCondOp(), (Object)iPSPanelItemSingleLogic.getValue());
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return strCode;
        }
        return "";
    }
}

