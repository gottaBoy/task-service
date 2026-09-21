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
import net.ibizsys.pscore.srv.devcenter.dao.PSDCRobotDAO;
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCRobotDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRobot;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevUser;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevUserBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCBKTaskService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCBKTaskServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCRobotAbilityService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCRobotAbilityServiceBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSRobot;
import net.ibizsys.pscore.srv.paasmgr.entity.PSRobotBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServerBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSSysDevBKTaskService;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSSysDevBKTaskServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCRobotServiceBase
extends PSCoreSysServiceBase<PSDCRobot> {
    private static final Log log = LogFactory.getLog(PSDCRobotServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDCRobotDEModel pSDCRobotDEModel;
    private PSDCRobotDAO pSDCRobotDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.devcenter.service.PSDCRobotService";
    }

    public PSDCRobotDEModel getPSDCRobotDEModel() {
        if (this.pSDCRobotDEModel == null) {
            try {
                this.pSDCRobotDEModel = (PSDCRobotDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCRobotDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCRobotDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDCRobotDEModel();
    }

    public PSDCRobotDAO getPSDCRobotDAO() {
        if (this.pSDCRobotDAO == null) {
            try {
                this.pSDCRobotDAO = (PSDCRobotDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.devcenter.dao.PSDCRobotDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCRobotDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDCRobotDAO();
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

    protected void onFillParentInfo(PSDCRobot pSDCRobot, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCROBOT_PSDEVCENTER_PSDEVCENTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService", (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = (PSDevCenter)iService.getDEModel().createEntity();
            pSDevCenter.set("PSDEVCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevCenter);
            } else {
                iService.get((IEntity)pSDevCenter);
            }
            this.onFillParentInfo_PSDevCenter(pSDCRobot, pSDevCenter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCROBOT_PSDEVUSER_PSDEVUSERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevUserService", (SessionFactory)this.getSessionFactory());
            PSDevUser pSDevUser = (PSDevUser)iService.getDEModel().createEntity();
            pSDevUser.set("PSDEVUSERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevUser);
            } else {
                iService.get((IEntity)pSDevUser);
            }
            this.onFillParentInfo_PSDevUser(pSDCRobot, pSDevUser);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCROBOT_PSROBOT_PSROBOTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSRobotService", (SessionFactory)this.getSessionFactory());
            PSRobot pSRobot = (PSRobot)iService.getDEModel().createEntity();
            pSRobot.set("PSROBOTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSRobot);
            } else {
                iService.get((IEntity)pSRobot);
            }
            this.onFillParentInfo_PSRobot(pSDCRobot, pSRobot);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCROBOT_PSTASKSERVER_PSTASKSERVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSTaskServerService", (SessionFactory)this.getSessionFactory());
            PSTaskServer pSTaskServer = (PSTaskServer)iService.getDEModel().createEntity();
            pSTaskServer.set("PSTASKSERVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSTaskServer);
            } else {
                iService.get((IEntity)pSTaskServer);
            }
            this.onFillParentInfo_PSTaskServer(pSDCRobot, pSTaskServer);
            return;
        }
        super.onFillParentInfo((IEntity)pSDCRobot, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDevCenter(PSDCRobot pSDCRobot, PSDevCenter pSDevCenter) throws Exception {
        pSDCRobot.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
        pSDCRobot.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
    }

    protected void onFillParentInfo_PSDevUser(PSDCRobot pSDCRobot, PSDevUser pSDevUser) throws Exception {
        pSDCRobot.setPSDevUserId(pSDevUser.getPSDevUserId());
        pSDCRobot.setPSDevUserName(pSDevUser.getPSDevUserName());
    }

    protected void onFillParentInfo_PSRobot(PSDCRobot pSDCRobot, PSRobot pSRobot) throws Exception {
        pSDCRobot.setPSRobotId(pSRobot.getPSRobotId());
        pSDCRobot.setPSRobotName(pSRobot.getPSRobotName());
    }

    protected void onFillParentInfo_PSTaskServer(PSDCRobot pSDCRobot, PSTaskServer pSTaskServer) throws Exception {
        pSDCRobot.setPSTaskServerId(pSTaskServer.getPSTaskServerId());
        pSDCRobot.setPSTaskServerName(pSTaskServer.getPSTaskServerName());
    }

    protected void onFillEntityFullInfo(PSDCRobot pSDCRobot, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSDCRobot, bl);
        this.onFillEntityFullInfo_PSDevCenter(pSDCRobot, bl);
        this.onFillEntityFullInfo_PSDevUser(pSDCRobot, bl);
        this.onFillEntityFullInfo_PSRobot(pSDCRobot, bl);
        this.onFillEntityFullInfo_PSTaskServer(pSDCRobot, bl);
    }

    protected void onFillEntityFullInfo_PSDevCenter(PSDCRobot pSDCRobot, boolean bl) throws Exception {
        if (pSDCRobot.isPSDevCenterIdDirty()) {
            if (pSDCRobot.getPSDevCenterId() != null) {
                if (pSDCRobot.getPSDevCenterId() == null || pSDCRobot.getPSDevCenterName() == null) {
                    PSDevCenter pSDevCenter = pSDCRobot.getPSDevCenter();
                    pSDCRobot.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
                }
            } else {
                pSDCRobot.setPSDevCenterName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDevUser(PSDCRobot pSDCRobot, boolean bl) throws Exception {
        if (pSDCRobot.isPSDevUserIdDirty()) {
            if (pSDCRobot.getPSDevUserId() != null) {
                if (pSDCRobot.getPSDevUserId() == null || pSDCRobot.getPSDevUserName() == null) {
                    PSDevUser pSDevUser = pSDCRobot.getPSDevUser();
                    pSDCRobot.setPSDevUserName(pSDevUser.getPSDevUserName());
                }
            } else {
                pSDCRobot.setPSDevUserName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSRobot(PSDCRobot pSDCRobot, boolean bl) throws Exception {
        if (pSDCRobot.isPSRobotIdDirty()) {
            if (pSDCRobot.getPSRobotId() != null) {
                if (pSDCRobot.getPSRobotId() == null || pSDCRobot.getPSRobotName() == null) {
                    PSRobot pSRobot = pSDCRobot.getPSRobot();
                    pSDCRobot.setPSRobotName(pSRobot.getPSRobotName());
                }
            } else {
                pSDCRobot.setPSRobotName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSTaskServer(PSDCRobot pSDCRobot, boolean bl) throws Exception {
        if (pSDCRobot.isPSTaskServerIdDirty()) {
            if (pSDCRobot.getPSTaskServerId() != null) {
                if (pSDCRobot.getPSTaskServerId() == null || pSDCRobot.getPSTaskServerName() == null) {
                    PSTaskServer pSTaskServer = pSDCRobot.getPSTaskServer();
                    pSDCRobot.setPSTaskServerName(pSTaskServer.getPSTaskServerName());
                }
            } else {
                pSDCRobot.setPSTaskServerName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDCRobot pSDCRobot, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDCRobot, bl);
    }

    public ArrayList<PSDCRobot> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, "", -1);
    }

    public ArrayList<PSDCRobot> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, string, -1);
    }

    public ArrayList<PSDCRobot> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string, int n) throws Exception {
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

    public ArrayList<PSDCRobot> selectByPSDevUser(PSDevUserBase pSDevUserBase) throws Exception {
        return this.selectByPSDevUser(pSDevUserBase, "", -1);
    }

    public ArrayList<PSDCRobot> selectByPSDevUser(PSDevUserBase pSDevUserBase, String string) throws Exception {
        return this.selectByPSDevUser(pSDevUserBase, string, -1);
    }

    public ArrayList<PSDCRobot> selectByPSDevUser(PSDevUserBase pSDevUserBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVUSERID", (Object)pSDevUserBase.getPSDevUserId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevUserCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevUserCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDCRobot> selectByPSRobot(PSRobotBase pSRobotBase) throws Exception {
        return this.selectByPSRobot(pSRobotBase, "", -1);
    }

    public ArrayList<PSDCRobot> selectByPSRobot(PSRobotBase pSRobotBase, String string) throws Exception {
        return this.selectByPSRobot(pSRobotBase, string, -1);
    }

    public ArrayList<PSDCRobot> selectByPSRobot(PSRobotBase pSRobotBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSROBOTID", (Object)pSRobotBase.getPSRobotId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSRobotCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSRobotCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDCRobot> selectByPSTaskServer(PSTaskServerBase pSTaskServerBase) throws Exception {
        return this.selectByPSTaskServer(pSTaskServerBase, "", -1);
    }

    public ArrayList<PSDCRobot> selectByPSTaskServer(PSTaskServerBase pSTaskServerBase, String string) throws Exception {
        return this.selectByPSTaskServer(pSTaskServerBase, string, -1);
    }

    public ArrayList<PSDCRobot> selectByPSTaskServer(PSTaskServerBase pSTaskServerBase, String string, int n) throws Exception {
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

    public void testRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    public void resetPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDCRobot> arrayList = this.selectByPSDevCenter(pSDevCenter);
        for (PSDCRobot pSDCRobot : arrayList) {
            PSDCRobot pSDCRobot2 = (PSDCRobot)this.getDEModel().createEntity();
            pSDCRobot2.setPSDCRobotId(pSDCRobot.getPSDCRobotId());
            pSDCRobot2.setPSDevCenterId(null);
            this.update(pSDCRobot2);
        }
    }

    public void removeByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCRobotServiceBase.this.onBeforeRemoveByPSDevCenter(pSDevCenter2);
                PSDCRobotServiceBase.this.internalRemoveByPSDevCenter(pSDevCenter2);
                PSDCRobotServiceBase.this.onAfterRemoveByPSDevCenter(pSDevCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void internalRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDCRobot> arrayList = this.selectByPSDevCenter(pSDevCenter);
        this.onBeforeRemoveByPSDevCenter(pSDevCenter, arrayList);
        for (PSDCRobot pSDCRobot : arrayList) {
            this.remove((IEntity)pSDCRobot);
        }
        this.onAfterRemoveByPSDevCenter(pSDevCenter, arrayList);
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDCRobot> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDCRobot> arrayList) throws Exception {
    }

    public void testRemoveByPSDevUser(PSDevUser pSDevUser) throws Exception {
    }

    public void resetPSDevUser(PSDevUser pSDevUser) throws Exception {
        ArrayList<PSDCRobot> arrayList = this.selectByPSDevUser(pSDevUser);
        for (PSDCRobot pSDCRobot : arrayList) {
            PSDCRobot pSDCRobot2 = (PSDCRobot)this.getDEModel().createEntity();
            pSDCRobot2.setPSDCRobotId(pSDCRobot.getPSDCRobotId());
            pSDCRobot2.setPSDevUserId(null);
            this.update(pSDCRobot2);
        }
    }

    public void removeByPSDevUser(PSDevUser pSDevUser) throws Exception {
        final PSDevUser pSDevUser2 = pSDevUser;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCRobotServiceBase.this.onBeforeRemoveByPSDevUser(pSDevUser2);
                PSDCRobotServiceBase.this.internalRemoveByPSDevUser(pSDevUser2);
                PSDCRobotServiceBase.this.onAfterRemoveByPSDevUser(pSDevUser2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevUser(PSDevUser pSDevUser) throws Exception {
    }

    protected void internalRemoveByPSDevUser(PSDevUser pSDevUser) throws Exception {
        ArrayList<PSDCRobot> arrayList = this.selectByPSDevUser(pSDevUser);
        this.onBeforeRemoveByPSDevUser(pSDevUser, arrayList);
        for (PSDCRobot pSDCRobot : arrayList) {
            this.remove((IEntity)pSDCRobot);
        }
        this.onAfterRemoveByPSDevUser(pSDevUser, arrayList);
    }

    protected void onAfterRemoveByPSDevUser(PSDevUser pSDevUser) throws Exception {
    }

    protected void onBeforeRemoveByPSDevUser(PSDevUser pSDevUser, ArrayList<PSDCRobot> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevUser(PSDevUser pSDevUser, ArrayList<PSDCRobot> arrayList) throws Exception {
    }

    public void testRemoveByPSRobot(PSRobot pSRobot) throws Exception {
        ArrayList<PSDCRobot> arrayList = this.selectByPSRobot(pSRobot, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSROBOT");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSRobot);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCROBOT_PSROBOT_PSROBOTID", "", iDataEntityModel.getName(), "PSDCROBOT", iDataEntityModel.getDataInfo((IEntity)pSRobot), arrayList.get(0)));
        }
    }

    public void resetPSRobot(PSRobot pSRobot) throws Exception {
        ArrayList<PSDCRobot> arrayList = this.selectByPSRobot(pSRobot);
        for (PSDCRobot pSDCRobot : arrayList) {
            PSDCRobot pSDCRobot2 = (PSDCRobot)this.getDEModel().createEntity();
            pSDCRobot2.setPSDCRobotId(pSDCRobot.getPSDCRobotId());
            pSDCRobot2.setPSRobotId(null);
            this.update(pSDCRobot2);
        }
    }

    public void removeByPSRobot(PSRobot pSRobot) throws Exception {
        final PSRobot pSRobot2 = pSRobot;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCRobotServiceBase.this.onBeforeRemoveByPSRobot(pSRobot2);
                PSDCRobotServiceBase.this.internalRemoveByPSRobot(pSRobot2);
                PSDCRobotServiceBase.this.onAfterRemoveByPSRobot(pSRobot2);
            }
        });
    }

    protected void onBeforeRemoveByPSRobot(PSRobot pSRobot) throws Exception {
    }

    protected void internalRemoveByPSRobot(PSRobot pSRobot) throws Exception {
        ArrayList<PSDCRobot> arrayList = this.selectByPSRobot(pSRobot);
        this.onBeforeRemoveByPSRobot(pSRobot, arrayList);
        for (PSDCRobot pSDCRobot : arrayList) {
            this.remove((IEntity)pSDCRobot);
        }
        this.onAfterRemoveByPSRobot(pSRobot, arrayList);
    }

    protected void onAfterRemoveByPSRobot(PSRobot pSRobot) throws Exception {
    }

    protected void onBeforeRemoveByPSRobot(PSRobot pSRobot, ArrayList<PSDCRobot> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSRobot(PSRobot pSRobot, ArrayList<PSDCRobot> arrayList) throws Exception {
    }

    public void testRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
        ArrayList<PSDCRobot> arrayList = this.selectByPSTaskServer(pSTaskServer, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSTASKSERVER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSTaskServer);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCROBOT_PSTASKSERVER_PSTASKSERVERID", "", iDataEntityModel.getName(), "PSDCROBOT", iDataEntityModel.getDataInfo((IEntity)pSTaskServer), arrayList.get(0)));
        }
    }

    public void resetPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
        ArrayList<PSDCRobot> arrayList = this.selectByPSTaskServer(pSTaskServer);
        for (PSDCRobot pSDCRobot : arrayList) {
            PSDCRobot pSDCRobot2 = (PSDCRobot)this.getDEModel().createEntity();
            pSDCRobot2.setPSDCRobotId(pSDCRobot.getPSDCRobotId());
            pSDCRobot2.setPSTaskServerId(null);
            this.update(pSDCRobot2);
        }
    }

    public void removeByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
        final PSTaskServer pSTaskServer2 = pSTaskServer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCRobotServiceBase.this.onBeforeRemoveByPSTaskServer(pSTaskServer2);
                PSDCRobotServiceBase.this.internalRemoveByPSTaskServer(pSTaskServer2);
                PSDCRobotServiceBase.this.onAfterRemoveByPSTaskServer(pSTaskServer2);
            }
        });
    }

    protected void onBeforeRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
    }

    protected void internalRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
        ArrayList<PSDCRobot> arrayList = this.selectByPSTaskServer(pSTaskServer);
        this.onBeforeRemoveByPSTaskServer(pSTaskServer, arrayList);
        for (PSDCRobot pSDCRobot : arrayList) {
            this.remove((IEntity)pSDCRobot);
        }
        this.onAfterRemoveByPSTaskServer(pSTaskServer, arrayList);
    }

    protected void onAfterRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
    }

    protected void onBeforeRemoveByPSTaskServer(PSTaskServer pSTaskServer, ArrayList<PSDCRobot> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSTaskServer(PSTaskServer pSTaskServer, ArrayList<PSDCRobot> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDCRobot pSDCRobot) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDCBKTaskService)ServiceGlobal.getService(PSDCBKTaskService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCBKTaskServiceBase)pSCoreSysServiceBase).testRemoveByPlanPSDCRobot(pSDCRobot);
        pSCoreSysServiceBase = (PSDCRobotAbilityService)ServiceGlobal.getService(PSDCRobotAbilityService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCRobotAbilityServiceBase)pSCoreSysServiceBase).testRemoveByPSDCRobot(pSDCRobot);
        pSCoreSysServiceBase = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnSysServiceBase)pSCoreSysServiceBase).testRemoveByPSDCRobot(pSDCRobot);
        pSCoreSysServiceBase = (PSSysDevBKTaskService)ServiceGlobal.getService(PSSysDevBKTaskService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysDevBKTaskServiceBase)pSCoreSysServiceBase).testRemoveByPlanPSDCRobot(pSDCRobot);
        super.onBeforeRemove(pSDCRobot);
    }

    protected void replaceParentInfo(PSDCRobot pSDCRobot, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDCRobot, cloneSession);
        if (pSDCRobot.getPSDevCenterId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTER", (Object)pSDCRobot.getPSDevCenterId())) != null) {
            this.onFillParentInfo_PSDevCenter(pSDCRobot, (PSDevCenter)iEntity);
        }
        if (pSDCRobot.getPSDevUserId() != null && (iEntity = cloneSession.getEntity("PSDEVUSER", (Object)pSDCRobot.getPSDevUserId())) != null) {
            this.onFillParentInfo_PSDevUser(pSDCRobot, (PSDevUser)iEntity);
        }
        if (pSDCRobot.getPSRobotId() != null && (iEntity = cloneSession.getEntity("PSROBOT", (Object)pSDCRobot.getPSRobotId())) != null) {
            this.onFillParentInfo_PSRobot(pSDCRobot, (PSRobot)iEntity);
        }
        if (pSDCRobot.getPSTaskServerId() != null && (iEntity = cloneSession.getEntity("PSTASKSERVER", (Object)pSDCRobot.getPSTaskServerId())) != null) {
            this.onFillParentInfo_PSTaskServer(pSDCRobot, (PSTaskServer)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDCRobot pSDCRobot, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDCRobot, bl);
    }

    protected void onCheckEntity(boolean bl, PSDCRobot pSDCRobot, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CurEnergy(bl, pSDCRobot, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnergyRate(bl, pSDCRobot, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExtEnergy(bl, pSDCRobot, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LastCalcTime(bl, pSDCRobot, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LastEnergy(bl, pSDCRobot, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MaxEnergy(bl, pSDCRobot, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MaxExtEnergy(bl, pSDCRobot, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDCRobot, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDCRobot, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCRobotId(bl, pSDCRobot, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCRobotName(bl, pSDCRobot, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterId(bl, pSDCRobot, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterName(bl, pSDCRobot, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevUserId(bl, pSDCRobot, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevUserName(bl, pSDCRobot, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSRobotId(bl, pSDCRobot, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSRobotName(bl, pSDCRobot, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSTaskServerId(bl, pSDCRobot, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSTaskServerName(bl, pSDCRobot, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefObjId(bl, pSDCRobot, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefObjName(bl, pSDCRobot, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefObjType(bl, pSDCRobot, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ResState(bl, pSDCRobot, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RobotLevel(bl, pSDCRobot, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RobotType(bl, pSDCRobot, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TotalEnergy(bl, pSDCRobot, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDCRobot, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CurEnergy(boolean bl, PSDCRobot pSDCRobot, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRobot.isCurEnergyDirty() : !pSDCRobot.isCurEnergyDirty()) {
            return null;
        }
        Integer n = pSDCRobot.getCurEnergy();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CurEnergy_Default((IEntity)pSDCRobot, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CURENERGY");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnergyRate(boolean bl, PSDCRobot pSDCRobot, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRobot.isEnergyRateDirty() : !pSDCRobot.isEnergyRateDirty()) {
            return null;
        }
        Double d = pSDCRobot.getEnergyRate();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnergyRate_Default((IEntity)pSDCRobot, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENERGYRATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExtEnergy(boolean bl, PSDCRobot pSDCRobot, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRobot.isExtEnergyDirty() : !pSDCRobot.isExtEnergyDirty()) {
            return null;
        }
        Integer n = pSDCRobot.getExtEnergy();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ExtEnergy_Default((IEntity)pSDCRobot, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXTENERGY");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LastCalcTime(boolean bl, PSDCRobot pSDCRobot, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRobot.isLastCalcTimeDirty() : !pSDCRobot.isLastCalcTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDCRobot.getLastCalcTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LastCalcTime_Default((IEntity)pSDCRobot, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LASTCALCTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LastEnergy(boolean bl, PSDCRobot pSDCRobot, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRobot.isLastEnergyDirty() : !pSDCRobot.isLastEnergyDirty()) {
            return null;
        }
        Integer n = pSDCRobot.getLastEnergy();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LastEnergy_Default((IEntity)pSDCRobot, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LASTENERGY");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MaxEnergy(boolean bl, PSDCRobot pSDCRobot, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRobot.isMaxEnergyDirty() : !pSDCRobot.isMaxEnergyDirty()) {
            return null;
        }
        Integer n = pSDCRobot.getMaxEnergy();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MaxEnergy_Default((IEntity)pSDCRobot, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAXENERGY");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MaxExtEnergy(boolean bl, PSDCRobot pSDCRobot, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRobot.isMaxExtEnergyDirty() : !pSDCRobot.isMaxExtEnergyDirty()) {
            return null;
        }
        Integer n = pSDCRobot.getMaxExtEnergy();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MaxExtEnergy_Default((IEntity)pSDCRobot, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAXEXTENERGY");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDCRobot pSDCRobot, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRobot.isMemoDirty() : !pSDCRobot.isMemoDirty()) {
            return null;
        }
        String string = pSDCRobot.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDCRobot, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDCRobot pSDCRobot, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRobot.isOrderValueDirty() : !pSDCRobot.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDCRobot.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSDCRobot, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDCRobotId(boolean bl, PSDCRobot pSDCRobot, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRobot.isPSDCRobotIdDirty() && !bl2 : !pSDCRobot.isPSDCRobotIdDirty()) {
            return null;
        }
        String string = pSDCRobot.getPSDCRobotId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCROBOTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCRobotId_Default((IEntity)pSDCRobot, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCROBOTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCRobotName(boolean bl, PSDCRobot pSDCRobot, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRobot.isPSDCRobotNameDirty() && !bl2 : !pSDCRobot.isPSDCRobotNameDirty()) {
            return null;
        }
        String string = pSDCRobot.getPSDCRobotName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCROBOTNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCRobotName_Default((IEntity)pSDCRobot, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCROBOTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterId(boolean bl, PSDCRobot pSDCRobot, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRobot.isPSDevCenterIdDirty() && !bl2 : !pSDCRobot.isPSDevCenterIdDirty()) {
            return null;
        }
        String string = pSDCRobot.getPSDevCenterId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterId_Default((IEntity)pSDCRobot, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevCenterName(boolean bl, PSDCRobot pSDCRobot, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRobot.isPSDevCenterNameDirty() && !bl2 : !pSDCRobot.isPSDevCenterNameDirty()) {
            return null;
        }
        String string = pSDCRobot.getPSDevCenterName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterName_Default((IEntity)pSDCRobot, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevUserId(boolean bl, PSDCRobot pSDCRobot, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRobot.isPSDevUserIdDirty() : !pSDCRobot.isPSDevUserIdDirty()) {
            return null;
        }
        String string = pSDCRobot.getPSDevUserId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevUserId_Default((IEntity)pSDCRobot, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVUSERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevUserName(boolean bl, PSDCRobot pSDCRobot, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRobot.isPSDevUserNameDirty() : !pSDCRobot.isPSDevUserNameDirty()) {
            return null;
        }
        String string = pSDCRobot.getPSDevUserName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevUserName_Default((IEntity)pSDCRobot, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVUSERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSRobotId(boolean bl, PSDCRobot pSDCRobot, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRobot.isPSRobotIdDirty() && !bl2 : !pSDCRobot.isPSRobotIdDirty()) {
            return null;
        }
        String string = pSDCRobot.getPSRobotId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSROBOTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSRobotId_Default((IEntity)pSDCRobot, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSROBOTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSRobotName(boolean bl, PSDCRobot pSDCRobot, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRobot.isPSRobotNameDirty() && !bl2 : !pSDCRobot.isPSRobotNameDirty()) {
            return null;
        }
        String string = pSDCRobot.getPSRobotName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSROBOTNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSRobotName_Default((IEntity)pSDCRobot, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSROBOTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSTaskServerId(boolean bl, PSDCRobot pSDCRobot, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRobot.isPSTaskServerIdDirty() : !pSDCRobot.isPSTaskServerIdDirty()) {
            return null;
        }
        String string = pSDCRobot.getPSTaskServerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSTaskServerId_Default((IEntity)pSDCRobot, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSTaskServerName(boolean bl, PSDCRobot pSDCRobot, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRobot.isPSTaskServerNameDirty() : !pSDCRobot.isPSTaskServerNameDirty()) {
            return null;
        }
        String string = pSDCRobot.getPSTaskServerName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSTaskServerName_Default((IEntity)pSDCRobot, bl2, bl3);
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

    protected EntityFieldError onCheckField_RefObjId(boolean bl, PSDCRobot pSDCRobot, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRobot.isRefObjIdDirty() : !pSDCRobot.isRefObjIdDirty()) {
            return null;
        }
        String string = pSDCRobot.getRefObjId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefObjId_Default((IEntity)pSDCRobot, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFOBJID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefObjName(boolean bl, PSDCRobot pSDCRobot, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRobot.isRefObjNameDirty() : !pSDCRobot.isRefObjNameDirty()) {
            return null;
        }
        String string = pSDCRobot.getRefObjName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefObjName_Default((IEntity)pSDCRobot, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFOBJNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefObjType(boolean bl, PSDCRobot pSDCRobot, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRobot.isRefObjTypeDirty() : !pSDCRobot.isRefObjTypeDirty()) {
            return null;
        }
        String string = pSDCRobot.getRefObjType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefObjType_Default((IEntity)pSDCRobot, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFOBJTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ResState(boolean bl, PSDCRobot pSDCRobot, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRobot.isResStateDirty() : !pSDCRobot.isResStateDirty()) {
            return null;
        }
        Integer n = pSDCRobot.getResState();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ResState_Default((IEntity)pSDCRobot, bl2, bl3);
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

    protected EntityFieldError onCheckField_RobotLevel(boolean bl, PSDCRobot pSDCRobot, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRobot.isRobotLevelDirty() : !pSDCRobot.isRobotLevelDirty()) {
            return null;
        }
        Integer n = pSDCRobot.getRobotLevel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_RobotLevel_Default((IEntity)pSDCRobot, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ROBOTLEVEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RobotType(boolean bl, PSDCRobot pSDCRobot, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRobot.isRobotTypeDirty() && !bl2 : !pSDCRobot.isRobotTypeDirty()) {
            return null;
        }
        String string = pSDCRobot.getRobotType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ROBOTTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_RobotType_Default((IEntity)pSDCRobot, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ROBOTTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TotalEnergy(boolean bl, PSDCRobot pSDCRobot, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRobot.isTotalEnergyDirty() : !pSDCRobot.isTotalEnergyDirty()) {
            return null;
        }
        Integer n = pSDCRobot.getTotalEnergy();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_TotalEnergy_Default((IEntity)pSDCRobot, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TOTALENERGY");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDCRobot pSDCRobot, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDCRobot, bl);
    }

    protected void onSyncIndexEntities(PSDCRobot pSDCRobot, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDCRobot, bl);
    }

    public Object getDataContextValue(PSDCRobot pSDCRobot, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDCRobot, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDCRobot pSDCRobot, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDCRobot, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CURENERGY", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CurEnergy_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENERGYRATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnergyRate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXTENERGY", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExtEnergy_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LASTCALCTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LastCalcTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LASTENERGY", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LastEnergy_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAXENERGY", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MaxEnergy_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAXEXTENERGY", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MaxExtEnergy_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCROBOTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCRobotId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCROBOTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCRobotName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVUSERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevUserId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVUSERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevUserName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSROBOTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSRobotId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSROBOTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSRobotName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSTASKSERVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSTaskServerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSTASKSERVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSTaskServerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFOBJID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefObjId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFOBJNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefObjName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFOBJTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefObjType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RESSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ResState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ROBOTLEVEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RobotLevel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ROBOTTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RobotType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TOTALENERGY", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TotalEnergy_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_CurEnergy_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnergyRate_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ExtEnergy_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LastCalcTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LastEnergy_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_MaxEnergy_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_MaxExtEnergy_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSDCRobotId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCROBOTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCRobotName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCROBOTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSDevUserId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVUSERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevUserName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVUSERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSRobotId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSROBOTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSRobotName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSROBOTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_RefObjId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFOBJID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefObjName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFOBJNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefObjType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFOBJTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ResState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_RobotLevel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_RobotType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ROBOTTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TotalEnergy_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected boolean onMergeChild(String string, String string2, PSDCRobot pSDCRobot) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDCRobot)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDCRobot pSDCRobot) throws Exception {
        super.onUpdateParent((IEntity)pSDCRobot);
    }

    @Override
    protected void exportCurXmlModel(PSDCRobot pSDCRobot, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDCROBOT");
        if (!bl) {
            pSDCRobot.setCreateDate(null);
            pSDCRobot.setCreateMan(null);
            pSDCRobot.setPSDCRobotId(null);
            pSDCRobot.setPSRobotId(null);
            pSDCRobot.setPSRobotName(null);
            pSDCRobot.setUpdateDate(null);
            pSDCRobot.setUpdateMan(null);
            super.exportCurXmlModel(pSDCRobot, xmlNode, bl);
        }
    }
}

