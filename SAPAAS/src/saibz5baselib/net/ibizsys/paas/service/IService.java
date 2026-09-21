/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.paas.service;

import java.util.ArrayList;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.core.IDEDataSyncIn;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.db.DBCallResult;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.ISelectContext;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.service.IDataContextParam;
import net.ibizsys.paas.service.IServiceCreateParam;
import net.ibizsys.paas.service.IServiceUpdateParam;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.psrt.srv.common.entity.DataSyncIn;
import net.ibizsys.pswf.core.IWFActionContext;
import net.sf.json.JSONObject;
import org.hibernate.SessionFactory;

public interface IService<ET extends IEntity> {
    public static final int CHECKKEYSTATE_OK = 0;
    public static final int CHECKKEYSTATE_NOTEXIST = 0;
    public static final int CHECKKEYSTATE_EXIST = 1;
    public static final int CHECKKEYSTATE_DELETE = 2;
    public static final int SAVEMODE_CREATEONLY = 1;
    public static final int SAVEMODE_UPDATEONLY = 2;
    public static final int SAVEMODE_ALL = 3;
    public static final String ACTION_GETDRAFT = "GETDRAFT";
    public static final String ACTION_AUTOGET = "AUTOGET";
    public static final String ACTION_TRYAUTOGET = "TRYAUTOGET";
    public static final String ACTION_GET = "GET";
    public static final String ACTION_TRYGET = "TRYGET";
    public static final String ACTION_GET2 = "GET2";
    public static final String ACTION_TRYGET2 = "TRYGET2";
    public static final String ACTION_GET3 = "GET3";
    public static final String ACTION_TRYGET3 = "TRYGET3";
    public static final String ACTION_GET4 = "GET4";
    public static final String ACTION_TRYGET4 = "TRYGET4";
    public static final String ACTION_GETCACHE = "GETCACHE";
    public static final String ACTION_SELECT = "SELECT";
    public static final String ACTION_TRYSELECT = "TRYSELECT";
    public static final String ACTION_CREATE = "CREATE";
    public static final String ACTION_UPDATE = "UPDATE";
    public static final String ACTION_INTERNALUPDATE = "INTERNALUPDATE";
    public static final String ACTION_SAVE = "SAVE";
    public static final String ACTION_CHECKKEY = "CHECKKEY";
    public static final String ACTION_REMOVE = "REMOVE";
    public static final String ACTION_GETDRAFTTEMP = "GETDRAFTTEMP";
    public static final String ACTION_GETTEMP = "GETTEMP";
    public static final String ACTION_CREATETEMP = "CREATETEMP";
    public static final String ACTION_UPDATETEMP = "UPDATETEMP";
    public static final String ACTION_REMOVETEMP = "REMOVETEMP";
    public static final String ACTION_GETDRAFTTEMPMAJOR = "GETDRAFTTEMPMAJOR";
    public static final String ACTION_GETTEMPMAJOR = "GETTEMPMAJOR";
    public static final String ACTION_CREATETEMPMAJOR = "CREATETEMPMAJOR";
    public static final String ACTION_UPDATETEMPMAJOR = "UPDATETEMPMAJOR";
    public static final String ACTION_REMOVETEMPMAJOR = "REMOVETEMPMAJOR";
    public static final String ACTION_GETDRAFTFROM = "GETDRAFTFROM";
    public static final String ACTION_GETDRAFTTEMPFROM = "GETDRAFTTEMPFROM";
    public static final String ACTION_GETDRAFTTEMPMAJORFROM = "GETDRAFTTEMPMAJORFROM";
    public static final String ACTION_EXPORTMODEL = "EXPORTMODEL";
    public static final String ACTION_EXPORTMAJORMODEL = "EXPORTMAJORMODEL";
    public static final String ACTION_EXPORTCURMODEL = "EXPORTCURMODEL";
    public static final String ACTION_EXPORTRELATEDMODEL = "EXPORTRELATEDMODEL";
    public static final Integer UPDATEWFINFOMODE_INIT = 0;
    public static final Integer UPDATEWFINFOMODE_UPDATESTATE = 1;
    public static final Integer UPDATEWFINFOMODE_FINISH = 2;
    public static final Integer UPDATEWFINFOMODE_CANCEL = 3;
    public static final Integer UPDATEWFINFOMODE_CANCELSTART = 4;
    public static final String ACTION_INITWF = "INITWF";
    public static final String ACTION_FINISHWF = "FINISHWF";
    public static final String ACTION_CLOSEWF = "CLOSEWF";
    public static final String ACTION_CANCELSTARTWF = "CANCELSTARTWF";
    public static final int DATACHGEVENT_INSERT = 1;
    public static final int DATACHGEVENT_UPDATE = 2;
    public static final int DATACHGEVENT_INSERTORUPDATE = 3;
    public static final int DATACHGEVENT_DELETE = 4;
    public static final int EXPORTMODELMODE_CREATE = 1;
    public static final int EXPORTMODELMODE_UPDATE = 2;
    public static final int EXPORTMODELMODE_CREATEUPDATE = 3;
    public static final int EXPORTMODELMODE_NOOPERATORINFO = 4;
    public static final int EXPORTMODELMODE_NOMAJORMODEL = 8;
    public static final int EXPORTMODELMODE_NORELATEDMODEL = 16;
    public static final int EXPORTMODELMODE_NOCURMODEL = 32;
    public static final int EXPORTMODELMODE_PHYSICALONLY = 64;
    public static final int EXPORTMODELMODE_NOTINCLUDEEMPTY = 128;
    public static final int EXPORTMODELMODE_USER1 = 65536;
    public static final int EXPORTMODELMODE_USER2 = 131072;
    public static final int EXPORTMODELMODE_USER3 = 262144;
    public static final int EXPORTMODELMODE_USER4 = 524288;

    public IWebContext getWebContext();

    public IDAO getDAO();

    public IDataEntityModel getDEModel();

    public DBFetchResult fetchDataSet(String var1, IDEDataSetFetchContext var2) throws Exception;

    public DBFetchResult fetchDataSetTemp(String var1, IDEDataSetFetchContext var2) throws Exception;

    public void executeAction(String var1, IEntity var2) throws Exception;

    public void executeAction(String var1, ArrayList<IEntity> var2) throws Exception;

    public boolean autoGet(ET var1, boolean var2) throws Exception;

    public void autoGet(ET var1) throws Exception;

    public boolean get(ET var1, boolean var2) throws Exception;

    public void get(ET var1) throws Exception;

    public boolean get2(ET var1, boolean var2) throws Exception;

    public void get2(ET var1) throws Exception;

    public boolean get3(ET var1, boolean var2) throws Exception;

    public void get3(ET var1) throws Exception;

    public boolean get4(ET var1, boolean var2) throws Exception;

    public void get4(ET var1) throws Exception;

    public void getCache(ET var1) throws Exception;

    public ET getCache(Object var1) throws Exception;

    public void resetCache();

    public void create(ET var1) throws Exception;

    public void create(ET var1, boolean var2) throws Exception;

    public void update(ET var1) throws Exception;

    public void update(ET var1, boolean var2) throws Exception;

    public void sysUpdate(ET var1, boolean var2) throws Exception;

    public void sysUpdateTemp(ET var1, boolean var2) throws Exception;

    public void save(ET var1) throws Exception;

    public void save(ET var1, int var2) throws Exception;

    public void save(ET var1, int var2, boolean var3) throws Exception;

    public void save(ET var1, boolean var2) throws Exception;

    public void remove(ET var1) throws Exception;

    public void getTemp(ET var1) throws Exception;

    public void createTemp(ET var1) throws Exception;

    public void updateTemp(ET var1) throws Exception;

    public void removeTemp(ET var1) throws Exception;

    public void removeTemp(ArrayList<ET> var1) throws Exception;

    public void remove(ArrayList<ET> var1) throws Exception;

    public void remove(ISelectCond var1, boolean var2) throws Exception;

    public boolean select(ET var1, boolean var2) throws Exception;

    public boolean selectOne(ET var1, boolean var2) throws Exception;

    public boolean selectTempOne(ET var1, boolean var2) throws Exception;

    public ArrayList<ET> select(ISelectCond var1) throws Exception;

    public ArrayList<ET> selectTemp(ISelectCond var1) throws Exception;

    public ArrayList<ET> selectEx(ISelectContext var1) throws Exception;

    public ArrayList<ET> selectTempEx(ISelectContext var1) throws Exception;

    public boolean selectTemp(ET var1, boolean var2) throws Exception;

    public void getDraft(ET var1) throws Exception;

    public void getDraftTemp(ET var1) throws Exception;

    public void getDraftFrom(ET var1) throws Exception;

    public void getDraftTempFrom(ET var1) throws Exception;

    public void getDraftTempMajorFrom(ET var1) throws Exception;

    public ET clone(ET var1) throws Exception;

    public ET cloneToTemp(ET var1) throws Exception;

    public ET cloneTemp(ET var1) throws Exception;

    public int checkKey(ET var1) throws Exception;

    public int checkKeyTemp(ET var1) throws Exception;

    public void updateWFInfo(int var1, IWFActionContext var2, ET var3) throws Exception;

    public Object getDataContextValue(ET var1, String var2, IDataContextParam var3) throws Exception;

    public String getDSLink();

    public void setDSLink(String var1);

    public void setSessionFactory(SessionFactory var1);

    public SessionFactory getSessionFactory();

    public ArrayList<IEntity> selectRaw(String var1, SqlParamList var2) throws Exception;

    public DBCallResult executeRaw(String var1, SqlParamList var2) throws Exception;

    public ArrayList<ET> select(String var1, SqlParamList var2) throws Exception;

    public DBCallResult executeRawBatch(String[] var1, SqlParamList[] var2, int var3) throws Exception;

    public String importModel(JSONObject var1) throws Exception;

    public void exportModel(ET var1, ArrayList<JSONObject> var2) throws Exception;

    public void exportModel(ET var1, ArrayList<JSONObject> var2, int var3) throws Exception;

    public EntityFieldError testValueRule(String var1, String var2, IEntity var3, String var4, boolean var5) throws Exception;

    public boolean fillEntityKeyValue(ET var1) throws Exception;

    public void updateTemp(ET var1, boolean var2) throws Exception;

    public boolean fillEntityKeyValue(ET var1, boolean var2) throws Exception;

    public void fillParentInfo(ET var1, String var2, String var3, String var4) throws Exception;

    public void beginMergeChild(ET var1) throws Exception;

    public void endMergeChild(ET var1, boolean var2) throws Exception;

    public void mergeChild(String var1, String var2, Object var3) throws Exception;

    public void copyDetails(ET var1, Object var2) throws Exception;

    public void syncData(DataSyncIn var1, IDEDataSyncIn var2) throws Exception;

    public ISystemModel getSystemModel();

    public void fillEntityActionHelper(ET var1) throws Exception;

    public void executeLogic(String var1, IEntity var2) throws Exception;

    public boolean isEnableEntityCache() throws Exception;

    public boolean isTempData(IEntity var1) throws Exception;

    public void removeUncopyValues(ET var1, boolean var2) throws Exception;

    public ArrayList<IEntity> convertPickupData(ArrayList<IEntity> var1) throws Exception;

    public boolean isUseServiceAPI();

    public IEntityActionHelper getServiceActionHelper();

    public String getDataSummary(ET var1) throws Exception;

    public void create(IServiceCreateParam<ET> var1) throws Exception;

    public void update(IServiceUpdateParam<ET> var1) throws Exception;

    public boolean isEnableDynaStorage();

    public DBCallResult callProc(String var1, SqlParamList var2) throws Exception;
}

