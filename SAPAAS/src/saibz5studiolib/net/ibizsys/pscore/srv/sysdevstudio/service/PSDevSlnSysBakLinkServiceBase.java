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
package net.ibizsys.pscore.srv.sysdevstudio.service;

import java.sql.Timestamp;
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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysBase;
import net.ibizsys.pscore.srv.sysdevstudio.dao.PSDevSlnSysBakLinkDAO;
import net.ibizsys.pscore.srv.sysdevstudio.demodel.PSDevSlnSysBakLinkDEModel;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDevSlnSysBak;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDevSlnSysBakBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDevSlnSysBakLink;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnSysBakLinkServiceBase
extends PSCoreSysServiceBase<PSDevSlnSysBakLink> {
    private static final Log log = LogFactory.getLog(PSDevSlnSysBakLinkServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_UPDATELINKSTATE = "UpdateLinkState";
    private PSDevSlnSysBakLinkDEModel pSDevSlnSysBakLinkDEModel;
    private PSDevSlnSysBakLinkDAO pSDevSlnSysBakLinkDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysBakLinkService";
    }

    public PSDevSlnSysBakLinkDEModel getPSDevSlnSysBakLinkDEModel() {
        if (this.pSDevSlnSysBakLinkDEModel == null) {
            try {
                this.pSDevSlnSysBakLinkDEModel = (PSDevSlnSysBakLinkDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdevstudio.demodel.PSDevSlnSysBakLinkDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnSysBakLinkDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDevSlnSysBakLinkDEModel();
    }

    public PSDevSlnSysBakLinkDAO getPSDevSlnSysBakLinkDAO() {
        if (this.pSDevSlnSysBakLinkDAO == null) {
            try {
                this.pSDevSlnSysBakLinkDAO = (PSDevSlnSysBakLinkDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdevstudio.dao.PSDevSlnSysBakLinkDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnSysBakLinkDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDevSlnSysBakLinkDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_UPDATELINKSTATE, (boolean)true) == 0) {
            this.updateLinkState((PSDevSlnSysBakLink)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public void updateLinkState(PSDevSlnSysBakLink pSDevSlnSysBakLink) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_UPDATELINKSTATE, 0, (IEntity)pSDevSlnSysBakLink, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDevSlnSysBakLink, ACTION_UPDATELINKSTATE);
        final PSDevSlnSysBakLink pSDevSlnSysBakLink2 = pSDevSlnSysBakLink;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDevSlnSysBakLinkServiceBase.this.getService(), PSDevSlnSysBakLinkServiceBase.ACTION_UPDATELINKSTATE, 40, (IEntity)pSDevSlnSysBakLink2, null).getResult() != 1) {
                    PSDevSlnSysBakLinkServiceBase.this.onUpdateLinkState(pSDevSlnSysBakLink2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_UPDATELINKSTATE, 99, (IEntity)pSDevSlnSysBakLink, null);
        }
    }

    protected void onUpdateLinkState(PSDevSlnSysBakLink pSDevSlnSysBakLink) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[UpdateLinkState]");
    }

    protected void onFillParentInfo(PSDevSlnSysBakLink pSDevSlnSysBakLink, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSBAKLINK_PSDEVCENTER_LINKPSDEVCENTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService", (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = (PSDevCenter)iService.getDEModel().createEntity();
            pSDevCenter.set("PSDEVCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevCenter);
            } else {
                iService.get((IEntity)pSDevCenter);
            }
            this.onFillParentInfo_LinkPSDevCenter(pSDevSlnSysBakLink, pSDevCenter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSBAKLINK_PSDEVSLNSYSBAK_PSDEVSLNSYSBAKID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysBakService", (SessionFactory)this.getSessionFactory());
            PSDevSlnSysBak pSDevSlnSysBak = (PSDevSlnSysBak)iService.getDEModel().createEntity();
            pSDevSlnSysBak.set("PSDEVSLNSYSBAKID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevSlnSysBak);
            } else {
                iService.get((IEntity)pSDevSlnSysBak);
            }
            this.onFillParentInfo_PSDevSlnSysBak(pSDevSlnSysBakLink, pSDevSlnSysBak);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSBAKLINK_PSDEVSLNSYS_PSDEVSLNSYSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService", (SessionFactory)this.getSessionFactory());
            PSDevSlnSys pSDevSlnSys = (PSDevSlnSys)iService.getDEModel().createEntity();
            pSDevSlnSys.set("PSDEVSLNSYSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevSlnSys);
            } else {
                iService.get((IEntity)pSDevSlnSys);
            }
            this.onFillParentInfo_PSDevSlnSys(pSDevSlnSysBakLink, pSDevSlnSys);
            return;
        }
        super.onFillParentInfo((IEntity)pSDevSlnSysBakLink, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_LinkPSDevCenter(PSDevSlnSysBakLink pSDevSlnSysBakLink, PSDevCenter pSDevCenter) throws Exception {
        pSDevSlnSysBakLink.setLinkPSDevCenterId(pSDevCenter.getPSDevCenterId());
        pSDevSlnSysBakLink.setLinkPSDevCenterName(pSDevCenter.getPSDevCenterName());
    }

    protected void onFillParentInfo_PSDevSlnSysBak(PSDevSlnSysBakLink pSDevSlnSysBakLink, PSDevSlnSysBak pSDevSlnSysBak) throws Exception {
        pSDevSlnSysBakLink.setPSDevSlnSysBakId(pSDevSlnSysBak.getPSDevSlnSysBakId());
        pSDevSlnSysBakLink.setPSDevSlnSysBakName(pSDevSlnSysBak.getPSDevSlnSysBakName());
    }

    protected void onFillParentInfo_PSDevSlnSys(PSDevSlnSysBakLink pSDevSlnSysBakLink, PSDevSlnSys pSDevSlnSys) throws Exception {
        pSDevSlnSysBakLink.setPSDevSlnId(pSDevSlnSys.getPSDevSlnId());
        pSDevSlnSysBakLink.setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
        pSDevSlnSysBakLink.setPSDevSlnSysName(pSDevSlnSys.getPSDevSlnSysName());
    }

    protected void onFillEntityFullInfo(PSDevSlnSysBakLink pSDevSlnSysBakLink, boolean bl) throws Exception {
        if (bl && pSDevSlnSysBakLink.getValidFlag() == null) {
            pSDevSlnSysBakLink.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo((IEntity)pSDevSlnSysBakLink, bl);
        this.onFillEntityFullInfo_LinkPSDevCenter(pSDevSlnSysBakLink, bl);
        this.onFillEntityFullInfo_PSDevSlnSysBak(pSDevSlnSysBakLink, bl);
        this.onFillEntityFullInfo_PSDevSlnSys(pSDevSlnSysBakLink, bl);
    }

    protected void onFillEntityFullInfo_LinkPSDevCenter(PSDevSlnSysBakLink pSDevSlnSysBakLink, boolean bl) throws Exception {
        if (pSDevSlnSysBakLink.isLinkPSDevCenterIdDirty()) {
            if (pSDevSlnSysBakLink.getLinkPSDevCenterId() != null) {
                if (pSDevSlnSysBakLink.getLinkPSDevCenterId() == null || pSDevSlnSysBakLink.getLinkPSDevCenterName() == null) {
                    PSDevCenter pSDevCenter = pSDevSlnSysBakLink.getLinkPSDevCenter();
                    pSDevSlnSysBakLink.setLinkPSDevCenterName(pSDevCenter.getPSDevCenterName());
                }
            } else {
                pSDevSlnSysBakLink.setLinkPSDevCenterName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDevSlnSysBak(PSDevSlnSysBakLink pSDevSlnSysBakLink, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevSlnSys(PSDevSlnSysBakLink pSDevSlnSysBakLink, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDevSlnSysBakLink pSDevSlnSysBakLink, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDevSlnSysBakLink, bl);
    }

    public ArrayList<PSDevSlnSysBakLink> selectByLinkPSDevCenter(PSDevCenterBase pSDevCenterBase) throws Exception {
        return this.selectByLinkPSDevCenter(pSDevCenterBase, "", -1);
    }

    public ArrayList<PSDevSlnSysBakLink> selectByLinkPSDevCenter(PSDevCenterBase pSDevCenterBase, String string) throws Exception {
        return this.selectByLinkPSDevCenter(pSDevCenterBase, string, -1);
    }

    public ArrayList<PSDevSlnSysBakLink> selectByLinkPSDevCenter(PSDevCenterBase pSDevCenterBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("LINKPSDEVCENTERID", (Object)pSDevCenterBase.getPSDevCenterId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByLinkPSDevCenterCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByLinkPSDevCenterCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSysBakLink> selectByPSDevSlnSysBak(PSDevSlnSysBakBase pSDevSlnSysBakBase) throws Exception {
        return this.selectByPSDevSlnSysBak(pSDevSlnSysBakBase, "", -1);
    }

    public ArrayList<PSDevSlnSysBakLink> selectByPSDevSlnSysBak(PSDevSlnSysBakBase pSDevSlnSysBakBase, String string) throws Exception {
        return this.selectByPSDevSlnSysBak(pSDevSlnSysBakBase, string, -1);
    }

    public ArrayList<PSDevSlnSysBakLink> selectByPSDevSlnSysBak(PSDevSlnSysBakBase pSDevSlnSysBakBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSLNSYSBAKID", (Object)pSDevSlnSysBakBase.getPSDevSlnSysBakId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevSlnSysBakCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevSlnSysBakCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSysBakLink> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase) throws Exception {
        return this.selectByPSDevSlnSys(pSDevSlnSysBase, "", -1);
    }

    public ArrayList<PSDevSlnSysBakLink> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase, String string) throws Exception {
        return this.selectByPSDevSlnSys(pSDevSlnSysBase, string, -1);
    }

    public ArrayList<PSDevSlnSysBakLink> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSLNSYSID", (Object)pSDevSlnSysBase.getPSDevSlnSysId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevSlnSysCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevSlnSysCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByLinkPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    public void resetLinkPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDevSlnSysBakLink> arrayList = this.selectByLinkPSDevCenter(pSDevCenter);
        for (PSDevSlnSysBakLink pSDevSlnSysBakLink : arrayList) {
            PSDevSlnSysBakLink pSDevSlnSysBakLink2 = (PSDevSlnSysBakLink)this.getDEModel().createEntity();
            pSDevSlnSysBakLink2.setPSDevSlnSysBakLinkId(pSDevSlnSysBakLink.getPSDevSlnSysBakLinkId());
            pSDevSlnSysBakLink2.setLinkPSDevCenterId(null);
            this.update(pSDevSlnSysBakLink2);
        }
    }

    public void removeByLinkPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysBakLinkServiceBase.this.onBeforeRemoveByLinkPSDevCenter(pSDevCenter2);
                PSDevSlnSysBakLinkServiceBase.this.internalRemoveByLinkPSDevCenter(pSDevCenter2);
                PSDevSlnSysBakLinkServiceBase.this.onAfterRemoveByLinkPSDevCenter(pSDevCenter2);
            }
        });
    }

    protected void onBeforeRemoveByLinkPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void internalRemoveByLinkPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDevSlnSysBakLink> arrayList = this.selectByLinkPSDevCenter(pSDevCenter);
        this.onBeforeRemoveByLinkPSDevCenter(pSDevCenter, arrayList);
        for (PSDevSlnSysBakLink pSDevSlnSysBakLink : arrayList) {
            this.remove((IEntity)pSDevSlnSysBakLink);
        }
        this.onAfterRemoveByLinkPSDevCenter(pSDevCenter, arrayList);
    }

    protected void onAfterRemoveByLinkPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void onBeforeRemoveByLinkPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDevSlnSysBakLink> arrayList) throws Exception {
    }

    protected void onAfterRemoveByLinkPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDevSlnSysBakLink> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSlnSysBak(PSDevSlnSysBak pSDevSlnSysBak) throws Exception {
        ArrayList<PSDevSlnSysBakLink> arrayList = this.selectByPSDevSlnSysBak(pSDevSlnSysBak, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLNSYSBAK");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevSlnSysBak);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYSBAKLINK_PSDEVSLNSYSBAK_PSDEVSLNSYSBAKID", "", iDataEntityModel.getName(), "PSDEVSLNSYSBAKLINK", iDataEntityModel.getDataInfo((IEntity)pSDevSlnSysBak), arrayList.get(0)));
        }
    }

    public void resetPSDevSlnSysBak(PSDevSlnSysBak pSDevSlnSysBak) throws Exception {
        ArrayList<PSDevSlnSysBakLink> arrayList = this.selectByPSDevSlnSysBak(pSDevSlnSysBak);
        for (PSDevSlnSysBakLink pSDevSlnSysBakLink : arrayList) {
            PSDevSlnSysBakLink pSDevSlnSysBakLink2 = (PSDevSlnSysBakLink)this.getDEModel().createEntity();
            pSDevSlnSysBakLink2.setPSDevSlnSysBakLinkId(pSDevSlnSysBakLink.getPSDevSlnSysBakLinkId());
            pSDevSlnSysBakLink2.setPSDevSlnSysBakId(null);
            this.update(pSDevSlnSysBakLink2);
        }
    }

    public void removeByPSDevSlnSysBak(PSDevSlnSysBak pSDevSlnSysBak) throws Exception {
        final PSDevSlnSysBak pSDevSlnSysBak2 = pSDevSlnSysBak;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysBakLinkServiceBase.this.onBeforeRemoveByPSDevSlnSysBak(pSDevSlnSysBak2);
                PSDevSlnSysBakLinkServiceBase.this.internalRemoveByPSDevSlnSysBak(pSDevSlnSysBak2);
                PSDevSlnSysBakLinkServiceBase.this.onAfterRemoveByPSDevSlnSysBak(pSDevSlnSysBak2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnSysBak(PSDevSlnSysBak pSDevSlnSysBak) throws Exception {
    }

    protected void internalRemoveByPSDevSlnSysBak(PSDevSlnSysBak pSDevSlnSysBak) throws Exception {
        ArrayList<PSDevSlnSysBakLink> arrayList = this.selectByPSDevSlnSysBak(pSDevSlnSysBak);
        this.onBeforeRemoveByPSDevSlnSysBak(pSDevSlnSysBak, arrayList);
        for (PSDevSlnSysBakLink pSDevSlnSysBakLink : arrayList) {
            this.remove((IEntity)pSDevSlnSysBakLink);
        }
        this.onAfterRemoveByPSDevSlnSysBak(pSDevSlnSysBak, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnSysBak(PSDevSlnSysBak pSDevSlnSysBak) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnSysBak(PSDevSlnSysBak pSDevSlnSysBak, ArrayList<PSDevSlnSysBakLink> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnSysBak(PSDevSlnSysBak pSDevSlnSysBak, ArrayList<PSDevSlnSysBakLink> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSlnSysBakLink> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLNSYS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevSlnSys);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYSBAKLINK_PSDEVSLNSYS_PSDEVSLNSYSID", "", iDataEntityModel.getName(), "PSDEVSLNSYSBAKLINK", iDataEntityModel.getDataInfo((IEntity)pSDevSlnSys), arrayList.get(0)));
        }
    }

    public void resetPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSlnSysBakLink> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys);
        for (PSDevSlnSysBakLink pSDevSlnSysBakLink : arrayList) {
            PSDevSlnSysBakLink pSDevSlnSysBakLink2 = (PSDevSlnSysBakLink)this.getDEModel().createEntity();
            pSDevSlnSysBakLink2.setPSDevSlnSysBakLinkId(pSDevSlnSysBakLink.getPSDevSlnSysBakLinkId());
            pSDevSlnSysBakLink2.setPSDevSlnSysId(null);
            this.update(pSDevSlnSysBakLink2);
        }
    }

    public void removeByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        final PSDevSlnSys pSDevSlnSys2 = pSDevSlnSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysBakLinkServiceBase.this.onBeforeRemoveByPSDevSlnSys(pSDevSlnSys2);
                PSDevSlnSysBakLinkServiceBase.this.internalRemoveByPSDevSlnSys(pSDevSlnSys2);
                PSDevSlnSysBakLinkServiceBase.this.onAfterRemoveByPSDevSlnSys(pSDevSlnSys2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    protected void internalRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSlnSysBakLink> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys);
        this.onBeforeRemoveByPSDevSlnSys(pSDevSlnSys, arrayList);
        for (PSDevSlnSysBakLink pSDevSlnSysBakLink : arrayList) {
            this.remove((IEntity)pSDevSlnSysBakLink);
        }
        this.onAfterRemoveByPSDevSlnSys(pSDevSlnSys, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys, ArrayList<PSDevSlnSysBakLink> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys, ArrayList<PSDevSlnSysBakLink> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDevSlnSysBakLink pSDevSlnSysBakLink) throws Exception {
        super.onBeforeRemove(pSDevSlnSysBakLink);
    }

    protected void replaceParentInfo(PSDevSlnSysBakLink pSDevSlnSysBakLink, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDevSlnSysBakLink, cloneSession);
        if (pSDevSlnSysBakLink.getLinkPSDevCenterId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTER", (Object)pSDevSlnSysBakLink.getLinkPSDevCenterId())) != null) {
            this.onFillParentInfo_LinkPSDevCenter(pSDevSlnSysBakLink, (PSDevCenter)iEntity);
        }
        if (pSDevSlnSysBakLink.getPSDevSlnSysBakId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNSYSBAK", (Object)pSDevSlnSysBakLink.getPSDevSlnSysBakId())) != null) {
            this.onFillParentInfo_PSDevSlnSysBak(pSDevSlnSysBakLink, (PSDevSlnSysBak)iEntity);
        }
        if (pSDevSlnSysBakLink.getPSDevSlnSysId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNSYS", (Object)pSDevSlnSysBakLink.getPSDevSlnSysId())) != null) {
            this.onFillParentInfo_PSDevSlnSys(pSDevSlnSysBakLink, (PSDevSlnSys)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDevSlnSysBakLink pSDevSlnSysBakLink, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDevSlnSysBakLink, bl);
    }

    protected void onCheckEntity(boolean bl, PSDevSlnSysBakLink pSDevSlnSysBakLink, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_BeginTime(bl, pSDevSlnSysBakLink, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EndTime(bl, pSDevSlnSysBakLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LinkPSDevCenterId(bl, pSDevSlnSysBakLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LinkPSDevCenterName(bl, pSDevSlnSysBakLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LinkRepMsg(bl, pSDevSlnSysBakLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LinkReqMsg(bl, pSDevSlnSysBakLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LinkState(bl, pSDevSlnSysBakLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LinkStateInfo(bl, pSDevSlnSysBakLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDevSlnSysBakLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysBakId(bl, pSDevSlnSysBakLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysBakLinkId(bl, pSDevSlnSysBakLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysBakLinkName(bl, pSDevSlnSysBakLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysId(bl, pSDevSlnSysBakLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDevSlnSysBakLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDevSlnSysBakLink, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_BeginTime(boolean bl, PSDevSlnSysBakLink pSDevSlnSysBakLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysBakLink.isBeginTimeDirty() : !pSDevSlnSysBakLink.isBeginTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDevSlnSysBakLink.getBeginTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_BeginTime_Default((IEntity)pSDevSlnSysBakLink, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BEGINTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EndTime(boolean bl, PSDevSlnSysBakLink pSDevSlnSysBakLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysBakLink.isEndTimeDirty() : !pSDevSlnSysBakLink.isEndTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDevSlnSysBakLink.getEndTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EndTime_Default((IEntity)pSDevSlnSysBakLink, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENDTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LinkPSDevCenterId(boolean bl, PSDevSlnSysBakLink pSDevSlnSysBakLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysBakLink.isLinkPSDevCenterIdDirty() : !pSDevSlnSysBakLink.isLinkPSDevCenterIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysBakLink.getLinkPSDevCenterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LinkPSDevCenterId_Default((IEntity)pSDevSlnSysBakLink, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LINKPSDEVCENTERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LinkPSDevCenterName(boolean bl, PSDevSlnSysBakLink pSDevSlnSysBakLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysBakLink.isLinkPSDevCenterNameDirty() : !pSDevSlnSysBakLink.isLinkPSDevCenterNameDirty()) {
            return null;
        }
        String string = pSDevSlnSysBakLink.getLinkPSDevCenterName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LinkPSDevCenterName_Default((IEntity)pSDevSlnSysBakLink, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LINKPSDEVCENTERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LinkRepMsg(boolean bl, PSDevSlnSysBakLink pSDevSlnSysBakLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysBakLink.isLinkRepMsgDirty() : !pSDevSlnSysBakLink.isLinkRepMsgDirty()) {
            return null;
        }
        String string = pSDevSlnSysBakLink.getLinkRepMsg();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LinkRepMsg_Default((IEntity)pSDevSlnSysBakLink, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LINKREPMSG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LinkReqMsg(boolean bl, PSDevSlnSysBakLink pSDevSlnSysBakLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysBakLink.isLinkReqMsgDirty() : !pSDevSlnSysBakLink.isLinkReqMsgDirty()) {
            return null;
        }
        String string = pSDevSlnSysBakLink.getLinkReqMsg();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LinkReqMsg_Default((IEntity)pSDevSlnSysBakLink, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LINKREQMSG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LinkState(boolean bl, PSDevSlnSysBakLink pSDevSlnSysBakLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysBakLink.isLinkStateDirty() && !bl2 : !pSDevSlnSysBakLink.isLinkStateDirty()) {
            return null;
        }
        Integer n = pSDevSlnSysBakLink.getLinkState();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LINKSTATE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_LinkState_Default((IEntity)pSDevSlnSysBakLink, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LINKSTATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LinkStateInfo(boolean bl, PSDevSlnSysBakLink pSDevSlnSysBakLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysBakLink.isLinkStateInfoDirty() : !pSDevSlnSysBakLink.isLinkStateInfoDirty()) {
            return null;
        }
        String string = pSDevSlnSysBakLink.getLinkStateInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LinkStateInfo_Default((IEntity)pSDevSlnSysBakLink, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LINKSTATEINFO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDevSlnSysBakLink pSDevSlnSysBakLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysBakLink.isMemoDirty() : !pSDevSlnSysBakLink.isMemoDirty()) {
            return null;
        }
        String string = pSDevSlnSysBakLink.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDevSlnSysBakLink, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnSysBakId(boolean bl, PSDevSlnSysBakLink pSDevSlnSysBakLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysBakLink.isPSDevSlnSysBakIdDirty() : !pSDevSlnSysBakLink.isPSDevSlnSysBakIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysBakLink.getPSDevSlnSysBakId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysBakId_Default((IEntity)pSDevSlnSysBakLink, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSBAKID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnSysBakLinkId(boolean bl, PSDevSlnSysBakLink pSDevSlnSysBakLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysBakLink.isPSDevSlnSysBakLinkIdDirty() && !bl2 : !pSDevSlnSysBakLink.isPSDevSlnSysBakLinkIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysBakLink.getPSDevSlnSysBakLinkId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSBAKLINKID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysBakLinkId_Default((IEntity)pSDevSlnSysBakLink, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSBAKLINKID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnSysBakLinkName(boolean bl, PSDevSlnSysBakLink pSDevSlnSysBakLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysBakLink.isPSDevSlnSysBakLinkNameDirty() && !bl2 : !pSDevSlnSysBakLink.isPSDevSlnSysBakLinkNameDirty()) {
            return null;
        }
        String string = pSDevSlnSysBakLink.getPSDevSlnSysBakLinkName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSBAKLINKNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysBakLinkName_Default((IEntity)pSDevSlnSysBakLink, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSBAKLINKNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnSysId(boolean bl, PSDevSlnSysBakLink pSDevSlnSysBakLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysBakLink.isPSDevSlnSysIdDirty() : !pSDevSlnSysBakLink.isPSDevSlnSysIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysBakLink.getPSDevSlnSysId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysId_Default((IEntity)pSDevSlnSysBakLink, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDevSlnSysBakLink pSDevSlnSysBakLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysBakLink.isValidFlagDirty() && !bl2 : !pSDevSlnSysBakLink.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDevSlnSysBakLink.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSDevSlnSysBakLink, bl2, bl3);
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

    protected void onSyncEntity(PSDevSlnSysBakLink pSDevSlnSysBakLink, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDevSlnSysBakLink, bl);
    }

    protected void onSyncIndexEntities(PSDevSlnSysBakLink pSDevSlnSysBakLink, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDevSlnSysBakLink, bl);
    }

    public Object getDataContextValue(PSDevSlnSysBakLink pSDevSlnSysBakLink, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDevSlnSysBakLink, string, iDataContextParam)) != null) {
            return object;
        }
        PSDevSlnSysBak pSDevSlnSysBak = pSDevSlnSysBakLink.getPSDevSlnSysBak();
        if (pSDevSlnSysBak != null && pSDevSlnSysBak.contains(string)) {
            return pSDevSlnSysBak.get(string);
        }
        PSDevSlnSys pSDevSlnSys = pSDevSlnSysBakLink.getPSDevSlnSys();
        if (pSDevSlnSys != null && pSDevSlnSys.contains(string)) {
            return pSDevSlnSys.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDevSlnSysBakLink pSDevSlnSysBakLink, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDevSlnSysBakLink, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"BEGINTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BeginTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENDTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EndTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LINKPSDEVCENTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LinkPSDevCenterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LINKPSDEVCENTERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LinkPSDevCenterName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LINKREPMSG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LinkRepMsg_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LINKREQMSG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LinkReqMsg_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LINKSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LinkState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LINKSTATEINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LinkStateInfo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSBAKID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysBakId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSBAKLINKID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysBakLinkId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSBAKLINKNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysBakLinkName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSBAKNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysBakName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_BeginTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_EndTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LinkPSDevCenterId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LINKPSDEVCENTERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LinkPSDevCenterName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LINKPSDEVCENTERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LinkRepMsg_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LINKREPMSG", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LinkReqMsg_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LINKREQMSG", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LinkState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LinkStateInfo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LINKSTATEINFO", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
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

    protected String onTestValueRule_PSDevSlnId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysBakId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSBAKID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysBakLinkId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSBAKLINKID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysBakLinkName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSBAKLINKNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysBakName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSBAKNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
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

    protected boolean onMergeChild(String string, String string2, PSDevSlnSysBakLink pSDevSlnSysBakLink) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDevSlnSysBakLink)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDevSlnSysBakLink pSDevSlnSysBakLink) throws Exception {
        super.onUpdateParent((IEntity)pSDevSlnSysBakLink);
    }

    @Override
    protected void exportCurXmlModel(PSDevSlnSysBakLink pSDevSlnSysBakLink, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEVSLNSYSBAKLINK");
        if (!bl) {
            pSDevSlnSysBakLink.setCreateDate(null);
            pSDevSlnSysBakLink.setCreateMan(null);
            pSDevSlnSysBakLink.setPSDevSlnSysBakLinkId(null);
            pSDevSlnSysBakLink.setPSDevSlnSysBakName(null);
            pSDevSlnSysBakLink.setUpdateDate(null);
            pSDevSlnSysBakLink.setUpdateMan(null);
            super.exportCurXmlModel(pSDevSlnSysBakLink, xmlNode, bl);
        }
    }
}

