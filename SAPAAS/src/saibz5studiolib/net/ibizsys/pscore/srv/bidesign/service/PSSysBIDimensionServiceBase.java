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
package net.ibizsys.pscore.srv.bidesign.service;

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
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.bidesign.dao.PSSysBIDimensionDAO;
import net.ibizsys.pscore.srv.bidesign.demodel.PSSysBIDimensionDEModel;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBIDimension;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBIHierarchy;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBIScheme;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBISchemeBase;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeDimensionService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeDimensionServiceBase;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBIHierarchyService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBIHierarchyServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPluginBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysBIDimensionServiceBase
extends PSCoreSysServiceBase<PSSysBIDimension> {
    private static final Log log = LogFactory.getLog(PSSysBIDimensionServiceBase.class);
    public static final String DATASET_CURSCHEME = "CurScheme";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSSysBIDimensionDEModel pSSysBIDimensionDEModel;
    private PSSysBIDimensionDAO pSSysBIDimensionDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.bidesign.service.PSSysBIDimensionService";
    }

    public PSSysBIDimensionDEModel getPSSysBIDimensionDEModel() {
        if (this.pSSysBIDimensionDEModel == null) {
            try {
                this.pSSysBIDimensionDEModel = (PSSysBIDimensionDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.bidesign.demodel.PSSysBIDimensionDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysBIDimensionDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysBIDimensionDEModel();
    }

    public PSSysBIDimensionDAO getPSSysBIDimensionDAO() {
        if (this.pSSysBIDimensionDAO == null) {
            try {
                this.pSSysBIDimensionDAO = (PSSysBIDimensionDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.bidesign.dao.PSSysBIDimensionDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysBIDimensionDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysBIDimensionDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
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
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurScheme(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSCHEME, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSSysBIDimension pSSysBIDimension, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBIDIMENSION_PSSYSBISCHEME_PSSYSBISCHEMEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bidesign.service.PSSysBISchemeService", (SessionFactory)this.getSessionFactory());
            PSSysBIScheme pSSysBIScheme = (PSSysBIScheme)iService.getDEModel().createEntity();
            pSSysBIScheme.set("PSSYSBISCHEMEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysBIScheme);
            } else {
                iService.get((IEntity)pSSysBIScheme);
            }
            this.onFillParentInfo_PSSysBIScheme(pSSysBIDimension, pSSysBIScheme);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBIDIMENSION_PSSYSSFPLUGIN_PSSYSSFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysSFPlugin pSSysSFPlugin = (PSSysSFPlugin)iService.getDEModel().createEntity();
            pSSysSFPlugin.set("PSSYSSFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysSFPlugin);
            } else {
                iService.get((IEntity)pSSysSFPlugin);
            }
            this.onFillParentInfo_PSSysSFPlugin(pSSysBIDimension, pSSysSFPlugin);
            return;
        }
        super.onFillParentInfo((IEntity)pSSysBIDimension, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSysBIScheme(PSSysBIDimension pSSysBIDimension, PSSysBIScheme pSSysBIScheme) throws Exception {
        pSSysBIDimension.setPSSysBISchemeId(pSSysBIScheme.getPSSysBISchemeId());
        pSSysBIDimension.setPSSysBISchemeName(pSSysBIScheme.getPSSysBISchemeName());
    }

    protected void onFillParentInfo_PSSysSFPlugin(PSSysBIDimension pSSysBIDimension, PSSysSFPlugin pSSysSFPlugin) throws Exception {
        pSSysBIDimension.setPSSysSFPluginId(pSSysSFPlugin.getPSSysSFPluginId());
        pSSysBIDimension.setPSSysSFPluginName(pSSysSFPlugin.getPSSysSFPluginName());
    }

    protected void onFillEntityFullInfo(PSSysBIDimension pSSysBIDimension, boolean bl) throws Exception {
        if (bl) {
            if (pSSysBIDimension.getCodeName() == null) {
                pSSysBIDimension.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "Dimension", 25));
            }
            if (pSSysBIDimension.getValidFlag() == null) {
                pSSysBIDimension.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSSysBIDimension, bl);
        this.onFillEntityFullInfo_PSSysBIScheme(pSSysBIDimension, bl);
        this.onFillEntityFullInfo_PSSysSFPlugin(pSSysBIDimension, bl);
    }

    protected void onFillEntityFullInfo_PSSysBIScheme(PSSysBIDimension pSSysBIDimension, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysSFPlugin(PSSysBIDimension pSSysBIDimension, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysBIDimension pSSysBIDimension, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSysBIDimension, bl);
    }

    public ArrayList<PSSysBIDimension> selectByPSSysBIScheme(PSSysBISchemeBase pSSysBISchemeBase) throws Exception {
        return this.selectByPSSysBIScheme(pSSysBISchemeBase, "", -1);
    }

    public ArrayList<PSSysBIDimension> selectByPSSysBIScheme(PSSysBISchemeBase pSSysBISchemeBase, String string) throws Exception {
        return this.selectByPSSysBIScheme(pSSysBISchemeBase, string, -1);
    }

    public ArrayList<PSSysBIDimension> selectByPSSysBIScheme(PSSysBISchemeBase pSSysBISchemeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSBISCHEMEID", (Object)pSSysBISchemeBase.getPSSysBISchemeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysBISchemeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysBISchemeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysBIDimension> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, "", -1);
    }

    public ArrayList<PSSysBIDimension> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, string, -1);
    }

    public ArrayList<PSSysBIDimension> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSSFPLUGINID", (Object)pSSysSFPluginBase.getPSSysSFPluginId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysSFPluginCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysSFPluginCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSSysBIScheme(PSSysBIScheme pSSysBIScheme) throws Exception {
        ArrayList<PSSysBIDimension> arrayList = this.selectByPSSysBIScheme(pSSysBIScheme, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSBISCHEME");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysBIScheme);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBIDIMENSION_PSSYSBISCHEME_PSSYSBISCHEMEID", "", iDataEntityModel.getName(), "PSSYSBIDIMENSION", iDataEntityModel.getDataInfo((IEntity)pSSysBIScheme), arrayList.get(0)));
        }
    }

    public void resetPSSysBIScheme(PSSysBIScheme pSSysBIScheme) throws Exception {
        ArrayList<PSSysBIDimension> arrayList = this.selectByPSSysBIScheme(pSSysBIScheme);
        for (PSSysBIDimension pSSysBIDimension : arrayList) {
            PSSysBIDimension pSSysBIDimension2 = (PSSysBIDimension)this.getDEModel().createEntity();
            pSSysBIDimension2.setPSSysBIDimensionId(pSSysBIDimension.getPSSysBIDimensionId());
            pSSysBIDimension2.setPSSysBISchemeId(null);
            this.update(pSSysBIDimension2);
        }
    }

    public void removeByPSSysBIScheme(PSSysBIScheme pSSysBIScheme) throws Exception {
        final PSSysBIScheme pSSysBIScheme2 = pSSysBIScheme;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBIDimensionServiceBase.this.onBeforeRemoveByPSSysBIScheme(pSSysBIScheme2);
                PSSysBIDimensionServiceBase.this.internalRemoveByPSSysBIScheme(pSSysBIScheme2);
                PSSysBIDimensionServiceBase.this.onAfterRemoveByPSSysBIScheme(pSSysBIScheme2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysBIScheme(PSSysBIScheme pSSysBIScheme) throws Exception {
    }

    protected void internalRemoveByPSSysBIScheme(PSSysBIScheme pSSysBIScheme) throws Exception {
        ArrayList<PSSysBIDimension> arrayList = this.selectByPSSysBIScheme(pSSysBIScheme);
        this.onBeforeRemoveByPSSysBIScheme(pSSysBIScheme, arrayList);
        for (PSSysBIDimension pSSysBIDimension : arrayList) {
            this.remove((IEntity)pSSysBIDimension);
        }
        this.onAfterRemoveByPSSysBIScheme(pSSysBIScheme, arrayList);
    }

    protected void onAfterRemoveByPSSysBIScheme(PSSysBIScheme pSSysBIScheme) throws Exception {
    }

    protected void onBeforeRemoveByPSSysBIScheme(PSSysBIScheme pSSysBIScheme, ArrayList<PSSysBIDimension> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysBIScheme(PSSysBIScheme pSSysBIScheme, ArrayList<PSSysBIDimension> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSysBIDimension> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysSFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBIDIMENSION_PSSYSSFPLUGIN_PSSYSSFPLUGINID", "", iDataEntityModel.getName(), "PSSYSBIDIMENSION", iDataEntityModel.getDataInfo((IEntity)pSSysSFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSysBIDimension> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        for (PSSysBIDimension pSSysBIDimension : arrayList) {
            PSSysBIDimension pSSysBIDimension2 = (PSSysBIDimension)this.getDEModel().createEntity();
            pSSysBIDimension2.setPSSysBIDimensionId(pSSysBIDimension.getPSSysBIDimensionId());
            pSSysBIDimension2.setPSSysSFPluginId(null);
            this.update(pSSysBIDimension2);
        }
    }

    public void removeByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        final PSSysSFPlugin pSSysSFPlugin2 = pSSysSFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBIDimensionServiceBase.this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSSysBIDimensionServiceBase.this.internalRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSSysBIDimensionServiceBase.this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSysBIDimension> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
        for (PSSysBIDimension pSSysBIDimension : arrayList) {
            this.remove((IEntity)pSSysBIDimension);
        }
        this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSSysBIDimension> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSSysBIDimension> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysBIDimension pSSysBIDimension) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysBICubeDimensionService)ServiceGlobal.getService(PSSysBICubeDimensionService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBICubeDimensionServiceBase)pSCoreSysServiceBase).testRemoveByPSSysBIDimension(pSSysBIDimension);
        pSCoreSysServiceBase = (PSSysBIHierarchyService)ServiceGlobal.getService(PSSysBIHierarchyService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBIHierarchyServiceBase)pSCoreSysServiceBase).testRemoveByPSSysBIDimension(pSSysBIDimension);
        ((PSSysBIHierarchyServiceBase)pSCoreSysServiceBase).removeByPSSysBIDimension(pSSysBIDimension);
        super.onBeforeRemove(pSSysBIDimension);
    }

    protected void replaceParentInfo(PSSysBIDimension pSSysBIDimension, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSysBIDimension, cloneSession);
        if (pSSysBIDimension.getPSSysBISchemeId() != null && (iEntity = cloneSession.getEntity("PSSYSBISCHEME", (Object)pSSysBIDimension.getPSSysBISchemeId())) != null) {
            this.onFillParentInfo_PSSysBIScheme(pSSysBIDimension, (PSSysBIScheme)iEntity);
        }
        if (pSSysBIDimension.getPSSysSFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSSFPLUGIN", (Object)pSSysBIDimension.getPSSysSFPluginId())) != null) {
            this.onFillParentInfo_PSSysSFPlugin(pSSysBIDimension, (PSSysSFPlugin)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysBIDimension pSSysBIDimension, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSysBIDimension, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysBIDimension pSSysBIDimension, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_BIDimensionTag(bl, pSSysBIDimension, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BIDimensionTag2(bl, pSSysBIDimension, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSSysBIDimension, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysBIDimension, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBIDimensionId(bl, pSSysBIDimension, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBIDimensionName(bl, pSSysBIDimension, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBISchemeId(bl, pSSysBIDimension, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSFPluginId(bl, pSSysBIDimension, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysBIDimension, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysBIDimension, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysBIDimension, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysBIDimension, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysBIDimension, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSysBIDimension, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSysBIDimension, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_BIDimensionTag(boolean bl, PSSysBIDimension pSSysBIDimension, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIDimension.isBIDimensionTagDirty() : !pSSysBIDimension.isBIDimensionTagDirty()) {
            return null;
        }
        String string = pSSysBIDimension.getBIDimensionTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BIDimensionTag_Default((IEntity)pSSysBIDimension, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BIDIMENSIONTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BIDimensionTag2(boolean bl, PSSysBIDimension pSSysBIDimension, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIDimension.isBIDimensionTag2Dirty() : !pSSysBIDimension.isBIDimensionTag2Dirty()) {
            return null;
        }
        String string = pSSysBIDimension.getBIDimensionTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BIDimensionTag2_Default((IEntity)pSSysBIDimension, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BIDIMENSIONTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysBIDimension pSSysBIDimension, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIDimension.isCodeNameDirty() && !bl2 : !pSSysBIDimension.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysBIDimension.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSSysBIDimension, bl2, bl3);
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
                string3 = "PSSYSBISCHEMEID";
                String string4 = this.checkFieldDupRule(this.getPSSysBIDimensionDEModel(), "CODENAME", string3, pSSysBIDimension, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysBIDimension pSSysBIDimension, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIDimension.isMemoDirty() : !pSSysBIDimension.isMemoDirty()) {
            return null;
        }
        String string = pSSysBIDimension.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSSysBIDimension, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysBIDimensionId(boolean bl, PSSysBIDimension pSSysBIDimension, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIDimension.isPSSysBIDimensionIdDirty() && !bl2 : !pSSysBIDimension.isPSSysBIDimensionIdDirty()) {
            return null;
        }
        String string = pSSysBIDimension.getPSSysBIDimensionId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBIDIMENSIONID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBIDimensionId_Default((IEntity)pSSysBIDimension, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBIDIMENSIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBIDimensionName(boolean bl, PSSysBIDimension pSSysBIDimension, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIDimension.isPSSysBIDimensionNameDirty() && !bl2 : !pSSysBIDimension.isPSSysBIDimensionNameDirty()) {
            return null;
        }
        String string = pSSysBIDimension.getPSSysBIDimensionName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBIDIMENSIONNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBIDimensionName_Default((IEntity)pSSysBIDimension, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBIDIMENSIONNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBISchemeId(boolean bl, PSSysBIDimension pSSysBIDimension, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIDimension.isPSSysBISchemeIdDirty() && !bl2 : !pSSysBIDimension.isPSSysBISchemeIdDirty()) {
            return null;
        }
        String string = pSSysBIDimension.getPSSysBISchemeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBISCHEMEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBISchemeId_Default((IEntity)pSSysBIDimension, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBISCHEMEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSFPluginId(boolean bl, PSSysBIDimension pSSysBIDimension, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIDimension.isPSSysSFPluginIdDirty() : !pSSysBIDimension.isPSSysSFPluginIdDirty()) {
            return null;
        }
        String string = pSSysBIDimension.getPSSysSFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSFPluginId_Default((IEntity)pSSysBIDimension, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSFPLUGINID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysBIDimension pSSysBIDimension, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIDimension.isUserCatDirty() : !pSSysBIDimension.isUserCatDirty()) {
            return null;
        }
        String string = pSSysBIDimension.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSSysBIDimension, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysBIDimension pSSysBIDimension, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIDimension.isUserTagDirty() : !pSSysBIDimension.isUserTagDirty()) {
            return null;
        }
        String string = pSSysBIDimension.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSSysBIDimension, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysBIDimension pSSysBIDimension, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIDimension.isUserTag2Dirty() : !pSSysBIDimension.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysBIDimension.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSSysBIDimension, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysBIDimension pSSysBIDimension, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIDimension.isUserTag3Dirty() : !pSSysBIDimension.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysBIDimension.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSSysBIDimension, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysBIDimension pSSysBIDimension, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIDimension.isUserTag4Dirty() : !pSSysBIDimension.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysBIDimension.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSSysBIDimension, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSysBIDimension pSSysBIDimension, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIDimension.isValidFlagDirty() && !bl2 : !pSSysBIDimension.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSysBIDimension.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSSysBIDimension, bl2, bl3);
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

    protected void onSyncEntity(PSSysBIDimension pSSysBIDimension, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSysBIDimension, bl);
    }

    protected void onSyncIndexEntities(PSSysBIDimension pSSysBIDimension, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSysBIDimension, bl);
    }

    public Object getDataContextValue(PSSysBIDimension pSSysBIDimension, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSysBIDimension, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSysBIDimension pSSysBIDimension, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSysBIDimension, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"BIDIMENSIONTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BIDimensionTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BIDIMENSIONTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BIDimensionTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBIDIMENSIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBIDimensionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBIDIMENSIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBIDimensionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBISCHEMEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBISchemeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBISCHEMENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBISchemeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPluginName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_BIDimensionTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BIDIMENSIONTAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BIDimensionTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BIDIMENSIONTAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_PSSysBIDimensionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBIDIMENSIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBIDimensionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBIDIMENSIONNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBISchemeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBISCHEMEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBISchemeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBISCHEMENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSFPluginId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSFPLUGINID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSFPluginName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSFPLUGINNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSSysBIDimension pSSysBIDimension) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSSysBIDimension)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysBIDimension pSSysBIDimension) throws Exception {
        super.onUpdateParent((IEntity)pSSysBIDimension);
    }

    protected void onCopyDetails(PSSysBIDimension pSSysBIDimension, Object object) throws Exception {
        PSSysBIDimension pSSysBIDimension2 = new PSSysBIDimension();
        pSSysBIDimension2.set("PSSYSBIDIMENSIONID", object);
        String string = DataObject.getStringValue((Object)pSSysBIDimension.get("PSSYSBIDIMENSIONID"));
        PSSysBIHierarchyService pSSysBIHierarchyService = (PSSysBIHierarchyService)ServiceGlobal.getService(PSSysBIHierarchyService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysBIHierarchy> arrayList = pSSysBIHierarchyService.selectByPSSysBIDimension(pSSysBIDimension2);
        for (PSSysBIHierarchy pSSysBIHierarchy : arrayList) {
            Object object2 = pSSysBIHierarchy.get("PSSYSBIHIERARCHYID");
            pSSysBIHierarchyService.getDraftFrom((IEntity)pSSysBIHierarchy);
            pSSysBIHierarchyService.fillParentInfo((IEntity)pSSysBIHierarchy, "DER1N", "DER1N_PSSYSBIHIERARCHY_PSSYSBIDIMENSION_PSSYSBIDIMENSIONID", string);
            pSSysBIHierarchyService.create(pSSysBIHierarchy);
            pSSysBIHierarchyService.copyDetails(pSSysBIHierarchy, object2);
        }
        super.onCopyDetails((IEntity)pSSysBIDimension, object);
    }

    @Override
    protected void exportCurXmlModel(PSSysBIDimension pSSysBIDimension, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSBIDIMENSION");
        if (!bl) {
            pSSysBIDimension.setCreateDate(null);
            pSSysBIDimension.setCreateMan(null);
            pSSysBIDimension.setPSSysBIDimensionId(null);
            pSSysBIDimension.setUpdateDate(null);
            pSSysBIDimension.setUpdateMan(null);
            super.exportCurXmlModel(pSSysBIDimension, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysBIDimension pSSysBIDimension, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysBIDimension, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSBISCHEMEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSBISCHEME#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSBISCHEMEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSBIDIMENSION_PSSYSBISCHEME_PSSYSBISCHEMEID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSBISCHEMEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSBISCHEMENAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSYSBISCHEME", (boolean)true) == 0) {
            iEntity.set("PSSYSBISCHEMEID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSSYSBISCHEMEID"};
    }

    @Override
    public String getModelV2Tag(PSSysBIDimension pSSysBIDimension) {
        if (!StringHelper.isNullOrEmpty((String)pSSysBIDimension.getCodeName())) {
            return pSSysBIDimension.getCodeName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysBIDimension.getCodeName())) {
            return pSSysBIDimension.getCodeName();
        }
        return super.getModelV2Tag(pSSysBIDimension);
    }

    @Override
    public boolean setModelV2Tag(PSSysBIDimension pSSysBIDimension, String string) {
        pSSysBIDimension.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("CODENAME", "");
        map.put("PSSYSBISCHEMEID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysBIDimension pSSysBIDimension, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysBIDimension.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysBIDimension, true);
        pSSysBIDimension.set("CODENAME", string);
        if (this.select(pSSysBIDimension, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysBIDimension, true);
        return super.getModelV2Entity(pSSysBIDimension, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysBIDimension pSSysBIDimension, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysBIDimension, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSSYSBIHIERARCHY_PSSYSBIDIMENSION_PSSYSBIDIMENSIONID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 60;
        }
        return true;
    }

    @Override
    protected void onExportRelatedModelV2(PSSysBIDimension pSSysBIDimension, String string, String string2) throws Exception {
        File file = null;
        if (this.isExportRelatedModelV2("DER1N_PSSYSBIHIERARCHY_PSSYSBIDIMENSION_PSSYSBIDIMENSIONID") && (file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSBIDIMENSION#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSSYSBIHIERARCHY", (Object)pSSysBIDimension.getPSSysBIDimensionId()))).exists()) {
            PSSysBIHierarchyService pSSysBIHierarchyService = (PSSysBIHierarchyService)ServiceGlobal.getService(PSSysBIHierarchyService.class, (SessionFactory)this.getSessionFactory());
            String string3 = pSSysBIHierarchyService.getModelV2Name(false);
            String string4 = string + File.separator + string3;
            File file2 = new File(string4);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            ArrayList<String> arrayList = PSModelV2Helper.readFile2(file);
            for (String string5 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string5)) continue;
                ObjectNode objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string5);
                PSSysBIHierarchy pSSysBIHierarchy = new PSSysBIHierarchy();
                PSModelV2Helper.fromJSONObject((IDataObject)pSSysBIHierarchy, objectNode, false);
                String string6 = pSSysBIHierarchyService.getModelV2Tag(pSSysBIHierarchy);
                if (StringHelper.isNullOrEmpty((String)string6)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSSYSBIHIERARCHY", (Object)pSSysBIHierarchy.getPSSysBIHierarchyId()));
                }
                string6 = PSModelV2Helper.getModelV2TagFolderName(string6);
                file2 = new File(string4 + File.separator + string6);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                pSSysBIHierarchyService.exportModelV2(pSSysBIHierarchy, string4 + File.separator + string6, string2);
            }
        }
        super.onExportRelatedModelV2(pSSysBIDimension, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSSysBIDimension pSSysBIDimension, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSYSBIHIERARCHY_PSSYSBIDIMENSION_PSSYSBIDIMENSIONID")) {
            Object object;
            PSSysBIHierarchy pSSysBIHierarchy2;
            Object object2;
            Object object3;
            Object object4;
            PSSysBIHierarchyService pSSysBIHierarchyService = (PSSysBIHierarchyService)ServiceGlobal.getService(PSSysBIHierarchyService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<PSSysBIHierarchy> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSBIDIMENSION#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSYSBIHIERARCHY", (Object)pSSysBIDimension.getPSSysBIDimensionId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        pSSysBIHierarchy2 = (ObjectNode)JsonNodeHelper.fromString((String)object2);
                        arrayList.add(pSSysBIHierarchy2);
                    }
                }
            } else {
                arrayList = new ArrayList<PSSysBIHierarchy>();
                object4 = pSSysBIHierarchyService.selectByPSSysBIDimension(pSSysBIDimension);
                object3 = StringHelper.format((String)"PSSYSBIDIMENSION#%1$s", (Object)pSSysBIDimension.getPSSysBIDimensionId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    pSSysBIHierarchy2 = object2.next();
                    object = pSSysBIHierarchyService.getModelV2ResScope((IEntity)pSSysBIHierarchy2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSSysBIHierarchy)PSModelV2Helper.toJSONObject((IEntity)pSSysBIHierarchy2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSSysBIHierarchyService.getModelV2Name(false);
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
                        if (objectNode.has("pssysbihierarchyname")) {
                            string = objectNode.get("pssysbihierarchyname").asText();
                        }
                        if (objectNode2.has("pssysbihierarchyname")) {
                            string2 = objectNode2.get("pssysbihierarchyname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (PSSysBIHierarchy pSSysBIHierarchy2 : arrayList) {
                    object = new PSSysBIHierarchy();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)pSSysBIHierarchy2, false);
                    object3.add((JsonNode)pSSysBIHierarchyService.exportModelV2(object, string));
                }
            }
        }
        super.onExportCurModelV2(pSSysBIDimension, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSSysBIDimension pSSysBIDimension) throws Exception {
        super.onEmptyModelV2(pSSysBIDimension);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSSysBIHierarchyService pSSysBIHierarchyService = (PSSysBIHierarchyService)ServiceGlobal.getService(PSSysBIHierarchyService.class, (SessionFactory)this.getSessionFactory());
        if (pSSysBIHierarchyService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSSysBIDimension pSSysBIDimension, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSSysBIHierarchy pSSysBIHierarchy = new PSSysBIHierarchy();
        pSSysBIHierarchy.set("PSSYSBIDIMENSIONID", pSSysBIDimension.getPSSysBIDimensionId());
        PSSysBIHierarchyService pSSysBIHierarchyService = (PSSysBIHierarchyService)ServiceGlobal.getService(PSSysBIHierarchyService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSSysBIHierarchyService.getModelV2Entity(pSSysBIHierarchy, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSSysBIDimension, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSSysBIDimension pSSysBIDimension, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (!PSSysBIDimensionServiceBase.isSimpleImportExportMode("")) {
            PSSysBIHierarchyService pSSysBIHierarchyService = (PSSysBIHierarchyService)ServiceGlobal.getService(PSSysBIHierarchyService.class, (SessionFactory)this.getSessionFactory());
            ArrayNode arrayNode = null;
            String string3 = pSSysBIHierarchyService.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                    PSSysBIHierarchy pSSysBIHierarchy = new PSSysBIHierarchy();
                    pSSysBIHierarchy.setPSSysBIDimensionId(pSSysBIDimension.getPSSysBIDimensionId());
                    pSSysBIHierarchy.setPSSysBIDimensionName(pSSysBIDimension.getPSSysBIDimensionName());
                    pSSysBIHierarchyService.compileModelV2(pSSysBIHierarchy, objectNode2, string, null, n);
                }
            } else {
                String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                File file = new File(string4);
                if (file.exists()) {
                    File[] fileArray;
                    for (File file2 : fileArray = file.listFiles()) {
                        if (!file2.isDirectory()) continue;
                        PSSysBIHierarchy pSSysBIHierarchy = new PSSysBIHierarchy();
                        pSSysBIHierarchy.setPSSysBIDimensionId(pSSysBIDimension.getPSSysBIDimensionId());
                        pSSysBIHierarchy.setPSSysBIDimensionName(pSSysBIDimension.getPSSysBIDimensionName());
                        pSSysBIHierarchyService.compileModelV2(pSSysBIHierarchy, null, string, file2.getCanonicalPath(), n);
                    }
                }
            }
        }
        super.onCompileRelatedModelV2(pSSysBIDimension, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSSysBIDimension pSSysBIDimension, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSSYSBIHIERARCHY_PSSYSBIDIMENSION_PSSYSBIDIMENSIONID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSSysBIHierarchies(pSSysBIDimension, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSSysBIDimension, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSSysBIHierarchies(PSSysBIDimension pSSysBIDimension, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSSYSBIHIERARCHY", true), (boolean)false) == 0) {
            PSSysBIHierarchyService pSSysBIHierarchyService = (PSSysBIHierarchyService)ServiceGlobal.getService(PSSysBIHierarchyService.class, (SessionFactory)this.getSessionFactory());
            PSSysBIHierarchy pSSysBIHierarchy = new PSSysBIHierarchy();
            pSSysBIHierarchy.setPSSysBIHierarchyId(pSMOSFile.getPSModelId());
            if (!pSSysBIHierarchyService.get((IEntity)pSSysBIHierarchy, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSSysBIHierarchy.getPSSysBIDimensionId(), (String)pSSysBIDimension.getPSSysBIDimensionId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSSysBIHierarchyService.exportModelV2(pSSysBIHierarchy);
            pSSysBIHierarchy.reset();
            if (!pSSysBIHierarchyService.setModelV2ResScope((IEntity)pSSysBIHierarchy, "PSSYSBIDIMENSION", pSSysBIDimension.getPSSysBIDimensionId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSSysBIHierarchyService.importModelV2(pSSysBIHierarchy, objectNode);
            SessionFactoryManager.commit();
            return pSSysBIHierarchyService.getFile((IEntity)pSSysBIHierarchy);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSSysBIDimension pSSysBIDimension, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSSysBIHierarchies(pSSysBIDimension, list);
        super.onFillPasteHelps(pSSysBIDimension, list);
    }

    protected void onFillPasteHelps_PSSysBIHierarchies(PSSysBIDimension pSSysBIDimension, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSSYSBIHIERARCHY");
        pSHelpSection.setSectionParam2("DER1N_PSSYSBIHIERARCHY_PSSYSBIDIMENSION_PSSYSBIDIMENSIONID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u667a\u80fd\u62a5\u8868\u7ef4\u5ea6]\u7684[\u667a\u80fd\u62a5\u8868\u7ef4\u5ea6\u4f53\u7cfb]");
        list.add(pSHelpSection);
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSSysBIDimension pSSysBIDimension, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "Dimension");
    }
}

