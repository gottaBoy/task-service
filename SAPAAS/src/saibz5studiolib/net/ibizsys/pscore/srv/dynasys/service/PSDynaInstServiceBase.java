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
 *  net.ibizsys.paas.service.IServicePlugin
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.DataTypeHelper
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
import net.ibizsys.paas.service.IServicePlugin;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormServiceBase;
import net.ibizsys.pscore.srv.dynasys.dao.PSDynaInstDAO;
import net.ibizsys.pscore.srv.dynasys.demodel.PSDynaInstDEModel;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaInst;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaSys;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaSysBase;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaAppViewInstService;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaAppViewInstServiceBase;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaCodeListInstService;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaCodeListInstServiceBase;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaDEFormInstService;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaDEFormInstServiceBase;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaWFVerInstService;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaWFVerInstServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeListServiceBase;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFVersionService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFVersionServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDynaInstServiceBase
extends PSCoreSysServiceBase<PSDynaInst> {
    private static final Log log = LogFactory.getLog(PSDynaInstServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_INITDYNAMODEL = "InitDynaModel";
    private PSDynaInstDEModel pSDynaInstDEModel;
    private PSDynaInstDAO pSDynaInstDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dynasys.service.PSDynaInstService";
    }

    public PSDynaInstDEModel getPSDynaInstDEModel() {
        if (this.pSDynaInstDEModel == null) {
            try {
                this.pSDynaInstDEModel = (PSDynaInstDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dynasys.demodel.PSDynaInstDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDynaInstDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDynaInstDEModel();
    }

    public PSDynaInstDAO getPSDynaInstDAO() {
        if (this.pSDynaInstDAO == null) {
            try {
                this.pSDynaInstDAO = (PSDynaInstDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dynasys.dao.PSDynaInstDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDynaInstDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDynaInstDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_INITDYNAMODEL, (boolean)true) == 0) {
            this.initDynaModel((PSDynaInst)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public void initDynaModel(PSDynaInst pSDynaInst) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_INITDYNAMODEL, 0, pSDynaInst, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDynaInst, ACTION_INITDYNAMODEL);
        final PSDynaInst pSDynaInst2 = pSDynaInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDynaInstServiceBase.this.getService(), PSDynaInstServiceBase.ACTION_INITDYNAMODEL, 40, pSDynaInst2, null).getResult() != 1) {
                    PSDynaInstServiceBase.this.onInitDynaModel(pSDynaInst2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_INITDYNAMODEL, 99, pSDynaInst, null);
        }
    }

    protected void onInitDynaModel(PSDynaInst pSDynaInst) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[InitDynaModel]");
    }

    protected void onFillParentInfo(PSDynaInst pSDynaInst, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDYNAINST_PSDYNASYS_PSDYNASYSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dynasys.service.PSDynaSysService", (SessionFactory)this.getSessionFactory());
            PSDynaSys pSDynaSys = (PSDynaSys)iService.getDEModel().createEntity();
            pSDynaSys.set("PSDYNASYSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDynaSys);
            } else {
                iService.get(pSDynaSys);
            }
            this.onFillParentInfo_PSDynaSys(pSDynaInst, pSDynaSys);
            return;
        }
        super.onFillParentInfo(pSDynaInst, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDynaSys(PSDynaInst pSDynaInst, PSDynaSys pSDynaSys) throws Exception {
        pSDynaInst.setPSDynaSysId(pSDynaSys.getPSDynaSysId());
        pSDynaInst.setPSDynaSysName(pSDynaSys.getPSDynaSysName());
    }

    protected void onFillEntityFullInfo(PSDynaInst pSDynaInst, boolean bl) throws Exception {
        if (bl) {
            if (pSDynaInst.getInstVer() == null) {
                pSDynaInst.setInstVer((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
            if (pSDynaInst.getValidFlag() == null) {
                pSDynaInst.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo(pSDynaInst, bl);
        this.onFillEntityFullInfo_PSDynaSys(pSDynaInst, bl);
    }

    protected void onFillEntityFullInfo_PSDynaSys(PSDynaInst pSDynaInst, boolean bl) throws Exception {
        if (pSDynaInst.isPSDynaSysIdDirty()) {
            if (pSDynaInst.getPSDynaSysId() != null) {
                if (pSDynaInst.getPSDynaSysId() == null || pSDynaInst.getPSDynaSysName() == null) {
                    PSDynaSys pSDynaSys = pSDynaInst.getPSDynaSys();
                    pSDynaInst.setPSDynaSysName(pSDynaSys.getPSDynaSysName());
                }
            } else {
                pSDynaInst.setPSDynaSysName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDynaInst pSDynaInst, boolean bl) throws Exception {
        super.onWriteBackParent(pSDynaInst, bl);
    }

    public ArrayList<PSDynaInst> selectByPSDynaSys(PSDynaSysBase pSDynaSysBase) throws Exception {
        return this.selectByPSDynaSys(pSDynaSysBase, "", -1);
    }

    public ArrayList<PSDynaInst> selectByPSDynaSys(PSDynaSysBase pSDynaSysBase, String string) throws Exception {
        return this.selectByPSDynaSys(pSDynaSysBase, string, -1);
    }

    public ArrayList<PSDynaInst> selectByPSDynaSys(PSDynaSysBase pSDynaSysBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDYNASYSID", (Object)pSDynaSysBase.getPSDynaSysId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDynaSysCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDynaSysCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDynaSys(PSDynaSys pSDynaSys) throws Exception {
        ArrayList<PSDynaInst> arrayList = this.selectByPSDynaSys(pSDynaSys, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDYNASYS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDynaSys);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDYNAINST_PSDYNASYS_PSDYNASYSID", "", iDataEntityModel.getName(), "PSDYNAINST", iDataEntityModel.getDataInfo(pSDynaSys), arrayList.get(0)));
        }
    }

    public void resetPSDynaSys(PSDynaSys pSDynaSys) throws Exception {
        ArrayList<PSDynaInst> arrayList = this.selectByPSDynaSys(pSDynaSys);
        for (PSDynaInst pSDynaInst : arrayList) {
            PSDynaInst pSDynaInst2 = (PSDynaInst)this.getDEModel().createEntity();
            pSDynaInst2.setPSDynaInstId(pSDynaInst.getPSDynaInstId());
            pSDynaInst2.setPSDynaSysId(null);
            this.update(pSDynaInst2);
        }
    }

    public void removeByPSDynaSys(PSDynaSys pSDynaSys) throws Exception {
        final PSDynaSys pSDynaSys2 = pSDynaSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDynaInstServiceBase.this.onBeforeRemoveByPSDynaSys(pSDynaSys2);
                PSDynaInstServiceBase.this.internalRemoveByPSDynaSys(pSDynaSys2);
                PSDynaInstServiceBase.this.onAfterRemoveByPSDynaSys(pSDynaSys2);
            }
        });
    }

    protected void onBeforeRemoveByPSDynaSys(PSDynaSys pSDynaSys) throws Exception {
    }

    protected void internalRemoveByPSDynaSys(PSDynaSys pSDynaSys) throws Exception {
        ArrayList<PSDynaInst> arrayList = this.selectByPSDynaSys(pSDynaSys);
        this.onBeforeRemoveByPSDynaSys(pSDynaSys, arrayList);
        for (PSDynaInst pSDynaInst : arrayList) {
            this.remove(pSDynaInst);
        }
        this.onAfterRemoveByPSDynaSys(pSDynaSys, arrayList);
    }

    protected void onAfterRemoveByPSDynaSys(PSDynaSys pSDynaSys) throws Exception {
    }

    protected void onBeforeRemoveByPSDynaSys(PSDynaSys pSDynaSys, ArrayList<PSDynaInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDynaSys(PSDynaSys pSDynaSys, ArrayList<PSDynaInst> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDynaInst pSDynaInst) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSCodeListService)ServiceGlobal.getService(PSCodeListService.class, (SessionFactory)this.getSessionFactory());
        ((PSCodeListServiceBase)pSCoreSysServiceBase).testRemoveByPSDynaInst(pSDynaInst);
        pSCoreSysServiceBase = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFormServiceBase)pSCoreSysServiceBase).testRemoveByPSDynaInst(pSDynaInst);
        pSCoreSysServiceBase = (PSDynaAppViewInstService)ServiceGlobal.getService(PSDynaAppViewInstService.class, (SessionFactory)this.getSessionFactory());
        ((PSDynaAppViewInstServiceBase)pSCoreSysServiceBase).testRemoveByPSDynaInst(pSDynaInst);
        ((PSDynaAppViewInstServiceBase)pSCoreSysServiceBase).removeByPSDynaInst(pSDynaInst);
        pSCoreSysServiceBase = (PSDynaCodeListInstService)ServiceGlobal.getService(PSDynaCodeListInstService.class, (SessionFactory)this.getSessionFactory());
        ((PSDynaCodeListInstServiceBase)pSCoreSysServiceBase).testRemoveByPSDynaInst(pSDynaInst);
        pSCoreSysServiceBase = (PSDynaDEFormInstService)ServiceGlobal.getService(PSDynaDEFormInstService.class, (SessionFactory)this.getSessionFactory());
        ((PSDynaDEFormInstServiceBase)pSCoreSysServiceBase).testRemoveByPSDynaInst(pSDynaInst);
        ((PSDynaDEFormInstServiceBase)pSCoreSysServiceBase).removeByPSDynaInst(pSDynaInst);
        pSCoreSysServiceBase = (PSDynaWFVerInstService)ServiceGlobal.getService(PSDynaWFVerInstService.class, (SessionFactory)this.getSessionFactory());
        ((PSDynaWFVerInstServiceBase)pSCoreSysServiceBase).testRemoveByPSDynaInst(pSDynaInst);
        pSCoreSysServiceBase = (PSWFVersionService)ServiceGlobal.getService(PSWFVersionService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFVersionServiceBase)pSCoreSysServiceBase).testRemoveByPSDynaInst(pSDynaInst);
        super.onBeforeRemove(pSDynaInst);
    }

    protected void replaceParentInfo(PSDynaInst pSDynaInst, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDynaInst, cloneSession);
        if (pSDynaInst.getPSDynaSysId() != null && (iEntity = cloneSession.getEntity("PSDYNASYS", (Object)pSDynaInst.getPSDynaSysId())) != null) {
            this.onFillParentInfo_PSDynaSys(pSDynaInst, (PSDynaSys)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDynaInst pSDynaInst, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDynaInst, bl);
    }

    protected void onCheckEntity(boolean bl, PSDynaInst pSDynaInst, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_InstMode(bl, pSDynaInst, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_InstVer(bl, pSDynaInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDynaInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSDynaInstId(bl, pSDynaInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSDynaInstName(bl, pSDynaInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysId(bl, pSDynaInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, pSDynaInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstName(bl, pSDynaInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaSysId(bl, pSDynaInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaSysName(bl, pSDynaInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDynaInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDynaInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDynaInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDynaInst, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_InstMode(boolean bl, PSDynaInst pSDynaInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaInst.isInstModeDirty() : !pSDynaInst.isInstModeDirty()) {
            return null;
        }
        String string = pSDynaInst.getInstMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_InstMode_Default(pSDynaInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INSTMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_InstVer(boolean bl, PSDynaInst pSDynaInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaInst.isInstVerDirty() : !pSDynaInst.isInstVerDirty()) {
            return null;
        }
        Integer n = pSDynaInst.getInstVer();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_InstVer_Default(pSDynaInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INSTVER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDynaInst pSDynaInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaInst.isMemoDirty() : !pSDynaInst.isMemoDirty()) {
            return null;
        }
        String string = pSDynaInst.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDynaInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_PPSDynaInstId(boolean bl, PSDynaInst pSDynaInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaInst.isPPSDynaInstIdDirty() : !pSDynaInst.isPPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSDynaInst.getPPSDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSDynaInstId_Default(pSDynaInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSDYNAINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PPSDynaInstName(boolean bl, PSDynaInst pSDynaInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaInst.isPPSDynaInstNameDirty() : !pSDynaInst.isPPSDynaInstNameDirty()) {
            return null;
        }
        String string = pSDynaInst.getPPSDynaInstName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSDynaInstName_Default(pSDynaInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSDYNAINSTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnSysId(boolean bl, PSDynaInst pSDynaInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaInst.isPSDevSlnSysIdDirty() : !pSDynaInst.isPSDevSlnSysIdDirty()) {
            return null;
        }
        String string = pSDynaInst.getPSDevSlnSysId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysId_Default(pSDynaInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, PSDynaInst pSDynaInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaInst.isPSDynaInstIdDirty() && !bl2 : !pSDynaInst.isPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSDynaInst.getPSDynaInstId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAINSTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default(pSDynaInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDynaInstName(boolean bl, PSDynaInst pSDynaInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaInst.isPSDynaInstNameDirty() && !bl2 : !pSDynaInst.isPSDynaInstNameDirty()) {
            return null;
        }
        String string = pSDynaInst.getPSDynaInstName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAINSTNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstName_Default(pSDynaInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAINSTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaSysId(boolean bl, PSDynaInst pSDynaInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaInst.isPSDynaSysIdDirty() && !bl2 : !pSDynaInst.isPSDynaSysIdDirty()) {
            return null;
        }
        String string = pSDynaInst.getPSDynaSysId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNASYSID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaSysId_Default(pSDynaInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNASYSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaSysName(boolean bl, PSDynaInst pSDynaInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaInst.isPSDynaSysNameDirty() && !bl2 : !pSDynaInst.isPSDynaSysNameDirty()) {
            return null;
        }
        String string = pSDynaInst.getPSDynaSysName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNASYSNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaSysName_Default(pSDynaInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNASYSNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDynaInst pSDynaInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaInst.isUserTagDirty() : !pSDynaInst.isUserTagDirty()) {
            return null;
        }
        String string = pSDynaInst.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDynaInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDynaInst pSDynaInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaInst.isUserTag2Dirty() : !pSDynaInst.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDynaInst.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDynaInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDynaInst pSDynaInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaInst.isValidFlagDirty() && !bl2 : !pSDynaInst.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDynaInst.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSDynaInst, bl2, bl3);
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

    protected void onSyncEntity(PSDynaInst pSDynaInst, boolean bl) throws Exception {
        super.onSyncEntity(pSDynaInst, bl);
    }

    protected void onSyncIndexEntities(PSDynaInst pSDynaInst, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDynaInst, bl);
    }

    public Object getDataContextValue(PSDynaInst pSDynaInst, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDynaInst, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDynaInst pSDynaInst, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDynaInst, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INSTMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InstMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INSTVER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InstVer_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSDynaInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSDYNAINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSDynaInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNASYSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaSysId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNASYSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaSysName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag2_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_InstMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INSTMODE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_InstVer_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_PPSDynaInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSDYNAINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSDynaInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSDYNAINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSID", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNAINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNAINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaSysId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNASYSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaSysName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNASYSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected boolean onMergeChild(String string, String string2, PSDynaInst pSDynaInst) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDynaInst)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDynaInst pSDynaInst) throws Exception {
        super.onUpdateParent(pSDynaInst);
    }

    @Override
    protected void exportCurXmlModel(PSDynaInst pSDynaInst, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDYNAINST");
        if (!bl) {
            pSDynaInst.setCreateDate(null);
            pSDynaInst.setCreateMan(null);
            pSDynaInst.setPSDynaInstId(null);
            pSDynaInst.setPSDynaSysId(null);
            pSDynaInst.setPSDynaSysName(null);
            pSDynaInst.setUpdateDate(null);
            pSDynaInst.setUpdateMan(null);
            super.exportCurXmlModel(pSDynaInst, xmlNode, bl);
        }
    }
}

