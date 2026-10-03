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
 *  net.ibizsys.paas.entity.EntityBase
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
import net.ibizsys.paas.entity.EntityBase;
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
import net.ibizsys.pscore.srv.appdesign.service.PSAppUIStyleService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppUIStyleServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewServiceBase;
import net.ibizsys.pscore.srv.config.dao.PSPFStyleDAO;
import net.ibizsys.pscore.srv.config.demodel.PSPFStyleDEModel;
import net.ibizsys.pscore.srv.config.entity.PSAppType;
import net.ibizsys.pscore.srv.config.entity.PSAppTypeBase;
import net.ibizsys.pscore.srv.config.entity.PSPF;
import net.ibizsys.pscore.srv.config.entity.PSPFBase;
import net.ibizsys.pscore.srv.config.entity.PSPFCtrlTempl;
import net.ibizsys.pscore.srv.config.entity.PSPFEditorTempl;
import net.ibizsys.pscore.srv.config.entity.PSPFStyle;
import net.ibizsys.pscore.srv.config.entity.PSPFStyleBase;
import net.ibizsys.pscore.srv.config.entity.PSPFStyleCode;
import net.ibizsys.pscore.srv.config.entity.PSPFViewTempl;
import net.ibizsys.pscore.srv.config.service.PSPFAppTemplService;
import net.ibizsys.pscore.srv.config.service.PSPFAppTemplServiceBase;
import net.ibizsys.pscore.srv.config.service.PSPFCtrlTemplService;
import net.ibizsys.pscore.srv.config.service.PSPFCtrlTemplServiceBase;
import net.ibizsys.pscore.srv.config.service.PSPFCtrlTypeService;
import net.ibizsys.pscore.srv.config.service.PSPFCtrlTypeServiceBase;
import net.ibizsys.pscore.srv.config.service.PSPFEditorTemplService;
import net.ibizsys.pscore.srv.config.service.PSPFEditorTemplServiceBase;
import net.ibizsys.pscore.srv.config.service.PSPFEditorTypeService;
import net.ibizsys.pscore.srv.config.service.PSPFEditorTypeServiceBase;
import net.ibizsys.pscore.srv.config.service.PSPFPubObjService;
import net.ibizsys.pscore.srv.config.service.PSPFPubObjServiceBase;
import net.ibizsys.pscore.srv.config.service.PSPFStyleCodeService;
import net.ibizsys.pscore.srv.config.service.PSPFStyleCodeServiceBase;
import net.ibizsys.pscore.srv.config.service.PSPFStyleLogService;
import net.ibizsys.pscore.srv.config.service.PSPFStyleLogServiceBase;
import net.ibizsys.pscore.srv.config.service.PSPFStylePkgService;
import net.ibizsys.pscore.srv.config.service.PSPFStylePkgServiceBase;
import net.ibizsys.pscore.srv.config.service.PSPFStylePrjService;
import net.ibizsys.pscore.srv.config.service.PSPFStylePrjServiceBase;
import net.ibizsys.pscore.srv.config.service.PSPFStyleRefService;
import net.ibizsys.pscore.srv.config.service.PSPFStyleRefServiceBase;
import net.ibizsys.pscore.srv.config.service.PSPFStyleService;
import net.ibizsys.pscore.srv.config.service.PSPFUATemplService;
import net.ibizsys.pscore.srv.config.service.PSPFUATemplServiceBase;
import net.ibizsys.pscore.srv.config.service.PSPFVLTemplService;
import net.ibizsys.pscore.srv.config.service.PSPFVLTemplServiceBase;
import net.ibizsys.pscore.srv.config.service.PSPFViewTemplService;
import net.ibizsys.pscore.srv.config.service.PSPFViewTemplServiceBase;
import net.ibizsys.pscore.srv.config.service.PSPFViewTypeService;
import net.ibizsys.pscore.srv.config.service.PSPFViewTypeServiceBase;
import net.ibizsys.pscore.srv.config.service.PSVTSampleService;
import net.ibizsys.pscore.srv.config.service.PSVTSampleServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterSVN;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterSVNBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCAbilityService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCAbilityServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysAppServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnTemplService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnTemplServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSPFStyleServiceBase
extends PSCoreSysServiceBase<PSPFStyle> {
    private static final Log log = LogFactory.getLog(PSPFStyleServiceBase.class);
    public static final String DATASET_CURDC = "CurDC";
    public static final String DATASET_CURDC2 = "CurDC2";
    public static final String DATASET_CURDCALL = "CurDCAll";
    public static final String DATASET_CURDCPF = "CurDCPF";
    public static final String DATASET_CURDCPF2 = "CurDCPF2";
    public static final String DATASET_CURDCPF3 = "CurDCPF3";
    public static final String DATASET_CURDCPFALL = "CurDCPFAll";
    public static final String DATASET_CURDCPFALL2 = "CurDCPFAll2";
    public static final String DATASET_CURPF = "CurPF";
    public static final String DATASET_CURPF3 = "CurPF3";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_EXPSTYLE = "ExpStyle";
    public static final String ACTION_FIXSTYLE = "FixStyle";
    public static final String ACTION_IMPSTYLE = "ImpStyle";
    public static final String ACTION_PUBLISH = "PUBLISH";
    private PSPFStyleDEModel pSPFStyleDEModel;
    private PSPFStyleDAO pSPFStyleDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSPFStyleService";
    }

    public PSPFStyleDEModel getPSPFStyleDEModel() {
        if (this.pSPFStyleDEModel == null) {
            try {
                this.pSPFStyleDEModel = (PSPFStyleDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSPFStyleDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSPFStyleDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSPFStyleDEModel();
    }

    public PSPFStyleDAO getPSPFStyleDAO() {
        if (this.pSPFStyleDAO == null) {
            try {
                this.pSPFStyleDAO = (PSPFStyleDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSPFStyleDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSPFStyleDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSPFStyleDAO();
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
        if (StringHelper.compare((String)string, (String)DATASET_CURDCPF, (boolean)true) == 0) {
            return this.fetchCurDCPF(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDCPF2, (boolean)true) == 0) {
            return this.fetchCurDCPF2(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDCPF3, (boolean)true) == 0) {
            return this.fetchCurDCPF3(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDCPFALL, (boolean)true) == 0) {
            return this.fetchCurDCPFAll(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDCPFALL2, (boolean)true) == 0) {
            return this.fetchCurDCPFAll2(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURPF, (boolean)true) == 0) {
            return this.fetchCurPF(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURPF3, (boolean)true) == 0) {
            return this.fetchCurPF3(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_EXPSTYLE, (boolean)true) == 0) {
            this.expStyle((PSPFStyle)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_FIXSTYLE, (boolean)true) == 0) {
            this.fixStyle((PSPFStyle)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_IMPSTYLE, (boolean)true) == 0) {
            this.impStyle((PSPFStyle)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_PUBLISH, (boolean)true) == 0) {
            this.publish((PSPFStyle)iEntity);
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

    public DBFetchResult fetchCurDCPF(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDCPF, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDCPF2(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDCPF2, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDCPF3(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDCPF3, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDCPFAll(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDCPFALL, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDCPFAll2(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDCPFALL2, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurPF(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURPF, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurPF3(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURPF3, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public void expStyle(PSPFStyle pSPFStyle) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_EXPSTYLE, 0, pSPFStyle, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSPFStyle, ACTION_EXPSTYLE);
        final PSPFStyle pSPFStyle2 = pSPFStyle;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSPFStyleServiceBase.this.getService(), PSPFStyleServiceBase.ACTION_EXPSTYLE, 40, pSPFStyle2, null).getResult() != 1) {
                    PSPFStyleServiceBase.this.onExpStyle(pSPFStyle2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_EXPSTYLE, 99, pSPFStyle, null);
        }
    }

    protected void onExpStyle(PSPFStyle pSPFStyle) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[ExpStyle]");
    }

    public void fixStyle(PSPFStyle pSPFStyle) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_FIXSTYLE, 0, pSPFStyle, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSPFStyle, ACTION_FIXSTYLE);
        final PSPFStyle pSPFStyle2 = pSPFStyle;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSPFStyleServiceBase.this.getService(), PSPFStyleServiceBase.ACTION_FIXSTYLE, 40, pSPFStyle2, null).getResult() != 1) {
                    PSPFStyleServiceBase.this.onFixStyle(pSPFStyle2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_FIXSTYLE, 99, pSPFStyle, null);
        }
    }

    protected void onFixStyle(PSPFStyle pSPFStyle) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[FixStyle]");
    }

    public void impStyle(PSPFStyle pSPFStyle) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_IMPSTYLE, 0, pSPFStyle, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSPFStyle, ACTION_IMPSTYLE);
        final PSPFStyle pSPFStyle2 = pSPFStyle;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSPFStyleServiceBase.this.getService(), PSPFStyleServiceBase.ACTION_IMPSTYLE, 40, pSPFStyle2, null).getResult() != 1) {
                    PSPFStyleServiceBase.this.onImpStyle(pSPFStyle2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_IMPSTYLE, 99, pSPFStyle, null);
        }
    }

    protected void onImpStyle(PSPFStyle pSPFStyle) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[ImpStyle]");
    }

    public void publish(PSPFStyle pSPFStyle) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_PUBLISH, 0, pSPFStyle, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSPFStyle, ACTION_PUBLISH);
        final PSPFStyle pSPFStyle2 = pSPFStyle;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSPFStyleServiceBase.this.getService(), PSPFStyleServiceBase.ACTION_PUBLISH, 40, pSPFStyle2, null).getResult() != 1) {
                    PSPFStyleServiceBase.this.onPublish(pSPFStyle2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_PUBLISH, 99, pSPFStyle, null);
        }
    }

    protected void onPublish(PSPFStyle pSPFStyle) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[PUBLISH]");
    }

    protected void onFillParentInfo(PSPFStyle pSPFStyle, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPFSTYLE_PSAPPTYPE_PSAPPTYPEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSAppTypeService", (SessionFactory)this.getSessionFactory());
            PSAppType pSAppType = (PSAppType)iService.getDEModel().createEntity();
            pSAppType.set("PSAPPTYPEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSAppType);
            } else {
                iService.get(pSAppType);
            }
            this.onFillParentInfo_PSAppType(pSPFStyle, pSAppType);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPFSTYLE_PSDEVCENTERSVN_PSDEVCENTERSVNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterSVNService", (SessionFactory)this.getSessionFactory());
            PSDevCenterSVN pSDevCenterSVN = (PSDevCenterSVN)iService.getDEModel().createEntity();
            pSDevCenterSVN.set("PSDEVCENTERSVNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenterSVN);
            } else {
                iService.get(pSDevCenterSVN);
            }
            this.onFillParentInfo_PSDevCenterSVN(pSPFStyle, pSDevCenterSVN);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPFSTYLE_PSDEVCENTER_PSDEVCENTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService", (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = (PSDevCenter)iService.getDEModel().createEntity();
            pSDevCenter.set("PSDEVCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenter);
            } else {
                iService.get(pSDevCenter);
            }
            this.onFillParentInfo_PSDevCenter(pSPFStyle, pSDevCenter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPFSTYLE_PSPFSTYLE_TEMPLPSPFSTYLEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFStyleService", (SessionFactory)this.getSessionFactory());
            PSPFStyle pSPFStyle2 = (PSPFStyle)iService.getDEModel().createEntity();
            pSPFStyle2.set("PSPFSTYLEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSPFStyle2);
            } else {
                iService.get(pSPFStyle2);
            }
            this.onFillParentInfo_TemplPSPFStyle(pSPFStyle, pSPFStyle2);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPFSTYLE_PSPF_PSPFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFService", (SessionFactory)this.getSessionFactory());
            PSPF pSPF = (PSPF)iService.getDEModel().createEntity();
            pSPF.set("PSPFID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSPF);
            } else {
                iService.get(pSPF);
            }
            this.onFillParentInfo_PSPF(pSPFStyle, pSPF);
            return;
        }
        super.onFillParentInfo(pSPFStyle, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSAppType(PSPFStyle pSPFStyle, PSAppType pSAppType) throws Exception {
        pSPFStyle.setPSAppTypeId(pSAppType.getPSAppTypeId());
        pSPFStyle.setPSAppTypeName(pSAppType.getPSAppTypeName());
    }

    protected void onFillParentInfo_PSDevCenterSVN(PSPFStyle pSPFStyle, PSDevCenterSVN pSDevCenterSVN) throws Exception {
        pSPFStyle.setPSDevCenterSVNId(pSDevCenterSVN.getPSDevCenterSVNId());
        pSPFStyle.setPSDevCenterSVNName(pSDevCenterSVN.getPSDevCenterSVNName());
    }

    protected void onFillParentInfo_PSDevCenter(PSPFStyle pSPFStyle, PSDevCenter pSDevCenter) throws Exception {
        pSPFStyle.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
        pSPFStyle.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
    }

    protected void onFillParentInfo_TemplPSPFStyle(PSPFStyle pSPFStyle, PSPFStyle pSPFStyle2) throws Exception {
        pSPFStyle.setTemplPSPFStyleId(pSPFStyle2.getPSPFStyleId());
        pSPFStyle.setTemplPSPFStyleName(pSPFStyle2.getPSPFStyleName());
    }

    protected void onFillParentInfo_PSPF(PSPFStyle pSPFStyle, PSPF pSPF) throws Exception {
        pSPFStyle.setPSPFId(pSPF.getPSPFId());
        pSPFStyle.setPSPFName(pSPF.getPSPFName());
        if (pSPF.getPSAppType() != null) {
            this.onFillParentInfo_PSAppType(pSPFStyle, pSPF.getPSAppType());
        }
    }

    protected void onFillEntityFullInfo(PSPFStyle pSPFStyle, boolean bl) throws Exception {
        if (bl) {
            if (pSPFStyle.getPubMode() == null) {
                pSPFStyle.setPubMode((Integer)this.getDefaultValue(this.getWebContext(), "", "2", 9));
            }
            if (pSPFStyle.getVersion() == null) {
                pSPFStyle.setVersion((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo(pSPFStyle, bl);
        this.onFillEntityFullInfo_PSAppType(pSPFStyle, bl);
        this.onFillEntityFullInfo_PSDevCenterSVN(pSPFStyle, bl);
        this.onFillEntityFullInfo_PSDevCenter(pSPFStyle, bl);
        this.onFillEntityFullInfo_TemplPSPFStyle(pSPFStyle, bl);
        this.onFillEntityFullInfo_PSPF(pSPFStyle, bl);
    }

    protected void onFillEntityFullInfo_PSAppType(PSPFStyle pSPFStyle, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevCenterSVN(PSPFStyle pSPFStyle, boolean bl) throws Exception {
        if (pSPFStyle.isPSDevCenterSVNIdDirty()) {
            if (pSPFStyle.getPSDevCenterSVNId() != null) {
                if (pSPFStyle.getPSDevCenterSVNId() == null || pSPFStyle.getPSDevCenterSVNName() == null) {
                    PSDevCenterSVN pSDevCenterSVN = pSPFStyle.getPSDevCenterSVN();
                    pSPFStyle.setPSDevCenterSVNName(pSDevCenterSVN.getPSDevCenterSVNName());
                }
            } else {
                pSPFStyle.setPSDevCenterSVNName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDevCenter(PSPFStyle pSPFStyle, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_TemplPSPFStyle(PSPFStyle pSPFStyle, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSPF(PSPFStyle pSPFStyle, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSPFStyle pSPFStyle, boolean bl) throws Exception {
        super.onWriteBackParent(pSPFStyle, bl);
    }

    public ArrayList<PSPFStyle> selectByPSAppType(PSAppTypeBase pSAppTypeBase) throws Exception {
        return this.selectByPSAppType(pSAppTypeBase, "", -1);
    }

    public ArrayList<PSPFStyle> selectByPSAppType(PSAppTypeBase pSAppTypeBase, String string) throws Exception {
        return this.selectByPSAppType(pSAppTypeBase, string, -1);
    }

    public ArrayList<PSPFStyle> selectByPSAppType(PSAppTypeBase pSAppTypeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSAPPTYPEID", (Object)pSAppTypeBase.getPSAppTypeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSAppTypeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSAppTypeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSPFStyle> selectByPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase) throws Exception {
        return this.selectByPSDevCenterSVN(pSDevCenterSVNBase, "", -1);
    }

    public ArrayList<PSPFStyle> selectByPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase, String string) throws Exception {
        return this.selectByPSDevCenterSVN(pSDevCenterSVNBase, string, -1);
    }

    public ArrayList<PSPFStyle> selectByPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase, String string, int n) throws Exception {
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

    public ArrayList<PSPFStyle> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, "", -1);
    }

    public ArrayList<PSPFStyle> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, string, -1);
    }

    public ArrayList<PSPFStyle> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string, int n) throws Exception {
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

    public ArrayList<PSPFStyle> selectByTemplPSPFStyle(PSPFStyleBase pSPFStyleBase) throws Exception {
        return this.selectByTemplPSPFStyle(pSPFStyleBase, "", -1);
    }

    public ArrayList<PSPFStyle> selectByTemplPSPFStyle(PSPFStyleBase pSPFStyleBase, String string) throws Exception {
        return this.selectByTemplPSPFStyle(pSPFStyleBase, string, -1);
    }

    public ArrayList<PSPFStyle> selectByTemplPSPFStyle(PSPFStyleBase pSPFStyleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("TEMPLPSPFSTYLEID", (Object)pSPFStyleBase.getPSPFStyleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByTemplPSPFStyleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByTemplPSPFStyleCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSPFStyle> selectByPSPF(PSPFBase pSPFBase) throws Exception {
        return this.selectByPSPF(pSPFBase, "", -1);
    }

    public ArrayList<PSPFStyle> selectByPSPF(PSPFBase pSPFBase, String string) throws Exception {
        return this.selectByPSPF(pSPFBase, string, -1);
    }

    public ArrayList<PSPFStyle> selectByPSPF(PSPFBase pSPFBase, String string, int n) throws Exception {
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

    public void testRemoveByPSAppType(PSAppType pSAppType) throws Exception {
    }

    public void resetPSAppType(PSAppType pSAppType) throws Exception {
        ArrayList<PSPFStyle> arrayList = this.selectByPSAppType(pSAppType);
        for (PSPFStyle pSPFStyle : arrayList) {
            PSPFStyle pSPFStyle2 = (PSPFStyle)this.getDEModel().createEntity();
            pSPFStyle2.setPSPFStyleId(pSPFStyle.getPSPFStyleId());
            pSPFStyle2.setPSAppTypeId(null);
            this.update(pSPFStyle2);
        }
    }

    public void removeByPSAppType(PSAppType pSAppType) throws Exception {
        final PSAppType pSAppType2 = pSAppType;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPFStyleServiceBase.this.onBeforeRemoveByPSAppType(pSAppType2);
                PSPFStyleServiceBase.this.internalRemoveByPSAppType(pSAppType2);
                PSPFStyleServiceBase.this.onAfterRemoveByPSAppType(pSAppType2);
            }
        });
    }

    protected void onBeforeRemoveByPSAppType(PSAppType pSAppType) throws Exception {
    }

    protected void internalRemoveByPSAppType(PSAppType pSAppType) throws Exception {
        ArrayList<PSPFStyle> arrayList = this.selectByPSAppType(pSAppType);
        this.onBeforeRemoveByPSAppType(pSAppType, arrayList);
        for (PSPFStyle pSPFStyle : arrayList) {
            this.remove(pSPFStyle);
        }
        this.onAfterRemoveByPSAppType(pSAppType, arrayList);
    }

    protected void onAfterRemoveByPSAppType(PSAppType pSAppType) throws Exception {
    }

    protected void onBeforeRemoveByPSAppType(PSAppType pSAppType, ArrayList<PSPFStyle> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSAppType(PSAppType pSAppType, ArrayList<PSPFStyle> arrayList) throws Exception {
    }

    public void testRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
    }

    public void resetPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSPFStyle> arrayList = this.selectByPSDevCenterSVN(pSDevCenterSVN);
        for (PSPFStyle pSPFStyle : arrayList) {
            PSPFStyle pSPFStyle2 = (PSPFStyle)this.getDEModel().createEntity();
            pSPFStyle2.setPSPFStyleId(pSPFStyle.getPSPFStyleId());
            pSPFStyle2.setPSDevCenterSVNId(null);
            this.update(pSPFStyle2);
        }
    }

    public void removeByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        final PSDevCenterSVN pSDevCenterSVN2 = pSDevCenterSVN;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPFStyleServiceBase.this.onBeforeRemoveByPSDevCenterSVN(pSDevCenterSVN2);
                PSPFStyleServiceBase.this.internalRemoveByPSDevCenterSVN(pSDevCenterSVN2);
                PSPFStyleServiceBase.this.onAfterRemoveByPSDevCenterSVN(pSDevCenterSVN2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
    }

    protected void internalRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSPFStyle> arrayList = this.selectByPSDevCenterSVN(pSDevCenterSVN);
        this.onBeforeRemoveByPSDevCenterSVN(pSDevCenterSVN, arrayList);
        for (PSPFStyle pSPFStyle : arrayList) {
            this.remove(pSPFStyle);
        }
        this.onAfterRemoveByPSDevCenterSVN(pSDevCenterSVN, arrayList);
    }

    protected void onAfterRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN, ArrayList<PSPFStyle> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN, ArrayList<PSPFStyle> arrayList) throws Exception {
    }

    public void testRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    public void resetPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSPFStyle> arrayList = this.selectByPSDevCenter(pSDevCenter);
        for (PSPFStyle pSPFStyle : arrayList) {
            PSPFStyle pSPFStyle2 = (PSPFStyle)this.getDEModel().createEntity();
            pSPFStyle2.setPSPFStyleId(pSPFStyle.getPSPFStyleId());
            pSPFStyle2.setPSDevCenterId(null);
            this.update(pSPFStyle2);
        }
    }

    public void removeByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPFStyleServiceBase.this.onBeforeRemoveByPSDevCenter(pSDevCenter2);
                PSPFStyleServiceBase.this.internalRemoveByPSDevCenter(pSDevCenter2);
                PSPFStyleServiceBase.this.onAfterRemoveByPSDevCenter(pSDevCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void internalRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSPFStyle> arrayList = this.selectByPSDevCenter(pSDevCenter);
        this.onBeforeRemoveByPSDevCenter(pSDevCenter, arrayList);
        for (PSPFStyle pSPFStyle : arrayList) {
            this.remove(pSPFStyle);
        }
        this.onAfterRemoveByPSDevCenter(pSDevCenter, arrayList);
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSPFStyle> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSPFStyle> arrayList) throws Exception {
    }

    public void testRemoveByTemplPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
        ArrayList<PSPFStyle> arrayList = this.selectByTemplPSPFStyle(pSPFStyle, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSPFSTYLE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSPFStyle);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSPFSTYLE_PSPFSTYLE_TEMPLPSPFSTYLEID", "", iDataEntityModel.getName(), "PSPFSTYLE", iDataEntityModel.getDataInfo(pSPFStyle), arrayList.get(0)));
        }
    }

    public void resetTemplPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
        ArrayList<PSPFStyle> arrayList = this.selectByTemplPSPFStyle(pSPFStyle);
        for (PSPFStyle pSPFStyle2 : arrayList) {
            PSPFStyle pSPFStyle3 = (PSPFStyle)this.getDEModel().createEntity();
            pSPFStyle3.setPSPFStyleId(pSPFStyle2.getPSPFStyleId());
            pSPFStyle3.setTemplPSPFStyleId(null);
            this.update(pSPFStyle3);
        }
    }

    public void removeByTemplPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
        final PSPFStyle pSPFStyle2 = pSPFStyle;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPFStyleServiceBase.this.onBeforeRemoveByTemplPSPFStyle(pSPFStyle2);
                PSPFStyleServiceBase.this.internalRemoveByTemplPSPFStyle(pSPFStyle2);
                PSPFStyleServiceBase.this.onAfterRemoveByTemplPSPFStyle(pSPFStyle2);
            }
        });
    }

    protected void onBeforeRemoveByTemplPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
    }

    protected void internalRemoveByTemplPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
        ArrayList<PSPFStyle> arrayList = this.selectByTemplPSPFStyle(pSPFStyle);
        this.onBeforeRemoveByTemplPSPFStyle(pSPFStyle, arrayList);
        for (PSPFStyle pSPFStyle2 : arrayList) {
            this.remove(pSPFStyle2);
        }
        this.onAfterRemoveByTemplPSPFStyle(pSPFStyle, arrayList);
    }

    protected void onAfterRemoveByTemplPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
    }

    protected void onBeforeRemoveByTemplPSPFStyle(PSPFStyle pSPFStyle, ArrayList<PSPFStyle> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTemplPSPFStyle(PSPFStyle pSPFStyle, ArrayList<PSPFStyle> arrayList) throws Exception {
    }

    public void testRemoveByPSPF(PSPF pSPF) throws Exception {
    }

    public void resetPSPF(PSPF pSPF) throws Exception {
        ArrayList<PSPFStyle> arrayList = this.selectByPSPF(pSPF);
        for (PSPFStyle pSPFStyle : arrayList) {
            PSPFStyle pSPFStyle2 = (PSPFStyle)this.getDEModel().createEntity();
            pSPFStyle2.setPSPFStyleId(pSPFStyle.getPSPFStyleId());
            pSPFStyle2.setPSPFId(null);
            this.update(pSPFStyle2);
        }
    }

    public void removeByPSPF(PSPF pSPF) throws Exception {
        final PSPF pSPF2 = pSPF;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPFStyleServiceBase.this.onBeforeRemoveByPSPF(pSPF2);
                PSPFStyleServiceBase.this.internalRemoveByPSPF(pSPF2);
                PSPFStyleServiceBase.this.onAfterRemoveByPSPF(pSPF2);
            }
        });
    }

    protected void onBeforeRemoveByPSPF(PSPF pSPF) throws Exception {
    }

    protected void internalRemoveByPSPF(PSPF pSPF) throws Exception {
        ArrayList<PSPFStyle> arrayList = this.selectByPSPF(pSPF);
        this.onBeforeRemoveByPSPF(pSPF, arrayList);
        for (PSPFStyle pSPFStyle : arrayList) {
            this.remove(pSPFStyle);
        }
        this.onAfterRemoveByPSPF(pSPF, arrayList);
    }

    protected void onAfterRemoveByPSPF(PSPF pSPF) throws Exception {
    }

    protected void onBeforeRemoveByPSPF(PSPF pSPF, ArrayList<PSPFStyle> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSPF(PSPF pSPF, ArrayList<PSPFStyle> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSPFStyle pSPFStyle) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSAppUIStyleService)ServiceGlobal.getService(PSAppUIStyleService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppUIStyleServiceBase)pSCoreSysServiceBase).testRemoveByPSPFStyle(pSPFStyle);
        pSCoreSysServiceBase = (PSAppViewService)ServiceGlobal.getService(PSAppViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppViewServiceBase)pSCoreSysServiceBase).testRemoveByPSPFStyle(pSPFStyle);
        pSCoreSysServiceBase = (PSDCAbilityService)ServiceGlobal.getService(PSDCAbilityService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCAbilityServiceBase)pSCoreSysServiceBase).testRemoveByPSPSStyle(pSPFStyle);
        pSCoreSysServiceBase = (PSDevSlnSysAppService)ServiceGlobal.getService(PSDevSlnSysAppService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnSysAppServiceBase)pSCoreSysServiceBase).testRemoveByPSPFStyle(pSPFStyle);
        pSCoreSysServiceBase = (PSDevSlnTemplService)ServiceGlobal.getService(PSDevSlnTemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnTemplServiceBase)pSCoreSysServiceBase).testRemoveByPSPFStyle(pSPFStyle);
        pSCoreSysServiceBase = (PSDevSlnTemplService)ServiceGlobal.getService(PSDevSlnTemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnTemplServiceBase)pSCoreSysServiceBase).testRemoveByTemplPSPFStyle(pSPFStyle);
        pSCoreSysServiceBase = (PSPFAppTemplService)ServiceGlobal.getService(PSPFAppTemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSPFAppTemplServiceBase)pSCoreSysServiceBase).testRemoveByPSPFStyle(pSPFStyle);
        ((PSPFAppTemplServiceBase)pSCoreSysServiceBase).removeByPSPFStyle(pSPFStyle);
        pSCoreSysServiceBase = (PSPFCtrlTemplService)ServiceGlobal.getService(PSPFCtrlTemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSPFCtrlTemplServiceBase)pSCoreSysServiceBase).testRemoveByPSPFStyle(pSPFStyle);
        pSCoreSysServiceBase = (PSPFCtrlTypeService)ServiceGlobal.getService(PSPFCtrlTypeService.class, (SessionFactory)this.getSessionFactory());
        ((PSPFCtrlTypeServiceBase)pSCoreSysServiceBase).testRemoveByPSPFStyle(pSPFStyle);
        pSCoreSysServiceBase = (PSPFEditorTemplService)ServiceGlobal.getService(PSPFEditorTemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSPFEditorTemplServiceBase)pSCoreSysServiceBase).testRemoveByPSPFStyle(pSPFStyle);
        pSCoreSysServiceBase = (PSPFEditorTypeService)ServiceGlobal.getService(PSPFEditorTypeService.class, (SessionFactory)this.getSessionFactory());
        ((PSPFEditorTypeServiceBase)pSCoreSysServiceBase).testRemoveByPSPFStyle(pSPFStyle);
        pSCoreSysServiceBase = (PSPFPubObjService)ServiceGlobal.getService(PSPFPubObjService.class, (SessionFactory)this.getSessionFactory());
        ((PSPFPubObjServiceBase)pSCoreSysServiceBase).testRemoveByPSPFStyle(pSPFStyle);
        pSCoreSysServiceBase = (PSPFStyleCodeService)ServiceGlobal.getService(PSPFStyleCodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSPFStyleCodeServiceBase)pSCoreSysServiceBase).testRemoveByPSPFStyle(pSPFStyle);
        ((PSPFStyleCodeServiceBase)pSCoreSysServiceBase).removeByPSPFStyle(pSPFStyle);
        pSCoreSysServiceBase = (PSPFStyleLogService)ServiceGlobal.getService(PSPFStyleLogService.class, (SessionFactory)this.getSessionFactory());
        ((PSPFStyleLogServiceBase)pSCoreSysServiceBase).testRemoveByPSPFStyle(pSPFStyle);
        ((PSPFStyleLogServiceBase)pSCoreSysServiceBase).removeByPSPFStyle(pSPFStyle);
        pSCoreSysServiceBase = (PSPFStylePkgService)ServiceGlobal.getService(PSPFStylePkgService.class, (SessionFactory)this.getSessionFactory());
        ((PSPFStylePkgServiceBase)pSCoreSysServiceBase).testRemoveByPSPFStyle(pSPFStyle);
        ((PSPFStylePkgServiceBase)pSCoreSysServiceBase).removeByPSPFStyle(pSPFStyle);
        pSCoreSysServiceBase = (PSPFStylePrjService)ServiceGlobal.getService(PSPFStylePrjService.class, (SessionFactory)this.getSessionFactory());
        ((PSPFStylePrjServiceBase)pSCoreSysServiceBase).testRemoveByPSPFStyle(pSPFStyle);
        ((PSPFStylePrjServiceBase)pSCoreSysServiceBase).removeByPSPFStyle(pSPFStyle);
        pSCoreSysServiceBase = (PSPFStyleRefService)ServiceGlobal.getService(PSPFStyleRefService.class, (SessionFactory)this.getSessionFactory());
        ((PSPFStyleRefServiceBase)pSCoreSysServiceBase).testRemoveByPSPFStyle(pSPFStyle);
        ((PSPFStyleRefServiceBase)pSCoreSysServiceBase).removeByPSPFStyle(pSPFStyle);
        pSCoreSysServiceBase = (PSPFStyleRefService)ServiceGlobal.getService(PSPFStyleRefService.class, (SessionFactory)this.getSessionFactory());
        ((PSPFStyleRefServiceBase)pSCoreSysServiceBase).testRemoveByRefPSPFStyle(pSPFStyle);
        pSCoreSysServiceBase = (PSPFStyleService)ServiceGlobal.getService(PSPFStyleService.class, (SessionFactory)this.getSessionFactory());
        ((PSPFStyleServiceBase)pSCoreSysServiceBase).testRemoveByTemplPSPFStyle(pSPFStyle);
        pSCoreSysServiceBase = (PSPFUATemplService)ServiceGlobal.getService(PSPFUATemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSPFUATemplServiceBase)pSCoreSysServiceBase).testRemoveByPSPFStyle(pSPFStyle);
        pSCoreSysServiceBase = (PSPFViewTemplService)ServiceGlobal.getService(PSPFViewTemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSPFViewTemplServiceBase)pSCoreSysServiceBase).testRemoveByPSPFStyle(pSPFStyle);
        pSCoreSysServiceBase = (PSPFViewTypeService)ServiceGlobal.getService(PSPFViewTypeService.class, (SessionFactory)this.getSessionFactory());
        ((PSPFViewTypeServiceBase)pSCoreSysServiceBase).testRemoveByPSPFStyle(pSPFStyle);
        pSCoreSysServiceBase = (PSPFVLTemplService)ServiceGlobal.getService(PSPFVLTemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSPFVLTemplServiceBase)pSCoreSysServiceBase).testRemoveByPSPFStyle(pSPFStyle);
        ((PSPFVLTemplServiceBase)pSCoreSysServiceBase).removeByPSPFStyle(pSPFStyle);
        pSCoreSysServiceBase = (PSSysAppService)ServiceGlobal.getService(PSSysAppService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysAppServiceBase)pSCoreSysServiceBase).testRemoveByPSPFStyle(pSPFStyle);
        pSCoreSysServiceBase = (PSVTSampleService)ServiceGlobal.getService(PSVTSampleService.class, (SessionFactory)this.getSessionFactory());
        ((PSVTSampleServiceBase)pSCoreSysServiceBase).testRemoveByPSPFStyle(pSPFStyle);
        super.onBeforeRemove(pSPFStyle);
    }

    protected void replaceParentInfo(PSPFStyle pSPFStyle, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSPFStyle, cloneSession);
        if (pSPFStyle.getPSAppTypeId() != null && (iEntity = cloneSession.getEntity("PSAPPTYPE", (Object)pSPFStyle.getPSAppTypeId())) != null) {
            this.onFillParentInfo_PSAppType(pSPFStyle, (PSAppType)iEntity);
        }
        if (pSPFStyle.getPSDevCenterSVNId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERSVN", (Object)pSPFStyle.getPSDevCenterSVNId())) != null) {
            this.onFillParentInfo_PSDevCenterSVN(pSPFStyle, (PSDevCenterSVN)iEntity);
        }
        if (pSPFStyle.getPSDevCenterId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTER", (Object)pSPFStyle.getPSDevCenterId())) != null) {
            this.onFillParentInfo_PSDevCenter(pSPFStyle, (PSDevCenter)iEntity);
        }
        if (pSPFStyle.getTemplPSPFStyleId() != null && (iEntity = cloneSession.getEntity("PSPFSTYLE", (Object)pSPFStyle.getTemplPSPFStyleId())) != null) {
            this.onFillParentInfo_TemplPSPFStyle(pSPFStyle, (PSPFStyle)iEntity);
        }
        if (pSPFStyle.getPSPFId() != null && (iEntity = cloneSession.getEntity("PSPF", (Object)pSPFStyle.getPSPFId())) != null) {
            this.onFillParentInfo_PSPF(pSPFStyle, (PSPF)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSPFStyle pSPFStyle, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSPFStyle, bl);
    }

    protected void onCheckEntity(boolean bl, PSPFStyle pSPFStyle, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ClsPkgParams(bl, pSPFStyle, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DCStyleCode(bl, pSPFStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefaultFlag(bl, pSPFStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaDepStyleFlag(bl, pSPFStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LastestFlag(bl, pSPFStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LastImpTime(bl, pSPFStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSPFStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PFStyleParam(bl, pSPFStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppTypeId(bl, pSPFStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterId(bl, pSPFStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterSVNId(bl, pSPFStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterSVNName(bl, pSPFStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnId(bl, pSPFStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFId(bl, pSPFStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFStyleId(bl, pSPFStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFStyleName(bl, pSPFStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PubMode(bl, pSPFStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefreshVer(bl, pSPFStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StyleCode(bl, pSPFStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StyleEngine(bl, pSPFStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StyleResUrl(bl, pSPFStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplFlag(bl, pSPFStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplInfo(bl, pSPFStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplPSPFStyleId(bl, pSPFStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplRootUrl(bl, pSPFStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplState(bl, pSPFStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSPFStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSPFStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_V2Folder(bl, pSPFStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_V2Folder2(bl, pSPFStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_V2GitPath(bl, pSPFStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Version(bl, pSPFStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_VerStr(bl, pSPFStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSPFStyle, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ClsPkgParams(boolean bl, PSPFStyle pSPFStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFStyle.isClsPkgParamsDirty() : !pSPFStyle.isClsPkgParamsDirty()) {
            return null;
        }
        String string = pSPFStyle.getClsPkgParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ClsPkgParams_Default(pSPFStyle, bl2, bl3);
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

    protected EntityFieldError onCheckField_DCStyleCode(boolean bl, PSPFStyle pSPFStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFStyle.isDCStyleCodeDirty() : !pSPFStyle.isDCStyleCodeDirty()) {
            return null;
        }
        String string = pSPFStyle.getDCStyleCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DCStyleCode_Default(pSPFStyle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DCSTYLECODE");
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
                string3 = "PSDEVCENTERID";
                string3 = string3 + ";";
                string3 = string3 + "PSPFID";
                String string4 = this.checkFieldDupRule(this.getPSPFStyleDEModel(), "DCSTYLECODE", string3, pSPFStyle, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("DCSTYLECODE");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DefaultFlag(boolean bl, PSPFStyle pSPFStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFStyle.isDefaultFlagDirty() : !pSPFStyle.isDefaultFlagDirty()) {
            return null;
        }
        Integer n = pSPFStyle.getDefaultFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DefaultFlag_Default(pSPFStyle, bl2, bl3);
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

    protected EntityFieldError onCheckField_DynaDepStyleFlag(boolean bl, PSPFStyle pSPFStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFStyle.isDynaDepStyleFlagDirty() : !pSPFStyle.isDynaDepStyleFlagDirty()) {
            return null;
        }
        Integer n = pSPFStyle.getDynaDepStyleFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DynaDepStyleFlag_Default(pSPFStyle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DYNADEPSTYLEFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LastestFlag(boolean bl, PSPFStyle pSPFStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFStyle.isLastestFlagDirty() : !pSPFStyle.isLastestFlagDirty()) {
            return null;
        }
        Integer n = pSPFStyle.getLastestFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LastestFlag_Default(pSPFStyle, bl2, bl3);
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

    protected EntityFieldError onCheckField_LastImpTime(boolean bl, PSPFStyle pSPFStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFStyle.isLastImpTimeDirty() : !pSPFStyle.isLastImpTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSPFStyle.getLastImpTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LastImpTime_Default(pSPFStyle, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSPFStyle pSPFStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFStyle.isMemoDirty() : !pSPFStyle.isMemoDirty()) {
            return null;
        }
        String string = pSPFStyle.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSPFStyle, bl2, bl3);
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

    protected EntityFieldError onCheckField_PFStyleParam(boolean bl, PSPFStyle pSPFStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFStyle.isPFStyleParamDirty() : !pSPFStyle.isPFStyleParamDirty()) {
            return null;
        }
        String string = pSPFStyle.getPFStyleParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PFStyleParam_Default(pSPFStyle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PFSTYLEPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppTypeId(boolean bl, PSPFStyle pSPFStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFStyle.isPSAppTypeIdDirty() : !pSPFStyle.isPSAppTypeIdDirty()) {
            return null;
        }
        String string = pSPFStyle.getPSAppTypeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppTypeId_Default(pSPFStyle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPTYPEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterId(boolean bl, PSPFStyle pSPFStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFStyle.isPSDevCenterIdDirty() : !pSPFStyle.isPSDevCenterIdDirty()) {
            return null;
        }
        String string = pSPFStyle.getPSDevCenterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterId_Default(pSPFStyle, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevCenterSVNId(boolean bl, PSPFStyle pSPFStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFStyle.isPSDevCenterSVNIdDirty() : !pSPFStyle.isPSDevCenterSVNIdDirty()) {
            return null;
        }
        String string = pSPFStyle.getPSDevCenterSVNId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterSVNId_Default(pSPFStyle, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevCenterSVNName(boolean bl, PSPFStyle pSPFStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFStyle.isPSDevCenterSVNNameDirty() : !pSPFStyle.isPSDevCenterSVNNameDirty()) {
            return null;
        }
        String string = pSPFStyle.getPSDevCenterSVNName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterSVNName_Default(pSPFStyle, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnId(boolean bl, PSPFStyle pSPFStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFStyle.isPSDevSlnIdDirty() : !pSPFStyle.isPSDevSlnIdDirty()) {
            return null;
        }
        String string = pSPFStyle.getPSDevSlnId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnId_Default(pSPFStyle, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSPFId(boolean bl, PSPFStyle pSPFStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFStyle.isPSPFIdDirty() && !bl2 : !pSPFStyle.isPSPFIdDirty()) {
            return null;
        }
        String string = pSPFStyle.getPSPFId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFId_Default(pSPFStyle, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSPFStyleId(boolean bl, PSPFStyle pSPFStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFStyle.isPSPFStyleIdDirty() && !bl2 : !pSPFStyle.isPSPFStyleIdDirty()) {
            return null;
        }
        String string = pSPFStyle.getPSPFStyleId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFSTYLEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFStyleId_Default(pSPFStyle, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSPFStyleName(boolean bl, PSPFStyle pSPFStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFStyle.isPSPFStyleNameDirty() && !bl2 : !pSPFStyle.isPSPFStyleNameDirty()) {
            return null;
        }
        String string = pSPFStyle.getPSPFStyleName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFSTYLENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFStyleName_Default(pSPFStyle, bl2, bl3);
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

    protected EntityFieldError onCheckField_PubMode(boolean bl, PSPFStyle pSPFStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFStyle.isPubModeDirty() : !pSPFStyle.isPubModeDirty()) {
            return null;
        }
        Integer n = pSPFStyle.getPubMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PubMode_Default(pSPFStyle, bl2, bl3);
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

    protected EntityFieldError onCheckField_RefreshVer(boolean bl, PSPFStyle pSPFStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFStyle.isRefreshVerDirty() : !pSPFStyle.isRefreshVerDirty()) {
            return null;
        }
        Integer n = pSPFStyle.getRefreshVer();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_RefreshVer_Default(pSPFStyle, bl2, bl3);
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

    protected EntityFieldError onCheckField_StyleCode(boolean bl, PSPFStyle pSPFStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFStyle.isStyleCodeDirty() && !bl2 : !pSPFStyle.isStyleCodeDirty()) {
            return null;
        }
        String string = pSPFStyle.getStyleCode();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STYLECODE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_StyleCode_Default(pSPFStyle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STYLECODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StyleEngine(boolean bl, PSPFStyle pSPFStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFStyle.isStyleEngineDirty() : !pSPFStyle.isStyleEngineDirty()) {
            return null;
        }
        String string = pSPFStyle.getStyleEngine();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_StyleEngine_Default(pSPFStyle, bl2, bl3);
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

    protected EntityFieldError onCheckField_StyleResUrl(boolean bl, PSPFStyle pSPFStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFStyle.isStyleResUrlDirty() : !pSPFStyle.isStyleResUrlDirty()) {
            return null;
        }
        String string = pSPFStyle.getStyleResUrl();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_StyleResUrl_Default(pSPFStyle, bl2, bl3);
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

    protected EntityFieldError onCheckField_TemplFlag(boolean bl, PSPFStyle pSPFStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFStyle.isTemplFlagDirty() : !pSPFStyle.isTemplFlagDirty()) {
            return null;
        }
        Integer n = pSPFStyle.getTemplFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_TemplFlag_Default(pSPFStyle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPLFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TemplInfo(boolean bl, PSPFStyle pSPFStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFStyle.isTemplInfoDirty() : !pSPFStyle.isTemplInfoDirty()) {
            return null;
        }
        String string = pSPFStyle.getTemplInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TemplInfo_Default(pSPFStyle, bl2, bl3);
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

    protected EntityFieldError onCheckField_TemplPSPFStyleId(boolean bl, PSPFStyle pSPFStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFStyle.isTemplPSPFStyleIdDirty() : !pSPFStyle.isTemplPSPFStyleIdDirty()) {
            return null;
        }
        String string = pSPFStyle.getTemplPSPFStyleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TemplPSPFStyleId_TemplPSPFStyle(pSPFStyle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPLPSPFSTYLEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
            string2 = this.onTestValueRule_TemplPSPFStyleId_Default(pSPFStyle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPLPSPFSTYLEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TemplRootUrl(boolean bl, PSPFStyle pSPFStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFStyle.isTemplRootUrlDirty() : !pSPFStyle.isTemplRootUrlDirty()) {
            return null;
        }
        String string = pSPFStyle.getTemplRootUrl();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TemplRootUrl_Default(pSPFStyle, bl2, bl3);
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

    protected EntityFieldError onCheckField_TemplState(boolean bl, PSPFStyle pSPFStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFStyle.isTemplStateDirty() : !pSPFStyle.isTemplStateDirty()) {
            return null;
        }
        Integer n = pSPFStyle.getTemplState();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_TemplState_Default(pSPFStyle, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSPFStyle pSPFStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFStyle.isUserTagDirty() : !pSPFStyle.isUserTagDirty()) {
            return null;
        }
        String string = pSPFStyle.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSPFStyle, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSPFStyle pSPFStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFStyle.isUserTag2Dirty() : !pSPFStyle.isUserTag2Dirty()) {
            return null;
        }
        String string = pSPFStyle.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSPFStyle, bl2, bl3);
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

    protected EntityFieldError onCheckField_V2Folder(boolean bl, PSPFStyle pSPFStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFStyle.isV2FolderDirty() : !pSPFStyle.isV2FolderDirty()) {
            return null;
        }
        String string = pSPFStyle.getV2Folder();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_V2Folder_Default(pSPFStyle, bl2, bl3);
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

    protected EntityFieldError onCheckField_V2Folder2(boolean bl, PSPFStyle pSPFStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFStyle.isV2Folder2Dirty() : !pSPFStyle.isV2Folder2Dirty()) {
            return null;
        }
        String string = pSPFStyle.getV2Folder2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_V2Folder2_Default(pSPFStyle, bl2, bl3);
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

    protected EntityFieldError onCheckField_V2GitPath(boolean bl, PSPFStyle pSPFStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFStyle.isV2GitPathDirty() : !pSPFStyle.isV2GitPathDirty()) {
            return null;
        }
        String string = pSPFStyle.getV2GitPath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_V2GitPath_Default(pSPFStyle, bl2, bl3);
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

    protected EntityFieldError onCheckField_Version(boolean bl, PSPFStyle pSPFStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFStyle.isVersionDirty() : !pSPFStyle.isVersionDirty()) {
            return null;
        }
        Integer n = pSPFStyle.getVersion();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Version_Default(pSPFStyle, bl2, bl3);
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

    protected EntityFieldError onCheckField_VerStr(boolean bl, PSPFStyle pSPFStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFStyle.isVerStrDirty() : !pSPFStyle.isVerStrDirty()) {
            return null;
        }
        String string = pSPFStyle.getVerStr();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_VerStr_Default(pSPFStyle, bl2, bl3);
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

    protected void onSyncEntity(PSPFStyle pSPFStyle, boolean bl) throws Exception {
        super.onSyncEntity(pSPFStyle, bl);
    }

    protected void onSyncIndexEntities(PSPFStyle pSPFStyle, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSPFStyle, bl);
    }

    public Object getDataContextValue(PSPFStyle pSPFStyle, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSPFStyle, string, iDataContextParam)) != null) {
            return object;
        }
        PSPF pSPF = pSPFStyle.getPSPF();
        if (pSPF != null && pSPF.contains(string)) {
            return pSPF.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSPFStyle pSPFStyle, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSPFStyle, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"DCSTYLECODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DCStyleCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFAULTFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefaultFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNADEPSTYLEFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaDepStyleFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LASTESTFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LastestFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LASTIMPTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LastImpTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PFSTYLEPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PFStyleParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPTYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPTYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppTypeName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDEVSLNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnId_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PUBMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PubMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFRESHVER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefreshVer_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STYLECODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StyleCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STYLEENGINE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StyleEngine_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STYLERESURL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StyleResUrl_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplInfo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLPSPFSTYLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"TEMPLPSPFSTYLE", (boolean)true) == 0) {
            return this.onTestValueRule_TemplPSPFStyleId_TemplPSPFStyle(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLPSPFSTYLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplPSPFStyleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLPSPFSTYLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplPSPFStyleName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_DCStyleCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DCSTYLECODE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false) && this.checkFieldRegExRule("DCSTYLECODE", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DefaultFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DynaDepStyleFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LastestFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LastImpTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_PFStyleParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PFSTYLEPARAM", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppTypeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPTYPEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPTYPENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PubMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_RefreshVer_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_StyleCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STYLECODE", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_TemplFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_TemplPSPFStyleId_TemplPSPFStyle(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldDataSetRule("TEMPLPSPFSTYLEID", "PSPFSTYLE", DATASET_CURPF, iEntity, bl2, null, null, "\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d", true)) {
                return null;
            }
            return "\u7ee7\u627f\u6837\u5f0f\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TemplPSPFStyleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TEMPLPSPFSTYLEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TemplPSPFStyleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TEMPLPSPFSTYLENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSPFStyle pSPFStyle) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSPFStyle)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSPFStyle pSPFStyle) throws Exception {
        super.onUpdateParent(pSPFStyle);
    }

    protected void onCopyDetails(PSPFStyle pSPFStyle, Object object) throws Exception {
        Object object2;
        PSPFStyle pSPFStyle2 = new PSPFStyle();
        pSPFStyle2.set("PSPFSTYLEID", object);
        String string = DataObject.getStringValue((Object)pSPFStyle.get("PSPFSTYLEID"));
        PSPFViewTemplService viewTemplService = (PSPFViewTemplService)ServiceGlobal.getService(PSPFViewTemplService.class, (SessionFactory)this.getSessionFactory());
        for (PSPFViewTempl entityBase : viewTemplService.selectByPSPFStyle(pSPFStyle2)) {
            object2 = entityBase.get("PSPFVIEWTEMPLID");
            viewTemplService.getDraftFrom(entityBase);
            viewTemplService.fillParentInfo(entityBase, "DER1N", "DER1N_PSPFVIEWTEMPL_PSPFSTYLE_PSPFSTYLEID", string);
            viewTemplService.create(entityBase);
            viewTemplService.copyDetails(entityBase, object2);
        }
        PSPFStyleCodeService styleCodeService = (PSPFStyleCodeService)ServiceGlobal.getService(PSPFStyleCodeService.class, (SessionFactory)this.getSessionFactory());
        for (PSPFStyleCode entityBase : styleCodeService.selectByPSPFStyle(pSPFStyle2)) {
            object2 = entityBase.get("PSPFSTYLECODEID");
            styleCodeService.getDraftFrom(entityBase);
            styleCodeService.fillParentInfo(entityBase, "DER1N", "DER1N_PSPFSTYLECODE_PSPFSTYLE_PSPFSTYLEID", string);
            styleCodeService.create(entityBase);
            styleCodeService.copyDetails(entityBase, object2);
        }
        PSPFEditorTemplService editorTemplService = (PSPFEditorTemplService)ServiceGlobal.getService(PSPFEditorTemplService.class, (SessionFactory)this.getSessionFactory());
        for (PSPFEditorTempl entityBase : editorTemplService.selectByPSPFStyle(pSPFStyle2)) {
            object2 = entityBase.get("PSPFEDITORTEMPLID");
            editorTemplService.getDraftFrom(entityBase);
            editorTemplService.fillParentInfo(entityBase, "DER1N", "DER1N_PSPFEDITORTEMPL_PSPFSTYLE_PSPFSTYLEID", string);
            editorTemplService.create(entityBase);
            editorTemplService.copyDetails(entityBase, object2);
        }
        PSPFCtrlTemplService ctrlTemplService = (PSPFCtrlTemplService)ServiceGlobal.getService(PSPFCtrlTemplService.class, (SessionFactory)this.getSessionFactory());
        for (PSPFCtrlTempl entityBase : ctrlTemplService.selectByPSPFStyle(pSPFStyle2)) {
            object2 = entityBase.get("PSPFCTRLTEMPLID");
            ctrlTemplService.getDraftFrom(entityBase);
            ctrlTemplService.fillParentInfo(entityBase, "DER1N", "DER1N_PSPFCTRLTEMPL_PSPFSTYLE_PSPFSTYLEID", string);
            ctrlTemplService.create(entityBase);
            ctrlTemplService.copyDetails(entityBase, object2);
        }
        super.onCopyDetails(pSPFStyle, object);
    }

    @Override
    protected void exportCurXmlModel(PSPFStyle pSPFStyle, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSPFSTYLE");
        if (!bl) {
            pSPFStyle.setCreateDate(null);
            pSPFStyle.setCreateMan(null);
            pSPFStyle.setUpdateDate(null);
            pSPFStyle.setUpdateMan(null);
            pSPFStyle.setVersion(null);
            super.exportCurXmlModel(pSPFStyle, xmlNode, bl);
        }
    }
}
