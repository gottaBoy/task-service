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
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.dao.PSDEMainStateRSDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEMainStateRSDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEActionBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMainState;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMainStateBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMainStateRS;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEMainStateRSServiceBase
extends PSCoreSysServiceBase<PSDEMainStateRS> {
    private static final Log log = LogFactory.getLog(PSDEMainStateRSServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSDEMainStateRSDEModel pSDEMainStateRSDEModel;
    private PSDEMainStateRSDAO pSDEMainStateRSDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEMainStateRSService";
    }

    public PSDEMainStateRSDEModel getPSDEMainStateRSDEModel() {
        if (this.pSDEMainStateRSDEModel == null) {
            try {
                this.pSDEMainStateRSDEModel = (PSDEMainStateRSDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEMainStateRSDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEMainStateRSDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEMainStateRSDEModel();
    }

    public PSDEMainStateRSDAO getPSDEMainStateRSDAO() {
        if (this.pSDEMainStateRSDAO == null) {
            try {
                this.pSDEMainStateRSDAO = (PSDEMainStateRSDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEMainStateRSDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEMainStateRSDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEMainStateRSDAO();
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

    protected void onFillParentInfo(PSDEMainStateRS pSDEMainStateRS, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEMAINSTATERS_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSDEMainStateRS, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEMAINSTATERS_PSDEACTION_ENTERPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEAction);
            } else {
                iService.get((IEntity)pSDEAction);
            }
            this.onFillParentInfo_EnterPSDEAction(pSDEMainStateRS, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEMAINSTATERS_PSDEMAINSTATE_NEXTPSDEMSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEMainStateService", (SessionFactory)this.getSessionFactory());
            PSDEMainState pSDEMainState = (PSDEMainState)iService.getDEModel().createEntity();
            pSDEMainState.set("PSDEMAINSTATEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEMainState);
            } else {
                iService.get((IEntity)pSDEMainState);
            }
            this.onFillParentInfo_NextPSDEMS(pSDEMainStateRS, pSDEMainState);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEMAINSTATERS_PSDEMAINSTATE_PREVPSDEMSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEMainStateService", (SessionFactory)this.getSessionFactory());
            PSDEMainState pSDEMainState = (PSDEMainState)iService.getDEModel().createEntity();
            pSDEMainState.set("PSDEMAINSTATEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEMainState);
            } else {
                iService.get((IEntity)pSDEMainState);
            }
            this.onFillParentInfo_PrevPSDEMS(pSDEMainStateRS, pSDEMainState);
            return;
        }
        super.onFillParentInfo((IEntity)pSDEMainStateRS, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDE(PSDEMainStateRS pSDEMainStateRS, PSDataEntity pSDataEntity) throws Exception {
        pSDEMainStateRS.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSDEMainStateRS.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_EnterPSDEAction(PSDEMainStateRS pSDEMainStateRS, PSDEAction pSDEAction) throws Exception {
        pSDEMainStateRS.setEnterPSDEActionId(pSDEAction.getPSDEActionId());
        pSDEMainStateRS.setEnterPSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_NextPSDEMS(PSDEMainStateRS pSDEMainStateRS, PSDEMainState pSDEMainState) throws Exception {
        pSDEMainStateRS.setNextPSDEMSId(pSDEMainState.getPSDEMainStateId());
        pSDEMainStateRS.setNextPSDEMSName(pSDEMainState.getPSDEMainStateName());
        if (pSDEMainState.getPSDE() != null) {
            this.onFillParentInfo_PSDE(pSDEMainStateRS, pSDEMainState.getPSDE());
        }
    }

    protected void onFillParentInfo_PrevPSDEMS(PSDEMainStateRS pSDEMainStateRS, PSDEMainState pSDEMainState) throws Exception {
        pSDEMainStateRS.setPrevPSDEMSId(pSDEMainState.getPSDEMainStateId());
        pSDEMainStateRS.setPrevPSDEMSName(pSDEMainState.getPSDEMainStateName());
    }

    protected void onFillEntityFullInfo(PSDEMainStateRS pSDEMainStateRS, boolean bl) throws Exception {
        if (bl) {
            if (pSDEMainStateRS.getCodeName() == null) {
                pSDEMainStateRS.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "MSRS", 25));
            }
            if (pSDEMainStateRS.getPSDEMainStateRSName() == null) {
                pSDEMainStateRS.setPSDEMainStateRSName((String)this.getDefaultValue(this.getWebContext(), "USER", "\u4e3b\u72b6\u6001\u5173\u7cfb", 25));
            }
            if (pSDEMainStateRS.getValidFlag() == null) {
                pSDEMainStateRS.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSDEMainStateRS, bl);
        this.onFillEntityFullInfo_PSDE(pSDEMainStateRS, bl);
        this.onFillEntityFullInfo_EnterPSDEAction(pSDEMainStateRS, bl);
        this.onFillEntityFullInfo_NextPSDEMS(pSDEMainStateRS, bl);
        this.onFillEntityFullInfo_PrevPSDEMS(pSDEMainStateRS, bl);
    }

    protected void onFillEntityFullInfo_PSDE(PSDEMainStateRS pSDEMainStateRS, boolean bl) throws Exception {
        if (pSDEMainStateRS.isPSDEIdDirty()) {
            if (pSDEMainStateRS.getPSDEId() != null) {
                if (pSDEMainStateRS.getPSDEId() == null || pSDEMainStateRS.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSDEMainStateRS.getPSDE();
                    pSDEMainStateRS.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDEMainStateRS.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_EnterPSDEAction(PSDEMainStateRS pSDEMainStateRS, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_NextPSDEMS(PSDEMainStateRS pSDEMainStateRS, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PrevPSDEMS(PSDEMainStateRS pSDEMainStateRS, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDEMainStateRS pSDEMainStateRS, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDEMainStateRS, bl);
    }

    public ArrayList<PSDEMainStateRS> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEMainStateRS> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEMainStateRS> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEMainStateRS> selectByEnterPSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByEnterPSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDEMainStateRS> selectByEnterPSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByEnterPSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDEMainStateRS> selectByEnterPSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("ENTERPSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByEnterPSDEActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByEnterPSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEMainStateRS> selectByNextPSDEMS(PSDEMainStateBase pSDEMainStateBase) throws Exception {
        return this.selectByNextPSDEMS(pSDEMainStateBase, "", -1);
    }

    public ArrayList<PSDEMainStateRS> selectByNextPSDEMS(PSDEMainStateBase pSDEMainStateBase, String string) throws Exception {
        return this.selectByNextPSDEMS(pSDEMainStateBase, string, -1);
    }

    public ArrayList<PSDEMainStateRS> selectByNextPSDEMS(PSDEMainStateBase pSDEMainStateBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("NEXTPSDEMSID", (Object)pSDEMainStateBase.getPSDEMainStateId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByNextPSDEMSCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByNextPSDEMSCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEMainStateRS> selectTempByNextPSDEMS(PSDEMainStateBase pSDEMainStateBase) throws Exception {
        return this.selectTempByNextPSDEMS(pSDEMainStateBase, "");
    }

    public ArrayList<PSDEMainStateRS> selectTempByNextPSDEMS(PSDEMainStateBase pSDEMainStateBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("NEXTPSDEMSID", (Object)pSDEMainStateBase.getPSDEMainStateId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByNextPSDEMSCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByNextPSDEMSCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEMainStateRS> selectByPrevPSDEMS(PSDEMainStateBase pSDEMainStateBase) throws Exception {
        return this.selectByPrevPSDEMS(pSDEMainStateBase, "", -1);
    }

    public ArrayList<PSDEMainStateRS> selectByPrevPSDEMS(PSDEMainStateBase pSDEMainStateBase, String string) throws Exception {
        return this.selectByPrevPSDEMS(pSDEMainStateBase, string, -1);
    }

    public ArrayList<PSDEMainStateRS> selectByPrevPSDEMS(PSDEMainStateBase pSDEMainStateBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PREVPSDEMSID", (Object)pSDEMainStateBase.getPSDEMainStateId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPrevPSDEMSCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPrevPSDEMSCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEMainStateRS> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSDEMainStateRS pSDEMainStateRS : arrayList) {
            PSDEMainStateRS pSDEMainStateRS2 = (PSDEMainStateRS)this.getDEModel().createEntity();
            pSDEMainStateRS2.setPSDEMainStateRSId(pSDEMainStateRS.getPSDEMainStateRSId());
            pSDEMainStateRS2.setPSDEId(null);
            this.update(pSDEMainStateRS2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEMainStateRSServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSDEMainStateRSServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSDEMainStateRSServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEMainStateRS> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSDEMainStateRS pSDEMainStateRS : arrayList) {
            this.remove((IEntity)pSDEMainStateRS);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEMainStateRS> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEMainStateRS> arrayList) throws Exception {
    }

    public void testRemoveByEnterPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEMainStateRS> arrayList = this.selectByEnterPSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEMAINSTATERS_PSDEACTION_ENTERPSDEACTIONID", "", iDataEntityModel.getName(), "PSDEMAINSTATERS", iDataEntityModel.getDataInfo((IEntity)pSDEAction), arrayList.get(0)));
        }
    }

    public void resetEnterPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEMainStateRS> arrayList = this.selectByEnterPSDEAction(pSDEAction);
        for (PSDEMainStateRS pSDEMainStateRS : arrayList) {
            PSDEMainStateRS pSDEMainStateRS2 = (PSDEMainStateRS)this.getDEModel().createEntity();
            pSDEMainStateRS2.setPSDEMainStateRSId(pSDEMainStateRS.getPSDEMainStateRSId());
            pSDEMainStateRS2.setEnterPSDEActionId(null);
            this.update(pSDEMainStateRS2);
        }
    }

    public void removeByEnterPSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEMainStateRSServiceBase.this.onBeforeRemoveByEnterPSDEAction(pSDEAction2);
                PSDEMainStateRSServiceBase.this.internalRemoveByEnterPSDEAction(pSDEAction2);
                PSDEMainStateRSServiceBase.this.onAfterRemoveByEnterPSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByEnterPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByEnterPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEMainStateRS> arrayList = this.selectByEnterPSDEAction(pSDEAction);
        this.onBeforeRemoveByEnterPSDEAction(pSDEAction, arrayList);
        for (PSDEMainStateRS pSDEMainStateRS : arrayList) {
            this.remove((IEntity)pSDEMainStateRS);
        }
        this.onAfterRemoveByEnterPSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByEnterPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByEnterPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEMainStateRS> arrayList) throws Exception {
    }

    protected void onAfterRemoveByEnterPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEMainStateRS> arrayList) throws Exception {
    }

    public void testRemoveByNextPSDEMS(PSDEMainState pSDEMainState) throws Exception {
    }

    public void resetNextPSDEMS(PSDEMainState pSDEMainState) throws Exception {
        ArrayList<PSDEMainStateRS> arrayList = this.selectByNextPSDEMS(pSDEMainState);
        for (PSDEMainStateRS pSDEMainStateRS : arrayList) {
            PSDEMainStateRS pSDEMainStateRS2 = (PSDEMainStateRS)this.getDEModel().createEntity();
            pSDEMainStateRS2.setPSDEMainStateRSId(pSDEMainStateRS.getPSDEMainStateRSId());
            pSDEMainStateRS2.setNextPSDEMSId(null);
            this.update(pSDEMainStateRS2);
        }
    }

    public void resetTempNextPSDEMS(PSDEMainState pSDEMainState) throws Exception {
        ArrayList<PSDEMainStateRS> arrayList = this.selectTempByNextPSDEMS(pSDEMainState);
        for (PSDEMainStateRS pSDEMainStateRS : arrayList) {
            PSDEMainStateRS pSDEMainStateRS2 = (PSDEMainStateRS)this.getDEModel().createEntity();
            pSDEMainStateRS2.setPSDEMainStateRSId(pSDEMainStateRS.getPSDEMainStateRSId());
            pSDEMainStateRS2.setNextPSDEMSId(null);
            this.updateTemp((IEntity)pSDEMainStateRS2);
        }
    }

    public void removeByNextPSDEMS(PSDEMainState pSDEMainState) throws Exception {
        final PSDEMainState pSDEMainState2 = pSDEMainState;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEMainStateRSServiceBase.this.onBeforeRemoveByNextPSDEMS(pSDEMainState2);
                PSDEMainStateRSServiceBase.this.internalRemoveByNextPSDEMS(pSDEMainState2);
                PSDEMainStateRSServiceBase.this.onAfterRemoveByNextPSDEMS(pSDEMainState2);
            }
        });
    }

    protected void onBeforeRemoveByNextPSDEMS(PSDEMainState pSDEMainState) throws Exception {
    }

    protected void internalRemoveByNextPSDEMS(PSDEMainState pSDEMainState) throws Exception {
        ArrayList<PSDEMainStateRS> arrayList = this.selectByNextPSDEMS(pSDEMainState);
        this.onBeforeRemoveByNextPSDEMS(pSDEMainState, arrayList);
        for (PSDEMainStateRS pSDEMainStateRS : arrayList) {
            this.remove((IEntity)pSDEMainStateRS);
        }
        this.onAfterRemoveByNextPSDEMS(pSDEMainState, arrayList);
    }

    protected void onAfterRemoveByNextPSDEMS(PSDEMainState pSDEMainState) throws Exception {
    }

    protected void onBeforeRemoveByNextPSDEMS(PSDEMainState pSDEMainState, ArrayList<PSDEMainStateRS> arrayList) throws Exception {
    }

    protected void onAfterRemoveByNextPSDEMS(PSDEMainState pSDEMainState, ArrayList<PSDEMainStateRS> arrayList) throws Exception {
    }

    public void testRemoveByPrevPSDEMS(PSDEMainState pSDEMainState) throws Exception {
    }

    public void resetPrevPSDEMS(PSDEMainState pSDEMainState) throws Exception {
        ArrayList<PSDEMainStateRS> arrayList = this.selectByPrevPSDEMS(pSDEMainState);
        for (PSDEMainStateRS pSDEMainStateRS : arrayList) {
            PSDEMainStateRS pSDEMainStateRS2 = (PSDEMainStateRS)this.getDEModel().createEntity();
            pSDEMainStateRS2.setPSDEMainStateRSId(pSDEMainStateRS.getPSDEMainStateRSId());
            pSDEMainStateRS2.setPrevPSDEMSId(null);
            this.update(pSDEMainStateRS2);
        }
    }

    public void removeByPrevPSDEMS(PSDEMainState pSDEMainState) throws Exception {
        final PSDEMainState pSDEMainState2 = pSDEMainState;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEMainStateRSServiceBase.this.onBeforeRemoveByPrevPSDEMS(pSDEMainState2);
                PSDEMainStateRSServiceBase.this.internalRemoveByPrevPSDEMS(pSDEMainState2);
                PSDEMainStateRSServiceBase.this.onAfterRemoveByPrevPSDEMS(pSDEMainState2);
            }
        });
    }

    protected void onBeforeRemoveByPrevPSDEMS(PSDEMainState pSDEMainState) throws Exception {
    }

    protected void internalRemoveByPrevPSDEMS(PSDEMainState pSDEMainState) throws Exception {
        ArrayList<PSDEMainStateRS> arrayList = this.selectByPrevPSDEMS(pSDEMainState);
        this.onBeforeRemoveByPrevPSDEMS(pSDEMainState, arrayList);
        for (PSDEMainStateRS pSDEMainStateRS : arrayList) {
            this.remove((IEntity)pSDEMainStateRS);
        }
        this.onAfterRemoveByPrevPSDEMS(pSDEMainState, arrayList);
    }

    protected void onAfterRemoveByPrevPSDEMS(PSDEMainState pSDEMainState) throws Exception {
    }

    protected void onBeforeRemoveByPrevPSDEMS(PSDEMainState pSDEMainState, ArrayList<PSDEMainStateRS> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPrevPSDEMS(PSDEMainState pSDEMainState, ArrayList<PSDEMainStateRS> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEMainStateRS pSDEMainStateRS) throws Exception {
        super.onBeforeRemove(pSDEMainStateRS);
    }

    public void removeTempByNextPSDEMS(PSDEMainState pSDEMainState) throws Exception {
        final PSDEMainState pSDEMainState2 = pSDEMainState;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEMainStateRSServiceBase.this.onBeforeRemoveTempByNextPSDEMS(pSDEMainState2);
                PSDEMainStateRSServiceBase.this.internalRemoveTempByNextPSDEMS(pSDEMainState2);
                PSDEMainStateRSServiceBase.this.onAfterRemoveTempByNextPSDEMS(pSDEMainState2);
            }
        });
    }

    protected void onBeforeRemoveTempByNextPSDEMS(PSDEMainState pSDEMainState) throws Exception {
    }

    protected void internalRemoveTempByNextPSDEMS(PSDEMainState pSDEMainState) throws Exception {
        ArrayList<PSDEMainStateRS> arrayList = this.selectTempByNextPSDEMS(pSDEMainState);
        this.onBeforeRemoveTempByNextPSDEMS(pSDEMainState, arrayList);
        for (PSDEMainStateRS pSDEMainStateRS : arrayList) {
            this.removeTemp((IEntity)pSDEMainStateRS);
        }
        this.onAfterRemoveTempByNextPSDEMS(pSDEMainState, arrayList);
    }

    protected void onAfterRemoveTempByNextPSDEMS(PSDEMainState pSDEMainState) throws Exception {
    }

    protected void onBeforeRemoveTempByNextPSDEMS(PSDEMainState pSDEMainState, ArrayList<PSDEMainStateRS> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByNextPSDEMS(PSDEMainState pSDEMainState, ArrayList<PSDEMainStateRS> arrayList) throws Exception {
    }

    protected void replaceParentInfo(PSDEMainStateRS pSDEMainStateRS, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDEMainStateRS, cloneSession);
        if (pSDEMainStateRS.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEMainStateRS.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSDEMainStateRS, (PSDataEntity)iEntity);
        }
        if (pSDEMainStateRS.getEnterPSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDEMainStateRS.getEnterPSDEActionId())) != null) {
            this.onFillParentInfo_EnterPSDEAction(pSDEMainStateRS, (PSDEAction)iEntity);
        }
        if (pSDEMainStateRS.getNextPSDEMSId() != null && (iEntity = cloneSession.getEntity("PSDEMAINSTATE", (Object)pSDEMainStateRS.getNextPSDEMSId())) != null) {
            this.onFillParentInfo_NextPSDEMS(pSDEMainStateRS, (PSDEMainState)iEntity);
        }
        if (pSDEMainStateRS.getPrevPSDEMSId() != null && (iEntity = cloneSession.getEntity("PSDEMAINSTATE", (Object)pSDEMainStateRS.getPrevPSDEMSId())) != null) {
            this.onFillParentInfo_PrevPSDEMS(pSDEMainStateRS, (PSDEMainState)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEMainStateRS pSDEMainStateRS, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDEMainStateRS, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEMainStateRS pSDEMainStateRS, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSDEMainStateRS, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnterPSDEActionId(bl, pSDEMainStateRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEMainStateRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NextPSDEMSId(bl, pSDEMainStateRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDEMainStateRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PrevPSDEMSId(bl, pSDEMainStateRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSDEMainStateRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEMainStateRSId(bl, pSDEMainStateRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEMainStateRSName(bl, pSDEMainStateRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSDEMainStateRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDEMainStateRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDEMainStateRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDEMainStateRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDEMainStateRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDEMainStateRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDEMainStateRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDEMainStateRS, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSDEMainStateRS pSDEMainStateRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMainStateRS.isCodeNameDirty() && !bl2 : !pSDEMainStateRS.isCodeNameDirty()) {
            return null;
        }
        String string = pSDEMainStateRS.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSDEMainStateRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSDEID";
                String string4 = this.checkFieldDupRule(this.getPSDEMainStateRSDEModel(), "CODENAME", string3, pSDEMainStateRS, bl2, bl3);
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

    protected EntityFieldError onCheckField_EnterPSDEActionId(boolean bl, PSDEMainStateRS pSDEMainStateRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMainStateRS.isEnterPSDEActionIdDirty() : !pSDEMainStateRS.isEnterPSDEActionIdDirty()) {
            return null;
        }
        String string = pSDEMainStateRS.getEnterPSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EnterPSDEActionId_Default((IEntity)pSDEMainStateRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENTERPSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEMainStateRS pSDEMainStateRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMainStateRS.isMemoDirty() : !pSDEMainStateRS.isMemoDirty()) {
            return null;
        }
        String string = pSDEMainStateRS.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDEMainStateRS, bl2, bl3);
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

    protected EntityFieldError onCheckField_NextPSDEMSId(boolean bl, PSDEMainStateRS pSDEMainStateRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMainStateRS.isNextPSDEMSIdDirty() && !bl2 : !pSDEMainStateRS.isNextPSDEMSIdDirty()) {
            return null;
        }
        String string = pSDEMainStateRS.getNextPSDEMSId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NEXTPSDEMSID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_NextPSDEMSId_Default((IEntity)pSDEMainStateRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NEXTPSDEMSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDEMainStateRS pSDEMainStateRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMainStateRS.isOrderValueDirty() : !pSDEMainStateRS.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDEMainStateRS.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSDEMainStateRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORDERVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PrevPSDEMSId(boolean bl, PSDEMainStateRS pSDEMainStateRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMainStateRS.isPrevPSDEMSIdDirty() && !bl2 : !pSDEMainStateRS.isPrevPSDEMSIdDirty()) {
            return null;
        }
        String string = pSDEMainStateRS.getPrevPSDEMSId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PREVPSDEMSID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PrevPSDEMSId_Default((IEntity)pSDEMainStateRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PREVPSDEMSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSDEMainStateRS pSDEMainStateRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMainStateRS.isPSDEIdDirty() : !pSDEMainStateRS.isPSDEIdDirty()) {
            return null;
        }
        String string = pSDEMainStateRS.getPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default((IEntity)pSDEMainStateRS, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEMainStateRSId(boolean bl, PSDEMainStateRS pSDEMainStateRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMainStateRS.isPSDEMainStateRSIdDirty() && !bl2 : !pSDEMainStateRS.isPSDEMainStateRSIdDirty()) {
            return null;
        }
        String string = pSDEMainStateRS.getPSDEMainStateRSId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEMAINSTATERSID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEMainStateRSId_Default((IEntity)pSDEMainStateRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEMAINSTATERSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEMainStateRSName(boolean bl, PSDEMainStateRS pSDEMainStateRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMainStateRS.isPSDEMainStateRSNameDirty() && !bl2 : !pSDEMainStateRS.isPSDEMainStateRSNameDirty()) {
            return null;
        }
        String string = pSDEMainStateRS.getPSDEMainStateRSName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEMAINSTATERSNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEMainStateRSName_Default((IEntity)pSDEMainStateRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEMAINSTATERSNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSDEID";
                String string4 = this.checkFieldDupRule(this.getPSDEMainStateRSDEModel(), "PSDEMAINSTATERSNAME", string3, pSDEMainStateRS, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDEMAINSTATERSNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSDEMainStateRS pSDEMainStateRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMainStateRS.isPSDENameDirty() && !bl2 : !pSDEMainStateRS.isPSDENameDirty()) {
            return null;
        }
        String string = pSDEMainStateRS.getPSDEName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default((IEntity)pSDEMainStateRS, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDEMainStateRS pSDEMainStateRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMainStateRS.isUserCatDirty() : !pSDEMainStateRS.isUserCatDirty()) {
            return null;
        }
        String string = pSDEMainStateRS.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSDEMainStateRS, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDEMainStateRS pSDEMainStateRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMainStateRS.isUserTagDirty() : !pSDEMainStateRS.isUserTagDirty()) {
            return null;
        }
        String string = pSDEMainStateRS.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSDEMainStateRS, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDEMainStateRS pSDEMainStateRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMainStateRS.isUserTag2Dirty() : !pSDEMainStateRS.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDEMainStateRS.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSDEMainStateRS, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDEMainStateRS pSDEMainStateRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMainStateRS.isUserTag3Dirty() : !pSDEMainStateRS.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDEMainStateRS.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSDEMainStateRS, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDEMainStateRS pSDEMainStateRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMainStateRS.isUserTag4Dirty() : !pSDEMainStateRS.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDEMainStateRS.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSDEMainStateRS, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDEMainStateRS pSDEMainStateRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMainStateRS.isValidFlagDirty() && !bl2 : !pSDEMainStateRS.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDEMainStateRS.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSDEMainStateRS, bl2, bl3);
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

    protected void onSyncEntity(PSDEMainStateRS pSDEMainStateRS, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDEMainStateRS, bl);
    }

    protected void onSyncIndexEntities(PSDEMainStateRS pSDEMainStateRS, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDEMainStateRS, bl);
    }

    public Object getDataContextValue(PSDEMainStateRS pSDEMainStateRS, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDEMainStateRS, string, iDataContextParam)) != null) {
            return object;
        }
        PSDEMainState pSDEMainState = pSDEMainStateRS.getNextPSDEMS();
        if (pSDEMainState != null && pSDEMainState.contains(string)) {
            return pSDEMainState.get(string);
        }
        PSDEMainState pSDEMainState2 = pSDEMainStateRS.getPrevPSDEMS();
        if (pSDEMainState2 != null && pSDEMainState2.contains(string)) {
            return pSDEMainState2.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDEMainStateRS pSDEMainStateRS, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDEMainStateRS, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"ENTERPSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnterPSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENTERPSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnterPSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NEXTPSDEMSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NextPSDEMSId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NEXTPSDEMSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NextPSDEMSName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PREVPSDEMSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PrevPSDEMSId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PREVPSDEMSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PrevPSDEMSName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEMAINSTATERSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEMainStateRSId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEMAINSTATERSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEMainStateRSName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
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
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
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

    protected String onTestValueRule_EnterPSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ENTERPSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EnterPSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ENTERPSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
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

    protected String onTestValueRule_NextPSDEMSId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NEXTPSDEMSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false) && (this.checkFieldSimpleRule("PREVPSDEMSID", iEntity, bl2, "ISNULL", null, null, "", true) || this.checkFieldSimpleRule("NEXTPSDEMSID", iEntity, bl2, "NOTEQ", "ENTITYFIELD", "PREVPSDEMSID", "\u5185\u5bb9\u4e0d\u80fd\u7b49\u4e8e[\u524d\u5e8f\u72b6\u6001]", true))) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100] \u5e76\u4e14 \u5185\u5bb9\u4e0d\u80fd\u7b49\u4e8e[\u524d\u5e8f\u72b6\u6001])";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NextPSDEMSName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NEXTPSDEMSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PrevPSDEMSId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PREVPSDEMSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false) && (this.checkFieldSimpleRule("NEXTPSDEMSID", iEntity, bl2, "ISNULL", null, null, "", true) || this.checkFieldSimpleRule("PREVPSDEMSID", iEntity, bl2, "NOTEQ", "ENTITYFIELD", "NEXTPSDEMSID", "\u5185\u5bb9\u4e0d\u80fd\u7b49\u4e8e[\u8fdb\u5165\u72b6\u6001]", true))) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100] \u5e76\u4e14 \u5185\u5bb9\u4e0d\u80fd\u7b49\u4e8e[\u8fdb\u5165\u72b6\u6001])";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PrevPSDEMSName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PREVPSDEMSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_PSDEMainStateRSId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEMAINSTATERSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEMainStateRSName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEMAINSTATERSNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDEMainStateRS pSDEMainStateRS) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDEMainStateRS)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEMainStateRS pSDEMainStateRS) throws Exception {
        super.onUpdateParent((IEntity)pSDEMainStateRS);
    }

    @Override
    protected void exportCurXmlModel(PSDEMainStateRS pSDEMainStateRS, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEMAINSTATERS");
        if (!bl) {
            pSDEMainStateRS.setCreateDate(null);
            pSDEMainStateRS.setCreateMan(null);
            pSDEMainStateRS.setPSDEMainStateRSId(null);
            pSDEMainStateRS.setUpdateDate(null);
            pSDEMainStateRS.setUpdateMan(null);
            pSDEMainStateRS.setNextPSDEMSId(null);
            pSDEMainStateRS.setNextPSDEMSName(null);
            super.exportCurXmlModel(pSDEMainStateRS, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEMainStateRS pSDEMainStateRS, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEMainStateRS, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"NEXTPSDEMSID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDEMAINSTATE#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"NEXTPSDEMSID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEMAINSTATERS_PSDEMAINSTATE_NEXTPSDEMSID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"NEXTPSDEMSID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"NEXTPSDEMSNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDEMAINSTATE", (boolean)true) == 0) {
            iEntity.set("NEXTPSDEMSID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"NEXTPSDEMSID"};
    }

    @Override
    public String getModelV2Tag(PSDEMainStateRS pSDEMainStateRS) {
        if (!StringHelper.isNullOrEmpty((String)pSDEMainStateRS.getCodeName())) {
            return pSDEMainStateRS.getCodeName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSDEMainStateRS.getPSDEMainStateRSName())) {
            return pSDEMainStateRS.getPSDEMainStateRSName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSDEMainStateRS.getCodeName())) {
            return pSDEMainStateRS.getCodeName();
        }
        return super.getModelV2Tag(pSDEMainStateRS);
    }

    @Override
    public boolean setModelV2Tag(PSDEMainStateRS pSDEMainStateRS, String string) {
        pSDEMainStateRS.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSDEMAINSTATERSNAME", "");
        map.put("CODENAME", "");
        map.put("CODENAME", "");
        map.put("PSDEMAINSTATERSNAME", "");
        map.put("NEXTPSDEMSID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEMainStateRS pSDEMainStateRS, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEMainStateRS.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEMainStateRS, true);
        pSDEMainStateRS.set("CODENAME", string);
        if (this.select(pSDEMainStateRS, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDEMainStateRS, true);
        return super.getModelV2Entity(pSDEMainStateRS, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEMainStateRS pSDEMainStateRS, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSDEMainStateRS, objectNode, string, string2, n);
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSDEMainStateRS pSDEMainStateRS, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "MSRS");
        defaultValueMap.put("PSDEMAINSTATERSNAME", "\u4e3b\u72b6\u6001\u5173\u7cfb");
    }
}

