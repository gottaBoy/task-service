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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService;
import net.ibizsys.pscore.srv.wfdesign.entity.PSSysWFCat;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWorkflow;
import net.ibizsys.pscore.srv.wfdesign.service.PSSysWFCatService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWorkflowService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSWFDEBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSWFDEBase.class);
    public static final String FIELD_ACTIONMOBPSDEVIEWID = "ACTIONMOBPSDEVIEWID";
    public static final String FIELD_ACTIONMOBPSDEVIEWNAME = "ACTIONMOBPSDEVIEWNAME";
    public static final String FIELD_ACTIONPSDEVIEWID = "ACTIONPSDEVIEWID";
    public static final String FIELD_ACTIONPSDEVIEWNAME = "ACTIONPSDEVIEWNAME";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMCODE = "CUSTOMCODE";
    public static final String FIELD_CUSTOMMODE = "CUSTOMMODE";
    public static final String FIELD_DEFAULTMODE = "DEFAULTMODE";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_EDITABLEWFSTEP = "EDITABLEWFSTEP";
    public static final String FIELD_EDITVIEWURI = "EDITVIEWURI";
    public static final String FIELD_ENABLE = "ENABLE";
    public static final String FIELD_EXTCNTSTATES = "EXTCNTSTATES";
    public static final String FIELD_FINISHPSDEACTIONID = "FINISHPSDEACTIONID";
    public static final String FIELD_FINISHPSDEACTIONNAME = "FINISHPSDEACTIONNAME";
    public static final String FIELD_INITPSDEACTIONID = "INITPSDEACTIONID";
    public static final String FIELD_INITPSDEACTIONNAME = "INITPSDEACTIONNAME";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MOBEDITVIEWURI = "MOBEDITVIEWURI";
    public static final String FIELD_MOBPROXYDATA2PSDEVIEWID = "MOBPROXYDATA2PSDEVIEWID";
    public static final String FIELD_MOBPROXYDATA2PSDEVIEWNAME = "MOBPROXYDATA2PSDEVIEWNAME";
    public static final String FIELD_MOBPROXYDATAPSDEVIEWID = "MOBPROXYDATAPSDEVIEWID";
    public static final String FIELD_MOBPROXYDATAPSDEVIEWNAME = "MOBPROXYDATAPSDEVIEWNAME";
    public static final String FIELD_MYWFDATA = "MYWFDATA";
    public static final String FIELD_MYWFDATAPSLANRESID = "MYWFDATAPSLANRESID";
    public static final String FIELD_MYWFDATAPSLANRESNAME = "MYWFDATAPSLANRESNAME";
    public static final String FIELD_MYWFWORK = "MYWFWORK";
    public static final String FIELD_MYWFWORKPSLANRESID = "MYWFWORKPSLANRESID";
    public static final String FIELD_MYWFWORKPSLANRESNAME = "MYWFWORKPSLANRESNAME";
    public static final String FIELD_PROXYDATA2PSDEVIEWID = "PROXYDATA2PSDEVIEWID";
    public static final String FIELD_PROXYDATA2PSDEVIEWNAME = "PROXYDATA2PSDEVIEWNAME";
    public static final String FIELD_PROXYDATAPSDEFID = "PROXYDATAPSDEFID";
    public static final String FIELD_PROXYDATAPSDEFNAME = "PROXYDATAPSDEFNAME";
    public static final String FIELD_PROXYDATAPSDEVIEWID = "PROXYDATAPSDEVIEWID";
    public static final String FIELD_PROXYDATAPSDEVIEWNAME = "PROXYDATAPSDEVIEWNAME";
    public static final String FIELD_PROXYMODULEPSDEFID = "PROXYMODULEPSDEFID";
    public static final String FIELD_PROXYMODULEPSDEFNAME = "PROXYMODULEPSDEFNAME";
    public static final String FIELD_PROXYWFPSDEFID = "PROXYWFPSDEFID";
    public static final String FIELD_PROXYWFPSDEFNAME = "PROXYWFPSDEFNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDEVIEWBASESCNT = "PSDEVIEWBASESCNT";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String FIELD_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSWFCATID = "PSSYSWFCATID";
    public static final String FIELD_PSSYSWFCATNAME = "PSSYSWFCATNAME";
    public static final String FIELD_PSWFDEID = "PSWFDEID";
    public static final String FIELD_PSWFDENAME = "PSWFDENAME";
    public static final String FIELD_PSWFID = "PSWFID";
    public static final String FIELD_PSWFNAME = "PSWFNAME";
    public static final String FIELD_PWFINSTPSDEFID = "PWFINSTPSDEFID";
    public static final String FIELD_PWFINSTPSDEFNAME = "PWFINSTPSDEFNAME";
    public static final String FIELD_STARTMOBPSDEVIEWID = "STARTMOBPSDEVIEWID";
    public static final String FIELD_STARTMOBPSDEVIEWNAME = "STARTMOBPSDEVIEWNAME";
    public static final String FIELD_STARTPSDEVIEWID = "STARTPSDEVIEWID";
    public static final String FIELD_STARTPSDEVIEWNAME = "STARTPSDEVIEWNAME";
    public static final String FIELD_STATEPSDEFID = "STATEPSDEFID";
    public static final String FIELD_STATEPSDEFNAME = "STATEPSDEFNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERSTART = "USERSTART";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    public static final String FIELD_WFACTORPSDEFID = "WFACTORPSDEFID";
    public static final String FIELD_WFACTORPSDEFNAME = "WFACTORPSDEFNAME";
    public static final String FIELD_WFCATCODE = "WFCATCODE";
    public static final String FIELD_WFCODENAME = "WFCODENAME";
    public static final String FIELD_WFIDPSDEFID = "WFIDPSDEFID";
    public static final String FIELD_WFIDPSDEFNAME = "WFIDPSDEFNAME";
    public static final String FIELD_WFINSTPSDEFID = "WFINSTPSDEFID";
    public static final String FIELD_WFINSTPSDEFNAME = "WFINSTPSDEFNAME";
    public static final String FIELD_WFMODE = "WFMODE";
    public static final String FIELD_WFPROXYMODE = "WFPROXYMODE";
    public static final String FIELD_WFRETPSDEFID = "WFRETPSDEFID";
    public static final String FIELD_WFRETPSDEFNAME = "WFRETPSDEFNAME";
    public static final String FIELD_WFSTATEPSDEFID = "WFSTATEPSDEFID";
    public static final String FIELD_WFSTATEPSDEFNAME = "WFSTATEPSDEFNAME";
    public static final String FIELD_WFSTEPPSDEFID = "WFSTEPPSDEFID";
    public static final String FIELD_WFSTEPPSDEFNAME = "WFSTEPPSDEFNAME";
    public static final String FIELD_WFVERPSDEFID = "WFVERPSDEFID";
    public static final String FIELD_WFVERPSDEFNAME = "WFVERPSDEFNAME";
    private static final int INDEX_ACTIONMOBPSDEVIEWID = 0;
    private static final int INDEX_ACTIONMOBPSDEVIEWNAME = 1;
    private static final int INDEX_ACTIONPSDEVIEWID = 2;
    private static final int INDEX_ACTIONPSDEVIEWNAME = 3;
    private static final int INDEX_CODENAME = 4;
    private static final int INDEX_CREATEDATE = 5;
    private static final int INDEX_CREATEMAN = 6;
    private static final int INDEX_CUSTOMCODE = 7;
    private static final int INDEX_CUSTOMMODE = 8;
    private static final int INDEX_DEFAULTMODE = 9;
    private static final int INDEX_DYNAMODELFLAG = 10;
    private static final int INDEX_EDITABLEWFSTEP = 11;
    private static final int INDEX_EDITVIEWURI = 12;
    private static final int INDEX_ENABLE = 13;
    private static final int INDEX_EXTCNTSTATES = 14;
    private static final int INDEX_FINISHPSDEACTIONID = 15;
    private static final int INDEX_FINISHPSDEACTIONNAME = 16;
    private static final int INDEX_INITPSDEACTIONID = 17;
    private static final int INDEX_INITPSDEACTIONNAME = 18;
    private static final int INDEX_LOCKFLAG = 19;
    private static final int INDEX_MEMO = 20;
    private static final int INDEX_MOBEDITVIEWURI = 21;
    private static final int INDEX_MOBPROXYDATA2PSDEVIEWID = 22;
    private static final int INDEX_MOBPROXYDATA2PSDEVIEWNAME = 23;
    private static final int INDEX_MOBPROXYDATAPSDEVIEWID = 24;
    private static final int INDEX_MOBPROXYDATAPSDEVIEWNAME = 25;
    private static final int INDEX_MYWFDATA = 26;
    private static final int INDEX_MYWFDATAPSLANRESID = 27;
    private static final int INDEX_MYWFDATAPSLANRESNAME = 28;
    private static final int INDEX_MYWFWORK = 29;
    private static final int INDEX_MYWFWORKPSLANRESID = 30;
    private static final int INDEX_MYWFWORKPSLANRESNAME = 31;
    private static final int INDEX_PROXYDATA2PSDEVIEWID = 32;
    private static final int INDEX_PROXYDATA2PSDEVIEWNAME = 33;
    private static final int INDEX_PROXYDATAPSDEFID = 34;
    private static final int INDEX_PROXYDATAPSDEFNAME = 35;
    private static final int INDEX_PROXYDATAPSDEVIEWID = 36;
    private static final int INDEX_PROXYDATAPSDEVIEWNAME = 37;
    private static final int INDEX_PROXYMODULEPSDEFID = 38;
    private static final int INDEX_PROXYMODULEPSDEFNAME = 39;
    private static final int INDEX_PROXYWFPSDEFID = 40;
    private static final int INDEX_PROXYWFPSDEFNAME = 41;
    private static final int INDEX_PSDEID = 42;
    private static final int INDEX_PSDENAME = 43;
    private static final int INDEX_PSDEVIEWBASESCNT = 44;
    private static final int INDEX_PSDYNAINSTID = 45;
    private static final int INDEX_PSSYSSFPLUGINID = 46;
    private static final int INDEX_PSSYSSFPLUGINNAME = 47;
    private static final int INDEX_PSSYSTEMID = 48;
    private static final int INDEX_PSSYSWFCATID = 49;
    private static final int INDEX_PSSYSWFCATNAME = 50;
    private static final int INDEX_PSWFDEID = 51;
    private static final int INDEX_PSWFDENAME = 52;
    private static final int INDEX_PSWFID = 53;
    private static final int INDEX_PSWFNAME = 54;
    private static final int INDEX_PWFINSTPSDEFID = 55;
    private static final int INDEX_PWFINSTPSDEFNAME = 56;
    private static final int INDEX_STARTMOBPSDEVIEWID = 57;
    private static final int INDEX_STARTMOBPSDEVIEWNAME = 58;
    private static final int INDEX_STARTPSDEVIEWID = 59;
    private static final int INDEX_STARTPSDEVIEWNAME = 60;
    private static final int INDEX_STATEPSDEFID = 61;
    private static final int INDEX_STATEPSDEFNAME = 62;
    private static final int INDEX_UPDATEDATE = 63;
    private static final int INDEX_UPDATEMAN = 64;
    private static final int INDEX_USERCAT = 65;
    private static final int INDEX_USERSTART = 66;
    private static final int INDEX_USERTAG = 67;
    private static final int INDEX_USERTAG2 = 68;
    private static final int INDEX_USERTAG3 = 69;
    private static final int INDEX_USERTAG4 = 70;
    private static final int INDEX_VALIDFLAG = 71;
    private static final int INDEX_WFACTORPSDEFID = 72;
    private static final int INDEX_WFACTORPSDEFNAME = 73;
    private static final int INDEX_WFCATCODE = 74;
    private static final int INDEX_WFCODENAME = 75;
    private static final int INDEX_WFIDPSDEFID = 76;
    private static final int INDEX_WFIDPSDEFNAME = 77;
    private static final int INDEX_WFINSTPSDEFID = 78;
    private static final int INDEX_WFINSTPSDEFNAME = 79;
    private static final int INDEX_WFMODE = 80;
    private static final int INDEX_WFPROXYMODE = 81;
    private static final int INDEX_WFRETPSDEFID = 82;
    private static final int INDEX_WFRETPSDEFNAME = 83;
    private static final int INDEX_WFSTATEPSDEFID = 84;
    private static final int INDEX_WFSTATEPSDEFNAME = 85;
    private static final int INDEX_WFSTEPPSDEFID = 86;
    private static final int INDEX_WFSTEPPSDEFNAME = 87;
    private static final int INDEX_WFVERPSDEFID = 88;
    private static final int INDEX_WFVERPSDEFNAME = 89;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSWFDEBase proxyPSWFDEBase = null;
    private boolean actionmobpsdeviewidDirtyFlag = false;
    private boolean actionmobpsdeviewnameDirtyFlag = false;
    private boolean actionpsdeviewidDirtyFlag = false;
    private boolean actionpsdeviewnameDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customcodeDirtyFlag = false;
    private boolean custommodeDirtyFlag = false;
    private boolean defaultmodeDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean editablewfstepDirtyFlag = false;
    private boolean editviewuriDirtyFlag = false;
    private boolean enableDirtyFlag = false;
    private boolean extcntstatesDirtyFlag = false;
    private boolean finishpsdeactionidDirtyFlag = false;
    private boolean finishpsdeactionnameDirtyFlag = false;
    private boolean initpsdeactionidDirtyFlag = false;
    private boolean initpsdeactionnameDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean mobeditviewuriDirtyFlag = false;
    private boolean mobproxydata2psdeviewidDirtyFlag = false;
    private boolean mobproxydata2psdeviewnameDirtyFlag = false;
    private boolean mobproxydatapsdeviewidDirtyFlag = false;
    private boolean mobproxydatapsdeviewnameDirtyFlag = false;
    private boolean mywfdataDirtyFlag = false;
    private boolean mywfdatapslanresidDirtyFlag = false;
    private boolean mywfdatapslanresnameDirtyFlag = false;
    private boolean mywfworkDirtyFlag = false;
    private boolean mywfworkpslanresidDirtyFlag = false;
    private boolean mywfworkpslanresnameDirtyFlag = false;
    private boolean proxydata2psdeviewidDirtyFlag = false;
    private boolean proxydata2psdeviewnameDirtyFlag = false;
    private boolean proxydatapsdefidDirtyFlag = false;
    private boolean proxydatapsdefnameDirtyFlag = false;
    private boolean proxydatapsdeviewidDirtyFlag = false;
    private boolean proxydatapsdeviewnameDirtyFlag = false;
    private boolean proxymodulepsdefidDirtyFlag = false;
    private boolean proxymodulepsdefnameDirtyFlag = false;
    private boolean proxywfpsdefidDirtyFlag = false;
    private boolean proxywfpsdefnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psdeviewbasescntDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean pssyssfpluginidDirtyFlag = false;
    private boolean pssyssfpluginnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssyswfcatidDirtyFlag = false;
    private boolean pssyswfcatnameDirtyFlag = false;
    private boolean pswfdeidDirtyFlag = false;
    private boolean pswfdenameDirtyFlag = false;
    private boolean pswfidDirtyFlag = false;
    private boolean pswfnameDirtyFlag = false;
    private boolean pwfinstpsdefidDirtyFlag = false;
    private boolean pwfinstpsdefnameDirtyFlag = false;
    private boolean startmobpsdeviewidDirtyFlag = false;
    private boolean startmobpsdeviewnameDirtyFlag = false;
    private boolean startpsdeviewidDirtyFlag = false;
    private boolean startpsdeviewnameDirtyFlag = false;
    private boolean statepsdefidDirtyFlag = false;
    private boolean statepsdefnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean userstartDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    private boolean wfactorpsdefidDirtyFlag = false;
    private boolean wfactorpsdefnameDirtyFlag = false;
    private boolean wfcatcodeDirtyFlag = false;
    private boolean wfcodenameDirtyFlag = false;
    private boolean wfidpsdefidDirtyFlag = false;
    private boolean wfidpsdefnameDirtyFlag = false;
    private boolean wfinstpsdefidDirtyFlag = false;
    private boolean wfinstpsdefnameDirtyFlag = false;
    private boolean wfmodeDirtyFlag = false;
    private boolean wfproxymodeDirtyFlag = false;
    private boolean wfretpsdefidDirtyFlag = false;
    private boolean wfretpsdefnameDirtyFlag = false;
    private boolean wfstatepsdefidDirtyFlag = false;
    private boolean wfstatepsdefnameDirtyFlag = false;
    private boolean wfsteppsdefidDirtyFlag = false;
    private boolean wfsteppsdefnameDirtyFlag = false;
    private boolean wfverpsdefidDirtyFlag = false;
    private boolean wfverpsdefnameDirtyFlag = false;
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
    @Column(name="customcode")
    private String customcode;
    @Column(name="custommode")
    private Integer custommode;
    @Column(name="defaultmode")
    private Integer defaultmode;
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="editablewfstep")
    private String editablewfstep;
    @Column(name="editviewuri")
    private String editviewuri;
    @Column(name="enable")
    private Integer enable;
    @Column(name="extcntstates")
    private String extcntstates;
    @Column(name="finishpsdeactionid")
    private String finishpsdeactionid;
    @Column(name="finishpsdeactionname")
    private String finishpsdeactionname;
    @Column(name="initpsdeactionid")
    private String initpsdeactionid;
    @Column(name="initpsdeactionname")
    private String initpsdeactionname;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="memo")
    private String memo;
    @Column(name="mobeditviewuri")
    private String mobeditviewuri;
    @Column(name="mobproxydata2psdeviewid")
    private String mobproxydata2psdeviewid;
    @Column(name="mobproxydata2psdeviewname")
    private String mobproxydata2psdeviewname;
    @Column(name="mobproxydatapsdeviewid")
    private String mobproxydatapsdeviewid;
    @Column(name="mobproxydatapsdeviewname")
    private String mobproxydatapsdeviewname;
    @Column(name="mywfdata")
    private String mywfdata;
    @Column(name="mywfdatapslanresid")
    private String mywfdatapslanresid;
    @Column(name="mywfdatapslanresname")
    private String mywfdatapslanresname;
    @Column(name="mywfwork")
    private String mywfwork;
    @Column(name="mywfworkpslanresid")
    private String mywfworkpslanresid;
    @Column(name="mywfworkpslanresname")
    private String mywfworkpslanresname;
    @Column(name="proxydata2psdeviewid")
    private String proxydata2psdeviewid;
    @Column(name="proxydata2psdeviewname")
    private String proxydata2psdeviewname;
    @Column(name="proxydatapsdefid")
    private String proxydatapsdefid;
    @Column(name="proxydatapsdefname")
    private String proxydatapsdefname;
    @Column(name="proxydatapsdeviewid")
    private String proxydatapsdeviewid;
    @Column(name="proxydatapsdeviewname")
    private String proxydatapsdeviewname;
    @Column(name="proxymodulepsdefid")
    private String proxymodulepsdefid;
    @Column(name="proxymodulepsdefname")
    private String proxymodulepsdefname;
    @Column(name="proxywfpsdefid")
    private String proxywfpsdefid;
    @Column(name="proxywfpsdefname")
    private String proxywfpsdefname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psdeviewbasescnt")
    private Integer psdeviewbasescnt;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="pssyssfpluginid")
    private String pssyssfpluginid;
    @Column(name="pssyssfpluginname")
    private String pssyssfpluginname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssyswfcatid")
    private String pssyswfcatid;
    @Column(name="pssyswfcatname")
    private String pssyswfcatname;
    @Column(name="pswfdeid")
    private String pswfdeid;
    @Column(name="pswfdename")
    private String pswfdename;
    @Column(name="pswfid")
    private String pswfid;
    @Column(name="pswfname")
    private String pswfname;
    @Column(name="pwfinstpsdefid")
    private String pwfinstpsdefid;
    @Column(name="pwfinstpsdefname")
    private String pwfinstpsdefname;
    @Column(name="startmobpsdeviewid")
    private String startmobpsdeviewid;
    @Column(name="startmobpsdeviewname")
    private String startmobpsdeviewname;
    @Column(name="startpsdeviewid")
    private String startpsdeviewid;
    @Column(name="startpsdeviewname")
    private String startpsdeviewname;
    @Column(name="statepsdefid")
    private String statepsdefid;
    @Column(name="statepsdefname")
    private String statepsdefname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usercat")
    private String usercat;
    @Column(name="userstart")
    private Integer userstart;
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
    @Column(name="wfactorpsdefid")
    private String wfactorpsdefid;
    @Column(name="wfactorpsdefname")
    private String wfactorpsdefname;
    @Column(name="wfcatcode")
    private String wfcatcode;
    @Column(name="wfcodename")
    private String wfcodename;
    @Column(name="wfidpsdefid")
    private String wfidpsdefid;
    @Column(name="wfidpsdefname")
    private String wfidpsdefname;
    @Column(name="wfinstpsdefid")
    private String wfinstpsdefid;
    @Column(name="wfinstpsdefname")
    private String wfinstpsdefname;
    @Column(name="wfmode")
    private String wfmode;
    @Column(name="wfproxymode")
    private Integer wfproxymode;
    @Column(name="wfretpsdefid")
    private String wfretpsdefid;
    @Column(name="wfretpsdefname")
    private String wfretpsdefname;
    @Column(name="wfstatepsdefid")
    private String wfstatepsdefid;
    @Column(name="wfstatepsdefname")
    private String wfstatepsdefname;
    @Column(name="wfsteppsdefid")
    private String wfsteppsdefid;
    @Column(name="wfsteppsdefname")
    private String wfsteppsdefname;
    @Column(name="wfverpsdefid")
    private String wfverpsdefid;
    @Column(name="wfverpsdefname")
    private String wfverpsdefname;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objFinishPSDEActionLock = new Integer(1);
    private PSDEAction finishpsdeaction = null;
    private Integer objInitPSDEActionLock = new Integer(1);
    private PSDEAction initpsdeaction = null;
    private Integer objProxyDataPSDEFLock = new Integer(1);
    private PSDEField proxydatapsdef = null;
    private Integer objProxyModulePSDEFLock = new Integer(1);
    private PSDEField proxymodulepsdef = null;
    private Integer objProxyWFPSDEFLock = new Integer(1);
    private PSDEField proxywfpsdef = null;
    private Integer objPWFInstPSDEFLock = new Integer(1);
    private PSDEField pwfinstpsdef = null;
    private Integer objStatePSDEFLock = new Integer(1);
    private PSDEField statepsdef = null;
    private Integer objWFActorPSDEFLock = new Integer(1);
    private PSDEField wfactorpsdef = null;
    private Integer objWFIdPSDEFLock = new Integer(1);
    private PSDEField wfidpsdef = null;
    private Integer objWFInstPSDEFLock = new Integer(1);
    private PSDEField wfinstpsdef = null;
    private Integer objWFRetPSDEFLock = new Integer(1);
    private PSDEField wfretpsdef = null;
    private Integer objWFStatePSDEFLock = new Integer(1);
    private PSDEField wfstatepsdef = null;
    private Integer objWFStepPSDEFLock = new Integer(1);
    private PSDEField wfsteppsdef = null;
    private Integer objWFVerPSDEFLock = new Integer(1);
    private PSDEField wfverpsdef = null;
    private Integer objActionMobPSDEViewLock = new Integer(1);
    private PSDEViewBase actionmobpsdeview = null;
    private Integer objActionPSDEViewLock = new Integer(1);
    private PSDEViewBase actionpsdeview = null;
    private Integer objMobProxyData2PSDEViewLock = new Integer(1);
    private PSDEViewBase mobproxydata2psdeview = null;
    private Integer objMobProxyDataPSDEViewLock = new Integer(1);
    private PSDEViewBase mobproxydatapsdeview = null;
    private Integer objProxyData2PSDEViewLock = new Integer(1);
    private PSDEViewBase proxydata2psdeview = null;
    private Integer objProxyDataPSDEViewLock = new Integer(1);
    private PSDEViewBase proxydatapsdeview = null;
    private Integer objStartMobPSDEViewLock = new Integer(1);
    private PSDEViewBase startmobpsdeview = null;
    private Integer objStartPSDEViewLock = new Integer(1);
    private PSDEViewBase startpsdeview = null;
    private Integer objMyWFDataPSLanResLock = new Integer(1);
    private PSLanguageRes mywfdatapslanres = null;
    private Integer objMyWFWorkPSLanResLock = new Integer(1);
    private PSLanguageRes mywfworkpslanres = null;
    private Integer objPSSysSFPluginLock = new Integer(1);
    private PSSysSFPlugin pssyssfplugin = null;
    private Integer objPSSysWFCatLock = new Integer(1);
    private PSSysWFCat pssyswfcat = null;
    private Integer objPSWFLock = new Integer(1);
    private PSWorkflow pswf = null;
    private Integer objPSDEViewBasesLock = new Integer(1);
    private ArrayList<PSDEViewBase> psdeviewbases = null;

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

    public void setCustomMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomMode(n);
            return;
        }
        this.custommode = n;
        this.custommodeDirtyFlag = true;
    }

    public Integer getCustomMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomMode();
        }
        return this.custommode;
    }

    public boolean isCustomModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomModeDirty();
        }
        return this.custommodeDirtyFlag;
    }

    public void resetCustomMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomMode();
            return;
        }
        this.custommodeDirtyFlag = false;
        this.custommode = null;
    }

    public void setDefaultMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefaultMode(n);
            return;
        }
        this.defaultmode = n;
        this.defaultmodeDirtyFlag = true;
    }

    public Integer getDefaultMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefaultMode();
        }
        return this.defaultmode;
    }

    public boolean isDefaultModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefaultModeDirty();
        }
        return this.defaultmodeDirtyFlag;
    }

    public void resetDefaultMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefaultMode();
            return;
        }
        this.defaultmodeDirtyFlag = false;
        this.defaultmode = null;
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

    public void setEditViewUri(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEditViewUri(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.editviewuri = string;
        this.editviewuriDirtyFlag = true;
    }

    public String getEditViewUri() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEditViewUri();
        }
        return this.editviewuri;
    }

    public boolean isEditViewUriDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEditViewUriDirty();
        }
        return this.editviewuriDirtyFlag;
    }

    public void resetEditViewUri() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEditViewUri();
            return;
        }
        this.editviewuriDirtyFlag = false;
        this.editviewuri = null;
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

    public void setFinishPSDEActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFinishPSDEActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.finishpsdeactionid = string;
        this.finishpsdeactionidDirtyFlag = true;
    }

    public String getFinishPSDEActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFinishPSDEActionId();
        }
        return this.finishpsdeactionid;
    }

    public boolean isFinishPSDEActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFinishPSDEActionIdDirty();
        }
        return this.finishpsdeactionidDirtyFlag;
    }

    public void resetFinishPSDEActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFinishPSDEActionId();
            return;
        }
        this.finishpsdeactionidDirtyFlag = false;
        this.finishpsdeactionid = null;
    }

    public void setFinishPSDEActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFinishPSDEActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.finishpsdeactionname = string;
        this.finishpsdeactionnameDirtyFlag = true;
    }

    public String getFinishPSDEActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFinishPSDEActionName();
        }
        return this.finishpsdeactionname;
    }

    public boolean isFinishPSDEActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFinishPSDEActionNameDirty();
        }
        return this.finishpsdeactionnameDirtyFlag;
    }

    public void resetFinishPSDEActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFinishPSDEActionName();
            return;
        }
        this.finishpsdeactionnameDirtyFlag = false;
        this.finishpsdeactionname = null;
    }

    public void setInitPSDEActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInitPSDEActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.initpsdeactionid = string;
        this.initpsdeactionidDirtyFlag = true;
    }

    public String getInitPSDEActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInitPSDEActionId();
        }
        return this.initpsdeactionid;
    }

    public boolean isInitPSDEActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInitPSDEActionIdDirty();
        }
        return this.initpsdeactionidDirtyFlag;
    }

    public void resetInitPSDEActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInitPSDEActionId();
            return;
        }
        this.initpsdeactionidDirtyFlag = false;
        this.initpsdeactionid = null;
    }

    public void setInitPSDEActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInitPSDEActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.initpsdeactionname = string;
        this.initpsdeactionnameDirtyFlag = true;
    }

    public String getInitPSDEActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInitPSDEActionName();
        }
        return this.initpsdeactionname;
    }

    public boolean isInitPSDEActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInitPSDEActionNameDirty();
        }
        return this.initpsdeactionnameDirtyFlag;
    }

    public void resetInitPSDEActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInitPSDEActionName();
            return;
        }
        this.initpsdeactionnameDirtyFlag = false;
        this.initpsdeactionname = null;
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

    public void setMobEditViewUri(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobEditViewUri(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mobeditviewuri = string;
        this.mobeditviewuriDirtyFlag = true;
    }

    public String getMobEditViewUri() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobEditViewUri();
        }
        return this.mobeditviewuri;
    }

    public boolean isMobEditViewUriDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobEditViewUriDirty();
        }
        return this.mobeditviewuriDirtyFlag;
    }

    public void resetMobEditViewUri() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobEditViewUri();
            return;
        }
        this.mobeditviewuriDirtyFlag = false;
        this.mobeditviewuri = null;
    }

    public void setMobProxyData2PSDEViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobProxyData2PSDEViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mobproxydata2psdeviewid = string;
        this.mobproxydata2psdeviewidDirtyFlag = true;
    }

    public String getMobProxyData2PSDEViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobProxyData2PSDEViewId();
        }
        return this.mobproxydata2psdeviewid;
    }

    public boolean isMobProxyData2PSDEViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobProxyData2PSDEViewIdDirty();
        }
        return this.mobproxydata2psdeviewidDirtyFlag;
    }

    public void resetMobProxyData2PSDEViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobProxyData2PSDEViewId();
            return;
        }
        this.mobproxydata2psdeviewidDirtyFlag = false;
        this.mobproxydata2psdeviewid = null;
    }

    public void setMobProxyData2PSDEViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobProxyData2PSDEViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mobproxydata2psdeviewname = string;
        this.mobproxydata2psdeviewnameDirtyFlag = true;
    }

    public String getMobProxyData2PSDEViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobProxyData2PSDEViewName();
        }
        return this.mobproxydata2psdeviewname;
    }

    public boolean isMobProxyData2PSDEViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobProxyData2PSDEViewNameDirty();
        }
        return this.mobproxydata2psdeviewnameDirtyFlag;
    }

    public void resetMobProxyData2PSDEViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobProxyData2PSDEViewName();
            return;
        }
        this.mobproxydata2psdeviewnameDirtyFlag = false;
        this.mobproxydata2psdeviewname = null;
    }

    public void setMobProxyDataPSDEViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobProxyDataPSDEViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mobproxydatapsdeviewid = string;
        this.mobproxydatapsdeviewidDirtyFlag = true;
    }

    public String getMobProxyDataPSDEViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobProxyDataPSDEViewId();
        }
        return this.mobproxydatapsdeviewid;
    }

    public boolean isMobProxyDataPSDEViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobProxyDataPSDEViewIdDirty();
        }
        return this.mobproxydatapsdeviewidDirtyFlag;
    }

    public void resetMobProxyDataPSDEViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobProxyDataPSDEViewId();
            return;
        }
        this.mobproxydatapsdeviewidDirtyFlag = false;
        this.mobproxydatapsdeviewid = null;
    }

    public void setMobProxyDataPSDEViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobProxyDataPSDEViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mobproxydatapsdeviewname = string;
        this.mobproxydatapsdeviewnameDirtyFlag = true;
    }

    public String getMobProxyDataPSDEViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobProxyDataPSDEViewName();
        }
        return this.mobproxydatapsdeviewname;
    }

    public boolean isMobProxyDataPSDEViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobProxyDataPSDEViewNameDirty();
        }
        return this.mobproxydatapsdeviewnameDirtyFlag;
    }

    public void resetMobProxyDataPSDEViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobProxyDataPSDEViewName();
            return;
        }
        this.mobproxydatapsdeviewnameDirtyFlag = false;
        this.mobproxydatapsdeviewname = null;
    }

    public void setMyWFData(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMyWFData(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mywfdata = string;
        this.mywfdataDirtyFlag = true;
    }

    public String getMyWFData() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMyWFData();
        }
        return this.mywfdata;
    }

    public boolean isMyWFDataDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMyWFDataDirty();
        }
        return this.mywfdataDirtyFlag;
    }

    public void resetMyWFData() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMyWFData();
            return;
        }
        this.mywfdataDirtyFlag = false;
        this.mywfdata = null;
    }

    public void setMyWFDataPSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMyWFDataPSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mywfdatapslanresid = string;
        this.mywfdatapslanresidDirtyFlag = true;
    }

    public String getMyWFDataPSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMyWFDataPSLanResId();
        }
        return this.mywfdatapslanresid;
    }

    public boolean isMyWFDataPSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMyWFDataPSLanResIdDirty();
        }
        return this.mywfdatapslanresidDirtyFlag;
    }

    public void resetMyWFDataPSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMyWFDataPSLanResId();
            return;
        }
        this.mywfdatapslanresidDirtyFlag = false;
        this.mywfdatapslanresid = null;
    }

    public void setMyWFDataPSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMyWFDataPSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mywfdatapslanresname = string;
        this.mywfdatapslanresnameDirtyFlag = true;
    }

    public String getMyWFDataPSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMyWFDataPSLanResName();
        }
        return this.mywfdatapslanresname;
    }

    public boolean isMyWFDataPSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMyWFDataPSLanResNameDirty();
        }
        return this.mywfdatapslanresnameDirtyFlag;
    }

    public void resetMyWFDataPSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMyWFDataPSLanResName();
            return;
        }
        this.mywfdatapslanresnameDirtyFlag = false;
        this.mywfdatapslanresname = null;
    }

    public void setMyWFWork(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMyWFWork(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mywfwork = string;
        this.mywfworkDirtyFlag = true;
    }

    public String getMyWFWork() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMyWFWork();
        }
        return this.mywfwork;
    }

    public boolean isMyWFWorkDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMyWFWorkDirty();
        }
        return this.mywfworkDirtyFlag;
    }

    public void resetMyWFWork() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMyWFWork();
            return;
        }
        this.mywfworkDirtyFlag = false;
        this.mywfwork = null;
    }

    public void setMyWFWorkPSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMyWFWorkPSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mywfworkpslanresid = string;
        this.mywfworkpslanresidDirtyFlag = true;
    }

    public String getMyWFWorkPSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMyWFWorkPSLanResId();
        }
        return this.mywfworkpslanresid;
    }

    public boolean isMyWFWorkPSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMyWFWorkPSLanResIdDirty();
        }
        return this.mywfworkpslanresidDirtyFlag;
    }

    public void resetMyWFWorkPSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMyWFWorkPSLanResId();
            return;
        }
        this.mywfworkpslanresidDirtyFlag = false;
        this.mywfworkpslanresid = null;
    }

    public void setMyWFWorkPSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMyWFWorkPSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mywfworkpslanresname = string;
        this.mywfworkpslanresnameDirtyFlag = true;
    }

    public String getMyWFWorkPSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMyWFWorkPSLanResName();
        }
        return this.mywfworkpslanresname;
    }

    public boolean isMyWFWorkPSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMyWFWorkPSLanResNameDirty();
        }
        return this.mywfworkpslanresnameDirtyFlag;
    }

    public void resetMyWFWorkPSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMyWFWorkPSLanResName();
            return;
        }
        this.mywfworkpslanresnameDirtyFlag = false;
        this.mywfworkpslanresname = null;
    }

    public void setProxyData2PSDEViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setProxyData2PSDEViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.proxydata2psdeviewid = string;
        this.proxydata2psdeviewidDirtyFlag = true;
    }

    public String getProxyData2PSDEViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getProxyData2PSDEViewId();
        }
        return this.proxydata2psdeviewid;
    }

    public boolean isProxyData2PSDEViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isProxyData2PSDEViewIdDirty();
        }
        return this.proxydata2psdeviewidDirtyFlag;
    }

    public void resetProxyData2PSDEViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetProxyData2PSDEViewId();
            return;
        }
        this.proxydata2psdeviewidDirtyFlag = false;
        this.proxydata2psdeviewid = null;
    }

    public void setProxyData2PSDEViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setProxyData2PSDEViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.proxydata2psdeviewname = string;
        this.proxydata2psdeviewnameDirtyFlag = true;
    }

    public String getProxyData2PSDEViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getProxyData2PSDEViewName();
        }
        return this.proxydata2psdeviewname;
    }

    public boolean isProxyData2PSDEViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isProxyData2PSDEViewNameDirty();
        }
        return this.proxydata2psdeviewnameDirtyFlag;
    }

    public void resetProxyData2PSDEViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetProxyData2PSDEViewName();
            return;
        }
        this.proxydata2psdeviewnameDirtyFlag = false;
        this.proxydata2psdeviewname = null;
    }

    public void setProxyDataPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setProxyDataPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.proxydatapsdefid = string;
        this.proxydatapsdefidDirtyFlag = true;
    }

    public String getProxyDataPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getProxyDataPSDEFId();
        }
        return this.proxydatapsdefid;
    }

    public boolean isProxyDataPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isProxyDataPSDEFIdDirty();
        }
        return this.proxydatapsdefidDirtyFlag;
    }

    public void resetProxyDataPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetProxyDataPSDEFId();
            return;
        }
        this.proxydatapsdefidDirtyFlag = false;
        this.proxydatapsdefid = null;
    }

    public void setProxyDataPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setProxyDataPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.proxydatapsdefname = string;
        this.proxydatapsdefnameDirtyFlag = true;
    }

    public String getProxyDataPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getProxyDataPSDEFName();
        }
        return this.proxydatapsdefname;
    }

    public boolean isProxyDataPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isProxyDataPSDEFNameDirty();
        }
        return this.proxydatapsdefnameDirtyFlag;
    }

    public void resetProxyDataPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetProxyDataPSDEFName();
            return;
        }
        this.proxydatapsdefnameDirtyFlag = false;
        this.proxydatapsdefname = null;
    }

    public void setProxyDataPSDEViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setProxyDataPSDEViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.proxydatapsdeviewid = string;
        this.proxydatapsdeviewidDirtyFlag = true;
    }

    public String getProxyDataPSDEViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getProxyDataPSDEViewId();
        }
        return this.proxydatapsdeviewid;
    }

    public boolean isProxyDataPSDEViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isProxyDataPSDEViewIdDirty();
        }
        return this.proxydatapsdeviewidDirtyFlag;
    }

    public void resetProxyDataPSDEViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetProxyDataPSDEViewId();
            return;
        }
        this.proxydatapsdeviewidDirtyFlag = false;
        this.proxydatapsdeviewid = null;
    }

    public void setProxyDataPSDEViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setProxyDataPSDEViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.proxydatapsdeviewname = string;
        this.proxydatapsdeviewnameDirtyFlag = true;
    }

    public String getProxyDataPSDEViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getProxyDataPSDEViewName();
        }
        return this.proxydatapsdeviewname;
    }

    public boolean isProxyDataPSDEViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isProxyDataPSDEViewNameDirty();
        }
        return this.proxydatapsdeviewnameDirtyFlag;
    }

    public void resetProxyDataPSDEViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetProxyDataPSDEViewName();
            return;
        }
        this.proxydatapsdeviewnameDirtyFlag = false;
        this.proxydatapsdeviewname = null;
    }

    public void setProxyModulePSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setProxyModulePSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.proxymodulepsdefid = string;
        this.proxymodulepsdefidDirtyFlag = true;
    }

    public String getProxyModulePSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getProxyModulePSDEFId();
        }
        return this.proxymodulepsdefid;
    }

    public boolean isProxyModulePSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isProxyModulePSDEFIdDirty();
        }
        return this.proxymodulepsdefidDirtyFlag;
    }

    public void resetProxyModulePSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetProxyModulePSDEFId();
            return;
        }
        this.proxymodulepsdefidDirtyFlag = false;
        this.proxymodulepsdefid = null;
    }

    public void setProxyModulePSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setProxyModulePSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.proxymodulepsdefname = string;
        this.proxymodulepsdefnameDirtyFlag = true;
    }

    public String getProxyModulePSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getProxyModulePSDEFName();
        }
        return this.proxymodulepsdefname;
    }

    public boolean isProxyModulePSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isProxyModulePSDEFNameDirty();
        }
        return this.proxymodulepsdefnameDirtyFlag;
    }

    public void resetProxyModulePSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetProxyModulePSDEFName();
            return;
        }
        this.proxymodulepsdefnameDirtyFlag = false;
        this.proxymodulepsdefname = null;
    }

    public void setProxyWFPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setProxyWFPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.proxywfpsdefid = string;
        this.proxywfpsdefidDirtyFlag = true;
    }

    public String getProxyWFPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getProxyWFPSDEFId();
        }
        return this.proxywfpsdefid;
    }

    public boolean isProxyWFPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isProxyWFPSDEFIdDirty();
        }
        return this.proxywfpsdefidDirtyFlag;
    }

    public void resetProxyWFPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetProxyWFPSDEFId();
            return;
        }
        this.proxywfpsdefidDirtyFlag = false;
        this.proxywfpsdefid = null;
    }

    public void setProxyWFPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setProxyWFPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.proxywfpsdefname = string;
        this.proxywfpsdefnameDirtyFlag = true;
    }

    public String getProxyWFPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getProxyWFPSDEFName();
        }
        return this.proxywfpsdefname;
    }

    public boolean isProxyWFPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isProxyWFPSDEFNameDirty();
        }
        return this.proxywfpsdefnameDirtyFlag;
    }

    public void resetProxyWFPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetProxyWFPSDEFName();
            return;
        }
        this.proxywfpsdefnameDirtyFlag = false;
        this.proxywfpsdefname = null;
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

    public void setPSDEViewBasesCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewBasesCnt(n);
            return;
        }
        this.psdeviewbasescnt = n;
        this.psdeviewbasescntDirtyFlag = true;
    }

    public Integer getPSDEViewBasesCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewBasesCnt();
        }
        return this.psdeviewbasescnt;
    }

    public boolean isPSDEViewBasesCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewBasesCntDirty();
        }
        return this.psdeviewbasescntDirtyFlag;
    }

    public void resetPSDEViewBasesCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewBasesCnt();
            return;
        }
        this.psdeviewbasescntDirtyFlag = false;
        this.psdeviewbasescnt = null;
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

    public void setPSSysSFPluginId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFPluginId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssfpluginid = string;
        this.pssyssfpluginidDirtyFlag = true;
    }

    public String getPSSysSFPluginId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPluginId();
        }
        return this.pssyssfpluginid;
    }

    public boolean isPSSysSFPluginIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFPluginIdDirty();
        }
        return this.pssyssfpluginidDirtyFlag;
    }

    public void resetPSSysSFPluginId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFPluginId();
            return;
        }
        this.pssyssfpluginidDirtyFlag = false;
        this.pssyssfpluginid = null;
    }

    public void setPSSysSFPluginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFPluginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssfpluginname = string;
        this.pssyssfpluginnameDirtyFlag = true;
    }

    public String getPSSysSFPluginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPluginName();
        }
        return this.pssyssfpluginname;
    }

    public boolean isPSSysSFPluginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFPluginNameDirty();
        }
        return this.pssyssfpluginnameDirtyFlag;
    }

    public void resetPSSysSFPluginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFPluginName();
            return;
        }
        this.pssyssfpluginnameDirtyFlag = false;
        this.pssyssfpluginname = null;
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

    public void setPWFInstPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPWFInstPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pwfinstpsdefid = string;
        this.pwfinstpsdefidDirtyFlag = true;
    }

    public String getPWFInstPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPWFInstPSDEFId();
        }
        return this.pwfinstpsdefid;
    }

    public boolean isPWFInstPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPWFInstPSDEFIdDirty();
        }
        return this.pwfinstpsdefidDirtyFlag;
    }

    public void resetPWFInstPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPWFInstPSDEFId();
            return;
        }
        this.pwfinstpsdefidDirtyFlag = false;
        this.pwfinstpsdefid = null;
    }

    public void setPWFInstPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPWFInstPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pwfinstpsdefname = string;
        this.pwfinstpsdefnameDirtyFlag = true;
    }

    public String getPWFInstPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPWFInstPSDEFName();
        }
        return this.pwfinstpsdefname;
    }

    public boolean isPWFInstPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPWFInstPSDEFNameDirty();
        }
        return this.pwfinstpsdefnameDirtyFlag;
    }

    public void resetPWFInstPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPWFInstPSDEFName();
            return;
        }
        this.pwfinstpsdefnameDirtyFlag = false;
        this.pwfinstpsdefname = null;
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

    public void setStatePSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStatePSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.statepsdefid = string;
        this.statepsdefidDirtyFlag = true;
    }

    public String getStatePSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStatePSDEFId();
        }
        return this.statepsdefid;
    }

    public boolean isStatePSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStatePSDEFIdDirty();
        }
        return this.statepsdefidDirtyFlag;
    }

    public void resetStatePSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStatePSDEFId();
            return;
        }
        this.statepsdefidDirtyFlag = false;
        this.statepsdefid = null;
    }

    public void setStatePSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStatePSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.statepsdefname = string;
        this.statepsdefnameDirtyFlag = true;
    }

    public String getStatePSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStatePSDEFName();
        }
        return this.statepsdefname;
    }

    public boolean isStatePSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStatePSDEFNameDirty();
        }
        return this.statepsdefnameDirtyFlag;
    }

    public void resetStatePSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStatePSDEFName();
            return;
        }
        this.statepsdefnameDirtyFlag = false;
        this.statepsdefname = null;
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

    public void setUserStart(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserStart(n);
            return;
        }
        this.userstart = n;
        this.userstartDirtyFlag = true;
    }

    public Integer getUserStart() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserStart();
        }
        return this.userstart;
    }

    public boolean isUserStartDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserStartDirty();
        }
        return this.userstartDirtyFlag;
    }

    public void resetUserStart() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserStart();
            return;
        }
        this.userstartDirtyFlag = false;
        this.userstart = null;
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

    public void setWFActorPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFActorPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wfactorpsdefid = string;
        this.wfactorpsdefidDirtyFlag = true;
    }

    public String getWFActorPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFActorPSDEFId();
        }
        return this.wfactorpsdefid;
    }

    public boolean isWFActorPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFActorPSDEFIdDirty();
        }
        return this.wfactorpsdefidDirtyFlag;
    }

    public void resetWFActorPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFActorPSDEFId();
            return;
        }
        this.wfactorpsdefidDirtyFlag = false;
        this.wfactorpsdefid = null;
    }

    public void setWFActorPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFActorPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wfactorpsdefname = string;
        this.wfactorpsdefnameDirtyFlag = true;
    }

    public String getWFActorPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFActorPSDEFName();
        }
        return this.wfactorpsdefname;
    }

    public boolean isWFActorPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFActorPSDEFNameDirty();
        }
        return this.wfactorpsdefnameDirtyFlag;
    }

    public void resetWFActorPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFActorPSDEFName();
            return;
        }
        this.wfactorpsdefnameDirtyFlag = false;
        this.wfactorpsdefname = null;
    }

    public void setWFCatCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFCatCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wfcatcode = string;
        this.wfcatcodeDirtyFlag = true;
    }

    public String getWFCatCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFCatCode();
        }
        return this.wfcatcode;
    }

    public boolean isWFCatCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFCatCodeDirty();
        }
        return this.wfcatcodeDirtyFlag;
    }

    public void resetWFCatCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFCatCode();
            return;
        }
        this.wfcatcodeDirtyFlag = false;
        this.wfcatcode = null;
    }

    public void setWFCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wfcodename = string;
        this.wfcodenameDirtyFlag = true;
    }

    public String getWFCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFCodeName();
        }
        return this.wfcodename;
    }

    public boolean isWFCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFCodeNameDirty();
        }
        return this.wfcodenameDirtyFlag;
    }

    public void resetWFCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFCodeName();
            return;
        }
        this.wfcodenameDirtyFlag = false;
        this.wfcodename = null;
    }

    public void setWFIdPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFIdPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wfidpsdefid = string;
        this.wfidpsdefidDirtyFlag = true;
    }

    public String getWFIdPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFIdPSDEFId();
        }
        return this.wfidpsdefid;
    }

    public boolean isWFIdPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFIdPSDEFIdDirty();
        }
        return this.wfidpsdefidDirtyFlag;
    }

    public void resetWFIdPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFIdPSDEFId();
            return;
        }
        this.wfidpsdefidDirtyFlag = false;
        this.wfidpsdefid = null;
    }

    public void setWFIdPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFIdPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wfidpsdefname = string;
        this.wfidpsdefnameDirtyFlag = true;
    }

    public String getWFIdPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFIdPSDEFName();
        }
        return this.wfidpsdefname;
    }

    public boolean isWFIdPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFIdPSDEFNameDirty();
        }
        return this.wfidpsdefnameDirtyFlag;
    }

    public void resetWFIdPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFIdPSDEFName();
            return;
        }
        this.wfidpsdefnameDirtyFlag = false;
        this.wfidpsdefname = null;
    }

    public void setWFInstPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFInstPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wfinstpsdefid = string;
        this.wfinstpsdefidDirtyFlag = true;
    }

    public String getWFInstPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFInstPSDEFId();
        }
        return this.wfinstpsdefid;
    }

    public boolean isWFInstPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFInstPSDEFIdDirty();
        }
        return this.wfinstpsdefidDirtyFlag;
    }

    public void resetWFInstPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFInstPSDEFId();
            return;
        }
        this.wfinstpsdefidDirtyFlag = false;
        this.wfinstpsdefid = null;
    }

    public void setWFInstPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFInstPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wfinstpsdefname = string;
        this.wfinstpsdefnameDirtyFlag = true;
    }

    public String getWFInstPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFInstPSDEFName();
        }
        return this.wfinstpsdefname;
    }

    public boolean isWFInstPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFInstPSDEFNameDirty();
        }
        return this.wfinstpsdefnameDirtyFlag;
    }

    public void resetWFInstPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFInstPSDEFName();
            return;
        }
        this.wfinstpsdefnameDirtyFlag = false;
        this.wfinstpsdefname = null;
    }

    public void setWFMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wfmode = string;
        this.wfmodeDirtyFlag = true;
    }

    public String getWFMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFMode();
        }
        return this.wfmode;
    }

    public boolean isWFModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFModeDirty();
        }
        return this.wfmodeDirtyFlag;
    }

    public void resetWFMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFMode();
            return;
        }
        this.wfmodeDirtyFlag = false;
        this.wfmode = null;
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

    public void setWFRetPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFRetPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wfretpsdefid = string;
        this.wfretpsdefidDirtyFlag = true;
    }

    public String getWFRetPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFRetPSDEFId();
        }
        return this.wfretpsdefid;
    }

    public boolean isWFRetPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFRetPSDEFIdDirty();
        }
        return this.wfretpsdefidDirtyFlag;
    }

    public void resetWFRetPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFRetPSDEFId();
            return;
        }
        this.wfretpsdefidDirtyFlag = false;
        this.wfretpsdefid = null;
    }

    public void setWFRetPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFRetPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wfretpsdefname = string;
        this.wfretpsdefnameDirtyFlag = true;
    }

    public String getWFRetPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFRetPSDEFName();
        }
        return this.wfretpsdefname;
    }

    public boolean isWFRetPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFRetPSDEFNameDirty();
        }
        return this.wfretpsdefnameDirtyFlag;
    }

    public void resetWFRetPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFRetPSDEFName();
            return;
        }
        this.wfretpsdefnameDirtyFlag = false;
        this.wfretpsdefname = null;
    }

    public void setWFStatePSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFStatePSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wfstatepsdefid = string;
        this.wfstatepsdefidDirtyFlag = true;
    }

    public String getWFStatePSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFStatePSDEFId();
        }
        return this.wfstatepsdefid;
    }

    public boolean isWFStatePSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFStatePSDEFIdDirty();
        }
        return this.wfstatepsdefidDirtyFlag;
    }

    public void resetWFStatePSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFStatePSDEFId();
            return;
        }
        this.wfstatepsdefidDirtyFlag = false;
        this.wfstatepsdefid = null;
    }

    public void setWFStatePSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFStatePSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wfstatepsdefname = string;
        this.wfstatepsdefnameDirtyFlag = true;
    }

    public String getWFStatePSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFStatePSDEFName();
        }
        return this.wfstatepsdefname;
    }

    public boolean isWFStatePSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFStatePSDEFNameDirty();
        }
        return this.wfstatepsdefnameDirtyFlag;
    }

    public void resetWFStatePSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFStatePSDEFName();
            return;
        }
        this.wfstatepsdefnameDirtyFlag = false;
        this.wfstatepsdefname = null;
    }

    public void setWFStepPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFStepPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wfsteppsdefid = string;
        this.wfsteppsdefidDirtyFlag = true;
    }

    public String getWFStepPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFStepPSDEFId();
        }
        return this.wfsteppsdefid;
    }

    public boolean isWFStepPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFStepPSDEFIdDirty();
        }
        return this.wfsteppsdefidDirtyFlag;
    }

    public void resetWFStepPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFStepPSDEFId();
            return;
        }
        this.wfsteppsdefidDirtyFlag = false;
        this.wfsteppsdefid = null;
    }

    public void setWFStepPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFStepPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wfsteppsdefname = string;
        this.wfsteppsdefnameDirtyFlag = true;
    }

    public String getWFStepPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFStepPSDEFName();
        }
        return this.wfsteppsdefname;
    }

    public boolean isWFStepPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFStepPSDEFNameDirty();
        }
        return this.wfsteppsdefnameDirtyFlag;
    }

    public void resetWFStepPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFStepPSDEFName();
            return;
        }
        this.wfsteppsdefnameDirtyFlag = false;
        this.wfsteppsdefname = null;
    }

    public void setWFVerPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFVerPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wfverpsdefid = string;
        this.wfverpsdefidDirtyFlag = true;
    }

    public String getWFVerPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFVerPSDEFId();
        }
        return this.wfverpsdefid;
    }

    public boolean isWFVerPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFVerPSDEFIdDirty();
        }
        return this.wfverpsdefidDirtyFlag;
    }

    public void resetWFVerPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFVerPSDEFId();
            return;
        }
        this.wfverpsdefidDirtyFlag = false;
        this.wfverpsdefid = null;
    }

    public void setWFVerPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFVerPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wfverpsdefname = string;
        this.wfverpsdefnameDirtyFlag = true;
    }

    public String getWFVerPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFVerPSDEFName();
        }
        return this.wfverpsdefname;
    }

    public boolean isWFVerPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFVerPSDEFNameDirty();
        }
        return this.wfverpsdefnameDirtyFlag;
    }

    public void resetWFVerPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFVerPSDEFName();
            return;
        }
        this.wfverpsdefnameDirtyFlag = false;
        this.wfverpsdefname = null;
    }

    protected void onReset() {
        PSWFDEBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSWFDEBase pSWFDEBase) {
        pSWFDEBase.resetActionMobPSDEViewId();
        pSWFDEBase.resetActionMobPSDEViewName();
        pSWFDEBase.resetActionPSDEViewId();
        pSWFDEBase.resetActionPSDEViewName();
        pSWFDEBase.resetCodeName();
        pSWFDEBase.resetCreateDate();
        pSWFDEBase.resetCreateMan();
        pSWFDEBase.resetCustomCode();
        pSWFDEBase.resetCustomMode();
        pSWFDEBase.resetDefaultMode();
        pSWFDEBase.resetDynaModelFlag();
        pSWFDEBase.resetEditableWFStep();
        pSWFDEBase.resetEditViewUri();
        pSWFDEBase.resetEnable();
        pSWFDEBase.resetExtCntStates();
        pSWFDEBase.resetFinishPSDEActionId();
        pSWFDEBase.resetFinishPSDEActionName();
        pSWFDEBase.resetInitPSDEActionId();
        pSWFDEBase.resetInitPSDEActionName();
        pSWFDEBase.resetLockFlag();
        pSWFDEBase.resetMemo();
        pSWFDEBase.resetMobEditViewUri();
        pSWFDEBase.resetMobProxyData2PSDEViewId();
        pSWFDEBase.resetMobProxyData2PSDEViewName();
        pSWFDEBase.resetMobProxyDataPSDEViewId();
        pSWFDEBase.resetMobProxyDataPSDEViewName();
        pSWFDEBase.resetMyWFData();
        pSWFDEBase.resetMyWFDataPSLanResId();
        pSWFDEBase.resetMyWFDataPSLanResName();
        pSWFDEBase.resetMyWFWork();
        pSWFDEBase.resetMyWFWorkPSLanResId();
        pSWFDEBase.resetMyWFWorkPSLanResName();
        pSWFDEBase.resetProxyData2PSDEViewId();
        pSWFDEBase.resetProxyData2PSDEViewName();
        pSWFDEBase.resetProxyDataPSDEFId();
        pSWFDEBase.resetProxyDataPSDEFName();
        pSWFDEBase.resetProxyDataPSDEViewId();
        pSWFDEBase.resetProxyDataPSDEViewName();
        pSWFDEBase.resetProxyModulePSDEFId();
        pSWFDEBase.resetProxyModulePSDEFName();
        pSWFDEBase.resetProxyWFPSDEFId();
        pSWFDEBase.resetProxyWFPSDEFName();
        pSWFDEBase.resetPSDEId();
        pSWFDEBase.resetPSDEName();
        pSWFDEBase.resetPSDEViewBasesCnt();
        pSWFDEBase.resetPSDynaInstId();
        pSWFDEBase.resetPSSysSFPluginId();
        pSWFDEBase.resetPSSysSFPluginName();
        pSWFDEBase.resetPSSystemId();
        pSWFDEBase.resetPSSysWFCatId();
        pSWFDEBase.resetPSSysWFCatName();
        pSWFDEBase.resetPSWFDEId();
        pSWFDEBase.resetPSWFDEName();
        pSWFDEBase.resetPSWFId();
        pSWFDEBase.resetPSWFName();
        pSWFDEBase.resetPWFInstPSDEFId();
        pSWFDEBase.resetPWFInstPSDEFName();
        pSWFDEBase.resetStartMobPSDEViewId();
        pSWFDEBase.resetStartMobPSDEViewName();
        pSWFDEBase.resetStartPSDEViewId();
        pSWFDEBase.resetStartPSDEViewName();
        pSWFDEBase.resetStatePSDEFId();
        pSWFDEBase.resetStatePSDEFName();
        pSWFDEBase.resetUpdateDate();
        pSWFDEBase.resetUpdateMan();
        pSWFDEBase.resetUserCat();
        pSWFDEBase.resetUserStart();
        pSWFDEBase.resetUserTag();
        pSWFDEBase.resetUserTag2();
        pSWFDEBase.resetUserTag3();
        pSWFDEBase.resetUserTag4();
        pSWFDEBase.resetValidFlag();
        pSWFDEBase.resetWFActorPSDEFId();
        pSWFDEBase.resetWFActorPSDEFName();
        pSWFDEBase.resetWFCatCode();
        pSWFDEBase.resetWFCodeName();
        pSWFDEBase.resetWFIdPSDEFId();
        pSWFDEBase.resetWFIdPSDEFName();
        pSWFDEBase.resetWFInstPSDEFId();
        pSWFDEBase.resetWFInstPSDEFName();
        pSWFDEBase.resetWFMode();
        pSWFDEBase.resetWFProxyMode();
        pSWFDEBase.resetWFRetPSDEFId();
        pSWFDEBase.resetWFRetPSDEFName();
        pSWFDEBase.resetWFStatePSDEFId();
        pSWFDEBase.resetWFStatePSDEFName();
        pSWFDEBase.resetWFStepPSDEFId();
        pSWFDEBase.resetWFStepPSDEFName();
        pSWFDEBase.resetWFVerPSDEFId();
        pSWFDEBase.resetWFVerPSDEFName();
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
        if (!bl || this.isCustomCodeDirty()) {
            hashMap.put(FIELD_CUSTOMCODE, this.getCustomCode());
        }
        if (!bl || this.isCustomModeDirty()) {
            hashMap.put(FIELD_CUSTOMMODE, this.getCustomMode());
        }
        if (!bl || this.isDefaultModeDirty()) {
            hashMap.put(FIELD_DEFAULTMODE, this.getDefaultMode());
        }
        if (!bl || this.isDynaModelFlagDirty()) {
            hashMap.put(FIELD_DYNAMODELFLAG, this.getDynaModelFlag());
        }
        if (!bl || this.isEditableWFStepDirty()) {
            hashMap.put(FIELD_EDITABLEWFSTEP, this.getEditableWFStep());
        }
        if (!bl || this.isEditViewUriDirty()) {
            hashMap.put(FIELD_EDITVIEWURI, this.getEditViewUri());
        }
        if (!bl || this.isEnableDirty()) {
            hashMap.put(FIELD_ENABLE, this.getEnable());
        }
        if (!bl || this.isExtCntStatesDirty()) {
            hashMap.put(FIELD_EXTCNTSTATES, this.getExtCntStates());
        }
        if (!bl || this.isFinishPSDEActionIdDirty()) {
            hashMap.put(FIELD_FINISHPSDEACTIONID, this.getFinishPSDEActionId());
        }
        if (!bl || this.isFinishPSDEActionNameDirty()) {
            hashMap.put(FIELD_FINISHPSDEACTIONNAME, this.getFinishPSDEActionName());
        }
        if (!bl || this.isInitPSDEActionIdDirty()) {
            hashMap.put(FIELD_INITPSDEACTIONID, this.getInitPSDEActionId());
        }
        if (!bl || this.isInitPSDEActionNameDirty()) {
            hashMap.put(FIELD_INITPSDEACTIONNAME, this.getInitPSDEActionName());
        }
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMobEditViewUriDirty()) {
            hashMap.put(FIELD_MOBEDITVIEWURI, this.getMobEditViewUri());
        }
        if (!bl || this.isMobProxyData2PSDEViewIdDirty()) {
            hashMap.put(FIELD_MOBPROXYDATA2PSDEVIEWID, this.getMobProxyData2PSDEViewId());
        }
        if (!bl || this.isMobProxyData2PSDEViewNameDirty()) {
            hashMap.put(FIELD_MOBPROXYDATA2PSDEVIEWNAME, this.getMobProxyData2PSDEViewName());
        }
        if (!bl || this.isMobProxyDataPSDEViewIdDirty()) {
            hashMap.put(FIELD_MOBPROXYDATAPSDEVIEWID, this.getMobProxyDataPSDEViewId());
        }
        if (!bl || this.isMobProxyDataPSDEViewNameDirty()) {
            hashMap.put(FIELD_MOBPROXYDATAPSDEVIEWNAME, this.getMobProxyDataPSDEViewName());
        }
        if (!bl || this.isMyWFDataDirty()) {
            hashMap.put(FIELD_MYWFDATA, this.getMyWFData());
        }
        if (!bl || this.isMyWFDataPSLanResIdDirty()) {
            hashMap.put(FIELD_MYWFDATAPSLANRESID, this.getMyWFDataPSLanResId());
        }
        if (!bl || this.isMyWFDataPSLanResNameDirty()) {
            hashMap.put(FIELD_MYWFDATAPSLANRESNAME, this.getMyWFDataPSLanResName());
        }
        if (!bl || this.isMyWFWorkDirty()) {
            hashMap.put(FIELD_MYWFWORK, this.getMyWFWork());
        }
        if (!bl || this.isMyWFWorkPSLanResIdDirty()) {
            hashMap.put(FIELD_MYWFWORKPSLANRESID, this.getMyWFWorkPSLanResId());
        }
        if (!bl || this.isMyWFWorkPSLanResNameDirty()) {
            hashMap.put(FIELD_MYWFWORKPSLANRESNAME, this.getMyWFWorkPSLanResName());
        }
        if (!bl || this.isProxyData2PSDEViewIdDirty()) {
            hashMap.put(FIELD_PROXYDATA2PSDEVIEWID, this.getProxyData2PSDEViewId());
        }
        if (!bl || this.isProxyData2PSDEViewNameDirty()) {
            hashMap.put(FIELD_PROXYDATA2PSDEVIEWNAME, this.getProxyData2PSDEViewName());
        }
        if (!bl || this.isProxyDataPSDEFIdDirty()) {
            hashMap.put(FIELD_PROXYDATAPSDEFID, this.getProxyDataPSDEFId());
        }
        if (!bl || this.isProxyDataPSDEFNameDirty()) {
            hashMap.put(FIELD_PROXYDATAPSDEFNAME, this.getProxyDataPSDEFName());
        }
        if (!bl || this.isProxyDataPSDEViewIdDirty()) {
            hashMap.put(FIELD_PROXYDATAPSDEVIEWID, this.getProxyDataPSDEViewId());
        }
        if (!bl || this.isProxyDataPSDEViewNameDirty()) {
            hashMap.put(FIELD_PROXYDATAPSDEVIEWNAME, this.getProxyDataPSDEViewName());
        }
        if (!bl || this.isProxyModulePSDEFIdDirty()) {
            hashMap.put(FIELD_PROXYMODULEPSDEFID, this.getProxyModulePSDEFId());
        }
        if (!bl || this.isProxyModulePSDEFNameDirty()) {
            hashMap.put(FIELD_PROXYMODULEPSDEFNAME, this.getProxyModulePSDEFName());
        }
        if (!bl || this.isProxyWFPSDEFIdDirty()) {
            hashMap.put(FIELD_PROXYWFPSDEFID, this.getProxyWFPSDEFId());
        }
        if (!bl || this.isProxyWFPSDEFNameDirty()) {
            hashMap.put(FIELD_PROXYWFPSDEFNAME, this.getProxyWFPSDEFName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSDEViewBasesCntDirty()) {
            hashMap.put(FIELD_PSDEVIEWBASESCNT, this.getPSDEViewBasesCnt());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSSysSFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINID, this.getPSSysSFPluginId());
        }
        if (!bl || this.isPSSysSFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINNAME, this.getPSSysSFPluginName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSysWFCatIdDirty()) {
            hashMap.put(FIELD_PSSYSWFCATID, this.getPSSysWFCatId());
        }
        if (!bl || this.isPSSysWFCatNameDirty()) {
            hashMap.put(FIELD_PSSYSWFCATNAME, this.getPSSysWFCatName());
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
        if (!bl || this.isPWFInstPSDEFIdDirty()) {
            hashMap.put(FIELD_PWFINSTPSDEFID, this.getPWFInstPSDEFId());
        }
        if (!bl || this.isPWFInstPSDEFNameDirty()) {
            hashMap.put(FIELD_PWFINSTPSDEFNAME, this.getPWFInstPSDEFName());
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
        if (!bl || this.isStatePSDEFIdDirty()) {
            hashMap.put(FIELD_STATEPSDEFID, this.getStatePSDEFId());
        }
        if (!bl || this.isStatePSDEFNameDirty()) {
            hashMap.put(FIELD_STATEPSDEFNAME, this.getStatePSDEFName());
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
        if (!bl || this.isUserStartDirty()) {
            hashMap.put(FIELD_USERSTART, this.getUserStart());
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
        if (!bl || this.isWFActorPSDEFIdDirty()) {
            hashMap.put(FIELD_WFACTORPSDEFID, this.getWFActorPSDEFId());
        }
        if (!bl || this.isWFActorPSDEFNameDirty()) {
            hashMap.put(FIELD_WFACTORPSDEFNAME, this.getWFActorPSDEFName());
        }
        if (!bl || this.isWFCatCodeDirty()) {
            hashMap.put(FIELD_WFCATCODE, this.getWFCatCode());
        }
        if (!bl || this.isWFCodeNameDirty()) {
            hashMap.put(FIELD_WFCODENAME, this.getWFCodeName());
        }
        if (!bl || this.isWFIdPSDEFIdDirty()) {
            hashMap.put(FIELD_WFIDPSDEFID, this.getWFIdPSDEFId());
        }
        if (!bl || this.isWFIdPSDEFNameDirty()) {
            hashMap.put(FIELD_WFIDPSDEFNAME, this.getWFIdPSDEFName());
        }
        if (!bl || this.isWFInstPSDEFIdDirty()) {
            hashMap.put(FIELD_WFINSTPSDEFID, this.getWFInstPSDEFId());
        }
        if (!bl || this.isWFInstPSDEFNameDirty()) {
            hashMap.put(FIELD_WFINSTPSDEFNAME, this.getWFInstPSDEFName());
        }
        if (!bl || this.isWFModeDirty()) {
            hashMap.put(FIELD_WFMODE, this.getWFMode());
        }
        if (!bl || this.isWFProxyModeDirty()) {
            hashMap.put(FIELD_WFPROXYMODE, this.getWFProxyMode());
        }
        if (!bl || this.isWFRetPSDEFIdDirty()) {
            hashMap.put(FIELD_WFRETPSDEFID, this.getWFRetPSDEFId());
        }
        if (!bl || this.isWFRetPSDEFNameDirty()) {
            hashMap.put(FIELD_WFRETPSDEFNAME, this.getWFRetPSDEFName());
        }
        if (!bl || this.isWFStatePSDEFIdDirty()) {
            hashMap.put(FIELD_WFSTATEPSDEFID, this.getWFStatePSDEFId());
        }
        if (!bl || this.isWFStatePSDEFNameDirty()) {
            hashMap.put(FIELD_WFSTATEPSDEFNAME, this.getWFStatePSDEFName());
        }
        if (!bl || this.isWFStepPSDEFIdDirty()) {
            hashMap.put(FIELD_WFSTEPPSDEFID, this.getWFStepPSDEFId());
        }
        if (!bl || this.isWFStepPSDEFNameDirty()) {
            hashMap.put(FIELD_WFSTEPPSDEFNAME, this.getWFStepPSDEFName());
        }
        if (!bl || this.isWFVerPSDEFIdDirty()) {
            hashMap.put(FIELD_WFVERPSDEFID, this.getWFVerPSDEFId());
        }
        if (!bl || this.isWFVerPSDEFNameDirty()) {
            hashMap.put(FIELD_WFVERPSDEFNAME, this.getWFVerPSDEFName());
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
        return PSWFDEBase.get(this, n);
    }

    private static Object get(PSWFDEBase pSWFDEBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWFDEBase.getActionMobPSDEViewId();
            }
            case 1: {
                return pSWFDEBase.getActionMobPSDEViewName();
            }
            case 2: {
                return pSWFDEBase.getActionPSDEViewId();
            }
            case 3: {
                return pSWFDEBase.getActionPSDEViewName();
            }
            case 4: {
                return pSWFDEBase.getCodeName();
            }
            case 5: {
                return pSWFDEBase.getCreateDate();
            }
            case 6: {
                return pSWFDEBase.getCreateMan();
            }
            case 7: {
                return pSWFDEBase.getCustomCode();
            }
            case 8: {
                return pSWFDEBase.getCustomMode();
            }
            case 9: {
                return pSWFDEBase.getDefaultMode();
            }
            case 10: {
                return pSWFDEBase.getDynaModelFlag();
            }
            case 11: {
                return pSWFDEBase.getEditableWFStep();
            }
            case 12: {
                return pSWFDEBase.getEditViewUri();
            }
            case 13: {
                return pSWFDEBase.getEnable();
            }
            case 14: {
                return pSWFDEBase.getExtCntStates();
            }
            case 15: {
                return pSWFDEBase.getFinishPSDEActionId();
            }
            case 16: {
                return pSWFDEBase.getFinishPSDEActionName();
            }
            case 17: {
                return pSWFDEBase.getInitPSDEActionId();
            }
            case 18: {
                return pSWFDEBase.getInitPSDEActionName();
            }
            case 19: {
                return pSWFDEBase.getLockFlag();
            }
            case 20: {
                return pSWFDEBase.getMemo();
            }
            case 21: {
                return pSWFDEBase.getMobEditViewUri();
            }
            case 22: {
                return pSWFDEBase.getMobProxyData2PSDEViewId();
            }
            case 23: {
                return pSWFDEBase.getMobProxyData2PSDEViewName();
            }
            case 24: {
                return pSWFDEBase.getMobProxyDataPSDEViewId();
            }
            case 25: {
                return pSWFDEBase.getMobProxyDataPSDEViewName();
            }
            case 26: {
                return pSWFDEBase.getMyWFData();
            }
            case 27: {
                return pSWFDEBase.getMyWFDataPSLanResId();
            }
            case 28: {
                return pSWFDEBase.getMyWFDataPSLanResName();
            }
            case 29: {
                return pSWFDEBase.getMyWFWork();
            }
            case 30: {
                return pSWFDEBase.getMyWFWorkPSLanResId();
            }
            case 31: {
                return pSWFDEBase.getMyWFWorkPSLanResName();
            }
            case 32: {
                return pSWFDEBase.getProxyData2PSDEViewId();
            }
            case 33: {
                return pSWFDEBase.getProxyData2PSDEViewName();
            }
            case 34: {
                return pSWFDEBase.getProxyDataPSDEFId();
            }
            case 35: {
                return pSWFDEBase.getProxyDataPSDEFName();
            }
            case 36: {
                return pSWFDEBase.getProxyDataPSDEViewId();
            }
            case 37: {
                return pSWFDEBase.getProxyDataPSDEViewName();
            }
            case 38: {
                return pSWFDEBase.getProxyModulePSDEFId();
            }
            case 39: {
                return pSWFDEBase.getProxyModulePSDEFName();
            }
            case 40: {
                return pSWFDEBase.getProxyWFPSDEFId();
            }
            case 41: {
                return pSWFDEBase.getProxyWFPSDEFName();
            }
            case 42: {
                return pSWFDEBase.getPSDEId();
            }
            case 43: {
                return pSWFDEBase.getPSDEName();
            }
            case 44: {
                return pSWFDEBase.getPSDEViewBasesCnt();
            }
            case 45: {
                return pSWFDEBase.getPSDynaInstId();
            }
            case 46: {
                return pSWFDEBase.getPSSysSFPluginId();
            }
            case 47: {
                return pSWFDEBase.getPSSysSFPluginName();
            }
            case 48: {
                return pSWFDEBase.getPSSystemId();
            }
            case 49: {
                return pSWFDEBase.getPSSysWFCatId();
            }
            case 50: {
                return pSWFDEBase.getPSSysWFCatName();
            }
            case 51: {
                return pSWFDEBase.getPSWFDEId();
            }
            case 52: {
                return pSWFDEBase.getPSWFDEName();
            }
            case 53: {
                return pSWFDEBase.getPSWFId();
            }
            case 54: {
                return pSWFDEBase.getPSWFName();
            }
            case 55: {
                return pSWFDEBase.getPWFInstPSDEFId();
            }
            case 56: {
                return pSWFDEBase.getPWFInstPSDEFName();
            }
            case 57: {
                return pSWFDEBase.getStartMobPSDEViewId();
            }
            case 58: {
                return pSWFDEBase.getStartMobPSDEViewName();
            }
            case 59: {
                return pSWFDEBase.getStartPSDEViewId();
            }
            case 60: {
                return pSWFDEBase.getStartPSDEViewName();
            }
            case 61: {
                return pSWFDEBase.getStatePSDEFId();
            }
            case 62: {
                return pSWFDEBase.getStatePSDEFName();
            }
            case 63: {
                return pSWFDEBase.getUpdateDate();
            }
            case 64: {
                return pSWFDEBase.getUpdateMan();
            }
            case 65: {
                return pSWFDEBase.getUserCat();
            }
            case 66: {
                return pSWFDEBase.getUserStart();
            }
            case 67: {
                return pSWFDEBase.getUserTag();
            }
            case 68: {
                return pSWFDEBase.getUserTag2();
            }
            case 69: {
                return pSWFDEBase.getUserTag3();
            }
            case 70: {
                return pSWFDEBase.getUserTag4();
            }
            case 71: {
                return pSWFDEBase.getValidFlag();
            }
            case 72: {
                return pSWFDEBase.getWFActorPSDEFId();
            }
            case 73: {
                return pSWFDEBase.getWFActorPSDEFName();
            }
            case 74: {
                return pSWFDEBase.getWFCatCode();
            }
            case 75: {
                return pSWFDEBase.getWFCodeName();
            }
            case 76: {
                return pSWFDEBase.getWFIdPSDEFId();
            }
            case 77: {
                return pSWFDEBase.getWFIdPSDEFName();
            }
            case 78: {
                return pSWFDEBase.getWFInstPSDEFId();
            }
            case 79: {
                return pSWFDEBase.getWFInstPSDEFName();
            }
            case 80: {
                return pSWFDEBase.getWFMode();
            }
            case 81: {
                return pSWFDEBase.getWFProxyMode();
            }
            case 82: {
                return pSWFDEBase.getWFRetPSDEFId();
            }
            case 83: {
                return pSWFDEBase.getWFRetPSDEFName();
            }
            case 84: {
                return pSWFDEBase.getWFStatePSDEFId();
            }
            case 85: {
                return pSWFDEBase.getWFStatePSDEFName();
            }
            case 86: {
                return pSWFDEBase.getWFStepPSDEFId();
            }
            case 87: {
                return pSWFDEBase.getWFStepPSDEFName();
            }
            case 88: {
                return pSWFDEBase.getWFVerPSDEFId();
            }
            case 89: {
                return pSWFDEBase.getWFVerPSDEFName();
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
        PSWFDEBase.set(this, n, object);
    }

    private static void set(PSWFDEBase pSWFDEBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSWFDEBase.setActionMobPSDEViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSWFDEBase.setActionMobPSDEViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSWFDEBase.setActionPSDEViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSWFDEBase.setActionPSDEViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSWFDEBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSWFDEBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 6: {
                pSWFDEBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSWFDEBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSWFDEBase.setCustomMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSWFDEBase.setDefaultMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSWFDEBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSWFDEBase.setEditableWFStep(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSWFDEBase.setEditViewUri(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSWFDEBase.setEnable(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSWFDEBase.setExtCntStates(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSWFDEBase.setFinishPSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSWFDEBase.setFinishPSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSWFDEBase.setInitPSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSWFDEBase.setInitPSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSWFDEBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 20: {
                pSWFDEBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSWFDEBase.setMobEditViewUri(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSWFDEBase.setMobProxyData2PSDEViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSWFDEBase.setMobProxyData2PSDEViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSWFDEBase.setMobProxyDataPSDEViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSWFDEBase.setMobProxyDataPSDEViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSWFDEBase.setMyWFData(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSWFDEBase.setMyWFDataPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSWFDEBase.setMyWFDataPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSWFDEBase.setMyWFWork(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSWFDEBase.setMyWFWorkPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSWFDEBase.setMyWFWorkPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSWFDEBase.setProxyData2PSDEViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSWFDEBase.setProxyData2PSDEViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSWFDEBase.setProxyDataPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSWFDEBase.setProxyDataPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSWFDEBase.setProxyDataPSDEViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSWFDEBase.setProxyDataPSDEViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSWFDEBase.setProxyModulePSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSWFDEBase.setProxyModulePSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSWFDEBase.setProxyWFPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSWFDEBase.setProxyWFPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSWFDEBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSWFDEBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSWFDEBase.setPSDEViewBasesCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 45: {
                pSWFDEBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSWFDEBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSWFDEBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSWFDEBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSWFDEBase.setPSSysWFCatId(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSWFDEBase.setPSSysWFCatName(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSWFDEBase.setPSWFDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSWFDEBase.setPSWFDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 53: {
                pSWFDEBase.setPSWFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 54: {
                pSWFDEBase.setPSWFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 55: {
                pSWFDEBase.setPWFInstPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 56: {
                pSWFDEBase.setPWFInstPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 57: {
                pSWFDEBase.setStartMobPSDEViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 58: {
                pSWFDEBase.setStartMobPSDEViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 59: {
                pSWFDEBase.setStartPSDEViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 60: {
                pSWFDEBase.setStartPSDEViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 61: {
                pSWFDEBase.setStatePSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 62: {
                pSWFDEBase.setStatePSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 63: {
                pSWFDEBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 64: {
                pSWFDEBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 65: {
                pSWFDEBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 66: {
                pSWFDEBase.setUserStart(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 67: {
                pSWFDEBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 68: {
                pSWFDEBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 69: {
                pSWFDEBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 70: {
                pSWFDEBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 71: {
                pSWFDEBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 72: {
                pSWFDEBase.setWFActorPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 73: {
                pSWFDEBase.setWFActorPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 74: {
                pSWFDEBase.setWFCatCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 75: {
                pSWFDEBase.setWFCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 76: {
                pSWFDEBase.setWFIdPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 77: {
                pSWFDEBase.setWFIdPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 78: {
                pSWFDEBase.setWFInstPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 79: {
                pSWFDEBase.setWFInstPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 80: {
                pSWFDEBase.setWFMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 81: {
                pSWFDEBase.setWFProxyMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 82: {
                pSWFDEBase.setWFRetPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 83: {
                pSWFDEBase.setWFRetPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 84: {
                pSWFDEBase.setWFStatePSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 85: {
                pSWFDEBase.setWFStatePSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 86: {
                pSWFDEBase.setWFStepPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 87: {
                pSWFDEBase.setWFStepPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 88: {
                pSWFDEBase.setWFVerPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 89: {
                pSWFDEBase.setWFVerPSDEFName(DataObject.getStringValue((Object)object));
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
        return PSWFDEBase.isNull(this, n);
    }

    private static boolean isNull(PSWFDEBase pSWFDEBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWFDEBase.getActionMobPSDEViewId() == null;
            }
            case 1: {
                return pSWFDEBase.getActionMobPSDEViewName() == null;
            }
            case 2: {
                return pSWFDEBase.getActionPSDEViewId() == null;
            }
            case 3: {
                return pSWFDEBase.getActionPSDEViewName() == null;
            }
            case 4: {
                return pSWFDEBase.getCodeName() == null;
            }
            case 5: {
                return pSWFDEBase.getCreateDate() == null;
            }
            case 6: {
                return pSWFDEBase.getCreateMan() == null;
            }
            case 7: {
                return pSWFDEBase.getCustomCode() == null;
            }
            case 8: {
                return pSWFDEBase.getCustomMode() == null;
            }
            case 9: {
                return pSWFDEBase.getDefaultMode() == null;
            }
            case 10: {
                return pSWFDEBase.getDynaModelFlag() == null;
            }
            case 11: {
                return pSWFDEBase.getEditableWFStep() == null;
            }
            case 12: {
                return pSWFDEBase.getEditViewUri() == null;
            }
            case 13: {
                return pSWFDEBase.getEnable() == null;
            }
            case 14: {
                return pSWFDEBase.getExtCntStates() == null;
            }
            case 15: {
                return pSWFDEBase.getFinishPSDEActionId() == null;
            }
            case 16: {
                return pSWFDEBase.getFinishPSDEActionName() == null;
            }
            case 17: {
                return pSWFDEBase.getInitPSDEActionId() == null;
            }
            case 18: {
                return pSWFDEBase.getInitPSDEActionName() == null;
            }
            case 19: {
                return pSWFDEBase.getLockFlag() == null;
            }
            case 20: {
                return pSWFDEBase.getMemo() == null;
            }
            case 21: {
                return pSWFDEBase.getMobEditViewUri() == null;
            }
            case 22: {
                return pSWFDEBase.getMobProxyData2PSDEViewId() == null;
            }
            case 23: {
                return pSWFDEBase.getMobProxyData2PSDEViewName() == null;
            }
            case 24: {
                return pSWFDEBase.getMobProxyDataPSDEViewId() == null;
            }
            case 25: {
                return pSWFDEBase.getMobProxyDataPSDEViewName() == null;
            }
            case 26: {
                return pSWFDEBase.getMyWFData() == null;
            }
            case 27: {
                return pSWFDEBase.getMyWFDataPSLanResId() == null;
            }
            case 28: {
                return pSWFDEBase.getMyWFDataPSLanResName() == null;
            }
            case 29: {
                return pSWFDEBase.getMyWFWork() == null;
            }
            case 30: {
                return pSWFDEBase.getMyWFWorkPSLanResId() == null;
            }
            case 31: {
                return pSWFDEBase.getMyWFWorkPSLanResName() == null;
            }
            case 32: {
                return pSWFDEBase.getProxyData2PSDEViewId() == null;
            }
            case 33: {
                return pSWFDEBase.getProxyData2PSDEViewName() == null;
            }
            case 34: {
                return pSWFDEBase.getProxyDataPSDEFId() == null;
            }
            case 35: {
                return pSWFDEBase.getProxyDataPSDEFName() == null;
            }
            case 36: {
                return pSWFDEBase.getProxyDataPSDEViewId() == null;
            }
            case 37: {
                return pSWFDEBase.getProxyDataPSDEViewName() == null;
            }
            case 38: {
                return pSWFDEBase.getProxyModulePSDEFId() == null;
            }
            case 39: {
                return pSWFDEBase.getProxyModulePSDEFName() == null;
            }
            case 40: {
                return pSWFDEBase.getProxyWFPSDEFId() == null;
            }
            case 41: {
                return pSWFDEBase.getProxyWFPSDEFName() == null;
            }
            case 42: {
                return pSWFDEBase.getPSDEId() == null;
            }
            case 43: {
                return pSWFDEBase.getPSDEName() == null;
            }
            case 44: {
                return pSWFDEBase.getPSDEViewBasesCnt() == null;
            }
            case 45: {
                return pSWFDEBase.getPSDynaInstId() == null;
            }
            case 46: {
                return pSWFDEBase.getPSSysSFPluginId() == null;
            }
            case 47: {
                return pSWFDEBase.getPSSysSFPluginName() == null;
            }
            case 48: {
                return pSWFDEBase.getPSSystemId() == null;
            }
            case 49: {
                return pSWFDEBase.getPSSysWFCatId() == null;
            }
            case 50: {
                return pSWFDEBase.getPSSysWFCatName() == null;
            }
            case 51: {
                return pSWFDEBase.getPSWFDEId() == null;
            }
            case 52: {
                return pSWFDEBase.getPSWFDEName() == null;
            }
            case 53: {
                return pSWFDEBase.getPSWFId() == null;
            }
            case 54: {
                return pSWFDEBase.getPSWFName() == null;
            }
            case 55: {
                return pSWFDEBase.getPWFInstPSDEFId() == null;
            }
            case 56: {
                return pSWFDEBase.getPWFInstPSDEFName() == null;
            }
            case 57: {
                return pSWFDEBase.getStartMobPSDEViewId() == null;
            }
            case 58: {
                return pSWFDEBase.getStartMobPSDEViewName() == null;
            }
            case 59: {
                return pSWFDEBase.getStartPSDEViewId() == null;
            }
            case 60: {
                return pSWFDEBase.getStartPSDEViewName() == null;
            }
            case 61: {
                return pSWFDEBase.getStatePSDEFId() == null;
            }
            case 62: {
                return pSWFDEBase.getStatePSDEFName() == null;
            }
            case 63: {
                return pSWFDEBase.getUpdateDate() == null;
            }
            case 64: {
                return pSWFDEBase.getUpdateMan() == null;
            }
            case 65: {
                return pSWFDEBase.getUserCat() == null;
            }
            case 66: {
                return pSWFDEBase.getUserStart() == null;
            }
            case 67: {
                return pSWFDEBase.getUserTag() == null;
            }
            case 68: {
                return pSWFDEBase.getUserTag2() == null;
            }
            case 69: {
                return pSWFDEBase.getUserTag3() == null;
            }
            case 70: {
                return pSWFDEBase.getUserTag4() == null;
            }
            case 71: {
                return pSWFDEBase.getValidFlag() == null;
            }
            case 72: {
                return pSWFDEBase.getWFActorPSDEFId() == null;
            }
            case 73: {
                return pSWFDEBase.getWFActorPSDEFName() == null;
            }
            case 74: {
                return pSWFDEBase.getWFCatCode() == null;
            }
            case 75: {
                return pSWFDEBase.getWFCodeName() == null;
            }
            case 76: {
                return pSWFDEBase.getWFIdPSDEFId() == null;
            }
            case 77: {
                return pSWFDEBase.getWFIdPSDEFName() == null;
            }
            case 78: {
                return pSWFDEBase.getWFInstPSDEFId() == null;
            }
            case 79: {
                return pSWFDEBase.getWFInstPSDEFName() == null;
            }
            case 80: {
                return pSWFDEBase.getWFMode() == null;
            }
            case 81: {
                return pSWFDEBase.getWFProxyMode() == null;
            }
            case 82: {
                return pSWFDEBase.getWFRetPSDEFId() == null;
            }
            case 83: {
                return pSWFDEBase.getWFRetPSDEFName() == null;
            }
            case 84: {
                return pSWFDEBase.getWFStatePSDEFId() == null;
            }
            case 85: {
                return pSWFDEBase.getWFStatePSDEFName() == null;
            }
            case 86: {
                return pSWFDEBase.getWFStepPSDEFId() == null;
            }
            case 87: {
                return pSWFDEBase.getWFStepPSDEFName() == null;
            }
            case 88: {
                return pSWFDEBase.getWFVerPSDEFId() == null;
            }
            case 89: {
                return pSWFDEBase.getWFVerPSDEFName() == null;
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
        return PSWFDEBase.contains(this, n);
    }

    private static boolean contains(PSWFDEBase pSWFDEBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWFDEBase.isActionMobPSDEViewIdDirty();
            }
            case 1: {
                return pSWFDEBase.isActionMobPSDEViewNameDirty();
            }
            case 2: {
                return pSWFDEBase.isActionPSDEViewIdDirty();
            }
            case 3: {
                return pSWFDEBase.isActionPSDEViewNameDirty();
            }
            case 4: {
                return pSWFDEBase.isCodeNameDirty();
            }
            case 5: {
                return pSWFDEBase.isCreateDateDirty();
            }
            case 6: {
                return pSWFDEBase.isCreateManDirty();
            }
            case 7: {
                return pSWFDEBase.isCustomCodeDirty();
            }
            case 8: {
                return pSWFDEBase.isCustomModeDirty();
            }
            case 9: {
                return pSWFDEBase.isDefaultModeDirty();
            }
            case 10: {
                return pSWFDEBase.isDynaModelFlagDirty();
            }
            case 11: {
                return pSWFDEBase.isEditableWFStepDirty();
            }
            case 12: {
                return pSWFDEBase.isEditViewUriDirty();
            }
            case 13: {
                return pSWFDEBase.isEnableDirty();
            }
            case 14: {
                return pSWFDEBase.isExtCntStatesDirty();
            }
            case 15: {
                return pSWFDEBase.isFinishPSDEActionIdDirty();
            }
            case 16: {
                return pSWFDEBase.isFinishPSDEActionNameDirty();
            }
            case 17: {
                return pSWFDEBase.isInitPSDEActionIdDirty();
            }
            case 18: {
                return pSWFDEBase.isInitPSDEActionNameDirty();
            }
            case 19: {
                return pSWFDEBase.isLockFlagDirty();
            }
            case 20: {
                return pSWFDEBase.isMemoDirty();
            }
            case 21: {
                return pSWFDEBase.isMobEditViewUriDirty();
            }
            case 22: {
                return pSWFDEBase.isMobProxyData2PSDEViewIdDirty();
            }
            case 23: {
                return pSWFDEBase.isMobProxyData2PSDEViewNameDirty();
            }
            case 24: {
                return pSWFDEBase.isMobProxyDataPSDEViewIdDirty();
            }
            case 25: {
                return pSWFDEBase.isMobProxyDataPSDEViewNameDirty();
            }
            case 26: {
                return pSWFDEBase.isMyWFDataDirty();
            }
            case 27: {
                return pSWFDEBase.isMyWFDataPSLanResIdDirty();
            }
            case 28: {
                return pSWFDEBase.isMyWFDataPSLanResNameDirty();
            }
            case 29: {
                return pSWFDEBase.isMyWFWorkDirty();
            }
            case 30: {
                return pSWFDEBase.isMyWFWorkPSLanResIdDirty();
            }
            case 31: {
                return pSWFDEBase.isMyWFWorkPSLanResNameDirty();
            }
            case 32: {
                return pSWFDEBase.isProxyData2PSDEViewIdDirty();
            }
            case 33: {
                return pSWFDEBase.isProxyData2PSDEViewNameDirty();
            }
            case 34: {
                return pSWFDEBase.isProxyDataPSDEFIdDirty();
            }
            case 35: {
                return pSWFDEBase.isProxyDataPSDEFNameDirty();
            }
            case 36: {
                return pSWFDEBase.isProxyDataPSDEViewIdDirty();
            }
            case 37: {
                return pSWFDEBase.isProxyDataPSDEViewNameDirty();
            }
            case 38: {
                return pSWFDEBase.isProxyModulePSDEFIdDirty();
            }
            case 39: {
                return pSWFDEBase.isProxyModulePSDEFNameDirty();
            }
            case 40: {
                return pSWFDEBase.isProxyWFPSDEFIdDirty();
            }
            case 41: {
                return pSWFDEBase.isProxyWFPSDEFNameDirty();
            }
            case 42: {
                return pSWFDEBase.isPSDEIdDirty();
            }
            case 43: {
                return pSWFDEBase.isPSDENameDirty();
            }
            case 44: {
                return pSWFDEBase.isPSDEViewBasesCntDirty();
            }
            case 45: {
                return pSWFDEBase.isPSDynaInstIdDirty();
            }
            case 46: {
                return pSWFDEBase.isPSSysSFPluginIdDirty();
            }
            case 47: {
                return pSWFDEBase.isPSSysSFPluginNameDirty();
            }
            case 48: {
                return pSWFDEBase.isPSSystemIdDirty();
            }
            case 49: {
                return pSWFDEBase.isPSSysWFCatIdDirty();
            }
            case 50: {
                return pSWFDEBase.isPSSysWFCatNameDirty();
            }
            case 51: {
                return pSWFDEBase.isPSWFDEIdDirty();
            }
            case 52: {
                return pSWFDEBase.isPSWFDENameDirty();
            }
            case 53: {
                return pSWFDEBase.isPSWFIdDirty();
            }
            case 54: {
                return pSWFDEBase.isPSWFNameDirty();
            }
            case 55: {
                return pSWFDEBase.isPWFInstPSDEFIdDirty();
            }
            case 56: {
                return pSWFDEBase.isPWFInstPSDEFNameDirty();
            }
            case 57: {
                return pSWFDEBase.isStartMobPSDEViewIdDirty();
            }
            case 58: {
                return pSWFDEBase.isStartMobPSDEViewNameDirty();
            }
            case 59: {
                return pSWFDEBase.isStartPSDEViewIdDirty();
            }
            case 60: {
                return pSWFDEBase.isStartPSDEViewNameDirty();
            }
            case 61: {
                return pSWFDEBase.isStatePSDEFIdDirty();
            }
            case 62: {
                return pSWFDEBase.isStatePSDEFNameDirty();
            }
            case 63: {
                return pSWFDEBase.isUpdateDateDirty();
            }
            case 64: {
                return pSWFDEBase.isUpdateManDirty();
            }
            case 65: {
                return pSWFDEBase.isUserCatDirty();
            }
            case 66: {
                return pSWFDEBase.isUserStartDirty();
            }
            case 67: {
                return pSWFDEBase.isUserTagDirty();
            }
            case 68: {
                return pSWFDEBase.isUserTag2Dirty();
            }
            case 69: {
                return pSWFDEBase.isUserTag3Dirty();
            }
            case 70: {
                return pSWFDEBase.isUserTag4Dirty();
            }
            case 71: {
                return pSWFDEBase.isValidFlagDirty();
            }
            case 72: {
                return pSWFDEBase.isWFActorPSDEFIdDirty();
            }
            case 73: {
                return pSWFDEBase.isWFActorPSDEFNameDirty();
            }
            case 74: {
                return pSWFDEBase.isWFCatCodeDirty();
            }
            case 75: {
                return pSWFDEBase.isWFCodeNameDirty();
            }
            case 76: {
                return pSWFDEBase.isWFIdPSDEFIdDirty();
            }
            case 77: {
                return pSWFDEBase.isWFIdPSDEFNameDirty();
            }
            case 78: {
                return pSWFDEBase.isWFInstPSDEFIdDirty();
            }
            case 79: {
                return pSWFDEBase.isWFInstPSDEFNameDirty();
            }
            case 80: {
                return pSWFDEBase.isWFModeDirty();
            }
            case 81: {
                return pSWFDEBase.isWFProxyModeDirty();
            }
            case 82: {
                return pSWFDEBase.isWFRetPSDEFIdDirty();
            }
            case 83: {
                return pSWFDEBase.isWFRetPSDEFNameDirty();
            }
            case 84: {
                return pSWFDEBase.isWFStatePSDEFIdDirty();
            }
            case 85: {
                return pSWFDEBase.isWFStatePSDEFNameDirty();
            }
            case 86: {
                return pSWFDEBase.isWFStepPSDEFIdDirty();
            }
            case 87: {
                return pSWFDEBase.isWFStepPSDEFNameDirty();
            }
            case 88: {
                return pSWFDEBase.isWFVerPSDEFIdDirty();
            }
            case 89: {
                return pSWFDEBase.isWFVerPSDEFNameDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSWFDEBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSWFDEBase pSWFDEBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSWFDEBase.getActionMobPSDEViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionmobpsdeviewid", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getActionMobPSDEViewId()), (boolean)false);
        }
        if (bl || pSWFDEBase.getActionMobPSDEViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionmobpsdeviewname", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getActionMobPSDEViewName()), (boolean)false);
        }
        if (bl || pSWFDEBase.getActionPSDEViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionpsdeviewid", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getActionPSDEViewId()), (boolean)false);
        }
        if (bl || pSWFDEBase.getActionPSDEViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionpsdeviewname", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getActionPSDEViewName()), (boolean)false);
        }
        if (bl || pSWFDEBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getCodeName()), (boolean)false);
        }
        if (bl || pSWFDEBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSWFDEBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSWFDEBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSWFDEBase.getCustomMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"custommode", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getCustomMode()), (boolean)false);
        }
        if (bl || pSWFDEBase.getDefaultMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultmode", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getDefaultMode()), (boolean)false);
        }
        if (bl || pSWFDEBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSWFDEBase.getEditableWFStep() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"editablewfstep", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getEditableWFStep()), (boolean)false);
        }
        if (bl || pSWFDEBase.getEditViewUri() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"editviewuri", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getEditViewUri()), (boolean)false);
        }
        if (bl || pSWFDEBase.getEnable() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enable", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getEnable()), (boolean)false);
        }
        if (bl || pSWFDEBase.getExtCntStates() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"extcntstates", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getExtCntStates()), (boolean)false);
        }
        if (bl || pSWFDEBase.getFinishPSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"finishpsdeactionid", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getFinishPSDEActionId()), (boolean)false);
        }
        if (bl || pSWFDEBase.getFinishPSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"finishpsdeactionname", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getFinishPSDEActionName()), (boolean)false);
        }
        if (bl || pSWFDEBase.getInitPSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"initpsdeactionid", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getInitPSDEActionId()), (boolean)false);
        }
        if (bl || pSWFDEBase.getInitPSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"initpsdeactionname", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getInitPSDEActionName()), (boolean)false);
        }
        if (bl || pSWFDEBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSWFDEBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getMemo()), (boolean)false);
        }
        if (bl || pSWFDEBase.getMobEditViewUri() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobeditviewuri", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getMobEditViewUri()), (boolean)false);
        }
        if (bl || pSWFDEBase.getMobProxyData2PSDEViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobproxydata2psdeviewid", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getMobProxyData2PSDEViewId()), (boolean)false);
        }
        if (bl || pSWFDEBase.getMobProxyData2PSDEViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobproxydata2psdeviewname", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getMobProxyData2PSDEViewName()), (boolean)false);
        }
        if (bl || pSWFDEBase.getMobProxyDataPSDEViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobproxydatapsdeviewid", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getMobProxyDataPSDEViewId()), (boolean)false);
        }
        if (bl || pSWFDEBase.getMobProxyDataPSDEViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobproxydatapsdeviewname", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getMobProxyDataPSDEViewName()), (boolean)false);
        }
        if (bl || pSWFDEBase.getMyWFData() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mywfdata", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getMyWFData()), (boolean)false);
        }
        if (bl || pSWFDEBase.getMyWFDataPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mywfdatapslanresid", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getMyWFDataPSLanResId()), (boolean)false);
        }
        if (bl || pSWFDEBase.getMyWFDataPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mywfdatapslanresname", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getMyWFDataPSLanResName()), (boolean)false);
        }
        if (bl || pSWFDEBase.getMyWFWork() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mywfwork", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getMyWFWork()), (boolean)false);
        }
        if (bl || pSWFDEBase.getMyWFWorkPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mywfworkpslanresid", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getMyWFWorkPSLanResId()), (boolean)false);
        }
        if (bl || pSWFDEBase.getMyWFWorkPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mywfworkpslanresname", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getMyWFWorkPSLanResName()), (boolean)false);
        }
        if (bl || pSWFDEBase.getProxyData2PSDEViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"proxydata2psdeviewid", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getProxyData2PSDEViewId()), (boolean)false);
        }
        if (bl || pSWFDEBase.getProxyData2PSDEViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"proxydata2psdeviewname", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getProxyData2PSDEViewName()), (boolean)false);
        }
        if (bl || pSWFDEBase.getProxyDataPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"proxydatapsdefid", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getProxyDataPSDEFId()), (boolean)false);
        }
        if (bl || pSWFDEBase.getProxyDataPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"proxydatapsdefname", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getProxyDataPSDEFName()), (boolean)false);
        }
        if (bl || pSWFDEBase.getProxyDataPSDEViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"proxydatapsdeviewid", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getProxyDataPSDEViewId()), (boolean)false);
        }
        if (bl || pSWFDEBase.getProxyDataPSDEViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"proxydatapsdeviewname", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getProxyDataPSDEViewName()), (boolean)false);
        }
        if (bl || pSWFDEBase.getProxyModulePSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"proxymodulepsdefid", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getProxyModulePSDEFId()), (boolean)false);
        }
        if (bl || pSWFDEBase.getProxyModulePSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"proxymodulepsdefname", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getProxyModulePSDEFName()), (boolean)false);
        }
        if (bl || pSWFDEBase.getProxyWFPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"proxywfpsdefid", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getProxyWFPSDEFId()), (boolean)false);
        }
        if (bl || pSWFDEBase.getProxyWFPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"proxywfpsdefname", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getProxyWFPSDEFName()), (boolean)false);
        }
        if (bl || pSWFDEBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSWFDEBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSWFDEBase.getPSDEViewBasesCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewbasescnt", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getPSDEViewBasesCnt()), (boolean)false);
        }
        if (bl || pSWFDEBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSWFDEBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSWFDEBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSWFDEBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSWFDEBase.getPSSysWFCatId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyswfcatid", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getPSSysWFCatId()), (boolean)false);
        }
        if (bl || pSWFDEBase.getPSSysWFCatName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyswfcatname", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getPSSysWFCatName()), (boolean)false);
        }
        if (bl || pSWFDEBase.getPSWFDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfdeid", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getPSWFDEId()), (boolean)false);
        }
        if (bl || pSWFDEBase.getPSWFDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfdename", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getPSWFDEName()), (boolean)false);
        }
        if (bl || pSWFDEBase.getPSWFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfid", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getPSWFId()), (boolean)false);
        }
        if (bl || pSWFDEBase.getPSWFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfname", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getPSWFName()), (boolean)false);
        }
        if (bl || pSWFDEBase.getPWFInstPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pwfinstpsdefid", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getPWFInstPSDEFId()), (boolean)false);
        }
        if (bl || pSWFDEBase.getPWFInstPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pwfinstpsdefname", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getPWFInstPSDEFName()), (boolean)false);
        }
        if (bl || pSWFDEBase.getStartMobPSDEViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"startmobpsdeviewid", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getStartMobPSDEViewId()), (boolean)false);
        }
        if (bl || pSWFDEBase.getStartMobPSDEViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"startmobpsdeviewname", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getStartMobPSDEViewName()), (boolean)false);
        }
        if (bl || pSWFDEBase.getStartPSDEViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"startpsdeviewid", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getStartPSDEViewId()), (boolean)false);
        }
        if (bl || pSWFDEBase.getStartPSDEViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"startpsdeviewname", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getStartPSDEViewName()), (boolean)false);
        }
        if (bl || pSWFDEBase.getStatePSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"statepsdefid", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getStatePSDEFId()), (boolean)false);
        }
        if (bl || pSWFDEBase.getStatePSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"statepsdefname", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getStatePSDEFName()), (boolean)false);
        }
        if (bl || pSWFDEBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSWFDEBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSWFDEBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getUserCat()), (boolean)false);
        }
        if (bl || pSWFDEBase.getUserStart() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userstart", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getUserStart()), (boolean)false);
        }
        if (bl || pSWFDEBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getUserTag()), (boolean)false);
        }
        if (bl || pSWFDEBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSWFDEBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSWFDEBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSWFDEBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSWFDEBase.getWFActorPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wfactorpsdefid", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getWFActorPSDEFId()), (boolean)false);
        }
        if (bl || pSWFDEBase.getWFActorPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wfactorpsdefname", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getWFActorPSDEFName()), (boolean)false);
        }
        if (bl || pSWFDEBase.getWFCatCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wfcatcode", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getWFCatCode()), (boolean)false);
        }
        if (bl || pSWFDEBase.getWFCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wfcodename", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getWFCodeName()), (boolean)false);
        }
        if (bl || pSWFDEBase.getWFIdPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wfidpsdefid", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getWFIdPSDEFId()), (boolean)false);
        }
        if (bl || pSWFDEBase.getWFIdPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wfidpsdefname", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getWFIdPSDEFName()), (boolean)false);
        }
        if (bl || pSWFDEBase.getWFInstPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wfinstpsdefid", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getWFInstPSDEFId()), (boolean)false);
        }
        if (bl || pSWFDEBase.getWFInstPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wfinstpsdefname", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getWFInstPSDEFName()), (boolean)false);
        }
        if (bl || pSWFDEBase.getWFMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wfmode", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getWFMode()), (boolean)false);
        }
        if (bl || pSWFDEBase.getWFProxyMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wfproxymode", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getWFProxyMode()), (boolean)false);
        }
        if (bl || pSWFDEBase.getWFRetPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wfretpsdefid", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getWFRetPSDEFId()), (boolean)false);
        }
        if (bl || pSWFDEBase.getWFRetPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wfretpsdefname", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getWFRetPSDEFName()), (boolean)false);
        }
        if (bl || pSWFDEBase.getWFStatePSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wfstatepsdefid", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getWFStatePSDEFId()), (boolean)false);
        }
        if (bl || pSWFDEBase.getWFStatePSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wfstatepsdefname", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getWFStatePSDEFName()), (boolean)false);
        }
        if (bl || pSWFDEBase.getWFStepPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wfsteppsdefid", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getWFStepPSDEFId()), (boolean)false);
        }
        if (bl || pSWFDEBase.getWFStepPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wfsteppsdefname", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getWFStepPSDEFName()), (boolean)false);
        }
        if (bl || pSWFDEBase.getWFVerPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wfverpsdefid", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getWFVerPSDEFId()), (boolean)false);
        }
        if (bl || pSWFDEBase.getWFVerPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wfverpsdefname", (Object)PSWFDEBase.getJSONValue((Object)pSWFDEBase.getWFVerPSDEFName()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSWFDEBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSWFDEBase pSWFDEBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSWFDEBase.getActionMobPSDEViewId() != null) {
            object = pSWFDEBase.getActionMobPSDEViewId();
            xmlNode.setAttribute(FIELD_ACTIONMOBPSDEVIEWID, (String)(object == null ? "" : object));
        }
        if (bl || pSWFDEBase.getActionMobPSDEViewName() != null) {
            object = pSWFDEBase.getActionMobPSDEViewName();
            xmlNode.setAttribute(FIELD_ACTIONMOBPSDEVIEWNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSWFDEBase.getActionPSDEViewId() != null) {
            object = pSWFDEBase.getActionPSDEViewId();
            xmlNode.setAttribute(FIELD_ACTIONPSDEVIEWID, (String)(object == null ? "" : object));
        }
        if (bl || pSWFDEBase.getActionPSDEViewName() != null) {
            object = pSWFDEBase.getActionPSDEViewName();
            xmlNode.setAttribute(FIELD_ACTIONPSDEVIEWNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSWFDEBase.getCodeName() != null) {
            object = pSWFDEBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getCreateDate() != null) {
            object = pSWFDEBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWFDEBase.getCreateMan() != null) {
            object = pSWFDEBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getCustomCode() != null) {
            object = pSWFDEBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getCustomMode() != null) {
            object = pSWFDEBase.getCustomMode();
            xmlNode.setAttribute(FIELD_CUSTOMMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWFDEBase.getDefaultMode() != null) {
            object = pSWFDEBase.getDefaultMode();
            xmlNode.setAttribute(FIELD_DEFAULTMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWFDEBase.getDynaModelFlag() != null) {
            object = pSWFDEBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWFDEBase.getEditableWFStep() != null) {
            object = pSWFDEBase.getEditableWFStep();
            xmlNode.setAttribute(FIELD_EDITABLEWFSTEP, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getEditViewUri() != null) {
            object = pSWFDEBase.getEditViewUri();
            xmlNode.setAttribute(FIELD_EDITVIEWURI, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getEnable() != null) {
            object = pSWFDEBase.getEnable();
            xmlNode.setAttribute(FIELD_ENABLE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWFDEBase.getExtCntStates() != null) {
            object = pSWFDEBase.getExtCntStates();
            xmlNode.setAttribute(FIELD_EXTCNTSTATES, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getFinishPSDEActionId() != null) {
            object = pSWFDEBase.getFinishPSDEActionId();
            xmlNode.setAttribute(FIELD_FINISHPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getFinishPSDEActionName() != null) {
            object = pSWFDEBase.getFinishPSDEActionName();
            xmlNode.setAttribute(FIELD_FINISHPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getInitPSDEActionId() != null) {
            object = pSWFDEBase.getInitPSDEActionId();
            xmlNode.setAttribute(FIELD_INITPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getInitPSDEActionName() != null) {
            object = pSWFDEBase.getInitPSDEActionName();
            xmlNode.setAttribute(FIELD_INITPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getLockFlag() != null) {
            object = pSWFDEBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWFDEBase.getMemo() != null) {
            object = pSWFDEBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getMobEditViewUri() != null) {
            object = pSWFDEBase.getMobEditViewUri();
            xmlNode.setAttribute(FIELD_MOBEDITVIEWURI, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getMobProxyData2PSDEViewId() != null) {
            object = pSWFDEBase.getMobProxyData2PSDEViewId();
            xmlNode.setAttribute(FIELD_MOBPROXYDATA2PSDEVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getMobProxyData2PSDEViewName() != null) {
            object = pSWFDEBase.getMobProxyData2PSDEViewName();
            xmlNode.setAttribute(FIELD_MOBPROXYDATA2PSDEVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getMobProxyDataPSDEViewId() != null) {
            object = pSWFDEBase.getMobProxyDataPSDEViewId();
            xmlNode.setAttribute(FIELD_MOBPROXYDATAPSDEVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getMobProxyDataPSDEViewName() != null) {
            object = pSWFDEBase.getMobProxyDataPSDEViewName();
            xmlNode.setAttribute(FIELD_MOBPROXYDATAPSDEVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getMyWFData() != null) {
            object = pSWFDEBase.getMyWFData();
            xmlNode.setAttribute(FIELD_MYWFDATA, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getMyWFDataPSLanResId() != null) {
            object = pSWFDEBase.getMyWFDataPSLanResId();
            xmlNode.setAttribute(FIELD_MYWFDATAPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getMyWFDataPSLanResName() != null) {
            object = pSWFDEBase.getMyWFDataPSLanResName();
            xmlNode.setAttribute(FIELD_MYWFDATAPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getMyWFWork() != null) {
            object = pSWFDEBase.getMyWFWork();
            xmlNode.setAttribute(FIELD_MYWFWORK, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getMyWFWorkPSLanResId() != null) {
            object = pSWFDEBase.getMyWFWorkPSLanResId();
            xmlNode.setAttribute(FIELD_MYWFWORKPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getMyWFWorkPSLanResName() != null) {
            object = pSWFDEBase.getMyWFWorkPSLanResName();
            xmlNode.setAttribute(FIELD_MYWFWORKPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getProxyData2PSDEViewId() != null) {
            object = pSWFDEBase.getProxyData2PSDEViewId();
            xmlNode.setAttribute(FIELD_PROXYDATA2PSDEVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getProxyData2PSDEViewName() != null) {
            object = pSWFDEBase.getProxyData2PSDEViewName();
            xmlNode.setAttribute(FIELD_PROXYDATA2PSDEVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getProxyDataPSDEFId() != null) {
            object = pSWFDEBase.getProxyDataPSDEFId();
            xmlNode.setAttribute(FIELD_PROXYDATAPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getProxyDataPSDEFName() != null) {
            object = pSWFDEBase.getProxyDataPSDEFName();
            xmlNode.setAttribute(FIELD_PROXYDATAPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getProxyDataPSDEViewId() != null) {
            object = pSWFDEBase.getProxyDataPSDEViewId();
            xmlNode.setAttribute(FIELD_PROXYDATAPSDEVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getProxyDataPSDEViewName() != null) {
            object = pSWFDEBase.getProxyDataPSDEViewName();
            xmlNode.setAttribute(FIELD_PROXYDATAPSDEVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getProxyModulePSDEFId() != null) {
            object = pSWFDEBase.getProxyModulePSDEFId();
            xmlNode.setAttribute(FIELD_PROXYMODULEPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getProxyModulePSDEFName() != null) {
            object = pSWFDEBase.getProxyModulePSDEFName();
            xmlNode.setAttribute(FIELD_PROXYMODULEPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getProxyWFPSDEFId() != null) {
            object = pSWFDEBase.getProxyWFPSDEFId();
            xmlNode.setAttribute(FIELD_PROXYWFPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getProxyWFPSDEFName() != null) {
            object = pSWFDEBase.getProxyWFPSDEFName();
            xmlNode.setAttribute(FIELD_PROXYWFPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getPSDEId() != null) {
            object = pSWFDEBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getPSDEName() != null) {
            object = pSWFDEBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getPSDEViewBasesCnt() != null) {
            object = pSWFDEBase.getPSDEViewBasesCnt();
            xmlNode.setAttribute(FIELD_PSDEVIEWBASESCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWFDEBase.getPSDynaInstId() != null) {
            object = pSWFDEBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getPSSysSFPluginId() != null) {
            object = pSWFDEBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getPSSysSFPluginName() != null) {
            object = pSWFDEBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getPSSystemId() != null) {
            object = pSWFDEBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getPSSysWFCatId() != null) {
            object = pSWFDEBase.getPSSysWFCatId();
            xmlNode.setAttribute(FIELD_PSSYSWFCATID, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getPSSysWFCatName() != null) {
            object = pSWFDEBase.getPSSysWFCatName();
            xmlNode.setAttribute(FIELD_PSSYSWFCATNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getPSWFDEId() != null) {
            object = pSWFDEBase.getPSWFDEId();
            xmlNode.setAttribute(FIELD_PSWFDEID, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getPSWFDEName() != null) {
            object = pSWFDEBase.getPSWFDEName();
            xmlNode.setAttribute(FIELD_PSWFDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getPSWFId() != null) {
            object = pSWFDEBase.getPSWFId();
            xmlNode.setAttribute(FIELD_PSWFID, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getPSWFName() != null) {
            object = pSWFDEBase.getPSWFName();
            xmlNode.setAttribute(FIELD_PSWFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getPWFInstPSDEFId() != null) {
            object = pSWFDEBase.getPWFInstPSDEFId();
            xmlNode.setAttribute(FIELD_PWFINSTPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getPWFInstPSDEFName() != null) {
            object = pSWFDEBase.getPWFInstPSDEFName();
            xmlNode.setAttribute(FIELD_PWFINSTPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getStartMobPSDEViewId() != null) {
            object = pSWFDEBase.getStartMobPSDEViewId();
            xmlNode.setAttribute(FIELD_STARTMOBPSDEVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getStartMobPSDEViewName() != null) {
            object = pSWFDEBase.getStartMobPSDEViewName();
            xmlNode.setAttribute(FIELD_STARTMOBPSDEVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getStartPSDEViewId() != null) {
            object = pSWFDEBase.getStartPSDEViewId();
            xmlNode.setAttribute(FIELD_STARTPSDEVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getStartPSDEViewName() != null) {
            object = pSWFDEBase.getStartPSDEViewName();
            xmlNode.setAttribute(FIELD_STARTPSDEVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getStatePSDEFId() != null) {
            object = pSWFDEBase.getStatePSDEFId();
            xmlNode.setAttribute(FIELD_STATEPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getStatePSDEFName() != null) {
            object = pSWFDEBase.getStatePSDEFName();
            xmlNode.setAttribute(FIELD_STATEPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getUpdateDate() != null) {
            object = pSWFDEBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWFDEBase.getUpdateMan() != null) {
            object = pSWFDEBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getUserCat() != null) {
            object = pSWFDEBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getUserStart() != null) {
            object = pSWFDEBase.getUserStart();
            xmlNode.setAttribute(FIELD_USERSTART, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWFDEBase.getUserTag() != null) {
            object = pSWFDEBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getUserTag2() != null) {
            object = pSWFDEBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getUserTag3() != null) {
            object = pSWFDEBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getUserTag4() != null) {
            object = pSWFDEBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getValidFlag() != null) {
            object = pSWFDEBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWFDEBase.getWFActorPSDEFId() != null) {
            object = pSWFDEBase.getWFActorPSDEFId();
            xmlNode.setAttribute(FIELD_WFACTORPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getWFActorPSDEFName() != null) {
            object = pSWFDEBase.getWFActorPSDEFName();
            xmlNode.setAttribute(FIELD_WFACTORPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getWFCatCode() != null) {
            object = pSWFDEBase.getWFCatCode();
            xmlNode.setAttribute(FIELD_WFCATCODE, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getWFCodeName() != null) {
            object = pSWFDEBase.getWFCodeName();
            xmlNode.setAttribute(FIELD_WFCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getWFIdPSDEFId() != null) {
            object = pSWFDEBase.getWFIdPSDEFId();
            xmlNode.setAttribute(FIELD_WFIDPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getWFIdPSDEFName() != null) {
            object = pSWFDEBase.getWFIdPSDEFName();
            xmlNode.setAttribute(FIELD_WFIDPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getWFInstPSDEFId() != null) {
            object = pSWFDEBase.getWFInstPSDEFId();
            xmlNode.setAttribute(FIELD_WFINSTPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getWFInstPSDEFName() != null) {
            object = pSWFDEBase.getWFInstPSDEFName();
            xmlNode.setAttribute(FIELD_WFINSTPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getWFMode() != null) {
            object = pSWFDEBase.getWFMode();
            xmlNode.setAttribute(FIELD_WFMODE, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getWFProxyMode() != null) {
            object = pSWFDEBase.getWFProxyMode();
            xmlNode.setAttribute(FIELD_WFPROXYMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWFDEBase.getWFRetPSDEFId() != null) {
            object = pSWFDEBase.getWFRetPSDEFId();
            xmlNode.setAttribute(FIELD_WFRETPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getWFRetPSDEFName() != null) {
            object = pSWFDEBase.getWFRetPSDEFName();
            xmlNode.setAttribute(FIELD_WFRETPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getWFStatePSDEFId() != null) {
            object = pSWFDEBase.getWFStatePSDEFId();
            xmlNode.setAttribute(FIELD_WFSTATEPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getWFStatePSDEFName() != null) {
            object = pSWFDEBase.getWFStatePSDEFName();
            xmlNode.setAttribute(FIELD_WFSTATEPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getWFStepPSDEFId() != null) {
            object = pSWFDEBase.getWFStepPSDEFId();
            xmlNode.setAttribute(FIELD_WFSTEPPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getWFStepPSDEFName() != null) {
            object = pSWFDEBase.getWFStepPSDEFName();
            xmlNode.setAttribute(FIELD_WFSTEPPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getWFVerPSDEFId() != null) {
            object = pSWFDEBase.getWFVerPSDEFId();
            xmlNode.setAttribute(FIELD_WFVERPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSWFDEBase.getWFVerPSDEFName() != null) {
            object = pSWFDEBase.getWFVerPSDEFName();
            xmlNode.setAttribute(FIELD_WFVERPSDEFNAME, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSWFDEBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSWFDEBase pSWFDEBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSWFDEBase.isActionMobPSDEViewIdDirty() && (bl || pSWFDEBase.getActionMobPSDEViewId() != null)) {
            iDataObject.set(FIELD_ACTIONMOBPSDEVIEWID, (Object)pSWFDEBase.getActionMobPSDEViewId());
        }
        if (pSWFDEBase.isActionMobPSDEViewNameDirty() && (bl || pSWFDEBase.getActionMobPSDEViewName() != null)) {
            iDataObject.set(FIELD_ACTIONMOBPSDEVIEWNAME, (Object)pSWFDEBase.getActionMobPSDEViewName());
        }
        if (pSWFDEBase.isActionPSDEViewIdDirty() && (bl || pSWFDEBase.getActionPSDEViewId() != null)) {
            iDataObject.set(FIELD_ACTIONPSDEVIEWID, (Object)pSWFDEBase.getActionPSDEViewId());
        }
        if (pSWFDEBase.isActionPSDEViewNameDirty() && (bl || pSWFDEBase.getActionPSDEViewName() != null)) {
            iDataObject.set(FIELD_ACTIONPSDEVIEWNAME, (Object)pSWFDEBase.getActionPSDEViewName());
        }
        if (pSWFDEBase.isCodeNameDirty() && (bl || pSWFDEBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSWFDEBase.getCodeName());
        }
        if (pSWFDEBase.isCreateDateDirty() && (bl || pSWFDEBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSWFDEBase.getCreateDate());
        }
        if (pSWFDEBase.isCreateManDirty() && (bl || pSWFDEBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSWFDEBase.getCreateMan());
        }
        if (pSWFDEBase.isCustomCodeDirty() && (bl || pSWFDEBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSWFDEBase.getCustomCode());
        }
        if (pSWFDEBase.isCustomModeDirty() && (bl || pSWFDEBase.getCustomMode() != null)) {
            iDataObject.set(FIELD_CUSTOMMODE, (Object)pSWFDEBase.getCustomMode());
        }
        if (pSWFDEBase.isDefaultModeDirty() && (bl || pSWFDEBase.getDefaultMode() != null)) {
            iDataObject.set(FIELD_DEFAULTMODE, (Object)pSWFDEBase.getDefaultMode());
        }
        if (pSWFDEBase.isDynaModelFlagDirty() && (bl || pSWFDEBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSWFDEBase.getDynaModelFlag());
        }
        if (pSWFDEBase.isEditableWFStepDirty() && (bl || pSWFDEBase.getEditableWFStep() != null)) {
            iDataObject.set(FIELD_EDITABLEWFSTEP, (Object)pSWFDEBase.getEditableWFStep());
        }
        if (pSWFDEBase.isEditViewUriDirty() && (bl || pSWFDEBase.getEditViewUri() != null)) {
            iDataObject.set(FIELD_EDITVIEWURI, (Object)pSWFDEBase.getEditViewUri());
        }
        if (pSWFDEBase.isEnableDirty() && (bl || pSWFDEBase.getEnable() != null)) {
            iDataObject.set(FIELD_ENABLE, (Object)pSWFDEBase.getEnable());
        }
        if (pSWFDEBase.isExtCntStatesDirty() && (bl || pSWFDEBase.getExtCntStates() != null)) {
            iDataObject.set(FIELD_EXTCNTSTATES, (Object)pSWFDEBase.getExtCntStates());
        }
        if (pSWFDEBase.isFinishPSDEActionIdDirty() && (bl || pSWFDEBase.getFinishPSDEActionId() != null)) {
            iDataObject.set(FIELD_FINISHPSDEACTIONID, (Object)pSWFDEBase.getFinishPSDEActionId());
        }
        if (pSWFDEBase.isFinishPSDEActionNameDirty() && (bl || pSWFDEBase.getFinishPSDEActionName() != null)) {
            iDataObject.set(FIELD_FINISHPSDEACTIONNAME, (Object)pSWFDEBase.getFinishPSDEActionName());
        }
        if (pSWFDEBase.isInitPSDEActionIdDirty() && (bl || pSWFDEBase.getInitPSDEActionId() != null)) {
            iDataObject.set(FIELD_INITPSDEACTIONID, (Object)pSWFDEBase.getInitPSDEActionId());
        }
        if (pSWFDEBase.isInitPSDEActionNameDirty() && (bl || pSWFDEBase.getInitPSDEActionName() != null)) {
            iDataObject.set(FIELD_INITPSDEACTIONNAME, (Object)pSWFDEBase.getInitPSDEActionName());
        }
        if (pSWFDEBase.isLockFlagDirty() && (bl || pSWFDEBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSWFDEBase.getLockFlag());
        }
        if (pSWFDEBase.isMemoDirty() && (bl || pSWFDEBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSWFDEBase.getMemo());
        }
        if (pSWFDEBase.isMobEditViewUriDirty() && (bl || pSWFDEBase.getMobEditViewUri() != null)) {
            iDataObject.set(FIELD_MOBEDITVIEWURI, (Object)pSWFDEBase.getMobEditViewUri());
        }
        if (pSWFDEBase.isMobProxyData2PSDEViewIdDirty() && (bl || pSWFDEBase.getMobProxyData2PSDEViewId() != null)) {
            iDataObject.set(FIELD_MOBPROXYDATA2PSDEVIEWID, (Object)pSWFDEBase.getMobProxyData2PSDEViewId());
        }
        if (pSWFDEBase.isMobProxyData2PSDEViewNameDirty() && (bl || pSWFDEBase.getMobProxyData2PSDEViewName() != null)) {
            iDataObject.set(FIELD_MOBPROXYDATA2PSDEVIEWNAME, (Object)pSWFDEBase.getMobProxyData2PSDEViewName());
        }
        if (pSWFDEBase.isMobProxyDataPSDEViewIdDirty() && (bl || pSWFDEBase.getMobProxyDataPSDEViewId() != null)) {
            iDataObject.set(FIELD_MOBPROXYDATAPSDEVIEWID, (Object)pSWFDEBase.getMobProxyDataPSDEViewId());
        }
        if (pSWFDEBase.isMobProxyDataPSDEViewNameDirty() && (bl || pSWFDEBase.getMobProxyDataPSDEViewName() != null)) {
            iDataObject.set(FIELD_MOBPROXYDATAPSDEVIEWNAME, (Object)pSWFDEBase.getMobProxyDataPSDEViewName());
        }
        if (pSWFDEBase.isMyWFDataDirty() && (bl || pSWFDEBase.getMyWFData() != null)) {
            iDataObject.set(FIELD_MYWFDATA, (Object)pSWFDEBase.getMyWFData());
        }
        if (pSWFDEBase.isMyWFDataPSLanResIdDirty() && (bl || pSWFDEBase.getMyWFDataPSLanResId() != null)) {
            iDataObject.set(FIELD_MYWFDATAPSLANRESID, (Object)pSWFDEBase.getMyWFDataPSLanResId());
        }
        if (pSWFDEBase.isMyWFDataPSLanResNameDirty() && (bl || pSWFDEBase.getMyWFDataPSLanResName() != null)) {
            iDataObject.set(FIELD_MYWFDATAPSLANRESNAME, (Object)pSWFDEBase.getMyWFDataPSLanResName());
        }
        if (pSWFDEBase.isMyWFWorkDirty() && (bl || pSWFDEBase.getMyWFWork() != null)) {
            iDataObject.set(FIELD_MYWFWORK, (Object)pSWFDEBase.getMyWFWork());
        }
        if (pSWFDEBase.isMyWFWorkPSLanResIdDirty() && (bl || pSWFDEBase.getMyWFWorkPSLanResId() != null)) {
            iDataObject.set(FIELD_MYWFWORKPSLANRESID, (Object)pSWFDEBase.getMyWFWorkPSLanResId());
        }
        if (pSWFDEBase.isMyWFWorkPSLanResNameDirty() && (bl || pSWFDEBase.getMyWFWorkPSLanResName() != null)) {
            iDataObject.set(FIELD_MYWFWORKPSLANRESNAME, (Object)pSWFDEBase.getMyWFWorkPSLanResName());
        }
        if (pSWFDEBase.isProxyData2PSDEViewIdDirty() && (bl || pSWFDEBase.getProxyData2PSDEViewId() != null)) {
            iDataObject.set(FIELD_PROXYDATA2PSDEVIEWID, (Object)pSWFDEBase.getProxyData2PSDEViewId());
        }
        if (pSWFDEBase.isProxyData2PSDEViewNameDirty() && (bl || pSWFDEBase.getProxyData2PSDEViewName() != null)) {
            iDataObject.set(FIELD_PROXYDATA2PSDEVIEWNAME, (Object)pSWFDEBase.getProxyData2PSDEViewName());
        }
        if (pSWFDEBase.isProxyDataPSDEFIdDirty() && (bl || pSWFDEBase.getProxyDataPSDEFId() != null)) {
            iDataObject.set(FIELD_PROXYDATAPSDEFID, (Object)pSWFDEBase.getProxyDataPSDEFId());
        }
        if (pSWFDEBase.isProxyDataPSDEFNameDirty() && (bl || pSWFDEBase.getProxyDataPSDEFName() != null)) {
            iDataObject.set(FIELD_PROXYDATAPSDEFNAME, (Object)pSWFDEBase.getProxyDataPSDEFName());
        }
        if (pSWFDEBase.isProxyDataPSDEViewIdDirty() && (bl || pSWFDEBase.getProxyDataPSDEViewId() != null)) {
            iDataObject.set(FIELD_PROXYDATAPSDEVIEWID, (Object)pSWFDEBase.getProxyDataPSDEViewId());
        }
        if (pSWFDEBase.isProxyDataPSDEViewNameDirty() && (bl || pSWFDEBase.getProxyDataPSDEViewName() != null)) {
            iDataObject.set(FIELD_PROXYDATAPSDEVIEWNAME, (Object)pSWFDEBase.getProxyDataPSDEViewName());
        }
        if (pSWFDEBase.isProxyModulePSDEFIdDirty() && (bl || pSWFDEBase.getProxyModulePSDEFId() != null)) {
            iDataObject.set(FIELD_PROXYMODULEPSDEFID, (Object)pSWFDEBase.getProxyModulePSDEFId());
        }
        if (pSWFDEBase.isProxyModulePSDEFNameDirty() && (bl || pSWFDEBase.getProxyModulePSDEFName() != null)) {
            iDataObject.set(FIELD_PROXYMODULEPSDEFNAME, (Object)pSWFDEBase.getProxyModulePSDEFName());
        }
        if (pSWFDEBase.isProxyWFPSDEFIdDirty() && (bl || pSWFDEBase.getProxyWFPSDEFId() != null)) {
            iDataObject.set(FIELD_PROXYWFPSDEFID, (Object)pSWFDEBase.getProxyWFPSDEFId());
        }
        if (pSWFDEBase.isProxyWFPSDEFNameDirty() && (bl || pSWFDEBase.getProxyWFPSDEFName() != null)) {
            iDataObject.set(FIELD_PROXYWFPSDEFNAME, (Object)pSWFDEBase.getProxyWFPSDEFName());
        }
        if (pSWFDEBase.isPSDEIdDirty() && (bl || pSWFDEBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSWFDEBase.getPSDEId());
        }
        if (pSWFDEBase.isPSDENameDirty() && (bl || pSWFDEBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSWFDEBase.getPSDEName());
        }
        if (pSWFDEBase.isPSDEViewBasesCntDirty() && (bl || pSWFDEBase.getPSDEViewBasesCnt() != null)) {
            iDataObject.set(FIELD_PSDEVIEWBASESCNT, (Object)pSWFDEBase.getPSDEViewBasesCnt());
        }
        if (pSWFDEBase.isPSDynaInstIdDirty() && (bl || pSWFDEBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSWFDEBase.getPSDynaInstId());
        }
        if (pSWFDEBase.isPSSysSFPluginIdDirty() && (bl || pSWFDEBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSWFDEBase.getPSSysSFPluginId());
        }
        if (pSWFDEBase.isPSSysSFPluginNameDirty() && (bl || pSWFDEBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSWFDEBase.getPSSysSFPluginName());
        }
        if (pSWFDEBase.isPSSystemIdDirty() && (bl || pSWFDEBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSWFDEBase.getPSSystemId());
        }
        if (pSWFDEBase.isPSSysWFCatIdDirty() && (bl || pSWFDEBase.getPSSysWFCatId() != null)) {
            iDataObject.set(FIELD_PSSYSWFCATID, (Object)pSWFDEBase.getPSSysWFCatId());
        }
        if (pSWFDEBase.isPSSysWFCatNameDirty() && (bl || pSWFDEBase.getPSSysWFCatName() != null)) {
            iDataObject.set(FIELD_PSSYSWFCATNAME, (Object)pSWFDEBase.getPSSysWFCatName());
        }
        if (pSWFDEBase.isPSWFDEIdDirty() && (bl || pSWFDEBase.getPSWFDEId() != null)) {
            iDataObject.set(FIELD_PSWFDEID, (Object)pSWFDEBase.getPSWFDEId());
        }
        if (pSWFDEBase.isPSWFDENameDirty() && (bl || pSWFDEBase.getPSWFDEName() != null)) {
            iDataObject.set(FIELD_PSWFDENAME, (Object)pSWFDEBase.getPSWFDEName());
        }
        if (pSWFDEBase.isPSWFIdDirty() && (bl || pSWFDEBase.getPSWFId() != null)) {
            iDataObject.set(FIELD_PSWFID, (Object)pSWFDEBase.getPSWFId());
        }
        if (pSWFDEBase.isPSWFNameDirty() && (bl || pSWFDEBase.getPSWFName() != null)) {
            iDataObject.set(FIELD_PSWFNAME, (Object)pSWFDEBase.getPSWFName());
        }
        if (pSWFDEBase.isPWFInstPSDEFIdDirty() && (bl || pSWFDEBase.getPWFInstPSDEFId() != null)) {
            iDataObject.set(FIELD_PWFINSTPSDEFID, (Object)pSWFDEBase.getPWFInstPSDEFId());
        }
        if (pSWFDEBase.isPWFInstPSDEFNameDirty() && (bl || pSWFDEBase.getPWFInstPSDEFName() != null)) {
            iDataObject.set(FIELD_PWFINSTPSDEFNAME, (Object)pSWFDEBase.getPWFInstPSDEFName());
        }
        if (pSWFDEBase.isStartMobPSDEViewIdDirty() && (bl || pSWFDEBase.getStartMobPSDEViewId() != null)) {
            iDataObject.set(FIELD_STARTMOBPSDEVIEWID, (Object)pSWFDEBase.getStartMobPSDEViewId());
        }
        if (pSWFDEBase.isStartMobPSDEViewNameDirty() && (bl || pSWFDEBase.getStartMobPSDEViewName() != null)) {
            iDataObject.set(FIELD_STARTMOBPSDEVIEWNAME, (Object)pSWFDEBase.getStartMobPSDEViewName());
        }
        if (pSWFDEBase.isStartPSDEViewIdDirty() && (bl || pSWFDEBase.getStartPSDEViewId() != null)) {
            iDataObject.set(FIELD_STARTPSDEVIEWID, (Object)pSWFDEBase.getStartPSDEViewId());
        }
        if (pSWFDEBase.isStartPSDEViewNameDirty() && (bl || pSWFDEBase.getStartPSDEViewName() != null)) {
            iDataObject.set(FIELD_STARTPSDEVIEWNAME, (Object)pSWFDEBase.getStartPSDEViewName());
        }
        if (pSWFDEBase.isStatePSDEFIdDirty() && (bl || pSWFDEBase.getStatePSDEFId() != null)) {
            iDataObject.set(FIELD_STATEPSDEFID, (Object)pSWFDEBase.getStatePSDEFId());
        }
        if (pSWFDEBase.isStatePSDEFNameDirty() && (bl || pSWFDEBase.getStatePSDEFName() != null)) {
            iDataObject.set(FIELD_STATEPSDEFNAME, (Object)pSWFDEBase.getStatePSDEFName());
        }
        if (pSWFDEBase.isUpdateDateDirty() && (bl || pSWFDEBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSWFDEBase.getUpdateDate());
        }
        if (pSWFDEBase.isUpdateManDirty() && (bl || pSWFDEBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSWFDEBase.getUpdateMan());
        }
        if (pSWFDEBase.isUserCatDirty() && (bl || pSWFDEBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSWFDEBase.getUserCat());
        }
        if (pSWFDEBase.isUserStartDirty() && (bl || pSWFDEBase.getUserStart() != null)) {
            iDataObject.set(FIELD_USERSTART, (Object)pSWFDEBase.getUserStart());
        }
        if (pSWFDEBase.isUserTagDirty() && (bl || pSWFDEBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSWFDEBase.getUserTag());
        }
        if (pSWFDEBase.isUserTag2Dirty() && (bl || pSWFDEBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSWFDEBase.getUserTag2());
        }
        if (pSWFDEBase.isUserTag3Dirty() && (bl || pSWFDEBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSWFDEBase.getUserTag3());
        }
        if (pSWFDEBase.isUserTag4Dirty() && (bl || pSWFDEBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSWFDEBase.getUserTag4());
        }
        if (pSWFDEBase.isValidFlagDirty() && (bl || pSWFDEBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSWFDEBase.getValidFlag());
        }
        if (pSWFDEBase.isWFActorPSDEFIdDirty() && (bl || pSWFDEBase.getWFActorPSDEFId() != null)) {
            iDataObject.set(FIELD_WFACTORPSDEFID, (Object)pSWFDEBase.getWFActorPSDEFId());
        }
        if (pSWFDEBase.isWFActorPSDEFNameDirty() && (bl || pSWFDEBase.getWFActorPSDEFName() != null)) {
            iDataObject.set(FIELD_WFACTORPSDEFNAME, (Object)pSWFDEBase.getWFActorPSDEFName());
        }
        if (pSWFDEBase.isWFCatCodeDirty() && (bl || pSWFDEBase.getWFCatCode() != null)) {
            iDataObject.set(FIELD_WFCATCODE, (Object)pSWFDEBase.getWFCatCode());
        }
        if (pSWFDEBase.isWFCodeNameDirty() && (bl || pSWFDEBase.getWFCodeName() != null)) {
            iDataObject.set(FIELD_WFCODENAME, (Object)pSWFDEBase.getWFCodeName());
        }
        if (pSWFDEBase.isWFIdPSDEFIdDirty() && (bl || pSWFDEBase.getWFIdPSDEFId() != null)) {
            iDataObject.set(FIELD_WFIDPSDEFID, (Object)pSWFDEBase.getWFIdPSDEFId());
        }
        if (pSWFDEBase.isWFIdPSDEFNameDirty() && (bl || pSWFDEBase.getWFIdPSDEFName() != null)) {
            iDataObject.set(FIELD_WFIDPSDEFNAME, (Object)pSWFDEBase.getWFIdPSDEFName());
        }
        if (pSWFDEBase.isWFInstPSDEFIdDirty() && (bl || pSWFDEBase.getWFInstPSDEFId() != null)) {
            iDataObject.set(FIELD_WFINSTPSDEFID, (Object)pSWFDEBase.getWFInstPSDEFId());
        }
        if (pSWFDEBase.isWFInstPSDEFNameDirty() && (bl || pSWFDEBase.getWFInstPSDEFName() != null)) {
            iDataObject.set(FIELD_WFINSTPSDEFNAME, (Object)pSWFDEBase.getWFInstPSDEFName());
        }
        if (pSWFDEBase.isWFModeDirty() && (bl || pSWFDEBase.getWFMode() != null)) {
            iDataObject.set(FIELD_WFMODE, (Object)pSWFDEBase.getWFMode());
        }
        if (pSWFDEBase.isWFProxyModeDirty() && (bl || pSWFDEBase.getWFProxyMode() != null)) {
            iDataObject.set(FIELD_WFPROXYMODE, (Object)pSWFDEBase.getWFProxyMode());
        }
        if (pSWFDEBase.isWFRetPSDEFIdDirty() && (bl || pSWFDEBase.getWFRetPSDEFId() != null)) {
            iDataObject.set(FIELD_WFRETPSDEFID, (Object)pSWFDEBase.getWFRetPSDEFId());
        }
        if (pSWFDEBase.isWFRetPSDEFNameDirty() && (bl || pSWFDEBase.getWFRetPSDEFName() != null)) {
            iDataObject.set(FIELD_WFRETPSDEFNAME, (Object)pSWFDEBase.getWFRetPSDEFName());
        }
        if (pSWFDEBase.isWFStatePSDEFIdDirty() && (bl || pSWFDEBase.getWFStatePSDEFId() != null)) {
            iDataObject.set(FIELD_WFSTATEPSDEFID, (Object)pSWFDEBase.getWFStatePSDEFId());
        }
        if (pSWFDEBase.isWFStatePSDEFNameDirty() && (bl || pSWFDEBase.getWFStatePSDEFName() != null)) {
            iDataObject.set(FIELD_WFSTATEPSDEFNAME, (Object)pSWFDEBase.getWFStatePSDEFName());
        }
        if (pSWFDEBase.isWFStepPSDEFIdDirty() && (bl || pSWFDEBase.getWFStepPSDEFId() != null)) {
            iDataObject.set(FIELD_WFSTEPPSDEFID, (Object)pSWFDEBase.getWFStepPSDEFId());
        }
        if (pSWFDEBase.isWFStepPSDEFNameDirty() && (bl || pSWFDEBase.getWFStepPSDEFName() != null)) {
            iDataObject.set(FIELD_WFSTEPPSDEFNAME, (Object)pSWFDEBase.getWFStepPSDEFName());
        }
        if (pSWFDEBase.isWFVerPSDEFIdDirty() && (bl || pSWFDEBase.getWFVerPSDEFId() != null)) {
            iDataObject.set(FIELD_WFVERPSDEFID, (Object)pSWFDEBase.getWFVerPSDEFId());
        }
        if (pSWFDEBase.isWFVerPSDEFNameDirty() && (bl || pSWFDEBase.getWFVerPSDEFName() != null)) {
            iDataObject.set(FIELD_WFVERPSDEFNAME, (Object)pSWFDEBase.getWFVerPSDEFName());
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
        return PSWFDEBase.remove(this, n);
    }

    private static boolean remove(PSWFDEBase pSWFDEBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSWFDEBase.resetActionMobPSDEViewId();
                return true;
            }
            case 1: {
                pSWFDEBase.resetActionMobPSDEViewName();
                return true;
            }
            case 2: {
                pSWFDEBase.resetActionPSDEViewId();
                return true;
            }
            case 3: {
                pSWFDEBase.resetActionPSDEViewName();
                return true;
            }
            case 4: {
                pSWFDEBase.resetCodeName();
                return true;
            }
            case 5: {
                pSWFDEBase.resetCreateDate();
                return true;
            }
            case 6: {
                pSWFDEBase.resetCreateMan();
                return true;
            }
            case 7: {
                pSWFDEBase.resetCustomCode();
                return true;
            }
            case 8: {
                pSWFDEBase.resetCustomMode();
                return true;
            }
            case 9: {
                pSWFDEBase.resetDefaultMode();
                return true;
            }
            case 10: {
                pSWFDEBase.resetDynaModelFlag();
                return true;
            }
            case 11: {
                pSWFDEBase.resetEditableWFStep();
                return true;
            }
            case 12: {
                pSWFDEBase.resetEditViewUri();
                return true;
            }
            case 13: {
                pSWFDEBase.resetEnable();
                return true;
            }
            case 14: {
                pSWFDEBase.resetExtCntStates();
                return true;
            }
            case 15: {
                pSWFDEBase.resetFinishPSDEActionId();
                return true;
            }
            case 16: {
                pSWFDEBase.resetFinishPSDEActionName();
                return true;
            }
            case 17: {
                pSWFDEBase.resetInitPSDEActionId();
                return true;
            }
            case 18: {
                pSWFDEBase.resetInitPSDEActionName();
                return true;
            }
            case 19: {
                pSWFDEBase.resetLockFlag();
                return true;
            }
            case 20: {
                pSWFDEBase.resetMemo();
                return true;
            }
            case 21: {
                pSWFDEBase.resetMobEditViewUri();
                return true;
            }
            case 22: {
                pSWFDEBase.resetMobProxyData2PSDEViewId();
                return true;
            }
            case 23: {
                pSWFDEBase.resetMobProxyData2PSDEViewName();
                return true;
            }
            case 24: {
                pSWFDEBase.resetMobProxyDataPSDEViewId();
                return true;
            }
            case 25: {
                pSWFDEBase.resetMobProxyDataPSDEViewName();
                return true;
            }
            case 26: {
                pSWFDEBase.resetMyWFData();
                return true;
            }
            case 27: {
                pSWFDEBase.resetMyWFDataPSLanResId();
                return true;
            }
            case 28: {
                pSWFDEBase.resetMyWFDataPSLanResName();
                return true;
            }
            case 29: {
                pSWFDEBase.resetMyWFWork();
                return true;
            }
            case 30: {
                pSWFDEBase.resetMyWFWorkPSLanResId();
                return true;
            }
            case 31: {
                pSWFDEBase.resetMyWFWorkPSLanResName();
                return true;
            }
            case 32: {
                pSWFDEBase.resetProxyData2PSDEViewId();
                return true;
            }
            case 33: {
                pSWFDEBase.resetProxyData2PSDEViewName();
                return true;
            }
            case 34: {
                pSWFDEBase.resetProxyDataPSDEFId();
                return true;
            }
            case 35: {
                pSWFDEBase.resetProxyDataPSDEFName();
                return true;
            }
            case 36: {
                pSWFDEBase.resetProxyDataPSDEViewId();
                return true;
            }
            case 37: {
                pSWFDEBase.resetProxyDataPSDEViewName();
                return true;
            }
            case 38: {
                pSWFDEBase.resetProxyModulePSDEFId();
                return true;
            }
            case 39: {
                pSWFDEBase.resetProxyModulePSDEFName();
                return true;
            }
            case 40: {
                pSWFDEBase.resetProxyWFPSDEFId();
                return true;
            }
            case 41: {
                pSWFDEBase.resetProxyWFPSDEFName();
                return true;
            }
            case 42: {
                pSWFDEBase.resetPSDEId();
                return true;
            }
            case 43: {
                pSWFDEBase.resetPSDEName();
                return true;
            }
            case 44: {
                pSWFDEBase.resetPSDEViewBasesCnt();
                return true;
            }
            case 45: {
                pSWFDEBase.resetPSDynaInstId();
                return true;
            }
            case 46: {
                pSWFDEBase.resetPSSysSFPluginId();
                return true;
            }
            case 47: {
                pSWFDEBase.resetPSSysSFPluginName();
                return true;
            }
            case 48: {
                pSWFDEBase.resetPSSystemId();
                return true;
            }
            case 49: {
                pSWFDEBase.resetPSSysWFCatId();
                return true;
            }
            case 50: {
                pSWFDEBase.resetPSSysWFCatName();
                return true;
            }
            case 51: {
                pSWFDEBase.resetPSWFDEId();
                return true;
            }
            case 52: {
                pSWFDEBase.resetPSWFDEName();
                return true;
            }
            case 53: {
                pSWFDEBase.resetPSWFId();
                return true;
            }
            case 54: {
                pSWFDEBase.resetPSWFName();
                return true;
            }
            case 55: {
                pSWFDEBase.resetPWFInstPSDEFId();
                return true;
            }
            case 56: {
                pSWFDEBase.resetPWFInstPSDEFName();
                return true;
            }
            case 57: {
                pSWFDEBase.resetStartMobPSDEViewId();
                return true;
            }
            case 58: {
                pSWFDEBase.resetStartMobPSDEViewName();
                return true;
            }
            case 59: {
                pSWFDEBase.resetStartPSDEViewId();
                return true;
            }
            case 60: {
                pSWFDEBase.resetStartPSDEViewName();
                return true;
            }
            case 61: {
                pSWFDEBase.resetStatePSDEFId();
                return true;
            }
            case 62: {
                pSWFDEBase.resetStatePSDEFName();
                return true;
            }
            case 63: {
                pSWFDEBase.resetUpdateDate();
                return true;
            }
            case 64: {
                pSWFDEBase.resetUpdateMan();
                return true;
            }
            case 65: {
                pSWFDEBase.resetUserCat();
                return true;
            }
            case 66: {
                pSWFDEBase.resetUserStart();
                return true;
            }
            case 67: {
                pSWFDEBase.resetUserTag();
                return true;
            }
            case 68: {
                pSWFDEBase.resetUserTag2();
                return true;
            }
            case 69: {
                pSWFDEBase.resetUserTag3();
                return true;
            }
            case 70: {
                pSWFDEBase.resetUserTag4();
                return true;
            }
            case 71: {
                pSWFDEBase.resetValidFlag();
                return true;
            }
            case 72: {
                pSWFDEBase.resetWFActorPSDEFId();
                return true;
            }
            case 73: {
                pSWFDEBase.resetWFActorPSDEFName();
                return true;
            }
            case 74: {
                pSWFDEBase.resetWFCatCode();
                return true;
            }
            case 75: {
                pSWFDEBase.resetWFCodeName();
                return true;
            }
            case 76: {
                pSWFDEBase.resetWFIdPSDEFId();
                return true;
            }
            case 77: {
                pSWFDEBase.resetWFIdPSDEFName();
                return true;
            }
            case 78: {
                pSWFDEBase.resetWFInstPSDEFId();
                return true;
            }
            case 79: {
                pSWFDEBase.resetWFInstPSDEFName();
                return true;
            }
            case 80: {
                pSWFDEBase.resetWFMode();
                return true;
            }
            case 81: {
                pSWFDEBase.resetWFProxyMode();
                return true;
            }
            case 82: {
                pSWFDEBase.resetWFRetPSDEFId();
                return true;
            }
            case 83: {
                pSWFDEBase.resetWFRetPSDEFName();
                return true;
            }
            case 84: {
                pSWFDEBase.resetWFStatePSDEFId();
                return true;
            }
            case 85: {
                pSWFDEBase.resetWFStatePSDEFName();
                return true;
            }
            case 86: {
                pSWFDEBase.resetWFStepPSDEFId();
                return true;
            }
            case 87: {
                pSWFDEBase.resetWFStepPSDEFName();
                return true;
            }
            case 88: {
                pSWFDEBase.resetWFVerPSDEFId();
                return true;
            }
            case 89: {
                pSWFDEBase.resetWFVerPSDEFName();
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
    public PSDEAction getFinishPSDEAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFinishPSDEAction();
        }
        if (this.getFinishPSDEActionId() == null) {
            return null;
        }
        Integer n = this.objFinishPSDEActionLock;
        synchronized (n) {
            if (this.finishpsdeaction != null && DataTypeHelper.compare((int)25, (Object)this.getFinishPSDEActionId(), (Object)this.finishpsdeaction.getPSDEActionId()) != 0L) {
                this.finishpsdeaction = null;
            }
            if (this.finishpsdeaction == null) {
                PSDEAction pSDEAction = new PSDEAction();
                pSDEAction.setPSDEActionId(this.getFinishPSDEActionId());
                PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEActionService.autoGet(pSDEAction);
                this.finishpsdeaction = pSDEAction;
            }
            return this.finishpsdeaction;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEAction getInitPSDEAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInitPSDEAction();
        }
        if (this.getInitPSDEActionId() == null) {
            return null;
        }
        Integer n = this.objInitPSDEActionLock;
        synchronized (n) {
            if (this.initpsdeaction != null && DataTypeHelper.compare((int)25, (Object)this.getInitPSDEActionId(), (Object)this.initpsdeaction.getPSDEActionId()) != 0L) {
                this.initpsdeaction = null;
            }
            if (this.initpsdeaction == null) {
                PSDEAction pSDEAction = new PSDEAction();
                pSDEAction.setPSDEActionId(this.getInitPSDEActionId());
                PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEActionService.autoGet(pSDEAction);
                this.initpsdeaction = pSDEAction;
            }
            return this.initpsdeaction;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getProxyDataPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getProxyDataPSDEF();
        }
        if (this.getProxyDataPSDEFId() == null) {
            return null;
        }
        Integer n = this.objProxyDataPSDEFLock;
        synchronized (n) {
            if (this.proxydatapsdef != null && DataTypeHelper.compare((int)25, (Object)this.getProxyDataPSDEFId(), (Object)this.proxydatapsdef.getPSDEFieldId()) != 0L) {
                this.proxydatapsdef = null;
            }
            if (this.proxydatapsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getProxyDataPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.proxydatapsdef = pSDEField;
            }
            return this.proxydatapsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getProxyModulePSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getProxyModulePSDEF();
        }
        if (this.getProxyModulePSDEFId() == null) {
            return null;
        }
        Integer n = this.objProxyModulePSDEFLock;
        synchronized (n) {
            if (this.proxymodulepsdef != null && DataTypeHelper.compare((int)25, (Object)this.getProxyModulePSDEFId(), (Object)this.proxymodulepsdef.getPSDEFieldId()) != 0L) {
                this.proxymodulepsdef = null;
            }
            if (this.proxymodulepsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getProxyModulePSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.proxymodulepsdef = pSDEField;
            }
            return this.proxymodulepsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getProxyWFPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getProxyWFPSDEF();
        }
        if (this.getProxyWFPSDEFId() == null) {
            return null;
        }
        Integer n = this.objProxyWFPSDEFLock;
        synchronized (n) {
            if (this.proxywfpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getProxyWFPSDEFId(), (Object)this.proxywfpsdef.getPSDEFieldId()) != 0L) {
                this.proxywfpsdef = null;
            }
            if (this.proxywfpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getProxyWFPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.proxywfpsdef = pSDEField;
            }
            return this.proxywfpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getPWFInstPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPWFInstPSDEF();
        }
        if (this.getPWFInstPSDEFId() == null) {
            return null;
        }
        Integer n = this.objPWFInstPSDEFLock;
        synchronized (n) {
            if (this.pwfinstpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getPWFInstPSDEFId(), (Object)this.pwfinstpsdef.getPSDEFieldId()) != 0L) {
                this.pwfinstpsdef = null;
            }
            if (this.pwfinstpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getPWFInstPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.pwfinstpsdef = pSDEField;
            }
            return this.pwfinstpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getStatePSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStatePSDEF();
        }
        if (this.getStatePSDEFId() == null) {
            return null;
        }
        Integer n = this.objStatePSDEFLock;
        synchronized (n) {
            if (this.statepsdef != null && DataTypeHelper.compare((int)25, (Object)this.getStatePSDEFId(), (Object)this.statepsdef.getPSDEFieldId()) != 0L) {
                this.statepsdef = null;
            }
            if (this.statepsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getStatePSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.statepsdef = pSDEField;
            }
            return this.statepsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getWFActorPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFActorPSDEF();
        }
        if (this.getWFActorPSDEFId() == null) {
            return null;
        }
        Integer n = this.objWFActorPSDEFLock;
        synchronized (n) {
            if (this.wfactorpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getWFActorPSDEFId(), (Object)this.wfactorpsdef.getPSDEFieldId()) != 0L) {
                this.wfactorpsdef = null;
            }
            if (this.wfactorpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getWFActorPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.wfactorpsdef = pSDEField;
            }
            return this.wfactorpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getWFIdPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFIdPSDEF();
        }
        if (this.getWFIdPSDEFId() == null) {
            return null;
        }
        Integer n = this.objWFIdPSDEFLock;
        synchronized (n) {
            if (this.wfidpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getWFIdPSDEFId(), (Object)this.wfidpsdef.getPSDEFieldId()) != 0L) {
                this.wfidpsdef = null;
            }
            if (this.wfidpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getWFIdPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.wfidpsdef = pSDEField;
            }
            return this.wfidpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getWFInstPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFInstPSDEF();
        }
        if (this.getWFInstPSDEFId() == null) {
            return null;
        }
        Integer n = this.objWFInstPSDEFLock;
        synchronized (n) {
            if (this.wfinstpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getWFInstPSDEFId(), (Object)this.wfinstpsdef.getPSDEFieldId()) != 0L) {
                this.wfinstpsdef = null;
            }
            if (this.wfinstpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getWFInstPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.wfinstpsdef = pSDEField;
            }
            return this.wfinstpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getWFRetPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFRetPSDEF();
        }
        if (this.getWFRetPSDEFId() == null) {
            return null;
        }
        Integer n = this.objWFRetPSDEFLock;
        synchronized (n) {
            if (this.wfretpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getWFRetPSDEFId(), (Object)this.wfretpsdef.getPSDEFieldId()) != 0L) {
                this.wfretpsdef = null;
            }
            if (this.wfretpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getWFRetPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.wfretpsdef = pSDEField;
            }
            return this.wfretpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getWFStatePSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFStatePSDEF();
        }
        if (this.getWFStatePSDEFId() == null) {
            return null;
        }
        Integer n = this.objWFStatePSDEFLock;
        synchronized (n) {
            if (this.wfstatepsdef != null && DataTypeHelper.compare((int)25, (Object)this.getWFStatePSDEFId(), (Object)this.wfstatepsdef.getPSDEFieldId()) != 0L) {
                this.wfstatepsdef = null;
            }
            if (this.wfstatepsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getWFStatePSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.wfstatepsdef = pSDEField;
            }
            return this.wfstatepsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getWFStepPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFStepPSDEF();
        }
        if (this.getWFStepPSDEFId() == null) {
            return null;
        }
        Integer n = this.objWFStepPSDEFLock;
        synchronized (n) {
            if (this.wfsteppsdef != null && DataTypeHelper.compare((int)25, (Object)this.getWFStepPSDEFId(), (Object)this.wfsteppsdef.getPSDEFieldId()) != 0L) {
                this.wfsteppsdef = null;
            }
            if (this.wfsteppsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getWFStepPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.wfsteppsdef = pSDEField;
            }
            return this.wfsteppsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getWFVerPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFVerPSDEF();
        }
        if (this.getWFVerPSDEFId() == null) {
            return null;
        }
        Integer n = this.objWFVerPSDEFLock;
        synchronized (n) {
            if (this.wfverpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getWFVerPSDEFId(), (Object)this.wfverpsdef.getPSDEFieldId()) != 0L) {
                this.wfverpsdef = null;
            }
            if (this.wfverpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getWFVerPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.wfverpsdef = pSDEField;
            }
            return this.wfverpsdef;
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
    public PSDEViewBase getMobProxyData2PSDEView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobProxyData2PSDEView();
        }
        if (this.getMobProxyData2PSDEViewId() == null) {
            return null;
        }
        Integer n = this.objMobProxyData2PSDEViewLock;
        synchronized (n) {
            if (this.mobproxydata2psdeview != null && DataTypeHelper.compare((int)25, (Object)this.getMobProxyData2PSDEViewId(), (Object)this.mobproxydata2psdeview.getPSDEViewBaseId()) != 0L) {
                this.mobproxydata2psdeview = null;
            }
            if (this.mobproxydata2psdeview == null) {
                PSDEViewBase pSDEViewBase = new PSDEViewBase();
                pSDEViewBase.setPSDEViewBaseId(this.getMobProxyData2PSDEViewId());
                PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
                pSDEViewBaseService.autoGet(pSDEViewBase);
                this.mobproxydata2psdeview = pSDEViewBase;
            }
            return this.mobproxydata2psdeview;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEViewBase getMobProxyDataPSDEView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobProxyDataPSDEView();
        }
        if (this.getMobProxyDataPSDEViewId() == null) {
            return null;
        }
        Integer n = this.objMobProxyDataPSDEViewLock;
        synchronized (n) {
            if (this.mobproxydatapsdeview != null && DataTypeHelper.compare((int)25, (Object)this.getMobProxyDataPSDEViewId(), (Object)this.mobproxydatapsdeview.getPSDEViewBaseId()) != 0L) {
                this.mobproxydatapsdeview = null;
            }
            if (this.mobproxydatapsdeview == null) {
                PSDEViewBase pSDEViewBase = new PSDEViewBase();
                pSDEViewBase.setPSDEViewBaseId(this.getMobProxyDataPSDEViewId());
                PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
                pSDEViewBaseService.autoGet(pSDEViewBase);
                this.mobproxydatapsdeview = pSDEViewBase;
            }
            return this.mobproxydatapsdeview;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEViewBase getProxyData2PSDEView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getProxyData2PSDEView();
        }
        if (this.getProxyData2PSDEViewId() == null) {
            return null;
        }
        Integer n = this.objProxyData2PSDEViewLock;
        synchronized (n) {
            if (this.proxydata2psdeview != null && DataTypeHelper.compare((int)25, (Object)this.getProxyData2PSDEViewId(), (Object)this.proxydata2psdeview.getPSDEViewBaseId()) != 0L) {
                this.proxydata2psdeview = null;
            }
            if (this.proxydata2psdeview == null) {
                PSDEViewBase pSDEViewBase = new PSDEViewBase();
                pSDEViewBase.setPSDEViewBaseId(this.getProxyData2PSDEViewId());
                PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
                pSDEViewBaseService.autoGet(pSDEViewBase);
                this.proxydata2psdeview = pSDEViewBase;
            }
            return this.proxydata2psdeview;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEViewBase getProxyDataPSDEView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getProxyDataPSDEView();
        }
        if (this.getProxyDataPSDEViewId() == null) {
            return null;
        }
        Integer n = this.objProxyDataPSDEViewLock;
        synchronized (n) {
            if (this.proxydatapsdeview != null && DataTypeHelper.compare((int)25, (Object)this.getProxyDataPSDEViewId(), (Object)this.proxydatapsdeview.getPSDEViewBaseId()) != 0L) {
                this.proxydatapsdeview = null;
            }
            if (this.proxydatapsdeview == null) {
                PSDEViewBase pSDEViewBase = new PSDEViewBase();
                pSDEViewBase.setPSDEViewBaseId(this.getProxyDataPSDEViewId());
                PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
                pSDEViewBaseService.autoGet(pSDEViewBase);
                this.proxydatapsdeview = pSDEViewBase;
            }
            return this.proxydatapsdeview;
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
    public PSLanguageRes getMyWFDataPSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMyWFDataPSLanRes();
        }
        if (this.getMyWFDataPSLanResId() == null) {
            return null;
        }
        Integer n = this.objMyWFDataPSLanResLock;
        synchronized (n) {
            if (this.mywfdatapslanres != null && DataTypeHelper.compare((int)25, (Object)this.getMyWFDataPSLanResId(), (Object)this.mywfdatapslanres.getPSLanguageResId()) != 0L) {
                this.mywfdatapslanres = null;
            }
            if (this.mywfdatapslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getMyWFDataPSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet(pSLanguageRes);
                this.mywfdatapslanres = pSLanguageRes;
            }
            return this.mywfdatapslanres;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguageRes getMyWFWorkPSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMyWFWorkPSLanRes();
        }
        if (this.getMyWFWorkPSLanResId() == null) {
            return null;
        }
        Integer n = this.objMyWFWorkPSLanResLock;
        synchronized (n) {
            if (this.mywfworkpslanres != null && DataTypeHelper.compare((int)25, (Object)this.getMyWFWorkPSLanResId(), (Object)this.mywfworkpslanres.getPSLanguageResId()) != 0L) {
                this.mywfworkpslanres = null;
            }
            if (this.mywfworkpslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getMyWFWorkPSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet(pSLanguageRes);
                this.mywfworkpslanres = pSLanguageRes;
            }
            return this.mywfworkpslanres;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysSFPlugin getPSSysSFPlugin() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPlugin();
        }
        if (this.getPSSysSFPluginId() == null) {
            return null;
        }
        Integer n = this.objPSSysSFPluginLock;
        synchronized (n) {
            if (this.pssyssfplugin != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysSFPluginId(), (Object)this.pssyssfplugin.getPSSysSFPluginId()) != 0L) {
                this.pssyssfplugin = null;
            }
            if (this.pssyssfplugin == null) {
                PSSysSFPlugin pSSysSFPlugin = new PSSysSFPlugin();
                pSSysSFPlugin.setPSSysSFPluginId(this.getPSSysSFPluginId());
                PSSysSFPluginService pSSysSFPluginService = (PSSysSFPluginService)ServiceGlobal.getService(PSSysSFPluginService.class, (SessionFactory)this.getSessionFactory());
                pSSysSFPluginService.autoGet(pSSysSFPlugin);
                this.pssyssfplugin = pSSysSFPlugin;
            }
            return this.pssyssfplugin;
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEViewBase> getPSDEViewBases() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewBases();
        }
        if (this.getPSWFDEId() == null) {
            return null;
        }
        PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEViewBasesLock;
        synchronized (n) {
            if (this.psdeviewbases == null) {
                this.psdeviewbases = pSDEViewBaseService.selectByPSWFDE(this);
            }
            return this.psdeviewbases;
        }
    }

    private PSWFDEBase getProxyEntity() {
        return this.proxyPSWFDEBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSWFDEBase = null;
        if (iDataObject != null && iDataObject instanceof PSWFDEBase) {
            this.proxyPSWFDEBase = (PSWFDEBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWFDEService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
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
        fieldIndexMap.put(FIELD_CUSTOMCODE, 7);
        fieldIndexMap.put(FIELD_CUSTOMMODE, 8);
        fieldIndexMap.put(FIELD_DEFAULTMODE, 9);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 10);
        fieldIndexMap.put(FIELD_EDITABLEWFSTEP, 11);
        fieldIndexMap.put(FIELD_EDITVIEWURI, 12);
        fieldIndexMap.put(FIELD_ENABLE, 13);
        fieldIndexMap.put(FIELD_EXTCNTSTATES, 14);
        fieldIndexMap.put(FIELD_FINISHPSDEACTIONID, 15);
        fieldIndexMap.put(FIELD_FINISHPSDEACTIONNAME, 16);
        fieldIndexMap.put(FIELD_INITPSDEACTIONID, 17);
        fieldIndexMap.put(FIELD_INITPSDEACTIONNAME, 18);
        fieldIndexMap.put(FIELD_LOCKFLAG, 19);
        fieldIndexMap.put(FIELD_MEMO, 20);
        fieldIndexMap.put(FIELD_MOBEDITVIEWURI, 21);
        fieldIndexMap.put(FIELD_MOBPROXYDATA2PSDEVIEWID, 22);
        fieldIndexMap.put(FIELD_MOBPROXYDATA2PSDEVIEWNAME, 23);
        fieldIndexMap.put(FIELD_MOBPROXYDATAPSDEVIEWID, 24);
        fieldIndexMap.put(FIELD_MOBPROXYDATAPSDEVIEWNAME, 25);
        fieldIndexMap.put(FIELD_MYWFDATA, 26);
        fieldIndexMap.put(FIELD_MYWFDATAPSLANRESID, 27);
        fieldIndexMap.put(FIELD_MYWFDATAPSLANRESNAME, 28);
        fieldIndexMap.put(FIELD_MYWFWORK, 29);
        fieldIndexMap.put(FIELD_MYWFWORKPSLANRESID, 30);
        fieldIndexMap.put(FIELD_MYWFWORKPSLANRESNAME, 31);
        fieldIndexMap.put(FIELD_PROXYDATA2PSDEVIEWID, 32);
        fieldIndexMap.put(FIELD_PROXYDATA2PSDEVIEWNAME, 33);
        fieldIndexMap.put(FIELD_PROXYDATAPSDEFID, 34);
        fieldIndexMap.put(FIELD_PROXYDATAPSDEFNAME, 35);
        fieldIndexMap.put(FIELD_PROXYDATAPSDEVIEWID, 36);
        fieldIndexMap.put(FIELD_PROXYDATAPSDEVIEWNAME, 37);
        fieldIndexMap.put(FIELD_PROXYMODULEPSDEFID, 38);
        fieldIndexMap.put(FIELD_PROXYMODULEPSDEFNAME, 39);
        fieldIndexMap.put(FIELD_PROXYWFPSDEFID, 40);
        fieldIndexMap.put(FIELD_PROXYWFPSDEFNAME, 41);
        fieldIndexMap.put(FIELD_PSDEID, 42);
        fieldIndexMap.put(FIELD_PSDENAME, 43);
        fieldIndexMap.put(FIELD_PSDEVIEWBASESCNT, 44);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 45);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 46);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 47);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 48);
        fieldIndexMap.put(FIELD_PSSYSWFCATID, 49);
        fieldIndexMap.put(FIELD_PSSYSWFCATNAME, 50);
        fieldIndexMap.put(FIELD_PSWFDEID, 51);
        fieldIndexMap.put(FIELD_PSWFDENAME, 52);
        fieldIndexMap.put(FIELD_PSWFID, 53);
        fieldIndexMap.put(FIELD_PSWFNAME, 54);
        fieldIndexMap.put(FIELD_PWFINSTPSDEFID, 55);
        fieldIndexMap.put(FIELD_PWFINSTPSDEFNAME, 56);
        fieldIndexMap.put(FIELD_STARTMOBPSDEVIEWID, 57);
        fieldIndexMap.put(FIELD_STARTMOBPSDEVIEWNAME, 58);
        fieldIndexMap.put(FIELD_STARTPSDEVIEWID, 59);
        fieldIndexMap.put(FIELD_STARTPSDEVIEWNAME, 60);
        fieldIndexMap.put(FIELD_STATEPSDEFID, 61);
        fieldIndexMap.put(FIELD_STATEPSDEFNAME, 62);
        fieldIndexMap.put(FIELD_UPDATEDATE, 63);
        fieldIndexMap.put(FIELD_UPDATEMAN, 64);
        fieldIndexMap.put(FIELD_USERCAT, 65);
        fieldIndexMap.put(FIELD_USERSTART, 66);
        fieldIndexMap.put(FIELD_USERTAG, 67);
        fieldIndexMap.put(FIELD_USERTAG2, 68);
        fieldIndexMap.put(FIELD_USERTAG3, 69);
        fieldIndexMap.put(FIELD_USERTAG4, 70);
        fieldIndexMap.put(FIELD_VALIDFLAG, 71);
        fieldIndexMap.put(FIELD_WFACTORPSDEFID, 72);
        fieldIndexMap.put(FIELD_WFACTORPSDEFNAME, 73);
        fieldIndexMap.put(FIELD_WFCATCODE, 74);
        fieldIndexMap.put(FIELD_WFCODENAME, 75);
        fieldIndexMap.put(FIELD_WFIDPSDEFID, 76);
        fieldIndexMap.put(FIELD_WFIDPSDEFNAME, 77);
        fieldIndexMap.put(FIELD_WFINSTPSDEFID, 78);
        fieldIndexMap.put(FIELD_WFINSTPSDEFNAME, 79);
        fieldIndexMap.put(FIELD_WFMODE, 80);
        fieldIndexMap.put(FIELD_WFPROXYMODE, 81);
        fieldIndexMap.put(FIELD_WFRETPSDEFID, 82);
        fieldIndexMap.put(FIELD_WFRETPSDEFNAME, 83);
        fieldIndexMap.put(FIELD_WFSTATEPSDEFID, 84);
        fieldIndexMap.put(FIELD_WFSTATEPSDEFNAME, 85);
        fieldIndexMap.put(FIELD_WFSTEPPSDEFID, 86);
        fieldIndexMap.put(FIELD_WFSTEPPSDEFNAME, 87);
        fieldIndexMap.put(FIELD_WFVERPSDEFID, 88);
        fieldIndexMap.put(FIELD_WFVERPSDEFNAME, 89);
    }
}

