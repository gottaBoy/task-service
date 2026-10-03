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
import net.ibizsys.pscore.srv.config.entity.PSDBType;
import net.ibizsys.pscore.srv.config.entity.PSDBTypeBase;
import net.ibizsys.pscore.srv.config.entity.PSPF;
import net.ibizsys.pscore.srv.config.entity.PSPFBase;
import net.ibizsys.pscore.srv.config.entity.PSPFStyle;
import net.ibizsys.pscore.srv.config.entity.PSPFStyleBase;
import net.ibizsys.pscore.srv.config.entity.PSSF;
import net.ibizsys.pscore.srv.config.entity.PSSFBase;
import net.ibizsys.pscore.srv.config.entity.PSSFStyle;
import net.ibizsys.pscore.srv.config.entity.PSSFStyleBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.devcenter.dao.PSDCAbilityDAO;
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCAbilityDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCAbility;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCAbilityServiceBase
extends PSCoreSysServiceBase<PSDCAbility> {
    private static final Log log = LogFactory.getLog(PSDCAbilityServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDCAbilityDEModel pSDCAbilityDEModel;
    private PSDCAbilityDAO pSDCAbilityDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.devcenter.service.PSDCAbilityService";
    }

    public PSDCAbilityDEModel getPSDCAbilityDEModel() {
        if (this.pSDCAbilityDEModel == null) {
            try {
                this.pSDCAbilityDEModel = (PSDCAbilityDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCAbilityDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCAbilityDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDCAbilityDEModel();
    }

    public PSDCAbilityDAO getPSDCAbilityDAO() {
        if (this.pSDCAbilityDAO == null) {
            try {
                this.pSDCAbilityDAO = (PSDCAbilityDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.devcenter.dao.PSDCAbilityDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCAbilityDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDCAbilityDAO();
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

    protected void onFillParentInfo(PSDCAbility pSDCAbility, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCABILITY_PSDBTYPE_PSDBTYPEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSDBTypeService", (SessionFactory)this.getSessionFactory());
            PSDBType pSDBType = (PSDBType)iService.getDEModel().createEntity();
            pSDBType.set("PSDBTYPEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDBType);
            } else {
                iService.get(pSDBType);
            }
            this.onFillParentInfo_PSDBType(pSDCAbility, pSDBType);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCABILITY_PSDEVCENTER_PSDEVCENTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService", (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = (PSDevCenter)iService.getDEModel().createEntity();
            pSDevCenter.set("PSDEVCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenter);
            } else {
                iService.get(pSDevCenter);
            }
            this.onFillParentInfo_PSDevCenter(pSDCAbility, pSDevCenter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCABILITY_PSPFSTYLE_PSPFSTYLEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFStyleService", (SessionFactory)this.getSessionFactory());
            PSPFStyle pSPFStyle = (PSPFStyle)iService.getDEModel().createEntity();
            pSPFStyle.set("PSPFSTYLEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSPFStyle);
            } else {
                iService.get(pSPFStyle);
            }
            this.onFillParentInfo_PSPSStyle(pSDCAbility, pSPFStyle);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCABILITY_PSPF_PSPFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFService", (SessionFactory)this.getSessionFactory());
            PSPF pSPF = (PSPF)iService.getDEModel().createEntity();
            pSPF.set("PSPFID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSPF);
            } else {
                iService.get(pSPF);
            }
            this.onFillParentInfo_PSPF(pSDCAbility, pSPF);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCABILITY_PSSFSTYLE_PSSFSTYLEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFStyleService", (SessionFactory)this.getSessionFactory());
            PSSFStyle pSSFStyle = (PSSFStyle)iService.getDEModel().createEntity();
            pSSFStyle.set("PSSFSTYLEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSFStyle);
            } else {
                iService.get(pSSFStyle);
            }
            this.onFillParentInfo_PSSFStyle(pSDCAbility, pSSFStyle);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCABILITY_PSSF_PSSFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFService", (SessionFactory)this.getSessionFactory());
            PSSF pSSF = (PSSF)iService.getDEModel().createEntity();
            pSSF.set("PSSFID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSF);
            } else {
                iService.get(pSSF);
            }
            this.onFillParentInfo_PSSF(pSDCAbility, pSSF);
            return;
        }
        super.onFillParentInfo(pSDCAbility, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDBType(PSDCAbility pSDCAbility, PSDBType pSDBType) throws Exception {
        pSDCAbility.setPSDBTypeId(pSDBType.getPSDBTypeId());
        pSDCAbility.setPSDBTypeName(pSDBType.getPSDBTypeName());
    }

    protected void onFillParentInfo_PSDevCenter(PSDCAbility pSDCAbility, PSDevCenter pSDevCenter) throws Exception {
        pSDCAbility.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
        pSDCAbility.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
    }

    protected void onFillParentInfo_PSPSStyle(PSDCAbility pSDCAbility, PSPFStyle pSPFStyle) throws Exception {
        pSDCAbility.setPSPFStyleId(pSPFStyle.getPSPFStyleId());
        pSDCAbility.setPSPFStyleName(pSPFStyle.getPSPFStyleName());
    }

    protected void onFillParentInfo_PSPF(PSDCAbility pSDCAbility, PSPF pSPF) throws Exception {
        pSDCAbility.setPSPFId(pSPF.getPSPFId());
        pSDCAbility.setPSPFName(pSPF.getPSPFName());
    }

    protected void onFillParentInfo_PSSFStyle(PSDCAbility pSDCAbility, PSSFStyle pSSFStyle) throws Exception {
        pSDCAbility.setPSSFStyleId(pSSFStyle.getPSSFStyleId());
        pSDCAbility.setPSSFStyleName(pSSFStyle.getPSSFStyleName());
    }

    protected void onFillParentInfo_PSSF(PSDCAbility pSDCAbility, PSSF pSSF) throws Exception {
        pSDCAbility.setPSSFId(pSSF.getPSSFId());
        pSDCAbility.setPSSFName(pSSF.getPSSFName());
    }

    protected void onFillEntityFullInfo(PSDCAbility pSDCAbility, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDCAbility, bl);
        this.onFillEntityFullInfo_PSDBType(pSDCAbility, bl);
        this.onFillEntityFullInfo_PSDevCenter(pSDCAbility, bl);
        this.onFillEntityFullInfo_PSPSStyle(pSDCAbility, bl);
        this.onFillEntityFullInfo_PSPF(pSDCAbility, bl);
        this.onFillEntityFullInfo_PSSFStyle(pSDCAbility, bl);
        this.onFillEntityFullInfo_PSSF(pSDCAbility, bl);
    }

    protected void onFillEntityFullInfo_PSDBType(PSDCAbility pSDCAbility, boolean bl) throws Exception {
        if (pSDCAbility.isPSDBTypeIdDirty()) {
            if (pSDCAbility.getPSDBTypeId() != null) {
                if (pSDCAbility.getPSDBTypeId() == null || pSDCAbility.getPSDBTypeName() == null) {
                    PSDBType pSDBType = pSDCAbility.getPSDBType();
                    pSDCAbility.setPSDBTypeName(pSDBType.getPSDBTypeName());
                }
            } else {
                pSDCAbility.setPSDBTypeName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDevCenter(PSDCAbility pSDCAbility, boolean bl) throws Exception {
        if (pSDCAbility.isPSDevCenterIdDirty()) {
            if (pSDCAbility.getPSDevCenterId() != null) {
                if (pSDCAbility.getPSDevCenterId() == null || pSDCAbility.getPSDevCenterName() == null) {
                    PSDevCenter pSDevCenter = pSDCAbility.getPSDevCenter();
                    pSDCAbility.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
                }
            } else {
                pSDCAbility.setPSDevCenterName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSPSStyle(PSDCAbility pSDCAbility, boolean bl) throws Exception {
        if (pSDCAbility.isPSPFStyleIdDirty()) {
            if (pSDCAbility.getPSPFStyleId() != null) {
                if (pSDCAbility.getPSPFStyleId() == null || pSDCAbility.getPSPFStyleName() == null) {
                    PSPFStyle pSPFStyle = pSDCAbility.getPSPSStyle();
                    pSDCAbility.setPSPFStyleName(pSPFStyle.getPSPFStyleName());
                }
            } else {
                pSDCAbility.setPSPFStyleName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSPF(PSDCAbility pSDCAbility, boolean bl) throws Exception {
        if (pSDCAbility.isPSPFIdDirty()) {
            if (pSDCAbility.getPSPFId() != null) {
                if (pSDCAbility.getPSPFId() == null || pSDCAbility.getPSPFName() == null) {
                    PSPF pSPF = pSDCAbility.getPSPF();
                    pSDCAbility.setPSPFName(pSPF.getPSPFName());
                }
            } else {
                pSDCAbility.setPSPFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSFStyle(PSDCAbility pSDCAbility, boolean bl) throws Exception {
        if (pSDCAbility.isPSSFStyleIdDirty()) {
            if (pSDCAbility.getPSSFStyleId() != null) {
                if (pSDCAbility.getPSSFStyleId() == null || pSDCAbility.getPSSFStyleName() == null) {
                    PSSFStyle pSSFStyle = pSDCAbility.getPSSFStyle();
                    pSDCAbility.setPSSFStyleName(pSSFStyle.getPSSFStyleName());
                }
            } else {
                pSDCAbility.setPSSFStyleName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSF(PSDCAbility pSDCAbility, boolean bl) throws Exception {
        if (pSDCAbility.isPSSFIdDirty()) {
            if (pSDCAbility.getPSSFId() != null) {
                if (pSDCAbility.getPSSFId() == null || pSDCAbility.getPSSFName() == null) {
                    PSSF pSSF = pSDCAbility.getPSSF();
                    pSDCAbility.setPSSFName(pSSF.getPSSFName());
                }
            } else {
                pSDCAbility.setPSSFName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDCAbility pSDCAbility, boolean bl) throws Exception {
        super.onWriteBackParent(pSDCAbility, bl);
    }

    public ArrayList<PSDCAbility> selectByPSDBType(PSDBTypeBase pSDBTypeBase) throws Exception {
        return this.selectByPSDBType(pSDBTypeBase, "", -1);
    }

    public ArrayList<PSDCAbility> selectByPSDBType(PSDBTypeBase pSDBTypeBase, String string) throws Exception {
        return this.selectByPSDBType(pSDBTypeBase, string, -1);
    }

    public ArrayList<PSDCAbility> selectByPSDBType(PSDBTypeBase pSDBTypeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDBTYPEID", (Object)pSDBTypeBase.getPSDBTypeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDBTypeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDBTypeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDCAbility> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, "", -1);
    }

    public ArrayList<PSDCAbility> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, string, -1);
    }

    public ArrayList<PSDCAbility> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string, int n) throws Exception {
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

    public ArrayList<PSDCAbility> selectByPSPSStyle(PSPFStyleBase pSPFStyleBase) throws Exception {
        return this.selectByPSPSStyle(pSPFStyleBase, "", -1);
    }

    public ArrayList<PSDCAbility> selectByPSPSStyle(PSPFStyleBase pSPFStyleBase, String string) throws Exception {
        return this.selectByPSPSStyle(pSPFStyleBase, string, -1);
    }

    public ArrayList<PSDCAbility> selectByPSPSStyle(PSPFStyleBase pSPFStyleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSPFSTYLEID", (Object)pSPFStyleBase.getPSPFStyleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSPSStyleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSPSStyleCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDCAbility> selectByPSPF(PSPFBase pSPFBase) throws Exception {
        return this.selectByPSPF(pSPFBase, "", -1);
    }

    public ArrayList<PSDCAbility> selectByPSPF(PSPFBase pSPFBase, String string) throws Exception {
        return this.selectByPSPF(pSPFBase, string, -1);
    }

    public ArrayList<PSDCAbility> selectByPSPF(PSPFBase pSPFBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSPFID", (Object)pSPFBase.getPSPFId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSPFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSPFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDCAbility> selectByPSSFStyle(PSSFStyleBase pSSFStyleBase) throws Exception {
        return this.selectByPSSFStyle(pSSFStyleBase, "", -1);
    }

    public ArrayList<PSDCAbility> selectByPSSFStyle(PSSFStyleBase pSSFStyleBase, String string) throws Exception {
        return this.selectByPSSFStyle(pSSFStyleBase, string, -1);
    }

    public ArrayList<PSDCAbility> selectByPSSFStyle(PSSFStyleBase pSSFStyleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSFSTYLEID", (Object)pSSFStyleBase.getPSSFStyleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSFStyleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSFStyleCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDCAbility> selectByPSSF(PSSFBase pSSFBase) throws Exception {
        return this.selectByPSSF(pSSFBase, "", -1);
    }

    public ArrayList<PSDCAbility> selectByPSSF(PSSFBase pSSFBase, String string) throws Exception {
        return this.selectByPSSF(pSSFBase, string, -1);
    }

    public ArrayList<PSDCAbility> selectByPSSF(PSSFBase pSSFBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSFID", (Object)pSSFBase.getPSSFId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSFCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDBType(PSDBType pSDBType) throws Exception {
        ArrayList<PSDCAbility> arrayList = this.selectByPSDBType(pSDBType, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDBTYPE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDBType);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCABILITY_PSDBTYPE_PSDBTYPEID", "", iDataEntityModel.getName(), "PSDCABILITY", iDataEntityModel.getDataInfo(pSDBType), arrayList.get(0)));
        }
    }

    public void resetPSDBType(PSDBType pSDBType) throws Exception {
        ArrayList<PSDCAbility> arrayList = this.selectByPSDBType(pSDBType);
        for (PSDCAbility pSDCAbility : arrayList) {
            PSDCAbility pSDCAbility2 = (PSDCAbility)this.getDEModel().createEntity();
            pSDCAbility2.setPSDCAbilityId(pSDCAbility.getPSDCAbilityId());
            pSDCAbility2.setPSDBTypeId(null);
            this.update(pSDCAbility2);
        }
    }

    public void removeByPSDBType(PSDBType pSDBType) throws Exception {
        final PSDBType pSDBType2 = pSDBType;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCAbilityServiceBase.this.onBeforeRemoveByPSDBType(pSDBType2);
                PSDCAbilityServiceBase.this.internalRemoveByPSDBType(pSDBType2);
                PSDCAbilityServiceBase.this.onAfterRemoveByPSDBType(pSDBType2);
            }
        });
    }

    protected void onBeforeRemoveByPSDBType(PSDBType pSDBType) throws Exception {
    }

    protected void internalRemoveByPSDBType(PSDBType pSDBType) throws Exception {
        ArrayList<PSDCAbility> arrayList = this.selectByPSDBType(pSDBType);
        this.onBeforeRemoveByPSDBType(pSDBType, arrayList);
        for (PSDCAbility pSDCAbility : arrayList) {
            this.remove(pSDCAbility);
        }
        this.onAfterRemoveByPSDBType(pSDBType, arrayList);
    }

    protected void onAfterRemoveByPSDBType(PSDBType pSDBType) throws Exception {
    }

    protected void onBeforeRemoveByPSDBType(PSDBType pSDBType, ArrayList<PSDCAbility> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDBType(PSDBType pSDBType, ArrayList<PSDCAbility> arrayList) throws Exception {
    }

    public void testRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDCAbility> arrayList = this.selectByPSDevCenter(pSDevCenter, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenter);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCABILITY_PSDEVCENTER_PSDEVCENTERID", "", iDataEntityModel.getName(), "PSDCABILITY", iDataEntityModel.getDataInfo(pSDevCenter), arrayList.get(0)));
        }
    }

    public void resetPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDCAbility> arrayList = this.selectByPSDevCenter(pSDevCenter);
        for (PSDCAbility pSDCAbility : arrayList) {
            PSDCAbility pSDCAbility2 = (PSDCAbility)this.getDEModel().createEntity();
            pSDCAbility2.setPSDCAbilityId(pSDCAbility.getPSDCAbilityId());
            pSDCAbility2.setPSDevCenterId(null);
            this.update(pSDCAbility2);
        }
    }

    public void removeByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCAbilityServiceBase.this.onBeforeRemoveByPSDevCenter(pSDevCenter2);
                PSDCAbilityServiceBase.this.internalRemoveByPSDevCenter(pSDevCenter2);
                PSDCAbilityServiceBase.this.onAfterRemoveByPSDevCenter(pSDevCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void internalRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDCAbility> arrayList = this.selectByPSDevCenter(pSDevCenter);
        this.onBeforeRemoveByPSDevCenter(pSDevCenter, arrayList);
        for (PSDCAbility pSDCAbility : arrayList) {
            this.remove(pSDCAbility);
        }
        this.onAfterRemoveByPSDevCenter(pSDevCenter, arrayList);
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDCAbility> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDCAbility> arrayList) throws Exception {
    }

    public void testRemoveByPSPSStyle(PSPFStyle pSPFStyle) throws Exception {
        ArrayList<PSDCAbility> arrayList = this.selectByPSPSStyle(pSPFStyle, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSPFSTYLE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSPFStyle);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCABILITY_PSPFSTYLE_PSPFSTYLEID", "", iDataEntityModel.getName(), "PSDCABILITY", iDataEntityModel.getDataInfo(pSPFStyle), arrayList.get(0)));
        }
    }

    public void resetPSPSStyle(PSPFStyle pSPFStyle) throws Exception {
        ArrayList<PSDCAbility> arrayList = this.selectByPSPSStyle(pSPFStyle);
        for (PSDCAbility pSDCAbility : arrayList) {
            PSDCAbility pSDCAbility2 = (PSDCAbility)this.getDEModel().createEntity();
            pSDCAbility2.setPSDCAbilityId(pSDCAbility.getPSDCAbilityId());
            pSDCAbility2.setPSPFStyleId(null);
            this.update(pSDCAbility2);
        }
    }

    public void removeByPSPSStyle(PSPFStyle pSPFStyle) throws Exception {
        final PSPFStyle pSPFStyle2 = pSPFStyle;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCAbilityServiceBase.this.onBeforeRemoveByPSPSStyle(pSPFStyle2);
                PSDCAbilityServiceBase.this.internalRemoveByPSPSStyle(pSPFStyle2);
                PSDCAbilityServiceBase.this.onAfterRemoveByPSPSStyle(pSPFStyle2);
            }
        });
    }

    protected void onBeforeRemoveByPSPSStyle(PSPFStyle pSPFStyle) throws Exception {
    }

    protected void internalRemoveByPSPSStyle(PSPFStyle pSPFStyle) throws Exception {
        ArrayList<PSDCAbility> arrayList = this.selectByPSPSStyle(pSPFStyle);
        this.onBeforeRemoveByPSPSStyle(pSPFStyle, arrayList);
        for (PSDCAbility pSDCAbility : arrayList) {
            this.remove(pSDCAbility);
        }
        this.onAfterRemoveByPSPSStyle(pSPFStyle, arrayList);
    }

    protected void onAfterRemoveByPSPSStyle(PSPFStyle pSPFStyle) throws Exception {
    }

    protected void onBeforeRemoveByPSPSStyle(PSPFStyle pSPFStyle, ArrayList<PSDCAbility> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSPSStyle(PSPFStyle pSPFStyle, ArrayList<PSDCAbility> arrayList) throws Exception {
    }

    public void testRemoveByPSPF(PSPF pSPF) throws Exception {
        ArrayList<PSDCAbility> arrayList = this.selectByPSPF(pSPF, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSPF");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSPF);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCABILITY_PSPF_PSPFID", "", iDataEntityModel.getName(), "PSDCABILITY", iDataEntityModel.getDataInfo(pSPF), arrayList.get(0)));
        }
    }

    public void resetPSPF(PSPF pSPF) throws Exception {
        ArrayList<PSDCAbility> arrayList = this.selectByPSPF(pSPF);
        for (PSDCAbility pSDCAbility : arrayList) {
            PSDCAbility pSDCAbility2 = (PSDCAbility)this.getDEModel().createEntity();
            pSDCAbility2.setPSDCAbilityId(pSDCAbility.getPSDCAbilityId());
            pSDCAbility2.setPSPFId(null);
            this.update(pSDCAbility2);
        }
    }

    public void removeByPSPF(PSPF pSPF) throws Exception {
        final PSPF pSPF2 = pSPF;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCAbilityServiceBase.this.onBeforeRemoveByPSPF(pSPF2);
                PSDCAbilityServiceBase.this.internalRemoveByPSPF(pSPF2);
                PSDCAbilityServiceBase.this.onAfterRemoveByPSPF(pSPF2);
            }
        });
    }

    protected void onBeforeRemoveByPSPF(PSPF pSPF) throws Exception {
    }

    protected void internalRemoveByPSPF(PSPF pSPF) throws Exception {
        ArrayList<PSDCAbility> arrayList = this.selectByPSPF(pSPF);
        this.onBeforeRemoveByPSPF(pSPF, arrayList);
        for (PSDCAbility pSDCAbility : arrayList) {
            this.remove(pSDCAbility);
        }
        this.onAfterRemoveByPSPF(pSPF, arrayList);
    }

    protected void onAfterRemoveByPSPF(PSPF pSPF) throws Exception {
    }

    protected void onBeforeRemoveByPSPF(PSPF pSPF, ArrayList<PSDCAbility> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSPF(PSPF pSPF, ArrayList<PSDCAbility> arrayList) throws Exception {
    }

    public void testRemoveByPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
        ArrayList<PSDCAbility> arrayList = this.selectByPSSFStyle(pSSFStyle, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSFSTYLE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSFStyle);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCABILITY_PSSFSTYLE_PSSFSTYLEID", "", iDataEntityModel.getName(), "PSDCABILITY", iDataEntityModel.getDataInfo(pSSFStyle), arrayList.get(0)));
        }
    }

    public void resetPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
        ArrayList<PSDCAbility> arrayList = this.selectByPSSFStyle(pSSFStyle);
        for (PSDCAbility pSDCAbility : arrayList) {
            PSDCAbility pSDCAbility2 = (PSDCAbility)this.getDEModel().createEntity();
            pSDCAbility2.setPSDCAbilityId(pSDCAbility.getPSDCAbilityId());
            pSDCAbility2.setPSSFStyleId(null);
            this.update(pSDCAbility2);
        }
    }

    public void removeByPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
        final PSSFStyle pSSFStyle2 = pSSFStyle;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCAbilityServiceBase.this.onBeforeRemoveByPSSFStyle(pSSFStyle2);
                PSDCAbilityServiceBase.this.internalRemoveByPSSFStyle(pSSFStyle2);
                PSDCAbilityServiceBase.this.onAfterRemoveByPSSFStyle(pSSFStyle2);
            }
        });
    }

    protected void onBeforeRemoveByPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
    }

    protected void internalRemoveByPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
        ArrayList<PSDCAbility> arrayList = this.selectByPSSFStyle(pSSFStyle);
        this.onBeforeRemoveByPSSFStyle(pSSFStyle, arrayList);
        for (PSDCAbility pSDCAbility : arrayList) {
            this.remove(pSDCAbility);
        }
        this.onAfterRemoveByPSSFStyle(pSSFStyle, arrayList);
    }

    protected void onAfterRemoveByPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
    }

    protected void onBeforeRemoveByPSSFStyle(PSSFStyle pSSFStyle, ArrayList<PSDCAbility> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSFStyle(PSSFStyle pSSFStyle, ArrayList<PSDCAbility> arrayList) throws Exception {
    }

    public void testRemoveByPSSF(PSSF pSSF) throws Exception {
        ArrayList<PSDCAbility> arrayList = this.selectByPSSF(pSSF, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSF");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSF);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCABILITY_PSSF_PSSFID", "", iDataEntityModel.getName(), "PSDCABILITY", iDataEntityModel.getDataInfo(pSSF), arrayList.get(0)));
        }
    }

    public void resetPSSF(PSSF pSSF) throws Exception {
        ArrayList<PSDCAbility> arrayList = this.selectByPSSF(pSSF);
        for (PSDCAbility pSDCAbility : arrayList) {
            PSDCAbility pSDCAbility2 = (PSDCAbility)this.getDEModel().createEntity();
            pSDCAbility2.setPSDCAbilityId(pSDCAbility.getPSDCAbilityId());
            pSDCAbility2.setPSSFId(null);
            this.update(pSDCAbility2);
        }
    }

    public void removeByPSSF(PSSF pSSF) throws Exception {
        final PSSF pSSF2 = pSSF;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCAbilityServiceBase.this.onBeforeRemoveByPSSF(pSSF2);
                PSDCAbilityServiceBase.this.internalRemoveByPSSF(pSSF2);
                PSDCAbilityServiceBase.this.onAfterRemoveByPSSF(pSSF2);
            }
        });
    }

    protected void onBeforeRemoveByPSSF(PSSF pSSF) throws Exception {
    }

    protected void internalRemoveByPSSF(PSSF pSSF) throws Exception {
        ArrayList<PSDCAbility> arrayList = this.selectByPSSF(pSSF);
        this.onBeforeRemoveByPSSF(pSSF, arrayList);
        for (PSDCAbility pSDCAbility : arrayList) {
            this.remove(pSDCAbility);
        }
        this.onAfterRemoveByPSSF(pSSF, arrayList);
    }

    protected void onAfterRemoveByPSSF(PSSF pSSF) throws Exception {
    }

    protected void onBeforeRemoveByPSSF(PSSF pSSF, ArrayList<PSDCAbility> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSF(PSSF pSSF, ArrayList<PSDCAbility> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDCAbility pSDCAbility) throws Exception {
        super.onBeforeRemove(pSDCAbility);
    }

    protected void replaceParentInfo(PSDCAbility pSDCAbility, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDCAbility, cloneSession);
        if (pSDCAbility.getPSDBTypeId() != null && (iEntity = cloneSession.getEntity("PSDBTYPE", (Object)pSDCAbility.getPSDBTypeId())) != null) {
            this.onFillParentInfo_PSDBType(pSDCAbility, (PSDBType)iEntity);
        }
        if (pSDCAbility.getPSDevCenterId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTER", (Object)pSDCAbility.getPSDevCenterId())) != null) {
            this.onFillParentInfo_PSDevCenter(pSDCAbility, (PSDevCenter)iEntity);
        }
        if (pSDCAbility.getPSPFStyleId() != null && (iEntity = cloneSession.getEntity("PSPFSTYLE", (Object)pSDCAbility.getPSPFStyleId())) != null) {
            this.onFillParentInfo_PSPSStyle(pSDCAbility, (PSPFStyle)iEntity);
        }
        if (pSDCAbility.getPSPFId() != null && (iEntity = cloneSession.getEntity("PSPF", (Object)pSDCAbility.getPSPFId())) != null) {
            this.onFillParentInfo_PSPF(pSDCAbility, (PSPF)iEntity);
        }
        if (pSDCAbility.getPSSFStyleId() != null && (iEntity = cloneSession.getEntity("PSSFSTYLE", (Object)pSDCAbility.getPSSFStyleId())) != null) {
            this.onFillParentInfo_PSSFStyle(pSDCAbility, (PSSFStyle)iEntity);
        }
        if (pSDCAbility.getPSSFId() != null && (iEntity = cloneSession.getEntity("PSSF", (Object)pSDCAbility.getPSSFId())) != null) {
            this.onFillParentInfo_PSSF(pSDCAbility, (PSSF)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDCAbility pSDCAbility, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDCAbility, bl);
    }

    protected void onCheckEntity(boolean bl, PSDCAbility pSDCAbility, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AbilityCat(bl, pSDCAbility, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BeginTime(bl, pSDCAbility, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EndTime(bl, pSDCAbility, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDCAbility, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDBTypeId(bl, pSDCAbility, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDBTypeName(bl, pSDCAbility, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCAbilityId(bl, pSDCAbility, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCAbilityName(bl, pSDCAbility, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterId(bl, pSDCAbility, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterName(bl, pSDCAbility, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFId(bl, pSDCAbility, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFName(bl, pSDCAbility, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFStyleId(bl, pSDCAbility, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFStyleName(bl, pSDCAbility, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFId(bl, pSDCAbility, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFName(bl, pSDCAbility, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFStyleId(bl, pSDCAbility, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFStyleName(bl, pSDCAbility, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDCAbility, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AbilityCat(boolean bl, PSDCAbility pSDCAbility, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCAbility.isAbilityCatDirty() && !bl2 : !pSDCAbility.isAbilityCatDirty()) {
            return null;
        }
        String string = pSDCAbility.getAbilityCat();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ABILITYCAT");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_AbilityCat_Default(pSDCAbility, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ABILITYCAT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BeginTime(boolean bl, PSDCAbility pSDCAbility, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCAbility.isBeginTimeDirty() : !pSDCAbility.isBeginTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDCAbility.getBeginTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_BeginTime_Default(pSDCAbility, bl2, bl3);
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

    protected EntityFieldError onCheckField_EndTime(boolean bl, PSDCAbility pSDCAbility, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCAbility.isEndTimeDirty() : !pSDCAbility.isEndTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDCAbility.getEndTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EndTime_Default(pSDCAbility, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDCAbility pSDCAbility, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCAbility.isMemoDirty() : !pSDCAbility.isMemoDirty()) {
            return null;
        }
        String string = pSDCAbility.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDCAbility, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDBTypeId(boolean bl, PSDCAbility pSDCAbility, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCAbility.isPSDBTypeIdDirty() : !pSDCAbility.isPSDBTypeIdDirty()) {
            return null;
        }
        String string = pSDCAbility.getPSDBTypeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDBTypeId_Default(pSDCAbility, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDBTYPEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDBTypeName(boolean bl, PSDCAbility pSDCAbility, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCAbility.isPSDBTypeNameDirty() : !pSDCAbility.isPSDBTypeNameDirty()) {
            return null;
        }
        String string = pSDCAbility.getPSDBTypeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDBTypeName_Default(pSDCAbility, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDBTYPENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCAbilityId(boolean bl, PSDCAbility pSDCAbility, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCAbility.isPSDCAbilityIdDirty() && !bl2 : !pSDCAbility.isPSDCAbilityIdDirty()) {
            return null;
        }
        String string = pSDCAbility.getPSDCAbilityId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCABILITYID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCAbilityId_Default(pSDCAbility, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCABILITYID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCAbilityName(boolean bl, PSDCAbility pSDCAbility, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCAbility.isPSDCAbilityNameDirty() && !bl2 : !pSDCAbility.isPSDCAbilityNameDirty()) {
            return null;
        }
        String string = pSDCAbility.getPSDCAbilityName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCABILITYNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCAbilityName_Default(pSDCAbility, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCABILITYNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterId(boolean bl, PSDCAbility pSDCAbility, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCAbility.isPSDevCenterIdDirty() : !pSDCAbility.isPSDevCenterIdDirty()) {
            return null;
        }
        String string = pSDCAbility.getPSDevCenterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterId_Default(pSDCAbility, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevCenterName(boolean bl, PSDCAbility pSDCAbility, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCAbility.isPSDevCenterNameDirty() : !pSDCAbility.isPSDevCenterNameDirty()) {
            return null;
        }
        String string = pSDCAbility.getPSDevCenterName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterName_Default(pSDCAbility, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSPFId(boolean bl, PSDCAbility pSDCAbility, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCAbility.isPSPFIdDirty() : !pSDCAbility.isPSPFIdDirty()) {
            return null;
        }
        String string = pSDCAbility.getPSPFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFId_Default(pSDCAbility, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFName(boolean bl, PSDCAbility pSDCAbility, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCAbility.isPSPFNameDirty() : !pSDCAbility.isPSPFNameDirty()) {
            return null;
        }
        String string = pSDCAbility.getPSPFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFName_Default(pSDCAbility, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFStyleId(boolean bl, PSDCAbility pSDCAbility, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCAbility.isPSPFStyleIdDirty() : !pSDCAbility.isPSPFStyleIdDirty()) {
            return null;
        }
        String string = pSDCAbility.getPSPFStyleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFStyleId_Default(pSDCAbility, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFSTYLEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFStyleName(boolean bl, PSDCAbility pSDCAbility, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCAbility.isPSPFStyleNameDirty() : !pSDCAbility.isPSPFStyleNameDirty()) {
            return null;
        }
        String string = pSDCAbility.getPSPFStyleName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFStyleName_Default(pSDCAbility, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFSTYLENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFId(boolean bl, PSDCAbility pSDCAbility, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCAbility.isPSSFIdDirty() : !pSDCAbility.isPSSFIdDirty()) {
            return null;
        }
        String string = pSDCAbility.getPSSFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFId_Default(pSDCAbility, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFName(boolean bl, PSDCAbility pSDCAbility, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCAbility.isPSSFNameDirty() : !pSDCAbility.isPSSFNameDirty()) {
            return null;
        }
        String string = pSDCAbility.getPSSFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFName_Default(pSDCAbility, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFStyleId(boolean bl, PSDCAbility pSDCAbility, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCAbility.isPSSFStyleIdDirty() : !pSDCAbility.isPSSFStyleIdDirty()) {
            return null;
        }
        String string = pSDCAbility.getPSSFStyleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFStyleId_Default(pSDCAbility, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFSTYLEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFStyleName(boolean bl, PSDCAbility pSDCAbility, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCAbility.isPSSFStyleNameDirty() : !pSDCAbility.isPSSFStyleNameDirty()) {
            return null;
        }
        String string = pSDCAbility.getPSSFStyleName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFStyleName_Default(pSDCAbility, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFSTYLENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDCAbility pSDCAbility, boolean bl) throws Exception {
        super.onSyncEntity(pSDCAbility, bl);
    }

    protected void onSyncIndexEntities(PSDCAbility pSDCAbility, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDCAbility, bl);
    }

    public Object getDataContextValue(PSDCAbility pSDCAbility, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDCAbility, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDCAbility pSDCAbility, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDCAbility, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ABILITYCAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AbilityCat_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDBTYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDBTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDBTYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDBTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCABILITYID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCAbilityId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCABILITYNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCAbilityName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFSTYLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFStyleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFSTYLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFStyleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFSTYLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFStyleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFSTYLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFStyleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_AbilityCat_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ABILITYCAT", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
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

    protected String onTestValueRule_PSDBTypeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDBTYPEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDBTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDBTYPENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCAbilityId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCABILITYID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCAbilityName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCABILITYNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSPFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFStyleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFSTYLEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFStyleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFSTYLENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFStyleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFSTYLEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFStyleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFSTYLENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDCAbility pSDCAbility) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDCAbility)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDCAbility pSDCAbility) throws Exception {
        super.onUpdateParent(pSDCAbility);
    }

    @Override
    protected void exportCurXmlModel(PSDCAbility pSDCAbility, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDCABILITY");
        if (!bl) {
            pSDCAbility.setCreateDate(null);
            pSDCAbility.setCreateMan(null);
            pSDCAbility.setPSDCAbilityId(null);
            pSDCAbility.setUpdateDate(null);
            pSDCAbility.setUpdateMan(null);
            super.exportCurXmlModel(pSDCAbility, xmlNode, bl);
        }
    }
}

