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
 *  net.ibizsys.paas.entity.EntityBase
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
package net.ibizsys.pscore.srv.eaidesign.service;

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
import net.ibizsys.paas.entity.EntityBase;
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
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.eaidesign.dao.PSSysEAIDEDAO;
import net.ibizsys.pscore.srv.eaidesign.demodel.PSSysEAIDEDEModel;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIDE;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIDEField;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIDEFieldBase;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIDER;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIDERBase;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIElement;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIElementBase;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIScheme;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAISchemeBase;
import net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIDEFieldService;
import net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIDEFieldServiceBase;
import net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIDERService;
import net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIDERServiceBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysEAIDEServiceBase
extends PSCoreSysServiceBase<PSSysEAIDE> {
    private static final Log log = LogFactory.getLog(PSSysEAIDEServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSSysEAIDEDEModel pSSysEAIDEDEModel;
    private PSSysEAIDEDAO pSSysEAIDEDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIDEService";
    }

    public PSSysEAIDEDEModel getPSSysEAIDEDEModel() {
        if (this.pSSysEAIDEDEModel == null) {
            try {
                this.pSSysEAIDEDEModel = (PSSysEAIDEDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.eaidesign.demodel.PSSysEAIDEDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysEAIDEDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysEAIDEDEModel();
    }

    public PSSysEAIDEDAO getPSSysEAIDEDAO() {
        if (this.pSSysEAIDEDAO == null) {
            try {
                this.pSSysEAIDEDAO = (PSSysEAIDEDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.eaidesign.dao.PSSysEAIDEDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysEAIDEDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysEAIDEDAO();
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

    protected void onFillParentInfo(PSSysEAIDE pSSysEAIDE, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSEAIDE_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDataEntity);
            } else {
                iService.get(pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSSysEAIDE, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSEAIDE_PSSYSEAIELEMENT_PSSYSEAIELEMENTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIElementService", (SessionFactory)this.getSessionFactory());
            PSSysEAIElement pSSysEAIElement = (PSSysEAIElement)iService.getDEModel().createEntity();
            pSSysEAIElement.set("PSSYSEAIELEMENTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysEAIElement);
            } else {
                iService.get(pSSysEAIElement);
            }
            this.onFillParentInfo_PSSysEAIElement(pSSysEAIDE, pSSysEAIElement);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSEAIDE_PSSYSEAISCHEME_PSSYSEAISCHEMEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.eaidesign.service.PSSysEAISchemeService", (SessionFactory)this.getSessionFactory());
            PSSysEAIScheme pSSysEAIScheme = (PSSysEAIScheme)iService.getDEModel().createEntity();
            pSSysEAIScheme.set("PSSYSEAISCHEMEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysEAIScheme);
            } else {
                iService.get(pSSysEAIScheme);
            }
            this.onFillParentInfo_PSSysEAIScheme(pSSysEAIDE, pSSysEAIScheme);
            return;
        }
        super.onFillParentInfo(pSSysEAIDE, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDE(PSSysEAIDE pSSysEAIDE, PSDataEntity pSDataEntity) throws Exception {
        pSSysEAIDE.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSSysEAIDE.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_PSSysEAIElement(PSSysEAIDE pSSysEAIDE, PSSysEAIElement pSSysEAIElement) throws Exception {
        pSSysEAIDE.setPSSysEAIElementId(pSSysEAIElement.getPSSysEAIElementId());
        pSSysEAIDE.setPSSysEAIElementName(pSSysEAIElement.getPSSysEAIElementName());
    }

    protected void onFillParentInfo_PSSysEAIScheme(PSSysEAIDE pSSysEAIDE, PSSysEAIScheme pSSysEAIScheme) throws Exception {
        pSSysEAIDE.setPSSysEAISchemeId(pSSysEAIScheme.getPSSysEAISchemeId());
        pSSysEAIDE.setPSSysEAISchemeName(pSSysEAIScheme.getPSSysEAISchemeName());
    }

    protected void onFillEntityFullInfo(PSSysEAIDE pSSysEAIDE, boolean bl) throws Exception {
        if (bl) {
            if (pSSysEAIDE.getCodeName() == null) {
                pSSysEAIDE.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "EAIDE", 25));
            }
            if (pSSysEAIDE.getPSSysEAIDEName() == null) {
                pSSysEAIDE.setPSSysEAIDEName((String)this.getDefaultValue(this.getWebContext(), "USER", "\u96c6\u6210\u5b9e\u4f53", 25));
            }
            if (pSSysEAIDE.getValidFlag() == null) {
                pSSysEAIDE.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo(pSSysEAIDE, bl);
        this.onFillEntityFullInfo_PSDE(pSSysEAIDE, bl);
        this.onFillEntityFullInfo_PSSysEAIElement(pSSysEAIDE, bl);
        this.onFillEntityFullInfo_PSSysEAIScheme(pSSysEAIDE, bl);
    }

    protected void onFillEntityFullInfo_PSDE(PSSysEAIDE pSSysEAIDE, boolean bl) throws Exception {
        if (pSSysEAIDE.isPSDEIdDirty()) {
            if (pSSysEAIDE.getPSDEId() != null) {
                if (pSSysEAIDE.getPSDEId() == null || pSSysEAIDE.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSSysEAIDE.getPSDE();
                    pSSysEAIDE.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSSysEAIDE.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysEAIElement(PSSysEAIDE pSSysEAIDE, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysEAIScheme(PSSysEAIDE pSSysEAIDE, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysEAIDE pSSysEAIDE, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysEAIDE, bl);
    }

    public ArrayList<PSSysEAIDE> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSSysEAIDE> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSSysEAIDE> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysEAIDE> selectByPSSysEAIElement(PSSysEAIElementBase pSSysEAIElementBase) throws Exception {
        return this.selectByPSSysEAIElement(pSSysEAIElementBase, "", -1);
    }

    public ArrayList<PSSysEAIDE> selectByPSSysEAIElement(PSSysEAIElementBase pSSysEAIElementBase, String string) throws Exception {
        return this.selectByPSSysEAIElement(pSSysEAIElementBase, string, -1);
    }

    public ArrayList<PSSysEAIDE> selectByPSSysEAIElement(PSSysEAIElementBase pSSysEAIElementBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSEAIELEMENTID", (Object)pSSysEAIElementBase.getPSSysEAIElementId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysEAIElementCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysEAIElementCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysEAIDE> selectByPSSysEAIScheme(PSSysEAISchemeBase pSSysEAISchemeBase) throws Exception {
        return this.selectByPSSysEAIScheme(pSSysEAISchemeBase, "", -1);
    }

    public ArrayList<PSSysEAIDE> selectByPSSysEAIScheme(PSSysEAISchemeBase pSSysEAISchemeBase, String string) throws Exception {
        return this.selectByPSSysEAIScheme(pSSysEAISchemeBase, string, -1);
    }

    public ArrayList<PSSysEAIDE> selectByPSSysEAIScheme(PSSysEAISchemeBase pSSysEAISchemeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSEAISCHEMEID", (Object)pSSysEAISchemeBase.getPSSysEAISchemeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysEAISchemeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysEAISchemeCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysEAIDE> arrayList = this.selectByPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSEAIDE_PSDATAENTITY_PSDEID", "", iDataEntityModel.getName(), "PSSYSEAIDE", iDataEntityModel.getDataInfo(pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysEAIDE> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSSysEAIDE pSSysEAIDE : arrayList) {
            PSSysEAIDE pSSysEAIDE2 = (PSSysEAIDE)this.getDEModel().createEntity();
            pSSysEAIDE2.setPSSysEAIDEId(pSSysEAIDE.getPSSysEAIDEId());
            pSSysEAIDE2.setPSDEId(null);
            this.update(pSSysEAIDE2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysEAIDEServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSSysEAIDEServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSSysEAIDEServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysEAIDE> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSSysEAIDE pSSysEAIDE : arrayList) {
            this.remove(pSSysEAIDE);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysEAIDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysEAIDE> arrayList) throws Exception {
    }

    public void testRemoveByPSSysEAIElement(PSSysEAIElement pSSysEAIElement) throws Exception {
        ArrayList<PSSysEAIDE> arrayList = this.selectByPSSysEAIElement(pSSysEAIElement, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSEAIELEMENT");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysEAIElement);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSEAIDE_PSSYSEAIELEMENT_PSSYSEAIELEMENTID", "", iDataEntityModel.getName(), "PSSYSEAIDE", iDataEntityModel.getDataInfo(pSSysEAIElement), arrayList.get(0)));
        }
    }

    public void resetPSSysEAIElement(PSSysEAIElement pSSysEAIElement) throws Exception {
        ArrayList<PSSysEAIDE> arrayList = this.selectByPSSysEAIElement(pSSysEAIElement);
        for (PSSysEAIDE pSSysEAIDE : arrayList) {
            PSSysEAIDE pSSysEAIDE2 = (PSSysEAIDE)this.getDEModel().createEntity();
            pSSysEAIDE2.setPSSysEAIDEId(pSSysEAIDE.getPSSysEAIDEId());
            pSSysEAIDE2.setPSSysEAIElementId(null);
            this.update(pSSysEAIDE2);
        }
    }

    public void removeByPSSysEAIElement(PSSysEAIElement pSSysEAIElement) throws Exception {
        final PSSysEAIElement pSSysEAIElement2 = pSSysEAIElement;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysEAIDEServiceBase.this.onBeforeRemoveByPSSysEAIElement(pSSysEAIElement2);
                PSSysEAIDEServiceBase.this.internalRemoveByPSSysEAIElement(pSSysEAIElement2);
                PSSysEAIDEServiceBase.this.onAfterRemoveByPSSysEAIElement(pSSysEAIElement2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysEAIElement(PSSysEAIElement pSSysEAIElement) throws Exception {
    }

    protected void internalRemoveByPSSysEAIElement(PSSysEAIElement pSSysEAIElement) throws Exception {
        ArrayList<PSSysEAIDE> arrayList = this.selectByPSSysEAIElement(pSSysEAIElement);
        this.onBeforeRemoveByPSSysEAIElement(pSSysEAIElement, arrayList);
        for (PSSysEAIDE pSSysEAIDE : arrayList) {
            this.remove(pSSysEAIDE);
        }
        this.onAfterRemoveByPSSysEAIElement(pSSysEAIElement, arrayList);
    }

    protected void onAfterRemoveByPSSysEAIElement(PSSysEAIElement pSSysEAIElement) throws Exception {
    }

    protected void onBeforeRemoveByPSSysEAIElement(PSSysEAIElement pSSysEAIElement, ArrayList<PSSysEAIDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysEAIElement(PSSysEAIElement pSSysEAIElement, ArrayList<PSSysEAIDE> arrayList) throws Exception {
    }

    public void testRemoveByPSSysEAIScheme(PSSysEAIScheme pSSysEAIScheme) throws Exception {
        ArrayList<PSSysEAIDE> arrayList = this.selectByPSSysEAIScheme(pSSysEAIScheme, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSEAISCHEME");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysEAIScheme);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSEAIDE_PSSYSEAISCHEME_PSSYSEAISCHEMEID", "", iDataEntityModel.getName(), "PSSYSEAIDE", iDataEntityModel.getDataInfo(pSSysEAIScheme), arrayList.get(0)));
        }
    }

    public void resetPSSysEAIScheme(PSSysEAIScheme pSSysEAIScheme) throws Exception {
        ArrayList<PSSysEAIDE> arrayList = this.selectByPSSysEAIScheme(pSSysEAIScheme);
        for (PSSysEAIDE pSSysEAIDE : arrayList) {
            PSSysEAIDE pSSysEAIDE2 = (PSSysEAIDE)this.getDEModel().createEntity();
            pSSysEAIDE2.setPSSysEAIDEId(pSSysEAIDE.getPSSysEAIDEId());
            pSSysEAIDE2.setPSSysEAISchemeId(null);
            this.update(pSSysEAIDE2);
        }
    }

    public void removeByPSSysEAIScheme(PSSysEAIScheme pSSysEAIScheme) throws Exception {
        final PSSysEAIScheme pSSysEAIScheme2 = pSSysEAIScheme;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysEAIDEServiceBase.this.onBeforeRemoveByPSSysEAIScheme(pSSysEAIScheme2);
                PSSysEAIDEServiceBase.this.internalRemoveByPSSysEAIScheme(pSSysEAIScheme2);
                PSSysEAIDEServiceBase.this.onAfterRemoveByPSSysEAIScheme(pSSysEAIScheme2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysEAIScheme(PSSysEAIScheme pSSysEAIScheme) throws Exception {
    }

    protected void internalRemoveByPSSysEAIScheme(PSSysEAIScheme pSSysEAIScheme) throws Exception {
        ArrayList<PSSysEAIDE> arrayList = this.selectByPSSysEAIScheme(pSSysEAIScheme);
        this.onBeforeRemoveByPSSysEAIScheme(pSSysEAIScheme, arrayList);
        for (PSSysEAIDE pSSysEAIDE : arrayList) {
            this.remove(pSSysEAIDE);
        }
        this.onAfterRemoveByPSSysEAIScheme(pSSysEAIScheme, arrayList);
    }

    protected void onAfterRemoveByPSSysEAIScheme(PSSysEAIScheme pSSysEAIScheme) throws Exception {
    }

    protected void onBeforeRemoveByPSSysEAIScheme(PSSysEAIScheme pSSysEAIScheme, ArrayList<PSSysEAIDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysEAIScheme(PSSysEAIScheme pSSysEAIScheme, ArrayList<PSSysEAIDE> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysEAIDE pSSysEAIDE) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysEAIDEFieldService)ServiceGlobal.getService(PSSysEAIDEFieldService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysEAIDEFieldServiceBase)pSCoreSysServiceBase).testRemoveByPSSysEAIDE(pSSysEAIDE);
        ((PSSysEAIDEFieldServiceBase)pSCoreSysServiceBase).removeByPSSysEAIDE(pSSysEAIDE);
        pSCoreSysServiceBase = (PSSysEAIDERService)ServiceGlobal.getService(PSSysEAIDERService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysEAIDERServiceBase)pSCoreSysServiceBase).testRemoveByPSSysEAIDE(pSSysEAIDE);
        ((PSSysEAIDERServiceBase)pSCoreSysServiceBase).removeByPSSysEAIDE(pSSysEAIDE);
        super.onBeforeRemove(pSSysEAIDE);
    }

    protected void onBeforeRemoveTemp(PSSysEAIDE pSSysEAIDE) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysEAIDERService)ServiceGlobal.getService(PSSysEAIDERService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysEAIDERServiceBase)pSCoreSysServiceBase).removeTempByPSSysEAIDE(pSSysEAIDE);
        pSCoreSysServiceBase = (PSSysEAIDEFieldService)ServiceGlobal.getService(PSSysEAIDEFieldService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysEAIDEFieldServiceBase)pSCoreSysServiceBase).removeTempByPSSysEAIDE(pSSysEAIDE);
        super.onBeforeRemoveTemp(pSSysEAIDE);
    }

    protected void getRelatedDataTempMajor(PSSysEAIDE pSSysEAIDE) throws Exception {
        this.getRelatedDataTempMajor_PSSysEAIDEField(pSSysEAIDE);
        this.getRelatedDataTempMajor_PSSysEAIDER(pSSysEAIDE);
        super.getRelatedDataTempMajor(pSSysEAIDE);
    }

    protected void getRelatedDataTempMajor_PSSysEAIDEField(PSSysEAIDE pSSysEAIDE) throws Exception {
        PSSysEAIDEFieldService pSSysEAIDEFieldService = (PSSysEAIDEFieldService)ServiceGlobal.getService(PSSysEAIDEFieldService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysEAIDEField> arrayList = null;
        String string = pSSysEAIDE.getPSSysEAIDEId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSSysEAIDEFieldService.selectByPSSysEAIDE(pSSysEAIDE) : pSSysEAIDEFieldService.selectTempByPSSysEAIDE(pSSysEAIDE);
        for (PSSysEAIDEField pSSysEAIDEField : arrayList) {
            pSSysEAIDEFieldService.getTempMajor(pSSysEAIDEField);
        }
    }

    protected void getRelatedDataTempMajor_PSSysEAIDER(PSSysEAIDE pSSysEAIDE) throws Exception {
        PSSysEAIDERService pSSysEAIDERService = (PSSysEAIDERService)ServiceGlobal.getService(PSSysEAIDERService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysEAIDER> arrayList = null;
        String string = pSSysEAIDE.getPSSysEAIDEId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSSysEAIDERService.selectByPSSysEAIDE(pSSysEAIDE) : pSSysEAIDERService.selectTempByPSSysEAIDE(pSSysEAIDE);
        for (PSSysEAIDER pSSysEAIDER : arrayList) {
            pSSysEAIDERService.getTempMajor(pSSysEAIDER);
        }
    }

    protected void updateRelatedDataTempMajor(PSSysEAIDE pSSysEAIDE, PSSysEAIDE pSSysEAIDE2) throws Exception {
        ArrayList<PSSysEAIDER> arrayList = this.updateRelatedDataTempMajor_removePSSysEAIDER(pSSysEAIDE, pSSysEAIDE2);
        ArrayList<PSSysEAIDEField> arrayList2 = this.updateRelatedDataTempMajor_removePSSysEAIDEField(pSSysEAIDE, pSSysEAIDE2);
        this.updateRelatedDataTempMajor_updatePSSysEAIDEField(pSSysEAIDE, pSSysEAIDE2, arrayList2);
        this.updateRelatedDataTempMajor_updatePSSysEAIDER(pSSysEAIDE, pSSysEAIDE2, arrayList);
        super.updateRelatedDataTempMajor(pSSysEAIDE, pSSysEAIDE2);
    }

    protected ArrayList<PSSysEAIDEField> updateRelatedDataTempMajor_removePSSysEAIDEField(PSSysEAIDE pSSysEAIDE, PSSysEAIDE pSSysEAIDE2) throws Exception {
        PSSysEAIDEFieldService pSSysEAIDEFieldService = (PSSysEAIDEFieldService)ServiceGlobal.getService(PSSysEAIDEFieldService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysEAIDEField> arrayList = pSSysEAIDEFieldService.selectTempByPSSysEAIDE(pSSysEAIDE);
        ArrayList<PSSysEAIDEField> arrayList2 = pSSysEAIDEFieldService.selectByPSSysEAIDE(pSSysEAIDE2);
        HashMap<String, PSSysEAIDEField> hashMap = new HashMap<String, PSSysEAIDEField>();
        for (PSSysEAIDEField pSSysEAIDEField : arrayList2) {
            hashMap.put(pSSysEAIDEField.getPSSysEAIDEFieldId(), pSSysEAIDEField);
        }
        for (PSSysEAIDEField pSSysEAIDEField : arrayList) {
            Object object = pSSysEAIDEField.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSSysEAIDEField pSSysEAIDEField : hashMap.values()) {
            pSSysEAIDEFieldService.remove(pSSysEAIDEField);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSSysEAIDEField(PSSysEAIDE pSSysEAIDE, PSSysEAIDE pSSysEAIDE2, ArrayList<PSSysEAIDEField> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSSysEAIDEFieldService pSSysEAIDEFieldService = (PSSysEAIDEFieldService)ServiceGlobal.getService(PSSysEAIDEFieldService.class, (SessionFactory)this.getSessionFactory());
        for (PSSysEAIDEField pSSysEAIDEField : arrayList) {
            pSSysEAIDEFieldService.updateTempMajor(pSSysEAIDEField);
        }
    }

    protected ArrayList<PSSysEAIDER> updateRelatedDataTempMajor_removePSSysEAIDER(PSSysEAIDE pSSysEAIDE, PSSysEAIDE pSSysEAIDE2) throws Exception {
        PSSysEAIDERService pSSysEAIDERService = (PSSysEAIDERService)ServiceGlobal.getService(PSSysEAIDERService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysEAIDER> arrayList = pSSysEAIDERService.selectTempByPSSysEAIDE(pSSysEAIDE);
        ArrayList<PSSysEAIDER> arrayList2 = pSSysEAIDERService.selectByPSSysEAIDE(pSSysEAIDE2);
        HashMap<String, PSSysEAIDER> hashMap = new HashMap<String, PSSysEAIDER>();
        for (PSSysEAIDER pSSysEAIDER : arrayList2) {
            hashMap.put(pSSysEAIDER.getPSSysEAIDERId(), pSSysEAIDER);
        }
        for (PSSysEAIDER pSSysEAIDER : arrayList) {
            Object object = pSSysEAIDER.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSSysEAIDER pSSysEAIDER : hashMap.values()) {
            pSSysEAIDERService.remove(pSSysEAIDER);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSSysEAIDER(PSSysEAIDE pSSysEAIDE, PSSysEAIDE pSSysEAIDE2, ArrayList<PSSysEAIDER> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSSysEAIDERService pSSysEAIDERService = (PSSysEAIDERService)ServiceGlobal.getService(PSSysEAIDERService.class, (SessionFactory)this.getSessionFactory());
        for (PSSysEAIDER pSSysEAIDER : arrayList) {
            pSSysEAIDERService.updateTempMajor(pSSysEAIDER);
        }
    }

    protected void replaceParentInfo(PSSysEAIDE pSSysEAIDE, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysEAIDE, cloneSession);
        if (pSSysEAIDE.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSSysEAIDE.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSSysEAIDE, (PSDataEntity)iEntity);
        }
        if (pSSysEAIDE.getPSSysEAIElementId() != null && (iEntity = cloneSession.getEntity("PSSYSEAIELEMENT", (Object)pSSysEAIDE.getPSSysEAIElementId())) != null) {
            this.onFillParentInfo_PSSysEAIElement(pSSysEAIDE, (PSSysEAIElement)iEntity);
        }
        if (pSSysEAIDE.getPSSysEAISchemeId() != null && (iEntity = cloneSession.getEntity("PSSYSEAISCHEME", (Object)pSSysEAIDE.getPSSysEAISchemeId())) != null) {
            this.onFillParentInfo_PSSysEAIScheme(pSSysEAIDE, (PSSysEAIScheme)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysEAIDE pSSysEAIDE, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysEAIDE, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysEAIDE pSSysEAIDE, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSSysEAIDE, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EAIDETag(bl, pSSysEAIDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EAIDETag2(bl, pSSysEAIDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysEAIDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSSysEAIDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSSysEAIDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysEAIDEId(bl, pSSysEAIDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysEAIDEName(bl, pSSysEAIDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysEAIElementId(bl, pSSysEAIDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysEAISchemeId(bl, pSSysEAIDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysEAIDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysEAIDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysEAIDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysEAIDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysEAIDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSysEAIDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysEAIDE, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysEAIDE pSSysEAIDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDE.isCodeNameDirty() && !bl2 : !pSSysEAIDE.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysEAIDE.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSSysEAIDE, bl2, bl3);
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
                string3 = "PSSYSEAISCHEMEID";
                String string4 = this.checkFieldDupRule(this.getPSSysEAIDEDEModel(), "CODENAME", string3, pSSysEAIDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_EAIDETag(boolean bl, PSSysEAIDE pSSysEAIDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDE.isEAIDETagDirty() : !pSSysEAIDE.isEAIDETagDirty()) {
            return null;
        }
        String string = pSSysEAIDE.getEAIDETag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EAIDETag_Default(pSSysEAIDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EAIDETAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EAIDETag2(boolean bl, PSSysEAIDE pSSysEAIDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDE.isEAIDETag2Dirty() : !pSSysEAIDE.isEAIDETag2Dirty()) {
            return null;
        }
        String string = pSSysEAIDE.getEAIDETag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EAIDETag2_Default(pSSysEAIDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EAIDETAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysEAIDE pSSysEAIDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDE.isMemoDirty() : !pSSysEAIDE.isMemoDirty()) {
            return null;
        }
        String string = pSSysEAIDE.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysEAIDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSSysEAIDE pSSysEAIDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDE.isPSDEIdDirty() && !bl2 : !pSSysEAIDE.isPSDEIdDirty()) {
            return null;
        }
        String string = pSSysEAIDE.getPSDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default(pSSysEAIDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSSysEAIDE pSSysEAIDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDE.isPSDENameDirty() : !pSSysEAIDE.isPSDENameDirty()) {
            return null;
        }
        String string = pSSysEAIDE.getPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default(pSSysEAIDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysEAIDEId(boolean bl, PSSysEAIDE pSSysEAIDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDE.isPSSysEAIDEIdDirty() && !bl2 : !pSSysEAIDE.isPSSysEAIDEIdDirty()) {
            return null;
        }
        String string = pSSysEAIDE.getPSSysEAIDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSEAIDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysEAIDEId_Default(pSSysEAIDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSEAIDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysEAIDEName(boolean bl, PSSysEAIDE pSSysEAIDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDE.isPSSysEAIDENameDirty() && !bl2 : !pSSysEAIDE.isPSSysEAIDENameDirty()) {
            return null;
        }
        String string = pSSysEAIDE.getPSSysEAIDEName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSEAIDENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysEAIDEName_Default(pSSysEAIDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSEAIDENAME");
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
                string3 = "PSSYSEAISCHEMEID";
                String string4 = this.checkFieldDupRule(this.getPSSysEAIDEDEModel(), "PSSYSEAIDENAME", string3, pSSysEAIDE, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSEAIDENAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysEAIElementId(boolean bl, PSSysEAIDE pSSysEAIDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDE.isPSSysEAIElementIdDirty() && !bl2 : !pSSysEAIDE.isPSSysEAIElementIdDirty()) {
            return null;
        }
        String string = pSSysEAIDE.getPSSysEAIElementId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSEAIELEMENTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysEAIElementId_Default(pSSysEAIDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSEAIELEMENTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysEAISchemeId(boolean bl, PSSysEAIDE pSSysEAIDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDE.isPSSysEAISchemeIdDirty() && !bl2 : !pSSysEAIDE.isPSSysEAISchemeIdDirty()) {
            return null;
        }
        String string = pSSysEAIDE.getPSSysEAISchemeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSEAISCHEMEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysEAISchemeId_Default(pSSysEAIDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSEAISCHEMEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysEAIDE pSSysEAIDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDE.isUserCatDirty() : !pSSysEAIDE.isUserCatDirty()) {
            return null;
        }
        String string = pSSysEAIDE.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSSysEAIDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysEAIDE pSSysEAIDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDE.isUserTagDirty() : !pSSysEAIDE.isUserTagDirty()) {
            return null;
        }
        String string = pSSysEAIDE.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSSysEAIDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysEAIDE pSSysEAIDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDE.isUserTag2Dirty() : !pSSysEAIDE.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysEAIDE.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSSysEAIDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysEAIDE pSSysEAIDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDE.isUserTag3Dirty() : !pSSysEAIDE.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysEAIDE.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSSysEAIDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysEAIDE pSSysEAIDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDE.isUserTag4Dirty() : !pSSysEAIDE.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysEAIDE.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSSysEAIDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSysEAIDE pSSysEAIDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDE.isValidFlagDirty() && !bl2 : !pSSysEAIDE.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSysEAIDE.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSSysEAIDE, bl2, bl3);
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

    protected void onSyncEntity(PSSysEAIDE pSSysEAIDE, boolean bl) throws Exception {
        super.onSyncEntity(pSSysEAIDE, bl);
    }

    protected void onSyncIndexEntities(PSSysEAIDE pSSysEAIDE, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysEAIDE, bl);
    }

    public Object getDataContextValue(PSSysEAIDE pSSysEAIDE, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysEAIDE, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysEAIScheme pSSysEAIScheme = pSSysEAIDE.getPSSysEAIScheme();
        if (pSSysEAIScheme != null && pSSysEAIScheme.contains(string)) {
            return pSSysEAIScheme.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysEAIDE pSSysEAIDE, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysEAIDE, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"EAIDETAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EAIDETag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EAIDETAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EAIDETag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSEAIDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysEAIDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSEAIDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysEAIDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSEAIELEMENTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysEAIElementId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSEAIELEMENTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysEAIElementName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSEAISCHEMEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysEAISchemeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSEAISCHEMENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysEAISchemeName_Default(iEntity, bl, bl2);
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
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false) && this.checkFieldRegExRule("CODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected String onTestValueRule_EAIDETag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EAIDETAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EAIDETag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EAIDETAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
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

    protected String onTestValueRule_PSSysEAIDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSEAIDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysEAIDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSEAIDENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysEAIElementId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSEAIELEMENTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysEAIElementName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSEAIELEMENTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysEAISchemeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSEAISCHEMEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysEAISchemeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSEAISCHEMENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSSysEAIDE pSSysEAIDE) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysEAIDE)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysEAIDE pSSysEAIDE) throws Exception {
        super.onUpdateParent(pSSysEAIDE);
    }

    protected void onCopyDetails(PSSysEAIDE pSSysEAIDE, Object object) throws Exception {
        PSSysEAIDE pSSysEAIDE2 = new PSSysEAIDE();
        pSSysEAIDE2.set("PSSYSEAIDEID", object);
        String string = DataObject.getStringValue((Object)pSSysEAIDE.get("PSSYSEAIDEID"));
        super.onCopyDetails(pSSysEAIDE, object);
    }

    @Override
    protected void exportCurXmlModel(PSSysEAIDE pSSysEAIDE, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSEAIDE");
        if (!bl) {
            pSSysEAIDE.setCreateDate(null);
            pSSysEAIDE.setCreateMan(null);
            pSSysEAIDE.setPSSysEAIDEId(null);
            pSSysEAIDE.setUpdateDate(null);
            pSSysEAIDE.setUpdateMan(null);
            super.exportCurXmlModel(pSSysEAIDE, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSSysEAIDE pSSysEAIDE, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSSysEAIDEField(pSSysEAIDE, xmlNode);
        this.exportRelatedXmlModel_PSSysEAIDER(pSSysEAIDE, xmlNode);
        super.onExportRelatedXmlModel(pSSysEAIDE, xmlNode);
    }

    protected void exportRelatedXmlModel_PSSysEAIDEField(PSSysEAIDE pSSysEAIDE, XmlNode xmlNode) throws Exception {
        PSSysEAIDEFieldService pSSysEAIDEFieldService = (PSSysEAIDEFieldService)ServiceGlobal.getService(PSSysEAIDEFieldService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysEAIDEField> arrayList = null;
        String string = pSSysEAIDE.getPSSysEAIDEId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSSysEAIDEFieldService.selectByPSSysEAIDE(pSSysEAIDE) : pSSysEAIDEFieldService.selectTempByPSSysEAIDE(pSSysEAIDE);
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSSYSEAIDEFIELDS");
            xmlNode.addNode(xmlNode2);
            for (PSSysEAIDEField pSSysEAIDEField : arrayList) {
                pSSysEAIDEFieldService.exportXmlModel(pSSysEAIDEField, xmlNode2);
            }
        }
    }

    protected void exportRelatedXmlModel_PSSysEAIDER(PSSysEAIDE pSSysEAIDE, XmlNode xmlNode) throws Exception {
        PSSysEAIDERService pSSysEAIDERService = (PSSysEAIDERService)ServiceGlobal.getService(PSSysEAIDERService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysEAIDER> arrayList = null;
        String string = pSSysEAIDE.getPSSysEAIDEId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSSysEAIDERService.selectByPSSysEAIDE(pSSysEAIDE) : pSSysEAIDERService.selectTempByPSSysEAIDE(pSSysEAIDE);
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSSYSEAIDERS");
            xmlNode.addNode(xmlNode2);
            for (PSSysEAIDER pSSysEAIDER : arrayList) {
                pSSysEAIDERService.exportXmlModel(pSSysEAIDER, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSSysEAIDE pSSysEAIDE, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSSYSEAIDEFIELDS");
        this.importRelatedXmlModel_PSSysEAIDEField(pSSysEAIDE, xmlNode2);
        XmlNode xmlNode3 = xmlNode.getChildNodeByNodeName("PSSYSEAIDERS");
        this.importRelatedXmlModel_PSSysEAIDER(pSSysEAIDE, xmlNode3);
        super.onImportRelatedXmlModel(pSSysEAIDE, xmlNode);
    }

    protected void importRelatedXmlModel_PSSysEAIDEField(PSSysEAIDE pSSysEAIDE, XmlNode xmlNode) throws Exception {
        PSSysEAIDEFieldService pSSysEAIDEFieldService = (PSSysEAIDEFieldService)ServiceGlobal.getService(PSSysEAIDEFieldService.class, (SessionFactory)this.getSessionFactory());
        String string = pSSysEAIDE.getPSSysEAIDEId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSSysEAIDEFieldService.removeByPSSysEAIDE(pSSysEAIDE);
        } else {
            pSSysEAIDEFieldService.removeTempByPSSysEAIDE(pSSysEAIDE);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSSysEAIDEField pSSysEAIDEField = new PSSysEAIDEField();
                pSSysEAIDEFieldService.fillParentInfo(pSSysEAIDEField, "DER1N", "DER1N_PSSYSEAIDEFIELD_PSSYSEAIDE_PSSYSEAIDEID", pSSysEAIDE.getPSSysEAIDEId());
                pSSysEAIDEFieldService.importXmlModel(pSSysEAIDEField, xmlNode2);
            }
        }
    }

    protected void importRelatedXmlModel_PSSysEAIDER(PSSysEAIDE pSSysEAIDE, XmlNode xmlNode) throws Exception {
        PSSysEAIDERService pSSysEAIDERService = (PSSysEAIDERService)ServiceGlobal.getService(PSSysEAIDERService.class, (SessionFactory)this.getSessionFactory());
        String string = pSSysEAIDE.getPSSysEAIDEId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSSysEAIDERService.removeByPSSysEAIDE(pSSysEAIDE);
        } else {
            pSSysEAIDERService.removeTempByPSSysEAIDE(pSSysEAIDE);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSSysEAIDER pSSysEAIDER = new PSSysEAIDER();
                pSSysEAIDERService.fillParentInfo(pSSysEAIDER, "DER1N", "DER1N_PSSYSEAIDER_PSSYSEAIDE_PSSYSEAIDEID", pSSysEAIDE.getPSSysEAIDEId());
                pSSysEAIDERService.importXmlModel(pSSysEAIDER, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysEAIDE pSSysEAIDE, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysEAIDE, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSEAISCHEMEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSEAISCHEME#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSEAISCHEMEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSEAIDE_PSSYSEAISCHEME_PSSYSEAISCHEMEID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSEAISCHEMEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSEAISCHEMENAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSYSEAISCHEME", (boolean)true) == 0) {
            iEntity.set("PSSYSEAISCHEMEID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSSYSEAISCHEMEID"};
    }

    @Override
    public String getModelV2Tag(PSSysEAIDE pSSysEAIDE) {
        if (!StringHelper.isNullOrEmpty((String)pSSysEAIDE.getCodeName())) {
            return pSSysEAIDE.getCodeName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysEAIDE.getPSSysEAIDEName())) {
            return pSSysEAIDE.getPSSysEAIDEName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysEAIDE.getCodeName())) {
            return pSSysEAIDE.getCodeName();
        }
        return super.getModelV2Tag(pSSysEAIDE);
    }

    @Override
    public boolean setModelV2Tag(PSSysEAIDE pSSysEAIDE, String string) {
        pSSysEAIDE.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSSYSEAIDENAME", "");
        map.put("CODENAME", "");
        map.put("PSSYSEAISCHEMEID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysEAIDE pSSysEAIDE, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysEAIDE.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysEAIDE, true);
        pSSysEAIDE.set("CODENAME", string);
        if (this.select(pSSysEAIDE, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysEAIDE, true);
        return super.getModelV2Entity(pSSysEAIDE, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysEAIDE pSSysEAIDE, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysEAIDE, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSSYSEAIDEFIELD_PSSYSEAIDE_PSSYSEAIDEID", (String)string, (boolean)true) == 0) {
            return false;
        }
        return StringHelper.compare((String)"DER1N_PSSYSEAIDER_PSSYSEAIDE_PSSYSEAIDEID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSSysEAIDE pSSysEAIDE, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSSysEAIDE, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSSysEAIDE pSSysEAIDE, ObjectNode objectNode, String string, boolean bl) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSYSEAIDEFIELD_PSSYSEAIDE_PSSYSEAIDEID")) {
            pSCoreSysServiceBase = (PSSysEAIDEFieldService)ServiceGlobal.getService(PSSysEAIDEFieldService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<ObjectNode> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                File file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSEAIDE#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSYSEAIDEFIELD", (Object)pSSysEAIDE.getPSSysEAIDEId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSSYSEAIDE#%1$s", (Object)pSSysEAIDE.getPSSysEAIDEId());
                for (PSSysEAIDEField child : ((PSSysEAIDEFieldServiceBase)pSCoreSysServiceBase).selectByPSSysEAIDE(pSSysEAIDE)) {
                    if (StringHelper.compare(scope, ((PSSysEAIDEFieldServiceBase)pSCoreSysServiceBase).getModelV2ResScope(child), false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(child, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                ArrayNode children = objectNode.putArray(pSCoreSysServiceBase.getModelV2Name(false).toLowerCase());
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
                        if (objectNode.has("pssyseaidefieldname")) {
                            string = objectNode.get("pssyseaidefieldname").asText();
                        }
                        if (objectNode2.has("pssyseaidefieldname")) {
                            string2 = objectNode2.get("pssyseaidefieldname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode childNode : arrayList) {
                    PSSysEAIDEField child = new PSSysEAIDEField();
                    PSModelV2Helper.fromJSONObject(child, childNode, false);
                    children.add((JsonNode)pSCoreSysServiceBase.exportModelV2(child, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSYSEAIDER_PSSYSEAIDE_PSSYSEAIDEID")) {
            pSCoreSysServiceBase = (PSSysEAIDERService)ServiceGlobal.getService(PSSysEAIDERService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<ObjectNode> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                File file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSEAIDE#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSYSEAIDER", (Object)pSSysEAIDE.getPSSysEAIDEId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSSYSEAIDE#%1$s", (Object)pSSysEAIDE.getPSSysEAIDEId());
                for (PSSysEAIDER child : ((PSSysEAIDERServiceBase)pSCoreSysServiceBase).selectByPSSysEAIDE(pSSysEAIDE)) {
                    if (StringHelper.compare(scope, ((PSSysEAIDERServiceBase)pSCoreSysServiceBase).getModelV2ResScope(child), false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(child, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                ArrayNode children = objectNode.putArray(pSCoreSysServiceBase.getModelV2Name(false).toLowerCase());
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
                        if (objectNode.has("pssyseaidername")) {
                            string = objectNode.get("pssyseaidername").asText();
                        }
                        if (objectNode2.has("pssyseaidername")) {
                            string2 = objectNode2.get("pssyseaidername").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode childNode : arrayList) {
                    PSSysEAIDER child = new PSSysEAIDER();
                    PSModelV2Helper.fromJSONObject(child, childNode, false);
                    children.add((JsonNode)pSCoreSysServiceBase.exportModelV2(child, string));
                }
            }
        }
        super.onExportCurModelV2(pSSysEAIDE, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSSysEAIDE pSSysEAIDE) throws Exception {
        String string;
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysEAIDEFieldService)ServiceGlobal.getService(PSSysEAIDEFieldService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysEAIDEField> fields = ((PSSysEAIDEFieldServiceBase)pSCoreSysServiceBase).selectByPSSysEAIDE(pSSysEAIDE);
        String string2 = StringHelper.format((String)"PSSYSEAIDE#%1$s", (Object)pSSysEAIDE.getPSSysEAIDEId());
        for (PSSysEAIDEField entityBase : fields) {
            string = ((PSSysEAIDEFieldServiceBase)pSCoreSysServiceBase).getModelV2ResScope(entityBase);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(entityBase);
        }
        SqlParamList object = new SqlParamList();
        object.addString(pSSysEAIDE.getPSSysEAIDEId());
        ((PSSysEAIDEFieldServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSSysEAIDEFieldServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSSYSEAIDEFIELD WHERE PSSYSEAIDEID = ?", (SqlParamList)object);
        pSCoreSysServiceBase = (PSSysEAIDERService)ServiceGlobal.getService(PSSysEAIDERService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysEAIDER> relations = ((PSSysEAIDERServiceBase)pSCoreSysServiceBase).selectByPSSysEAIDE(pSSysEAIDE);
        string2 = StringHelper.format((String)"PSSYSEAIDE#%1$s", (Object)pSSysEAIDE.getPSSysEAIDEId());
        for (PSSysEAIDER pSSysEAIDER : relations) {
            string = ((PSSysEAIDERServiceBase)pSCoreSysServiceBase).getModelV2ResScope(pSSysEAIDER);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(pSSysEAIDER);
        }
        object = new SqlParamList();
        object.addString(pSSysEAIDE.getPSSysEAIDEId());
        ((PSSysEAIDERServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSSysEAIDERServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSSYSEAIDER WHERE PSSYSEAIDEID = ?", (SqlParamList)object);
        super.onEmptyModelV2(pSSysEAIDE);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysEAIDEFieldService)ServiceGlobal.getService(PSSysEAIDEFieldService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSSysEAIDERService)ServiceGlobal.getService(PSSysEAIDERService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSSysEAIDE pSSysEAIDE, String string, String string2) throws Exception {
        IEntity iEntity = null;
        EntityBase entityBase = new PSSysEAIDEField();
        entityBase.set("PSSYSEAIDEID", pSSysEAIDE.getPSSysEAIDEId());
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysEAIDEFieldService)ServiceGlobal.getService(PSSysEAIDEFieldService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSSysEAIDER();
        entityBase.set("PSSYSEAIDEID", pSSysEAIDE.getPSSysEAIDEId());
        pSCoreSysServiceBase = (PSSysEAIDERService)ServiceGlobal.getService(PSSysEAIDERService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSSysEAIDE, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSSysEAIDE pSSysEAIDE, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        int n2;
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysEAIDEFieldService)ServiceGlobal.getService(PSSysEAIDEFieldService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                ObjectNode childNode = (ObjectNode)arrayNode.get(n2);
                PSSysEAIDEField child = new PSSysEAIDEField();
                child.setPSDEId(pSSysEAIDE.getPSDEId());
                child.setPSSysEAIDEId(pSSysEAIDE.getPSSysEAIDEId());
                child.setPSSysEAIDEName(pSSysEAIDE.getPSSysEAIDEName());
                child.setPSSysEAIElementId(pSSysEAIDE.getPSSysEAIElementId());
                pSCoreSysServiceBase.compileModelV2(child, childNode, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File directory = new File(string4);
            if (directory.exists()) {
                for (File childDirectory : directory.listFiles()) {
                    if (!childDirectory.isDirectory()) continue;
                    PSSysEAIDEField child = new PSSysEAIDEField();
                    child.setPSDEId(pSSysEAIDE.getPSDEId());
                    child.setPSSysEAIDEId(pSSysEAIDE.getPSSysEAIDEId());
                    child.setPSSysEAIDEName(pSSysEAIDE.getPSSysEAIDEName());
                    child.setPSSysEAIElementId(pSSysEAIDE.getPSSysEAIElementId());
                    pSCoreSysServiceBase.compileModelV2(child, null, string, childDirectory.getCanonicalPath(), n);
                }
            }
        }
        pSCoreSysServiceBase = (PSSysEAIDERService)ServiceGlobal.getService(PSSysEAIDERService.class, (SessionFactory)this.getSessionFactory());
        arrayNode = null;
        string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                ObjectNode childNode = (ObjectNode)arrayNode.get(n2);
                PSSysEAIDER child = new PSSysEAIDER();
                child.setPSDEId(pSSysEAIDE.getPSDEId());
                child.setPSSysEAIDEId(pSSysEAIDE.getPSSysEAIDEId());
                child.setPSSysEAIDEName(pSSysEAIDE.getPSSysEAIDEName());
                child.setPSSysEAIElementId(pSSysEAIDE.getPSSysEAIElementId());
                pSCoreSysServiceBase.compileModelV2(child, childNode, string, null, n);
            }
        } else {
            String string5 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File directory = new File(string5);
            if (directory.exists()) {
                for (File childDirectory : directory.listFiles()) {
                    if (!childDirectory.isDirectory()) continue;
                    PSSysEAIDER child = new PSSysEAIDER();
                    child.setPSDEId(pSSysEAIDE.getPSDEId());
                    child.setPSSysEAIDEId(pSSysEAIDE.getPSSysEAIDEId());
                    child.setPSSysEAIDEName(pSSysEAIDE.getPSSysEAIDEName());
                    child.setPSSysEAIElementId(pSSysEAIDE.getPSSysEAIElementId());
                    pSCoreSysServiceBase.compileModelV2(child, null, string, childDirectory.getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSSysEAIDE, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSSysEAIDE pSSysEAIDE, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSSYSEAIDEFIELD_PSSYSEAIDE_PSSYSEAIDEID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSSysEAIDEFields(pSSysEAIDE, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSSYSEAIDER_PSSYSEAIDE_PSSYSEAIDEID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSSysEAIDERs(pSSysEAIDE, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSSysEAIDE, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSSysEAIDEFields(PSSysEAIDE pSSysEAIDE, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSSYSEAIDEFIELD", true), (boolean)false) == 0) {
            PSSysEAIDEFieldService pSSysEAIDEFieldService = (PSSysEAIDEFieldService)ServiceGlobal.getService(PSSysEAIDEFieldService.class, (SessionFactory)this.getSessionFactory());
            PSSysEAIDEField pSSysEAIDEField = new PSSysEAIDEField();
            pSSysEAIDEField.setPSSysEAIDEFieldId(pSMOSFile.getPSModelId());
            if (!pSSysEAIDEFieldService.get(pSSysEAIDEField, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSSysEAIDEField.getPSSysEAIDEId(), (String)pSSysEAIDE.getPSSysEAIDEId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSSysEAIDEFieldService.exportModelV2(pSSysEAIDEField);
            pSSysEAIDEField.reset();
            if (!pSSysEAIDEFieldService.setModelV2ResScope(pSSysEAIDEField, "PSSYSEAIDE", pSSysEAIDE.getPSSysEAIDEId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSSysEAIDEFieldService.importModelV2(pSSysEAIDEField, objectNode);
            SessionFactoryManager.commit();
            return pSSysEAIDEFieldService.getFile(pSSysEAIDEField);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSSysEAIDERs(PSSysEAIDE pSSysEAIDE, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSSYSEAIDER", true), (boolean)false) == 0) {
            PSSysEAIDERService pSSysEAIDERService = (PSSysEAIDERService)ServiceGlobal.getService(PSSysEAIDERService.class, (SessionFactory)this.getSessionFactory());
            PSSysEAIDER pSSysEAIDER = new PSSysEAIDER();
            pSSysEAIDER.setPSSysEAIDERId(pSMOSFile.getPSModelId());
            if (!pSSysEAIDERService.get(pSSysEAIDER, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSSysEAIDER.getPSSysEAIDEId(), (String)pSSysEAIDE.getPSSysEAIDEId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSSysEAIDERService.exportModelV2(pSSysEAIDER);
            pSSysEAIDER.reset();
            if (!pSSysEAIDERService.setModelV2ResScope(pSSysEAIDER, "PSSYSEAIDE", pSSysEAIDE.getPSSysEAIDEId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSSysEAIDERService.importModelV2(pSSysEAIDER, objectNode);
            SessionFactoryManager.commit();
            return pSSysEAIDERService.getFile(pSSysEAIDER);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSSysEAIDE pSSysEAIDE, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSSysEAIDEFields(pSSysEAIDE, list);
        this.onFillPasteHelps_PSSysEAIDERs(pSSysEAIDE, list);
        super.onFillPasteHelps(pSSysEAIDE, list);
    }

    protected void onFillPasteHelps_PSSysEAIDEFields(PSSysEAIDE pSSysEAIDE, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSSYSEAIDEFIELD");
        pSHelpSection.setSectionParam2("DER1N_PSSYSEAIDEFIELD_PSSYSEAIDE_PSSYSEAIDEID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u96c6\u6210\u5b9e\u4f53\u6620\u5c04]\u7684[\u96c6\u6210\u5b9e\u4f53\u5c5e\u6027\u6620\u5c04]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSSysEAIDERs(PSSysEAIDE pSSysEAIDE, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSSYSEAIDER");
        pSHelpSection.setSectionParam2("DER1N_PSSYSEAIDER_PSSYSEAIDE_PSSYSEAIDEID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u96c6\u6210\u5b9e\u4f53\u6620\u5c04]\u7684[\u96c6\u6210\u5b9e\u4f53\u5173\u7cfb\u6620\u5c04]");
        list.add(pSHelpSection);
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSSysEAIDE pSSysEAIDE, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "EAIDE");
        defaultValueMap.put("PSSYSEAIDENAME", "\u96c6\u6210\u5b9e\u4f53");
    }
}
