/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core;

import java.util.Iterator;
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
import net.ibizsys.paas.core.IDEDataSync;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.core.IDELogic;
import net.ibizsys.paas.core.IDEMainState;
import net.ibizsys.paas.core.IDEOPPrivRole;
import net.ibizsys.paas.core.IDERBase;
import net.ibizsys.paas.core.IDERIndex;
import net.ibizsys.paas.core.IDEUIAction;
import net.ibizsys.paas.core.IDEUniState;
import net.ibizsys.paas.core.IDEUserRole;
import net.ibizsys.paas.core.IDEWF;
import net.ibizsys.paas.core.IModelBase;
import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.data.ISimpleDataObject;

public interface IDataEntity
extends IModelBase {
    public static final String DSLINK_DEFAULT = "DEFAULT";
    public static final String DSLINK_DB2 = "DB2";
    public static final String DSLINK_DB3 = "DB3";
    public static final String DSLINK_DB4 = "DB4";
    public static final String DSLINK_DB5 = "DB5";
    public static final String DSLINK_DB6 = "DB6";
    public static final String DSLINK_DB7 = "DB7";
    public static final String DSLINK_DB8 = "DB8";
    public static final String DSLINK_DB9 = "DB9";
    public static final String DSLINK_DB10 = "DB10";
    public static final String DSLINK_DB11 = "DB11";
    public static final String DSLINK_DB12 = "DB12";
    public static final int DYNAMICMODE_STATIC = 0;
    public static final int DYNAMICMODE_DYNAMIC = 1;
    public static final int DYNAMICMODE_EXTEND = 2;
    public static final int DATAACCCTRL_NONE = 0;
    public static final int DATAACCCTRL_SELF = 1;
    public static final int DATAACCCTRL_MASTER = 2;
    public static final int DATAACCCTRL_MASTER_SELF = 3;
    public static final int DATAACCCTRLARCH_RTSYSROLE = 1;
    public static final int DATAACCCTRLARCH_SYSROLE_DEROLE = 2;
    public static final int AUDITMODE_NONE = 0;
    public static final int AUDITMODE_STD = 1;
    public static final int AUDITMODE_ADV = 2;
    public static final String INDEXDETYPE_INDEX = "INDEX";
    public static final String INDEXDETYPE_INHERIT = "INHERIT";
    public static final int DATACHGLOG_NONE = 0;
    public static final int DATACHGLOG_SINGLEDATA = 2;
    public static final int DATACHGLOG_FULLDATA = 3;
    public static final int DATACHGLOG_SINGLEDATA_ASYNC = 4;
    public static final int DATACHGLOG_FULLDATA_ASYNC = 5;
    public static final int STORAGEMODE_NONE = 0;
    public static final int STORAGEMODE_SQL = 1;
    public static final int STORAGEMODE_NoSQL = 2;
    public static final int STORAGEMODE_SQLAndNoSQL = 3;
    public static final int STORAGEMODE_SERVICEAPI = 4;
    public static final int STORAGEMODE_MULTI = 8;
    public static final int STORAGEMODE_SQLAndMore = 9;
    public static final int STORAGEMODE_NoSQLAndMore = 10;
    public static final int STORAGEMODE_SERVICEAPIAndMore = 12;
    public static final int STORAGEMODE_USER = 128;
    public static final int STORAGEMODE_USER2 = 256;
    public static final int VIEWLEVEL_UNKNOWN = -1;
    public static final int VIEWLEVEL_DEFAULT = 0;
    public static final int VIEWLEVEL_LEVEL2 = 1;
    public static final int VIEWLEVEL_LEVEL3 = 2;
    public static final int VIEWLEVEL_LEVEL4 = 3;
    public static final int DATAIMPEXPFLAG__NONE = 0;
    public static final int DATAIMPEXPFLAG_EXPORT = 1;
    public static final int DATAIMPEXPFLAG_IMPORT = 2;
    public static final int DATAIMPEXPFLAG_ALL = 3;

    public ISystem getSystem();

    public Iterator<IDEField> getDEFields() throws Exception;

    public IDEField getDEField(String var1, boolean var2) throws Exception;

    public IDEField getKeyDEField();

    public IDEField getUniTagDEField();

    public IDEField getMajorDEField();

    public IDEField getLogicValidDEField();

    public String getTableName();

    public String getUserTable();

    public String getViewName();

    public String getView2Name();

    public String getView3Name();

    public String getView4Name();

    public IDERBase getDER(boolean var1, String var2) throws Exception;

    public Iterator<IDERBase> getDERs(boolean var1);

    public IDEDataSet getDEDataSet(String var1) throws Exception;

    public String getLogicName();

    public IDEAction getDEAction(String var1) throws Exception;

    public IDELogic getDELogic(String var1) throws Exception;

    public IDEUIAction getDEUIAction(String var1) throws Exception;

    public IDEWF getDEWF(String var1) throws Exception;

    public boolean hasDEWF();

    public IDataObject createDataObject() throws Exception;

    public IDEACMode getDEACMode(String var1) throws Exception;

    public IDEACMode getDefaultDEACMode() throws Exception;

    public IDEDataQuery getDEDataQuery(String var1) throws Exception;

    public IDEDataSet getDEDataSet(String var1, boolean var2) throws Exception;

    public boolean isLogicValid();

    public Object getLogicValidValue(boolean var1);

    public String getDSLink();

    public boolean isEnableMultiDS();

    public IDEMainState getDEMainState(ISimpleDataObject var1) throws Exception;

    public IDEDataImport getDEDataImport(String var1) throws Exception;

    public IDEDataExport getDEDataExport(String var1) throws Exception;

    public IDEActionWizardGroup getDEActionWizardGroup(String var1) throws Exception;

    public IDEActionWizardGroup getDEActionWizardGroup(String var1, boolean var2) throws Exception;

    public IDEActionWizard getDEActionWizard(String var1) throws Exception;

    public int getDataAccCtrlMode();

    public int getAuditMode();

    public IDERIndex getDERIndex(boolean var1, String var2) throws Exception;

    public IDataEntity getInheritDataEntity() throws Exception;

    public int getDynamicMode();

    public String getMapDEOPPrivTag(String var1, String var2);

    public int getDataChangeLogMode();

    public Iterator<IDEDataSync> getDEDataSyncs(boolean var1);

    public boolean isNoViewMode();

    public IDEDataQuery getDefaultDEDataQuery();

    public IDEDataQuery getViewDEDataQuery(int var1);

    public int getStorageMode();

    public IDEBATable getDEBATable(String var1) throws Exception;

    public Iterator<IDEBATable> getDEBATables();

    public IDEUniState getDEUniState(String var1) throws Exception;

    public Iterator<IDEUniState> getDEUniStates();

    public IDEUniState getDefaultDEUniState();

    public int getDataImpExpMode();

    public String getServiceAPIClientId();

    public String getDefaultDEDTSQueueId();

    public int getDataAccCtrlArch();

    public IDEUserRole getDEUserRole(String var1) throws Exception;

    public Iterator<IDEUserRole> getDEUserRoles();

    public Iterator<IDEOPPrivRole> getDEOPPrivRoles(String var1);

    public IDEDBConfig getDEDBConfig(String var1) throws Exception;

    public IDEDataImport getDefaultDEDataImport();
}

