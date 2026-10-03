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
 *  net.ibizsys.paas.service.IServicePlugin
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
package net.ibizsys.pscore.srv.sysdesign.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.sql.Timestamp;
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
import net.ibizsys.paas.service.IServicePlugin;
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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterAS;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterASBase;
import net.ibizsys.pscore.srv.sysdesign.dao.PSSystemASDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSystemASDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemAS;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemRunService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSystemASServiceBase
extends PSCoreSysServiceBase<PSSystemAS> {
    private static final Log log = LogFactory.getLog(PSSystemASServiceBase.class);
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_CURSYSANDBIND = "CurSysAndBind";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_OPENWEBCONSOLE = "OPENWEBCONSOLE";
    private PSSystemASDEModel pSSystemASDEModel;
    private PSSystemASDAO pSSystemASDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSystemASService";
    }

    public PSSystemASDEModel getPSSystemASDEModel() {
        if (this.pSSystemASDEModel == null) {
            try {
                this.pSSystemASDEModel = (PSSystemASDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSystemASDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSystemASDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSystemASDEModel();
    }

    public PSSystemASDAO getPSSystemASDAO() {
        if (this.pSSystemASDAO == null) {
            try {
                this.pSSystemASDAO = (PSSystemASDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSystemASDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSystemASDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSystemASDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchCurSys(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSANDBIND, (boolean)true) == 0) {
            return this.fetchCurSysAndBind(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_OPENWEBCONSOLE, (boolean)true) == 0) {
            this.openWebConsole((PSSystemAS)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurSys(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYS, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysAndBind(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSANDBIND, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public void openWebConsole(PSSystemAS pSSystemAS) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_OPENWEBCONSOLE, 0, pSSystemAS, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSSystemAS, ACTION_OPENWEBCONSOLE);
        final PSSystemAS pSSystemAS2 = pSSystemAS;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSystemASServiceBase.this.getService(), PSSystemASServiceBase.ACTION_OPENWEBCONSOLE, 40, pSSystemAS2, null).getResult() != 1) {
                    PSSystemASServiceBase.this.onOpenWebConsole(pSSystemAS2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_OPENWEBCONSOLE, 99, pSSystemAS, null);
        }
    }

    protected void onOpenWebConsole(PSSystemAS pSSystemAS) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[OPENWEBCONSOLE]");
    }

    protected void onFillParentInfo(PSSystemAS pSSystemAS, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTEMAS_PSDEVCENTERAS_PSDEVCENTERASID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterASService", (SessionFactory)this.getSessionFactory());
            PSDevCenterAS pSDevCenterAS = (PSDevCenterAS)iService.getDEModel().createEntity();
            pSDevCenterAS.set("PSDEVCENTERASID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenterAS);
            } else {
                iService.get(pSDevCenterAS);
            }
            this.onFillParentInfo_PSDevCenterAS(pSSystemAS, pSDevCenterAS);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTEMAS_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSystem);
            } else {
                iService.get(pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSSystemAS, pSSystem);
            return;
        }
        super.onFillParentInfo(pSSystemAS, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDevCenterAS(PSSystemAS pSSystemAS, PSDevCenterAS pSDevCenterAS) throws Exception {
        pSSystemAS.setASType(pSDevCenterAS.getASType());
        pSSystemAS.setPSAppServerId(pSDevCenterAS.getPSAppServerId());
        pSSystemAS.setPSDevCenterASId(pSDevCenterAS.getPSDevCenterASId());
        pSSystemAS.setPSDevCenterASName(pSDevCenterAS.getPSDevCenterASName());
    }

    protected void onFillParentInfo_PSSystem(PSSystemAS pSSystemAS, PSSystem pSSystem) throws Exception {
        pSSystemAS.setPSSystemId(pSSystem.getPSSystemId());
        pSSystemAS.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected boolean onFillEntityKeyValue(PSSystemAS pSSystemAS, boolean bl) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        Object object = pSSystemAS.get("PSSYSTEMID");
        if (object == null) {
            object = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object);
        stringBuilderEx.append("||");
        Object object2 = pSSystemAS.get("ASID");
        if (object2 == null) {
            object2 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object2);
        String string = stringBuilderEx.toString();
        pSSystemAS.set(this.getPSSystemASDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId((String)string));
        return true;
    }

    protected void onFillEntityFullInfo(PSSystemAS pSSystemAS, boolean bl) throws Exception {
        if (bl && pSSystemAS.getEnableWebTool() == null) {
            pSSystemAS.setEnableWebTool((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
        }
        super.onFillEntityFullInfo(pSSystemAS, bl);
        this.onFillEntityFullInfo_PSDevCenterAS(pSSystemAS, bl);
        this.onFillEntityFullInfo_PSSystem(pSSystemAS, bl);
    }

    protected void onFillEntityFullInfo_PSDevCenterAS(PSSystemAS pSSystemAS, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystem(PSSystemAS pSSystemAS, boolean bl) throws Exception {
        if (pSSystemAS.isPSSystemIdDirty()) {
            if (pSSystemAS.getPSSystemId() != null) {
                if (pSSystemAS.getPSSystemId() == null || pSSystemAS.getPSSystemName() == null) {
                    PSSystem pSSystem = pSSystemAS.getPSSystem();
                    pSSystemAS.setPSSystemName(pSSystem.getPSSystemName());
                }
            } else {
                pSSystemAS.setPSSystemName(null);
            }
        }
    }

    protected void onWriteBackParent(PSSystemAS pSSystemAS, boolean bl) throws Exception {
        super.onWriteBackParent(pSSystemAS, bl);
    }

    public ArrayList<PSSystemAS> selectByPSDevCenterAS(PSDevCenterASBase pSDevCenterASBase) throws Exception {
        return this.selectByPSDevCenterAS(pSDevCenterASBase, "", -1);
    }

    public ArrayList<PSSystemAS> selectByPSDevCenterAS(PSDevCenterASBase pSDevCenterASBase, String string) throws Exception {
        return this.selectByPSDevCenterAS(pSDevCenterASBase, string, -1);
    }

    public ArrayList<PSSystemAS> selectByPSDevCenterAS(PSDevCenterASBase pSDevCenterASBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVCENTERASID", (Object)pSDevCenterASBase.getPSDevCenterASId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevCenterASCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevCenterASCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSystemAS> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSSystemAS> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSSystemAS> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
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

    public void testRemoveByPSDevCenterAS(PSDevCenterAS pSDevCenterAS) throws Exception {
        ArrayList<PSSystemAS> arrayList = this.selectByPSDevCenterAS(pSDevCenterAS, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERAS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenterAS);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSTEMAS_PSDEVCENTERAS_PSDEVCENTERASID", "", iDataEntityModel.getName(), "PSSYSTEMAS", iDataEntityModel.getDataInfo(pSDevCenterAS), arrayList.get(0)));
        }
    }

    public void resetPSDevCenterAS(PSDevCenterAS pSDevCenterAS) throws Exception {
        ArrayList<PSSystemAS> arrayList = this.selectByPSDevCenterAS(pSDevCenterAS);
        for (PSSystemAS pSSystemAS : arrayList) {
            PSSystemAS pSSystemAS2 = (PSSystemAS)this.getDEModel().createEntity();
            pSSystemAS2.setPSSystemASId(pSSystemAS.getPSSystemASId());
            pSSystemAS2.setPSDevCenterASId(null);
            this.update(pSSystemAS2);
        }
    }

    public void removeByPSDevCenterAS(PSDevCenterAS pSDevCenterAS) throws Exception {
        final PSDevCenterAS pSDevCenterAS2 = pSDevCenterAS;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSystemASServiceBase.this.onBeforeRemoveByPSDevCenterAS(pSDevCenterAS2);
                PSSystemASServiceBase.this.internalRemoveByPSDevCenterAS(pSDevCenterAS2);
                PSSystemASServiceBase.this.onAfterRemoveByPSDevCenterAS(pSDevCenterAS2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenterAS(PSDevCenterAS pSDevCenterAS) throws Exception {
    }

    protected void internalRemoveByPSDevCenterAS(PSDevCenterAS pSDevCenterAS) throws Exception {
        ArrayList<PSSystemAS> arrayList = this.selectByPSDevCenterAS(pSDevCenterAS);
        this.onBeforeRemoveByPSDevCenterAS(pSDevCenterAS, arrayList);
        for (PSSystemAS pSSystemAS : arrayList) {
            this.remove(pSSystemAS);
        }
        this.onAfterRemoveByPSDevCenterAS(pSDevCenterAS, arrayList);
    }

    protected void onAfterRemoveByPSDevCenterAS(PSDevCenterAS pSDevCenterAS) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenterAS(PSDevCenterAS pSDevCenterAS, ArrayList<PSSystemAS> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenterAS(PSDevCenterAS pSDevCenterAS, ArrayList<PSSystemAS> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSystemAS> arrayList = this.selectByPSSystem(pSSystem);
        for (PSSystemAS pSSystemAS : arrayList) {
            PSSystemAS pSSystemAS2 = (PSSystemAS)this.getDEModel().createEntity();
            pSSystemAS2.setPSSystemASId(pSSystemAS.getPSSystemASId());
            pSSystemAS2.setPSSystemId(null);
            this.update(pSSystemAS2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSystemASServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSSystemASServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSSystemASServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSystemAS> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSSystemAS pSSystemAS : arrayList) {
            this.remove(pSSystemAS);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSystemAS> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSystemAS> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSystemAS pSSystemAS) throws Exception {
        PSSystemRunService pSSystemRunService = (PSSystemRunService)ServiceGlobal.getService(PSSystemRunService.class, (SessionFactory)this.getSessionFactory());
        pSSystemRunService.testRemoveByPSSystemAS(pSSystemAS);
        super.onBeforeRemove(pSSystemAS);
    }

    protected void replaceParentInfo(PSSystemAS pSSystemAS, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSystemAS, cloneSession);
        if (pSSystemAS.getPSDevCenterASId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERAS", (Object)pSSystemAS.getPSDevCenterASId())) != null) {
            this.onFillParentInfo_PSDevCenterAS(pSSystemAS, (PSDevCenterAS)iEntity);
        }
        if (pSSystemAS.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSSystemAS.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSSystemAS, (PSSystem)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSystemAS pSSystemAS, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSystemAS, bl);
    }

    protected void onCheckEntity(boolean bl, PSSystemAS pSSystemAS, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ASId(bl, pSSystemAS, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableWebTool(bl, pSSystemAS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSystemAS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterASId(bl, pSSystemAS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemASId(bl, pSSystemAS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemASName(bl, pSSystemAS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSSystemAS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemName(bl, pSSystemAS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ResInfo(bl, pSSystemAS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ResReadyTime(bl, pSSystemAS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ResState(bl, pSSystemAS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSystemAS, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ASId(boolean bl, PSSystemAS pSSystemAS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemAS.isASIdDirty() && !bl2 : !pSSystemAS.isASIdDirty()) {
            return null;
        }
        String string = pSSystemAS.getASId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ASID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_ASId_Default(pSSystemAS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ASID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableWebTool(boolean bl, PSSystemAS pSSystemAS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemAS.isEnableWebToolDirty() : !pSSystemAS.isEnableWebToolDirty()) {
            return null;
        }
        Integer n = pSSystemAS.getEnableWebTool();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableWebTool_Default(pSSystemAS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEWEBTOOL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSystemAS pSSystemAS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemAS.isMemoDirty() : !pSSystemAS.isMemoDirty()) {
            return null;
        }
        String string = pSSystemAS.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSystemAS, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevCenterASId(boolean bl, PSSystemAS pSSystemAS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemAS.isPSDevCenterASIdDirty() : !pSSystemAS.isPSDevCenterASIdDirty()) {
            return null;
        }
        String string = pSSystemAS.getPSDevCenterASId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterASId_Default(pSSystemAS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERASID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemASId(boolean bl, PSSystemAS pSSystemAS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemAS.isPSSystemASIdDirty() && !bl2 : !pSSystemAS.isPSSystemASIdDirty()) {
            return null;
        }
        String string = pSSystemAS.getPSSystemASId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMASID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemASId_Default(pSSystemAS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMASID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemASName(boolean bl, PSSystemAS pSSystemAS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemAS.isPSSystemASNameDirty() && !bl2 : !pSSystemAS.isPSSystemASNameDirty()) {
            return null;
        }
        String string = pSSystemAS.getPSSystemASName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMASNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemASName_Default(pSSystemAS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMASNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSSystemAS pSSystemAS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemAS.isPSSystemIdDirty() && !bl2 : !pSSystemAS.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSSystemAS.getPSSystemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default(pSSystemAS, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemName(boolean bl, PSSystemAS pSSystemAS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemAS.isPSSystemNameDirty() : !pSSystemAS.isPSSystemNameDirty()) {
            return null;
        }
        String string = pSSystemAS.getPSSystemName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemName_Default(pSSystemAS, bl2, bl3);
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

    protected EntityFieldError onCheckField_ResInfo(boolean bl, PSSystemAS pSSystemAS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemAS.isResInfoDirty() : !pSSystemAS.isResInfoDirty()) {
            return null;
        }
        String string = pSSystemAS.getResInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ResInfo_Default(pSSystemAS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RESINFO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ResReadyTime(boolean bl, PSSystemAS pSSystemAS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemAS.isResReadyTimeDirty() : !pSSystemAS.isResReadyTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSSystemAS.getResReadyTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ResReadyTime_Default(pSSystemAS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RESREADYTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ResState(boolean bl, PSSystemAS pSSystemAS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemAS.isResStateDirty() : !pSSystemAS.isResStateDirty()) {
            return null;
        }
        Integer n = pSSystemAS.getResState();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ResState_Default(pSSystemAS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RESSTATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSSystemAS pSSystemAS, boolean bl) throws Exception {
        super.onSyncEntity(pSSystemAS, bl);
    }

    protected void onSyncIndexEntities(PSSystemAS pSSystemAS, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSystemAS, bl);
    }

    public Object getDataContextValue(PSSystemAS pSSystemAS, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSystemAS, string, iDataContextParam)) != null) {
            return object;
        }
        PSSystem pSSystem = pSSystemAS.getPSSystem();
        if (pSSystem != null && pSSystem.contains(string)) {
            return pSSystem.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSystemAS pSSystemAS, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSystemAS, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ASID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ASId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ASTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ASType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEWEBTOOL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableWebTool_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPSERVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppServerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERASID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterASId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERASNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterASName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMASID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemASId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMASNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemASName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RESINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ResInfo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RESREADYTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ResReadyTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RESSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ResState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_ASId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ASID", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ASType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ASTYPE", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
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

    protected String onTestValueRule_EnableWebTool_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_PSAppServerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPSERVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterASId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERASID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterASName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERASNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSystemASId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTEMASID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSystemASName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTEMASNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_ResInfo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RESINFO", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ResReadyTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ResState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected boolean onMergeChild(String string, String string2, PSSystemAS pSSystemAS) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSystemAS)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSystemAS pSSystemAS) throws Exception {
        super.onUpdateParent(pSSystemAS);
    }

    @Override
    protected void exportCurXmlModel(PSSystemAS pSSystemAS, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSTEMAS");
        if (!bl) {
            pSSystemAS.setASId(null);
            pSSystemAS.setEnableWebTool(null);
            pSSystemAS.setPSDevCenterASName(null);
            pSSystemAS.setPSSystemASName(null);
            super.exportCurXmlModel(pSSystemAS, xmlNode, bl);
        }
    }

    @Override
    protected String getEntityFolderKeyValue(PSSystemAS pSSystemAS, PSSystem pSSystem) throws Exception {
        PSSystemAS pSSystemAS2 = new PSSystemAS();
        pSSystemAS2.setPSSystemId(pSSystemAS.getPSSystemId());
        pSSystemAS2.setASId(pSSystemAS.getASId());
        if (this.selectOne(pSSystemAS2, true)) {
            return pSSystemAS2.getPSSystemASId();
        }
        return super.getEntityFolderKeyValue(pSSystemAS, pSSystem);
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSystemAS pSSystemAS, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSystemAS, string);
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
            return "DER1N_PSSYSTEMAS_PSSYSTEM_PSSYSTEMID";
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
    public String getModelV2Tag(PSSystemAS pSSystemAS) {
        if (!StringHelper.isNullOrEmpty((String)pSSystemAS.getASId())) {
            return pSSystemAS.getASId();
        }
        return super.getModelV2Tag(pSSystemAS);
    }

    @Override
    public boolean setModelV2Tag(PSSystemAS pSSystemAS, String string) {
        return super.setModelV2Tag(pSSystemAS, string);
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("ASID", "");
        map.put("PSSYSTEMID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSystemAS pSSystemAS, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSystemAS.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSystemAS, true);
        pSSystemAS.set("ASID", string);
        if (this.select(pSSystemAS, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSystemAS, true);
        return super.getModelV2Entity(pSSystemAS, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSystemAS pSSystemAS, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSystemAS, objectNode, string, string2, n);
    }
}

