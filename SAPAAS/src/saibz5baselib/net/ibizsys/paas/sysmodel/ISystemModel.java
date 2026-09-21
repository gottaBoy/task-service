/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.sysmodel;

import java.util.Iterator;
import net.ibizsys.paas.api.IServiceAPIAction;
import net.ibizsys.paas.api.IServiceAPIClientModel;
import net.ibizsys.paas.cache.IUniStateManager;
import net.ibizsys.paas.cache.IUniStateModel;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.core.IDERBase;
import net.ibizsys.paas.core.IModelBase3;
import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.core.ISystemSetting;
import net.ibizsys.paas.core.IValueTranslator;
import net.ibizsys.paas.db.IDBDialect;
import net.ibizsys.paas.db.IDBFunction;
import net.ibizsys.paas.demodel.IDEActionWizardModel;
import net.ibizsys.paas.demodel.IDEFInputTipSetModel;
import net.ibizsys.paas.demodel.IDEUIActionModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.dts.IDTSQueueModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.security.IDEDataAccMgr;
import net.ibizsys.paas.sysmodel.IDynaSystemSetting;
import net.ibizsys.paas.sysmodel.ISystemLogicModel;
import net.ibizsys.paas.sysmodel.ISystemPartModel;
import net.ibizsys.paas.sysmodel.ISystemPlugin;
import net.ibizsys.paas.sysmodel.ISystemUserRoleModel;
import net.ibizsys.paas.sysmodel.ISystemUtil;
import net.ibizsys.paas.sysmodel.ISystemValueRuleModel;
import net.ibizsys.paas.view.IViewMessage;
import net.ibizsys.paas.view.IViewMsgGroupModel;
import net.ibizsys.paas.view.IViewMsgModel;
import net.ibizsys.paas.view.IViewWizard;
import net.ibizsys.paas.view.IViewWizardGroupModel;
import net.ibizsys.psba.core.IBASchemeModel;
import net.ibizsys.pswf.core.IWFModel;
import net.ibizsys.pswf.core.IWFRoleModel;
import net.sf.json.JSONObject;

public interface ISystemModel
extends ISystem,
IModelBase3 {
    public static final int GETMODE_EXCEPTIONIF = 0;
    public static final int GETMODE_TRY = 1;
    public static final int GETMODE_CREATEIF = 2;
    public static final String USERDICTCAT = "USERDICTCAT";
    public static final String USERDICTCAT_GLOBAL = "GLOBAL";
    public static final String USERDICTCAT_USER = "USER";

    public IDataEntityModel getDataEntityModel(String var1) throws Exception;

    public IDataEntityModel getDataEntityModel(String var1, boolean var2) throws Exception;

    public IWFModel getWFModel(String var1) throws Exception;

    public IWFRoleModel getWFRoleModel(String var1) throws Exception;

    public IWFModel getWFModel(String var1, boolean var2) throws Exception;

    public IWFRoleModel getWFRoleModel(String var1, boolean var2) throws Exception;

    public Iterator<IWFRoleModel> getWFRoleModels();

    public IValueTranslator getValueTranslator(String var1) throws Exception;

    public void installRTDatas() throws Exception;

    public Iterator<IDERBase> getDERs(String var1, boolean var2);

    public IDERBase getDER(String var1, boolean var2) throws Exception;

    public IDEDataAccMgr createDEDataAccMgr(IDataEntityModel var1) throws Exception;

    public void registerDataEntityModel(IDataEntityModel var1) throws Exception;

    public void registerWFModel(IWFModel var1) throws Exception;

    public void registerWFRoleModel(IWFRoleModel var1) throws Exception;

    public void registerSystemPartModel(ISystemPartModel var1) throws Exception;

    public void registerBASchemeModel(IBASchemeModel var1) throws Exception;

    public IBASchemeModel getBASchemeModel(String var1) throws Exception;

    public void registerViewMsgGroupModel(IViewMsgGroupModel var1) throws Exception;

    public IViewMsgGroupModel getViewMsgGroupModel(String var1) throws Exception;

    public void registerViewMsgModel(IViewMsgModel var1) throws Exception;

    public IViewMsgModel getViewMsgModel(String var1) throws Exception;

    public Iterator<IViewMessage> getViewMessages(IViewController var1, IViewMsgGroupModel var2) throws Exception;

    public Iterator<IViewWizard> getViewWizards(IViewController var1, IViewWizardGroupModel var2, String var3) throws Exception;

    public void setSystemPlugin(ISystemPlugin var1) throws Exception;

    public void setSystemPlugin(ISystemPlugin var1, boolean var2) throws Exception;

    public ISystemPlugin getSystemPlugin();

    public IDEActionWizardModel createDEActionWizardModel(int var1, String var2) throws Exception;

    public IViewMsgModel createViewMsgModel(int var1, String var2) throws Exception;

    public void registerUniStateModel(IUniStateModel var1) throws Exception;

    public IUniStateModel getUniStateModel(String var1) throws Exception;

    public IUniStateModel createUniStateModel(String var1, String var2) throws Exception;

    public IUniStateManager getUniStateManager();

    public void fillViewMsgActiveData(IEntity var1, IViewMsgModel var2, IViewController var3) throws Exception;

    public IDEFInputTipSetModel createDEFInputTipSetModel(String var1) throws Exception;

    public void registerDEFInputTipSetModel(IDEFInputTipSetModel var1) throws Exception;

    public IDEFInputTipSetModel getDEFInputTipSetModel(String var1) throws Exception;

    public IDBFunction getDBFunction(IDBDialect var1, String var2) throws Exception;

    public void registerSystemValueRuleModel(ISystemValueRuleModel var1) throws Exception;

    public ISystemValueRuleModel getSystemValueRuleModel(String var1) throws Exception;

    public void registerSystemLogicModel(ISystemLogicModel var1) throws Exception;

    public ISystemLogicModel getSystemLogicModel(String var1) throws Exception;

    public boolean isNoViewMode(IDataEntityModel var1);

    public String getDEOPPrivTarget(String var1);

    public void registerDTSQueueModel(IDTSQueueModel var1) throws Exception;

    public IDTSQueueModel getDTSQueueModel(String var1) throws Exception;

    public IDTSQueueModel createDTSQueueModel(String var1, String var2) throws Exception;

    public void registerServiceAPIClientModel(IServiceAPIClientModel var1) throws Exception;

    public IServiceAPIClientModel getServiceAPIClientModel(String var1) throws Exception;

    public String getServicePath(IServiceAPIClientModel var1, IServiceAPIAction var2, Object var3) throws Exception;

    public ISystemUserRoleModel createSystemUserRoleModel(String var1, String var2) throws Exception;

    public void registerSystemUserRoleModel(ISystemUserRoleModel var1) throws Exception;

    public ISystemUserRoleModel getSystemUserRoleModel(String var1) throws Exception;

    public IDynaSystemSetting getDynaSystemSetting();

    public ISystemSetting getSystemSetting();

    public void installDBModel(String var1, boolean var2) throws Exception;

    public void registerDEUIActionModel(IDEUIActionModel var1) throws Exception;

    public IDEUIActionModel getDEUIActionModel(String var1, boolean var2) throws Exception;

    public JSONObject toJSONObject(IDataEntityModel var1, IEntity var2, boolean var3, int var4) throws Exception;

    public void logException(Object var1, Throwable var2, String var3, Object var4);

    public void registerSystemUtil(ISystemUtil var1) throws Exception;

    public ISystemUtil getSystemUtil(String var1, boolean var2) throws Exception;

    public Iterator<IDataEntityModel> getDataEntityModels();
}

