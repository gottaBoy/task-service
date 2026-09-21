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
import net.ibizsys.pscore.srv.config.entity.PSRobotAbility;
import net.ibizsys.pscore.srv.config.entity.PSRobotAbilityBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.devcenter.dao.PSDCRobotAbilityDAO;
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCRobotAbilityDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRobot;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRobotAbility;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRobotBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCRobotAbilityServiceBase
extends PSCoreSysServiceBase<PSDCRobotAbility> {
    private static final Log log = LogFactory.getLog(PSDCRobotAbilityServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDCRobotAbilityDEModel pSDCRobotAbilityDEModel;
    private PSDCRobotAbilityDAO pSDCRobotAbilityDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.devcenter.service.PSDCRobotAbilityService";
    }

    public PSDCRobotAbilityDEModel getPSDCRobotAbilityDEModel() {
        if (this.pSDCRobotAbilityDEModel == null) {
            try {
                this.pSDCRobotAbilityDEModel = (PSDCRobotAbilityDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCRobotAbilityDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCRobotAbilityDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDCRobotAbilityDEModel();
    }

    public PSDCRobotAbilityDAO getPSDCRobotAbilityDAO() {
        if (this.pSDCRobotAbilityDAO == null) {
            try {
                this.pSDCRobotAbilityDAO = (PSDCRobotAbilityDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.devcenter.dao.PSDCRobotAbilityDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCRobotAbilityDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDCRobotAbilityDAO();
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

    protected void onFillParentInfo(PSDCRobotAbility pSDCRobotAbility, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCROBOTABILITY_PSDCROBOT_PSDCROBOTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCRobotService", (SessionFactory)this.getSessionFactory());
            PSDCRobot pSDCRobot = (PSDCRobot)iService.getDEModel().createEntity();
            pSDCRobot.set("PSDCROBOTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDCRobot);
            } else {
                iService.get((IEntity)pSDCRobot);
            }
            this.onFillParentInfo_PSDCRobot(pSDCRobotAbility, pSDCRobot);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCROBOTABILITY_PSDEVCENTER_PSDEVCENTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService", (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = (PSDevCenter)iService.getDEModel().createEntity();
            pSDevCenter.set("PSDEVCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevCenter);
            } else {
                iService.get((IEntity)pSDevCenter);
            }
            this.onFillParentInfo_PSDevCenter(pSDCRobotAbility, pSDevCenter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCROBOTABILITY_PSROBOTABILITY_PSROBOTABILITYID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSRobotAbilityService", (SessionFactory)this.getSessionFactory());
            PSRobotAbility pSRobotAbility = (PSRobotAbility)iService.getDEModel().createEntity();
            pSRobotAbility.set("PSROBOTABILITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSRobotAbility);
            } else {
                iService.get((IEntity)pSRobotAbility);
            }
            this.onFillParentInfo_PSRobotAbility(pSDCRobotAbility, pSRobotAbility);
            return;
        }
        super.onFillParentInfo((IEntity)pSDCRobotAbility, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDCRobot(PSDCRobotAbility pSDCRobotAbility, PSDCRobot pSDCRobot) throws Exception {
        pSDCRobotAbility.setPSDCRobotId(pSDCRobot.getPSDCRobotId());
        pSDCRobotAbility.setPSDCRobotName(pSDCRobot.getPSDCRobotName());
    }

    protected void onFillParentInfo_PSDevCenter(PSDCRobotAbility pSDCRobotAbility, PSDevCenter pSDevCenter) throws Exception {
        pSDCRobotAbility.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
        pSDCRobotAbility.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
    }

    protected void onFillParentInfo_PSRobotAbility(PSDCRobotAbility pSDCRobotAbility, PSRobotAbility pSRobotAbility) throws Exception {
        pSDCRobotAbility.setPSRobotAbilityId(pSRobotAbility.getPSRobotAbilityId());
        pSDCRobotAbility.setPSRobotAbilityName(pSRobotAbility.getPSRobotAbilityName());
    }

    protected void onFillEntityFullInfo(PSDCRobotAbility pSDCRobotAbility, boolean bl) throws Exception {
        if (bl && pSDCRobotAbility.getValidFlag() == null) {
            pSDCRobotAbility.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo((IEntity)pSDCRobotAbility, bl);
        this.onFillEntityFullInfo_PSDCRobot(pSDCRobotAbility, bl);
        this.onFillEntityFullInfo_PSDevCenter(pSDCRobotAbility, bl);
        this.onFillEntityFullInfo_PSRobotAbility(pSDCRobotAbility, bl);
    }

    protected void onFillEntityFullInfo_PSDCRobot(PSDCRobotAbility pSDCRobotAbility, boolean bl) throws Exception {
        if (pSDCRobotAbility.isPSDCRobotIdDirty()) {
            if (pSDCRobotAbility.getPSDCRobotId() != null) {
                if (pSDCRobotAbility.getPSDCRobotId() == null || pSDCRobotAbility.getPSDCRobotName() == null) {
                    PSDCRobot pSDCRobot = pSDCRobotAbility.getPSDCRobot();
                    pSDCRobotAbility.setPSDCRobotName(pSDCRobot.getPSDCRobotName());
                }
            } else {
                pSDCRobotAbility.setPSDCRobotName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDevCenter(PSDCRobotAbility pSDCRobotAbility, boolean bl) throws Exception {
        if (pSDCRobotAbility.isPSDevCenterIdDirty()) {
            if (pSDCRobotAbility.getPSDevCenterId() != null) {
                if (pSDCRobotAbility.getPSDevCenterId() == null || pSDCRobotAbility.getPSDevCenterName() == null) {
                    PSDevCenter pSDevCenter = pSDCRobotAbility.getPSDevCenter();
                    pSDCRobotAbility.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
                }
            } else {
                pSDCRobotAbility.setPSDevCenterName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSRobotAbility(PSDCRobotAbility pSDCRobotAbility, boolean bl) throws Exception {
        if (pSDCRobotAbility.isPSRobotAbilityIdDirty()) {
            if (pSDCRobotAbility.getPSRobotAbilityId() != null) {
                if (pSDCRobotAbility.getPSRobotAbilityId() == null || pSDCRobotAbility.getPSRobotAbilityName() == null) {
                    PSRobotAbility pSRobotAbility = pSDCRobotAbility.getPSRobotAbility();
                    pSDCRobotAbility.setPSRobotAbilityName(pSRobotAbility.getPSRobotAbilityName());
                }
            } else {
                pSDCRobotAbility.setPSRobotAbilityName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDCRobotAbility pSDCRobotAbility, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDCRobotAbility, bl);
    }

    public ArrayList<PSDCRobotAbility> selectByPSDCRobot(PSDCRobotBase pSDCRobotBase) throws Exception {
        return this.selectByPSDCRobot(pSDCRobotBase, "", -1);
    }

    public ArrayList<PSDCRobotAbility> selectByPSDCRobot(PSDCRobotBase pSDCRobotBase, String string) throws Exception {
        return this.selectByPSDCRobot(pSDCRobotBase, string, -1);
    }

    public ArrayList<PSDCRobotAbility> selectByPSDCRobot(PSDCRobotBase pSDCRobotBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDCROBOTID", (Object)pSDCRobotBase.getPSDCRobotId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDCRobotCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDCRobotCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDCRobotAbility> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, "", -1);
    }

    public ArrayList<PSDCRobotAbility> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, string, -1);
    }

    public ArrayList<PSDCRobotAbility> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string, int n) throws Exception {
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

    public ArrayList<PSDCRobotAbility> selectByPSRobotAbility(PSRobotAbilityBase pSRobotAbilityBase) throws Exception {
        return this.selectByPSRobotAbility(pSRobotAbilityBase, "", -1);
    }

    public ArrayList<PSDCRobotAbility> selectByPSRobotAbility(PSRobotAbilityBase pSRobotAbilityBase, String string) throws Exception {
        return this.selectByPSRobotAbility(pSRobotAbilityBase, string, -1);
    }

    public ArrayList<PSDCRobotAbility> selectByPSRobotAbility(PSRobotAbilityBase pSRobotAbilityBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSROBOTABILITYID", (Object)pSRobotAbilityBase.getPSRobotAbilityId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSRobotAbilityCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSRobotAbilityCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDCRobot(PSDCRobot pSDCRobot) throws Exception {
        ArrayList<PSDCRobotAbility> arrayList = this.selectByPSDCRobot(pSDCRobot, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCROBOT");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDCRobot);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCROBOTABILITY_PSDCROBOT_PSDCROBOTID", "", iDataEntityModel.getName(), "PSDCROBOTABILITY", iDataEntityModel.getDataInfo((IEntity)pSDCRobot), arrayList.get(0)));
        }
    }

    public void resetPSDCRobot(PSDCRobot pSDCRobot) throws Exception {
        ArrayList<PSDCRobotAbility> arrayList = this.selectByPSDCRobot(pSDCRobot);
        for (PSDCRobotAbility pSDCRobotAbility : arrayList) {
            PSDCRobotAbility pSDCRobotAbility2 = (PSDCRobotAbility)this.getDEModel().createEntity();
            pSDCRobotAbility2.setPSDCRobotAbilityId(pSDCRobotAbility.getPSDCRobotAbilityId());
            pSDCRobotAbility2.setPSDCRobotId(null);
            this.update(pSDCRobotAbility2);
        }
    }

    public void removeByPSDCRobot(PSDCRobot pSDCRobot) throws Exception {
        final PSDCRobot pSDCRobot2 = pSDCRobot;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCRobotAbilityServiceBase.this.onBeforeRemoveByPSDCRobot(pSDCRobot2);
                PSDCRobotAbilityServiceBase.this.internalRemoveByPSDCRobot(pSDCRobot2);
                PSDCRobotAbilityServiceBase.this.onAfterRemoveByPSDCRobot(pSDCRobot2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCRobot(PSDCRobot pSDCRobot) throws Exception {
    }

    protected void internalRemoveByPSDCRobot(PSDCRobot pSDCRobot) throws Exception {
        ArrayList<PSDCRobotAbility> arrayList = this.selectByPSDCRobot(pSDCRobot);
        this.onBeforeRemoveByPSDCRobot(pSDCRobot, arrayList);
        for (PSDCRobotAbility pSDCRobotAbility : arrayList) {
            this.remove((IEntity)pSDCRobotAbility);
        }
        this.onAfterRemoveByPSDCRobot(pSDCRobot, arrayList);
    }

    protected void onAfterRemoveByPSDCRobot(PSDCRobot pSDCRobot) throws Exception {
    }

    protected void onBeforeRemoveByPSDCRobot(PSDCRobot pSDCRobot, ArrayList<PSDCRobotAbility> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCRobot(PSDCRobot pSDCRobot, ArrayList<PSDCRobotAbility> arrayList) throws Exception {
    }

    public void testRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDCRobotAbility> arrayList = this.selectByPSDevCenter(pSDevCenter, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevCenter);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCROBOTABILITY_PSDEVCENTER_PSDEVCENTERID", "", iDataEntityModel.getName(), "PSDCROBOTABILITY", iDataEntityModel.getDataInfo((IEntity)pSDevCenter), arrayList.get(0)));
        }
    }

    public void resetPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDCRobotAbility> arrayList = this.selectByPSDevCenter(pSDevCenter);
        for (PSDCRobotAbility pSDCRobotAbility : arrayList) {
            PSDCRobotAbility pSDCRobotAbility2 = (PSDCRobotAbility)this.getDEModel().createEntity();
            pSDCRobotAbility2.setPSDCRobotAbilityId(pSDCRobotAbility.getPSDCRobotAbilityId());
            pSDCRobotAbility2.setPSDevCenterId(null);
            this.update(pSDCRobotAbility2);
        }
    }

    public void removeByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCRobotAbilityServiceBase.this.onBeforeRemoveByPSDevCenter(pSDevCenter2);
                PSDCRobotAbilityServiceBase.this.internalRemoveByPSDevCenter(pSDevCenter2);
                PSDCRobotAbilityServiceBase.this.onAfterRemoveByPSDevCenter(pSDevCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void internalRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDCRobotAbility> arrayList = this.selectByPSDevCenter(pSDevCenter);
        this.onBeforeRemoveByPSDevCenter(pSDevCenter, arrayList);
        for (PSDCRobotAbility pSDCRobotAbility : arrayList) {
            this.remove((IEntity)pSDCRobotAbility);
        }
        this.onAfterRemoveByPSDevCenter(pSDevCenter, arrayList);
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDCRobotAbility> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDCRobotAbility> arrayList) throws Exception {
    }

    public void testRemoveByPSRobotAbility(PSRobotAbility pSRobotAbility) throws Exception {
        ArrayList<PSDCRobotAbility> arrayList = this.selectByPSRobotAbility(pSRobotAbility, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSROBOTABILITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSRobotAbility);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCROBOTABILITY_PSROBOTABILITY_PSROBOTABILITYID", "", iDataEntityModel.getName(), "PSDCROBOTABILITY", iDataEntityModel.getDataInfo((IEntity)pSRobotAbility), arrayList.get(0)));
        }
    }

    public void resetPSRobotAbility(PSRobotAbility pSRobotAbility) throws Exception {
        ArrayList<PSDCRobotAbility> arrayList = this.selectByPSRobotAbility(pSRobotAbility);
        for (PSDCRobotAbility pSDCRobotAbility : arrayList) {
            PSDCRobotAbility pSDCRobotAbility2 = (PSDCRobotAbility)this.getDEModel().createEntity();
            pSDCRobotAbility2.setPSDCRobotAbilityId(pSDCRobotAbility.getPSDCRobotAbilityId());
            pSDCRobotAbility2.setPSRobotAbilityId(null);
            this.update(pSDCRobotAbility2);
        }
    }

    public void removeByPSRobotAbility(PSRobotAbility pSRobotAbility) throws Exception {
        final PSRobotAbility pSRobotAbility2 = pSRobotAbility;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCRobotAbilityServiceBase.this.onBeforeRemoveByPSRobotAbility(pSRobotAbility2);
                PSDCRobotAbilityServiceBase.this.internalRemoveByPSRobotAbility(pSRobotAbility2);
                PSDCRobotAbilityServiceBase.this.onAfterRemoveByPSRobotAbility(pSRobotAbility2);
            }
        });
    }

    protected void onBeforeRemoveByPSRobotAbility(PSRobotAbility pSRobotAbility) throws Exception {
    }

    protected void internalRemoveByPSRobotAbility(PSRobotAbility pSRobotAbility) throws Exception {
        ArrayList<PSDCRobotAbility> arrayList = this.selectByPSRobotAbility(pSRobotAbility);
        this.onBeforeRemoveByPSRobotAbility(pSRobotAbility, arrayList);
        for (PSDCRobotAbility pSDCRobotAbility : arrayList) {
            this.remove((IEntity)pSDCRobotAbility);
        }
        this.onAfterRemoveByPSRobotAbility(pSRobotAbility, arrayList);
    }

    protected void onAfterRemoveByPSRobotAbility(PSRobotAbility pSRobotAbility) throws Exception {
    }

    protected void onBeforeRemoveByPSRobotAbility(PSRobotAbility pSRobotAbility, ArrayList<PSDCRobotAbility> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSRobotAbility(PSRobotAbility pSRobotAbility, ArrayList<PSDCRobotAbility> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDCRobotAbility pSDCRobotAbility) throws Exception {
        super.onBeforeRemove(pSDCRobotAbility);
    }

    protected void replaceParentInfo(PSDCRobotAbility pSDCRobotAbility, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDCRobotAbility, cloneSession);
        if (pSDCRobotAbility.getPSDCRobotId() != null && (iEntity = cloneSession.getEntity("PSDCROBOT", (Object)pSDCRobotAbility.getPSDCRobotId())) != null) {
            this.onFillParentInfo_PSDCRobot(pSDCRobotAbility, (PSDCRobot)iEntity);
        }
        if (pSDCRobotAbility.getPSDevCenterId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTER", (Object)pSDCRobotAbility.getPSDevCenterId())) != null) {
            this.onFillParentInfo_PSDevCenter(pSDCRobotAbility, (PSDevCenter)iEntity);
        }
        if (pSDCRobotAbility.getPSRobotAbilityId() != null && (iEntity = cloneSession.getEntity("PSROBOTABILITY", (Object)pSDCRobotAbility.getPSRobotAbilityId())) != null) {
            this.onFillParentInfo_PSRobotAbility(pSDCRobotAbility, (PSRobotAbility)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDCRobotAbility pSDCRobotAbility, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDCRobotAbility, bl);
    }

    protected void onCheckEntity(boolean bl, PSDCRobotAbility pSDCRobotAbility, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Energy(bl, pSDCRobotAbility, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExpiredTime(bl, pSDCRobotAbility, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDCRobotAbility, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCRobotAbilityId(bl, pSDCRobotAbility, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCRobotAbilityName(bl, pSDCRobotAbility, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCRobotId(bl, pSDCRobotAbility, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCRobotName(bl, pSDCRobotAbility, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterId(bl, pSDCRobotAbility, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterName(bl, pSDCRobotAbility, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSRobotAbilityId(bl, pSDCRobotAbility, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSRobotAbilityName(bl, pSDCRobotAbility, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RobotWorkType(bl, pSDCRobotAbility, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDCRobotAbility, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDCRobotAbility, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Energy(boolean bl, PSDCRobotAbility pSDCRobotAbility, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRobotAbility.isEnergyDirty() : !pSDCRobotAbility.isEnergyDirty()) {
            return null;
        }
        Integer n = pSDCRobotAbility.getEnergy();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Energy_Default((IEntity)pSDCRobotAbility, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENERGY");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExpiredTime(boolean bl, PSDCRobotAbility pSDCRobotAbility, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRobotAbility.isExpiredTimeDirty() : !pSDCRobotAbility.isExpiredTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDCRobotAbility.getExpiredTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ExpiredTime_Default((IEntity)pSDCRobotAbility, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXPIREDTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDCRobotAbility pSDCRobotAbility, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRobotAbility.isMemoDirty() : !pSDCRobotAbility.isMemoDirty()) {
            return null;
        }
        String string = pSDCRobotAbility.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDCRobotAbility, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDCRobotAbilityId(boolean bl, PSDCRobotAbility pSDCRobotAbility, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRobotAbility.isPSDCRobotAbilityIdDirty() && !bl2 : !pSDCRobotAbility.isPSDCRobotAbilityIdDirty()) {
            return null;
        }
        String string = pSDCRobotAbility.getPSDCRobotAbilityId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCROBOTABILITYID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCRobotAbilityId_Default((IEntity)pSDCRobotAbility, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCROBOTABILITYID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCRobotAbilityName(boolean bl, PSDCRobotAbility pSDCRobotAbility, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRobotAbility.isPSDCRobotAbilityNameDirty() && !bl2 : !pSDCRobotAbility.isPSDCRobotAbilityNameDirty()) {
            return null;
        }
        String string = pSDCRobotAbility.getPSDCRobotAbilityName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCROBOTABILITYNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCRobotAbilityName_Default((IEntity)pSDCRobotAbility, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCROBOTABILITYNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCRobotId(boolean bl, PSDCRobotAbility pSDCRobotAbility, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRobotAbility.isPSDCRobotIdDirty() : !pSDCRobotAbility.isPSDCRobotIdDirty()) {
            return null;
        }
        String string = pSDCRobotAbility.getPSDCRobotId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCRobotId_Default((IEntity)pSDCRobotAbility, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDCRobotName(boolean bl, PSDCRobotAbility pSDCRobotAbility, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRobotAbility.isPSDCRobotNameDirty() : !pSDCRobotAbility.isPSDCRobotNameDirty()) {
            return null;
        }
        String string = pSDCRobotAbility.getPSDCRobotName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCRobotName_Default((IEntity)pSDCRobotAbility, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevCenterId(boolean bl, PSDCRobotAbility pSDCRobotAbility, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRobotAbility.isPSDevCenterIdDirty() && !bl2 : !pSDCRobotAbility.isPSDevCenterIdDirty()) {
            return null;
        }
        String string = pSDCRobotAbility.getPSDevCenterId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterId_Default((IEntity)pSDCRobotAbility, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevCenterName(boolean bl, PSDCRobotAbility pSDCRobotAbility, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRobotAbility.isPSDevCenterNameDirty() && !bl2 : !pSDCRobotAbility.isPSDevCenterNameDirty()) {
            return null;
        }
        String string = pSDCRobotAbility.getPSDevCenterName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterName_Default((IEntity)pSDCRobotAbility, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSRobotAbilityId(boolean bl, PSDCRobotAbility pSDCRobotAbility, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRobotAbility.isPSRobotAbilityIdDirty() : !pSDCRobotAbility.isPSRobotAbilityIdDirty()) {
            return null;
        }
        String string = pSDCRobotAbility.getPSRobotAbilityId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSRobotAbilityId_Default((IEntity)pSDCRobotAbility, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSROBOTABILITYID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSRobotAbilityName(boolean bl, PSDCRobotAbility pSDCRobotAbility, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRobotAbility.isPSRobotAbilityNameDirty() : !pSDCRobotAbility.isPSRobotAbilityNameDirty()) {
            return null;
        }
        String string = pSDCRobotAbility.getPSRobotAbilityName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSRobotAbilityName_Default((IEntity)pSDCRobotAbility, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSROBOTABILITYNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RobotWorkType(boolean bl, PSDCRobotAbility pSDCRobotAbility, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRobotAbility.isRobotWorkTypeDirty() : !pSDCRobotAbility.isRobotWorkTypeDirty()) {
            return null;
        }
        String string = pSDCRobotAbility.getRobotWorkType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RobotWorkType_Default((IEntity)pSDCRobotAbility, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ROBOTWORKTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDCRobotAbility pSDCRobotAbility, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRobotAbility.isValidFlagDirty() && !bl2 : !pSDCRobotAbility.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDCRobotAbility.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSDCRobotAbility, bl2, bl3);
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

    protected void onSyncEntity(PSDCRobotAbility pSDCRobotAbility, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDCRobotAbility, bl);
    }

    protected void onSyncIndexEntities(PSDCRobotAbility pSDCRobotAbility, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDCRobotAbility, bl);
    }

    public Object getDataContextValue(PSDCRobotAbility pSDCRobotAbility, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDCRobotAbility, string, iDataContextParam)) != null) {
            return object;
        }
        PSDCRobot pSDCRobot = pSDCRobotAbility.getPSDCRobot();
        if (pSDCRobot != null && pSDCRobot.contains(string)) {
            return pSDCRobot.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDCRobotAbility pSDCRobotAbility, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDCRobotAbility, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENERGY", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Energy_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXPIREDTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExpiredTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCROBOTABILITYID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCRobotAbilityId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCROBOTABILITYNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCRobotAbilityName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSROBOTABILITYID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSRobotAbilityId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSROBOTABILITYNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSRobotAbilityName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ROBOTWORKTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RobotWorkType_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_Energy_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ExpiredTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Memo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCRobotAbilityId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCROBOTABILITYID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCRobotAbilityName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCROBOTABILITYNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_PSRobotAbilityId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSROBOTABILITYID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSRobotAbilityName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSROBOTABILITYNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RobotWorkType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ROBOTWORKTYPE", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
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

    protected boolean onMergeChild(String string, String string2, PSDCRobotAbility pSDCRobotAbility) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDCRobotAbility)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDCRobotAbility pSDCRobotAbility) throws Exception {
        super.onUpdateParent((IEntity)pSDCRobotAbility);
    }

    @Override
    protected void exportCurXmlModel(PSDCRobotAbility pSDCRobotAbility, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDCROBOTABILITY");
        if (!bl) {
            pSDCRobotAbility.setCreateDate(null);
            pSDCRobotAbility.setCreateMan(null);
            pSDCRobotAbility.setPSDCRobotAbilityId(null);
            pSDCRobotAbility.setUpdateDate(null);
            pSDCRobotAbility.setUpdateMan(null);
            super.exportCurXmlModel(pSDCRobotAbility, xmlNode, bl);
        }
    }
}

