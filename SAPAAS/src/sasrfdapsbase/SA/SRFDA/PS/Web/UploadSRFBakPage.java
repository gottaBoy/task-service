/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.CodeList
 *  SA.SRFDA.Ctrl.Data.DEField
 *  SA.SRFDA.Ctrl.Data.DER1N
 *  SA.SRFDA.Ctrl.Data.DERINDEX
 *  SA.SRFDA.Ctrl.Data.DataEntity
 *  SA.SRFDA.Ctrl.Data.DataGrid
 *  SA.SRFDA.Ctrl.Data.Form
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Model.DGModelColumnConfig
 *  SA.SRFDA.Model.DataGridModelConfig
 *  SA.SRFDA.Web.Default.BaseMainPage
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.CodeList.CodeItemConfig
 *  SA.SRFramework.CodeList.CodeListConfig
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.XML.XMLNode
 *  com.jspsmart.upload.SmartFile
 *  com.jspsmart.upload.SmartUpload
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.service.SessionFactoryManager
 *  net.ibizsys.paas.util.PropertiesHelper
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.paas.web.WebContext
 *  net.ibizsys.paas.web.util.SimpleWebContext
 *  net.ibizsys.paas.xml.XmlNode
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEField
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEForm
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEFormBase
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEFormDetail
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEGrid
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEGridBase
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEGridCol
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDER
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase
 *  net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService
 *  net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailService
 *  net.ibizsys.pscore.srv.dedesign.service.PSDEFormService
 *  net.ibizsys.pscore.srv.dedesign.service.PSDEGridColService
 *  net.ibizsys.pscore.srv.dedesign.service.PSDEGridService
 *  net.ibizsys.pscore.srv.dedesign.service.PSDERService
 *  net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSCodeItem
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSCodeListBase
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSModule
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSystem
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase
 *  net.ibizsys.pscore.srv.sysdesign.service.PSCodeItemService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSModuleService
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Web;

import SA.SRFDA.Ctrl.Data.CodeList;
import SA.SRFDA.Ctrl.Data.DEField;
import SA.SRFDA.Ctrl.Data.DER1N;
import SA.SRFDA.Ctrl.Data.DERINDEX;
import SA.SRFDA.Ctrl.Data.DataEntity;
import SA.SRFDA.Ctrl.Data.DataGrid;
import SA.SRFDA.Ctrl.Data.Form;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Model.DGModelColumnConfig;
import SA.SRFDA.Model.DataGridModelConfig;
import SA.SRFDA.PS.Core.JIT.Web.PSJITWebContext;
import SA.SRFDA.PS.Core.PSObjectFactory;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.Web.Default.BaseMainPage;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.CodeList.CodeItemConfig;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.XML.XMLNode;
import com.jspsmart.upload.SmartFile;
import com.jspsmart.upload.SmartUpload;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.paas.web.util.SimpleWebContext;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEForm;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFormBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFormDetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGrid;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGridBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGridCol;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridColService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridService;
import net.ibizsys.pscore.srv.dedesign.service.PSDERService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeListBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class UploadSRFBakPage
extends BaseMainPage {
    protected StringBuilderEx processInfo = new StringBuilderEx();
    private static final Log log = LogFactory.getLog(UploadSRFBakPage.class);
    private PSDevSlnSys psDevSlnSys = new PSDevSlnSys();
    private SessionFactory sysSessionFactory = null;
    private HashMap<String, PSDataEntity> psDataEntityMap = new HashMap();
    private HashMap<String, PSCodeList> psCodeListMap = new HashMap();
    private HashMap<String, PSDER> psDER1NMap = new HashMap();
    private HashMap<String, PSDER> psDERIndexMap = new HashMap();
    private HashMap<String, HashMap<String, PSDEField>> psDEFieldMap = new HashMap();
    private static Random random = new Random();
    private static final Pattern codeNamePattern = Pattern.compile("[a-zA-Z_$][a-zA-Z0-9_$]*");

    protected boolean PreparePageEnv() {
        if (PSJITWebContext.getInstance() != null) {
            PSJITWebContext.setCurrent(null);
        }
        return super.PreparePageEnv();
    }

    protected void OnInitComponents() {
        super.OnInitComponents();
        try {
            XMLNode rootNode;
            String strPSDevSlnSysId = this.getWebContext().GetParamValue("PSDEVSLNSYSID");
            String strActionMode = this.getWebContext().GetParamValue("SRFACTIONMODE");
            SmartUpload su = new SmartUpload();
            su.initialize(this.pageContext);
            su.upload();
            int nCount = su.getFiles().getCount();
            if (nCount == 0) {
                return;
            }
            PSObjectFactory.getPSModelStorage(this.getDAGlobalHelper());
            PSDevSlnSysService psDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class);
            this.psDevSlnSys.setPSDevSlnSysId(strPSDevSlnSysId);
            psDevSlnSysService.get((IEntity)this.psDevSlnSys);
            SimpleWebContext iWebContext = new SimpleWebContext();
            iWebContext.init(this.getRequest(), this.getResponse(), this.getRequest().getSession().getServletContext());
            WebContext.setCurrent((IWebContext)iWebContext);
            String strUserId = this.getRequest().getHeader("X-SRFUSERID");
            String strLoginName = this.getRequest().getHeader("X-SRFLOGINNAME");
            String strUserName = this.getRequest().getHeader("X-SRFUSERNAME");
            iWebContext.setSessionValue("SRFPERSONID", (Object)strUserId);
            iWebContext.setSessionValue("SRFLOGINNAME", (Object)strLoginName);
            JSONObject jo = new JSONObject();
            jo.put("pssystemid", (Object)this.psDevSlnSys.getPSSystemId());
            jo.put("pssystemname", (Object)this.psDevSlnSys.getPSDevSlnSysName());
            WebContext.setAppData((JSONObject)jo);
            PSCoreSysServiceBase.setCurrentPSSystemId((String)this.psDevSlnSys.getPSSystemId());
            PSCoreSysServiceBase.setCurrentPSDevSlnSysId((String)this.psDevSlnSys.getPSDevSlnSysId());
            this.sysSessionFactory = PSSysModelInstGlobal.getSessionFactory((String)this.psDevSlnSys.getPSSysModelInstId());
            String strTempId = Helper.GenGuidEx();
            String strTempFilePath = StringHelper.Format((String)"%1$s%2$s.srfbak", (Object)this.getWebContext().getGlobalHelper().GetTempPath(), (Object)strTempId);
            int i = 0;
            if (i < nCount) {
                SmartFile file = su.getFiles().getFile(i);
                file.saveAs(strTempFilePath);
            }
            if ((rootNode = XMLNode.Load((String)strTempFilePath)) == null) {
                this.processInfo.Append("<SPAN class='sx-normaltext-red'>\u6570\u636e\u6587\u4ef6\u65e0\u6548\uff01</SPAN><BR>");
                return;
            }
            if (rootNode.getChildNodes() != null) {
                int nIndex = 0;
                for (XMLNode xmlNode : rootNode.getChildNodes()) {
                    ++nIndex;
                    String strDEId = xmlNode.GetExtValue("SRFDEID", "");
                    if (StringHelper.IsNullOrEmpty((String)strDEId)) {
                        this.processInfo.Append("[%1$s] <SPAN class='sx-normaltext-red'>\u6ca1\u6709\u6307\u5b9a\u5bf9\u5e94\u7684\u6570\u636e\u5bf9\u8c61</SPAN><BR>", (Object)nIndex);
                        continue;
                    }
                    IDEHelper iDEHelper = this.getDAModelStorage().FindDEHelper(strDEId);
                    Object callResult = null;
                    BaseDataEntity dataEntity = null;
                    SessionFactoryManager.addRef();
                    try {
                        dataEntity = this.Import(strDEId, xmlNode);
                        this.processInfo.Append("[%1$s] <SPAN class='sx-normaltext'>[%2$s:%3$s]\u5bfc\u5165\u6570\u636e[%4$s]\u6210\u529f!</SPAN><BR>", (Object)nIndex, (Object)iDEHelper.getName(), (Object)iDEHelper.getLogicName(this.getLanguage()), (Object)(dataEntity == null ? "\u672a\u77e5" : iDEHelper.GetDataInfo(dataEntity)));
                        SessionFactoryManager.releaseRef((boolean)true);
                    }
                    catch (Exception ex) {
                        log.error((Object)ex);
                        SessionFactoryManager.releaseRef((boolean)false);
                        this.processInfo.Append("[%1$s] <SPAN class='sx-normaltext-red'>\u5bfc\u5165\u6570\u636e\u53d1\u751f\u5f02\u5e38\uff1a%2$s</SPAN><BR>", (Object)nIndex, (Object)ex.getMessage());
                    }
                }
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String getProcessInfo() {
        return this.processInfo.toString();
    }

    public BaseDataEntity Import(String strDEId, XMLNode xmlNode) throws Exception {
        BaseDataEntity importDataEntity2;
        String strValue = xmlNode.GetExtValue("SRFVALUE", "");
        if (StringHelper.IsNullOrEmpty((String)strValue)) {
            String strCustomCall = xmlNode.GetExtValue("SRFCUSTOMCALL", "");
            if (!StringHelper.IsNullOrEmpty((String)strCustomCall)) {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u5bfc\u5165\u5b9e\u4f53[%1$s]\u81ea\u5b9a\u4e49\u8c03\u7528[%2$s]", (Object)strDEId, (Object)strCustomCall));
            }
            String strRemoveCall = xmlNode.GetExtValue("SRFREMOVE", "");
            if (StringHelper.Compare((String)strRemoveCall, (String)"TRUE", (boolean)true) == 0) {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u5bfc\u5165\u5b9e\u4f53[%1$s]\u6570\u636e\u5220\u9664", (Object)strDEId));
            }
            String strDER1NSync = xmlNode.GetExtValue("SRFDER1NSYNC", "");
            if (StringHelper.Compare((String)strDER1NSync, (String)"TRUE", (boolean)true) == 0) {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u5bfc\u5165\u5b9e\u4f53[%1$s]DER1N\u5173\u7cfb\u540c\u6b65", (Object)strDEId));
            }
            String strSQLPatch = xmlNode.GetExtValue("SRFSQLPATCH", "");
            if (StringHelper.Compare((String)strSQLPatch, (String)"TRUE", (boolean)true) == 0) {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u5bfc\u5165\u5b9e\u4f53[%1$s]\u6570\u636e\u5e93\u8865\u4e01 ", (Object)strDEId));
            }
            return null;
        }
        String strValueEx = xmlNode.GetExtValue("SRFVALUEEX", "");
        BaseDataEntity importDataEntity = BaseDataEntity.FromString((String)strValue);
        if (!StringHelper.IsNullOrEmpty((String)strValueEx) && (importDataEntity2 = BaseDataEntity.FromJSONString((String)strValueEx)) != null) {
            importDataEntity2.CopyTo(importDataEntity, false);
        }
        if (StringHelper.Compare((String)strDEId, (String)"DE0001", (boolean)true) == 0) {
            DataEntity dataEntity = new DataEntity();
            importDataEntity.CopyTo((BaseDataEntity)dataEntity, true);
            this.OnImportDataEntity(dataEntity);
            return dataEntity;
        }
        if (StringHelper.Compare((String)strDEId, (String)"DE0002", (boolean)true) == 0) {
            DEField deField = new DEField();
            importDataEntity.CopyTo((BaseDataEntity)deField, true);
            this.OnImportDEField(deField);
            return deField;
        }
        if (StringHelper.Compare((String)strDEId, (String)"DE0003", (boolean)true) == 0) {
            DER1N der1N = new DER1N();
            importDataEntity.CopyTo((BaseDataEntity)der1N, true);
            this.OnImportDER1N(der1N);
            return der1N;
        }
        if (StringHelper.Compare((String)strDEId, (String)"DE0016", (boolean)true) == 0) {
            DERINDEX derIndex = new DERINDEX();
            importDataEntity.CopyTo((BaseDataEntity)derIndex, true);
            this.OnImportDERIndex(derIndex);
            return derIndex;
        }
        if (StringHelper.Compare((String)strDEId, (String)"DE0009", (boolean)true) == 0) {
            CodeList codeList = new CodeList();
            importDataEntity.CopyTo((BaseDataEntity)codeList, true);
            this.OnImportCodeList(codeList);
            return codeList;
        }
        if (StringHelper.Compare((String)strDEId, (String)"DE0007", (boolean)true) == 0) {
            Form form = new Form();
            importDataEntity.CopyTo((BaseDataEntity)form, true);
            this.OnImportForm(form);
            return form;
        }
        if (StringHelper.Compare((String)strDEId, (String)"DE0008", (boolean)true) == 0) {
            DataGrid dataGrid = new DataGrid();
            importDataEntity.CopyTo((BaseDataEntity)dataGrid, true);
            this.OnImportDataGrid(dataGrid);
            return dataGrid;
        }
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u5bfc\u5165\u5b9e\u4f53[%1$s]\u6570\u636e ", (Object)strDEId));
    }

    protected void OnImportDataEntity(DataEntity dataEntity) throws Exception {
        PSDataEntityService psDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.sysSessionFactory);
        PSDataEntity psDataEntity = new PSDataEntity();
        String strPSDATAENTITYNAME = dataEntity.getDENAME().toUpperCase();
        psDataEntity.setPSDataEntityId(Helper.GenUniqueId((String)this.psDevSlnSys.getPSSystemId(), (String)strPSDATAENTITYNAME));
        if (psDataEntityService.checkKey((IEntity)psDataEntity) == 0) {
            String[] parts;
            PSModuleService psModuleService = (PSModuleService)ServiceGlobal.getService(PSModuleService.class, (SessionFactory)this.sysSessionFactory);
            PSSystem psSystem = new PSSystem();
            psSystem.setPSSystemId(this.psDevSlnSys.getPSSystemId());
            ArrayList psModuleList = psModuleService.selectByPSSystem((PSSystemBase)psSystem, "ORDER BY PSMODULENAME ");
            if (psModuleList.size() == 0) {
                throw new Exception(StringHelper.Format((String)"\u5bfc\u5165\u7cfb\u7edf\u672a\u5b9a\u4e49\u6a21\u5757"));
            }
            psDataEntity.setSystemFlag(Integer.valueOf(dataEntity.GetParamIntValue("ISSYSTEM", 0)));
            psDataEntity.setDEType(Integer.valueOf(dataEntity.getDETYPE()));
            psDataEntity.setDESN(dataEntity.getDEID());
            psDataEntity.setPSSystemId(this.psDevSlnSys.getPSSystemId());
            psDataEntity.setPSDataEntityName(dataEntity.getDENAME());
            psDataEntity.setLogicName(dataEntity.getDELOGICNAME());
            psDataEntity.setLogicValid(Integer.valueOf(dataEntity.isLOGICVALID() ? 1 : 0));
            psDataEntity.setTableName(dataEntity.getTABLENAME());
            if (!StringHelper.IsNullOrEmpty((String)psDataEntity.getTableName()) && (parts = psDataEntity.getTableName().split("[.]")).length > 1) {
                psDataEntity.setTableName(parts[parts.length - 1]);
            }
            psDataEntity.setPSModuleId(((PSModule)psModuleList.get(0)).getPSModuleId());
            psDataEntity.setCodeName(dataEntity.getDENAME());
            psDataEntity.setMemo(dataEntity.getParamStringValue("DESCRIPTION", null));
            psDataEntity.setExistingModel(Integer.valueOf(dataEntity.isEXITINGMODEL() ? 1 : 0));
            psDataEntityService.create((IEntity)psDataEntity);
        }
    }

    protected void OnImportDER1N(DER1N der1N) throws Exception {
        PSDERService psDERService = (PSDERService)ServiceGlobal.getService(PSDERService.class, (SessionFactory)this.sysSessionFactory);
        PSDER psDER = new PSDER();
        psDER.setPSSystemId(this.psDevSlnSys.getPSSystemId());
        psDER.setPSDERId(Helper.GenUniqueId((String)this.psDevSlnSys.getPSSystemId(), (String)der1N.getDERID()));
        if (!psDERService.get((IEntity)psDER, true)) {
            psDER.setDERType("DER1N");
            PSDataEntity psDataEntity = this.getPSDataEntityByDEId(der1N.getMAJORDEID());
            psDER.setMajorPSDEId(psDataEntity.getPSDataEntityId());
            psDER.setMajorPSDEName(psDataEntity.getPSDataEntityName());
            psDataEntity = this.getPSDataEntityByDEId(der1N.getMINORDEID());
            psDER.setMinorPSDEId(psDataEntity.getPSDataEntityId());
            psDER.setMinorPSDEName(psDataEntity.getPSDataEntityName());
            psDER.setDERFieldName(der1N.getMAJORKEYDEFNAME());
            psDER.setDERFieldLName(der1N.getDERLOGICNAME());
            psDER.setRemoveActionType(Integer.valueOf(2));
            if (der1N.getREMOVEACTIONTYPE() > 0) {
                psDER.setRemoveActionType(Integer.valueOf(der1N.getREMOVEACTIONTYPE()));
            }
            psDERService.create((IEntity)psDER);
        }
    }

    protected void OnImportDERIndex(DERINDEX derINDEX) throws Exception {
        PSDERService psDERService = (PSDERService)ServiceGlobal.getService(PSDERService.class, (SessionFactory)this.sysSessionFactory);
        PSDER psDER = new PSDER();
        psDER.setPSSystemId(this.psDevSlnSys.getPSSystemId());
        psDER.setPSDERId(Helper.GenUniqueId((String)this.psDevSlnSys.getPSSystemId(), (String)derINDEX.getDERINDEXID()));
        if (!psDERService.get((IEntity)psDER, true)) {
            if (derINDEX.isINHERITMODE()) {
                psDER.setDERType("DERINHERIT");
            } else {
                psDER.setDERType("DERINDEX");
            }
            PSDataEntity psDataEntity = this.getPSDataEntityByDEId(derINDEX.getINDEXDEID());
            psDER.setMajorPSDEId(psDataEntity.getPSDataEntityId());
            psDER.setMajorPSDEName(psDataEntity.getPSDataEntityName());
            psDataEntity = this.getPSDataEntityByDEId(derINDEX.getDEID());
            psDER.setMinorPSDEId(psDataEntity.getPSDataEntityId());
            psDER.setMinorPSDEName(psDataEntity.getPSDataEntityName());
            psDER.setIndexValue(derINDEX.getTYPEVALUE());
            psDERService.create((IEntity)psDER);
        }
    }

    protected void OnImportCodeList(CodeList codeList) throws Exception {
        PSCodeListService psCodeListService = (PSCodeListService)ServiceGlobal.getService(PSCodeListService.class, (SessionFactory)this.sysSessionFactory);
        PSCodeList psCodeList = new PSCodeList();
        psCodeList.setPSSystemId(this.psDevSlnSys.getPSSystemId());
        psCodeList.setPSCodeListId(Helper.GenUniqueId((String)this.psDevSlnSys.getPSSystemId(), (String)codeList.getCODELISTID()));
        if (!psCodeListService.get((IEntity)psCodeList, true)) {
            PSDEDataCtrl.convertEntity2((BaseDataEntity)codeList, (IEntity)psCodeList);
            String strDEId = codeList.getParamStringValue("DEID", "");
            if (!StringHelper.IsNullOrEmpty((String)strDEId)) {
                PSDataEntity psDataEntity = this.getPSDataEntityByDEId(strDEId);
                psCodeList.setPSDEId(psDataEntity.getPSDataEntityId());
                psCodeList.setPSDEName(psDataEntity.getPSDataEntityName());
            }
            psCodeList.setPSCodeListName(codeList.getCODELISTNAME());
            psCodeList.setPSSystemId(this.psDevSlnSys.getPSSystemId());
            psCodeList.setCodeListSN(codeList.getCODELISTID());
            String strCodeName = codeList.getCODELISTID();
            Matcher m = codeNamePattern.matcher(strCodeName);
            boolean b = m.matches();
            if (!b) {
                strCodeName = StringHelper.Format((String)"CL_%1$s", (Object)random.nextInt());
            }
            psCodeList.setCodeName(strCodeName);
            psCodeList.setUserScope(Integer.valueOf(codeList.isUSERSCOPE() ? 1 : 0));
            psCodeList.setEmptyText(codeList.getEMPTYTEXT());
            psCodeList.setNoValueEmpty(Integer.valueOf(codeList.isNOVALUEEMPTY() ? 1 : 0));
            if (StringHelper.IsNullOrEmpty((String)codeList.getFILLER())) {
                psCodeList.setCLType("STATIC");
            } else {
                psCodeList.setCLType("DYNAMIC");
                psCodeList.setMemo(codeList.getCLPARAM());
            }
            psCodeListService.create((IEntity)psCodeList);
        }
        if (StringHelper.Compare((String)psCodeList.getCLType(), (String)"STATIC", (boolean)true) == 0) {
            PSCodeItemService psCodeItemService = (PSCodeItemService)ServiceGlobal.getService(PSCodeItemService.class, (SessionFactory)this.sysSessionFactory);
            ArrayList psCodeItemList = psCodeItemService.selectByPSCodeList((PSCodeListBase)psCodeList);
            if (psCodeItemList.size() > 0) {
                return;
            }
            CodeListConfig codeListConfig = new CodeListConfig();
            XMLConfig.LoadFromXML((String)codeList.getCLMODEL(), (XMLConfig)codeListConfig);
            if (codeListConfig.getCodeItems() == null || codeListConfig.getCodeItems().size() == 0) {
                return;
            }
            int i = 0;
            while (i < codeListConfig.getCodeItems().size()) {
                CodeItemConfig codeItemConfig = (CodeItemConfig)codeListConfig.getCodeItems().get(i);
                this.onInitPSCodeItem(psCodeList, null, codeItemConfig, i);
                ++i;
            }
        }
    }

    protected void onInitPSCodeItem(PSCodeList psCodeList, PSCodeItem parentPSCodeItem, CodeItemConfig codeItemConfig, int nIndex) throws Exception {
        PSCodeItemService psCodeItemService = (PSCodeItemService)ServiceGlobal.getService(PSCodeItemService.class, (SessionFactory)this.sysSessionFactory);
        PSCodeItem psCodeItem = new PSCodeItem();
        psCodeItem.setPSCodeListId(psCodeList.getPSCodeListId());
        psCodeItem.setCodeItemValue(codeItemConfig.getValue());
        psCodeItem.setPSCodeItemName(codeItemConfig.getText());
        psCodeItem.setOrderValue(Integer.valueOf(nIndex));
        if (parentPSCodeItem != null) {
            psCodeItem.setPPSCodeItemId(parentPSCodeItem.getPSCodeItemId());
        }
        psCodeItemService.create((IEntity)psCodeItem);
        if (codeItemConfig.getCodeItems() == null || codeItemConfig.getCodeItems().size() == 0) {
            return;
        }
        int i = 0;
        while (i < codeItemConfig.getCodeItems().size()) {
            CodeItemConfig childCodeItemConfig = (CodeItemConfig)codeItemConfig.getCodeItems().get(i);
            this.onInitPSCodeItem(psCodeList, psCodeItem, childCodeItemConfig, i);
            ++i;
        }
    }

    protected void OnImportForm(Form form) throws Exception {
        PSDEFormDetailService psDEFormDetailService;
        ArrayList psDEFormDetailList;
        PSDEFormService psDEFormService = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)this.sysSessionFactory);
        PSDEForm psDEForm = new PSDEForm();
        PSDataEntity psDataEntity = this.getPSDataEntityByDEId(form.getDEID());
        psDEForm.setPSDEFormId(Helper.GenUniqueId((String)psDataEntity.getPSDataEntityId(), (String)form.getFORMID()));
        if (!psDEFormService.get((IEntity)psDEForm, true)) {
            psDEForm.setPSDEId(psDataEntity.getPSDataEntityId());
            psDEForm.setPSDEName(psDataEntity.getPSDataEntityName());
            psDEForm.setPSDEFormName(form.getFORMNAME());
            psDEForm.setFormSN(form.getFORMID());
            psDEForm.setFormType("EDITFORM");
            if (form.GetParamIntValue("ISMAJOR", 1) == 1) {
                psDEForm.setCodeName("Main2");
            } else {
                psDEForm.setCodeName(StringHelper.Format((String)"F%1$s", (Object)random.nextInt(100)));
            }
            psDEFormService.create((IEntity)psDEForm);
        }
        if ((psDEFormDetailList = (psDEFormDetailService = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.sysSessionFactory)).selectByPSDEForm((PSDEFormBase)psDEForm)).size() > 0) {
            return;
        }
        String strFormModel = form.getFORMMODEL();
        XmlNode xmlNode = XmlNode.loadFromXML((String)strFormModel);
        Iterator xmlNodes = xmlNode.getChildNodes();
        int nIndex = 0;
        while (xmlNodes.hasNext()) {
            XmlNode childXmlNode = (XmlNode)xmlNodes.next();
            this.savePSDEFormDetail(psDEForm, null, form, childXmlNode, ++nIndex);
        }
    }

    protected void savePSDEFormDetail(PSDEForm psDEForm, PSDEFormDetail parentPSDEFormDetail, Form form, XmlNode xmlNode, int nIndex) throws Exception {
        PSDEFormDetailService psDEFormDetailService = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.sysSessionFactory);
        String strNodeName = xmlNode.getNodeName();
        int nValue = DataObject.getIntegerValue((IDataObject)psDEForm, (String)strNodeName, (int)0);
        psDEForm.set(strNodeName, (Object)(++nValue));
        PSDEFormDetail psDEFormDetail = new PSDEFormDetail();
        psDEFormDetail.setPSDEFormId(psDEForm.getPSDEFormId());
        psDEFormDetail.setPSDEFormName(psDEForm.getPSDEFormName());
        psDEFormDetail.setOrderValue(Integer.valueOf(nIndex));
        psDEFormDetail.setCaption(xmlNode.getAttribute("CAPTION", ""));
        psDEFormDetail.setColModel(xmlNode.getAttribute("COLUMNS", ""));
        String strFormPartId = "";
        int nColSpan = xmlNode.getAttribute("COLSPAN", -1);
        if (nColSpan != -1) {
            psDEFormDetail.setColSpan(Integer.valueOf(nColSpan));
        }
        if (parentPSDEFormDetail != null) {
            psDEFormDetail.setPPSDEFormDetailId(parentPSDEFormDetail.getPSDEFormDetailId());
        }
        if (StringHelper.Compare((String)strNodeName, (String)"SRFEXDPPAGEGROUP", (boolean)true) == 0) {
            psDEFormDetail.setDetailType("FORMPAGE");
        } else if (StringHelper.Compare((String)strNodeName, (String)"SRFEXDPTABGROUP", (boolean)true) == 0) {
            psDEFormDetail.setDetailType("TABPANEL");
        } else if (StringHelper.Compare((String)strNodeName, (String)"SRFEXDPPAGEGROUP", (boolean)true) == 0) {
            psDEFormDetail.setDetailType("TABPAGE");
        } else if (StringHelper.Compare((String)strNodeName, (String)"SRFEXDPGROUP", (boolean)true) == 0) {
            psDEFormDetail.setDetailType("GROUPPANEL");
            if (xmlNode.getAttribute("SHOWCAPTION", true)) {
                psDEFormDetail.setShowCaption(Integer.valueOf(1));
            } else {
                psDEFormDetail.setShowCaption(Integer.valueOf(0));
            }
        } else if (StringHelper.Compare((String)strNodeName, (String)"SRFEXDPFORMITEM", (boolean)true) == 0) {
            String strEditorType;
            psDEFormDetail.setDetailType("FORMITEM");
            String strDEFID = xmlNode.getAttribute("DEFID", "");
            if (StringHelper.IsNullOrEmpty((String)strDEFID)) {
                strDEFID = xmlNode.getAttribute("DEFNAME", "");
            }
            if (StringHelper.IsNullOrEmpty((String)strDEFID)) {
                strDEFID = xmlNode.getAttribute("DEFIELD", "");
            }
            PSDEField psDEField = this.getPSDEFieldByDEFName(form.getDEID(), strDEFID);
            String strDEFLogicName = xmlNode.getAttribute("DEFLOGICNAME", "");
            if (StringHelper.IsNullOrEmpty((String)strDEFLogicName)) {
                strDEFLogicName = psDEField.getLogicName();
            }
            psDEFormDetail.setLogicName(strDEFLogicName);
            if (xmlNode.getAttribute("SHOWCAPTION", true)) {
                psDEFormDetail.setShowCaption(Integer.valueOf(1));
            } else {
                psDEFormDetail.setShowCaption(Integer.valueOf(0));
                psDEFormDetail.setLabelPos("NONE");
            }
            String strAllowEmpty = xmlNode.getAttribute("ALLOWEMPTY", "");
            if (!StringHelper.IsNullOrEmpty((String)strAllowEmpty)) {
                psDEFormDetail.setAllowEmpty(Integer.valueOf(StringHelper.Compare((String)strAllowEmpty, (String)"TRUE", (boolean)true) == 0 ? 1 : 0));
            }
            if (!StringHelper.IsNullOrEmpty((String)(strEditorType = xmlNode.getAttribute("FC_FORMITEMSTYLE", "")))) {
                strEditorType = strEditorType.replace("SRFEX", "");
                psDEFormDetail.setEditorType(strEditorType);
            }
            psDEFormDetail.setPSDEFormDetailName(psDEField.getPSDEFieldName().toLowerCase());
            psDEFormDetail.setPSDEFId(psDEField.getPSDEFieldId());
            String strFIExtParams = xmlNode.getAttribute("FI_EXTPARAMS", "");
            if (!StringHelper.IsNullOrEmpty((String)strFIExtParams)) {
                Properties properties = PropertiesHelper.load((String)strFIExtParams);
                String strValue = PropertiesHelper.getProperty((Properties)properties, (String)"HEIGHT");
                if (!StringHelper.IsNullOrEmpty((String)strValue)) {
                    psDEFormDetail.setCtrlHeight(Integer.valueOf(Integer.parseInt(strValue)));
                }
                if (!StringHelper.IsNullOrEmpty((String)(strValue = PropertiesHelper.getProperty((Properties)properties, (String)"WIDTH")))) {
                    psDEFormDetail.setCtrlWidth(Integer.valueOf(Integer.parseInt(strValue)));
                }
            }
        } else if (StringHelper.Compare((String)strNodeName, (String)"SRFEXDPRAWITEM", (boolean)true) == 0) {
            strFormPartId = xmlNode.getAttribute("FORMPARTID", "");
            if (StringHelper.IsNullOrEmpty((String)strFormPartId)) {
                psDEFormDetail.setDetailType("GROUPPANEL");
                psDEFormDetail.setShowCaption(Integer.valueOf(0));
                psDEFormDetail.setPSDEFormDetailName(StringHelper.Format((String)"%1$s%2$s", (Object)"raw", (Object)nValue));
            }
        } else if (StringHelper.Compare((String)strNodeName, (String)"SRFEXDPDATAGRIDITEM", (boolean)true) == 0) {
            int nHeight = xmlNode.getAttribute("HEIGHT", 300);
            psDEFormDetail.setDetailType("DRUIPART");
            psDEFormDetail.setHeight(Integer.valueOf(nHeight));
            String strDER1NId = xmlNode.getAttribute("DER1NID", "");
            if (StringHelper.IsNullOrEmpty((String)strDER1NId)) {
                throw new Exception(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9aDER1N"));
            }
            psDEFormDetail.setPSDEDRItemId(Helper.GenUniqueId((String)this.psDevSlnSys.getPSSystemId(), (String)strDER1NId));
        } else {
            psDEFormDetail.setDetailType("GROUPPANEL");
            psDEFormDetail.setShowCaption(Integer.valueOf(1));
            psDEFormDetail.setCaption(StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684[%1$s]", (Object)strNodeName));
        }
        if (StringHelper.IsNullOrEmpty((String)psDEFormDetail.getPSDEFormDetailName())) {
            if (nValue == 1) {
                psDEFormDetail.setPSDEFormDetailName(StringHelper.Format((String)"%1$s%2$s", (Object)psDEFormDetail.getDetailType().toLowerCase(), (Object)nValue));
            } else {
                psDEFormDetail.setPSDEFormDetailName(StringHelper.Format((String)"%1$s%2$s", (Object)psDEFormDetail.getDetailType().toLowerCase(), (Object)nValue));
            }
        }
        psDEFormDetailService.create((IEntity)psDEFormDetail);
        Iterator xmlNodes = xmlNode.getChildNodes();
        if (xmlNodes != null) {
            int nChildIndex = 0;
            while (xmlNodes.hasNext()) {
                XmlNode childXmlNode = (XmlNode)xmlNodes.next();
                this.savePSDEFormDetail(psDEForm, psDEFormDetail, form, childXmlNode, ++nChildIndex);
            }
        }
    }

    protected void OnImportDataGrid(DataGrid dataGrid) throws Exception {
        PSDEGridColService psDEGridColService;
        ArrayList psDEGridColumnList;
        PSDEGridService psDEGridService = (PSDEGridService)ServiceGlobal.getService(PSDEGridService.class, (SessionFactory)this.sysSessionFactory);
        PSDEGrid psDEGrid = new PSDEGrid();
        PSDataEntity psDataEntity = this.getPSDataEntityByDEId(dataGrid.getDEID());
        psDEGrid.setPSDEGridId(Helper.GenUniqueId((String)psDataEntity.getPSDataEntityId(), (String)dataGrid.getDATAGRIDID()));
        if (!psDEGridService.get((IEntity)psDEGrid, true)) {
            psDEGrid.setPSDEId(psDataEntity.getPSDataEntityId());
            psDEGrid.setPSDEName(psDataEntity.getPSDataEntityName());
            psDEGrid.setPSDEGridName(dataGrid.getDATAGRIDNAME());
            psDEGrid.setPagingSize(Integer.valueOf(dataGrid.getPAGESIZE()));
            psDEGrid.setEnablePagingBar(Integer.valueOf(1));
            psDEGrid.setGridSN(dataGrid.getDATAGRIDID());
            if (dataGrid.GetParamIntValue("ISMAJOR", 1) == 1) {
                psDEGrid.setCodeName("Main2");
            } else {
                psDEGrid.setCodeName(StringHelper.Format((String)"G%1$s", (Object)random.nextInt(100)));
            }
            psDEGridService.create((IEntity)psDEGrid);
        }
        if ((psDEGridColumnList = (psDEGridColService = (PSDEGridColService)ServiceGlobal.getService(PSDEGridColService.class, (SessionFactory)this.sysSessionFactory)).selectByPSDEGrid((PSDEGridBase)psDEGrid)).size() > 0) {
            return;
        }
        DataGridModelConfig dataGridModelConfig = dataGrid.getDataGridModelConfig();
        int nOrderValue = 0;
        for (DGModelColumnConfig columnConfig : dataGridModelConfig.getColumnsConfig()) {
            PSDEField psDEField = this.getPSDEFieldByDEFName(dataGrid.getDEID(), columnConfig.getDEField());
            PSDEGridCol psDEGridColumn = new PSDEGridCol();
            psDEGridColumn.setPSDEGridColName(psDEField.getPSDEFieldName().toLowerCase());
            psDEGridColumn.setLogicName(psDEField.getLogicName());
            psDEGridColumn.setOrderValue(Integer.valueOf(++nOrderValue));
            psDEGridColumn.setPSDEGridId(psDEGrid.getPSDEGridId());
            psDEGridColumn.setPSDEId(psDEGrid.getPSDEId());
            psDEGridColumn.setWidth(Integer.valueOf(columnConfig.getWidth()));
            psDEGridColumn.setPSDEFId(psDEField.getPSDEFieldId());
            psDEGridColumn.setGridColType("DEFGRIDCOLUMN");
            psDEGridColService.create((IEntity)psDEGridColumn);
        }
    }

    protected PSDataEntity getPSDataEntityByDEId(String strDEId) throws Exception {
        PSDataEntity psDataEntity = this.psDataEntityMap.get(strDEId);
        if (psDataEntity != null) {
            return psDataEntity;
        }
        PSDataEntityService psDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.sysSessionFactory);
        psDataEntity = new PSDataEntity();
        psDataEntity.setPSSystemId(this.psDevSlnSys.getPSSystemId());
        psDataEntity.setDESN(strDEId);
        if (!psDataEntityService.select((IEntity)psDataEntity, true)) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6807\u793a\u4e3a[%1$s]\u7684\u5b9e\u4f53", (Object)strDEId));
        }
        this.psDataEntityMap.put(strDEId, psDataEntity);
        return psDataEntity;
    }

    protected PSDEField getPSDEFieldByDEFName(String strDEId, String strDEFName) throws Exception {
        PSDEField psDEField;
        PSDEFieldService psDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.sysSessionFactory);
        PSDataEntity psDataEntity = this.getPSDataEntityByDEId(strDEId);
        HashMap<String, Object> psDEFieldMap = this.psDEFieldMap.get(strDEId);
        if (psDEFieldMap == null) {
            psDEFieldMap = new HashMap();
            this.psDEFieldMap.put(strDEId, psDEFieldMap);
            ArrayList psDEFieldList = psDEFieldService.selectByPSDE((PSDataEntityBase)psDataEntity);
            for (PSDEField psDEField2 : psDEFieldList) {
                psDEFieldMap.put(psDEField2.getPSDEFieldName(), psDEField2);
                psDEFieldMap.put(StringHelper.Format((String)"%1$s_%2$s", (Object)strDEId, (Object)psDEField2.getPSDEFieldName()), psDEField2);
            }
        }
        if ((psDEField = psDEFieldMap.get(strDEFName)) != null) {
            return psDEField;
        }
        psDEField = new PSDEField();
        psDEField.setPSDEId(psDataEntity.getPSDataEntityId());
        psDEField.setPSDEFieldName(strDEFName);
        if (!psDEFieldService.select((IEntity)psDEField, true)) {
            String strDEFName2 = strDEFName.replace(String.valueOf(strDEId) + "_", "");
            psDEField.setPSDEFieldName(strDEFName2);
            if (!psDEFieldService.select((IEntity)psDEField, true)) {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u540d\u79f0\u4e3a[%2$s]\u7684\u5c5e\u6027", (Object)strDEId, (Object)strDEFName));
            }
        }
        psDEFieldMap.put(psDEField.getPSDEFieldName(), psDEField);
        psDEFieldMap.put(StringHelper.Format((String)"%1$s_%2$s", (Object)strDEId, (Object)psDEField.getPSDEFieldName()), psDEField);
        return psDEField;
    }

    protected PSCodeList getPSCodeListByCLId(String strCodeListId) throws Exception {
        PSCodeList psCodeList = this.psCodeListMap.get(strCodeListId);
        if (psCodeList != null) {
            return psCodeList;
        }
        PSCodeListService psCodeListService = (PSCodeListService)ServiceGlobal.getService(PSCodeListService.class, (SessionFactory)this.sysSessionFactory);
        psCodeList = new PSCodeList();
        psCodeList.setPSSystemId(this.psDevSlnSys.getPSSystemId());
        psCodeList.setCodeListSN(strCodeListId);
        if (!psCodeListService.select((IEntity)psCodeList, true)) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6807\u793a\u4e3a[%1$s]\u7684\u4ee3\u7801\u8868", (Object)strCodeListId));
        }
        this.psCodeListMap.put(strCodeListId, psCodeList);
        return psCodeList;
    }

    protected PSDER getPSDER1NByDER1NId(String strDER1NId) throws Exception {
        PSDER psDER = this.psDER1NMap.get(strDER1NId);
        if (psDER != null) {
            return psDER;
        }
        PSDERService psDERService = (PSDERService)ServiceGlobal.getService(PSDERService.class, (SessionFactory)this.sysSessionFactory);
        psDER = new PSDER();
        psDER.setPSDERId(Helper.GenUniqueId((String)this.psDevSlnSys.getPSSystemId(), (String)strDER1NId));
        if (!psDERService.get((IEntity)psDER, true)) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6807\u793a\u4e3a[%1$s]\u7684DER1N", (Object)strDER1NId));
        }
        this.psDER1NMap.put(strDER1NId, psDER);
        return psDER;
    }

    protected PSDER getPSDERInheritByMinorPSDEId(String strPSDEId) throws Exception {
        PSDER psDER = this.psDERIndexMap.get(strPSDEId);
        if (psDER != null) {
            return psDER;
        }
        PSDERService psDERService = (PSDERService)ServiceGlobal.getService(PSDERService.class, (SessionFactory)this.sysSessionFactory);
        psDER = new PSDER();
        psDER.setMinorPSDEId(strPSDEId);
        psDER.setDERType("DERINHERIT");
        if (!psDERService.select((IEntity)psDER, true)) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u4ece\u5b9e\u4f53\u6807\u793a\u4e3a[%1$s]\u7684DERInherit", (Object)strPSDEId));
        }
        this.psDERIndexMap.put(strPSDEId, psDER);
        return psDER;
    }

    protected void OnImportDEField(DEField deField) throws Exception {
        PSDataEntity psDataEntity = this.getPSDataEntityByDEId(deField.getDEID());
        PSDEFieldService psDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.sysSessionFactory);
        if (StringHelper.Compare((String)deField.getDATATYPE(), (String)"PICKUP", (boolean)true) == 0 || StringHelper.Compare((String)deField.getDATATYPE(), (String)"PICKUPTEXT", (boolean)true) == 0 || StringHelper.Compare((String)deField.getDATATYPE(), (String)"PICKUPDATA", (boolean)true) == 0) {
            PSDEField psDEField = new PSDEField();
            psDEField.setPSDEFieldId(Helper.GenUniqueId((String)psDataEntity.getPSDataEntityId(), (String)deField.getDEFNAME().toUpperCase()));
            if (!psDEFieldService.get((IEntity)psDEField, true)) {
                String[] parts;
                String strDER1NId = deField.getDATATYPEPARAM4();
                PSDER psDER = this.getPSDER1NByDER1NId(strDER1NId);
                psDEField.setPSDEId(psDER.getMinorPSDEId());
                psDEField.setDEFType(Integer.valueOf(deField.getDEFTYPE()));
                psDEField.setPSDEName(psDER.getMinorPSDEName());
                psDEField.setPSDEFieldName(deField.getDEFNAME().toUpperCase());
                psDEField.setLogicName(deField.getDEFLOGICNAME());
                psDEField.setPSDataTypeId(deField.getDATATYPE());
                if (!deField.isLENGTHNull()) {
                    psDEField.setLength(Integer.valueOf(deField.getLENGTH()));
                }
                if (!deField.isPRECISION2Null()) {
                    psDEField.setPrecision2(Integer.valueOf(deField.getPRECISION2()));
                }
                psDEField.setAllowEmpty(Integer.valueOf(deField.isNULLABLE() ? 1 : 0));
                psDEField.setMajorField(Integer.valueOf(deField.isMAJOR() ? 1 : 0));
                psDEField.setFKey(Integer.valueOf(deField.isFKEY() ? 1 : 0));
                psDEField.setPKey(Integer.valueOf(deField.isPKEY() ? 1 : 0));
                psDEField.setTableName(deField.getTABLENAME());
                if (!StringHelper.IsNullOrEmpty((String)psDEField.getTableName()) && (parts = psDEField.getTableName().split("[.]")).length > 1) {
                    psDEField.setTableName(parts[parts.length - 1]);
                }
                psDEField.setMemo(deField.getDESCRIPTION());
                int nUIAction = 0;
                if (deField.isENABLECREATE()) {
                    nUIAction = 1;
                }
                if (deField.isENABLEMODIFY()) {
                    nUIAction |= 2;
                }
                psDEField.setEnableUserInput(Integer.valueOf(nUIAction));
                psDEField.setPSDERId(psDER.getPSDERId());
                psDEField.setMemo(deField.getDESCRIPTION());
                PSDEField relatedDEField = new PSDEField();
                relatedDEField.setPSDEId(psDER.getMajorPSDEId());
                relatedDEField.setPSDEFieldName(deField.getRDEFNAME().toUpperCase());
                if (!psDEFieldService.select((IEntity)relatedDEField, true)) {
                    throw new Exception(StringHelper.Format((String)"\u5b9e\u4f53[%1%2]\u5c5e\u6027[%2$s]\u4e0d\u5b58\u5728", (Object)psDER.getMajorPSDE().getPSDataEntityName(), (Object)deField.getRDEFNAME()));
                }
                psDEField.setDERPSDEFId(relatedDEField.getPSDEFieldId());
                psDEField.setDERPSDEFName(relatedDEField.getPSDEFieldName());
                psDEFieldService.create((IEntity)psDEField);
            }
        } else if (StringHelper.Compare((String)deField.getDATATYPE(), (String)"INHERIT", (boolean)true) == 0) {
            PSDEField psDEField = new PSDEField();
            psDEField.setPSDEFieldId(Helper.GenUniqueId((String)psDataEntity.getPSDataEntityId(), (String)deField.getDEFNAME().toUpperCase()));
            if (!psDEFieldService.get((IEntity)psDEField, true)) {
                PSDER psDER = this.getPSDERInheritByMinorPSDEId(psDataEntity.getPSDataEntityId());
                psDEField.setPSDEId(psDataEntity.getPSDataEntityId());
                psDEField.setDEFType(Integer.valueOf(deField.getDEFTYPE()));
                psDEField.setPSDEName(psDataEntity.getPSDataEntityName());
                psDEField.setPSDEFieldName(deField.getDEFNAME().toUpperCase());
                psDEField.setLogicName(deField.getDEFLOGICNAME());
                psDEField.setPSDataTypeId(deField.getDATATYPE());
                psDEField.setMajorField(Integer.valueOf(0));
                if (!deField.isLENGTHNull()) {
                    psDEField.setLength(Integer.valueOf(deField.getLENGTH()));
                }
                if (!deField.isPRECISION2Null()) {
                    psDEField.setPrecision2(Integer.valueOf(deField.getPRECISION2()));
                }
                psDEField.setAllowEmpty(Integer.valueOf(deField.isNULLABLE() ? 1 : 0));
                int nUIAction = 0;
                if (deField.isENABLECREATE()) {
                    nUIAction = 1;
                }
                if (deField.isENABLEMODIFY()) {
                    nUIAction |= 2;
                }
                psDEField.setEnableUserInput(Integer.valueOf(nUIAction));
                psDEField.setPSDERId(psDER.getPSDERId());
                psDEField.setMemo(deField.getDESCRIPTION());
                PSDEField relatedDEField = new PSDEField();
                relatedDEField.setPSDEId(psDER.getMajorPSDEId());
                relatedDEField.setPSDEFieldName(deField.getRDEFNAME().toUpperCase());
                if (!psDEFieldService.select((IEntity)relatedDEField, true)) {
                    throw new Exception(StringHelper.Format((String)"\u5b9e\u4f53[%1%2]\u5c5e\u6027[%2$s]\u4e0d\u5b58\u5728", (Object)psDER.getMajorPSDE().getPSDataEntityName(), (Object)deField.getRDEFNAME()));
                }
                psDEField.setDERPSDEFId(relatedDEField.getPSDEFieldId());
                psDEField.setDERPSDEFName(relatedDEField.getPSDEFieldName());
                psDEFieldService.create((IEntity)psDEField);
            }
        } else {
            PSDEField psDEField = new PSDEField();
            psDEField.setPSDEFieldId(Helper.GenUniqueId((String)psDataEntity.getPSDataEntityId(), (String)deField.getDEFNAME().toUpperCase()));
            if (!psDEFieldService.get((IEntity)psDEField, true)) {
                psDEField.setPSDEId(psDataEntity.getPSDataEntityId());
                psDEField.setDEFType(Integer.valueOf(deField.getDEFTYPE()));
                psDEField.setPSDEName(psDataEntity.getPSDataEntityName());
                psDEField.setPSDEFieldName(deField.getDEFNAME().toUpperCase());
                psDEField.setLogicName(deField.getDEFLOGICNAME());
                psDEField.setPSDataTypeId(deField.getDATATYPE());
                if (!deField.isLENGTHNull()) {
                    psDEField.setLength(Integer.valueOf(deField.getLENGTH()));
                }
                if (!deField.isPRECISION2Null()) {
                    psDEField.setPrecision2(Integer.valueOf(deField.getPRECISION2()));
                }
                psDEField.setAllowEmpty(Integer.valueOf(deField.isNULLABLE() ? 1 : 0));
                psDEField.setMajorField(Integer.valueOf(deField.isMAJOR() ? 1 : 0));
                psDEField.setFKey(Integer.valueOf(deField.isFKEY() ? 1 : 0));
                psDEField.setPKey(Integer.valueOf(deField.isPKEY() ? 1 : 0));
                psDEField.setTableName(deField.getTABLENAME());
                psDEField.setFormulaFormat(deField.getFORMULAFORMAT());
                psDEField.setFormulaFields(deField.getFORMULAFIELD());
                psDEField.setMemo(deField.getDESCRIPTION());
                int nUIAction = 0;
                if (deField.isENABLECREATE()) {
                    nUIAction = 1;
                }
                if (deField.isENABLEMODIFY()) {
                    nUIAction |= 2;
                }
                psDEField.setEnableUserInput(Integer.valueOf(nUIAction));
                psDEField.setIndexType(Integer.valueOf(deField.isINDEXTYPE() ? 1 : 0));
                if (!StringHelper.IsNullOrEmpty((String)deField.getCODELISTID())) {
                    psDEField.setPSCodeListId(this.getPSCodeListByCLId(deField.getCODELISTID()).getPSCodeListId());
                }
                psDEFieldService.create((IEntity)psDEField);
            } else {
                boolean bModify = false;
                if (!StringHelper.IsNullOrEmpty((String)deField.getCODELISTID()) && StringHelper.IsNullOrEmpty((String)psDEField.getPSCodeListId())) {
                    bModify = true;
                    psDEField.setPSCodeListId(this.getPSCodeListByCLId(deField.getCODELISTID()).getPSCodeListId());
                }
                if (bModify) {
                    psDEFieldService.update((IEntity)psDEField);
                }
            }
        }
    }
}

