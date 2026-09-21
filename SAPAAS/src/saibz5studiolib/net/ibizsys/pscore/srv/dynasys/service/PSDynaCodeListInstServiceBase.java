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
import net.ibizsys.pscore.srv.dynasys.dao.PSDynaCodeListInstDAO;
import net.ibizsys.pscore.srv.dynasys.demodel.PSDynaCodeListInstDEModel;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaCodeList;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaCodeListBase;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaCodeListInst;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaInst;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaInstBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDynaCodeListInstServiceBase
extends PSCoreSysServiceBase<PSDynaCodeListInst> {
    private static final Log log = LogFactory.getLog(PSDynaCodeListInstServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_UPDATEDYNAMODEL = "UpdateDynaModel";
    private PSDynaCodeListInstDEModel pSDynaCodeListInstDEModel;
    private PSDynaCodeListInstDAO pSDynaCodeListInstDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dynasys.service.PSDynaCodeListInstService";
    }

    public PSDynaCodeListInstDEModel getPSDynaCodeListInstDEModel() {
        if (this.pSDynaCodeListInstDEModel == null) {
            try {
                this.pSDynaCodeListInstDEModel = (PSDynaCodeListInstDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dynasys.demodel.PSDynaCodeListInstDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDynaCodeListInstDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDynaCodeListInstDEModel();
    }

    public PSDynaCodeListInstDAO getPSDynaCodeListInstDAO() {
        if (this.pSDynaCodeListInstDAO == null) {
            try {
                this.pSDynaCodeListInstDAO = (PSDynaCodeListInstDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dynasys.dao.PSDynaCodeListInstDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDynaCodeListInstDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDynaCodeListInstDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_UPDATEDYNAMODEL, (boolean)true) == 0) {
            this.updateDynaModel((PSDynaCodeListInst)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public void updateDynaModel(PSDynaCodeListInst pSDynaCodeListInst) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEDYNAMODEL, 0, (IEntity)pSDynaCodeListInst, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDynaCodeListInst, ACTION_UPDATEDYNAMODEL);
        final PSDynaCodeListInst pSDynaCodeListInst2 = pSDynaCodeListInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDynaCodeListInstServiceBase.this.getService(), PSDynaCodeListInstServiceBase.ACTION_UPDATEDYNAMODEL, 40, (IEntity)pSDynaCodeListInst2, null).getResult() != 1) {
                    PSDynaCodeListInstServiceBase.this.onUpdateDynaModel(pSDynaCodeListInst2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEDYNAMODEL, 99, (IEntity)pSDynaCodeListInst, null);
        }
    }

    protected void onUpdateDynaModel(PSDynaCodeListInst pSDynaCodeListInst) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[UpdateDynaModel]");
    }

    protected void onFillParentInfo(PSDynaCodeListInst pSDynaCodeListInst, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDYNACODELISTINST_PSDYNACODELIST_PSDYNACODELISTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dynasys.service.PSDynaCodeListService", (SessionFactory)this.getSessionFactory());
            PSDynaCodeList pSDynaCodeList = (PSDynaCodeList)iService.getDEModel().createEntity();
            pSDynaCodeList.set("PSDYNACODELISTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDynaCodeList);
            } else {
                iService.get((IEntity)pSDynaCodeList);
            }
            this.onFillParentInfo_PSDynaCodeList(pSDynaCodeListInst, pSDynaCodeList);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDYNACODELISTINST_PSDYNAINST_PSDYNAINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dynasys.service.PSDynaInstService", (SessionFactory)this.getSessionFactory());
            PSDynaInst pSDynaInst = (PSDynaInst)iService.getDEModel().createEntity();
            pSDynaInst.set("PSDYNAINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDynaInst);
            } else {
                iService.get((IEntity)pSDynaInst);
            }
            this.onFillParentInfo_PSDynaInst(pSDynaCodeListInst, pSDynaInst);
            return;
        }
        super.onFillParentInfo((IEntity)pSDynaCodeListInst, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDynaCodeList(PSDynaCodeListInst pSDynaCodeListInst, PSDynaCodeList pSDynaCodeList) throws Exception {
        pSDynaCodeListInst.setPSDynaCodeListId(pSDynaCodeList.getPSDynaCodeListId());
        pSDynaCodeListInst.setPSDynaCodeListName(pSDynaCodeList.getPSDynaCodeListName());
    }

    protected void onFillParentInfo_PSDynaInst(PSDynaCodeListInst pSDynaCodeListInst, PSDynaInst pSDynaInst) throws Exception {
        pSDynaCodeListInst.setPSDynaInstId(pSDynaInst.getPSDynaInstId());
        pSDynaCodeListInst.setPSDynaInstName(pSDynaInst.getPSDynaInstName());
    }

    protected void onFillEntityFullInfo(PSDynaCodeListInst pSDynaCodeListInst, boolean bl) throws Exception {
        if (bl && pSDynaCodeListInst.getInstVer() == null) {
            pSDynaCodeListInst.setInstVer((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo((IEntity)pSDynaCodeListInst, bl);
        this.onFillEntityFullInfo_PSDynaCodeList(pSDynaCodeListInst, bl);
        this.onFillEntityFullInfo_PSDynaInst(pSDynaCodeListInst, bl);
    }

    protected void onFillEntityFullInfo_PSDynaCodeList(PSDynaCodeListInst pSDynaCodeListInst, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDynaInst(PSDynaCodeListInst pSDynaCodeListInst, boolean bl) throws Exception {
        if (pSDynaCodeListInst.isPSDynaInstIdDirty()) {
            if (pSDynaCodeListInst.getPSDynaInstId() != null) {
                if (pSDynaCodeListInst.getPSDynaInstId() == null || pSDynaCodeListInst.getPSDynaInstName() == null) {
                    PSDynaInst pSDynaInst = pSDynaCodeListInst.getPSDynaInst();
                    pSDynaCodeListInst.setPSDynaInstName(pSDynaInst.getPSDynaInstName());
                }
            } else {
                pSDynaCodeListInst.setPSDynaInstName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDynaCodeListInst pSDynaCodeListInst, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDynaCodeListInst, bl);
    }

    public ArrayList<PSDynaCodeListInst> selectByPSDynaCodeList(PSDynaCodeListBase pSDynaCodeListBase) throws Exception {
        return this.selectByPSDynaCodeList(pSDynaCodeListBase, "", -1);
    }

    public ArrayList<PSDynaCodeListInst> selectByPSDynaCodeList(PSDynaCodeListBase pSDynaCodeListBase, String string) throws Exception {
        return this.selectByPSDynaCodeList(pSDynaCodeListBase, string, -1);
    }

    public ArrayList<PSDynaCodeListInst> selectByPSDynaCodeList(PSDynaCodeListBase pSDynaCodeListBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDYNACODELISTID", (Object)pSDynaCodeListBase.getPSDynaCodeListId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDynaCodeListCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDynaCodeListCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDynaCodeListInst> selectByPSDynaInst(PSDynaInstBase pSDynaInstBase) throws Exception {
        return this.selectByPSDynaInst(pSDynaInstBase, "", -1);
    }

    public ArrayList<PSDynaCodeListInst> selectByPSDynaInst(PSDynaInstBase pSDynaInstBase, String string) throws Exception {
        return this.selectByPSDynaInst(pSDynaInstBase, string, -1);
    }

    public ArrayList<PSDynaCodeListInst> selectByPSDynaInst(PSDynaInstBase pSDynaInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDYNAINSTID", (Object)pSDynaInstBase.getPSDynaInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDynaInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDynaInstCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDynaCodeList(PSDynaCodeList pSDynaCodeList) throws Exception {
        ArrayList<PSDynaCodeListInst> arrayList = this.selectByPSDynaCodeList(pSDynaCodeList, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDYNACODELIST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDynaCodeList);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDYNACODELISTINST_PSDYNACODELIST_PSDYNACODELISTID", "", iDataEntityModel.getName(), "PSDYNACODELISTINST", iDataEntityModel.getDataInfo((IEntity)pSDynaCodeList), arrayList.get(0)));
        }
    }

    public void resetPSDynaCodeList(PSDynaCodeList pSDynaCodeList) throws Exception {
        ArrayList<PSDynaCodeListInst> arrayList = this.selectByPSDynaCodeList(pSDynaCodeList);
        for (PSDynaCodeListInst pSDynaCodeListInst : arrayList) {
            PSDynaCodeListInst pSDynaCodeListInst2 = (PSDynaCodeListInst)this.getDEModel().createEntity();
            pSDynaCodeListInst2.setPSDynaCodeListInstId(pSDynaCodeListInst.getPSDynaCodeListInstId());
            pSDynaCodeListInst2.setPSDynaCodeListId(null);
            this.update(pSDynaCodeListInst2);
        }
    }

    public void removeByPSDynaCodeList(PSDynaCodeList pSDynaCodeList) throws Exception {
        final PSDynaCodeList pSDynaCodeList2 = pSDynaCodeList;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDynaCodeListInstServiceBase.this.onBeforeRemoveByPSDynaCodeList(pSDynaCodeList2);
                PSDynaCodeListInstServiceBase.this.internalRemoveByPSDynaCodeList(pSDynaCodeList2);
                PSDynaCodeListInstServiceBase.this.onAfterRemoveByPSDynaCodeList(pSDynaCodeList2);
            }
        });
    }

    protected void onBeforeRemoveByPSDynaCodeList(PSDynaCodeList pSDynaCodeList) throws Exception {
    }

    protected void internalRemoveByPSDynaCodeList(PSDynaCodeList pSDynaCodeList) throws Exception {
        ArrayList<PSDynaCodeListInst> arrayList = this.selectByPSDynaCodeList(pSDynaCodeList);
        this.onBeforeRemoveByPSDynaCodeList(pSDynaCodeList, arrayList);
        for (PSDynaCodeListInst pSDynaCodeListInst : arrayList) {
            this.remove((IEntity)pSDynaCodeListInst);
        }
        this.onAfterRemoveByPSDynaCodeList(pSDynaCodeList, arrayList);
    }

    protected void onAfterRemoveByPSDynaCodeList(PSDynaCodeList pSDynaCodeList) throws Exception {
    }

    protected void onBeforeRemoveByPSDynaCodeList(PSDynaCodeList pSDynaCodeList, ArrayList<PSDynaCodeListInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDynaCodeList(PSDynaCodeList pSDynaCodeList, ArrayList<PSDynaCodeListInst> arrayList) throws Exception {
    }

    public void testRemoveByPSDynaInst(PSDynaInst pSDynaInst) throws Exception {
        ArrayList<PSDynaCodeListInst> arrayList = this.selectByPSDynaInst(pSDynaInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDYNAINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDynaInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDYNACODELISTINST_PSDYNAINST_PSDYNAINSTID", "", iDataEntityModel.getName(), "PSDYNACODELISTINST", iDataEntityModel.getDataInfo((IEntity)pSDynaInst), arrayList.get(0)));
        }
    }

    public void resetPSDynaInst(PSDynaInst pSDynaInst) throws Exception {
        ArrayList<PSDynaCodeListInst> arrayList = this.selectByPSDynaInst(pSDynaInst);
        for (PSDynaCodeListInst pSDynaCodeListInst : arrayList) {
            PSDynaCodeListInst pSDynaCodeListInst2 = (PSDynaCodeListInst)this.getDEModel().createEntity();
            pSDynaCodeListInst2.setPSDynaCodeListInstId(pSDynaCodeListInst.getPSDynaCodeListInstId());
            pSDynaCodeListInst2.setPSDynaInstId(null);
            this.update(pSDynaCodeListInst2);
        }
    }

    public void removeByPSDynaInst(PSDynaInst pSDynaInst) throws Exception {
        final PSDynaInst pSDynaInst2 = pSDynaInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDynaCodeListInstServiceBase.this.onBeforeRemoveByPSDynaInst(pSDynaInst2);
                PSDynaCodeListInstServiceBase.this.internalRemoveByPSDynaInst(pSDynaInst2);
                PSDynaCodeListInstServiceBase.this.onAfterRemoveByPSDynaInst(pSDynaInst2);
            }
        });
    }

    protected void onBeforeRemoveByPSDynaInst(PSDynaInst pSDynaInst) throws Exception {
    }

    protected void internalRemoveByPSDynaInst(PSDynaInst pSDynaInst) throws Exception {
        ArrayList<PSDynaCodeListInst> arrayList = this.selectByPSDynaInst(pSDynaInst);
        this.onBeforeRemoveByPSDynaInst(pSDynaInst, arrayList);
        for (PSDynaCodeListInst pSDynaCodeListInst : arrayList) {
            this.remove((IEntity)pSDynaCodeListInst);
        }
        this.onAfterRemoveByPSDynaInst(pSDynaInst, arrayList);
    }

    protected void onAfterRemoveByPSDynaInst(PSDynaInst pSDynaInst) throws Exception {
    }

    protected void onBeforeRemoveByPSDynaInst(PSDynaInst pSDynaInst, ArrayList<PSDynaCodeListInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDynaInst(PSDynaInst pSDynaInst, ArrayList<PSDynaCodeListInst> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDynaCodeListInst pSDynaCodeListInst) throws Exception {
        super.onBeforeRemove(pSDynaCodeListInst);
    }

    protected void replaceParentInfo(PSDynaCodeListInst pSDynaCodeListInst, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDynaCodeListInst, cloneSession);
        if (pSDynaCodeListInst.getPSDynaCodeListId() != null && (iEntity = cloneSession.getEntity("PSDYNACODELIST", (Object)pSDynaCodeListInst.getPSDynaCodeListId())) != null) {
            this.onFillParentInfo_PSDynaCodeList(pSDynaCodeListInst, (PSDynaCodeList)iEntity);
        }
        if (pSDynaCodeListInst.getPSDynaInstId() != null && (iEntity = cloneSession.getEntity("PSDYNAINST", (Object)pSDynaCodeListInst.getPSDynaInstId())) != null) {
            this.onFillParentInfo_PSDynaInst(pSDynaCodeListInst, (PSDynaInst)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDynaCodeListInst pSDynaCodeListInst, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDynaCodeListInst, bl);
    }

    protected void onCheckEntity(boolean bl, PSDynaCodeListInst pSDynaCodeListInst, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_DynaModel(bl, pSDynaCodeListInst, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_InstVer(bl, pSDynaCodeListInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDynaCodeListInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaCodeListId(bl, pSDynaCodeListInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaCodeListInstId(bl, pSDynaCodeListInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaCodeListInstName(bl, pSDynaCodeListInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, pSDynaCodeListInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstName(bl, pSDynaCodeListInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDynaCodeListInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDynaCodeListInst, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_DynaModel(boolean bl, PSDynaCodeListInst pSDynaCodeListInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaCodeListInst.isDynaModelDirty() : !pSDynaCodeListInst.isDynaModelDirty()) {
            return null;
        }
        String string = pSDynaCodeListInst.getDynaModel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DynaModel_Default((IEntity)pSDynaCodeListInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DYNAMODEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_InstVer(boolean bl, PSDynaCodeListInst pSDynaCodeListInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaCodeListInst.isInstVerDirty() : !pSDynaCodeListInst.isInstVerDirty()) {
            return null;
        }
        Integer n = pSDynaCodeListInst.getInstVer();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_InstVer_Default((IEntity)pSDynaCodeListInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDynaCodeListInst pSDynaCodeListInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaCodeListInst.isMemoDirty() : !pSDynaCodeListInst.isMemoDirty()) {
            return null;
        }
        String string = pSDynaCodeListInst.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDynaCodeListInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDynaCodeListId(boolean bl, PSDynaCodeListInst pSDynaCodeListInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaCodeListInst.isPSDynaCodeListIdDirty() : !pSDynaCodeListInst.isPSDynaCodeListIdDirty()) {
            return null;
        }
        String string = pSDynaCodeListInst.getPSDynaCodeListId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaCodeListId_Default((IEntity)pSDynaCodeListInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNACODELISTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaCodeListInstId(boolean bl, PSDynaCodeListInst pSDynaCodeListInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaCodeListInst.isPSDynaCodeListInstIdDirty() && !bl2 : !pSDynaCodeListInst.isPSDynaCodeListInstIdDirty()) {
            return null;
        }
        String string = pSDynaCodeListInst.getPSDynaCodeListInstId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNACODELISTINSTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaCodeListInstId_Default((IEntity)pSDynaCodeListInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNACODELISTINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaCodeListInstName(boolean bl, PSDynaCodeListInst pSDynaCodeListInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaCodeListInst.isPSDynaCodeListInstNameDirty() && !bl2 : !pSDynaCodeListInst.isPSDynaCodeListInstNameDirty()) {
            return null;
        }
        String string = pSDynaCodeListInst.getPSDynaCodeListInstName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNACODELISTINSTNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaCodeListInstName_Default((IEntity)pSDynaCodeListInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNACODELISTINSTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, PSDynaCodeListInst pSDynaCodeListInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaCodeListInst.isPSDynaInstIdDirty() : !pSDynaCodeListInst.isPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSDynaCodeListInst.getPSDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default((IEntity)pSDynaCodeListInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDynaInstName(boolean bl, PSDynaCodeListInst pSDynaCodeListInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaCodeListInst.isPSDynaInstNameDirty() : !pSDynaCodeListInst.isPSDynaInstNameDirty()) {
            return null;
        }
        String string = pSDynaCodeListInst.getPSDynaInstName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstName_Default((IEntity)pSDynaCodeListInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDynaCodeListInst pSDynaCodeListInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaCodeListInst.isValidFlagDirty() : !pSDynaCodeListInst.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDynaCodeListInst.getValidFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSDynaCodeListInst, bl2, bl3);
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

    protected void onSyncEntity(PSDynaCodeListInst pSDynaCodeListInst, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDynaCodeListInst, bl);
    }

    protected void onSyncIndexEntities(PSDynaCodeListInst pSDynaCodeListInst, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDynaCodeListInst, bl);
    }

    public Object getDataContextValue(PSDynaCodeListInst pSDynaCodeListInst, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDynaCodeListInst, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDynaCodeListInst pSDynaCodeListInst, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDynaCodeListInst, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAMODEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaModel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INSTVER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InstVer_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNACODELISTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaCodeListId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNACODELISTINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaCodeListInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNACODELISTINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaCodeListInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNACODELISTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaCodeListName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_DynaModel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DYNAMODEL", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
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

    protected String onTestValueRule_PSDynaCodeListId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNACODELISTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaCodeListInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNACODELISTINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaCodeListInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNACODELISTINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaCodeListName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNACODELISTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected boolean onMergeChild(String string, String string2, PSDynaCodeListInst pSDynaCodeListInst) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDynaCodeListInst)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDynaCodeListInst pSDynaCodeListInst) throws Exception {
        super.onUpdateParent((IEntity)pSDynaCodeListInst);
    }

    @Override
    protected void exportCurXmlModel(PSDynaCodeListInst pSDynaCodeListInst, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDYNACODELISTINST");
        if (!bl) {
            pSDynaCodeListInst.setCreateDate(null);
            pSDynaCodeListInst.setCreateMan(null);
            pSDynaCodeListInst.setPSDynaCodeListInstId(null);
            pSDynaCodeListInst.setUpdateDate(null);
            pSDynaCodeListInst.setUpdateMan(null);
            super.exportCurXmlModel(pSDynaCodeListInst, xmlNode, bl);
        }
    }
}

