/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.core.IDEDataQuery
 *  net.ibizsys.paas.core.IDEDataSetGroupParam
 *  net.ibizsys.paas.core.IDEDataSetQuery
 *  net.ibizsys.paas.core.IDataEntity
 *  net.ibizsys.paas.db.IDBFunction
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.PropertiesHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.util.Assert
 */
package SA.SRFDA.PS.Core.DataEntity.DS;

import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.DEField.IPSDEFGroup;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERAggData;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERAggDataDEFieldMap;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQCondition;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQuery;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSetCode;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSetGroupParam;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSetInput;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSetParam;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSetReturn;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSetRuntime;
import SA.SRFDA.PS.Core.DataEntity.DS.PSDEDataSetCodeGlobalModel;
import SA.SRFDA.PS.Core.DataEntity.DS.PSDEDataSetGroupParamImpl;
import SA.SRFDA.PS.Core.DataEntity.DS.PSDEDataSetInputImpl;
import SA.SRFDA.PS.Core.DataEntity.DS.PSDEDataSetParamImpl;
import SA.SRFDA.PS.Core.DataEntity.DS.PSDEDataSetReturnImpl;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityObjectImpl;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEOPPriv;
import SA.SRFDA.PS.Core.Database.IPSDBType;
import SA.SRFDA.PS.Core.Database.IPSDEFDTColumn;
import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginTempl;
import SA.SRFDA.PS.Core.Res.IPSSysUniState;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Core.SF.PSSFXCodeObjectProxy;
import SA.SRFDA.PS.Core.Security.IPSSysUserDR;
import SA.SRFDA.PS.Core.Service.IPSRESTfulAPI;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDEMethod;
import SA.SRFDA.PS.Core.Service.PSSubSysServiceAPIMethodImpl;
import SA.SRFDA.PS.Core.Util.PSModelCodeNameUtils;
import SA.SRFDA.PS.Data.PSDEDSDQ;
import SA.SRFDA.PS.Data.PSDEDSGroupParam;
import SA.SRFDA.PS.Data.PSDEDSParam;
import SA.SRFDA.PS.Data.PSDEDataSet;
import SA.SRFDA.PS.Data.PSDEDataSetCode;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;
import java.util.Vector;
import net.ibizsys.paas.core.IDEDataQuery;
import net.ibizsys.paas.core.IDEDataSetGroupParam;
import net.ibizsys.paas.core.IDEDataSetQuery;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.db.IDBFunction;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.PropertiesHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.Assert;

@PSModelPFIgnoreMeta
public class PSDEDataSetImpl
extends PSDataEntityObjectImpl
implements IPSDEDataSet,
IPSRESTfulAPI,
IPSDEDataSetRuntime,
IPSModelSortable {
    private static final Log log = LogFactory.getLog(PSDEDataSetImpl.class);
    protected PSDEDataSet psDEDataSet = null;
    protected ArrayList<IPSDEDataQuery> psDEDataQueryList = new ArrayList();
    protected ArrayList<IDEDataQuery> deDataQueryList = new ArrayList();
    protected ArrayList<IPSDEDataSetGroupParam> psDEDSGroupParamList = new ArrayList();
    protected ArrayList<IDEDataSetGroupParam> deDSGroupParamList = new ArrayList();
    protected Map<String, IPSDEDataSetGroupParam> psDEDSGroupParamMap = new LinkedHashMap<String, IPSDEDataSetGroupParam>();
    private Map<String, List<IPSDEDataSetGroupParam>> psDEDSGroupParamListMap = null;
    protected ArrayList<IPSDEDataSetParam> psDEDSParamList = new ArrayList();
    protected PSDEDataSetCodeGlobalModel psDEDataSetCodeGlobalModel = new PSDEDataSetCodeGlobalModel();
    protected IDEHelper psDEDSCodeHelper = null;
    protected boolean bDefaultMode = false;
    protected String strCodeName = "";
    private boolean bEnableGroup = false;
    private int nGroupTopCount = -1;
    private IPSCodeList iPSCodeList = null;
    private int nExtendMode = 0;
    private String strLogicName = null;
    private boolean bEnableOrgDR = false;
    private boolean bEnableSecDR = false;
    private boolean bEnableSecBC = false;
    private long nOrgDR = 0L;
    private long nSecDR = 0L;
    private String strSecBC = "";
    private boolean bEnableUserDR = false;
    private String strUserDRAction = "READ";
    private String strCustomDRModeParam = "";
    private String strCustomDRMode2Param = "";
    private IPSSysUserDR iPSSysUserDR = null;
    private IPSSysUserDR iPSSysUserDR2 = null;
    private boolean bEnableCache = false;
    private String strCacheScope = null;
    private int nCacheTimeout = -1;
    private IPSDEField majorSortPSDEField = null;
    private IPSDEField minorSortPSDEField = null;
    private String strMajorSortDir = null;
    private String strMinorSortDir = null;
    private int nPageSize = -1;
    private IPSSysUniState iPSSysUniState = null;
    private IPSDELogic cacheStatePSDELogic = null;
    private String strCacheHookState = null;
    private boolean bPubFlag = true;
    private String strRequestPath = null;
    private IPSDELogic activeDataPSDELogic = null;
    private String strRequestMethod = null;
    private boolean bEnableTempData = false;
    private ArrayList<IPSDEDQCondition> adPSDEDQConditionList = null;
    private IPSSubSysServiceAPIDEMethod iPSSubSysServiceAPIDEMethod = null;
    private int nActionHolder = 3;
    private boolean bCustomActionHolder = false;
    private IPSSysPFPlugin iPSSysPFPlugin = null;
    private IPSSysSFPlugin iPSSysSFPlugin = null;
    private IPSSFXCodeObject iPSSFXCodeObject = null;
    private IPSDEOPPriv iPSDEOPPriv = null;
    private int nOrderValue = 99999;
    private boolean bValid = true;
    private boolean bEnableAudit = false;
    private IPSDEDataSetInput iPSDEDataSetInput = null;
    private IPSDEDataSetReturn iPSDEDataSetReturn = null;
    private IPSDEFGroup iPSDEFGroup = null;
    private int nGroupMode = 0;
    private IPSDERAggData iPSDERAggData = null;
    private IPSDELogic iPSDELogic = null;
    private int nPOTime = -1;
    private int nViewLevel = -1;
    private int nParamMode = 1;
    private boolean bCustomParam = false;
    private IPSDEFGroup inPSDEFGroup = null;
    private int nSubSysServiceAPIDEMethodBindingMode = 2;
    private Properties dataSetParams = null;
    private int nMaxRowCount = -1;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDataEntity majorPSDataEntity, PSDEDataSet psDEDataSet) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSDataEntity(majorPSDataEntity);
            this.psDEDataSet = psDEDataSet;
            this.setId(this.psDEDataSet.getPSDEDATASETID());
            this.setName(this.psDEDataSet.getPSDEDATASETNAME());
            this.setPSObjectData(this.psDEDataSet);
            this.psDEDataSetCodeGlobalModel.Init(iDAGlobalHelper, this);
            this.psDEDSCodeHelper = this.getDAGlobalHelper().getDAModelStorage().FindDEHelper2("DE2062");
            if (!this.psDEDataSet.isDEFAULTMODENull()) {
                this.bDefaultMode = this.psDEDataSet.getDEFAULTMODE();
            }
            this.strCodeName = this.psDEDataSet.getCODENAME();
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strCodeName)) {
                this.strCodeName = this.psDEDataSet.getPSDEDATASETNAME().toLowerCase();
            }
            if (!(SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strCodeName) || majorPSDataEntity != null && majorPSDataEntity.getPSSystem().getPSSystemSetting().isFixCodeNameAutoCapitalize())) {
                String strHeader = this.strCodeName.substring(0, 1).toUpperCase();
                this.strCodeName = String.valueOf(strHeader) + this.strCodeName.substring(1);
            }
            if (!this.psDEDataSet.isENABLEGROUPNull()) {
                this.bEnableGroup = this.psDEDataSet.getENABLEGROUP() != 0;
                this.nGroupMode = this.psDEDataSet.getENABLEGROUP();
            }
            if (this.getGroupMode() == 2 && SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataSet.getAGGDATAPSDERID())) {
                throw new Exception("\u672a\u6307\u5b9a\u805a\u5408\u6570\u636e\u5173\u7cfb");
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDEDataSet.getPSCODELISTID())) {
                this.iPSCodeList = this.getPSDataEntity().getPSSystem().getPSCodeList(psDEDataSet.getPSCODELISTID());
            } else if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getPredefinedType())) {
                if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getPredefinedType(), (String)"INDEXDE", (boolean)false) == 0) {
                    if (this.getPSDataEntity().getIndexTypePSDEField() != null) {
                        this.iPSCodeList = this.getPSDataEntity().getIndexTypePSDEField().getPSCodeList();
                    }
                } else if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getPredefinedType(), (String)"MULTIFORM", (boolean)false) == 0 && this.getPSDataEntity().getFormTypePSDEField() != null) {
                    this.iPSCodeList = this.getPSDataEntity().getFormTypePSDEField().getPSCodeList();
                }
            }
            if (!this.psDEDataSet.isVALIDFLAGNull()) {
                this.bValid = this.psDEDataSet.getVALIDFLAG();
            }
            if (!this.psDEDataSet.isMAXROWCNTNull()) {
                this.nMaxRowCount = this.psDEDataSet.getMAXROWCNT();
                if (this.nMaxRowCount <= 0) {
                    this.nMaxRowCount = -1;
                }
            } else {
                this.nMaxRowCount = this.getPSSystemSetting().getDEDataSetMaxRowCount();
            }
            if (!this.psDEDataSet.isEXTENDMODENull()) {
                this.nExtendMode = this.psDEDataSet.getEXTENDMODE();
            }
            if (!this.psDEDataSet.isACTIONHOLDERNull()) {
                this.nActionHolder = this.psDEDataSet.getACTIONHOLDER();
                this.bCustomActionHolder = true;
            } else {
                this.nActionHolder = this.getPSDataEntity().getDEHolder();
            }
            if (!this.psDEDataSet.isPARAMTYPENull()) {
                this.nParamMode = this.psDEDataSet.getPARAMTYPE();
                this.bCustomParam = true;
            }
            this.strLogicName = this.psDEDataSet.getLOGICNAME();
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strLogicName)) {
                this.strLogicName = this.getName();
            }
            this.bPubFlag = !this.psDEDataSet.isPUBMODENull() ? this.psDEDataSet.getPUBMODE() : (this.getPSDataEntity().isEnableAPIStorage() ? true : this.getPSDataEntity().getServiceAPIMode() == 1);
            if (!this.psDEDataSet.isORDERVALUENull() && this.psDEDataSet.getORDERVALUE() >= 0) {
                this.nOrderValue = this.psDEDataSet.getORDERVALUE();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataSet.getREQUESTPATH())) {
                this.strRequestPath = this.psDEDataSet.getREQUESTPATH();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataSet.getREQUESTMETHOD())) {
                this.strRequestMethod = this.psDEDataSet.getREQUESTMETHOD();
            }
            if (this.getPSDataEntity().isEnableTempData()) {
                this.bEnableTempData = true;
                if (!this.psDEDataSet.isENABLETEMPDATANull()) {
                    this.bEnableTempData = this.psDEDataSet.getENABLETEMPDATA();
                }
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataSet.getPSDEOPPRIVID())) {
                this.iPSDEOPPriv = this.getPSDataEntity().getPSDEOPPriv(this.psDEDataSet.getPSDEOPPRIVID());
            }
            if (this.getPSDEOPPriv() == null) {
                this.iPSDEOPPriv = this.getPSDataEntity().getPSDEOPPriv("READ", true);
            }
            if (this.getPSDataEntity().getAuditMode() != 0 && !this.psDEDataSet.isENABLEAUDITNull()) {
                this.bEnableAudit = this.psDEDataSet.getENABLEAUDIT();
            }
            if (!this.psDEDataSet.isPOTIMENull() && this.psDEDataSet.getPOTIME() > 0) {
                this.nPOTime = this.psDEDataSet.getPOTIME();
            }
            if (!this.psDEDataSet.isSUBSYSSADETAILMODENull()) {
                this.nSubSysServiceAPIDEMethodBindingMode = this.psDEDataSet.getSUBSYSSADETAILMODE();
            }
            if (this.getSubSysServiceAPIDEMethodBindingMode() == 1 && SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getPSSubSysServiceAPIDEMethodId())) {
                throw new Exception("\u672a\u6307\u5b9a\u5916\u90e8\u63a5\u53e3\u5b9e\u4f53\u65b9\u6cd5");
            }
            if (!this.psDEDataSet.isVIEWCOLLEVELNull()) {
                this.nViewLevel = this.psDEDataSet.getVIEWCOLLEVEL();
                if (this.nViewLevel == 100) {
                    if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataSet.getOUTPSDEFGROUPID())) {
                        throw new Exception("\u672a\u6307\u5b9a\u8f93\u51fa\u7684\u5c5e\u6027\u7ec4");
                    }
                    this.iPSDEFGroup = this.getPSDataEntity().getPSDEFGroup(this.psDEDataSet.getOUTPSDEFGROUPID());
                }
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataSet.getDATASETPARAMS())) {
                this.dataSetParams = PropertiesHelper.load((String)this.psDEDataSet.getDATASETPARAMS());
            }
            this.onInit();
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
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataSet.getPSSYSPFPLUGINID())) {
            this.iPSSysPFPlugin = this.getPSDataEntity().getPSSystem().getPSSysPFPlugin(this.psDEDataSet.getPSSYSPFPLUGINID());
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataSet.getPSSYSSFPLUGINID())) {
            this.iPSSysSFPlugin = this.getPSDataEntity().getPSSystem().getPSSysSFPlugin(this.psDEDataSet.getPSSYSSFPLUGINID());
        }
        if (this.getPSSysSFPlugin() != null) {
            String strPSSysSFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysSFPlugin().getId(), (String)this.getPSSystem().getPSSFId());
            IPSSysSFPluginTempl iPSSysSFPluginTempl = this.getPSSystem().getPSSysSFPluginTempl(strPSSysSFPluginTemplId, true);
            if (iPSSysSFPluginTempl != null) {
                this.iPSSFXCodeObject = new PSSFXCodeObjectProxy(iPSSysSFPluginTempl, this);
            }
        }
        if (!this.psDEDataSet.isENABLEORGDRNull()) {
            this.bEnableOrgDR = this.psDEDataSet.getENABLEORGDR();
            if (this.bEnableOrgDR) {
                this.nOrgDR = this.psDEDataSet.getORGDR();
            }
        }
        if (!this.psDEDataSet.isENABLESECDRNull()) {
            this.bEnableSecDR = this.psDEDataSet.getENABLESECDR();
            if (this.bEnableSecDR) {
                this.nSecDR = this.psDEDataSet.getSECDR();
            }
        }
        if (!this.psDEDataSet.isENABLESECBCNull()) {
            this.bEnableSecBC = this.psDEDataSet.getENABLESECBC();
            if (this.bEnableSecBC) {
                this.strSecBC = this.psDEDataSet.getSECBC();
            }
        }
        if (!this.psDEDataSet.isENABLEUSERDRNull()) {
            this.bEnableUserDR = this.psDEDataSet.getENABLEUSERDR();
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataSet.getPSSYSUSERDRID())) {
            this.iPSSysUserDR = this.getPSDataEntity().getPSSystem().getPSSysUserDR(this.psDEDataSet.getPSSYSUSERDRID());
            this.strCustomDRModeParam = this.psDEDataSet.getSYSUSERDRPARAM();
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataSet.getPSSYSUSERDRID2())) {
            this.iPSSysUserDR2 = this.getPSDataEntity().getPSSystem().getPSSysUserDR(this.psDEDataSet.getPSSYSUSERDRID2());
            this.strCustomDRMode2Param = this.psDEDataSet.getSYSUSERDR2PARAM();
        }
        if (!this.psDEDataSet.isENABLECACHENull()) {
            this.bEnableCache = this.psDEDataSet.getENABLECACHE();
        }
        if (this.isEnableCache()) {
            this.strCacheScope = this.psDEDataSet.getCACHESCOPE();
            if (!this.psDEDataSet.isCACHETIMEOUTNull() && this.psDEDataSet.getCACHETIMEOUT() > 0) {
                this.nCacheTimeout = this.psDEDataSet.getCACHETIMEOUT();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataSet.getPSSYSUNISTATEID())) {
                this.iPSSysUniState = this.getPSDataEntity().getPSSystem().getPSSysUniState(this.psDEDataSet.getPSSYSUNISTATEID());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataSet.getCACHESTATEPSDELOGICID())) {
                this.cacheStatePSDELogic = this.getPSDataEntity().getPSDELogic(this.psDEDataSet.getCACHESTATEPSDELOGICID());
            }
            this.strCacheHookState = this.psDEDataSet.getCACHECHECKSTATE();
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataSet.getMAJORPSDEFID())) {
            this.majorSortPSDEField = this.getPSDataEntity().getPSDEField(this.psDEDataSet.getMAJORPSDEFID());
            this.strMajorSortDir = this.psDEDataSet.getMAJORSORTDIR();
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataSet.getMINORPSDEFID())) {
            this.minorSortPSDEField = this.getPSDataEntity().getPSDEField(this.psDEDataSet.getMINORPSDEFID());
            this.strMinorSortDir = this.psDEDataSet.getMINORSORTDIR();
        }
        if (!this.psDEDataSet.isPAGESIZENull()) {
            this.nPageSize = this.psDEDataSet.getPAGESIZE();
            if (this.nPageSize <= 0) {
                this.nPageSize = -1;
            }
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataSet.getADPSDELOGICID())) {
            this.activeDataPSDELogic = this.getPSDataEntity().getPSDELogic(this.psDEDataSet.getADPSDELOGICID());
        }
        if (this.getGroupMode() == 2 && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataSet.getAGGDATAPSDERID())) {
            IPSDERBase iPSDERBase = this.getPSDataEntity().getPSSystem().getPSDER(this.psDEDataSet.getAGGDATAPSDERID());
            if (iPSDERBase instanceof IPSDERAggData) {
                this.iPSDERAggData = (IPSDERAggData)iPSDERBase;
            } else {
                throw new Exception(String.format("\u5173\u7cfb[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e\uff0c\u5fc5\u987b\u4e3a[\u805a\u5408\u6570\u636e\u5173\u7cfb]", iPSDERBase.getName()));
            }
        }
        this.onPreparePSDEDSDQs();
        this.deDataQueryList.clear();
        this.deDataQueryList.addAll(this.psDEDataQueryList);
        this.onPreparePSDEDSGroupParams();
        this.deDSGroupParamList.clear();
        this.deDSGroupParamList.addAll(this.psDEDSGroupParamList);
        this.onPreparePSDEDSParams();
        if (this.getParamMode() != 2 && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataSet.getINPSDEFGROUPID())) {
            this.inPSDEFGroup = this.getPSDataEntity().getPSDEFGroup(this.psDEDataSet.getINPSDEFGROUPID());
        }
        this.iPSDEDataSetInput = this.createPSDEDataSetInput();
        this.iPSDEDataSetReturn = this.createPSDEDataSetReturn();
    }

    @Override
    protected int onCheck() throws Exception {
        IPSDELogic iPSDELogic;
        if (this.createPSDEDataSetInput() != null) {
            this.createPSDEDataSetInput().check();
        }
        if (this.getPSDEDataSetReturn() != null) {
            this.getPSDEDataSetReturn().check();
        }
        if ((iPSDELogic = this.getPSDELogic()) != null && iPSDELogic.getDefaultPSDELogicParam() != null && !iPSDELogic.getDefaultPSDELogicParam().isFilterParam()) {
            throw new Exception(String.format("\u7ed1\u5b9a\u7684\u5b9e\u4f53\u5904\u7406\u903b\u8f91\u9ed8\u8ba4\u53c2\u6570\u4e0d\u662f\u8fc7\u6ee4\u5668\u7c7b\u578b", new Object[0]));
        }
        return super.onCheck();
    }

    protected void onPreparePSDEDSDQs() throws Exception {
        this.psDEDataQueryList.clear();
        Vector<PSDEDSDQ> psDEDSDQList = new Vector<PSDEDSDQ>();
        CallResult callResult = this.getPSModelHelper().getPSDEDSDQs(this.getId(), psDEDSDQList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u6570\u636e\u67e5\u8be2\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        int nADCount = 0;
        IPSDEDataQuery lastPSDEDataQuery = null;
        for (PSDEDSDQ psDEDSDQ : psDEDSDQList) {
            IPSDEDataQuery iPSDEDataQuery = this.getPSDataEntity().getPSDEDataQuery(psDEDSDQ.getPSDEDQID());
            if (lastPSDEDataQuery == null) {
                lastPSDEDataQuery = iPSDEDataQuery;
            } else {
                if (iPSDEDataQuery.getViewLevel() != lastPSDEDataQuery.getViewLevel()) {
                    throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u5b9e\u4f53\u6570\u636e\u67e5\u8be2[%1$s]\u4e0e[%2$s]\u9009\u62e9\u5217\u7ea7\u522b\u4e0d\u4e00\u81f4", (Object)iPSDEDataQuery.getModelName(), (Object)lastPSDEDataQuery.getModelName()));
                }
                if (iPSDEDataQuery.getViewLevel() == 100 && SA.SRFramework.Utility.StringHelper.Compare((String)iPSDEDataQuery.getPSDEFGroup().getId(), (String)lastPSDEDataQuery.getPSDEFGroup().getId(), (boolean)false) != 0) {
                    throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u5b9e\u4f53\u6570\u636e\u67e5\u8be2[%1$s]\u4e0e[%2$s]\u9009\u62e9\u5217\u6307\u5b9a\u7684\u5c5e\u6027\u7ec4\u4e0d\u4e00\u81f4", (Object)iPSDEDataQuery.getModelName(), (Object)lastPSDEDataQuery.getModelName()));
                }
            }
            this.psDEDataQueryList.add(iPSDEDataQuery);
            if (iPSDEDataQuery.getADPSDEDQConditions() == null) continue;
            ++nADCount;
        }
        if (nADCount > 1) {
            this.adPSDEDQConditionList = new ArrayList();
            for (IPSDEDataQuery iPSDEDataQuery : this.psDEDataQueryList) {
                Iterator<IPSDEDQCondition> psDEDQConditions = iPSDEDataQuery.getADPSDEDQConditions();
                if (psDEDQConditions == null) continue;
                while (psDEDQConditions.hasNext()) {
                    this.adPSDEDQConditionList.add(psDEDQConditions.next());
                }
            }
        }
        if (lastPSDEDataQuery != null) {
            if (this.psDEDataSet.isVIEWCOLLEVELNull()) {
                this.nViewLevel = lastPSDEDataQuery.getViewLevel();
                if (lastPSDEDataQuery.getViewLevel() == 100 && SA.SRFramework.Utility.StringHelper.Compare((String)lastPSDEDataQuery.getPSDataEntity().getId(), (String)this.getPSDataEntity().getId(), (boolean)false) == 0) {
                    this.iPSDEFGroup = lastPSDEDataQuery.getPSDEFGroup();
                }
            }
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getMemo())) {
                this.setMemo(lastPSDEDataQuery.getMemo());
            }
        }
    }

    protected void onPreparePSDEDSGroupParams() throws Exception {
        this.psDEDSGroupParamList.clear();
        if (!this.isEnableGroup()) {
            return;
        }
        Vector<PSDEDSGroupParam> psDEDSGroupParamList = new Vector<PSDEDSGroupParam>();
        CallResult callResult = this.getPSModelHelper().getPSDEDSGroupParams(this.getId(), psDEDSGroupParamList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u5206\u7ec4\u53c2\u6570\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDEDSGroupParam psDEDSGroupParam : psDEDSGroupParamList) {
            PSDEDataSetGroupParamImpl iPSDEDSGroupParam = new PSDEDataSetGroupParamImpl();
            iPSDEDSGroupParam.init(this.getDAGlobalHelper(), this, psDEDSGroupParam);
            this.psDEDSGroupParamList.add(iPSDEDSGroupParam);
            this.psDEDSGroupParamMap.put(iPSDEDSGroupParam.getName().toLowerCase(), iPSDEDSGroupParam);
        }
    }

    protected void onPreparePSDEDSParams() throws Exception {
        this.psDEDSParamList.clear();
        if (!this.isCustomParam()) {
            return;
        }
        Vector<PSDEDSParam> psDEDSParamList = new Vector<PSDEDSParam>();
        CallResult callResult = this.getPSModelHelper().getPSDEDSParams(this.getId(), psDEDSParamList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u53c2\u6570\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDEDSParam psDEDSParam : psDEDSParamList) {
            PSDEDataSetParamImpl iPSDEDSParam = new PSDEDataSetParamImpl();
            iPSDEDSParam.init(this.getDAGlobalHelper(), this, psDEDSParam);
            this.psDEDSParamList.add(iPSDEDSParam);
        }
    }

    protected IPSDEDataSetInput createPSDEDataSetInput() throws Exception {
        PSDEDataSetInputImpl psDEDataSetInputImpl = new PSDEDataSetInputImpl();
        psDEDataSetInputImpl.init(this.getDAGlobalHelper(), this);
        return psDEDataSetInputImpl;
    }

    protected IPSDEDataSetReturn createPSDEDataSetReturn() throws Exception {
        PSDEDataSetReturnImpl psDEDataSetReturnImpl = new PSDEDataSetReturnImpl();
        psDEDataSetReturnImpl.init(this.getDAGlobalHelper(), this);
        return psDEDataSetReturnImpl;
    }

    @Override
    public IPSDEDataSetCode getPSDEDataSetCode(String strDBType) throws Exception {
        PSDEDataSetCode psDEDataSetCode = new PSDEDataSetCode();
        psDEDataSetCode.setPSDEDATASETID(this.getId());
        psDEDataSetCode.setDBTYPE(strDBType);
        String objObjectId = (String)this.psDEDSCodeHelper.getKeyValue((BaseDataEntity)psDEDataSetCode);
        return (IPSDEDataSetCode)this.psDEDataSetCodeGlobalModel.FindModelHelper(objObjectId);
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u96c6\u67e5\u8be2\u96c6\u5408", hideempty2=true, dumpref=true, rtdump=3, dynamodelmode=4, from="IPSDataEntity", child=true, ignorepf=true)
    public Iterator<IPSDEDataQuery> getPSDEDataQueries() {
        if (this.psDEDataQueryList.size() == 0) {
            return null;
        }
        return this.psDEDataQueryList.iterator();
    }

    @Override
    public IDataEntity getDataEntity() {
        return this.getPSDataEntity();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u9ed8\u8ba4\u6570\u636e\u96c6", ignoredumpvalues="false", fields={"DEFAULTMODE"})
    public boolean isDefaultMode() {
        return this.bDefaultMode;
    }

    public Iterator<IDEDataQuery> getDEDataQueries() throws Exception {
        return this.deDataQueryList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.onGetCodeName();
    }

    protected String onGetCodeName() {
        return this.strCodeName;
    }

    public Iterator<IDEDataSetQuery> getDEDataSetQueries() {
        return null;
    }

    @Override
    @Deprecated
    public String getPredefineType() {
        return this.psDEDataSet.getPREDEFINETYPE();
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u5206\u7ec4", ignoredumpvalues="false", fields={"ENABLEGROUP"}, doc="\u5206\u7ec4\u6a21\u5f0f\u8bbf\u95ee{@link #getGroupMode}")
    public boolean isEnableGroup() {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getPredefinedType())) {
            return this.bEnableGroup;
        }
        return false;
    }

    public Iterator<IDEDataSetGroupParam> getDEDataSetGroupParams() {
        return this.deDSGroupParamList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u96c6\u5206\u7ec4\u53c2\u6570\u96c6\u5408", hideempty2=true, child=true, dynamodelmode=4)
    public Iterator<IPSDEDataSetGroupParam> getPSDEDataSetGroupParams() {
        return this.psDEDSGroupParamList.iterator();
    }

    @Override
    public Iterator<IPSDEDataSetGroupParam> getPSDEDataSetGroupParamsByDBType(String strDBType) throws Exception {
        if (this.getGroupMode() == 2) {
            List<IPSDEDataSetGroupParam> list;
            Assert.notNull((Object)this.getPSDERAggData(), (String)"\u805a\u5408\u6570\u636e\u5173\u7cfb\u65e0\u6548");
            IPSDBType iPSDBType = this.getPSModelStorage().getPSDBType(strDBType, true);
            if (iPSDBType == null) {
                throw new Exception(String.format("\u4e0d\u652f\u6301\u7684\u6570\u636e\u5e93\u7c7b\u578b[%1$s]", strDBType));
            }
            if (this.psDEDSGroupParamListMap == null) {
                this.psDEDSGroupParamListMap = new LinkedHashMap<String, List<IPSDEDataSetGroupParam>>();
            }
            if ((list = this.psDEDSGroupParamListMap.get(strDBType)) != null) {
                return list.iterator();
            }
            TreeMap<String, PSDEDSGroupParam> psDEDSGroupParamMap = new TreeMap<String, PSDEDSGroupParam>();
            Vector<PSDEDSGroupParam> psDEDSGroupParamList2 = new Vector<PSDEDSGroupParam>();
            Iterator<IPSDERAggDataDEFieldMap> psDERAggDataDEFieldMaps = this.getPSDERAggData().getPSDERAggDataDEFieldMaps();
            if (psDERAggDataDEFieldMaps != null) {
                while (psDERAggDataDEFieldMaps.hasNext()) {
                    IPSDEField majorPSDEField;
                    IPSDERAggDataDEFieldMap iPSDERAggDataDEFieldMap = psDERAggDataDEFieldMaps.next();
                    if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)iPSDERAggDataDEFieldMap.getMapType()) || psDEDSGroupParamMap.containsKey((majorPSDEField = iPSDERAggDataDEFieldMap.getMajorPSDEField()).getName())) continue;
                    IPSDEField minorPSDEField = iPSDERAggDataDEFieldMap.getMinorPSDEField();
                    IPSDEFDTColumn minorPSDEFDTColumn = null;
                    if (minorPSDEField != null && (minorPSDEFDTColumn = minorPSDEField.getPSDEFDTColumn(strDBType)) == null) {
                        throw new Exception(String.format("\u5c5e\u6027[%1$s]\u6570\u636e\u5e93[%2$s]\u5217\u65e0\u6548", minorPSDEField.getName(), strDBType));
                    }
                    PSDEDSGroupParam psDEDSGroupParam = new PSDEDSGroupParam();
                    psDEDSGroupParam.setPSDEDSGRPPARAMID(iPSDERAggDataDEFieldMap.getId());
                    psDEDSGroupParam.setPSDEDSGRPPARAMNAME(iPSDBType.getDBObjStandardName(majorPSDEField.getName()));
                    psDEDSGroupParam.setPSDEFID(majorPSDEField.getId());
                    psDEDSGroupParam.setPSDEFNAME(majorPSDEField.getName());
                    psDEDSGroupParam.setSTDDATATYPE(majorPSDEField.getStdDataType());
                    if (iPSDERAggDataDEFieldMap.getMapType().indexOf("GROUPBY") == 0) {
                        if (minorPSDEField == null || minorPSDEFDTColumn == null) {
                            throw new Exception(String.format("\u805a\u5408\u6570\u636e\u5173\u7cfb\u5c5e\u6027\u6620\u5c04[%1$s]\u672a\u6307\u5b9a\u4ece\u5b9e\u4f53\u5c5e\u6027", iPSDERAggDataDEFieldMap.getName()));
                        }
                        psDEDSGroupParam.setGROUPFLAG(true);
                        if (SA.SRFramework.Utility.StringHelper.Compare((String)iPSDERAggDataDEFieldMap.getMapType(), (String)"GROUPBY", (boolean)false) == 0) {
                            psDEDSGroupParam.setGROUPCODE(minorPSDEFDTColumn.getStandardColumnName());
                        } else {
                            String strGroupMode = iPSDERAggDataDEFieldMap.getMapType().substring(8);
                            IDBFunction iDBFuntion = iPSDBType.getDBFunction(strGroupMode);
                            psDEDSGroupParam.setGROUPCODE(iDBFuntion.getFuncSQL(true, new String[]{minorPSDEFDTColumn.getStandardColumnName()}));
                            psDEDSGroupParam.setAGGMODE(strGroupMode);
                        }
                    } else {
                        psDEDSGroupParam.setGROUPFLAG(false);
                        IDBFunction iDBFuntion = iPSDBType.getDBFunction(iPSDERAggDataDEFieldMap.getMapType());
                        if (minorPSDEFDTColumn != null) {
                            psDEDSGroupParam.setGROUPCODE(iDBFuntion.getFuncSQL(true, new String[]{minorPSDEFDTColumn.getStandardColumnName()}));
                        } else {
                            psDEDSGroupParam.setGROUPCODE(iDBFuntion.getFuncSQL(true, null));
                        }
                    }
                    psDEDSGroupParam.set("AUTOMODEL", 1);
                    psDEDSGroupParamMap.put(majorPSDEField.getName(), psDEDSGroupParam);
                    psDEDSGroupParamList2.add(psDEDSGroupParam);
                }
            }
            Vector<PSDEDSGroupParam> psDEDSGroupParamList = new Vector<PSDEDSGroupParam>();
            for (PSDEDSGroupParam psDEDSGroupParam : psDEDSGroupParamList2) {
                if (psDEDSGroupParam.getGROUPFLAG()) continue;
                psDEDSGroupParamList.add(psDEDSGroupParam);
            }
            for (PSDEDSGroupParam psDEDSGroupParam : psDEDSGroupParamList2) {
                if (!psDEDSGroupParam.getGROUPFLAG()) continue;
                psDEDSGroupParamList.add(psDEDSGroupParam);
            }
            list = new ArrayList<IPSDEDataSetGroupParam>();
            for (PSDEDSGroupParam psDEDSGroupParam : psDEDSGroupParamList) {
                PSDEDataSetGroupParamImpl iPSDEDSGroupParam = new PSDEDataSetGroupParamImpl();
                iPSDEDSGroupParam.init(this.getDAGlobalHelper(), this, psDEDSGroupParam);
                list.add(iPSDEDSGroupParam);
            }
            this.psDEDSGroupParamListMap.put(strDBType, list);
            return list.iterator();
        }
        return this.psDEDSGroupParamList.iterator();
    }

    @Override
    public IPSDEDataSetGroupParam getPSDEDataSetGroupParam(String strName, boolean bTry) throws Exception {
        IPSDEDataSetGroupParam iPSDEDataSetGroupParam = this.psDEDSGroupParamMap.get(strName = strName.toLowerCase());
        if (iPSDEDataSetGroupParam == null && !bTry) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e\u96c6\u5408\u5206\u7ec4\u53c2\u6570\uff0c\u6807\u8bc6\u4e3a[%1$s]", (Object)strName));
        }
        return iPSDEDataSetGroupParam;
    }

    @Override
    public int getGroupTopCount() {
        return -1;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u8868\u5bf9\u8c61", hideempty=true, dumpref=true, fields={"PSCODELISTID"})
    public IPSCodeList getPSCodeList() {
        return this.iPSCodeList;
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u7cfb\u7edf\u6269\u5c55", codelist="DEExtendMode", ignoredumpvalues="0")
    public int getExtendMode() {
        return this.nExtendMode;
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u540d\u79f0", fields={"LOGICNAME"})
    public String getLogicName() {
        return this.strLogicName;
    }

    @Override
    public String getModelType() {
        return "PSDEDATASET";
    }

    public void init(IDataEntity iDataEntity) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u673a\u6784\u6570\u636e\u8303\u56f4", ignoredumpvalues="false")
    public boolean isEnableOrgDR() {
        return this.bEnableOrgDR;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u90e8\u95e8\u6570\u636e\u8303\u56f4", ignoredumpvalues="false")
    public boolean isEnableSecDR() {
        return this.bEnableSecDR;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u90e8\u95e8\u4e1a\u52a1\u6761\u7ebf", ignoredumpvalues="false")
    public boolean isEnableSecBC() {
        return this.bEnableSecBC;
    }

    @Override
    @PSModelRTMeta(description="\u673a\u6784\u6570\u636e\u8303\u56f4", codelist="ACHOrgDR", ignoredumpvalues="0")
    public long getOrgDR() {
        return this.nOrgDR;
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u95e8\u6570\u636e\u8303\u56f4", codelist="ACHSecDR", ignoredumpvalues="0")
    public long getSecDR() {
        return this.nSecDR;
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u95e8\u4e1a\u52a1\u6761\u4ef6")
    public String getSecBC() {
        return this.strSecBC;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u7528\u6237\u6570\u636e\u8303\u56f4", ignoredumpvalues="false")
    public boolean isEnableUserDR() {
        return this.bEnableUserDR;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u8bbf\u95ee\u64cd\u4f5c\u6807\u8bc6", dump=false)
    public String getUserDRAction() {
        return this.strUserDRAction;
    }

    @Override
    public String getCustomDRMode() {
        if (this.getPSSysUserDR() != null) {
            return this.getPSSysUserDR().getCustomMode();
        }
        return null;
    }

    @Override
    public String getCustomDRMode2() {
        if (this.getPSSysUserDR2() != null) {
            return this.getPSSysUserDR2().getCustomMode();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u5b9a\u4e49\u6570\u636e\u8303\u56f4\u53c2\u6570")
    public String getCustomDRModeParam() {
        return this.strCustomDRModeParam;
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u5b9a\u4e49\u6570\u636e\u8303\u56f42\u53c2\u6570")
    public String getCustomDRMode2Param() {
        return this.strCustomDRMode2Param;
    }

    @Override
    @PSModelRTMeta(description="\u7528\u6237\u6570\u636e\u8303\u56f4\u5bf9\u8c61", dumpref=true)
    public IPSSysUserDR getPSSysUserDR() {
        return this.iPSSysUserDR;
    }

    @Override
    @PSModelRTMeta(description="\u7528\u6237\u6570\u636e\u8303\u56f4\u5bf9\u8c612", dumpref=true)
    public IPSSysUserDR getPSSysUserDR2() {
        return this.iPSSysUserDR2;
    }

    @Override
    @PSModelRTMeta(description="\u9884\u5b9a\u4e49\u7c7b\u578b", codelist="DEDSPDT", hideempty2=true, fields={"PREDEFINEDTYPE"})
    public String getPredefinedType() {
        return this.getPredefineType();
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u7f13\u5b58", ignorepf=true, ignoredumpvalues="false")
    public boolean isEnableCache() {
        return this.bEnableCache;
    }

    @PSModelRTMeta(description="\u7f13\u5b58\u8303\u56f4", ignorepf=true, codelist="DEDSCacheScope")
    public String getCacheScope() {
        return this.strCacheScope;
    }

    @Override
    @PSModelRTMeta(description="\u7f13\u5b58\u8d85\u65f6", ignorepf=true, ignoredumpvalues="-1")
    public int getCacheTimeout() {
        return this.nCacheTimeout;
    }

    public String getMajorSortField() {
        if (this.getMajorSortPSDEField() != null) {
            return this.getMajorSortPSDEField().getName();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u4e3b\u6392\u5e8f\u65b9\u5411", codelist="SortDir", fields={"MAJORSORTDIR"})
    public String getMajorSortDir() {
        return this.strMajorSortDir;
    }

    public String getMinorSortField() {
        if (this.getMinorSortPSDEField() != null) {
            return this.getMinorSortPSDEField().getName();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u4ece\u6392\u5e8f\u65b9\u5411", codelist="SortDir", fields={"MINORSORTDIR"})
    public String getMinorSortDir() {
        return this.strMinorSortDir;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u5206\u9875\u5927\u5c0f", ignoredumpvalues="-1", fields={"PAGESIZE"})
    public int getPageSize() {
        return this.nPageSize;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u4e3b\u6392\u5e8f\u5c5e\u6027", dumpref=true, from="IPSDataEntity", fields={"MAJORPSDEFID"})
    public IPSDEField getMajorSortPSDEField() {
        return this.majorSortPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u4ece\u6392\u5e8f\u5c5e\u6027", dumpref=true, from="IPSDataEntity", fields={"MINORPSDEFID"})
    public IPSDEField getMinorSortPSDEField() {
        return this.minorSortPSDEField;
    }

    public String getCacheUniStateId() {
        if (this.getPSSysUniState() != null) {
            return this.getPSSysUniState().getId();
        }
        return null;
    }

    public String getCacheUniStateDELogicId() {
        if (this.getCacheStatePSDELogic() != null) {
            return this.getCacheStatePSDELogic().getId();
        }
        return null;
    }

    public String getCacheHookState() {
        return this.strCacheHookState;
    }

    @Override
    @PSModelRTMeta(description="\u7f13\u5b58\u7edf\u4e00\u72b6\u6001\u5bf9\u8c61", hideempty2=true, dumpref=true, ignorepf=true, fields={"PSSYSUNISTATEID"})
    public IPSSysUniState getPSSysUniState() {
        return this.iPSSysUniState;
    }

    @Override
    public IPSDELogic getCacheStatePSDELogic() {
        return this.cacheStatePSDELogic;
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
    public String getRequestPath() {
        return this.strRequestPath;
    }

    @Override
    public String getRequestMethod() {
        return this.strRequestMethod;
    }

    @Override
    @PSModelRTMeta(description="\u5f53\u524d\u6570\u636e\u8f6c\u6362\u903b\u8f91", hideempty=true, ignorepf=true, dumpref=true, from="IPSDataEntity")
    public IPSDELogic getActiveDataPSDELogic() {
        return this.activeDataPSDELogic;
    }

    public String getActiveDataDELogicId() {
        if (this.getActiveDataPSDELogic() != null) {
            return this.getActiveDataPSDELogic().getId();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u4e34\u65f6\u6570\u636e", ignoredumpvalues="false")
    public boolean isEnableTempData() {
        return this.bEnableTempData;
    }

    @Override
    @PSModelRTMeta(description="\u4e0a\u4e0b\u6587\u6570\u636e\u6761\u4ef6", outputdoc="false")
    public Iterator<IPSDEDQCondition> getADPSDEDQConditions() {
        if (this.adPSDEDQConditionList != null && this.adPSDEDQConditionList.size() > 0) {
            return this.adPSDEDQConditionList.iterator();
        }
        for (IPSDEDataQuery iPSDEDataQuery : this.psDEDataQueryList) {
            Iterator<IPSDEDQCondition> adPSDEDQConditions = iPSDEDataQuery.getADPSDEDQConditions();
            if (adPSDEDQConditions == null) continue;
            return adPSDEDQConditions;
        }
        return null;
    }

    @Override
    public String getModelId() {
        return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSDataEntity().getModelId(), (Object)this.getCodeName());
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u7cfb\u7edf\u5b9e\u4f53\u63a5\u53e3\u65b9\u6cd5", hideempty=true, dumpref=true, dynamodelmode=4, from="IPSDataEntity", from_method="getPSSubSysServiceAPIDEMust().getPSSubSysServiceAPIDEMethod")
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
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataSet.getPSSUBSYSSADETAILID())) {
            this.iPSSubSysServiceAPIDEMethod = this.getPSDataEntity().getPSSubSysServiceAPIDE().getPSSubSysServiceAPIDEMethod(this.psDEDataSet.getPSSUBSYSSADETAILID(), false);
        } else {
            String strFullCodeName = SA.SRFramework.Utility.StringHelper.Format((String)"Fetch%1$s", (Object)PSModelCodeNameUtils.capitalize(this.getCodeName()));
            Iterator<? extends IPSSubSysServiceAPIDEMethod> psSubSysSADEMethods = this.getPSDataEntity().getPSSubSysServiceAPIDE().getPSSubSysServiceAPIDEMethods();
            if (psSubSysSADEMethods != null) {
                while (psSubSysSADEMethods.hasNext()) {
                    IPSSubSysServiceAPIDEMethod iPSSubSysServiceAPIDEMethod = psSubSysSADEMethods.next();
                    if (SA.SRFramework.Utility.StringHelper.Compare((String)iPSSubSysServiceAPIDEMethod.getMethodType(), (String)"DEDATASET", (boolean)true) != 0 || SA.SRFramework.Utility.StringHelper.Compare((String)iPSSubSysServiceAPIDEMethod.getCodeName(), (String)strFullCodeName, (boolean)true) != 0) continue;
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
    @PSModelRTMeta(description="\u884c\u4e3a\u6301\u6709\u8005", codelist="DELogicHolder", ignoredumpvalues="3", dynamodelmode=8)
    public int getActionHolder() {
        if (!this.isCustomActionHolder()) {
            try {
                IPSDELogic iPSDELogic = this.getPSDELogic();
                if (iPSDELogic != null) {
                    return iPSDELogic.getLogicHolder();
                }
            }
            catch (Exception e) {
                log.error((Object)e);
            }
        }
        return this.nActionHolder;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u540e\u53f0\u6267\u884c")
    public boolean isEnableBackend() {
        return (this.getActionHolder() & 1) == 1;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u524d\u53f0\u6267\u884c")
    public boolean isEnableFront() {
        return (this.getActionHolder() & 2) == 2;
    }

    protected boolean isCustomActionHolder() {
        return this.bCustomActionHolder;
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u6269\u5c55\u63d2\u4ef6", hideempty=true)
    public IPSSysPFPlugin getPSSysPFPlugin() {
        return this.iPSSysPFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u540e\u7aef\u6269\u5c55\u63d2\u4ef6", hideempty=true)
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
        return this.psDEDataSet.getPSSUBSYSSADETAILID();
    }

    @Override
    public void setPSSubSysServiceAPIDEMethod(IPSSubSysServiceAPIDEMethod iPSSubSysServiceAPIDEMethod) throws Exception {
        this.iPSSubSysServiceAPIDEMethod = iPSSubSysServiceAPIDEMethod;
    }

    @Override
    @PSModelRTMeta(description="\u670d\u52a1\u8bbf\u95ee\u64cd\u4f5c\u6807\u8bc6", dump=false)
    public IPSDEOPPriv getPSDEOPPriv() {
        return this.iPSDEOPPriv;
    }

    public IPSDEDataSet getPSDEDataSet() {
        return this;
    }

    @Override
    @PSModelRTMeta(description="\u6392\u5e8f\u503c", ignoredumpvalues="99999")
    public int getOrderValue() {
        return this.nOrderValue;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528", ignoredumpvalues="true")
    public boolean isValid() {
        return this.bValid;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u8bbf\u95ee\u5ba1\u8ba1", ignoredumpvalues="false", fields={"ENABLEAUDIT"})
    public boolean isEnableAudit() {
        return this.bEnableAudit;
    }

    @Override
    public String getDynaModelFilePath() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u811a\u672c\u4ee3\u7801", fields={"CUSTOMCODE"})
    public String getScriptCode() {
        if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getDataSetType(), (String)"SCRIPT", (boolean)false) == 0) {
            return this.psDEDataSet.getCUSTOMCODE();
        }
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u7ed3\u679c\u96c6\u7c7b\u578b", codelist="DEDataSetType", ignoredumpvalues="DATAQUERY", group="\u57fa\u672c", order=125)
    public String getDataSetType() {
        String strPredefinedType = this.getPredefinedType();
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strPredefinedType)) {
            return strPredefinedType;
        }
        return "DATAQUERY";
    }

    @Override
    @PSModelRTMeta(description="\u9009\u62e9\u5217\u7ea7\u522b", codelist="DEDataQueryColLevel3", ignoredumpvalues="-1", ignorepf=true, doc="\u4ece\u5305\u542b\u7684\u6570\u636e\u67e5\u8be2\u8ba1\u7b97\u5f97\u51fa")
    public int getViewLevel() {
        return this.nViewLevel;
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u7ec4\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSDataEntity", ignorepf=true, doc="\u4ece\u5305\u542b\u7684\u6570\u636e\u67e5\u8be2\u8ba1\u7b97\u5f97\u51fa")
    public IPSDEFGroup getPSDEFGroup() {
        return this.iPSDEFGroup;
    }

    @Override
    @PSModelRTMeta(description="\u8c03\u7528\u8f93\u5165\u5bf9\u8c61", child=true, ignorepf=true, doctype="item", group="\u903b\u8f91", order=215)
    public IPSDEDataSetInput getPSDEDataSetInput() {
        return this.iPSDEDataSetInput;
    }

    @Override
    @PSModelRTMeta(description="\u8c03\u7528\u8fd4\u56de\u5bf9\u8c61", child=true, ignorepf=true, doctype="item", group="\u903b\u8f91", order=216)
    public IPSDEDataSetReturn getPSDEDataSetReturn() {
        return this.iPSDEDataSetReturn;
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u6a21\u5f0f", ignoredumpvalues="0", ignorepf=true, codelist="DEDataSetGroupMode", fields={"ENABLEGROUP"})
    public int getGroupMode() {
        return this.nGroupMode;
    }

    @Override
    @PSModelRTMeta(description="\u805a\u5408\u6570\u636e\u5173\u7cfb", hideempty=true, ignorepf=true, dumpref=true, from="IPSDataEntity", from_method="getMajorPSDERBase", origin="IPSDERAggData", fields={"AGGDATAPSDERID"})
    public IPSDERAggData getPSDERAggData() {
        return this.iPSDERAggData;
    }

    @Override
    protected String onGetMOSFileName() {
        return this.getName();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5904\u7406\u903b\u8f91", hideempty=true, ignorepf=true, dumpref=true, from="IPSDataEntity")
    public IPSDELogic getPSDELogic() throws Exception {
        if (this.iPSDELogic != null) {
            return this.iPSDELogic;
        }
        if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getPredefinedType(), (String)"DELOGIC", (boolean)false) == 0) {
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataSet.getPSDELOGICID())) {
                throw new Exception("\u672a\u6307\u5b9a\u5b9e\u4f53\u5904\u7406\u903b\u8f91");
            }
            this.iPSDELogic = this.getPSDataEntity().getPSDELogic(this.psDEDataSet.getPSDELOGICID());
        }
        return this.iPSDELogic;
    }

    @Override
    public String getBeforeCode() {
        return this.psDEDataSet.getBEFORECODE();
    }

    @Override
    public String getAfterCode() {
        return this.psDEDataSet.getAFTERCODE();
    }

    @Override
    @PSModelRTMeta(description="\u6027\u80fd\u4f18\u5316\u9884\u8b66\u65f6\u957f\uff08ms\uff09", ignorepf=true, ignoredumpvalues="-1", fields={"POTIME"})
    public int getPOTime() {
        return this.nPOTime;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u96c6\u6807\u8bb0", fields={"DSTAG"})
    public String getDataSetTag() {
        return this.psDEDataSet.getDSTAG();
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u96c6\u6807\u8bb02", fields={"DSTAG2"})
    public String getDataSetTag2() {
        return this.psDEDataSet.getDSTAG2();
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u96c6\u6807\u8bb03", fields={"DSTAG3"})
    public String getDataSetTag3() {
        return this.psDEDataSet.getDSTAG3();
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u96c6\u6807\u8bb04", fields={"DSTAG4"})
    public String getDataSetTag4() {
        return this.psDEDataSet.getDSTAG4();
    }

    @Override
    public String getReturnValueType() {
        return this.psDEDataSet.getRETVALTYPE();
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u96c6\u53c2\u6570\u6a21\u5f0f", codelist="DEDataSetParamMode", ignoredumpvalues="1", ignorepf=true, fields={"PARAMTYPE"})
    public int getParamMode() {
        return this.nParamMode;
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u5b9a\u4e49\u6570\u636e\u96c6\u53c2\u6570", ignoredumpvalues="false", ignorepf=true, fields={"PARAMTYPE"}, doc="\u662f\u5426\u6709\u8bbe\u7f6e\u884c\u4e3a\u53c2\u6570")
    public boolean isCustomParam() {
        return this.bCustomParam;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u96c6\u53c2\u6570\u96c6\u5408", child=true, ignorepf=true, group="\u57fa\u672c", order=130)
    public Iterator<IPSDEDataSetParam> getPSDEDataSetParams() {
        if (this.psDEDSParamList == null || this.psDEDSParamList.size() == 0) {
            return null;
        }
        return this.psDEDSParamList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u5165\u5c5e\u6027\u7ec4\u5bf9\u8c61", hideempty=true, dump=false)
    public IPSDEFGroup getInPSDEFGroup() {
        return this.inPSDEFGroup;
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
        String strServiceCodeName = this.psDEDataSet.getSERVICECODENAME();
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strServiceCodeName)) {
            return this.getPSDataEntity().getAPICodeName("Fetch", PSModelCodeNameUtils.capitalize(this.getCodeName()), null);
        }
        return strServiceCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u96c6\u9009\u9879", codelist="DEDataSetOption", ignoredumpvalues="0", fields={"DSOPTION"})
    public int getDataSetOption() {
        int nDSOption = this.psDEDataSet.getDSOPTION();
        if (nDSOption > 0) {
            return nDSOption;
        }
        return 0;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u96c6\u52a8\u6001\u53c2\u6570", hideempty2=true, ignorepf=true, fields={"DATASETPARAMS"})
    public Properties getDataSetParams() {
        return this.dataSetParams;
    }

    @Override
    @PSModelRTMeta(description="\u8fde\u63a5\u6a21\u5f0f", hideempty2=true, ignorepf=true, codelist="DEDataSetUnionMode", ignoredumpvalues="UNION", fields={"UNIONMODE"})
    public String getUnionMode() {
        return this.psDEDataSet.getUNIONMODE();
    }

    @Override
    @PSModelRTMeta(description="\u6700\u5927\u8bb0\u5f55\u6570", ignorepf=true, ignoredumpvalues="-1", fields={"MAXROWCNT"})
    public int getMaxRowCount() {
        return this.nMaxRowCount;
    }
}

