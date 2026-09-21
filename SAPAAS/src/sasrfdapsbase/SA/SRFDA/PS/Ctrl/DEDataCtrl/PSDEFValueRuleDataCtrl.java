/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.XML.SimpleXMLWriter
 *  SA.SRFramework.XML.XMLNode
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.PS.Data.PSDEFValueRule;
import SA.SRFDA.PS.Data.PSDEFValueRuleCond;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.XML.SimpleXMLWriter;
import SA.SRFramework.XML.XMLNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEFValueRuleDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSDEFValueRuleDataCtrl.class);

    @Override
    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        try {
            PSDEFValueRule psDEFValueRule = new PSDEFValueRule();
            psDEFValueRule.proxy(dataEntity);
            if (!bInsert) {
                String strXML = dataEntity.getParamStringValue("VRMODEL", "");
                if (lastDataEntity != null) {
                    strXML = strXML.replace("\r\n", "\n");
                    String strLastXML = lastDataEntity.getParamStringValue("VRMODEL", "");
                    if (StringHelper.Compare((String)strXML, (String)(strLastXML = strLastXML.replace("\r\n", "\n")), (boolean)true) != 0) {
                        HashMap<String, PSDEFValueRuleCond> validMap = new HashMap<String, PSDEFValueRuleCond>();
                        XMLNode xmlNode = XMLNode.LoadFromXML((String)strXML);
                        this.modifyLayoutFromXML(xmlNode, psDEFValueRule, validMap);
                        BaseDataEntity cond = new BaseDataEntity();
                        cond.setParamValue("PSDEFVRID", (Object)psDEFValueRule.getPSDEFVALUERULEID());
                        Vector psDEFValueRuleCondList = new Vector();
                        IDEDataCtrl psDEFValueRuleCondDataCtrl = this.GetRelatedDataCtrl("DE2071");
                        callResult = psDEFValueRuleCondDataCtrl.Select(cond, psDEFValueRuleCondList, PSDEFValueRuleCond.class.getName());
                        if (callResult.isError()) {
                            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u89c4\u5219\u6761\u4ef6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                        }
                        for (PSDEFValueRuleCond psDEFValueRuleCond : psDEFValueRuleCondList) {
                            if (validMap.containsKey(psDEFValueRuleCond.getPSDEFVRCONDID()) || this.CheckKeyState2(psDEFValueRuleCond) != 1 || !(callResult = psDEFValueRuleCondDataCtrl.Remove((BaseDataEntity)psDEFValueRuleCond)).isError()) continue;
                            throw new Exception(StringHelper.Format((String)"\u5220\u9664\u89c4\u5219\u6761\u4ef6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                        }
                    }
                }
                XMLNode xmlNode = this.fillLayoutXMLNode(null, psDEFValueRule);
                StringBuilder sb = new StringBuilder();
                SimpleXMLWriter writer = new SimpleXMLWriter(sb);
                writer.WriteRaw("<?xml version=\"1.0\" encoding=\"utf-8\" ?>\r\n");
                xmlNode.Save(writer);
                dataEntity.setParamValue("VRMODEL", (Object)sb.toString());
            }
        }
        catch (Exception ex) {
            log.error((Object)ex.getMessage(), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
        return callResult;
    }

    protected void modifyLayoutFromXML(XMLNode xmlNode, PSDEFValueRule psDEFValueRule, HashMap<String, PSDEFValueRuleCond> validMap) throws Exception {
        ArrayList xmlNodes = xmlNode.getChildNodes();
        if (xmlNodes == null) {
            return;
        }
        IDEDataCtrl psDEFValueRuleCondDataCtrl = this.GetRelatedDataCtrl("DE2071");
        String strPNodeId = xmlNode.getID();
        int nIndex = 100;
        for (XMLNode childNode : xmlNodes) {
            String strNodeName = childNode.getNodeName();
            String strNodeId = childNode.getID();
            nIndex += 10;
            PSDEFValueRuleCond realItem = new PSDEFValueRuleCond();
            realItem.setPSDEFVRID(psDEFValueRule.getPSDEFVALUERULEID());
            if (!StringHelper.IsNullOrEmpty((String)strNodeId)) {
                realItem.setPSDEFVRCONDID(strNodeId);
            }
            realItem.setCONDTYPE(strNodeName);
            if (!StringHelper.IsNullOrEmpty((String)strPNodeId)) {
                realItem.setPPSDEFVRCONDID(strPNodeId);
            }
            realItem.setParamValue("ORDERVALUE", nIndex);
            CallResult callResult = psDEFValueRuleCondDataCtrl.Save(StringHelper.IsNullOrEmpty((String)strNodeId), (BaseDataEntity)realItem);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u4fee\u6539\u89c4\u5219\u6761\u4ef6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            childNode.setID(realItem.getPSDEFVRCONDID());
            validMap.put(realItem.getPSDEFVRCONDID(), realItem);
            this.modifyLayoutFromXML(childNode, psDEFValueRule, validMap);
        }
    }

    protected XMLNode fillLayoutXMLNode(XMLNode xmlNode, PSDEFValueRule psDEFValueRule) throws Exception {
        if (xmlNode == null) {
            xmlNode = new XMLNode();
            xmlNode.setNodeName("DEDATAQUERY");
        }
        BaseDataEntity cond = new BaseDataEntity();
        cond.setParamValue("PSDEFVRID", (Object)psDEFValueRule.getPSDEFVALUERULEID());
        Vector psDEFValueRuleCondList = new Vector();
        IDEDataCtrl psDEFValueRuleCondDataCtrl = this.GetRelatedDataCtrl("DE2071");
        CallResult callResult = psDEFValueRuleCondDataCtrl.Select(cond, psDEFValueRuleCondList, PSDEFValueRuleCond.class.getName(), "ORDER BY ORDERVALUE");
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u89c4\u5219\u6761\u4ef6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        HashMap<String, PSDEFValueRuleCond> psDEFValueRuleCondMap = new HashMap<String, PSDEFValueRuleCond>();
        for (PSDEFValueRuleCond psDEFValueRuleCond : psDEFValueRuleCondList) {
            psDEFValueRuleCondMap.put(psDEFValueRuleCond.getPSDEFVRCONDID(), psDEFValueRuleCond);
        }
        for (PSDEFValueRuleCond psDEFValueRuleCond : psDEFValueRuleCondList) {
            if (StringHelper.IsNullOrEmpty((String)psDEFValueRuleCond.getPPSDEFVRCONDID())) continue;
            PSDEFValueRuleCond parentPSDEFValueRuleCond = (PSDEFValueRuleCond)((Object)psDEFValueRuleCondMap.get(psDEFValueRuleCond.getPPSDEFVRCONDID()));
            parentPSDEFValueRuleCond.getChildPSDEFValueRuleConds(true).add(psDEFValueRuleCond);
        }
        int nValue = 0;
        for (PSDEFValueRuleCond psDEFValueRuleCond : psDEFValueRuleCondList) {
            if (!StringHelper.IsNullOrEmpty((String)psDEFValueRuleCond.getPPSDEFVRCONDID())) continue;
            String strOrderString = PSDEFValueRuleDataCtrl.getOrderString(++nValue);
            String strOrderString2 = PSDEFValueRuleDataCtrl.getFullOrderString(strOrderString, 40);
            psDEFValueRuleCond.setLEVELTAG(strOrderString2);
            psDEFValueRuleCond.setLEVELVALUE(strOrderString.length() / 2 - 1);
            xmlNode.SetExtValue("ORDERTAG", strOrderString);
            psDEFValueRuleCondDataCtrl.Save(false, (BaseDataEntity)psDEFValueRuleCond);
            this.fillLayoutXMLNode(xmlNode, psDEFValueRuleCond);
        }
        return xmlNode;
    }

    protected XMLNode fillLayoutXMLNode(XMLNode xmlNode, PSDEFValueRuleCond psDEFValueRuleCond) throws Exception {
        XMLNode childXmlNode = new XMLNode();
        childXmlNode.setNodeName(psDEFValueRuleCond.getCONDTYPE());
        childXmlNode.SetProperty("ID", psDEFValueRuleCond.getPSDEFVRCONDID());
        childXmlNode.SetProperty("NAME", psDEFValueRuleCond.getPSDEFVRCONDNAME());
        xmlNode.AddNode(childXmlNode);
        ArrayList<PSDEFValueRuleCond> childPSDEFValueRuleCondList = psDEFValueRuleCond.getChildPSDEFValueRuleConds(false);
        if (childPSDEFValueRuleCondList != null) {
            int nValue = 0;
            IDEDataCtrl psDEFValueRuleCondDataCtrl = this.GetRelatedDataCtrl("DE2071");
            for (PSDEFValueRuleCond childPSDEFValueRuleCond : childPSDEFValueRuleCondList) {
                String strOrderString = String.valueOf(xmlNode.GetExtValue("ORDERTAG", "")) + PSDEFValueRuleDataCtrl.getOrderString(++nValue);
                String strOrderString2 = PSDEFValueRuleDataCtrl.getFullOrderString(strOrderString, 40);
                childPSDEFValueRuleCond.setLEVELTAG(strOrderString2);
                childPSDEFValueRuleCond.setLEVELVALUE(strOrderString.length() / 2 - 1);
                childXmlNode.SetExtValue("ORDERTAG", strOrderString);
                psDEFValueRuleCondDataCtrl.Save(false, (BaseDataEntity)childPSDEFValueRuleCond);
                this.fillLayoutXMLNode(childXmlNode, childPSDEFValueRuleCond);
            }
        }
        return childXmlNode;
    }

    protected CallResult OnAfterSaveOK(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnAfterSaveOK(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        PSDEFValueRule psDEFValueRule = new PSDEFValueRule();
        psDEFValueRule.proxy(dataEntity);
        try {
            if (bInsert) {
                PSDEFValueRuleCond psDEFValueRuleCond = new PSDEFValueRuleCond();
                psDEFValueRuleCond.setPSDEFVRID(psDEFValueRule.getPSDEFVALUERULEID());
                psDEFValueRuleCond.setCONDTYPE("GROUP");
                psDEFValueRuleCond.setGROUPOP("AND");
                IDEDataCtrl psDEFValueRuleCondDataCtrl = this.GetRelatedDataCtrl("DE2071");
                callResult = psDEFValueRuleCondDataCtrl.Save(true, (BaseDataEntity)psDEFValueRuleCond);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u5efa\u7acb\u9ed8\u8ba4 \u6761\u4ef6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
            }
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
        return callResult;
    }

    public CallResult GetDefault(ISRFDAWebContext webContext, BaseDataEntity dataEntity) {
        CallResult callResult = super.GetDefault(webContext, dataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        dataEntity.setParamValue("VRTYPE", (Object)webContext.GetParamValue("VRTYPE"));
        return callResult;
    }
}

