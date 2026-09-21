/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogicNode
 *  SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogicNodeParam
 *  SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogicParam
 *  SA.SRFDA.PS.Core.Control.Panel.IPSPanelModel
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  freemarker.ext.beans.StringModel
 *  freemarker.template.TemplateMethodModelEx
 *  freemarker.template.TemplateModelException
 */
package SA.SRFDA.PS.Core.Pub.Base;

import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogicNode;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogicNodeParam;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogicParam;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelModel;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import freemarker.ext.beans.StringModel;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PSLogicNodeMethod
implements TemplateMethodModelEx {
    public Object exec(List arg0) throws TemplateModelException {
        if (arg0.size() == 0) {
            return StringHelper.Format((String)"");
        }
        Object objCtrl = null;
        if (arg0.get(0) instanceof StringModel) {
            objCtrl = ((StringModel)arg0.get(0)).getWrappedObject();
        }
        if (objCtrl instanceof IPSPanelLogicNode) {
            IPSPanelLogicNode iPSPanelLogicNode = (IPSPanelLogicNode)objCtrl;
            return PSLogicNodeMethod.getPSLogicNodeCode(iPSPanelLogicNode);
        }
        return "";
    }

    public static String getPSLogicNodeCode(IPSPanelLogicNode iPSPanelLogicNode) {
        Iterator nodeParams = iPSPanelLogicNode.getPSPanelLogicNodeParams();
        ArrayList<String> codeList = new ArrayList<String>();
        if (nodeParams != null) {
            while (nodeParams.hasNext()) {
                IPSPanelLogicNodeParam iPSPanelLogicNodeParam = (IPSPanelLogicNodeParam)nodeParams.next();
                String strCode = PSLogicNodeMethod.getPSLogicNodeParamCode(iPSPanelLogicNodeParam);
                codeList.add(strCode);
            }
        }
        if (codeList.size() == 0) {
            return "";
        }
        StringBuilderEx sb = new StringBuilderEx();
        for (String str : codeList) {
            sb.Append(str);
        }
        return sb.toString();
    }

    public static String getPSLogicNodeParamCode(IPSPanelLogicNodeParam nodeParam) {
        try {
            String strDstName = PSLogicNodeMethod.getLogicParamName(nodeParam.getDstPSPanelLogicParam(), nodeParam.getDstFieldName());
            String strSrcValue = "";
            if (StringHelper.Compare((String)nodeParam.getSrcValueType(), (String)"SRCMODEL", (boolean)true) == 0) {
                strSrcValue = PSLogicNodeMethod.getLogicParamName(nodeParam.getSrcPSPanelLogicParam(), nodeParam.getSrcFieldName());
            } else if (StringHelper.Compare((String)nodeParam.getSrcValueType(), (String)"SRCVALUE", (boolean)true) == 0) {
                strSrcValue = "'" + nodeParam.getSrcValue() + "'";
            }
            if (StringHelper.Compare((String)nodeParam.getLogicNodeParamType(), (String)"SETMODEL", (boolean)true) == 0) {
                return String.valueOf(strDstName) + " = " + strSrcValue + ";\n";
            }
            if (StringHelper.Compare((String)nodeParam.getLogicNodeParamType(), (String)"PUSHARRAY", (boolean)true) == 0) {
                return StringHelper.Format((String)"%1$s = IBiz.addToArray(%2$s, %3$s);\n", (Object)strDstName, (Object)strDstName, (Object)strSrcValue);
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "";
    }

    public static String getLogicParamName(IPSPanelLogicParam logicParam, String strFieldName) {
        if (!StringHelper.IsNullOrEmpty((String)strFieldName)) {
            strFieldName = "." + strFieldName;
        }
        if (StringHelper.Compare((String)logicParam.getType(), (String)"TEMP", (boolean)true) == 0 || StringHelper.Compare((String)logicParam.getType(), (String)"INPUT", (boolean)true) == 0) {
            return String.valueOf(logicParam.getCodeName()) + strFieldName;
        }
        if (StringHelper.Compare((String)logicParam.getType(), (String)"PANELMODEL", (boolean)true) == 0) {
            IPSPanelModel iPSPanelModel = logicParam.getPSPanelModel();
            if (StringHelper.Compare((String)iPSPanelModel.getType(), (String)"CTRLMODEL", (boolean)true) == 0) {
                return String.valueOf(iPSPanelModel.getCodeName()) + (StringHelper.IsNullOrEmpty((String)strFieldName) ? ".value" : strFieldName);
            }
            return "model." + iPSPanelModel.getCodeName() + strFieldName;
        }
        return "";
    }
}

