/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.ServletContext
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.beans.factory.annotation.Qualifier
 *  org.springframework.web.context.ServletContextAware
 */
package net.ibizsys.paas.sysmodel;

import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import javax.servlet.ServletContext;
import net.ibizsys.paas.api.IServiceAPIAction;
import net.ibizsys.paas.api.IServiceAPIClientModel;
import net.ibizsys.paas.cache.DEUniStateModel;
import net.ibizsys.paas.cache.IUniStateManager;
import net.ibizsys.paas.cache.IUniStateModel;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.core.DER;
import net.ibizsys.paas.core.DERs;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.core.IDERBase;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.IPostConstructable;
import net.ibizsys.paas.core.ISystemSetting;
import net.ibizsys.paas.core.IValueTranslator;
import net.ibizsys.paas.core.ModelBase3Impl;
import net.ibizsys.paas.core.Plugin;
import net.ibizsys.paas.core.PluginActionResult;
import net.ibizsys.paas.core.PluginList;
import net.ibizsys.paas.core.ValueTranslatorGlobal;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.DBCallResult;
import net.ibizsys.paas.db.IDBDialect;
import net.ibizsys.paas.db.IDBFunction;
import net.ibizsys.paas.demodel.DEActionWizardModel;
import net.ibizsys.paas.demodel.DEDataSetDEAWModel;
import net.ibizsys.paas.demodel.DEFInputTipSetModel;
import net.ibizsys.paas.demodel.DEFInputTipSetModelGlobal;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.DER11Model;
import net.ibizsys.paas.demodel.DER1NModel;
import net.ibizsys.paas.demodel.DERIndexModel;
import net.ibizsys.paas.demodel.DERInheritModel;
import net.ibizsys.paas.demodel.DERMultiInheritModel;
import net.ibizsys.paas.demodel.IDEActionWizardModel;
import net.ibizsys.paas.demodel.IDEFInputTipSetModel;
import net.ibizsys.paas.demodel.IDEUIActionModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.dts.DTSQueueModel;
import net.ibizsys.paas.dts.IDTSQueueModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.security.DEDataAccMgr;
import net.ibizsys.paas.security.IDEDataAccMgr;
import net.ibizsys.paas.service.ActionSessionManager;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.IServicePlugin;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.sysmodel.CustomSystemUserRoleModel;
import net.ibizsys.paas.sysmodel.DEDataSetSystemUserRoleModel;
import net.ibizsys.paas.sysmodel.IDynaSystemSetting;
import net.ibizsys.paas.sysmodel.IExceptionHandler;
import net.ibizsys.paas.sysmodel.ISystemLogicModel;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.sysmodel.ISystemPartModel;
import net.ibizsys.paas.sysmodel.ISystemPlugin;
import net.ibizsys.paas.sysmodel.ISystemRuntime;
import net.ibizsys.paas.sysmodel.ISystemUserRoleModel;
import net.ibizsys.paas.sysmodel.ISystemUtil;
import net.ibizsys.paas.sysmodel.ISystemValueRuleModel;
import net.ibizsys.paas.sysmodel.SysModelGlobal;
import net.ibizsys.paas.sysmodel.SystemSettingModel;
import net.ibizsys.paas.sysmodel.SystemViewMsgGroupPlugin;
import net.ibizsys.paas.sysmodel.util.IAppCustomizeUtil;
import net.ibizsys.paas.util.FileHelper;
import net.ibizsys.paas.util.ObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.view.DEDataSetViewMsgModel;
import net.ibizsys.paas.view.IViewMessage;
import net.ibizsys.paas.view.IViewMsgGroupModel;
import net.ibizsys.paas.view.IViewMsgGroupPlugin;
import net.ibizsys.paas.view.IViewMsgModel;
import net.ibizsys.paas.view.IViewWizard;
import net.ibizsys.paas.view.IViewWizardGroupModel;
import net.ibizsys.paas.view.StaticViewMsgModel;
import net.ibizsys.paas.view.ViewMsgGroupModelGlobal;
import net.ibizsys.paas.view.ViewMsgModelGlobal;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.psba.core.BASchemeModelGlobal;
import net.ibizsys.psba.core.IBASchemeModel;
import net.ibizsys.psba.core.IBASchemeRuntime;
import net.ibizsys.psrt.srv.wf.entity.WFDynamicUser;
import net.ibizsys.psrt.srv.wf.entity.WFUserGroup;
import net.ibizsys.psrt.srv.wf.entity.WFWorkflow;
import net.ibizsys.psrt.srv.wf.service.WFDynamicUserService;
import net.ibizsys.psrt.srv.wf.service.WFUserGroupService;
import net.ibizsys.psrt.srv.wf.service.WFWorkflowService;
import net.ibizsys.pswf.core.IWFModel;
import net.ibizsys.pswf.core.IWFRoleModel;
import net.ibizsys.pswf.core.WFModelGlobal;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.context.ServletContextAware;

public abstract class SystemModelBase
extends ModelBase3Impl
implements ISystemModel,
ISystemRuntime,
ServletContextAware {
    private static final Log log = LogFactory.getLog(SystemModelBase.class);
    private HashMap<String, IDERBase> derBaseMap = new HashMap();
    private HashMap<String, IDataEntityModel> dataEntityModelMap = new HashMap();
    private HashMap<String, IDataEntityModel> dataEntityModelMap2 = new HashMap();
    private HashMap<String, IWFModel> wfModelMap = new HashMap();
    private HashMap<String, IWFRoleModel> wfRoleModelMap = new HashMap();
    private HashMap<String, ArrayList<IDERBase>> deMajorDERsMap = new HashMap();
    private HashMap<String, ArrayList<IDERBase>> deMinorDERsMap = new HashMap();
    private HashMap<String, IBASchemeModel> baSchemeModelMap = new HashMap();
    private HashMap<String, IDEFInputTipSetModel> defInputTipSetModelMap = new HashMap();
    private HashMap<String, IViewMsgGroupModel> viewMsgGroupModelMap = new HashMap();
    private HashMap<String, IViewMsgModel> viewMsgModelMap = new HashMap();
    private HashMap<String, IUniStateModel> uniStateModelMap = new HashMap();
    private HashMap<String, ISystemValueRuleModel> sysValueRuleModelMap = new HashMap();
    private HashMap<String, ISystemLogicModel> systemLogicModelMap = new HashMap();
    private HashMap<String, IDTSQueueModel> dstQueueModelMap = new HashMap();
    private HashMap<String, IServiceAPIClientModel> serviceAPIClientModelMap = new HashMap();
    private HashMap<String, ISystemUserRoleModel> sysUserRoleModelMap = new HashMap();
    private HashMap<String, IDEUIActionModel> deUIActionModelMap = new HashMap();
    private ServletContext servletContext = null;
    private static HashMap<String, String> replaceObjectMap = null;
    private ISystemPlugin iSystemPlugin = null;
    private IViewMsgGroupPlugin iViewMsgGroupPlugin = null;
    private SystemViewMsgGroupPlugin nullSystemViewMsgGroupPlugin = new SystemViewMsgGroupPlugin();
    private IServiceAPIClientModel iServiceAPIClientModel = null;
    private IDynaSystemSetting iDynaSystemSetting = null;
    protected SystemSettingModel systemSettingModel = new SystemSettingModel();
    private HashMap<String, ISystemPartModel> systemPartModelMap = new HashMap();
    private HashMap<String, ISystemUtil> systemUtilMap = new HashMap();
    private static String strModuleIId = null;
    @Autowired(required=false)
    @Qualifier(value="dbDialect")
    private IDBDialect dbDialect;
    @Autowired(required=false)
    @Qualifier(value="sessionFactory")
    private SessionFactory sessionFactory;
    @Autowired(required=false)
    @Qualifier(value="dbDialect2")
    private IDBDialect dbDialect2;
    @Autowired(required=false)
    @Qualifier(value="sessionFactory2")
    private SessionFactory sessionFactory2;
    @Autowired(required=false)
    @Qualifier(value="dbDialect3")
    private IDBDialect dbDialect3;
    @Autowired(required=false)
    @Qualifier(value="sessionFactory3")
    private SessionFactory sessionFactory3;
    @Autowired(required=false)
    @Qualifier(value="dbDialect4")
    private IDBDialect dbDialect4;
    @Autowired(required=false)
    @Qualifier(value="sessionFactory4")
    private SessionFactory sessionFactory4;
    @Autowired(required=false)
    @Qualifier(value="dbDialect5")
    private IDBDialect dbDialect5;
    @Autowired(required=false)
    @Qualifier(value="sessionFactory5")
    private SessionFactory sessionFactory5;
    @Autowired(required=false)
    @Qualifier(value="dbDialect6")
    private IDBDialect dbDialect6;
    @Autowired(required=false)
    @Qualifier(value="sessionFactory6")
    private SessionFactory sessionFactory6;
    @Autowired(required=false)
    @Qualifier(value="dbDialect7")
    private IDBDialect dbDialect7;
    @Autowired(required=false)
    @Qualifier(value="sessionFactory7")
    private SessionFactory sessionFactory7;
    @Autowired(required=false)
    @Qualifier(value="dbDialect8")
    private IDBDialect dbDialect8;
    @Autowired(required=false)
    @Qualifier(value="sessionFactory8")
    private SessionFactory sessionFactory8;
    @Autowired(required=false)
    @Qualifier(value="dbDialect9")
    private IDBDialect dbDialect9;
    @Autowired(required=false)
    @Qualifier(value="sessionFactory9")
    private SessionFactory sessionFactory9;
    @Autowired(required=false)
    @Qualifier(value="dbDialect10")
    private IDBDialect dbDialect10;
    @Autowired(required=false)
    @Qualifier(value="sessionFactory10")
    private SessionFactory sessionFactory10;
    @Autowired(required=false)
    @Qualifier(value="dbDialect11")
    private IDBDialect dbDialect11;
    @Autowired(required=false)
    @Qualifier(value="sessionFactory11")
    private SessionFactory sessionFactory11;
    @Autowired(required=false)
    @Qualifier(value="dbDialect12")
    private IDBDialect dbDialect12;
    @Autowired(required=false)
    @Qualifier(value="sessionFactory12")
    private SessionFactory sessionFactory12;
    @Autowired(required=false)
    @Qualifier(value="uniStateManager")
    private IUniStateManager uniStateManager;
    @Autowired(required=false)
    @Qualifier(value="noViewMode")
    private Boolean noViewMode;

    protected void initAnnotation(Class c) {
        Annotation[] annotations = c.getAnnotations();
        if (annotations != null) {
            Annotation[] annotationArray = annotations;
            int n = annotations.length;
            int n2 = 0;
            while (n2 < n) {
                Annotation annotation = annotationArray[n2];
                if (annotation instanceof DERs) {
                    this.prepareDERs((DERs)annotation);
                }
                ++n2;
            }
        }
    }

    protected void prepareDERs(DERs ders) {
        DER[] dERArray = ders.value();
        int n = dERArray.length;
        int n2 = 0;
        while (n2 < n) {
            DER der = dERArray[n2];
            IDERBase iDERBase = this.createDERBase(der);
            this.derBaseMap.put(iDERBase.getId(), iDERBase);
            this.derBaseMap.put(iDERBase.getName(), iDERBase);
            String strMajorDEId = iDERBase.getMajorDEId();
            String strMinorDEId = iDERBase.getMinorDEId();
            ArrayList<IDERBase> majorDERList = this.deMajorDERsMap.get(strMajorDEId);
            if (majorDERList == null) {
                majorDERList = new ArrayList();
                this.deMajorDERsMap.put(strMajorDEId, majorDERList);
            }
            majorDERList.add(iDERBase);
            ArrayList<IDERBase> minorDERList = this.deMinorDERsMap.get(strMinorDEId);
            if (minorDERList == null) {
                minorDERList = new ArrayList();
                this.deMinorDERsMap.put(strMinorDEId, minorDERList);
            }
            minorDERList.add(iDERBase);
            ++n2;
        }
    }

    protected IDERBase createDERBase(DER der) {
        if (StringHelper.compare(der.type(), "DER1N", true) == 0) {
            DER1NModel der1nModel = new DER1NModel();
            der1nModel.init(this, der);
            return der1nModel;
        }
        if (StringHelper.compare(der.type(), "DER11", true) == 0) {
            DER11Model der11Model = new DER11Model();
            der11Model.init(this, der);
            return der11Model;
        }
        if (StringHelper.compare(der.type(), "DERINHERIT", true) == 0) {
            DERInheritModel derInheritModel = new DERInheritModel();
            derInheritModel.init(this, der);
            return derInheritModel;
        }
        if (StringHelper.compare(der.type(), "DERINDEX", true) == 0) {
            DERIndexModel derIndexModel = new DERIndexModel();
            derIndexModel.init(this, der);
            return derIndexModel;
        }
        if (StringHelper.compare(der.type(), "DERMULINH", true) == 0) {
            DERMultiInheritModel derMultiInheritModel = new DERMultiInheritModel();
            derMultiInheritModel.init(this, der);
            return derMultiInheritModel;
        }
        return null;
    }

    @Override
    public IDataEntityModel getDataEntityModel(String strDEName, boolean bIncludeOtherSys) throws Exception {
        IDataEntityModel iDataEntityModel = this.dataEntityModelMap.get(strDEName);
        if (iDataEntityModel == null) {
            if (bIncludeOtherSys) {
                return DEModelGlobal.getDEModel(strDEName);
            }
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53[%1$s]", strDEName));
        }
        return iDataEntityModel;
    }

    public boolean containsDataEntityModel(String strDEName, boolean bIncludeOtherSys) {
        IDataEntityModel iDataEntityModel = this.dataEntityModelMap.get(strDEName);
        if (iDataEntityModel == null && bIncludeOtherSys) {
            return DEModelGlobal.containsDEModel(strDEName);
        }
        return iDataEntityModel != null;
    }

    @Override
    public IDataEntityModel getDataEntityModel(String strDEName) throws Exception {
        return this.getDataEntityModel(strDEName, true);
    }

    @Override
    public IDataEntity getDataEntity(String strDataEntityId) throws Exception {
        return this.getDataEntityModel(strDataEntityId);
    }

    @Override
    public IDERBase getDER(String strDERId) throws Exception {
        IDERBase iDERBase = this.derBaseMap.get(strDERId);
        if (iDERBase == null) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5173\u7cfb[%1$s]", strDERId));
        }
        return iDERBase;
    }

    @Override
    public IDERBase getDER(String strDERId, boolean bTryMode) throws Exception {
        IDERBase iDERBase = this.derBaseMap.get(strDERId);
        if (iDERBase == null && !bTryMode) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5173\u7cfb[%1$s]", strDERId));
        }
        return iDERBase;
    }

    @Override
    public ICodeList getCodeList(String strCodeListId) throws Exception {
        return null;
    }

    public void setDBDialect(IDBDialect dbDialect) {
        this.dbDialect = dbDialect;
    }

    @Override
    public IDBDialect getDBDialect() {
        return this.dbDialect;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public SessionFactory getSessionFactory() {
        return this.sessionFactory;
    }

    @Override
    public IWFModel getWFModel(String strWFModelId) throws Exception {
        return this.getWFModel(strWFModelId, false);
    }

    @Override
    public IWFModel getWFModel(String strWFModelId, boolean bTryMode) throws Exception {
        IWFModel iWFModel = this.wfModelMap.get(strWFModelId);
        if (iWFModel == null && !bTryMode) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6d41\u7a0b\uff0c\u6d41\u7a0b\u6807\u8bc6[%1$s]", strWFModelId));
        }
        return iWFModel;
    }

    protected Iterator<IWFModel> getWFModels() {
        return this.wfModelMap.values().iterator();
    }

    @Override
    public IWFRoleModel getWFRoleModel(String strWFRoleModelId) throws Exception {
        return this.getWFRoleModel(strWFRoleModelId, false);
    }

    @Override
    public IWFRoleModel getWFRoleModel(String strWFRoleModelId, boolean bTryMode) throws Exception {
        IWFRoleModel iWFRoleModel = this.wfRoleModelMap.get(strWFRoleModelId);
        if (iWFRoleModel == null && !bTryMode) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6d41\u7a0b\u89d2\u8272\uff0c\u89d2\u8272\u6807\u8bc6[%1$s]", strWFRoleModelId));
        }
        return iWFRoleModel;
    }

    @Override
    public void registerDataEntityModel(IDataEntityModel iDataEntityModel) throws Exception {
        String strId = iDataEntityModel.getId();
        String strName = iDataEntityModel.getName();
        this.dataEntityModelMap.put(strId, iDataEntityModel);
        this.dataEntityModelMap.put(strName, iDataEntityModel);
        this.dataEntityModelMap2.put(strId, iDataEntityModel);
    }

    @Override
    public void registerWFModel(IWFModel iWFModel) throws Exception {
        String strId = iWFModel.getId();
        if (this.wfModelMap.containsKey(strId)) {
            throw new Exception(StringHelper.format("\u7cfb\u7edf\u4e2d\u5df2\u7ecf\u6ce8\u518c\u4e86\u6807\u8bc6\u4e3a[%1$s]\u7684\u6d41\u7a0b\u6a21\u578b", strId));
        }
        this.wfModelMap.put(strId, iWFModel);
        WFModelGlobal.registerWFModel(iWFModel.getClass().getCanonicalName(), iWFModel);
    }

    @Override
    public void registerWFRoleModel(IWFRoleModel iWFRoleModel) throws Exception {
        String strId = iWFRoleModel.getId();
        if (this.wfRoleModelMap.containsKey(strId)) {
            throw new Exception(StringHelper.format("\u7cfb\u7edf\u4e2d\u5df2\u7ecf\u6ce8\u518c\u4e86\u6807\u8bc6\u4e3a[%1$s]\u7684\u6d41\u7a0b\u89d2\u8272\u6a21\u578b", strId));
        }
        this.wfRoleModelMap.put(strId, iWFRoleModel);
    }

    @Override
    public void registerBASchemeModel(IBASchemeModel iBASchemeModel) throws Exception {
        String strId = iBASchemeModel.getId();
        if (this.baSchemeModelMap.containsKey(strId)) {
            throw new Exception(StringHelper.format("\u7cfb\u7edf\u4e2d\u5df2\u7ecf\u6ce8\u518c\u4e86\u6807\u8bc6\u4e3a[%1$s]\u7684\u5927\u6570\u636e\u67b6\u6784\u6a21\u578b", strId));
        }
        this.baSchemeModelMap.put(strId, iBASchemeModel);
        BASchemeModelGlobal.registerBASchemeModel(iBASchemeModel.getClass().getCanonicalName(), iBASchemeModel);
    }

    @Override
    public IBASchemeModel getBASchemeModel(String strBASchemeModelId) throws Exception {
        IBASchemeModel iBASchemeModel = this.baSchemeModelMap.get(strBASchemeModelId);
        if (iBASchemeModel == null) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5927\u6570\u636e\u67b6\u6784\u6a21\u578b\uff0c\u5927\u6570\u636e\u67b6\u6784\u6a21\u578b\u6807\u8bc6[%1$s]", strBASchemeModelId));
        }
        return iBASchemeModel;
    }

    @Override
    public IDEFInputTipSetModel createDEFInputTipSetModel(String strUserTag) throws Exception {
        return new DEFInputTipSetModel();
    }

    @Override
    public void registerDEFInputTipSetModel(IDEFInputTipSetModel iDEFInputTipSetModel) throws Exception {
        String strId = iDEFInputTipSetModel.getId();
        if (this.defInputTipSetModelMap.containsKey(strId)) {
            throw new Exception(StringHelper.format("\u7cfb\u7edf\u4e2d\u5df2\u7ecf\u6ce8\u518c\u4e86\u6807\u8bc6\u4e3a[%1$s]\u7684\u5c5e\u6027\u8f93\u5165\u63d0\u793a\u96c6\u5408\u6a21\u578b", strId));
        }
        this.defInputTipSetModelMap.put(strId, iDEFInputTipSetModel);
        DEFInputTipSetModelGlobal.registerDEFInputTipSet(iDEFInputTipSetModel.getClass().getCanonicalName(), iDEFInputTipSetModel);
    }

    @Override
    public IDEFInputTipSetModel getDEFInputTipSetModel(String strDEFInputTipSetModelId) throws Exception {
        IDEFInputTipSetModel iDEFInputTipSetModel = this.defInputTipSetModelMap.get(strDEFInputTipSetModelId);
        if (iDEFInputTipSetModel == null) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5c5e\u6027\u8f93\u5165\u63d0\u793a\u96c6\u5408\u6a21\u578b\uff0c\u5c5e\u6027\u8f93\u5165\u63d0\u793a\u96c6\u5408\u6807\u8bc6\u6a21\u578b[%1$s]", strDEFInputTipSetModelId));
        }
        return iDEFInputTipSetModel;
    }

    @Override
    public void registerViewMsgGroupModel(IViewMsgGroupModel iViewMsgGroupModel) throws Exception {
        String strId = iViewMsgGroupModel.getId();
        if (this.viewMsgGroupModelMap.containsKey(strId)) {
            throw new Exception(StringHelper.format("\u7cfb\u7edf\u4e2d\u5df2\u7ecf\u6ce8\u518c\u4e86\u6807\u8bc6\u4e3a[%1$s]\u7684\u89c6\u56fe\u6d88\u606f\u7ec4\u6a21\u578b", strId));
        }
        this.viewMsgGroupModelMap.put(strId, iViewMsgGroupModel);
        ViewMsgGroupModelGlobal.registerViewMsgGroup(iViewMsgGroupModel.getClass().getCanonicalName(), iViewMsgGroupModel);
    }

    @Override
    public IViewMsgGroupModel getViewMsgGroupModel(String strViewMsgGroupModelId) throws Exception {
        IViewMsgGroupModel iViewMsgGroupModel = this.viewMsgGroupModelMap.get(strViewMsgGroupModelId);
        if (iViewMsgGroupModel == null) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u89c6\u56fe\u6d88\u606f\u7ec4\u6a21\u578b\uff0c\u89c6\u56fe\u6d88\u606f\u7ec4\u6a21\u578b\u6807\u8bc6[%1$s]", strViewMsgGroupModelId));
        }
        return iViewMsgGroupModel;
    }

    @Override
    public void registerViewMsgModel(IViewMsgModel iViewMsgModel) throws Exception {
        String strId = iViewMsgModel.getId();
        if (this.viewMsgModelMap.containsKey(strId)) {
            throw new Exception(StringHelper.format("\u7cfb\u7edf\u4e2d\u5df2\u7ecf\u6ce8\u518c\u4e86\u6807\u8bc6\u4e3a[%1$s]\u7684\u89c6\u56fe\u6d88\u606f\u6a21\u578b", strId));
        }
        this.viewMsgModelMap.put(strId, iViewMsgModel);
        ViewMsgModelGlobal.registerViewMsg(iViewMsgModel.getClass().getCanonicalName(), iViewMsgModel);
    }

    @Override
    public IViewMsgModel getViewMsgModel(String strViewMsgModelId) throws Exception {
        IViewMsgModel iViewMsgModel = this.viewMsgModelMap.get(strViewMsgModelId);
        if (iViewMsgModel == null) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u89c6\u56fe\u6d88\u606f\u6a21\u578b\uff0c\u89c6\u56fe\u6d88\u606f\u6a21\u578b\u6807\u8bc6[%1$s]", strViewMsgModelId));
        }
        return iViewMsgModel;
    }

    @Override
    public void registerUniStateModel(IUniStateModel iUniStateModel) throws Exception {
        String strId = iUniStateModel.getId();
        if (this.uniStateModelMap.containsKey(strId)) {
            throw new Exception(StringHelper.format("\u7cfb\u7edf\u4e2d\u5df2\u7ecf\u6ce8\u518c\u4e86\u6807\u8bc6\u4e3a[%1$s]\u7684\u7edf\u4e00\u72b6\u6001\u534f\u540c\u5bf9\u8c61", strId));
        }
        if (this.uniStateModelMap.containsKey(iUniStateModel.getUniqueTag())) {
            throw new Exception(StringHelper.format("\u7cfb\u7edf\u4e2d\u5df2\u7ecf\u6ce8\u518c\u4e86\u6807\u8bc6\u4e3a[%1$s]\u7684\u7edf\u4e00\u72b6\u6001\u534f\u540c\u5bf9\u8c61", iUniStateModel.getUniqueTag()));
        }
        this.uniStateModelMap.put(strId, iUniStateModel);
        this.uniStateModelMap.put(iUniStateModel.getUniqueTag(), iUniStateModel);
    }

    @Override
    public IUniStateModel getUniStateModel(String strUniStateModelId) throws Exception {
        IUniStateModel iUniStateModel = this.uniStateModelMap.get(strUniStateModelId);
        if (iUniStateModel == null) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u7edf\u4e00\u72b6\u6001\u534f\u540c\u5bf9\u8c61\uff0c\u7edf\u4e00\u72b6\u6001\u534f\u540c\u5bf9\u8c61\u6807\u8bc6[%1$s]", strUniStateModelId));
        }
        return iUniStateModel;
    }

    @Override
    public IUniStateModel createUniStateModel(String strType, String strUserTag) throws Exception {
        if (StringHelper.compare(strType, "DE", true) == 0) {
            return new DEUniStateModel();
        }
        return null;
    }

    @Override
    public void registerDTSQueueModel(IDTSQueueModel iDTSQueueModel) throws Exception {
        String strId = iDTSQueueModel.getId();
        if (this.dstQueueModelMap.containsKey(strId)) {
            throw new Exception(StringHelper.format("\u7cfb\u7edf\u4e2d\u5df2\u7ecf\u6ce8\u518c\u4e86\u6807\u8bc6\u4e3a[%1$s]\u7684\u5206\u5e03\u4e8b\u52a1\u961f\u5217\u534f\u540c\u5bf9\u8c61", strId));
        }
        this.dstQueueModelMap.put(strId, iDTSQueueModel);
    }

    @Override
    public IDTSQueueModel getDTSQueueModel(String strDTSQueueModelId) throws Exception {
        IDTSQueueModel iDTSQueueModel = this.dstQueueModelMap.get(strDTSQueueModelId);
        if (iDTSQueueModel == null) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5206\u5e03\u4e8b\u52a1\u961f\u5217\u534f\u540c\u5bf9\u8c61\uff0c\u5206\u5e03\u4e8b\u52a1\u961f\u5217\u534f\u540c\u5bf9\u8c61\u6807\u8bc6[%1$s]", strDTSQueueModelId));
        }
        return iDTSQueueModel;
    }

    @Override
    public IDTSQueueModel createDTSQueueModel(String strType, String strUserTag) throws Exception {
        return new DTSQueueModel();
    }

    @Override
    public void registerSystemValueRuleModel(ISystemValueRuleModel iSystemValueRuleModel) throws Exception {
        String strId = iSystemValueRuleModel.getId();
        if (this.sysValueRuleModelMap.containsKey(strId)) {
            throw new Exception(StringHelper.format("\u7cfb\u7edf\u4e2d\u5df2\u7ecf\u6ce8\u518c\u4e86\u6807\u8bc6\u4e3a[%1$s]\u7684\u503c\u89c4\u5219\u5bf9\u8c61", strId));
        }
        if (!StringHelper.isNullOrEmpty(iSystemValueRuleModel.getUniqueTag()) && this.sysValueRuleModelMap.containsKey(iSystemValueRuleModel.getUniqueTag())) {
            throw new Exception(StringHelper.format("\u7cfb\u7edf\u4e2d\u5df2\u7ecf\u6ce8\u518c\u4e86\u6807\u8bc6\u4e3a[%1$s]\u7684\u503c\u89c4\u5219\u5bf9\u8c61", iSystemValueRuleModel.getUniqueTag()));
        }
        this.sysValueRuleModelMap.put(strId, iSystemValueRuleModel);
        if (!StringHelper.isNullOrEmpty(iSystemValueRuleModel.getUniqueTag())) {
            this.sysValueRuleModelMap.put(iSystemValueRuleModel.getUniqueTag(), iSystemValueRuleModel);
        }
    }

    @Override
    public ISystemValueRuleModel getSystemValueRuleModel(String strValueRuleModelId) throws Exception {
        ISystemValueRuleModel iSystemValueRuleModel = this.sysValueRuleModelMap.get(strValueRuleModelId);
        if (iSystemValueRuleModel == null) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u503c\u89c4\u5219\u5bf9\u8c61\uff0c\u503c\u89c4\u5219\u5bf9\u8c61\u6807\u8bc6[%1$s]", strValueRuleModelId));
        }
        return iSystemValueRuleModel;
    }

    @Override
    public void registerSystemLogicModel(ISystemLogicModel iSystemLogicModel) throws Exception {
        String strId = iSystemLogicModel.getId();
        if (this.systemLogicModelMap.containsKey(strId)) {
            throw new Exception(StringHelper.format("\u7cfb\u7edf\u4e2d\u5df2\u7ecf\u6ce8\u518c\u4e86\u6807\u8bc6\u4e3a[%1$s]\u7684\u7cfb\u7edf\u903b\u8f91\u5bf9\u8c61", strId));
        }
        if (!StringHelper.isNullOrEmpty(iSystemLogicModel.getUniqueTag()) && this.systemLogicModelMap.containsKey(iSystemLogicModel.getUniqueTag())) {
            throw new Exception(StringHelper.format("\u7cfb\u7edf\u4e2d\u5df2\u7ecf\u6ce8\u518c\u4e86\u6807\u8bc6\u4e3a[%1$s]\u7684\u7cfb\u7edf\u903b\u8f91\u5bf9\u8c61", iSystemLogicModel.getUniqueTag()));
        }
        this.systemLogicModelMap.put(strId, iSystemLogicModel);
        if (!StringHelper.isNullOrEmpty(iSystemLogicModel.getUniqueTag())) {
            this.systemLogicModelMap.put(iSystemLogicModel.getUniqueTag(), iSystemLogicModel);
        }
    }

    @Override
    public ISystemLogicModel getSystemLogicModel(String strSystemLogicModelId) throws Exception {
        ISystemLogicModel iSystemLogicModel = this.systemLogicModelMap.get(strSystemLogicModelId);
        if (iSystemLogicModel == null) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u903b\u8f91\u5bf9\u8c61\uff0c\u7cfb\u7edf\u903b\u8f91\u6807\u8bc6[%1$s]", strSystemLogicModelId));
        }
        return iSystemLogicModel;
    }

    protected void setId(String strId) {
        this.strId = strId;
    }

    protected void setName(String strName) {
        this.strName = strName;
    }

    @Override
    public Iterator<IWFRoleModel> getWFRoleModels() {
        return this.wfRoleModelMap.values().iterator();
    }

    @Override
    public IDBDialect getDBDialect(String strDSLink) {
        if (StringHelper.isNullOrEmpty(strDSLink) || StringHelper.compare(strDSLink, "DEFAULT", true) == 0) {
            return this.getDBDialect();
        }
        if (StringHelper.compare(strDSLink, "DB2", true) == 0) {
            return this.getDBDialect2();
        }
        if (StringHelper.compare(strDSLink, "DB3", true) == 0) {
            return this.getDBDialect3();
        }
        if (StringHelper.compare(strDSLink, "DB4", true) == 0) {
            return this.getDBDialect4();
        }
        if (StringHelper.compare(strDSLink, "DB5", true) == 0) {
            return this.getDBDialect5();
        }
        if (StringHelper.compare(strDSLink, "DB6", true) == 0) {
            return this.getDBDialect6();
        }
        if (StringHelper.compare(strDSLink, "DB7", true) == 0) {
            return this.getDBDialect7();
        }
        if (StringHelper.compare(strDSLink, "DB8", true) == 0) {
            return this.getDBDialect8();
        }
        if (StringHelper.compare(strDSLink, "DB9", true) == 0) {
            return this.getDBDialect9();
        }
        if (StringHelper.compare(strDSLink, "DB10", true) == 0) {
            return this.getDBDialect10();
        }
        if (StringHelper.compare(strDSLink, "DB11", true) == 0) {
            return this.getDBDialect11();
        }
        if (StringHelper.compare(strDSLink, "DB12", true) == 0) {
            return this.getDBDialect12();
        }
        return this.getDBDialect();
    }

    @Override
    public SessionFactory getSessionFactory(String strDSLink) {
        if (StringHelper.isNullOrEmpty(strDSLink) || StringHelper.compare(strDSLink, "DEFAULT", true) == 0) {
            return this.getSessionFactory();
        }
        if (StringHelper.compare(strDSLink, "DB2", true) == 0) {
            return this.getSessionFactory2();
        }
        if (StringHelper.compare(strDSLink, "DB3", true) == 0) {
            return this.getSessionFactory3();
        }
        if (StringHelper.compare(strDSLink, "DB4", true) == 0) {
            return this.getSessionFactory4();
        }
        if (StringHelper.compare(strDSLink, "DB5", true) == 0) {
            return this.getSessionFactory5();
        }
        if (StringHelper.compare(strDSLink, "DB6", true) == 0) {
            return this.getSessionFactory6();
        }
        if (StringHelper.compare(strDSLink, "DB7", true) == 0) {
            return this.getSessionFactory7();
        }
        if (StringHelper.compare(strDSLink, "DB8", true) == 0) {
            return this.getSessionFactory8();
        }
        if (StringHelper.compare(strDSLink, "DB9", true) == 0) {
            return this.getSessionFactory9();
        }
        if (StringHelper.compare(strDSLink, "DB10", true) == 0) {
            return this.getSessionFactory10();
        }
        if (StringHelper.compare(strDSLink, "DB11", true) == 0) {
            return this.getSessionFactory11();
        }
        if (StringHelper.compare(strDSLink, "DB12", true) == 0) {
            return this.getSessionFactory12();
        }
        return this.getSessionFactory();
    }

    @Override
    public IDBDialect getDBDialect2() {
        if (this.dbDialect2 != null) {
            return this.dbDialect2;
        }
        return this.getDBDialect();
    }

    @Override
    public SessionFactory getSessionFactory2() {
        if (this.sessionFactory2 != null) {
            return this.sessionFactory2;
        }
        return this.getSessionFactory();
    }

    @Override
    public IDBDialect getDBDialect3() {
        if (this.dbDialect3 != null) {
            return this.dbDialect3;
        }
        return this.getDBDialect();
    }

    @Override
    public SessionFactory getSessionFactory3() {
        if (this.sessionFactory3 != null) {
            return this.sessionFactory3;
        }
        return this.getSessionFactory();
    }

    @Override
    public IDBDialect getDBDialect4() {
        if (this.dbDialect4 != null) {
            return this.dbDialect4;
        }
        return this.getDBDialect();
    }

    @Override
    public SessionFactory getSessionFactory4() {
        if (this.sessionFactory4 != null) {
            return this.sessionFactory4;
        }
        return this.getSessionFactory();
    }

    @Override
    public IDBDialect getDBDialect5() {
        if (this.dbDialect5 != null) {
            return this.dbDialect5;
        }
        return this.getDBDialect();
    }

    @Override
    public SessionFactory getSessionFactory5() {
        if (this.sessionFactory5 != null) {
            return this.sessionFactory5;
        }
        return this.getSessionFactory();
    }

    @Override
    public IDBDialect getDBDialect6() {
        if (this.dbDialect6 != null) {
            return this.dbDialect6;
        }
        return this.getDBDialect();
    }

    @Override
    public SessionFactory getSessionFactory6() {
        if (this.sessionFactory6 != null) {
            return this.sessionFactory6;
        }
        return this.getSessionFactory();
    }

    @Override
    public IDBDialect getDBDialect7() {
        if (this.dbDialect7 != null) {
            return this.dbDialect7;
        }
        return this.getDBDialect();
    }

    @Override
    public SessionFactory getSessionFactory7() {
        if (this.sessionFactory7 != null) {
            return this.sessionFactory7;
        }
        return this.getSessionFactory();
    }

    @Override
    public IDBDialect getDBDialect8() {
        if (this.dbDialect8 != null) {
            return this.dbDialect8;
        }
        return this.getDBDialect();
    }

    @Override
    public SessionFactory getSessionFactory8() {
        if (this.sessionFactory8 != null) {
            return this.sessionFactory8;
        }
        return this.getSessionFactory();
    }

    @Override
    public IDBDialect getDBDialect9() {
        if (this.dbDialect9 != null) {
            return this.dbDialect9;
        }
        return this.getDBDialect();
    }

    @Override
    public SessionFactory getSessionFactory9() {
        if (this.sessionFactory9 != null) {
            return this.sessionFactory9;
        }
        return this.getSessionFactory();
    }

    @Override
    public IDBDialect getDBDialect10() {
        if (this.dbDialect10 != null) {
            return this.dbDialect10;
        }
        return this.getDBDialect();
    }

    @Override
    public SessionFactory getSessionFactory10() {
        if (this.sessionFactory10 != null) {
            return this.sessionFactory10;
        }
        return this.getSessionFactory();
    }

    @Override
    public IDBDialect getDBDialect11() {
        if (this.dbDialect11 != null) {
            return this.dbDialect11;
        }
        return this.getDBDialect();
    }

    @Override
    public SessionFactory getSessionFactory11() {
        if (this.sessionFactory11 != null) {
            return this.sessionFactory11;
        }
        return this.getSessionFactory();
    }

    @Override
    public IDBDialect getDBDialect12() {
        if (this.dbDialect12 != null) {
            return this.dbDialect12;
        }
        return this.getDBDialect();
    }

    @Override
    public SessionFactory getSessionFactory12() {
        if (this.sessionFactory12 != null) {
            return this.sessionFactory12;
        }
        return this.getSessionFactory();
    }

    public void postConstruct() throws Exception {
        if (this.dbDialect != null && this.sessionFactory != null) {
            DAOGlobal.registerDBDialect(this.sessionFactory, this.dbDialect);
        }
        if (this.dbDialect2 != null && this.sessionFactory2 != null) {
            DAOGlobal.registerDBDialect(this.sessionFactory2, this.dbDialect2);
        }
        if (this.dbDialect3 != null && this.sessionFactory3 != null) {
            DAOGlobal.registerDBDialect(this.sessionFactory3, this.dbDialect3);
        }
        if (this.dbDialect4 != null && this.sessionFactory4 != null) {
            DAOGlobal.registerDBDialect(this.sessionFactory4, this.dbDialect4);
        }
        if (this.dbDialect5 != null && this.sessionFactory5 != null) {
            DAOGlobal.registerDBDialect(this.sessionFactory5, this.dbDialect5);
        }
        if (this.dbDialect6 != null && this.sessionFactory6 != null) {
            DAOGlobal.registerDBDialect(this.sessionFactory6, this.dbDialect6);
        }
        if (this.dbDialect7 != null && this.sessionFactory7 != null) {
            DAOGlobal.registerDBDialect(this.sessionFactory7, this.dbDialect7);
        }
        if (this.dbDialect8 != null && this.sessionFactory8 != null) {
            DAOGlobal.registerDBDialect(this.sessionFactory8, this.dbDialect8);
        }
        if (this.dbDialect9 != null && this.sessionFactory9 != null) {
            DAOGlobal.registerDBDialect(this.sessionFactory9, this.dbDialect9);
        }
        if (this.dbDialect10 != null && this.sessionFactory10 != null) {
            DAOGlobal.registerDBDialect(this.sessionFactory10, this.dbDialect10);
        }
        if (this.dbDialect11 != null && this.sessionFactory11 != null) {
            DAOGlobal.registerDBDialect(this.sessionFactory11, this.dbDialect11);
        }
        if (this.dbDialect12 != null && this.sessionFactory12 != null) {
            DAOGlobal.registerDBDialect(this.sessionFactory12, this.dbDialect12);
        }
    }

    @Override
    public void installRTDatas() throws Exception {
        this.installBASchemes();
        this.installWFRTDatas();
        this.installAppCustomizedDatas();
        this.onInstallRTDatas();
    }

    protected void onInstallRTDatas() throws Exception {
    }

    protected void installAppCustomizedDatas() throws Exception {
        ISystemUtil iSystemUtil = this.getSystemUtil("APPCUSTOMIZE", true);
        if (iSystemUtil != null) {
            ((IAppCustomizeUtil)iSystemUtil).installAll();
        }
    }

    protected void installWFRTDatas() throws Exception {
        WFUserGroupService wfUserGroupService = (WFUserGroupService)ServiceGlobal.getService(WFUserGroupService.class);
        WFDynamicUserService wfDynamicUserService = (WFDynamicUserService)ServiceGlobal.getService(WFDynamicUserService.class);
        Iterator<IWFRoleModel> wfRoleModes = this.getWFRoleModels();
        if (wfRoleModes != null) {
            while (wfRoleModes.hasNext()) {
                IWFRoleModel iWFRoleModel = wfRoleModes.next();
                if (StringHelper.compare(iWFRoleModel.getWFRoleType(), "USERGROUP", true) == 0) {
                    WFUserGroup wfUserGroup = new WFUserGroup();
                    wfUserGroup.setWFUserGroupId(iWFRoleModel.getId());
                    wfUserGroup.setWFUserGroupName(iWFRoleModel.getName());
                    wfUserGroup.set("SRF_PERSONID", "SYSTEM");
                    wfUserGroup.set("SRF_LOGINNAME", "SYSTEM");
                    wfUserGroup.set("SRF_PERSONNAME", "\u7cfb\u7edf\u5185\u5efa\u7528\u6237");
                    wfUserGroupService.save(wfUserGroup);
                    ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), wfUserGroupService.getDEModel().getLogicName(), wfUserGroupService.getDEModel().getDataInfo(wfUserGroup)));
                    continue;
                }
                if (StringHelper.compare(iWFRoleModel.getWFRoleType(), "CUSTOM", true) != 0) continue;
                WFDynamicUser wfDynamicUser = new WFDynamicUser();
                wfDynamicUser.setWFDynamicUserId(iWFRoleModel.getId());
                wfDynamicUser.setWFDynamicUserName(iWFRoleModel.getName());
                wfDynamicUser.setUserObject("#");
                wfDynamicUser.set("SRF_PERSONID", "SYSTEM");
                wfDynamicUser.set("SRF_LOGINNAME", "SYSTEM");
                wfDynamicUser.set("SRF_PERSONNAME", "\u7cfb\u7edf\u5185\u5efa\u7528\u6237");
                wfDynamicUserService.save(wfDynamicUser);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), wfDynamicUserService.getDEModel().getLogicName(), wfDynamicUserService.getDEModel().getDataInfo(wfDynamicUser)));
            }
        }
        for (IWFModel iWFModel : this.wfModelMap.values()) {
            WFWorkflowService wfWorkflowService = (WFWorkflowService)ServiceGlobal.getService(WFWorkflowService.class);
            WFWorkflow wfWorkflow = new WFWorkflow();
            wfWorkflow.setWFWorkflowId(iWFModel.getId());
            if (wfWorkflowService.checkKey(wfWorkflow) != 0) continue;
            wfWorkflow.setWFWorkflowName(iWFModel.getName());
            wfWorkflow.setWFState(1);
            if (!StringHelper.isNullOrEmpty(iWFModel.getRemindMsgTemplId())) {
                wfWorkflow.setRemindMsgTemplId(iWFModel.getRemindMsgTemplId());
            }
            wfWorkflow.setWFLogicName(iWFModel.getName());
            wfWorkflow.setWFVersion(1);
            wfWorkflow.setWFModel("<?xml version=\"1.0\" encoding=\"utf-8\" ?><SRFEXWFWORKFLOW></SRFEXWFWORKFLOW>");
            wfWorkflow.set("SRF_PERSONID", "SYSTEM");
            wfWorkflow.set("SRF_LOGINNAME", "SYSTEM");
            wfWorkflow.set("SRF_PERSONNAME", "\u7cfb\u7edf\u5185\u5efa\u7528\u6237");
            wfWorkflowService.create(wfWorkflow);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), wfWorkflowService.getDEModel().getLogicName(), wfWorkflowService.getDEModel().getDataInfo(wfWorkflow)));
        }
    }

    protected void installBASchemes() throws Exception {
        for (IBASchemeModel iBASchemeModel : this.baSchemeModelMap.values()) {
            try {
                if (!(iBASchemeModel instanceof IBASchemeRuntime)) continue;
                iBASchemeModel.install();
            }
            catch (Exception ex) {
                throw new Exception("\u5b89\u88c5\u5927\u6570\u636e\u67b6\u6784", ex);
            }
        }
    }

    @Override
    public IValueTranslator getValueTranslator(String strTranslator) throws Exception {
        return ValueTranslatorGlobal.getValueTranslator(strTranslator);
    }

    @Override
    public String getLocalization() {
        return null;
    }

    @Override
    public Iterator<IDERBase> getDERs(String strDEId, boolean bMajor) {
        ArrayList<IDERBase> list = null;
        list = bMajor ? this.deMajorDERsMap.get(strDEId) : this.deMinorDERsMap.get(strDEId);
        if (list == null) {
            return null;
        }
        return list.iterator();
    }

    public void setServletContext(ServletContext arg0) {
        this.servletContext = arg0;
    }

    @Override
    public IDEDataAccMgr createDEDataAccMgr(IDataEntityModel iDEModel) throws Exception {
        DEDataAccMgr iDEDataAccMgr = new DEDataAccMgr();
        iDEDataAccMgr.init(iDEModel);
        return iDEDataAccMgr;
    }

    @Override
    public Object createObject(String strObjectType) throws Exception {
        String strNewObject;
        if (replaceObjectMap != null && !StringHelper.isNullOrEmpty(strNewObject = replaceObjectMap.get(strObjectType))) {
            return ObjectHelper.create(strNewObject);
        }
        return ObjectHelper.create(strObjectType);
    }

    public Object createObject2(String strObjectType) throws Exception {
        Object object = this.createObject(strObjectType);
        if (object != null && object instanceof IPostConstructable) {
            ((IPostConstructable)object).postConstruct();
        }
        return object;
    }

    public static synchronized void replaceObject(String strObject, String strNewObject) {
        if (replaceObjectMap == null) {
            replaceObjectMap = new HashMap();
        }
        replaceObjectMap.put(strObject, strNewObject);
    }

    @Override
    public Iterator<IViewMessage> getViewMessages(IViewController iViewController, IViewMsgGroupModel iViewMsgGroupModel) throws Exception {
        ArrayList viewMessageList = null;
        IViewMsgGroupPlugin iViewMsgGroupPlugin = this.getViewMsgGroupPlugin();
        if (iViewMsgGroupPlugin != null) {
            PluginActionResult pluginActionResult = iViewMsgGroupPlugin.doGetViewMessages(iViewController, iViewMsgGroupModel, null, null);
            if (pluginActionResult.getUserObject() != null) {
                viewMessageList = (ArrayList)pluginActionResult.getUserObject();
            }
            if (pluginActionResult.getResult() == 1) {
                if (viewMessageList == null) {
                    return null;
                }
                return viewMessageList.iterator();
            }
        }
        if (viewMessageList == null) {
            viewMessageList = new ArrayList();
        }
        iViewMsgGroupModel.fillViewMessages(iViewController, viewMessageList);
        return viewMessageList.iterator();
    }

    @Override
    public Iterator<IViewWizard> getViewWizards(IViewController iViewController, IViewWizardGroupModel iViewWizardGroupModel, String strQuery) throws Exception {
        ArrayList<IViewWizard> viewWizardList = new ArrayList<IViewWizard>();
        iViewWizardGroupModel.fillViewWizards(iViewController, strQuery, viewWizardList);
        return viewWizardList.iterator();
    }

    @Override
    public void setSystemPlugin(ISystemPlugin iSystemPlugin) throws Exception {
        this.setSystemPlugin(iSystemPlugin, false);
    }

    @Override
    public void setSystemPlugin(ISystemPlugin iSystemPlugin, boolean bIgnoreOrigin) throws Exception {
        ISystemPlugin lastPlugin = null;
        if (!bIgnoreOrigin && (lastPlugin = this.iSystemPlugin) == null) {
            lastPlugin = SysModelGlobal.getSystemPlugin();
        }
        iSystemPlugin.setPrevPlugin(lastPlugin);
        this.iSystemPlugin = iSystemPlugin;
    }

    @Override
    public ISystemPlugin getSystemPlugin() {
        return this.iSystemPlugin;
    }

    protected void installPlugins(PluginList pluginList) throws Exception {
        if (pluginList == null || pluginList.getList() == null) {
            return;
        }
        for (Plugin plugin : pluginList.getList()) {
            if (StringHelper.compare(plugin.getType(), "SYSTEM", true) == 0) {
                ISystemPlugin iSystemPlugin = (ISystemPlugin)ObjectHelper.create(plugin.getObj());
                if (StringHelper.isNullOrEmpty(plugin.getTarget())) {
                    iSystemPlugin.init(null, plugin.getCode());
                    SysModelGlobal.setSystemPlugin(iSystemPlugin);
                    continue;
                }
                ISystemModel iSystemModel = (ISystemModel)SysModelGlobal.getSystem(plugin.getTarget());
                iSystemPlugin.init(iSystemModel, plugin.getCode());
                iSystemModel.setSystemPlugin(iSystemPlugin);
                continue;
            }
            if (StringHelper.compare(plugin.getType(), "SERVICE", true) != 0) continue;
            IServicePlugin iServicePlugin = (IServicePlugin)ObjectHelper.create(plugin.getObj());
            IDataEntityModel dataEntityModel = DEModelGlobal.getDEModel(plugin.getTarget());
            iServicePlugin.init(plugin.getCode());
            dataEntityModel.setServicePlugin(iServicePlugin);
        }
    }

    protected IViewMsgGroupPlugin getViewMsgGroupPlugin() {
        if (this.iViewMsgGroupPlugin == null) {
            if (this.getSystemPlugin() != null && this.getSystemPlugin().getViewMsgGroupPlugin() != null) {
                this.iViewMsgGroupPlugin = this.getSystemPlugin().getViewMsgGroupPlugin();
            }
            if (this.iViewMsgGroupPlugin == null) {
                this.iViewMsgGroupPlugin = this.nullSystemViewMsgGroupPlugin;
            }
        }
        return this.iViewMsgGroupPlugin == this.nullSystemViewMsgGroupPlugin ? null : this.iViewMsgGroupPlugin;
    }

    @Override
    public SessionFactory getRealSessionFactory(IDataEntityModel iDataEntityModel, SessionFactory sessionFactory) {
        return sessionFactory;
    }

    @Override
    public IDEActionWizardModel createDEActionWizardModel(int nMode, String strUserTag) throws Exception {
        switch (nMode) {
            case 0: {
                return new DEActionWizardModel();
            }
            case 1: {
                return new DEDataSetDEAWModel();
            }
        }
        throw new Exception(StringHelper.format("\u65e0\u6cd5\u8bc6\u522b\u7684\u5b9e\u4f53\u64cd\u4f5c\u5411\u5bfc\u6a21\u5f0f[%1$s]", nMode));
    }

    @Override
    public IViewMsgModel createViewMsgModel(int nMode, String strUserTag) throws Exception {
        switch (nMode) {
            case 0: {
                return new StaticViewMsgModel();
            }
            case 1: {
                return new DEDataSetViewMsgModel();
            }
        }
        throw new Exception(StringHelper.format("\u65e0\u6cd5\u8bc6\u522b\u7684\u89c6\u56fe\u6d88\u606f\u6a21\u5f0f[%1$s]", nMode));
    }

    @Override
    public IUniStateManager getUniStateManager() {
        return this.uniStateManager;
    }

    @Override
    public void fillViewMsgActiveData(IEntity iEntity, IViewMsgModel iViewMsgModel, IViewController iViewController) throws Exception {
        iEntity.set("SRFVIEWID", iViewController.getId());
        iEntity.set("SRFVIEWCLS", iViewController.getClass().getCanonicalName());
        Object objDEId = null;
        Object objKey = null;
        String objDERId = null;
        JSONObject jo = WebContext.getActiveData();
        if (jo != null) {
            objDEId = iViewController.getDEModel() != null ? iViewController.getDEModel().getId() : jo.opt("srfdeid");
            objKey = jo.opt("srfkey");
            if (objKey == null) {
                objKey = WebContext.getKey(WebContext.getCurrent());
            }
        }
        if (jo == null && (jo = WebContext.getParentData()) != null) {
            String strParentType;
            objDEId = jo.opt("srfparentdeid");
            objKey = jo.opt("srfparentkey");
            if (objKey == null) {
                objKey = WebContext.getParentKey(WebContext.getCurrent());
            }
            if (!StringHelper.isNullOrEmpty(strParentType = WebContext.getParentType(WebContext.getCurrent()))) {
                if (StringHelper.compare(strParentType, "DER1N", true) == 0) {
                    objDERId = WebContext.getDER1NId(WebContext.getCurrent());
                } else if (StringHelper.compare(strParentType, "SYSDER1N", true) == 0) {
                    objDERId = WebContext.getDER1NId(WebContext.getCurrent());
                }
            }
        }
        if (objDEId != null) {
            iEntity.set("SRFDEID", objDEId);
            IDataEntityModel iDataEntityModel = DEModelGlobal.getDEModel((String)objDEId, true);
            if (iDataEntityModel != null) {
                iEntity.set("SRFDENAME", iDataEntityModel.getName());
            }
        }
        if (objKey != null) {
            iEntity.set("SRFKEY", objKey);
        }
        if (objDERId != null) {
            iEntity.set("SRFDERID", objDERId);
        }
    }

    @Override
    public IDBFunction getDBFunction(IDBDialect iDBDialect, String strFuncName) throws Exception {
        return iDBDialect.getDBFunction(strFuncName);
    }

    @Override
    public boolean isNoViewMode(IDataEntityModel iDataEntityModel) {
        if (this.noViewMode == null) {
            return iDataEntityModel.isNoViewMode();
        }
        return this.noViewMode;
    }

    @Override
    public String getDEOPPrivTarget(String strDEOPPriv) {
        if (StringHelper.isNullOrEmpty(strDEOPPriv)) {
            return "UNKNOWN";
        }
        if (StringHelper.compare(strDEOPPriv, "CREATE", true) == 0 || strDEOPPriv.indexOf("SRFUR__") == 0) {
            return "NONE";
        }
        return "DATA";
    }

    @Override
    public void registerServiceAPIClientModel(IServiceAPIClientModel iServiceAPIClientModel) throws Exception {
        String strId = iServiceAPIClientModel.getId();
        if (this.serviceAPIClientModelMap.containsKey(strId)) {
            throw new Exception(StringHelper.format("\u7cfb\u7edf\u4e2d\u5df2\u7ecf\u6ce8\u518c\u4e86\u6807\u8bc6\u4e3a[%1$s]\u7684\u670d\u52a1API\u5ba2\u6237\u7aef\u5bf9\u8c61", strId));
        }
        this.serviceAPIClientModelMap.put(strId, iServiceAPIClientModel);
        if (!StringHelper.isNullOrEmpty(iServiceAPIClientModel.getUniqueTag()) && !this.serviceAPIClientModelMap.containsKey(iServiceAPIClientModel.getUniqueTag())) {
            this.serviceAPIClientModelMap.put(iServiceAPIClientModel.getUniqueTag(), iServiceAPIClientModel);
        }
    }

    @Override
    public IServiceAPIClientModel getServiceAPIClientModel(String strServiceAPIClientModelId) throws Exception {
        IServiceAPIClientModel iServiceAPIClientModel = this.serviceAPIClientModelMap.get(strServiceAPIClientModelId);
        if (iServiceAPIClientModel == null) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u670d\u52a1API\u5ba2\u6237\u7aef\u5bf9\u8c61\uff0c\u670d\u52a1API\u5ba2\u6237\u7aef\u6807\u8bc6[%1$s]", strServiceAPIClientModelId));
        }
        return iServiceAPIClientModel;
    }

    @Override
    public boolean isUseServiceAPI() {
        return !StringHelper.isNullOrEmpty(this.getServiceAPIClientId());
    }

    @Override
    public IServiceAPIClientModel getServiceAPIClientModel() throws Exception {
        if (StringHelper.isNullOrEmpty(this.getServiceAPIClientId())) {
            return null;
        }
        if (this.iServiceAPIClientModel == null) {
            this.iServiceAPIClientModel = this.getServiceAPIClientModel(this.getServiceAPIClientId());
        }
        return this.iServiceAPIClientModel;
    }

    @Override
    public String getServiceAPIClientId() {
        return null;
    }

    @Override
    public boolean isDEUseServiceAPI(IDataEntityModel iDataEntityModel) {
        return this.isUseServiceAPI();
    }

    @Override
    public String getServicePath(IServiceAPIClientModel iServiceAPIClientModel, IServiceAPIAction iServiceAPIAction, Object objParam) throws Exception {
        return iServiceAPIClientModel.getServicePath();
    }

    @Override
    public ISystemUserRoleModel createSystemUserRoleModel(String strType, String strRoleTag) throws Exception {
        if (StringHelper.compare(strType, "DEDATASET", false) == 0) {
            return new DEDataSetSystemUserRoleModel();
        }
        if (StringHelper.compare(strType, "CUSTOM", false) == 0) {
            return new CustomSystemUserRoleModel();
        }
        throw new Exception(StringHelper.format("\u65e0\u6cd5\u8bc6\u522b\u7684\u7cfb\u7edf\u89d2\u8272\u7c7b\u578b[%1$s]", strType));
    }

    @Override
    public void registerSystemUserRoleModel(ISystemUserRoleModel iSystemUserRoleModel) throws Exception {
        String strId = iSystemUserRoleModel.getId();
        if (this.sysUserRoleModelMap.containsKey(strId)) {
            throw new Exception(StringHelper.format("\u7cfb\u7edf\u4e2d\u5df2\u7ecf\u6ce8\u518c\u4e86\u6807\u8bc6\u4e3a[%1$s]\u7684\u7528\u6237\u89d2\u8272\u5bf9\u8c61", strId));
        }
        if (!StringHelper.isNullOrEmpty(iSystemUserRoleModel.getRoleTag()) && this.sysUserRoleModelMap.containsKey(iSystemUserRoleModel.getRoleTag())) {
            throw new Exception(StringHelper.format("\u7cfb\u7edf\u4e2d\u5df2\u7ecf\u6ce8\u518c\u4e86\u6807\u8bc6\u4e3a[%1$s]\u7684\u7528\u6237\u89d2\u8272\u5bf9\u8c61", iSystemUserRoleModel.getRoleTag()));
        }
        this.sysUserRoleModelMap.put(strId, iSystemUserRoleModel);
        if (!StringHelper.isNullOrEmpty(iSystemUserRoleModel.getRoleTag())) {
            this.sysUserRoleModelMap.put(iSystemUserRoleModel.getRoleTag(), iSystemUserRoleModel);
        }
    }

    @Override
    public ISystemUserRoleModel getSystemUserRoleModel(String strUserRoleModelId) throws Exception {
        ISystemUserRoleModel iSystemUserRoleModel = this.sysUserRoleModelMap.get(strUserRoleModelId);
        if (iSystemUserRoleModel == null) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u7528\u6237\u89d2\u8272\u5bf9\u8c61\uff0c\u7528\u6237\u89d2\u8272\u5bf9\u8c61\u6807\u8bc6[%1$s]", strUserRoleModelId));
        }
        return iSystemUserRoleModel;
    }

    @Override
    public IDynaSystemSetting getDynaSystemSetting() {
        return this.iDynaSystemSetting;
    }

    public void setDynaSystemSetting(IDynaSystemSetting iDynaSystemSetting) {
        this.iDynaSystemSetting = iDynaSystemSetting;
    }

    @Override
    public ISystemSetting getSystemSetting() {
        return this.systemSettingModel;
    }

    @Override
    public void installDBModel(String strVersion, boolean bIgnoreCheck) throws Exception {
        this.onInstallDBModel(null, strVersion, bIgnoreCheck);
    }

    protected void onInstallDBModel(String strCat, String strVersion, boolean bIgnoreCheck) throws Exception {
        String[] sqls;
        String strSqlCode;
        if (this.getDBDialect() == null && this.getSessionFactory() != null) {
            return;
        }
        if (this.dataEntityModelMap.size() == 0) {
            return;
        }
        IDataEntityModel iDataEntityModel = null;
        Iterator<IDataEntityModel> iterator = this.dataEntityModelMap.values().iterator();
        if (iterator.hasNext()) {
            IDataEntityModel firstDEModel;
            iDataEntityModel = firstDEModel = iterator.next();
        }
        IService service = iDataEntityModel.getService(this.getSessionFactory());
        if (StringHelper.isNullOrEmpty(strCat)) {
            strCat = this.getName().toLowerCase();
        }
        if (StringHelper.isNullOrEmpty(strVersion)) {
            strVersion = "last";
        }
        String strSqlFile = StringHelper.format("db/%1$s.%2$s.%3$s.sql", strCat.toLowerCase(), this.getDBDialect().getDBType().toLowerCase(), strVersion.toLowerCase());
        String strSqlCheckFile = StringHelper.format("db/%1$s.%2$s.%3$s.check.sql", strCat.toLowerCase(), this.getDBDialect().getDBType().toLowerCase(), strVersion.toLowerCase());
        InputStream sqlInputStream = this.getClass().getClassLoader().getResourceAsStream(strSqlFile);
        InputStream sqlCheckInputStream = this.getClass().getClassLoader().getResourceAsStream(strSqlCheckFile);
        if (sqlInputStream == null || sqlCheckInputStream == null) {
            return;
        }
        String strCheckSqlCode = FileHelper.readFile(sqlCheckInputStream);
        if (StringHelper.isNullOrEmpty(strCheckSqlCode)) {
            return;
        }
        log.info((Object)StringHelper.format("\u5f00\u59cb\u5b89\u88c5\u7cfb\u7edf[%1$s]\u6570\u636e\u5e93[%2$s]\u6a21\u578b", this.getName(), this.getDBDialect().getDBType()));
        if (!bIgnoreCheck) {
            try {
                DBCallResult dbCallResult = service.executeRaw(strCheckSqlCode, null);
                if (dbCallResult.isOk()) {
                    return;
                }
                log.debug((Object)StringHelper.format("\u6267\u884c\u5b89\u88c5\u6570\u636e\u5e93\u68c0\u67e5\u811a\u672c\u53d1\u751f\u9519\u8bef\uff0c\u6267\u884c\u5b89\u88c5\u6570\u636e\u5e93"));
            }
            catch (Exception ex) {
                log.debug((Object)StringHelper.format("\u6267\u884c\u5b89\u88c5\u6570\u636e\u5e93\u68c0\u67e5\u811a\u672c\u53d1\u751f\u9519\u8bef\uff0c\u6267\u884c\u5b89\u88c5\u6570\u636e\u5e93"));
            }
        }
        if (StringHelper.isNullOrEmpty(strSqlCode = FileHelper.readFile(sqlInputStream))) {
            return;
        }
        strSqlCode = strSqlCode.replace("\r\n", "\n");
        String[] stringArray = sqls = StringHelper.split(strSqlCode, "/**\u5206\u5272\u7ebf**/");
        int n = sqls.length;
        int n2 = 0;
        while (n2 < n) {
            String strSql = stringArray[n2];
            if (!StringHelper.isNullOrEmpty(strSql = strSql.trim())) {
                try {
                    DBCallResult dbCallResult = service.executeRaw(strSql, null);
                    if (dbCallResult.isOk()) {
                        log.debug((Object)StringHelper.format("\u6210\u529f\u6267\u884c\uff1a%1$s", strSql));
                    }
                }
                catch (Exception exception) {
                    // empty catch block
                }
            }
            ++n2;
        }
        try {
            DBCallResult dbCallResult = service.executeRaw(strCheckSqlCode, null);
            if (dbCallResult.isOk()) {
                log.info((Object)StringHelper.format("\u5b89\u88c5\u7cfb\u7edf\u6570\u636e\u5e93\u6210\u529f\uff01"));
            } else {
                log.error((Object)StringHelper.format("\u5b89\u88c5\u7cfb\u7edf\u6570\u636e\u5e93\u5931\u8d25\uff01"));
            }
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format("\u5b89\u88c5\u7cfb\u7edf\u6570\u636e\u5e93\u5931\u8d25\uff01"));
        }
    }

    @Override
    public void registerDEUIActionModel(IDEUIActionModel iDEUIActionModel) throws Exception {
        String strId = iDEUIActionModel.getId();
        if (this.deUIActionModelMap.containsKey(strId)) {
            throw new Exception(StringHelper.format("\u7cfb\u7edf\u4e2d\u5df2\u7ecf\u6ce8\u518c\u4e86\u6807\u8bc6\u4e3a[%1$s]\u7684\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\u5bf9\u8c61", strId));
        }
        this.deUIActionModelMap.put(strId, iDEUIActionModel);
    }

    @Override
    public IDEUIActionModel getDEUIActionModel(String strDEUIActionId, boolean bTryMode) throws Exception {
        IDEUIActionModel iDEUIActionModel = this.deUIActionModelMap.get(strDEUIActionId);
        if (iDEUIActionModel == null && !bTryMode) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5168\u5c40\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\u5bf9\u8c61\uff0c\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\u5bf9\u8c61\u6807\u8bc6[%1$s]", strDEUIActionId));
        }
        return iDEUIActionModel;
    }

    @Override
    public JSONObject toJSONObject(IDataEntityModel iDataEntityModel, IEntity iEntity, boolean bIncludeEmpty, int nOption) throws Exception {
        JSONObject jo = DataObject.toJSONObject(iEntity, bIncludeEmpty);
        if ((nOption & 4) == 4 && iDataEntityModel != null) {
            IDEField iDEField = iDataEntityModel.getDEFieldByPDT("CREATEMAN", true);
            if (iDEField != null) {
                jo.remove(iDEField.getName().toLowerCase());
            }
            if ((iDEField = iDataEntityModel.getDEFieldByPDT("CREATEDATE", true)) != null) {
                jo.remove(iDEField.getName().toLowerCase());
            }
            if ((iDEField = iDataEntityModel.getDEFieldByPDT("UPDATEMAN", true)) != null) {
                jo.remove(iDEField.getName().toLowerCase());
            }
            if ((iDEField = iDataEntityModel.getDEFieldByPDT("UPDATEDATE", true)) != null) {
                jo.remove(iDEField.getName().toLowerCase());
            }
        }
        if ((nOption & 0x40) == 64 && iDataEntityModel != null) {
            Iterator<IDEField> defields = iDataEntityModel.getDEFields();
            while (defields.hasNext()) {
                IDEField iDEField = defields.next();
                if (iDEField.isPhisicalDEField()) continue;
                jo.remove(iDEField.getName().toLowerCase());
            }
        }
        return jo;
    }

    @Override
    public void registerSystemPartModel(ISystemPartModel iSystemPartModel) throws Exception {
        String strId = iSystemPartModel.getId();
        if (this.systemPartModelMap.containsKey(strId)) {
            throw new Exception(StringHelper.format("\u7cfb\u7edf\u4e2d\u5df2\u7ecf\u6ce8\u518c\u4e86\u6807\u8bc6\u4e3a[%1$s]\u7684\u7cfb\u7edf\u6210\u5458\u6a21\u578b", strId));
        }
        this.systemPartModelMap.put(strId, iSystemPartModel);
    }

    @Override
    public void logException(Object logger, Throwable throwable, String strMessage, Object objUserData) {
        if (this.getExceptionHandler() == null) {
            return;
        }
        this.getExceptionHandler().log(this, logger, throwable, strMessage, objUserData);
    }

    protected IExceptionHandler getExceptionHandler() {
        return null;
    }

    @Override
    public void registerSystemUtil(ISystemUtil iSystemUtil) throws Exception {
        this.systemUtilMap.put(iSystemUtil.getUtilType(), iSystemUtil);
    }

    @Override
    public ISystemUtil getSystemUtil(String strUtilType, boolean bTry) throws Exception {
        ISystemUtil iSystemUtil = this.systemUtilMap.get(strUtilType);
        if (iSystemUtil == null && !bTry) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u8f85\u52a9\u529f\u80fd[%1$s]", strUtilType));
        }
        return iSystemUtil;
    }

    @Override
    public String getModuleId() {
        return strModuleIId;
    }

    protected void setModuleId(String strModuleId) {
        strModuleIId = strModuleId;
    }

    @Override
    public Iterator<IDataEntityModel> getDataEntityModels() {
        return this.dataEntityModelMap2.values().iterator();
    }
}

