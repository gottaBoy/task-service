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
package net.ibizsys.pscore.srv.config.service;

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
import net.ibizsys.pscore.srv.config.dao.PSSFStyleDAO;
import net.ibizsys.pscore.srv.config.demodel.PSSFStyleDEModel;
import net.ibizsys.pscore.srv.config.entity.PSSF;
import net.ibizsys.pscore.srv.config.entity.PSSFBase;
import net.ibizsys.pscore.srv.config.entity.PSSFStyle;
import net.ibizsys.pscore.srv.config.entity.PSSFStyleBase;
import net.ibizsys.pscore.srv.config.service.PSSFCodeFolderService;
import net.ibizsys.pscore.srv.config.service.PSSFCodeFolderServiceBase;
import net.ibizsys.pscore.srv.config.service.PSSFCtrlTypeService;
import net.ibizsys.pscore.srv.config.service.PSSFCtrlTypeServiceBase;
import net.ibizsys.pscore.srv.config.service.PSSFPubOjbService;
import net.ibizsys.pscore.srv.config.service.PSSFPubOjbServiceBase;
import net.ibizsys.pscore.srv.config.service.PSSFStyleCodeService;
import net.ibizsys.pscore.srv.config.service.PSSFStyleCodeServiceBase;
import net.ibizsys.pscore.srv.config.service.PSSFStyleLogService;
import net.ibizsys.pscore.srv.config.service.PSSFStyleLogServiceBase;
import net.ibizsys.pscore.srv.config.service.PSSFStyleParamService;
import net.ibizsys.pscore.srv.config.service.PSSFStyleParamServiceBase;
import net.ibizsys.pscore.srv.config.service.PSSFStylePkgService;
import net.ibizsys.pscore.srv.config.service.PSSFStylePkgServiceBase;
import net.ibizsys.pscore.srv.config.service.PSSFStylePrjService;
import net.ibizsys.pscore.srv.config.service.PSSFStylePrjServiceBase;
import net.ibizsys.pscore.srv.config.service.PSSFStyleRefService;
import net.ibizsys.pscore.srv.config.service.PSSFStyleRefServiceBase;
import net.ibizsys.pscore.srv.config.service.PSSFStyleService;
import net.ibizsys.pscore.srv.config.service.PSSFStyleVerService;
import net.ibizsys.pscore.srv.config.service.PSSFStyleVerServiceBase;
import net.ibizsys.pscore.srv.config.service.PSSFViewTypeService;
import net.ibizsys.pscore.srv.config.service.PSSFViewTypeServiceBase;
import net.ibizsys.pscore.srv.config.service.PSSubSysSFService;
import net.ibizsys.pscore.srv.config.service.PSSubSysSFServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCAbilityService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCAbilityServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysSrvService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysSrvServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnTemplService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnTemplServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPubService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPubServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSFStyleServiceBase
extends PSCoreSysServiceBase<PSSFStyle> {
    private static final Log log = LogFactory.getLog(PSSFStyleServiceBase.class);
    public static final String DATASET_CURDC = "CurDC";
    public static final String DATASET_CURDC2 = "CurDC2";
    public static final String DATASET_CURDCALL = "CurDCAll";
    public static final String DATASET_CURDCDOC = "CurDCDoc";
    public static final String DATASET_CURDCDOC2 = "CurDCDoc2";
    public static final String DATASET_CURDCDOC3 = "CurDCDoc3";
    public static final String DATASET_CURDCDOCALL = "CurDCDocAll";
    public static final String DATASET_CURDCDOCALL2 = "CurDCDocAll2";
    public static final String DATASET_CURDCSF = "CurDCSF";
    public static final String DATASET_CURDCSF2 = "CurDCSF2";
    public static final String DATASET_CURDCSF3 = "CurDCSF3";
    public static final String DATASET_CURDCSFALL = "CurDCSFAll";
    public static final String DATASET_CURDCSFALL2 = "CurDCSFAll2";
    public static final String DATASET_CURSF = "CurSF";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_EXPSTYLE = "ExpStyle";
    private PSSFStyleDEModel pSSFStyleDEModel;
    private PSSFStyleDAO pSSFStyleDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSSFStyleService";
    }

    public PSSFStyleDEModel getPSSFStyleDEModel() {
        if (this.pSSFStyleDEModel == null) {
            try {
                this.pSSFStyleDEModel = (PSSFStyleDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSSFStyleDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSFStyleDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSFStyleDEModel();
    }

    public PSSFStyleDAO getPSSFStyleDAO() {
        if (this.pSSFStyleDAO == null) {
            try {
                this.pSSFStyleDAO = (PSSFStyleDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSSFStyleDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSFStyleDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSFStyleDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURDC, (boolean)true) == 0) {
            return this.fetchCurDC(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDC2, (boolean)true) == 0) {
            return this.fetchCurDC2(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDCALL, (boolean)true) == 0) {
            return this.fetchCurDCAll(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDCDOC, (boolean)true) == 0) {
            return this.fetchCurDCDoc(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDCDOC2, (boolean)true) == 0) {
            return this.fetchCurDCDoc2(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDCDOC3, (boolean)true) == 0) {
            return this.fetchCurDCDoc3(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDCDOCALL, (boolean)true) == 0) {
            return this.fetchCurDCDocAll(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDCDOCALL2, (boolean)true) == 0) {
            return this.fetchCurDCDocAll2(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDCSF, (boolean)true) == 0) {
            return this.fetchCurDCSF(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDCSF2, (boolean)true) == 0) {
            return this.fetchCurDCSF2(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDCSF3, (boolean)true) == 0) {
            return this.fetchCurDCSF3(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDCSFALL, (boolean)true) == 0) {
            return this.fetchCurDCSFAll(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDCSFALL2, (boolean)true) == 0) {
            return this.fetchCurDCSFAll2(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSF, (boolean)true) == 0) {
            return this.fetchCurSF(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_EXPSTYLE, (boolean)true) == 0) {
            this.expStyle((PSSFStyle)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurDC(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDC, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDC2(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDC2, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDCAll(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDCALL, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDCDoc(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDCDOC, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDCDoc2(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDCDOC2, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDCDoc3(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDCDOC3, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDCDocAll(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDCDOCALL, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDCDocAll2(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDCDOCALL2, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDCSF(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDCSF, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDCSF2(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDCSF2, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDCSF3(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDCSF3, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDCSFAll(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDCSFALL, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDCSFAll2(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDCSFALL2, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSF(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSF, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public void expStyle(PSSFStyle pSSFStyle) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_EXPSTYLE, 0, (IEntity)pSSFStyle, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSSFStyle, ACTION_EXPSTYLE);
        final PSSFStyle pSSFStyle2 = pSSFStyle;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSFStyleServiceBase.this.getService(), PSSFStyleServiceBase.ACTION_EXPSTYLE, 40, (IEntity)pSSFStyle2, null).getResult() != 1) {
                    PSSFStyleServiceBase.this.onExpStyle(pSSFStyle2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_EXPSTYLE, 99, (IEntity)pSSFStyle, null);
        }
    }

    protected void onExpStyle(PSSFStyle pSSFStyle) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[ExpStyle]");
    }

    protected void onFillParentInfo(PSSFStyle pSSFStyle, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSFSTYLE_PSDEVCENTER_PSDEVCENTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService", (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = (PSDevCenter)iService.getDEModel().createEntity();
            pSDevCenter.set("PSDEVCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevCenter);
            } else {
                iService.get((IEntity)pSDevCenter);
            }
            this.onFillParentInfo_PSDevCenter(pSSFStyle, pSDevCenter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSFSTYLE_PSSFSTYLE_MAINPSSFSTYLEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFStyleService", (SessionFactory)this.getSessionFactory());
            PSSFStyle pSSFStyle2 = (PSSFStyle)iService.getDEModel().createEntity();
            pSSFStyle2.set("PSSFSTYLEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSFStyle2);
            } else {
                iService.get((IEntity)pSSFStyle2);
            }
            this.onFillParentInfo_MainPSSFStyle(pSSFStyle, pSSFStyle2);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSFSTYLE_PSSFSTYLE_PPSSFSTYLEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFStyleService", (SessionFactory)this.getSessionFactory());
            PSSFStyle pSSFStyle3 = (PSSFStyle)iService.getDEModel().createEntity();
            pSSFStyle3.set("PSSFSTYLEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSFStyle3);
            } else {
                iService.get((IEntity)pSSFStyle3);
            }
            this.onFillParentInfo_PPSSFStyle(pSSFStyle, pSSFStyle3);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSFSTYLE_PSSF_PSSFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFService", (SessionFactory)this.getSessionFactory());
            PSSF pSSF = (PSSF)iService.getDEModel().createEntity();
            pSSF.set("PSSFID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSF);
            } else {
                iService.get((IEntity)pSSF);
            }
            this.onFillParentInfo_PSSF(pSSFStyle, pSSF);
            return;
        }
        super.onFillParentInfo((IEntity)pSSFStyle, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDevCenter(PSSFStyle pSSFStyle, PSDevCenter pSDevCenter) throws Exception {
        pSSFStyle.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
        pSSFStyle.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
    }

    protected void onFillParentInfo_MainPSSFStyle(PSSFStyle pSSFStyle, PSSFStyle pSSFStyle2) throws Exception {
        pSSFStyle.setMainPSSFStyleId(pSSFStyle2.getPSSFStyleId());
        pSSFStyle.setMainPSSFStyleName(pSSFStyle2.getPSSFStyleName());
    }

    protected void onFillParentInfo_PPSSFStyle(PSSFStyle pSSFStyle, PSSFStyle pSSFStyle2) throws Exception {
        pSSFStyle.setPPSSFStyleId(pSSFStyle2.getPSSFStyleId());
        pSSFStyle.setPPSSFStyleName(pSSFStyle2.getPSSFStyleName());
    }

    protected void onFillParentInfo_PSSF(PSSFStyle pSSFStyle, PSSF pSSF) throws Exception {
        pSSFStyle.setPSSFId(pSSF.getPSSFId());
        pSSFStyle.setPSSFName(pSSF.getPSSFName());
    }

    protected void onFillEntityFullInfo(PSSFStyle pSSFStyle, boolean bl) throws Exception {
        if (bl && pSSFStyle.getPkgInheritMode() == null) {
            pSSFStyle.setPkgInheritMode((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo((IEntity)pSSFStyle, bl);
        this.onFillEntityFullInfo_PSDevCenter(pSSFStyle, bl);
        this.onFillEntityFullInfo_MainPSSFStyle(pSSFStyle, bl);
        this.onFillEntityFullInfo_PPSSFStyle(pSSFStyle, bl);
        this.onFillEntityFullInfo_PSSF(pSSFStyle, bl);
    }

    protected void onFillEntityFullInfo_PSDevCenter(PSSFStyle pSSFStyle, boolean bl) throws Exception {
        if (pSSFStyle.isPSDevCenterIdDirty()) {
            if (pSSFStyle.getPSDevCenterId() != null) {
                if (pSSFStyle.getPSDevCenterId() == null || pSSFStyle.getPSDevCenterName() == null) {
                    PSDevCenter pSDevCenter = pSSFStyle.getPSDevCenter();
                    pSSFStyle.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
                }
            } else {
                pSSFStyle.setPSDevCenterName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_MainPSSFStyle(PSSFStyle pSSFStyle, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PPSSFStyle(PSSFStyle pSSFStyle, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSF(PSSFStyle pSSFStyle, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSFStyle pSSFStyle, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSFStyle, bl);
    }

    public ArrayList<PSSFStyle> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, "", -1);
    }

    public ArrayList<PSSFStyle> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, string, -1);
    }

    public ArrayList<PSSFStyle> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string, int n) throws Exception {
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

    public ArrayList<PSSFStyle> selectByMainPSSFStyle(PSSFStyleBase pSSFStyleBase) throws Exception {
        return this.selectByMainPSSFStyle(pSSFStyleBase, "", -1);
    }

    public ArrayList<PSSFStyle> selectByMainPSSFStyle(PSSFStyleBase pSSFStyleBase, String string) throws Exception {
        return this.selectByMainPSSFStyle(pSSFStyleBase, string, -1);
    }

    public ArrayList<PSSFStyle> selectByMainPSSFStyle(PSSFStyleBase pSSFStyleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MAINPSSFSTYLEID", (Object)pSSFStyleBase.getPSSFStyleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMainPSSFStyleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMainPSSFStyleCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSFStyle> selectByPPSSFStyle(PSSFStyleBase pSSFStyleBase) throws Exception {
        return this.selectByPPSSFStyle(pSSFStyleBase, "", -1);
    }

    public ArrayList<PSSFStyle> selectByPPSSFStyle(PSSFStyleBase pSSFStyleBase, String string) throws Exception {
        return this.selectByPPSSFStyle(pSSFStyleBase, string, -1);
    }

    public ArrayList<PSSFStyle> selectByPPSSFStyle(PSSFStyleBase pSSFStyleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSSFSTYLEID", (Object)pSSFStyleBase.getPSSFStyleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPPSSFStyleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPPSSFStyleCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSFStyle> selectByPSSF(PSSFBase pSSFBase) throws Exception {
        return this.selectByPSSF(pSSFBase, "", -1);
    }

    public ArrayList<PSSFStyle> selectByPSSF(PSSFBase pSSFBase, String string) throws Exception {
        return this.selectByPSSF(pSSFBase, string, -1);
    }

    public ArrayList<PSSFStyle> selectByPSSF(PSSFBase pSSFBase, String string, int n) throws Exception {
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

    public void testRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSSFStyle> arrayList = this.selectByPSDevCenter(pSDevCenter, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevCenter);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSFSTYLE_PSDEVCENTER_PSDEVCENTERID", "", iDataEntityModel.getName(), "PSSFSTYLE", iDataEntityModel.getDataInfo((IEntity)pSDevCenter), arrayList.get(0)));
        }
    }

    public void resetPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSSFStyle> arrayList = this.selectByPSDevCenter(pSDevCenter);
        for (PSSFStyle pSSFStyle : arrayList) {
            PSSFStyle pSSFStyle2 = (PSSFStyle)this.getDEModel().createEntity();
            pSSFStyle2.setPSSFStyleId(pSSFStyle.getPSSFStyleId());
            pSSFStyle2.setPSDevCenterId(null);
            this.update(pSSFStyle2);
        }
    }

    public void removeByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSFStyleServiceBase.this.onBeforeRemoveByPSDevCenter(pSDevCenter2);
                PSSFStyleServiceBase.this.internalRemoveByPSDevCenter(pSDevCenter2);
                PSSFStyleServiceBase.this.onAfterRemoveByPSDevCenter(pSDevCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void internalRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSSFStyle> arrayList = this.selectByPSDevCenter(pSDevCenter);
        this.onBeforeRemoveByPSDevCenter(pSDevCenter, arrayList);
        for (PSSFStyle pSSFStyle : arrayList) {
            this.remove((IEntity)pSSFStyle);
        }
        this.onAfterRemoveByPSDevCenter(pSDevCenter, arrayList);
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSSFStyle> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSSFStyle> arrayList) throws Exception {
    }

    public void testRemoveByMainPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
        ArrayList<PSSFStyle> arrayList = this.selectByMainPSSFStyle(pSSFStyle, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSFSTYLE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSFStyle);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSFSTYLE_PSSFSTYLE_MAINPSSFSTYLEID", "", iDataEntityModel.getName(), "PSSFSTYLE", iDataEntityModel.getDataInfo((IEntity)pSSFStyle), arrayList.get(0)));
        }
    }

    public void resetMainPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
        ArrayList<PSSFStyle> arrayList = this.selectByMainPSSFStyle(pSSFStyle);
        for (PSSFStyle pSSFStyle2 : arrayList) {
            PSSFStyle pSSFStyle3 = (PSSFStyle)this.getDEModel().createEntity();
            pSSFStyle3.setPSSFStyleId(pSSFStyle2.getPSSFStyleId());
            pSSFStyle3.setMainPSSFStyleId(null);
            this.update(pSSFStyle3);
        }
    }

    public void removeByMainPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
        final PSSFStyle pSSFStyle2 = pSSFStyle;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSFStyleServiceBase.this.onBeforeRemoveByMainPSSFStyle(pSSFStyle2);
                PSSFStyleServiceBase.this.internalRemoveByMainPSSFStyle(pSSFStyle2);
                PSSFStyleServiceBase.this.onAfterRemoveByMainPSSFStyle(pSSFStyle2);
            }
        });
    }

    protected void onBeforeRemoveByMainPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
    }

    protected void internalRemoveByMainPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
        ArrayList<PSSFStyle> arrayList = this.selectByMainPSSFStyle(pSSFStyle);
        this.onBeforeRemoveByMainPSSFStyle(pSSFStyle, arrayList);
        for (PSSFStyle pSSFStyle2 : arrayList) {
            this.remove((IEntity)pSSFStyle2);
        }
        this.onAfterRemoveByMainPSSFStyle(pSSFStyle, arrayList);
    }

    protected void onAfterRemoveByMainPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
    }

    protected void onBeforeRemoveByMainPSSFStyle(PSSFStyle pSSFStyle, ArrayList<PSSFStyle> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMainPSSFStyle(PSSFStyle pSSFStyle, ArrayList<PSSFStyle> arrayList) throws Exception {
    }

    public void testRemoveByPPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
    }

    public void resetPPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
        ArrayList<PSSFStyle> arrayList = this.selectByPPSSFStyle(pSSFStyle);
        for (PSSFStyle pSSFStyle2 : arrayList) {
            PSSFStyle pSSFStyle3 = (PSSFStyle)this.getDEModel().createEntity();
            pSSFStyle3.setPSSFStyleId(pSSFStyle2.getPSSFStyleId());
            pSSFStyle3.setPPSSFStyleId(null);
            this.update(pSSFStyle3);
        }
    }

    public void removeByPPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
        final PSSFStyle pSSFStyle2 = pSSFStyle;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSFStyleServiceBase.this.onBeforeRemoveByPPSSFStyle(pSSFStyle2);
                PSSFStyleServiceBase.this.internalRemoveByPPSSFStyle(pSSFStyle2);
                PSSFStyleServiceBase.this.onAfterRemoveByPPSSFStyle(pSSFStyle2);
            }
        });
    }

    protected void onBeforeRemoveByPPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
    }

    protected void internalRemoveByPPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
        ArrayList<PSSFStyle> arrayList = this.selectByPPSSFStyle(pSSFStyle);
        this.onBeforeRemoveByPPSSFStyle(pSSFStyle, arrayList);
        for (PSSFStyle pSSFStyle2 : arrayList) {
            this.remove((IEntity)pSSFStyle2);
        }
        this.onAfterRemoveByPPSSFStyle(pSSFStyle, arrayList);
    }

    protected void onAfterRemoveByPPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
    }

    protected void onBeforeRemoveByPPSSFStyle(PSSFStyle pSSFStyle, ArrayList<PSSFStyle> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPPSSFStyle(PSSFStyle pSSFStyle, ArrayList<PSSFStyle> arrayList) throws Exception {
    }

    public void testRemoveByPSSF(PSSF pSSF) throws Exception {
        ArrayList<PSSFStyle> arrayList = this.selectByPSSF(pSSF, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSF");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSF);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSFSTYLE_PSSF_PSSFID", "", iDataEntityModel.getName(), "PSSFSTYLE", iDataEntityModel.getDataInfo((IEntity)pSSF), arrayList.get(0)));
        }
    }

    public void resetPSSF(PSSF pSSF) throws Exception {
        ArrayList<PSSFStyle> arrayList = this.selectByPSSF(pSSF);
        for (PSSFStyle pSSFStyle : arrayList) {
            PSSFStyle pSSFStyle2 = (PSSFStyle)this.getDEModel().createEntity();
            pSSFStyle2.setPSSFStyleId(pSSFStyle.getPSSFStyleId());
            pSSFStyle2.setPSSFId(null);
            this.update(pSSFStyle2);
        }
    }

    public void removeByPSSF(PSSF pSSF) throws Exception {
        final PSSF pSSF2 = pSSF;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSFStyleServiceBase.this.onBeforeRemoveByPSSF(pSSF2);
                PSSFStyleServiceBase.this.internalRemoveByPSSF(pSSF2);
                PSSFStyleServiceBase.this.onAfterRemoveByPSSF(pSSF2);
            }
        });
    }

    protected void onBeforeRemoveByPSSF(PSSF pSSF) throws Exception {
    }

    protected void internalRemoveByPSSF(PSSF pSSF) throws Exception {
        ArrayList<PSSFStyle> arrayList = this.selectByPSSF(pSSF);
        this.onBeforeRemoveByPSSF(pSSF, arrayList);
        for (PSSFStyle pSSFStyle : arrayList) {
            this.remove((IEntity)pSSFStyle);
        }
        this.onAfterRemoveByPSSF(pSSF, arrayList);
    }

    protected void onAfterRemoveByPSSF(PSSF pSSF) throws Exception {
    }

    protected void onBeforeRemoveByPSSF(PSSF pSSF, ArrayList<PSSFStyle> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSF(PSSF pSSF, ArrayList<PSSFStyle> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSFStyle pSSFStyle) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDCAbilityService)ServiceGlobal.getService(PSDCAbilityService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCAbilityServiceBase)pSCoreSysServiceBase).testRemoveByPSSFStyle(pSSFStyle);
        pSCoreSysServiceBase = (PSDevSlnSysSrvService)ServiceGlobal.getService(PSDevSlnSysSrvService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnSysSrvServiceBase)pSCoreSysServiceBase).testRemoveByPSSFStyle(pSSFStyle);
        pSCoreSysServiceBase = (PSDevSlnTemplService)ServiceGlobal.getService(PSDevSlnTemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnTemplServiceBase)pSCoreSysServiceBase).testRemoveByPSSFStyle(pSSFStyle);
        pSCoreSysServiceBase = (PSDevSlnTemplService)ServiceGlobal.getService(PSDevSlnTemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnTemplServiceBase)pSCoreSysServiceBase).testRemoveByTemplPSSFStyle(pSSFStyle);
        ((PSDevSlnTemplServiceBase)pSCoreSysServiceBase).resetTemplPSSFStyle(pSSFStyle);
        pSCoreSysServiceBase = (PSSFCodeFolderService)ServiceGlobal.getService(PSSFCodeFolderService.class, (SessionFactory)this.getSessionFactory());
        ((PSSFCodeFolderServiceBase)pSCoreSysServiceBase).testRemoveByPSSFStyle(pSSFStyle);
        ((PSSFCodeFolderServiceBase)pSCoreSysServiceBase).removeByPSSFStyle(pSSFStyle);
        pSCoreSysServiceBase = (PSSFCtrlTypeService)ServiceGlobal.getService(PSSFCtrlTypeService.class, (SessionFactory)this.getSessionFactory());
        ((PSSFCtrlTypeServiceBase)pSCoreSysServiceBase).testRemoveByPSSFStyle(pSSFStyle);
        pSCoreSysServiceBase = (PSSFPubOjbService)ServiceGlobal.getService(PSSFPubOjbService.class, (SessionFactory)this.getSessionFactory());
        ((PSSFPubOjbServiceBase)pSCoreSysServiceBase).testRemoveByPSSFStyle(pSSFStyle);
        pSCoreSysServiceBase = (PSSFStyleCodeService)ServiceGlobal.getService(PSSFStyleCodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSSFStyleCodeServiceBase)pSCoreSysServiceBase).testRemoveByPSSFStyle(pSSFStyle);
        ((PSSFStyleCodeServiceBase)pSCoreSysServiceBase).removeByPSSFStyle(pSSFStyle);
        pSCoreSysServiceBase = (PSSFStyleLogService)ServiceGlobal.getService(PSSFStyleLogService.class, (SessionFactory)this.getSessionFactory());
        ((PSSFStyleLogServiceBase)pSCoreSysServiceBase).testRemoveByPSSFStyle(pSSFStyle);
        ((PSSFStyleLogServiceBase)pSCoreSysServiceBase).removeByPSSFStyle(pSSFStyle);
        pSCoreSysServiceBase = (PSSFStyleParamService)ServiceGlobal.getService(PSSFStyleParamService.class, (SessionFactory)this.getSessionFactory());
        ((PSSFStyleParamServiceBase)pSCoreSysServiceBase).testRemoveByPSSFStyle(pSSFStyle);
        pSCoreSysServiceBase = (PSSFStylePkgService)ServiceGlobal.getService(PSSFStylePkgService.class, (SessionFactory)this.getSessionFactory());
        ((PSSFStylePkgServiceBase)pSCoreSysServiceBase).testRemoveByPSSFStyle(pSSFStyle);
        ((PSSFStylePkgServiceBase)pSCoreSysServiceBase).removeByPSSFStyle(pSSFStyle);
        pSCoreSysServiceBase = (PSSFStylePrjService)ServiceGlobal.getService(PSSFStylePrjService.class, (SessionFactory)this.getSessionFactory());
        ((PSSFStylePrjServiceBase)pSCoreSysServiceBase).testRemoveByPSSFStyle(pSSFStyle);
        ((PSSFStylePrjServiceBase)pSCoreSysServiceBase).removeByPSSFStyle(pSSFStyle);
        pSCoreSysServiceBase = (PSSFStyleRefService)ServiceGlobal.getService(PSSFStyleRefService.class, (SessionFactory)this.getSessionFactory());
        ((PSSFStyleRefServiceBase)pSCoreSysServiceBase).testRemoveByPSSFStyle(pSSFStyle);
        ((PSSFStyleRefServiceBase)pSCoreSysServiceBase).removeByPSSFStyle(pSSFStyle);
        pSCoreSysServiceBase = (PSSFStyleRefService)ServiceGlobal.getService(PSSFStyleRefService.class, (SessionFactory)this.getSessionFactory());
        ((PSSFStyleRefServiceBase)pSCoreSysServiceBase).testRemoveByRefPSSFStyle(pSSFStyle);
        pSCoreSysServiceBase = (PSSFStyleVerService)ServiceGlobal.getService(PSSFStyleVerService.class, (SessionFactory)this.getSessionFactory());
        ((PSSFStyleVerServiceBase)pSCoreSysServiceBase).testRemoveByPSSFStyle(pSSFStyle);
        pSCoreSysServiceBase = (PSSFStyleService)ServiceGlobal.getService(PSSFStyleService.class, (SessionFactory)this.getSessionFactory());
        ((PSSFStyleServiceBase)pSCoreSysServiceBase).testRemoveByMainPSSFStyle(pSSFStyle);
        pSCoreSysServiceBase = (PSSFViewTypeService)ServiceGlobal.getService(PSSFViewTypeService.class, (SessionFactory)this.getSessionFactory());
        ((PSSFViewTypeServiceBase)pSCoreSysServiceBase).testRemoveByPSSFStyle(pSSFStyle);
        pSCoreSysServiceBase = (PSSubSysSFService)ServiceGlobal.getService(PSSubSysSFService.class, (SessionFactory)this.getSessionFactory());
        ((PSSubSysSFServiceBase)pSCoreSysServiceBase).testRemoveByPSSFStyle(pSSFStyle);
        pSCoreSysServiceBase = (PSSysSFPubService)ServiceGlobal.getService(PSSysSFPubService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysSFPubServiceBase)pSCoreSysServiceBase).testRemoveByPSSFStyle(pSSFStyle);
        super.onBeforeRemove(pSSFStyle);
    }

    protected void replaceParentInfo(PSSFStyle pSSFStyle, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSFStyle, cloneSession);
        if (pSSFStyle.getPSDevCenterId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTER", (Object)pSSFStyle.getPSDevCenterId())) != null) {
            this.onFillParentInfo_PSDevCenter(pSSFStyle, (PSDevCenter)iEntity);
        }
        if (pSSFStyle.getMainPSSFStyleId() != null && (iEntity = cloneSession.getEntity("PSSFSTYLE", (Object)pSSFStyle.getMainPSSFStyleId())) != null) {
            this.onFillParentInfo_MainPSSFStyle(pSSFStyle, (PSSFStyle)iEntity);
        }
        if (pSSFStyle.getPPSSFStyleId() != null && (iEntity = cloneSession.getEntity("PSSFSTYLE", (Object)pSSFStyle.getPPSSFStyleId())) != null) {
            this.onFillParentInfo_PPSSFStyle(pSSFStyle, (PSSFStyle)iEntity);
        }
        if (pSSFStyle.getPSSFId() != null && (iEntity = cloneSession.getEntity("PSSF", (Object)pSSFStyle.getPSSFId())) != null) {
            this.onFillParentInfo_PSSF(pSSFStyle, (PSSF)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSFStyle pSSFStyle, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSFStyle, bl);
    }

    protected void onCheckEntity(boolean bl, PSSFStyle pSSFStyle, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ClsPkgParams(bl, pSSFStyle, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefaultFlag(bl, pSSFStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableDeployCenter(bl, pSSFStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableWSServer(bl, pSSFStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LastestFlag(bl, pSSFStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MainPSSFStyleId(bl, pSSFStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MainStyleFlag(bl, pSSFStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSFStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PkgInheritMode(bl, pSSFStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSSFStyleId(bl, pSSFStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PrjList(bl, pSSFStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PrjType(bl, pSSFStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterId(bl, pSSFStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterName(bl, pSSFStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnId(bl, pSSFStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFId(bl, pSSFStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFStyleId(bl, pSSFStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFStyleName(bl, pSSFStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PubMode(bl, pSSFStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefreshVer(bl, pSSFStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StyleEngine(bl, pSSFStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StyleResUrl(bl, pSSFStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplInfo(bl, pSSFStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplRootUrl(bl, pSSFStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplState(bl, pSSFStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSFStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSFStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_V2Folder(bl, pSSFStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_V2Folder2(bl, pSSFStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_V2GitPath(bl, pSSFStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Version(bl, pSSFStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_VerStr(bl, pSSFStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WorkshopName(bl, pSSFStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSFStyle, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ClsPkgParams(boolean bl, PSSFStyle pSSFStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFStyle.isClsPkgParamsDirty() : !pSSFStyle.isClsPkgParamsDirty()) {
            return null;
        }
        String string = pSSFStyle.getClsPkgParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ClsPkgParams_Default((IEntity)pSSFStyle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CLSPKGPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DefaultFlag(boolean bl, PSSFStyle pSSFStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFStyle.isDefaultFlagDirty() : !pSSFStyle.isDefaultFlagDirty()) {
            return null;
        }
        Integer n = pSSFStyle.getDefaultFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DefaultFlag_Default((IEntity)pSSFStyle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableDeployCenter(boolean bl, PSSFStyle pSSFStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFStyle.isEnableDeployCenterDirty() : !pSSFStyle.isEnableDeployCenterDirty()) {
            return null;
        }
        Integer n = pSSFStyle.getEnableDeployCenter();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableDeployCenter_Default((IEntity)pSSFStyle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEDEPLOYCENTER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableWSServer(boolean bl, PSSFStyle pSSFStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFStyle.isEnableWSServerDirty() : !pSSFStyle.isEnableWSServerDirty()) {
            return null;
        }
        Integer n = pSSFStyle.getEnableWSServer();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableWSServer_Default((IEntity)pSSFStyle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEWSSERVER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LastestFlag(boolean bl, PSSFStyle pSSFStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFStyle.isLastestFlagDirty() : !pSSFStyle.isLastestFlagDirty()) {
            return null;
        }
        Integer n = pSSFStyle.getLastestFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LastestFlag_Default((IEntity)pSSFStyle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LASTESTFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MainPSSFStyleId(boolean bl, PSSFStyle pSSFStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFStyle.isMainPSSFStyleIdDirty() : !pSSFStyle.isMainPSSFStyleIdDirty()) {
            return null;
        }
        String string = pSSFStyle.getMainPSSFStyleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MainPSSFStyleId_Default((IEntity)pSSFStyle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAINPSSFSTYLEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MainStyleFlag(boolean bl, PSSFStyle pSSFStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFStyle.isMainStyleFlagDirty() : !pSSFStyle.isMainStyleFlagDirty()) {
            return null;
        }
        Integer n = pSSFStyle.getMainStyleFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MainStyleFlag_Default((IEntity)pSSFStyle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAINSTYLEFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSFStyle pSSFStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFStyle.isMemoDirty() : !pSSFStyle.isMemoDirty()) {
            return null;
        }
        String string = pSSFStyle.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSSFStyle, bl2, bl3);
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

    protected EntityFieldError onCheckField_PkgInheritMode(boolean bl, PSSFStyle pSSFStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFStyle.isPkgInheritModeDirty() : !pSSFStyle.isPkgInheritModeDirty()) {
            return null;
        }
        Integer n = pSSFStyle.getPkgInheritMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PkgInheritMode_Default((IEntity)pSSFStyle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PKGINHERITMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PPSSFStyleId(boolean bl, PSSFStyle pSSFStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFStyle.isPPSSFStyleIdDirty() : !pSSFStyle.isPPSSFStyleIdDirty()) {
            return null;
        }
        String string = pSSFStyle.getPPSSFStyleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSSFStyleId_Default((IEntity)pSSFStyle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSSFSTYLEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PrjList(boolean bl, PSSFStyle pSSFStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFStyle.isPrjListDirty() : !pSSFStyle.isPrjListDirty()) {
            return null;
        }
        String string = pSSFStyle.getPrjList();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PrjList_Default((IEntity)pSSFStyle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PRJLIST");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PrjType(boolean bl, PSSFStyle pSSFStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFStyle.isPrjTypeDirty() : !pSSFStyle.isPrjTypeDirty()) {
            return null;
        }
        Integer n = pSSFStyle.getPrjType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PrjType_Default((IEntity)pSSFStyle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PRJTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterId(boolean bl, PSSFStyle pSSFStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFStyle.isPSDevCenterIdDirty() : !pSSFStyle.isPSDevCenterIdDirty()) {
            return null;
        }
        String string = pSSFStyle.getPSDevCenterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterId_Default((IEntity)pSSFStyle, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevCenterName(boolean bl, PSSFStyle pSSFStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFStyle.isPSDevCenterNameDirty() : !pSSFStyle.isPSDevCenterNameDirty()) {
            return null;
        }
        String string = pSSFStyle.getPSDevCenterName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterName_Default((IEntity)pSSFStyle, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnId(boolean bl, PSSFStyle pSSFStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFStyle.isPSDevSlnIdDirty() : !pSSFStyle.isPSDevSlnIdDirty()) {
            return null;
        }
        String string = pSSFStyle.getPSDevSlnId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnId_Default((IEntity)pSSFStyle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFId(boolean bl, PSSFStyle pSSFStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFStyle.isPSSFIdDirty() && !bl2 : !pSSFStyle.isPSSFIdDirty()) {
            return null;
        }
        String string = pSSFStyle.getPSSFId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFId_Default((IEntity)pSSFStyle, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSFStyleId(boolean bl, PSSFStyle pSSFStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFStyle.isPSSFStyleIdDirty() && !bl2 : !pSSFStyle.isPSSFStyleIdDirty()) {
            return null;
        }
        String string = pSSFStyle.getPSSFStyleId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFSTYLEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFStyleId_Default((IEntity)pSSFStyle, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSFStyleName(boolean bl, PSSFStyle pSSFStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFStyle.isPSSFStyleNameDirty() && !bl2 : !pSSFStyle.isPSSFStyleNameDirty()) {
            return null;
        }
        String string = pSSFStyle.getPSSFStyleName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFSTYLENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFStyleName_Default((IEntity)pSSFStyle, bl2, bl3);
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

    protected EntityFieldError onCheckField_PubMode(boolean bl, PSSFStyle pSSFStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFStyle.isPubModeDirty() : !pSSFStyle.isPubModeDirty()) {
            return null;
        }
        Integer n = pSSFStyle.getPubMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PubMode_Default((IEntity)pSSFStyle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PUBMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefreshVer(boolean bl, PSSFStyle pSSFStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFStyle.isRefreshVerDirty() : !pSSFStyle.isRefreshVerDirty()) {
            return null;
        }
        Integer n = pSSFStyle.getRefreshVer();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_RefreshVer_Default((IEntity)pSSFStyle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFRESHVER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StyleEngine(boolean bl, PSSFStyle pSSFStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFStyle.isStyleEngineDirty() : !pSSFStyle.isStyleEngineDirty()) {
            return null;
        }
        String string = pSSFStyle.getStyleEngine();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_StyleEngine_Default((IEntity)pSSFStyle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STYLEENGINE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StyleResUrl(boolean bl, PSSFStyle pSSFStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFStyle.isStyleResUrlDirty() : !pSSFStyle.isStyleResUrlDirty()) {
            return null;
        }
        String string = pSSFStyle.getStyleResUrl();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_StyleResUrl_Default((IEntity)pSSFStyle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STYLERESURL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TemplInfo(boolean bl, PSSFStyle pSSFStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFStyle.isTemplInfoDirty() : !pSSFStyle.isTemplInfoDirty()) {
            return null;
        }
        String string = pSSFStyle.getTemplInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TemplInfo_Default((IEntity)pSSFStyle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPLINFO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TemplRootUrl(boolean bl, PSSFStyle pSSFStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFStyle.isTemplRootUrlDirty() : !pSSFStyle.isTemplRootUrlDirty()) {
            return null;
        }
        String string = pSSFStyle.getTemplRootUrl();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TemplRootUrl_Default((IEntity)pSSFStyle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPLROOTURL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TemplState(boolean bl, PSSFStyle pSSFStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFStyle.isTemplStateDirty() : !pSSFStyle.isTemplStateDirty()) {
            return null;
        }
        Integer n = pSSFStyle.getTemplState();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_TemplState_Default((IEntity)pSSFStyle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPLSTATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSFStyle pSSFStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFStyle.isUserTagDirty() : !pSSFStyle.isUserTagDirty()) {
            return null;
        }
        String string = pSSFStyle.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSSFStyle, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSFStyle pSSFStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFStyle.isUserTag2Dirty() : !pSSFStyle.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSFStyle.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSSFStyle, bl2, bl3);
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

    protected EntityFieldError onCheckField_V2Folder(boolean bl, PSSFStyle pSSFStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFStyle.isV2FolderDirty() : !pSSFStyle.isV2FolderDirty()) {
            return null;
        }
        String string = pSSFStyle.getV2Folder();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_V2Folder_Default((IEntity)pSSFStyle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("V2FOLDER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_V2Folder2(boolean bl, PSSFStyle pSSFStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFStyle.isV2Folder2Dirty() : !pSSFStyle.isV2Folder2Dirty()) {
            return null;
        }
        String string = pSSFStyle.getV2Folder2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_V2Folder2_Default((IEntity)pSSFStyle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("V2FOLDER2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_V2GitPath(boolean bl, PSSFStyle pSSFStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFStyle.isV2GitPathDirty() : !pSSFStyle.isV2GitPathDirty()) {
            return null;
        }
        String string = pSSFStyle.getV2GitPath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_V2GitPath_Default((IEntity)pSSFStyle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("V2GITPATH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Version(boolean bl, PSSFStyle pSSFStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFStyle.isVersionDirty() : !pSSFStyle.isVersionDirty()) {
            return null;
        }
        Integer n = pSSFStyle.getVersion();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Version_Default((IEntity)pSSFStyle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VERSION");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_VerStr(boolean bl, PSSFStyle pSSFStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFStyle.isVerStrDirty() : !pSSFStyle.isVerStrDirty()) {
            return null;
        }
        String string = pSSFStyle.getVerStr();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_VerStr_Default((IEntity)pSSFStyle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VERSTR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WorkshopName(boolean bl, PSSFStyle pSSFStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFStyle.isWorkshopNameDirty() : !pSSFStyle.isWorkshopNameDirty()) {
            return null;
        }
        String string = pSSFStyle.getWorkshopName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WorkshopName_Default((IEntity)pSSFStyle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WORKSHOPNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSSFStyle pSSFStyle, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSFStyle, bl);
    }

    protected void onSyncIndexEntities(PSSFStyle pSSFStyle, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSFStyle, bl);
    }

    public Object getDataContextValue(PSSFStyle pSSFStyle, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSFStyle, string, iDataContextParam)) != null) {
            return object;
        }
        PSSF pSSF = pSSFStyle.getPSSF();
        if (pSSF != null && pSSF.contains(string)) {
            return pSSF.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSFStyle pSSFStyle, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSFStyle, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CLSPKGPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ClsPkgParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFAULTFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefaultFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEDEPLOYCENTER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableDeployCenter_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEWSSERVER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableWSServer_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LASTESTFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LastestFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAINPSSFSTYLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MainPSSFStyleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAINPSSFSTYLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MainPSSFStyleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAINSTYLEFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MainStyleFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PKGINHERITMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PkgInheritMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSSFSTYLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSSFStyleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSSFSTYLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSSFStyleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PRJLIST", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PrjList_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PRJTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PrjType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnId_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PUBMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PubMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFRESHVER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefreshVer_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STYLEENGINE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StyleEngine_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STYLERESURL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StyleResUrl_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplInfo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLROOTURL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplRootUrl_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"V2FOLDER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_V2Folder_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"V2FOLDER2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_V2Folder2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"V2GITPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_V2GitPath_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VERSION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Version_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VERSTR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_VerStr_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WORKSHOPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WorkshopName_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_ClsPkgParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CLSPKGPARAMS", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
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

    protected String onTestValueRule_DefaultFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableDeployCenter_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableWSServer_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LastestFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_MainPSSFStyleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MAINPSSFSTYLEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MainPSSFStyleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MAINPSSFSTYLENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MainStyleFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_PkgInheritMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PPSSFStyleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSSFSTYLEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSSFStyleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSSFSTYLENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PrjList_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PRJLIST", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PrjType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_PSDevSlnId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNID", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
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

    protected String onTestValueRule_PubMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_RefreshVer_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_StyleEngine_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STYLEENGINE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_StyleResUrl_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STYLERESURL", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TemplInfo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TEMPLINFO", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TemplRootUrl_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TEMPLROOTURL", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TemplState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_UserTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_V2Folder_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("V2FOLDER", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_V2Folder2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("V2FOLDER2", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_V2GitPath_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("V2GITPATH", iEntity, bl2, null, false, 400, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[400]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[400]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Version_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_VerStr_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VERSTR", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WorkshopName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WORKSHOPNAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected boolean onMergeChild(String string, String string2, PSSFStyle pSSFStyle) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSSFStyle)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSFStyle pSSFStyle) throws Exception {
        super.onUpdateParent((IEntity)pSSFStyle);
    }

    @Override
    protected void exportCurXmlModel(PSSFStyle pSSFStyle, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSFSTYLE");
        if (!bl) {
            pSSFStyle.setCreateDate(null);
            pSSFStyle.setCreateMan(null);
            pSSFStyle.setUpdateDate(null);
            pSSFStyle.setUpdateMan(null);
            super.exportCurXmlModel(pSSFStyle, xmlNode, bl);
        }
    }
}

