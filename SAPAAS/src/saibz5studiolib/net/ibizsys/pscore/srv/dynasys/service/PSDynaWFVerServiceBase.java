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
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dynasys.dao.PSDynaWFVerDAO;
import net.ibizsys.pscore.srv.dynasys.demodel.PSDynaWFVerDEModel;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaSys;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaSysBase;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaWF;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaWFBase;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaWFVer;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaWFVerInstService;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaWFVerInstServiceBase;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFVersionService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFVersionServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDynaWFVerServiceBase
extends PSCoreSysServiceBase<PSDynaWFVer> {
    private static final Log log = LogFactory.getLog(PSDynaWFVerServiceBase.class);
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDynaWFVerDEModel pSDynaWFVerDEModel;
    private PSDynaWFVerDAO pSDynaWFVerDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dynasys.service.PSDynaWFVerService";
    }

    public PSDynaWFVerDEModel getPSDynaWFVerDEModel() {
        if (this.pSDynaWFVerDEModel == null) {
            try {
                this.pSDynaWFVerDEModel = (PSDynaWFVerDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dynasys.demodel.PSDynaWFVerDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDynaWFVerDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDynaWFVerDEModel();
    }

    public PSDynaWFVerDAO getPSDynaWFVerDAO() {
        if (this.pSDynaWFVerDAO == null) {
            try {
                this.pSDynaWFVerDAO = (PSDynaWFVerDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dynasys.dao.PSDynaWFVerDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDynaWFVerDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDynaWFVerDAO();
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

    protected void onFillParentInfo(PSDynaWFVer pSDynaWFVer, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDYNAWFVER_PSDYNASYS_PSDYNASYSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dynasys.service.PSDynaSysService", (SessionFactory)this.getSessionFactory());
            PSDynaSys pSDynaSys = (PSDynaSys)iService.getDEModel().createEntity();
            pSDynaSys.set("PSDYNASYSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDynaSys);
            } else {
                iService.get(pSDynaSys);
            }
            this.onFillParentInfo_PSDynaSys(pSDynaWFVer, pSDynaSys);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDYNAWFVER_PSDYNAWF_PSDYNAWFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dynasys.service.PSDynaWFService", (SessionFactory)this.getSessionFactory());
            PSDynaWF pSDynaWF = (PSDynaWF)iService.getDEModel().createEntity();
            pSDynaWF.set("PSDYNAWFID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDynaWF);
            } else {
                iService.get(pSDynaWF);
            }
            this.onFillParentInfo_PSDynaWF(pSDynaWFVer, pSDynaWF);
            return;
        }
        super.onFillParentInfo(pSDynaWFVer, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDynaSys(PSDynaWFVer pSDynaWFVer, PSDynaSys pSDynaSys) throws Exception {
        pSDynaWFVer.setPSDynaSysId(pSDynaSys.getPSDynaSysId());
        pSDynaWFVer.setPSDynaSysName(pSDynaSys.getPSDynaSysName());
    }

    protected void onFillParentInfo_PSDynaWF(PSDynaWFVer pSDynaWFVer, PSDynaWF pSDynaWF) throws Exception {
        pSDynaWFVer.setPSDynaWFId(pSDynaWF.getPSDynaWFId());
        pSDynaWFVer.setPSDynaWFName(pSDynaWF.getPSDynaWFName());
        if (pSDynaWF.getPSDynaSys() != null) {
            this.onFillParentInfo_PSDynaSys(pSDynaWFVer, pSDynaWF.getPSDynaSys());
        }
    }

    protected void onFillEntityFullInfo(PSDynaWFVer pSDynaWFVer, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDynaWFVer, bl);
        this.onFillEntityFullInfo_PSDynaSys(pSDynaWFVer, bl);
        this.onFillEntityFullInfo_PSDynaWF(pSDynaWFVer, bl);
    }

    protected void onFillEntityFullInfo_PSDynaSys(PSDynaWFVer pSDynaWFVer, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDynaWF(PSDynaWFVer pSDynaWFVer, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDynaWFVer pSDynaWFVer, boolean bl) throws Exception {
        super.onWriteBackParent(pSDynaWFVer, bl);
    }

    public ArrayList<PSDynaWFVer> selectByPSDynaSys(PSDynaSysBase pSDynaSysBase) throws Exception {
        return this.selectByPSDynaSys(pSDynaSysBase, "", -1);
    }

    public ArrayList<PSDynaWFVer> selectByPSDynaSys(PSDynaSysBase pSDynaSysBase, String string) throws Exception {
        return this.selectByPSDynaSys(pSDynaSysBase, string, -1);
    }

    public ArrayList<PSDynaWFVer> selectByPSDynaSys(PSDynaSysBase pSDynaSysBase, String string, int n) throws Exception {
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

    public ArrayList<PSDynaWFVer> selectByPSDynaWF(PSDynaWFBase pSDynaWFBase) throws Exception {
        return this.selectByPSDynaWF(pSDynaWFBase, "", -1);
    }

    public ArrayList<PSDynaWFVer> selectByPSDynaWF(PSDynaWFBase pSDynaWFBase, String string) throws Exception {
        return this.selectByPSDynaWF(pSDynaWFBase, string, -1);
    }

    public ArrayList<PSDynaWFVer> selectByPSDynaWF(PSDynaWFBase pSDynaWFBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDYNAWFID", (Object)pSDynaWFBase.getPSDynaWFId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDynaWFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDynaWFCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDynaSys(PSDynaSys pSDynaSys) throws Exception {
        ArrayList<PSDynaWFVer> arrayList = this.selectByPSDynaSys(pSDynaSys, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDYNASYS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDynaSys);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDYNAWFVER_PSDYNASYS_PSDYNASYSID", "", iDataEntityModel.getName(), "PSDYNAWFVER", iDataEntityModel.getDataInfo(pSDynaSys), arrayList.get(0)));
        }
    }

    public void resetPSDynaSys(PSDynaSys pSDynaSys) throws Exception {
        ArrayList<PSDynaWFVer> arrayList = this.selectByPSDynaSys(pSDynaSys);
        for (PSDynaWFVer pSDynaWFVer : arrayList) {
            PSDynaWFVer pSDynaWFVer2 = (PSDynaWFVer)this.getDEModel().createEntity();
            pSDynaWFVer2.setPSDynaWFVerId(pSDynaWFVer.getPSDynaWFVerId());
            pSDynaWFVer2.setPSDynaSysId(null);
            this.update(pSDynaWFVer2);
        }
    }

    public void removeByPSDynaSys(PSDynaSys pSDynaSys) throws Exception {
        final PSDynaSys pSDynaSys2 = pSDynaSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDynaWFVerServiceBase.this.onBeforeRemoveByPSDynaSys(pSDynaSys2);
                PSDynaWFVerServiceBase.this.internalRemoveByPSDynaSys(pSDynaSys2);
                PSDynaWFVerServiceBase.this.onAfterRemoveByPSDynaSys(pSDynaSys2);
            }
        });
    }

    protected void onBeforeRemoveByPSDynaSys(PSDynaSys pSDynaSys) throws Exception {
    }

    protected void internalRemoveByPSDynaSys(PSDynaSys pSDynaSys) throws Exception {
        ArrayList<PSDynaWFVer> arrayList = this.selectByPSDynaSys(pSDynaSys);
        this.onBeforeRemoveByPSDynaSys(pSDynaSys, arrayList);
        for (PSDynaWFVer pSDynaWFVer : arrayList) {
            this.remove(pSDynaWFVer);
        }
        this.onAfterRemoveByPSDynaSys(pSDynaSys, arrayList);
    }

    protected void onAfterRemoveByPSDynaSys(PSDynaSys pSDynaSys) throws Exception {
    }

    protected void onBeforeRemoveByPSDynaSys(PSDynaSys pSDynaSys, ArrayList<PSDynaWFVer> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDynaSys(PSDynaSys pSDynaSys, ArrayList<PSDynaWFVer> arrayList) throws Exception {
    }

    public void testRemoveByPSDynaWF(PSDynaWF pSDynaWF) throws Exception {
    }

    public void resetPSDynaWF(PSDynaWF pSDynaWF) throws Exception {
        ArrayList<PSDynaWFVer> arrayList = this.selectByPSDynaWF(pSDynaWF);
        for (PSDynaWFVer pSDynaWFVer : arrayList) {
            PSDynaWFVer pSDynaWFVer2 = (PSDynaWFVer)this.getDEModel().createEntity();
            pSDynaWFVer2.setPSDynaWFVerId(pSDynaWFVer.getPSDynaWFVerId());
            pSDynaWFVer2.setPSDynaWFId(null);
            this.update(pSDynaWFVer2);
        }
    }

    public void removeByPSDynaWF(PSDynaWF pSDynaWF) throws Exception {
        final PSDynaWF pSDynaWF2 = pSDynaWF;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDynaWFVerServiceBase.this.onBeforeRemoveByPSDynaWF(pSDynaWF2);
                PSDynaWFVerServiceBase.this.internalRemoveByPSDynaWF(pSDynaWF2);
                PSDynaWFVerServiceBase.this.onAfterRemoveByPSDynaWF(pSDynaWF2);
            }
        });
    }

    protected void onBeforeRemoveByPSDynaWF(PSDynaWF pSDynaWF) throws Exception {
    }

    protected void internalRemoveByPSDynaWF(PSDynaWF pSDynaWF) throws Exception {
        ArrayList<PSDynaWFVer> arrayList = this.selectByPSDynaWF(pSDynaWF);
        this.onBeforeRemoveByPSDynaWF(pSDynaWF, arrayList);
        for (PSDynaWFVer pSDynaWFVer : arrayList) {
            this.remove(pSDynaWFVer);
        }
        this.onAfterRemoveByPSDynaWF(pSDynaWF, arrayList);
    }

    protected void onAfterRemoveByPSDynaWF(PSDynaWF pSDynaWF) throws Exception {
    }

    protected void onBeforeRemoveByPSDynaWF(PSDynaWF pSDynaWF, ArrayList<PSDynaWFVer> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDynaWF(PSDynaWF pSDynaWF, ArrayList<PSDynaWFVer> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDynaWFVer pSDynaWFVer) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDynaWFVerInstService)ServiceGlobal.getService(PSDynaWFVerInstService.class, (SessionFactory)this.getSessionFactory());
        ((PSDynaWFVerInstServiceBase)pSCoreSysServiceBase).testRemoveByPSDynaWFVer(pSDynaWFVer);
        pSCoreSysServiceBase = (PSWFVersionService)ServiceGlobal.getService(PSWFVersionService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFVersionServiceBase)pSCoreSysServiceBase).testRemoveByPSDynaWFVer(pSDynaWFVer);
        super.onBeforeRemove(pSDynaWFVer);
    }

    protected void replaceParentInfo(PSDynaWFVer pSDynaWFVer, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDynaWFVer, cloneSession);
        if (pSDynaWFVer.getPSDynaSysId() != null && (iEntity = cloneSession.getEntity("PSDYNASYS", (Object)pSDynaWFVer.getPSDynaSysId())) != null) {
            this.onFillParentInfo_PSDynaSys(pSDynaWFVer, (PSDynaSys)iEntity);
        }
        if (pSDynaWFVer.getPSDynaWFId() != null && (iEntity = cloneSession.getEntity("PSDYNAWF", (Object)pSDynaWFVer.getPSDynaWFId())) != null) {
            this.onFillParentInfo_PSDynaWF(pSDynaWFVer, (PSDynaWF)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDynaWFVer pSDynaWFVer, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDynaWFVer, bl);
    }

    protected void onCheckEntity(boolean bl, PSDynaWFVer pSDynaWFVer, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSDynaWFVer, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaSysId(bl, pSDynaWFVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaWFId(bl, pSDynaWFVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaWFVerId(bl, pSDynaWFVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaWFVerName(bl, pSDynaWFVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDynaWFVer, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDynaWFVer pSDynaWFVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaWFVer.isMemoDirty() : !pSDynaWFVer.isMemoDirty()) {
            return null;
        }
        String string = pSDynaWFVer.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDynaWFVer, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDynaSysId(boolean bl, PSDynaWFVer pSDynaWFVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaWFVer.isPSDynaSysIdDirty() && !bl2 : !pSDynaWFVer.isPSDynaSysIdDirty()) {
            return null;
        }
        String string = pSDynaWFVer.getPSDynaSysId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNASYSID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaSysId_Default(pSDynaWFVer, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDynaWFId(boolean bl, PSDynaWFVer pSDynaWFVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaWFVer.isPSDynaWFIdDirty() && !bl2 : !pSDynaWFVer.isPSDynaWFIdDirty()) {
            return null;
        }
        String string = pSDynaWFVer.getPSDynaWFId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAWFID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaWFId_Default(pSDynaWFVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAWFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaWFVerId(boolean bl, PSDynaWFVer pSDynaWFVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaWFVer.isPSDynaWFVerIdDirty() && !bl2 : !pSDynaWFVer.isPSDynaWFVerIdDirty()) {
            return null;
        }
        String string = pSDynaWFVer.getPSDynaWFVerId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAWFVERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaWFVerId_Default(pSDynaWFVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAWFVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaWFVerName(boolean bl, PSDynaWFVer pSDynaWFVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaWFVer.isPSDynaWFVerNameDirty() && !bl2 : !pSDynaWFVer.isPSDynaWFVerNameDirty()) {
            return null;
        }
        String string = pSDynaWFVer.getPSDynaWFVerName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAWFVERNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaWFVerName_Default(pSDynaWFVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAWFVERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDynaWFVer pSDynaWFVer, boolean bl) throws Exception {
        super.onSyncEntity(pSDynaWFVer, bl);
    }

    protected void onSyncIndexEntities(PSDynaWFVer pSDynaWFVer, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDynaWFVer, bl);
    }

    public Object getDataContextValue(PSDynaWFVer pSDynaWFVer, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDynaWFVer, string, iDataContextParam)) != null) {
            return object;
        }
        PSDynaWF pSDynaWF = pSDynaWFVer.getPSDynaWF();
        if (pSDynaWF != null && pSDynaWF.contains(string)) {
            return pSDynaWF.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDynaWFVer pSDynaWFVer, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDynaWFVer, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PSDYNASYSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaSysId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNASYSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaSysName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAWFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaWFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAWFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaWFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAWFVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaWFVerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAWFVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaWFVerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSDynaWFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNAWFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaWFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNAWFNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaWFVerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNAWFVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaWFVerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNAWFVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDynaWFVer pSDynaWFVer) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDynaWFVer)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDynaWFVer pSDynaWFVer) throws Exception {
        super.onUpdateParent(pSDynaWFVer);
    }

    @Override
    protected void exportCurXmlModel(PSDynaWFVer pSDynaWFVer, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDYNAWFVER");
        if (!bl) {
            pSDynaWFVer.setCreateDate(null);
            pSDynaWFVer.setCreateMan(null);
            pSDynaWFVer.setPSDynaSysId(null);
            pSDynaWFVer.setPSDynaSysName(null);
            pSDynaWFVer.setPSDynaWFId(null);
            pSDynaWFVer.setPSDynaWFName(null);
            pSDynaWFVer.setPSDynaWFVerId(null);
            pSDynaWFVer.setUpdateDate(null);
            pSDynaWFVer.setUpdateMan(null);
            super.exportCurXmlModel(pSDynaWFVer, xmlNode, bl);
        }
    }
}

