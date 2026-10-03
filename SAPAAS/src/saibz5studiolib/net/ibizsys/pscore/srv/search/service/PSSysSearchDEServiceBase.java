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
 *  net.ibizsys.paas.db.ISelectContext
 *  net.ibizsys.paas.db.ISelectField
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.db.SelectContext
 *  net.ibizsys.paas.db.SelectField
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
package net.ibizsys.pscore.srv.search.service;

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
import net.ibizsys.paas.db.ISelectContext;
import net.ibizsys.paas.db.ISelectField;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.db.SelectContext;
import net.ibizsys.paas.db.SelectField;
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
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.search.dao.PSSysSearchDEDAO;
import net.ibizsys.pscore.srv.search.demodel.PSSysSearchDEDEModel;
import net.ibizsys.pscore.srv.search.entity.PSSysSearchDE;
import net.ibizsys.pscore.srv.search.entity.PSSysSearchDEField;
import net.ibizsys.pscore.srv.search.entity.PSSysSearchDoc;
import net.ibizsys.pscore.srv.search.entity.PSSysSearchDocBase;
import net.ibizsys.pscore.srv.search.entity.PSSysSearchScheme;
import net.ibizsys.pscore.srv.search.entity.PSSysSearchSchemeBase;
import net.ibizsys.pscore.srv.search.service.PSSysSearchDEFieldService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSMOSFileUtil;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysSearchDEServiceBase
extends PSCoreSysServiceBase<PSSysSearchDE> {
    private static final Log log = LogFactory.getLog(PSSysSearchDEServiceBase.class);
    public static final String DATASET_CURDE = "CurDE";
    public static final String DATASET_CURSCHEME = "CurScheme";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_BUILDSEARCHDEFIELDS = "BuildSearchDEFields";
    private PSSysSearchDEDEModel pSSysSearchDEDEModel;
    private PSSysSearchDEDAO pSSysSearchDEDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.search.service.PSSysSearchDEService";
    }

    public PSSysSearchDEDEModel getPSSysSearchDEDEModel() {
        if (this.pSSysSearchDEDEModel == null) {
            try {
                this.pSSysSearchDEDEModel = (PSSysSearchDEDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.search.demodel.PSSysSearchDEDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysSearchDEDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysSearchDEDEModel();
    }

    public PSSysSearchDEDAO getPSSysSearchDEDAO() {
        if (this.pSSysSearchDEDAO == null) {
            try {
                this.pSSysSearchDEDAO = (PSSysSearchDEDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.search.dao.PSSysSearchDEDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysSearchDEDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysSearchDEDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURDE, (boolean)true) == 0) {
            return this.fetchCurDE(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSCHEME, (boolean)true) == 0) {
            return this.fetchCurScheme(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_BUILDSEARCHDEFIELDS, (boolean)true) == 0) {
            this.buildSearchDEFields((PSSysSearchDE)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurDE(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurScheme(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSCHEME, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public void buildSearchDEFields(PSSysSearchDE pSSysSearchDE) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_BUILDSEARCHDEFIELDS, 0, pSSysSearchDE, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSSysSearchDE, ACTION_BUILDSEARCHDEFIELDS);
        final PSSysSearchDE pSSysSearchDE2 = pSSysSearchDE;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysSearchDEServiceBase.this.getService(), PSSysSearchDEServiceBase.ACTION_BUILDSEARCHDEFIELDS, 40, pSSysSearchDE2, null).getResult() != 1) {
                    PSSysSearchDEServiceBase.this.onBuildSearchDEFields(pSSysSearchDE2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_BUILDSEARCHDEFIELDS, 99, pSSysSearchDE, null);
        }
    }

    protected void onBuildSearchDEFields(PSSysSearchDE pSSysSearchDE) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[BuildSearchDEFields]");
    }

    protected void onFillParentInfo(PSSysSearchDE pSSysSearchDE, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSEARCHDE_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDataEntity);
            } else {
                iService.get(pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSSysSearchDE, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSEARCHDE_PSSYSSEARCHDOC_PSSYSSEARCHDOCID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.search.service.PSSysSearchDocService", (SessionFactory)this.getSessionFactory());
            PSSysSearchDoc pSSysSearchDoc = (PSSysSearchDoc)iService.getDEModel().createEntity();
            pSSysSearchDoc.set("PSSYSSEARCHDOCID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysSearchDoc);
            } else {
                iService.get(pSSysSearchDoc);
            }
            this.onFillParentInfo_PSSysSearchDoc(pSSysSearchDE, pSSysSearchDoc);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSEARCHDE_PSSYSSEARCHSCHEME_PSSYSSEARCHSCHEMEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.search.service.PSSysSearchSchemeService", (SessionFactory)this.getSessionFactory());
            PSSysSearchScheme pSSysSearchScheme = (PSSysSearchScheme)iService.getDEModel().createEntity();
            pSSysSearchScheme.set("PSSYSSEARCHSCHEMEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysSearchScheme);
            } else {
                iService.get(pSSysSearchScheme);
            }
            this.onFillParentInfo_PSSysSearchScheme(pSSysSearchDE, pSSysSearchScheme);
            return;
        }
        super.onFillParentInfo(pSSysSearchDE, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDE(PSSysSearchDE pSSysSearchDE, PSDataEntity pSDataEntity) throws Exception {
        pSSysSearchDE.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSSysSearchDE.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_PSSysSearchDoc(PSSysSearchDE pSSysSearchDE, PSSysSearchDoc pSSysSearchDoc) throws Exception {
        pSSysSearchDE.setPSSysSearchDocId(pSSysSearchDoc.getPSSysSearchDocId());
        pSSysSearchDE.setPSSysSearchDocName(pSSysSearchDoc.getPSSysSearchDocName());
        if (pSSysSearchDoc.getPSSysSearchScheme() != null) {
            this.onFillParentInfo_PSSysSearchScheme(pSSysSearchDE, pSSysSearchDoc.getPSSysSearchScheme());
        }
    }

    protected void onFillParentInfo_PSSysSearchScheme(PSSysSearchDE pSSysSearchDE, PSSysSearchScheme pSSysSearchScheme) throws Exception {
        pSSysSearchDE.setPSSysSearchSchemeId(pSSysSearchScheme.getPSSysSearchSchemeId());
        pSSysSearchDE.setPSSysSearchSchemeName(pSSysSearchScheme.getPSSysSearchSchemeName());
    }

    protected void onFillEntityFullInfo(PSSysSearchDE pSSysSearchDE, boolean bl) throws Exception {
        if (bl) {
            if (pSSysSearchDE.getNoSQLFlag() == null) {
                pSSysSearchDE.setNoSQLFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSSysSearchDE.getValidFlag() == null) {
                pSSysSearchDE.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo(pSSysSearchDE, bl);
        this.onFillEntityFullInfo_PSDE(pSSysSearchDE, bl);
        this.onFillEntityFullInfo_PSSysSearchDoc(pSSysSearchDE, bl);
        this.onFillEntityFullInfo_PSSysSearchScheme(pSSysSearchDE, bl);
    }

    protected void onFillEntityFullInfo_PSDE(PSSysSearchDE pSSysSearchDE, boolean bl) throws Exception {
        if (pSSysSearchDE.isPSDEIdDirty()) {
            if (pSSysSearchDE.getPSDEId() != null) {
                if (pSSysSearchDE.getPSDEId() == null || pSSysSearchDE.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSSysSearchDE.getPSDE();
                    pSSysSearchDE.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSSysSearchDE.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysSearchDoc(PSSysSearchDE pSSysSearchDE, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysSearchScheme(PSSysSearchDE pSSysSearchDE, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysSearchDE pSSysSearchDE, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysSearchDE, bl);
    }

    public ArrayList<PSSysSearchDE> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSSysSearchDE> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSSysSearchDE> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEID", (Object)pSDataEntityBase.getPSDataEntityId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDECond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysSearchDE> selectByPSSysSearchDoc(PSSysSearchDocBase pSSysSearchDocBase) throws Exception {
        return this.selectByPSSysSearchDoc(pSSysSearchDocBase, "", -1);
    }

    public ArrayList<PSSysSearchDE> selectByPSSysSearchDoc(PSSysSearchDocBase pSSysSearchDocBase, String string) throws Exception {
        return this.selectByPSSysSearchDoc(pSSysSearchDocBase, string, -1);
    }

    public ArrayList<PSSysSearchDE> selectByPSSysSearchDoc(PSSysSearchDocBase pSSysSearchDocBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSSEARCHDOCID", (Object)pSSysSearchDocBase.getPSSysSearchDocId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysSearchDocCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysSearchDocCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysSearchDE> selectByPSSysSearchScheme(PSSysSearchSchemeBase pSSysSearchSchemeBase) throws Exception {
        return this.selectByPSSysSearchScheme(pSSysSearchSchemeBase, "", -1);
    }

    public ArrayList<PSSysSearchDE> selectByPSSysSearchScheme(PSSysSearchSchemeBase pSSysSearchSchemeBase, String string) throws Exception {
        return this.selectByPSSysSearchScheme(pSSysSearchSchemeBase, string, -1);
    }

    public ArrayList<PSSysSearchDE> selectByPSSysSearchScheme(PSSysSearchSchemeBase pSSysSearchSchemeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSSEARCHSCHEMEID", (Object)pSSysSearchSchemeBase.getPSSysSearchSchemeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysSearchSchemeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysSearchSchemeCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysSearchDE> arrayList = this.selectByPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSSEARCHDE_PSDATAENTITY_PSDEID", "", iDataEntityModel.getName(), "PSSYSSEARCHDE", iDataEntityModel.getDataInfo(pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysSearchDE> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSSysSearchDE pSSysSearchDE : arrayList) {
            PSSysSearchDE pSSysSearchDE2 = (PSSysSearchDE)this.getDEModel().createEntity();
            pSSysSearchDE2.setPSSysSearchDEId(pSSysSearchDE.getPSSysSearchDEId());
            pSSysSearchDE2.setPSDEId(null);
            this.update(pSSysSearchDE2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysSearchDEServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSSysSearchDEServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSSysSearchDEServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysSearchDE> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSSysSearchDE pSSysSearchDE : arrayList) {
            this.remove(pSSysSearchDE);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysSearchDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysSearchDE> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSearchDoc(PSSysSearchDoc pSSysSearchDoc) throws Exception {
        ArrayList<PSSysSearchDE> arrayList = this.selectByPSSysSearchDoc(pSSysSearchDoc, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSEARCHDOC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysSearchDoc);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSSEARCHDE_PSSYSSEARCHDOC_PSSYSSEARCHDOCID", "", iDataEntityModel.getName(), "PSSYSSEARCHDE", iDataEntityModel.getDataInfo(pSSysSearchDoc), arrayList.get(0)));
        }
    }

    public void resetPSSysSearchDoc(PSSysSearchDoc pSSysSearchDoc) throws Exception {
        ArrayList<PSSysSearchDE> arrayList = this.selectByPSSysSearchDoc(pSSysSearchDoc);
        for (PSSysSearchDE pSSysSearchDE : arrayList) {
            PSSysSearchDE pSSysSearchDE2 = (PSSysSearchDE)this.getDEModel().createEntity();
            pSSysSearchDE2.setPSSysSearchDEId(pSSysSearchDE.getPSSysSearchDEId());
            pSSysSearchDE2.setPSSysSearchDocId(null);
            this.update(pSSysSearchDE2);
        }
    }

    public void removeByPSSysSearchDoc(PSSysSearchDoc pSSysSearchDoc) throws Exception {
        final PSSysSearchDoc pSSysSearchDoc2 = pSSysSearchDoc;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysSearchDEServiceBase.this.onBeforeRemoveByPSSysSearchDoc(pSSysSearchDoc2);
                PSSysSearchDEServiceBase.this.internalRemoveByPSSysSearchDoc(pSSysSearchDoc2);
                PSSysSearchDEServiceBase.this.onAfterRemoveByPSSysSearchDoc(pSSysSearchDoc2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSearchDoc(PSSysSearchDoc pSSysSearchDoc) throws Exception {
    }

    protected void internalRemoveByPSSysSearchDoc(PSSysSearchDoc pSSysSearchDoc) throws Exception {
        ArrayList<PSSysSearchDE> arrayList = this.selectByPSSysSearchDoc(pSSysSearchDoc);
        this.onBeforeRemoveByPSSysSearchDoc(pSSysSearchDoc, arrayList);
        for (PSSysSearchDE pSSysSearchDE : arrayList) {
            this.remove(pSSysSearchDE);
        }
        this.onAfterRemoveByPSSysSearchDoc(pSSysSearchDoc, arrayList);
    }

    protected void onAfterRemoveByPSSysSearchDoc(PSSysSearchDoc pSSysSearchDoc) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSearchDoc(PSSysSearchDoc pSSysSearchDoc, ArrayList<PSSysSearchDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSearchDoc(PSSysSearchDoc pSSysSearchDoc, ArrayList<PSSysSearchDE> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSearchScheme(PSSysSearchScheme pSSysSearchScheme) throws Exception {
        ArrayList<PSSysSearchDE> arrayList = this.selectByPSSysSearchScheme(pSSysSearchScheme, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSEARCHSCHEME");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysSearchScheme);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSSEARCHDE_PSSYSSEARCHSCHEME_PSSYSSEARCHSCHEMEID", "", iDataEntityModel.getName(), "PSSYSSEARCHDE", iDataEntityModel.getDataInfo(pSSysSearchScheme), arrayList.get(0)));
        }
    }

    public void resetPSSysSearchScheme(PSSysSearchScheme pSSysSearchScheme) throws Exception {
        ArrayList<PSSysSearchDE> arrayList = this.selectByPSSysSearchScheme(pSSysSearchScheme);
        for (PSSysSearchDE pSSysSearchDE : arrayList) {
            PSSysSearchDE pSSysSearchDE2 = (PSSysSearchDE)this.getDEModel().createEntity();
            pSSysSearchDE2.setPSSysSearchDEId(pSSysSearchDE.getPSSysSearchDEId());
            pSSysSearchDE2.setPSSysSearchSchemeId(null);
            this.update(pSSysSearchDE2);
        }
    }

    public void removeByPSSysSearchScheme(PSSysSearchScheme pSSysSearchScheme) throws Exception {
        final PSSysSearchScheme pSSysSearchScheme2 = pSSysSearchScheme;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysSearchDEServiceBase.this.onBeforeRemoveByPSSysSearchScheme(pSSysSearchScheme2);
                PSSysSearchDEServiceBase.this.internalRemoveByPSSysSearchScheme(pSSysSearchScheme2);
                PSSysSearchDEServiceBase.this.onAfterRemoveByPSSysSearchScheme(pSSysSearchScheme2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSearchScheme(PSSysSearchScheme pSSysSearchScheme) throws Exception {
    }

    protected void internalRemoveByPSSysSearchScheme(PSSysSearchScheme pSSysSearchScheme) throws Exception {
        ArrayList<PSSysSearchDE> arrayList = this.selectByPSSysSearchScheme(pSSysSearchScheme);
        this.onBeforeRemoveByPSSysSearchScheme(pSSysSearchScheme, arrayList);
        for (PSSysSearchDE pSSysSearchDE : arrayList) {
            this.remove(pSSysSearchDE);
        }
        this.onAfterRemoveByPSSysSearchScheme(pSSysSearchScheme, arrayList);
    }

    protected void onAfterRemoveByPSSysSearchScheme(PSSysSearchScheme pSSysSearchScheme) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSearchScheme(PSSysSearchScheme pSSysSearchScheme, ArrayList<PSSysSearchDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSearchScheme(PSSysSearchScheme pSSysSearchScheme, ArrayList<PSSysSearchDE> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysSearchDE pSSysSearchDE) throws Exception {
        PSSysSearchDEFieldService pSSysSearchDEFieldService = (PSSysSearchDEFieldService)ServiceGlobal.getService(PSSysSearchDEFieldService.class, (SessionFactory)this.getSessionFactory());
        pSSysSearchDEFieldService.testRemoveByPSSysSearchDE(pSSysSearchDE);
        super.onBeforeRemove(pSSysSearchDE);
    }

    protected void replaceParentInfo(PSSysSearchDE pSSysSearchDE, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysSearchDE, cloneSession);
        if (pSSysSearchDE.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSSysSearchDE.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSSysSearchDE, (PSDataEntity)iEntity);
        }
        if (pSSysSearchDE.getPSSysSearchDocId() != null && (iEntity = cloneSession.getEntity("PSSYSSEARCHDOC", (Object)pSSysSearchDE.getPSSysSearchDocId())) != null) {
            this.onFillParentInfo_PSSysSearchDoc(pSSysSearchDE, (PSSysSearchDoc)iEntity);
        }
        if (pSSysSearchDE.getPSSysSearchSchemeId() != null && (iEntity = cloneSession.getEntity("PSSYSSEARCHSCHEME", (Object)pSSysSearchDE.getPSSysSearchSchemeId())) != null) {
            this.onFillParentInfo_PSSysSearchScheme(pSSysSearchDE, (PSSysSearchScheme)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysSearchDE pSSysSearchDE, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysSearchDE, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysSearchDE pSSysSearchDE, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSSysSearchDE, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DETag(bl, pSSysSearchDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DETag2(bl, pSSysSearchDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysSearchDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NoSQLFlag(bl, pSSysSearchDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSSysSearchDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSSysSearchDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSearchDEId(bl, pSSysSearchDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSearchDEName(bl, pSSysSearchDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSearchDocId(bl, pSSysSearchDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSearchSchemeId(bl, pSSysSearchDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ThreadRunMode(bl, pSSysSearchDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysSearchDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysSearchDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysSearchDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysSearchDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysSearchDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSysSearchDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysSearchDE, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysSearchDE pSSysSearchDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchDE.isCodeNameDirty() : !pSSysSearchDE.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysSearchDE.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSSysSearchDE, bl2, bl3);
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
                string3 = "PSSYSSEARCHSCHEMEID";
                String string4 = this.checkFieldDupRule(this.getPSSysSearchDEDEModel(), "CODENAME", string3, pSSysSearchDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_DETag(boolean bl, PSSysSearchDE pSSysSearchDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchDE.isDETagDirty() : !pSSysSearchDE.isDETagDirty()) {
            return null;
        }
        String string = pSSysSearchDE.getDETag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DETag_Default(pSSysSearchDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DETAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DETag2(boolean bl, PSSysSearchDE pSSysSearchDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchDE.isDETag2Dirty() : !pSSysSearchDE.isDETag2Dirty()) {
            return null;
        }
        String string = pSSysSearchDE.getDETag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DETag2_Default(pSSysSearchDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DETAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysSearchDE pSSysSearchDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchDE.isMemoDirty() : !pSSysSearchDE.isMemoDirty()) {
            return null;
        }
        String string = pSSysSearchDE.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysSearchDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_NoSQLFlag(boolean bl, PSSysSearchDE pSSysSearchDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchDE.isNoSQLFlagDirty() : !pSSysSearchDE.isNoSQLFlagDirty()) {
            return null;
        }
        Integer n = pSSysSearchDE.getNoSQLFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NoSQLFlag_Default(pSSysSearchDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NOSQLFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSSysSearchDE pSSysSearchDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchDE.isPSDEIdDirty() && !bl2 : !pSSysSearchDE.isPSDEIdDirty()) {
            return null;
        }
        String string = pSSysSearchDE.getPSDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default(pSSysSearchDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEID");
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
                string3 = "PSSYSSEARCHSCHEMEID";
                string3 = string3 + ";";
                string3 = string3 + "PSSYSSEARCHDOCID";
                String string4 = this.checkFieldDupRule(this.getPSSysSearchDEDEModel(), "PSDEID", string3, pSSysSearchDE, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDEID");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSSysSearchDE pSSysSearchDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchDE.isPSDENameDirty() : !pSSysSearchDE.isPSDENameDirty()) {
            return null;
        }
        String string = pSSysSearchDE.getPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default(pSSysSearchDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSearchDEId(boolean bl, PSSysSearchDE pSSysSearchDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchDE.isPSSysSearchDEIdDirty() && !bl2 : !pSSysSearchDE.isPSSysSearchDEIdDirty()) {
            return null;
        }
        String string = pSSysSearchDE.getPSSysSearchDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSEARCHDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSearchDEId_Default(pSSysSearchDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSEARCHDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSearchDEName(boolean bl, PSSysSearchDE pSSysSearchDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchDE.isPSSysSearchDENameDirty() && !bl2 : !pSSysSearchDE.isPSSysSearchDENameDirty()) {
            return null;
        }
        String string = pSSysSearchDE.getPSSysSearchDEName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSEARCHDENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSearchDEName_Default(pSSysSearchDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSEARCHDENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSearchDocId(boolean bl, PSSysSearchDE pSSysSearchDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchDE.isPSSysSearchDocIdDirty() : !pSSysSearchDE.isPSSysSearchDocIdDirty()) {
            return null;
        }
        String string = pSSysSearchDE.getPSSysSearchDocId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSearchDocId_Default(pSSysSearchDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSEARCHDOCID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSearchSchemeId(boolean bl, PSSysSearchDE pSSysSearchDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchDE.isPSSysSearchSchemeIdDirty() : !pSSysSearchDE.isPSSysSearchSchemeIdDirty()) {
            return null;
        }
        String string = pSSysSearchDE.getPSSysSearchSchemeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSearchSchemeId_Default(pSSysSearchDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSEARCHSCHEMEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ThreadRunMode(boolean bl, PSSysSearchDE pSSysSearchDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchDE.isThreadRunModeDirty() : !pSSysSearchDE.isThreadRunModeDirty()) {
            return null;
        }
        Integer n = pSSysSearchDE.getThreadRunMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ThreadRunMode_Default(pSSysSearchDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("THREADRUNMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysSearchDE pSSysSearchDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchDE.isUserCatDirty() : !pSSysSearchDE.isUserCatDirty()) {
            return null;
        }
        String string = pSSysSearchDE.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSSysSearchDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysSearchDE pSSysSearchDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchDE.isUserTagDirty() : !pSSysSearchDE.isUserTagDirty()) {
            return null;
        }
        String string = pSSysSearchDE.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSSysSearchDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysSearchDE pSSysSearchDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchDE.isUserTag2Dirty() : !pSSysSearchDE.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysSearchDE.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSSysSearchDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysSearchDE pSSysSearchDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchDE.isUserTag3Dirty() : !pSSysSearchDE.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysSearchDE.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSSysSearchDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysSearchDE pSSysSearchDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchDE.isUserTag4Dirty() : !pSSysSearchDE.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysSearchDE.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSSysSearchDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSysSearchDE pSSysSearchDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchDE.isValidFlagDirty() && !bl2 : !pSSysSearchDE.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSysSearchDE.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSSysSearchDE, bl2, bl3);
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

    protected void onSyncEntity(PSSysSearchDE pSSysSearchDE, boolean bl) throws Exception {
        super.onSyncEntity(pSSysSearchDE, bl);
    }

    protected void onSyncIndexEntities(PSSysSearchDE pSSysSearchDE, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysSearchDE, bl);
    }

    public Object getDataContextValue(PSSysSearchDE pSSysSearchDE, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysSearchDE, string, iDataContextParam)) != null) {
            return object;
        }
        PSDataEntity pSDataEntity = pSSysSearchDE.getPSDE();
        if (pSDataEntity != null && pSDataEntity.contains(string)) {
            return pSDataEntity.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysSearchDE pSSysSearchDE, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysSearchDE, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DETAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DETag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DETAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DETag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NOSQLFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NoSQLFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSEARCHDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSearchDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSEARCHDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSearchDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSEARCHDOCID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSearchDocId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSEARCHDOCNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSearchDocName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSEARCHSCHEMEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSearchSchemeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSEARCHSCHEMENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSearchSchemeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"THREADRUNMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ThreadRunMode_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_DETag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DETAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DETag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DETAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_NoSQLFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_PSDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSearchDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSEARCHDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSearchDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSEARCHDENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSearchDocId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSEARCHDOCID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSearchDocName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSEARCHDOCNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSearchSchemeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSEARCHSCHEMEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSearchSchemeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSEARCHSCHEMENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ThreadRunMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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
            if (this.checkFieldStringLengthRule("USERTAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected boolean onMergeChild(String string, String string2, PSSysSearchDE pSSysSearchDE) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysSearchDE)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysSearchDE pSSysSearchDE) throws Exception {
        super.onUpdateParent(pSSysSearchDE);
    }

    @Override
    protected void exportCurXmlModel(PSSysSearchDE pSSysSearchDE, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSSEARCHDE");
        if (!bl) {
            pSSysSearchDE.setCreateDate(null);
            pSSysSearchDE.setCreateMan(null);
            pSSysSearchDE.setPSSysSearchDEId(null);
            pSSysSearchDE.setUpdateDate(null);
            pSSysSearchDE.setUpdateMan(null);
            super.exportCurXmlModel(pSSysSearchDE, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysSearchDE pSSysSearchDE, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysSearchDE, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSSEARCHSCHEMEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSSEARCHSCHEME#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSSEARCHSCHEMEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSSEARCHDE_PSSYSSEARCHSCHEME_PSSYSSEARCHSCHEMEID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSSEARCHSCHEMEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSSEARCHSCHEMENAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSYSSEARCHSCHEME", (boolean)true) == 0) {
            iEntity.set("PSSYSSEARCHSCHEMEID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSSYSSEARCHSCHEMEID"};
    }

    @Override
    public String getModelV2Tag(PSSysSearchDE pSSysSearchDE) {
        if (!StringHelper.isNullOrEmpty((String)pSSysSearchDE.getCodeName())) {
            return pSSysSearchDE.getCodeName();
        }
        return super.getModelV2Tag(pSSysSearchDE);
    }

    @Override
    public boolean setModelV2Tag(PSSysSearchDE pSSysSearchDE, String string) {
        pSSysSearchDE.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSSYSSEARCHSCHEMEID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysSearchDE pSSysSearchDE, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysSearchDE.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysSearchDE, true);
        pSSysSearchDE.set("CODENAME", string);
        if (this.select(pSSysSearchDE, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysSearchDE, true);
        return super.getModelV2Entity(pSSysSearchDE, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysSearchDE pSSysSearchDE, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysSearchDE, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSSYSSEARCHDEFIELD_PSSYSSEARCHDE_PSSYSSEARCHDEID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 60;
        }
        return true;
    }

    @Override
    protected void onExportRelatedModelV2(PSSysSearchDE pSSysSearchDE, String string, String string2) throws Exception {
        File file = null;
        if (this.isExportRelatedModelV2("DER1N_PSSYSSEARCHDEFIELD_PSSYSSEARCHDE_PSSYSSEARCHDEID") && (file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSSEARCHDE#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSSYSSEARCHDEFIELD", (Object)pSSysSearchDE.getPSSysSearchDEId()))).exists()) {
            PSSysSearchDEFieldService pSSysSearchDEFieldService = (PSSysSearchDEFieldService)ServiceGlobal.getService(PSSysSearchDEFieldService.class, (SessionFactory)this.getSessionFactory());
            String string3 = pSSysSearchDEFieldService.getModelV2Name(false);
            String string4 = string + File.separator + string3;
            File file2 = new File(string4);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            ArrayList<String> arrayList = PSModelV2Helper.readFile2(file);
            for (String string5 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string5)) continue;
                ObjectNode objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string5);
                PSSysSearchDEField pSSysSearchDEField = new PSSysSearchDEField();
                PSModelV2Helper.fromJSONObject((IDataObject)pSSysSearchDEField, objectNode, false);
                String string6 = pSSysSearchDEFieldService.getModelV2Tag(pSSysSearchDEField);
                if (StringHelper.isNullOrEmpty((String)string6)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSSYSSEARCHDEFIELD", (Object)pSSysSearchDEField.getPSSysSearchDEFieldId()));
                }
                string6 = PSModelV2Helper.getModelV2TagFolderName(string6);
                file2 = new File(string4 + File.separator + string6);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                pSSysSearchDEFieldService.exportModelV2(pSSysSearchDEField, string4 + File.separator + string6, string2);
            }
        }
        super.onExportRelatedModelV2(pSSysSearchDE, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSSysSearchDE pSSysSearchDE, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSYSSEARCHDEFIELD_PSSYSSEARCHDE_PSSYSSEARCHDEID")) {
            PSSysSearchDEFieldService pSSysSearchDEFieldService = (PSSysSearchDEFieldService)ServiceGlobal.getService(PSSysSearchDEFieldService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<ObjectNode> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSSEARCHDE#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSYSSEARCHDEFIELD", (Object)pSSysSearchDE.getPSSysSearchDEId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty((String)line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString((String)line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSSYSSEARCHDE#%1$s", (Object)pSSysSearchDE.getPSSysSearchDEId());
                for (PSSysSearchDEField field : pSSysSearchDEFieldService.selectByPSSysSearchDE(pSSysSearchDE)) {
                    String fieldScope = pSSysSearchDEFieldService.getModelV2ResScope(field);
                    if (StringHelper.compare((String)scope, (String)fieldScope, (boolean)false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(field, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                ArrayNode output = objectNode.putArray(pSSysSearchDEFieldService.getModelV2Name(false).toLowerCase());
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
                        if (objectNode.has("pssyssearchdefieldname")) {
                            string = objectNode.get("pssyssearchdefieldname").asText();
                        }
                        if (objectNode2.has("pssyssearchdefieldname")) {
                            string2 = objectNode2.get("pssyssearchdefieldname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode fieldNode : arrayList) {
                    PSSysSearchDEField field = new PSSysSearchDEField();
                    PSModelV2Helper.fromJSONObject((IDataObject)field, fieldNode, false);
                    output.add((JsonNode)pSSysSearchDEFieldService.exportModelV2(field, string));
                }
            }
        }
        super.onExportCurModelV2(pSSysSearchDE, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSSysSearchDE pSSysSearchDE) throws Exception {
        super.onEmptyModelV2(pSSysSearchDE);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSSysSearchDEFieldService pSSysSearchDEFieldService = (PSSysSearchDEFieldService)ServiceGlobal.getService(PSSysSearchDEFieldService.class, (SessionFactory)this.getSessionFactory());
        if (pSSysSearchDEFieldService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSSysSearchDE pSSysSearchDE, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSSysSearchDEField pSSysSearchDEField = new PSSysSearchDEField();
        pSSysSearchDEField.set("PSSYSSEARCHDEID", pSSysSearchDE.getPSSysSearchDEId());
        PSSysSearchDEFieldService pSSysSearchDEFieldService = (PSSysSearchDEFieldService)ServiceGlobal.getService(PSSysSearchDEFieldService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSSysSearchDEFieldService.getModelV2Entity(pSSysSearchDEField, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSSysSearchDE, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSSysSearchDE pSSysSearchDE, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (!PSSysSearchDEServiceBase.isSimpleImportExportMode("")) {
            PSSysSearchDEFieldService pSSysSearchDEFieldService = (PSSysSearchDEFieldService)ServiceGlobal.getService(PSSysSearchDEFieldService.class, (SessionFactory)this.getSessionFactory());
            ArrayNode arrayNode = null;
            String string3 = pSSysSearchDEFieldService.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                    PSSysSearchDEField pSSysSearchDEField = new PSSysSearchDEField();
                    pSSysSearchDEField.setPSSysSearchDEId(pSSysSearchDE.getPSSysSearchDEId());
                    pSSysSearchDEField.setPSSysSearchDEName(pSSysSearchDE.getPSSysSearchDEName());
                    pSSysSearchDEField.setPSSysSearchDocId(pSSysSearchDE.getPSSysSearchDocId());
                    pSSysSearchDEFieldService.compileModelV2(pSSysSearchDEField, objectNode2, string, null, n);
                }
            } else {
                String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                File file = new File(string4);
                if (file.exists()) {
                    File[] fileArray;
                    for (File file2 : fileArray = file.listFiles()) {
                        if (!file2.isDirectory()) continue;
                        PSSysSearchDEField pSSysSearchDEField = new PSSysSearchDEField();
                        pSSysSearchDEField.setPSSysSearchDEId(pSSysSearchDE.getPSSysSearchDEId());
                        pSSysSearchDEField.setPSSysSearchDEName(pSSysSearchDE.getPSSysSearchDEName());
                        pSSysSearchDEField.setPSSysSearchDocId(pSSysSearchDE.getPSSysSearchDocId());
                        pSSysSearchDEFieldService.compileModelV2(pSSysSearchDEField, null, string, file2.getCanonicalPath(), n);
                    }
                }
            }
        }
        super.onCompileRelatedModelV2(pSSysSearchDE, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSSysSearchDE pSSysSearchDE, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSSYSSEARCHDEFIELD_PSSYSSEARCHDE_PSSYSSEARCHDEID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSSysSearchDEFields(pSSysSearchDE, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSSysSearchDE, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSSysSearchDEFields(PSSysSearchDE pSSysSearchDE, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSSYSSEARCHDEFIELD", true), (boolean)false) == 0) {
            PSSysSearchDEFieldService pSSysSearchDEFieldService = (PSSysSearchDEFieldService)ServiceGlobal.getService(PSSysSearchDEFieldService.class, (SessionFactory)this.getSessionFactory());
            PSSysSearchDEField pSSysSearchDEField = new PSSysSearchDEField();
            pSSysSearchDEField.setPSSysSearchDEFieldId(pSMOSFile.getPSModelId());
            if (!pSSysSearchDEFieldService.get(pSSysSearchDEField, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSSysSearchDEField.getPSSysSearchDEId(), (String)pSSysSearchDE.getPSSysSearchDEId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSSysSearchDEFieldService.exportModelV2(pSSysSearchDEField);
            pSSysSearchDEField.reset();
            if (!pSSysSearchDEFieldService.setModelV2ResScope(pSSysSearchDEField, "PSSYSSEARCHDE", pSSysSearchDE.getPSSysSearchDEId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSSysSearchDEFieldService.importModelV2(pSSysSearchDEField, objectNode);
            SessionFactoryManager.commit();
            return pSSysSearchDEFieldService.getFile(pSSysSearchDEField);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSSysSearchDE pSSysSearchDE, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSSysSearchDEFields(pSSysSearchDE, list);
        super.onFillPasteHelps(pSSysSearchDE, list);
    }

    protected void onFillPasteHelps_PSSysSearchDEFields(PSSysSearchDE pSSysSearchDE, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSSYSSEARCHDEFIELD");
        pSHelpSection.setSectionParam2("DER1N_PSSYSSEARCHDEFIELD_PSSYSSEARCHDE_PSSYSSEARCHDEID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5168\u6587\u68c0\u7d22\u5b9e\u4f53]\u7684[\u5168\u6587\u68c0\u7d22\u5b9e\u4f53\u5c5e\u6027]");
        list.add(pSHelpSection);
    }

    @Override
    protected PSMOSFile[] onListDRFolders(PSMOSFile pSMOSFile, String string, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        HashMap<String, PSMOSFile> hashMap = new HashMap<String, PSMOSFile>();
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u68c0\u7d22\u5c5e\u6027>", "DER1N_PSSYSSEARCHDEFIELD_PSSYSSEARCHDE_PSSYSSEARCHDEID", "PSSYSSEARCHDEID", pSMOSFile.getPSModelId(), "", "")) {
            PSMOSFile pSMOSFile2 = new PSMOSFile();
            if (PSSysSearchDEServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u68c0\u7d22\u5c5e\u6027>");
            } else if (PSSysSearchDEServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("pssyssearchdefields");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSSYSSEARCHDEFIELD_PSSYSSEARCHDE_PSSYSSEARCHDEID|PSSYSSEARCHDEID");
            pSMOSFile2.setFileTag3("PSSYSSEARCHDEFIELD");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSSYSSEARCHDEFIELD_PSSYSSEARCHDE_PSSYSSEARCHDEID", "PSSYSSEARCHDEID", pSMOSFile.getPSModelId(), "", "")) {
                PSSysSearchDEFieldService pSSysSearchDEFieldService = (PSSysSearchDEFieldService)ServiceGlobal.getService(PSSysSearchDEFieldService.class, (SessionFactory)this.getSessionFactory());
                SelectContext selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSSysSearchDEFieldService, "DER1N_PSSYSSEARCHDEFIELD_PSSYSSEARCHDE_PSSYSSEARCHDEID", "PSSYSSEARCHDEID", pSMOSFile.getPSModelId(), "", "");
                SelectField selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                ArrayList arrayList = pSSysSearchDEFieldService.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSSysSearchDEServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
                if (iPSMOSFileFilter.isStarQuery() || pSMOSFile2.getPSMOSFileName().indexOf(iPSMOSFileFilter.getQuery()) != -1) {
                    hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
                }
            } else {
                hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
            }
        }
        if (hashMap.size() > 0) {
            return PSMOSFileUtil.append(hashMap.values().toArray(new PSMOSFile[hashMap.size()]), super.onListDRFolders(pSMOSFile, string, iPSMOSFileFilter));
        }
        return super.onListDRFolders(pSMOSFile, string, iPSMOSFileFilter);
    }

    @Override
    protected PSMOSFile[] onListDRDataFolders(PSMOSFile pSMOSFile, String string, String string2, IPSMOSFileFilter iPSMOSFileFilter, boolean bl) throws Exception {
        ArrayList<PSMOSFile> arrayList = new ArrayList<PSMOSFile>();
        if (PSSysSearchDEServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u68c0\u7d22\u5c5e\u6027>", (boolean)false) == 0 || PSSysSearchDEServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSSysSearchDEFields", (boolean)true) == 0) {
            PSSysSearchDEFieldService pSSysSearchDEFieldService = (PSSysSearchDEFieldService)ServiceGlobal.getService(PSSysSearchDEFieldService.class, (SessionFactory)this.getSessionFactory());
            SelectContext selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSSysSearchDEFieldService, "DER1N_PSSYSSEARCHDEFIELD_PSSYSSEARCHDE_PSSYSSEARCHDEID", "PSSYSSEARCHDEID", pSMOSFile.getPSModelId(), "", "");
            ArrayList<PSSysSearchDEField> arrayList2 = pSSysSearchDEFieldService.selectEx((ISelectContext)selectContext);
            for (PSSysSearchDEField pSSysSearchDEField : arrayList2) {
                PSMOSFile pSMOSFile2 = pSSysSearchDEFieldService.getFile(pSMOSFile, pSSysSearchDEField, bl);
                if (pSMOSFile2 == null) continue;
                arrayList.add(pSMOSFile2);
            }
        }
        if (arrayList.size() > 0) {
            return PSMOSFileUtil.append(arrayList.toArray(new PSMOSFile[arrayList.size()]), super.onListDRDataFolders(pSMOSFile, string, string2, iPSMOSFileFilter, bl));
        }
        return super.onListDRDataFolders(pSMOSFile, string, string2, iPSMOSFileFilter, bl);
    }

    @Override
    public String getDRFolderPath(String string, IEntity iEntity, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"DER1N_PSSYSSEARCHDEFIELD_PSSYSSEARCHDE_PSSYSSEARCHDEID", (boolean)false) == 0) {
            if (PSSysSearchDEServiceBase.getMOSVer() == 1) {
                return "<\u68c0\u7d22\u5c5e\u6027>";
            }
            if (PSSysSearchDEServiceBase.getMOSVer() == 2) {
                return "pssyssearchdefields";
            }
        }
        return super.getDRFolderPath(string, iEntity, string2);
    }

    @Override
    public boolean isOutputDRFolders() {
        return true;
    }
}
