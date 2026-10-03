/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.ServletContext
 *  net.ibizsys.paas.api.IServiceAPIAction
 *  net.ibizsys.paas.api.IServiceAPIClientModel
 *  net.ibizsys.paas.cache.IUniStateManager
 *  net.ibizsys.paas.cache.IUniStateModel
 *  net.ibizsys.paas.codelist.ICodeList
 *  net.ibizsys.paas.controller.IViewController
 *  net.ibizsys.paas.core.IDERBase
 *  net.ibizsys.paas.core.IDataEntity
 *  net.ibizsys.paas.core.IPostConstructable
 *  net.ibizsys.paas.core.ISystemSetting
 *  net.ibizsys.paas.core.IValueTranslator
 *  net.ibizsys.paas.core.ModelBase3Impl
 *  net.ibizsys.paas.core.ValueTranslatorGlobal
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.IDBDialect
 *  net.ibizsys.paas.db.IDBFunction
 *  net.ibizsys.paas.demodel.DEActionWizardModel
 *  net.ibizsys.paas.demodel.DEDataSetDEAWModel
 *  net.ibizsys.paas.demodel.DEFInputTipSetModel
 *  net.ibizsys.paas.demodel.IDEActionWizardModel
 *  net.ibizsys.paas.demodel.IDEFInputTipSetModel
 *  net.ibizsys.paas.demodel.IDEUIActionModel
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.dts.IDTSQueueModel
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.security.DEDataAccMgr
 *  net.ibizsys.paas.security.IDEDataAccMgr
 *  net.ibizsys.paas.service.ActionSessionManager
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.sysmodel.CustomSystemUserRoleModel
 *  net.ibizsys.paas.sysmodel.DEDataSetSystemUserRoleModel
 *  net.ibizsys.paas.sysmodel.IDynaSystemSetting
 *  net.ibizsys.paas.sysmodel.ISystemLogicModel
 *  net.ibizsys.paas.sysmodel.ISystemModel
 *  net.ibizsys.paas.sysmodel.ISystemPartModel
 *  net.ibizsys.paas.sysmodel.ISystemRuntime
 *  net.ibizsys.paas.sysmodel.ISystemUserRoleModel
 *  net.ibizsys.paas.sysmodel.ISystemUtil
 *  net.ibizsys.paas.sysmodel.ISystemValueRuleModel
 *  net.ibizsys.paas.sysmodel.SystemSettingModel
 *  net.ibizsys.paas.util.ObjectHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.view.DEDataSetViewMsgModel
 *  net.ibizsys.paas.view.IDynaViewSetting
 *  net.ibizsys.paas.view.IViewMessage
 *  net.ibizsys.paas.view.IViewMsgGroupModel
 *  net.ibizsys.paas.view.IViewMsgModel
 *  net.ibizsys.paas.view.IViewWizard
 *  net.ibizsys.paas.view.IViewWizardGroupModel
 *  net.ibizsys.paas.view.StaticViewMsgModel
 *  net.ibizsys.psba.core.IBASchemeModel
 *  net.ibizsys.psba.core.IBASchemeRuntime
 *  net.ibizsys.psrt.srv.wf.entity.WFDynamicUser
 *  net.ibizsys.psrt.srv.wf.entity.WFUserGroup
 *  net.ibizsys.psrt.srv.wf.entity.WFWorkflow
 *  net.ibizsys.psrt.srv.wf.service.WFDynamicUserService
 *  net.ibizsys.psrt.srv.wf.service.WFUserGroupService
 *  net.ibizsys.psrt.srv.wf.service.WFWorkflowService
 *  net.ibizsys.pswf.core.IDynaWFSetting
 *  net.ibizsys.pswf.core.IWFModel
 *  net.ibizsys.pswf.core.IWFRoleModel
 *  net.sf.json.JSONObject
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.JIT.SysModel;

import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.JIT.SysModel.PSJITDER11Model;
import SA.SRFDA.PS.Core.JIT.SysModel.PSJITDER1NModel;
import SA.SRFDA.PS.Core.JIT.SysModel.PSJITDERIndexModel;
import SA.SRFDA.PS.Core.JIT.SysModel.PSJITDERInheritModel;
import SA.SRFDA.PS.Core.JIT.SysModel.PSJITDERMultiInheritModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import javax.servlet.ServletContext;
import net.ibizsys.paas.api.IServiceAPIAction;
import net.ibizsys.paas.api.IServiceAPIClientModel;
import net.ibizsys.paas.cache.IUniStateManager;
import net.ibizsys.paas.cache.IUniStateModel;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.core.IDERBase;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.IPostConstructable;
import net.ibizsys.paas.core.ISystemSetting;
import net.ibizsys.paas.core.IValueTranslator;
import net.ibizsys.paas.core.ModelBase3Impl;
import net.ibizsys.paas.core.ValueTranslatorGlobal;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.IDBDialect;
import net.ibizsys.paas.db.IDBFunction;
import net.ibizsys.paas.demodel.DEActionWizardModel;
import net.ibizsys.paas.demodel.DEDataSetDEAWModel;
import net.ibizsys.paas.demodel.DEFInputTipSetModel;
import net.ibizsys.paas.demodel.IDEActionWizardModel;
import net.ibizsys.paas.demodel.IDEFInputTipSetModel;
import net.ibizsys.paas.demodel.IDEUIActionModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.dts.IDTSQueueModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.security.DEDataAccMgr;
import net.ibizsys.paas.security.IDEDataAccMgr;
import net.ibizsys.paas.service.ActionSessionManager;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.sysmodel.CustomSystemUserRoleModel;
import net.ibizsys.paas.sysmodel.DEDataSetSystemUserRoleModel;
import net.ibizsys.paas.sysmodel.IDynaSystemSetting;
import net.ibizsys.paas.sysmodel.ISystemLogicModel;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.sysmodel.ISystemPartModel;
import net.ibizsys.paas.sysmodel.ISystemRuntime;
import net.ibizsys.paas.sysmodel.ISystemUserRoleModel;
import net.ibizsys.paas.sysmodel.ISystemUtil;
import net.ibizsys.paas.sysmodel.ISystemValueRuleModel;
import net.ibizsys.paas.sysmodel.SystemSettingModel;
import net.ibizsys.paas.util.ObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.view.DEDataSetViewMsgModel;
import net.ibizsys.paas.view.IDynaViewSetting;
import net.ibizsys.paas.view.IViewMessage;
import net.ibizsys.paas.view.IViewMsgGroupModel;
import net.ibizsys.paas.view.IViewMsgModel;
import net.ibizsys.paas.view.IViewWizard;
import net.ibizsys.paas.view.IViewWizardGroupModel;
import net.ibizsys.paas.view.StaticViewMsgModel;
import net.ibizsys.psba.core.IBASchemeModel;
import net.ibizsys.psba.core.IBASchemeRuntime;
import net.ibizsys.psrt.srv.wf.entity.WFDynamicUser;
import net.ibizsys.psrt.srv.wf.entity.WFUserGroup;
import net.ibizsys.psrt.srv.wf.entity.WFWorkflow;
import net.ibizsys.psrt.srv.wf.service.WFDynamicUserService;
import net.ibizsys.psrt.srv.wf.service.WFUserGroupService;
import net.ibizsys.psrt.srv.wf.service.WFWorkflowService;
import net.ibizsys.pswf.core.IDynaWFSetting;
import net.ibizsys.pswf.core.IWFModel;
import net.ibizsys.pswf.core.IWFRoleModel;
import net.sf.json.JSONObject;
import org.hibernate.SessionFactory;

public abstract class PSJITSystemModelBase
extends ModelBase3Impl
implements ISystemModel,
ISystemRuntime {
    private HashMap<String, IDERBase> derBaseMap = new HashMap();
    private HashMap<String, IDataEntityModel> dataEntityModelMap = new HashMap();
    private HashMap<String, IWFModel> wfModelMap = new HashMap();
    private HashMap<String, IWFRoleModel> wfRoleModelMap = new HashMap();
    private HashMap<String, ArrayList<IDERBase>> deMajorDERsMap = new HashMap();
    private HashMap<String, ArrayList<IDERBase>> deMinorDERsMap = new HashMap();
    private HashMap<String, IBASchemeModel> baSchemeModelMap = new HashMap();
    private HashMap<String, IViewMsgGroupModel> viewMsgGroupModelMap = new HashMap();
    private HashMap<String, IViewMsgModel> viewMsgModelMap = new HashMap();
    private HashMap<String, IUniStateModel> uniStateModelMap = new HashMap();
    private HashMap<String, IDEFInputTipSetModel> defInputTipSetModelMap = new HashMap();
    private HashMap<String, ISystemValueRuleModel> sysValueRuleModelMap = new HashMap();
    private HashMap<String, ISystemLogicModel> systemLogicModelMap = new HashMap();
    private ServletContext servletContext = null;
    private static HashMap<String, String> replaceObjectMap = null;
    private IDynaViewSetting iDynaViewSetting = null;
    private IDynaWFSetting iDynaWFSetting = null;
    private IDynaSystemSetting iDynaSystemSetting = null;
    protected SystemSettingModel systemSettingModel = new SystemSettingModel();
    private HashMap<String, ISystemPartModel> systemPartModelMap = new HashMap();
    private IDBDialect dbDialect;
    private SessionFactory sessionFactory;
    private IDBDialect dbDialect2;
    private SessionFactory sessionFactory2;
    private IDBDialect dbDialect3;
    private SessionFactory sessionFactory3;
    private IDBDialect dbDialect4;
    private SessionFactory sessionFactory4;
    private IDBDialect dbDialect5;
    private SessionFactory sessionFactory5;
    private IDBDialect dbDialect6;
    private SessionFactory sessionFactory6;
    private IDBDialect dbDialect7;
    private SessionFactory sessionFactory7;
    private IDBDialect dbDialect8;
    private SessionFactory sessionFactory8;
    private IDBDialect dbDialect9;
    private SessionFactory sessionFactory9;
    private IDBDialect dbDialect10;
    private SessionFactory sessionFactory10;
    private IDBDialect dbDialect11;
    private SessionFactory sessionFactory11;
    private IDBDialect dbDialect12;
    private SessionFactory sessionFactory12;

    protected void registerDERBase(IDERBase iDERBase) {
        this.derBaseMap.put(iDERBase.getId(), iDERBase);
        this.derBaseMap.put(iDERBase.getName(), iDERBase);
        String strMajorDEId = iDERBase.getMajorDEId();
        String strMinorDEId = iDERBase.getMinorDEId();
        ArrayList<IDERBase> majorDERList = this.deMajorDERsMap.get(strMajorDEId);
        if (majorDERList == null) {
            majorDERList = new ArrayList<IDERBase>();
            this.deMajorDERsMap.put(strMajorDEId, majorDERList);
        }
        majorDERList.add(iDERBase);
        ArrayList<IDERBase> minorDERList = this.deMinorDERsMap.get(strMinorDEId);
        if (minorDERList == null) {
            minorDERList = new ArrayList<IDERBase>();
            this.deMinorDERsMap.put(strMinorDEId, minorDERList);
        }
        minorDERList.add(iDERBase);
    }

    protected IDERBase createDERBase(IPSDERBase iPSDERBase) {
        if (StringHelper.compare((String)iPSDERBase.getDERType(), (String)"DER1N", (boolean)true) == 0) {
            PSJITDER1NModel der1nModel = new PSJITDER1NModel();
            der1nModel.init(this, iPSDERBase);
            return der1nModel;
        }
        if (StringHelper.compare((String)iPSDERBase.getDERType(), (String)"DER11", (boolean)true) == 0) {
            PSJITDER11Model der11Model = new PSJITDER11Model();
            der11Model.init(this, iPSDERBase);
            return der11Model;
        }
        if (StringHelper.compare((String)iPSDERBase.getDERType(), (String)"DERINHERIT", (boolean)true) == 0) {
            PSJITDERInheritModel derInheritModel = new PSJITDERInheritModel();
            derInheritModel.init(this, iPSDERBase);
            return derInheritModel;
        }
        if (StringHelper.compare((String)iPSDERBase.getDERType(), (String)"DERINDEX", (boolean)true) == 0) {
            PSJITDERIndexModel derIndexModel = new PSJITDERIndexModel();
            derIndexModel.init(this, iPSDERBase);
            return derIndexModel;
        }
        if (StringHelper.compare((String)iPSDERBase.getDERType(), (String)"DERMULINH", (boolean)true) == 0) {
            PSJITDERMultiInheritModel derMultiInheritModel = new PSJITDERMultiInheritModel();
            derMultiInheritModel.init(this, iPSDERBase);
            return derMultiInheritModel;
        }
        return null;
    }

    protected void setId(String strId) {
        this.strId = strId;
    }

    protected void setName(String strName) {
        this.strName = strName;
    }

    public IDataEntityModel getDataEntityModel(String strDEName) throws Exception {
        IDataEntityModel iDataEntityModel = this.dataEntityModelMap.get(strDEName);
        if (iDataEntityModel == null) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53[%1$s]", (Object)strDEName));
        }
        return iDataEntityModel;
    }

    public IDataEntity getDataEntity(String strDataEntityId) throws Exception {
        return this.getDataEntityModel(strDataEntityId);
    }

    public IDERBase getDER(String strDERId) throws Exception {
        IDERBase iDERBase = this.derBaseMap.get(strDERId);
        if (iDERBase == null) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5173\u7cfb[%1$s]", (Object)strDERId));
        }
        return iDERBase;
    }

    public IDERBase getDER(String strDERId, boolean bTryMode) throws Exception {
        IDERBase iDERBase = this.derBaseMap.get(strDERId);
        if (iDERBase == null && !bTryMode) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5173\u7cfb[%1$s]", (Object)strDERId));
        }
        return iDERBase;
    }

    public ICodeList getCodeList(String strCodeListId) throws Exception {
        return null;
    }

    public void setDBDialect(IDBDialect dbDialect) {
        this.dbDialect = dbDialect;
    }

    public IDBDialect getDBDialect() {
        return this.dbDialect;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return this.sessionFactory;
    }

    public IWFModel getWFModel(String strWFModelId) throws Exception {
        return this.getWFModel(strWFModelId, false);
    }

    public IWFModel getWFModel(String strWFModelId, boolean bTryMode) throws Exception {
        IWFModel iWFModel = this.wfModelMap.get(strWFModelId);
        if (iWFModel == null && !bTryMode) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6d41\u7a0b\uff0c\u6d41\u7a0b\u6807\u8bc6[%1$s]", (Object)strWFModelId));
        }
        return iWFModel;
    }

    protected Iterator<IWFModel> getWFModels() {
        return this.wfModelMap.values().iterator();
    }

    public IWFRoleModel getWFRoleModel(String strWFRoleModelId) throws Exception {
        return this.getWFRoleModel(strWFRoleModelId, false);
    }

    public IWFRoleModel getWFRoleModel(String strWFRoleModelId, boolean bTryMode) throws Exception {
        IWFRoleModel iWFRoleModel = this.wfRoleModelMap.get(strWFRoleModelId);
        if (iWFRoleModel == null && !bTryMode) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6d41\u7a0b\u89d2\u8272\uff0c\u89d2\u8272\u6807\u8bc6[%1$s]", (Object)strWFRoleModelId));
        }
        return iWFRoleModel;
    }

    public void registerDataEntityModel(IDataEntityModel iDataEntityModel) throws Exception {
        String strId = iDataEntityModel.getId();
        String strName = iDataEntityModel.getName();
        this.dataEntityModelMap.put(strId, iDataEntityModel);
        this.dataEntityModelMap.put(strName, iDataEntityModel);
    }

    public void registerWFModel(IWFModel iWFModel) throws Exception {
        String strId = iWFModel.getId();
        if (this.wfModelMap.containsKey(strId)) {
            throw new Exception(StringHelper.format((String)"\u7cfb\u7edf\u4e2d\u5df2\u7ecf\u6ce8\u518c\u4e86\u6807\u8bc6\u4e3a[%1$s]\u7684\u6d41\u7a0b\u6a21\u578b", (Object)strId));
        }
        this.wfModelMap.put(strId, iWFModel);
    }

    public void registerWFRoleModel(IWFRoleModel iWFRoleModel) throws Exception {
        String strId = iWFRoleModel.getId();
        if (this.wfRoleModelMap.containsKey(strId)) {
            throw new Exception(StringHelper.format((String)"\u7cfb\u7edf\u4e2d\u5df2\u7ecf\u6ce8\u518c\u4e86\u6807\u8bc6\u4e3a[%1$s]\u7684\u6d41\u7a0b\u89d2\u8272\u6a21\u578b", (Object)strId));
        }
        this.wfRoleModelMap.put(strId, iWFRoleModel);
    }

    public void registerBASchemeModel(IBASchemeModel iBASchemeModel) throws Exception {
        String strId = iBASchemeModel.getId();
        if (this.baSchemeModelMap.containsKey(strId)) {
            throw new Exception(StringHelper.format((String)"\u7cfb\u7edf\u4e2d\u5df2\u7ecf\u6ce8\u518c\u4e86\u6807\u8bc6\u4e3a[%1$s]\u7684\u5927\u6570\u636e\u67b6\u6784\u6a21\u578b", (Object)strId));
        }
        this.baSchemeModelMap.put(strId, iBASchemeModel);
    }

    public IBASchemeModel getBASchemeModel(String strBASchemeModelId) throws Exception {
        IBASchemeModel iBASchemeModel = this.baSchemeModelMap.get(strBASchemeModelId);
        if (iBASchemeModel == null) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5927\u6570\u636e\u67b6\u6784\u6a21\u578b\uff0c\u5927\u6570\u636e\u67b6\u6784\u6a21\u578b\u6807\u8bc6[%1$s]", (Object)strBASchemeModelId));
        }
        return iBASchemeModel;
    }

    public Iterator<IWFRoleModel> getWFRoleModels() {
        return this.wfRoleModelMap.values().iterator();
    }

    public IDBDialect getDBDialect(String strDSLink) {
        if (StringHelper.compare((String)strDSLink, (String)"DEFAULT", (boolean)true) == 0) {
            return this.getDBDialect();
        }
        if (StringHelper.compare((String)strDSLink, (String)"DB2", (boolean)true) == 0) {
            return this.getDBDialect2();
        }
        if (StringHelper.compare((String)strDSLink, (String)"DB3", (boolean)true) == 0) {
            return this.getDBDialect3();
        }
        if (StringHelper.compare((String)strDSLink, (String)"DB4", (boolean)true) == 0) {
            return this.getDBDialect4();
        }
        if (StringHelper.compare((String)strDSLink, (String)"DB5", (boolean)true) == 0) {
            return this.getDBDialect5();
        }
        if (StringHelper.compare((String)strDSLink, (String)"DB6", (boolean)true) == 0) {
            return this.getDBDialect6();
        }
        if (StringHelper.compare((String)strDSLink, (String)"DB7", (boolean)true) == 0) {
            return this.getDBDialect7();
        }
        if (StringHelper.compare((String)strDSLink, (String)"DB8", (boolean)true) == 0) {
            return this.getDBDialect8();
        }
        if (StringHelper.compare((String)strDSLink, (String)"DB9", (boolean)true) == 0) {
            return this.getDBDialect9();
        }
        if (StringHelper.compare((String)strDSLink, (String)"DB10", (boolean)true) == 0) {
            return this.getDBDialect10();
        }
        if (StringHelper.compare((String)strDSLink, (String)"DB11", (boolean)true) == 0) {
            return this.getDBDialect11();
        }
        if (StringHelper.compare((String)strDSLink, (String)"DB12", (boolean)true) == 0) {
            return this.getDBDialect12();
        }
        return this.getDBDialect();
    }

    public SessionFactory getSessionFactory(String strDSLink) {
        if (StringHelper.isNullOrEmpty((String)strDSLink) || StringHelper.compare((String)strDSLink, (String)"DEFAULT", (boolean)true) == 0) {
            return this.getSessionFactory();
        }
        if (StringHelper.compare((String)strDSLink, (String)"DB2", (boolean)true) == 0) {
            return this.getSessionFactory2();
        }
        if (StringHelper.compare((String)strDSLink, (String)"DB3", (boolean)true) == 0) {
            return this.getSessionFactory3();
        }
        if (StringHelper.compare((String)strDSLink, (String)"DB4", (boolean)true) == 0) {
            return this.getSessionFactory4();
        }
        if (StringHelper.compare((String)strDSLink, (String)"DB5", (boolean)true) == 0) {
            return this.getSessionFactory5();
        }
        if (StringHelper.compare((String)strDSLink, (String)"DB6", (boolean)true) == 0) {
            return this.getSessionFactory6();
        }
        if (StringHelper.compare((String)strDSLink, (String)"DB7", (boolean)true) == 0) {
            return this.getSessionFactory7();
        }
        if (StringHelper.compare((String)strDSLink, (String)"DB8", (boolean)true) == 0) {
            return this.getSessionFactory8();
        }
        if (StringHelper.compare((String)strDSLink, (String)"DB9", (boolean)true) == 0) {
            return this.getSessionFactory9();
        }
        if (StringHelper.compare((String)strDSLink, (String)"DB10", (boolean)true) == 0) {
            return this.getSessionFactory10();
        }
        if (StringHelper.compare((String)strDSLink, (String)"DB11", (boolean)true) == 0) {
            return this.getSessionFactory11();
        }
        if (StringHelper.compare((String)strDSLink, (String)"DB12", (boolean)true) == 0) {
            return this.getSessionFactory12();
        }
        return this.getSessionFactory();
    }

    public IDBDialect getDBDialect2() {
        if (this.dbDialect2 != null) {
            return this.dbDialect2;
        }
        return this.getDBDialect();
    }

    public SessionFactory getSessionFactory2() {
        if (this.sessionFactory2 != null) {
            return this.sessionFactory2;
        }
        return this.getSessionFactory();
    }

    public IDBDialect getDBDialect3() {
        if (this.dbDialect3 != null) {
            return this.dbDialect3;
        }
        return this.getDBDialect();
    }

    public SessionFactory getSessionFactory3() {
        if (this.sessionFactory3 != null) {
            return this.sessionFactory3;
        }
        return this.getSessionFactory();
    }

    public IDBDialect getDBDialect4() {
        if (this.dbDialect4 != null) {
            return this.dbDialect4;
        }
        return this.getDBDialect();
    }

    public SessionFactory getSessionFactory4() {
        if (this.sessionFactory4 != null) {
            return this.sessionFactory4;
        }
        return this.getSessionFactory();
    }

    public IDBDialect getDBDialect5() {
        if (this.dbDialect5 != null) {
            return this.dbDialect5;
        }
        return this.getDBDialect();
    }

    public SessionFactory getSessionFactory5() {
        if (this.sessionFactory5 != null) {
            return this.sessionFactory5;
        }
        return this.getSessionFactory();
    }

    public IDBDialect getDBDialect6() {
        if (this.dbDialect6 != null) {
            return this.dbDialect6;
        }
        return this.getDBDialect();
    }

    public SessionFactory getSessionFactory6() {
        if (this.sessionFactory6 != null) {
            return this.sessionFactory6;
        }
        return this.getSessionFactory();
    }

    public IDBDialect getDBDialect7() {
        if (this.dbDialect7 != null) {
            return this.dbDialect7;
        }
        return this.getDBDialect();
    }

    public SessionFactory getSessionFactory7() {
        if (this.sessionFactory7 != null) {
            return this.sessionFactory7;
        }
        return this.getSessionFactory();
    }

    public IDBDialect getDBDialect8() {
        if (this.dbDialect8 != null) {
            return this.dbDialect8;
        }
        return this.getDBDialect();
    }

    public SessionFactory getSessionFactory8() {
        if (this.sessionFactory8 != null) {
            return this.sessionFactory8;
        }
        return this.getSessionFactory();
    }

    public IDBDialect getDBDialect9() {
        if (this.dbDialect9 != null) {
            return this.dbDialect9;
        }
        return this.getDBDialect();
    }

    public SessionFactory getSessionFactory9() {
        if (this.sessionFactory9 != null) {
            return this.sessionFactory9;
        }
        return this.getSessionFactory();
    }

    public IDBDialect getDBDialect10() {
        if (this.dbDialect10 != null) {
            return this.dbDialect10;
        }
        return this.getDBDialect();
    }

    public SessionFactory getSessionFactory10() {
        if (this.sessionFactory10 != null) {
            return this.sessionFactory10;
        }
        return this.getSessionFactory();
    }

    public IDBDialect getDBDialect11() {
        if (this.dbDialect11 != null) {
            return this.dbDialect11;
        }
        return this.getDBDialect();
    }

    public SessionFactory getSessionFactory11() {
        if (this.sessionFactory11 != null) {
            return this.sessionFactory11;
        }
        return this.getSessionFactory();
    }

    public IDBDialect getDBDialect12() {
        if (this.dbDialect12 != null) {
            return this.dbDialect12;
        }
        return this.getDBDialect();
    }

    public SessionFactory getSessionFactory12() {
        if (this.sessionFactory12 != null) {
            return this.sessionFactory12;
        }
        return this.getSessionFactory();
    }

    public void postConstruct() throws Exception {
        if (this.dbDialect != null && this.sessionFactory != null) {
            DAOGlobal.registerDBDialect((SessionFactory)this.sessionFactory, (IDBDialect)this.dbDialect);
        }
        if (this.dbDialect2 != null && this.sessionFactory2 != null) {
            DAOGlobal.registerDBDialect((SessionFactory)this.sessionFactory2, (IDBDialect)this.dbDialect2);
        }
        if (this.dbDialect3 != null && this.sessionFactory3 != null) {
            DAOGlobal.registerDBDialect((SessionFactory)this.sessionFactory3, (IDBDialect)this.dbDialect3);
        }
        if (this.dbDialect4 != null && this.sessionFactory4 != null) {
            DAOGlobal.registerDBDialect((SessionFactory)this.sessionFactory4, (IDBDialect)this.dbDialect4);
        }
    }

    public void installRTDatas() throws Exception {
        this.installBASchemes();
        this.installWFRTDatas();
        this.onInstallRTDatas();
    }

    protected void onInstallRTDatas() throws Exception {
    }

    protected void installWFRTDatas() throws Exception {
        WFUserGroupService wfUserGroupService = (WFUserGroupService)ServiceGlobal.getService(WFUserGroupService.class, (SessionFactory)this.getSessionFactory());
        WFDynamicUserService wfDynamicUserService = (WFDynamicUserService)ServiceGlobal.getService(WFDynamicUserService.class, (SessionFactory)this.getSessionFactory());
        Iterator<IWFRoleModel> wfRoleModes = this.getWFRoleModels();
        if (wfRoleModes != null) {
            while (wfRoleModes.hasNext()) {
                IWFRoleModel iWFRoleModel = wfRoleModes.next();
                if (StringHelper.compare((String)iWFRoleModel.getWFRoleType(), (String)"USERGROUP", (boolean)true) == 0) {
                    WFUserGroup wfUserGroup = new WFUserGroup();
                    wfUserGroup.setWFUserGroupId(iWFRoleModel.getId());
                    wfUserGroup.setWFUserGroupName(iWFRoleModel.getName());
                    wfUserGroup.set("SRF_PERSONID", (Object)"SYSTEM");
                    wfUserGroup.set("SRF_LOGINNAME", (Object)"SYSTEM");
                    wfUserGroupService.save(wfUserGroup);
                    ActionSessionManager.appendActionInfo((String)StringHelper.format((String)"[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", (Object)this.getName(), (Object)wfUserGroupService.getDEModel().getLogicName(), (Object)wfUserGroupService.getDEModel().getDataInfo((IEntity)wfUserGroup)));
                    continue;
                }
                if (StringHelper.compare((String)iWFRoleModel.getWFRoleType(), (String)"CUSTOM", (boolean)true) != 0) continue;
                WFDynamicUser wfDynamicUser = new WFDynamicUser();
                wfDynamicUser.setWFDynamicUserId(iWFRoleModel.getId());
                wfDynamicUser.setWFDynamicUserName(iWFRoleModel.getName());
                wfDynamicUser.setUserObject("#");
                wfDynamicUser.set("SRF_PERSONID", (Object)"SYSTEM");
                wfDynamicUser.set("SRF_LOGINNAME", (Object)"SYSTEM");
                wfDynamicUserService.save(wfDynamicUser);
                ActionSessionManager.appendActionInfo((String)StringHelper.format((String)"[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", (Object)this.getName(), (Object)wfDynamicUserService.getDEModel().getLogicName(), (Object)wfDynamicUserService.getDEModel().getDataInfo((IEntity)wfDynamicUser)));
            }
        }
        for (IWFModel iWFModel : this.wfModelMap.values()) {
            WFWorkflowService wfWorkflowService = (WFWorkflowService)ServiceGlobal.getService(WFWorkflowService.class, (SessionFactory)this.getSessionFactory());
            WFWorkflow wfWorkflow = new WFWorkflow();
            wfWorkflow.setWFWorkflowId(iWFModel.getId());
            if (wfWorkflowService.checkKey(wfWorkflow) != 0) continue;
            wfWorkflow.setWFWorkflowName(iWFModel.getName());
            wfWorkflow.setWFState(Integer.valueOf(1));
            if (!StringHelper.isNullOrEmpty((String)iWFModel.getRemindMsgTemplId())) {
                wfWorkflow.setRemindMsgTemplId(iWFModel.getRemindMsgTemplId());
            }
            wfWorkflow.setWFLogicName(iWFModel.getName());
            wfWorkflow.setWFVersion(Integer.valueOf(1));
            wfWorkflow.setWFModel("<?xml version=\"1.0\" encoding=\"utf-8\" ?><SRFEXWFWORKFLOW></SRFEXWFWORKFLOW>");
            wfWorkflow.set("SRF_PERSONID", (Object)"SYSTEM");
            wfWorkflow.set("SRF_LOGINNAME", (Object)"SYSTEM");
            wfWorkflowService.create(wfWorkflow);
            ActionSessionManager.appendActionInfo((String)StringHelper.format((String)"[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", (Object)this.getName(), (Object)wfWorkflowService.getDEModel().getLogicName(), (Object)wfWorkflowService.getDEModel().getDataInfo((IEntity)wfWorkflow)));
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

    public IValueTranslator getValueTranslator(String strTranslator) throws Exception {
        return ValueTranslatorGlobal.getValueTranslator((String)strTranslator);
    }

    public String getLocalization() {
        return null;
    }

    public Iterator<IDERBase> getDERs(String strDEId, boolean bMajor) {
        ArrayList<IDERBase> list = null;
        list = bMajor ? this.deMajorDERsMap.get(strDEId) : this.deMinorDERsMap.get(strDEId);
        if (list == null) {
            return null;
        }
        return list.iterator();
    }

    public IDEDataAccMgr createDEDataAccMgr(IDataEntityModel iDEModel) throws Exception {
        DEDataAccMgr iDEDataAccMgr = new DEDataAccMgr();
        iDEDataAccMgr.init(iDEModel);
        return iDEDataAccMgr;
    }

    public Object createObject(String strObjectType) throws Exception {
        String strNewObject;
        if (replaceObjectMap != null && !StringHelper.isNullOrEmpty((String)(strNewObject = replaceObjectMap.get(strObjectType)))) {
            return ObjectHelper.create((String)strNewObject);
        }
        return ObjectHelper.create((String)strObjectType);
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

    public Iterator<IViewMessage> getViewMessages(IViewController iViewController, IViewMsgGroupModel iViewMsgGroupModel) throws Exception {
        ArrayList viewMessageList = new ArrayList();
        iViewMsgGroupModel.fillViewMessages(iViewController, viewMessageList);
        return viewMessageList.iterator();
    }

    public Iterator<IViewWizard> getViewWizards(IViewController iViewController, IViewWizardGroupModel iViewWizardGroupModel, String strQuery) throws Exception {
        ArrayList viewWizardList = new ArrayList();
        iViewWizardGroupModel.fillViewWizards(iViewController, strQuery, viewWizardList);
        return viewWizardList.iterator();
    }

    public void registerViewMsgGroupModel(IViewMsgGroupModel iViewMsgGroupModel) throws Exception {
        String strId = iViewMsgGroupModel.getId();
        if (this.viewMsgGroupModelMap.containsKey(strId)) {
            throw new Exception(StringHelper.format((String)"\u7cfb\u7edf\u4e2d\u5df2\u7ecf\u6ce8\u518c\u4e86\u6807\u8bc6\u4e3a[%1$s]\u7684\u89c6\u56fe\u6d88\u606f\u7ec4\u6a21\u578b", (Object)strId));
        }
        this.viewMsgGroupModelMap.put(strId, iViewMsgGroupModel);
    }

    public IViewMsgGroupModel getViewMsgGroupModel(String strViewMsgGroupModelId) throws Exception {
        IViewMsgGroupModel iViewMsgGroupModel = this.viewMsgGroupModelMap.get(strViewMsgGroupModelId);
        if (iViewMsgGroupModel == null) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u89c6\u56fe\u6d88\u606f\u7ec4\u6a21\u578b\uff0c\u89c6\u56fe\u6d88\u606f\u7ec4\u6a21\u578b\u6807\u8bc6[%1$s]", (Object)strViewMsgGroupModelId));
        }
        return iViewMsgGroupModel;
    }

    public void registerViewMsgModel(IViewMsgModel iViewMsgModel) throws Exception {
        String strId = iViewMsgModel.getId();
        if (this.viewMsgModelMap.containsKey(strId)) {
            throw new Exception(StringHelper.format((String)"\u7cfb\u7edf\u4e2d\u5df2\u7ecf\u6ce8\u518c\u4e86\u6807\u8bc6\u4e3a[%1$s]\u7684\u89c6\u56fe\u6d88\u606f\u6a21\u578b", (Object)strId));
        }
        this.viewMsgModelMap.put(strId, iViewMsgModel);
    }

    public IViewMsgModel getViewMsgModel(String strViewMsgModelId) throws Exception {
        IViewMsgModel iViewMsgModel = this.viewMsgModelMap.get(strViewMsgModelId);
        if (iViewMsgModel == null) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u89c6\u56fe\u6d88\u606f\u6a21\u578b\uff0c\u89c6\u56fe\u6d88\u606f\u6a21\u578b\u6807\u8bc6[%1$s]", (Object)strViewMsgModelId));
        }
        return iViewMsgModel;
    }

    public SessionFactory getRealSessionFactory(IDataEntityModel iDataEntityModel, SessionFactory sessionFactory) {
        return sessionFactory;
    }

    public IDEActionWizardModel createDEActionWizardModel(int nMode, String strUserTag) throws Exception {
        switch (nMode) {
            case 0: {
                return new DEActionWizardModel();
            }
            case 1: {
                return new DEDataSetDEAWModel();
            }
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u5b9e\u4f53\u64cd\u4f5c\u5411\u5bfc\u6a21\u5f0f[%1$s]", (Object)nMode));
    }

    public IViewMsgModel createViewMsgModel(int nMode, String strUserTag) throws Exception {
        switch (nMode) {
            case 0: {
                return new StaticViewMsgModel();
            }
            case 1: {
                return new DEDataSetViewMsgModel();
            }
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u89c6\u56fe\u6d88\u606f\u6a21\u5f0f[%1$s]", (Object)nMode));
    }

    public IUniStateManager getUniStateManager() {
        return null;
    }

    public void registerUniStateModel(IUniStateModel iUniStateModel) throws Exception {
        String strId = iUniStateModel.getId();
        if (this.uniStateModelMap.containsKey(strId)) {
            throw new Exception(StringHelper.format((String)"\u7cfb\u7edf\u4e2d\u5df2\u7ecf\u6ce8\u518c\u4e86\u6807\u8bc6\u4e3a[%1$s]\u7684\u7edf\u4e00\u72b6\u6001\u534f\u540c\u5bf9\u8c61", (Object)strId));
        }
        if (this.uniStateModelMap.containsKey(iUniStateModel.getUniqueTag())) {
            throw new Exception(StringHelper.format((String)"\u7cfb\u7edf\u4e2d\u5df2\u7ecf\u6ce8\u518c\u4e86\u6807\u8bc6\u4e3a[%1$s]\u7684\u7edf\u4e00\u72b6\u6001\u534f\u540c\u5bf9\u8c61", (Object)iUniStateModel.getUniqueTag()));
        }
        this.uniStateModelMap.put(strId, iUniStateModel);
        this.uniStateModelMap.put(iUniStateModel.getUniqueTag(), iUniStateModel);
    }

    public IUniStateModel getUniStateModel(String strUniStateModelId) throws Exception {
        IUniStateModel iUniStateModel = this.uniStateModelMap.get(strUniStateModelId);
        if (iUniStateModel == null) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u7edf\u4e00\u72b6\u6001\u534f\u540c\u5bf9\u8c61\uff0c\u7edf\u4e00\u72b6\u6001\u534f\u540c\u5bf9\u8c61\u6807\u8bc6[%1$s]", (Object)strUniStateModelId));
        }
        return iUniStateModel;
    }

    public IUniStateModel createUniStateModel(String strType, String strUserTag) throws Exception {
        return null;
    }

    public void fillViewMsgActiveData(IEntity iEntity, IViewMsgModel iViewMsgModel, IViewController iViewController) throws Exception {
    }

    public IDEFInputTipSetModel createDEFInputTipSetModel(String strUserTag) throws Exception {
        return new DEFInputTipSetModel();
    }

    public void registerDEFInputTipSetModel(IDEFInputTipSetModel iDEFInputTipSetModel) throws Exception {
        String strId = iDEFInputTipSetModel.getId();
        if (this.defInputTipSetModelMap.containsKey(strId)) {
            throw new Exception(StringHelper.format((String)"\u7cfb\u7edf\u4e2d\u5df2\u7ecf\u6ce8\u518c\u4e86\u6807\u8bc6\u4e3a[%1$s]\u7684\u5c5e\u6027\u8f93\u5165\u63d0\u793a\u96c6\u5408\u6a21\u578b", (Object)strId));
        }
        this.defInputTipSetModelMap.put(strId, iDEFInputTipSetModel);
    }

    public IDEFInputTipSetModel getDEFInputTipSetModel(String strDEFInputTipSetModelId) throws Exception {
        IDEFInputTipSetModel iDEFInputTipSetModel = this.defInputTipSetModelMap.get(strDEFInputTipSetModelId);
        if (iDEFInputTipSetModel == null) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5c5e\u6027\u8f93\u5165\u63d0\u793a\u96c6\u5408\u6a21\u578b\uff0c\u5c5e\u6027\u8f93\u5165\u63d0\u793a\u96c6\u5408\u6807\u8bc6\u6a21\u578b[%1$s]", (Object)strDEFInputTipSetModelId));
        }
        return iDEFInputTipSetModel;
    }

    public IDBFunction getDBFunction(IDBDialect iDBDialect, String strFuncName) throws Exception {
        return iDBDialect.getDBFunction(strFuncName);
    }

    public IDataEntityModel getDataEntityModel(String strDEName, boolean bIncludeOtherSys) throws Exception {
        return this.getDataEntityModel(strDEName);
    }

    public void registerSystemValueRuleModel(ISystemValueRuleModel iSystemValueRuleModel) throws Exception {
        String strId = iSystemValueRuleModel.getId();
        if (this.sysValueRuleModelMap.containsKey(strId)) {
            throw new Exception(StringHelper.format((String)"\u7cfb\u7edf\u4e2d\u5df2\u7ecf\u6ce8\u518c\u4e86\u6807\u8bc6\u4e3a[%1$s]\u7684\u503c\u89c4\u5219\u5bf9\u8c61", (Object)strId));
        }
        if (!StringHelper.isNullOrEmpty((String)iSystemValueRuleModel.getUniqueTag()) && this.sysValueRuleModelMap.containsKey(iSystemValueRuleModel.getUniqueTag())) {
            throw new Exception(StringHelper.format((String)"\u7cfb\u7edf\u4e2d\u5df2\u7ecf\u6ce8\u518c\u4e86\u6807\u8bc6\u4e3a[%1$s]\u7684\u503c\u89c4\u5219\u5bf9\u8c61", (Object)iSystemValueRuleModel.getUniqueTag()));
        }
        this.sysValueRuleModelMap.put(strId, iSystemValueRuleModel);
        if (!StringHelper.isNullOrEmpty((String)iSystemValueRuleModel.getUniqueTag())) {
            this.sysValueRuleModelMap.put(iSystemValueRuleModel.getUniqueTag(), iSystemValueRuleModel);
        }
    }

    public ISystemValueRuleModel getSystemValueRuleModel(String strValueRuleModelId) throws Exception {
        ISystemValueRuleModel iSystemValueRuleModel = this.sysValueRuleModelMap.get(strValueRuleModelId);
        if (iSystemValueRuleModel == null) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u503c\u89c4\u5219\u5bf9\u8c61\uff0c\u503c\u89c4\u5219\u5bf9\u8c61\u6807\u8bc6[%1$s]", (Object)strValueRuleModelId));
        }
        return iSystemValueRuleModel;
    }

    public void registerSystemLogicModel(ISystemLogicModel iSystemLogicModel) throws Exception {
        String strId = iSystemLogicModel.getId();
        if (this.systemLogicModelMap.containsKey(strId)) {
            throw new Exception(StringHelper.format((String)"\u7cfb\u7edf\u4e2d\u5df2\u7ecf\u6ce8\u518c\u4e86\u6807\u8bc6\u4e3a[%1$s]\u7684\u7cfb\u7edf\u903b\u8f91\u5bf9\u8c61", (Object)strId));
        }
        if (!StringHelper.isNullOrEmpty((String)iSystemLogicModel.getUniqueTag()) && this.systemLogicModelMap.containsKey(iSystemLogicModel.getUniqueTag())) {
            throw new Exception(StringHelper.format((String)"\u7cfb\u7edf\u4e2d\u5df2\u7ecf\u6ce8\u518c\u4e86\u6807\u8bc6\u4e3a[%1$s]\u7684\u7cfb\u7edf\u903b\u8f91\u5bf9\u8c61", (Object)iSystemLogicModel.getUniqueTag()));
        }
        this.systemLogicModelMap.put(strId, iSystemLogicModel);
        if (!StringHelper.isNullOrEmpty((String)iSystemLogicModel.getUniqueTag())) {
            this.systemLogicModelMap.put(iSystemLogicModel.getUniqueTag(), iSystemLogicModel);
        }
    }

    public ISystemLogicModel getSystemLogicModel(String strSystemLogicModelId) throws Exception {
        ISystemLogicModel iSystemLogicModel = this.systemLogicModelMap.get(strSystemLogicModelId);
        if (iSystemLogicModel == null) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u903b\u8f91\u5bf9\u8c61\uff0c\u7cfb\u7edf\u903b\u8f91\u6807\u8bc6[%1$s]", (Object)strSystemLogicModelId));
        }
        return iSystemLogicModel;
    }

    public boolean isNoViewMode(IDataEntityModel iDataEntityModel) {
        return iDataEntityModel.isNoViewMode();
    }

    public String getDEOPPrivTarget(String strDEOPPriv) {
        if (StringHelper.isNullOrEmpty((String)strDEOPPriv)) {
            return "UNKNOWN";
        }
        if (StringHelper.compare((String)strDEOPPriv, (String)"CREATE", (boolean)true) == 0 || strDEOPPriv.indexOf("SRFUR__") == 0) {
            return "NONE";
        }
        return "DATA";
    }

    public void registerDTSQueueModel(IDTSQueueModel iDTSQueueModel) throws Exception {
    }

    public IDTSQueueModel getDTSQueueModel(String strDTSQueueModelId) throws Exception {
        return null;
    }

    public IDTSQueueModel createDTSQueueModel(String strType, String strUserTag) throws Exception {
        return null;
    }

    public void registerServiceAPIClientModel(IServiceAPIClientModel iServiceAPIClientModel) throws Exception {
    }

    public IServiceAPIClientModel getServiceAPIClientModel(String strServiceAPIClientModelId) throws Exception {
        return null;
    }

    public String getServiceAPIClientId() {
        return null;
    }

    public boolean isUseServiceAPI() {
        return false;
    }

    public IServiceAPIClientModel getServiceAPIClientModel() throws Exception {
        return null;
    }

    public boolean isDEUseServiceAPI(IDataEntityModel iDataEntityModel) {
        return this.isUseServiceAPI();
    }

    public String getServicePath(IServiceAPIClientModel iServiceAPIClientModel, IServiceAPIAction iServiceAPIAction, Object objParam) throws Exception {
        return iServiceAPIClientModel.getServicePath();
    }

    public void registerSystemUserRoleModel(ISystemUserRoleModel iSystemUserRoleModel) throws Exception {
    }

    public ISystemUserRoleModel getSystemUserRoleModel(String strSystemUserRoleModelId) throws Exception {
        return null;
    }

    public ISystemUserRoleModel createSystemUserRoleModel(String strType, String strRoleTag) throws Exception {
        if (StringHelper.compare((String)strType, (String)"DEDATASET", (boolean)false) == 0) {
            return new DEDataSetSystemUserRoleModel();
        }
        if (StringHelper.compare((String)strType, (String)"CUSTOM", (boolean)false) == 0) {
            return new CustomSystemUserRoleModel();
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u7cfb\u7edf\u89d2\u8272\u7c7b\u578b[%1$s]", (Object)strType));
    }

    public IDynaSystemSetting getDynaSystemSetting() {
        return this.iDynaSystemSetting;
    }

    public void setDynaSystemSetting(IDynaSystemSetting iDynaSystemSetting) {
        this.iDynaSystemSetting = iDynaSystemSetting;
    }

    public ISystemSetting getSystemSetting() {
        return this.systemSettingModel;
    }

    public void installDBModel(String strVersion, boolean bIgnoreCheck) throws Exception {
    }

    public void registerDEUIActionModel(IDEUIActionModel iDEUIActionModel) throws Exception {
    }

    public IDEUIActionModel getDEUIActionModel(String strDEUIActionId, boolean bTryMode) throws Exception {
        return null;
    }

    public JSONObject toJSONObject(IDataEntityModel iDataEntityModel, IEntity iEntity, boolean bIncludeEmpty, int nOption) throws Exception {
        if (iDataEntityModel == null) {
            return DataObject.toJSONObject((IDataObject)iEntity, (boolean)bIncludeEmpty);
        }
        return iDataEntityModel.toJSONObject(iEntity, bIncludeEmpty, nOption);
    }

    public void registerSystemPartModel(ISystemPartModel iSystemPartModel) throws Exception {
        String strId = iSystemPartModel.getId();
        if (this.systemPartModelMap.containsKey(strId)) {
            throw new Exception(StringHelper.format((String)"\u7cfb\u7edf\u4e2d\u5df2\u7ecf\u6ce8\u518c\u4e86\u6807\u8bc6\u4e3a[%1$s]\u7684\u7cfb\u7edf\u6210\u5458\u6a21\u578b", (Object)strId));
        }
        this.systemPartModelMap.put(strId, iSystemPartModel);
    }

    public void logException(Object logger, Throwable throwable, String strMessage, Object objUserData) {
    }

    public void registerSystemUtil(ISystemUtil iSystemUtil) throws Exception {
    }

    public ISystemUtil getSystemUtil(String strUtilType, boolean bTry) throws Exception {
        return null;
    }

    public String getModuleId() {
        return null;
    }

    public Iterator<IDataEntityModel> getDataEntityModels() {
        return null;
    }
}
