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
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEJoinType;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.PS.Data.PSDEDataQueryCond;
import SA.SRFDA.PS.Data.PSDEDataQueryJoin;
import SA.SRFDA.PS.Data.PSDEField;
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

public class PSDEDataQueryJoinDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSDEDataQueryJoinDataCtrl.class);

    @Override
    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        try {
            PSDEDataQueryJoin psDEDataQueryJoin = new PSDEDataQueryJoin();
            psDEDataQueryJoin.proxy(dataEntity);
            if (!StringHelper.IsNullOrEmpty((String)psDEDataQueryJoin.getPSDEJOINTYPEID())) {
                IPSDEJoinType iPSDEJoinType = this.getPSModelStorage().getPSDEJoinType(psDEDataQueryJoin.getPSDEJOINTYPEID());
                String strPSDEName = psDEDataQueryJoin.getPSDEDQJOINNAME();
                psDEDataQueryJoin.setPSDEDQJOINNAME(StringHelper.Format((String)"[%1$s]%2$s", (Object)iPSDEJoinType.getName(), (Object)strPSDEName));
            }
            if (!bInsert) {
                String strXML = dataEntity.getParamStringValue("CONDMODEL", "");
                if (lastDataEntity != null) {
                    strXML = strXML.replace("\r\n", "\n");
                    String strLastXML = lastDataEntity.getParamStringValue("CONDMODEL", "");
                    if (StringHelper.Compare((String)strXML, (String)(strLastXML = strLastXML.replace("\r\n", "\n")), (boolean)true) != 0) {
                        HashMap<String, PSDEDataQueryCond> validMap = new HashMap<String, PSDEDataQueryCond>();
                        XMLNode xmlNode = XMLNode.LoadFromXML((String)strXML);
                        this.modifyLayoutFromXML(xmlNode, psDEDataQueryJoin, validMap);
                        BaseDataEntity cond = new BaseDataEntity();
                        cond.setParamValue("PSDEDQJOINID", (Object)psDEDataQueryJoin.getPSDEDQJOINID());
                        Vector<PSDEDataQueryCond> psDEDataQueryCondList = new Vector<>();
                        IDEDataCtrl psDEDataQueryCondDataCtrl = this.GetRelatedDataCtrl("DE2059");
                        callResult = psDEDataQueryCondDataCtrl.Select(cond, psDEDataQueryCondList, PSDEDataQueryCond.class.getName());
                        if (callResult.isError()) {
                            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u67e5\u8be2\u6761\u4ef6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                        }
                        for (PSDEDataQueryCond psDEDataQueryCond : psDEDataQueryCondList) {
                            if (validMap.containsKey(psDEDataQueryCond.getPSDEDQCONDID()) || this.CheckKeyState2(psDEDataQueryCond) != 1 || !(callResult = psDEDataQueryCondDataCtrl.Remove((BaseDataEntity)psDEDataQueryCond)).isError()) continue;
                            throw new Exception(StringHelper.Format((String)"\u5220\u9664\u67e5\u8be2\u6761\u4ef6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                        }
                    }
                }
                XMLNode xmlNode = this.fillLayoutXMLNode(null, psDEDataQueryJoin);
                StringBuilder sb = new StringBuilder();
                SimpleXMLWriter writer = new SimpleXMLWriter(sb);
                writer.WriteRaw("<?xml version=\"1.0\" encoding=\"utf-8\" ?>\r\n");
                xmlNode.Save(writer);
                dataEntity.setParamValue("CONDMODEL", (Object)sb.toString());
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

    protected void modifyLayoutFromXML(XMLNode xmlNode, PSDEDataQueryJoin psDEDataQueryJoin, HashMap<String, PSDEDataQueryCond> validMap) throws Exception {
        ArrayList<XMLNode> xmlNodes = xmlNode.getChildNodes();
        if (xmlNodes == null) {
            return;
        }
        IDEDataCtrl psDEDataQueryCondDataCtrl = this.GetRelatedDataCtrl("DE2059");
        String strPNodeId = xmlNode.getID();
        int nIndex = 100;
        for (XMLNode childNode : xmlNodes) {
            String strNodeName = childNode.getNodeName();
            String strNodeId = childNode.getID();
            nIndex += 10;
            PSDEDataQueryCond realItem = new PSDEDataQueryCond();
            realItem.setPSDEDQJOINID(psDEDataQueryJoin.getPSDEDQJOINID());
            realItem.setPSDEID(psDEDataQueryJoin.getJOINPSDEID());
            if (!StringHelper.IsNullOrEmpty((String)strNodeId)) {
                realItem.setPSDEDQCONDID(strNodeId);
            } else if (StringHelper.Compare((String)strNodeName, (String)"SINGLE", (boolean)true) == 0) {
                String strDEFieldName = childNode.GetExtValue("DEFNAME", "").toUpperCase();
                PSDEField psDEField = new PSDEField();
                psDEField.setPSDEID(psDEDataQueryJoin.getJOINPSDEID());
                psDEField.setPSDEFIELDNAME(strDEFieldName);
                IDEDataCtrl psDEFieldDataCtrl = this.GetRelatedDataCtrl("DE2051");
                CallResult callResult = psDEFieldDataCtrl.Select((BaseDataEntity)psDEField);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u4e91\u5b9e\u4f53\u5c5e\u6027[%1$s:%2$s]", (Object)psDEDataQueryJoin.getJOINPSDENAME(), (Object)strDEFieldName));
                }
                realItem.setPSDEFID(psDEField.getPSDEFIELDID());
                realItem.setPSDEFNAME(psDEField.getPSDEFIELDNAME());
            }
            realItem.setCONDTYPE(strNodeName);
            if (!StringHelper.IsNullOrEmpty((String)strPNodeId)) {
                realItem.setPPSDEDQCONDID(strPNodeId);
            }
            realItem.setParamValue("ORDERVALUE", nIndex);
            CallResult callResult = psDEDataQueryCondDataCtrl.Save(StringHelper.IsNullOrEmpty((String)strNodeId), (BaseDataEntity)realItem);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u4fee\u6539\u67e5\u8be2\u6761\u4ef6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            childNode.setID(realItem.getPSDEDQCONDID());
            validMap.put(realItem.getPSDEDQCONDID(), realItem);
            this.modifyLayoutFromXML(childNode, psDEDataQueryJoin, validMap);
        }
    }

    protected XMLNode fillLayoutXMLNode(XMLNode xmlNode, PSDEDataQueryJoin psDEDataQueryJoin) throws Exception {
        if (xmlNode == null) {
            xmlNode = new XMLNode();
            xmlNode.setNodeName("DEDATAQUERY");
        }
        BaseDataEntity cond = new BaseDataEntity();
        cond.setParamValue("PSDEDQJOINID", (Object)psDEDataQueryJoin.getPSDEDQJOINID());
        Vector<PSDEDataQueryCond> psDEDataQueryCondList = new Vector<>();
        IDEDataCtrl psDEDataQueryCondDataCtrl = this.GetRelatedDataCtrl("DE2059");
        CallResult callResult = psDEDataQueryCondDataCtrl.Select(cond, psDEDataQueryCondList, PSDEDataQueryCond.class.getName(), "ORDER BY ORDERVALUE");
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u67e5\u8be2\u6761\u4ef6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        HashMap<String, PSDEDataQueryCond> psDEDataQueryCondMap = new HashMap<String, PSDEDataQueryCond>();
        for (PSDEDataQueryCond psDEDataQueryCond : psDEDataQueryCondList) {
            psDEDataQueryCondMap.put(psDEDataQueryCond.getPSDEDQCONDID(), psDEDataQueryCond);
        }
        for (PSDEDataQueryCond psDEDataQueryCond : psDEDataQueryCondList) {
            if (StringHelper.IsNullOrEmpty((String)psDEDataQueryCond.getPPSDEDQCONDID())) continue;
            PSDEDataQueryCond parentPSDEDataQueryCond = (PSDEDataQueryCond)((Object)psDEDataQueryCondMap.get(psDEDataQueryCond.getPPSDEDQCONDID()));
            parentPSDEDataQueryCond.getChildPSDEDataQueryConds(true).add(psDEDataQueryCond);
        }
        int nValue = 0;
        for (PSDEDataQueryCond psDEDataQueryCond : psDEDataQueryCondList) {
            if (!StringHelper.IsNullOrEmpty((String)psDEDataQueryCond.getPPSDEDQCONDID())) continue;
            String strOrderString = PSDEDataQueryJoinDataCtrl.getOrderString(++nValue);
            String strOrderString2 = PSDEDataQueryJoinDataCtrl.getFullOrderString(strOrderString, 40);
            psDEDataQueryCond.setLEVELTAG(strOrderString2);
            psDEDataQueryCond.setLEVELVALUE(strOrderString.length() / 2 - 1);
            xmlNode.SetExtValue("ORDERTAG", strOrderString);
            psDEDataQueryCondDataCtrl.Save(false, (BaseDataEntity)psDEDataQueryCond);
            this.fillLayoutXMLNode(xmlNode, psDEDataQueryCond);
        }
        return xmlNode;
    }

    protected XMLNode fillLayoutXMLNode(XMLNode xmlNode, PSDEDataQueryCond psDEDataQueryCond) throws Exception {
        XMLNode childXmlNode = new XMLNode();
        childXmlNode.setNodeName(psDEDataQueryCond.getCONDTYPE());
        childXmlNode.SetProperty("ID", psDEDataQueryCond.getPSDEDQCONDID());
        childXmlNode.SetProperty("NAME", psDEDataQueryCond.getPSDEDQCONDNAME());
        xmlNode.AddNode(childXmlNode);
        ArrayList<PSDEDataQueryCond> childPSDEDataQueryCondList = psDEDataQueryCond.getChildPSDEDataQueryConds(false);
        if (childPSDEDataQueryCondList != null) {
            int nValue = 0;
            IDEDataCtrl psDEDataQueryCondDataCtrl = this.GetRelatedDataCtrl("DE2059");
            for (PSDEDataQueryCond childPSDEDataQueryCond : childPSDEDataQueryCondList) {
                String strOrderString = String.valueOf(xmlNode.GetExtValue("ORDERTAG", "")) + PSDEDataQueryJoinDataCtrl.getOrderString(++nValue);
                String strOrderString2 = PSDEDataQueryJoinDataCtrl.getFullOrderString(strOrderString, 40);
                childPSDEDataQueryCond.setLEVELTAG(strOrderString2);
                childPSDEDataQueryCond.setLEVELVALUE(strOrderString.length() / 2 - 1);
                childXmlNode.SetExtValue("ORDERTAG", strOrderString);
                psDEDataQueryCondDataCtrl.Save(false, (BaseDataEntity)childPSDEDataQueryCond);
                this.fillLayoutXMLNode(childXmlNode, childPSDEDataQueryCond);
            }
        }
        return childXmlNode;
    }

    protected CallResult OnAfterSaveOK(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnAfterSaveOK(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        PSDEDataQueryJoin psDEDataQueryJoin = new PSDEDataQueryJoin();
        psDEDataQueryJoin.proxy(dataEntity);
        try {
            if (bInsert) {
                PSDEDataQueryCond psDEDataQueryCond = new PSDEDataQueryCond();
                psDEDataQueryCond.setPSDEDQID(psDEDataQueryJoin.getPSDEDQID());
                psDEDataQueryCond.setPSDEDQJOINID(psDEDataQueryJoin.getPSDEDQJOINID());
                psDEDataQueryCond.setCONDTYPE("GROUP");
                psDEDataQueryCond.setGROUPOP("AND");
                IDEDataCtrl psDEDataQueryCondDataCtrl = this.GetRelatedDataCtrl("DE2059");
                callResult = psDEDataQueryCondDataCtrl.Save(true, (BaseDataEntity)psDEDataQueryCond);
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
}
