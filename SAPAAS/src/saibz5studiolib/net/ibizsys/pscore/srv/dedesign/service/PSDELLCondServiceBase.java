/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ArrayNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.core.ActionContext
 *  net.ibizsys.paas.core.IActionContext
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
 *  net.ibizsys.paas.demodel.IDELogicModel
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
package net.ibizsys.pscore.srv.dedesign.service;

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
import net.ibizsys.paas.core.ActionContext;
import net.ibizsys.paas.core.IActionContext;
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
import net.ibizsys.paas.demodel.IDELogicModel;
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
import net.ibizsys.pscore.srv.dedesign.dao.PSDELLCondDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDELLCondDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELLCond;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELLCondBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicLink;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicLinkBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicParam;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicParamBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDELLCondService;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDELLCondServiceBase
extends PSCoreSysServiceBase<PSDELLCond> {
    private static final Log log = LogFactory.getLog(PSDELLCondServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_CALCDSTPARAMPSDEID = "CalcDstParamPSDEId";
    private PSDELLCondDEModel pSDELLCondDEModel;
    private PSDELLCondDAO pSDELLCondDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDELLCondService";
    }

    public PSDELLCondDEModel getPSDELLCondDEModel() {
        if (this.pSDELLCondDEModel == null) {
            try {
                this.pSDELLCondDEModel = (PSDELLCondDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDELLCondDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDELLCondDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDELLCondDEModel();
    }

    public PSDELLCondDAO getPSDELLCondDAO() {
        if (this.pSDELLCondDAO == null) {
            try {
                this.pSDELLCondDAO = (PSDELLCondDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDELLCondDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDELLCondDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDELLCondDAO();
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
        if (StringHelper.compare((String)string, (String)ACTION_CALCDSTPARAMPSDEID, (boolean)true) == 0) {
            this.calcDstParamPSDEId((PSDELLCond)iEntity);
            return;
        }
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

    public void calcDstParamPSDEId(PSDELLCond pSDELLCond) throws Exception {
        final PSDELLCond pSDELLCond2 = pSDELLCond;
        pSDELLCond2.setSessionFactory(this.getSessionFactory());
        this.testDEMainStateAction(pSDELLCond, ACTION_CALCDSTPARAMPSDEID);
        final IDELogicModel iDELogicModel = (IDELogicModel)this.getPSDELLCondDEModel().getDELogic(ACTION_CALCDSTPARAMPSDEID);
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                ActionContext actionContext = new ActionContext(null);
                actionContext.setParam(iDELogicModel.getDefaultParamName(), (Object)pSDELLCond2);
                actionContext.setSessionFactory(PSDELLCondServiceBase.this.getSessionFactory());
                iDELogicModel.execute((IActionContext)actionContext);
            }
        });
    }

    protected void onFillParentInfo(PSDELLCond pSDELLCond, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELLCOND_PSDBVALUEOP_PSDBVALUEOPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSDBValueOPService", (SessionFactory)this.getSessionFactory());
            PSDBValueOP pSDBValueOP = (PSDBValueOP)iService.getDEModel().createEntity();
            pSDBValueOP.set("PSDBVALUEOPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDBValueOP);
            } else {
                iService.get(pSDBValueOP);
            }
            this.onFillParentInfo_PSDBValueOP(pSDELLCond, pSDBValueOP);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELLCOND_PSDEFIELD_DSTPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_DstPSDEF(pSDELLCond, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELLCOND_PSDELLCOND_PPSDELLCONDID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELLCondService", (SessionFactory)this.getSessionFactory());
            PSDELLCond pSDELLCond2 = (PSDELLCond)iService.getDEModel().createEntity();
            pSDELLCond2.set("PSDELLCONDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDELLCond2);
            } else {
                iService.get(pSDELLCond2);
            }
            this.onFillParentInfo_PPSDELLCond(pSDELLCond, pSDELLCond2);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELLCOND_PSDELOGICLINK_PSDELOGICLINKID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELogicLinkService", (SessionFactory)this.getSessionFactory());
            PSDELogicLink pSDELogicLink = (PSDELogicLink)iService.getDEModel().createEntity();
            pSDELogicLink.set("PSDELOGICLINKID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDELogicLink);
            } else {
                iService.get(pSDELogicLink);
            }
            this.onFillParentInfo_PSDELogicLink(pSDELLCond, pSDELogicLink);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELLCOND_PSDELOGICPARAM_DSTPSDLPARAMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELogicParamService", (SessionFactory)this.getSessionFactory());
            PSDELogicParam pSDELogicParam = (PSDELogicParam)iService.getDEModel().createEntity();
            pSDELogicParam.set("PSDELOGICPARAMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDELogicParam);
            } else {
                iService.get(pSDELogicParam);
            }
            this.onFillParentInfo_DstPSDLParam(pSDELLCond, pSDELogicParam);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELLCOND_PSDELOGICPARAM_SRCPSDLPARAMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELogicParamService", (SessionFactory)this.getSessionFactory());
            PSDELogicParam pSDELogicParam = (PSDELogicParam)iService.getDEModel().createEntity();
            pSDELogicParam.set("PSDELOGICPARAMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDELogicParam);
            } else {
                iService.get(pSDELogicParam);
            }
            this.onFillParentInfo_SrcPSDLParam(pSDELLCond, pSDELogicParam);
            return;
        }
        super.onFillParentInfo(pSDELLCond, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        if (StringHelper.compare((String)string, (String)"DER1N_PSDELLCOND_PSDELOGICLINK_PSDELOGICLINKID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELogicLinkService", (SessionFactory)this.getSessionFactory());
            PSDELogicLink pSDELogicLink = (PSDELogicLink)iService.getDEModel().createEntity();
            pSDELogicLink.set("PSDELOGICLINKID", string2);
            return this.onSyncDER1NData_PSDELogicLink(pSDELogicLink, string3);
        }
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDBValueOP(PSDELLCond pSDELLCond, PSDBValueOP pSDBValueOP) throws Exception {
        pSDELLCond.setPSDBValueOPId(pSDBValueOP.getPSDBValueOPId());
        pSDELLCond.setPSDBValueOPName(pSDBValueOP.getPSDBValueOPName());
    }

    protected void onFillParentInfo_DstPSDEF(PSDELLCond pSDELLCond, PSDEField pSDEField) throws Exception {
        pSDELLCond.setDstPSDEFId(pSDEField.getPSDEFieldId());
        pSDELLCond.setDstPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_PPSDELLCond(PSDELLCond pSDELLCond, PSDELLCond pSDELLCond2) throws Exception {
        pSDELLCond.setPPSDELLCondId(pSDELLCond2.getPSDELLCondId());
        pSDELLCond.setPPSDELLCondName(pSDELLCond2.getPSDELLCondName());
        if (pSDELLCond2.getPSDELogicLink() != null) {
            this.onFillParentInfo_PSDELogicLink(pSDELLCond, pSDELLCond2.getPSDELogicLink());
        }
    }

    protected void onFillParentInfo_PSDELogicLink(PSDELLCond pSDELLCond, PSDELogicLink pSDELogicLink) throws Exception {
        pSDELLCond.setPSDElogicId(pSDELogicLink.getPSDELogicId());
        pSDELLCond.setPSDELogicLinkId(pSDELogicLink.getPSDELogicLinkId());
        pSDELLCond.setPSDELogicLinkName(pSDELogicLink.getPSDELogicLinkName());
    }

    protected String onSyncDER1NData_PSDELogicLink(PSDELogicLink pSDELogicLink, String string) throws Exception {
        if (StringHelper.isNullOrEmpty((String)string)) {
            this.removeByPSDELogicLink(pSDELogicLink);
        } else {
            HashMap<String, String> hashMap = new HashMap<String, String>();
            String[] stringArray = StringHelper.splitEx((String)string);
            if (stringArray != null) {
                for (int i = 0; i < stringArray.length; ++i) {
                    if (StringHelper.isNullOrEmpty((String)stringArray[i])) continue;
                    hashMap.put(stringArray[i], "");
                }
            }
            ArrayList<PSDELLCond> arrayList = this.selectByPSDELogicLink(pSDELogicLink);
            for (PSDELLCond pSDELLCond : arrayList) {
                if (hashMap.containsKey(DataObject.getStringValue((IDataObject)pSDELLCond, (String)"PSDELLCONDID", (String)""))) continue;
                this.remove(pSDELLCond);
            }
        }
        return null;
    }

    protected void onFillParentInfo_DstPSDLParam(PSDELLCond pSDELLCond, PSDELogicParam pSDELogicParam) throws Exception {
        pSDELLCond.setDstParamPSDEId(pSDELogicParam.getParamPSDEId());
        pSDELLCond.setDstPSDLParamId(pSDELogicParam.getPSDELogicParamId());
        pSDELLCond.setDstPSDLParamName(pSDELogicParam.getPSDELogicParamName());
    }

    protected void onFillParentInfo_SrcPSDLParam(PSDELLCond pSDELLCond, PSDELogicParam pSDELogicParam) throws Exception {
        pSDELLCond.setSrcPSDLParamId(pSDELogicParam.getPSDELogicParamId());
        pSDELLCond.setSrcPSDLParamName(pSDELogicParam.getPSDELogicParamName());
    }

    protected void onFillEntityFullInfo(PSDELLCond pSDELLCond, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDELLCond, bl);
        this.onFillEntityFullInfo_PSDBValueOP(pSDELLCond, bl);
        this.onFillEntityFullInfo_DstPSDEF(pSDELLCond, bl);
        this.onFillEntityFullInfo_PPSDELLCond(pSDELLCond, bl);
        this.onFillEntityFullInfo_PSDELogicLink(pSDELLCond, bl);
        this.onFillEntityFullInfo_DstPSDLParam(pSDELLCond, bl);
        this.onFillEntityFullInfo_SrcPSDLParam(pSDELLCond, bl);
    }

    protected void onFillEntityFullInfo_PSDBValueOP(PSDELLCond pSDELLCond, boolean bl) throws Exception {
        if (pSDELLCond.isPSDBValueOPIdDirty()) {
            if (pSDELLCond.getPSDBValueOPId() != null) {
                if (pSDELLCond.getPSDBValueOPId() == null || pSDELLCond.getPSDBValueOPName() == null) {
                    PSDBValueOP pSDBValueOP = pSDELLCond.getPSDBValueOP();
                    pSDELLCond.setPSDBValueOPName(pSDBValueOP.getPSDBValueOPName());
                }
            } else {
                pSDELLCond.setPSDBValueOPName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_DstPSDEF(PSDELLCond pSDELLCond, boolean bl) throws Exception {
        if (pSDELLCond.isDstPSDEFIdDirty()) {
            if (pSDELLCond.getDstPSDEFId() != null) {
                if (pSDELLCond.getDstPSDEFId() == null || pSDELLCond.getDstPSDEFName() == null) {
                    PSDEField pSDEField = pSDELLCond.getDstPSDEF();
                    pSDELLCond.setDstPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDELLCond.setDstPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PPSDELLCond(PSDELLCond pSDELLCond, boolean bl) throws Exception {
        if (pSDELLCond.isPPSDELLCondIdDirty()) {
            if (pSDELLCond.getPPSDELLCondId() != null) {
                PSDELLCond pSDELLCond2;
                if (pSDELLCond.getPPSDELLCondId() == null || pSDELLCond.getPPSDELLCondName() == null) {
                    pSDELLCond2 = pSDELLCond.getPPSDELLCond();
                    pSDELLCond.setPPSDELLCondName(pSDELLCond2.getPSDELLCondName());
                }
                if (DataTypeHelper.compare((int)25, (Object)(pSDELLCond2 = pSDELLCond.getPPSDELLCond()).getPSDELogicLinkId(), (Object)pSDELLCond.getPSDELogicLinkId()) != 0L) {
                    pSDELLCond.setPSDELogicLinkId(pSDELLCond2.getPSDELogicLinkId());
                    this.onFillEntityFullInfo_PSDELogicLink(pSDELLCond, bl);
                }
            } else {
                pSDELLCond.setPPSDELLCondName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDELogicLink(PSDELLCond pSDELLCond, boolean bl) throws Exception {
        if (pSDELLCond.isPSDELogicLinkIdDirty()) {
            if (pSDELLCond.getPSDELogicLinkId() != null) {
                if (pSDELLCond.getPSDELogicLinkId() == null || pSDELLCond.getPSDELogicLinkName() == null) {
                    PSDELogicLink pSDELogicLink = pSDELLCond.getPSDELogicLink();
                    pSDELLCond.setPSDElogicId(pSDELogicLink.getPSDELogicId());
                    pSDELLCond.setPSDELogicLinkName(pSDELogicLink.getPSDELogicLinkName());
                }
            } else {
                pSDELLCond.setPSDElogicId(null);
                pSDELLCond.setPSDELogicLinkName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_DstPSDLParam(PSDELLCond pSDELLCond, boolean bl) throws Exception {
        if (pSDELLCond.isDstPSDLParamIdDirty()) {
            if (pSDELLCond.getDstPSDLParamId() != null) {
                if (pSDELLCond.getDstPSDLParamId() == null || pSDELLCond.getDstPSDLParamName() == null) {
                    PSDELogicParam pSDELogicParam = pSDELLCond.getDstPSDLParam();
                    pSDELLCond.setDstParamPSDEId(pSDELogicParam.getParamPSDEId());
                    pSDELLCond.setDstPSDLParamName(pSDELogicParam.getPSDELogicParamName());
                }
            } else {
                pSDELLCond.setDstParamPSDEId(null);
                pSDELLCond.setDstPSDLParamName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_SrcPSDLParam(PSDELLCond pSDELLCond, boolean bl) throws Exception {
        if (pSDELLCond.isSrcPSDLParamIdDirty()) {
            if (pSDELLCond.getSrcPSDLParamId() != null) {
                if (pSDELLCond.getSrcPSDLParamId() == null || pSDELLCond.getSrcPSDLParamName() == null) {
                    PSDELogicParam pSDELogicParam = pSDELLCond.getSrcPSDLParam();
                    pSDELLCond.setSrcPSDLParamName(pSDELogicParam.getPSDELogicParamName());
                }
            } else {
                pSDELLCond.setSrcPSDLParamName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDELLCond pSDELLCond, boolean bl) throws Exception {
        super.onWriteBackParent(pSDELLCond, bl);
    }

    public ArrayList<PSDELLCond> selectByPSDBValueOP(PSDBValueOPBase pSDBValueOPBase) throws Exception {
        return this.selectByPSDBValueOP(pSDBValueOPBase, "", -1);
    }

    public ArrayList<PSDELLCond> selectByPSDBValueOP(PSDBValueOPBase pSDBValueOPBase, String string) throws Exception {
        return this.selectByPSDBValueOP(pSDBValueOPBase, string, -1);
    }

    public ArrayList<PSDELLCond> selectByPSDBValueOP(PSDBValueOPBase pSDBValueOPBase, String string, int n) throws Exception {
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

    public ArrayList<PSDELLCond> selectByDstPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByDstPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDELLCond> selectByDstPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByDstPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDELLCond> selectByDstPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
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

    public ArrayList<PSDELLCond> selectByPPSDELLCond(PSDELLCondBase pSDELLCondBase) throws Exception {
        return this.selectByPPSDELLCond(pSDELLCondBase, "", -1);
    }

    public ArrayList<PSDELLCond> selectByPPSDELLCond(PSDELLCondBase pSDELLCondBase, String string) throws Exception {
        return this.selectByPPSDELLCond(pSDELLCondBase, string, -1);
    }

    public ArrayList<PSDELLCond> selectByPPSDELLCond(PSDELLCondBase pSDELLCondBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSDELLCONDID", (Object)pSDELLCondBase.getPSDELLCondId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPPSDELLCondCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPPSDELLCondCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELLCond> selectTempByPPSDELLCond(PSDELLCondBase pSDELLCondBase) throws Exception {
        return this.selectTempByPPSDELLCond(pSDELLCondBase, "");
    }

    public ArrayList<PSDELLCond> selectTempByPPSDELLCond(PSDELLCondBase pSDELLCondBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSDELLCONDID", (Object)pSDELLCondBase.getPSDELLCondId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPPSDELLCondCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPPSDELLCondCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELLCond> selectByPSDELogicLink(PSDELogicLinkBase pSDELogicLinkBase) throws Exception {
        return this.selectByPSDELogicLink(pSDELogicLinkBase, "", -1);
    }

    public ArrayList<PSDELLCond> selectByPSDELogicLink(PSDELogicLinkBase pSDELogicLinkBase, String string) throws Exception {
        return this.selectByPSDELogicLink(pSDELogicLinkBase, string, -1);
    }

    public ArrayList<PSDELLCond> selectByPSDELogicLink(PSDELogicLinkBase pSDELogicLinkBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDELOGICLINKID", (Object)pSDELogicLinkBase.getPSDELogicLinkId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDELogicLinkCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDELogicLinkCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELLCond> selectTempByPSDELogicLink(PSDELogicLinkBase pSDELogicLinkBase) throws Exception {
        return this.selectTempByPSDELogicLink(pSDELogicLinkBase, "");
    }

    public ArrayList<PSDELLCond> selectTempByPSDELogicLink(PSDELogicLinkBase pSDELogicLinkBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDELOGICLINKID", (Object)pSDELogicLinkBase.getPSDELogicLinkId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDELogicLinkCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDELogicLinkCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELLCond> selectByDstPSDLParam(PSDELogicParamBase pSDELogicParamBase) throws Exception {
        return this.selectByDstPSDLParam(pSDELogicParamBase, "", -1);
    }

    public ArrayList<PSDELLCond> selectByDstPSDLParam(PSDELogicParamBase pSDELogicParamBase, String string) throws Exception {
        return this.selectByDstPSDLParam(pSDELogicParamBase, string, -1);
    }

    public ArrayList<PSDELLCond> selectByDstPSDLParam(PSDELogicParamBase pSDELogicParamBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DSTPSDLPARAMID", (Object)pSDELogicParamBase.getPSDELogicParamId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDstPSDLParamCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDstPSDLParamCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELLCond> selectTempByDstPSDLParam(PSDELogicParamBase pSDELogicParamBase) throws Exception {
        return this.selectTempByDstPSDLParam(pSDELogicParamBase, "");
    }

    public ArrayList<PSDELLCond> selectTempByDstPSDLParam(PSDELogicParamBase pSDELogicParamBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DSTPSDLPARAMID", (Object)pSDELogicParamBase.getPSDELogicParamId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByDstPSDLParamCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByDstPSDLParamCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELLCond> selectBySrcPSDLParam(PSDELogicParamBase pSDELogicParamBase) throws Exception {
        return this.selectBySrcPSDLParam(pSDELogicParamBase, "", -1);
    }

    public ArrayList<PSDELLCond> selectBySrcPSDLParam(PSDELogicParamBase pSDELogicParamBase, String string) throws Exception {
        return this.selectBySrcPSDLParam(pSDELogicParamBase, string, -1);
    }

    public ArrayList<PSDELLCond> selectBySrcPSDLParam(PSDELogicParamBase pSDELogicParamBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("SRCPSDLPARAMID", (Object)pSDELogicParamBase.getPSDELogicParamId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectBySrcPSDLParamCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectBySrcPSDLParamCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELLCond> selectTempBySrcPSDLParam(PSDELogicParamBase pSDELogicParamBase) throws Exception {
        return this.selectTempBySrcPSDLParam(pSDELogicParamBase, "");
    }

    public ArrayList<PSDELLCond> selectTempBySrcPSDLParam(PSDELogicParamBase pSDELogicParamBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("SRCPSDLPARAMID", (Object)pSDELogicParamBase.getPSDELogicParamId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempBySrcPSDLParamCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempBySrcPSDLParamCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDBValueOP(PSDBValueOP pSDBValueOP) throws Exception {
        ArrayList<PSDELLCond> arrayList = this.selectByPSDBValueOP(pSDBValueOP, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDBVALUEOP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDBValueOP);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELLCOND_PSDBVALUEOP_PSDBVALUEOPID", "", iDataEntityModel.getName(), "PSDELLCOND", iDataEntityModel.getDataInfo(pSDBValueOP), arrayList.get(0)));
        }
    }

    public void resetPSDBValueOP(PSDBValueOP pSDBValueOP) throws Exception {
        ArrayList<PSDELLCond> arrayList = this.selectByPSDBValueOP(pSDBValueOP);
        for (PSDELLCond pSDELLCond : arrayList) {
            PSDELLCond pSDELLCond2 = (PSDELLCond)this.getDEModel().createEntity();
            pSDELLCond2.setPSDELLCondId(pSDELLCond.getPSDELLCondId());
            pSDELLCond2.setPSDBValueOPId(null);
            this.update(pSDELLCond2);
        }
    }

    public void removeByPSDBValueOP(PSDBValueOP pSDBValueOP) throws Exception {
        final PSDBValueOP pSDBValueOP2 = pSDBValueOP;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELLCondServiceBase.this.onBeforeRemoveByPSDBValueOP(pSDBValueOP2);
                PSDELLCondServiceBase.this.internalRemoveByPSDBValueOP(pSDBValueOP2);
                PSDELLCondServiceBase.this.onAfterRemoveByPSDBValueOP(pSDBValueOP2);
            }
        });
    }

    protected void onBeforeRemoveByPSDBValueOP(PSDBValueOP pSDBValueOP) throws Exception {
    }

    protected void internalRemoveByPSDBValueOP(PSDBValueOP pSDBValueOP) throws Exception {
        ArrayList<PSDELLCond> arrayList = this.selectByPSDBValueOP(pSDBValueOP);
        this.onBeforeRemoveByPSDBValueOP(pSDBValueOP, arrayList);
        for (PSDELLCond pSDELLCond : arrayList) {
            this.remove(pSDELLCond);
        }
        this.onAfterRemoveByPSDBValueOP(pSDBValueOP, arrayList);
    }

    protected void onAfterRemoveByPSDBValueOP(PSDBValueOP pSDBValueOP) throws Exception {
    }

    protected void onBeforeRemoveByPSDBValueOP(PSDBValueOP pSDBValueOP, ArrayList<PSDELLCond> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDBValueOP(PSDBValueOP pSDBValueOP, ArrayList<PSDELLCond> arrayList) throws Exception {
    }

    public void testRemoveByDstPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDELLCond> arrayList = this.selectByDstPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELLCOND_PSDEFIELD_DSTPSDEFID", "", iDataEntityModel.getName(), "PSDELLCOND", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetDstPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDELLCond> arrayList = this.selectByDstPSDEF(pSDEField);
        for (PSDELLCond pSDELLCond : arrayList) {
            PSDELLCond pSDELLCond2 = (PSDELLCond)this.getDEModel().createEntity();
            pSDELLCond2.setPSDELLCondId(pSDELLCond.getPSDELLCondId());
            pSDELLCond2.setDstPSDEFId(null);
            this.update(pSDELLCond2);
        }
    }

    public void removeByDstPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELLCondServiceBase.this.onBeforeRemoveByDstPSDEF(pSDEField2);
                PSDELLCondServiceBase.this.internalRemoveByDstPSDEF(pSDEField2);
                PSDELLCondServiceBase.this.onAfterRemoveByDstPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByDstPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByDstPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDELLCond> arrayList = this.selectByDstPSDEF(pSDEField);
        this.onBeforeRemoveByDstPSDEF(pSDEField, arrayList);
        for (PSDELLCond pSDELLCond : arrayList) {
            this.remove(pSDELLCond);
        }
        this.onAfterRemoveByDstPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByDstPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByDstPSDEF(PSDEField pSDEField, ArrayList<PSDELLCond> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDstPSDEF(PSDEField pSDEField, ArrayList<PSDELLCond> arrayList) throws Exception {
    }

    public void testRemoveByPPSDELLCond(PSDELLCond pSDELLCond) throws Exception {
    }

    public void resetPPSDELLCond(PSDELLCond pSDELLCond) throws Exception {
        ArrayList<PSDELLCond> arrayList = this.selectByPPSDELLCond(pSDELLCond);
        for (PSDELLCond pSDELLCond2 : arrayList) {
            PSDELLCond pSDELLCond3 = (PSDELLCond)this.getDEModel().createEntity();
            pSDELLCond3.setPSDELLCondId(pSDELLCond2.getPSDELLCondId());
            pSDELLCond3.setPPSDELLCondId(null);
            this.update(pSDELLCond3);
        }
    }

    public void resetTempPPSDELLCond(PSDELLCond pSDELLCond) throws Exception {
        ArrayList<PSDELLCond> arrayList = this.selectTempByPPSDELLCond(pSDELLCond);
        for (PSDELLCond pSDELLCond2 : arrayList) {
            PSDELLCond pSDELLCond3 = (PSDELLCond)this.getDEModel().createEntity();
            pSDELLCond3.setPSDELLCondId(pSDELLCond2.getPSDELLCondId());
            pSDELLCond3.setPPSDELLCondId(null);
            this.updateTemp(pSDELLCond3);
        }
    }

    public void removeByPPSDELLCond(PSDELLCond pSDELLCond) throws Exception {
        final PSDELLCond pSDELLCond2 = pSDELLCond;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELLCondServiceBase.this.onBeforeRemoveByPPSDELLCond(pSDELLCond2);
                PSDELLCondServiceBase.this.internalRemoveByPPSDELLCond(pSDELLCond2);
                PSDELLCondServiceBase.this.onAfterRemoveByPPSDELLCond(pSDELLCond2);
            }
        });
    }

    protected void onBeforeRemoveByPPSDELLCond(PSDELLCond pSDELLCond) throws Exception {
    }

    protected void internalRemoveByPPSDELLCond(PSDELLCond pSDELLCond) throws Exception {
        ArrayList<PSDELLCond> arrayList = this.selectByPPSDELLCond(pSDELLCond);
        this.onBeforeRemoveByPPSDELLCond(pSDELLCond, arrayList);
        for (PSDELLCond pSDELLCond2 : arrayList) {
            this.remove(pSDELLCond2);
        }
        this.onAfterRemoveByPPSDELLCond(pSDELLCond, arrayList);
    }

    protected void onAfterRemoveByPPSDELLCond(PSDELLCond pSDELLCond) throws Exception {
    }

    protected void onBeforeRemoveByPPSDELLCond(PSDELLCond pSDELLCond, ArrayList<PSDELLCond> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPPSDELLCond(PSDELLCond pSDELLCond, ArrayList<PSDELLCond> arrayList) throws Exception {
    }

    public void testRemoveByPSDELogicLink(PSDELogicLink pSDELogicLink) throws Exception {
    }

    public void resetPSDELogicLink(PSDELogicLink pSDELogicLink) throws Exception {
        ArrayList<PSDELLCond> arrayList = this.selectByPSDELogicLink(pSDELogicLink);
        for (PSDELLCond pSDELLCond : arrayList) {
            PSDELLCond pSDELLCond2 = (PSDELLCond)this.getDEModel().createEntity();
            pSDELLCond2.setPSDELLCondId(pSDELLCond.getPSDELLCondId());
            pSDELLCond2.setPSDELogicLinkId(null);
            this.update(pSDELLCond2);
        }
    }

    public void resetTempPSDELogicLink(PSDELogicLink pSDELogicLink) throws Exception {
        ArrayList<PSDELLCond> arrayList = this.selectTempByPSDELogicLink(pSDELogicLink);
        for (PSDELLCond pSDELLCond : arrayList) {
            PSDELLCond pSDELLCond2 = (PSDELLCond)this.getDEModel().createEntity();
            pSDELLCond2.setPSDELLCondId(pSDELLCond.getPSDELLCondId());
            pSDELLCond2.setPSDELogicLinkId(null);
            this.updateTemp(pSDELLCond2);
        }
    }

    public void removeByPSDELogicLink(PSDELogicLink pSDELogicLink) throws Exception {
        final PSDELogicLink pSDELogicLink2 = pSDELogicLink;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELLCondServiceBase.this.onBeforeRemoveByPSDELogicLink(pSDELogicLink2);
                PSDELLCondServiceBase.this.internalRemoveByPSDELogicLink(pSDELogicLink2);
                PSDELLCondServiceBase.this.onAfterRemoveByPSDELogicLink(pSDELogicLink2);
            }
        });
    }

    protected void onBeforeRemoveByPSDELogicLink(PSDELogicLink pSDELogicLink) throws Exception {
    }

    protected void internalRemoveByPSDELogicLink(PSDELogicLink pSDELogicLink) throws Exception {
        ArrayList<PSDELLCond> arrayList = this.selectByPSDELogicLink(pSDELogicLink);
        this.onBeforeRemoveByPSDELogicLink(pSDELogicLink, arrayList);
        for (PSDELLCond pSDELLCond : arrayList) {
            this.remove(pSDELLCond);
        }
        this.onAfterRemoveByPSDELogicLink(pSDELogicLink, arrayList);
    }

    protected void onAfterRemoveByPSDELogicLink(PSDELogicLink pSDELogicLink) throws Exception {
    }

    protected void onBeforeRemoveByPSDELogicLink(PSDELogicLink pSDELogicLink, ArrayList<PSDELLCond> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDELogicLink(PSDELogicLink pSDELogicLink, ArrayList<PSDELLCond> arrayList) throws Exception {
    }

    public void testRemoveByDstPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
    }

    public void resetDstPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
        ArrayList<PSDELLCond> arrayList = this.selectByDstPSDLParam(pSDELogicParam);
        for (PSDELLCond pSDELLCond : arrayList) {
            PSDELLCond pSDELLCond2 = (PSDELLCond)this.getDEModel().createEntity();
            pSDELLCond2.setPSDELLCondId(pSDELLCond.getPSDELLCondId());
            pSDELLCond2.setDstPSDLParamId(null);
            this.update(pSDELLCond2);
        }
    }

    public void resetTempDstPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
        ArrayList<PSDELLCond> arrayList = this.selectTempByDstPSDLParam(pSDELogicParam);
        for (PSDELLCond pSDELLCond : arrayList) {
            PSDELLCond pSDELLCond2 = (PSDELLCond)this.getDEModel().createEntity();
            pSDELLCond2.setPSDELLCondId(pSDELLCond.getPSDELLCondId());
            pSDELLCond2.setDstPSDLParamId(null);
            this.updateTemp(pSDELLCond2);
        }
    }

    public void removeByDstPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
        final PSDELogicParam pSDELogicParam2 = pSDELogicParam;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELLCondServiceBase.this.onBeforeRemoveByDstPSDLParam(pSDELogicParam2);
                PSDELLCondServiceBase.this.internalRemoveByDstPSDLParam(pSDELogicParam2);
                PSDELLCondServiceBase.this.onAfterRemoveByDstPSDLParam(pSDELogicParam2);
            }
        });
    }

    protected void onBeforeRemoveByDstPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
    }

    protected void internalRemoveByDstPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
        ArrayList<PSDELLCond> arrayList = this.selectByDstPSDLParam(pSDELogicParam);
        this.onBeforeRemoveByDstPSDLParam(pSDELogicParam, arrayList);
        for (PSDELLCond pSDELLCond : arrayList) {
            this.remove(pSDELLCond);
        }
        this.onAfterRemoveByDstPSDLParam(pSDELogicParam, arrayList);
    }

    protected void onAfterRemoveByDstPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
    }

    protected void onBeforeRemoveByDstPSDLParam(PSDELogicParam pSDELogicParam, ArrayList<PSDELLCond> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDstPSDLParam(PSDELogicParam pSDELogicParam, ArrayList<PSDELLCond> arrayList) throws Exception {
    }

    public void testRemoveBySrcPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
    }

    public void resetSrcPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
        ArrayList<PSDELLCond> arrayList = this.selectBySrcPSDLParam(pSDELogicParam);
        for (PSDELLCond pSDELLCond : arrayList) {
            PSDELLCond pSDELLCond2 = (PSDELLCond)this.getDEModel().createEntity();
            pSDELLCond2.setPSDELLCondId(pSDELLCond.getPSDELLCondId());
            pSDELLCond2.setSrcPSDLParamId(null);
            this.update(pSDELLCond2);
        }
    }

    public void resetTempSrcPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
        ArrayList<PSDELLCond> arrayList = this.selectTempBySrcPSDLParam(pSDELogicParam);
        for (PSDELLCond pSDELLCond : arrayList) {
            PSDELLCond pSDELLCond2 = (PSDELLCond)this.getDEModel().createEntity();
            pSDELLCond2.setPSDELLCondId(pSDELLCond.getPSDELLCondId());
            pSDELLCond2.setSrcPSDLParamId(null);
            this.updateTemp(pSDELLCond2);
        }
    }

    public void removeBySrcPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
        final PSDELogicParam pSDELogicParam2 = pSDELogicParam;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELLCondServiceBase.this.onBeforeRemoveBySrcPSDLParam(pSDELogicParam2);
                PSDELLCondServiceBase.this.internalRemoveBySrcPSDLParam(pSDELogicParam2);
                PSDELLCondServiceBase.this.onAfterRemoveBySrcPSDLParam(pSDELogicParam2);
            }
        });
    }

    protected void onBeforeRemoveBySrcPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
    }

    protected void internalRemoveBySrcPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
        ArrayList<PSDELLCond> arrayList = this.selectBySrcPSDLParam(pSDELogicParam);
        this.onBeforeRemoveBySrcPSDLParam(pSDELogicParam, arrayList);
        for (PSDELLCond pSDELLCond : arrayList) {
            this.remove(pSDELLCond);
        }
        this.onAfterRemoveBySrcPSDLParam(pSDELogicParam, arrayList);
    }

    protected void onAfterRemoveBySrcPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
    }

    protected void onBeforeRemoveBySrcPSDLParam(PSDELogicParam pSDELogicParam, ArrayList<PSDELLCond> arrayList) throws Exception {
    }

    protected void onAfterRemoveBySrcPSDLParam(PSDELogicParam pSDELogicParam, ArrayList<PSDELLCond> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDELLCond pSDELLCond) throws Exception {
        PSDELLCondService pSDELLCondService = (PSDELLCondService)ServiceGlobal.getService(PSDELLCondService.class, (SessionFactory)this.getSessionFactory());
        pSDELLCondService.testRemoveByPPSDELLCond(pSDELLCond);
        pSDELLCondService.resetPPSDELLCond(pSDELLCond);
        super.onBeforeRemove(pSDELLCond);
    }

    protected void onBeforeRemoveTemp(PSDELLCond pSDELLCond) throws Exception {
        PSDELLCondService pSDELLCondService = (PSDELLCondService)ServiceGlobal.getService(PSDELLCondService.class, (SessionFactory)this.getSessionFactory());
        pSDELLCondService.resetTempPPSDELLCond(pSDELLCond);
        super.onBeforeRemoveTemp(pSDELLCond);
    }

    public void removeTempByPPSDELLCond(PSDELLCond pSDELLCond) throws Exception {
        final PSDELLCond pSDELLCond2 = pSDELLCond;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELLCondServiceBase.this.onBeforeRemoveTempByPPSDELLCond(pSDELLCond2);
                PSDELLCondServiceBase.this.internalRemoveTempByPPSDELLCond(pSDELLCond2);
                PSDELLCondServiceBase.this.onAfterRemoveTempByPPSDELLCond(pSDELLCond2);
            }
        });
    }

    protected void onBeforeRemoveTempByPPSDELLCond(PSDELLCond pSDELLCond) throws Exception {
    }

    protected void internalRemoveTempByPPSDELLCond(PSDELLCond pSDELLCond) throws Exception {
        ArrayList<PSDELLCond> arrayList = this.selectTempByPPSDELLCond(pSDELLCond);
        this.onBeforeRemoveTempByPPSDELLCond(pSDELLCond, arrayList);
        for (PSDELLCond pSDELLCond2 : arrayList) {
            this.removeTemp(pSDELLCond2);
        }
        this.onAfterRemoveTempByPPSDELLCond(pSDELLCond, arrayList);
    }

    protected void onAfterRemoveTempByPPSDELLCond(PSDELLCond pSDELLCond) throws Exception {
    }

    protected void onBeforeRemoveTempByPPSDELLCond(PSDELLCond pSDELLCond, ArrayList<PSDELLCond> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPPSDELLCond(PSDELLCond pSDELLCond, ArrayList<PSDELLCond> arrayList) throws Exception {
    }

    public void removeTempByDstPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
        final PSDELogicParam pSDELogicParam2 = pSDELogicParam;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELLCondServiceBase.this.onBeforeRemoveTempByDstPSDLParam(pSDELogicParam2);
                PSDELLCondServiceBase.this.internalRemoveTempByDstPSDLParam(pSDELogicParam2);
                PSDELLCondServiceBase.this.onAfterRemoveTempByDstPSDLParam(pSDELogicParam2);
            }
        });
    }

    protected void onBeforeRemoveTempByDstPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
    }

    protected void internalRemoveTempByDstPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
        ArrayList<PSDELLCond> arrayList = this.selectTempByDstPSDLParam(pSDELogicParam);
        this.onBeforeRemoveTempByDstPSDLParam(pSDELogicParam, arrayList);
        for (PSDELLCond pSDELLCond : arrayList) {
            this.removeTemp(pSDELLCond);
        }
        this.onAfterRemoveTempByDstPSDLParam(pSDELogicParam, arrayList);
    }

    protected void onAfterRemoveTempByDstPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
    }

    protected void onBeforeRemoveTempByDstPSDLParam(PSDELogicParam pSDELogicParam, ArrayList<PSDELLCond> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByDstPSDLParam(PSDELogicParam pSDELogicParam, ArrayList<PSDELLCond> arrayList) throws Exception {
    }

    public void removeTempBySrcPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
        final PSDELogicParam pSDELogicParam2 = pSDELogicParam;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELLCondServiceBase.this.onBeforeRemoveTempBySrcPSDLParam(pSDELogicParam2);
                PSDELLCondServiceBase.this.internalRemoveTempBySrcPSDLParam(pSDELogicParam2);
                PSDELLCondServiceBase.this.onAfterRemoveTempBySrcPSDLParam(pSDELogicParam2);
            }
        });
    }

    protected void onBeforeRemoveTempBySrcPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
    }

    protected void internalRemoveTempBySrcPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
        ArrayList<PSDELLCond> arrayList = this.selectTempBySrcPSDLParam(pSDELogicParam);
        this.onBeforeRemoveTempBySrcPSDLParam(pSDELogicParam, arrayList);
        for (PSDELLCond pSDELLCond : arrayList) {
            this.removeTemp(pSDELLCond);
        }
        this.onAfterRemoveTempBySrcPSDLParam(pSDELogicParam, arrayList);
    }

    protected void onAfterRemoveTempBySrcPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
    }

    protected void onBeforeRemoveTempBySrcPSDLParam(PSDELogicParam pSDELogicParam, ArrayList<PSDELLCond> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempBySrcPSDLParam(PSDELogicParam pSDELogicParam, ArrayList<PSDELLCond> arrayList) throws Exception {
    }

    public void removeTempByPSDELogicLink(PSDELogicLink pSDELogicLink) throws Exception {
        final PSDELogicLink pSDELogicLink2 = pSDELogicLink;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELLCondServiceBase.this.onBeforeRemoveTempByPSDELogicLink(pSDELogicLink2);
                PSDELLCondServiceBase.this.internalRemoveTempByPSDELogicLink(pSDELogicLink2);
                PSDELLCondServiceBase.this.onAfterRemoveTempByPSDELogicLink(pSDELogicLink2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDELogicLink(PSDELogicLink pSDELogicLink) throws Exception {
    }

    protected void internalRemoveTempByPSDELogicLink(PSDELogicLink pSDELogicLink) throws Exception {
        ArrayList<PSDELLCond> arrayList = this.selectTempByPSDELogicLink(pSDELogicLink);
        this.onBeforeRemoveTempByPSDELogicLink(pSDELogicLink, arrayList);
        for (PSDELLCond pSDELLCond : arrayList) {
            this.removeTemp(pSDELLCond);
        }
        this.onAfterRemoveTempByPSDELogicLink(pSDELogicLink, arrayList);
    }

    protected void onAfterRemoveTempByPSDELogicLink(PSDELogicLink pSDELogicLink) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDELogicLink(PSDELogicLink pSDELogicLink, ArrayList<PSDELLCond> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDELogicLink(PSDELogicLink pSDELogicLink, ArrayList<PSDELLCond> arrayList) throws Exception {
    }

    protected void getRelatedDataTempMajor(PSDELLCond pSDELLCond) throws Exception {
        super.getRelatedDataTempMajor(pSDELLCond);
    }

    protected void updateRelatedDataTempMajor(PSDELLCond pSDELLCond, PSDELLCond pSDELLCond2) throws Exception {
        super.updateRelatedDataTempMajor(pSDELLCond, pSDELLCond2);
    }

    protected void replaceParentInfo(PSDELLCond pSDELLCond, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDELLCond, cloneSession);
        if (pSDELLCond.getPSDBValueOPId() != null && (iEntity = cloneSession.getEntity("PSDBVALUEOP", (Object)pSDELLCond.getPSDBValueOPId())) != null) {
            this.onFillParentInfo_PSDBValueOP(pSDELLCond, (PSDBValueOP)iEntity);
        }
        if (pSDELLCond.getDstPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDELLCond.getDstPSDEFId())) != null) {
            this.onFillParentInfo_DstPSDEF(pSDELLCond, (PSDEField)iEntity);
        }
        if (pSDELLCond.getPPSDELLCondId() != null && (iEntity = cloneSession.getEntity("PSDELLCOND", (Object)pSDELLCond.getPPSDELLCondId())) != null) {
            this.onFillParentInfo_PPSDELLCond(pSDELLCond, (PSDELLCond)iEntity);
        }
        if (pSDELLCond.getPSDELogicLinkId() != null && (iEntity = cloneSession.getEntity("PSDELOGICLINK", (Object)pSDELLCond.getPSDELogicLinkId())) != null) {
            this.onFillParentInfo_PSDELogicLink(pSDELLCond, (PSDELogicLink)iEntity);
        }
        if (pSDELLCond.getDstPSDLParamId() != null && (iEntity = cloneSession.getEntity("PSDELOGICPARAM", (Object)pSDELLCond.getDstPSDLParamId())) != null) {
            this.onFillParentInfo_DstPSDLParam(pSDELLCond, (PSDELogicParam)iEntity);
        }
        if (pSDELLCond.getSrcPSDLParamId() != null && (iEntity = cloneSession.getEntity("PSDELOGICPARAM", (Object)pSDELLCond.getSrcPSDLParamId())) != null) {
            this.onFillParentInfo_SrcPSDLParam(pSDELLCond, (PSDELogicParam)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDELLCond pSDELLCond, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDELLCond, bl);
    }

    protected void onCheckEntity(boolean bl, PSDELLCond pSDELLCond, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CondValue(bl, pSDELLCond, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomDSTParam(bl, pSDELLCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstPSDEFId(bl, pSDELLCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstPSDEFName(bl, pSDELLCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstPSDLParamId(bl, pSDELLCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstPSDLParamName(bl, pSDELLCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaModelFlag(bl, pSDELLCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupNotFlag(bl, pSDELLCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupOP(bl, pSDELLCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicType(bl, pSDELLCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDELLCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDELLCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ParamType(bl, pSDELLCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSDELLCondId(bl, pSDELLCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSDELLCondName(bl, pSDELLCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDBValueOPId(bl, pSDELLCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDBValueOPName(bl, pSDELLCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDELLCondId(bl, pSDELLCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDELLCondName(bl, pSDELLCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDELogicLinkId(bl, pSDELLCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDELogicLinkName(bl, pSDELLCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, pSDELLCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SrcPSDLParamId(bl, pSDELLCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SrcPSDLParamName(bl, pSDELLCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDELLCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDELLCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDELLCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDELLCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDELLCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDELLCond, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CondValue(boolean bl, PSDELLCond pSDELLCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELLCond.isCondValueDirty() : !pSDELLCond.isCondValueDirty()) {
            return null;
        }
        String string = pSDELLCond.getCondValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CondValue_Default(pSDELLCond, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomDSTParam(boolean bl, PSDELLCond pSDELLCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELLCond.isCustomDSTParamDirty() : !pSDELLCond.isCustomDSTParamDirty()) {
            return null;
        }
        String string = pSDELLCond.getCustomDSTParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomDSTParam_Default(pSDELLCond, bl2, bl3);
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

    protected EntityFieldError onCheckField_DstPSDEFId(boolean bl, PSDELLCond pSDELLCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELLCond.isDstPSDEFIdDirty() : !pSDELLCond.isDstPSDEFIdDirty()) {
            return null;
        }
        String string = pSDELLCond.getDstPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstPSDEFId_Default(pSDELLCond, bl2, bl3);
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

    protected EntityFieldError onCheckField_DstPSDEFName(boolean bl, PSDELLCond pSDELLCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELLCond.isDstPSDEFNameDirty() : !pSDELLCond.isDstPSDEFNameDirty()) {
            return null;
        }
        String string = pSDELLCond.getDstPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstPSDEFName_Default(pSDELLCond, bl2, bl3);
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

    protected EntityFieldError onCheckField_DstPSDLParamId(boolean bl, PSDELLCond pSDELLCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELLCond.isDstPSDLParamIdDirty() : !pSDELLCond.isDstPSDLParamIdDirty()) {
            return null;
        }
        String string = pSDELLCond.getDstPSDLParamId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstPSDLParamId_Default(pSDELLCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTPSDLPARAMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DstPSDLParamName(boolean bl, PSDELLCond pSDELLCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELLCond.isDstPSDLParamNameDirty() : !pSDELLCond.isDstPSDLParamNameDirty()) {
            return null;
        }
        String string = pSDELLCond.getDstPSDLParamName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstPSDLParamName_Default(pSDELLCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTPSDLPARAMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaModelFlag(boolean bl, PSDELLCond pSDELLCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELLCond.isDynaModelFlagDirty() : !pSDELLCond.isDynaModelFlagDirty()) {
            return null;
        }
        Integer n = pSDELLCond.getDynaModelFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DynaModelFlag_Default(pSDELLCond, bl2, bl3);
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

    protected EntityFieldError onCheckField_GroupNotFlag(boolean bl, PSDELLCond pSDELLCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELLCond.isGroupNotFlagDirty() : !pSDELLCond.isGroupNotFlagDirty()) {
            return null;
        }
        Integer n = pSDELLCond.getGroupNotFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_GroupNotFlag_Default(pSDELLCond, bl2, bl3);
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

    protected EntityFieldError onCheckField_GroupOP(boolean bl, PSDELLCond pSDELLCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELLCond.isGroupOPDirty() : !pSDELLCond.isGroupOPDirty()) {
            return null;
        }
        String string = pSDELLCond.getGroupOP();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupOP_Default(pSDELLCond, bl2, bl3);
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

    protected EntityFieldError onCheckField_LogicType(boolean bl, PSDELLCond pSDELLCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELLCond.isLogicTypeDirty() && !bl2 : !pSDELLCond.isLogicTypeDirty()) {
            return null;
        }
        String string = pSDELLCond.getLogicType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGICTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicType_Default(pSDELLCond, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDELLCond pSDELLCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELLCond.isMemoDirty() : !pSDELLCond.isMemoDirty()) {
            return null;
        }
        String string = pSDELLCond.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDELLCond, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDELLCond pSDELLCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELLCond.isOrderValueDirty() : !pSDELLCond.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDELLCond.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSDELLCond, bl2, bl3);
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

    protected EntityFieldError onCheckField_ParamType(boolean bl, PSDELLCond pSDELLCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELLCond.isParamTypeDirty() : !pSDELLCond.isParamTypeDirty()) {
            return null;
        }
        String string = pSDELLCond.getParamType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ParamType_Default(pSDELLCond, bl2, bl3);
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

    protected EntityFieldError onCheckField_PPSDELLCondId(boolean bl, PSDELLCond pSDELLCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELLCond.isPPSDELLCondIdDirty() : !pSDELLCond.isPPSDELLCondIdDirty()) {
            return null;
        }
        String string = pSDELLCond.getPPSDELLCondId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSDELLCondId_Default(pSDELLCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSDELLCONDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PPSDELLCondName(boolean bl, PSDELLCond pSDELLCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELLCond.isPPSDELLCondNameDirty() : !pSDELLCond.isPPSDELLCondNameDirty()) {
            return null;
        }
        String string = pSDELLCond.getPPSDELLCondName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSDELLCondName_Default(pSDELLCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSDELLCONDNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDBValueOPId(boolean bl, PSDELLCond pSDELLCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELLCond.isPSDBValueOPIdDirty() : !pSDELLCond.isPSDBValueOPIdDirty()) {
            return null;
        }
        String string = pSDELLCond.getPSDBValueOPId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDBValueOPId_Default(pSDELLCond, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDBValueOPName(boolean bl, PSDELLCond pSDELLCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELLCond.isPSDBValueOPNameDirty() : !pSDELLCond.isPSDBValueOPNameDirty()) {
            return null;
        }
        String string = pSDELLCond.getPSDBValueOPName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDBValueOPName_Default(pSDELLCond, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDELLCondId(boolean bl, PSDELLCond pSDELLCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELLCond.isPSDELLCondIdDirty() && !bl2 : !pSDELLCond.isPSDELLCondIdDirty()) {
            return null;
        }
        String string = pSDELLCond.getPSDELLCondId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDELLCONDID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDELLCondId_Default(pSDELLCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDELLCONDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDELLCondName(boolean bl, PSDELLCond pSDELLCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELLCond.isPSDELLCondNameDirty() && !bl2 : !pSDELLCond.isPSDELLCondNameDirty()) {
            return null;
        }
        String string = pSDELLCond.getPSDELLCondName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDELLCONDNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDELLCondName_Default(pSDELLCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDELLCONDNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDELogicLinkId(boolean bl, PSDELLCond pSDELLCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELLCond.isPSDELogicLinkIdDirty() : !pSDELLCond.isPSDELogicLinkIdDirty()) {
            return null;
        }
        String string = pSDELLCond.getPSDELogicLinkId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDELogicLinkId_Default(pSDELLCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDELOGICLINKID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDELogicLinkName(boolean bl, PSDELLCond pSDELLCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELLCond.isPSDELogicLinkNameDirty() : !pSDELLCond.isPSDELogicLinkNameDirty()) {
            return null;
        }
        String string = pSDELLCond.getPSDELogicLinkName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDELogicLinkName_Default(pSDELLCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDELOGICLINKNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, PSDELLCond pSDELLCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELLCond.isPSDynaInstIdDirty() : !pSDELLCond.isPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSDELLCond.getPSDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default(pSDELLCond, bl2, bl3);
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

    protected EntityFieldError onCheckField_SrcPSDLParamId(boolean bl, PSDELLCond pSDELLCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELLCond.isSrcPSDLParamIdDirty() : !pSDELLCond.isSrcPSDLParamIdDirty()) {
            return null;
        }
        String string = pSDELLCond.getSrcPSDLParamId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SrcPSDLParamId_Default(pSDELLCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SRCPSDLPARAMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SrcPSDLParamName(boolean bl, PSDELLCond pSDELLCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELLCond.isSrcPSDLParamNameDirty() : !pSDELLCond.isSrcPSDLParamNameDirty()) {
            return null;
        }
        String string = pSDELLCond.getSrcPSDLParamName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SrcPSDLParamName_Default(pSDELLCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SRCPSDLPARAMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDELLCond pSDELLCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELLCond.isUserCatDirty() : !pSDELLCond.isUserCatDirty()) {
            return null;
        }
        String string = pSDELLCond.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSDELLCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERCAT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDELLCond pSDELLCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELLCond.isUserTagDirty() : !pSDELLCond.isUserTagDirty()) {
            return null;
        }
        String string = pSDELLCond.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDELLCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDELLCond pSDELLCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELLCond.isUserTag2Dirty() : !pSDELLCond.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDELLCond.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDELLCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDELLCond pSDELLCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELLCond.isUserTag3Dirty() : !pSDELLCond.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDELLCond.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSDELLCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDELLCond pSDELLCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELLCond.isUserTag4Dirty() : !pSDELLCond.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDELLCond.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSDELLCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDELLCond pSDELLCond, boolean bl) throws Exception {
        super.onSyncEntity(pSDELLCond, bl);
    }

    protected void onSyncIndexEntities(PSDELLCond pSDELLCond, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDELLCond, bl);
    }

    public Object getDataContextValue(PSDELLCond pSDELLCond, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null && StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEFIELD", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"DSTPSDEFID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"DSTPSDEFNAME", (boolean)true) == 0) && (object = super.getDataContextValue(pSDELLCond, "dstparampsdeid", iDataContextParam)) != null) {
            return object;
        }
        object = super.getDataContextValue(pSDELLCond, string, iDataContextParam);
        if (object != null) {
            return object;
        }
        PSDELogicLink pSDELogicLink = pSDELLCond.getPSDELogicLink();
        if (pSDELogicLink != null && pSDELogicLink.contains(string)) {
            return pSDELogicLink.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDELLCond pSDELLCond, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDELLCond, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"DSTPARAMPSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstParamPSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDLPARAMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDLParamId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDLPARAMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDLParamName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PPSDELLCONDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSDELLCondId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSDELLCONDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSDELLCondName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDBVALUEOPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDBValueOPId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDBVALUEOPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDBValueOPName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDELLCONDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDELLCondId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDELLCONDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDELLCondName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDELOGICID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDElogicId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDELOGICLINKID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDELogicLinkId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDELOGICLINKNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDELogicLinkName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SRCPSDLPARAMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SrcPSDLParamId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SRCPSDLPARAMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SrcPSDLParamName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERCAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserCat_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag4_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_DstParamPSDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPARAMPSDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_DstPSDLParamId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDLPARAMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDLParamName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDLPARAMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_PPSDELLCondId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSDELLCONDID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSDELLCondName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSDELLCONDNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSDELLCondId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDELLCONDID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDELLCondName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDELLCONDNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDElogicId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDELOGICID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDELogicLinkId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDELOGICLINKID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDELogicLinkName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDELOGICLINKNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_SrcPSDLParamId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SRCPSDLPARAMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SrcPSDLParamName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SRCPSDLPARAMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_UserCat_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERCAT", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG3", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG4", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected boolean onMergeChild(String string, String string2, PSDELLCond pSDELLCond) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDELLCond)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDELLCond pSDELLCond) throws Exception {
        super.onUpdateParent(pSDELLCond);
    }

    @Override
    protected void exportCurXmlModel(PSDELLCond pSDELLCond, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDELLCOND");
        if (!bl) {
            pSDELLCond.setPPSDELLCondId(null);
            pSDELLCond.setDstParamPSDEId(null);
            pSDELLCond.setDstPSDLParamId(null);
            pSDELLCond.setSrcPSDLParamId(null);
            pSDELLCond.setPSDElogicId(null);
            pSDELLCond.setPSDELogicLinkId(null);
            pSDELLCond.setPSDELogicLinkName(null);
            super.exportCurXmlModel(pSDELLCond, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSDELLCond pSDELLCond, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSDELLCond(pSDELLCond, xmlNode);
        super.onExportRelatedXmlModel(pSDELLCond, xmlNode);
    }

    protected void exportRelatedXmlModel_PSDELLCond(PSDELLCond pSDELLCond, XmlNode xmlNode) throws Exception {
        PSDELLCondService pSDELLCondService = (PSDELLCondService)ServiceGlobal.getService(PSDELLCondService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDELLCond> arrayList = null;
        String string = pSDELLCond.getPSDELLCondId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDELLCondService.selectByPPSDELLCond(pSDELLCond, "ORDER BY ORDERVALUE ASC") : pSDELLCondService.selectTempByPPSDELLCond(pSDELLCond, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSDELLCONDS");
            xmlNode.addNode(xmlNode2);
            for (PSDELLCond pSDELLCond2 : arrayList) {
                pSDELLCond2.set("ORDERVALUE", null);
                pSDELLCondService.exportXmlModel(pSDELLCond2, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSDELLCond pSDELLCond, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSDELLCONDS");
        this.importRelatedXmlModel_PSDELLCond(pSDELLCond, xmlNode2);
        super.onImportRelatedXmlModel(pSDELLCond, xmlNode);
    }

    protected void importRelatedXmlModel_PSDELLCond(PSDELLCond pSDELLCond, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSDELLCondService pSDELLCondService = (PSDELLCondService)ServiceGlobal.getService(PSDELLCondService.class, (SessionFactory)this.getSessionFactory());
        String string = pSDELLCond.getPSDELLCondId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSDELLCondService.removeByPPSDELLCond(pSDELLCond);
        } else {
            pSDELLCondService.removeTempByPPSDELLCond(pSDELLCond);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSDELLCond pSDELLCond2 = new PSDELLCond();
                pSDELLCond2.setOrderValue(n);
                n += 100;
                pSDELLCondService.fillParentInfo(pSDELLCond2, "DER1N", "DER1N_PSDELLCOND_PSDELLCOND_PPSDELLCONDID", pSDELLCond.getPSDELLCondId());
                pSDELLCondService.importXmlModel(pSDELLCond2, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDELLCond pSDELLCond, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDELLCond, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PPSDELLCONDID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDELLCOND#%1$s", (Object)string);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDELOGICLINKID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDELOGICLINK#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PPSDELLCONDID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDELLCOND_PSDELLCOND_PPSDELLCONDID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDELOGICLINKID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDELLCOND_PSDELOGICLINK_PSDELOGICLINKID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PPSDELLCONDID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PPSDELLCONDNAME", null);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDELOGICLINKID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDELOGICLINKNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDELLCOND", (boolean)true) == 0) {
            iEntity.set("PPSDELLCONDID", (Object)string2);
            return true;
        }
        if (StringHelper.compare((String)string, (String)"PSDELOGICLINK", (boolean)true) == 0) {
            iEntity.set("PSDELOGICLINKID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PPSDELLCONDID", "PSDELOGICLINKID"};
    }

    @Override
    public String getModelV2Tag(PSDELLCond pSDELLCond) {
        return super.getModelV2Tag(pSDELLCond);
    }

    @Override
    public boolean setModelV2Tag(PSDELLCond pSDELLCond, String string) {
        return super.setModelV2Tag(pSDELLCond, string);
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PPSDELLCONDID", "");
        map.put("PSDELOGICLINKID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDELLCond pSDELLCond, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDELLCond.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDELLCond, true);
        return super.getModelV2Entity(pSDELLCond, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDELLCond pSDELLCond, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        boolean bl = false;
        if (!StringHelper.isNullOrEmpty((String)pSDELLCond.getPPSDELLCondId())) {
            bl = true;
        }
        if (!StringHelper.isNullOrEmpty((String)pSDELLCond.getPSDELogicLinkId())) {
            bl = true;
        } else if (bl && !objectNode.has("psdelogiclinkid")) {
            objectNode.put("psdelogiclinkid", "<PSDELOGICLINK>");
        }
        return super.testCompileCurModelV2(pSDELLCond, objectNode, string, string2, n);
    }

    @Override
    protected ObjectNode onFillModelV2(ObjectNode objectNode, PSDELLCond pSDELLCond, String string, Map<String, String> map) throws Exception {
        if (PSDELLCondServiceBase.isSimpleImportExportMode()) {
            map.put("PPSDELLCONDID", "");
            map.put("PSDELOGICLINKID", "");
        }
        return super.onFillModelV2(objectNode, pSDELLCond, string, map);
    }

    protected boolean isExportRelatedModelV2(String string) {
        return StringHelper.compare((String)"DER1N_PSDELLCOND_PSDELLCOND_PPSDELLCONDID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSDELLCond pSDELLCond, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSDELLCond, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSDELLCond pSDELLCond, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDELLCOND_PSDELLCOND_PPSDELLCONDID")) {
            PSDELLCondService pSDELLCondService = (PSDELLCondService)ServiceGlobal.getService(PSDELLCondService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<ObjectNode> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDELLCOND#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDELLCOND", (Object)pSDELLCond.getPSDELLCondId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty((String)line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString((String)line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSDELLCOND#%1$s", (Object)pSDELLCond.getPSDELLCondId());
                for (PSDELLCond child : pSDELLCondService.selectByPPSDELLCond(pSDELLCond)) {
                    String childScope = pSDELLCondService.getModelV2ResScope(child);
                    if (StringHelper.compare((String)scope, (String)childScope, (boolean)false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(child, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                String modelName = pSDELLCondService.getModelV2Name(false);
                ArrayNode arrayNode = objectNode.putArray(modelName.toLowerCase());
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
                        if (objectNode.has("psdellcondname")) {
                            string = objectNode.get("psdellcondname").asText();
                        }
                        if (objectNode2.has("psdellcondname")) {
                            string2 = objectNode2.get("psdellcondname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode childNode : arrayList) {
                    PSDELLCond child = new PSDELLCond();
                    PSModelV2Helper.fromJSONObject((IDataObject)child, childNode, false);
                    child.remove("ordervalue");
                    arrayNode.add((JsonNode)pSDELLCondService.exportModelV2(child, string));
                }
            }
        }
        super.onExportCurModelV2(pSDELLCond, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSDELLCond pSDELLCond) throws Exception {
        PSDELLCondService pSDELLCondService = (PSDELLCondService)ServiceGlobal.getService(PSDELLCondService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDELLCond> arrayList = pSDELLCondService.selectByPPSDELLCond(pSDELLCond);
        String string = StringHelper.format((String)"PSDELLCOND#%1$s", (Object)pSDELLCond.getPSDELLCondId());
        for (PSDELLCond pSDELLCond2 : arrayList) {
            String string2 = pSDELLCondService.getModelV2ResScope(pSDELLCond2);
            if (StringHelper.compare((String)string, (String)string2, (boolean)false) != 0) continue;
            pSDELLCondService.emptyModelV2(pSDELLCond2);
        }
        SqlParamList sqlParamList = new SqlParamList();
        sqlParamList.addString(pSDELLCond.getPSDELLCondId());
        pSDELLCondService.getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        pSDELLCondService.getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDELLCOND WHERE PPSDELLCONDID = ?", sqlParamList);
        super.onEmptyModelV2(pSDELLCond);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSDELLCondService pSDELLCondService = (PSDELLCondService)ServiceGlobal.getService(PSDELLCondService.class, (SessionFactory)this.getSessionFactory());
        if (pSDELLCondService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSDELLCond pSDELLCond, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSDELLCond pSDELLCond2 = new PSDELLCond();
        pSDELLCond2.set("PPSDELLCONDID", pSDELLCond.getPSDELLCondId());
        PSDELLCondService pSDELLCondService = (PSDELLCondService)ServiceGlobal.getService(PSDELLCondService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSDELLCondService.getModelV2Entity(pSDELLCond2, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSDELLCond, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSDELLCond pSDELLCond, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        PSDELLCondService pSDELLCondService = (PSDELLCondService)ServiceGlobal.getService(PSDELLCondService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSDELLCondService.getModelV2Name(null, false);
        int n2 = 0;
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                PSDELLCond pSDELLCond2 = new PSDELLCond();
                pSDELLCond2.setPPSDELLCondId(pSDELLCond.getPSDELLCondId());
                pSDELLCond2.setPPSDELLCondName(pSDELLCond.getPSDELLCondName());
                pSDELLCond2.setOrderValue(n2 += 10);
                pSDELLCondService.compileModelV2(pSDELLCond2, objectNode2, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File file = new File(string4);
            if (file.exists()) {
                File[] fileArray;
                for (File file2 : fileArray = file.listFiles()) {
                    if (!file2.isDirectory()) continue;
                    PSDELLCond pSDELLCond3 = new PSDELLCond();
                    pSDELLCond3.setPPSDELLCondId(pSDELLCond.getPSDELLCondId());
                    pSDELLCond3.setPPSDELLCondName(pSDELLCond.getPSDELLCondName());
                    pSDELLCondService.compileModelV2(pSDELLCond3, null, string, file2.getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSDELLCond, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSDELLCond pSDELLCond, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDELLCOND_PSDELLCOND_PPSDELLCONDID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDELLConds(pSDELLCond, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSDELLCond, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSDELLConds(PSDELLCond pSDELLCond, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDELLCOND", true), (boolean)false) == 0) {
            PSDELLCondService pSDELLCondService = (PSDELLCondService)ServiceGlobal.getService(PSDELLCondService.class, (SessionFactory)this.getSessionFactory());
            PSDELLCond pSDELLCond2 = new PSDELLCond();
            pSDELLCond2.setPSDELLCondId(pSMOSFile.getPSModelId());
            if (!pSDELLCondService.get(pSDELLCond2, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDELLCond2.getPPSDELLCondId(), (String)pSDELLCond.getPSDELLCondId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDELLCondService.exportModelV2(pSDELLCond2);
            pSDELLCond2.reset();
            if (!pSDELLCondService.setModelV2ResScope(pSDELLCond2, "PSDELLCOND", pSDELLCond.getPSDELLCondId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDELLCondService.importModelV2(pSDELLCond2, objectNode);
            SessionFactoryManager.commit();
            return pSDELLCondService.getFile(pSDELLCond2);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSDELLCond pSDELLCond, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSDELLConds(pSDELLCond, list);
        super.onFillPasteHelps(pSDELLCond, list);
    }

    protected void onFillPasteHelps_PSDELLConds(PSDELLCond pSDELLCond, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDELLCOND");
        pSHelpSection.setSectionParam2("DER1N_PSDELLCOND_PSDELLCOND_PPSDELLCONDID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5b9e\u4f53\u5904\u7406\u903b\u8f91\u8fde\u63a5\u6761\u4ef6]\u7684[\u5b9e\u4f53\u5904\u7406\u903b\u8f91\u8fde\u63a5\u6761\u4ef6]");
        list.add(pSHelpSection);
    }

    @Override
    public Object getDataType(PSDELLCond pSDELLCond) throws Exception {
        return pSDELLCond.getLogicType();
    }
}
