/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.DEFHelper.IPickupDEFHelper
 *  SA.SRFDA.Ctrl.Data.Form
 *  SA.SRFDA.Ctrl.Data.FormPart
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.CallParamList
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.PropertiesHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.IPickupDEFHelper;
import SA.SRFDA.Ctrl.Data.Form;
import SA.SRFDA.Ctrl.Data.FormPart;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.PS.Core.Deploy.IPSSystemDeploy;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.PS.Data.PSDEForm;
import SA.SRFDA.PS.Data.PSDEFormDetail;
import SA.SRFDA.PS.Data.PSDEFormDetailV3;
import SA.SRFDA.PS.Data.PSDEViewCtrl;
import SA.SRFDA.PS.Data.PSV3Migrate;
import SA.SRFDA.PS.Data.PSV3MigrateDEForm;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.CallParamList;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import java.sql.Connection;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Vector;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.xml.XmlNode;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSV3MigrateDEFormDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSV3MigrateDEFormDataCtrl.class);
    public static final String CUSTOMCALL_SYNCBASE = "SYNCBASE";
    public static final String CUSTOMCALL_REPLACEDEFAULT = "REPLACEDEFAULT";
    private static Random random = new Random();

    @Override
    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        return callResult;
    }

    @Override
    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_SYNCBASE, (boolean)true) == 0) {
            return this.syncBaseInfo(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_REPLACEDEFAULT, (boolean)true) == 0) {
            return this.replaceDefaultForm(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult syncBaseInfo(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            PSV3MigrateDEForm psV3MigrateDEForm = new PSV3MigrateDEForm();
            psV3MigrateDEForm.proxy(dataEntity);
            if (psV3MigrateDEForm.getIGNOREFLAG()) {
                return callResult;
            }
            this.onSyncBaseInfo(psV3MigrateDEForm);
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().CommitAndBegin();
            }
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u521d\u59cb\u5316\u5b9e\u4f53\u8868\u5355\u57fa\u672c\u4fe1\u606f\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onSyncBaseInfo(PSV3MigrateDEForm psV3MigrateDEForm) throws Exception {
        PSV3Migrate psV3Migrate = new PSV3Migrate();
        psV3Migrate.setPSV3MIGRATEID(psV3MigrateDEForm.getPSV3MIGRATEID());
        IDEDataCtrl psV3MigrateDataCtrl = this.GetRelatedDataCtrl("DE2900");
        CallResult callResult = psV3MigrateDataCtrl.Get((BaseDataEntity)psV3Migrate);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u8fc1\u79fb\u914d\u7f6e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        String strPSSystemId = psV3Migrate.getPSSYSTEMID();
        IPSSystem iPSSystem = this.getPSModelStorage().getPSSystem(strPSSystemId);
        IPSSystemDeploy defaultPSSystemDeploy = iPSSystem.getDefaultPSSystemDeploy();
        Exception exception = null;
        Connection connection = defaultPSSystemDeploy.getDefaultPSSystemDeployDB().getConnection();
        try {
            String strSQL = "SELECT t1.* FROM V_SRFFORM t1 WHERE FORMID=?";
            CallParamList callParamList = new CallParamList();
            callParamList.Add((Object)psV3MigrateDEForm.getDEFORMID());
            Form form = new Form();
            callResult = BaseDEDataCtrl.SelectSingleEx((ISRFDAGlobalHelper)this.getGlobalHelper(), (Connection)connection, (String)"", (String)strSQL, (Vector)callParamList.GetList(), (BaseDataEntity)form);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u8868\u5355\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            IDEDataCtrl psDEFormDataCtrl = this.GetRelatedDataCtrl("DE2201");
            IDEDataCtrl psDEFormDetailDataCtrl = this.GetRelatedDataCtrl("DE2202");
            String strPSDEId = Helper.GenUniqueId((String)iPSSystem.getId(), (String)psV3MigrateDEForm.getDENAME().toUpperCase());
            String strPSDEFormId = Helper.GenUniqueId((String)strPSDEId, (String)form.getFORMID());
            PSDEForm psDEForm = new PSDEForm();
            psDEForm.setPSDEFORMID(strPSDEFormId);
            callResult = psDEFormDataCtrl.Get((BaseDataEntity)psDEForm);
            if (callResult.isError()) {
                psDEForm.setPSDEID(strPSDEId);
                psDEForm.setPSDENAME(psV3MigrateDEForm.getDENAME());
                psDEForm.setPSDEFORMNAME(form.getFORMNAME());
                psDEForm.setFORMSN(form.getFORMID());
                psDEForm.setFORMTYPE("EDITFORM");
                if (form.GetParamIntValue("ISMAJOR", 1) == 1) {
                    psDEForm.setCODENAME("Main2");
                } else {
                    psDEForm.setCODENAME(StringHelper.Format((String)"F%1$s", (Object)random.nextInt(100)));
                }
                callResult = psDEFormDataCtrl.Save(true, (BaseDataEntity)psDEForm);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u4e91\u5b9e\u4f53\u8868\u5355\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
            }
            BaseDataEntity cond = new BaseDataEntity();
            cond.setParamValue("PSDEFORMID", (Object)psDEForm.getPSDEFORMID());
            Vector psDEFormDetailList = new Vector();
            callResult = psDEFormDetailDataCtrl.Select(cond, psDEFormDetailList, PSDEFormDetail.class.getName());
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u4e91\u5b9e\u4f53\u8868\u5355\u5217\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            if (psDEFormDetailList.size() > 0) {
                return;
            }
            try {
                String strFormModel = form.getFORMMODEL();
                IDEHelper iDEHelper = this.getGlobalHelper().getDAModelStorage().FindDEHelper(form.getDEID());
                XmlNode xmlNode = XmlNode.loadFromXML((String)strFormModel);
                Iterator xmlNodes = xmlNode.getChildNodes();
                int nIndex = 0;
                while (xmlNodes.hasNext()) {
                    XmlNode childXmlNode = (XmlNode)xmlNodes.next();
                    this.savePSDEFormDetail(psV3Migrate, iDEHelper, psDEForm, null, childXmlNode, ++nIndex);
                }
            }
            catch (Exception e) {
                log.error((Object)e.getMessage(), (Throwable)e);
                exception = new Exception(e);
                connection.close();
                if (exception != null) {
                    throw exception;
                }
            }
        }
        finally {
            connection.close();
            if (exception != null) {
                throw exception;
            }
        }
    }

    protected void savePSDEFormDetail(PSV3Migrate psV3Migrate, IDEHelper iDEHelper, PSDEForm psDEForm, PSDEFormDetailV3 parentPSDEFormDetail, XmlNode xmlNode, int nIndex) throws Exception {
        IDEDataCtrl psDEFormDetailDataCtrl;
        CallResult callResult;
        String strNodeName = xmlNode.getNodeName();
        int nValue = psDEForm.GetParamIntValue(strNodeName, 0);
        psDEForm.setParamValue(strNodeName, ++nValue);
        PSDEFormDetailV3 psDEFormDetail = new PSDEFormDetailV3();
        psDEFormDetail.setPSDEFORMID(psDEForm.getPSDEFORMID());
        psDEFormDetail.setPSDEFORMNAME(psDEForm.getPSDEFORMNAME());
        psDEFormDetail.setORDERVALUE(nIndex);
        psDEFormDetail.setCAPTION(xmlNode.getAttribute("CAPTION", ""));
        psDEFormDetail.setCOLMODEL(xmlNode.getAttribute("COLUMNS", ""));
        String strFormPartId = "";
        int nColSpan = xmlNode.getAttribute("COLSPAN", -1);
        if (nColSpan != -1) {
            psDEFormDetail.setCOLSPAN(nColSpan);
        }
        if (parentPSDEFormDetail != null) {
            psDEFormDetail.setPPSDEFORMDETAILID(parentPSDEFormDetail.getPSDEFORMDETAILID());
        }
        if (StringHelper.Compare((String)strNodeName, (String)"SRFEXDPPAGEGROUP", (boolean)true) == 0) {
            psDEFormDetail.setDETAILTYPE("FORMPAGE");
        } else if (StringHelper.Compare((String)strNodeName, (String)"SRFEXDPGROUP", (boolean)true) == 0) {
            psDEFormDetail.setDETAILTYPE("GROUPPANEL");
            if (xmlNode.getAttribute("SHOWCAPTION", true)) {
                psDEFormDetail.setSHOWCAPTION(true);
            } else {
                psDEFormDetail.setSHOWCAPTION(false);
            }
        } else if (StringHelper.Compare((String)strNodeName, (String)"SRFEXDPFORMITEM", (boolean)true) == 0) {
            String strEditorType;
            IDEFHelper iDEFHelper;
            psDEFormDetail.setDETAILTYPE("FORMITEM");
            String strDEFID = xmlNode.getAttribute("DEFID", "");
            if (StringHelper.IsNullOrEmpty((String)strDEFID)) {
                strDEFID = xmlNode.getAttribute("DEFNAME", "");
            }
            if (StringHelper.IsNullOrEmpty((String)strDEFID)) {
                strDEFID = xmlNode.getAttribute("DEFIELD", "");
            }
            if ((iDEFHelper = iDEHelper.GetDEFHelper(strDEFID)) == null) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u5c5e\u6027[%1$s]", (Object)strDEFID));
                return;
            }
            String strDEFLogicName = xmlNode.getAttribute("DEFLOGICNAME", "");
            if (StringHelper.IsNullOrEmpty((String)strDEFLogicName)) {
                strDEFLogicName = iDEFHelper.getLogicName();
            }
            if (xmlNode.getAttribute("SHOWCAPTION", true)) {
                psDEFormDetail.setSHOWCAPTION(true);
            } else {
                psDEFormDetail.setSHOWCAPTION(false);
                psDEFormDetail.setLABELPOS("NONE");
            }
            String strAllowEmpty = xmlNode.getAttribute("ALLOWEMPTY", "");
            if (!StringHelper.IsNullOrEmpty((String)strAllowEmpty)) {
                psDEFormDetail.setALLOWEMPTY(StringHelper.Compare((String)strAllowEmpty, (String)"TRUE", (boolean)true) == 0);
            }
            if (!StringHelper.IsNullOrEmpty((String)(strEditorType = xmlNode.getAttribute("FC_FORMITEMSTYLE", "")))) {
                strEditorType = strEditorType.replace("SRFEX", "");
                psDEFormDetail.setEDITORTYPE(strEditorType);
            }
            if (iDEFHelper instanceof IPickupDEFHelper) {
                IPickupDEFHelper iPickupDEFHelper = (IPickupDEFHelper)iDEFHelper;
                if (StringHelper.IsNullOrEmpty((String)strEditorType) && StringHelper.Compare((String)iPickupDEFHelper.GetFormItemStyle(), (String)"SRFEXHIDDEN", (boolean)true) != 0) {
                    iDEFHelper = iPickupDEFHelper.GetPickupTextDEFHelper();
                }
            }
            psDEFormDetail.setPSDEFORMDETAILNAME(iDEFHelper.getName().toLowerCase());
            psDEFormDetail.setPSDEFID(Helper.GenUniqueId((String)psDEForm.getPSDEID(), (String)iDEFHelper.getName().toUpperCase()));
            String strFIExtParams = xmlNode.getAttribute("FI_EXTPARAMS", "");
            if (!StringHelper.IsNullOrEmpty((String)strFIExtParams)) {
                Properties properties = PropertiesHelper.load((String)strFIExtParams);
                String strValue = PropertiesHelper.getProperty((Properties)properties, (String)"HEIGHT");
                if (!StringHelper.IsNullOrEmpty((String)strValue)) {
                    psDEFormDetail.setCTRLHEIGHT(Integer.parseInt(strValue));
                }
                if (!StringHelper.IsNullOrEmpty((String)(strValue = PropertiesHelper.getProperty((Properties)properties, (String)"WIDTH")))) {
                    psDEFormDetail.setCTRLWIDTH(Integer.parseInt(strValue));
                }
            }
            log.info((Object)StringHelper.Format((String)"\u5b9e\u4f53\u8868\u5355\u7f16\u8f91\u9879[%1$s]", (Object)iDEFHelper.getName()));
        } else if (StringHelper.Compare((String)strNodeName, (String)"SRFEXDPRAWITEM", (boolean)true) == 0) {
            strFormPartId = xmlNode.getAttribute("FORMPARTID", "");
            if (!StringHelper.IsNullOrEmpty((String)strFormPartId)) {
                IDEDataCtrl formPartDataCtrl = this.GetRelatedDataCtrl("DE0083");
                FormPart formPart = new FormPart();
                formPart.setFORMPARTID(strFormPartId);
                CallResult callResult2 = formPartDataCtrl.Get((BaseDataEntity)formPart);
                if (callResult2.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u8868\u5355\u90e8\u4ef6\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult2.getErrorInfo()));
                }
                XmlNode formPartNode = XmlNode.loadFromXML((String)("<?xml version=\"1.0\" encoding=\"utf-8\" ?>" + formPart.getFORMPARTMODEL()));
                this.savePSDEFormDetail(psV3Migrate, iDEHelper, psDEForm, parentPSDEFormDetail, formPartNode, nIndex);
                return;
            }
            psDEFormDetail.setDETAILTYPE("GROUPPANEL");
            psDEFormDetail.setSHOWCAPTION(false);
            psDEFormDetail.setPSDEFORMDETAILNAME(StringHelper.Format((String)"%1$s%2$s", (Object)"raw", (Object)nValue));
        } else if (StringHelper.Compare((String)strNodeName, (String)"SRFEXDPDATAGRIDITEM", (boolean)true) == 0) {
            int nHeight = xmlNode.getAttribute("HEIGHT", 300);
            psDEFormDetail.setDETAILTYPE("DRUIPART");
            psDEFormDetail.setHEIGHT(nHeight);
            String strDER1NId = xmlNode.getAttribute("DER1NID", "");
            if (StringHelper.IsNullOrEmpty((String)strDER1NId)) {
                throw new Exception(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9aDER1N"));
            }
            psDEFormDetail.setPSDEDRITEMID(Helper.GenUniqueId((String)psV3Migrate.getPSSYSTEMID(), (String)strDER1NId));
        }
        if (StringHelper.IsNullOrEmpty((String)psDEFormDetail.getPSDEFORMDETAILNAME())) {
            if (nValue == 1) {
                psDEFormDetail.setPSDEFORMDETAILNAME(StringHelper.Format((String)"%1$s%2$s", (Object)psDEFormDetail.getDETAILTYPE().toLowerCase(), (Object)nValue));
            } else {
                psDEFormDetail.setPSDEFORMDETAILNAME(StringHelper.Format((String)"%1$s%2$s", (Object)psDEFormDetail.getDETAILTYPE().toLowerCase(), (Object)nValue));
            }
        }
        if ((callResult = (psDEFormDetailDataCtrl = this.GetRelatedDataCtrl("DE2202")).Save(true, (BaseDataEntity)psDEFormDetail)).isError()) {
            log.error((Object)StringHelper.Format((String)"\u5b9e\u4f53\u8868\u5355[%1$s]\u9879\u7c7b\u578b[%2$s]", (Object)psDEForm.getPSDEFORMNAME(), (Object)psDEFormDetail.getDETAILTYPE()));
            throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u4e91\u5b9e\u4f53\u8868\u5355\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        Iterator xmlNodes = xmlNode.getChildNodes();
        if (xmlNodes != null) {
            int nChildIndex = 0;
            while (xmlNodes.hasNext()) {
                XmlNode childXmlNode = (XmlNode)xmlNodes.next();
                this.savePSDEFormDetail(psV3Migrate, iDEHelper, psDEForm, psDEFormDetail, childXmlNode, ++nChildIndex);
            }
        }
    }

    public CallResult replaceDefaultForm(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            PSV3MigrateDEForm psV3MigrateDEForm = new PSV3MigrateDEForm();
            psV3MigrateDEForm.proxy(dataEntity);
            if (psV3MigrateDEForm.getIGNOREFLAG()) {
                return callResult;
            }
            this.onReplaceDefaultForm(psV3MigrateDEForm);
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().CommitAndBegin();
            }
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u66ff\u6362\u9ed8\u8ba4\u5b9e\u4f53\u8868\u5355\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onReplaceDefaultForm(PSV3MigrateDEForm psV3MigrateDEForm) throws Exception {
        PSV3Migrate psV3Migrate = new PSV3Migrate();
        psV3Migrate.setPSV3MIGRATEID(psV3MigrateDEForm.getPSV3MIGRATEID());
        IDEDataCtrl psV3MigrateDataCtrl = this.GetRelatedDataCtrl("DE2900");
        CallResult callResult = psV3MigrateDataCtrl.Get((BaseDataEntity)psV3Migrate);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u8fc1\u79fb\u914d\u7f6e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        String strPSSystemId = psV3Migrate.getPSSYSTEMID();
        String strPSDEId = Helper.GenUniqueId((String)strPSSystemId, (String)psV3MigrateDEForm.getDENAME().toUpperCase());
        String strDefaultEditFormId = Helper.GenUniqueId((String)strPSDEId, (String)"EDITFORM");
        String strPSDEFormId = Helper.GenUniqueId((String)strPSDEId, (String)psV3MigrateDEForm.getDEFORMID());
        String strPSDEFormName = psV3MigrateDEForm.getPSV3MGFORMNAME();
        BaseDataEntity cond = new BaseDataEntity();
        cond.setParamValue("PSDEFORMID", (Object)strDefaultEditFormId);
        Vector<PSDEViewCtrl> psDEViewCtrlList = new Vector<PSDEViewCtrl>();
        IDEDataCtrl psDEViewCtrlDataCtrl = this.GetRelatedDataCtrl("DE2302");
        callResult = psDEViewCtrlDataCtrl.Select(cond, psDEViewCtrlList, PSDEViewCtrl.class.getName());
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u89c6\u56fe\u8868\u5355\u5f15\u7528\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDEViewCtrl psDEViewCtrl : psDEViewCtrlList) {
            psDEViewCtrl.setPSDEFORMID(strPSDEFormId);
            psDEViewCtrl.setPSDEFORMNAME(strPSDEFormName);
            callResult = psDEViewCtrlDataCtrl.Save(false, (BaseDataEntity)psDEViewCtrl);
            if (!callResult.isError()) continue;
            throw new Exception(StringHelper.Format((String)"\u66f4\u65b0\u89c6\u56fe\u8868\u5355\u5f15\u7528\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
    }
}
