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
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.EntityError
 *  net.ibizsys.paas.entity.EntityFieldError
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.entity.SimpleEntity
 *  net.ibizsys.paas.service.CloneSession
 *  net.ibizsys.paas.service.IDataContextParam
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.IServicePlugin
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
package net.ibizsys.pscore.srv.helpdesign.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
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
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.SimpleEntity;
import net.ibizsys.paas.service.CloneSession;
import net.ibizsys.paas.service.IDataContextParam;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.IServicePlugin;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.config.entity.PSHelpSectionTempl;
import net.ibizsys.pscore.srv.config.entity.PSHelpSectionTemplBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIActionBase;
import net.ibizsys.pscore.srv.helpdesign.dao.PSHelpSectionDAO;
import net.ibizsys.pscore.srv.helpdesign.demodel.PSHelpSectionDEModel;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpArticle;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpArticleBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpResource;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpResourceBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSectionBase;
import net.ibizsys.pscore.srv.helpdesign.service.PSHelpSectionService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeListBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSHelpSectionServiceBase
extends PSCoreSysServiceBase<PSHelpSection> {
    private static final Log log = LogFactory.getLog(PSHelpSectionServiceBase.class);
    public static final String DATASET_CURART = "CurArt";
    public static final String DATASET_CURARTROOT = "CurArtRoot";
    public static final String DATASET_CURCHILD = "CurChild";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String DATASET_FORMTYPE = "FormType";
    public static final String DATASET_ROOT = "Root";
    public static final String DATASET_VALID = "Valid";
    public static final String DATASET_VALIDROOT = "ValidRoot";
    public static final String ACTION_BATDISABLE = "BatDisable";
    public static final String ACTION_BATENABLE = "BatEnable";
    public static final String ACTION_TOGGLEEXPAND = "ToggleExpand";
    public static final String ACTION_TOGGLEVALID = "ToggleValid";
    private PSHelpSectionDEModel pSHelpSectionDEModel;
    private PSHelpSectionDAO pSHelpSectionDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.helpdesign.service.PSHelpSectionService";
    }

    public PSHelpSectionDEModel getPSHelpSectionDEModel() {
        if (this.pSHelpSectionDEModel == null) {
            try {
                this.pSHelpSectionDEModel = (PSHelpSectionDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.helpdesign.demodel.PSHelpSectionDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSHelpSectionDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSHelpSectionDEModel();
    }

    public PSHelpSectionDAO getPSHelpSectionDAO() {
        if (this.pSHelpSectionDAO == null) {
            try {
                this.pSHelpSectionDAO = (PSHelpSectionDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.helpdesign.dao.PSHelpSectionDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSHelpSectionDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSHelpSectionDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURART, (boolean)true) == 0) {
            return this.fetchCurArt(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURARTROOT, (boolean)true) == 0) {
            return this.fetchCurArtRoot(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURCHILD, (boolean)true) == 0) {
            return this.fetchCurChild(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_FORMTYPE, (boolean)true) == 0) {
            return this.fetchFormType(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_ROOT, (boolean)true) == 0) {
            return this.fetchRoot(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_VALID, (boolean)true) == 0) {
            return this.fetchValid(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_VALIDROOT, (boolean)true) == 0) {
            return this.fetchValidRoot(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_BATDISABLE, (boolean)true) == 0) {
            this.batDisable((PSHelpSection)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_BATENABLE, (boolean)true) == 0) {
            this.batEnable((PSHelpSection)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_TOGGLEEXPAND, (boolean)true) == 0) {
            this.toggleExpand((PSHelpSection)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_TOGGLEVALID, (boolean)true) == 0) {
            this.toggleValid((PSHelpSection)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurArt(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURART, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurArtRoot(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURARTROOT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurChild(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURCHILD, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchFormType(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_FORMTYPE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchRoot(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_ROOT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchValid(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_VALID, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchValidRoot(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_VALIDROOT, false);
        return dBFetchResult;
    }

    public void batDisable(PSHelpSection pSHelpSection) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_BATDISABLE, 0, pSHelpSection, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSHelpSection, ACTION_BATDISABLE);
        final PSHelpSection pSHelpSection2 = pSHelpSection;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSHelpSectionServiceBase.this.getService(), PSHelpSectionServiceBase.ACTION_BATDISABLE, 40, pSHelpSection2, null).getResult() != 1) {
                    PSHelpSectionServiceBase.this.onBatDisable(pSHelpSection2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_BATDISABLE, 99, pSHelpSection, null);
        }
    }

    protected void onBatDisable(PSHelpSection pSHelpSection) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[BatDisable]");
    }

    public void batEnable(PSHelpSection pSHelpSection) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_BATENABLE, 0, pSHelpSection, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSHelpSection, ACTION_BATENABLE);
        final PSHelpSection pSHelpSection2 = pSHelpSection;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSHelpSectionServiceBase.this.getService(), PSHelpSectionServiceBase.ACTION_BATENABLE, 40, pSHelpSection2, null).getResult() != 1) {
                    PSHelpSectionServiceBase.this.onBatEnable(pSHelpSection2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_BATENABLE, 99, pSHelpSection, null);
        }
    }

    protected void onBatEnable(PSHelpSection pSHelpSection) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[BatEnable]");
    }

    public void toggleExpand(PSHelpSection pSHelpSection) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_TOGGLEEXPAND, 0, pSHelpSection, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSHelpSection, ACTION_TOGGLEEXPAND);
        final PSHelpSection pSHelpSection2 = pSHelpSection;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSHelpSectionServiceBase.this.getService(), PSHelpSectionServiceBase.ACTION_TOGGLEEXPAND, 40, pSHelpSection2, null).getResult() != 1) {
                    PSHelpSectionServiceBase.this.onToggleExpand(pSHelpSection2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_TOGGLEEXPAND, 99, pSHelpSection, null);
        }
    }

    protected void onToggleExpand(PSHelpSection pSHelpSection) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[ToggleExpand]");
    }

    public void toggleValid(PSHelpSection pSHelpSection) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_TOGGLEVALID, 0, pSHelpSection, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSHelpSection, ACTION_TOGGLEVALID);
        final PSHelpSection pSHelpSection2 = pSHelpSection;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSHelpSectionServiceBase.this.getService(), PSHelpSectionServiceBase.ACTION_TOGGLEVALID, 40, pSHelpSection2, null).getResult() != 1) {
                    PSHelpSectionServiceBase.this.onToggleValid(pSHelpSection2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_TOGGLEVALID, 99, pSHelpSection, null);
        }
    }

    protected void onToggleValid(PSHelpSection pSHelpSection) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[ToggleValid]");
    }

    protected void onFillParentInfo(PSHelpSection pSHelpSection, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSHELPSECTION_PSCODELIST_PSCODELISTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService", (SessionFactory)this.getSessionFactory());
            PSCodeList pSCodeList = (PSCodeList)iService.getDEModel().createEntity();
            pSCodeList.set("PSCODELISTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSCodeList);
            } else {
                iService.get(pSCodeList);
            }
            this.onFillParentInfo_PSCodeList(pSHelpSection, pSCodeList);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSHELPSECTION_PSDEFIELD_PSDEFIELDID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_PSDEField(pSHelpSection, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSHELPSECTION_PSDEUIACTION_PSDEUIACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService", (SessionFactory)this.getSessionFactory());
            PSDEUIAction pSDEUIAction = (PSDEUIAction)iService.getDEModel().createEntity();
            pSDEUIAction.set("PSDEUIACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEUIAction);
            } else {
                iService.get(pSDEUIAction);
            }
            this.onFillParentInfo_PSDEUIAction(pSHelpSection, pSDEUIAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSHELPSECTION_PSHELPARTICLE_PSHELPARTICLEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.helpdesign.service.PSHelpArticleService", (SessionFactory)this.getSessionFactory());
            PSHelpArticle pSHelpArticle = (PSHelpArticle)iService.getDEModel().createEntity();
            pSHelpArticle.set("PSHELPARTICLEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSHelpArticle);
            } else {
                iService.get(pSHelpArticle);
            }
            this.onFillParentInfo_PSHelpArticle(pSHelpSection, pSHelpArticle);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSHELPSECTION_PSHELPARTICLE_REFPSHELPARTICLEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.helpdesign.service.PSHelpArticleService", (SessionFactory)this.getSessionFactory());
            PSHelpArticle pSHelpArticle = (PSHelpArticle)iService.getDEModel().createEntity();
            pSHelpArticle.set("PSHELPARTICLEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSHelpArticle);
            } else {
                iService.get(pSHelpArticle);
            }
            this.onFillParentInfo_RefPSHelpArticle(pSHelpSection, pSHelpArticle);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSHELPSECTION_PSHELPRESOURCE_LINKPSHELPRESOURCEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.helpdesign.service.PSHelpResourceService", (SessionFactory)this.getSessionFactory());
            PSHelpResource pSHelpResource = (PSHelpResource)iService.getDEModel().createEntity();
            pSHelpResource.set("PSHELPRESOURCEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSHelpResource);
            } else {
                iService.get(pSHelpResource);
            }
            this.onFillParentInfo_LinkPSHelpResource(pSHelpSection, pSHelpResource);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSHELPSECTION_PSHELPRESOURCE_PSHELPRESOURCEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.helpdesign.service.PSHelpResourceService", (SessionFactory)this.getSessionFactory());
            PSHelpResource pSHelpResource = (PSHelpResource)iService.getDEModel().createEntity();
            pSHelpResource.set("PSHELPRESOURCEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSHelpResource);
            } else {
                iService.get(pSHelpResource);
            }
            this.onFillParentInfo_PSHelpResource(pSHelpSection, pSHelpResource);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSHELPSECTION_PSHELPSECTIONTEMPL_PSHELPSECTIONTEMPLID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSHelpSectionTemplService", (SessionFactory)this.getSessionFactory());
            PSHelpSectionTempl pSHelpSectionTempl = (PSHelpSectionTempl)iService.getDEModel().createEntity();
            pSHelpSectionTempl.set("PSHELPSECTIONTEMPLID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSHelpSectionTempl);
            } else {
                iService.get(pSHelpSectionTempl);
            }
            this.onFillParentInfo_PSHelpSectionTempl(pSHelpSection, pSHelpSectionTempl);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSHELPSECTION_PSHELPSECTION_PPSHELPSECTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.helpdesign.service.PSHelpSectionService", (SessionFactory)this.getSessionFactory());
            PSHelpSection pSHelpSection2 = (PSHelpSection)iService.getDEModel().createEntity();
            pSHelpSection2.set("PSHELPSECTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSHelpSection2);
            } else {
                iService.get(pSHelpSection2);
            }
            this.onFillParentInfo_PPSHelpSector(pSHelpSection, pSHelpSection2);
            return;
        }
        super.onFillParentInfo(pSHelpSection, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSCodeList(PSHelpSection pSHelpSection, PSCodeList pSCodeList) throws Exception {
        pSHelpSection.setPSCodeListId(pSCodeList.getPSCodeListId());
        pSHelpSection.setPSCodeListName(pSCodeList.getPSCodeListName());
    }

    protected void onFillParentInfo_PSDEField(PSHelpSection pSHelpSection, PSDEField pSDEField) throws Exception {
        pSHelpSection.setPSDEFieldId(pSDEField.getPSDEFieldId());
        pSHelpSection.setPSDEFieldName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_PSDEUIAction(PSHelpSection pSHelpSection, PSDEUIAction pSDEUIAction) throws Exception {
        pSHelpSection.setPSDEUIActionId(pSDEUIAction.getPSDEUIActionId());
        pSHelpSection.setPSDEUIActionName(pSDEUIAction.getPSDEUIActionName());
    }

    protected void onFillParentInfo_PSHelpArticle(PSHelpSection pSHelpSection, PSHelpArticle pSHelpArticle) throws Exception {
        pSHelpSection.setPSDEId(pSHelpArticle.getPSDEId());
        pSHelpSection.setPSHelpArticleId(pSHelpArticle.getPSHelpArticleId());
        pSHelpSection.setPSHelpArticleName(pSHelpArticle.getPSHelpArticleName());
    }

    protected void onFillParentInfo_RefPSHelpArticle(PSHelpSection pSHelpSection, PSHelpArticle pSHelpArticle) throws Exception {
        pSHelpSection.setRefPSHelpArticleId(pSHelpArticle.getPSHelpArticleId());
        pSHelpSection.setRefPSHelpArticleName(pSHelpArticle.getPSHelpArticleName());
    }

    protected void onFillParentInfo_LinkPSHelpResource(PSHelpSection pSHelpSection, PSHelpResource pSHelpResource) throws Exception {
        pSHelpSection.setLinkPSHelpResourceId(pSHelpResource.getPSHelpResourceId());
        pSHelpSection.setLinkPSHelpResourceName(pSHelpResource.getPSHelpResourceName());
    }

    protected void onFillParentInfo_PSHelpResource(PSHelpSection pSHelpSection, PSHelpResource pSHelpResource) throws Exception {
        pSHelpSection.setPSHelpResourceId(pSHelpResource.getPSHelpResourceId());
        pSHelpSection.setPSHelpResourceName(pSHelpResource.getPSHelpResourceName());
    }

    protected void onFillParentInfo_PSHelpSectionTempl(PSHelpSection pSHelpSection, PSHelpSectionTempl pSHelpSectionTempl) throws Exception {
        pSHelpSection.setPSHelpSectionTemplId(pSHelpSectionTempl.getPSHelpSectionTemplId());
        pSHelpSection.setPSHelpSectionTemplName(pSHelpSectionTempl.getPSHelpSectionTemplName());
    }

    protected void onFillParentInfo_PPSHelpSector(PSHelpSection pSHelpSection, PSHelpSection pSHelpSection2) throws Exception {
        pSHelpSection.setPPSHelpSectorId(pSHelpSection2.getPSHelpSectionId());
        pSHelpSection.setPPSHelpSectorName(pSHelpSection2.getPSHelpSectionName());
        if (pSHelpSection2.getPSHelpArticle() != null) {
            this.onFillParentInfo_PSHelpArticle(pSHelpSection, pSHelpSection2.getPSHelpArticle());
        }
    }

    protected void onFillEntityFullInfo(PSHelpSection pSHelpSection, boolean bl) throws Exception {
        if (bl && pSHelpSection.getValidFlag() == null) {
            pSHelpSection.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSHelpSection, bl);
        this.onFillEntityFullInfo_PSCodeList(pSHelpSection, bl);
        this.onFillEntityFullInfo_PSDEField(pSHelpSection, bl);
        this.onFillEntityFullInfo_PSDEUIAction(pSHelpSection, bl);
        this.onFillEntityFullInfo_PSHelpArticle(pSHelpSection, bl);
        this.onFillEntityFullInfo_RefPSHelpArticle(pSHelpSection, bl);
        this.onFillEntityFullInfo_LinkPSHelpResource(pSHelpSection, bl);
        this.onFillEntityFullInfo_PSHelpResource(pSHelpSection, bl);
        this.onFillEntityFullInfo_PSHelpSectionTempl(pSHelpSection, bl);
        this.onFillEntityFullInfo_PPSHelpSector(pSHelpSection, bl);
    }

    protected void onFillEntityFullInfo_PSCodeList(PSHelpSection pSHelpSection, boolean bl) throws Exception {
        if (pSHelpSection.isPSCodeListIdDirty()) {
            if (pSHelpSection.getPSCodeListId() != null) {
                if (pSHelpSection.getPSCodeListId() == null || pSHelpSection.getPSCodeListName() == null) {
                    PSCodeList pSCodeList = pSHelpSection.getPSCodeList();
                    pSHelpSection.setPSCodeListName(pSCodeList.getPSCodeListName());
                }
            } else {
                pSHelpSection.setPSCodeListName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEField(PSHelpSection pSHelpSection, boolean bl) throws Exception {
        if (pSHelpSection.isPSDEFieldIdDirty()) {
            if (pSHelpSection.getPSDEFieldId() != null) {
                if (pSHelpSection.getPSDEFieldId() == null || pSHelpSection.getPSDEFieldName() == null) {
                    PSDEField pSDEField = pSHelpSection.getPSDEField();
                    pSHelpSection.setPSDEFieldName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSHelpSection.setPSDEFieldName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEUIAction(PSHelpSection pSHelpSection, boolean bl) throws Exception {
        if (pSHelpSection.isPSDEUIActionIdDirty()) {
            if (pSHelpSection.getPSDEUIActionId() != null) {
                if (pSHelpSection.getPSDEUIActionId() == null || pSHelpSection.getPSDEUIActionName() == null) {
                    PSDEUIAction pSDEUIAction = pSHelpSection.getPSDEUIAction();
                    pSHelpSection.setPSDEUIActionName(pSDEUIAction.getPSDEUIActionName());
                }
            } else {
                pSHelpSection.setPSDEUIActionName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSHelpArticle(PSHelpSection pSHelpSection, boolean bl) throws Exception {
        if (pSHelpSection.isPSHelpArticleIdDirty()) {
            if (pSHelpSection.getPSHelpArticleId() != null) {
                if (pSHelpSection.getPSHelpArticleId() == null || pSHelpSection.getPSHelpArticleName() == null) {
                    PSHelpArticle pSHelpArticle = pSHelpSection.getPSHelpArticle();
                    pSHelpSection.setPSDEId(pSHelpArticle.getPSDEId());
                    pSHelpSection.setPSHelpArticleName(pSHelpArticle.getPSHelpArticleName());
                }
            } else {
                pSHelpSection.setPSDEId(null);
                pSHelpSection.setPSHelpArticleName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_RefPSHelpArticle(PSHelpSection pSHelpSection, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_LinkPSHelpResource(PSHelpSection pSHelpSection, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSHelpResource(PSHelpSection pSHelpSection, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSHelpSectionTempl(PSHelpSection pSHelpSection, boolean bl) throws Exception {
        if (pSHelpSection.isPSHelpSectionTemplIdDirty()) {
            if (pSHelpSection.getPSHelpSectionTemplId() != null) {
                if (pSHelpSection.getPSHelpSectionTemplId() == null || pSHelpSection.getPSHelpSectionTemplName() == null) {
                    PSHelpSectionTempl pSHelpSectionTempl = pSHelpSection.getPSHelpSectionTempl();
                    pSHelpSection.setPSHelpSectionTemplName(pSHelpSectionTempl.getPSHelpSectionTemplName());
                }
            } else {
                pSHelpSection.setPSHelpSectionTemplName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PPSHelpSector(PSHelpSection pSHelpSection, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSHelpSection pSHelpSection, boolean bl) throws Exception {
        super.onWriteBackParent(pSHelpSection, bl);
    }

    public ArrayList<PSHelpSection> selectByPSCodeList(PSCodeListBase pSCodeListBase) throws Exception {
        return this.selectByPSCodeList(pSCodeListBase, "", -1);
    }

    public ArrayList<PSHelpSection> selectByPSCodeList(PSCodeListBase pSCodeListBase, String string) throws Exception {
        return this.selectByPSCodeList(pSCodeListBase, string, -1);
    }

    public ArrayList<PSHelpSection> selectByPSCodeList(PSCodeListBase pSCodeListBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSCODELISTID", (Object)pSCodeListBase.getPSCodeListId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSCodeListCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSCodeListCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSHelpSection> selectByPSDEField(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByPSDEField(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSHelpSection> selectByPSDEField(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByPSDEField(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSHelpSection> selectByPSDEField(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEFIELDID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEFieldCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEFieldCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSHelpSection> selectByPSDEUIAction(PSDEUIActionBase pSDEUIActionBase) throws Exception {
        return this.selectByPSDEUIAction(pSDEUIActionBase, "", -1);
    }

    public ArrayList<PSHelpSection> selectByPSDEUIAction(PSDEUIActionBase pSDEUIActionBase, String string) throws Exception {
        return this.selectByPSDEUIAction(pSDEUIActionBase, string, -1);
    }

    public ArrayList<PSHelpSection> selectByPSDEUIAction(PSDEUIActionBase pSDEUIActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEUIACTIONID", (Object)pSDEUIActionBase.getPSDEUIActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEUIActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEUIActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSHelpSection> selectByPSHelpArticle(PSHelpArticleBase pSHelpArticleBase) throws Exception {
        return this.selectByPSHelpArticle(pSHelpArticleBase, "", -1);
    }

    public ArrayList<PSHelpSection> selectByPSHelpArticle(PSHelpArticleBase pSHelpArticleBase, String string) throws Exception {
        return this.selectByPSHelpArticle(pSHelpArticleBase, string, -1);
    }

    public ArrayList<PSHelpSection> selectByPSHelpArticle(PSHelpArticleBase pSHelpArticleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSHELPARTICLEID", (Object)pSHelpArticleBase.getPSHelpArticleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSHelpArticleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSHelpArticleCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSHelpSection> selectByRefPSHelpArticle(PSHelpArticleBase pSHelpArticleBase) throws Exception {
        return this.selectByRefPSHelpArticle(pSHelpArticleBase, "", -1);
    }

    public ArrayList<PSHelpSection> selectByRefPSHelpArticle(PSHelpArticleBase pSHelpArticleBase, String string) throws Exception {
        return this.selectByRefPSHelpArticle(pSHelpArticleBase, string, -1);
    }

    public ArrayList<PSHelpSection> selectByRefPSHelpArticle(PSHelpArticleBase pSHelpArticleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("REFPSHELPARTICLEID", (Object)pSHelpArticleBase.getPSHelpArticleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRefPSHelpArticleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRefPSHelpArticleCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSHelpSection> selectByLinkPSHelpResource(PSHelpResourceBase pSHelpResourceBase) throws Exception {
        return this.selectByLinkPSHelpResource(pSHelpResourceBase, "", -1);
    }

    public ArrayList<PSHelpSection> selectByLinkPSHelpResource(PSHelpResourceBase pSHelpResourceBase, String string) throws Exception {
        return this.selectByLinkPSHelpResource(pSHelpResourceBase, string, -1);
    }

    public ArrayList<PSHelpSection> selectByLinkPSHelpResource(PSHelpResourceBase pSHelpResourceBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("LINKPSHELPRESOURCEID", (Object)pSHelpResourceBase.getPSHelpResourceId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByLinkPSHelpResourceCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByLinkPSHelpResourceCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSHelpSection> selectByPSHelpResource(PSHelpResourceBase pSHelpResourceBase) throws Exception {
        return this.selectByPSHelpResource(pSHelpResourceBase, "", -1);
    }

    public ArrayList<PSHelpSection> selectByPSHelpResource(PSHelpResourceBase pSHelpResourceBase, String string) throws Exception {
        return this.selectByPSHelpResource(pSHelpResourceBase, string, -1);
    }

    public ArrayList<PSHelpSection> selectByPSHelpResource(PSHelpResourceBase pSHelpResourceBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSHELPRESOURCEID", (Object)pSHelpResourceBase.getPSHelpResourceId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSHelpResourceCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSHelpResourceCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSHelpSection> selectByPSHelpSectionTempl(PSHelpSectionTemplBase pSHelpSectionTemplBase) throws Exception {
        return this.selectByPSHelpSectionTempl(pSHelpSectionTemplBase, "", -1);
    }

    public ArrayList<PSHelpSection> selectByPSHelpSectionTempl(PSHelpSectionTemplBase pSHelpSectionTemplBase, String string) throws Exception {
        return this.selectByPSHelpSectionTempl(pSHelpSectionTemplBase, string, -1);
    }

    public ArrayList<PSHelpSection> selectByPSHelpSectionTempl(PSHelpSectionTemplBase pSHelpSectionTemplBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSHELPSECTIONTEMPLID", (Object)pSHelpSectionTemplBase.getPSHelpSectionTemplId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSHelpSectionTemplCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSHelpSectionTemplCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSHelpSection> selectByPPSHelpSector(PSHelpSectionBase pSHelpSectionBase) throws Exception {
        return this.selectByPPSHelpSector(pSHelpSectionBase, "", -1);
    }

    public ArrayList<PSHelpSection> selectByPPSHelpSector(PSHelpSectionBase pSHelpSectionBase, String string) throws Exception {
        return this.selectByPPSHelpSector(pSHelpSectionBase, string, -1);
    }

    public ArrayList<PSHelpSection> selectByPPSHelpSector(PSHelpSectionBase pSHelpSectionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSHELPSECTIONID", (Object)pSHelpSectionBase.getPSHelpSectionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPPSHelpSectorCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPPSHelpSectorCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
    }

    public void resetPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSHelpSection> arrayList = this.selectByPSCodeList(pSCodeList);
        for (PSHelpSection pSHelpSection : arrayList) {
            PSHelpSection pSHelpSection2 = (PSHelpSection)this.getDEModel().createEntity();
            pSHelpSection2.setPSHelpSectionId(pSHelpSection.getPSHelpSectionId());
            pSHelpSection2.setPSCodeListId(null);
            this.update(pSHelpSection2);
        }
    }

    public void removeByPSCodeList(PSCodeList pSCodeList) throws Exception {
        final PSCodeList pSCodeList2 = pSCodeList;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSHelpSectionServiceBase.this.onBeforeRemoveByPSCodeList(pSCodeList2);
                PSHelpSectionServiceBase.this.internalRemoveByPSCodeList(pSCodeList2);
                PSHelpSectionServiceBase.this.onAfterRemoveByPSCodeList(pSCodeList2);
            }
        });
    }

    protected void onBeforeRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void internalRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSHelpSection> arrayList = this.selectByPSCodeList(pSCodeList);
        this.onBeforeRemoveByPSCodeList(pSCodeList, arrayList);
        for (PSHelpSection pSHelpSection : arrayList) {
            this.remove(pSHelpSection);
        }
        this.onAfterRemoveByPSCodeList(pSCodeList, arrayList);
    }

    protected void onAfterRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void onBeforeRemoveByPSCodeList(PSCodeList pSCodeList, ArrayList<PSHelpSection> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCodeList(PSCodeList pSCodeList, ArrayList<PSHelpSection> arrayList) throws Exception {
    }

    public void testRemoveByPSDEField(PSDEField pSDEField) throws Exception {
    }

    public void resetPSDEField(PSDEField pSDEField) throws Exception {
        ArrayList<PSHelpSection> arrayList = this.selectByPSDEField(pSDEField);
        for (PSHelpSection pSHelpSection : arrayList) {
            PSHelpSection pSHelpSection2 = (PSHelpSection)this.getDEModel().createEntity();
            pSHelpSection2.setPSHelpSectionId(pSHelpSection.getPSHelpSectionId());
            pSHelpSection2.setPSDEFieldId(null);
            this.update(pSHelpSection2);
        }
    }

    public void removeByPSDEField(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSHelpSectionServiceBase.this.onBeforeRemoveByPSDEField(pSDEField2);
                PSHelpSectionServiceBase.this.internalRemoveByPSDEField(pSDEField2);
                PSHelpSectionServiceBase.this.onAfterRemoveByPSDEField(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEField(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByPSDEField(PSDEField pSDEField) throws Exception {
        ArrayList<PSHelpSection> arrayList = this.selectByPSDEField(pSDEField);
        this.onBeforeRemoveByPSDEField(pSDEField, arrayList);
        for (PSHelpSection pSHelpSection : arrayList) {
            this.remove(pSHelpSection);
        }
        this.onAfterRemoveByPSDEField(pSDEField, arrayList);
    }

    protected void onAfterRemoveByPSDEField(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByPSDEField(PSDEField pSDEField, ArrayList<PSHelpSection> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEField(PSDEField pSDEField, ArrayList<PSHelpSection> arrayList) throws Exception {
    }

    public void testRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
    }

    public void resetPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        ArrayList<PSHelpSection> arrayList = this.selectByPSDEUIAction(pSDEUIAction);
        for (PSHelpSection pSHelpSection : arrayList) {
            PSHelpSection pSHelpSection2 = (PSHelpSection)this.getDEModel().createEntity();
            pSHelpSection2.setPSHelpSectionId(pSHelpSection.getPSHelpSectionId());
            pSHelpSection2.setPSDEUIActionId(null);
            this.update(pSHelpSection2);
        }
    }

    public void removeByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        final PSDEUIAction pSDEUIAction2 = pSDEUIAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSHelpSectionServiceBase.this.onBeforeRemoveByPSDEUIAction(pSDEUIAction2);
                PSHelpSectionServiceBase.this.internalRemoveByPSDEUIAction(pSDEUIAction2);
                PSHelpSectionServiceBase.this.onAfterRemoveByPSDEUIAction(pSDEUIAction2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
    }

    protected void internalRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        ArrayList<PSHelpSection> arrayList = this.selectByPSDEUIAction(pSDEUIAction);
        this.onBeforeRemoveByPSDEUIAction(pSDEUIAction, arrayList);
        for (PSHelpSection pSHelpSection : arrayList) {
            this.remove(pSHelpSection);
        }
        this.onAfterRemoveByPSDEUIAction(pSDEUIAction, arrayList);
    }

    protected void onAfterRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
    }

    protected void onBeforeRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction, ArrayList<PSHelpSection> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction, ArrayList<PSHelpSection> arrayList) throws Exception {
    }

    public void testRemoveByPSHelpArticle(PSHelpArticle pSHelpArticle) throws Exception {
    }

    public void resetPSHelpArticle(PSHelpArticle pSHelpArticle) throws Exception {
        ArrayList<PSHelpSection> arrayList = this.selectByPSHelpArticle(pSHelpArticle);
        for (PSHelpSection pSHelpSection : arrayList) {
            PSHelpSection pSHelpSection2 = (PSHelpSection)this.getDEModel().createEntity();
            pSHelpSection2.setPSHelpSectionId(pSHelpSection.getPSHelpSectionId());
            pSHelpSection2.setPSHelpArticleId(null);
            this.update(pSHelpSection2);
        }
    }

    public void removeByPSHelpArticle(PSHelpArticle pSHelpArticle) throws Exception {
        final PSHelpArticle pSHelpArticle2 = pSHelpArticle;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSHelpSectionServiceBase.this.onBeforeRemoveByPSHelpArticle(pSHelpArticle2);
                PSHelpSectionServiceBase.this.internalRemoveByPSHelpArticle(pSHelpArticle2);
                PSHelpSectionServiceBase.this.onAfterRemoveByPSHelpArticle(pSHelpArticle2);
            }
        });
    }

    protected void onBeforeRemoveByPSHelpArticle(PSHelpArticle pSHelpArticle) throws Exception {
    }

    protected void internalRemoveByPSHelpArticle(PSHelpArticle pSHelpArticle) throws Exception {
        ArrayList<PSHelpSection> arrayList = this.selectByPSHelpArticle(pSHelpArticle);
        this.onBeforeRemoveByPSHelpArticle(pSHelpArticle, arrayList);
        for (PSHelpSection pSHelpSection : arrayList) {
            this.remove(pSHelpSection);
        }
        this.onAfterRemoveByPSHelpArticle(pSHelpArticle, arrayList);
    }

    protected void onAfterRemoveByPSHelpArticle(PSHelpArticle pSHelpArticle) throws Exception {
    }

    protected void onBeforeRemoveByPSHelpArticle(PSHelpArticle pSHelpArticle, ArrayList<PSHelpSection> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSHelpArticle(PSHelpArticle pSHelpArticle, ArrayList<PSHelpSection> arrayList) throws Exception {
    }

    public void testRemoveByRefPSHelpArticle(PSHelpArticle pSHelpArticle) throws Exception {
        ArrayList<PSHelpSection> arrayList = this.selectByRefPSHelpArticle(pSHelpArticle, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSHELPARTICLE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSHelpArticle);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSHELPSECTION_PSHELPARTICLE_REFPSHELPARTICLEID", "", iDataEntityModel.getName(), "PSHELPSECTION", iDataEntityModel.getDataInfo(pSHelpArticle), arrayList.get(0)));
        }
    }

    public void resetRefPSHelpArticle(PSHelpArticle pSHelpArticle) throws Exception {
        ArrayList<PSHelpSection> arrayList = this.selectByRefPSHelpArticle(pSHelpArticle);
        for (PSHelpSection pSHelpSection : arrayList) {
            PSHelpSection pSHelpSection2 = (PSHelpSection)this.getDEModel().createEntity();
            pSHelpSection2.setPSHelpSectionId(pSHelpSection.getPSHelpSectionId());
            pSHelpSection2.setRefPSHelpArticleId(null);
            this.update(pSHelpSection2);
        }
    }

    public void removeByRefPSHelpArticle(PSHelpArticle pSHelpArticle) throws Exception {
        final PSHelpArticle pSHelpArticle2 = pSHelpArticle;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSHelpSectionServiceBase.this.onBeforeRemoveByRefPSHelpArticle(pSHelpArticle2);
                PSHelpSectionServiceBase.this.internalRemoveByRefPSHelpArticle(pSHelpArticle2);
                PSHelpSectionServiceBase.this.onAfterRemoveByRefPSHelpArticle(pSHelpArticle2);
            }
        });
    }

    protected void onBeforeRemoveByRefPSHelpArticle(PSHelpArticle pSHelpArticle) throws Exception {
    }

    protected void internalRemoveByRefPSHelpArticle(PSHelpArticle pSHelpArticle) throws Exception {
        ArrayList<PSHelpSection> arrayList = this.selectByRefPSHelpArticle(pSHelpArticle);
        this.onBeforeRemoveByRefPSHelpArticle(pSHelpArticle, arrayList);
        for (PSHelpSection pSHelpSection : arrayList) {
            this.remove(pSHelpSection);
        }
        this.onAfterRemoveByRefPSHelpArticle(pSHelpArticle, arrayList);
    }

    protected void onAfterRemoveByRefPSHelpArticle(PSHelpArticle pSHelpArticle) throws Exception {
    }

    protected void onBeforeRemoveByRefPSHelpArticle(PSHelpArticle pSHelpArticle, ArrayList<PSHelpSection> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRefPSHelpArticle(PSHelpArticle pSHelpArticle, ArrayList<PSHelpSection> arrayList) throws Exception {
    }

    public void testRemoveByLinkPSHelpResource(PSHelpResource pSHelpResource) throws Exception {
        ArrayList<PSHelpSection> arrayList = this.selectByLinkPSHelpResource(pSHelpResource, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSHELPRESOURCE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSHelpResource);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSHELPSECTION_PSHELPRESOURCE_LINKPSHELPRESOURCEID", "", iDataEntityModel.getName(), "PSHELPSECTION", iDataEntityModel.getDataInfo(pSHelpResource), arrayList.get(0)));
        }
    }

    public void resetLinkPSHelpResource(PSHelpResource pSHelpResource) throws Exception {
        ArrayList<PSHelpSection> arrayList = this.selectByLinkPSHelpResource(pSHelpResource);
        for (PSHelpSection pSHelpSection : arrayList) {
            PSHelpSection pSHelpSection2 = (PSHelpSection)this.getDEModel().createEntity();
            pSHelpSection2.setPSHelpSectionId(pSHelpSection.getPSHelpSectionId());
            pSHelpSection2.setLinkPSHelpResourceId(null);
            this.update(pSHelpSection2);
        }
    }

    public void removeByLinkPSHelpResource(PSHelpResource pSHelpResource) throws Exception {
        final PSHelpResource pSHelpResource2 = pSHelpResource;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSHelpSectionServiceBase.this.onBeforeRemoveByLinkPSHelpResource(pSHelpResource2);
                PSHelpSectionServiceBase.this.internalRemoveByLinkPSHelpResource(pSHelpResource2);
                PSHelpSectionServiceBase.this.onAfterRemoveByLinkPSHelpResource(pSHelpResource2);
            }
        });
    }

    protected void onBeforeRemoveByLinkPSHelpResource(PSHelpResource pSHelpResource) throws Exception {
    }

    protected void internalRemoveByLinkPSHelpResource(PSHelpResource pSHelpResource) throws Exception {
        ArrayList<PSHelpSection> arrayList = this.selectByLinkPSHelpResource(pSHelpResource);
        this.onBeforeRemoveByLinkPSHelpResource(pSHelpResource, arrayList);
        for (PSHelpSection pSHelpSection : arrayList) {
            this.remove(pSHelpSection);
        }
        this.onAfterRemoveByLinkPSHelpResource(pSHelpResource, arrayList);
    }

    protected void onAfterRemoveByLinkPSHelpResource(PSHelpResource pSHelpResource) throws Exception {
    }

    protected void onBeforeRemoveByLinkPSHelpResource(PSHelpResource pSHelpResource, ArrayList<PSHelpSection> arrayList) throws Exception {
    }

    protected void onAfterRemoveByLinkPSHelpResource(PSHelpResource pSHelpResource, ArrayList<PSHelpSection> arrayList) throws Exception {
    }

    public void testRemoveByPSHelpResource(PSHelpResource pSHelpResource) throws Exception {
        ArrayList<PSHelpSection> arrayList = this.selectByPSHelpResource(pSHelpResource, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSHELPRESOURCE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSHelpResource);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSHELPSECTION_PSHELPRESOURCE_PSHELPRESOURCEID", "", iDataEntityModel.getName(), "PSHELPSECTION", iDataEntityModel.getDataInfo(pSHelpResource), arrayList.get(0)));
        }
    }

    public void resetPSHelpResource(PSHelpResource pSHelpResource) throws Exception {
        ArrayList<PSHelpSection> arrayList = this.selectByPSHelpResource(pSHelpResource);
        for (PSHelpSection pSHelpSection : arrayList) {
            PSHelpSection pSHelpSection2 = (PSHelpSection)this.getDEModel().createEntity();
            pSHelpSection2.setPSHelpSectionId(pSHelpSection.getPSHelpSectionId());
            pSHelpSection2.setPSHelpResourceId(null);
            this.update(pSHelpSection2);
        }
    }

    public void removeByPSHelpResource(PSHelpResource pSHelpResource) throws Exception {
        final PSHelpResource pSHelpResource2 = pSHelpResource;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSHelpSectionServiceBase.this.onBeforeRemoveByPSHelpResource(pSHelpResource2);
                PSHelpSectionServiceBase.this.internalRemoveByPSHelpResource(pSHelpResource2);
                PSHelpSectionServiceBase.this.onAfterRemoveByPSHelpResource(pSHelpResource2);
            }
        });
    }

    protected void onBeforeRemoveByPSHelpResource(PSHelpResource pSHelpResource) throws Exception {
    }

    protected void internalRemoveByPSHelpResource(PSHelpResource pSHelpResource) throws Exception {
        ArrayList<PSHelpSection> arrayList = this.selectByPSHelpResource(pSHelpResource);
        this.onBeforeRemoveByPSHelpResource(pSHelpResource, arrayList);
        for (PSHelpSection pSHelpSection : arrayList) {
            this.remove(pSHelpSection);
        }
        this.onAfterRemoveByPSHelpResource(pSHelpResource, arrayList);
    }

    protected void onAfterRemoveByPSHelpResource(PSHelpResource pSHelpResource) throws Exception {
    }

    protected void onBeforeRemoveByPSHelpResource(PSHelpResource pSHelpResource, ArrayList<PSHelpSection> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSHelpResource(PSHelpResource pSHelpResource, ArrayList<PSHelpSection> arrayList) throws Exception {
    }

    public void testRemoveByPSHelpSectionTempl(PSHelpSectionTempl pSHelpSectionTempl) throws Exception {
        ArrayList<PSHelpSection> arrayList = this.selectByPSHelpSectionTempl(pSHelpSectionTempl, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSHELPSECTIONTEMPL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSHelpSectionTempl);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSHELPSECTION_PSHELPSECTIONTEMPL_PSHELPSECTIONTEMPLID", "", iDataEntityModel.getName(), "PSHELPSECTION", iDataEntityModel.getDataInfo(pSHelpSectionTempl), arrayList.get(0)));
        }
    }

    public void resetPSHelpSectionTempl(PSHelpSectionTempl pSHelpSectionTempl) throws Exception {
        ArrayList<PSHelpSection> arrayList = this.selectByPSHelpSectionTempl(pSHelpSectionTempl);
        for (PSHelpSection pSHelpSection : arrayList) {
            PSHelpSection pSHelpSection2 = (PSHelpSection)this.getDEModel().createEntity();
            pSHelpSection2.setPSHelpSectionId(pSHelpSection.getPSHelpSectionId());
            pSHelpSection2.setPSHelpSectionTemplId(null);
            this.update(pSHelpSection2);
        }
    }

    public void removeByPSHelpSectionTempl(PSHelpSectionTempl pSHelpSectionTempl) throws Exception {
        final PSHelpSectionTempl pSHelpSectionTempl2 = pSHelpSectionTempl;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSHelpSectionServiceBase.this.onBeforeRemoveByPSHelpSectionTempl(pSHelpSectionTempl2);
                PSHelpSectionServiceBase.this.internalRemoveByPSHelpSectionTempl(pSHelpSectionTempl2);
                PSHelpSectionServiceBase.this.onAfterRemoveByPSHelpSectionTempl(pSHelpSectionTempl2);
            }
        });
    }

    protected void onBeforeRemoveByPSHelpSectionTempl(PSHelpSectionTempl pSHelpSectionTempl) throws Exception {
    }

    protected void internalRemoveByPSHelpSectionTempl(PSHelpSectionTempl pSHelpSectionTempl) throws Exception {
        ArrayList<PSHelpSection> arrayList = this.selectByPSHelpSectionTempl(pSHelpSectionTempl);
        this.onBeforeRemoveByPSHelpSectionTempl(pSHelpSectionTempl, arrayList);
        for (PSHelpSection pSHelpSection : arrayList) {
            this.remove(pSHelpSection);
        }
        this.onAfterRemoveByPSHelpSectionTempl(pSHelpSectionTempl, arrayList);
    }

    protected void onAfterRemoveByPSHelpSectionTempl(PSHelpSectionTempl pSHelpSectionTempl) throws Exception {
    }

    protected void onBeforeRemoveByPSHelpSectionTempl(PSHelpSectionTempl pSHelpSectionTempl, ArrayList<PSHelpSection> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSHelpSectionTempl(PSHelpSectionTempl pSHelpSectionTempl, ArrayList<PSHelpSection> arrayList) throws Exception {
    }

    public void testRemoveByPPSHelpSector(PSHelpSection pSHelpSection) throws Exception {
    }

    public void resetPPSHelpSector(PSHelpSection pSHelpSection) throws Exception {
        ArrayList<PSHelpSection> arrayList = this.selectByPPSHelpSector(pSHelpSection);
        for (PSHelpSection pSHelpSection2 : arrayList) {
            PSHelpSection pSHelpSection3 = (PSHelpSection)this.getDEModel().createEntity();
            pSHelpSection3.setPSHelpSectionId(pSHelpSection2.getPSHelpSectionId());
            pSHelpSection3.setPPSHelpSectorId(null);
            this.update(pSHelpSection3);
        }
    }

    public void removeByPPSHelpSector(PSHelpSection pSHelpSection) throws Exception {
        final PSHelpSection pSHelpSection2 = pSHelpSection;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSHelpSectionServiceBase.this.onBeforeRemoveByPPSHelpSector(pSHelpSection2);
                PSHelpSectionServiceBase.this.internalRemoveByPPSHelpSector(pSHelpSection2);
                PSHelpSectionServiceBase.this.onAfterRemoveByPPSHelpSector(pSHelpSection2);
            }
        });
    }

    protected void onBeforeRemoveByPPSHelpSector(PSHelpSection pSHelpSection) throws Exception {
    }

    protected void internalRemoveByPPSHelpSector(PSHelpSection pSHelpSection) throws Exception {
        ArrayList<PSHelpSection> arrayList = this.selectByPPSHelpSector(pSHelpSection);
        this.onBeforeRemoveByPPSHelpSector(pSHelpSection, arrayList);
        for (PSHelpSection pSHelpSection2 : arrayList) {
            this.remove(pSHelpSection2);
        }
        this.onAfterRemoveByPPSHelpSector(pSHelpSection, arrayList);
    }

    protected void onAfterRemoveByPPSHelpSector(PSHelpSection pSHelpSection) throws Exception {
    }

    protected void onBeforeRemoveByPPSHelpSector(PSHelpSection pSHelpSection, ArrayList<PSHelpSection> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPPSHelpSector(PSHelpSection pSHelpSection, ArrayList<PSHelpSection> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSHelpSection pSHelpSection) throws Exception {
        PSHelpSectionService pSHelpSectionService = (PSHelpSectionService)ServiceGlobal.getService(PSHelpSectionService.class, (SessionFactory)this.getSessionFactory());
        pSHelpSectionService.testRemoveByPPSHelpSector(pSHelpSection);
        pSHelpSectionService.removeByPPSHelpSector(pSHelpSection);
        super.onBeforeRemove(pSHelpSection);
    }

    protected void replaceParentInfo(PSHelpSection pSHelpSection, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSHelpSection, cloneSession);
        if (pSHelpSection.getPSCodeListId() != null && (iEntity = cloneSession.getEntity("PSCODELIST", (Object)pSHelpSection.getPSCodeListId())) != null) {
            this.onFillParentInfo_PSCodeList(pSHelpSection, (PSCodeList)iEntity);
        }
        if (pSHelpSection.getPSDEFieldId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSHelpSection.getPSDEFieldId())) != null) {
            this.onFillParentInfo_PSDEField(pSHelpSection, (PSDEField)iEntity);
        }
        if (pSHelpSection.getPSDEUIActionId() != null && (iEntity = cloneSession.getEntity("PSDEUIACTION", (Object)pSHelpSection.getPSDEUIActionId())) != null) {
            this.onFillParentInfo_PSDEUIAction(pSHelpSection, (PSDEUIAction)iEntity);
        }
        if (pSHelpSection.getPSHelpArticleId() != null && (iEntity = cloneSession.getEntity("PSHELPARTICLE", (Object)pSHelpSection.getPSHelpArticleId())) != null) {
            this.onFillParentInfo_PSHelpArticle(pSHelpSection, (PSHelpArticle)iEntity);
        }
        if (pSHelpSection.getRefPSHelpArticleId() != null && (iEntity = cloneSession.getEntity("PSHELPARTICLE", (Object)pSHelpSection.getRefPSHelpArticleId())) != null) {
            this.onFillParentInfo_RefPSHelpArticle(pSHelpSection, (PSHelpArticle)iEntity);
        }
        if (pSHelpSection.getLinkPSHelpResourceId() != null && (iEntity = cloneSession.getEntity("PSHELPRESOURCE", (Object)pSHelpSection.getLinkPSHelpResourceId())) != null) {
            this.onFillParentInfo_LinkPSHelpResource(pSHelpSection, (PSHelpResource)iEntity);
        }
        if (pSHelpSection.getPSHelpResourceId() != null && (iEntity = cloneSession.getEntity("PSHELPRESOURCE", (Object)pSHelpSection.getPSHelpResourceId())) != null) {
            this.onFillParentInfo_PSHelpResource(pSHelpSection, (PSHelpResource)iEntity);
        }
        if (pSHelpSection.getPSHelpSectionTemplId() != null && (iEntity = cloneSession.getEntity("PSHELPSECTIONTEMPL", (Object)pSHelpSection.getPSHelpSectionTemplId())) != null) {
            this.onFillParentInfo_PSHelpSectionTempl(pSHelpSection, (PSHelpSectionTempl)iEntity);
        }
        if (pSHelpSection.getPPSHelpSectorId() != null && (iEntity = cloneSession.getEntity("PSHELPSECTION", (Object)pSHelpSection.getPPSHelpSectorId())) != null) {
            this.onFillParentInfo_PPSHelpSector(pSHelpSection, (PSHelpSection)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSHelpSection pSHelpSection, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSHelpSection, bl);
    }

    protected void onCheckEntity(boolean bl, PSHelpSection pSHelpSection, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_BottomContent(bl, pSHelpSection, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSHelpSection, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Content(bl, pSHelpSection, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Content2(bl, pSHelpSection, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ContentAsCode(bl, pSHelpSection, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExpandMode(bl, pSHelpSection, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HeaderContent(bl, pSHelpSection, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LinkPSHelpResourceId(bl, pSHelpSection, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSHelpSection, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSHelpSection, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OutputDir(bl, pSHelpSection, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSHelpSectorId(bl, pSHelpSection, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCodeListId(bl, pSHelpSection, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCodeListName(bl, pSHelpSection, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFieldId(bl, pSHelpSection, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFieldName(bl, pSHelpSection, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEUIActionId(bl, pSHelpSection, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEUIActionName(bl, pSHelpSection, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSHelpArticleId(bl, pSHelpSection, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSHelpArticleName(bl, pSHelpSection, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSHelpResourceId(bl, pSHelpSection, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSHelpSectionId(bl, pSHelpSection, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSHelpSectionName(bl, pSHelpSection, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSHelpSectionTemplId(bl, pSHelpSection, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSHelpSectionTemplName(bl, pSHelpSection, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSHelpArticleId(bl, pSHelpSection, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SectionParam(bl, pSHelpSection, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SectionParam2(bl, pSHelpSection, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SectionSN(bl, pSHelpSection, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SectionType(bl, pSHelpSection, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSHelpSection, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSHelpSection, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSHelpSection, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSHelpSection, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSHelpSection, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSHelpSection, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSHelpSection, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_BottomContent(boolean bl, PSHelpSection pSHelpSection, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpSection.isBottomContentDirty() : !pSHelpSection.isBottomContentDirty()) {
            return null;
        }
        String string = pSHelpSection.getBottomContent();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BottomContent_Default(pSHelpSection, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BOTTOMCONTENT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSHelpSection pSHelpSection, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpSection.isCodeNameDirty() : !pSHelpSection.isCodeNameDirty()) {
            return null;
        }
        String string = pSHelpSection.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSHelpSection, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (string == null) {
                bl4 = false;
            }
            if (bl4) {
                String string3 = "";
                string3 = "PSHELPARTICLEID";
                String string4 = this.checkFieldDupRule(this.getPSHelpSectionDEModel(), "CODENAME", string3, pSHelpSection, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("CODENAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Content(boolean bl, PSHelpSection pSHelpSection, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpSection.isContentDirty() : !pSHelpSection.isContentDirty()) {
            return null;
        }
        String string = pSHelpSection.getContent();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Content_Default(pSHelpSection, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONTENT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Content2(boolean bl, PSHelpSection pSHelpSection, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpSection.isContent2Dirty() : !pSHelpSection.isContent2Dirty()) {
            return null;
        }
        String string = pSHelpSection.getContent2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Content2_Default(pSHelpSection, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONTENT2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ContentAsCode(boolean bl, PSHelpSection pSHelpSection, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpSection.isContentAsCodeDirty() : !pSHelpSection.isContentAsCodeDirty()) {
            return null;
        }
        Integer n = pSHelpSection.getContentAsCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ContentAsCode_Default(pSHelpSection, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONTENTASCODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExpandMode(boolean bl, PSHelpSection pSHelpSection, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpSection.isExpandModeDirty() : !pSHelpSection.isExpandModeDirty()) {
            return null;
        }
        Integer n = pSHelpSection.getExpandMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ExpandMode_Default(pSHelpSection, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXPANDMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HeaderContent(boolean bl, PSHelpSection pSHelpSection, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpSection.isHeaderContentDirty() : !pSHelpSection.isHeaderContentDirty()) {
            return null;
        }
        String string = pSHelpSection.getHeaderContent();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HeaderContent_Default(pSHelpSection, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HEADERCONTENT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LinkPSHelpResourceId(boolean bl, PSHelpSection pSHelpSection, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpSection.isLinkPSHelpResourceIdDirty() : !pSHelpSection.isLinkPSHelpResourceIdDirty()) {
            return null;
        }
        String string = pSHelpSection.getLinkPSHelpResourceId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LinkPSHelpResourceId_Default(pSHelpSection, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LINKPSHELPRESOURCEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSHelpSection pSHelpSection, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpSection.isMemoDirty() : !pSHelpSection.isMemoDirty()) {
            return null;
        }
        String string = pSHelpSection.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSHelpSection, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSHelpSection pSHelpSection, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpSection.isOrderValueDirty() && !bl2 : !pSHelpSection.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSHelpSection.getOrderValue();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORDERVALUE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSHelpSection, bl2, bl3);
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

    protected EntityFieldError onCheckField_OutputDir(boolean bl, PSHelpSection pSHelpSection, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpSection.isOutputDirDirty() : !pSHelpSection.isOutputDirDirty()) {
            return null;
        }
        Integer n = pSHelpSection.getOutputDir();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OutputDir_Default(pSHelpSection, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OUTPUTDIR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PPSHelpSectorId(boolean bl, PSHelpSection pSHelpSection, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpSection.isPPSHelpSectorIdDirty() : !pSHelpSection.isPPSHelpSectorIdDirty()) {
            return null;
        }
        String string = pSHelpSection.getPPSHelpSectorId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSHelpSectorId_Default(pSHelpSection, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSHELPSECTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCodeListId(boolean bl, PSHelpSection pSHelpSection, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpSection.isPSCodeListIdDirty() : !pSHelpSection.isPSCodeListIdDirty()) {
            return null;
        }
        String string = pSHelpSection.getPSCodeListId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCodeListId_Default(pSHelpSection, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCODELISTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCodeListName(boolean bl, PSHelpSection pSHelpSection, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpSection.isPSCodeListNameDirty() : !pSHelpSection.isPSCodeListNameDirty()) {
            return null;
        }
        String string = pSHelpSection.getPSCodeListName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCodeListName_Default(pSHelpSection, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCODELISTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFieldId(boolean bl, PSHelpSection pSHelpSection, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpSection.isPSDEFieldIdDirty() : !pSHelpSection.isPSDEFieldIdDirty()) {
            return null;
        }
        String string = pSHelpSection.getPSDEFieldId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFieldId_Default(pSHelpSection, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFIELDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFieldName(boolean bl, PSHelpSection pSHelpSection, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpSection.isPSDEFieldNameDirty() : !pSHelpSection.isPSDEFieldNameDirty()) {
            return null;
        }
        String string = pSHelpSection.getPSDEFieldName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFieldName_Default(pSHelpSection, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFIELDNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEUIActionId(boolean bl, PSHelpSection pSHelpSection, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpSection.isPSDEUIActionIdDirty() : !pSHelpSection.isPSDEUIActionIdDirty()) {
            return null;
        }
        String string = pSHelpSection.getPSDEUIActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEUIActionId_Default(pSHelpSection, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEUIACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEUIActionName(boolean bl, PSHelpSection pSHelpSection, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpSection.isPSDEUIActionNameDirty() : !pSHelpSection.isPSDEUIActionNameDirty()) {
            return null;
        }
        String string = pSHelpSection.getPSDEUIActionName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEUIActionName_Default(pSHelpSection, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEUIACTIONNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSHelpArticleId(boolean bl, PSHelpSection pSHelpSection, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpSection.isPSHelpArticleIdDirty() && !bl2 : !pSHelpSection.isPSHelpArticleIdDirty()) {
            return null;
        }
        String string = pSHelpSection.getPSHelpArticleId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSHELPARTICLEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSHelpArticleId_Default(pSHelpSection, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSHELPARTICLEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSHelpArticleName(boolean bl, PSHelpSection pSHelpSection, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpSection.isPSHelpArticleNameDirty() && !bl2 : !pSHelpSection.isPSHelpArticleNameDirty()) {
            return null;
        }
        String string = pSHelpSection.getPSHelpArticleName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSHELPARTICLENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSHelpArticleName_Default(pSHelpSection, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSHELPARTICLENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSHelpResourceId(boolean bl, PSHelpSection pSHelpSection, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpSection.isPSHelpResourceIdDirty() : !pSHelpSection.isPSHelpResourceIdDirty()) {
            return null;
        }
        String string = pSHelpSection.getPSHelpResourceId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSHelpResourceId_Default(pSHelpSection, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSHELPRESOURCEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSHelpSectionId(boolean bl, PSHelpSection pSHelpSection, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpSection.isPSHelpSectionIdDirty() && !bl2 : !pSHelpSection.isPSHelpSectionIdDirty()) {
            return null;
        }
        String string = pSHelpSection.getPSHelpSectionId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSHELPSECTIONID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSHelpSectionId_Default(pSHelpSection, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSHELPSECTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSHelpSectionName(boolean bl, PSHelpSection pSHelpSection, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpSection.isPSHelpSectionNameDirty() && !bl2 : !pSHelpSection.isPSHelpSectionNameDirty()) {
            return null;
        }
        String string = pSHelpSection.getPSHelpSectionName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSHELPSECTIONNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSHelpSectionName_Default(pSHelpSection, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSHELPSECTIONNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSHelpSectionTemplId(boolean bl, PSHelpSection pSHelpSection, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpSection.isPSHelpSectionTemplIdDirty() : !pSHelpSection.isPSHelpSectionTemplIdDirty()) {
            return null;
        }
        String string = pSHelpSection.getPSHelpSectionTemplId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSHelpSectionTemplId_Default(pSHelpSection, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSHELPSECTIONTEMPLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSHelpSectionTemplName(boolean bl, PSHelpSection pSHelpSection, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpSection.isPSHelpSectionTemplNameDirty() : !pSHelpSection.isPSHelpSectionTemplNameDirty()) {
            return null;
        }
        String string = pSHelpSection.getPSHelpSectionTemplName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSHelpSectionTemplName_Default(pSHelpSection, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSHELPSECTIONTEMPLNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefPSHelpArticleId(boolean bl, PSHelpSection pSHelpSection, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpSection.isRefPSHelpArticleIdDirty() : !pSHelpSection.isRefPSHelpArticleIdDirty()) {
            return null;
        }
        String string = pSHelpSection.getRefPSHelpArticleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSHelpArticleId_Default(pSHelpSection, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPSHELPARTICLEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SectionParam(boolean bl, PSHelpSection pSHelpSection, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpSection.isSectionParamDirty() : !pSHelpSection.isSectionParamDirty()) {
            return null;
        }
        String string = pSHelpSection.getSectionParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SectionParam_Default(pSHelpSection, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SECTIONPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SectionParam2(boolean bl, PSHelpSection pSHelpSection, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpSection.isSectionParam2Dirty() : !pSHelpSection.isSectionParam2Dirty()) {
            return null;
        }
        String string = pSHelpSection.getSectionParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SectionParam2_Default(pSHelpSection, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SECTIONPARAM2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SectionSN(boolean bl, PSHelpSection pSHelpSection, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpSection.isSectionSNDirty() : !pSHelpSection.isSectionSNDirty()) {
            return null;
        }
        String string = pSHelpSection.getSectionSN();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SectionSN_Default(pSHelpSection, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SECTIONSN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (string == null) {
                bl4 = false;
            }
            if (bl4) {
                String string3 = "";
                string3 = "PSHELPARTICLEID";
                String string4 = this.checkFieldDupRule(this.getPSHelpSectionDEModel(), "SECTIONSN", string3, pSHelpSection, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("SECTIONSN");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SectionType(boolean bl, PSHelpSection pSHelpSection, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpSection.isSectionTypeDirty() && !bl2 : !pSHelpSection.isSectionTypeDirty()) {
            return null;
        }
        String string = pSHelpSection.getSectionType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SECTIONTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_SectionType_Default(pSHelpSection, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SECTIONTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSHelpSection pSHelpSection, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpSection.isUserCatDirty() : !pSHelpSection.isUserCatDirty()) {
            return null;
        }
        String string = pSHelpSection.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSHelpSection, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSHelpSection pSHelpSection, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpSection.isUserTagDirty() : !pSHelpSection.isUserTagDirty()) {
            return null;
        }
        String string = pSHelpSection.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSHelpSection, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSHelpSection pSHelpSection, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpSection.isUserTag2Dirty() : !pSHelpSection.isUserTag2Dirty()) {
            return null;
        }
        String string = pSHelpSection.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSHelpSection, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSHelpSection pSHelpSection, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpSection.isUserTag3Dirty() : !pSHelpSection.isUserTag3Dirty()) {
            return null;
        }
        String string = pSHelpSection.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSHelpSection, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSHelpSection pSHelpSection, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpSection.isUserTag4Dirty() : !pSHelpSection.isUserTag4Dirty()) {
            return null;
        }
        String string = pSHelpSection.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSHelpSection, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSHelpSection pSHelpSection, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpSection.isValidFlagDirty() && !bl2 : !pSHelpSection.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSHelpSection.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSHelpSection, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSHelpSection pSHelpSection, boolean bl) throws Exception {
        super.onSyncEntity(pSHelpSection, bl);
    }

    protected void onSyncIndexEntities(PSHelpSection pSHelpSection, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSHelpSection, bl);
    }

    public Object getDataContextValue(PSHelpSection pSHelpSection, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSHelpSection, string, iDataContextParam)) != null) {
            return object;
        }
        PSHelpArticle pSHelpArticle = pSHelpSection.getPSHelpArticle();
        if (pSHelpArticle != null && pSHelpArticle.contains(string)) {
            return pSHelpArticle.get(string);
        }
        PSHelpSection pSHelpSection2 = pSHelpSection.getPPSHelpSector();
        if (pSHelpSection2 != null && pSHelpSection2.contains(string)) {
            return pSHelpSection2.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSHelpSection pSHelpSection, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSHelpSection, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"BOTTOMCONTENT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BottomContent_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONTENT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Content_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONTENT2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Content2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONTENTASCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ContentAsCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXPANDMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExpandMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HEADERCONTENT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HeaderContent_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LINKPSHELPRESOURCEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LinkPSHelpResourceId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LINKPSHELPRESOURCENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LinkPSHelpResourceName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OUTPUTDIR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OutputDir_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSHELPSECTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSHelpSectorId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSHELPSECTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSHelpSectorName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCODELISTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCodeListId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCODELISTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCodeListName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFIELDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFieldId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFIELDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFieldName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEUIACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEUIActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEUIACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEUIActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSHELPARTICLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSHelpArticleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSHELPARTICLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSHelpArticleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSHELPRESOURCEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSHelpResourceId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSHELPRESOURCENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSHelpResourceName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSHELPSECTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSHelpSectionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSHELPSECTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSHelpSectionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSHELPSECTIONTEMPLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSHelpSectionTemplId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSHELPSECTIONTEMPLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSHelpSectionTemplName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSHELPARTICLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSHelpArticleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSHELPARTICLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSHelpArticleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SECTIONPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SectionParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SECTIONPARAM2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SectionParam2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SECTIONSN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SectionSN_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SECTIONTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SectionType_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_BottomContent_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BOTTOMCONTENT", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false) && this.checkFieldRegExRule("CODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Content_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONTENT", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Content2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONTENT2", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ContentAsCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_ExpandMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_HeaderContent_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HEADERCONTENT", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LinkPSHelpResourceId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LINKPSHELPRESOURCEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LinkPSHelpResourceName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LINKPSHELPRESOURCENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Memo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_OutputDir_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PPSHelpSectorId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSHELPSECTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false) && this.checkFieldRecursionRule("PPSHELPSECTIONID", "PSHELPSECTION", iEntity, bl2, "")) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSHelpSectorName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSHELPSECTIONNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCodeListId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCODELISTID", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCodeListName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCODELISTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFieldId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFIELDID", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFieldName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFIELDNAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEUIActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEUIACTIONID", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEUIActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEUIACTIONNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSHelpArticleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSHELPARTICLEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSHelpArticleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSHELPARTICLENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSHelpResourceId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSHELPRESOURCEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSHelpResourceName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSHELPRESOURCENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSHelpSectionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSHELPSECTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSHelpSectionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSHELPSECTIONNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSHelpSectionTemplId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSHELPSECTIONTEMPLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSHelpSectionTemplName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSHELPSECTIONTEMPLNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSHelpArticleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSHELPARTICLEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSHelpArticleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSHELPARTICLENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SectionParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SECTIONPARAM", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SectionParam2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SECTIONPARAM2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SectionSN_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SECTIONSN", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SectionType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SECTIONTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
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

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSHelpSection pSHelpSection) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSHelpSection)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSHelpSection pSHelpSection) throws Exception {
        super.onUpdateParent(pSHelpSection);
    }

    @Override
    protected void exportCurXmlModel(PSHelpSection pSHelpSection, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSHELPSECTION");
        if (!bl) {
            pSHelpSection.setCreateDate(null);
            pSHelpSection.setCreateMan(null);
            pSHelpSection.setPSHelpSectionId(null);
            pSHelpSection.setUpdateDate(null);
            pSHelpSection.setUpdateMan(null);
            super.exportCurXmlModel(pSHelpSection, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSHelpSection pSHelpSection, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSHelpSection, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PPSHELPSECTIONID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSHELPSECTION#%1$s", (Object)string);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSHELPARTICLEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSHELPARTICLE#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PPSHELPSECTIONID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSHELPSECTION_PSHELPSECTION_PPSHELPSECTIONID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSHELPARTICLEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSHELPSECTION_PSHELPARTICLE_PSHELPARTICLEID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PPSHELPSECTIONID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PPSHELPSECTIONNAME", null);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSHELPARTICLEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSHELPARTICLENAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSHELPSECTION", (boolean)true) == 0) {
            iEntity.set("PPSHELPSECTIONID", (Object)string2);
            return true;
        }
        if (StringHelper.compare((String)string, (String)"PSHELPARTICLE", (boolean)true) == 0) {
            iEntity.set("PSHELPARTICLEID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PPSHELPSECTIONID", "PSHELPARTICLEID"};
    }

    @Override
    public String getModelV2Tag(PSHelpSection pSHelpSection) {
        if (!StringHelper.isNullOrEmpty((String)pSHelpSection.getCodeName())) {
            return pSHelpSection.getCodeName();
        }
        return super.getModelV2Tag(pSHelpSection);
    }

    @Override
    public boolean setModelV2Tag(PSHelpSection pSHelpSection, String string) {
        return super.setModelV2Tag(pSHelpSection, string);
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PPSHELPSECTIONID", "");
        map.put("PSHELPARTICLEID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSHelpSection pSHelpSection, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSHelpSection.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSHelpSection, true);
        pSHelpSection.set("CODENAME", string);
        if (this.select(pSHelpSection, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSHelpSection, true);
        return super.getModelV2Entity(pSHelpSection, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSHelpSection pSHelpSection, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSHelpSection, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSHELPSECTION_PSHELPSECTION_PPSHELPSECTIONID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 60;
        }
        return true;
    }

    @Override
    protected void onExportRelatedModelV2(PSHelpSection pSHelpSection, String string, String string2) throws Exception {
        File file = null;
        if (this.isExportRelatedModelV2("DER1N_PSHELPSECTION_PSHELPSECTION_PPSHELPSECTIONID") && (file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSHELPSECTION#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSHELPSECTION", (Object)pSHelpSection.getPSHelpSectionId()))).exists()) {
            PSHelpSectionService pSHelpSectionService = (PSHelpSectionService)ServiceGlobal.getService(PSHelpSectionService.class, (SessionFactory)this.getSessionFactory());
            String string3 = pSHelpSectionService.getModelV2Name(false);
            String string4 = string + File.separator + string3;
            File file2 = new File(string4);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            ArrayList<String> arrayList = PSModelV2Helper.readFile2(file);
            for (String string5 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string5)) continue;
                ObjectNode objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string5);
                PSHelpSection pSHelpSection2 = new PSHelpSection();
                PSModelV2Helper.fromJSONObject((IDataObject)pSHelpSection2, objectNode, false);
                String string6 = pSHelpSectionService.getModelV2Tag(pSHelpSection2);
                if (StringHelper.isNullOrEmpty((String)string6)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSHELPSECTION", (Object)pSHelpSection2.getPSHelpSectionId()));
                }
                string6 = PSModelV2Helper.getModelV2TagFolderName(string6);
                file2 = new File(string4 + File.separator + string6);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                pSHelpSectionService.exportModelV2(pSHelpSection2, string4 + File.separator + string6, string2);
            }
        }
        super.onExportRelatedModelV2(pSHelpSection, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSHelpSection pSHelpSection, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSHELPSECTION_PSHELPSECTION_PPSHELPSECTIONID")) {
            PSHelpSectionService pSHelpSectionService = (PSHelpSectionService)ServiceGlobal.getService(PSHelpSectionService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<ObjectNode> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSHELPSECTION#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSHELPSECTION", (Object)pSHelpSection.getPSHelpSectionId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String sectionJson : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty((String)sectionJson)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString(sectionJson));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String resScope = StringHelper.format((String)"PSHELPSECTION#%1$s", (Object)pSHelpSection.getPSHelpSectionId());
                for (PSHelpSection section : pSHelpSectionService.selectByPPSHelpSector(pSHelpSection)) {
                    String sectionScope = pSHelpSectionService.getModelV2ResScope(section);
                    if (StringHelper.compare(resScope, sectionScope, (boolean)false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(section, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                ArrayNode sectionsNode = objectNode.putArray(pSHelpSectionService.getModelV2Name(false).toLowerCase());
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
                        if (objectNode.has("pshelpsectionname")) {
                            string = objectNode.get("pshelpsectionname").asText();
                        }
                        if (objectNode2.has("pshelpsectionname")) {
                            string2 = objectNode2.get("pshelpsectionname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode sectionNode : arrayList) {
                    PSHelpSection section = new PSHelpSection();
                    PSModelV2Helper.fromJSONObject((IDataObject)section, sectionNode, false);
                    sectionsNode.add((JsonNode)pSHelpSectionService.exportModelV2(section, string));
                }
            }
        }
        super.onExportCurModelV2(pSHelpSection, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSHelpSection pSHelpSection) throws Exception {
        super.onEmptyModelV2(pSHelpSection);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSHelpSectionService pSHelpSectionService = (PSHelpSectionService)ServiceGlobal.getService(PSHelpSectionService.class, (SessionFactory)this.getSessionFactory());
        if (pSHelpSectionService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSHelpSection pSHelpSection, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSHelpSection pSHelpSection2 = new PSHelpSection();
        pSHelpSection2.set("PPSHELPSECTIONID", pSHelpSection.getPSHelpSectionId());
        PSHelpSectionService pSHelpSectionService = (PSHelpSectionService)ServiceGlobal.getService(PSHelpSectionService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSHelpSectionService.getModelV2Entity(pSHelpSection2, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSHelpSection, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSHelpSection pSHelpSection, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (!PSHelpSectionServiceBase.isSimpleImportExportMode("")) {
            PSHelpSectionService pSHelpSectionService = (PSHelpSectionService)ServiceGlobal.getService(PSHelpSectionService.class, (SessionFactory)this.getSessionFactory());
            ArrayNode arrayNode = null;
            String string3 = pSHelpSectionService.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                    PSHelpSection pSHelpSection2 = new PSHelpSection();
                    pSHelpSection2.setPPSHelpSectorId(pSHelpSection.getPSHelpSectionId());
                    pSHelpSection2.setPPSHelpSectorName(pSHelpSection.getPSHelpSectionName());
                    pSHelpSectionService.compileModelV2(pSHelpSection2, objectNode2, string, null, n);
                }
            } else {
                String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                File file = new File(string4);
                if (file.exists()) {
                    File[] fileArray;
                    for (File file2 : fileArray = file.listFiles()) {
                        if (!file2.isDirectory()) continue;
                        PSHelpSection pSHelpSection3 = new PSHelpSection();
                        pSHelpSection3.setPPSHelpSectorId(pSHelpSection.getPSHelpSectionId());
                        pSHelpSection3.setPPSHelpSectorName(pSHelpSection.getPSHelpSectionName());
                        pSHelpSectionService.compileModelV2(pSHelpSection3, null, string, file2.getCanonicalPath(), n);
                    }
                }
            }
        }
        super.onCompileRelatedModelV2(pSHelpSection, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSHelpSection pSHelpSection, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSHELPSECTION_PSHELPSECTION_PPSHELPSECTIONID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSHelpSections(pSHelpSection, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSHelpSection, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSHelpSections(PSHelpSection pSHelpSection, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSHELPSECTION", true), (boolean)false) == 0) {
            PSHelpSectionService pSHelpSectionService = (PSHelpSectionService)ServiceGlobal.getService(PSHelpSectionService.class, (SessionFactory)this.getSessionFactory());
            PSHelpSection pSHelpSection2 = new PSHelpSection();
            pSHelpSection2.setPSHelpSectionId(pSMOSFile.getPSModelId());
            if (!pSHelpSectionService.get(pSHelpSection2, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSHelpSection2.getPPSHelpSectorId(), (String)pSHelpSection.getPSHelpSectionId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSHelpSectionService.exportModelV2(pSHelpSection2);
            pSHelpSection2.reset();
            if (!pSHelpSectionService.setModelV2ResScope(pSHelpSection2, "PSHELPSECTION", pSHelpSection.getPSHelpSectionId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSHelpSectionService.importModelV2(pSHelpSection2, objectNode);
            SessionFactoryManager.commit();
            return pSHelpSectionService.getFile(pSHelpSection2);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSHelpSection pSHelpSection, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSHelpSections(pSHelpSection, list);
        super.onFillPasteHelps(pSHelpSection, list);
    }

    protected void onFillPasteHelps_PSHelpSections(PSHelpSection pSHelpSection, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection2 = new PSHelpSection();
        pSHelpSection2.setSectionType("USER");
        pSHelpSection2.setSectionParam("PSHELPSECTION");
        pSHelpSection2.setSectionParam2("DER1N_PSHELPSECTION_PSHELPSECTION_PPSHELPSECTIONID");
        pSHelpSection2.setContent("\u7c98\u8d34\u5176\u5b83[\u5e2e\u52a9\u7ae0\u8282]\u7684[\u5e2e\u52a9\u7ae0\u8282]");
        list.add(pSHelpSection2);
    }

    @Override
    public Object getDataType(PSHelpSection pSHelpSection) throws Exception {
        return pSHelpSection.getSectionType();
    }
}

