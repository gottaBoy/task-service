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
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysRef;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysRefBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysSrv;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysSrvBase;
import net.ibizsys.pscore.srv.sysdevstudio.dao.PSDevSlnSysRefLinkDAO;
import net.ibizsys.pscore.srv.sysdevstudio.demodel.PSDevSlnSysRefLinkDEModel;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDevSlnSysRefLink;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnSysRefLinkServiceBase
extends PSCoreSysServiceBase<PSDevSlnSysRefLink> {
    private static final Log log = LogFactory.getLog(PSDevSlnSysRefLinkServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_CREATEWITHTOKEN = "CreateWithToken";
    public static final String ACTION_UPDATELINKSTATE = "UpdateLinkState";
    private PSDevSlnSysRefLinkDEModel pSDevSlnSysRefLinkDEModel;
    private PSDevSlnSysRefLinkDAO pSDevSlnSysRefLinkDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysRefLinkService";
    }

    public PSDevSlnSysRefLinkDEModel getPSDevSlnSysRefLinkDEModel() {
        if (this.pSDevSlnSysRefLinkDEModel == null) {
            try {
                this.pSDevSlnSysRefLinkDEModel = (PSDevSlnSysRefLinkDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdevstudio.demodel.PSDevSlnSysRefLinkDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnSysRefLinkDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDevSlnSysRefLinkDEModel();
    }

    public PSDevSlnSysRefLinkDAO getPSDevSlnSysRefLinkDAO() {
        if (this.pSDevSlnSysRefLinkDAO == null) {
            try {
                this.pSDevSlnSysRefLinkDAO = (PSDevSlnSysRefLinkDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdevstudio.dao.PSDevSlnSysRefLinkDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnSysRefLinkDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDevSlnSysRefLinkDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_CREATEWITHTOKEN, (boolean)true) == 0) {
            this.createWithToken((PSDevSlnSysRefLink)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_UPDATELINKSTATE, (boolean)true) == 0) {
            this.updateLinkState((PSDevSlnSysRefLink)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public void createWithToken(PSDevSlnSysRefLink pSDevSlnSysRefLink) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CREATEWITHTOKEN, 0, (IEntity)pSDevSlnSysRefLink, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDevSlnSysRefLink, ACTION_CREATEWITHTOKEN);
        final PSDevSlnSysRefLink pSDevSlnSysRefLink2 = pSDevSlnSysRefLink;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDevSlnSysRefLinkServiceBase.this.getService(), PSDevSlnSysRefLinkServiceBase.ACTION_CREATEWITHTOKEN, 40, (IEntity)pSDevSlnSysRefLink2, null).getResult() != 1) {
                    PSDevSlnSysRefLinkServiceBase.this.onCreateWithToken(pSDevSlnSysRefLink2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CREATEWITHTOKEN, 99, (IEntity)pSDevSlnSysRefLink, null);
        }
    }

    protected void onCreateWithToken(PSDevSlnSysRefLink pSDevSlnSysRefLink) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[CreateWithToken]");
    }

    public void updateLinkState(PSDevSlnSysRefLink pSDevSlnSysRefLink) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_UPDATELINKSTATE, 0, (IEntity)pSDevSlnSysRefLink, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDevSlnSysRefLink, ACTION_UPDATELINKSTATE);
        final PSDevSlnSysRefLink pSDevSlnSysRefLink2 = pSDevSlnSysRefLink;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDevSlnSysRefLinkServiceBase.this.getService(), PSDevSlnSysRefLinkServiceBase.ACTION_UPDATELINKSTATE, 40, (IEntity)pSDevSlnSysRefLink2, null).getResult() != 1) {
                    PSDevSlnSysRefLinkServiceBase.this.onUpdateLinkState(pSDevSlnSysRefLink2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_UPDATELINKSTATE, 99, (IEntity)pSDevSlnSysRefLink, null);
        }
    }

    protected void onUpdateLinkState(PSDevSlnSysRefLink pSDevSlnSysRefLink) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[UpdateLinkState]");
    }

    protected void onFillParentInfo(PSDevSlnSysRefLink pSDevSlnSysRefLink, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSREFLINK_PSDEVCENTER_LINKPSDEVCENTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService", (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = (PSDevCenter)iService.getDEModel().createEntity();
            pSDevCenter.set("PSDEVCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevCenter);
            } else {
                iService.get((IEntity)pSDevCenter);
            }
            this.onFillParentInfo_LinkPSDevcCenter(pSDevSlnSysRefLink, pSDevCenter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSREFLINK_PSDEVSLNSYSREF_PSDEVSLNSYSREFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysRefService", (SessionFactory)this.getSessionFactory());
            PSDevSlnSysRef pSDevSlnSysRef = (PSDevSlnSysRef)iService.getDEModel().createEntity();
            pSDevSlnSysRef.set("PSDEVSLNSYSREFID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevSlnSysRef);
            } else {
                iService.get((IEntity)pSDevSlnSysRef);
            }
            this.onFillParentInfo_PSDevSlnSysRef(pSDevSlnSysRefLink, pSDevSlnSysRef);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSREFLINK_PSDEVSLNSYSSRV_PSDEVSLNSYSSRVID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysSrvService", (SessionFactory)this.getSessionFactory());
            PSDevSlnSysSrv pSDevSlnSysSrv = (PSDevSlnSysSrv)iService.getDEModel().createEntity();
            pSDevSlnSysSrv.set("PSDEVSLNSYSSRVID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevSlnSysSrv);
            } else {
                iService.get((IEntity)pSDevSlnSysSrv);
            }
            this.onFillParentInfo_PSDevSlnSysSrv(pSDevSlnSysRefLink, pSDevSlnSysSrv);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSREFLINK_PSDEVSLNSYS_PSDEVSLNSYSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService", (SessionFactory)this.getSessionFactory());
            PSDevSlnSys pSDevSlnSys = (PSDevSlnSys)iService.getDEModel().createEntity();
            pSDevSlnSys.set("PSDEVSLNSYSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevSlnSys);
            } else {
                iService.get((IEntity)pSDevSlnSys);
            }
            this.onFillParentInfo_PSDevSlnSys(pSDevSlnSysRefLink, pSDevSlnSys);
            return;
        }
        super.onFillParentInfo((IEntity)pSDevSlnSysRefLink, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_LinkPSDevcCenter(PSDevSlnSysRefLink pSDevSlnSysRefLink, PSDevCenter pSDevCenter) throws Exception {
        pSDevSlnSysRefLink.setLinkPSDevCenterId(pSDevCenter.getPSDevCenterId());
        pSDevSlnSysRefLink.setLinkPSDevCenterName(pSDevCenter.getPSDevCenterName());
    }

    protected void onFillParentInfo_PSDevSlnSysRef(PSDevSlnSysRefLink pSDevSlnSysRefLink, PSDevSlnSysRef pSDevSlnSysRef) throws Exception {
        pSDevSlnSysRefLink.setPSDevSlnSysRefId(pSDevSlnSysRef.getPSDevSlnSysRefId());
        pSDevSlnSysRefLink.setPSDevSlnSysRefName(pSDevSlnSysRef.getPSDevSlnSysRefName());
    }

    protected void onFillParentInfo_PSDevSlnSysSrv(PSDevSlnSysRefLink pSDevSlnSysRefLink, PSDevSlnSysSrv pSDevSlnSysSrv) throws Exception {
        pSDevSlnSysRefLink.setPSDevSlnSysSrvId(pSDevSlnSysSrv.getPSDevSlnSysSrvId());
        pSDevSlnSysRefLink.setPSDevSlnSysSrvName(pSDevSlnSysSrv.getPSDevSlnSysSrvName());
    }

    protected void onFillParentInfo_PSDevSlnSys(PSDevSlnSysRefLink pSDevSlnSysRefLink, PSDevSlnSys pSDevSlnSys) throws Exception {
        pSDevSlnSysRefLink.setPSDevSlnId(pSDevSlnSys.getPSDevSlnId());
        pSDevSlnSysRefLink.setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
        pSDevSlnSysRefLink.setPSDevSlnSysName(pSDevSlnSys.getPSDevSlnSysName());
    }

    protected void onFillEntityFullInfo(PSDevSlnSysRefLink pSDevSlnSysRefLink, boolean bl) throws Exception {
        if (bl) {
            if (pSDevSlnSysRefLink.getLinkState() == null) {
                pSDevSlnSysRefLink.setLinkState((Integer)this.getDefaultValue(this.getWebContext(), "", "10", 9));
            }
            if (pSDevSlnSysRefLink.getValidFlag() == null) {
                pSDevSlnSysRefLink.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSDevSlnSysRefLink, bl);
        this.onFillEntityFullInfo_LinkPSDevcCenter(pSDevSlnSysRefLink, bl);
        this.onFillEntityFullInfo_PSDevSlnSysRef(pSDevSlnSysRefLink, bl);
        this.onFillEntityFullInfo_PSDevSlnSysSrv(pSDevSlnSysRefLink, bl);
        this.onFillEntityFullInfo_PSDevSlnSys(pSDevSlnSysRefLink, bl);
    }

    protected void onFillEntityFullInfo_LinkPSDevcCenter(PSDevSlnSysRefLink pSDevSlnSysRefLink, boolean bl) throws Exception {
        if (pSDevSlnSysRefLink.isLinkPSDevCenterIdDirty()) {
            if (pSDevSlnSysRefLink.getLinkPSDevCenterId() != null) {
                if (pSDevSlnSysRefLink.getLinkPSDevCenterId() == null || pSDevSlnSysRefLink.getLinkPSDevCenterName() == null) {
                    PSDevCenter pSDevCenter = pSDevSlnSysRefLink.getLinkPSDevcCenter();
                    pSDevSlnSysRefLink.setLinkPSDevCenterName(pSDevCenter.getPSDevCenterName());
                }
            } else {
                pSDevSlnSysRefLink.setLinkPSDevCenterName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDevSlnSysRef(PSDevSlnSysRefLink pSDevSlnSysRefLink, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevSlnSysSrv(PSDevSlnSysRefLink pSDevSlnSysRefLink, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevSlnSys(PSDevSlnSysRefLink pSDevSlnSysRefLink, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDevSlnSysRefLink pSDevSlnSysRefLink, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDevSlnSysRefLink, bl);
    }

    public ArrayList<PSDevSlnSysRefLink> selectByLinkPSDevcCenter(PSDevCenterBase pSDevCenterBase) throws Exception {
        return this.selectByLinkPSDevcCenter(pSDevCenterBase, "", -1);
    }

    public ArrayList<PSDevSlnSysRefLink> selectByLinkPSDevcCenter(PSDevCenterBase pSDevCenterBase, String string) throws Exception {
        return this.selectByLinkPSDevcCenter(pSDevCenterBase, string, -1);
    }

    public ArrayList<PSDevSlnSysRefLink> selectByLinkPSDevcCenter(PSDevCenterBase pSDevCenterBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("LINKPSDEVCENTERID", (Object)pSDevCenterBase.getPSDevCenterId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByLinkPSDevcCenterCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByLinkPSDevcCenterCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSysRefLink> selectByPSDevSlnSysRef(PSDevSlnSysRefBase pSDevSlnSysRefBase) throws Exception {
        return this.selectByPSDevSlnSysRef(pSDevSlnSysRefBase, "", -1);
    }

    public ArrayList<PSDevSlnSysRefLink> selectByPSDevSlnSysRef(PSDevSlnSysRefBase pSDevSlnSysRefBase, String string) throws Exception {
        return this.selectByPSDevSlnSysRef(pSDevSlnSysRefBase, string, -1);
    }

    public ArrayList<PSDevSlnSysRefLink> selectByPSDevSlnSysRef(PSDevSlnSysRefBase pSDevSlnSysRefBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSLNSYSREFID", (Object)pSDevSlnSysRefBase.getPSDevSlnSysRefId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevSlnSysRefCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevSlnSysRefCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSysRefLink> selectByPSDevSlnSysSrv(PSDevSlnSysSrvBase pSDevSlnSysSrvBase) throws Exception {
        return this.selectByPSDevSlnSysSrv(pSDevSlnSysSrvBase, "", -1);
    }

    public ArrayList<PSDevSlnSysRefLink> selectByPSDevSlnSysSrv(PSDevSlnSysSrvBase pSDevSlnSysSrvBase, String string) throws Exception {
        return this.selectByPSDevSlnSysSrv(pSDevSlnSysSrvBase, string, -1);
    }

    public ArrayList<PSDevSlnSysRefLink> selectByPSDevSlnSysSrv(PSDevSlnSysSrvBase pSDevSlnSysSrvBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSLNSYSSRVID", (Object)pSDevSlnSysSrvBase.getPSDevSlnSysSrvId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevSlnSysSrvCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevSlnSysSrvCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSysRefLink> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase) throws Exception {
        return this.selectByPSDevSlnSys(pSDevSlnSysBase, "", -1);
    }

    public ArrayList<PSDevSlnSysRefLink> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase, String string) throws Exception {
        return this.selectByPSDevSlnSys(pSDevSlnSysBase, string, -1);
    }

    public ArrayList<PSDevSlnSysRefLink> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase, String string, int n) throws Exception {
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

    public void testRemoveByLinkPSDevcCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    public void resetLinkPSDevcCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDevSlnSysRefLink> arrayList = this.selectByLinkPSDevcCenter(pSDevCenter);
        for (PSDevSlnSysRefLink pSDevSlnSysRefLink : arrayList) {
            PSDevSlnSysRefLink pSDevSlnSysRefLink2 = (PSDevSlnSysRefLink)this.getDEModel().createEntity();
            pSDevSlnSysRefLink2.setPSDevSlnSysRefLinkId(pSDevSlnSysRefLink.getPSDevSlnSysRefLinkId());
            pSDevSlnSysRefLink2.setLinkPSDevCenterId(null);
            this.update(pSDevSlnSysRefLink2);
        }
    }

    public void removeByLinkPSDevcCenter(PSDevCenter pSDevCenter) throws Exception {
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysRefLinkServiceBase.this.onBeforeRemoveByLinkPSDevcCenter(pSDevCenter2);
                PSDevSlnSysRefLinkServiceBase.this.internalRemoveByLinkPSDevcCenter(pSDevCenter2);
                PSDevSlnSysRefLinkServiceBase.this.onAfterRemoveByLinkPSDevcCenter(pSDevCenter2);
            }
        });
    }

    protected void onBeforeRemoveByLinkPSDevcCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void internalRemoveByLinkPSDevcCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDevSlnSysRefLink> arrayList = this.selectByLinkPSDevcCenter(pSDevCenter);
        this.onBeforeRemoveByLinkPSDevcCenter(pSDevCenter, arrayList);
        for (PSDevSlnSysRefLink pSDevSlnSysRefLink : arrayList) {
            this.remove((IEntity)pSDevSlnSysRefLink);
        }
        this.onAfterRemoveByLinkPSDevcCenter(pSDevCenter, arrayList);
    }

    protected void onAfterRemoveByLinkPSDevcCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void onBeforeRemoveByLinkPSDevcCenter(PSDevCenter pSDevCenter, ArrayList<PSDevSlnSysRefLink> arrayList) throws Exception {
    }

    protected void onAfterRemoveByLinkPSDevcCenter(PSDevCenter pSDevCenter, ArrayList<PSDevSlnSysRefLink> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSlnSysRef(PSDevSlnSysRef pSDevSlnSysRef) throws Exception {
    }

    public void resetPSDevSlnSysRef(PSDevSlnSysRef pSDevSlnSysRef) throws Exception {
        ArrayList<PSDevSlnSysRefLink> arrayList = this.selectByPSDevSlnSysRef(pSDevSlnSysRef);
        for (PSDevSlnSysRefLink pSDevSlnSysRefLink : arrayList) {
            PSDevSlnSysRefLink pSDevSlnSysRefLink2 = (PSDevSlnSysRefLink)this.getDEModel().createEntity();
            pSDevSlnSysRefLink2.setPSDevSlnSysRefLinkId(pSDevSlnSysRefLink.getPSDevSlnSysRefLinkId());
            pSDevSlnSysRefLink2.setPSDevSlnSysRefId(null);
            this.update(pSDevSlnSysRefLink2);
        }
    }

    public void removeByPSDevSlnSysRef(PSDevSlnSysRef pSDevSlnSysRef) throws Exception {
        final PSDevSlnSysRef pSDevSlnSysRef2 = pSDevSlnSysRef;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysRefLinkServiceBase.this.onBeforeRemoveByPSDevSlnSysRef(pSDevSlnSysRef2);
                PSDevSlnSysRefLinkServiceBase.this.internalRemoveByPSDevSlnSysRef(pSDevSlnSysRef2);
                PSDevSlnSysRefLinkServiceBase.this.onAfterRemoveByPSDevSlnSysRef(pSDevSlnSysRef2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnSysRef(PSDevSlnSysRef pSDevSlnSysRef) throws Exception {
    }

    protected void internalRemoveByPSDevSlnSysRef(PSDevSlnSysRef pSDevSlnSysRef) throws Exception {
        ArrayList<PSDevSlnSysRefLink> arrayList = this.selectByPSDevSlnSysRef(pSDevSlnSysRef);
        this.onBeforeRemoveByPSDevSlnSysRef(pSDevSlnSysRef, arrayList);
        for (PSDevSlnSysRefLink pSDevSlnSysRefLink : arrayList) {
            this.remove((IEntity)pSDevSlnSysRefLink);
        }
        this.onAfterRemoveByPSDevSlnSysRef(pSDevSlnSysRef, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnSysRef(PSDevSlnSysRef pSDevSlnSysRef) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnSysRef(PSDevSlnSysRef pSDevSlnSysRef, ArrayList<PSDevSlnSysRefLink> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnSysRef(PSDevSlnSysRef pSDevSlnSysRef, ArrayList<PSDevSlnSysRefLink> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSlnSysSrv(PSDevSlnSysSrv pSDevSlnSysSrv) throws Exception {
        ArrayList<PSDevSlnSysRefLink> arrayList = this.selectByPSDevSlnSysSrv(pSDevSlnSysSrv, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLNSYSSRV");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevSlnSysSrv);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYSREFLINK_PSDEVSLNSYSSRV_PSDEVSLNSYSSRVID", "", iDataEntityModel.getName(), "PSDEVSLNSYSREFLINK", iDataEntityModel.getDataInfo((IEntity)pSDevSlnSysSrv), arrayList.get(0)));
        }
    }

    public void resetPSDevSlnSysSrv(PSDevSlnSysSrv pSDevSlnSysSrv) throws Exception {
        ArrayList<PSDevSlnSysRefLink> arrayList = this.selectByPSDevSlnSysSrv(pSDevSlnSysSrv);
        for (PSDevSlnSysRefLink pSDevSlnSysRefLink : arrayList) {
            PSDevSlnSysRefLink pSDevSlnSysRefLink2 = (PSDevSlnSysRefLink)this.getDEModel().createEntity();
            pSDevSlnSysRefLink2.setPSDevSlnSysRefLinkId(pSDevSlnSysRefLink.getPSDevSlnSysRefLinkId());
            pSDevSlnSysRefLink2.setPSDevSlnSysSrvId(null);
            this.update(pSDevSlnSysRefLink2);
        }
    }

    public void removeByPSDevSlnSysSrv(PSDevSlnSysSrv pSDevSlnSysSrv) throws Exception {
        final PSDevSlnSysSrv pSDevSlnSysSrv2 = pSDevSlnSysSrv;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysRefLinkServiceBase.this.onBeforeRemoveByPSDevSlnSysSrv(pSDevSlnSysSrv2);
                PSDevSlnSysRefLinkServiceBase.this.internalRemoveByPSDevSlnSysSrv(pSDevSlnSysSrv2);
                PSDevSlnSysRefLinkServiceBase.this.onAfterRemoveByPSDevSlnSysSrv(pSDevSlnSysSrv2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnSysSrv(PSDevSlnSysSrv pSDevSlnSysSrv) throws Exception {
    }

    protected void internalRemoveByPSDevSlnSysSrv(PSDevSlnSysSrv pSDevSlnSysSrv) throws Exception {
        ArrayList<PSDevSlnSysRefLink> arrayList = this.selectByPSDevSlnSysSrv(pSDevSlnSysSrv);
        this.onBeforeRemoveByPSDevSlnSysSrv(pSDevSlnSysSrv, arrayList);
        for (PSDevSlnSysRefLink pSDevSlnSysRefLink : arrayList) {
            this.remove((IEntity)pSDevSlnSysRefLink);
        }
        this.onAfterRemoveByPSDevSlnSysSrv(pSDevSlnSysSrv, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnSysSrv(PSDevSlnSysSrv pSDevSlnSysSrv) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnSysSrv(PSDevSlnSysSrv pSDevSlnSysSrv, ArrayList<PSDevSlnSysRefLink> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnSysSrv(PSDevSlnSysSrv pSDevSlnSysSrv, ArrayList<PSDevSlnSysRefLink> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSlnSysRefLink> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLNSYS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevSlnSys);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYSREFLINK_PSDEVSLNSYS_PSDEVSLNSYSID", "", iDataEntityModel.getName(), "PSDEVSLNSYSREFLINK", iDataEntityModel.getDataInfo((IEntity)pSDevSlnSys), arrayList.get(0)));
        }
    }

    public void resetPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSlnSysRefLink> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys);
        for (PSDevSlnSysRefLink pSDevSlnSysRefLink : arrayList) {
            PSDevSlnSysRefLink pSDevSlnSysRefLink2 = (PSDevSlnSysRefLink)this.getDEModel().createEntity();
            pSDevSlnSysRefLink2.setPSDevSlnSysRefLinkId(pSDevSlnSysRefLink.getPSDevSlnSysRefLinkId());
            pSDevSlnSysRefLink2.setPSDevSlnSysId(null);
            this.update(pSDevSlnSysRefLink2);
        }
    }

    public void removeByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        final PSDevSlnSys pSDevSlnSys2 = pSDevSlnSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysRefLinkServiceBase.this.onBeforeRemoveByPSDevSlnSys(pSDevSlnSys2);
                PSDevSlnSysRefLinkServiceBase.this.internalRemoveByPSDevSlnSys(pSDevSlnSys2);
                PSDevSlnSysRefLinkServiceBase.this.onAfterRemoveByPSDevSlnSys(pSDevSlnSys2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    protected void internalRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSlnSysRefLink> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys);
        this.onBeforeRemoveByPSDevSlnSys(pSDevSlnSys, arrayList);
        for (PSDevSlnSysRefLink pSDevSlnSysRefLink : arrayList) {
            this.remove((IEntity)pSDevSlnSysRefLink);
        }
        this.onAfterRemoveByPSDevSlnSys(pSDevSlnSys, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys, ArrayList<PSDevSlnSysRefLink> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys, ArrayList<PSDevSlnSysRefLink> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDevSlnSysRefLink pSDevSlnSysRefLink) throws Exception {
        super.onBeforeRemove(pSDevSlnSysRefLink);
    }

    protected void replaceParentInfo(PSDevSlnSysRefLink pSDevSlnSysRefLink, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDevSlnSysRefLink, cloneSession);
        if (pSDevSlnSysRefLink.getLinkPSDevCenterId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTER", (Object)pSDevSlnSysRefLink.getLinkPSDevCenterId())) != null) {
            this.onFillParentInfo_LinkPSDevcCenter(pSDevSlnSysRefLink, (PSDevCenter)iEntity);
        }
        if (pSDevSlnSysRefLink.getPSDevSlnSysRefId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNSYSREF", (Object)pSDevSlnSysRefLink.getPSDevSlnSysRefId())) != null) {
            this.onFillParentInfo_PSDevSlnSysRef(pSDevSlnSysRefLink, (PSDevSlnSysRef)iEntity);
        }
        if (pSDevSlnSysRefLink.getPSDevSlnSysSrvId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNSYSSRV", (Object)pSDevSlnSysRefLink.getPSDevSlnSysSrvId())) != null) {
            this.onFillParentInfo_PSDevSlnSysSrv(pSDevSlnSysRefLink, (PSDevSlnSysSrv)iEntity);
        }
        if (pSDevSlnSysRefLink.getPSDevSlnSysId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNSYS", (Object)pSDevSlnSysRefLink.getPSDevSlnSysId())) != null) {
            this.onFillParentInfo_PSDevSlnSys(pSDevSlnSysRefLink, (PSDevSlnSys)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDevSlnSysRefLink pSDevSlnSysRefLink, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDevSlnSysRefLink, bl);
    }

    protected void onCheckEntity(boolean bl, PSDevSlnSysRefLink pSDevSlnSysRefLink, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AccessToken(bl, pSDevSlnSysRefLink, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BeginTime(bl, pSDevSlnSysRefLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EndTime(bl, pSDevSlnSysRefLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LinkPSDevCenterId(bl, pSDevSlnSysRefLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LinkPSDevCenterName(bl, pSDevSlnSysRefLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LinkRepMsg(bl, pSDevSlnSysRefLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LinkReqMsg(bl, pSDevSlnSysRefLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LinkState(bl, pSDevSlnSysRefLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LinkStateInfo(bl, pSDevSlnSysRefLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDevSlnSysRefLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysId(bl, pSDevSlnSysRefLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysRefId(bl, pSDevSlnSysRefLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysRefLinkId(bl, pSDevSlnSysRefLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysRefLinkName(bl, pSDevSlnSysRefLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysSrvId(bl, pSDevSlnSysRefLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDevSlnSysRefLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDevSlnSysRefLink, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AccessToken(boolean bl, PSDevSlnSysRefLink pSDevSlnSysRefLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRefLink.isAccessTokenDirty() : !pSDevSlnSysRefLink.isAccessTokenDirty()) {
            return null;
        }
        String string = pSDevSlnSysRefLink.getAccessToken();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AccessToken_Default((IEntity)pSDevSlnSysRefLink, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ACCESSTOKEN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BeginTime(boolean bl, PSDevSlnSysRefLink pSDevSlnSysRefLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRefLink.isBeginTimeDirty() : !pSDevSlnSysRefLink.isBeginTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDevSlnSysRefLink.getBeginTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_BeginTime_Default((IEntity)pSDevSlnSysRefLink, bl2, bl3);
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

    protected EntityFieldError onCheckField_EndTime(boolean bl, PSDevSlnSysRefLink pSDevSlnSysRefLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRefLink.isEndTimeDirty() : !pSDevSlnSysRefLink.isEndTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDevSlnSysRefLink.getEndTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EndTime_Default((IEntity)pSDevSlnSysRefLink, bl2, bl3);
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

    protected EntityFieldError onCheckField_LinkPSDevCenterId(boolean bl, PSDevSlnSysRefLink pSDevSlnSysRefLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRefLink.isLinkPSDevCenterIdDirty() && !bl2 : !pSDevSlnSysRefLink.isLinkPSDevCenterIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysRefLink.getLinkPSDevCenterId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LINKPSDEVCENTERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_LinkPSDevCenterId_Default((IEntity)pSDevSlnSysRefLink, bl2, bl3);
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

    protected EntityFieldError onCheckField_LinkPSDevCenterName(boolean bl, PSDevSlnSysRefLink pSDevSlnSysRefLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRefLink.isLinkPSDevCenterNameDirty() && !bl2 : !pSDevSlnSysRefLink.isLinkPSDevCenterNameDirty()) {
            return null;
        }
        String string = pSDevSlnSysRefLink.getLinkPSDevCenterName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LINKPSDEVCENTERNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_LinkPSDevCenterName_Default((IEntity)pSDevSlnSysRefLink, bl2, bl3);
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

    protected EntityFieldError onCheckField_LinkRepMsg(boolean bl, PSDevSlnSysRefLink pSDevSlnSysRefLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRefLink.isLinkRepMsgDirty() : !pSDevSlnSysRefLink.isLinkRepMsgDirty()) {
            return null;
        }
        String string = pSDevSlnSysRefLink.getLinkRepMsg();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LinkRepMsg_Default((IEntity)pSDevSlnSysRefLink, bl2, bl3);
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

    protected EntityFieldError onCheckField_LinkReqMsg(boolean bl, PSDevSlnSysRefLink pSDevSlnSysRefLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRefLink.isLinkReqMsgDirty() : !pSDevSlnSysRefLink.isLinkReqMsgDirty()) {
            return null;
        }
        String string = pSDevSlnSysRefLink.getLinkReqMsg();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LinkReqMsg_Default((IEntity)pSDevSlnSysRefLink, bl2, bl3);
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

    protected EntityFieldError onCheckField_LinkState(boolean bl, PSDevSlnSysRefLink pSDevSlnSysRefLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRefLink.isLinkStateDirty() && !bl2 : !pSDevSlnSysRefLink.isLinkStateDirty()) {
            return null;
        }
        Integer n = pSDevSlnSysRefLink.getLinkState();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LINKSTATE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_LinkState_Default((IEntity)pSDevSlnSysRefLink, bl2, bl3);
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

    protected EntityFieldError onCheckField_LinkStateInfo(boolean bl, PSDevSlnSysRefLink pSDevSlnSysRefLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRefLink.isLinkStateInfoDirty() : !pSDevSlnSysRefLink.isLinkStateInfoDirty()) {
            return null;
        }
        String string = pSDevSlnSysRefLink.getLinkStateInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LinkStateInfo_Default((IEntity)pSDevSlnSysRefLink, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDevSlnSysRefLink pSDevSlnSysRefLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRefLink.isMemoDirty() : !pSDevSlnSysRefLink.isMemoDirty()) {
            return null;
        }
        String string = pSDevSlnSysRefLink.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDevSlnSysRefLink, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnSysId(boolean bl, PSDevSlnSysRefLink pSDevSlnSysRefLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRefLink.isPSDevSlnSysIdDirty() && !bl2 : !pSDevSlnSysRefLink.isPSDevSlnSysIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysRefLink.getPSDevSlnSysId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysId_Default((IEntity)pSDevSlnSysRefLink, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnSysRefId(boolean bl, PSDevSlnSysRefLink pSDevSlnSysRefLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRefLink.isPSDevSlnSysRefIdDirty() && !bl2 : !pSDevSlnSysRefLink.isPSDevSlnSysRefIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysRefLink.getPSDevSlnSysRefId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSREFID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysRefId_Default((IEntity)pSDevSlnSysRefLink, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSREFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnSysRefLinkId(boolean bl, PSDevSlnSysRefLink pSDevSlnSysRefLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRefLink.isPSDevSlnSysRefLinkIdDirty() && !bl2 : !pSDevSlnSysRefLink.isPSDevSlnSysRefLinkIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysRefLink.getPSDevSlnSysRefLinkId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSREFLINKID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysRefLinkId_Default((IEntity)pSDevSlnSysRefLink, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSREFLINKID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnSysRefLinkName(boolean bl, PSDevSlnSysRefLink pSDevSlnSysRefLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRefLink.isPSDevSlnSysRefLinkNameDirty() && !bl2 : !pSDevSlnSysRefLink.isPSDevSlnSysRefLinkNameDirty()) {
            return null;
        }
        String string = pSDevSlnSysRefLink.getPSDevSlnSysRefLinkName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSREFLINKNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysRefLinkName_Default((IEntity)pSDevSlnSysRefLink, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSREFLINKNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnSysSrvId(boolean bl, PSDevSlnSysRefLink pSDevSlnSysRefLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRefLink.isPSDevSlnSysSrvIdDirty() && !bl2 : !pSDevSlnSysRefLink.isPSDevSlnSysSrvIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysRefLink.getPSDevSlnSysSrvId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSSRVID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysSrvId_Default((IEntity)pSDevSlnSysRefLink, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSSRVID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDevSlnSysRefLink pSDevSlnSysRefLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRefLink.isValidFlagDirty() && !bl2 : !pSDevSlnSysRefLink.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDevSlnSysRefLink.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSDevSlnSysRefLink, bl2, bl3);
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

    protected void onSyncEntity(PSDevSlnSysRefLink pSDevSlnSysRefLink, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDevSlnSysRefLink, bl);
    }

    protected void onSyncIndexEntities(PSDevSlnSysRefLink pSDevSlnSysRefLink, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDevSlnSysRefLink, bl);
    }

    public Object getDataContextValue(PSDevSlnSysRefLink pSDevSlnSysRefLink, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDevSlnSysRefLink, string, iDataContextParam)) != null) {
            return object;
        }
        PSDevSlnSys pSDevSlnSys = pSDevSlnSysRefLink.getPSDevSlnSys();
        if (pSDevSlnSys != null && pSDevSlnSys.contains(string)) {
            return pSDevSlnSys.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDevSlnSysRefLink pSDevSlnSysRefLink, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDevSlnSysRefLink, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ACCESSTOKEN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AccessToken_Default(iEntity, bl, bl2);
        }
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
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSREFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysRefId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSREFLINKID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysRefLinkId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSREFLINKNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysRefLinkName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSREFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysRefName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSSRVID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysSrvId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSSRVNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysSrvName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_AccessToken_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ACCESSTOKEN", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_PSDevSlnSysRefId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSREFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysRefLinkId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSREFLINKID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysRefLinkName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSREFLINKNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysRefName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSREFNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysSrvId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSSRVID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysSrvName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSSRVNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDevSlnSysRefLink pSDevSlnSysRefLink) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDevSlnSysRefLink)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDevSlnSysRefLink pSDevSlnSysRefLink) throws Exception {
        super.onUpdateParent((IEntity)pSDevSlnSysRefLink);
    }

    @Override
    protected void exportCurXmlModel(PSDevSlnSysRefLink pSDevSlnSysRefLink, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEVSLNSYSREFLINK");
        if (!bl) {
            pSDevSlnSysRefLink.setCreateDate(null);
            pSDevSlnSysRefLink.setCreateMan(null);
            pSDevSlnSysRefLink.setPSDevSlnSysRefLinkId(null);
            pSDevSlnSysRefLink.setUpdateDate(null);
            pSDevSlnSysRefLink.setUpdateMan(null);
            super.exportCurXmlModel(pSDevSlnSysRefLink, xmlNode, bl);
        }
    }
}

