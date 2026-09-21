/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.core.IDEAction
 */
package SA.SRFDA.PS.Core.DataEntity.Action;

import SA.SRFDA.PS.Core.DEField.IPSDEFGroup;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionInput;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionLogic;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionParam;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionReturn;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionTempl;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionVR;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntityObject;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEOPPriv;
import SA.SRFDA.PS.Core.DevTask.IPSDevTask;
import SA.SRFDA.PS.Core.DynaModel.IPSSysDynaModel;
import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginSupportable;
import SA.SRFDA.PS.Core.Res.IPSSysUniState;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Core.Service.IPSRESTfulAPI;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDEMethod;
import SA.SRFDA.PS.Core.Testing.IPSSysTestCase;
import SA.SRFDA.PS.Data.PSDEAction;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import java.util.Properties;
import net.ibizsys.paas.core.IDEAction;

@PSModelInterfaceMeta(typefield="actionType", implement="PSDEUserCustomActionImpl", title="\u5b9e\u4f53\u884c\u4e3a\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEAction", description="\u5b9e\u4f53\u884c\u4e3a\u6a21\u578b\u9664\u4e86\u81ea\u8eab\u903b\u8f91\u8fd8\u5305\u62ec\u4e86\u8f93\u5165{@link #getPSDEActionInput}\u53ca\u8fd4\u56de{@link #getPSDEActionReturn}\u6a21\u578b")
public interface IPSDEAction
extends IPSDataEntityObject,
IDEAction,
IPSDevTask,
IPSModelSortable,
IPSSysSFPluginSupportable {
    public static final String ACTIONTYPE_TEMPL = "TEMPL";
    public static final String ACTIONTYPE_SELECTBYKEY = "SELECTBYKEY";
    public static final String ACTIONTYPE_SCRIPT = "SCRIPT";
    public static final String ACTIONTYPE_REMOTE = "REMOTE";
    public static final int PARAMMODE_ALL = 1;
    public static final int PARAMMODE_SOME = 2;
    public static final int PARAMMODE_DYNAMODEL = 3;
    public static final int PARAMMODE_NONE = 99;
    public static final String ACTIONMODE_CREATE = "CREATE";
    public static final String ACTIONMODE_CREATE2 = "CREATE2";
    public static final String ACTIONMODE_READ = "READ";
    public static final String ACTIONMODE_UPDATE = "UPDATE";
    public static final String ACTIONMODE_UPDATE2 = "UPDATE2";
    public static final String ACTIONMODE_DELETE = "DELETE";
    public static final String ACTIONMODE_CUSTOM = "CUSTOM";
    public static final String ACTIONMODE_CUSTOM2 = "CUSTOM2";
    public static final String ACTIONMODE_UNKNOWN = "UNKNOWN";
    public static final String ACTIONMODE_GETDRAFT = "GETDRAFT";
    public static final String ACTIONMODE_GETDRAFTFROM = "GETDRAFTFROM";
    public static final String ACTIONMODE_CREATEBATCH = "CREATEBATCH";
    public static final String ACTIONMODE_CREATEBATCH2 = "CREATEBATCH2";
    public static final String ACTIONMODE_UPDATEBATCH = "UPDATEBATCH";
    public static final String ACTIONMODE_UPDATEBATCH2 = "UPDATEBATCH2";
    public static final String ACTIONMODE_DELETEBATCH = "DELETEBATCH";
    public static final String ACTIONMODE_CUSTOMBATCH = "CUSTOMBATCH";
    public static final String ACTIONMODE_CUSTOMBATCH2 = "CUSTOMBATCH2";
    public static final String ACTIONMODE_MOVEORDER = "MOVEORDER";
    public static final String ACTIONMODE_CHECKKEY = "CHECKKEY";
    public static final String ACTIONMODE_SAVE = "SAVE";
    public static final String ACTIONMODE_COPY = "COPY";
    public static final String ACTIONMODE_USER = "USER";
    public static final String ACTIONMODE_USER2 = "USER2";
    public static final String ACTIONMODE_USER3 = "USER3";
    public static final String ACTIONMODE_USER4 = "USER4";
    public static final String ACTIONMODE_USER5 = "USER5";
    public static final String ACTIONMODE_USER6 = "USER6";
    public static final String ACTIONMODE_USER7 = "USER7";
    public static final String ACTIONMODE_USER8 = "USER8";
    public static final String ACTIONMODE_USER9 = "USER9";
    public static final int ACTIONHOLDER_BACKEND = 1;
    public static final int ACTIONHOLDER_FRONT = 2;
    public static final int ACTIONHOLDER_BACKENDANDFRONT = 3;
    public static final int TEMPDATAMODE_NONE = 0;
    public static final int TEMPDATAMODE_MAJOR = 1;
    public static final int TEMPDATAMODE_MINOR = 2;
    public static final int TESTACTIONMODE_NONE = 0;
    public static final int TESTACTIONMODE_PROTECTED = 1;
    public static final int TESTACTIONMODE_PUBLIC = 3;
    public static final String TSMODE_NONE = "NONE";
    public static final String TSMODE_DEFAULT = "DEFAULT";
    public static final String TSMODE_GLOBAL = "GLOBAL";
    public static final String TSMODE_USER = "USER";
    public static final String TSMODE_USER2 = "USER2";
    public static final int BATCHACTIONMODE_NONE = 0;
    public static final int BATCHACTIONMODE_ENABLE = 1;
    public static final int BATCHACTIONMODE_BATCHONLY = 2;
    public static final int BATCHACTIONMODE_ENABLEEX = 5;
    public static final int BATCHACTIONMODE_BATCHONLYEX = 6;
    public static final String RETURNTYPE_VOID = "VOID";
    public static final String RETURNTYPE_SIMPLE = "SIMPLE";
    public static final String RETURNTYPE_SIMPLES = "SIMPLES";
    public static final String RETURNTYPE_ENTITY = "ENTITY";
    public static final String RETURNTYPE_ENTITIES = "ENTITIES";
    public static final String RETURNTYPE_OBJECT = "OBJECT";
    public static final String RETURNTYPE_OBJECTS = "OBJECTS";
    public static final String RETURNTYPE_LINKENTITY = "LINKENTITY";
    public static final String RETURNTYPE_LINKENTITIES = "LINKENTITIES";
    public static final String RETURNTYPE_ASYNCACTION = "ASYNCACTION";
    public static final String RETURNTYPE_USER = "USER";
    public static final String RETURNTYPE_USER2 = "USER2";
    public static final String RETURNTYPE_SSE = "SSE";
    public static final int SUBSYSSADEMETHODBINDINGMODE_NOT = 0;
    public static final int SUBSYSSADEMETHODBINDINGMODE_MANUAL = 1;
    public static final int SUBSYSSADEMETHODBINDINGMODE_AUTO = 2;
    public static final int PREPARELASTMODE_DISABLED = 0;
    public static final int PREPARELASTMODE_ENABLED = 1;
    public static final int PREPARELASTMODE_FILLED = 2;

    public void init(ISRFDAGlobalHelper var1, IPSDataEntity var2, PSDEAction var3) throws Exception;

    public int getTimeOut();

    public String getActionType();

    @Override
    public String getCodeName();

    public String getLogicName();

    public boolean isCustomParam();

    public int getParamMode();

    public Iterator<IPSDEActionLogic> getPSDEActionLogics(String var1);

    public Iterator<IPSDEActionLogic> getPSDEActionLogics();

    public Iterator<IPSDEActionParam> getPSDEActionParams();

    public Iterator<IPSDEActionVR> getPSDEActionVRs();

    public Iterator<IPSSysTestCase> getPSSysTestCases() throws Exception;

    public boolean isGenerateTestUnit();

    public boolean isPubServiceDefault();

    public IPSRESTfulAPI getPSRESTfulAPI();

    public IPSDEActionTempl getPSDEActionTempl();

    @Override
    public int getExtendMode();

    public String getActionMode();

    public boolean isBatchAction();

    public boolean isEnableBatchAction();

    public IPSSubSysServiceAPIDEMethod getPSSubSysServiceAPIDEMethod() throws Exception;

    public boolean isEnableBackend();

    public boolean isEnableFront();

    public int getActionHolder();

    public IPSSysPFPlugin getPSSysPFPlugin();

    public IPSSFXCodeObject getRender();

    public String getPSSubSysServiceAPIDEMethodId();

    public boolean isBuiltinAction();

    public boolean isEnableTempData();

    public int getTempDataMode();

    public IPSDEOPPriv getPSDEOPPriv();

    public int getTestActionMode();

    public Iterator<IPSDEActionLogic> getPreparePSDEActionLogics();

    public Iterator<IPSDEActionLogic> getCheckPSDEActionLogics();

    public Iterator<IPSDEActionLogic> getBeforePSDEActionLogics();

    public Iterator<IPSDEActionLogic> getAfterPSDEActionLogics();

    @Override
    public int getOrderValue();

    public boolean isValid();

    public String getTransactionMode();

    public IPSDEAction getInheritPSDEAction() throws Exception;

    public int getBatchActionMode();

    public boolean isEnableAudit();

    public boolean isPrepareLast();

    public int getPrepareLastMode();

    public IPSDEFGroup getInPSDEFGroup();

    public IPSDEFGroup getOutPSDEFGroup();

    public IPSSysDynaModel getInPSSysDynaModel();

    public IPSSysDynaModel getOutPSSysDynaModel();

    public IPSDEActionInput getPSDEActionInput();

    public IPSDEActionReturn getPSDEActionReturn();

    public String getReturnValueType();

    public int getReturnStdDataType();

    public String getBeforeCode();

    public String getAfterCode();

    public int getPOTime();

    public String getActionTag();

    public String getActionTag2();

    public String getActionTag3();

    public String getActionTag4();

    public IPSDataEntity getOutRefPSDataEntity() throws Exception;

    public IPSDEFGroup getOutRefPSDEFGroup() throws Exception;

    public boolean isAsyncAction();

    public IPSDEAction getRealPSDEAction() throws Exception;

    public int getSubSysServiceAPIDEMethodBindingMode();

    public String getServiceCodeName();

    public int getOption();

    public boolean isEnableCache();

    public int getCacheTimeout();

    public IPSSysUniState getPSSysUniState();

    public String getPredefinedType();

    public String getPredefinedTypeParam();

    public Properties getActionParams();

    public int getSyncEvent();

    public String getDataAccessAction();

    public boolean isNeedResourceKey();

    public boolean isNeedResourceKeyDefined();
}

