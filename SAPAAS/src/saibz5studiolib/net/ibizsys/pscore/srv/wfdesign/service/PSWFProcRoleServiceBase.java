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
package net.ibizsys.pscore.srv.wfdesign.service;

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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysMsgTempl;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysMsgTemplBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.wfdesign.dao.PSWFProcRoleDAO;
import net.ibizsys.pscore.srv.wfdesign.demodel.PSWFProcRoleDEModel;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFProcRole;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFProcess;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFProcessBase;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFRole;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFRoleBase;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFVersion;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFVersionBase;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFLinkRoleService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSWFProcRoleServiceBase
extends PSCoreSysServiceBase<PSWFProcRole> {
    private static final Log log = LogFactory.getLog(PSWFProcRoleServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSWFProcRoleDEModel pSWFProcRoleDEModel;
    private PSWFProcRoleDAO pSWFProcRoleDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.wfdesign.service.PSWFProcRoleService";
    }

    public PSWFProcRoleDEModel getPSWFProcRoleDEModel() {
        if (this.pSWFProcRoleDEModel == null) {
            try {
                this.pSWFProcRoleDEModel = (PSWFProcRoleDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.wfdesign.demodel.PSWFProcRoleDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWFProcRoleDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSWFProcRoleDEModel();
    }

    public PSWFProcRoleDAO getPSWFProcRoleDAO() {
        if (this.pSWFProcRoleDAO == null) {
            try {
                this.pSWFProcRoleDAO = (PSWFProcRoleDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.wfdesign.dao.PSWFProcRoleDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWFProcRoleDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSWFProcRoleDAO();
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

    protected void onFillParentInfo(PSWFProcRole pSWFProcRole, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFPROCROLE_PSSYSMSGTEMPL_PSSYSMSGTEMPLID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysMsgTemplService", (SessionFactory)this.getSessionFactory());
            PSSysMsgTempl pSSysMsgTempl = (PSSysMsgTempl)iService.getDEModel().createEntity();
            pSSysMsgTempl.set("PSSYSMSGTEMPLID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysMsgTempl);
            } else {
                iService.get(pSSysMsgTempl);
            }
            this.onFillParentInfo_PSSysMsgTempl(pSWFProcRole, pSSysMsgTempl);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFPROCROLE_PSWFPROCESS_PSWFPROCESSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWFProcessService", (SessionFactory)this.getSessionFactory());
            PSWFProcess pSWFProcess = (PSWFProcess)iService.getDEModel().createEntity();
            pSWFProcess.set("PSWFPROCESSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSWFProcess);
            } else {
                iService.get(pSWFProcess);
            }
            this.onFillParentInfo_PSWFProcess(pSWFProcRole, pSWFProcess);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFPROCROLE_PSWFROLE_PSWFROLEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWFRoleService", (SessionFactory)this.getSessionFactory());
            PSWFRole pSWFRole = (PSWFRole)iService.getDEModel().createEntity();
            pSWFRole.set("PSWFROLEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSWFRole);
            } else {
                iService.get(pSWFRole);
            }
            this.onFillParentInfo_PSWFRole(pSWFProcRole, pSWFRole);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFPROCROLE_PSWFVERSION_PSWFVERSIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWFVersionService", (SessionFactory)this.getSessionFactory());
            PSWFVersion pSWFVersion = (PSWFVersion)iService.getDEModel().createEntity();
            pSWFVersion.set("PSWFVERSIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSWFVersion);
            } else {
                iService.get(pSWFVersion);
            }
            this.onFillParentInfo_PSWFVersion(pSWFProcRole, pSWFVersion);
            return;
        }
        super.onFillParentInfo(pSWFProcRole, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        if (StringHelper.compare((String)string, (String)"DER1N_PSWFPROCROLE_PSWFPROCESS_PSWFPROCESSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWFProcessService", (SessionFactory)this.getSessionFactory());
            PSWFProcess pSWFProcess = (PSWFProcess)iService.getDEModel().createEntity();
            pSWFProcess.set("PSWFPROCESSID", string2);
            return this.onSyncDER1NData_PSWFProcess(pSWFProcess, string3);
        }
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSysMsgTempl(PSWFProcRole pSWFProcRole, PSSysMsgTempl pSSysMsgTempl) throws Exception {
        pSWFProcRole.setPSSysMsgTemplId(pSSysMsgTempl.getPSSysMsgTemplId());
        pSWFProcRole.setPSSysMsgTemplName(pSSysMsgTempl.getPSSysMsgTemplName());
    }

    protected void onFillParentInfo_PSWFProcess(PSWFProcRole pSWFProcRole, PSWFProcess pSWFProcess) throws Exception {
        pSWFProcRole.setPSSystemId(pSWFProcess.getPSSystemId());
        pSWFProcRole.setPSWFProcessId(pSWFProcess.getPSWFProcessId());
        pSWFProcRole.setPSWFProcessName(pSWFProcess.getPSWFProcessName());
        if (pSWFProcess.getPSWFVersion() != null) {
            this.onFillParentInfo_PSWFVersion(pSWFProcRole, pSWFProcess.getPSWFVersion());
        }
    }

    protected String onSyncDER1NData_PSWFProcess(PSWFProcess pSWFProcess, String string) throws Exception {
        if (StringHelper.isNullOrEmpty((String)string)) {
            this.removeByPSWFProcess(pSWFProcess);
        } else {
            HashMap<String, String> hashMap = new HashMap<String, String>();
            String[] stringArray = StringHelper.splitEx((String)string);
            if (stringArray != null) {
                for (int i = 0; i < stringArray.length; ++i) {
                    if (StringHelper.isNullOrEmpty((String)stringArray[i])) continue;
                    hashMap.put(stringArray[i], "");
                }
            }
            ArrayList<PSWFProcRole> arrayList = this.selectByPSWFProcess(pSWFProcess);
            for (PSWFProcRole pSWFProcRole : arrayList) {
                if (hashMap.containsKey(DataObject.getStringValue((IDataObject)pSWFProcRole, (String)"PSWFPROCROLEID", (String)""))) continue;
                this.remove(pSWFProcRole);
            }
        }
        return null;
    }

    protected void onFillParentInfo_PSWFRole(PSWFProcRole pSWFProcRole, PSWFRole pSWFRole) throws Exception {
        pSWFProcRole.setPSWFRoleId(pSWFRole.getPSWFRoleId());
        pSWFProcRole.setPSWFRoleName(pSWFRole.getPSWFRoleName());
    }

    protected void onFillParentInfo_PSWFVersion(PSWFProcRole pSWFProcRole, PSWFVersion pSWFVersion) throws Exception {
        pSWFProcRole.setPSWFID(pSWFVersion.getPSWFId());
        pSWFProcRole.setPSWFVersionId(pSWFVersion.getPSWFVersionId());
        pSWFProcRole.setPSWFVersionName(pSWFVersion.getPSWFVersionName());
    }

    protected void onFillEntityFullInfo(PSWFProcRole pSWFProcRole, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSWFProcRole, bl);
        this.onFillEntityFullInfo_PSSysMsgTempl(pSWFProcRole, bl);
        this.onFillEntityFullInfo_PSWFProcess(pSWFProcRole, bl);
        this.onFillEntityFullInfo_PSWFRole(pSWFProcRole, bl);
        this.onFillEntityFullInfo_PSWFVersion(pSWFProcRole, bl);
    }

    protected void onFillEntityFullInfo_PSSysMsgTempl(PSWFProcRole pSWFProcRole, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSWFProcess(PSWFProcRole pSWFProcRole, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSWFRole(PSWFProcRole pSWFProcRole, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSWFVersion(PSWFProcRole pSWFProcRole, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSWFProcRole pSWFProcRole, boolean bl) throws Exception {
        super.onWriteBackParent(pSWFProcRole, bl);
    }

    public ArrayList<PSWFProcRole> selectByPSSysMsgTempl(PSSysMsgTemplBase pSSysMsgTemplBase) throws Exception {
        return this.selectByPSSysMsgTempl(pSSysMsgTemplBase, "", -1);
    }

    public ArrayList<PSWFProcRole> selectByPSSysMsgTempl(PSSysMsgTemplBase pSSysMsgTemplBase, String string) throws Exception {
        return this.selectByPSSysMsgTempl(pSSysMsgTemplBase, string, -1);
    }

    public ArrayList<PSWFProcRole> selectByPSSysMsgTempl(PSSysMsgTemplBase pSSysMsgTemplBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSMSGTEMPLID", (Object)pSSysMsgTemplBase.getPSSysMsgTemplId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysMsgTemplCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysMsgTemplCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFProcRole> selectByPSWFProcess(PSWFProcessBase pSWFProcessBase) throws Exception {
        return this.selectByPSWFProcess(pSWFProcessBase, "", -1);
    }

    public ArrayList<PSWFProcRole> selectByPSWFProcess(PSWFProcessBase pSWFProcessBase, String string) throws Exception {
        return this.selectByPSWFProcess(pSWFProcessBase, string, -1);
    }

    public ArrayList<PSWFProcRole> selectByPSWFProcess(PSWFProcessBase pSWFProcessBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSWFPROCESSID", (Object)pSWFProcessBase.getPSWFProcessId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSWFProcessCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSWFProcessCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFProcRole> selectTempByPSWFProcess(PSWFProcessBase pSWFProcessBase) throws Exception {
        return this.selectTempByPSWFProcess(pSWFProcessBase, "");
    }

    public ArrayList<PSWFProcRole> selectTempByPSWFProcess(PSWFProcessBase pSWFProcessBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSWFPROCESSID", (Object)pSWFProcessBase.getPSWFProcessId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSWFProcessCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSWFProcessCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFProcRole> selectByPSWFRole(PSWFRoleBase pSWFRoleBase) throws Exception {
        return this.selectByPSWFRole(pSWFRoleBase, "", -1);
    }

    public ArrayList<PSWFProcRole> selectByPSWFRole(PSWFRoleBase pSWFRoleBase, String string) throws Exception {
        return this.selectByPSWFRole(pSWFRoleBase, string, -1);
    }

    public ArrayList<PSWFProcRole> selectByPSWFRole(PSWFRoleBase pSWFRoleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSWFROLEID", (Object)pSWFRoleBase.getPSWFRoleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSWFRoleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSWFRoleCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFProcRole> selectByPSWFVersion(PSWFVersionBase pSWFVersionBase) throws Exception {
        return this.selectByPSWFVersion(pSWFVersionBase, "", -1);
    }

    public ArrayList<PSWFProcRole> selectByPSWFVersion(PSWFVersionBase pSWFVersionBase, String string) throws Exception {
        return this.selectByPSWFVersion(pSWFVersionBase, string, -1);
    }

    public ArrayList<PSWFProcRole> selectByPSWFVersion(PSWFVersionBase pSWFVersionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSWFVERSIONID", (Object)pSWFVersionBase.getPSWFVersionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSWFVersionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSWFVersionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFProcRole> selectTempByPSWFVersion(PSWFVersionBase pSWFVersionBase) throws Exception {
        return this.selectTempByPSWFVersion(pSWFVersionBase, "");
    }

    public ArrayList<PSWFProcRole> selectTempByPSWFVersion(PSWFVersionBase pSWFVersionBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSWFVERSIONID", (Object)pSWFVersionBase.getPSWFVersionId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSWFVersionCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSWFVersionCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl) throws Exception {
        ArrayList<PSWFProcRole> arrayList = this.selectByPSSysMsgTempl(pSSysMsgTempl, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSMSGTEMPL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysMsgTempl);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFPROCROLE_PSSYSMSGTEMPL_PSSYSMSGTEMPLID", "", iDataEntityModel.getName(), "PSWFPROCROLE", iDataEntityModel.getDataInfo(pSSysMsgTempl), arrayList.get(0)));
        }
    }

    public void resetPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl) throws Exception {
        ArrayList<PSWFProcRole> arrayList = this.selectByPSSysMsgTempl(pSSysMsgTempl);
        for (PSWFProcRole pSWFProcRole : arrayList) {
            PSWFProcRole pSWFProcRole2 = (PSWFProcRole)this.getDEModel().createEntity();
            pSWFProcRole2.setPSWFProcRoleId(pSWFProcRole.getPSWFProcRoleId());
            pSWFProcRole2.setPSSysMsgTemplId(null);
            this.update(pSWFProcRole2);
        }
    }

    public void removeByPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl) throws Exception {
        final PSSysMsgTempl pSSysMsgTempl2 = pSSysMsgTempl;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFProcRoleServiceBase.this.onBeforeRemoveByPSSysMsgTempl(pSSysMsgTempl2);
                PSWFProcRoleServiceBase.this.internalRemoveByPSSysMsgTempl(pSSysMsgTempl2);
                PSWFProcRoleServiceBase.this.onAfterRemoveByPSSysMsgTempl(pSSysMsgTempl2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl) throws Exception {
    }

    protected void internalRemoveByPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl) throws Exception {
        ArrayList<PSWFProcRole> arrayList = this.selectByPSSysMsgTempl(pSSysMsgTempl);
        this.onBeforeRemoveByPSSysMsgTempl(pSSysMsgTempl, arrayList);
        for (PSWFProcRole pSWFProcRole : arrayList) {
            this.remove(pSWFProcRole);
        }
        this.onAfterRemoveByPSSysMsgTempl(pSSysMsgTempl, arrayList);
    }

    protected void onAfterRemoveByPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl) throws Exception {
    }

    protected void onBeforeRemoveByPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl, ArrayList<PSWFProcRole> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl, ArrayList<PSWFProcRole> arrayList) throws Exception {
    }

    public void testRemoveByPSWFProcess(PSWFProcess pSWFProcess) throws Exception {
    }

    public void resetPSWFProcess(PSWFProcess pSWFProcess) throws Exception {
        ArrayList<PSWFProcRole> arrayList = this.selectByPSWFProcess(pSWFProcess);
        for (PSWFProcRole pSWFProcRole : arrayList) {
            PSWFProcRole pSWFProcRole2 = (PSWFProcRole)this.getDEModel().createEntity();
            pSWFProcRole2.setPSWFProcRoleId(pSWFProcRole.getPSWFProcRoleId());
            pSWFProcRole2.setPSWFProcessId(null);
            this.update(pSWFProcRole2);
        }
    }

    public void resetTempPSWFProcess(PSWFProcess pSWFProcess) throws Exception {
        ArrayList<PSWFProcRole> arrayList = this.selectTempByPSWFProcess(pSWFProcess);
        for (PSWFProcRole pSWFProcRole : arrayList) {
            PSWFProcRole pSWFProcRole2 = (PSWFProcRole)this.getDEModel().createEntity();
            pSWFProcRole2.setPSWFProcRoleId(pSWFProcRole.getPSWFProcRoleId());
            pSWFProcRole2.setPSWFProcessId(null);
            this.updateTemp(pSWFProcRole2);
        }
    }

    public void removeByPSWFProcess(PSWFProcess pSWFProcess) throws Exception {
        final PSWFProcess pSWFProcess2 = pSWFProcess;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFProcRoleServiceBase.this.onBeforeRemoveByPSWFProcess(pSWFProcess2);
                PSWFProcRoleServiceBase.this.internalRemoveByPSWFProcess(pSWFProcess2);
                PSWFProcRoleServiceBase.this.onAfterRemoveByPSWFProcess(pSWFProcess2);
            }
        });
    }

    protected void onBeforeRemoveByPSWFProcess(PSWFProcess pSWFProcess) throws Exception {
    }

    protected void internalRemoveByPSWFProcess(PSWFProcess pSWFProcess) throws Exception {
        ArrayList<PSWFProcRole> arrayList = this.selectByPSWFProcess(pSWFProcess);
        this.onBeforeRemoveByPSWFProcess(pSWFProcess, arrayList);
        for (PSWFProcRole pSWFProcRole : arrayList) {
            this.remove(pSWFProcRole);
        }
        this.onAfterRemoveByPSWFProcess(pSWFProcess, arrayList);
    }

    protected void onAfterRemoveByPSWFProcess(PSWFProcess pSWFProcess) throws Exception {
    }

    protected void onBeforeRemoveByPSWFProcess(PSWFProcess pSWFProcess, ArrayList<PSWFProcRole> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSWFProcess(PSWFProcess pSWFProcess, ArrayList<PSWFProcRole> arrayList) throws Exception {
    }

    public void testRemoveByPSWFRole(PSWFRole pSWFRole) throws Exception {
        ArrayList<PSWFProcRole> arrayList = this.selectByPSWFRole(pSWFRole, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSWFROLE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSWFRole);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFPROCROLE_PSWFROLE_PSWFROLEID", "", iDataEntityModel.getName(), "PSWFPROCROLE", iDataEntityModel.getDataInfo(pSWFRole), arrayList.get(0)));
        }
    }

    public void resetPSWFRole(PSWFRole pSWFRole) throws Exception {
        ArrayList<PSWFProcRole> arrayList = this.selectByPSWFRole(pSWFRole);
        for (PSWFProcRole pSWFProcRole : arrayList) {
            PSWFProcRole pSWFProcRole2 = (PSWFProcRole)this.getDEModel().createEntity();
            pSWFProcRole2.setPSWFProcRoleId(pSWFProcRole.getPSWFProcRoleId());
            pSWFProcRole2.setPSWFRoleId(null);
            this.update(pSWFProcRole2);
        }
    }

    public void removeByPSWFRole(PSWFRole pSWFRole) throws Exception {
        final PSWFRole pSWFRole2 = pSWFRole;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFProcRoleServiceBase.this.onBeforeRemoveByPSWFRole(pSWFRole2);
                PSWFProcRoleServiceBase.this.internalRemoveByPSWFRole(pSWFRole2);
                PSWFProcRoleServiceBase.this.onAfterRemoveByPSWFRole(pSWFRole2);
            }
        });
    }

    protected void onBeforeRemoveByPSWFRole(PSWFRole pSWFRole) throws Exception {
    }

    protected void internalRemoveByPSWFRole(PSWFRole pSWFRole) throws Exception {
        ArrayList<PSWFProcRole> arrayList = this.selectByPSWFRole(pSWFRole);
        this.onBeforeRemoveByPSWFRole(pSWFRole, arrayList);
        for (PSWFProcRole pSWFProcRole : arrayList) {
            this.remove(pSWFProcRole);
        }
        this.onAfterRemoveByPSWFRole(pSWFRole, arrayList);
    }

    protected void onAfterRemoveByPSWFRole(PSWFRole pSWFRole) throws Exception {
    }

    protected void onBeforeRemoveByPSWFRole(PSWFRole pSWFRole, ArrayList<PSWFProcRole> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSWFRole(PSWFRole pSWFRole, ArrayList<PSWFProcRole> arrayList) throws Exception {
    }

    public void testRemoveByPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
        ArrayList<PSWFProcRole> arrayList = this.selectByPSWFVersion(pSWFVersion, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSWFVERSION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSWFVersion);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFPROCROLE_PSWFVERSION_PSWFVERSIONID", "", iDataEntityModel.getName(), "PSWFPROCROLE", iDataEntityModel.getDataInfo(pSWFVersion), arrayList.get(0)));
        }
    }

    public void resetPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
        ArrayList<PSWFProcRole> arrayList = this.selectByPSWFVersion(pSWFVersion);
        for (PSWFProcRole pSWFProcRole : arrayList) {
            PSWFProcRole pSWFProcRole2 = (PSWFProcRole)this.getDEModel().createEntity();
            pSWFProcRole2.setPSWFProcRoleId(pSWFProcRole.getPSWFProcRoleId());
            pSWFProcRole2.setPSWFVersionId(null);
            this.update(pSWFProcRole2);
        }
    }

    public void resetTempPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
        ArrayList<PSWFProcRole> arrayList = this.selectTempByPSWFVersion(pSWFVersion);
        for (PSWFProcRole pSWFProcRole : arrayList) {
            PSWFProcRole pSWFProcRole2 = (PSWFProcRole)this.getDEModel().createEntity();
            pSWFProcRole2.setPSWFProcRoleId(pSWFProcRole.getPSWFProcRoleId());
            pSWFProcRole2.setPSWFVersionId(null);
            this.updateTemp(pSWFProcRole2);
        }
    }

    public void removeByPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
        final PSWFVersion pSWFVersion2 = pSWFVersion;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFProcRoleServiceBase.this.onBeforeRemoveByPSWFVersion(pSWFVersion2);
                PSWFProcRoleServiceBase.this.internalRemoveByPSWFVersion(pSWFVersion2);
                PSWFProcRoleServiceBase.this.onAfterRemoveByPSWFVersion(pSWFVersion2);
            }
        });
    }

    protected void onBeforeRemoveByPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
    }

    protected void internalRemoveByPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
        ArrayList<PSWFProcRole> arrayList = this.selectByPSWFVersion(pSWFVersion);
        this.onBeforeRemoveByPSWFVersion(pSWFVersion, arrayList);
        for (PSWFProcRole pSWFProcRole : arrayList) {
            this.remove(pSWFProcRole);
        }
        this.onAfterRemoveByPSWFVersion(pSWFVersion, arrayList);
    }

    protected void onAfterRemoveByPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
    }

    protected void onBeforeRemoveByPSWFVersion(PSWFVersion pSWFVersion, ArrayList<PSWFProcRole> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSWFVersion(PSWFVersion pSWFVersion, ArrayList<PSWFProcRole> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSWFProcRole pSWFProcRole) throws Exception {
        PSWFLinkRoleService pSWFLinkRoleService = (PSWFLinkRoleService)ServiceGlobal.getService(PSWFLinkRoleService.class, (SessionFactory)this.getSessionFactory());
        pSWFLinkRoleService.testRemoveByPSWFProcRole(pSWFProcRole);
        pSWFLinkRoleService.removeByPSWFProcRole(pSWFProcRole);
        super.onBeforeRemove(pSWFProcRole);
    }

    protected void onBeforeRemoveTemp(PSWFProcRole pSWFProcRole) throws Exception {
        PSWFLinkRoleService pSWFLinkRoleService = (PSWFLinkRoleService)ServiceGlobal.getService(PSWFLinkRoleService.class, (SessionFactory)this.getSessionFactory());
        pSWFLinkRoleService.resetTempPSWFProcRole(pSWFProcRole);
        super.onBeforeRemoveTemp(pSWFProcRole);
    }

    public void removeTempByPSWFProcess(PSWFProcess pSWFProcess) throws Exception {
        final PSWFProcess pSWFProcess2 = pSWFProcess;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFProcRoleServiceBase.this.onBeforeRemoveTempByPSWFProcess(pSWFProcess2);
                PSWFProcRoleServiceBase.this.internalRemoveTempByPSWFProcess(pSWFProcess2);
                PSWFProcRoleServiceBase.this.onAfterRemoveTempByPSWFProcess(pSWFProcess2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSWFProcess(PSWFProcess pSWFProcess) throws Exception {
    }

    protected void internalRemoveTempByPSWFProcess(PSWFProcess pSWFProcess) throws Exception {
        ArrayList<PSWFProcRole> arrayList = this.selectTempByPSWFProcess(pSWFProcess);
        this.onBeforeRemoveTempByPSWFProcess(pSWFProcess, arrayList);
        for (PSWFProcRole pSWFProcRole : arrayList) {
            this.removeTemp(pSWFProcRole);
        }
        this.onAfterRemoveTempByPSWFProcess(pSWFProcess, arrayList);
    }

    protected void onAfterRemoveTempByPSWFProcess(PSWFProcess pSWFProcess) throws Exception {
    }

    protected void onBeforeRemoveTempByPSWFProcess(PSWFProcess pSWFProcess, ArrayList<PSWFProcRole> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSWFProcess(PSWFProcess pSWFProcess, ArrayList<PSWFProcRole> arrayList) throws Exception {
    }

    public void removeTempByPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
        final PSWFVersion pSWFVersion2 = pSWFVersion;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFProcRoleServiceBase.this.onBeforeRemoveTempByPSWFVersion(pSWFVersion2);
                PSWFProcRoleServiceBase.this.internalRemoveTempByPSWFVersion(pSWFVersion2);
                PSWFProcRoleServiceBase.this.onAfterRemoveTempByPSWFVersion(pSWFVersion2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
    }

    protected void internalRemoveTempByPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
        ArrayList<PSWFProcRole> arrayList = this.selectTempByPSWFVersion(pSWFVersion);
        this.onBeforeRemoveTempByPSWFVersion(pSWFVersion, arrayList);
        for (PSWFProcRole pSWFProcRole : arrayList) {
            this.removeTemp(pSWFProcRole);
        }
        this.onAfterRemoveTempByPSWFVersion(pSWFVersion, arrayList);
    }

    protected void onAfterRemoveTempByPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
    }

    protected void onBeforeRemoveTempByPSWFVersion(PSWFVersion pSWFVersion, ArrayList<PSWFProcRole> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSWFVersion(PSWFVersion pSWFVersion, ArrayList<PSWFProcRole> arrayList) throws Exception {
    }

    protected void getRelatedDataTempMajor(PSWFProcRole pSWFProcRole) throws Exception {
        super.getRelatedDataTempMajor(pSWFProcRole);
    }

    protected void updateRelatedDataTempMajor(PSWFProcRole pSWFProcRole, PSWFProcRole pSWFProcRole2) throws Exception {
        super.updateRelatedDataTempMajor(pSWFProcRole, pSWFProcRole2);
    }

    protected void replaceParentInfo(PSWFProcRole pSWFProcRole, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSWFProcRole, cloneSession);
        if (pSWFProcRole.getPSSysMsgTemplId() != null && (iEntity = cloneSession.getEntity("PSSYSMSGTEMPL", (Object)pSWFProcRole.getPSSysMsgTemplId())) != null) {
            this.onFillParentInfo_PSSysMsgTempl(pSWFProcRole, (PSSysMsgTempl)iEntity);
        }
        if (pSWFProcRole.getPSWFProcessId() != null && (iEntity = cloneSession.getEntity("PSWFPROCESS", (Object)pSWFProcRole.getPSWFProcessId())) != null) {
            this.onFillParentInfo_PSWFProcess(pSWFProcRole, (PSWFProcess)iEntity);
        }
        if (pSWFProcRole.getPSWFRoleId() != null && (iEntity = cloneSession.getEntity("PSWFROLE", (Object)pSWFProcRole.getPSWFRoleId())) != null) {
            this.onFillParentInfo_PSWFRole(pSWFProcRole, (PSWFRole)iEntity);
        }
        if (pSWFProcRole.getPSWFVersionId() != null && (iEntity = cloneSession.getEntity("PSWFVERSION", (Object)pSWFProcRole.getPSWFVersionId())) != null) {
            this.onFillParentInfo_PSWFVersion(pSWFProcRole, (PSWFVersion)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSWFProcRole pSWFProcRole, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSWFProcRole, bl);
    }

    protected void onCheckEntity(boolean bl, PSWFProcRole pSWFProcRole, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CCMode(bl, pSWFProcRole, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaModelFlag(bl, pSWFProcRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSWFProcRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, pSWFProcRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysMsgTemplId(bl, pSWFProcRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWFProcessId(bl, pSWFProcRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWFProcRoleId(bl, pSWFProcRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWFProcRoleName(bl, pSWFProcRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWFRoleId(bl, pSWFProcRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWFVersionId(bl, pSWFProcRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RoleType(bl, pSWFProcRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UDFields(bl, pSWFProcRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSWFProcRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserData(bl, pSWFProcRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserData2(bl, pSWFProcRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSWFProcRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSWFProcRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSWFProcRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSWFProcRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSWFProcRole, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CCMode(boolean bl, PSWFProcRole pSWFProcRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcRole.isCCModeDirty() : !pSWFProcRole.isCCModeDirty()) {
            return null;
        }
        Integer n = pSWFProcRole.getCCMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CCMode_Default(pSWFProcRole, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CCMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaModelFlag(boolean bl, PSWFProcRole pSWFProcRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcRole.isDynaModelFlagDirty() : !pSWFProcRole.isDynaModelFlagDirty()) {
            return null;
        }
        Integer n = pSWFProcRole.getDynaModelFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DynaModelFlag_Default(pSWFProcRole, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DYNAMODELFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSWFProcRole pSWFProcRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcRole.isMemoDirty() : !pSWFProcRole.isMemoDirty()) {
            return null;
        }
        String string = pSWFProcRole.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSWFProcRole, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, PSWFProcRole pSWFProcRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcRole.isPSDynaInstIdDirty() : !pSWFProcRole.isPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSWFProcRole.getPSDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default(pSWFProcRole, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysMsgTemplId(boolean bl, PSWFProcRole pSWFProcRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcRole.isPSSysMsgTemplIdDirty() : !pSWFProcRole.isPSSysMsgTemplIdDirty()) {
            return null;
        }
        String string = pSWFProcRole.getPSSysMsgTemplId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysMsgTemplId_Default(pSWFProcRole, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMSGTEMPLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWFProcessId(boolean bl, PSWFProcRole pSWFProcRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcRole.isPSWFProcessIdDirty() && !bl2 : !pSWFProcRole.isPSWFProcessIdDirty()) {
            return null;
        }
        String string = pSWFProcRole.getPSWFProcessId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFPROCESSID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWFProcessId_Default(pSWFProcRole, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFPROCESSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWFProcRoleId(boolean bl, PSWFProcRole pSWFProcRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcRole.isPSWFProcRoleIdDirty() && !bl2 : !pSWFProcRole.isPSWFProcRoleIdDirty()) {
            return null;
        }
        String string = pSWFProcRole.getPSWFProcRoleId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFPROCROLEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWFProcRoleId_Default(pSWFProcRole, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFPROCROLEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWFProcRoleName(boolean bl, PSWFProcRole pSWFProcRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcRole.isPSWFProcRoleNameDirty() && !bl2 : !pSWFProcRole.isPSWFProcRoleNameDirty()) {
            return null;
        }
        String string = pSWFProcRole.getPSWFProcRoleName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFPROCROLENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWFProcRoleName_Default(pSWFProcRole, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFPROCROLENAME");
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
                string3 = "PSWFPROCESSID";
                String string4 = this.checkFieldDupRule(this.getPSWFProcRoleDEModel(), "PSWFPROCROLENAME", string3, pSWFProcRole, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSWFPROCROLENAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWFRoleId(boolean bl, PSWFProcRole pSWFProcRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcRole.isPSWFRoleIdDirty() : !pSWFProcRole.isPSWFRoleIdDirty()) {
            return null;
        }
        String string = pSWFProcRole.getPSWFRoleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWFRoleId_Default(pSWFProcRole, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFROLEID");
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
                string3 = "PSWFPROCESSID";
                String string4 = this.checkFieldDupRule(this.getPSWFProcRoleDEModel(), "PSWFROLEID", string3, pSWFProcRole, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSWFROLEID");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWFVersionId(boolean bl, PSWFProcRole pSWFProcRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcRole.isPSWFVersionIdDirty() : !pSWFProcRole.isPSWFVersionIdDirty()) {
            return null;
        }
        String string = pSWFProcRole.getPSWFVersionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWFVersionId_Default(pSWFProcRole, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFVERSIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RoleType(boolean bl, PSWFProcRole pSWFProcRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcRole.isRoleTypeDirty() && !bl2 : !pSWFProcRole.isRoleTypeDirty()) {
            return null;
        }
        String string = pSWFProcRole.getRoleType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ROLETYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_RoleType_Default(pSWFProcRole, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ROLETYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            bl4 = DataTypeHelper.compare((int)25, (Object)string, (Object)"LASTTWOSTEPACTOR") == 0L || DataTypeHelper.compare((int)25, (Object)string, (Object)"LASTTHREESTEPACTOR") == 0L || DataTypeHelper.compare((int)25, (Object)string, (Object)"LASTSTEPACTOR") == 0L || DataTypeHelper.compare((int)25, (Object)string, (Object)"UDACTOR") == 0L || DataTypeHelper.compare((int)25, (Object)string, (Object)"CURACTOR") == 0L;
            if (bl4) {
                String string3 = "";
                string3 = "PSWFPROCESSID";
                String string4 = this.checkFieldDupRule(this.getPSWFProcRoleDEModel(), "ROLETYPE", string3, pSWFProcRole, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("ROLETYPE");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UDFields(boolean bl, PSWFProcRole pSWFProcRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcRole.isUDFieldsDirty() : !pSWFProcRole.isUDFieldsDirty()) {
            return null;
        }
        String string = pSWFProcRole.getUDFields();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UDFields_Default(pSWFProcRole, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UDFIELDS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSWFProcRole pSWFProcRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcRole.isUserCatDirty() : !pSWFProcRole.isUserCatDirty()) {
            return null;
        }
        String string = pSWFProcRole.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSWFProcRole, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserData(boolean bl, PSWFProcRole pSWFProcRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcRole.isUserDataDirty() : !pSWFProcRole.isUserDataDirty()) {
            return null;
        }
        String string = pSWFProcRole.getUserData();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserData_Default(pSWFProcRole, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERDATA");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserData2(boolean bl, PSWFProcRole pSWFProcRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcRole.isUserData2Dirty() : !pSWFProcRole.isUserData2Dirty()) {
            return null;
        }
        String string = pSWFProcRole.getUserData2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserData2_Default(pSWFProcRole, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERDATA2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSWFProcRole pSWFProcRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcRole.isUserTagDirty() : !pSWFProcRole.isUserTagDirty()) {
            return null;
        }
        String string = pSWFProcRole.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSWFProcRole, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSWFProcRole pSWFProcRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcRole.isUserTag2Dirty() : !pSWFProcRole.isUserTag2Dirty()) {
            return null;
        }
        String string = pSWFProcRole.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSWFProcRole, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSWFProcRole pSWFProcRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcRole.isUserTag3Dirty() : !pSWFProcRole.isUserTag3Dirty()) {
            return null;
        }
        String string = pSWFProcRole.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSWFProcRole, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSWFProcRole pSWFProcRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcRole.isUserTag4Dirty() : !pSWFProcRole.isUserTag4Dirty()) {
            return null;
        }
        String string = pSWFProcRole.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSWFProcRole, bl2, bl3);
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

    protected void onSyncEntity(PSWFProcRole pSWFProcRole, boolean bl) throws Exception {
        super.onSyncEntity(pSWFProcRole, bl);
    }

    protected void onSyncIndexEntities(PSWFProcRole pSWFProcRole, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSWFProcRole, bl);
    }

    public Object getDataContextValue(PSWFProcRole pSWFProcRole, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSWFProcRole, string, iDataContextParam)) != null) {
            return object;
        }
        PSWFProcess pSWFProcess = pSWFProcRole.getPSWFProcess();
        if (pSWFProcess != null && pSWFProcess.contains(string)) {
            return pSWFProcess.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSWFProcRole pSWFProcRole, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSWFProcRole, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CCMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CCMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAMODELFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaModelFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMSGTEMPLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysMsgTemplId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMSGTEMPLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysMsgTemplName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFID_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFPROCESSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFProcessId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFPROCESSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFProcessName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFPROCROLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFProcRoleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFPROCROLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFProcRoleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFROLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFRoleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFROLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFRoleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFVERSIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFVersionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFVERSIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFVersionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ROLETYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RoleType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UDFIELDS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UDFields_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"USERDATA", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserData_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERDATA2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserData2_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_CCMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_DynaModelFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_PSDynaInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNAINSTID", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysMsgTemplId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMSGTEMPLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysMsgTemplName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMSGTEMPLNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSWFID_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWFProcessId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFPROCESSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWFProcessName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFPROCESSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWFProcRoleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFPROCROLEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWFProcRoleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFPROCROLENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWFRoleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFROLEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWFRoleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFROLENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWFVersionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFVERSIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWFVersionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFVERSIONNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RoleType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ROLETYPE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UDFields_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UDFIELDS", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
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

    protected String onTestValueRule_UserData_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERDATA", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserData2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERDATA2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSWFProcRole pSWFProcRole) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSWFProcRole)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSWFProcRole pSWFProcRole) throws Exception {
        super.onUpdateParent(pSWFProcRole);
    }

    @Override
    protected void exportCurXmlModel(PSWFProcRole pSWFProcRole, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSWFPROCROLE");
        if (!bl) {
            pSWFProcRole.setPSWFVersionName(null);
            pSWFProcRole.setPSSystemId(null);
            pSWFProcRole.setPSWFProcessId(null);
            pSWFProcRole.setPSWFProcessName(null);
            pSWFProcRole.setPSWFID(null);
            pSWFProcRole.setPSWFVersionId(null);
            pSWFProcRole.setPSWFVersionName(null);
            super.exportCurXmlModel(pSWFProcRole, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSWFProcRole pSWFProcRole, XmlNode xmlNode) throws Exception {
        super.onExportRelatedXmlModel(pSWFProcRole, xmlNode);
    }

    @Override
    protected void onImportRelatedXmlModel(PSWFProcRole pSWFProcRole, XmlNode xmlNode) throws Exception {
        super.onImportRelatedXmlModel(pSWFProcRole, xmlNode);
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSWFProcRole pSWFProcRole, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSWFProcRole, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSWFPROCESSID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSWFPROCESS#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSWFPROCESSID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSWFPROCROLE_PSWFPROCESS_PSWFPROCESSID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSWFPROCESSID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSWFPROCESSNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSWFPROCESS", (boolean)true) == 0) {
            iEntity.set("PSWFPROCESSID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSWFPROCESSID"};
    }

    @Override
    public String getModelV2Tag(PSWFProcRole pSWFProcRole) {
        if (!StringHelper.isNullOrEmpty((String)pSWFProcRole.getPSWFProcRoleName())) {
            return pSWFProcRole.getPSWFProcRoleName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSWFProcRole.getPSWFProcRoleName())) {
            return pSWFProcRole.getPSWFProcRoleName();
        }
        return super.getModelV2Tag(pSWFProcRole);
    }

    @Override
    public boolean setModelV2Tag(PSWFProcRole pSWFProcRole, String string) {
        pSWFProcRole.setPSWFProcRoleName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSWFPROCROLENAME", "");
        map.put("PSWFPROCROLENAME", "");
        map.put("PSWFPROCESSID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSWFProcRole pSWFProcRole, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSWFProcRole.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSWFProcRole, true);
        pSWFProcRole.set("PSWFPROCROLENAME", string);
        if (this.select(pSWFProcRole, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSWFProcRole, true);
        return super.getModelV2Entity(pSWFProcRole, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSWFProcRole pSWFProcRole, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSWFProcRole, objectNode, string, string2, n);
    }
}

