/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
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
import SA.SRFDA.PS.Data.PSCodeItem;
import SA.SRFDA.PS.Data.PSCodeList;
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

public class PSCodeListDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSCodeListDataCtrl.class);

    @Override
    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        try {
            if (!bInsert) {
                PSCodeList psCodeList = new PSCodeList();
                psCodeList.proxy(dataEntity);
                String strXML = dataEntity.getParamStringValue("CLMODEL", null);
                if (lastDataEntity != null && strXML != null) {
                    String strLastXML = lastDataEntity.getParamStringValue("CLMODEL", "");
                    if (StringHelper.Compare((String)(strXML = strXML.replace("\r\n", "\n")), (String)(strLastXML = strLastXML.replace("\r\n", "\n")), (boolean)true) != 0) {
                        HashMap<String, PSCodeItem> validMap = new HashMap<String, PSCodeItem>();
                        XMLNode xmlNode = XMLNode.LoadFromXML((String)strXML);
                        this.modifyLayoutFromXML(xmlNode, psCodeList, validMap);
                        BaseDataEntity cond = new BaseDataEntity();
                        cond.setParamValue("PSCODELISTID", (Object)psCodeList.getPSCODELISTID());
                        Vector psCodeItemList = new Vector();
                        IDEDataCtrl psCodeItemDataCtrl = this.GetRelatedDataCtrl("DE2041");
                        callResult = psCodeItemDataCtrl.Select(cond, psCodeItemList, PSCodeItem.class.getName());
                        if (callResult.isError()) {
                            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u4ee3\u7801\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                        }
                        for (PSCodeItem psCodeItem : psCodeItemList) {
                            if (validMap.containsKey(psCodeItem.getPSCODEITEMID()) || this.CheckKeyState2(psCodeItem) != 1 || !(callResult = psCodeItemDataCtrl.Remove((BaseDataEntity)psCodeItem)).isError()) continue;
                            throw new Exception(StringHelper.Format((String)"\u5220\u9664\u4ee3\u7801\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                        }
                    }
                }
                XMLNode xmlNode = this.fillLayoutXMLNode(null, psCodeList);
                StringBuilder sb = new StringBuilder();
                SimpleXMLWriter writer = new SimpleXMLWriter(sb);
                writer.WriteRaw("<?xml version=\"1.0\" encoding=\"utf-8\" ?>\r\n");
                xmlNode.Save(writer);
                dataEntity.setParamValue("CLMODEL", (Object)sb.toString());
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

    protected void modifyLayoutFromXML(XMLNode xmlNode, PSCodeList psCodeList, HashMap<String, PSCodeItem> validMap) throws Exception {
        ArrayList xmlNodes = xmlNode.getChildNodes();
        if (xmlNodes == null) {
            return;
        }
        IDEDataCtrl psCodeItemDataCtrl = this.GetRelatedDataCtrl("DE2041");
        String strPNodeId = xmlNode.getID();
        int nIndex = 100;
        for (XMLNode childNode : xmlNodes) {
            String strNodeName = childNode.getNodeName();
            String strNodeId = childNode.getID();
            nIndex += 10;
            PSCodeItem realItem = new PSCodeItem();
            realItem.setPSCODELISTID(psCodeList.getPSCODELISTID());
            if (!StringHelper.IsNullOrEmpty((String)strNodeId)) {
                realItem.setPSCODEITEMID(strNodeId);
            }
            if (!StringHelper.IsNullOrEmpty((String)strPNodeId)) {
                realItem.setPPSCODEITEMID(strPNodeId);
            }
            realItem.setParamValue("ORDERVALUE", nIndex);
            CallResult callResult = psCodeItemDataCtrl.Save(StringHelper.IsNullOrEmpty((String)strNodeId), (BaseDataEntity)realItem);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u4fee\u6539\u4ee3\u7801\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            childNode.setID(realItem.getPSCODEITEMID());
            validMap.put(realItem.getPSCODEITEMID(), realItem);
            this.modifyLayoutFromXML(childNode, psCodeList, validMap);
        }
    }

    protected XMLNode fillLayoutXMLNode(XMLNode xmlNode, PSCodeList psCodeList) throws Exception {
        if (xmlNode == null) {
            xmlNode = new XMLNode();
            xmlNode.setNodeName("CODELIST");
        }
        BaseDataEntity cond = new BaseDataEntity();
        cond.setParamValue("PSCODELISTID", (Object)psCodeList.getPSCODELISTID());
        Vector psCodeItemList = new Vector();
        IDEDataCtrl psCodeItemDataCtrl = this.GetRelatedDataCtrl("DE2041");
        CallResult callResult = psCodeItemDataCtrl.Select(cond, psCodeItemList, PSCodeItem.class.getName(), "ORDER BY ORDERVALUE");
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u4ee3\u7801\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        HashMap<String, PSCodeItem> psCodeItemMap = new HashMap<String, PSCodeItem>();
        for (PSCodeItem psCodeItem : psCodeItemList) {
            psCodeItemMap.put(psCodeItem.getPSCODEITEMID(), psCodeItem);
        }
        for (PSCodeItem psCodeItem : psCodeItemList) {
            if (StringHelper.IsNullOrEmpty((String)psCodeItem.getPPSCODEITEMID())) continue;
            PSCodeItem parentPSCodeItem = (PSCodeItem)((Object)psCodeItemMap.get(psCodeItem.getPPSCODEITEMID()));
            parentPSCodeItem.getChildPSCodeItems(true).add(psCodeItem);
        }
        int nValue = 0;
        for (PSCodeItem psCodeItem : psCodeItemList) {
            if (!StringHelper.IsNullOrEmpty((String)psCodeItem.getPPSCODEITEMID())) continue;
            String strOrderString = PSCodeListDataCtrl.getOrderString(++nValue);
            String strOrderString2 = PSCodeListDataCtrl.getFullOrderString(strOrderString, 40);
            psCodeItem.setLEVELTAG(strOrderString2);
            psCodeItem.setLEVELVALUE(strOrderString.length() / 2);
            xmlNode.SetExtValue("ORDERTAG", strOrderString);
            psCodeItemDataCtrl.Save(false, (BaseDataEntity)psCodeItem);
            this.fillLayoutXMLNode(xmlNode, psCodeItem);
        }
        return xmlNode;
    }

    protected XMLNode fillLayoutXMLNode(XMLNode xmlNode, PSCodeItem psCodeItem) throws Exception {
        XMLNode childXmlNode = new XMLNode();
        childXmlNode.setNodeName("CODEITEM");
        childXmlNode.SetProperty("ID", psCodeItem.getPSCODEITEMID());
        childXmlNode.SetProperty("NAME", psCodeItem.getPSCODEITEMNAME());
        childXmlNode.SetProperty("VALUE", psCodeItem.getCODEITEMVALUE());
        xmlNode.AddNode(childXmlNode);
        ArrayList<PSCodeItem> childPSCodeItemList = psCodeItem.getChildPSCodeItems(false);
        if (childPSCodeItemList != null) {
            int nValue = 0;
            IDEDataCtrl psCodeItemDataCtrl = this.GetRelatedDataCtrl("DE2041");
            for (PSCodeItem childPSCodeItem : childPSCodeItemList) {
                String strOrderString = String.valueOf(xmlNode.GetExtValue("ORDERTAG", "")) + PSCodeListDataCtrl.getOrderString(++nValue);
                String strOrderString2 = PSCodeListDataCtrl.getFullOrderString(strOrderString, 40);
                psCodeItem.setLEVELTAG(strOrderString2);
                psCodeItem.setLEVELVALUE(strOrderString.length() / 2);
                xmlNode.SetExtValue("ORDERTAG", strOrderString);
                psCodeItemDataCtrl.Save(false, (BaseDataEntity)psCodeItem);
                this.fillLayoutXMLNode(childXmlNode, childPSCodeItem);
            }
        }
        return childXmlNode;
    }

    public CallResult CopyDetail(BaseDataEntity dataEntity, Object srcKey) {
        CallResult callResult = super.CopyDetail(dataEntity, srcKey);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            PSCodeList psCodeList = new PSCodeList();
            psCodeList.Proxy(dataEntity);
            BaseDataEntity cond = new BaseDataEntity();
            cond.setParamValue("PSCODELISTID", srcKey);
            Vector<PSCodeItem> psCodeItemList = new Vector<PSCodeItem>();
            IDEDataCtrl psCodeItemDataCtrl = this.GetRelatedDataCtrl("DE2041");
            callResult = psCodeItemDataCtrl.Select(cond, psCodeItemList, PSCodeItem.class.getName(), "ORDER BY ORDERVALUE");
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u4ee3\u7801\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            HashMap<String, String> psCodeItemIdMap = new HashMap<String, String>();
            int nContinueCount = 0;
            while (psCodeItemList.size() > 0) {
                String strParentId = "";
                PSCodeItem psCodeItem = (PSCodeItem)((Object)psCodeItemList.remove(0));
                if (!StringHelper.IsNullOrEmpty((String)psCodeItem.getPPSCODEITEMID())) {
                    if (psCodeItemIdMap.containsKey(psCodeItem.getPPSCODEITEMID())) {
                        strParentId = (String)psCodeItemIdMap.get(psCodeItem.getPPSCODEITEMID());
                    } else {
                        psCodeItemList.add(psCodeItem);
                        if (++nContinueCount < psCodeItemList.size()) continue;
                        throw new Exception(StringHelper.Format((String)"\u51fa\u73b0\u9012\u5f52\u6570\u636e"));
                    }
                }
                nContinueCount = 0;
                String strOriginId = psCodeItem.getPSCODEITEMID();
                psCodeItem.setPSCODELISTID(psCodeList.getPSCODELISTID());
                psCodeItem.RemoveParam("PSCODEITEMID");
                psCodeItem.RemoveParam("PPSCODEITEMID");
                if (!StringHelper.IsNullOrEmpty((String)strParentId)) {
                    psCodeItem.setPPSCODEITEMID(strParentId);
                }
                if ((callResult = psCodeItemDataCtrl.Save(true, (BaseDataEntity)psCodeItem)).isError()) {
                    throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u4ee3\u7801\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psCodeItemIdMap.put(strOriginId, psCodeItem.getPSCODEITEMID());
            }
            PSCodeList psCodeList2 = new PSCodeList();
            psCodeList2.setPSCODELISTID(psCodeList.getPSCODELISTID());
            callResult = this.Save(false, psCodeList2);
            if (callResult.IsError()) {
                throw new Exception(StringHelper.Format((String)"\u4fdd\u6301\u4ee3\u7801\u8868\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psCodeList2.CopyTo(psCodeList, true);
        }
        catch (Exception ex) {
            log.error((Object)ex.getMessage(), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
        return callResult;
    }
}

