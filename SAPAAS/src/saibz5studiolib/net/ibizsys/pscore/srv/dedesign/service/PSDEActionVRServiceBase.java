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
import net.ibizsys.pscore.srv.dedesign.dao.PSDEActionVRDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEActionVRDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEActionBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEActionVR;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFValueRule;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFValueRuleBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEActionVRServiceBase
extends PSCoreSysServiceBase<PSDEActionVR> {
    private static final Log log = LogFactory.getLog(PSDEActionVRServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDEActionVRDEModel pSDEActionVRDEModel;
    private PSDEActionVRDAO pSDEActionVRDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEActionVRService";
    }

    public PSDEActionVRDEModel getPSDEActionVRDEModel() {
        if (this.pSDEActionVRDEModel == null) {
            try {
                this.pSDEActionVRDEModel = (PSDEActionVRDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEActionVRDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEActionVRDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEActionVRDEModel();
    }

    public PSDEActionVRDAO getPSDEActionVRDAO() {
        if (this.pSDEActionVRDAO == null) {
            try {
                this.pSDEActionVRDAO = (PSDEActionVRDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEActionVRDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEActionVRDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEActionVRDAO();
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

    protected void onFillParentInfo(PSDEActionVR pSDEActionVR, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACTIONVR_PSDEACTION_PSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEAction);
            } else {
                iService.get(pSDEAction);
            }
            this.onFillParentInfo_PSDEAction(pSDEActionVR, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACTIONVR_PSDEFVALUERULE_PSDEFVRID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFValueRuleService", (SessionFactory)this.getSessionFactory());
            PSDEFValueRule pSDEFValueRule = (PSDEFValueRule)iService.getDEModel().createEntity();
            pSDEFValueRule.set("PSDEFVALUERULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEFValueRule);
            } else {
                iService.get(pSDEFValueRule);
            }
            this.onFillParentInfo_PSDEFVR(pSDEActionVR, pSDEFValueRule);
            return;
        }
        super.onFillParentInfo(pSDEActionVR, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        if (StringHelper.compare((String)string, (String)"DER1N_PSDEACTIONVR_PSDEACTION_PSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", string2);
            return this.onSyncDER1NData_PSDEAction(pSDEAction, string3);
        }
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDEAction(PSDEActionVR pSDEActionVR, PSDEAction pSDEAction) throws Exception {
        pSDEActionVR.setPSDEActionId(pSDEAction.getPSDEActionId());
        pSDEActionVR.setPSDEActionName(pSDEAction.getPSDEActionName());
        pSDEActionVR.setPSDEId(pSDEAction.getPSDEId());
    }

    protected String onSyncDER1NData_PSDEAction(PSDEAction pSDEAction, String string) throws Exception {
        if (StringHelper.isNullOrEmpty((String)string)) {
            this.removeByPSDEAction(pSDEAction);
        } else {
            HashMap<String, String> hashMap = new HashMap<String, String>();
            String[] stringArray = StringHelper.splitEx((String)string);
            if (stringArray != null) {
                for (int i = 0; i < stringArray.length; ++i) {
                    if (StringHelper.isNullOrEmpty((String)stringArray[i])) continue;
                    hashMap.put(stringArray[i], "");
                }
            }
            ArrayList<PSDEActionVR> arrayList = this.selectByPSDEAction(pSDEAction);
            for (PSDEActionVR pSDEActionVR : arrayList) {
                if (hashMap.containsKey(DataObject.getStringValue((IDataObject)pSDEActionVR, (String)"PSDEACTIONVRID", (String)""))) continue;
                this.remove(pSDEActionVR);
            }
        }
        return null;
    }

    protected void onFillParentInfo_PSDEFVR(PSDEActionVR pSDEActionVR, PSDEFValueRule pSDEFValueRule) throws Exception {
        pSDEActionVR.setPSDEFVRId(pSDEFValueRule.getPSDEFValueRuleId());
        pSDEActionVR.setPSDEFVRName(pSDEFValueRule.getPSDEFValueRuleName());
    }

    protected void onFillEntityFullInfo(PSDEActionVR pSDEActionVR, boolean bl) throws Exception {
        if (bl) {
            if (pSDEActionVR.getValidFlag() == null) {
                pSDEActionVR.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
            if (pSDEActionVR.getVRType() == null) {
                pSDEActionVR.setVRType((String)this.getDefaultValue(this.getWebContext(), "", "DEFVALUERULE", 25));
            }
        }
        super.onFillEntityFullInfo(pSDEActionVR, bl);
        this.onFillEntityFullInfo_PSDEAction(pSDEActionVR, bl);
        this.onFillEntityFullInfo_PSDEFVR(pSDEActionVR, bl);
    }

    protected void onFillEntityFullInfo_PSDEAction(PSDEActionVR pSDEActionVR, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEFVR(PSDEActionVR pSDEActionVR, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDEActionVR pSDEActionVR, boolean bl) throws Exception {
        super.onWriteBackParent(pSDEActionVR, bl);
    }

    public ArrayList<PSDEActionVR> selectByPSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByPSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDEActionVR> selectByPSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByPSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDEActionVR> selectByPSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEActionVR> selectTempByPSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectTempByPSDEAction(pSDEActionBase, "");
    }

    public ArrayList<PSDEActionVR> selectTempByPSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDEActionCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEActionVR> selectByPSDEFVR(PSDEFValueRuleBase pSDEFValueRuleBase) throws Exception {
        return this.selectByPSDEFVR(pSDEFValueRuleBase, "", -1);
    }

    public ArrayList<PSDEActionVR> selectByPSDEFVR(PSDEFValueRuleBase pSDEFValueRuleBase, String string) throws Exception {
        return this.selectByPSDEFVR(pSDEFValueRuleBase, string, -1);
    }

    public ArrayList<PSDEActionVR> selectByPSDEFVR(PSDEFValueRuleBase pSDEFValueRuleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEFVRID", (Object)pSDEFValueRuleBase.getPSDEFValueRuleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEFVRCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEFVRCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    public void resetPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEActionVR> arrayList = this.selectByPSDEAction(pSDEAction);
        for (PSDEActionVR pSDEActionVR : arrayList) {
            PSDEActionVR pSDEActionVR2 = (PSDEActionVR)this.getDEModel().createEntity();
            pSDEActionVR2.setPSDEActionVRId(pSDEActionVR.getPSDEActionVRId());
            pSDEActionVR2.setPSDEActionId(null);
            this.update(pSDEActionVR2);
        }
    }

    public void resetTempPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEActionVR> arrayList = this.selectTempByPSDEAction(pSDEAction);
        for (PSDEActionVR pSDEActionVR : arrayList) {
            PSDEActionVR pSDEActionVR2 = (PSDEActionVR)this.getDEModel().createEntity();
            pSDEActionVR2.setPSDEActionVRId(pSDEActionVR.getPSDEActionVRId());
            pSDEActionVR2.setPSDEActionId(null);
            this.updateTemp(pSDEActionVR2);
        }
    }

    public void removeByPSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEActionVRServiceBase.this.onBeforeRemoveByPSDEAction(pSDEAction2);
                PSDEActionVRServiceBase.this.internalRemoveByPSDEAction(pSDEAction2);
                PSDEActionVRServiceBase.this.onAfterRemoveByPSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEActionVR> arrayList = this.selectByPSDEAction(pSDEAction);
        this.onBeforeRemoveByPSDEAction(pSDEAction, arrayList);
        for (PSDEActionVR pSDEActionVR : arrayList) {
            this.remove(pSDEActionVR);
        }
        this.onAfterRemoveByPSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEActionVR> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEActionVR> arrayList) throws Exception {
    }

    public void testRemoveByPSDEFVR(PSDEFValueRule pSDEFValueRule) throws Exception {
        ArrayList<PSDEActionVR> arrayList = this.selectByPSDEFVR(pSDEFValueRule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFVALUERULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEFValueRule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACTIONVR_PSDEFVALUERULE_PSDEFVRID", "", iDataEntityModel.getName(), "PSDEACTIONVR", iDataEntityModel.getDataInfo(pSDEFValueRule), arrayList.get(0)));
        }
    }

    public void resetPSDEFVR(PSDEFValueRule pSDEFValueRule) throws Exception {
        ArrayList<PSDEActionVR> arrayList = this.selectByPSDEFVR(pSDEFValueRule);
        for (PSDEActionVR pSDEActionVR : arrayList) {
            PSDEActionVR pSDEActionVR2 = (PSDEActionVR)this.getDEModel().createEntity();
            pSDEActionVR2.setPSDEActionVRId(pSDEActionVR.getPSDEActionVRId());
            pSDEActionVR2.setPSDEFVRId(null);
            this.update(pSDEActionVR2);
        }
    }

    public void removeByPSDEFVR(PSDEFValueRule pSDEFValueRule) throws Exception {
        final PSDEFValueRule pSDEFValueRule2 = pSDEFValueRule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEActionVRServiceBase.this.onBeforeRemoveByPSDEFVR(pSDEFValueRule2);
                PSDEActionVRServiceBase.this.internalRemoveByPSDEFVR(pSDEFValueRule2);
                PSDEActionVRServiceBase.this.onAfterRemoveByPSDEFVR(pSDEFValueRule2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEFVR(PSDEFValueRule pSDEFValueRule) throws Exception {
    }

    protected void internalRemoveByPSDEFVR(PSDEFValueRule pSDEFValueRule) throws Exception {
        ArrayList<PSDEActionVR> arrayList = this.selectByPSDEFVR(pSDEFValueRule);
        this.onBeforeRemoveByPSDEFVR(pSDEFValueRule, arrayList);
        for (PSDEActionVR pSDEActionVR : arrayList) {
            this.remove(pSDEActionVR);
        }
        this.onAfterRemoveByPSDEFVR(pSDEFValueRule, arrayList);
    }

    protected void onAfterRemoveByPSDEFVR(PSDEFValueRule pSDEFValueRule) throws Exception {
    }

    protected void onBeforeRemoveByPSDEFVR(PSDEFValueRule pSDEFValueRule, ArrayList<PSDEActionVR> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEFVR(PSDEFValueRule pSDEFValueRule, ArrayList<PSDEActionVR> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEActionVR pSDEActionVR) throws Exception {
        super.onBeforeRemove(pSDEActionVR);
    }

    public void removeTempByPSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEActionVRServiceBase.this.onBeforeRemoveTempByPSDEAction(pSDEAction2);
                PSDEActionVRServiceBase.this.internalRemoveTempByPSDEAction(pSDEAction2);
                PSDEActionVRServiceBase.this.onAfterRemoveTempByPSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveTempByPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEActionVR> arrayList = this.selectTempByPSDEAction(pSDEAction);
        this.onBeforeRemoveTempByPSDEAction(pSDEAction, arrayList);
        for (PSDEActionVR pSDEActionVR : arrayList) {
            this.removeTemp(pSDEActionVR);
        }
        this.onAfterRemoveTempByPSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveTempByPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEActionVR> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEActionVR> arrayList) throws Exception {
    }

    protected void replaceParentInfo(PSDEActionVR pSDEActionVR, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDEActionVR, cloneSession);
        if (pSDEActionVR.getPSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDEActionVR.getPSDEActionId())) != null) {
            this.onFillParentInfo_PSDEAction(pSDEActionVR, (PSDEAction)iEntity);
        }
        if (pSDEActionVR.getPSDEFVRId() != null && (iEntity = cloneSession.getEntity("PSDEFVALUERULE", (Object)pSDEActionVR.getPSDEFVRId())) != null) {
            this.onFillParentInfo_PSDEFVR(pSDEActionVR, (PSDEFValueRule)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEActionVR pSDEActionVR, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDEActionVR, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEActionVR pSDEActionVR, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSDEActionVR, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEActionVR, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDEActionVR, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEActionId(bl, pSDEActionVR, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEActionVRId(bl, pSDEActionVR, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEActionVRName(bl, pSDEActionVR, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFVRId(bl, pSDEActionVR, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDEActionVR, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDEActionVR, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDEActionVR, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDEActionVR, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDEActionVR, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDEActionVR, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_VRType(bl, pSDEActionVR, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDEActionVR, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSDEActionVR pSDEActionVR, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionVR.isCodeNameDirty() : !pSDEActionVR.isCodeNameDirty()) {
            return null;
        }
        String string = pSDEActionVR.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSDEActionVR, bl2, bl3);
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
                string3 = "PSDEACTIONID";
                String string4 = this.checkFieldDupRule(this.getPSDEActionVRDEModel(), "CODENAME", string3, pSDEActionVR, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEActionVR pSDEActionVR, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionVR.isMemoDirty() : !pSDEActionVR.isMemoDirty()) {
            return null;
        }
        String string = pSDEActionVR.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDEActionVR, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDEActionVR pSDEActionVR, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionVR.isOrderValueDirty() : !pSDEActionVR.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDEActionVR.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSDEActionVR, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEActionId(boolean bl, PSDEActionVR pSDEActionVR, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionVR.isPSDEActionIdDirty() && !bl2 : !pSDEActionVR.isPSDEActionIdDirty()) {
            return null;
        }
        String string = pSDEActionVR.getPSDEActionId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEACTIONID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEActionId_Default(pSDEActionVR, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEActionVRId(boolean bl, PSDEActionVR pSDEActionVR, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionVR.isPSDEActionVRIdDirty() && !bl2 : !pSDEActionVR.isPSDEActionVRIdDirty()) {
            return null;
        }
        String string = pSDEActionVR.getPSDEActionVRId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEACTIONVRID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEActionVRId_Default(pSDEActionVR, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEACTIONVRID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEActionVRName(boolean bl, PSDEActionVR pSDEActionVR, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionVR.isPSDEActionVRNameDirty() && !bl2 : !pSDEActionVR.isPSDEActionVRNameDirty()) {
            return null;
        }
        String string = pSDEActionVR.getPSDEActionVRName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEACTIONVRNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEActionVRName_Default(pSDEActionVR, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEACTIONVRNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFVRId(boolean bl, PSDEActionVR pSDEActionVR, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionVR.isPSDEFVRIdDirty() : !pSDEActionVR.isPSDEFVRIdDirty()) {
            return null;
        }
        String string = pSDEActionVR.getPSDEFVRId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFVRId_Default(pSDEActionVR, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFVRID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDEActionVR pSDEActionVR, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionVR.isUserCatDirty() : !pSDEActionVR.isUserCatDirty()) {
            return null;
        }
        String string = pSDEActionVR.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSDEActionVR, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDEActionVR pSDEActionVR, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionVR.isUserTagDirty() : !pSDEActionVR.isUserTagDirty()) {
            return null;
        }
        String string = pSDEActionVR.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDEActionVR, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDEActionVR pSDEActionVR, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionVR.isUserTag2Dirty() : !pSDEActionVR.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDEActionVR.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDEActionVR, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDEActionVR pSDEActionVR, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionVR.isUserTag3Dirty() : !pSDEActionVR.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDEActionVR.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSDEActionVR, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDEActionVR pSDEActionVR, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionVR.isUserTag4Dirty() : !pSDEActionVR.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDEActionVR.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSDEActionVR, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDEActionVR pSDEActionVR, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionVR.isValidFlagDirty() && !bl2 : !pSDEActionVR.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDEActionVR.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSDEActionVR, bl2, bl3);
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

    protected EntityFieldError onCheckField_VRType(boolean bl, PSDEActionVR pSDEActionVR, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionVR.isVRTypeDirty() : !pSDEActionVR.isVRTypeDirty()) {
            return null;
        }
        String string = pSDEActionVR.getVRType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_VRType_Default(pSDEActionVR, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VRTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDEActionVR pSDEActionVR, boolean bl) throws Exception {
        super.onSyncEntity(pSDEActionVR, bl);
    }

    protected void onSyncIndexEntities(PSDEActionVR pSDEActionVR, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDEActionVR, bl);
    }

    public Object getDataContextValue(PSDEActionVR pSDEActionVR, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDEActionVR, string, iDataContextParam)) != null) {
            return object;
        }
        PSDEAction pSDEAction = pSDEActionVR.getPSDEAction();
        if (pSDEAction != null && pSDEAction.contains(string)) {
            return pSDEAction.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDEActionVR pSDEActionVR, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDEActionVR, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEACTIONVRID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEActionVRId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEACTIONVRNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEActionVRName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFVRID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFVRId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFVRNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFVRName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"VRTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_VRType_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false) && this.checkFieldRegExRule("CODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEActionVRId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEACTIONVRID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEActionVRName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEACTIONVRNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFVRId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFVRID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFVRName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFVRNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_VRType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VRTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDEActionVR pSDEActionVR) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDEActionVR)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEActionVR pSDEActionVR) throws Exception {
        super.onUpdateParent(pSDEActionVR);
    }

    @Override
    protected void exportCurXmlModel(PSDEActionVR pSDEActionVR, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEACTIONVR");
        if (!bl) {
            pSDEActionVR.setCreateDate(null);
            pSDEActionVR.setCreateMan(null);
            pSDEActionVR.setPSDEActionVRId(null);
            pSDEActionVR.setUpdateDate(null);
            pSDEActionVR.setUpdateMan(null);
            pSDEActionVR.setPSDEActionId(null);
            pSDEActionVR.setPSDEActionName(null);
            pSDEActionVR.setPSDEId(null);
            super.exportCurXmlModel(pSDEActionVR, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEActionVR pSDEActionVR, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEActionVR, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEACTIONID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDEACTION#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEACTIONID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEACTIONVR_PSDEACTION_PSDEACTIONID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEACTIONID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEACTIONNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDEACTION", (boolean)true) == 0) {
            iEntity.set("PSDEACTIONID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSDEACTIONID"};
    }

    @Override
    public String getModelV2Tag(PSDEActionVR pSDEActionVR) {
        if (!StringHelper.isNullOrEmpty((String)pSDEActionVR.getCodeName())) {
            return pSDEActionVR.getCodeName();
        }
        return super.getModelV2Tag(pSDEActionVR);
    }

    @Override
    public boolean setModelV2Tag(PSDEActionVR pSDEActionVR, String string) {
        pSDEActionVR.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSDEACTIONID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEActionVR pSDEActionVR, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEActionVR.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEActionVR, true);
        pSDEActionVR.set("CODENAME", string);
        if (this.select(pSDEActionVR, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDEActionVR, true);
        return super.getModelV2Entity(pSDEActionVR, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEActionVR pSDEActionVR, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSDEActionVR, objectNode, string, string2, n);
    }
}

