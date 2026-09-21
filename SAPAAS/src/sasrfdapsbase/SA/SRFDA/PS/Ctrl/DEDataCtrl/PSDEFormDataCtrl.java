/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.CommonEx.Errors
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

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.IPSModelInitDataCtrl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.PS.Data.PSDEFSearchMode;
import SA.SRFDA.PS.Data.PSDEFSearchModeV3;
import SA.SRFDA.PS.Data.PSDEField;
import SA.SRFDA.PS.Data.PSDEForm;
import SA.SRFDA.PS.Data.PSDEFormDetail;
import SA.SRFDA.PS.Data.PSDEFormDetailV3;
import SA.SRFDA.PS.Data.PSDataEntity;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.CommonEx.Errors;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.XML.SimpleXMLWriter;
import SA.SRFramework.XML.XMLNode;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEFormDataCtrl
extends PSDEDataCtrl
implements IPSModelInitDataCtrl {
    private static final Log log = LogFactory.getLog(PSDEFormDataCtrl.class);

    @Override
    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        try {
            if (!bInsert) {
                PSDEForm psDEForm = new PSDEForm();
                psDEForm.proxy(dataEntity);
                String strXML = dataEntity.getParamStringValue("FORMMODEL", "");
                if (lastDataEntity != null) {
                    String strLastXML = lastDataEntity.getParamStringValue("FORMMODEL", "");
                    if (StringHelper.Compare((String)(strXML = strXML.replace("\r\n", "\n")), (String)(strLastXML = strLastXML.replace("\r\n", "\n")), (boolean)true) != 0) {
                        HashMap<String, PSDEFormDetailV3> validMap = new HashMap<String, PSDEFormDetailV3>();
                        XMLNode xmlNode = XMLNode.LoadFromXML((String)strXML);
                        this.modifyLayoutFromXML(xmlNode, psDEForm, validMap);
                        BaseDataEntity cond = new BaseDataEntity();
                        cond.setParamValue("PSDEFORMID", (Object)psDEForm.getPSDEFORMID());
                        Vector psDEFormDetailList = new Vector();
                        IDEDataCtrl psDEFormDetailDataCtrl = this.GetRelatedDataCtrl("DE2202");
                        callResult = psDEFormDetailDataCtrl.Select(cond, psDEFormDetailList, PSDEFormDetail.class.getName());
                        if (callResult.isError()) {
                            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u8868\u5355\u6210\u5458\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                        }
                        for (PSDEFormDetailV3 psDEFormDetail : psDEFormDetailList) {
                            if (validMap.containsKey(psDEFormDetail.getPSDEFORMDETAILID()) || this.CheckKeyState2(psDEFormDetail) != 1 || !(callResult = psDEFormDetailDataCtrl.Remove((BaseDataEntity)psDEFormDetail)).isError()) continue;
                            throw new Exception(StringHelper.Format((String)"\u5220\u9664\u8868\u5355\u6210\u5458\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                        }
                    }
                }
                XMLNode xmlNode = this.fillLayoutXMLNode(null, psDEForm);
                StringBuilder sb = new StringBuilder();
                SimpleXMLWriter writer = new SimpleXMLWriter(sb);
                writer.WriteRaw("<?xml version=\"1.0\" encoding=\"utf-8\" ?>\r\n");
                xmlNode.Save(writer);
                dataEntity.setParamValue("FORMMODEL", (Object)sb.toString());
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

    protected void modifyLayoutFromXML(XMLNode xmlNode, PSDEForm psDEForm, HashMap<String, PSDEFormDetailV3> validMap) throws Exception {
        ArrayList xmlNodes = xmlNode.getChildNodes();
        if (xmlNodes == null) {
            return;
        }
        IDEDataCtrl psDEFormDetailDataCtrl = this.GetRelatedDataCtrl("DE2202");
        String strPNodeId = xmlNode.getID();
        int nIndex = 100;
        for (XMLNode childNode : xmlNodes) {
            String strNodeName = childNode.getNodeName();
            String strNodeId = childNode.getID();
            nIndex += 10;
            PSDEFormDetailV3 realItem = new PSDEFormDetailV3();
            realItem.setPSDEFORMID(psDEForm.getPSDEFORMID());
            String strCaption = childNode.GetExtValue("CAPTION", null);
            if (strCaption != null) {
                realItem.setCAPTION(strCaption);
            }
            if (!StringHelper.IsNullOrEmpty((String)strNodeId)) {
                realItem.setPSDEFORMDETAILID(strNodeId);
            } else if (StringHelper.Compare((String)strNodeName, (String)"FORMITEM", (boolean)true) == 0) {
                String strDEFieldName = childNode.GetExtValue("DEFNAME", "").toUpperCase();
                PSDEField psDEField = new PSDEField();
                psDEField.setPSDEID(psDEForm.getPSDEID());
                psDEField.setPSDEFIELDNAME(strDEFieldName);
                IDEDataCtrl psDEFieldDataCtrl = this.GetRelatedDataCtrl("DE2051");
                CallResult callResult = psDEFieldDataCtrl.Select((BaseDataEntity)psDEField);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u4e91\u5b9e\u4f53\u5c5e\u6027[%1$s:%2$s]", (Object)psDEForm.getPSDENAME(), (Object)strDEFieldName));
                }
                realItem.setPSDEFID(psDEField.getPSDEFIELDID());
                realItem.setPSDEFNAME(psDEField.getPSDEFIELDNAME());
                realItem.setFORMTYPE(psDEForm.getFORMTYPE());
                StringHelper.Compare((String)psDEForm.getFORMTYPE(), (String)"SEARCHFORM", (boolean)true);
            }
            realItem.setDETAILTYPE(strNodeName);
            if (!StringHelper.IsNullOrEmpty((String)strPNodeId)) {
                realItem.setPPSDEFORMDETAILID(strPNodeId);
            }
            realItem.setParamValue("ORDERVALUE", nIndex);
            CallResult callResult = psDEFormDetailDataCtrl.Save(StringHelper.IsNullOrEmpty((String)strNodeId), (BaseDataEntity)realItem);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u4fee\u6539\u8868\u5355\u6210\u5458\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            childNode.setID(realItem.getPSDEFORMDETAILID());
            validMap.put(realItem.getPSDEFORMDETAILID(), realItem);
            this.modifyLayoutFromXML(childNode, psDEForm, validMap);
        }
    }

    protected XMLNode fillLayoutXMLNode(XMLNode xmlNode, PSDEForm psDEForm) throws Exception {
        if (xmlNode == null) {
            xmlNode = new XMLNode();
            xmlNode.setNodeName("DEFORM");
        }
        BaseDataEntity cond = new BaseDataEntity();
        cond.setParamValue("PSDEFORMID", (Object)psDEForm.getPSDEFORMID());
        Vector psDEFormDetailList = new Vector();
        IDEDataCtrl psDEFormDetailDataCtrl = this.GetRelatedDataCtrl("DE2202");
        CallResult callResult = psDEFormDetailDataCtrl.Select(cond, psDEFormDetailList, PSDEFormDetail.class.getName(), "ORDER BY ORDERVALUE");
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u8868\u5355\u6210\u5458\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        HashMap<String, PSDEFormDetailV3> psDEFormDetailMap = new HashMap<String, PSDEFormDetailV3>();
        for (PSDEFormDetailV3 psDEFormDetail : psDEFormDetailList) {
            psDEFormDetailMap.put(psDEFormDetail.getPSDEFORMDETAILID(), psDEFormDetail);
        }
        for (PSDEFormDetailV3 psDEFormDetail : psDEFormDetailList) {
            if (StringHelper.IsNullOrEmpty((String)psDEFormDetail.getPPSDEFORMDETAILID())) continue;
            PSDEFormDetailV3 parentPSDEFormDetail = (PSDEFormDetailV3)((Object)psDEFormDetailMap.get(psDEFormDetail.getPPSDEFORMDETAILID()));
            parentPSDEFormDetail.getChildPSDEFormDetails(true).add(psDEFormDetail);
        }
        int nValue = 0;
        for (PSDEFormDetailV3 psDEFormDetail : psDEFormDetailList) {
            if (!StringHelper.IsNullOrEmpty((String)psDEFormDetail.getPPSDEFORMDETAILID())) continue;
            String strOrderString = PSDEFormDataCtrl.getOrderString(++nValue);
            String strOrderString2 = PSDEFormDataCtrl.getFullOrderString(strOrderString, 40);
            psDEFormDetail.setLEVELTAG(strOrderString2);
            psDEFormDetail.setLEVELVALUE(strOrderString.length() / 2 - 1);
            xmlNode.SetExtValue("ORDERTAG", strOrderString);
            psDEFormDetailDataCtrl.Save(false, (BaseDataEntity)psDEFormDetail);
            this.fillLayoutXMLNode(xmlNode, psDEFormDetail);
        }
        return xmlNode;
    }

    protected XMLNode fillLayoutXMLNode(XMLNode xmlNode, PSDEFormDetailV3 psDEFormDetail) throws Exception {
        XMLNode childXmlNode = new XMLNode();
        childXmlNode.setNodeName(psDEFormDetail.getDETAILTYPE());
        childXmlNode.SetProperty("ID", psDEFormDetail.getPSDEFORMDETAILID());
        childXmlNode.SetProperty("NAME", psDEFormDetail.getPSDEFORMDETAILNAME());
        childXmlNode.SetProperty("CAPTION", psDEFormDetail.getCAPTION());
        xmlNode.AddNode(childXmlNode);
        ArrayList<PSDEFormDetailV3> childPSDEFormDetailList = psDEFormDetail.getChildPSDEFormDetails(false);
        if (childPSDEFormDetailList != null) {
            int nValue = 0;
            IDEDataCtrl psDEFormDetailDataCtrl = this.GetRelatedDataCtrl("DE2202");
            for (PSDEFormDetailV3 childPSDEFormDetail : childPSDEFormDetailList) {
                String strOrderString = String.valueOf(xmlNode.GetExtValue("ORDERTAG", "")) + PSDEFormDataCtrl.getOrderString(++nValue);
                String strOrderString2 = PSDEFormDataCtrl.getFullOrderString(strOrderString, 40);
                childPSDEFormDetail.setLEVELTAG(strOrderString2);
                childPSDEFormDetail.setLEVELVALUE(strOrderString.length() / 2 - 1);
                childXmlNode.SetExtValue("ORDERTAG", strOrderString);
                psDEFormDetailDataCtrl.Save(false, (BaseDataEntity)childPSDEFormDetail);
                this.fillLayoutXMLNode(childXmlNode, childPSDEFormDetail);
            }
        }
        return childXmlNode;
    }

    public CallResult GetDefault(ISRFDAWebContext webContext, BaseDataEntity dataEntity) {
        CallResult callResult = super.GetDefault(webContext, dataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        String strFormType = webContext.GetParamValue("FORMTYPE");
        dataEntity.setParamValue("FORMTYPE", (Object)strFormType);
        return callResult;
    }

    @Override
    public CallResult initModel(String strDEId, BaseDataEntity dataEntity, String strMode) {
        CallResult callResult = new CallResult();
        try {
            if (StringHelper.Compare((String)strDEId, (String)"DE2050", (boolean)true) == 0) {
                PSDataEntity psDataEntity = new PSDataEntity();
                psDataEntity.proxy(dataEntity);
                this.initDefaultEditForm(psDataEntity);
                this.initDefaultSearchForm(psDataEntity);
                return callResult;
            }
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)ex.getMessage(), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void initDefaultEditForm(PSDataEntity psDataEntity) throws Exception {
        String strDefaultEditFormId = Helper.GenUniqueId((String)psDataEntity.getPSDATAENTITYID(), (String)"EDITFORM");
        PSDEForm psDEForm = new PSDEForm();
        psDEForm.setPSDEFORMID(strDefaultEditFormId);
        CallResult callResult = this.Get(psDEForm);
        if (Errors.IsSpecialError((int)callResult.getRetCode(), (int)3)) {
            psDEForm.setPSDEFORMID(strDefaultEditFormId);
            psDEForm.setFORMTYPE("EDITFORM");
            psDEForm.setPSDEID(psDataEntity.getPSDATAENTITYID());
            psDEForm.setCODENAME("Main");
            psDEForm.setPSDEFORMNAME("\u4e3b\u7f16\u8f91\u8868\u5355");
            callResult = this.Save(true, psDEForm);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u521d\u59cb\u5316\u4e3b\u7f16\u8f91\u8868\u5355\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
        }
    }

    protected void initDefaultSearchForm(PSDataEntity psDataEntity) throws Exception {
        String strDefaultEditFormId = Helper.GenUniqueId((String)psDataEntity.getPSDATAENTITYID(), (String)"SEARCHFORM");
        PSDEForm psDEForm = new PSDEForm();
        psDEForm.setPSDEFORMID(strDefaultEditFormId);
        CallResult callResult = this.Get(psDEForm);
        if (Errors.IsSpecialError((int)callResult.getRetCode(), (int)3)) {
            psDEForm.setPSDEFORMID(strDefaultEditFormId);
            psDEForm.setFORMTYPE("SEARCHFORM");
            psDEForm.setPSDEID(psDataEntity.getPSDATAENTITYID());
            psDEForm.setCODENAME("Default");
            psDEForm.setPSDEFORMNAME("\u9ed8\u8ba4\u641c\u7d22\u8868\u5355");
            callResult = this.Save(true, psDEForm);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u521d\u59cb\u5316\u9ed8\u8ba4\u641c\u7d22\u8868\u5355\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
        }
        IDEDataCtrl psDEFormDetailDataCtrl = this.GetRelatedDataCtrl("DE2202");
        BaseDataEntity cond = new BaseDataEntity();
        cond.setParamValue("PSDEFORMID", (Object)strDefaultEditFormId);
        Vector psDEFormDetailList = new Vector();
        callResult = psDEFormDetailDataCtrl.Select(cond, psDEFormDetailList, PSDEFormDetail.class.getName());
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u9ed8\u8ba4\u641c\u7d22\u8868\u5355\u6210\u5458\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        if (psDEFormDetailList.size() > 0) {
            return;
        }
        Vector psDEFSearchModeList = new Vector();
        String strSQL = StringHelper.Format((String)"select * from v_srfPSDEFSFITEM t1 inner join t_srfpsdefield t2 on t1.PSDEFID=t2.PSDEFIELDID where t2.PSDEID='%1$s'", (Object)psDEForm.getPSDEID());
        callResult = BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)this.globalHelperEx, (Connection)this.getConnection(), (String)"", (String)strSQL, null, psDEFSearchModeList, (String)PSDEFSearchMode.class.getName());
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u5efa\u7acb\u5b9e\u4f53\u641c\u7d22\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        if (psDEFSearchModeList.size() == 0) {
            return;
        }
        PSDEFormDetailV3 formPagePSDEFormDetail = new PSDEFormDetailV3();
        formPagePSDEFormDetail.setPSDEFORMID(strDefaultEditFormId);
        formPagePSDEFormDetail.setDETAILTYPE("FORMPAGE");
        formPagePSDEFormDetail.setCAPTION("\u5e38\u89c4");
        formPagePSDEFormDetail.setCOLMODEL("33%;33%;34%");
        formPagePSDEFormDetail.setORDERVALUE(100);
        callResult = psDEFormDetailDataCtrl.Save(true, (BaseDataEntity)formPagePSDEFormDetail);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u5efa\u7acb\u9ed8\u8ba4\u641c\u7d22\u8868\u5355\u5e38\u89c4\u5206\u9875\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        int nOrder = 100;
        for (PSDEFSearchModeV3 psDEFSearchMode : psDEFSearchModeList) {
            PSDEFormDetailV3 psDEFormDetail = new PSDEFormDetailV3();
            psDEFormDetail.setPSDEFORMDETAILNAME(psDEFSearchMode.getPSDEFSFITEMNAME().toLowerCase());
            psDEFormDetail.setDETAILTYPE("FORMITEM");
            psDEFormDetail.setPSDEFID(psDEFSearchMode.getPSDEFID());
            psDEFormDetail.setPSDEFNAME(psDEFSearchMode.getPSDEFNAME());
            psDEFormDetail.setPSDEFORMID(strDefaultEditFormId);
            psDEFormDetail.setPPSDEFORMDETAILID(formPagePSDEFormDetail.getPSDEFORMDETAILID());
            psDEFormDetail.setPSDEFSFITEMID(psDEFSearchMode.getPSDEFSFITEMID());
            psDEFormDetail.setORDERVALUE(nOrder);
            callResult = psDEFormDetailDataCtrl.Save(true, (BaseDataEntity)psDEFormDetail);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u5efa\u7acb\u9ed8\u8ba4\u641c\u7d22\u8868\u5355\u8868\u5355\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            nOrder += 10;
        }
    }
}

