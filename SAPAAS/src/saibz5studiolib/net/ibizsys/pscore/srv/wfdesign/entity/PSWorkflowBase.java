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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysMsgTempl;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMsgTemplService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.ibizsys.pscore.srv.wfdesign.entity.PSSysWFCat;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFDE;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFVersion;
import net.ibizsys.pscore.srv.wfdesign.service.PSSysWFCatService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFDEService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFVersionService;
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXAccount;
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXEntApp;
import net.ibizsys.pscore.srv.wxdesign.service.PSWXAccountService;
import net.ibizsys.pscore.srv.wxdesign.service.PSWXEntAppService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSWorkflowBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSWorkflowBase.class);
    public static final String FIELD_ACTIONMOBPSDEVIEWID = "ACTIONMOBPSDEVIEWID";
    public static final String FIELD_ACTIONMOBPSDEVIEWNAME = "ACTIONMOBPSDEVIEWNAME";
    public static final String FIELD_ACTIONPSDEVIEWID = "ACTIONPSDEVIEWID";
    public static final String FIELD_ACTIONPSDEVIEWNAME = "ACTIONPSDEVIEWNAME";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_EDITABLEWFSTEP = "EDITABLEWFSTEP";
    public static final String FIELD_ENABLE = "ENABLE";
    public static final String FIELD_ENABLEDYNASYS = "ENABLEDYNASYS";
    public static final String FIELD_ENABLEDYNAVIEW = "ENABLEDYNAVIEW";
    public static final String FIELD_ENABLEMOB = "ENABLEMOB";
    public static final String FIELD_EXTCNTSTATES = "EXTCNTSTATES";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MOBWFEDITVIEWTYPE = "MOBWFEDITVIEWTYPE";
    public static final String FIELD_MODCOLOR = "MODCOLOR";
    public static final String FIELD_NAMEPSLANRESID = "NAMEPSLANRESID";
    public static final String FIELD_NAMEPSLANRESNAME = "NAMEPSLANRESNAME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSREQITEMID = "PSSYSREQITEMID";
    public static final String FIELD_PSSYSREQITEMNAME = "PSSYSREQITEMNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_PSSYSWFCATID = "PSSYSWFCATID";
    public static final String FIELD_PSSYSWFCATNAME = "PSSYSWFCATNAME";
    public static final String FIELD_PSWFDESCNT = "PSWFDESCNT";
    public static final String FIELD_PSWFVERSIONSCNT = "PSWFVERSIONSCNT";
    public static final String FIELD_PSWORKFLOWID = "PSWORKFLOWID";
    public static final String FIELD_PSWORKFLOWNAME = "PSWORKFLOWNAME";
    public static final String FIELD_PSWXACCOUNTID = "PSWXACCOUNTID";
    public static final String FIELD_PSWXACCOUNTNAME = "PSWXACCOUNTNAME";
    public static final String FIELD_PSWXENTAPPID = "PSWXENTAPPID";
    public static final String FIELD_PSWXENTAPPNAME = "PSWXENTAPPNAME";
    public static final String FIELD_REMINDPSSYSMSGTEMPLID = "REMINDPSSYSMSGTEMPLID";
    public static final String FIELD_REMINDPSSYSMSGTEMPLNAME = "REMINDPSSYSMSGTEMPLNAME";
    public static final String FIELD_REMOTEENGINEFLAG = "REMOTEENGINEFLAG";
    public static final String FIELD_STARTMOBPSDEVIEWID = "STARTMOBPSDEVIEWID";
    public static final String FIELD_STARTMOBPSDEVIEWNAME = "STARTMOBPSDEVIEWNAME";
    public static final String FIELD_STARTPSDEVIEWID = "STARTPSDEVIEWID";
    public static final String FIELD_STARTPSDEVIEWNAME = "STARTPSDEVIEWNAME";
    public static final String FIELD_STATECODELISTID = "STATECODELISTID";
    public static final String FIELD_STATECODELISTNAME = "STATECODELISTNAME";
    public static final String FIELD_TODOTASK = "TODOTASK";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    public static final String FIELD_WFCANCELVALUE = "WFCANCELVALUE";
    public static final String FIELD_WFCANCELVALUETEXT = "WFCANCELVALUETEXT";
    public static final String FIELD_WFEDITVIEWTYPE = "WFEDITVIEWTYPE";
    public static final String FIELD_WFENGINETYPE = "WFENGINETYPE";
    public static final String FIELD_WFERRORVALUE = "WFERRORVALUE";
    public static final String FIELD_WFERRORVALUETEXT = "WFERRORVALUETEXT";
    public static final String FIELD_WFFINISHVALUE = "WFFINISHEVALUE";
    public static final String FIELD_WFFINISHVALUETEXT = "WFFINISHEVALUETEXT";
    public static final String FIELD_WFPROXYMODE = "WFPROXYMODE";
    public static final String FIELD_WFSN = "WFSN";
    public static final String FIELD_WFSTATEVALUE = "WFSTATEVALUE";
    public static final String FIELD_WFSTEPCODELISTID = "WFSTEPCODELISTID";
    public static final String FIELD_WFSTEPCODELISTNAME = "WFSTEPCODELISTNAME";
    public static final String FIELD_WFTAG = "WFTAG";
    public static final String FIELD_WFTAG2 = "WFTAG2";
    public static final String FIELD_WFTAG3 = "WFTAG3";
    public static final String FIELD_WFTAG4 = "WFTAG4";
    public static final String FIELD_WFTYPE = "WFTYPE";
    private static final int INDEX_ACTIONMOBPSDEVIEWID = 0;
    private static final int INDEX_ACTIONMOBPSDEVIEWNAME = 1;
    private static final int INDEX_ACTIONPSDEVIEWID = 2;
    private static final int INDEX_ACTIONPSDEVIEWNAME = 3;
    private static final int INDEX_CODENAME = 4;
    private static final int INDEX_CREATEDATE = 5;
    private static final int INDEX_CREATEMAN = 6;
    private static final int INDEX_DYNAMODELFLAG = 7;
    private static final int INDEX_EDITABLEWFSTEP = 8;
    private static final int INDEX_ENABLE = 9;
    private static final int INDEX_ENABLEDYNASYS = 10;
    private static final int INDEX_ENABLEDYNAVIEW = 11;
    private static final int INDEX_ENABLEMOB = 12;
    private static final int INDEX_EXTCNTSTATES = 13;
    private static final int INDEX_LOCKFLAG = 14;
    private static final int INDEX_MEMO = 15;
    private static final int INDEX_MOBWFEDITVIEWTYPE = 16;
    private static final int INDEX_MODCOLOR = 17;
    private static final int INDEX_NAMEPSLANRESID = 18;
    private static final int INDEX_NAMEPSLANRESNAME = 19;
    private static final int INDEX_PSDYNAINSTID = 20;
    private static final int INDEX_PSMODULEID = 21;
    private static final int INDEX_PSMODULENAME = 22;
    private static final int INDEX_PSSYSREQITEMID = 23;
    private static final int INDEX_PSSYSREQITEMNAME = 24;
    private static final int INDEX_PSSYSTEMID = 25;
    private static final int INDEX_PSSYSTEMNAME = 26;
    private static final int INDEX_PSSYSWFCATID = 27;
    private static final int INDEX_PSSYSWFCATNAME = 28;
    private static final int INDEX_PSWFDESCNT = 29;
    private static final int INDEX_PSWFVERSIONSCNT = 30;
    private static final int INDEX_PSWORKFLOWID = 31;
    private static final int INDEX_PSWORKFLOWNAME = 32;
    private static final int INDEX_PSWXACCOUNTID = 33;
    private static final int INDEX_PSWXACCOUNTNAME = 34;
    private static final int INDEX_PSWXENTAPPID = 35;
    private static final int INDEX_PSWXENTAPPNAME = 36;
    private static final int INDEX_REMINDPSSYSMSGTEMPLID = 37;
    private static final int INDEX_REMINDPSSYSMSGTEMPLNAME = 38;
    private static final int INDEX_REMOTEENGINEFLAG = 39;
    private static final int INDEX_STARTMOBPSDEVIEWID = 40;
    private static final int INDEX_STARTMOBPSDEVIEWNAME = 41;
    private static final int INDEX_STARTPSDEVIEWID = 42;
    private static final int INDEX_STARTPSDEVIEWNAME = 43;
    private static final int INDEX_STATECODELISTID = 44;
    private static final int INDEX_STATECODELISTNAME = 45;
    private static final int INDEX_TODOTASK = 46;
    private static final int INDEX_UPDATEDATE = 47;
    private static final int INDEX_UPDATEMAN = 48;
    private static final int INDEX_USERCAT = 49;
    private static final int INDEX_USERTAG = 50;
    private static final int INDEX_USERTAG2 = 51;
    private static final int INDEX_USERTAG3 = 52;
    private static final int INDEX_USERTAG4 = 53;
    private static final int INDEX_VALIDFLAG = 54;
    private static final int INDEX_WFCANCELVALUE = 55;
    private static final int INDEX_WFCANCELVALUETEXT = 56;
    private static final int INDEX_WFEDITVIEWTYPE = 57;
    private static final int INDEX_WFENGINETYPE = 58;
    private static final int INDEX_WFERRORVALUE = 59;
    private static final int INDEX_WFERRORVALUETEXT = 60;
    private static final int INDEX_WFFINISHVALUE = 61;
    private static final int INDEX_WFFINISHVALUETEXT = 62;
    private static final int INDEX_WFPROXYMODE = 63;
    private static final int INDEX_WFSN = 64;
    private static final int INDEX_WFSTATEVALUE = 65;
    private static final int INDEX_WFSTEPCODELISTID = 66;
    private static final int INDEX_WFSTEPCODELISTNAME = 67;
    private static final int INDEX_WFTAG = 68;
    private static final int INDEX_WFTAG2 = 69;
    private static final int INDEX_WFTAG3 = 70;
    private static final int INDEX_WFTAG4 = 71;
    private static final int INDEX_WFTYPE = 72;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSWorkflowBase proxyPSWorkflowBase = null;
    private boolean actionmobpsdeviewidDirtyFlag = false;
    private boolean actionmobpsdeviewnameDirtyFlag = false;
    private boolean actionpsdeviewidDirtyFlag = false;
    private boolean actionpsdeviewnameDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean editablewfstepDirtyFlag = false;
    private boolean enableDirtyFlag = false;
    private boolean enabledynasysDirtyFlag = false;
    private boolean enabledynaviewDirtyFlag = false;
    private boolean enablemobDirtyFlag = false;
    private boolean extcntstatesDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean mobwfeditviewtypeDirtyFlag = false;
    private boolean modcolorDirtyFlag = false;
    private boolean namepslanresidDirtyFlag = false;
    private boolean namepslanresnameDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssysreqitemidDirtyFlag = false;
    private boolean pssysreqitemnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean pssyswfcatidDirtyFlag = false;
    private boolean pssyswfcatnameDirtyFlag = false;
    private boolean pswfdescntDirtyFlag = false;
    private boolean pswfversionscntDirtyFlag = false;
    private boolean psworkflowidDirtyFlag = false;
    private boolean psworkflownameDirtyFlag = false;
    private boolean pswxaccountidDirtyFlag = false;
    private boolean pswxaccountnameDirtyFlag = false;
    private boolean pswxentappidDirtyFlag = false;
    private boolean pswxentappnameDirtyFlag = false;
    private boolean remindpssysmsgtemplidDirtyFlag = false;
    private boolean remindpssysmsgtemplnameDirtyFlag = false;
    private boolean remoteengineflagDirtyFlag = false;
    private boolean startmobpsdeviewidDirtyFlag = false;
    private boolean startmobpsdeviewnameDirtyFlag = false;
    private boolean startpsdeviewidDirtyFlag = false;
    private boolean startpsdeviewnameDirtyFlag = false;
    private boolean statecodelistidDirtyFlag = false;
    private boolean statecodelistnameDirtyFlag = false;
    private boolean todotaskDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    private boolean wfcancelvalueDirtyFlag = false;
    private boolean wfcancelvaluetextDirtyFlag = false;
    private boolean wfeditviewtypeDirtyFlag = false;
    private boolean wfenginetypeDirtyFlag = false;
    private boolean wferrorvalueDirtyFlag = false;
    private boolean wferrorvaluetextDirtyFlag = false;
    private boolean wffinishvalueDirtyFlag = false;
    private boolean wffinishvaluetextDirtyFlag = false;
    private boolean wfproxymodeDirtyFlag = false;
    private boolean wfsnDirtyFlag = false;
    private boolean wfstatevalueDirtyFlag = false;
    private boolean wfstepcodelistidDirtyFlag = false;
    private boolean wfstepcodelistnameDirtyFlag = false;
    private boolean wftagDirtyFlag = false;
    private boolean wftag2DirtyFlag = false;
    private boolean wftag3DirtyFlag = false;
    private boolean wftag4DirtyFlag = false;
    private boolean wftypeDirtyFlag = false;
    @Column(name="actionmobpsdeviewid")
    private String actionmobpsdeviewid;
    @Column(name="actionmobpsdeviewname")
    private String actionmobpsdeviewname;
    @Column(name="actionpsdeviewid")
    private String actionpsdeviewid;
    @Column(name="actionpsdeviewname")
    private String actionpsdeviewname;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="editablewfstep")
    private String editablewfstep;
    @Column(name="enable")
    private Integer enable;
    @Column(name="enabledynasys")
    private Integer enabledynasys;
    @Column(name="enabledynaview")
    private Integer enabledynaview;
    @Column(name="enablemob")
    private Integer enablemob;
    @Column(name="extcntstates")
    private String extcntstates;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="memo")
    private String memo;
    @Column(name="mobwfeditviewtype")
    private String mobwfeditviewtype;
    @Column(name="modcolor")
    private String modcolor;
    @Column(name="namepslanresid")
    private String namepslanresid;
    @Column(name="namepslanresname")
    private String namepslanresname;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssysreqitemid")
    private String pssysreqitemid;
    @Column(name="pssysreqitemname")
    private String pssysreqitemname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="pssyswfcatid")
    private String pssyswfcatid;
    @Column(name="pssyswfcatname")
    private String pssyswfcatname;
    @Column(name="pswfdescnt")
    private Integer pswfdescnt;
    @Column(name="pswfversionscnt")
    private Integer pswfversionscnt;
    @Column(name="psworkflowid")
    private String psworkflowid;
    @Column(name="psworkflowname")
    private String psworkflowname;
    @Column(name="pswxaccountid")
    private String pswxaccountid;
    @Column(name="pswxaccountname")
    private String pswxaccountname;
    @Column(name="pswxentappid")
    private String pswxentappid;
    @Column(name="pswxentappname")
    private String pswxentappname;
    @Column(name="remindpssysmsgtemplid")
    private String remindpssysmsgtemplid;
    @Column(name="remindpssysmsgtemplname")
    private String remindpssysmsgtemplname;
    @Column(name="remoteengineflag")
    private Integer remoteengineflag;
    @Column(name="startmobpsdeviewid")
    private String startmobpsdeviewid;
    @Column(name="startmobpsdeviewname")
    private String startmobpsdeviewname;
    @Column(name="startpsdeviewid")
    private String startpsdeviewid;
    @Column(name="startpsdeviewname")
    private String startpsdeviewname;
    @Column(name="statecodelistid")
    private String statecodelistid;
    @Column(name="statecodelistname")
    private String statecodelistname;
    @Column(name="todotask")
    private String todotask;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usercat")
    private String usercat;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="usertag3")
    private String usertag3;
    @Column(name="usertag4")
    private String usertag4;
    @Column(name="validflag")
    private Integer validflag;
    @Column(name="wfcancelvalue")
    private String wfcancelvalue;
    @Column(name="wfcancelvaluetext")
    private String wfcancelvaluetext;
    @Column(name="wfeditviewtype")
    private String wfeditviewtype;
    @Column(name="wfenginetype")
    private String wfenginetype;
    @Column(name="wferrorvalue")
    private String wferrorvalue;
    @Column(name="wferrorvaluetext")
    private String wferrorvaluetext;
    @Column(name="wffinishvalue")
    private String wffinishvalue;
    @Column(name="wffinishvaluetext")
    private String wffinishvaluetext;
    @Column(name="wfproxymode")
    private Integer wfproxymode;
    @Column(name="wfsn")
    private String wfsn;
    @Column(name="wfstatevalue")
    private String wfstatevalue;
    @Column(name="wfstepcodelistid")
    private String wfstepcodelistid;
    @Column(name="wfstepcodelistname")
    private String wfstepcodelistname;
    @Column(name="wftag")
    private String wftag;
    @Column(name="wftag2")
    private String wftag2;
    @Column(name="wftag3")
    private String wftag3;
    @Column(name="wftag4")
    private String wftag4;
    @Column(name="wftype")
    private String wftype;
    private Integer objStateCodeListLock = new Integer(1);
    private PSCodeList statecodelist = null;
    private Integer objWFStepCodeListLock = new Integer(1);
    private PSCodeList wfstepcodelist = null;
    private Integer objActionMobPSDEViewLock = new Integer(1);
    private PSDEViewBase actionmobpsdeview = null;
    private Integer objActionPSDEViewLock = new Integer(1);
    private PSDEViewBase actionpsdeview = null;
    private Integer objStartMobPSDEViewLock = new Integer(1);
    private PSDEViewBase startmobpsdeview = null;
    private Integer objStartPSDEViewLock = new Integer(1);
    private PSDEViewBase startpsdeview = null;
    private Integer objNamePSLanResLock = new Integer(1);
    private PSLanguageRes namepslanres = null;
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objRemindPSSysMsgTemplLock = new Integer(1);
    private PSSysMsgTempl remindpssysmsgtempl = null;
    private Integer objPSSysReqItemLock = new Integer(1);
    private PSSysReqItem pssysreqitem = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSSysWFCatLock = new Integer(1);
    private PSSysWFCat pssyswfcat = null;
    private Integer objPSWXAccountLock = new Integer(1);
    private PSWXAccount pswxaccount = null;
    private Integer objPSWXEntAppLock = new Integer(1);
    private PSWXEntApp pswxentapp = null;
    private Integer objPSWFDEsLock = new Integer(1);
    private ArrayList<PSWFDE> pswfdes = null;
    private Integer objPSWFVersionsLock = new Integer(1);
    private ArrayList<PSWFVersion> pswfversions = null;

    public void setActionMobPSDEViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionMobPSDEViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actionmobpsdeviewid = string;
        this.actionmobpsdeviewidDirtyFlag = true;
    }

    public String getActionMobPSDEViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionMobPSDEViewId();
        }
        return this.actionmobpsdeviewid;
    }

    public boolean isActionMobPSDEViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionMobPSDEViewIdDirty();
        }
        return this.actionmobpsdeviewidDirtyFlag;
    }

    public void resetActionMobPSDEViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionMobPSDEViewId();
            return;
        }
        this.actionmobpsdeviewidDirtyFlag = false;
        this.actionmobpsdeviewid = null;
    }

    public void setActionMobPSDEViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionMobPSDEViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actionmobpsdeviewname = string;
        this.actionmobpsdeviewnameDirtyFlag = true;
    }

    public String getActionMobPSDEViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionMobPSDEViewName();
        }
        return this.actionmobpsdeviewname;
    }

    public boolean isActionMobPSDEViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionMobPSDEViewNameDirty();
        }
        return this.actionmobpsdeviewnameDirtyFlag;
    }

    public void resetActionMobPSDEViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionMobPSDEViewName();
            return;
        }
        this.actionmobpsdeviewnameDirtyFlag = false;
        this.actionmobpsdeviewname = null;
    }

    public void setActionPSDEViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionPSDEViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actionpsdeviewid = string;
        this.actionpsdeviewidDirtyFlag = true;
    }

    public String getActionPSDEViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionPSDEViewId();
        }
        return this.actionpsdeviewid;
    }

    public boolean isActionPSDEViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionPSDEViewIdDirty();
        }
        return this.actionpsdeviewidDirtyFlag;
    }

    public void resetActionPSDEViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionPSDEViewId();
            return;
        }
        this.actionpsdeviewidDirtyFlag = false;
        this.actionpsdeviewid = null;
    }

    public void setActionPSDEViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionPSDEViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actionpsdeviewname = string;
        this.actionpsdeviewnameDirtyFlag = true;
    }

    public String getActionPSDEViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionPSDEViewName();
        }
        return this.actionpsdeviewname;
    }

    public boolean isActionPSDEViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionPSDEViewNameDirty();
        }
        return this.actionpsdeviewnameDirtyFlag;
    }

    public void resetActionPSDEViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionPSDEViewName();
            return;
        }
        this.actionpsdeviewnameDirtyFlag = false;
        this.actionpsdeviewname = null;
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

    public void setEditableWFStep(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEditableWFStep(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.editablewfstep = string;
        this.editablewfstepDirtyFlag = true;
    }

    public String getEditableWFStep() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEditableWFStep();
        }
        return this.editablewfstep;
    }

    public boolean isEditableWFStepDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEditableWFStepDirty();
        }
        return this.editablewfstepDirtyFlag;
    }

    public void resetEditableWFStep() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEditableWFStep();
            return;
        }
        this.editablewfstepDirtyFlag = false;
        this.editablewfstep = null;
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

    public void setEnableDynaSys(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableDynaSys(n);
            return;
        }
        this.enabledynasys = n;
        this.enabledynasysDirtyFlag = true;
    }

    public Integer getEnableDynaSys() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableDynaSys();
        }
        return this.enabledynasys;
    }

    public boolean isEnableDynaSysDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableDynaSysDirty();
        }
        return this.enabledynasysDirtyFlag;
    }

    public void resetEnableDynaSys() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableDynaSys();
            return;
        }
        this.enabledynasysDirtyFlag = false;
        this.enabledynasys = null;
    }

    public void setEnableDynaView(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableDynaView(n);
            return;
        }
        this.enabledynaview = n;
        this.enabledynaviewDirtyFlag = true;
    }

    public Integer getEnableDynaView() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableDynaView();
        }
        return this.enabledynaview;
    }

    public boolean isEnableDynaViewDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableDynaViewDirty();
        }
        return this.enabledynaviewDirtyFlag;
    }

    public void resetEnableDynaView() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableDynaView();
            return;
        }
        this.enabledynaviewDirtyFlag = false;
        this.enabledynaview = null;
    }

    public void setEnableMob(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableMob(n);
            return;
        }
        this.enablemob = n;
        this.enablemobDirtyFlag = true;
    }

    public Integer getEnableMob() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableMob();
        }
        return this.enablemob;
    }

    public boolean isEnableMobDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableMobDirty();
        }
        return this.enablemobDirtyFlag;
    }

    public void resetEnableMob() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableMob();
            return;
        }
        this.enablemobDirtyFlag = false;
        this.enablemob = null;
    }

    public void setExtCntStates(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExtCntStates(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.extcntstates = string;
        this.extcntstatesDirtyFlag = true;
    }

    public String getExtCntStates() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExtCntStates();
        }
        return this.extcntstates;
    }

    public boolean isExtCntStatesDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExtCntStatesDirty();
        }
        return this.extcntstatesDirtyFlag;
    }

    public void resetExtCntStates() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExtCntStates();
            return;
        }
        this.extcntstatesDirtyFlag = false;
        this.extcntstates = null;
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

    public void setModColor(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModColor(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.modcolor = string;
        this.modcolorDirtyFlag = true;
    }

    public String getModColor() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModColor();
        }
        return this.modcolor;
    }

    public boolean isModColorDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModColorDirty();
        }
        return this.modcolorDirtyFlag;
    }

    public void resetModColor() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModColor();
            return;
        }
        this.modcolorDirtyFlag = false;
        this.modcolor = null;
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

    public void setPSSysWFCatId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysWFCatId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyswfcatid = string;
        this.pssyswfcatidDirtyFlag = true;
    }

    public String getPSSysWFCatId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysWFCatId();
        }
        return this.pssyswfcatid;
    }

    public boolean isPSSysWFCatIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysWFCatIdDirty();
        }
        return this.pssyswfcatidDirtyFlag;
    }

    public void resetPSSysWFCatId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysWFCatId();
            return;
        }
        this.pssyswfcatidDirtyFlag = false;
        this.pssyswfcatid = null;
    }

    public void setPSSysWFCatName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysWFCatName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyswfcatname = string;
        this.pssyswfcatnameDirtyFlag = true;
    }

    public String getPSSysWFCatName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysWFCatName();
        }
        return this.pssyswfcatname;
    }

    public boolean isPSSysWFCatNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysWFCatNameDirty();
        }
        return this.pssyswfcatnameDirtyFlag;
    }

    public void resetPSSysWFCatName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysWFCatName();
            return;
        }
        this.pssyswfcatnameDirtyFlag = false;
        this.pssyswfcatname = null;
    }

    public void setPSWFDEsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFDEsCnt(n);
            return;
        }
        this.pswfdescnt = n;
        this.pswfdescntDirtyFlag = true;
    }

    public Integer getPSWFDEsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFDEsCnt();
        }
        return this.pswfdescnt;
    }

    public boolean isPSWFDEsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFDEsCntDirty();
        }
        return this.pswfdescntDirtyFlag;
    }

    public void resetPSWFDEsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFDEsCnt();
            return;
        }
        this.pswfdescntDirtyFlag = false;
        this.pswfdescnt = null;
    }

    public void setPSWFVersionsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFVersionsCnt(n);
            return;
        }
        this.pswfversionscnt = n;
        this.pswfversionscntDirtyFlag = true;
    }

    public Integer getPSWFVersionsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFVersionsCnt();
        }
        return this.pswfversionscnt;
    }

    public boolean isPSWFVersionsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFVersionsCntDirty();
        }
        return this.pswfversionscntDirtyFlag;
    }

    public void resetPSWFVersionsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFVersionsCnt();
            return;
        }
        this.pswfversionscntDirtyFlag = false;
        this.pswfversionscnt = null;
    }

    public void setPSWorkflowId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWorkflowId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psworkflowid = string;
        this.psworkflowidDirtyFlag = true;
    }

    public String getPSWorkflowId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWorkflowId();
        }
        return this.psworkflowid;
    }

    public boolean isPSWorkflowIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWorkflowIdDirty();
        }
        return this.psworkflowidDirtyFlag;
    }

    public void resetPSWorkflowId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWorkflowId();
            return;
        }
        this.psworkflowidDirtyFlag = false;
        this.psworkflowid = null;
    }

    public void setPSWorkflowName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWorkflowName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psworkflowname = string;
        this.psworkflownameDirtyFlag = true;
    }

    public String getPSWorkflowName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWorkflowName();
        }
        return this.psworkflowname;
    }

    public boolean isPSWorkflowNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWorkflowNameDirty();
        }
        return this.psworkflownameDirtyFlag;
    }

    public void resetPSWorkflowName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWorkflowName();
            return;
        }
        this.psworkflownameDirtyFlag = false;
        this.psworkflowname = null;
    }

    public void setPSWXAccountId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWXAccountId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswxaccountid = string;
        this.pswxaccountidDirtyFlag = true;
    }

    public String getPSWXAccountId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWXAccountId();
        }
        return this.pswxaccountid;
    }

    public boolean isPSWXAccountIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWXAccountIdDirty();
        }
        return this.pswxaccountidDirtyFlag;
    }

    public void resetPSWXAccountId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWXAccountId();
            return;
        }
        this.pswxaccountidDirtyFlag = false;
        this.pswxaccountid = null;
    }

    public void setPSWXAccountName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWXAccountName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswxaccountname = string;
        this.pswxaccountnameDirtyFlag = true;
    }

    public String getPSWXAccountName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWXAccountName();
        }
        return this.pswxaccountname;
    }

    public boolean isPSWXAccountNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWXAccountNameDirty();
        }
        return this.pswxaccountnameDirtyFlag;
    }

    public void resetPSWXAccountName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWXAccountName();
            return;
        }
        this.pswxaccountnameDirtyFlag = false;
        this.pswxaccountname = null;
    }

    public void setPSWXEntAppId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWXEntAppId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswxentappid = string;
        this.pswxentappidDirtyFlag = true;
    }

    public String getPSWXEntAppId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWXEntAppId();
        }
        return this.pswxentappid;
    }

    public boolean isPSWXEntAppIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWXEntAppIdDirty();
        }
        return this.pswxentappidDirtyFlag;
    }

    public void resetPSWXEntAppId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWXEntAppId();
            return;
        }
        this.pswxentappidDirtyFlag = false;
        this.pswxentappid = null;
    }

    public void setPSWXEntAppName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWXEntAppName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswxentappname = string;
        this.pswxentappnameDirtyFlag = true;
    }

    public String getPSWXEntAppName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWXEntAppName();
        }
        return this.pswxentappname;
    }

    public boolean isPSWXEntAppNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWXEntAppNameDirty();
        }
        return this.pswxentappnameDirtyFlag;
    }

    public void resetPSWXEntAppName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWXEntAppName();
            return;
        }
        this.pswxentappnameDirtyFlag = false;
        this.pswxentappname = null;
    }

    public void setRemindPSSysMsgTemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRemindPSSysMsgTemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.remindpssysmsgtemplid = string;
        this.remindpssysmsgtemplidDirtyFlag = true;
    }

    public String getRemindPSSysMsgTemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRemindPSSysMsgTemplId();
        }
        return this.remindpssysmsgtemplid;
    }

    public boolean isRemindPSSysMsgTemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRemindPSSysMsgTemplIdDirty();
        }
        return this.remindpssysmsgtemplidDirtyFlag;
    }

    public void resetRemindPSSysMsgTemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRemindPSSysMsgTemplId();
            return;
        }
        this.remindpssysmsgtemplidDirtyFlag = false;
        this.remindpssysmsgtemplid = null;
    }

    public void setRemindPSSysMsgTemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRemindPSSysMsgTemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.remindpssysmsgtemplname = string;
        this.remindpssysmsgtemplnameDirtyFlag = true;
    }

    public String getRemindPSSysMsgTemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRemindPSSysMsgTemplName();
        }
        return this.remindpssysmsgtemplname;
    }

    public boolean isRemindPSSysMsgTemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRemindPSSysMsgTemplNameDirty();
        }
        return this.remindpssysmsgtemplnameDirtyFlag;
    }

    public void resetRemindPSSysMsgTemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRemindPSSysMsgTemplName();
            return;
        }
        this.remindpssysmsgtemplnameDirtyFlag = false;
        this.remindpssysmsgtemplname = null;
    }

    public void setRemoteEngineFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRemoteEngineFlag(n);
            return;
        }
        this.remoteengineflag = n;
        this.remoteengineflagDirtyFlag = true;
    }

    public Integer getRemoteEngineFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRemoteEngineFlag();
        }
        return this.remoteengineflag;
    }

    public boolean isRemoteEngineFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRemoteEngineFlagDirty();
        }
        return this.remoteengineflagDirtyFlag;
    }

    public void resetRemoteEngineFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRemoteEngineFlag();
            return;
        }
        this.remoteengineflagDirtyFlag = false;
        this.remoteengineflag = null;
    }

    public void setStartMobPSDEViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStartMobPSDEViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.startmobpsdeviewid = string;
        this.startmobpsdeviewidDirtyFlag = true;
    }

    public String getStartMobPSDEViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStartMobPSDEViewId();
        }
        return this.startmobpsdeviewid;
    }

    public boolean isStartMobPSDEViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStartMobPSDEViewIdDirty();
        }
        return this.startmobpsdeviewidDirtyFlag;
    }

    public void resetStartMobPSDEViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStartMobPSDEViewId();
            return;
        }
        this.startmobpsdeviewidDirtyFlag = false;
        this.startmobpsdeviewid = null;
    }

    public void setStartMobPSDEViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStartMobPSDEViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.startmobpsdeviewname = string;
        this.startmobpsdeviewnameDirtyFlag = true;
    }

    public String getStartMobPSDEViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStartMobPSDEViewName();
        }
        return this.startmobpsdeviewname;
    }

    public boolean isStartMobPSDEViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStartMobPSDEViewNameDirty();
        }
        return this.startmobpsdeviewnameDirtyFlag;
    }

    public void resetStartMobPSDEViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStartMobPSDEViewName();
            return;
        }
        this.startmobpsdeviewnameDirtyFlag = false;
        this.startmobpsdeviewname = null;
    }

    public void setStartPSDEViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStartPSDEViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.startpsdeviewid = string;
        this.startpsdeviewidDirtyFlag = true;
    }

    public String getStartPSDEViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStartPSDEViewId();
        }
        return this.startpsdeviewid;
    }

    public boolean isStartPSDEViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStartPSDEViewIdDirty();
        }
        return this.startpsdeviewidDirtyFlag;
    }

    public void resetStartPSDEViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStartPSDEViewId();
            return;
        }
        this.startpsdeviewidDirtyFlag = false;
        this.startpsdeviewid = null;
    }

    public void setStartPSDEViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStartPSDEViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.startpsdeviewname = string;
        this.startpsdeviewnameDirtyFlag = true;
    }

    public String getStartPSDEViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStartPSDEViewName();
        }
        return this.startpsdeviewname;
    }

    public boolean isStartPSDEViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStartPSDEViewNameDirty();
        }
        return this.startpsdeviewnameDirtyFlag;
    }

    public void resetStartPSDEViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStartPSDEViewName();
            return;
        }
        this.startpsdeviewnameDirtyFlag = false;
        this.startpsdeviewname = null;
    }

    public void setStateCodeListId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStateCodeListId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.statecodelistid = string;
        this.statecodelistidDirtyFlag = true;
    }

    public String getStateCodeListId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStateCodeListId();
        }
        return this.statecodelistid;
    }

    public boolean isStateCodeListIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStateCodeListIdDirty();
        }
        return this.statecodelistidDirtyFlag;
    }

    public void resetStateCodeListId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStateCodeListId();
            return;
        }
        this.statecodelistidDirtyFlag = false;
        this.statecodelistid = null;
    }

    public void setStateCodeListName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStateCodeListName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.statecodelistname = string;
        this.statecodelistnameDirtyFlag = true;
    }

    public String getStateCodeListName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStateCodeListName();
        }
        return this.statecodelistname;
    }

    public boolean isStateCodeListNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStateCodeListNameDirty();
        }
        return this.statecodelistnameDirtyFlag;
    }

    public void resetStateCodeListName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStateCodeListName();
            return;
        }
        this.statecodelistnameDirtyFlag = false;
        this.statecodelistname = null;
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

    public void setValidFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValidFlag(n);
            return;
        }
        this.validflag = n;
        this.validflagDirtyFlag = true;
    }

    public Integer getValidFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValidFlag();
        }
        return this.validflag;
    }

    public boolean isValidFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValidFlagDirty();
        }
        return this.validflagDirtyFlag;
    }

    public void resetValidFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValidFlag();
            return;
        }
        this.validflagDirtyFlag = false;
        this.validflag = null;
    }

    public void setWFCancelValue(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFCancelValue(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wfcancelvalue = string;
        this.wfcancelvalueDirtyFlag = true;
    }

    public String getWFCancelValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFCancelValue();
        }
        return this.wfcancelvalue;
    }

    public boolean isWFCancelValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFCancelValueDirty();
        }
        return this.wfcancelvalueDirtyFlag;
    }

    public void resetWFCancelValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFCancelValue();
            return;
        }
        this.wfcancelvalueDirtyFlag = false;
        this.wfcancelvalue = null;
    }

    public void setWFCancelValueText(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFCancelValueText(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wfcancelvaluetext = string;
        this.wfcancelvaluetextDirtyFlag = true;
    }

    public String getWFCancelValueText() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFCancelValueText();
        }
        return this.wfcancelvaluetext;
    }

    public boolean isWFCancelValueTextDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFCancelValueTextDirty();
        }
        return this.wfcancelvaluetextDirtyFlag;
    }

    public void resetWFCancelValueText() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFCancelValueText();
            return;
        }
        this.wfcancelvaluetextDirtyFlag = false;
        this.wfcancelvaluetext = null;
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

    public void setWFErrorValue(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFErrorValue(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wferrorvalue = string;
        this.wferrorvalueDirtyFlag = true;
    }

    public String getWFErrorValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFErrorValue();
        }
        return this.wferrorvalue;
    }

    public boolean isWFErrorValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFErrorValueDirty();
        }
        return this.wferrorvalueDirtyFlag;
    }

    public void resetWFErrorValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFErrorValue();
            return;
        }
        this.wferrorvalueDirtyFlag = false;
        this.wferrorvalue = null;
    }

    public void setWFErrorValueText(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFErrorValueText(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wferrorvaluetext = string;
        this.wferrorvaluetextDirtyFlag = true;
    }

    public String getWFErrorValueText() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFErrorValueText();
        }
        return this.wferrorvaluetext;
    }

    public boolean isWFErrorValueTextDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFErrorValueTextDirty();
        }
        return this.wferrorvaluetextDirtyFlag;
    }

    public void resetWFErrorValueText() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFErrorValueText();
            return;
        }
        this.wferrorvaluetextDirtyFlag = false;
        this.wferrorvaluetext = null;
    }

    public void setWFFinishValue(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFFinishValue(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wffinishvalue = string;
        this.wffinishvalueDirtyFlag = true;
    }

    public String getWFFinishValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFFinishValue();
        }
        return this.wffinishvalue;
    }

    public boolean isWFFinishValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFFinishValueDirty();
        }
        return this.wffinishvalueDirtyFlag;
    }

    public void resetWFFinishValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFFinishValue();
            return;
        }
        this.wffinishvalueDirtyFlag = false;
        this.wffinishvalue = null;
    }

    public void setWFFinishValueText(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFFinishValueText(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wffinishvaluetext = string;
        this.wffinishvaluetextDirtyFlag = true;
    }

    public String getWFFinishValueText() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFFinishValueText();
        }
        return this.wffinishvaluetext;
    }

    public boolean isWFFinishValueTextDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFFinishValueTextDirty();
        }
        return this.wffinishvaluetextDirtyFlag;
    }

    public void resetWFFinishValueText() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFFinishValueText();
            return;
        }
        this.wffinishvaluetextDirtyFlag = false;
        this.wffinishvaluetext = null;
    }

    public void setWFProxyMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFProxyMode(n);
            return;
        }
        this.wfproxymode = n;
        this.wfproxymodeDirtyFlag = true;
    }

    public Integer getWFProxyMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFProxyMode();
        }
        return this.wfproxymode;
    }

    public boolean isWFProxyModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFProxyModeDirty();
        }
        return this.wfproxymodeDirtyFlag;
    }

    public void resetWFProxyMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFProxyMode();
            return;
        }
        this.wfproxymodeDirtyFlag = false;
        this.wfproxymode = null;
    }

    public void setWFSN(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFSN(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wfsn = string;
        this.wfsnDirtyFlag = true;
    }

    public String getWFSN() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFSN();
        }
        return this.wfsn;
    }

    public boolean isWFSNDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFSNDirty();
        }
        return this.wfsnDirtyFlag;
    }

    public void resetWFSN() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFSN();
            return;
        }
        this.wfsnDirtyFlag = false;
        this.wfsn = null;
    }

    public void setWFStateValue(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFStateValue(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wfstatevalue = string;
        this.wfstatevalueDirtyFlag = true;
    }

    public String getWFStateValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFStateValue();
        }
        return this.wfstatevalue;
    }

    public boolean isWFStateValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFStateValueDirty();
        }
        return this.wfstatevalueDirtyFlag;
    }

    public void resetWFStateValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFStateValue();
            return;
        }
        this.wfstatevalueDirtyFlag = false;
        this.wfstatevalue = null;
    }

    public void setWFStepCodeListId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFStepCodeListId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wfstepcodelistid = string;
        this.wfstepcodelistidDirtyFlag = true;
    }

    public String getWFStepCodeListId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFStepCodeListId();
        }
        return this.wfstepcodelistid;
    }

    public boolean isWFStepCodeListIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFStepCodeListIdDirty();
        }
        return this.wfstepcodelistidDirtyFlag;
    }

    public void resetWFStepCodeListId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFStepCodeListId();
            return;
        }
        this.wfstepcodelistidDirtyFlag = false;
        this.wfstepcodelistid = null;
    }

    public void setWFStepCodeListName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFStepCodeListName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wfstepcodelistname = string;
        this.wfstepcodelistnameDirtyFlag = true;
    }

    public String getWFStepCodeListName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFStepCodeListName();
        }
        return this.wfstepcodelistname;
    }

    public boolean isWFStepCodeListNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFStepCodeListNameDirty();
        }
        return this.wfstepcodelistnameDirtyFlag;
    }

    public void resetWFStepCodeListName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFStepCodeListName();
            return;
        }
        this.wfstepcodelistnameDirtyFlag = false;
        this.wfstepcodelistname = null;
    }

    public void setWFTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wftag = string;
        this.wftagDirtyFlag = true;
    }

    public String getWFTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFTag();
        }
        return this.wftag;
    }

    public boolean isWFTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFTagDirty();
        }
        return this.wftagDirtyFlag;
    }

    public void resetWFTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFTag();
            return;
        }
        this.wftagDirtyFlag = false;
        this.wftag = null;
    }

    public void setWFTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wftag2 = string;
        this.wftag2DirtyFlag = true;
    }

    public String getWFTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFTag2();
        }
        return this.wftag2;
    }

    public boolean isWFTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFTag2Dirty();
        }
        return this.wftag2DirtyFlag;
    }

    public void resetWFTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFTag2();
            return;
        }
        this.wftag2DirtyFlag = false;
        this.wftag2 = null;
    }

    public void setWFTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wftag3 = string;
        this.wftag3DirtyFlag = true;
    }

    public String getWFTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFTag3();
        }
        return this.wftag3;
    }

    public boolean isWFTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFTag3Dirty();
        }
        return this.wftag3DirtyFlag;
    }

    public void resetWFTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFTag3();
            return;
        }
        this.wftag3DirtyFlag = false;
        this.wftag3 = null;
    }

    public void setWFTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wftag4 = string;
        this.wftag4DirtyFlag = true;
    }

    public String getWFTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFTag4();
        }
        return this.wftag4;
    }

    public boolean isWFTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFTag4Dirty();
        }
        return this.wftag4DirtyFlag;
    }

    public void resetWFTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFTag4();
            return;
        }
        this.wftag4DirtyFlag = false;
        this.wftag4 = null;
    }

    public void setWFType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wftype = string;
        this.wftypeDirtyFlag = true;
    }

    public String getWFType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFType();
        }
        return this.wftype;
    }

    public boolean isWFTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFTypeDirty();
        }
        return this.wftypeDirtyFlag;
    }

    public void resetWFType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFType();
            return;
        }
        this.wftypeDirtyFlag = false;
        this.wftype = null;
    }

    protected void onReset() {
        PSWorkflowBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSWorkflowBase pSWorkflowBase) {
        pSWorkflowBase.resetActionMobPSDEViewId();
        pSWorkflowBase.resetActionMobPSDEViewName();
        pSWorkflowBase.resetActionPSDEViewId();
        pSWorkflowBase.resetActionPSDEViewName();
        pSWorkflowBase.resetCodeName();
        pSWorkflowBase.resetCreateDate();
        pSWorkflowBase.resetCreateMan();
        pSWorkflowBase.resetDynaModelFlag();
        pSWorkflowBase.resetEditableWFStep();
        pSWorkflowBase.resetEnable();
        pSWorkflowBase.resetEnableDynaSys();
        pSWorkflowBase.resetEnableDynaView();
        pSWorkflowBase.resetEnableMob();
        pSWorkflowBase.resetExtCntStates();
        pSWorkflowBase.resetLockFlag();
        pSWorkflowBase.resetMemo();
        pSWorkflowBase.resetMobWFEditViewType();
        pSWorkflowBase.resetModColor();
        pSWorkflowBase.resetNamePSLanResId();
        pSWorkflowBase.resetNamePSLanResName();
        pSWorkflowBase.resetPSDynaInstId();
        pSWorkflowBase.resetPSModuleId();
        pSWorkflowBase.resetPSModuleName();
        pSWorkflowBase.resetPSSysReqItemId();
        pSWorkflowBase.resetPSSysReqItemName();
        pSWorkflowBase.resetPSSystemId();
        pSWorkflowBase.resetPSSystemName();
        pSWorkflowBase.resetPSSysWFCatId();
        pSWorkflowBase.resetPSSysWFCatName();
        pSWorkflowBase.resetPSWFDEsCnt();
        pSWorkflowBase.resetPSWFVersionsCnt();
        pSWorkflowBase.resetPSWorkflowId();
        pSWorkflowBase.resetPSWorkflowName();
        pSWorkflowBase.resetPSWXAccountId();
        pSWorkflowBase.resetPSWXAccountName();
        pSWorkflowBase.resetPSWXEntAppId();
        pSWorkflowBase.resetPSWXEntAppName();
        pSWorkflowBase.resetRemindPSSysMsgTemplId();
        pSWorkflowBase.resetRemindPSSysMsgTemplName();
        pSWorkflowBase.resetRemoteEngineFlag();
        pSWorkflowBase.resetStartMobPSDEViewId();
        pSWorkflowBase.resetStartMobPSDEViewName();
        pSWorkflowBase.resetStartPSDEViewId();
        pSWorkflowBase.resetStartPSDEViewName();
        pSWorkflowBase.resetStateCodeListId();
        pSWorkflowBase.resetStateCodeListName();
        pSWorkflowBase.resetToDoTask();
        pSWorkflowBase.resetUpdateDate();
        pSWorkflowBase.resetUpdateMan();
        pSWorkflowBase.resetUserCat();
        pSWorkflowBase.resetUserTag();
        pSWorkflowBase.resetUserTag2();
        pSWorkflowBase.resetUserTag3();
        pSWorkflowBase.resetUserTag4();
        pSWorkflowBase.resetValidFlag();
        pSWorkflowBase.resetWFCancelValue();
        pSWorkflowBase.resetWFCancelValueText();
        pSWorkflowBase.resetWFEditViewType();
        pSWorkflowBase.resetWFEngineType();
        pSWorkflowBase.resetWFErrorValue();
        pSWorkflowBase.resetWFErrorValueText();
        pSWorkflowBase.resetWFFinishValue();
        pSWorkflowBase.resetWFFinishValueText();
        pSWorkflowBase.resetWFProxyMode();
        pSWorkflowBase.resetWFSN();
        pSWorkflowBase.resetWFStateValue();
        pSWorkflowBase.resetWFStepCodeListId();
        pSWorkflowBase.resetWFStepCodeListName();
        pSWorkflowBase.resetWFTag();
        pSWorkflowBase.resetWFTag2();
        pSWorkflowBase.resetWFTag3();
        pSWorkflowBase.resetWFTag4();
        pSWorkflowBase.resetWFType();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isActionMobPSDEViewIdDirty()) {
            hashMap.put(FIELD_ACTIONMOBPSDEVIEWID, this.getActionMobPSDEViewId());
        }
        if (!bl || this.isActionMobPSDEViewNameDirty()) {
            hashMap.put(FIELD_ACTIONMOBPSDEVIEWNAME, this.getActionMobPSDEViewName());
        }
        if (!bl || this.isActionPSDEViewIdDirty()) {
            hashMap.put(FIELD_ACTIONPSDEVIEWID, this.getActionPSDEViewId());
        }
        if (!bl || this.isActionPSDEViewNameDirty()) {
            hashMap.put(FIELD_ACTIONPSDEVIEWNAME, this.getActionPSDEViewName());
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
        if (!bl || this.isEditableWFStepDirty()) {
            hashMap.put(FIELD_EDITABLEWFSTEP, this.getEditableWFStep());
        }
        if (!bl || this.isEnableDirty()) {
            hashMap.put(FIELD_ENABLE, this.getEnable());
        }
        if (!bl || this.isEnableDynaSysDirty()) {
            hashMap.put(FIELD_ENABLEDYNASYS, this.getEnableDynaSys());
        }
        if (!bl || this.isEnableDynaViewDirty()) {
            hashMap.put(FIELD_ENABLEDYNAVIEW, this.getEnableDynaView());
        }
        if (!bl || this.isEnableMobDirty()) {
            hashMap.put(FIELD_ENABLEMOB, this.getEnableMob());
        }
        if (!bl || this.isExtCntStatesDirty()) {
            hashMap.put(FIELD_EXTCNTSTATES, this.getExtCntStates());
        }
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMobWFEditViewTypeDirty()) {
            hashMap.put(FIELD_MOBWFEDITVIEWTYPE, this.getMobWFEditViewType());
        }
        if (!bl || this.isModColorDirty()) {
            hashMap.put(FIELD_MODCOLOR, this.getModColor());
        }
        if (!bl || this.isNamePSLanResIdDirty()) {
            hashMap.put(FIELD_NAMEPSLANRESID, this.getNamePSLanResId());
        }
        if (!bl || this.isNamePSLanResNameDirty()) {
            hashMap.put(FIELD_NAMEPSLANRESNAME, this.getNamePSLanResName());
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
        if (!bl || this.isPSSysWFCatIdDirty()) {
            hashMap.put(FIELD_PSSYSWFCATID, this.getPSSysWFCatId());
        }
        if (!bl || this.isPSSysWFCatNameDirty()) {
            hashMap.put(FIELD_PSSYSWFCATNAME, this.getPSSysWFCatName());
        }
        if (!bl || this.isPSWFDEsCntDirty()) {
            hashMap.put(FIELD_PSWFDESCNT, this.getPSWFDEsCnt());
        }
        if (!bl || this.isPSWFVersionsCntDirty()) {
            hashMap.put(FIELD_PSWFVERSIONSCNT, this.getPSWFVersionsCnt());
        }
        if (!bl || this.isPSWorkflowIdDirty()) {
            hashMap.put(FIELD_PSWORKFLOWID, this.getPSWorkflowId());
        }
        if (!bl || this.isPSWorkflowNameDirty()) {
            hashMap.put(FIELD_PSWORKFLOWNAME, this.getPSWorkflowName());
        }
        if (!bl || this.isPSWXAccountIdDirty()) {
            hashMap.put(FIELD_PSWXACCOUNTID, this.getPSWXAccountId());
        }
        if (!bl || this.isPSWXAccountNameDirty()) {
            hashMap.put(FIELD_PSWXACCOUNTNAME, this.getPSWXAccountName());
        }
        if (!bl || this.isPSWXEntAppIdDirty()) {
            hashMap.put(FIELD_PSWXENTAPPID, this.getPSWXEntAppId());
        }
        if (!bl || this.isPSWXEntAppNameDirty()) {
            hashMap.put(FIELD_PSWXENTAPPNAME, this.getPSWXEntAppName());
        }
        if (!bl || this.isRemindPSSysMsgTemplIdDirty()) {
            hashMap.put(FIELD_REMINDPSSYSMSGTEMPLID, this.getRemindPSSysMsgTemplId());
        }
        if (!bl || this.isRemindPSSysMsgTemplNameDirty()) {
            hashMap.put(FIELD_REMINDPSSYSMSGTEMPLNAME, this.getRemindPSSysMsgTemplName());
        }
        if (!bl || this.isRemoteEngineFlagDirty()) {
            hashMap.put(FIELD_REMOTEENGINEFLAG, this.getRemoteEngineFlag());
        }
        if (!bl || this.isStartMobPSDEViewIdDirty()) {
            hashMap.put(FIELD_STARTMOBPSDEVIEWID, this.getStartMobPSDEViewId());
        }
        if (!bl || this.isStartMobPSDEViewNameDirty()) {
            hashMap.put(FIELD_STARTMOBPSDEVIEWNAME, this.getStartMobPSDEViewName());
        }
        if (!bl || this.isStartPSDEViewIdDirty()) {
            hashMap.put(FIELD_STARTPSDEVIEWID, this.getStartPSDEViewId());
        }
        if (!bl || this.isStartPSDEViewNameDirty()) {
            hashMap.put(FIELD_STARTPSDEVIEWNAME, this.getStartPSDEViewName());
        }
        if (!bl || this.isStateCodeListIdDirty()) {
            hashMap.put(FIELD_STATECODELISTID, this.getStateCodeListId());
        }
        if (!bl || this.isStateCodeListNameDirty()) {
            hashMap.put(FIELD_STATECODELISTNAME, this.getStateCodeListName());
        }
        if (!bl || this.isToDoTaskDirty()) {
            hashMap.put(FIELD_TODOTASK, this.getToDoTask());
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
        if (!bl || this.isValidFlagDirty()) {
            hashMap.put(FIELD_VALIDFLAG, this.getValidFlag());
        }
        if (!bl || this.isWFCancelValueDirty()) {
            hashMap.put(FIELD_WFCANCELVALUE, this.getWFCancelValue());
        }
        if (!bl || this.isWFCancelValueTextDirty()) {
            hashMap.put(FIELD_WFCANCELVALUETEXT, this.getWFCancelValueText());
        }
        if (!bl || this.isWFEditViewTypeDirty()) {
            hashMap.put(FIELD_WFEDITVIEWTYPE, this.getWFEditViewType());
        }
        if (!bl || this.isWFEngineTypeDirty()) {
            hashMap.put(FIELD_WFENGINETYPE, this.getWFEngineType());
        }
        if (!bl || this.isWFErrorValueDirty()) {
            hashMap.put(FIELD_WFERRORVALUE, this.getWFErrorValue());
        }
        if (!bl || this.isWFErrorValueTextDirty()) {
            hashMap.put(FIELD_WFERRORVALUETEXT, this.getWFErrorValueText());
        }
        if (!bl || this.isWFFinishValueDirty()) {
            hashMap.put(FIELD_WFFINISHVALUE, this.getWFFinishValue());
        }
        if (!bl || this.isWFFinishValueTextDirty()) {
            hashMap.put(FIELD_WFFINISHVALUETEXT, this.getWFFinishValueText());
        }
        if (!bl || this.isWFProxyModeDirty()) {
            hashMap.put(FIELD_WFPROXYMODE, this.getWFProxyMode());
        }
        if (!bl || this.isWFSNDirty()) {
            hashMap.put(FIELD_WFSN, this.getWFSN());
        }
        if (!bl || this.isWFStateValueDirty()) {
            hashMap.put(FIELD_WFSTATEVALUE, this.getWFStateValue());
        }
        if (!bl || this.isWFStepCodeListIdDirty()) {
            hashMap.put(FIELD_WFSTEPCODELISTID, this.getWFStepCodeListId());
        }
        if (!bl || this.isWFStepCodeListNameDirty()) {
            hashMap.put(FIELD_WFSTEPCODELISTNAME, this.getWFStepCodeListName());
        }
        if (!bl || this.isWFTagDirty()) {
            hashMap.put(FIELD_WFTAG, this.getWFTag());
        }
        if (!bl || this.isWFTag2Dirty()) {
            hashMap.put(FIELD_WFTAG2, this.getWFTag2());
        }
        if (!bl || this.isWFTag3Dirty()) {
            hashMap.put(FIELD_WFTAG3, this.getWFTag3());
        }
        if (!bl || this.isWFTag4Dirty()) {
            hashMap.put(FIELD_WFTAG4, this.getWFTag4());
        }
        if (!bl || this.isWFTypeDirty()) {
            hashMap.put(FIELD_WFTYPE, this.getWFType());
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
        return PSWorkflowBase.get(this, n);
    }

    private static Object get(PSWorkflowBase pSWorkflowBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWorkflowBase.getActionMobPSDEViewId();
            }
            case 1: {
                return pSWorkflowBase.getActionMobPSDEViewName();
            }
            case 2: {
                return pSWorkflowBase.getActionPSDEViewId();
            }
            case 3: {
                return pSWorkflowBase.getActionPSDEViewName();
            }
            case 4: {
                return pSWorkflowBase.getCodeName();
            }
            case 5: {
                return pSWorkflowBase.getCreateDate();
            }
            case 6: {
                return pSWorkflowBase.getCreateMan();
            }
            case 7: {
                return pSWorkflowBase.getDynaModelFlag();
            }
            case 8: {
                return pSWorkflowBase.getEditableWFStep();
            }
            case 9: {
                return pSWorkflowBase.getEnable();
            }
            case 10: {
                return pSWorkflowBase.getEnableDynaSys();
            }
            case 11: {
                return pSWorkflowBase.getEnableDynaView();
            }
            case 12: {
                return pSWorkflowBase.getEnableMob();
            }
            case 13: {
                return pSWorkflowBase.getExtCntStates();
            }
            case 14: {
                return pSWorkflowBase.getLockFlag();
            }
            case 15: {
                return pSWorkflowBase.getMemo();
            }
            case 16: {
                return pSWorkflowBase.getMobWFEditViewType();
            }
            case 17: {
                return pSWorkflowBase.getModColor();
            }
            case 18: {
                return pSWorkflowBase.getNamePSLanResId();
            }
            case 19: {
                return pSWorkflowBase.getNamePSLanResName();
            }
            case 20: {
                return pSWorkflowBase.getPSDynaInstId();
            }
            case 21: {
                return pSWorkflowBase.getPSModuleId();
            }
            case 22: {
                return pSWorkflowBase.getPSModuleName();
            }
            case 23: {
                return pSWorkflowBase.getPSSysReqItemId();
            }
            case 24: {
                return pSWorkflowBase.getPSSysReqItemName();
            }
            case 25: {
                return pSWorkflowBase.getPSSystemId();
            }
            case 26: {
                return pSWorkflowBase.getPSSystemName();
            }
            case 27: {
                return pSWorkflowBase.getPSSysWFCatId();
            }
            case 28: {
                return pSWorkflowBase.getPSSysWFCatName();
            }
            case 29: {
                return pSWorkflowBase.getPSWFDEsCnt();
            }
            case 30: {
                return pSWorkflowBase.getPSWFVersionsCnt();
            }
            case 31: {
                return pSWorkflowBase.getPSWorkflowId();
            }
            case 32: {
                return pSWorkflowBase.getPSWorkflowName();
            }
            case 33: {
                return pSWorkflowBase.getPSWXAccountId();
            }
            case 34: {
                return pSWorkflowBase.getPSWXAccountName();
            }
            case 35: {
                return pSWorkflowBase.getPSWXEntAppId();
            }
            case 36: {
                return pSWorkflowBase.getPSWXEntAppName();
            }
            case 37: {
                return pSWorkflowBase.getRemindPSSysMsgTemplId();
            }
            case 38: {
                return pSWorkflowBase.getRemindPSSysMsgTemplName();
            }
            case 39: {
                return pSWorkflowBase.getRemoteEngineFlag();
            }
            case 40: {
                return pSWorkflowBase.getStartMobPSDEViewId();
            }
            case 41: {
                return pSWorkflowBase.getStartMobPSDEViewName();
            }
            case 42: {
                return pSWorkflowBase.getStartPSDEViewId();
            }
            case 43: {
                return pSWorkflowBase.getStartPSDEViewName();
            }
            case 44: {
                return pSWorkflowBase.getStateCodeListId();
            }
            case 45: {
                return pSWorkflowBase.getStateCodeListName();
            }
            case 46: {
                return pSWorkflowBase.getToDoTask();
            }
            case 47: {
                return pSWorkflowBase.getUpdateDate();
            }
            case 48: {
                return pSWorkflowBase.getUpdateMan();
            }
            case 49: {
                return pSWorkflowBase.getUserCat();
            }
            case 50: {
                return pSWorkflowBase.getUserTag();
            }
            case 51: {
                return pSWorkflowBase.getUserTag2();
            }
            case 52: {
                return pSWorkflowBase.getUserTag3();
            }
            case 53: {
                return pSWorkflowBase.getUserTag4();
            }
            case 54: {
                return pSWorkflowBase.getValidFlag();
            }
            case 55: {
                return pSWorkflowBase.getWFCancelValue();
            }
            case 56: {
                return pSWorkflowBase.getWFCancelValueText();
            }
            case 57: {
                return pSWorkflowBase.getWFEditViewType();
            }
            case 58: {
                return pSWorkflowBase.getWFEngineType();
            }
            case 59: {
                return pSWorkflowBase.getWFErrorValue();
            }
            case 60: {
                return pSWorkflowBase.getWFErrorValueText();
            }
            case 61: {
                return pSWorkflowBase.getWFFinishValue();
            }
            case 62: {
                return pSWorkflowBase.getWFFinishValueText();
            }
            case 63: {
                return pSWorkflowBase.getWFProxyMode();
            }
            case 64: {
                return pSWorkflowBase.getWFSN();
            }
            case 65: {
                return pSWorkflowBase.getWFStateValue();
            }
            case 66: {
                return pSWorkflowBase.getWFStepCodeListId();
            }
            case 67: {
                return pSWorkflowBase.getWFStepCodeListName();
            }
            case 68: {
                return pSWorkflowBase.getWFTag();
            }
            case 69: {
                return pSWorkflowBase.getWFTag2();
            }
            case 70: {
                return pSWorkflowBase.getWFTag3();
            }
            case 71: {
                return pSWorkflowBase.getWFTag4();
            }
            case 72: {
                return pSWorkflowBase.getWFType();
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
        PSWorkflowBase.set(this, n, object);
    }

    private static void set(PSWorkflowBase pSWorkflowBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSWorkflowBase.setActionMobPSDEViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSWorkflowBase.setActionMobPSDEViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSWorkflowBase.setActionPSDEViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSWorkflowBase.setActionPSDEViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSWorkflowBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSWorkflowBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 6: {
                pSWorkflowBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSWorkflowBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSWorkflowBase.setEditableWFStep(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSWorkflowBase.setEnable(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSWorkflowBase.setEnableDynaSys(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSWorkflowBase.setEnableDynaView(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSWorkflowBase.setEnableMob(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSWorkflowBase.setExtCntStates(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSWorkflowBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSWorkflowBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSWorkflowBase.setMobWFEditViewType(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSWorkflowBase.setModColor(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSWorkflowBase.setNamePSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSWorkflowBase.setNamePSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSWorkflowBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSWorkflowBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSWorkflowBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSWorkflowBase.setPSSysReqItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSWorkflowBase.setPSSysReqItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSWorkflowBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSWorkflowBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSWorkflowBase.setPSSysWFCatId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSWorkflowBase.setPSSysWFCatName(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSWorkflowBase.setPSWFDEsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 30: {
                pSWorkflowBase.setPSWFVersionsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 31: {
                pSWorkflowBase.setPSWorkflowId(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSWorkflowBase.setPSWorkflowName(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSWorkflowBase.setPSWXAccountId(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSWorkflowBase.setPSWXAccountName(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSWorkflowBase.setPSWXEntAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSWorkflowBase.setPSWXEntAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSWorkflowBase.setRemindPSSysMsgTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSWorkflowBase.setRemindPSSysMsgTemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSWorkflowBase.setRemoteEngineFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 40: {
                pSWorkflowBase.setStartMobPSDEViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSWorkflowBase.setStartMobPSDEViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSWorkflowBase.setStartPSDEViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSWorkflowBase.setStartPSDEViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSWorkflowBase.setStateCodeListId(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSWorkflowBase.setStateCodeListName(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSWorkflowBase.setToDoTask(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSWorkflowBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 48: {
                pSWorkflowBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSWorkflowBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSWorkflowBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSWorkflowBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSWorkflowBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 53: {
                pSWorkflowBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 54: {
                pSWorkflowBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 55: {
                pSWorkflowBase.setWFCancelValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 56: {
                pSWorkflowBase.setWFCancelValueText(DataObject.getStringValue((Object)object));
                return;
            }
            case 57: {
                pSWorkflowBase.setWFEditViewType(DataObject.getStringValue((Object)object));
                return;
            }
            case 58: {
                pSWorkflowBase.setWFEngineType(DataObject.getStringValue((Object)object));
                return;
            }
            case 59: {
                pSWorkflowBase.setWFErrorValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 60: {
                pSWorkflowBase.setWFErrorValueText(DataObject.getStringValue((Object)object));
                return;
            }
            case 61: {
                pSWorkflowBase.setWFFinishValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 62: {
                pSWorkflowBase.setWFFinishValueText(DataObject.getStringValue((Object)object));
                return;
            }
            case 63: {
                pSWorkflowBase.setWFProxyMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 64: {
                pSWorkflowBase.setWFSN(DataObject.getStringValue((Object)object));
                return;
            }
            case 65: {
                pSWorkflowBase.setWFStateValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 66: {
                pSWorkflowBase.setWFStepCodeListId(DataObject.getStringValue((Object)object));
                return;
            }
            case 67: {
                pSWorkflowBase.setWFStepCodeListName(DataObject.getStringValue((Object)object));
                return;
            }
            case 68: {
                pSWorkflowBase.setWFTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 69: {
                pSWorkflowBase.setWFTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 70: {
                pSWorkflowBase.setWFTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 71: {
                pSWorkflowBase.setWFTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 72: {
                pSWorkflowBase.setWFType(DataObject.getStringValue((Object)object));
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
        return PSWorkflowBase.isNull(this, n);
    }

    private static boolean isNull(PSWorkflowBase pSWorkflowBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWorkflowBase.getActionMobPSDEViewId() == null;
            }
            case 1: {
                return pSWorkflowBase.getActionMobPSDEViewName() == null;
            }
            case 2: {
                return pSWorkflowBase.getActionPSDEViewId() == null;
            }
            case 3: {
                return pSWorkflowBase.getActionPSDEViewName() == null;
            }
            case 4: {
                return pSWorkflowBase.getCodeName() == null;
            }
            case 5: {
                return pSWorkflowBase.getCreateDate() == null;
            }
            case 6: {
                return pSWorkflowBase.getCreateMan() == null;
            }
            case 7: {
                return pSWorkflowBase.getDynaModelFlag() == null;
            }
            case 8: {
                return pSWorkflowBase.getEditableWFStep() == null;
            }
            case 9: {
                return pSWorkflowBase.getEnable() == null;
            }
            case 10: {
                return pSWorkflowBase.getEnableDynaSys() == null;
            }
            case 11: {
                return pSWorkflowBase.getEnableDynaView() == null;
            }
            case 12: {
                return pSWorkflowBase.getEnableMob() == null;
            }
            case 13: {
                return pSWorkflowBase.getExtCntStates() == null;
            }
            case 14: {
                return pSWorkflowBase.getLockFlag() == null;
            }
            case 15: {
                return pSWorkflowBase.getMemo() == null;
            }
            case 16: {
                return pSWorkflowBase.getMobWFEditViewType() == null;
            }
            case 17: {
                return pSWorkflowBase.getModColor() == null;
            }
            case 18: {
                return pSWorkflowBase.getNamePSLanResId() == null;
            }
            case 19: {
                return pSWorkflowBase.getNamePSLanResName() == null;
            }
            case 20: {
                return pSWorkflowBase.getPSDynaInstId() == null;
            }
            case 21: {
                return pSWorkflowBase.getPSModuleId() == null;
            }
            case 22: {
                return pSWorkflowBase.getPSModuleName() == null;
            }
            case 23: {
                return pSWorkflowBase.getPSSysReqItemId() == null;
            }
            case 24: {
                return pSWorkflowBase.getPSSysReqItemName() == null;
            }
            case 25: {
                return pSWorkflowBase.getPSSystemId() == null;
            }
            case 26: {
                return pSWorkflowBase.getPSSystemName() == null;
            }
            case 27: {
                return pSWorkflowBase.getPSSysWFCatId() == null;
            }
            case 28: {
                return pSWorkflowBase.getPSSysWFCatName() == null;
            }
            case 29: {
                return pSWorkflowBase.getPSWFDEsCnt() == null;
            }
            case 30: {
                return pSWorkflowBase.getPSWFVersionsCnt() == null;
            }
            case 31: {
                return pSWorkflowBase.getPSWorkflowId() == null;
            }
            case 32: {
                return pSWorkflowBase.getPSWorkflowName() == null;
            }
            case 33: {
                return pSWorkflowBase.getPSWXAccountId() == null;
            }
            case 34: {
                return pSWorkflowBase.getPSWXAccountName() == null;
            }
            case 35: {
                return pSWorkflowBase.getPSWXEntAppId() == null;
            }
            case 36: {
                return pSWorkflowBase.getPSWXEntAppName() == null;
            }
            case 37: {
                return pSWorkflowBase.getRemindPSSysMsgTemplId() == null;
            }
            case 38: {
                return pSWorkflowBase.getRemindPSSysMsgTemplName() == null;
            }
            case 39: {
                return pSWorkflowBase.getRemoteEngineFlag() == null;
            }
            case 40: {
                return pSWorkflowBase.getStartMobPSDEViewId() == null;
            }
            case 41: {
                return pSWorkflowBase.getStartMobPSDEViewName() == null;
            }
            case 42: {
                return pSWorkflowBase.getStartPSDEViewId() == null;
            }
            case 43: {
                return pSWorkflowBase.getStartPSDEViewName() == null;
            }
            case 44: {
                return pSWorkflowBase.getStateCodeListId() == null;
            }
            case 45: {
                return pSWorkflowBase.getStateCodeListName() == null;
            }
            case 46: {
                return pSWorkflowBase.getToDoTask() == null;
            }
            case 47: {
                return pSWorkflowBase.getUpdateDate() == null;
            }
            case 48: {
                return pSWorkflowBase.getUpdateMan() == null;
            }
            case 49: {
                return pSWorkflowBase.getUserCat() == null;
            }
            case 50: {
                return pSWorkflowBase.getUserTag() == null;
            }
            case 51: {
                return pSWorkflowBase.getUserTag2() == null;
            }
            case 52: {
                return pSWorkflowBase.getUserTag3() == null;
            }
            case 53: {
                return pSWorkflowBase.getUserTag4() == null;
            }
            case 54: {
                return pSWorkflowBase.getValidFlag() == null;
            }
            case 55: {
                return pSWorkflowBase.getWFCancelValue() == null;
            }
            case 56: {
                return pSWorkflowBase.getWFCancelValueText() == null;
            }
            case 57: {
                return pSWorkflowBase.getWFEditViewType() == null;
            }
            case 58: {
                return pSWorkflowBase.getWFEngineType() == null;
            }
            case 59: {
                return pSWorkflowBase.getWFErrorValue() == null;
            }
            case 60: {
                return pSWorkflowBase.getWFErrorValueText() == null;
            }
            case 61: {
                return pSWorkflowBase.getWFFinishValue() == null;
            }
            case 62: {
                return pSWorkflowBase.getWFFinishValueText() == null;
            }
            case 63: {
                return pSWorkflowBase.getWFProxyMode() == null;
            }
            case 64: {
                return pSWorkflowBase.getWFSN() == null;
            }
            case 65: {
                return pSWorkflowBase.getWFStateValue() == null;
            }
            case 66: {
                return pSWorkflowBase.getWFStepCodeListId() == null;
            }
            case 67: {
                return pSWorkflowBase.getWFStepCodeListName() == null;
            }
            case 68: {
                return pSWorkflowBase.getWFTag() == null;
            }
            case 69: {
                return pSWorkflowBase.getWFTag2() == null;
            }
            case 70: {
                return pSWorkflowBase.getWFTag3() == null;
            }
            case 71: {
                return pSWorkflowBase.getWFTag4() == null;
            }
            case 72: {
                return pSWorkflowBase.getWFType() == null;
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
        return PSWorkflowBase.contains(this, n);
    }

    private static boolean contains(PSWorkflowBase pSWorkflowBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWorkflowBase.isActionMobPSDEViewIdDirty();
            }
            case 1: {
                return pSWorkflowBase.isActionMobPSDEViewNameDirty();
            }
            case 2: {
                return pSWorkflowBase.isActionPSDEViewIdDirty();
            }
            case 3: {
                return pSWorkflowBase.isActionPSDEViewNameDirty();
            }
            case 4: {
                return pSWorkflowBase.isCodeNameDirty();
            }
            case 5: {
                return pSWorkflowBase.isCreateDateDirty();
            }
            case 6: {
                return pSWorkflowBase.isCreateManDirty();
            }
            case 7: {
                return pSWorkflowBase.isDynaModelFlagDirty();
            }
            case 8: {
                return pSWorkflowBase.isEditableWFStepDirty();
            }
            case 9: {
                return pSWorkflowBase.isEnableDirty();
            }
            case 10: {
                return pSWorkflowBase.isEnableDynaSysDirty();
            }
            case 11: {
                return pSWorkflowBase.isEnableDynaViewDirty();
            }
            case 12: {
                return pSWorkflowBase.isEnableMobDirty();
            }
            case 13: {
                return pSWorkflowBase.isExtCntStatesDirty();
            }
            case 14: {
                return pSWorkflowBase.isLockFlagDirty();
            }
            case 15: {
                return pSWorkflowBase.isMemoDirty();
            }
            case 16: {
                return pSWorkflowBase.isMobWFEditViewTypeDirty();
            }
            case 17: {
                return pSWorkflowBase.isModColorDirty();
            }
            case 18: {
                return pSWorkflowBase.isNamePSLanResIdDirty();
            }
            case 19: {
                return pSWorkflowBase.isNamePSLanResNameDirty();
            }
            case 20: {
                return pSWorkflowBase.isPSDynaInstIdDirty();
            }
            case 21: {
                return pSWorkflowBase.isPSModuleIdDirty();
            }
            case 22: {
                return pSWorkflowBase.isPSModuleNameDirty();
            }
            case 23: {
                return pSWorkflowBase.isPSSysReqItemIdDirty();
            }
            case 24: {
                return pSWorkflowBase.isPSSysReqItemNameDirty();
            }
            case 25: {
                return pSWorkflowBase.isPSSystemIdDirty();
            }
            case 26: {
                return pSWorkflowBase.isPSSystemNameDirty();
            }
            case 27: {
                return pSWorkflowBase.isPSSysWFCatIdDirty();
            }
            case 28: {
                return pSWorkflowBase.isPSSysWFCatNameDirty();
            }
            case 29: {
                return pSWorkflowBase.isPSWFDEsCntDirty();
            }
            case 30: {
                return pSWorkflowBase.isPSWFVersionsCntDirty();
            }
            case 31: {
                return pSWorkflowBase.isPSWorkflowIdDirty();
            }
            case 32: {
                return pSWorkflowBase.isPSWorkflowNameDirty();
            }
            case 33: {
                return pSWorkflowBase.isPSWXAccountIdDirty();
            }
            case 34: {
                return pSWorkflowBase.isPSWXAccountNameDirty();
            }
            case 35: {
                return pSWorkflowBase.isPSWXEntAppIdDirty();
            }
            case 36: {
                return pSWorkflowBase.isPSWXEntAppNameDirty();
            }
            case 37: {
                return pSWorkflowBase.isRemindPSSysMsgTemplIdDirty();
            }
            case 38: {
                return pSWorkflowBase.isRemindPSSysMsgTemplNameDirty();
            }
            case 39: {
                return pSWorkflowBase.isRemoteEngineFlagDirty();
            }
            case 40: {
                return pSWorkflowBase.isStartMobPSDEViewIdDirty();
            }
            case 41: {
                return pSWorkflowBase.isStartMobPSDEViewNameDirty();
            }
            case 42: {
                return pSWorkflowBase.isStartPSDEViewIdDirty();
            }
            case 43: {
                return pSWorkflowBase.isStartPSDEViewNameDirty();
            }
            case 44: {
                return pSWorkflowBase.isStateCodeListIdDirty();
            }
            case 45: {
                return pSWorkflowBase.isStateCodeListNameDirty();
            }
            case 46: {
                return pSWorkflowBase.isToDoTaskDirty();
            }
            case 47: {
                return pSWorkflowBase.isUpdateDateDirty();
            }
            case 48: {
                return pSWorkflowBase.isUpdateManDirty();
            }
            case 49: {
                return pSWorkflowBase.isUserCatDirty();
            }
            case 50: {
                return pSWorkflowBase.isUserTagDirty();
            }
            case 51: {
                return pSWorkflowBase.isUserTag2Dirty();
            }
            case 52: {
                return pSWorkflowBase.isUserTag3Dirty();
            }
            case 53: {
                return pSWorkflowBase.isUserTag4Dirty();
            }
            case 54: {
                return pSWorkflowBase.isValidFlagDirty();
            }
            case 55: {
                return pSWorkflowBase.isWFCancelValueDirty();
            }
            case 56: {
                return pSWorkflowBase.isWFCancelValueTextDirty();
            }
            case 57: {
                return pSWorkflowBase.isWFEditViewTypeDirty();
            }
            case 58: {
                return pSWorkflowBase.isWFEngineTypeDirty();
            }
            case 59: {
                return pSWorkflowBase.isWFErrorValueDirty();
            }
            case 60: {
                return pSWorkflowBase.isWFErrorValueTextDirty();
            }
            case 61: {
                return pSWorkflowBase.isWFFinishValueDirty();
            }
            case 62: {
                return pSWorkflowBase.isWFFinishValueTextDirty();
            }
            case 63: {
                return pSWorkflowBase.isWFProxyModeDirty();
            }
            case 64: {
                return pSWorkflowBase.isWFSNDirty();
            }
            case 65: {
                return pSWorkflowBase.isWFStateValueDirty();
            }
            case 66: {
                return pSWorkflowBase.isWFStepCodeListIdDirty();
            }
            case 67: {
                return pSWorkflowBase.isWFStepCodeListNameDirty();
            }
            case 68: {
                return pSWorkflowBase.isWFTagDirty();
            }
            case 69: {
                return pSWorkflowBase.isWFTag2Dirty();
            }
            case 70: {
                return pSWorkflowBase.isWFTag3Dirty();
            }
            case 71: {
                return pSWorkflowBase.isWFTag4Dirty();
            }
            case 72: {
                return pSWorkflowBase.isWFTypeDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSWorkflowBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSWorkflowBase pSWorkflowBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSWorkflowBase.getActionMobPSDEViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionmobpsdeviewid", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getActionMobPSDEViewId()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getActionMobPSDEViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionmobpsdeviewname", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getActionMobPSDEViewName()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getActionPSDEViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionpsdeviewid", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getActionPSDEViewId()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getActionPSDEViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionpsdeviewname", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getActionPSDEViewName()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getCodeName()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getEditableWFStep() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"editablewfstep", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getEditableWFStep()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getEnable() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enable", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getEnable()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getEnableDynaSys() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enabledynasys", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getEnableDynaSys()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getEnableDynaView() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enabledynaview", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getEnableDynaView()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getEnableMob() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablemob", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getEnableMob()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getExtCntStates() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"extcntstates", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getExtCntStates()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getMemo()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getMobWFEditViewType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobwfeditviewtype", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getMobWFEditViewType()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getModColor() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modcolor", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getModColor()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getNamePSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"namepslanresid", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getNamePSLanResId()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getNamePSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"namepslanresname", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getNamePSLanResName()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getPSSysReqItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemid", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getPSSysReqItemId()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getPSSysReqItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemname", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getPSSysReqItemName()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getPSSysWFCatId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyswfcatid", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getPSSysWFCatId()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getPSSysWFCatName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyswfcatname", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getPSSysWFCatName()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getPSWFDEsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfdescnt", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getPSWFDEsCnt()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getPSWFVersionsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfversionscnt", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getPSWFVersionsCnt()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getPSWorkflowId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psworkflowid", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getPSWorkflowId()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getPSWorkflowName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psworkflowname", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getPSWorkflowName()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getPSWXAccountId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswxaccountid", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getPSWXAccountId()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getPSWXAccountName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswxaccountname", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getPSWXAccountName()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getPSWXEntAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswxentappid", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getPSWXEntAppId()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getPSWXEntAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswxentappname", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getPSWXEntAppName()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getRemindPSSysMsgTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"remindpssysmsgtemplid", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getRemindPSSysMsgTemplId()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getRemindPSSysMsgTemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"remindpssysmsgtemplname", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getRemindPSSysMsgTemplName()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getRemoteEngineFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"remoteengineflag", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getRemoteEngineFlag()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getStartMobPSDEViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"startmobpsdeviewid", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getStartMobPSDEViewId()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getStartMobPSDEViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"startmobpsdeviewname", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getStartMobPSDEViewName()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getStartPSDEViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"startpsdeviewid", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getStartPSDEViewId()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getStartPSDEViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"startpsdeviewname", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getStartPSDEViewName()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getStateCodeListId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"statecodelistid", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getStateCodeListId()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getStateCodeListName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"statecodelistname", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getStateCodeListName()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getToDoTask() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"todotask", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getToDoTask()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getUserCat()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getUserTag()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getWFCancelValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wfcancelvalue", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getWFCancelValue()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getWFCancelValueText() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wfcancelvaluetext", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getWFCancelValueText()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getWFEditViewType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wfeditviewtype", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getWFEditViewType()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getWFEngineType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wfenginetype", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getWFEngineType()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getWFErrorValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wferrorvalue", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getWFErrorValue()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getWFErrorValueText() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wferrorvaluetext", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getWFErrorValueText()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getWFFinishValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wffinishevalue", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getWFFinishValue()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getWFFinishValueText() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wffinishevaluetext", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getWFFinishValueText()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getWFProxyMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wfproxymode", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getWFProxyMode()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getWFSN() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wfsn", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getWFSN()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getWFStateValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wfstatevalue", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getWFStateValue()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getWFStepCodeListId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wfstepcodelistid", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getWFStepCodeListId()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getWFStepCodeListName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wfstepcodelistname", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getWFStepCodeListName()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getWFTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wftag", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getWFTag()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getWFTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wftag2", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getWFTag2()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getWFTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wftag3", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getWFTag3()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getWFTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wftag4", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getWFTag4()), (boolean)false);
        }
        if (bl || pSWorkflowBase.getWFType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wftype", (Object)PSWorkflowBase.getJSONValue((Object)pSWorkflowBase.getWFType()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSWorkflowBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSWorkflowBase pSWorkflowBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSWorkflowBase.getActionMobPSDEViewId() != null) {
            object = pSWorkflowBase.getActionMobPSDEViewId();
            xmlNode.setAttribute(FIELD_ACTIONMOBPSDEVIEWID, (String)(object == null ? "" : object));
        }
        if (bl || pSWorkflowBase.getActionMobPSDEViewName() != null) {
            object = pSWorkflowBase.getActionMobPSDEViewName();
            xmlNode.setAttribute(FIELD_ACTIONMOBPSDEVIEWNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSWorkflowBase.getActionPSDEViewId() != null) {
            object = pSWorkflowBase.getActionPSDEViewId();
            xmlNode.setAttribute(FIELD_ACTIONPSDEVIEWID, (String)(object == null ? "" : object));
        }
        if (bl || pSWorkflowBase.getActionPSDEViewName() != null) {
            object = pSWorkflowBase.getActionPSDEViewName();
            xmlNode.setAttribute(FIELD_ACTIONPSDEVIEWNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSWorkflowBase.getCodeName() != null) {
            object = pSWorkflowBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSWorkflowBase.getCreateDate() != null) {
            object = pSWorkflowBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWorkflowBase.getCreateMan() != null) {
            object = pSWorkflowBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSWorkflowBase.getDynaModelFlag() != null) {
            object = pSWorkflowBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWorkflowBase.getEditableWFStep() != null) {
            object = pSWorkflowBase.getEditableWFStep();
            xmlNode.setAttribute(FIELD_EDITABLEWFSTEP, object == null ? "" : (String)object);
        }
        if (bl || pSWorkflowBase.getEnable() != null) {
            object = pSWorkflowBase.getEnable();
            xmlNode.setAttribute(FIELD_ENABLE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWorkflowBase.getEnableDynaSys() != null) {
            object = pSWorkflowBase.getEnableDynaSys();
            xmlNode.setAttribute(FIELD_ENABLEDYNASYS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWorkflowBase.getEnableDynaView() != null) {
            object = pSWorkflowBase.getEnableDynaView();
            xmlNode.setAttribute(FIELD_ENABLEDYNAVIEW, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWorkflowBase.getEnableMob() != null) {
            object = pSWorkflowBase.getEnableMob();
            xmlNode.setAttribute(FIELD_ENABLEMOB, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWorkflowBase.getExtCntStates() != null) {
            object = pSWorkflowBase.getExtCntStates();
            xmlNode.setAttribute(FIELD_EXTCNTSTATES, object == null ? "" : (String)object);
        }
        if (bl || pSWorkflowBase.getLockFlag() != null) {
            object = pSWorkflowBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWorkflowBase.getMemo() != null) {
            object = pSWorkflowBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSWorkflowBase.getMobWFEditViewType() != null) {
            object = pSWorkflowBase.getMobWFEditViewType();
            xmlNode.setAttribute(FIELD_MOBWFEDITVIEWTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSWorkflowBase.getModColor() != null) {
            object = pSWorkflowBase.getModColor();
            xmlNode.setAttribute(FIELD_MODCOLOR, object == null ? "" : (String)object);
        }
        if (bl || pSWorkflowBase.getNamePSLanResId() != null) {
            object = pSWorkflowBase.getNamePSLanResId();
            xmlNode.setAttribute(FIELD_NAMEPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSWorkflowBase.getNamePSLanResName() != null) {
            object = pSWorkflowBase.getNamePSLanResName();
            xmlNode.setAttribute(FIELD_NAMEPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWorkflowBase.getPSDynaInstId() != null) {
            object = pSWorkflowBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSWorkflowBase.getPSModuleId() != null) {
            object = pSWorkflowBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSWorkflowBase.getPSModuleName() != null) {
            object = pSWorkflowBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSWorkflowBase.getPSSysReqItemId() != null) {
            object = pSWorkflowBase.getPSSysReqItemId();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSWorkflowBase.getPSSysReqItemName() != null) {
            object = pSWorkflowBase.getPSSysReqItemName();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWorkflowBase.getPSSystemId() != null) {
            object = pSWorkflowBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSWorkflowBase.getPSSystemName() != null) {
            object = pSWorkflowBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWorkflowBase.getPSSysWFCatId() != null) {
            object = pSWorkflowBase.getPSSysWFCatId();
            xmlNode.setAttribute(FIELD_PSSYSWFCATID, object == null ? "" : (String)object);
        }
        if (bl || pSWorkflowBase.getPSSysWFCatName() != null) {
            object = pSWorkflowBase.getPSSysWFCatName();
            xmlNode.setAttribute(FIELD_PSSYSWFCATNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWorkflowBase.getPSWFDEsCnt() != null) {
            object = pSWorkflowBase.getPSWFDEsCnt();
            xmlNode.setAttribute(FIELD_PSWFDESCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWorkflowBase.getPSWFVersionsCnt() != null) {
            object = pSWorkflowBase.getPSWFVersionsCnt();
            xmlNode.setAttribute(FIELD_PSWFVERSIONSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWorkflowBase.getPSWorkflowId() != null) {
            object = pSWorkflowBase.getPSWorkflowId();
            xmlNode.setAttribute(FIELD_PSWORKFLOWID, object == null ? "" : (String)object);
        }
        if (bl || pSWorkflowBase.getPSWorkflowName() != null) {
            object = pSWorkflowBase.getPSWorkflowName();
            xmlNode.setAttribute(FIELD_PSWORKFLOWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWorkflowBase.getPSWXAccountId() != null) {
            object = pSWorkflowBase.getPSWXAccountId();
            xmlNode.setAttribute(FIELD_PSWXACCOUNTID, object == null ? "" : (String)object);
        }
        if (bl || pSWorkflowBase.getPSWXAccountName() != null) {
            object = pSWorkflowBase.getPSWXAccountName();
            xmlNode.setAttribute(FIELD_PSWXACCOUNTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWorkflowBase.getPSWXEntAppId() != null) {
            object = pSWorkflowBase.getPSWXEntAppId();
            xmlNode.setAttribute(FIELD_PSWXENTAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSWorkflowBase.getPSWXEntAppName() != null) {
            object = pSWorkflowBase.getPSWXEntAppName();
            xmlNode.setAttribute(FIELD_PSWXENTAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWorkflowBase.getRemindPSSysMsgTemplId() != null) {
            object = pSWorkflowBase.getRemindPSSysMsgTemplId();
            xmlNode.setAttribute(FIELD_REMINDPSSYSMSGTEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSWorkflowBase.getRemindPSSysMsgTemplName() != null) {
            object = pSWorkflowBase.getRemindPSSysMsgTemplName();
            xmlNode.setAttribute(FIELD_REMINDPSSYSMSGTEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWorkflowBase.getRemoteEngineFlag() != null) {
            object = pSWorkflowBase.getRemoteEngineFlag();
            xmlNode.setAttribute(FIELD_REMOTEENGINEFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWorkflowBase.getStartMobPSDEViewId() != null) {
            object = pSWorkflowBase.getStartMobPSDEViewId();
            xmlNode.setAttribute(FIELD_STARTMOBPSDEVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSWorkflowBase.getStartMobPSDEViewName() != null) {
            object = pSWorkflowBase.getStartMobPSDEViewName();
            xmlNode.setAttribute(FIELD_STARTMOBPSDEVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWorkflowBase.getStartPSDEViewId() != null) {
            object = pSWorkflowBase.getStartPSDEViewId();
            xmlNode.setAttribute(FIELD_STARTPSDEVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSWorkflowBase.getStartPSDEViewName() != null) {
            object = pSWorkflowBase.getStartPSDEViewName();
            xmlNode.setAttribute(FIELD_STARTPSDEVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWorkflowBase.getStateCodeListId() != null) {
            object = pSWorkflowBase.getStateCodeListId();
            xmlNode.setAttribute(FIELD_STATECODELISTID, object == null ? "" : (String)object);
        }
        if (bl || pSWorkflowBase.getStateCodeListName() != null) {
            object = pSWorkflowBase.getStateCodeListName();
            xmlNode.setAttribute(FIELD_STATECODELISTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWorkflowBase.getToDoTask() != null) {
            object = pSWorkflowBase.getToDoTask();
            xmlNode.setAttribute(FIELD_TODOTASK, object == null ? "" : (String)object);
        }
        if (bl || pSWorkflowBase.getUpdateDate() != null) {
            object = pSWorkflowBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWorkflowBase.getUpdateMan() != null) {
            object = pSWorkflowBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSWorkflowBase.getUserCat() != null) {
            object = pSWorkflowBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSWorkflowBase.getUserTag() != null) {
            object = pSWorkflowBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSWorkflowBase.getUserTag2() != null) {
            object = pSWorkflowBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSWorkflowBase.getUserTag3() != null) {
            object = pSWorkflowBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSWorkflowBase.getUserTag4() != null) {
            object = pSWorkflowBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSWorkflowBase.getValidFlag() != null) {
            object = pSWorkflowBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWorkflowBase.getWFCancelValue() != null) {
            object = pSWorkflowBase.getWFCancelValue();
            xmlNode.setAttribute(FIELD_WFCANCELVALUE, object == null ? "" : (String)object);
        }
        if (bl || pSWorkflowBase.getWFCancelValueText() != null) {
            object = pSWorkflowBase.getWFCancelValueText();
            xmlNode.setAttribute(FIELD_WFCANCELVALUETEXT, object == null ? "" : (String)object);
        }
        if (bl || pSWorkflowBase.getWFEditViewType() != null) {
            object = pSWorkflowBase.getWFEditViewType();
            xmlNode.setAttribute(FIELD_WFEDITVIEWTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSWorkflowBase.getWFEngineType() != null) {
            object = pSWorkflowBase.getWFEngineType();
            xmlNode.setAttribute(FIELD_WFENGINETYPE, object == null ? "" : (String)object);
        }
        if (bl || pSWorkflowBase.getWFErrorValue() != null) {
            object = pSWorkflowBase.getWFErrorValue();
            xmlNode.setAttribute(FIELD_WFERRORVALUE, object == null ? "" : (String)object);
        }
        if (bl || pSWorkflowBase.getWFErrorValueText() != null) {
            object = pSWorkflowBase.getWFErrorValueText();
            xmlNode.setAttribute(FIELD_WFERRORVALUETEXT, object == null ? "" : (String)object);
        }
        if (bl || pSWorkflowBase.getWFFinishValue() != null) {
            object = pSWorkflowBase.getWFFinishValue();
            xmlNode.setAttribute("WFFINISHVALUE", object == null ? "" : (String)object);
        }
        if (bl || pSWorkflowBase.getWFFinishValueText() != null) {
            object = pSWorkflowBase.getWFFinishValueText();
            xmlNode.setAttribute("WFFINISHVALUETEXT", object == null ? "" : (String)object);
        }
        if (bl || pSWorkflowBase.getWFProxyMode() != null) {
            object = pSWorkflowBase.getWFProxyMode();
            xmlNode.setAttribute(FIELD_WFPROXYMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWorkflowBase.getWFSN() != null) {
            object = pSWorkflowBase.getWFSN();
            xmlNode.setAttribute(FIELD_WFSN, object == null ? "" : (String)object);
        }
        if (bl || pSWorkflowBase.getWFStateValue() != null) {
            object = pSWorkflowBase.getWFStateValue();
            xmlNode.setAttribute(FIELD_WFSTATEVALUE, object == null ? "" : (String)object);
        }
        if (bl || pSWorkflowBase.getWFStepCodeListId() != null) {
            object = pSWorkflowBase.getWFStepCodeListId();
            xmlNode.setAttribute(FIELD_WFSTEPCODELISTID, object == null ? "" : (String)object);
        }
        if (bl || pSWorkflowBase.getWFStepCodeListName() != null) {
            object = pSWorkflowBase.getWFStepCodeListName();
            xmlNode.setAttribute(FIELD_WFSTEPCODELISTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWorkflowBase.getWFTag() != null) {
            object = pSWorkflowBase.getWFTag();
            xmlNode.setAttribute(FIELD_WFTAG, object == null ? "" : (String)object);
        }
        if (bl || pSWorkflowBase.getWFTag2() != null) {
            object = pSWorkflowBase.getWFTag2();
            xmlNode.setAttribute(FIELD_WFTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSWorkflowBase.getWFTag3() != null) {
            object = pSWorkflowBase.getWFTag3();
            xmlNode.setAttribute(FIELD_WFTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSWorkflowBase.getWFTag4() != null) {
            object = pSWorkflowBase.getWFTag4();
            xmlNode.setAttribute(FIELD_WFTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSWorkflowBase.getWFType() != null) {
            object = pSWorkflowBase.getWFType();
            xmlNode.setAttribute(FIELD_WFTYPE, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSWorkflowBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSWorkflowBase pSWorkflowBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSWorkflowBase.isActionMobPSDEViewIdDirty() && (bl || pSWorkflowBase.getActionMobPSDEViewId() != null)) {
            iDataObject.set(FIELD_ACTIONMOBPSDEVIEWID, (Object)pSWorkflowBase.getActionMobPSDEViewId());
        }
        if (pSWorkflowBase.isActionMobPSDEViewNameDirty() && (bl || pSWorkflowBase.getActionMobPSDEViewName() != null)) {
            iDataObject.set(FIELD_ACTIONMOBPSDEVIEWNAME, (Object)pSWorkflowBase.getActionMobPSDEViewName());
        }
        if (pSWorkflowBase.isActionPSDEViewIdDirty() && (bl || pSWorkflowBase.getActionPSDEViewId() != null)) {
            iDataObject.set(FIELD_ACTIONPSDEVIEWID, (Object)pSWorkflowBase.getActionPSDEViewId());
        }
        if (pSWorkflowBase.isActionPSDEViewNameDirty() && (bl || pSWorkflowBase.getActionPSDEViewName() != null)) {
            iDataObject.set(FIELD_ACTIONPSDEVIEWNAME, (Object)pSWorkflowBase.getActionPSDEViewName());
        }
        if (pSWorkflowBase.isCodeNameDirty() && (bl || pSWorkflowBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSWorkflowBase.getCodeName());
        }
        if (pSWorkflowBase.isCreateDateDirty() && (bl || pSWorkflowBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSWorkflowBase.getCreateDate());
        }
        if (pSWorkflowBase.isCreateManDirty() && (bl || pSWorkflowBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSWorkflowBase.getCreateMan());
        }
        if (pSWorkflowBase.isDynaModelFlagDirty() && (bl || pSWorkflowBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSWorkflowBase.getDynaModelFlag());
        }
        if (pSWorkflowBase.isEditableWFStepDirty() && (bl || pSWorkflowBase.getEditableWFStep() != null)) {
            iDataObject.set(FIELD_EDITABLEWFSTEP, (Object)pSWorkflowBase.getEditableWFStep());
        }
        if (pSWorkflowBase.isEnableDirty() && (bl || pSWorkflowBase.getEnable() != null)) {
            iDataObject.set(FIELD_ENABLE, (Object)pSWorkflowBase.getEnable());
        }
        if (pSWorkflowBase.isEnableDynaSysDirty() && (bl || pSWorkflowBase.getEnableDynaSys() != null)) {
            iDataObject.set(FIELD_ENABLEDYNASYS, (Object)pSWorkflowBase.getEnableDynaSys());
        }
        if (pSWorkflowBase.isEnableDynaViewDirty() && (bl || pSWorkflowBase.getEnableDynaView() != null)) {
            iDataObject.set(FIELD_ENABLEDYNAVIEW, (Object)pSWorkflowBase.getEnableDynaView());
        }
        if (pSWorkflowBase.isEnableMobDirty() && (bl || pSWorkflowBase.getEnableMob() != null)) {
            iDataObject.set(FIELD_ENABLEMOB, (Object)pSWorkflowBase.getEnableMob());
        }
        if (pSWorkflowBase.isExtCntStatesDirty() && (bl || pSWorkflowBase.getExtCntStates() != null)) {
            iDataObject.set(FIELD_EXTCNTSTATES, (Object)pSWorkflowBase.getExtCntStates());
        }
        if (pSWorkflowBase.isLockFlagDirty() && (bl || pSWorkflowBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSWorkflowBase.getLockFlag());
        }
        if (pSWorkflowBase.isMemoDirty() && (bl || pSWorkflowBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSWorkflowBase.getMemo());
        }
        if (pSWorkflowBase.isMobWFEditViewTypeDirty() && (bl || pSWorkflowBase.getMobWFEditViewType() != null)) {
            iDataObject.set(FIELD_MOBWFEDITVIEWTYPE, (Object)pSWorkflowBase.getMobWFEditViewType());
        }
        if (pSWorkflowBase.isModColorDirty() && (bl || pSWorkflowBase.getModColor() != null)) {
            iDataObject.set(FIELD_MODCOLOR, (Object)pSWorkflowBase.getModColor());
        }
        if (pSWorkflowBase.isNamePSLanResIdDirty() && (bl || pSWorkflowBase.getNamePSLanResId() != null)) {
            iDataObject.set(FIELD_NAMEPSLANRESID, (Object)pSWorkflowBase.getNamePSLanResId());
        }
        if (pSWorkflowBase.isNamePSLanResNameDirty() && (bl || pSWorkflowBase.getNamePSLanResName() != null)) {
            iDataObject.set(FIELD_NAMEPSLANRESNAME, (Object)pSWorkflowBase.getNamePSLanResName());
        }
        if (pSWorkflowBase.isPSDynaInstIdDirty() && (bl || pSWorkflowBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSWorkflowBase.getPSDynaInstId());
        }
        if (pSWorkflowBase.isPSModuleIdDirty() && (bl || pSWorkflowBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSWorkflowBase.getPSModuleId());
        }
        if (pSWorkflowBase.isPSModuleNameDirty() && (bl || pSWorkflowBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSWorkflowBase.getPSModuleName());
        }
        if (pSWorkflowBase.isPSSysReqItemIdDirty() && (bl || pSWorkflowBase.getPSSysReqItemId() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMID, (Object)pSWorkflowBase.getPSSysReqItemId());
        }
        if (pSWorkflowBase.isPSSysReqItemNameDirty() && (bl || pSWorkflowBase.getPSSysReqItemName() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMNAME, (Object)pSWorkflowBase.getPSSysReqItemName());
        }
        if (pSWorkflowBase.isPSSystemIdDirty() && (bl || pSWorkflowBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSWorkflowBase.getPSSystemId());
        }
        if (pSWorkflowBase.isPSSystemNameDirty() && (bl || pSWorkflowBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSWorkflowBase.getPSSystemName());
        }
        if (pSWorkflowBase.isPSSysWFCatIdDirty() && (bl || pSWorkflowBase.getPSSysWFCatId() != null)) {
            iDataObject.set(FIELD_PSSYSWFCATID, (Object)pSWorkflowBase.getPSSysWFCatId());
        }
        if (pSWorkflowBase.isPSSysWFCatNameDirty() && (bl || pSWorkflowBase.getPSSysWFCatName() != null)) {
            iDataObject.set(FIELD_PSSYSWFCATNAME, (Object)pSWorkflowBase.getPSSysWFCatName());
        }
        if (pSWorkflowBase.isPSWFDEsCntDirty() && (bl || pSWorkflowBase.getPSWFDEsCnt() != null)) {
            iDataObject.set(FIELD_PSWFDESCNT, (Object)pSWorkflowBase.getPSWFDEsCnt());
        }
        if (pSWorkflowBase.isPSWFVersionsCntDirty() && (bl || pSWorkflowBase.getPSWFVersionsCnt() != null)) {
            iDataObject.set(FIELD_PSWFVERSIONSCNT, (Object)pSWorkflowBase.getPSWFVersionsCnt());
        }
        if (pSWorkflowBase.isPSWorkflowIdDirty() && (bl || pSWorkflowBase.getPSWorkflowId() != null)) {
            iDataObject.set(FIELD_PSWORKFLOWID, (Object)pSWorkflowBase.getPSWorkflowId());
        }
        if (pSWorkflowBase.isPSWorkflowNameDirty() && (bl || pSWorkflowBase.getPSWorkflowName() != null)) {
            iDataObject.set(FIELD_PSWORKFLOWNAME, (Object)pSWorkflowBase.getPSWorkflowName());
        }
        if (pSWorkflowBase.isPSWXAccountIdDirty() && (bl || pSWorkflowBase.getPSWXAccountId() != null)) {
            iDataObject.set(FIELD_PSWXACCOUNTID, (Object)pSWorkflowBase.getPSWXAccountId());
        }
        if (pSWorkflowBase.isPSWXAccountNameDirty() && (bl || pSWorkflowBase.getPSWXAccountName() != null)) {
            iDataObject.set(FIELD_PSWXACCOUNTNAME, (Object)pSWorkflowBase.getPSWXAccountName());
        }
        if (pSWorkflowBase.isPSWXEntAppIdDirty() && (bl || pSWorkflowBase.getPSWXEntAppId() != null)) {
            iDataObject.set(FIELD_PSWXENTAPPID, (Object)pSWorkflowBase.getPSWXEntAppId());
        }
        if (pSWorkflowBase.isPSWXEntAppNameDirty() && (bl || pSWorkflowBase.getPSWXEntAppName() != null)) {
            iDataObject.set(FIELD_PSWXENTAPPNAME, (Object)pSWorkflowBase.getPSWXEntAppName());
        }
        if (pSWorkflowBase.isRemindPSSysMsgTemplIdDirty() && (bl || pSWorkflowBase.getRemindPSSysMsgTemplId() != null)) {
            iDataObject.set(FIELD_REMINDPSSYSMSGTEMPLID, (Object)pSWorkflowBase.getRemindPSSysMsgTemplId());
        }
        if (pSWorkflowBase.isRemindPSSysMsgTemplNameDirty() && (bl || pSWorkflowBase.getRemindPSSysMsgTemplName() != null)) {
            iDataObject.set(FIELD_REMINDPSSYSMSGTEMPLNAME, (Object)pSWorkflowBase.getRemindPSSysMsgTemplName());
        }
        if (pSWorkflowBase.isRemoteEngineFlagDirty() && (bl || pSWorkflowBase.getRemoteEngineFlag() != null)) {
            iDataObject.set(FIELD_REMOTEENGINEFLAG, (Object)pSWorkflowBase.getRemoteEngineFlag());
        }
        if (pSWorkflowBase.isStartMobPSDEViewIdDirty() && (bl || pSWorkflowBase.getStartMobPSDEViewId() != null)) {
            iDataObject.set(FIELD_STARTMOBPSDEVIEWID, (Object)pSWorkflowBase.getStartMobPSDEViewId());
        }
        if (pSWorkflowBase.isStartMobPSDEViewNameDirty() && (bl || pSWorkflowBase.getStartMobPSDEViewName() != null)) {
            iDataObject.set(FIELD_STARTMOBPSDEVIEWNAME, (Object)pSWorkflowBase.getStartMobPSDEViewName());
        }
        if (pSWorkflowBase.isStartPSDEViewIdDirty() && (bl || pSWorkflowBase.getStartPSDEViewId() != null)) {
            iDataObject.set(FIELD_STARTPSDEVIEWID, (Object)pSWorkflowBase.getStartPSDEViewId());
        }
        if (pSWorkflowBase.isStartPSDEViewNameDirty() && (bl || pSWorkflowBase.getStartPSDEViewName() != null)) {
            iDataObject.set(FIELD_STARTPSDEVIEWNAME, (Object)pSWorkflowBase.getStartPSDEViewName());
        }
        if (pSWorkflowBase.isStateCodeListIdDirty() && (bl || pSWorkflowBase.getStateCodeListId() != null)) {
            iDataObject.set(FIELD_STATECODELISTID, (Object)pSWorkflowBase.getStateCodeListId());
        }
        if (pSWorkflowBase.isStateCodeListNameDirty() && (bl || pSWorkflowBase.getStateCodeListName() != null)) {
            iDataObject.set(FIELD_STATECODELISTNAME, (Object)pSWorkflowBase.getStateCodeListName());
        }
        if (pSWorkflowBase.isToDoTaskDirty() && (bl || pSWorkflowBase.getToDoTask() != null)) {
            iDataObject.set(FIELD_TODOTASK, (Object)pSWorkflowBase.getToDoTask());
        }
        if (pSWorkflowBase.isUpdateDateDirty() && (bl || pSWorkflowBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSWorkflowBase.getUpdateDate());
        }
        if (pSWorkflowBase.isUpdateManDirty() && (bl || pSWorkflowBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSWorkflowBase.getUpdateMan());
        }
        if (pSWorkflowBase.isUserCatDirty() && (bl || pSWorkflowBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSWorkflowBase.getUserCat());
        }
        if (pSWorkflowBase.isUserTagDirty() && (bl || pSWorkflowBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSWorkflowBase.getUserTag());
        }
        if (pSWorkflowBase.isUserTag2Dirty() && (bl || pSWorkflowBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSWorkflowBase.getUserTag2());
        }
        if (pSWorkflowBase.isUserTag3Dirty() && (bl || pSWorkflowBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSWorkflowBase.getUserTag3());
        }
        if (pSWorkflowBase.isUserTag4Dirty() && (bl || pSWorkflowBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSWorkflowBase.getUserTag4());
        }
        if (pSWorkflowBase.isValidFlagDirty() && (bl || pSWorkflowBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSWorkflowBase.getValidFlag());
        }
        if (pSWorkflowBase.isWFCancelValueDirty() && (bl || pSWorkflowBase.getWFCancelValue() != null)) {
            iDataObject.set(FIELD_WFCANCELVALUE, (Object)pSWorkflowBase.getWFCancelValue());
        }
        if (pSWorkflowBase.isWFCancelValueTextDirty() && (bl || pSWorkflowBase.getWFCancelValueText() != null)) {
            iDataObject.set(FIELD_WFCANCELVALUETEXT, (Object)pSWorkflowBase.getWFCancelValueText());
        }
        if (pSWorkflowBase.isWFEditViewTypeDirty() && (bl || pSWorkflowBase.getWFEditViewType() != null)) {
            iDataObject.set(FIELD_WFEDITVIEWTYPE, (Object)pSWorkflowBase.getWFEditViewType());
        }
        if (pSWorkflowBase.isWFEngineTypeDirty() && (bl || pSWorkflowBase.getWFEngineType() != null)) {
            iDataObject.set(FIELD_WFENGINETYPE, (Object)pSWorkflowBase.getWFEngineType());
        }
        if (pSWorkflowBase.isWFErrorValueDirty() && (bl || pSWorkflowBase.getWFErrorValue() != null)) {
            iDataObject.set(FIELD_WFERRORVALUE, (Object)pSWorkflowBase.getWFErrorValue());
        }
        if (pSWorkflowBase.isWFErrorValueTextDirty() && (bl || pSWorkflowBase.getWFErrorValueText() != null)) {
            iDataObject.set(FIELD_WFERRORVALUETEXT, (Object)pSWorkflowBase.getWFErrorValueText());
        }
        if (pSWorkflowBase.isWFFinishValueDirty() && (bl || pSWorkflowBase.getWFFinishValue() != null)) {
            iDataObject.set(FIELD_WFFINISHVALUE, (Object)pSWorkflowBase.getWFFinishValue());
        }
        if (pSWorkflowBase.isWFFinishValueTextDirty() && (bl || pSWorkflowBase.getWFFinishValueText() != null)) {
            iDataObject.set(FIELD_WFFINISHVALUETEXT, (Object)pSWorkflowBase.getWFFinishValueText());
        }
        if (pSWorkflowBase.isWFProxyModeDirty() && (bl || pSWorkflowBase.getWFProxyMode() != null)) {
            iDataObject.set(FIELD_WFPROXYMODE, (Object)pSWorkflowBase.getWFProxyMode());
        }
        if (pSWorkflowBase.isWFSNDirty() && (bl || pSWorkflowBase.getWFSN() != null)) {
            iDataObject.set(FIELD_WFSN, (Object)pSWorkflowBase.getWFSN());
        }
        if (pSWorkflowBase.isWFStateValueDirty() && (bl || pSWorkflowBase.getWFStateValue() != null)) {
            iDataObject.set(FIELD_WFSTATEVALUE, (Object)pSWorkflowBase.getWFStateValue());
        }
        if (pSWorkflowBase.isWFStepCodeListIdDirty() && (bl || pSWorkflowBase.getWFStepCodeListId() != null)) {
            iDataObject.set(FIELD_WFSTEPCODELISTID, (Object)pSWorkflowBase.getWFStepCodeListId());
        }
        if (pSWorkflowBase.isWFStepCodeListNameDirty() && (bl || pSWorkflowBase.getWFStepCodeListName() != null)) {
            iDataObject.set(FIELD_WFSTEPCODELISTNAME, (Object)pSWorkflowBase.getWFStepCodeListName());
        }
        if (pSWorkflowBase.isWFTagDirty() && (bl || pSWorkflowBase.getWFTag() != null)) {
            iDataObject.set(FIELD_WFTAG, (Object)pSWorkflowBase.getWFTag());
        }
        if (pSWorkflowBase.isWFTag2Dirty() && (bl || pSWorkflowBase.getWFTag2() != null)) {
            iDataObject.set(FIELD_WFTAG2, (Object)pSWorkflowBase.getWFTag2());
        }
        if (pSWorkflowBase.isWFTag3Dirty() && (bl || pSWorkflowBase.getWFTag3() != null)) {
            iDataObject.set(FIELD_WFTAG3, (Object)pSWorkflowBase.getWFTag3());
        }
        if (pSWorkflowBase.isWFTag4Dirty() && (bl || pSWorkflowBase.getWFTag4() != null)) {
            iDataObject.set(FIELD_WFTAG4, (Object)pSWorkflowBase.getWFTag4());
        }
        if (pSWorkflowBase.isWFTypeDirty() && (bl || pSWorkflowBase.getWFType() != null)) {
            iDataObject.set(FIELD_WFTYPE, (Object)pSWorkflowBase.getWFType());
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
        return PSWorkflowBase.remove(this, n);
    }

    private static boolean remove(PSWorkflowBase pSWorkflowBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSWorkflowBase.resetActionMobPSDEViewId();
                return true;
            }
            case 1: {
                pSWorkflowBase.resetActionMobPSDEViewName();
                return true;
            }
            case 2: {
                pSWorkflowBase.resetActionPSDEViewId();
                return true;
            }
            case 3: {
                pSWorkflowBase.resetActionPSDEViewName();
                return true;
            }
            case 4: {
                pSWorkflowBase.resetCodeName();
                return true;
            }
            case 5: {
                pSWorkflowBase.resetCreateDate();
                return true;
            }
            case 6: {
                pSWorkflowBase.resetCreateMan();
                return true;
            }
            case 7: {
                pSWorkflowBase.resetDynaModelFlag();
                return true;
            }
            case 8: {
                pSWorkflowBase.resetEditableWFStep();
                return true;
            }
            case 9: {
                pSWorkflowBase.resetEnable();
                return true;
            }
            case 10: {
                pSWorkflowBase.resetEnableDynaSys();
                return true;
            }
            case 11: {
                pSWorkflowBase.resetEnableDynaView();
                return true;
            }
            case 12: {
                pSWorkflowBase.resetEnableMob();
                return true;
            }
            case 13: {
                pSWorkflowBase.resetExtCntStates();
                return true;
            }
            case 14: {
                pSWorkflowBase.resetLockFlag();
                return true;
            }
            case 15: {
                pSWorkflowBase.resetMemo();
                return true;
            }
            case 16: {
                pSWorkflowBase.resetMobWFEditViewType();
                return true;
            }
            case 17: {
                pSWorkflowBase.resetModColor();
                return true;
            }
            case 18: {
                pSWorkflowBase.resetNamePSLanResId();
                return true;
            }
            case 19: {
                pSWorkflowBase.resetNamePSLanResName();
                return true;
            }
            case 20: {
                pSWorkflowBase.resetPSDynaInstId();
                return true;
            }
            case 21: {
                pSWorkflowBase.resetPSModuleId();
                return true;
            }
            case 22: {
                pSWorkflowBase.resetPSModuleName();
                return true;
            }
            case 23: {
                pSWorkflowBase.resetPSSysReqItemId();
                return true;
            }
            case 24: {
                pSWorkflowBase.resetPSSysReqItemName();
                return true;
            }
            case 25: {
                pSWorkflowBase.resetPSSystemId();
                return true;
            }
            case 26: {
                pSWorkflowBase.resetPSSystemName();
                return true;
            }
            case 27: {
                pSWorkflowBase.resetPSSysWFCatId();
                return true;
            }
            case 28: {
                pSWorkflowBase.resetPSSysWFCatName();
                return true;
            }
            case 29: {
                pSWorkflowBase.resetPSWFDEsCnt();
                return true;
            }
            case 30: {
                pSWorkflowBase.resetPSWFVersionsCnt();
                return true;
            }
            case 31: {
                pSWorkflowBase.resetPSWorkflowId();
                return true;
            }
            case 32: {
                pSWorkflowBase.resetPSWorkflowName();
                return true;
            }
            case 33: {
                pSWorkflowBase.resetPSWXAccountId();
                return true;
            }
            case 34: {
                pSWorkflowBase.resetPSWXAccountName();
                return true;
            }
            case 35: {
                pSWorkflowBase.resetPSWXEntAppId();
                return true;
            }
            case 36: {
                pSWorkflowBase.resetPSWXEntAppName();
                return true;
            }
            case 37: {
                pSWorkflowBase.resetRemindPSSysMsgTemplId();
                return true;
            }
            case 38: {
                pSWorkflowBase.resetRemindPSSysMsgTemplName();
                return true;
            }
            case 39: {
                pSWorkflowBase.resetRemoteEngineFlag();
                return true;
            }
            case 40: {
                pSWorkflowBase.resetStartMobPSDEViewId();
                return true;
            }
            case 41: {
                pSWorkflowBase.resetStartMobPSDEViewName();
                return true;
            }
            case 42: {
                pSWorkflowBase.resetStartPSDEViewId();
                return true;
            }
            case 43: {
                pSWorkflowBase.resetStartPSDEViewName();
                return true;
            }
            case 44: {
                pSWorkflowBase.resetStateCodeListId();
                return true;
            }
            case 45: {
                pSWorkflowBase.resetStateCodeListName();
                return true;
            }
            case 46: {
                pSWorkflowBase.resetToDoTask();
                return true;
            }
            case 47: {
                pSWorkflowBase.resetUpdateDate();
                return true;
            }
            case 48: {
                pSWorkflowBase.resetUpdateMan();
                return true;
            }
            case 49: {
                pSWorkflowBase.resetUserCat();
                return true;
            }
            case 50: {
                pSWorkflowBase.resetUserTag();
                return true;
            }
            case 51: {
                pSWorkflowBase.resetUserTag2();
                return true;
            }
            case 52: {
                pSWorkflowBase.resetUserTag3();
                return true;
            }
            case 53: {
                pSWorkflowBase.resetUserTag4();
                return true;
            }
            case 54: {
                pSWorkflowBase.resetValidFlag();
                return true;
            }
            case 55: {
                pSWorkflowBase.resetWFCancelValue();
                return true;
            }
            case 56: {
                pSWorkflowBase.resetWFCancelValueText();
                return true;
            }
            case 57: {
                pSWorkflowBase.resetWFEditViewType();
                return true;
            }
            case 58: {
                pSWorkflowBase.resetWFEngineType();
                return true;
            }
            case 59: {
                pSWorkflowBase.resetWFErrorValue();
                return true;
            }
            case 60: {
                pSWorkflowBase.resetWFErrorValueText();
                return true;
            }
            case 61: {
                pSWorkflowBase.resetWFFinishValue();
                return true;
            }
            case 62: {
                pSWorkflowBase.resetWFFinishValueText();
                return true;
            }
            case 63: {
                pSWorkflowBase.resetWFProxyMode();
                return true;
            }
            case 64: {
                pSWorkflowBase.resetWFSN();
                return true;
            }
            case 65: {
                pSWorkflowBase.resetWFStateValue();
                return true;
            }
            case 66: {
                pSWorkflowBase.resetWFStepCodeListId();
                return true;
            }
            case 67: {
                pSWorkflowBase.resetWFStepCodeListName();
                return true;
            }
            case 68: {
                pSWorkflowBase.resetWFTag();
                return true;
            }
            case 69: {
                pSWorkflowBase.resetWFTag2();
                return true;
            }
            case 70: {
                pSWorkflowBase.resetWFTag3();
                return true;
            }
            case 71: {
                pSWorkflowBase.resetWFTag4();
                return true;
            }
            case 72: {
                pSWorkflowBase.resetWFType();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCodeList getStateCodeList() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStateCodeList();
        }
        if (this.getStateCodeListId() == null) {
            return null;
        }
        Integer n = this.objStateCodeListLock;
        synchronized (n) {
            if (this.statecodelist != null && DataTypeHelper.compare((int)25, (Object)this.getStateCodeListId(), (Object)this.statecodelist.getPSCodeListId()) != 0L) {
                this.statecodelist = null;
            }
            if (this.statecodelist == null) {
                PSCodeList pSCodeList = new PSCodeList();
                pSCodeList.setPSCodeListId(this.getStateCodeListId());
                PSCodeListService pSCodeListService = (PSCodeListService)ServiceGlobal.getService(PSCodeListService.class, (SessionFactory)this.getSessionFactory());
                pSCodeListService.autoGet(pSCodeList);
                this.statecodelist = pSCodeList;
            }
            return this.statecodelist;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCodeList getWFStepCodeList() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFStepCodeList();
        }
        if (this.getWFStepCodeListId() == null) {
            return null;
        }
        Integer n = this.objWFStepCodeListLock;
        synchronized (n) {
            if (this.wfstepcodelist != null && DataTypeHelper.compare((int)25, (Object)this.getWFStepCodeListId(), (Object)this.wfstepcodelist.getPSCodeListId()) != 0L) {
                this.wfstepcodelist = null;
            }
            if (this.wfstepcodelist == null) {
                PSCodeList pSCodeList = new PSCodeList();
                pSCodeList.setPSCodeListId(this.getWFStepCodeListId());
                PSCodeListService pSCodeListService = (PSCodeListService)ServiceGlobal.getService(PSCodeListService.class, (SessionFactory)this.getSessionFactory());
                pSCodeListService.autoGet(pSCodeList);
                this.wfstepcodelist = pSCodeList;
            }
            return this.wfstepcodelist;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEViewBase getActionMobPSDEView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionMobPSDEView();
        }
        if (this.getActionMobPSDEViewId() == null) {
            return null;
        }
        Integer n = this.objActionMobPSDEViewLock;
        synchronized (n) {
            if (this.actionmobpsdeview != null && DataTypeHelper.compare((int)25, (Object)this.getActionMobPSDEViewId(), (Object)this.actionmobpsdeview.getPSDEViewBaseId()) != 0L) {
                this.actionmobpsdeview = null;
            }
            if (this.actionmobpsdeview == null) {
                PSDEViewBase pSDEViewBase = new PSDEViewBase();
                pSDEViewBase.setPSDEViewBaseId(this.getActionMobPSDEViewId());
                PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
                pSDEViewBaseService.autoGet(pSDEViewBase);
                this.actionmobpsdeview = pSDEViewBase;
            }
            return this.actionmobpsdeview;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEViewBase getActionPSDEView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionPSDEView();
        }
        if (this.getActionPSDEViewId() == null) {
            return null;
        }
        Integer n = this.objActionPSDEViewLock;
        synchronized (n) {
            if (this.actionpsdeview != null && DataTypeHelper.compare((int)25, (Object)this.getActionPSDEViewId(), (Object)this.actionpsdeview.getPSDEViewBaseId()) != 0L) {
                this.actionpsdeview = null;
            }
            if (this.actionpsdeview == null) {
                PSDEViewBase pSDEViewBase = new PSDEViewBase();
                pSDEViewBase.setPSDEViewBaseId(this.getActionPSDEViewId());
                PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
                pSDEViewBaseService.autoGet(pSDEViewBase);
                this.actionpsdeview = pSDEViewBase;
            }
            return this.actionpsdeview;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEViewBase getStartMobPSDEView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStartMobPSDEView();
        }
        if (this.getStartMobPSDEViewId() == null) {
            return null;
        }
        Integer n = this.objStartMobPSDEViewLock;
        synchronized (n) {
            if (this.startmobpsdeview != null && DataTypeHelper.compare((int)25, (Object)this.getStartMobPSDEViewId(), (Object)this.startmobpsdeview.getPSDEViewBaseId()) != 0L) {
                this.startmobpsdeview = null;
            }
            if (this.startmobpsdeview == null) {
                PSDEViewBase pSDEViewBase = new PSDEViewBase();
                pSDEViewBase.setPSDEViewBaseId(this.getStartMobPSDEViewId());
                PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
                pSDEViewBaseService.autoGet(pSDEViewBase);
                this.startmobpsdeview = pSDEViewBase;
            }
            return this.startmobpsdeview;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEViewBase getStartPSDEView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStartPSDEView();
        }
        if (this.getStartPSDEViewId() == null) {
            return null;
        }
        Integer n = this.objStartPSDEViewLock;
        synchronized (n) {
            if (this.startpsdeview != null && DataTypeHelper.compare((int)25, (Object)this.getStartPSDEViewId(), (Object)this.startpsdeview.getPSDEViewBaseId()) != 0L) {
                this.startpsdeview = null;
            }
            if (this.startpsdeview == null) {
                PSDEViewBase pSDEViewBase = new PSDEViewBase();
                pSDEViewBase.setPSDEViewBaseId(this.getStartPSDEViewId());
                PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
                pSDEViewBaseService.autoGet(pSDEViewBase);
                this.startpsdeview = pSDEViewBase;
            }
            return this.startpsdeview;
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
                pSLanguageResService.autoGet(pSLanguageRes);
                this.namepslanres = pSLanguageRes;
            }
            return this.namepslanres;
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
    public PSSysMsgTempl getRemindPSSysMsgTempl() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRemindPSSysMsgTempl();
        }
        if (this.getRemindPSSysMsgTemplId() == null) {
            return null;
        }
        Integer n = this.objRemindPSSysMsgTemplLock;
        synchronized (n) {
            if (this.remindpssysmsgtempl != null && DataTypeHelper.compare((int)25, (Object)this.getRemindPSSysMsgTemplId(), (Object)this.remindpssysmsgtempl.getPSSysMsgTemplId()) != 0L) {
                this.remindpssysmsgtempl = null;
            }
            if (this.remindpssysmsgtempl == null) {
                PSSysMsgTempl pSSysMsgTempl = new PSSysMsgTempl();
                pSSysMsgTempl.setPSSysMsgTemplId(this.getRemindPSSysMsgTemplId());
                PSSysMsgTemplService pSSysMsgTemplService = (PSSysMsgTemplService)ServiceGlobal.getService(PSSysMsgTemplService.class, (SessionFactory)this.getSessionFactory());
                pSSysMsgTemplService.autoGet(pSSysMsgTempl);
                this.remindpssysmsgtempl = pSSysMsgTempl;
            }
            return this.remindpssysmsgtempl;
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
    public PSSysWFCat getPSSysWFCat() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysWFCat();
        }
        if (this.getPSSysWFCatId() == null) {
            return null;
        }
        Integer n = this.objPSSysWFCatLock;
        synchronized (n) {
            if (this.pssyswfcat != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysWFCatId(), (Object)this.pssyswfcat.getPSSysWFCatId()) != 0L) {
                this.pssyswfcat = null;
            }
            if (this.pssyswfcat == null) {
                PSSysWFCat pSSysWFCat = new PSSysWFCat();
                pSSysWFCat.setPSSysWFCatId(this.getPSSysWFCatId());
                PSSysWFCatService pSSysWFCatService = (PSSysWFCatService)ServiceGlobal.getService(PSSysWFCatService.class, (SessionFactory)this.getSessionFactory());
                pSSysWFCatService.autoGet(pSSysWFCat);
                this.pssyswfcat = pSSysWFCat;
            }
            return this.pssyswfcat;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSWXAccount getPSWXAccount() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWXAccount();
        }
        if (this.getPSWXAccountId() == null) {
            return null;
        }
        Integer n = this.objPSWXAccountLock;
        synchronized (n) {
            if (this.pswxaccount != null && DataTypeHelper.compare((int)25, (Object)this.getPSWXAccountId(), (Object)this.pswxaccount.getPSWXAccountId()) != 0L) {
                this.pswxaccount = null;
            }
            if (this.pswxaccount == null) {
                PSWXAccount pSWXAccount = new PSWXAccount();
                pSWXAccount.setPSWXAccountId(this.getPSWXAccountId());
                PSWXAccountService pSWXAccountService = (PSWXAccountService)ServiceGlobal.getService(PSWXAccountService.class, (SessionFactory)this.getSessionFactory());
                pSWXAccountService.autoGet(pSWXAccount);
                this.pswxaccount = pSWXAccount;
            }
            return this.pswxaccount;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSWXEntApp getPSWXEntApp() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWXEntApp();
        }
        if (this.getPSWXEntAppId() == null) {
            return null;
        }
        Integer n = this.objPSWXEntAppLock;
        synchronized (n) {
            if (this.pswxentapp != null && DataTypeHelper.compare((int)25, (Object)this.getPSWXEntAppId(), (Object)this.pswxentapp.getPSWXEntAppId()) != 0L) {
                this.pswxentapp = null;
            }
            if (this.pswxentapp == null) {
                PSWXEntApp pSWXEntApp = new PSWXEntApp();
                pSWXEntApp.setPSWXEntAppId(this.getPSWXEntAppId());
                PSWXEntAppService pSWXEntAppService = (PSWXEntAppService)ServiceGlobal.getService(PSWXEntAppService.class, (SessionFactory)this.getSessionFactory());
                pSWXEntAppService.autoGet(pSWXEntApp);
                this.pswxentapp = pSWXEntApp;
            }
            return this.pswxentapp;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSWFDE> getPSWFDEs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFDEs();
        }
        if (this.getPSWorkflowId() == null) {
            return null;
        }
        PSWFDEService pSWFDEService = (PSWFDEService)ServiceGlobal.getService(PSWFDEService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSWFDEsLock;
        synchronized (n) {
            if (this.pswfdes == null) {
                this.pswfdes = pSWFDEService.selectByPSWF(this);
            }
            return this.pswfdes;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSWFVersion> getPSWFVersions() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFVersions();
        }
        if (this.getPSWorkflowId() == null) {
            return null;
        }
        PSWFVersionService pSWFVersionService = (PSWFVersionService)ServiceGlobal.getService(PSWFVersionService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSWFVersionsLock;
        synchronized (n) {
            if (this.pswfversions == null) {
                this.pswfversions = pSWFVersionService.selectByPSWF(this);
            }
            return this.pswfversions;
        }
    }

    private PSWorkflowBase getProxyEntity() {
        return this.proxyPSWorkflowBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSWorkflowBase = null;
        if (iDataObject != null && iDataObject instanceof PSWorkflowBase) {
            this.proxyPSWorkflowBase = (PSWorkflowBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWorkflowService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ACTIONMOBPSDEVIEWID, 0);
        fieldIndexMap.put(FIELD_ACTIONMOBPSDEVIEWNAME, 1);
        fieldIndexMap.put(FIELD_ACTIONPSDEVIEWID, 2);
        fieldIndexMap.put(FIELD_ACTIONPSDEVIEWNAME, 3);
        fieldIndexMap.put(FIELD_CODENAME, 4);
        fieldIndexMap.put(FIELD_CREATEDATE, 5);
        fieldIndexMap.put(FIELD_CREATEMAN, 6);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 7);
        fieldIndexMap.put(FIELD_EDITABLEWFSTEP, 8);
        fieldIndexMap.put(FIELD_ENABLE, 9);
        fieldIndexMap.put(FIELD_ENABLEDYNASYS, 10);
        fieldIndexMap.put(FIELD_ENABLEDYNAVIEW, 11);
        fieldIndexMap.put(FIELD_ENABLEMOB, 12);
        fieldIndexMap.put(FIELD_EXTCNTSTATES, 13);
        fieldIndexMap.put(FIELD_LOCKFLAG, 14);
        fieldIndexMap.put(FIELD_MEMO, 15);
        fieldIndexMap.put(FIELD_MOBWFEDITVIEWTYPE, 16);
        fieldIndexMap.put(FIELD_MODCOLOR, 17);
        fieldIndexMap.put(FIELD_NAMEPSLANRESID, 18);
        fieldIndexMap.put(FIELD_NAMEPSLANRESNAME, 19);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 20);
        fieldIndexMap.put(FIELD_PSMODULEID, 21);
        fieldIndexMap.put(FIELD_PSMODULENAME, 22);
        fieldIndexMap.put(FIELD_PSSYSREQITEMID, 23);
        fieldIndexMap.put(FIELD_PSSYSREQITEMNAME, 24);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 25);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 26);
        fieldIndexMap.put(FIELD_PSSYSWFCATID, 27);
        fieldIndexMap.put(FIELD_PSSYSWFCATNAME, 28);
        fieldIndexMap.put(FIELD_PSWFDESCNT, 29);
        fieldIndexMap.put(FIELD_PSWFVERSIONSCNT, 30);
        fieldIndexMap.put(FIELD_PSWORKFLOWID, 31);
        fieldIndexMap.put(FIELD_PSWORKFLOWNAME, 32);
        fieldIndexMap.put(FIELD_PSWXACCOUNTID, 33);
        fieldIndexMap.put(FIELD_PSWXACCOUNTNAME, 34);
        fieldIndexMap.put(FIELD_PSWXENTAPPID, 35);
        fieldIndexMap.put(FIELD_PSWXENTAPPNAME, 36);
        fieldIndexMap.put(FIELD_REMINDPSSYSMSGTEMPLID, 37);
        fieldIndexMap.put(FIELD_REMINDPSSYSMSGTEMPLNAME, 38);
        fieldIndexMap.put(FIELD_REMOTEENGINEFLAG, 39);
        fieldIndexMap.put(FIELD_STARTMOBPSDEVIEWID, 40);
        fieldIndexMap.put(FIELD_STARTMOBPSDEVIEWNAME, 41);
        fieldIndexMap.put(FIELD_STARTPSDEVIEWID, 42);
        fieldIndexMap.put(FIELD_STARTPSDEVIEWNAME, 43);
        fieldIndexMap.put(FIELD_STATECODELISTID, 44);
        fieldIndexMap.put(FIELD_STATECODELISTNAME, 45);
        fieldIndexMap.put(FIELD_TODOTASK, 46);
        fieldIndexMap.put(FIELD_UPDATEDATE, 47);
        fieldIndexMap.put(FIELD_UPDATEMAN, 48);
        fieldIndexMap.put(FIELD_USERCAT, 49);
        fieldIndexMap.put(FIELD_USERTAG, 50);
        fieldIndexMap.put(FIELD_USERTAG2, 51);
        fieldIndexMap.put(FIELD_USERTAG3, 52);
        fieldIndexMap.put(FIELD_USERTAG4, 53);
        fieldIndexMap.put(FIELD_VALIDFLAG, 54);
        fieldIndexMap.put(FIELD_WFCANCELVALUE, 55);
        fieldIndexMap.put(FIELD_WFCANCELVALUETEXT, 56);
        fieldIndexMap.put(FIELD_WFEDITVIEWTYPE, 57);
        fieldIndexMap.put(FIELD_WFENGINETYPE, 58);
        fieldIndexMap.put(FIELD_WFERRORVALUE, 59);
        fieldIndexMap.put(FIELD_WFERRORVALUETEXT, 60);
        fieldIndexMap.put(FIELD_WFFINISHVALUE, 61);
        fieldIndexMap.put(FIELD_WFFINISHVALUETEXT, 62);
        fieldIndexMap.put(FIELD_WFPROXYMODE, 63);
        fieldIndexMap.put(FIELD_WFSN, 64);
        fieldIndexMap.put(FIELD_WFSTATEVALUE, 65);
        fieldIndexMap.put(FIELD_WFSTEPCODELISTID, 66);
        fieldIndexMap.put(FIELD_WFSTEPCODELISTNAME, 67);
        fieldIndexMap.put(FIELD_WFTAG, 68);
        fieldIndexMap.put(FIELD_WFTAG2, 69);
        fieldIndexMap.put(FIELD_WFTAG3, 70);
        fieldIndexMap.put(FIELD_WFTAG4, 71);
        fieldIndexMap.put(FIELD_WFTYPE, 72);
    }
}

