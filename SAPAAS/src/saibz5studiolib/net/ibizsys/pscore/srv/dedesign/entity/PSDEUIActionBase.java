/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.entity.IEntityActionHelper
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.JSONObjectHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.dedesign.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import javax.persistence.Column;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSSysUIAction;
import net.ibizsys.pscore.srv.config.service.PSSysPFPluginService;
import net.ibizsys.pscore.srv.config.service.PSSysUIActionService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEACMode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataExp;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataImp;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEForm;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPriv;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEPrint;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEACModeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataExpService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataImpService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEPrintService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCounter;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImage;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysPDTView;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewLogic;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCounterService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysImageService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysPDTViewService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewLogicService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFLink;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFProcess;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFVersion;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWorkflow;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFLinkService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFProcessService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFVersionService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWorkflowService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEUIActionBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEUIActionBase.class);
    public static final String FIELD_ACTIONLEVEL = "ACTIONLEVEL";
    public static final String FIELD_ACTIONTARGET = "ACTIONTARGET";
    public static final String FIELD_BUSYINDICATOR = "BUSYINDICATOR";
    public static final String FIELD_BUTTONSTYLE = "BUTTONSTYLE";
    public static final String FIELD_CAPPSLANRESID = "CAPPSLANRESID";
    public static final String FIELD_CAPPSLANRESNAME = "CAPPSLANRESNAME";
    public static final String FIELD_CAPTION = "CAPTION";
    public static final String FIELD_CLOSEEDITVIEW = "CLOSEEDITVIEW";
    public static final String FIELD_CMPSLANRESID = "CMPSLANRESID";
    public static final String FIELD_CMPSLANRESNAME = "CMPSLANRESNAME";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CONFIRMINFO = "CONFIRMINFO";
    public static final String FIELD_COUNTERID = "COUNTERID";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMCODE = "CUSTOMCODE";
    public static final String FIELD_DATAITEM = "DATAITEM";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_ENABLELOGIC = "ENABLELOGIC";
    public static final String FIELD_ENABLERTMODEL = "ENABLERTMODEL";
    public static final String FIELD_ENABLEVIEWACTIONS = "ENABLEVIEWACTIONS";
    public static final String FIELD_EXTENDMODE = "EXTENDMODE";
    public static final String FIELD_FRONTPROTYPE = "FRONTPROTYPE";
    public static final String FIELD_GLOBALFLAG = "GLOBALFLAG";
    public static final String FIELD_HTMLPAGEURL = "HTMLPAGEURL";
    public static final String FIELD_ITEMOBJ = "ITEMOBJ";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MOBPSDEVIEWID = "MOBPSDEVIEWID";
    public static final String FIELD_MOBPSDEVIEWNAME = "MOBPSDEVIEWNAME";
    public static final String FIELD_NEXTPSDEUIACTIONID = "NEXTPSDEUIACTIONID";
    public static final String FIELD_NEXTPSDEUIACTIONNAME = "NEXTPSDEUIACTIONNAME";
    public static final String FIELD_NO2PSDEDATAEXPID = "NO2PSDEDATAEXPID";
    public static final String FIELD_NO2PSDEDATAEXPNAME = "NO2PSDEDATAEXPNAME";
    public static final String FIELD_NOPRIVDM = "NOPRIVDM";
    public static final String FIELD_PARAMITEM = "PARAMITEM";
    public static final String FIELD_PDTVIEWFLAG = "PDTVIEWFLAG";
    public static final String FIELD_PSDEACMODEID = "PSDEACMODEID";
    public static final String FIELD_PSDEACMODENAME = "PSDEACMODENAME";
    public static final String FIELD_PSDEACTIONID = "PSDEACTIONID";
    public static final String FIELD_PSDEACTIONNAME = "PSDEACTIONNAME";
    public static final String FIELD_PSDEDATAEXPID = "PSDEDATAEXPID";
    public static final String FIELD_PSDEDATAIMPID = "PSDEDATAIMPID";
    public static final String FIELD_PSDEDATAIMPNAME = "PSDEDATAIMPNAME";
    public static final String FIELD_PSDEFGROUPID = "PSDEFGROUPID";
    public static final String FIELD_PSDEFGROUPNAME = "PSDEFGROUPNAME";
    public static final String FIELD_PSDEFORMID = "PSDEFORMID";
    public static final String FIELD_PSDEFORMNAME = "PSDEFORMNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDEOPPRIVID = "PSDEOPPRIVID";
    public static final String FIELD_PSDEOPPRIVNAME = "PSDEOPPRIVNAME";
    public static final String FIELD_PSDEPRINTID = "PSDEPRINTID";
    public static final String FIELD_PSDEPRINTNAME = "PSDEPRINTNAME";
    public static final String FIELD_PSDEUIACTIONID = "PSDEUIACTIONID";
    public static final String FIELD_PSDEUIACTIONNAME = "PSDEUIACTIONNAME";
    public static final String FIELD_PSDEVIEWBASEID = "PSDEVIEWBASEID";
    public static final String FIELD_PSDEVIEWBASENAME = "PSDEVIEWBASENAME";
    public static final String FIELD_PSDEVIEWLOGICID = "PSDEVIEWLOGICID";
    public static final String FIELD_PSDEVIEWLOGICNAME = "PSDEVIEWLOGICNAME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSCOUNTERID = "PSSYSCOUNTERID";
    public static final String FIELD_PSSYSCOUNTERNAME = "PSSYSCOUNTERNAME";
    public static final String FIELD_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String FIELD_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String FIELD_PSSYSIMAGEID = "PSSYSIMAGEID";
    public static final String FIELD_PSSYSIMAGENAME = "PSSYSIMAGENAME";
    public static final String FIELD_PSSYSPDTVIEWID = "PSSYSPDTVIEWID";
    public static final String FIELD_PSSYSPDTVIEWNAME = "PSSYSPDTVIEWNAME";
    public static final String FIELD_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String FIELD_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String FIELD_PSSYSREQITEMID = "PSSYSREQITEMID";
    public static final String FIELD_PSSYSREQITEMNAME = "PSSYSREQITEMNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_PSSYSUIACTIONID = "PSSYSUIACTIONID";
    public static final String FIELD_PSSYSUIACTIONNAME = "PSSYSUIACTIONNAME";
    public static final String FIELD_PSSYSVIEWLOGICID = "PSSYSVIEWLOGICID";
    public static final String FIELD_PSSYSVIEWLOGICNAME = "PSSYSVIEWLOGICNAME";
    public static final String FIELD_PSWFID = "PSWFID";
    public static final String FIELD_PSWFNAME = "PSWFNAME";
    public static final String FIELD_PSWFLINKID = "PSWFPLINKID";
    public static final String FIELD_PSWFLINKNAME = "PSWFPLINKNAME";
    public static final String FIELD_PSWFPROCESSID = "PSWFPROCESSID";
    public static final String FIELD_PSWFPROCESSNAME = "PSWFPROCESSNAME";
    public static final String FIELD_PSWFVERSIONID = "PSWFVERSIONID";
    public static final String FIELD_PSWFVERSIONNAME = "PSWFVERSIONNAME";
    public static final String FIELD_RELOADDATA = "RELOADDATA";
    public static final String FIELD_REPPSSYSUIACTIONID = "REPPSSYSUIACTIONID";
    public static final String FIELD_REPPSSYSUIACTIONNAME = "REPPSSYSUIACTIONNAME";
    public static final String FIELD_SMPSLANRESID = "SMPSLANRESID";
    public static final String FIELD_SMPSLANRESNAME = "SMPSLANRESNAME";
    public static final String FIELD_SUCCESSINFO = "SUCCESSINFO";
    public static final String FIELD_SYSITEMOBJ = "SYSITEMOBJ";
    public static final String FIELD_TEMPLMODE = "TEMPLMODE";
    public static final String FIELD_TEXTITEM = "TEXTITEM";
    public static final String FIELD_TIMEOUT = "TIMEOUT";
    public static final String FIELD_TIPPSLANRESID = "TIPPSLANRESID";
    public static final String FIELD_TIPPSLANRESNAME = "TIPPSLANRESNAME";
    public static final String FIELD_TODOTASK = "TODOTASK";
    public static final String FIELD_TOOLTIPINFO = "TOOLTIPINFO";
    public static final String FIELD_UATAG = "UATAG";
    public static final String FIELD_UATAG2 = "UATAG2";
    public static final String FIELD_UATAG3 = "UATAG3";
    public static final String FIELD_UATAG4 = "UATAG4";
    public static final String FIELD_UIACTIONCODE = "UIACTIONCODE";
    public static final String FIELD_UIACTIONPARAM = "UIACTIONPARAM";
    public static final String FIELD_UIACTIONPARAM10 = "UIACTIONPARAM10";
    public static final String FIELD_UIACTIONPARAM11 = "UIACTIONPARAM11";
    public static final String FIELD_UIACTIONPARAM12 = "UIACTIONPARAM12";
    public static final String FIELD_UIACTIONPARAM2 = "UIACTIONPARAM2";
    public static final String FIELD_UIACTIONPARAM3 = "UIACTIONPARAM3";
    public static final String FIELD_UIACTIONPARAM4 = "UIACTIONPARAM4";
    public static final String FIELD_UIACTIONPARAM5 = "UIACTIONPARAM5";
    public static final String FIELD_UIACTIONPARAM6 = "UIACTIONPARAM6";
    public static final String FIELD_UIACTIONPARAM7 = "UIACTIONPARAM7";
    public static final String FIELD_UIACTIONPARAM8 = "UIACTIONPARAM8";
    public static final String FIELD_UIACTIONPARAM9 = "UIACTIONPARAM9";
    public static final String FIELD_UIACTIONPARAMS = "UIACTIONPARAMS";
    public static final String FIELD_UIACTIONTYPE = "UIACTIONTYPE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERCONFIRM = "USERCONFIRM";
    public static final String FIELD_USERPARAMS = "USERPARAMS";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VIEWACTIONS = "VIEWACTIONS";
    public static final String FIELD_VIEWLOGICTYPE = "VIEWLOGICTYPE";
    public static final String FIELD_VISIBLELOGIC = "VISIBLELOGIC";
    public static final String FIELD_VLEXECMODE = "VLEXECMODE";
    private static final int INDEX_ACTIONLEVEL = 0;
    private static final int INDEX_ACTIONTARGET = 1;
    private static final int INDEX_BUSYINDICATOR = 2;
    private static final int INDEX_BUTTONSTYLE = 3;
    private static final int INDEX_CAPPSLANRESID = 4;
    private static final int INDEX_CAPPSLANRESNAME = 5;
    private static final int INDEX_CAPTION = 6;
    private static final int INDEX_CLOSEEDITVIEW = 7;
    private static final int INDEX_CMPSLANRESID = 8;
    private static final int INDEX_CMPSLANRESNAME = 9;
    private static final int INDEX_CODENAME = 10;
    private static final int INDEX_CONFIRMINFO = 11;
    private static final int INDEX_COUNTERID = 12;
    private static final int INDEX_CREATEDATE = 13;
    private static final int INDEX_CREATEMAN = 14;
    private static final int INDEX_CUSTOMCODE = 15;
    private static final int INDEX_DATAITEM = 16;
    private static final int INDEX_DYNAMODELFLAG = 17;
    private static final int INDEX_ENABLELOGIC = 18;
    private static final int INDEX_ENABLERTMODEL = 19;
    private static final int INDEX_ENABLEVIEWACTIONS = 20;
    private static final int INDEX_EXTENDMODE = 21;
    private static final int INDEX_FRONTPROTYPE = 22;
    private static final int INDEX_GLOBALFLAG = 23;
    private static final int INDEX_HTMLPAGEURL = 24;
    private static final int INDEX_ITEMOBJ = 25;
    private static final int INDEX_LOCKFLAG = 26;
    private static final int INDEX_MEMO = 27;
    private static final int INDEX_MOBPSDEVIEWID = 28;
    private static final int INDEX_MOBPSDEVIEWNAME = 29;
    private static final int INDEX_NEXTPSDEUIACTIONID = 30;
    private static final int INDEX_NEXTPSDEUIACTIONNAME = 31;
    private static final int INDEX_NO2PSDEDATAEXPID = 32;
    private static final int INDEX_NO2PSDEDATAEXPNAME = 33;
    private static final int INDEX_NOPRIVDM = 34;
    private static final int INDEX_PARAMITEM = 35;
    private static final int INDEX_PDTVIEWFLAG = 36;
    private static final int INDEX_PSDEACMODEID = 37;
    private static final int INDEX_PSDEACMODENAME = 38;
    private static final int INDEX_PSDEACTIONID = 39;
    private static final int INDEX_PSDEACTIONNAME = 40;
    private static final int INDEX_PSDEDATAEXPID = 41;
    private static final int INDEX_PSDEDATAIMPID = 42;
    private static final int INDEX_PSDEDATAIMPNAME = 43;
    private static final int INDEX_PSDEFGROUPID = 44;
    private static final int INDEX_PSDEFGROUPNAME = 45;
    private static final int INDEX_PSDEFORMID = 46;
    private static final int INDEX_PSDEFORMNAME = 47;
    private static final int INDEX_PSDEID = 48;
    private static final int INDEX_PSDENAME = 49;
    private static final int INDEX_PSDEOPPRIVID = 50;
    private static final int INDEX_PSDEOPPRIVNAME = 51;
    private static final int INDEX_PSDEPRINTID = 52;
    private static final int INDEX_PSDEPRINTNAME = 53;
    private static final int INDEX_PSDEUIACTIONID = 54;
    private static final int INDEX_PSDEUIACTIONNAME = 55;
    private static final int INDEX_PSDEVIEWBASEID = 56;
    private static final int INDEX_PSDEVIEWBASENAME = 57;
    private static final int INDEX_PSDEVIEWLOGICID = 58;
    private static final int INDEX_PSDEVIEWLOGICNAME = 59;
    private static final int INDEX_PSDYNAINSTID = 60;
    private static final int INDEX_PSMODULEID = 61;
    private static final int INDEX_PSMODULENAME = 62;
    private static final int INDEX_PSSYSCOUNTERID = 63;
    private static final int INDEX_PSSYSCOUNTERNAME = 64;
    private static final int INDEX_PSSYSDYNAMODELID = 65;
    private static final int INDEX_PSSYSDYNAMODELNAME = 66;
    private static final int INDEX_PSSYSIMAGEID = 67;
    private static final int INDEX_PSSYSIMAGENAME = 68;
    private static final int INDEX_PSSYSPDTVIEWID = 69;
    private static final int INDEX_PSSYSPDTVIEWNAME = 70;
    private static final int INDEX_PSSYSPFPLUGINID = 71;
    private static final int INDEX_PSSYSPFPLUGINNAME = 72;
    private static final int INDEX_PSSYSREQITEMID = 73;
    private static final int INDEX_PSSYSREQITEMNAME = 74;
    private static final int INDEX_PSSYSTEMID = 75;
    private static final int INDEX_PSSYSTEMNAME = 76;
    private static final int INDEX_PSSYSUIACTIONID = 77;
    private static final int INDEX_PSSYSUIACTIONNAME = 78;
    private static final int INDEX_PSSYSVIEWLOGICID = 79;
    private static final int INDEX_PSSYSVIEWLOGICNAME = 80;
    private static final int INDEX_PSWFID = 81;
    private static final int INDEX_PSWFNAME = 82;
    private static final int INDEX_PSWFLINKID = 83;
    private static final int INDEX_PSWFLINKNAME = 84;
    private static final int INDEX_PSWFPROCESSID = 85;
    private static final int INDEX_PSWFPROCESSNAME = 86;
    private static final int INDEX_PSWFVERSIONID = 87;
    private static final int INDEX_PSWFVERSIONNAME = 88;
    private static final int INDEX_RELOADDATA = 89;
    private static final int INDEX_REPPSSYSUIACTIONID = 90;
    private static final int INDEX_REPPSSYSUIACTIONNAME = 91;
    private static final int INDEX_SMPSLANRESID = 92;
    private static final int INDEX_SMPSLANRESNAME = 93;
    private static final int INDEX_SUCCESSINFO = 94;
    private static final int INDEX_SYSITEMOBJ = 95;
    private static final int INDEX_TEMPLMODE = 96;
    private static final int INDEX_TEXTITEM = 97;
    private static final int INDEX_TIMEOUT = 98;
    private static final int INDEX_TIPPSLANRESID = 99;
    private static final int INDEX_TIPPSLANRESNAME = 100;
    private static final int INDEX_TODOTASK = 101;
    private static final int INDEX_TOOLTIPINFO = 102;
    private static final int INDEX_UATAG = 103;
    private static final int INDEX_UATAG2 = 104;
    private static final int INDEX_UATAG3 = 105;
    private static final int INDEX_UATAG4 = 106;
    private static final int INDEX_UIACTIONCODE = 107;
    private static final int INDEX_UIACTIONPARAM = 108;
    private static final int INDEX_UIACTIONPARAM10 = 109;
    private static final int INDEX_UIACTIONPARAM11 = 110;
    private static final int INDEX_UIACTIONPARAM12 = 111;
    private static final int INDEX_UIACTIONPARAM2 = 112;
    private static final int INDEX_UIACTIONPARAM3 = 113;
    private static final int INDEX_UIACTIONPARAM4 = 114;
    private static final int INDEX_UIACTIONPARAM5 = 115;
    private static final int INDEX_UIACTIONPARAM6 = 116;
    private static final int INDEX_UIACTIONPARAM7 = 117;
    private static final int INDEX_UIACTIONPARAM8 = 118;
    private static final int INDEX_UIACTIONPARAM9 = 119;
    private static final int INDEX_UIACTIONPARAMS = 120;
    private static final int INDEX_UIACTIONTYPE = 121;
    private static final int INDEX_UPDATEDATE = 122;
    private static final int INDEX_UPDATEMAN = 123;
    private static final int INDEX_USERCAT = 124;
    private static final int INDEX_USERCONFIRM = 125;
    private static final int INDEX_USERPARAMS = 126;
    private static final int INDEX_USERTAG = 127;
    private static final int INDEX_USERTAG2 = 128;
    private static final int INDEX_USERTAG3 = 129;
    private static final int INDEX_USERTAG4 = 130;
    private static final int INDEX_VIEWACTIONS = 131;
    private static final int INDEX_VIEWLOGICTYPE = 132;
    private static final int INDEX_VISIBLELOGIC = 133;
    private static final int INDEX_VLEXECMODE = 134;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEUIActionBase proxyPSDEUIActionBase = null;
    private boolean actionlevelDirtyFlag = false;
    private boolean actiontargetDirtyFlag = false;
    private boolean busyindicatorDirtyFlag = false;
    private boolean buttonstyleDirtyFlag = false;
    private boolean cappslanresidDirtyFlag = false;
    private boolean cappslanresnameDirtyFlag = false;
    private boolean captionDirtyFlag = false;
    private boolean closeeditviewDirtyFlag = false;
    private boolean cmpslanresidDirtyFlag = false;
    private boolean cmpslanresnameDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean confirminfoDirtyFlag = false;
    private boolean counteridDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customcodeDirtyFlag = false;
    private boolean dataitemDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean enablelogicDirtyFlag = false;
    private boolean enablertmodelDirtyFlag = false;
    private boolean enableviewactionsDirtyFlag = false;
    private boolean extendmodeDirtyFlag = false;
    private boolean frontprotypeDirtyFlag = false;
    private boolean globalflagDirtyFlag = false;
    private boolean htmlpageurlDirtyFlag = false;
    private boolean itemobjDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean mobpsdeviewidDirtyFlag = false;
    private boolean mobpsdeviewnameDirtyFlag = false;
    private boolean nextpsdeuiactionidDirtyFlag = false;
    private boolean nextpsdeuiactionnameDirtyFlag = false;
    private boolean no2psdedataexpidDirtyFlag = false;
    private boolean no2psdedataexpnameDirtyFlag = false;
    private boolean noprivdmDirtyFlag = false;
    private boolean paramitemDirtyFlag = false;
    private boolean pdtviewflagDirtyFlag = false;
    private boolean psdeacmodeidDirtyFlag = false;
    private boolean psdeacmodenameDirtyFlag = false;
    private boolean psdeactionidDirtyFlag = false;
    private boolean psdeactionnameDirtyFlag = false;
    private boolean psdedataexpidDirtyFlag = false;
    private boolean psdedataimpidDirtyFlag = false;
    private boolean psdedataimpnameDirtyFlag = false;
    private boolean psdefgroupidDirtyFlag = false;
    private boolean psdefgroupnameDirtyFlag = false;
    private boolean psdeformidDirtyFlag = false;
    private boolean psdeformnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psdeopprividDirtyFlag = false;
    private boolean psdeopprivnameDirtyFlag = false;
    private boolean psdeprintidDirtyFlag = false;
    private boolean psdeprintnameDirtyFlag = false;
    private boolean psdeuiactionidDirtyFlag = false;
    private boolean psdeuiactionnameDirtyFlag = false;
    private boolean psdeviewbaseidDirtyFlag = false;
    private boolean psdeviewbasenameDirtyFlag = false;
    private boolean psdeviewlogicidDirtyFlag = false;
    private boolean psdeviewlogicnameDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssyscounteridDirtyFlag = false;
    private boolean pssyscounternameDirtyFlag = false;
    private boolean pssysdynamodelidDirtyFlag = false;
    private boolean pssysdynamodelnameDirtyFlag = false;
    private boolean pssysimageidDirtyFlag = false;
    private boolean pssysimagenameDirtyFlag = false;
    private boolean pssyspdtviewidDirtyFlag = false;
    private boolean pssyspdtviewnameDirtyFlag = false;
    private boolean pssyspfpluginidDirtyFlag = false;
    private boolean pssyspfpluginnameDirtyFlag = false;
    private boolean pssysreqitemidDirtyFlag = false;
    private boolean pssysreqitemnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean pssysuiactionidDirtyFlag = false;
    private boolean pssysuiactionnameDirtyFlag = false;
    private boolean pssysviewlogicidDirtyFlag = false;
    private boolean pssysviewlogicnameDirtyFlag = false;
    private boolean pswfidDirtyFlag = false;
    private boolean pswfnameDirtyFlag = false;
    private boolean pswflinkidDirtyFlag = false;
    private boolean pswflinknameDirtyFlag = false;
    private boolean pswfprocessidDirtyFlag = false;
    private boolean pswfprocessnameDirtyFlag = false;
    private boolean pswfversionidDirtyFlag = false;
    private boolean pswfversionnameDirtyFlag = false;
    private boolean reloaddataDirtyFlag = false;
    private boolean reppssysuiactionidDirtyFlag = false;
    private boolean reppssysuiactionnameDirtyFlag = false;
    private boolean smpslanresidDirtyFlag = false;
    private boolean smpslanresnameDirtyFlag = false;
    private boolean successinfoDirtyFlag = false;
    private boolean sysitemobjDirtyFlag = false;
    private boolean templmodeDirtyFlag = false;
    private boolean textitemDirtyFlag = false;
    private boolean timeoutDirtyFlag = false;
    private boolean tippslanresidDirtyFlag = false;
    private boolean tippslanresnameDirtyFlag = false;
    private boolean todotaskDirtyFlag = false;
    private boolean tooltipinfoDirtyFlag = false;
    private boolean uatagDirtyFlag = false;
    private boolean uatag2DirtyFlag = false;
    private boolean uatag3DirtyFlag = false;
    private boolean uatag4DirtyFlag = false;
    private boolean uiactioncodeDirtyFlag = false;
    private boolean uiactionparamDirtyFlag = false;
    private boolean uiactionparam10DirtyFlag = false;
    private boolean uiactionparam11DirtyFlag = false;
    private boolean uiactionparam12DirtyFlag = false;
    private boolean uiactionparam2DirtyFlag = false;
    private boolean uiactionparam3DirtyFlag = false;
    private boolean uiactionparam4DirtyFlag = false;
    private boolean uiactionparam5DirtyFlag = false;
    private boolean uiactionparam6DirtyFlag = false;
    private boolean uiactionparam7DirtyFlag = false;
    private boolean uiactionparam8DirtyFlag = false;
    private boolean uiactionparam9DirtyFlag = false;
    private boolean uiactionparamsDirtyFlag = false;
    private boolean uiactiontypeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean userconfirmDirtyFlag = false;
    private boolean userparamsDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean viewactionsDirtyFlag = false;
    private boolean viewlogictypeDirtyFlag = false;
    private boolean visiblelogicDirtyFlag = false;
    private boolean vlexecmodeDirtyFlag = false;
    @Column(name="actionlevel")
    private Integer actionlevel;
    @Column(name="actiontarget")
    private String actiontarget;
    @Column(name="busyindicator")
    private Integer busyindicator;
    @Column(name="buttonstyle")
    private String buttonstyle;
    @Column(name="cappslanresid")
    private String cappslanresid;
    @Column(name="cappslanresname")
    private String cappslanresname;
    @Column(name="caption")
    private String caption;
    @Column(name="closeeditview")
    private Integer closeeditview;
    @Column(name="cmpslanresid")
    private String cmpslanresid;
    @Column(name="cmpslanresname")
    private String cmpslanresname;
    @Column(name="codename")
    private String codename;
    @Column(name="confirminfo")
    private String confirminfo;
    @Column(name="counterid")
    private String counterid;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="customcode")
    private String customcode;
    @Column(name="dataitem")
    private String dataitem;
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="enablelogic")
    private String enablelogic;
    @Column(name="enablertmodel")
    private Integer enablertmodel;
    @Column(name="enableviewactions")
    private Integer enableviewactions;
    @Column(name="extendmode")
    private Integer extendmode;
    @Column(name="frontprotype")
    private String frontprotype;
    @Column(name="globalflag")
    private Integer globalflag;
    @Column(name="htmlpageurl")
    private String htmlpageurl;
    @Column(name="itemobj")
    private String itemobj;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="memo")
    private String memo;
    @Column(name="mobpsdeviewid")
    private String mobpsdeviewid;
    @Column(name="mobpsdeviewname")
    private String mobpsdeviewname;
    @Column(name="nextpsdeuiactionid")
    private String nextpsdeuiactionid;
    @Column(name="nextpsdeuiactionname")
    private String nextpsdeuiactionname;
    @Column(name="no2psdedataexpid")
    private String no2psdedataexpid;
    @Column(name="no2psdedataexpname")
    private String no2psdedataexpname;
    @Column(name="noprivdm")
    private Integer noprivdm;
    @Column(name="paramitem")
    private String paramitem;
    @Column(name="pdtviewflag")
    private Integer pdtviewflag;
    @Column(name="psdeacmodeid")
    private String psdeacmodeid;
    @Column(name="psdeacmodename")
    private String psdeacmodename;
    @Column(name="psdeactionid")
    private String psdeactionid;
    @Column(name="psdeactionname")
    private String psdeactionname;
    @Column(name="psdedataexpid")
    private String psdedataexpid;
    @Column(name="psdedataimpid")
    private String psdedataimpid;
    @Column(name="psdedataimpname")
    private String psdedataimpname;
    @Column(name="psdefgroupid")
    private String psdefgroupid;
    @Column(name="psdefgroupname")
    private String psdefgroupname;
    @Column(name="psdeformid")
    private String psdeformid;
    @Column(name="psdeformname")
    private String psdeformname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psdeopprivid")
    private String psdeopprivid;
    @Column(name="psdeopprivname")
    private String psdeopprivname;
    @Column(name="psdeprintid")
    private String psdeprintid;
    @Column(name="psdeprintname")
    private String psdeprintname;
    @Column(name="psdeuiactionid")
    private String psdeuiactionid;
    @Column(name="psdeuiactionname")
    private String psdeuiactionname;
    @Column(name="psdeviewbaseid")
    private String psdeviewbaseid;
    @Column(name="psdeviewbasename")
    private String psdeviewbasename;
    @Column(name="psdeviewlogicid")
    private String psdeviewlogicid;
    @Column(name="psdeviewlogicname")
    private String psdeviewlogicname;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssyscounterid")
    private String pssyscounterid;
    @Column(name="pssyscountername")
    private String pssyscountername;
    @Column(name="pssysdynamodelid")
    private String pssysdynamodelid;
    @Column(name="pssysdynamodelname")
    private String pssysdynamodelname;
    @Column(name="pssysimageid")
    private String pssysimageid;
    @Column(name="pssysimagename")
    private String pssysimagename;
    @Column(name="pssyspdtviewid")
    private String pssyspdtviewid;
    @Column(name="pssyspdtviewname")
    private String pssyspdtviewname;
    @Column(name="pssyspfpluginid")
    private String pssyspfpluginid;
    @Column(name="pssyspfpluginname")
    private String pssyspfpluginname;
    @Column(name="pssysreqitemid")
    private String pssysreqitemid;
    @Column(name="pssysreqitemname")
    private String pssysreqitemname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="pssysuiactionid")
    private String pssysuiactionid;
    @Column(name="pssysuiactionname")
    private String pssysuiactionname;
    @Column(name="pssysviewlogicid")
    private String pssysviewlogicid;
    @Column(name="pssysviewlogicname")
    private String pssysviewlogicname;
    @Column(name="pswfid")
    private String pswfid;
    @Column(name="pswfname")
    private String pswfname;
    @Column(name="pswflinkid")
    private String pswflinkid;
    @Column(name="pswflinkname")
    private String pswflinkname;
    @Column(name="pswfprocessid")
    private String pswfprocessid;
    @Column(name="pswfprocessname")
    private String pswfprocessname;
    @Column(name="pswfversionid")
    private String pswfversionid;
    @Column(name="pswfversionname")
    private String pswfversionname;
    @Column(name="reloaddata")
    private Integer reloaddata;
    @Column(name="reppssysuiactionid")
    private String reppssysuiactionid;
    @Column(name="reppssysuiactionname")
    private String reppssysuiactionname;
    @Column(name="smpslanresid")
    private String smpslanresid;
    @Column(name="smpslanresname")
    private String smpslanresname;
    @Column(name="successinfo")
    private String successinfo;
    @Column(name="sysitemobj")
    private String sysitemobj;
    @Column(name="templmode")
    private Integer templmode;
    @Column(name="textitem")
    private String textitem;
    @Column(name="timeout")
    private Integer timeout;
    @Column(name="tippslanresid")
    private String tippslanresid;
    @Column(name="tippslanresname")
    private String tippslanresname;
    @Column(name="todotask")
    private String todotask;
    @Column(name="tooltipinfo")
    private String tooltipinfo;
    @Column(name="uatag")
    private String uatag;
    @Column(name="uatag2")
    private String uatag2;
    @Column(name="uatag3")
    private String uatag3;
    @Column(name="uatag4")
    private String uatag4;
    @Column(name="uiactioncode")
    private String uiactioncode;
    @Column(name="uiactionparam")
    private String uiactionparam;
    @Column(name="uiactionparam10")
    private Double uiactionparam10;
    @Column(name="uiactionparam11")
    private Integer uiactionparam11;
    @Column(name="uiactionparam12")
    private Integer uiactionparam12;
    @Column(name="uiactionparam2")
    private String uiactionparam2;
    @Column(name="uiactionparam3")
    private String uiactionparam3;
    @Column(name="uiactionparam4")
    private String uiactionparam4;
    @Column(name="uiactionparam5")
    private Integer uiactionparam5;
    @Column(name="uiactionparam6")
    private Integer uiactionparam6;
    @Column(name="uiactionparam7")
    private Integer uiactionparam7;
    @Column(name="uiactionparam8")
    private Integer uiactionparam8;
    @Column(name="uiactionparam9")
    private Double uiactionparam9;
    @Column(name="uiactionparams")
    private String uiactionparams;
    @Column(name="uiactiontype")
    private String uiactiontype;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usercat")
    private String usercat;
    @Column(name="userconfirm")
    private Integer userconfirm;
    @Column(name="userparams")
    private String userparams;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="usertag3")
    private String usertag3;
    @Column(name="usertag4")
    private String usertag4;
    @Column(name="viewactions")
    private Integer viewactions;
    @Column(name="viewlogictype")
    private String viewlogictype;
    @Column(name="visiblelogic")
    private String visiblelogic;
    @Column(name="vlexecmode")
    private String vlexecmode;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSDEACModeLock = new Integer(1);
    private PSDEACMode psdeacmode = null;
    private Integer objPSDEActionLock = new Integer(1);
    private PSDEAction psdeaction = null;
    private Integer objNo2PSDEDataExpLock = new Integer(1);
    private PSDEDataExp no2psdedataexp = null;
    private Integer objPSDEDataImpLock = new Integer(1);
    private PSDEDataImp psdedataimp = null;
    private Integer objPSDEFGroupLock = new Integer(1);
    private PSDEFGroup psdefgroup = null;
    private Integer objPSDEFormLock = new Integer(1);
    private PSDEForm psdeform = null;
    private Integer objPSDEViewLogicLock = new Integer(1);
    private PSDELogic psdeviewlogic = null;
    private Integer objPSDEOpPrivLock = new Integer(1);
    private PSDEOPPriv psdeoppriv = null;
    private Integer objPSDEPrintLock = new Integer(1);
    private PSDEPrint psdeprint = null;
    private Integer objNextPSDEUIActionLock = new Integer(1);
    private PSDEUIAction nextpsdeuiaction = null;
    private Integer objMobPSDEViewLock = new Integer(1);
    private PSDEViewBase mobpsdeview = null;
    private Integer objPSDEViewBaseLock = new Integer(1);
    private PSDEViewBase psdeviewbase = null;
    private Integer objCapPSLanResLock = new Integer(1);
    private PSLanguageRes cappslanres = null;
    private Integer objCMPSLanResLock = new Integer(1);
    private PSLanguageRes cmpslanres = null;
    private Integer objSMPSLanResLock = new Integer(1);
    private PSLanguageRes smpslanres = null;
    private Integer objTipPSLanResLock = new Integer(1);
    private PSLanguageRes tippslanres = null;
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objPSSysCounterLock = new Integer(1);
    private PSSysCounter pssyscounter = null;
    private Integer objPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel pssysdynamodel = null;
    private Integer objPSSysImageLock = new Integer(1);
    private PSSysImage pssysimage = null;
    private Integer objPSSysPDTViewLock = new Integer(1);
    private PSSysPDTView pssyspdtview = null;
    private Integer objPSSysPFPluginLock = new Integer(1);
    private PSSysPFPlugin pssyspfplugin = null;
    private Integer objPSSysReqItemLock = new Integer(1);
    private PSSysReqItem pssysreqitem = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSSysUIActionLock = new Integer(1);
    private PSSysUIAction pssysuiaction = null;
    private Integer objRepPSSysUIActionLock = new Integer(1);
    private PSSysUIAction reppssysuiaction = null;
    private Integer objPSSysViewLogicLock = new Integer(1);
    private PSSysViewLogic pssysviewlogic = null;
    private Integer objPSWFLinkLock = new Integer(1);
    private PSWFLink pswflink = null;
    private Integer objPSWFProcessLock = new Integer(1);
    private PSWFProcess pswfprocess = null;
    private Integer objPSWFVersionLock = new Integer(1);
    private PSWFVersion pswfversion = null;
    private Integer objPSWFLock = new Integer(1);
    private PSWorkflow pswf = null;

    public void setActionLevel(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionLevel(n);
            return;
        }
        this.actionlevel = n;
        this.actionlevelDirtyFlag = true;
    }

    public Integer getActionLevel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionLevel();
        }
        return this.actionlevel;
    }

    public boolean isActionLevelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionLevelDirty();
        }
        return this.actionlevelDirtyFlag;
    }

    public void resetActionLevel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionLevel();
            return;
        }
        this.actionlevelDirtyFlag = false;
        this.actionlevel = null;
    }

    public void setActionTarget(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionTarget(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actiontarget = string;
        this.actiontargetDirtyFlag = true;
    }

    public String getActionTarget() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionTarget();
        }
        return this.actiontarget;
    }

    public boolean isActionTargetDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionTargetDirty();
        }
        return this.actiontargetDirtyFlag;
    }

    public void resetActionTarget() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionTarget();
            return;
        }
        this.actiontargetDirtyFlag = false;
        this.actiontarget = null;
    }

    public void setBusyIndicator(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBusyIndicator(n);
            return;
        }
        this.busyindicator = n;
        this.busyindicatorDirtyFlag = true;
    }

    public Integer getBusyIndicator() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBusyIndicator();
        }
        return this.busyindicator;
    }

    public boolean isBusyIndicatorDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBusyIndicatorDirty();
        }
        return this.busyindicatorDirtyFlag;
    }

    public void resetBusyIndicator() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBusyIndicator();
            return;
        }
        this.busyindicatorDirtyFlag = false;
        this.busyindicator = null;
    }

    public void setButtonStyle(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setButtonStyle(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.buttonstyle = string;
        this.buttonstyleDirtyFlag = true;
    }

    public String getButtonStyle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getButtonStyle();
        }
        return this.buttonstyle;
    }

    public boolean isButtonStyleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isButtonStyleDirty();
        }
        return this.buttonstyleDirtyFlag;
    }

    public void resetButtonStyle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetButtonStyle();
            return;
        }
        this.buttonstyleDirtyFlag = false;
        this.buttonstyle = null;
    }

    public void setCapPSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCapPSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cappslanresid = string;
        this.cappslanresidDirtyFlag = true;
    }

    public String getCapPSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCapPSLanResId();
        }
        return this.cappslanresid;
    }

    public boolean isCapPSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCapPSLanResIdDirty();
        }
        return this.cappslanresidDirtyFlag;
    }

    public void resetCapPSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCapPSLanResId();
            return;
        }
        this.cappslanresidDirtyFlag = false;
        this.cappslanresid = null;
    }

    public void setCapPSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCapPSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cappslanresname = string;
        this.cappslanresnameDirtyFlag = true;
    }

    public String getCapPSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCapPSLanResName();
        }
        return this.cappslanresname;
    }

    public boolean isCapPSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCapPSLanResNameDirty();
        }
        return this.cappslanresnameDirtyFlag;
    }

    public void resetCapPSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCapPSLanResName();
            return;
        }
        this.cappslanresnameDirtyFlag = false;
        this.cappslanresname = null;
    }

    public void setCaption(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCaption(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.caption = string;
        this.captionDirtyFlag = true;
    }

    public String getCaption() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCaption();
        }
        return this.caption;
    }

    public boolean isCaptionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCaptionDirty();
        }
        return this.captionDirtyFlag;
    }

    public void resetCaption() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCaption();
            return;
        }
        this.captionDirtyFlag = false;
        this.caption = null;
    }

    public void setCloseEditView(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCloseEditView(n);
            return;
        }
        this.closeeditview = n;
        this.closeeditviewDirtyFlag = true;
    }

    public Integer getCloseEditView() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCloseEditView();
        }
        return this.closeeditview;
    }

    public boolean isCloseEditViewDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCloseEditViewDirty();
        }
        return this.closeeditviewDirtyFlag;
    }

    public void resetCloseEditView() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCloseEditView();
            return;
        }
        this.closeeditviewDirtyFlag = false;
        this.closeeditview = null;
    }

    public void setCMPSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCMPSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cmpslanresid = string;
        this.cmpslanresidDirtyFlag = true;
    }

    public String getCMPSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCMPSLanResId();
        }
        return this.cmpslanresid;
    }

    public boolean isCMPSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCMPSLanResIdDirty();
        }
        return this.cmpslanresidDirtyFlag;
    }

    public void resetCMPSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCMPSLanResId();
            return;
        }
        this.cmpslanresidDirtyFlag = false;
        this.cmpslanresid = null;
    }

    public void setCMPSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCMPSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cmpslanresname = string;
        this.cmpslanresnameDirtyFlag = true;
    }

    public String getCMPSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCMPSLanResName();
        }
        return this.cmpslanresname;
    }

    public boolean isCMPSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCMPSLanResNameDirty();
        }
        return this.cmpslanresnameDirtyFlag;
    }

    public void resetCMPSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCMPSLanResName();
            return;
        }
        this.cmpslanresnameDirtyFlag = false;
        this.cmpslanresname = null;
    }

    public void setCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.codename = string;
        this.codenameDirtyFlag = true;
    }

    public String getCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeName();
        }
        return this.codename;
    }

    public boolean isCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeNameDirty();
        }
        return this.codenameDirtyFlag;
    }

    public void resetCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeName();
            return;
        }
        this.codenameDirtyFlag = false;
        this.codename = null;
    }

    public void setConfirmInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setConfirmInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.confirminfo = string;
        this.confirminfoDirtyFlag = true;
    }

    public String getConfirmInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getConfirmInfo();
        }
        return this.confirminfo;
    }

    public boolean isConfirmInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isConfirmInfoDirty();
        }
        return this.confirminfoDirtyFlag;
    }

    public void resetConfirmInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetConfirmInfo();
            return;
        }
        this.confirminfoDirtyFlag = false;
        this.confirminfo = null;
    }

    public void setCounterId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCounterId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.counterid = string;
        this.counteridDirtyFlag = true;
    }

    public String getCounterId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCounterId();
        }
        return this.counterid;
    }

    public boolean isCounterIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCounterIdDirty();
        }
        return this.counteridDirtyFlag;
    }

    public void resetCounterId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCounterId();
            return;
        }
        this.counteridDirtyFlag = false;
        this.counterid = null;
    }

    public void setCreateDate(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateDate(timestamp);
            return;
        }
        this.createdate = timestamp;
        this.createdateDirtyFlag = true;
    }

    public Timestamp getCreateDate() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreateDate();
        }
        return this.createdate;
    }

    public boolean isCreateDateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCreateDateDirty();
        }
        return this.createdateDirtyFlag;
    }

    public void resetCreateDate() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCreateDate();
            return;
        }
        this.createdateDirtyFlag = false;
        this.createdate = null;
    }

    public void setCreateMan(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateMan(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.createman = string;
        this.createmanDirtyFlag = true;
    }

    public String getCreateMan() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreateMan();
        }
        return this.createman;
    }

    public boolean isCreateManDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCreateManDirty();
        }
        return this.createmanDirtyFlag;
    }

    public void resetCreateMan() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCreateMan();
            return;
        }
        this.createmanDirtyFlag = false;
        this.createman = null;
    }

    public void setCustomCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.customcode = string;
        this.customcodeDirtyFlag = true;
    }

    public String getCustomCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomCode();
        }
        return this.customcode;
    }

    public boolean isCustomCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomCodeDirty();
        }
        return this.customcodeDirtyFlag;
    }

    public void resetCustomCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomCode();
            return;
        }
        this.customcodeDirtyFlag = false;
        this.customcode = null;
    }

    public void setDataItem(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDataItem(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dataitem = string;
        this.dataitemDirtyFlag = true;
    }

    public String getDataItem() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDataItem();
        }
        return this.dataitem;
    }

    public boolean isDataItemDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataItemDirty();
        }
        return this.dataitemDirtyFlag;
    }

    public void resetDataItem() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDataItem();
            return;
        }
        this.dataitemDirtyFlag = false;
        this.dataitem = null;
    }

    public void setDynaModelFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynaModelFlag(n);
            return;
        }
        this.dynamodelflag = n;
        this.dynamodelflagDirtyFlag = true;
    }

    public Integer getDynaModelFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynaModelFlag();
        }
        return this.dynamodelflag;
    }

    public boolean isDynaModelFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynaModelFlagDirty();
        }
        return this.dynamodelflagDirtyFlag;
    }

    public void resetDynaModelFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynaModelFlag();
            return;
        }
        this.dynamodelflagDirtyFlag = false;
        this.dynamodelflag = null;
    }

    public void setEnableLogic(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableLogic(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.enablelogic = string;
        this.enablelogicDirtyFlag = true;
    }

    public String getEnableLogic() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableLogic();
        }
        return this.enablelogic;
    }

    public boolean isEnableLogicDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableLogicDirty();
        }
        return this.enablelogicDirtyFlag;
    }

    public void resetEnableLogic() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableLogic();
            return;
        }
        this.enablelogicDirtyFlag = false;
        this.enablelogic = null;
    }

    public void setEnableRTModel(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableRTModel(n);
            return;
        }
        this.enablertmodel = n;
        this.enablertmodelDirtyFlag = true;
    }

    public Integer getEnableRTModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableRTModel();
        }
        return this.enablertmodel;
    }

    public boolean isEnableRTModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableRTModelDirty();
        }
        return this.enablertmodelDirtyFlag;
    }

    public void resetEnableRTModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableRTModel();
            return;
        }
        this.enablertmodelDirtyFlag = false;
        this.enablertmodel = null;
    }

    public void setEnableViewActions(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableViewActions(n);
            return;
        }
        this.enableviewactions = n;
        this.enableviewactionsDirtyFlag = true;
    }

    public Integer getEnableViewActions() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableViewActions();
        }
        return this.enableviewactions;
    }

    public boolean isEnableViewActionsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableViewActionsDirty();
        }
        return this.enableviewactionsDirtyFlag;
    }

    public void resetEnableViewActions() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableViewActions();
            return;
        }
        this.enableviewactionsDirtyFlag = false;
        this.enableviewactions = null;
    }

    public void setExtendMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExtendMode(n);
            return;
        }
        this.extendmode = n;
        this.extendmodeDirtyFlag = true;
    }

    public Integer getExtendMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExtendMode();
        }
        return this.extendmode;
    }

    public boolean isExtendModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExtendModeDirty();
        }
        return this.extendmodeDirtyFlag;
    }

    public void resetExtendMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExtendMode();
            return;
        }
        this.extendmodeDirtyFlag = false;
        this.extendmode = null;
    }

    public void setFrontProType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFrontProType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.frontprotype = string;
        this.frontprotypeDirtyFlag = true;
    }

    public String getFrontProType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFrontProType();
        }
        return this.frontprotype;
    }

    public boolean isFrontProTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFrontProTypeDirty();
        }
        return this.frontprotypeDirtyFlag;
    }

    public void resetFrontProType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFrontProType();
            return;
        }
        this.frontprotypeDirtyFlag = false;
        this.frontprotype = null;
    }

    public void setGlobalFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGlobalFlag(n);
            return;
        }
        this.globalflag = n;
        this.globalflagDirtyFlag = true;
    }

    public Integer getGlobalFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGlobalFlag();
        }
        return this.globalflag;
    }

    public boolean isGlobalFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGlobalFlagDirty();
        }
        return this.globalflagDirtyFlag;
    }

    public void resetGlobalFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGlobalFlag();
            return;
        }
        this.globalflagDirtyFlag = false;
        this.globalflag = null;
    }

    public void setHtmlPageUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHtmlPageUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.htmlpageurl = string;
        this.htmlpageurlDirtyFlag = true;
    }

    public String getHtmlPageUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHtmlPageUrl();
        }
        return this.htmlpageurl;
    }

    public boolean isHtmlPageUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHtmlPageUrlDirty();
        }
        return this.htmlpageurlDirtyFlag;
    }

    public void resetHtmlPageUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHtmlPageUrl();
            return;
        }
        this.htmlpageurlDirtyFlag = false;
        this.htmlpageurl = null;
    }

    public void setItemObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.itemobj = string;
        this.itemobjDirtyFlag = true;
    }

    public String getItemObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemObj();
        }
        return this.itemobj;
    }

    public boolean isItemObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemObjDirty();
        }
        return this.itemobjDirtyFlag;
    }

    public void resetItemObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemObj();
            return;
        }
        this.itemobjDirtyFlag = false;
        this.itemobj = null;
    }

    public void setLockFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLockFlag(n);
            return;
        }
        this.lockflag = n;
        this.lockflagDirtyFlag = true;
    }

    public Integer getLockFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLockFlag();
        }
        return this.lockflag;
    }

    public boolean isLockFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLockFlagDirty();
        }
        return this.lockflagDirtyFlag;
    }

    public void resetLockFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLockFlag();
            return;
        }
        this.lockflagDirtyFlag = false;
        this.lockflag = null;
    }

    public void setMemo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMemo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.memo = string;
        this.memoDirtyFlag = true;
    }

    public String getMemo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMemo();
        }
        return this.memo;
    }

    public boolean isMemoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMemoDirty();
        }
        return this.memoDirtyFlag;
    }

    public void resetMemo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMemo();
            return;
        }
        this.memoDirtyFlag = false;
        this.memo = null;
    }

    public void setMobPSDEViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobPSDEViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mobpsdeviewid = string;
        this.mobpsdeviewidDirtyFlag = true;
    }

    public String getMobPSDEViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobPSDEViewId();
        }
        return this.mobpsdeviewid;
    }

    public boolean isMobPSDEViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobPSDEViewIdDirty();
        }
        return this.mobpsdeviewidDirtyFlag;
    }

    public void resetMobPSDEViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobPSDEViewId();
            return;
        }
        this.mobpsdeviewidDirtyFlag = false;
        this.mobpsdeviewid = null;
    }

    public void setMobPSDEViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobPSDEViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mobpsdeviewname = string;
        this.mobpsdeviewnameDirtyFlag = true;
    }

    public String getMobPSDEViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobPSDEViewName();
        }
        return this.mobpsdeviewname;
    }

    public boolean isMobPSDEViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobPSDEViewNameDirty();
        }
        return this.mobpsdeviewnameDirtyFlag;
    }

    public void resetMobPSDEViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobPSDEViewName();
            return;
        }
        this.mobpsdeviewnameDirtyFlag = false;
        this.mobpsdeviewname = null;
    }

    public void setNextPSDEUIActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNextPSDEUIActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.nextpsdeuiactionid = string;
        this.nextpsdeuiactionidDirtyFlag = true;
    }

    public String getNextPSDEUIActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNextPSDEUIActionId();
        }
        return this.nextpsdeuiactionid;
    }

    public boolean isNextPSDEUIActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNextPSDEUIActionIdDirty();
        }
        return this.nextpsdeuiactionidDirtyFlag;
    }

    public void resetNextPSDEUIActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNextPSDEUIActionId();
            return;
        }
        this.nextpsdeuiactionidDirtyFlag = false;
        this.nextpsdeuiactionid = null;
    }

    public void setNextPSDEUIActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNextPSDEUIActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.nextpsdeuiactionname = string;
        this.nextpsdeuiactionnameDirtyFlag = true;
    }

    public String getNextPSDEUIActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNextPSDEUIActionName();
        }
        return this.nextpsdeuiactionname;
    }

    public boolean isNextPSDEUIActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNextPSDEUIActionNameDirty();
        }
        return this.nextpsdeuiactionnameDirtyFlag;
    }

    public void resetNextPSDEUIActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNextPSDEUIActionName();
            return;
        }
        this.nextpsdeuiactionnameDirtyFlag = false;
        this.nextpsdeuiactionname = null;
    }

    public void setNo2PSDEDataExpId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo2PSDEDataExpId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no2psdedataexpid = string;
        this.no2psdedataexpidDirtyFlag = true;
    }

    public String getNo2PSDEDataExpId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo2PSDEDataExpId();
        }
        return this.no2psdedataexpid;
    }

    public boolean isNo2PSDEDataExpIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo2PSDEDataExpIdDirty();
        }
        return this.no2psdedataexpidDirtyFlag;
    }

    public void resetNo2PSDEDataExpId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo2PSDEDataExpId();
            return;
        }
        this.no2psdedataexpidDirtyFlag = false;
        this.no2psdedataexpid = null;
    }

    public void setNo2PSDEDataExpName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo2PSDEDataExpName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no2psdedataexpname = string;
        this.no2psdedataexpnameDirtyFlag = true;
    }

    public String getNo2PSDEDataExpName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo2PSDEDataExpName();
        }
        return this.no2psdedataexpname;
    }

    public boolean isNo2PSDEDataExpNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo2PSDEDataExpNameDirty();
        }
        return this.no2psdedataexpnameDirtyFlag;
    }

    public void resetNo2PSDEDataExpName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo2PSDEDataExpName();
            return;
        }
        this.no2psdedataexpnameDirtyFlag = false;
        this.no2psdedataexpname = null;
    }

    public void setNoPrivDM(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNoPrivDM(n);
            return;
        }
        this.noprivdm = n;
        this.noprivdmDirtyFlag = true;
    }

    public Integer getNoPrivDM() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNoPrivDM();
        }
        return this.noprivdm;
    }

    public boolean isNoPrivDMDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNoPrivDMDirty();
        }
        return this.noprivdmDirtyFlag;
    }

    public void resetNoPrivDM() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNoPrivDM();
            return;
        }
        this.noprivdmDirtyFlag = false;
        this.noprivdm = null;
    }

    public void setParamItem(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParamItem(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.paramitem = string;
        this.paramitemDirtyFlag = true;
    }

    public String getParamItem() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParamItem();
        }
        return this.paramitem;
    }

    public boolean isParamItemDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParamItemDirty();
        }
        return this.paramitemDirtyFlag;
    }

    public void resetParamItem() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParamItem();
            return;
        }
        this.paramitemDirtyFlag = false;
        this.paramitem = null;
    }

    public void setPDTViewFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPDTViewFlag(n);
            return;
        }
        this.pdtviewflag = n;
        this.pdtviewflagDirtyFlag = true;
    }

    public Integer getPDTViewFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPDTViewFlag();
        }
        return this.pdtviewflag;
    }

    public boolean isPDTViewFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPDTViewFlagDirty();
        }
        return this.pdtviewflagDirtyFlag;
    }

    public void resetPDTViewFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPDTViewFlag();
            return;
        }
        this.pdtviewflagDirtyFlag = false;
        this.pdtviewflag = null;
    }

    public void setPSDEACModeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEACModeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeacmodeid = string;
        this.psdeacmodeidDirtyFlag = true;
    }

    public String getPSDEACModeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEACModeId();
        }
        return this.psdeacmodeid;
    }

    public boolean isPSDEACModeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEACModeIdDirty();
        }
        return this.psdeacmodeidDirtyFlag;
    }

    public void resetPSDEACModeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEACModeId();
            return;
        }
        this.psdeacmodeidDirtyFlag = false;
        this.psdeacmodeid = null;
    }

    public void setPSDEACModeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEACModeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeacmodename = string;
        this.psdeacmodenameDirtyFlag = true;
    }

    public String getPSDEACModeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEACModeName();
        }
        return this.psdeacmodename;
    }

    public boolean isPSDEACModeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEACModeNameDirty();
        }
        return this.psdeacmodenameDirtyFlag;
    }

    public void resetPSDEACModeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEACModeName();
            return;
        }
        this.psdeacmodenameDirtyFlag = false;
        this.psdeacmodename = null;
    }

    public void setPSDEActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeactionid = string;
        this.psdeactionidDirtyFlag = true;
    }

    public String getPSDEActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEActionId();
        }
        return this.psdeactionid;
    }

    public boolean isPSDEActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEActionIdDirty();
        }
        return this.psdeactionidDirtyFlag;
    }

    public void resetPSDEActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEActionId();
            return;
        }
        this.psdeactionidDirtyFlag = false;
        this.psdeactionid = null;
    }

    public void setPSDEActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeactionname = string;
        this.psdeactionnameDirtyFlag = true;
    }

    public String getPSDEActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEActionName();
        }
        return this.psdeactionname;
    }

    public boolean isPSDEActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEActionNameDirty();
        }
        return this.psdeactionnameDirtyFlag;
    }

    public void resetPSDEActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEActionName();
            return;
        }
        this.psdeactionnameDirtyFlag = false;
        this.psdeactionname = null;
    }

    public void setPSDEDataExpId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataExpId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedataexpid = string;
        this.psdedataexpidDirtyFlag = true;
    }

    public String getPSDEDataExpId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataExpId();
        }
        return this.psdedataexpid;
    }

    public boolean isPSDEDataExpIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataExpIdDirty();
        }
        return this.psdedataexpidDirtyFlag;
    }

    public void resetPSDEDataExpId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataExpId();
            return;
        }
        this.psdedataexpidDirtyFlag = false;
        this.psdedataexpid = null;
    }

    public void setPSDEDataImpId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataImpId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedataimpid = string;
        this.psdedataimpidDirtyFlag = true;
    }

    public String getPSDEDataImpId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataImpId();
        }
        return this.psdedataimpid;
    }

    public boolean isPSDEDataImpIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataImpIdDirty();
        }
        return this.psdedataimpidDirtyFlag;
    }

    public void resetPSDEDataImpId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataImpId();
            return;
        }
        this.psdedataimpidDirtyFlag = false;
        this.psdedataimpid = null;
    }

    public void setPSDEDataImpName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataImpName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedataimpname = string;
        this.psdedataimpnameDirtyFlag = true;
    }

    public String getPSDEDataImpName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataImpName();
        }
        return this.psdedataimpname;
    }

    public boolean isPSDEDataImpNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataImpNameDirty();
        }
        return this.psdedataimpnameDirtyFlag;
    }

    public void resetPSDEDataImpName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataImpName();
            return;
        }
        this.psdedataimpnameDirtyFlag = false;
        this.psdedataimpname = null;
    }

    public void setPSDEFGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefgroupid = string;
        this.psdefgroupidDirtyFlag = true;
    }

    public String getPSDEFGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFGroupId();
        }
        return this.psdefgroupid;
    }

    public boolean isPSDEFGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFGroupIdDirty();
        }
        return this.psdefgroupidDirtyFlag;
    }

    public void resetPSDEFGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFGroupId();
            return;
        }
        this.psdefgroupidDirtyFlag = false;
        this.psdefgroupid = null;
    }

    public void setPSDEFGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefgroupname = string;
        this.psdefgroupnameDirtyFlag = true;
    }

    public String getPSDEFGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFGroupName();
        }
        return this.psdefgroupname;
    }

    public boolean isPSDEFGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFGroupNameDirty();
        }
        return this.psdefgroupnameDirtyFlag;
    }

    public void resetPSDEFGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFGroupName();
            return;
        }
        this.psdefgroupnameDirtyFlag = false;
        this.psdefgroupname = null;
    }

    public void setPSDEFormId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFormId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeformid = string;
        this.psdeformidDirtyFlag = true;
    }

    public String getPSDEFormId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFormId();
        }
        return this.psdeformid;
    }

    public boolean isPSDEFormIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFormIdDirty();
        }
        return this.psdeformidDirtyFlag;
    }

    public void resetPSDEFormId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFormId();
            return;
        }
        this.psdeformidDirtyFlag = false;
        this.psdeformid = null;
    }

    public void setPSDEFormName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFormName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeformname = string;
        this.psdeformnameDirtyFlag = true;
    }

    public String getPSDEFormName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFormName();
        }
        return this.psdeformname;
    }

    public boolean isPSDEFormNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFormNameDirty();
        }
        return this.psdeformnameDirtyFlag;
    }

    public void resetPSDEFormName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFormName();
            return;
        }
        this.psdeformnameDirtyFlag = false;
        this.psdeformname = null;
    }

    public void setPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeid = string;
        this.psdeidDirtyFlag = true;
    }

    public String getPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEId();
        }
        return this.psdeid;
    }

    public boolean isPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEIdDirty();
        }
        return this.psdeidDirtyFlag;
    }

    public void resetPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEId();
            return;
        }
        this.psdeidDirtyFlag = false;
        this.psdeid = null;
    }

    public void setPSDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdename = string;
        this.psdenameDirtyFlag = true;
    }

    public String getPSDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEName();
        }
        return this.psdename;
    }

    public boolean isPSDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDENameDirty();
        }
        return this.psdenameDirtyFlag;
    }

    public void resetPSDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEName();
            return;
        }
        this.psdenameDirtyFlag = false;
        this.psdename = null;
    }

    public void setPSDEOPPrivId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEOPPrivId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeopprivid = string;
        this.psdeopprividDirtyFlag = true;
    }

    public String getPSDEOPPrivId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEOPPrivId();
        }
        return this.psdeopprivid;
    }

    public boolean isPSDEOPPrivIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEOPPrivIdDirty();
        }
        return this.psdeopprividDirtyFlag;
    }

    public void resetPSDEOPPrivId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEOPPrivId();
            return;
        }
        this.psdeopprividDirtyFlag = false;
        this.psdeopprivid = null;
    }

    public void setPSDEOPPrivName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEOPPrivName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeopprivname = string;
        this.psdeopprivnameDirtyFlag = true;
    }

    public String getPSDEOPPrivName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEOPPrivName();
        }
        return this.psdeopprivname;
    }

    public boolean isPSDEOPPrivNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEOPPrivNameDirty();
        }
        return this.psdeopprivnameDirtyFlag;
    }

    public void resetPSDEOPPrivName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEOPPrivName();
            return;
        }
        this.psdeopprivnameDirtyFlag = false;
        this.psdeopprivname = null;
    }

    public void setPSDEPrintId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEPrintId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeprintid = string;
        this.psdeprintidDirtyFlag = true;
    }

    public String getPSDEPrintId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEPrintId();
        }
        return this.psdeprintid;
    }

    public boolean isPSDEPrintIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEPrintIdDirty();
        }
        return this.psdeprintidDirtyFlag;
    }

    public void resetPSDEPrintId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEPrintId();
            return;
        }
        this.psdeprintidDirtyFlag = false;
        this.psdeprintid = null;
    }

    public void setPSDEPrintName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEPrintName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeprintname = string;
        this.psdeprintnameDirtyFlag = true;
    }

    public String getPSDEPrintName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEPrintName();
        }
        return this.psdeprintname;
    }

    public boolean isPSDEPrintNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEPrintNameDirty();
        }
        return this.psdeprintnameDirtyFlag;
    }

    public void resetPSDEPrintName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEPrintName();
            return;
        }
        this.psdeprintnameDirtyFlag = false;
        this.psdeprintname = null;
    }

    public void setPSDEUIActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEUIActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeuiactionid = string;
        this.psdeuiactionidDirtyFlag = true;
    }

    public String getPSDEUIActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUIActionId();
        }
        return this.psdeuiactionid;
    }

    public boolean isPSDEUIActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEUIActionIdDirty();
        }
        return this.psdeuiactionidDirtyFlag;
    }

    public void resetPSDEUIActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEUIActionId();
            return;
        }
        this.psdeuiactionidDirtyFlag = false;
        this.psdeuiactionid = null;
    }

    public void setPSDEUIActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEUIActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeuiactionname = string;
        this.psdeuiactionnameDirtyFlag = true;
    }

    public String getPSDEUIActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUIActionName();
        }
        return this.psdeuiactionname;
    }

    public boolean isPSDEUIActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEUIActionNameDirty();
        }
        return this.psdeuiactionnameDirtyFlag;
    }

    public void resetPSDEUIActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEUIActionName();
            return;
        }
        this.psdeuiactionnameDirtyFlag = false;
        this.psdeuiactionname = null;
    }

    public void setPSDEViewBaseId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewBaseId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewbaseid = string;
        this.psdeviewbaseidDirtyFlag = true;
    }

    public String getPSDEViewBaseId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewBaseId();
        }
        return this.psdeviewbaseid;
    }

    public boolean isPSDEViewBaseIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewBaseIdDirty();
        }
        return this.psdeviewbaseidDirtyFlag;
    }

    public void resetPSDEViewBaseId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewBaseId();
            return;
        }
        this.psdeviewbaseidDirtyFlag = false;
        this.psdeviewbaseid = null;
    }

    public void setPSDEViewBaseName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewBaseName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewbasename = string;
        this.psdeviewbasenameDirtyFlag = true;
    }

    public String getPSDEViewBaseName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewBaseName();
        }
        return this.psdeviewbasename;
    }

    public boolean isPSDEViewBaseNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewBaseNameDirty();
        }
        return this.psdeviewbasenameDirtyFlag;
    }

    public void resetPSDEViewBaseName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewBaseName();
            return;
        }
        this.psdeviewbasenameDirtyFlag = false;
        this.psdeviewbasename = null;
    }

    public void setPSDEViewLogicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewLogicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewlogicid = string;
        this.psdeviewlogicidDirtyFlag = true;
    }

    public String getPSDEViewLogicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewLogicId();
        }
        return this.psdeviewlogicid;
    }

    public boolean isPSDEViewLogicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewLogicIdDirty();
        }
        return this.psdeviewlogicidDirtyFlag;
    }

    public void resetPSDEViewLogicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewLogicId();
            return;
        }
        this.psdeviewlogicidDirtyFlag = false;
        this.psdeviewlogicid = null;
    }

    public void setPSDEViewLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewlogicname = string;
        this.psdeviewlogicnameDirtyFlag = true;
    }

    public String getPSDEViewLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewLogicName();
        }
        return this.psdeviewlogicname;
    }

    public boolean isPSDEViewLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewLogicNameDirty();
        }
        return this.psdeviewlogicnameDirtyFlag;
    }

    public void resetPSDEViewLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewLogicName();
            return;
        }
        this.psdeviewlogicnameDirtyFlag = false;
        this.psdeviewlogicname = null;
    }

    public void setPSDynaInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynainstid = string;
        this.psdynainstidDirtyFlag = true;
    }

    public String getPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaInstId();
        }
        return this.psdynainstid;
    }

    public boolean isPSDynaInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaInstIdDirty();
        }
        return this.psdynainstidDirtyFlag;
    }

    public void resetPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaInstId();
            return;
        }
        this.psdynainstidDirtyFlag = false;
        this.psdynainstid = null;
    }

    public void setPSModuleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModuleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmoduleid = string;
        this.psmoduleidDirtyFlag = true;
    }

    public String getPSModuleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModuleId();
        }
        return this.psmoduleid;
    }

    public boolean isPSModuleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModuleIdDirty();
        }
        return this.psmoduleidDirtyFlag;
    }

    public void resetPSModuleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModuleId();
            return;
        }
        this.psmoduleidDirtyFlag = false;
        this.psmoduleid = null;
    }

    public void setPSModuleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModuleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodulename = string;
        this.psmodulenameDirtyFlag = true;
    }

    public String getPSModuleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModuleName();
        }
        return this.psmodulename;
    }

    public boolean isPSModuleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModuleNameDirty();
        }
        return this.psmodulenameDirtyFlag;
    }

    public void resetPSModuleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModuleName();
            return;
        }
        this.psmodulenameDirtyFlag = false;
        this.psmodulename = null;
    }

    public void setPSSysCounterId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCounterId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscounterid = string;
        this.pssyscounteridDirtyFlag = true;
    }

    public String getPSSysCounterId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCounterId();
        }
        return this.pssyscounterid;
    }

    public boolean isPSSysCounterIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCounterIdDirty();
        }
        return this.pssyscounteridDirtyFlag;
    }

    public void resetPSSysCounterId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCounterId();
            return;
        }
        this.pssyscounteridDirtyFlag = false;
        this.pssyscounterid = null;
    }

    public void setPSSysCounterName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCounterName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscountername = string;
        this.pssyscounternameDirtyFlag = true;
    }

    public String getPSSysCounterName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCounterName();
        }
        return this.pssyscountername;
    }

    public boolean isPSSysCounterNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCounterNameDirty();
        }
        return this.pssyscounternameDirtyFlag;
    }

    public void resetPSSysCounterName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCounterName();
            return;
        }
        this.pssyscounternameDirtyFlag = false;
        this.pssyscountername = null;
    }

    public void setPSSysDynaModelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDynaModelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdynamodelid = string;
        this.pssysdynamodelidDirtyFlag = true;
    }

    public String getPSSysDynaModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModelId();
        }
        return this.pssysdynamodelid;
    }

    public boolean isPSSysDynaModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDynaModelIdDirty();
        }
        return this.pssysdynamodelidDirtyFlag;
    }

    public void resetPSSysDynaModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDynaModelId();
            return;
        }
        this.pssysdynamodelidDirtyFlag = false;
        this.pssysdynamodelid = null;
    }

    public void setPSSysDynaModelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDynaModelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdynamodelname = string;
        this.pssysdynamodelnameDirtyFlag = true;
    }

    public String getPSSysDynaModelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModelName();
        }
        return this.pssysdynamodelname;
    }

    public boolean isPSSysDynaModelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDynaModelNameDirty();
        }
        return this.pssysdynamodelnameDirtyFlag;
    }

    public void resetPSSysDynaModelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDynaModelName();
            return;
        }
        this.pssysdynamodelnameDirtyFlag = false;
        this.pssysdynamodelname = null;
    }

    public void setPSSysImageId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysImageId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysimageid = string;
        this.pssysimageidDirtyFlag = true;
    }

    public String getPSSysImageId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysImageId();
        }
        return this.pssysimageid;
    }

    public boolean isPSSysImageIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysImageIdDirty();
        }
        return this.pssysimageidDirtyFlag;
    }

    public void resetPSSysImageId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysImageId();
            return;
        }
        this.pssysimageidDirtyFlag = false;
        this.pssysimageid = null;
    }

    public void setPSSysImageName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysImageName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysimagename = string;
        this.pssysimagenameDirtyFlag = true;
    }

    public String getPSSysImageName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysImageName();
        }
        return this.pssysimagename;
    }

    public boolean isPSSysImageNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysImageNameDirty();
        }
        return this.pssysimagenameDirtyFlag;
    }

    public void resetPSSysImageName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysImageName();
            return;
        }
        this.pssysimagenameDirtyFlag = false;
        this.pssysimagename = null;
    }

    public void setPSSysPDTViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysPDTViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyspdtviewid = string;
        this.pssyspdtviewidDirtyFlag = true;
    }

    public String getPSSysPDTViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPDTViewId();
        }
        return this.pssyspdtviewid;
    }

    public boolean isPSSysPDTViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysPDTViewIdDirty();
        }
        return this.pssyspdtviewidDirtyFlag;
    }

    public void resetPSSysPDTViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysPDTViewId();
            return;
        }
        this.pssyspdtviewidDirtyFlag = false;
        this.pssyspdtviewid = null;
    }

    public void setPSSysPDTViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysPDTViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyspdtviewname = string;
        this.pssyspdtviewnameDirtyFlag = true;
    }

    public String getPSSysPDTViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPDTViewName();
        }
        return this.pssyspdtviewname;
    }

    public boolean isPSSysPDTViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysPDTViewNameDirty();
        }
        return this.pssyspdtviewnameDirtyFlag;
    }

    public void resetPSSysPDTViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysPDTViewName();
            return;
        }
        this.pssyspdtviewnameDirtyFlag = false;
        this.pssyspdtviewname = null;
    }

    public void setPSSysPFPluginId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysPFPluginId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyspfpluginid = string;
        this.pssyspfpluginidDirtyFlag = true;
    }

    public String getPSSysPFPluginId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPFPluginId();
        }
        return this.pssyspfpluginid;
    }

    public boolean isPSSysPFPluginIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysPFPluginIdDirty();
        }
        return this.pssyspfpluginidDirtyFlag;
    }

    public void resetPSSysPFPluginId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysPFPluginId();
            return;
        }
        this.pssyspfpluginidDirtyFlag = false;
        this.pssyspfpluginid = null;
    }

    public void setPSSysPFPluginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysPFPluginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyspfpluginname = string;
        this.pssyspfpluginnameDirtyFlag = true;
    }

    public String getPSSysPFPluginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPFPluginName();
        }
        return this.pssyspfpluginname;
    }

    public boolean isPSSysPFPluginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysPFPluginNameDirty();
        }
        return this.pssyspfpluginnameDirtyFlag;
    }

    public void resetPSSysPFPluginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysPFPluginName();
            return;
        }
        this.pssyspfpluginnameDirtyFlag = false;
        this.pssyspfpluginname = null;
    }

    public void setPSSysReqItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysReqItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysreqitemid = string;
        this.pssysreqitemidDirtyFlag = true;
    }

    public String getPSSysReqItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysReqItemId();
        }
        return this.pssysreqitemid;
    }

    public boolean isPSSysReqItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysReqItemIdDirty();
        }
        return this.pssysreqitemidDirtyFlag;
    }

    public void resetPSSysReqItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysReqItemId();
            return;
        }
        this.pssysreqitemidDirtyFlag = false;
        this.pssysreqitemid = null;
    }

    public void setPSSysReqItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysReqItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysreqitemname = string;
        this.pssysreqitemnameDirtyFlag = true;
    }

    public String getPSSysReqItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysReqItemName();
        }
        return this.pssysreqitemname;
    }

    public boolean isPSSysReqItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysReqItemNameDirty();
        }
        return this.pssysreqitemnameDirtyFlag;
    }

    public void resetPSSysReqItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysReqItemName();
            return;
        }
        this.pssysreqitemnameDirtyFlag = false;
        this.pssysreqitemname = null;
    }

    public void setPSSystemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemid = string;
        this.pssystemidDirtyFlag = true;
    }

    public String getPSSystemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemId();
        }
        return this.pssystemid;
    }

    public boolean isPSSystemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemIdDirty();
        }
        return this.pssystemidDirtyFlag;
    }

    public void resetPSSystemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemId();
            return;
        }
        this.pssystemidDirtyFlag = false;
        this.pssystemid = null;
    }

    public void setPSSystemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemname = string;
        this.pssystemnameDirtyFlag = true;
    }

    public String getPSSystemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemName();
        }
        return this.pssystemname;
    }

    public boolean isPSSystemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemNameDirty();
        }
        return this.pssystemnameDirtyFlag;
    }

    public void resetPSSystemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemName();
            return;
        }
        this.pssystemnameDirtyFlag = false;
        this.pssystemname = null;
    }

    public void setPSSysUIActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUIActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysuiactionid = string;
        this.pssysuiactionidDirtyFlag = true;
    }

    public String getPSSysUIActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUIActionId();
        }
        return this.pssysuiactionid;
    }

    public boolean isPSSysUIActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUIActionIdDirty();
        }
        return this.pssysuiactionidDirtyFlag;
    }

    public void resetPSSysUIActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUIActionId();
            return;
        }
        this.pssysuiactionidDirtyFlag = false;
        this.pssysuiactionid = null;
    }

    public void setPSSysUIActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUIActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysuiactionname = string;
        this.pssysuiactionnameDirtyFlag = true;
    }

    public String getPSSysUIActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUIActionName();
        }
        return this.pssysuiactionname;
    }

    public boolean isPSSysUIActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUIActionNameDirty();
        }
        return this.pssysuiactionnameDirtyFlag;
    }

    public void resetPSSysUIActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUIActionName();
            return;
        }
        this.pssysuiactionnameDirtyFlag = false;
        this.pssysuiactionname = null;
    }

    public void setPSSysViewLogicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysViewLogicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysviewlogicid = string;
        this.pssysviewlogicidDirtyFlag = true;
    }

    public String getPSSysViewLogicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewLogicId();
        }
        return this.pssysviewlogicid;
    }

    public boolean isPSSysViewLogicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysViewLogicIdDirty();
        }
        return this.pssysviewlogicidDirtyFlag;
    }

    public void resetPSSysViewLogicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysViewLogicId();
            return;
        }
        this.pssysviewlogicidDirtyFlag = false;
        this.pssysviewlogicid = null;
    }

    public void setPSSysViewLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysViewLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysviewlogicname = string;
        this.pssysviewlogicnameDirtyFlag = true;
    }

    public String getPSSysViewLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewLogicName();
        }
        return this.pssysviewlogicname;
    }

    public boolean isPSSysViewLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysViewLogicNameDirty();
        }
        return this.pssysviewlogicnameDirtyFlag;
    }

    public void resetPSSysViewLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysViewLogicName();
            return;
        }
        this.pssysviewlogicnameDirtyFlag = false;
        this.pssysviewlogicname = null;
    }

    public void setPSWFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfid = string;
        this.pswfidDirtyFlag = true;
    }

    public String getPSWFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFId();
        }
        return this.pswfid;
    }

    public boolean isPSWFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFIdDirty();
        }
        return this.pswfidDirtyFlag;
    }

    public void resetPSWFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFId();
            return;
        }
        this.pswfidDirtyFlag = false;
        this.pswfid = null;
    }

    public void setPSWFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfname = string;
        this.pswfnameDirtyFlag = true;
    }

    public String getPSWFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFName();
        }
        return this.pswfname;
    }

    public boolean isPSWFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFNameDirty();
        }
        return this.pswfnameDirtyFlag;
    }

    public void resetPSWFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFName();
            return;
        }
        this.pswfnameDirtyFlag = false;
        this.pswfname = null;
    }

    public void setPSWFLinkId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFLinkId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswflinkid = string;
        this.pswflinkidDirtyFlag = true;
    }

    public String getPSWFLinkId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFLinkId();
        }
        return this.pswflinkid;
    }

    public boolean isPSWFLinkIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFLinkIdDirty();
        }
        return this.pswflinkidDirtyFlag;
    }

    public void resetPSWFLinkId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFLinkId();
            return;
        }
        this.pswflinkidDirtyFlag = false;
        this.pswflinkid = null;
    }

    public void setPSWFLinkName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFLinkName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswflinkname = string;
        this.pswflinknameDirtyFlag = true;
    }

    public String getPSWFLinkName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFLinkName();
        }
        return this.pswflinkname;
    }

    public boolean isPSWFLinkNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFLinkNameDirty();
        }
        return this.pswflinknameDirtyFlag;
    }

    public void resetPSWFLinkName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFLinkName();
            return;
        }
        this.pswflinknameDirtyFlag = false;
        this.pswflinkname = null;
    }

    public void setPSWFProcessId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFProcessId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfprocessid = string;
        this.pswfprocessidDirtyFlag = true;
    }

    public String getPSWFProcessId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFProcessId();
        }
        return this.pswfprocessid;
    }

    public boolean isPSWFProcessIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFProcessIdDirty();
        }
        return this.pswfprocessidDirtyFlag;
    }

    public void resetPSWFProcessId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFProcessId();
            return;
        }
        this.pswfprocessidDirtyFlag = false;
        this.pswfprocessid = null;
    }

    public void setPSWFProcessName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFProcessName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfprocessname = string;
        this.pswfprocessnameDirtyFlag = true;
    }

    public String getPSWFProcessName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFProcessName();
        }
        return this.pswfprocessname;
    }

    public boolean isPSWFProcessNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFProcessNameDirty();
        }
        return this.pswfprocessnameDirtyFlag;
    }

    public void resetPSWFProcessName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFProcessName();
            return;
        }
        this.pswfprocessnameDirtyFlag = false;
        this.pswfprocessname = null;
    }

    public void setPSWFVersionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFVersionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfversionid = string;
        this.pswfversionidDirtyFlag = true;
    }

    public String getPSWFVersionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFVersionId();
        }
        return this.pswfversionid;
    }

    public boolean isPSWFVersionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFVersionIdDirty();
        }
        return this.pswfversionidDirtyFlag;
    }

    public void resetPSWFVersionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFVersionId();
            return;
        }
        this.pswfversionidDirtyFlag = false;
        this.pswfversionid = null;
    }

    public void setPSWFVersionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFVersionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfversionname = string;
        this.pswfversionnameDirtyFlag = true;
    }

    public String getPSWFVersionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFVersionName();
        }
        return this.pswfversionname;
    }

    public boolean isPSWFVersionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFVersionNameDirty();
        }
        return this.pswfversionnameDirtyFlag;
    }

    public void resetPSWFVersionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFVersionName();
            return;
        }
        this.pswfversionnameDirtyFlag = false;
        this.pswfversionname = null;
    }

    public void setReloadData(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReloadData(n);
            return;
        }
        this.reloaddata = n;
        this.reloaddataDirtyFlag = true;
    }

    public Integer getReloadData() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReloadData();
        }
        return this.reloaddata;
    }

    public boolean isReloadDataDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReloadDataDirty();
        }
        return this.reloaddataDirtyFlag;
    }

    public void resetReloadData() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReloadData();
            return;
        }
        this.reloaddataDirtyFlag = false;
        this.reloaddata = null;
    }

    public void setRepPSSysUIActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRepPSSysUIActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.reppssysuiactionid = string;
        this.reppssysuiactionidDirtyFlag = true;
    }

    public String getRepPSSysUIActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRepPSSysUIActionId();
        }
        return this.reppssysuiactionid;
    }

    public boolean isRepPSSysUIActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRepPSSysUIActionIdDirty();
        }
        return this.reppssysuiactionidDirtyFlag;
    }

    public void resetRepPSSysUIActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRepPSSysUIActionId();
            return;
        }
        this.reppssysuiactionidDirtyFlag = false;
        this.reppssysuiactionid = null;
    }

    public void setRepPSSysUIActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRepPSSysUIActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.reppssysuiactionname = string;
        this.reppssysuiactionnameDirtyFlag = true;
    }

    public String getRepPSSysUIActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRepPSSysUIActionName();
        }
        return this.reppssysuiactionname;
    }

    public boolean isRepPSSysUIActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRepPSSysUIActionNameDirty();
        }
        return this.reppssysuiactionnameDirtyFlag;
    }

    public void resetRepPSSysUIActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRepPSSysUIActionName();
            return;
        }
        this.reppssysuiactionnameDirtyFlag = false;
        this.reppssysuiactionname = null;
    }

    public void setSMPSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSMPSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.smpslanresid = string;
        this.smpslanresidDirtyFlag = true;
    }

    public String getSMPSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSMPSLanResId();
        }
        return this.smpslanresid;
    }

    public boolean isSMPSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSMPSLanResIdDirty();
        }
        return this.smpslanresidDirtyFlag;
    }

    public void resetSMPSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSMPSLanResId();
            return;
        }
        this.smpslanresidDirtyFlag = false;
        this.smpslanresid = null;
    }

    public void setSMPSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSMPSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.smpslanresname = string;
        this.smpslanresnameDirtyFlag = true;
    }

    public String getSMPSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSMPSLanResName();
        }
        return this.smpslanresname;
    }

    public boolean isSMPSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSMPSLanResNameDirty();
        }
        return this.smpslanresnameDirtyFlag;
    }

    public void resetSMPSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSMPSLanResName();
            return;
        }
        this.smpslanresnameDirtyFlag = false;
        this.smpslanresname = null;
    }

    public void setSuccessInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSuccessInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.successinfo = string;
        this.successinfoDirtyFlag = true;
    }

    public String getSuccessInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSuccessInfo();
        }
        return this.successinfo;
    }

    public boolean isSuccessInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSuccessInfoDirty();
        }
        return this.successinfoDirtyFlag;
    }

    public void resetSuccessInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSuccessInfo();
            return;
        }
        this.successinfoDirtyFlag = false;
        this.successinfo = null;
    }

    public void setSysItemObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysItemObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sysitemobj = string;
        this.sysitemobjDirtyFlag = true;
    }

    public String getSysItemObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysItemObj();
        }
        return this.sysitemobj;
    }

    public boolean isSysItemObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysItemObjDirty();
        }
        return this.sysitemobjDirtyFlag;
    }

    public void resetSysItemObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysItemObj();
            return;
        }
        this.sysitemobjDirtyFlag = false;
        this.sysitemobj = null;
    }

    public void setTemplMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplMode(n);
            return;
        }
        this.templmode = n;
        this.templmodeDirtyFlag = true;
    }

    public Integer getTemplMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplMode();
        }
        return this.templmode;
    }

    public boolean isTemplModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplModeDirty();
        }
        return this.templmodeDirtyFlag;
    }

    public void resetTemplMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplMode();
            return;
        }
        this.templmodeDirtyFlag = false;
        this.templmode = null;
    }

    public void setTextItem(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTextItem(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.textitem = string;
        this.textitemDirtyFlag = true;
    }

    public String getTextItem() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTextItem();
        }
        return this.textitem;
    }

    public boolean isTextItemDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTextItemDirty();
        }
        return this.textitemDirtyFlag;
    }

    public void resetTextItem() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTextItem();
            return;
        }
        this.textitemDirtyFlag = false;
        this.textitem = null;
    }

    public void setTimeout(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTimeout(n);
            return;
        }
        this.timeout = n;
        this.timeoutDirtyFlag = true;
    }

    public Integer getTimeout() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTimeout();
        }
        return this.timeout;
    }

    public boolean isTimeoutDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTimeoutDirty();
        }
        return this.timeoutDirtyFlag;
    }

    public void resetTimeout() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTimeout();
            return;
        }
        this.timeoutDirtyFlag = false;
        this.timeout = null;
    }

    public void setTipPSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTipPSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tippslanresid = string;
        this.tippslanresidDirtyFlag = true;
    }

    public String getTipPSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTipPSLanResId();
        }
        return this.tippslanresid;
    }

    public boolean isTipPSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTipPSLanResIdDirty();
        }
        return this.tippslanresidDirtyFlag;
    }

    public void resetTipPSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTipPSLanResId();
            return;
        }
        this.tippslanresidDirtyFlag = false;
        this.tippslanresid = null;
    }

    public void setTipPSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTipPSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tippslanresname = string;
        this.tippslanresnameDirtyFlag = true;
    }

    public String getTipPSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTipPSLanResName();
        }
        return this.tippslanresname;
    }

    public boolean isTipPSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTipPSLanResNameDirty();
        }
        return this.tippslanresnameDirtyFlag;
    }

    public void resetTipPSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTipPSLanResName();
            return;
        }
        this.tippslanresnameDirtyFlag = false;
        this.tippslanresname = null;
    }

    public void setToDoTask(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setToDoTask(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.todotask = string;
        this.todotaskDirtyFlag = true;
    }

    public String getToDoTask() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getToDoTask();
        }
        return this.todotask;
    }

    public boolean isToDoTaskDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isToDoTaskDirty();
        }
        return this.todotaskDirtyFlag;
    }

    public void resetToDoTask() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetToDoTask();
            return;
        }
        this.todotaskDirtyFlag = false;
        this.todotask = null;
    }

    public void setTooltipInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTooltipInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tooltipinfo = string;
        this.tooltipinfoDirtyFlag = true;
    }

    public String getTooltipInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTooltipInfo();
        }
        return this.tooltipinfo;
    }

    public boolean isTooltipInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTooltipInfoDirty();
        }
        return this.tooltipinfoDirtyFlag;
    }

    public void resetTooltipInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTooltipInfo();
            return;
        }
        this.tooltipinfoDirtyFlag = false;
        this.tooltipinfo = null;
    }

    public void setUATag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUATag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.uatag = string;
        this.uatagDirtyFlag = true;
    }

    public String getUATag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUATag();
        }
        return this.uatag;
    }

    public boolean isUATagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUATagDirty();
        }
        return this.uatagDirtyFlag;
    }

    public void resetUATag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUATag();
            return;
        }
        this.uatagDirtyFlag = false;
        this.uatag = null;
    }

    public void setUATag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUATag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.uatag2 = string;
        this.uatag2DirtyFlag = true;
    }

    public String getUATag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUATag2();
        }
        return this.uatag2;
    }

    public boolean isUATag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUATag2Dirty();
        }
        return this.uatag2DirtyFlag;
    }

    public void resetUATag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUATag2();
            return;
        }
        this.uatag2DirtyFlag = false;
        this.uatag2 = null;
    }

    public void setUATag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUATag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.uatag3 = string;
        this.uatag3DirtyFlag = true;
    }

    public String getUATag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUATag3();
        }
        return this.uatag3;
    }

    public boolean isUATag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUATag3Dirty();
        }
        return this.uatag3DirtyFlag;
    }

    public void resetUATag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUATag3();
            return;
        }
        this.uatag3DirtyFlag = false;
        this.uatag3 = null;
    }

    public void setUATag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUATag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.uatag4 = string;
        this.uatag4DirtyFlag = true;
    }

    public String getUATag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUATag4();
        }
        return this.uatag4;
    }

    public boolean isUATag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUATag4Dirty();
        }
        return this.uatag4DirtyFlag;
    }

    public void resetUATag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUATag4();
            return;
        }
        this.uatag4DirtyFlag = false;
        this.uatag4 = null;
    }

    public void setUIActionCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUIActionCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.uiactioncode = string;
        this.uiactioncodeDirtyFlag = true;
    }

    public String getUIActionCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUIActionCode();
        }
        return this.uiactioncode;
    }

    public boolean isUIActionCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUIActionCodeDirty();
        }
        return this.uiactioncodeDirtyFlag;
    }

    public void resetUIActionCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUIActionCode();
            return;
        }
        this.uiactioncodeDirtyFlag = false;
        this.uiactioncode = null;
    }

    public void setUIActionParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUIActionParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.uiactionparam = string;
        this.uiactionparamDirtyFlag = true;
    }

    public String getUIActionParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUIActionParam();
        }
        return this.uiactionparam;
    }

    public boolean isUIActionParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUIActionParamDirty();
        }
        return this.uiactionparamDirtyFlag;
    }

    public void resetUIActionParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUIActionParam();
            return;
        }
        this.uiactionparamDirtyFlag = false;
        this.uiactionparam = null;
    }

    public void setUIActionParam10(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUIActionParam10(d);
            return;
        }
        this.uiactionparam10 = d;
        this.uiactionparam10DirtyFlag = true;
    }

    public Double getUIActionParam10() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUIActionParam10();
        }
        return this.uiactionparam10;
    }

    public boolean isUIActionParam10Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUIActionParam10Dirty();
        }
        return this.uiactionparam10DirtyFlag;
    }

    public void resetUIActionParam10() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUIActionParam10();
            return;
        }
        this.uiactionparam10DirtyFlag = false;
        this.uiactionparam10 = null;
    }

    public void setUIActionParam11(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUIActionParam11(n);
            return;
        }
        this.uiactionparam11 = n;
        this.uiactionparam11DirtyFlag = true;
    }

    public Integer getUIActionParam11() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUIActionParam11();
        }
        return this.uiactionparam11;
    }

    public boolean isUIActionParam11Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUIActionParam11Dirty();
        }
        return this.uiactionparam11DirtyFlag;
    }

    public void resetUIActionParam11() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUIActionParam11();
            return;
        }
        this.uiactionparam11DirtyFlag = false;
        this.uiactionparam11 = null;
    }

    public void setUIActionParam12(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUIActionParam12(n);
            return;
        }
        this.uiactionparam12 = n;
        this.uiactionparam12DirtyFlag = true;
    }

    public Integer getUIActionParam12() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUIActionParam12();
        }
        return this.uiactionparam12;
    }

    public boolean isUIActionParam12Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUIActionParam12Dirty();
        }
        return this.uiactionparam12DirtyFlag;
    }

    public void resetUIActionParam12() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUIActionParam12();
            return;
        }
        this.uiactionparam12DirtyFlag = false;
        this.uiactionparam12 = null;
    }

    public void setUIActionParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUIActionParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.uiactionparam2 = string;
        this.uiactionparam2DirtyFlag = true;
    }

    public String getUIActionParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUIActionParam2();
        }
        return this.uiactionparam2;
    }

    public boolean isUIActionParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUIActionParam2Dirty();
        }
        return this.uiactionparam2DirtyFlag;
    }

    public void resetUIActionParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUIActionParam2();
            return;
        }
        this.uiactionparam2DirtyFlag = false;
        this.uiactionparam2 = null;
    }

    public void setUIActionParam3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUIActionParam3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.uiactionparam3 = string;
        this.uiactionparam3DirtyFlag = true;
    }

    public String getUIActionParam3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUIActionParam3();
        }
        return this.uiactionparam3;
    }

    public boolean isUIActionParam3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUIActionParam3Dirty();
        }
        return this.uiactionparam3DirtyFlag;
    }

    public void resetUIActionParam3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUIActionParam3();
            return;
        }
        this.uiactionparam3DirtyFlag = false;
        this.uiactionparam3 = null;
    }

    public void setUIActionParam4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUIActionParam4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.uiactionparam4 = string;
        this.uiactionparam4DirtyFlag = true;
    }

    public String getUIActionParam4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUIActionParam4();
        }
        return this.uiactionparam4;
    }

    public boolean isUIActionParam4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUIActionParam4Dirty();
        }
        return this.uiactionparam4DirtyFlag;
    }

    public void resetUIActionParam4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUIActionParam4();
            return;
        }
        this.uiactionparam4DirtyFlag = false;
        this.uiactionparam4 = null;
    }

    public void setUIActionParam5(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUIActionParam5(n);
            return;
        }
        this.uiactionparam5 = n;
        this.uiactionparam5DirtyFlag = true;
    }

    public Integer getUIActionParam5() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUIActionParam5();
        }
        return this.uiactionparam5;
    }

    public boolean isUIActionParam5Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUIActionParam5Dirty();
        }
        return this.uiactionparam5DirtyFlag;
    }

    public void resetUIActionParam5() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUIActionParam5();
            return;
        }
        this.uiactionparam5DirtyFlag = false;
        this.uiactionparam5 = null;
    }

    public void setUIActionParam6(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUIActionParam6(n);
            return;
        }
        this.uiactionparam6 = n;
        this.uiactionparam6DirtyFlag = true;
    }

    public Integer getUIActionParam6() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUIActionParam6();
        }
        return this.uiactionparam6;
    }

    public boolean isUIActionParam6Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUIActionParam6Dirty();
        }
        return this.uiactionparam6DirtyFlag;
    }

    public void resetUIActionParam6() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUIActionParam6();
            return;
        }
        this.uiactionparam6DirtyFlag = false;
        this.uiactionparam6 = null;
    }

    public void setUIActionParam7(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUIActionParam7(n);
            return;
        }
        this.uiactionparam7 = n;
        this.uiactionparam7DirtyFlag = true;
    }

    public Integer getUIActionParam7() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUIActionParam7();
        }
        return this.uiactionparam7;
    }

    public boolean isUIActionParam7Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUIActionParam7Dirty();
        }
        return this.uiactionparam7DirtyFlag;
    }

    public void resetUIActionParam7() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUIActionParam7();
            return;
        }
        this.uiactionparam7DirtyFlag = false;
        this.uiactionparam7 = null;
    }

    public void setUIActionParam8(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUIActionParam8(n);
            return;
        }
        this.uiactionparam8 = n;
        this.uiactionparam8DirtyFlag = true;
    }

    public Integer getUIActionParam8() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUIActionParam8();
        }
        return this.uiactionparam8;
    }

    public boolean isUIActionParam8Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUIActionParam8Dirty();
        }
        return this.uiactionparam8DirtyFlag;
    }

    public void resetUIActionParam8() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUIActionParam8();
            return;
        }
        this.uiactionparam8DirtyFlag = false;
        this.uiactionparam8 = null;
    }

    public void setUIActionParam9(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUIActionParam9(d);
            return;
        }
        this.uiactionparam9 = d;
        this.uiactionparam9DirtyFlag = true;
    }

    public Double getUIActionParam9() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUIActionParam9();
        }
        return this.uiactionparam9;
    }

    public boolean isUIActionParam9Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUIActionParam9Dirty();
        }
        return this.uiactionparam9DirtyFlag;
    }

    public void resetUIActionParam9() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUIActionParam9();
            return;
        }
        this.uiactionparam9DirtyFlag = false;
        this.uiactionparam9 = null;
    }

    public void setUIActionParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUIActionParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.uiactionparams = string;
        this.uiactionparamsDirtyFlag = true;
    }

    public String getUIActionParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUIActionParams();
        }
        return this.uiactionparams;
    }

    public boolean isUIActionParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUIActionParamsDirty();
        }
        return this.uiactionparamsDirtyFlag;
    }

    public void resetUIActionParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUIActionParams();
            return;
        }
        this.uiactionparamsDirtyFlag = false;
        this.uiactionparams = null;
    }

    public void setUIActionType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUIActionType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.uiactiontype = string;
        this.uiactiontypeDirtyFlag = true;
    }

    public String getUIActionType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUIActionType();
        }
        return this.uiactiontype;
    }

    public boolean isUIActionTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUIActionTypeDirty();
        }
        return this.uiactiontypeDirtyFlag;
    }

    public void resetUIActionType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUIActionType();
            return;
        }
        this.uiactiontypeDirtyFlag = false;
        this.uiactiontype = null;
    }

    public void setUpdateDate(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateDate(timestamp);
            return;
        }
        this.updatedate = timestamp;
        this.updatedateDirtyFlag = true;
    }

    public Timestamp getUpdateDate() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUpdateDate();
        }
        return this.updatedate;
    }

    public boolean isUpdateDateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUpdateDateDirty();
        }
        return this.updatedateDirtyFlag;
    }

    public void resetUpdateDate() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUpdateDate();
            return;
        }
        this.updatedateDirtyFlag = false;
        this.updatedate = null;
    }

    public void setUpdateMan(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateMan(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.updateman = string;
        this.updatemanDirtyFlag = true;
    }

    public String getUpdateMan() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUpdateMan();
        }
        return this.updateman;
    }

    public boolean isUpdateManDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUpdateManDirty();
        }
        return this.updatemanDirtyFlag;
    }

    public void resetUpdateMan() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUpdateMan();
            return;
        }
        this.updatemanDirtyFlag = false;
        this.updateman = null;
    }

    public void setUserCat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserCat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usercat = string;
        this.usercatDirtyFlag = true;
    }

    public String getUserCat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserCat();
        }
        return this.usercat;
    }

    public boolean isUserCatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserCatDirty();
        }
        return this.usercatDirtyFlag;
    }

    public void resetUserCat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserCat();
            return;
        }
        this.usercatDirtyFlag = false;
        this.usercat = null;
    }

    public void setUserConfirm(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserConfirm(n);
            return;
        }
        this.userconfirm = n;
        this.userconfirmDirtyFlag = true;
    }

    public Integer getUserConfirm() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserConfirm();
        }
        return this.userconfirm;
    }

    public boolean isUserConfirmDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserConfirmDirty();
        }
        return this.userconfirmDirtyFlag;
    }

    public void resetUserConfirm() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserConfirm();
            return;
        }
        this.userconfirmDirtyFlag = false;
        this.userconfirm = null;
    }

    public void setUserParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userparams = string;
        this.userparamsDirtyFlag = true;
    }

    public String getUserParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserParams();
        }
        return this.userparams;
    }

    public boolean isUserParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserParamsDirty();
        }
        return this.userparamsDirtyFlag;
    }

    public void resetUserParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserParams();
            return;
        }
        this.userparamsDirtyFlag = false;
        this.userparams = null;
    }

    public void setUserTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag = string;
        this.usertagDirtyFlag = true;
    }

    public String getUserTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag();
        }
        return this.usertag;
    }

    public boolean isUserTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTagDirty();
        }
        return this.usertagDirtyFlag;
    }

    public void resetUserTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag();
            return;
        }
        this.usertagDirtyFlag = false;
        this.usertag = null;
    }

    public void setUserTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag2 = string;
        this.usertag2DirtyFlag = true;
    }

    public String getUserTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag2();
        }
        return this.usertag2;
    }

    public boolean isUserTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag2Dirty();
        }
        return this.usertag2DirtyFlag;
    }

    public void resetUserTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag2();
            return;
        }
        this.usertag2DirtyFlag = false;
        this.usertag2 = null;
    }

    public void setUserTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag3 = string;
        this.usertag3DirtyFlag = true;
    }

    public String getUserTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag3();
        }
        return this.usertag3;
    }

    public boolean isUserTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag3Dirty();
        }
        return this.usertag3DirtyFlag;
    }

    public void resetUserTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag3();
            return;
        }
        this.usertag3DirtyFlag = false;
        this.usertag3 = null;
    }

    public void setUserTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag4 = string;
        this.usertag4DirtyFlag = true;
    }

    public String getUserTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag4();
        }
        return this.usertag4;
    }

    public boolean isUserTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag4Dirty();
        }
        return this.usertag4DirtyFlag;
    }

    public void resetUserTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag4();
            return;
        }
        this.usertag4DirtyFlag = false;
        this.usertag4 = null;
    }

    public void setViewActions(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewActions(n);
            return;
        }
        this.viewactions = n;
        this.viewactionsDirtyFlag = true;
    }

    public Integer getViewActions() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewActions();
        }
        return this.viewactions;
    }

    public boolean isViewActionsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewActionsDirty();
        }
        return this.viewactionsDirtyFlag;
    }

    public void resetViewActions() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewActions();
            return;
        }
        this.viewactionsDirtyFlag = false;
        this.viewactions = null;
    }

    public void setViewLogicType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewLogicType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.viewlogictype = string;
        this.viewlogictypeDirtyFlag = true;
    }

    public String getViewLogicType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewLogicType();
        }
        return this.viewlogictype;
    }

    public boolean isViewLogicTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewLogicTypeDirty();
        }
        return this.viewlogictypeDirtyFlag;
    }

    public void resetViewLogicType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewLogicType();
            return;
        }
        this.viewlogictypeDirtyFlag = false;
        this.viewlogictype = null;
    }

    public void setVisibleLogic(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVisibleLogic(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.visiblelogic = string;
        this.visiblelogicDirtyFlag = true;
    }

    public String getVisibleLogic() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVisibleLogic();
        }
        return this.visiblelogic;
    }

    public boolean isVisibleLogicDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVisibleLogicDirty();
        }
        return this.visiblelogicDirtyFlag;
    }

    public void resetVisibleLogic() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVisibleLogic();
            return;
        }
        this.visiblelogicDirtyFlag = false;
        this.visiblelogic = null;
    }

    public void setVLExecMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVLExecMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.vlexecmode = string;
        this.vlexecmodeDirtyFlag = true;
    }

    public String getVLExecMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVLExecMode();
        }
        return this.vlexecmode;
    }

    public boolean isVLExecModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVLExecModeDirty();
        }
        return this.vlexecmodeDirtyFlag;
    }

    public void resetVLExecMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVLExecMode();
            return;
        }
        this.vlexecmodeDirtyFlag = false;
        this.vlexecmode = null;
    }

    protected void onReset() {
        PSDEUIActionBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEUIActionBase pSDEUIActionBase) {
        pSDEUIActionBase.resetActionLevel();
        pSDEUIActionBase.resetActionTarget();
        pSDEUIActionBase.resetBusyIndicator();
        pSDEUIActionBase.resetButtonStyle();
        pSDEUIActionBase.resetCapPSLanResId();
        pSDEUIActionBase.resetCapPSLanResName();
        pSDEUIActionBase.resetCaption();
        pSDEUIActionBase.resetCloseEditView();
        pSDEUIActionBase.resetCMPSLanResId();
        pSDEUIActionBase.resetCMPSLanResName();
        pSDEUIActionBase.resetCodeName();
        pSDEUIActionBase.resetConfirmInfo();
        pSDEUIActionBase.resetCounterId();
        pSDEUIActionBase.resetCreateDate();
        pSDEUIActionBase.resetCreateMan();
        pSDEUIActionBase.resetCustomCode();
        pSDEUIActionBase.resetDataItem();
        pSDEUIActionBase.resetDynaModelFlag();
        pSDEUIActionBase.resetEnableLogic();
        pSDEUIActionBase.resetEnableRTModel();
        pSDEUIActionBase.resetEnableViewActions();
        pSDEUIActionBase.resetExtendMode();
        pSDEUIActionBase.resetFrontProType();
        pSDEUIActionBase.resetGlobalFlag();
        pSDEUIActionBase.resetHtmlPageUrl();
        pSDEUIActionBase.resetItemObj();
        pSDEUIActionBase.resetLockFlag();
        pSDEUIActionBase.resetMemo();
        pSDEUIActionBase.resetMobPSDEViewId();
        pSDEUIActionBase.resetMobPSDEViewName();
        pSDEUIActionBase.resetNextPSDEUIActionId();
        pSDEUIActionBase.resetNextPSDEUIActionName();
        pSDEUIActionBase.resetNo2PSDEDataExpId();
        pSDEUIActionBase.resetNo2PSDEDataExpName();
        pSDEUIActionBase.resetNoPrivDM();
        pSDEUIActionBase.resetParamItem();
        pSDEUIActionBase.resetPDTViewFlag();
        pSDEUIActionBase.resetPSDEACModeId();
        pSDEUIActionBase.resetPSDEACModeName();
        pSDEUIActionBase.resetPSDEActionId();
        pSDEUIActionBase.resetPSDEActionName();
        pSDEUIActionBase.resetPSDEDataExpId();
        pSDEUIActionBase.resetPSDEDataImpId();
        pSDEUIActionBase.resetPSDEDataImpName();
        pSDEUIActionBase.resetPSDEFGroupId();
        pSDEUIActionBase.resetPSDEFGroupName();
        pSDEUIActionBase.resetPSDEFormId();
        pSDEUIActionBase.resetPSDEFormName();
        pSDEUIActionBase.resetPSDEId();
        pSDEUIActionBase.resetPSDEName();
        pSDEUIActionBase.resetPSDEOPPrivId();
        pSDEUIActionBase.resetPSDEOPPrivName();
        pSDEUIActionBase.resetPSDEPrintId();
        pSDEUIActionBase.resetPSDEPrintName();
        pSDEUIActionBase.resetPSDEUIActionId();
        pSDEUIActionBase.resetPSDEUIActionName();
        pSDEUIActionBase.resetPSDEViewBaseId();
        pSDEUIActionBase.resetPSDEViewBaseName();
        pSDEUIActionBase.resetPSDEViewLogicId();
        pSDEUIActionBase.resetPSDEViewLogicName();
        pSDEUIActionBase.resetPSDynaInstId();
        pSDEUIActionBase.resetPSModuleId();
        pSDEUIActionBase.resetPSModuleName();
        pSDEUIActionBase.resetPSSysCounterId();
        pSDEUIActionBase.resetPSSysCounterName();
        pSDEUIActionBase.resetPSSysDynaModelId();
        pSDEUIActionBase.resetPSSysDynaModelName();
        pSDEUIActionBase.resetPSSysImageId();
        pSDEUIActionBase.resetPSSysImageName();
        pSDEUIActionBase.resetPSSysPDTViewId();
        pSDEUIActionBase.resetPSSysPDTViewName();
        pSDEUIActionBase.resetPSSysPFPluginId();
        pSDEUIActionBase.resetPSSysPFPluginName();
        pSDEUIActionBase.resetPSSysReqItemId();
        pSDEUIActionBase.resetPSSysReqItemName();
        pSDEUIActionBase.resetPSSystemId();
        pSDEUIActionBase.resetPSSystemName();
        pSDEUIActionBase.resetPSSysUIActionId();
        pSDEUIActionBase.resetPSSysUIActionName();
        pSDEUIActionBase.resetPSSysViewLogicId();
        pSDEUIActionBase.resetPSSysViewLogicName();
        pSDEUIActionBase.resetPSWFId();
        pSDEUIActionBase.resetPSWFName();
        pSDEUIActionBase.resetPSWFLinkId();
        pSDEUIActionBase.resetPSWFLinkName();
        pSDEUIActionBase.resetPSWFProcessId();
        pSDEUIActionBase.resetPSWFProcessName();
        pSDEUIActionBase.resetPSWFVersionId();
        pSDEUIActionBase.resetPSWFVersionName();
        pSDEUIActionBase.resetReloadData();
        pSDEUIActionBase.resetRepPSSysUIActionId();
        pSDEUIActionBase.resetRepPSSysUIActionName();
        pSDEUIActionBase.resetSMPSLanResId();
        pSDEUIActionBase.resetSMPSLanResName();
        pSDEUIActionBase.resetSuccessInfo();
        pSDEUIActionBase.resetSysItemObj();
        pSDEUIActionBase.resetTemplMode();
        pSDEUIActionBase.resetTextItem();
        pSDEUIActionBase.resetTimeout();
        pSDEUIActionBase.resetTipPSLanResId();
        pSDEUIActionBase.resetTipPSLanResName();
        pSDEUIActionBase.resetToDoTask();
        pSDEUIActionBase.resetTooltipInfo();
        pSDEUIActionBase.resetUATag();
        pSDEUIActionBase.resetUATag2();
        pSDEUIActionBase.resetUATag3();
        pSDEUIActionBase.resetUATag4();
        pSDEUIActionBase.resetUIActionCode();
        pSDEUIActionBase.resetUIActionParam();
        pSDEUIActionBase.resetUIActionParam10();
        pSDEUIActionBase.resetUIActionParam11();
        pSDEUIActionBase.resetUIActionParam12();
        pSDEUIActionBase.resetUIActionParam2();
        pSDEUIActionBase.resetUIActionParam3();
        pSDEUIActionBase.resetUIActionParam4();
        pSDEUIActionBase.resetUIActionParam5();
        pSDEUIActionBase.resetUIActionParam6();
        pSDEUIActionBase.resetUIActionParam7();
        pSDEUIActionBase.resetUIActionParam8();
        pSDEUIActionBase.resetUIActionParam9();
        pSDEUIActionBase.resetUIActionParams();
        pSDEUIActionBase.resetUIActionType();
        pSDEUIActionBase.resetUpdateDate();
        pSDEUIActionBase.resetUpdateMan();
        pSDEUIActionBase.resetUserCat();
        pSDEUIActionBase.resetUserConfirm();
        pSDEUIActionBase.resetUserParams();
        pSDEUIActionBase.resetUserTag();
        pSDEUIActionBase.resetUserTag2();
        pSDEUIActionBase.resetUserTag3();
        pSDEUIActionBase.resetUserTag4();
        pSDEUIActionBase.resetViewActions();
        pSDEUIActionBase.resetViewLogicType();
        pSDEUIActionBase.resetVisibleLogic();
        pSDEUIActionBase.resetVLExecMode();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isActionLevelDirty()) {
            hashMap.put(FIELD_ACTIONLEVEL, this.getActionLevel());
        }
        if (!bl || this.isActionTargetDirty()) {
            hashMap.put(FIELD_ACTIONTARGET, this.getActionTarget());
        }
        if (!bl || this.isBusyIndicatorDirty()) {
            hashMap.put(FIELD_BUSYINDICATOR, this.getBusyIndicator());
        }
        if (!bl || this.isButtonStyleDirty()) {
            hashMap.put(FIELD_BUTTONSTYLE, this.getButtonStyle());
        }
        if (!bl || this.isCapPSLanResIdDirty()) {
            hashMap.put(FIELD_CAPPSLANRESID, this.getCapPSLanResId());
        }
        if (!bl || this.isCapPSLanResNameDirty()) {
            hashMap.put(FIELD_CAPPSLANRESNAME, this.getCapPSLanResName());
        }
        if (!bl || this.isCaptionDirty()) {
            hashMap.put(FIELD_CAPTION, this.getCaption());
        }
        if (!bl || this.isCloseEditViewDirty()) {
            hashMap.put(FIELD_CLOSEEDITVIEW, this.getCloseEditView());
        }
        if (!bl || this.isCMPSLanResIdDirty()) {
            hashMap.put(FIELD_CMPSLANRESID, this.getCMPSLanResId());
        }
        if (!bl || this.isCMPSLanResNameDirty()) {
            hashMap.put(FIELD_CMPSLANRESNAME, this.getCMPSLanResName());
        }
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isConfirmInfoDirty()) {
            hashMap.put(FIELD_CONFIRMINFO, this.getConfirmInfo());
        }
        if (!bl || this.isCounterIdDirty()) {
            hashMap.put(FIELD_COUNTERID, this.getCounterId());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCustomCodeDirty()) {
            hashMap.put(FIELD_CUSTOMCODE, this.getCustomCode());
        }
        if (!bl || this.isDataItemDirty()) {
            hashMap.put(FIELD_DATAITEM, this.getDataItem());
        }
        if (!bl || this.isDynaModelFlagDirty()) {
            hashMap.put(FIELD_DYNAMODELFLAG, this.getDynaModelFlag());
        }
        if (!bl || this.isEnableLogicDirty()) {
            hashMap.put(FIELD_ENABLELOGIC, this.getEnableLogic());
        }
        if (!bl || this.isEnableRTModelDirty()) {
            hashMap.put(FIELD_ENABLERTMODEL, this.getEnableRTModel());
        }
        if (!bl || this.isEnableViewActionsDirty()) {
            hashMap.put(FIELD_ENABLEVIEWACTIONS, this.getEnableViewActions());
        }
        if (!bl || this.isExtendModeDirty()) {
            hashMap.put(FIELD_EXTENDMODE, this.getExtendMode());
        }
        if (!bl || this.isFrontProTypeDirty()) {
            hashMap.put(FIELD_FRONTPROTYPE, this.getFrontProType());
        }
        if (!bl || this.isGlobalFlagDirty()) {
            hashMap.put(FIELD_GLOBALFLAG, this.getGlobalFlag());
        }
        if (!bl || this.isHtmlPageUrlDirty()) {
            hashMap.put(FIELD_HTMLPAGEURL, this.getHtmlPageUrl());
        }
        if (!bl || this.isItemObjDirty()) {
            hashMap.put(FIELD_ITEMOBJ, this.getItemObj());
        }
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMobPSDEViewIdDirty()) {
            hashMap.put(FIELD_MOBPSDEVIEWID, this.getMobPSDEViewId());
        }
        if (!bl || this.isMobPSDEViewNameDirty()) {
            hashMap.put(FIELD_MOBPSDEVIEWNAME, this.getMobPSDEViewName());
        }
        if (!bl || this.isNextPSDEUIActionIdDirty()) {
            hashMap.put(FIELD_NEXTPSDEUIACTIONID, this.getNextPSDEUIActionId());
        }
        if (!bl || this.isNextPSDEUIActionNameDirty()) {
            hashMap.put(FIELD_NEXTPSDEUIACTIONNAME, this.getNextPSDEUIActionName());
        }
        if (!bl || this.isNo2PSDEDataExpIdDirty()) {
            hashMap.put(FIELD_NO2PSDEDATAEXPID, this.getNo2PSDEDataExpId());
        }
        if (!bl || this.isNo2PSDEDataExpNameDirty()) {
            hashMap.put(FIELD_NO2PSDEDATAEXPNAME, this.getNo2PSDEDataExpName());
        }
        if (!bl || this.isNoPrivDMDirty()) {
            hashMap.put(FIELD_NOPRIVDM, this.getNoPrivDM());
        }
        if (!bl || this.isParamItemDirty()) {
            hashMap.put(FIELD_PARAMITEM, this.getParamItem());
        }
        if (!bl || this.isPDTViewFlagDirty()) {
            hashMap.put(FIELD_PDTVIEWFLAG, this.getPDTViewFlag());
        }
        if (!bl || this.isPSDEACModeIdDirty()) {
            hashMap.put(FIELD_PSDEACMODEID, this.getPSDEACModeId());
        }
        if (!bl || this.isPSDEACModeNameDirty()) {
            hashMap.put(FIELD_PSDEACMODENAME, this.getPSDEACModeName());
        }
        if (!bl || this.isPSDEActionIdDirty()) {
            hashMap.put(FIELD_PSDEACTIONID, this.getPSDEActionId());
        }
        if (!bl || this.isPSDEActionNameDirty()) {
            hashMap.put(FIELD_PSDEACTIONNAME, this.getPSDEActionName());
        }
        if (!bl || this.isPSDEDataExpIdDirty()) {
            hashMap.put(FIELD_PSDEDATAEXPID, this.getPSDEDataExpId());
        }
        if (!bl || this.isPSDEDataImpIdDirty()) {
            hashMap.put(FIELD_PSDEDATAIMPID, this.getPSDEDataImpId());
        }
        if (!bl || this.isPSDEDataImpNameDirty()) {
            hashMap.put(FIELD_PSDEDATAIMPNAME, this.getPSDEDataImpName());
        }
        if (!bl || this.isPSDEFGroupIdDirty()) {
            hashMap.put(FIELD_PSDEFGROUPID, this.getPSDEFGroupId());
        }
        if (!bl || this.isPSDEFGroupNameDirty()) {
            hashMap.put(FIELD_PSDEFGROUPNAME, this.getPSDEFGroupName());
        }
        if (!bl || this.isPSDEFormIdDirty()) {
            hashMap.put(FIELD_PSDEFORMID, this.getPSDEFormId());
        }
        if (!bl || this.isPSDEFormNameDirty()) {
            hashMap.put(FIELD_PSDEFORMNAME, this.getPSDEFormName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSDEOPPrivIdDirty()) {
            hashMap.put(FIELD_PSDEOPPRIVID, this.getPSDEOPPrivId());
        }
        if (!bl || this.isPSDEOPPrivNameDirty()) {
            hashMap.put(FIELD_PSDEOPPRIVNAME, this.getPSDEOPPrivName());
        }
        if (!bl || this.isPSDEPrintIdDirty()) {
            hashMap.put(FIELD_PSDEPRINTID, this.getPSDEPrintId());
        }
        if (!bl || this.isPSDEPrintNameDirty()) {
            hashMap.put(FIELD_PSDEPRINTNAME, this.getPSDEPrintName());
        }
        if (!bl || this.isPSDEUIActionIdDirty()) {
            hashMap.put(FIELD_PSDEUIACTIONID, this.getPSDEUIActionId());
        }
        if (!bl || this.isPSDEUIActionNameDirty()) {
            hashMap.put(FIELD_PSDEUIACTIONNAME, this.getPSDEUIActionName());
        }
        if (!bl || this.isPSDEViewBaseIdDirty()) {
            hashMap.put(FIELD_PSDEVIEWBASEID, this.getPSDEViewBaseId());
        }
        if (!bl || this.isPSDEViewBaseNameDirty()) {
            hashMap.put(FIELD_PSDEVIEWBASENAME, this.getPSDEViewBaseName());
        }
        if (!bl || this.isPSDEViewLogicIdDirty()) {
            hashMap.put(FIELD_PSDEVIEWLOGICID, this.getPSDEViewLogicId());
        }
        if (!bl || this.isPSDEViewLogicNameDirty()) {
            hashMap.put(FIELD_PSDEVIEWLOGICNAME, this.getPSDEViewLogicName());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSModuleIdDirty()) {
            hashMap.put(FIELD_PSMODULEID, this.getPSModuleId());
        }
        if (!bl || this.isPSModuleNameDirty()) {
            hashMap.put(FIELD_PSMODULENAME, this.getPSModuleName());
        }
        if (!bl || this.isPSSysCounterIdDirty()) {
            hashMap.put(FIELD_PSSYSCOUNTERID, this.getPSSysCounterId());
        }
        if (!bl || this.isPSSysCounterNameDirty()) {
            hashMap.put(FIELD_PSSYSCOUNTERNAME, this.getPSSysCounterName());
        }
        if (!bl || this.isPSSysDynaModelIdDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELID, this.getPSSysDynaModelId());
        }
        if (!bl || this.isPSSysDynaModelNameDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELNAME, this.getPSSysDynaModelName());
        }
        if (!bl || this.isPSSysImageIdDirty()) {
            hashMap.put(FIELD_PSSYSIMAGEID, this.getPSSysImageId());
        }
        if (!bl || this.isPSSysImageNameDirty()) {
            hashMap.put(FIELD_PSSYSIMAGENAME, this.getPSSysImageName());
        }
        if (!bl || this.isPSSysPDTViewIdDirty()) {
            hashMap.put(FIELD_PSSYSPDTVIEWID, this.getPSSysPDTViewId());
        }
        if (!bl || this.isPSSysPDTViewNameDirty()) {
            hashMap.put(FIELD_PSSYSPDTVIEWNAME, this.getPSSysPDTViewName());
        }
        if (!bl || this.isPSSysPFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSPFPLUGINID, this.getPSSysPFPluginId());
        }
        if (!bl || this.isPSSysPFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSPFPLUGINNAME, this.getPSSysPFPluginName());
        }
        if (!bl || this.isPSSysReqItemIdDirty()) {
            hashMap.put(FIELD_PSSYSREQITEMID, this.getPSSysReqItemId());
        }
        if (!bl || this.isPSSysReqItemNameDirty()) {
            hashMap.put(FIELD_PSSYSREQITEMNAME, this.getPSSysReqItemName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
        }
        if (!bl || this.isPSSysUIActionIdDirty()) {
            hashMap.put(FIELD_PSSYSUIACTIONID, this.getPSSysUIActionId());
        }
        if (!bl || this.isPSSysUIActionNameDirty()) {
            hashMap.put(FIELD_PSSYSUIACTIONNAME, this.getPSSysUIActionName());
        }
        if (!bl || this.isPSSysViewLogicIdDirty()) {
            hashMap.put(FIELD_PSSYSVIEWLOGICID, this.getPSSysViewLogicId());
        }
        if (!bl || this.isPSSysViewLogicNameDirty()) {
            hashMap.put(FIELD_PSSYSVIEWLOGICNAME, this.getPSSysViewLogicName());
        }
        if (!bl || this.isPSWFIdDirty()) {
            hashMap.put(FIELD_PSWFID, this.getPSWFId());
        }
        if (!bl || this.isPSWFNameDirty()) {
            hashMap.put(FIELD_PSWFNAME, this.getPSWFName());
        }
        if (!bl || this.isPSWFLinkIdDirty()) {
            hashMap.put(FIELD_PSWFLINKID, this.getPSWFLinkId());
        }
        if (!bl || this.isPSWFLinkNameDirty()) {
            hashMap.put(FIELD_PSWFLINKNAME, this.getPSWFLinkName());
        }
        if (!bl || this.isPSWFProcessIdDirty()) {
            hashMap.put(FIELD_PSWFPROCESSID, this.getPSWFProcessId());
        }
        if (!bl || this.isPSWFProcessNameDirty()) {
            hashMap.put(FIELD_PSWFPROCESSNAME, this.getPSWFProcessName());
        }
        if (!bl || this.isPSWFVersionIdDirty()) {
            hashMap.put(FIELD_PSWFVERSIONID, this.getPSWFVersionId());
        }
        if (!bl || this.isPSWFVersionNameDirty()) {
            hashMap.put(FIELD_PSWFVERSIONNAME, this.getPSWFVersionName());
        }
        if (!bl || this.isReloadDataDirty()) {
            hashMap.put(FIELD_RELOADDATA, this.getReloadData());
        }
        if (!bl || this.isRepPSSysUIActionIdDirty()) {
            hashMap.put(FIELD_REPPSSYSUIACTIONID, this.getRepPSSysUIActionId());
        }
        if (!bl || this.isRepPSSysUIActionNameDirty()) {
            hashMap.put(FIELD_REPPSSYSUIACTIONNAME, this.getRepPSSysUIActionName());
        }
        if (!bl || this.isSMPSLanResIdDirty()) {
            hashMap.put(FIELD_SMPSLANRESID, this.getSMPSLanResId());
        }
        if (!bl || this.isSMPSLanResNameDirty()) {
            hashMap.put(FIELD_SMPSLANRESNAME, this.getSMPSLanResName());
        }
        if (!bl || this.isSuccessInfoDirty()) {
            hashMap.put(FIELD_SUCCESSINFO, this.getSuccessInfo());
        }
        if (!bl || this.isSysItemObjDirty()) {
            hashMap.put(FIELD_SYSITEMOBJ, this.getSysItemObj());
        }
        if (!bl || this.isTemplModeDirty()) {
            hashMap.put(FIELD_TEMPLMODE, this.getTemplMode());
        }
        if (!bl || this.isTextItemDirty()) {
            hashMap.put(FIELD_TEXTITEM, this.getTextItem());
        }
        if (!bl || this.isTimeoutDirty()) {
            hashMap.put(FIELD_TIMEOUT, this.getTimeout());
        }
        if (!bl || this.isTipPSLanResIdDirty()) {
            hashMap.put(FIELD_TIPPSLANRESID, this.getTipPSLanResId());
        }
        if (!bl || this.isTipPSLanResNameDirty()) {
            hashMap.put(FIELD_TIPPSLANRESNAME, this.getTipPSLanResName());
        }
        if (!bl || this.isToDoTaskDirty()) {
            hashMap.put(FIELD_TODOTASK, this.getToDoTask());
        }
        if (!bl || this.isTooltipInfoDirty()) {
            hashMap.put(FIELD_TOOLTIPINFO, this.getTooltipInfo());
        }
        if (!bl || this.isUATagDirty()) {
            hashMap.put(FIELD_UATAG, this.getUATag());
        }
        if (!bl || this.isUATag2Dirty()) {
            hashMap.put(FIELD_UATAG2, this.getUATag2());
        }
        if (!bl || this.isUATag3Dirty()) {
            hashMap.put(FIELD_UATAG3, this.getUATag3());
        }
        if (!bl || this.isUATag4Dirty()) {
            hashMap.put(FIELD_UATAG4, this.getUATag4());
        }
        if (!bl || this.isUIActionCodeDirty()) {
            hashMap.put(FIELD_UIACTIONCODE, this.getUIActionCode());
        }
        if (!bl || this.isUIActionParamDirty()) {
            hashMap.put(FIELD_UIACTIONPARAM, this.getUIActionParam());
        }
        if (!bl || this.isUIActionParam10Dirty()) {
            hashMap.put(FIELD_UIACTIONPARAM10, this.getUIActionParam10());
        }
        if (!bl || this.isUIActionParam11Dirty()) {
            hashMap.put(FIELD_UIACTIONPARAM11, this.getUIActionParam11());
        }
        if (!bl || this.isUIActionParam12Dirty()) {
            hashMap.put(FIELD_UIACTIONPARAM12, this.getUIActionParam12());
        }
        if (!bl || this.isUIActionParam2Dirty()) {
            hashMap.put(FIELD_UIACTIONPARAM2, this.getUIActionParam2());
        }
        if (!bl || this.isUIActionParam3Dirty()) {
            hashMap.put(FIELD_UIACTIONPARAM3, this.getUIActionParam3());
        }
        if (!bl || this.isUIActionParam4Dirty()) {
            hashMap.put(FIELD_UIACTIONPARAM4, this.getUIActionParam4());
        }
        if (!bl || this.isUIActionParam5Dirty()) {
            hashMap.put(FIELD_UIACTIONPARAM5, this.getUIActionParam5());
        }
        if (!bl || this.isUIActionParam6Dirty()) {
            hashMap.put(FIELD_UIACTIONPARAM6, this.getUIActionParam6());
        }
        if (!bl || this.isUIActionParam7Dirty()) {
            hashMap.put(FIELD_UIACTIONPARAM7, this.getUIActionParam7());
        }
        if (!bl || this.isUIActionParam8Dirty()) {
            hashMap.put(FIELD_UIACTIONPARAM8, this.getUIActionParam8());
        }
        if (!bl || this.isUIActionParam9Dirty()) {
            hashMap.put(FIELD_UIACTIONPARAM9, this.getUIActionParam9());
        }
        if (!bl || this.isUIActionParamsDirty()) {
            hashMap.put(FIELD_UIACTIONPARAMS, this.getUIActionParams());
        }
        if (!bl || this.isUIActionTypeDirty()) {
            hashMap.put(FIELD_UIACTIONTYPE, this.getUIActionType());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserCatDirty()) {
            hashMap.put(FIELD_USERCAT, this.getUserCat());
        }
        if (!bl || this.isUserConfirmDirty()) {
            hashMap.put(FIELD_USERCONFIRM, this.getUserConfirm());
        }
        if (!bl || this.isUserParamsDirty()) {
            hashMap.put(FIELD_USERPARAMS, this.getUserParams());
        }
        if (!bl || this.isUserTagDirty()) {
            hashMap.put(FIELD_USERTAG, this.getUserTag());
        }
        if (!bl || this.isUserTag2Dirty()) {
            hashMap.put(FIELD_USERTAG2, this.getUserTag2());
        }
        if (!bl || this.isUserTag3Dirty()) {
            hashMap.put(FIELD_USERTAG3, this.getUserTag3());
        }
        if (!bl || this.isUserTag4Dirty()) {
            hashMap.put(FIELD_USERTAG4, this.getUserTag4());
        }
        if (!bl || this.isViewActionsDirty()) {
            hashMap.put(FIELD_VIEWACTIONS, this.getViewActions());
        }
        if (!bl || this.isViewLogicTypeDirty()) {
            hashMap.put(FIELD_VIEWLOGICTYPE, this.getViewLogicType());
        }
        if (!bl || this.isVisibleLogicDirty()) {
            hashMap.put(FIELD_VISIBLELOGIC, this.getVisibleLogic());
        }
        if (!bl || this.isVLExecModeDirty()) {
            hashMap.put(FIELD_VLEXECMODE, this.getVLExecMode());
        }
        super.onFillMap(hashMap, bl);
    }

    public Object get(String string) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().get(string);
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer n = fieldIndexMap.get(string.toUpperCase());
        if (n == null) {
            return super.get(string);
        }
        return PSDEUIActionBase.get(this, n);
    }

    private static Object get(PSDEUIActionBase pSDEUIActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEUIActionBase.getActionLevel();
            }
            case 1: {
                return pSDEUIActionBase.getActionTarget();
            }
            case 2: {
                return pSDEUIActionBase.getBusyIndicator();
            }
            case 3: {
                return pSDEUIActionBase.getButtonStyle();
            }
            case 4: {
                return pSDEUIActionBase.getCapPSLanResId();
            }
            case 5: {
                return pSDEUIActionBase.getCapPSLanResName();
            }
            case 6: {
                return pSDEUIActionBase.getCaption();
            }
            case 7: {
                return pSDEUIActionBase.getCloseEditView();
            }
            case 8: {
                return pSDEUIActionBase.getCMPSLanResId();
            }
            case 9: {
                return pSDEUIActionBase.getCMPSLanResName();
            }
            case 10: {
                return pSDEUIActionBase.getCodeName();
            }
            case 11: {
                return pSDEUIActionBase.getConfirmInfo();
            }
            case 12: {
                return pSDEUIActionBase.getCounterId();
            }
            case 13: {
                return pSDEUIActionBase.getCreateDate();
            }
            case 14: {
                return pSDEUIActionBase.getCreateMan();
            }
            case 15: {
                return pSDEUIActionBase.getCustomCode();
            }
            case 16: {
                return pSDEUIActionBase.getDataItem();
            }
            case 17: {
                return pSDEUIActionBase.getDynaModelFlag();
            }
            case 18: {
                return pSDEUIActionBase.getEnableLogic();
            }
            case 19: {
                return pSDEUIActionBase.getEnableRTModel();
            }
            case 20: {
                return pSDEUIActionBase.getEnableViewActions();
            }
            case 21: {
                return pSDEUIActionBase.getExtendMode();
            }
            case 22: {
                return pSDEUIActionBase.getFrontProType();
            }
            case 23: {
                return pSDEUIActionBase.getGlobalFlag();
            }
            case 24: {
                return pSDEUIActionBase.getHtmlPageUrl();
            }
            case 25: {
                return pSDEUIActionBase.getItemObj();
            }
            case 26: {
                return pSDEUIActionBase.getLockFlag();
            }
            case 27: {
                return pSDEUIActionBase.getMemo();
            }
            case 28: {
                return pSDEUIActionBase.getMobPSDEViewId();
            }
            case 29: {
                return pSDEUIActionBase.getMobPSDEViewName();
            }
            case 30: {
                return pSDEUIActionBase.getNextPSDEUIActionId();
            }
            case 31: {
                return pSDEUIActionBase.getNextPSDEUIActionName();
            }
            case 32: {
                return pSDEUIActionBase.getNo2PSDEDataExpId();
            }
            case 33: {
                return pSDEUIActionBase.getNo2PSDEDataExpName();
            }
            case 34: {
                return pSDEUIActionBase.getNoPrivDM();
            }
            case 35: {
                return pSDEUIActionBase.getParamItem();
            }
            case 36: {
                return pSDEUIActionBase.getPDTViewFlag();
            }
            case 37: {
                return pSDEUIActionBase.getPSDEACModeId();
            }
            case 38: {
                return pSDEUIActionBase.getPSDEACModeName();
            }
            case 39: {
                return pSDEUIActionBase.getPSDEActionId();
            }
            case 40: {
                return pSDEUIActionBase.getPSDEActionName();
            }
            case 41: {
                return pSDEUIActionBase.getPSDEDataExpId();
            }
            case 42: {
                return pSDEUIActionBase.getPSDEDataImpId();
            }
            case 43: {
                return pSDEUIActionBase.getPSDEDataImpName();
            }
            case 44: {
                return pSDEUIActionBase.getPSDEFGroupId();
            }
            case 45: {
                return pSDEUIActionBase.getPSDEFGroupName();
            }
            case 46: {
                return pSDEUIActionBase.getPSDEFormId();
            }
            case 47: {
                return pSDEUIActionBase.getPSDEFormName();
            }
            case 48: {
                return pSDEUIActionBase.getPSDEId();
            }
            case 49: {
                return pSDEUIActionBase.getPSDEName();
            }
            case 50: {
                return pSDEUIActionBase.getPSDEOPPrivId();
            }
            case 51: {
                return pSDEUIActionBase.getPSDEOPPrivName();
            }
            case 52: {
                return pSDEUIActionBase.getPSDEPrintId();
            }
            case 53: {
                return pSDEUIActionBase.getPSDEPrintName();
            }
            case 54: {
                return pSDEUIActionBase.getPSDEUIActionId();
            }
            case 55: {
                return pSDEUIActionBase.getPSDEUIActionName();
            }
            case 56: {
                return pSDEUIActionBase.getPSDEViewBaseId();
            }
            case 57: {
                return pSDEUIActionBase.getPSDEViewBaseName();
            }
            case 58: {
                return pSDEUIActionBase.getPSDEViewLogicId();
            }
            case 59: {
                return pSDEUIActionBase.getPSDEViewLogicName();
            }
            case 60: {
                return pSDEUIActionBase.getPSDynaInstId();
            }
            case 61: {
                return pSDEUIActionBase.getPSModuleId();
            }
            case 62: {
                return pSDEUIActionBase.getPSModuleName();
            }
            case 63: {
                return pSDEUIActionBase.getPSSysCounterId();
            }
            case 64: {
                return pSDEUIActionBase.getPSSysCounterName();
            }
            case 65: {
                return pSDEUIActionBase.getPSSysDynaModelId();
            }
            case 66: {
                return pSDEUIActionBase.getPSSysDynaModelName();
            }
            case 67: {
                return pSDEUIActionBase.getPSSysImageId();
            }
            case 68: {
                return pSDEUIActionBase.getPSSysImageName();
            }
            case 69: {
                return pSDEUIActionBase.getPSSysPDTViewId();
            }
            case 70: {
                return pSDEUIActionBase.getPSSysPDTViewName();
            }
            case 71: {
                return pSDEUIActionBase.getPSSysPFPluginId();
            }
            case 72: {
                return pSDEUIActionBase.getPSSysPFPluginName();
            }
            case 73: {
                return pSDEUIActionBase.getPSSysReqItemId();
            }
            case 74: {
                return pSDEUIActionBase.getPSSysReqItemName();
            }
            case 75: {
                return pSDEUIActionBase.getPSSystemId();
            }
            case 76: {
                return pSDEUIActionBase.getPSSystemName();
            }
            case 77: {
                return pSDEUIActionBase.getPSSysUIActionId();
            }
            case 78: {
                return pSDEUIActionBase.getPSSysUIActionName();
            }
            case 79: {
                return pSDEUIActionBase.getPSSysViewLogicId();
            }
            case 80: {
                return pSDEUIActionBase.getPSSysViewLogicName();
            }
            case 81: {
                return pSDEUIActionBase.getPSWFId();
            }
            case 82: {
                return pSDEUIActionBase.getPSWFName();
            }
            case 83: {
                return pSDEUIActionBase.getPSWFLinkId();
            }
            case 84: {
                return pSDEUIActionBase.getPSWFLinkName();
            }
            case 85: {
                return pSDEUIActionBase.getPSWFProcessId();
            }
            case 86: {
                return pSDEUIActionBase.getPSWFProcessName();
            }
            case 87: {
                return pSDEUIActionBase.getPSWFVersionId();
            }
            case 88: {
                return pSDEUIActionBase.getPSWFVersionName();
            }
            case 89: {
                return pSDEUIActionBase.getReloadData();
            }
            case 90: {
                return pSDEUIActionBase.getRepPSSysUIActionId();
            }
            case 91: {
                return pSDEUIActionBase.getRepPSSysUIActionName();
            }
            case 92: {
                return pSDEUIActionBase.getSMPSLanResId();
            }
            case 93: {
                return pSDEUIActionBase.getSMPSLanResName();
            }
            case 94: {
                return pSDEUIActionBase.getSuccessInfo();
            }
            case 95: {
                return pSDEUIActionBase.getSysItemObj();
            }
            case 96: {
                return pSDEUIActionBase.getTemplMode();
            }
            case 97: {
                return pSDEUIActionBase.getTextItem();
            }
            case 98: {
                return pSDEUIActionBase.getTimeout();
            }
            case 99: {
                return pSDEUIActionBase.getTipPSLanResId();
            }
            case 100: {
                return pSDEUIActionBase.getTipPSLanResName();
            }
            case 101: {
                return pSDEUIActionBase.getToDoTask();
            }
            case 102: {
                return pSDEUIActionBase.getTooltipInfo();
            }
            case 103: {
                return pSDEUIActionBase.getUATag();
            }
            case 104: {
                return pSDEUIActionBase.getUATag2();
            }
            case 105: {
                return pSDEUIActionBase.getUATag3();
            }
            case 106: {
                return pSDEUIActionBase.getUATag4();
            }
            case 107: {
                return pSDEUIActionBase.getUIActionCode();
            }
            case 108: {
                return pSDEUIActionBase.getUIActionParam();
            }
            case 109: {
                return pSDEUIActionBase.getUIActionParam10();
            }
            case 110: {
                return pSDEUIActionBase.getUIActionParam11();
            }
            case 111: {
                return pSDEUIActionBase.getUIActionParam12();
            }
            case 112: {
                return pSDEUIActionBase.getUIActionParam2();
            }
            case 113: {
                return pSDEUIActionBase.getUIActionParam3();
            }
            case 114: {
                return pSDEUIActionBase.getUIActionParam4();
            }
            case 115: {
                return pSDEUIActionBase.getUIActionParam5();
            }
            case 116: {
                return pSDEUIActionBase.getUIActionParam6();
            }
            case 117: {
                return pSDEUIActionBase.getUIActionParam7();
            }
            case 118: {
                return pSDEUIActionBase.getUIActionParam8();
            }
            case 119: {
                return pSDEUIActionBase.getUIActionParam9();
            }
            case 120: {
                return pSDEUIActionBase.getUIActionParams();
            }
            case 121: {
                return pSDEUIActionBase.getUIActionType();
            }
            case 122: {
                return pSDEUIActionBase.getUpdateDate();
            }
            case 123: {
                return pSDEUIActionBase.getUpdateMan();
            }
            case 124: {
                return pSDEUIActionBase.getUserCat();
            }
            case 125: {
                return pSDEUIActionBase.getUserConfirm();
            }
            case 126: {
                return pSDEUIActionBase.getUserParams();
            }
            case 127: {
                return pSDEUIActionBase.getUserTag();
            }
            case 128: {
                return pSDEUIActionBase.getUserTag2();
            }
            case 129: {
                return pSDEUIActionBase.getUserTag3();
            }
            case 130: {
                return pSDEUIActionBase.getUserTag4();
            }
            case 131: {
                return pSDEUIActionBase.getViewActions();
            }
            case 132: {
                return pSDEUIActionBase.getViewLogicType();
            }
            case 133: {
                return pSDEUIActionBase.getVisibleLogic();
            }
            case 134: {
                return pSDEUIActionBase.getVLExecMode();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    public void set(String string, Object object) throws Exception {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().set(string, object);
            return;
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer n = fieldIndexMap.get(string.toUpperCase());
        if (n == null) {
            super.set(string, object);
            return;
        }
        PSDEUIActionBase.set(this, n, object);
    }

    private static void set(PSDEUIActionBase pSDEUIActionBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEUIActionBase.setActionLevel(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSDEUIActionBase.setActionTarget(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEUIActionBase.setBusyIndicator(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSDEUIActionBase.setButtonStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEUIActionBase.setCapPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEUIActionBase.setCapPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEUIActionBase.setCaption(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEUIActionBase.setCloseEditView(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSDEUIActionBase.setCMPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEUIActionBase.setCMPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEUIActionBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEUIActionBase.setConfirmInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEUIActionBase.setCounterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEUIActionBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 14: {
                pSDEUIActionBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEUIActionBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEUIActionBase.setDataItem(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEUIActionBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 18: {
                pSDEUIActionBase.setEnableLogic(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEUIActionBase.setEnableRTModel(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 20: {
                pSDEUIActionBase.setEnableViewActions(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 21: {
                pSDEUIActionBase.setExtendMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 22: {
                pSDEUIActionBase.setFrontProType(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDEUIActionBase.setGlobalFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 24: {
                pSDEUIActionBase.setHtmlPageUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDEUIActionBase.setItemObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDEUIActionBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 27: {
                pSDEUIActionBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDEUIActionBase.setMobPSDEViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDEUIActionBase.setMobPSDEViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDEUIActionBase.setNextPSDEUIActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDEUIActionBase.setNextPSDEUIActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDEUIActionBase.setNo2PSDEDataExpId(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDEUIActionBase.setNo2PSDEDataExpName(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDEUIActionBase.setNoPrivDM(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 35: {
                pSDEUIActionBase.setParamItem(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDEUIActionBase.setPDTViewFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 37: {
                pSDEUIActionBase.setPSDEACModeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDEUIActionBase.setPSDEACModeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSDEUIActionBase.setPSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSDEUIActionBase.setPSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSDEUIActionBase.setPSDEDataExpId(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSDEUIActionBase.setPSDEDataImpId(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSDEUIActionBase.setPSDEDataImpName(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSDEUIActionBase.setPSDEFGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSDEUIActionBase.setPSDEFGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSDEUIActionBase.setPSDEFormId(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSDEUIActionBase.setPSDEFormName(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSDEUIActionBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSDEUIActionBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSDEUIActionBase.setPSDEOPPrivId(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSDEUIActionBase.setPSDEOPPrivName(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSDEUIActionBase.setPSDEPrintId(DataObject.getStringValue((Object)object));
                return;
            }
            case 53: {
                pSDEUIActionBase.setPSDEPrintName(DataObject.getStringValue((Object)object));
                return;
            }
            case 54: {
                pSDEUIActionBase.setPSDEUIActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 55: {
                pSDEUIActionBase.setPSDEUIActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 56: {
                pSDEUIActionBase.setPSDEViewBaseId(DataObject.getStringValue((Object)object));
                return;
            }
            case 57: {
                pSDEUIActionBase.setPSDEViewBaseName(DataObject.getStringValue((Object)object));
                return;
            }
            case 58: {
                pSDEUIActionBase.setPSDEViewLogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 59: {
                pSDEUIActionBase.setPSDEViewLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 60: {
                pSDEUIActionBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 61: {
                pSDEUIActionBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 62: {
                pSDEUIActionBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 63: {
                pSDEUIActionBase.setPSSysCounterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 64: {
                pSDEUIActionBase.setPSSysCounterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 65: {
                pSDEUIActionBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 66: {
                pSDEUIActionBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 67: {
                pSDEUIActionBase.setPSSysImageId(DataObject.getStringValue((Object)object));
                return;
            }
            case 68: {
                pSDEUIActionBase.setPSSysImageName(DataObject.getStringValue((Object)object));
                return;
            }
            case 69: {
                pSDEUIActionBase.setPSSysPDTViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 70: {
                pSDEUIActionBase.setPSSysPDTViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 71: {
                pSDEUIActionBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 72: {
                pSDEUIActionBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 73: {
                pSDEUIActionBase.setPSSysReqItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 74: {
                pSDEUIActionBase.setPSSysReqItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 75: {
                pSDEUIActionBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 76: {
                pSDEUIActionBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 77: {
                pSDEUIActionBase.setPSSysUIActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 78: {
                pSDEUIActionBase.setPSSysUIActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 79: {
                pSDEUIActionBase.setPSSysViewLogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 80: {
                pSDEUIActionBase.setPSSysViewLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 81: {
                pSDEUIActionBase.setPSWFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 82: {
                pSDEUIActionBase.setPSWFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 83: {
                pSDEUIActionBase.setPSWFLinkId(DataObject.getStringValue((Object)object));
                return;
            }
            case 84: {
                pSDEUIActionBase.setPSWFLinkName(DataObject.getStringValue((Object)object));
                return;
            }
            case 85: {
                pSDEUIActionBase.setPSWFProcessId(DataObject.getStringValue((Object)object));
                return;
            }
            case 86: {
                pSDEUIActionBase.setPSWFProcessName(DataObject.getStringValue((Object)object));
                return;
            }
            case 87: {
                pSDEUIActionBase.setPSWFVersionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 88: {
                pSDEUIActionBase.setPSWFVersionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 89: {
                pSDEUIActionBase.setReloadData(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 90: {
                pSDEUIActionBase.setRepPSSysUIActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 91: {
                pSDEUIActionBase.setRepPSSysUIActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 92: {
                pSDEUIActionBase.setSMPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 93: {
                pSDEUIActionBase.setSMPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 94: {
                pSDEUIActionBase.setSuccessInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 95: {
                pSDEUIActionBase.setSysItemObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 96: {
                pSDEUIActionBase.setTemplMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 97: {
                pSDEUIActionBase.setTextItem(DataObject.getStringValue((Object)object));
                return;
            }
            case 98: {
                pSDEUIActionBase.setTimeout(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 99: {
                pSDEUIActionBase.setTipPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 100: {
                pSDEUIActionBase.setTipPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 101: {
                pSDEUIActionBase.setToDoTask(DataObject.getStringValue((Object)object));
                return;
            }
            case 102: {
                pSDEUIActionBase.setTooltipInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 103: {
                pSDEUIActionBase.setUATag(DataObject.getStringValue((Object)object));
                return;
            }
            case 104: {
                pSDEUIActionBase.setUATag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 105: {
                pSDEUIActionBase.setUATag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 106: {
                pSDEUIActionBase.setUATag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 107: {
                pSDEUIActionBase.setUIActionCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 108: {
                pSDEUIActionBase.setUIActionParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 109: {
                pSDEUIActionBase.setUIActionParam10(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 110: {
                pSDEUIActionBase.setUIActionParam11(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 111: {
                pSDEUIActionBase.setUIActionParam12(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 112: {
                pSDEUIActionBase.setUIActionParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 113: {
                pSDEUIActionBase.setUIActionParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 114: {
                pSDEUIActionBase.setUIActionParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 115: {
                pSDEUIActionBase.setUIActionParam5(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 116: {
                pSDEUIActionBase.setUIActionParam6(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 117: {
                pSDEUIActionBase.setUIActionParam7(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 118: {
                pSDEUIActionBase.setUIActionParam8(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 119: {
                pSDEUIActionBase.setUIActionParam9(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 120: {
                pSDEUIActionBase.setUIActionParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 121: {
                pSDEUIActionBase.setUIActionType(DataObject.getStringValue((Object)object));
                return;
            }
            case 122: {
                pSDEUIActionBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 123: {
                pSDEUIActionBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 124: {
                pSDEUIActionBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 125: {
                pSDEUIActionBase.setUserConfirm(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 126: {
                pSDEUIActionBase.setUserParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 127: {
                pSDEUIActionBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 128: {
                pSDEUIActionBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 129: {
                pSDEUIActionBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 130: {
                pSDEUIActionBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 131: {
                pSDEUIActionBase.setViewActions(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 132: {
                pSDEUIActionBase.setViewLogicType(DataObject.getStringValue((Object)object));
                return;
            }
            case 133: {
                pSDEUIActionBase.setVisibleLogic(DataObject.getStringValue((Object)object));
                return;
            }
            case 134: {
                pSDEUIActionBase.setVLExecMode(DataObject.getStringValue((Object)object));
                return;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    public boolean isNull(String string) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNull(string);
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer n = fieldIndexMap.get(string.toUpperCase());
        if (n == null) {
            return super.isNull(string);
        }
        return PSDEUIActionBase.isNull(this, n);
    }

    private static boolean isNull(PSDEUIActionBase pSDEUIActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEUIActionBase.getActionLevel() == null;
            }
            case 1: {
                return pSDEUIActionBase.getActionTarget() == null;
            }
            case 2: {
                return pSDEUIActionBase.getBusyIndicator() == null;
            }
            case 3: {
                return pSDEUIActionBase.getButtonStyle() == null;
            }
            case 4: {
                return pSDEUIActionBase.getCapPSLanResId() == null;
            }
            case 5: {
                return pSDEUIActionBase.getCapPSLanResName() == null;
            }
            case 6: {
                return pSDEUIActionBase.getCaption() == null;
            }
            case 7: {
                return pSDEUIActionBase.getCloseEditView() == null;
            }
            case 8: {
                return pSDEUIActionBase.getCMPSLanResId() == null;
            }
            case 9: {
                return pSDEUIActionBase.getCMPSLanResName() == null;
            }
            case 10: {
                return pSDEUIActionBase.getCodeName() == null;
            }
            case 11: {
                return pSDEUIActionBase.getConfirmInfo() == null;
            }
            case 12: {
                return pSDEUIActionBase.getCounterId() == null;
            }
            case 13: {
                return pSDEUIActionBase.getCreateDate() == null;
            }
            case 14: {
                return pSDEUIActionBase.getCreateMan() == null;
            }
            case 15: {
                return pSDEUIActionBase.getCustomCode() == null;
            }
            case 16: {
                return pSDEUIActionBase.getDataItem() == null;
            }
            case 17: {
                return pSDEUIActionBase.getDynaModelFlag() == null;
            }
            case 18: {
                return pSDEUIActionBase.getEnableLogic() == null;
            }
            case 19: {
                return pSDEUIActionBase.getEnableRTModel() == null;
            }
            case 20: {
                return pSDEUIActionBase.getEnableViewActions() == null;
            }
            case 21: {
                return pSDEUIActionBase.getExtendMode() == null;
            }
            case 22: {
                return pSDEUIActionBase.getFrontProType() == null;
            }
            case 23: {
                return pSDEUIActionBase.getGlobalFlag() == null;
            }
            case 24: {
                return pSDEUIActionBase.getHtmlPageUrl() == null;
            }
            case 25: {
                return pSDEUIActionBase.getItemObj() == null;
            }
            case 26: {
                return pSDEUIActionBase.getLockFlag() == null;
            }
            case 27: {
                return pSDEUIActionBase.getMemo() == null;
            }
            case 28: {
                return pSDEUIActionBase.getMobPSDEViewId() == null;
            }
            case 29: {
                return pSDEUIActionBase.getMobPSDEViewName() == null;
            }
            case 30: {
                return pSDEUIActionBase.getNextPSDEUIActionId() == null;
            }
            case 31: {
                return pSDEUIActionBase.getNextPSDEUIActionName() == null;
            }
            case 32: {
                return pSDEUIActionBase.getNo2PSDEDataExpId() == null;
            }
            case 33: {
                return pSDEUIActionBase.getNo2PSDEDataExpName() == null;
            }
            case 34: {
                return pSDEUIActionBase.getNoPrivDM() == null;
            }
            case 35: {
                return pSDEUIActionBase.getParamItem() == null;
            }
            case 36: {
                return pSDEUIActionBase.getPDTViewFlag() == null;
            }
            case 37: {
                return pSDEUIActionBase.getPSDEACModeId() == null;
            }
            case 38: {
                return pSDEUIActionBase.getPSDEACModeName() == null;
            }
            case 39: {
                return pSDEUIActionBase.getPSDEActionId() == null;
            }
            case 40: {
                return pSDEUIActionBase.getPSDEActionName() == null;
            }
            case 41: {
                return pSDEUIActionBase.getPSDEDataExpId() == null;
            }
            case 42: {
                return pSDEUIActionBase.getPSDEDataImpId() == null;
            }
            case 43: {
                return pSDEUIActionBase.getPSDEDataImpName() == null;
            }
            case 44: {
                return pSDEUIActionBase.getPSDEFGroupId() == null;
            }
            case 45: {
                return pSDEUIActionBase.getPSDEFGroupName() == null;
            }
            case 46: {
                return pSDEUIActionBase.getPSDEFormId() == null;
            }
            case 47: {
                return pSDEUIActionBase.getPSDEFormName() == null;
            }
            case 48: {
                return pSDEUIActionBase.getPSDEId() == null;
            }
            case 49: {
                return pSDEUIActionBase.getPSDEName() == null;
            }
            case 50: {
                return pSDEUIActionBase.getPSDEOPPrivId() == null;
            }
            case 51: {
                return pSDEUIActionBase.getPSDEOPPrivName() == null;
            }
            case 52: {
                return pSDEUIActionBase.getPSDEPrintId() == null;
            }
            case 53: {
                return pSDEUIActionBase.getPSDEPrintName() == null;
            }
            case 54: {
                return pSDEUIActionBase.getPSDEUIActionId() == null;
            }
            case 55: {
                return pSDEUIActionBase.getPSDEUIActionName() == null;
            }
            case 56: {
                return pSDEUIActionBase.getPSDEViewBaseId() == null;
            }
            case 57: {
                return pSDEUIActionBase.getPSDEViewBaseName() == null;
            }
            case 58: {
                return pSDEUIActionBase.getPSDEViewLogicId() == null;
            }
            case 59: {
                return pSDEUIActionBase.getPSDEViewLogicName() == null;
            }
            case 60: {
                return pSDEUIActionBase.getPSDynaInstId() == null;
            }
            case 61: {
                return pSDEUIActionBase.getPSModuleId() == null;
            }
            case 62: {
                return pSDEUIActionBase.getPSModuleName() == null;
            }
            case 63: {
                return pSDEUIActionBase.getPSSysCounterId() == null;
            }
            case 64: {
                return pSDEUIActionBase.getPSSysCounterName() == null;
            }
            case 65: {
                return pSDEUIActionBase.getPSSysDynaModelId() == null;
            }
            case 66: {
                return pSDEUIActionBase.getPSSysDynaModelName() == null;
            }
            case 67: {
                return pSDEUIActionBase.getPSSysImageId() == null;
            }
            case 68: {
                return pSDEUIActionBase.getPSSysImageName() == null;
            }
            case 69: {
                return pSDEUIActionBase.getPSSysPDTViewId() == null;
            }
            case 70: {
                return pSDEUIActionBase.getPSSysPDTViewName() == null;
            }
            case 71: {
                return pSDEUIActionBase.getPSSysPFPluginId() == null;
            }
            case 72: {
                return pSDEUIActionBase.getPSSysPFPluginName() == null;
            }
            case 73: {
                return pSDEUIActionBase.getPSSysReqItemId() == null;
            }
            case 74: {
                return pSDEUIActionBase.getPSSysReqItemName() == null;
            }
            case 75: {
                return pSDEUIActionBase.getPSSystemId() == null;
            }
            case 76: {
                return pSDEUIActionBase.getPSSystemName() == null;
            }
            case 77: {
                return pSDEUIActionBase.getPSSysUIActionId() == null;
            }
            case 78: {
                return pSDEUIActionBase.getPSSysUIActionName() == null;
            }
            case 79: {
                return pSDEUIActionBase.getPSSysViewLogicId() == null;
            }
            case 80: {
                return pSDEUIActionBase.getPSSysViewLogicName() == null;
            }
            case 81: {
                return pSDEUIActionBase.getPSWFId() == null;
            }
            case 82: {
                return pSDEUIActionBase.getPSWFName() == null;
            }
            case 83: {
                return pSDEUIActionBase.getPSWFLinkId() == null;
            }
            case 84: {
                return pSDEUIActionBase.getPSWFLinkName() == null;
            }
            case 85: {
                return pSDEUIActionBase.getPSWFProcessId() == null;
            }
            case 86: {
                return pSDEUIActionBase.getPSWFProcessName() == null;
            }
            case 87: {
                return pSDEUIActionBase.getPSWFVersionId() == null;
            }
            case 88: {
                return pSDEUIActionBase.getPSWFVersionName() == null;
            }
            case 89: {
                return pSDEUIActionBase.getReloadData() == null;
            }
            case 90: {
                return pSDEUIActionBase.getRepPSSysUIActionId() == null;
            }
            case 91: {
                return pSDEUIActionBase.getRepPSSysUIActionName() == null;
            }
            case 92: {
                return pSDEUIActionBase.getSMPSLanResId() == null;
            }
            case 93: {
                return pSDEUIActionBase.getSMPSLanResName() == null;
            }
            case 94: {
                return pSDEUIActionBase.getSuccessInfo() == null;
            }
            case 95: {
                return pSDEUIActionBase.getSysItemObj() == null;
            }
            case 96: {
                return pSDEUIActionBase.getTemplMode() == null;
            }
            case 97: {
                return pSDEUIActionBase.getTextItem() == null;
            }
            case 98: {
                return pSDEUIActionBase.getTimeout() == null;
            }
            case 99: {
                return pSDEUIActionBase.getTipPSLanResId() == null;
            }
            case 100: {
                return pSDEUIActionBase.getTipPSLanResName() == null;
            }
            case 101: {
                return pSDEUIActionBase.getToDoTask() == null;
            }
            case 102: {
                return pSDEUIActionBase.getTooltipInfo() == null;
            }
            case 103: {
                return pSDEUIActionBase.getUATag() == null;
            }
            case 104: {
                return pSDEUIActionBase.getUATag2() == null;
            }
            case 105: {
                return pSDEUIActionBase.getUATag3() == null;
            }
            case 106: {
                return pSDEUIActionBase.getUATag4() == null;
            }
            case 107: {
                return pSDEUIActionBase.getUIActionCode() == null;
            }
            case 108: {
                return pSDEUIActionBase.getUIActionParam() == null;
            }
            case 109: {
                return pSDEUIActionBase.getUIActionParam10() == null;
            }
            case 110: {
                return pSDEUIActionBase.getUIActionParam11() == null;
            }
            case 111: {
                return pSDEUIActionBase.getUIActionParam12() == null;
            }
            case 112: {
                return pSDEUIActionBase.getUIActionParam2() == null;
            }
            case 113: {
                return pSDEUIActionBase.getUIActionParam3() == null;
            }
            case 114: {
                return pSDEUIActionBase.getUIActionParam4() == null;
            }
            case 115: {
                return pSDEUIActionBase.getUIActionParam5() == null;
            }
            case 116: {
                return pSDEUIActionBase.getUIActionParam6() == null;
            }
            case 117: {
                return pSDEUIActionBase.getUIActionParam7() == null;
            }
            case 118: {
                return pSDEUIActionBase.getUIActionParam8() == null;
            }
            case 119: {
                return pSDEUIActionBase.getUIActionParam9() == null;
            }
            case 120: {
                return pSDEUIActionBase.getUIActionParams() == null;
            }
            case 121: {
                return pSDEUIActionBase.getUIActionType() == null;
            }
            case 122: {
                return pSDEUIActionBase.getUpdateDate() == null;
            }
            case 123: {
                return pSDEUIActionBase.getUpdateMan() == null;
            }
            case 124: {
                return pSDEUIActionBase.getUserCat() == null;
            }
            case 125: {
                return pSDEUIActionBase.getUserConfirm() == null;
            }
            case 126: {
                return pSDEUIActionBase.getUserParams() == null;
            }
            case 127: {
                return pSDEUIActionBase.getUserTag() == null;
            }
            case 128: {
                return pSDEUIActionBase.getUserTag2() == null;
            }
            case 129: {
                return pSDEUIActionBase.getUserTag3() == null;
            }
            case 130: {
                return pSDEUIActionBase.getUserTag4() == null;
            }
            case 131: {
                return pSDEUIActionBase.getViewActions() == null;
            }
            case 132: {
                return pSDEUIActionBase.getViewLogicType() == null;
            }
            case 133: {
                return pSDEUIActionBase.getVisibleLogic() == null;
            }
            case 134: {
                return pSDEUIActionBase.getVLExecMode() == null;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    public boolean contains(String string) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().contains(string);
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer n = fieldIndexMap.get(string.toUpperCase());
        if (n == null) {
            return super.contains(string);
        }
        return PSDEUIActionBase.contains(this, n);
    }

    private static boolean contains(PSDEUIActionBase pSDEUIActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEUIActionBase.isActionLevelDirty();
            }
            case 1: {
                return pSDEUIActionBase.isActionTargetDirty();
            }
            case 2: {
                return pSDEUIActionBase.isBusyIndicatorDirty();
            }
            case 3: {
                return pSDEUIActionBase.isButtonStyleDirty();
            }
            case 4: {
                return pSDEUIActionBase.isCapPSLanResIdDirty();
            }
            case 5: {
                return pSDEUIActionBase.isCapPSLanResNameDirty();
            }
            case 6: {
                return pSDEUIActionBase.isCaptionDirty();
            }
            case 7: {
                return pSDEUIActionBase.isCloseEditViewDirty();
            }
            case 8: {
                return pSDEUIActionBase.isCMPSLanResIdDirty();
            }
            case 9: {
                return pSDEUIActionBase.isCMPSLanResNameDirty();
            }
            case 10: {
                return pSDEUIActionBase.isCodeNameDirty();
            }
            case 11: {
                return pSDEUIActionBase.isConfirmInfoDirty();
            }
            case 12: {
                return pSDEUIActionBase.isCounterIdDirty();
            }
            case 13: {
                return pSDEUIActionBase.isCreateDateDirty();
            }
            case 14: {
                return pSDEUIActionBase.isCreateManDirty();
            }
            case 15: {
                return pSDEUIActionBase.isCustomCodeDirty();
            }
            case 16: {
                return pSDEUIActionBase.isDataItemDirty();
            }
            case 17: {
                return pSDEUIActionBase.isDynaModelFlagDirty();
            }
            case 18: {
                return pSDEUIActionBase.isEnableLogicDirty();
            }
            case 19: {
                return pSDEUIActionBase.isEnableRTModelDirty();
            }
            case 20: {
                return pSDEUIActionBase.isEnableViewActionsDirty();
            }
            case 21: {
                return pSDEUIActionBase.isExtendModeDirty();
            }
            case 22: {
                return pSDEUIActionBase.isFrontProTypeDirty();
            }
            case 23: {
                return pSDEUIActionBase.isGlobalFlagDirty();
            }
            case 24: {
                return pSDEUIActionBase.isHtmlPageUrlDirty();
            }
            case 25: {
                return pSDEUIActionBase.isItemObjDirty();
            }
            case 26: {
                return pSDEUIActionBase.isLockFlagDirty();
            }
            case 27: {
                return pSDEUIActionBase.isMemoDirty();
            }
            case 28: {
                return pSDEUIActionBase.isMobPSDEViewIdDirty();
            }
            case 29: {
                return pSDEUIActionBase.isMobPSDEViewNameDirty();
            }
            case 30: {
                return pSDEUIActionBase.isNextPSDEUIActionIdDirty();
            }
            case 31: {
                return pSDEUIActionBase.isNextPSDEUIActionNameDirty();
            }
            case 32: {
                return pSDEUIActionBase.isNo2PSDEDataExpIdDirty();
            }
            case 33: {
                return pSDEUIActionBase.isNo2PSDEDataExpNameDirty();
            }
            case 34: {
                return pSDEUIActionBase.isNoPrivDMDirty();
            }
            case 35: {
                return pSDEUIActionBase.isParamItemDirty();
            }
            case 36: {
                return pSDEUIActionBase.isPDTViewFlagDirty();
            }
            case 37: {
                return pSDEUIActionBase.isPSDEACModeIdDirty();
            }
            case 38: {
                return pSDEUIActionBase.isPSDEACModeNameDirty();
            }
            case 39: {
                return pSDEUIActionBase.isPSDEActionIdDirty();
            }
            case 40: {
                return pSDEUIActionBase.isPSDEActionNameDirty();
            }
            case 41: {
                return pSDEUIActionBase.isPSDEDataExpIdDirty();
            }
            case 42: {
                return pSDEUIActionBase.isPSDEDataImpIdDirty();
            }
            case 43: {
                return pSDEUIActionBase.isPSDEDataImpNameDirty();
            }
            case 44: {
                return pSDEUIActionBase.isPSDEFGroupIdDirty();
            }
            case 45: {
                return pSDEUIActionBase.isPSDEFGroupNameDirty();
            }
            case 46: {
                return pSDEUIActionBase.isPSDEFormIdDirty();
            }
            case 47: {
                return pSDEUIActionBase.isPSDEFormNameDirty();
            }
            case 48: {
                return pSDEUIActionBase.isPSDEIdDirty();
            }
            case 49: {
                return pSDEUIActionBase.isPSDENameDirty();
            }
            case 50: {
                return pSDEUIActionBase.isPSDEOPPrivIdDirty();
            }
            case 51: {
                return pSDEUIActionBase.isPSDEOPPrivNameDirty();
            }
            case 52: {
                return pSDEUIActionBase.isPSDEPrintIdDirty();
            }
            case 53: {
                return pSDEUIActionBase.isPSDEPrintNameDirty();
            }
            case 54: {
                return pSDEUIActionBase.isPSDEUIActionIdDirty();
            }
            case 55: {
                return pSDEUIActionBase.isPSDEUIActionNameDirty();
            }
            case 56: {
                return pSDEUIActionBase.isPSDEViewBaseIdDirty();
            }
            case 57: {
                return pSDEUIActionBase.isPSDEViewBaseNameDirty();
            }
            case 58: {
                return pSDEUIActionBase.isPSDEViewLogicIdDirty();
            }
            case 59: {
                return pSDEUIActionBase.isPSDEViewLogicNameDirty();
            }
            case 60: {
                return pSDEUIActionBase.isPSDynaInstIdDirty();
            }
            case 61: {
                return pSDEUIActionBase.isPSModuleIdDirty();
            }
            case 62: {
                return pSDEUIActionBase.isPSModuleNameDirty();
            }
            case 63: {
                return pSDEUIActionBase.isPSSysCounterIdDirty();
            }
            case 64: {
                return pSDEUIActionBase.isPSSysCounterNameDirty();
            }
            case 65: {
                return pSDEUIActionBase.isPSSysDynaModelIdDirty();
            }
            case 66: {
                return pSDEUIActionBase.isPSSysDynaModelNameDirty();
            }
            case 67: {
                return pSDEUIActionBase.isPSSysImageIdDirty();
            }
            case 68: {
                return pSDEUIActionBase.isPSSysImageNameDirty();
            }
            case 69: {
                return pSDEUIActionBase.isPSSysPDTViewIdDirty();
            }
            case 70: {
                return pSDEUIActionBase.isPSSysPDTViewNameDirty();
            }
            case 71: {
                return pSDEUIActionBase.isPSSysPFPluginIdDirty();
            }
            case 72: {
                return pSDEUIActionBase.isPSSysPFPluginNameDirty();
            }
            case 73: {
                return pSDEUIActionBase.isPSSysReqItemIdDirty();
            }
            case 74: {
                return pSDEUIActionBase.isPSSysReqItemNameDirty();
            }
            case 75: {
                return pSDEUIActionBase.isPSSystemIdDirty();
            }
            case 76: {
                return pSDEUIActionBase.isPSSystemNameDirty();
            }
            case 77: {
                return pSDEUIActionBase.isPSSysUIActionIdDirty();
            }
            case 78: {
                return pSDEUIActionBase.isPSSysUIActionNameDirty();
            }
            case 79: {
                return pSDEUIActionBase.isPSSysViewLogicIdDirty();
            }
            case 80: {
                return pSDEUIActionBase.isPSSysViewLogicNameDirty();
            }
            case 81: {
                return pSDEUIActionBase.isPSWFIdDirty();
            }
            case 82: {
                return pSDEUIActionBase.isPSWFNameDirty();
            }
            case 83: {
                return pSDEUIActionBase.isPSWFLinkIdDirty();
            }
            case 84: {
                return pSDEUIActionBase.isPSWFLinkNameDirty();
            }
            case 85: {
                return pSDEUIActionBase.isPSWFProcessIdDirty();
            }
            case 86: {
                return pSDEUIActionBase.isPSWFProcessNameDirty();
            }
            case 87: {
                return pSDEUIActionBase.isPSWFVersionIdDirty();
            }
            case 88: {
                return pSDEUIActionBase.isPSWFVersionNameDirty();
            }
            case 89: {
                return pSDEUIActionBase.isReloadDataDirty();
            }
            case 90: {
                return pSDEUIActionBase.isRepPSSysUIActionIdDirty();
            }
            case 91: {
                return pSDEUIActionBase.isRepPSSysUIActionNameDirty();
            }
            case 92: {
                return pSDEUIActionBase.isSMPSLanResIdDirty();
            }
            case 93: {
                return pSDEUIActionBase.isSMPSLanResNameDirty();
            }
            case 94: {
                return pSDEUIActionBase.isSuccessInfoDirty();
            }
            case 95: {
                return pSDEUIActionBase.isSysItemObjDirty();
            }
            case 96: {
                return pSDEUIActionBase.isTemplModeDirty();
            }
            case 97: {
                return pSDEUIActionBase.isTextItemDirty();
            }
            case 98: {
                return pSDEUIActionBase.isTimeoutDirty();
            }
            case 99: {
                return pSDEUIActionBase.isTipPSLanResIdDirty();
            }
            case 100: {
                return pSDEUIActionBase.isTipPSLanResNameDirty();
            }
            case 101: {
                return pSDEUIActionBase.isToDoTaskDirty();
            }
            case 102: {
                return pSDEUIActionBase.isTooltipInfoDirty();
            }
            case 103: {
                return pSDEUIActionBase.isUATagDirty();
            }
            case 104: {
                return pSDEUIActionBase.isUATag2Dirty();
            }
            case 105: {
                return pSDEUIActionBase.isUATag3Dirty();
            }
            case 106: {
                return pSDEUIActionBase.isUATag4Dirty();
            }
            case 107: {
                return pSDEUIActionBase.isUIActionCodeDirty();
            }
            case 108: {
                return pSDEUIActionBase.isUIActionParamDirty();
            }
            case 109: {
                return pSDEUIActionBase.isUIActionParam10Dirty();
            }
            case 110: {
                return pSDEUIActionBase.isUIActionParam11Dirty();
            }
            case 111: {
                return pSDEUIActionBase.isUIActionParam12Dirty();
            }
            case 112: {
                return pSDEUIActionBase.isUIActionParam2Dirty();
            }
            case 113: {
                return pSDEUIActionBase.isUIActionParam3Dirty();
            }
            case 114: {
                return pSDEUIActionBase.isUIActionParam4Dirty();
            }
            case 115: {
                return pSDEUIActionBase.isUIActionParam5Dirty();
            }
            case 116: {
                return pSDEUIActionBase.isUIActionParam6Dirty();
            }
            case 117: {
                return pSDEUIActionBase.isUIActionParam7Dirty();
            }
            case 118: {
                return pSDEUIActionBase.isUIActionParam8Dirty();
            }
            case 119: {
                return pSDEUIActionBase.isUIActionParam9Dirty();
            }
            case 120: {
                return pSDEUIActionBase.isUIActionParamsDirty();
            }
            case 121: {
                return pSDEUIActionBase.isUIActionTypeDirty();
            }
            case 122: {
                return pSDEUIActionBase.isUpdateDateDirty();
            }
            case 123: {
                return pSDEUIActionBase.isUpdateManDirty();
            }
            case 124: {
                return pSDEUIActionBase.isUserCatDirty();
            }
            case 125: {
                return pSDEUIActionBase.isUserConfirmDirty();
            }
            case 126: {
                return pSDEUIActionBase.isUserParamsDirty();
            }
            case 127: {
                return pSDEUIActionBase.isUserTagDirty();
            }
            case 128: {
                return pSDEUIActionBase.isUserTag2Dirty();
            }
            case 129: {
                return pSDEUIActionBase.isUserTag3Dirty();
            }
            case 130: {
                return pSDEUIActionBase.isUserTag4Dirty();
            }
            case 131: {
                return pSDEUIActionBase.isViewActionsDirty();
            }
            case 132: {
                return pSDEUIActionBase.isViewLogicTypeDirty();
            }
            case 133: {
                return pSDEUIActionBase.isVisibleLogicDirty();
            }
            case 134: {
                return pSDEUIActionBase.isVLExecModeDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEUIActionBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEUIActionBase pSDEUIActionBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEUIActionBase.getActionLevel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionlevel", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getActionLevel()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getActionTarget() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actiontarget", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getActionTarget()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getBusyIndicator() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"busyindicator", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getBusyIndicator()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getButtonStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"buttonstyle", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getButtonStyle()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getCapPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cappslanresid", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getCapPSLanResId()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getCapPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cappslanresname", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getCapPSLanResName()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getCaption() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"caption", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getCaption()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getCloseEditView() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"closeeditview", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getCloseEditView()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getCMPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cmpslanresid", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getCMPSLanResId()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getCMPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cmpslanresname", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getCMPSLanResName()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getConfirmInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"confirminfo", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getConfirmInfo()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getCounterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"counterid", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getCounterId()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getDataItem() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dataitem", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getDataItem()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getEnableLogic() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablelogic", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getEnableLogic()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getEnableRTModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablertmodel", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getEnableRTModel()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getEnableViewActions() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableviewactions", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getEnableViewActions()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getExtendMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"extendmode", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getExtendMode()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getFrontProType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"frontprotype", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getFrontProType()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getGlobalFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"globalflag", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getGlobalFlag()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getHtmlPageUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"htmlpageurl", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getHtmlPageUrl()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getItemObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemobj", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getItemObj()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getMobPSDEViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobpsdeviewid", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getMobPSDEViewId()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getMobPSDEViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobpsdeviewname", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getMobPSDEViewName()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getNextPSDEUIActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"nextpsdeuiactionid", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getNextPSDEUIActionId()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getNextPSDEUIActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"nextpsdeuiactionname", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getNextPSDEUIActionName()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getNo2PSDEDataExpId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no2psdedataexpid", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getNo2PSDEDataExpId()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getNo2PSDEDataExpName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no2psdedataexpname", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getNo2PSDEDataExpName()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getNoPrivDM() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"noprivdm", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getNoPrivDM()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getParamItem() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"paramitem", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getParamItem()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getPDTViewFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pdtviewflag", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getPDTViewFlag()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getPSDEACModeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeacmodeid", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getPSDEACModeId()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getPSDEACModeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeacmodename", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getPSDEACModeName()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getPSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactionid", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getPSDEActionId()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getPSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactionname", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getPSDEActionName()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getPSDEDataExpId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedataexpid", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getPSDEDataExpId()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getPSDEDataImpId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedataimpid", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getPSDEDataImpId()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getPSDEDataImpName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedataimpname", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getPSDEDataImpName()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getPSDEFGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefgroupid", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getPSDEFGroupId()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getPSDEFGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefgroupname", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getPSDEFGroupName()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getPSDEFormId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeformid", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getPSDEFormId()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getPSDEFormName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeformname", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getPSDEFormName()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getPSDEOPPrivId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeopprivid", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getPSDEOPPrivId()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getPSDEOPPrivName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeopprivname", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getPSDEOPPrivName()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getPSDEPrintId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeprintid", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getPSDEPrintId()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getPSDEPrintName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeprintname", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getPSDEPrintName()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getPSDEUIActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuiactionid", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getPSDEUIActionId()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getPSDEUIActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuiactionname", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getPSDEUIActionName()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getPSDEViewBaseId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewbaseid", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getPSDEViewBaseId()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getPSDEViewBaseName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewbasename", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getPSDEViewBaseName()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getPSDEViewLogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewlogicid", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getPSDEViewLogicId()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getPSDEViewLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewlogicname", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getPSDEViewLogicName()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getPSSysCounterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscounterid", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getPSSysCounterId()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getPSSysCounterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscountername", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getPSSysCounterName()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getPSSysImageId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysimageid", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getPSSysImageId()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getPSSysImageName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysimagename", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getPSSysImageName()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getPSSysPDTViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspdtviewid", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getPSSysPDTViewId()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getPSSysPDTViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspdtviewname", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getPSSysPDTViewName()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getPSSysReqItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemid", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getPSSysReqItemId()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getPSSysReqItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemname", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getPSSysReqItemName()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getPSSysUIActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysuiactionid", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getPSSysUIActionId()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getPSSysUIActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysuiactionname", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getPSSysUIActionName()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getPSSysViewLogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewlogicid", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getPSSysViewLogicId()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getPSSysViewLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewlogicname", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getPSSysViewLogicName()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getPSWFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfid", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getPSWFId()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getPSWFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfname", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getPSWFName()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getPSWFLinkId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfplinkid", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getPSWFLinkId()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getPSWFLinkName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfplinkname", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getPSWFLinkName()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getPSWFProcessId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfprocessid", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getPSWFProcessId()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getPSWFProcessName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfprocessname", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getPSWFProcessName()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getPSWFVersionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfversionid", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getPSWFVersionId()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getPSWFVersionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfversionname", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getPSWFVersionName()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getReloadData() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"reloaddata", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getReloadData()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getRepPSSysUIActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"reppssysuiactionid", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getRepPSSysUIActionId()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getRepPSSysUIActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"reppssysuiactionname", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getRepPSSysUIActionName()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getSMPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"smpslanresid", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getSMPSLanResId()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getSMPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"smpslanresname", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getSMPSLanResName()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getSuccessInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"successinfo", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getSuccessInfo()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getSysItemObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sysitemobj", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getSysItemObj()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getTemplMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templmode", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getTemplMode()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getTextItem() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"textitem", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getTextItem()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getTimeout() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"timeout", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getTimeout()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getTipPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tippslanresid", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getTipPSLanResId()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getTipPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tippslanresname", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getTipPSLanResName()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getToDoTask() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"todotask", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getToDoTask()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getTooltipInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tooltipinfo", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getTooltipInfo()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getUATag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uatag", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getUATag()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getUATag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uatag2", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getUATag2()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getUATag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uatag3", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getUATag3()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getUATag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uatag4", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getUATag4()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getUIActionCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uiactioncode", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getUIActionCode()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getUIActionParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uiactionparam", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getUIActionParam()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getUIActionParam10() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uiactionparam10", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getUIActionParam10()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getUIActionParam11() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uiactionparam11", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getUIActionParam11()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getUIActionParam12() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uiactionparam12", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getUIActionParam12()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getUIActionParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uiactionparam2", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getUIActionParam2()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getUIActionParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uiactionparam3", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getUIActionParam3()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getUIActionParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uiactionparam4", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getUIActionParam4()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getUIActionParam5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uiactionparam5", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getUIActionParam5()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getUIActionParam6() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uiactionparam6", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getUIActionParam6()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getUIActionParam7() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uiactionparam7", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getUIActionParam7()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getUIActionParam8() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uiactionparam8", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getUIActionParam8()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getUIActionParam9() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uiactionparam9", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getUIActionParam9()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getUIActionParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uiactionparams", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getUIActionParams()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getUIActionType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uiactiontype", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getUIActionType()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getUserConfirm() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userconfirm", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getUserConfirm()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getUserParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userparams", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getUserParams()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getViewActions() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewactions", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getViewActions()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getViewLogicType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewlogictype", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getViewLogicType()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getVisibleLogic() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"visiblelogic", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getVisibleLogic()), (boolean)false);
        }
        if (bl || pSDEUIActionBase.getVLExecMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"vlexecmode", (Object)PSDEUIActionBase.getJSONValue((Object)pSDEUIActionBase.getVLExecMode()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEUIActionBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEUIActionBase pSDEUIActionBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEUIActionBase.getActionLevel() != null) {
            object = pSDEUIActionBase.getActionLevel();
            xmlNode.setAttribute(FIELD_ACTIONLEVEL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEUIActionBase.getActionTarget() != null) {
            object = pSDEUIActionBase.getActionTarget();
            xmlNode.setAttribute(FIELD_ACTIONTARGET, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getBusyIndicator() != null) {
            object = pSDEUIActionBase.getBusyIndicator();
            xmlNode.setAttribute(FIELD_BUSYINDICATOR, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEUIActionBase.getButtonStyle() != null) {
            object = pSDEUIActionBase.getButtonStyle();
            xmlNode.setAttribute(FIELD_BUTTONSTYLE, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getCapPSLanResId() != null) {
            object = pSDEUIActionBase.getCapPSLanResId();
            xmlNode.setAttribute(FIELD_CAPPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getCapPSLanResName() != null) {
            object = pSDEUIActionBase.getCapPSLanResName();
            xmlNode.setAttribute(FIELD_CAPPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getCaption() != null) {
            object = pSDEUIActionBase.getCaption();
            xmlNode.setAttribute(FIELD_CAPTION, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getCloseEditView() != null) {
            object = pSDEUIActionBase.getCloseEditView();
            xmlNode.setAttribute(FIELD_CLOSEEDITVIEW, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEUIActionBase.getCMPSLanResId() != null) {
            object = pSDEUIActionBase.getCMPSLanResId();
            xmlNode.setAttribute(FIELD_CMPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getCMPSLanResName() != null) {
            object = pSDEUIActionBase.getCMPSLanResName();
            xmlNode.setAttribute(FIELD_CMPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getCodeName() != null) {
            object = pSDEUIActionBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getConfirmInfo() != null) {
            object = pSDEUIActionBase.getConfirmInfo();
            xmlNode.setAttribute(FIELD_CONFIRMINFO, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getCounterId() != null) {
            object = pSDEUIActionBase.getCounterId();
            xmlNode.setAttribute(FIELD_COUNTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getCreateDate() != null) {
            object = pSDEUIActionBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEUIActionBase.getCreateMan() != null) {
            object = pSDEUIActionBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getCustomCode() != null) {
            object = pSDEUIActionBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getDataItem() != null) {
            object = pSDEUIActionBase.getDataItem();
            xmlNode.setAttribute(FIELD_DATAITEM, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getDynaModelFlag() != null) {
            object = pSDEUIActionBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEUIActionBase.getEnableLogic() != null) {
            object = pSDEUIActionBase.getEnableLogic();
            xmlNode.setAttribute(FIELD_ENABLELOGIC, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getEnableRTModel() != null) {
            object = pSDEUIActionBase.getEnableRTModel();
            xmlNode.setAttribute(FIELD_ENABLERTMODEL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEUIActionBase.getEnableViewActions() != null) {
            object = pSDEUIActionBase.getEnableViewActions();
            xmlNode.setAttribute(FIELD_ENABLEVIEWACTIONS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEUIActionBase.getExtendMode() != null) {
            object = pSDEUIActionBase.getExtendMode();
            xmlNode.setAttribute(FIELD_EXTENDMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEUIActionBase.getFrontProType() != null) {
            object = pSDEUIActionBase.getFrontProType();
            xmlNode.setAttribute(FIELD_FRONTPROTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getGlobalFlag() != null) {
            object = pSDEUIActionBase.getGlobalFlag();
            xmlNode.setAttribute(FIELD_GLOBALFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEUIActionBase.getHtmlPageUrl() != null) {
            object = pSDEUIActionBase.getHtmlPageUrl();
            xmlNode.setAttribute(FIELD_HTMLPAGEURL, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getItemObj() != null) {
            object = pSDEUIActionBase.getItemObj();
            xmlNode.setAttribute(FIELD_ITEMOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getLockFlag() != null) {
            object = pSDEUIActionBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEUIActionBase.getMemo() != null) {
            object = pSDEUIActionBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getMobPSDEViewId() != null) {
            object = pSDEUIActionBase.getMobPSDEViewId();
            xmlNode.setAttribute(FIELD_MOBPSDEVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getMobPSDEViewName() != null) {
            object = pSDEUIActionBase.getMobPSDEViewName();
            xmlNode.setAttribute(FIELD_MOBPSDEVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getNextPSDEUIActionId() != null) {
            object = pSDEUIActionBase.getNextPSDEUIActionId();
            xmlNode.setAttribute(FIELD_NEXTPSDEUIACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getNextPSDEUIActionName() != null) {
            object = pSDEUIActionBase.getNextPSDEUIActionName();
            xmlNode.setAttribute(FIELD_NEXTPSDEUIACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getNo2PSDEDataExpId() != null) {
            object = pSDEUIActionBase.getNo2PSDEDataExpId();
            xmlNode.setAttribute(FIELD_NO2PSDEDATAEXPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getNo2PSDEDataExpName() != null) {
            object = pSDEUIActionBase.getNo2PSDEDataExpName();
            xmlNode.setAttribute(FIELD_NO2PSDEDATAEXPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getNoPrivDM() != null) {
            object = pSDEUIActionBase.getNoPrivDM();
            xmlNode.setAttribute(FIELD_NOPRIVDM, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEUIActionBase.getParamItem() != null) {
            object = pSDEUIActionBase.getParamItem();
            xmlNode.setAttribute(FIELD_PARAMITEM, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getPDTViewFlag() != null) {
            object = pSDEUIActionBase.getPDTViewFlag();
            xmlNode.setAttribute(FIELD_PDTVIEWFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEUIActionBase.getPSDEACModeId() != null) {
            object = pSDEUIActionBase.getPSDEACModeId();
            xmlNode.setAttribute(FIELD_PSDEACMODEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getPSDEACModeName() != null) {
            object = pSDEUIActionBase.getPSDEACModeName();
            xmlNode.setAttribute(FIELD_PSDEACMODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getPSDEActionId() != null) {
            object = pSDEUIActionBase.getPSDEActionId();
            xmlNode.setAttribute(FIELD_PSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getPSDEActionName() != null) {
            object = pSDEUIActionBase.getPSDEActionName();
            xmlNode.setAttribute(FIELD_PSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getPSDEDataExpId() != null) {
            object = pSDEUIActionBase.getPSDEDataExpId();
            xmlNode.setAttribute(FIELD_PSDEDATAEXPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getPSDEDataImpId() != null) {
            object = pSDEUIActionBase.getPSDEDataImpId();
            xmlNode.setAttribute(FIELD_PSDEDATAIMPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getPSDEDataImpName() != null) {
            object = pSDEUIActionBase.getPSDEDataImpName();
            xmlNode.setAttribute(FIELD_PSDEDATAIMPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getPSDEFGroupId() != null) {
            object = pSDEUIActionBase.getPSDEFGroupId();
            xmlNode.setAttribute(FIELD_PSDEFGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getPSDEFGroupName() != null) {
            object = pSDEUIActionBase.getPSDEFGroupName();
            xmlNode.setAttribute(FIELD_PSDEFGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getPSDEFormId() != null) {
            object = pSDEUIActionBase.getPSDEFormId();
            xmlNode.setAttribute(FIELD_PSDEFORMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getPSDEFormName() != null) {
            object = pSDEUIActionBase.getPSDEFormName();
            xmlNode.setAttribute(FIELD_PSDEFORMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getPSDEId() != null) {
            object = pSDEUIActionBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getPSDEName() != null) {
            object = pSDEUIActionBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getPSDEOPPrivId() != null) {
            object = pSDEUIActionBase.getPSDEOPPrivId();
            xmlNode.setAttribute(FIELD_PSDEOPPRIVID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getPSDEOPPrivName() != null) {
            object = pSDEUIActionBase.getPSDEOPPrivName();
            xmlNode.setAttribute(FIELD_PSDEOPPRIVNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getPSDEPrintId() != null) {
            object = pSDEUIActionBase.getPSDEPrintId();
            xmlNode.setAttribute(FIELD_PSDEPRINTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getPSDEPrintName() != null) {
            object = pSDEUIActionBase.getPSDEPrintName();
            xmlNode.setAttribute(FIELD_PSDEPRINTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getPSDEUIActionId() != null) {
            object = pSDEUIActionBase.getPSDEUIActionId();
            xmlNode.setAttribute(FIELD_PSDEUIACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getPSDEUIActionName() != null) {
            object = pSDEUIActionBase.getPSDEUIActionName();
            xmlNode.setAttribute(FIELD_PSDEUIACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getPSDEViewBaseId() != null) {
            object = pSDEUIActionBase.getPSDEViewBaseId();
            xmlNode.setAttribute(FIELD_PSDEVIEWBASEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getPSDEViewBaseName() != null) {
            object = pSDEUIActionBase.getPSDEViewBaseName();
            xmlNode.setAttribute(FIELD_PSDEVIEWBASENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getPSDEViewLogicId() != null) {
            object = pSDEUIActionBase.getPSDEViewLogicId();
            xmlNode.setAttribute(FIELD_PSDEVIEWLOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getPSDEViewLogicName() != null) {
            object = pSDEUIActionBase.getPSDEViewLogicName();
            xmlNode.setAttribute(FIELD_PSDEVIEWLOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getPSDynaInstId() != null) {
            object = pSDEUIActionBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getPSModuleId() != null) {
            object = pSDEUIActionBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getPSModuleName() != null) {
            object = pSDEUIActionBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getPSSysCounterId() != null) {
            object = pSDEUIActionBase.getPSSysCounterId();
            xmlNode.setAttribute(FIELD_PSSYSCOUNTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getPSSysCounterName() != null) {
            object = pSDEUIActionBase.getPSSysCounterName();
            xmlNode.setAttribute(FIELD_PSSYSCOUNTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getPSSysDynaModelId() != null) {
            object = pSDEUIActionBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getPSSysDynaModelName() != null) {
            object = pSDEUIActionBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getPSSysImageId() != null) {
            object = pSDEUIActionBase.getPSSysImageId();
            xmlNode.setAttribute(FIELD_PSSYSIMAGEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getPSSysImageName() != null) {
            object = pSDEUIActionBase.getPSSysImageName();
            xmlNode.setAttribute(FIELD_PSSYSIMAGENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getPSSysPDTViewId() != null) {
            object = pSDEUIActionBase.getPSSysPDTViewId();
            xmlNode.setAttribute(FIELD_PSSYSPDTVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getPSSysPDTViewName() != null) {
            object = pSDEUIActionBase.getPSSysPDTViewName();
            xmlNode.setAttribute(FIELD_PSSYSPDTVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getPSSysPFPluginId() != null) {
            object = pSDEUIActionBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getPSSysPFPluginName() != null) {
            object = pSDEUIActionBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getPSSysReqItemId() != null) {
            object = pSDEUIActionBase.getPSSysReqItemId();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getPSSysReqItemName() != null) {
            object = pSDEUIActionBase.getPSSysReqItemName();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getPSSystemId() != null) {
            object = pSDEUIActionBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getPSSystemName() != null) {
            object = pSDEUIActionBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getPSSysUIActionId() != null) {
            object = pSDEUIActionBase.getPSSysUIActionId();
            xmlNode.setAttribute(FIELD_PSSYSUIACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getPSSysUIActionName() != null) {
            object = pSDEUIActionBase.getPSSysUIActionName();
            xmlNode.setAttribute(FIELD_PSSYSUIACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getPSSysViewLogicId() != null) {
            object = pSDEUIActionBase.getPSSysViewLogicId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWLOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getPSSysViewLogicName() != null) {
            object = pSDEUIActionBase.getPSSysViewLogicName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWLOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getPSWFId() != null) {
            object = pSDEUIActionBase.getPSWFId();
            xmlNode.setAttribute(FIELD_PSWFID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getPSWFName() != null) {
            object = pSDEUIActionBase.getPSWFName();
            xmlNode.setAttribute(FIELD_PSWFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getPSWFLinkId() != null) {
            object = pSDEUIActionBase.getPSWFLinkId();
            xmlNode.setAttribute("PSWFLINKID", object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getPSWFLinkName() != null) {
            object = pSDEUIActionBase.getPSWFLinkName();
            xmlNode.setAttribute("PSWFLINKNAME", object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getPSWFProcessId() != null) {
            object = pSDEUIActionBase.getPSWFProcessId();
            xmlNode.setAttribute(FIELD_PSWFPROCESSID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getPSWFProcessName() != null) {
            object = pSDEUIActionBase.getPSWFProcessName();
            xmlNode.setAttribute(FIELD_PSWFPROCESSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getPSWFVersionId() != null) {
            object = pSDEUIActionBase.getPSWFVersionId();
            xmlNode.setAttribute(FIELD_PSWFVERSIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getPSWFVersionName() != null) {
            object = pSDEUIActionBase.getPSWFVersionName();
            xmlNode.setAttribute(FIELD_PSWFVERSIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getReloadData() != null) {
            object = pSDEUIActionBase.getReloadData();
            xmlNode.setAttribute(FIELD_RELOADDATA, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEUIActionBase.getRepPSSysUIActionId() != null) {
            object = pSDEUIActionBase.getRepPSSysUIActionId();
            xmlNode.setAttribute(FIELD_REPPSSYSUIACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getRepPSSysUIActionName() != null) {
            object = pSDEUIActionBase.getRepPSSysUIActionName();
            xmlNode.setAttribute(FIELD_REPPSSYSUIACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getSMPSLanResId() != null) {
            object = pSDEUIActionBase.getSMPSLanResId();
            xmlNode.setAttribute(FIELD_SMPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getSMPSLanResName() != null) {
            object = pSDEUIActionBase.getSMPSLanResName();
            xmlNode.setAttribute(FIELD_SMPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getSuccessInfo() != null) {
            object = pSDEUIActionBase.getSuccessInfo();
            xmlNode.setAttribute(FIELD_SUCCESSINFO, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getSysItemObj() != null) {
            object = pSDEUIActionBase.getSysItemObj();
            xmlNode.setAttribute(FIELD_SYSITEMOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getTemplMode() != null) {
            object = pSDEUIActionBase.getTemplMode();
            xmlNode.setAttribute(FIELD_TEMPLMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEUIActionBase.getTextItem() != null) {
            object = pSDEUIActionBase.getTextItem();
            xmlNode.setAttribute(FIELD_TEXTITEM, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getTimeout() != null) {
            object = pSDEUIActionBase.getTimeout();
            xmlNode.setAttribute(FIELD_TIMEOUT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEUIActionBase.getTipPSLanResId() != null) {
            object = pSDEUIActionBase.getTipPSLanResId();
            xmlNode.setAttribute(FIELD_TIPPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getTipPSLanResName() != null) {
            object = pSDEUIActionBase.getTipPSLanResName();
            xmlNode.setAttribute(FIELD_TIPPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getToDoTask() != null) {
            object = pSDEUIActionBase.getToDoTask();
            xmlNode.setAttribute(FIELD_TODOTASK, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getTooltipInfo() != null) {
            object = pSDEUIActionBase.getTooltipInfo();
            xmlNode.setAttribute(FIELD_TOOLTIPINFO, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getUATag() != null) {
            object = pSDEUIActionBase.getUATag();
            xmlNode.setAttribute(FIELD_UATAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getUATag2() != null) {
            object = pSDEUIActionBase.getUATag2();
            xmlNode.setAttribute(FIELD_UATAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getUATag3() != null) {
            object = pSDEUIActionBase.getUATag3();
            xmlNode.setAttribute(FIELD_UATAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getUATag4() != null) {
            object = pSDEUIActionBase.getUATag4();
            xmlNode.setAttribute(FIELD_UATAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getUIActionCode() != null) {
            object = pSDEUIActionBase.getUIActionCode();
            xmlNode.setAttribute(FIELD_UIACTIONCODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getUIActionParam() != null) {
            object = pSDEUIActionBase.getUIActionParam();
            xmlNode.setAttribute(FIELD_UIACTIONPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getUIActionParam10() != null) {
            object = pSDEUIActionBase.getUIActionParam10();
            xmlNode.setAttribute(FIELD_UIACTIONPARAM10, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEUIActionBase.getUIActionParam11() != null) {
            object = pSDEUIActionBase.getUIActionParam11();
            xmlNode.setAttribute(FIELD_UIACTIONPARAM11, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEUIActionBase.getUIActionParam12() != null) {
            object = pSDEUIActionBase.getUIActionParam12();
            xmlNode.setAttribute(FIELD_UIACTIONPARAM12, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEUIActionBase.getUIActionParam2() != null) {
            object = pSDEUIActionBase.getUIActionParam2();
            xmlNode.setAttribute(FIELD_UIACTIONPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getUIActionParam3() != null) {
            object = pSDEUIActionBase.getUIActionParam3();
            xmlNode.setAttribute(FIELD_UIACTIONPARAM3, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getUIActionParam4() != null) {
            object = pSDEUIActionBase.getUIActionParam4();
            xmlNode.setAttribute(FIELD_UIACTIONPARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getUIActionParam5() != null) {
            object = pSDEUIActionBase.getUIActionParam5();
            xmlNode.setAttribute(FIELD_UIACTIONPARAM5, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEUIActionBase.getUIActionParam6() != null) {
            object = pSDEUIActionBase.getUIActionParam6();
            xmlNode.setAttribute(FIELD_UIACTIONPARAM6, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEUIActionBase.getUIActionParam7() != null) {
            object = pSDEUIActionBase.getUIActionParam7();
            xmlNode.setAttribute(FIELD_UIACTIONPARAM7, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEUIActionBase.getUIActionParam8() != null) {
            object = pSDEUIActionBase.getUIActionParam8();
            xmlNode.setAttribute(FIELD_UIACTIONPARAM8, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEUIActionBase.getUIActionParam9() != null) {
            object = pSDEUIActionBase.getUIActionParam9();
            xmlNode.setAttribute(FIELD_UIACTIONPARAM9, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEUIActionBase.getUIActionParams() != null) {
            object = pSDEUIActionBase.getUIActionParams();
            xmlNode.setAttribute(FIELD_UIACTIONPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getUIActionType() != null) {
            object = pSDEUIActionBase.getUIActionType();
            xmlNode.setAttribute(FIELD_UIACTIONTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getUpdateDate() != null) {
            object = pSDEUIActionBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEUIActionBase.getUpdateMan() != null) {
            object = pSDEUIActionBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getUserCat() != null) {
            object = pSDEUIActionBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getUserConfirm() != null) {
            object = pSDEUIActionBase.getUserConfirm();
            xmlNode.setAttribute(FIELD_USERCONFIRM, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEUIActionBase.getUserParams() != null) {
            object = pSDEUIActionBase.getUserParams();
            xmlNode.setAttribute(FIELD_USERPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getUserTag() != null) {
            object = pSDEUIActionBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getUserTag2() != null) {
            object = pSDEUIActionBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getUserTag3() != null) {
            object = pSDEUIActionBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getUserTag4() != null) {
            object = pSDEUIActionBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getViewActions() != null) {
            object = pSDEUIActionBase.getViewActions();
            xmlNode.setAttribute(FIELD_VIEWACTIONS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEUIActionBase.getViewLogicType() != null) {
            object = pSDEUIActionBase.getViewLogicType();
            xmlNode.setAttribute(FIELD_VIEWLOGICTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getVisibleLogic() != null) {
            object = pSDEUIActionBase.getVisibleLogic();
            xmlNode.setAttribute(FIELD_VISIBLELOGIC, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionBase.getVLExecMode() != null) {
            object = pSDEUIActionBase.getVLExecMode();
            xmlNode.setAttribute(FIELD_VLEXECMODE, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEUIActionBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEUIActionBase pSDEUIActionBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEUIActionBase.isActionLevelDirty() && (bl || pSDEUIActionBase.getActionLevel() != null)) {
            iDataObject.set(FIELD_ACTIONLEVEL, (Object)pSDEUIActionBase.getActionLevel());
        }
        if (pSDEUIActionBase.isActionTargetDirty() && (bl || pSDEUIActionBase.getActionTarget() != null)) {
            iDataObject.set(FIELD_ACTIONTARGET, (Object)pSDEUIActionBase.getActionTarget());
        }
        if (pSDEUIActionBase.isBusyIndicatorDirty() && (bl || pSDEUIActionBase.getBusyIndicator() != null)) {
            iDataObject.set(FIELD_BUSYINDICATOR, (Object)pSDEUIActionBase.getBusyIndicator());
        }
        if (pSDEUIActionBase.isButtonStyleDirty() && (bl || pSDEUIActionBase.getButtonStyle() != null)) {
            iDataObject.set(FIELD_BUTTONSTYLE, (Object)pSDEUIActionBase.getButtonStyle());
        }
        if (pSDEUIActionBase.isCapPSLanResIdDirty() && (bl || pSDEUIActionBase.getCapPSLanResId() != null)) {
            iDataObject.set(FIELD_CAPPSLANRESID, (Object)pSDEUIActionBase.getCapPSLanResId());
        }
        if (pSDEUIActionBase.isCapPSLanResNameDirty() && (bl || pSDEUIActionBase.getCapPSLanResName() != null)) {
            iDataObject.set(FIELD_CAPPSLANRESNAME, (Object)pSDEUIActionBase.getCapPSLanResName());
        }
        if (pSDEUIActionBase.isCaptionDirty() && (bl || pSDEUIActionBase.getCaption() != null)) {
            iDataObject.set(FIELD_CAPTION, (Object)pSDEUIActionBase.getCaption());
        }
        if (pSDEUIActionBase.isCloseEditViewDirty() && (bl || pSDEUIActionBase.getCloseEditView() != null)) {
            iDataObject.set(FIELD_CLOSEEDITVIEW, (Object)pSDEUIActionBase.getCloseEditView());
        }
        if (pSDEUIActionBase.isCMPSLanResIdDirty() && (bl || pSDEUIActionBase.getCMPSLanResId() != null)) {
            iDataObject.set(FIELD_CMPSLANRESID, (Object)pSDEUIActionBase.getCMPSLanResId());
        }
        if (pSDEUIActionBase.isCMPSLanResNameDirty() && (bl || pSDEUIActionBase.getCMPSLanResName() != null)) {
            iDataObject.set(FIELD_CMPSLANRESNAME, (Object)pSDEUIActionBase.getCMPSLanResName());
        }
        if (pSDEUIActionBase.isCodeNameDirty() && (bl || pSDEUIActionBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDEUIActionBase.getCodeName());
        }
        if (pSDEUIActionBase.isConfirmInfoDirty() && (bl || pSDEUIActionBase.getConfirmInfo() != null)) {
            iDataObject.set(FIELD_CONFIRMINFO, (Object)pSDEUIActionBase.getConfirmInfo());
        }
        if (pSDEUIActionBase.isCounterIdDirty() && (bl || pSDEUIActionBase.getCounterId() != null)) {
            iDataObject.set(FIELD_COUNTERID, (Object)pSDEUIActionBase.getCounterId());
        }
        if (pSDEUIActionBase.isCreateDateDirty() && (bl || pSDEUIActionBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEUIActionBase.getCreateDate());
        }
        if (pSDEUIActionBase.isCreateManDirty() && (bl || pSDEUIActionBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEUIActionBase.getCreateMan());
        }
        if (pSDEUIActionBase.isCustomCodeDirty() && (bl || pSDEUIActionBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSDEUIActionBase.getCustomCode());
        }
        if (pSDEUIActionBase.isDataItemDirty() && (bl || pSDEUIActionBase.getDataItem() != null)) {
            iDataObject.set(FIELD_DATAITEM, (Object)pSDEUIActionBase.getDataItem());
        }
        if (pSDEUIActionBase.isDynaModelFlagDirty() && (bl || pSDEUIActionBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSDEUIActionBase.getDynaModelFlag());
        }
        if (pSDEUIActionBase.isEnableLogicDirty() && (bl || pSDEUIActionBase.getEnableLogic() != null)) {
            iDataObject.set(FIELD_ENABLELOGIC, (Object)pSDEUIActionBase.getEnableLogic());
        }
        if (pSDEUIActionBase.isEnableRTModelDirty() && (bl || pSDEUIActionBase.getEnableRTModel() != null)) {
            iDataObject.set(FIELD_ENABLERTMODEL, (Object)pSDEUIActionBase.getEnableRTModel());
        }
        if (pSDEUIActionBase.isEnableViewActionsDirty() && (bl || pSDEUIActionBase.getEnableViewActions() != null)) {
            iDataObject.set(FIELD_ENABLEVIEWACTIONS, (Object)pSDEUIActionBase.getEnableViewActions());
        }
        if (pSDEUIActionBase.isExtendModeDirty() && (bl || pSDEUIActionBase.getExtendMode() != null)) {
            iDataObject.set(FIELD_EXTENDMODE, (Object)pSDEUIActionBase.getExtendMode());
        }
        if (pSDEUIActionBase.isFrontProTypeDirty() && (bl || pSDEUIActionBase.getFrontProType() != null)) {
            iDataObject.set(FIELD_FRONTPROTYPE, (Object)pSDEUIActionBase.getFrontProType());
        }
        if (pSDEUIActionBase.isGlobalFlagDirty() && (bl || pSDEUIActionBase.getGlobalFlag() != null)) {
            iDataObject.set(FIELD_GLOBALFLAG, (Object)pSDEUIActionBase.getGlobalFlag());
        }
        if (pSDEUIActionBase.isHtmlPageUrlDirty() && (bl || pSDEUIActionBase.getHtmlPageUrl() != null)) {
            iDataObject.set(FIELD_HTMLPAGEURL, (Object)pSDEUIActionBase.getHtmlPageUrl());
        }
        if (pSDEUIActionBase.isItemObjDirty() && (bl || pSDEUIActionBase.getItemObj() != null)) {
            iDataObject.set(FIELD_ITEMOBJ, (Object)pSDEUIActionBase.getItemObj());
        }
        if (pSDEUIActionBase.isLockFlagDirty() && (bl || pSDEUIActionBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSDEUIActionBase.getLockFlag());
        }
        if (pSDEUIActionBase.isMemoDirty() && (bl || pSDEUIActionBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEUIActionBase.getMemo());
        }
        if (pSDEUIActionBase.isMobPSDEViewIdDirty() && (bl || pSDEUIActionBase.getMobPSDEViewId() != null)) {
            iDataObject.set(FIELD_MOBPSDEVIEWID, (Object)pSDEUIActionBase.getMobPSDEViewId());
        }
        if (pSDEUIActionBase.isMobPSDEViewNameDirty() && (bl || pSDEUIActionBase.getMobPSDEViewName() != null)) {
            iDataObject.set(FIELD_MOBPSDEVIEWNAME, (Object)pSDEUIActionBase.getMobPSDEViewName());
        }
        if (pSDEUIActionBase.isNextPSDEUIActionIdDirty() && (bl || pSDEUIActionBase.getNextPSDEUIActionId() != null)) {
            iDataObject.set(FIELD_NEXTPSDEUIACTIONID, (Object)pSDEUIActionBase.getNextPSDEUIActionId());
        }
        if (pSDEUIActionBase.isNextPSDEUIActionNameDirty() && (bl || pSDEUIActionBase.getNextPSDEUIActionName() != null)) {
            iDataObject.set(FIELD_NEXTPSDEUIACTIONNAME, (Object)pSDEUIActionBase.getNextPSDEUIActionName());
        }
        if (pSDEUIActionBase.isNo2PSDEDataExpIdDirty() && (bl || pSDEUIActionBase.getNo2PSDEDataExpId() != null)) {
            iDataObject.set(FIELD_NO2PSDEDATAEXPID, (Object)pSDEUIActionBase.getNo2PSDEDataExpId());
        }
        if (pSDEUIActionBase.isNo2PSDEDataExpNameDirty() && (bl || pSDEUIActionBase.getNo2PSDEDataExpName() != null)) {
            iDataObject.set(FIELD_NO2PSDEDATAEXPNAME, (Object)pSDEUIActionBase.getNo2PSDEDataExpName());
        }
        if (pSDEUIActionBase.isNoPrivDMDirty() && (bl || pSDEUIActionBase.getNoPrivDM() != null)) {
            iDataObject.set(FIELD_NOPRIVDM, (Object)pSDEUIActionBase.getNoPrivDM());
        }
        if (pSDEUIActionBase.isParamItemDirty() && (bl || pSDEUIActionBase.getParamItem() != null)) {
            iDataObject.set(FIELD_PARAMITEM, (Object)pSDEUIActionBase.getParamItem());
        }
        if (pSDEUIActionBase.isPDTViewFlagDirty() && (bl || pSDEUIActionBase.getPDTViewFlag() != null)) {
            iDataObject.set(FIELD_PDTVIEWFLAG, (Object)pSDEUIActionBase.getPDTViewFlag());
        }
        if (pSDEUIActionBase.isPSDEACModeIdDirty() && (bl || pSDEUIActionBase.getPSDEACModeId() != null)) {
            iDataObject.set(FIELD_PSDEACMODEID, (Object)pSDEUIActionBase.getPSDEACModeId());
        }
        if (pSDEUIActionBase.isPSDEACModeNameDirty() && (bl || pSDEUIActionBase.getPSDEACModeName() != null)) {
            iDataObject.set(FIELD_PSDEACMODENAME, (Object)pSDEUIActionBase.getPSDEACModeName());
        }
        if (pSDEUIActionBase.isPSDEActionIdDirty() && (bl || pSDEUIActionBase.getPSDEActionId() != null)) {
            iDataObject.set(FIELD_PSDEACTIONID, (Object)pSDEUIActionBase.getPSDEActionId());
        }
        if (pSDEUIActionBase.isPSDEActionNameDirty() && (bl || pSDEUIActionBase.getPSDEActionName() != null)) {
            iDataObject.set(FIELD_PSDEACTIONNAME, (Object)pSDEUIActionBase.getPSDEActionName());
        }
        if (pSDEUIActionBase.isPSDEDataExpIdDirty() && (bl || pSDEUIActionBase.getPSDEDataExpId() != null)) {
            iDataObject.set(FIELD_PSDEDATAEXPID, (Object)pSDEUIActionBase.getPSDEDataExpId());
        }
        if (pSDEUIActionBase.isPSDEDataImpIdDirty() && (bl || pSDEUIActionBase.getPSDEDataImpId() != null)) {
            iDataObject.set(FIELD_PSDEDATAIMPID, (Object)pSDEUIActionBase.getPSDEDataImpId());
        }
        if (pSDEUIActionBase.isPSDEDataImpNameDirty() && (bl || pSDEUIActionBase.getPSDEDataImpName() != null)) {
            iDataObject.set(FIELD_PSDEDATAIMPNAME, (Object)pSDEUIActionBase.getPSDEDataImpName());
        }
        if (pSDEUIActionBase.isPSDEFGroupIdDirty() && (bl || pSDEUIActionBase.getPSDEFGroupId() != null)) {
            iDataObject.set(FIELD_PSDEFGROUPID, (Object)pSDEUIActionBase.getPSDEFGroupId());
        }
        if (pSDEUIActionBase.isPSDEFGroupNameDirty() && (bl || pSDEUIActionBase.getPSDEFGroupName() != null)) {
            iDataObject.set(FIELD_PSDEFGROUPNAME, (Object)pSDEUIActionBase.getPSDEFGroupName());
        }
        if (pSDEUIActionBase.isPSDEFormIdDirty() && (bl || pSDEUIActionBase.getPSDEFormId() != null)) {
            iDataObject.set(FIELD_PSDEFORMID, (Object)pSDEUIActionBase.getPSDEFormId());
        }
        if (pSDEUIActionBase.isPSDEFormNameDirty() && (bl || pSDEUIActionBase.getPSDEFormName() != null)) {
            iDataObject.set(FIELD_PSDEFORMNAME, (Object)pSDEUIActionBase.getPSDEFormName());
        }
        if (pSDEUIActionBase.isPSDEIdDirty() && (bl || pSDEUIActionBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEUIActionBase.getPSDEId());
        }
        if (pSDEUIActionBase.isPSDENameDirty() && (bl || pSDEUIActionBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDEUIActionBase.getPSDEName());
        }
        if (pSDEUIActionBase.isPSDEOPPrivIdDirty() && (bl || pSDEUIActionBase.getPSDEOPPrivId() != null)) {
            iDataObject.set(FIELD_PSDEOPPRIVID, (Object)pSDEUIActionBase.getPSDEOPPrivId());
        }
        if (pSDEUIActionBase.isPSDEOPPrivNameDirty() && (bl || pSDEUIActionBase.getPSDEOPPrivName() != null)) {
            iDataObject.set(FIELD_PSDEOPPRIVNAME, (Object)pSDEUIActionBase.getPSDEOPPrivName());
        }
        if (pSDEUIActionBase.isPSDEPrintIdDirty() && (bl || pSDEUIActionBase.getPSDEPrintId() != null)) {
            iDataObject.set(FIELD_PSDEPRINTID, (Object)pSDEUIActionBase.getPSDEPrintId());
        }
        if (pSDEUIActionBase.isPSDEPrintNameDirty() && (bl || pSDEUIActionBase.getPSDEPrintName() != null)) {
            iDataObject.set(FIELD_PSDEPRINTNAME, (Object)pSDEUIActionBase.getPSDEPrintName());
        }
        if (pSDEUIActionBase.isPSDEUIActionIdDirty() && (bl || pSDEUIActionBase.getPSDEUIActionId() != null)) {
            iDataObject.set(FIELD_PSDEUIACTIONID, (Object)pSDEUIActionBase.getPSDEUIActionId());
        }
        if (pSDEUIActionBase.isPSDEUIActionNameDirty() && (bl || pSDEUIActionBase.getPSDEUIActionName() != null)) {
            iDataObject.set(FIELD_PSDEUIACTIONNAME, (Object)pSDEUIActionBase.getPSDEUIActionName());
        }
        if (pSDEUIActionBase.isPSDEViewBaseIdDirty() && (bl || pSDEUIActionBase.getPSDEViewBaseId() != null)) {
            iDataObject.set(FIELD_PSDEVIEWBASEID, (Object)pSDEUIActionBase.getPSDEViewBaseId());
        }
        if (pSDEUIActionBase.isPSDEViewBaseNameDirty() && (bl || pSDEUIActionBase.getPSDEViewBaseName() != null)) {
            iDataObject.set(FIELD_PSDEVIEWBASENAME, (Object)pSDEUIActionBase.getPSDEViewBaseName());
        }
        if (pSDEUIActionBase.isPSDEViewLogicIdDirty() && (bl || pSDEUIActionBase.getPSDEViewLogicId() != null)) {
            iDataObject.set(FIELD_PSDEVIEWLOGICID, (Object)pSDEUIActionBase.getPSDEViewLogicId());
        }
        if (pSDEUIActionBase.isPSDEViewLogicNameDirty() && (bl || pSDEUIActionBase.getPSDEViewLogicName() != null)) {
            iDataObject.set(FIELD_PSDEVIEWLOGICNAME, (Object)pSDEUIActionBase.getPSDEViewLogicName());
        }
        if (pSDEUIActionBase.isPSDynaInstIdDirty() && (bl || pSDEUIActionBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSDEUIActionBase.getPSDynaInstId());
        }
        if (pSDEUIActionBase.isPSModuleIdDirty() && (bl || pSDEUIActionBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSDEUIActionBase.getPSModuleId());
        }
        if (pSDEUIActionBase.isPSModuleNameDirty() && (bl || pSDEUIActionBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSDEUIActionBase.getPSModuleName());
        }
        if (pSDEUIActionBase.isPSSysCounterIdDirty() && (bl || pSDEUIActionBase.getPSSysCounterId() != null)) {
            iDataObject.set(FIELD_PSSYSCOUNTERID, (Object)pSDEUIActionBase.getPSSysCounterId());
        }
        if (pSDEUIActionBase.isPSSysCounterNameDirty() && (bl || pSDEUIActionBase.getPSSysCounterName() != null)) {
            iDataObject.set(FIELD_PSSYSCOUNTERNAME, (Object)pSDEUIActionBase.getPSSysCounterName());
        }
        if (pSDEUIActionBase.isPSSysDynaModelIdDirty() && (bl || pSDEUIActionBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSDEUIActionBase.getPSSysDynaModelId());
        }
        if (pSDEUIActionBase.isPSSysDynaModelNameDirty() && (bl || pSDEUIActionBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSDEUIActionBase.getPSSysDynaModelName());
        }
        if (pSDEUIActionBase.isPSSysImageIdDirty() && (bl || pSDEUIActionBase.getPSSysImageId() != null)) {
            iDataObject.set(FIELD_PSSYSIMAGEID, (Object)pSDEUIActionBase.getPSSysImageId());
        }
        if (pSDEUIActionBase.isPSSysImageNameDirty() && (bl || pSDEUIActionBase.getPSSysImageName() != null)) {
            iDataObject.set(FIELD_PSSYSIMAGENAME, (Object)pSDEUIActionBase.getPSSysImageName());
        }
        if (pSDEUIActionBase.isPSSysPDTViewIdDirty() && (bl || pSDEUIActionBase.getPSSysPDTViewId() != null)) {
            iDataObject.set(FIELD_PSSYSPDTVIEWID, (Object)pSDEUIActionBase.getPSSysPDTViewId());
        }
        if (pSDEUIActionBase.isPSSysPDTViewNameDirty() && (bl || pSDEUIActionBase.getPSSysPDTViewName() != null)) {
            iDataObject.set(FIELD_PSSYSPDTVIEWNAME, (Object)pSDEUIActionBase.getPSSysPDTViewName());
        }
        if (pSDEUIActionBase.isPSSysPFPluginIdDirty() && (bl || pSDEUIActionBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSDEUIActionBase.getPSSysPFPluginId());
        }
        if (pSDEUIActionBase.isPSSysPFPluginNameDirty() && (bl || pSDEUIActionBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSDEUIActionBase.getPSSysPFPluginName());
        }
        if (pSDEUIActionBase.isPSSysReqItemIdDirty() && (bl || pSDEUIActionBase.getPSSysReqItemId() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMID, (Object)pSDEUIActionBase.getPSSysReqItemId());
        }
        if (pSDEUIActionBase.isPSSysReqItemNameDirty() && (bl || pSDEUIActionBase.getPSSysReqItemName() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMNAME, (Object)pSDEUIActionBase.getPSSysReqItemName());
        }
        if (pSDEUIActionBase.isPSSystemIdDirty() && (bl || pSDEUIActionBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSDEUIActionBase.getPSSystemId());
        }
        if (pSDEUIActionBase.isPSSystemNameDirty() && (bl || pSDEUIActionBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSDEUIActionBase.getPSSystemName());
        }
        if (pSDEUIActionBase.isPSSysUIActionIdDirty() && (bl || pSDEUIActionBase.getPSSysUIActionId() != null)) {
            iDataObject.set(FIELD_PSSYSUIACTIONID, (Object)pSDEUIActionBase.getPSSysUIActionId());
        }
        if (pSDEUIActionBase.isPSSysUIActionNameDirty() && (bl || pSDEUIActionBase.getPSSysUIActionName() != null)) {
            iDataObject.set(FIELD_PSSYSUIACTIONNAME, (Object)pSDEUIActionBase.getPSSysUIActionName());
        }
        if (pSDEUIActionBase.isPSSysViewLogicIdDirty() && (bl || pSDEUIActionBase.getPSSysViewLogicId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWLOGICID, (Object)pSDEUIActionBase.getPSSysViewLogicId());
        }
        if (pSDEUIActionBase.isPSSysViewLogicNameDirty() && (bl || pSDEUIActionBase.getPSSysViewLogicName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWLOGICNAME, (Object)pSDEUIActionBase.getPSSysViewLogicName());
        }
        if (pSDEUIActionBase.isPSWFIdDirty() && (bl || pSDEUIActionBase.getPSWFId() != null)) {
            iDataObject.set(FIELD_PSWFID, (Object)pSDEUIActionBase.getPSWFId());
        }
        if (pSDEUIActionBase.isPSWFNameDirty() && (bl || pSDEUIActionBase.getPSWFName() != null)) {
            iDataObject.set(FIELD_PSWFNAME, (Object)pSDEUIActionBase.getPSWFName());
        }
        if (pSDEUIActionBase.isPSWFLinkIdDirty() && (bl || pSDEUIActionBase.getPSWFLinkId() != null)) {
            iDataObject.set(FIELD_PSWFLINKID, (Object)pSDEUIActionBase.getPSWFLinkId());
        }
        if (pSDEUIActionBase.isPSWFLinkNameDirty() && (bl || pSDEUIActionBase.getPSWFLinkName() != null)) {
            iDataObject.set(FIELD_PSWFLINKNAME, (Object)pSDEUIActionBase.getPSWFLinkName());
        }
        if (pSDEUIActionBase.isPSWFProcessIdDirty() && (bl || pSDEUIActionBase.getPSWFProcessId() != null)) {
            iDataObject.set(FIELD_PSWFPROCESSID, (Object)pSDEUIActionBase.getPSWFProcessId());
        }
        if (pSDEUIActionBase.isPSWFProcessNameDirty() && (bl || pSDEUIActionBase.getPSWFProcessName() != null)) {
            iDataObject.set(FIELD_PSWFPROCESSNAME, (Object)pSDEUIActionBase.getPSWFProcessName());
        }
        if (pSDEUIActionBase.isPSWFVersionIdDirty() && (bl || pSDEUIActionBase.getPSWFVersionId() != null)) {
            iDataObject.set(FIELD_PSWFVERSIONID, (Object)pSDEUIActionBase.getPSWFVersionId());
        }
        if (pSDEUIActionBase.isPSWFVersionNameDirty() && (bl || pSDEUIActionBase.getPSWFVersionName() != null)) {
            iDataObject.set(FIELD_PSWFVERSIONNAME, (Object)pSDEUIActionBase.getPSWFVersionName());
        }
        if (pSDEUIActionBase.isReloadDataDirty() && (bl || pSDEUIActionBase.getReloadData() != null)) {
            iDataObject.set(FIELD_RELOADDATA, (Object)pSDEUIActionBase.getReloadData());
        }
        if (pSDEUIActionBase.isRepPSSysUIActionIdDirty() && (bl || pSDEUIActionBase.getRepPSSysUIActionId() != null)) {
            iDataObject.set(FIELD_REPPSSYSUIACTIONID, (Object)pSDEUIActionBase.getRepPSSysUIActionId());
        }
        if (pSDEUIActionBase.isRepPSSysUIActionNameDirty() && (bl || pSDEUIActionBase.getRepPSSysUIActionName() != null)) {
            iDataObject.set(FIELD_REPPSSYSUIACTIONNAME, (Object)pSDEUIActionBase.getRepPSSysUIActionName());
        }
        if (pSDEUIActionBase.isSMPSLanResIdDirty() && (bl || pSDEUIActionBase.getSMPSLanResId() != null)) {
            iDataObject.set(FIELD_SMPSLANRESID, (Object)pSDEUIActionBase.getSMPSLanResId());
        }
        if (pSDEUIActionBase.isSMPSLanResNameDirty() && (bl || pSDEUIActionBase.getSMPSLanResName() != null)) {
            iDataObject.set(FIELD_SMPSLANRESNAME, (Object)pSDEUIActionBase.getSMPSLanResName());
        }
        if (pSDEUIActionBase.isSuccessInfoDirty() && (bl || pSDEUIActionBase.getSuccessInfo() != null)) {
            iDataObject.set(FIELD_SUCCESSINFO, (Object)pSDEUIActionBase.getSuccessInfo());
        }
        if (pSDEUIActionBase.isSysItemObjDirty() && (bl || pSDEUIActionBase.getSysItemObj() != null)) {
            iDataObject.set(FIELD_SYSITEMOBJ, (Object)pSDEUIActionBase.getSysItemObj());
        }
        if (pSDEUIActionBase.isTemplModeDirty() && (bl || pSDEUIActionBase.getTemplMode() != null)) {
            iDataObject.set(FIELD_TEMPLMODE, (Object)pSDEUIActionBase.getTemplMode());
        }
        if (pSDEUIActionBase.isTextItemDirty() && (bl || pSDEUIActionBase.getTextItem() != null)) {
            iDataObject.set(FIELD_TEXTITEM, (Object)pSDEUIActionBase.getTextItem());
        }
        if (pSDEUIActionBase.isTimeoutDirty() && (bl || pSDEUIActionBase.getTimeout() != null)) {
            iDataObject.set(FIELD_TIMEOUT, (Object)pSDEUIActionBase.getTimeout());
        }
        if (pSDEUIActionBase.isTipPSLanResIdDirty() && (bl || pSDEUIActionBase.getTipPSLanResId() != null)) {
            iDataObject.set(FIELD_TIPPSLANRESID, (Object)pSDEUIActionBase.getTipPSLanResId());
        }
        if (pSDEUIActionBase.isTipPSLanResNameDirty() && (bl || pSDEUIActionBase.getTipPSLanResName() != null)) {
            iDataObject.set(FIELD_TIPPSLANRESNAME, (Object)pSDEUIActionBase.getTipPSLanResName());
        }
        if (pSDEUIActionBase.isToDoTaskDirty() && (bl || pSDEUIActionBase.getToDoTask() != null)) {
            iDataObject.set(FIELD_TODOTASK, (Object)pSDEUIActionBase.getToDoTask());
        }
        if (pSDEUIActionBase.isTooltipInfoDirty() && (bl || pSDEUIActionBase.getTooltipInfo() != null)) {
            iDataObject.set(FIELD_TOOLTIPINFO, (Object)pSDEUIActionBase.getTooltipInfo());
        }
        if (pSDEUIActionBase.isUATagDirty() && (bl || pSDEUIActionBase.getUATag() != null)) {
            iDataObject.set(FIELD_UATAG, (Object)pSDEUIActionBase.getUATag());
        }
        if (pSDEUIActionBase.isUATag2Dirty() && (bl || pSDEUIActionBase.getUATag2() != null)) {
            iDataObject.set(FIELD_UATAG2, (Object)pSDEUIActionBase.getUATag2());
        }
        if (pSDEUIActionBase.isUATag3Dirty() && (bl || pSDEUIActionBase.getUATag3() != null)) {
            iDataObject.set(FIELD_UATAG3, (Object)pSDEUIActionBase.getUATag3());
        }
        if (pSDEUIActionBase.isUATag4Dirty() && (bl || pSDEUIActionBase.getUATag4() != null)) {
            iDataObject.set(FIELD_UATAG4, (Object)pSDEUIActionBase.getUATag4());
        }
        if (pSDEUIActionBase.isUIActionCodeDirty() && (bl || pSDEUIActionBase.getUIActionCode() != null)) {
            iDataObject.set(FIELD_UIACTIONCODE, (Object)pSDEUIActionBase.getUIActionCode());
        }
        if (pSDEUIActionBase.isUIActionParamDirty() && (bl || pSDEUIActionBase.getUIActionParam() != null)) {
            iDataObject.set(FIELD_UIACTIONPARAM, (Object)pSDEUIActionBase.getUIActionParam());
        }
        if (pSDEUIActionBase.isUIActionParam10Dirty() && (bl || pSDEUIActionBase.getUIActionParam10() != null)) {
            iDataObject.set(FIELD_UIACTIONPARAM10, (Object)pSDEUIActionBase.getUIActionParam10());
        }
        if (pSDEUIActionBase.isUIActionParam11Dirty() && (bl || pSDEUIActionBase.getUIActionParam11() != null)) {
            iDataObject.set(FIELD_UIACTIONPARAM11, (Object)pSDEUIActionBase.getUIActionParam11());
        }
        if (pSDEUIActionBase.isUIActionParam12Dirty() && (bl || pSDEUIActionBase.getUIActionParam12() != null)) {
            iDataObject.set(FIELD_UIACTIONPARAM12, (Object)pSDEUIActionBase.getUIActionParam12());
        }
        if (pSDEUIActionBase.isUIActionParam2Dirty() && (bl || pSDEUIActionBase.getUIActionParam2() != null)) {
            iDataObject.set(FIELD_UIACTIONPARAM2, (Object)pSDEUIActionBase.getUIActionParam2());
        }
        if (pSDEUIActionBase.isUIActionParam3Dirty() && (bl || pSDEUIActionBase.getUIActionParam3() != null)) {
            iDataObject.set(FIELD_UIACTIONPARAM3, (Object)pSDEUIActionBase.getUIActionParam3());
        }
        if (pSDEUIActionBase.isUIActionParam4Dirty() && (bl || pSDEUIActionBase.getUIActionParam4() != null)) {
            iDataObject.set(FIELD_UIACTIONPARAM4, (Object)pSDEUIActionBase.getUIActionParam4());
        }
        if (pSDEUIActionBase.isUIActionParam5Dirty() && (bl || pSDEUIActionBase.getUIActionParam5() != null)) {
            iDataObject.set(FIELD_UIACTIONPARAM5, (Object)pSDEUIActionBase.getUIActionParam5());
        }
        if (pSDEUIActionBase.isUIActionParam6Dirty() && (bl || pSDEUIActionBase.getUIActionParam6() != null)) {
            iDataObject.set(FIELD_UIACTIONPARAM6, (Object)pSDEUIActionBase.getUIActionParam6());
        }
        if (pSDEUIActionBase.isUIActionParam7Dirty() && (bl || pSDEUIActionBase.getUIActionParam7() != null)) {
            iDataObject.set(FIELD_UIACTIONPARAM7, (Object)pSDEUIActionBase.getUIActionParam7());
        }
        if (pSDEUIActionBase.isUIActionParam8Dirty() && (bl || pSDEUIActionBase.getUIActionParam8() != null)) {
            iDataObject.set(FIELD_UIACTIONPARAM8, (Object)pSDEUIActionBase.getUIActionParam8());
        }
        if (pSDEUIActionBase.isUIActionParam9Dirty() && (bl || pSDEUIActionBase.getUIActionParam9() != null)) {
            iDataObject.set(FIELD_UIACTIONPARAM9, (Object)pSDEUIActionBase.getUIActionParam9());
        }
        if (pSDEUIActionBase.isUIActionParamsDirty() && (bl || pSDEUIActionBase.getUIActionParams() != null)) {
            iDataObject.set(FIELD_UIACTIONPARAMS, (Object)pSDEUIActionBase.getUIActionParams());
        }
        if (pSDEUIActionBase.isUIActionTypeDirty() && (bl || pSDEUIActionBase.getUIActionType() != null)) {
            iDataObject.set(FIELD_UIACTIONTYPE, (Object)pSDEUIActionBase.getUIActionType());
        }
        if (pSDEUIActionBase.isUpdateDateDirty() && (bl || pSDEUIActionBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEUIActionBase.getUpdateDate());
        }
        if (pSDEUIActionBase.isUpdateManDirty() && (bl || pSDEUIActionBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEUIActionBase.getUpdateMan());
        }
        if (pSDEUIActionBase.isUserCatDirty() && (bl || pSDEUIActionBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEUIActionBase.getUserCat());
        }
        if (pSDEUIActionBase.isUserConfirmDirty() && (bl || pSDEUIActionBase.getUserConfirm() != null)) {
            iDataObject.set(FIELD_USERCONFIRM, (Object)pSDEUIActionBase.getUserConfirm());
        }
        if (pSDEUIActionBase.isUserParamsDirty() && (bl || pSDEUIActionBase.getUserParams() != null)) {
            iDataObject.set(FIELD_USERPARAMS, (Object)pSDEUIActionBase.getUserParams());
        }
        if (pSDEUIActionBase.isUserTagDirty() && (bl || pSDEUIActionBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEUIActionBase.getUserTag());
        }
        if (pSDEUIActionBase.isUserTag2Dirty() && (bl || pSDEUIActionBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEUIActionBase.getUserTag2());
        }
        if (pSDEUIActionBase.isUserTag3Dirty() && (bl || pSDEUIActionBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEUIActionBase.getUserTag3());
        }
        if (pSDEUIActionBase.isUserTag4Dirty() && (bl || pSDEUIActionBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEUIActionBase.getUserTag4());
        }
        if (pSDEUIActionBase.isViewActionsDirty() && (bl || pSDEUIActionBase.getViewActions() != null)) {
            iDataObject.set(FIELD_VIEWACTIONS, (Object)pSDEUIActionBase.getViewActions());
        }
        if (pSDEUIActionBase.isViewLogicTypeDirty() && (bl || pSDEUIActionBase.getViewLogicType() != null)) {
            iDataObject.set(FIELD_VIEWLOGICTYPE, (Object)pSDEUIActionBase.getViewLogicType());
        }
        if (pSDEUIActionBase.isVisibleLogicDirty() && (bl || pSDEUIActionBase.getVisibleLogic() != null)) {
            iDataObject.set(FIELD_VISIBLELOGIC, (Object)pSDEUIActionBase.getVisibleLogic());
        }
        if (pSDEUIActionBase.isVLExecModeDirty() && (bl || pSDEUIActionBase.getVLExecMode() != null)) {
            iDataObject.set(FIELD_VLEXECMODE, (Object)pSDEUIActionBase.getVLExecMode());
        }
    }

    public boolean remove(String string) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().remove(string);
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer n = fieldIndexMap.get(string.toUpperCase());
        if (n == null) {
            return super.remove(string);
        }
        return PSDEUIActionBase.remove(this, n);
    }

    private static boolean remove(PSDEUIActionBase pSDEUIActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEUIActionBase.resetActionLevel();
                return true;
            }
            case 1: {
                pSDEUIActionBase.resetActionTarget();
                return true;
            }
            case 2: {
                pSDEUIActionBase.resetBusyIndicator();
                return true;
            }
            case 3: {
                pSDEUIActionBase.resetButtonStyle();
                return true;
            }
            case 4: {
                pSDEUIActionBase.resetCapPSLanResId();
                return true;
            }
            case 5: {
                pSDEUIActionBase.resetCapPSLanResName();
                return true;
            }
            case 6: {
                pSDEUIActionBase.resetCaption();
                return true;
            }
            case 7: {
                pSDEUIActionBase.resetCloseEditView();
                return true;
            }
            case 8: {
                pSDEUIActionBase.resetCMPSLanResId();
                return true;
            }
            case 9: {
                pSDEUIActionBase.resetCMPSLanResName();
                return true;
            }
            case 10: {
                pSDEUIActionBase.resetCodeName();
                return true;
            }
            case 11: {
                pSDEUIActionBase.resetConfirmInfo();
                return true;
            }
            case 12: {
                pSDEUIActionBase.resetCounterId();
                return true;
            }
            case 13: {
                pSDEUIActionBase.resetCreateDate();
                return true;
            }
            case 14: {
                pSDEUIActionBase.resetCreateMan();
                return true;
            }
            case 15: {
                pSDEUIActionBase.resetCustomCode();
                return true;
            }
            case 16: {
                pSDEUIActionBase.resetDataItem();
                return true;
            }
            case 17: {
                pSDEUIActionBase.resetDynaModelFlag();
                return true;
            }
            case 18: {
                pSDEUIActionBase.resetEnableLogic();
                return true;
            }
            case 19: {
                pSDEUIActionBase.resetEnableRTModel();
                return true;
            }
            case 20: {
                pSDEUIActionBase.resetEnableViewActions();
                return true;
            }
            case 21: {
                pSDEUIActionBase.resetExtendMode();
                return true;
            }
            case 22: {
                pSDEUIActionBase.resetFrontProType();
                return true;
            }
            case 23: {
                pSDEUIActionBase.resetGlobalFlag();
                return true;
            }
            case 24: {
                pSDEUIActionBase.resetHtmlPageUrl();
                return true;
            }
            case 25: {
                pSDEUIActionBase.resetItemObj();
                return true;
            }
            case 26: {
                pSDEUIActionBase.resetLockFlag();
                return true;
            }
            case 27: {
                pSDEUIActionBase.resetMemo();
                return true;
            }
            case 28: {
                pSDEUIActionBase.resetMobPSDEViewId();
                return true;
            }
            case 29: {
                pSDEUIActionBase.resetMobPSDEViewName();
                return true;
            }
            case 30: {
                pSDEUIActionBase.resetNextPSDEUIActionId();
                return true;
            }
            case 31: {
                pSDEUIActionBase.resetNextPSDEUIActionName();
                return true;
            }
            case 32: {
                pSDEUIActionBase.resetNo2PSDEDataExpId();
                return true;
            }
            case 33: {
                pSDEUIActionBase.resetNo2PSDEDataExpName();
                return true;
            }
            case 34: {
                pSDEUIActionBase.resetNoPrivDM();
                return true;
            }
            case 35: {
                pSDEUIActionBase.resetParamItem();
                return true;
            }
            case 36: {
                pSDEUIActionBase.resetPDTViewFlag();
                return true;
            }
            case 37: {
                pSDEUIActionBase.resetPSDEACModeId();
                return true;
            }
            case 38: {
                pSDEUIActionBase.resetPSDEACModeName();
                return true;
            }
            case 39: {
                pSDEUIActionBase.resetPSDEActionId();
                return true;
            }
            case 40: {
                pSDEUIActionBase.resetPSDEActionName();
                return true;
            }
            case 41: {
                pSDEUIActionBase.resetPSDEDataExpId();
                return true;
            }
            case 42: {
                pSDEUIActionBase.resetPSDEDataImpId();
                return true;
            }
            case 43: {
                pSDEUIActionBase.resetPSDEDataImpName();
                return true;
            }
            case 44: {
                pSDEUIActionBase.resetPSDEFGroupId();
                return true;
            }
            case 45: {
                pSDEUIActionBase.resetPSDEFGroupName();
                return true;
            }
            case 46: {
                pSDEUIActionBase.resetPSDEFormId();
                return true;
            }
            case 47: {
                pSDEUIActionBase.resetPSDEFormName();
                return true;
            }
            case 48: {
                pSDEUIActionBase.resetPSDEId();
                return true;
            }
            case 49: {
                pSDEUIActionBase.resetPSDEName();
                return true;
            }
            case 50: {
                pSDEUIActionBase.resetPSDEOPPrivId();
                return true;
            }
            case 51: {
                pSDEUIActionBase.resetPSDEOPPrivName();
                return true;
            }
            case 52: {
                pSDEUIActionBase.resetPSDEPrintId();
                return true;
            }
            case 53: {
                pSDEUIActionBase.resetPSDEPrintName();
                return true;
            }
            case 54: {
                pSDEUIActionBase.resetPSDEUIActionId();
                return true;
            }
            case 55: {
                pSDEUIActionBase.resetPSDEUIActionName();
                return true;
            }
            case 56: {
                pSDEUIActionBase.resetPSDEViewBaseId();
                return true;
            }
            case 57: {
                pSDEUIActionBase.resetPSDEViewBaseName();
                return true;
            }
            case 58: {
                pSDEUIActionBase.resetPSDEViewLogicId();
                return true;
            }
            case 59: {
                pSDEUIActionBase.resetPSDEViewLogicName();
                return true;
            }
            case 60: {
                pSDEUIActionBase.resetPSDynaInstId();
                return true;
            }
            case 61: {
                pSDEUIActionBase.resetPSModuleId();
                return true;
            }
            case 62: {
                pSDEUIActionBase.resetPSModuleName();
                return true;
            }
            case 63: {
                pSDEUIActionBase.resetPSSysCounterId();
                return true;
            }
            case 64: {
                pSDEUIActionBase.resetPSSysCounterName();
                return true;
            }
            case 65: {
                pSDEUIActionBase.resetPSSysDynaModelId();
                return true;
            }
            case 66: {
                pSDEUIActionBase.resetPSSysDynaModelName();
                return true;
            }
            case 67: {
                pSDEUIActionBase.resetPSSysImageId();
                return true;
            }
            case 68: {
                pSDEUIActionBase.resetPSSysImageName();
                return true;
            }
            case 69: {
                pSDEUIActionBase.resetPSSysPDTViewId();
                return true;
            }
            case 70: {
                pSDEUIActionBase.resetPSSysPDTViewName();
                return true;
            }
            case 71: {
                pSDEUIActionBase.resetPSSysPFPluginId();
                return true;
            }
            case 72: {
                pSDEUIActionBase.resetPSSysPFPluginName();
                return true;
            }
            case 73: {
                pSDEUIActionBase.resetPSSysReqItemId();
                return true;
            }
            case 74: {
                pSDEUIActionBase.resetPSSysReqItemName();
                return true;
            }
            case 75: {
                pSDEUIActionBase.resetPSSystemId();
                return true;
            }
            case 76: {
                pSDEUIActionBase.resetPSSystemName();
                return true;
            }
            case 77: {
                pSDEUIActionBase.resetPSSysUIActionId();
                return true;
            }
            case 78: {
                pSDEUIActionBase.resetPSSysUIActionName();
                return true;
            }
            case 79: {
                pSDEUIActionBase.resetPSSysViewLogicId();
                return true;
            }
            case 80: {
                pSDEUIActionBase.resetPSSysViewLogicName();
                return true;
            }
            case 81: {
                pSDEUIActionBase.resetPSWFId();
                return true;
            }
            case 82: {
                pSDEUIActionBase.resetPSWFName();
                return true;
            }
            case 83: {
                pSDEUIActionBase.resetPSWFLinkId();
                return true;
            }
            case 84: {
                pSDEUIActionBase.resetPSWFLinkName();
                return true;
            }
            case 85: {
                pSDEUIActionBase.resetPSWFProcessId();
                return true;
            }
            case 86: {
                pSDEUIActionBase.resetPSWFProcessName();
                return true;
            }
            case 87: {
                pSDEUIActionBase.resetPSWFVersionId();
                return true;
            }
            case 88: {
                pSDEUIActionBase.resetPSWFVersionName();
                return true;
            }
            case 89: {
                pSDEUIActionBase.resetReloadData();
                return true;
            }
            case 90: {
                pSDEUIActionBase.resetRepPSSysUIActionId();
                return true;
            }
            case 91: {
                pSDEUIActionBase.resetRepPSSysUIActionName();
                return true;
            }
            case 92: {
                pSDEUIActionBase.resetSMPSLanResId();
                return true;
            }
            case 93: {
                pSDEUIActionBase.resetSMPSLanResName();
                return true;
            }
            case 94: {
                pSDEUIActionBase.resetSuccessInfo();
                return true;
            }
            case 95: {
                pSDEUIActionBase.resetSysItemObj();
                return true;
            }
            case 96: {
                pSDEUIActionBase.resetTemplMode();
                return true;
            }
            case 97: {
                pSDEUIActionBase.resetTextItem();
                return true;
            }
            case 98: {
                pSDEUIActionBase.resetTimeout();
                return true;
            }
            case 99: {
                pSDEUIActionBase.resetTipPSLanResId();
                return true;
            }
            case 100: {
                pSDEUIActionBase.resetTipPSLanResName();
                return true;
            }
            case 101: {
                pSDEUIActionBase.resetToDoTask();
                return true;
            }
            case 102: {
                pSDEUIActionBase.resetTooltipInfo();
                return true;
            }
            case 103: {
                pSDEUIActionBase.resetUATag();
                return true;
            }
            case 104: {
                pSDEUIActionBase.resetUATag2();
                return true;
            }
            case 105: {
                pSDEUIActionBase.resetUATag3();
                return true;
            }
            case 106: {
                pSDEUIActionBase.resetUATag4();
                return true;
            }
            case 107: {
                pSDEUIActionBase.resetUIActionCode();
                return true;
            }
            case 108: {
                pSDEUIActionBase.resetUIActionParam();
                return true;
            }
            case 109: {
                pSDEUIActionBase.resetUIActionParam10();
                return true;
            }
            case 110: {
                pSDEUIActionBase.resetUIActionParam11();
                return true;
            }
            case 111: {
                pSDEUIActionBase.resetUIActionParam12();
                return true;
            }
            case 112: {
                pSDEUIActionBase.resetUIActionParam2();
                return true;
            }
            case 113: {
                pSDEUIActionBase.resetUIActionParam3();
                return true;
            }
            case 114: {
                pSDEUIActionBase.resetUIActionParam4();
                return true;
            }
            case 115: {
                pSDEUIActionBase.resetUIActionParam5();
                return true;
            }
            case 116: {
                pSDEUIActionBase.resetUIActionParam6();
                return true;
            }
            case 117: {
                pSDEUIActionBase.resetUIActionParam7();
                return true;
            }
            case 118: {
                pSDEUIActionBase.resetUIActionParam8();
                return true;
            }
            case 119: {
                pSDEUIActionBase.resetUIActionParam9();
                return true;
            }
            case 120: {
                pSDEUIActionBase.resetUIActionParams();
                return true;
            }
            case 121: {
                pSDEUIActionBase.resetUIActionType();
                return true;
            }
            case 122: {
                pSDEUIActionBase.resetUpdateDate();
                return true;
            }
            case 123: {
                pSDEUIActionBase.resetUpdateMan();
                return true;
            }
            case 124: {
                pSDEUIActionBase.resetUserCat();
                return true;
            }
            case 125: {
                pSDEUIActionBase.resetUserConfirm();
                return true;
            }
            case 126: {
                pSDEUIActionBase.resetUserParams();
                return true;
            }
            case 127: {
                pSDEUIActionBase.resetUserTag();
                return true;
            }
            case 128: {
                pSDEUIActionBase.resetUserTag2();
                return true;
            }
            case 129: {
                pSDEUIActionBase.resetUserTag3();
                return true;
            }
            case 130: {
                pSDEUIActionBase.resetUserTag4();
                return true;
            }
            case 131: {
                pSDEUIActionBase.resetViewActions();
                return true;
            }
            case 132: {
                pSDEUIActionBase.resetViewLogicType();
                return true;
            }
            case 133: {
                pSDEUIActionBase.resetVisibleLogic();
                return true;
            }
            case 134: {
                pSDEUIActionBase.resetVLExecMode();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getPSDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDE();
        }
        if (this.getPSDEId() == null) {
            return null;
        }
        Integer n = this.objPSDELock;
        synchronized (n) {
            if (this.psde != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEId(), (Object)this.psde.getPSDataEntityId()) != 0L) {
                this.psde = null;
            }
            if (this.psde == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getPSDEId());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet(pSDataEntity);
                this.psde = pSDataEntity;
            }
            return this.psde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEACMode getPSDEACMode() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEACMode();
        }
        if (this.getPSDEACModeId() == null) {
            return null;
        }
        Integer n = this.objPSDEACModeLock;
        synchronized (n) {
            if (this.psdeacmode != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEACModeId(), (Object)this.psdeacmode.getPSDEACModeId()) != 0L) {
                this.psdeacmode = null;
            }
            if (this.psdeacmode == null) {
                PSDEACMode pSDEACMode = new PSDEACMode();
                pSDEACMode.setPSDEACModeId(this.getPSDEACModeId());
                PSDEACModeService pSDEACModeService = (PSDEACModeService)ServiceGlobal.getService(PSDEACModeService.class, (SessionFactory)this.getSessionFactory());
                pSDEACModeService.autoGet(pSDEACMode);
                this.psdeacmode = pSDEACMode;
            }
            return this.psdeacmode;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEAction getPSDEAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEAction();
        }
        if (this.getPSDEActionId() == null) {
            return null;
        }
        Integer n = this.objPSDEActionLock;
        synchronized (n) {
            if (this.psdeaction != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEActionId(), (Object)this.psdeaction.getPSDEActionId()) != 0L) {
                this.psdeaction = null;
            }
            if (this.psdeaction == null) {
                PSDEAction pSDEAction = new PSDEAction();
                pSDEAction.setPSDEActionId(this.getPSDEActionId());
                PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEActionService.autoGet(pSDEAction);
                this.psdeaction = pSDEAction;
            }
            return this.psdeaction;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDataExp getNo2PSDEDataExp() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo2PSDEDataExp();
        }
        if (this.getNo2PSDEDataExpId() == null) {
            return null;
        }
        Integer n = this.objNo2PSDEDataExpLock;
        synchronized (n) {
            if (this.no2psdedataexp != null && DataTypeHelper.compare((int)25, (Object)this.getNo2PSDEDataExpId(), (Object)this.no2psdedataexp.getPSDEDataExpId()) != 0L) {
                this.no2psdedataexp = null;
            }
            if (this.no2psdedataexp == null) {
                PSDEDataExp pSDEDataExp = new PSDEDataExp();
                pSDEDataExp.setPSDEDataExpId(this.getNo2PSDEDataExpId());
                PSDEDataExpService pSDEDataExpService = (PSDEDataExpService)ServiceGlobal.getService(PSDEDataExpService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataExpService.autoGet(pSDEDataExp);
                this.no2psdedataexp = pSDEDataExp;
            }
            return this.no2psdedataexp;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDataImp getPSDEDataImp() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataImp();
        }
        if (this.getPSDEDataImpId() == null) {
            return null;
        }
        Integer n = this.objPSDEDataImpLock;
        synchronized (n) {
            if (this.psdedataimp != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEDataImpId(), (Object)this.psdedataimp.getPSDEDataImpId()) != 0L) {
                this.psdedataimp = null;
            }
            if (this.psdedataimp == null) {
                PSDEDataImp pSDEDataImp = new PSDEDataImp();
                pSDEDataImp.setPSDEDataImpId(this.getPSDEDataImpId());
                PSDEDataImpService pSDEDataImpService = (PSDEDataImpService)ServiceGlobal.getService(PSDEDataImpService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataImpService.autoGet(pSDEDataImp);
                this.psdedataimp = pSDEDataImp;
            }
            return this.psdedataimp;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEFGroup getPSDEFGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFGroup();
        }
        if (this.getPSDEFGroupId() == null) {
            return null;
        }
        Integer n = this.objPSDEFGroupLock;
        synchronized (n) {
            if (this.psdefgroup != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEFGroupId(), (Object)this.psdefgroup.getPSDEFGroupId()) != 0L) {
                this.psdefgroup = null;
            }
            if (this.psdefgroup == null) {
                PSDEFGroup pSDEFGroup = new PSDEFGroup();
                pSDEFGroup.setPSDEFGroupId(this.getPSDEFGroupId());
                PSDEFGroupService pSDEFGroupService = (PSDEFGroupService)ServiceGlobal.getService(PSDEFGroupService.class, (SessionFactory)this.getSessionFactory());
                pSDEFGroupService.autoGet(pSDEFGroup);
                this.psdefgroup = pSDEFGroup;
            }
            return this.psdefgroup;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEForm getPSDEForm() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEForm();
        }
        if (this.getPSDEFormId() == null) {
            return null;
        }
        Integer n = this.objPSDEFormLock;
        synchronized (n) {
            if (this.psdeform != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEFormId(), (Object)this.psdeform.getPSDEFormId()) != 0L) {
                this.psdeform = null;
            }
            if (this.psdeform == null) {
                PSDEForm pSDEForm = new PSDEForm();
                pSDEForm.setPSDEFormId(this.getPSDEFormId());
                PSDEFormService pSDEFormService = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)this.getSessionFactory());
                pSDEFormService.autoGet(pSDEForm);
                this.psdeform = pSDEForm;
            }
            return this.psdeform;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDELogic getPSDEViewLogic() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewLogic();
        }
        if (this.getPSDEViewLogicId() == null) {
            return null;
        }
        Integer n = this.objPSDEViewLogicLock;
        synchronized (n) {
            if (this.psdeviewlogic != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEViewLogicId(), (Object)this.psdeviewlogic.getPSDELogicId()) != 0L) {
                this.psdeviewlogic = null;
            }
            if (this.psdeviewlogic == null) {
                PSDELogic pSDELogic = new PSDELogic();
                pSDELogic.setPSDELogicId(this.getPSDEViewLogicId());
                PSDELogicService pSDELogicService = (PSDELogicService)ServiceGlobal.getService(PSDELogicService.class, (SessionFactory)this.getSessionFactory());
                pSDELogicService.autoGet(pSDELogic);
                this.psdeviewlogic = pSDELogic;
            }
            return this.psdeviewlogic;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEOPPriv getPSDEOpPriv() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEOpPriv();
        }
        if (this.getPSDEOPPrivId() == null) {
            return null;
        }
        Integer n = this.objPSDEOpPrivLock;
        synchronized (n) {
            if (this.psdeoppriv != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEOPPrivId(), (Object)this.psdeoppriv.getPSDEOPPrivId()) != 0L) {
                this.psdeoppriv = null;
            }
            if (this.psdeoppriv == null) {
                PSDEOPPriv pSDEOPPriv = new PSDEOPPriv();
                pSDEOPPriv.setPSDEOPPrivId(this.getPSDEOPPrivId());
                PSDEOPPrivService pSDEOPPrivService = (PSDEOPPrivService)ServiceGlobal.getService(PSDEOPPrivService.class, (SessionFactory)this.getSessionFactory());
                pSDEOPPrivService.autoGet(pSDEOPPriv);
                this.psdeoppriv = pSDEOPPriv;
            }
            return this.psdeoppriv;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEPrint getPSDEPrint() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEPrint();
        }
        if (this.getPSDEPrintId() == null) {
            return null;
        }
        Integer n = this.objPSDEPrintLock;
        synchronized (n) {
            if (this.psdeprint != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEPrintId(), (Object)this.psdeprint.getPSDEPrintId()) != 0L) {
                this.psdeprint = null;
            }
            if (this.psdeprint == null) {
                PSDEPrint pSDEPrint = new PSDEPrint();
                pSDEPrint.setPSDEPrintId(this.getPSDEPrintId());
                PSDEPrintService pSDEPrintService = (PSDEPrintService)ServiceGlobal.getService(PSDEPrintService.class, (SessionFactory)this.getSessionFactory());
                pSDEPrintService.autoGet(pSDEPrint);
                this.psdeprint = pSDEPrint;
            }
            return this.psdeprint;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEUIAction getNextPSDEUIAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNextPSDEUIAction();
        }
        if (this.getNextPSDEUIActionId() == null) {
            return null;
        }
        Integer n = this.objNextPSDEUIActionLock;
        synchronized (n) {
            if (this.nextpsdeuiaction != null && DataTypeHelper.compare((int)25, (Object)this.getNextPSDEUIActionId(), (Object)this.nextpsdeuiaction.getPSDEUIActionId()) != 0L) {
                this.nextpsdeuiaction = null;
            }
            if (this.nextpsdeuiaction == null) {
                PSDEUIAction pSDEUIAction = new PSDEUIAction();
                pSDEUIAction.setPSDEUIActionId(this.getNextPSDEUIActionId());
                PSDEUIActionService pSDEUIActionService = (PSDEUIActionService)ServiceGlobal.getService(PSDEUIActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEUIActionService.autoGet(pSDEUIAction);
                this.nextpsdeuiaction = pSDEUIAction;
            }
            return this.nextpsdeuiaction;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEViewBase getMobPSDEView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobPSDEView();
        }
        if (this.getMobPSDEViewId() == null) {
            return null;
        }
        Integer n = this.objMobPSDEViewLock;
        synchronized (n) {
            if (this.mobpsdeview != null && DataTypeHelper.compare((int)25, (Object)this.getMobPSDEViewId(), (Object)this.mobpsdeview.getPSDEViewBaseId()) != 0L) {
                this.mobpsdeview = null;
            }
            if (this.mobpsdeview == null) {
                PSDEViewBase pSDEViewBase = new PSDEViewBase();
                pSDEViewBase.setPSDEViewBaseId(this.getMobPSDEViewId());
                PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
                pSDEViewBaseService.autoGet(pSDEViewBase);
                this.mobpsdeview = pSDEViewBase;
            }
            return this.mobpsdeview;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEViewBase getPSDEViewBase() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewBase();
        }
        if (this.getPSDEViewBaseId() == null) {
            return null;
        }
        Integer n = this.objPSDEViewBaseLock;
        synchronized (n) {
            if (this.psdeviewbase != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEViewBaseId(), (Object)this.psdeviewbase.getPSDEViewBaseId()) != 0L) {
                this.psdeviewbase = null;
            }
            if (this.psdeviewbase == null) {
                PSDEViewBase pSDEViewBase = new PSDEViewBase();
                pSDEViewBase.setPSDEViewBaseId(this.getPSDEViewBaseId());
                PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
                pSDEViewBaseService.autoGet(pSDEViewBase);
                this.psdeviewbase = pSDEViewBase;
            }
            return this.psdeviewbase;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguageRes getCapPSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCapPSLanRes();
        }
        if (this.getCapPSLanResId() == null) {
            return null;
        }
        Integer n = this.objCapPSLanResLock;
        synchronized (n) {
            if (this.cappslanres != null && DataTypeHelper.compare((int)25, (Object)this.getCapPSLanResId(), (Object)this.cappslanres.getPSLanguageResId()) != 0L) {
                this.cappslanres = null;
            }
            if (this.cappslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getCapPSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet(pSLanguageRes);
                this.cappslanres = pSLanguageRes;
            }
            return this.cappslanres;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguageRes getCMPSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCMPSLanRes();
        }
        if (this.getCMPSLanResId() == null) {
            return null;
        }
        Integer n = this.objCMPSLanResLock;
        synchronized (n) {
            if (this.cmpslanres != null && DataTypeHelper.compare((int)25, (Object)this.getCMPSLanResId(), (Object)this.cmpslanres.getPSLanguageResId()) != 0L) {
                this.cmpslanres = null;
            }
            if (this.cmpslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getCMPSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet(pSLanguageRes);
                this.cmpslanres = pSLanguageRes;
            }
            return this.cmpslanres;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguageRes getSMPSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSMPSLanRes();
        }
        if (this.getSMPSLanResId() == null) {
            return null;
        }
        Integer n = this.objSMPSLanResLock;
        synchronized (n) {
            if (this.smpslanres != null && DataTypeHelper.compare((int)25, (Object)this.getSMPSLanResId(), (Object)this.smpslanres.getPSLanguageResId()) != 0L) {
                this.smpslanres = null;
            }
            if (this.smpslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getSMPSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet(pSLanguageRes);
                this.smpslanres = pSLanguageRes;
            }
            return this.smpslanres;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguageRes getTipPSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTipPSLanRes();
        }
        if (this.getTipPSLanResId() == null) {
            return null;
        }
        Integer n = this.objTipPSLanResLock;
        synchronized (n) {
            if (this.tippslanres != null && DataTypeHelper.compare((int)25, (Object)this.getTipPSLanResId(), (Object)this.tippslanres.getPSLanguageResId()) != 0L) {
                this.tippslanres = null;
            }
            if (this.tippslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getTipPSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet(pSLanguageRes);
                this.tippslanres = pSLanguageRes;
            }
            return this.tippslanres;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSModule getPSModule() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModule();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        Integer n = this.objPSModuleLock;
        synchronized (n) {
            if (this.psmodule != null && DataTypeHelper.compare((int)25, (Object)this.getPSModuleId(), (Object)this.psmodule.getPSModuleId()) != 0L) {
                this.psmodule = null;
            }
            if (this.psmodule == null) {
                PSModule pSModule = new PSModule();
                pSModule.setPSModuleId(this.getPSModuleId());
                PSModuleService pSModuleService = (PSModuleService)ServiceGlobal.getService(PSModuleService.class, (SessionFactory)this.getSessionFactory());
                pSModuleService.autoGet(pSModule);
                this.psmodule = pSModule;
            }
            return this.psmodule;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysCounter getPSSysCounter() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCounter();
        }
        if (this.getPSSysCounterId() == null) {
            return null;
        }
        Integer n = this.objPSSysCounterLock;
        synchronized (n) {
            if (this.pssyscounter != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysCounterId(), (Object)this.pssyscounter.getPSSysCounterId()) != 0L) {
                this.pssyscounter = null;
            }
            if (this.pssyscounter == null) {
                PSSysCounter pSSysCounter = new PSSysCounter();
                pSSysCounter.setPSSysCounterId(this.getPSSysCounterId());
                PSSysCounterService pSSysCounterService = (PSSysCounterService)ServiceGlobal.getService(PSSysCounterService.class, (SessionFactory)this.getSessionFactory());
                pSSysCounterService.autoGet(pSSysCounter);
                this.pssyscounter = pSSysCounter;
            }
            return this.pssyscounter;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysDynaModel getPSSysDynaModel() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModel();
        }
        if (this.getPSSysDynaModelId() == null) {
            return null;
        }
        Integer n = this.objPSSysDynaModelLock;
        synchronized (n) {
            if (this.pssysdynamodel != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysDynaModelId(), (Object)this.pssysdynamodel.getPSSysDynaModelId()) != 0L) {
                this.pssysdynamodel = null;
            }
            if (this.pssysdynamodel == null) {
                PSSysDynaModel pSSysDynaModel = new PSSysDynaModel();
                pSSysDynaModel.setPSSysDynaModelId(this.getPSSysDynaModelId());
                PSSysDynaModelService pSSysDynaModelService = (PSSysDynaModelService)ServiceGlobal.getService(PSSysDynaModelService.class, (SessionFactory)this.getSessionFactory());
                pSSysDynaModelService.autoGet(pSSysDynaModel);
                this.pssysdynamodel = pSSysDynaModel;
            }
            return this.pssysdynamodel;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysImage getPSSysImage() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysImage();
        }
        if (this.getPSSysImageId() == null) {
            return null;
        }
        Integer n = this.objPSSysImageLock;
        synchronized (n) {
            if (this.pssysimage != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysImageId(), (Object)this.pssysimage.getPSSysImageId()) != 0L) {
                this.pssysimage = null;
            }
            if (this.pssysimage == null) {
                PSSysImage pSSysImage = new PSSysImage();
                pSSysImage.setPSSysImageId(this.getPSSysImageId());
                PSSysImageService pSSysImageService = (PSSysImageService)ServiceGlobal.getService(PSSysImageService.class, (SessionFactory)this.getSessionFactory());
                pSSysImageService.autoGet(pSSysImage);
                this.pssysimage = pSSysImage;
            }
            return this.pssysimage;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysPDTView getPSSysPDTView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPDTView();
        }
        if (this.getPSSysPDTViewId() == null) {
            return null;
        }
        Integer n = this.objPSSysPDTViewLock;
        synchronized (n) {
            if (this.pssyspdtview != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysPDTViewId(), (Object)this.pssyspdtview.getPSSysPDTViewId()) != 0L) {
                this.pssyspdtview = null;
            }
            if (this.pssyspdtview == null) {
                PSSysPDTView pSSysPDTView = new PSSysPDTView();
                pSSysPDTView.setPSSysPDTViewId(this.getPSSysPDTViewId());
                PSSysPDTViewService pSSysPDTViewService = (PSSysPDTViewService)ServiceGlobal.getService(PSSysPDTViewService.class, (SessionFactory)this.getSessionFactory());
                pSSysPDTViewService.autoGet(pSSysPDTView);
                this.pssyspdtview = pSSysPDTView;
            }
            return this.pssyspdtview;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysPFPlugin getPSSysPFPlugin() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPFPlugin();
        }
        if (this.getPSSysPFPluginId() == null) {
            return null;
        }
        Integer n = this.objPSSysPFPluginLock;
        synchronized (n) {
            if (this.pssyspfplugin != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysPFPluginId(), (Object)this.pssyspfplugin.getPSSysPFPluginId()) != 0L) {
                this.pssyspfplugin = null;
            }
            if (this.pssyspfplugin == null) {
                PSSysPFPlugin pSSysPFPlugin = new PSSysPFPlugin();
                pSSysPFPlugin.setPSSysPFPluginId(this.getPSSysPFPluginId());
                PSSysPFPluginService pSSysPFPluginService = (PSSysPFPluginService)ServiceGlobal.getService(PSSysPFPluginService.class, (SessionFactory)this.getSessionFactory());
                pSSysPFPluginService.autoGet(pSSysPFPlugin);
                this.pssyspfplugin = pSSysPFPlugin;
            }
            return this.pssyspfplugin;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysReqItem getPSSysReqItem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysReqItem();
        }
        if (this.getPSSysReqItemId() == null) {
            return null;
        }
        Integer n = this.objPSSysReqItemLock;
        synchronized (n) {
            if (this.pssysreqitem != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysReqItemId(), (Object)this.pssysreqitem.getPSSysReqItemId()) != 0L) {
                this.pssysreqitem = null;
            }
            if (this.pssysreqitem == null) {
                PSSysReqItem pSSysReqItem = new PSSysReqItem();
                pSSysReqItem.setPSSysReqItemId(this.getPSSysReqItemId());
                PSSysReqItemService pSSysReqItemService = (PSSysReqItemService)ServiceGlobal.getService(PSSysReqItemService.class, (SessionFactory)this.getSessionFactory());
                pSSysReqItemService.autoGet(pSSysReqItem);
                this.pssysreqitem = pSSysReqItem;
            }
            return this.pssysreqitem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSystem getPSSystem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystem();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        Integer n = this.objPSSystemLock;
        synchronized (n) {
            if (this.pssystem != null && DataTypeHelper.compare((int)25, (Object)this.getPSSystemId(), (Object)this.pssystem.getPSSystemId()) != 0L) {
                this.pssystem = null;
            }
            if (this.pssystem == null) {
                PSSystem pSSystem = new PSSystem();
                pSSystem.setPSSystemId(this.getPSSystemId());
                PSSystemService pSSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)this.getSessionFactory());
                pSSystemService.autoGet(pSSystem);
                this.pssystem = pSSystem;
            }
            return this.pssystem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysUIAction getPSSysUIAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUIAction();
        }
        if (this.getPSSysUIActionId() == null) {
            return null;
        }
        Integer n = this.objPSSysUIActionLock;
        synchronized (n) {
            if (this.pssysuiaction != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysUIActionId(), (Object)this.pssysuiaction.getPSSysUIActionId()) != 0L) {
                this.pssysuiaction = null;
            }
            if (this.pssysuiaction == null) {
                PSSysUIAction pSSysUIAction = new PSSysUIAction();
                pSSysUIAction.setPSSysUIActionId(this.getPSSysUIActionId());
                PSSysUIActionService pSSysUIActionService = (PSSysUIActionService)ServiceGlobal.getService(PSSysUIActionService.class, (SessionFactory)this.getSessionFactory());
                pSSysUIActionService.autoGet(pSSysUIAction);
                this.pssysuiaction = pSSysUIAction;
            }
            return this.pssysuiaction;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysUIAction getRepPSSysUIAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRepPSSysUIAction();
        }
        if (this.getRepPSSysUIActionId() == null) {
            return null;
        }
        Integer n = this.objRepPSSysUIActionLock;
        synchronized (n) {
            if (this.reppssysuiaction != null && DataTypeHelper.compare((int)25, (Object)this.getRepPSSysUIActionId(), (Object)this.reppssysuiaction.getPSSysUIActionId()) != 0L) {
                this.reppssysuiaction = null;
            }
            if (this.reppssysuiaction == null) {
                PSSysUIAction pSSysUIAction = new PSSysUIAction();
                pSSysUIAction.setPSSysUIActionId(this.getRepPSSysUIActionId());
                PSSysUIActionService pSSysUIActionService = (PSSysUIActionService)ServiceGlobal.getService(PSSysUIActionService.class, (SessionFactory)this.getSessionFactory());
                pSSysUIActionService.autoGet(pSSysUIAction);
                this.reppssysuiaction = pSSysUIAction;
            }
            return this.reppssysuiaction;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysViewLogic getPSSysViewLogic() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewLogic();
        }
        if (this.getPSSysViewLogicId() == null) {
            return null;
        }
        Integer n = this.objPSSysViewLogicLock;
        synchronized (n) {
            if (this.pssysviewlogic != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysViewLogicId(), (Object)this.pssysviewlogic.getPSSysViewLogicId()) != 0L) {
                this.pssysviewlogic = null;
            }
            if (this.pssysviewlogic == null) {
                PSSysViewLogic pSSysViewLogic = new PSSysViewLogic();
                pSSysViewLogic.setPSSysViewLogicId(this.getPSSysViewLogicId());
                PSSysViewLogicService pSSysViewLogicService = (PSSysViewLogicService)ServiceGlobal.getService(PSSysViewLogicService.class, (SessionFactory)this.getSessionFactory());
                pSSysViewLogicService.autoGet(pSSysViewLogic);
                this.pssysviewlogic = pSSysViewLogic;
            }
            return this.pssysviewlogic;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSWFLink getPSWFLink() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFLink();
        }
        if (this.getPSWFLinkId() == null) {
            return null;
        }
        Integer n = this.objPSWFLinkLock;
        synchronized (n) {
            if (this.pswflink != null && DataTypeHelper.compare((int)25, (Object)this.getPSWFLinkId(), (Object)this.pswflink.getPSWFLinkId()) != 0L) {
                this.pswflink = null;
            }
            if (this.pswflink == null) {
                PSWFLink pSWFLink = new PSWFLink();
                pSWFLink.setPSWFLinkId(this.getPSWFLinkId());
                PSWFLinkService pSWFLinkService = (PSWFLinkService)ServiceGlobal.getService(PSWFLinkService.class, (SessionFactory)this.getSessionFactory());
                pSWFLinkService.autoGet(pSWFLink);
                this.pswflink = pSWFLink;
            }
            return this.pswflink;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSWFProcess getPSWFProcess() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFProcess();
        }
        if (this.getPSWFProcessId() == null) {
            return null;
        }
        Integer n = this.objPSWFProcessLock;
        synchronized (n) {
            if (this.pswfprocess != null && DataTypeHelper.compare((int)25, (Object)this.getPSWFProcessId(), (Object)this.pswfprocess.getPSWFProcessId()) != 0L) {
                this.pswfprocess = null;
            }
            if (this.pswfprocess == null) {
                PSWFProcess pSWFProcess = new PSWFProcess();
                pSWFProcess.setPSWFProcessId(this.getPSWFProcessId());
                PSWFProcessService pSWFProcessService = (PSWFProcessService)ServiceGlobal.getService(PSWFProcessService.class, (SessionFactory)this.getSessionFactory());
                pSWFProcessService.autoGet(pSWFProcess);
                this.pswfprocess = pSWFProcess;
            }
            return this.pswfprocess;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSWFVersion getPSWFVersion() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFVersion();
        }
        if (this.getPSWFVersionId() == null) {
            return null;
        }
        Integer n = this.objPSWFVersionLock;
        synchronized (n) {
            if (this.pswfversion != null && DataTypeHelper.compare((int)25, (Object)this.getPSWFVersionId(), (Object)this.pswfversion.getPSWFVersionId()) != 0L) {
                this.pswfversion = null;
            }
            if (this.pswfversion == null) {
                PSWFVersion pSWFVersion = new PSWFVersion();
                pSWFVersion.setPSWFVersionId(this.getPSWFVersionId());
                PSWFVersionService pSWFVersionService = (PSWFVersionService)ServiceGlobal.getService(PSWFVersionService.class, (SessionFactory)this.getSessionFactory());
                pSWFVersionService.autoGet(pSWFVersion);
                this.pswfversion = pSWFVersion;
            }
            return this.pswfversion;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSWorkflow getPSWF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWF();
        }
        if (this.getPSWFId() == null) {
            return null;
        }
        Integer n = this.objPSWFLock;
        synchronized (n) {
            if (this.pswf != null && DataTypeHelper.compare((int)25, (Object)this.getPSWFId(), (Object)this.pswf.getPSWorkflowId()) != 0L) {
                this.pswf = null;
            }
            if (this.pswf == null) {
                PSWorkflow pSWorkflow = new PSWorkflow();
                pSWorkflow.setPSWorkflowId(this.getPSWFId());
                PSWorkflowService pSWorkflowService = (PSWorkflowService)ServiceGlobal.getService(PSWorkflowService.class, (SessionFactory)this.getSessionFactory());
                pSWorkflowService.autoGet(pSWorkflow);
                this.pswf = pSWorkflow;
            }
            return this.pswf;
        }
    }

    private PSDEUIActionBase getProxyEntity() {
        return this.proxyPSDEUIActionBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEUIActionBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEUIActionBase) {
            this.proxyPSDEUIActionBase = (PSDEUIActionBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ACTIONLEVEL, 0);
        fieldIndexMap.put(FIELD_ACTIONTARGET, 1);
        fieldIndexMap.put(FIELD_BUSYINDICATOR, 2);
        fieldIndexMap.put(FIELD_BUTTONSTYLE, 3);
        fieldIndexMap.put(FIELD_CAPPSLANRESID, 4);
        fieldIndexMap.put(FIELD_CAPPSLANRESNAME, 5);
        fieldIndexMap.put(FIELD_CAPTION, 6);
        fieldIndexMap.put(FIELD_CLOSEEDITVIEW, 7);
        fieldIndexMap.put(FIELD_CMPSLANRESID, 8);
        fieldIndexMap.put(FIELD_CMPSLANRESNAME, 9);
        fieldIndexMap.put(FIELD_CODENAME, 10);
        fieldIndexMap.put(FIELD_CONFIRMINFO, 11);
        fieldIndexMap.put(FIELD_COUNTERID, 12);
        fieldIndexMap.put(FIELD_CREATEDATE, 13);
        fieldIndexMap.put(FIELD_CREATEMAN, 14);
        fieldIndexMap.put(FIELD_CUSTOMCODE, 15);
        fieldIndexMap.put(FIELD_DATAITEM, 16);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 17);
        fieldIndexMap.put(FIELD_ENABLELOGIC, 18);
        fieldIndexMap.put(FIELD_ENABLERTMODEL, 19);
        fieldIndexMap.put(FIELD_ENABLEVIEWACTIONS, 20);
        fieldIndexMap.put(FIELD_EXTENDMODE, 21);
        fieldIndexMap.put(FIELD_FRONTPROTYPE, 22);
        fieldIndexMap.put(FIELD_GLOBALFLAG, 23);
        fieldIndexMap.put(FIELD_HTMLPAGEURL, 24);
        fieldIndexMap.put(FIELD_ITEMOBJ, 25);
        fieldIndexMap.put(FIELD_LOCKFLAG, 26);
        fieldIndexMap.put(FIELD_MEMO, 27);
        fieldIndexMap.put(FIELD_MOBPSDEVIEWID, 28);
        fieldIndexMap.put(FIELD_MOBPSDEVIEWNAME, 29);
        fieldIndexMap.put(FIELD_NEXTPSDEUIACTIONID, 30);
        fieldIndexMap.put(FIELD_NEXTPSDEUIACTIONNAME, 31);
        fieldIndexMap.put(FIELD_NO2PSDEDATAEXPID, 32);
        fieldIndexMap.put(FIELD_NO2PSDEDATAEXPNAME, 33);
        fieldIndexMap.put(FIELD_NOPRIVDM, 34);
        fieldIndexMap.put(FIELD_PARAMITEM, 35);
        fieldIndexMap.put(FIELD_PDTVIEWFLAG, 36);
        fieldIndexMap.put(FIELD_PSDEACMODEID, 37);
        fieldIndexMap.put(FIELD_PSDEACMODENAME, 38);
        fieldIndexMap.put(FIELD_PSDEACTIONID, 39);
        fieldIndexMap.put(FIELD_PSDEACTIONNAME, 40);
        fieldIndexMap.put(FIELD_PSDEDATAEXPID, 41);
        fieldIndexMap.put(FIELD_PSDEDATAIMPID, 42);
        fieldIndexMap.put(FIELD_PSDEDATAIMPNAME, 43);
        fieldIndexMap.put(FIELD_PSDEFGROUPID, 44);
        fieldIndexMap.put(FIELD_PSDEFGROUPNAME, 45);
        fieldIndexMap.put(FIELD_PSDEFORMID, 46);
        fieldIndexMap.put(FIELD_PSDEFORMNAME, 47);
        fieldIndexMap.put(FIELD_PSDEID, 48);
        fieldIndexMap.put(FIELD_PSDENAME, 49);
        fieldIndexMap.put(FIELD_PSDEOPPRIVID, 50);
        fieldIndexMap.put(FIELD_PSDEOPPRIVNAME, 51);
        fieldIndexMap.put(FIELD_PSDEPRINTID, 52);
        fieldIndexMap.put(FIELD_PSDEPRINTNAME, 53);
        fieldIndexMap.put(FIELD_PSDEUIACTIONID, 54);
        fieldIndexMap.put(FIELD_PSDEUIACTIONNAME, 55);
        fieldIndexMap.put(FIELD_PSDEVIEWBASEID, 56);
        fieldIndexMap.put(FIELD_PSDEVIEWBASENAME, 57);
        fieldIndexMap.put(FIELD_PSDEVIEWLOGICID, 58);
        fieldIndexMap.put(FIELD_PSDEVIEWLOGICNAME, 59);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 60);
        fieldIndexMap.put(FIELD_PSMODULEID, 61);
        fieldIndexMap.put(FIELD_PSMODULENAME, 62);
        fieldIndexMap.put(FIELD_PSSYSCOUNTERID, 63);
        fieldIndexMap.put(FIELD_PSSYSCOUNTERNAME, 64);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 65);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 66);
        fieldIndexMap.put(FIELD_PSSYSIMAGEID, 67);
        fieldIndexMap.put(FIELD_PSSYSIMAGENAME, 68);
        fieldIndexMap.put(FIELD_PSSYSPDTVIEWID, 69);
        fieldIndexMap.put(FIELD_PSSYSPDTVIEWNAME, 70);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINID, 71);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINNAME, 72);
        fieldIndexMap.put(FIELD_PSSYSREQITEMID, 73);
        fieldIndexMap.put(FIELD_PSSYSREQITEMNAME, 74);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 75);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 76);
        fieldIndexMap.put(FIELD_PSSYSUIACTIONID, 77);
        fieldIndexMap.put(FIELD_PSSYSUIACTIONNAME, 78);
        fieldIndexMap.put(FIELD_PSSYSVIEWLOGICID, 79);
        fieldIndexMap.put(FIELD_PSSYSVIEWLOGICNAME, 80);
        fieldIndexMap.put(FIELD_PSWFID, 81);
        fieldIndexMap.put(FIELD_PSWFNAME, 82);
        fieldIndexMap.put(FIELD_PSWFLINKID, 83);
        fieldIndexMap.put(FIELD_PSWFLINKNAME, 84);
        fieldIndexMap.put(FIELD_PSWFPROCESSID, 85);
        fieldIndexMap.put(FIELD_PSWFPROCESSNAME, 86);
        fieldIndexMap.put(FIELD_PSWFVERSIONID, 87);
        fieldIndexMap.put(FIELD_PSWFVERSIONNAME, 88);
        fieldIndexMap.put(FIELD_RELOADDATA, 89);
        fieldIndexMap.put(FIELD_REPPSSYSUIACTIONID, 90);
        fieldIndexMap.put(FIELD_REPPSSYSUIACTIONNAME, 91);
        fieldIndexMap.put(FIELD_SMPSLANRESID, 92);
        fieldIndexMap.put(FIELD_SMPSLANRESNAME, 93);
        fieldIndexMap.put(FIELD_SUCCESSINFO, 94);
        fieldIndexMap.put(FIELD_SYSITEMOBJ, 95);
        fieldIndexMap.put(FIELD_TEMPLMODE, 96);
        fieldIndexMap.put(FIELD_TEXTITEM, 97);
        fieldIndexMap.put(FIELD_TIMEOUT, 98);
        fieldIndexMap.put(FIELD_TIPPSLANRESID, 99);
        fieldIndexMap.put(FIELD_TIPPSLANRESNAME, 100);
        fieldIndexMap.put(FIELD_TODOTASK, 101);
        fieldIndexMap.put(FIELD_TOOLTIPINFO, 102);
        fieldIndexMap.put(FIELD_UATAG, 103);
        fieldIndexMap.put(FIELD_UATAG2, 104);
        fieldIndexMap.put(FIELD_UATAG3, 105);
        fieldIndexMap.put(FIELD_UATAG4, 106);
        fieldIndexMap.put(FIELD_UIACTIONCODE, 107);
        fieldIndexMap.put(FIELD_UIACTIONPARAM, 108);
        fieldIndexMap.put(FIELD_UIACTIONPARAM10, 109);
        fieldIndexMap.put(FIELD_UIACTIONPARAM11, 110);
        fieldIndexMap.put(FIELD_UIACTIONPARAM12, 111);
        fieldIndexMap.put(FIELD_UIACTIONPARAM2, 112);
        fieldIndexMap.put(FIELD_UIACTIONPARAM3, 113);
        fieldIndexMap.put(FIELD_UIACTIONPARAM4, 114);
        fieldIndexMap.put(FIELD_UIACTIONPARAM5, 115);
        fieldIndexMap.put(FIELD_UIACTIONPARAM6, 116);
        fieldIndexMap.put(FIELD_UIACTIONPARAM7, 117);
        fieldIndexMap.put(FIELD_UIACTIONPARAM8, 118);
        fieldIndexMap.put(FIELD_UIACTIONPARAM9, 119);
        fieldIndexMap.put(FIELD_UIACTIONPARAMS, 120);
        fieldIndexMap.put(FIELD_UIACTIONTYPE, 121);
        fieldIndexMap.put(FIELD_UPDATEDATE, 122);
        fieldIndexMap.put(FIELD_UPDATEMAN, 123);
        fieldIndexMap.put(FIELD_USERCAT, 124);
        fieldIndexMap.put(FIELD_USERCONFIRM, 125);
        fieldIndexMap.put(FIELD_USERPARAMS, 126);
        fieldIndexMap.put(FIELD_USERTAG, 127);
        fieldIndexMap.put(FIELD_USERTAG2, 128);
        fieldIndexMap.put(FIELD_USERTAG3, 129);
        fieldIndexMap.put(FIELD_USERTAG4, 130);
        fieldIndexMap.put(FIELD_VIEWACTIONS, 131);
        fieldIndexMap.put(FIELD_VIEWLOGICTYPE, 132);
        fieldIndexMap.put(FIELD_VISIBLELOGIC, 133);
        fieldIndexMap.put(FIELD_VLEXECMODE, 134);
    }
}

