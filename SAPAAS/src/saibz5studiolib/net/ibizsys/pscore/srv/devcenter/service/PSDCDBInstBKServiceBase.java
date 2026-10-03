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
package net.ibizsys.pscore.srv.devcenter.service;

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
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.devcenter.dao.PSDCDBInstBKDAO;
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCDBInstBKDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCDBInstBK;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCDBInstBKBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterDBInst;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterDBInstBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCDBInstBKService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDBDevInstBK;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDBDevInstBKBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServerBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCDBInstBKServiceBase
extends PSCoreSysServiceBase<PSDCDBInstBK> {
    private static final Log log = LogFactory.getLog(PSDCDBInstBKServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDCDBInstBKDEModel pSDCDBInstBKDEModel;
    private PSDCDBInstBKDAO pSDCDBInstBKDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.devcenter.service.PSDCDBInstBKService";
    }

    public PSDCDBInstBKDEModel getPSDCDBInstBKDEModel() {
        if (this.pSDCDBInstBKDEModel == null) {
            try {
                this.pSDCDBInstBKDEModel = (PSDCDBInstBKDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCDBInstBKDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCDBInstBKDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDCDBInstBKDEModel();
    }

    public PSDCDBInstBKDAO getPSDCDBInstBKDAO() {
        if (this.pSDCDBInstBKDAO == null) {
            try {
                this.pSDCDBInstBKDAO = (PSDCDBInstBKDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.devcenter.dao.PSDCDBInstBKDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCDBInstBKDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDCDBInstBKDAO();
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

    protected void onFillParentInfo(PSDCDBInstBK pSDCDBInstBK, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCDBINSTBK_PSDBDEVINSTBK_PSDBDEVINSTBKID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSDBDevInstBKService", (SessionFactory)this.getSessionFactory());
            PSDBDevInstBK pSDBDevInstBK = (PSDBDevInstBK)iService.getDEModel().createEntity();
            pSDBDevInstBK.set("PSDBDEVINSTBKID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDBDevInstBK);
            } else {
                iService.get(pSDBDevInstBK);
            }
            this.onFillParentInfo_PSDBDevInstBK(pSDCDBInstBK, pSDBDevInstBK);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCDBINSTBK_PSDCDBINSTBK_PPSDCDBINSTBKID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCDBInstBKService", (SessionFactory)this.getSessionFactory());
            PSDCDBInstBK pSDCDBInstBK2 = (PSDCDBInstBK)iService.getDEModel().createEntity();
            pSDCDBInstBK2.set("PSDCDBINSTBKID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDCDBInstBK2);
            } else {
                iService.get(pSDCDBInstBK2);
            }
            this.onFillParentInfo_PPSDCDBInstBK(pSDCDBInstBK, pSDCDBInstBK2);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCDBINSTBK_PSDEVCENTERDBINST_PSDEVCENTERDBINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService", (SessionFactory)this.getSessionFactory());
            PSDevCenterDBInst pSDevCenterDBInst = (PSDevCenterDBInst)iService.getDEModel().createEntity();
            pSDevCenterDBInst.set("PSDEVCENTERDBINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenterDBInst);
            } else {
                iService.get(pSDevCenterDBInst);
            }
            this.onFillParentInfo_PSDevCenterDBInst(pSDCDBInstBK, pSDevCenterDBInst);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCDBINSTBK_PSDEVCENTER_PSDEVCENTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService", (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = (PSDevCenter)iService.getDEModel().createEntity();
            pSDevCenter.set("PSDEVCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenter);
            } else {
                iService.get(pSDevCenter);
            }
            this.onFillParentInfo_PSDevCenter(pSDCDBInstBK, pSDevCenter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCDBINSTBK_PSTASKSERVER_PSTASKSERVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSTaskServerService", (SessionFactory)this.getSessionFactory());
            PSTaskServer pSTaskServer = (PSTaskServer)iService.getDEModel().createEntity();
            pSTaskServer.set("PSTASKSERVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSTaskServer);
            } else {
                iService.get(pSTaskServer);
            }
            this.onFillParentInfo_PSTaskServer(pSDCDBInstBK, pSTaskServer);
            return;
        }
        super.onFillParentInfo(pSDCDBInstBK, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDBDevInstBK(PSDCDBInstBK pSDCDBInstBK, PSDBDevInstBK pSDBDevInstBK) throws Exception {
        pSDCDBInstBK.setPSDBDevInstBKId(pSDBDevInstBK.getPSDBDevInstBKId());
        pSDCDBInstBK.setPSDBDevInstBKName(pSDBDevInstBK.getPSDBDevInstBKName());
    }

    protected void onFillParentInfo_PPSDCDBInstBK(PSDCDBInstBK pSDCDBInstBK, PSDCDBInstBK pSDCDBInstBK2) throws Exception {
        pSDCDBInstBK.setPPSDCDBInstBKId(pSDCDBInstBK2.getPSDCDBInstBKId());
        pSDCDBInstBK.setPPSDCDBInstBKName(pSDCDBInstBK2.getPSDCDBInstBKName());
    }

    protected void onFillParentInfo_PSDevCenterDBInst(PSDCDBInstBK pSDCDBInstBK, PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        pSDCDBInstBK.setPSDevCenterDBInstId(pSDevCenterDBInst.getPSDevCenterDBInstId());
        pSDCDBInstBK.setPSDevCenterDBInstName(pSDevCenterDBInst.getPSDevCenterDBInstName());
    }

    protected void onFillParentInfo_PSDevCenter(PSDCDBInstBK pSDCDBInstBK, PSDevCenter pSDevCenter) throws Exception {
        pSDCDBInstBK.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
        pSDCDBInstBK.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
    }

    protected void onFillParentInfo_PSTaskServer(PSDCDBInstBK pSDCDBInstBK, PSTaskServer pSTaskServer) throws Exception {
        pSDCDBInstBK.setPSTaskServerId(pSTaskServer.getPSTaskServerId());
        pSDCDBInstBK.setPSTaskServerName(pSTaskServer.getPSTaskServerName());
    }

    protected void onFillEntityFullInfo(PSDCDBInstBK pSDCDBInstBK, boolean bl) throws Exception {
        if (bl && pSDCDBInstBK.getBKState() == null) {
            pSDCDBInstBK.setBKState((Integer)this.getDefaultValue(this.getWebContext(), "", "10", 9));
        }
        super.onFillEntityFullInfo(pSDCDBInstBK, bl);
        this.onFillEntityFullInfo_PSDBDevInstBK(pSDCDBInstBK, bl);
        this.onFillEntityFullInfo_PPSDCDBInstBK(pSDCDBInstBK, bl);
        this.onFillEntityFullInfo_PSDevCenterDBInst(pSDCDBInstBK, bl);
        this.onFillEntityFullInfo_PSDevCenter(pSDCDBInstBK, bl);
        this.onFillEntityFullInfo_PSTaskServer(pSDCDBInstBK, bl);
    }

    protected void onFillEntityFullInfo_PSDBDevInstBK(PSDCDBInstBK pSDCDBInstBK, boolean bl) throws Exception {
        if (pSDCDBInstBK.isPSDBDevInstBKIdDirty()) {
            if (pSDCDBInstBK.getPSDBDevInstBKId() != null) {
                if (pSDCDBInstBK.getPSDBDevInstBKId() == null || pSDCDBInstBK.getPSDBDevInstBKName() == null) {
                    PSDBDevInstBK pSDBDevInstBK = pSDCDBInstBK.getPSDBDevInstBK();
                    pSDCDBInstBK.setPSDBDevInstBKName(pSDBDevInstBK.getPSDBDevInstBKName());
                }
            } else {
                pSDCDBInstBK.setPSDBDevInstBKName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PPSDCDBInstBK(PSDCDBInstBK pSDCDBInstBK, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevCenterDBInst(PSDCDBInstBK pSDCDBInstBK, boolean bl) throws Exception {
        if (pSDCDBInstBK.isPSDevCenterDBInstIdDirty()) {
            if (pSDCDBInstBK.getPSDevCenterDBInstId() != null) {
                if (pSDCDBInstBK.getPSDevCenterDBInstId() == null || pSDCDBInstBK.getPSDevCenterDBInstName() == null) {
                    PSDevCenterDBInst pSDevCenterDBInst = pSDCDBInstBK.getPSDevCenterDBInst();
                    pSDCDBInstBK.setPSDevCenterDBInstName(pSDevCenterDBInst.getPSDevCenterDBInstName());
                }
            } else {
                pSDCDBInstBK.setPSDevCenterDBInstName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDevCenter(PSDCDBInstBK pSDCDBInstBK, boolean bl) throws Exception {
        if (pSDCDBInstBK.isPSDevCenterIdDirty()) {
            if (pSDCDBInstBK.getPSDevCenterId() != null) {
                if (pSDCDBInstBK.getPSDevCenterId() == null || pSDCDBInstBK.getPSDevCenterName() == null) {
                    PSDevCenter pSDevCenter = pSDCDBInstBK.getPSDevCenter();
                    pSDCDBInstBK.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
                }
            } else {
                pSDCDBInstBK.setPSDevCenterName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSTaskServer(PSDCDBInstBK pSDCDBInstBK, boolean bl) throws Exception {
        if (pSDCDBInstBK.isPSTaskServerIdDirty()) {
            if (pSDCDBInstBK.getPSTaskServerId() != null) {
                if (pSDCDBInstBK.getPSTaskServerId() == null || pSDCDBInstBK.getPSTaskServerName() == null) {
                    PSTaskServer pSTaskServer = pSDCDBInstBK.getPSTaskServer();
                    pSDCDBInstBK.setPSTaskServerName(pSTaskServer.getPSTaskServerName());
                }
            } else {
                pSDCDBInstBK.setPSTaskServerName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDCDBInstBK pSDCDBInstBK, boolean bl) throws Exception {
        super.onWriteBackParent(pSDCDBInstBK, bl);
    }

    public ArrayList<PSDCDBInstBK> selectByPSDBDevInstBK(PSDBDevInstBKBase pSDBDevInstBKBase) throws Exception {
        return this.selectByPSDBDevInstBK(pSDBDevInstBKBase, "", -1);
    }

    public ArrayList<PSDCDBInstBK> selectByPSDBDevInstBK(PSDBDevInstBKBase pSDBDevInstBKBase, String string) throws Exception {
        return this.selectByPSDBDevInstBK(pSDBDevInstBKBase, string, -1);
    }

    public ArrayList<PSDCDBInstBK> selectByPSDBDevInstBK(PSDBDevInstBKBase pSDBDevInstBKBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDBDEVINSTBKID", (Object)pSDBDevInstBKBase.getPSDBDevInstBKId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDBDevInstBKCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDBDevInstBKCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDCDBInstBK> selectByPPSDCDBInstBK(PSDCDBInstBKBase pSDCDBInstBKBase) throws Exception {
        return this.selectByPPSDCDBInstBK(pSDCDBInstBKBase, "", -1);
    }

    public ArrayList<PSDCDBInstBK> selectByPPSDCDBInstBK(PSDCDBInstBKBase pSDCDBInstBKBase, String string) throws Exception {
        return this.selectByPPSDCDBInstBK(pSDCDBInstBKBase, string, -1);
    }

    public ArrayList<PSDCDBInstBK> selectByPPSDCDBInstBK(PSDCDBInstBKBase pSDCDBInstBKBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSDCDBINSTBKID", (Object)pSDCDBInstBKBase.getPSDCDBInstBKId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPPSDCDBInstBKCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPPSDCDBInstBKCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDCDBInstBK> selectByPSDevCenterDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase) throws Exception {
        return this.selectByPSDevCenterDBInst(pSDevCenterDBInstBase, "", -1);
    }

    public ArrayList<PSDCDBInstBK> selectByPSDevCenterDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase, String string) throws Exception {
        return this.selectByPSDevCenterDBInst(pSDevCenterDBInstBase, string, -1);
    }

    public ArrayList<PSDCDBInstBK> selectByPSDevCenterDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVCENTERDBINSTID", (Object)pSDevCenterDBInstBase.getPSDevCenterDBInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevCenterDBInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevCenterDBInstCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDCDBInstBK> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, "", -1);
    }

    public ArrayList<PSDCDBInstBK> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, string, -1);
    }

    public ArrayList<PSDCDBInstBK> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string, int n) throws Exception {
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

    public ArrayList<PSDCDBInstBK> selectByPSTaskServer(PSTaskServerBase pSTaskServerBase) throws Exception {
        return this.selectByPSTaskServer(pSTaskServerBase, "", -1);
    }

    public ArrayList<PSDCDBInstBK> selectByPSTaskServer(PSTaskServerBase pSTaskServerBase, String string) throws Exception {
        return this.selectByPSTaskServer(pSTaskServerBase, string, -1);
    }

    public ArrayList<PSDCDBInstBK> selectByPSTaskServer(PSTaskServerBase pSTaskServerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSTASKSERVERID", (Object)pSTaskServerBase.getPSTaskServerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSTaskServerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSTaskServerCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDBDevInstBK(PSDBDevInstBK pSDBDevInstBK) throws Exception {
    }

    public void resetPSDBDevInstBK(PSDBDevInstBK pSDBDevInstBK) throws Exception {
        ArrayList<PSDCDBInstBK> arrayList = this.selectByPSDBDevInstBK(pSDBDevInstBK);
        for (PSDCDBInstBK pSDCDBInstBK : arrayList) {
            PSDCDBInstBK pSDCDBInstBK2 = (PSDCDBInstBK)this.getDEModel().createEntity();
            pSDCDBInstBK2.setPSDCDBInstBKId(pSDCDBInstBK.getPSDCDBInstBKId());
            pSDCDBInstBK2.setPSDBDevInstBKId(null);
            this.update(pSDCDBInstBK2);
        }
    }

    public void removeByPSDBDevInstBK(PSDBDevInstBK pSDBDevInstBK) throws Exception {
        final PSDBDevInstBK pSDBDevInstBK2 = pSDBDevInstBK;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCDBInstBKServiceBase.this.onBeforeRemoveByPSDBDevInstBK(pSDBDevInstBK2);
                PSDCDBInstBKServiceBase.this.internalRemoveByPSDBDevInstBK(pSDBDevInstBK2);
                PSDCDBInstBKServiceBase.this.onAfterRemoveByPSDBDevInstBK(pSDBDevInstBK2);
            }
        });
    }

    protected void onBeforeRemoveByPSDBDevInstBK(PSDBDevInstBK pSDBDevInstBK) throws Exception {
    }

    protected void internalRemoveByPSDBDevInstBK(PSDBDevInstBK pSDBDevInstBK) throws Exception {
        ArrayList<PSDCDBInstBK> arrayList = this.selectByPSDBDevInstBK(pSDBDevInstBK);
        this.onBeforeRemoveByPSDBDevInstBK(pSDBDevInstBK, arrayList);
        for (PSDCDBInstBK pSDCDBInstBK : arrayList) {
            this.remove(pSDCDBInstBK);
        }
        this.onAfterRemoveByPSDBDevInstBK(pSDBDevInstBK, arrayList);
    }

    protected void onAfterRemoveByPSDBDevInstBK(PSDBDevInstBK pSDBDevInstBK) throws Exception {
    }

    protected void onBeforeRemoveByPSDBDevInstBK(PSDBDevInstBK pSDBDevInstBK, ArrayList<PSDCDBInstBK> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDBDevInstBK(PSDBDevInstBK pSDBDevInstBK, ArrayList<PSDCDBInstBK> arrayList) throws Exception {
    }

    public void testRemoveByPPSDCDBInstBK(PSDCDBInstBK pSDCDBInstBK) throws Exception {
        ArrayList<PSDCDBInstBK> arrayList = this.selectByPPSDCDBInstBK(pSDCDBInstBK, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCDBINSTBK");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDCDBInstBK);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCDBINSTBK_PSDCDBINSTBK_PPSDCDBINSTBKID", "", iDataEntityModel.getName(), "PSDCDBINSTBK", iDataEntityModel.getDataInfo(pSDCDBInstBK), arrayList.get(0)));
        }
    }

    public void resetPPSDCDBInstBK(PSDCDBInstBK pSDCDBInstBK) throws Exception {
        ArrayList<PSDCDBInstBK> arrayList = this.selectByPPSDCDBInstBK(pSDCDBInstBK);
        for (PSDCDBInstBK pSDCDBInstBK2 : arrayList) {
            PSDCDBInstBK pSDCDBInstBK3 = (PSDCDBInstBK)this.getDEModel().createEntity();
            pSDCDBInstBK3.setPSDCDBInstBKId(pSDCDBInstBK2.getPSDCDBInstBKId());
            pSDCDBInstBK3.setPPSDCDBInstBKId(null);
            this.update(pSDCDBInstBK3);
        }
    }

    public void removeByPPSDCDBInstBK(PSDCDBInstBK pSDCDBInstBK) throws Exception {
        final PSDCDBInstBK pSDCDBInstBK2 = pSDCDBInstBK;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCDBInstBKServiceBase.this.onBeforeRemoveByPPSDCDBInstBK(pSDCDBInstBK2);
                PSDCDBInstBKServiceBase.this.internalRemoveByPPSDCDBInstBK(pSDCDBInstBK2);
                PSDCDBInstBKServiceBase.this.onAfterRemoveByPPSDCDBInstBK(pSDCDBInstBK2);
            }
        });
    }

    protected void onBeforeRemoveByPPSDCDBInstBK(PSDCDBInstBK pSDCDBInstBK) throws Exception {
    }

    protected void internalRemoveByPPSDCDBInstBK(PSDCDBInstBK pSDCDBInstBK) throws Exception {
        ArrayList<PSDCDBInstBK> arrayList = this.selectByPPSDCDBInstBK(pSDCDBInstBK);
        this.onBeforeRemoveByPPSDCDBInstBK(pSDCDBInstBK, arrayList);
        for (PSDCDBInstBK pSDCDBInstBK2 : arrayList) {
            this.remove(pSDCDBInstBK2);
        }
        this.onAfterRemoveByPPSDCDBInstBK(pSDCDBInstBK, arrayList);
    }

    protected void onAfterRemoveByPPSDCDBInstBK(PSDCDBInstBK pSDCDBInstBK) throws Exception {
    }

    protected void onBeforeRemoveByPPSDCDBInstBK(PSDCDBInstBK pSDCDBInstBK, ArrayList<PSDCDBInstBK> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPPSDCDBInstBK(PSDCDBInstBK pSDCDBInstBK, ArrayList<PSDCDBInstBK> arrayList) throws Exception {
    }

    public void testRemoveByPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
    }

    public void resetPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDCDBInstBK> arrayList = this.selectByPSDevCenterDBInst(pSDevCenterDBInst);
        for (PSDCDBInstBK pSDCDBInstBK : arrayList) {
            PSDCDBInstBK pSDCDBInstBK2 = (PSDCDBInstBK)this.getDEModel().createEntity();
            pSDCDBInstBK2.setPSDCDBInstBKId(pSDCDBInstBK.getPSDCDBInstBKId());
            pSDCDBInstBK2.setPSDevCenterDBInstId(null);
            this.update(pSDCDBInstBK2);
        }
    }

    public void removeByPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        final PSDevCenterDBInst pSDevCenterDBInst2 = pSDevCenterDBInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCDBInstBKServiceBase.this.onBeforeRemoveByPSDevCenterDBInst(pSDevCenterDBInst2);
                PSDCDBInstBKServiceBase.this.internalRemoveByPSDevCenterDBInst(pSDevCenterDBInst2);
                PSDCDBInstBKServiceBase.this.onAfterRemoveByPSDevCenterDBInst(pSDevCenterDBInst2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
    }

    protected void internalRemoveByPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDCDBInstBK> arrayList = this.selectByPSDevCenterDBInst(pSDevCenterDBInst);
        this.onBeforeRemoveByPSDevCenterDBInst(pSDevCenterDBInst, arrayList);
        for (PSDCDBInstBK pSDCDBInstBK : arrayList) {
            this.remove(pSDCDBInstBK);
        }
        this.onAfterRemoveByPSDevCenterDBInst(pSDevCenterDBInst, arrayList);
    }

    protected void onAfterRemoveByPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst, ArrayList<PSDCDBInstBK> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst, ArrayList<PSDCDBInstBK> arrayList) throws Exception {
    }

    public void testRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDCDBInstBK> arrayList = this.selectByPSDevCenter(pSDevCenter, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenter);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCDBINSTBK_PSDEVCENTER_PSDEVCENTERID", "", iDataEntityModel.getName(), "PSDCDBINSTBK", iDataEntityModel.getDataInfo(pSDevCenter), arrayList.get(0)));
        }
    }

    public void resetPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDCDBInstBK> arrayList = this.selectByPSDevCenter(pSDevCenter);
        for (PSDCDBInstBK pSDCDBInstBK : arrayList) {
            PSDCDBInstBK pSDCDBInstBK2 = (PSDCDBInstBK)this.getDEModel().createEntity();
            pSDCDBInstBK2.setPSDCDBInstBKId(pSDCDBInstBK.getPSDCDBInstBKId());
            pSDCDBInstBK2.setPSDevCenterId(null);
            this.update(pSDCDBInstBK2);
        }
    }

    public void removeByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCDBInstBKServiceBase.this.onBeforeRemoveByPSDevCenter(pSDevCenter2);
                PSDCDBInstBKServiceBase.this.internalRemoveByPSDevCenter(pSDevCenter2);
                PSDCDBInstBKServiceBase.this.onAfterRemoveByPSDevCenter(pSDevCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void internalRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDCDBInstBK> arrayList = this.selectByPSDevCenter(pSDevCenter);
        this.onBeforeRemoveByPSDevCenter(pSDevCenter, arrayList);
        for (PSDCDBInstBK pSDCDBInstBK : arrayList) {
            this.remove(pSDCDBInstBK);
        }
        this.onAfterRemoveByPSDevCenter(pSDevCenter, arrayList);
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDCDBInstBK> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDCDBInstBK> arrayList) throws Exception {
    }

    public void testRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
    }

    public void resetPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
        ArrayList<PSDCDBInstBK> arrayList = this.selectByPSTaskServer(pSTaskServer);
        for (PSDCDBInstBK pSDCDBInstBK : arrayList) {
            PSDCDBInstBK pSDCDBInstBK2 = (PSDCDBInstBK)this.getDEModel().createEntity();
            pSDCDBInstBK2.setPSDCDBInstBKId(pSDCDBInstBK.getPSDCDBInstBKId());
            pSDCDBInstBK2.setPSTaskServerId(null);
            this.update(pSDCDBInstBK2);
        }
    }

    public void removeByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
        final PSTaskServer pSTaskServer2 = pSTaskServer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCDBInstBKServiceBase.this.onBeforeRemoveByPSTaskServer(pSTaskServer2);
                PSDCDBInstBKServiceBase.this.internalRemoveByPSTaskServer(pSTaskServer2);
                PSDCDBInstBKServiceBase.this.onAfterRemoveByPSTaskServer(pSTaskServer2);
            }
        });
    }

    protected void onBeforeRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
    }

    protected void internalRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
        ArrayList<PSDCDBInstBK> arrayList = this.selectByPSTaskServer(pSTaskServer);
        this.onBeforeRemoveByPSTaskServer(pSTaskServer, arrayList);
        for (PSDCDBInstBK pSDCDBInstBK : arrayList) {
            this.remove(pSDCDBInstBK);
        }
        this.onAfterRemoveByPSTaskServer(pSTaskServer, arrayList);
    }

    protected void onAfterRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
    }

    protected void onBeforeRemoveByPSTaskServer(PSTaskServer pSTaskServer, ArrayList<PSDCDBInstBK> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSTaskServer(PSTaskServer pSTaskServer, ArrayList<PSDCDBInstBK> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDCDBInstBK pSDCDBInstBK) throws Exception {
        PSDCDBInstBKService pSDCDBInstBKService = (PSDCDBInstBKService)ServiceGlobal.getService(PSDCDBInstBKService.class, (SessionFactory)this.getSessionFactory());
        pSDCDBInstBKService.testRemoveByPPSDCDBInstBK(pSDCDBInstBK);
        super.onBeforeRemove(pSDCDBInstBK);
    }

    protected void replaceParentInfo(PSDCDBInstBK pSDCDBInstBK, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDCDBInstBK, cloneSession);
        if (pSDCDBInstBK.getPSDBDevInstBKId() != null && (iEntity = cloneSession.getEntity("PSDBDEVINSTBK", (Object)pSDCDBInstBK.getPSDBDevInstBKId())) != null) {
            this.onFillParentInfo_PSDBDevInstBK(pSDCDBInstBK, (PSDBDevInstBK)iEntity);
        }
        if (pSDCDBInstBK.getPPSDCDBInstBKId() != null && (iEntity = cloneSession.getEntity("PSDCDBINSTBK", (Object)pSDCDBInstBK.getPPSDCDBInstBKId())) != null) {
            this.onFillParentInfo_PPSDCDBInstBK(pSDCDBInstBK, (PSDCDBInstBK)iEntity);
        }
        if (pSDCDBInstBK.getPSDevCenterDBInstId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERDBINST", (Object)pSDCDBInstBK.getPSDevCenterDBInstId())) != null) {
            this.onFillParentInfo_PSDevCenterDBInst(pSDCDBInstBK, (PSDevCenterDBInst)iEntity);
        }
        if (pSDCDBInstBK.getPSDevCenterId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTER", (Object)pSDCDBInstBK.getPSDevCenterId())) != null) {
            this.onFillParentInfo_PSDevCenter(pSDCDBInstBK, (PSDevCenter)iEntity);
        }
        if (pSDCDBInstBK.getPSTaskServerId() != null && (iEntity = cloneSession.getEntity("PSTASKSERVER", (Object)pSDCDBInstBK.getPSTaskServerId())) != null) {
            this.onFillParentInfo_PSTaskServer(pSDCDBInstBK, (PSTaskServer)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDCDBInstBK pSDCDBInstBK, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDCDBInstBK, bl);
    }

    protected void onCheckEntity(boolean bl, PSDCDBInstBK pSDCDBInstBK, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_BackupSize(bl, pSDCDBInstBK, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BKFilePath(bl, pSDCDBInstBK, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BKInfo(bl, pSDCDBInstBK, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BackupMode(bl, pSDCDBInstBK, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BKState(bl, pSDCDBInstBK, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BKTime(bl, pSDCDBInstBK, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DBType(bl, pSDCDBInstBK, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FullBKFilePath(bl, pSDCDBInstBK, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDCDBInstBK, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Passwd(bl, pSDCDBInstBK, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSDCDBInstBKId(bl, pSDCDBInstBK, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDBDevInstBKId(bl, pSDCDBInstBK, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDBDevInstBKName(bl, pSDCDBInstBK, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCDBInstBKId(bl, pSDCDBInstBK, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCDBInstBKName(bl, pSDCDBInstBK, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterDBInstId(bl, pSDCDBInstBK, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterDBInstName(bl, pSDCDBInstBK, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterId(bl, pSDCDBInstBK, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterName(bl, pSDCDBInstBK, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSTaskServerId(bl, pSDCDBInstBK, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSTaskServerName(bl, pSDCDBInstBK, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDCDBInstBK, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_BackupSize(boolean bl, PSDCDBInstBK pSDCDBInstBK, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDBInstBK.isBackupSizeDirty() : !pSDCDBInstBK.isBackupSizeDirty()) {
            return null;
        }
        Integer n = pSDCDBInstBK.getBackupSize();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_BackupSize_Default(pSDCDBInstBK, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BACKUPSIZE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BKFilePath(boolean bl, PSDCDBInstBK pSDCDBInstBK, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDBInstBK.isBKFilePathDirty() : !pSDCDBInstBK.isBKFilePathDirty()) {
            return null;
        }
        String string = pSDCDBInstBK.getBKFilePath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BKFilePath_Default(pSDCDBInstBK, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BKFILEPATH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BKInfo(boolean bl, PSDCDBInstBK pSDCDBInstBK, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDBInstBK.isBKInfoDirty() : !pSDCDBInstBK.isBKInfoDirty()) {
            return null;
        }
        String string = pSDCDBInstBK.getBKInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BKInfo_Default(pSDCDBInstBK, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BKINFO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BackupMode(boolean bl, PSDCDBInstBK pSDCDBInstBK, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDBInstBK.isBackupModeDirty() && !bl2 : !pSDCDBInstBK.isBackupModeDirty()) {
            return null;
        }
        Integer n = pSDCDBInstBK.getBackupMode();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BKMODE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_BackupMode_Default(pSDCDBInstBK, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BKMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BKState(boolean bl, PSDCDBInstBK pSDCDBInstBK, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDBInstBK.isBKStateDirty() && !bl2 : !pSDCDBInstBK.isBKStateDirty()) {
            return null;
        }
        Integer n = pSDCDBInstBK.getBKState();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BKSTATE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_BKState_Default(pSDCDBInstBK, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BKSTATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BKTime(boolean bl, PSDCDBInstBK pSDCDBInstBK, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDBInstBK.isBKTimeDirty() : !pSDCDBInstBK.isBKTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDCDBInstBK.getBKTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_BKTime_Default(pSDCDBInstBK, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BKTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DBType(boolean bl, PSDCDBInstBK pSDCDBInstBK, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDBInstBK.isDBTypeDirty() && !bl2 : !pSDCDBInstBK.isDBTypeDirty()) {
            return null;
        }
        String string = pSDCDBInstBK.getDBType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DBTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_DBType_Default(pSDCDBInstBK, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DBTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FullBKFilePath(boolean bl, PSDCDBInstBK pSDCDBInstBK, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDBInstBK.isFullBKFilePathDirty() : !pSDCDBInstBK.isFullBKFilePathDirty()) {
            return null;
        }
        String string = pSDCDBInstBK.getFullBKFilePath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FullBKFilePath_Default(pSDCDBInstBK, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FULLBKFILEPATH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDCDBInstBK pSDCDBInstBK, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDBInstBK.isMemoDirty() : !pSDCDBInstBK.isMemoDirty()) {
            return null;
        }
        String string = pSDCDBInstBK.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDCDBInstBK, bl2, bl3);
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

    protected EntityFieldError onCheckField_Passwd(boolean bl, PSDCDBInstBK pSDCDBInstBK, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDBInstBK.isPasswdDirty() : !pSDCDBInstBK.isPasswdDirty()) {
            return null;
        }
        String string = pSDCDBInstBK.getPasswd();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Passwd_Default(pSDCDBInstBK, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PASSWD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PPSDCDBInstBKId(boolean bl, PSDCDBInstBK pSDCDBInstBK, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDBInstBK.isPPSDCDBInstBKIdDirty() : !pSDCDBInstBK.isPPSDCDBInstBKIdDirty()) {
            return null;
        }
        String string = pSDCDBInstBK.getPPSDCDBInstBKId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSDCDBInstBKId_Default(pSDCDBInstBK, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSDCDBINSTBKID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDBDevInstBKId(boolean bl, PSDCDBInstBK pSDCDBInstBK, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDBInstBK.isPSDBDevInstBKIdDirty() : !pSDCDBInstBK.isPSDBDevInstBKIdDirty()) {
            return null;
        }
        String string = pSDCDBInstBK.getPSDBDevInstBKId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDBDevInstBKId_Default(pSDCDBInstBK, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDBDEVINSTBKID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDBDevInstBKName(boolean bl, PSDCDBInstBK pSDCDBInstBK, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDBInstBK.isPSDBDevInstBKNameDirty() : !pSDCDBInstBK.isPSDBDevInstBKNameDirty()) {
            return null;
        }
        String string = pSDCDBInstBK.getPSDBDevInstBKName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDBDevInstBKName_Default(pSDCDBInstBK, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDBDEVINSTBKNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCDBInstBKId(boolean bl, PSDCDBInstBK pSDCDBInstBK, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDBInstBK.isPSDCDBInstBKIdDirty() && !bl2 : !pSDCDBInstBK.isPSDCDBInstBKIdDirty()) {
            return null;
        }
        String string = pSDCDBInstBK.getPSDCDBInstBKId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCDBINSTBKID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCDBInstBKId_Default(pSDCDBInstBK, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCDBINSTBKID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCDBInstBKName(boolean bl, PSDCDBInstBK pSDCDBInstBK, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDBInstBK.isPSDCDBInstBKNameDirty() && !bl2 : !pSDCDBInstBK.isPSDCDBInstBKNameDirty()) {
            return null;
        }
        String string = pSDCDBInstBK.getPSDCDBInstBKName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCDBINSTBKNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCDBInstBKName_Default(pSDCDBInstBK, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCDBINSTBKNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterDBInstId(boolean bl, PSDCDBInstBK pSDCDBInstBK, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDBInstBK.isPSDevCenterDBInstIdDirty() : !pSDCDBInstBK.isPSDevCenterDBInstIdDirty()) {
            return null;
        }
        String string = pSDCDBInstBK.getPSDevCenterDBInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterDBInstId_Default(pSDCDBInstBK, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERDBINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterDBInstName(boolean bl, PSDCDBInstBK pSDCDBInstBK, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDBInstBK.isPSDevCenterDBInstNameDirty() : !pSDCDBInstBK.isPSDevCenterDBInstNameDirty()) {
            return null;
        }
        String string = pSDCDBInstBK.getPSDevCenterDBInstName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterDBInstName_Default(pSDCDBInstBK, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERDBINSTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterId(boolean bl, PSDCDBInstBK pSDCDBInstBK, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDBInstBK.isPSDevCenterIdDirty() : !pSDCDBInstBK.isPSDevCenterIdDirty()) {
            return null;
        }
        String string = pSDCDBInstBK.getPSDevCenterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterId_Default(pSDCDBInstBK, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevCenterName(boolean bl, PSDCDBInstBK pSDCDBInstBK, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDBInstBK.isPSDevCenterNameDirty() : !pSDCDBInstBK.isPSDevCenterNameDirty()) {
            return null;
        }
        String string = pSDCDBInstBK.getPSDevCenterName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterName_Default(pSDCDBInstBK, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSTaskServerId(boolean bl, PSDCDBInstBK pSDCDBInstBK, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDBInstBK.isPSTaskServerIdDirty() : !pSDCDBInstBK.isPSTaskServerIdDirty()) {
            return null;
        }
        String string = pSDCDBInstBK.getPSTaskServerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSTaskServerId_Default(pSDCDBInstBK, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSTASKSERVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSTaskServerName(boolean bl, PSDCDBInstBK pSDCDBInstBK, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDBInstBK.isPSTaskServerNameDirty() : !pSDCDBInstBK.isPSTaskServerNameDirty()) {
            return null;
        }
        String string = pSDCDBInstBK.getPSTaskServerName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSTaskServerName_Default(pSDCDBInstBK, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSTASKSERVERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDCDBInstBK pSDCDBInstBK, boolean bl) throws Exception {
        super.onSyncEntity(pSDCDBInstBK, bl);
    }

    protected void onSyncIndexEntities(PSDCDBInstBK pSDCDBInstBK, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDCDBInstBK, bl);
    }

    public Object getDataContextValue(PSDCDBInstBK pSDCDBInstBK, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDCDBInstBK, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDCDBInstBK pSDCDBInstBK, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDCDBInstBK, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"BACKUPSIZE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BackupSize_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BKFILEPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BKFilePath_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BKINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BKInfo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BKMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BackupMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BKSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BKState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BKTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BKTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DBTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DBType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FULLBKFILEPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FullBKFilePath_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PASSWD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Passwd_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSDCDBINSTBKID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSDCDBInstBKId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSDCDBINSTBKNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSDCDBInstBKName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDBDEVINSTBKID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDBDevInstBKId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDBDEVINSTBKNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDBDevInstBKName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCDBINSTBKID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCDBInstBKId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCDBINSTBKNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCDBInstBKName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERDBINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterDBInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERDBINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterDBInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSTASKSERVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSTaskServerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSTASKSERVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSTaskServerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_BackupSize_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_BKFilePath_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BKFILEPATH", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BKInfo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BKINFO", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BackupMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_BKState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_BKTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_DBType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DBTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FullBKFilePath_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FULLBKFILEPATH", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
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

    protected String onTestValueRule_Passwd_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PASSWD", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSDCDBInstBKId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSDCDBINSTBKID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSDCDBInstBKName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSDCDBINSTBKNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDBDevInstBKId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDBDEVINSTBKID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDBDevInstBKName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDBDEVINSTBKNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCDBInstBKId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCDBINSTBKID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCDBInstBKName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCDBINSTBKNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterDBInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERDBINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterDBInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERDBINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSTaskServerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSTASKSERVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSTaskServerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSTASKSERVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDCDBInstBK pSDCDBInstBK) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDCDBInstBK)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDCDBInstBK pSDCDBInstBK) throws Exception {
        super.onUpdateParent(pSDCDBInstBK);
    }

    @Override
    protected void exportCurXmlModel(PSDCDBInstBK pSDCDBInstBK, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDCDBINSTBK");
        if (!bl) {
            pSDCDBInstBK.setCreateDate(null);
            pSDCDBInstBK.setCreateMan(null);
            pSDCDBInstBK.setPSDCDBInstBKId(null);
            pSDCDBInstBK.setUpdateDate(null);
            pSDCDBInstBK.setUpdateMan(null);
            super.exportCurXmlModel(pSDCDBInstBK, xmlNode, bl);
        }
    }
}

