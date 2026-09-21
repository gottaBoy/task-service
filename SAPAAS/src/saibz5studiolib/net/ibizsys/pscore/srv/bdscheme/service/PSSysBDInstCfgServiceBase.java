/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
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
package net.ibizsys.pscore.srv.bdscheme.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.HashMap;
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
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.bdscheme.dao.PSSysBDInstCfgDAO;
import net.ibizsys.pscore.srv.bdscheme.demodel.PSSysBDInstCfgDEModel;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDInstCfg;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCBDInst;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCBDInstBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemRunService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysBDInstCfgServiceBase
extends PSCoreSysServiceBase<PSSysBDInstCfg> {
    private static final Log log = LogFactory.getLog(PSSysBDInstCfgServiceBase.class);
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysBDInstCfgDEModel pSSysBDInstCfgDEModel;
    private PSSysBDInstCfgDAO pSSysBDInstCfgDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.bdscheme.service.PSSysBDInstCfgService";
    }

    public PSSysBDInstCfgDEModel getPSSysBDInstCfgDEModel() {
        if (this.pSSysBDInstCfgDEModel == null) {
            try {
                this.pSSysBDInstCfgDEModel = (PSSysBDInstCfgDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.bdscheme.demodel.PSSysBDInstCfgDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysBDInstCfgDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysBDInstCfgDEModel();
    }

    public PSSysBDInstCfgDAO getPSSysBDInstCfgDAO() {
        if (this.pSSysBDInstCfgDAO == null) {
            try {
                this.pSSysBDInstCfgDAO = (PSSysBDInstCfgDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.bdscheme.dao.PSSysBDInstCfgDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysBDInstCfgDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysBDInstCfgDAO();
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

    protected void onFillParentInfo(PSSysBDInstCfg pSSysBDInstCfg, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBDINSTCFG_PSDCBDINST_PSDCBDINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCBDInstService", (SessionFactory)this.getSessionFactory());
            PSDCBDInst pSDCBDInst = (PSDCBDInst)iService.getDEModel().createEntity();
            pSDCBDInst.set("PSDCBDINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDCBDInst);
            } else {
                iService.get((IEntity)pSDCBDInst);
            }
            this.onFillParentInfo_PSDCBDInst(pSSysBDInstCfg, pSDCBDInst);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBDINSTCFG_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSystem);
            } else {
                iService.get((IEntity)pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSSysBDInstCfg, pSSystem);
            return;
        }
        super.onFillParentInfo((IEntity)pSSysBDInstCfg, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDCBDInst(PSSysBDInstCfg pSSysBDInstCfg, PSDCBDInst pSDCBDInst) throws Exception {
        pSSysBDInstCfg.setPSDCBDInstId(pSDCBDInst.getPSDCBDInstId());
        pSSysBDInstCfg.setPSDCBDInstName(pSDCBDInst.getPSDCBDInstName());
    }

    protected void onFillParentInfo_PSSystem(PSSysBDInstCfg pSSysBDInstCfg, PSSystem pSSystem) throws Exception {
        pSSysBDInstCfg.setPSSystemId(pSSystem.getPSSystemId());
        pSSysBDInstCfg.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected boolean onFillEntityKeyValue(PSSysBDInstCfg pSSysBDInstCfg, boolean bl) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        Object object = pSSysBDInstCfg.get("PSSYSTEMID");
        if (object == null) {
            object = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object);
        stringBuilderEx.append("||");
        Object object2 = pSSysBDInstCfg.get("PSSYSBDINSTCFGNAME");
        if (object2 == null) {
            object2 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object2);
        String string = stringBuilderEx.toString();
        pSSysBDInstCfg.set(this.getPSSysBDInstCfgDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId((String)string));
        return true;
    }

    protected void onFillEntityFullInfo(PSSysBDInstCfg pSSysBDInstCfg, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSSysBDInstCfg, bl);
        this.onFillEntityFullInfo_PSDCBDInst(pSSysBDInstCfg, bl);
        this.onFillEntityFullInfo_PSSystem(pSSysBDInstCfg, bl);
    }

    protected void onFillEntityFullInfo_PSDCBDInst(PSSysBDInstCfg pSSysBDInstCfg, boolean bl) throws Exception {
        if (pSSysBDInstCfg.isPSDCBDInstIdDirty()) {
            if (pSSysBDInstCfg.getPSDCBDInstId() != null) {
                if (pSSysBDInstCfg.getPSDCBDInstId() == null || pSSysBDInstCfg.getPSDCBDInstName() == null) {
                    PSDCBDInst pSDCBDInst = pSSysBDInstCfg.getPSDCBDInst();
                    pSSysBDInstCfg.setPSDCBDInstName(pSDCBDInst.getPSDCBDInstName());
                }
            } else {
                pSSysBDInstCfg.setPSDCBDInstName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSystem(PSSysBDInstCfg pSSysBDInstCfg, boolean bl) throws Exception {
        if (pSSysBDInstCfg.isPSSystemIdDirty()) {
            if (pSSysBDInstCfg.getPSSystemId() != null) {
                if (pSSysBDInstCfg.getPSSystemId() == null || pSSysBDInstCfg.getPSSystemName() == null) {
                    PSSystem pSSystem = pSSysBDInstCfg.getPSSystem();
                    pSSysBDInstCfg.setPSSystemName(pSSystem.getPSSystemName());
                }
            } else {
                pSSysBDInstCfg.setPSSystemName(null);
            }
        }
    }

    protected void onWriteBackParent(PSSysBDInstCfg pSSysBDInstCfg, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSysBDInstCfg, bl);
    }

    public ArrayList<PSSysBDInstCfg> selectByPSDCBDInst(PSDCBDInstBase pSDCBDInstBase) throws Exception {
        return this.selectByPSDCBDInst(pSDCBDInstBase, "", -1);
    }

    public ArrayList<PSSysBDInstCfg> selectByPSDCBDInst(PSDCBDInstBase pSDCBDInstBase, String string) throws Exception {
        return this.selectByPSDCBDInst(pSDCBDInstBase, string, -1);
    }

    public ArrayList<PSSysBDInstCfg> selectByPSDCBDInst(PSDCBDInstBase pSDCBDInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDCBDINSTID", (Object)pSDCBDInstBase.getPSDCBDInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDCBDInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDCBDInstCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysBDInstCfg> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSSysBDInstCfg> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSSysBDInstCfg> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
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

    public void testRemoveByPSDCBDInst(PSDCBDInst pSDCBDInst) throws Exception {
        ArrayList<PSSysBDInstCfg> arrayList = this.selectByPSDCBDInst(pSDCBDInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCBDINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDCBDInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBDINSTCFG_PSDCBDINST_PSDCBDINSTID", "", iDataEntityModel.getName(), "PSSYSBDINSTCFG", iDataEntityModel.getDataInfo((IEntity)pSDCBDInst), arrayList.get(0)));
        }
    }

    public void resetPSDCBDInst(PSDCBDInst pSDCBDInst) throws Exception {
        ArrayList<PSSysBDInstCfg> arrayList = this.selectByPSDCBDInst(pSDCBDInst);
        for (PSSysBDInstCfg pSSysBDInstCfg : arrayList) {
            PSSysBDInstCfg pSSysBDInstCfg2 = (PSSysBDInstCfg)this.getDEModel().createEntity();
            pSSysBDInstCfg2.setPSSysBDInstCfgId(pSSysBDInstCfg.getPSSysBDInstCfgId());
            pSSysBDInstCfg2.setPSDCBDInstId(null);
            this.update(pSSysBDInstCfg2);
        }
    }

    public void removeByPSDCBDInst(PSDCBDInst pSDCBDInst) throws Exception {
        final PSDCBDInst pSDCBDInst2 = pSDCBDInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBDInstCfgServiceBase.this.onBeforeRemoveByPSDCBDInst(pSDCBDInst2);
                PSSysBDInstCfgServiceBase.this.internalRemoveByPSDCBDInst(pSDCBDInst2);
                PSSysBDInstCfgServiceBase.this.onAfterRemoveByPSDCBDInst(pSDCBDInst2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCBDInst(PSDCBDInst pSDCBDInst) throws Exception {
    }

    protected void internalRemoveByPSDCBDInst(PSDCBDInst pSDCBDInst) throws Exception {
        ArrayList<PSSysBDInstCfg> arrayList = this.selectByPSDCBDInst(pSDCBDInst);
        this.onBeforeRemoveByPSDCBDInst(pSDCBDInst, arrayList);
        for (PSSysBDInstCfg pSSysBDInstCfg : arrayList) {
            this.remove((IEntity)pSSysBDInstCfg);
        }
        this.onAfterRemoveByPSDCBDInst(pSDCBDInst, arrayList);
    }

    protected void onAfterRemoveByPSDCBDInst(PSDCBDInst pSDCBDInst) throws Exception {
    }

    protected void onBeforeRemoveByPSDCBDInst(PSDCBDInst pSDCBDInst, ArrayList<PSSysBDInstCfg> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCBDInst(PSDCBDInst pSDCBDInst, ArrayList<PSSysBDInstCfg> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysBDInstCfg> arrayList = this.selectByPSSystem(pSSystem);
        for (PSSysBDInstCfg pSSysBDInstCfg : arrayList) {
            PSSysBDInstCfg pSSysBDInstCfg2 = (PSSysBDInstCfg)this.getDEModel().createEntity();
            pSSysBDInstCfg2.setPSSysBDInstCfgId(pSSysBDInstCfg.getPSSysBDInstCfgId());
            pSSysBDInstCfg2.setPSSystemId(null);
            this.update(pSSysBDInstCfg2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBDInstCfgServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSSysBDInstCfgServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSSysBDInstCfgServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysBDInstCfg> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSSysBDInstCfg pSSysBDInstCfg : arrayList) {
            this.remove((IEntity)pSSysBDInstCfg);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysBDInstCfg> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysBDInstCfg> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysBDInstCfg pSSysBDInstCfg) throws Exception {
        PSSystemRunService pSSystemRunService = (PSSystemRunService)ServiceGlobal.getService(PSSystemRunService.class, (SessionFactory)this.getSessionFactory());
        pSSystemRunService.testRemoveByPSSysBDInstCfg(pSSysBDInstCfg);
        super.onBeforeRemove(pSSysBDInstCfg);
    }

    protected void replaceParentInfo(PSSysBDInstCfg pSSysBDInstCfg, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSysBDInstCfg, cloneSession);
        if (pSSysBDInstCfg.getPSDCBDInstId() != null && (iEntity = cloneSession.getEntity("PSDCBDINST", (Object)pSSysBDInstCfg.getPSDCBDInstId())) != null) {
            this.onFillParentInfo_PSDCBDInst(pSSysBDInstCfg, (PSDCBDInst)iEntity);
        }
        if (pSSysBDInstCfg.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSSysBDInstCfg.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSSysBDInstCfg, (PSSystem)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysBDInstCfg pSSysBDInstCfg, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSysBDInstCfg, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysBDInstCfg pSSysBDInstCfg, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSSysBDInstCfg, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCBDInstId(bl, pSSysBDInstCfg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCBDInstName(bl, pSSysBDInstCfg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBDInstCfgId(bl, pSSysBDInstCfg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBDInstCfgName(bl, pSSysBDInstCfg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSSysBDInstCfg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemName(bl, pSSysBDInstCfg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysBDInstCfg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysBDInstCfg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysBDInstCfg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysBDInstCfg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysBDInstCfg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSysBDInstCfg, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysBDInstCfg pSSysBDInstCfg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDInstCfg.isMemoDirty() : !pSSysBDInstCfg.isMemoDirty()) {
            return null;
        }
        String string = pSSysBDInstCfg.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSSysBDInstCfg, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDCBDInstId(boolean bl, PSSysBDInstCfg pSSysBDInstCfg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDInstCfg.isPSDCBDInstIdDirty() : !pSSysBDInstCfg.isPSDCBDInstIdDirty()) {
            return null;
        }
        String string = pSSysBDInstCfg.getPSDCBDInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCBDInstId_Default((IEntity)pSSysBDInstCfg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCBDINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCBDInstName(boolean bl, PSSysBDInstCfg pSSysBDInstCfg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDInstCfg.isPSDCBDInstNameDirty() : !pSSysBDInstCfg.isPSDCBDInstNameDirty()) {
            return null;
        }
        String string = pSSysBDInstCfg.getPSDCBDInstName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCBDInstName_Default((IEntity)pSSysBDInstCfg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCBDINSTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBDInstCfgId(boolean bl, PSSysBDInstCfg pSSysBDInstCfg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDInstCfg.isPSSysBDInstCfgIdDirty() && !bl2 : !pSSysBDInstCfg.isPSSysBDInstCfgIdDirty()) {
            return null;
        }
        String string = pSSysBDInstCfg.getPSSysBDInstCfgId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBDINSTCFGID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBDInstCfgId_Default((IEntity)pSSysBDInstCfg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBDINSTCFGID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBDInstCfgName(boolean bl, PSSysBDInstCfg pSSysBDInstCfg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDInstCfg.isPSSysBDInstCfgNameDirty() && !bl2 : !pSSysBDInstCfg.isPSSysBDInstCfgNameDirty()) {
            return null;
        }
        String string = pSSysBDInstCfg.getPSSysBDInstCfgName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBDINSTCFGNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBDInstCfgName_Default((IEntity)pSSysBDInstCfg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBDINSTCFGNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSSysBDInstCfg pSSysBDInstCfg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDInstCfg.isPSSystemIdDirty() && !bl2 : !pSSysBDInstCfg.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSSysBDInstCfg.getPSSystemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default((IEntity)pSSysBDInstCfg, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemName(boolean bl, PSSysBDInstCfg pSSysBDInstCfg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDInstCfg.isPSSystemNameDirty() && !bl2 : !pSSysBDInstCfg.isPSSystemNameDirty()) {
            return null;
        }
        String string = pSSysBDInstCfg.getPSSystemName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemName_Default((IEntity)pSSysBDInstCfg, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysBDInstCfg pSSysBDInstCfg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDInstCfg.isUserCatDirty() : !pSSysBDInstCfg.isUserCatDirty()) {
            return null;
        }
        String string = pSSysBDInstCfg.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSSysBDInstCfg, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysBDInstCfg pSSysBDInstCfg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDInstCfg.isUserTagDirty() : !pSSysBDInstCfg.isUserTagDirty()) {
            return null;
        }
        String string = pSSysBDInstCfg.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSSysBDInstCfg, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysBDInstCfg pSSysBDInstCfg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDInstCfg.isUserTag2Dirty() : !pSSysBDInstCfg.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysBDInstCfg.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSSysBDInstCfg, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysBDInstCfg pSSysBDInstCfg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDInstCfg.isUserTag3Dirty() : !pSSysBDInstCfg.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysBDInstCfg.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSSysBDInstCfg, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysBDInstCfg pSSysBDInstCfg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDInstCfg.isUserTag4Dirty() : !pSSysBDInstCfg.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysBDInstCfg.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSSysBDInstCfg, bl2, bl3);
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

    protected void onSyncEntity(PSSysBDInstCfg pSSysBDInstCfg, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSysBDInstCfg, bl);
    }

    protected void onSyncIndexEntities(PSSysBDInstCfg pSSysBDInstCfg, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSysBDInstCfg, bl);
    }

    public Object getDataContextValue(PSSysBDInstCfg pSSysBDInstCfg, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSysBDInstCfg, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSysBDInstCfg pSSysBDInstCfg, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSysBDInstCfg, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PSDCBDINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCBDInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCBDINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCBDInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBDINSTCFGID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBDInstCfgId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBDINSTCFGNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBDInstCfgName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSDCBDInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCBDINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCBDInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCBDINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBDInstCfgId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBDINSTCFGID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBDInstCfgName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBDINSTCFGNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSSysBDInstCfg pSSysBDInstCfg) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSSysBDInstCfg)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysBDInstCfg pSSysBDInstCfg) throws Exception {
        super.onUpdateParent((IEntity)pSSysBDInstCfg);
    }

    @Override
    protected void exportCurXmlModel(PSSysBDInstCfg pSSysBDInstCfg, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSBDINSTCFG");
        if (!bl) {
            pSSysBDInstCfg.setCreateDate(null);
            pSSysBDInstCfg.setCreateMan(null);
            pSSysBDInstCfg.setPSSysBDInstCfgId(null);
            pSSysBDInstCfg.setUpdateDate(null);
            pSSysBDInstCfg.setUpdateMan(null);
            super.exportCurXmlModel(pSSysBDInstCfg, xmlNode, bl);
        }
    }

    @Override
    protected String getEntityFolderKeyValue(PSSysBDInstCfg pSSysBDInstCfg, PSSystem pSSystem) throws Exception {
        PSSysBDInstCfg pSSysBDInstCfg2 = new PSSysBDInstCfg();
        pSSysBDInstCfg2.setPSSystemId(pSSysBDInstCfg.getPSSystemId());
        pSSysBDInstCfg2.setPSSysBDInstCfgName(pSSysBDInstCfg.getPSSysBDInstCfgName());
        if (this.selectOne((IEntity)pSSysBDInstCfg2, true)) {
            return pSSysBDInstCfg2.getPSSysBDInstCfgId();
        }
        return super.getEntityFolderKeyValue(pSSysBDInstCfg, pSSystem);
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysBDInstCfg pSSysBDInstCfg, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysBDInstCfg, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSTEM#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSBDINSTCFG_PSSYSTEM_PSSYSTEMID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSYSTEM", (boolean)true) == 0) {
            iEntity.set("PSSYSTEMID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSSYSTEMID"};
    }

    @Override
    public String getModelV2Tag(PSSysBDInstCfg pSSysBDInstCfg) {
        if (!StringHelper.isNullOrEmpty((String)pSSysBDInstCfg.getPSSysBDInstCfgName())) {
            return pSSysBDInstCfg.getPSSysBDInstCfgName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysBDInstCfg.getPSSysBDInstCfgName())) {
            return pSSysBDInstCfg.getPSSysBDInstCfgName();
        }
        return super.getModelV2Tag(pSSysBDInstCfg);
    }

    @Override
    public boolean setModelV2Tag(PSSysBDInstCfg pSSysBDInstCfg, String string) {
        pSSysBDInstCfg.setPSSysBDInstCfgName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSSYSBDINSTCFGNAME", "");
        map.put("PSSYSBDINSTCFGNAME", "");
        map.put("PSSYSTEMID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysBDInstCfg pSSysBDInstCfg, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysBDInstCfg.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysBDInstCfg, true);
        pSSysBDInstCfg.set("PSSYSBDINSTCFGNAME", string);
        if (this.select(pSSysBDInstCfg, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysBDInstCfg, true);
        return super.getModelV2Entity(pSSysBDInstCfg, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysBDInstCfg pSSysBDInstCfg, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysBDInstCfg, objectNode, string, string2, n);
    }
}

