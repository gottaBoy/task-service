/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.paas.demodel;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.api.IServiceAPIClientModel;
import net.ibizsys.paas.core.IDEACMode;
import net.ibizsys.paas.core.IDEAction;
import net.ibizsys.paas.core.IDEActionWizard;
import net.ibizsys.paas.core.IDEActionWizardGroup;
import net.ibizsys.paas.core.IDEBATable;
import net.ibizsys.paas.core.IDEDBConfig;
import net.ibizsys.paas.core.IDEDataExport;
import net.ibizsys.paas.core.IDEDataImport;
import net.ibizsys.paas.core.IDEDataQuery;
import net.ibizsys.paas.core.IDEDataSet;
import net.ibizsys.paas.core.IDEDataSetCond;
import net.ibizsys.paas.core.IDEDataSync;
import net.ibizsys.paas.core.IDEFSearchMode;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.core.IDELogic;
import net.ibizsys.paas.core.IDEMainState;
import net.ibizsys.paas.core.IDEOPPrivRole;
import net.ibizsys.paas.core.IDER1N;
import net.ibizsys.paas.core.IDEUIAction;
import net.ibizsys.paas.core.IDEUniState;
import net.ibizsys.paas.core.IDEUserRole;
import net.ibizsys.paas.core.IDEWF;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.IModelBase3;
import net.ibizsys.paas.data.ISimpleDataObject;
import net.ibizsys.paas.db.IDBDialect;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.ISelectContext;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.demodel.IDEActionLogicModel;
import net.ibizsys.paas.demodel.IDELogicModel;
import net.ibizsys.paas.demodel.IDEWFModel;
import net.ibizsys.paas.demodel.ISqlCommandModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.security.IDEDataAccMgr;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.IServicePlugin;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.sysmodel.ISystemRuntime;
import net.ibizsys.paas.view.IDynaViewSetting;
import net.ibizsys.paas.web.IWebContext;
import net.sf.json.JSONObject;
import org.hibernate.SessionFactory;

public interface IDataEntityModel<ET extends IEntity>
extends IDataEntity,
IModelBase3 {
    public static final String DEOPPRIVTARGET_NONE = "NONE";
    public static final String DEOPPRIVTARGET_DATA = "DATA";
    public static final String DEOPPRIVTARGET_UNKNOWN = "UNKNOWN";

    public String getLogicName(String var1);

    public ET createEntity();

    public ArrayList<ET> createEntityList();

    public IService getService();

    public String getServiceId();

    public IService getService(SessionFactory var1) throws Exception;

    public Iterator<IDELogicModel<ET>> getDEActionLogics(String var1, String var2);

    public Iterator<IDEActionLogicModel> getDEActionLogics2(String var1, String var2);

    public IDEFSearchMode getDEFSearchMode(String var1, boolean var2) throws Exception;

    public ISqlCommandModel getGetSqlCommandModel(IDBDialect var1, boolean var2) throws Exception;

    public ISqlCommandModel getGetSqlCommandModel(IDBDialect var1, int var2, boolean var3) throws Exception;

    public ISqlCommandModel getGetSqlCommandModel2(IDBDialect var1, int var2, boolean var3) throws Exception;

    public ISqlCommandModel getCheckKeySqlCommandModel(IDBDialect var1, boolean var2) throws Exception;

    public ISqlCommandModel getCheckKeySqlCommandModel2(IDBDialect var1, boolean var2) throws Exception;

    public ISqlCommandModel getCreateSqlCommandModel(IDBDialect var1, boolean var2) throws Exception;

    public ISqlCommandModel getCreateSqlCommandModel(IDBDialect var1, IEntity var2, boolean var3) throws Exception;

    public ISqlCommandModel getUpdateSqlCommandModel(IDBDialect var1, IEntity var2, boolean var3) throws Exception;

    public ISqlCommandModel getSysUpdateSqlCommandModel(IDBDialect var1, IEntity var2, boolean var3) throws Exception;

    public ISqlCommandModel getRemoveSqlCommandModel(IDBDialect var1, boolean var2) throws Exception;

    public ISqlCommandModel getSelectSqlCommandModel(IDBDialect var1, ISelectCond var2, boolean var3) throws Exception;

    public ISqlCommandModel getSelectSqlCommandModelEx(IDBDialect var1, ISelectContext var2, boolean var3) throws Exception;

    public ISqlCommandModel getMergeSqlCommandModel(IDBDialect var1) throws Exception;

    public IDEDataSetCond getFetchQuickSearchCondition(String var1) throws Exception;

    public ISystemRuntime getSystemRuntime();

    public String getDEMainStateTag(ISimpleDataObject var1) throws Exception;

    public boolean hasDEMainState();

    public String getDEMainStateDenyMsg(IDEMainState var1, ISimpleDataObject var2, int var3, String var4) throws Exception;

    public String getDataInfo(ET var1) throws Exception;

    public IDEWF getDefaultDEWF();

    public Iterator<IDEWF> getDEWFs();

    public IDEField getPickupDEField(String var1) throws Exception;

    public IDEField getPickupDEField(IDataEntityModel var1, boolean var2) throws Exception;

    public IDEField getDEFieldByPDT(String var1, boolean var2) throws Exception;

    public void registerDEActionLogic(String var1, String var2, String var3, String var4) throws Exception;

    public IDEActionLogicModel registerDEActionLogic(String var1, String var2, String var3, String var4, boolean var5, boolean var6) throws Exception;

    public IDER1N getAccMasterDER(ET var1) throws Exception;

    public boolean isEnableAudit();

    public boolean isLogAuditDetail();

    public IDEDataAccMgr getDEDataAccMgr();

    public IDEWFModel testDataInWF(IEntity var1) throws Exception;

    public Object getOrgId(IEntity var1) throws Exception;

    public ISystemModel getSystemModel();

    public IDEField getUpdateDateDEField();

    public void registerDEField(IDEField var1);

    public void registerDEACMode(IDEACMode var1);

    public void registerDELogic(IDELogic var1);

    public void registerDEUIAction(IDEUIAction var1);

    public void registerDEWF(IDEWF var1);

    public void registerDEMainState(IDEMainState var1);

    public void registerDEDataQuery(IDEDataQuery var1);

    public void registerDEDataSet(IDEDataSet var1);

    public void registerDEAction(IDEAction var1);

    public void registerDEActionLogic(String var1, String var2, String var3) throws Exception;

    public void registerDEDataExport(IDEDataExport var1);

    public void registerDEDataImport(IDEDataImport var1);

    public void registerDEActionWizard(IDEActionWizard var1);

    public void registerDEActionWizardGroup(IDEActionWizardGroup var1);

    public String getDEViewIdByPDT(String var1, boolean var2) throws Exception;

    public void registerPDTDEView(String var1, String var2) throws Exception;

    public String getSDDEViewPDTParam(ET var1, boolean var2, boolean var3) throws Exception;

    public String getSDDEViewPDTParam(ET var1, boolean var2, boolean var3, int var4) throws Exception;

    public boolean isEnableMultiForm();

    public String getIndexDEType();

    public IDEField getMultiFormDEField();

    public IDEField getIndexTypeDEField();

    public IDataEntityModel getInheritDEModel() throws Exception;

    public String getInheritTypeValue();

    public void registerMapDEOPPrivTag(String var1, String var2, String var3);

    public IDEWFModel getDEWFModel(ET var1, IWebContext var2) throws Exception;

    public void registerDEDataSync(IDEDataSync var1);

    public Iterator<IDEField> getUnionKeyValueDEFields();

    public String getDEFieldConditionSql(IDBDialect var1, String var2, String var3, int var4, String var5, String var6) throws Exception;

    public String getDEFieldConditionSql(IDBDialect var1, String var2, String var3, int var4, String var5, String var6, boolean var7, SqlParamList var8) throws Exception;

    public void registerDEBATable(IDEBATable var1);

    public void setServicePlugin(IServicePlugin var1) throws Exception;

    public void setServicePlugin(IServicePlugin var1, boolean var2) throws Exception;

    public IServicePlugin getServicePlugin();

    public String getViewName(int var1);

    public boolean isEnableEntityCache();

    public int getEntityCacheTimeout();

    public int getEntityCacheCount();

    public void registerDEUniState(IDEUniState var1);

    public Object getRuntimeId();

    public void setRuntimeId(Object var1);

    public String getDEOPPrivTarget(String var1);

    public boolean isUseServiceAPI();

    public String getServiceAPIActionTag(String var1, String var2) throws Exception;

    public IServiceAPIClientModel getServiceAPIClientModel() throws Exception;

    public void registerDEUserRole(IDEUserRole var1);

    public void registerDEOPPrivRole(IDEOPPrivRole var1);

    public String getAuditDEName();

    public String getAuditDetailDEName();

    public IDynaViewSetting getDynaViewSetting();

    public void registerDEDBConfig(IDEDBConfig var1);

    public JSONObject toJSONObject(IEntity var1, boolean var2, int var3) throws Exception;

    public boolean isEnableDynaStorage();

    public String getDynaStorageDEName();

    public boolean hasDynaStorageDEField();

    public IDEField getOrgIdDEField();

    public boolean isEnableTempData();
}

