/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.TBTempl
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.XML.XMLNode
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.Data.TBTempl;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.PS.Data.PSSysToolbar;
import SA.SRFDA.PS.Data.PSSysToolbarItem;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.XML.XMLNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysToobarDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSSysToobarDataCtrl.class);
    public static final String CUSTOMCALL_INITFROMTBTEMPL = "INITFROMTBTEMPL";

    @Override
    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        return callResult;
    }

    protected void modifyLayoutFromXML(XMLNode xmlNode, PSSysToolbar psSysToolbar, HashMap<String, PSSysToolbarItem> validMap) throws Exception {
        ArrayList xmlNodes = xmlNode.getChildNodes();
        if (xmlNodes == null) {
            return;
        }
        IDEDataCtrl psSysToolbarItemDataCtrl = this.GetRelatedDataCtrl("DE1621");
        String strPNodeId = xmlNode.getID();
        int nIndex = 100;
        for (XMLNode childNode : xmlNodes) {
            String strNodeName = childNode.getNodeName();
            String strNodeId = childNode.getID();
            nIndex += 10;
            PSSysToolbarItem realItem = new PSSysToolbarItem();
            realItem.setPSSYSTOOLBARID(psSysToolbar.getPSSYSTOOLBARID());
            String strCaption = childNode.GetExtValue("CAPTION", null);
            if (strCaption != null) {
                realItem.setCAPTION(strCaption);
            }
            if (!StringHelper.IsNullOrEmpty((String)strNodeId)) {
                realItem.setPSSYSTBITEMID(strNodeId);
            }
            if (!StringHelper.IsNullOrEmpty((String)strPNodeId)) {
                realItem.setPPSSYSTBITEMID(strPNodeId);
            }
            realItem.setParamValue("ORDERVALUE", nIndex);
            CallResult callResult = psSysToolbarItemDataCtrl.Save(StringHelper.IsNullOrEmpty((String)strNodeId), (BaseDataEntity)realItem);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u4fee\u6539\u5de5\u5177\u680f\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            childNode.setID(realItem.getPSSYSTBITEMID());
            validMap.put(realItem.getPSSYSTBITEMID(), realItem);
            this.modifyLayoutFromXML(childNode, psSysToolbar, validMap);
        }
    }

    protected XMLNode fillLayoutXMLNode(XMLNode xmlNode, PSSysToolbar psSysToolbar) throws Exception {
        if (xmlNode == null) {
            xmlNode = new XMLNode();
            xmlNode.setNodeName("SYSTOOLBAR");
        }
        BaseDataEntity cond = new BaseDataEntity();
        cond.setParamValue("PSSYSTOOLBARID", (Object)psSysToolbar.getPSSYSTOOLBARID());
        Vector psSysToolbarItemList = new Vector();
        IDEDataCtrl psSysToolbarItemDataCtrl = this.GetRelatedDataCtrl("DE1621");
        CallResult callResult = psSysToolbarItemDataCtrl.Select(cond, psSysToolbarItemList, PSSysToolbarItem.class.getName(), "ORDER BY ORDERVALUE");
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5de5\u5177\u680f\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        HashMap<String, PSSysToolbarItem> psSysToolbarItemMap = new HashMap<String, PSSysToolbarItem>();
        for (PSSysToolbarItem psSysToolbarItem : psSysToolbarItemList) {
            psSysToolbarItemMap.put(psSysToolbarItem.getPSSYSTBITEMID(), psSysToolbarItem);
        }
        for (PSSysToolbarItem psSysToolbarItem : psSysToolbarItemList) {
            if (StringHelper.IsNullOrEmpty((String)psSysToolbarItem.getPPSSYSTBITEMID())) continue;
            PSSysToolbarItem parentPSSysToolbarItem = (PSSysToolbarItem)((Object)psSysToolbarItemMap.get(psSysToolbarItem.getPPSSYSTBITEMID()));
            parentPSSysToolbarItem.getChildPSSysToolbarItems(true).add(psSysToolbarItem);
        }
        int nValue = 0;
        for (PSSysToolbarItem psSysToolbarItem : psSysToolbarItemList) {
            if (!StringHelper.IsNullOrEmpty((String)psSysToolbarItem.getPPSSYSTBITEMID())) continue;
            String strOrderString = PSSysToobarDataCtrl.getOrderString(++nValue);
            String strOrderString2 = PSSysToobarDataCtrl.getFullOrderString(strOrderString, 40);
            psSysToolbarItem.setLEVELTAG(strOrderString2);
            psSysToolbarItem.setLEVELVALUE(strOrderString.length() / 2);
            xmlNode.SetExtValue("ORDERTAG", strOrderString);
            psSysToolbarItemDataCtrl.Save(false, (BaseDataEntity)psSysToolbarItem);
            this.fillLayoutXMLNode(xmlNode, psSysToolbarItem);
        }
        return xmlNode;
    }

    protected XMLNode fillLayoutXMLNode(XMLNode xmlNode, PSSysToolbarItem psSysToolbarItem) throws Exception {
        XMLNode childXmlNode = new XMLNode();
        childXmlNode.setNodeName(psSysToolbarItem.getTBITEMTYPE());
        childXmlNode.SetProperty("ID", psSysToolbarItem.getPSSYSTBITEMID());
        childXmlNode.SetProperty("NAME", psSysToolbarItem.getPSSYSTBITEMNAME());
        childXmlNode.SetProperty("CAPTION", psSysToolbarItem.getCAPTION());
        xmlNode.AddNode(childXmlNode);
        ArrayList<PSSysToolbarItem> childPSSysToolbarItemList = psSysToolbarItem.getChildPSSysToolbarItems(false);
        if (childPSSysToolbarItemList != null) {
            int nValue = 0;
            IDEDataCtrl psSysToolbarItemDataCtrl = this.GetRelatedDataCtrl("DE1621");
            for (PSSysToolbarItem childPSSysToolbarItem : childPSSysToolbarItemList) {
                String strOrderString = String.valueOf(xmlNode.GetExtValue("ORDERTAG", "")) + PSSysToobarDataCtrl.getOrderString(++nValue);
                String strOrderString2 = PSSysToobarDataCtrl.getFullOrderString(strOrderString, 40);
                psSysToolbarItem.setLEVELTAG(strOrderString2);
                psSysToolbarItem.setLEVELVALUE(strOrderString.length() / 2);
                xmlNode.SetExtValue("ORDERTAG", strOrderString);
                psSysToolbarItemDataCtrl.Save(false, (BaseDataEntity)psSysToolbarItem);
                this.fillLayoutXMLNode(childXmlNode, childPSSysToolbarItem);
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
            PSSysToolbar psSysToolbar = new PSSysToolbar();
            psSysToolbar.Proxy(dataEntity);
            BaseDataEntity cond = new BaseDataEntity();
            cond.setParamValue("PSSYSTOOLBARID", srcKey);
            Vector<PSSysToolbarItem> psSysToolbarItemList = new Vector<PSSysToolbarItem>();
            IDEDataCtrl psSysToolbarItemDataCtrl = this.GetRelatedDataCtrl("DE1621");
            callResult = psSysToolbarItemDataCtrl.Select(cond, psSysToolbarItemList, PSSysToolbarItem.class.getName(), "ORDER BY ORDERVALUE");
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5de5\u5177\u680f\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            HashMap<String, String> psSysToolbarItemIdMap = new HashMap<String, String>();
            int nContinueCount = 0;
            while (psSysToolbarItemList.size() > 0) {
                String strParentId = "";
                PSSysToolbarItem psSysToolbarItem = (PSSysToolbarItem)((Object)psSysToolbarItemList.remove(0));
                if (!StringHelper.IsNullOrEmpty((String)psSysToolbarItem.getPPSSYSTBITEMID())) {
                    if (psSysToolbarItemIdMap.containsKey(psSysToolbarItem.getPPSSYSTBITEMID())) {
                        strParentId = (String)psSysToolbarItemIdMap.get(psSysToolbarItem.getPPSSYSTBITEMID());
                    } else {
                        psSysToolbarItemList.add(psSysToolbarItem);
                        if (++nContinueCount < psSysToolbarItemList.size()) continue;
                        throw new Exception(StringHelper.Format((String)"\u51fa\u73b0\u9012\u5f52\u6570\u636e"));
                    }
                }
                nContinueCount = 0;
                String strOriginId = psSysToolbarItem.getPSSYSTBITEMID();
                psSysToolbarItem.setPSSYSTOOLBARID(psSysToolbar.getPSSYSTOOLBARID());
                psSysToolbarItem.RemoveParam("PSSYSTBITEMID");
                psSysToolbarItem.RemoveParam("PPSSYSTBITEMID");
                if (!StringHelper.IsNullOrEmpty((String)strParentId)) {
                    psSysToolbarItem.setPPSSYSTBITEMID(strParentId);
                }
                if ((callResult = psSysToolbarItemDataCtrl.Save(true, (BaseDataEntity)psSysToolbarItem)).isError()) {
                    throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u5de5\u5177\u680f\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysToolbarItemIdMap.put(strOriginId, psSysToolbarItem.getPSSYSTBITEMID());
            }
            PSSysToolbar psSysToolbar2 = new PSSysToolbar();
            psSysToolbar2.setPSSYSTOOLBARID(psSysToolbar.getPSSYSTOOLBARID());
            callResult = this.Save(false, psSysToolbar2);
            if (callResult.IsError()) {
                throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u5de5\u5177\u680f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysToolbar2.CopyTo(psSysToolbar, true);
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
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_INITFROMTBTEMPL, (boolean)true) == 0) {
            return this.initFromTBTempl(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult initFromTBTempl(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            PSSysToolbar psSysToolbar = new PSSysToolbar();
            psSysToolbar.proxy(dataEntity);
            this.onInitFromTBTempl(psSysToolbar);
            callResult = this.Save(false, psSysToolbar);
            if (callResult.IsError()) {
                throw new Exception(StringHelper.Format((String)"\u66f4\u65b0\u5de5\u5177\u680f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().CommitAndBegin();
            }
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u4ece\u5de5\u5177\u680f\u6a21\u7248\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onInitFromTBTempl(PSSysToolbar psSysToolbar) throws Exception {
        BaseDataEntity cond = new BaseDataEntity();
        cond.setParamValue("PSSYSTOOLBARID", (Object)psSysToolbar.getPSSYSTOOLBARID());
        Vector psSysToolbarItemList = new Vector();
        IDEDataCtrl psSysToolbarItemDataCtrl = this.GetRelatedDataCtrl("DE1621");
        CallResult callResult = psSysToolbarItemDataCtrl.Select(cond, psSysToolbarItemList, PSSysToolbarItem.class.getName());
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5de5\u5177\u680f\u5b50\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        if (psSysToolbarItemList.size() > 0) {
            throw new Exception(StringHelper.Format((String)"\u4e91\u5e73\u53f0\u5de5\u5177\u680f\u5b58\u5728\u5b50\u9879\uff0c\u4e0d\u80fd\u521d\u59cb\u5316"));
        }
        IDEDataCtrl tbTemplDataCtrl = this.GetRelatedDataCtrl("DE0127");
        TBTempl tbTempl = new TBTempl();
        tbTempl.setTBTEMPLID(psSysToolbar.getPSSYSTOOLBARID());
        callResult = tbTemplDataCtrl.Get((BaseDataEntity)tbTempl);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u5de5\u5177\u680f\u6a21\u7248\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        XMLNode tbModelXmlNode = XMLNode.LoadFromXML((String)tbTempl.getTBMODEL());
        if (tbModelXmlNode.getChildNodes() == null) {
            return;
        }
        int nIndex = 0;
        for (XMLNode tbItemNode : tbModelXmlNode.getChildNodes()) {
            this.savePSSysToolbarItem(psSysToolbar, null, tbItemNode, nIndex += 100, 0);
        }
    }

    protected void savePSSysToolbarItem(PSSysToolbar psSysToolbar, PSSysToolbarItem parentPSSysToolbarItem, XMLNode tbItemNode, int nIndex, int nLevel) throws Exception {
        IDEDataCtrl psSysToolbarItemDataCtrl = this.GetRelatedDataCtrl("DE1621");
        PSSysToolbarItem psSysToolbarItem = new PSSysToolbarItem();
        psSysToolbarItem.setPSSYSTOOLBARID(psSysToolbar.getPSSYSTOOLBARID());
        if (parentPSSysToolbarItem != null) {
            psSysToolbarItem.setPPSSYSTBITEMID(parentPSSysToolbarItem.getPSSYSTBITEMID());
        }
        String strDEBehaviorId = tbItemNode.GetExtValue("DEBEHAVIORID", "");
        String strCaption = tbItemNode.GetExtValue("CAPTION", "");
        if (StringHelper.Compare((String)strCaption, (String)"\u5de5\u5177\u680f\u6309\u94ae", (boolean)true) == 0) {
            strCaption = "";
        }
        psSysToolbarItem.setCAPTION(strCaption);
        psSysToolbarItem.setORDERVALUE(nIndex);
        if (StringHelper.IsNullOrEmpty((String)strDEBehaviorId)) {
            if (StringHelper.Compare((String)strCaption, (String)"-", (boolean)true) == 0) {
                psSysToolbarItem.setTBITEMTYPE("SEPERATOR");
            } else if (tbItemNode.getChildNodes() != null && tbItemNode.getChildNodes().size() > 0) {
                psSysToolbarItem.setTBITEMTYPE("ITEMS");
            }
        } else {
            psSysToolbarItem.setTBITEMTYPE("DEUIACTION");
            psSysToolbarItem.setPSSYSUIACTIONID(strDEBehaviorId);
        }
        if (StringHelper.IsNullOrEmpty((String)psSysToolbarItem.getTBITEMTYPE())) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u5de5\u5177\u680f\u5b50\u9879"));
        }
        CallResult callResult = psSysToolbarItemDataCtrl.Save(true, (BaseDataEntity)psSysToolbarItem);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u5de5\u5177\u680f\u5b50\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        if (StringHelper.Compare((String)psSysToolbarItem.getTBITEMTYPE(), (String)"ITEMS", (boolean)true) == 0) {
            int nChildIndex = 0;
            int nStep = 1;
            if (nLevel == 0) {
                nStep = 10;
            }
            for (XMLNode childTBItemNode : tbItemNode.getChildNodes()) {
                this.savePSSysToolbarItem(psSysToolbar, psSysToolbarItem, childTBItemNode, nIndex + (nChildIndex += nStep), nLevel + 1);
            }
        }
    }
}

