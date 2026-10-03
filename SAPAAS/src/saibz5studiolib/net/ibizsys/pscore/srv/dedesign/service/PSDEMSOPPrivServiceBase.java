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
package net.ibizsys.pscore.srv.dedesign.service;

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
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.dao.PSDEMSOPPrivDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEMSOPPrivDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMSOPPriv;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMainState;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMainStateBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPriv;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPrivBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEMSOPPrivServiceBase
extends PSCoreSysServiceBase<PSDEMSOPPriv> {
    private static final Log log = LogFactory.getLog(PSDEMSOPPrivServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDEMSOPPrivDEModel pSDEMSOPPrivDEModel;
    private PSDEMSOPPrivDAO pSDEMSOPPrivDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEMSOPPrivService";
    }

    public PSDEMSOPPrivDEModel getPSDEMSOPPrivDEModel() {
        if (this.pSDEMSOPPrivDEModel == null) {
            try {
                this.pSDEMSOPPrivDEModel = (PSDEMSOPPrivDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEMSOPPrivDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEMSOPPrivDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEMSOPPrivDEModel();
    }

    public PSDEMSOPPrivDAO getPSDEMSOPPrivDAO() {
        if (this.pSDEMSOPPrivDAO == null) {
            try {
                this.pSDEMSOPPrivDAO = (PSDEMSOPPrivDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEMSOPPrivDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEMSOPPrivDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEMSOPPrivDAO();
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

    protected void onFillParentInfo(PSDEMSOPPriv pSDEMSOPPriv, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEMSOPPRIV_PSDEMAINSTATE_PSDEMAINSTATEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEMainStateService", (SessionFactory)this.getSessionFactory());
            PSDEMainState pSDEMainState = (PSDEMainState)iService.getDEModel().createEntity();
            pSDEMainState.set("PSDEMAINSTATEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEMainState);
            } else {
                iService.get(pSDEMainState);
            }
            this.onFillParentInfo_PSDEMainState(pSDEMSOPPriv, pSDEMainState);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEMSOPPRIV_PSDEOPPRIV_PSDEOPPRIVID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivService", (SessionFactory)this.getSessionFactory());
            PSDEOPPriv pSDEOPPriv = (PSDEOPPriv)iService.getDEModel().createEntity();
            pSDEOPPriv.set("PSDEOPPRIVID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEOPPriv);
            } else {
                iService.get(pSDEOPPriv);
            }
            this.onFillParentInfo_PSDEOPPriv(pSDEMSOPPriv, pSDEOPPriv);
            return;
        }
        super.onFillParentInfo(pSDEMSOPPriv, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDEMainState(PSDEMSOPPriv pSDEMSOPPriv, PSDEMainState pSDEMainState) throws Exception {
        pSDEMSOPPriv.setPSDEId(pSDEMainState.getPSDEId());
        pSDEMSOPPriv.setPSDEMainStateId(pSDEMainState.getPSDEMainStateId());
        pSDEMSOPPriv.setPSDEMainStateName(pSDEMainState.getPSDEMainStateName());
    }

    protected void onFillParentInfo_PSDEOPPriv(PSDEMSOPPriv pSDEMSOPPriv, PSDEOPPriv pSDEOPPriv) throws Exception {
        pSDEMSOPPriv.setPSDEOPPrivId(pSDEOPPriv.getPSDEOPPrivId());
        pSDEMSOPPriv.setPSDEOPPrivName(pSDEOPPriv.getPSDEOPPrivName());
    }

    protected boolean onFillEntityKeyValue(PSDEMSOPPriv pSDEMSOPPriv, boolean bl) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        Object object = pSDEMSOPPriv.get("PSDEMAINSTATEID");
        if (object == null) {
            object = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object);
        stringBuilderEx.append("||");
        Object object2 = pSDEMSOPPriv.get("PSDEOPPRIVID");
        if (object2 == null) {
            object2 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object2);
        String string = stringBuilderEx.toString();
        pSDEMSOPPriv.set(this.getPSDEMSOPPrivDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId((String)string));
        return true;
    }

    protected void onFillEntityFullInfo(PSDEMSOPPriv pSDEMSOPPriv, boolean bl) throws Exception {
        if (bl) {
            if (pSDEMSOPPriv.getPSDEMSOPPrivName() == null) {
                pSDEMSOPPriv.setPSDEMSOPPrivName((String)this.getDefaultValue(this.getWebContext(), "", "\u540d\u79f0", 25));
            }
            if (pSDEMSOPPriv.getValidFlag() == null) {
                pSDEMSOPPriv.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo(pSDEMSOPPriv, bl);
        this.onFillEntityFullInfo_PSDEMainState(pSDEMSOPPriv, bl);
        this.onFillEntityFullInfo_PSDEOPPriv(pSDEMSOPPriv, bl);
    }

    protected void onFillEntityFullInfo_PSDEMainState(PSDEMSOPPriv pSDEMSOPPriv, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEOPPriv(PSDEMSOPPriv pSDEMSOPPriv, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDEMSOPPriv pSDEMSOPPriv, boolean bl) throws Exception {
        super.onWriteBackParent(pSDEMSOPPriv, bl);
    }

    public ArrayList<PSDEMSOPPriv> selectByPSDEMainState(PSDEMainStateBase pSDEMainStateBase) throws Exception {
        return this.selectByPSDEMainState(pSDEMainStateBase, "", -1);
    }

    public ArrayList<PSDEMSOPPriv> selectByPSDEMainState(PSDEMainStateBase pSDEMainStateBase, String string) throws Exception {
        return this.selectByPSDEMainState(pSDEMainStateBase, string, -1);
    }

    public ArrayList<PSDEMSOPPriv> selectByPSDEMainState(PSDEMainStateBase pSDEMainStateBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEMAINSTATEID", (Object)pSDEMainStateBase.getPSDEMainStateId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEMainStateCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEMainStateCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEMSOPPriv> selectTempByPSDEMainState(PSDEMainStateBase pSDEMainStateBase) throws Exception {
        return this.selectTempByPSDEMainState(pSDEMainStateBase, "");
    }

    public ArrayList<PSDEMSOPPriv> selectTempByPSDEMainState(PSDEMainStateBase pSDEMainStateBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEMAINSTATEID", (Object)pSDEMainStateBase.getPSDEMainStateId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDEMainStateCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDEMainStateCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEMSOPPriv> selectByPSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase) throws Exception {
        return this.selectByPSDEOPPriv(pSDEOPPrivBase, "", -1);
    }

    public ArrayList<PSDEMSOPPriv> selectByPSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase, String string) throws Exception {
        return this.selectByPSDEOPPriv(pSDEOPPrivBase, string, -1);
    }

    public ArrayList<PSDEMSOPPriv> selectByPSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEOPPRIVID", (Object)pSDEOPPrivBase.getPSDEOPPrivId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEOPPrivCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEOPPrivCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDEMainState(PSDEMainState pSDEMainState) throws Exception {
    }

    public void resetPSDEMainState(PSDEMainState pSDEMainState) throws Exception {
        ArrayList<PSDEMSOPPriv> arrayList = this.selectByPSDEMainState(pSDEMainState);
        for (PSDEMSOPPriv pSDEMSOPPriv : arrayList) {
            PSDEMSOPPriv pSDEMSOPPriv2 = (PSDEMSOPPriv)this.getDEModel().createEntity();
            pSDEMSOPPriv2.setPSDEMSOPPrivId(pSDEMSOPPriv.getPSDEMSOPPrivId());
            pSDEMSOPPriv2.setPSDEMainStateId(null);
            this.update(pSDEMSOPPriv2);
        }
    }

    public void resetTempPSDEMainState(PSDEMainState pSDEMainState) throws Exception {
        ArrayList<PSDEMSOPPriv> arrayList = this.selectTempByPSDEMainState(pSDEMainState);
        for (PSDEMSOPPriv pSDEMSOPPriv : arrayList) {
            PSDEMSOPPriv pSDEMSOPPriv2 = (PSDEMSOPPriv)this.getDEModel().createEntity();
            pSDEMSOPPriv2.setPSDEMSOPPrivId(pSDEMSOPPriv.getPSDEMSOPPrivId());
            pSDEMSOPPriv2.setPSDEMainStateId(null);
            this.updateTemp(pSDEMSOPPriv2);
        }
    }

    public void removeByPSDEMainState(PSDEMainState pSDEMainState) throws Exception {
        final PSDEMainState pSDEMainState2 = pSDEMainState;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEMSOPPrivServiceBase.this.onBeforeRemoveByPSDEMainState(pSDEMainState2);
                PSDEMSOPPrivServiceBase.this.internalRemoveByPSDEMainState(pSDEMainState2);
                PSDEMSOPPrivServiceBase.this.onAfterRemoveByPSDEMainState(pSDEMainState2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEMainState(PSDEMainState pSDEMainState) throws Exception {
    }

    protected void internalRemoveByPSDEMainState(PSDEMainState pSDEMainState) throws Exception {
        ArrayList<PSDEMSOPPriv> arrayList = this.selectByPSDEMainState(pSDEMainState);
        this.onBeforeRemoveByPSDEMainState(pSDEMainState, arrayList);
        for (PSDEMSOPPriv pSDEMSOPPriv : arrayList) {
            this.remove(pSDEMSOPPriv);
        }
        this.onAfterRemoveByPSDEMainState(pSDEMainState, arrayList);
    }

    protected void onAfterRemoveByPSDEMainState(PSDEMainState pSDEMainState) throws Exception {
    }

    protected void onBeforeRemoveByPSDEMainState(PSDEMainState pSDEMainState, ArrayList<PSDEMSOPPriv> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEMainState(PSDEMainState pSDEMainState, ArrayList<PSDEMSOPPriv> arrayList) throws Exception {
    }

    public void testRemoveByPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSDEMSOPPriv> arrayList = this.selectByPSDEOPPriv(pSDEOPPriv, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEOPPRIV");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEOPPriv);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEMSOPPRIV_PSDEOPPRIV_PSDEOPPRIVID", "", iDataEntityModel.getName(), "PSDEMSOPPRIV", iDataEntityModel.getDataInfo(pSDEOPPriv), arrayList.get(0)));
        }
    }

    public void resetPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSDEMSOPPriv> arrayList = this.selectByPSDEOPPriv(pSDEOPPriv);
        for (PSDEMSOPPriv pSDEMSOPPriv : arrayList) {
            PSDEMSOPPriv pSDEMSOPPriv2 = (PSDEMSOPPriv)this.getDEModel().createEntity();
            pSDEMSOPPriv2.setPSDEMSOPPrivId(pSDEMSOPPriv.getPSDEMSOPPrivId());
            pSDEMSOPPriv2.setPSDEOPPrivId(null);
            this.update(pSDEMSOPPriv2);
        }
    }

    public void removeByPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        final PSDEOPPriv pSDEOPPriv2 = pSDEOPPriv;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEMSOPPrivServiceBase.this.onBeforeRemoveByPSDEOPPriv(pSDEOPPriv2);
                PSDEMSOPPrivServiceBase.this.internalRemoveByPSDEOPPriv(pSDEOPPriv2);
                PSDEMSOPPrivServiceBase.this.onAfterRemoveByPSDEOPPriv(pSDEOPPriv2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
    }

    protected void internalRemoveByPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSDEMSOPPriv> arrayList = this.selectByPSDEOPPriv(pSDEOPPriv);
        this.onBeforeRemoveByPSDEOPPriv(pSDEOPPriv, arrayList);
        for (PSDEMSOPPriv pSDEMSOPPriv : arrayList) {
            this.remove(pSDEMSOPPriv);
        }
        this.onAfterRemoveByPSDEOPPriv(pSDEOPPriv, arrayList);
    }

    protected void onAfterRemoveByPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
    }

    protected void onBeforeRemoveByPSDEOPPriv(PSDEOPPriv pSDEOPPriv, ArrayList<PSDEMSOPPriv> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEOPPriv(PSDEOPPriv pSDEOPPriv, ArrayList<PSDEMSOPPriv> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEMSOPPriv pSDEMSOPPriv) throws Exception {
        super.onBeforeRemove(pSDEMSOPPriv);
    }

    public void removeTempByPSDEMainState(PSDEMainState pSDEMainState) throws Exception {
        final PSDEMainState pSDEMainState2 = pSDEMainState;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEMSOPPrivServiceBase.this.onBeforeRemoveTempByPSDEMainState(pSDEMainState2);
                PSDEMSOPPrivServiceBase.this.internalRemoveTempByPSDEMainState(pSDEMainState2);
                PSDEMSOPPrivServiceBase.this.onAfterRemoveTempByPSDEMainState(pSDEMainState2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDEMainState(PSDEMainState pSDEMainState) throws Exception {
    }

    protected void internalRemoveTempByPSDEMainState(PSDEMainState pSDEMainState) throws Exception {
        ArrayList<PSDEMSOPPriv> arrayList = this.selectTempByPSDEMainState(pSDEMainState);
        this.onBeforeRemoveTempByPSDEMainState(pSDEMainState, arrayList);
        for (PSDEMSOPPriv pSDEMSOPPriv : arrayList) {
            this.removeTemp(pSDEMSOPPriv);
        }
        this.onAfterRemoveTempByPSDEMainState(pSDEMainState, arrayList);
    }

    protected void onAfterRemoveTempByPSDEMainState(PSDEMainState pSDEMainState) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDEMainState(PSDEMainState pSDEMainState, ArrayList<PSDEMSOPPriv> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDEMainState(PSDEMainState pSDEMainState, ArrayList<PSDEMSOPPriv> arrayList) throws Exception {
    }

    protected void replaceParentInfo(PSDEMSOPPriv pSDEMSOPPriv, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDEMSOPPriv, cloneSession);
        if (pSDEMSOPPriv.getPSDEMainStateId() != null && (iEntity = cloneSession.getEntity("PSDEMAINSTATE", (Object)pSDEMSOPPriv.getPSDEMainStateId())) != null) {
            this.onFillParentInfo_PSDEMainState(pSDEMSOPPriv, (PSDEMainState)iEntity);
        }
        if (pSDEMSOPPriv.getPSDEOPPrivId() != null && (iEntity = cloneSession.getEntity("PSDEOPPRIV", (Object)pSDEMSOPPriv.getPSDEOPPrivId())) != null) {
            this.onFillParentInfo_PSDEOPPriv(pSDEMSOPPriv, (PSDEOPPriv)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEMSOPPriv pSDEMSOPPriv, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDEMSOPPriv, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEMSOPPriv pSDEMSOPPriv, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSDEMSOPPriv, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEMainStateId(bl, pSDEMSOPPriv, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEMSOPPrivId(bl, pSDEMSOPPriv, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEMSOPPrivName(bl, pSDEMSOPPriv, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEOPPrivId(bl, pSDEMSOPPriv, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDEMSOPPriv, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDEMSOPPriv, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDEMSOPPriv, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDEMSOPPriv, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDEMSOPPriv, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDEMSOPPriv, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDEMSOPPriv, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEMSOPPriv pSDEMSOPPriv, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMSOPPriv.isMemoDirty() : !pSDEMSOPPriv.isMemoDirty()) {
            return null;
        }
        String string = pSDEMSOPPriv.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDEMSOPPriv, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEMainStateId(boolean bl, PSDEMSOPPriv pSDEMSOPPriv, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMSOPPriv.isPSDEMainStateIdDirty() && !bl2 : !pSDEMSOPPriv.isPSDEMainStateIdDirty()) {
            return null;
        }
        String string = pSDEMSOPPriv.getPSDEMainStateId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEMAINSTATEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEMainStateId_Default(pSDEMSOPPriv, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEMAINSTATEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEMSOPPrivId(boolean bl, PSDEMSOPPriv pSDEMSOPPriv, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMSOPPriv.isPSDEMSOPPrivIdDirty() && !bl2 : !pSDEMSOPPriv.isPSDEMSOPPrivIdDirty()) {
            return null;
        }
        String string = pSDEMSOPPriv.getPSDEMSOPPrivId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEMSOPPRIVID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEMSOPPrivId_Default(pSDEMSOPPriv, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEMSOPPRIVID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEMSOPPrivName(boolean bl, PSDEMSOPPriv pSDEMSOPPriv, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMSOPPriv.isPSDEMSOPPrivNameDirty() : !pSDEMSOPPriv.isPSDEMSOPPrivNameDirty()) {
            return null;
        }
        String string = pSDEMSOPPriv.getPSDEMSOPPrivName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEMSOPPrivName_Default(pSDEMSOPPriv, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEMSOPPRIVNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEOPPrivId(boolean bl, PSDEMSOPPriv pSDEMSOPPriv, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMSOPPriv.isPSDEOPPrivIdDirty() && !bl2 : !pSDEMSOPPriv.isPSDEOPPrivIdDirty()) {
            return null;
        }
        String string = pSDEMSOPPriv.getPSDEOPPrivId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEOPPRIVID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEOPPrivId_Default(pSDEMSOPPriv, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEOPPRIVID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDEMSOPPriv pSDEMSOPPriv, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMSOPPriv.isUserCatDirty() : !pSDEMSOPPriv.isUserCatDirty()) {
            return null;
        }
        String string = pSDEMSOPPriv.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSDEMSOPPriv, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDEMSOPPriv pSDEMSOPPriv, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMSOPPriv.isUserTagDirty() : !pSDEMSOPPriv.isUserTagDirty()) {
            return null;
        }
        String string = pSDEMSOPPriv.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDEMSOPPriv, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDEMSOPPriv pSDEMSOPPriv, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMSOPPriv.isUserTag2Dirty() : !pSDEMSOPPriv.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDEMSOPPriv.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDEMSOPPriv, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDEMSOPPriv pSDEMSOPPriv, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMSOPPriv.isUserTag3Dirty() : !pSDEMSOPPriv.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDEMSOPPriv.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSDEMSOPPriv, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDEMSOPPriv pSDEMSOPPriv, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMSOPPriv.isUserTag4Dirty() : !pSDEMSOPPriv.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDEMSOPPriv.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSDEMSOPPriv, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDEMSOPPriv pSDEMSOPPriv, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMSOPPriv.isValidFlagDirty() && !bl2 : !pSDEMSOPPriv.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDEMSOPPriv.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSDEMSOPPriv, bl2, bl3);
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

    protected void onSyncEntity(PSDEMSOPPriv pSDEMSOPPriv, boolean bl) throws Exception {
        super.onSyncEntity(pSDEMSOPPriv, bl);
    }

    protected void onSyncIndexEntities(PSDEMSOPPriv pSDEMSOPPriv, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDEMSOPPriv, bl);
    }

    public Object getDataContextValue(PSDEMSOPPriv pSDEMSOPPriv, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDEMSOPPriv, string, iDataContextParam)) != null) {
            return object;
        }
        PSDEMainState pSDEMainState = pSDEMSOPPriv.getPSDEMainState();
        if (pSDEMainState != null && pSDEMainState.contains(string)) {
            return pSDEMainState.get(string);
        }
        PSDEOPPriv pSDEOPPriv = pSDEMSOPPriv.getPSDEOPPriv();
        if (pSDEOPPriv != null && pSDEOPPriv.contains(string)) {
            return pSDEOPPriv.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDEMSOPPriv pSDEMSOPPriv, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDEMSOPPriv, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEMAINSTATEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEMainStateId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEMAINSTATENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEMainStateName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEMSOPPRIVID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEMSOPPrivId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEMSOPPRIVNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEMSOPPrivName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEOPPRIVID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEOPPrivId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEOPPRIVNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEOPPrivName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSDEMainStateId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEMAINSTATEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEMainStateName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEMAINSTATENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEMSOPPrivId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEMSOPPRIVID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEMSOPPrivName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEMSOPPRIVNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEOPPrivId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEOPPRIVID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEOPPrivName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEOPPRIVNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDEMSOPPriv pSDEMSOPPriv) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDEMSOPPriv)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEMSOPPriv pSDEMSOPPriv) throws Exception {
        super.onUpdateParent(pSDEMSOPPriv);
    }

    @Override
    protected void exportCurXmlModel(PSDEMSOPPriv pSDEMSOPPriv, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEMSOPPRIV");
        if (!bl) {
            pSDEMSOPPriv.setCreateDate(null);
            pSDEMSOPPriv.setCreateMan(null);
            pSDEMSOPPriv.setPSDEMSOPPrivId(null);
            pSDEMSOPPriv.setUpdateDate(null);
            pSDEMSOPPriv.setUpdateMan(null);
            pSDEMSOPPriv.setPSDEId(null);
            pSDEMSOPPriv.setPSDEMainStateId(null);
            pSDEMSOPPriv.setPSDEMainStateName(null);
            super.exportCurXmlModel(pSDEMSOPPriv, xmlNode, bl);
        }
    }

    @Override
    protected String getEntityFolderKeyValue(PSDEMSOPPriv pSDEMSOPPriv, PSSystem pSSystem) throws Exception {
        PSDEMSOPPriv pSDEMSOPPriv2 = new PSDEMSOPPriv();
        pSDEMSOPPriv2.setPSDEMainStateId(pSDEMSOPPriv.getPSDEMainStateId());
        pSDEMSOPPriv2.setPSDEOPPrivId(pSDEMSOPPriv.getPSDEOPPrivId());
        if (this.selectOne(pSDEMSOPPriv2, true)) {
            return pSDEMSOPPriv2.getPSDEMSOPPrivId();
        }
        return super.getEntityFolderKeyValue(pSDEMSOPPriv, pSSystem);
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEMSOPPriv pSDEMSOPPriv, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEMSOPPriv, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEMAINSTATEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDEMAINSTATE#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEMAINSTATEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEMSOPPRIV_PSDEMAINSTATE_PSDEMAINSTATEID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEMAINSTATEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEMAINSTATENAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDEMAINSTATE", (boolean)true) == 0) {
            iEntity.set("PSDEMAINSTATEID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSDEMAINSTATEID"};
    }

    @Override
    public String getModelV2Tag(PSDEMSOPPriv pSDEMSOPPriv) {
        return super.getModelV2Tag(pSDEMSOPPriv);
    }

    @Override
    public boolean setModelV2Tag(PSDEMSOPPriv pSDEMSOPPriv, String string) {
        return super.setModelV2Tag(pSDEMSOPPriv, string);
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSDEMAINSTATEID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEMSOPPriv pSDEMSOPPriv, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEMSOPPriv.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEMSOPPriv, true);
        return super.getModelV2Entity(pSDEMSOPPriv, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEMSOPPriv pSDEMSOPPriv, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSDEMSOPPriv, objectNode, string, string2, n);
    }
}

