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
package net.ibizsys.pscore.srv.sysdeploy.service;

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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterBase;
import net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSlnSysKeyDAO;
import net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSlnSysKeyDEModel;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnSys;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnSysBase;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnSysDynaInst;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnSysDynaInstBase;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnSysKey;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDepSlnSysKeyServiceBase
extends PSCoreSysServiceBase<PSDepSlnSysKey> {
    private static final Log log = LogFactory.getLog(PSDepSlnSysKeyServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDepSlnSysKeyDEModel pSDepSlnSysKeyDEModel;
    private PSDepSlnSysKeyDAO pSDepSlnSysKeyDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysKeyService";
    }

    public PSDepSlnSysKeyDEModel getPSDepSlnSysKeyDEModel() {
        if (this.pSDepSlnSysKeyDEModel == null) {
            try {
                this.pSDepSlnSysKeyDEModel = (PSDepSlnSysKeyDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSlnSysKeyDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSlnSysKeyDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDepSlnSysKeyDEModel();
    }

    public PSDepSlnSysKeyDAO getPSDepSlnSysKeyDAO() {
        if (this.pSDepSlnSysKeyDAO == null) {
            try {
                this.pSDepSlnSysKeyDAO = (PSDepSlnSysKeyDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSlnSysKeyDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSlnSysKeyDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDepSlnSysKeyDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSDepSlnSysKey pSDepSlnSysKey, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLNSYSKEY_PSDEPSLNSYSDYNAINST_PSDEPSLNSYSDYNAINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysDynaInstService", (SessionFactory)this.getSessionFactory());
            PSDepSlnSysDynaInst pSDepSlnSysDynaInst = (PSDepSlnSysDynaInst)iService.getDEModel().createEntity();
            pSDepSlnSysDynaInst.set("PSDEPSLNSYSDYNAINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDepSlnSysDynaInst);
            } else {
                iService.get(pSDepSlnSysDynaInst);
            }
            this.onFillParentInfo_PSDepSlnSysDynaInst(pSDepSlnSysKey, pSDepSlnSysDynaInst);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLNSYSKEY_PSDEPSLNSYS_PSDEPSLNSYSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysService", (SessionFactory)this.getSessionFactory());
            PSDepSlnSys pSDepSlnSys = (PSDepSlnSys)iService.getDEModel().createEntity();
            pSDepSlnSys.set("PSDEPSLNSYSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDepSlnSys);
            } else {
                iService.get(pSDepSlnSys);
            }
            this.onFillParentInfo_PSDepSlnSys(pSDepSlnSysKey, pSDepSlnSys);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLNSYSKEY_PSDEVCENTER_PSDEVCENTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService", (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = (PSDevCenter)iService.getDEModel().createEntity();
            pSDevCenter.set("PSDEVCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenter);
            } else {
                iService.get(pSDevCenter);
            }
            this.onFillParentInfo_PSDevCenter(pSDepSlnSysKey, pSDevCenter);
            return;
        }
        super.onFillParentInfo(pSDepSlnSysKey, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDepSlnSysDynaInst(PSDepSlnSysKey pSDepSlnSysKey, PSDepSlnSysDynaInst pSDepSlnSysDynaInst) throws Exception {
        pSDepSlnSysKey.setPSDepSlnSysDynaInstId(pSDepSlnSysDynaInst.getPSDepSlnSysDynaInstId());
        pSDepSlnSysKey.setPSDepSlnSysDynaInstName(pSDepSlnSysDynaInst.getPSDepSlnSysDynaInstName());
    }

    protected void onFillParentInfo_PSDepSlnSys(PSDepSlnSysKey pSDepSlnSysKey, PSDepSlnSys pSDepSlnSys) throws Exception {
        pSDepSlnSysKey.setPSDepSlnSysId(pSDepSlnSys.getPSDepSlnSysId());
        pSDepSlnSysKey.setPSDepSlnSysName(pSDepSlnSys.getPSDepSlnSysName());
    }

    protected void onFillParentInfo_PSDevCenter(PSDepSlnSysKey pSDepSlnSysKey, PSDevCenter pSDevCenter) throws Exception {
        pSDepSlnSysKey.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
        pSDepSlnSysKey.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
    }

    protected void onFillEntityFullInfo(PSDepSlnSysKey pSDepSlnSysKey, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDepSlnSysKey, bl);
        this.onFillEntityFullInfo_PSDepSlnSysDynaInst(pSDepSlnSysKey, bl);
        this.onFillEntityFullInfo_PSDepSlnSys(pSDepSlnSysKey, bl);
        this.onFillEntityFullInfo_PSDevCenter(pSDepSlnSysKey, bl);
    }

    protected void onFillEntityFullInfo_PSDepSlnSysDynaInst(PSDepSlnSysKey pSDepSlnSysKey, boolean bl) throws Exception {
        if (pSDepSlnSysKey.isPSDepSlnSysDynaInstIdDirty()) {
            if (pSDepSlnSysKey.getPSDepSlnSysDynaInstId() != null) {
                if (pSDepSlnSysKey.getPSDepSlnSysDynaInstId() == null || pSDepSlnSysKey.getPSDepSlnSysDynaInstName() == null) {
                    PSDepSlnSysDynaInst pSDepSlnSysDynaInst = pSDepSlnSysKey.getPSDepSlnSysDynaInst();
                    pSDepSlnSysKey.setPSDepSlnSysDynaInstName(pSDepSlnSysDynaInst.getPSDepSlnSysDynaInstName());
                }
            } else {
                pSDepSlnSysKey.setPSDepSlnSysDynaInstName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDepSlnSys(PSDepSlnSysKey pSDepSlnSysKey, boolean bl) throws Exception {
        if (pSDepSlnSysKey.isPSDepSlnSysIdDirty()) {
            if (pSDepSlnSysKey.getPSDepSlnSysId() != null) {
                if (pSDepSlnSysKey.getPSDepSlnSysId() == null || pSDepSlnSysKey.getPSDepSlnSysName() == null) {
                    PSDepSlnSys pSDepSlnSys = pSDepSlnSysKey.getPSDepSlnSys();
                    pSDepSlnSysKey.setPSDepSlnSysName(pSDepSlnSys.getPSDepSlnSysName());
                }
            } else {
                pSDepSlnSysKey.setPSDepSlnSysName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDevCenter(PSDepSlnSysKey pSDepSlnSysKey, boolean bl) throws Exception {
        if (pSDepSlnSysKey.isPSDevCenterIdDirty()) {
            if (pSDepSlnSysKey.getPSDevCenterId() != null) {
                if (pSDepSlnSysKey.getPSDevCenterId() == null || pSDepSlnSysKey.getPSDevCenterName() == null) {
                    PSDevCenter pSDevCenter = pSDepSlnSysKey.getPSDevCenter();
                    pSDepSlnSysKey.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
                }
            } else {
                pSDepSlnSysKey.setPSDevCenterName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDepSlnSysKey pSDepSlnSysKey, boolean bl) throws Exception {
        super.onWriteBackParent(pSDepSlnSysKey, bl);
    }

    public ArrayList<PSDepSlnSysKey> selectByPSDepSlnSysDynaInst(PSDepSlnSysDynaInstBase pSDepSlnSysDynaInstBase) throws Exception {
        return this.selectByPSDepSlnSysDynaInst(pSDepSlnSysDynaInstBase, "", -1);
    }

    public ArrayList<PSDepSlnSysKey> selectByPSDepSlnSysDynaInst(PSDepSlnSysDynaInstBase pSDepSlnSysDynaInstBase, String string) throws Exception {
        return this.selectByPSDepSlnSysDynaInst(pSDepSlnSysDynaInstBase, string, -1);
    }

    public ArrayList<PSDepSlnSysKey> selectByPSDepSlnSysDynaInst(PSDepSlnSysDynaInstBase pSDepSlnSysDynaInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEPSLNSYSDYNAINSTID", (Object)pSDepSlnSysDynaInstBase.getPSDepSlnSysDynaInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDepSlnSysDynaInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDepSlnSysDynaInstCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDepSlnSysKey> selectByPSDepSlnSys(PSDepSlnSysBase pSDepSlnSysBase) throws Exception {
        return this.selectByPSDepSlnSys(pSDepSlnSysBase, "", -1);
    }

    public ArrayList<PSDepSlnSysKey> selectByPSDepSlnSys(PSDepSlnSysBase pSDepSlnSysBase, String string) throws Exception {
        return this.selectByPSDepSlnSys(pSDepSlnSysBase, string, -1);
    }

    public ArrayList<PSDepSlnSysKey> selectByPSDepSlnSys(PSDepSlnSysBase pSDepSlnSysBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEPSLNSYSID", (Object)pSDepSlnSysBase.getPSDepSlnSysId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDepSlnSysCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDepSlnSysCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDepSlnSysKey> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, "", -1);
    }

    public ArrayList<PSDepSlnSysKey> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, string, -1);
    }

    public ArrayList<PSDepSlnSysKey> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVCENTERID", (Object)pSDevCenterBase.getPSDevCenterId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevCenterCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevCenterCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDepSlnSysDynaInst(PSDepSlnSysDynaInst pSDepSlnSysDynaInst) throws Exception {
    }

    public void resetPSDepSlnSysDynaInst(PSDepSlnSysDynaInst pSDepSlnSysDynaInst) throws Exception {
        ArrayList<PSDepSlnSysKey> arrayList = this.selectByPSDepSlnSysDynaInst(pSDepSlnSysDynaInst);
        for (PSDepSlnSysKey pSDepSlnSysKey : arrayList) {
            PSDepSlnSysKey pSDepSlnSysKey2 = (PSDepSlnSysKey)this.getDEModel().createEntity();
            pSDepSlnSysKey2.setPSDepSlnSysKeyId(pSDepSlnSysKey.getPSDepSlnSysKeyId());
            pSDepSlnSysKey2.setPSDepSlnSysDynaInstId(null);
            this.update(pSDepSlnSysKey2);
        }
    }

    public void removeByPSDepSlnSysDynaInst(PSDepSlnSysDynaInst pSDepSlnSysDynaInst) throws Exception {
        final PSDepSlnSysDynaInst pSDepSlnSysDynaInst2 = pSDepSlnSysDynaInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnSysKeyServiceBase.this.onBeforeRemoveByPSDepSlnSysDynaInst(pSDepSlnSysDynaInst2);
                PSDepSlnSysKeyServiceBase.this.internalRemoveByPSDepSlnSysDynaInst(pSDepSlnSysDynaInst2);
                PSDepSlnSysKeyServiceBase.this.onAfterRemoveByPSDepSlnSysDynaInst(pSDepSlnSysDynaInst2);
            }
        });
    }

    protected void onBeforeRemoveByPSDepSlnSysDynaInst(PSDepSlnSysDynaInst pSDepSlnSysDynaInst) throws Exception {
    }

    protected void internalRemoveByPSDepSlnSysDynaInst(PSDepSlnSysDynaInst pSDepSlnSysDynaInst) throws Exception {
        ArrayList<PSDepSlnSysKey> arrayList = this.selectByPSDepSlnSysDynaInst(pSDepSlnSysDynaInst);
        this.onBeforeRemoveByPSDepSlnSysDynaInst(pSDepSlnSysDynaInst, arrayList);
        for (PSDepSlnSysKey pSDepSlnSysKey : arrayList) {
            this.remove(pSDepSlnSysKey);
        }
        this.onAfterRemoveByPSDepSlnSysDynaInst(pSDepSlnSysDynaInst, arrayList);
    }

    protected void onAfterRemoveByPSDepSlnSysDynaInst(PSDepSlnSysDynaInst pSDepSlnSysDynaInst) throws Exception {
    }

    protected void onBeforeRemoveByPSDepSlnSysDynaInst(PSDepSlnSysDynaInst pSDepSlnSysDynaInst, ArrayList<PSDepSlnSysKey> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDepSlnSysDynaInst(PSDepSlnSysDynaInst pSDepSlnSysDynaInst, ArrayList<PSDepSlnSysKey> arrayList) throws Exception {
    }

    public void testRemoveByPSDepSlnSys(PSDepSlnSys pSDepSlnSys) throws Exception {
    }

    public void resetPSDepSlnSys(PSDepSlnSys pSDepSlnSys) throws Exception {
        ArrayList<PSDepSlnSysKey> arrayList = this.selectByPSDepSlnSys(pSDepSlnSys);
        for (PSDepSlnSysKey pSDepSlnSysKey : arrayList) {
            PSDepSlnSysKey pSDepSlnSysKey2 = (PSDepSlnSysKey)this.getDEModel().createEntity();
            pSDepSlnSysKey2.setPSDepSlnSysKeyId(pSDepSlnSysKey.getPSDepSlnSysKeyId());
            pSDepSlnSysKey2.setPSDepSlnSysId(null);
            this.update(pSDepSlnSysKey2);
        }
    }

    public void removeByPSDepSlnSys(PSDepSlnSys pSDepSlnSys) throws Exception {
        final PSDepSlnSys pSDepSlnSys2 = pSDepSlnSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnSysKeyServiceBase.this.onBeforeRemoveByPSDepSlnSys(pSDepSlnSys2);
                PSDepSlnSysKeyServiceBase.this.internalRemoveByPSDepSlnSys(pSDepSlnSys2);
                PSDepSlnSysKeyServiceBase.this.onAfterRemoveByPSDepSlnSys(pSDepSlnSys2);
            }
        });
    }

    protected void onBeforeRemoveByPSDepSlnSys(PSDepSlnSys pSDepSlnSys) throws Exception {
    }

    protected void internalRemoveByPSDepSlnSys(PSDepSlnSys pSDepSlnSys) throws Exception {
        ArrayList<PSDepSlnSysKey> arrayList = this.selectByPSDepSlnSys(pSDepSlnSys);
        this.onBeforeRemoveByPSDepSlnSys(pSDepSlnSys, arrayList);
        for (PSDepSlnSysKey pSDepSlnSysKey : arrayList) {
            this.remove(pSDepSlnSysKey);
        }
        this.onAfterRemoveByPSDepSlnSys(pSDepSlnSys, arrayList);
    }

    protected void onAfterRemoveByPSDepSlnSys(PSDepSlnSys pSDepSlnSys) throws Exception {
    }

    protected void onBeforeRemoveByPSDepSlnSys(PSDepSlnSys pSDepSlnSys, ArrayList<PSDepSlnSysKey> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDepSlnSys(PSDepSlnSys pSDepSlnSys, ArrayList<PSDepSlnSysKey> arrayList) throws Exception {
    }

    public void testRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    public void resetPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDepSlnSysKey> arrayList = this.selectByPSDevCenter(pSDevCenter);
        for (PSDepSlnSysKey pSDepSlnSysKey : arrayList) {
            PSDepSlnSysKey pSDepSlnSysKey2 = (PSDepSlnSysKey)this.getDEModel().createEntity();
            pSDepSlnSysKey2.setPSDepSlnSysKeyId(pSDepSlnSysKey.getPSDepSlnSysKeyId());
            pSDepSlnSysKey2.setPSDevCenterId(null);
            this.update(pSDepSlnSysKey2);
        }
    }

    public void removeByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnSysKeyServiceBase.this.onBeforeRemoveByPSDevCenter(pSDevCenter2);
                PSDepSlnSysKeyServiceBase.this.internalRemoveByPSDevCenter(pSDevCenter2);
                PSDepSlnSysKeyServiceBase.this.onAfterRemoveByPSDevCenter(pSDevCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void internalRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDepSlnSysKey> arrayList = this.selectByPSDevCenter(pSDevCenter);
        this.onBeforeRemoveByPSDevCenter(pSDevCenter, arrayList);
        for (PSDepSlnSysKey pSDepSlnSysKey : arrayList) {
            this.remove(pSDepSlnSysKey);
        }
        this.onAfterRemoveByPSDevCenter(pSDevCenter, arrayList);
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDepSlnSysKey> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDepSlnSysKey> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDepSlnSysKey pSDepSlnSysKey) throws Exception {
        super.onBeforeRemove(pSDepSlnSysKey);
    }

    protected void replaceParentInfo(PSDepSlnSysKey pSDepSlnSysKey, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDepSlnSysKey, cloneSession);
        if (pSDepSlnSysKey.getPSDepSlnSysDynaInstId() != null && (iEntity = cloneSession.getEntity("PSDEPSLNSYSDYNAINST", (Object)pSDepSlnSysKey.getPSDepSlnSysDynaInstId())) != null) {
            this.onFillParentInfo_PSDepSlnSysDynaInst(pSDepSlnSysKey, (PSDepSlnSysDynaInst)iEntity);
        }
        if (pSDepSlnSysKey.getPSDepSlnSysId() != null && (iEntity = cloneSession.getEntity("PSDEPSLNSYS", (Object)pSDepSlnSysKey.getPSDepSlnSysId())) != null) {
            this.onFillParentInfo_PSDepSlnSys(pSDepSlnSysKey, (PSDepSlnSys)iEntity);
        }
        if (pSDepSlnSysKey.getPSDevCenterId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTER", (Object)pSDepSlnSysKey.getPSDevCenterId())) != null) {
            this.onFillParentInfo_PSDevCenter(pSDepSlnSysKey, (PSDevCenter)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDepSlnSysKey pSDepSlnSysKey, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDepSlnSysKey, bl);
    }

    protected void onCheckEntity(boolean bl, PSDepSlnSysKey pSDepSlnSysKey, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AdminMode(bl, pSDepSlnSysKey, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BeginTime(bl, pSDepSlnSysKey, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EndTime(bl, pSDepSlnSysKey, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_KeyCount(bl, pSDepSlnSysKey, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_KeyState(bl, pSDepSlnSysKey, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LoginUserFlag(bl, pSDepSlnSysKey, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LoginUserId(bl, pSDepSlnSysKey, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LoginUserName(bl, pSDepSlnSysKey, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnSysDynaInstId(bl, pSDepSlnSysKey, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnSysDynaInstName(bl, pSDepSlnSysKey, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnSysId(bl, pSDepSlnSysKey, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnSysKeyId(bl, pSDepSlnSysKey, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnSysKeyName(bl, pSDepSlnSysKey, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnSysName(bl, pSDepSlnSysKey, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterId(bl, pSDepSlnSysKey, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterName(bl, pSDepSlnSysKey, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDepSlnSysKey, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AdminMode(boolean bl, PSDepSlnSysKey pSDepSlnSysKey, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSysKey.isAdminModeDirty() : !pSDepSlnSysKey.isAdminModeDirty()) {
            return null;
        }
        Integer n = pSDepSlnSysKey.getAdminMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_AdminMode_Default(pSDepSlnSysKey, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ADMINMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BeginTime(boolean bl, PSDepSlnSysKey pSDepSlnSysKey, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSysKey.isBeginTimeDirty() : !pSDepSlnSysKey.isBeginTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDepSlnSysKey.getBeginTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_BeginTime_Default(pSDepSlnSysKey, bl2, bl3);
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

    protected EntityFieldError onCheckField_EndTime(boolean bl, PSDepSlnSysKey pSDepSlnSysKey, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSysKey.isEndTimeDirty() : !pSDepSlnSysKey.isEndTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDepSlnSysKey.getEndTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EndTime_Default(pSDepSlnSysKey, bl2, bl3);
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

    protected EntityFieldError onCheckField_KeyCount(boolean bl, PSDepSlnSysKey pSDepSlnSysKey, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSysKey.isKeyCountDirty() : !pSDepSlnSysKey.isKeyCountDirty()) {
            return null;
        }
        Integer n = pSDepSlnSysKey.getKeyCount();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_KeyCount_Default(pSDepSlnSysKey, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("KEYCOUNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_KeyState(boolean bl, PSDepSlnSysKey pSDepSlnSysKey, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSysKey.isKeyStateDirty() : !pSDepSlnSysKey.isKeyStateDirty()) {
            return null;
        }
        Integer n = pSDepSlnSysKey.getKeyState();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_KeyState_Default(pSDepSlnSysKey, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("KEYSTATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LoginUserFlag(boolean bl, PSDepSlnSysKey pSDepSlnSysKey, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSysKey.isLoginUserFlagDirty() : !pSDepSlnSysKey.isLoginUserFlagDirty()) {
            return null;
        }
        Integer n = pSDepSlnSysKey.getLoginUserFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LoginUserFlag_Default(pSDepSlnSysKey, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGINUSERFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LoginUserId(boolean bl, PSDepSlnSysKey pSDepSlnSysKey, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSysKey.isLoginUserIdDirty() : !pSDepSlnSysKey.isLoginUserIdDirty()) {
            return null;
        }
        String string = pSDepSlnSysKey.getLoginUserId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LoginUserId_Default(pSDepSlnSysKey, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGINUSERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LoginUserName(boolean bl, PSDepSlnSysKey pSDepSlnSysKey, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSysKey.isLoginUserNameDirty() : !pSDepSlnSysKey.isLoginUserNameDirty()) {
            return null;
        }
        String string = pSDepSlnSysKey.getLoginUserName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LoginUserName_Default(pSDepSlnSysKey, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGINUSERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnSysDynaInstId(boolean bl, PSDepSlnSysKey pSDepSlnSysKey, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSysKey.isPSDepSlnSysDynaInstIdDirty() : !pSDepSlnSysKey.isPSDepSlnSysDynaInstIdDirty()) {
            return null;
        }
        String string = pSDepSlnSysKey.getPSDepSlnSysDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnSysDynaInstId_Default(pSDepSlnSysKey, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNSYSDYNAINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnSysDynaInstName(boolean bl, PSDepSlnSysKey pSDepSlnSysKey, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSysKey.isPSDepSlnSysDynaInstNameDirty() : !pSDepSlnSysKey.isPSDepSlnSysDynaInstNameDirty()) {
            return null;
        }
        String string = pSDepSlnSysKey.getPSDepSlnSysDynaInstName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnSysDynaInstName_Default(pSDepSlnSysKey, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNSYSDYNAINSTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnSysId(boolean bl, PSDepSlnSysKey pSDepSlnSysKey, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSysKey.isPSDepSlnSysIdDirty() : !pSDepSlnSysKey.isPSDepSlnSysIdDirty()) {
            return null;
        }
        String string = pSDepSlnSysKey.getPSDepSlnSysId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnSysId_Default(pSDepSlnSysKey, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNSYSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnSysKeyId(boolean bl, PSDepSlnSysKey pSDepSlnSysKey, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSysKey.isPSDepSlnSysKeyIdDirty() && !bl2 : !pSDepSlnSysKey.isPSDepSlnSysKeyIdDirty()) {
            return null;
        }
        String string = pSDepSlnSysKey.getPSDepSlnSysKeyId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNSYSKEYID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnSysKeyId_Default(pSDepSlnSysKey, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNSYSKEYID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnSysKeyName(boolean bl, PSDepSlnSysKey pSDepSlnSysKey, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSysKey.isPSDepSlnSysKeyNameDirty() && !bl2 : !pSDepSlnSysKey.isPSDepSlnSysKeyNameDirty()) {
            return null;
        }
        String string = pSDepSlnSysKey.getPSDepSlnSysKeyName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNSYSKEYNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnSysKeyName_Default(pSDepSlnSysKey, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNSYSKEYNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnSysName(boolean bl, PSDepSlnSysKey pSDepSlnSysKey, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSysKey.isPSDepSlnSysNameDirty() : !pSDepSlnSysKey.isPSDepSlnSysNameDirty()) {
            return null;
        }
        String string = pSDepSlnSysKey.getPSDepSlnSysName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnSysName_Default(pSDepSlnSysKey, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNSYSNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterId(boolean bl, PSDepSlnSysKey pSDepSlnSysKey, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSysKey.isPSDevCenterIdDirty() : !pSDepSlnSysKey.isPSDevCenterIdDirty()) {
            return null;
        }
        String string = pSDepSlnSysKey.getPSDevCenterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterId_Default(pSDepSlnSysKey, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterName(boolean bl, PSDepSlnSysKey pSDepSlnSysKey, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSysKey.isPSDevCenterNameDirty() : !pSDepSlnSysKey.isPSDevCenterNameDirty()) {
            return null;
        }
        String string = pSDepSlnSysKey.getPSDevCenterName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterName_Default(pSDepSlnSysKey, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDepSlnSysKey pSDepSlnSysKey, boolean bl) throws Exception {
        super.onSyncEntity(pSDepSlnSysKey, bl);
    }

    protected void onSyncIndexEntities(PSDepSlnSysKey pSDepSlnSysKey, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDepSlnSysKey, bl);
    }

    public Object getDataContextValue(PSDepSlnSysKey pSDepSlnSysKey, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDepSlnSysKey, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDepSlnSysKey pSDepSlnSysKey, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDepSlnSysKey, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ADMINMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AdminMode_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"KEYCOUNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_KeyCount_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"KEYSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_KeyState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGINUSERFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LoginUserFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGINUSERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LoginUserId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGINUSERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LoginUserName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNSYSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnSysDynaInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNSYSDYNAINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnSysDynaInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNSYSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnSysId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNSYSKEYID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnSysKeyId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNSYSKEYNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnSysKeyName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNSYSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnSysName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_AdminMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_KeyCount_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_KeyState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LoginUserFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LoginUserId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOGINUSERID", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LoginUserName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOGINUSERNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnSysDynaInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNSYSDYNAINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnSysDynaInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNSYSDYNAINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnSysId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNSYSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnSysKeyId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNSYSKEYID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnSysKeyName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNSYSKEYNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnSysName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNSYSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDepSlnSysKey pSDepSlnSysKey) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDepSlnSysKey)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDepSlnSysKey pSDepSlnSysKey) throws Exception {
        super.onUpdateParent(pSDepSlnSysKey);
    }

    @Override
    protected void exportCurXmlModel(PSDepSlnSysKey pSDepSlnSysKey, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEPSLNSYSKEY");
        if (!bl) {
            pSDepSlnSysKey.setCreateDate(null);
            pSDepSlnSysKey.setCreateMan(null);
            pSDepSlnSysKey.setPSDepSlnSysKeyId(null);
            pSDepSlnSysKey.setUpdateDate(null);
            pSDepSlnSysKey.setUpdateMan(null);
            super.exportCurXmlModel(pSDepSlnSysKey, xmlNode, bl);
        }
    }
}

