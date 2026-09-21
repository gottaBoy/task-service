/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ArrayNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.db.SqlParamList
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.EntityError
 *  net.ibizsys.paas.entity.EntityFieldError
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.entity.SimpleEntity
 *  net.ibizsys.paas.service.CloneSession
 *  net.ibizsys.paas.service.IDataContextParam
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.service.SessionFactoryManager
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.wfdesign.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.SimpleEntity;
import net.ibizsys.paas.service.CloneSession;
import net.ibizsys.paas.service.IDataContextParam;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.config.entity.PSDBValueOP;
import net.ibizsys.pscore.srv.config.entity.PSDBValueOPBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.ibizsys.pscore.srv.wfdesign.dao.PSWFLinkCondDAO;
import net.ibizsys.pscore.srv.wfdesign.demodel.PSWFLinkCondDEModel;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFLink;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFLinkBase;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFLinkCond;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFLinkCondBase;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFVersion;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFVersionBase;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFLinkCondService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSWFLinkCondServiceBase
extends PSCoreSysServiceBase<PSWFLinkCond> {
    private static final Log log = LogFactory.getLog(PSWFLinkCondServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSWFLinkCondDEModel pSWFLinkCondDEModel;
    private PSWFLinkCondDAO pSWFLinkCondDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.wfdesign.service.PSWFLinkCondService";
    }

    public PSWFLinkCondDEModel getPSWFLinkCondDEModel() {
        if (this.pSWFLinkCondDEModel == null) {
            try {
                this.pSWFLinkCondDEModel = (PSWFLinkCondDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.wfdesign.demodel.PSWFLinkCondDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWFLinkCondDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSWFLinkCondDEModel();
    }

    public PSWFLinkCondDAO getPSWFLinkCondDAO() {
        if (this.pSWFLinkCondDAO == null) {
            try {
                this.pSWFLinkCondDAO = (PSWFLinkCondDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.wfdesign.dao.PSWFLinkCondDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWFLinkCondDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSWFLinkCondDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchTempDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSetTemp(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, true);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSWFLinkCond pSWFLinkCond, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFLINKCOND_PSDBVALUEOP_PSDBVALUEOPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSDBValueOPService", (SessionFactory)this.getSessionFactory());
            PSDBValueOP pSDBValueOP = (PSDBValueOP)iService.getDEModel().createEntity();
            pSDBValueOP.set("PSDBVALUEOPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDBValueOP);
            } else {
                iService.get((IEntity)pSDBValueOP);
            }
            this.onFillParentInfo_PSDBValueOP(pSWFLinkCond, pSDBValueOP);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFLINKCOND_PSDEFIELD_DSTPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_DstPSDEF(pSWFLinkCond, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFLINKCOND_PSWFLINKCOND_PPSWFLINKCONDID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWFLinkCondService", (SessionFactory)this.getSessionFactory());
            PSWFLinkCond pSWFLinkCond2 = (PSWFLinkCond)iService.getDEModel().createEntity();
            pSWFLinkCond2.set("PSWFLINKCONDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSWFLinkCond2);
            } else {
                iService.get((IEntity)pSWFLinkCond2);
            }
            this.onFillParentInfo_PPWFLinkCond(pSWFLinkCond, pSWFLinkCond2);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFLINKCOND_PSWFLINK_PSWFLINKID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWFLinkService", (SessionFactory)this.getSessionFactory());
            PSWFLink pSWFLink = (PSWFLink)iService.getDEModel().createEntity();
            pSWFLink.set("PSWFLINKID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSWFLink);
            } else {
                iService.get((IEntity)pSWFLink);
            }
            this.onFillParentInfo_PSWFLink(pSWFLinkCond, pSWFLink);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFLINKCOND_PSWFVERSION_PSWFVERSIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWFVersionService", (SessionFactory)this.getSessionFactory());
            PSWFVersion pSWFVersion = (PSWFVersion)iService.getDEModel().createEntity();
            pSWFVersion.set("PSWFVERSIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSWFVersion);
            } else {
                iService.get((IEntity)pSWFVersion);
            }
            this.onFillParentInfo_PSWFVersion(pSWFLinkCond, pSWFVersion);
            return;
        }
        super.onFillParentInfo((IEntity)pSWFLinkCond, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        if (StringHelper.compare((String)string, (String)"DER1N_PSWFLINKCOND_PSWFLINK_PSWFLINKID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWFLinkService", (SessionFactory)this.getSessionFactory());
            PSWFLink pSWFLink = (PSWFLink)iService.getDEModel().createEntity();
            pSWFLink.set("PSWFLINKID", string2);
            return this.onSyncDER1NData_PSWFLink(pSWFLink, string3);
        }
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDBValueOP(PSWFLinkCond pSWFLinkCond, PSDBValueOP pSDBValueOP) throws Exception {
        pSWFLinkCond.setPSDBValueOPId(pSDBValueOP.getPSDBValueOPId());
        pSWFLinkCond.setPSDBValueOPName(pSDBValueOP.getPSDBValueOPName());
    }

    protected void onFillParentInfo_DstPSDEF(PSWFLinkCond pSWFLinkCond, PSDEField pSDEField) throws Exception {
        pSWFLinkCond.setDstPSDEFId(pSDEField.getPSDEFieldId());
        pSWFLinkCond.setDstPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_PPWFLinkCond(PSWFLinkCond pSWFLinkCond, PSWFLinkCond pSWFLinkCond2) throws Exception {
        pSWFLinkCond.setPPSWFLinkCondId(pSWFLinkCond2.getPSWFLinkCondId());
        pSWFLinkCond.setPPSWFLinkCondName(pSWFLinkCond2.getPSWFLinkCondName());
        if (pSWFLinkCond2.getPSWFLink() != null) {
            this.onFillParentInfo_PSWFLink(pSWFLinkCond, pSWFLinkCond2.getPSWFLink());
        }
    }

    protected void onFillParentInfo_PSWFLink(PSWFLinkCond pSWFLinkCond, PSWFLink pSWFLink) throws Exception {
        pSWFLinkCond.setPSWFLinkId(pSWFLink.getPSWFLinkId());
        pSWFLinkCond.setPSWFLinkName(pSWFLink.getPSWFLinkName());
        if (pSWFLink.getPSWFVersion() != null) {
            this.onFillParentInfo_PSWFVersion(pSWFLinkCond, pSWFLink.getPSWFVersion());
        }
    }

    protected String onSyncDER1NData_PSWFLink(PSWFLink pSWFLink, String string) throws Exception {
        if (StringHelper.isNullOrEmpty((String)string)) {
            this.removeByPSWFLink(pSWFLink);
        } else {
            HashMap<String, String> hashMap = new HashMap<String, String>();
            String[] stringArray = StringHelper.splitEx((String)string);
            if (stringArray != null) {
                for (int i = 0; i < stringArray.length; ++i) {
                    if (StringHelper.isNullOrEmpty((String)stringArray[i])) continue;
                    hashMap.put(stringArray[i], "");
                }
            }
            ArrayList<PSWFLinkCond> arrayList = this.selectByPSWFLink(pSWFLink);
            for (PSWFLinkCond pSWFLinkCond : arrayList) {
                if (hashMap.containsKey(DataObject.getStringValue((IDataObject)pSWFLinkCond, (String)"PSWFLINKCONDID", (String)""))) continue;
                this.remove((IEntity)pSWFLinkCond);
            }
        }
        return null;
    }

    protected void onFillParentInfo_PSWFVersion(PSWFLinkCond pSWFLinkCond, PSWFVersion pSWFVersion) throws Exception {
        pSWFLinkCond.setPSWFVersionId(pSWFVersion.getPSWFVersionId());
        pSWFLinkCond.setPSWFVersionName(pSWFVersion.getPSWFVersionName());
    }

    protected void onFillEntityFullInfo(PSWFLinkCond pSWFLinkCond, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSWFLinkCond, bl);
        this.onFillEntityFullInfo_PSDBValueOP(pSWFLinkCond, bl);
        this.onFillEntityFullInfo_DstPSDEF(pSWFLinkCond, bl);
        this.onFillEntityFullInfo_PPWFLinkCond(pSWFLinkCond, bl);
        this.onFillEntityFullInfo_PSWFLink(pSWFLinkCond, bl);
        this.onFillEntityFullInfo_PSWFVersion(pSWFLinkCond, bl);
    }

    protected void onFillEntityFullInfo_PSDBValueOP(PSWFLinkCond pSWFLinkCond, boolean bl) throws Exception {
        if (pSWFLinkCond.isPSDBValueOPIdDirty()) {
            if (pSWFLinkCond.getPSDBValueOPId() != null) {
                if (pSWFLinkCond.getPSDBValueOPId() == null || pSWFLinkCond.getPSDBValueOPName() == null) {
                    PSDBValueOP pSDBValueOP = pSWFLinkCond.getPSDBValueOP();
                    pSWFLinkCond.setPSDBValueOPName(pSDBValueOP.getPSDBValueOPName());
                }
            } else {
                pSWFLinkCond.setPSDBValueOPName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_DstPSDEF(PSWFLinkCond pSWFLinkCond, boolean bl) throws Exception {
        if (pSWFLinkCond.isDstPSDEFIdDirty()) {
            if (pSWFLinkCond.getDstPSDEFId() != null) {
                if (pSWFLinkCond.getDstPSDEFId() == null || pSWFLinkCond.getDstPSDEFName() == null) {
                    PSDEField pSDEField = pSWFLinkCond.getDstPSDEF();
                    pSWFLinkCond.setDstPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSWFLinkCond.setDstPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PPWFLinkCond(PSWFLinkCond pSWFLinkCond, boolean bl) throws Exception {
        if (pSWFLinkCond.isPPSWFLinkCondIdDirty()) {
            if (pSWFLinkCond.getPPSWFLinkCondId() != null) {
                PSWFLinkCond pSWFLinkCond2;
                if (pSWFLinkCond.getPPSWFLinkCondId() == null || pSWFLinkCond.getPPSWFLinkCondName() == null) {
                    pSWFLinkCond2 = pSWFLinkCond.getPPWFLinkCond();
                    pSWFLinkCond.setPPSWFLinkCondName(pSWFLinkCond2.getPSWFLinkCondName());
                }
                if (DataTypeHelper.compare((int)25, (Object)(pSWFLinkCond2 = pSWFLinkCond.getPPWFLinkCond()).getPSWFLinkId(), (Object)pSWFLinkCond.getPSWFLinkId()) != 0L) {
                    pSWFLinkCond.setPSWFLinkId(pSWFLinkCond2.getPSWFLinkId());
                    this.onFillEntityFullInfo_PSWFLink(pSWFLinkCond, bl);
                }
            } else {
                pSWFLinkCond.setPPSWFLinkCondName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSWFLink(PSWFLinkCond pSWFLinkCond, boolean bl) throws Exception {
        if (pSWFLinkCond.isPSWFLinkIdDirty()) {
            if (pSWFLinkCond.getPSWFLinkId() != null) {
                PSWFLink pSWFLink;
                if (pSWFLinkCond.getPSWFLinkId() == null || pSWFLinkCond.getPSWFLinkName() == null) {
                    pSWFLink = pSWFLinkCond.getPSWFLink();
                    pSWFLinkCond.setPSWFLinkName(pSWFLink.getPSWFLinkName());
                }
                if (DataTypeHelper.compare((int)25, (Object)(pSWFLink = pSWFLinkCond.getPSWFLink()).getPSWFVersionId(), (Object)pSWFLinkCond.getPSWFVersionId()) != 0L) {
                    pSWFLinkCond.setPSWFVersionId(pSWFLink.getPSWFVersionId());
                    this.onFillEntityFullInfo_PSWFVersion(pSWFLinkCond, bl);
                }
            } else {
                pSWFLinkCond.setPSWFLinkName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSWFVersion(PSWFLinkCond pSWFLinkCond, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSWFLinkCond pSWFLinkCond, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSWFLinkCond, bl);
    }

    public ArrayList<PSWFLinkCond> selectByPSDBValueOP(PSDBValueOPBase pSDBValueOPBase) throws Exception {
        return this.selectByPSDBValueOP(pSDBValueOPBase, "", -1);
    }

    public ArrayList<PSWFLinkCond> selectByPSDBValueOP(PSDBValueOPBase pSDBValueOPBase, String string) throws Exception {
        return this.selectByPSDBValueOP(pSDBValueOPBase, string, -1);
    }

    public ArrayList<PSWFLinkCond> selectByPSDBValueOP(PSDBValueOPBase pSDBValueOPBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDBVALUEOPID", (Object)pSDBValueOPBase.getPSDBValueOPId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDBValueOPCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDBValueOPCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFLinkCond> selectByDstPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByDstPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSWFLinkCond> selectByDstPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByDstPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSWFLinkCond> selectByDstPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DSTPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDstPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDstPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFLinkCond> selectByPPWFLinkCond(PSWFLinkCondBase pSWFLinkCondBase) throws Exception {
        return this.selectByPPWFLinkCond(pSWFLinkCondBase, "", -1);
    }

    public ArrayList<PSWFLinkCond> selectByPPWFLinkCond(PSWFLinkCondBase pSWFLinkCondBase, String string) throws Exception {
        return this.selectByPPWFLinkCond(pSWFLinkCondBase, string, -1);
    }

    public ArrayList<PSWFLinkCond> selectByPPWFLinkCond(PSWFLinkCondBase pSWFLinkCondBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSWFLINKCONDID", (Object)pSWFLinkCondBase.getPSWFLinkCondId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPPWFLinkCondCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPPWFLinkCondCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFLinkCond> selectTempByPPWFLinkCond(PSWFLinkCondBase pSWFLinkCondBase) throws Exception {
        return this.selectTempByPPWFLinkCond(pSWFLinkCondBase, "");
    }

    public ArrayList<PSWFLinkCond> selectTempByPPWFLinkCond(PSWFLinkCondBase pSWFLinkCondBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSWFLINKCONDID", (Object)pSWFLinkCondBase.getPSWFLinkCondId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPPWFLinkCondCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPPWFLinkCondCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFLinkCond> selectByPSWFLink(PSWFLinkBase pSWFLinkBase) throws Exception {
        return this.selectByPSWFLink(pSWFLinkBase, "", -1);
    }

    public ArrayList<PSWFLinkCond> selectByPSWFLink(PSWFLinkBase pSWFLinkBase, String string) throws Exception {
        return this.selectByPSWFLink(pSWFLinkBase, string, -1);
    }

    public ArrayList<PSWFLinkCond> selectByPSWFLink(PSWFLinkBase pSWFLinkBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSWFLINKID", (Object)pSWFLinkBase.getPSWFLinkId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSWFLinkCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSWFLinkCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFLinkCond> selectTempByPSWFLink(PSWFLinkBase pSWFLinkBase) throws Exception {
        return this.selectTempByPSWFLink(pSWFLinkBase, "");
    }

    public ArrayList<PSWFLinkCond> selectTempByPSWFLink(PSWFLinkBase pSWFLinkBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSWFLINKID", (Object)pSWFLinkBase.getPSWFLinkId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSWFLinkCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSWFLinkCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFLinkCond> selectByPSWFVersion(PSWFVersionBase pSWFVersionBase) throws Exception {
        return this.selectByPSWFVersion(pSWFVersionBase, "", -1);
    }

    public ArrayList<PSWFLinkCond> selectByPSWFVersion(PSWFVersionBase pSWFVersionBase, String string) throws Exception {
        return this.selectByPSWFVersion(pSWFVersionBase, string, -1);
    }

    public ArrayList<PSWFLinkCond> selectByPSWFVersion(PSWFVersionBase pSWFVersionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSWFVERSIONID", (Object)pSWFVersionBase.getPSWFVersionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSWFVersionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSWFVersionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFLinkCond> selectTempByPSWFVersion(PSWFVersionBase pSWFVersionBase) throws Exception {
        return this.selectTempByPSWFVersion(pSWFVersionBase, "");
    }

    public ArrayList<PSWFLinkCond> selectTempByPSWFVersion(PSWFVersionBase pSWFVersionBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSWFVERSIONID", (Object)pSWFVersionBase.getPSWFVersionId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSWFVersionCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSWFVersionCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDBValueOP(PSDBValueOP pSDBValueOP) throws Exception {
        ArrayList<PSWFLinkCond> arrayList = this.selectByPSDBValueOP(pSDBValueOP, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDBVALUEOP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDBValueOP);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFLINKCOND_PSDBVALUEOP_PSDBVALUEOPID", "", iDataEntityModel.getName(), "PSWFLINKCOND", iDataEntityModel.getDataInfo((IEntity)pSDBValueOP), arrayList.get(0)));
        }
    }

    public void resetPSDBValueOP(PSDBValueOP pSDBValueOP) throws Exception {
        ArrayList<PSWFLinkCond> arrayList = this.selectByPSDBValueOP(pSDBValueOP);
        for (PSWFLinkCond pSWFLinkCond : arrayList) {
            PSWFLinkCond pSWFLinkCond2 = (PSWFLinkCond)this.getDEModel().createEntity();
            pSWFLinkCond2.setPSWFLinkCondId(pSWFLinkCond.getPSWFLinkCondId());
            pSWFLinkCond2.setPSDBValueOPId(null);
            this.update(pSWFLinkCond2);
        }
    }

    public void removeByPSDBValueOP(PSDBValueOP pSDBValueOP) throws Exception {
        final PSDBValueOP pSDBValueOP2 = pSDBValueOP;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFLinkCondServiceBase.this.onBeforeRemoveByPSDBValueOP(pSDBValueOP2);
                PSWFLinkCondServiceBase.this.internalRemoveByPSDBValueOP(pSDBValueOP2);
                PSWFLinkCondServiceBase.this.onAfterRemoveByPSDBValueOP(pSDBValueOP2);
            }
        });
    }

    protected void onBeforeRemoveByPSDBValueOP(PSDBValueOP pSDBValueOP) throws Exception {
    }

    protected void internalRemoveByPSDBValueOP(PSDBValueOP pSDBValueOP) throws Exception {
        ArrayList<PSWFLinkCond> arrayList = this.selectByPSDBValueOP(pSDBValueOP);
        this.onBeforeRemoveByPSDBValueOP(pSDBValueOP, arrayList);
        for (PSWFLinkCond pSWFLinkCond : arrayList) {
            this.remove((IEntity)pSWFLinkCond);
        }
        this.onAfterRemoveByPSDBValueOP(pSDBValueOP, arrayList);
    }

    protected void onAfterRemoveByPSDBValueOP(PSDBValueOP pSDBValueOP) throws Exception {
    }

    protected void onBeforeRemoveByPSDBValueOP(PSDBValueOP pSDBValueOP, ArrayList<PSWFLinkCond> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDBValueOP(PSDBValueOP pSDBValueOP, ArrayList<PSWFLinkCond> arrayList) throws Exception {
    }

    public void testRemoveByDstPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSWFLinkCond> arrayList = this.selectByDstPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFLINKCOND_PSDEFIELD_DSTPSDEFID", "", iDataEntityModel.getName(), "PSWFLINKCOND", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetDstPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSWFLinkCond> arrayList = this.selectByDstPSDEF(pSDEField);
        for (PSWFLinkCond pSWFLinkCond : arrayList) {
            PSWFLinkCond pSWFLinkCond2 = (PSWFLinkCond)this.getDEModel().createEntity();
            pSWFLinkCond2.setPSWFLinkCondId(pSWFLinkCond.getPSWFLinkCondId());
            pSWFLinkCond2.setDstPSDEFId(null);
            this.update(pSWFLinkCond2);
        }
    }

    public void removeByDstPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFLinkCondServiceBase.this.onBeforeRemoveByDstPSDEF(pSDEField2);
                PSWFLinkCondServiceBase.this.internalRemoveByDstPSDEF(pSDEField2);
                PSWFLinkCondServiceBase.this.onAfterRemoveByDstPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByDstPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByDstPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSWFLinkCond> arrayList = this.selectByDstPSDEF(pSDEField);
        this.onBeforeRemoveByDstPSDEF(pSDEField, arrayList);
        for (PSWFLinkCond pSWFLinkCond : arrayList) {
            this.remove((IEntity)pSWFLinkCond);
        }
        this.onAfterRemoveByDstPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByDstPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByDstPSDEF(PSDEField pSDEField, ArrayList<PSWFLinkCond> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDstPSDEF(PSDEField pSDEField, ArrayList<PSWFLinkCond> arrayList) throws Exception {
    }

    public void testRemoveByPPWFLinkCond(PSWFLinkCond pSWFLinkCond) throws Exception {
    }

    public void resetPPWFLinkCond(PSWFLinkCond pSWFLinkCond) throws Exception {
        ArrayList<PSWFLinkCond> arrayList = this.selectByPPWFLinkCond(pSWFLinkCond);
        for (PSWFLinkCond pSWFLinkCond2 : arrayList) {
            PSWFLinkCond pSWFLinkCond3 = (PSWFLinkCond)this.getDEModel().createEntity();
            pSWFLinkCond3.setPSWFLinkCondId(pSWFLinkCond2.getPSWFLinkCondId());
            pSWFLinkCond3.setPPSWFLinkCondId(null);
            this.update(pSWFLinkCond3);
        }
    }

    public void resetTempPPWFLinkCond(PSWFLinkCond pSWFLinkCond) throws Exception {
        ArrayList<PSWFLinkCond> arrayList = this.selectTempByPPWFLinkCond(pSWFLinkCond);
        for (PSWFLinkCond pSWFLinkCond2 : arrayList) {
            PSWFLinkCond pSWFLinkCond3 = (PSWFLinkCond)this.getDEModel().createEntity();
            pSWFLinkCond3.setPSWFLinkCondId(pSWFLinkCond2.getPSWFLinkCondId());
            pSWFLinkCond3.setPPSWFLinkCondId(null);
            this.updateTemp((IEntity)pSWFLinkCond3);
        }
    }

    public void removeByPPWFLinkCond(PSWFLinkCond pSWFLinkCond) throws Exception {
        final PSWFLinkCond pSWFLinkCond2 = pSWFLinkCond;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFLinkCondServiceBase.this.onBeforeRemoveByPPWFLinkCond(pSWFLinkCond2);
                PSWFLinkCondServiceBase.this.internalRemoveByPPWFLinkCond(pSWFLinkCond2);
                PSWFLinkCondServiceBase.this.onAfterRemoveByPPWFLinkCond(pSWFLinkCond2);
            }
        });
    }

    protected void onBeforeRemoveByPPWFLinkCond(PSWFLinkCond pSWFLinkCond) throws Exception {
    }

    protected void internalRemoveByPPWFLinkCond(PSWFLinkCond pSWFLinkCond) throws Exception {
        ArrayList<PSWFLinkCond> arrayList = this.selectByPPWFLinkCond(pSWFLinkCond);
        this.onBeforeRemoveByPPWFLinkCond(pSWFLinkCond, arrayList);
        for (PSWFLinkCond pSWFLinkCond2 : arrayList) {
            this.remove((IEntity)pSWFLinkCond2);
        }
        this.onAfterRemoveByPPWFLinkCond(pSWFLinkCond, arrayList);
    }

    protected void onAfterRemoveByPPWFLinkCond(PSWFLinkCond pSWFLinkCond) throws Exception {
    }

    protected void onBeforeRemoveByPPWFLinkCond(PSWFLinkCond pSWFLinkCond, ArrayList<PSWFLinkCond> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPPWFLinkCond(PSWFLinkCond pSWFLinkCond, ArrayList<PSWFLinkCond> arrayList) throws Exception {
    }

    public void testRemoveByPSWFLink(PSWFLink pSWFLink) throws Exception {
    }

    public void resetPSWFLink(PSWFLink pSWFLink) throws Exception {
        ArrayList<PSWFLinkCond> arrayList = this.selectByPSWFLink(pSWFLink);
        for (PSWFLinkCond pSWFLinkCond : arrayList) {
            PSWFLinkCond pSWFLinkCond2 = (PSWFLinkCond)this.getDEModel().createEntity();
            pSWFLinkCond2.setPSWFLinkCondId(pSWFLinkCond.getPSWFLinkCondId());
            pSWFLinkCond2.setPSWFLinkId(null);
            this.update(pSWFLinkCond2);
        }
    }

    public void resetTempPSWFLink(PSWFLink pSWFLink) throws Exception {
        ArrayList<PSWFLinkCond> arrayList = this.selectTempByPSWFLink(pSWFLink);
        for (PSWFLinkCond pSWFLinkCond : arrayList) {
            PSWFLinkCond pSWFLinkCond2 = (PSWFLinkCond)this.getDEModel().createEntity();
            pSWFLinkCond2.setPSWFLinkCondId(pSWFLinkCond.getPSWFLinkCondId());
            pSWFLinkCond2.setPSWFLinkId(null);
            this.updateTemp((IEntity)pSWFLinkCond2);
        }
    }

    public void removeByPSWFLink(PSWFLink pSWFLink) throws Exception {
        final PSWFLink pSWFLink2 = pSWFLink;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFLinkCondServiceBase.this.onBeforeRemoveByPSWFLink(pSWFLink2);
                PSWFLinkCondServiceBase.this.internalRemoveByPSWFLink(pSWFLink2);
                PSWFLinkCondServiceBase.this.onAfterRemoveByPSWFLink(pSWFLink2);
            }
        });
    }

    protected void onBeforeRemoveByPSWFLink(PSWFLink pSWFLink) throws Exception {
    }

    protected void internalRemoveByPSWFLink(PSWFLink pSWFLink) throws Exception {
        ArrayList<PSWFLinkCond> arrayList = this.selectByPSWFLink(pSWFLink);
        this.onBeforeRemoveByPSWFLink(pSWFLink, arrayList);
        for (PSWFLinkCond pSWFLinkCond : arrayList) {
            this.remove((IEntity)pSWFLinkCond);
        }
        this.onAfterRemoveByPSWFLink(pSWFLink, arrayList);
    }

    protected void onAfterRemoveByPSWFLink(PSWFLink pSWFLink) throws Exception {
    }

    protected void onBeforeRemoveByPSWFLink(PSWFLink pSWFLink, ArrayList<PSWFLinkCond> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSWFLink(PSWFLink pSWFLink, ArrayList<PSWFLinkCond> arrayList) throws Exception {
    }

    public void testRemoveByPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
    }

    public void resetPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
        ArrayList<PSWFLinkCond> arrayList = this.selectByPSWFVersion(pSWFVersion);
        for (PSWFLinkCond pSWFLinkCond : arrayList) {
            PSWFLinkCond pSWFLinkCond2 = (PSWFLinkCond)this.getDEModel().createEntity();
            pSWFLinkCond2.setPSWFLinkCondId(pSWFLinkCond.getPSWFLinkCondId());
            pSWFLinkCond2.setPSWFVersionId(null);
            this.update(pSWFLinkCond2);
        }
    }

    public void resetTempPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
        ArrayList<PSWFLinkCond> arrayList = this.selectTempByPSWFVersion(pSWFVersion);
        for (PSWFLinkCond pSWFLinkCond : arrayList) {
            PSWFLinkCond pSWFLinkCond2 = (PSWFLinkCond)this.getDEModel().createEntity();
            pSWFLinkCond2.setPSWFLinkCondId(pSWFLinkCond.getPSWFLinkCondId());
            pSWFLinkCond2.setPSWFVersionId(null);
            this.updateTemp((IEntity)pSWFLinkCond2);
        }
    }

    public void removeByPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
        final PSWFVersion pSWFVersion2 = pSWFVersion;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFLinkCondServiceBase.this.onBeforeRemoveByPSWFVersion(pSWFVersion2);
                PSWFLinkCondServiceBase.this.internalRemoveByPSWFVersion(pSWFVersion2);
                PSWFLinkCondServiceBase.this.onAfterRemoveByPSWFVersion(pSWFVersion2);
            }
        });
    }

    protected void onBeforeRemoveByPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
    }

    protected void internalRemoveByPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
        ArrayList<PSWFLinkCond> arrayList = this.selectByPSWFVersion(pSWFVersion);
        this.onBeforeRemoveByPSWFVersion(pSWFVersion, arrayList);
        for (PSWFLinkCond pSWFLinkCond : arrayList) {
            this.remove((IEntity)pSWFLinkCond);
        }
        this.onAfterRemoveByPSWFVersion(pSWFVersion, arrayList);
    }

    protected void onAfterRemoveByPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
    }

    protected void onBeforeRemoveByPSWFVersion(PSWFVersion pSWFVersion, ArrayList<PSWFLinkCond> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSWFVersion(PSWFVersion pSWFVersion, ArrayList<PSWFLinkCond> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSWFLinkCond pSWFLinkCond) throws Exception {
        PSWFLinkCondService pSWFLinkCondService = (PSWFLinkCondService)ServiceGlobal.getService(PSWFLinkCondService.class, (SessionFactory)this.getSessionFactory());
        pSWFLinkCondService.testRemoveByPPWFLinkCond(pSWFLinkCond);
        pSWFLinkCondService.resetPPWFLinkCond(pSWFLinkCond);
        super.onBeforeRemove(pSWFLinkCond);
    }

    protected void onBeforeRemoveTemp(PSWFLinkCond pSWFLinkCond) throws Exception {
        PSWFLinkCondService pSWFLinkCondService = (PSWFLinkCondService)ServiceGlobal.getService(PSWFLinkCondService.class, (SessionFactory)this.getSessionFactory());
        pSWFLinkCondService.resetTempPPWFLinkCond(pSWFLinkCond);
        super.onBeforeRemoveTemp((IEntity)pSWFLinkCond);
    }

    public void removeTempByPPWFLinkCond(PSWFLinkCond pSWFLinkCond) throws Exception {
        final PSWFLinkCond pSWFLinkCond2 = pSWFLinkCond;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFLinkCondServiceBase.this.onBeforeRemoveTempByPPWFLinkCond(pSWFLinkCond2);
                PSWFLinkCondServiceBase.this.internalRemoveTempByPPWFLinkCond(pSWFLinkCond2);
                PSWFLinkCondServiceBase.this.onAfterRemoveTempByPPWFLinkCond(pSWFLinkCond2);
            }
        });
    }

    protected void onBeforeRemoveTempByPPWFLinkCond(PSWFLinkCond pSWFLinkCond) throws Exception {
    }

    protected void internalRemoveTempByPPWFLinkCond(PSWFLinkCond pSWFLinkCond) throws Exception {
        ArrayList<PSWFLinkCond> arrayList = this.selectTempByPPWFLinkCond(pSWFLinkCond);
        this.onBeforeRemoveTempByPPWFLinkCond(pSWFLinkCond, arrayList);
        for (PSWFLinkCond pSWFLinkCond2 : arrayList) {
            this.removeTemp((IEntity)pSWFLinkCond2);
        }
        this.onAfterRemoveTempByPPWFLinkCond(pSWFLinkCond, arrayList);
    }

    protected void onAfterRemoveTempByPPWFLinkCond(PSWFLinkCond pSWFLinkCond) throws Exception {
    }

    protected void onBeforeRemoveTempByPPWFLinkCond(PSWFLinkCond pSWFLinkCond, ArrayList<PSWFLinkCond> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPPWFLinkCond(PSWFLinkCond pSWFLinkCond, ArrayList<PSWFLinkCond> arrayList) throws Exception {
    }

    public void removeTempByPSWFLink(PSWFLink pSWFLink) throws Exception {
        final PSWFLink pSWFLink2 = pSWFLink;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFLinkCondServiceBase.this.onBeforeRemoveTempByPSWFLink(pSWFLink2);
                PSWFLinkCondServiceBase.this.internalRemoveTempByPSWFLink(pSWFLink2);
                PSWFLinkCondServiceBase.this.onAfterRemoveTempByPSWFLink(pSWFLink2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSWFLink(PSWFLink pSWFLink) throws Exception {
    }

    protected void internalRemoveTempByPSWFLink(PSWFLink pSWFLink) throws Exception {
        ArrayList<PSWFLinkCond> arrayList = this.selectTempByPSWFLink(pSWFLink);
        this.onBeforeRemoveTempByPSWFLink(pSWFLink, arrayList);
        for (PSWFLinkCond pSWFLinkCond : arrayList) {
            this.removeTemp((IEntity)pSWFLinkCond);
        }
        this.onAfterRemoveTempByPSWFLink(pSWFLink, arrayList);
    }

    protected void onAfterRemoveTempByPSWFLink(PSWFLink pSWFLink) throws Exception {
    }

    protected void onBeforeRemoveTempByPSWFLink(PSWFLink pSWFLink, ArrayList<PSWFLinkCond> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSWFLink(PSWFLink pSWFLink, ArrayList<PSWFLinkCond> arrayList) throws Exception {
    }

    public void removeTempByPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
        final PSWFVersion pSWFVersion2 = pSWFVersion;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFLinkCondServiceBase.this.onBeforeRemoveTempByPSWFVersion(pSWFVersion2);
                PSWFLinkCondServiceBase.this.internalRemoveTempByPSWFVersion(pSWFVersion2);
                PSWFLinkCondServiceBase.this.onAfterRemoveTempByPSWFVersion(pSWFVersion2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
    }

    protected void internalRemoveTempByPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
        ArrayList<PSWFLinkCond> arrayList = this.selectTempByPSWFVersion(pSWFVersion);
        this.onBeforeRemoveTempByPSWFVersion(pSWFVersion, arrayList);
        for (PSWFLinkCond pSWFLinkCond : arrayList) {
            this.removeTemp((IEntity)pSWFLinkCond);
        }
        this.onAfterRemoveTempByPSWFVersion(pSWFVersion, arrayList);
    }

    protected void onAfterRemoveTempByPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
    }

    protected void onBeforeRemoveTempByPSWFVersion(PSWFVersion pSWFVersion, ArrayList<PSWFLinkCond> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSWFVersion(PSWFVersion pSWFVersion, ArrayList<PSWFLinkCond> arrayList) throws Exception {
    }

    protected void getRelatedDataTempMajor(PSWFLinkCond pSWFLinkCond) throws Exception {
        super.getRelatedDataTempMajor((IEntity)pSWFLinkCond);
    }

    protected void updateRelatedDataTempMajor(PSWFLinkCond pSWFLinkCond, PSWFLinkCond pSWFLinkCond2) throws Exception {
        super.updateRelatedDataTempMajor((IEntity)pSWFLinkCond, (IEntity)pSWFLinkCond2);
    }

    protected void replaceParentInfo(PSWFLinkCond pSWFLinkCond, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSWFLinkCond, cloneSession);
        if (pSWFLinkCond.getPSDBValueOPId() != null && (iEntity = cloneSession.getEntity("PSDBVALUEOP", (Object)pSWFLinkCond.getPSDBValueOPId())) != null) {
            this.onFillParentInfo_PSDBValueOP(pSWFLinkCond, (PSDBValueOP)iEntity);
        }
        if (pSWFLinkCond.getDstPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSWFLinkCond.getDstPSDEFId())) != null) {
            this.onFillParentInfo_DstPSDEF(pSWFLinkCond, (PSDEField)iEntity);
        }
        if (pSWFLinkCond.getPPSWFLinkCondId() != null && (iEntity = cloneSession.getEntity("PSWFLINKCOND", (Object)pSWFLinkCond.getPPSWFLinkCondId())) != null) {
            this.onFillParentInfo_PPWFLinkCond(pSWFLinkCond, (PSWFLinkCond)iEntity);
        }
        if (pSWFLinkCond.getPSWFLinkId() != null && (iEntity = cloneSession.getEntity("PSWFLINK", (Object)pSWFLinkCond.getPSWFLinkId())) != null) {
            this.onFillParentInfo_PSWFLink(pSWFLinkCond, (PSWFLink)iEntity);
        }
        if (pSWFLinkCond.getPSWFVersionId() != null && (iEntity = cloneSession.getEntity("PSWFVERSION", (Object)pSWFLinkCond.getPSWFVersionId())) != null) {
            this.onFillParentInfo_PSWFVersion(pSWFLinkCond, (PSWFVersion)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSWFLinkCond pSWFLinkCond, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSWFLinkCond, bl);
    }

    protected void onCheckEntity(boolean bl, PSWFLinkCond pSWFLinkCond, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CondValue(bl, pSWFLinkCond, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomDSTParam(bl, pSWFLinkCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstPSDEFId(bl, pSWFLinkCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstPSDEFName(bl, pSWFLinkCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaModelFlag(bl, pSWFLinkCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupNotFlag(bl, pSWFLinkCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupOP(bl, pSWFLinkCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicType(bl, pSWFLinkCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSWFLinkCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSWFLinkCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ParamType(bl, pSWFLinkCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSWFLinkCondId(bl, pSWFLinkCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSWFLinkCondName(bl, pSWFLinkCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDBValueOPId(bl, pSWFLinkCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDBValueOPName(bl, pSWFLinkCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, pSWFLinkCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWFLinkCondId(bl, pSWFLinkCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWFLinkCondName(bl, pSWFLinkCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWFLinkId(bl, pSWFLinkCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWFLinkName(bl, pSWFLinkCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWFVersionId(bl, pSWFLinkCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSWFLinkCond, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CondValue(boolean bl, PSWFLinkCond pSWFLinkCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLinkCond.isCondValueDirty() : !pSWFLinkCond.isCondValueDirty()) {
            return null;
        }
        String string = pSWFLinkCond.getCondValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CondValue_Default((IEntity)pSWFLinkCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONDVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CustomDSTParam(boolean bl, PSWFLinkCond pSWFLinkCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLinkCond.isCustomDSTParamDirty() : !pSWFLinkCond.isCustomDSTParamDirty()) {
            return null;
        }
        String string = pSWFLinkCond.getCustomDSTParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomDSTParam_Default((IEntity)pSWFLinkCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CUSTOMDSTPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DstPSDEFId(boolean bl, PSWFLinkCond pSWFLinkCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLinkCond.isDstPSDEFIdDirty() : !pSWFLinkCond.isDstPSDEFIdDirty()) {
            return null;
        }
        String string = pSWFLinkCond.getDstPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstPSDEFId_Default((IEntity)pSWFLinkCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DstPSDEFName(boolean bl, PSWFLinkCond pSWFLinkCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLinkCond.isDstPSDEFNameDirty() : !pSWFLinkCond.isDstPSDEFNameDirty()) {
            return null;
        }
        String string = pSWFLinkCond.getDstPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstPSDEFName_Default((IEntity)pSWFLinkCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaModelFlag(boolean bl, PSWFLinkCond pSWFLinkCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLinkCond.isDynaModelFlagDirty() : !pSWFLinkCond.isDynaModelFlagDirty()) {
            return null;
        }
        Integer n = pSWFLinkCond.getDynaModelFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DynaModelFlag_Default((IEntity)pSWFLinkCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DYNAMODELFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupNotFlag(boolean bl, PSWFLinkCond pSWFLinkCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLinkCond.isGroupNotFlagDirty() : !pSWFLinkCond.isGroupNotFlagDirty()) {
            return null;
        }
        Integer n = pSWFLinkCond.getGroupNotFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_GroupNotFlag_Default((IEntity)pSWFLinkCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPNOTFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupOP(boolean bl, PSWFLinkCond pSWFLinkCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLinkCond.isGroupOPDirty() : !pSWFLinkCond.isGroupOPDirty()) {
            return null;
        }
        String string = pSWFLinkCond.getGroupOP();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupOP_Default((IEntity)pSWFLinkCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPOP");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LogicType(boolean bl, PSWFLinkCond pSWFLinkCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLinkCond.isLogicTypeDirty() && !bl2 : !pSWFLinkCond.isLogicTypeDirty()) {
            return null;
        }
        String string = pSWFLinkCond.getLogicType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGICTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicType_Default((IEntity)pSWFLinkCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGICTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSWFLinkCond pSWFLinkCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLinkCond.isMemoDirty() : !pSWFLinkCond.isMemoDirty()) {
            return null;
        }
        String string = pSWFLinkCond.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSWFLinkCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MEMO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSWFLinkCond pSWFLinkCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLinkCond.isOrderValueDirty() : !pSWFLinkCond.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSWFLinkCond.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSWFLinkCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORDERVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ParamType(boolean bl, PSWFLinkCond pSWFLinkCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLinkCond.isParamTypeDirty() : !pSWFLinkCond.isParamTypeDirty()) {
            return null;
        }
        String string = pSWFLinkCond.getParamType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ParamType_Default((IEntity)pSWFLinkCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAMTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PPSWFLinkCondId(boolean bl, PSWFLinkCond pSWFLinkCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLinkCond.isPPSWFLinkCondIdDirty() : !pSWFLinkCond.isPPSWFLinkCondIdDirty()) {
            return null;
        }
        String string = pSWFLinkCond.getPPSWFLinkCondId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSWFLinkCondId_Default((IEntity)pSWFLinkCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSWFLINKCONDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PPSWFLinkCondName(boolean bl, PSWFLinkCond pSWFLinkCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLinkCond.isPPSWFLinkCondNameDirty() : !pSWFLinkCond.isPPSWFLinkCondNameDirty()) {
            return null;
        }
        String string = pSWFLinkCond.getPPSWFLinkCondName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSWFLinkCondName_Default((IEntity)pSWFLinkCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSWFLINKCONDNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDBValueOPId(boolean bl, PSWFLinkCond pSWFLinkCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLinkCond.isPSDBValueOPIdDirty() : !pSWFLinkCond.isPSDBValueOPIdDirty()) {
            return null;
        }
        String string = pSWFLinkCond.getPSDBValueOPId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDBValueOPId_Default((IEntity)pSWFLinkCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDBVALUEOPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDBValueOPName(boolean bl, PSWFLinkCond pSWFLinkCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLinkCond.isPSDBValueOPNameDirty() : !pSWFLinkCond.isPSDBValueOPNameDirty()) {
            return null;
        }
        String string = pSWFLinkCond.getPSDBValueOPName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDBValueOPName_Default((IEntity)pSWFLinkCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDBVALUEOPNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, PSWFLinkCond pSWFLinkCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLinkCond.isPSDynaInstIdDirty() : !pSWFLinkCond.isPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSWFLinkCond.getPSDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default((IEntity)pSWFLinkCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWFLinkCondId(boolean bl, PSWFLinkCond pSWFLinkCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLinkCond.isPSWFLinkCondIdDirty() && !bl2 : !pSWFLinkCond.isPSWFLinkCondIdDirty()) {
            return null;
        }
        String string = pSWFLinkCond.getPSWFLinkCondId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFLINKCONDID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWFLinkCondId_Default((IEntity)pSWFLinkCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFLINKCONDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWFLinkCondName(boolean bl, PSWFLinkCond pSWFLinkCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLinkCond.isPSWFLinkCondNameDirty() && !bl2 : !pSWFLinkCond.isPSWFLinkCondNameDirty()) {
            return null;
        }
        String string = pSWFLinkCond.getPSWFLinkCondName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFLINKCONDNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWFLinkCondName_Default((IEntity)pSWFLinkCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFLINKCONDNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWFLinkId(boolean bl, PSWFLinkCond pSWFLinkCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLinkCond.isPSWFLinkIdDirty() && !bl2 : !pSWFLinkCond.isPSWFLinkIdDirty()) {
            return null;
        }
        String string = pSWFLinkCond.getPSWFLinkId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFLINKID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWFLinkId_Default((IEntity)pSWFLinkCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFLINKID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWFLinkName(boolean bl, PSWFLinkCond pSWFLinkCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLinkCond.isPSWFLinkNameDirty() : !pSWFLinkCond.isPSWFLinkNameDirty()) {
            return null;
        }
        String string = pSWFLinkCond.getPSWFLinkName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWFLinkName_Default((IEntity)pSWFLinkCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFLINKNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWFVersionId(boolean bl, PSWFLinkCond pSWFLinkCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLinkCond.isPSWFVersionIdDirty() : !pSWFLinkCond.isPSWFVersionIdDirty()) {
            return null;
        }
        String string = pSWFLinkCond.getPSWFVersionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWFVersionId_Default((IEntity)pSWFLinkCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFVERSIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSWFLinkCond pSWFLinkCond, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSWFLinkCond, bl);
    }

    protected void onSyncIndexEntities(PSWFLinkCond pSWFLinkCond, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSWFLinkCond, bl);
    }

    public Object getDataContextValue(PSWFLinkCond pSWFLinkCond, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSWFLinkCond, string, iDataContextParam)) != null) {
            return object;
        }
        PSWFLink pSWFLink = pSWFLinkCond.getPSWFLink();
        if (pSWFLink != null && pSWFLink.contains(string)) {
            return pSWFLink.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSWFLinkCond pSWFLinkCond, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSWFLinkCond, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CONDVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CondValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CUSTOMDSTPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomDSTParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAMODELFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaModelFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPNOTFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupNotFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPOP", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupOP_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAMTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ParamType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSWFLINKCONDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSWFLinkCondId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSWFLINKCONDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSWFLinkCondName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDBVALUEOPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDBValueOPId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDBVALUEOPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDBValueOPName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFLINKCONDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFLinkCondId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFLINKCONDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFLinkCondName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFLINKID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFLinkId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFLINKNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFLinkName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFVERSIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFVersionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFVERSIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFVersionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_CondValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONDVALUE", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CreateDate_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CreateMan_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CREATEMAN", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CustomDSTParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CUSTOMDSTPARAM", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DynaModelFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_GroupNotFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_GroupOP_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPOP", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LogicType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOGICTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Memo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ParamType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PARAMTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSWFLinkCondId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSWFLINKCONDID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSWFLinkCondName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSWFLINKCONDNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDBValueOPId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDBVALUEOPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDBValueOPName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDBVALUEOPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNAINSTID", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWFLinkCondId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFLINKCONDID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWFLinkCondName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFLINKCONDNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWFLinkId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFLINKID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWFLinkName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFLINKNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWFVersionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFVERSIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWFVersionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFVERSIONNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UpdateDate_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_UpdateMan_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UPDATEMAN", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected boolean onMergeChild(String string, String string2, PSWFLinkCond pSWFLinkCond) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSWFLinkCond)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSWFLinkCond pSWFLinkCond) throws Exception {
        super.onUpdateParent((IEntity)pSWFLinkCond);
    }

    protected void onCopyDetails(PSWFLinkCond pSWFLinkCond, Object object) throws Exception {
        PSWFLinkCond pSWFLinkCond2 = new PSWFLinkCond();
        pSWFLinkCond2.set("PSWFLINKCONDID", object);
        String string = DataObject.getStringValue((Object)pSWFLinkCond.get("PSWFLINKCONDID"));
        super.onCopyDetails((IEntity)pSWFLinkCond, object);
    }

    @Override
    protected void exportCurXmlModel(PSWFLinkCond pSWFLinkCond, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSWFLINKCOND");
        if (!bl) {
            pSWFLinkCond.setPSWFVersionName(null);
            pSWFLinkCond.setPPSWFLinkCondId(null);
            pSWFLinkCond.setPSWFLinkId(null);
            pSWFLinkCond.setPSWFLinkName(null);
            pSWFLinkCond.setPSWFVersionId(null);
            pSWFLinkCond.setPSWFVersionName(null);
            super.exportCurXmlModel(pSWFLinkCond, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSWFLinkCond pSWFLinkCond, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSWFLinkCond(pSWFLinkCond, xmlNode);
        super.onExportRelatedXmlModel(pSWFLinkCond, xmlNode);
    }

    protected void exportRelatedXmlModel_PSWFLinkCond(PSWFLinkCond pSWFLinkCond, XmlNode xmlNode) throws Exception {
        PSWFLinkCondService pSWFLinkCondService = (PSWFLinkCondService)ServiceGlobal.getService(PSWFLinkCondService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSWFLinkCond> arrayList = null;
        String string = pSWFLinkCond.getPSWFLinkCondId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSWFLinkCondService.selectByPPWFLinkCond(pSWFLinkCond, "ORDER BY ORDERVALUE ASC") : pSWFLinkCondService.selectTempByPPWFLinkCond(pSWFLinkCond, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSWFLINKCONDS");
            xmlNode.addNode(xmlNode2);
            for (PSWFLinkCond pSWFLinkCond2 : arrayList) {
                pSWFLinkCond2.set("ORDERVALUE", null);
                pSWFLinkCondService.exportXmlModel(pSWFLinkCond2, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSWFLinkCond pSWFLinkCond, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSWFLINKCONDS");
        this.importRelatedXmlModel_PSWFLinkCond(pSWFLinkCond, xmlNode2);
        super.onImportRelatedXmlModel(pSWFLinkCond, xmlNode);
    }

    protected void importRelatedXmlModel_PSWFLinkCond(PSWFLinkCond pSWFLinkCond, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSWFLinkCondService pSWFLinkCondService = (PSWFLinkCondService)ServiceGlobal.getService(PSWFLinkCondService.class, (SessionFactory)this.getSessionFactory());
        String string = pSWFLinkCond.getPSWFLinkCondId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSWFLinkCondService.removeByPPWFLinkCond(pSWFLinkCond);
        } else {
            pSWFLinkCondService.removeTempByPPWFLinkCond(pSWFLinkCond);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSWFLinkCond pSWFLinkCond2 = new PSWFLinkCond();
                pSWFLinkCond2.setOrderValue(n);
                n += 100;
                pSWFLinkCondService.fillParentInfo((IEntity)pSWFLinkCond2, "DER1N", "DER1N_PSWFLINKCOND_PSWFLINKCOND_PPSWFLINKCONDID", pSWFLinkCond.getPSWFLinkCondId());
                pSWFLinkCondService.importXmlModel(pSWFLinkCond2, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSWFLinkCond pSWFLinkCond, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSWFLinkCond, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PPSWFLINKCONDID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSWFLINKCOND#%1$s", (Object)string);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSWFLINKID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSWFLINK#%1$s", (Object)string);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSWFVERSIONID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSWFVERSION#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PPSWFLINKCONDID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSWFLINKCOND_PSWFLINKCOND_PPSWFLINKCONDID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSWFLINKID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSWFLINKCOND_PSWFLINK_PSWFLINKID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSWFVERSIONID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSWFLINKCOND_PSWFVERSION_PSWFVERSIONID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PPSWFLINKCONDID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PPSWFLINKCONDNAME", null);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSWFLINKID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSWFLINKNAME", null);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSWFVERSIONID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSWFVERSIONNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSWFLINKCOND", (boolean)true) == 0) {
            iEntity.set("PPSWFLINKCONDID", (Object)string2);
            return true;
        }
        if (StringHelper.compare((String)string, (String)"PSWFLINK", (boolean)true) == 0) {
            iEntity.set("PSWFLINKID", (Object)string2);
            return true;
        }
        if (StringHelper.compare((String)string, (String)"PSWFVERSION", (boolean)true) == 0) {
            iEntity.set("PSWFVERSIONID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PPSWFLINKCONDID", "PSWFLINKID", "PSWFVERSIONID"};
    }

    @Override
    public String getModelV2Tag(PSWFLinkCond pSWFLinkCond) {
        return super.getModelV2Tag(pSWFLinkCond);
    }

    @Override
    public boolean setModelV2Tag(PSWFLinkCond pSWFLinkCond, String string) {
        return super.setModelV2Tag(pSWFLinkCond, string);
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PPSWFLINKCONDID", "");
        map.put("PSWFLINKID", "");
        map.put("PSWFVERSIONID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSWFLinkCond pSWFLinkCond, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSWFLinkCond.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSWFLinkCond, true);
        return super.getModelV2Entity(pSWFLinkCond, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSWFLinkCond pSWFLinkCond, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        boolean bl = false;
        if (!StringHelper.isNullOrEmpty((String)pSWFLinkCond.getPPSWFLinkCondId())) {
            bl = true;
        }
        if (!StringHelper.isNullOrEmpty((String)pSWFLinkCond.getPSWFLinkId())) {
            bl = true;
        } else if (bl && !objectNode.has("pswflinkid")) {
            objectNode.put("pswflinkid", "<PSWFLINK>");
        }
        if (!StringHelper.isNullOrEmpty((String)pSWFLinkCond.getPSWFVersionId())) {
            bl = true;
        } else if (bl && !objectNode.has("pswfversionid")) {
            objectNode.put("pswfversionid", "<PSWFVERSION>");
        }
        return super.testCompileCurModelV2(pSWFLinkCond, objectNode, string, string2, n);
    }

    @Override
    protected ObjectNode onFillModelV2(ObjectNode objectNode, PSWFLinkCond pSWFLinkCond, String string, Map<String, String> map) throws Exception {
        if (PSWFLinkCondServiceBase.isSimpleImportExportMode()) {
            map.put("PPSWFLINKCONDID", "");
            map.put("PSWFLINKID", "");
            map.put("PSWFVERSIONID", "");
        }
        return super.onFillModelV2(objectNode, pSWFLinkCond, string, map);
    }

    protected boolean isExportRelatedModelV2(String string) {
        return StringHelper.compare((String)"DER1N_PSWFLINKCOND_PSWFLINKCOND_PPSWFLINKCONDID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSWFLinkCond pSWFLinkCond, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSWFLinkCond, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSWFLinkCond pSWFLinkCond, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSWFLINKCOND_PSWFLINKCOND_PPSWFLINKCONDID")) {
            Object object;
            PSWFLinkCond pSWFLinkCond22;
            Object object2;
            Object object3;
            Object object4;
            PSWFLinkCondService pSWFLinkCondService = (PSWFLinkCondService)ServiceGlobal.getService(PSWFLinkCondService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<PSWFLinkCond> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSWFLINKCOND#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSWFLINKCOND", (Object)pSWFLinkCond.getPSWFLinkCondId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        pSWFLinkCond22 = (ObjectNode)JsonNodeHelper.fromString((String)object2);
                        arrayList.add(pSWFLinkCond22);
                    }
                }
            } else {
                arrayList = new ArrayList<PSWFLinkCond>();
                object4 = pSWFLinkCondService.selectByPPWFLinkCond(pSWFLinkCond);
                object3 = StringHelper.format((String)"PSWFLINKCOND#%1$s", (Object)pSWFLinkCond.getPSWFLinkCondId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    pSWFLinkCond22 = object2.next();
                    object = pSWFLinkCondService.getModelV2ResScope((IEntity)pSWFLinkCond22);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSWFLinkCond)PSModelV2Helper.toJSONObject((IEntity)pSWFLinkCond22, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSWFLinkCondService.getModelV2Name(false);
                object3 = objectNode.putArray(((String)object4).toLowerCase());
                Collections.sort(arrayList, new Comparator<ObjectNode>(){

                    @Override
                    public int compare(ObjectNode objectNode, ObjectNode objectNode2) {
                        int n;
                        int n2 = 1000;
                        int n3 = 1000;
                        if (objectNode.has("ordervalue")) {
                            n2 = objectNode.get("ordervalue").asInt();
                        }
                        if (objectNode2.has("ordervalue")) {
                            n3 = objectNode2.get("ordervalue").asInt();
                        }
                        if ((n = n2 - n3) != 0) {
                            return n;
                        }
                        String string = null;
                        String string2 = null;
                        if (objectNode.has("pswflinkcondname")) {
                            string = objectNode.get("pswflinkcondname").asText();
                        }
                        if (objectNode2.has("pswflinkcondname")) {
                            string2 = objectNode2.get("pswflinkcondname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (PSWFLinkCond pSWFLinkCond22 : arrayList) {
                    object = new PSWFLinkCond();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)pSWFLinkCond22, false);
                    ((PSWFLinkCondBase)object).remove("ordervalue");
                    object3.add((JsonNode)pSWFLinkCondService.exportModelV2(object, string));
                }
            }
        }
        super.onExportCurModelV2(pSWFLinkCond, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSWFLinkCond pSWFLinkCond) throws Exception {
        PSWFLinkCondService pSWFLinkCondService = (PSWFLinkCondService)ServiceGlobal.getService(PSWFLinkCondService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSWFLinkCond> arrayList = pSWFLinkCondService.selectByPPWFLinkCond(pSWFLinkCond);
        String string = StringHelper.format((String)"PSWFLINKCOND#%1$s", (Object)pSWFLinkCond.getPSWFLinkCondId());
        for (PSWFLinkCond pSWFLinkCond2 : arrayList) {
            String string2 = pSWFLinkCondService.getModelV2ResScope((IEntity)pSWFLinkCond2);
            if (StringHelper.compare((String)string, (String)string2, (boolean)false) != 0) continue;
            pSWFLinkCondService.emptyModelV2(pSWFLinkCond2);
        }
        SqlParamList sqlParamList = new SqlParamList();
        sqlParamList.addString(pSWFLinkCond.getPSWFLinkCondId());
        pSWFLinkCondService.getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        pSWFLinkCondService.getDAO().executeRawSql(null, "DELETE FROM T_SRFPSWFLINKCOND WHERE PPSWFLINKCONDID = ?", sqlParamList);
        super.onEmptyModelV2(pSWFLinkCond);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSWFLinkCondService pSWFLinkCondService = (PSWFLinkCondService)ServiceGlobal.getService(PSWFLinkCondService.class, (SessionFactory)this.getSessionFactory());
        if (pSWFLinkCondService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSWFLinkCond pSWFLinkCond, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSWFLinkCond pSWFLinkCond2 = new PSWFLinkCond();
        pSWFLinkCond2.set("PPSWFLINKCONDID", pSWFLinkCond.getPSWFLinkCondId());
        PSWFLinkCondService pSWFLinkCondService = (PSWFLinkCondService)ServiceGlobal.getService(PSWFLinkCondService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSWFLinkCondService.getModelV2Entity(pSWFLinkCond2, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSWFLinkCond, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSWFLinkCond pSWFLinkCond, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        PSWFLinkCondService pSWFLinkCondService = (PSWFLinkCondService)ServiceGlobal.getService(PSWFLinkCondService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSWFLinkCondService.getModelV2Name(null, false);
        int n2 = 0;
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                PSWFLinkCond pSWFLinkCond2 = new PSWFLinkCond();
                pSWFLinkCond2.setPPSWFLinkCondId(pSWFLinkCond.getPSWFLinkCondId());
                pSWFLinkCond2.setPPSWFLinkCondName(pSWFLinkCond.getPSWFLinkCondName());
                pSWFLinkCond2.setOrderValue(n2 += 10);
                pSWFLinkCondService.compileModelV2(pSWFLinkCond2, objectNode2, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File file = new File(string4);
            if (file.exists()) {
                File[] fileArray;
                for (File file2 : fileArray = file.listFiles()) {
                    if (!file2.isDirectory()) continue;
                    PSWFLinkCond pSWFLinkCond3 = new PSWFLinkCond();
                    pSWFLinkCond3.setPPSWFLinkCondId(pSWFLinkCond.getPSWFLinkCondId());
                    pSWFLinkCond3.setPPSWFLinkCondName(pSWFLinkCond.getPSWFLinkCondName());
                    pSWFLinkCondService.compileModelV2(pSWFLinkCond3, null, string, file2.getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSWFLinkCond, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSWFLinkCond pSWFLinkCond, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSWFLINKCOND_PSWFLINKCOND_PPSWFLINKCONDID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSWFLinkConds(pSWFLinkCond, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSWFLinkCond, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSWFLinkConds(PSWFLinkCond pSWFLinkCond, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSWFLINKCOND", true), (boolean)false) == 0) {
            PSWFLinkCondService pSWFLinkCondService = (PSWFLinkCondService)ServiceGlobal.getService(PSWFLinkCondService.class, (SessionFactory)this.getSessionFactory());
            PSWFLinkCond pSWFLinkCond2 = new PSWFLinkCond();
            pSWFLinkCond2.setPSWFLinkCondId(pSMOSFile.getPSModelId());
            if (!pSWFLinkCondService.get((IEntity)pSWFLinkCond2, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSWFLinkCond2.getPPSWFLinkCondId(), (String)pSWFLinkCond.getPSWFLinkCondId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSWFLinkCondService.exportModelV2(pSWFLinkCond2);
            pSWFLinkCond2.reset();
            if (!pSWFLinkCondService.setModelV2ResScope((IEntity)pSWFLinkCond2, "PSWFLINKCOND", pSWFLinkCond.getPSWFLinkCondId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSWFLinkCondService.importModelV2(pSWFLinkCond2, objectNode);
            SessionFactoryManager.commit();
            return pSWFLinkCondService.getFile((IEntity)pSWFLinkCond2);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSWFLinkCond pSWFLinkCond, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSWFLinkConds(pSWFLinkCond, list);
        super.onFillPasteHelps(pSWFLinkCond, list);
    }

    protected void onFillPasteHelps_PSWFLinkConds(PSWFLinkCond pSWFLinkCond, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSWFLINKCOND");
        pSHelpSection.setSectionParam2("DER1N_PSWFLINKCOND_PSWFLINKCOND_PPSWFLINKCONDID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u6d41\u7a0b\u5904\u7406\u8fde\u63a5\u6761\u4ef6]\u7684[\u6d41\u7a0b\u5904\u7406\u8fde\u63a5\u6761\u4ef6]");
        list.add(pSHelpSection);
    }

    @Override
    public Object getDataType(PSWFLinkCond pSWFLinkCond) throws Exception {
        return pSWFLinkCond.getLogicType();
    }
}

