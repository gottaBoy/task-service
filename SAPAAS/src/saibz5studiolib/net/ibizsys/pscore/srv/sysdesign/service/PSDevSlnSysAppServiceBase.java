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
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.sysdesign.service;

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
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.config.entity.PSAppType;
import net.ibizsys.pscore.srv.config.entity.PSAppTypeBase;
import net.ibizsys.pscore.srv.config.entity.PSPF;
import net.ibizsys.pscore.srv.config.entity.PSPFBase;
import net.ibizsys.pscore.srv.config.entity.PSPFStyle;
import net.ibizsys.pscore.srv.config.entity.PSPFStyleBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.sysdesign.dao.PSDevSlnSysAppDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnSysAppDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysAppBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepAppServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepFuncItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepFuncItemServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineStepService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineStepServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnTemplService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnTemplServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSStudioTheme;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSStudioThemeBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnSysAppServiceBase
extends PSCoreSysServiceBase<PSDevSlnSysApp> {
    private static final Log log = LogFactory.getLog(PSDevSlnSysAppServiceBase.class);
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_CURUSER = "CurUser";
    public static final String DATASET_CURUSER2 = "CurUser2";
    public static final String DATASET_CURUSER3 = "CurUser3";
    public static final String DATASET_CURUSER4 = "CurUser4";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDevSlnSysAppDEModel pSDevSlnSysAppDEModel;
    private PSDevSlnSysAppDAO pSDevSlnSysAppDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysAppService";
    }

    public PSDevSlnSysAppDEModel getPSDevSlnSysAppDEModel() {
        if (this.pSDevSlnSysAppDEModel == null) {
            try {
                this.pSDevSlnSysAppDEModel = (PSDevSlnSysAppDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnSysAppDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnSysAppDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDevSlnSysAppDEModel();
    }

    public PSDevSlnSysAppDAO getPSDevSlnSysAppDAO() {
        if (this.pSDevSlnSysAppDAO == null) {
            try {
                this.pSDevSlnSysAppDAO = (PSDevSlnSysAppDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSDevSlnSysAppDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnSysAppDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDevSlnSysAppDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchCurSys(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURUSER, (boolean)true) == 0) {
            return this.fetchCurUser(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURUSER2, (boolean)true) == 0) {
            return this.fetchCurUser2(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURUSER3, (boolean)true) == 0) {
            return this.fetchCurUser3(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURUSER4, (boolean)true) == 0) {
            return this.fetchCurUser4(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurSys(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYS, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurUser(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURUSER, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurUser2(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURUSER2, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurUser3(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURUSER3, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurUser4(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURUSER4, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSDevSlnSysApp pSDevSlnSysApp, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSAPP_PSAPPTYPE_PSAPPTYPEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSAppTypeService", (SessionFactory)this.getSessionFactory());
            PSAppType pSAppType = (PSAppType)iService.getDEModel().createEntity();
            pSAppType.set("PSAPPTYPEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSAppType);
            } else {
                iService.get(pSAppType);
            }
            this.onFillParentInfo_PSAppType(pSDevSlnSysApp, pSAppType);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSAPP_PSDEVSLNSYS_PSDEVSLNSYSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService", (SessionFactory)this.getSessionFactory());
            PSDevSlnSys pSDevSlnSys = (PSDevSlnSys)iService.getDEModel().createEntity();
            pSDevSlnSys.set("PSDEVSLNSYSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSlnSys);
            } else {
                iService.get(pSDevSlnSys);
            }
            this.onFillParentInfo_PSDevSlnSys(pSDevSlnSysApp, pSDevSlnSys);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSAPP_PSPFSTYLE_PSPFSTYLEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFStyleService", (SessionFactory)this.getSessionFactory());
            PSPFStyle pSPFStyle = (PSPFStyle)iService.getDEModel().createEntity();
            pSPFStyle.set("PSPFSTYLEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSPFStyle);
            } else {
                iService.get(pSPFStyle);
            }
            this.onFillParentInfo_PSPFStyle(pSDevSlnSysApp, pSPFStyle);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSAPP_PSPF_PSPFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFService", (SessionFactory)this.getSessionFactory());
            PSPF pSPF = (PSPF)iService.getDEModel().createEntity();
            pSPF.set("PSPFID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSPF);
            } else {
                iService.get(pSPF);
            }
            this.onFillParentInfo_PSPF(pSDevSlnSysApp, pSPF);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSAPP_PSSTUDIOTHEME_PSSTUDIOTHEMEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdevstudio.service.PSStudioThemeService", (SessionFactory)this.getSessionFactory());
            PSStudioTheme pSStudioTheme = (PSStudioTheme)iService.getDEModel().createEntity();
            pSStudioTheme.set("PSSTUDIOTHEMEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSStudioTheme);
            } else {
                iService.get(pSStudioTheme);
            }
            this.onFillParentInfo_PSStudioTheme(pSDevSlnSysApp, pSStudioTheme);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSAPP_PSSYSAPP_PSSYSAPPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService", (SessionFactory)this.getSessionFactory());
            PSSysApp pSSysApp = (PSSysApp)iService.getDEModel().createEntity();
            pSSysApp.set("PSSYSAPPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysApp);
            } else {
                iService.get(pSSysApp);
            }
            this.onFillParentInfo_PSSysApp(pSDevSlnSysApp, pSSysApp);
            return;
        }
        super.onFillParentInfo(pSDevSlnSysApp, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSAppType(PSDevSlnSysApp pSDevSlnSysApp, PSAppType pSAppType) throws Exception {
        pSDevSlnSysApp.setPSAppTypeId(pSAppType.getPSAppTypeId());
        pSDevSlnSysApp.setPSAppTypeName(pSAppType.getPSAppTypeName());
    }

    protected void onFillParentInfo_PSDevSlnSys(PSDevSlnSysApp pSDevSlnSysApp, PSDevSlnSys pSDevSlnSys) throws Exception {
        pSDevSlnSysApp.setDevSysState(pSDevSlnSys.getDevSysState());
        pSDevSlnSysApp.setPSDevSlnId(pSDevSlnSys.getPSDevSlnId());
        pSDevSlnSysApp.setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
        pSDevSlnSysApp.setPSDevSlnSysName(pSDevSlnSys.getPSDevSlnSysName());
    }

    protected void onFillParentInfo_PSPFStyle(PSDevSlnSysApp pSDevSlnSysApp, PSPFStyle pSPFStyle) throws Exception {
        pSDevSlnSysApp.setPSPFStyleId(pSPFStyle.getPSPFStyleId());
        pSDevSlnSysApp.setPSPFStyleName(pSPFStyle.getPSPFStyleName());
    }

    protected void onFillParentInfo_PSPF(PSDevSlnSysApp pSDevSlnSysApp, PSPF pSPF) throws Exception {
        pSDevSlnSysApp.setPSPFId(pSPF.getPSPFId());
        pSDevSlnSysApp.setPSPFName(pSPF.getPSPFName());
    }

    protected void onFillParentInfo_PSStudioTheme(PSDevSlnSysApp pSDevSlnSysApp, PSStudioTheme pSStudioTheme) throws Exception {
        pSDevSlnSysApp.setPSStudioThemeId(pSStudioTheme.getPSStudioThemeId());
        pSDevSlnSysApp.setPSStudioThemeName(pSStudioTheme.getPSStudioThemeName());
        pSDevSlnSysApp.setThemeCssStyle(pSStudioTheme.getCardCssStyle());
    }

    protected void onFillParentInfo_PSSysApp(PSDevSlnSysApp pSDevSlnSysApp, PSSysApp pSSysApp) throws Exception {
        pSDevSlnSysApp.setPSSysAppId(pSSysApp.getPSSysAppId());
        pSDevSlnSysApp.setPSSysAppName(pSSysApp.getPSSysAppName());
    }

    protected boolean onFillEntityKeyValue(PSDevSlnSysApp pSDevSlnSysApp, boolean bl) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        Object object = pSDevSlnSysApp.get("PSDEVSLNSYSID");
        if (object == null) {
            object = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object);
        stringBuilderEx.append("||");
        Object object2 = pSDevSlnSysApp.get("PSSYSAPPID");
        if (object2 == null) {
            object2 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object2);
        String string = stringBuilderEx.toString();
        pSDevSlnSysApp.set(this.getPSDevSlnSysAppDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId((String)string));
        return true;
    }

    protected void onFillEntityFullInfo(PSDevSlnSysApp pSDevSlnSysApp, boolean bl) throws Exception {
        if (bl && pSDevSlnSysApp.getValidFlag() == null) {
            pSDevSlnSysApp.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSDevSlnSysApp, bl);
        this.onFillEntityFullInfo_PSAppType(pSDevSlnSysApp, bl);
        this.onFillEntityFullInfo_PSDevSlnSys(pSDevSlnSysApp, bl);
        this.onFillEntityFullInfo_PSPFStyle(pSDevSlnSysApp, bl);
        this.onFillEntityFullInfo_PSPF(pSDevSlnSysApp, bl);
        this.onFillEntityFullInfo_PSStudioTheme(pSDevSlnSysApp, bl);
        this.onFillEntityFullInfo_PSSysApp(pSDevSlnSysApp, bl);
    }

    protected void onFillEntityFullInfo_PSAppType(PSDevSlnSysApp pSDevSlnSysApp, boolean bl) throws Exception {
        if (pSDevSlnSysApp.isPSAppTypeIdDirty()) {
            if (pSDevSlnSysApp.getPSAppTypeId() != null) {
                if (pSDevSlnSysApp.getPSAppTypeId() == null || pSDevSlnSysApp.getPSAppTypeName() == null) {
                    PSAppType pSAppType = pSDevSlnSysApp.getPSAppType();
                    pSDevSlnSysApp.setPSAppTypeName(pSAppType.getPSAppTypeName());
                }
            } else {
                pSDevSlnSysApp.setPSAppTypeName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDevSlnSys(PSDevSlnSysApp pSDevSlnSysApp, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSPFStyle(PSDevSlnSysApp pSDevSlnSysApp, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSPF(PSDevSlnSysApp pSDevSlnSysApp, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSStudioTheme(PSDevSlnSysApp pSDevSlnSysApp, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysApp(PSDevSlnSysApp pSDevSlnSysApp, boolean bl) throws Exception {
        if (pSDevSlnSysApp.isPSSysAppIdDirty()) {
            if (pSDevSlnSysApp.getPSSysAppId() != null) {
                if (pSDevSlnSysApp.getPSSysAppId() == null || pSDevSlnSysApp.getPSSysAppName() == null) {
                    PSSysApp pSSysApp = pSDevSlnSysApp.getPSSysApp();
                    pSDevSlnSysApp.setPSSysAppName(pSSysApp.getPSSysAppName());
                }
            } else {
                pSDevSlnSysApp.setPSSysAppName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDevSlnSysApp pSDevSlnSysApp, boolean bl) throws Exception {
        super.onWriteBackParent(pSDevSlnSysApp, bl);
    }

    public ArrayList<PSDevSlnSysApp> selectByPSAppType(PSAppTypeBase pSAppTypeBase) throws Exception {
        return this.selectByPSAppType(pSAppTypeBase, "", -1);
    }

    public ArrayList<PSDevSlnSysApp> selectByPSAppType(PSAppTypeBase pSAppTypeBase, String string) throws Exception {
        return this.selectByPSAppType(pSAppTypeBase, string, -1);
    }

    public ArrayList<PSDevSlnSysApp> selectByPSAppType(PSAppTypeBase pSAppTypeBase, String string, int n) throws Exception {
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

    public ArrayList<PSDevSlnSysApp> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase) throws Exception {
        return this.selectByPSDevSlnSys(pSDevSlnSysBase, "", -1);
    }

    public ArrayList<PSDevSlnSysApp> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase, String string) throws Exception {
        return this.selectByPSDevSlnSys(pSDevSlnSysBase, string, -1);
    }

    public ArrayList<PSDevSlnSysApp> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase, String string, int n) throws Exception {
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

    public ArrayList<PSDevSlnSysApp> selectByPSPFStyle(PSPFStyleBase pSPFStyleBase) throws Exception {
        return this.selectByPSPFStyle(pSPFStyleBase, "", -1);
    }

    public ArrayList<PSDevSlnSysApp> selectByPSPFStyle(PSPFStyleBase pSPFStyleBase, String string) throws Exception {
        return this.selectByPSPFStyle(pSPFStyleBase, string, -1);
    }

    public ArrayList<PSDevSlnSysApp> selectByPSPFStyle(PSPFStyleBase pSPFStyleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSPFSTYLEID", (Object)pSPFStyleBase.getPSPFStyleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSPFStyleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSPFStyleCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSysApp> selectByPSPF(PSPFBase pSPFBase) throws Exception {
        return this.selectByPSPF(pSPFBase, "", -1);
    }

    public ArrayList<PSDevSlnSysApp> selectByPSPF(PSPFBase pSPFBase, String string) throws Exception {
        return this.selectByPSPF(pSPFBase, string, -1);
    }

    public ArrayList<PSDevSlnSysApp> selectByPSPF(PSPFBase pSPFBase, String string, int n) throws Exception {
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

    public ArrayList<PSDevSlnSysApp> selectByPSStudioTheme(PSStudioThemeBase pSStudioThemeBase) throws Exception {
        return this.selectByPSStudioTheme(pSStudioThemeBase, "", -1);
    }

    public ArrayList<PSDevSlnSysApp> selectByPSStudioTheme(PSStudioThemeBase pSStudioThemeBase, String string) throws Exception {
        return this.selectByPSStudioTheme(pSStudioThemeBase, string, -1);
    }

    public ArrayList<PSDevSlnSysApp> selectByPSStudioTheme(PSStudioThemeBase pSStudioThemeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSTUDIOTHEMEID", (Object)pSStudioThemeBase.getPSStudioThemeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSStudioThemeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSStudioThemeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSysApp> selectByPSSysApp(PSSysAppBase pSSysAppBase) throws Exception {
        return this.selectByPSSysApp(pSSysAppBase, "", -1);
    }

    public ArrayList<PSDevSlnSysApp> selectByPSSysApp(PSSysAppBase pSSysAppBase, String string) throws Exception {
        return this.selectByPSSysApp(pSSysAppBase, string, -1);
    }

    public ArrayList<PSDevSlnSysApp> selectByPSSysApp(PSSysAppBase pSSysAppBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSAPPID", (Object)pSSysAppBase.getPSSysAppId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysAppCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysAppCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSAppType(PSAppType pSAppType) throws Exception {
        ArrayList<PSDevSlnSysApp> arrayList = this.selectByPSAppType(pSAppType, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSAPPTYPE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSAppType);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYSAPP_PSAPPTYPE_PSAPPTYPEID", "", iDataEntityModel.getName(), "PSDEVSLNSYSAPP", iDataEntityModel.getDataInfo(pSAppType), arrayList.get(0)));
        }
    }

    public void resetPSAppType(PSAppType pSAppType) throws Exception {
        ArrayList<PSDevSlnSysApp> arrayList = this.selectByPSAppType(pSAppType);
        for (PSDevSlnSysApp pSDevSlnSysApp : arrayList) {
            PSDevSlnSysApp pSDevSlnSysApp2 = (PSDevSlnSysApp)this.getDEModel().createEntity();
            pSDevSlnSysApp2.setPSDevSlnSysAppId(pSDevSlnSysApp.getPSDevSlnSysAppId());
            pSDevSlnSysApp2.setPSAppTypeId(null);
            this.update(pSDevSlnSysApp2);
        }
    }

    public void removeByPSAppType(PSAppType pSAppType) throws Exception {
        final PSAppType pSAppType2 = pSAppType;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysAppServiceBase.this.onBeforeRemoveByPSAppType(pSAppType2);
                PSDevSlnSysAppServiceBase.this.internalRemoveByPSAppType(pSAppType2);
                PSDevSlnSysAppServiceBase.this.onAfterRemoveByPSAppType(pSAppType2);
            }
        });
    }

    protected void onBeforeRemoveByPSAppType(PSAppType pSAppType) throws Exception {
    }

    protected void internalRemoveByPSAppType(PSAppType pSAppType) throws Exception {
        ArrayList<PSDevSlnSysApp> arrayList = this.selectByPSAppType(pSAppType);
        this.onBeforeRemoveByPSAppType(pSAppType, arrayList);
        for (PSDevSlnSysApp pSDevSlnSysApp : arrayList) {
            this.remove(pSDevSlnSysApp);
        }
        this.onAfterRemoveByPSAppType(pSAppType, arrayList);
    }

    protected void onAfterRemoveByPSAppType(PSAppType pSAppType) throws Exception {
    }

    protected void onBeforeRemoveByPSAppType(PSAppType pSAppType, ArrayList<PSDevSlnSysApp> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSAppType(PSAppType pSAppType, ArrayList<PSDevSlnSysApp> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSlnSysApp> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLNSYS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevSlnSys);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYSAPP_PSDEVSLNSYS_PSDEVSLNSYSID", "", iDataEntityModel.getName(), "PSDEVSLNSYSAPP", iDataEntityModel.getDataInfo(pSDevSlnSys), arrayList.get(0)));
        }
    }

    public void resetPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSlnSysApp> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys);
        for (PSDevSlnSysApp pSDevSlnSysApp : arrayList) {
            PSDevSlnSysApp pSDevSlnSysApp2 = (PSDevSlnSysApp)this.getDEModel().createEntity();
            pSDevSlnSysApp2.setPSDevSlnSysAppId(pSDevSlnSysApp.getPSDevSlnSysAppId());
            pSDevSlnSysApp2.setPSDevSlnSysId(null);
            this.update(pSDevSlnSysApp2);
        }
    }

    public void removeByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        final PSDevSlnSys pSDevSlnSys2 = pSDevSlnSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysAppServiceBase.this.onBeforeRemoveByPSDevSlnSys(pSDevSlnSys2);
                PSDevSlnSysAppServiceBase.this.internalRemoveByPSDevSlnSys(pSDevSlnSys2);
                PSDevSlnSysAppServiceBase.this.onAfterRemoveByPSDevSlnSys(pSDevSlnSys2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    protected void internalRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSlnSysApp> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys);
        this.onBeforeRemoveByPSDevSlnSys(pSDevSlnSys, arrayList);
        for (PSDevSlnSysApp pSDevSlnSysApp : arrayList) {
            this.remove(pSDevSlnSysApp);
        }
        this.onAfterRemoveByPSDevSlnSys(pSDevSlnSys, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys, ArrayList<PSDevSlnSysApp> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys, ArrayList<PSDevSlnSysApp> arrayList) throws Exception {
    }

    public void testRemoveByPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
        ArrayList<PSDevSlnSysApp> arrayList = this.selectByPSPFStyle(pSPFStyle, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSPFSTYLE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSPFStyle);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYSAPP_PSPFSTYLE_PSPFSTYLEID", "", iDataEntityModel.getName(), "PSDEVSLNSYSAPP", iDataEntityModel.getDataInfo(pSPFStyle), arrayList.get(0)));
        }
    }

    public void resetPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
        ArrayList<PSDevSlnSysApp> arrayList = this.selectByPSPFStyle(pSPFStyle);
        for (PSDevSlnSysApp pSDevSlnSysApp : arrayList) {
            PSDevSlnSysApp pSDevSlnSysApp2 = (PSDevSlnSysApp)this.getDEModel().createEntity();
            pSDevSlnSysApp2.setPSDevSlnSysAppId(pSDevSlnSysApp.getPSDevSlnSysAppId());
            pSDevSlnSysApp2.setPSPFStyleId(null);
            this.update(pSDevSlnSysApp2);
        }
    }

    public void removeByPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
        final PSPFStyle pSPFStyle2 = pSPFStyle;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysAppServiceBase.this.onBeforeRemoveByPSPFStyle(pSPFStyle2);
                PSDevSlnSysAppServiceBase.this.internalRemoveByPSPFStyle(pSPFStyle2);
                PSDevSlnSysAppServiceBase.this.onAfterRemoveByPSPFStyle(pSPFStyle2);
            }
        });
    }

    protected void onBeforeRemoveByPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
    }

    protected void internalRemoveByPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
        ArrayList<PSDevSlnSysApp> arrayList = this.selectByPSPFStyle(pSPFStyle);
        this.onBeforeRemoveByPSPFStyle(pSPFStyle, arrayList);
        for (PSDevSlnSysApp pSDevSlnSysApp : arrayList) {
            this.remove(pSDevSlnSysApp);
        }
        this.onAfterRemoveByPSPFStyle(pSPFStyle, arrayList);
    }

    protected void onAfterRemoveByPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
    }

    protected void onBeforeRemoveByPSPFStyle(PSPFStyle pSPFStyle, ArrayList<PSDevSlnSysApp> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSPFStyle(PSPFStyle pSPFStyle, ArrayList<PSDevSlnSysApp> arrayList) throws Exception {
    }

    public void testRemoveByPSPF(PSPF pSPF) throws Exception {
        ArrayList<PSDevSlnSysApp> arrayList = this.selectByPSPF(pSPF, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSPF");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSPF);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYSAPP_PSPF_PSPFID", "", iDataEntityModel.getName(), "PSDEVSLNSYSAPP", iDataEntityModel.getDataInfo(pSPF), arrayList.get(0)));
        }
    }

    public void resetPSPF(PSPF pSPF) throws Exception {
        ArrayList<PSDevSlnSysApp> arrayList = this.selectByPSPF(pSPF);
        for (PSDevSlnSysApp pSDevSlnSysApp : arrayList) {
            PSDevSlnSysApp pSDevSlnSysApp2 = (PSDevSlnSysApp)this.getDEModel().createEntity();
            pSDevSlnSysApp2.setPSDevSlnSysAppId(pSDevSlnSysApp.getPSDevSlnSysAppId());
            pSDevSlnSysApp2.setPSPFId(null);
            this.update(pSDevSlnSysApp2);
        }
    }

    public void removeByPSPF(PSPF pSPF) throws Exception {
        final PSPF pSPF2 = pSPF;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysAppServiceBase.this.onBeforeRemoveByPSPF(pSPF2);
                PSDevSlnSysAppServiceBase.this.internalRemoveByPSPF(pSPF2);
                PSDevSlnSysAppServiceBase.this.onAfterRemoveByPSPF(pSPF2);
            }
        });
    }

    protected void onBeforeRemoveByPSPF(PSPF pSPF) throws Exception {
    }

    protected void internalRemoveByPSPF(PSPF pSPF) throws Exception {
        ArrayList<PSDevSlnSysApp> arrayList = this.selectByPSPF(pSPF);
        this.onBeforeRemoveByPSPF(pSPF, arrayList);
        for (PSDevSlnSysApp pSDevSlnSysApp : arrayList) {
            this.remove(pSDevSlnSysApp);
        }
        this.onAfterRemoveByPSPF(pSPF, arrayList);
    }

    protected void onAfterRemoveByPSPF(PSPF pSPF) throws Exception {
    }

    protected void onBeforeRemoveByPSPF(PSPF pSPF, ArrayList<PSDevSlnSysApp> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSPF(PSPF pSPF, ArrayList<PSDevSlnSysApp> arrayList) throws Exception {
    }

    public void testRemoveByPSStudioTheme(PSStudioTheme pSStudioTheme) throws Exception {
    }

    public void resetPSStudioTheme(PSStudioTheme pSStudioTheme) throws Exception {
        ArrayList<PSDevSlnSysApp> arrayList = this.selectByPSStudioTheme(pSStudioTheme);
        for (PSDevSlnSysApp pSDevSlnSysApp : arrayList) {
            PSDevSlnSysApp pSDevSlnSysApp2 = (PSDevSlnSysApp)this.getDEModel().createEntity();
            pSDevSlnSysApp2.setPSDevSlnSysAppId(pSDevSlnSysApp.getPSDevSlnSysAppId());
            pSDevSlnSysApp2.setPSStudioThemeId(null);
            this.update(pSDevSlnSysApp2);
        }
    }

    public void removeByPSStudioTheme(PSStudioTheme pSStudioTheme) throws Exception {
        final PSStudioTheme pSStudioTheme2 = pSStudioTheme;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysAppServiceBase.this.onBeforeRemoveByPSStudioTheme(pSStudioTheme2);
                PSDevSlnSysAppServiceBase.this.internalRemoveByPSStudioTheme(pSStudioTheme2);
                PSDevSlnSysAppServiceBase.this.onAfterRemoveByPSStudioTheme(pSStudioTheme2);
            }
        });
    }

    protected void onBeforeRemoveByPSStudioTheme(PSStudioTheme pSStudioTheme) throws Exception {
    }

    protected void internalRemoveByPSStudioTheme(PSStudioTheme pSStudioTheme) throws Exception {
        ArrayList<PSDevSlnSysApp> arrayList = this.selectByPSStudioTheme(pSStudioTheme);
        this.onBeforeRemoveByPSStudioTheme(pSStudioTheme, arrayList);
        for (PSDevSlnSysApp pSDevSlnSysApp : arrayList) {
            this.remove(pSDevSlnSysApp);
        }
        this.onAfterRemoveByPSStudioTheme(pSStudioTheme, arrayList);
    }

    protected void onAfterRemoveByPSStudioTheme(PSStudioTheme pSStudioTheme) throws Exception {
    }

    protected void onBeforeRemoveByPSStudioTheme(PSStudioTheme pSStudioTheme, ArrayList<PSDevSlnSysApp> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSStudioTheme(PSStudioTheme pSStudioTheme, ArrayList<PSDevSlnSysApp> arrayList) throws Exception {
    }

    public void testRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    public void resetPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSDevSlnSysApp> arrayList = this.selectByPSSysApp(pSSysApp);
        for (PSDevSlnSysApp pSDevSlnSysApp : arrayList) {
            PSDevSlnSysApp pSDevSlnSysApp2 = (PSDevSlnSysApp)this.getDEModel().createEntity();
            pSDevSlnSysApp2.setPSDevSlnSysAppId(pSDevSlnSysApp.getPSDevSlnSysAppId());
            pSDevSlnSysApp2.setPSSysAppId(null);
            this.update(pSDevSlnSysApp2);
        }
    }

    public void removeByPSSysApp(PSSysApp pSSysApp) throws Exception {
        final PSSysApp pSSysApp2 = pSSysApp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysAppServiceBase.this.onBeforeRemoveByPSSysApp(pSSysApp2);
                PSDevSlnSysAppServiceBase.this.internalRemoveByPSSysApp(pSSysApp2);
                PSDevSlnSysAppServiceBase.this.onAfterRemoveByPSSysApp(pSSysApp2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    protected void internalRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSDevSlnSysApp> arrayList = this.selectByPSSysApp(pSSysApp);
        this.onBeforeRemoveByPSSysApp(pSSysApp, arrayList);
        for (PSDevSlnSysApp pSDevSlnSysApp : arrayList) {
            this.remove(pSDevSlnSysApp);
        }
        this.onAfterRemoveByPSSysApp(pSSysApp, arrayList);
    }

    protected void onAfterRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    protected void onBeforeRemoveByPSSysApp(PSSysApp pSSysApp, ArrayList<PSDevSlnSysApp> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysApp(PSSysApp pSSysApp, ArrayList<PSDevSlnSysApp> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDevSlnSysApp pSDevSlnSysApp) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDevSlnMSDepAppService)ServiceGlobal.getService(PSDevSlnMSDepAppService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnMSDepAppServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSlnSysApp(pSDevSlnSysApp);
        ((PSDevSlnMSDepAppServiceBase)pSCoreSysServiceBase).removeByPSDevSlnSysApp(pSDevSlnSysApp);
        pSCoreSysServiceBase = (PSDevSlnMSDepFuncItemService)ServiceGlobal.getService(PSDevSlnMSDepFuncItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnMSDepFuncItemServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSlnSysApp(pSDevSlnSysApp);
        pSCoreSysServiceBase = (PSDevSlnPipelineStepService)ServiceGlobal.getService(PSDevSlnPipelineStepService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnPipelineStepServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSlnSysApp(pSDevSlnSysApp);
        pSCoreSysServiceBase = (PSDevSlnTemplService)ServiceGlobal.getService(PSDevSlnTemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnTemplServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSlnSysApp(pSDevSlnSysApp);
        super.onBeforeRemove(pSDevSlnSysApp);
    }

    protected void replaceParentInfo(PSDevSlnSysApp pSDevSlnSysApp, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDevSlnSysApp, cloneSession);
        if (pSDevSlnSysApp.getPSAppTypeId() != null && (iEntity = cloneSession.getEntity("PSAPPTYPE", (Object)pSDevSlnSysApp.getPSAppTypeId())) != null) {
            this.onFillParentInfo_PSAppType(pSDevSlnSysApp, (PSAppType)iEntity);
        }
        if (pSDevSlnSysApp.getPSDevSlnSysId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNSYS", (Object)pSDevSlnSysApp.getPSDevSlnSysId())) != null) {
            this.onFillParentInfo_PSDevSlnSys(pSDevSlnSysApp, (PSDevSlnSys)iEntity);
        }
        if (pSDevSlnSysApp.getPSPFStyleId() != null && (iEntity = cloneSession.getEntity("PSPFSTYLE", (Object)pSDevSlnSysApp.getPSPFStyleId())) != null) {
            this.onFillParentInfo_PSPFStyle(pSDevSlnSysApp, (PSPFStyle)iEntity);
        }
        if (pSDevSlnSysApp.getPSPFId() != null && (iEntity = cloneSession.getEntity("PSPF", (Object)pSDevSlnSysApp.getPSPFId())) != null) {
            this.onFillParentInfo_PSPF(pSDevSlnSysApp, (PSPF)iEntity);
        }
        if (pSDevSlnSysApp.getPSStudioThemeId() != null && (iEntity = cloneSession.getEntity("PSSTUDIOTHEME", (Object)pSDevSlnSysApp.getPSStudioThemeId())) != null) {
            this.onFillParentInfo_PSStudioTheme(pSDevSlnSysApp, (PSStudioTheme)iEntity);
        }
        if (pSDevSlnSysApp.getPSSysAppId() != null && (iEntity = cloneSession.getEntity("PSSYSAPP", (Object)pSDevSlnSysApp.getPSSysAppId())) != null) {
            this.onFillParentInfo_PSSysApp(pSDevSlnSysApp, (PSSysApp)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDevSlnSysApp pSDevSlnSysApp, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDevSlnSysApp, bl);
    }

    protected void onCheckEntity(boolean bl, PSDevSlnSysApp pSDevSlnSysApp, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AppMDUrl(bl, pSDevSlnSysApp, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AppMode(bl, pSDevSlnSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AppPKGName(bl, pSDevSlnSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AppSN(bl, pSDevSlnSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AppTag(bl, pSDevSlnSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AppTag2(bl, pSDevSlnSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AppTag3(bl, pSDevSlnSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AppTag4(bl, pSDevSlnSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicName(bl, pSDevSlnSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDevSlnSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppTypeId(bl, pSDevSlnSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppTypeName(bl, pSDevSlnSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysAppId(bl, pSDevSlnSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysAppName(bl, pSDevSlnSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysId(bl, pSDevSlnSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFId(bl, pSDevSlnSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFStyleId(bl, pSDevSlnSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSStudioThemeId(bl, pSDevSlnSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAppId(bl, pSDevSlnSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAppName(bl, pSDevSlnSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDevSlnSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDevSlnSysApp, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AppMDUrl(boolean bl, PSDevSlnSysApp pSDevSlnSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysApp.isAppMDUrlDirty() : !pSDevSlnSysApp.isAppMDUrlDirty()) {
            return null;
        }
        String string = pSDevSlnSysApp.getAppMDUrl();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AppMDUrl_Default(pSDevSlnSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("APPMDURL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AppMode(boolean bl, PSDevSlnSysApp pSDevSlnSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysApp.isAppModeDirty() : !pSDevSlnSysApp.isAppModeDirty()) {
            return null;
        }
        String string = pSDevSlnSysApp.getAppMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AppMode_Default(pSDevSlnSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("APPMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AppPKGName(boolean bl, PSDevSlnSysApp pSDevSlnSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysApp.isAppPKGNameDirty() : !pSDevSlnSysApp.isAppPKGNameDirty()) {
            return null;
        }
        String string = pSDevSlnSysApp.getAppPKGName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AppPKGName_Default(pSDevSlnSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("APPPKGNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AppSN(boolean bl, PSDevSlnSysApp pSDevSlnSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysApp.isAppSNDirty() : !pSDevSlnSysApp.isAppSNDirty()) {
            return null;
        }
        String string = pSDevSlnSysApp.getAppSN();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AppSN_Default(pSDevSlnSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("APPSN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AppTag(boolean bl, PSDevSlnSysApp pSDevSlnSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysApp.isAppTagDirty() : !pSDevSlnSysApp.isAppTagDirty()) {
            return null;
        }
        String string = pSDevSlnSysApp.getAppTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AppTag_Default(pSDevSlnSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("APPTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AppTag2(boolean bl, PSDevSlnSysApp pSDevSlnSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysApp.isAppTag2Dirty() : !pSDevSlnSysApp.isAppTag2Dirty()) {
            return null;
        }
        String string = pSDevSlnSysApp.getAppTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AppTag2_Default(pSDevSlnSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("APPTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AppTag3(boolean bl, PSDevSlnSysApp pSDevSlnSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysApp.isAppTag3Dirty() : !pSDevSlnSysApp.isAppTag3Dirty()) {
            return null;
        }
        String string = pSDevSlnSysApp.getAppTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AppTag3_Default(pSDevSlnSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("APPTAG3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AppTag4(boolean bl, PSDevSlnSysApp pSDevSlnSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysApp.isAppTag4Dirty() : !pSDevSlnSysApp.isAppTag4Dirty()) {
            return null;
        }
        String string = pSDevSlnSysApp.getAppTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AppTag4_Default(pSDevSlnSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("APPTAG4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LogicName(boolean bl, PSDevSlnSysApp pSDevSlnSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysApp.isLogicNameDirty() : !pSDevSlnSysApp.isLogicNameDirty()) {
            return null;
        }
        String string = pSDevSlnSysApp.getLogicName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicName_Default(pSDevSlnSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGICNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDevSlnSysApp pSDevSlnSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysApp.isMemoDirty() : !pSDevSlnSysApp.isMemoDirty()) {
            return null;
        }
        String string = pSDevSlnSysApp.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDevSlnSysApp, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSAppTypeId(boolean bl, PSDevSlnSysApp pSDevSlnSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysApp.isPSAppTypeIdDirty() : !pSDevSlnSysApp.isPSAppTypeIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysApp.getPSAppTypeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppTypeId_Default(pSDevSlnSysApp, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSAppTypeName(boolean bl, PSDevSlnSysApp pSDevSlnSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysApp.isPSAppTypeNameDirty() : !pSDevSlnSysApp.isPSAppTypeNameDirty()) {
            return null;
        }
        String string = pSDevSlnSysApp.getPSAppTypeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppTypeName_Default(pSDevSlnSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPTYPENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnSysAppId(boolean bl, PSDevSlnSysApp pSDevSlnSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysApp.isPSDevSlnSysAppIdDirty() && !bl2 : !pSDevSlnSysApp.isPSDevSlnSysAppIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysApp.getPSDevSlnSysAppId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSAPPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysAppId_Default(pSDevSlnSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSAPPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnSysAppName(boolean bl, PSDevSlnSysApp pSDevSlnSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysApp.isPSDevSlnSysAppNameDirty() && !bl2 : !pSDevSlnSysApp.isPSDevSlnSysAppNameDirty()) {
            return null;
        }
        String string = pSDevSlnSysApp.getPSDevSlnSysAppName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSAPPNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysAppName_Default(pSDevSlnSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSAPPNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnSysId(boolean bl, PSDevSlnSysApp pSDevSlnSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysApp.isPSDevSlnSysIdDirty() && !bl2 : !pSDevSlnSysApp.isPSDevSlnSysIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysApp.getPSDevSlnSysId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysId_Default(pSDevSlnSysApp, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSPFId(boolean bl, PSDevSlnSysApp pSDevSlnSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysApp.isPSPFIdDirty() : !pSDevSlnSysApp.isPSPFIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysApp.getPSPFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFId_Default(pSDevSlnSysApp, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSPFStyleId(boolean bl, PSDevSlnSysApp pSDevSlnSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysApp.isPSPFStyleIdDirty() : !pSDevSlnSysApp.isPSPFStyleIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysApp.getPSPFStyleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFStyleId_Default(pSDevSlnSysApp, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSStudioThemeId(boolean bl, PSDevSlnSysApp pSDevSlnSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysApp.isPSStudioThemeIdDirty() : !pSDevSlnSysApp.isPSStudioThemeIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysApp.getPSStudioThemeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSStudioThemeId_Default(pSDevSlnSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSTUDIOTHEMEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysAppId(boolean bl, PSDevSlnSysApp pSDevSlnSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysApp.isPSSysAppIdDirty() && !bl2 : !pSDevSlnSysApp.isPSSysAppIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysApp.getPSSysAppId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAPPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAppId_Default(pSDevSlnSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAPPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysAppName(boolean bl, PSDevSlnSysApp pSDevSlnSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysApp.isPSSysAppNameDirty() && !bl2 : !pSDevSlnSysApp.isPSSysAppNameDirty()) {
            return null;
        }
        String string = pSDevSlnSysApp.getPSSysAppName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAPPNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAppName_Default(pSDevSlnSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAPPNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDevSlnSysApp pSDevSlnSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysApp.isValidFlagDirty() : !pSDevSlnSysApp.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDevSlnSysApp.getValidFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSDevSlnSysApp, bl2, bl3);
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

    protected void onSyncEntity(PSDevSlnSysApp pSDevSlnSysApp, boolean bl) throws Exception {
        super.onSyncEntity(pSDevSlnSysApp, bl);
    }

    protected void onSyncIndexEntities(PSDevSlnSysApp pSDevSlnSysApp, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDevSlnSysApp, bl);
    }

    public Object getDataContextValue(PSDevSlnSysApp pSDevSlnSysApp, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDevSlnSysApp, string, iDataContextParam)) != null) {
            return object;
        }
        PSDevSlnSys pSDevSlnSys = pSDevSlnSysApp.getPSDevSlnSys();
        if (pSDevSlnSys != null && pSDevSlnSys.contains(string)) {
            return pSDevSlnSys.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDevSlnSysApp pSDevSlnSysApp, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDevSlnSysApp, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"APPMDURL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AppMDUrl_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"APPMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AppMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"APPPKGNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AppPKGName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"APPSN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AppSN_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"APPTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AppTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"APPTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AppTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"APPTAG3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AppTag3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"APPTAG4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AppTag4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEVSYSSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DevSysState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPTYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPTYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysAppId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSAPPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysAppName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSTUDIOTHEMEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSStudioThemeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSTUDIOTHEMENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSStudioThemeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAPPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"THEMECSSSTYLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ThemeCssStyle_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_AppMDUrl_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("APPMDURL", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AppMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("APPMODE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AppPKGName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("APPPKGNAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AppSN_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("APPSN", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AppTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("APPTAG", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AppTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("APPTAG2", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AppTag3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("APPTAG3", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AppTag4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("APPTAG4", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
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

    protected String onTestValueRule_DevSysState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOGICNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_PSDevSlnSysAppId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSAPPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysAppName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSAPPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSStudioThemeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSTUDIOTHEMEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSStudioThemeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSTUDIOTHEMENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysAppId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSAPPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysAppName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSAPPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ThemeCssStyle_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("THEMECSSSTYLE", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
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

    protected boolean onMergeChild(String string, String string2, PSDevSlnSysApp pSDevSlnSysApp) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDevSlnSysApp)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDevSlnSysApp pSDevSlnSysApp) throws Exception {
        super.onUpdateParent(pSDevSlnSysApp);
    }

    @Override
    protected void exportCurXmlModel(PSDevSlnSysApp pSDevSlnSysApp, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEVSLNSYSAPP");
        if (!bl) {
            pSDevSlnSysApp.setCreateDate(null);
            pSDevSlnSysApp.setCreateMan(null);
            pSDevSlnSysApp.setPSDevSlnSysAppId(null);
            pSDevSlnSysApp.setPSDevSlnSysName(null);
            pSDevSlnSysApp.setPSPFName(null);
            pSDevSlnSysApp.setPSPFStyleName(null);
            pSDevSlnSysApp.setPSStudioThemeName(null);
            pSDevSlnSysApp.setUpdateDate(null);
            pSDevSlnSysApp.setUpdateMan(null);
            super.exportCurXmlModel(pSDevSlnSysApp, xmlNode, bl);
        }
    }

    @Override
    protected String getEntityFolderKeyValue(PSDevSlnSysApp pSDevSlnSysApp, PSSystem pSSystem) throws Exception {
        PSDevSlnSysApp pSDevSlnSysApp2 = new PSDevSlnSysApp();
        pSDevSlnSysApp2.setPSDevSlnSysId(pSDevSlnSysApp.getPSDevSlnSysId());
        pSDevSlnSysApp2.setPSSysAppId(pSDevSlnSysApp.getPSSysAppId());
        if (this.selectOne(pSDevSlnSysApp2, true)) {
            return pSDevSlnSysApp2.getPSDevSlnSysAppId();
        }
        return super.getEntityFolderKeyValue(pSDevSlnSysApp, pSSystem);
    }
}

