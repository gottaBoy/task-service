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
import net.ibizsys.pscore.srv.wfdesign.dao.PSWFLinkRoleDAO;
import net.ibizsys.pscore.srv.wfdesign.demodel.PSWFLinkRoleDEModel;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFLink;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFLinkBase;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFLinkRole;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFProcRole;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFProcRoleBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSWFLinkRoleServiceBase
extends PSCoreSysServiceBase<PSWFLinkRole> {
    private static final Log log = LogFactory.getLog(PSWFLinkRoleServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSWFLinkRoleDEModel pSWFLinkRoleDEModel;
    private PSWFLinkRoleDAO pSWFLinkRoleDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.wfdesign.service.PSWFLinkRoleService";
    }

    public PSWFLinkRoleDEModel getPSWFLinkRoleDEModel() {
        if (this.pSWFLinkRoleDEModel == null) {
            try {
                this.pSWFLinkRoleDEModel = (PSWFLinkRoleDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.wfdesign.demodel.PSWFLinkRoleDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWFLinkRoleDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSWFLinkRoleDEModel();
    }

    public PSWFLinkRoleDAO getPSWFLinkRoleDAO() {
        if (this.pSWFLinkRoleDAO == null) {
            try {
                this.pSWFLinkRoleDAO = (PSWFLinkRoleDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.wfdesign.dao.PSWFLinkRoleDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWFLinkRoleDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSWFLinkRoleDAO();
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

    protected void onFillParentInfo(PSWFLinkRole pSWFLinkRole, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFLINKROLE_PSSYSMSGTEMPL_PSSYSMSGTEMPLID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysMsgTemplService", (SessionFactory)this.getSessionFactory());
            PSSysMsgTempl pSSysMsgTempl = (PSSysMsgTempl)iService.getDEModel().createEntity();
            pSSysMsgTempl.set("PSSYSMSGTEMPLID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysMsgTempl);
            } else {
                iService.get(pSSysMsgTempl);
            }
            this.onFillParentInfo_PSSysMsgTempl(pSWFLinkRole, pSSysMsgTempl);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFLINKROLE_PSWFLINK_PSWFLINKID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWFLinkService", (SessionFactory)this.getSessionFactory());
            PSWFLink pSWFLink = (PSWFLink)iService.getDEModel().createEntity();
            pSWFLink.set("PSWFLINKID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSWFLink);
            } else {
                iService.get(pSWFLink);
            }
            this.onFillParentInfo_PSWFLink(pSWFLinkRole, pSWFLink);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFLINKROLE_PSWFPROCROLE_PSWFPROCROLEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWFProcRoleService", (SessionFactory)this.getSessionFactory());
            PSWFProcRole pSWFProcRole = (PSWFProcRole)iService.getDEModel().createEntity();
            pSWFProcRole.set("PSWFPROCROLEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSWFProcRole);
            } else {
                iService.get(pSWFProcRole);
            }
            this.onFillParentInfo_PSWFProcRole(pSWFLinkRole, pSWFProcRole);
            return;
        }
        super.onFillParentInfo(pSWFLinkRole, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        if (StringHelper.compare((String)string, (String)"DER1N_PSWFLINKROLE_PSWFLINK_PSWFLINKID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWFLinkService", (SessionFactory)this.getSessionFactory());
            PSWFLink pSWFLink = (PSWFLink)iService.getDEModel().createEntity();
            pSWFLink.set("PSWFLINKID", string2);
            return this.onSyncDER1NData_PSWFLink(pSWFLink, string3);
        }
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSysMsgTempl(PSWFLinkRole pSWFLinkRole, PSSysMsgTempl pSSysMsgTempl) throws Exception {
        pSWFLinkRole.setPSSysMsgTemplId(pSSysMsgTempl.getPSSysMsgTemplId());
        pSWFLinkRole.setPSSysMsgTemplName(pSSysMsgTempl.getPSSysMsgTemplName());
    }

    protected void onFillParentInfo_PSWFLink(PSWFLinkRole pSWFLinkRole, PSWFLink pSWFLink) throws Exception {
        pSWFLinkRole.setPSWFLinkId(pSWFLink.getPSWFLinkId());
        pSWFLinkRole.setPSWFLinkName(pSWFLink.getPSWFLinkName());
        pSWFLinkRole.setPSWFProcessId(pSWFLink.getFromPSWFProcId());
        pSWFLinkRole.setPSWFVersionId(pSWFLink.getPSWFVersionId());
    }

    protected String onSyncDER1NData_PSWFLink(PSWFLink pSWFLink, String string) throws Exception {
        if (StringHelper.isNullOrEmpty((String)string)) {
            this.removeByPSWFLink(pSWFLink);
        } else {
            HashMap<String, String> hashMap = new HashMap<String, String>();
            String[] stringArray = StringHelper.splitEx((String)string);
            if (stringArray != null) {
                for (int i = 0; i < stringArray.length; ++i) {
                    if (StringHelper.isNullOrEmpty((String)stringArray[i])) continue;
                    hashMap.put(stringArray[i], "");
                }
            }
            ArrayList<PSWFLinkRole> arrayList = this.selectByPSWFLink(pSWFLink);
            for (PSWFLinkRole pSWFLinkRole : arrayList) {
                if (hashMap.containsKey(DataObject.getStringValue((IDataObject)pSWFLinkRole, (String)"PSWFLINKROLEID", (String)""))) continue;
                this.remove(pSWFLinkRole);
            }
        }
        return null;
    }

    protected void onFillParentInfo_PSWFProcRole(PSWFLinkRole pSWFLinkRole, PSWFProcRole pSWFProcRole) throws Exception {
        pSWFLinkRole.setPSWFProcRoleId(pSWFProcRole.getPSWFProcRoleId());
        pSWFLinkRole.setPSWFProcRoleName(pSWFProcRole.getPSWFProcRoleName());
    }

    protected void onFillEntityFullInfo(PSWFLinkRole pSWFLinkRole, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSWFLinkRole, bl);
        this.onFillEntityFullInfo_PSSysMsgTempl(pSWFLinkRole, bl);
        this.onFillEntityFullInfo_PSWFLink(pSWFLinkRole, bl);
        this.onFillEntityFullInfo_PSWFProcRole(pSWFLinkRole, bl);
    }

    protected void onFillEntityFullInfo_PSSysMsgTempl(PSWFLinkRole pSWFLinkRole, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSWFLink(PSWFLinkRole pSWFLinkRole, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSWFProcRole(PSWFLinkRole pSWFLinkRole, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSWFLinkRole pSWFLinkRole, boolean bl) throws Exception {
        super.onWriteBackParent(pSWFLinkRole, bl);
    }

    public ArrayList<PSWFLinkRole> selectByPSSysMsgTempl(PSSysMsgTemplBase pSSysMsgTemplBase) throws Exception {
        return this.selectByPSSysMsgTempl(pSSysMsgTemplBase, "", -1);
    }

    public ArrayList<PSWFLinkRole> selectByPSSysMsgTempl(PSSysMsgTemplBase pSSysMsgTemplBase, String string) throws Exception {
        return this.selectByPSSysMsgTempl(pSSysMsgTemplBase, string, -1);
    }

    public ArrayList<PSWFLinkRole> selectByPSSysMsgTempl(PSSysMsgTemplBase pSSysMsgTemplBase, String string, int n) throws Exception {
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

    public ArrayList<PSWFLinkRole> selectByPSWFLink(PSWFLinkBase pSWFLinkBase) throws Exception {
        return this.selectByPSWFLink(pSWFLinkBase, "", -1);
    }

    public ArrayList<PSWFLinkRole> selectByPSWFLink(PSWFLinkBase pSWFLinkBase, String string) throws Exception {
        return this.selectByPSWFLink(pSWFLinkBase, string, -1);
    }

    public ArrayList<PSWFLinkRole> selectByPSWFLink(PSWFLinkBase pSWFLinkBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSWFLINKID", (Object)pSWFLinkBase.getPSWFLinkId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSWFLinkCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSWFLinkCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFLinkRole> selectTempByPSWFLink(PSWFLinkBase pSWFLinkBase) throws Exception {
        return this.selectTempByPSWFLink(pSWFLinkBase, "");
    }

    public ArrayList<PSWFLinkRole> selectTempByPSWFLink(PSWFLinkBase pSWFLinkBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSWFLINKID", (Object)pSWFLinkBase.getPSWFLinkId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSWFLinkCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSWFLinkCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFLinkRole> selectByPSWFProcRole(PSWFProcRoleBase pSWFProcRoleBase) throws Exception {
        return this.selectByPSWFProcRole(pSWFProcRoleBase, "", -1);
    }

    public ArrayList<PSWFLinkRole> selectByPSWFProcRole(PSWFProcRoleBase pSWFProcRoleBase, String string) throws Exception {
        return this.selectByPSWFProcRole(pSWFProcRoleBase, string, -1);
    }

    public ArrayList<PSWFLinkRole> selectByPSWFProcRole(PSWFProcRoleBase pSWFProcRoleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSWFPROCROLEID", (Object)pSWFProcRoleBase.getPSWFProcRoleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSWFProcRoleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSWFProcRoleCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFLinkRole> selectTempByPSWFProcRole(PSWFProcRoleBase pSWFProcRoleBase) throws Exception {
        return this.selectTempByPSWFProcRole(pSWFProcRoleBase, "");
    }

    public ArrayList<PSWFLinkRole> selectTempByPSWFProcRole(PSWFProcRoleBase pSWFProcRoleBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSWFPROCROLEID", (Object)pSWFProcRoleBase.getPSWFProcRoleId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSWFProcRoleCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSWFProcRoleCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl) throws Exception {
        ArrayList<PSWFLinkRole> arrayList = this.selectByPSSysMsgTempl(pSSysMsgTempl, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSMSGTEMPL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysMsgTempl);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFLINKROLE_PSSYSMSGTEMPL_PSSYSMSGTEMPLID", "", iDataEntityModel.getName(), "PSWFLINKROLE", iDataEntityModel.getDataInfo(pSSysMsgTempl), arrayList.get(0)));
        }
    }

    public void resetPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl) throws Exception {
        ArrayList<PSWFLinkRole> arrayList = this.selectByPSSysMsgTempl(pSSysMsgTempl);
        for (PSWFLinkRole pSWFLinkRole : arrayList) {
            PSWFLinkRole pSWFLinkRole2 = (PSWFLinkRole)this.getDEModel().createEntity();
            pSWFLinkRole2.setPSWFLinkRoleId(pSWFLinkRole.getPSWFLinkRoleId());
            pSWFLinkRole2.setPSSysMsgTemplId(null);
            this.update(pSWFLinkRole2);
        }
    }

    public void removeByPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl) throws Exception {
        final PSSysMsgTempl pSSysMsgTempl2 = pSSysMsgTempl;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFLinkRoleServiceBase.this.onBeforeRemoveByPSSysMsgTempl(pSSysMsgTempl2);
                PSWFLinkRoleServiceBase.this.internalRemoveByPSSysMsgTempl(pSSysMsgTempl2);
                PSWFLinkRoleServiceBase.this.onAfterRemoveByPSSysMsgTempl(pSSysMsgTempl2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl) throws Exception {
    }

    protected void internalRemoveByPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl) throws Exception {
        ArrayList<PSWFLinkRole> arrayList = this.selectByPSSysMsgTempl(pSSysMsgTempl);
        this.onBeforeRemoveByPSSysMsgTempl(pSSysMsgTempl, arrayList);
        for (PSWFLinkRole pSWFLinkRole : arrayList) {
            this.remove(pSWFLinkRole);
        }
        this.onAfterRemoveByPSSysMsgTempl(pSSysMsgTempl, arrayList);
    }

    protected void onAfterRemoveByPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl) throws Exception {
    }

    protected void onBeforeRemoveByPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl, ArrayList<PSWFLinkRole> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl, ArrayList<PSWFLinkRole> arrayList) throws Exception {
    }

    public void testRemoveByPSWFLink(PSWFLink pSWFLink) throws Exception {
    }

    public void resetPSWFLink(PSWFLink pSWFLink) throws Exception {
        ArrayList<PSWFLinkRole> arrayList = this.selectByPSWFLink(pSWFLink);
        for (PSWFLinkRole pSWFLinkRole : arrayList) {
            PSWFLinkRole pSWFLinkRole2 = (PSWFLinkRole)this.getDEModel().createEntity();
            pSWFLinkRole2.setPSWFLinkRoleId(pSWFLinkRole.getPSWFLinkRoleId());
            pSWFLinkRole2.setPSWFLinkId(null);
            this.update(pSWFLinkRole2);
        }
    }

    public void resetTempPSWFLink(PSWFLink pSWFLink) throws Exception {
        ArrayList<PSWFLinkRole> arrayList = this.selectTempByPSWFLink(pSWFLink);
        for (PSWFLinkRole pSWFLinkRole : arrayList) {
            PSWFLinkRole pSWFLinkRole2 = (PSWFLinkRole)this.getDEModel().createEntity();
            pSWFLinkRole2.setPSWFLinkRoleId(pSWFLinkRole.getPSWFLinkRoleId());
            pSWFLinkRole2.setPSWFLinkId(null);
            this.updateTemp(pSWFLinkRole2);
        }
    }

    public void removeByPSWFLink(PSWFLink pSWFLink) throws Exception {
        final PSWFLink pSWFLink2 = pSWFLink;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFLinkRoleServiceBase.this.onBeforeRemoveByPSWFLink(pSWFLink2);
                PSWFLinkRoleServiceBase.this.internalRemoveByPSWFLink(pSWFLink2);
                PSWFLinkRoleServiceBase.this.onAfterRemoveByPSWFLink(pSWFLink2);
            }
        });
    }

    protected void onBeforeRemoveByPSWFLink(PSWFLink pSWFLink) throws Exception {
    }

    protected void internalRemoveByPSWFLink(PSWFLink pSWFLink) throws Exception {
        ArrayList<PSWFLinkRole> arrayList = this.selectByPSWFLink(pSWFLink);
        this.onBeforeRemoveByPSWFLink(pSWFLink, arrayList);
        for (PSWFLinkRole pSWFLinkRole : arrayList) {
            this.remove(pSWFLinkRole);
        }
        this.onAfterRemoveByPSWFLink(pSWFLink, arrayList);
    }

    protected void onAfterRemoveByPSWFLink(PSWFLink pSWFLink) throws Exception {
    }

    protected void onBeforeRemoveByPSWFLink(PSWFLink pSWFLink, ArrayList<PSWFLinkRole> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSWFLink(PSWFLink pSWFLink, ArrayList<PSWFLinkRole> arrayList) throws Exception {
    }

    public void testRemoveByPSWFProcRole(PSWFProcRole pSWFProcRole) throws Exception {
    }

    public void resetPSWFProcRole(PSWFProcRole pSWFProcRole) throws Exception {
        ArrayList<PSWFLinkRole> arrayList = this.selectByPSWFProcRole(pSWFProcRole);
        for (PSWFLinkRole pSWFLinkRole : arrayList) {
            PSWFLinkRole pSWFLinkRole2 = (PSWFLinkRole)this.getDEModel().createEntity();
            pSWFLinkRole2.setPSWFLinkRoleId(pSWFLinkRole.getPSWFLinkRoleId());
            pSWFLinkRole2.setPSWFProcRoleId(null);
            this.update(pSWFLinkRole2);
        }
    }

    public void resetTempPSWFProcRole(PSWFProcRole pSWFProcRole) throws Exception {
        ArrayList<PSWFLinkRole> arrayList = this.selectTempByPSWFProcRole(pSWFProcRole);
        for (PSWFLinkRole pSWFLinkRole : arrayList) {
            PSWFLinkRole pSWFLinkRole2 = (PSWFLinkRole)this.getDEModel().createEntity();
            pSWFLinkRole2.setPSWFLinkRoleId(pSWFLinkRole.getPSWFLinkRoleId());
            pSWFLinkRole2.setPSWFProcRoleId(null);
            this.updateTemp(pSWFLinkRole2);
        }
    }

    public void removeByPSWFProcRole(PSWFProcRole pSWFProcRole) throws Exception {
        final PSWFProcRole pSWFProcRole2 = pSWFProcRole;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFLinkRoleServiceBase.this.onBeforeRemoveByPSWFProcRole(pSWFProcRole2);
                PSWFLinkRoleServiceBase.this.internalRemoveByPSWFProcRole(pSWFProcRole2);
                PSWFLinkRoleServiceBase.this.onAfterRemoveByPSWFProcRole(pSWFProcRole2);
            }
        });
    }

    protected void onBeforeRemoveByPSWFProcRole(PSWFProcRole pSWFProcRole) throws Exception {
    }

    protected void internalRemoveByPSWFProcRole(PSWFProcRole pSWFProcRole) throws Exception {
        ArrayList<PSWFLinkRole> arrayList = this.selectByPSWFProcRole(pSWFProcRole);
        this.onBeforeRemoveByPSWFProcRole(pSWFProcRole, arrayList);
        for (PSWFLinkRole pSWFLinkRole : arrayList) {
            this.remove(pSWFLinkRole);
        }
        this.onAfterRemoveByPSWFProcRole(pSWFProcRole, arrayList);
    }

    protected void onAfterRemoveByPSWFProcRole(PSWFProcRole pSWFProcRole) throws Exception {
    }

    protected void onBeforeRemoveByPSWFProcRole(PSWFProcRole pSWFProcRole, ArrayList<PSWFLinkRole> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSWFProcRole(PSWFProcRole pSWFProcRole, ArrayList<PSWFLinkRole> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSWFLinkRole pSWFLinkRole) throws Exception {
        super.onBeforeRemove(pSWFLinkRole);
    }

    public void removeTempByPSWFProcRole(PSWFProcRole pSWFProcRole) throws Exception {
        final PSWFProcRole pSWFProcRole2 = pSWFProcRole;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFLinkRoleServiceBase.this.onBeforeRemoveTempByPSWFProcRole(pSWFProcRole2);
                PSWFLinkRoleServiceBase.this.internalRemoveTempByPSWFProcRole(pSWFProcRole2);
                PSWFLinkRoleServiceBase.this.onAfterRemoveTempByPSWFProcRole(pSWFProcRole2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSWFProcRole(PSWFProcRole pSWFProcRole) throws Exception {
    }

    protected void internalRemoveTempByPSWFProcRole(PSWFProcRole pSWFProcRole) throws Exception {
        ArrayList<PSWFLinkRole> arrayList = this.selectTempByPSWFProcRole(pSWFProcRole);
        this.onBeforeRemoveTempByPSWFProcRole(pSWFProcRole, arrayList);
        for (PSWFLinkRole pSWFLinkRole : arrayList) {
            this.removeTemp(pSWFLinkRole);
        }
        this.onAfterRemoveTempByPSWFProcRole(pSWFProcRole, arrayList);
    }

    protected void onAfterRemoveTempByPSWFProcRole(PSWFProcRole pSWFProcRole) throws Exception {
    }

    protected void onBeforeRemoveTempByPSWFProcRole(PSWFProcRole pSWFProcRole, ArrayList<PSWFLinkRole> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSWFProcRole(PSWFProcRole pSWFProcRole, ArrayList<PSWFLinkRole> arrayList) throws Exception {
    }

    public void removeTempByPSWFLink(PSWFLink pSWFLink) throws Exception {
        final PSWFLink pSWFLink2 = pSWFLink;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFLinkRoleServiceBase.this.onBeforeRemoveTempByPSWFLink(pSWFLink2);
                PSWFLinkRoleServiceBase.this.internalRemoveTempByPSWFLink(pSWFLink2);
                PSWFLinkRoleServiceBase.this.onAfterRemoveTempByPSWFLink(pSWFLink2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSWFLink(PSWFLink pSWFLink) throws Exception {
    }

    protected void internalRemoveTempByPSWFLink(PSWFLink pSWFLink) throws Exception {
        ArrayList<PSWFLinkRole> arrayList = this.selectTempByPSWFLink(pSWFLink);
        this.onBeforeRemoveTempByPSWFLink(pSWFLink, arrayList);
        for (PSWFLinkRole pSWFLinkRole : arrayList) {
            this.removeTemp(pSWFLinkRole);
        }
        this.onAfterRemoveTempByPSWFLink(pSWFLink, arrayList);
    }

    protected void onAfterRemoveTempByPSWFLink(PSWFLink pSWFLink) throws Exception {
    }

    protected void onBeforeRemoveTempByPSWFLink(PSWFLink pSWFLink, ArrayList<PSWFLinkRole> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSWFLink(PSWFLink pSWFLink, ArrayList<PSWFLinkRole> arrayList) throws Exception {
    }

    protected void replaceParentInfo(PSWFLinkRole pSWFLinkRole, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSWFLinkRole, cloneSession);
        if (pSWFLinkRole.getPSSysMsgTemplId() != null && (iEntity = cloneSession.getEntity("PSSYSMSGTEMPL", (Object)pSWFLinkRole.getPSSysMsgTemplId())) != null) {
            this.onFillParentInfo_PSSysMsgTempl(pSWFLinkRole, (PSSysMsgTempl)iEntity);
        }
        if (pSWFLinkRole.getPSWFLinkId() != null && (iEntity = cloneSession.getEntity("PSWFLINK", (Object)pSWFLinkRole.getPSWFLinkId())) != null) {
            this.onFillParentInfo_PSWFLink(pSWFLinkRole, (PSWFLink)iEntity);
        }
        if (pSWFLinkRole.getPSWFProcRoleId() != null && (iEntity = cloneSession.getEntity("PSWFPROCROLE", (Object)pSWFLinkRole.getPSWFProcRoleId())) != null) {
            this.onFillParentInfo_PSWFProcRole(pSWFLinkRole, (PSWFProcRole)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSWFLinkRole pSWFLinkRole, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSWFLinkRole, bl);
    }

    protected void onCheckEntity(boolean bl, PSWFLinkRole pSWFLinkRole, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_DynaModelFlag(bl, pSWFLinkRole, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSWFLinkRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, pSWFLinkRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysMsgTemplId(bl, pSWFLinkRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWFLinkId(bl, pSWFLinkRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWFLinkRoleId(bl, pSWFLinkRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWFLinkRoleName(bl, pSWFLinkRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWFProcRoleId(bl, pSWFLinkRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSWFLinkRole, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_DynaModelFlag(boolean bl, PSWFLinkRole pSWFLinkRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLinkRole.isDynaModelFlagDirty() : !pSWFLinkRole.isDynaModelFlagDirty()) {
            return null;
        }
        Integer n = pSWFLinkRole.getDynaModelFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DynaModelFlag_Default(pSWFLinkRole, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSWFLinkRole pSWFLinkRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLinkRole.isMemoDirty() : !pSWFLinkRole.isMemoDirty()) {
            return null;
        }
        String string = pSWFLinkRole.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSWFLinkRole, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, PSWFLinkRole pSWFLinkRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLinkRole.isPSDynaInstIdDirty() : !pSWFLinkRole.isPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSWFLinkRole.getPSDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default(pSWFLinkRole, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysMsgTemplId(boolean bl, PSWFLinkRole pSWFLinkRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLinkRole.isPSSysMsgTemplIdDirty() : !pSWFLinkRole.isPSSysMsgTemplIdDirty()) {
            return null;
        }
        String string = pSWFLinkRole.getPSSysMsgTemplId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysMsgTemplId_Default(pSWFLinkRole, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSWFLinkId(boolean bl, PSWFLinkRole pSWFLinkRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLinkRole.isPSWFLinkIdDirty() : !pSWFLinkRole.isPSWFLinkIdDirty()) {
            return null;
        }
        String string = pSWFLinkRole.getPSWFLinkId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWFLinkId_Default(pSWFLinkRole, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFLINKID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWFLinkRoleId(boolean bl, PSWFLinkRole pSWFLinkRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLinkRole.isPSWFLinkRoleIdDirty() && !bl2 : !pSWFLinkRole.isPSWFLinkRoleIdDirty()) {
            return null;
        }
        String string = pSWFLinkRole.getPSWFLinkRoleId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFLINKROLEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWFLinkRoleId_Default(pSWFLinkRole, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFLINKROLEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWFLinkRoleName(boolean bl, PSWFLinkRole pSWFLinkRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLinkRole.isPSWFLinkRoleNameDirty() : !pSWFLinkRole.isPSWFLinkRoleNameDirty()) {
            return null;
        }
        String string = pSWFLinkRole.getPSWFLinkRoleName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWFLinkRoleName_Default(pSWFLinkRole, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFLINKROLENAME");
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
                string3 = "PSWFLINKID";
                String string4 = this.checkFieldDupRule(this.getPSWFLinkRoleDEModel(), "PSWFLINKROLENAME", string3, pSWFLinkRole, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSWFLINKROLENAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWFProcRoleId(boolean bl, PSWFLinkRole pSWFLinkRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLinkRole.isPSWFProcRoleIdDirty() : !pSWFLinkRole.isPSWFProcRoleIdDirty()) {
            return null;
        }
        String string = pSWFLinkRole.getPSWFProcRoleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWFProcRoleId_Default(pSWFLinkRole, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFPROCROLEID");
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
                string3 = "PSWFLINKID";
                String string4 = this.checkFieldDupRule(this.getPSWFLinkRoleDEModel(), "PSWFPROCROLEID", string3, pSWFLinkRole, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSWFPROCROLEID");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected void onSyncEntity(PSWFLinkRole pSWFLinkRole, boolean bl) throws Exception {
        super.onSyncEntity(pSWFLinkRole, bl);
    }

    protected void onSyncIndexEntities(PSWFLinkRole pSWFLinkRole, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSWFLinkRole, bl);
    }

    public Object getDataContextValue(PSWFLinkRole pSWFLinkRole, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSWFLinkRole, string, iDataContextParam)) != null) {
            return object;
        }
        PSWFLink pSWFLink = pSWFLinkRole.getPSWFLink();
        if (pSWFLink != null && pSWFLink.contains(string)) {
            return pSWFLink.get(string);
        }
        PSWFProcRole pSWFProcRole = pSWFLinkRole.getPSWFProcRole();
        if (pSWFProcRole != null && pSWFProcRole.contains(string)) {
            return pSWFProcRole.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSWFLinkRole pSWFLinkRole, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSWFLinkRole, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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
        if (StringHelper.compare((String)string, (String)"PSWFLINKID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFLinkId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFLINKNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFLinkName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFLINKROLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFLinkRoleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFLINKROLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFLinkRoleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFPROCESSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFProcessId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFPROCROLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFProcRoleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFPROCROLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFProcRoleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFVERSIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFVersionId_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSWFLinkId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFLINKID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWFLinkName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFLINKNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWFLinkRoleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFLINKROLEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWFLinkRoleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFLINKROLENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSWFLinkRole pSWFLinkRole) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSWFLinkRole)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSWFLinkRole pSWFLinkRole) throws Exception {
        super.onUpdateParent(pSWFLinkRole);
    }

    @Override
    protected void exportCurXmlModel(PSWFLinkRole pSWFLinkRole, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSWFLINKROLE");
        if (!bl) {
            pSWFLinkRole.setPSWFProcRoleId(null);
            pSWFLinkRole.setPSWFLinkId(null);
            pSWFLinkRole.setPSWFLinkName(null);
            pSWFLinkRole.setPSWFProcessId(null);
            pSWFLinkRole.setPSWFVersionId(null);
            super.exportCurXmlModel(pSWFLinkRole, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSWFLinkRole pSWFLinkRole, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSWFLinkRole, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSWFLINKID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSWFLINK#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSWFLINKID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSWFLINKROLE_PSWFLINK_PSWFLINKID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSWFLINKID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSWFLINKNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSWFLINK", (boolean)true) == 0) {
            iEntity.set("PSWFLINKID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSWFLINKID"};
    }

    @Override
    public String getModelV2Tag(PSWFLinkRole pSWFLinkRole) {
        if (!StringHelper.isNullOrEmpty((String)pSWFLinkRole.getPSWFLinkRoleName())) {
            return pSWFLinkRole.getPSWFLinkRoleName();
        }
        return super.getModelV2Tag(pSWFLinkRole);
    }

    @Override
    public boolean setModelV2Tag(PSWFLinkRole pSWFLinkRole, String string) {
        pSWFLinkRole.setPSWFLinkRoleName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSWFLINKROLENAME", "");
        map.put("PSWFLINKID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSWFLinkRole pSWFLinkRole, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSWFLinkRole.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSWFLinkRole, true);
        pSWFLinkRole.set("PSWFLINKROLENAME", string);
        if (this.select(pSWFLinkRole, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSWFLinkRole, true);
        return super.getModelV2Entity(pSWFLinkRole, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSWFLinkRole pSWFLinkRole, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSWFLinkRole, objectNode, string, string2, n);
    }
}

