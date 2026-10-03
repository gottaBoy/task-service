/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.core.IDEActionCaller
 *  net.ibizsys.paas.core.IDataEntity
 *  net.ibizsys.paas.service.ActionSessionManager
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceWorkHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.PropertiesHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.Action;

import SA.SRFDA.PS.Core.DEField.IPSDEFGroup;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionInput;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionLogic;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionParam;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionReturn;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionRuntime;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionTempl;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionVR;
import SA.SRFDA.PS.Core.DataEntity.Action.PSDEActionInputImpl;
import SA.SRFDA.PS.Core.DataEntity.Action.PSDEActionLogicImpl;
import SA.SRFDA.PS.Core.DataEntity.Action.PSDEActionParamImpl;
import SA.SRFDA.PS.Core.DataEntity.Action.PSDEActionReturnImpl;
import SA.SRFDA.PS.Core.DataEntity.Action.PSDEActionVRImpl;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityObjectImpl;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEOPPriv;
import SA.SRFDA.PS.Core.DevTask.IPSDevTask;
import SA.SRFDA.PS.Core.DynaModel.IPSSysDynaModel;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginTempl;
import SA.SRFDA.PS.Core.Res.IPSSysUniState;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Core.SF.PSSFXCodeObjectProxy;
import SA.SRFDA.PS.Core.Service.IPSDEActionRESTfulAPI;
import SA.SRFDA.PS.Core.Service.IPSRESTfulAPI;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDEMethod;
import SA.SRFDA.PS.Core.Service.PSSubSysServiceAPIMethodImpl;
import SA.SRFDA.PS.Core.Testing.IPSDEActionTestCase;
import SA.SRFDA.PS.Core.Testing.IPSSysTestCase;
import SA.SRFDA.PS.Data.PSDEAction;
import SA.SRFDA.PS.Data.PSDEActionLogic;
import SA.SRFDA.PS.Data.PSDEActionParam;
import SA.SRFDA.PS.Data.PSDEActionVR;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Vector;
import net.ibizsys.paas.core.IDEActionCaller;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.service.ActionSessionManager;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceWorkHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.PropertiesHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEActionImplBase
extends PSDataEntityObjectImpl
implements IPSDEAction,
IPSDEActionRESTfulAPI,
IPSDevTask,
IPSDEActionRuntime,
IPSModelSortable {
    private static final Log log = LogFactory.getLog(PSDEActionImplBase.class);
    public static final String ASYNCACTION_PREFIX = "ASYNC_";
    public static final String SSEACTION_PREFIX = "SSE_";
    private static HashMap<String, String> internalServiceActionMap = new HashMap();
    private static HashMap<String, String> internalActionModeMap = new HashMap();
    private static HashMap<String, String> batchActionModeMap = new HashMap();
    private static HashMap<String, Integer> tempDataActionMap = new HashMap();
    private static HashMap<String, Integer> defaultActionOrderValueMap = new HashMap();
    private static HashMap<String, String> getDraftActionModeMap = new HashMap();
    public static final String MODELGROUP_ACTIONLOGIC = "\u884c\u4e3a\u903b\u8f91\u9644\u52a0";
    public static final String MODELGROUP_TEST = "\u6d4b\u8bd5";
    public static final String[] MODELGROUPS;
    public static final int MODELORDER_ACTIONLOGIC = 200;
    public static final int MODELORDER_TEST = 250;
    protected PSDEAction psDEAction = null;
    private String strCallerObject = "";
    private int nTimeOut = -1;
    private String strCodeName = "";
    private HashMap<String, ArrayList<IPSDEActionLogic>> psDEActionLogicMap = new HashMap();
    private ArrayList<IPSDEActionLogic> psDEActionLogicList = new ArrayList();
    private ArrayList<IPSDEActionParam> psDEActionParamList = new ArrayList();
    private ArrayList<IPSDEActionVR> psDEActionVRList = new ArrayList();
    private boolean bGenerateTestUnit = false;
    private boolean bPubFlag = true;
    private String strRequestPath = null;
    private String strRequestMethod = null;
    private String strRequestParamType = null;
    private String strRequestField = null;
    private int nParamMode = 1;
    private boolean bCustomParam = false;
    private IPSDEActionTempl iPSDEActionTempl = null;
    private int nExtendMode = 0;
    private String strToDo = "";
    private int nDevTaskState = 0;
    private String strActionMode = null;
    private IPSSubSysServiceAPIDEMethod iPSSubSysServiceAPIDEMethod = null;
    private int nActionHolder = 3;
    private boolean bCustomActionHolder = false;
    private IPSSysPFPlugin iPSSysPFPlugin = null;
    private IPSSysSFPlugin iPSSysSFPlugin = null;
    private IPSSFXCodeObject iPSSFXCodeObject = null;
    private boolean bBuiltinAction = false;
    private int nTempDataMode = 0;
    private IPSDEOPPriv iPSDEOPPriv = null;
    private int nTestActionMode = 0;
    private int nOrderValue = 99999;
    private boolean bValid = true;
    private String strTransactionMode = "DEFAULT";
    private IPSDEAction inheritPSDEAction = null;
    private int nBatchActionMode = 0;
    private boolean bEnableAudit = false;
    private boolean bPrepareLast = false;
    private int nPrepareLastMode = 0;
    private boolean bCustomPrepareLast = false;
    private IPSDEActionInput iPSDEActionInput = null;
    private IPSDEActionReturn iPSDEActionReturn = null;
    private IPSDEFGroup inPSDEFGroup = null;
    private IPSDEFGroup outPSDEFGroup = null;
    private IPSSysDynaModel inPSSysDynaModel = null;
    private IPSSysDynaModel outPSSysDynaModel = null;
    private int nPOTime = -1;
    private int nSubSysServiceAPIDEMethodBindingMode = 2;
    private boolean bEnableCache = false;
    private String strCacheScope = null;
    private int nCacheTimeout = -1;
    private IPSSysUniState iPSSysUniState = null;
    private Properties actionParams = null;
    private int nSyncEvent = -1;
    private boolean bNeedResourceKey = false;
    private boolean bNeedResourceKeyDefined = false;

    static {
        internalServiceActionMap.put("CREATE", "");
        internalServiceActionMap.put("GET", "");
        internalServiceActionMap.put("UPDATE", "");
        internalServiceActionMap.put("REMOVE", "");
        internalActionModeMap.put("CREATE", "CREATE");
        internalActionModeMap.put("CREATETEMP", "CREATE");
        internalActionModeMap.put("CREATETEMPMAJOR", "CREATE");
        internalActionModeMap.put("GET", "READ");
        internalActionModeMap.put("GETTEMP", "READ");
        internalActionModeMap.put("GETTEMPMAJOR", "READ");
        internalActionModeMap.put("UPDATE", "UPDATE");
        internalActionModeMap.put("UPDATETEMP", "UPDATE");
        internalActionModeMap.put("UPDATETEMPMAJOR", "UPDATE");
        internalActionModeMap.put("REMOVE", "DELETE");
        internalActionModeMap.put("REMOVETEMP", "DELETE");
        internalActionModeMap.put("REMOVETEMPMAJOR", "DELETE");
        internalActionModeMap.put("GETDRAFT", "GETDRAFT");
        internalActionModeMap.put("GETDRAFTFROM", "GETDRAFT");
        internalActionModeMap.put("GETDRAFTTEMP", "GETDRAFT");
        internalActionModeMap.put("GETDRAFTTEMPFROM", "GETDRAFT");
        internalActionModeMap.put("GETDRAFTTEMPMAJOR", "GETDRAFT");
        internalActionModeMap.put("GETDRAFTTEMPMAJORFROM", "GETDRAFT");
        internalActionModeMap.put("CHECKKEY", "CHECKKEY");
        getDraftActionModeMap.put("GETDRAFTFROM", "GETDRAFTFROM");
        getDraftActionModeMap.put("GETDRAFTTEMPFROM", "GETDRAFTFROM");
        getDraftActionModeMap.put("GETDRAFTTEMPMAJORFROM", "GETDRAFTFROM");
        internalActionModeMap.put("CREATEBATCH", "CREATEBATCH");
        internalActionModeMap.put("CREATETEMPBATCH", "CREATEBATCH");
        internalActionModeMap.put("UPDATEBATCH", "UPDATEBATCH");
        internalActionModeMap.put("UPDATETEMPBATCH", "UPDATEBATCH");
        internalActionModeMap.put("REMOVEBATCH", "DELETEBATCH");
        internalActionModeMap.put("REMOVETEMPBATCH", "DELETEBATCH");
        batchActionModeMap.put("CREATEBATCH", "");
        batchActionModeMap.put("CREATEBATCH2", "");
        batchActionModeMap.put("UPDATEBATCH", "");
        batchActionModeMap.put("UPDATEBATCH2", "");
        batchActionModeMap.put("DELETEBATCH", "");
        batchActionModeMap.put("CUSTOMBATCH", "");
        batchActionModeMap.put("CUSTOMBATCH2", "");
        batchActionModeMap.put("DELETE", "");
        tempDataActionMap.put("CREATETEMP", 2);
        tempDataActionMap.put("CREATETEMPMAJOR", 1);
        tempDataActionMap.put("GETTEMP", 2);
        tempDataActionMap.put("GETTEMPMAJOR", 1);
        tempDataActionMap.put("UPDATETEMP", 2);
        tempDataActionMap.put("UPDATETEMPMAJOR", 1);
        tempDataActionMap.put("REMOVETEMP", 2);
        tempDataActionMap.put("REMOVETEMPMAJOR", 1);
        tempDataActionMap.put("GETDRAFTTEMP", 2);
        tempDataActionMap.put("GETDRAFTTEMPFROM", 2);
        tempDataActionMap.put("GETDRAFTTEMPMAJOR", 1);
        tempDataActionMap.put("GETDRAFTTEMPMAJORFROM", 1);
        defaultActionOrderValueMap.put("CREATE", 1);
        defaultActionOrderValueMap.put("CREATETEMP", 2);
        defaultActionOrderValueMap.put("CREATETEMPMAJOR", 3);
        defaultActionOrderValueMap.put("UPDATE", 11);
        defaultActionOrderValueMap.put("UPDATETEMP", 12);
        defaultActionOrderValueMap.put("UPDATETEMPMAJOR", 13);
        defaultActionOrderValueMap.put("REMOVE", 21);
        defaultActionOrderValueMap.put("REMOVETEMP", 22);
        defaultActionOrderValueMap.put("REMOVETEMPMAJOR", 23);
        defaultActionOrderValueMap.put("GET", 31);
        defaultActionOrderValueMap.put("GETTEMP", 32);
        defaultActionOrderValueMap.put("GETTEMPMAJOR", 33);
        defaultActionOrderValueMap.put("GETDRAFT", 41);
        defaultActionOrderValueMap.put("GETDRAFTFROM", 42);
        defaultActionOrderValueMap.put("GETDRAFTTEMP", 43);
        defaultActionOrderValueMap.put("GETDRAFTTEMPFROM", 44);
        defaultActionOrderValueMap.put("GETDRAFTTEMPMAJOR", 45);
        defaultActionOrderValueMap.put("GETDRAFTTEMPMAJORFROM", 46);
        MODELGROUPS = new String[]{"\u57fa\u672c", MODELGROUP_ACTIONLOGIC, MODELGROUP_TEST, "\u7528\u6237\u6269\u5c55", "\u5176\u5b83"};
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDataEntity iPSDataEntity, PSDEAction psDEAction) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSDataEntity(iPSDataEntity);
            this.psDEAction = psDEAction;
            this.setId(this.psDEAction.getPSDEACTIONID());
            this.setName(this.psDEAction.getPSDEACTIONNAME());
            this.setPSObjectData(this.psDEAction);
            if (!this.psDEAction.isCALLTIMEOUTNull() && this.psDEAction.getCALLTIMEOUT() > 0) {
                this.nTimeOut = this.psDEAction.getCALLTIMEOUT();
            }
            this.setCallerObject(this.psDEAction.getCALLEROBJ());
            this.strCodeName = this.psDEAction.getCODENAME();
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strCodeName)) {
                this.strCodeName = this.psDEAction.getPSDEACTIONNAME().toLowerCase();
            }
            if (!(SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strCodeName) || iPSDataEntity != null && iPSDataEntity.getPSSystem().getPSSystemSetting().isFixCodeNameAutoCapitalize())) {
                String strHeader = this.strCodeName.substring(0, 1).toUpperCase();
                this.strCodeName = String.valueOf(strHeader) + this.strCodeName.substring(1);
            }
            if (!this.psDEAction.isTESTACTIONMODENull()) {
                this.nTestActionMode = this.psDEAction.getTESTACTIONMODE();
            }
            String strPSDEActionName = this.getName().toUpperCase();
            if (!this.psDEAction.isORDERVALUENull() && this.psDEAction.getORDERVALUE() >= 0) {
                this.nOrderValue = this.psDEAction.getORDERVALUE();
            } else {
                Integer nValue = defaultActionOrderValueMap.get(strPSDEActionName);
                if (nValue != null) {
                    this.nOrderValue = nValue;
                }
            }
            this.bBuiltinAction = SA.SRFramework.Utility.StringHelper.Compare((String)this.getActionType(), (String)"BUILTIN", (boolean)true) == 0;
            this.strToDo = this.psDEAction.getTODOTASK();
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strToDo)) {
                this.strToDo = this.psDEAction.getPSSYSTASKNAME();
            }
            if (!this.psDEAction.isFINISHFLAGNull()) {
                this.nDevTaskState = this.psDEAction.GetParamIntValue("FINISHFLAG", this.nDevTaskState);
            }
            if (internalServiceActionMap.containsKey(this.getName().toUpperCase())) {
                this.bGenerateTestUnit = true;
                if (!this.psDEAction.isTESTCASEFLAGNull()) {
                    this.bGenerateTestUnit = this.psDEAction.getTESTCASEFLAG();
                }
            }
            this.bPubFlag = !this.psDEAction.isPUBMODENull() ? this.psDEAction.getPUBMODE() : (this.getPSDataEntity().isEnableAPIStorage() ? true : this.getPSDataEntity().getServiceAPIMode() == 1);
            if (!this.psDEAction.isPARAMTYPENull()) {
                this.nParamMode = this.psDEAction.getPARAMTYPE();
                this.bCustomParam = true;
            }
            if (!this.psDEAction.isACTIONHOLDERNull()) {
                this.nActionHolder = this.psDEAction.getACTIONHOLDER();
                this.bCustomActionHolder = true;
            } else {
                this.nActionHolder = this.getPSDataEntity().getDEHolder();
            }
            if (!this.psDEAction.isPREPARELASTNull()) {
                this.nPrepareLastMode = this.psDEAction.getPREPARELAST();
                this.bPrepareLast = this.nPrepareLastMode != 0;
                this.bCustomPrepareLast = true;
            }
            this.strActionMode = this.psDEAction.getACTIONMODE();
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getActionMode())) {
                this.strActionMode = this.onCalcActionMode(strPSDEActionName);
            }
            if (tempDataActionMap.containsKey(strPSDEActionName)) {
                this.nTempDataMode = tempDataActionMap.get(strPSDEActionName);
            }
            if (!this.psDEAction.isVALIDFLAGNull()) {
                this.bValid = this.psDEAction.getVALIDFLAG();
            } else {
                if (!this.getPSDataEntity().isEnableCreate()) {
                    if (this.getActionMode().indexOf("CREATE") == 0) {
                        this.bValid = false;
                        this.logPSModelInfo("info", "isValid", "\u5b9e\u4f53\u9ed8\u8ba4\u7981\u6b62\u5efa\u7acb\u64cd\u4f5c");
                    } else if (this.getActionMode().indexOf("GETDRAFT") == 0) {
                        this.bValid = false;
                        this.logPSModelInfo("info", "isValid", "\u5b9e\u4f53\u9ed8\u8ba4\u7981\u6b62\u5efa\u7acb\u64cd\u4f5c");
                    }
                }
                if (!this.getPSDataEntity().isEnableModify() && this.getActionMode().indexOf("UPDATE") == 0) {
                    this.bValid = false;
                    this.logPSModelInfo("info", "isValid", "\u5b9e\u4f53\u9ed8\u8ba4\u7981\u6b62\u66f4\u65b0\u64cd\u4f5c");
                }
                if (!this.getPSDataEntity().isEnableRemove() && this.getActionMode().indexOf("DELETE") == 0) {
                    this.bValid = false;
                    this.logPSModelInfo("info", "isValid", "\u5b9e\u4f53\u9ed8\u8ba4\u7981\u6b62\u5220\u9664\u64cd\u4f5c");
                }
                if (!(this.getPSDataEntity().isEnableCreate() && this.getPSDataEntity().isEnableModify() || this.getActionMode().indexOf("SAVE") != 0)) {
                    this.bValid = false;
                    this.logPSModelInfo("info", "isValid", "\u5b9e\u4f53\u9ed8\u8ba4\u7981\u6b62\u4fdd\u5b58\u64cd\u4f5c");
                }
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEAction.getPSDEOPPRIVID())) {
                this.iPSDEOPPriv = this.getPSDataEntity().getPSDEOPPriv(this.psDEAction.getPSDEOPPRIVID());
            }
            if (this.getPSDEOPPriv() == null) {
                if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getActionMode(), (String)"CREATE", (boolean)false) == 0 || SA.SRFramework.Utility.StringHelper.Compare((String)this.getActionMode(), (String)"GETDRAFT", (boolean)false) == 0 || SA.SRFramework.Utility.StringHelper.Compare((String)this.getActionMode(), (String)"CREATEBATCH", (boolean)false) == 0 || SA.SRFramework.Utility.StringHelper.Compare((String)this.getActionMode(), (String)"CHECKKEY", (boolean)false) == 0 || SA.SRFramework.Utility.StringHelper.Compare((String)this.getActionMode(), (String)"SAVE", (boolean)false) == 0) {
                    this.iPSDEOPPriv = this.getPSDataEntity().getPSDEOPPriv("CREATE", true);
                } else if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getActionMode(), (String)"UPDATE", (boolean)false) == 0 || SA.SRFramework.Utility.StringHelper.Compare((String)this.getActionMode(), (String)"UPDATEBATCH", (boolean)false) == 0) {
                    this.iPSDEOPPriv = this.getPSDataEntity().getPSDEOPPriv("UPDATE", true);
                } else if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getActionMode(), (String)"DELETE", (boolean)false) == 0 || SA.SRFramework.Utility.StringHelper.Compare((String)this.getActionMode(), (String)"DELETEBATCH", (boolean)false) == 0) {
                    this.iPSDEOPPriv = this.getPSDataEntity().getPSDEOPPriv("DELETE", true);
                } else if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getActionMode(), (String)"READ", (boolean)false) == 0 || SA.SRFramework.Utility.StringHelper.Compare((String)this.getActionMode(), (String)"GETDRAFTFROM", (boolean)false) == 0) {
                    this.iPSDEOPPriv = this.getPSDataEntity().getPSDEOPPriv("READ", true);
                }
            }
            if (this.getPSDataEntity().getPSDERInherit() != null && this.getPSDataEntity().getPSDERInherit().getInheritMode() == 2 && SA.SRFramework.Utility.StringHelper.Compare((String)this.getActionMode(), (String)"READ", (boolean)true) != 0) {
                this.inheritPSDEAction = this.getPSDataEntity().getInheritPSDataEntity().getPSDEAction(this.getName(), true);
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEAction.getTSMODE())) {
                this.strTransactionMode = this.psDEAction.getTSMODE();
            } else {
                this.strTransactionMode = "DEFAULT";
                if (!this.getPSSystemSetting().isEnableDEInheritModelEx() && this.getInheritPSDEAction() != null) {
                    this.strTransactionMode = "GLOBAL";
                }
            }
            if (!this.psDEAction.isEXTENDMODENull()) {
                this.nExtendMode = this.psDEAction.getEXTENDMODE();
            }
            if (!this.psDEAction.isBATCHACTIONMODENull()) {
                this.nBatchActionMode = this.psDEAction.getBATCHACTIONMODE();
            } else if (batchActionModeMap.containsKey(this.getActionMode())) {
                this.nBatchActionMode = 1;
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEAction.getREQUESTPATH())) {
                this.strRequestPath = this.psDEAction.getREQUESTPATH();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEAction.getREQUESTMETHOD())) {
                this.strRequestMethod = this.psDEAction.getREQUESTMETHOD();
            }
            if (!this.psDEAction.isNEEDRESOURCEKEYNull()) {
                this.bNeedResourceKey = this.psDEAction.getNEEDRESOURCEKEY();
                this.bNeedResourceKeyDefined = true;
            }
            this.strRequestParamType = !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEAction.getREQUESTPARAMTYPE()) ? this.psDEAction.getREQUESTPARAMTYPE() : (strPSDEActionName.indexOf("CREATE") != -1 ? "ENTITY" : (strPSDEActionName.indexOf("UPDATE") != -1 ? "ENTITY" : (strPSDEActionName.indexOf("GET") != -1 ? (SA.SRFramework.Utility.StringHelper.Compare((String)strPSDEActionName, (String)"GETDRAFT", (boolean)false) == 0 || SA.SRFramework.Utility.StringHelper.Compare((String)strPSDEActionName, (String)"GETDRAFTTEMP", (boolean)false) == 0 ? "NONE" : "FIELD") : (strPSDEActionName.indexOf("REMOVE") != -1 ? "FIELD" : "ENTITY"))));
            if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getRequestParamType(), (String)"FIELD", (boolean)false) == 0) {
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEAction.getREQUESTFIELD())) {
                    this.strRequestField = this.psDEAction.getREQUESTFIELD();
                } else if (this.getPSDataEntity().getKeyPSDEField() != null) {
                    this.strRequestField = this.getPSDataEntity().getKeyPSDEField().getName();
                }
            }
            if (this.getPSDataEntity().getAuditMode() != 0) {
                if (!this.psDEAction.isENABLEAUDITNull()) {
                    this.bEnableAudit = this.psDEAction.getENABLEAUDIT();
                } else if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getActionMode(), (String)"CREATE", (boolean)true) == 0 || SA.SRFramework.Utility.StringHelper.Compare((String)this.getActionMode(), (String)"UPDATE", (boolean)true) == 0 || SA.SRFramework.Utility.StringHelper.Compare((String)this.getActionMode(), (String)"DELETE", (boolean)true) == 0 || SA.SRFramework.Utility.StringHelper.Compare((String)this.getActionMode(), (String)"CREATEBATCH", (boolean)true) == 0 || SA.SRFramework.Utility.StringHelper.Compare((String)this.getActionMode(), (String)"UPDATEBATCH", (boolean)true) == 0 || SA.SRFramework.Utility.StringHelper.Compare((String)this.getActionMode(), (String)"DELETEBATCH", (boolean)true) == 0 || SA.SRFramework.Utility.StringHelper.Compare((String)this.getActionMode(), (String)"CUSTOM", (boolean)true) == 0) {
                    this.bEnableAudit = true;
                }
            }
            if (!this.psDEAction.isPOTIMENull() && this.psDEAction.getPOTIME() > 0) {
                this.nPOTime = this.psDEAction.getPOTIME();
            }
            if (!this.psDEAction.isSUBSYSSADETAILMODENull()) {
                this.nSubSysServiceAPIDEMethodBindingMode = this.psDEAction.getSUBSYSSADETAILMODE();
            }
            if (this.getSubSysServiceAPIDEMethodBindingMode() == 1 && SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getPSSubSysServiceAPIDEMethodId())) {
                throw new Exception("\u672a\u6307\u5b9a\u5916\u90e8\u63a5\u53e3\u5b9e\u4f53\u65b9\u6cd5");
            }
            if (!this.psDEAction.isENABLECACHENull()) {
                this.bEnableCache = this.psDEAction.getENABLECACHE();
            }
            if (this.isEnableCache()) {
                this.strCacheScope = this.psDEAction.getCACHESCOPE();
                if (!this.psDEAction.isCACHETIMEOUTNull() && this.psDEAction.getCACHETIMEOUT() > 0) {
                    this.nCacheTimeout = this.psDEAction.getCACHETIMEOUT();
                }
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEAction.getPSSYSUNISTATEID())) {
                    this.iPSSysUniState = this.getPSDataEntity().getPSSystem().getPSSysUniState(this.psDEAction.getPSSYSUNISTATEID());
                }
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEAction.getACTIONPARAMS())) {
                this.actionParams = PropertiesHelper.load((String)this.psDEAction.getACTIONPARAMS());
            }
            if (!this.psDEAction.isSYNCEVENTNull()) {
                this.nSyncEvent = this.psDEAction.getSYNCEVENT();
            }
            ServiceWorkHelper.getInstance().execute(new IServiceWork(){

                public void execute(ITransaction iTransaction) throws Exception {
                    if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)PSDEActionImplBase.this.getModelType()) && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)PSDEActionImplBase.this.getId())) {
                        if (!ActionSessionManager.getCurrentSession().registerRecursion(PSDEActionImplBase.this.getModelType(), (Object)PSDEActionImplBase.this.getId())) {
                            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u5b58\u5728\u9012\u5f52\u5f15\u7528"));
                        }
                        try {
                            PSDEActionImplBase.this.onInit();
                            ActionSessionManager.getCurrentSession().unregisterRecursion(PSDEActionImplBase.this.getModelType(), (Object)PSDEActionImplBase.this.getId());
                        }
                        catch (Exception ex) {
                            ActionSessionManager.getCurrentSession().unregisterRecursion(PSDEActionImplBase.this.getModelType(), (Object)PSDEActionImplBase.this.getId());
                            throw ex;
                        }
                    } else {
                        PSDEActionImplBase.this.onInit();
                    }
                }
            });
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEAction.getPSDEACTIONTEMPLID())) {
            this.iPSDEActionTempl = this.getPSDataEntity().getPSSystem().getPSDEActionTempl(this.psDEAction.getPSDEACTIONTEMPLID());
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEAction.getPSSYSPFPLUGINID())) {
            this.iPSSysPFPlugin = this.getPSDataEntity().getPSSystem().getPSSysPFPlugin(this.psDEAction.getPSSYSPFPLUGINID());
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEAction.getPSSYSSFPLUGINID())) {
            this.iPSSysSFPlugin = this.getPSDataEntity().getPSSystem().getPSSysSFPlugin(this.psDEAction.getPSSYSSFPLUGINID());
        }
        if (this.getPSSysSFPlugin() != null) {
            String strPSSysSFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysSFPlugin().getId(), (String)this.getPSSystem().getPSSFId());
            IPSSysSFPluginTempl iPSSysSFPluginTempl = this.getPSSystem().getPSSysSFPluginTempl(strPSSysSFPluginTemplId, true);
            if (iPSSysSFPluginTempl != null) {
                this.iPSSFXCodeObject = new PSSFXCodeObjectProxy(iPSSysSFPluginTempl, this);
            }
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEAction.getINPSDEFGROUPID())) {
            this.inPSDEFGroup = this.getPSDataEntity().getPSDEFGroup(this.psDEAction.getINPSDEFGROUPID());
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEAction.getOUTPSDEFGROUPID())) {
            this.outPSDEFGroup = this.getPSDataEntity().getPSDEFGroup(this.psDEAction.getOUTPSDEFGROUPID());
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEAction.getINPSSYSDYNAMODELID())) {
            this.inPSSysDynaModel = this.getPSDataEntity().getPSSystem().getPSSysDynaModel(this.psDEAction.getINPSSYSDYNAMODELID());
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEAction.getOUTPSSYSDYNAMODELID())) {
            this.outPSSysDynaModel = this.getPSDataEntity().getPSSystem().getPSSysDynaModel(this.psDEAction.getOUTPSSYSDYNAMODELID());
        }
        this.preparePSDEActionLogics();
        this.preparePSDEActionParams();
        this.preparePSDEActionVRs();
        this.iPSDEActionInput = this.createPSDEActionInput();
        this.iPSDEActionReturn = this.createPSDEActionReturn();
    }

    @Override
    protected int onCheck() throws Exception {
        this.getOutRefPSDataEntity();
        this.getOutRefPSDEFGroup();
        int nRet = 0;
        if (this.psDEActionLogicList != null) {
            for (IPSDEActionLogic iPSDEActionLogic : this.psDEActionLogicList) {
                if (!(iPSDEActionLogic instanceof IPSModelObject)) continue;
                nRet += iPSDEActionLogic.check();
            }
        }
        if (this.getPSDEActionInput() != null) {
            nRet += this.getPSDEActionInput().check();
        }
        if (this.getPSDEActionReturn() != null) {
            nRet += this.getPSDEActionReturn().check();
        }
        return nRet + super.onCheck();
    }

    protected void preparePSDEActionLogics() throws Exception {
        if (this.psDEActionLogicList == null) {
            this.psDEActionLogicList = new ArrayList();
        } else {
            this.psDEActionLogicList.clear();
        }
        if (this.psDEActionLogicMap == null) {
            this.psDEActionLogicMap = new HashMap();
        } else {
            this.psDEActionLogicMap.clear();
        }
        Vector<PSDEActionLogic> psDEActionLogicList = new Vector<PSDEActionLogic>();
        CallResult callResult = this.getPSModelHelper().getPSDEActionLogics(this.getId(), psDEActionLogicList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u64cd\u4f5c\u9644\u52a0\u903b\u8f91\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDEActionLogic psDEActionLogic : psDEActionLogicList) {
            if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getPSSystemUtil().getTemplEngineVer(), (String)"V2", (boolean)false) == 0 && !psDEActionLogic.isVALIDFLAGNull() && !psDEActionLogic.getVALIDFLAG()) continue;
            PSDEActionLogicImpl iPSDEActionLogic = new PSDEActionLogicImpl();
            iPSDEActionLogic.init(this.getDAGlobalHelper(), this, psDEActionLogic);
            ArrayList<IPSDEActionLogic> attachList = this.psDEActionLogicMap.get(iPSDEActionLogic.getAttachMode());
            if (attachList == null) {
                attachList = new ArrayList();
                this.psDEActionLogicMap.put(iPSDEActionLogic.getAttachMode(), attachList);
            }
            attachList.add(iPSDEActionLogic);
            this.psDEActionLogicList.add(iPSDEActionLogic);
            if (!iPSDEActionLogic.isValid() || !iPSDEActionLogic.isPrepareLast()) continue;
            this.bPrepareLast = true;
            if (iPSDEActionLogic.getPrepareLastMode() <= this.nPrepareLastMode) continue;
            this.nPrepareLastMode = iPSDEActionLogic.getPrepareLastMode();
        }
        if (this.psDEActionLogicList.size() == 0) {
            this.psDEActionLogicList = null;
        }
        if (this.psDEActionLogicMap.size() == 0) {
            this.psDEActionLogicMap = null;
        }
    }

    protected void preparePSDEActionParams() throws Exception {
        IPSDEActionParam iPSDEActionParam;
        if (this.psDEActionParamList == null) {
            this.psDEActionParamList = new ArrayList();
        } else {
            this.psDEActionParamList.clear();
        }
        if (this.getParamMode() == 0) {
            return;
        }
        Vector<PSDEActionParam> psDEActionParamList = new Vector<PSDEActionParam>();
        CallResult callResult = this.getPSModelHelper().getPSDEActionParams(this.getId(), psDEActionParamList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u884c\u4e3a\u53c2\u6570\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDEActionParam psDEActionParam : psDEActionParamList) {
            iPSDEActionParam = new PSDEActionParamImpl();
            iPSDEActionParam.init(this.getDAGlobalHelper(), this, psDEActionParam);
            this.psDEActionParamList.add((IPSDEActionParam)iPSDEActionParam);
        }
        if (this.getParamMode() == 2) {
            boolean bKeyField = false;
            if (this.getPSSystem().isEnableModelRT()) {
                bKeyField = true;
            }
            if (!bKeyField) {
                for (IPSDEActionParam iPSDEActionParam2 : this.psDEActionParamList) {
                    if (iPSDEActionParam2.getPSDEField() == null || !iPSDEActionParam2.getPSDEField().isKeyDEField() || SA.SRFramework.Utility.StringHelper.Compare((String)this.getActionType(), (String)"USERCUSTOM", (boolean)true) != 0) continue;
                    bKeyField = true;
                    break;
                }
                if (!bKeyField) {
                    PSDEActionParam psDEActionParam = new PSDEActionParam();
                    psDEActionParam.setORDERVALUE(0);
                    psDEActionParam.setPSDEACTIONID(this.getId());
                    psDEActionParam.setPSDEACTIONNAME(this.getName());
                    psDEActionParam.setPSDEACTIONPARAMID(this.getPSDataEntity().getKeyPSDEField().getName());
                    psDEActionParam.setPSDEACTIONPARAMNAME(this.getPSDataEntity().getKeyPSDEField().getName());
                    psDEActionParam.setPARAMDESC(this.getPSDataEntity().getKeyPSDEField().getLogicName());
                    psDEActionParam.setVALUETYPE("INPUTVALUE");
                    iPSDEActionParam = new PSDEActionParamImpl();
                    iPSDEActionParam.init(this.getDAGlobalHelper(), this, psDEActionParam);
                    this.psDEActionParamList.add(0, (IPSDEActionParam)iPSDEActionParam);
                }
            }
        }
        if (this.psDEActionParamList.size() == 0) {
            this.psDEActionParamList = null;
        }
    }

    protected void preparePSDEActionVRs() throws Exception {
        if (this.psDEActionVRList == null) {
            this.psDEActionVRList = new ArrayList();
        } else {
            this.psDEActionVRList.clear();
        }
        Vector<PSDEActionVR> psDEActionVRList = new Vector<PSDEActionVR>();
        CallResult callResult = this.getPSModelHelper().getPSDEActionVRs(this.getId(), psDEActionVRList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u884c\u4e3a\u9644\u52a0\u503c\u89c4\u5219\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDEActionVR psDEActionVR : psDEActionVRList) {
            if (!psDEActionVR.isVALIDFLAGNull() && !psDEActionVR.getVALIDFLAG()) continue;
            PSDEActionVRImpl iPSDEActionVR = new PSDEActionVRImpl();
            iPSDEActionVR.init(this.getDAGlobalHelper(), this, psDEActionVR);
            this.psDEActionVRList.add(iPSDEActionVR);
        }
        if (this.psDEActionVRList.size() == 0) {
            this.psDEActionVRList = null;
        }
    }

    protected IPSDEActionInput createPSDEActionInput() throws Exception {
        PSDEActionInputImpl psDEActionInputImpl = new PSDEActionInputImpl();
        psDEActionInputImpl.init(this.getDAGlobalHelper(), this);
        return psDEActionInputImpl;
    }

    protected IPSDEActionReturn createPSDEActionReturn() throws Exception {
        PSDEActionReturnImpl psDEActionReturnImpl = new PSDEActionReturnImpl();
        psDEActionReturnImpl.init(this.getDAGlobalHelper(), this);
        return psDEActionReturnImpl;
    }

    @Override
    @PSModelRTMeta(description="\u884c\u4e3a\u7c7b\u578b", codelist="DEActionType2", group="\u57fa\u672c", order=125, fields={"ACTIONTYPE"})
    public String getActionType() {
        return this.psDEAction.getACTIONTYPE();
    }

    @Override
    public IDataEntity getDataEntity() {
        return this.getPSDataEntity();
    }

    public IDEActionCaller getDEActionCaller() throws Exception {
        return null;
    }

    public void releaseDEActionCaller(IDEActionCaller iDEActionCaller) {
    }

    public String getCallerObject() {
        return this.strCallerObject;
    }

    protected void setCallerObject(String strCallerObject) {
        this.strCallerObject = strCallerObject;
    }

    @Override
    @PSModelRTMeta(description="\u8c03\u7528\u8d85\u65f6", ignoredumpvalues="-1", fields={"CALLTIMEOUT"})
    public int getTimeOut() {
        return this.nTimeOut;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.onGetCodeName();
    }

    protected String onGetCodeName() {
        return this.strCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u540d\u79f0", fields={"LOGICNAME"})
    public String getLogicName() {
        return this.psDEAction.getLOGICNAME();
    }

    @Override
    public Iterator<IPSDEActionLogic> getPSDEActionLogics(String strAttachMode) {
        if (this.psDEActionLogicMap == null) {
            return null;
        }
        ArrayList<IPSDEActionLogic> attachList = this.psDEActionLogicMap.get(strAttachMode);
        if (attachList == null) {
            return null;
        }
        return attachList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u884c\u4e3a\u9644\u52a0\u903b\u8f91\u96c6\u5408", outputdoc="false")
    public Iterator<IPSDEActionLogic> getPSDEActionLogics() {
        if (this.psDEActionLogicList == null || this.psDEActionLogicList.size() == 0) {
            return null;
        }
        return this.psDEActionLogicList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u884c\u4e3a\u53c2\u6570\u96c6\u5408", child=true, ignorepf=true, group="\u57fa\u672c", order=130)
    public Iterator<IPSDEActionParam> getPSDEActionParams() {
        if (this.psDEActionParamList == null || this.psDEActionParamList.size() == 0) {
            return null;
        }
        return this.psDEActionParamList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u884c\u4e3a\u9644\u52a0\u503c\u89c4\u5219\u96c6\u5408", child=true, ignorepf=true)
    public Iterator<IPSDEActionVR> getPSDEActionVRs() {
        if (this.psDEActionVRList == null || this.psDEActionVRList.size() == 0) {
            return null;
        }
        return this.psDEActionVRList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u4ea7\u751f\u6d4b\u8bd5\u5355\u5143", dump=false)
    public boolean isGenerateTestUnit() {
        return this.bGenerateTestUnit;
    }

    @Override
    public String getRequestPath() {
        return this.strRequestPath;
    }

    @Override
    public String getRequestMethod() {
        return this.strRequestMethod;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u53d1\u5e03\u670d\u52a1", dump=false)
    public boolean isPubServiceDefault() {
        return this.bPubFlag;
    }

    @Override
    public IPSRESTfulAPI getPSRESTfulAPI() {
        return this;
    }

    @Override
    @PSModelRTMeta(description="\u8bf7\u6c42\u53c2\u6570\u7c7b\u578b", dump=false)
    public String getRequestParamType() {
        return this.strRequestParamType;
    }

    @Override
    @PSModelRTMeta(description="\u8bf7\u6c42\u5c5e\u6027", dump=false)
    public String getRequestField() {
        return this.strRequestField;
    }

    @Override
    @PSModelRTMeta(description="\u884c\u4e3a\u53c2\u6570\u6a21\u5f0f", codelist="DEActionParamMode", ignoredumpvalues="1", fields={"PARAMTYPE"})
    public int getParamMode() {
        return this.nParamMode;
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u5b9a\u4e49\u884c\u4e3a\u53c2\u6570", ignoredumpvalues="false", fields={"PARAMTYPE"}, doc="\u662f\u5426\u6709\u8bbe\u7f6e\u884c\u4e3a\u53c2\u6570")
    public boolean isCustomParam() {
        return this.bCustomParam;
    }

    @Override
    @PSModelRTMeta(description="\u884c\u4e3a\u6a21\u677f\u5bf9\u8c61", hideempty=true)
    public IPSDEActionTempl getPSDEActionTempl() {
        return this.iPSDEActionTempl;
    }

    @Override
    public String getModelType() {
        return "PSDEACTION";
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u7cfb\u7edf\u6269\u5c55", codelist="DEExtendMode", ignoredumpvalues="0")
    public int getExtendMode() {
        return this.nExtendMode;
    }

    @Override
    public int getDevTaskState() {
        return this.nDevTaskState;
    }

    @Override
    public String getDevTaskToDo() {
        return this.strToDo;
    }

    @Override
    public String getDevTaskLink() {
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u884c\u4e3a\u6a21\u5f0f", codelist="DEActionMode", group="\u57fa\u672c", order=128, fields={"ACTIONMODE"})
    public String getActionMode() {
        return this.strActionMode;
    }

    @Override
    public String getModelId() {
        return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSDataEntity().getModelId(), (Object)this.getName());
    }

    @Override
    @PSModelRTMeta(description="\u6279\u64cd\u4f5c\u884c\u4e3a", ignoredumpvalues="false", fields={"BATCHACTIONMODE"})
    public boolean isBatchAction() {
        return this.getBatchActionMode() != 0;
    }

    @Override
    public boolean isEnableBatchAction() {
        return this.isBatchAction();
    }

    @Override
    @PSModelRTMeta(description="\u6279\u64cd\u4f5c\u6a21\u5f0f", ignoredumpvalues="0", codelist="DEActionBatchMode")
    public int getBatchActionMode() {
        return this.nBatchActionMode;
    }

    @Override
    @PSModelRTMeta(description="\u5916\u90e8\u670d\u52a1\u63a5\u53e3\u65b9\u6cd5", hideempty=true, dumpref=true, dynamodelmode=4, from="IPSDataEntity", from_method="getPSSubSysServiceAPIDEMust().getPSSubSysServiceAPIDEMethod", fields={"PSSUBSYSSADETAILID"})
    public IPSSubSysServiceAPIDEMethod getPSSubSysServiceAPIDEMethod() throws Exception {
        if (this.getSubSysServiceAPIDEMethodBindingMode() == 0) {
            return null;
        }
        IPSSubSysServiceAPIDEMethod iPSSubSysServiceAPIDEMethod = this.onGetPSSubSysServiceAPIDEMethod();
        if (iPSSubSysServiceAPIDEMethod == PSSubSysServiceAPIMethodImpl.EMPTY) {
            return null;
        }
        return iPSSubSysServiceAPIDEMethod;
    }

    protected IPSSubSysServiceAPIDEMethod onGetPSSubSysServiceAPIDEMethod() throws Exception {
        if (this.iPSSubSysServiceAPIDEMethod != null) {
            if (this.iPSSubSysServiceAPIDEMethod == PSSubSysServiceAPIMethodImpl.EMPTY) {
                return null;
            }
            return this.iPSSubSysServiceAPIDEMethod;
        }
        if (this.getPSDataEntity().getPSSubSysServiceAPIDE() == null) {
            return null;
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEAction.getPSSUBSYSSADETAILID())) {
            this.iPSSubSysServiceAPIDEMethod = this.getPSDataEntity().getPSSubSysServiceAPIDE().getPSSubSysServiceAPIDEMethod(this.psDEAction.getPSSUBSYSSADETAILID(), false);
        } else {
            Iterator<? extends IPSSubSysServiceAPIDEMethod> psSubSysSADEMethods = this.getPSDataEntity().getPSSubSysServiceAPIDE().getPSSubSysServiceAPIDEMethods();
            if (psSubSysSADEMethods != null) {
                while (psSubSysSADEMethods.hasNext()) {
                    IPSSubSysServiceAPIDEMethod iPSSubSysServiceAPIDEMethod = psSubSysSADEMethods.next();
                    if (SA.SRFramework.Utility.StringHelper.Compare((String)iPSSubSysServiceAPIDEMethod.getMethodType(), (String)"DEACTION", (boolean)true) != 0 || SA.SRFramework.Utility.StringHelper.Compare((String)iPSSubSysServiceAPIDEMethod.getCodeName(), (String)this.getCodeName(), (boolean)true) != 0) continue;
                    this.iPSSubSysServiceAPIDEMethod = iPSSubSysServiceAPIDEMethod;
                    break;
                }
            }
        }
        if (this.iPSSubSysServiceAPIDEMethod == null) {
            this.iPSSubSysServiceAPIDEMethod = PSSubSysServiceAPIMethodImpl.EMPTY;
            return null;
        }
        return this.iPSSubSysServiceAPIDEMethod;
    }

    @Override
    @PSModelRTMeta(description="\u884c\u4e3a\u6301\u6709\u8005", codelist="DELogicHolder", ignoredumpvalues="3", dynamodelmode=4, fields={"ACTIONHOLDER"})
    public int getActionHolder() {
        if (!this.isCustomActionHolder() && this.isEnableTempData()) {
            return this.getPSDataEntity().getTempDataHolder();
        }
        return this.nActionHolder;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u540e\u53f0\u6267\u884c", ignoredumpvalues="true", dynamodelmode=4, doc="\u53c2\u8003 {@link #getActionHolder}")
    public boolean isEnableBackend() {
        return (this.getActionHolder() & 1) == 1;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u524d\u53f0\u6267\u884c", ignoredumpvalues="true", dynamodelmode=4, doc="\u53c2\u8003 {@link #getActionHolder}")
    public boolean isEnableFront() {
        return (this.getActionHolder() & 2) == 2;
    }

    protected boolean isCustomActionHolder() {
        return this.bCustomActionHolder;
    }

    protected boolean isCustomPrepareLast() {
        return this.bCustomPrepareLast;
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u6269\u5c55\u63d2\u4ef6", hideempty=true)
    public IPSSysPFPlugin getPSSysPFPlugin() {
        return this.iPSSysPFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u6269\u5c55\u63d2\u4ef6", hideempty=true)
    public IPSSysSFPlugin getPSSysSFPlugin() {
        return this.iPSSysSFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u6269\u5c55\u7ed8\u5236\u5668", hideempty=true)
    public IPSSFXCodeObject getRender() {
        return this.iPSSFXCodeObject;
    }

    @Override
    public String getPSSubSysServiceAPIDEMethodId() {
        return this.psDEAction.getPSSUBSYSSADETAILID();
    }

    @Override
    @PSModelRTMeta(description="\u9884\u7f6e\u884c\u4e3a", ignoredumpvalues="false")
    public boolean isBuiltinAction() {
        return this.bBuiltinAction;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u4e34\u65f6\u6570\u636e", ignoredumpvalues="false")
    public boolean isEnableTempData() {
        return this.getTempDataMode() != 0;
    }

    @Override
    @PSModelRTMeta(description="\u4e34\u65f6\u6570\u636e\u6a21\u5f0f", codelist="TempDataMode", ignoredumpvalues="0")
    public int getTempDataMode() {
        return this.nTempDataMode;
    }

    @Override
    public void setPSSubSysServiceAPIDEMethod(IPSSubSysServiceAPIDEMethod iPSSubSysServiceAPIDEMethod) throws Exception {
        this.iPSSubSysServiceAPIDEMethod = iPSSubSysServiceAPIDEMethod;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u8bbf\u95ee\u64cd\u4f5c\u6807\u8bc6", dump=false)
    public IPSDEOPPriv getPSDEOPPriv() {
        return this.iPSDEOPPriv;
    }

    @Override
    @PSModelRTMeta(description="\u6d4b\u8bd5\u884c\u4e3a\u6a21\u5f0f", codelist="DEActionTestActionMode", ignoredumpvalues="0", fields={"TESTACTIONMODE"})
    public int getTestActionMode() {
        return this.nTestActionMode;
    }

    public IPSDEAction getPSDEAction() {
        return this;
    }

    @Override
    @PSModelRTMeta(description="\u51c6\u5907\u9644\u52a0\u903b\u8f91\u96c6\u5408", modeltype="SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionLogic", child=true, group="\u884c\u4e3a\u903b\u8f91\u9644\u52a0", order=220)
    public Iterator<IPSDEActionLogic> getPreparePSDEActionLogics() {
        return this.getPSDEActionLogics("PREPARE");
    }

    @Override
    @PSModelRTMeta(description="\u68c0\u67e5\u9644\u52a0\u903b\u8f91\u96c6\u5408", modeltype="SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionLogic", child=true, group="\u884c\u4e3a\u903b\u8f91\u9644\u52a0", order=222)
    public Iterator<IPSDEActionLogic> getCheckPSDEActionLogics() {
        return this.getPSDEActionLogics("CHECK");
    }

    @Override
    @PSModelRTMeta(description="\u6267\u884c\u524d\u9644\u52a0\u903b\u8f91\u96c6\u5408", modeltype="SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionLogic", child=true, group="\u884c\u4e3a\u903b\u8f91\u9644\u52a0", order=224)
    public Iterator<IPSDEActionLogic> getBeforePSDEActionLogics() {
        return this.getPSDEActionLogics("BEFORE");
    }

    @Override
    @PSModelRTMeta(description="\u6267\u884c\u540e\u9644\u52a0\u903b\u8f91\u96c6\u5408", modeltype="SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionLogic", child=true, group="\u884c\u4e3a\u903b\u8f91\u9644\u52a0", order=226)
    public Iterator<IPSDEActionLogic> getAfterPSDEActionLogics() {
        return this.getPSDEActionLogics("AFTER");
    }

    @Override
    public void registerPSDEActionLogic(IPSDEActionLogic iPSDEActionLogic) throws Exception {
        ArrayList<IPSDEActionLogic> attachList;
        if (this.psDEActionLogicList == null) {
            this.psDEActionLogicList = new ArrayList();
        }
        if (this.psDEActionLogicMap == null) {
            this.psDEActionLogicMap = new HashMap();
        }
        if ((attachList = this.psDEActionLogicMap.get(iPSDEActionLogic.getAttachMode())) == null) {
            attachList = new ArrayList();
            this.psDEActionLogicMap.put(iPSDEActionLogic.getAttachMode(), attachList);
        }
        attachList.add(iPSDEActionLogic);
        this.psDEActionLogicList.add(iPSDEActionLogic);
    }

    @Override
    @PSModelRTMeta(description="\u884c\u4e3a\u6b21\u5e8f", ignoredumpvalues="99999")
    public int getOrderValue() {
        return this.nOrderValue;
    }

    protected String onCalcActionMode(String strPSDEActionName) throws Exception {
        String strActionMode;
        if (this.getPSSystemSetting().isEnableDEGetDraftActionModelEx() && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)(strActionMode = getDraftActionModeMap.get(strPSDEActionName)))) {
            return strActionMode;
        }
        strActionMode = internalActionModeMap.get(strPSDEActionName);
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strActionMode) && this.getPSSystemSetting().isEnableDESaveActionModelEx() && "SAVE".equalsIgnoreCase(strPSDEActionName)) {
            return "SAVE";
        }
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strActionMode)) {
            strActionMode = "UNKNOWN";
            int nMaxLength = 0;
            for (Map.Entry<String, String> entry : internalActionModeMap.entrySet()) {
                if (strPSDEActionName.indexOf(entry.getKey()) != 0 || entry.getKey().length() <= nMaxLength) continue;
                nMaxLength = entry.getKey().length();
                strActionMode = entry.getValue();
            }
        }
        return strActionMode;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528", ignoredumpvalues="true")
    public boolean isValid() {
        return this.bValid;
    }

    @Override
    @PSModelRTMeta(description="\u4e8b\u52a1\u6a21\u5f0f", ignoredumpvalues="DEFAULT", codelist="DEActionTSMode", ignorepf=true, fields={"TSMODE"})
    public String getTransactionMode() {
        return this.strTransactionMode;
    }

    @Override
    @PSModelRTMeta(description="\u7ee7\u627f\u884c\u4e3a", hideempty=true)
    public IPSDEAction getInheritPSDEAction() throws Exception {
        return this.inheritPSDEAction;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u8bbf\u95ee\u5ba1\u8ba1", ignoredumpvalues="false", ignorepf=true, fields={"ENABLEAUDIT"})
    public boolean isEnableAudit() {
        return this.bEnableAudit;
    }

    @Override
    @PSModelRTMeta(description="\u51c6\u5907\u64cd\u4f5c\u4e4b\u524d\u6570\u636e", ignoredumpvalues="false", ignorepf=true, doc="\u7531\u884c\u4e3a\u7684\u9644\u52a0\u903b\u8f91\u51b3\u5b9a{@link IPSDEActionLogic#isPrepareLast}\uff08\u5b58\u5728\u9700\u8981\u51c6\u5907\u64cd\u4f5c\u4e4b\u524d\u6570\u636e\uff09")
    public boolean isPrepareLast() {
        return this.onGetPrepareLast();
    }

    protected boolean onGetPrepareLast() {
        return this.bPrepareLast;
    }

    @Override
    @PSModelRTMeta(description="\u51c6\u5907\u64cd\u4f5c\u4e4b\u524d\u6570\u636e\u6a21\u5f0f", ignoredumpvalues="0", codelist="DEActionPrepareLastMode", ignorepf=true, fields={"PREPARELAST"}, doc="\u7531\u884c\u4e3a\u7684\u9644\u52a0\u903b\u8f91\u51b3\u5b9a{@link IPSDEActionLogic#isPrepareLast}\uff08\u5b58\u5728\u9700\u8981\u51c6\u5907\u64cd\u4f5c\u4e4b\u524d\u6570\u636e\uff09")
    public int getPrepareLastMode() {
        return this.onGetPrepareLastMode();
    }

    protected int onGetPrepareLastMode() {
        return this.nPrepareLastMode;
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u5165\u5c5e\u6027\u7ec4\u5bf9\u8c61", hideempty=true, dump=false)
    public IPSDEFGroup getInPSDEFGroup() {
        return this.inPSDEFGroup;
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u51fa\u5c5e\u6027\u7ec4\u5bf9\u8c61", hideempty=true, dump=false)
    public IPSDEFGroup getOutPSDEFGroup() {
        return this.outPSDEFGroup;
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u5165\u52a8\u6001\u5bf9\u8c61\u6a21\u578b", hideempty=true, dump=false)
    public IPSSysDynaModel getInPSSysDynaModel() {
        return this.inPSSysDynaModel;
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u51fa\u52a8\u6001\u5bf9\u8c61\u6a21\u578b", hideempty=true, dump=false)
    public IPSSysDynaModel getOutPSSysDynaModel() {
        return this.outPSSysDynaModel;
    }

    @Override
    @PSModelRTMeta(description="\u8c03\u7528\u8f93\u5165\u5bf9\u8c61", child=true, ignorepf=true, doctype="item", group="\u57fa\u672c", order=135)
    public IPSDEActionInput getPSDEActionInput() {
        return this.iPSDEActionInput;
    }

    @Override
    @PSModelRTMeta(description="\u8c03\u7528\u8fd4\u56de\u5bf9\u8c61", child=true, ignorepf=true, doctype="item", group="\u57fa\u672c", order=136)
    public IPSDEActionReturn getPSDEActionReturn() {
        return this.iPSDEActionReturn;
    }

    @Override
    public String getReturnValueType() {
        return this.psDEAction.getRETVALTYPE();
    }

    @Override
    public int getReturnStdDataType() {
        if (this.psDEAction.isRETSTDDATATYPENull()) {
            return 0;
        }
        return this.psDEAction.getRETSTDDATATYPE();
    }

    @Override
    protected String onGetMOSFileName() {
        return this.getName();
    }

    @Override
    @PSModelRTMeta(description="\u6d4b\u8bd5\u7528\u4f8b\u96c6\u5408", child=true, dumpref=true, ignorert=3, dynamodelmode=8, group="\u6d4b\u8bd5", order=275)
    public Iterator<IPSSysTestCase> getPSSysTestCases() throws Exception {
        Iterator<IPSSysTestCase> psSysTestCases = this.getPSSystem().getAllPSSysTestCases();
        if (psSysTestCases == null) {
            return null;
        }
        ArrayList<IPSSysTestCase> psSysTestCaseList = new ArrayList<IPSSysTestCase>();
        while (psSysTestCases.hasNext()) {
            IPSDEActionTestCase iPSDEActionTestCase;
            IPSSysTestCase iPSSysTestCase = psSysTestCases.next();
            if (!(iPSSysTestCase instanceof IPSDEActionTestCase) || (iPSDEActionTestCase = (IPSDEActionTestCase)iPSSysTestCase).getPSDEAction() == null || SA.SRFramework.Utility.StringHelper.Compare((String)iPSDEActionTestCase.getPSDEAction().getId(), (String)this.getId(), (boolean)false) != 0) continue;
            psSysTestCaseList.add(iPSSysTestCase);
        }
        if (psSysTestCaseList.size() == 0) {
            return null;
        }
        return psSysTestCaseList.iterator();
    }

    @Override
    public String getBeforeCode() {
        return this.psDEAction.getBEFORECODE();
    }

    @Override
    public String getAfterCode() {
        return this.psDEAction.getAFTERCODE();
    }

    @Override
    @PSModelRTMeta(description="\u6027\u80fd\u4f18\u5316\u9884\u8b66\u65f6\u957f\uff08ms\uff09", ignorepf=true, ignoredumpvalues="-1", fields={"POTIME"})
    public int getPOTime() {
        return this.nPOTime;
    }

    @Override
    @PSModelRTMeta(description="\u884c\u4e3a\u6807\u8bb0", fields={"ACTIONTAG"})
    public String getActionTag() {
        return this.psDEAction.getACTIONTAG();
    }

    @Override
    @PSModelRTMeta(description="\u884c\u4e3a\u6807\u8bb02", fields={"ACTIONTAG2"})
    public String getActionTag2() {
        return this.psDEAction.getACTIONTAG2();
    }

    @Override
    @PSModelRTMeta(description="\u884c\u4e3a\u6807\u8bb03", fields={"ACTIONTAG3"})
    public String getActionTag3() {
        return this.psDEAction.getACTIONTAG3();
    }

    @Override
    @PSModelRTMeta(description="\u884c\u4e3a\u6807\u8bb04", fields={"ACTIONTAG4"})
    public String getActionTag4() {
        return this.psDEAction.getACTIONTAG4();
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u51fa\u5f15\u7528\u5b9e\u4f53\u5bf9\u8c61", fields={"OUTREFPSDEID"})
    public IPSDataEntity getOutRefPSDataEntity() throws Exception {
        if ("LINKENTITY".equalsIgnoreCase(this.getReturnValueType()) || "LINKENTITIES".equalsIgnoreCase(this.getReturnValueType())) {
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEAction.getOUTREFPSDEID())) {
                throw new Exception(String.format("\u672a\u6307\u5b9a\u8f93\u51fa\u5f15\u7528\u5b9e\u4f53\u5bf9\u8c61", new Object[0]));
            }
            return this.getPSSystem().getPSDataEntity2(this.psDEAction.getOUTREFPSDEID());
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u51fa\u5f15\u7528\u5b9e\u4f53\u5c5e\u6027\u7ec4\u5bf9\u8c61", fields={"OUTREFPSDEFGROUPID"})
    public IPSDEFGroup getOutRefPSDEFGroup() throws Exception {
        if ("LINKENTITY".equalsIgnoreCase(this.getReturnValueType()) || "LINKENTITIES".equalsIgnoreCase(this.getReturnValueType())) {
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEAction.getOUTREFPSDEFGROUPID())) {
                return null;
            }
            return this.getOutRefPSDataEntity().getPSDEFGroup(this.psDEAction.getOUTREFPSDEFGROUPID());
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5f02\u6b65\u64cd\u4f5c\u884c\u4e3a", ignoredumpvalues="false")
    public boolean isAsyncAction() {
        if ("ASYNCACTION".equals(this.getReturnValueType())) {
            return true;
        }
        return "SSE".equals(this.getReturnValueType());
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u9645\u6267\u884c\u884c\u4e3a", dumpref=true, from="IPSDataEntity", ignorepf=true)
    public IPSDEAction getRealPSDEAction() throws Exception {
        if (this.isAsyncAction()) {
            if (this.getName().toUpperCase().indexOf(ASYNCACTION_PREFIX) == 0) {
                return this.getPSDataEntity().getPSDEAction(this.getName().substring(ASYNCACTION_PREFIX.length()), true);
            }
            if (this.getName().toUpperCase().indexOf(SSEACTION_PREFIX) == 0) {
                return this.getPSDataEntity().getPSDEAction(this.getName().substring(SSEACTION_PREFIX.length()), true);
            }
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5916\u90e8\u63a5\u53e3\u5b9e\u4f53\u65b9\u6cd5\u7ed1\u5b9a\u6a21\u5f0f", codelist="SubSysSADEMethodBindingMode", dump=false)
    public int getSubSysServiceAPIDEMethodBindingMode() {
        return this.nSubSysServiceAPIDEMethodBindingMode;
    }

    @Override
    @PSModelRTMeta(description="\u670d\u52a1\u4ee3\u7801\u6807\u8bc6", dump=false)
    public String getServiceCodeName() {
        return this.onGetServiceCodeName();
    }

    protected String onGetServiceCodeName() {
        String strServiceCodeName = this.psDEAction.getSERVICECODENAME();
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strServiceCodeName)) {
            return this.getPSDataEntity().getAPICodeName(null, this.getCodeName(), null);
        }
        return strServiceCodeName;
    }

    @Override
    public int getOption() {
        return 0;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u7f13\u5b58", ignoredumpvalues="false", ignorepf=true, fields={"ENABLECACHE"})
    public boolean isEnableCache() {
        return this.bEnableCache;
    }

    @Override
    @PSModelRTMeta(description="\u7f13\u5b58\u8d85\u65f6", ignoredumpvalues="-1", ignorepf=true, fields={"CACHETIMEOUT"})
    public int getCacheTimeout() {
        return this.nCacheTimeout;
    }

    @Override
    @PSModelRTMeta(description="\u7f13\u5b58\u7edf\u4e00\u72b6\u6001\u5bf9\u8c61", hideempty2=true, dumpref=true, ignorepf=true, fields={"PSSYSUNISTATEID"})
    public IPSSysUniState getPSSysUniState() {
        return this.iPSSysUniState;
    }

    @Override
    @PSModelRTMeta(description="\u9884\u5b9a\u4e49\u7c7b\u578b", hideempty2=true, ignorepf=true, fields={"PREDEFINEDTYPE"})
    public String getPredefinedType() {
        return this.psDEAction.getPREDEFINEDTYPE();
    }

    @Override
    @PSModelRTMeta(description="\u9884\u5b9a\u4e49\u7c7b\u578b\u53c2\u6570", hideempty2=true, ignorepf=true, fields={"PREDEFINEDTYPEPARAM"})
    public String getPredefinedTypeParam() {
        return this.psDEAction.getPREDEFINEDTYPEPARAM();
    }

    @Override
    @PSModelRTMeta(description="\u884c\u4e3a\u52a8\u6001\u53c2\u6570", hideempty2=true, ignorepf=true, fields={"ACTIONPARAMS"})
    public Properties getActionParams() {
        return this.actionParams;
    }

    @Override
    @PSModelRTMeta(description="\u540c\u6b65\u4e8b\u4ef6", codelist="DEActionSyncEvent", ignoredumpvalues="-1", ignorepf=true, fields={"SYNCEVENT"})
    public int getSyncEvent() {
        return this.nSyncEvent;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u8bbf\u95ee\u6807\u8bc6", hideempty2=true, ignorepf=true)
    public String getDataAccessAction() {
        if (this.getPSDEOPPriv() == null) {
            return null;
        }
        return this.getPSDEOPPriv().getName();
    }

    @Override
    @PSModelRTMeta(description="\u8bf7\u6c42\u9700\u8981\u72ec\u7acb\u8d44\u6e90\u952e\u503c", ignoredumpvalues="false", dump=false)
    public boolean isNeedResourceKey() {
        return this.bNeedResourceKey;
    }

    @Override
    @PSModelRTMeta(description="\u5b9a\u4e49\u8bf7\u6c42\u9700\u8981\u72ec\u7acb\u8d44\u6e90\u952e\u503c", ignoredumpvalues="false", dump=false)
    public boolean isNeedResourceKeyDefined() {
        return this.bNeedResourceKeyDefined;
    }
}
