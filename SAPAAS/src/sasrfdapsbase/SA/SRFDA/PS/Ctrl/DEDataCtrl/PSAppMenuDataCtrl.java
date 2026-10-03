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
import SA.SRFDA.PS.Data.PSAppMenu;
import SA.SRFDA.PS.Data.PSAppMenuItem;
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

public class PSAppMenuDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSAppMenuDataCtrl.class);

    @Override
    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        try {
            if (!bInsert) {
                String strLastXML;
                PSAppMenu psAppMenu = new PSAppMenu();
                psAppMenu.proxy(dataEntity);
                String strXML = dataEntity.getParamStringValue("MENUMODEL", null);
                if (lastDataEntity != null && strXML != null && StringHelper.Compare((String)strXML, (String)(strLastXML = lastDataEntity.getParamStringValue("MENUMODEL", "")), (boolean)true) != 0) {
                    HashMap<String, PSAppMenuItem> validMap = new HashMap<String, PSAppMenuItem>();
                    XMLNode xmlNode = XMLNode.LoadFromXML((String)strXML);
                    this.modifyLayoutFromXML(xmlNode, psAppMenu, validMap);
                    BaseDataEntity cond = new BaseDataEntity();
                    cond.setParamValue("PSAPPMENUID", (Object)psAppMenu.getPSAPPMENUID());
                    Vector<PSAppMenuItem> psAppMenuItemList = new Vector<>();
                    IDEDataCtrl psAppMenuItemDataCtrl = this.GetRelatedDataCtrl("DE2521");
                    callResult = psAppMenuItemDataCtrl.Select(cond, psAppMenuItemList, PSAppMenuItem.class.getName());
                    if (callResult.isError()) {
                        throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u83dc\u5355\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                    for (PSAppMenuItem psAppMenuItem : psAppMenuItemList) {
                        if (validMap.containsKey(psAppMenuItem.getPSAPPMENUITEMID()) || this.CheckKeyState2(psAppMenuItem) != 1 || !(callResult = psAppMenuItemDataCtrl.Remove((BaseDataEntity)psAppMenuItem)).isError()) continue;
                        throw new Exception(StringHelper.Format((String)"\u5220\u9664\u5e94\u7528\u83dc\u5355\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                }
                XMLNode xmlNode = this.fillLayoutXMLNode(null, psAppMenu);
                StringBuilder sb = new StringBuilder();
                SimpleXMLWriter writer = new SimpleXMLWriter(sb);
                writer.WriteRaw("<?xml version=\"1.0\" encoding=\"utf-8\" ?>\r\n");
                xmlNode.Save(writer);
                dataEntity.setParamValue("MENUMODEL", (Object)sb.toString());
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

    protected void modifyLayoutFromXML(XMLNode xmlNode, PSAppMenu psAppMenu, HashMap<String, PSAppMenuItem> validMap) throws Exception {
        ArrayList<XMLNode> xmlNodes = xmlNode.getChildNodes();
        if (xmlNodes == null) {
            return;
        }
        IDEDataCtrl psAppMenuItemDataCtrl = this.GetRelatedDataCtrl("DE2521");
        String strPNodeId = xmlNode.getID();
        int nIndex = 100;
        for (XMLNode childNode : xmlNodes) {
            String strNodeName = childNode.getNodeName();
            String strNodeId = childNode.getID();
            nIndex += 10;
            PSAppMenuItem realItem = new PSAppMenuItem();
            realItem.setPSAPPMENUID(psAppMenu.getPSAPPMENUID());
            String strCaption = childNode.GetExtValue("CAPTION", null);
            if (strCaption != null) {
                realItem.setCAPTION(strCaption);
            }
            if (!StringHelper.IsNullOrEmpty((String)strNodeId)) {
                realItem.setPSAPPMENUITEMID(strNodeId);
            }
            realItem.setAMITEMTYPE(strNodeName);
            if (!StringHelper.IsNullOrEmpty((String)strPNodeId)) {
                realItem.setPPSAPPMENUITEMID(strPNodeId);
            }
            realItem.setParamValue("ORDERVALUE", nIndex);
            CallResult callResult = psAppMenuItemDataCtrl.Save(StringHelper.IsNullOrEmpty((String)strNodeId), (BaseDataEntity)realItem);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u4fee\u6539\u5e94\u7528\u83dc\u5355\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            childNode.setID(realItem.getPSAPPMENUITEMID());
            validMap.put(realItem.getPSAPPMENUITEMID(), realItem);
            this.modifyLayoutFromXML(childNode, psAppMenu, validMap);
        }
    }

    protected XMLNode fillLayoutXMLNode(XMLNode xmlNode, PSAppMenu psAppMenu) throws Exception {
        if (xmlNode == null) {
            xmlNode = new XMLNode();
            xmlNode.setNodeName("APPMENU");
        }
        BaseDataEntity cond = new BaseDataEntity();
        cond.setParamValue("PSAPPMENUID", (Object)psAppMenu.getPSAPPMENUID());
        Vector<PSAppMenuItem> psAppMenuItemList = new Vector<>();
        IDEDataCtrl psAppMenuItemDataCtrl = this.GetRelatedDataCtrl("DE2521");
        CallResult callResult = psAppMenuItemDataCtrl.Select(cond, psAppMenuItemList, PSAppMenuItem.class.getName(), "ORDER BY ORDERVALUE");
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u83dc\u5355\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        HashMap<String, PSAppMenuItem> psAppMenuItemMap = new HashMap<String, PSAppMenuItem>();
        for (PSAppMenuItem psAppMenuItem : psAppMenuItemList) {
            psAppMenuItemMap.put(psAppMenuItem.getPSAPPMENUITEMID(), psAppMenuItem);
        }
        for (PSAppMenuItem psAppMenuItem : psAppMenuItemList) {
            if (StringHelper.IsNullOrEmpty((String)psAppMenuItem.getPPSAPPMENUITEMID())) continue;
            PSAppMenuItem parentPSAppMenuItem = (PSAppMenuItem)((Object)psAppMenuItemMap.get(psAppMenuItem.getPPSAPPMENUITEMID()));
            parentPSAppMenuItem.getChildPSAppMenuItems(true).add(psAppMenuItem);
        }
        int nValue = 0;
        for (PSAppMenuItem psAppMenuItem : psAppMenuItemList) {
            if (!StringHelper.IsNullOrEmpty((String)psAppMenuItem.getPPSAPPMENUITEMID())) continue;
            String strOrderString = PSAppMenuDataCtrl.getOrderString(++nValue);
            String strOrderString2 = PSAppMenuDataCtrl.getFullOrderString(strOrderString, 40);
            psAppMenuItem.setLEVELTAG(strOrderString2);
            psAppMenuItem.setLEVELVALUE(strOrderString.length() / 2);
            xmlNode.SetExtValue("ORDERTAG", strOrderString);
            psAppMenuItemDataCtrl.Save(false, (BaseDataEntity)psAppMenuItem);
            this.fillLayoutXMLNode(xmlNode, psAppMenuItem);
        }
        return xmlNode;
    }

    protected XMLNode fillLayoutXMLNode(XMLNode xmlNode, PSAppMenuItem psAppMenuItem) throws Exception {
        XMLNode childXmlNode = new XMLNode();
        childXmlNode.setNodeName(psAppMenuItem.getAMITEMTYPE());
        childXmlNode.SetProperty("ID", psAppMenuItem.getPSAPPMENUITEMID());
        childXmlNode.SetProperty("NAME", psAppMenuItem.getPSAPPMENUITEMNAME());
        childXmlNode.SetProperty("CAPTION", psAppMenuItem.getCAPTION());
        xmlNode.AddNode(childXmlNode);
        ArrayList<PSAppMenuItem> childPSAppMenuItemList = psAppMenuItem.getChildPSAppMenuItems(false);
        if (childPSAppMenuItemList != null) {
            int nValue = 0;
            IDEDataCtrl psAppMenuItemDataCtrl = this.GetRelatedDataCtrl("DE2521");
            for (PSAppMenuItem childPSAppMenuItem : childPSAppMenuItemList) {
                String strOrderString = String.valueOf(xmlNode.GetExtValue("ORDERTAG", "")) + PSAppMenuDataCtrl.getOrderString(++nValue);
                String strOrderString2 = PSAppMenuDataCtrl.getFullOrderString(strOrderString, 40);
                psAppMenuItem.setLEVELTAG(strOrderString2);
                psAppMenuItem.setLEVELVALUE(strOrderString.length() / 2);
                xmlNode.SetExtValue("ORDERTAG", strOrderString);
                psAppMenuItemDataCtrl.Save(false, (BaseDataEntity)psAppMenuItem);
                this.fillLayoutXMLNode(childXmlNode, childPSAppMenuItem);
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
            PSAppMenu psAppMenu = new PSAppMenu();
            psAppMenu.Proxy(dataEntity);
            BaseDataEntity cond = new BaseDataEntity();
            cond.setParamValue("PSAPPMENUID", srcKey);
            Vector<PSAppMenuItem> psAppMenuItemList = new Vector<PSAppMenuItem>();
            IDEDataCtrl psAppMenuItemDataCtrl = this.GetRelatedDataCtrl("DE2521");
            callResult = psAppMenuItemDataCtrl.Select(cond, psAppMenuItemList, PSAppMenuItem.class.getName(), "ORDER BY ORDERVALUE");
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u83dc\u5355\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            HashMap<String, String> psAppMenuItemIdMap = new HashMap<String, String>();
            int nContinueCount = 0;
            while (psAppMenuItemList.size() > 0) {
                String strParentId = "";
                PSAppMenuItem psAppMenuItem = (PSAppMenuItem)((Object)psAppMenuItemList.remove(0));
                if (!StringHelper.IsNullOrEmpty((String)psAppMenuItem.getPPSAPPMENUITEMID())) {
                    if (psAppMenuItemIdMap.containsKey(psAppMenuItem.getPPSAPPMENUITEMID())) {
                        strParentId = (String)psAppMenuItemIdMap.get(psAppMenuItem.getPPSAPPMENUITEMID());
                    } else {
                        psAppMenuItemList.add(psAppMenuItem);
                        if (++nContinueCount < psAppMenuItemList.size()) continue;
                        throw new Exception(StringHelper.Format((String)"\u51fa\u73b0\u9012\u5f52\u6570\u636e"));
                    }
                }
                nContinueCount = 0;
                String strOriginId = psAppMenuItem.getPSAPPMENUITEMID();
                psAppMenuItem.setPSAPPMENUID(psAppMenu.getPSAPPMENUID());
                psAppMenuItem.RemoveParam("PSAPPMENUITEMID");
                psAppMenuItem.RemoveParam("PPSAPPMENUITEMID");
                if (!StringHelper.IsNullOrEmpty((String)strParentId)) {
                    psAppMenuItem.setPPSAPPMENUITEMID(strParentId);
                }
                if ((callResult = psAppMenuItemDataCtrl.Save(true, (BaseDataEntity)psAppMenuItem)).isError()) {
                    throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u5e94\u7528\u83dc\u5355\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psAppMenuItemIdMap.put(strOriginId, psAppMenuItem.getPSAPPMENUITEMID());
            }
            PSAppMenu psAppMenu2 = new PSAppMenu();
            psAppMenu2.setPSAPPMENUID(psAppMenu.getPSAPPMENUID());
            callResult = this.Save(false, psAppMenu2);
            if (callResult.IsError()) {
                throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u5e94\u7528\u83dc\u5355\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psAppMenu2.CopyTo(psAppMenu, true);
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
