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
package net.ibizsys.pscore.srv.wfdesign.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEForm;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysMsgTempl;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMsgTemplService;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFDE;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFProcParam;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFProcRole;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFProcSubWF;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFVersion;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFWorkTime;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWorkflow;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFDEService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFProcParamService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFProcRoleService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFProcSubWFService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFProcessService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFVersionService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFWorkTimeService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWorkflowService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSWFProcessBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSWFProcessBase.class);
    public static final String FIELD_ASYNCMODE = "ASYNCMODE";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_EDITFIELDS = "EDITFIELDS";
    public static final String FIELD_EDITFLAG = "EDITFLAG";
    public static final String FIELD_EDITPSDEFGROUPID = "EDITPSDEFGROUPID";
    public static final String FIELD_EDITPSDEFGROUPNAME = "EDITPSDEFGROUPNAME";
    public static final String FIELD_EMBEDPSDEDSID = "EMBEDPSDEDSID";
    public static final String FIELD_EMBEDPSDEDSNAME = "EMBEDPSDEDSNAME";
    public static final String FIELD_EMBEDPSDEID = "EMBEDPSDEID";
    public static final String FIELD_EMBEDPSWFDEID = "EMBEDPSWFDEID";
    public static final String FIELD_EMBEDPSWFDENAME = "EMBEDPSWFDENAME";
    public static final String FIELD_EMBEDPSWFID = "EMBEDPSWFID";
    public static final String FIELD_EMBEDPSWFNAME = "EMBEDPSWFNAME";
    public static final String FIELD_ENABLE = "ENABLE";
    public static final String FIELD_ENABLEMOBILE = "ENABLEMOBILE";
    public static final String FIELD_ENABLETIMEOUT = "ENABLETIMEOUT";
    public static final String FIELD_EXITSTATENAME = "EXITSTATENAME";
    public static final String FIELD_EXITSTATEVALUE = "EXITSTATEVALUE";
    public static final String FIELD_FORMCODENAME = "FORMCODENAME";
    public static final String FIELD_HEIGHT = "HEIGHT";
    public static final String FIELD_ICONPATH = "ICONPATH";
    public static final String FIELD_LEFTPOS = "LEFTPOS";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MEMOFIELD = "MEMOFIELD";
    public static final String FIELD_MOBFORMCODENAME = "MOBFORMCODENAME";
    public static final String FIELD_MOBPSDEFORMID = "MOBPSDEFORMID";
    public static final String FIELD_MOBPSDEFORMNAME = "MOBPSDEFORMNAME";
    public static final String FIELD_MOBPSDEUAGROUPID = "MOBPSDEUAGROUPID";
    public static final String FIELD_MOBPSDEUAGROUPNAME = "MOBPSDEUAGROUPNAME";
    public static final String FIELD_MOBPSDEVIEWID = "MOBPSDEVIEWID";
    public static final String FIELD_MOBPSDEVIEWNAME = "MOBPSDEVIEWNAME";
    public static final String FIELD_MOBPSDYNADEVIEWTEMPLID = "MOBPSDYNADEVIEWTEMPLID";
    public static final String FIELD_MOBUAGROUPCODENAME = "MOBUAGROUPCODENAME";
    public static final String FIELD_MOBUTIL2FORMCODENAME = "MOBUTIL2FORMCODENAME";
    public static final String FIELD_MOBUTIL2PSDEFORMID = "MOBUTIL2PSDEFORMID";
    public static final String FIELD_MOBUTIL2PSDEFORMNAME = "MOBUTIL2PSDEFORMNAME";
    public static final String FIELD_MOBUTIL3FORMCODENAME = "MOBUTIL3FORMCODENAME";
    public static final String FIELD_MOBUTIL3PSDEFORMID = "MOBUTIL3PSDEFORMID";
    public static final String FIELD_MOBUTIL3PSDEFORMNAME = "MOBUTIL3PSDEFORMNAME";
    public static final String FIELD_MOBUTIL4FORMCODENAME = "MOBUTIL4FORMCODENAME";
    public static final String FIELD_MOBUTIL4PSDEFORMID = "MOBUTIL4PSDEFORMID";
    public static final String FIELD_MOBUTIL4PSDEFORMNAME = "MOBUTIL4PSDEFORMNAME";
    public static final String FIELD_MOBUTIL5FORMCODENAME = "MOBUTIL5FORMCODENAME";
    public static final String FIELD_MOBUTIL5PSDEFORMID = "MOBUTIL5PSDEFORMID";
    public static final String FIELD_MOBUTIL5PSDEFORMNAME = "MOBUTIL5PSDEFORMNAME";
    public static final String FIELD_MOBUTILFORMCODENAME = "MOBUTILFORMCODENAME";
    public static final String FIELD_MOBUTILPSDEFORMID = "MOBUTILPSDEFORMID";
    public static final String FIELD_MOBUTILPSDEFORMNAME = "MOBUTILPSDEFORMNAME";
    public static final String FIELD_MOBWFEDITVIEWTYPE = "MOBWFEDITVIEWTYPE";
    public static final String FIELD_MODELID = "MODELID";
    public static final String FIELD_MSGTYPE = "MSGTYPE";
    public static final String FIELD_MULTIINSTMODE = "MULTIINSTMODE";
    public static final String FIELD_NAMEPSLANRESID = "NAMEPSLANRESID";
    public static final String FIELD_NAMEPSLANRESNAME = "NAMEPSLANRESNAME";
    public static final String FIELD_NORMALPROCTYPE = "NORMALPROCTYPE";
    public static final String FIELD_PREDEFINEDACTIONS = "PREDEFINEDACTIONS";
    public static final String FIELD_PSDEACTIONID = "PSDEACTIONID";
    public static final String FIELD_PSDEACTIONNAME = "PSDEACTIONNAME";
    public static final String FIELD_PSDEFORMID = "PSDEFORMID";
    public static final String FIELD_PSDEFORMNAME = "PSDEFORMNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDEUAGROUPID = "PSDEUAGROUPID";
    public static final String FIELD_PSDEUAGROUPNAME = "PSDEUAGROUPNAME";
    public static final String FIELD_PSDEVIEWBASEID = "PSDEVIEWBASEID";
    public static final String FIELD_PSDEVIEWBASENAME = "PSDEVIEWBASENAME";
    public static final String FIELD_PSDYNADEVIEWTEMPLID = "PSDYNADEVIEWTEMPLID";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSSYSMSGTEMPLID = "PSSYSMSGTEMPLID";
    public static final String FIELD_PSSYSMSGTEMPLNAME = "PSSYSMSGTEMPLNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSWFDEID = "PSWFDEID";
    public static final String FIELD_PSWFDENAME = "PSWFDENAME";
    public static final String FIELD_PSWFID = "PSWFID";
    public static final String FIELD_PSWFNAME = "PSWFNAME";
    public static final String FIELD_PSWFPROCESSID = "PSWFPROCESSID";
    public static final String FIELD_PSWFPROCESSNAME = "PSWFPROCESSNAME";
    public static final String FIELD_PSWFVERSIONID = "PSWFVERSIONID";
    public static final String FIELD_PSWFVERSIONNAME = "PSWFVERSIONNAME";
    public static final String FIELD_PSWFWORKTIMEID = "PSWFWORKTIMEID";
    public static final String FIELD_PSWFWORKTIMENAME = "PSWFWORKTIMENAME";
    public static final String FIELD_REFPSWFVERSIONID = "REFPSWFVERSIONID";
    public static final String FIELD_REFPSWFVERSIONNAME = "REFPSWFVERSIONNAME";
    public static final String FIELD_SENDINFORM = "SENDINFORM";
    public static final String FIELD_SHAPEPARAMS = "SHAPEPARAMS";
    public static final String FIELD_THREADNAME = "THREADNAME";
    public static final String FIELD_THREADSN = "THREADSN";
    public static final String FIELD_TIMEOUT = "TIMEOUT";
    public static final String FIELD_TIMEOUTPSDEFID = "TIMEOUTPSDEFID";
    public static final String FIELD_TIMEOUTPSDEFNAME = "TIMEOUTPSDEFNAME";
    public static final String FIELD_TIMEOUTTYPE = "TIMEOUTTYPE";
    public static final String FIELD_TOPPOS = "TOPPOS";
    public static final String FIELD_UAGROUPCODENAME = "UAGROUPCODENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERDATA = "USERDATA";
    public static final String FIELD_USERDATA2 = "USERDATA2";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_UTIL2FORMCODENAME = "UTIL2FORMCODENAME";
    public static final String FIELD_UTIL2PSDEFORMID = "UTIL2PSDEFORMID";
    public static final String FIELD_UTIL2PSDEFORMNAME = "UTIL2PSDEFORMNAME";
    public static final String FIELD_UTIL3FORMCODENAME = "UTIL3FORMCODENAME";
    public static final String FIELD_UTIL3PSDEFORMID = "UTIL3PSDEFORMID";
    public static final String FIELD_UTIL3PSDEFORMNAME = "UTIL3PSDEFORMNAME";
    public static final String FIELD_UTIL4FORMCODENAME = "UTIL4FORMCODENAME";
    public static final String FIELD_UTIL4PSDEFORMID = "UTIL4PSDEFORMID";
    public static final String FIELD_UTIL4PSDEFORMNAME = "UTIL4PSDEFORMNAME";
    public static final String FIELD_UTIL5FORMCODENAME = "UTIL5FORMCODENAME";
    public static final String FIELD_UTIL5PSDEFORMID = "UTIL5PSDEFORMID";
    public static final String FIELD_UTIL5PSDEFORMNAME = "UTIL5PSDEFORMNAME";
    public static final String FIELD_UTILFORMCODENAME = "UTILFORMCODENAME";
    public static final String FIELD_UTILPSDEFORMID = "UTILPSDEFORMID";
    public static final String FIELD_UTILPSDEFORMNAME = "UTILPSDEFORMNAME";
    public static final String FIELD_WFEDITVIEWTYPE = "WFEDITVIEWTYPE";
    public static final String FIELD_WFENGINETYPE = "WFENGINETYPE";
    public static final String FIELD_WFPROCESSTYPE = "WFPROCESSTYPE";
    public static final String FIELD_WFSTEPNAME = "WFSTEPNAME";
    public static final String FIELD_WFSTEPVALUE = "WFSTEPVALUE";
    public static final String FIELD_WIDTH = "WIDTH";
    private static final int INDEX_ASYNCMODE = 0;
    private static final int INDEX_CODENAME = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_DYNAMODELFLAG = 4;
    private static final int INDEX_EDITFIELDS = 5;
    private static final int INDEX_EDITFLAG = 6;
    private static final int INDEX_EDITPSDEFGROUPID = 7;
    private static final int INDEX_EDITPSDEFGROUPNAME = 8;
    private static final int INDEX_EMBEDPSDEDSID = 9;
    private static final int INDEX_EMBEDPSDEDSNAME = 10;
    private static final int INDEX_EMBEDPSDEID = 11;
    private static final int INDEX_EMBEDPSWFDEID = 12;
    private static final int INDEX_EMBEDPSWFDENAME = 13;
    private static final int INDEX_EMBEDPSWFID = 14;
    private static final int INDEX_EMBEDPSWFNAME = 15;
    private static final int INDEX_ENABLE = 16;
    private static final int INDEX_ENABLEMOBILE = 17;
    private static final int INDEX_ENABLETIMEOUT = 18;
    private static final int INDEX_EXITSTATENAME = 19;
    private static final int INDEX_EXITSTATEVALUE = 20;
    private static final int INDEX_FORMCODENAME = 21;
    private static final int INDEX_HEIGHT = 22;
    private static final int INDEX_ICONPATH = 23;
    private static final int INDEX_LEFTPOS = 24;
    private static final int INDEX_MEMO = 25;
    private static final int INDEX_MEMOFIELD = 26;
    private static final int INDEX_MOBFORMCODENAME = 27;
    private static final int INDEX_MOBPSDEFORMID = 28;
    private static final int INDEX_MOBPSDEFORMNAME = 29;
    private static final int INDEX_MOBPSDEUAGROUPID = 30;
    private static final int INDEX_MOBPSDEUAGROUPNAME = 31;
    private static final int INDEX_MOBPSDEVIEWID = 32;
    private static final int INDEX_MOBPSDEVIEWNAME = 33;
    private static final int INDEX_MOBPSDYNADEVIEWTEMPLID = 34;
    private static final int INDEX_MOBUAGROUPCODENAME = 35;
    private static final int INDEX_MOBUTIL2FORMCODENAME = 36;
    private static final int INDEX_MOBUTIL2PSDEFORMID = 37;
    private static final int INDEX_MOBUTIL2PSDEFORMNAME = 38;
    private static final int INDEX_MOBUTIL3FORMCODENAME = 39;
    private static final int INDEX_MOBUTIL3PSDEFORMID = 40;
    private static final int INDEX_MOBUTIL3PSDEFORMNAME = 41;
    private static final int INDEX_MOBUTIL4FORMCODENAME = 42;
    private static final int INDEX_MOBUTIL4PSDEFORMID = 43;
    private static final int INDEX_MOBUTIL4PSDEFORMNAME = 44;
    private static final int INDEX_MOBUTIL5FORMCODENAME = 45;
    private static final int INDEX_MOBUTIL5PSDEFORMID = 46;
    private static final int INDEX_MOBUTIL5PSDEFORMNAME = 47;
    private static final int INDEX_MOBUTILFORMCODENAME = 48;
    private static final int INDEX_MOBUTILPSDEFORMID = 49;
    private static final int INDEX_MOBUTILPSDEFORMNAME = 50;
    private static final int INDEX_MOBWFEDITVIEWTYPE = 51;
    private static final int INDEX_MODELID = 52;
    private static final int INDEX_MSGTYPE = 53;
    private static final int INDEX_MULTIINSTMODE = 54;
    private static final int INDEX_NAMEPSLANRESID = 55;
    private static final int INDEX_NAMEPSLANRESNAME = 56;
    private static final int INDEX_NORMALPROCTYPE = 57;
    private static final int INDEX_PREDEFINEDACTIONS = 58;
    private static final int INDEX_PSDEACTIONID = 59;
    private static final int INDEX_PSDEACTIONNAME = 60;
    private static final int INDEX_PSDEFORMID = 61;
    private static final int INDEX_PSDEFORMNAME = 62;
    private static final int INDEX_PSDEID = 63;
    private static final int INDEX_PSDEUAGROUPID = 64;
    private static final int INDEX_PSDEUAGROUPNAME = 65;
    private static final int INDEX_PSDEVIEWBASEID = 66;
    private static final int INDEX_PSDEVIEWBASENAME = 67;
    private static final int INDEX_PSDYNADEVIEWTEMPLID = 68;
    private static final int INDEX_PSDYNAINSTID = 69;
    private static final int INDEX_PSSYSMSGTEMPLID = 70;
    private static final int INDEX_PSSYSMSGTEMPLNAME = 71;
    private static final int INDEX_PSSYSTEMID = 72;
    private static final int INDEX_PSWFDEID = 73;
    private static final int INDEX_PSWFDENAME = 74;
    private static final int INDEX_PSWFID = 75;
    private static final int INDEX_PSWFNAME = 76;
    private static final int INDEX_PSWFPROCESSID = 77;
    private static final int INDEX_PSWFPROCESSNAME = 78;
    private static final int INDEX_PSWFVERSIONID = 79;
    private static final int INDEX_PSWFVERSIONNAME = 80;
    private static final int INDEX_PSWFWORKTIMEID = 81;
    private static final int INDEX_PSWFWORKTIMENAME = 82;
    private static final int INDEX_REFPSWFVERSIONID = 83;
    private static final int INDEX_REFPSWFVERSIONNAME = 84;
    private static final int INDEX_SENDINFORM = 85;
    private static final int INDEX_SHAPEPARAMS = 86;
    private static final int INDEX_THREADNAME = 87;
    private static final int INDEX_THREADSN = 88;
    private static final int INDEX_TIMEOUT = 89;
    private static final int INDEX_TIMEOUTPSDEFID = 90;
    private static final int INDEX_TIMEOUTPSDEFNAME = 91;
    private static final int INDEX_TIMEOUTTYPE = 92;
    private static final int INDEX_TOPPOS = 93;
    private static final int INDEX_UAGROUPCODENAME = 94;
    private static final int INDEX_UPDATEDATE = 95;
    private static final int INDEX_UPDATEMAN = 96;
    private static final int INDEX_USERCAT = 97;
    private static final int INDEX_USERDATA = 98;
    private static final int INDEX_USERDATA2 = 99;
    private static final int INDEX_USERTAG = 100;
    private static final int INDEX_USERTAG2 = 101;
    private static final int INDEX_USERTAG3 = 102;
    private static final int INDEX_USERTAG4 = 103;
    private static final int INDEX_UTIL2FORMCODENAME = 104;
    private static final int INDEX_UTIL2PSDEFORMID = 105;
    private static final int INDEX_UTIL2PSDEFORMNAME = 106;
    private static final int INDEX_UTIL3FORMCODENAME = 107;
    private static final int INDEX_UTIL3PSDEFORMID = 108;
    private static final int INDEX_UTIL3PSDEFORMNAME = 109;
    private static final int INDEX_UTIL4FORMCODENAME = 110;
    private static final int INDEX_UTIL4PSDEFORMID = 111;
    private static final int INDEX_UTIL4PSDEFORMNAME = 112;
    private static final int INDEX_UTIL5FORMCODENAME = 113;
    private static final int INDEX_UTIL5PSDEFORMID = 114;
    private static final int INDEX_UTIL5PSDEFORMNAME = 115;
    private static final int INDEX_UTILFORMCODENAME = 116;
    private static final int INDEX_UTILPSDEFORMID = 117;
    private static final int INDEX_UTILPSDEFORMNAME = 118;
    private static final int INDEX_WFEDITVIEWTYPE = 119;
    private static final int INDEX_WFENGINETYPE = 120;
    private static final int INDEX_WFPROCESSTYPE = 121;
    private static final int INDEX_WFSTEPNAME = 122;
    private static final int INDEX_WFSTEPVALUE = 123;
    private static final int INDEX_WIDTH = 124;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSWFProcessBase proxyPSWFProcessBase = null;
    private boolean asyncmodeDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean editfieldsDirtyFlag = false;
    private boolean editflagDirtyFlag = false;
    private boolean editpsdefgroupidDirtyFlag = false;
    private boolean editpsdefgroupnameDirtyFlag = false;
    private boolean embedpsdedsidDirtyFlag = false;
    private boolean embedpsdedsnameDirtyFlag = false;
    private boolean embedpsdeidDirtyFlag = false;
    private boolean embedpswfdeidDirtyFlag = false;
    private boolean embedpswfdenameDirtyFlag = false;
    private boolean embedpswfidDirtyFlag = false;
    private boolean embedpswfnameDirtyFlag = false;
    private boolean enableDirtyFlag = false;
    private boolean enablemobileDirtyFlag = false;
    private boolean enabletimeoutDirtyFlag = false;
    private boolean exitstatenameDirtyFlag = false;
    private boolean exitstatevalueDirtyFlag = false;
    private boolean formcodenameDirtyFlag = false;
    private boolean heightDirtyFlag = false;
    private boolean iconpathDirtyFlag = false;
    private boolean leftposDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean memofieldDirtyFlag = false;
    private boolean mobformcodenameDirtyFlag = false;
    private boolean mobpsdeformidDirtyFlag = false;
    private boolean mobpsdeformnameDirtyFlag = false;
    private boolean mobpsdeuagroupidDirtyFlag = false;
    private boolean mobpsdeuagroupnameDirtyFlag = false;
    private boolean mobpsdeviewidDirtyFlag = false;
    private boolean mobpsdeviewnameDirtyFlag = false;
    private boolean mobpsdynadeviewtemplidDirtyFlag = false;
    private boolean mobuagroupcodenameDirtyFlag = false;
    private boolean mobutil2formcodenameDirtyFlag = false;
    private boolean mobutil2psdeformidDirtyFlag = false;
    private boolean mobutil2psdeformnameDirtyFlag = false;
    private boolean mobutil3formcodenameDirtyFlag = false;
    private boolean mobutil3psdeformidDirtyFlag = false;
    private boolean mobutil3psdeformnameDirtyFlag = false;
    private boolean mobutil4formcodenameDirtyFlag = false;
    private boolean mobutil4psdeformidDirtyFlag = false;
    private boolean mobutil4psdeformnameDirtyFlag = false;
    private boolean mobutil5formcodenameDirtyFlag = false;
    private boolean mobutil5psdeformidDirtyFlag = false;
    private boolean mobutil5psdeformnameDirtyFlag = false;
    private boolean mobutilformcodenameDirtyFlag = false;
    private boolean mobutilpsdeformidDirtyFlag = false;
    private boolean mobutilpsdeformnameDirtyFlag = false;
    private boolean mobwfeditviewtypeDirtyFlag = false;
    private boolean modelidDirtyFlag = false;
    private boolean msgtypeDirtyFlag = false;
    private boolean multiinstmodeDirtyFlag = false;
    private boolean namepslanresidDirtyFlag = false;
    private boolean namepslanresnameDirtyFlag = false;
    private boolean normalproctypeDirtyFlag = false;
    private boolean predefinedactionsDirtyFlag = false;
    private boolean psdeactionidDirtyFlag = false;
    private boolean psdeactionnameDirtyFlag = false;
    private boolean psdeformidDirtyFlag = false;
    private boolean psdeformnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdeuagroupidDirtyFlag = false;
    private boolean psdeuagroupnameDirtyFlag = false;
    private boolean psdeviewbaseidDirtyFlag = false;
    private boolean psdeviewbasenameDirtyFlag = false;
    private boolean psdynadeviewtemplidDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean pssysmsgtemplidDirtyFlag = false;
    private boolean pssysmsgtemplnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pswfdeidDirtyFlag = false;
    private boolean pswfdenameDirtyFlag = false;
    private boolean pswfidDirtyFlag = false;
    private boolean pswfnameDirtyFlag = false;
    private boolean pswfprocessidDirtyFlag = false;
    private boolean pswfprocessnameDirtyFlag = false;
    private boolean pswfversionidDirtyFlag = false;
    private boolean pswfversionnameDirtyFlag = false;
    private boolean pswfworktimeidDirtyFlag = false;
    private boolean pswfworktimenameDirtyFlag = false;
    private boolean refpswfversionidDirtyFlag = false;
    private boolean refpswfversionnameDirtyFlag = false;
    private boolean sendinformDirtyFlag = false;
    private boolean shapeparamsDirtyFlag = false;
    private boolean threadnameDirtyFlag = false;
    private boolean threadsnDirtyFlag = false;
    private boolean timeoutDirtyFlag = false;
    private boolean timeoutpsdefidDirtyFlag = false;
    private boolean timeoutpsdefnameDirtyFlag = false;
    private boolean timeouttypeDirtyFlag = false;
    private boolean topposDirtyFlag = false;
    private boolean uagroupcodenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean userdataDirtyFlag = false;
    private boolean userdata2DirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean util2formcodenameDirtyFlag = false;
    private boolean util2psdeformidDirtyFlag = false;
    private boolean util2psdeformnameDirtyFlag = false;
    private boolean util3formcodenameDirtyFlag = false;
    private boolean util3psdeformidDirtyFlag = false;
    private boolean util3psdeformnameDirtyFlag = false;
    private boolean util4formcodenameDirtyFlag = false;
    private boolean util4psdeformidDirtyFlag = false;
    private boolean util4psdeformnameDirtyFlag = false;
    private boolean util5formcodenameDirtyFlag = false;
    private boolean util5psdeformidDirtyFlag = false;
    private boolean util5psdeformnameDirtyFlag = false;
    private boolean utilformcodenameDirtyFlag = false;
    private boolean utilpsdeformidDirtyFlag = false;
    private boolean utilpsdeformnameDirtyFlag = false;
    private boolean wfeditviewtypeDirtyFlag = false;
    private boolean wfenginetypeDirtyFlag = false;
    private boolean wfprocesstypeDirtyFlag = false;
    private boolean wfstepnameDirtyFlag = false;
    private boolean wfstepvalueDirtyFlag = false;
    private boolean widthDirtyFlag = false;
    @Column(name="asyncmode")
    private Integer asyncmode;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="editfields")
    private String editfields;
    @Column(name="editflag")
    private Integer editflag;
    @Column(name="editpsdefgroupid")
    private String editpsdefgroupid;
    @Column(name="editpsdefgroupname")
    private String editpsdefgroupname;
    @Column(name="embedpsdedsid")
    private String embedpsdedsid;
    @Column(name="embedpsdedsname")
    private String embedpsdedsname;
    @Column(name="embedpsdeid")
    private String embedpsdeid;
    @Column(name="embedpswfdeid")
    private String embedpswfdeid;
    @Column(name="embedpswfdename")
    private String embedpswfdename;
    @Column(name="embedpswfid")
    private String embedpswfid;
    @Column(name="embedpswfname")
    private String embedpswfname;
    @Column(name="enable")
    private Integer enable;
    @Column(name="enablemobile")
    private Integer enablemobile;
    @Column(name="enabletimeout")
    private Integer enabletimeout;
    @Column(name="exitstatename")
    private String exitstatename;
    @Column(name="exitstatevalue")
    private String exitstatevalue;
    @Column(name="formcodename")
    private String formcodename;
    @Column(name="height")
    private Integer height;
    @Column(name="iconpath")
    private String iconpath;
    @Column(name="leftpos")
    private Integer leftpos;
    @Column(name="memo")
    private String memo;
    @Column(name="memofield")
    private String memofield;
    @Column(name="mobformcodename")
    private String mobformcodename;
    @Column(name="mobpsdeformid")
    private String mobpsdeformid;
    @Column(name="mobpsdeformname")
    private String mobpsdeformname;
    @Column(name="mobpsdeuagroupid")
    private String mobpsdeuagroupid;
    @Column(name="mobpsdeuagroupname")
    private String mobpsdeuagroupname;
    @Column(name="mobpsdeviewid")
    private String mobpsdeviewid;
    @Column(name="mobpsdeviewname")
    private String mobpsdeviewname;
    @Column(name="mobpsdynadeviewtemplid")
    private String mobpsdynadeviewtemplid;
    @Column(name="mobuagroupcodename")
    private String mobuagroupcodename;
    @Column(name="mobutil2formcodename")
    private String mobutil2formcodename;
    @Column(name="mobutil2psdeformid")
    private String mobutil2psdeformid;
    @Column(name="mobutil2psdeformname")
    private String mobutil2psdeformname;
    @Column(name="mobutil3formcodename")
    private String mobutil3formcodename;
    @Column(name="mobutil3psdeformid")
    private String mobutil3psdeformid;
    @Column(name="mobutil3psdeformname")
    private String mobutil3psdeformname;
    @Column(name="mobutil4formcodename")
    private String mobutil4formcodename;
    @Column(name="mobutil4psdeformid")
    private String mobutil4psdeformid;
    @Column(name="mobutil4psdeformname")
    private String mobutil4psdeformname;
    @Column(name="mobutil5formcodename")
    private String mobutil5formcodename;
    @Column(name="mobutil5psdeformid")
    private String mobutil5psdeformid;
    @Column(name="mobutil5psdeformname")
    private String mobutil5psdeformname;
    @Column(name="mobutilformcodename")
    private String mobutilformcodename;
    @Column(name="mobutilpsdeformid")
    private String mobutilpsdeformid;
    @Column(name="mobutilpsdeformname")
    private String mobutilpsdeformname;
    @Column(name="mobwfeditviewtype")
    private String mobwfeditviewtype;
    @Column(name="modelid")
    private String modelid;
    @Column(name="msgtype")
    private Integer msgtype;
    @Column(name="multiinstmode")
    private String multiinstmode;
    @Column(name="namepslanresid")
    private String namepslanresid;
    @Column(name="namepslanresname")
    private String namepslanresname;
    @Column(name="normalproctype")
    private String normalproctype;
    @Column(name="predefinedactions")
    private String predefinedactions;
    @Column(name="psdeactionid")
    private String psdeactionid;
    @Column(name="psdeactionname")
    private String psdeactionname;
    @Column(name="psdeformid")
    private String psdeformid;
    @Column(name="psdeformname")
    private String psdeformname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdeuagroupid")
    private String psdeuagroupid;
    @Column(name="psdeuagroupname")
    private String psdeuagroupname;
    @Column(name="psdeviewbaseid")
    private String psdeviewbaseid;
    @Column(name="psdeviewbasename")
    private String psdeviewbasename;
    @Column(name="psdynadeviewtemplid")
    private String psdynadeviewtemplid;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="pssysmsgtemplid")
    private String pssysmsgtemplid;
    @Column(name="pssysmsgtemplname")
    private String pssysmsgtemplname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pswfdeid")
    private String pswfdeid;
    @Column(name="pswfdename")
    private String pswfdename;
    @Column(name="pswfid")
    private String pswfid;
    @Column(name="pswfname")
    private String pswfname;
    @Column(name="pswfprocessid")
    private String pswfprocessid;
    @Column(name="pswfprocessname")
    private String pswfprocessname;
    @Column(name="pswfversionid")
    private String pswfversionid;
    @Column(name="pswfversionname")
    private String pswfversionname;
    @Column(name="pswfworktimeid")
    private String pswfworktimeid;
    @Column(name="pswfworktimename")
    private String pswfworktimename;
    @Column(name="refpswfversionid")
    private String refpswfversionid;
    @Column(name="refpswfversionname")
    private String refpswfversionname;
    @Column(name="sendinform")
    private Integer sendinform;
    @Column(name="shapeparams")
    private String shapeparams;
    @Column(name="threadname")
    private String threadname;
    @Column(name="threadsn")
    private Integer threadsn;
    @Column(name="timeout")
    private Integer timeout;
    @Column(name="timeoutpsdefid")
    private String timeoutpsdefid;
    @Column(name="timeoutpsdefname")
    private String timeoutpsdefname;
    @Column(name="timeouttype")
    private String timeouttype;
    @Column(name="toppos")
    private Integer toppos;
    @Column(name="uagroupcodename")
    private String uagroupcodename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usercat")
    private String usercat;
    @Column(name="userdata")
    private String userdata;
    @Column(name="userdata2")
    private String userdata2;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="usertag3")
    private String usertag3;
    @Column(name="usertag4")
    private String usertag4;
    @Column(name="util2formcodename")
    private String util2formcodename;
    @Column(name="util2psdeformid")
    private String util2psdeformid;
    @Column(name="util2psdeformname")
    private String util2psdeformname;
    @Column(name="util3formcodename")
    private String util3formcodename;
    @Column(name="util3psdeformid")
    private String util3psdeformid;
    @Column(name="util3psdeformname")
    private String util3psdeformname;
    @Column(name="util4formcodename")
    private String util4formcodename;
    @Column(name="util4psdeformid")
    private String util4psdeformid;
    @Column(name="util4psdeformname")
    private String util4psdeformname;
    @Column(name="util5formcodename")
    private String util5formcodename;
    @Column(name="util5psdeformid")
    private String util5psdeformid;
    @Column(name="util5psdeformname")
    private String util5psdeformname;
    @Column(name="utilformcodename")
    private String utilformcodename;
    @Column(name="utilpsdeformid")
    private String utilpsdeformid;
    @Column(name="utilpsdeformname")
    private String utilpsdeformname;
    @Column(name="wfeditviewtype")
    private String wfeditviewtype;
    @Column(name="wfenginetype")
    private String wfenginetype;
    @Column(name="wfprocesstype")
    private String wfprocesstype;
    @Column(name="wfstepname")
    private String wfstepname;
    @Column(name="wfstepvalue")
    private String wfstepvalue;
    @Column(name="width")
    private Integer width;
    private Integer objPSDEActionLock = new Integer(1);
    private PSDEAction psdeaction = null;
    private Integer objEmbedPSDEDSLock = new Integer(1);
    private PSDEDataSet embedpsdeds = null;
    private Integer objEditPSDEFGroupLock = new Integer(1);
    private PSDEFGroup editpsdefgroup = null;
    private Integer objTimeoutPSDEFLock = new Integer(1);
    private PSDEField timeoutpsdef = null;
    private Integer objMobPSDEFormLock = new Integer(1);
    private PSDEForm mobpsdeform = null;
    private Integer objMobUtil2PSDEFormLock = new Integer(1);
    private PSDEForm mobutil2psdeform = null;
    private Integer objMobUtil3PSDEFormLock = new Integer(1);
    private PSDEForm mobutil3psdeform = null;
    private Integer objMobUtil4PSDEFormLock = new Integer(1);
    private PSDEForm mobutil4psdeform = null;
    private Integer objMobUtil5PSDEFormLock = new Integer(1);
    private PSDEForm mobutil5psdeform = null;
    private Integer objMobUtilPSDEFormLock = new Integer(1);
    private PSDEForm mobutilpsdeform = null;
    private Integer objPSDEFormLock = new Integer(1);
    private PSDEForm psdeform = null;
    private Integer objUtil2PSDEFormLock = new Integer(1);
    private PSDEForm util2psdeform = null;
    private Integer objUtil3PSDEFormLock = new Integer(1);
    private PSDEForm util3psdeform = null;
    private Integer objUtil4PSDEFormLock = new Integer(1);
    private PSDEForm util4psdeform = null;
    private Integer objUtil5PSDEFormLock = new Integer(1);
    private PSDEForm util5psdeform = null;
    private Integer objUtilPSDEFormLock = new Integer(1);
    private PSDEForm utilpsdeform = null;
    private Integer objMobPSDEUAGroupLock = new Integer(1);
    private PSDEUAGroup mobpsdeuagroup = null;
    private Integer objPSDEUAGroupLock = new Integer(1);
    private PSDEUAGroup psdeuagroup = null;
    private Integer objMobPSDEViewLock = new Integer(1);
    private PSDEViewBase mobpsdeview = null;
    private Integer objPSDEViewBaseLock = new Integer(1);
    private PSDEViewBase psdeviewbase = null;
    private Integer objNamePSLanResLock = new Integer(1);
    private PSLanguageRes namepslanres = null;
    private Integer objPSSysMsgTemplLock = new Integer(1);
    private PSSysMsgTempl pssysmsgtempl = null;
    private Integer objEmbedPSWFDELock = new Integer(1);
    private PSWFDE embedpswfde = null;
    private Integer objPSWFDELock = new Integer(1);
    private PSWFDE pswfde = null;
    private Integer objPSWFVersionLock = new Integer(1);
    private PSWFVersion pswfversion = null;
    private Integer objRefPSWFVersionLock = new Integer(1);
    private PSWFVersion refpswfversion = null;
    private Integer objPSWFWorktimeLock = new Integer(1);
    private PSWFWorkTime pswfworktime = null;
    private Integer objEmbedPSWFLock = new Integer(1);
    private PSWorkflow embedpswf = null;
    private Integer objPSWFLock = new Integer(1);
    private PSWorkflow pswf = null;
    private Integer objPSWFProcParamsLock = new Integer(1);
    private ArrayList<PSWFProcParam> pswfprocparams = null;
    private Integer objPSWFProcRolesLock = new Integer(1);
    private ArrayList<PSWFProcRole> pswfprocroles = null;
    private Integer objPSWFProcSubWFsLock = new Integer(1);
    private ArrayList<PSWFProcSubWF> pswfprocsubwfs = null;

    public void setAsyncMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAsyncMode(n);
            return;
        }
        this.asyncmode = n;
        this.asyncmodeDirtyFlag = true;
    }

    public Integer getAsyncMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAsyncMode();
        }
        return this.asyncmode;
    }

    public boolean isAsyncModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAsyncModeDirty();
        }
        return this.asyncmodeDirtyFlag;
    }

    public void resetAsyncMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAsyncMode();
            return;
        }
        this.asyncmodeDirtyFlag = false;
        this.asyncmode = null;
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

    public void setEditFields(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEditFields(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.editfields = string;
        this.editfieldsDirtyFlag = true;
    }

    public String getEditFields() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEditFields();
        }
        return this.editfields;
    }

    public boolean isEditFieldsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEditFieldsDirty();
        }
        return this.editfieldsDirtyFlag;
    }

    public void resetEditFields() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEditFields();
            return;
        }
        this.editfieldsDirtyFlag = false;
        this.editfields = null;
    }

    public void setEditFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEditFlag(n);
            return;
        }
        this.editflag = n;
        this.editflagDirtyFlag = true;
    }

    public Integer getEditFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEditFlag();
        }
        return this.editflag;
    }

    public boolean isEditFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEditFlagDirty();
        }
        return this.editflagDirtyFlag;
    }

    public void resetEditFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEditFlag();
            return;
        }
        this.editflagDirtyFlag = false;
        this.editflag = null;
    }

    public void setEditPSDEFGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEditPSDEFGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.editpsdefgroupid = string;
        this.editpsdefgroupidDirtyFlag = true;
    }

    public String getEditPSDEFGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEditPSDEFGroupId();
        }
        return this.editpsdefgroupid;
    }

    public boolean isEditPSDEFGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEditPSDEFGroupIdDirty();
        }
        return this.editpsdefgroupidDirtyFlag;
    }

    public void resetEditPSDEFGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEditPSDEFGroupId();
            return;
        }
        this.editpsdefgroupidDirtyFlag = false;
        this.editpsdefgroupid = null;
    }

    public void setEditPSDEFGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEditPSDEFGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.editpsdefgroupname = string;
        this.editpsdefgroupnameDirtyFlag = true;
    }

    public String getEditPSDEFGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEditPSDEFGroupName();
        }
        return this.editpsdefgroupname;
    }

    public boolean isEditPSDEFGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEditPSDEFGroupNameDirty();
        }
        return this.editpsdefgroupnameDirtyFlag;
    }

    public void resetEditPSDEFGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEditPSDEFGroupName();
            return;
        }
        this.editpsdefgroupnameDirtyFlag = false;
        this.editpsdefgroupname = null;
    }

    public void setEmbedPSDEDSId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEmbedPSDEDSId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.embedpsdedsid = string;
        this.embedpsdedsidDirtyFlag = true;
    }

    public String getEmbedPSDEDSId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEmbedPSDEDSId();
        }
        return this.embedpsdedsid;
    }

    public boolean isEmbedPSDEDSIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEmbedPSDEDSIdDirty();
        }
        return this.embedpsdedsidDirtyFlag;
    }

    public void resetEmbedPSDEDSId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEmbedPSDEDSId();
            return;
        }
        this.embedpsdedsidDirtyFlag = false;
        this.embedpsdedsid = null;
    }

    public void setEmbedPSDEDSName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEmbedPSDEDSName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.embedpsdedsname = string;
        this.embedpsdedsnameDirtyFlag = true;
    }

    public String getEmbedPSDEDSName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEmbedPSDEDSName();
        }
        return this.embedpsdedsname;
    }

    public boolean isEmbedPSDEDSNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEmbedPSDEDSNameDirty();
        }
        return this.embedpsdedsnameDirtyFlag;
    }

    public void resetEmbedPSDEDSName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEmbedPSDEDSName();
            return;
        }
        this.embedpsdedsnameDirtyFlag = false;
        this.embedpsdedsname = null;
    }

    public void setEmbedPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEmbedPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.embedpsdeid = string;
        this.embedpsdeidDirtyFlag = true;
    }

    public String getEmbedPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEmbedPSDEId();
        }
        return this.embedpsdeid;
    }

    public boolean isEmbedPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEmbedPSDEIdDirty();
        }
        return this.embedpsdeidDirtyFlag;
    }

    public void resetEmbedPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEmbedPSDEId();
            return;
        }
        this.embedpsdeidDirtyFlag = false;
        this.embedpsdeid = null;
    }

    public void setEmbedPSWFDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEmbedPSWFDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.embedpswfdeid = string;
        this.embedpswfdeidDirtyFlag = true;
    }

    public String getEmbedPSWFDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEmbedPSWFDEId();
        }
        return this.embedpswfdeid;
    }

    public boolean isEmbedPSWFDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEmbedPSWFDEIdDirty();
        }
        return this.embedpswfdeidDirtyFlag;
    }

    public void resetEmbedPSWFDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEmbedPSWFDEId();
            return;
        }
        this.embedpswfdeidDirtyFlag = false;
        this.embedpswfdeid = null;
    }

    public void setEmbedPSWFDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEmbedPSWFDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.embedpswfdename = string;
        this.embedpswfdenameDirtyFlag = true;
    }

    public String getEmbedPSWFDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEmbedPSWFDEName();
        }
        return this.embedpswfdename;
    }

    public boolean isEmbedPSWFDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEmbedPSWFDENameDirty();
        }
        return this.embedpswfdenameDirtyFlag;
    }

    public void resetEmbedPSWFDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEmbedPSWFDEName();
            return;
        }
        this.embedpswfdenameDirtyFlag = false;
        this.embedpswfdename = null;
    }

    public void setEmbedPSWFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEmbedPSWFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.embedpswfid = string;
        this.embedpswfidDirtyFlag = true;
    }

    public String getEmbedPSWFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEmbedPSWFId();
        }
        return this.embedpswfid;
    }

    public boolean isEmbedPSWFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEmbedPSWFIdDirty();
        }
        return this.embedpswfidDirtyFlag;
    }

    public void resetEmbedPSWFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEmbedPSWFId();
            return;
        }
        this.embedpswfidDirtyFlag = false;
        this.embedpswfid = null;
    }

    public void setEmbedPSWFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEmbedPSWFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.embedpswfname = string;
        this.embedpswfnameDirtyFlag = true;
    }

    public String getEmbedPSWFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEmbedPSWFName();
        }
        return this.embedpswfname;
    }

    public boolean isEmbedPSWFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEmbedPSWFNameDirty();
        }
        return this.embedpswfnameDirtyFlag;
    }

    public void resetEmbedPSWFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEmbedPSWFName();
            return;
        }
        this.embedpswfnameDirtyFlag = false;
        this.embedpswfname = null;
    }

    public void setEnable(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnable(n);
            return;
        }
        this.enable = n;
        this.enableDirtyFlag = true;
    }

    public Integer getEnable() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnable();
        }
        return this.enable;
    }

    public boolean isEnableDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableDirty();
        }
        return this.enableDirtyFlag;
    }

    public void resetEnable() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnable();
            return;
        }
        this.enableDirtyFlag = false;
        this.enable = null;
    }

    public void setEnableMobile(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableMobile(n);
            return;
        }
        this.enablemobile = n;
        this.enablemobileDirtyFlag = true;
    }

    public Integer getEnableMobile() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableMobile();
        }
        return this.enablemobile;
    }

    public boolean isEnableMobileDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableMobileDirty();
        }
        return this.enablemobileDirtyFlag;
    }

    public void resetEnableMobile() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableMobile();
            return;
        }
        this.enablemobileDirtyFlag = false;
        this.enablemobile = null;
    }

    public void setEnableTimeout(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableTimeout(n);
            return;
        }
        this.enabletimeout = n;
        this.enabletimeoutDirtyFlag = true;
    }

    public Integer getEnableTimeout() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableTimeout();
        }
        return this.enabletimeout;
    }

    public boolean isEnableTimeoutDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableTimeoutDirty();
        }
        return this.enabletimeoutDirtyFlag;
    }

    public void resetEnableTimeout() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableTimeout();
            return;
        }
        this.enabletimeoutDirtyFlag = false;
        this.enabletimeout = null;
    }

    public void setExitStateName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExitStateName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.exitstatename = string;
        this.exitstatenameDirtyFlag = true;
    }

    public String getExitStateName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExitStateName();
        }
        return this.exitstatename;
    }

    public boolean isExitStateNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExitStateNameDirty();
        }
        return this.exitstatenameDirtyFlag;
    }

    public void resetExitStateName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExitStateName();
            return;
        }
        this.exitstatenameDirtyFlag = false;
        this.exitstatename = null;
    }

    public void setExitStateValue(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExitStateValue(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.exitstatevalue = string;
        this.exitstatevalueDirtyFlag = true;
    }

    public String getExitStateValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExitStateValue();
        }
        return this.exitstatevalue;
    }

    public boolean isExitStateValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExitStateValueDirty();
        }
        return this.exitstatevalueDirtyFlag;
    }

    public void resetExitStateValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExitStateValue();
            return;
        }
        this.exitstatevalueDirtyFlag = false;
        this.exitstatevalue = null;
    }

    public void setFormCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFormCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.formcodename = string;
        this.formcodenameDirtyFlag = true;
    }

    public String getFormCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFormCodeName();
        }
        return this.formcodename;
    }

    public boolean isFormCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFormCodeNameDirty();
        }
        return this.formcodenameDirtyFlag;
    }

    public void resetFormCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFormCodeName();
            return;
        }
        this.formcodenameDirtyFlag = false;
        this.formcodename = null;
    }

    public void setHeight(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHeight(n);
            return;
        }
        this.height = n;
        this.heightDirtyFlag = true;
    }

    public Integer getHeight() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHeight();
        }
        return this.height;
    }

    public boolean isHeightDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHeightDirty();
        }
        return this.heightDirtyFlag;
    }

    public void resetHeight() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHeight();
            return;
        }
        this.heightDirtyFlag = false;
        this.height = null;
    }

    public void setIconPath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIconPath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.iconpath = string;
        this.iconpathDirtyFlag = true;
    }

    public String getIconPath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIconPath();
        }
        return this.iconpath;
    }

    public boolean isIconPathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIconPathDirty();
        }
        return this.iconpathDirtyFlag;
    }

    public void resetIconPath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIconPath();
            return;
        }
        this.iconpathDirtyFlag = false;
        this.iconpath = null;
    }

    public void setLeftPos(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLeftPos(n);
            return;
        }
        this.leftpos = n;
        this.leftposDirtyFlag = true;
    }

    public Integer getLeftPos() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLeftPos();
        }
        return this.leftpos;
    }

    public boolean isLeftPosDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLeftPosDirty();
        }
        return this.leftposDirtyFlag;
    }

    public void resetLeftPos() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLeftPos();
            return;
        }
        this.leftposDirtyFlag = false;
        this.leftpos = null;
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

    public void setMemoField(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMemoField(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.memofield = string;
        this.memofieldDirtyFlag = true;
    }

    public String getMemoField() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMemoField();
        }
        return this.memofield;
    }

    public boolean isMemoFieldDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMemoFieldDirty();
        }
        return this.memofieldDirtyFlag;
    }

    public void resetMemoField() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMemoField();
            return;
        }
        this.memofieldDirtyFlag = false;
        this.memofield = null;
    }

    public void setMobFormCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobFormCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mobformcodename = string;
        this.mobformcodenameDirtyFlag = true;
    }

    public String getMobFormCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobFormCodeName();
        }
        return this.mobformcodename;
    }

    public boolean isMobFormCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobFormCodeNameDirty();
        }
        return this.mobformcodenameDirtyFlag;
    }

    public void resetMobFormCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobFormCodeName();
            return;
        }
        this.mobformcodenameDirtyFlag = false;
        this.mobformcodename = null;
    }

    public void setMobPSDEFormId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobPSDEFormId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mobpsdeformid = string;
        this.mobpsdeformidDirtyFlag = true;
    }

    public String getMobPSDEFormId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobPSDEFormId();
        }
        return this.mobpsdeformid;
    }

    public boolean isMobPSDEFormIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobPSDEFormIdDirty();
        }
        return this.mobpsdeformidDirtyFlag;
    }

    public void resetMobPSDEFormId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobPSDEFormId();
            return;
        }
        this.mobpsdeformidDirtyFlag = false;
        this.mobpsdeformid = null;
    }

    public void setMobPSDEFormName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobPSDEFormName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mobpsdeformname = string;
        this.mobpsdeformnameDirtyFlag = true;
    }

    public String getMobPSDEFormName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobPSDEFormName();
        }
        return this.mobpsdeformname;
    }

    public boolean isMobPSDEFormNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobPSDEFormNameDirty();
        }
        return this.mobpsdeformnameDirtyFlag;
    }

    public void resetMobPSDEFormName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobPSDEFormName();
            return;
        }
        this.mobpsdeformnameDirtyFlag = false;
        this.mobpsdeformname = null;
    }

    public void setMobPSDEUAGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobPSDEUAGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mobpsdeuagroupid = string;
        this.mobpsdeuagroupidDirtyFlag = true;
    }

    public String getMobPSDEUAGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobPSDEUAGroupId();
        }
        return this.mobpsdeuagroupid;
    }

    public boolean isMobPSDEUAGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobPSDEUAGroupIdDirty();
        }
        return this.mobpsdeuagroupidDirtyFlag;
    }

    public void resetMobPSDEUAGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobPSDEUAGroupId();
            return;
        }
        this.mobpsdeuagroupidDirtyFlag = false;
        this.mobpsdeuagroupid = null;
    }

    public void setMobPSDEUAGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobPSDEUAGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mobpsdeuagroupname = string;
        this.mobpsdeuagroupnameDirtyFlag = true;
    }

    public String getMobPSDEUAGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobPSDEUAGroupName();
        }
        return this.mobpsdeuagroupname;
    }

    public boolean isMobPSDEUAGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobPSDEUAGroupNameDirty();
        }
        return this.mobpsdeuagroupnameDirtyFlag;
    }

    public void resetMobPSDEUAGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobPSDEUAGroupName();
            return;
        }
        this.mobpsdeuagroupnameDirtyFlag = false;
        this.mobpsdeuagroupname = null;
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

    public void setMobPSDynaDEViewTemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobPSDynaDEViewTemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mobpsdynadeviewtemplid = string;
        this.mobpsdynadeviewtemplidDirtyFlag = true;
    }

    public String getMobPSDynaDEViewTemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobPSDynaDEViewTemplId();
        }
        return this.mobpsdynadeviewtemplid;
    }

    public boolean isMobPSDynaDEViewTemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobPSDynaDEViewTemplIdDirty();
        }
        return this.mobpsdynadeviewtemplidDirtyFlag;
    }

    public void resetMobPSDynaDEViewTemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobPSDynaDEViewTemplId();
            return;
        }
        this.mobpsdynadeviewtemplidDirtyFlag = false;
        this.mobpsdynadeviewtemplid = null;
    }

    public void setMobUAGroupCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobUAGroupCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mobuagroupcodename = string;
        this.mobuagroupcodenameDirtyFlag = true;
    }

    public String getMobUAGroupCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobUAGroupCodeName();
        }
        return this.mobuagroupcodename;
    }

    public boolean isMobUAGroupCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobUAGroupCodeNameDirty();
        }
        return this.mobuagroupcodenameDirtyFlag;
    }

    public void resetMobUAGroupCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobUAGroupCodeName();
            return;
        }
        this.mobuagroupcodenameDirtyFlag = false;
        this.mobuagroupcodename = null;
    }

    public void setMobUtil2FormCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobUtil2FormCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mobutil2formcodename = string;
        this.mobutil2formcodenameDirtyFlag = true;
    }

    public String getMobUtil2FormCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobUtil2FormCodeName();
        }
        return this.mobutil2formcodename;
    }

    public boolean isMobUtil2FormCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobUtil2FormCodeNameDirty();
        }
        return this.mobutil2formcodenameDirtyFlag;
    }

    public void resetMobUtil2FormCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobUtil2FormCodeName();
            return;
        }
        this.mobutil2formcodenameDirtyFlag = false;
        this.mobutil2formcodename = null;
    }

    public void setMobUtil2PSDEFormId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobUtil2PSDEFormId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mobutil2psdeformid = string;
        this.mobutil2psdeformidDirtyFlag = true;
    }

    public String getMobUtil2PSDEFormId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobUtil2PSDEFormId();
        }
        return this.mobutil2psdeformid;
    }

    public boolean isMobUtil2PSDEFormIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobUtil2PSDEFormIdDirty();
        }
        return this.mobutil2psdeformidDirtyFlag;
    }

    public void resetMobUtil2PSDEFormId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobUtil2PSDEFormId();
            return;
        }
        this.mobutil2psdeformidDirtyFlag = false;
        this.mobutil2psdeformid = null;
    }

    public void setMobUtil2PSDEFormName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobUtil2PSDEFormName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mobutil2psdeformname = string;
        this.mobutil2psdeformnameDirtyFlag = true;
    }

    public String getMobUtil2PSDEFormName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobUtil2PSDEFormName();
        }
        return this.mobutil2psdeformname;
    }

    public boolean isMobUtil2PSDEFormNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobUtil2PSDEFormNameDirty();
        }
        return this.mobutil2psdeformnameDirtyFlag;
    }

    public void resetMobUtil2PSDEFormName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobUtil2PSDEFormName();
            return;
        }
        this.mobutil2psdeformnameDirtyFlag = false;
        this.mobutil2psdeformname = null;
    }

    public void setMobUtil3FormCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobUtil3FormCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mobutil3formcodename = string;
        this.mobutil3formcodenameDirtyFlag = true;
    }

    public String getMobUtil3FormCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobUtil3FormCodeName();
        }
        return this.mobutil3formcodename;
    }

    public boolean isMobUtil3FormCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobUtil3FormCodeNameDirty();
        }
        return this.mobutil3formcodenameDirtyFlag;
    }

    public void resetMobUtil3FormCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobUtil3FormCodeName();
            return;
        }
        this.mobutil3formcodenameDirtyFlag = false;
        this.mobutil3formcodename = null;
    }

    public void setMobUtil3PSDEFormId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobUtil3PSDEFormId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mobutil3psdeformid = string;
        this.mobutil3psdeformidDirtyFlag = true;
    }

    public String getMobUtil3PSDEFormId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobUtil3PSDEFormId();
        }
        return this.mobutil3psdeformid;
    }

    public boolean isMobUtil3PSDEFormIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobUtil3PSDEFormIdDirty();
        }
        return this.mobutil3psdeformidDirtyFlag;
    }

    public void resetMobUtil3PSDEFormId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobUtil3PSDEFormId();
            return;
        }
        this.mobutil3psdeformidDirtyFlag = false;
        this.mobutil3psdeformid = null;
    }

    public void setMobUtil3PSDEFormName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobUtil3PSDEFormName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mobutil3psdeformname = string;
        this.mobutil3psdeformnameDirtyFlag = true;
    }

    public String getMobUtil3PSDEFormName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobUtil3PSDEFormName();
        }
        return this.mobutil3psdeformname;
    }

    public boolean isMobUtil3PSDEFormNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobUtil3PSDEFormNameDirty();
        }
        return this.mobutil3psdeformnameDirtyFlag;
    }

    public void resetMobUtil3PSDEFormName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobUtil3PSDEFormName();
            return;
        }
        this.mobutil3psdeformnameDirtyFlag = false;
        this.mobutil3psdeformname = null;
    }

    public void setMobUtil4FormCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobUtil4FormCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mobutil4formcodename = string;
        this.mobutil4formcodenameDirtyFlag = true;
    }

    public String getMobUtil4FormCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobUtil4FormCodeName();
        }
        return this.mobutil4formcodename;
    }

    public boolean isMobUtil4FormCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobUtil4FormCodeNameDirty();
        }
        return this.mobutil4formcodenameDirtyFlag;
    }

    public void resetMobUtil4FormCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobUtil4FormCodeName();
            return;
        }
        this.mobutil4formcodenameDirtyFlag = false;
        this.mobutil4formcodename = null;
    }

    public void setMobUtil4PSDEFormId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobUtil4PSDEFormId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mobutil4psdeformid = string;
        this.mobutil4psdeformidDirtyFlag = true;
    }

    public String getMobUtil4PSDEFormId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobUtil4PSDEFormId();
        }
        return this.mobutil4psdeformid;
    }

    public boolean isMobUtil4PSDEFormIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobUtil4PSDEFormIdDirty();
        }
        return this.mobutil4psdeformidDirtyFlag;
    }

    public void resetMobUtil4PSDEFormId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobUtil4PSDEFormId();
            return;
        }
        this.mobutil4psdeformidDirtyFlag = false;
        this.mobutil4psdeformid = null;
    }

    public void setMobUtil4PSDEFormName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobUtil4PSDEFormName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mobutil4psdeformname = string;
        this.mobutil4psdeformnameDirtyFlag = true;
    }

    public String getMobUtil4PSDEFormName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobUtil4PSDEFormName();
        }
        return this.mobutil4psdeformname;
    }

    public boolean isMobUtil4PSDEFormNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobUtil4PSDEFormNameDirty();
        }
        return this.mobutil4psdeformnameDirtyFlag;
    }

    public void resetMobUtil4PSDEFormName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobUtil4PSDEFormName();
            return;
        }
        this.mobutil4psdeformnameDirtyFlag = false;
        this.mobutil4psdeformname = null;
    }

    public void setMobUtil5FormCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobUtil5FormCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mobutil5formcodename = string;
        this.mobutil5formcodenameDirtyFlag = true;
    }

    public String getMobUtil5FormCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobUtil5FormCodeName();
        }
        return this.mobutil5formcodename;
    }

    public boolean isMobUtil5FormCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobUtil5FormCodeNameDirty();
        }
        return this.mobutil5formcodenameDirtyFlag;
    }

    public void resetMobUtil5FormCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobUtil5FormCodeName();
            return;
        }
        this.mobutil5formcodenameDirtyFlag = false;
        this.mobutil5formcodename = null;
    }

    public void setMobUtil5PSDEFormId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobUtil5PSDEFormId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mobutil5psdeformid = string;
        this.mobutil5psdeformidDirtyFlag = true;
    }

    public String getMobUtil5PSDEFormId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobUtil5PSDEFormId();
        }
        return this.mobutil5psdeformid;
    }

    public boolean isMobUtil5PSDEFormIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobUtil5PSDEFormIdDirty();
        }
        return this.mobutil5psdeformidDirtyFlag;
    }

    public void resetMobUtil5PSDEFormId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobUtil5PSDEFormId();
            return;
        }
        this.mobutil5psdeformidDirtyFlag = false;
        this.mobutil5psdeformid = null;
    }

    public void setMobUtil5PSDEFormName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobUtil5PSDEFormName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mobutil5psdeformname = string;
        this.mobutil5psdeformnameDirtyFlag = true;
    }

    public String getMobUtil5PSDEFormName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobUtil5PSDEFormName();
        }
        return this.mobutil5psdeformname;
    }

    public boolean isMobUtil5PSDEFormNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobUtil5PSDEFormNameDirty();
        }
        return this.mobutil5psdeformnameDirtyFlag;
    }

    public void resetMobUtil5PSDEFormName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobUtil5PSDEFormName();
            return;
        }
        this.mobutil5psdeformnameDirtyFlag = false;
        this.mobutil5psdeformname = null;
    }

    public void setMobUtilFormCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobUtilFormCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mobutilformcodename = string;
        this.mobutilformcodenameDirtyFlag = true;
    }

    public String getMobUtilFormCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobUtilFormCodeName();
        }
        return this.mobutilformcodename;
    }

    public boolean isMobUtilFormCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobUtilFormCodeNameDirty();
        }
        return this.mobutilformcodenameDirtyFlag;
    }

    public void resetMobUtilFormCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobUtilFormCodeName();
            return;
        }
        this.mobutilformcodenameDirtyFlag = false;
        this.mobutilformcodename = null;
    }

    public void setMobUtilPSDEFormId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobUtilPSDEFormId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mobutilpsdeformid = string;
        this.mobutilpsdeformidDirtyFlag = true;
    }

    public String getMobUtilPSDEFormId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobUtilPSDEFormId();
        }
        return this.mobutilpsdeformid;
    }

    public boolean isMobUtilPSDEFormIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobUtilPSDEFormIdDirty();
        }
        return this.mobutilpsdeformidDirtyFlag;
    }

    public void resetMobUtilPSDEFormId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobUtilPSDEFormId();
            return;
        }
        this.mobutilpsdeformidDirtyFlag = false;
        this.mobutilpsdeformid = null;
    }

    public void setMobUtilPSDEFormName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobUtilPSDEFormName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mobutilpsdeformname = string;
        this.mobutilpsdeformnameDirtyFlag = true;
    }

    public String getMobUtilPSDEFormName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobUtilPSDEFormName();
        }
        return this.mobutilpsdeformname;
    }

    public boolean isMobUtilPSDEFormNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobUtilPSDEFormNameDirty();
        }
        return this.mobutilpsdeformnameDirtyFlag;
    }

    public void resetMobUtilPSDEFormName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobUtilPSDEFormName();
            return;
        }
        this.mobutilpsdeformnameDirtyFlag = false;
        this.mobutilpsdeformname = null;
    }

    public void setMobWFEditViewType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobWFEditViewType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mobwfeditviewtype = string;
        this.mobwfeditviewtypeDirtyFlag = true;
    }

    public String getMobWFEditViewType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobWFEditViewType();
        }
        return this.mobwfeditviewtype;
    }

    public boolean isMobWFEditViewTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobWFEditViewTypeDirty();
        }
        return this.mobwfeditviewtypeDirtyFlag;
    }

    public void resetMobWFEditViewType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobWFEditViewType();
            return;
        }
        this.mobwfeditviewtypeDirtyFlag = false;
        this.mobwfeditviewtype = null;
    }

    public void setModelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.modelid = string;
        this.modelidDirtyFlag = true;
    }

    public String getModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelId();
        }
        return this.modelid;
    }

    public boolean isModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelIdDirty();
        }
        return this.modelidDirtyFlag;
    }

    public void resetModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelId();
            return;
        }
        this.modelidDirtyFlag = false;
        this.modelid = null;
    }

    public void setMsgType(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMsgType(n);
            return;
        }
        this.msgtype = n;
        this.msgtypeDirtyFlag = true;
    }

    public Integer getMsgType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMsgType();
        }
        return this.msgtype;
    }

    public boolean isMsgTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMsgTypeDirty();
        }
        return this.msgtypeDirtyFlag;
    }

    public void resetMsgType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMsgType();
            return;
        }
        this.msgtypeDirtyFlag = false;
        this.msgtype = null;
    }

    public void setMultiInstMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMultiInstMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.multiinstmode = string;
        this.multiinstmodeDirtyFlag = true;
    }

    public String getMultiInstMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMultiInstMode();
        }
        return this.multiinstmode;
    }

    public boolean isMultiInstModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMultiInstModeDirty();
        }
        return this.multiinstmodeDirtyFlag;
    }

    public void resetMultiInstMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMultiInstMode();
            return;
        }
        this.multiinstmodeDirtyFlag = false;
        this.multiinstmode = null;
    }

    public void setNamePSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNamePSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.namepslanresid = string;
        this.namepslanresidDirtyFlag = true;
    }

    public String getNamePSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNamePSLanResId();
        }
        return this.namepslanresid;
    }

    public boolean isNamePSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNamePSLanResIdDirty();
        }
        return this.namepslanresidDirtyFlag;
    }

    public void resetNamePSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNamePSLanResId();
            return;
        }
        this.namepslanresidDirtyFlag = false;
        this.namepslanresid = null;
    }

    public void setNamePSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNamePSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.namepslanresname = string;
        this.namepslanresnameDirtyFlag = true;
    }

    public String getNamePSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNamePSLanResName();
        }
        return this.namepslanresname;
    }

    public boolean isNamePSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNamePSLanResNameDirty();
        }
        return this.namepslanresnameDirtyFlag;
    }

    public void resetNamePSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNamePSLanResName();
            return;
        }
        this.namepslanresnameDirtyFlag = false;
        this.namepslanresname = null;
    }

    public void setNormalProcType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNormalProcType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.normalproctype = string;
        this.normalproctypeDirtyFlag = true;
    }

    public String getNormalProcType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNormalProcType();
        }
        return this.normalproctype;
    }

    public boolean isNormalProcTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNormalProcTypeDirty();
        }
        return this.normalproctypeDirtyFlag;
    }

    public void resetNormalProcType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNormalProcType();
            return;
        }
        this.normalproctypeDirtyFlag = false;
        this.normalproctype = null;
    }

    public void setPredefinedActions(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPredefinedActions(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.predefinedactions = string;
        this.predefinedactionsDirtyFlag = true;
    }

    public String getPredefinedActions() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPredefinedActions();
        }
        return this.predefinedactions;
    }

    public boolean isPredefinedActionsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPredefinedActionsDirty();
        }
        return this.predefinedactionsDirtyFlag;
    }

    public void resetPredefinedActions() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPredefinedActions();
            return;
        }
        this.predefinedactionsDirtyFlag = false;
        this.predefinedactions = null;
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

    public void setPSDEUAGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEUAGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeuagroupid = string;
        this.psdeuagroupidDirtyFlag = true;
    }

    public String getPSDEUAGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUAGroupId();
        }
        return this.psdeuagroupid;
    }

    public boolean isPSDEUAGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEUAGroupIdDirty();
        }
        return this.psdeuagroupidDirtyFlag;
    }

    public void resetPSDEUAGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEUAGroupId();
            return;
        }
        this.psdeuagroupidDirtyFlag = false;
        this.psdeuagroupid = null;
    }

    public void setPSDEUAGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEUAGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeuagroupname = string;
        this.psdeuagroupnameDirtyFlag = true;
    }

    public String getPSDEUAGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUAGroupName();
        }
        return this.psdeuagroupname;
    }

    public boolean isPSDEUAGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEUAGroupNameDirty();
        }
        return this.psdeuagroupnameDirtyFlag;
    }

    public void resetPSDEUAGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEUAGroupName();
            return;
        }
        this.psdeuagroupnameDirtyFlag = false;
        this.psdeuagroupname = null;
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

    public void setPSDynaDEViewTemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaDEViewTemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynadeviewtemplid = string;
        this.psdynadeviewtemplidDirtyFlag = true;
    }

    public String getPSDynaDEViewTemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaDEViewTemplId();
        }
        return this.psdynadeviewtemplid;
    }

    public boolean isPSDynaDEViewTemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaDEViewTemplIdDirty();
        }
        return this.psdynadeviewtemplidDirtyFlag;
    }

    public void resetPSDynaDEViewTemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaDEViewTemplId();
            return;
        }
        this.psdynadeviewtemplidDirtyFlag = false;
        this.psdynadeviewtemplid = null;
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

    public void setPSSysMsgTemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysMsgTemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmsgtemplid = string;
        this.pssysmsgtemplidDirtyFlag = true;
    }

    public String getPSSysMsgTemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysMsgTemplId();
        }
        return this.pssysmsgtemplid;
    }

    public boolean isPSSysMsgTemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysMsgTemplIdDirty();
        }
        return this.pssysmsgtemplidDirtyFlag;
    }

    public void resetPSSysMsgTemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysMsgTemplId();
            return;
        }
        this.pssysmsgtemplidDirtyFlag = false;
        this.pssysmsgtemplid = null;
    }

    public void setPSSysMsgTemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysMsgTemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmsgtemplname = string;
        this.pssysmsgtemplnameDirtyFlag = true;
    }

    public String getPSSysMsgTemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysMsgTemplName();
        }
        return this.pssysmsgtemplname;
    }

    public boolean isPSSysMsgTemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysMsgTemplNameDirty();
        }
        return this.pssysmsgtemplnameDirtyFlag;
    }

    public void resetPSSysMsgTemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysMsgTemplName();
            return;
        }
        this.pssysmsgtemplnameDirtyFlag = false;
        this.pssysmsgtemplname = null;
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

    public void setPSWFDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfdeid = string;
        this.pswfdeidDirtyFlag = true;
    }

    public String getPSWFDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFDEId();
        }
        return this.pswfdeid;
    }

    public boolean isPSWFDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFDEIdDirty();
        }
        return this.pswfdeidDirtyFlag;
    }

    public void resetPSWFDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFDEId();
            return;
        }
        this.pswfdeidDirtyFlag = false;
        this.pswfdeid = null;
    }

    public void setPSWFDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfdename = string;
        this.pswfdenameDirtyFlag = true;
    }

    public String getPSWFDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFDEName();
        }
        return this.pswfdename;
    }

    public boolean isPSWFDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFDENameDirty();
        }
        return this.pswfdenameDirtyFlag;
    }

    public void resetPSWFDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFDEName();
            return;
        }
        this.pswfdenameDirtyFlag = false;
        this.pswfdename = null;
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

    public void setPSWFWorkTimeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFWorkTimeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfworktimeid = string;
        this.pswfworktimeidDirtyFlag = true;
    }

    public String getPSWFWorkTimeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFWorkTimeId();
        }
        return this.pswfworktimeid;
    }

    public boolean isPSWFWorkTimeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFWorkTimeIdDirty();
        }
        return this.pswfworktimeidDirtyFlag;
    }

    public void resetPSWFWorkTimeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFWorkTimeId();
            return;
        }
        this.pswfworktimeidDirtyFlag = false;
        this.pswfworktimeid = null;
    }

    public void setPSWFWorkTimeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFWorkTimeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfworktimename = string;
        this.pswfworktimenameDirtyFlag = true;
    }

    public String getPSWFWorkTimeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFWorkTimeName();
        }
        return this.pswfworktimename;
    }

    public boolean isPSWFWorkTimeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFWorkTimeNameDirty();
        }
        return this.pswfworktimenameDirtyFlag;
    }

    public void resetPSWFWorkTimeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFWorkTimeName();
            return;
        }
        this.pswfworktimenameDirtyFlag = false;
        this.pswfworktimename = null;
    }

    public void setRefPSWFVersionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSWFVersionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpswfversionid = string;
        this.refpswfversionidDirtyFlag = true;
    }

    public String getRefPSWFVersionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSWFVersionId();
        }
        return this.refpswfversionid;
    }

    public boolean isRefPSWFVersionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSWFVersionIdDirty();
        }
        return this.refpswfversionidDirtyFlag;
    }

    public void resetRefPSWFVersionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSWFVersionId();
            return;
        }
        this.refpswfversionidDirtyFlag = false;
        this.refpswfversionid = null;
    }

    public void setRefPSWFVersionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSWFVersionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpswfversionname = string;
        this.refpswfversionnameDirtyFlag = true;
    }

    public String getRefPSWFVersionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSWFVersionName();
        }
        return this.refpswfversionname;
    }

    public boolean isRefPSWFVersionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSWFVersionNameDirty();
        }
        return this.refpswfversionnameDirtyFlag;
    }

    public void resetRefPSWFVersionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSWFVersionName();
            return;
        }
        this.refpswfversionnameDirtyFlag = false;
        this.refpswfversionname = null;
    }

    public void setSendInform(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSendInform(n);
            return;
        }
        this.sendinform = n;
        this.sendinformDirtyFlag = true;
    }

    public Integer getSendInform() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSendInform();
        }
        return this.sendinform;
    }

    public boolean isSendInformDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSendInformDirty();
        }
        return this.sendinformDirtyFlag;
    }

    public void resetSendInform() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSendInform();
            return;
        }
        this.sendinformDirtyFlag = false;
        this.sendinform = null;
    }

    public void setShapeParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setShapeParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.shapeparams = string;
        this.shapeparamsDirtyFlag = true;
    }

    public String getShapeParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getShapeParams();
        }
        return this.shapeparams;
    }

    public boolean isShapeParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isShapeParamsDirty();
        }
        return this.shapeparamsDirtyFlag;
    }

    public void resetShapeParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetShapeParams();
            return;
        }
        this.shapeparamsDirtyFlag = false;
        this.shapeparams = null;
    }

    public void setThreadName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setThreadName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.threadname = string;
        this.threadnameDirtyFlag = true;
    }

    public String getThreadName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getThreadName();
        }
        return this.threadname;
    }

    public boolean isThreadNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isThreadNameDirty();
        }
        return this.threadnameDirtyFlag;
    }

    public void resetThreadName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetThreadName();
            return;
        }
        this.threadnameDirtyFlag = false;
        this.threadname = null;
    }

    public void setThreadSN(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setThreadSN(n);
            return;
        }
        this.threadsn = n;
        this.threadsnDirtyFlag = true;
    }

    public Integer getThreadSN() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getThreadSN();
        }
        return this.threadsn;
    }

    public boolean isThreadSNDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isThreadSNDirty();
        }
        return this.threadsnDirtyFlag;
    }

    public void resetThreadSN() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetThreadSN();
            return;
        }
        this.threadsnDirtyFlag = false;
        this.threadsn = null;
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

    public void setTimeoutPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTimeoutPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.timeoutpsdefid = string;
        this.timeoutpsdefidDirtyFlag = true;
    }

    public String getTimeoutPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTimeoutPSDEFId();
        }
        return this.timeoutpsdefid;
    }

    public boolean isTimeoutPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTimeoutPSDEFIdDirty();
        }
        return this.timeoutpsdefidDirtyFlag;
    }

    public void resetTimeoutPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTimeoutPSDEFId();
            return;
        }
        this.timeoutpsdefidDirtyFlag = false;
        this.timeoutpsdefid = null;
    }

    public void setTimeoutPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTimeoutPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.timeoutpsdefname = string;
        this.timeoutpsdefnameDirtyFlag = true;
    }

    public String getTimeoutPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTimeoutPSDEFName();
        }
        return this.timeoutpsdefname;
    }

    public boolean isTimeoutPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTimeoutPSDEFNameDirty();
        }
        return this.timeoutpsdefnameDirtyFlag;
    }

    public void resetTimeoutPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTimeoutPSDEFName();
            return;
        }
        this.timeoutpsdefnameDirtyFlag = false;
        this.timeoutpsdefname = null;
    }

    public void setTimeoutType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTimeoutType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.timeouttype = string;
        this.timeouttypeDirtyFlag = true;
    }

    public String getTimeoutType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTimeoutType();
        }
        return this.timeouttype;
    }

    public boolean isTimeoutTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTimeoutTypeDirty();
        }
        return this.timeouttypeDirtyFlag;
    }

    public void resetTimeoutType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTimeoutType();
            return;
        }
        this.timeouttypeDirtyFlag = false;
        this.timeouttype = null;
    }

    public void setTopPos(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTopPos(n);
            return;
        }
        this.toppos = n;
        this.topposDirtyFlag = true;
    }

    public Integer getTopPos() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTopPos();
        }
        return this.toppos;
    }

    public boolean isTopPosDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTopPosDirty();
        }
        return this.topposDirtyFlag;
    }

    public void resetTopPos() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTopPos();
            return;
        }
        this.topposDirtyFlag = false;
        this.toppos = null;
    }

    public void setUAGroupCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUAGroupCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.uagroupcodename = string;
        this.uagroupcodenameDirtyFlag = true;
    }

    public String getUAGroupCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUAGroupCodeName();
        }
        return this.uagroupcodename;
    }

    public boolean isUAGroupCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUAGroupCodeNameDirty();
        }
        return this.uagroupcodenameDirtyFlag;
    }

    public void resetUAGroupCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUAGroupCodeName();
            return;
        }
        this.uagroupcodenameDirtyFlag = false;
        this.uagroupcodename = null;
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

    public void setUserData(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserData(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userdata = string;
        this.userdataDirtyFlag = true;
    }

    public String getUserData() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserData();
        }
        return this.userdata;
    }

    public boolean isUserDataDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserDataDirty();
        }
        return this.userdataDirtyFlag;
    }

    public void resetUserData() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserData();
            return;
        }
        this.userdataDirtyFlag = false;
        this.userdata = null;
    }

    public void setUserData2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserData2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userdata2 = string;
        this.userdata2DirtyFlag = true;
    }

    public String getUserData2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserData2();
        }
        return this.userdata2;
    }

    public boolean isUserData2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserData2Dirty();
        }
        return this.userdata2DirtyFlag;
    }

    public void resetUserData2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserData2();
            return;
        }
        this.userdata2DirtyFlag = false;
        this.userdata2 = null;
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

    public void setUtil2FormCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtil2FormCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.util2formcodename = string;
        this.util2formcodenameDirtyFlag = true;
    }

    public String getUtil2FormCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtil2FormCodeName();
        }
        return this.util2formcodename;
    }

    public boolean isUtil2FormCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtil2FormCodeNameDirty();
        }
        return this.util2formcodenameDirtyFlag;
    }

    public void resetUtil2FormCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtil2FormCodeName();
            return;
        }
        this.util2formcodenameDirtyFlag = false;
        this.util2formcodename = null;
    }

    public void setUtil2PSDEFormId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtil2PSDEFormId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.util2psdeformid = string;
        this.util2psdeformidDirtyFlag = true;
    }

    public String getUtil2PSDEFormId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtil2PSDEFormId();
        }
        return this.util2psdeformid;
    }

    public boolean isUtil2PSDEFormIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtil2PSDEFormIdDirty();
        }
        return this.util2psdeformidDirtyFlag;
    }

    public void resetUtil2PSDEFormId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtil2PSDEFormId();
            return;
        }
        this.util2psdeformidDirtyFlag = false;
        this.util2psdeformid = null;
    }

    public void setUtil2PSDEFormName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtil2PSDEFormName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.util2psdeformname = string;
        this.util2psdeformnameDirtyFlag = true;
    }

    public String getUtil2PSDEFormName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtil2PSDEFormName();
        }
        return this.util2psdeformname;
    }

    public boolean isUtil2PSDEFormNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtil2PSDEFormNameDirty();
        }
        return this.util2psdeformnameDirtyFlag;
    }

    public void resetUtil2PSDEFormName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtil2PSDEFormName();
            return;
        }
        this.util2psdeformnameDirtyFlag = false;
        this.util2psdeformname = null;
    }

    public void setUtil3FormCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtil3FormCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.util3formcodename = string;
        this.util3formcodenameDirtyFlag = true;
    }

    public String getUtil3FormCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtil3FormCodeName();
        }
        return this.util3formcodename;
    }

    public boolean isUtil3FormCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtil3FormCodeNameDirty();
        }
        return this.util3formcodenameDirtyFlag;
    }

    public void resetUtil3FormCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtil3FormCodeName();
            return;
        }
        this.util3formcodenameDirtyFlag = false;
        this.util3formcodename = null;
    }

    public void setUtil3PSDEFormId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtil3PSDEFormId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.util3psdeformid = string;
        this.util3psdeformidDirtyFlag = true;
    }

    public String getUtil3PSDEFormId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtil3PSDEFormId();
        }
        return this.util3psdeformid;
    }

    public boolean isUtil3PSDEFormIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtil3PSDEFormIdDirty();
        }
        return this.util3psdeformidDirtyFlag;
    }

    public void resetUtil3PSDEFormId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtil3PSDEFormId();
            return;
        }
        this.util3psdeformidDirtyFlag = false;
        this.util3psdeformid = null;
    }

    public void setUtil3PSDEFormName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtil3PSDEFormName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.util3psdeformname = string;
        this.util3psdeformnameDirtyFlag = true;
    }

    public String getUtil3PSDEFormName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtil3PSDEFormName();
        }
        return this.util3psdeformname;
    }

    public boolean isUtil3PSDEFormNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtil3PSDEFormNameDirty();
        }
        return this.util3psdeformnameDirtyFlag;
    }

    public void resetUtil3PSDEFormName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtil3PSDEFormName();
            return;
        }
        this.util3psdeformnameDirtyFlag = false;
        this.util3psdeformname = null;
    }

    public void setUtil4FormCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtil4FormCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.util4formcodename = string;
        this.util4formcodenameDirtyFlag = true;
    }

    public String getUtil4FormCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtil4FormCodeName();
        }
        return this.util4formcodename;
    }

    public boolean isUtil4FormCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtil4FormCodeNameDirty();
        }
        return this.util4formcodenameDirtyFlag;
    }

    public void resetUtil4FormCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtil4FormCodeName();
            return;
        }
        this.util4formcodenameDirtyFlag = false;
        this.util4formcodename = null;
    }

    public void setUtil4PSDEFormId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtil4PSDEFormId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.util4psdeformid = string;
        this.util4psdeformidDirtyFlag = true;
    }

    public String getUtil4PSDEFormId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtil4PSDEFormId();
        }
        return this.util4psdeformid;
    }

    public boolean isUtil4PSDEFormIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtil4PSDEFormIdDirty();
        }
        return this.util4psdeformidDirtyFlag;
    }

    public void resetUtil4PSDEFormId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtil4PSDEFormId();
            return;
        }
        this.util4psdeformidDirtyFlag = false;
        this.util4psdeformid = null;
    }

    public void setUtil4PSDEFormName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtil4PSDEFormName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.util4psdeformname = string;
        this.util4psdeformnameDirtyFlag = true;
    }

    public String getUtil4PSDEFormName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtil4PSDEFormName();
        }
        return this.util4psdeformname;
    }

    public boolean isUtil4PSDEFormNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtil4PSDEFormNameDirty();
        }
        return this.util4psdeformnameDirtyFlag;
    }

    public void resetUtil4PSDEFormName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtil4PSDEFormName();
            return;
        }
        this.util4psdeformnameDirtyFlag = false;
        this.util4psdeformname = null;
    }

    public void setUtil5FormCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtil5FormCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.util5formcodename = string;
        this.util5formcodenameDirtyFlag = true;
    }

    public String getUtil5FormCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtil5FormCodeName();
        }
        return this.util5formcodename;
    }

    public boolean isUtil5FormCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtil5FormCodeNameDirty();
        }
        return this.util5formcodenameDirtyFlag;
    }

    public void resetUtil5FormCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtil5FormCodeName();
            return;
        }
        this.util5formcodenameDirtyFlag = false;
        this.util5formcodename = null;
    }

    public void setUtil5PSDEFormId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtil5PSDEFormId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.util5psdeformid = string;
        this.util5psdeformidDirtyFlag = true;
    }

    public String getUtil5PSDEFormId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtil5PSDEFormId();
        }
        return this.util5psdeformid;
    }

    public boolean isUtil5PSDEFormIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtil5PSDEFormIdDirty();
        }
        return this.util5psdeformidDirtyFlag;
    }

    public void resetUtil5PSDEFormId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtil5PSDEFormId();
            return;
        }
        this.util5psdeformidDirtyFlag = false;
        this.util5psdeformid = null;
    }

    public void setUtil5PSDEFormName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtil5PSDEFormName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.util5psdeformname = string;
        this.util5psdeformnameDirtyFlag = true;
    }

    public String getUtil5PSDEFormName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtil5PSDEFormName();
        }
        return this.util5psdeformname;
    }

    public boolean isUtil5PSDEFormNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtil5PSDEFormNameDirty();
        }
        return this.util5psdeformnameDirtyFlag;
    }

    public void resetUtil5PSDEFormName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtil5PSDEFormName();
            return;
        }
        this.util5psdeformnameDirtyFlag = false;
        this.util5psdeformname = null;
    }

    public void setUtilFormCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilFormCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilformcodename = string;
        this.utilformcodenameDirtyFlag = true;
    }

    public String getUtilFormCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilFormCodeName();
        }
        return this.utilformcodename;
    }

    public boolean isUtilFormCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilFormCodeNameDirty();
        }
        return this.utilformcodenameDirtyFlag;
    }

    public void resetUtilFormCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilFormCodeName();
            return;
        }
        this.utilformcodenameDirtyFlag = false;
        this.utilformcodename = null;
    }

    public void setUtilPSDEFormId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDEFormId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsdeformid = string;
        this.utilpsdeformidDirtyFlag = true;
    }

    public String getUtilPSDEFormId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDEFormId();
        }
        return this.utilpsdeformid;
    }

    public boolean isUtilPSDEFormIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDEFormIdDirty();
        }
        return this.utilpsdeformidDirtyFlag;
    }

    public void resetUtilPSDEFormId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDEFormId();
            return;
        }
        this.utilpsdeformidDirtyFlag = false;
        this.utilpsdeformid = null;
    }

    public void setUtilPSDEFormName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDEFormName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsdeformname = string;
        this.utilpsdeformnameDirtyFlag = true;
    }

    public String getUtilPSDEFormName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDEFormName();
        }
        return this.utilpsdeformname;
    }

    public boolean isUtilPSDEFormNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDEFormNameDirty();
        }
        return this.utilpsdeformnameDirtyFlag;
    }

    public void resetUtilPSDEFormName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDEFormName();
            return;
        }
        this.utilpsdeformnameDirtyFlag = false;
        this.utilpsdeformname = null;
    }

    public void setWFEditViewType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFEditViewType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wfeditviewtype = string;
        this.wfeditviewtypeDirtyFlag = true;
    }

    public String getWFEditViewType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFEditViewType();
        }
        return this.wfeditviewtype;
    }

    public boolean isWFEditViewTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFEditViewTypeDirty();
        }
        return this.wfeditviewtypeDirtyFlag;
    }

    public void resetWFEditViewType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFEditViewType();
            return;
        }
        this.wfeditviewtypeDirtyFlag = false;
        this.wfeditviewtype = null;
    }

    public void setWFEngineType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFEngineType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wfenginetype = string;
        this.wfenginetypeDirtyFlag = true;
    }

    public String getWFEngineType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFEngineType();
        }
        return this.wfenginetype;
    }

    public boolean isWFEngineTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFEngineTypeDirty();
        }
        return this.wfenginetypeDirtyFlag;
    }

    public void resetWFEngineType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFEngineType();
            return;
        }
        this.wfenginetypeDirtyFlag = false;
        this.wfenginetype = null;
    }

    public void setWFProcessType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFProcessType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wfprocesstype = string;
        this.wfprocesstypeDirtyFlag = true;
    }

    public String getWFProcessType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFProcessType();
        }
        return this.wfprocesstype;
    }

    public boolean isWFProcessTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFProcessTypeDirty();
        }
        return this.wfprocesstypeDirtyFlag;
    }

    public void resetWFProcessType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFProcessType();
            return;
        }
        this.wfprocesstypeDirtyFlag = false;
        this.wfprocesstype = null;
    }

    public void setWFStepName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFStepName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wfstepname = string;
        this.wfstepnameDirtyFlag = true;
    }

    public String getWFStepName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFStepName();
        }
        return this.wfstepname;
    }

    public boolean isWFStepNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFStepNameDirty();
        }
        return this.wfstepnameDirtyFlag;
    }

    public void resetWFStepName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFStepName();
            return;
        }
        this.wfstepnameDirtyFlag = false;
        this.wfstepname = null;
    }

    public void setWFStepValue(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFStepValue(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wfstepvalue = string;
        this.wfstepvalueDirtyFlag = true;
    }

    public String getWFStepValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFStepValue();
        }
        return this.wfstepvalue;
    }

    public boolean isWFStepValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFStepValueDirty();
        }
        return this.wfstepvalueDirtyFlag;
    }

    public void resetWFStepValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFStepValue();
            return;
        }
        this.wfstepvalueDirtyFlag = false;
        this.wfstepvalue = null;
    }

    public void setWidth(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWidth(n);
            return;
        }
        this.width = n;
        this.widthDirtyFlag = true;
    }

    public Integer getWidth() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWidth();
        }
        return this.width;
    }

    public boolean isWidthDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWidthDirty();
        }
        return this.widthDirtyFlag;
    }

    public void resetWidth() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWidth();
            return;
        }
        this.widthDirtyFlag = false;
        this.width = null;
    }

    protected void onReset() {
        PSWFProcessBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSWFProcessBase pSWFProcessBase) {
        pSWFProcessBase.resetAsyncMode();
        pSWFProcessBase.resetCodeName();
        pSWFProcessBase.resetCreateDate();
        pSWFProcessBase.resetCreateMan();
        pSWFProcessBase.resetDynaModelFlag();
        pSWFProcessBase.resetEditFields();
        pSWFProcessBase.resetEditFlag();
        pSWFProcessBase.resetEditPSDEFGroupId();
        pSWFProcessBase.resetEditPSDEFGroupName();
        pSWFProcessBase.resetEmbedPSDEDSId();
        pSWFProcessBase.resetEmbedPSDEDSName();
        pSWFProcessBase.resetEmbedPSDEId();
        pSWFProcessBase.resetEmbedPSWFDEId();
        pSWFProcessBase.resetEmbedPSWFDEName();
        pSWFProcessBase.resetEmbedPSWFId();
        pSWFProcessBase.resetEmbedPSWFName();
        pSWFProcessBase.resetEnable();
        pSWFProcessBase.resetEnableMobile();
        pSWFProcessBase.resetEnableTimeout();
        pSWFProcessBase.resetExitStateName();
        pSWFProcessBase.resetExitStateValue();
        pSWFProcessBase.resetFormCodeName();
        pSWFProcessBase.resetHeight();
        pSWFProcessBase.resetIconPath();
        pSWFProcessBase.resetLeftPos();
        pSWFProcessBase.resetMemo();
        pSWFProcessBase.resetMemoField();
        pSWFProcessBase.resetMobFormCodeName();
        pSWFProcessBase.resetMobPSDEFormId();
        pSWFProcessBase.resetMobPSDEFormName();
        pSWFProcessBase.resetMobPSDEUAGroupId();
        pSWFProcessBase.resetMobPSDEUAGroupName();
        pSWFProcessBase.resetMobPSDEViewId();
        pSWFProcessBase.resetMobPSDEViewName();
        pSWFProcessBase.resetMobPSDynaDEViewTemplId();
        pSWFProcessBase.resetMobUAGroupCodeName();
        pSWFProcessBase.resetMobUtil2FormCodeName();
        pSWFProcessBase.resetMobUtil2PSDEFormId();
        pSWFProcessBase.resetMobUtil2PSDEFormName();
        pSWFProcessBase.resetMobUtil3FormCodeName();
        pSWFProcessBase.resetMobUtil3PSDEFormId();
        pSWFProcessBase.resetMobUtil3PSDEFormName();
        pSWFProcessBase.resetMobUtil4FormCodeName();
        pSWFProcessBase.resetMobUtil4PSDEFormId();
        pSWFProcessBase.resetMobUtil4PSDEFormName();
        pSWFProcessBase.resetMobUtil5FormCodeName();
        pSWFProcessBase.resetMobUtil5PSDEFormId();
        pSWFProcessBase.resetMobUtil5PSDEFormName();
        pSWFProcessBase.resetMobUtilFormCodeName();
        pSWFProcessBase.resetMobUtilPSDEFormId();
        pSWFProcessBase.resetMobUtilPSDEFormName();
        pSWFProcessBase.resetMobWFEditViewType();
        pSWFProcessBase.resetModelId();
        pSWFProcessBase.resetMsgType();
        pSWFProcessBase.resetMultiInstMode();
        pSWFProcessBase.resetNamePSLanResId();
        pSWFProcessBase.resetNamePSLanResName();
        pSWFProcessBase.resetNormalProcType();
        pSWFProcessBase.resetPredefinedActions();
        pSWFProcessBase.resetPSDEActionId();
        pSWFProcessBase.resetPSDEActionName();
        pSWFProcessBase.resetPSDEFormId();
        pSWFProcessBase.resetPSDEFormName();
        pSWFProcessBase.resetPSDEId();
        pSWFProcessBase.resetPSDEUAGroupId();
        pSWFProcessBase.resetPSDEUAGroupName();
        pSWFProcessBase.resetPSDEViewBaseId();
        pSWFProcessBase.resetPSDEViewBaseName();
        pSWFProcessBase.resetPSDynaDEViewTemplId();
        pSWFProcessBase.resetPSDynaInstId();
        pSWFProcessBase.resetPSSysMsgTemplId();
        pSWFProcessBase.resetPSSysMsgTemplName();
        pSWFProcessBase.resetPSSystemId();
        pSWFProcessBase.resetPSWFDEId();
        pSWFProcessBase.resetPSWFDEName();
        pSWFProcessBase.resetPSWFId();
        pSWFProcessBase.resetPSWFName();
        pSWFProcessBase.resetPSWFProcessId();
        pSWFProcessBase.resetPSWFProcessName();
        pSWFProcessBase.resetPSWFVersionId();
        pSWFProcessBase.resetPSWFVersionName();
        pSWFProcessBase.resetPSWFWorkTimeId();
        pSWFProcessBase.resetPSWFWorkTimeName();
        pSWFProcessBase.resetRefPSWFVersionId();
        pSWFProcessBase.resetRefPSWFVersionName();
        pSWFProcessBase.resetSendInform();
        pSWFProcessBase.resetShapeParams();
        pSWFProcessBase.resetThreadName();
        pSWFProcessBase.resetThreadSN();
        pSWFProcessBase.resetTimeout();
        pSWFProcessBase.resetTimeoutPSDEFId();
        pSWFProcessBase.resetTimeoutPSDEFName();
        pSWFProcessBase.resetTimeoutType();
        pSWFProcessBase.resetTopPos();
        pSWFProcessBase.resetUAGroupCodeName();
        pSWFProcessBase.resetUpdateDate();
        pSWFProcessBase.resetUpdateMan();
        pSWFProcessBase.resetUserCat();
        pSWFProcessBase.resetUserData();
        pSWFProcessBase.resetUserData2();
        pSWFProcessBase.resetUserTag();
        pSWFProcessBase.resetUserTag2();
        pSWFProcessBase.resetUserTag3();
        pSWFProcessBase.resetUserTag4();
        pSWFProcessBase.resetUtil2FormCodeName();
        pSWFProcessBase.resetUtil2PSDEFormId();
        pSWFProcessBase.resetUtil2PSDEFormName();
        pSWFProcessBase.resetUtil3FormCodeName();
        pSWFProcessBase.resetUtil3PSDEFormId();
        pSWFProcessBase.resetUtil3PSDEFormName();
        pSWFProcessBase.resetUtil4FormCodeName();
        pSWFProcessBase.resetUtil4PSDEFormId();
        pSWFProcessBase.resetUtil4PSDEFormName();
        pSWFProcessBase.resetUtil5FormCodeName();
        pSWFProcessBase.resetUtil5PSDEFormId();
        pSWFProcessBase.resetUtil5PSDEFormName();
        pSWFProcessBase.resetUtilFormCodeName();
        pSWFProcessBase.resetUtilPSDEFormId();
        pSWFProcessBase.resetUtilPSDEFormName();
        pSWFProcessBase.resetWFEditViewType();
        pSWFProcessBase.resetWFEngineType();
        pSWFProcessBase.resetWFProcessType();
        pSWFProcessBase.resetWFStepName();
        pSWFProcessBase.resetWFStepValue();
        pSWFProcessBase.resetWidth();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAsyncModeDirty()) {
            hashMap.put(FIELD_ASYNCMODE, this.getAsyncMode());
        }
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDynaModelFlagDirty()) {
            hashMap.put(FIELD_DYNAMODELFLAG, this.getDynaModelFlag());
        }
        if (!bl || this.isEditFieldsDirty()) {
            hashMap.put(FIELD_EDITFIELDS, this.getEditFields());
        }
        if (!bl || this.isEditFlagDirty()) {
            hashMap.put(FIELD_EDITFLAG, this.getEditFlag());
        }
        if (!bl || this.isEditPSDEFGroupIdDirty()) {
            hashMap.put(FIELD_EDITPSDEFGROUPID, this.getEditPSDEFGroupId());
        }
        if (!bl || this.isEditPSDEFGroupNameDirty()) {
            hashMap.put(FIELD_EDITPSDEFGROUPNAME, this.getEditPSDEFGroupName());
        }
        if (!bl || this.isEmbedPSDEDSIdDirty()) {
            hashMap.put(FIELD_EMBEDPSDEDSID, this.getEmbedPSDEDSId());
        }
        if (!bl || this.isEmbedPSDEDSNameDirty()) {
            hashMap.put(FIELD_EMBEDPSDEDSNAME, this.getEmbedPSDEDSName());
        }
        if (!bl || this.isEmbedPSDEIdDirty()) {
            hashMap.put(FIELD_EMBEDPSDEID, this.getEmbedPSDEId());
        }
        if (!bl || this.isEmbedPSWFDEIdDirty()) {
            hashMap.put(FIELD_EMBEDPSWFDEID, this.getEmbedPSWFDEId());
        }
        if (!bl || this.isEmbedPSWFDENameDirty()) {
            hashMap.put(FIELD_EMBEDPSWFDENAME, this.getEmbedPSWFDEName());
        }
        if (!bl || this.isEmbedPSWFIdDirty()) {
            hashMap.put(FIELD_EMBEDPSWFID, this.getEmbedPSWFId());
        }
        if (!bl || this.isEmbedPSWFNameDirty()) {
            hashMap.put(FIELD_EMBEDPSWFNAME, this.getEmbedPSWFName());
        }
        if (!bl || this.isEnableDirty()) {
            hashMap.put(FIELD_ENABLE, this.getEnable());
        }
        if (!bl || this.isEnableMobileDirty()) {
            hashMap.put(FIELD_ENABLEMOBILE, this.getEnableMobile());
        }
        if (!bl || this.isEnableTimeoutDirty()) {
            hashMap.put(FIELD_ENABLETIMEOUT, this.getEnableTimeout());
        }
        if (!bl || this.isExitStateNameDirty()) {
            hashMap.put(FIELD_EXITSTATENAME, this.getExitStateName());
        }
        if (!bl || this.isExitStateValueDirty()) {
            hashMap.put(FIELD_EXITSTATEVALUE, this.getExitStateValue());
        }
        if (!bl || this.isFormCodeNameDirty()) {
            hashMap.put(FIELD_FORMCODENAME, this.getFormCodeName());
        }
        if (!bl || this.isHeightDirty()) {
            hashMap.put(FIELD_HEIGHT, this.getHeight());
        }
        if (!bl || this.isIconPathDirty()) {
            hashMap.put(FIELD_ICONPATH, this.getIconPath());
        }
        if (!bl || this.isLeftPosDirty()) {
            hashMap.put(FIELD_LEFTPOS, this.getLeftPos());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMemoFieldDirty()) {
            hashMap.put(FIELD_MEMOFIELD, this.getMemoField());
        }
        if (!bl || this.isMobFormCodeNameDirty()) {
            hashMap.put(FIELD_MOBFORMCODENAME, this.getMobFormCodeName());
        }
        if (!bl || this.isMobPSDEFormIdDirty()) {
            hashMap.put(FIELD_MOBPSDEFORMID, this.getMobPSDEFormId());
        }
        if (!bl || this.isMobPSDEFormNameDirty()) {
            hashMap.put(FIELD_MOBPSDEFORMNAME, this.getMobPSDEFormName());
        }
        if (!bl || this.isMobPSDEUAGroupIdDirty()) {
            hashMap.put(FIELD_MOBPSDEUAGROUPID, this.getMobPSDEUAGroupId());
        }
        if (!bl || this.isMobPSDEUAGroupNameDirty()) {
            hashMap.put(FIELD_MOBPSDEUAGROUPNAME, this.getMobPSDEUAGroupName());
        }
        if (!bl || this.isMobPSDEViewIdDirty()) {
            hashMap.put(FIELD_MOBPSDEVIEWID, this.getMobPSDEViewId());
        }
        if (!bl || this.isMobPSDEViewNameDirty()) {
            hashMap.put(FIELD_MOBPSDEVIEWNAME, this.getMobPSDEViewName());
        }
        if (!bl || this.isMobPSDynaDEViewTemplIdDirty()) {
            hashMap.put(FIELD_MOBPSDYNADEVIEWTEMPLID, this.getMobPSDynaDEViewTemplId());
        }
        if (!bl || this.isMobUAGroupCodeNameDirty()) {
            hashMap.put(FIELD_MOBUAGROUPCODENAME, this.getMobUAGroupCodeName());
        }
        if (!bl || this.isMobUtil2FormCodeNameDirty()) {
            hashMap.put(FIELD_MOBUTIL2FORMCODENAME, this.getMobUtil2FormCodeName());
        }
        if (!bl || this.isMobUtil2PSDEFormIdDirty()) {
            hashMap.put(FIELD_MOBUTIL2PSDEFORMID, this.getMobUtil2PSDEFormId());
        }
        if (!bl || this.isMobUtil2PSDEFormNameDirty()) {
            hashMap.put(FIELD_MOBUTIL2PSDEFORMNAME, this.getMobUtil2PSDEFormName());
        }
        if (!bl || this.isMobUtil3FormCodeNameDirty()) {
            hashMap.put(FIELD_MOBUTIL3FORMCODENAME, this.getMobUtil3FormCodeName());
        }
        if (!bl || this.isMobUtil3PSDEFormIdDirty()) {
            hashMap.put(FIELD_MOBUTIL3PSDEFORMID, this.getMobUtil3PSDEFormId());
        }
        if (!bl || this.isMobUtil3PSDEFormNameDirty()) {
            hashMap.put(FIELD_MOBUTIL3PSDEFORMNAME, this.getMobUtil3PSDEFormName());
        }
        if (!bl || this.isMobUtil4FormCodeNameDirty()) {
            hashMap.put(FIELD_MOBUTIL4FORMCODENAME, this.getMobUtil4FormCodeName());
        }
        if (!bl || this.isMobUtil4PSDEFormIdDirty()) {
            hashMap.put(FIELD_MOBUTIL4PSDEFORMID, this.getMobUtil4PSDEFormId());
        }
        if (!bl || this.isMobUtil4PSDEFormNameDirty()) {
            hashMap.put(FIELD_MOBUTIL4PSDEFORMNAME, this.getMobUtil4PSDEFormName());
        }
        if (!bl || this.isMobUtil5FormCodeNameDirty()) {
            hashMap.put(FIELD_MOBUTIL5FORMCODENAME, this.getMobUtil5FormCodeName());
        }
        if (!bl || this.isMobUtil5PSDEFormIdDirty()) {
            hashMap.put(FIELD_MOBUTIL5PSDEFORMID, this.getMobUtil5PSDEFormId());
        }
        if (!bl || this.isMobUtil5PSDEFormNameDirty()) {
            hashMap.put(FIELD_MOBUTIL5PSDEFORMNAME, this.getMobUtil5PSDEFormName());
        }
        if (!bl || this.isMobUtilFormCodeNameDirty()) {
            hashMap.put(FIELD_MOBUTILFORMCODENAME, this.getMobUtilFormCodeName());
        }
        if (!bl || this.isMobUtilPSDEFormIdDirty()) {
            hashMap.put(FIELD_MOBUTILPSDEFORMID, this.getMobUtilPSDEFormId());
        }
        if (!bl || this.isMobUtilPSDEFormNameDirty()) {
            hashMap.put(FIELD_MOBUTILPSDEFORMNAME, this.getMobUtilPSDEFormName());
        }
        if (!bl || this.isMobWFEditViewTypeDirty()) {
            hashMap.put(FIELD_MOBWFEDITVIEWTYPE, this.getMobWFEditViewType());
        }
        if (!bl || this.isModelIdDirty()) {
            hashMap.put(FIELD_MODELID, this.getModelId());
        }
        if (!bl || this.isMsgTypeDirty()) {
            hashMap.put(FIELD_MSGTYPE, this.getMsgType());
        }
        if (!bl || this.isMultiInstModeDirty()) {
            hashMap.put(FIELD_MULTIINSTMODE, this.getMultiInstMode());
        }
        if (!bl || this.isNamePSLanResIdDirty()) {
            hashMap.put(FIELD_NAMEPSLANRESID, this.getNamePSLanResId());
        }
        if (!bl || this.isNamePSLanResNameDirty()) {
            hashMap.put(FIELD_NAMEPSLANRESNAME, this.getNamePSLanResName());
        }
        if (!bl || this.isNormalProcTypeDirty()) {
            hashMap.put(FIELD_NORMALPROCTYPE, this.getNormalProcType());
        }
        if (!bl || this.isPredefinedActionsDirty()) {
            hashMap.put(FIELD_PREDEFINEDACTIONS, this.getPredefinedActions());
        }
        if (!bl || this.isPSDEActionIdDirty()) {
            hashMap.put(FIELD_PSDEACTIONID, this.getPSDEActionId());
        }
        if (!bl || this.isPSDEActionNameDirty()) {
            hashMap.put(FIELD_PSDEACTIONNAME, this.getPSDEActionName());
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
        if (!bl || this.isPSDEUAGroupIdDirty()) {
            hashMap.put(FIELD_PSDEUAGROUPID, this.getPSDEUAGroupId());
        }
        if (!bl || this.isPSDEUAGroupNameDirty()) {
            hashMap.put(FIELD_PSDEUAGROUPNAME, this.getPSDEUAGroupName());
        }
        if (!bl || this.isPSDEViewBaseIdDirty()) {
            hashMap.put(FIELD_PSDEVIEWBASEID, this.getPSDEViewBaseId());
        }
        if (!bl || this.isPSDEViewBaseNameDirty()) {
            hashMap.put(FIELD_PSDEVIEWBASENAME, this.getPSDEViewBaseName());
        }
        if (!bl || this.isPSDynaDEViewTemplIdDirty()) {
            hashMap.put(FIELD_PSDYNADEVIEWTEMPLID, this.getPSDynaDEViewTemplId());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSSysMsgTemplIdDirty()) {
            hashMap.put(FIELD_PSSYSMSGTEMPLID, this.getPSSysMsgTemplId());
        }
        if (!bl || this.isPSSysMsgTemplNameDirty()) {
            hashMap.put(FIELD_PSSYSMSGTEMPLNAME, this.getPSSysMsgTemplName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSWFDEIdDirty()) {
            hashMap.put(FIELD_PSWFDEID, this.getPSWFDEId());
        }
        if (!bl || this.isPSWFDENameDirty()) {
            hashMap.put(FIELD_PSWFDENAME, this.getPSWFDEName());
        }
        if (!bl || this.isPSWFIdDirty()) {
            hashMap.put(FIELD_PSWFID, this.getPSWFId());
        }
        if (!bl || this.isPSWFNameDirty()) {
            hashMap.put(FIELD_PSWFNAME, this.getPSWFName());
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
        if (!bl || this.isPSWFWorkTimeIdDirty()) {
            hashMap.put(FIELD_PSWFWORKTIMEID, this.getPSWFWorkTimeId());
        }
        if (!bl || this.isPSWFWorkTimeNameDirty()) {
            hashMap.put(FIELD_PSWFWORKTIMENAME, this.getPSWFWorkTimeName());
        }
        if (!bl || this.isRefPSWFVersionIdDirty()) {
            hashMap.put(FIELD_REFPSWFVERSIONID, this.getRefPSWFVersionId());
        }
        if (!bl || this.isRefPSWFVersionNameDirty()) {
            hashMap.put(FIELD_REFPSWFVERSIONNAME, this.getRefPSWFVersionName());
        }
        if (!bl || this.isSendInformDirty()) {
            hashMap.put(FIELD_SENDINFORM, this.getSendInform());
        }
        if (!bl || this.isShapeParamsDirty()) {
            hashMap.put(FIELD_SHAPEPARAMS, this.getShapeParams());
        }
        if (!bl || this.isThreadNameDirty()) {
            hashMap.put(FIELD_THREADNAME, this.getThreadName());
        }
        if (!bl || this.isThreadSNDirty()) {
            hashMap.put(FIELD_THREADSN, this.getThreadSN());
        }
        if (!bl || this.isTimeoutDirty()) {
            hashMap.put(FIELD_TIMEOUT, this.getTimeout());
        }
        if (!bl || this.isTimeoutPSDEFIdDirty()) {
            hashMap.put(FIELD_TIMEOUTPSDEFID, this.getTimeoutPSDEFId());
        }
        if (!bl || this.isTimeoutPSDEFNameDirty()) {
            hashMap.put(FIELD_TIMEOUTPSDEFNAME, this.getTimeoutPSDEFName());
        }
        if (!bl || this.isTimeoutTypeDirty()) {
            hashMap.put(FIELD_TIMEOUTTYPE, this.getTimeoutType());
        }
        if (!bl || this.isTopPosDirty()) {
            hashMap.put(FIELD_TOPPOS, this.getTopPos());
        }
        if (!bl || this.isUAGroupCodeNameDirty()) {
            hashMap.put(FIELD_UAGROUPCODENAME, this.getUAGroupCodeName());
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
        if (!bl || this.isUserDataDirty()) {
            hashMap.put(FIELD_USERDATA, this.getUserData());
        }
        if (!bl || this.isUserData2Dirty()) {
            hashMap.put(FIELD_USERDATA2, this.getUserData2());
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
        if (!bl || this.isUtil2FormCodeNameDirty()) {
            hashMap.put(FIELD_UTIL2FORMCODENAME, this.getUtil2FormCodeName());
        }
        if (!bl || this.isUtil2PSDEFormIdDirty()) {
            hashMap.put(FIELD_UTIL2PSDEFORMID, this.getUtil2PSDEFormId());
        }
        if (!bl || this.isUtil2PSDEFormNameDirty()) {
            hashMap.put(FIELD_UTIL2PSDEFORMNAME, this.getUtil2PSDEFormName());
        }
        if (!bl || this.isUtil3FormCodeNameDirty()) {
            hashMap.put(FIELD_UTIL3FORMCODENAME, this.getUtil3FormCodeName());
        }
        if (!bl || this.isUtil3PSDEFormIdDirty()) {
            hashMap.put(FIELD_UTIL3PSDEFORMID, this.getUtil3PSDEFormId());
        }
        if (!bl || this.isUtil3PSDEFormNameDirty()) {
            hashMap.put(FIELD_UTIL3PSDEFORMNAME, this.getUtil3PSDEFormName());
        }
        if (!bl || this.isUtil4FormCodeNameDirty()) {
            hashMap.put(FIELD_UTIL4FORMCODENAME, this.getUtil4FormCodeName());
        }
        if (!bl || this.isUtil4PSDEFormIdDirty()) {
            hashMap.put(FIELD_UTIL4PSDEFORMID, this.getUtil4PSDEFormId());
        }
        if (!bl || this.isUtil4PSDEFormNameDirty()) {
            hashMap.put(FIELD_UTIL4PSDEFORMNAME, this.getUtil4PSDEFormName());
        }
        if (!bl || this.isUtil5FormCodeNameDirty()) {
            hashMap.put(FIELD_UTIL5FORMCODENAME, this.getUtil5FormCodeName());
        }
        if (!bl || this.isUtil5PSDEFormIdDirty()) {
            hashMap.put(FIELD_UTIL5PSDEFORMID, this.getUtil5PSDEFormId());
        }
        if (!bl || this.isUtil5PSDEFormNameDirty()) {
            hashMap.put(FIELD_UTIL5PSDEFORMNAME, this.getUtil5PSDEFormName());
        }
        if (!bl || this.isUtilFormCodeNameDirty()) {
            hashMap.put(FIELD_UTILFORMCODENAME, this.getUtilFormCodeName());
        }
        if (!bl || this.isUtilPSDEFormIdDirty()) {
            hashMap.put(FIELD_UTILPSDEFORMID, this.getUtilPSDEFormId());
        }
        if (!bl || this.isUtilPSDEFormNameDirty()) {
            hashMap.put(FIELD_UTILPSDEFORMNAME, this.getUtilPSDEFormName());
        }
        if (!bl || this.isWFEditViewTypeDirty()) {
            hashMap.put(FIELD_WFEDITVIEWTYPE, this.getWFEditViewType());
        }
        if (!bl || this.isWFEngineTypeDirty()) {
            hashMap.put(FIELD_WFENGINETYPE, this.getWFEngineType());
        }
        if (!bl || this.isWFProcessTypeDirty()) {
            hashMap.put(FIELD_WFPROCESSTYPE, this.getWFProcessType());
        }
        if (!bl || this.isWFStepNameDirty()) {
            hashMap.put(FIELD_WFSTEPNAME, this.getWFStepName());
        }
        if (!bl || this.isWFStepValueDirty()) {
            hashMap.put(FIELD_WFSTEPVALUE, this.getWFStepValue());
        }
        if (!bl || this.isWidthDirty()) {
            hashMap.put(FIELD_WIDTH, this.getWidth());
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
        return PSWFProcessBase.get(this, n);
    }

    private static Object get(PSWFProcessBase pSWFProcessBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWFProcessBase.getAsyncMode();
            }
            case 1: {
                return pSWFProcessBase.getCodeName();
            }
            case 2: {
                return pSWFProcessBase.getCreateDate();
            }
            case 3: {
                return pSWFProcessBase.getCreateMan();
            }
            case 4: {
                return pSWFProcessBase.getDynaModelFlag();
            }
            case 5: {
                return pSWFProcessBase.getEditFields();
            }
            case 6: {
                return pSWFProcessBase.getEditFlag();
            }
            case 7: {
                return pSWFProcessBase.getEditPSDEFGroupId();
            }
            case 8: {
                return pSWFProcessBase.getEditPSDEFGroupName();
            }
            case 9: {
                return pSWFProcessBase.getEmbedPSDEDSId();
            }
            case 10: {
                return pSWFProcessBase.getEmbedPSDEDSName();
            }
            case 11: {
                return pSWFProcessBase.getEmbedPSDEId();
            }
            case 12: {
                return pSWFProcessBase.getEmbedPSWFDEId();
            }
            case 13: {
                return pSWFProcessBase.getEmbedPSWFDEName();
            }
            case 14: {
                return pSWFProcessBase.getEmbedPSWFId();
            }
            case 15: {
                return pSWFProcessBase.getEmbedPSWFName();
            }
            case 16: {
                return pSWFProcessBase.getEnable();
            }
            case 17: {
                return pSWFProcessBase.getEnableMobile();
            }
            case 18: {
                return pSWFProcessBase.getEnableTimeout();
            }
            case 19: {
                return pSWFProcessBase.getExitStateName();
            }
            case 20: {
                return pSWFProcessBase.getExitStateValue();
            }
            case 21: {
                return pSWFProcessBase.getFormCodeName();
            }
            case 22: {
                return pSWFProcessBase.getHeight();
            }
            case 23: {
                return pSWFProcessBase.getIconPath();
            }
            case 24: {
                return pSWFProcessBase.getLeftPos();
            }
            case 25: {
                return pSWFProcessBase.getMemo();
            }
            case 26: {
                return pSWFProcessBase.getMemoField();
            }
            case 27: {
                return pSWFProcessBase.getMobFormCodeName();
            }
            case 28: {
                return pSWFProcessBase.getMobPSDEFormId();
            }
            case 29: {
                return pSWFProcessBase.getMobPSDEFormName();
            }
            case 30: {
                return pSWFProcessBase.getMobPSDEUAGroupId();
            }
            case 31: {
                return pSWFProcessBase.getMobPSDEUAGroupName();
            }
            case 32: {
                return pSWFProcessBase.getMobPSDEViewId();
            }
            case 33: {
                return pSWFProcessBase.getMobPSDEViewName();
            }
            case 34: {
                return pSWFProcessBase.getMobPSDynaDEViewTemplId();
            }
            case 35: {
                return pSWFProcessBase.getMobUAGroupCodeName();
            }
            case 36: {
                return pSWFProcessBase.getMobUtil2FormCodeName();
            }
            case 37: {
                return pSWFProcessBase.getMobUtil2PSDEFormId();
            }
            case 38: {
                return pSWFProcessBase.getMobUtil2PSDEFormName();
            }
            case 39: {
                return pSWFProcessBase.getMobUtil3FormCodeName();
            }
            case 40: {
                return pSWFProcessBase.getMobUtil3PSDEFormId();
            }
            case 41: {
                return pSWFProcessBase.getMobUtil3PSDEFormName();
            }
            case 42: {
                return pSWFProcessBase.getMobUtil4FormCodeName();
            }
            case 43: {
                return pSWFProcessBase.getMobUtil4PSDEFormId();
            }
            case 44: {
                return pSWFProcessBase.getMobUtil4PSDEFormName();
            }
            case 45: {
                return pSWFProcessBase.getMobUtil5FormCodeName();
            }
            case 46: {
                return pSWFProcessBase.getMobUtil5PSDEFormId();
            }
            case 47: {
                return pSWFProcessBase.getMobUtil5PSDEFormName();
            }
            case 48: {
                return pSWFProcessBase.getMobUtilFormCodeName();
            }
            case 49: {
                return pSWFProcessBase.getMobUtilPSDEFormId();
            }
            case 50: {
                return pSWFProcessBase.getMobUtilPSDEFormName();
            }
            case 51: {
                return pSWFProcessBase.getMobWFEditViewType();
            }
            case 52: {
                return pSWFProcessBase.getModelId();
            }
            case 53: {
                return pSWFProcessBase.getMsgType();
            }
            case 54: {
                return pSWFProcessBase.getMultiInstMode();
            }
            case 55: {
                return pSWFProcessBase.getNamePSLanResId();
            }
            case 56: {
                return pSWFProcessBase.getNamePSLanResName();
            }
            case 57: {
                return pSWFProcessBase.getNormalProcType();
            }
            case 58: {
                return pSWFProcessBase.getPredefinedActions();
            }
            case 59: {
                return pSWFProcessBase.getPSDEActionId();
            }
            case 60: {
                return pSWFProcessBase.getPSDEActionName();
            }
            case 61: {
                return pSWFProcessBase.getPSDEFormId();
            }
            case 62: {
                return pSWFProcessBase.getPSDEFormName();
            }
            case 63: {
                return pSWFProcessBase.getPSDEId();
            }
            case 64: {
                return pSWFProcessBase.getPSDEUAGroupId();
            }
            case 65: {
                return pSWFProcessBase.getPSDEUAGroupName();
            }
            case 66: {
                return pSWFProcessBase.getPSDEViewBaseId();
            }
            case 67: {
                return pSWFProcessBase.getPSDEViewBaseName();
            }
            case 68: {
                return pSWFProcessBase.getPSDynaDEViewTemplId();
            }
            case 69: {
                return pSWFProcessBase.getPSDynaInstId();
            }
            case 70: {
                return pSWFProcessBase.getPSSysMsgTemplId();
            }
            case 71: {
                return pSWFProcessBase.getPSSysMsgTemplName();
            }
            case 72: {
                return pSWFProcessBase.getPSSystemId();
            }
            case 73: {
                return pSWFProcessBase.getPSWFDEId();
            }
            case 74: {
                return pSWFProcessBase.getPSWFDEName();
            }
            case 75: {
                return pSWFProcessBase.getPSWFId();
            }
            case 76: {
                return pSWFProcessBase.getPSWFName();
            }
            case 77: {
                return pSWFProcessBase.getPSWFProcessId();
            }
            case 78: {
                return pSWFProcessBase.getPSWFProcessName();
            }
            case 79: {
                return pSWFProcessBase.getPSWFVersionId();
            }
            case 80: {
                return pSWFProcessBase.getPSWFVersionName();
            }
            case 81: {
                return pSWFProcessBase.getPSWFWorkTimeId();
            }
            case 82: {
                return pSWFProcessBase.getPSWFWorkTimeName();
            }
            case 83: {
                return pSWFProcessBase.getRefPSWFVersionId();
            }
            case 84: {
                return pSWFProcessBase.getRefPSWFVersionName();
            }
            case 85: {
                return pSWFProcessBase.getSendInform();
            }
            case 86: {
                return pSWFProcessBase.getShapeParams();
            }
            case 87: {
                return pSWFProcessBase.getThreadName();
            }
            case 88: {
                return pSWFProcessBase.getThreadSN();
            }
            case 89: {
                return pSWFProcessBase.getTimeout();
            }
            case 90: {
                return pSWFProcessBase.getTimeoutPSDEFId();
            }
            case 91: {
                return pSWFProcessBase.getTimeoutPSDEFName();
            }
            case 92: {
                return pSWFProcessBase.getTimeoutType();
            }
            case 93: {
                return pSWFProcessBase.getTopPos();
            }
            case 94: {
                return pSWFProcessBase.getUAGroupCodeName();
            }
            case 95: {
                return pSWFProcessBase.getUpdateDate();
            }
            case 96: {
                return pSWFProcessBase.getUpdateMan();
            }
            case 97: {
                return pSWFProcessBase.getUserCat();
            }
            case 98: {
                return pSWFProcessBase.getUserData();
            }
            case 99: {
                return pSWFProcessBase.getUserData2();
            }
            case 100: {
                return pSWFProcessBase.getUserTag();
            }
            case 101: {
                return pSWFProcessBase.getUserTag2();
            }
            case 102: {
                return pSWFProcessBase.getUserTag3();
            }
            case 103: {
                return pSWFProcessBase.getUserTag4();
            }
            case 104: {
                return pSWFProcessBase.getUtil2FormCodeName();
            }
            case 105: {
                return pSWFProcessBase.getUtil2PSDEFormId();
            }
            case 106: {
                return pSWFProcessBase.getUtil2PSDEFormName();
            }
            case 107: {
                return pSWFProcessBase.getUtil3FormCodeName();
            }
            case 108: {
                return pSWFProcessBase.getUtil3PSDEFormId();
            }
            case 109: {
                return pSWFProcessBase.getUtil3PSDEFormName();
            }
            case 110: {
                return pSWFProcessBase.getUtil4FormCodeName();
            }
            case 111: {
                return pSWFProcessBase.getUtil4PSDEFormId();
            }
            case 112: {
                return pSWFProcessBase.getUtil4PSDEFormName();
            }
            case 113: {
                return pSWFProcessBase.getUtil5FormCodeName();
            }
            case 114: {
                return pSWFProcessBase.getUtil5PSDEFormId();
            }
            case 115: {
                return pSWFProcessBase.getUtil5PSDEFormName();
            }
            case 116: {
                return pSWFProcessBase.getUtilFormCodeName();
            }
            case 117: {
                return pSWFProcessBase.getUtilPSDEFormId();
            }
            case 118: {
                return pSWFProcessBase.getUtilPSDEFormName();
            }
            case 119: {
                return pSWFProcessBase.getWFEditViewType();
            }
            case 120: {
                return pSWFProcessBase.getWFEngineType();
            }
            case 121: {
                return pSWFProcessBase.getWFProcessType();
            }
            case 122: {
                return pSWFProcessBase.getWFStepName();
            }
            case 123: {
                return pSWFProcessBase.getWFStepValue();
            }
            case 124: {
                return pSWFProcessBase.getWidth();
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
        PSWFProcessBase.set(this, n, object);
    }

    private static void set(PSWFProcessBase pSWFProcessBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSWFProcessBase.setAsyncMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSWFProcessBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSWFProcessBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSWFProcessBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSWFProcessBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSWFProcessBase.setEditFields(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSWFProcessBase.setEditFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSWFProcessBase.setEditPSDEFGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSWFProcessBase.setEditPSDEFGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSWFProcessBase.setEmbedPSDEDSId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSWFProcessBase.setEmbedPSDEDSName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSWFProcessBase.setEmbedPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSWFProcessBase.setEmbedPSWFDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSWFProcessBase.setEmbedPSWFDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSWFProcessBase.setEmbedPSWFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSWFProcessBase.setEmbedPSWFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSWFProcessBase.setEnable(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSWFProcessBase.setEnableMobile(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 18: {
                pSWFProcessBase.setEnableTimeout(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 19: {
                pSWFProcessBase.setExitStateName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSWFProcessBase.setExitStateValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSWFProcessBase.setFormCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSWFProcessBase.setHeight(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 23: {
                pSWFProcessBase.setIconPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSWFProcessBase.setLeftPos(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 25: {
                pSWFProcessBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSWFProcessBase.setMemoField(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSWFProcessBase.setMobFormCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSWFProcessBase.setMobPSDEFormId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSWFProcessBase.setMobPSDEFormName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSWFProcessBase.setMobPSDEUAGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSWFProcessBase.setMobPSDEUAGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSWFProcessBase.setMobPSDEViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSWFProcessBase.setMobPSDEViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSWFProcessBase.setMobPSDynaDEViewTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSWFProcessBase.setMobUAGroupCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSWFProcessBase.setMobUtil2FormCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSWFProcessBase.setMobUtil2PSDEFormId(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSWFProcessBase.setMobUtil2PSDEFormName(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSWFProcessBase.setMobUtil3FormCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSWFProcessBase.setMobUtil3PSDEFormId(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSWFProcessBase.setMobUtil3PSDEFormName(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSWFProcessBase.setMobUtil4FormCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSWFProcessBase.setMobUtil4PSDEFormId(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSWFProcessBase.setMobUtil4PSDEFormName(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSWFProcessBase.setMobUtil5FormCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSWFProcessBase.setMobUtil5PSDEFormId(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSWFProcessBase.setMobUtil5PSDEFormName(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSWFProcessBase.setMobUtilFormCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSWFProcessBase.setMobUtilPSDEFormId(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSWFProcessBase.setMobUtilPSDEFormName(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSWFProcessBase.setMobWFEditViewType(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSWFProcessBase.setModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 53: {
                pSWFProcessBase.setMsgType(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 54: {
                pSWFProcessBase.setMultiInstMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 55: {
                pSWFProcessBase.setNamePSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 56: {
                pSWFProcessBase.setNamePSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 57: {
                pSWFProcessBase.setNormalProcType(DataObject.getStringValue((Object)object));
                return;
            }
            case 58: {
                pSWFProcessBase.setPredefinedActions(DataObject.getStringValue((Object)object));
                return;
            }
            case 59: {
                pSWFProcessBase.setPSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 60: {
                pSWFProcessBase.setPSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 61: {
                pSWFProcessBase.setPSDEFormId(DataObject.getStringValue((Object)object));
                return;
            }
            case 62: {
                pSWFProcessBase.setPSDEFormName(DataObject.getStringValue((Object)object));
                return;
            }
            case 63: {
                pSWFProcessBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 64: {
                pSWFProcessBase.setPSDEUAGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 65: {
                pSWFProcessBase.setPSDEUAGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 66: {
                pSWFProcessBase.setPSDEViewBaseId(DataObject.getStringValue((Object)object));
                return;
            }
            case 67: {
                pSWFProcessBase.setPSDEViewBaseName(DataObject.getStringValue((Object)object));
                return;
            }
            case 68: {
                pSWFProcessBase.setPSDynaDEViewTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 69: {
                pSWFProcessBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 70: {
                pSWFProcessBase.setPSSysMsgTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 71: {
                pSWFProcessBase.setPSSysMsgTemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 72: {
                pSWFProcessBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 73: {
                pSWFProcessBase.setPSWFDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 74: {
                pSWFProcessBase.setPSWFDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 75: {
                pSWFProcessBase.setPSWFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 76: {
                pSWFProcessBase.setPSWFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 77: {
                pSWFProcessBase.setPSWFProcessId(DataObject.getStringValue((Object)object));
                return;
            }
            case 78: {
                pSWFProcessBase.setPSWFProcessName(DataObject.getStringValue((Object)object));
                return;
            }
            case 79: {
                pSWFProcessBase.setPSWFVersionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 80: {
                pSWFProcessBase.setPSWFVersionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 81: {
                pSWFProcessBase.setPSWFWorkTimeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 82: {
                pSWFProcessBase.setPSWFWorkTimeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 83: {
                pSWFProcessBase.setRefPSWFVersionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 84: {
                pSWFProcessBase.setRefPSWFVersionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 85: {
                pSWFProcessBase.setSendInform(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 86: {
                pSWFProcessBase.setShapeParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 87: {
                pSWFProcessBase.setThreadName(DataObject.getStringValue((Object)object));
                return;
            }
            case 88: {
                pSWFProcessBase.setThreadSN(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 89: {
                pSWFProcessBase.setTimeout(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 90: {
                pSWFProcessBase.setTimeoutPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 91: {
                pSWFProcessBase.setTimeoutPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 92: {
                pSWFProcessBase.setTimeoutType(DataObject.getStringValue((Object)object));
                return;
            }
            case 93: {
                pSWFProcessBase.setTopPos(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 94: {
                pSWFProcessBase.setUAGroupCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 95: {
                pSWFProcessBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 96: {
                pSWFProcessBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 97: {
                pSWFProcessBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 98: {
                pSWFProcessBase.setUserData(DataObject.getStringValue((Object)object));
                return;
            }
            case 99: {
                pSWFProcessBase.setUserData2(DataObject.getStringValue((Object)object));
                return;
            }
            case 100: {
                pSWFProcessBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 101: {
                pSWFProcessBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 102: {
                pSWFProcessBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 103: {
                pSWFProcessBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 104: {
                pSWFProcessBase.setUtil2FormCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 105: {
                pSWFProcessBase.setUtil2PSDEFormId(DataObject.getStringValue((Object)object));
                return;
            }
            case 106: {
                pSWFProcessBase.setUtil2PSDEFormName(DataObject.getStringValue((Object)object));
                return;
            }
            case 107: {
                pSWFProcessBase.setUtil3FormCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 108: {
                pSWFProcessBase.setUtil3PSDEFormId(DataObject.getStringValue((Object)object));
                return;
            }
            case 109: {
                pSWFProcessBase.setUtil3PSDEFormName(DataObject.getStringValue((Object)object));
                return;
            }
            case 110: {
                pSWFProcessBase.setUtil4FormCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 111: {
                pSWFProcessBase.setUtil4PSDEFormId(DataObject.getStringValue((Object)object));
                return;
            }
            case 112: {
                pSWFProcessBase.setUtil4PSDEFormName(DataObject.getStringValue((Object)object));
                return;
            }
            case 113: {
                pSWFProcessBase.setUtil5FormCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 114: {
                pSWFProcessBase.setUtil5PSDEFormId(DataObject.getStringValue((Object)object));
                return;
            }
            case 115: {
                pSWFProcessBase.setUtil5PSDEFormName(DataObject.getStringValue((Object)object));
                return;
            }
            case 116: {
                pSWFProcessBase.setUtilFormCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 117: {
                pSWFProcessBase.setUtilPSDEFormId(DataObject.getStringValue((Object)object));
                return;
            }
            case 118: {
                pSWFProcessBase.setUtilPSDEFormName(DataObject.getStringValue((Object)object));
                return;
            }
            case 119: {
                pSWFProcessBase.setWFEditViewType(DataObject.getStringValue((Object)object));
                return;
            }
            case 120: {
                pSWFProcessBase.setWFEngineType(DataObject.getStringValue((Object)object));
                return;
            }
            case 121: {
                pSWFProcessBase.setWFProcessType(DataObject.getStringValue((Object)object));
                return;
            }
            case 122: {
                pSWFProcessBase.setWFStepName(DataObject.getStringValue((Object)object));
                return;
            }
            case 123: {
                pSWFProcessBase.setWFStepValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 124: {
                pSWFProcessBase.setWidth(DataObject.getIntegerValue((Object)object));
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
        return PSWFProcessBase.isNull(this, n);
    }

    private static boolean isNull(PSWFProcessBase pSWFProcessBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWFProcessBase.getAsyncMode() == null;
            }
            case 1: {
                return pSWFProcessBase.getCodeName() == null;
            }
            case 2: {
                return pSWFProcessBase.getCreateDate() == null;
            }
            case 3: {
                return pSWFProcessBase.getCreateMan() == null;
            }
            case 4: {
                return pSWFProcessBase.getDynaModelFlag() == null;
            }
            case 5: {
                return pSWFProcessBase.getEditFields() == null;
            }
            case 6: {
                return pSWFProcessBase.getEditFlag() == null;
            }
            case 7: {
                return pSWFProcessBase.getEditPSDEFGroupId() == null;
            }
            case 8: {
                return pSWFProcessBase.getEditPSDEFGroupName() == null;
            }
            case 9: {
                return pSWFProcessBase.getEmbedPSDEDSId() == null;
            }
            case 10: {
                return pSWFProcessBase.getEmbedPSDEDSName() == null;
            }
            case 11: {
                return pSWFProcessBase.getEmbedPSDEId() == null;
            }
            case 12: {
                return pSWFProcessBase.getEmbedPSWFDEId() == null;
            }
            case 13: {
                return pSWFProcessBase.getEmbedPSWFDEName() == null;
            }
            case 14: {
                return pSWFProcessBase.getEmbedPSWFId() == null;
            }
            case 15: {
                return pSWFProcessBase.getEmbedPSWFName() == null;
            }
            case 16: {
                return pSWFProcessBase.getEnable() == null;
            }
            case 17: {
                return pSWFProcessBase.getEnableMobile() == null;
            }
            case 18: {
                return pSWFProcessBase.getEnableTimeout() == null;
            }
            case 19: {
                return pSWFProcessBase.getExitStateName() == null;
            }
            case 20: {
                return pSWFProcessBase.getExitStateValue() == null;
            }
            case 21: {
                return pSWFProcessBase.getFormCodeName() == null;
            }
            case 22: {
                return pSWFProcessBase.getHeight() == null;
            }
            case 23: {
                return pSWFProcessBase.getIconPath() == null;
            }
            case 24: {
                return pSWFProcessBase.getLeftPos() == null;
            }
            case 25: {
                return pSWFProcessBase.getMemo() == null;
            }
            case 26: {
                return pSWFProcessBase.getMemoField() == null;
            }
            case 27: {
                return pSWFProcessBase.getMobFormCodeName() == null;
            }
            case 28: {
                return pSWFProcessBase.getMobPSDEFormId() == null;
            }
            case 29: {
                return pSWFProcessBase.getMobPSDEFormName() == null;
            }
            case 30: {
                return pSWFProcessBase.getMobPSDEUAGroupId() == null;
            }
            case 31: {
                return pSWFProcessBase.getMobPSDEUAGroupName() == null;
            }
            case 32: {
                return pSWFProcessBase.getMobPSDEViewId() == null;
            }
            case 33: {
                return pSWFProcessBase.getMobPSDEViewName() == null;
            }
            case 34: {
                return pSWFProcessBase.getMobPSDynaDEViewTemplId() == null;
            }
            case 35: {
                return pSWFProcessBase.getMobUAGroupCodeName() == null;
            }
            case 36: {
                return pSWFProcessBase.getMobUtil2FormCodeName() == null;
            }
            case 37: {
                return pSWFProcessBase.getMobUtil2PSDEFormId() == null;
            }
            case 38: {
                return pSWFProcessBase.getMobUtil2PSDEFormName() == null;
            }
            case 39: {
                return pSWFProcessBase.getMobUtil3FormCodeName() == null;
            }
            case 40: {
                return pSWFProcessBase.getMobUtil3PSDEFormId() == null;
            }
            case 41: {
                return pSWFProcessBase.getMobUtil3PSDEFormName() == null;
            }
            case 42: {
                return pSWFProcessBase.getMobUtil4FormCodeName() == null;
            }
            case 43: {
                return pSWFProcessBase.getMobUtil4PSDEFormId() == null;
            }
            case 44: {
                return pSWFProcessBase.getMobUtil4PSDEFormName() == null;
            }
            case 45: {
                return pSWFProcessBase.getMobUtil5FormCodeName() == null;
            }
            case 46: {
                return pSWFProcessBase.getMobUtil5PSDEFormId() == null;
            }
            case 47: {
                return pSWFProcessBase.getMobUtil5PSDEFormName() == null;
            }
            case 48: {
                return pSWFProcessBase.getMobUtilFormCodeName() == null;
            }
            case 49: {
                return pSWFProcessBase.getMobUtilPSDEFormId() == null;
            }
            case 50: {
                return pSWFProcessBase.getMobUtilPSDEFormName() == null;
            }
            case 51: {
                return pSWFProcessBase.getMobWFEditViewType() == null;
            }
            case 52: {
                return pSWFProcessBase.getModelId() == null;
            }
            case 53: {
                return pSWFProcessBase.getMsgType() == null;
            }
            case 54: {
                return pSWFProcessBase.getMultiInstMode() == null;
            }
            case 55: {
                return pSWFProcessBase.getNamePSLanResId() == null;
            }
            case 56: {
                return pSWFProcessBase.getNamePSLanResName() == null;
            }
            case 57: {
                return pSWFProcessBase.getNormalProcType() == null;
            }
            case 58: {
                return pSWFProcessBase.getPredefinedActions() == null;
            }
            case 59: {
                return pSWFProcessBase.getPSDEActionId() == null;
            }
            case 60: {
                return pSWFProcessBase.getPSDEActionName() == null;
            }
            case 61: {
                return pSWFProcessBase.getPSDEFormId() == null;
            }
            case 62: {
                return pSWFProcessBase.getPSDEFormName() == null;
            }
            case 63: {
                return pSWFProcessBase.getPSDEId() == null;
            }
            case 64: {
                return pSWFProcessBase.getPSDEUAGroupId() == null;
            }
            case 65: {
                return pSWFProcessBase.getPSDEUAGroupName() == null;
            }
            case 66: {
                return pSWFProcessBase.getPSDEViewBaseId() == null;
            }
            case 67: {
                return pSWFProcessBase.getPSDEViewBaseName() == null;
            }
            case 68: {
                return pSWFProcessBase.getPSDynaDEViewTemplId() == null;
            }
            case 69: {
                return pSWFProcessBase.getPSDynaInstId() == null;
            }
            case 70: {
                return pSWFProcessBase.getPSSysMsgTemplId() == null;
            }
            case 71: {
                return pSWFProcessBase.getPSSysMsgTemplName() == null;
            }
            case 72: {
                return pSWFProcessBase.getPSSystemId() == null;
            }
            case 73: {
                return pSWFProcessBase.getPSWFDEId() == null;
            }
            case 74: {
                return pSWFProcessBase.getPSWFDEName() == null;
            }
            case 75: {
                return pSWFProcessBase.getPSWFId() == null;
            }
            case 76: {
                return pSWFProcessBase.getPSWFName() == null;
            }
            case 77: {
                return pSWFProcessBase.getPSWFProcessId() == null;
            }
            case 78: {
                return pSWFProcessBase.getPSWFProcessName() == null;
            }
            case 79: {
                return pSWFProcessBase.getPSWFVersionId() == null;
            }
            case 80: {
                return pSWFProcessBase.getPSWFVersionName() == null;
            }
            case 81: {
                return pSWFProcessBase.getPSWFWorkTimeId() == null;
            }
            case 82: {
                return pSWFProcessBase.getPSWFWorkTimeName() == null;
            }
            case 83: {
                return pSWFProcessBase.getRefPSWFVersionId() == null;
            }
            case 84: {
                return pSWFProcessBase.getRefPSWFVersionName() == null;
            }
            case 85: {
                return pSWFProcessBase.getSendInform() == null;
            }
            case 86: {
                return pSWFProcessBase.getShapeParams() == null;
            }
            case 87: {
                return pSWFProcessBase.getThreadName() == null;
            }
            case 88: {
                return pSWFProcessBase.getThreadSN() == null;
            }
            case 89: {
                return pSWFProcessBase.getTimeout() == null;
            }
            case 90: {
                return pSWFProcessBase.getTimeoutPSDEFId() == null;
            }
            case 91: {
                return pSWFProcessBase.getTimeoutPSDEFName() == null;
            }
            case 92: {
                return pSWFProcessBase.getTimeoutType() == null;
            }
            case 93: {
                return pSWFProcessBase.getTopPos() == null;
            }
            case 94: {
                return pSWFProcessBase.getUAGroupCodeName() == null;
            }
            case 95: {
                return pSWFProcessBase.getUpdateDate() == null;
            }
            case 96: {
                return pSWFProcessBase.getUpdateMan() == null;
            }
            case 97: {
                return pSWFProcessBase.getUserCat() == null;
            }
            case 98: {
                return pSWFProcessBase.getUserData() == null;
            }
            case 99: {
                return pSWFProcessBase.getUserData2() == null;
            }
            case 100: {
                return pSWFProcessBase.getUserTag() == null;
            }
            case 101: {
                return pSWFProcessBase.getUserTag2() == null;
            }
            case 102: {
                return pSWFProcessBase.getUserTag3() == null;
            }
            case 103: {
                return pSWFProcessBase.getUserTag4() == null;
            }
            case 104: {
                return pSWFProcessBase.getUtil2FormCodeName() == null;
            }
            case 105: {
                return pSWFProcessBase.getUtil2PSDEFormId() == null;
            }
            case 106: {
                return pSWFProcessBase.getUtil2PSDEFormName() == null;
            }
            case 107: {
                return pSWFProcessBase.getUtil3FormCodeName() == null;
            }
            case 108: {
                return pSWFProcessBase.getUtil3PSDEFormId() == null;
            }
            case 109: {
                return pSWFProcessBase.getUtil3PSDEFormName() == null;
            }
            case 110: {
                return pSWFProcessBase.getUtil4FormCodeName() == null;
            }
            case 111: {
                return pSWFProcessBase.getUtil4PSDEFormId() == null;
            }
            case 112: {
                return pSWFProcessBase.getUtil4PSDEFormName() == null;
            }
            case 113: {
                return pSWFProcessBase.getUtil5FormCodeName() == null;
            }
            case 114: {
                return pSWFProcessBase.getUtil5PSDEFormId() == null;
            }
            case 115: {
                return pSWFProcessBase.getUtil5PSDEFormName() == null;
            }
            case 116: {
                return pSWFProcessBase.getUtilFormCodeName() == null;
            }
            case 117: {
                return pSWFProcessBase.getUtilPSDEFormId() == null;
            }
            case 118: {
                return pSWFProcessBase.getUtilPSDEFormName() == null;
            }
            case 119: {
                return pSWFProcessBase.getWFEditViewType() == null;
            }
            case 120: {
                return pSWFProcessBase.getWFEngineType() == null;
            }
            case 121: {
                return pSWFProcessBase.getWFProcessType() == null;
            }
            case 122: {
                return pSWFProcessBase.getWFStepName() == null;
            }
            case 123: {
                return pSWFProcessBase.getWFStepValue() == null;
            }
            case 124: {
                return pSWFProcessBase.getWidth() == null;
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
        return PSWFProcessBase.contains(this, n);
    }

    private static boolean contains(PSWFProcessBase pSWFProcessBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWFProcessBase.isAsyncModeDirty();
            }
            case 1: {
                return pSWFProcessBase.isCodeNameDirty();
            }
            case 2: {
                return pSWFProcessBase.isCreateDateDirty();
            }
            case 3: {
                return pSWFProcessBase.isCreateManDirty();
            }
            case 4: {
                return pSWFProcessBase.isDynaModelFlagDirty();
            }
            case 5: {
                return pSWFProcessBase.isEditFieldsDirty();
            }
            case 6: {
                return pSWFProcessBase.isEditFlagDirty();
            }
            case 7: {
                return pSWFProcessBase.isEditPSDEFGroupIdDirty();
            }
            case 8: {
                return pSWFProcessBase.isEditPSDEFGroupNameDirty();
            }
            case 9: {
                return pSWFProcessBase.isEmbedPSDEDSIdDirty();
            }
            case 10: {
                return pSWFProcessBase.isEmbedPSDEDSNameDirty();
            }
            case 11: {
                return pSWFProcessBase.isEmbedPSDEIdDirty();
            }
            case 12: {
                return pSWFProcessBase.isEmbedPSWFDEIdDirty();
            }
            case 13: {
                return pSWFProcessBase.isEmbedPSWFDENameDirty();
            }
            case 14: {
                return pSWFProcessBase.isEmbedPSWFIdDirty();
            }
            case 15: {
                return pSWFProcessBase.isEmbedPSWFNameDirty();
            }
            case 16: {
                return pSWFProcessBase.isEnableDirty();
            }
            case 17: {
                return pSWFProcessBase.isEnableMobileDirty();
            }
            case 18: {
                return pSWFProcessBase.isEnableTimeoutDirty();
            }
            case 19: {
                return pSWFProcessBase.isExitStateNameDirty();
            }
            case 20: {
                return pSWFProcessBase.isExitStateValueDirty();
            }
            case 21: {
                return pSWFProcessBase.isFormCodeNameDirty();
            }
            case 22: {
                return pSWFProcessBase.isHeightDirty();
            }
            case 23: {
                return pSWFProcessBase.isIconPathDirty();
            }
            case 24: {
                return pSWFProcessBase.isLeftPosDirty();
            }
            case 25: {
                return pSWFProcessBase.isMemoDirty();
            }
            case 26: {
                return pSWFProcessBase.isMemoFieldDirty();
            }
            case 27: {
                return pSWFProcessBase.isMobFormCodeNameDirty();
            }
            case 28: {
                return pSWFProcessBase.isMobPSDEFormIdDirty();
            }
            case 29: {
                return pSWFProcessBase.isMobPSDEFormNameDirty();
            }
            case 30: {
                return pSWFProcessBase.isMobPSDEUAGroupIdDirty();
            }
            case 31: {
                return pSWFProcessBase.isMobPSDEUAGroupNameDirty();
            }
            case 32: {
                return pSWFProcessBase.isMobPSDEViewIdDirty();
            }
            case 33: {
                return pSWFProcessBase.isMobPSDEViewNameDirty();
            }
            case 34: {
                return pSWFProcessBase.isMobPSDynaDEViewTemplIdDirty();
            }
            case 35: {
                return pSWFProcessBase.isMobUAGroupCodeNameDirty();
            }
            case 36: {
                return pSWFProcessBase.isMobUtil2FormCodeNameDirty();
            }
            case 37: {
                return pSWFProcessBase.isMobUtil2PSDEFormIdDirty();
            }
            case 38: {
                return pSWFProcessBase.isMobUtil2PSDEFormNameDirty();
            }
            case 39: {
                return pSWFProcessBase.isMobUtil3FormCodeNameDirty();
            }
            case 40: {
                return pSWFProcessBase.isMobUtil3PSDEFormIdDirty();
            }
            case 41: {
                return pSWFProcessBase.isMobUtil3PSDEFormNameDirty();
            }
            case 42: {
                return pSWFProcessBase.isMobUtil4FormCodeNameDirty();
            }
            case 43: {
                return pSWFProcessBase.isMobUtil4PSDEFormIdDirty();
            }
            case 44: {
                return pSWFProcessBase.isMobUtil4PSDEFormNameDirty();
            }
            case 45: {
                return pSWFProcessBase.isMobUtil5FormCodeNameDirty();
            }
            case 46: {
                return pSWFProcessBase.isMobUtil5PSDEFormIdDirty();
            }
            case 47: {
                return pSWFProcessBase.isMobUtil5PSDEFormNameDirty();
            }
            case 48: {
                return pSWFProcessBase.isMobUtilFormCodeNameDirty();
            }
            case 49: {
                return pSWFProcessBase.isMobUtilPSDEFormIdDirty();
            }
            case 50: {
                return pSWFProcessBase.isMobUtilPSDEFormNameDirty();
            }
            case 51: {
                return pSWFProcessBase.isMobWFEditViewTypeDirty();
            }
            case 52: {
                return pSWFProcessBase.isModelIdDirty();
            }
            case 53: {
                return pSWFProcessBase.isMsgTypeDirty();
            }
            case 54: {
                return pSWFProcessBase.isMultiInstModeDirty();
            }
            case 55: {
                return pSWFProcessBase.isNamePSLanResIdDirty();
            }
            case 56: {
                return pSWFProcessBase.isNamePSLanResNameDirty();
            }
            case 57: {
                return pSWFProcessBase.isNormalProcTypeDirty();
            }
            case 58: {
                return pSWFProcessBase.isPredefinedActionsDirty();
            }
            case 59: {
                return pSWFProcessBase.isPSDEActionIdDirty();
            }
            case 60: {
                return pSWFProcessBase.isPSDEActionNameDirty();
            }
            case 61: {
                return pSWFProcessBase.isPSDEFormIdDirty();
            }
            case 62: {
                return pSWFProcessBase.isPSDEFormNameDirty();
            }
            case 63: {
                return pSWFProcessBase.isPSDEIdDirty();
            }
            case 64: {
                return pSWFProcessBase.isPSDEUAGroupIdDirty();
            }
            case 65: {
                return pSWFProcessBase.isPSDEUAGroupNameDirty();
            }
            case 66: {
                return pSWFProcessBase.isPSDEViewBaseIdDirty();
            }
            case 67: {
                return pSWFProcessBase.isPSDEViewBaseNameDirty();
            }
            case 68: {
                return pSWFProcessBase.isPSDynaDEViewTemplIdDirty();
            }
            case 69: {
                return pSWFProcessBase.isPSDynaInstIdDirty();
            }
            case 70: {
                return pSWFProcessBase.isPSSysMsgTemplIdDirty();
            }
            case 71: {
                return pSWFProcessBase.isPSSysMsgTemplNameDirty();
            }
            case 72: {
                return pSWFProcessBase.isPSSystemIdDirty();
            }
            case 73: {
                return pSWFProcessBase.isPSWFDEIdDirty();
            }
            case 74: {
                return pSWFProcessBase.isPSWFDENameDirty();
            }
            case 75: {
                return pSWFProcessBase.isPSWFIdDirty();
            }
            case 76: {
                return pSWFProcessBase.isPSWFNameDirty();
            }
            case 77: {
                return pSWFProcessBase.isPSWFProcessIdDirty();
            }
            case 78: {
                return pSWFProcessBase.isPSWFProcessNameDirty();
            }
            case 79: {
                return pSWFProcessBase.isPSWFVersionIdDirty();
            }
            case 80: {
                return pSWFProcessBase.isPSWFVersionNameDirty();
            }
            case 81: {
                return pSWFProcessBase.isPSWFWorkTimeIdDirty();
            }
            case 82: {
                return pSWFProcessBase.isPSWFWorkTimeNameDirty();
            }
            case 83: {
                return pSWFProcessBase.isRefPSWFVersionIdDirty();
            }
            case 84: {
                return pSWFProcessBase.isRefPSWFVersionNameDirty();
            }
            case 85: {
                return pSWFProcessBase.isSendInformDirty();
            }
            case 86: {
                return pSWFProcessBase.isShapeParamsDirty();
            }
            case 87: {
                return pSWFProcessBase.isThreadNameDirty();
            }
            case 88: {
                return pSWFProcessBase.isThreadSNDirty();
            }
            case 89: {
                return pSWFProcessBase.isTimeoutDirty();
            }
            case 90: {
                return pSWFProcessBase.isTimeoutPSDEFIdDirty();
            }
            case 91: {
                return pSWFProcessBase.isTimeoutPSDEFNameDirty();
            }
            case 92: {
                return pSWFProcessBase.isTimeoutTypeDirty();
            }
            case 93: {
                return pSWFProcessBase.isTopPosDirty();
            }
            case 94: {
                return pSWFProcessBase.isUAGroupCodeNameDirty();
            }
            case 95: {
                return pSWFProcessBase.isUpdateDateDirty();
            }
            case 96: {
                return pSWFProcessBase.isUpdateManDirty();
            }
            case 97: {
                return pSWFProcessBase.isUserCatDirty();
            }
            case 98: {
                return pSWFProcessBase.isUserDataDirty();
            }
            case 99: {
                return pSWFProcessBase.isUserData2Dirty();
            }
            case 100: {
                return pSWFProcessBase.isUserTagDirty();
            }
            case 101: {
                return pSWFProcessBase.isUserTag2Dirty();
            }
            case 102: {
                return pSWFProcessBase.isUserTag3Dirty();
            }
            case 103: {
                return pSWFProcessBase.isUserTag4Dirty();
            }
            case 104: {
                return pSWFProcessBase.isUtil2FormCodeNameDirty();
            }
            case 105: {
                return pSWFProcessBase.isUtil2PSDEFormIdDirty();
            }
            case 106: {
                return pSWFProcessBase.isUtil2PSDEFormNameDirty();
            }
            case 107: {
                return pSWFProcessBase.isUtil3FormCodeNameDirty();
            }
            case 108: {
                return pSWFProcessBase.isUtil3PSDEFormIdDirty();
            }
            case 109: {
                return pSWFProcessBase.isUtil3PSDEFormNameDirty();
            }
            case 110: {
                return pSWFProcessBase.isUtil4FormCodeNameDirty();
            }
            case 111: {
                return pSWFProcessBase.isUtil4PSDEFormIdDirty();
            }
            case 112: {
                return pSWFProcessBase.isUtil4PSDEFormNameDirty();
            }
            case 113: {
                return pSWFProcessBase.isUtil5FormCodeNameDirty();
            }
            case 114: {
                return pSWFProcessBase.isUtil5PSDEFormIdDirty();
            }
            case 115: {
                return pSWFProcessBase.isUtil5PSDEFormNameDirty();
            }
            case 116: {
                return pSWFProcessBase.isUtilFormCodeNameDirty();
            }
            case 117: {
                return pSWFProcessBase.isUtilPSDEFormIdDirty();
            }
            case 118: {
                return pSWFProcessBase.isUtilPSDEFormNameDirty();
            }
            case 119: {
                return pSWFProcessBase.isWFEditViewTypeDirty();
            }
            case 120: {
                return pSWFProcessBase.isWFEngineTypeDirty();
            }
            case 121: {
                return pSWFProcessBase.isWFProcessTypeDirty();
            }
            case 122: {
                return pSWFProcessBase.isWFStepNameDirty();
            }
            case 123: {
                return pSWFProcessBase.isWFStepValueDirty();
            }
            case 124: {
                return pSWFProcessBase.isWidthDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSWFProcessBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSWFProcessBase pSWFProcessBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSWFProcessBase.getAsyncMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"asyncmode", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getAsyncMode()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getCodeName()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getEditFields() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"editfields", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getEditFields()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getEditFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"editflag", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getEditFlag()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getEditPSDEFGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"editpsdefgroupid", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getEditPSDEFGroupId()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getEditPSDEFGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"editpsdefgroupname", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getEditPSDEFGroupName()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getEmbedPSDEDSId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"embedpsdedsid", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getEmbedPSDEDSId()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getEmbedPSDEDSName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"embedpsdedsname", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getEmbedPSDEDSName()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getEmbedPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"embedpsdeid", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getEmbedPSDEId()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getEmbedPSWFDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"embedpswfdeid", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getEmbedPSWFDEId()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getEmbedPSWFDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"embedpswfdename", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getEmbedPSWFDEName()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getEmbedPSWFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"embedpswfid", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getEmbedPSWFId()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getEmbedPSWFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"embedpswfname", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getEmbedPSWFName()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getEnable() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enable", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getEnable()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getEnableMobile() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablemobile", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getEnableMobile()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getEnableTimeout() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enabletimeout", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getEnableTimeout()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getExitStateName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"exitstatename", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getExitStateName()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getExitStateValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"exitstatevalue", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getExitStateValue()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getFormCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"formcodename", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getFormCodeName()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getHeight() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"height", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getHeight()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getIconPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"iconpath", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getIconPath()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getLeftPos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"leftpos", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getLeftPos()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getMemo()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getMemoField() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memofield", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getMemoField()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getMobFormCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobformcodename", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getMobFormCodeName()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getMobPSDEFormId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobpsdeformid", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getMobPSDEFormId()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getMobPSDEFormName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobpsdeformname", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getMobPSDEFormName()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getMobPSDEUAGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobpsdeuagroupid", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getMobPSDEUAGroupId()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getMobPSDEUAGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobpsdeuagroupname", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getMobPSDEUAGroupName()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getMobPSDEViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobpsdeviewid", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getMobPSDEViewId()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getMobPSDEViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobpsdeviewname", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getMobPSDEViewName()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getMobPSDynaDEViewTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobpsdynadeviewtemplid", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getMobPSDynaDEViewTemplId()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getMobUAGroupCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobuagroupcodename", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getMobUAGroupCodeName()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getMobUtil2FormCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobutil2formcodename", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getMobUtil2FormCodeName()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getMobUtil2PSDEFormId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobutil2psdeformid", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getMobUtil2PSDEFormId()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getMobUtil2PSDEFormName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobutil2psdeformname", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getMobUtil2PSDEFormName()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getMobUtil3FormCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobutil3formcodename", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getMobUtil3FormCodeName()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getMobUtil3PSDEFormId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobutil3psdeformid", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getMobUtil3PSDEFormId()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getMobUtil3PSDEFormName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobutil3psdeformname", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getMobUtil3PSDEFormName()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getMobUtil4FormCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobutil4formcodename", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getMobUtil4FormCodeName()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getMobUtil4PSDEFormId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobutil4psdeformid", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getMobUtil4PSDEFormId()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getMobUtil4PSDEFormName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobutil4psdeformname", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getMobUtil4PSDEFormName()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getMobUtil5FormCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobutil5formcodename", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getMobUtil5FormCodeName()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getMobUtil5PSDEFormId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobutil5psdeformid", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getMobUtil5PSDEFormId()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getMobUtil5PSDEFormName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobutil5psdeformname", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getMobUtil5PSDEFormName()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getMobUtilFormCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobutilformcodename", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getMobUtilFormCodeName()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getMobUtilPSDEFormId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobutilpsdeformid", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getMobUtilPSDEFormId()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getMobUtilPSDEFormName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobutilpsdeformname", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getMobUtilPSDEFormName()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getMobWFEditViewType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobwfeditviewtype", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getMobWFEditViewType()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modelid", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getModelId()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getMsgType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"msgtype", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getMsgType()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getMultiInstMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"multiinstmode", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getMultiInstMode()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getNamePSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"namepslanresid", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getNamePSLanResId()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getNamePSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"namepslanresname", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getNamePSLanResName()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getNormalProcType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"normalproctype", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getNormalProcType()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getPredefinedActions() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"predefinedactions", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getPredefinedActions()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getPSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactionid", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getPSDEActionId()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getPSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactionname", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getPSDEActionName()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getPSDEFormId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeformid", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getPSDEFormId()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getPSDEFormName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeformname", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getPSDEFormName()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getPSDEUAGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuagroupid", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getPSDEUAGroupId()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getPSDEUAGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuagroupname", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getPSDEUAGroupName()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getPSDEViewBaseId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewbaseid", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getPSDEViewBaseId()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getPSDEViewBaseName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewbasename", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getPSDEViewBaseName()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getPSDynaDEViewTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynadeviewtemplid", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getPSDynaDEViewTemplId()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getPSSysMsgTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmsgtemplid", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getPSSysMsgTemplId()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getPSSysMsgTemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmsgtemplname", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getPSSysMsgTemplName()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getPSWFDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfdeid", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getPSWFDEId()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getPSWFDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfdename", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getPSWFDEName()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getPSWFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfid", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getPSWFId()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getPSWFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfname", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getPSWFName()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getPSWFProcessId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfprocessid", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getPSWFProcessId()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getPSWFProcessName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfprocessname", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getPSWFProcessName()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getPSWFVersionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfversionid", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getPSWFVersionId()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getPSWFVersionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfversionname", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getPSWFVersionName()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getPSWFWorkTimeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfworktimeid", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getPSWFWorkTimeId()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getPSWFWorkTimeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfworktimename", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getPSWFWorkTimeName()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getRefPSWFVersionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpswfversionid", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getRefPSWFVersionId()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getRefPSWFVersionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpswfversionname", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getRefPSWFVersionName()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getSendInform() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sendinform", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getSendInform()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getShapeParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"shapeparams", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getShapeParams()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getThreadName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"threadname", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getThreadName()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getThreadSN() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"threadsn", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getThreadSN()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getTimeout() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"timeout", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getTimeout()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getTimeoutPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"timeoutpsdefid", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getTimeoutPSDEFId()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getTimeoutPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"timeoutpsdefname", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getTimeoutPSDEFName()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getTimeoutType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"timeouttype", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getTimeoutType()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getTopPos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"toppos", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getTopPos()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getUAGroupCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uagroupcodename", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getUAGroupCodeName()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getUserCat()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getUserData() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userdata", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getUserData()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getUserData2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userdata2", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getUserData2()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getUserTag()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getUtil2FormCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"util2formcodename", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getUtil2FormCodeName()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getUtil2PSDEFormId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"util2psdeformid", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getUtil2PSDEFormId()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getUtil2PSDEFormName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"util2psdeformname", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getUtil2PSDEFormName()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getUtil3FormCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"util3formcodename", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getUtil3FormCodeName()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getUtil3PSDEFormId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"util3psdeformid", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getUtil3PSDEFormId()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getUtil3PSDEFormName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"util3psdeformname", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getUtil3PSDEFormName()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getUtil4FormCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"util4formcodename", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getUtil4FormCodeName()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getUtil4PSDEFormId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"util4psdeformid", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getUtil4PSDEFormId()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getUtil4PSDEFormName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"util4psdeformname", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getUtil4PSDEFormName()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getUtil5FormCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"util5formcodename", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getUtil5FormCodeName()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getUtil5PSDEFormId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"util5psdeformid", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getUtil5PSDEFormId()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getUtil5PSDEFormName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"util5psdeformname", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getUtil5PSDEFormName()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getUtilFormCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilformcodename", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getUtilFormCodeName()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getUtilPSDEFormId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsdeformid", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getUtilPSDEFormId()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getUtilPSDEFormName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsdeformname", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getUtilPSDEFormName()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getWFEditViewType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wfeditviewtype", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getWFEditViewType()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getWFEngineType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wfenginetype", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getWFEngineType()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getWFProcessType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wfprocesstype", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getWFProcessType()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getWFStepName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wfstepname", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getWFStepName()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getWFStepValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wfstepvalue", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getWFStepValue()), (boolean)false);
        }
        if (bl || pSWFProcessBase.getWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"width", (Object)PSWFProcessBase.getJSONValue((Object)pSWFProcessBase.getWidth()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSWFProcessBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSWFProcessBase pSWFProcessBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSWFProcessBase.getAsyncMode() != null) {
            object = pSWFProcessBase.getAsyncMode();
            xmlNode.setAttribute(FIELD_ASYNCMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWFProcessBase.getCodeName() != null) {
            object = pSWFProcessBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getCreateDate() != null) {
            object = pSWFProcessBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWFProcessBase.getCreateMan() != null) {
            object = pSWFProcessBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getDynaModelFlag() != null) {
            object = pSWFProcessBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWFProcessBase.getEditFields() != null) {
            object = pSWFProcessBase.getEditFields();
            xmlNode.setAttribute(FIELD_EDITFIELDS, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getEditFlag() != null) {
            object = pSWFProcessBase.getEditFlag();
            xmlNode.setAttribute(FIELD_EDITFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWFProcessBase.getEditPSDEFGroupId() != null) {
            object = pSWFProcessBase.getEditPSDEFGroupId();
            xmlNode.setAttribute(FIELD_EDITPSDEFGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getEditPSDEFGroupName() != null) {
            object = pSWFProcessBase.getEditPSDEFGroupName();
            xmlNode.setAttribute(FIELD_EDITPSDEFGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getEmbedPSDEDSId() != null) {
            object = pSWFProcessBase.getEmbedPSDEDSId();
            xmlNode.setAttribute(FIELD_EMBEDPSDEDSID, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getEmbedPSDEDSName() != null) {
            object = pSWFProcessBase.getEmbedPSDEDSName();
            xmlNode.setAttribute(FIELD_EMBEDPSDEDSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getEmbedPSDEId() != null) {
            object = pSWFProcessBase.getEmbedPSDEId();
            xmlNode.setAttribute(FIELD_EMBEDPSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getEmbedPSWFDEId() != null) {
            object = pSWFProcessBase.getEmbedPSWFDEId();
            xmlNode.setAttribute(FIELD_EMBEDPSWFDEID, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getEmbedPSWFDEName() != null) {
            object = pSWFProcessBase.getEmbedPSWFDEName();
            xmlNode.setAttribute(FIELD_EMBEDPSWFDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getEmbedPSWFId() != null) {
            object = pSWFProcessBase.getEmbedPSWFId();
            xmlNode.setAttribute(FIELD_EMBEDPSWFID, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getEmbedPSWFName() != null) {
            object = pSWFProcessBase.getEmbedPSWFName();
            xmlNode.setAttribute(FIELD_EMBEDPSWFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getEnable() != null) {
            object = pSWFProcessBase.getEnable();
            xmlNode.setAttribute(FIELD_ENABLE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWFProcessBase.getEnableMobile() != null) {
            object = pSWFProcessBase.getEnableMobile();
            xmlNode.setAttribute(FIELD_ENABLEMOBILE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWFProcessBase.getEnableTimeout() != null) {
            object = pSWFProcessBase.getEnableTimeout();
            xmlNode.setAttribute(FIELD_ENABLETIMEOUT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWFProcessBase.getExitStateName() != null) {
            object = pSWFProcessBase.getExitStateName();
            xmlNode.setAttribute(FIELD_EXITSTATENAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getExitStateValue() != null) {
            object = pSWFProcessBase.getExitStateValue();
            xmlNode.setAttribute(FIELD_EXITSTATEVALUE, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getFormCodeName() != null) {
            object = pSWFProcessBase.getFormCodeName();
            xmlNode.setAttribute(FIELD_FORMCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getHeight() != null) {
            object = pSWFProcessBase.getHeight();
            xmlNode.setAttribute(FIELD_HEIGHT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWFProcessBase.getIconPath() != null) {
            object = pSWFProcessBase.getIconPath();
            xmlNode.setAttribute(FIELD_ICONPATH, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getLeftPos() != null) {
            object = pSWFProcessBase.getLeftPos();
            xmlNode.setAttribute(FIELD_LEFTPOS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWFProcessBase.getMemo() != null) {
            object = pSWFProcessBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getMemoField() != null) {
            object = pSWFProcessBase.getMemoField();
            xmlNode.setAttribute(FIELD_MEMOFIELD, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getMobFormCodeName() != null) {
            object = pSWFProcessBase.getMobFormCodeName();
            xmlNode.setAttribute(FIELD_MOBFORMCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getMobPSDEFormId() != null) {
            object = pSWFProcessBase.getMobPSDEFormId();
            xmlNode.setAttribute(FIELD_MOBPSDEFORMID, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getMobPSDEFormName() != null) {
            object = pSWFProcessBase.getMobPSDEFormName();
            xmlNode.setAttribute(FIELD_MOBPSDEFORMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getMobPSDEUAGroupId() != null) {
            object = pSWFProcessBase.getMobPSDEUAGroupId();
            xmlNode.setAttribute(FIELD_MOBPSDEUAGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getMobPSDEUAGroupName() != null) {
            object = pSWFProcessBase.getMobPSDEUAGroupName();
            xmlNode.setAttribute(FIELD_MOBPSDEUAGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getMobPSDEViewId() != null) {
            object = pSWFProcessBase.getMobPSDEViewId();
            xmlNode.setAttribute(FIELD_MOBPSDEVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getMobPSDEViewName() != null) {
            object = pSWFProcessBase.getMobPSDEViewName();
            xmlNode.setAttribute(FIELD_MOBPSDEVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getMobPSDynaDEViewTemplId() != null) {
            object = pSWFProcessBase.getMobPSDynaDEViewTemplId();
            xmlNode.setAttribute(FIELD_MOBPSDYNADEVIEWTEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getMobUAGroupCodeName() != null) {
            object = pSWFProcessBase.getMobUAGroupCodeName();
            xmlNode.setAttribute(FIELD_MOBUAGROUPCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getMobUtil2FormCodeName() != null) {
            object = pSWFProcessBase.getMobUtil2FormCodeName();
            xmlNode.setAttribute(FIELD_MOBUTIL2FORMCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getMobUtil2PSDEFormId() != null) {
            object = pSWFProcessBase.getMobUtil2PSDEFormId();
            xmlNode.setAttribute(FIELD_MOBUTIL2PSDEFORMID, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getMobUtil2PSDEFormName() != null) {
            object = pSWFProcessBase.getMobUtil2PSDEFormName();
            xmlNode.setAttribute(FIELD_MOBUTIL2PSDEFORMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getMobUtil3FormCodeName() != null) {
            object = pSWFProcessBase.getMobUtil3FormCodeName();
            xmlNode.setAttribute(FIELD_MOBUTIL3FORMCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getMobUtil3PSDEFormId() != null) {
            object = pSWFProcessBase.getMobUtil3PSDEFormId();
            xmlNode.setAttribute(FIELD_MOBUTIL3PSDEFORMID, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getMobUtil3PSDEFormName() != null) {
            object = pSWFProcessBase.getMobUtil3PSDEFormName();
            xmlNode.setAttribute(FIELD_MOBUTIL3PSDEFORMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getMobUtil4FormCodeName() != null) {
            object = pSWFProcessBase.getMobUtil4FormCodeName();
            xmlNode.setAttribute(FIELD_MOBUTIL4FORMCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getMobUtil4PSDEFormId() != null) {
            object = pSWFProcessBase.getMobUtil4PSDEFormId();
            xmlNode.setAttribute(FIELD_MOBUTIL4PSDEFORMID, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getMobUtil4PSDEFormName() != null) {
            object = pSWFProcessBase.getMobUtil4PSDEFormName();
            xmlNode.setAttribute(FIELD_MOBUTIL4PSDEFORMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getMobUtil5FormCodeName() != null) {
            object = pSWFProcessBase.getMobUtil5FormCodeName();
            xmlNode.setAttribute(FIELD_MOBUTIL5FORMCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getMobUtil5PSDEFormId() != null) {
            object = pSWFProcessBase.getMobUtil5PSDEFormId();
            xmlNode.setAttribute(FIELD_MOBUTIL5PSDEFORMID, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getMobUtil5PSDEFormName() != null) {
            object = pSWFProcessBase.getMobUtil5PSDEFormName();
            xmlNode.setAttribute(FIELD_MOBUTIL5PSDEFORMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getMobUtilFormCodeName() != null) {
            object = pSWFProcessBase.getMobUtilFormCodeName();
            xmlNode.setAttribute(FIELD_MOBUTILFORMCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getMobUtilPSDEFormId() != null) {
            object = pSWFProcessBase.getMobUtilPSDEFormId();
            xmlNode.setAttribute(FIELD_MOBUTILPSDEFORMID, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getMobUtilPSDEFormName() != null) {
            object = pSWFProcessBase.getMobUtilPSDEFormName();
            xmlNode.setAttribute(FIELD_MOBUTILPSDEFORMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getMobWFEditViewType() != null) {
            object = pSWFProcessBase.getMobWFEditViewType();
            xmlNode.setAttribute(FIELD_MOBWFEDITVIEWTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getModelId() != null) {
            object = pSWFProcessBase.getModelId();
            xmlNode.setAttribute(FIELD_MODELID, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getMsgType() != null) {
            object = pSWFProcessBase.getMsgType();
            xmlNode.setAttribute(FIELD_MSGTYPE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWFProcessBase.getMultiInstMode() != null) {
            object = pSWFProcessBase.getMultiInstMode();
            xmlNode.setAttribute(FIELD_MULTIINSTMODE, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getNamePSLanResId() != null) {
            object = pSWFProcessBase.getNamePSLanResId();
            xmlNode.setAttribute(FIELD_NAMEPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getNamePSLanResName() != null) {
            object = pSWFProcessBase.getNamePSLanResName();
            xmlNode.setAttribute(FIELD_NAMEPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getNormalProcType() != null) {
            object = pSWFProcessBase.getNormalProcType();
            xmlNode.setAttribute(FIELD_NORMALPROCTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getPredefinedActions() != null) {
            object = pSWFProcessBase.getPredefinedActions();
            xmlNode.setAttribute(FIELD_PREDEFINEDACTIONS, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getPSDEActionId() != null) {
            object = pSWFProcessBase.getPSDEActionId();
            xmlNode.setAttribute(FIELD_PSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getPSDEActionName() != null) {
            object = pSWFProcessBase.getPSDEActionName();
            xmlNode.setAttribute(FIELD_PSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getPSDEFormId() != null) {
            object = pSWFProcessBase.getPSDEFormId();
            xmlNode.setAttribute(FIELD_PSDEFORMID, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getPSDEFormName() != null) {
            object = pSWFProcessBase.getPSDEFormName();
            xmlNode.setAttribute(FIELD_PSDEFORMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getPSDEId() != null) {
            object = pSWFProcessBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getPSDEUAGroupId() != null) {
            object = pSWFProcessBase.getPSDEUAGroupId();
            xmlNode.setAttribute(FIELD_PSDEUAGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getPSDEUAGroupName() != null) {
            object = pSWFProcessBase.getPSDEUAGroupName();
            xmlNode.setAttribute(FIELD_PSDEUAGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getPSDEViewBaseId() != null) {
            object = pSWFProcessBase.getPSDEViewBaseId();
            xmlNode.setAttribute(FIELD_PSDEVIEWBASEID, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getPSDEViewBaseName() != null) {
            object = pSWFProcessBase.getPSDEViewBaseName();
            xmlNode.setAttribute(FIELD_PSDEVIEWBASENAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getPSDynaDEViewTemplId() != null) {
            object = pSWFProcessBase.getPSDynaDEViewTemplId();
            xmlNode.setAttribute(FIELD_PSDYNADEVIEWTEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getPSDynaInstId() != null) {
            object = pSWFProcessBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getPSSysMsgTemplId() != null) {
            object = pSWFProcessBase.getPSSysMsgTemplId();
            xmlNode.setAttribute(FIELD_PSSYSMSGTEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getPSSysMsgTemplName() != null) {
            object = pSWFProcessBase.getPSSysMsgTemplName();
            xmlNode.setAttribute(FIELD_PSSYSMSGTEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getPSSystemId() != null) {
            object = pSWFProcessBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getPSWFDEId() != null) {
            object = pSWFProcessBase.getPSWFDEId();
            xmlNode.setAttribute(FIELD_PSWFDEID, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getPSWFDEName() != null) {
            object = pSWFProcessBase.getPSWFDEName();
            xmlNode.setAttribute(FIELD_PSWFDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getPSWFId() != null) {
            object = pSWFProcessBase.getPSWFId();
            xmlNode.setAttribute(FIELD_PSWFID, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getPSWFName() != null) {
            object = pSWFProcessBase.getPSWFName();
            xmlNode.setAttribute(FIELD_PSWFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getPSWFProcessId() != null) {
            object = pSWFProcessBase.getPSWFProcessId();
            xmlNode.setAttribute(FIELD_PSWFPROCESSID, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getPSWFProcessName() != null) {
            object = pSWFProcessBase.getPSWFProcessName();
            xmlNode.setAttribute(FIELD_PSWFPROCESSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getPSWFVersionId() != null) {
            object = pSWFProcessBase.getPSWFVersionId();
            xmlNode.setAttribute(FIELD_PSWFVERSIONID, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getPSWFVersionName() != null) {
            object = pSWFProcessBase.getPSWFVersionName();
            xmlNode.setAttribute(FIELD_PSWFVERSIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getPSWFWorkTimeId() != null) {
            object = pSWFProcessBase.getPSWFWorkTimeId();
            xmlNode.setAttribute(FIELD_PSWFWORKTIMEID, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getPSWFWorkTimeName() != null) {
            object = pSWFProcessBase.getPSWFWorkTimeName();
            xmlNode.setAttribute(FIELD_PSWFWORKTIMENAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getRefPSWFVersionId() != null) {
            object = pSWFProcessBase.getRefPSWFVersionId();
            xmlNode.setAttribute(FIELD_REFPSWFVERSIONID, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getRefPSWFVersionName() != null) {
            object = pSWFProcessBase.getRefPSWFVersionName();
            xmlNode.setAttribute(FIELD_REFPSWFVERSIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getSendInform() != null) {
            object = pSWFProcessBase.getSendInform();
            xmlNode.setAttribute(FIELD_SENDINFORM, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWFProcessBase.getShapeParams() != null) {
            object = pSWFProcessBase.getShapeParams();
            xmlNode.setAttribute(FIELD_SHAPEPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getThreadName() != null) {
            object = pSWFProcessBase.getThreadName();
            xmlNode.setAttribute(FIELD_THREADNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getThreadSN() != null) {
            object = pSWFProcessBase.getThreadSN();
            xmlNode.setAttribute(FIELD_THREADSN, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWFProcessBase.getTimeout() != null) {
            object = pSWFProcessBase.getTimeout();
            xmlNode.setAttribute(FIELD_TIMEOUT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWFProcessBase.getTimeoutPSDEFId() != null) {
            object = pSWFProcessBase.getTimeoutPSDEFId();
            xmlNode.setAttribute(FIELD_TIMEOUTPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getTimeoutPSDEFName() != null) {
            object = pSWFProcessBase.getTimeoutPSDEFName();
            xmlNode.setAttribute(FIELD_TIMEOUTPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getTimeoutType() != null) {
            object = pSWFProcessBase.getTimeoutType();
            xmlNode.setAttribute(FIELD_TIMEOUTTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getTopPos() != null) {
            object = pSWFProcessBase.getTopPos();
            xmlNode.setAttribute(FIELD_TOPPOS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWFProcessBase.getUAGroupCodeName() != null) {
            object = pSWFProcessBase.getUAGroupCodeName();
            xmlNode.setAttribute(FIELD_UAGROUPCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getUpdateDate() != null) {
            object = pSWFProcessBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWFProcessBase.getUpdateMan() != null) {
            object = pSWFProcessBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getUserCat() != null) {
            object = pSWFProcessBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getUserData() != null) {
            object = pSWFProcessBase.getUserData();
            xmlNode.setAttribute(FIELD_USERDATA, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getUserData2() != null) {
            object = pSWFProcessBase.getUserData2();
            xmlNode.setAttribute(FIELD_USERDATA2, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getUserTag() != null) {
            object = pSWFProcessBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getUserTag2() != null) {
            object = pSWFProcessBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getUserTag3() != null) {
            object = pSWFProcessBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getUserTag4() != null) {
            object = pSWFProcessBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getUtil2FormCodeName() != null) {
            object = pSWFProcessBase.getUtil2FormCodeName();
            xmlNode.setAttribute(FIELD_UTIL2FORMCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getUtil2PSDEFormId() != null) {
            object = pSWFProcessBase.getUtil2PSDEFormId();
            xmlNode.setAttribute(FIELD_UTIL2PSDEFORMID, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getUtil2PSDEFormName() != null) {
            object = pSWFProcessBase.getUtil2PSDEFormName();
            xmlNode.setAttribute(FIELD_UTIL2PSDEFORMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getUtil3FormCodeName() != null) {
            object = pSWFProcessBase.getUtil3FormCodeName();
            xmlNode.setAttribute(FIELD_UTIL3FORMCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getUtil3PSDEFormId() != null) {
            object = pSWFProcessBase.getUtil3PSDEFormId();
            xmlNode.setAttribute(FIELD_UTIL3PSDEFORMID, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getUtil3PSDEFormName() != null) {
            object = pSWFProcessBase.getUtil3PSDEFormName();
            xmlNode.setAttribute(FIELD_UTIL3PSDEFORMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getUtil4FormCodeName() != null) {
            object = pSWFProcessBase.getUtil4FormCodeName();
            xmlNode.setAttribute(FIELD_UTIL4FORMCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getUtil4PSDEFormId() != null) {
            object = pSWFProcessBase.getUtil4PSDEFormId();
            xmlNode.setAttribute(FIELD_UTIL4PSDEFORMID, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getUtil4PSDEFormName() != null) {
            object = pSWFProcessBase.getUtil4PSDEFormName();
            xmlNode.setAttribute(FIELD_UTIL4PSDEFORMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getUtil5FormCodeName() != null) {
            object = pSWFProcessBase.getUtil5FormCodeName();
            xmlNode.setAttribute(FIELD_UTIL5FORMCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getUtil5PSDEFormId() != null) {
            object = pSWFProcessBase.getUtil5PSDEFormId();
            xmlNode.setAttribute(FIELD_UTIL5PSDEFORMID, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getUtil5PSDEFormName() != null) {
            object = pSWFProcessBase.getUtil5PSDEFormName();
            xmlNode.setAttribute(FIELD_UTIL5PSDEFORMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getUtilFormCodeName() != null) {
            object = pSWFProcessBase.getUtilFormCodeName();
            xmlNode.setAttribute(FIELD_UTILFORMCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getUtilPSDEFormId() != null) {
            object = pSWFProcessBase.getUtilPSDEFormId();
            xmlNode.setAttribute(FIELD_UTILPSDEFORMID, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getUtilPSDEFormName() != null) {
            object = pSWFProcessBase.getUtilPSDEFormName();
            xmlNode.setAttribute(FIELD_UTILPSDEFORMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getWFEditViewType() != null) {
            object = pSWFProcessBase.getWFEditViewType();
            xmlNode.setAttribute(FIELD_WFEDITVIEWTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getWFEngineType() != null) {
            object = pSWFProcessBase.getWFEngineType();
            xmlNode.setAttribute(FIELD_WFENGINETYPE, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getWFProcessType() != null) {
            object = pSWFProcessBase.getWFProcessType();
            xmlNode.setAttribute(FIELD_WFPROCESSTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getWFStepName() != null) {
            object = pSWFProcessBase.getWFStepName();
            xmlNode.setAttribute(FIELD_WFSTEPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getWFStepValue() != null) {
            object = pSWFProcessBase.getWFStepValue();
            xmlNode.setAttribute(FIELD_WFSTEPVALUE, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessBase.getWidth() != null) {
            object = pSWFProcessBase.getWidth();
            xmlNode.setAttribute(FIELD_WIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSWFProcessBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSWFProcessBase pSWFProcessBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSWFProcessBase.isAsyncModeDirty() && (bl || pSWFProcessBase.getAsyncMode() != null)) {
            iDataObject.set(FIELD_ASYNCMODE, (Object)pSWFProcessBase.getAsyncMode());
        }
        if (pSWFProcessBase.isCodeNameDirty() && (bl || pSWFProcessBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSWFProcessBase.getCodeName());
        }
        if (pSWFProcessBase.isCreateDateDirty() && (bl || pSWFProcessBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSWFProcessBase.getCreateDate());
        }
        if (pSWFProcessBase.isCreateManDirty() && (bl || pSWFProcessBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSWFProcessBase.getCreateMan());
        }
        if (pSWFProcessBase.isDynaModelFlagDirty() && (bl || pSWFProcessBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSWFProcessBase.getDynaModelFlag());
        }
        if (pSWFProcessBase.isEditFieldsDirty() && (bl || pSWFProcessBase.getEditFields() != null)) {
            iDataObject.set(FIELD_EDITFIELDS, (Object)pSWFProcessBase.getEditFields());
        }
        if (pSWFProcessBase.isEditFlagDirty() && (bl || pSWFProcessBase.getEditFlag() != null)) {
            iDataObject.set(FIELD_EDITFLAG, (Object)pSWFProcessBase.getEditFlag());
        }
        if (pSWFProcessBase.isEditPSDEFGroupIdDirty() && (bl || pSWFProcessBase.getEditPSDEFGroupId() != null)) {
            iDataObject.set(FIELD_EDITPSDEFGROUPID, (Object)pSWFProcessBase.getEditPSDEFGroupId());
        }
        if (pSWFProcessBase.isEditPSDEFGroupNameDirty() && (bl || pSWFProcessBase.getEditPSDEFGroupName() != null)) {
            iDataObject.set(FIELD_EDITPSDEFGROUPNAME, (Object)pSWFProcessBase.getEditPSDEFGroupName());
        }
        if (pSWFProcessBase.isEmbedPSDEDSIdDirty() && (bl || pSWFProcessBase.getEmbedPSDEDSId() != null)) {
            iDataObject.set(FIELD_EMBEDPSDEDSID, (Object)pSWFProcessBase.getEmbedPSDEDSId());
        }
        if (pSWFProcessBase.isEmbedPSDEDSNameDirty() && (bl || pSWFProcessBase.getEmbedPSDEDSName() != null)) {
            iDataObject.set(FIELD_EMBEDPSDEDSNAME, (Object)pSWFProcessBase.getEmbedPSDEDSName());
        }
        if (pSWFProcessBase.isEmbedPSDEIdDirty() && (bl || pSWFProcessBase.getEmbedPSDEId() != null)) {
            iDataObject.set(FIELD_EMBEDPSDEID, (Object)pSWFProcessBase.getEmbedPSDEId());
        }
        if (pSWFProcessBase.isEmbedPSWFDEIdDirty() && (bl || pSWFProcessBase.getEmbedPSWFDEId() != null)) {
            iDataObject.set(FIELD_EMBEDPSWFDEID, (Object)pSWFProcessBase.getEmbedPSWFDEId());
        }
        if (pSWFProcessBase.isEmbedPSWFDENameDirty() && (bl || pSWFProcessBase.getEmbedPSWFDEName() != null)) {
            iDataObject.set(FIELD_EMBEDPSWFDENAME, (Object)pSWFProcessBase.getEmbedPSWFDEName());
        }
        if (pSWFProcessBase.isEmbedPSWFIdDirty() && (bl || pSWFProcessBase.getEmbedPSWFId() != null)) {
            iDataObject.set(FIELD_EMBEDPSWFID, (Object)pSWFProcessBase.getEmbedPSWFId());
        }
        if (pSWFProcessBase.isEmbedPSWFNameDirty() && (bl || pSWFProcessBase.getEmbedPSWFName() != null)) {
            iDataObject.set(FIELD_EMBEDPSWFNAME, (Object)pSWFProcessBase.getEmbedPSWFName());
        }
        if (pSWFProcessBase.isEnableDirty() && (bl || pSWFProcessBase.getEnable() != null)) {
            iDataObject.set(FIELD_ENABLE, (Object)pSWFProcessBase.getEnable());
        }
        if (pSWFProcessBase.isEnableMobileDirty() && (bl || pSWFProcessBase.getEnableMobile() != null)) {
            iDataObject.set(FIELD_ENABLEMOBILE, (Object)pSWFProcessBase.getEnableMobile());
        }
        if (pSWFProcessBase.isEnableTimeoutDirty() && (bl || pSWFProcessBase.getEnableTimeout() != null)) {
            iDataObject.set(FIELD_ENABLETIMEOUT, (Object)pSWFProcessBase.getEnableTimeout());
        }
        if (pSWFProcessBase.isExitStateNameDirty() && (bl || pSWFProcessBase.getExitStateName() != null)) {
            iDataObject.set(FIELD_EXITSTATENAME, (Object)pSWFProcessBase.getExitStateName());
        }
        if (pSWFProcessBase.isExitStateValueDirty() && (bl || pSWFProcessBase.getExitStateValue() != null)) {
            iDataObject.set(FIELD_EXITSTATEVALUE, (Object)pSWFProcessBase.getExitStateValue());
        }
        if (pSWFProcessBase.isFormCodeNameDirty() && (bl || pSWFProcessBase.getFormCodeName() != null)) {
            iDataObject.set(FIELD_FORMCODENAME, (Object)pSWFProcessBase.getFormCodeName());
        }
        if (pSWFProcessBase.isHeightDirty() && (bl || pSWFProcessBase.getHeight() != null)) {
            iDataObject.set(FIELD_HEIGHT, (Object)pSWFProcessBase.getHeight());
        }
        if (pSWFProcessBase.isIconPathDirty() && (bl || pSWFProcessBase.getIconPath() != null)) {
            iDataObject.set(FIELD_ICONPATH, (Object)pSWFProcessBase.getIconPath());
        }
        if (pSWFProcessBase.isLeftPosDirty() && (bl || pSWFProcessBase.getLeftPos() != null)) {
            iDataObject.set(FIELD_LEFTPOS, (Object)pSWFProcessBase.getLeftPos());
        }
        if (pSWFProcessBase.isMemoDirty() && (bl || pSWFProcessBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSWFProcessBase.getMemo());
        }
        if (pSWFProcessBase.isMemoFieldDirty() && (bl || pSWFProcessBase.getMemoField() != null)) {
            iDataObject.set(FIELD_MEMOFIELD, (Object)pSWFProcessBase.getMemoField());
        }
        if (pSWFProcessBase.isMobFormCodeNameDirty() && (bl || pSWFProcessBase.getMobFormCodeName() != null)) {
            iDataObject.set(FIELD_MOBFORMCODENAME, (Object)pSWFProcessBase.getMobFormCodeName());
        }
        if (pSWFProcessBase.isMobPSDEFormIdDirty() && (bl || pSWFProcessBase.getMobPSDEFormId() != null)) {
            iDataObject.set(FIELD_MOBPSDEFORMID, (Object)pSWFProcessBase.getMobPSDEFormId());
        }
        if (pSWFProcessBase.isMobPSDEFormNameDirty() && (bl || pSWFProcessBase.getMobPSDEFormName() != null)) {
            iDataObject.set(FIELD_MOBPSDEFORMNAME, (Object)pSWFProcessBase.getMobPSDEFormName());
        }
        if (pSWFProcessBase.isMobPSDEUAGroupIdDirty() && (bl || pSWFProcessBase.getMobPSDEUAGroupId() != null)) {
            iDataObject.set(FIELD_MOBPSDEUAGROUPID, (Object)pSWFProcessBase.getMobPSDEUAGroupId());
        }
        if (pSWFProcessBase.isMobPSDEUAGroupNameDirty() && (bl || pSWFProcessBase.getMobPSDEUAGroupName() != null)) {
            iDataObject.set(FIELD_MOBPSDEUAGROUPNAME, (Object)pSWFProcessBase.getMobPSDEUAGroupName());
        }
        if (pSWFProcessBase.isMobPSDEViewIdDirty() && (bl || pSWFProcessBase.getMobPSDEViewId() != null)) {
            iDataObject.set(FIELD_MOBPSDEVIEWID, (Object)pSWFProcessBase.getMobPSDEViewId());
        }
        if (pSWFProcessBase.isMobPSDEViewNameDirty() && (bl || pSWFProcessBase.getMobPSDEViewName() != null)) {
            iDataObject.set(FIELD_MOBPSDEVIEWNAME, (Object)pSWFProcessBase.getMobPSDEViewName());
        }
        if (pSWFProcessBase.isMobPSDynaDEViewTemplIdDirty() && (bl || pSWFProcessBase.getMobPSDynaDEViewTemplId() != null)) {
            iDataObject.set(FIELD_MOBPSDYNADEVIEWTEMPLID, (Object)pSWFProcessBase.getMobPSDynaDEViewTemplId());
        }
        if (pSWFProcessBase.isMobUAGroupCodeNameDirty() && (bl || pSWFProcessBase.getMobUAGroupCodeName() != null)) {
            iDataObject.set(FIELD_MOBUAGROUPCODENAME, (Object)pSWFProcessBase.getMobUAGroupCodeName());
        }
        if (pSWFProcessBase.isMobUtil2FormCodeNameDirty() && (bl || pSWFProcessBase.getMobUtil2FormCodeName() != null)) {
            iDataObject.set(FIELD_MOBUTIL2FORMCODENAME, (Object)pSWFProcessBase.getMobUtil2FormCodeName());
        }
        if (pSWFProcessBase.isMobUtil2PSDEFormIdDirty() && (bl || pSWFProcessBase.getMobUtil2PSDEFormId() != null)) {
            iDataObject.set(FIELD_MOBUTIL2PSDEFORMID, (Object)pSWFProcessBase.getMobUtil2PSDEFormId());
        }
        if (pSWFProcessBase.isMobUtil2PSDEFormNameDirty() && (bl || pSWFProcessBase.getMobUtil2PSDEFormName() != null)) {
            iDataObject.set(FIELD_MOBUTIL2PSDEFORMNAME, (Object)pSWFProcessBase.getMobUtil2PSDEFormName());
        }
        if (pSWFProcessBase.isMobUtil3FormCodeNameDirty() && (bl || pSWFProcessBase.getMobUtil3FormCodeName() != null)) {
            iDataObject.set(FIELD_MOBUTIL3FORMCODENAME, (Object)pSWFProcessBase.getMobUtil3FormCodeName());
        }
        if (pSWFProcessBase.isMobUtil3PSDEFormIdDirty() && (bl || pSWFProcessBase.getMobUtil3PSDEFormId() != null)) {
            iDataObject.set(FIELD_MOBUTIL3PSDEFORMID, (Object)pSWFProcessBase.getMobUtil3PSDEFormId());
        }
        if (pSWFProcessBase.isMobUtil3PSDEFormNameDirty() && (bl || pSWFProcessBase.getMobUtil3PSDEFormName() != null)) {
            iDataObject.set(FIELD_MOBUTIL3PSDEFORMNAME, (Object)pSWFProcessBase.getMobUtil3PSDEFormName());
        }
        if (pSWFProcessBase.isMobUtil4FormCodeNameDirty() && (bl || pSWFProcessBase.getMobUtil4FormCodeName() != null)) {
            iDataObject.set(FIELD_MOBUTIL4FORMCODENAME, (Object)pSWFProcessBase.getMobUtil4FormCodeName());
        }
        if (pSWFProcessBase.isMobUtil4PSDEFormIdDirty() && (bl || pSWFProcessBase.getMobUtil4PSDEFormId() != null)) {
            iDataObject.set(FIELD_MOBUTIL4PSDEFORMID, (Object)pSWFProcessBase.getMobUtil4PSDEFormId());
        }
        if (pSWFProcessBase.isMobUtil4PSDEFormNameDirty() && (bl || pSWFProcessBase.getMobUtil4PSDEFormName() != null)) {
            iDataObject.set(FIELD_MOBUTIL4PSDEFORMNAME, (Object)pSWFProcessBase.getMobUtil4PSDEFormName());
        }
        if (pSWFProcessBase.isMobUtil5FormCodeNameDirty() && (bl || pSWFProcessBase.getMobUtil5FormCodeName() != null)) {
            iDataObject.set(FIELD_MOBUTIL5FORMCODENAME, (Object)pSWFProcessBase.getMobUtil5FormCodeName());
        }
        if (pSWFProcessBase.isMobUtil5PSDEFormIdDirty() && (bl || pSWFProcessBase.getMobUtil5PSDEFormId() != null)) {
            iDataObject.set(FIELD_MOBUTIL5PSDEFORMID, (Object)pSWFProcessBase.getMobUtil5PSDEFormId());
        }
        if (pSWFProcessBase.isMobUtil5PSDEFormNameDirty() && (bl || pSWFProcessBase.getMobUtil5PSDEFormName() != null)) {
            iDataObject.set(FIELD_MOBUTIL5PSDEFORMNAME, (Object)pSWFProcessBase.getMobUtil5PSDEFormName());
        }
        if (pSWFProcessBase.isMobUtilFormCodeNameDirty() && (bl || pSWFProcessBase.getMobUtilFormCodeName() != null)) {
            iDataObject.set(FIELD_MOBUTILFORMCODENAME, (Object)pSWFProcessBase.getMobUtilFormCodeName());
        }
        if (pSWFProcessBase.isMobUtilPSDEFormIdDirty() && (bl || pSWFProcessBase.getMobUtilPSDEFormId() != null)) {
            iDataObject.set(FIELD_MOBUTILPSDEFORMID, (Object)pSWFProcessBase.getMobUtilPSDEFormId());
        }
        if (pSWFProcessBase.isMobUtilPSDEFormNameDirty() && (bl || pSWFProcessBase.getMobUtilPSDEFormName() != null)) {
            iDataObject.set(FIELD_MOBUTILPSDEFORMNAME, (Object)pSWFProcessBase.getMobUtilPSDEFormName());
        }
        if (pSWFProcessBase.isMobWFEditViewTypeDirty() && (bl || pSWFProcessBase.getMobWFEditViewType() != null)) {
            iDataObject.set(FIELD_MOBWFEDITVIEWTYPE, (Object)pSWFProcessBase.getMobWFEditViewType());
        }
        if (pSWFProcessBase.isModelIdDirty() && (bl || pSWFProcessBase.getModelId() != null)) {
            iDataObject.set(FIELD_MODELID, (Object)pSWFProcessBase.getModelId());
        }
        if (pSWFProcessBase.isMsgTypeDirty() && (bl || pSWFProcessBase.getMsgType() != null)) {
            iDataObject.set(FIELD_MSGTYPE, (Object)pSWFProcessBase.getMsgType());
        }
        if (pSWFProcessBase.isMultiInstModeDirty() && (bl || pSWFProcessBase.getMultiInstMode() != null)) {
            iDataObject.set(FIELD_MULTIINSTMODE, (Object)pSWFProcessBase.getMultiInstMode());
        }
        if (pSWFProcessBase.isNamePSLanResIdDirty() && (bl || pSWFProcessBase.getNamePSLanResId() != null)) {
            iDataObject.set(FIELD_NAMEPSLANRESID, (Object)pSWFProcessBase.getNamePSLanResId());
        }
        if (pSWFProcessBase.isNamePSLanResNameDirty() && (bl || pSWFProcessBase.getNamePSLanResName() != null)) {
            iDataObject.set(FIELD_NAMEPSLANRESNAME, (Object)pSWFProcessBase.getNamePSLanResName());
        }
        if (pSWFProcessBase.isNormalProcTypeDirty() && (bl || pSWFProcessBase.getNormalProcType() != null)) {
            iDataObject.set(FIELD_NORMALPROCTYPE, (Object)pSWFProcessBase.getNormalProcType());
        }
        if (pSWFProcessBase.isPredefinedActionsDirty() && (bl || pSWFProcessBase.getPredefinedActions() != null)) {
            iDataObject.set(FIELD_PREDEFINEDACTIONS, (Object)pSWFProcessBase.getPredefinedActions());
        }
        if (pSWFProcessBase.isPSDEActionIdDirty() && (bl || pSWFProcessBase.getPSDEActionId() != null)) {
            iDataObject.set(FIELD_PSDEACTIONID, (Object)pSWFProcessBase.getPSDEActionId());
        }
        if (pSWFProcessBase.isPSDEActionNameDirty() && (bl || pSWFProcessBase.getPSDEActionName() != null)) {
            iDataObject.set(FIELD_PSDEACTIONNAME, (Object)pSWFProcessBase.getPSDEActionName());
        }
        if (pSWFProcessBase.isPSDEFormIdDirty() && (bl || pSWFProcessBase.getPSDEFormId() != null)) {
            iDataObject.set(FIELD_PSDEFORMID, (Object)pSWFProcessBase.getPSDEFormId());
        }
        if (pSWFProcessBase.isPSDEFormNameDirty() && (bl || pSWFProcessBase.getPSDEFormName() != null)) {
            iDataObject.set(FIELD_PSDEFORMNAME, (Object)pSWFProcessBase.getPSDEFormName());
        }
        if (pSWFProcessBase.isPSDEIdDirty() && (bl || pSWFProcessBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSWFProcessBase.getPSDEId());
        }
        if (pSWFProcessBase.isPSDEUAGroupIdDirty() && (bl || pSWFProcessBase.getPSDEUAGroupId() != null)) {
            iDataObject.set(FIELD_PSDEUAGROUPID, (Object)pSWFProcessBase.getPSDEUAGroupId());
        }
        if (pSWFProcessBase.isPSDEUAGroupNameDirty() && (bl || pSWFProcessBase.getPSDEUAGroupName() != null)) {
            iDataObject.set(FIELD_PSDEUAGROUPNAME, (Object)pSWFProcessBase.getPSDEUAGroupName());
        }
        if (pSWFProcessBase.isPSDEViewBaseIdDirty() && (bl || pSWFProcessBase.getPSDEViewBaseId() != null)) {
            iDataObject.set(FIELD_PSDEVIEWBASEID, (Object)pSWFProcessBase.getPSDEViewBaseId());
        }
        if (pSWFProcessBase.isPSDEViewBaseNameDirty() && (bl || pSWFProcessBase.getPSDEViewBaseName() != null)) {
            iDataObject.set(FIELD_PSDEVIEWBASENAME, (Object)pSWFProcessBase.getPSDEViewBaseName());
        }
        if (pSWFProcessBase.isPSDynaDEViewTemplIdDirty() && (bl || pSWFProcessBase.getPSDynaDEViewTemplId() != null)) {
            iDataObject.set(FIELD_PSDYNADEVIEWTEMPLID, (Object)pSWFProcessBase.getPSDynaDEViewTemplId());
        }
        if (pSWFProcessBase.isPSDynaInstIdDirty() && (bl || pSWFProcessBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSWFProcessBase.getPSDynaInstId());
        }
        if (pSWFProcessBase.isPSSysMsgTemplIdDirty() && (bl || pSWFProcessBase.getPSSysMsgTemplId() != null)) {
            iDataObject.set(FIELD_PSSYSMSGTEMPLID, (Object)pSWFProcessBase.getPSSysMsgTemplId());
        }
        if (pSWFProcessBase.isPSSysMsgTemplNameDirty() && (bl || pSWFProcessBase.getPSSysMsgTemplName() != null)) {
            iDataObject.set(FIELD_PSSYSMSGTEMPLNAME, (Object)pSWFProcessBase.getPSSysMsgTemplName());
        }
        if (pSWFProcessBase.isPSSystemIdDirty() && (bl || pSWFProcessBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSWFProcessBase.getPSSystemId());
        }
        if (pSWFProcessBase.isPSWFDEIdDirty() && (bl || pSWFProcessBase.getPSWFDEId() != null)) {
            iDataObject.set(FIELD_PSWFDEID, (Object)pSWFProcessBase.getPSWFDEId());
        }
        if (pSWFProcessBase.isPSWFDENameDirty() && (bl || pSWFProcessBase.getPSWFDEName() != null)) {
            iDataObject.set(FIELD_PSWFDENAME, (Object)pSWFProcessBase.getPSWFDEName());
        }
        if (pSWFProcessBase.isPSWFIdDirty() && (bl || pSWFProcessBase.getPSWFId() != null)) {
            iDataObject.set(FIELD_PSWFID, (Object)pSWFProcessBase.getPSWFId());
        }
        if (pSWFProcessBase.isPSWFNameDirty() && (bl || pSWFProcessBase.getPSWFName() != null)) {
            iDataObject.set(FIELD_PSWFNAME, (Object)pSWFProcessBase.getPSWFName());
        }
        if (pSWFProcessBase.isPSWFProcessIdDirty() && (bl || pSWFProcessBase.getPSWFProcessId() != null)) {
            iDataObject.set(FIELD_PSWFPROCESSID, (Object)pSWFProcessBase.getPSWFProcessId());
        }
        if (pSWFProcessBase.isPSWFProcessNameDirty() && (bl || pSWFProcessBase.getPSWFProcessName() != null)) {
            iDataObject.set(FIELD_PSWFPROCESSNAME, (Object)pSWFProcessBase.getPSWFProcessName());
        }
        if (pSWFProcessBase.isPSWFVersionIdDirty() && (bl || pSWFProcessBase.getPSWFVersionId() != null)) {
            iDataObject.set(FIELD_PSWFVERSIONID, (Object)pSWFProcessBase.getPSWFVersionId());
        }
        if (pSWFProcessBase.isPSWFVersionNameDirty() && (bl || pSWFProcessBase.getPSWFVersionName() != null)) {
            iDataObject.set(FIELD_PSWFVERSIONNAME, (Object)pSWFProcessBase.getPSWFVersionName());
        }
        if (pSWFProcessBase.isPSWFWorkTimeIdDirty() && (bl || pSWFProcessBase.getPSWFWorkTimeId() != null)) {
            iDataObject.set(FIELD_PSWFWORKTIMEID, (Object)pSWFProcessBase.getPSWFWorkTimeId());
        }
        if (pSWFProcessBase.isPSWFWorkTimeNameDirty() && (bl || pSWFProcessBase.getPSWFWorkTimeName() != null)) {
            iDataObject.set(FIELD_PSWFWORKTIMENAME, (Object)pSWFProcessBase.getPSWFWorkTimeName());
        }
        if (pSWFProcessBase.isRefPSWFVersionIdDirty() && (bl || pSWFProcessBase.getRefPSWFVersionId() != null)) {
            iDataObject.set(FIELD_REFPSWFVERSIONID, (Object)pSWFProcessBase.getRefPSWFVersionId());
        }
        if (pSWFProcessBase.isRefPSWFVersionNameDirty() && (bl || pSWFProcessBase.getRefPSWFVersionName() != null)) {
            iDataObject.set(FIELD_REFPSWFVERSIONNAME, (Object)pSWFProcessBase.getRefPSWFVersionName());
        }
        if (pSWFProcessBase.isSendInformDirty() && (bl || pSWFProcessBase.getSendInform() != null)) {
            iDataObject.set(FIELD_SENDINFORM, (Object)pSWFProcessBase.getSendInform());
        }
        if (pSWFProcessBase.isShapeParamsDirty() && (bl || pSWFProcessBase.getShapeParams() != null)) {
            iDataObject.set(FIELD_SHAPEPARAMS, (Object)pSWFProcessBase.getShapeParams());
        }
        if (pSWFProcessBase.isThreadNameDirty() && (bl || pSWFProcessBase.getThreadName() != null)) {
            iDataObject.set(FIELD_THREADNAME, (Object)pSWFProcessBase.getThreadName());
        }
        if (pSWFProcessBase.isThreadSNDirty() && (bl || pSWFProcessBase.getThreadSN() != null)) {
            iDataObject.set(FIELD_THREADSN, (Object)pSWFProcessBase.getThreadSN());
        }
        if (pSWFProcessBase.isTimeoutDirty() && (bl || pSWFProcessBase.getTimeout() != null)) {
            iDataObject.set(FIELD_TIMEOUT, (Object)pSWFProcessBase.getTimeout());
        }
        if (pSWFProcessBase.isTimeoutPSDEFIdDirty() && (bl || pSWFProcessBase.getTimeoutPSDEFId() != null)) {
            iDataObject.set(FIELD_TIMEOUTPSDEFID, (Object)pSWFProcessBase.getTimeoutPSDEFId());
        }
        if (pSWFProcessBase.isTimeoutPSDEFNameDirty() && (bl || pSWFProcessBase.getTimeoutPSDEFName() != null)) {
            iDataObject.set(FIELD_TIMEOUTPSDEFNAME, (Object)pSWFProcessBase.getTimeoutPSDEFName());
        }
        if (pSWFProcessBase.isTimeoutTypeDirty() && (bl || pSWFProcessBase.getTimeoutType() != null)) {
            iDataObject.set(FIELD_TIMEOUTTYPE, (Object)pSWFProcessBase.getTimeoutType());
        }
        if (pSWFProcessBase.isTopPosDirty() && (bl || pSWFProcessBase.getTopPos() != null)) {
            iDataObject.set(FIELD_TOPPOS, (Object)pSWFProcessBase.getTopPos());
        }
        if (pSWFProcessBase.isUAGroupCodeNameDirty() && (bl || pSWFProcessBase.getUAGroupCodeName() != null)) {
            iDataObject.set(FIELD_UAGROUPCODENAME, (Object)pSWFProcessBase.getUAGroupCodeName());
        }
        if (pSWFProcessBase.isUpdateDateDirty() && (bl || pSWFProcessBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSWFProcessBase.getUpdateDate());
        }
        if (pSWFProcessBase.isUpdateManDirty() && (bl || pSWFProcessBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSWFProcessBase.getUpdateMan());
        }
        if (pSWFProcessBase.isUserCatDirty() && (bl || pSWFProcessBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSWFProcessBase.getUserCat());
        }
        if (pSWFProcessBase.isUserDataDirty() && (bl || pSWFProcessBase.getUserData() != null)) {
            iDataObject.set(FIELD_USERDATA, (Object)pSWFProcessBase.getUserData());
        }
        if (pSWFProcessBase.isUserData2Dirty() && (bl || pSWFProcessBase.getUserData2() != null)) {
            iDataObject.set(FIELD_USERDATA2, (Object)pSWFProcessBase.getUserData2());
        }
        if (pSWFProcessBase.isUserTagDirty() && (bl || pSWFProcessBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSWFProcessBase.getUserTag());
        }
        if (pSWFProcessBase.isUserTag2Dirty() && (bl || pSWFProcessBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSWFProcessBase.getUserTag2());
        }
        if (pSWFProcessBase.isUserTag3Dirty() && (bl || pSWFProcessBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSWFProcessBase.getUserTag3());
        }
        if (pSWFProcessBase.isUserTag4Dirty() && (bl || pSWFProcessBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSWFProcessBase.getUserTag4());
        }
        if (pSWFProcessBase.isUtil2FormCodeNameDirty() && (bl || pSWFProcessBase.getUtil2FormCodeName() != null)) {
            iDataObject.set(FIELD_UTIL2FORMCODENAME, (Object)pSWFProcessBase.getUtil2FormCodeName());
        }
        if (pSWFProcessBase.isUtil2PSDEFormIdDirty() && (bl || pSWFProcessBase.getUtil2PSDEFormId() != null)) {
            iDataObject.set(FIELD_UTIL2PSDEFORMID, (Object)pSWFProcessBase.getUtil2PSDEFormId());
        }
        if (pSWFProcessBase.isUtil2PSDEFormNameDirty() && (bl || pSWFProcessBase.getUtil2PSDEFormName() != null)) {
            iDataObject.set(FIELD_UTIL2PSDEFORMNAME, (Object)pSWFProcessBase.getUtil2PSDEFormName());
        }
        if (pSWFProcessBase.isUtil3FormCodeNameDirty() && (bl || pSWFProcessBase.getUtil3FormCodeName() != null)) {
            iDataObject.set(FIELD_UTIL3FORMCODENAME, (Object)pSWFProcessBase.getUtil3FormCodeName());
        }
        if (pSWFProcessBase.isUtil3PSDEFormIdDirty() && (bl || pSWFProcessBase.getUtil3PSDEFormId() != null)) {
            iDataObject.set(FIELD_UTIL3PSDEFORMID, (Object)pSWFProcessBase.getUtil3PSDEFormId());
        }
        if (pSWFProcessBase.isUtil3PSDEFormNameDirty() && (bl || pSWFProcessBase.getUtil3PSDEFormName() != null)) {
            iDataObject.set(FIELD_UTIL3PSDEFORMNAME, (Object)pSWFProcessBase.getUtil3PSDEFormName());
        }
        if (pSWFProcessBase.isUtil4FormCodeNameDirty() && (bl || pSWFProcessBase.getUtil4FormCodeName() != null)) {
            iDataObject.set(FIELD_UTIL4FORMCODENAME, (Object)pSWFProcessBase.getUtil4FormCodeName());
        }
        if (pSWFProcessBase.isUtil4PSDEFormIdDirty() && (bl || pSWFProcessBase.getUtil4PSDEFormId() != null)) {
            iDataObject.set(FIELD_UTIL4PSDEFORMID, (Object)pSWFProcessBase.getUtil4PSDEFormId());
        }
        if (pSWFProcessBase.isUtil4PSDEFormNameDirty() && (bl || pSWFProcessBase.getUtil4PSDEFormName() != null)) {
            iDataObject.set(FIELD_UTIL4PSDEFORMNAME, (Object)pSWFProcessBase.getUtil4PSDEFormName());
        }
        if (pSWFProcessBase.isUtil5FormCodeNameDirty() && (bl || pSWFProcessBase.getUtil5FormCodeName() != null)) {
            iDataObject.set(FIELD_UTIL5FORMCODENAME, (Object)pSWFProcessBase.getUtil5FormCodeName());
        }
        if (pSWFProcessBase.isUtil5PSDEFormIdDirty() && (bl || pSWFProcessBase.getUtil5PSDEFormId() != null)) {
            iDataObject.set(FIELD_UTIL5PSDEFORMID, (Object)pSWFProcessBase.getUtil5PSDEFormId());
        }
        if (pSWFProcessBase.isUtil5PSDEFormNameDirty() && (bl || pSWFProcessBase.getUtil5PSDEFormName() != null)) {
            iDataObject.set(FIELD_UTIL5PSDEFORMNAME, (Object)pSWFProcessBase.getUtil5PSDEFormName());
        }
        if (pSWFProcessBase.isUtilFormCodeNameDirty() && (bl || pSWFProcessBase.getUtilFormCodeName() != null)) {
            iDataObject.set(FIELD_UTILFORMCODENAME, (Object)pSWFProcessBase.getUtilFormCodeName());
        }
        if (pSWFProcessBase.isUtilPSDEFormIdDirty() && (bl || pSWFProcessBase.getUtilPSDEFormId() != null)) {
            iDataObject.set(FIELD_UTILPSDEFORMID, (Object)pSWFProcessBase.getUtilPSDEFormId());
        }
        if (pSWFProcessBase.isUtilPSDEFormNameDirty() && (bl || pSWFProcessBase.getUtilPSDEFormName() != null)) {
            iDataObject.set(FIELD_UTILPSDEFORMNAME, (Object)pSWFProcessBase.getUtilPSDEFormName());
        }
        if (pSWFProcessBase.isWFEditViewTypeDirty() && (bl || pSWFProcessBase.getWFEditViewType() != null)) {
            iDataObject.set(FIELD_WFEDITVIEWTYPE, (Object)pSWFProcessBase.getWFEditViewType());
        }
        if (pSWFProcessBase.isWFEngineTypeDirty() && (bl || pSWFProcessBase.getWFEngineType() != null)) {
            iDataObject.set(FIELD_WFENGINETYPE, (Object)pSWFProcessBase.getWFEngineType());
        }
        if (pSWFProcessBase.isWFProcessTypeDirty() && (bl || pSWFProcessBase.getWFProcessType() != null)) {
            iDataObject.set(FIELD_WFPROCESSTYPE, (Object)pSWFProcessBase.getWFProcessType());
        }
        if (pSWFProcessBase.isWFStepNameDirty() && (bl || pSWFProcessBase.getWFStepName() != null)) {
            iDataObject.set(FIELD_WFSTEPNAME, (Object)pSWFProcessBase.getWFStepName());
        }
        if (pSWFProcessBase.isWFStepValueDirty() && (bl || pSWFProcessBase.getWFStepValue() != null)) {
            iDataObject.set(FIELD_WFSTEPVALUE, (Object)pSWFProcessBase.getWFStepValue());
        }
        if (pSWFProcessBase.isWidthDirty() && (bl || pSWFProcessBase.getWidth() != null)) {
            iDataObject.set(FIELD_WIDTH, (Object)pSWFProcessBase.getWidth());
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
        return PSWFProcessBase.remove(this, n);
    }

    private static boolean remove(PSWFProcessBase pSWFProcessBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSWFProcessBase.resetAsyncMode();
                return true;
            }
            case 1: {
                pSWFProcessBase.resetCodeName();
                return true;
            }
            case 2: {
                pSWFProcessBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSWFProcessBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSWFProcessBase.resetDynaModelFlag();
                return true;
            }
            case 5: {
                pSWFProcessBase.resetEditFields();
                return true;
            }
            case 6: {
                pSWFProcessBase.resetEditFlag();
                return true;
            }
            case 7: {
                pSWFProcessBase.resetEditPSDEFGroupId();
                return true;
            }
            case 8: {
                pSWFProcessBase.resetEditPSDEFGroupName();
                return true;
            }
            case 9: {
                pSWFProcessBase.resetEmbedPSDEDSId();
                return true;
            }
            case 10: {
                pSWFProcessBase.resetEmbedPSDEDSName();
                return true;
            }
            case 11: {
                pSWFProcessBase.resetEmbedPSDEId();
                return true;
            }
            case 12: {
                pSWFProcessBase.resetEmbedPSWFDEId();
                return true;
            }
            case 13: {
                pSWFProcessBase.resetEmbedPSWFDEName();
                return true;
            }
            case 14: {
                pSWFProcessBase.resetEmbedPSWFId();
                return true;
            }
            case 15: {
                pSWFProcessBase.resetEmbedPSWFName();
                return true;
            }
            case 16: {
                pSWFProcessBase.resetEnable();
                return true;
            }
            case 17: {
                pSWFProcessBase.resetEnableMobile();
                return true;
            }
            case 18: {
                pSWFProcessBase.resetEnableTimeout();
                return true;
            }
            case 19: {
                pSWFProcessBase.resetExitStateName();
                return true;
            }
            case 20: {
                pSWFProcessBase.resetExitStateValue();
                return true;
            }
            case 21: {
                pSWFProcessBase.resetFormCodeName();
                return true;
            }
            case 22: {
                pSWFProcessBase.resetHeight();
                return true;
            }
            case 23: {
                pSWFProcessBase.resetIconPath();
                return true;
            }
            case 24: {
                pSWFProcessBase.resetLeftPos();
                return true;
            }
            case 25: {
                pSWFProcessBase.resetMemo();
                return true;
            }
            case 26: {
                pSWFProcessBase.resetMemoField();
                return true;
            }
            case 27: {
                pSWFProcessBase.resetMobFormCodeName();
                return true;
            }
            case 28: {
                pSWFProcessBase.resetMobPSDEFormId();
                return true;
            }
            case 29: {
                pSWFProcessBase.resetMobPSDEFormName();
                return true;
            }
            case 30: {
                pSWFProcessBase.resetMobPSDEUAGroupId();
                return true;
            }
            case 31: {
                pSWFProcessBase.resetMobPSDEUAGroupName();
                return true;
            }
            case 32: {
                pSWFProcessBase.resetMobPSDEViewId();
                return true;
            }
            case 33: {
                pSWFProcessBase.resetMobPSDEViewName();
                return true;
            }
            case 34: {
                pSWFProcessBase.resetMobPSDynaDEViewTemplId();
                return true;
            }
            case 35: {
                pSWFProcessBase.resetMobUAGroupCodeName();
                return true;
            }
            case 36: {
                pSWFProcessBase.resetMobUtil2FormCodeName();
                return true;
            }
            case 37: {
                pSWFProcessBase.resetMobUtil2PSDEFormId();
                return true;
            }
            case 38: {
                pSWFProcessBase.resetMobUtil2PSDEFormName();
                return true;
            }
            case 39: {
                pSWFProcessBase.resetMobUtil3FormCodeName();
                return true;
            }
            case 40: {
                pSWFProcessBase.resetMobUtil3PSDEFormId();
                return true;
            }
            case 41: {
                pSWFProcessBase.resetMobUtil3PSDEFormName();
                return true;
            }
            case 42: {
                pSWFProcessBase.resetMobUtil4FormCodeName();
                return true;
            }
            case 43: {
                pSWFProcessBase.resetMobUtil4PSDEFormId();
                return true;
            }
            case 44: {
                pSWFProcessBase.resetMobUtil4PSDEFormName();
                return true;
            }
            case 45: {
                pSWFProcessBase.resetMobUtil5FormCodeName();
                return true;
            }
            case 46: {
                pSWFProcessBase.resetMobUtil5PSDEFormId();
                return true;
            }
            case 47: {
                pSWFProcessBase.resetMobUtil5PSDEFormName();
                return true;
            }
            case 48: {
                pSWFProcessBase.resetMobUtilFormCodeName();
                return true;
            }
            case 49: {
                pSWFProcessBase.resetMobUtilPSDEFormId();
                return true;
            }
            case 50: {
                pSWFProcessBase.resetMobUtilPSDEFormName();
                return true;
            }
            case 51: {
                pSWFProcessBase.resetMobWFEditViewType();
                return true;
            }
            case 52: {
                pSWFProcessBase.resetModelId();
                return true;
            }
            case 53: {
                pSWFProcessBase.resetMsgType();
                return true;
            }
            case 54: {
                pSWFProcessBase.resetMultiInstMode();
                return true;
            }
            case 55: {
                pSWFProcessBase.resetNamePSLanResId();
                return true;
            }
            case 56: {
                pSWFProcessBase.resetNamePSLanResName();
                return true;
            }
            case 57: {
                pSWFProcessBase.resetNormalProcType();
                return true;
            }
            case 58: {
                pSWFProcessBase.resetPredefinedActions();
                return true;
            }
            case 59: {
                pSWFProcessBase.resetPSDEActionId();
                return true;
            }
            case 60: {
                pSWFProcessBase.resetPSDEActionName();
                return true;
            }
            case 61: {
                pSWFProcessBase.resetPSDEFormId();
                return true;
            }
            case 62: {
                pSWFProcessBase.resetPSDEFormName();
                return true;
            }
            case 63: {
                pSWFProcessBase.resetPSDEId();
                return true;
            }
            case 64: {
                pSWFProcessBase.resetPSDEUAGroupId();
                return true;
            }
            case 65: {
                pSWFProcessBase.resetPSDEUAGroupName();
                return true;
            }
            case 66: {
                pSWFProcessBase.resetPSDEViewBaseId();
                return true;
            }
            case 67: {
                pSWFProcessBase.resetPSDEViewBaseName();
                return true;
            }
            case 68: {
                pSWFProcessBase.resetPSDynaDEViewTemplId();
                return true;
            }
            case 69: {
                pSWFProcessBase.resetPSDynaInstId();
                return true;
            }
            case 70: {
                pSWFProcessBase.resetPSSysMsgTemplId();
                return true;
            }
            case 71: {
                pSWFProcessBase.resetPSSysMsgTemplName();
                return true;
            }
            case 72: {
                pSWFProcessBase.resetPSSystemId();
                return true;
            }
            case 73: {
                pSWFProcessBase.resetPSWFDEId();
                return true;
            }
            case 74: {
                pSWFProcessBase.resetPSWFDEName();
                return true;
            }
            case 75: {
                pSWFProcessBase.resetPSWFId();
                return true;
            }
            case 76: {
                pSWFProcessBase.resetPSWFName();
                return true;
            }
            case 77: {
                pSWFProcessBase.resetPSWFProcessId();
                return true;
            }
            case 78: {
                pSWFProcessBase.resetPSWFProcessName();
                return true;
            }
            case 79: {
                pSWFProcessBase.resetPSWFVersionId();
                return true;
            }
            case 80: {
                pSWFProcessBase.resetPSWFVersionName();
                return true;
            }
            case 81: {
                pSWFProcessBase.resetPSWFWorkTimeId();
                return true;
            }
            case 82: {
                pSWFProcessBase.resetPSWFWorkTimeName();
                return true;
            }
            case 83: {
                pSWFProcessBase.resetRefPSWFVersionId();
                return true;
            }
            case 84: {
                pSWFProcessBase.resetRefPSWFVersionName();
                return true;
            }
            case 85: {
                pSWFProcessBase.resetSendInform();
                return true;
            }
            case 86: {
                pSWFProcessBase.resetShapeParams();
                return true;
            }
            case 87: {
                pSWFProcessBase.resetThreadName();
                return true;
            }
            case 88: {
                pSWFProcessBase.resetThreadSN();
                return true;
            }
            case 89: {
                pSWFProcessBase.resetTimeout();
                return true;
            }
            case 90: {
                pSWFProcessBase.resetTimeoutPSDEFId();
                return true;
            }
            case 91: {
                pSWFProcessBase.resetTimeoutPSDEFName();
                return true;
            }
            case 92: {
                pSWFProcessBase.resetTimeoutType();
                return true;
            }
            case 93: {
                pSWFProcessBase.resetTopPos();
                return true;
            }
            case 94: {
                pSWFProcessBase.resetUAGroupCodeName();
                return true;
            }
            case 95: {
                pSWFProcessBase.resetUpdateDate();
                return true;
            }
            case 96: {
                pSWFProcessBase.resetUpdateMan();
                return true;
            }
            case 97: {
                pSWFProcessBase.resetUserCat();
                return true;
            }
            case 98: {
                pSWFProcessBase.resetUserData();
                return true;
            }
            case 99: {
                pSWFProcessBase.resetUserData2();
                return true;
            }
            case 100: {
                pSWFProcessBase.resetUserTag();
                return true;
            }
            case 101: {
                pSWFProcessBase.resetUserTag2();
                return true;
            }
            case 102: {
                pSWFProcessBase.resetUserTag3();
                return true;
            }
            case 103: {
                pSWFProcessBase.resetUserTag4();
                return true;
            }
            case 104: {
                pSWFProcessBase.resetUtil2FormCodeName();
                return true;
            }
            case 105: {
                pSWFProcessBase.resetUtil2PSDEFormId();
                return true;
            }
            case 106: {
                pSWFProcessBase.resetUtil2PSDEFormName();
                return true;
            }
            case 107: {
                pSWFProcessBase.resetUtil3FormCodeName();
                return true;
            }
            case 108: {
                pSWFProcessBase.resetUtil3PSDEFormId();
                return true;
            }
            case 109: {
                pSWFProcessBase.resetUtil3PSDEFormName();
                return true;
            }
            case 110: {
                pSWFProcessBase.resetUtil4FormCodeName();
                return true;
            }
            case 111: {
                pSWFProcessBase.resetUtil4PSDEFormId();
                return true;
            }
            case 112: {
                pSWFProcessBase.resetUtil4PSDEFormName();
                return true;
            }
            case 113: {
                pSWFProcessBase.resetUtil5FormCodeName();
                return true;
            }
            case 114: {
                pSWFProcessBase.resetUtil5PSDEFormId();
                return true;
            }
            case 115: {
                pSWFProcessBase.resetUtil5PSDEFormName();
                return true;
            }
            case 116: {
                pSWFProcessBase.resetUtilFormCodeName();
                return true;
            }
            case 117: {
                pSWFProcessBase.resetUtilPSDEFormId();
                return true;
            }
            case 118: {
                pSWFProcessBase.resetUtilPSDEFormName();
                return true;
            }
            case 119: {
                pSWFProcessBase.resetWFEditViewType();
                return true;
            }
            case 120: {
                pSWFProcessBase.resetWFEngineType();
                return true;
            }
            case 121: {
                pSWFProcessBase.resetWFProcessType();
                return true;
            }
            case 122: {
                pSWFProcessBase.resetWFStepName();
                return true;
            }
            case 123: {
                pSWFProcessBase.resetWFStepValue();
                return true;
            }
            case 124: {
                pSWFProcessBase.resetWidth();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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
                pSDEActionService.autoGet((IEntity)pSDEAction);
                this.psdeaction = pSDEAction;
            }
            return this.psdeaction;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDataSet getEmbedPSDEDS() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEmbedPSDEDS();
        }
        if (this.getEmbedPSDEDSId() == null) {
            return null;
        }
        Integer n = this.objEmbedPSDEDSLock;
        synchronized (n) {
            if (this.embedpsdeds != null && DataTypeHelper.compare((int)25, (Object)this.getEmbedPSDEDSId(), (Object)this.embedpsdeds.getPSDEDataSetId()) != 0L) {
                this.embedpsdeds = null;
            }
            if (this.embedpsdeds == null) {
                PSDEDataSet pSDEDataSet = new PSDEDataSet();
                pSDEDataSet.setPSDEDataSetId(this.getEmbedPSDEDSId());
                PSDEDataSetService pSDEDataSetService = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataSetService.autoGet((IEntity)pSDEDataSet);
                this.embedpsdeds = pSDEDataSet;
            }
            return this.embedpsdeds;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEFGroup getEditPSDEFGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEditPSDEFGroup();
        }
        if (this.getEditPSDEFGroupId() == null) {
            return null;
        }
        Integer n = this.objEditPSDEFGroupLock;
        synchronized (n) {
            if (this.editpsdefgroup != null && DataTypeHelper.compare((int)25, (Object)this.getEditPSDEFGroupId(), (Object)this.editpsdefgroup.getPSDEFGroupId()) != 0L) {
                this.editpsdefgroup = null;
            }
            if (this.editpsdefgroup == null) {
                PSDEFGroup pSDEFGroup = new PSDEFGroup();
                pSDEFGroup.setPSDEFGroupId(this.getEditPSDEFGroupId());
                PSDEFGroupService pSDEFGroupService = (PSDEFGroupService)ServiceGlobal.getService(PSDEFGroupService.class, (SessionFactory)this.getSessionFactory());
                pSDEFGroupService.autoGet((IEntity)pSDEFGroup);
                this.editpsdefgroup = pSDEFGroup;
            }
            return this.editpsdefgroup;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getTimeoutPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTimeoutPSDEF();
        }
        if (this.getTimeoutPSDEFId() == null) {
            return null;
        }
        Integer n = this.objTimeoutPSDEFLock;
        synchronized (n) {
            if (this.timeoutpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getTimeoutPSDEFId(), (Object)this.timeoutpsdef.getPSDEFieldId()) != 0L) {
                this.timeoutpsdef = null;
            }
            if (this.timeoutpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getTimeoutPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.timeoutpsdef = pSDEField;
            }
            return this.timeoutpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEForm getMobPSDEForm() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobPSDEForm();
        }
        if (this.getMobPSDEFormId() == null) {
            return null;
        }
        Integer n = this.objMobPSDEFormLock;
        synchronized (n) {
            if (this.mobpsdeform != null && DataTypeHelper.compare((int)25, (Object)this.getMobPSDEFormId(), (Object)this.mobpsdeform.getPSDEFormId()) != 0L) {
                this.mobpsdeform = null;
            }
            if (this.mobpsdeform == null) {
                PSDEForm pSDEForm = new PSDEForm();
                pSDEForm.setPSDEFormId(this.getMobPSDEFormId());
                PSDEFormService pSDEFormService = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)this.getSessionFactory());
                pSDEFormService.autoGet((IEntity)pSDEForm);
                this.mobpsdeform = pSDEForm;
            }
            return this.mobpsdeform;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEForm getMobUtil2PSDEForm() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobUtil2PSDEForm();
        }
        if (this.getMobUtil2PSDEFormId() == null) {
            return null;
        }
        Integer n = this.objMobUtil2PSDEFormLock;
        synchronized (n) {
            if (this.mobutil2psdeform != null && DataTypeHelper.compare((int)25, (Object)this.getMobUtil2PSDEFormId(), (Object)this.mobutil2psdeform.getPSDEFormId()) != 0L) {
                this.mobutil2psdeform = null;
            }
            if (this.mobutil2psdeform == null) {
                PSDEForm pSDEForm = new PSDEForm();
                pSDEForm.setPSDEFormId(this.getMobUtil2PSDEFormId());
                PSDEFormService pSDEFormService = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)this.getSessionFactory());
                pSDEFormService.autoGet((IEntity)pSDEForm);
                this.mobutil2psdeform = pSDEForm;
            }
            return this.mobutil2psdeform;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEForm getMobUtil3PSDEForm() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobUtil3PSDEForm();
        }
        if (this.getMobUtil3PSDEFormId() == null) {
            return null;
        }
        Integer n = this.objMobUtil3PSDEFormLock;
        synchronized (n) {
            if (this.mobutil3psdeform != null && DataTypeHelper.compare((int)25, (Object)this.getMobUtil3PSDEFormId(), (Object)this.mobutil3psdeform.getPSDEFormId()) != 0L) {
                this.mobutil3psdeform = null;
            }
            if (this.mobutil3psdeform == null) {
                PSDEForm pSDEForm = new PSDEForm();
                pSDEForm.setPSDEFormId(this.getMobUtil3PSDEFormId());
                PSDEFormService pSDEFormService = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)this.getSessionFactory());
                pSDEFormService.autoGet((IEntity)pSDEForm);
                this.mobutil3psdeform = pSDEForm;
            }
            return this.mobutil3psdeform;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEForm getMobUtil4PSDEForm() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobUtil4PSDEForm();
        }
        if (this.getMobUtil4PSDEFormId() == null) {
            return null;
        }
        Integer n = this.objMobUtil4PSDEFormLock;
        synchronized (n) {
            if (this.mobutil4psdeform != null && DataTypeHelper.compare((int)25, (Object)this.getMobUtil4PSDEFormId(), (Object)this.mobutil4psdeform.getPSDEFormId()) != 0L) {
                this.mobutil4psdeform = null;
            }
            if (this.mobutil4psdeform == null) {
                PSDEForm pSDEForm = new PSDEForm();
                pSDEForm.setPSDEFormId(this.getMobUtil4PSDEFormId());
                PSDEFormService pSDEFormService = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)this.getSessionFactory());
                pSDEFormService.autoGet((IEntity)pSDEForm);
                this.mobutil4psdeform = pSDEForm;
            }
            return this.mobutil4psdeform;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEForm getMobUtil5PSDEForm() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobUtil5PSDEForm();
        }
        if (this.getMobUtil5PSDEFormId() == null) {
            return null;
        }
        Integer n = this.objMobUtil5PSDEFormLock;
        synchronized (n) {
            if (this.mobutil5psdeform != null && DataTypeHelper.compare((int)25, (Object)this.getMobUtil5PSDEFormId(), (Object)this.mobutil5psdeform.getPSDEFormId()) != 0L) {
                this.mobutil5psdeform = null;
            }
            if (this.mobutil5psdeform == null) {
                PSDEForm pSDEForm = new PSDEForm();
                pSDEForm.setPSDEFormId(this.getMobUtil5PSDEFormId());
                PSDEFormService pSDEFormService = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)this.getSessionFactory());
                pSDEFormService.autoGet((IEntity)pSDEForm);
                this.mobutil5psdeform = pSDEForm;
            }
            return this.mobutil5psdeform;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEForm getMobUtilPSDEForm() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobUtilPSDEForm();
        }
        if (this.getMobUtilPSDEFormId() == null) {
            return null;
        }
        Integer n = this.objMobUtilPSDEFormLock;
        synchronized (n) {
            if (this.mobutilpsdeform != null && DataTypeHelper.compare((int)25, (Object)this.getMobUtilPSDEFormId(), (Object)this.mobutilpsdeform.getPSDEFormId()) != 0L) {
                this.mobutilpsdeform = null;
            }
            if (this.mobutilpsdeform == null) {
                PSDEForm pSDEForm = new PSDEForm();
                pSDEForm.setPSDEFormId(this.getMobUtilPSDEFormId());
                PSDEFormService pSDEFormService = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)this.getSessionFactory());
                pSDEFormService.autoGet((IEntity)pSDEForm);
                this.mobutilpsdeform = pSDEForm;
            }
            return this.mobutilpsdeform;
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
                pSDEFormService.autoGet((IEntity)pSDEForm);
                this.psdeform = pSDEForm;
            }
            return this.psdeform;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEForm getUtil2PSDEForm() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtil2PSDEForm();
        }
        if (this.getUtil2PSDEFormId() == null) {
            return null;
        }
        Integer n = this.objUtil2PSDEFormLock;
        synchronized (n) {
            if (this.util2psdeform != null && DataTypeHelper.compare((int)25, (Object)this.getUtil2PSDEFormId(), (Object)this.util2psdeform.getPSDEFormId()) != 0L) {
                this.util2psdeform = null;
            }
            if (this.util2psdeform == null) {
                PSDEForm pSDEForm = new PSDEForm();
                pSDEForm.setPSDEFormId(this.getUtil2PSDEFormId());
                PSDEFormService pSDEFormService = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)this.getSessionFactory());
                pSDEFormService.autoGet((IEntity)pSDEForm);
                this.util2psdeform = pSDEForm;
            }
            return this.util2psdeform;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEForm getUtil3PSDEForm() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtil3PSDEForm();
        }
        if (this.getUtil3PSDEFormId() == null) {
            return null;
        }
        Integer n = this.objUtil3PSDEFormLock;
        synchronized (n) {
            if (this.util3psdeform != null && DataTypeHelper.compare((int)25, (Object)this.getUtil3PSDEFormId(), (Object)this.util3psdeform.getPSDEFormId()) != 0L) {
                this.util3psdeform = null;
            }
            if (this.util3psdeform == null) {
                PSDEForm pSDEForm = new PSDEForm();
                pSDEForm.setPSDEFormId(this.getUtil3PSDEFormId());
                PSDEFormService pSDEFormService = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)this.getSessionFactory());
                pSDEFormService.autoGet((IEntity)pSDEForm);
                this.util3psdeform = pSDEForm;
            }
            return this.util3psdeform;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEForm getUtil4PSDEForm() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtil4PSDEForm();
        }
        if (this.getUtil4PSDEFormId() == null) {
            return null;
        }
        Integer n = this.objUtil4PSDEFormLock;
        synchronized (n) {
            if (this.util4psdeform != null && DataTypeHelper.compare((int)25, (Object)this.getUtil4PSDEFormId(), (Object)this.util4psdeform.getPSDEFormId()) != 0L) {
                this.util4psdeform = null;
            }
            if (this.util4psdeform == null) {
                PSDEForm pSDEForm = new PSDEForm();
                pSDEForm.setPSDEFormId(this.getUtil4PSDEFormId());
                PSDEFormService pSDEFormService = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)this.getSessionFactory());
                pSDEFormService.autoGet((IEntity)pSDEForm);
                this.util4psdeform = pSDEForm;
            }
            return this.util4psdeform;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEForm getUtil5PSDEForm() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtil5PSDEForm();
        }
        if (this.getUtil5PSDEFormId() == null) {
            return null;
        }
        Integer n = this.objUtil5PSDEFormLock;
        synchronized (n) {
            if (this.util5psdeform != null && DataTypeHelper.compare((int)25, (Object)this.getUtil5PSDEFormId(), (Object)this.util5psdeform.getPSDEFormId()) != 0L) {
                this.util5psdeform = null;
            }
            if (this.util5psdeform == null) {
                PSDEForm pSDEForm = new PSDEForm();
                pSDEForm.setPSDEFormId(this.getUtil5PSDEFormId());
                PSDEFormService pSDEFormService = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)this.getSessionFactory());
                pSDEFormService.autoGet((IEntity)pSDEForm);
                this.util5psdeform = pSDEForm;
            }
            return this.util5psdeform;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEForm getUtilPSDEForm() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDEForm();
        }
        if (this.getUtilPSDEFormId() == null) {
            return null;
        }
        Integer n = this.objUtilPSDEFormLock;
        synchronized (n) {
            if (this.utilpsdeform != null && DataTypeHelper.compare((int)25, (Object)this.getUtilPSDEFormId(), (Object)this.utilpsdeform.getPSDEFormId()) != 0L) {
                this.utilpsdeform = null;
            }
            if (this.utilpsdeform == null) {
                PSDEForm pSDEForm = new PSDEForm();
                pSDEForm.setPSDEFormId(this.getUtilPSDEFormId());
                PSDEFormService pSDEFormService = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)this.getSessionFactory());
                pSDEFormService.autoGet((IEntity)pSDEForm);
                this.utilpsdeform = pSDEForm;
            }
            return this.utilpsdeform;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEUAGroup getMobPSDEUAGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobPSDEUAGroup();
        }
        if (this.getMobPSDEUAGroupId() == null) {
            return null;
        }
        Integer n = this.objMobPSDEUAGroupLock;
        synchronized (n) {
            if (this.mobpsdeuagroup != null && DataTypeHelper.compare((int)25, (Object)this.getMobPSDEUAGroupId(), (Object)this.mobpsdeuagroup.getPSDEUAGroupId()) != 0L) {
                this.mobpsdeuagroup = null;
            }
            if (this.mobpsdeuagroup == null) {
                PSDEUAGroup pSDEUAGroup = new PSDEUAGroup();
                pSDEUAGroup.setPSDEUAGroupId(this.getMobPSDEUAGroupId());
                PSDEUAGroupService pSDEUAGroupService = (PSDEUAGroupService)ServiceGlobal.getService(PSDEUAGroupService.class, (SessionFactory)this.getSessionFactory());
                pSDEUAGroupService.autoGet((IEntity)pSDEUAGroup);
                this.mobpsdeuagroup = pSDEUAGroup;
            }
            return this.mobpsdeuagroup;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEUAGroup getPSDEUAGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUAGroup();
        }
        if (this.getPSDEUAGroupId() == null) {
            return null;
        }
        Integer n = this.objPSDEUAGroupLock;
        synchronized (n) {
            if (this.psdeuagroup != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEUAGroupId(), (Object)this.psdeuagroup.getPSDEUAGroupId()) != 0L) {
                this.psdeuagroup = null;
            }
            if (this.psdeuagroup == null) {
                PSDEUAGroup pSDEUAGroup = new PSDEUAGroup();
                pSDEUAGroup.setPSDEUAGroupId(this.getPSDEUAGroupId());
                PSDEUAGroupService pSDEUAGroupService = (PSDEUAGroupService)ServiceGlobal.getService(PSDEUAGroupService.class, (SessionFactory)this.getSessionFactory());
                pSDEUAGroupService.autoGet((IEntity)pSDEUAGroup);
                this.psdeuagroup = pSDEUAGroup;
            }
            return this.psdeuagroup;
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
                pSDEViewBaseService.autoGet((IEntity)pSDEViewBase);
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
                pSDEViewBaseService.autoGet((IEntity)pSDEViewBase);
                this.psdeviewbase = pSDEViewBase;
            }
            return this.psdeviewbase;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguageRes getNamePSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNamePSLanRes();
        }
        if (this.getNamePSLanResId() == null) {
            return null;
        }
        Integer n = this.objNamePSLanResLock;
        synchronized (n) {
            if (this.namepslanres != null && DataTypeHelper.compare((int)25, (Object)this.getNamePSLanResId(), (Object)this.namepslanres.getPSLanguageResId()) != 0L) {
                this.namepslanres = null;
            }
            if (this.namepslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getNamePSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet((IEntity)pSLanguageRes);
                this.namepslanres = pSLanguageRes;
            }
            return this.namepslanres;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysMsgTempl getPSSysMsgTempl() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysMsgTempl();
        }
        if (this.getPSSysMsgTemplId() == null) {
            return null;
        }
        Integer n = this.objPSSysMsgTemplLock;
        synchronized (n) {
            if (this.pssysmsgtempl != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysMsgTemplId(), (Object)this.pssysmsgtempl.getPSSysMsgTemplId()) != 0L) {
                this.pssysmsgtempl = null;
            }
            if (this.pssysmsgtempl == null) {
                PSSysMsgTempl pSSysMsgTempl = new PSSysMsgTempl();
                pSSysMsgTempl.setPSSysMsgTemplId(this.getPSSysMsgTemplId());
                PSSysMsgTemplService pSSysMsgTemplService = (PSSysMsgTemplService)ServiceGlobal.getService(PSSysMsgTemplService.class, (SessionFactory)this.getSessionFactory());
                pSSysMsgTemplService.autoGet((IEntity)pSSysMsgTempl);
                this.pssysmsgtempl = pSSysMsgTempl;
            }
            return this.pssysmsgtempl;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSWFDE getEmbedPSWFDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEmbedPSWFDE();
        }
        if (this.getEmbedPSWFDEId() == null) {
            return null;
        }
        Integer n = this.objEmbedPSWFDELock;
        synchronized (n) {
            if (this.embedpswfde != null && DataTypeHelper.compare((int)25, (Object)this.getEmbedPSWFDEId(), (Object)this.embedpswfde.getPSWFDEId()) != 0L) {
                this.embedpswfde = null;
            }
            if (this.embedpswfde == null) {
                PSWFDE pSWFDE = new PSWFDE();
                pSWFDE.setPSWFDEId(this.getEmbedPSWFDEId());
                PSWFDEService pSWFDEService = (PSWFDEService)ServiceGlobal.getService(PSWFDEService.class, (SessionFactory)this.getSessionFactory());
                pSWFDEService.autoGet((IEntity)pSWFDE);
                this.embedpswfde = pSWFDE;
            }
            return this.embedpswfde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSWFDE getPSWFDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFDE();
        }
        if (this.getPSWFDEId() == null) {
            return null;
        }
        Integer n = this.objPSWFDELock;
        synchronized (n) {
            if (this.pswfde != null && DataTypeHelper.compare((int)25, (Object)this.getPSWFDEId(), (Object)this.pswfde.getPSWFDEId()) != 0L) {
                this.pswfde = null;
            }
            if (this.pswfde == null) {
                PSWFDE pSWFDE = new PSWFDE();
                pSWFDE.setPSWFDEId(this.getPSWFDEId());
                PSWFDEService pSWFDEService = (PSWFDEService)ServiceGlobal.getService(PSWFDEService.class, (SessionFactory)this.getSessionFactory());
                pSWFDEService.autoGet((IEntity)pSWFDE);
                this.pswfde = pSWFDE;
            }
            return this.pswfde;
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
                pSWFVersionService.autoGet((IEntity)pSWFVersion);
                this.pswfversion = pSWFVersion;
            }
            return this.pswfversion;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSWFVersion getRefPSWFVersion() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSWFVersion();
        }
        if (this.getRefPSWFVersionId() == null) {
            return null;
        }
        Integer n = this.objRefPSWFVersionLock;
        synchronized (n) {
            if (this.refpswfversion != null && DataTypeHelper.compare((int)25, (Object)this.getRefPSWFVersionId(), (Object)this.refpswfversion.getPSWFVersionId()) != 0L) {
                this.refpswfversion = null;
            }
            if (this.refpswfversion == null) {
                PSWFVersion pSWFVersion = new PSWFVersion();
                pSWFVersion.setPSWFVersionId(this.getRefPSWFVersionId());
                PSWFVersionService pSWFVersionService = (PSWFVersionService)ServiceGlobal.getService(PSWFVersionService.class, (SessionFactory)this.getSessionFactory());
                pSWFVersionService.autoGet((IEntity)pSWFVersion);
                this.refpswfversion = pSWFVersion;
            }
            return this.refpswfversion;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSWFWorkTime getPSWFWorktime() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFWorktime();
        }
        if (this.getPSWFWorkTimeId() == null) {
            return null;
        }
        Integer n = this.objPSWFWorktimeLock;
        synchronized (n) {
            if (this.pswfworktime != null && DataTypeHelper.compare((int)25, (Object)this.getPSWFWorkTimeId(), (Object)this.pswfworktime.getPSWFWorkTimeId()) != 0L) {
                this.pswfworktime = null;
            }
            if (this.pswfworktime == null) {
                PSWFWorkTime pSWFWorkTime = new PSWFWorkTime();
                pSWFWorkTime.setPSWFWorkTimeId(this.getPSWFWorkTimeId());
                PSWFWorkTimeService pSWFWorkTimeService = (PSWFWorkTimeService)ServiceGlobal.getService(PSWFWorkTimeService.class, (SessionFactory)this.getSessionFactory());
                pSWFWorkTimeService.autoGet((IEntity)pSWFWorkTime);
                this.pswfworktime = pSWFWorkTime;
            }
            return this.pswfworktime;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSWorkflow getEmbedPSWF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEmbedPSWF();
        }
        if (this.getEmbedPSWFId() == null) {
            return null;
        }
        Integer n = this.objEmbedPSWFLock;
        synchronized (n) {
            if (this.embedpswf != null && DataTypeHelper.compare((int)25, (Object)this.getEmbedPSWFId(), (Object)this.embedpswf.getPSWorkflowId()) != 0L) {
                this.embedpswf = null;
            }
            if (this.embedpswf == null) {
                PSWorkflow pSWorkflow = new PSWorkflow();
                pSWorkflow.setPSWorkflowId(this.getEmbedPSWFId());
                PSWorkflowService pSWorkflowService = (PSWorkflowService)ServiceGlobal.getService(PSWorkflowService.class, (SessionFactory)this.getSessionFactory());
                pSWorkflowService.autoGet((IEntity)pSWorkflow);
                this.embedpswf = pSWorkflow;
            }
            return this.embedpswf;
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
                pSWorkflowService.autoGet((IEntity)pSWorkflow);
                this.pswf = pSWorkflow;
            }
            return this.pswf;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSWFProcParam> getPSWFProcParams() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFProcParams();
        }
        if (this.getPSWFProcessId() == null) {
            return null;
        }
        PSWFProcessService pSWFProcessService = (PSWFProcessService)ServiceGlobal.getService(PSWFProcessService.class, (SessionFactory)this.getSessionFactory());
        PSWFProcParamService pSWFProcParamService = (PSWFProcParamService)ServiceGlobal.getService(PSWFProcParamService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSWFProcParamsLock;
        synchronized (n) {
            if (this.pswfprocparams == null) {
                this.pswfprocparams = pSWFProcessService.isTempData((IEntity)this) ? pSWFProcParamService.selectTempByPSWFProcess(this) : pSWFProcParamService.selectByPSWFProcess(this);
            }
            return this.pswfprocparams;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSWFProcRole> getPSWFProcRoles() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFProcRoles();
        }
        if (this.getPSWFProcessId() == null) {
            return null;
        }
        PSWFProcessService pSWFProcessService = (PSWFProcessService)ServiceGlobal.getService(PSWFProcessService.class, (SessionFactory)this.getSessionFactory());
        PSWFProcRoleService pSWFProcRoleService = (PSWFProcRoleService)ServiceGlobal.getService(PSWFProcRoleService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSWFProcRolesLock;
        synchronized (n) {
            if (this.pswfprocroles == null) {
                this.pswfprocroles = pSWFProcessService.isTempData((IEntity)this) ? pSWFProcRoleService.selectTempByPSWFProcess(this) : pSWFProcRoleService.selectByPSWFProcess(this);
            }
            return this.pswfprocroles;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSWFProcSubWF> getPSWFProcSubWFs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFProcSubWFs();
        }
        if (this.getPSWFProcessId() == null) {
            return null;
        }
        PSWFProcessService pSWFProcessService = (PSWFProcessService)ServiceGlobal.getService(PSWFProcessService.class, (SessionFactory)this.getSessionFactory());
        PSWFProcSubWFService pSWFProcSubWFService = (PSWFProcSubWFService)ServiceGlobal.getService(PSWFProcSubWFService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSWFProcSubWFsLock;
        synchronized (n) {
            if (this.pswfprocsubwfs == null) {
                this.pswfprocsubwfs = pSWFProcessService.isTempData((IEntity)this) ? pSWFProcSubWFService.selectTempByPSWFProcess(this) : pSWFProcSubWFService.selectByPSWFProcess(this);
            }
            return this.pswfprocsubwfs;
        }
    }

    private PSWFProcessBase getProxyEntity() {
        return this.proxyPSWFProcessBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSWFProcessBase = null;
        if (iDataObject != null && iDataObject instanceof PSWFProcessBase) {
            this.proxyPSWFProcessBase = (PSWFProcessBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWFProcessService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ASYNCMODE, 0);
        fieldIndexMap.put(FIELD_CODENAME, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 4);
        fieldIndexMap.put(FIELD_EDITFIELDS, 5);
        fieldIndexMap.put(FIELD_EDITFLAG, 6);
        fieldIndexMap.put(FIELD_EDITPSDEFGROUPID, 7);
        fieldIndexMap.put(FIELD_EDITPSDEFGROUPNAME, 8);
        fieldIndexMap.put(FIELD_EMBEDPSDEDSID, 9);
        fieldIndexMap.put(FIELD_EMBEDPSDEDSNAME, 10);
        fieldIndexMap.put(FIELD_EMBEDPSDEID, 11);
        fieldIndexMap.put(FIELD_EMBEDPSWFDEID, 12);
        fieldIndexMap.put(FIELD_EMBEDPSWFDENAME, 13);
        fieldIndexMap.put(FIELD_EMBEDPSWFID, 14);
        fieldIndexMap.put(FIELD_EMBEDPSWFNAME, 15);
        fieldIndexMap.put(FIELD_ENABLE, 16);
        fieldIndexMap.put(FIELD_ENABLEMOBILE, 17);
        fieldIndexMap.put(FIELD_ENABLETIMEOUT, 18);
        fieldIndexMap.put(FIELD_EXITSTATENAME, 19);
        fieldIndexMap.put(FIELD_EXITSTATEVALUE, 20);
        fieldIndexMap.put(FIELD_FORMCODENAME, 21);
        fieldIndexMap.put(FIELD_HEIGHT, 22);
        fieldIndexMap.put(FIELD_ICONPATH, 23);
        fieldIndexMap.put(FIELD_LEFTPOS, 24);
        fieldIndexMap.put(FIELD_MEMO, 25);
        fieldIndexMap.put(FIELD_MEMOFIELD, 26);
        fieldIndexMap.put(FIELD_MOBFORMCODENAME, 27);
        fieldIndexMap.put(FIELD_MOBPSDEFORMID, 28);
        fieldIndexMap.put(FIELD_MOBPSDEFORMNAME, 29);
        fieldIndexMap.put(FIELD_MOBPSDEUAGROUPID, 30);
        fieldIndexMap.put(FIELD_MOBPSDEUAGROUPNAME, 31);
        fieldIndexMap.put(FIELD_MOBPSDEVIEWID, 32);
        fieldIndexMap.put(FIELD_MOBPSDEVIEWNAME, 33);
        fieldIndexMap.put(FIELD_MOBPSDYNADEVIEWTEMPLID, 34);
        fieldIndexMap.put(FIELD_MOBUAGROUPCODENAME, 35);
        fieldIndexMap.put(FIELD_MOBUTIL2FORMCODENAME, 36);
        fieldIndexMap.put(FIELD_MOBUTIL2PSDEFORMID, 37);
        fieldIndexMap.put(FIELD_MOBUTIL2PSDEFORMNAME, 38);
        fieldIndexMap.put(FIELD_MOBUTIL3FORMCODENAME, 39);
        fieldIndexMap.put(FIELD_MOBUTIL3PSDEFORMID, 40);
        fieldIndexMap.put(FIELD_MOBUTIL3PSDEFORMNAME, 41);
        fieldIndexMap.put(FIELD_MOBUTIL4FORMCODENAME, 42);
        fieldIndexMap.put(FIELD_MOBUTIL4PSDEFORMID, 43);
        fieldIndexMap.put(FIELD_MOBUTIL4PSDEFORMNAME, 44);
        fieldIndexMap.put(FIELD_MOBUTIL5FORMCODENAME, 45);
        fieldIndexMap.put(FIELD_MOBUTIL5PSDEFORMID, 46);
        fieldIndexMap.put(FIELD_MOBUTIL5PSDEFORMNAME, 47);
        fieldIndexMap.put(FIELD_MOBUTILFORMCODENAME, 48);
        fieldIndexMap.put(FIELD_MOBUTILPSDEFORMID, 49);
        fieldIndexMap.put(FIELD_MOBUTILPSDEFORMNAME, 50);
        fieldIndexMap.put(FIELD_MOBWFEDITVIEWTYPE, 51);
        fieldIndexMap.put(FIELD_MODELID, 52);
        fieldIndexMap.put(FIELD_MSGTYPE, 53);
        fieldIndexMap.put(FIELD_MULTIINSTMODE, 54);
        fieldIndexMap.put(FIELD_NAMEPSLANRESID, 55);
        fieldIndexMap.put(FIELD_NAMEPSLANRESNAME, 56);
        fieldIndexMap.put(FIELD_NORMALPROCTYPE, 57);
        fieldIndexMap.put(FIELD_PREDEFINEDACTIONS, 58);
        fieldIndexMap.put(FIELD_PSDEACTIONID, 59);
        fieldIndexMap.put(FIELD_PSDEACTIONNAME, 60);
        fieldIndexMap.put(FIELD_PSDEFORMID, 61);
        fieldIndexMap.put(FIELD_PSDEFORMNAME, 62);
        fieldIndexMap.put(FIELD_PSDEID, 63);
        fieldIndexMap.put(FIELD_PSDEUAGROUPID, 64);
        fieldIndexMap.put(FIELD_PSDEUAGROUPNAME, 65);
        fieldIndexMap.put(FIELD_PSDEVIEWBASEID, 66);
        fieldIndexMap.put(FIELD_PSDEVIEWBASENAME, 67);
        fieldIndexMap.put(FIELD_PSDYNADEVIEWTEMPLID, 68);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 69);
        fieldIndexMap.put(FIELD_PSSYSMSGTEMPLID, 70);
        fieldIndexMap.put(FIELD_PSSYSMSGTEMPLNAME, 71);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 72);
        fieldIndexMap.put(FIELD_PSWFDEID, 73);
        fieldIndexMap.put(FIELD_PSWFDENAME, 74);
        fieldIndexMap.put(FIELD_PSWFID, 75);
        fieldIndexMap.put(FIELD_PSWFNAME, 76);
        fieldIndexMap.put(FIELD_PSWFPROCESSID, 77);
        fieldIndexMap.put(FIELD_PSWFPROCESSNAME, 78);
        fieldIndexMap.put(FIELD_PSWFVERSIONID, 79);
        fieldIndexMap.put(FIELD_PSWFVERSIONNAME, 80);
        fieldIndexMap.put(FIELD_PSWFWORKTIMEID, 81);
        fieldIndexMap.put(FIELD_PSWFWORKTIMENAME, 82);
        fieldIndexMap.put(FIELD_REFPSWFVERSIONID, 83);
        fieldIndexMap.put(FIELD_REFPSWFVERSIONNAME, 84);
        fieldIndexMap.put(FIELD_SENDINFORM, 85);
        fieldIndexMap.put(FIELD_SHAPEPARAMS, 86);
        fieldIndexMap.put(FIELD_THREADNAME, 87);
        fieldIndexMap.put(FIELD_THREADSN, 88);
        fieldIndexMap.put(FIELD_TIMEOUT, 89);
        fieldIndexMap.put(FIELD_TIMEOUTPSDEFID, 90);
        fieldIndexMap.put(FIELD_TIMEOUTPSDEFNAME, 91);
        fieldIndexMap.put(FIELD_TIMEOUTTYPE, 92);
        fieldIndexMap.put(FIELD_TOPPOS, 93);
        fieldIndexMap.put(FIELD_UAGROUPCODENAME, 94);
        fieldIndexMap.put(FIELD_UPDATEDATE, 95);
        fieldIndexMap.put(FIELD_UPDATEMAN, 96);
        fieldIndexMap.put(FIELD_USERCAT, 97);
        fieldIndexMap.put(FIELD_USERDATA, 98);
        fieldIndexMap.put(FIELD_USERDATA2, 99);
        fieldIndexMap.put(FIELD_USERTAG, 100);
        fieldIndexMap.put(FIELD_USERTAG2, 101);
        fieldIndexMap.put(FIELD_USERTAG3, 102);
        fieldIndexMap.put(FIELD_USERTAG4, 103);
        fieldIndexMap.put(FIELD_UTIL2FORMCODENAME, 104);
        fieldIndexMap.put(FIELD_UTIL2PSDEFORMID, 105);
        fieldIndexMap.put(FIELD_UTIL2PSDEFORMNAME, 106);
        fieldIndexMap.put(FIELD_UTIL3FORMCODENAME, 107);
        fieldIndexMap.put(FIELD_UTIL3PSDEFORMID, 108);
        fieldIndexMap.put(FIELD_UTIL3PSDEFORMNAME, 109);
        fieldIndexMap.put(FIELD_UTIL4FORMCODENAME, 110);
        fieldIndexMap.put(FIELD_UTIL4PSDEFORMID, 111);
        fieldIndexMap.put(FIELD_UTIL4PSDEFORMNAME, 112);
        fieldIndexMap.put(FIELD_UTIL5FORMCODENAME, 113);
        fieldIndexMap.put(FIELD_UTIL5PSDEFORMID, 114);
        fieldIndexMap.put(FIELD_UTIL5PSDEFORMNAME, 115);
        fieldIndexMap.put(FIELD_UTILFORMCODENAME, 116);
        fieldIndexMap.put(FIELD_UTILPSDEFORMID, 117);
        fieldIndexMap.put(FIELD_UTILPSDEFORMNAME, 118);
        fieldIndexMap.put(FIELD_WFEDITVIEWTYPE, 119);
        fieldIndexMap.put(FIELD_WFENGINETYPE, 120);
        fieldIndexMap.put(FIELD_WFPROCESSTYPE, 121);
        fieldIndexMap.put(FIELD_WFSTEPNAME, 122);
        fieldIndexMap.put(FIELD_WFSTEPVALUE, 123);
        fieldIndexMap.put(FIELD_WIDTH, 124);
    }
}

