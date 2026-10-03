/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Default.BaseMainPage
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.Web.WebUtility
 *  com.jspsmart.upload.SmartFile
 *  com.jspsmart.upload.SmartUpload
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.ImportSessionManager
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.JSONObjectHelper
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.paas.web.WebContext
 *  net.ibizsys.paas.web.util.SimpleWebContext
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSystem
 *  net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSystemService
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Web;

import SA.SRFDA.PS.Core.JIT.Web.PSJITWebContext;
import SA.SRFDA.Web.Default.BaseMainPage;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.Web.WebUtility;
import com.jspsmart.upload.SmartFile;
import com.jspsmart.upload.SmartUpload;
import java.io.File;
import java.util.HashMap;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ImportSessionManager;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.paas.web.util.SimpleWebContext;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class UploadIBZBakPage
extends BaseMainPage {
    protected StringBuilderEx processInfo = new StringBuilderEx();
    private static final Log log = LogFactory.getLog(UploadIBZBakPage.class);
    private PSDevSlnSys psDevSlnSys = new PSDevSlnSys();
    private SessionFactory sysSessionFactory = null;
    private static HashMap<String, String> psServiceMap = new HashMap();

    static {
        psServiceMap.put("PSDBTYPE", "net.ibizsys.pscore.srv.config.service.PSDBTypeService");
        psServiceMap.put("PSSF", "net.ibizsys.pscore.srv.config.service.PSSFService");
        psServiceMap.put("PSPF", "net.ibizsys.pscore.srv.config.service.PSPFService");
        psServiceMap.put("PSDBSYSPROCTYPE", "net.ibizsys.pscore.srv.def.service.PSDBSysProcTypeService");
        psServiceMap.put("PSDEFTYPE", "net.ibizsys.pscore.srv.config.service.PSDEFTypeService");
        psServiceMap.put("PSDEACTIONTYPE", "net.ibizsys.pscore.srv.config.service.PSDEActionTypeService");
        psServiceMap.put("PSDEUIACTIONTYPE", "net.ibizsys.pscore.srv.def.service.PSDEUIActionTypeService");
        psServiceMap.put("PSSYSUIACTION", "net.ibizsys.pscore.srv.config.service.PSSysUIActionService");
        psServiceMap.put("PSVARTYPE", "net.ibizsys.pscore.srv.config.service.PSVarTypeService");
        psServiceMap.put("PSDERTYPE", "net.ibizsys.pscore.srv.config.service.PSDERTypeService");
        psServiceMap.put("PSDEJOINTYPE", "net.ibizsys.pscore.srv.config.service.PSDEJoinTypeService");
        psServiceMap.put("PSASTYPE", "net.ibizsys.pscore.srv.def.service.PSASTypeService");
        psServiceMap.put("PSSFSTYLE", "net.ibizsys.pscore.srv.config.service.PSSFStyleService");
        psServiceMap.put("PSSFCODEFOLDER", "net.ibizsys.pscore.srv.config.service.PSSFCodeFolderService");
        psServiceMap.put("PSSFCODETYPE", "net.ibizsys.pscore.srv.config.service.PSSFCodeTypeService");
        psServiceMap.put("PSSFCODETEMPL", "net.ibizsys.pscore.srv.config.service.PSSFCodeTemplService");
        psServiceMap.put("PSDBSYSPROCTEMPL", "net.ibizsys.pscore.srv.def.service.PSDBSysProcTemplService");
        psServiceMap.put("PSDBSPPARTTEMPL", "net.ibizsys.pscore.srv.def.service.PSDBSPPartTemplService");
        psServiceMap.put("PSDEFDATATYPE", "net.ibizsys.pscore.srv.config.service.PSDEFDataTypeService");
        psServiceMap.put("PSDELNTYPE", "net.ibizsys.pscore.srv.config.service.PSDELNTypeService");
        psServiceMap.put("PSDELLTYPE", "net.ibizsys.pscore.srv.config.service.PSDELLTypeService");
        psServiceMap.put("PSDEFVRTYPE", "net.ibizsys.pscore.srv.config.service.PSDEFVRTypeService");
        psServiceMap.put("PSDEFVRTYPEDETAIL", "net.ibizsys.pscore.srv.config.service.PSDEFVRTypeDetailService");
        psServiceMap.put("PSCODELISTTEMPL", "net.ibizsys.pscore.srv.config.service.PSCodeListTemplService");
        psServiceMap.put("PSDBVALUEOP", "net.ibizsys.pscore.srv.config.service.PSDBValueOPService");
        psServiceMap.put("PSDBVALUEFUNC", "net.ibizsys.pscore.srv.config.service.PSDBValueFuncService");
        psServiceMap.put("PSDBVFCODE", "net.ibizsys.pscore.srv.config.service.PSDBVFCodeService");
        psServiceMap.put("PSMODELINIT", "net.ibizsys.pscore.srv.config.service.PSModelInitService");
        psServiceMap.put("PSMIDETAIL", "net.ibizsys.pscore.srv.config.service.PSMIDetailService");
        psServiceMap.put("PSPFCODEFOLDER", "net.ibizsys.pscore.srv.config.service.PSPFCodeFolderService");
        psServiceMap.put("PSPFSTYLE", "net.ibizsys.pscore.srv.config.service.PSPFStyleService");
        psServiceMap.put("PSPFPUBCODE", "net.ibizsys.pscore.srv.config.service.PSPFPubCodeService");
        psServiceMap.put("PSVIEWTYPE", "net.ibizsys.pscore.srv.config.service.PSViewTypeService");
        psServiceMap.put("PSCTRLTYPE", "net.ibizsys.pscore.srv.config.service.PSCtrlTypeService");
        psServiceMap.put("PSFORMTYPE", "net.ibizsys.pscore.srv.def.service.PSFormTypeService");
        psServiceMap.put("PSDEGCTYPE", "net.ibizsys.pscore.srv.config.service.PSDEGCTypeService");
        psServiceMap.put("PSEDITORTYPE", "net.ibizsys.pscore.srv.config.service.PSEditorTypeService");
        psServiceMap.put("PSTBITEMTYPE", "net.ibizsys.pscore.srv.def.service.PSTBItemTypeService");
        psServiceMap.put("PSFORMDETAILTYPE", "net.ibizsys.pscore.srv.def.service.PSFormDetailTypeService");
        psServiceMap.put("PSDRITEMTYPE", "net.ibizsys.pscore.srv.def.service.PSDRItemTypeService");
        psServiceMap.put("PSAMITEMTYPE", "net.ibizsys.pscore.srv.def.service.PSAMItemTypeService");
        psServiceMap.put("PSVTRV", "net.ibizsys.pscore.srv.config.service.PSVTRVService");
        psServiceMap.put("PSVTCTRL", "net.ibizsys.pscore.srv.config.service.PSVTCtrlService");
        psServiceMap.put("PSVTSTYLE", "net.ibizsys.pscore.srv.config.service.PSVTStyleService");
        psServiceMap.put("PSVIEWLOGICTYPE", "net.ibizsys.pscore.srv.config.service.PSViewLogicTypeService");
        psServiceMap.put("PSVIEWTYPELOGIC", "net.ibizsys.pscore.srv.config.service.PSViewTypeLogicService");
        psServiceMap.put("PSSFACHANDLER", "net.ibizsys.pscore.srv.config.service.PSSFACHandlerService");
        psServiceMap.put("PSAPPFUNCTYPE", "net.ibizsys.pscore.srv.def.service.PSAppFuncTypeService");
        psServiceMap.put("PSPFSTYLECODE", "net.ibizsys.pscore.srv.config.service.PSPFStyleCodeService");
        psServiceMap.put("PSPFVIEWTEMPL", "net.ibizsys.pscore.srv.config.service.PSPFViewTemplService");
        psServiceMap.put("PSPFCTRLTEMPL", "net.ibizsys.pscore.srv.config.service.PSPFCtrlTemplService");
        psServiceMap.put("PSPFCTDETAIL", "net.ibizsys.pscore.srv.config.service.PSPFCTDetailService");
        psServiceMap.put("PSPFEDITORTEMPL", "net.ibizsys.pscore.srv.config.service.PSPFEditorTemplService");
        psServiceMap.put("PSPFUATEMPL", "net.ibizsys.pscore.srv.config.service.PSPFUATemplService");
        psServiceMap.put("PSPFVLTEMPL", "net.ibizsys.pscore.srv.config.service.PSPFVLTemplService");
        psServiceMap.put("PSDEFVRCODETYPE", "net.ibizsys.pscore.srv.def.service.PSDEFVRCodeTypeService");
        psServiceMap.put("PSDBDEVINST", "net.ibizsys.pscore.srv.paasmgr.service.PSDBDevInstService");
        psServiceMap.put("PSACHANDLER", "net.ibizsys.pscore.srv.sysdesign.service.PSACHandlerService");
        psServiceMap.put("PSAPPCTRLSTYLE", "net.ibizsys.pscore.srv.appdesign.service.PSAppCtrlStyleService");
        psServiceMap.put("PSAPPDEVIEW", "net.ibizsys.pscore.srv.appdesign.service.PSAppDEViewService");
        psServiceMap.put("PSAPPEDITORTEMPL", "net.ibizsys.pscore.srv.appdesign.service.PSAppEditorTemplService");
        psServiceMap.put("PSAPPFUNC", "net.ibizsys.pscore.srv.appdesign.service.PSAppFuncService");
        psServiceMap.put("PSAPPINDEXVIEW", "net.ibizsys.pscore.srv.appdesign.service.PSAppIndexViewService");
        psServiceMap.put("PSAPPMENU", "net.ibizsys.pscore.srv.appdesign.service.PSAppMenuService");
        psServiceMap.put("PSAPPMENUITEM", "net.ibizsys.pscore.srv.appdesign.service.PSAppMenuItemService");
        psServiceMap.put("PSAPPMODULE", "net.ibizsys.pscore.srv.appdesign.service.PSAppModuleService");
        psServiceMap.put("PSAPPPORTALVIEW", "net.ibizsys.pscore.srv.appdesign.service.PSAppPortalViewService");
        psServiceMap.put("PSAPPVIEW", "net.ibizsys.pscore.srv.appdesign.service.PSAppViewService");
        psServiceMap.put("PSAPPVIEWCODE", "net.ibizsys.pscore.srv.appdesign.service.PSAppViewCodeService");
        psServiceMap.put("PSAPPVIEWLOGIC", "net.ibizsys.pscore.srv.appdesign.service.PSAppViewLogicService");
        psServiceMap.put("PSAPPVIEWREF", "net.ibizsys.pscore.srv.appdesign.service.PSAppViewRefService");
        psServiceMap.put("PSAPPVIEWSTYLE", "net.ibizsys.pscore.srv.appdesign.service.PSAppViewStyleService");
        psServiceMap.put("PSAPPVIEWTEMPL", "net.ibizsys.pscore.srv.appdesign.service.PSAppViewTemplService");
        psServiceMap.put("PSCODEITEM", "net.ibizsys.pscore.srv.sysdesign.service.PSCodeItemService");
        psServiceMap.put("PSCODELIST", "net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService");
        psServiceMap.put("PSDATAENTITY", "net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService");
        psServiceMap.put("PSDBPROCPARAM", "net.ibizsys.pscore.srv.def.service.PSDBProcParamService");
        psServiceMap.put("PSDEACMODE", "net.ibizsys.pscore.srv.dedesign.service.PSDEACModeService");
        psServiceMap.put("PSDEACTION", "net.ibizsys.pscore.srv.dedesign.service.PSDEActionService");
        psServiceMap.put("PSDEACTIONLOGIC", "net.ibizsys.pscore.srv.dedesign.service.PSDEActionLogicService");
        psServiceMap.put("PSDECTRL", "net.ibizsys.pscore.srv.dedesign.service.PSDECtrlService");
        psServiceMap.put("PSDEDATAQUERY", "net.ibizsys.pscore.srv.dedesign.service.PSDEDataQueryService");
        psServiceMap.put("PSDEDATARELATION", "net.ibizsys.pscore.srv.dedesign.service.PSDEDataRelationService");
        psServiceMap.put("PSDEDATASET", "net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService");
        psServiceMap.put("PSDEDBCFG", "net.ibizsys.pscore.srv.dedesign.service.PSDEDBCfgService");
        psServiceMap.put("PSDEDBOBJSQL", "net.ibizsys.pscore.srv.dedesign.service.PSDEDBObjSqlService");
        psServiceMap.put("PSDEDQCODE", "net.ibizsys.pscore.srv.dedesign.service.PSDEDQCodeService");
        psServiceMap.put("PSDEDQCODEEXP", "net.ibizsys.pscore.srv.dedesign.service.PSDEDQCodeExpService");
        psServiceMap.put("PSDEDQCOND", "net.ibizsys.pscore.srv.dedesign.service.PSDEDQCondService");
        psServiceMap.put("PSDEDQJOIN", "net.ibizsys.pscore.srv.dedesign.service.PSDEDQJoinService");
        psServiceMap.put("PSDEDRDETAIL", "net.ibizsys.pscore.srv.dedesign.service.PSDEDRDetailService");
        psServiceMap.put("PSDEDRGROUP", "net.ibizsys.pscore.srv.dedesign.service.PSDEDRGroupService");
        psServiceMap.put("PSDEDRITEM", "net.ibizsys.pscore.srv.dedesign.service.PSDEDRItemService");
        psServiceMap.put("PSDEDSCODE", "net.ibizsys.pscore.srv.dedesign.service.PSDEDSCodeService");
        psServiceMap.put("PSDEDSDQ", "net.ibizsys.pscore.srv.dedesign.service.PSDEDSDQService");
        psServiceMap.put("PSDEDSPARAM", "net.ibizsys.pscore.srv.dedesign.service.PSDEDSParamService");
        psServiceMap.put("PSDEDUPRULE", "net.ibizsys.pscore.srv.dedesign.service.PSDEDUPRuleService");
        psServiceMap.put("PSDEDUPRULEITEM", "net.ibizsys.pscore.srv.dedesign.service.PSDEDUPRuleItemService");
        psServiceMap.put("PSDEFDTCOL", "net.ibizsys.pscore.srv.dedesign.service.PSDEFDTColService");
        psServiceMap.put("PSDEFFORMITEM", "net.ibizsys.pscore.srv.dedesign.service.PSDEFUIModeService");
        psServiceMap.put("PSDEFGRIDCOL", "net.ibizsys.pscore.srv.dedesign.service.PSDEFGridColService");
        psServiceMap.put("PSDEFIELD", "net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService");
        psServiceMap.put("PSDEFIVR", "net.ibizsys.pscore.srv.dedesign.service.PSDEFIVRService");
        psServiceMap.put("PSDEFORM", "net.ibizsys.pscore.srv.dedesign.service.PSDEFormService");
        psServiceMap.put("PSDEFORMDETAIL", "net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailService");
        psServiceMap.put("PSDEFSFITEM", "net.ibizsys.pscore.srv.dedesign.service.PSDEFSFItemService");
        psServiceMap.put("PSDEFVALUERULE", "net.ibizsys.pscore.srv.dedesign.service.PSDEFValueRuleService");
        psServiceMap.put("PSDEFVRCOND", "net.ibizsys.pscore.srv.dedesign.service.PSDEFVRCondService");
        psServiceMap.put("PSDEFVRDSPARAM", "net.ibizsys.pscore.srv.dedesign.service.PSDEFVRDSParamService");
        psServiceMap.put("PSDEGRID", "net.ibizsys.pscore.srv.dedesign.service.PSDEGridService");
        psServiceMap.put("PSDEGRIDCOL", "net.ibizsys.pscore.srv.dedesign.service.PSDEGridColService");
        psServiceMap.put("PSDELOGIC", "net.ibizsys.pscore.srv.dedesign.service.PSDELogicService");
        psServiceMap.put("PSDELOGICLINK", "net.ibizsys.pscore.srv.dedesign.service.PSDELogicLinkService");
        psServiceMap.put("PSDELOGICNODE", "net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeService");
        psServiceMap.put("PSDEOPPRIV", "net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivService");
        psServiceMap.put("PSDER", "net.ibizsys.pscore.srv.dedesign.service.PSDERService");
        psServiceMap.put("PSDESPCODE", "net.ibizsys.pscore.srv.dedesign.service.PSDESPCodeService");
        psServiceMap.put("PSDESPCODEPART", "net.ibizsys.pscore.srv.dedesign.service.PSDESPCodePartService");
        psServiceMap.put("PSDESPFIELD", "net.ibizsys.pscore.srv.dedesign.service.PSDESPFieldService");
        psServiceMap.put("PSDESYSPROC", "net.ibizsys.pscore.srv.dedesign.service.PSDESysProcService");
        psServiceMap.put("PSDETBITEM", "net.ibizsys.pscore.srv.dedesign.service.PSDETBItemService");
        psServiceMap.put("PSDETOOLBAR", "net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarService");
        psServiceMap.put("PSDEUIACTION", "net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService");
        psServiceMap.put("PSDEVCENTER", "net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService");
        psServiceMap.put("PSDEVIEWBASE", "net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService");
        psServiceMap.put("PSDEVIEWCTRL", "net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlService");
        psServiceMap.put("PSDEVIEWLOGIC", "net.ibizsys.pscore.srv.dedesign.service.PSDEViewLogicService");
        psServiceMap.put("PSDEVIEWRV", "net.ibizsys.pscore.srv.dedesign.service.PSDEViewRVService");
        psServiceMap.put("PSDEVRGROUP", "net.ibizsys.pscore.srv.dedesign.service.PSDEVRGroupService");
        psServiceMap.put("PSDEVRGRPDETAIL", "net.ibizsys.pscore.srv.dedesign.service.PSDEVRGrpDetailService");
        psServiceMap.put("PSDEVSLN", "net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService");
        psServiceMap.put("PSMODULE", "net.ibizsys.pscore.srv.sysdesign.service.PSModuleService");
        psServiceMap.put("PSSYSAPP", "net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService");
        psServiceMap.put("PSSYSDBCHGLOG", "net.ibizsys.pscore.srv.sysdesign.service.PSSysModelChgLogService");
        psServiceMap.put("PSSYSDBVF", "net.ibizsys.pscore.srv.sysdesign.service.PSSysDBVFService");
        psServiceMap.put("PSSYSDBVFCODE", "net.ibizsys.pscore.srv.sysdesign.service.PSSysDBVFCodeService");
        psServiceMap.put("PSSYSDEPLOY", "net.ibizsys.pscore.srv.sysdesign.service.PSSysDeployService");
        psServiceMap.put("PSSYSDEPLOYAS", "net.ibizsys.pscore.srv.sysdesign.service.PSSysDeployASService");
        psServiceMap.put("PSSYSDEPLOYDB", "net.ibizsys.pscore.srv.sysdesign.service.PSSysDeployDBService");
        psServiceMap.put("PSSYSEDITORSTYLE", "net.ibizsys.pscore.srv.sysdesign.service.PSSysEditorStyleService");
        psServiceMap.put("PSSYSIMAGE", "net.ibizsys.pscore.srv.sysdesign.service.PSSysImageService");
        psServiceMap.put("PSSYSSFCODE", "net.ibizsys.pscore.srv.sysdesign.service.PSSysSFCodeService");
        psServiceMap.put("PSSYSSFPUB", "net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPubService");
        psServiceMap.put("PSSYSTEM", "net.ibizsys.pscore.srv.sysdesign.service.PSSystemService");
        psServiceMap.put("PSSYSTEMDBCFG", "net.ibizsys.pscore.srv.sysdesign.service.PSSystemDBCfgService");
        psServiceMap.put("PSV3MIGRATE", "net.ibizsys.pscore.srv.def.service.PSV3MigrateService");
        psServiceMap.put("PSV3MIGRATEDE", "net.ibizsys.pscore.srv.def.service.PSV3MigrateDEService");
        psServiceMap.put("PSPORTLET", "net.ibizsys.pscore.srv.config.service.PSPortletService");
        psServiceMap.put("PSSYSTOOLBAR", "net.ibizsys.pscore.srv.config.service.PSSysToolbarService");
        psServiceMap.put("PSSYSTBITEM", "net.ibizsys.pscore.srv.config.service.PSSysTBItemService");
        psServiceMap.put("PSSYSACHANDLER", "net.ibizsys.pscore.srv.config.service.PSSysACHandlerService");
        psServiceMap.put("PSV3MGFORM", "net.ibizsys.pscore.srv.def.service.PSV3MGFormService");
        psServiceMap.put("PSV3MGGRID", "net.ibizsys.pscore.srv.def.service.PSV3MGGridService");
        psServiceMap.put("PSV3MGVIEW", "net.ibizsys.pscore.srv.def.service.PSV3MGViewService");
        psServiceMap.put("PSDEFDLOGIC", "net.ibizsys.pscore.srv.dedesign.service.PSDEFDLogicService");
        psServiceMap.put("PSDEFIUPDATE", "net.ibizsys.pscore.srv.dedesign.service.PSDEFIUpdateService");
        psServiceMap.put("PSUAWIZARD", "net.ibizsys.pscore.srv.dedesign.service.PSDEUAWizardService");
        psServiceMap.put("PSDELOGICPARAM", "net.ibizsys.pscore.srv.dedesign.service.PSDELogicParamService");
        psServiceMap.put("PSDELLCOND", "net.ibizsys.pscore.srv.dedesign.service.PSDELLCondService");
        psServiceMap.put("PSDELLCONDTYPE", "net.ibizsys.pscore.srv.config.service.PSDELLCondTypeService");
        psServiceMap.put("PSDELNPARAM", "net.ibizsys.pscore.srv.dedesign.service.PSDELNParamService");
        psServiceMap.put("PSDEFIUDETAIL", "net.ibizsys.pscore.srv.dedesign.service.PSDEFIUDetailService");
        psServiceMap.put("PSDEUAGROUP", "net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService");
        psServiceMap.put("PSDEUAGRPDETAIL", "net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupDetailService");
        psServiceMap.put("PSDEFORMRF", "net.ibizsys.pscore.srv.dedesign.service.PSDEFormRFService");
        psServiceMap.put("PSDEDATAVIEW", "net.ibizsys.pscore.srv.dedesign.service.PSDEDataViewService");
        psServiceMap.put("PSSYSVALUERULE", "net.ibizsys.pscore.srv.sysdesign.service.PSSysValueRuleService");
        psServiceMap.put("PSVALUERULE", "net.ibizsys.pscore.srv.config.service.PSValueRuleService");
        psServiceMap.put("PSSYSREFDE", "net.ibizsys.pscore.srv.sysdesign.service.PSSysRefDEService");
        psServiceMap.put("PSSYSREF", "net.ibizsys.pscore.srv.sysdesign.service.PSSysRefService");
        psServiceMap.put("PSDEMAPDETAIL", "net.ibizsys.pscore.srv.dedesign.service.PSDEMapDetailService");
        psServiceMap.put("PSDEMAP", "net.ibizsys.pscore.srv.dedesign.service.PSDEMapService");
        psServiceMap.put("PSSYSISSUE", "net.ibizsys.pscore.srv.sysdesign.service.PSSysIssueService");
        psServiceMap.put("PSDEVUSERGROUP", "net.ibizsys.pscore.srv.devcenter.service.PSDevUserGroupService");
        psServiceMap.put("PSDEVUSER", "net.ibizsys.pscore.srv.devcenter.service.PSDevUserService");
        psServiceMap.put("PSDEVUSEROBJ", "net.ibizsys.pscore.srv.devcenter.service.PSDevUserObjService");
        psServiceMap.put("PSWFPROCESSTYPE", "net.ibizsys.pscore.srv.config.service.PSWFProcessTypeService");
        psServiceMap.put("PSWFLINKTYPE", "net.ibizsys.pscore.srv.config.service.PSWFLinkTypeService");
        psServiceMap.put("PSWFLINKCONDTYPE", "net.ibizsys.pscore.srv.config.service.PSWFLinkCondTypeService");
        psServiceMap.put("PSWFVERSION", "net.ibizsys.pscore.srv.wfdesign.service.PSWFVersionService");
        psServiceMap.put("PSWFROLE", "net.ibizsys.pscore.srv.wfdesign.service.PSWFRoleService");
        psServiceMap.put("PSWFDE", "net.ibizsys.pscore.srv.wfdesign.service.PSWFDEService");
        psServiceMap.put("PSWFPROCESS", "net.ibizsys.pscore.srv.wfdesign.service.PSWFProcessService");
        psServiceMap.put("PSWFLINK", "net.ibizsys.pscore.srv.wfdesign.service.PSWFLinkService");
        psServiceMap.put("PSWFWORKTIME", "net.ibizsys.pscore.srv.wfdesign.service.PSWFWorkTimeService");
        psServiceMap.put("PSWFSUBWF", "net.ibizsys.pscore.srv.wfdesign.service.PSWFSubWFService");
        psServiceMap.put("PSWFPROCROLE", "net.ibizsys.pscore.srv.wfdesign.service.PSWFProcRoleService");
        psServiceMap.put("PSWFLINKCOND", "net.ibizsys.pscore.srv.wfdesign.service.PSWFLinkCondService");
        psServiceMap.put("PSWORKFLOW", "net.ibizsys.pscore.srv.wfdesign.service.PSWorkflowService");
        psServiceMap.put("PSWFPROCSUBWF", "net.ibizsys.pscore.srv.wfdesign.service.PSWFProcSubWFService");
        psServiceMap.put("PSWFLINKROLE", "net.ibizsys.pscore.srv.wfdesign.service.PSWFLinkRoleService");
        psServiceMap.put("PSWFPROCPARAM", "net.ibizsys.pscore.srv.wfdesign.service.PSWFProcParamService");
        psServiceMap.put("PSDETREEVIEW", "net.ibizsys.pscore.srv.dedesign.service.PSDETreeViewService");
        psServiceMap.put("PSDETREENODE", "net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeService");
        psServiceMap.put("PSDETREENODERS", "net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeRSService");
        psServiceMap.put("PSIMAGETEMPL", "net.ibizsys.pscore.srv.config.service.PSImageTemplService");
        psServiceMap.put("PSSYSREPORT", "net.ibizsys.pscore.srv.sysdesign.service.PSSysReportService");
        psServiceMap.put("PSDEPRINT", "net.ibizsys.pscore.srv.dedesign.service.PSDEPrintService");
        psServiceMap.put("PSPORTLETTYPE", "net.ibizsys.pscore.srv.config.service.PSPortletTypeService");
        psServiceMap.put("PSSYSPORTLET", "net.ibizsys.pscore.srv.sysdesign.service.PSSysPortletService");
        psServiceMap.put("PSCHARTTYPE", "net.ibizsys.pscore.srv.config.service.PSChartTypeService");
        psServiceMap.put("PSDECHART", "net.ibizsys.pscore.srv.dedesign.service.PSDEChartService");
        psServiceMap.put("PSDECHARTPARAM", "net.ibizsys.pscore.srv.dedesign.service.PSDEChartParamService");
        psServiceMap.put("PSDEDSGRPPARAM", "net.ibizsys.pscore.srv.dedesign.service.PSDEDSGrpParamService");
        psServiceMap.put("PSDEDSPARAM", "net.ibizsys.pscore.srv.dedesign.service.PSDEDSParamService");
        psServiceMap.put("PSDECHARTAXES", "net.ibizsys.pscore.srv.dedesign.service.PSDEChartAxesService");
        psServiceMap.put("PSAPPPVPART", "net.ibizsys.pscore.srv.appdesign.service.PSAppPVPartService");
        psServiceMap.put("PSMODELOBJ", "net.ibizsys.pscore.srv.sysdesign.service.PSModelObjService");
        psServiceMap.put("PSLISTITEMTYPE", "net.ibizsys.pscore.srv.config.service.PSListItemTypeService");
        psServiceMap.put("PSDELISTITEM", "net.ibizsys.pscore.srv.dedesign.service.PSDEListItemService");
        psServiceMap.put("PSDELIST", "net.ibizsys.pscore.srv.dedesign.service.PSDEListService");
        psServiceMap.put("PSDEDQCODECOND", "net.ibizsys.pscore.srv.dedesign.service.PSDEDQCodeCondService");
        psServiceMap.put("PSSYSUSERMODE", "net.ibizsys.pscore.srv.sysdesign.service.PSSysUserModeService");
        psServiceMap.put("PSDEVSERVERLEASE", "net.ibizsys.pscore.srv.devcenter.service.PSDevServerLeaseService");
        psServiceMap.put("PSDEVCENTERSERVER", "net.ibizsys.pscore.srv.devcenter.service.PSDevCenterServerService");
        psServiceMap.put("PSDEVCENTERDBINST", "net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService");
        psServiceMap.put("PSDEVCENTERSRV", "net.ibizsys.pscore.srv.devcenter.service.PSDevCenterSrvService");
        psServiceMap.put("PSDEVSERVER", "net.ibizsys.pscore.srv.paasmgr.service.PSDevServerService");
        psServiceMap.put("PSDBSERVER", "net.ibizsys.pscore.srv.paasmgr.service.PSDBServerService");
        psServiceMap.put("PSSVRSERVER", "net.ibizsys.pscore.srv.paasmgr.service.PSSvrServerService");
        psServiceMap.put("PSAPPUSERMODE", "net.ibizsys.pscore.srv.appdesign.service.PSAppUserModeService");
        psServiceMap.put("PSDBVALUEMODE", "net.ibizsys.pscore.srv.config.service.PSDBValueModeService");
        psServiceMap.put("PSDEMAINSTATE", "net.ibizsys.pscore.srv.dedesign.service.PSDEMainStateService");
        psServiceMap.put("PSDCSERVERSTATE", "net.ibizsys.pscore.srv.appdesign.service.PSDCServerStateService");
        psServiceMap.put("PSAPPTYPE", "net.ibizsys.pscore.srv.config.service.PSAppTypeService");
        psServiceMap.put("PSDEVENV", "net.ibizsys.pscore.srv.config.service.PSDevEnvService");
        psServiceMap.put("PSSYSDSACTIONTYPE", "net.ibizsys.pscore.srv.config.service.PSSysDSActoinTypeService");
        psServiceMap.put("PSSYSDSACTION", "net.ibizsys.pscore.srv.sysdevstudio.service.PSSysDSActionService");
        psServiceMap.put("PSSYSDEVINFOTYPE", "net.ibizsys.pscore.srv.config.service.PSSysDevInfoTypeService");
        psServiceMap.put("PSSYSDEVBTTYPE", "net.ibizsys.pscore.srv.config.service.PSSysDevBTTypeService");
        psServiceMap.put("PSSYSDEVBKTASK", "net.ibizsys.pscore.srv.sysdevstudio.service.PSSysDevBKTaskService");
        psServiceMap.put("PSSYSDEVINFO", "net.ibizsys.pscore.srv.sysdevstudio.service.PSSysDevInfoService");
        psServiceMap.put("PSSYSDEVSTUDIO", "net.ibizsys.pscore.srv.sysdevstudio.service.PSSysDevStudioService");
        psServiceMap.put("PSSYSDEPLOYAPP", "net.ibizsys.pscore.srv.sysdesign.service.PSSysDeployAppService");
        psServiceMap.put("PSDEVCENTERAS", "net.ibizsys.pscore.srv.devcenter.service.PSDevCenterASService");
        psServiceMap.put("PSAPPSERVER", "net.ibizsys.pscore.srv.paasmgr.service.PSAppServerService");
        psServiceMap.put("PSSYSDBDETAIL", "net.ibizsys.pscore.srv.sysdesign.service.PSSysDBDetailService");
        psServiceMap.put("PSPFAPPTEMPL", "net.ibizsys.pscore.srv.config.service.PSPFAppTemplService");
        psServiceMap.put("PSVIEWTYPECAT", "net.ibizsys.pscore.srv.config.service.PSViewTypeCatService");
        psServiceMap.put("PSSUBAPPVIEW", "net.ibizsys.pscore.srv.config.service.PSSubAppViewService");
        psServiceMap.put("PSSUBSYSSF", "net.ibizsys.pscore.srv.config.service.PSSubSysSFService");
        psServiceMap.put("PSSUBAPP", "net.ibizsys.pscore.srv.config.service.PSSubAppService");
        psServiceMap.put("PSSUBDEACTION", "net.ibizsys.pscore.srv.config.service.PSSubDEActionService");
        psServiceMap.put("PSSUBDE", "net.ibizsys.pscore.srv.config.service.PSSubDEService");
        psServiceMap.put("PSSUBSYS", "net.ibizsys.pscore.srv.config.service.PSSubSysService");
        psServiceMap.put("PSPRODUCTTYPE", "net.ibizsys.pscore.srv.config.service.PSProductTypeService");
        psServiceMap.put("PSSYSPRDVER", "net.ibizsys.pscore.srv.paasmgr.service.PSSysPrdVerService");
        psServiceMap.put("PSSVRPROVIDER", "net.ibizsys.pscore.srv.paasmgr.service.PSSvrProviderService");
        psServiceMap.put("PSSYSPRODUCT", "net.ibizsys.pscore.srv.paasmgr.service.PSSysProductService");
        psServiceMap.put("PSPRODUCT", "net.ibizsys.pscore.srv.paasmgr.service.PSProductService");
        psServiceMap.put("PSDCSYSPRDVER", "net.ibizsys.pscore.srv.devcenter.service.PSDCSysPrdVerService");
        psServiceMap.put("PSDCSYSPRODUCT", "net.ibizsys.pscore.srv.devcenter.service.PSDCSysProductService");
        psServiceMap.put("PSDCPRODUCT", "net.ibizsys.pscore.srv.devcenter.service.PSDCProductService");
        psServiceMap.put("PSDCSYSRES", "net.ibizsys.pscore.srv.devcenter.service.PSDCSysResService");
        psServiceMap.put("PSDEVSLNSYS", "net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService");
        psServiceMap.put("PSSYSMODELINST", "net.ibizsys.pscore.srv.paasmgr.service.PSSysModelInstService");
        psServiceMap.put("PSSYSDMITEM", "net.ibizsys.pscore.srv.sysdesign.service.PSSysDMItemService");
        psServiceMap.put("PSDBOBJTYPE", "net.ibizsys.pscore.srv.config.service.PSDBObjTypeService");
        psServiceMap.put("PSUAWIZARD2", "net.ibizsys.pscore.srv.sysdevstudio.service.PSUAWizard2Service");
        psServiceMap.put("PSSYSMODELACTION", "net.ibizsys.pscore.srv.config.service.PSSysModelActionService");
        psServiceMap.put("PSSYSMODELVER", "net.ibizsys.pscore.srv.config.service.PSSysModelVerService");
        psServiceMap.put("PSTASKSERVER", "net.ibizsys.pscore.srv.paasmgr.service.PSTaskServerService");
        psServiceMap.put("PSDEVCENTERTS", "net.ibizsys.pscore.srv.devcenter.service.PSDevCenterTSService");
        psServiceMap.put("PSSYSTEMAS", "net.ibizsys.pscore.srv.sysdesign.service.PSSystemASService");
        psServiceMap.put("PSSYSRUNLOG", "net.ibizsys.pscore.srv.sysdesign.service.PSSysRunLogService");
        psServiceMap.put("PSSYSRUNSESSION", "net.ibizsys.pscore.srv.sysdesign.service.PSSysRunSessionService");
        psServiceMap.put("PSSYSTEMRUN", "net.ibizsys.pscore.srv.sysdesign.service.PSSystemRunService");
        psServiceMap.put("PSDEVCENTERSVN", "net.ibizsys.pscore.srv.devcenter.service.PSDevCenterSVNService");
        psServiceMap.put("PSSVNINSTREPO", "net.ibizsys.pscore.srv.paasmgr.service.PSSVNInstRepoService");
        psServiceMap.put("PSMQINST", "net.ibizsys.pscore.srv.paasmgr.service.PSMQInstService");
        psServiceMap.put("PSDEVCENTERMQ", "net.ibizsys.pscore.srv.devcenter.service.PSDevCenterMQService");
        psServiceMap.put("PSSYSTEMMQ", "net.ibizsys.pscore.srv.sysdesign.service.PSSystemMQService");
        psServiceMap.put("PSDEVSLNUSER", "net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnUserService");
        psServiceMap.put("PSSUBSYSDM", "net.ibizsys.pscore.srv.config.service.PSSubSysDMService");
        psServiceMap.put("PSDCINST", "net.ibizsys.pscore.srv.paasmgr.service.PSDCInstService");
        psServiceMap.put("PSDEVSLNSYSVER", "net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysVerService");
        psServiceMap.put("PSDEVSYSDIFFREP", "net.ibizsys.pscore.srv.sysdesign.service.PSDevSysDiffRepService");
        psServiceMap.put("PSDEVSYSDIFFITEM", "net.ibizsys.pscore.srv.sysdesign.service.PSDevSysDiffItemService");
        psServiceMap.put("PSDEPSLN", "net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnService");
        psServiceMap.put("PSDEPSLNPRD", "net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnPrdService");
        psServiceMap.put("PSDEPSLNDBINST", "net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnDBInstService");
        psServiceMap.put("PSDEPSLNAS", "net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnASService");
        psServiceMap.put("PSDEPSLNASGRP", "net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnASGroupService");
        psServiceMap.put("PSDEPSLNASITEM", "net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnASItemService");
        psServiceMap.put("PSDEPSLNMODE", "net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnModeService");
        psServiceMap.put("PSDEPSLNMODEPRD", "net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnModePrdService");
        psServiceMap.put("PSDEPSLNLOG", "net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnLogService");
        psServiceMap.put("PSDEPSLNRUNLOG", "net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnRunLogService");
        psServiceMap.put("PSDEVUSERRECENT", "net.ibizsys.pscore.srv.devcenter.service.PSDevUserRecentService");
        psServiceMap.put("PSCSSTEMPL", "net.ibizsys.pscore.srv.config.service.PSCssTemplService");
        psServiceMap.put("PSSYSCSS", "net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService");
        psServiceMap.put("PSDEACMODEITEM", "net.ibizsys.pscore.srv.dedesign.service.PSDEACModeItemService");
        psServiceMap.put("PSCSSCATTEMPL", "net.ibizsys.pscore.srv.config.service.PSCssCatTemplService");
        psServiceMap.put("PSSYSCSSCAT", "net.ibizsys.pscore.srv.sysdesign.service.PSSysCssCatService");
        psServiceMap.put("PSDEMSACTION", "net.ibizsys.pscore.srv.dedesign.service.PSDEMSActionService");
        psServiceMap.put("PSSYSORGTYPE", "net.ibizsys.pscore.srv.sysdesign.service.PSSysOrgTypeService");
        psServiceMap.put("PSSYSOUTYPE", "net.ibizsys.pscore.srv.sysdesign.service.PSSysOUTypeService");
        psServiceMap.put("PSSYSOUTYPERS", "net.ibizsys.pscore.srv.sysdesign.service.PSSysOUTypeRSService");
        psServiceMap.put("PSSYSOPPRIV", "net.ibizsys.pscore.srv.sysdesign.service.PSSysOPPrivService");
        psServiceMap.put("PSSUBDEVIEW", "net.ibizsys.pscore.srv.config.service.PSSubDEViewService");
        psServiceMap.put("PSPDTVIEW", "net.ibizsys.pscore.srv.config.service.PSPDTViewService");
        psServiceMap.put("PSSYSPDTVIEW", "net.ibizsys.pscore.srv.sysdesign.service.PSSysPDTViewService");
        psServiceMap.put("PSAPPSUBAPP", "net.ibizsys.pscore.srv.appdesign.service.PSAppSubAppService");
        psServiceMap.put("PSDEDQPDCOND", "net.ibizsys.pscore.srv.config.service.PSDEDQPDCondService");
        psServiceMap.put("PSSYSPFPITEMPL", "net.ibizsys.pscore.srv.sysdesign.service.PSSysPFPITemplService");
        psServiceMap.put("PSSYSPFPLUGIN", "net.ibizsys.pscore.srv.config.service.PSSysPFPluginService");
        psServiceMap.put("PSPFPLUGINTYPE", "net.ibizsys.pscore.srv.config.service.PSPFPluginTypeService");
        psServiceMap.put("PSPFPLUGINTEMPL", "net.ibizsys.pscore.srv.config.service.PSPFPluginTemplService");
        psServiceMap.put("PSPFPLUGIN", "net.ibizsys.pscore.srv.config.service.PSPFPluginService");
        psServiceMap.put("PSCOUNTERTYPESF", "net.ibizsys.pscore.srv.config.service.PSCounterTypeSFService");
        psServiceMap.put("PSSYSCOUNTER", "net.ibizsys.pscore.srv.sysdesign.service.PSSysCounterService");
        psServiceMap.put("PSCOUNTERTYPE", "net.ibizsys.pscore.srv.config.service.PSCounterTypeService");
        psServiceMap.put("PSCOUNTER", "net.ibizsys.pscore.srv.config.service.PSCounterService");
        psServiceMap.put("PSAPPUTILPAGE", "net.ibizsys.pscore.srv.appdesign.service.PSAppUtilPageService");
        psServiceMap.put("PSSUBVIEWTYPE", "net.ibizsys.pscore.srv.sysdesign.service.PSSubViewTypeService");
        psServiceMap.put("PSSYSDICTCAT", "net.ibizsys.pscore.srv.sysdesign.service.PSSysDictCatService");
        psServiceMap.put("PSAPPUITHEME", "net.ibizsys.pscore.srv.appdesign.service.PSAppUIThemeService");
        psServiceMap.put("PSAPPUISTYLE", "net.ibizsys.pscore.srv.appdesign.service.PSAppUIStyleService");
        psServiceMap.put("PSSYSUNISTATE", "net.ibizsys.pscore.srv.sysdesign.service.PSSysUniStateService");
        psServiceMap.put("PSSYSUNIRES", "net.ibizsys.pscore.srv.sysdesign.service.PSSysUniResService");
        psServiceMap.put("PSDEDATAEXP", "net.ibizsys.pscore.srv.dedesign.service.PSDEDataExpService");
        psServiceMap.put("PSDEDATAIMP", "net.ibizsys.pscore.srv.dedesign.service.PSDEDataImpService");
        psServiceMap.put("PSSYSMSGTEMPL", "net.ibizsys.pscore.srv.sysdesign.service.PSSysMsgTemplService");
        psServiceMap.put("PSBACKSERVICE", "net.ibizsys.pscore.srv.config.service.PSBackServiceService");
        psServiceMap.put("PSSYSBACKSERVICE", "net.ibizsys.pscore.srv.sysdesign.service.PSSysBackServiceService");
        psServiceMap.put("PSSYSWFSETTING", "net.ibizsys.pscore.srv.wfdesign.service.PSSysWFSettingService");
        psServiceMap.put("PSDEDBINDEX", "net.ibizsys.pscore.srv.dedesign.service.PSDEDBIndexService");
        psServiceMap.put("PSDEDBIDXFIELD", "net.ibizsys.pscore.srv.dedesign.service.PSDEDBIdxFieldService");
        psServiceMap.put("PSDEMODELCNT", "net.ibizsys.pscore.srv.dedesign.service.PSDEModelCntService");
        psServiceMap.put("PSDEREPORT", "net.ibizsys.pscore.srv.dedesign.service.PSDEReportService");
        psServiceMap.put("PSDEREPITEM", "net.ibizsys.pscore.srv.dedesign.service.PSDERepItemService");
        psServiceMap.put("PSDEVCENTERRES", "net.ibizsys.pscore.srv.devcenter.service.PSDevCenterResService");
        psServiceMap.put("PSDEVCENTERLOG", "net.ibizsys.pscore.srv.devcenter.service.PSDevCenterLogService");
        psServiceMap.put("PSDCBULLETIN", "net.ibizsys.pscore.srv.devcenter.service.PSDCBulletinService");
        psServiceMap.put("PSSUBSYSVER", "net.ibizsys.pscore.srv.config.service.PSSubSysVerService");
        psServiceMap.put("PSSVNSERVER", "net.ibizsys.pscore.srv.paasmgr.service.PSSVNServerService");
        psServiceMap.put("PSSYSISSUEENGINE", "net.ibizsys.pscore.srv.config.service.PSSysIssueEngineService");
        psServiceMap.put("PSSYSISSUETYPE", "net.ibizsys.pscore.srv.config.service.PSSysIssueTypeService");
        psServiceMap.put("PSROSSERVER", "net.ibizsys.pscore.srv.paasmgr.service.PSROSServerService");
        psServiceMap.put("PSCTRLTYPEACTION", "net.ibizsys.pscore.srv.config.service.PSCtrlTypeActionService");
        psServiceMap.put("PSCTRLTYPEEVENT", "net.ibizsys.pscore.srv.config.service.PSCtrlTypeEventService");
        psServiceMap.put("PSCTRLACTION", "net.ibizsys.pscore.srv.config.service.PSCtrlActionService");
        psServiceMap.put("PSCTRLEVENT", "net.ibizsys.pscore.srv.config.service.PSCtrlEventService");
        psServiceMap.put("PSSYSVIEWLOGIC", "net.ibizsys.pscore.srv.sysdesign.service.PSSysViewLogicService");
        psServiceMap.put("PSVTCATDETAIL", "net.ibizsys.pscore.srv.config.service.PSVTCatDetailService");
        psServiceMap.put("PSDEVCENTERPF", "net.ibizsys.pscore.srv.devcenter.service.PSDevCenterPFService");
        psServiceMap.put("PSEDITORSTYLE", "net.ibizsys.pscore.srv.config.service.PSEditorStyleService");
        psServiceMap.put("PSSYSCTRLSTYLE", "net.ibizsys.pscore.srv.sysdesign.service.PSSysCtrlStyleService");
        psServiceMap.put("PSSYSUSERCASERS", "net.ibizsys.pscore.srv.sysdesign.service.PSSysUserCaseRSService");
        psServiceMap.put("PSSYSUSERCASE", "net.ibizsys.pscore.srv.sysdesign.service.PSSysUserCaseService");
        psServiceMap.put("PSSYSACTOR", "net.ibizsys.pscore.srv.sysdesign.service.PSSysActorService");
        psServiceMap.put("PSMODELAPIRS", "net.ibizsys.pscore.srv.dedesign.service.PSModelAPIRSService");
        psServiceMap.put("PSMODELAPIMETHOD", "net.ibizsys.pscore.srv.config.service.PSModelAPIMethodService");
        psServiceMap.put("PSMODELAPIINT", "net.ibizsys.pscore.srv.config.service.PSModelAPIIntService");
        psServiceMap.put("PSMODELAPI", "net.ibizsys.pscore.srv.config.service.PSModelAPIService");
        psServiceMap.put("PSSYSTCASSERT", "net.ibizsys.pscore.srv.systest.service.PSSysTCAssertService");
        psServiceMap.put("PSMOBAPPPACK", "net.ibizsys.pscore.srv.appdesign.service.PSMobAppPackService");
        psServiceMap.put("PSSYSTCINPUT", "net.ibizsys.pscore.srv.systest.service.PSSysTCInputService");
        psServiceMap.put("PSSYSTESTCASE", "net.ibizsys.pscore.srv.systest.service.PSSysTestCaseService");
        psServiceMap.put("PSSFSTYLECODE", "net.ibizsys.pscore.srv.config.service.PSSFStyleCodeService");
        psServiceMap.put("PSSFVERCODEITEM", "net.ibizsys.pscore.srv.config.service.PSSFVerCodeItemService");
        psServiceMap.put("PSSFVERCODE", "net.ibizsys.pscore.srv.config.service.PSSFVerCodeService");
        psServiceMap.put("PSSFSTYLEVER", "net.ibizsys.pscore.srv.config.service.PSSFStyleVerService");
        psServiceMap.put("PSTREENODETYPE", "net.ibizsys.pscore.srv.config.service.PSTreeNodeTypeService");
        psServiceMap.put("PSPFCDN", "net.ibizsys.pscore.srv.config.service.PSPFCDNService");
        psServiceMap.put("PSSYSWFMODE", "net.ibizsys.pscore.srv.wfdesign.service.PSSysWFModeService");
        psServiceMap.put("PSFDLOGICTYPE", "net.ibizsys.pscore.srv.config.service.PSFDLogicTypeService");
        psServiceMap.put("PSCODENAME", "net.ibizsys.pscore.srv.config.service.PSCodeNameService");
        psServiceMap.put("PSSYSLANITEM", "net.ibizsys.pscore.srv.config.service.PSSysLanItemService");
        psServiceMap.put("PSSYSLANRES", "net.ibizsys.pscore.srv.config.service.PSSysLanResService");
        psServiceMap.put("PSLANGUAGE", "net.ibizsys.pscore.srv.config.service.PSLanguageService");
        psServiceMap.put("PSSYSTESTDATA", "net.ibizsys.pscore.srv.systest.service.PSSysTestDataService");
        psServiceMap.put("PSSYSTDITEM", "net.ibizsys.pscore.srv.systest.service.PSSysTDItemService");
        psServiceMap.put("PSPDTAPPFUNC", "net.ibizsys.pscore.srv.config.service.PSPDTAppFuncService");
        psServiceMap.put("PSSAMPLEVALUE", "net.ibizsys.pscore.srv.config.service.PSSampleValueService");
        psServiceMap.put("PSSYSSAMPLEVALUE", "net.ibizsys.pscore.srv.sysdesign.service.PSSysSampleValueService");
        psServiceMap.put("PSTSCMD", "net.ibizsys.pscore.srv.paasmgr.service.PSTSCmdService");
        psServiceMap.put("PSSVRDOMAIN", "net.ibizsys.pscore.srv.paasmgr.service.PSSvrDomainService");
        psServiceMap.put("PSDERDEFMAP", "net.ibizsys.pscore.srv.dedesign.service.PSDERDEFMapService");
        psServiceMap.put("PSDCTASKLOG", "net.ibizsys.pscore.srv.devcenter.service.PSDCTaskLogService");
        psServiceMap.put("PSDCMODELTEMPL", "net.ibizsys.pscore.srv.devcenter.service.PSDCModelTemplService");
        psServiceMap.put("PSDCMTDEF", "net.ibizsys.pscore.srv.devcenter.service.PSDCMTDEFService");
        psServiceMap.put("PSDCMTDECAT", "net.ibizsys.pscore.srv.devcenter.service.PSDCMTDECatService");
        psServiceMap.put("PSSYSERMAP", "net.ibizsys.pscore.srv.sysdesign.service.PSSysERMapService");
        psServiceMap.put("PSSYSERMAPNODE", "net.ibizsys.pscore.srv.sysdesign.service.PSSysERMapNodeService");
        psServiceMap.put("PSCOREPRDCAT", "net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdCatService");
        psServiceMap.put("PSCOREPRD", "net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdService");
        psServiceMap.put("PSCOREPRDISSUE", "net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdIssueService");
        psServiceMap.put("PSCOREPRDFUNC", "net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdFuncService");
        psServiceMap.put("PSCPVFUNC", "net.ibizsys.pscore.srv.paasmgr.service.PSCPVFuncService");
        psServiceMap.put("PSCPVISSUE", "net.ibizsys.pscore.srv.paasmgr.service.PSCPVIssueService");
        psServiceMap.put("PSMODELREF", "net.ibizsys.pscore.srv.sysdesign.service.PSModelRefService");
        psServiceMap.put("PSDCCOREPRDISSUE", "net.ibizsys.pscore.srv.paasmgr.service.PSDCCorePrdIssueService");
        psServiceMap.put("PSCOREPRDVER", "net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdVerService");
        psServiceMap.put("PSSYSCOUNTERITEM", "net.ibizsys.pscore.srv.sysdesign.service.PSSysCounterItemService");
        psServiceMap.put("PSSYSDMITEMLOG", "net.ibizsys.pscore.srv.sysdesign.service.PSSysDMItemLogService");
        psServiceMap.put("PSSYSTASK", "net.ibizsys.pscore.srv.sysdesign.service.PSSysTaskService");
        psServiceMap.put("PSSFCONFIG", "net.ibizsys.pscore.srv.config.service.PSSFConfigService");
        psServiceMap.put("PSMODELERROR", "net.ibizsys.pscore.srv.config.service.PSModelErrorService");
        psServiceMap.put("PSDCNWFLOW", "net.ibizsys.pscore.srv.devcenter.service.PSDCNWFlowService");
        psServiceMap.put("PSPFPKGVERCDN", "net.ibizsys.pscore.srv.config.service.PSPFPkgVerCDNService");
        psServiceMap.put("PSVTSAMPLE", "net.ibizsys.pscore.srv.config.service.PSVTSampleService");
        psServiceMap.put("PSSYSMODELFUNCCAT", "net.ibizsys.pscore.srv.config.service.PSSysModelFuncCatService");
        psServiceMap.put("PSSFPKGCAT", "net.ibizsys.pscore.srv.config.service.PSSFPkgCatService");
        psServiceMap.put("PSSFPKG", "net.ibizsys.pscore.srv.config.service.PSSFPkgService");
        psServiceMap.put("PSSFPKGVER", "net.ibizsys.pscore.srv.config.service.PSSFPkgVerService");
        psServiceMap.put("PSDCSFPKG", "net.ibizsys.pscore.srv.devcenter.service.PSDCSFPkgService");
        psServiceMap.put("PSDCSFPKGVER", "net.ibizsys.pscore.srv.devcenter.service.PSDCSFPkgVerService");
        psServiceMap.put("PSSFSTYLEPKG", "net.ibizsys.pscore.srv.config.service.PSSFStylePkgService");
        psServiceMap.put("PSDEVCENTERSF", "net.ibizsys.pscore.srv.devcenter.service.PSDevCenterSFService");
        psServiceMap.put("PSSFSTYLEPRJ", "net.ibizsys.pscore.srv.config.service.PSSFStylePrjService");
        psServiceMap.put("PSPFSTYLEPRJ", "net.ibizsys.pscore.srv.config.service.PSPFStylePrjService");
        psServiceMap.put("PSDCSERVER", "net.ibizsys.pscore.srv.paasmgr.service.PSDCServerService");
        psServiceMap.put("PSDEGEIUPDATE", "net.ibizsys.pscore.srv.dedesign.service.PSDEGEIUpdateService");
        psServiceMap.put("PSDEGEIUDETAIL", "net.ibizsys.pscore.srv.dedesign.service.PSDEGEIUDetailService");
        psServiceMap.put("PSDATASYNCAGENTTYPE", "net.ibizsys.pscore.srv.paasmgr.service.PSDataSyncAgentTypeService");
        psServiceMap.put("PSSYSDATASYNCAGENT", "net.ibizsys.pscore.srv.sysdesign.service.PSSysDataSyncAgentService");
        psServiceMap.put("PSDEDATASYNC", "net.ibizsys.pscore.srv.dedesign.service.PSDEDataSyncService");
        psServiceMap.put("PSSYSREQITEM", "net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService");
        psServiceMap.put("PSDEWIZARDSTEP", "net.ibizsys.pscore.srv.dedesign.service.PSDEWizardStepService");
        psServiceMap.put("PSDEWIZARD", "net.ibizsys.pscore.srv.dedesign.service.PSDEWizardService");
        psServiceMap.put("PSPFSTYLELOG", "net.ibizsys.pscore.srv.config.service.PSPFStyleLogService");
        psServiceMap.put("PSSFSTYLELOG", "net.ibizsys.pscore.srv.config.service.PSSFStyleLogService");
        psServiceMap.put("PSSYSMODELFUNCTEMPL", "net.ibizsys.pscore.srv.config.service.PSSysModelFuncTemplService");
        psServiceMap.put("PSSYSMODELFUNC", "net.ibizsys.pscore.srv.config.service.PSSysModelFuncService");
        psServiceMap.put("PSDEWIZARDFORM", "net.ibizsys.pscore.srv.dedesign.service.PSDEWizardFormService");
        psServiceMap.put("PSSYSUSERDR", "net.ibizsys.pscore.srv.sysdesign.service.PSSysUserDRService");
        psServiceMap.put("PSLANGUAGEITEM", "net.ibizsys.pscore.srv.sysdesign.service.PSLanguageItemService");
        psServiceMap.put("PSLANGUAGERES", "net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService");
        psServiceMap.put("PSVIEWMSGGRPDETAIL", "net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgGrpDetailService");
        psServiceMap.put("PSVIEWMSG", "net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgService");
        psServiceMap.put("PSVIEWMSGGROUP", "net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgGroupService");
        psServiceMap.put("PSBDTYPE", "net.ibizsys.pscore.srv.config.service.PSBDTypeService");
        psServiceMap.put("PSSYSBDTABLEDE", "net.ibizsys.pscore.srv.bdscheme.service.PSSysBDTableDEService");
        psServiceMap.put("PSSYSBDCOLUMN", "net.ibizsys.pscore.srv.bdscheme.service.PSSysBDColumnService");
        psServiceMap.put("PSSYSBDCOLSET", "net.ibizsys.pscore.srv.bdscheme.service.PSSysBDColSetService");
        psServiceMap.put("PSSYSBDTABLE", "net.ibizsys.pscore.srv.bdscheme.service.PSSysBDTableService");
        psServiceMap.put("PSSYSBDPART", "net.ibizsys.pscore.srv.bdscheme.service.PSSysBDPartService");
        psServiceMap.put("PSSYSBDSCHEME", "net.ibizsys.pscore.srv.bdscheme.service.PSSysBDSchemeService");
        psServiceMap.put("PSSYSBDINSTCFG", "net.ibizsys.pscore.srv.bdscheme.service.PSSysBDInstCfgService");
        psServiceMap.put("PSDCBDINST", "net.ibizsys.pscore.srv.devcenter.service.PSDCBDInstService");
        psServiceMap.put("PSBDDEVINST", "net.ibizsys.pscore.srv.paasmgr.service.PSBDDevInstService");
        psServiceMap.put("PSBDSERVER", "net.ibizsys.pscore.srv.paasmgr.service.PSBDServerService");
        psServiceMap.put("PSAPPLAN", "net.ibizsys.pscore.srv.appdesign.service.PSAppLanService");
        psServiceMap.put("PSDCBKTYPE", "net.ibizsys.pscore.srv.config.service.PSDCBKTypeService");
        psServiceMap.put("PSDCBKTASK", "net.ibizsys.pscore.srv.devcenter.service.PSDCBKTaskService");
        psServiceMap.put("PSSYSREQMODULE", "net.ibizsys.pscore.srv.sysdesign.service.PSSysReqModuleService");
        psServiceMap.put("PSSYSREQITEMHIS", "net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemHisService");
        psServiceMap.put("PSSYSREQITEMDATA", "net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemDataService");
        psServiceMap.put("PSSYSTASKDATA", "net.ibizsys.pscore.srv.sysdesign.service.PSSysTaskDataService");
        psServiceMap.put("PSCTRLMSG", "net.ibizsys.pscore.srv.sysdesign.service.PSCtrlMsgService");
        psServiceMap.put("PSCTRLMSGITEM", "net.ibizsys.pscore.srv.sysdesign.service.PSCtrlMsgItemService");
        psServiceMap.put("PSDEVSLNSYSPATCH", "net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysPatchService");
        psServiceMap.put("PSDEFINPUTTIP", "net.ibizsys.pscore.srv.dedesign.service.PSDEFInputTipService");
        psServiceMap.put("PSUNIT", "net.ibizsys.pscore.srv.config.service.PSUnitService");
        psServiceMap.put("PSSYSUNIT", "net.ibizsys.pscore.srv.sysdesign.service.PSSysUnitService");
        psServiceMap.put("PSSYSMODELLOG", "net.ibizsys.pscore.srv.sysdesign.service.PSSysModelLogService");
        psServiceMap.put("PSDEACTIONWIZARD", "net.ibizsys.pscore.srv.dedesign.service.PSDEActionWizardService");
        psServiceMap.put("PSDEAWITEM", "net.ibizsys.pscore.srv.dedesign.service.PSDEAWItemService");
        psServiceMap.put("PSDEAWGROUP", "net.ibizsys.pscore.srv.dedesign.service.PSDEAWGroupService");
        psServiceMap.put("PSDEAWGRPDETAIL", "net.ibizsys.pscore.srv.dedesign.service.PSDEAWGrpDetailService");
        psServiceMap.put("PSVIEWWIZARDGROUP", "net.ibizsys.pscore.srv.sysdesign.service.PSViewWizardGroupService");
        psServiceMap.put("PSPFPKGCAT", "net.ibizsys.pscore.srv.config.service.PSPFPkgCatService");
        psServiceMap.put("PSPFPKG", "net.ibizsys.pscore.srv.config.service.PSPFPkgService");
        psServiceMap.put("PSPFPKGVER", "net.ibizsys.pscore.srv.config.service.PSPFPkgVerService");
        psServiceMap.put("PSPFSTYLEPKG", "net.ibizsys.pscore.srv.config.service.PSPFStylePkgService");
        psServiceMap.put("PSDEVSLNSYSKEY", "net.ibizsys.pscore.srv.devcenter.service.PSDevSlnSysKeyService");
        psServiceMap.put("PSSYSPOLICY", "net.ibizsys.pscore.srv.config.service.PSSysPolicyService");
        psServiceMap.put("PSSYSPOLICYMODEL", "net.ibizsys.pscore.srv.config.service.PSSysPolicyModelService");
        psServiceMap.put("PSDEVSLNSYSMODEL", "net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysModelService");
        psServiceMap.put("PSDEVUSERSQL", "net.ibizsys.pscore.srv.devcenter.service.PSDevUserSqlService");
        psServiceMap.put("PSDCDBOBJ", "net.ibizsys.pscore.srv.devcenter.service.PSDCDBObjService");
        psServiceMap.put("PSMODELSTATE", "net.ibizsys.pscore.srv.config.service.PSModelStateService");
        psServiceMap.put("PSDETREENODERV", "net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeRVService");
        psServiceMap.put("PSMODEL", "net.ibizsys.pscore.srv.config.service.PSModelService");
        psServiceMap.put("PSWXACCOUNT", "net.ibizsys.pscore.srv.wxdesign.service.PSWXAccountService");
        psServiceMap.put("PSWXENTAPP", "net.ibizsys.pscore.srv.wxdesign.service.PSWXEntAppService");
        psServiceMap.put("PSWXMENU", "net.ibizsys.pscore.srv.wxdesign.service.PSWXMenuService");
        psServiceMap.put("PSWXMENUFUNC", "net.ibizsys.pscore.srv.wxdesign.service.PSWXMenuFuncService");
        psServiceMap.put("PSWXLOGIC", "net.ibizsys.pscore.srv.wxdesign.service.PSWXLogicService");
        psServiceMap.put("PSWXMENUITEM", "net.ibizsys.pscore.srv.wxdesign.service.PSWXMenuItemService");
        psServiceMap.put("PSMODELHOTCODE", "net.ibizsys.pscore.srv.config.service.PSModelHotCodeService");
        psServiceMap.put("PSDEVUSERMODEL", "net.ibizsys.pscore.srv.devcenter.service.PSDevUserModelService");
        psServiceMap.put("PSSFEXCEPTION", "net.ibizsys.pscore.srv.config.service.PSSFExceptionService");
        psServiceMap.put("PSVIEWSTYLE", "net.ibizsys.pscore.srv.config.service.PSViewStyleService");
        psServiceMap.put("PSAPPPKG", "net.ibizsys.pscore.srv.appdesign.service.PSAppPkgService");
        psServiceMap.put("PSSYSSFPUBPKG", "net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPubPkgService");
        psServiceMap.put("PSMODELRS", "net.ibizsys.pscore.srv.config.service.PSModelRSService");
        psServiceMap.put("PSHELPMODART", "net.ibizsys.pscore.srv.helpdesign.service.PSHelpModArtService");
        psServiceMap.put("PSHELPARTICLE", "net.ibizsys.pscore.srv.helpdesign.service.PSHelpArticleService");
        psServiceMap.put("PSHELPSECTION", "net.ibizsys.pscore.srv.helpdesign.service.PSHelpSectionService");
        psServiceMap.put("PSHELPRESOURCE", "net.ibizsys.pscore.srv.helpdesign.service.PSHelpResourceService");
        psServiceMap.put("PSHELPMODULE", "net.ibizsys.pscore.srv.helpdesign.service.PSHelpModuleService");
        psServiceMap.put("PSHELPPRJ", "net.ibizsys.pscore.srv.helpdesign.service.PSHelpPrjService");
        psServiceMap.put("PSHELPARTICLECAT", "net.ibizsys.pscore.srv.helpdesign.service.PSHelpArticleCatService");
        psServiceMap.put("PSHELPARTSEC", "net.ibizsys.pscore.srv.config.service.PSHelpArtSecService");
        psServiceMap.put("PSHELPSECTIONTEMPL", "net.ibizsys.pscore.srv.config.service.PSHelpSectionTemplService");
        psServiceMap.put("PSHELPARTICLETEMPL", "net.ibizsys.pscore.srv.config.service.PSHelpArticleTemplService");
        psServiceMap.put("PSHELPARTICLETYPE", "net.ibizsys.pscore.srv.config.service.PSHelpArticleTypeService");
        psServiceMap.put("PSHELPSECTIONTYPE", "net.ibizsys.pscore.srv.config.service.PSHelpSectionTypeService");
        psServiceMap.put("PSDEUSERROLE", "net.ibizsys.pscore.srv.dedesign.service.PSDEUserRoleService");
        psServiceMap.put("PSSYSDBPART", "net.ibizsys.pscore.srv.sysdesign.service.PSSysDBPartService");
        psServiceMap.put("PSHELPPRJTYPE", "net.ibizsys.pscore.srv.config.service.PSHelpPrjTypeService");
        psServiceMap.put("PSHELPPRJTEMPL", "net.ibizsys.pscore.srv.config.service.PSHelpPrjTemplService");
        psServiceMap.put("PSMODELPLUGIN", "net.ibizsys.pscore.srv.config.service.PSModelPluginService");
        psServiceMap.put("PSMODELMODULE", "net.ibizsys.pscore.srv.config.service.PSModelModuleService");
        psServiceMap.put("PSMODELSECTION", "net.ibizsys.pscore.srv.config.service.PSModelSectionService");
        psServiceMap.put("PSMODELEXAMPLE", "net.ibizsys.pscore.srv.config.service.PSModelExampleService");
        psServiceMap.put("PSMODELRESOURCE", "net.ibizsys.pscore.srv.config.service.PSModelResourceService");
        psServiceMap.put("PSMODELVALUEGROUP", "net.ibizsys.pscore.srv.config.service.PSModelValueGroupService");
        psServiceMap.put("PSMODELFIELDVALUE", "net.ibizsys.pscore.srv.config.service.PSModelFieldValueService");
        psServiceMap.put("PSMODELFIELD", "net.ibizsys.pscore.srv.config.service.PSModelFieldService");
        psServiceMap.put("PSSFVIEWTYPE", "net.ibizsys.pscore.srv.config.service.PSSFViewTypeService");
        psServiceMap.put("PSSFCTRLTYPE", "net.ibizsys.pscore.srv.config.service.PSSFCtrlTypeService");
        psServiceMap.put("PSPFEDITORTYPE", "net.ibizsys.pscore.srv.config.service.PSPFEditorTypeService");
        psServiceMap.put("PSPFVIEWTYPE", "net.ibizsys.pscore.srv.config.service.PSPFViewTypeService");
        psServiceMap.put("PSPFCTRLTYPE", "net.ibizsys.pscore.srv.config.service.PSPFCtrlTypeService");
        psServiceMap.put("PSMODELUIACTION", "net.ibizsys.pscore.srv.config.service.PSModelUIActionService");
        psServiceMap.put("PSMODELEXAMPLESTEP", "net.ibizsys.pscore.srv.config.service.PSModelExampleStepService");
        psServiceMap.put("PSMODELEXAMPLECAT", "net.ibizsys.pscore.srv.config.service.PSModelExampleCatService");
        psServiceMap.put("PSMODELSUBVIEW", "net.ibizsys.pscore.srv.config.service.PSModelSubViewService");
        psServiceMap.put("PSMODELVIEW", "net.ibizsys.pscore.srv.config.service.PSModelViewService");
        psServiceMap.put("PSDCSYSLIC", "net.ibizsys.pscore.srv.devcenter.service.PSDCSysLicService");
        psServiceMap.put("PSDCDBINSTBK", "net.ibizsys.pscore.srv.devcenter.service.PSDCDBInstBKService");
        psServiceMap.put("PSDCSVNBK", "net.ibizsys.pscore.srv.devcenter.service.PSDCSVNBKService");
        psServiceMap.put("PSDEPSLNSYSAS", "net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysASService");
        psServiceMap.put("PSDEPSLNSYSMQ", "net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysMQService");
        psServiceMap.put("PSDEPSLNSYSDB", "net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysDBService");
        psServiceMap.put("PSDEPSLNMQINST", "net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnMQInstService");
        psServiceMap.put("PSDEPSLNSYS", "net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysService");
        psServiceMap.put("PSDEPSAASSYSAPP", "net.ibizsys.pscore.srv.sysdeploy.service.PSDepSaaSSysAppService");
        psServiceMap.put("PSDEPSAASSYSVER", "net.ibizsys.pscore.srv.sysdeploy.service.PSDepSaaSSysVerService");
        psServiceMap.put("PSDEPSAASSYS", "net.ibizsys.pscore.srv.sysdeploy.service.PSDepSaaSSysService");
        psServiceMap.put("PSDEPSYSAPP", "net.ibizsys.pscore.srv.sysdeploy.service.PSDepSysAppService");
        psServiceMap.put("PSDEPSYS", "net.ibizsys.pscore.srv.sysdeploy.service.PSDepSysService");
        psServiceMap.put("PSDEPSYSVER", "net.ibizsys.pscore.srv.sysdeploy.service.PSDepSysVerService");
        psServiceMap.put("PSSAASSYSAPP", "net.ibizsys.pscore.srv.devcenter.service.PSSaaSSysAppService");
        psServiceMap.put("PSSAASSYSVER", "net.ibizsys.pscore.srv.devcenter.service.PSSaaSSysVerService");
        psServiceMap.put("PSSAASSYS", "net.ibizsys.pscore.srv.devcenter.service.PSSaaSSysService");
        psServiceMap.put("PSSYSMODELMSG", "net.ibizsys.pscore.srv.sysdevstudio.service.PSSysModelMsgService");
        psServiceMap.put("PSDEPSLNHOST", "net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnHostService");
        psServiceMap.put("PSDEPSYSTYPE", "net.ibizsys.pscore.srv.config.service.PSDepSysTypeService");
        psServiceMap.put("PSMQTYPE", "net.ibizsys.pscore.srv.config.service.PSMQTypeService");
        psServiceMap.put("PSDCASGROUP", "net.ibizsys.pscore.srv.config.service.PSDCASGroupService");
        psServiceMap.put("PSASGROUP", "net.ibizsys.pscore.srv.config.service.PSASGroupService");
        psServiceMap.put("PSDEPSLNTYPE", "net.ibizsys.pscore.srv.config.service.PSDepSlnTypeService");
        psServiceMap.put("PSSAASSYSDB", "net.ibizsys.pscore.srv.sysdeploy.service.PSSaaSSysDBService");
        psServiceMap.put("PSGITUSER", "net.ibizsys.pscore.srv.paasmgr.service.PSGitUserService");
        psServiceMap.put("PSNDFILE", "net.ibizsys.pscore.srv.paasmgr.service.PSNDFileService");
        psServiceMap.put("PSDEVCENTERFILE", "net.ibizsys.pscore.srv.devcenter.service.PSDevCenterFileService");
        psServiceMap.put("PSDEPSLNPACK", "net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnPackService");
        psServiceMap.put("PSNDFILELINK", "net.ibizsys.pscore.srv.paasmgr.service.PSNDFileLinkService");
        psServiceMap.put("PSDEPSLNDEPSESSION", "net.ibizsys.pscore.srv.sysdeploy.service.PSdepSlnDepSessionService");
        psServiceMap.put("PSSYSENGINECFG", "net.ibizsys.pscore.srv.sysdesign.service.PSSysEngineCfgService");
        psServiceMap.put("PSSYSBDTABLEDER", "net.ibizsys.pscore.srv.bdscheme.service.PSSysBDTableDERService");
        psServiceMap.put("PSSYSBDMODULE", "net.ibizsys.pscore.srv.bdscheme.service.PSSysBDModuleService");
        psServiceMap.put("PSDEVPRD", "net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdService");
        psServiceMap.put("PSDEVPRDVER", "net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdVerService");
        psServiceMap.put("PSDEVPRDSUBVER", "net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdSubVerService");
        psServiceMap.put("PSDEVPRDSYS", "net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdSysService");
        psServiceMap.put("PSDEVPRDSYSSYNC", "net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdSysSyncService");
        psServiceMap.put("PSDEVPRDSYSSYNCITEM", "net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdSysSyncItemService");
        psServiceMap.put("PSDEVPRDSPEC", "net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdSpecService");
        psServiceMap.put("PSDEVPRDSEPCPLAN", "net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdSepcPlanXXXXService");
        psServiceMap.put("PSDEVPRDSPECPLAN", "net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdSpecPlanService");
        psServiceMap.put("PSDEVSLNSYSRES", "net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysResService");
        psServiceMap.put("PSMODELVIEWUIACTION", "net.ibizsys.pscore.srv.config.service.PSModelViewUIActionService");
        psServiceMap.put("PSROBOTTYPE", "net.ibizsys.pscore.srv.config.service.PSRobotTypeService");
        psServiceMap.put("PSROBOT", "net.ibizsys.pscore.srv.paasmgr.service.PSRobotService");
        psServiceMap.put("PSROBOTWORKTYPE", "net.ibizsys.pscore.srv.config.service.PSRobotWorkTypeService");
        psServiceMap.put("PSDCROBOT", "net.ibizsys.pscore.srv.devcenter.service.PSDCRobotService");
        psServiceMap.put("PSROBOTTYPEABILITY", "net.ibizsys.pscore.srv.config.service.PSRobotTypeAbilityService");
        psServiceMap.put("PSDCROBOTABILITY", "net.ibizsys.pscore.srv.devcenter.service.PSDCRobotAbilityService");
        psServiceMap.put("PSDCROBOTLOG", "net.ibizsys.pscore.srv.devcenter.service.PSDCRobotLogService");
        psServiceMap.put("PSSTUDIOSERVER", "net.ibizsys.pscore.srv.paasmgr.service.PSStudioServerService");
        psServiceMap.put("PSSYSBDTABLERS", "net.ibizsys.pscore.srv.bdscheme.service.PSSysBDTableRSService");
        psServiceMap.put("PSSYSSQLCMD", "net.ibizsys.pscore.srv.sysdesign.service.PSSysSQLCmdService");
        psServiceMap.put("PSSYSSQLCMDSQL", "net.ibizsys.pscore.srv.sysdesign.service.PSSysSQLCmdSQLService");
        psServiceMap.put("PSDEFINPUTTIPSET", "net.ibizsys.pscore.srv.dedesign.service.PSDEFInputTipSetService");
        psServiceMap.put("PSSUBSYSVERINST", "net.ibizsys.pscore.srv.config.service.PSSubSysVerInstService");
        psServiceMap.put("PSCTRLMSGTAG", "net.ibizsys.pscore.srv.config.service.PSCtrlMsgTagService");
        psServiceMap.put("PSSFPUBOBJPARAM", "net.ibizsys.pscore.srv.config.service.PSSFPubObjParamService");
        psServiceMap.put("PSRTWXACCOUNT", "net.ibizsys.pscore.srv.paasmgr.service.PSRTWXAccountService");
        psServiceMap.put("PSDCRESREP", "net.ibizsys.pscore.srv.devcenter.service.PSDCResRepService");
        psServiceMap.put("PSSTUDIOSERVERGRP", "net.ibizsys.pscore.srv.paasmgr.service.PSStudioServerGrpService");
        psServiceMap.put("PSDCABILITY", "net.ibizsys.pscore.srv.devcenter.service.PSDCAbilityService");
        psServiceMap.put("PSDSBOOKINGLOG", "net.ibizsys.pscore.srv.paasmgr.service.PSDSBookingLogService");
        psServiceMap.put("PSASBOOKING", "net.ibizsys.pscore.srv.paasmgr.service.PSASBookingService");
        psServiceMap.put("PSDSBOOKING", "net.ibizsys.pscore.srv.paasmgr.service.PSDSBookingService");
        psServiceMap.put("PSDCRESHOURSLOG", "net.ibizsys.pscore.srv.devcenter.service.PSDCResHoursLogService");
        psServiceMap.put("PSASBOOKINGLOG", "net.ibizsys.pscore.srv.paasmgr.service.PSASBookingLogService");
        psServiceMap.put("PSBOOKINGRESTYPE", "net.ibizsys.pscore.srv.config.service.PSBookingResTypeService");
        psServiceMap.put("PSDCRESHOURS", "net.ibizsys.pscore.srv.devcenter.service.PSDCResHoursService");
        psServiceMap.put("PSSFPUBOBJ", "net.ibizsys.pscore.srv.config.service.PSSFPubOjbService");
        psServiceMap.put("PSTASKSERVERLOG", "net.ibizsys.pscore.srv.paasmgr.service.PSTaskServerLogService");
        psServiceMap.put("PSSTUDIOSERVERLOG", "net.ibizsys.pscore.srv.paasmgr.service.PSStudioServerLogService");
        psServiceMap.put("PSDBDEVINSTBK", "net.ibizsys.pscore.srv.paasmgr.service.PSDBDevInstBKService");
        psServiceMap.put("PSSYSMODELINSTBK", "net.ibizsys.pscore.srv.paasmgr.service.PSSysModelInstBKService");
        psServiceMap.put("PSPFPUBOBJ", "net.ibizsys.pscore.srv.config.service.PSPFPubObjService");
        psServiceMap.put("PSSYSMODELLOADLOG", "net.ibizsys.pscore.srv.sysdesign.service.PSSysModelLoadLogService");
        psServiceMap.put("PSDEVSERVERTYPE", "net.ibizsys.pscore.srv.config.service.PSDevServerTypeService");
        psServiceMap.put("PSDCDBINSTREF", "net.ibizsys.pscore.srv.devcenter.service.PSDCDBInstRefService");
        psServiceMap.put("PSDEMSOPPRIV", "net.ibizsys.pscore.srv.dedesign.service.PSDEMSOPPrivService");
        psServiceMap.put("PSDEVSLNSYSTS", "net.ibizsys.pscore.srv.paasmgr.service.PSDevSlnSysTSService");
        psServiceMap.put("PSMOBAPPSTARTPAGE", "net.ibizsys.pscore.srv.appdesign.service.PSMobAppStartPageService");
        psServiceMap.put("PSMOBAPPPACKSESSION", "net.ibizsys.pscore.srv.appdesign.service.PSMobAppPackSessionService");
        psServiceMap.put("PSDCMOBAPPTESTDEVICE", "net.ibizsys.pscore.srv.devcenter.service.PSDCMobAppTestDeviceService");
        psServiceMap.put("PSDCMOBPACKCERT", "net.ibizsys.pscore.srv.appdesign.service.PSDCMobPackCertService");
        psServiceMap.put("PSMOBAPPPACKTD", "net.ibizsys.pscore.srv.appdesign.service.PSMobAppPackTDService");
        psServiceMap.put("PSDCMOBAPPTDREF", "net.ibizsys.pscore.srv.devcenter.service.PSDCMobAppTDRefService");
        psServiceMap.put("PSSYSDEFTYPE", "net.ibizsys.pscore.srv.sysdesign.service.PSSysDEFTypeService");
        psServiceMap.put("PSDCPFPITEMPL", "net.ibizsys.pscore.srv.devcenter.service.PSDCPFPITemplService");
        psServiceMap.put("PSDCPFPLUGIN", "net.ibizsys.pscore.srv.devcenter.service.PSDCPFPluginService");
        psServiceMap.put("PSDEVPRDISSUE", "net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdIssueService");
        psServiceMap.put("PSDEVPRDISSUEPLAN", "net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdIssuePlanService");
        psServiceMap.put("PSSYSDELOGICNODE", "net.ibizsys.pscore.srv.sysdesign.service.PSSysDELogicNodeService");
        psServiceMap.put("PSMOBAPPPACKSERVER", "net.ibizsys.pscore.srv.paasmgr.service.PSMobAppPackServerService");
        psServiceMap.put("PSDCSYNCAGENT", "net.ibizsys.pscore.srv.paasmgr.service.PSDCSyncAgentService");
        psServiceMap.put("PSDCSYNCDATATYPE", "net.ibizsys.pscore.srv.config.service.PSDCSyncDataTypeService");
        psServiceMap.put("PSDCSYNCDATA", "net.ibizsys.pscore.srv.devcenter.service.PSDCSyncDataService");
        psServiceMap.put("PSDCSYNCDATA2", "net.ibizsys.pscore.srv.devcenter.service.PSDCSyncData2Service");
        psServiceMap.put("PSPFPUBOBJPARAM", "net.ibizsys.pscore.srv.config.service.PSPFPubObjParamService");
        psServiceMap.put("PSDEVIEWCTRLDS", "net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlDSService");
        psServiceMap.put("PSSYSVIEWPANEL", "net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService");
        psServiceMap.put("PSSYSVIEWPANELITEM", "net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelItemService");
        psServiceMap.put("PSSYSSEARCHBAR", "net.ibizsys.pscore.srv.sysdesign.service.PSSysSearchBarService");
        psServiceMap.put("PSSYSSEARCHBARITEM", "net.ibizsys.pscore.srv.sysdesign.service.PSSysSearchBarItemService");
        psServiceMap.put("PSCOREPRDINSTLOG", "net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdInstLogService");
        psServiceMap.put("PSROBOTWORK", "net.ibizsys.pscore.srv.config.service.PSRobotWorkService");
        psServiceMap.put("PSROBOTABILITY", "net.ibizsys.pscore.srv.config.service.PSRobotAbilityService");
        psServiceMap.put("PSVIEWENGINE", "net.ibizsys.pscore.srv.config.service.PSViewEngineService");
        psServiceMap.put("PSSUBSYSSADETAIL", "net.ibizsys.pscore.srv.sysdesign.service.PSSubSysSADetailService");
        psServiceMap.put("PSSUBSYSSERVICEAPI", "net.ibizsys.pscore.srv.sysdesign.service.PSSubSysServiceAPIService");
        psServiceMap.put("PSDERGROUP", "net.ibizsys.pscore.srv.sysdesign.service.PSDERGroupService");
        psServiceMap.put("PSDESADETAIL", "net.ibizsys.pscore.srv.dedesign.service.PSDESADetailService");
        psServiceMap.put("PSSYSSERVICEAPI", "net.ibizsys.pscore.srv.sysdesign.service.PSSysServiceAPIService");
        psServiceMap.put("PSDESERVICEAPI", "net.ibizsys.pscore.srv.dedesign.service.PSDEServiceAPIService");
        psServiceMap.put("PSDEFGROUPDETAIL", "net.ibizsys.pscore.srv.dedesign.service.PSDEFGroupDetailService");
        psServiceMap.put("PSDEFGROUP", "net.ibizsys.pscore.srv.dedesign.service.PSDEFGroupService");
        psServiceMap.put("PSDERGROUPDETAIL", "net.ibizsys.pscore.srv.sysdesign.service.PSDERGroupDetailService");
        psServiceMap.put("PSDEDTSQUEUE", "net.ibizsys.pscore.srv.dedesign.service.PSDEDTSQueueService");
        psServiceMap.put("PSDEPLOYSERVER", "net.ibizsys.pscore.srv.paasmgr.service.PSDeployServerService");
        psServiceMap.put("PSDCDEPLOYSERVER", "net.ibizsys.pscore.srv.devcenter.service.PSDCDeployServerService");
        psServiceMap.put("PSSYSPROJECT", "net.ibizsys.pscore.srv.sysdesign.service.PSSysProjectService");
        psServiceMap.put("PSDEOPPRIVROLE", "net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivRoleService");
        psServiceMap.put("PSSYSDASHBOARD", "net.ibizsys.pscore.srv.sysdesign.service.PSSysDashboardService");
        psServiceMap.put("PSAPPLOCALDE", "net.ibizsys.pscore.srv.appdesign.service.PSAppLocalDEService");
        psServiceMap.put("PSDEUTILDE", "net.ibizsys.pscore.srv.dedesign.service.PSDEUtilDEService");
        psServiceMap.put("PSSYSUTILDE", "net.ibizsys.pscore.srv.sysdesign.service.PSSysUtilDEService");
        psServiceMap.put("PSDEACTIONPARAM", "net.ibizsys.pscore.srv.sysdesign.service.PSDEActionParamService");
        psServiceMap.put("PSDEACTIONPARAM", "net.ibizsys.pscore.srv.sysdesign.service.PSDEActionParamService");
        psServiceMap.put("PSDETREENODECOL", "net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeColService");
    }

    protected boolean PreparePageEnv() {
        if (PSJITWebContext.getInstance() != null) {
            PSJITWebContext.setCurrent(null);
        }
        return super.PreparePageEnv();
    }

    protected void OnInitComponents() {
        super.OnInitComponents();
        try {
            JSONObject jo;
            JSONArray ja;
            String strPSDevSlnSysId = this.getWebContext().GetParamValue("PSDEVSLNSYSID");
            String strPSSystemId = this.getWebContext().GetParamValue("PSSYSID");
            SmartUpload su = new SmartUpload();
            su.initialize(this.pageContext);
            su.upload();
            int nCount = su.getFiles().getCount();
            if (nCount == 0) {
                return;
            }
            String strUserId = this.getRequest().getHeader("X-SRFUSERID");
            String strLoginName = this.getRequest().getHeader("X-SRFLOGINNAME");
            SimpleWebContext iWebContext = new SimpleWebContext();
            iWebContext.init(this.getRequest(), this.getResponse(), this.getRequest().getSession().getServletContext());
            WebContext.setCurrent((IWebContext)iWebContext);
            JSONObject jo2 = new JSONObject();
            if (!StringHelper.IsNullOrEmpty((String)strPSDevSlnSysId)) {
                PSDevSlnSysService psDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class);
                this.psDevSlnSys.setPSDevSlnSysId(strPSDevSlnSysId);
                psDevSlnSysService.get(this.psDevSlnSys);
                String strUserName = this.getRequest().getHeader("X-SRFUSERNAME");
                if (StringHelper.IsNullOrEmpty((String)strUserId)) {
                    this.processInfo.Append("\u6ca1\u6709\u6307\u5b9a\u5f53\u524d\u7528\u6237\u8eab\u4efd");
                    return;
                }
                iWebContext.setSessionValue("SRFPERSONID", (Object)strUserId);
                iWebContext.setSessionValue("SRFLOGINNAME", (Object)strLoginName);
            } else if (!StringHelper.IsNullOrEmpty((String)strPSSystemId)) {
                if (StringHelper.IsNullOrEmpty((String)this.getWebContext().getCurUserId())) {
                    this.processInfo.Append("\u6ca1\u6709\u6307\u5b9a\u5f53\u524d\u7528\u6237\u8eab\u4efd");
                    return;
                }
                iWebContext.setSessionValue("SRFPERSONID", (Object)this.getWebContext().getCurUserId());
                PSSystem psSystem = new PSSystem();
                PSSystemService psSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class);
                psSystem.setPSSystemId(strPSSystemId);
                psSystemService.get(psSystem);
                this.psDevSlnSys.setPSSystemId(psSystem.getPSSystemId());
                this.psDevSlnSys.setPSDevSlnSysName(psSystem.getPSSystemName());
            } else {
                this.processInfo.Append("\u8bf7\u6c42\u53c2\u6570\u65e0\u6548");
                return;
            }
            jo2.put("pssystemid", (Object)this.psDevSlnSys.getPSSystemId());
            jo2.put("pssystemname", (Object)this.psDevSlnSys.getPSDevSlnSysName());
            WebContext.setAppData((JSONObject)jo2);
            PSCoreSysServiceBase.setCurrentPSSystemId((String)this.psDevSlnSys.getPSSystemId());
            PSCoreSysServiceBase.setCurrentPSDevSlnSysId((String)this.psDevSlnSys.getPSDevSlnSysId());
            this.sysSessionFactory = PSSysModelInstGlobal.getSessionFactory((String)this.psDevSlnSys.getPSSysModelInstId());
            String strTempId = Helper.GenGuidEx();
            String strTempFilePath = StringHelper.Format((String)"%1$s%2$s.ibzbak", (Object)this.getWebContext().getGlobalHelper().GetTempPath(), (Object)strTempId);
            int i = 0;
            if (i < nCount) {
                SmartFile file = su.getFiles().getFile(i);
                file.saveAs(strTempFilePath);
            }
            if ((ja = (jo = JSONObjectHelper.fromFile((File)new File(strTempFilePath))).optJSONArray("items")) == null) {
                this.processInfo.Append("<SPAN class='sx-normaltext-red'>\u6570\u636e\u6587\u4ef6\u65e0\u6548\uff01</SPAN><BR>");
                return;
            }
            ImportSessionManager.openSession();
            long nStartTime = System.currentTimeMillis();
            int nIndex = 0;
            int i2 = 0;
            while (i2 < ja.length()) {
                JSONObject item = (JSONObject)ja.get(i2);
                ++nIndex;
                String strDEId = item.optString("srfdename", "");
                if (StringHelper.IsNullOrEmpty((String)strDEId)) {
                    this.processInfo.Append("[%1$s] <SPAN class='sx-normaltext-red'>\u6ca1\u6709\u6307\u5b9a\u5bf9\u5e94\u7684\u6570\u636e\u5bf9\u8c61</SPAN><BR>", (Object)nIndex);
                } else {
                    IService iService = null;
                    try {
                        String strServiceCls = psServiceMap.get(strDEId);
                        if (StringHelper.IsNullOrEmpty((String)strServiceCls)) {
                            this.processInfo.Append("[%1$s] <SPAN class='sx-normaltext-red'>\u6ca1\u6709\u8bc6\u522b\u6307\u5b9a\u7684\u6570\u636e\u5bf9\u8c61[%2$s]</SPAN><BR>", (Object)nIndex, (Object)strDEId);
                        } else {
                            iService = ServiceGlobal.getService((String)strServiceCls, (SessionFactory)this.sysSessionFactory);
                            String strInfo = iService.importModel(item);
                            if (StringHelper.IsNullOrEmpty((String)strInfo)) {
                                strInfo = "\u672a\u77e5";
                            }
                            this.processInfo.Append("[%1$s] <SPAN class='sx-normaltext'>[%2$s:%3$s]\u5bfc\u5165\u6570\u636e[%4$s]\u6210\u529f!</SPAN><BR>", (Object)nIndex, (Object)iService.getDEModel().getName(), (Object)iService.getDEModel().getLogicName(), (Object)strInfo);
                            if (nStartTime + 10000L < System.currentTimeMillis()) {
                                nStartTime = System.currentTimeMillis();
                                PSSysModelInstGlobal.active((String)this.psDevSlnSys.getPSSysModelInstId());
                            }
                        }
                    }
                    catch (Exception ex) {
                        if (iService != null) {
                            this.processInfo.Append("[%1$s] <SPAN class='sx-normaltext-red'>[%2$s:%3$s]\u5bfc\u5165\u6570\u636e\u53d1\u751f\u5f02\u5e38\uff1a%4$s</SPAN><BR>%5$s<BR>", (Object)nIndex, (Object)iService.getDEModel().getName(), (Object)iService.getDEModel().getLogicName(), (Object)ex.getMessage(), (Object)WebUtility.TextToHTML((String)item.toString()));
                        }
                        this.processInfo.Append("[%1$s] <SPAN class='sx-normaltext-red'>\u5bfc\u5165\u6570\u636e\u53d1\u751f\u5f02\u5e38\uff1a%2$s</SPAN><BR>", (Object)nIndex, (Object)ex.getMessage());
                    }
                }
                ++i2;
            }
            ImportSessionManager.closeSession();
        }
        catch (Exception ex) {
            ImportSessionManager.closeSession();
            ex.printStackTrace();
        }
    }

    public String getProcessInfo() {
        return this.processInfo.toString();
    }
}

