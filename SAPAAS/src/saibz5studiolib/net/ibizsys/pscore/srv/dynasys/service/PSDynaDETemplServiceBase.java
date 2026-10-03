/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.EntityError
 *  net.ibizsys.paas.entity.EntityFieldError
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.CloneSession
 *  net.ibizsys.paas.service.IDataContextParam
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.dynasys.service;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.CloneSession;
import net.ibizsys.paas.service.IDataContextParam;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityServiceBase;
import net.ibizsys.pscore.srv.dynasys.dao.PSDynaDETemplDAO;
import net.ibizsys.pscore.srv.dynasys.demodel.PSDynaDETemplDEModel;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaDETempl;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaDEFormTemplService;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaDEFormTemplServiceBase;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaDEViewTemplService;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaDEViewTemplServiceBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDynaDETemplServiceBase
extends PSCoreSysServiceBase<PSDynaDETempl> {
    private static final Log log = LogFactory.getLog(PSDynaDETemplServiceBase.class);
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDynaDETemplDEModel pSDynaDETemplDEModel;
    private PSDynaDETemplDAO pSDynaDETemplDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dynasys.service.PSDynaDETemplService";
    }

    public PSDynaDETemplDEModel getPSDynaDETemplDEModel() {
        if (this.pSDynaDETemplDEModel == null) {
            try {
                this.pSDynaDETemplDEModel = (PSDynaDETemplDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dynasys.demodel.PSDynaDETemplDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDynaDETemplDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDynaDETemplDEModel();
    }

    public PSDynaDETemplDAO getPSDynaDETemplDAO() {
        if (this.pSDynaDETemplDAO == null) {
            try {
                this.pSDynaDETemplDAO = (PSDynaDETemplDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dynasys.dao.PSDynaDETemplDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDynaDETemplDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDynaDETemplDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchCurSys(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurSys(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYS, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSDynaDETempl pSDynaDETempl, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDYNADETEMPL_PSDATAENTITY_TEMPLPSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDataEntity);
            } else {
                iService.get(pSDataEntity);
            }
            this.onFillParentInfo_TemplPSDE(pSDynaDETempl, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDYNADETEMPL_PSDEFIELD_TYPEPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_TypePSDEF(pSDynaDETempl, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDYNADETEMPL_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSystem);
            } else {
                iService.get(pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSDynaDETempl, pSSystem);
            return;
        }
        super.onFillParentInfo(pSDynaDETempl, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_TemplPSDE(PSDynaDETempl pSDynaDETempl, PSDataEntity pSDataEntity) throws Exception {
        pSDynaDETempl.setTemplPSDEId(pSDataEntity.getPSDataEntityId());
        pSDynaDETempl.setTemplPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_TypePSDEF(PSDynaDETempl pSDynaDETempl, PSDEField pSDEField) throws Exception {
        pSDynaDETempl.setTypePSDEFId(pSDEField.getPSDEFieldId());
        pSDynaDETempl.setTypePSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_PSSystem(PSDynaDETempl pSDynaDETempl, PSSystem pSSystem) throws Exception {
        pSDynaDETempl.setPSSystemId(pSSystem.getPSSystemId());
        pSDynaDETempl.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected boolean onFillEntityKeyValue(PSDynaDETempl pSDynaDETempl, boolean bl) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        Object object = pSDynaDETempl.get("PSSYSTEMID");
        if (object == null) {
            object = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object);
        stringBuilderEx.append("||");
        Object object2 = pSDynaDETempl.get("TEMPLPSDEID");
        if (object2 == null) {
            object2 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object2);
        String string = stringBuilderEx.toString();
        pSDynaDETempl.set(this.getPSDynaDETemplDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId((String)string));
        return true;
    }

    protected void onFillEntityFullInfo(PSDynaDETempl pSDynaDETempl, boolean bl) throws Exception {
        if (bl && pSDynaDETempl.getValidFlag() == null) {
            pSDynaDETempl.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSDynaDETempl, bl);
        this.onFillEntityFullInfo_TemplPSDE(pSDynaDETempl, bl);
        this.onFillEntityFullInfo_TypePSDEF(pSDynaDETempl, bl);
        this.onFillEntityFullInfo_PSSystem(pSDynaDETempl, bl);
    }

    protected void onFillEntityFullInfo_TemplPSDE(PSDynaDETempl pSDynaDETempl, boolean bl) throws Exception {
        if (pSDynaDETempl.isTemplPSDEIdDirty()) {
            if (pSDynaDETempl.getTemplPSDEId() != null) {
                if (pSDynaDETempl.getTemplPSDEId() == null || pSDynaDETempl.getTemplPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSDynaDETempl.getTemplPSDE();
                    pSDynaDETempl.setTemplPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDynaDETempl.setTemplPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_TypePSDEF(PSDynaDETempl pSDynaDETempl, boolean bl) throws Exception {
        if (pSDynaDETempl.isTypePSDEFIdDirty()) {
            if (pSDynaDETempl.getTypePSDEFId() != null) {
                if (pSDynaDETempl.getTypePSDEFId() == null || pSDynaDETempl.getTypePSDEFName() == null) {
                    PSDEField pSDEField = pSDynaDETempl.getTypePSDEF();
                    pSDynaDETempl.setTypePSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDynaDETempl.setTypePSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSystem(PSDynaDETempl pSDynaDETempl, boolean bl) throws Exception {
        if (pSDynaDETempl.isPSSystemIdDirty()) {
            if (pSDynaDETempl.getPSSystemId() != null) {
                if (pSDynaDETempl.getPSSystemId() == null || pSDynaDETempl.getPSSystemName() == null) {
                    PSSystem pSSystem = pSDynaDETempl.getPSSystem();
                    pSDynaDETempl.setPSSystemName(pSSystem.getPSSystemName());
                }
            } else {
                pSDynaDETempl.setPSSystemName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDynaDETempl pSDynaDETempl, boolean bl) throws Exception {
        super.onWriteBackParent(pSDynaDETempl, bl);
    }

    public ArrayList<PSDynaDETempl> selectByTemplPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByTemplPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDynaDETempl> selectByTemplPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByTemplPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDynaDETempl> selectByTemplPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("TEMPLPSDEID", (Object)pSDataEntityBase.getPSDataEntityId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByTemplPSDECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByTemplPSDECond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDynaDETempl> selectByTypePSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByTypePSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDynaDETempl> selectByTypePSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByTypePSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDynaDETempl> selectByTypePSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("TYPEPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByTypePSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByTypePSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDynaDETempl> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSDynaDETempl> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSDynaDETempl> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSTEMID", (Object)pSSystemBase.getPSSystemId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSystemCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSystemCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByTemplPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDynaDETempl> arrayList = this.selectByTemplPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDYNADETEMPL_PSDATAENTITY_TEMPLPSDEID", "", iDataEntityModel.getName(), "PSDYNADETEMPL", iDataEntityModel.getDataInfo(pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetTemplPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDynaDETempl> arrayList = this.selectByTemplPSDE(pSDataEntity);
        for (PSDynaDETempl pSDynaDETempl : arrayList) {
            PSDynaDETempl pSDynaDETempl2 = (PSDynaDETempl)this.getDEModel().createEntity();
            pSDynaDETempl2.setPSDynaDETemplId(pSDynaDETempl.getPSDynaDETemplId());
            pSDynaDETempl2.setTemplPSDEId(null);
            this.update(pSDynaDETempl2);
        }
    }

    public void removeByTemplPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDynaDETemplServiceBase.this.onBeforeRemoveByTemplPSDE(pSDataEntity2);
                PSDynaDETemplServiceBase.this.internalRemoveByTemplPSDE(pSDataEntity2);
                PSDynaDETemplServiceBase.this.onAfterRemoveByTemplPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByTemplPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByTemplPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDynaDETempl> arrayList = this.selectByTemplPSDE(pSDataEntity);
        this.onBeforeRemoveByTemplPSDE(pSDataEntity, arrayList);
        for (PSDynaDETempl pSDynaDETempl : arrayList) {
            this.remove(pSDynaDETempl);
        }
        this.onAfterRemoveByTemplPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByTemplPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByTemplPSDE(PSDataEntity pSDataEntity, ArrayList<PSDynaDETempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTemplPSDE(PSDataEntity pSDataEntity, ArrayList<PSDynaDETempl> arrayList) throws Exception {
    }

    public void testRemoveByTypePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDynaDETempl> arrayList = this.selectByTypePSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDYNADETEMPL_PSDEFIELD_TYPEPSDEFID", "", iDataEntityModel.getName(), "PSDYNADETEMPL", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetTypePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDynaDETempl> arrayList = this.selectByTypePSDEF(pSDEField);
        for (PSDynaDETempl pSDynaDETempl : arrayList) {
            PSDynaDETempl pSDynaDETempl2 = (PSDynaDETempl)this.getDEModel().createEntity();
            pSDynaDETempl2.setPSDynaDETemplId(pSDynaDETempl.getPSDynaDETemplId());
            pSDynaDETempl2.setTypePSDEFId(null);
            this.update(pSDynaDETempl2);
        }
    }

    public void removeByTypePSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDynaDETemplServiceBase.this.onBeforeRemoveByTypePSDEF(pSDEField2);
                PSDynaDETemplServiceBase.this.internalRemoveByTypePSDEF(pSDEField2);
                PSDynaDETemplServiceBase.this.onAfterRemoveByTypePSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByTypePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByTypePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDynaDETempl> arrayList = this.selectByTypePSDEF(pSDEField);
        this.onBeforeRemoveByTypePSDEF(pSDEField, arrayList);
        for (PSDynaDETempl pSDynaDETempl : arrayList) {
            this.remove(pSDynaDETempl);
        }
        this.onAfterRemoveByTypePSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByTypePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByTypePSDEF(PSDEField pSDEField, ArrayList<PSDynaDETempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTypePSDEF(PSDEField pSDEField, ArrayList<PSDynaDETempl> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSDynaDETempl> arrayList = this.selectByPSSystem(pSSystem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSTEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSystem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDYNADETEMPL_PSSYSTEM_PSSYSTEMID", "", iDataEntityModel.getName(), "PSDYNADETEMPL", iDataEntityModel.getDataInfo(pSSystem), arrayList.get(0)));
        }
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSDynaDETempl> arrayList = this.selectByPSSystem(pSSystem);
        for (PSDynaDETempl pSDynaDETempl : arrayList) {
            PSDynaDETempl pSDynaDETempl2 = (PSDynaDETempl)this.getDEModel().createEntity();
            pSDynaDETempl2.setPSDynaDETemplId(pSDynaDETempl.getPSDynaDETemplId());
            pSDynaDETempl2.setPSSystemId(null);
            this.update(pSDynaDETempl2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDynaDETemplServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSDynaDETemplServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSDynaDETemplServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSDynaDETempl> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSDynaDETempl pSDynaDETempl : arrayList) {
            this.remove(pSDynaDETempl);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSDynaDETempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSDynaDETempl> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDynaDETempl pSDynaDETempl) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
        ((PSDataEntityServiceBase)pSCoreSysServiceBase).testRemoveByPSDynaDETempl(pSDynaDETempl);
        pSCoreSysServiceBase = (PSDynaDEFormTemplService)ServiceGlobal.getService(PSDynaDEFormTemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSDynaDEFormTemplServiceBase)pSCoreSysServiceBase).testRemoveByPSDynaDETempl(pSDynaDETempl);
        pSCoreSysServiceBase = (PSDynaDEViewTemplService)ServiceGlobal.getService(PSDynaDEViewTemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSDynaDEViewTemplServiceBase)pSCoreSysServiceBase).testRemoveByPSDynaDETempl(pSDynaDETempl);
        ((PSDynaDEViewTemplServiceBase)pSCoreSysServiceBase).removeByPSDynaDETempl(pSDynaDETempl);
        super.onBeforeRemove(pSDynaDETempl);
    }

    protected void replaceParentInfo(PSDynaDETempl pSDynaDETempl, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDynaDETempl, cloneSession);
        if (pSDynaDETempl.getTemplPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDynaDETempl.getTemplPSDEId())) != null) {
            this.onFillParentInfo_TemplPSDE(pSDynaDETempl, (PSDataEntity)iEntity);
        }
        if (pSDynaDETempl.getTypePSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDynaDETempl.getTypePSDEFId())) != null) {
            this.onFillParentInfo_TypePSDEF(pSDynaDETempl, (PSDEField)iEntity);
        }
        if (pSDynaDETempl.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSDynaDETempl.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSDynaDETempl, (PSSystem)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDynaDETempl pSDynaDETempl, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDynaDETempl, bl);
    }

    protected void onCheckEntity(boolean bl, PSDynaDETempl pSDynaDETempl, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSDynaDETempl, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaDETemplId(bl, pSDynaDETempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaDETemplName(bl, pSDynaDETempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSDynaDETempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemName(bl, pSDynaDETempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplPSDEId(bl, pSDynaDETempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplPSDEName(bl, pSDynaDETempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TypePSDEFId(bl, pSDynaDETempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TypePSDEFName(bl, pSDynaDETempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDynaDETempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDynaDETempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDynaDETempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDynaDETempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDynaDETempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDynaDETempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDynaDETempl, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDynaDETempl pSDynaDETempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaDETempl.isMemoDirty() : !pSDynaDETempl.isMemoDirty()) {
            return null;
        }
        String string = pSDynaDETempl.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDynaDETempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDynaDETemplId(boolean bl, PSDynaDETempl pSDynaDETempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaDETempl.isPSDynaDETemplIdDirty() && !bl2 : !pSDynaDETempl.isPSDynaDETemplIdDirty()) {
            return null;
        }
        String string = pSDynaDETempl.getPSDynaDETemplId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNADETEMPLID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaDETemplId_Default(pSDynaDETempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNADETEMPLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaDETemplName(boolean bl, PSDynaDETempl pSDynaDETempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaDETempl.isPSDynaDETemplNameDirty() && !bl2 : !pSDynaDETempl.isPSDynaDETemplNameDirty()) {
            return null;
        }
        String string = pSDynaDETempl.getPSDynaDETemplName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNADETEMPLNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaDETemplName_Default(pSDynaDETempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNADETEMPLNAME");
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
                string3 = "TEMPLPSDEID";
                String string4 = this.checkFieldDupRule(this.getPSDynaDETemplDEModel(), "PSDYNADETEMPLNAME", string3, pSDynaDETempl, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDYNADETEMPLNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSDynaDETempl pSDynaDETempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaDETempl.isPSSystemIdDirty() && !bl2 : !pSDynaDETempl.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSDynaDETempl.getPSSystemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default(pSDynaDETempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemName(boolean bl, PSDynaDETempl pSDynaDETempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaDETempl.isPSSystemNameDirty() && !bl2 : !pSDynaDETempl.isPSSystemNameDirty()) {
            return null;
        }
        String string = pSDynaDETempl.getPSSystemName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemName_Default(pSDynaDETempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TemplPSDEId(boolean bl, PSDynaDETempl pSDynaDETempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaDETempl.isTemplPSDEIdDirty() && !bl2 : !pSDynaDETempl.isTemplPSDEIdDirty()) {
            return null;
        }
        String string = pSDynaDETempl.getTemplPSDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPLPSDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_TemplPSDEId_Default(pSDynaDETempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPLPSDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TemplPSDEName(boolean bl, PSDynaDETempl pSDynaDETempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaDETempl.isTemplPSDENameDirty() && !bl2 : !pSDynaDETempl.isTemplPSDENameDirty()) {
            return null;
        }
        String string = pSDynaDETempl.getTemplPSDEName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPLPSDENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_TemplPSDEName_Default(pSDynaDETempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPLPSDENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TypePSDEFId(boolean bl, PSDynaDETempl pSDynaDETempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaDETempl.isTypePSDEFIdDirty() && !bl2 : !pSDynaDETempl.isTypePSDEFIdDirty()) {
            return null;
        }
        String string = pSDynaDETempl.getTypePSDEFId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TYPEPSDEFID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_TypePSDEFId_Default(pSDynaDETempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TYPEPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TypePSDEFName(boolean bl, PSDynaDETempl pSDynaDETempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaDETempl.isTypePSDEFNameDirty() : !pSDynaDETempl.isTypePSDEFNameDirty()) {
            return null;
        }
        String string = pSDynaDETempl.getTypePSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TypePSDEFName_Default(pSDynaDETempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TYPEPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDynaDETempl pSDynaDETempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaDETempl.isUserCatDirty() : !pSDynaDETempl.isUserCatDirty()) {
            return null;
        }
        String string = pSDynaDETempl.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSDynaDETempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDynaDETempl pSDynaDETempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaDETempl.isUserTagDirty() : !pSDynaDETempl.isUserTagDirty()) {
            return null;
        }
        String string = pSDynaDETempl.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDynaDETempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDynaDETempl pSDynaDETempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaDETempl.isUserTag2Dirty() : !pSDynaDETempl.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDynaDETempl.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDynaDETempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDynaDETempl pSDynaDETempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaDETempl.isUserTag3Dirty() : !pSDynaDETempl.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDynaDETempl.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSDynaDETempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDynaDETempl pSDynaDETempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaDETempl.isUserTag4Dirty() : !pSDynaDETempl.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDynaDETempl.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSDynaDETempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDynaDETempl pSDynaDETempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaDETempl.isValidFlagDirty() && !bl2 : !pSDynaDETempl.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDynaDETempl.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSDynaDETempl, bl2, bl3);
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

    protected void onSyncEntity(PSDynaDETempl pSDynaDETempl, boolean bl) throws Exception {
        super.onSyncEntity(pSDynaDETempl, bl);
    }

    protected void onSyncIndexEntities(PSDynaDETempl pSDynaDETempl, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDynaDETempl, bl);
    }

    public Object getDataContextValue(PSDynaDETempl pSDynaDETempl, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null && StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEFIELD", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"TYPEPSDEFID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"TYPEPSDEFNAME", (boolean)true) == 0) && (object = super.getDataContextValue(pSDynaDETempl, "templpsdeid", iDataContextParam)) != null) {
            return object;
        }
        object = super.getDataContextValue(pSDynaDETempl, string, iDataContextParam);
        if (object != null) {
            return object;
        }
        PSSystem pSSystem = pSDynaDETempl.getPSSystem();
        if (pSSystem != null && pSSystem.contains(string)) {
            return pSSystem.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDynaDETempl pSDynaDETempl, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDynaDETempl, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNADETEMPLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaDETemplId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNADETEMPLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaDETemplName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLPSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplPSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLPSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplPSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TYPEPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TypePSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TYPEPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TypePSDEFName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSDynaDETemplId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNADETEMPLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaDETemplName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNADETEMPLNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSystemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSystemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TemplPSDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TEMPLPSDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TemplPSDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TEMPLPSDENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TypePSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TYPEPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TypePSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TYPEPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected boolean onMergeChild(String string, String string2, PSDynaDETempl pSDynaDETempl) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDynaDETempl)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDynaDETempl pSDynaDETempl) throws Exception {
        super.onUpdateParent(pSDynaDETempl);
    }

    @Override
    protected void exportCurXmlModel(PSDynaDETempl pSDynaDETempl, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDYNADETEMPL");
        if (!bl) {
            pSDynaDETempl.setCreateDate(null);
            pSDynaDETempl.setCreateMan(null);
            pSDynaDETempl.setPSDynaDETemplId(null);
            pSDynaDETempl.setUpdateDate(null);
            pSDynaDETempl.setUpdateMan(null);
            super.exportCurXmlModel(pSDynaDETempl, xmlNode, bl);
        }
    }

    @Override
    protected String getEntityFolderKeyValue(PSDynaDETempl pSDynaDETempl, PSSystem pSSystem) throws Exception {
        PSDynaDETempl pSDynaDETempl2 = new PSDynaDETempl();
        pSDynaDETempl2.setPSSystemId(pSDynaDETempl.getPSSystemId());
        pSDynaDETempl2.setTemplPSDEId(pSDynaDETempl.getTemplPSDEId());
        if (this.selectOne(pSDynaDETempl2, true)) {
            return pSDynaDETempl2.getPSDynaDETemplId();
        }
        return super.getEntityFolderKeyValue(pSDynaDETempl, pSSystem);
    }
}

