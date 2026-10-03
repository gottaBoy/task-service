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
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeServiceBase;
import net.ibizsys.pscore.srv.eaidesign.dao.PSSysEAIElementDAO;
import net.ibizsys.pscore.srv.eaidesign.demodel.PSSysEAIElementDEModel;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIElement;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIElementAttr;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIElementAttrBase;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIElementRE;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIElementREBase;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIScheme;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAISchemeBase;
import net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIDEService;
import net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIDEServiceBase;
import net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIElementAttrService;
import net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIElementAttrServiceBase;
import net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIElementREService;
import net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIElementREServiceBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysEAIElementServiceBase
extends PSCoreSysServiceBase<PSSysEAIElement> {
    private static final Log log = LogFactory.getLog(PSSysEAIElementServiceBase.class);
    public static final String DATASET_CURSCHEME = "CurScheme";
    public static final String DATASET_CURSCHEMEAG = "CurSchemeAG";
    public static final String DATASET_CURSCHEMECP = "CurSchemeCP";
    public static final String DATASET_CURSCHEMEEG = "CurSchemeEG";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSSysEAIElementDEModel pSSysEAIElementDEModel;
    private PSSysEAIElementDAO pSSysEAIElementDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIElementService";
    }

    public PSSysEAIElementDEModel getPSSysEAIElementDEModel() {
        if (this.pSSysEAIElementDEModel == null) {
            try {
                this.pSSysEAIElementDEModel = (PSSysEAIElementDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.eaidesign.demodel.PSSysEAIElementDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysEAIElementDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysEAIElementDEModel();
    }

    public PSSysEAIElementDAO getPSSysEAIElementDAO() {
        if (this.pSSysEAIElementDAO == null) {
            try {
                this.pSSysEAIElementDAO = (PSSysEAIElementDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.eaidesign.dao.PSSysEAIElementDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysEAIElementDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysEAIElementDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURSCHEME, (boolean)true) == 0) {
            return this.fetchCurScheme(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSCHEMEAG, (boolean)true) == 0) {
            return this.fetchCurSchemeAG(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSCHEMECP, (boolean)true) == 0) {
            return this.fetchCurSchemeCP(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSCHEMEEG, (boolean)true) == 0) {
            return this.fetchCurSchemeEG(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURSCHEME, (boolean)true) == 0) {
            return this.fetchTempCurScheme(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSCHEMEAG, (boolean)true) == 0) {
            return this.fetchTempCurSchemeAG(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSCHEMECP, (boolean)true) == 0) {
            return this.fetchTempCurSchemeCP(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSCHEMEEG, (boolean)true) == 0) {
            return this.fetchTempCurSchemeEG(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchTempDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSetTemp(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurScheme(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSCHEME, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurScheme(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSCHEME, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSchemeAG(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSCHEMEAG, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurSchemeAG(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSCHEMEAG, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSchemeCP(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSCHEMECP, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurSchemeCP(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSCHEMECP, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSchemeEG(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSCHEMEEG, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurSchemeEG(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSCHEMEEG, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, true);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSSysEAIElement pSSysEAIElement, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSEAIELEMENT_PSSYSEAISCHEME_PSSYSEAISCHEMEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.eaidesign.service.PSSysEAISchemeService", (SessionFactory)this.getSessionFactory());
            PSSysEAIScheme pSSysEAIScheme = (PSSysEAIScheme)iService.getDEModel().createEntity();
            pSSysEAIScheme.set("PSSYSEAISCHEMEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysEAIScheme);
            } else {
                iService.get(pSSysEAIScheme);
            }
            this.onFillParentInfo_PSSysEAIScheme(pSSysEAIElement, pSSysEAIScheme);
            return;
        }
        super.onFillParentInfo(pSSysEAIElement, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSysEAIScheme(PSSysEAIElement pSSysEAIElement, PSSysEAIScheme pSSysEAIScheme) throws Exception {
        pSSysEAIElement.setPSSysEAISchemeId(pSSysEAIScheme.getPSSysEAISchemeId());
        pSSysEAIElement.setPSSysEAISchemeName(pSSysEAIScheme.getPSSysEAISchemeName());
    }

    protected void onFillEntityFullInfo(PSSysEAIElement pSSysEAIElement, boolean bl) throws Exception {
        if (bl) {
            if (pSSysEAIElement.getCodeName() == null) {
                pSSysEAIElement.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "Element", 25));
            }
            if (pSSysEAIElement.getPSSysEAIElementName() == null) {
                pSSysEAIElement.setPSSysEAIElementName((String)this.getDefaultValue(this.getWebContext(), "USER", "\u96c6\u6210\u5143\u7d20", 25));
            }
            if (pSSysEAIElement.getValidFlag() == null) {
                pSSysEAIElement.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo(pSSysEAIElement, bl);
        this.onFillEntityFullInfo_PSSysEAIScheme(pSSysEAIElement, bl);
    }

    protected void onFillEntityFullInfo_PSSysEAIScheme(PSSysEAIElement pSSysEAIElement, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysEAIElement pSSysEAIElement, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysEAIElement, bl);
    }

    public ArrayList<PSSysEAIElement> selectByPSSysEAIScheme(PSSysEAISchemeBase pSSysEAISchemeBase) throws Exception {
        return this.selectByPSSysEAIScheme(pSSysEAISchemeBase, "", -1);
    }

    public ArrayList<PSSysEAIElement> selectByPSSysEAIScheme(PSSysEAISchemeBase pSSysEAISchemeBase, String string) throws Exception {
        return this.selectByPSSysEAIScheme(pSSysEAISchemeBase, string, -1);
    }

    public ArrayList<PSSysEAIElement> selectByPSSysEAIScheme(PSSysEAISchemeBase pSSysEAISchemeBase, String string, int n) throws Exception {
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

    public void testRemoveByPSSysEAIScheme(PSSysEAIScheme pSSysEAIScheme) throws Exception {
        ArrayList<PSSysEAIElement> arrayList = this.selectByPSSysEAIScheme(pSSysEAIScheme, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSEAISCHEME");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysEAIScheme);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSEAIELEMENT_PSSYSEAISCHEME_PSSYSEAISCHEMEID", "", iDataEntityModel.getName(), "PSSYSEAIELEMENT", iDataEntityModel.getDataInfo(pSSysEAIScheme), arrayList.get(0)));
        }
    }

    public void resetPSSysEAIScheme(PSSysEAIScheme pSSysEAIScheme) throws Exception {
        ArrayList<PSSysEAIElement> arrayList = this.selectByPSSysEAIScheme(pSSysEAIScheme);
        for (PSSysEAIElement pSSysEAIElement : arrayList) {
            PSSysEAIElement pSSysEAIElement2 = (PSSysEAIElement)this.getDEModel().createEntity();
            pSSysEAIElement2.setPSSysEAIElementId(pSSysEAIElement.getPSSysEAIElementId());
            pSSysEAIElement2.setPSSysEAISchemeId(null);
            this.update(pSSysEAIElement2);
        }
    }

    public void removeByPSSysEAIScheme(PSSysEAIScheme pSSysEAIScheme) throws Exception {
        final PSSysEAIScheme pSSysEAIScheme2 = pSSysEAIScheme;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysEAIElementServiceBase.this.onBeforeRemoveByPSSysEAIScheme(pSSysEAIScheme2);
                PSSysEAIElementServiceBase.this.internalRemoveByPSSysEAIScheme(pSSysEAIScheme2);
                PSSysEAIElementServiceBase.this.onAfterRemoveByPSSysEAIScheme(pSSysEAIScheme2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysEAIScheme(PSSysEAIScheme pSSysEAIScheme) throws Exception {
    }

    protected void internalRemoveByPSSysEAIScheme(PSSysEAIScheme pSSysEAIScheme) throws Exception {
        ArrayList<PSSysEAIElement> arrayList = this.selectByPSSysEAIScheme(pSSysEAIScheme);
        this.onBeforeRemoveByPSSysEAIScheme(pSSysEAIScheme, arrayList);
        for (PSSysEAIElement pSSysEAIElement : arrayList) {
            this.remove(pSSysEAIElement);
        }
        this.onAfterRemoveByPSSysEAIScheme(pSSysEAIScheme, arrayList);
    }

    protected void onAfterRemoveByPSSysEAIScheme(PSSysEAIScheme pSSysEAIScheme) throws Exception {
    }

    protected void onBeforeRemoveByPSSysEAIScheme(PSSysEAIScheme pSSysEAIScheme, ArrayList<PSSysEAIElement> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysEAIScheme(PSSysEAIScheme pSSysEAIScheme, ArrayList<PSSysEAIElement> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysEAIElement pSSysEAIElement) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDELogicNodeService)ServiceGlobal.getService(PSDELogicNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDELogicNodeServiceBase)pSCoreSysServiceBase).testRemoveByPSSysEAIElement(pSSysEAIElement);
        pSCoreSysServiceBase = (PSSysEAIDEService)ServiceGlobal.getService(PSSysEAIDEService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysEAIDEServiceBase)pSCoreSysServiceBase).testRemoveByPSSysEAIElement(pSSysEAIElement);
        pSCoreSysServiceBase = (PSSysEAIElementAttrService)ServiceGlobal.getService(PSSysEAIElementAttrService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysEAIElementAttrServiceBase)pSCoreSysServiceBase).testRemoveByPSSysEAIElement(pSSysEAIElement);
        ((PSSysEAIElementAttrServiceBase)pSCoreSysServiceBase).removeByPSSysEAIElement(pSSysEAIElement);
        pSCoreSysServiceBase = (PSSysEAIElementAttrService)ServiceGlobal.getService(PSSysEAIElementAttrService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysEAIElementAttrServiceBase)pSCoreSysServiceBase).testRemoveByRefPSSysEAIElement(pSSysEAIElement);
        pSCoreSysServiceBase = (PSSysEAIElementREService)ServiceGlobal.getService(PSSysEAIElementREService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysEAIElementREServiceBase)pSCoreSysServiceBase).testRemoveByPSSysEAIElement(pSSysEAIElement);
        ((PSSysEAIElementREServiceBase)pSCoreSysServiceBase).removeByPSSysEAIElement(pSSysEAIElement);
        pSCoreSysServiceBase = (PSSysEAIElementREService)ServiceGlobal.getService(PSSysEAIElementREService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysEAIElementREServiceBase)pSCoreSysServiceBase).testRemoveByRefPSSysEAIElement(pSSysEAIElement);
        super.onBeforeRemove(pSSysEAIElement);
    }

    protected void onBeforeRemoveTemp(PSSysEAIElement pSSysEAIElement) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysEAIElementREService)ServiceGlobal.getService(PSSysEAIElementREService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysEAIElementREServiceBase)pSCoreSysServiceBase).removeTempByPSSysEAIElement(pSSysEAIElement);
        pSCoreSysServiceBase = (PSSysEAIElementAttrService)ServiceGlobal.getService(PSSysEAIElementAttrService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysEAIElementAttrServiceBase)pSCoreSysServiceBase).removeTempByPSSysEAIElement(pSSysEAIElement);
        super.onBeforeRemoveTemp(pSSysEAIElement);
    }

    protected void getRelatedDataTempMajor(PSSysEAIElement pSSysEAIElement) throws Exception {
        this.getRelatedDataTempMajor_PSSysEAIElementAttr(pSSysEAIElement);
        this.getRelatedDataTempMajor_PSSysEAIElementRE(pSSysEAIElement);
        super.getRelatedDataTempMajor(pSSysEAIElement);
    }

    protected void getRelatedDataTempMajor_PSSysEAIElementAttr(PSSysEAIElement pSSysEAIElement) throws Exception {
        PSSysEAIElementAttrService pSSysEAIElementAttrService = (PSSysEAIElementAttrService)ServiceGlobal.getService(PSSysEAIElementAttrService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysEAIElementAttr> arrayList = null;
        String string = pSSysEAIElement.getPSSysEAIElementId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSSysEAIElementAttrService.selectByPSSysEAIElement(pSSysEAIElement) : pSSysEAIElementAttrService.selectTempByPSSysEAIElement(pSSysEAIElement);
        for (PSSysEAIElementAttr pSSysEAIElementAttr : arrayList) {
            pSSysEAIElementAttrService.getTempMajor(pSSysEAIElementAttr);
        }
    }

    protected void getRelatedDataTempMajor_PSSysEAIElementRE(PSSysEAIElement pSSysEAIElement) throws Exception {
        PSSysEAIElementREService pSSysEAIElementREService = (PSSysEAIElementREService)ServiceGlobal.getService(PSSysEAIElementREService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysEAIElementRE> arrayList = null;
        String string = pSSysEAIElement.getPSSysEAIElementId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSSysEAIElementREService.selectByPSSysEAIElement(pSSysEAIElement) : pSSysEAIElementREService.selectTempByPSSysEAIElement(pSSysEAIElement);
        for (PSSysEAIElementRE pSSysEAIElementRE : arrayList) {
            pSSysEAIElementREService.getTempMajor(pSSysEAIElementRE);
        }
    }

    protected void updateRelatedDataTempMajor(PSSysEAIElement pSSysEAIElement, PSSysEAIElement pSSysEAIElement2) throws Exception {
        ArrayList<PSSysEAIElementRE> arrayList = this.updateRelatedDataTempMajor_removePSSysEAIElementRE(pSSysEAIElement, pSSysEAIElement2);
        ArrayList<PSSysEAIElementAttr> arrayList2 = this.updateRelatedDataTempMajor_removePSSysEAIElementAttr(pSSysEAIElement, pSSysEAIElement2);
        this.updateRelatedDataTempMajor_updatePSSysEAIElementAttr(pSSysEAIElement, pSSysEAIElement2, arrayList2);
        this.updateRelatedDataTempMajor_updatePSSysEAIElementRE(pSSysEAIElement, pSSysEAIElement2, arrayList);
        super.updateRelatedDataTempMajor(pSSysEAIElement, pSSysEAIElement2);
    }

    protected ArrayList<PSSysEAIElementAttr> updateRelatedDataTempMajor_removePSSysEAIElementAttr(PSSysEAIElement pSSysEAIElement, PSSysEAIElement pSSysEAIElement2) throws Exception {
        PSSysEAIElementAttrService pSSysEAIElementAttrService = (PSSysEAIElementAttrService)ServiceGlobal.getService(PSSysEAIElementAttrService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysEAIElementAttr> arrayList = pSSysEAIElementAttrService.selectTempByPSSysEAIElement(pSSysEAIElement);
        ArrayList<PSSysEAIElementAttr> arrayList2 = pSSysEAIElementAttrService.selectByPSSysEAIElement(pSSysEAIElement2);
        HashMap<String, PSSysEAIElementAttr> hashMap = new HashMap<String, PSSysEAIElementAttr>();
        for (PSSysEAIElementAttr pSSysEAIElementAttr : arrayList2) {
            hashMap.put(pSSysEAIElementAttr.getPSSysEAIElementAttrId(), pSSysEAIElementAttr);
        }
        for (PSSysEAIElementAttr pSSysEAIElementAttr : arrayList) {
            Object object = pSSysEAIElementAttr.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSSysEAIElementAttr pSSysEAIElementAttr : hashMap.values()) {
            pSSysEAIElementAttrService.remove(pSSysEAIElementAttr);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSSysEAIElementAttr(PSSysEAIElement pSSysEAIElement, PSSysEAIElement pSSysEAIElement2, ArrayList<PSSysEAIElementAttr> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSSysEAIElementAttrService pSSysEAIElementAttrService = (PSSysEAIElementAttrService)ServiceGlobal.getService(PSSysEAIElementAttrService.class, (SessionFactory)this.getSessionFactory());
        for (PSSysEAIElementAttr pSSysEAIElementAttr : arrayList) {
            pSSysEAIElementAttrService.updateTempMajor(pSSysEAIElementAttr);
        }
    }

    protected ArrayList<PSSysEAIElementRE> updateRelatedDataTempMajor_removePSSysEAIElementRE(PSSysEAIElement pSSysEAIElement, PSSysEAIElement pSSysEAIElement2) throws Exception {
        PSSysEAIElementREService pSSysEAIElementREService = (PSSysEAIElementREService)ServiceGlobal.getService(PSSysEAIElementREService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysEAIElementRE> arrayList = pSSysEAIElementREService.selectTempByPSSysEAIElement(pSSysEAIElement);
        ArrayList<PSSysEAIElementRE> arrayList2 = pSSysEAIElementREService.selectByPSSysEAIElement(pSSysEAIElement2);
        HashMap<String, PSSysEAIElementRE> hashMap = new HashMap<String, PSSysEAIElementRE>();
        for (PSSysEAIElementRE pSSysEAIElementRE : arrayList2) {
            hashMap.put(pSSysEAIElementRE.getPSSysEAIElementREId(), pSSysEAIElementRE);
        }
        for (PSSysEAIElementRE pSSysEAIElementRE : arrayList) {
            Object object = pSSysEAIElementRE.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSSysEAIElementRE pSSysEAIElementRE : hashMap.values()) {
            pSSysEAIElementREService.remove(pSSysEAIElementRE);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSSysEAIElementRE(PSSysEAIElement pSSysEAIElement, PSSysEAIElement pSSysEAIElement2, ArrayList<PSSysEAIElementRE> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSSysEAIElementREService pSSysEAIElementREService = (PSSysEAIElementREService)ServiceGlobal.getService(PSSysEAIElementREService.class, (SessionFactory)this.getSessionFactory());
        for (PSSysEAIElementRE pSSysEAIElementRE : arrayList) {
            pSSysEAIElementREService.updateTempMajor(pSSysEAIElementRE);
        }
    }

    protected void replaceParentInfo(PSSysEAIElement pSSysEAIElement, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysEAIElement, cloneSession);
        if (pSSysEAIElement.getPSSysEAISchemeId() != null && (iEntity = cloneSession.getEntity("PSSYSEAISCHEME", (Object)pSSysEAIElement.getPSSysEAISchemeId())) != null) {
            this.onFillParentInfo_PSSysEAIScheme(pSSysEAIElement, (PSSysEAIScheme)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysEAIElement pSSysEAIElement, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysEAIElement, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysEAIElement pSSysEAIElement, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSSysEAIElement, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EAIElementTag(bl, pSSysEAIElement, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EAIElementTag2(bl, pSSysEAIElement, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EAIElementType(bl, pSSysEAIElement, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysEAIElement, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderMode(bl, pSSysEAIElement, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysEAIElementId(bl, pSSysEAIElement, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysEAIElementName(bl, pSSysEAIElement, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysEAISchemeId(bl, pSSysEAIElement, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysEAIElement, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysEAIElement, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysEAIElement, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysEAIElement, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysEAIElement, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSysEAIElement, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysEAIElement, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysEAIElement pSSysEAIElement, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIElement.isCodeNameDirty() && !bl2 : !pSSysEAIElement.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysEAIElement.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSSysEAIElement, bl2, bl3);
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
                String string4 = this.checkFieldDupRule(this.getPSSysEAIElementDEModel(), "CODENAME", string3, pSSysEAIElement, bl2, bl3);
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

    protected EntityFieldError onCheckField_EAIElementTag(boolean bl, PSSysEAIElement pSSysEAIElement, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIElement.isEAIElementTagDirty() : !pSSysEAIElement.isEAIElementTagDirty()) {
            return null;
        }
        String string = pSSysEAIElement.getEAIElementTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EAIElementTag_Default(pSSysEAIElement, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EAIELEMENTTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EAIElementTag2(boolean bl, PSSysEAIElement pSSysEAIElement, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIElement.isEAIElementTag2Dirty() : !pSSysEAIElement.isEAIElementTag2Dirty()) {
            return null;
        }
        String string = pSSysEAIElement.getEAIElementTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EAIElementTag2_Default(pSSysEAIElement, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EAIELEMENTTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EAIElementType(boolean bl, PSSysEAIElement pSSysEAIElement, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIElement.isEAIElementTypeDirty() && !bl2 : !pSSysEAIElement.isEAIElementTypeDirty()) {
            return null;
        }
        String string = pSSysEAIElement.getEAIElementType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EAIELEMENTTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_EAIElementType_Default(pSSysEAIElement, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EAIELEMENTTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysEAIElement pSSysEAIElement, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIElement.isMemoDirty() : !pSSysEAIElement.isMemoDirty()) {
            return null;
        }
        String string = pSSysEAIElement.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysEAIElement, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderMode(boolean bl, PSSysEAIElement pSSysEAIElement, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIElement.isOrderModeDirty() : !pSSysEAIElement.isOrderModeDirty()) {
            return null;
        }
        String string = pSSysEAIElement.getOrderMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OrderMode_Default(pSSysEAIElement, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORDERMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysEAIElementId(boolean bl, PSSysEAIElement pSSysEAIElement, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIElement.isPSSysEAIElementIdDirty() && !bl2 : !pSSysEAIElement.isPSSysEAIElementIdDirty()) {
            return null;
        }
        String string = pSSysEAIElement.getPSSysEAIElementId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSEAIELEMENTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysEAIElementId_Default(pSSysEAIElement, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysEAIElementName(boolean bl, PSSysEAIElement pSSysEAIElement, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIElement.isPSSysEAIElementNameDirty() && !bl2 : !pSSysEAIElement.isPSSysEAIElementNameDirty()) {
            return null;
        }
        String string = pSSysEAIElement.getPSSysEAIElementName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSEAIELEMENTNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysEAIElementName_Default(pSSysEAIElement, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSEAIELEMENTNAME");
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
                String string4 = this.checkFieldDupRule(this.getPSSysEAIElementDEModel(), "PSSYSEAIELEMENTNAME", string3, pSSysEAIElement, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSEAIELEMENTNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysEAISchemeId(boolean bl, PSSysEAIElement pSSysEAIElement, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIElement.isPSSysEAISchemeIdDirty() && !bl2 : !pSSysEAIElement.isPSSysEAISchemeIdDirty()) {
            return null;
        }
        String string = pSSysEAIElement.getPSSysEAISchemeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSEAISCHEMEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysEAISchemeId_Default(pSSysEAIElement, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysEAIElement pSSysEAIElement, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIElement.isUserCatDirty() : !pSSysEAIElement.isUserCatDirty()) {
            return null;
        }
        String string = pSSysEAIElement.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSSysEAIElement, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysEAIElement pSSysEAIElement, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIElement.isUserTagDirty() : !pSSysEAIElement.isUserTagDirty()) {
            return null;
        }
        String string = pSSysEAIElement.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSSysEAIElement, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysEAIElement pSSysEAIElement, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIElement.isUserTag2Dirty() : !pSSysEAIElement.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysEAIElement.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSSysEAIElement, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysEAIElement pSSysEAIElement, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIElement.isUserTag3Dirty() : !pSSysEAIElement.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysEAIElement.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSSysEAIElement, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysEAIElement pSSysEAIElement, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIElement.isUserTag4Dirty() : !pSSysEAIElement.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysEAIElement.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSSysEAIElement, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSysEAIElement pSSysEAIElement, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIElement.isValidFlagDirty() && !bl2 : !pSSysEAIElement.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSysEAIElement.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSSysEAIElement, bl2, bl3);
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

    protected void onSyncEntity(PSSysEAIElement pSSysEAIElement, boolean bl) throws Exception {
        super.onSyncEntity(pSSysEAIElement, bl);
    }

    protected void onSyncIndexEntities(PSSysEAIElement pSSysEAIElement, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysEAIElement, bl);
    }

    public Object getDataContextValue(PSSysEAIElement pSSysEAIElement, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysEAIElement, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysEAIScheme pSSysEAIScheme = pSSysEAIElement.getPSSysEAIScheme();
        if (pSSysEAIScheme != null && pSSysEAIScheme.contains(string)) {
            return pSSysEAIScheme.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysEAIElement pSSysEAIElement, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysEAIElement, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"EAIELEMENTTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EAIElementTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EAIELEMENTTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EAIElementTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EAIELEMENTTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EAIElementType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderMode_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_EAIElementTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EAIELEMENTTAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EAIElementTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EAIELEMENTTAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EAIElementType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EAIELEMENTTYPE", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
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

    protected String onTestValueRule_OrderMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ORDERMODE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
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

    protected boolean onMergeChild(String string, String string2, PSSysEAIElement pSSysEAIElement) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysEAIElement)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysEAIElement pSSysEAIElement) throws Exception {
        super.onUpdateParent(pSSysEAIElement);
    }

    protected void onCopyDetails(PSSysEAIElement pSSysEAIElement, Object object) throws Exception {
        PSSysEAIElement pSSysEAIElement2 = new PSSysEAIElement();
        pSSysEAIElement2.set("PSSYSEAIELEMENTID", object);
        String string = DataObject.getStringValue((Object)pSSysEAIElement.get("PSSYSEAIELEMENTID"));
        super.onCopyDetails(pSSysEAIElement, object);
    }

    @Override
    protected void exportCurXmlModel(PSSysEAIElement pSSysEAIElement, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSEAIELEMENT");
        if (!bl) {
            pSSysEAIElement.setCreateDate(null);
            pSSysEAIElement.setCreateMan(null);
            pSSysEAIElement.setPSSysEAIElementId(null);
            pSSysEAIElement.setUpdateDate(null);
            pSSysEAIElement.setUpdateMan(null);
            super.exportCurXmlModel(pSSysEAIElement, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSSysEAIElement pSSysEAIElement, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSSysEAIElementAttr(pSSysEAIElement, xmlNode);
        this.exportRelatedXmlModel_PSSysEAIElementRE(pSSysEAIElement, xmlNode);
        super.onExportRelatedXmlModel(pSSysEAIElement, xmlNode);
    }

    protected void exportRelatedXmlModel_PSSysEAIElementAttr(PSSysEAIElement pSSysEAIElement, XmlNode xmlNode) throws Exception {
        PSSysEAIElementAttrService pSSysEAIElementAttrService = (PSSysEAIElementAttrService)ServiceGlobal.getService(PSSysEAIElementAttrService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysEAIElementAttr> arrayList = null;
        String string = pSSysEAIElement.getPSSysEAIElementId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSSysEAIElementAttrService.selectByPSSysEAIElement(pSSysEAIElement, "ORDER BY ORDERVALUE ASC") : pSSysEAIElementAttrService.selectTempByPSSysEAIElement(pSSysEAIElement, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSSYSEAIELEMENTATTRS");
            xmlNode.addNode(xmlNode2);
            for (PSSysEAIElementAttr pSSysEAIElementAttr : arrayList) {
                pSSysEAIElementAttr.set("ORDERVALUE", null);
                pSSysEAIElementAttrService.exportXmlModel(pSSysEAIElementAttr, xmlNode2);
            }
        }
    }

    protected void exportRelatedXmlModel_PSSysEAIElementRE(PSSysEAIElement pSSysEAIElement, XmlNode xmlNode) throws Exception {
        PSSysEAIElementREService pSSysEAIElementREService = (PSSysEAIElementREService)ServiceGlobal.getService(PSSysEAIElementREService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysEAIElementRE> arrayList = null;
        String string = pSSysEAIElement.getPSSysEAIElementId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSSysEAIElementREService.selectByPSSysEAIElement(pSSysEAIElement, "ORDER BY ORDERVALUE ASC") : pSSysEAIElementREService.selectTempByPSSysEAIElement(pSSysEAIElement, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSSYSEAIELEMENTRES");
            xmlNode.addNode(xmlNode2);
            for (PSSysEAIElementRE pSSysEAIElementRE : arrayList) {
                pSSysEAIElementRE.set("ORDERVALUE", null);
                pSSysEAIElementREService.exportXmlModel(pSSysEAIElementRE, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSSysEAIElement pSSysEAIElement, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSSYSEAIELEMENTATTRS");
        this.importRelatedXmlModel_PSSysEAIElementAttr(pSSysEAIElement, xmlNode2);
        XmlNode xmlNode3 = xmlNode.getChildNodeByNodeName("PSSYSEAIELEMENTRES");
        this.importRelatedXmlModel_PSSysEAIElementRE(pSSysEAIElement, xmlNode3);
        super.onImportRelatedXmlModel(pSSysEAIElement, xmlNode);
    }

    protected void importRelatedXmlModel_PSSysEAIElementAttr(PSSysEAIElement pSSysEAIElement, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSSysEAIElementAttrService pSSysEAIElementAttrService = (PSSysEAIElementAttrService)ServiceGlobal.getService(PSSysEAIElementAttrService.class, (SessionFactory)this.getSessionFactory());
        String string = pSSysEAIElement.getPSSysEAIElementId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSSysEAIElementAttrService.removeByPSSysEAIElement(pSSysEAIElement);
        } else {
            pSSysEAIElementAttrService.removeTempByPSSysEAIElement(pSSysEAIElement);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSSysEAIElementAttr pSSysEAIElementAttr = new PSSysEAIElementAttr();
                pSSysEAIElementAttr.setOrderValue(n);
                n += 100;
                pSSysEAIElementAttrService.fillParentInfo(pSSysEAIElementAttr, "DER1N", "DER1N_PSSYSEAIELEMENTATTR_PSSYSEAIELEMENT_PSSYSEAIELEMENTID", pSSysEAIElement.getPSSysEAIElementId());
                pSSysEAIElementAttrService.importXmlModel(pSSysEAIElementAttr, xmlNode2);
            }
        }
    }

    protected void importRelatedXmlModel_PSSysEAIElementRE(PSSysEAIElement pSSysEAIElement, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSSysEAIElementREService pSSysEAIElementREService = (PSSysEAIElementREService)ServiceGlobal.getService(PSSysEAIElementREService.class, (SessionFactory)this.getSessionFactory());
        String string = pSSysEAIElement.getPSSysEAIElementId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSSysEAIElementREService.removeByPSSysEAIElement(pSSysEAIElement);
        } else {
            pSSysEAIElementREService.removeTempByPSSysEAIElement(pSSysEAIElement);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSSysEAIElementRE pSSysEAIElementRE = new PSSysEAIElementRE();
                pSSysEAIElementRE.setOrderValue(n);
                n += 100;
                pSSysEAIElementREService.fillParentInfo(pSSysEAIElementRE, "DER1N", "DER1N_PSSYSEAIELEMENTRE_PSSYSEAIELEMENT_PSSYSEAIELEMENTID", pSSysEAIElement.getPSSysEAIElementId());
                pSSysEAIElementREService.importXmlModel(pSSysEAIElementRE, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysEAIElement pSSysEAIElement, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysEAIElement, string);
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
            return "DER1N_PSSYSEAIELEMENT_PSSYSEAISCHEME_PSSYSEAISCHEMEID";
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
    public String getModelV2Tag(PSSysEAIElement pSSysEAIElement) {
        if (!StringHelper.isNullOrEmpty((String)pSSysEAIElement.getCodeName())) {
            return pSSysEAIElement.getCodeName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysEAIElement.getPSSysEAIElementName())) {
            return pSSysEAIElement.getPSSysEAIElementName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysEAIElement.getCodeName())) {
            return pSSysEAIElement.getCodeName();
        }
        return super.getModelV2Tag(pSSysEAIElement);
    }

    @Override
    public boolean setModelV2Tag(PSSysEAIElement pSSysEAIElement, String string) {
        pSSysEAIElement.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSSYSEAIELEMENTNAME", "");
        map.put("CODENAME", "");
        map.put("PSSYSEAISCHEMEID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysEAIElement pSSysEAIElement, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysEAIElement.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysEAIElement, true);
        pSSysEAIElement.set("CODENAME", string);
        if (this.select(pSSysEAIElement, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysEAIElement, true);
        return super.getModelV2Entity(pSSysEAIElement, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysEAIElement pSSysEAIElement, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysEAIElement, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSSYSEAIELEMENTATTR_PSSYSEAIELEMENT_PSSYSEAIELEMENTID", (String)string, (boolean)true) == 0) {
            return false;
        }
        return StringHelper.compare((String)"DER1N_PSSYSEAIELEMENTRE_PSSYSEAIELEMENT_PSSYSEAIELEMENTID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSSysEAIElement pSSysEAIElement, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSSysEAIElement, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSSysEAIElement pSSysEAIElement, ObjectNode objectNode, String string, boolean bl) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSYSEAIELEMENTATTR_PSSYSEAIELEMENT_PSSYSEAIELEMENTID")) {
            pSCoreSysServiceBase = (PSSysEAIElementAttrService)ServiceGlobal.getService(PSSysEAIElementAttrService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<ObjectNode> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                File file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSEAIELEMENT#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSYSEAIELEMENTATTR", (Object)pSSysEAIElement.getPSSysEAIElementId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSSYSEAIELEMENT#%1$s", (Object)pSSysEAIElement.getPSSysEAIElementId());
                for (PSSysEAIElementAttr child : ((PSSysEAIElementAttrServiceBase)pSCoreSysServiceBase).selectByPSSysEAIElement(pSSysEAIElement)) {
                    if (StringHelper.compare(scope, ((PSSysEAIElementAttrServiceBase)pSCoreSysServiceBase).getModelV2ResScope(child), false) != 0) continue;
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
                        if (objectNode.has("pssyseaielementattrname")) {
                            string = objectNode.get("pssyseaielementattrname").asText();
                        }
                        if (objectNode2.has("pssyseaielementattrname")) {
                            string2 = objectNode2.get("pssyseaielementattrname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode childNode : arrayList) {
                    PSSysEAIElementAttr child = new PSSysEAIElementAttr();
                    PSModelV2Helper.fromJSONObject(child, childNode, false);
                    children.add((JsonNode)pSCoreSysServiceBase.exportModelV2(child, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSYSEAIELEMENTRE_PSSYSEAIELEMENT_PSSYSEAIELEMENTID")) {
            pSCoreSysServiceBase = (PSSysEAIElementREService)ServiceGlobal.getService(PSSysEAIElementREService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<ObjectNode> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                File file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSEAIELEMENT#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSYSEAIELEMENTRE", (Object)pSSysEAIElement.getPSSysEAIElementId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSSYSEAIELEMENT#%1$s", (Object)pSSysEAIElement.getPSSysEAIElementId());
                for (PSSysEAIElementRE child : ((PSSysEAIElementREServiceBase)pSCoreSysServiceBase).selectByPSSysEAIElement(pSSysEAIElement)) {
                    if (StringHelper.compare(scope, ((PSSysEAIElementREServiceBase)pSCoreSysServiceBase).getModelV2ResScope(child), false) != 0) continue;
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
                        if (objectNode.has("pssyseaielementrename")) {
                            string = objectNode.get("pssyseaielementrename").asText();
                        }
                        if (objectNode2.has("pssyseaielementrename")) {
                            string2 = objectNode2.get("pssyseaielementrename").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode childNode : arrayList) {
                    PSSysEAIElementRE child = new PSSysEAIElementRE();
                    PSModelV2Helper.fromJSONObject(child, childNode, false);
                    children.add((JsonNode)pSCoreSysServiceBase.exportModelV2(child, string));
                }
            }
        }
        super.onExportCurModelV2(pSSysEAIElement, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSSysEAIElement pSSysEAIElement) throws Exception {
        String string;
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysEAIElementAttrService)ServiceGlobal.getService(PSSysEAIElementAttrService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysEAIElementAttr> attrs = ((PSSysEAIElementAttrServiceBase)pSCoreSysServiceBase).selectByPSSysEAIElement(pSSysEAIElement);
        String string2 = StringHelper.format((String)"PSSYSEAIELEMENT#%1$s", (Object)pSSysEAIElement.getPSSysEAIElementId());
        for (PSSysEAIElementAttr entityBase : attrs) {
            string = ((PSSysEAIElementAttrServiceBase)pSCoreSysServiceBase).getModelV2ResScope(entityBase);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(entityBase);
        }
        SqlParamList object = new SqlParamList();
        object.addString(pSSysEAIElement.getPSSysEAIElementId());
        ((PSSysEAIElementAttrServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSSysEAIElementAttrServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSSYSEAIELEMENTATTR WHERE PSSYSEAIELEMENTID = ?", (SqlParamList)object);
        pSCoreSysServiceBase = (PSSysEAIElementREService)ServiceGlobal.getService(PSSysEAIElementREService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysEAIElementRE> relations = ((PSSysEAIElementREServiceBase)pSCoreSysServiceBase).selectByPSSysEAIElement(pSSysEAIElement);
        string2 = StringHelper.format((String)"PSSYSEAIELEMENT#%1$s", (Object)pSSysEAIElement.getPSSysEAIElementId());
        for (PSSysEAIElementRE pSSysEAIElementRE : relations) {
            string = ((PSSysEAIElementREServiceBase)pSCoreSysServiceBase).getModelV2ResScope(pSSysEAIElementRE);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(pSSysEAIElementRE);
        }
        object = new SqlParamList();
        object.addString(pSSysEAIElement.getPSSysEAIElementId());
        ((PSSysEAIElementREServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSSysEAIElementREServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSSYSEAIELEMENTRE WHERE PSSYSEAIELEMENTID = ?", (SqlParamList)object);
        super.onEmptyModelV2(pSSysEAIElement);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysEAIElementAttrService)ServiceGlobal.getService(PSSysEAIElementAttrService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSSysEAIElementREService)ServiceGlobal.getService(PSSysEAIElementREService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSSysEAIElement pSSysEAIElement, String string, String string2) throws Exception {
        IEntity iEntity = null;
        EntityBase entityBase = new PSSysEAIElementAttr();
        entityBase.set("PSSYSEAIELEMENTID", pSSysEAIElement.getPSSysEAIElementId());
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysEAIElementAttrService)ServiceGlobal.getService(PSSysEAIElementAttrService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSSysEAIElementRE();
        entityBase.set("PSSYSEAIELEMENTID", pSSysEAIElement.getPSSysEAIElementId());
        pSCoreSysServiceBase = (PSSysEAIElementREService)ServiceGlobal.getService(PSSysEAIElementREService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSSysEAIElement, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSSysEAIElement pSSysEAIElement, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        int n2;
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysEAIElementAttrService)ServiceGlobal.getService(PSSysEAIElementAttrService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                ObjectNode childNode = (ObjectNode)arrayNode.get(n2);
                PSSysEAIElementAttr child = new PSSysEAIElementAttr();
                child.setPSSysEAIElementId(pSSysEAIElement.getPSSysEAIElementId());
                child.setPSSysEAIElementName(pSSysEAIElement.getPSSysEAIElementName());
                child.setPSSysEAISchemeId(pSSysEAIElement.getPSSysEAISchemeId());
                pSCoreSysServiceBase.compileModelV2(child, childNode, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File directory = new File(string4);
            if (directory.exists()) {
                for (File childDirectory : directory.listFiles()) {
                    if (!childDirectory.isDirectory()) continue;
                    PSSysEAIElementAttr child = new PSSysEAIElementAttr();
                    child.setPSSysEAIElementId(pSSysEAIElement.getPSSysEAIElementId());
                    child.setPSSysEAIElementName(pSSysEAIElement.getPSSysEAIElementName());
                    child.setPSSysEAISchemeId(pSSysEAIElement.getPSSysEAISchemeId());
                    pSCoreSysServiceBase.compileModelV2(child, null, string, childDirectory.getCanonicalPath(), n);
                }
            }
        }
        pSCoreSysServiceBase = (PSSysEAIElementREService)ServiceGlobal.getService(PSSysEAIElementREService.class, (SessionFactory)this.getSessionFactory());
        arrayNode = null;
        string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                ObjectNode childNode = (ObjectNode)arrayNode.get(n2);
                PSSysEAIElementRE child = new PSSysEAIElementRE();
                child.setPSSysEAIElementId(pSSysEAIElement.getPSSysEAIElementId());
                child.setPSSysEAIElementName(pSSysEAIElement.getPSSysEAIElementName());
                child.setPSSysEAISchemeId(pSSysEAIElement.getPSSysEAISchemeId());
                pSCoreSysServiceBase.compileModelV2(child, childNode, string, null, n);
            }
        } else {
            String string5 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File directory = new File(string5);
            if (directory.exists()) {
                for (File childDirectory : directory.listFiles()) {
                    if (!childDirectory.isDirectory()) continue;
                    PSSysEAIElementRE child = new PSSysEAIElementRE();
                    child.setPSSysEAIElementId(pSSysEAIElement.getPSSysEAIElementId());
                    child.setPSSysEAIElementName(pSSysEAIElement.getPSSysEAIElementName());
                    child.setPSSysEAISchemeId(pSSysEAIElement.getPSSysEAISchemeId());
                    pSCoreSysServiceBase.compileModelV2(child, null, string, childDirectory.getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSSysEAIElement, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSSysEAIElement pSSysEAIElement, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSSYSEAIELEMENTATTR_PSSYSEAIELEMENT_PSSYSEAIELEMENTID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSSysEAIElementAttrs(pSSysEAIElement, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSSYSEAIELEMENTRE_PSSYSEAIELEMENT_PSSYSEAIELEMENTID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSSysEAIElementREs(pSSysEAIElement, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSSysEAIElement, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSSysEAIElementAttrs(PSSysEAIElement pSSysEAIElement, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSSYSEAIELEMENTATTR", true), (boolean)false) == 0) {
            PSSysEAIElementAttrService pSSysEAIElementAttrService = (PSSysEAIElementAttrService)ServiceGlobal.getService(PSSysEAIElementAttrService.class, (SessionFactory)this.getSessionFactory());
            PSSysEAIElementAttr pSSysEAIElementAttr = new PSSysEAIElementAttr();
            pSSysEAIElementAttr.setPSSysEAIElementAttrId(pSMOSFile.getPSModelId());
            if (!pSSysEAIElementAttrService.get(pSSysEAIElementAttr, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSSysEAIElementAttr.getPSSysEAIElementId(), (String)pSSysEAIElement.getPSSysEAIElementId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSSysEAIElementAttrService.exportModelV2(pSSysEAIElementAttr);
            pSSysEAIElementAttr.reset();
            if (!pSSysEAIElementAttrService.setModelV2ResScope(pSSysEAIElementAttr, "PSSYSEAIELEMENT", pSSysEAIElement.getPSSysEAIElementId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSSysEAIElementAttrService.importModelV2(pSSysEAIElementAttr, objectNode);
            SessionFactoryManager.commit();
            return pSSysEAIElementAttrService.getFile(pSSysEAIElementAttr);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSSysEAIElementREs(PSSysEAIElement pSSysEAIElement, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSSYSEAIELEMENTRE", true), (boolean)false) == 0) {
            PSSysEAIElementREService pSSysEAIElementREService = (PSSysEAIElementREService)ServiceGlobal.getService(PSSysEAIElementREService.class, (SessionFactory)this.getSessionFactory());
            PSSysEAIElementRE pSSysEAIElementRE = new PSSysEAIElementRE();
            pSSysEAIElementRE.setPSSysEAIElementREId(pSMOSFile.getPSModelId());
            if (!pSSysEAIElementREService.get(pSSysEAIElementRE, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSSysEAIElementRE.getPSSysEAIElementId(), (String)pSSysEAIElement.getPSSysEAIElementId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSSysEAIElementREService.exportModelV2(pSSysEAIElementRE);
            pSSysEAIElementRE.reset();
            if (!pSSysEAIElementREService.setModelV2ResScope(pSSysEAIElementRE, "PSSYSEAIELEMENT", pSSysEAIElement.getPSSysEAIElementId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSSysEAIElementREService.importModelV2(pSSysEAIElementRE, objectNode);
            SessionFactoryManager.commit();
            return pSSysEAIElementREService.getFile(pSSysEAIElementRE);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSSysEAIElement pSSysEAIElement, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSSysEAIElementAttrs(pSSysEAIElement, list);
        this.onFillPasteHelps_PSSysEAIElementREs(pSSysEAIElement, list);
        super.onFillPasteHelps(pSSysEAIElement, list);
    }

    protected void onFillPasteHelps_PSSysEAIElementAttrs(PSSysEAIElement pSSysEAIElement, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSSYSEAIELEMENTATTR");
        pSHelpSection.setSectionParam2("DER1N_PSSYSEAIELEMENTATTR_PSSYSEAIELEMENT_PSSYSEAIELEMENTID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u96c6\u6210\u5143\u7d20]\u7684[\u96c6\u6210\u5143\u7d20\u5c5e\u6027]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSSysEAIElementREs(PSSysEAIElement pSSysEAIElement, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSSYSEAIELEMENTRE");
        pSHelpSection.setSectionParam2("DER1N_PSSYSEAIELEMENTRE_PSSYSEAIELEMENT_PSSYSEAIELEMENTID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u96c6\u6210\u5143\u7d20]\u7684[\u96c6\u6210\u5143\u7d20\u5143\u7d20]");
        list.add(pSHelpSection);
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSSysEAIElement pSSysEAIElement, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "Element");
        defaultValueMap.put("PSSYSEAIELEMENTNAME", "\u96c6\u6210\u5143\u7d20");
    }
}
