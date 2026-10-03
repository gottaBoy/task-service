/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.data.DataObject
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

import java.sql.Timestamp;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.data.DataObject;
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
import net.ibizsys.pscore.srv.config.dao.PSSFStyleVerDAO;
import net.ibizsys.pscore.srv.config.demodel.PSSFStyleVerDEModel;
import net.ibizsys.pscore.srv.config.entity.PSSFStyle;
import net.ibizsys.pscore.srv.config.entity.PSSFStyleBase;
import net.ibizsys.pscore.srv.config.entity.PSSFStyleVer;
import net.ibizsys.pscore.srv.config.entity.PSSFVerCode;
import net.ibizsys.pscore.srv.config.service.PSSFVerCodeService;
import net.ibizsys.pscore.srv.config.service.PSSFVerCodeServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterSVN;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterSVNBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysSrvService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysSrvServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPubService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPubServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSFStyleVerServiceBase
extends PSCoreSysServiceBase<PSSFStyleVer> {
    private static final Log log = LogFactory.getLog(PSSFStyleVerServiceBase.class);
    public static final String DATASET_CURDC = "CurDC";
    public static final String DATASET_CURDCANDSTYLE = "CurDCAndStyle";
    public static final String DATASET_CURSTYLE = "CURSTYLE";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_EXPSTYLEVER = "ExpStyleVer";
    public static final String ACTION_FIXSTYLEVER = "FixStyleVer";
    public static final String ACTION_IMPSTYLEVER = "ImpStyleVer";
    public static final String ACTION_PUBLISH = "PUBLISH";
    private PSSFStyleVerDEModel pSSFStyleVerDEModel;
    private PSSFStyleVerDAO pSSFStyleVerDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSSFStyleVerService";
    }

    public PSSFStyleVerDEModel getPSSFStyleVerDEModel() {
        if (this.pSSFStyleVerDEModel == null) {
            try {
                this.pSSFStyleVerDEModel = (PSSFStyleVerDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSSFStyleVerDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSFStyleVerDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSFStyleVerDEModel();
    }

    public PSSFStyleVerDAO getPSSFStyleVerDAO() {
        if (this.pSSFStyleVerDAO == null) {
            try {
                this.pSSFStyleVerDAO = (PSSFStyleVerDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSSFStyleVerDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSFStyleVerDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSFStyleVerDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURDC, (boolean)true) == 0) {
            return this.fetchCurDC(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDCANDSTYLE, (boolean)true) == 0) {
            return this.fetchCurDCAndStyle(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSTYLE, (boolean)true) == 0) {
            return this.fetchCurStyle(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_EXPSTYLEVER, (boolean)true) == 0) {
            this.expStyleVer((PSSFStyleVer)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_FIXSTYLEVER, (boolean)true) == 0) {
            this.fixStyleVer((PSSFStyleVer)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_IMPSTYLEVER, (boolean)true) == 0) {
            this.impStyleVer((PSSFStyleVer)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_PUBLISH, (boolean)true) == 0) {
            this.publish((PSSFStyleVer)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurDC(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDC, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDCAndStyle(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDCANDSTYLE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurStyle(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSTYLE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public void expStyleVer(PSSFStyleVer pSSFStyleVer) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_EXPSTYLEVER, 0, pSSFStyleVer, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSSFStyleVer, ACTION_EXPSTYLEVER);
        final PSSFStyleVer pSSFStyleVer2 = pSSFStyleVer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSFStyleVerServiceBase.this.getService(), PSSFStyleVerServiceBase.ACTION_EXPSTYLEVER, 40, pSSFStyleVer2, null).getResult() != 1) {
                    PSSFStyleVerServiceBase.this.onExpStyleVer(pSSFStyleVer2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_EXPSTYLEVER, 99, pSSFStyleVer, null);
        }
    }

    protected void onExpStyleVer(PSSFStyleVer pSSFStyleVer) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[ExpStyleVer]");
    }

    public void fixStyleVer(PSSFStyleVer pSSFStyleVer) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_FIXSTYLEVER, 0, pSSFStyleVer, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSSFStyleVer, ACTION_FIXSTYLEVER);
        final PSSFStyleVer pSSFStyleVer2 = pSSFStyleVer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSFStyleVerServiceBase.this.getService(), PSSFStyleVerServiceBase.ACTION_FIXSTYLEVER, 40, pSSFStyleVer2, null).getResult() != 1) {
                    PSSFStyleVerServiceBase.this.onFixStyleVer(pSSFStyleVer2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_FIXSTYLEVER, 99, pSSFStyleVer, null);
        }
    }

    protected void onFixStyleVer(PSSFStyleVer pSSFStyleVer) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[FixStyleVer]");
    }

    public void impStyleVer(PSSFStyleVer pSSFStyleVer) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_IMPSTYLEVER, 0, pSSFStyleVer, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSSFStyleVer, ACTION_IMPSTYLEVER);
        final PSSFStyleVer pSSFStyleVer2 = pSSFStyleVer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSFStyleVerServiceBase.this.getService(), PSSFStyleVerServiceBase.ACTION_IMPSTYLEVER, 40, pSSFStyleVer2, null).getResult() != 1) {
                    PSSFStyleVerServiceBase.this.onImpStyleVer(pSSFStyleVer2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_IMPSTYLEVER, 99, pSSFStyleVer, null);
        }
    }

    protected void onImpStyleVer(PSSFStyleVer pSSFStyleVer) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[ImpStyleVer]");
    }

    public void publish(PSSFStyleVer pSSFStyleVer) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_PUBLISH, 0, pSSFStyleVer, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSSFStyleVer, ACTION_PUBLISH);
        final PSSFStyleVer pSSFStyleVer2 = pSSFStyleVer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSFStyleVerServiceBase.this.getService(), PSSFStyleVerServiceBase.ACTION_PUBLISH, 40, pSSFStyleVer2, null).getResult() != 1) {
                    PSSFStyleVerServiceBase.this.onPublish(pSSFStyleVer2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_PUBLISH, 99, pSSFStyleVer, null);
        }
    }

    protected void onPublish(PSSFStyleVer pSSFStyleVer) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[PUBLISH]");
    }

    protected void onFillParentInfo(PSSFStyleVer pSSFStyleVer, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSFSTYLEVER_PSDEVCENTERSVN_PSDEVCENTERSVNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterSVNService", (SessionFactory)this.getSessionFactory());
            PSDevCenterSVN pSDevCenterSVN = (PSDevCenterSVN)iService.getDEModel().createEntity();
            pSDevCenterSVN.set("PSDEVCENTERSVNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenterSVN);
            } else {
                iService.get(pSDevCenterSVN);
            }
            this.onFillParentInfo_PSDevCenterSVN(pSSFStyleVer, pSDevCenterSVN);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSFSTYLEVER_PSDEVCENTER_PSDEVCENTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService", (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = (PSDevCenter)iService.getDEModel().createEntity();
            pSDevCenter.set("PSDEVCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenter);
            } else {
                iService.get(pSDevCenter);
            }
            this.onFillParentInfo_PSDevCenter(pSSFStyleVer, pSDevCenter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSFSTYLEVER_PSSFSTYLE_PSSFSTYLEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFStyleService", (SessionFactory)this.getSessionFactory());
            PSSFStyle pSSFStyle = (PSSFStyle)iService.getDEModel().createEntity();
            pSSFStyle.set("PSSFSTYLEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSFStyle);
            } else {
                iService.get(pSSFStyle);
            }
            this.onFillParentInfo_PSSFStyle(pSSFStyleVer, pSSFStyle);
            return;
        }
        super.onFillParentInfo(pSSFStyleVer, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDevCenterSVN(PSSFStyleVer pSSFStyleVer, PSDevCenterSVN pSDevCenterSVN) throws Exception {
        pSSFStyleVer.setPSDevCenterSVNId(pSDevCenterSVN.getPSDevCenterSVNId());
        pSSFStyleVer.setPSDevCenterSVNName(pSDevCenterSVN.getPSDevCenterSVNName());
    }

    protected void onFillParentInfo_PSDevCenter(PSSFStyleVer pSSFStyleVer, PSDevCenter pSDevCenter) throws Exception {
        pSSFStyleVer.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
        pSSFStyleVer.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
    }

    protected void onFillParentInfo_PSSFStyle(PSSFStyleVer pSSFStyleVer, PSSFStyle pSSFStyle) throws Exception {
        pSSFStyleVer.setPSSFId(pSSFStyle.getPSSFId());
        pSSFStyleVer.setPSSFStyleId(pSSFStyle.getPSSFStyleId());
        pSSFStyleVer.setPSSFStyleName(pSSFStyle.getPSSFStyleName());
    }

    protected void onFillEntityFullInfo(PSSFStyleVer pSSFStyleVer, boolean bl) throws Exception {
        if (bl) {
            if (pSSFStyleVer.getMajor() == null) {
                pSSFStyleVer.setMajor((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
            if (pSSFStyleVer.getPubMode() == null) {
                pSSFStyleVer.setPubMode((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
            if (pSSFStyleVer.getValidFlag() == null) {
                pSSFStyleVer.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo(pSSFStyleVer, bl);
        this.onFillEntityFullInfo_PSDevCenterSVN(pSSFStyleVer, bl);
        this.onFillEntityFullInfo_PSDevCenter(pSSFStyleVer, bl);
        this.onFillEntityFullInfo_PSSFStyle(pSSFStyleVer, bl);
    }

    protected void onFillEntityFullInfo_PSDevCenterSVN(PSSFStyleVer pSSFStyleVer, boolean bl) throws Exception {
        if (pSSFStyleVer.isPSDevCenterSVNIdDirty()) {
            if (pSSFStyleVer.getPSDevCenterSVNId() != null) {
                if (pSSFStyleVer.getPSDevCenterSVNId() == null || pSSFStyleVer.getPSDevCenterSVNName() == null) {
                    PSDevCenterSVN pSDevCenterSVN = pSSFStyleVer.getPSDevCenterSVN();
                    pSSFStyleVer.setPSDevCenterSVNName(pSDevCenterSVN.getPSDevCenterSVNName());
                }
            } else {
                pSSFStyleVer.setPSDevCenterSVNName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDevCenter(PSSFStyleVer pSSFStyleVer, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSFStyle(PSSFStyleVer pSSFStyleVer, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSFStyleVer pSSFStyleVer, boolean bl) throws Exception {
        super.onWriteBackParent(pSSFStyleVer, bl);
    }

    public ArrayList<PSSFStyleVer> selectByPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase) throws Exception {
        return this.selectByPSDevCenterSVN(pSDevCenterSVNBase, "", -1);
    }

    public ArrayList<PSSFStyleVer> selectByPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase, String string) throws Exception {
        return this.selectByPSDevCenterSVN(pSDevCenterSVNBase, string, -1);
    }

    public ArrayList<PSSFStyleVer> selectByPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVCENTERSVNID", (Object)pSDevCenterSVNBase.getPSDevCenterSVNId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevCenterSVNCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevCenterSVNCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSFStyleVer> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, "", -1);
    }

    public ArrayList<PSSFStyleVer> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, string, -1);
    }

    public ArrayList<PSSFStyleVer> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string, int n) throws Exception {
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

    public ArrayList<PSSFStyleVer> selectByPSSFStyle(PSSFStyleBase pSSFStyleBase) throws Exception {
        return this.selectByPSSFStyle(pSSFStyleBase, "", -1);
    }

    public ArrayList<PSSFStyleVer> selectByPSSFStyle(PSSFStyleBase pSSFStyleBase, String string) throws Exception {
        return this.selectByPSSFStyle(pSSFStyleBase, string, -1);
    }

    public ArrayList<PSSFStyleVer> selectByPSSFStyle(PSSFStyleBase pSSFStyleBase, String string, int n) throws Exception {
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

    public void testRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
    }

    public void resetPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSSFStyleVer> arrayList = this.selectByPSDevCenterSVN(pSDevCenterSVN);
        for (PSSFStyleVer pSSFStyleVer : arrayList) {
            PSSFStyleVer pSSFStyleVer2 = (PSSFStyleVer)this.getDEModel().createEntity();
            pSSFStyleVer2.setPSSFStyleVerId(pSSFStyleVer.getPSSFStyleVerId());
            pSSFStyleVer2.setPSDevCenterSVNId(null);
            this.update(pSSFStyleVer2);
        }
    }

    public void removeByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        final PSDevCenterSVN pSDevCenterSVN2 = pSDevCenterSVN;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSFStyleVerServiceBase.this.onBeforeRemoveByPSDevCenterSVN(pSDevCenterSVN2);
                PSSFStyleVerServiceBase.this.internalRemoveByPSDevCenterSVN(pSDevCenterSVN2);
                PSSFStyleVerServiceBase.this.onAfterRemoveByPSDevCenterSVN(pSDevCenterSVN2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
    }

    protected void internalRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSSFStyleVer> arrayList = this.selectByPSDevCenterSVN(pSDevCenterSVN);
        this.onBeforeRemoveByPSDevCenterSVN(pSDevCenterSVN, arrayList);
        for (PSSFStyleVer pSSFStyleVer : arrayList) {
            this.remove(pSSFStyleVer);
        }
        this.onAfterRemoveByPSDevCenterSVN(pSDevCenterSVN, arrayList);
    }

    protected void onAfterRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN, ArrayList<PSSFStyleVer> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN, ArrayList<PSSFStyleVer> arrayList) throws Exception {
    }

    public void testRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    public void resetPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSSFStyleVer> arrayList = this.selectByPSDevCenter(pSDevCenter);
        for (PSSFStyleVer pSSFStyleVer : arrayList) {
            PSSFStyleVer pSSFStyleVer2 = (PSSFStyleVer)this.getDEModel().createEntity();
            pSSFStyleVer2.setPSSFStyleVerId(pSSFStyleVer.getPSSFStyleVerId());
            pSSFStyleVer2.setPSDevCenterId(null);
            this.update(pSSFStyleVer2);
        }
    }

    public void removeByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSFStyleVerServiceBase.this.onBeforeRemoveByPSDevCenter(pSDevCenter2);
                PSSFStyleVerServiceBase.this.internalRemoveByPSDevCenter(pSDevCenter2);
                PSSFStyleVerServiceBase.this.onAfterRemoveByPSDevCenter(pSDevCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void internalRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSSFStyleVer> arrayList = this.selectByPSDevCenter(pSDevCenter);
        this.onBeforeRemoveByPSDevCenter(pSDevCenter, arrayList);
        for (PSSFStyleVer pSSFStyleVer : arrayList) {
            this.remove(pSSFStyleVer);
        }
        this.onAfterRemoveByPSDevCenter(pSDevCenter, arrayList);
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSSFStyleVer> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSSFStyleVer> arrayList) throws Exception {
    }

    public void testRemoveByPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
        ArrayList<PSSFStyleVer> arrayList = this.selectByPSSFStyle(pSSFStyle, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSFSTYLE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSFStyle);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSFSTYLEVER_PSSFSTYLE_PSSFSTYLEID", "", iDataEntityModel.getName(), "PSSFSTYLEVER", iDataEntityModel.getDataInfo(pSSFStyle), arrayList.get(0)));
        }
    }

    public void resetPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
        ArrayList<PSSFStyleVer> arrayList = this.selectByPSSFStyle(pSSFStyle);
        for (PSSFStyleVer pSSFStyleVer : arrayList) {
            PSSFStyleVer pSSFStyleVer2 = (PSSFStyleVer)this.getDEModel().createEntity();
            pSSFStyleVer2.setPSSFStyleVerId(pSSFStyleVer.getPSSFStyleVerId());
            pSSFStyleVer2.setPSSFStyleId(null);
            this.update(pSSFStyleVer2);
        }
    }

    public void removeByPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
        final PSSFStyle pSSFStyle2 = pSSFStyle;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSFStyleVerServiceBase.this.onBeforeRemoveByPSSFStyle(pSSFStyle2);
                PSSFStyleVerServiceBase.this.internalRemoveByPSSFStyle(pSSFStyle2);
                PSSFStyleVerServiceBase.this.onAfterRemoveByPSSFStyle(pSSFStyle2);
            }
        });
    }

    protected void onBeforeRemoveByPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
    }

    protected void internalRemoveByPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
        ArrayList<PSSFStyleVer> arrayList = this.selectByPSSFStyle(pSSFStyle);
        this.onBeforeRemoveByPSSFStyle(pSSFStyle, arrayList);
        for (PSSFStyleVer pSSFStyleVer : arrayList) {
            this.remove(pSSFStyleVer);
        }
        this.onAfterRemoveByPSSFStyle(pSSFStyle, arrayList);
    }

    protected void onAfterRemoveByPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
    }

    protected void onBeforeRemoveByPSSFStyle(PSSFStyle pSSFStyle, ArrayList<PSSFStyleVer> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSFStyle(PSSFStyle pSSFStyle, ArrayList<PSSFStyleVer> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSFStyleVer pSSFStyleVer) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDevSlnSysSrvService)ServiceGlobal.getService(PSDevSlnSysSrvService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnSysSrvServiceBase)pSCoreSysServiceBase).testRemoveByPSSFStyleVer(pSSFStyleVer);
        pSCoreSysServiceBase = (PSSFVerCodeService)ServiceGlobal.getService(PSSFVerCodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSSFVerCodeServiceBase)pSCoreSysServiceBase).testRemoveByPSSFStyleVer(pSSFStyleVer);
        ((PSSFVerCodeServiceBase)pSCoreSysServiceBase).removeByPSSFStyleVer(pSSFStyleVer);
        pSCoreSysServiceBase = (PSSysSFPubService)ServiceGlobal.getService(PSSysSFPubService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysSFPubServiceBase)pSCoreSysServiceBase).testRemoveByPSSFStyleVer(pSSFStyleVer);
        super.onBeforeRemove(pSSFStyleVer);
    }

    protected void replaceParentInfo(PSSFStyleVer pSSFStyleVer, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSFStyleVer, cloneSession);
        if (pSSFStyleVer.getPSDevCenterSVNId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERSVN", (Object)pSSFStyleVer.getPSDevCenterSVNId())) != null) {
            this.onFillParentInfo_PSDevCenterSVN(pSSFStyleVer, (PSDevCenterSVN)iEntity);
        }
        if (pSSFStyleVer.getPSDevCenterId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTER", (Object)pSSFStyleVer.getPSDevCenterId())) != null) {
            this.onFillParentInfo_PSDevCenter(pSSFStyleVer, (PSDevCenter)iEntity);
        }
        if (pSSFStyleVer.getPSSFStyleId() != null && (iEntity = cloneSession.getEntity("PSSFSTYLE", (Object)pSSFStyleVer.getPSSFStyleId())) != null) {
            this.onFillParentInfo_PSSFStyle(pSSFStyleVer, (PSSFStyle)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSFStyleVer pSSFStyleVer, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSFStyleVer, bl);
    }

    protected void onCheckEntity(boolean bl, PSSFStyleVer pSSFStyleVer, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_LastImpTime(bl, pSSFStyleVer, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Major(bl, pSSFStyleVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSFStyleVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Minor(bl, pSSFStyleVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterId(bl, pSSFStyleVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterSVNId(bl, pSSFStyleVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterSVNName(bl, pSSFStyleVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFStyleId(bl, pSSFStyleVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFStyleVerId(bl, pSSFStyleVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFStyleVerName(bl, pSSFStyleVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PubMode(bl, pSSFStyleVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplInfo(bl, pSSFStyleVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplState(bl, pSSFStyleVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSFStyleVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Version(bl, pSSFStyleVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSFStyleVer, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_LastImpTime(boolean bl, PSSFStyleVer pSSFStyleVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFStyleVer.isLastImpTimeDirty() : !pSSFStyleVer.isLastImpTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSSFStyleVer.getLastImpTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LastImpTime_Default(pSSFStyleVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LASTIMPTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Major(boolean bl, PSSFStyleVer pSSFStyleVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFStyleVer.isMajorDirty() : !pSSFStyleVer.isMajorDirty()) {
            return null;
        }
        Integer n = pSSFStyleVer.getMajor();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Major_Default(pSSFStyleVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAJOR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSFStyleVer pSSFStyleVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFStyleVer.isMemoDirty() : !pSSFStyleVer.isMemoDirty()) {
            return null;
        }
        String string = pSSFStyleVer.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSFStyleVer, bl2, bl3);
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

    protected EntityFieldError onCheckField_Minor(boolean bl, PSSFStyleVer pSSFStyleVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFStyleVer.isMinorDirty() : !pSSFStyleVer.isMinorDirty()) {
            return null;
        }
        Integer n = pSSFStyleVer.getMinor();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Minor_Default(pSSFStyleVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINOR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterId(boolean bl, PSSFStyleVer pSSFStyleVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFStyleVer.isPSDevCenterIdDirty() : !pSSFStyleVer.isPSDevCenterIdDirty()) {
            return null;
        }
        String string = pSSFStyleVer.getPSDevCenterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterId_Default(pSSFStyleVer, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevCenterSVNId(boolean bl, PSSFStyleVer pSSFStyleVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFStyleVer.isPSDevCenterSVNIdDirty() : !pSSFStyleVer.isPSDevCenterSVNIdDirty()) {
            return null;
        }
        String string = pSSFStyleVer.getPSDevCenterSVNId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterSVNId_Default(pSSFStyleVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERSVNID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterSVNName(boolean bl, PSSFStyleVer pSSFStyleVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFStyleVer.isPSDevCenterSVNNameDirty() : !pSSFStyleVer.isPSDevCenterSVNNameDirty()) {
            return null;
        }
        String string = pSSFStyleVer.getPSDevCenterSVNName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterSVNName_Default(pSSFStyleVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERSVNNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFStyleId(boolean bl, PSSFStyleVer pSSFStyleVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFStyleVer.isPSSFStyleIdDirty() && !bl2 : !pSSFStyleVer.isPSSFStyleIdDirty()) {
            return null;
        }
        String string = pSSFStyleVer.getPSSFStyleId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFSTYLEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFStyleId_Default(pSSFStyleVer, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSFStyleVerId(boolean bl, PSSFStyleVer pSSFStyleVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFStyleVer.isPSSFStyleVerIdDirty() && !bl2 : !pSSFStyleVer.isPSSFStyleVerIdDirty()) {
            return null;
        }
        String string = pSSFStyleVer.getPSSFStyleVerId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFSTYLEVERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFStyleVerId_Default(pSSFStyleVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFSTYLEVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFStyleVerName(boolean bl, PSSFStyleVer pSSFStyleVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFStyleVer.isPSSFStyleVerNameDirty() && !bl2 : !pSSFStyleVer.isPSSFStyleVerNameDirty()) {
            return null;
        }
        String string = pSSFStyleVer.getPSSFStyleVerName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFSTYLEVERNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFStyleVerName_Default(pSSFStyleVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFSTYLEVERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PubMode(boolean bl, PSSFStyleVer pSSFStyleVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFStyleVer.isPubModeDirty() : !pSSFStyleVer.isPubModeDirty()) {
            return null;
        }
        Integer n = pSSFStyleVer.getPubMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PubMode_Default(pSSFStyleVer, bl2, bl3);
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

    protected EntityFieldError onCheckField_TemplInfo(boolean bl, PSSFStyleVer pSSFStyleVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFStyleVer.isTemplInfoDirty() : !pSSFStyleVer.isTemplInfoDirty()) {
            return null;
        }
        String string = pSSFStyleVer.getTemplInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TemplInfo_Default(pSSFStyleVer, bl2, bl3);
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

    protected EntityFieldError onCheckField_TemplState(boolean bl, PSSFStyleVer pSSFStyleVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFStyleVer.isTemplStateDirty() : !pSSFStyleVer.isTemplStateDirty()) {
            return null;
        }
        Integer n = pSSFStyleVer.getTemplState();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_TemplState_Default(pSSFStyleVer, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSFStyleVer pSSFStyleVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFStyleVer.isValidFlagDirty() && !bl2 : !pSSFStyleVer.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSFStyleVer.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSSFStyleVer, bl2, bl3);
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

    protected EntityFieldError onCheckField_Version(boolean bl, PSSFStyleVer pSSFStyleVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFStyleVer.isVersionDirty() : !pSSFStyleVer.isVersionDirty()) {
            return null;
        }
        String string = pSSFStyleVer.getVersion();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Version_Default(pSSFStyleVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VERSION");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSSFStyleVer pSSFStyleVer, boolean bl) throws Exception {
        super.onSyncEntity(pSSFStyleVer, bl);
    }

    protected void onSyncIndexEntities(PSSFStyleVer pSSFStyleVer, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSFStyleVer, bl);
    }

    public Object getDataContextValue(PSSFStyleVer pSSFStyleVer, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSFStyleVer, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSFStyleVer pSSFStyleVer, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSFStyleVer, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LASTIMPTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LastImpTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAJOR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Major_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINOR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Minor_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERSVNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterSVNId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERSVNNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterSVNName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFSTYLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFStyleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFSTYLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFStyleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFSTYLEVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFStyleVerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFSTYLEVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFStyleVerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PUBMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PubMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplInfo_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VERSION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Version_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_LastImpTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Major_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_Minor_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_PSDevCenterSVNId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERSVNID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterSVNName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERSVNNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSFStyleVerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFSTYLEVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFStyleVerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFSTYLEVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Version_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VERSION", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected boolean onMergeChild(String string, String string2, PSSFStyleVer pSSFStyleVer) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSFStyleVer)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSFStyleVer pSSFStyleVer) throws Exception {
        super.onUpdateParent(pSSFStyleVer);
    }

    protected void onCopyDetails(PSSFStyleVer pSSFStyleVer, Object object) throws Exception {
        PSSFStyleVer pSSFStyleVer2 = new PSSFStyleVer();
        pSSFStyleVer2.set("PSSFSTYLEVERID", object);
        String string = DataObject.getStringValue((Object)pSSFStyleVer.get("PSSFSTYLEVERID"));
        PSSFVerCodeService pSSFVerCodeService = (PSSFVerCodeService)ServiceGlobal.getService(PSSFVerCodeService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSFVerCode> arrayList = pSSFVerCodeService.selectByPSSFStyleVer(pSSFStyleVer2);
        for (PSSFVerCode pSSFVerCode : arrayList) {
            Object object2 = pSSFVerCode.get("PSSFVERCODEID");
            pSSFVerCodeService.getDraftFrom(pSSFVerCode);
            pSSFVerCodeService.fillParentInfo(pSSFVerCode, "DER1N", "DER1N_PSSFVERCODE_PSSFSTYLEVER_PSSFSTYLEVERID", string);
            pSSFVerCodeService.create(pSSFVerCode);
            pSSFVerCodeService.copyDetails(pSSFVerCode, object2);
        }
        super.onCopyDetails(pSSFStyleVer, object);
    }

    @Override
    protected void exportCurXmlModel(PSSFStyleVer pSSFStyleVer, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSFSTYLEVER");
        if (!bl) {
            pSSFStyleVer.setCreateDate(null);
            pSSFStyleVer.setCreateMan(null);
            pSSFStyleVer.setMajor(null);
            pSSFStyleVer.setPSSFStyleVerId(null);
            pSSFStyleVer.setUpdateDate(null);
            pSSFStyleVer.setUpdateMan(null);
            super.exportCurXmlModel(pSSFStyleVer, xmlNode, bl);
        }
    }
}
