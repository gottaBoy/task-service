/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.hibernate.Transaction
 */
package net.ibizsys.paas.service;

import java.lang.reflect.ParameterizedType;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.ibizsys.paas.api.FetchResult;
import net.ibizsys.paas.api.IServiceAPIClientModel;
import net.ibizsys.paas.cache.CacheManager;
import net.ibizsys.paas.cache.ICacheManager;
import net.ibizsys.paas.cache.IUniStateModel;
import net.ibizsys.paas.cache.UniStateSFSAction;
import net.ibizsys.paas.core.ActionContext;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.core.DEDataSetCond;
import net.ibizsys.paas.core.DEDataSetCondProxy;
import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.core.IDEDataQuery;
import net.ibizsys.paas.core.IDEDataQueryCodeCond;
import net.ibizsys.paas.core.IDEDataSet;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.core.IDEDataSyncIn;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.core.IDEMainState;
import net.ibizsys.paas.core.IDEUniState;
import net.ibizsys.paas.core.IPostConstructable;
import net.ibizsys.paas.core.PluginActionResult;
import net.ibizsys.paas.ctrlhandler.CtrlHandler;
import net.ibizsys.paas.ctrlhandler.ICtrlHandler;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.data.ISimpleDataObject;
import net.ibizsys.paas.db.DBCallResult;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.ISelectContext;
import net.ibizsys.paas.db.ISelectContext2;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.db.SelectContext;
import net.ibizsys.paas.db.SelectField;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.db.impl.SimpleDataSetImpl;
import net.ibizsys.paas.db.impl.SimpleDataTableImpl;
import net.ibizsys.paas.demodel.IDEActionLogicModel;
import net.ibizsys.paas.demodel.IDEDataSetModel;
import net.ibizsys.paas.demodel.IDELogicModel;
import net.ibizsys.paas.demodel.IDEUniStateModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.dts.DTSQueueSFSAction;
import net.ibizsys.paas.dts.IDTSQueueModel;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityException;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.entity.IEntityActionSupporter;
import net.ibizsys.paas.entity.SimpleEntity;
import net.ibizsys.paas.exception.ErrorException;
import net.ibizsys.paas.service.ActionSession;
import net.ibizsys.paas.service.ActionSessionManager;
import net.ibizsys.paas.service.CloneSession;
import net.ibizsys.paas.service.CloneSessionManager;
import net.ibizsys.paas.service.HibernateTransaction;
import net.ibizsys.paas.service.IDataContextParam;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.IServiceCreateParam;
import net.ibizsys.paas.service.IServicePlugin;
import net.ibizsys.paas.service.IServiceUpdateParam;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ImportSessionManager;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.service.SessionFactorySession;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.sysmodel.ISystemValueRuleModel;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.DefaultValueHelper;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.psba.dao.IBADAO;
import net.ibizsys.psba.service.DEBAUitl;
import net.ibizsys.psrt.srv.codelist.DataChangeEventCodeListModel;
import net.ibizsys.psrt.srv.common.entity.DEDataChg;
import net.ibizsys.psrt.srv.common.entity.DataSyncIn;
import net.ibizsys.psrt.srv.common.service.DEDataChgService;
import net.ibizsys.pswf.core.IWFActionContext;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public abstract class ServiceBase<ET extends IEntity>
implements IService<ET>,
IPostConstructable {
    private static final Log log = LogFactory.getLog(ServiceBase.class);
    public static final String TEMPKEY = "SRFTEMPKEY:";
    public static final String ORIGINKEY = "SRFORIKEY";
    public static final String ENTITYKEY = "SRFENTITYKEY";
    public static final String SOURCEKEY = "SRFSOURCEKEY";
    public static final String DRAFTFLAG = "SRFDRAFTFLAG";
    public static final String KEYSTATE = "SRFKEYSTATE";
    public static final String LASTUPDATEDATE = "SRFUPDATEDATE";
    public static final String IGNORECHECK = "SRFIGNORECHECK";
    public static final String IGNORECHECKKEY = "SRFIGNORECHECKKEY";
    public static final String RET = "SRFRET";
    public static final String DATASYNCIN = "SRFDATASYNCIN";
    public static final String LOGICATTACHMODE_BEFORE = "BEFORE";
    public static final String LOGICATTACHMODE_AFTER = "AFTER";
    public static final String MSG_CHECKKEYSTATE_DELETE = "CTRL.SERVICE.CHECKKEYSTATE_DELETE";
    public static final String MSG_CHECKKEYSTATE_EXIST = "CTRL.SERVICE.CHECKKEYSTATE_EXIST";
    public static final String MSG_SAVE_DATADELETE = "CTRL.SERVICE.SAVE_DATADELETE";
    public static final String MSG_GETLAST_NOTCACHED = "CTRL.SERVICE.GETLAST_NOTCACHED";
    public static final String MSG_CHECKFIELDSIMPLERULE_INFO = "CTRL.SERVICE.CHECKFIELDSIMPLERULE_INFO";
    public static final String MSG_CHECKFIELDDATASETRULE_INFO = "CTRL.SERVICE.CHECKFIELDDATASETRULE_INFO";
    public static final String MSG_CHECKFIELDSTRINGLENGTHRULE_INFO = "CTRL.SERVICE.CHECKFIELDSTRINGLENGTHRULE_INFO";
    public static final String MSG_CHECKFIELDSTRINGLENGTHRULE_INVALIDVALUE = "CTRL.SERVICE.CHECKFIELDSTRINGLENGTHRULE_INVALIDVALUE";
    public static final String MSG_CHECKFIELDVALUERANGERULE_INFO = "CTRL.SERVICE.CHECKFIELDVALUERANGERULE_INFO";
    public static final String MSG_CHECKFIELDRECURSIONRULE_INFO = "CTRL.SERVICE.CHECKFIELDRECURSIONRULE_INFO";
    public static final String MSG_CHECKFIELDREGEXRULE_INVALIDVALUE = "CTRL.SERVICE.CHECKFIELDREGEXRULE_INVALIDVALUE";
    public static final String MSG_CHECKFIELDDUPRULE_EMPTYVALUE = "CTRL.SERVICE.CHECKFIELDDUPRULE_EMPTYVALUE";
    public static final String MSG_CHECKFIELDDUPRULE_INFO = "CTRL.SERVICE.CHECKFIELDDUPRULE_INFO";
    public static final String MSG_IMPORTMODEL_DATADELETE = "CTRL.SERVICE.IMPORTMODEL_DATADELETE";
    public static final String MSG_GETREMOVEREJECTMSG_INFO = "CTRL.SERVICE.GETREMOVEREJECTMSG_INFO";
    public static final String DYNAFIELD_TEXT = "TEXTVAL";
    public static final String DYNAFIELD_INT = "INTVAL";
    public static final String DYNAFIELD_NUM = "NUMVAL";
    public static final String DYNAFIELD_DATE = "DATEVAL";
    public static final String DYNAFIELD_CLOB = "CLOBVAL";
    public static final String DYNAFIELD_BLOB = "BLOBVAL";
    public static final String DYNAFIELD_DENAME = "DENAME";
    public static final String DYNAFIELD_OWNERID = "OWNERID";
    private String strDSLink = null;
    private SessionFactory sessionFactory = null;
    protected static final SimpleEntity INVALIDLAST = new SimpleEntity();
    protected static final SimpleEntity EMPTYLAST = new SimpleEntity();
    private IServicePlugin iServicePlugin = null;
    private boolean bCalcServicePlugin = false;
    private IEntityActionHelper iEntityActionHelper = null;
    private ICacheManager iCacheManager = null;
    private IUniStateModel iUniStateModel = null;
    private boolean bCalcUniStateModel = false;
    private IServiceAPIClientModel iServiceAPIClientModel = null;
    private IDTSQueueModel iDTSQueueModel = null;
    private IDataEntityModel dynaStorageDEModel = null;
    private String strDynaStoragePickupDEFName = null;
    private IService dynaStorageService = null;

    @Override
    public IWebContext getWebContext() {
        return WebContext.getCurrent();
    }

    protected String getServiceId() {
        return null;
    }

    @Override
    public abstract IDataEntityModel<ET> getDEModel();

    @Override
    public IDAO getDAO() {
        return null;
    }

    public IBADAO getBADAO() {
        return null;
    }

    @Deprecated
    public IDAO getDAO(int nMode) throws Exception {
        switch (nMode) {
            case 1: {
                IDAO iDAO = this.getDAO();
                if (iDAO == null) {
                    throw new Exception("\u5f53\u524d\u672a\u5b9a\u4e49SQL\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61");
                }
                return iDAO;
            }
        }
        throw new Exception(StringHelper.format("\u65e0\u6cd5\u8bc6\u522b\u7684\u6570\u636e\u8bbf\u95ee\u65b9\u5f0f"));
    }

    @Override
    public DBFetchResult fetchDataSet(String strDataSetName, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        return this.onFetchDataSet(strDataSetName, iDEDataSetFetchContext);
    }

    protected DBFetchResult onFetchDataSet(String strDataSetName, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        return this.onfetchDataSet(strDataSetName, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSet(String strDataSetName, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        throw new Exception(StringHelper.format("\u6ca1\u6709\u627e\u5230\u83b7\u53d6\u6570\u636e\u96c6\u5408\u64cd\u4f5c[%1$s]", strDataSetName));
    }

    @Override
    public DBFetchResult fetchDataSetTemp(String strDataSetName, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        return this.onFetchDataSetTemp(strDataSetName, iDEDataSetFetchContext);
    }

    protected DBFetchResult onFetchDataSetTemp(String strDataSetName, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        return this.onfetchDataSetTemp(strDataSetName, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSetTemp(String strDataSetName, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        throw new Exception(StringHelper.format("\u6ca1\u6709\u627e\u5230\u83b7\u53d6\u6570\u636e\u96c6\u5408\u64cd\u4f5c[%1$s]", strDataSetName));
    }

    @Override
    public void executeAction(String strAction, IEntity iEntity) throws Exception {
        ET iEntity2 = this.getDEModel().createEntity();
        if (iEntity2.getClass().isInstance(iEntity)) {
            this.onExecuteAction(strAction, iEntity);
        } else {
            iEntity.copyTo((IDataObject)iEntity2, true);
            this.onExecuteAction(strAction, (IEntity)iEntity2);
            iEntity2.copyTo(iEntity, true);
        }
    }

    protected void onExecuteAction(String strAction, IEntity iEntity) throws Exception {
        if (StringHelper.compare(strAction, "GETDRAFT", true) == 0) {
            this.getDraft(iEntity);
            return;
        }
        if (StringHelper.compare(strAction, "GET", true) == 0) {
            this.get(iEntity);
            return;
        }
        if (StringHelper.compare(strAction, "TRYGET", true) == 0) {
            boolean bRet = this.get(iEntity, true);
            if (ActionSessionManager.getCurrentSession() != null) {
                ActionSessionManager.getCurrentSession().getEnvEntity(true).set("srfret", bRet ? 1 : 0);
            }
            return;
        }
        if (StringHelper.compare(strAction, "AUTOGET", true) == 0) {
            this.autoGet(iEntity);
            return;
        }
        if (StringHelper.compare(strAction, "TRYAUTOGET", true) == 0) {
            boolean bRet = this.autoGet(iEntity, true);
            if (ActionSessionManager.getCurrentSession() != null) {
                ActionSessionManager.getCurrentSession().getEnvEntity(true).set("srfret", bRet ? 1 : 0);
            }
            return;
        }
        if (StringHelper.compare(strAction, "GET2", true) == 0) {
            this.get2(iEntity);
            return;
        }
        if (StringHelper.compare(strAction, "TRYGET2", true) == 0) {
            boolean bRet = this.get2(iEntity, true);
            if (ActionSessionManager.getCurrentSession() != null) {
                ActionSessionManager.getCurrentSession().getEnvEntity(true).set("srfret", bRet ? 1 : 0);
            }
            return;
        }
        if (StringHelper.compare(strAction, "GET3", true) == 0) {
            this.get3(iEntity);
            return;
        }
        if (StringHelper.compare(strAction, "TRYGET3", true) == 0) {
            boolean bRet = this.get3(iEntity, true);
            if (ActionSessionManager.getCurrentSession() != null) {
                ActionSessionManager.getCurrentSession().getEnvEntity(true).set("srfret", bRet ? 1 : 0);
            }
            return;
        }
        if (StringHelper.compare(strAction, "GET4", true) == 0) {
            this.get4(iEntity);
            return;
        }
        if (StringHelper.compare(strAction, "TRYGET4", true) == 0) {
            boolean bRet = this.get4(iEntity, true);
            if (ActionSessionManager.getCurrentSession() != null) {
                ActionSessionManager.getCurrentSession().getEnvEntity(true).set("srfret", bRet ? 1 : 0);
            }
            return;
        }
        if (StringHelper.compare(strAction, "GETCACHE", true) == 0) {
            this.getCache((ET)iEntity);
            return;
        }
        if (StringHelper.compare(strAction, "SELECT", true) == 0) {
            this.select(iEntity, false);
            return;
        }
        if (StringHelper.compare(strAction, "TRYSELECT", true) == 0) {
            boolean bRet = this.select(iEntity, true);
            if (ActionSessionManager.getCurrentSession() != null) {
                ActionSessionManager.getCurrentSession().getEnvEntity(true).set("srfret", bRet ? 1 : 0);
            }
            return;
        }
        if (StringHelper.compare(strAction, "CREATE", true) == 0) {
            this.create(iEntity);
            return;
        }
        if (StringHelper.compare(strAction, "UPDATE", true) == 0) {
            this.update(iEntity);
            return;
        }
        if (StringHelper.compare(strAction, "INTERNALUPDATE", true) == 0) {
            this.internalUpdate(iEntity);
            this.internalGet(iEntity, false);
            return;
        }
        if (StringHelper.compare(strAction, "REMOVE", true) == 0) {
            this.remove(iEntity);
            return;
        }
        if (StringHelper.compare(strAction, "GETDRAFTTEMP", true) == 0) {
            this.getDraftTemp(iEntity);
            return;
        }
        if (StringHelper.compare(strAction, "GETTEMP", true) == 0) {
            this.getTemp(iEntity);
            return;
        }
        if (StringHelper.compare(strAction, "CREATETEMP", true) == 0) {
            this.createTemp(iEntity);
            return;
        }
        if (StringHelper.compare(strAction, "UPDATETEMP", true) == 0) {
            this.updateTemp(iEntity);
            return;
        }
        if (StringHelper.compare(strAction, "REMOVETEMP", true) == 0) {
            this.removeTemp(iEntity);
            return;
        }
        if (StringHelper.compare(strAction, "GETDRAFTTEMPMAJOR", true) == 0) {
            this.getDraftTempMajor(iEntity);
            return;
        }
        if (StringHelper.compare(strAction, "GETTEMPMAJOR", true) == 0) {
            this.getTempMajor(iEntity);
            return;
        }
        if (StringHelper.compare(strAction, "CREATETEMPMAJOR", true) == 0) {
            this.createTempMajor(iEntity);
            return;
        }
        if (StringHelper.compare(strAction, "UPDATETEMPMAJOR", true) == 0) {
            this.updateTempMajor(iEntity);
            return;
        }
        if (StringHelper.compare(strAction, "REMOVETEMPMAJOR", true) == 0) {
            this.removeTempMajor(iEntity);
            return;
        }
        if (StringHelper.compare(strAction, "SAVE", true) == 0) {
            this.save(iEntity);
            return;
        }
        if (StringHelper.compare(strAction, "CHECKKEY", true) == 0) {
            int nCheckState = this.checkKey(iEntity);
            if (ActionSessionManager.getCurrentSession() != null) {
                ActionSessionManager.getCurrentSession().getEnvEntity(true).set("srfret", nCheckState);
            }
            return;
        }
        if (StringHelper.compare(strAction, "GETDRAFTFROM", true) == 0) {
            this.getDraftFrom(iEntity);
            return;
        }
        if (StringHelper.compare(strAction, "GETDRAFTTEMPFROM", true) == 0) {
            this.getDraftTempFrom(iEntity);
            return;
        }
        if (StringHelper.compare(strAction, "GETDRAFTTEMPMAJORFROM", true) == 0) {
            this.getDraftTempMajorFrom(iEntity);
            return;
        }
        if (StringHelper.compare(strAction, "INITWF", true) == 0) {
            this.initWF(iEntity);
            return;
        }
        if (StringHelper.compare(strAction, "FINISHWF", true) == 0) {
            this.finishWF(iEntity);
            return;
        }
        if (StringHelper.compare(strAction, "CLOSEWF", true) == 0) {
            this.closeWF(iEntity);
            return;
        }
        if (StringHelper.compare(strAction, "CANCELSTARTWF", true) == 0) {
            this.cancelStartWF(iEntity);
            return;
        }
        throw new Exception(StringHelper.format("\u6ca1\u6709\u627e\u5230\u64cd\u4f5c[%1$s]", strAction));
    }

    @Override
    public void executeAction(String strAction, ArrayList<IEntity> entities) throws Exception {
        this.onExecuteAction(strAction, entities);
    }

    protected void onExecuteAction(String strAction, ArrayList<IEntity> entities) throws Exception {
        for (IEntity iEntity : entities) {
            this.executeAction(strAction, iEntity);
        }
    }

    @Override
    public boolean get(ET et2, boolean bTryMode2) throws Exception {
        et2.setSessionFactory(this.getSessionFactory());
        long nBeginTime = System.currentTimeMillis();
        ET et = et2;
        boolean bTryMode = bTryMode2;
        CallResult callResult = new CallResult();
        this.doServiceWork(new IServiceWork((IEntity)et, bTryMode, callResult, nBeginTime){
            private final /* synthetic */ IEntity val$et;
            private final /* synthetic */ boolean val$bTryMode;
            private final /* synthetic */ CallResult val$callResult;
            private final /* synthetic */ long val$nBeginTime;
            {
                this.val$et = iEntity;
                this.val$bTryMode = bl;
                this.val$callResult = callResult;
                this.val$nBeginTime = l;
            }

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                CallResult ret = ServiceBase.this.internalGet(this.val$et, this.val$bTryMode);
                this.val$callResult.from(ret);
                if (this.val$callResult.isError()) {
                    return;
                }
                ServiceBase.this.onAfterGet(this.val$et);
                long nTime = System.currentTimeMillis() - this.val$nBeginTime;
                log.debug((Object)StringHelper.format("get \u8017\u65f6[%1$s]", nTime));
            }
        }, false);
        return callResult.isOk();
    }

    @Override
    public boolean get2(ET et2, boolean bTryMode2) throws Exception {
        et2.setSessionFactory(this.getSessionFactory());
        long nBeginTime = System.currentTimeMillis();
        ET et = et2;
        boolean bTryMode = bTryMode2;
        CallResult callResult = new CallResult();
        this.doServiceWork(new IServiceWork((IEntity)et, bTryMode, callResult, nBeginTime){
            private final /* synthetic */ IEntity val$et;
            private final /* synthetic */ boolean val$bTryMode;
            private final /* synthetic */ CallResult val$callResult;
            private final /* synthetic */ long val$nBeginTime;
            {
                this.val$et = iEntity;
                this.val$bTryMode = bl;
                this.val$callResult = callResult;
                this.val$nBeginTime = l;
            }

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                CallResult ret = ServiceBase.this.internalGet(this.val$et, this.val$bTryMode, 1);
                this.val$callResult.from(ret);
                if (this.val$callResult.isError()) {
                    return;
                }
                ServiceBase.this.onAfterGet(this.val$et, 1);
                long nTime = System.currentTimeMillis() - this.val$nBeginTime;
                log.debug((Object)StringHelper.format("get2 \u8017\u65f6[%1$s]", nTime));
            }
        }, false);
        return callResult.isOk();
    }

    @Override
    public boolean get3(ET et2, boolean bTryMode2) throws Exception {
        et2.setSessionFactory(this.getSessionFactory());
        long nBeginTime = System.currentTimeMillis();
        ET et = et2;
        boolean bTryMode = bTryMode2;
        CallResult callResult = new CallResult();
        this.doServiceWork(new IServiceWork((IEntity)et, bTryMode, callResult, nBeginTime){
            private final /* synthetic */ IEntity val$et;
            private final /* synthetic */ boolean val$bTryMode;
            private final /* synthetic */ CallResult val$callResult;
            private final /* synthetic */ long val$nBeginTime;
            {
                this.val$et = iEntity;
                this.val$bTryMode = bl;
                this.val$callResult = callResult;
                this.val$nBeginTime = l;
            }

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                CallResult ret = ServiceBase.this.internalGet(this.val$et, this.val$bTryMode, 2);
                this.val$callResult.from(ret);
                if (this.val$callResult.isError()) {
                    return;
                }
                ServiceBase.this.onAfterGet(this.val$et, 2);
                long nTime = System.currentTimeMillis() - this.val$nBeginTime;
                log.debug((Object)StringHelper.format("get3 \u8017\u65f6[%1$s]", nTime));
            }
        }, false);
        return callResult.isOk();
    }

    @Override
    public boolean get4(ET et2, boolean bTryMode2) throws Exception {
        et2.setSessionFactory(this.getSessionFactory());
        long nBeginTime = System.currentTimeMillis();
        ET et = et2;
        boolean bTryMode = bTryMode2;
        CallResult callResult = new CallResult();
        this.doServiceWork(new IServiceWork((IEntity)et, bTryMode, callResult, nBeginTime){
            private final /* synthetic */ IEntity val$et;
            private final /* synthetic */ boolean val$bTryMode;
            private final /* synthetic */ CallResult val$callResult;
            private final /* synthetic */ long val$nBeginTime;
            {
                this.val$et = iEntity;
                this.val$bTryMode = bl;
                this.val$callResult = callResult;
                this.val$nBeginTime = l;
            }

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                CallResult ret = ServiceBase.this.internalGet(this.val$et, this.val$bTryMode, 3);
                this.val$callResult.from(ret);
                if (this.val$callResult.isError()) {
                    return;
                }
                ServiceBase.this.onAfterGet(this.val$et, 3);
                long nTime = System.currentTimeMillis() - this.val$nBeginTime;
                log.debug((Object)StringHelper.format("get4 \u8017\u65f6[%1$s]", nTime));
            }
        }, false);
        return callResult.isOk();
    }

    protected CallResult internalGet(ET entity, boolean bTryMode, int nViewLevel) throws Exception {
        CallResult callResult = new CallResult();
        switch (this.getDEModel().getStorageMode()) {
            case 0: {
                throw new ErrorException(1, "\u5f53\u524d\u5b9e\u4f53\u4e0d\u652f\u6301\u5b58\u50a8", this.getDEModel());
            }
            case 1: {
                if (this.getDEModel().isNoViewMode()) {
                    IDEDataQuery iDEDataQuery = this.getDEModel().getViewDEDataQuery(nViewLevel);
                    if (iDEDataQuery == null) {
                        throw new ErrorException(1, "\u6ca1\u6709\u83b7\u53d6\u5b9e\u4f53\u76f8\u5e94\u89c6\u56fe\u67e5\u8be2", this.getDEModel());
                    }
                    DEDataSetFetchContext deDataSetFetchContext = new DEDataSetFetchContext(null);
                    deDataSetFetchContext.setFetchTotalRow(false);
                    deDataSetFetchContext.setPageSize(1);
                    deDataSetFetchContext.setPaging(false);
                    deDataSetFetchContext.setStartRow(0);
                    if (this.getDEModel().getKeyDEField().isPhisicalDEField() || this.getDEModel().getUniTagDEField() != null && this.getDEModel().getUniTagDEField().isPhisicalDEField() || this.getDEModel().getUnionKeyValueDEFields() == null) {
                        DEDataSetCond deDataSetCondImpl = new DEDataSetCond();
                        deDataSetCondImpl.setCondType("DEFIELD");
                        deDataSetCondImpl.setCondOp("EQ");
                        if (this.getDEModel().getKeyDEField().isPhisicalDEField() && entity.get(this.getDEModel().getKeyDEField().getName()) != null) {
                            deDataSetCondImpl.setDEFName(this.getDEModel().getKeyDEField().getName());
                            deDataSetCondImpl.setCondValue(DataObject.getStringValue(entity, this.getDEModel().getKeyDEField().getName(), null));
                        } else if (this.getDEModel().getUniTagDEField() != null && this.getDEModel().getUniTagDEField().isPhisicalDEField() && entity.get(this.getDEModel().getUniTagDEField().getName()) != null) {
                            deDataSetCondImpl.setDEFName(this.getDEModel().getUniTagDEField().getName());
                            deDataSetCondImpl.setCondValue(DataObject.getStringValue(entity, this.getDEModel().getUniTagDEField().getName(), null));
                        } else {
                            throw new ErrorException(4);
                        }
                        deDataSetFetchContext.getConditionList().add(deDataSetCondImpl);
                    } else {
                        Iterator<IDEField> deFields = this.getDEModel().getUnionKeyValueDEFields();
                        while (deFields.hasNext()) {
                            IDEField iDEField = deFields.next();
                            DEDataSetCond deDataSetCondImpl = new DEDataSetCond();
                            deDataSetCondImpl.setCondType("DEFIELD");
                            deDataSetCondImpl.setCondOp("EQ");
                            deDataSetCondImpl.setDEFName(iDEField.getName());
                            deDataSetCondImpl.setCondValue(DataObject.getStringValue(entity, iDEField.getName(), null));
                            deDataSetFetchContext.getConditionList().add(deDataSetCondImpl);
                        }
                    }
                    DBFetchResult dbFetchResult = this.getDAO(this.getDEModel().getStorageMode()).fetchDEDataQuery(deDataSetFetchContext, iDEDataQuery.getId(), false);
                    if (dbFetchResult.isError()) {
                        throw new ErrorException(1, dbFetchResult.getErrorInfo());
                    }
                    if (dbFetchResult.getDataSet().getDataTableCount() == 0 || dbFetchResult.getDataSet().getDataTable(0).getCachedRowCount() == 0) {
                        if (bTryMode) {
                            callResult.setRetCode(3);
                            return callResult;
                        }
                        throw new ErrorException(3, this.getDEModel());
                    }
                    DataObject.fromDataRow(entity, dbFetchResult.getDataSet().getDataTable(0).getCachedRow(0));
                } else {
                    DBCallResult dbCallResult = null;
                    dbCallResult = nViewLevel == 0 ? this.getDAO(this.getDEModel().getStorageMode()).executeGetSql(null, entity, false) : this.getDAO(this.getDEModel().getStorageMode()).executeGetSql(null, entity, nViewLevel, false);
                    if (dbCallResult.isError()) {
                        throw new ErrorException(1, dbCallResult.getErrorInfo(), this.getDEModel());
                    }
                    if (dbCallResult.isOk()) {
                        dbCallResult.getDataSet().cacheDataRow();
                    }
                    if (dbCallResult.getDataSet().getDataTableCount() == 0 || dbCallResult.getDataSet().getDataTable(0).getCachedRowCount() == 0) {
                        if (bTryMode) {
                            callResult.setRetCode(3);
                            return callResult;
                        }
                        throw new ErrorException(3, this.getDEModel());
                    }
                    DataObject.fromDataRow(entity, dbCallResult.getDataSet().getDataTable(0).getCachedRow(0));
                }
                if (this.isEnableDynaStorage()) {
                    this.internalGetDynaStorage(entity);
                }
                entity.setSessionFactory(this.getSessionFactory());
                entity.markFullEntity(true);
                break;
            }
            case 2: {
                DEBAUitl.getData(this.getDEModel(), entity);
                entity.markFullEntity(true);
                break;
            }
            case 3: {
                throw new ErrorException(1, "\u5f53\u524d\u5b9e\u4f53\u4e0d\u652f\u6301\u6df7\u5408\u5b58\u50a8", this.getDEModel());
            }
            default: {
                throw new ErrorException(1, StringHelper.format("\u4e0d\u652f\u6301\u7684\u5b9e\u4f53\u5b58\u50a8\u6a21\u5f0f[%1$s]", this.getDEModel().getStorageMode()), this.getDEModel());
            }
        }
        return callResult;
    }

    protected void internalGetDynaStorage(ET entity) throws Exception {
        if (!this.getDEModel().hasDynaStorageDEField()) {
            return;
        }
        IService dynaStorageService = this.getDynaStorageService();
        String strPickupDEFName = this.getDynaStoragePickupDEFName();
        String strDynaFieldName = dynaStorageService.getDEModel().getMajorDEField().getName();
        SelectContext selectContext = new SelectContext();
        selectContext.set(strPickupDEFName, entity.get(this.getDEModel().getKeyDEField().getName()));
        selectContext.set(DYNAFIELD_DENAME, this.getDEModel().getName());
        ArrayList list = dynaStorageService.selectEx(selectContext);
        for (Object objEntity : list) {
            IEntity dynaEntity = (IEntity)objEntity;
            IDEField iDEField = this.getDEModel().getDEField((String)dynaEntity.get(strDynaFieldName), true);
            if (iDEField == null || iDEField.getDEFType() != 4) continue;
            this.getDynaFieldValue(dynaEntity, iDEField, entity);
        }
    }

    protected CallResult internalGet(ET entity, boolean bTryMode) throws Exception {
        return this.internalGet(entity, bTryMode, 0);
    }

    protected CallResult internalGetTemp(ET entity, boolean bTryMode) throws Exception {
        CallResult callResult = new CallResult();
        if (this.getDEModel().isNoViewMode()) {
            IDEDataQuery iDEDataQuery = this.getDEModel().getViewDEDataQuery(0);
            if (iDEDataQuery == null) {
                throw new ErrorException(1, "\u5b9e\u4f53\u6ca1\u6709\u6307\u5b9a\u9ed8\u8ba4\u67e5\u8be2", this.getDEModel());
            }
            DEDataSetFetchContext deDataSetFetchContext = new DEDataSetFetchContext(null);
            deDataSetFetchContext.setFetchTotalRow(false);
            deDataSetFetchContext.setPageSize(1);
            deDataSetFetchContext.setPaging(false);
            deDataSetFetchContext.setStartRow(0);
            if (this.getDEModel().getKeyDEField().isPhisicalDEField() || this.getDEModel().getUnionKeyValueDEFields() == null) {
                DEDataSetCond deDataSetCondImpl = new DEDataSetCond();
                deDataSetCondImpl.setCondType("DEFIELD");
                deDataSetCondImpl.setCondOp("EQ");
                deDataSetCondImpl.setDEFName(this.getDEModel().getKeyDEField().getName());
                deDataSetCondImpl.setCondValue(DataObject.getStringValue(entity, this.getDEModel().getKeyDEField().getName(), null));
                deDataSetFetchContext.getConditionList().add(deDataSetCondImpl);
            } else {
                Iterator<IDEField> deFields = this.getDEModel().getUnionKeyValueDEFields();
                while (deFields.hasNext()) {
                    IDEField iDEField = deFields.next();
                    DEDataSetCond deDataSetCondImpl = new DEDataSetCond();
                    deDataSetCondImpl.setCondType("DEFIELD");
                    deDataSetCondImpl.setCondOp("EQ");
                    deDataSetCondImpl.setDEFName(iDEField.getName());
                    deDataSetCondImpl.setCondValue(DataObject.getStringValue(entity, iDEField.getName(), null));
                    deDataSetFetchContext.getConditionList().add(deDataSetCondImpl);
                }
            }
            DBFetchResult dbFetchResult = this.getDAO().fetchDEDataQuery(deDataSetFetchContext, iDEDataQuery.getId(), true);
            if (dbFetchResult.isError()) {
                throw new ErrorException(1, dbFetchResult.getErrorInfo(), this.getDEModel());
            }
            if (dbFetchResult.getDataSet().getDataTableCount() == 0 || dbFetchResult.getDataSet().getDataTable(0).getCachedRowCount() == 0) {
                if (bTryMode) {
                    callResult.setRetCode(3);
                    return callResult;
                }
                throw new ErrorException(3, this.getDEModel());
            }
            DataObject.fromDataRow(entity, dbFetchResult.getDataSet().getDataTable(0).getCachedRow(0));
        } else {
            DBCallResult dbCallResult = this.getDAO().executeGetSql(null, entity, true);
            if (dbCallResult.isError()) {
                throw new ErrorException(1, dbCallResult.getErrorInfo(), this.getDEModel());
            }
            if (dbCallResult.isOk()) {
                dbCallResult.getDataSet().cacheDataRow();
            }
            if (dbCallResult.getDataSet().getDataTableCount() == 0 || dbCallResult.getDataSet().getDataTable(0).getCachedRowCount() == 0) {
                if (bTryMode) {
                    callResult.setRetCode(3);
                    return callResult;
                }
                throw new ErrorException(3, this.getDEModel());
            }
            DataObject.fromDataRow(entity, dbCallResult.getDataSet().getDataTable(0).getCachedRow(0));
        }
        entity.setSessionFactory(this.getSessionFactory());
        entity.markFullEntity(true);
        return callResult;
    }

    @Override
    public void get(ET et2) throws Exception {
        if (this.isUseServiceAPI()) {
            this.getServiceAPIClientModel().execute(this.getDEModel().getServiceAPIActionTag("DEACTION", "GET"), (IEntity)et2);
            return;
        }
        this.get(et2, false);
    }

    @Override
    public void get2(ET et2) throws Exception {
        if (this.isUseServiceAPI()) {
            this.getServiceAPIClientModel().execute(this.getDEModel().getServiceAPIActionTag("DEACTION", "GET2"), (IEntity)et2);
            return;
        }
        this.get2(et2, false);
    }

    @Override
    public void get3(ET et2) throws Exception {
        if (this.isUseServiceAPI()) {
            this.getServiceAPIClientModel().execute(this.getDEModel().getServiceAPIActionTag("DEACTION", "GET3"), (IEntity)et2);
            return;
        }
        this.get3(et2, false);
    }

    @Override
    public void get4(ET et2) throws Exception {
        if (this.isUseServiceAPI()) {
            this.getServiceAPIClientModel().execute(this.getDEModel().getServiceAPIActionTag("DEACTION", "GET4"), (IEntity)et2);
            return;
        }
        this.get4(et2, false);
    }

    protected void onAfterGet(ET et) throws Exception {
        this.onAfterGet(et, 0);
    }

    protected void onAfterGet(ET et, int nViewModel) throws Exception {
    }

    @Override
    public void create(ET et, boolean bGet) throws Exception {
        if (this.isUseServiceAPI()) {
            this.getServiceAPIClientModel().execute(this.getDEModel().getServiceAPIActionTag("DEACTION", "CREATE"), (IEntity)et);
            return;
        }
        et.setSessionFactory(this.getSessionFactory());
        Object strSourceKey = et.get(SOURCEKEY);
        boolean bIgnoreCheck = EntityBase.isIgnoreCheck(et);
        IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCreate(this.getService(), 0, (IEntity)et, (Object)null).getResult() == 1) {
            return;
        }
        this.onTestCreate(et);
        if (this.fillEntityKeyValue(et, false) && !EntityBase.isIgnoreCheckKey(et)) {
            int nCheckState = this.checkKey(et);
            switch (nCheckState) {
                case 2: {
                    throw new ErrorException(6, this.getLocalization(MSG_CHECKKEYSTATE_DELETE, StringHelper.format("\u6570\u636e\u5df2\u7ecf\u88ab\u5220\u9664\uff0c\u65e0\u6cd5\u518d\u6b21\u5efa\u7acb")), this.getDEModel());
                }
                case 1: {
                    Iterator<IDEField> deFields = this.getDEModel().getUnionKeyValueDEFields();
                    if (deFields != null) {
                        EntityError entityError = new EntityError();
                        while (deFields.hasNext()) {
                            IDEField iDEField = deFields.next();
                            EntityFieldError entityFieldError = new EntityFieldError();
                            entityFieldError.setFieldName(iDEField.getName());
                            if (this.getWebContext() != null) {
                                entityFieldError.setFieldLogicName(iDEField.getLogicName(this.getWebContext().getLocalization()));
                            } else {
                                entityFieldError.setFieldLogicName(iDEField.getLogicName());
                            }
                            entityFieldError.setErrorType(3);
                            entityFieldError.setErrorInfo(this.getLocalization(MSG_CHECKFIELDDUPRULE_INFO, "\u503c\u91cd\u590d"));
                            entityError.register(entityFieldError);
                        }
                        throw new EntityException(entityError, 6, this.getLocalization(MSG_CHECKKEYSTATE_EXIST, StringHelper.format("\u6570\u636e\u5df2\u7ecf\u5b58\u5728\uff0c\u65e0\u6cd5\u518d\u6b21\u5efa\u7acb")), this.getDEModel());
                    }
                    throw new ErrorException(6, this.getLocalization(MSG_CHECKKEYSTATE_EXIST, StringHelper.format("\u6570\u636e\u5df2\u7ecf\u5b58\u5728\uff0c\u65e0\u6cd5\u518d\u6b21\u5efa\u7acb")), this.getDEModel());
                }
            }
        }
        ET et2 = et;
        boolean bGet2 = bGet || this.isNeedUpdateParent();
        this.doServiceWork(new IServiceWork((IEntity)et2, iServicePlugin, bIgnoreCheck, bGet2, strSourceKey){
            private final /* synthetic */ IEntity val$et2;
            private final /* synthetic */ IServicePlugin val$iServicePlugin;
            private final /* synthetic */ boolean val$bIgnoreCheck;
            private final /* synthetic */ boolean val$bGet2;
            private final /* synthetic */ Object val$strSourceKey;
            {
                this.val$et2 = iEntity;
                this.val$iServicePlugin = iServicePlugin;
                this.val$bIgnoreCheck = bl;
                this.val$bGet2 = bl2;
                this.val$strSourceKey = object;
            }

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                ServiceBase.this.setLast(this.val$et2, EMPTYLAST, true);
                ServiceBase.this.writeBackParent(this.val$et2, true);
                ServiceBase.this.fillEntityFullInfo(this.val$et2, true);
                if (this.val$iServicePlugin != null) {
                    this.val$iServicePlugin.doCreate(ServiceBase.this.getService(), 30, this.val$et2, null);
                }
                ServiceBase.this.onBeforeCreate(this.val$et2);
                if (this.val$iServicePlugin != null) {
                    this.val$iServicePlugin.doCreate(ServiceBase.this.getService(), 31, this.val$et2, null);
                }
                if (!this.val$bIgnoreCheck) {
                    ServiceBase.this.checkEntity(this.val$et2, true, false);
                }
                if (this.val$iServicePlugin == null || this.val$iServicePlugin.doCreate(ServiceBase.this.getService(), 40, this.val$et2, null).getResult() != 1) {
                    ServiceBase.this.internalCreate(this.val$et2);
                }
                if (this.val$bGet2) {
                    ServiceBase.this.internalGet(this.val$et2, false);
                }
                if (!StringHelper.isNullOrEmpty(this.val$strSourceKey)) {
                    ServiceBase.this.copyDetails(this.val$et2, this.val$strSourceKey);
                }
                if (ServiceBase.this.isNeedUpdateParent()) {
                    ServiceBase.this.updateParent(this.val$et2);
                }
                IEntity et3 = this.val$et2;
                if ((ServiceBase.this.getDEModel().isEnableAudit() || ServiceBase.this.getDEModel().getDataChangeLogMode() != 0) && !this.val$bGet2) {
                    et3 = ServiceBase.this.getDEModel().createEntity();
                    this.val$et2.copyTo(et3, true);
                    ServiceBase.this.internalGet(et3, false);
                }
                if (ServiceBase.this.getDEModel().isEnableAudit()) {
                    ServiceBase.this.getDEModel().getDEDataAccMgr().audit(null, ServiceBase.this.getWebContext(), et3, null, "CREATE");
                }
                ServiceBase.this.syncEntity(this.val$et2, false);
                ServiceBase.this.pushDTSQueue(this.val$et2);
                ServiceBase.this.logDataChanged(1, et3);
                if (this.val$iServicePlugin != null) {
                    this.val$iServicePlugin.doCreate(ServiceBase.this.getService(), 60, this.val$et2, null);
                }
                ServiceBase.this.onAfterCreate(this.val$et2);
                if (this.val$iServicePlugin != null) {
                    this.val$iServicePlugin.doCreate(ServiceBase.this.getService(), 61, this.val$et2, null);
                }
                ServiceBase.this.resetLast(this.val$et2);
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCreate(this.getService(), 99, (IEntity)et2, (Object)null);
        }
    }

    @Override
    public void create(ET et) throws Exception {
        if (this.isUseServiceAPI()) {
            this.getServiceAPIClientModel().execute(this.getDEModel().getServiceAPIActionTag("DEACTION", "CREATE"), (IEntity)et);
            return;
        }
        this.create(et, true);
    }

    @Override
    public void create(IServiceCreateParam<ET> iServiceCreateParam) throws Exception {
        Object et = iServiceCreateParam.getEntity();
        et.setSessionFactory(this.getSessionFactory());
        Object strSourceKey = et.get(SOURCEKEY);
        boolean bIgnoreCheck = EntityBase.isIgnoreCheck(et);
        IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCreate(this.getService(), 0, iServiceCreateParam, null).getResult() == 1) {
            return;
        }
        if (!iServiceCreateParam.testAction(et)) {
            return;
        }
        if (this.fillEntityKeyValue(et, false) && !EntityBase.isIgnoreCheckKey(et)) {
            int nCheckState = this.checkKey(et);
            switch (nCheckState) {
                case 2: {
                    throw new ErrorException(6, this.getLocalization(MSG_CHECKKEYSTATE_DELETE, StringHelper.format("\u6570\u636e\u5df2\u7ecf\u88ab\u5220\u9664\uff0c\u65e0\u6cd5\u518d\u6b21\u5efa\u7acb")), this.getDEModel());
                }
                case 1: {
                    Iterator<IDEField> deFields = this.getDEModel().getUnionKeyValueDEFields();
                    if (deFields != null) {
                        EntityError entityError = new EntityError();
                        while (deFields.hasNext()) {
                            IDEField iDEField = deFields.next();
                            EntityFieldError entityFieldError = new EntityFieldError();
                            entityFieldError.setFieldName(iDEField.getName());
                            if (this.getWebContext() != null) {
                                entityFieldError.setFieldLogicName(iDEField.getLogicName(this.getWebContext().getLocalization()));
                            } else {
                                entityFieldError.setFieldLogicName(iDEField.getLogicName());
                            }
                            entityFieldError.setErrorType(3);
                            entityFieldError.setErrorInfo(this.getLocalization(MSG_CHECKFIELDDUPRULE_INFO, "\u503c\u91cd\u590d"));
                            entityError.register(entityFieldError);
                        }
                        throw new EntityException(entityError, 6, this.getLocalization(MSG_CHECKKEYSTATE_EXIST, StringHelper.format("\u6570\u636e\u5df2\u7ecf\u5b58\u5728\uff0c\u65e0\u6cd5\u518d\u6b21\u5efa\u7acb")), this.getDEModel());
                    }
                    throw new ErrorException(6, this.getLocalization(MSG_CHECKKEYSTATE_EXIST, StringHelper.format("\u6570\u636e\u5df2\u7ecf\u5b58\u5728\uff0c\u65e0\u6cd5\u518d\u6b21\u5efa\u7acb")), this.getDEModel());
                }
            }
        }
        Object et2 = et;
        boolean bGet2 = iServiceCreateParam.isReturnData() || this.isNeedUpdateParent();
        this.doServiceWork(new IServiceWork((IEntity)et2, iServicePlugin, iServiceCreateParam, bIgnoreCheck, bGet2, strSourceKey){
            private final /* synthetic */ IEntity val$et2;
            private final /* synthetic */ IServicePlugin val$iServicePlugin;
            private final /* synthetic */ IServiceCreateParam val$iServiceCreateParam;
            private final /* synthetic */ boolean val$bIgnoreCheck;
            private final /* synthetic */ boolean val$bGet2;
            private final /* synthetic */ Object val$strSourceKey;
            {
                this.val$et2 = iEntity;
                this.val$iServicePlugin = iServicePlugin;
                this.val$iServiceCreateParam = iServiceCreateParam;
                this.val$bIgnoreCheck = bl;
                this.val$bGet2 = bl2;
                this.val$strSourceKey = object;
            }

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                ServiceBase.this.setLast(this.val$et2, EMPTYLAST, true);
                ServiceBase.this.writeBackParent(this.val$et2, true);
                ServiceBase.this.fillEntityFullInfo(this.val$et2, true);
                if (this.val$iServicePlugin != null) {
                    this.val$iServicePlugin.doCreate(ServiceBase.this.getService(), 30, this.val$iServiceCreateParam, null);
                }
                this.val$iServiceCreateParam.doBeforeAction(this.val$et2);
                if (this.val$iServicePlugin != null) {
                    this.val$iServicePlugin.doCreate(ServiceBase.this.getService(), 31, this.val$iServiceCreateParam, null);
                }
                if (!this.val$bIgnoreCheck) {
                    ServiceBase.this.checkEntity(this.val$et2, true, false);
                }
                if (this.val$iServicePlugin == null || this.val$iServicePlugin.doCreate(ServiceBase.this.getService(), 40, this.val$iServiceCreateParam, null).getResult() != 1) {
                    ServiceBase.this.internalCreate(this.val$et2);
                }
                if (this.val$bGet2) {
                    ServiceBase.this.internalGet(this.val$et2, false);
                }
                if (!StringHelper.isNullOrEmpty(this.val$strSourceKey)) {
                    ServiceBase.this.copyDetails(this.val$et2, this.val$strSourceKey);
                }
                if (ServiceBase.this.isNeedUpdateParent()) {
                    ServiceBase.this.updateParent(this.val$et2);
                }
                IEntity et3 = this.val$et2;
                if ((ServiceBase.this.getDEModel().isEnableAudit() || ServiceBase.this.getDEModel().getDataChangeLogMode() != 0) && !this.val$bGet2) {
                    et3 = ServiceBase.this.getDEModel().createEntity();
                    this.val$et2.copyTo(et3, true);
                    ServiceBase.this.internalGet(et3, false);
                }
                if (ServiceBase.this.getDEModel().isEnableAudit()) {
                    ServiceBase.this.getDEModel().getDEDataAccMgr().audit(null, ServiceBase.this.getWebContext(), et3, null, "CREATE");
                }
                ServiceBase.this.syncEntity(this.val$et2, false);
                ServiceBase.this.pushDTSQueue(this.val$et2);
                ServiceBase.this.logDataChanged(1, et3);
                if (this.val$iServicePlugin != null) {
                    this.val$iServicePlugin.doCreate(ServiceBase.this.getService(), 60, this.val$iServiceCreateParam, null);
                }
                this.val$iServiceCreateParam.doAfterAction(this.val$et2);
                if (this.val$iServicePlugin != null) {
                    this.val$iServicePlugin.doCreate(ServiceBase.this.getService(), 61, this.val$iServiceCreateParam, null);
                }
                ServiceBase.this.resetLast(this.val$et2);
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCreate(this.getService(), 99, iServiceCreateParam, null);
        }
    }

    @Override
    public void save(ET et) throws Exception {
        if (this.isUseServiceAPI()) {
            this.getServiceAPIClientModel().execute(this.getDEModel().getServiceAPIActionTag("DEACTION", "SAVE"), (IEntity)et);
            return;
        }
        this.save(et, 3, true);
    }

    @Override
    public void save(ET et, int nSaveMode) throws Exception {
        this.save(et, nSaveMode, true);
    }

    @Override
    public void save(ET et, boolean bGet) throws Exception {
        this.save(et, 3, bGet);
    }

    @Override
    public void save(ET et, int nSaveMode, boolean bGet) throws Exception {
        int nKeyState = this.checkKey(et);
        if (nKeyState == 0) {
            if ((nSaveMode & 1) > 0) {
                this.create(et, bGet);
            }
            return;
        }
        if (nKeyState == 1) {
            if ((nSaveMode & 2) > 0) {
                this.update(et, bGet);
            }
            return;
        }
        throw new ErrorException(3, this.getLocalization(MSG_SAVE_DATADELETE, StringHelper.format("\u6570\u636e\u5df2\u7ecf\u88ab\u903b\u8f91\u5220\u9664\uff0c\u65e0\u6cd5\u4fdd\u5b58")), this.getDEModel());
    }

    protected void internalCreateTemp(ET entity) throws Exception {
        DBCallResult dbCallResult = this.getDAO().executeCreateSql(null, entity, true);
        if (dbCallResult.isError()) {
            throw new ErrorException(1, dbCallResult.getErrorInfo(), this.getDEModel());
        }
    }

    protected void internalCreate(ET entity) throws Exception {
        switch (this.getDEModel().getStorageMode()) {
            case 0: {
                throw new ErrorException(1, "\u5f53\u524d\u5b9e\u4f53\u4e0d\u652f\u6301\u5b58\u50a8", this.getDEModel());
            }
            case 1: {
                DBCallResult dbCallResult = this.getDAO(this.getDEModel().getStorageMode()).executeCreateSql(null, entity, false);
                if (dbCallResult.isError()) {
                    throw new ErrorException(1, dbCallResult.getErrorInfo(), this.getDEModel());
                }
                if (!this.isEnableDynaStorage()) break;
                this.internalCreateDynaStorage(entity);
                break;
            }
            case 2: {
                DEBAUitl.syncData(this.getDEModel(), entity);
                break;
            }
            case 3: {
                throw new ErrorException(1, "\u5f53\u524d\u5b9e\u4f53\u4e0d\u652f\u6301\u6df7\u5408\u5b58\u50a8", this.getDEModel());
            }
            default: {
                throw new ErrorException(1, StringHelper.format("\u4e0d\u652f\u6301\u7684\u5b9e\u4f53\u5b58\u50a8\u6a21\u5f0f[%1$s]", this.getDEModel().getStorageMode()), this.getDEModel());
            }
        }
    }

    protected void internalCreateDynaStorage(ET entity) throws Exception {
        if (!this.getDEModel().hasDynaStorageDEField()) {
            return;
        }
        IService dynaStorageService = this.getDynaStorageService();
        String strPickupDEFName = this.getDynaStoragePickupDEFName();
        String strDynaFieldName = dynaStorageService.getDEModel().getMajorDEField().getName();
        Iterator<IDEField> deFields = this.getDEModel().getDEFields();
        while (deFields.hasNext()) {
            IDEField iDEField = deFields.next();
            if (iDEField.getDEFType() != 4 || entity.get(iDEField.getName()) == null) continue;
            Object dynaEntity = dynaStorageService.getDEModel().createEntity();
            dynaEntity.set(strPickupDEFName, entity.get(this.getDEModel().getKeyDEField().getName()));
            dynaEntity.set(strDynaFieldName, iDEField.getName());
            dynaEntity.set(DYNAFIELD_DENAME, this.getDEModel().getName());
            this.setDynaFieldValue((IEntity)dynaEntity, iDEField, entity);
            dynaStorageService.create(dynaEntity, false);
        }
    }

    protected void setDynaFieldValue(IEntity dynaEntity, IDEField iDEField, ET entity) throws Exception {
        if (DataTypeHelper.isStringType(iDEField.getStdDataType())) {
            dynaEntity.set(DYNAFIELD_TEXT, entity.get(iDEField.getName()));
            return;
        }
        if (DataTypeHelper.isIntType(iDEField.getStdDataType())) {
            dynaEntity.set(DYNAFIELD_INT, entity.get(iDEField.getName()));
            return;
        }
        if (DataTypeHelper.isDoubleType(iDEField.getStdDataType())) {
            dynaEntity.set(DYNAFIELD_NUM, entity.get(iDEField.getName()));
            return;
        }
        if (DataTypeHelper.isLongStringType(iDEField.getStdDataType())) {
            dynaEntity.set(DYNAFIELD_CLOB, entity.get(iDEField.getName()));
            return;
        }
        if (DataTypeHelper.isBinaryType(iDEField.getStdDataType())) {
            dynaEntity.set(DYNAFIELD_BLOB, entity.get(iDEField.getName()));
            return;
        }
        if (DataTypeHelper.isDateTimeType(iDEField.getStdDataType())) {
            dynaEntity.set(DYNAFIELD_DATE, entity.get(iDEField.getName()));
            return;
        }
        throw new Exception(StringHelper.format("\u65e0\u6cd5\u8bbe\u7f6e\u52a8\u6001\u5b58\u50a8\u5c5e\u6027[%1$s]\uff0c\u6570\u636e\u7c7b\u578b\u4e3a[%2$s]", iDEField.getName(), iDEField.getStdDataType()));
    }

    protected void getDynaFieldValue(IEntity dynaEntity, IDEField iDEField, ET entity) throws Exception {
        if (DataTypeHelper.isStringType(iDEField.getStdDataType())) {
            entity.set(iDEField.getName(), dynaEntity.get(DYNAFIELD_TEXT));
            return;
        }
        if (DataTypeHelper.isIntType(iDEField.getStdDataType())) {
            entity.set(iDEField.getName(), dynaEntity.get(DYNAFIELD_INT));
            return;
        }
        if (DataTypeHelper.isDoubleType(iDEField.getStdDataType())) {
            entity.set(iDEField.getName(), dynaEntity.get(DYNAFIELD_NUM));
            return;
        }
        if (DataTypeHelper.isLongStringType(iDEField.getStdDataType())) {
            entity.set(iDEField.getName(), dynaEntity.get(DYNAFIELD_CLOB));
            return;
        }
        if (DataTypeHelper.isBinaryType(iDEField.getStdDataType())) {
            entity.set(iDEField.getName(), dynaEntity.get(DYNAFIELD_BLOB));
            return;
        }
        if (DataTypeHelper.isDateTimeType(iDEField.getStdDataType())) {
            entity.set(iDEField.getName(), dynaEntity.get(DYNAFIELD_DATE));
            return;
        }
        throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u52a8\u6001\u5b58\u50a8\u5c5e\u6027[%1$s]\uff0c\u6570\u636e\u7c7b\u578b\u4e3a[%2$s]", iDEField.getName(), iDEField.getStdDataType()));
    }

    protected void onTestCreate(ET et) throws Exception {
    }

    protected void onBeforeCreate(ET et) throws Exception {
        this.executeActionLogics("CREATE", LOGICATTACHMODE_BEFORE, et);
    }

    protected void onAfterCreate(ET et) throws Exception {
        this.executeActionLogics("CREATE", LOGICATTACHMODE_AFTER, et);
    }

    @Override
    public void update(ET entity, boolean bGet) throws Exception {
        if (this.isUseServiceAPI()) {
            this.getServiceAPIClientModel().execute(this.getDEModel().getServiceAPIActionTag("DEACTION", "UPDATE"), (IEntity)entity);
            return;
        }
        ET et = entity;
        boolean bGet2 = bGet || this.isNeedUpdateParent();
        boolean bIgnoreCheck = EntityBase.isIgnoreCheck(et);
        et.setSessionFactory(this.getSessionFactory());
        IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doUpdate(this.getService(), 0, (IEntity)et, (Object)null).getResult() == 1) {
            return;
        }
        if (et.get(this.getDEModel().getKeyDEField().getName()) == null && !this.fillEntityKeyValue(et, false)) {
            throw new ErrorException(4, this.getDEModel());
        }
        this.testDEMainStateAction(entity, "UPDATE");
        this.onTestUpdate(et);
        log.debug((Object)"\u5f00\u59cb[update]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork((IEntity)et, iServicePlugin, bIgnoreCheck, bGet2){
            private final /* synthetic */ IEntity val$et;
            private final /* synthetic */ IServicePlugin val$iServicePlugin;
            private final /* synthetic */ boolean val$bIgnoreCheck;
            private final /* synthetic */ boolean val$bGet2;
            {
                this.val$et = iEntity;
                this.val$iServicePlugin = iServicePlugin;
                this.val$bIgnoreCheck = bl;
                this.val$bGet2 = bl2;
            }

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                Object last = null;
                if (ServiceBase.this.isPrepareLastForUpdate()) {
                    last = ServiceBase.this.getLast(this.val$et);
                }
                ServiceBase.this.updateTestNewOldData(this.val$et);
                ServiceBase.this.writeBackParent(this.val$et, false);
                ServiceBase.this.fillEntityFullInfo(this.val$et, false);
                if (this.val$iServicePlugin != null) {
                    this.val$iServicePlugin.doUpdate(ServiceBase.this.getService(), 30, this.val$et, last);
                }
                ServiceBase.this.onBeforeUpdate(this.val$et);
                if (this.val$iServicePlugin != null) {
                    this.val$iServicePlugin.doUpdate(ServiceBase.this.getService(), 31, this.val$et, last);
                }
                if (!this.val$bIgnoreCheck) {
                    ServiceBase.this.checkEntity(this.val$et, false, false);
                }
                ServiceBase.this.setLast(this.val$et, INVALIDLAST, false);
                if (this.val$iServicePlugin == null || this.val$iServicePlugin.doUpdate(ServiceBase.this.getService(), 40, this.val$et, last).getResult() != 1) {
                    ServiceBase.this.internalUpdate(this.val$et);
                }
                if (this.val$bGet2) {
                    ServiceBase.this.internalGet(this.val$et, false);
                }
                ServiceBase.this.syncDEUniState(this.val$et, this.val$bGet2, "UPDATE");
                if (ServiceBase.this.isNeedUpdateParent()) {
                    ServiceBase.this.updateParent(this.val$et);
                }
                IEntity et3 = this.val$et;
                if ((ServiceBase.this.getDEModel().isEnableAudit() || ServiceBase.this.getDEModel().getDataChangeLogMode() != 0) && !this.val$bGet2) {
                    et3 = ServiceBase.this.getDEModel().createEntity();
                    this.val$et.copyTo(et3, true);
                    ServiceBase.this.internalGet(et3, false);
                }
                if (ServiceBase.this.getDEModel().isEnableAudit()) {
                    ServiceBase.this.getDEModel().getDEDataAccMgr().audit(null, ServiceBase.this.getWebContext(), et3, (IEntity)ServiceBase.this.getLast(this.val$et), "UPDATE");
                }
                ServiceBase.this.syncEntity(this.val$et, false);
                ServiceBase.this.logDataChanged(2, et3);
                if (this.val$iServicePlugin != null) {
                    this.val$iServicePlugin.doUpdate(ServiceBase.this.getService(), 60, this.val$et, last);
                }
                ServiceBase.this.onAfterUpdate(this.val$et);
                if (this.val$iServicePlugin != null) {
                    this.val$iServicePlugin.doUpdate(ServiceBase.this.getService(), 61, this.val$et, last);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doUpdate(this.getService(), 99, (IEntity)et, (Object)null);
        }
    }

    @Override
    public void update(final IServiceUpdateParam<ET> iServiceUpdateParam) throws Exception {
        Object et = iServiceUpdateParam.getEntity();
        boolean bGet2 = iServiceUpdateParam.isReturnData() || this.isNeedUpdateParent();
        boolean bIgnoreCheck = EntityBase.isIgnoreCheck(et);
        et.setSessionFactory(this.getSessionFactory());
        IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doUpdate(this.getService(), 0, iServiceUpdateParam, null).getResult() == 1) {
            return;
        }
        if (et.get(this.getDEModel().getKeyDEField().getName()) == null && !this.fillEntityKeyValue(et, false)) {
            throw new ErrorException(4, this.getDEModel());
        }
        this.testDEMainStateAction(et, iServiceUpdateParam.getAction());
        if (!iServiceUpdateParam.testAction(et)) {
            return;
        }
        log.debug((Object)StringHelper.format("\u5f00\u59cb[%1$s]\u4f5c\u4e1a", iServiceUpdateParam.getAction()));
        this.doServiceWork(new IServiceWork((IEntity)et, iServicePlugin, bIgnoreCheck, bGet2){
            private final /* synthetic */ IEntity val$et;
            private final /* synthetic */ IServicePlugin val$iServicePlugin;
            private final /* synthetic */ boolean val$bIgnoreCheck;
            private final /* synthetic */ boolean val$bGet2;
            {
                this.val$et = iEntity;
                this.val$iServicePlugin = iServicePlugin;
                this.val$bIgnoreCheck = bl;
                this.val$bGet2 = bl2;
            }

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                Object last = null;
                if (iServiceUpdateParam.isPrepareLast()) {
                    last = ServiceBase.this.getLast(this.val$et);
                }
                if (!iServiceUpdateParam.isSysUpdate()) {
                    ServiceBase.this.updateTestNewOldData(this.val$et);
                }
                ServiceBase.this.writeBackParent(this.val$et, false);
                ServiceBase.this.fillEntityFullInfo(this.val$et, false);
                if (this.val$iServicePlugin != null) {
                    this.val$iServicePlugin.doUpdate(ServiceBase.this.getService(), 30, iServiceUpdateParam, last);
                }
                iServiceUpdateParam.doBeforeAction(this.val$et);
                if (this.val$iServicePlugin != null) {
                    this.val$iServicePlugin.doUpdate(ServiceBase.this.getService(), 31, iServiceUpdateParam, last);
                }
                if (!this.val$bIgnoreCheck) {
                    ServiceBase.this.checkEntity(this.val$et, false, false);
                }
                ServiceBase.this.setLast(this.val$et, INVALIDLAST, false);
                if (this.val$iServicePlugin == null || this.val$iServicePlugin.doUpdate(ServiceBase.this.getService(), 40, iServiceUpdateParam, last).getResult() != 1) {
                    if (!iServiceUpdateParam.isSysUpdate()) {
                        ServiceBase.this.internalUpdate(this.val$et);
                    } else {
                        ServiceBase.this.internalSysUpdate(this.val$et);
                    }
                }
                if (this.val$bGet2) {
                    ServiceBase.this.internalGet(this.val$et, false);
                }
                ServiceBase.this.syncDEUniState(this.val$et, this.val$bGet2, "UPDATE");
                if (ServiceBase.this.isNeedUpdateParent()) {
                    ServiceBase.this.updateParent(this.val$et);
                }
                IEntity et3 = this.val$et;
                if (!iServiceUpdateParam.isSysUpdate()) {
                    if ((ServiceBase.this.getDEModel().isEnableAudit() || ServiceBase.this.getDEModel().getDataChangeLogMode() != 0) && !this.val$bGet2) {
                        et3 = ServiceBase.this.getDEModel().createEntity();
                        this.val$et.copyTo(et3, true);
                        ServiceBase.this.internalGet(et3, false);
                    }
                    if (ServiceBase.this.getDEModel().isEnableAudit()) {
                        ServiceBase.this.getDEModel().getDEDataAccMgr().audit(null, ServiceBase.this.getWebContext(), et3, (IEntity)ServiceBase.this.getLast(this.val$et), "UPDATE");
                    }
                }
                ServiceBase.this.syncEntity(this.val$et, false);
                ServiceBase.this.logDataChanged(2, et3);
                if (this.val$iServicePlugin != null) {
                    this.val$iServicePlugin.doUpdate(ServiceBase.this.getService(), 60, iServiceUpdateParam, last);
                }
                iServiceUpdateParam.doAfterAction(this.val$et);
                if (this.val$iServicePlugin != null) {
                    this.val$iServicePlugin.doUpdate(ServiceBase.this.getService(), 61, iServiceUpdateParam, last);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doUpdate(this.getService(), 99, iServiceUpdateParam, null);
        }
    }

    @Override
    public void sysUpdate(ET entity, boolean bGet) throws Exception {
        ET et = entity;
        boolean bGet2 = bGet || this.isNeedUpdateParent();
        boolean bIgnoreCheck = EntityBase.isIgnoreCheck(et);
        et.setSessionFactory(this.getSessionFactory());
        if (et.get(this.getDEModel().getKeyDEField().getName()) == null && !this.fillEntityKeyValue(et, false)) {
            throw new ErrorException(4, this.getDEModel());
        }
        this.onTestUpdate(et);
        log.debug((Object)"\u5f00\u59cb[sysupdate]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork((IEntity)et, bIgnoreCheck, bGet2){
            private final /* synthetic */ IEntity val$et;
            private final /* synthetic */ boolean val$bIgnoreCheck;
            private final /* synthetic */ boolean val$bGet2;
            {
                this.val$et = iEntity;
                this.val$bIgnoreCheck = bl;
                this.val$bGet2 = bl2;
            }

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                ServiceBase.this.writeBackParent(this.val$et, false);
                ServiceBase.this.fillEntityFullInfo(this.val$et, false);
                if (!this.val$bIgnoreCheck) {
                    ServiceBase.this.checkEntity(this.val$et, false, false);
                }
                ServiceBase.this.internalSysUpdate(this.val$et);
                if (this.val$bGet2) {
                    ServiceBase.this.internalGet(this.val$et, false);
                }
                ServiceBase.this.syncDEUniState(this.val$et, this.val$bGet2, "UPDATE");
                if (ServiceBase.this.isNeedUpdateParent()) {
                    ServiceBase.this.updateParent(this.val$et);
                }
                ServiceBase.this.syncEntity(this.val$et, false);
            }
        });
    }

    @Override
    public void update(ET entity) throws Exception {
        if (this.isUseServiceAPI()) {
            this.getServiceAPIClientModel().execute(this.getDEModel().getServiceAPIActionTag("DEACTION", "UPDATE"), (IEntity)entity);
            return;
        }
        this.update(entity, true);
    }

    protected boolean isPrepareLastForUpdate() {
        PluginActionResult pluginActionResult;
        IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && (pluginActionResult = iServicePlugin.isPrepareLastForUpdate(this.getService(), null)).getResult() == 1 && pluginActionResult.getUserObject() != null && ((Boolean)pluginActionResult.getUserObject()).booleanValue()) {
            return true;
        }
        return this.getDEModel().isEnableAudit();
    }

    protected boolean isPrepareLastForRemove() {
        PluginActionResult pluginActionResult;
        IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && (pluginActionResult = iServicePlugin.isPrepareLastForRemove(this.getService(), null)).getResult() == 1 && pluginActionResult.getUserObject() != null && ((Boolean)pluginActionResult.getUserObject()).booleanValue()) {
            return true;
        }
        return this.getDEModel().isEnableAudit();
    }

    protected void updateTestNewOldData(ET entity) throws Exception {
        if (!entity.isNull("srfupdatedate")) {
            String strFieldName;
            ET lastEntity = this.getLast((IEntity)entity);
            IDEField updateDEField = this.getDEModel().getUpdateDateDEField();
            if (updateDEField != null && lastEntity.contains(strFieldName = updateDEField.getName())) {
                String strLastDateStr;
                String strCurDateStr;
                Timestamp curDate = DataObject.getTimestampValue(entity, "srfupdatedate", null);
                Timestamp lastDate = DataObject.getTimestampValue(lastEntity, strFieldName, null);
                if (curDate != null && lastDate != null && StringHelper.compare(strCurDateStr = StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", curDate), strLastDateStr = StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", lastDate), true) != 0) {
                    throw new ErrorException(10, this.getDEModel());
                }
            }
        }
    }

    protected void internalUpdate(ET entity) throws Exception {
        switch (this.getDEModel().getStorageMode()) {
            case 0: {
                throw new ErrorException(1, "\u5f53\u524d\u5b9e\u4f53\u4e0d\u652f\u6301\u5b58\u50a8", this.getDEModel());
            }
            case 1: {
                DBCallResult dbCallResult = this.getDAO(this.getDEModel().getStorageMode()).executeUpdateSql(null, entity, false);
                if (dbCallResult.isError()) {
                    throw new ErrorException(1, dbCallResult.getErrorInfo(), this.getDEModel());
                }
                if (!this.isEnableDynaStorage()) break;
                this.internalUpdateDynaStorage(entity);
                break;
            }
            case 2: {
                DEBAUitl.syncData(this.getDEModel(), entity);
                break;
            }
            case 3: {
                throw new ErrorException(1, "\u5f53\u524d\u5b9e\u4f53\u4e0d\u652f\u6301\u6df7\u5408\u5b58\u50a8", this.getDEModel());
            }
            default: {
                throw new ErrorException(1, StringHelper.format("\u4e0d\u652f\u6301\u7684\u5b9e\u4f53\u5b58\u50a8\u6a21\u5f0f[%1$s]", this.getDEModel().getStorageMode()), this.getDEModel());
            }
        }
    }

    protected void internalUpdateDynaStorage(ET entity) throws Exception {
        IEntity dynaEntity;
        if (!this.getDEModel().hasDynaStorageDEField()) {
            return;
        }
        IService dynaStorageService = this.getDynaStorageService();
        String strPickupDEFName = this.getDynaStoragePickupDEFName();
        String strDynaFieldName = dynaStorageService.getDEModel().getMajorDEField().getName();
        SelectContext selectContext = new SelectContext();
        selectContext.addSelectField(dynaStorageService.getDEModel().getKeyDEField().getName());
        selectContext.addSelectField(strDynaFieldName);
        selectContext.set(strPickupDEFName, entity.get(this.getDEModel().getKeyDEField().getName()));
        selectContext.set(DYNAFIELD_DENAME, this.getDEModel().getName());
        ArrayList list = dynaStorageService.selectEx(selectContext);
        HashMap<String, Object> dynaEntityMap = new HashMap<String, Object>();
        for (Object objEntity : list) {
            dynaEntity = (IEntity)objEntity;
            dynaEntityMap.put((String)dynaEntity.get(strDynaFieldName), dynaEntity.get(dynaStorageService.getDEModel().getKeyDEField().getName()));
        }
        Iterator<IDEField> deFields = this.getDEModel().getDEFields();
        while (deFields.hasNext()) {
            IDEField iDEField = deFields.next();
            if (iDEField.getDEFType() != 4 || entity.get(iDEField.getName()) == null) continue;
            dynaEntity = dynaStorageService.getDEModel().createEntity();
            dynaEntity.set(strPickupDEFName, entity.get(this.getDEModel().getKeyDEField().getName()));
            dynaEntity.set(strDynaFieldName, iDEField.getName());
            dynaEntity.set(DYNAFIELD_DENAME, this.getDEModel().getName());
            Object objLastId = dynaEntityMap.get(iDEField.getName());
            this.setDynaFieldValue(dynaEntity, iDEField, entity);
            if (objLastId == null) {
                dynaStorageService.create(dynaEntity, false);
                continue;
            }
            dynaEntity.set(dynaStorageService.getDEModel().getKeyDEField().getName(), objLastId);
            dynaStorageService.update(dynaEntity, false);
            dynaEntityMap.remove(iDEField.getName());
        }
        for (Object objKey : dynaEntityMap.values()) {
            Object dynaEntity2 = dynaStorageService.getDEModel().createEntity();
            dynaEntity2.set(dynaStorageService.getDEModel().getKeyDEField().getName(), objKey);
            dynaStorageService.remove(dynaEntity2);
        }
    }

    protected void internalSysUpdate(ET entity) throws Exception {
        switch (this.getDEModel().getStorageMode()) {
            case 0: {
                throw new ErrorException(1, "\u5f53\u524d\u5b9e\u4f53\u4e0d\u652f\u6301\u5b58\u50a8", this.getDEModel());
            }
            case 1: {
                DBCallResult dbCallResult = this.getDAO(this.getDEModel().getStorageMode()).executeSysUpdateSql(null, entity, false);
                if (dbCallResult.isError()) {
                    throw new ErrorException(1, dbCallResult.getErrorInfo(), this.getDEModel());
                }
                if (!this.isEnableDynaStorage()) break;
                this.internalUpdateDynaStorage(entity);
                break;
            }
            case 2: {
                DEBAUitl.syncData(this.getDEModel(), entity);
                break;
            }
            case 3: {
                throw new ErrorException(1, "\u5f53\u524d\u5b9e\u4f53\u4e0d\u652f\u6301\u6df7\u5408\u5b58\u50a8", this.getDEModel());
            }
            default: {
                throw new ErrorException(1, StringHelper.format("\u4e0d\u652f\u6301\u7684\u5b9e\u4f53\u5b58\u50a8\u6a21\u5f0f[%1$s]", this.getDEModel().getStorageMode()), this.getDEModel());
            }
        }
    }

    protected void internalSysUpdateTemp(ET entity) throws Exception {
        DBCallResult dbCallResult = this.getDAO().executeSysUpdateSql(null, entity, true);
        if (dbCallResult.isError()) {
            throw new ErrorException(1, dbCallResult.getErrorInfo(), this.getDEModel());
        }
    }

    protected void onTestUpdate(ET et) throws Exception {
    }

    protected void onBeforeUpdate(ET et) throws Exception {
        this.executeActionLogics("UPDATE", LOGICATTACHMODE_BEFORE, et);
    }

    protected void onAfterUpdate(ET et) throws Exception {
        this.executeActionLogics("UPDATE", LOGICATTACHMODE_AFTER, et);
    }

    @Override
    public void remove(ET entity) throws Exception {
        if (this.isUseServiceAPI()) {
            this.getServiceAPIClientModel().execute(this.getDEModel().getServiceAPIActionTag("DEACTION", "REMOVE"), (IEntity)entity);
            return;
        }
        ET et = entity;
        et.setSessionFactory(this.getSessionFactory());
        IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doRemove(this.getService(), 0, (IEntity)et, (Object)null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(entity, "REMOVE");
        this.onTestRemove(entity);
        log.debug((Object)"\u5f00\u59cb[remove]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork((IEntity)et, iServicePlugin){
            private final /* synthetic */ IEntity val$et;
            private final /* synthetic */ IServicePlugin val$iServicePlugin;
            {
                this.val$et = iEntity;
                this.val$iServicePlugin = iServicePlugin;
            }

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                Object objKeyValue = this.val$et.get(ServiceBase.this.getDEModel().getKeyDEField().getName());
                if (!ActionSessionManager.getCurrentSession().registerRecursion("REMOVE", ServiceBase.this.getDEModel().getId(), objKeyValue)) {
                    return;
                }
                Object last = null;
                if (ServiceBase.this.isPrepareLastForRemove() || ServiceBase.this.isNeedUpdateParent()) {
                    last = ServiceBase.this.getLast(this.val$et);
                }
                if (this.val$iServicePlugin != null) {
                    this.val$iServicePlugin.doRemove(ServiceBase.this.getService(), 30, this.val$et, last);
                }
                ServiceBase.this.onBeforeRemove(this.val$et);
                if (this.val$iServicePlugin != null) {
                    this.val$iServicePlugin.doRemove(ServiceBase.this.getService(), 31, this.val$et, last);
                }
                ServiceBase.this.syncEntity(this.val$et, true);
                ServiceBase.this.setLast(this.val$et, INVALIDLAST, false);
                if (this.val$iServicePlugin == null || this.val$iServicePlugin.doRemove(ServiceBase.this.getService(), 40, this.val$et, null).getResult() != 1) {
                    ServiceBase.this.internalRemove(this.val$et);
                }
                ServiceBase.this.syncDEUniState(this.val$et, true, "REMOVE");
                ServiceBase.this.updateParent(last);
                if (ServiceBase.this.getDEModel().isEnableAudit()) {
                    ServiceBase.this.getDEModel().getDEDataAccMgr().audit(null, ServiceBase.this.getWebContext(), (IEntity)ServiceBase.this.getLast(this.val$et), null, "DELETE");
                }
                ServiceBase.this.logDataChanged(4, this.val$et);
                if (this.val$iServicePlugin != null) {
                    this.val$iServicePlugin.doRemove(ServiceBase.this.getService(), 60, this.val$et, last);
                }
                ServiceBase.this.onAfterRemove(this.val$et);
                if (this.val$iServicePlugin != null) {
                    this.val$iServicePlugin.doRemove(ServiceBase.this.getService(), 61, this.val$et, last);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doRemove(this.getService(), 99, (IEntity)et, (Object)null);
        }
    }

    protected void internalRemove(ET et) throws Exception {
        switch (this.getDEModel().getStorageMode()) {
            case 0: {
                throw new ErrorException(1, "\u5f53\u524d\u5b9e\u4f53\u4e0d\u652f\u6301\u5b58\u50a8", this.getDEModel());
            }
            case 1: {
                DBCallResult dbCallResult;
                if (this.isEnableDynaStorage()) {
                    this.internalRemoveDynaStorage(et);
                }
                if (!(dbCallResult = this.getDAO(this.getDEModel().getStorageMode()).executeRemoveSql(null, et, false)).isError()) break;
                throw new ErrorException(1, dbCallResult.getErrorInfo(), this.getDEModel());
            }
            case 2: {
                DEBAUitl.removeData(this.getDEModel(), et);
                break;
            }
            case 3: {
                throw new ErrorException(1, "\u5f53\u524d\u5b9e\u4f53\u4e0d\u652f\u6301\u6df7\u5408\u5b58\u50a8", this.getDEModel());
            }
            default: {
                throw new ErrorException(1, StringHelper.format("\u4e0d\u652f\u6301\u7684\u5b9e\u4f53\u5b58\u50a8\u6a21\u5f0f[%1$s]", this.getDEModel().getStorageMode()), this.getDEModel());
            }
        }
    }

    protected void internalRemoveDynaStorage(ET entity) throws Exception {
        if (!this.getDEModel().hasDynaStorageDEField()) {
            return;
        }
        IService dynaStorageService = this.getDynaStorageService();
        String strPickupDEFName = this.getDynaStoragePickupDEFName();
        String strDynaFieldName = dynaStorageService.getDEModel().getMajorDEField().getName();
        SelectContext selectContext = new SelectContext();
        selectContext.addSelectField(dynaStorageService.getDEModel().getKeyDEField().getName());
        selectContext.addSelectField(strDynaFieldName);
        selectContext.set(strPickupDEFName, entity.get(this.getDEModel().getKeyDEField().getName()));
        selectContext.set(DYNAFIELD_DENAME, this.getDEModel().getName());
        ArrayList list = dynaStorageService.selectEx(selectContext);
        HashMap dynaEntityMap = new HashMap();
        for (Object objEntity : list) {
            IEntity dynaEntity = (IEntity)objEntity;
            dynaStorageService.remove(dynaEntity);
        }
    }

    protected void onTestRemove(ET et) throws Exception {
    }

    protected void onBeforeRemove(ET et) throws Exception {
        this.executeActionLogics("REMOVE", LOGICATTACHMODE_BEFORE, et);
    }

    protected void onAfterRemove(ET et) throws Exception {
        this.executeActionLogics("REMOVE", LOGICATTACHMODE_AFTER, et);
    }

    protected void onBeforeRemove(ArrayList<ET> list) throws Exception {
    }

    protected void onAfterRemove(ArrayList<ET> list) throws Exception {
    }

    protected void internalRemove(ArrayList<ET> list) throws Exception {
        for (IEntity et : list) {
            this.remove(et);
        }
    }

    @Override
    public void remove(ISelectCond iSelectCond, boolean bDirect) throws Exception {
        if (bDirect) {
            log.warn((Object)"\u6ca1\u6709\u5b9e\u73b0\u76f4\u63a5\u5220\u9664\u8bed\u53e5");
            ArrayList<ET> list = this.select(iSelectCond);
            this.remove(list);
        } else {
            ArrayList<ET> list = this.select(iSelectCond);
            this.remove(list);
        }
    }

    @Override
    public void remove(ArrayList<ET> entityList) throws Exception {
        final ArrayList<ET> list = entityList;
        log.debug((Object)"\u5f00\u59cb[remove]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork(){

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                ServiceBase.this.onBeforeRemove(list);
                ServiceBase.this.internalRemove(list);
                ServiceBase.this.onAfterRemove(list);
            }
        });
    }

    @Override
    public boolean selectOne(ET et, boolean bTryMode) throws Exception {
        return this.select(et, bTryMode);
    }

    @Override
    public boolean selectTempOne(ET et, boolean bTryMode) throws Exception {
        return this.selectTemp(et, bTryMode);
    }

    @Override
    public boolean select(ET et, boolean bTryMode) throws Exception {
        SelectCond selectCond = new SelectCond();
        et.copyTo(selectCond, false);
        selectCond.setFetchFirst(true);
        ArrayList<ET> list = this.select(selectCond);
        if (list.size() == 0) {
            if (bTryMode) {
                return false;
            }
            throw new ErrorException(3, this.getDEModel());
        }
        ((IEntity)list.get(0)).copyTo((IDataObject)et, true);
        return true;
    }

    @Override
    public ArrayList<ET> selectEx(ISelectContext iSelectContext) throws Exception {
        return this.select(iSelectContext);
    }

    @Override
    public ArrayList<ET> select(ISelectCond iSelectCond2) throws Exception {
        if (this.isUseServiceAPI()) {
            ArrayList<IEntity> list = this.getServiceAPIClientModel().select(this.getDEModel().getServiceAPIActionTag("SELECT", ""), iSelectCond2);
            ArrayList<ET> list2 = new ArrayList<ET>();
            for (IEntity iEntity : list) {
                ET et = this.getDEModel().createEntity();
                iEntity.copyTo((IDataObject)et, false);
                list2.add(et);
            }
            return list2;
        }
        final ISelectCond iSelectCond = iSelectCond2;
        final CallResult callResult = new CallResult();
        this.doServiceWork(new IServiceWork(){

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                callResult.setUserObject(ServiceBase.this.internalSelect(iSelectCond));
            }
        });
        return (ArrayList)callResult.getUserObject();
    }

    protected ArrayList<ET> internalSelect(ISelectCond iSelectCond) throws Exception {
        ISelectContext iSelectContext = iSelectCond instanceof ISelectContext ? (ISelectContext)iSelectCond : null;
        switch (this.getDEModel().getStorageMode()) {
            case 0: {
                throw new ErrorException(1, "\u5f53\u524d\u5b9e\u4f53\u4e0d\u652f\u6301\u5b58\u50a8", this.getDEModel());
            }
            case 1: {
                DBCallResult dbCallResult = null;
                ArrayList<ET> list = new ArrayList<ET>();
                if (iSelectContext != null && !StringHelper.isNullOrEmpty(iSelectContext.getDEDataQueryName())) {
                    dbCallResult = this.getDAO().fetchDEDataQuery(iSelectContext, false);
                } else if (this.getDEModel().isNoViewMode()) {
                    IDEDataQuery iDEDataQuery = this.getDEModel().getViewDEDataQuery(0);
                    if (iDEDataQuery == null) {
                        throw new ErrorException(1, "\u6ca1\u6709\u83b7\u53d6\u5b9e\u4f53\u76f8\u5e94\u89c6\u56fe\u67e5\u8be2", this.getDEModel());
                    }
                    DEDataSetFetchContext deDataSetFetchContext = new DEDataSetFetchContext(null);
                    deDataSetFetchContext.setCacheDataSet(false);
                    deDataSetFetchContext.setFetchTotalRow(false);
                    if (iSelectCond.isFetchFirst()) {
                        deDataSetFetchContext.setPageSize(1);
                    }
                    deDataSetFetchContext.setPaging(false);
                    deDataSetFetchContext.setStartRow(0);
                    if (iSelectContext != null) {
                        ISelectContext2 iSelectContext2;
                        if (!StringHelper.isNullOrEmpty(iSelectContext.getSort())) {
                            deDataSetFetchContext.setSort(iSelectContext.getSort());
                            deDataSetFetchContext.setSortDir(iSelectContext.getSortDir());
                        }
                        if (iSelectContext instanceof ISelectContext2 && (iSelectContext2 = (ISelectContext2)iSelectContext).isPaging()) {
                            deDataSetFetchContext.setPaging(iSelectContext2.isPaging());
                            deDataSetFetchContext.setStartRow(iSelectContext2.getStartRow());
                            deDataSetFetchContext.setPageSize(iSelectContext2.getPageSize());
                        }
                    }
                    if (this.getDEModel().isLogicValid()) {
                        DEDataSetCond deDataSetCondImpl = new DEDataSetCond();
                        deDataSetCondImpl.setCondType("DEFIELD");
                        deDataSetCondImpl.setCondOp("EQ");
                        deDataSetCondImpl.setDEFName(this.getDEModel().getLogicValidDEField().getName());
                        deDataSetCondImpl.setCondValue(DataObject.getStringValue(this.getDEModel().getLogicValidValue(true)));
                        deDataSetFetchContext.getConditionList().add(deDataSetCondImpl);
                    }
                    HashMap<String, Object> paramMap = new HashMap<String, Object>();
                    iSelectCond.fillMap(paramMap);
                    for (String strFieldName : paramMap.keySet()) {
                        DEDataSetCond deDataSetCondImpl;
                        IDEField iDEField = this.getDEModel().getDEField(strFieldName, true);
                        if (iDEField == null) continue;
                        Object objValue = paramMap.get(strFieldName);
                        if (objValue == SelectCond.ISNOTNULL) {
                            deDataSetCondImpl = new DEDataSetCond();
                            deDataSetCondImpl.setCondType("DEFIELD");
                            deDataSetCondImpl.setCondOp("ISNOTNULL");
                            deDataSetCondImpl.setDEFName(iDEField.getName());
                            deDataSetFetchContext.getConditionList().add(deDataSetCondImpl);
                            continue;
                        }
                        if (objValue == SelectCond.ISNULL) {
                            deDataSetCondImpl = new DEDataSetCond();
                            deDataSetCondImpl.setCondType("DEFIELD");
                            deDataSetCondImpl.setCondOp("ISNULL");
                            deDataSetCondImpl.setDEFName(iDEField.getName());
                            deDataSetFetchContext.getConditionList().add(deDataSetCondImpl);
                            continue;
                        }
                        deDataSetCondImpl = new DEDataSetCond();
                        deDataSetCondImpl.setCondType("DEFIELD");
                        deDataSetCondImpl.setCondOp("EQ");
                        deDataSetCondImpl.setDEFName(iDEField.getName());
                        deDataSetCondImpl.setCondValue(DataObject.getStringValue(objValue));
                        deDataSetFetchContext.getConditionList().add(deDataSetCondImpl);
                    }
                    if (iSelectContext != null && iSelectContext.getSelectFilter() != null && iSelectContext.getSelectFilter() instanceof IDEDataQueryCodeCond) {
                        deDataSetFetchContext.getConditionList().add(new DEDataSetCondProxy((IDEDataQueryCodeCond)iSelectContext.getSelectFilter()));
                    }
                    dbCallResult = this.getDAO(this.getDEModel().getStorageMode()).fetchDEDataQuery(deDataSetFetchContext, iDEDataQuery.getId(), false);
                } else {
                    dbCallResult = this.getDAO().executeSelectSql(null, iSelectCond, false);
                }
                if (dbCallResult.isError()) {
                    throw new ErrorException(1, dbCallResult.getErrorInfo(), this.getDEModel());
                }
                try {
                    ET et;
                    IDataRow iDataRow;
                    IDataTable iDataTable;
                    if (!iSelectCond.isFetchFirst()) {
                        iDataTable = dbCallResult.getDataSet().getDataTable(0);
                        iDataTable.cacheRows(iSelectCond.getMaxRowCount());
                        int nRows = iDataTable.getCachedRowCount();
                        int i = 0;
                        while (i < nRows) {
                            iDataRow = iDataTable.getCachedRow(i);
                            et = this.getDEModel().createEntity();
                            DataObject.fromDataRow(et, iDataRow);
                            et.setSessionFactory(this.getSessionFactory());
                            et.markFullEntity(true);
                            list.add(et);
                            ++i;
                        }
                        dbCallResult.getDataSet().close();
                    } else {
                        iDataTable = dbCallResult.getDataSet().getDataTable(0);
                        iDataTable.cacheRows(1);
                        int nRows = iDataTable.getCachedRowCount();
                        int i = 0;
                        if (i < nRows) {
                            iDataRow = iDataTable.getCachedRow(i);
                            et = this.getDEModel().createEntity();
                            DataObject.fromDataRow(et, iDataRow);
                            et.setSessionFactory(this.getSessionFactory());
                            et.markFullEntity(true);
                            list.add(et);
                        }
                        dbCallResult.getDataSet().close();
                    }
                }
                catch (Exception ex) {
                    log.error((Object)StringHelper.format("\u67e5\u8be2\u6570\u636e\u53d1\u751f\u5f02\u5e38\uff0c%1$s", ex.getMessage()), (Throwable)ex);
                    dbCallResult.getDataSet().close();
                }
                return list;
            }
            case 3: {
                throw new ErrorException(1, "\u5f53\u524d\u5b9e\u4f53\u4e0d\u652f\u6301\u6df7\u5408\u5b58\u50a8", this.getDEModel());
            }
        }
        throw new ErrorException(1, StringHelper.format("\u4e0d\u652f\u6301\u7684\u5b9e\u4f53\u5b58\u50a8\u6a21\u5f0f[%1$s]", this.getDEModel().getStorageMode()), this.getDEModel());
    }

    @Override
    public ArrayList<ET> selectTempEx(ISelectContext iSelectContext) throws Exception {
        return this.selectTemp(iSelectContext);
    }

    @Override
    public ArrayList<ET> selectTemp(ISelectCond iSelectCond2) throws Exception {
        if (this.isUseServiceAPI()) {
            ArrayList<IEntity> list = this.getServiceAPIClientModel().select(this.getDEModel().getServiceAPIActionTag("SELECTTEMP", ""), iSelectCond2);
            ArrayList<ET> list2 = new ArrayList<ET>();
            for (IEntity iEntity : list) {
                ET et = this.getDEModel().createEntity();
                iEntity.copyTo((IDataObject)et, false);
                list2.add(et);
            }
            return list2;
        }
        final ISelectCond iSelectCond = iSelectCond2;
        final CallResult callResult = new CallResult();
        this.doServiceWork(new IServiceWork(){

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                callResult.setUserObject(ServiceBase.this.internalSelectTemp(iSelectCond));
            }
        });
        return (ArrayList)callResult.getUserObject();
    }

    protected ArrayList<ET> internalSelectTemp(ISelectCond iSelectCond) throws Exception {
        DBCallResult dbCallResult = null;
        if (this.getDEModel().isNoViewMode()) {
            IDEDataQuery iDEDataQuery = this.getDEModel().getViewDEDataQuery(0);
            if (iDEDataQuery == null) {
                throw new ErrorException(1, "\u6ca1\u6709\u83b7\u53d6\u5b9e\u4f53\u76f8\u5e94\u89c6\u56fe\u67e5\u8be2", this.getDEModel());
            }
            DEDataSetFetchContext deDataSetFetchContext = new DEDataSetFetchContext(null);
            deDataSetFetchContext.setCacheDataSet(false);
            deDataSetFetchContext.setFetchTotalRow(false);
            if (iSelectCond.isFetchFirst()) {
                deDataSetFetchContext.setPageSize(1);
            }
            deDataSetFetchContext.setPaging(false);
            deDataSetFetchContext.setStartRow(0);
            if (this.getDEModel().isLogicValid()) {
                DEDataSetCond deDataSetCondImpl = new DEDataSetCond();
                deDataSetCondImpl.setCondType("DEFIELD");
                deDataSetCondImpl.setCondOp("EQ");
                deDataSetCondImpl.setDEFName(this.getDEModel().getLogicValidDEField().getName());
                deDataSetCondImpl.setCondValue(DataObject.getStringValue(this.getDEModel().getLogicValidValue(true)));
                deDataSetFetchContext.getConditionList().add(deDataSetCondImpl);
            }
            HashMap<String, Object> paramMap = new HashMap<String, Object>();
            iSelectCond.fillMap(paramMap);
            for (String strFieldName : paramMap.keySet()) {
                DEDataSetCond deDataSetCondImpl;
                IDEField iDEField = this.getDEModel().getDEField(strFieldName, true);
                if (iDEField == null) continue;
                Object objValue = paramMap.get(strFieldName);
                if (objValue == SelectCond.ISNOTNULL) {
                    deDataSetCondImpl = new DEDataSetCond();
                    deDataSetCondImpl.setCondType("DEFIELD");
                    deDataSetCondImpl.setCondOp("ISNOTNULL");
                    deDataSetCondImpl.setDEFName(iDEField.getName());
                    deDataSetFetchContext.getConditionList().add(deDataSetCondImpl);
                    continue;
                }
                if (objValue == SelectCond.ISNULL) {
                    deDataSetCondImpl = new DEDataSetCond();
                    deDataSetCondImpl.setCondType("DEFIELD");
                    deDataSetCondImpl.setCondOp("ISNULL");
                    deDataSetCondImpl.setDEFName(iDEField.getName());
                    deDataSetFetchContext.getConditionList().add(deDataSetCondImpl);
                    continue;
                }
                deDataSetCondImpl = new DEDataSetCond();
                deDataSetCondImpl.setCondType("DEFIELD");
                deDataSetCondImpl.setCondOp("EQ");
                deDataSetCondImpl.setDEFName(iDEField.getName());
                deDataSetCondImpl.setCondValue(DataObject.getStringValue(objValue));
                deDataSetFetchContext.getConditionList().add(deDataSetCondImpl);
            }
            dbCallResult = this.getDAO(this.getDEModel().getStorageMode()).fetchDEDataQuery(deDataSetFetchContext, iDEDataQuery.getId(), true);
        } else {
            ISelectContext iSelectContext = iSelectCond instanceof ISelectContext ? (ISelectContext)iSelectCond : null;
            dbCallResult = iSelectContext != null && !StringHelper.isNullOrEmpty(iSelectContext.getDEDataQueryName()) ? this.getDAO().fetchDEDataQuery(iSelectContext, true) : this.getDAO().executeSelectSql(null, iSelectCond, true);
            if (dbCallResult.isError()) {
                throw new ErrorException(1, dbCallResult.getErrorInfo(), this.getDEModel());
            }
        }
        ArrayList<ET> list = new ArrayList<ET>();
        try {
            if (dbCallResult.isOk()) {
                dbCallResult.getDataSet().cacheDataRow();
            }
            IDataTable iDataTable = dbCallResult.getDataSet().getDataTable(0);
            int nRows = iDataTable.getCachedRowCount();
            int i = 0;
            while (i < nRows) {
                IDataRow iDataRow = iDataTable.getCachedRow(i);
                ET et = this.getDEModel().createEntity();
                DataObject.fromDataRow(et, iDataRow);
                et.setSessionFactory(this.getSessionFactory());
                et.markFullEntity(true);
                list.add(et);
                ++i;
            }
            dbCallResult.getDataSet().close();
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format("\u67e5\u8be2\u6570\u636e\u53d1\u751f\u5f02\u5e38\uff0c%1$s", ex.getMessage()), (Throwable)ex);
            dbCallResult.getDataSet().close();
        }
        return list;
    }

    @Override
    public boolean selectTemp(ET et, boolean bTryMode) throws Exception {
        SelectCond selectCond = new SelectCond();
        et.copyTo(selectCond, false);
        selectCond.setFetchFirst(true);
        ArrayList<ET> list = this.selectTemp(selectCond);
        if (list.size() == 0) {
            if (bTryMode) {
                return false;
            }
            throw new ErrorException(3, this.getDEModel());
        }
        ((IEntity)list.get(0)).copyTo((IDataObject)et, true);
        return true;
    }

    @Override
    public void getDraft(ET et) throws Exception {
        if (this.isUseServiceAPI()) {
            this.fillParentInfo(et);
            this.getServiceAPIClientModel().execute(this.getDEModel().getServiceAPIActionTag("DEACTION", "GETDRAFT"), (IEntity)et);
            return;
        }
        et.setSessionFactory(this.getSessionFactory());
        IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doGetDraft(this.getService(), 0, (IEntity)et, null).getResult() == 1) {
            return;
        }
        long nBeginTime = System.currentTimeMillis();
        if (iServicePlugin != null) {
            iServicePlugin.doGetDraft(this.getService(), 30, (IEntity)et, null);
        }
        this.onBeforeGetDraft(et);
        if (iServicePlugin != null) {
            iServicePlugin.doGetDraft(this.getService(), 31, (IEntity)et, null);
        }
        if (iServicePlugin == null || iServicePlugin.doGetDraft(this.getService(), 40, (IEntity)et, null).getResult() != 1) {
            this.fillParentInfo(et);
        }
        if (iServicePlugin != null) {
            iServicePlugin.doGetDraft(this.getService(), 60, (IEntity)et, null);
        }
        this.onAfterGetDraft(et);
        if (iServicePlugin != null) {
            iServicePlugin.doGetDraft(this.getService(), 61, (IEntity)et, null);
        }
        if (iServicePlugin != null) {
            iServicePlugin.doGetDraft(this.getService(), 99, (IEntity)et, null);
        }
        long nTime = System.currentTimeMillis() - nBeginTime;
        log.debug((Object)StringHelper.format("getDraft \u8017\u65f6[%1$s]", nTime));
    }

    @Override
    public void getDraftFrom(ET et) throws Exception {
        et.setSessionFactory(this.getSessionFactory());
        IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doGetDraftFrom(this.getService(), 0, (IEntity)et, null).getResult() == 1) {
            return;
        }
        long nBeginTime = System.currentTimeMillis();
        this.get(et);
        this.removeEntityUncopyValues(et, false);
        if (iServicePlugin != null) {
            iServicePlugin.doGetDraftFrom(this.getService(), 30, (IEntity)et, null);
        }
        this.onBeforeGetDraft(et);
        if (iServicePlugin != null) {
            iServicePlugin.doGetDraftFrom(this.getService(), 31, (IEntity)et, null);
        }
        if (iServicePlugin != null) {
            iServicePlugin.doGetDraftFrom(this.getService(), 60, (IEntity)et, null);
        }
        this.onAfterGetDraft(et);
        if (iServicePlugin != null) {
            iServicePlugin.doGetDraftFrom(this.getService(), 61, (IEntity)et, null);
        }
        if (iServicePlugin != null) {
            iServicePlugin.doGetDraftFrom(this.getService(), 99, (IEntity)et, null);
        }
        long nTime = System.currentTimeMillis() - nBeginTime;
        log.debug((Object)StringHelper.format("getDraftFrom \u8017\u65f6[%1$s]", nTime));
    }

    @Override
    public void getDraftTemp(ET et) throws Exception {
        if (this.isUseServiceAPI()) {
            this.fillParentInfo(et);
            this.getServiceAPIClientModel().execute(this.getDEModel().getServiceAPIActionTag("DEACTION", "GETDRAFTTEMP"), (IEntity)et);
            return;
        }
        et.setSessionFactory(this.getSessionFactory());
        long nBeginTime = System.currentTimeMillis();
        this.fillParentInfo(et);
        this.fillEntityKeyValue(et, true);
        if (this.checkKeyTemp(et) == 1) {
            this.getTemp(et);
            return;
        }
        long nTime = System.currentTimeMillis() - nBeginTime;
        ET et2 = et;
        this.doServiceWork(new IServiceWork((IEntity)et2){
            private final /* synthetic */ IEntity val$et2;
            {
                this.val$et2 = iEntity;
            }

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                EntityBase.setDraft(this.val$et2, true);
                ServiceBase.this.onBeforeGetDraftTemp(this.val$et2);
                ServiceBase.this.internalCreateTemp(this.val$et2);
                ServiceBase.this.onAfterGetDraftTemp(this.val$et2);
            }
        });
        log.debug((Object)StringHelper.format("getDraftTemp \u8017\u65f6[%1$s]", nTime));
    }

    @Override
    public void getDraftTempFrom(ET et) throws Exception {
        if (this.isUseServiceAPI()) {
            this.getServiceAPIClientModel().execute(this.getDEModel().getServiceAPIActionTag("DEACTION", "GETDRAFTTEMPFROM"), (IEntity)et);
            return;
        }
        et.setSessionFactory(this.getSessionFactory());
        ET et2 = et;
        this.doServiceWork(new IServiceWork((IEntity)et2){
            private final /* synthetic */ IEntity val$et2;
            {
                this.val$et2 = iEntity;
            }

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                CloneSession cloneSession = CloneSessionManager.getCurrentSession();
                cloneSession.setFromSource(true);
                cloneSession.setSourceObject(this.val$et2);
                ServiceBase.this.getTempMajor(this.val$et2);
            }
        });
    }

    @Override
    public void getDraftTempMajorFrom(ET et) throws Exception {
        if (this.isUseServiceAPI()) {
            this.getServiceAPIClientModel().execute(this.getDEModel().getServiceAPIActionTag("DEACTION", "GETDRAFTTEMPMAJORFROM"), (IEntity)et);
            return;
        }
        ET et2 = et;
        this.doServiceWork(new IServiceWork((IEntity)et2){
            private final /* synthetic */ IEntity val$et2;
            {
                this.val$et2 = iEntity;
            }

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                CloneSession cloneSession = CloneSessionManager.getCurrentSession();
                cloneSession.setFromSource(true);
                cloneSession.setSourceObject(this.val$et2);
                ServiceBase.this.getTempMajor(this.val$et2);
            }
        });
    }

    protected void onBeforeGetDraft(ET et) throws Exception {
        this.executeActionLogics("GETDRAFT", LOGICATTACHMODE_BEFORE, et);
    }

    protected void onAfterGetDraft(ET et) throws Exception {
        this.executeActionLogics("GETDRAFT", LOGICATTACHMODE_AFTER, et);
    }

    protected void onBeforeGetDraftTemp(ET et) throws Exception {
    }

    protected void onAfterGetDraftTemp(ET et) throws Exception {
    }

    protected void fillParentInfo(ET et) throws Exception {
        String strParentType = WebContext.getParentType(this.getWebContext());
        if (StringHelper.isNullOrEmpty(strParentType)) {
            return;
        }
        String strTypeParam = "";
        if (StringHelper.compare(strParentType, "DER1N", true) == 0) {
            strTypeParam = WebContext.getDER1NId(this.getWebContext());
        } else if (StringHelper.compare(strParentType, "SYSDER1N", true) == 0) {
            strTypeParam = WebContext.getDER1NId(this.getWebContext());
        }
        String strParentKey = WebContext.getParentKey(this.getWebContext());
        if (StringHelper.isNullOrEmpty(strParentKey)) {
            return;
        }
        this.onFillParentInfo(et, strParentType, strTypeParam, strParentKey);
    }

    protected void onFillParentInfo(ET et, String strParentType, String strTypeParam, String strParentKey) throws Exception {
    }

    @Override
    public boolean fillEntityKeyValue(ET et, boolean bTempMode) throws Exception {
        String strOriKey;
        String strKeyFieldName = this.getDEModel().getKeyDEField().getName();
        Object objValue = et.get(strKeyFieldName);
        if (objValue != null) {
            return true;
        }
        if (this.getDEModel().getUniTagDEField() != null) {
            if (StringHelper.compare(strKeyFieldName, this.getDEModel().getUniTagDEField().getName(), true) != 0 && (objValue = et.get(this.getDEModel().getUniTagDEField().getName())) != null) {
                return true;
            }
            if (bTempMode) {
                et.set(this.getDEModel().getUniTagDEField().getName(), TEMPKEY + KeyValueHelper.genGuidEx());
                return false;
            }
            objValue = et.get(ENTITYKEY);
            if (objValue != null) {
                et.set(this.getDEModel().getUniTagDEField().getName(), objValue);
                return true;
            }
        }
        boolean bRet = this.onFillEntityKeyValue(et, bTempMode);
        if (bTempMode && (strOriKey = et.get(strKeyFieldName).toString()).indexOf(TEMPKEY) != 0) {
            et.set(strKeyFieldName, TEMPKEY + strOriKey);
        }
        return bRet;
    }

    @Override
    public boolean fillEntityKeyValue(ET et) throws Exception {
        return this.fillEntityKeyValue(et, false);
    }

    protected boolean onFillEntityKeyValue(ET et, boolean bTempMode) throws Exception {
        if (!bTempMode && this.getDEModel().getUniTagDEField() != null && !this.getDEModel().getUniTagDEField().isEnableDBAutoValue()) {
            et.set(this.getDEModel().getUniTagDEField().getName(), KeyValueHelper.genGuidEx());
        }
        return false;
    }

    protected void fillEntityFullInfo(ET et, boolean bCreate) throws Exception {
        this.onFillEntityFullInfo(et, bCreate);
    }

    protected void onFillEntityFullInfo(ET et, boolean bCreate) throws Exception {
    }

    protected void writeBackParent(ET et, boolean bCreate) throws Exception {
        this.onWriteBackParent(et, bCreate);
    }

    protected void onWriteBackParent(ET et, boolean bCreate) throws Exception {
    }

    protected void checkEntity(ET et, boolean bCreate, boolean bTempMode) throws Exception {
        EntityError entityError = new EntityError();
        IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCheckEntity(this.getService(), 0, (IEntity)et, bCreate, bTempMode, entityError, null).getResult() == 1) {
            return;
        }
        if (iServicePlugin == null || iServicePlugin.doCheckEntity(this.getService(), 40, (IEntity)et, bCreate, bTempMode, entityError, null).getResult() != 1) {
            this.onCheckEntity(true, et, bCreate, bTempMode, entityError);
        }
        if (entityError.hasError()) {
            this.convertEntityError(entityError);
            throw new EntityException(entityError, this.getDEModel());
        }
        if (iServicePlugin == null || iServicePlugin.doCheckEntity(this.getService(), 45, (IEntity)et, bCreate, bTempMode, entityError, null).getResult() != 1) {
            this.onCheckEntity(false, et, bCreate, bTempMode, entityError);
        }
        if (entityError.hasError()) {
            this.convertEntityError(entityError);
            throw new EntityException(entityError, this.getDEModel());
        }
        if (iServicePlugin != null) {
            iServicePlugin.doCheckEntity(this.getService(), 99, (IEntity)et, bCreate, bTempMode, entityError, null);
        }
    }

    protected void convertEntityError(EntityError entityError) throws Exception {
        for (EntityFieldError entityFieldError : entityError.getEntityFieldErrorList()) {
            this.convertEntityFieldError(entityFieldError);
        }
    }

    protected void convertEntityFieldError(EntityFieldError entityFieldError) throws Exception {
        IDEField iDEField;
        ICtrlHandler iCtrlHandler;
        if (!StringHelper.isNullOrEmpty(entityFieldError.getFieldName()) && StringHelper.isNullOrEmpty(entityFieldError.getFieldLogicName()) && (iCtrlHandler = CtrlHandler.getCurrent()) != null) {
            iCtrlHandler.convertEntityFieldError(entityFieldError);
        }
        if (!StringHelper.isNullOrEmpty(entityFieldError.getFieldName()) && StringHelper.isNullOrEmpty(entityFieldError.getFieldLogicName()) && (iDEField = this.getDEModel().getDEField(entityFieldError.getFieldName(), true)) != null) {
            entityFieldError.setFieldLogicName(iDEField.getLogicName());
        }
    }

    protected void onCheckEntity(boolean bBaseMode, ET et, boolean bCreate, boolean bTempMode, EntityError entityError) throws Exception {
    }

    protected void doServiceWork(IServiceWork iServiceWork) throws Exception {
        this.doServiceWork(-1, iServiceWork, true);
    }

    protected void doServiceWork(IServiceWork iServiceWork, boolean bTransaction) throws Exception {
        this.doServiceWork(-1, iServiceWork, bTransaction);
    }

    protected void doServiceWork(int nMode, IServiceWork iServiceWork, boolean bTransaction) throws Exception {
        boolean bOpenCloneSession;
        boolean bOpenActionSession;
        long nBeginTime = System.currentTimeMillis();
        boolean bl = bOpenActionSession = ActionSessionManager.getCurrentSession() == null;
        if (bOpenActionSession) {
            ActionSessionManager.openSession().setName(this.getDEModel().getName());
        }
        boolean bl2 = bOpenCloneSession = CloneSessionManager.getCurrentSession() == null;
        if (bOpenCloneSession) {
            CloneSessionManager.openSession().setOwner(this.getDEModel().getName());
        }
        int nLastRef = 0;
        try {
            nLastRef = SessionFactoryManager.addRef();
            if (bTransaction && this.getRealSessionFactory() != null) {
                Transaction curTransaction = SessionFactoryManager.getCurrentTransaction(this.getRealSessionFactory());
                iServiceWork.execute(new HibernateTransaction(curTransaction));
            } else {
                iServiceWork.execute(null);
            }
            if (nLastRef != SessionFactoryManager.releaseRef(true) + 1) {
                log.warn((Object)StringHelper.format("\u5b9e\u4f53\u670d\u52a1[%1$s]\u4f1a\u8bdd\u5de5\u5382\u5f15\u7528\u8ba1\u6570\u6267\u884c\u524d\u540e\u4e0d\u4e00\u81f4\uff0c\u53ef\u80fd\u5b58\u5728\u6570\u636e\u9501\u95ee\u9898", this.getDEModel().getName()));
            }
            if (bOpenActionSession) {
                ActionSessionManager.closeSession();
            }
            if (bOpenCloneSession) {
                CloneSessionManager.closeSession();
            }
        }
        catch (Exception ex) {
            if (bOpenActionSession) {
                this.getSystemModel().logException(this, ex, null, null);
            }
            Exception exception = ex;
            String strMessage = ex.getMessage();
            if (ex.getCause() != null && ex.getCause() instanceof Exception) {
                exception = (Exception)ex.getCause();
                strMessage = exception.getMessage();
            }
            log.error((Object)StringHelper.format("\u5b9e\u4f53[%1$s]doServiceWork\u53d1\u751f\u5f02\u5e38\uff0c%2$s", this.getDEModel().getName(), strMessage), (Throwable)ex);
            if (nLastRef != SessionFactoryManager.releaseRef(false) + 1) {
                log.warn((Object)StringHelper.format("\u5b9e\u4f53\u670d\u52a1[%1$s]\u4f1a\u8bdd\u5de5\u5382\u5f15\u7528\u8ba1\u6570\u6267\u884c\u524d\u540e\u4e0d\u4e00\u81f4\uff0c\u53ef\u80fd\u5b58\u5728\u6570\u636e\u9501\u95ee\u9898", this.getDEModel().getName()));
            }
            if (bOpenActionSession) {
                ActionSessionManager.closeSession();
            }
            if (bOpenCloneSession) {
                CloneSessionManager.closeSession();
            }
            throw ex;
        }
        long nTime = System.currentTimeMillis() - nBeginTime;
        log.debug((Object)StringHelper.format("\u4f5c\u4e1a \u8017\u65f6[%1$s]", nTime));
    }

    protected DBFetchResult doServiceFetchWork(IDEDataSetFetchContext iDEDataSetFetchContext, String strDEDataSetName, boolean bTempMode) throws Exception {
        IDEDataSet iDEDataSet;
        long nBeginTime = System.currentTimeMillis();
        if (iDEDataSetFetchContext.getActiveDataObject() == null && (iDEDataSet = this.getDEModel().getDEDataSet(strDEDataSetName, true)) != null && !StringHelper.isNullOrEmpty(iDEDataSet.getActiveDataDELogicId())) {
            ET et = this.getDEModel().createEntity();
            this.executeLogic(iDEDataSet.getActiveDataDELogicId(), (IEntity)et);
            iDEDataSetFetchContext.setActiveDataObject((ISimpleDataObject)et);
        }
        if (this.isUseServiceAPI()) {
            FetchResult fetchResult = null;
            fetchResult = !bTempMode ? this.getServiceAPIClientModel().fetch(this.getDEModel().getServiceAPIActionTag("FETCH", strDEDataSetName), iDEDataSetFetchContext) : this.getServiceAPIClientModel().fetch(this.getDEModel().getServiceAPIActionTag("FETCHTEMP", strDEDataSetName), iDEDataSetFetchContext);
            DBFetchResult dbFetchResult = new DBFetchResult();
            dbFetchResult.setTotalRow(fetchResult.getTotalRow());
            SimpleDataSetImpl simpleDataSetImpl = new SimpleDataSetImpl();
            SimpleDataTableImpl simpleDataTableImpl = new SimpleDataTableImpl(simpleDataSetImpl);
            simpleDataSetImpl.addDataTable(simpleDataTableImpl);
            ArrayList<IDataRow> list = fetchResult.getDataRows();
            for (IDataRow iDataRow : list) {
                simpleDataTableImpl.addCachedRow(iDataRow);
            }
            dbFetchResult.setDataSet(simpleDataSetImpl);
            long nTime = System.currentTimeMillis() - nBeginTime;
            log.debug((Object)StringHelper.format("\u63a5\u53e3\u67e5\u8be2\u8017\u65f6[%1$s]", nTime));
            return dbFetchResult;
        }
        try {
            switch (this.getDEModel().getStorageMode()) {
                case 0: {
                    throw new ErrorException(1, "\u5f53\u524d\u5b9e\u4f53\u4e0d\u652f\u6301\u5b58\u50a8", this.getDEModel());
                }
                case 1: {
                    IDEDataSetModel iDEDataSetModel;
                    SessionFactoryManager.addRef();
                    if (!bTempMode && (iDEDataSet = this.getDEModel().getDEDataSet(strDEDataSetName)) instanceof IDEDataSetModel && !(iDEDataSetModel = (IDEDataSetModel)iDEDataSet).isCustomDS() && iDEDataSetModel.isEnableDEDataRange()) {
                        iDEDataSetModel.fillDEDataSetFetchDataRange(this, this.getWebContext(), iDEDataSetFetchContext);
                    }
                    DBFetchResult dbFetchResult = this.getDAO(this.getDEModel().getStorageMode()).fetchDEDataSet(iDEDataSetFetchContext, strDEDataSetName, bTempMode);
                    SessionFactoryManager.releaseRef(false);
                    long nTime = System.currentTimeMillis() - nBeginTime;
                    log.debug((Object)StringHelper.format("\u67e5\u8be2\u8017\u65f6[%1$s]", nTime));
                    return dbFetchResult;
                }
                case 2: {
                    DBFetchResult dbFetchResult = this.getDAO(this.getDEModel().getStorageMode()).fetchDEDataSet(iDEDataSetFetchContext, strDEDataSetName, bTempMode);
                    long nTime = System.currentTimeMillis() - nBeginTime;
                    log.debug((Object)StringHelper.format("\u67e5\u8be2\u8017\u65f6[%1$s]", nTime));
                    return dbFetchResult;
                }
                case 3: {
                    throw new ErrorException(1, "\u5f53\u524d\u5b9e\u4f53\u4e0d\u652f\u6301\u6df7\u5408\u5b58\u50a8", this.getDEModel());
                }
            }
            throw new ErrorException(1, StringHelper.format("\u4e0d\u652f\u6301\u7684\u5b9e\u4f53\u5b58\u50a8\u6a21\u5f0f[%1$s]", this.getDEModel().getStorageMode()), this.getDEModel());
        }
        catch (Exception ex) {
            Exception exception = ex;
            String strMessage = ex.getMessage();
            if (ex.getCause() != null && ex.getCause() instanceof Exception) {
                exception = (Exception)ex.getCause();
                strMessage = exception.getMessage();
            }
            log.error((Object)StringHelper.format("\u5b9e\u4f53[%1$s]doServiceFetchWork\u53d1\u751f\u5f02\u5e38\uff0c%2$s", this.getDEModel().getName(), strMessage), (Throwable)ex);
            SessionFactoryManager.releaseRef(false);
            throw exception;
        }
    }

    @Override
    public void getTemp(ET et2) throws Exception {
        if (this.isUseServiceAPI()) {
            this.getServiceAPIClientModel().execute(this.getDEModel().getServiceAPIActionTag("DEACTION", "GETTEMP"), (IEntity)et2);
            return;
        }
        ET et = et2;
        long nBeginTime = System.currentTimeMillis();
        this.doServiceWork(new IServiceWork((IEntity)et, nBeginTime){
            private final /* synthetic */ IEntity val$et;
            private final /* synthetic */ long val$nBeginTime;
            {
                this.val$et = iEntity;
                this.val$nBeginTime = l;
            }

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                ServiceBase.this.internalGetTemp(this.val$et, false);
                ServiceBase.this.onAfterGetTemp(this.val$et);
                long nTime = System.currentTimeMillis() - this.val$nBeginTime;
                log.debug((Object)StringHelper.format("getTemp  \u8017\u65f6[%1$s]", nTime));
            }
        });
    }

    @Override
    public ET getCache(Object objKeyValue) throws Exception {
        if (this.isEnableEntityCache()) {
            Object objValue;
            Object curState = this.getUniStateModel().get(objKeyValue, null);
            if (this.getUniStateModel().contains(objKeyValue) && (objValue = this.getCacheManager().getData(objKeyValue.toString(), curState)) != null) {
                return (ET)((IEntity)objValue);
            }
            ET et = this.getDEModel().createEntity();
            et.set(this.getDEModel().getKeyDEField().getName(), objKeyValue);
            this.get(et);
            this.getCacheManager().updateData(objKeyValue.toString(), curState, et);
            return et;
        }
        ET et = this.getDEModel().createEntity();
        et.set(this.getDEModel().getKeyDEField().getName(), objKeyValue);
        this.get(et);
        return et;
    }

    @Override
    public void getCache(ET et) throws Exception {
        Object objKeyValue;
        if (this.isEnableEntityCache() && (objKeyValue = et.get(this.getDEModel().getKeyDEField().getName())) != null) {
            Object objValue;
            Object curState = this.getUniStateModel().get(objKeyValue, null);
            if (this.getUniStateModel().contains(objKeyValue) && (objValue = this.getCacheManager().getData(objKeyValue.toString(), curState)) != null) {
                ((IEntity)objValue).copyTo((IDataObject)et, true);
                return;
            }
            this.get(et);
            ET iEntity = this.getDEModel().createEntity();
            et.copyTo((IDataObject)iEntity, false);
            this.getCacheManager().updateData(objKeyValue.toString(), curState, iEntity);
            return;
        }
        this.get(et);
    }

    @Override
    public void resetCache() {
        try {
            if (this.isEnableEntityCache()) {
                this.getCacheManager().removeAll();
            }
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    protected void setLast(IEntity et, IEntity last, boolean bReplace) throws Exception {
        final IEntity curEntity = et;
        final IEntity lastEntity = last;
        final boolean bReplace2 = bReplace;
        this.doServiceWork(new IServiceWork(){

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                SessionFactorySession sessionFactorySession = SessionFactoryManager.getCurrentSFS(ServiceBase.this.getSessionFactory());
                if (!bReplace2 && sessionFactorySession.getLastEntity(curEntity) != null) {
                    return;
                }
                sessionFactorySession.setLastEntity(curEntity, lastEntity, ServiceBase.this.getRealSessionFactory());
            }
        }, false);
    }

    protected ET getLast(IEntity et) throws Exception {
        return this.getLast(et, false);
    }

    protected ET getLast(IEntity et, boolean bTry) throws Exception {
        final String strKey = DataObject.getStringValue(et, this.getDEModel().getKeyDEField().getName(), null);
        if (StringHelper.isNullOrEmpty(strKey)) {
            return null;
        }
        final IEntity curEntity = et;
        final CallResult callResult = new CallResult();
        final boolean bTry2 = bTry;
        this.doServiceWork(new IServiceWork(){

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                SessionFactorySession sessionFactorySession = SessionFactoryManager.getCurrentSFS(ServiceBase.this.getSessionFactory());
                IEntity lastEntity2 = sessionFactorySession.getLastEntity(curEntity);
                if (lastEntity2 != null) {
                    if (lastEntity2 == INVALIDLAST) {
                        if (bTry2) {
                            return;
                        }
                        throw new ErrorException(3, ServiceBase.this.getLocalization(ServiceBase.MSG_GETLAST_NOTCACHED, StringHelper.format("\u53d8\u66f4\u4e4b\u524d\u6570\u636e\u65e0\u6548\uff0c\u6ca1\u6709\u5728\u6570\u636e\u53d8\u66f4\u4e4b\u524d\u8fdb\u884c\u7f13\u5b58")), ServiceBase.this.getDEModel());
                    }
                    if (lastEntity2 != EMPTYLAST) {
                        callResult.setUserObject(lastEntity2);
                    }
                    return;
                }
                Object lastEntity = ServiceBase.this.getDEModel().createEntity();
                lastEntity.set(ServiceBase.this.getDEModel().getKeyDEField().getName(), curEntity.get(ServiceBase.this.getDEModel().getKeyDEField().getName()));
                if (strKey.indexOf(ServiceBase.TEMPKEY) == 0) {
                    ServiceBase.this.getTemp(lastEntity);
                } else {
                    ServiceBase.this.getCache(lastEntity);
                }
                sessionFactorySession.setLastEntity(curEntity, (IEntity)lastEntity, ServiceBase.this.getRealSessionFactory());
                callResult.setUserObject(lastEntity);
            }
        }, false);
        if (callResult.getUserObject() == null) {
            return null;
        }
        return (ET)((IEntity)callResult.getUserObject());
    }

    protected void resetLast(IEntity et) throws Exception {
        final IEntity curEntity = et;
        this.doServiceWork(new IServiceWork(){

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                SessionFactorySession sessionFactorySession = SessionFactoryManager.getCurrentSFS(ServiceBase.this.getSessionFactory());
                sessionFactorySession.resetLastEntity(curEntity);
            }
        }, false);
    }

    protected void onAfterGetTemp(ET et) throws Exception {
    }

    @Override
    public void updateTemp(ET entity) throws Exception {
        this.updateTemp(entity, true);
    }

    @Override
    public void updateTemp(ET entity, boolean bGet) throws Exception {
        if (this.isUseServiceAPI()) {
            this.getServiceAPIClientModel().execute(this.getDEModel().getServiceAPIActionTag("DEACTION", "UPDATETEMP"), (IEntity)entity);
            return;
        }
        ET et = entity;
        boolean bGet2 = bGet;
        boolean bIgnoreCheck = EntityBase.isIgnoreCheck(et);
        et.setSessionFactory(this.getSessionFactory());
        if (et.get(this.getDEModel().getKeyDEField().getName()) == null && !this.fillEntityKeyValue(et, true)) {
            throw new ErrorException(4, this.getDEModel());
        }
        this.onTestUpdateTemp(et);
        log.debug((Object)"\u5f00\u59cb[updateTemp]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork((IEntity)et, bIgnoreCheck, bGet2){
            private final /* synthetic */ IEntity val$et;
            private final /* synthetic */ boolean val$bIgnoreCheck;
            private final /* synthetic */ boolean val$bGet2;
            {
                this.val$et = iEntity;
                this.val$bIgnoreCheck = bl;
                this.val$bGet2 = bl2;
            }

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                if (ServiceBase.this.isPrepareLastForUpdate()) {
                    Object ET = ServiceBase.this.getLast(this.val$et);
                }
                ServiceBase.this.writeBackParent(this.val$et, false);
                ServiceBase.this.fillEntityFullInfo(this.val$et, false);
                ServiceBase.this.onBeforeUpdateTemp(this.val$et);
                if (!this.val$bIgnoreCheck) {
                    ServiceBase.this.checkEntity(this.val$et, false, true);
                }
                ServiceBase.this.setLast(this.val$et, INVALIDLAST, false);
                ServiceBase.this.internalUpdateTemp(this.val$et);
                if (this.val$bGet2) {
                    ServiceBase.this.internalGetTemp(this.val$et, false);
                }
                if (ServiceBase.this.isNeedUpdateParent()) {
                    ServiceBase.this.updateParent(this.val$et);
                }
                ServiceBase.this.onAfterUpdateTemp(this.val$et);
            }
        });
    }

    @Override
    public void sysUpdateTemp(ET entity, boolean bGet) throws Exception {
        ET et = entity;
        boolean bGet2 = bGet || this.isNeedUpdateParent();
        boolean bIgnoreCheck = EntityBase.isIgnoreCheck(et);
        et.setSessionFactory(this.getSessionFactory());
        if (et.get(this.getDEModel().getKeyDEField().getName()) == null && !this.fillEntityKeyValue(et, true)) {
            throw new ErrorException(4, this.getDEModel());
        }
        this.onTestUpdateTemp(et);
        log.debug((Object)"\u5f00\u59cb[updateTemp]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork((IEntity)et, bIgnoreCheck, bGet2){
            private final /* synthetic */ IEntity val$et;
            private final /* synthetic */ boolean val$bIgnoreCheck;
            private final /* synthetic */ boolean val$bGet2;
            {
                this.val$et = iEntity;
                this.val$bIgnoreCheck = bl;
                this.val$bGet2 = bl2;
            }

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                ServiceBase.this.writeBackParent(this.val$et, false);
                ServiceBase.this.fillEntityFullInfo(this.val$et, false);
                if (!this.val$bIgnoreCheck) {
                    ServiceBase.this.checkEntity(this.val$et, false, true);
                }
                ServiceBase.this.internalSysUpdateTemp(this.val$et);
                if (this.val$bGet2) {
                    ServiceBase.this.internalGetTemp(this.val$et, false);
                }
                if (ServiceBase.this.isNeedUpdateParent()) {
                    ServiceBase.this.updateParent(this.val$et);
                }
            }
        });
    }

    protected void internalUpdateTemp(ET entity) throws Exception {
        DBCallResult dbCallResult = this.getDAO().executeUpdateSql(null, entity, true);
        if (dbCallResult.isError()) {
            throw new ErrorException(1, dbCallResult.getErrorInfo(), this.getDEModel());
        }
    }

    protected void onTestUpdateTemp(ET et) throws Exception {
    }

    protected void onBeforeUpdateTemp(ET et) throws Exception {
        this.executeActionLogics("UPDATETEMP", LOGICATTACHMODE_BEFORE, et);
    }

    protected void onAfterUpdateTemp(ET et) throws Exception {
        this.executeActionLogics("UPDATETEMP", LOGICATTACHMODE_AFTER, et);
    }

    @Override
    public void createTemp(ET et) throws Exception {
        if (this.isUseServiceAPI()) {
            this.getServiceAPIClientModel().execute(this.getDEModel().getServiceAPIActionTag("DEACTION", "CREATETEMP"), (IEntity)et);
            return;
        }
        et.setSessionFactory(this.getSessionFactory());
        this.onTestCreateTemp(et);
        String strKey = (String)et.get(this.getDEModel().getKeyDEField().getName());
        boolean bUpdate = !StringHelper.isNullOrEmpty(strKey);
        boolean bIgnoreCheck = EntityBase.isIgnoreCheck(et);
        if (StringHelper.isNullOrEmpty(strKey)) {
            this.fillEntityKeyValue(et, true);
        }
        EntityBase.setDraft(et, false);
        ET et2 = et;
        this.doServiceWork(new IServiceWork((IEntity)et2, bIgnoreCheck, bUpdate){
            private final /* synthetic */ IEntity val$et2;
            private final /* synthetic */ boolean val$bIgnoreCheck;
            private final /* synthetic */ boolean val$bUpdate;
            {
                this.val$et2 = iEntity;
                this.val$bIgnoreCheck = bl;
                this.val$bUpdate = bl2;
            }

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                ServiceBase.this.setLast(this.val$et2, EMPTYLAST, true);
                ServiceBase.this.writeBackParent(this.val$et2, true);
                ServiceBase.this.fillEntityFullInfo(this.val$et2, true);
                ServiceBase.this.onBeforeCreateTemp(this.val$et2);
                if (!this.val$bIgnoreCheck) {
                    ServiceBase.this.checkEntity(this.val$et2, true, true);
                }
                if (this.val$bUpdate) {
                    ServiceBase.this.internalUpdateTemp(this.val$et2);
                } else {
                    ServiceBase.this.internalCreateTemp(this.val$et2);
                }
                ServiceBase.this.internalGetTemp(this.val$et2, false);
                if (ServiceBase.this.isNeedUpdateParent()) {
                    ServiceBase.this.updateParent(this.val$et2);
                }
                ServiceBase.this.onAfterCreateTemp(this.val$et2);
            }
        });
    }

    protected void onTestCreateTemp(ET et) throws Exception {
    }

    protected void onBeforeCreateTemp(ET et) throws Exception {
        this.executeActionLogics("CREATETEMP", LOGICATTACHMODE_BEFORE, et);
    }

    protected void onAfterCreateTemp(ET et) throws Exception {
        this.executeActionLogics("CREATETEMP", LOGICATTACHMODE_AFTER, et);
    }

    @Override
    public void removeTemp(ArrayList<ET> entityList) throws Exception {
        if (this.isUseServiceAPI()) {
            for (IEntity et : entityList) {
                this.removeTemp(et);
            }
            return;
        }
        final ArrayList<ET> list = entityList;
        log.debug((Object)"\u5f00\u59cb[remove]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork(){

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                ServiceBase.this.onBeforeRemoveTemp(list);
                ServiceBase.this.internalRemoveTemp(list);
                ServiceBase.this.onAfterRemoveTemp(list);
            }
        });
    }

    protected void onBeforeRemoveTemp(ArrayList<ET> list) throws Exception {
    }

    protected void onAfterRemoveTemp(ArrayList<ET> list) throws Exception {
    }

    protected void internalRemoveTemp(ArrayList<ET> list) throws Exception {
        for (IEntity et : list) {
            this.removeTemp(et);
        }
    }

    @Override
    public void removeTemp(ET entity) throws Exception {
        if (this.isUseServiceAPI()) {
            this.getServiceAPIClientModel().execute(this.getDEModel().getServiceAPIActionTag("DEACTION", "REMOVETEMP"), (IEntity)entity);
            return;
        }
        ET et = entity;
        et.setSessionFactory(this.getSessionFactory());
        this.onTestRemoveTemp(entity);
        log.debug((Object)"\u5f00\u59cb[removeTemp]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork((IEntity)et){
            private final /* synthetic */ IEntity val$et;
            {
                this.val$et = iEntity;
            }

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                Object objKeyValue = this.val$et.get(ServiceBase.this.getDEModel().getKeyDEField().getName());
                if (!ActionSessionManager.getCurrentSession().registerRecursion("REMOVE", ServiceBase.this.getDEModel().getId(), objKeyValue)) {
                    return;
                }
                Object last = null;
                if (ServiceBase.this.isPrepareLastForRemove() || ServiceBase.this.isNeedUpdateParent()) {
                    last = ServiceBase.this.getLast(this.val$et);
                }
                ServiceBase.this.onBeforeRemoveTemp(this.val$et);
                ServiceBase.this.internalRemoveTemp(this.val$et);
                if (ServiceBase.this.isNeedUpdateParent()) {
                    ServiceBase.this.updateParent(last);
                }
                ServiceBase.this.onAfterRemoveTemp(this.val$et);
            }
        });
    }

    protected void internalRemoveTemp(ET et) throws Exception {
        DBCallResult dbCallResult = this.getDAO().executeRemoveSql(null, et, true);
        if (dbCallResult.isError()) {
            throw new ErrorException(1, dbCallResult.getErrorInfo(), this.getDEModel());
        }
    }

    protected void onTestRemoveTemp(ET et) throws Exception {
    }

    protected void onBeforeRemoveTemp(ET et) throws Exception {
        this.executeActionLogics("REMOVETEMP", LOGICATTACHMODE_BEFORE, et);
    }

    protected void onAfterRemoveTemp(ET et) throws Exception {
        this.executeActionLogics("REMOVETEMP", LOGICATTACHMODE_AFTER, et);
    }

    public void getTempMajor(ET et) throws Exception {
        if (this.isUseServiceAPI()) {
            this.getServiceAPIClientModel().execute(this.getDEModel().getServiceAPIActionTag("DEACTION", "GETTEMPMAJOR"), (IEntity)et);
            return;
        }
        ET et2 = et;
        this.doServiceWork(new IServiceWork((IEntity)et2){
            private final /* synthetic */ IEntity val$et2;
            {
                this.val$et2 = iEntity;
            }

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                Object tempET = ServiceBase.this.getDEModel().createEntity();
                this.val$et2.copyTo((IDataObject)tempET, false);
                boolean bFromTemp = false;
                if (!this.val$et2.isFullEntity()) {
                    String strKeyValue = (String)tempET.get(ServiceBase.this.getDEModel().getKeyDEField().getName());
                    if (strKeyValue.indexOf(ServiceBase.TEMPKEY) == 0) {
                        ServiceBase.this.getTemp(tempET);
                        bFromTemp = true;
                    } else {
                        ServiceBase.this.get(tempET);
                    }
                }
                CloneSession cloneSession = CloneSessionManager.getCurrentSession();
                tempET.remove(ServiceBase.this.getDEModel().getKeyDEField().getName());
                ServiceBase.this.replaceParentInfo(tempET, cloneSession);
                ServiceBase.this.fillEntityKeyValue(tempET, true);
                if (!cloneSession.isFromSource()) {
                    tempET.set("srforikey", this.val$et2.get(ServiceBase.this.getDEModel().getKeyDEField().getName()));
                } else {
                    tempET.remove("srforikey");
                    if (bFromTemp) {
                        if (cloneSession.getSourceObject() == this.val$et2) {
                            EntityBase.setDraft(tempET, true);
                        } else {
                            EntityBase.setDraft(tempET, false);
                        }
                    } else {
                        EntityBase.setDraft(tempET, false);
                    }
                }
                ServiceBase.this.internalCreateTemp(tempET);
                ServiceBase.this.beginMergeChild(tempET);
                cloneSession.setEntity(ServiceBase.this.getDEModel(), this.val$et2.get(ServiceBase.this.getDEModel().getKeyDEField().getName()), (IEntity)tempET);
                ServiceBase.this.getRelatedDataTempMajor(this.val$et2);
                ServiceBase.this.endMergeChild(tempET, true);
                tempET.copyTo(this.val$et2, true);
            }
        });
    }

    protected void getRelatedDataTempMajor(ET et) throws Exception {
    }

    public void getDraftTempMajor(ET et) throws Exception {
        this.getDraftTemp(et);
    }

    public void createTempMajor(ET et) throws Exception {
        this.updateTempMajor(et);
    }

    public void updateTempMajor(ET et) throws Exception {
        if (this.isUseServiceAPI()) {
            this.getServiceAPIClientModel().execute(this.getDEModel().getServiceAPIActionTag("DEACTION", "UPDATETEMPMAJOR"), (IEntity)et);
            return;
        }
        ET et2 = et;
        et2.setSessionFactory(this.getSessionFactory());
        Object strSourceKey = et.get(SOURCEKEY);
        Object objEntityKey = et.get(ENTITYKEY);
        this.doServiceWork(new IServiceWork((IEntity)et2, objEntityKey, strSourceKey){
            private final /* synthetic */ IEntity val$et2;
            private final /* synthetic */ Object val$objEntityKey;
            private final /* synthetic */ Object val$strSourceKey;
            {
                this.val$et2 = iEntity;
                this.val$objEntityKey = object;
                this.val$strSourceKey = object2;
            }

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                CloneSession cloneSession = CloneSessionManager.getCurrentSession();
                Object objLastUpdateDate = this.val$et2.get("srfupdatedate");
                ServiceBase.this.updateTemp(this.val$et2);
                Object oriET = ServiceBase.this.getDEModel().createEntity();
                this.val$et2.copyTo((IDataObject)oriET, false);
                oriET.remove(ServiceBase.this.getDEModel().getKeyDEField().getName());
                ServiceBase.this.replaceParentInfo(oriET, cloneSession);
                JSONObject jo = new JSONObject();
                oriET.fillJSONObject(jo, false);
                Iterator keys = jo.keys();
                while (keys.hasNext()) {
                    String strKey = (String)keys.next();
                    Object objValue = jo.get(strKey);
                    if (objValue == null || !(objValue instanceof String) || !KeyValueHelper.isTempKey((String)objValue)) continue;
                    log.warn((Object)StringHelper.format("\u4e34\u65f6\u6570\u636e[%1$s]\u5c5e\u6027[%2$s]\u4e3a\u4e34\u65f6\u6570\u636e", ServiceBase.this.getDEModel().getName(), strKey));
                    return;
                }
                Object oriKey = this.val$et2.get(ServiceBase.ORIGINKEY);
                if (this.val$objEntityKey != null) {
                    oriET.set(ServiceBase.ENTITYKEY, this.val$objEntityKey);
                }
                if (StringHelper.isNullOrEmpty(oriKey)) {
                    ServiceBase.this.create(oriET);
                    this.val$et2.set(ServiceBase.ORIGINKEY, oriET.get(ServiceBase.this.getDEModel().getKeyDEField().getName()));
                    HashMap<String, Object> valueMap = new HashMap<String, Object>();
                    oriET.fillMap(valueMap, false);
                    for (String strKey : valueMap.keySet()) {
                        Object objValue2;
                        Object objValue = valueMap.get(strKey);
                        if (!this.val$et2.contains(strKey) || (objValue2 = this.val$et2.get(strKey)) != null || objValue == null) continue;
                        this.val$et2.set(strKey, objValue);
                    }
                    ServiceBase.this.updateTemp(this.val$et2);
                } else {
                    if (objLastUpdateDate != null) {
                        oriET.set("srfupdatedate", objLastUpdateDate);
                    }
                    oriET.set(ServiceBase.this.getDEModel().getKeyDEField().getName(), oriKey);
                    ServiceBase.this.update(oriET);
                    if (objLastUpdateDate != null) {
                        oriET.set("srfupdatedate", objLastUpdateDate);
                    }
                }
                cloneSession.setEntity(ServiceBase.this.getDEModel(), this.val$et2.get(ServiceBase.this.getDEModel().getKeyDEField().getName()), (IEntity)oriET);
                ServiceBase.this.beginMergeChild(oriET);
                ServiceBase.this.updateRelatedDataTempMajor(this.val$et2, oriET);
                if (StringHelper.isNullOrEmpty(oriKey) && !StringHelper.isNullOrEmpty(this.val$strSourceKey)) {
                    ServiceBase.this.copyDetails(oriET, this.val$strSourceKey);
                }
                ServiceBase.this.endMergeChild(oriET, true);
                ServiceBase.this.onAfterUpdateTempMajor(oriET);
                this.val$et2.set(ServiceBase.this.getDEModel().getUpdateDateDEField().getName(), oriET.get(ServiceBase.this.getDEModel().getUpdateDateDEField().getName()));
            }
        });
    }

    protected void onAfterUpdateTempMajor(ET et) throws Exception {
    }

    protected void updateRelatedDataTempMajor(ET tempET, ET oriET) throws Exception {
    }

    public void removeTempMajor(ET et) throws Exception {
        if (this.isUseServiceAPI()) {
            this.getServiceAPIClientModel().execute(this.getDEModel().getServiceAPIActionTag("DEACTION", "REMOVETEMPMAJOR"), (IEntity)et);
            return;
        }
        Object oriKey = et.get(ORIGINKEY);
        if (oriKey == null) {
            this.getTemp(et);
            oriKey = et.get(ORIGINKEY);
        }
        et.set(this.getDEModel().getKeyDEField().getName(), oriKey);
        this.remove(et);
    }

    @Override
    public ET clone(ET et) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[clone]");
    }

    @Override
    public ET cloneToTemp(ET et) throws Exception {
        boolean bCloseSession = false;
        CloneSession cloneSession = CloneSessionManager.getCurrentSession();
        if (cloneSession == null) {
            cloneSession = CloneSessionManager.openSession();
            cloneSession.setOwner(this.getDEModel().getName());
            bCloseSession = true;
        }
        try {
            ET et2 = this.getDEModel().createEntity();
            et.copyTo((IDataObject)et2, false);
            if (!et.isFullEntity()) {
                this.get(et2);
            }
            et2.remove(this.getDEModel().getKeyDEField().getName());
            this.replaceParentInfo(et2, cloneSession);
            this.createTemp(et2);
            Class entityClass = (Class)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
            cloneSession.setEntity(this.getDEModel(), et.get(this.getDEModel().getKeyDEField().getName()), (IEntity)et2);
            this.onAfterCloneToTemp(et2, et, cloneSession);
            if (bCloseSession) {
                CloneSessionManager.closeSession();
            }
            return et2;
        }
        catch (Exception ex) {
            if (bCloseSession) {
                CloneSessionManager.closeSession();
            }
            throw ex;
        }
    }

    protected void replaceParentInfo(ET et, CloneSession cloneSession) throws Exception {
    }

    protected void onAfterCloneToTemp(ET newET, ET srcET, CloneSession cloneSession) throws Exception {
    }

    @Override
    public ET cloneTemp(ET et) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[cloneTemp]");
    }

    @Override
    public int checkKey(ET et3) throws Exception {
        ET et = et3;
        ET et2 = this.getDEModel().createEntity();
        et.copyTo((IDataObject)et2, false);
        if (this.isUseServiceAPI()) {
            this.getServiceAPIClientModel().execute(this.getDEModel().getServiceAPIActionTag("DEACTION", "CHECKKEY"), (IEntity)et2);
            et.set("srfret", et2.get("srfret"));
            return (Integer)et.get("srfret");
        }
        et2.setSessionFactory(this.getSessionFactory());
        this.doServiceWork(new IServiceWork((IEntity)et2, (IEntity)et){
            private final /* synthetic */ IEntity val$et2;
            private final /* synthetic */ IEntity val$et;
            {
                this.val$et2 = iEntity;
                this.val$et = iEntity2;
            }

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                if (ServiceBase.this.getDEModel().getKeyDEField().isPhisicalDEField()) {
                    if (this.val$et2.get(ServiceBase.this.getDEModel().getKeyDEField().getName()) == null && !ServiceBase.this.fillEntityKeyValue(this.val$et2, false)) {
                        this.val$et.set("srfret", 0);
                        return;
                    }
                    DBCallResult dbCallResult = ServiceBase.this.getDAO().executeCheckKeySql(null, this.val$et2, false);
                    if (dbCallResult.isError()) {
                        throw new ErrorException(1, dbCallResult.getErrorInfo(), ServiceBase.this.getDEModel());
                    }
                    if (dbCallResult.isOk()) {
                        dbCallResult.getDataSet().cacheDataRow();
                    }
                    if (dbCallResult.getDataSet().getDataTableCount() == 0 || dbCallResult.getDataSet().getDataTable(0).getCachedRowCount() == 0) {
                        this.val$et.set("srfret", 0);
                        return;
                    }
                    this.val$et.set("srfret", 1);
                    return;
                }
                CallResult callResult = ServiceBase.this.internalGet(this.val$et2, true);
                if (callResult.getRetCode() == 3) {
                    this.val$et.set("srfret", 0);
                    return;
                }
                if (callResult.getRetCode() == 0) {
                    this.val$et.set("srfret", 1);
                    return;
                }
                throw new ErrorException(3, callResult.getErrorInfo(), ServiceBase.this.getDEModel());
            }
        }, false);
        return (Integer)et.get("srfret");
    }

    @Override
    public int checkKeyTemp(ET et3) throws Exception {
        if (this.isUseServiceAPI()) {
            return 0;
        }
        boolean bFillKey = false;
        ET et = et3;
        ET et2 = this.getDEModel().createEntity();
        et.copyTo((IDataObject)et2, false);
        et2.setSessionFactory(this.getSessionFactory());
        if (et2.get(this.getDEModel().getKeyDEField().getName()) == null && !this.fillEntityKeyValue(et2, true)) {
            et.set("srfret", 0);
            return 0;
        }
        long nBeginTime = System.currentTimeMillis();
        this.doServiceWork(new IServiceWork((IEntity)et2, (IEntity)et, nBeginTime){
            private final /* synthetic */ IEntity val$et2;
            private final /* synthetic */ IEntity val$et;
            private final /* synthetic */ long val$nBeginTime;
            {
                this.val$et2 = iEntity;
                this.val$et = iEntity2;
                this.val$nBeginTime = l;
            }

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                DBCallResult dbCallResult = ServiceBase.this.getDAO().executeCheckKeySql(null, this.val$et2, true);
                if (dbCallResult.isError()) {
                    throw new ErrorException(1, dbCallResult.getErrorInfo(), ServiceBase.this.getDEModel());
                }
                if (dbCallResult.isOk()) {
                    dbCallResult.getDataSet().cacheDataRow();
                }
                if (dbCallResult.getDataSet().getDataTableCount() == 0 || dbCallResult.getDataSet().getDataTable(0).getCachedRowCount() == 0) {
                    this.val$et.set("srfret", 0);
                    return;
                }
                long nTime = System.currentTimeMillis() - this.val$nBeginTime;
                log.debug((Object)StringHelper.format("checkKeyTemp \u8017\u65f6[%1$s]", nTime));
                this.val$et.set("srfret", 1);
            }
        }, false);
        return (Integer)et.get("srfret");
    }

    public static void sortHierarchyEntities(ArrayList list, String strKeyField, String strPKeyField) throws Exception {
        if (list.size() <= 1) {
            return;
        }
        HashMap<Object, IEntity> entityMap = new HashMap<Object, IEntity>();
        ArrayList<IEntity> retList = new ArrayList<IEntity>();
        ArrayList<IEntity> list2 = new ArrayList<IEntity>();
        while (true) {
            list2.clear();
            int nLastLength = list.size();
            while (list.size() > 0) {
                IEntity iEntity = (IEntity)list.remove(0);
                Object objKey = iEntity.get(strKeyField);
                Object objPKey = iEntity.get(strPKeyField);
                if (objPKey == null || objPKey.toString().length() == 0) {
                    entityMap.put(objKey, iEntity);
                    retList.add(iEntity);
                    continue;
                }
                if (entityMap.containsKey(objPKey)) {
                    entityMap.put(objKey, iEntity);
                    retList.add(iEntity);
                    continue;
                }
                list2.add(iEntity);
            }
            if (list2.size() == 0) break;
            if (nLastLength == list2.size()) {
                throw new Exception(StringHelper.format("\u65e0\u6cd5\u6392\u5e8f"));
            }
            list.addAll(list2);
        }
        list.addAll(retList);
    }

    public SessionFactory getRealSessionFactory() {
        if (this.sessionFactory != null) {
            return this.sessionFactory;
        }
        return this.getDEModel().getSystemRuntime().getSessionFactory(this.getDEModel().getDSLink());
    }

    @Override
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public SessionFactory getSessionFactory() {
        return this.sessionFactory;
    }

    @Override
    public void removeUncopyValues(ET et, boolean bTempMode) throws Exception {
        this.removeEntityUncopyValues(et, bTempMode);
    }

    protected void removeEntityUncopyValues(ET et, boolean bTempMode) throws Exception {
        if (bTempMode) {
            et.remove(ORIGINKEY);
        }
        String strKeyFieldName = this.getDEModel().getKeyDEField().getName();
        et.remove(strKeyFieldName);
        this.onRemoveEntityUncopyValues(et, bTempMode);
    }

    protected void onRemoveEntityUncopyValues(ET et, boolean bTempMode) throws Exception {
    }

    protected boolean checkFieldSimpleRule(String strFieldName, IEntity et, boolean bTempMode, String strCond, String strParamType, String strParamValue, String strRuleInfo) throws Exception {
        return this.checkFieldSimpleRule(strFieldName, et, bTempMode, strCond, strParamType, strParamValue, strRuleInfo, true);
    }

    protected boolean checkFieldSimpleRule(String strFieldName, IEntity et, boolean bTempMode, String strCond, String strParamType, String strParamValue, String strRuleInfo, boolean bTryMode) throws Exception {
        if (StringHelper.isNullOrEmpty(strRuleInfo)) {
            strRuleInfo = this.getLocalization(MSG_CHECKFIELDSIMPLERULE_INFO, "\u5185\u5bb9\u5fc5\u987b\u7b26\u5408\u503c\u89c4\u5219");
        }
        Object objValue = et.get(strFieldName);
        int nStdDataType = 25;
        if (objValue != null) {
            nStdDataType = DataTypeHelper.getObjectDataType(objValue);
        }
        Object objDst = DefaultValueHelper.getValue(WebContext.getCurrent(), strParamType, strParamValue, nStdDataType, et);
        return DataTypeHelper.testCond(objValue, strCond, objDst);
    }

    protected boolean checkFieldQueryCountRule(String strFieldName, String strDEDataQueryName, IEntity et, boolean bTempMode, Integer nMinValue, boolean bIncMinValue, Integer nMaxValue, boolean bIncMaxValue, String strRuleInfo) throws Exception {
        return this.checkFieldQueryCountRule(strFieldName, strDEDataQueryName, et, bTempMode, nMinValue, bIncMinValue, nMaxValue, bIncMaxValue, strRuleInfo, true);
    }

    protected boolean checkFieldQueryCountRule(String strFieldName, String strDEDataQueryName, IEntity et, boolean bTempMode, Integer nMinValue, boolean bIncMinValue, Integer nMaxValue, boolean bIncMaxValue, String strRuleInfo, boolean bTryMode) throws Exception {
        return this.checkFieldQueryCountRule2(strFieldName, strDEDataQueryName, et, bTempMode, nMinValue, bIncMinValue, nMaxValue, bIncMaxValue, strRuleInfo, false, bTryMode);
    }

    protected boolean checkFieldQueryCountRule2(String strFieldName, String strDEDataQueryName, IEntity et, boolean bTempMode, Integer nMinValue, boolean bIncMinValue, Integer nMaxValue, boolean bIncMaxValue, String strRuleInfo, boolean bAlwaysCheck) throws Exception {
        return this.checkFieldQueryCountRule2(strFieldName, strDEDataQueryName, et, bTempMode, nMinValue, bIncMinValue, nMaxValue, bIncMaxValue, strRuleInfo, bAlwaysCheck, true);
    }

    protected boolean checkFieldQueryCountRule2(String strFieldName, String strDEDataQueryName, IEntity et, boolean bTempMode, Integer nMinValue, boolean bIncMinValue, Integer nMaxValue, boolean bIncMaxValue, String strRuleInfo, boolean bAlwaysCheck, boolean bTryMode) throws Exception {
        if (bTempMode) {
            return true;
        }
        if (!bAlwaysCheck) {
            Object objValue = et.get(strFieldName);
            ET last = this.getLast(et);
            if (last != null) {
                Object objValue2;
                int nStdDataType = 25;
                if (objValue != null) {
                    nStdDataType = DataTypeHelper.getObjectDataType(objValue);
                }
                if (DataTypeHelper.compare(nStdDataType, objValue, objValue2 = last.get(strFieldName)) == 0L) {
                    return true;
                }
            }
        }
        DEDataSetFetchContext deDataSetFetchContext = new DEDataSetFetchContext(null);
        deDataSetFetchContext.setFetchData(false);
        deDataSetFetchContext.setActiveDataObject(et);
        DBFetchResult dbFetchResult = this.getDAO().fetchDEDataQuery(deDataSetFetchContext, strDEDataQueryName, bTempMode);
        int nLength = dbFetchResult.getTotalRow();
        if (nMinValue != null) {
            if (bIncMinValue) {
                if (nLength < nMinValue) {
                    if (bTryMode) {
                        return false;
                    }
                    throw new Exception(strRuleInfo);
                }
            } else if (nLength <= nMinValue) {
                if (bTryMode) {
                    return false;
                }
                throw new Exception(strRuleInfo);
            }
        }
        if (nMaxValue != null) {
            if (bIncMaxValue) {
                if (nLength > nMaxValue) {
                    if (bTryMode) {
                        return false;
                    }
                    throw new Exception(strRuleInfo);
                }
            } else if (nLength >= nMaxValue) {
                if (bTryMode) {
                    return false;
                }
                throw new Exception(strRuleInfo);
            }
        }
        return true;
    }

    protected boolean checkFieldDataSetRule(String strFieldName, String strDSDEName, String strDSName, IEntity et, boolean bTempMode, String strEQDSDEFName, String strEQDEFName, String strRuleInfo, boolean bAlwaysCheck) throws Exception {
        return this.checkFieldDataSetRule(strFieldName, strDSDEName, strDSName, et, bTempMode, strEQDSDEFName, strEQDEFName, strRuleInfo, bAlwaysCheck, false);
    }

    protected boolean checkFieldDataSetRule(String strFieldName, String strDSDEName, String strDSName, IEntity et, boolean bTempMode, String strEQDSDEFName, String strEQDEFName, String strRuleInfo, boolean bAlwaysCheck, boolean bTryMode) throws Exception {
        DBFetchResult dbFetchResult;
        int nLength;
        ET last;
        Object objValue;
        if (bTempMode) {
            return true;
        }
        if (StringHelper.isNullOrEmpty(strRuleInfo)) {
            strRuleInfo = this.getLocalization(MSG_CHECKFIELDDATASETRULE_INFO, "\u503c\u5fc5\u987b\u7b26\u5408\u6570\u636e\u96c6\u5408\u8303\u56f4\u89c4\u5219");
        }
        if ((objValue = et.get(strFieldName)) == null) {
            return true;
        }
        if (!bAlwaysCheck && (last = this.getLast(et)) != null) {
            Object objValue2;
            int nStdDataType = 25;
            if (objValue != null) {
                nStdDataType = DataTypeHelper.getObjectDataType(objValue);
            }
            if (DataTypeHelper.compare(nStdDataType, objValue, objValue2 = last.get(strFieldName)) == 0L) {
                return true;
            }
        }
        IDataEntityModel dsDEModel = this.getSystemModel().getDataEntityModel(strDSDEName);
        IService dsService = dsDEModel.getService(this.getSessionFactory());
        DEDataSetFetchContext deDataSetFetchContext = new DEDataSetFetchContext(null);
        deDataSetFetchContext.setFetchData(false);
        deDataSetFetchContext.setActiveDataObject(et);
        et.setEntityProperty("srfdeid", this.getDEModel().getName());
        et.setEntityProperty("srfreferitem", strFieldName);
        DEDataSetCond deDataSetCondImpl = new DEDataSetCond();
        deDataSetCondImpl.setCondType("DEFIELD");
        deDataSetCondImpl.setCondOp("EQ");
        deDataSetCondImpl.setDEFName(dsDEModel.getKeyDEField().getName());
        deDataSetCondImpl.setCondValue(DataObject.getStringValue(objValue, ""));
        deDataSetFetchContext.getConditionList().add(deDataSetCondImpl);
        if (!StringHelper.isNullOrEmpty(strEQDSDEFName)) {
            deDataSetCondImpl = new DEDataSetCond();
            deDataSetCondImpl.setCondType("DEFIELD");
            deDataSetCondImpl.setCondOp("EQ");
            deDataSetCondImpl.setDEFName(strEQDSDEFName);
            deDataSetCondImpl.setCondValue(DataObject.getStringValue(et, strEQDEFName, ""));
            deDataSetFetchContext.getConditionList().add(deDataSetCondImpl);
        }
        if ((nLength = (dbFetchResult = dsService.fetchDataSet(strDSName, deDataSetFetchContext)).getTotalRow()) == 0) {
            if (bTryMode) {
                return false;
            }
            throw new Exception(strRuleInfo);
        }
        return true;
    }

    protected boolean checkFieldRecursionRule(String strFieldName, String strDEName, IEntity et, boolean bTempMode, String strRuleInfo) throws Exception {
        return this.checkFieldRecursionRule(strFieldName, strDEName, et, bTempMode, strRuleInfo, false);
    }

    protected boolean checkFieldRecursionRule(String strFieldName, String strDEName, IEntity et, boolean bTempMode, String strRuleInfo, boolean bTryMode) throws Exception {
        Object objValue;
        if (bTempMode) {
            return true;
        }
        if (StringHelper.isNullOrEmpty(strRuleInfo)) {
            strRuleInfo = this.getLocalization(MSG_CHECKFIELDRECURSIONRULE_INFO, "\u503c\u5f15\u7528\u51fa\u73b0\u9012\u5f52\u5173\u7cfb");
        }
        if ((objValue = et.get(strFieldName)) == null) {
            return true;
        }
        Object objKey = et.get(this.getDEModel().getKeyDEField().getName());
        if (objKey == null) {
            return true;
        }
        if (DataTypeHelper.compare(this.getDEModel().getKeyDEField().getStdDataType(), objValue, objKey) == 0L) {
            if (bTryMode) {
                return false;
            }
            throw new Exception(strRuleInfo);
        }
        IService<ET> iService = this;
        if (!StringHelper.isNullOrEmpty(strDEName) && StringHelper.compare(strDEName, this.getDEModel().getName(), true) != 0) {
            IDataEntityModel iDEModel = this.getSystemModel().getDataEntityModel(strDEName);
            iService = iDEModel.getService(this.getSessionFactory());
        }
        Object parentData = iService.getDEModel().createEntity();
        while (objValue != null) {
            parentData.set(this.getDEModel().getKeyDEField().getName(), objValue);
            if (iService.get(parentData, true)) {
                objValue = parentData.get(strFieldName);
                if (objValue == null) {
                    return true;
                }
                if (DataTypeHelper.compare(this.getDEModel().getKeyDEField().getStdDataType(), objValue, objKey) != 0L) continue;
                if (bTryMode) {
                    return false;
                }
                throw new Exception(strRuleInfo);
            }
            return true;
        }
        return true;
    }

    protected boolean checkFieldStringLengthRule(String strFieldName, IEntity et, boolean bTempMode, Integer nMinValue, boolean bIncMinValue, Integer nMaxValue, boolean bIncMaxValue, String strRuleInfo) throws Exception {
        return this.checkFieldStringLengthRule(strFieldName, et, bTempMode, nMinValue, bIncMinValue, nMaxValue, bIncMaxValue, strRuleInfo, true);
    }

    protected boolean checkFieldStringLengthRule(String strFieldName, IEntity et, boolean bTempMode, Integer nMinValue, boolean bIncMinValue, Integer nMaxValue, boolean bIncMaxValue, String strRuleInfo, boolean bTryMode) throws Exception {
        if (StringHelper.isNullOrEmpty(strRuleInfo)) {
            strRuleInfo = this.getLocalization(MSG_CHECKFIELDSTRINGLENGTHRULE_INFO, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u7b26\u5408\u8303\u56f4\u89c4\u5219");
        }
        String strValue = "";
        Object objValue = et.get(strFieldName);
        if (objValue != null) {
            if (!(objValue instanceof String)) {
                throw new Exception(this.getLocalization(MSG_CHECKFIELDSTRINGLENGTHRULE_INVALIDVALUE, new Object[]{strFieldName}, StringHelper.format("\u5c5e\u6027[%1$s]\u503c\u4e0d\u662f\u5b57\u7b26\u7c7b\u578b", strFieldName)));
            }
            strValue = (String)objValue;
        }
        int nLength = strValue.length();
        if (nMinValue != null) {
            if (bIncMinValue) {
                if (nLength < nMinValue) {
                    if (bTryMode) {
                        return false;
                    }
                    throw new Exception(strRuleInfo);
                }
            } else if (nLength <= nMinValue) {
                if (bTryMode) {
                    return false;
                }
                throw new Exception(strRuleInfo);
            }
        }
        if (nMaxValue != null) {
            if (bIncMaxValue) {
                if (nLength > nMaxValue) {
                    if (bTryMode) {
                        return false;
                    }
                    throw new Exception(strRuleInfo);
                }
            } else if (nLength >= nMaxValue) {
                if (bTryMode) {
                    return false;
                }
                throw new Exception(strRuleInfo);
            }
        }
        return true;
    }

    protected boolean checkFieldValueRangeRule(String strFieldName, IEntity et, boolean bTempMode, Double fMinValue, boolean bIncMinValue, Double fMaxValue, boolean bIncMaxValue, String strRuleInfo) throws Exception {
        return this.checkFieldValueRangeRule(strFieldName, et, bTempMode, fMinValue, bIncMinValue, fMaxValue, bIncMaxValue, strRuleInfo, true);
    }

    protected boolean checkFieldValueRangeRule(String strFieldName, IEntity et, boolean bTempMode, Double fMinValue, boolean bIncMinValue, Double fMaxValue, boolean bIncMaxValue, String strRuleInfo, boolean bTryMode) throws Exception {
        Object objValue;
        if (StringHelper.isNullOrEmpty(strRuleInfo)) {
            strRuleInfo = this.getLocalization(MSG_CHECKFIELDVALUERANGERULE_INFO, "\u503c\u5fc5\u987b\u7b26\u5408\u503c\u8303\u56f4\u89c4\u5219");
        }
        if ((objValue = et.get(strFieldName)) == null) {
            return true;
        }
        double fSrcValue = 0.0;
        if (objValue instanceof Double) {
            fSrcValue = (Double)objValue;
        } else {
            String strValue = objValue.toString();
            if (StringHelper.isNullOrEmpty(strValue)) {
                return true;
            }
            fSrcValue = Double.parseDouble(objValue.toString());
        }
        if (fMinValue != null) {
            if (bIncMinValue) {
                if (fSrcValue < fMinValue) {
                    if (bTryMode) {
                        return false;
                    }
                    throw new Exception(strRuleInfo);
                }
            } else if (fSrcValue <= fMinValue) {
                if (bTryMode) {
                    return false;
                }
                throw new Exception(strRuleInfo);
            }
        }
        if (fMaxValue != null) {
            if (bIncMaxValue) {
                if (fSrcValue > fMaxValue) {
                    if (bTryMode) {
                        return false;
                    }
                    throw new Exception(strRuleInfo);
                }
            } else if (fSrcValue >= fMaxValue) {
                if (bTryMode) {
                    return false;
                }
                throw new Exception(strRuleInfo);
            }
        }
        return true;
    }

    protected boolean checkFieldValueRangeRule2(String strFieldName, IEntity et, boolean bTempMode, String strValueList, String strSeparator, String strRuleInfo) throws Exception {
        return this.checkFieldValueRangeRule2(strFieldName, et, bTempMode, strValueList, strSeparator, strRuleInfo, true);
    }

    protected boolean checkFieldValueRangeRule2(String strFieldName, IEntity et, boolean bTempMode, String strValueList, String strSeparator, String strRuleInfo, boolean bTryMode) throws Exception {
        Object objValue;
        if (StringHelper.isNullOrEmpty(strRuleInfo)) {
            strRuleInfo = this.getLocalization(MSG_CHECKFIELDVALUERANGERULE_INFO, "\u503c\u5fc5\u987b\u7b26\u5408\u503c\u8303\u56f4\u89c4\u5219");
        }
        if ((objValue = et.get(strFieldName)) == null) {
            return true;
        }
        String[] values = null;
        if (!StringHelper.isNullOrEmpty(strValueList)) {
            values = StringHelper.isNullOrEmpty(strSeparator) ? StringHelper.split(strValueList, ";") : StringHelper.split(strValueList, strSeparator);
        }
        if (values != null) {
            IDEField iDEField = this.getDEModel().getDEField(strFieldName, false);
            int nStdDataType = iDEField.getStdDataType();
            String[] stringArray = values;
            int n = values.length;
            int n2 = 0;
            while (n2 < n) {
                String strValue = stringArray[n2];
                if (DataTypeHelper.compare(nStdDataType, objValue, (Object)strValue) == 0L) {
                    return true;
                }
                ++n2;
            }
            if (bTryMode) {
                return false;
            }
            throw new Exception(strRuleInfo);
        }
        if (bTryMode) {
            return false;
        }
        throw new Exception(strRuleInfo);
    }

    protected boolean checkFieldRegExRule(String strFieldName, IEntity et, boolean bTempMode, String strRegExCode, String strRuleInfo) throws Exception {
        return this.checkFieldRegExRule(strFieldName, et, bTempMode, strRegExCode, strRuleInfo, true);
    }

    protected boolean checkFieldRegExRule(String strFieldName, IEntity et, boolean bTempMode, String strRegExCode, String strRuleInfo, boolean bTryMode) throws Exception {
        if (!et.contains(strFieldName)) {
            return true;
        }
        String strValue = "";
        Object objValue = et.get(strFieldName);
        if (objValue != null) {
            if (!(objValue instanceof String)) {
                throw new Exception(this.getLocalization(MSG_CHECKFIELDREGEXRULE_INVALIDVALUE, new Object[]{strFieldName}, StringHelper.format("\u5c5e\u6027[%1$s]\u503c\u4e0d\u662f\u5b57\u7b26\u7c7b\u578b", strFieldName)));
            }
            strValue = (String)objValue;
        }
        if (StringHelper.isNullOrEmpty(strValue)) {
            return true;
        }
        Pattern p = Pattern.compile(strRegExCode);
        Matcher m = p.matcher(strValue);
        boolean b = m.matches();
        if (!b) {
            if (bTryMode) {
                return false;
            }
            throw new Exception(strRuleInfo);
        }
        return true;
    }

    protected String checkFieldDupRule(IDataEntityModel iDEModel, String strFieldName, String strRangeFieldName, ET et, boolean bCreate, boolean bTempMode) throws Exception {
        Object value2;
        boolean bValueFieldChanged = true;
        boolean bRangeFieldChanged = true;
        Object objKeyValue = et.get(iDEModel.getKeyDEField().getName());
        SelectContext selectCond = new SelectContext();
        Object value = et.get(strFieldName);
        selectCond.setConditon(strFieldName, value);
        selectCond.setFetchFirst(true);
        ET last = this.getLast((IEntity)et);
        if (last != null && (value2 = last.get(strFieldName)) != null) {
            IDEField iDEField = iDEModel.getDEField(strFieldName, true);
            boolean bl = bValueFieldChanged = DataTypeHelper.compare(iDEField.getStdDataType(), value, value2) != 0L;
        }
        if (!StringHelper.isNullOrEmpty(strRangeFieldName)) {
            String strRangeValue;
            Object rangeValue = et.get(strRangeFieldName);
            if (rangeValue == null && last != null) {
                rangeValue = last.get(strRangeFieldName);
            }
            if (bTempMode && rangeValue != null && rangeValue instanceof String && (strRangeValue = (String)rangeValue).indexOf(TEMPKEY) != 0) {
                return null;
            }
            if (rangeValue == null) {
                selectCond.setConditon(strRangeFieldName, SelectCond.ISNULL);
            } else {
                selectCond.setConditon(strRangeFieldName, rangeValue);
            }
            if (last != null) {
                Object value22 = last.get(strRangeFieldName);
                if (value22 != null) {
                    if (rangeValue != null) {
                        IDEField iDEField = iDEModel.getDEField(strRangeFieldName, true);
                        bRangeFieldChanged = DataTypeHelper.compare(iDEField.getStdDataType(), rangeValue, value22) != 0L;
                    }
                } else if (rangeValue == null) {
                    bRangeFieldChanged = false;
                }
            }
        } else {
            bRangeFieldChanged = false;
        }
        if (!bValueFieldChanged && !bRangeFieldChanged) {
            return null;
        }
        SelectField selectField = new SelectField();
        selectField.setName(iDEModel.getKeyDEField().getName());
        selectCond.addSelectField(selectField);
        ArrayList<ET> list = null;
        list = bTempMode ? (iDEModel == this.getDEModel() ? this.selectTemp(selectCond) : iDEModel.getService(this.getSessionFactory()).selectTemp(selectCond)) : (iDEModel == this.getDEModel() ? this.select(selectCond) : iDEModel.getService(this.getSessionFactory()).select(selectCond));
        if (list.size() == 0) {
            return null;
        }
        for (IEntity item : list) {
            Object objKeyValue2 = item.get(iDEModel.getKeyDEField().getName());
            if (DataTypeHelper.compare(iDEModel.getKeyDEField().getStdDataType(), objKeyValue, objKeyValue2) == 0L) continue;
            return this.getLocalization(MSG_CHECKFIELDDUPRULE_INFO, "\u503c\u91cd\u590d");
        }
        return null;
    }

    protected boolean checkFieldSysValueRule(String strFieldName, IEntity et, boolean bTempMode, String strSysValueRuleId, String strRuleInfo) throws Exception {
        return this.checkFieldSysValueRule(strFieldName, et, bTempMode, strSysValueRuleId, strRuleInfo, true);
    }

    protected boolean checkFieldSysValueRule(String strFieldName, IEntity et, boolean bTempMode, String strSysValueRuleId, String strRuleInfo, boolean bTryMode) throws Exception {
        ISystemValueRuleModel iSystemValueRuleModel = this.getSystemModel().getSystemValueRuleModel(strSysValueRuleId);
        return iSystemValueRuleModel.check(et, strFieldName, bTempMode, null, strRuleInfo, bTryMode);
    }

    protected void syncEntity(ET et, boolean bRemove) throws Exception {
        this.onSyncEntity(et, bRemove);
        this.onSyncIndexEntities(et, bRemove);
    }

    protected void onSyncEntity(ET et, boolean bRemove) throws Exception {
    }

    protected void pushDTSQueue(ET et) throws Exception {
        if (!StringHelper.isNullOrEmpty(this.getDEModel().getDefaultDEDTSQueueId())) {
            if (this.iDTSQueueModel == null) {
                this.iDTSQueueModel = this.getSystemModel().getDTSQueueModel(this.getDEModel().getDefaultDEDTSQueueId());
            }
            SessionFactoryManager.getCurrentSFS().registerSFSAction(this.getRealSessionFactory(), new DTSQueueSFSAction(this.iDTSQueueModel, (IEntity)et));
        }
    }

    protected void logDataChanged(int nEvent, ET et) throws Exception {
        if (this.getDEModel().getDataChangeLogMode() == 2 || this.getDEModel().getDataChangeLogMode() == 3 || this.getDEModel().getDataChangeLogMode() != 0 && nEvent == 4) {
            DEDataChgService deDataChgService = (DEDataChgService)ServiceGlobal.getService(DEDataChgService.class, this.getSessionFactory());
            DEDataChg deDataChg = new DEDataChg();
            deDataChg.set("DEID", this.getDEModel().getRuntimeId());
            deDataChg.setDEName(this.getDEModel().getName());
            deDataChg.setEventType(nEvent);
            deDataChg.setDataKey(DataObject.getStringValue(et, this.getDEModel().getKeyDEField().getName(), ""));
            if (nEvent != 4) {
                deDataChg.setLogicData(DataObject.toJSONString(et, true));
                if (this.getDEModel().getDataChangeLogMode() == 3) {
                    ArrayList<JSONObject> list = new ArrayList<JSONObject>();
                    this.onExportRelatedModel(et, list);
                    deDataChg.setData(JSONArray.fromArray((Object[])list.toArray()).toString());
                }
            } else {
                deDataChg.setLogicData(DataObject.toJSONString(et, true));
            }
            deDataChgService.create(deDataChg, false);
        }
    }

    @Override
    public void updateWFInfo(int nActionMode, IWFActionContext iWFActionContext, ET entity) throws Exception {
        entity.setSessionFactory(this.getSessionFactory());
        ET et = entity;
        final int nActionMode2 = nActionMode;
        final IWFActionContext iWFActionContext2 = iWFActionContext;
        log.debug((Object)"\u5f00\u59cb[updateWFInfo]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork((IEntity)et){
            private final /* synthetic */ IEntity val$et;
            {
                this.val$et = iEntity;
            }

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                ServiceBase.this.onBeforeUpdateWFInfo(nActionMode2, iWFActionContext2, this.val$et);
                if (nActionMode2 == IService.UPDATEWFINFOMODE_INIT) {
                    ServiceBase.this.initWF(this.val$et);
                } else if (nActionMode2 == IService.UPDATEWFINFOMODE_FINISH) {
                    ServiceBase.this.finishWF(this.val$et);
                } else if (nActionMode2 == IService.UPDATEWFINFOMODE_CANCELSTART) {
                    ServiceBase.this.cancelStartWF(this.val$et);
                } else if (nActionMode2 == IService.UPDATEWFINFOMODE_CANCEL) {
                    ServiceBase.this.closeWF(this.val$et);
                } else {
                    ServiceBase.this.internalUpdate(this.val$et);
                    ServiceBase.this.internalGet(this.val$et, false);
                    ServiceBase.this.syncDEUniState(this.val$et, true, "UPDATE");
                    ServiceBase.this.syncEntity(this.val$et, false);
                }
                ServiceBase.this.onAfterUpdateWFInfo(nActionMode2, iWFActionContext2, this.val$et);
            }
        });
    }

    public void initWF(ET entity) throws Exception {
        ET et = entity;
        this.doServiceWork(new IServiceWork((IEntity)et){
            private final /* synthetic */ IEntity val$et;
            {
                this.val$et = iEntity;
            }

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                ServiceBase.this.executeActionLogics("INITWF", ServiceBase.LOGICATTACHMODE_BEFORE, this.val$et);
                ServiceBase.this.onInitWF(this.val$et);
                ServiceBase.this.executeActionLogics("INITWF", ServiceBase.LOGICATTACHMODE_AFTER, this.val$et);
            }
        });
    }

    protected void onInitWF(ET et) throws Exception {
        this.internalUpdate(et);
        this.internalGet(et, false);
        this.syncDEUniState(et, true, "UPDATE");
        this.syncEntity(et, false);
    }

    public void finishWF(ET entity) throws Exception {
        ET et = entity;
        this.doServiceWork(new IServiceWork((IEntity)et){
            private final /* synthetic */ IEntity val$et;
            {
                this.val$et = iEntity;
            }

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                ServiceBase.this.executeActionLogics("FINISHWF", ServiceBase.LOGICATTACHMODE_BEFORE, this.val$et);
                ServiceBase.this.onFinishWF(this.val$et);
                ServiceBase.this.executeActionLogics("FINISHWF", ServiceBase.LOGICATTACHMODE_AFTER, this.val$et);
            }
        });
    }

    protected void onFinishWF(ET et) throws Exception {
        this.internalUpdate(et);
        this.internalGet(et, false);
        this.syncDEUniState(et, true, "UPDATE");
        this.syncEntity(et, false);
    }

    public void closeWF(ET entity) throws Exception {
        ET et = entity;
        this.doServiceWork(new IServiceWork((IEntity)et){
            private final /* synthetic */ IEntity val$et;
            {
                this.val$et = iEntity;
            }

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                ServiceBase.this.executeActionLogics("CLOSEWF", ServiceBase.LOGICATTACHMODE_BEFORE, this.val$et);
                ServiceBase.this.onCloseWF(this.val$et);
                ServiceBase.this.executeActionLogics("CLOSEWF", ServiceBase.LOGICATTACHMODE_AFTER, this.val$et);
            }
        });
    }

    protected void onCloseWF(ET et) throws Exception {
        this.internalUpdate(et);
        this.internalGet(et, false);
        this.syncDEUniState(et, true, "UPDATE");
        this.syncEntity(et, false);
    }

    public void cancelStartWF(ET entity) throws Exception {
        ET et = entity;
        this.doServiceWork(new IServiceWork((IEntity)et){
            private final /* synthetic */ IEntity val$et;
            {
                this.val$et = iEntity;
            }

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                ServiceBase.this.executeActionLogics("CANCELSTARTWF", ServiceBase.LOGICATTACHMODE_BEFORE, this.val$et);
                ServiceBase.this.onCancelStartWF(this.val$et);
                ServiceBase.this.executeActionLogics("CANCELSTARTWF", ServiceBase.LOGICATTACHMODE_AFTER, this.val$et);
            }
        });
    }

    protected void onCancelStartWF(ET et) throws Exception {
        this.internalUpdate(et);
        this.internalGet(et, false);
        this.syncDEUniState(et, true, "UPDATE");
        this.syncEntity(et, false);
    }

    protected void onBeforeUpdateWFInfo(int nActionMode, IWFActionContext iWFActionContext, ET entity) throws Exception {
    }

    protected void onAfterUpdateWFInfo(int nActionMode, IWFActionContext iWFActionContext, ET entity) throws Exception {
    }

    protected void onSyncIndexEntities(ET et, boolean bRemove) throws Exception {
    }

    @Override
    public Object getDataContextValue(ET et, String strField, IDataContextParam iDataContextParam) throws Exception {
        if (et.contains(strField)) {
            return et.get(strField);
        }
        return null;
    }

    @Override
    public String getDSLink() {
        return this.strDSLink;
    }

    @Override
    public void setDSLink(String strDSLink) {
        this.strDSLink = strDSLink;
    }

    protected void executeActionLogics(String strAction, String strAttachMode, ET et) throws Exception {
        ET et2 = et;
        IDataEntityModel iDataEntityModel = this.getDEModel();
        while (iDataEntityModel != null) {
            Iterator<IDEActionLogicModel> logics2;
            Iterator<IDELogicModel<ET>> logics = iDataEntityModel.getDEActionLogics(strAction, strAttachMode);
            if (logics != null) {
                while (logics.hasNext()) {
                    final IDELogicModel<ET> iDELogicModel = logics.next();
                    this.doServiceWork(new IServiceWork((IEntity)et2){
                        private final /* synthetic */ IEntity val$et2;
                        {
                            this.val$et2 = iEntity;
                        }

                        @Override
                        public void execute(ITransaction iTransaction) throws Exception {
                            ActionContext actionContextImpl = new ActionContext(null);
                            actionContextImpl.setParam(iDELogicModel.getDefaultParamName(), this.val$et2);
                            Object last2 = ServiceBase.this.getLast(this.val$et2, true);
                            if (last2 != null) {
                                actionContextImpl.setParam(StringHelper.format("%1$s|LAST", iDELogicModel.getDefaultParamName()), last2);
                            }
                            actionContextImpl.setSessionFactory(ServiceBase.this.getSessionFactory());
                            iDELogicModel.execute(actionContextImpl);
                        }
                    });
                }
            }
            if ((logics2 = iDataEntityModel.getDEActionLogics2(strAction, strAttachMode)) != null) {
                while (logics2.hasNext()) {
                    final IDEActionLogicModel iDEActionLogicModel = logics2.next();
                    this.doServiceWork(new IServiceWork((IEntity)et2){
                        private final /* synthetic */ IEntity val$et2;
                        {
                            this.val$et2 = iEntity;
                        }

                        @Override
                        public void execute(ITransaction iTransaction) throws Exception {
                            IService service = ServiceBase.this.getSystemModel().getDataEntityModel(iDEActionLogicModel.getDEName()).getService(ServiceBase.this.getSessionFactory());
                            if (iDEActionLogicModel.isCloneParam()) {
                                Object iEntity = service.getDEModel().createEntity();
                                this.val$et2.copyTo((IDataObject)iEntity, false);
                                if (iDEActionLogicModel.isIgnoreException()) {
                                    try {
                                        service.executeAction(iDEActionLogicModel.getDEActionName(), (IEntity)iEntity);
                                    }
                                    catch (Exception ex) {
                                        log.error((Object)ex);
                                    }
                                } else {
                                    service.executeAction(iDEActionLogicModel.getDEActionName(), (IEntity)iEntity);
                                }
                            } else if (iDEActionLogicModel.isIgnoreException()) {
                                try {
                                    service.executeAction(iDEActionLogicModel.getDEActionName(), this.val$et2);
                                }
                                catch (Exception ex) {
                                    log.error((Object)ex);
                                }
                            } else {
                                service.executeAction(iDEActionLogicModel.getDEActionName(), this.val$et2);
                            }
                        }
                    });
                }
            }
            iDataEntityModel = iDataEntityModel.getInheritDEModel();
        }
    }

    @Override
    public ArrayList<IEntity> selectRaw(String strSql, SqlParamList sqlParamList) throws Exception {
        final String strSql2 = strSql;
        final SqlParamList sqlParamList2 = sqlParamList;
        final ArrayList<IEntity> list = new ArrayList<IEntity>();
        this.doServiceWork(new IServiceWork(){

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                ArrayList<IEntity> list2 = ServiceBase.this.getDAO().executeRawSelectSql(null, strSql2, sqlParamList2);
                list.addAll(list2);
            }
        });
        return list;
    }

    @Override
    public ArrayList<ET> select(String strSql, SqlParamList sqlParamList) throws Exception {
        final String strSql2 = strSql;
        final SqlParamList sqlParamList2 = sqlParamList;
        final ArrayList list = new ArrayList();
        this.doServiceWork(new IServiceWork(){

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                ArrayList list2 = ServiceBase.this.getDAO().executeSelectSql(null, strSql2, sqlParamList2);
                list.addAll(list2);
            }
        });
        return list;
    }

    @Override
    public DBCallResult executeRaw(String strSql, SqlParamList sqlParamList) throws Exception {
        final String strSql2 = strSql;
        final SqlParamList sqlParamList2 = sqlParamList;
        final DBCallResultProxy dbCallResultProxy = new DBCallResultProxy();
        this.doServiceWork(new IServiceWork(){

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                dbCallResultProxy.setDBCallResult(ServiceBase.this.getDAO().executeRawSql(null, strSql2, sqlParamList2));
            }
        });
        return dbCallResultProxy.getDBCallResult();
    }

    @Override
    public DBCallResult callProc(String strProcName, SqlParamList sqlParamList) throws Exception {
        final String strProcName2 = strProcName;
        final SqlParamList sqlParamList2 = sqlParamList;
        final DBCallResultProxy dbCallResultProxy = new DBCallResultProxy();
        this.doServiceWork(new IServiceWork(){

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                dbCallResultProxy.setDBCallResult(ServiceBase.this.getDAO().callProc(null, strProcName2, sqlParamList2));
            }
        });
        return dbCallResultProxy.getDBCallResult();
    }

    @Override
    public DBCallResult executeRawBatch(String[] sqls, SqlParamList[] sqlParamLists, int nBatchSize) throws Exception {
        final String[] sqls2 = sqls;
        final SqlParamList[] sqlParamLists2 = sqlParamLists;
        final int nBatchSize2 = nBatchSize;
        final DBCallResultProxy dbCallResultProxy = new DBCallResultProxy();
        this.doServiceWork(new IServiceWork(){

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                dbCallResultProxy.setDBCallResult(ServiceBase.this.getDAO().executeRawSqlBatch(null, sqls2, sqlParamLists2, nBatchSize2));
            }
        });
        return dbCallResultProxy.getDBCallResult();
    }

    @Override
    public void exportModel(ET et, ArrayList<JSONObject> list) throws Exception {
        this.exportModel(et, list, this.getDefaultExportModelMode());
    }

    protected int getDefaultExportModelMode() {
        return 3;
    }

    @Override
    public void exportModel(ET et, ArrayList<JSONObject> list, int nExportMode) throws Exception {
        ET et2 = et;
        ArrayList<JSONObject> list2 = list;
        int nExportMode2 = nExportMode;
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doExportModel(this.getService(), 0, (IEntity)et, list, nExportMode, null).getResult() == 1) {
            return;
        }
        if (!et.isFullEntity()) {
            this.get(et);
        }
        this.doServiceWork(new IServiceWork((IEntity)et2, list2, nExportMode2){
            private final /* synthetic */ IEntity val$et2;
            private final /* synthetic */ ArrayList val$list2;
            private final /* synthetic */ int val$nExportMode2;
            {
                this.val$et2 = iEntity;
                this.val$list2 = arrayList;
                this.val$nExportMode2 = n;
            }

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doExportModel(ServiceBase.this.getService(), 40, this.val$et2, this.val$list2, this.val$nExportMode2, null).getResult() != 1) {
                    int nExportMode3;
                    Object objKeyValue = this.val$et2.get(ServiceBase.this.getDEModel().getKeyDEField().getName());
                    if ((this.val$nExportMode2 & 8) == 0 && ActionSessionManager.getCurrentSession().registerRecursion("EXPORTMAJORMODEL", ServiceBase.this.getDEModel().getId(), objKeyValue, this.val$nExportMode2 & 3 | 1)) {
                        nExportMode3 = this.val$nExportMode2;
                        if ((nExportMode3 & 2) > 0) {
                            nExportMode3 ^= 2;
                        }
                        if ((nExportMode3 & 0x20) > 0) {
                            nExportMode3 ^= 0x20;
                        }
                        ServiceBase.this.onExportMajorModel(this.val$et2, this.val$list2, nExportMode3 | 1);
                    }
                    if ((this.val$nExportMode2 & 0x20) == 0 && ActionSessionManager.getCurrentSession().registerRecursion("EXPORTMODEL", ServiceBase.this.getDEModel().getId(), objKeyValue, this.val$nExportMode2 & 3)) {
                        ServiceBase.this.onExportCurModel(this.val$et2, this.val$list2, this.val$nExportMode2);
                    }
                    if ((this.val$nExportMode2 & 0x10) == 0 && ActionSessionManager.getCurrentSession().registerRecursion("EXPORTRELATEDMODEL", ServiceBase.this.getDEModel().getId(), objKeyValue, this.val$nExportMode2 & 3)) {
                        nExportMode3 = this.val$nExportMode2;
                        if ((nExportMode3 & 0x20) > 0) {
                            nExportMode3 ^= 0x20;
                        }
                        ServiceBase.this.onExportRelatedModel(this.val$et2, this.val$list2, nExportMode3);
                    }
                }
            }
        }, false);
        if (iServicePlugin != null) {
            iServicePlugin.doExportModel(this.getService(), 99, (IEntity)et, list, nExportMode, null);
        }
    }

    protected void onExportCurModel(ET et, ArrayList<JSONObject> list, int nExportMode) throws Exception {
        this.onExportCurModel(et, list);
        boolean bIncludeEmpty = (nExportMode & 0x80) != 128;
        JSONObject etJO = this.getDEModel().toJSONObject((IEntity)et, bIncludeEmpty, nExportMode);
        if (etJO != null) {
            JSONObject jo = new JSONObject();
            jo.put("srfdeid", (Object)this.getDEModel().getId());
            jo.put("srfdename", (Object)this.getDEModel().getName());
            jo.put("srfvalue", (Object)etJO.toString());
            if ((nExportMode & 2) == 0) {
                jo.put("srfcreateonly", (Object)"true");
            }
            list.add(jo);
        }
    }

    protected void onExportCurModel(ET et, ArrayList<JSONObject> list) throws Exception {
    }

    protected void onExportRelatedModel(ET et, ArrayList<JSONObject> list, int nExportMode) throws Exception {
        this.onExportRelatedModel(et, list);
    }

    protected void onExportRelatedModel(ET et, ArrayList<JSONObject> list) throws Exception {
    }

    protected void onExportMajorModel(ET et, ArrayList<JSONObject> list, int nExportMode) throws Exception {
    }

    @Override
    public String importModel(JSONObject jo) throws Exception {
        PluginActionResult pluginActionResult;
        IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && (pluginActionResult = iServicePlugin.doImportModel(this.getService(), 0, jo, null)).getResult() == 1) {
            return (String)pluginActionResult.getUserObject();
        }
        boolean bOpenImportSession = false;
        try {
            if (ImportSessionManager.getCurrentSession() == null) {
                bOpenImportSession = true;
                ImportSessionManager.openSession().setName(this.getDEModel().getName());
            }
            String retInfo = this.internalImportModel(jo);
            if (bOpenImportSession) {
                ImportSessionManager.closeSession();
            }
            return retInfo;
        }
        catch (Exception ex) {
            if (bOpenImportSession) {
                ImportSessionManager.closeSession();
            }
            throw ex;
        }
    }

    protected String internalImportModel(JSONObject jo) throws Exception {
        JSONObject joValue;
        block8: {
            block11: {
                String strValue;
                block9: {
                    ET et;
                    String strCustomCall;
                    block10: {
                        try {
                            joValue = jo.optJSONObject("srfvalue");
                            if (joValue != null) break block8;
                            strValue = "";
                            strCustomCall = jo.optString("srfcustomcall", "");
                            if (StringHelper.isNullOrEmpty(strCustomCall)) break block9;
                            et = this.getDEModel().createEntity();
                            strValue = jo.optString("srfarg", "");
                            if (!StringHelper.isNullOrEmpty(strValue)) break block10;
                            this.executeAction(strCustomCall, (IEntity)et);
                            return null;
                        }
                        catch (Exception ex) {
                            log.error((Object)StringHelper.format("\u5bfc\u5165\u6570\u636e\u6a21\u578b\u53d1\u751f\u5f02\u5e38\uff0c%1$s", ex.getMessage(), ex));
                            throw ex;
                        }
                    }
                    DataObject.fromJSONObject(et, jo);
                    this.executeAction(strCustomCall, (IEntity)et);
                    return null;
                }
                String strRemoveCall = jo.optString("srfremove", "");
                if (StringHelper.compare(strRemoveCall, "TRUE", true) != 0) break block11;
                ET et = this.getDEModel().createEntity();
                strValue = jo.optString("srfarg", "");
                et.set(this.getDEModel().getKeyDEField().getName(), strValue);
                this.remove(et);
                return null;
            }
            String strDER1NSync = jo.optString("srfder1nsync", "");
            if (StringHelper.compare(strDER1NSync, "TRUE", true) == 0) {
                return this.onSyncDER1NData(jo.optString("srfder1nid", ""), jo.optString("srfarg", ""), jo.optString("srfarg2", ""));
            }
            return null;
        }
        String strCreateOnly = jo.optString("srfcreateonly", "");
        ET et = this.getDEModel().createEntity();
        DataObject.fromJSONObject(et, joValue);
        if (StringHelper.compare(strCreateOnly, "TRUE", true) == 0) {
            return this.onImportCurModel(et, joValue, true);
        }
        return this.onImportCurModel(et, joValue);
    }

    protected String onImportCurModel(ET et, JSONObject jo, boolean bCreateOnly) throws Exception {
        IDataEntityModel<ET> iDEModel = this.getDEModel();
        int nCheckKeyState = this.checkKey(et);
        if (nCheckKeyState == 2) {
            throw new Exception(this.getLocalization(MSG_IMPORTMODEL_DATADELETE, new Object[]{iDEModel.getName(), et.get(iDEModel.getKeyDEField().getName())}, StringHelper.format("[%1$s]\u6570\u636e[%2$s]\u5df2\u7ecf\u88ab\u5220\u9664\uff0c\u65e0\u6cd5\u5bfc\u5165", iDEModel.getName(), et.get(iDEModel.getKeyDEField().getName()))));
        }
        if (!this.onTestImportCurModel(nCheckKeyState == 0, et)) {
            return null;
        }
        if (nCheckKeyState == 0) {
            this.create(et, false);
        } else if (!bCreateOnly) {
            this.update(et, false);
        } else {
            return null;
        }
        return this.getDEModel().getDataInfo(et);
    }

    protected String onImportCurModel(ET et, JSONObject jo) throws Exception {
        return this.onImportCurModel(et, jo, false);
    }

    protected boolean onTestImportCurModel(boolean bInsert, ET et) {
        return true;
    }

    protected String onSyncDER1NData(String strDER1NId, String strParentKey, String strDatas) throws Exception {
        return null;
    }

    @Override
    public EntityFieldError testValueRule(String strDEFieldName, String strRule, IEntity iEntity, String strField, boolean bCreate) throws Exception {
        String strRuleInfo;
        if (bCreate) {
            this.setLast(iEntity, EMPTYLAST, true);
        }
        boolean bTempMode = false;
        String strKey = DataObject.getStringValue(iEntity, this.getDEModel().getKeyDEField().getName(), null);
        if (!StringHelper.isNullOrEmpty(strKey)) {
            boolean bl = bTempMode = strKey.indexOf(TEMPKEY) == 0;
        }
        if ((strRuleInfo = this.onTestValueRule(strDEFieldName, strRule, iEntity, bCreate, bTempMode)) != null) {
            EntityFieldError entityFieldError = new EntityFieldError();
            if (StringHelper.isNullOrEmpty(strField)) {
                entityFieldError.setFieldName(strDEFieldName);
            } else {
                entityFieldError.setFieldName(strField);
            }
            entityFieldError.setErrorType(3);
            entityFieldError.setErrorInfo(strRuleInfo);
            this.convertEntityFieldError(entityFieldError);
            return entityFieldError;
        }
        return null;
    }

    protected String onTestValueRule(String strDEFieldName, String strRule, IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        return null;
    }

    protected String getLocalization() {
        if (WebContext.getCurrent() != null) {
            return WebContext.getCurrent().getLocalization();
        }
        return this.getDEModel().getSystemRuntime().getLocalization();
    }

    protected String getRemoveRejectMsg(String strDERName, String strDERLogicName, String strMajorDEName, String strMinorDEName, String strDataInfo) throws Exception {
        String strLogicName = strDERLogicName;
        if (StringHelper.isNullOrEmpty(strLogicName)) {
            strLogicName = this.getSystemModel().getDataEntityModel(strMinorDEName).getLogicName();
        }
        return this.getLocalization(MSG_GETREMOVEREJECTMSG_INFO, new Object[]{this.getSystemModel().getDataEntityModel(strMajorDEName).getLogicName(), strDataInfo, strLogicName}, StringHelper.format("%1$s[%2$s]\u5b58\u5728\u5173\u7cfb\u6570\u636e[%3$s]\uff0c\u65e0\u6cd5\u5220\u9664\uff01", this.getSystemModel().getDataEntityModel(strMajorDEName).getLogicName(), strDataInfo, strLogicName));
    }

    protected String getRemoveRejectMsg(String strDERName, String strDERLogicName, String strMajorDEName, String strMinorDEName, String strDataInfo, Object objData) throws Exception {
        String strLogicName = strDERLogicName;
        if (StringHelper.isNullOrEmpty(strLogicName)) {
            String curDataInfo;
            IDataEntityModel curDEModel = this.getSystemModel().getDataEntityModel(strMinorDEName);
            strLogicName = curDEModel.getLogicName();
            if (objData != null && objData instanceof IEntity && !StringHelper.isNullOrEmpty(curDataInfo = curDEModel.getDataInfo((IEntity)objData))) {
                strLogicName = StringHelper.format("%1$s-%2$s", strLogicName, curDataInfo);
            }
        }
        return this.getLocalization(MSG_GETREMOVEREJECTMSG_INFO, new Object[]{this.getSystemModel().getDataEntityModel(strMajorDEName).getLogicName(), strDataInfo, strLogicName}, StringHelper.format("%1$s[%2$s]\u5b58\u5728\u5173\u7cfb\u6570\u636e[%3$s]\uff0c\u65e0\u6cd5\u5220\u9664\uff01", this.getSystemModel().getDataEntityModel(strMajorDEName).getLogicName(), strDataInfo, strLogicName));
    }

    @Override
    public void fillParentInfo(ET et, String strParentType, String strTypeParam, String strParentKey) throws Exception {
        this.onFillParentInfo(et, strParentType, strTypeParam, strParentKey);
    }

    public void updateParent(ET et) throws Exception {
        this.onUpdateParent(et);
    }

    protected void onUpdateParent(ET et) throws Exception {
    }

    protected boolean isNeedUpdateParent() {
        return false;
    }

    protected boolean isParentMergeChild() {
        return true;
    }

    protected boolean testParentMergeChild(String strChildType, String strTypeParam) {
        return true;
    }

    @Override
    public void beginMergeChild(ET et) throws Exception {
        ActionSession actionSession = ActionSessionManager.getCurrentSession();
        if (actionSession == null) {
            throw new ErrorException(1, "\u5f53\u524d\u64cd\u4f5c\u4f1a\u8bdd\u65e0\u6548", this.getDEModel());
        }
        String strMergeChildKey = StringHelper.format("__SRF__MERGE_%1$s_%2$s", this.getDEModel().getName(), et.get(this.getDEModel().getKeyDEField().getName()));
        Object objValue = actionSession.getActionParam(strMergeChildKey);
        if (objValue == null) {
            actionSession.setActionParam(strMergeChildKey, new ArrayList());
        }
    }

    @Override
    public void endMergeChild(ET et, boolean bCancel) throws Exception {
        ActionSession actionSession = ActionSessionManager.getCurrentSession();
        if (actionSession == null) {
            throw new ErrorException(1, "\u5f53\u524d\u64cd\u4f5c\u4f1a\u8bdd\u65e0\u6548", this.getDEModel());
        }
        String strMergeChildKey = StringHelper.format("__SRF__MERGE_%1$s_%2$s", this.getDEModel().getName(), et.get(this.getDEModel().getKeyDEField().getName()));
        Object objValue = actionSession.removeActionParam(strMergeChildKey);
        if (objValue == null || bCancel) {
            return;
        }
        ArrayList arrList = (ArrayList)objValue;
        if (arrList.size() == 0) {
            return;
        }
        for (String strTag : arrList) {
            String[] items = strTag.split("[|]");
            this.mergeChild(items[0], items[1], et.get(this.getDEModel().getKeyDEField().getName()));
        }
        String strKey = DataObject.getStringValue(et.get(this.getDEModel().getKeyDEField().getName()));
        if (strKey.indexOf(TEMPKEY) == 0) {
            this.internalGetTemp(et, false);
        } else {
            this.internalGet(et, false);
        }
    }

    @Override
    public void mergeChild(String strChildType, String strTypeParam, Object objKey) throws Exception {
        String strMergeChildKey;
        Object objValue;
        ActionSession actionSession = ActionSessionManager.getCurrentSession();
        if (actionSession != null && (objValue = actionSession.getActionParam(strMergeChildKey = StringHelper.format("__SRF__MERGE_%1$s_%2$s", this.getDEModel().getName(), objKey))) != null) {
            ArrayList arrList = (ArrayList)objValue;
            arrList.add(StringHelper.format("%1$s|%2$s", strChildType, strTypeParam));
            return;
        }
        ET et = this.getDEModel().createEntity();
        et.set(this.getDEModel().getKeyDEField().getName(), objKey);
        if (this.onMergeChild(strChildType, strTypeParam, et)) {
            String strKey = DataObject.getStringValue(objKey);
            if (strKey.indexOf(TEMPKEY) == 0) {
                this.sysUpdateTemp(et, false);
            } else {
                this.sysUpdate(et, false);
            }
        }
    }

    protected boolean onMergeChild(String strChildType, String strTypeParam, ET et) throws Exception {
        return false;
    }

    @Override
    public void postConstruct() throws Exception {
    }

    @Override
    public void copyDetails(ET et, Object objSourceKey) throws Exception {
        IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCopyDetails(this.getService(), 0, (IEntity)et, objSourceKey).getResult() == 1) {
            return;
        }
        this.onCopyDetails(et, objSourceKey);
    }

    protected void onCopyDetails(ET et, Object objSourceKey) throws Exception {
    }

    @Override
    public void syncData(DataSyncIn dataSyncIn, IDEDataSyncIn iDEDataSyncIn) throws Exception {
        final DataSyncIn dataSyncIn2 = dataSyncIn;
        final IDEDataSyncIn iDEDataSyncIn2 = iDEDataSyncIn;
        this.doServiceWork(new IServiceWork(){

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                if (!ServiceBase.this.testSyncData(dataSyncIn2, iDEDataSyncIn2)) {
                    return;
                }
                ActionSessionManager.getCurrentSession().setActionParam(ServiceBase.DATASYNCIN, dataSyncIn2);
                ServiceBase.this.onSyncData(dataSyncIn2, iDEDataSyncIn2);
                ActionSessionManager.getCurrentSession().removeActionParam(ServiceBase.DATASYNCIN);
            }
        });
    }

    protected boolean testSyncData(DataSyncIn dataSyncIn, IDEDataSyncIn iDEDataSyncIn) throws Exception {
        if ((dataSyncIn.getEventType() & iDEDataSyncIn.getEventType()) == 0) {
            return false;
        }
        if (StringHelper.isNullOrEmpty(iDEDataSyncIn.getTestDEActionName())) {
            return true;
        }
        ET iEntity = this.getDEModel().createEntity();
        if (!StringHelper.isNullOrEmpty(dataSyncIn.getLogicData())) {
            DataObject.fromJSONObject(iEntity, JSONObjectHelper.fromString(dataSyncIn.getLogicData()));
        }
        this.executeAction(iDEDataSyncIn.getTestDEActionName(), (IEntity)iEntity);
        return DataObject.getBoolValue(iEntity, RET, false);
    }

    protected void onSyncData(DataSyncIn dataSyncIn, IDEDataSyncIn iDEDataSyncInc) throws Exception {
        if (StringHelper.isNullOrEmpty(iDEDataSyncInc.getImportDEActionName())) {
            if (dataSyncIn.getEventType() == DataChangeEventCodeListModel.DELETE) {
                ET iEntity = this.getDEModel().createEntity();
                iEntity.set(this.getDEModel().getKeyDEField().getName(), dataSyncIn.getDataKey());
                try {
                    this.remove(iEntity);
                }
                catch (Exception ex) {
                    throw new Exception(StringHelper.format("\u79fb\u9664\u5b9e\u4f53[%1$s]\u6570\u636e[%2$s]\u53d1\u751f\u9519\u8bef\uff0c%3$s", dataSyncIn.getDEName(), dataSyncIn.getDataKey(), ex.getMessage()));
                }
            } else if ((dataSyncIn.getEventType() & DataChangeEventCodeListModel.CREATEORUPDATE) > 0) {
                ET iEntity = this.getDEModel().createEntity();
                JSONObject jo = JSONObjectHelper.fromString(dataSyncIn.getLogicData());
                DataObject.fromJSONObject(iEntity, jo);
                try {
                    this.save(iEntity);
                }
                catch (Exception ex) {
                    throw new Exception(StringHelper.format("\u4fdd\u5b58\u5b9e\u4f53[%1$s]\u6570\u636e[%2$s]\u53d1\u751f\u9519\u8bef\uff0c%3$s", dataSyncIn.getDEName(), dataSyncIn.getDataKey(), ex.getMessage()));
                }
            }
        } else {
            ET iEntity = this.getDEModel().createEntity();
            JSONObject jo = JSONObjectHelper.fromString(dataSyncIn.getLogicData());
            DataObject.fromJSONObject(iEntity, jo);
            try {
                this.executeAction(iDEDataSyncInc.getImportDEActionName(), (IEntity)iEntity);
            }
            catch (Exception ex) {
                throw new Exception(StringHelper.format("\u5bfc\u5165\u5b9e\u4f53[%1$s]\u6570\u636e[%2$s]\u53d1\u751f\u9519\u8bef\uff0c%3$s", dataSyncIn.getDEName(), dataSyncIn.getDataKey(), ex.getMessage()));
            }
        }
    }

    protected String getLocalization(String strResId, Object[] params, String strDefault) {
        if (this.getWebContext() != null) {
            return this.getWebContext().getLocalization(strResId, params, strDefault);
        }
        return strDefault;
    }

    protected String getLocalization(String strResId, String strDefault) {
        if (this.getWebContext() != null) {
            return this.getWebContext().getLocalization(strResId, null, strDefault);
        }
        return strDefault;
    }

    @Override
    public ISystemModel getSystemModel() {
        return this.getDEModel().getSystemModel();
    }

    protected final IService getService() {
        return this;
    }

    protected final IServicePlugin getPlugin() {
        if (!this.bCalcServicePlugin) {
            this.iServicePlugin = this.getDEModel().getServicePlugin();
            this.bCalcServicePlugin = true;
            log.debug((Object)StringHelper.format("\u5b9e\u4f53[%1$s]\u6302\u63a5\u63d2\u4ef6[%2$s]", this.getDEModel().getName(), this.iServicePlugin));
        }
        return this.iServicePlugin;
    }

    @Override
    public IEntityActionHelper getServiceActionHelper() {
        return this.getEntityActionHelper();
    }

    protected IEntityActionHelper getEntityActionHelper() {
        IEntityActionHelper iEntityActionHelper;
        if (this.iEntityActionHelper != null) {
            return this.iEntityActionHelper;
        }
        this.iEntityActionHelper = iEntityActionHelper = new IEntityActionHelper(){

            @Override
            public void create(IEntity iEntity) throws Exception {
                ServiceBase.this.getService().create(iEntity);
            }

            @Override
            public void update(IEntity iEntity) throws Exception {
                ServiceBase.this.getService().update(iEntity);
            }

            @Override
            public void save(IEntity iEntity) throws Exception {
                ServiceBase.this.getService().save(iEntity);
            }

            @Override
            public void remove(IEntity iEntity) throws Exception {
                ServiceBase.this.getService().remove(iEntity);
            }

            @Override
            public boolean get(IEntity iEntity, boolean bTryMode) throws Exception {
                return ServiceBase.this.getService().get(iEntity, bTryMode);
            }

            @Override
            public boolean select(IEntity iEntity, boolean bTryMode) throws Exception {
                return ServiceBase.this.getService().select(iEntity, bTryMode);
            }
        };
        return this.iEntityActionHelper;
    }

    @Override
    public void fillEntityActionHelper(ET et) throws Exception {
        if (et instanceof IEntityActionSupporter) {
            ((IEntityActionSupporter)et).setActionHelper(this.getEntityActionHelper());
            return;
        }
        throw new Exception("\u6570\u636e\u5bf9\u8c61\u7c7b\u578b\u4e0d\u652f\u6301");
    }

    @Override
    public void executeLogic(String strDELogicId, IEntity iEntity) throws Exception {
        ET iEntity2 = this.getDEModel().createEntity();
        if (iEntity2.getClass().isInstance(iEntity)) {
            this.onExecuteLogic(strDELogicId, iEntity);
        } else {
            iEntity.copyTo((IDataObject)iEntity2, true);
            this.onExecuteLogic(strDELogicId, (IEntity)iEntity2);
            iEntity2.copyTo(iEntity, true);
        }
    }

    protected void onExecuteLogic(String strDELogicId, IEntity iEntity) throws Exception {
        final IDELogicModel iDELogic2 = (IDELogicModel)this.getDEModel().getDELogic(strDELogicId);
        final IEntity iEntity2 = iEntity;
        this.doServiceWork(new IServiceWork(){

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                ActionContext actionContextImpl = new ActionContext(null);
                actionContextImpl.setParam(iDELogic2.getDefaultParamName(), iEntity2);
                actionContextImpl.setSessionFactory(ServiceBase.this.getSessionFactory());
                iDELogic2.execute(actionContextImpl);
            }
        });
    }

    protected void testDEMainStateAction(ET et, String strDEActionName) throws Exception {
        if (!this.getDEModel().hasDEMainState()) {
            return;
        }
        ET last = this.getLast((IEntity)et);
        if (last == null) {
            return;
        }
        IDEMainState iDEMainState = this.getDEModel().getDEMainState((ISimpleDataObject)last);
        if (iDEMainState != null && !iDEMainState.testDEAction(strDEActionName)) {
            throw new ErrorException(9, this.getDEModel().getDEMainStateDenyMsg(iDEMainState, (ISimpleDataObject)et, 1, strDEActionName));
        }
    }

    protected ICacheManager getCacheManager() {
        if (this.iCacheManager == null) {
            this.iCacheManager = this.createCacheManager();
        }
        return this.iCacheManager;
    }

    protected ICacheManager createCacheManager() {
        CacheManager cacheManager = new CacheManager();
        cacheManager.setDefaultTimeout(this.getDEModel().getEntityCacheTimeout());
        cacheManager.setMaxItemCount(this.getDEModel().getEntityCacheCount());
        return cacheManager;
    }

    protected IUniStateModel getUniStateModel() throws Exception {
        if (this.bCalcUniStateModel) {
            return this.iUniStateModel;
        }
        if (this.getDEModel().getDefaultDEUniState() != null) {
            this.iUniStateModel = ((IDEUniStateModel)this.getDEModel().getDefaultDEUniState()).getUniStateModel();
        }
        this.bCalcUniStateModel = true;
        return this.iUniStateModel;
    }

    @Override
    public boolean isEnableEntityCache() throws Exception {
        return this.getDEModel().isEnableEntityCache() && this.getUniStateModel() != null && this.getUniStateModel().isEnabled();
    }

    @Override
    public boolean isEnableDynaStorage() {
        return this.getDEModel().isEnableDynaStorage();
    }

    protected void syncDEUniState(ET iEntity, boolean bFullInfo, String strAction) throws Exception {
        Iterator<IDEUniState> deUniStates = this.getDEModel().getDEUniStates();
        if (deUniStates != null) {
            ET et = this.getDEModel().createEntity();
            iEntity.copyTo((IDataObject)et, false);
            if (!bFullInfo) {
                this.internalGet(et, false);
            }
            while (deUniStates.hasNext()) {
                SessionFactoryManager.getCurrentSFS().registerSFSAction(this.getRealSessionFactory(), new UniStateSFSAction(((IDEUniStateModel)deUniStates.next()).getUniStateModel(), (IEntity)iEntity, strAction));
            }
        }
    }

    @Override
    public boolean autoGet(ET et, boolean bTryMode) throws Exception {
        if (this.isTempData((IEntity)et)) {
            this.getTemp(et);
            return true;
        }
        return this.get(et, bTryMode);
    }

    @Override
    public void autoGet(ET et) throws Exception {
        if (this.isTempData((IEntity)et)) {
            this.getTemp(et);
        } else {
            this.get(et);
        }
    }

    @Override
    public boolean isTempData(IEntity et) throws Exception {
        Object objKeyValue = et.get(this.getDEModel().getKeyDEField().getName());
        if (StringHelper.isNullOrEmpty(objKeyValue)) {
            throw new ErrorException(4);
        }
        String strKeyValue = objKeyValue.toString();
        return strKeyValue.indexOf(TEMPKEY) == 0;
    }

    @Override
    public ArrayList<IEntity> convertPickupData(ArrayList<IEntity> list) throws Exception {
        return list;
    }

    @Override
    public boolean isUseServiceAPI() {
        return this.getDEModel().isUseServiceAPI();
    }

    protected IServiceAPIClientModel getServiceAPIClientModel() throws Exception {
        if (this.iServiceAPIClientModel == null) {
            this.iServiceAPIClientModel = this.getDEModel().getServiceAPIClientModel();
        }
        return this.iServiceAPIClientModel;
    }

    public ArrayList<ET> fromDBFetchResult(DBFetchResult dbFetchResult) throws Exception {
        if (!dbFetchResult.isOk() || dbFetchResult.getDataSet() == null || dbFetchResult.getDataSet().getDataTableCount() == 0) {
            throw new Exception("\u4f20\u5165\u6570\u636e\u96c6\u7ed3\u679c\u5bf9\u8c61\u65e0\u6548");
        }
        ArrayList<ET> list = new ArrayList<ET>();
        IDataTable dt = dbFetchResult.getDataSet().getDataTable(0);
        if (dt.getCachedRowCount() == -1) {
            IDataRow iDataRow;
            while ((iDataRow = dt.next()) != null) {
                ET et = this.getDEModel().createEntity();
                DataObject.fromDataRow(et, iDataRow);
                list.add(et);
            }
        } else {
            int nRows = dt.getCachedRowCount();
            int i = 0;
            while (i < nRows) {
                IDataRow iDataRow = dt.getCachedRow(i);
                ET et = this.getDEModel().createEntity();
                DataObject.fromDataRow(et, iDataRow);
                list.add(et);
                ++i;
            }
        }
        return list;
    }

    public static ArrayList<IEntity> fromDBFetchResult(IDataEntityModel iDataEntityModel, DBFetchResult dbFetchResult) throws Exception {
        if (!dbFetchResult.isOk() || dbFetchResult.getDataSet() == null || dbFetchResult.getDataSet().getDataTableCount() == 0) {
            throw new Exception("\u4f20\u5165\u6570\u636e\u96c6\u7ed3\u679c\u5bf9\u8c61\u65e0\u6548");
        }
        ArrayList<IEntity> list = new ArrayList<IEntity>();
        IDataTable dt = dbFetchResult.getDataSet().getDataTable(0);
        if (dt.getCachedRowCount() == -1) {
            IDataRow iDataRow;
            while ((iDataRow = dt.next()) != null) {
                Object et = iDataEntityModel.createEntity();
                DataObject.fromDataRow(et, iDataRow);
                list.add((IEntity)et);
            }
        } else {
            int nRows = dt.getCachedRowCount();
            int i = 0;
            while (i < nRows) {
                IDataRow iDataRow = dt.getCachedRow(i);
                Object et = iDataEntityModel.createEntity();
                DataObject.fromDataRow(et, iDataRow);
                list.add((IEntity)et);
                ++i;
            }
        }
        return list;
    }

    @Override
    public String getDataSummary(ET et) throws Exception {
        return this.getDEModel().getDataInfo(et);
    }

    protected IDataEntityModel getDynaStorageDEModel() throws Exception {
        if (this.dynaStorageDEModel != null) {
            return this.dynaStorageDEModel;
        }
        this.dynaStorageDEModel = this.getSystemModel().getDataEntityModel(this.getDEModel().getDynaStorageDEName());
        return this.dynaStorageDEModel;
    }

    protected IService getDynaStorageService() throws Exception {
        if (this.dynaStorageService != null) {
            return this.dynaStorageService;
        }
        this.dynaStorageService = this.getDynaStorageDEModel().getService(this.getSessionFactory());
        return this.dynaStorageService;
    }

    protected String getDynaStoragePickupDEFName() throws Exception {
        if (!StringHelper.isNullOrEmpty(this.strDynaStoragePickupDEFName)) {
            return this.strDynaStoragePickupDEFName;
        }
        IDEField iDEField = this.getDynaStorageDEModel().getPickupDEField(this.getDEModel(), true);
        if (iDEField == null) {
            iDEField = this.getDynaStorageDEModel().getDEField(DYNAFIELD_OWNERID, true);
        }
        if (iDEField == null) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u52a8\u6001\u5b58\u50a8\u5b9e\u4f53\u5230\u5f53\u524d\u5b9e\u4f53\u7684\u5916\u952e\u503c\u5c5e\u6027");
        }
        this.strDynaStoragePickupDEFName = iDEField.getName();
        return this.strDynaStoragePickupDEFName;
    }

    protected class DBCallResultProxy {
        private DBCallResult dbCallResult = null;

        protected DBCallResultProxy() {
        }

        public DBCallResult getDBCallResult() {
            return this.dbCallResult;
        }

        public void setDBCallResult(DBCallResult dbCallResult) {
            this.dbCallResult = dbCallResult;
        }
    }
}

