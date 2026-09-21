/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Control.Form.IPSDEFDGroupLogic
 *  SA.SRFDA.PS.Core.Control.Form.IPSDEFDLogic
 *  SA.SRFDA.PS.Core.Control.Form.IPSDEFDSingleLogic
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 */
package SA.SRFDA.PS.Core.Pub.Csharp;

import SA.SRFDA.PS.Core.Control.Form.IPSDEFDGroupLogic;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFDLogic;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFDSingleLogic;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysAppViewDECtrlModelBaseCodePublisherImpl;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSIBiz5SysAppViewDECtrlModelBaseCSCodePublisherImpl
extends PSIBiz5SysAppViewDECtrlModelBaseCodePublisherImpl {
    @Override
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
            sb.Append("Object _%1$s=iDataObject.Get(\"%1$s\");\r\n", (Object)strKey);
        }
        sb.Append("if(!(%1$s)&&(iDataObject.Get(\"%2$s\")==null)){\r\n", (Object)strCode, (Object)iPSDEFDGroupLogic.getPSDEFormDetail().getName());
        if (StringHelper.Compare((String)iPSDEFDGroupLogic.getLogicCat(), (String)"ITEMBLANK", (boolean)true) == 0) {
            sb.Append("IFormItem iFormItem = this.GetFormItem(\"%1$s\");\r\n", (Object)iPSDEFDGroupLogic.getPSDEFormDetail().getName());
            sb.Append("formError.Register(iFormItem.Name, iFormItem.Caption, iFormItem.CapLanId, FormItemError.ERROR_EMPTY,GetFormItemErrorInfo(iFormItem, FormItemError.ERROR_EMPTY));\r\n");
        }
        sb.Append("}\r\n");
        sb.Append("}\r\n");
        return sb.toString();
    }

    @Override
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
                return StringHelper.Format((String)"DataTypeHelper.TestCond(_%1$s,\"%2$s\",null)", (Object)iPSDEFDSingleLogic.getDEFDName().toLowerCase(), (Object)iPSDEFDSingleLogic.getPSDBValueOPId());
            }
            return StringHelper.Format((String)"DataTypeHelper.TestCond(_%1$s,\"%2$s\",\"%3$s\")", (Object)iPSDEFDSingleLogic.getDEFDName().toLowerCase(), (Object)iPSDEFDSingleLogic.getPSDBValueOPId(), (Object)iPSDEFDSingleLogic.getValue());
        }
        throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u903b\u8f91\u4ee3\u7801");
    }

    @Override
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
        sb.Append("if(IBizSys.Paas.Util.StringHelper.Compare(iFormItem.Name,\"%1$s\",true) == 0){\r\n", (Object)iPSDEFDGroupLogic.getPSDEFormDetail().getName());
        for (String strKey : relatedFormDetailMap.keySet()) {
            sb.Append("Object _%1$s=iDataObject.Get(\"%1$s\");\r\n", (Object)strKey);
        }
        sb.Append("return (%1$s);\r\n", (Object)strCode);
        sb.Append("}\r\n");
        return sb.toString();
    }

    @Override
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
                return StringHelper.Format((String)"DataTypeHelper.TestCond(_%1$s,\"%2$s\",null)", (Object)iPSDEFDSingleLogic.getDEFDName().toLowerCase(), (Object)iPSDEFDSingleLogic.getPSDBValueOPId());
            }
            return StringHelper.Format((String)"DataTypeHelper.TestCond(_%1$s,\"%2$s\",\"%3$s\")", (Object)iPSDEFDSingleLogic.getDEFDName().toLowerCase(), (Object)iPSDEFDSingleLogic.getPSDBValueOPId(), (Object)iPSDEFDSingleLogic.getValue());
        }
        throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u903b\u8f91\u4ee3\u7801");
    }
}

