/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IDEField
 *  net.ibizsys.paas.core.IDataEntity
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.EntityError
 *  net.ibizsys.paas.entity.EntityException
 *  net.ibizsys.paas.entity.EntityFieldError
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.exception.ErrorException
 *  net.ibizsys.paas.service.ActionSessionManager
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.IServiceCreateParam
 *  net.ibizsys.paas.service.IServicePlugin
 *  net.ibizsys.paas.service.IServiceUpdateParam
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceBase
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityException;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.exception.ErrorException;
import net.ibizsys.paas.service.ActionSessionManager;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.IServiceCreateParam;
import net.ibizsys.paas.service.IServicePlugin;
import net.ibizsys.paas.service.IServiceUpdateParam;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceBase;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.web.WebContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSCoreSysServiceBaseBase<ET extends IEntity>
extends ServiceBase<ET> {
    private static final Log log = LogFactory.getLog(PSCoreSysServiceBaseBase.class);

    protected IEntity getActionCacheEntity(String string, String string2) throws Exception {
        return PSCoreSysServiceBaseBase.getActionCacheEntity(this.getSystemModel().getDataEntityModel(string).getService(this.getSessionFactory()), string2, false);
    }

    protected IEntity getActionCacheEntity(String string, String string2, boolean bl) throws Exception {
        return PSCoreSysServiceBaseBase.getActionCacheEntity(this.getSystemModel().getDataEntityModel(string).getService(this.getSessionFactory()), string2, bl);
    }

    public static IEntity getActionCacheEntity(IService iService, String string) throws Exception {
        return PSCoreSysServiceBaseBase.getActionCacheEntity(iService, string, false);
    }

    public static IEntity getActionCacheEntity(IService iService, String string, boolean bl) throws Exception {
        Object object;
        String string2 = StringHelper.format((String)"ACTIONCACHEENTITY|%1$s#%2$s", (Object)iService.getDEModel().getName(), (Object)string);
        if (ActionSessionManager.getCurrentSession() != null) {
            object = ActionSessionManager.getCurrentSession().getActionParam(string2);
            if (object != null) {
                if (object == DataObject.EMPTY) {
                    if (bl) {
                        return null;
                    }
                    throw new ErrorException(3, StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e[%1$s][%2$s]", (Object)iService.getDEModel().getName(), (Object)string));
                }
                if (object instanceof IEntity) {
                    return (IEntity)object;
                }
            }
        } else {
            log.warn((Object)"\u83b7\u53d6\u64cd\u4f5c\u7f13\u5b58\u6570\u636e\u5931\u8d25\uff0c\u5f53\u524d\u6ca1\u6709\u64cd\u4f5c\u4f1a\u8bdd");
        }
        object = iService.getDEModel().createEntity();
        object.set(iService.getDEModel().getKeyDEField().getName(), (Object)string);
        try {
            if (iService.get((IEntity)object, bl)) {
                if (ActionSessionManager.getCurrentSession() != null) {
                    ActionSessionManager.getCurrentSession().setActionParam(string2, object);
                }
                return object;
            }
            if (ActionSessionManager.getCurrentSession() != null) {
                ActionSessionManager.getCurrentSession().setActionParam(string2, DataObject.EMPTY);
            }
            return null;
        }
        catch (Exception exception) {
            if (ActionSessionManager.getCurrentSession() != null) {
                ActionSessionManager.getCurrentSession().setActionParam(string2, DataObject.EMPTY);
            }
            throw exception;
        }
    }

    public static void resetActionCacheEntity(String string, String string2) throws Exception {
        String string3 = StringHelper.format((String)"ACTIONCACHEENTITY|%1$s#%2$s", (Object)string, (Object)string2);
        if (ActionSessionManager.getCurrentSession() != null) {
            ActionSessionManager.getCurrentSession().removeActionParam(string3);
        }
    }

    public static void setActionCacheEntity(String string, String string2, IEntity iEntity) throws Exception {
        String string3 = StringHelper.format((String)"ACTIONCACHEENTITY|%1$s#%2$s", (Object)string, (Object)string2);
        if (ActionSessionManager.getCurrentSession() != null) {
            ActionSessionManager.getCurrentSession().setActionParam(string3, (Object)iEntity);
        }
    }

    public boolean select(ET ET, boolean bl) throws Exception {
        SelectCond selectCond = new SelectCond();
        ET.copyTo((IDataObject)selectCond, false);
        selectCond.setFetchFirst(true);
        ArrayList arrayList = this.select(PSCoreSysServiceBaseBase.convertSelectCondNull((ISelectCond)selectCond));
        if (arrayList.size() == 0) {
            if (bl) {
                return false;
            }
            throw new ErrorException(3, (IDataEntity)this.getDEModel());
        }
        ((IEntity)arrayList.get(0)).copyTo(ET, true);
        return true;
    }

    public boolean selectTemp(ET ET, boolean bl) throws Exception {
        SelectCond selectCond = new SelectCond();
        ET.copyTo((IDataObject)selectCond, false);
        selectCond.setFetchFirst(true);
        ArrayList arrayList = this.selectTemp(PSCoreSysServiceBaseBase.convertSelectCondNull((ISelectCond)selectCond));
        if (arrayList.size() == 0) {
            if (bl) {
                return false;
            }
            throw new ErrorException(3, (IDataEntity)this.getDEModel());
        }
        ((IEntity)arrayList.get(0)).copyTo(ET, true);
        return true;
    }

    public static ISelectCond convertSelectCondNull(ISelectCond iSelectCond) throws Exception {
        HashMap hashMap = new HashMap();
        iSelectCond.fillMap(hashMap, true);
        for (Map.Entry entry : hashMap.entrySet()) {
            if (entry.getValue() != null && entry.getValue() != DataObject.EMPTY) continue;
            iSelectCond.set((String)entry.getKey(), SelectCond.ISNULL);
        }
        return iSelectCond;
    }

    protected IEntity getWebContextCacheEntity(String string, String string2) throws Exception {
        return PSCoreSysServiceBaseBase.getWebContextCacheEntity(this.getSystemModel().getDataEntityModel(string).getService(this.getSessionFactory()), string2, false);
    }

    protected IEntity getWebContextCacheEntity(String string, String string2, boolean bl) throws Exception {
        return PSCoreSysServiceBaseBase.getWebContextCacheEntity(this.getSystemModel().getDataEntityModel(string).getService(this.getSessionFactory()), string2, bl);
    }

    public static IEntity getWebContextCacheEntity(IService iService, String string) throws Exception {
        return PSCoreSysServiceBaseBase.getWebContextCacheEntity(iService, string, false);
    }

    public static IEntity getWebContextCacheEntity(IService iService, String string, boolean bl) throws Exception {
        Object object;
        String string2 = StringHelper.format((String)"WEBCTXCACHEENTITY|%1$s#%2$s", (Object)iService.getDEModel().getName(), (Object)string);
        if (WebContext.getCurrent() != null) {
            object = WebContext.getCurrent().getAttribute(string2);
            if (object != null) {
                if (object == DataObject.EMPTY) {
                    if (bl) {
                        return null;
                    }
                    throw new ErrorException(3, StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e[%1$s][%2$s]", (Object)iService.getDEModel().getName(), (Object)string));
                }
                if (object instanceof IEntity) {
                    return (IEntity)object;
                }
            }
        } else {
            log.warn((Object)"\u83b7\u53d6Web\u4e0a\u4e0b\u6587\u7f13\u5b58\u6570\u636e\u5931\u8d25\uff0c\u5f53\u524d\u6ca1\u6709\u64cd\u4f5c\u4f1a\u8bdd");
        }
        object = iService.getDEModel().createEntity();
        object.set(iService.getDEModel().getKeyDEField().getName(), (Object)string);
        try {
            if (iService.get((IEntity)object, bl)) {
                if (WebContext.getCurrent() != null) {
                    WebContext.getCurrent().setAttribute(string2, object);
                }
                return object;
            }
            if (WebContext.getCurrent() != null) {
                WebContext.getCurrent().setAttribute(string2, DataObject.EMPTY);
            }
            return null;
        }
        catch (Exception exception) {
            if (WebContext.getCurrent() != null) {
                WebContext.getCurrent().setAttribute(string2, DataObject.EMPTY);
            }
            throw exception;
        }
    }

    public static void resetWebContextCacheEntity(String string, String string2) throws Exception {
        String string3 = StringHelper.format((String)"WEBCTXCACHEENTITY|%1$s#%2$s", (Object)string, (Object)string2);
        if (WebContext.getCurrent() != null) {
            WebContext.getCurrent().setAttribute(string3, null);
        }
    }

    public static void setWebContextCacheEntity(String string, String string2, IEntity iEntity) throws Exception {
        String string3 = StringHelper.format((String)"WEBCTXCACHEENTITY|%1$s#%2$s", (Object)string, (Object)string2);
        if (WebContext.getCurrent() != null) {
            WebContext.getCurrent().setAttribute(string3, (Object)iEntity);
        }
    }

    public void create(ET ET, boolean bl) throws Exception {
        if (this.isUseServiceAPI()) {
            this.getServiceAPIClientModel().execute(this.getDEModel().getServiceAPIActionTag("DEACTION", "CREATE"), ET);
            return;
        }
        ET.setSessionFactory(this.getSessionFactory());
        Object object = ET.get("SRFSOURCEKEY");
        boolean bl2 = EntityBase.isIgnoreCheck(ET);
        IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCreate(this.getService(), 0, ET, null).getResult() == 1) {
            return;
        }
        this.onTestCreate((IEntity)ET);
        if (this.fillEntityKeyValue((IEntity)ET, false) && !EntityBase.isIgnoreCheckKey(ET)) {
            int n = this.checkKey((IEntity)ET);
            switch (n) {
                case 2: {
                    throw new ErrorException(6, this.getLocalization("CTRL.SERVICE.CHECKKEYSTATE_DELETE", StringHelper.format((String)"\u6570\u636e\u5df2\u7ecf\u88ab\u5220\u9664\uff0c\u65e0\u6cd5\u518d\u6b21\u5efa\u7acb")), (IDataEntity)this.getDEModel());
                }
                case 1: {
                    Iterator iterator = this.getDEModel().getUnionKeyValueDEFields();
                    if (iterator != null) {
                        EntityError entityError = new EntityError();
                        while (iterator.hasNext()) {
                            IDEField iDEField = (IDEField)iterator.next();
                            EntityFieldError entityFieldError = new EntityFieldError();
                            entityFieldError.setFieldName(iDEField.getName());
                            if (this.getWebContext() != null) {
                                entityFieldError.setFieldLogicName(iDEField.getLogicName(this.getWebContext().getLocalization()));
                            } else {
                                entityFieldError.setFieldLogicName(iDEField.getLogicName());
                            }
                            entityFieldError.setErrorType(3);
                            entityFieldError.setErrorInfo(this.getLocalization("CTRL.SERVICE.CHECKFIELDDUPRULE_INFO", "\u503c\u91cd\u590d"));
                            entityError.register(entityFieldError);
                        }
                        throw new EntityException(entityError, 6, this.getLocalization("CTRL.SERVICE.CHECKKEYSTATE_EXIST", StringHelper.format((String)"\u6570\u636e\u5df2\u7ecf\u5b58\u5728\uff0c\u65e0\u6cd5\u518d\u6b21\u5efa\u7acb")), (IDataEntity)this.getDEModel());
                    }
                    throw new ErrorException(6, this.getLocalization("CTRL.SERVICE.CHECKKEYSTATE_EXIST", StringHelper.format((String)"\u6570\u636e\u5df2\u7ecf\u5b58\u5728\uff0c\u65e0\u6cd5\u518d\u6b21\u5efa\u7acb")), (IDataEntity)this.getDEModel());
                }
            }
        }
        ET ET2 = ET;
        boolean bl3 = bl || this.isNeedUpdateParent();
        this.doServiceWork(new IServiceWork((IEntity)ET2, iServicePlugin, bl2, bl3, object){
            final /* synthetic */ IEntity val$et2;
            final /* synthetic */ IServicePlugin val$iServicePlugin;
            final /* synthetic */ boolean val$bIgnoreCheck;
            final /* synthetic */ boolean val$bGet2;
            final /* synthetic */ Object val$strSourceKey;
            {
                this.val$et2 = iEntity;
                this.val$iServicePlugin = iServicePlugin;
                this.val$bIgnoreCheck = bl;
                this.val$bGet2 = bl2;
                this.val$strSourceKey = object;
            }

            public void execute(ITransaction iTransaction) throws Exception {
                PSCoreSysServiceBaseBase.this.setLast(this.val$et2, (IEntity)EMPTYLAST, true);
                PSCoreSysServiceBaseBase.this.writeBackParent(this.val$et2, true);
                PSCoreSysServiceBaseBase.this.fillEntityFullInfo(this.val$et2, true);
                if (this.val$iServicePlugin != null) {
                    this.val$iServicePlugin.doCreate(PSCoreSysServiceBaseBase.this.getService(), 30, this.val$et2, null);
                }
                PSCoreSysServiceBaseBase.this.onBeforeCreate(this.val$et2);
                if (this.val$iServicePlugin != null) {
                    this.val$iServicePlugin.doCreate(PSCoreSysServiceBaseBase.this.getService(), 31, this.val$et2, null);
                }
                if (!this.val$bIgnoreCheck) {
                    PSCoreSysServiceBaseBase.this.checkEntity(this.val$et2, true, false);
                } else {
                    PSCoreSysServiceBaseBase.this.checkEntity(this.val$et2, true, false, true);
                }
                if (this.val$iServicePlugin == null || this.val$iServicePlugin.doCreate(PSCoreSysServiceBaseBase.this.getService(), 40, this.val$et2, null).getResult() != 1) {
                    PSCoreSysServiceBaseBase.this.internalCreate(this.val$et2);
                }
                if (this.val$bGet2) {
                    PSCoreSysServiceBaseBase.this.internalGet(this.val$et2, false);
                }
                if (!StringHelper.isNullOrEmpty((Object)this.val$strSourceKey)) {
                    PSCoreSysServiceBaseBase.this.copyDetails(this.val$et2, this.val$strSourceKey);
                }
                if (PSCoreSysServiceBaseBase.this.isNeedUpdateParent()) {
                    PSCoreSysServiceBaseBase.this.updateParent(this.val$et2);
                }
                IEntity iEntity = this.val$et2;
                if ((PSCoreSysServiceBaseBase.this.getDEModel().isEnableAudit() || PSCoreSysServiceBaseBase.this.getDEModel().getDataChangeLogMode() != 0) && !this.val$bGet2) {
                    iEntity = PSCoreSysServiceBaseBase.this.getDEModel().createEntity();
                    this.val$et2.copyTo((IDataObject)iEntity, true);
                    PSCoreSysServiceBaseBase.this.internalGet(iEntity, false);
                }
                if (PSCoreSysServiceBaseBase.this.getDEModel().isEnableAudit()) {
                    PSCoreSysServiceBaseBase.this.getDEModel().getDEDataAccMgr().audit(null, PSCoreSysServiceBaseBase.this.getWebContext(), iEntity, null, "CREATE");
                }
                PSCoreSysServiceBaseBase.this.syncEntity(this.val$et2, false);
                PSCoreSysServiceBaseBase.this.pushDTSQueue(this.val$et2);
                PSCoreSysServiceBaseBase.this.logDataChanged(1, iEntity);
                if (this.val$iServicePlugin != null) {
                    this.val$iServicePlugin.doCreate(PSCoreSysServiceBaseBase.this.getService(), 60, this.val$et2, null);
                }
                PSCoreSysServiceBaseBase.this.onAfterCreate(this.val$et2);
                if (this.val$iServicePlugin != null) {
                    this.val$iServicePlugin.doCreate(PSCoreSysServiceBaseBase.this.getService(), 61, this.val$et2, null);
                }
                PSCoreSysServiceBaseBase.this.resetLast(this.val$et2);
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCreate(this.getService(), 99, ET2, null);
        }
    }

    public void create(ET ET) throws Exception {
        if (this.isUseServiceAPI()) {
            this.getServiceAPIClientModel().execute(this.getDEModel().getServiceAPIActionTag("DEACTION", "CREATE"), ET);
            return;
        }
        this.create(ET, true);
    }

    public void create(final IServiceCreateParam<ET> iServiceCreateParam) throws Exception {
        IEntity iEntity = iServiceCreateParam.getEntity();
        iEntity.setSessionFactory(this.getSessionFactory());
        final Object object = iEntity.get("SRFSOURCEKEY");
        final boolean bl = EntityBase.isIgnoreCheck((IEntity)iEntity);
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCreate(this.getService(), 0, iServiceCreateParam, null).getResult() == 1) {
            return;
        }
        if (!iServiceCreateParam.testAction(iEntity)) {
            return;
        }
        if (this.fillEntityKeyValue(iEntity, false) && !EntityBase.isIgnoreCheckKey((IEntity)iEntity)) {
            int n = this.checkKey(iEntity);
            switch (n) {
                case 2: {
                    throw new ErrorException(6, this.getLocalization("CTRL.SERVICE.CHECKKEYSTATE_DELETE", StringHelper.format((String)"\u6570\u636e\u5df2\u7ecf\u88ab\u5220\u9664\uff0c\u65e0\u6cd5\u518d\u6b21\u5efa\u7acb")), (IDataEntity)this.getDEModel());
                }
                case 1: {
                    Iterator iterator = this.getDEModel().getUnionKeyValueDEFields();
                    if (iterator != null) {
                        EntityError entityError = new EntityError();
                        while (iterator.hasNext()) {
                            IDEField iDEField = (IDEField)iterator.next();
                            EntityFieldError entityFieldError = new EntityFieldError();
                            entityFieldError.setFieldName(iDEField.getName());
                            if (this.getWebContext() != null) {
                                entityFieldError.setFieldLogicName(iDEField.getLogicName(this.getWebContext().getLocalization()));
                            } else {
                                entityFieldError.setFieldLogicName(iDEField.getLogicName());
                            }
                            entityFieldError.setErrorType(3);
                            entityFieldError.setErrorInfo(this.getLocalization("CTRL.SERVICE.CHECKFIELDDUPRULE_INFO", "\u503c\u91cd\u590d"));
                            entityError.register(entityFieldError);
                        }
                        throw new EntityException(entityError, 6, this.getLocalization("CTRL.SERVICE.CHECKKEYSTATE_EXIST", StringHelper.format((String)"\u6570\u636e\u5df2\u7ecf\u5b58\u5728\uff0c\u65e0\u6cd5\u518d\u6b21\u5efa\u7acb")), (IDataEntity)this.getDEModel());
                    }
                    throw new ErrorException(6, this.getLocalization("CTRL.SERVICE.CHECKKEYSTATE_EXIST", StringHelper.format((String)"\u6570\u636e\u5df2\u7ecf\u5b58\u5728\uff0c\u65e0\u6cd5\u518d\u6b21\u5efa\u7acb")), (IDataEntity)this.getDEModel());
                }
            }
        }
        final IEntity iEntity2 = iEntity;
        final boolean bl2 = iServiceCreateParam.isReturnData() || this.isNeedUpdateParent();
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCoreSysServiceBaseBase.this.setLast(iEntity2, (IEntity)EMPTYLAST, true);
                PSCoreSysServiceBaseBase.this.writeBackParent(iEntity2, true);
                PSCoreSysServiceBaseBase.this.fillEntityFullInfo(iEntity2, true);
                if (iServicePlugin != null) {
                    iServicePlugin.doCreate(PSCoreSysServiceBaseBase.this.getService(), 30, iServiceCreateParam, null);
                }
                iServiceCreateParam.doBeforeAction(iEntity2);
                if (iServicePlugin != null) {
                    iServicePlugin.doCreate(PSCoreSysServiceBaseBase.this.getService(), 31, iServiceCreateParam, null);
                }
                if (!bl) {
                    PSCoreSysServiceBaseBase.this.checkEntity(iEntity2, true, false);
                } else {
                    PSCoreSysServiceBaseBase.this.checkEntity(iEntity2, true, false, true);
                }
                if (iServicePlugin == null || iServicePlugin.doCreate(PSCoreSysServiceBaseBase.this.getService(), 40, iServiceCreateParam, null).getResult() != 1) {
                    PSCoreSysServiceBaseBase.this.internalCreate(iEntity2);
                }
                if (bl2) {
                    PSCoreSysServiceBaseBase.this.internalGet(iEntity2, false);
                }
                if (!StringHelper.isNullOrEmpty((Object)object)) {
                    PSCoreSysServiceBaseBase.this.copyDetails(iEntity2, object);
                }
                if (PSCoreSysServiceBaseBase.this.isNeedUpdateParent()) {
                    PSCoreSysServiceBaseBase.this.updateParent(iEntity2);
                }
                IEntity iEntity = iEntity2;
                if ((PSCoreSysServiceBaseBase.this.getDEModel().isEnableAudit() || PSCoreSysServiceBaseBase.this.getDEModel().getDataChangeLogMode() != 0) && !bl2) {
                    iEntity = PSCoreSysServiceBaseBase.this.getDEModel().createEntity();
                    iEntity2.copyTo((IDataObject)iEntity, true);
                    PSCoreSysServiceBaseBase.this.internalGet(iEntity, false);
                }
                if (PSCoreSysServiceBaseBase.this.getDEModel().isEnableAudit()) {
                    PSCoreSysServiceBaseBase.this.getDEModel().getDEDataAccMgr().audit(null, PSCoreSysServiceBaseBase.this.getWebContext(), iEntity, null, "CREATE");
                }
                PSCoreSysServiceBaseBase.this.syncEntity(iEntity2, false);
                PSCoreSysServiceBaseBase.this.pushDTSQueue(iEntity2);
                PSCoreSysServiceBaseBase.this.logDataChanged(1, iEntity);
                if (iServicePlugin != null) {
                    iServicePlugin.doCreate(PSCoreSysServiceBaseBase.this.getService(), 60, iServiceCreateParam, null);
                }
                iServiceCreateParam.doAfterAction(iEntity2);
                if (iServicePlugin != null) {
                    iServicePlugin.doCreate(PSCoreSysServiceBaseBase.this.getService(), 61, iServiceCreateParam, null);
                }
                PSCoreSysServiceBaseBase.this.resetLast(iEntity2);
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCreate(this.getService(), 99, iServiceCreateParam, null);
        }
    }

    public void update(ET ET, boolean bl) throws Exception {
        if (this.isUseServiceAPI()) {
            this.getServiceAPIClientModel().execute(this.getDEModel().getServiceAPIActionTag("DEACTION", "UPDATE"), ET);
            return;
        }
        ET ET2 = ET;
        boolean bl2 = bl || this.isNeedUpdateParent();
        boolean bl3 = EntityBase.isIgnoreCheck(ET2);
        ET2.setSessionFactory(this.getSessionFactory());
        IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doUpdate(this.getService(), 0, ET2, null).getResult() == 1) {
            return;
        }
        if (ET2.get(this.getDEModel().getKeyDEField().getName()) == null && !this.fillEntityKeyValue((IEntity)ET2, false)) {
            throw new ErrorException(4, (IDataEntity)this.getDEModel());
        }
        this.testDEMainStateAction((IEntity)ET, "UPDATE");
        this.onTestUpdate((IEntity)ET2);
        log.debug((Object)"\u5f00\u59cb[update]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork((IEntity)ET2, iServicePlugin, bl3, bl2){
            final /* synthetic */ IEntity val$et;
            final /* synthetic */ IServicePlugin val$iServicePlugin;
            final /* synthetic */ boolean val$bIgnoreCheck;
            final /* synthetic */ boolean val$bGet2;
            {
                this.val$et = iEntity;
                this.val$iServicePlugin = iServicePlugin;
                this.val$bIgnoreCheck = bl;
                this.val$bGet2 = bl2;
            }

            public void execute(ITransaction iTransaction) throws Exception {
                IEntity iEntity = null;
                if (PSCoreSysServiceBaseBase.this.isPrepareLastForUpdate()) {
                    iEntity = PSCoreSysServiceBaseBase.this.getLast(this.val$et);
                }
                PSCoreSysServiceBaseBase.this.updateTestNewOldData(this.val$et);
                PSCoreSysServiceBaseBase.this.writeBackParent(this.val$et, false);
                PSCoreSysServiceBaseBase.this.fillEntityFullInfo(this.val$et, false);
                if (this.val$iServicePlugin != null) {
                    this.val$iServicePlugin.doUpdate(PSCoreSysServiceBaseBase.this.getService(), 30, this.val$et, (Object)iEntity);
                }
                PSCoreSysServiceBaseBase.this.onBeforeUpdate(this.val$et);
                if (this.val$iServicePlugin != null) {
                    this.val$iServicePlugin.doUpdate(PSCoreSysServiceBaseBase.this.getService(), 31, this.val$et, (Object)iEntity);
                }
                if (!this.val$bIgnoreCheck) {
                    PSCoreSysServiceBaseBase.this.checkEntity(this.val$et, false, false);
                } else {
                    PSCoreSysServiceBaseBase.this.checkEntity(this.val$et, false, false, true);
                }
                PSCoreSysServiceBaseBase.this.setLast(this.val$et, (IEntity)INVALIDLAST, false);
                if (this.val$iServicePlugin == null || this.val$iServicePlugin.doUpdate(PSCoreSysServiceBaseBase.this.getService(), 40, this.val$et, (Object)iEntity).getResult() != 1) {
                    PSCoreSysServiceBaseBase.this.internalUpdate(this.val$et);
                }
                if (this.val$bGet2) {
                    PSCoreSysServiceBaseBase.this.internalGet(this.val$et, false);
                }
                PSCoreSysServiceBaseBase.this.syncDEUniState(this.val$et, this.val$bGet2, "UPDATE");
                if (PSCoreSysServiceBaseBase.this.isNeedUpdateParent()) {
                    PSCoreSysServiceBaseBase.this.updateParent(this.val$et);
                }
                IEntity iEntity2 = this.val$et;
                if ((PSCoreSysServiceBaseBase.this.getDEModel().isEnableAudit() || PSCoreSysServiceBaseBase.this.getDEModel().getDataChangeLogMode() != 0) && !this.val$bGet2) {
                    iEntity2 = PSCoreSysServiceBaseBase.this.getDEModel().createEntity();
                    this.val$et.copyTo((IDataObject)iEntity2, true);
                    PSCoreSysServiceBaseBase.this.internalGet(iEntity2, false);
                }
                if (PSCoreSysServiceBaseBase.this.getDEModel().isEnableAudit()) {
                    PSCoreSysServiceBaseBase.this.getDEModel().getDEDataAccMgr().audit(null, PSCoreSysServiceBaseBase.this.getWebContext(), iEntity2, PSCoreSysServiceBaseBase.this.getLast(this.val$et), "UPDATE");
                }
                PSCoreSysServiceBaseBase.this.syncEntity(this.val$et, false);
                PSCoreSysServiceBaseBase.this.logDataChanged(2, iEntity2);
                if (this.val$iServicePlugin != null) {
                    this.val$iServicePlugin.doUpdate(PSCoreSysServiceBaseBase.this.getService(), 60, this.val$et, (Object)iEntity);
                }
                PSCoreSysServiceBaseBase.this.onAfterUpdate(this.val$et);
                if (this.val$iServicePlugin != null) {
                    this.val$iServicePlugin.doUpdate(PSCoreSysServiceBaseBase.this.getService(), 61, this.val$et, (Object)iEntity);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doUpdate(this.getService(), 99, ET2, null);
        }
    }

    public void update(final IServiceUpdateParam<ET> iServiceUpdateParam) throws Exception {
        final IEntity iEntity = iServiceUpdateParam.getEntity();
        final boolean bl = iServiceUpdateParam.isReturnData() || this.isNeedUpdateParent();
        final boolean bl2 = EntityBase.isIgnoreCheck((IEntity)iEntity);
        iEntity.setSessionFactory(this.getSessionFactory());
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doUpdate(this.getService(), 0, iServiceUpdateParam, null).getResult() == 1) {
            return;
        }
        if (iEntity.get(this.getDEModel().getKeyDEField().getName()) == null && !this.fillEntityKeyValue(iEntity, false)) {
            throw new ErrorException(4, (IDataEntity)this.getDEModel());
        }
        this.testDEMainStateAction(iEntity, iServiceUpdateParam.getAction());
        if (!iServiceUpdateParam.testAction(iEntity)) {
            return;
        }
        log.debug((Object)StringHelper.format((String)"\u5f00\u59cb[%1$s]\u4f5c\u4e1a", (Object)iServiceUpdateParam.getAction()));
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                IEntity iEntity3 = null;
                if (iServiceUpdateParam.isPrepareLast()) {
                    iEntity3 = PSCoreSysServiceBaseBase.this.getLast(iEntity);
                }
                if (!iServiceUpdateParam.isSysUpdate()) {
                    PSCoreSysServiceBaseBase.this.updateTestNewOldData(iEntity);
                }
                PSCoreSysServiceBaseBase.this.writeBackParent(iEntity, false);
                PSCoreSysServiceBaseBase.this.fillEntityFullInfo(iEntity, false);
                if (iServicePlugin != null) {
                    iServicePlugin.doUpdate(PSCoreSysServiceBaseBase.this.getService(), 30, iServiceUpdateParam, (Object)iEntity3);
                }
                iServiceUpdateParam.doBeforeAction(iEntity);
                if (iServicePlugin != null) {
                    iServicePlugin.doUpdate(PSCoreSysServiceBaseBase.this.getService(), 31, iServiceUpdateParam, (Object)iEntity3);
                }
                if (!bl2) {
                    PSCoreSysServiceBaseBase.this.checkEntity(iEntity, false, false);
                } else {
                    PSCoreSysServiceBaseBase.this.checkEntity(iEntity, false, false, true);
                }
                PSCoreSysServiceBaseBase.this.setLast(iEntity, (IEntity)INVALIDLAST, false);
                if (iServicePlugin == null || iServicePlugin.doUpdate(PSCoreSysServiceBaseBase.this.getService(), 40, iServiceUpdateParam, (Object)iEntity3).getResult() != 1) {
                    if (!iServiceUpdateParam.isSysUpdate()) {
                        PSCoreSysServiceBaseBase.this.internalUpdate(iEntity);
                    } else {
                        PSCoreSysServiceBaseBase.this.internalSysUpdate(iEntity);
                    }
                }
                if (bl) {
                    PSCoreSysServiceBaseBase.this.internalGet(iEntity, false);
                }
                PSCoreSysServiceBaseBase.this.syncDEUniState(iEntity, bl, "UPDATE");
                if (PSCoreSysServiceBaseBase.this.isNeedUpdateParent()) {
                    PSCoreSysServiceBaseBase.this.updateParent(iEntity);
                }
                IEntity iEntity2 = iEntity;
                if (!iServiceUpdateParam.isSysUpdate()) {
                    if ((PSCoreSysServiceBaseBase.this.getDEModel().isEnableAudit() || PSCoreSysServiceBaseBase.this.getDEModel().getDataChangeLogMode() != 0) && !bl) {
                        iEntity2 = PSCoreSysServiceBaseBase.this.getDEModel().createEntity();
                        iEntity.copyTo((IDataObject)iEntity2, true);
                        PSCoreSysServiceBaseBase.this.internalGet(iEntity2, false);
                    }
                    if (PSCoreSysServiceBaseBase.this.getDEModel().isEnableAudit()) {
                        PSCoreSysServiceBaseBase.this.getDEModel().getDEDataAccMgr().audit(null, PSCoreSysServiceBaseBase.this.getWebContext(), iEntity2, PSCoreSysServiceBaseBase.this.getLast(iEntity), "UPDATE");
                    }
                }
                PSCoreSysServiceBaseBase.this.syncEntity(iEntity, false);
                PSCoreSysServiceBaseBase.this.logDataChanged(2, iEntity2);
                if (iServicePlugin != null) {
                    iServicePlugin.doUpdate(PSCoreSysServiceBaseBase.this.getService(), 60, iServiceUpdateParam, (Object)iEntity3);
                }
                iServiceUpdateParam.doAfterAction(iEntity);
                if (iServicePlugin != null) {
                    iServicePlugin.doUpdate(PSCoreSysServiceBaseBase.this.getService(), 61, iServiceUpdateParam, (Object)iEntity3);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doUpdate(this.getService(), 99, iServiceUpdateParam, null);
        }
    }

    public void sysUpdate(ET ET, boolean bl) throws Exception {
        ET ET2 = ET;
        boolean bl2 = bl || this.isNeedUpdateParent();
        boolean bl3 = EntityBase.isIgnoreCheck(ET2);
        ET2.setSessionFactory(this.getSessionFactory());
        if (ET2.get(this.getDEModel().getKeyDEField().getName()) == null && !this.fillEntityKeyValue((IEntity)ET2, false)) {
            throw new ErrorException(4, (IDataEntity)this.getDEModel());
        }
        this.onTestUpdate((IEntity)ET2);
        log.debug((Object)"\u5f00\u59cb[sysupdate]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork((IEntity)ET2, bl3, bl2){
            final /* synthetic */ IEntity val$et;
            final /* synthetic */ boolean val$bIgnoreCheck;
            final /* synthetic */ boolean val$bGet2;
            {
                this.val$et = iEntity;
                this.val$bIgnoreCheck = bl;
                this.val$bGet2 = bl2;
            }

            public void execute(ITransaction iTransaction) throws Exception {
                PSCoreSysServiceBaseBase.this.writeBackParent(this.val$et, false);
                PSCoreSysServiceBaseBase.this.fillEntityFullInfo(this.val$et, false);
                if (!this.val$bIgnoreCheck) {
                    PSCoreSysServiceBaseBase.this.checkEntity(this.val$et, false, false);
                } else {
                    PSCoreSysServiceBaseBase.this.checkEntity(this.val$et, false, false, true);
                }
                PSCoreSysServiceBaseBase.this.internalSysUpdate(this.val$et);
                if (this.val$bGet2) {
                    PSCoreSysServiceBaseBase.this.internalGet(this.val$et, false);
                }
                PSCoreSysServiceBaseBase.this.syncDEUniState(this.val$et, this.val$bGet2, "UPDATE");
                if (PSCoreSysServiceBaseBase.this.isNeedUpdateParent()) {
                    PSCoreSysServiceBaseBase.this.updateParent(this.val$et);
                }
                PSCoreSysServiceBaseBase.this.syncEntity(this.val$et, false);
            }
        });
    }

    public void update(ET ET) throws Exception {
        if (this.isUseServiceAPI()) {
            this.getServiceAPIClientModel().execute(this.getDEModel().getServiceAPIActionTag("DEACTION", "UPDATE"), ET);
            return;
        }
        this.update(ET, true);
    }

    protected void checkEntity(ET ET, boolean bl, boolean bl2, boolean bl3) throws Exception {
        EntityError entityError = new EntityError();
        IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCheckEntity(this.getService(), 0, ET, bl, bl2, entityError, null).getResult() == 1) {
            return;
        }
        if (iServicePlugin == null || iServicePlugin.doCheckEntity(this.getService(), 40, ET, bl, bl2, entityError, null).getResult() != 1) {
            this.onCheckEntity(true, (IEntity)ET, bl, bl2, entityError);
        }
        if (entityError.hasError()) {
            this.convertEntityError(entityError);
            throw new EntityException(entityError, (IDataEntity)this.getDEModel());
        }
        if (!bl3) {
            if (iServicePlugin == null || iServicePlugin.doCheckEntity(this.getService(), 45, ET, bl, bl2, entityError, null).getResult() != 1) {
                this.onCheckEntity(false, (IEntity)ET, bl, bl2, entityError);
            }
            if (entityError.hasError()) {
                this.convertEntityError(entityError);
                throw new EntityException(entityError, (IDataEntity)this.getDEModel());
            }
        }
        if (iServicePlugin != null) {
            iServicePlugin.doCheckEntity(this.getService(), 99, ET, bl, bl2, entityError, null);
        }
    }

    protected final void checkEntity(ET ET, boolean bl, boolean bl2) throws Exception {
        this.checkEntity(ET, bl, bl2, false);
    }
}

