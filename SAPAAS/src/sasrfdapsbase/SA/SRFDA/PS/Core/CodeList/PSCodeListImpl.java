/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.codelist.ICodeItem
 *  net.ibizsys.paas.core.ISystem
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.pscore.srv.util.Inflector
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.CodeList;

import SA.SRFDA.PS.Core.CodeList.IPSCodeItem;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.CodeList.PSCodeItemImpl;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEMSLogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEMSLogicNode;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.IPSSystemRuntime;
import SA.SRFDA.PS.Core.IPSSystemSetting;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PF.IPSPFLogicCodeObject;
import SA.SRFDA.PS.Core.PF.IPSPFPlugin;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Pub.IPSXCodeObject;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginTempl;
import SA.SRFDA.PS.Core.SF.PSSFCodeObjectHelper;
import SA.SRFDA.PS.Core.SF.PSSFXCodeObjectProxy;
import SA.SRFDA.PS.Core.System.IPSSysRef;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSCodeItem;
import SA.SRFDA.PS.Data.PSCodeList;
import SA.SRFDA.PS.Data.PSDEMainState;
import SA.SRFDA.PS.Data.PSDevSlnSysDynaInst;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.Vector;
import net.ibizsys.paas.codelist.ICodeItem;
import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.pscore.srv.util.Inflector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSCodeListImpl
extends PSCodeItemImpl
implements IPSCodeList,
IPSSystemObject,
IPSPFLogicCodeObject {
    private static final Log log = LogFactory.getLog(PSCodeListImpl.class);
    public static final String MODELGROUP_THRESHOLD = "\u9608\u503c\u7ec4";
    public static final String MODELGROUP_STATIC = "\u9759\u6001\u4ee3\u7801\u8868";
    public static final String MODELGROUP_DYNAMIC = "\u52a8\u6001\u4ee3\u7801\u8868";
    public static final String[] MODELGROUPS = new String[]{"\u57fa\u672c", "\u9608\u503c\u7ec4|item.isThresholdGroup()", "\u9759\u6001\u4ee3\u7801\u8868|item.codeListType=='STATIC'", "\u52a8\u6001\u4ee3\u7801\u8868|item.codeListType=='DYNAMIC'", "\u7528\u6237\u6269\u5c55", "\u5176\u5b83"};
    public static final int MODELORDER_THRESHOLD = 150;
    public static final int MODELORDER_STATIC = 180;
    public static final int MODELORDER_DYNAMIC = 210;
    protected PSCodeList psCodeList = null;
    protected String strCodeName = "";
    private IPSDataEntity iPSDataEntity = null;
    private IPSDEDataSet iPSDEDataSet = null;
    private String strValueSeparator = "";
    private String strTextSeparator = "";
    private String strEmptyText = "";
    private String strOrMode = "";
    private boolean bUserRefFlag = false;
    private boolean bSysRefFlag = false;
    private boolean bCodeItemValueNumber = false;
    private String strPredefinedType = null;
    private String strCLType = null;
    private IPSSystem iPSSystem = null;
    private IPSSystemModule iPSSystemModule = null;
    private boolean bSubSysCodeList = false;
    private Properties classOrPkgNameMap = null;
    private IPSDEField textPSDEField = null;
    private IPSDEField valuePSDEField = null;
    protected IPSDEField minorPSDEField = null;
    private IPSDEField iconClsPSDEField = null;
    private IPSDEField iconClsXPSDEField = null;
    private IPSDEField iconPathPSDEField = null;
    private IPSDEField iconPathXPSDEField = null;
    private IPSDEField dataPSDEField = null;
    private IPSDEField clsPSDEField = null;
    private IPSDEField colorPSDEField = null;
    private IPSDEField bkColorPSDEField = null;
    private boolean bUserScope = false;
    private IPSDEField pValuePSDEField = null;
    private IPSDEField disablePSDEField = null;
    private int nExtendMode = 0;
    private IPSLanguageRes emptyTextPSLanguageRes = null;
    private boolean bDynamicCodeList = false;
    private boolean bSubSysAsCloud = false;
    private String strLinkPSDEViewId = "";
    private boolean bEnableCache = true;
    private int nCacheTimeout = -1;
    private int nDynaInstMode = 0;
    private boolean bModuleInstCodeList = false;
    private boolean bThresholdGroup = false;
    private int nIncBeginValueMode = 2;
    private int nIncEndValueMode = 3;
    private IPSDEField beginValuePSDEField = null;
    private IPSDEField endValuePSDEField = null;
    private IPSSysPFPlugin iPSSysPFPlugin = null;
    private IPSSysSFPlugin iPSSysSFPlugin = null;
    private IPSXCodeObject iPSXCodeObject = null;
    private int nDynaSysMode = 0;
    protected ArrayList<IPSCodeItem> allPSCodeItemList = null;
    private IPSDEMSLogic iPSDEMSLogic = null;
    private String strAllText = "";
    private IPSLanguageRes allTextPSLanguageRes = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSCodeList psCodeList) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psCodeList = psCodeList;
            this.setId(this.psCodeList.getPSCODELISTID());
            this.setName(this.psCodeList.getPSCODELISTNAME());
            this.setPSObjectData(this.psCodeList);
            this.strCodeName = this.psCodeList.getCODENAME();
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strCodeName)) {
                this.strCodeName = this.psCodeList.getCODELISTSN().toLowerCase();
            }
            if (!(SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strCodeName) || iPSSystem != null && iPSSystem.getPSSystemSetting().isFixCodeNameAutoCapitalize())) {
                String strHeader = this.strCodeName.substring(0, 1).toUpperCase();
                this.strCodeName = String.valueOf(strHeader) + this.strCodeName.substring(1);
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getPredefinedType(), (String)"MODULEINST", (boolean)false) == 0 && SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psCodeList.getPSMODULEID())) {
                throw new Exception(String.format("\u6a21\u5757\u526f\u672c\u4ee3\u7801\u8868\u5fc5\u987b\u6307\u5b9a\u76f8\u5e94\u7684\u7cfb\u7edf\u6a21\u5757", new Object[0]));
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getPredefinedType(), (String)"DEMAINSTATE", (boolean)false) == 0 && SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psCodeList.getPSDEID())) {
                throw new Exception(String.format("\u4e3b\u72b6\u6001\u4ee3\u7801\u8868\u5fc5\u987b\u6307\u5b9a\u76f8\u5e94\u7684\u5b9e\u4f53", new Object[0]));
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psCodeList.getPSMODULEID())) {
                this.iPSSystemModule = this.getPSSystem().getPSSystemModule(this.psCodeList.getPSMODULEID());
            }
            if (this.iPSSystemModule != null) {
                this.bSubSysCodeList = this.iPSSystemModule.isSubSysModule();
                this.bSubSysAsCloud = this.iPSSystemModule.isSubSysAsCloud();
            } else if (this.getPSDataEntity() != null && this.getPSDataEntity().isSubSysDE()) {
                this.iPSSystemModule = this.getPSDataEntity().getPSSystemModule();
                this.bSubSysAsCloud = this.getPSDataEntity().isSubSysAsCloud();
                this.bSubSysCodeList = true;
            }
            if (!this.psCodeList.isNUMBERITEMNull()) {
                this.bCodeItemValueNumber = this.psCodeList.getNUMBERITEM();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psCodeList.getORMODE())) {
                if (SA.SRFramework.Utility.StringHelper.Compare((String)this.psCodeList.getORMODE(), (String)"NUMBERORMODE", (boolean)true) == 0 || SA.SRFramework.Utility.StringHelper.Compare((String)this.psCodeList.getORMODE(), (String)"NUM", (boolean)true) == 0) {
                    this.strOrMode = "NUM";
                    this.bCodeItemValueNumber = true;
                } else {
                    this.strOrMode = "STR";
                }
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)this.strOrMode, (String)"STR", (boolean)true) == 0) {
                this.strValueSeparator = ";";
                this.strTextSeparator = "\u3001";
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psCodeList.getSEPERATOR())) {
                    this.strTextSeparator = this.psCodeList.getSEPERATOR();
                }
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psCodeList.getVALUESEPERATOR())) {
                    this.strValueSeparator = this.psCodeList.getVALUESEPERATOR();
                }
            } else if (SA.SRFramework.Utility.StringHelper.Compare((String)this.strOrMode, (String)"NUM", (boolean)true) == 0) {
                this.strValueSeparator = "";
                this.strTextSeparator = "\u3001";
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psCodeList.getSEPERATOR())) {
                    this.strTextSeparator = this.psCodeList.getSEPERATOR();
                }
            } else {
                this.strValueSeparator = "";
                this.strTextSeparator = "";
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psCodeList.getPSDEID())) {
                this.bUserRefFlag = true;
            }
            if (!this.psCodeList.isUSERREFFLAGNull() || !this.psCodeList.isSYSREFFLAGNull()) {
                boolean bl = this.bUserRefFlag = this.psCodeList.getUSERREFFLAG() || this.psCodeList.getSYSREFFLAG();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psCodeList.getPREDEFINEDTYPE())) {
                this.strPredefinedType = this.psCodeList.getPREDEFINEDTYPE();
            }
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getPredefinedType())) {
                this.strCLType = this.psCodeList.getCLTYPE();
            } else {
                this.strCLType = "DYNAMIC";
                if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getPredefinedType(), (String)"MODULEINST", (boolean)false) == 0) {
                    this.strCLType = "STATIC";
                    this.bModuleInstCodeList = true;
                } else if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getPredefinedType(), (String)"DEMAINSTATE", (boolean)false) == 0 && SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psCodeList.getPSDEMSLOGICID())) {
                    this.strCLType = "STATIC";
                }
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)this.strCLType, (String)"PREDEFINED", (boolean)true) == 0) {
                this.strCLType = "DYNAMIC";
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)this.strCLType, (String)"DYNAMIC", (boolean)true) == 0 && !this.psCodeList.isUSERSCOPENull()) {
                this.bUserScope = this.psCodeList.getUSERSCOPE();
            }
            if (!this.psCodeList.isEXTENDMODENull()) {
                this.nExtendMode = this.psCodeList.getEXTENDMODE();
            }
            if (!this.psCodeList.isTHRESHOLDGROUPFLAGNull()) {
                this.bThresholdGroup = this.psCodeList.getTHRESHOLDGROUPFLAG();
            }
            if (this.isThresholdGroup()) {
                this.nIncBeginValueMode = this.psCodeList.getINCBEGINVALUE();
                this.nIncEndValueMode = this.psCodeList.getINCENDVALUE();
            }
            this.strLinkPSDEViewId = this.psCodeList.getLINKPSDEVIEWID();
            if (!this.psCodeList.isENABLECACHENull()) {
                this.bEnableCache = this.psCodeList.getENABLECACHE();
            }
            if (this.isEnableCache() && !this.psCodeList.isCACHETIMEOUTNull()) {
                this.nCacheTimeout = this.psCodeList.getCACHETIMEOUT();
                if (this.nCacheTimeout < 0) {
                    this.nCacheTimeout = -1;
                }
            }
            if (this.getPSSystemModule() != null && this.getPSSystemModule().getDynaInstMode() != 0) {
                this.nDynaInstMode = this.getPSSystemModule().getDynaInstMode();
                if (!this.psCodeList.isENABLEDYNASYSNull() && !this.psCodeList.getENABLEDYNASYS()) {
                    this.nDynaInstMode = 0;
                }
            }
            if (!this.psCodeList.isENABLEDYNASYSNull() && this.psCodeList.getENABLEDYNASYS()) {
                this.nDynaSysMode = 1;
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
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psCodeList.getPSSYSPFPLUGINID())) {
            this.iPSSysPFPlugin = this.getPSDataEntity().getPSSystem().getPSSysPFPlugin(this.psCodeList.getPSSYSPFPLUGINID());
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psCodeList.getPSSYSSFPLUGINID())) {
            this.iPSSysSFPlugin = this.getPSDataEntity().getPSSystem().getPSSysSFPlugin(this.psCodeList.getPSSYSSFPLUGINID());
        }
        if (this.getPSSysSFPlugin() != null) {
            String strPSSysSFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysSFPlugin().getId(), (String)this.getPSSystem().getPSSFId());
            IPSSysSFPluginTempl iPSSysSFPluginTempl = this.getPSSystem().getPSSysSFPluginTempl(strPSSysSFPluginTemplId, true);
            if (iPSSysSFPluginTempl != null) {
                this.iPSXCodeObject = new PSSFXCodeObjectProxy(iPSSysSFPluginTempl, this);
            }
        }
        super.onInit();
        if (!this.psCodeList.getNOVALUEEMPTY()) {
            String strEmptyTextPSLanguageId;
            this.strEmptyText = this.psCodeList.getEMPTYTEXT();
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strEmptyText)) {
                for (IPSCodeItem iPSCodeItem : this.psCodeItemList) {
                    if (!iPSCodeItem.isShowAsEmtpy()) continue;
                    this.strEmptyText = iPSCodeItem.getText();
                    break;
                }
            }
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strEmptyText)) {
                this.strEmptyText = ((IPSSystemSetting)((Object)this.getPSSystem())).getCLEmptyText();
            }
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strEmptyText)) {
                this.strEmptyText = "\u672a\u5b9a\u4e49";
            }
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)(strEmptyTextPSLanguageId = this.psCodeList.getEMPTYTEXTPSLANRESID()))) {
                strEmptyTextPSLanguageId = ((IPSSystemSetting)((Object)this.getPSSystem())).getCLEmptyTextPSLanguageResId();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strEmptyTextPSLanguageId)) {
                this.emptyTextPSLanguageRes = this.getPSSystem().getPSLanguageRes(strEmptyTextPSLanguageId);
            }
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getOrMode())) {
            this.strAllText = this.psCodeList.getALLTEXT();
            String strAllTextPSLanguageId = this.psCodeList.getALLTEXTPSLANRESID();
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strAllTextPSLanguageId)) {
                this.allTextPSLanguageRes = this.getPSSystem().getPSLanguageRes(strAllTextPSLanguageId);
            }
        }
        this.onPrepareAllPSCodeItems();
    }

    @Override
    @PSModelRTMeta(description="\u540d\u79f0", order=100)
    public String getName() {
        return super.getName();
    }

    @Override
    protected void onPreparePSCodeItems() throws Exception {
        this.psCodeItemList.clear();
        this.codeItemList.clear();
        Vector<PSCodeItem> psCodeItemList = new Vector<PSCodeItem>();
        if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getPredefinedType(), (String)"MODULEINST", (boolean)false) == 0) {
            if (this.getPSSystem() instanceof IPSSystemRuntime) {
                IPSSystemRuntime iPSSystemRuntime = (IPSSystemRuntime)((Object)this.getPSSystem());
                if (iPSSystemRuntime.getDynaInstMode() == 1) {
                    ArrayList<PSDevSlnSysDynaInst> psDevSlnSysDynaInstList = iPSSystemRuntime.getPSDevSlnSysDynaInstList();
                    if (psDevSlnSysDynaInstList != null) {
                        for (PSDevSlnSysDynaInst psDevSlnSysDynaInst : psDevSlnSysDynaInstList) {
                            if (SA.SRFramework.Utility.StringHelper.Compare((String)psDevSlnSysDynaInst.getINSTTAG(), (String)this.getDynaInstTag(), (boolean)false) != 0 || SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDevSlnSysDynaInst.getINSTTAG2())) continue;
                            PSCodeItem psCodeItem = new PSCodeItem();
                            psCodeItem.setPSCODEITEMID(psDevSlnSysDynaInst.getPSDEVSLNSYSDYNAINSTID());
                            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDevSlnSysDynaInst.getLOGICNAME())) {
                                psCodeItem.setPSCODEITEMNAME(psDevSlnSysDynaInst.getLOGICNAME());
                            } else {
                                psCodeItem.setPSCODEITEMNAME(psDevSlnSysDynaInst.getPSDEVSLNSYSDYNAINSTNAME());
                            }
                            psCodeItem.setCODEITEMVALUE(psDevSlnSysDynaInst.getINSTTAG2());
                            psCodeItem.setDATA(psDevSlnSysDynaInst.getPSDEVSLNSYSDYNAINSTID());
                            psCodeItem.setCOLOR(psDevSlnSysDynaInst.getCOLOR());
                            psCodeItemList.add(psCodeItem);
                        }
                    }
                } else if (iPSSystemRuntime.getDynaInstMode() == 2 && SA.SRFramework.Utility.StringHelper.Compare((String)iPSSystemRuntime.getDynaInstTag(), (String)this.getDynaInstTag(), (boolean)false) == 0) {
                    PSCodeItem psCodeItem = new PSCodeItem();
                    psCodeItem.setPSCODEITEMID(iPSSystemRuntime.getPSDynaInstId());
                    if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)iPSSystemRuntime.getPSDynaInstLogicName())) {
                        psCodeItem.setPSCODEITEMNAME(iPSSystemRuntime.getPSDynaInstLogicName());
                    } else {
                        psCodeItem.setPSCODEITEMNAME(iPSSystemRuntime.getPSDynaInstName());
                    }
                    psCodeItem.setCODEITEMVALUE(iPSSystemRuntime.getDynaInstTag2());
                    psCodeItem.setDATA(iPSSystemRuntime.getPSDynaInstId());
                    psCodeItemList.add(psCodeItem);
                }
            }
        } else if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getPredefinedType(), (String)"DEMAINSTATE", (boolean)false) == 0) {
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psCodeList.getPSDEMSLOGICID())) {
                Vector<PSDEMainState> psDEMainStateList = new Vector<PSDEMainState>();
                CallResult callResult = this.getPSModelHelper().getPSDEMainStates(this.psCodeList.getPSDEID(), psDEMainStateList);
                if (callResult.isError()) {
                    throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u5168\u90e8\u4e3b\u72b6\u6001\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                Collections.sort(psDEMainStateList, new Comparator<PSDEMainState>(){

                    @Override
                    public int compare(PSDEMainState o1, PSDEMainState o2) {
                        Integer nOrder1 = o1.GetParamIntValue("ORDERVALUE", 99999);
                        Integer nOrder2 = o2.GetParamIntValue("ORDERVALUE", 99999);
                        return nOrder1.compareTo(nOrder2);
                    }
                });
                for (PSDEMainState psDEMainState : psDEMainStateList) {
                    int nMainStateType;
                    if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDEMainState.getMSVALUE()) || !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDEMainState.getMSVALUE2()) || !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDEMainState.getMSVALUE3()) || (nMainStateType = psDEMainState.getDEFAULTMODE()) != 0 && nMainStateType != 1) continue;
                    PSCodeItem psCodeItem = new PSCodeItem();
                    psCodeItem.setPSCODEITEMID(psDEMainState.getPSDEMAINSTATEID());
                    psCodeItem.setPSCODEITEMNAME(psDEMainState.getPSDEMAINSTATENAME());
                    psCodeItem.setCODEITEMVALUE(psDEMainState.getMSVALUE());
                    if (nMainStateType == 1) {
                        psCodeItem.setDEFAULTFLAG(true);
                    }
                    psCodeItem.setCODENAME(psDEMainState.getCODENAME());
                    psCodeItem.setCOLOR(psDEMainState.getCOLOR());
                    psCodeItem.setPSSYSCSSID(psDEMainState.getPSSYSCSSID());
                    psCodeItem.setPSSYSCSSNAME(psDEMainState.getPSSYSCSSNAME());
                    psCodeItem.setPSSYSIMAGEID(psDEMainState.getPSSYSIMAGEID());
                    psCodeItem.setPSSYSIMAGENAME(psDEMainState.getPSSYSIMAGENAME());
                    psCodeItem.setORDERVALUE(psDEMainState.getORDERVALUE());
                    psCodeItemList.add(psCodeItem);
                }
            } else {
                Iterator<? extends IPSDEMSLogicNode> psDEMSLogicNodes = this.getPSDEMSLogic().getPSDEMSLogicNodes();
                if (psDEMSLogicNodes != null) {
                    if (this.getPSDEMSLogic().getDefaultPSDEMSLogicNode() != null) {
                        IPSDEMSLogicNode iPSDEMSLogicNode = this.getPSDEMSLogic().getDefaultPSDEMSLogicNode();
                        PSCodeItem psCodeItem = new PSCodeItem();
                        psCodeItem.setPSCODEITEMID(iPSDEMSLogicNode.getId());
                        psCodeItem.setPSCODEITEMNAME(iPSDEMSLogicNode.getName());
                        psCodeItem.setCODEITEMVALUE(iPSDEMSLogicNode.getStateValue());
                        psCodeItem.setDEFAULTFLAG(true);
                        psCodeItem.setCODENAME(iPSDEMSLogicNode.getCodeName());
                        psCodeItem.setCOLOR(iPSDEMSLogicNode.getColor());
                        psCodeItem.setBKCOLOR(iPSDEMSLogicNode.getBKColor());
                        psCodeItem.setCSSCLASS(iPSDEMSLogicNode.getCssClass());
                        psCodeItem.setORDERVALUE(0);
                        psCodeItemList.add(psCodeItem);
                    }
                    int nOrderValue = 100;
                    while (psDEMSLogicNodes.hasNext()) {
                        IPSDEMSLogicNode iPSDEMSLogicNode = psDEMSLogicNodes.next();
                        if (iPSDEMSLogicNode.isDefaultMode()) continue;
                        PSCodeItem psCodeItem = new PSCodeItem();
                        psCodeItem.setPSCODEITEMID(iPSDEMSLogicNode.getId());
                        psCodeItem.setPSCODEITEMNAME(iPSDEMSLogicNode.getName());
                        psCodeItem.setCODEITEMVALUE(iPSDEMSLogicNode.getStateValue());
                        psCodeItem.setDEFAULTFLAG(false);
                        psCodeItem.setCODENAME(iPSDEMSLogicNode.getCodeName());
                        psCodeItem.setCOLOR(iPSDEMSLogicNode.getColor());
                        psCodeItem.setBKCOLOR(iPSDEMSLogicNode.getBKColor());
                        psCodeItem.setCSSCLASS(iPSDEMSLogicNode.getCssClass());
                        psCodeItem.setORDERVALUE(nOrderValue);
                        psCodeItemList.add(psCodeItem);
                        nOrderValue += 100;
                    }
                }
            }
        } else {
            CallResult callResult = this.getPSModelHelper().getPSCodeItems(this.getId(), psCodeItemList);
            if (callResult.isError()) {
                throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u4ee3\u7801\u8868\u9879\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
            }
        }
        int nOrderValue = 1;
        for (PSCodeItem psCodeItem : psCodeItemList) {
            psCodeItem.setORDERVALUE(nOrderValue);
            ++nOrderValue;
        }
        HashMap<String, PSCodeItem> psCodeItemMap = new HashMap<String, PSCodeItem>();
        for (PSCodeItem psCodeItem : psCodeItemList) {
            if (!psCodeItem.isVALIDFLAGNull() && !psCodeItem.getVALIDFLAG()) continue;
            psCodeItemMap.put(psCodeItem.getPSCODEITEMID(), psCodeItem);
        }
        for (PSCodeItem psCodeItem : psCodeItemList) {
            PSCodeItem parentPSCodeItem;
            if (!psCodeItem.isVALIDFLAGNull() && !psCodeItem.getVALIDFLAG() || SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psCodeItem.getPPSCODEITEMID()) || (parentPSCodeItem = (PSCodeItem)((Object)psCodeItemMap.get(psCodeItem.getPPSCODEITEMID()))) == null) continue;
            parentPSCodeItem.getChildPSCodeItems(true).add(psCodeItem);
        }
        for (PSCodeItem psCodeItem : psCodeItemList) {
            if (!psCodeItem.isVALIDFLAGNull() && !psCodeItem.getVALIDFLAG() || !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psCodeItem.getPPSCODEITEMID())) continue;
            PSCodeItemImpl iPSCodeItem = new PSCodeItemImpl();
            iPSCodeItem.init(this.getDAGlobalHelper(), this, null, psCodeItem);
            this.psCodeItemList.add(iPSCodeItem);
        }
        this.codeItemList.addAll(this.psCodeItemList);
    }

    protected void onPrepareAllPSCodeItems() throws Exception {
        Iterator<IPSCodeItem> childPSCodeItems = this.getPSCodeItems();
        if (childPSCodeItems != null) {
            this.allPSCodeItemList = new ArrayList();
            while (childPSCodeItems.hasNext()) {
                this.fillPSCodeItems(childPSCodeItems.next(), this.allPSCodeItemList);
            }
            if (this.allPSCodeItemList.size() == 0) {
                this.allPSCodeItemList = null;
            }
        }
    }

    protected void fillPSCodeItems(IPSCodeItem iPSCodeItem, ArrayList<IPSCodeItem> allPSCodeItemList) throws Exception {
        allPSCodeItemList.add(iPSCodeItem);
        Iterator<IPSCodeItem> childPSCodeItems = iPSCodeItem.getPSCodeItems();
        if (childPSCodeItems != null) {
            while (childPSCodeItems.hasNext()) {
                this.fillPSCodeItems(childPSCodeItems.next(), allPSCodeItemList);
            }
        }
    }

    @Override
    @PSModelRTMeta(description="\u5e73\u53f0\u4ee3\u7801\u8868\u6807\u8bc6")
    public String getPSCodeListTemplId() {
        return this.psCodeList.getPSCODELISTTEMPLID();
    }

    public String getCodeListText(String strValue, boolean bRecursion) throws Exception {
        return this.getCodeListText(strValue, bRecursion, null, null);
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u8868\u7c7b\u578b", codelist="CodeListType", group="\u57fa\u672c", order=125, fields={"CLTYPE"})
    public String getCodeListType() {
        return this.strCLType;
    }

    @Override
    public String getHandler() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u7528\u6237\u8303\u56f4", ignorert=2, fields={"USERSCOPE"})
    public boolean isUserScope() {
        return this.bUserScope;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.onGetCodeName();
    }

    protected String onGetCodeName() {
        return this.calcCodeName();
    }

    protected String calcCodeName() {
        return this.strCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5bf9\u8c61", hideempty=true, ignorepf=true, dumpref=true, group="\u52a8\u6001\u4ee3\u7801\u8868", order=15, fields={"PSDEID"})
    public IPSDataEntity getPSDataEntity() throws Exception {
        if (this.iPSDataEntity != null) {
            return this.iPSDataEntity;
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psCodeList.getPSDEID())) {
            this.iPSDataEntity = this.getPSSystem().getPSDataEntity2(this.psCodeList.getPSDEID());
        }
        return this.iPSDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u96c6\u5bf9\u8c61", hideempty=true, ignorepf=true, dumpref=true, from="IPSDataEntity", group="\u52a8\u6001\u4ee3\u7801\u8868", order=16, fields={"PSDEDSID"})
    public IPSDEDataSet getPSDEDataSet() throws Exception {
        if (this.iPSDEDataSet != null) {
            return this.iPSDEDataSet;
        }
        if (this.getPSDataEntity() != null && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psCodeList.getPSDEDSID())) {
            this.iPSDEDataSet = this.getPSDataEntity().getPSDEDataSet(this.psCodeList.getPSDEDSID());
        }
        return this.iPSDEDataSet;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u4e3b\u72b6\u6001\u903b\u8f91\u5bf9\u8c61", hideempty=true, ignorepf=true, dumpref=true, from="IPSDataEntity", group="\u52a8\u6001\u4ee3\u7801\u8868", order=17, fields={"PSDEMSLOGICID"})
    public IPSDEMSLogic getPSDEMSLogic() throws Exception {
        if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getPredefinedType(), (String)"DEMAINSTATE", (boolean)false) != 0) {
            return null;
        }
        if (this.iPSDEMSLogic != null) {
            return this.iPSDEMSLogic;
        }
        if (this.getPSDataEntity() != null && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psCodeList.getPSDEMSLOGICID())) {
            this.iPSDEMSLogic = this.getPSDataEntity().getPSDEMSLogic(this.psCodeList.getPSDEMSLOGICID());
        }
        return this.iPSDEMSLogic;
    }

    @Override
    @PSModelRTMeta(description="\u591a\u9879\u4ee3\u7801\u8868\u6216\u6a21\u5f0f", hideempty2=true, codelist="CodeListOrMode2", group="\u57fa\u672c", order=130, fields={"ORMODE"})
    public String getOrMode() {
        return this.strOrMode;
    }

    @Override
    @PSModelRTMeta(description="\u503c\u5206\u9694\u7b26", hideempty2=true, fields={"VALUESEPERATOR"})
    public String getValueSeparator() {
        return this.strValueSeparator;
    }

    @Override
    @PSModelRTMeta(description="\u6587\u672c\u5206\u9694\u7b26", hideempty2=true, fields={"SEPERATOR"})
    public String getTextSeparator() {
        return this.strTextSeparator;
    }

    @Override
    @PSModelRTMeta(description="\u7a7a\u767d\u663e\u793a\u6587\u672c", fields={"EMPTYTEXT"})
    public String getEmptyText() {
        return this.strEmptyText;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u9879\u503c\u4e3a\u6570\u503c", group="\u57fa\u672c", order=129, fields={"NUMBERITEM"})
    public boolean isCodeItemValueNumber() {
        return this.bCodeItemValueNumber;
    }

    @Override
    @PSModelRTMeta(description="\u9884\u7f6e\u4ee3\u7801\u8868\u7c7b\u578b", codelist="PredefinedCLType", hideempty2=true, group="\u57fa\u672c", order=128, fields={"PREDEFINEDTYPE"})
    public String getPredefinedType() {
        return this.strPredefinedType;
    }

    public String getGlobalId() {
        return this.getPSCodeListTemplId();
    }

    public String getCodeListText(String strValue, boolean bRecursion, Object activeData, IWebContext iWebContext) throws Exception {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u5bf9\u8c61")
    public IPSSystem getPSSystem() {
        return this.iPSSystem;
    }

    protected void setPSSystem(IPSSystem iPSSystem) {
        this.iPSSystem = iPSSystem;
    }

    public ISystem getSystem() {
        return this.getPSSystem();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSystem().getPSSysModelInstId();
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u7cfb\u7edf\u4ee3\u7801\u8868", ignorert=3)
    public boolean isSubSysCodeList() {
        return this.bSubSysCodeList;
    }

    @Override
    public String getClassOrPkgName(String strCodeType, IPSSysSFPub iPSSysSFPub) throws Exception {
        String strNameFormat2;
        String strPKGName = PSSFCodeObjectHelper.getClassOrPkgName(this, this.iPSSystemModule, this.classOrPkgNameMap, "PKG", iPSSysSFPub);
        String strNameFormat = PSSFCodeObjectHelper.getClassOrPkgName(this, this.iPSSystemModule, this.classOrPkgNameMap, strCodeType, iPSSysSFPub);
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strNameFormat)) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u4ee3\u7801\u8868[%1$s]\u4ee3\u7801\u7c7b\u578b[%2$s]\u4ee3\u7801\u540d\u79f0"));
        }
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strPKGName)) {
            strPKGName = iPSSysSFPub.getPKGCodeName();
        }
        String strModuleName = "";
        if (this.getPSSystemModule() != null) {
            strModuleName = this.getPSSystemModule().getCodeName();
        }
        if (this.isSubSysCodeList() && this.getExtendMode() == 2 && strCodeType.indexOf("SUBSYS_") != 0 && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)(strNameFormat2 = PSSFCodeObjectHelper.getClassOrPkgName(this, null, this.classOrPkgNameMap, "SUBSYS_" + strCodeType, iPSSysSFPub)))) {
            strModuleName = "SubSys";
            strPKGName = "";
            strNameFormat = strNameFormat2;
        }
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strPKGName)) {
            strPKGName = iPSSysSFPub.getPKGCodeName();
        }
        if (iPSSysSFPub.getPSSFStyle().getPSSF().isPkgLowercase()) {
            strModuleName = strModuleName.toLowerCase();
        }
        return SA.SRFramework.Utility.StringHelper.Format((String)strNameFormat, (Object)strPKGName, (Object)strModuleName, (Object)this.getCodeName());
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757", dumpref=true, dynamodelmode=4, outputdoc="false", ignorepf=true, fields={"PSMODULEID"})
    public IPSSystemModule getPSSystemModule() {
        if (this.iPSSystemModule == null) {
            return this.getPSSystem().getDefaultPSSystemModule();
        }
        return this.iPSSystemModule;
    }

    @Override
    @PSModelRTMeta(description="\u663e\u793a\u6587\u672c\u5c5e\u6027", hideempty=true, ignorepf=true, dumpref=true, from="IPSDataEntity", group="\u52a8\u6001\u4ee3\u7801\u8868", order=20, fields={"TEXTPSDEFID"})
    public IPSDEField getTextPSDEField() throws Exception {
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psCodeList.getPSDEID()) && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psCodeList.getTEXTPSDEFID())) {
            if (this.textPSDEField != null) {
                return this.textPSDEField;
            }
            this.textPSDEField = this.getPSDataEntity().getPSDEField(this.psCodeList.getTEXTPSDEFID());
            return this.textPSDEField;
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u503c\u5c5e\u6027", hideempty=true, ignorepf=true, dumpref=true, from="IPSDataEntity", group="\u52a8\u6001\u4ee3\u7801\u8868", order=21, fields={"VALUEPSDEFID"})
    public IPSDEField getValuePSDEField() throws Exception {
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psCodeList.getPSDEID()) && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psCodeList.getVALUEPSDEFID())) {
            if (this.valuePSDEField != null) {
                return this.valuePSDEField;
            }
            this.valuePSDEField = this.getPSDataEntity().getPSDEField(this.psCodeList.getVALUEPSDEFID());
            return this.valuePSDEField;
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u5c5e\u6027", hideempty=true, ignorepf=true, dumpref=true, from="IPSDataEntity", fields={"DATAPSDEFID"})
    public IPSDEField getDataPSDEField() throws Exception {
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psCodeList.getPSDEID()) && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psCodeList.getDATAPSDEFID())) {
            if (this.dataPSDEField != null) {
                return this.dataPSDEField;
            }
            this.dataPSDEField = this.getPSDataEntity().getPSDEField(this.psCodeList.getDATAPSDEFID());
            return this.dataPSDEField;
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u6392\u5e8f\u5c5e\u6027", hideempty=true, ignorepf=true, dumpref=true, from="IPSDataEntity", group="\u52a8\u6001\u4ee3\u7801\u8868", order=25, fields={"MINORSORTPSDEFID"})
    public IPSDEField getMinorSortPSDEField() throws Exception {
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psCodeList.getPSDEID()) && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psCodeList.getMINORSORTPSDEFID())) {
            if (this.minorPSDEField != null) {
                return this.minorPSDEField;
            }
            this.minorPSDEField = this.getPSDataEntity().getPSDEField(this.psCodeList.getMINORSORTPSDEFID());
            return this.minorPSDEField;
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u6392\u5e8f\u65b9\u5411", hideempty2=true, codelist="SortDir", group="\u52a8\u6001\u4ee3\u7801\u8868", order=26, fields={"MINORSORTDIR"})
    public String getMinorSortDir() {
        return this.psCodeList.getMINORSORTDIR();
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u6807\u6837\u5f0f\u5c5e\u6027", hideempty2=true, ignorepf=true, dumpref=true, from="IPSDataEntity", group="\u52a8\u6001\u4ee3\u7801\u8868", order=30, fields={"ICONCLSPSDEFID"})
    public IPSDEField getIconClsPSDEField() throws Exception {
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psCodeList.getPSDEID()) && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psCodeList.getICONCLSPSDEFID())) {
            if (this.iconClsPSDEField != null) {
                return this.iconClsPSDEField;
            }
            this.iconClsPSDEField = this.getPSDataEntity().getPSDEField(this.psCodeList.getICONCLSPSDEFID());
            return this.iconClsPSDEField;
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u6807\u8def\u5f84\u5c5e\u6027", hideempty2=true, group="\u52a8\u6001\u4ee3\u7801\u8868", order=32, fields={"ICONPATHPSDEFID"})
    public IPSDEField getIconPathPSDEField() throws Exception {
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psCodeList.getPSDEID()) && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psCodeList.getICONPATHPSDEFID())) {
            if (this.iconPathPSDEField != null) {
                return this.iconPathPSDEField;
            }
            this.iconPathPSDEField = this.getPSDataEntity().getPSDEField(this.psCodeList.getICONPATHPSDEFID());
            return this.iconPathPSDEField;
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u6807\u6837\u5f0f(x)\u5c5e\u6027", hideempty2=true, ignorepf=true, dumpref=true, from="IPSDataEntity", group="\u52a8\u6001\u4ee3\u7801\u8868", order=31, fields={"ICONCLSXPSDEFID"})
    public IPSDEField getIconClsXPSDEField() throws Exception {
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psCodeList.getPSDEID()) && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psCodeList.getICONCLSXPSDEFID())) {
            if (this.iconClsXPSDEField != null) {
                return this.iconClsXPSDEField;
            }
            this.iconClsXPSDEField = this.getPSDataEntity().getPSDEField(this.psCodeList.getICONCLSXPSDEFID());
            return this.iconClsXPSDEField;
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u6807\u8def\u5f84(x)\u5c5e\u6027", hideempty2=true, ignorepf=true, dumpref=true, from="IPSDataEntity", group="\u52a8\u6001\u4ee3\u7801\u8868", order=33, fields={"ICONPATHXPSDEFID"})
    public IPSDEField getIconPathXPSDEField() throws Exception {
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psCodeList.getPSDEID()) && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psCodeList.getICONPATHXPSDEFID())) {
            if (this.iconPathXPSDEField != null) {
                return this.iconPathXPSDEField;
            }
            this.iconPathXPSDEField = this.getPSDataEntity().getPSDEField(this.psCodeList.getICONPATHXPSDEFID());
            return this.iconPathXPSDEField;
        }
        return null;
    }

    @Override
    public String getModelType() {
        return "PSCODELIST";
    }

    @Override
    public boolean isUserRef() {
        return this.bUserRefFlag;
    }

    @Override
    @PSModelRTMeta(description="\u662f\u5426\u88ab\u5f15\u7528")
    public boolean getRefFlag() {
        String strTag = String.format("PSCODELIST:%1$s:REF", this.getId());
        Object objValue = this.getPSSystem().getAttribute(strTag);
        return this.isUserRef() || this.bSysRefFlag || "1".equals(objValue);
    }

    @Override
    public void markSysRef(Object objRef, String strMemo) {
        this.bSysRefFlag = true;
        String strTag = String.format("PSCODELIST:%1$s:REF", this.getId());
        this.getPSSystem().setAttribute(strTag, "1");
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u8868\u6570\u636e", hideempty2=true, fields={"USERDATA"})
    public String getUserData() {
        return this.psCodeList.getUSERDATA();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u8868\u6570\u636e2", hideempty2=true, fields={"USERDATA2"})
    public String getUserData2() {
        return this.psCodeList.getUSERDATA2();
    }

    @Override
    public String getFetchCondition() {
        return this.psCodeList.getDSCONDITIONS();
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u5b9a\u4e49\u6761\u4ef6", hideempty2=true, fields={"DSCONDITIONS"})
    public String getCustomCond() {
        return this.psCodeList.getDSCONDITIONS();
    }

    @Override
    @PSModelRTMeta(description="\u7236\u503c\u5c5e\u6027", hideempty2=true, ignorepf=true, dumpref=true, from="IPSDataEntity", group="\u52a8\u6001\u4ee3\u7801\u8868", order=22, fields={"PVALUEPSDEFID"})
    public IPSDEField getPValuePSDEField() throws Exception {
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psCodeList.getPSDEID()) && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psCodeList.getPVALUEPSDEFID())) {
            if (this.pValuePSDEField != null) {
                return this.pValuePSDEField;
            }
            this.pValuePSDEField = this.getPSDataEntity().getPSDEField(this.psCodeList.getPVALUEPSDEFID());
            return this.pValuePSDEField;
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u7981\u7528\u503c\u5c5e\u6027", hideempty2=true, ignorepf=true, dumpref=true, from="IPSDataEntity", fields={"DISABLEPSDEFID"})
    public IPSDEField getDisablePSDEField() throws Exception {
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psCodeList.getPSDEID()) && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psCodeList.getDISABLEPSDEFID())) {
            if (this.disablePSDEField != null) {
                return this.disablePSDEField;
            }
            this.disablePSDEField = this.getPSDataEntity().getPSDEField(this.psCodeList.getDISABLEPSDEFID());
            return this.disablePSDEField;
        }
        return null;
    }

    @Override
    public int getExtendMode() {
        return this.nExtendMode;
    }

    @Override
    @PSModelRTMeta(description="\u7a7a\u767d\u663e\u793a\u6587\u672c\u8bed\u8a00\u8d44\u6e90")
    public IPSLanguageRes getEmptyTextPSLanguageRes() {
        return this.emptyTextPSLanguageRes;
    }

    @Override
    public IPSCodeList getPSCodeList() {
        return super.getPSCodeList();
    }

    @Override
    public IPSCodeItem getParentPSCodeItem() {
        return super.getParentPSCodeItem();
    }

    @Override
    public PSCodeItem getPSCodeItemData() {
        return super.getPSCodeItemData();
    }

    @Override
    public String getRealText() {
        return super.getRealText();
    }

    @Override
    public String getText() {
        return super.getText();
    }

    @Override
    public String getValue() {
        return super.getValue();
    }

    @Override
    public ICodeItem getParentCodeItem() {
        return super.getParentCodeItem();
    }

    @Override
    public String getColor() {
        return super.getColor();
    }

    @Override
    public String getIconPath() {
        return super.getIconPath();
    }

    @Override
    public String getMemo() {
        return super.getMemo();
    }

    @Override
    public String getIconCls() {
        return super.getIconCls();
    }

    @Override
    public IPSSysCss getPSSysCss() {
        return super.getPSSysCss();
    }

    @Override
    public String getTextCls() {
        return super.getTextCls();
    }

    @Override
    public IPSSysImage getPSSysImage() {
        return super.getPSSysImage();
    }

    @Override
    public String getParentValue() {
        return super.getParentValue();
    }

    @Override
    public String getIconPathX() {
        return super.getIconPathX();
    }

    @Override
    public String getIconPath(int nX) {
        return super.getIconPath(nX);
    }

    @Override
    public String getIconClsX() {
        return super.getIconClsX();
    }

    @Override
    public String getIconCls(int nX) {
        return super.getIconCls(nX);
    }

    @Override
    public boolean isDisableSelect() {
        return super.isDisableSelect();
    }

    @Override
    public IPSLanguageRes getTextPSLanguageRes() {
        return super.getTextPSLanguageRes();
    }

    @Override
    public String getTextLanResTag() {
        return super.getTextLanResTag();
    }

    @Override
    public boolean isEnableDynaSys() {
        return this.bDynamicCodeList;
    }

    @Override
    public String getModelName() {
        return this.getName();
    }

    @Override
    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSSystem());
    }

    @Override
    public String getFullModelName() {
        return this.getModelName();
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u670d\u52a1\u53d1\u5e03\u5bf9\u8c61", hideempty=true)
    public IPSSysSFPub getPSSysSFPub() {
        if (this.isSubSysCodeList()) {
            return null;
        }
        if (this.getPSSystemModule() != null) {
            return this.getPSSystemModule().getPSSysSFPub();
        }
        return this.getPSSystem().getDefaultPSSysSFPub();
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u6a21\u677f\u903b\u8f91\u7c7b\u578b", dump=false)
    public String getPFLogicCodeCat() {
        return "CODELIST";
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u6a21\u677f\u903b\u8f91\u7c7b\u578b", dump=false)
    public String getPFLogicCodeType() {
        return this.getCodeListType();
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u7cfb\u7edf\u5f15\u7528", hideempty=true, outputdoc="false")
    public IPSSysRef getPSSysRef() {
        if (this.getPSSystemModule() == null) {
            return null;
        }
        return this.getPSSystemModule().getPSSysRef();
    }

    @Override
    @PSModelRTMeta(description="\u6240\u5c5e\u7cfb\u7edf\u6807\u8bc6")
    public String getSystemTag() {
        if (this.getPSSysRef() != null) {
            return this.getPSSysRef().getSystemTag();
        }
        return this.getPSSystem().getCodeName();
    }

    @Override
    @PSModelRTMeta(description="\u5168\u90e8\u4ee3\u7801\u9879\u96c6\u5408", group="\u57fa\u672c", order=145, outputdoc="item.codeListType=='STATIC'")
    public Iterator<IPSCodeItem> getAllPSCodeItems() {
        if (this.allPSCodeItemList == null || this.allPSCodeItemList.size() == 0) {
            return null;
        }
        return this.allPSCodeItemList.iterator();
    }

    @Override
    public IPSPFPlugin getPSPFPlugin() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u7cfb\u7edf\u4ee5\u4e91\u670d\u52a1\u65b9\u5f0f\u63d0\u4f9b")
    public boolean isSubSysAsCloud() {
        return this.bSubSysAsCloud;
    }

    @Override
    public String getLinkPSDEViewId() {
        return this.strLinkPSDEViewId;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u7f13\u5b58", group="\u52a8\u6001\u4ee3\u7801\u8868", order=30)
    public boolean isEnableCache() {
        return this.bEnableCache;
    }

    @Override
    @PSModelRTMeta(description="\u7f13\u5b58\u8d85\u65f6\u65f6\u957f", ignoredumpvalues="-1", group="\u52a8\u6001\u4ee3\u7801\u8868", order=31)
    public int getCacheTimeout() {
        return this.nCacheTimeout;
    }

    @Override
    public String getData() {
        return super.getData();
    }

    @Override
    public boolean isDefault() {
        return super.isDefault();
    }

    @Override
    public String getTooltip() {
        return super.getTooltip();
    }

    @Override
    public IPSLanguageRes getTooltipPSLanguageRes() {
        return super.getTooltipPSLanguageRes();
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u52a8\u6001\u6a21\u578b", dump=false)
    public boolean isEnableDynaModel() {
        return this.getPSSystem().isEnableDynaSys();
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u5b9e\u4f8b\u6a21\u5f0f", codelist="DynaInstMode3")
    public int getDynaInstMode() {
        return this.onGetDynaInstMode();
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u5b9e\u4f8b\u6807\u8bb0")
    public String getDynaInstTag() {
        if (this.getDynaInstMode() == 0) {
            return "";
        }
        return this.onGetDynaInstTag();
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u5b9e\u4f8b\u6807\u8bb02")
    public String getDynaInstTag2() {
        if (this.getDynaInstMode() == 0) {
            return "";
        }
        return this.onGetDynaInstTag2();
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u6a21\u578b\u76ee\u5f55", hideempty=true, dump=false)
    public String getDynaModelFolder() {
        if (!this.isEnableDynaModel()) {
            return null;
        }
        if (this.getPSSystemModule() != null) {
            return String.format("%1$s/%2$s/%3$s", this.getPSSystemModule().getDynaModelFolder(), Inflector.getInstance().pluralize((Object)this.getDumpModelType()).toUpperCase(), this.getDynaModelTag());
        }
        return String.format("%1$s/%2$s", Inflector.getInstance().pluralize((Object)this.getDumpModelType()).toUpperCase(), this.getDynaModelTag());
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u6a21\u578b\u6587\u4ef6\u8def\u5f84", hideempty=true)
    public String getDynaModelFilePath() {
        if (!this.isEnableDynaModel()) {
            return null;
        }
        String strDynaModelPath = this.getDynaModelFolder();
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strDynaModelPath)) {
            return null;
        }
        return String.format("%1$s.json", strDynaModelPath, this.getDumpModelType());
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u6a21\u578b\u6807\u8bb0", hideempty=true, dump=false)
    public String getDynaModelTag() {
        if (!this.isEnableDynaModel()) {
            return null;
        }
        return this.onGetDynaModelTag();
    }

    @Override
    protected int onGetDynaInstMode() {
        return this.nDynaInstMode;
    }

    @Override
    protected String onGetDynaInstTag() {
        if (this.getPSSystemModule() != null) {
            return this.getPSSystemModule().getDynaInstTag();
        }
        return super.onGetDynaInstTag();
    }

    @Override
    public String getModelRefId() {
        String strModelRefId = this.getDynaModelFilePath();
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strModelRefId)) {
            return strModelRefId;
        }
        return this.getCodeName();
    }

    @Override
    @PSModelRTMeta(description="\u6a21\u5757\u5b9e\u4f8b\u4ee3\u7801\u8868", ignoredumpvalues="false", ignorert=3)
    public boolean isModuleInstCodeList() {
        return this.bModuleInstCodeList;
    }

    @Override
    @PSModelRTMeta(description="\u9608\u503c\u7ec4", ignoredumpvalues="false", outputdoc="item.isThresholdGroup()")
    public boolean isThresholdGroup() {
        return this.bThresholdGroup;
    }

    @Override
    @PSModelRTMeta(description="\u5f00\u59cb\u503c\u5c5e\u6027", hideempty=true, ignorepf=true, dumpref=true, from="IPSDataEntity", outputdoc="item.isThresholdGroup()")
    public IPSDEField getBeginValuePSDEField() throws Exception {
        if (!this.isThresholdGroup()) {
            return null;
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psCodeList.getPSDEID()) && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psCodeList.getBEGINVALUEPSDEFID())) {
            if (this.beginValuePSDEField != null) {
                return this.beginValuePSDEField;
            }
            this.beginValuePSDEField = this.getPSDataEntity().getPSDEField(this.psCodeList.getBEGINVALUEPSDEFID());
            return this.beginValuePSDEField;
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u7ed3\u675f\u503c\u5c5e\u6027", hideempty=true, ignorepf=true, dumpref=true, from="IPSDataEntity", outputdoc="item.isThresholdGroup()")
    public IPSDEField getEndValuePSDEField() throws Exception {
        if (!this.isThresholdGroup()) {
            return null;
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psCodeList.getPSDEID()) && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psCodeList.getENDVALUEPSDEFID())) {
            if (this.endValuePSDEField != null) {
                return this.endValuePSDEField;
            }
            this.endValuePSDEField = this.getPSDataEntity().getPSDEField(this.psCodeList.getENDVALUEPSDEFID());
            return this.endValuePSDEField;
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5305\u542b\u5f00\u59cb\u503c\u6a21\u5f0f", ignoredumpvalues="0", codelist="ThresholdIncValueMode", outputdoc="item.isThresholdGroup()")
    public int getIncBeginValueMode() {
        if (!this.isThresholdGroup()) {
            return 0;
        }
        return this.nIncBeginValueMode;
    }

    @Override
    @PSModelRTMeta(description="\u5305\u542b\u7ed3\u675f\u503c\u6a21\u5f0f", ignoredumpvalues="0", codelist="ThresholdIncValueMode", outputdoc="item.isThresholdGroup()")
    public int getIncEndValueMode() {
        if (!this.isThresholdGroup()) {
            return 0;
        }
        return this.nIncEndValueMode;
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u6269\u5c55\u63d2\u4ef6", hideempty=true)
    public IPSSysPFPlugin getPSSysPFPlugin() {
        return this.iPSSysPFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u6269\u5c55\u63d2\u4ef6", hideempty=true, ignorepf=true)
    public IPSSysSFPlugin getPSSysSFPlugin() {
        return this.iPSSysSFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u6269\u5c55\u7ed8\u5236\u5668", hideempty=true)
    public IPSXCodeObject getRender() {
        return this.iPSXCodeObject;
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u7cfb\u7edf\u6a21\u5f0f", codelist="DynaSysMode", ignoredumpvalues="0", fields={"ENABLEDYNASYS"})
    public int getDynaSysMode() {
        return this.nDynaSysMode;
    }

    @Override
    @PSModelRTMeta(description="\u9879\u6837\u5f0f\u5c5e\u6027", hideempty2=true, ignorepf=true, dumpref=true, from="IPSDataEntity", group="\u52a8\u6001\u4ee3\u7801\u8868", order=30, fields={"CLSPSDEFID"})
    public IPSDEField getClsPSDEField() throws Exception {
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psCodeList.getPSDEID()) && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psCodeList.getCLSPSDEFID())) {
            if (this.clsPSDEField != null) {
                return this.clsPSDEField;
            }
            this.clsPSDEField = this.getPSDataEntity().getPSDEField(this.psCodeList.getCLSPSDEFID());
            return this.clsPSDEField;
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u524d\u666f\u989c\u8272\u5c5e\u6027", hideempty2=true, ignorepf=true, dumpref=true, from="IPSDataEntity", group="\u52a8\u6001\u4ee3\u7801\u8868", order=30, fields={"COLORPSDEFID"})
    public IPSDEField getColorPSDEField() throws Exception {
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psCodeList.getPSDEID()) && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psCodeList.getCOLORPSDEFID())) {
            if (this.colorPSDEField != null) {
                return this.colorPSDEField;
            }
            this.colorPSDEField = this.getPSDataEntity().getPSDEField(this.psCodeList.getCOLORPSDEFID());
            return this.colorPSDEField;
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u80cc\u666f\u989c\u8272\u5c5e\u6027", hideempty2=true, ignorepf=true, dumpref=true, from="IPSDataEntity", group="\u52a8\u6001\u4ee3\u7801\u8868", order=30, fields={"BKCOLORPSDEFID"})
    public IPSDEField getBKColorPSDEField() throws Exception {
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psCodeList.getPSDEID()) && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psCodeList.getBKCOLORPSDEFID())) {
            if (this.bkColorPSDEField != null) {
                return this.bkColorPSDEField;
            }
            this.bkColorPSDEField = this.getPSDataEntity().getPSDEField(this.psCodeList.getBKCOLORPSDEFID());
            return this.bkColorPSDEField;
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u8868\u6807\u8bb0")
    public String getCodeListTag() {
        if (this.getPSSystemModule() != null) {
            if (this.getPSSystemModule().getPSSysModelGroup() != null) {
                return String.format("%1$s__%2$s__%3$s", this.getPSSystemModule().getPSSysModelGroup().getCodeName(), this.getPSSystemModule().getCodeName(), this.getCodeName());
            }
            if (this.getPSSystemModule().getPSSysRef() != null) {
                return String.format("%1$s__%2$s__%3$s", this.getPSSystemModule().getPSSysRef().getSysRefTag(), this.getPSSystemModule().getCodeName(), this.getCodeName());
            }
            return String.format("%1$s__%2$s", this.getPSSystemModule().getCodeName(), this.getCodeName());
        }
        return this.getCodeName();
    }

    @Override
    @PSModelRTMeta(description="\u5168\u90e8\u663e\u793a\u6587\u672c", fields={"ALLTEXT"})
    public String getAllText() {
        return this.strAllText;
    }

    @Override
    @PSModelRTMeta(description="\u5168\u90e8\u663e\u793a\u6587\u672c\u8bed\u8a00\u8d44\u6e90")
    public IPSLanguageRes getAllTextPSLanguageRes() {
        return this.allTextPSLanguageRes;
    }

    @Override
    protected String onGetMOSFolder() {
        if (this.getPSSystemModule() != null) {
            return String.format("%1$s/%2$s", this.getPSSystemModule().getMOSFilePath(), Inflector.getInstance().pluralize((Object)this.getModelType()).toLowerCase());
        }
        return Inflector.getInstance().pluralize((Object)this.getModelType()).toLowerCase();
    }

    @Override
    protected String onGetRTMOSFolder() {
        if (this.getPSSystemModule() != null) {
            return String.format("%1$s/%2$s", this.getPSSystemModule().getRTMOSFilePath(), Inflector.getInstance().pluralize((Object)this.getRTMOSModelType()).toLowerCase());
        }
        return Inflector.getInstance().pluralize((Object)this.getRTMOSModelType()).toLowerCase();
    }

    @Override
    protected void onFillModelNode(ObjectNode objectNode, String strModelType) throws Exception {
        super.onFillModelNode(objectNode, strModelType);
        if (!this.isThresholdGroup()) {
            objectNode.remove("incBeginValueMode");
            objectNode.remove("incEndValueMode");
            objectNode.remove("includeBeginValue");
            objectNode.remove("includeEndValue");
        }
    }
}

