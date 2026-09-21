/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.XML.SimpleXMLWriter
 *  SA.SRFramework.XML.XMLNode
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.PS.Data.PSDEToolbar;
import SA.SRFDA.PS.Data.PSDEToolbarItem;
import SA.SRFDA.PS.Data.PSSysToolbarItem;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.XML.SimpleXMLWriter;
import SA.SRFramework.XML.XMLNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEToobarDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSDEToobarDataCtrl.class);
    public static final String CUSTOMCALL_INITFROMSYSTOOLBAR = "INITFROMSYSTOOLBAR";

    @Override
    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        try {
            if (!bInsert) {
                PSDEToolbar psDEToolbar = new PSDEToolbar();
                psDEToolbar.proxy(dataEntity);
                String strXML = dataEntity.getParamStringValue("TBMODEL", null);
                if (lastDataEntity != null && strXML != null) {
                    String strLastXML = lastDataEntity.getParamStringValue("TBMODEL", "");
                    if (StringHelper.Compare((String)(strXML = strXML.replace("\r\n", "\n")), (String)(strLastXML = strLastXML.replace("\r\n", "\n")), (boolean)true) != 0) {
                        HashMap<String, PSDEToolbarItem> validMap = new HashMap<String, PSDEToolbarItem>();
                        XMLNode xmlNode = XMLNode.LoadFromXML((String)strXML);
                        this.modifyLayoutFromXML(xmlNode, psDEToolbar, validMap);
                        BaseDataEntity cond = new BaseDataEntity();
                        cond.setParamValue("PSDETOOLBARID", (Object)psDEToolbar.getPSDETOOLBARID());
                        Vector psDEToolbarItemList = new Vector();
                        IDEDataCtrl psDEToolbarItemDataCtrl = this.GetRelatedDataCtrl("DE2207");
                        callResult = psDEToolbarItemDataCtrl.Select(cond, psDEToolbarItemList, PSDEToolbarItem.class.getName());
                        if (callResult.isError()) {
                            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5de5\u5177\u680f\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                        }
                        for (PSDEToolbarItem psDEToolbarItem : psDEToolbarItemList) {
                            if (validMap.containsKey(psDEToolbarItem.getPSDETBITEMID()) || this.CheckKeyState2(psDEToolbarItem) != 1 || !(callResult = psDEToolbarItemDataCtrl.Remove((BaseDataEntity)psDEToolbarItem)).isError()) continue;
                            throw new Exception(StringHelper.Format((String)"\u5220\u9664\u5de5\u5177\u680f\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                        }
                    }
                }
                XMLNode xmlNode = this.fillLayoutXMLNode(null, psDEToolbar);
                StringBuilder sb = new StringBuilder();
                SimpleXMLWriter writer = new SimpleXMLWriter(sb);
                writer.WriteRaw("<?xml version=\"1.0\" encoding=\"utf-8\" ?>\r\n");
                xmlNode.Save(writer);
                dataEntity.setParamValue("TBMODEL", (Object)sb.toString());
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

    protected void modifyLayoutFromXML(XMLNode xmlNode, PSDEToolbar psDEToolbar, HashMap<String, PSDEToolbarItem> validMap) throws Exception {
        ArrayList xmlNodes = xmlNode.getChildNodes();
        if (xmlNodes == null) {
            return;
        }
        IDEDataCtrl psDEToolbarItemDataCtrl = this.GetRelatedDataCtrl("DE2207");
        String strPNodeId = xmlNode.getID();
        int nIndex = 100;
        for (XMLNode childNode : xmlNodes) {
            String strNodeName = childNode.getNodeName();
            String strNodeId = childNode.getID();
            nIndex += 10;
            PSDEToolbarItem realItem = new PSDEToolbarItem();
            realItem.setPSDETOOLBARID(psDEToolbar.getPSDETOOLBARID());
            String strCaption = childNode.GetExtValue("CAPTION", null);
            if (strCaption != null) {
                realItem.setCAPTION(strCaption);
            }
            if (!StringHelper.IsNullOrEmpty((String)strNodeId)) {
                realItem.setPSDETBITEMID(strNodeId);
            }
            realItem.setTBITEMTYPE(strNodeName);
            if (!StringHelper.IsNullOrEmpty((String)strPNodeId)) {
                realItem.setPPSDETBITEMID(strPNodeId);
            }
            realItem.setParamValue("ORDERVALUE", nIndex);
            CallResult callResult = psDEToolbarItemDataCtrl.Save(StringHelper.IsNullOrEmpty((String)strNodeId), (BaseDataEntity)realItem);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u4fee\u6539\u5de5\u5177\u680f\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            childNode.setID(realItem.getPSDETBITEMID());
            validMap.put(realItem.getPSDETBITEMID(), realItem);
            this.modifyLayoutFromXML(childNode, psDEToolbar, validMap);
        }
    }

    protected XMLNode fillLayoutXMLNode(XMLNode xmlNode, PSDEToolbar psDEToolbar) throws Exception {
        if (xmlNode == null) {
            xmlNode = new XMLNode();
            xmlNode.setNodeName("DETOOLBAR");
        }
        BaseDataEntity cond = new BaseDataEntity();
        cond.setParamValue("PSDETOOLBARID", (Object)psDEToolbar.getPSDETOOLBARID());
        Vector psDEToolbarItemList = new Vector();
        IDEDataCtrl psDEToolbarItemDataCtrl = this.GetRelatedDataCtrl("DE2207");
        CallResult callResult = psDEToolbarItemDataCtrl.Select(cond, psDEToolbarItemList, PSDEToolbarItem.class.getName(), "ORDER BY ORDERVALUE");
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5de5\u5177\u680f\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        HashMap<String, PSDEToolbarItem> psDEToolbarItemMap = new HashMap<String, PSDEToolbarItem>();
        for (PSDEToolbarItem psDEToolbarItem : psDEToolbarItemList) {
            psDEToolbarItemMap.put(psDEToolbarItem.getPSDETBITEMID(), psDEToolbarItem);
        }
        for (PSDEToolbarItem psDEToolbarItem : psDEToolbarItemList) {
            if (StringHelper.IsNullOrEmpty((String)psDEToolbarItem.getPPSDETBITEMID())) continue;
            PSDEToolbarItem parentPSDEToolbarItem = (PSDEToolbarItem)((Object)psDEToolbarItemMap.get(psDEToolbarItem.getPPSDETBITEMID()));
            parentPSDEToolbarItem.getChildPSDEToolbarItems(true).add(psDEToolbarItem);
        }
        int nValue = 0;
        for (PSDEToolbarItem psDEToolbarItem : psDEToolbarItemList) {
            if (!StringHelper.IsNullOrEmpty((String)psDEToolbarItem.getPPSDETBITEMID())) continue;
            String strOrderString = PSDEToobarDataCtrl.getOrderString(++nValue);
            String strOrderString2 = PSDEToobarDataCtrl.getFullOrderString(strOrderString, 40);
            psDEToolbarItem.setLEVELTAG(strOrderString2);
            psDEToolbarItem.setLEVELVALUE(strOrderString.length() / 2);
            xmlNode.SetExtValue("ORDERTAG", strOrderString);
            psDEToolbarItemDataCtrl.Save(false, (BaseDataEntity)psDEToolbarItem);
            this.fillLayoutXMLNode(xmlNode, psDEToolbarItem);
        }
        return xmlNode;
    }

    protected XMLNode fillLayoutXMLNode(XMLNode xmlNode, PSDEToolbarItem psDEToolbarItem) throws Exception {
        XMLNode childXmlNode = new XMLNode();
        childXmlNode.setNodeName(psDEToolbarItem.getTBITEMTYPE());
        childXmlNode.SetProperty("ID", psDEToolbarItem.getPSDETBITEMID());
        childXmlNode.SetProperty("NAME", psDEToolbarItem.getPSDETBITEMNAME());
        childXmlNode.SetProperty("CAPTION", psDEToolbarItem.getCAPTION());
        xmlNode.AddNode(childXmlNode);
        ArrayList<PSDEToolbarItem> childPSDEToolbarItemList = psDEToolbarItem.getChildPSDEToolbarItems(false);
        if (childPSDEToolbarItemList != null) {
            int nValue = 0;
            IDEDataCtrl psDEToolbarItemDataCtrl = this.GetRelatedDataCtrl("DE2207");
            for (PSDEToolbarItem childPSDEToolbarItem : childPSDEToolbarItemList) {
                String strOrderString = String.valueOf(xmlNode.GetExtValue("ORDERTAG", "")) + PSDEToobarDataCtrl.getOrderString(++nValue);
                String strOrderString2 = PSDEToobarDataCtrl.getFullOrderString(strOrderString, 40);
                psDEToolbarItem.setLEVELTAG(strOrderString2);
                psDEToolbarItem.setLEVELVALUE(strOrderString.length() / 2);
                xmlNode.SetExtValue("ORDERTAG", strOrderString);
                psDEToolbarItemDataCtrl.Save(false, (BaseDataEntity)psDEToolbarItem);
                this.fillLayoutXMLNode(childXmlNode, childPSDEToolbarItem);
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
            PSDEToolbar psDEToolbar = new PSDEToolbar();
            psDEToolbar.Proxy(dataEntity);
            BaseDataEntity cond = new BaseDataEntity();
            cond.setParamValue("PSDETOOLBARID", srcKey);
            Vector<PSDEToolbarItem> psDEToolbarItemList = new Vector<PSDEToolbarItem>();
            IDEDataCtrl psDEToolbarItemDataCtrl = this.GetRelatedDataCtrl("DE2207");
            callResult = psDEToolbarItemDataCtrl.Select(cond, psDEToolbarItemList, PSDEToolbarItem.class.getName(), "ORDER BY ORDERVALUE");
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5de5\u5177\u680f\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            HashMap<String, String> psDEToolbarItemIdMap = new HashMap<String, String>();
            int nContinueCount = 0;
            while (psDEToolbarItemList.size() > 0) {
                String strParentId = "";
                PSDEToolbarItem psDEToolbarItem = (PSDEToolbarItem)((Object)psDEToolbarItemList.remove(0));
                if (!StringHelper.IsNullOrEmpty((String)psDEToolbarItem.getPPSDETBITEMID())) {
                    if (psDEToolbarItemIdMap.containsKey(psDEToolbarItem.getPPSDETBITEMID())) {
                        strParentId = (String)psDEToolbarItemIdMap.get(psDEToolbarItem.getPPSDETBITEMID());
                    } else {
                        psDEToolbarItemList.add(psDEToolbarItem);
                        if (++nContinueCount < psDEToolbarItemList.size()) continue;
                        throw new Exception(StringHelper.Format((String)"\u51fa\u73b0\u9012\u5f52\u6570\u636e"));
                    }
                }
                nContinueCount = 0;
                String strOriginId = psDEToolbarItem.getPSDETBITEMID();
                psDEToolbarItem.setPSDETOOLBARID(psDEToolbar.getPSDETOOLBARID());
                psDEToolbarItem.RemoveParam("PSDETBITEMID");
                psDEToolbarItem.RemoveParam("PPSDETBITEMID");
                if (!StringHelper.IsNullOrEmpty((String)strParentId)) {
                    psDEToolbarItem.setPPSDETBITEMID(strParentId);
                }
                if ((callResult = psDEToolbarItemDataCtrl.Save(true, (BaseDataEntity)psDEToolbarItem)).isError()) {
                    throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u5de5\u5177\u680f\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psDEToolbarItemIdMap.put(strOriginId, psDEToolbarItem.getPSDETBITEMID());
            }
            PSDEToolbar psDEToolbar2 = new PSDEToolbar();
            psDEToolbar2.setPSDETOOLBARID(psDEToolbar.getPSDETOOLBARID());
            callResult = this.Save(false, psDEToolbar2);
            if (callResult.IsError()) {
                throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u5de5\u5177\u680f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psDEToolbar2.CopyTo(psDEToolbar, true);
        }
        catch (Exception ex) {
            log.error((Object)ex.getMessage(), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
        return callResult;
    }

    @Override
    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_INITFROMSYSTOOLBAR, (boolean)true) == 0) {
            return this.initFromSysToolbar(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult initFromSysToolbar(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            PSDEToolbar psDEToolbar = new PSDEToolbar();
            psDEToolbar.proxy(dataEntity);
            this.onInitFromSysToolbar(psDEToolbar);
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().CommitAndBegin();
            }
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u521d\u59cb\u5316\u5b9e\u4f53\u5de5\u5177\u680f\u6a21\u578b\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onInitFromSysToolbar(PSDEToolbar psDEToolbar) throws Exception {
        BaseDataEntity cond = new BaseDataEntity();
        cond.setParamValue("PSDETOOLBARID", (Object)psDEToolbar.getPSDETOOLBARID());
        Vector psDEToolbarItemList = new Vector();
        IDEDataCtrl psDEToolbarItemDataCtrl = this.GetRelatedDataCtrl("DE2207");
        CallResult callResult = psDEToolbarItemDataCtrl.Select(cond, psDEToolbarItemList, PSDEToolbarItem.class.getName());
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5de5\u5177\u680f\u5b50\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        if (psDEToolbarItemList.size() > 0) {
            throw new Exception(StringHelper.Format((String)"\u5de5\u5177\u680f\u5b58\u5728\u5b50\u9879\uff0c\u4e0d\u80fd\u521d\u59cb\u5316"));
        }
        cond.Reset();
        cond.setParamValue("PSSYSTOOLBARID", (Object)psDEToolbar.getPSSYSTOOLBARID());
        Vector<PSSysToolbarItem> psSysToolbarItemList = new Vector<PSSysToolbarItem>();
        IDEDataCtrl psSysToolbarItemDataCtrl = this.GetRelatedDataCtrl("DE1621");
        callResult = psSysToolbarItemDataCtrl.Select(cond, psSysToolbarItemList, PSSysToolbarItem.class.getName());
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u4e91\u5e73\u53f0\u5de5\u5177\u680f\u5b50\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        HashMap<String, String> toolbarItemMap = new HashMap<String, String>();
        while (psSysToolbarItemList.size() > 0) {
            String strPSSysUIActionId;
            String strPPDEToolbarItemId = "";
            PSSysToolbarItem psSysToolbarItem = (PSSysToolbarItem)((Object)psSysToolbarItemList.remove(0));
            if (!StringHelper.IsNullOrEmpty((String)psSysToolbarItem.getPPSSYSTBITEMID()) && StringHelper.IsNullOrEmpty((String)(strPPDEToolbarItemId = (String)toolbarItemMap.get(psSysToolbarItem.getPPSSYSTBITEMID())))) {
                psSysToolbarItemList.add(psSysToolbarItem);
                continue;
            }
            PSDEToolbarItem psDEToolbarItem = new PSDEToolbarItem();
            psSysToolbarItem.CopyTo(psDEToolbarItem, true);
            psDEToolbarItem.setPSDETOOLBARID(psDEToolbar.getPSDETOOLBARID());
            if (!StringHelper.IsNullOrEmpty((String)strPPDEToolbarItemId)) {
                psDEToolbarItem.setPPSDETBITEMID(strPPDEToolbarItemId);
            }
            if (!StringHelper.IsNullOrEmpty((String)(strPSSysUIActionId = psSysToolbarItem.getPSSYSUIACTIONID()))) {
                String strPSDEUIActionId = Helper.GenUniqueId((String)psDEToolbar.getPSSYSTEMID(), (String)strPSSysUIActionId);
                psDEToolbarItem.setPSDEUIACTIONID(strPSDEUIActionId);
            }
            if ((callResult = psDEToolbarItemDataCtrl.Save(true, (BaseDataEntity)psDEToolbarItem)).isError()) {
                throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u5de5\u5177\u680f\u5b50\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            toolbarItemMap.put(psSysToolbarItem.getPSSYSTBITEMID(), psDEToolbarItem.getPSDETBITEMID());
        }
        callResult = this.Save(false, psDEToolbar);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u5de5\u5177\u680f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
    }
}

