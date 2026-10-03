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
package net.ibizsys.pscore.srv.sysdesign.entity;

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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUtilDE;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUtilDEService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysUniStateBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysUniStateBase.class);
    public static final String FIELD_ALLDATAFLAG = "ALLDATAFLAG";
    public static final String FIELD_CACHECAT = "CACHECAT";
    public static final String FIELD_CACHESCOPE = "CACHESCOPE";
    public static final String FIELD_CACHETIMEOUT = "CACHETIMEOUT";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMCODE = "CUSTOMCODE";
    public static final String FIELD_CUSTOMMODE = "CUSTOMMODE";
    public static final String FIELD_DEDEFAULTFLAG = "DEDEFAULTFLAG";
    public static final String FIELD_DELETEASUPDATE = "DELETEASUPDATE";
    public static final String FIELD_INITPSDELOGICID = "INITPSDELOGICID";
    public static final String FIELD_INITPSDELOGICNAME = "INITPSDELOGICNAME";
    public static final String FIELD_KEY2PSDEFID = "KEY2PSDEFID";
    public static final String FIELD_KEY2PSDEFNAME = "KEY2PSDEFNAME";
    public static final String FIELD_KEY3PSDEFID = "KEY3PSDEFID";
    public static final String FIELD_KEY3PSDEFNAME = "KEY3PSDEFNAME";
    public static final String FIELD_KEY4PSDEFID = "KEY4PSDEFID";
    public static final String FIELD_KEY4PSDEFNAME = "KEY4PSDEFNAME";
    public static final String FIELD_KEY5PSDEFID = "KEY5PSDEFID";
    public static final String FIELD_KEY5PSDEFNAME = "KEY5PSDEFNAME";
    public static final String FIELD_KEY6PSDEFID = "KEY6PSDEFID";
    public static final String FIELD_KEY6PSDEFNAME = "KEY6PSDEFNAME";
    public static final String FIELD_KEY7PSDEFID = "KEY7PSDEFID";
    public static final String FIELD_KEY7PSDEFNAME = "KEY7PSDEFNAME";
    public static final String FIELD_KEY8PSDEFID = "KEY8PSDEFID";
    public static final String FIELD_KEY8PSDEFNAME = "KEY8PSDEFNAME";
    public static final String FIELD_KEY9PSDEFID = "KEY9PSDEFID";
    public static final String FIELD_KEY9PSDEFNAME = "KEY9PSDEFNAME";
    public static final String FIELD_KEYFORMAT = "KEYFORMAT";
    public static final String FIELD_KEYPSDEFID = "KEYPSDEFID";
    public static final String FIELD_KEYPSDEFNAME = "KEYPSDEFNAME";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MONITORFORMAT = "MONITORFORMAT";
    public static final String FIELD_ONCHANGEPSDELOGICID = "ONCHANGEPSDELOGICID";
    public static final String FIELD_ONCHANGEPSDELOGICNAME = "ONCHANGEPSDELOGICNAME";
    public static final String FIELD_ONDELETEPSDELOGICID = "ONDELETEPSDELOGICID";
    public static final String FIELD_ONDELETEPSDELOGICNAME = "ONDELETEPSDELOGICNAME";
    public static final String FIELD_PSDEDATASETID = "PSDEDATASETID";
    public static final String FIELD_PSDEDATASETNAME = "PSDEDATASETNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String FIELD_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_PSSYSUNISTATEID = "PSSYSUNISTATEID";
    public static final String FIELD_PSSYSUNISTATENAME = "PSSYSUNISTATENAME";
    public static final String FIELD_PSSYSUTILDEID = "PSSYSUTILDEID";
    public static final String FIELD_PSSYSUTILDENAME = "PSSYSUTILDENAME";
    public static final String FIELD_RELOADTIMER = "RELOADTIMER";
    public static final String FIELD_STATE2PSDEFID = "STATE2PSDEFID";
    public static final String FIELD_STATE2PSDEFNAME = "STATE2PSDEFNAME";
    public static final String FIELD_STATE3PSDEFID = "STATE3PSDEFID";
    public static final String FIELD_STATE3PSDEFNAME = "STATE3PSDEFNAME";
    public static final String FIELD_STATE4PSDEFID = "STATE4PSDEFID";
    public static final String FIELD_STATE4PSDEFNAME = "STATE4PSDEFNAME";
    public static final String FIELD_STATE5PSDEFID = "STATE5PSDEFID";
    public static final String FIELD_STATE5PSDEFNAME = "STATE5PSDEFNAME";
    public static final String FIELD_STATE6PSDEFID = "STATE6PSDEFID";
    public static final String FIELD_STATE6PSDEFNAME = "STATE6PSDEFNAME";
    public static final String FIELD_STATE7PSDEFID = "STATE7PSDEFID";
    public static final String FIELD_STATE7PSDEFNAME = "STATE7PSDEFNAME";
    public static final String FIELD_STATE8PSDEFID = "STATE8PSDEFID";
    public static final String FIELD_STATE8PSDEFNAME = "STATE8PSDEFNAME";
    public static final String FIELD_STATEPSDEFID = "STATEPSDEFID";
    public static final String FIELD_STATEPSDEFNAME = "STATEPSDEFNAME";
    public static final String FIELD_UNIQUETAG = "UNIQUETAG";
    public static final String FIELD_UNISTATEMODE = "UNISTATEMODE";
    public static final String FIELD_UNISTATEPARAMS = "UNISTATEPARAMS";
    public static final String FIELD_UNISTATETAG = "UNISTATETAG";
    public static final String FIELD_UNISTATETAG2 = "UNISTATETAG2";
    public static final String FIELD_UNISTATETYPE = "UNISTATETYPE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_ALLDATAFLAG = 0;
    private static final int INDEX_CACHECAT = 1;
    private static final int INDEX_CACHESCOPE = 2;
    private static final int INDEX_CACHETIMEOUT = 3;
    private static final int INDEX_CREATEDATE = 4;
    private static final int INDEX_CREATEMAN = 5;
    private static final int INDEX_CUSTOMCODE = 6;
    private static final int INDEX_CUSTOMMODE = 7;
    private static final int INDEX_DEDEFAULTFLAG = 8;
    private static final int INDEX_DELETEASUPDATE = 9;
    private static final int INDEX_INITPSDELOGICID = 10;
    private static final int INDEX_INITPSDELOGICNAME = 11;
    private static final int INDEX_KEY2PSDEFID = 12;
    private static final int INDEX_KEY2PSDEFNAME = 13;
    private static final int INDEX_KEY3PSDEFID = 14;
    private static final int INDEX_KEY3PSDEFNAME = 15;
    private static final int INDEX_KEY4PSDEFID = 16;
    private static final int INDEX_KEY4PSDEFNAME = 17;
    private static final int INDEX_KEY5PSDEFID = 18;
    private static final int INDEX_KEY5PSDEFNAME = 19;
    private static final int INDEX_KEY6PSDEFID = 20;
    private static final int INDEX_KEY6PSDEFNAME = 21;
    private static final int INDEX_KEY7PSDEFID = 22;
    private static final int INDEX_KEY7PSDEFNAME = 23;
    private static final int INDEX_KEY8PSDEFID = 24;
    private static final int INDEX_KEY8PSDEFNAME = 25;
    private static final int INDEX_KEY9PSDEFID = 26;
    private static final int INDEX_KEY9PSDEFNAME = 27;
    private static final int INDEX_KEYFORMAT = 28;
    private static final int INDEX_KEYPSDEFID = 29;
    private static final int INDEX_KEYPSDEFNAME = 30;
    private static final int INDEX_LOCKFLAG = 31;
    private static final int INDEX_MEMO = 32;
    private static final int INDEX_MONITORFORMAT = 33;
    private static final int INDEX_ONCHANGEPSDELOGICID = 34;
    private static final int INDEX_ONCHANGEPSDELOGICNAME = 35;
    private static final int INDEX_ONDELETEPSDELOGICID = 36;
    private static final int INDEX_ONDELETEPSDELOGICNAME = 37;
    private static final int INDEX_PSDEDATASETID = 38;
    private static final int INDEX_PSDEDATASETNAME = 39;
    private static final int INDEX_PSDEID = 40;
    private static final int INDEX_PSDENAME = 41;
    private static final int INDEX_PSMODULEID = 42;
    private static final int INDEX_PSMODULENAME = 43;
    private static final int INDEX_PSSYSSFPLUGINID = 44;
    private static final int INDEX_PSSYSSFPLUGINNAME = 45;
    private static final int INDEX_PSSYSTEMID = 46;
    private static final int INDEX_PSSYSTEMNAME = 47;
    private static final int INDEX_PSSYSUNISTATEID = 48;
    private static final int INDEX_PSSYSUNISTATENAME = 49;
    private static final int INDEX_PSSYSUTILDEID = 50;
    private static final int INDEX_PSSYSUTILDENAME = 51;
    private static final int INDEX_RELOADTIMER = 52;
    private static final int INDEX_STATE2PSDEFID = 53;
    private static final int INDEX_STATE2PSDEFNAME = 54;
    private static final int INDEX_STATE3PSDEFID = 55;
    private static final int INDEX_STATE3PSDEFNAME = 56;
    private static final int INDEX_STATE4PSDEFID = 57;
    private static final int INDEX_STATE4PSDEFNAME = 58;
    private static final int INDEX_STATE5PSDEFID = 59;
    private static final int INDEX_STATE5PSDEFNAME = 60;
    private static final int INDEX_STATE6PSDEFID = 61;
    private static final int INDEX_STATE6PSDEFNAME = 62;
    private static final int INDEX_STATE7PSDEFID = 63;
    private static final int INDEX_STATE7PSDEFNAME = 64;
    private static final int INDEX_STATE8PSDEFID = 65;
    private static final int INDEX_STATE8PSDEFNAME = 66;
    private static final int INDEX_STATEPSDEFID = 67;
    private static final int INDEX_STATEPSDEFNAME = 68;
    private static final int INDEX_UNIQUETAG = 69;
    private static final int INDEX_UNISTATEMODE = 70;
    private static final int INDEX_UNISTATEPARAMS = 71;
    private static final int INDEX_UNISTATETAG = 72;
    private static final int INDEX_UNISTATETAG2 = 73;
    private static final int INDEX_UNISTATETYPE = 74;
    private static final int INDEX_UPDATEDATE = 75;
    private static final int INDEX_UPDATEMAN = 76;
    private static final int INDEX_USERCAT = 77;
    private static final int INDEX_USERTAG = 78;
    private static final int INDEX_USERTAG2 = 79;
    private static final int INDEX_USERTAG3 = 80;
    private static final int INDEX_USERTAG4 = 81;
    private static final int INDEX_VALIDFLAG = 82;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysUniStateBase proxyPSSysUniStateBase = null;
    private boolean alldataflagDirtyFlag = false;
    private boolean cachecatDirtyFlag = false;
    private boolean cachescopeDirtyFlag = false;
    private boolean cachetimeoutDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customcodeDirtyFlag = false;
    private boolean custommodeDirtyFlag = false;
    private boolean dedefaultflagDirtyFlag = false;
    private boolean deleteasupdateDirtyFlag = false;
    private boolean initpsdelogicidDirtyFlag = false;
    private boolean initpsdelogicnameDirtyFlag = false;
    private boolean key2psdefidDirtyFlag = false;
    private boolean key2psdefnameDirtyFlag = false;
    private boolean key3psdefidDirtyFlag = false;
    private boolean key3psdefnameDirtyFlag = false;
    private boolean key4psdefidDirtyFlag = false;
    private boolean key4psdefnameDirtyFlag = false;
    private boolean key5psdefidDirtyFlag = false;
    private boolean key5psdefnameDirtyFlag = false;
    private boolean key6psdefidDirtyFlag = false;
    private boolean key6psdefnameDirtyFlag = false;
    private boolean key7psdefidDirtyFlag = false;
    private boolean key7psdefnameDirtyFlag = false;
    private boolean key8psdefidDirtyFlag = false;
    private boolean key8psdefnameDirtyFlag = false;
    private boolean key9psdefidDirtyFlag = false;
    private boolean key9psdefnameDirtyFlag = false;
    private boolean keyformatDirtyFlag = false;
    private boolean keypsdefidDirtyFlag = false;
    private boolean keypsdefnameDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean monitorformatDirtyFlag = false;
    private boolean onchangepsdelogicidDirtyFlag = false;
    private boolean onchangepsdelogicnameDirtyFlag = false;
    private boolean ondeletepsdelogicidDirtyFlag = false;
    private boolean ondeletepsdelogicnameDirtyFlag = false;
    private boolean psdedatasetidDirtyFlag = false;
    private boolean psdedatasetnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssyssfpluginidDirtyFlag = false;
    private boolean pssyssfpluginnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean pssysunistateidDirtyFlag = false;
    private boolean pssysunistatenameDirtyFlag = false;
    private boolean pssysutildeidDirtyFlag = false;
    private boolean pssysutildenameDirtyFlag = false;
    private boolean reloadtimerDirtyFlag = false;
    private boolean state2psdefidDirtyFlag = false;
    private boolean state2psdefnameDirtyFlag = false;
    private boolean state3psdefidDirtyFlag = false;
    private boolean state3psdefnameDirtyFlag = false;
    private boolean state4psdefidDirtyFlag = false;
    private boolean state4psdefnameDirtyFlag = false;
    private boolean state5psdefidDirtyFlag = false;
    private boolean state5psdefnameDirtyFlag = false;
    private boolean state6psdefidDirtyFlag = false;
    private boolean state6psdefnameDirtyFlag = false;
    private boolean state7psdefidDirtyFlag = false;
    private boolean state7psdefnameDirtyFlag = false;
    private boolean state8psdefidDirtyFlag = false;
    private boolean state8psdefnameDirtyFlag = false;
    private boolean statepsdefidDirtyFlag = false;
    private boolean statepsdefnameDirtyFlag = false;
    private boolean uniquetagDirtyFlag = false;
    private boolean unistatemodeDirtyFlag = false;
    private boolean unistateparamsDirtyFlag = false;
    private boolean unistatetagDirtyFlag = false;
    private boolean unistatetag2DirtyFlag = false;
    private boolean unistatetypeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="alldataflag")
    private Integer alldataflag;
    @Column(name="cachecat")
    private String cachecat;
    @Column(name="cachescope")
    private String cachescope;
    @Column(name="cachetimeout")
    private Integer cachetimeout;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="customcode")
    private String customcode;
    @Column(name="custommode")
    private Integer custommode;
    @Column(name="dedefaultflag")
    private Integer dedefaultflag;
    @Column(name="deleteasupdate")
    private Integer deleteasupdate;
    @Column(name="initpsdelogicid")
    private String initpsdelogicid;
    @Column(name="initpsdelogicname")
    private String initpsdelogicname;
    @Column(name="key2psdefid")
    private String key2psdefid;
    @Column(name="key2psdefname")
    private String key2psdefname;
    @Column(name="key3psdefid")
    private String key3psdefid;
    @Column(name="key3psdefname")
    private String key3psdefname;
    @Column(name="key4psdefid")
    private String key4psdefid;
    @Column(name="key4psdefname")
    private String key4psdefname;
    @Column(name="key5psdefid")
    private String key5psdefid;
    @Column(name="key5psdefname")
    private String key5psdefname;
    @Column(name="key6psdefid")
    private String key6psdefid;
    @Column(name="key6psdefname")
    private String key6psdefname;
    @Column(name="key7psdefid")
    private String key7psdefid;
    @Column(name="key7psdefname")
    private String key7psdefname;
    @Column(name="key8psdefid")
    private String key8psdefid;
    @Column(name="key8psdefname")
    private String key8psdefname;
    @Column(name="key9psdefid")
    private String key9psdefid;
    @Column(name="key9psdefname")
    private String key9psdefname;
    @Column(name="keyformat")
    private String keyformat;
    @Column(name="keypsdefid")
    private String keypsdefid;
    @Column(name="keypsdefname")
    private String keypsdefname;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="memo")
    private String memo;
    @Column(name="monitorformat")
    private String monitorformat;
    @Column(name="onchangepsdelogicid")
    private String onchangepsdelogicid;
    @Column(name="onchangepsdelogicname")
    private String onchangepsdelogicname;
    @Column(name="ondeletepsdelogicid")
    private String ondeletepsdelogicid;
    @Column(name="ondeletepsdelogicname")
    private String ondeletepsdelogicname;
    @Column(name="psdedatasetid")
    private String psdedatasetid;
    @Column(name="psdedatasetname")
    private String psdedatasetname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssyssfpluginid")
    private String pssyssfpluginid;
    @Column(name="pssyssfpluginname")
    private String pssyssfpluginname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="pssysunistateid")
    private String pssysunistateid;
    @Column(name="pssysunistatename")
    private String pssysunistatename;
    @Column(name="pssysutildeid")
    private String pssysutildeid;
    @Column(name="pssysutildename")
    private String pssysutildename;
    @Column(name="reloadtimer")
    private Integer reloadtimer;
    @Column(name="state2psdefid")
    private String state2psdefid;
    @Column(name="state2psdefname")
    private String state2psdefname;
    @Column(name="state3psdefid")
    private String state3psdefid;
    @Column(name="state3psdefname")
    private String state3psdefname;
    @Column(name="state4psdefid")
    private String state4psdefid;
    @Column(name="state4psdefname")
    private String state4psdefname;
    @Column(name="state5psdefid")
    private String state5psdefid;
    @Column(name="state5psdefname")
    private String state5psdefname;
    @Column(name="state6psdefid")
    private String state6psdefid;
    @Column(name="state6psdefname")
    private String state6psdefname;
    @Column(name="state7psdefid")
    private String state7psdefid;
    @Column(name="state7psdefname")
    private String state7psdefname;
    @Column(name="state8psdefid")
    private String state8psdefid;
    @Column(name="state8psdefname")
    private String state8psdefname;
    @Column(name="statepsdefid")
    private String statepsdefid;
    @Column(name="statepsdefname")
    private String statepsdefname;
    @Column(name="uniquetag")
    private String uniquetag;
    @Column(name="unistatemode")
    private String unistatemode;
    @Column(name="unistateparams")
    private String unistateparams;
    @Column(name="unistatetag")
    private String unistatetag;
    @Column(name="unistatetag2")
    private String unistatetag2;
    @Column(name="unistatetype")
    private String unistatetype;
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
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSDEDataSetLock = new Integer(1);
    private PSDEDataSet psdedataset = null;
    private Integer objKey2PSDEFLock = new Integer(1);
    private PSDEField key2psdef = null;
    private Integer objKey3PSDEFLock = new Integer(1);
    private PSDEField key3psdef = null;
    private Integer objKey4PSDEFLock = new Integer(1);
    private PSDEField key4psdef = null;
    private Integer objKey5PSDEFLock = new Integer(1);
    private PSDEField key5psdef = null;
    private Integer objKey6PSDEFLock = new Integer(1);
    private PSDEField key6psdef = null;
    private Integer objKey7PSDEFLock = new Integer(1);
    private PSDEField key7psdef = null;
    private Integer objKey8PSDEFLock = new Integer(1);
    private PSDEField key8psdef = null;
    private Integer objKey9PSDEFLock = new Integer(1);
    private PSDEField key9psdef = null;
    private Integer objKeyPSDEFLock = new Integer(1);
    private PSDEField keypsdef = null;
    private Integer objState2PSDEFLock = new Integer(1);
    private PSDEField state2psdef = null;
    private Integer objState3PSDEFLock = new Integer(1);
    private PSDEField state3psdef = null;
    private Integer objState4PSDEFLock = new Integer(1);
    private PSDEField state4psdef = null;
    private Integer objState5PSDEFLock = new Integer(1);
    private PSDEField state5psdef = null;
    private Integer objState6PSDEFLock = new Integer(1);
    private PSDEField state6psdef = null;
    private Integer objState7PSDEFLock = new Integer(1);
    private PSDEField state7psdef = null;
    private Integer objState8PSDEFLock = new Integer(1);
    private PSDEField state8psdef = null;
    private Integer objStatePSDEFLock = new Integer(1);
    private PSDEField statepsdef = null;
    private Integer objInitPSDELogicLock = new Integer(1);
    private PSDELogic initpsdelogic = null;
    private Integer objOnChangePSDELogicLock = new Integer(1);
    private PSDELogic onchangepsdelogic = null;
    private Integer objOnDeletePSDELogicLock = new Integer(1);
    private PSDELogic ondeletepsdelogic = null;
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objPSSysSFPluginLock = new Integer(1);
    private PSSysSFPlugin pssyssfplugin = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSSysUtilDELock = new Integer(1);
    private PSSysUtilDE pssysutilde = null;

    public void setAllDataFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAllDataFlag(n);
            return;
        }
        this.alldataflag = n;
        this.alldataflagDirtyFlag = true;
    }

    public Integer getAllDataFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAllDataFlag();
        }
        return this.alldataflag;
    }

    public boolean isAllDataFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAllDataFlagDirty();
        }
        return this.alldataflagDirtyFlag;
    }

    public void resetAllDataFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAllDataFlag();
            return;
        }
        this.alldataflagDirtyFlag = false;
        this.alldataflag = null;
    }

    public void setCacheCat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCacheCat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cachecat = string;
        this.cachecatDirtyFlag = true;
    }

    public String getCacheCat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCacheCat();
        }
        return this.cachecat;
    }

    public boolean isCacheCatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCacheCatDirty();
        }
        return this.cachecatDirtyFlag;
    }

    public void resetCacheCat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCacheCat();
            return;
        }
        this.cachecatDirtyFlag = false;
        this.cachecat = null;
    }

    public void setCacheScope(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCacheScope(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cachescope = string;
        this.cachescopeDirtyFlag = true;
    }

    public String getCacheScope() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCacheScope();
        }
        return this.cachescope;
    }

    public boolean isCacheScopeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCacheScopeDirty();
        }
        return this.cachescopeDirtyFlag;
    }

    public void resetCacheScope() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCacheScope();
            return;
        }
        this.cachescopeDirtyFlag = false;
        this.cachescope = null;
    }

    public void setCacheTimeout(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCacheTimeout(n);
            return;
        }
        this.cachetimeout = n;
        this.cachetimeoutDirtyFlag = true;
    }

    public Integer getCacheTimeout() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCacheTimeout();
        }
        return this.cachetimeout;
    }

    public boolean isCacheTimeoutDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCacheTimeoutDirty();
        }
        return this.cachetimeoutDirtyFlag;
    }

    public void resetCacheTimeout() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCacheTimeout();
            return;
        }
        this.cachetimeoutDirtyFlag = false;
        this.cachetimeout = null;
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

    public void setDEDefaultFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEDefaultFlag(n);
            return;
        }
        this.dedefaultflag = n;
        this.dedefaultflagDirtyFlag = true;
    }

    public Integer getDEDefaultFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEDefaultFlag();
        }
        return this.dedefaultflag;
    }

    public boolean isDEDefaultFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEDefaultFlagDirty();
        }
        return this.dedefaultflagDirtyFlag;
    }

    public void resetDEDefaultFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEDefaultFlag();
            return;
        }
        this.dedefaultflagDirtyFlag = false;
        this.dedefaultflag = null;
    }

    public void setDeleteAsUpdate(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDeleteAsUpdate(n);
            return;
        }
        this.deleteasupdate = n;
        this.deleteasupdateDirtyFlag = true;
    }

    public Integer getDeleteAsUpdate() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDeleteAsUpdate();
        }
        return this.deleteasupdate;
    }

    public boolean isDeleteAsUpdateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDeleteAsUpdateDirty();
        }
        return this.deleteasupdateDirtyFlag;
    }

    public void resetDeleteAsUpdate() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDeleteAsUpdate();
            return;
        }
        this.deleteasupdateDirtyFlag = false;
        this.deleteasupdate = null;
    }

    public void setInitPSDELogicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInitPSDELogicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.initpsdelogicid = string;
        this.initpsdelogicidDirtyFlag = true;
    }

    public String getInitPSDELogicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInitPSDELogicId();
        }
        return this.initpsdelogicid;
    }

    public boolean isInitPSDELogicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInitPSDELogicIdDirty();
        }
        return this.initpsdelogicidDirtyFlag;
    }

    public void resetInitPSDELogicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInitPSDELogicId();
            return;
        }
        this.initpsdelogicidDirtyFlag = false;
        this.initpsdelogicid = null;
    }

    public void setInitPSDELogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInitPSDELogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.initpsdelogicname = string;
        this.initpsdelogicnameDirtyFlag = true;
    }

    public String getInitPSDELogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInitPSDELogicName();
        }
        return this.initpsdelogicname;
    }

    public boolean isInitPSDELogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInitPSDELogicNameDirty();
        }
        return this.initpsdelogicnameDirtyFlag;
    }

    public void resetInitPSDELogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInitPSDELogicName();
            return;
        }
        this.initpsdelogicnameDirtyFlag = false;
        this.initpsdelogicname = null;
    }

    public void setKey2PSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setKey2PSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.key2psdefid = string;
        this.key2psdefidDirtyFlag = true;
    }

    public String getKey2PSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getKey2PSDEFId();
        }
        return this.key2psdefid;
    }

    public boolean isKey2PSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isKey2PSDEFIdDirty();
        }
        return this.key2psdefidDirtyFlag;
    }

    public void resetKey2PSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetKey2PSDEFId();
            return;
        }
        this.key2psdefidDirtyFlag = false;
        this.key2psdefid = null;
    }

    public void setKey2PSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setKey2PSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.key2psdefname = string;
        this.key2psdefnameDirtyFlag = true;
    }

    public String getKey2PSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getKey2PSDEFName();
        }
        return this.key2psdefname;
    }

    public boolean isKey2PSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isKey2PSDEFNameDirty();
        }
        return this.key2psdefnameDirtyFlag;
    }

    public void resetKey2PSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetKey2PSDEFName();
            return;
        }
        this.key2psdefnameDirtyFlag = false;
        this.key2psdefname = null;
    }

    public void setKey3PSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setKey3PSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.key3psdefid = string;
        this.key3psdefidDirtyFlag = true;
    }

    public String getKey3PSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getKey3PSDEFId();
        }
        return this.key3psdefid;
    }

    public boolean isKey3PSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isKey3PSDEFIdDirty();
        }
        return this.key3psdefidDirtyFlag;
    }

    public void resetKey3PSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetKey3PSDEFId();
            return;
        }
        this.key3psdefidDirtyFlag = false;
        this.key3psdefid = null;
    }

    public void setKey3PSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setKey3PSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.key3psdefname = string;
        this.key3psdefnameDirtyFlag = true;
    }

    public String getKey3PSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getKey3PSDEFName();
        }
        return this.key3psdefname;
    }

    public boolean isKey3PSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isKey3PSDEFNameDirty();
        }
        return this.key3psdefnameDirtyFlag;
    }

    public void resetKey3PSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetKey3PSDEFName();
            return;
        }
        this.key3psdefnameDirtyFlag = false;
        this.key3psdefname = null;
    }

    public void setKey4PSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setKey4PSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.key4psdefid = string;
        this.key4psdefidDirtyFlag = true;
    }

    public String getKey4PSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getKey4PSDEFId();
        }
        return this.key4psdefid;
    }

    public boolean isKey4PSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isKey4PSDEFIdDirty();
        }
        return this.key4psdefidDirtyFlag;
    }

    public void resetKey4PSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetKey4PSDEFId();
            return;
        }
        this.key4psdefidDirtyFlag = false;
        this.key4psdefid = null;
    }

    public void setKey4PSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setKey4PSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.key4psdefname = string;
        this.key4psdefnameDirtyFlag = true;
    }

    public String getKey4PSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getKey4PSDEFName();
        }
        return this.key4psdefname;
    }

    public boolean isKey4PSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isKey4PSDEFNameDirty();
        }
        return this.key4psdefnameDirtyFlag;
    }

    public void resetKey4PSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetKey4PSDEFName();
            return;
        }
        this.key4psdefnameDirtyFlag = false;
        this.key4psdefname = null;
    }

    public void setKey5PSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setKey5PSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.key5psdefid = string;
        this.key5psdefidDirtyFlag = true;
    }

    public String getKey5PSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getKey5PSDEFId();
        }
        return this.key5psdefid;
    }

    public boolean isKey5PSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isKey5PSDEFIdDirty();
        }
        return this.key5psdefidDirtyFlag;
    }

    public void resetKey5PSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetKey5PSDEFId();
            return;
        }
        this.key5psdefidDirtyFlag = false;
        this.key5psdefid = null;
    }

    public void setKey5PSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setKey5PSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.key5psdefname = string;
        this.key5psdefnameDirtyFlag = true;
    }

    public String getKey5PSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getKey5PSDEFName();
        }
        return this.key5psdefname;
    }

    public boolean isKey5PSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isKey5PSDEFNameDirty();
        }
        return this.key5psdefnameDirtyFlag;
    }

    public void resetKey5PSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetKey5PSDEFName();
            return;
        }
        this.key5psdefnameDirtyFlag = false;
        this.key5psdefname = null;
    }

    public void setKey6PSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setKey6PSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.key6psdefid = string;
        this.key6psdefidDirtyFlag = true;
    }

    public String getKey6PSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getKey6PSDEFId();
        }
        return this.key6psdefid;
    }

    public boolean isKey6PSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isKey6PSDEFIdDirty();
        }
        return this.key6psdefidDirtyFlag;
    }

    public void resetKey6PSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetKey6PSDEFId();
            return;
        }
        this.key6psdefidDirtyFlag = false;
        this.key6psdefid = null;
    }

    public void setKey6PSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setKey6PSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.key6psdefname = string;
        this.key6psdefnameDirtyFlag = true;
    }

    public String getKey6PSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getKey6PSDEFName();
        }
        return this.key6psdefname;
    }

    public boolean isKey6PSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isKey6PSDEFNameDirty();
        }
        return this.key6psdefnameDirtyFlag;
    }

    public void resetKey6PSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetKey6PSDEFName();
            return;
        }
        this.key6psdefnameDirtyFlag = false;
        this.key6psdefname = null;
    }

    public void setKey7PSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setKey7PSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.key7psdefid = string;
        this.key7psdefidDirtyFlag = true;
    }

    public String getKey7PSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getKey7PSDEFId();
        }
        return this.key7psdefid;
    }

    public boolean isKey7PSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isKey7PSDEFIdDirty();
        }
        return this.key7psdefidDirtyFlag;
    }

    public void resetKey7PSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetKey7PSDEFId();
            return;
        }
        this.key7psdefidDirtyFlag = false;
        this.key7psdefid = null;
    }

    public void setKey7PSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setKey7PSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.key7psdefname = string;
        this.key7psdefnameDirtyFlag = true;
    }

    public String getKey7PSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getKey7PSDEFName();
        }
        return this.key7psdefname;
    }

    public boolean isKey7PSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isKey7PSDEFNameDirty();
        }
        return this.key7psdefnameDirtyFlag;
    }

    public void resetKey7PSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetKey7PSDEFName();
            return;
        }
        this.key7psdefnameDirtyFlag = false;
        this.key7psdefname = null;
    }

    public void setKey8PSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setKey8PSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.key8psdefid = string;
        this.key8psdefidDirtyFlag = true;
    }

    public String getKey8PSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getKey8PSDEFId();
        }
        return this.key8psdefid;
    }

    public boolean isKey8PSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isKey8PSDEFIdDirty();
        }
        return this.key8psdefidDirtyFlag;
    }

    public void resetKey8PSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetKey8PSDEFId();
            return;
        }
        this.key8psdefidDirtyFlag = false;
        this.key8psdefid = null;
    }

    public void setKey8PSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setKey8PSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.key8psdefname = string;
        this.key8psdefnameDirtyFlag = true;
    }

    public String getKey8PSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getKey8PSDEFName();
        }
        return this.key8psdefname;
    }

    public boolean isKey8PSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isKey8PSDEFNameDirty();
        }
        return this.key8psdefnameDirtyFlag;
    }

    public void resetKey8PSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetKey8PSDEFName();
            return;
        }
        this.key8psdefnameDirtyFlag = false;
        this.key8psdefname = null;
    }

    public void setKey9PSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setKey9PSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.key9psdefid = string;
        this.key9psdefidDirtyFlag = true;
    }

    public String getKey9PSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getKey9PSDEFId();
        }
        return this.key9psdefid;
    }

    public boolean isKey9PSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isKey9PSDEFIdDirty();
        }
        return this.key9psdefidDirtyFlag;
    }

    public void resetKey9PSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetKey9PSDEFId();
            return;
        }
        this.key9psdefidDirtyFlag = false;
        this.key9psdefid = null;
    }

    public void setKey9PSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setKey9PSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.key9psdefname = string;
        this.key9psdefnameDirtyFlag = true;
    }

    public String getKey9PSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getKey9PSDEFName();
        }
        return this.key9psdefname;
    }

    public boolean isKey9PSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isKey9PSDEFNameDirty();
        }
        return this.key9psdefnameDirtyFlag;
    }

    public void resetKey9PSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetKey9PSDEFName();
            return;
        }
        this.key9psdefnameDirtyFlag = false;
        this.key9psdefname = null;
    }

    public void setKeyFormat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setKeyFormat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.keyformat = string;
        this.keyformatDirtyFlag = true;
    }

    public String getKeyFormat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getKeyFormat();
        }
        return this.keyformat;
    }

    public boolean isKeyFormatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isKeyFormatDirty();
        }
        return this.keyformatDirtyFlag;
    }

    public void resetKeyFormat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetKeyFormat();
            return;
        }
        this.keyformatDirtyFlag = false;
        this.keyformat = null;
    }

    public void setKeyPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setKeyPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.keypsdefid = string;
        this.keypsdefidDirtyFlag = true;
    }

    public String getKeyPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getKeyPSDEFId();
        }
        return this.keypsdefid;
    }

    public boolean isKeyPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isKeyPSDEFIdDirty();
        }
        return this.keypsdefidDirtyFlag;
    }

    public void resetKeyPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetKeyPSDEFId();
            return;
        }
        this.keypsdefidDirtyFlag = false;
        this.keypsdefid = null;
    }

    public void setKeyPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setKeyPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.keypsdefname = string;
        this.keypsdefnameDirtyFlag = true;
    }

    public String getKeyPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getKeyPSDEFName();
        }
        return this.keypsdefname;
    }

    public boolean isKeyPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isKeyPSDEFNameDirty();
        }
        return this.keypsdefnameDirtyFlag;
    }

    public void resetKeyPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetKeyPSDEFName();
            return;
        }
        this.keypsdefnameDirtyFlag = false;
        this.keypsdefname = null;
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

    public void setMonitorFormat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMonitorFormat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.monitorformat = string;
        this.monitorformatDirtyFlag = true;
    }

    public String getMonitorFormat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMonitorFormat();
        }
        return this.monitorformat;
    }

    public boolean isMonitorFormatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMonitorFormatDirty();
        }
        return this.monitorformatDirtyFlag;
    }

    public void resetMonitorFormat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMonitorFormat();
            return;
        }
        this.monitorformatDirtyFlag = false;
        this.monitorformat = null;
    }

    public void setOnChangePSDELogicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOnChangePSDELogicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.onchangepsdelogicid = string;
        this.onchangepsdelogicidDirtyFlag = true;
    }

    public String getOnChangePSDELogicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOnChangePSDELogicId();
        }
        return this.onchangepsdelogicid;
    }

    public boolean isOnChangePSDELogicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOnChangePSDELogicIdDirty();
        }
        return this.onchangepsdelogicidDirtyFlag;
    }

    public void resetOnChangePSDELogicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOnChangePSDELogicId();
            return;
        }
        this.onchangepsdelogicidDirtyFlag = false;
        this.onchangepsdelogicid = null;
    }

    public void setOnChangePSDELogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOnChangePSDELogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.onchangepsdelogicname = string;
        this.onchangepsdelogicnameDirtyFlag = true;
    }

    public String getOnChangePSDELogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOnChangePSDELogicName();
        }
        return this.onchangepsdelogicname;
    }

    public boolean isOnChangePSDELogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOnChangePSDELogicNameDirty();
        }
        return this.onchangepsdelogicnameDirtyFlag;
    }

    public void resetOnChangePSDELogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOnChangePSDELogicName();
            return;
        }
        this.onchangepsdelogicnameDirtyFlag = false;
        this.onchangepsdelogicname = null;
    }

    public void setOnDeletePSDELogicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOnDeletePSDELogicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ondeletepsdelogicid = string;
        this.ondeletepsdelogicidDirtyFlag = true;
    }

    public String getOnDeletePSDELogicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOnDeletePSDELogicId();
        }
        return this.ondeletepsdelogicid;
    }

    public boolean isOnDeletePSDELogicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOnDeletePSDELogicIdDirty();
        }
        return this.ondeletepsdelogicidDirtyFlag;
    }

    public void resetOnDeletePSDELogicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOnDeletePSDELogicId();
            return;
        }
        this.ondeletepsdelogicidDirtyFlag = false;
        this.ondeletepsdelogicid = null;
    }

    public void setOnDeletePSDELogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOnDeletePSDELogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ondeletepsdelogicname = string;
        this.ondeletepsdelogicnameDirtyFlag = true;
    }

    public String getOnDeletePSDELogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOnDeletePSDELogicName();
        }
        return this.ondeletepsdelogicname;
    }

    public boolean isOnDeletePSDELogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOnDeletePSDELogicNameDirty();
        }
        return this.ondeletepsdelogicnameDirtyFlag;
    }

    public void resetOnDeletePSDELogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOnDeletePSDELogicName();
            return;
        }
        this.ondeletepsdelogicnameDirtyFlag = false;
        this.ondeletepsdelogicname = null;
    }

    public void setPSDEDataSetId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataSetId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedatasetid = string;
        this.psdedatasetidDirtyFlag = true;
    }

    public String getPSDEDataSetId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataSetId();
        }
        return this.psdedatasetid;
    }

    public boolean isPSDEDataSetIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataSetIdDirty();
        }
        return this.psdedatasetidDirtyFlag;
    }

    public void resetPSDEDataSetId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataSetId();
            return;
        }
        this.psdedatasetidDirtyFlag = false;
        this.psdedatasetid = null;
    }

    public void setPSDEDataSetName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataSetName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedatasetname = string;
        this.psdedatasetnameDirtyFlag = true;
    }

    public String getPSDEDataSetName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataSetName();
        }
        return this.psdedatasetname;
    }

    public boolean isPSDEDataSetNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataSetNameDirty();
        }
        return this.psdedatasetnameDirtyFlag;
    }

    public void resetPSDEDataSetName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataSetName();
            return;
        }
        this.psdedatasetnameDirtyFlag = false;
        this.psdedatasetname = null;
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

    public void setPSSysUniStateId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUniStateId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysunistateid = string;
        this.pssysunistateidDirtyFlag = true;
    }

    public String getPSSysUniStateId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUniStateId();
        }
        return this.pssysunistateid;
    }

    public boolean isPSSysUniStateIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUniStateIdDirty();
        }
        return this.pssysunistateidDirtyFlag;
    }

    public void resetPSSysUniStateId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUniStateId();
            return;
        }
        this.pssysunistateidDirtyFlag = false;
        this.pssysunistateid = null;
    }

    public void setPSSysUniStateName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUniStateName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysunistatename = string;
        this.pssysunistatenameDirtyFlag = true;
    }

    public String getPSSysUniStateName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUniStateName();
        }
        return this.pssysunistatename;
    }

    public boolean isPSSysUniStateNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUniStateNameDirty();
        }
        return this.pssysunistatenameDirtyFlag;
    }

    public void resetPSSysUniStateName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUniStateName();
            return;
        }
        this.pssysunistatenameDirtyFlag = false;
        this.pssysunistatename = null;
    }

    public void setPSSysUtilDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUtilDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysutildeid = string;
        this.pssysutildeidDirtyFlag = true;
    }

    public String getPSSysUtilDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUtilDEId();
        }
        return this.pssysutildeid;
    }

    public boolean isPSSysUtilDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUtilDEIdDirty();
        }
        return this.pssysutildeidDirtyFlag;
    }

    public void resetPSSysUtilDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUtilDEId();
            return;
        }
        this.pssysutildeidDirtyFlag = false;
        this.pssysutildeid = null;
    }

    public void setPSSysUtilDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUtilDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysutildename = string;
        this.pssysutildenameDirtyFlag = true;
    }

    public String getPSSysUtilDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUtilDEName();
        }
        return this.pssysutildename;
    }

    public boolean isPSSysUtilDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUtilDENameDirty();
        }
        return this.pssysutildenameDirtyFlag;
    }

    public void resetPSSysUtilDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUtilDEName();
            return;
        }
        this.pssysutildenameDirtyFlag = false;
        this.pssysutildename = null;
    }

    public void setReloadTimer(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReloadTimer(n);
            return;
        }
        this.reloadtimer = n;
        this.reloadtimerDirtyFlag = true;
    }

    public Integer getReloadTimer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReloadTimer();
        }
        return this.reloadtimer;
    }

    public boolean isReloadTimerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReloadTimerDirty();
        }
        return this.reloadtimerDirtyFlag;
    }

    public void resetReloadTimer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReloadTimer();
            return;
        }
        this.reloadtimerDirtyFlag = false;
        this.reloadtimer = null;
    }

    public void setState2PSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setState2PSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.state2psdefid = string;
        this.state2psdefidDirtyFlag = true;
    }

    public String getState2PSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getState2PSDEFId();
        }
        return this.state2psdefid;
    }

    public boolean isState2PSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isState2PSDEFIdDirty();
        }
        return this.state2psdefidDirtyFlag;
    }

    public void resetState2PSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetState2PSDEFId();
            return;
        }
        this.state2psdefidDirtyFlag = false;
        this.state2psdefid = null;
    }

    public void setState2PSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setState2PSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.state2psdefname = string;
        this.state2psdefnameDirtyFlag = true;
    }

    public String getState2PSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getState2PSDEFName();
        }
        return this.state2psdefname;
    }

    public boolean isState2PSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isState2PSDEFNameDirty();
        }
        return this.state2psdefnameDirtyFlag;
    }

    public void resetState2PSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetState2PSDEFName();
            return;
        }
        this.state2psdefnameDirtyFlag = false;
        this.state2psdefname = null;
    }

    public void setState3PSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setState3PSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.state3psdefid = string;
        this.state3psdefidDirtyFlag = true;
    }

    public String getState3PSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getState3PSDEFId();
        }
        return this.state3psdefid;
    }

    public boolean isState3PSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isState3PSDEFIdDirty();
        }
        return this.state3psdefidDirtyFlag;
    }

    public void resetState3PSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetState3PSDEFId();
            return;
        }
        this.state3psdefidDirtyFlag = false;
        this.state3psdefid = null;
    }

    public void setState3PSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setState3PSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.state3psdefname = string;
        this.state3psdefnameDirtyFlag = true;
    }

    public String getState3PSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getState3PSDEFName();
        }
        return this.state3psdefname;
    }

    public boolean isState3PSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isState3PSDEFNameDirty();
        }
        return this.state3psdefnameDirtyFlag;
    }

    public void resetState3PSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetState3PSDEFName();
            return;
        }
        this.state3psdefnameDirtyFlag = false;
        this.state3psdefname = null;
    }

    public void setState4PSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setState4PSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.state4psdefid = string;
        this.state4psdefidDirtyFlag = true;
    }

    public String getState4PSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getState4PSDEFId();
        }
        return this.state4psdefid;
    }

    public boolean isState4PSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isState4PSDEFIdDirty();
        }
        return this.state4psdefidDirtyFlag;
    }

    public void resetState4PSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetState4PSDEFId();
            return;
        }
        this.state4psdefidDirtyFlag = false;
        this.state4psdefid = null;
    }

    public void setState4PSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setState4PSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.state4psdefname = string;
        this.state4psdefnameDirtyFlag = true;
    }

    public String getState4PSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getState4PSDEFName();
        }
        return this.state4psdefname;
    }

    public boolean isState4PSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isState4PSDEFNameDirty();
        }
        return this.state4psdefnameDirtyFlag;
    }

    public void resetState4PSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetState4PSDEFName();
            return;
        }
        this.state4psdefnameDirtyFlag = false;
        this.state4psdefname = null;
    }

    public void setState5PSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setState5PSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.state5psdefid = string;
        this.state5psdefidDirtyFlag = true;
    }

    public String getState5PSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getState5PSDEFId();
        }
        return this.state5psdefid;
    }

    public boolean isState5PSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isState5PSDEFIdDirty();
        }
        return this.state5psdefidDirtyFlag;
    }

    public void resetState5PSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetState5PSDEFId();
            return;
        }
        this.state5psdefidDirtyFlag = false;
        this.state5psdefid = null;
    }

    public void setState5PSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setState5PSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.state5psdefname = string;
        this.state5psdefnameDirtyFlag = true;
    }

    public String getState5PSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getState5PSDEFName();
        }
        return this.state5psdefname;
    }

    public boolean isState5PSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isState5PSDEFNameDirty();
        }
        return this.state5psdefnameDirtyFlag;
    }

    public void resetState5PSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetState5PSDEFName();
            return;
        }
        this.state5psdefnameDirtyFlag = false;
        this.state5psdefname = null;
    }

    public void setState6PSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setState6PSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.state6psdefid = string;
        this.state6psdefidDirtyFlag = true;
    }

    public String getState6PSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getState6PSDEFId();
        }
        return this.state6psdefid;
    }

    public boolean isState6PSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isState6PSDEFIdDirty();
        }
        return this.state6psdefidDirtyFlag;
    }

    public void resetState6PSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetState6PSDEFId();
            return;
        }
        this.state6psdefidDirtyFlag = false;
        this.state6psdefid = null;
    }

    public void setState6PSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setState6PSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.state6psdefname = string;
        this.state6psdefnameDirtyFlag = true;
    }

    public String getState6PSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getState6PSDEFName();
        }
        return this.state6psdefname;
    }

    public boolean isState6PSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isState6PSDEFNameDirty();
        }
        return this.state6psdefnameDirtyFlag;
    }

    public void resetState6PSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetState6PSDEFName();
            return;
        }
        this.state6psdefnameDirtyFlag = false;
        this.state6psdefname = null;
    }

    public void setState7PSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setState7PSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.state7psdefid = string;
        this.state7psdefidDirtyFlag = true;
    }

    public String getState7PSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getState7PSDEFId();
        }
        return this.state7psdefid;
    }

    public boolean isState7PSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isState7PSDEFIdDirty();
        }
        return this.state7psdefidDirtyFlag;
    }

    public void resetState7PSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetState7PSDEFId();
            return;
        }
        this.state7psdefidDirtyFlag = false;
        this.state7psdefid = null;
    }

    public void setState7PSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setState7PSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.state7psdefname = string;
        this.state7psdefnameDirtyFlag = true;
    }

    public String getState7PSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getState7PSDEFName();
        }
        return this.state7psdefname;
    }

    public boolean isState7PSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isState7PSDEFNameDirty();
        }
        return this.state7psdefnameDirtyFlag;
    }

    public void resetState7PSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetState7PSDEFName();
            return;
        }
        this.state7psdefnameDirtyFlag = false;
        this.state7psdefname = null;
    }

    public void setState8PSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setState8PSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.state8psdefid = string;
        this.state8psdefidDirtyFlag = true;
    }

    public String getState8PSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getState8PSDEFId();
        }
        return this.state8psdefid;
    }

    public boolean isState8PSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isState8PSDEFIdDirty();
        }
        return this.state8psdefidDirtyFlag;
    }

    public void resetState8PSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetState8PSDEFId();
            return;
        }
        this.state8psdefidDirtyFlag = false;
        this.state8psdefid = null;
    }

    public void setState8PSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setState8PSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.state8psdefname = string;
        this.state8psdefnameDirtyFlag = true;
    }

    public String getState8PSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getState8PSDEFName();
        }
        return this.state8psdefname;
    }

    public boolean isState8PSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isState8PSDEFNameDirty();
        }
        return this.state8psdefnameDirtyFlag;
    }

    public void resetState8PSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetState8PSDEFName();
            return;
        }
        this.state8psdefnameDirtyFlag = false;
        this.state8psdefname = null;
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

    public void setUniqueTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUniqueTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.uniquetag = string;
        this.uniquetagDirtyFlag = true;
    }

    public String getUniqueTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUniqueTag();
        }
        return this.uniquetag;
    }

    public boolean isUniqueTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUniqueTagDirty();
        }
        return this.uniquetagDirtyFlag;
    }

    public void resetUniqueTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUniqueTag();
            return;
        }
        this.uniquetagDirtyFlag = false;
        this.uniquetag = null;
    }

    public void setUniStateMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUniStateMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.unistatemode = string;
        this.unistatemodeDirtyFlag = true;
    }

    public String getUniStateMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUniStateMode();
        }
        return this.unistatemode;
    }

    public boolean isUniStateModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUniStateModeDirty();
        }
        return this.unistatemodeDirtyFlag;
    }

    public void resetUniStateMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUniStateMode();
            return;
        }
        this.unistatemodeDirtyFlag = false;
        this.unistatemode = null;
    }

    public void setUniStateParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUniStateParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.unistateparams = string;
        this.unistateparamsDirtyFlag = true;
    }

    public String getUniStateParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUniStateParams();
        }
        return this.unistateparams;
    }

    public boolean isUniStateParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUniStateParamsDirty();
        }
        return this.unistateparamsDirtyFlag;
    }

    public void resetUniStateParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUniStateParams();
            return;
        }
        this.unistateparamsDirtyFlag = false;
        this.unistateparams = null;
    }

    public void setUniStateTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUniStateTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.unistatetag = string;
        this.unistatetagDirtyFlag = true;
    }

    public String getUniStateTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUniStateTag();
        }
        return this.unistatetag;
    }

    public boolean isUniStateTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUniStateTagDirty();
        }
        return this.unistatetagDirtyFlag;
    }

    public void resetUniStateTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUniStateTag();
            return;
        }
        this.unistatetagDirtyFlag = false;
        this.unistatetag = null;
    }

    public void setUniStateTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUniStateTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.unistatetag2 = string;
        this.unistatetag2DirtyFlag = true;
    }

    public String getUniStateTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUniStateTag2();
        }
        return this.unistatetag2;
    }

    public boolean isUniStateTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUniStateTag2Dirty();
        }
        return this.unistatetag2DirtyFlag;
    }

    public void resetUniStateTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUniStateTag2();
            return;
        }
        this.unistatetag2DirtyFlag = false;
        this.unistatetag2 = null;
    }

    public void setUniStateType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUniStateType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.unistatetype = string;
        this.unistatetypeDirtyFlag = true;
    }

    public String getUniStateType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUniStateType();
        }
        return this.unistatetype;
    }

    public boolean isUniStateTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUniStateTypeDirty();
        }
        return this.unistatetypeDirtyFlag;
    }

    public void resetUniStateType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUniStateType();
            return;
        }
        this.unistatetypeDirtyFlag = false;
        this.unistatetype = null;
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

    protected void onReset() {
        PSSysUniStateBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysUniStateBase pSSysUniStateBase) {
        pSSysUniStateBase.resetAllDataFlag();
        pSSysUniStateBase.resetCacheCat();
        pSSysUniStateBase.resetCacheScope();
        pSSysUniStateBase.resetCacheTimeout();
        pSSysUniStateBase.resetCreateDate();
        pSSysUniStateBase.resetCreateMan();
        pSSysUniStateBase.resetCustomCode();
        pSSysUniStateBase.resetCustomMode();
        pSSysUniStateBase.resetDEDefaultFlag();
        pSSysUniStateBase.resetDeleteAsUpdate();
        pSSysUniStateBase.resetInitPSDELogicId();
        pSSysUniStateBase.resetInitPSDELogicName();
        pSSysUniStateBase.resetKey2PSDEFId();
        pSSysUniStateBase.resetKey2PSDEFName();
        pSSysUniStateBase.resetKey3PSDEFId();
        pSSysUniStateBase.resetKey3PSDEFName();
        pSSysUniStateBase.resetKey4PSDEFId();
        pSSysUniStateBase.resetKey4PSDEFName();
        pSSysUniStateBase.resetKey5PSDEFId();
        pSSysUniStateBase.resetKey5PSDEFName();
        pSSysUniStateBase.resetKey6PSDEFId();
        pSSysUniStateBase.resetKey6PSDEFName();
        pSSysUniStateBase.resetKey7PSDEFId();
        pSSysUniStateBase.resetKey7PSDEFName();
        pSSysUniStateBase.resetKey8PSDEFId();
        pSSysUniStateBase.resetKey8PSDEFName();
        pSSysUniStateBase.resetKey9PSDEFId();
        pSSysUniStateBase.resetKey9PSDEFName();
        pSSysUniStateBase.resetKeyFormat();
        pSSysUniStateBase.resetKeyPSDEFId();
        pSSysUniStateBase.resetKeyPSDEFName();
        pSSysUniStateBase.resetLockFlag();
        pSSysUniStateBase.resetMemo();
        pSSysUniStateBase.resetMonitorFormat();
        pSSysUniStateBase.resetOnChangePSDELogicId();
        pSSysUniStateBase.resetOnChangePSDELogicName();
        pSSysUniStateBase.resetOnDeletePSDELogicId();
        pSSysUniStateBase.resetOnDeletePSDELogicName();
        pSSysUniStateBase.resetPSDEDataSetId();
        pSSysUniStateBase.resetPSDEDataSetName();
        pSSysUniStateBase.resetPSDEId();
        pSSysUniStateBase.resetPSDEName();
        pSSysUniStateBase.resetPSModuleId();
        pSSysUniStateBase.resetPSModuleName();
        pSSysUniStateBase.resetPSSysSFPluginId();
        pSSysUniStateBase.resetPSSysSFPluginName();
        pSSysUniStateBase.resetPSSystemId();
        pSSysUniStateBase.resetPSSystemName();
        pSSysUniStateBase.resetPSSysUniStateId();
        pSSysUniStateBase.resetPSSysUniStateName();
        pSSysUniStateBase.resetPSSysUtilDEId();
        pSSysUniStateBase.resetPSSysUtilDEName();
        pSSysUniStateBase.resetReloadTimer();
        pSSysUniStateBase.resetState2PSDEFId();
        pSSysUniStateBase.resetState2PSDEFName();
        pSSysUniStateBase.resetState3PSDEFId();
        pSSysUniStateBase.resetState3PSDEFName();
        pSSysUniStateBase.resetState4PSDEFId();
        pSSysUniStateBase.resetState4PSDEFName();
        pSSysUniStateBase.resetState5PSDEFId();
        pSSysUniStateBase.resetState5PSDEFName();
        pSSysUniStateBase.resetState6PSDEFId();
        pSSysUniStateBase.resetState6PSDEFName();
        pSSysUniStateBase.resetState7PSDEFId();
        pSSysUniStateBase.resetState7PSDEFName();
        pSSysUniStateBase.resetState8PSDEFId();
        pSSysUniStateBase.resetState8PSDEFName();
        pSSysUniStateBase.resetStatePSDEFId();
        pSSysUniStateBase.resetStatePSDEFName();
        pSSysUniStateBase.resetUniqueTag();
        pSSysUniStateBase.resetUniStateMode();
        pSSysUniStateBase.resetUniStateParams();
        pSSysUniStateBase.resetUniStateTag();
        pSSysUniStateBase.resetUniStateTag2();
        pSSysUniStateBase.resetUniStateType();
        pSSysUniStateBase.resetUpdateDate();
        pSSysUniStateBase.resetUpdateMan();
        pSSysUniStateBase.resetUserCat();
        pSSysUniStateBase.resetUserTag();
        pSSysUniStateBase.resetUserTag2();
        pSSysUniStateBase.resetUserTag3();
        pSSysUniStateBase.resetUserTag4();
        pSSysUniStateBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAllDataFlagDirty()) {
            hashMap.put(FIELD_ALLDATAFLAG, this.getAllDataFlag());
        }
        if (!bl || this.isCacheCatDirty()) {
            hashMap.put(FIELD_CACHECAT, this.getCacheCat());
        }
        if (!bl || this.isCacheScopeDirty()) {
            hashMap.put(FIELD_CACHESCOPE, this.getCacheScope());
        }
        if (!bl || this.isCacheTimeoutDirty()) {
            hashMap.put(FIELD_CACHETIMEOUT, this.getCacheTimeout());
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
        if (!bl || this.isDEDefaultFlagDirty()) {
            hashMap.put(FIELD_DEDEFAULTFLAG, this.getDEDefaultFlag());
        }
        if (!bl || this.isDeleteAsUpdateDirty()) {
            hashMap.put(FIELD_DELETEASUPDATE, this.getDeleteAsUpdate());
        }
        if (!bl || this.isInitPSDELogicIdDirty()) {
            hashMap.put(FIELD_INITPSDELOGICID, this.getInitPSDELogicId());
        }
        if (!bl || this.isInitPSDELogicNameDirty()) {
            hashMap.put(FIELD_INITPSDELOGICNAME, this.getInitPSDELogicName());
        }
        if (!bl || this.isKey2PSDEFIdDirty()) {
            hashMap.put(FIELD_KEY2PSDEFID, this.getKey2PSDEFId());
        }
        if (!bl || this.isKey2PSDEFNameDirty()) {
            hashMap.put(FIELD_KEY2PSDEFNAME, this.getKey2PSDEFName());
        }
        if (!bl || this.isKey3PSDEFIdDirty()) {
            hashMap.put(FIELD_KEY3PSDEFID, this.getKey3PSDEFId());
        }
        if (!bl || this.isKey3PSDEFNameDirty()) {
            hashMap.put(FIELD_KEY3PSDEFNAME, this.getKey3PSDEFName());
        }
        if (!bl || this.isKey4PSDEFIdDirty()) {
            hashMap.put(FIELD_KEY4PSDEFID, this.getKey4PSDEFId());
        }
        if (!bl || this.isKey4PSDEFNameDirty()) {
            hashMap.put(FIELD_KEY4PSDEFNAME, this.getKey4PSDEFName());
        }
        if (!bl || this.isKey5PSDEFIdDirty()) {
            hashMap.put(FIELD_KEY5PSDEFID, this.getKey5PSDEFId());
        }
        if (!bl || this.isKey5PSDEFNameDirty()) {
            hashMap.put(FIELD_KEY5PSDEFNAME, this.getKey5PSDEFName());
        }
        if (!bl || this.isKey6PSDEFIdDirty()) {
            hashMap.put(FIELD_KEY6PSDEFID, this.getKey6PSDEFId());
        }
        if (!bl || this.isKey6PSDEFNameDirty()) {
            hashMap.put(FIELD_KEY6PSDEFNAME, this.getKey6PSDEFName());
        }
        if (!bl || this.isKey7PSDEFIdDirty()) {
            hashMap.put(FIELD_KEY7PSDEFID, this.getKey7PSDEFId());
        }
        if (!bl || this.isKey7PSDEFNameDirty()) {
            hashMap.put(FIELD_KEY7PSDEFNAME, this.getKey7PSDEFName());
        }
        if (!bl || this.isKey8PSDEFIdDirty()) {
            hashMap.put(FIELD_KEY8PSDEFID, this.getKey8PSDEFId());
        }
        if (!bl || this.isKey8PSDEFNameDirty()) {
            hashMap.put(FIELD_KEY8PSDEFNAME, this.getKey8PSDEFName());
        }
        if (!bl || this.isKey9PSDEFIdDirty()) {
            hashMap.put(FIELD_KEY9PSDEFID, this.getKey9PSDEFId());
        }
        if (!bl || this.isKey9PSDEFNameDirty()) {
            hashMap.put(FIELD_KEY9PSDEFNAME, this.getKey9PSDEFName());
        }
        if (!bl || this.isKeyFormatDirty()) {
            hashMap.put(FIELD_KEYFORMAT, this.getKeyFormat());
        }
        if (!bl || this.isKeyPSDEFIdDirty()) {
            hashMap.put(FIELD_KEYPSDEFID, this.getKeyPSDEFId());
        }
        if (!bl || this.isKeyPSDEFNameDirty()) {
            hashMap.put(FIELD_KEYPSDEFNAME, this.getKeyPSDEFName());
        }
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMonitorFormatDirty()) {
            hashMap.put(FIELD_MONITORFORMAT, this.getMonitorFormat());
        }
        if (!bl || this.isOnChangePSDELogicIdDirty()) {
            hashMap.put(FIELD_ONCHANGEPSDELOGICID, this.getOnChangePSDELogicId());
        }
        if (!bl || this.isOnChangePSDELogicNameDirty()) {
            hashMap.put(FIELD_ONCHANGEPSDELOGICNAME, this.getOnChangePSDELogicName());
        }
        if (!bl || this.isOnDeletePSDELogicIdDirty()) {
            hashMap.put(FIELD_ONDELETEPSDELOGICID, this.getOnDeletePSDELogicId());
        }
        if (!bl || this.isOnDeletePSDELogicNameDirty()) {
            hashMap.put(FIELD_ONDELETEPSDELOGICNAME, this.getOnDeletePSDELogicName());
        }
        if (!bl || this.isPSDEDataSetIdDirty()) {
            hashMap.put(FIELD_PSDEDATASETID, this.getPSDEDataSetId());
        }
        if (!bl || this.isPSDEDataSetNameDirty()) {
            hashMap.put(FIELD_PSDEDATASETNAME, this.getPSDEDataSetName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSModuleIdDirty()) {
            hashMap.put(FIELD_PSMODULEID, this.getPSModuleId());
        }
        if (!bl || this.isPSModuleNameDirty()) {
            hashMap.put(FIELD_PSMODULENAME, this.getPSModuleName());
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
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
        }
        if (!bl || this.isPSSysUniStateIdDirty()) {
            hashMap.put(FIELD_PSSYSUNISTATEID, this.getPSSysUniStateId());
        }
        if (!bl || this.isPSSysUniStateNameDirty()) {
            hashMap.put(FIELD_PSSYSUNISTATENAME, this.getPSSysUniStateName());
        }
        if (!bl || this.isPSSysUtilDEIdDirty()) {
            hashMap.put(FIELD_PSSYSUTILDEID, this.getPSSysUtilDEId());
        }
        if (!bl || this.isPSSysUtilDENameDirty()) {
            hashMap.put(FIELD_PSSYSUTILDENAME, this.getPSSysUtilDEName());
        }
        if (!bl || this.isReloadTimerDirty()) {
            hashMap.put(FIELD_RELOADTIMER, this.getReloadTimer());
        }
        if (!bl || this.isState2PSDEFIdDirty()) {
            hashMap.put(FIELD_STATE2PSDEFID, this.getState2PSDEFId());
        }
        if (!bl || this.isState2PSDEFNameDirty()) {
            hashMap.put(FIELD_STATE2PSDEFNAME, this.getState2PSDEFName());
        }
        if (!bl || this.isState3PSDEFIdDirty()) {
            hashMap.put(FIELD_STATE3PSDEFID, this.getState3PSDEFId());
        }
        if (!bl || this.isState3PSDEFNameDirty()) {
            hashMap.put(FIELD_STATE3PSDEFNAME, this.getState3PSDEFName());
        }
        if (!bl || this.isState4PSDEFIdDirty()) {
            hashMap.put(FIELD_STATE4PSDEFID, this.getState4PSDEFId());
        }
        if (!bl || this.isState4PSDEFNameDirty()) {
            hashMap.put(FIELD_STATE4PSDEFNAME, this.getState4PSDEFName());
        }
        if (!bl || this.isState5PSDEFIdDirty()) {
            hashMap.put(FIELD_STATE5PSDEFID, this.getState5PSDEFId());
        }
        if (!bl || this.isState5PSDEFNameDirty()) {
            hashMap.put(FIELD_STATE5PSDEFNAME, this.getState5PSDEFName());
        }
        if (!bl || this.isState6PSDEFIdDirty()) {
            hashMap.put(FIELD_STATE6PSDEFID, this.getState6PSDEFId());
        }
        if (!bl || this.isState6PSDEFNameDirty()) {
            hashMap.put(FIELD_STATE6PSDEFNAME, this.getState6PSDEFName());
        }
        if (!bl || this.isState7PSDEFIdDirty()) {
            hashMap.put(FIELD_STATE7PSDEFID, this.getState7PSDEFId());
        }
        if (!bl || this.isState7PSDEFNameDirty()) {
            hashMap.put(FIELD_STATE7PSDEFNAME, this.getState7PSDEFName());
        }
        if (!bl || this.isState8PSDEFIdDirty()) {
            hashMap.put(FIELD_STATE8PSDEFID, this.getState8PSDEFId());
        }
        if (!bl || this.isState8PSDEFNameDirty()) {
            hashMap.put(FIELD_STATE8PSDEFNAME, this.getState8PSDEFName());
        }
        if (!bl || this.isStatePSDEFIdDirty()) {
            hashMap.put(FIELD_STATEPSDEFID, this.getStatePSDEFId());
        }
        if (!bl || this.isStatePSDEFNameDirty()) {
            hashMap.put(FIELD_STATEPSDEFNAME, this.getStatePSDEFName());
        }
        if (!bl || this.isUniqueTagDirty()) {
            hashMap.put(FIELD_UNIQUETAG, this.getUniqueTag());
        }
        if (!bl || this.isUniStateModeDirty()) {
            hashMap.put(FIELD_UNISTATEMODE, this.getUniStateMode());
        }
        if (!bl || this.isUniStateParamsDirty()) {
            hashMap.put(FIELD_UNISTATEPARAMS, this.getUniStateParams());
        }
        if (!bl || this.isUniStateTagDirty()) {
            hashMap.put(FIELD_UNISTATETAG, this.getUniStateTag());
        }
        if (!bl || this.isUniStateTag2Dirty()) {
            hashMap.put(FIELD_UNISTATETAG2, this.getUniStateTag2());
        }
        if (!bl || this.isUniStateTypeDirty()) {
            hashMap.put(FIELD_UNISTATETYPE, this.getUniStateType());
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
        return PSSysUniStateBase.get(this, n);
    }

    private static Object get(PSSysUniStateBase pSSysUniStateBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysUniStateBase.getAllDataFlag();
            }
            case 1: {
                return pSSysUniStateBase.getCacheCat();
            }
            case 2: {
                return pSSysUniStateBase.getCacheScope();
            }
            case 3: {
                return pSSysUniStateBase.getCacheTimeout();
            }
            case 4: {
                return pSSysUniStateBase.getCreateDate();
            }
            case 5: {
                return pSSysUniStateBase.getCreateMan();
            }
            case 6: {
                return pSSysUniStateBase.getCustomCode();
            }
            case 7: {
                return pSSysUniStateBase.getCustomMode();
            }
            case 8: {
                return pSSysUniStateBase.getDEDefaultFlag();
            }
            case 9: {
                return pSSysUniStateBase.getDeleteAsUpdate();
            }
            case 10: {
                return pSSysUniStateBase.getInitPSDELogicId();
            }
            case 11: {
                return pSSysUniStateBase.getInitPSDELogicName();
            }
            case 12: {
                return pSSysUniStateBase.getKey2PSDEFId();
            }
            case 13: {
                return pSSysUniStateBase.getKey2PSDEFName();
            }
            case 14: {
                return pSSysUniStateBase.getKey3PSDEFId();
            }
            case 15: {
                return pSSysUniStateBase.getKey3PSDEFName();
            }
            case 16: {
                return pSSysUniStateBase.getKey4PSDEFId();
            }
            case 17: {
                return pSSysUniStateBase.getKey4PSDEFName();
            }
            case 18: {
                return pSSysUniStateBase.getKey5PSDEFId();
            }
            case 19: {
                return pSSysUniStateBase.getKey5PSDEFName();
            }
            case 20: {
                return pSSysUniStateBase.getKey6PSDEFId();
            }
            case 21: {
                return pSSysUniStateBase.getKey6PSDEFName();
            }
            case 22: {
                return pSSysUniStateBase.getKey7PSDEFId();
            }
            case 23: {
                return pSSysUniStateBase.getKey7PSDEFName();
            }
            case 24: {
                return pSSysUniStateBase.getKey8PSDEFId();
            }
            case 25: {
                return pSSysUniStateBase.getKey8PSDEFName();
            }
            case 26: {
                return pSSysUniStateBase.getKey9PSDEFId();
            }
            case 27: {
                return pSSysUniStateBase.getKey9PSDEFName();
            }
            case 28: {
                return pSSysUniStateBase.getKeyFormat();
            }
            case 29: {
                return pSSysUniStateBase.getKeyPSDEFId();
            }
            case 30: {
                return pSSysUniStateBase.getKeyPSDEFName();
            }
            case 31: {
                return pSSysUniStateBase.getLockFlag();
            }
            case 32: {
                return pSSysUniStateBase.getMemo();
            }
            case 33: {
                return pSSysUniStateBase.getMonitorFormat();
            }
            case 34: {
                return pSSysUniStateBase.getOnChangePSDELogicId();
            }
            case 35: {
                return pSSysUniStateBase.getOnChangePSDELogicName();
            }
            case 36: {
                return pSSysUniStateBase.getOnDeletePSDELogicId();
            }
            case 37: {
                return pSSysUniStateBase.getOnDeletePSDELogicName();
            }
            case 38: {
                return pSSysUniStateBase.getPSDEDataSetId();
            }
            case 39: {
                return pSSysUniStateBase.getPSDEDataSetName();
            }
            case 40: {
                return pSSysUniStateBase.getPSDEId();
            }
            case 41: {
                return pSSysUniStateBase.getPSDEName();
            }
            case 42: {
                return pSSysUniStateBase.getPSModuleId();
            }
            case 43: {
                return pSSysUniStateBase.getPSModuleName();
            }
            case 44: {
                return pSSysUniStateBase.getPSSysSFPluginId();
            }
            case 45: {
                return pSSysUniStateBase.getPSSysSFPluginName();
            }
            case 46: {
                return pSSysUniStateBase.getPSSystemId();
            }
            case 47: {
                return pSSysUniStateBase.getPSSystemName();
            }
            case 48: {
                return pSSysUniStateBase.getPSSysUniStateId();
            }
            case 49: {
                return pSSysUniStateBase.getPSSysUniStateName();
            }
            case 50: {
                return pSSysUniStateBase.getPSSysUtilDEId();
            }
            case 51: {
                return pSSysUniStateBase.getPSSysUtilDEName();
            }
            case 52: {
                return pSSysUniStateBase.getReloadTimer();
            }
            case 53: {
                return pSSysUniStateBase.getState2PSDEFId();
            }
            case 54: {
                return pSSysUniStateBase.getState2PSDEFName();
            }
            case 55: {
                return pSSysUniStateBase.getState3PSDEFId();
            }
            case 56: {
                return pSSysUniStateBase.getState3PSDEFName();
            }
            case 57: {
                return pSSysUniStateBase.getState4PSDEFId();
            }
            case 58: {
                return pSSysUniStateBase.getState4PSDEFName();
            }
            case 59: {
                return pSSysUniStateBase.getState5PSDEFId();
            }
            case 60: {
                return pSSysUniStateBase.getState5PSDEFName();
            }
            case 61: {
                return pSSysUniStateBase.getState6PSDEFId();
            }
            case 62: {
                return pSSysUniStateBase.getState6PSDEFName();
            }
            case 63: {
                return pSSysUniStateBase.getState7PSDEFId();
            }
            case 64: {
                return pSSysUniStateBase.getState7PSDEFName();
            }
            case 65: {
                return pSSysUniStateBase.getState8PSDEFId();
            }
            case 66: {
                return pSSysUniStateBase.getState8PSDEFName();
            }
            case 67: {
                return pSSysUniStateBase.getStatePSDEFId();
            }
            case 68: {
                return pSSysUniStateBase.getStatePSDEFName();
            }
            case 69: {
                return pSSysUniStateBase.getUniqueTag();
            }
            case 70: {
                return pSSysUniStateBase.getUniStateMode();
            }
            case 71: {
                return pSSysUniStateBase.getUniStateParams();
            }
            case 72: {
                return pSSysUniStateBase.getUniStateTag();
            }
            case 73: {
                return pSSysUniStateBase.getUniStateTag2();
            }
            case 74: {
                return pSSysUniStateBase.getUniStateType();
            }
            case 75: {
                return pSSysUniStateBase.getUpdateDate();
            }
            case 76: {
                return pSSysUniStateBase.getUpdateMan();
            }
            case 77: {
                return pSSysUniStateBase.getUserCat();
            }
            case 78: {
                return pSSysUniStateBase.getUserTag();
            }
            case 79: {
                return pSSysUniStateBase.getUserTag2();
            }
            case 80: {
                return pSSysUniStateBase.getUserTag3();
            }
            case 81: {
                return pSSysUniStateBase.getUserTag4();
            }
            case 82: {
                return pSSysUniStateBase.getValidFlag();
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
        PSSysUniStateBase.set(this, n, object);
    }

    private static void set(PSSysUniStateBase pSSysUniStateBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysUniStateBase.setAllDataFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSSysUniStateBase.setCacheCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysUniStateBase.setCacheScope(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysUniStateBase.setCacheTimeout(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSSysUniStateBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 5: {
                pSSysUniStateBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysUniStateBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysUniStateBase.setCustomMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSSysUniStateBase.setDEDefaultFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSSysUniStateBase.setDeleteAsUpdate(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSSysUniStateBase.setInitPSDELogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysUniStateBase.setInitPSDELogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysUniStateBase.setKey2PSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysUniStateBase.setKey2PSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysUniStateBase.setKey3PSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysUniStateBase.setKey3PSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysUniStateBase.setKey4PSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysUniStateBase.setKey4PSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysUniStateBase.setKey5PSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysUniStateBase.setKey5PSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysUniStateBase.setKey6PSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysUniStateBase.setKey6PSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysUniStateBase.setKey7PSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysUniStateBase.setKey7PSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysUniStateBase.setKey8PSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysUniStateBase.setKey8PSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysUniStateBase.setKey9PSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysUniStateBase.setKey9PSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysUniStateBase.setKeyFormat(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSysUniStateBase.setKeyPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysUniStateBase.setKeyPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSSysUniStateBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 32: {
                pSSysUniStateBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSSysUniStateBase.setMonitorFormat(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSSysUniStateBase.setOnChangePSDELogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSSysUniStateBase.setOnChangePSDELogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSSysUniStateBase.setOnDeletePSDELogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSSysUniStateBase.setOnDeletePSDELogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSSysUniStateBase.setPSDEDataSetId(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSSysUniStateBase.setPSDEDataSetName(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSSysUniStateBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSSysUniStateBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSSysUniStateBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSSysUniStateBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSSysUniStateBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSSysUniStateBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSSysUniStateBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSSysUniStateBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSSysUniStateBase.setPSSysUniStateId(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSSysUniStateBase.setPSSysUniStateName(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSSysUniStateBase.setPSSysUtilDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSSysUniStateBase.setPSSysUtilDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSSysUniStateBase.setReloadTimer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 53: {
                pSSysUniStateBase.setState2PSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 54: {
                pSSysUniStateBase.setState2PSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 55: {
                pSSysUniStateBase.setState3PSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 56: {
                pSSysUniStateBase.setState3PSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 57: {
                pSSysUniStateBase.setState4PSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 58: {
                pSSysUniStateBase.setState4PSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 59: {
                pSSysUniStateBase.setState5PSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 60: {
                pSSysUniStateBase.setState5PSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 61: {
                pSSysUniStateBase.setState6PSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 62: {
                pSSysUniStateBase.setState6PSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 63: {
                pSSysUniStateBase.setState7PSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 64: {
                pSSysUniStateBase.setState7PSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 65: {
                pSSysUniStateBase.setState8PSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 66: {
                pSSysUniStateBase.setState8PSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 67: {
                pSSysUniStateBase.setStatePSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 68: {
                pSSysUniStateBase.setStatePSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 69: {
                pSSysUniStateBase.setUniqueTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 70: {
                pSSysUniStateBase.setUniStateMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 71: {
                pSSysUniStateBase.setUniStateParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 72: {
                pSSysUniStateBase.setUniStateTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 73: {
                pSSysUniStateBase.setUniStateTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 74: {
                pSSysUniStateBase.setUniStateType(DataObject.getStringValue((Object)object));
                return;
            }
            case 75: {
                pSSysUniStateBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 76: {
                pSSysUniStateBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 77: {
                pSSysUniStateBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 78: {
                pSSysUniStateBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 79: {
                pSSysUniStateBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 80: {
                pSSysUniStateBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 81: {
                pSSysUniStateBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 82: {
                pSSysUniStateBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSysUniStateBase.isNull(this, n);
    }

    private static boolean isNull(PSSysUniStateBase pSSysUniStateBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysUniStateBase.getAllDataFlag() == null;
            }
            case 1: {
                return pSSysUniStateBase.getCacheCat() == null;
            }
            case 2: {
                return pSSysUniStateBase.getCacheScope() == null;
            }
            case 3: {
                return pSSysUniStateBase.getCacheTimeout() == null;
            }
            case 4: {
                return pSSysUniStateBase.getCreateDate() == null;
            }
            case 5: {
                return pSSysUniStateBase.getCreateMan() == null;
            }
            case 6: {
                return pSSysUniStateBase.getCustomCode() == null;
            }
            case 7: {
                return pSSysUniStateBase.getCustomMode() == null;
            }
            case 8: {
                return pSSysUniStateBase.getDEDefaultFlag() == null;
            }
            case 9: {
                return pSSysUniStateBase.getDeleteAsUpdate() == null;
            }
            case 10: {
                return pSSysUniStateBase.getInitPSDELogicId() == null;
            }
            case 11: {
                return pSSysUniStateBase.getInitPSDELogicName() == null;
            }
            case 12: {
                return pSSysUniStateBase.getKey2PSDEFId() == null;
            }
            case 13: {
                return pSSysUniStateBase.getKey2PSDEFName() == null;
            }
            case 14: {
                return pSSysUniStateBase.getKey3PSDEFId() == null;
            }
            case 15: {
                return pSSysUniStateBase.getKey3PSDEFName() == null;
            }
            case 16: {
                return pSSysUniStateBase.getKey4PSDEFId() == null;
            }
            case 17: {
                return pSSysUniStateBase.getKey4PSDEFName() == null;
            }
            case 18: {
                return pSSysUniStateBase.getKey5PSDEFId() == null;
            }
            case 19: {
                return pSSysUniStateBase.getKey5PSDEFName() == null;
            }
            case 20: {
                return pSSysUniStateBase.getKey6PSDEFId() == null;
            }
            case 21: {
                return pSSysUniStateBase.getKey6PSDEFName() == null;
            }
            case 22: {
                return pSSysUniStateBase.getKey7PSDEFId() == null;
            }
            case 23: {
                return pSSysUniStateBase.getKey7PSDEFName() == null;
            }
            case 24: {
                return pSSysUniStateBase.getKey8PSDEFId() == null;
            }
            case 25: {
                return pSSysUniStateBase.getKey8PSDEFName() == null;
            }
            case 26: {
                return pSSysUniStateBase.getKey9PSDEFId() == null;
            }
            case 27: {
                return pSSysUniStateBase.getKey9PSDEFName() == null;
            }
            case 28: {
                return pSSysUniStateBase.getKeyFormat() == null;
            }
            case 29: {
                return pSSysUniStateBase.getKeyPSDEFId() == null;
            }
            case 30: {
                return pSSysUniStateBase.getKeyPSDEFName() == null;
            }
            case 31: {
                return pSSysUniStateBase.getLockFlag() == null;
            }
            case 32: {
                return pSSysUniStateBase.getMemo() == null;
            }
            case 33: {
                return pSSysUniStateBase.getMonitorFormat() == null;
            }
            case 34: {
                return pSSysUniStateBase.getOnChangePSDELogicId() == null;
            }
            case 35: {
                return pSSysUniStateBase.getOnChangePSDELogicName() == null;
            }
            case 36: {
                return pSSysUniStateBase.getOnDeletePSDELogicId() == null;
            }
            case 37: {
                return pSSysUniStateBase.getOnDeletePSDELogicName() == null;
            }
            case 38: {
                return pSSysUniStateBase.getPSDEDataSetId() == null;
            }
            case 39: {
                return pSSysUniStateBase.getPSDEDataSetName() == null;
            }
            case 40: {
                return pSSysUniStateBase.getPSDEId() == null;
            }
            case 41: {
                return pSSysUniStateBase.getPSDEName() == null;
            }
            case 42: {
                return pSSysUniStateBase.getPSModuleId() == null;
            }
            case 43: {
                return pSSysUniStateBase.getPSModuleName() == null;
            }
            case 44: {
                return pSSysUniStateBase.getPSSysSFPluginId() == null;
            }
            case 45: {
                return pSSysUniStateBase.getPSSysSFPluginName() == null;
            }
            case 46: {
                return pSSysUniStateBase.getPSSystemId() == null;
            }
            case 47: {
                return pSSysUniStateBase.getPSSystemName() == null;
            }
            case 48: {
                return pSSysUniStateBase.getPSSysUniStateId() == null;
            }
            case 49: {
                return pSSysUniStateBase.getPSSysUniStateName() == null;
            }
            case 50: {
                return pSSysUniStateBase.getPSSysUtilDEId() == null;
            }
            case 51: {
                return pSSysUniStateBase.getPSSysUtilDEName() == null;
            }
            case 52: {
                return pSSysUniStateBase.getReloadTimer() == null;
            }
            case 53: {
                return pSSysUniStateBase.getState2PSDEFId() == null;
            }
            case 54: {
                return pSSysUniStateBase.getState2PSDEFName() == null;
            }
            case 55: {
                return pSSysUniStateBase.getState3PSDEFId() == null;
            }
            case 56: {
                return pSSysUniStateBase.getState3PSDEFName() == null;
            }
            case 57: {
                return pSSysUniStateBase.getState4PSDEFId() == null;
            }
            case 58: {
                return pSSysUniStateBase.getState4PSDEFName() == null;
            }
            case 59: {
                return pSSysUniStateBase.getState5PSDEFId() == null;
            }
            case 60: {
                return pSSysUniStateBase.getState5PSDEFName() == null;
            }
            case 61: {
                return pSSysUniStateBase.getState6PSDEFId() == null;
            }
            case 62: {
                return pSSysUniStateBase.getState6PSDEFName() == null;
            }
            case 63: {
                return pSSysUniStateBase.getState7PSDEFId() == null;
            }
            case 64: {
                return pSSysUniStateBase.getState7PSDEFName() == null;
            }
            case 65: {
                return pSSysUniStateBase.getState8PSDEFId() == null;
            }
            case 66: {
                return pSSysUniStateBase.getState8PSDEFName() == null;
            }
            case 67: {
                return pSSysUniStateBase.getStatePSDEFId() == null;
            }
            case 68: {
                return pSSysUniStateBase.getStatePSDEFName() == null;
            }
            case 69: {
                return pSSysUniStateBase.getUniqueTag() == null;
            }
            case 70: {
                return pSSysUniStateBase.getUniStateMode() == null;
            }
            case 71: {
                return pSSysUniStateBase.getUniStateParams() == null;
            }
            case 72: {
                return pSSysUniStateBase.getUniStateTag() == null;
            }
            case 73: {
                return pSSysUniStateBase.getUniStateTag2() == null;
            }
            case 74: {
                return pSSysUniStateBase.getUniStateType() == null;
            }
            case 75: {
                return pSSysUniStateBase.getUpdateDate() == null;
            }
            case 76: {
                return pSSysUniStateBase.getUpdateMan() == null;
            }
            case 77: {
                return pSSysUniStateBase.getUserCat() == null;
            }
            case 78: {
                return pSSysUniStateBase.getUserTag() == null;
            }
            case 79: {
                return pSSysUniStateBase.getUserTag2() == null;
            }
            case 80: {
                return pSSysUniStateBase.getUserTag3() == null;
            }
            case 81: {
                return pSSysUniStateBase.getUserTag4() == null;
            }
            case 82: {
                return pSSysUniStateBase.getValidFlag() == null;
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
        return PSSysUniStateBase.contains(this, n);
    }

    private static boolean contains(PSSysUniStateBase pSSysUniStateBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysUniStateBase.isAllDataFlagDirty();
            }
            case 1: {
                return pSSysUniStateBase.isCacheCatDirty();
            }
            case 2: {
                return pSSysUniStateBase.isCacheScopeDirty();
            }
            case 3: {
                return pSSysUniStateBase.isCacheTimeoutDirty();
            }
            case 4: {
                return pSSysUniStateBase.isCreateDateDirty();
            }
            case 5: {
                return pSSysUniStateBase.isCreateManDirty();
            }
            case 6: {
                return pSSysUniStateBase.isCustomCodeDirty();
            }
            case 7: {
                return pSSysUniStateBase.isCustomModeDirty();
            }
            case 8: {
                return pSSysUniStateBase.isDEDefaultFlagDirty();
            }
            case 9: {
                return pSSysUniStateBase.isDeleteAsUpdateDirty();
            }
            case 10: {
                return pSSysUniStateBase.isInitPSDELogicIdDirty();
            }
            case 11: {
                return pSSysUniStateBase.isInitPSDELogicNameDirty();
            }
            case 12: {
                return pSSysUniStateBase.isKey2PSDEFIdDirty();
            }
            case 13: {
                return pSSysUniStateBase.isKey2PSDEFNameDirty();
            }
            case 14: {
                return pSSysUniStateBase.isKey3PSDEFIdDirty();
            }
            case 15: {
                return pSSysUniStateBase.isKey3PSDEFNameDirty();
            }
            case 16: {
                return pSSysUniStateBase.isKey4PSDEFIdDirty();
            }
            case 17: {
                return pSSysUniStateBase.isKey4PSDEFNameDirty();
            }
            case 18: {
                return pSSysUniStateBase.isKey5PSDEFIdDirty();
            }
            case 19: {
                return pSSysUniStateBase.isKey5PSDEFNameDirty();
            }
            case 20: {
                return pSSysUniStateBase.isKey6PSDEFIdDirty();
            }
            case 21: {
                return pSSysUniStateBase.isKey6PSDEFNameDirty();
            }
            case 22: {
                return pSSysUniStateBase.isKey7PSDEFIdDirty();
            }
            case 23: {
                return pSSysUniStateBase.isKey7PSDEFNameDirty();
            }
            case 24: {
                return pSSysUniStateBase.isKey8PSDEFIdDirty();
            }
            case 25: {
                return pSSysUniStateBase.isKey8PSDEFNameDirty();
            }
            case 26: {
                return pSSysUniStateBase.isKey9PSDEFIdDirty();
            }
            case 27: {
                return pSSysUniStateBase.isKey9PSDEFNameDirty();
            }
            case 28: {
                return pSSysUniStateBase.isKeyFormatDirty();
            }
            case 29: {
                return pSSysUniStateBase.isKeyPSDEFIdDirty();
            }
            case 30: {
                return pSSysUniStateBase.isKeyPSDEFNameDirty();
            }
            case 31: {
                return pSSysUniStateBase.isLockFlagDirty();
            }
            case 32: {
                return pSSysUniStateBase.isMemoDirty();
            }
            case 33: {
                return pSSysUniStateBase.isMonitorFormatDirty();
            }
            case 34: {
                return pSSysUniStateBase.isOnChangePSDELogicIdDirty();
            }
            case 35: {
                return pSSysUniStateBase.isOnChangePSDELogicNameDirty();
            }
            case 36: {
                return pSSysUniStateBase.isOnDeletePSDELogicIdDirty();
            }
            case 37: {
                return pSSysUniStateBase.isOnDeletePSDELogicNameDirty();
            }
            case 38: {
                return pSSysUniStateBase.isPSDEDataSetIdDirty();
            }
            case 39: {
                return pSSysUniStateBase.isPSDEDataSetNameDirty();
            }
            case 40: {
                return pSSysUniStateBase.isPSDEIdDirty();
            }
            case 41: {
                return pSSysUniStateBase.isPSDENameDirty();
            }
            case 42: {
                return pSSysUniStateBase.isPSModuleIdDirty();
            }
            case 43: {
                return pSSysUniStateBase.isPSModuleNameDirty();
            }
            case 44: {
                return pSSysUniStateBase.isPSSysSFPluginIdDirty();
            }
            case 45: {
                return pSSysUniStateBase.isPSSysSFPluginNameDirty();
            }
            case 46: {
                return pSSysUniStateBase.isPSSystemIdDirty();
            }
            case 47: {
                return pSSysUniStateBase.isPSSystemNameDirty();
            }
            case 48: {
                return pSSysUniStateBase.isPSSysUniStateIdDirty();
            }
            case 49: {
                return pSSysUniStateBase.isPSSysUniStateNameDirty();
            }
            case 50: {
                return pSSysUniStateBase.isPSSysUtilDEIdDirty();
            }
            case 51: {
                return pSSysUniStateBase.isPSSysUtilDENameDirty();
            }
            case 52: {
                return pSSysUniStateBase.isReloadTimerDirty();
            }
            case 53: {
                return pSSysUniStateBase.isState2PSDEFIdDirty();
            }
            case 54: {
                return pSSysUniStateBase.isState2PSDEFNameDirty();
            }
            case 55: {
                return pSSysUniStateBase.isState3PSDEFIdDirty();
            }
            case 56: {
                return pSSysUniStateBase.isState3PSDEFNameDirty();
            }
            case 57: {
                return pSSysUniStateBase.isState4PSDEFIdDirty();
            }
            case 58: {
                return pSSysUniStateBase.isState4PSDEFNameDirty();
            }
            case 59: {
                return pSSysUniStateBase.isState5PSDEFIdDirty();
            }
            case 60: {
                return pSSysUniStateBase.isState5PSDEFNameDirty();
            }
            case 61: {
                return pSSysUniStateBase.isState6PSDEFIdDirty();
            }
            case 62: {
                return pSSysUniStateBase.isState6PSDEFNameDirty();
            }
            case 63: {
                return pSSysUniStateBase.isState7PSDEFIdDirty();
            }
            case 64: {
                return pSSysUniStateBase.isState7PSDEFNameDirty();
            }
            case 65: {
                return pSSysUniStateBase.isState8PSDEFIdDirty();
            }
            case 66: {
                return pSSysUniStateBase.isState8PSDEFNameDirty();
            }
            case 67: {
                return pSSysUniStateBase.isStatePSDEFIdDirty();
            }
            case 68: {
                return pSSysUniStateBase.isStatePSDEFNameDirty();
            }
            case 69: {
                return pSSysUniStateBase.isUniqueTagDirty();
            }
            case 70: {
                return pSSysUniStateBase.isUniStateModeDirty();
            }
            case 71: {
                return pSSysUniStateBase.isUniStateParamsDirty();
            }
            case 72: {
                return pSSysUniStateBase.isUniStateTagDirty();
            }
            case 73: {
                return pSSysUniStateBase.isUniStateTag2Dirty();
            }
            case 74: {
                return pSSysUniStateBase.isUniStateTypeDirty();
            }
            case 75: {
                return pSSysUniStateBase.isUpdateDateDirty();
            }
            case 76: {
                return pSSysUniStateBase.isUpdateManDirty();
            }
            case 77: {
                return pSSysUniStateBase.isUserCatDirty();
            }
            case 78: {
                return pSSysUniStateBase.isUserTagDirty();
            }
            case 79: {
                return pSSysUniStateBase.isUserTag2Dirty();
            }
            case 80: {
                return pSSysUniStateBase.isUserTag3Dirty();
            }
            case 81: {
                return pSSysUniStateBase.isUserTag4Dirty();
            }
            case 82: {
                return pSSysUniStateBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysUniStateBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysUniStateBase pSSysUniStateBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysUniStateBase.getAllDataFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"alldataflag", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getAllDataFlag()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getCacheCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cachecat", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getCacheCat()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getCacheScope() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cachescope", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getCacheScope()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getCacheTimeout() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cachetimeout", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getCacheTimeout()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getCustomMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"custommode", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getCustomMode()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getDEDefaultFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dedefaultflag", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getDEDefaultFlag()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getDeleteAsUpdate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"deleteasupdate", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getDeleteAsUpdate()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getInitPSDELogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"initpsdelogicid", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getInitPSDELogicId()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getInitPSDELogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"initpsdelogicname", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getInitPSDELogicName()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getKey2PSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"key2psdefid", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getKey2PSDEFId()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getKey2PSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"key2psdefname", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getKey2PSDEFName()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getKey3PSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"key3psdefid", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getKey3PSDEFId()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getKey3PSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"key3psdefname", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getKey3PSDEFName()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getKey4PSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"key4psdefid", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getKey4PSDEFId()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getKey4PSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"key4psdefname", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getKey4PSDEFName()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getKey5PSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"key5psdefid", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getKey5PSDEFId()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getKey5PSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"key5psdefname", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getKey5PSDEFName()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getKey6PSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"key6psdefid", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getKey6PSDEFId()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getKey6PSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"key6psdefname", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getKey6PSDEFName()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getKey7PSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"key7psdefid", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getKey7PSDEFId()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getKey7PSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"key7psdefname", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getKey7PSDEFName()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getKey8PSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"key8psdefid", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getKey8PSDEFId()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getKey8PSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"key8psdefname", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getKey8PSDEFName()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getKey9PSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"key9psdefid", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getKey9PSDEFId()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getKey9PSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"key9psdefname", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getKey9PSDEFName()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getKeyFormat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"keyformat", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getKeyFormat()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getKeyPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"keypsdefid", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getKeyPSDEFId()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getKeyPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"keypsdefname", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getKeyPSDEFName()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getMonitorFormat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"monitorformat", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getMonitorFormat()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getOnChangePSDELogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"onchangepsdelogicid", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getOnChangePSDELogicId()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getOnChangePSDELogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"onchangepsdelogicname", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getOnChangePSDELogicName()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getOnDeletePSDELogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ondeletepsdelogicid", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getOnDeletePSDELogicId()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getOnDeletePSDELogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ondeletepsdelogicname", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getOnDeletePSDELogicName()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getPSDEDataSetId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedatasetid", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getPSDEDataSetId()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getPSDEDataSetName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedatasetname", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getPSDEDataSetName()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getPSSysUniStateId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysunistateid", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getPSSysUniStateId()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getPSSysUniStateName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysunistatename", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getPSSysUniStateName()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getPSSysUtilDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysutildeid", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getPSSysUtilDEId()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getPSSysUtilDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysutildename", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getPSSysUtilDEName()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getReloadTimer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"reloadtimer", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getReloadTimer()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getState2PSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"state2psdefid", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getState2PSDEFId()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getState2PSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"state2psdefname", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getState2PSDEFName()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getState3PSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"state3psdefid", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getState3PSDEFId()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getState3PSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"state3psdefname", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getState3PSDEFName()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getState4PSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"state4psdefid", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getState4PSDEFId()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getState4PSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"state4psdefname", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getState4PSDEFName()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getState5PSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"state5psdefid", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getState5PSDEFId()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getState5PSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"state5psdefname", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getState5PSDEFName()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getState6PSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"state6psdefid", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getState6PSDEFId()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getState6PSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"state6psdefname", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getState6PSDEFName()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getState7PSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"state7psdefid", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getState7PSDEFId()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getState7PSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"state7psdefname", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getState7PSDEFName()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getState8PSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"state8psdefid", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getState8PSDEFId()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getState8PSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"state8psdefname", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getState8PSDEFName()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getStatePSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"statepsdefid", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getStatePSDEFId()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getStatePSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"statepsdefname", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getStatePSDEFName()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getUniqueTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uniquetag", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getUniqueTag()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getUniStateMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"unistatemode", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getUniStateMode()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getUniStateParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"unistateparams", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getUniStateParams()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getUniStateTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"unistatetag", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getUniStateTag()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getUniStateTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"unistatetag2", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getUniStateTag2()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getUniStateType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"unistatetype", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getUniStateType()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysUniStateBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysUniStateBase.getJSONValue((Object)pSSysUniStateBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysUniStateBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysUniStateBase pSSysUniStateBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysUniStateBase.getAllDataFlag() != null) {
            object = pSSysUniStateBase.getAllDataFlag();
            xmlNode.setAttribute(FIELD_ALLDATAFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysUniStateBase.getCacheCat() != null) {
            object = pSSysUniStateBase.getCacheCat();
            xmlNode.setAttribute(FIELD_CACHECAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getCacheScope() != null) {
            object = pSSysUniStateBase.getCacheScope();
            xmlNode.setAttribute(FIELD_CACHESCOPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getCacheTimeout() != null) {
            object = pSSysUniStateBase.getCacheTimeout();
            xmlNode.setAttribute(FIELD_CACHETIMEOUT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysUniStateBase.getCreateDate() != null) {
            object = pSSysUniStateBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysUniStateBase.getCreateMan() != null) {
            object = pSSysUniStateBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getCustomCode() != null) {
            object = pSSysUniStateBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getCustomMode() != null) {
            object = pSSysUniStateBase.getCustomMode();
            xmlNode.setAttribute(FIELD_CUSTOMMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysUniStateBase.getDEDefaultFlag() != null) {
            object = pSSysUniStateBase.getDEDefaultFlag();
            xmlNode.setAttribute(FIELD_DEDEFAULTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysUniStateBase.getDeleteAsUpdate() != null) {
            object = pSSysUniStateBase.getDeleteAsUpdate();
            xmlNode.setAttribute(FIELD_DELETEASUPDATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysUniStateBase.getInitPSDELogicId() != null) {
            object = pSSysUniStateBase.getInitPSDELogicId();
            xmlNode.setAttribute(FIELD_INITPSDELOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getInitPSDELogicName() != null) {
            object = pSSysUniStateBase.getInitPSDELogicName();
            xmlNode.setAttribute(FIELD_INITPSDELOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getKey2PSDEFId() != null) {
            object = pSSysUniStateBase.getKey2PSDEFId();
            xmlNode.setAttribute(FIELD_KEY2PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getKey2PSDEFName() != null) {
            object = pSSysUniStateBase.getKey2PSDEFName();
            xmlNode.setAttribute(FIELD_KEY2PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getKey3PSDEFId() != null) {
            object = pSSysUniStateBase.getKey3PSDEFId();
            xmlNode.setAttribute(FIELD_KEY3PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getKey3PSDEFName() != null) {
            object = pSSysUniStateBase.getKey3PSDEFName();
            xmlNode.setAttribute(FIELD_KEY3PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getKey4PSDEFId() != null) {
            object = pSSysUniStateBase.getKey4PSDEFId();
            xmlNode.setAttribute(FIELD_KEY4PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getKey4PSDEFName() != null) {
            object = pSSysUniStateBase.getKey4PSDEFName();
            xmlNode.setAttribute(FIELD_KEY4PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getKey5PSDEFId() != null) {
            object = pSSysUniStateBase.getKey5PSDEFId();
            xmlNode.setAttribute(FIELD_KEY5PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getKey5PSDEFName() != null) {
            object = pSSysUniStateBase.getKey5PSDEFName();
            xmlNode.setAttribute(FIELD_KEY5PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getKey6PSDEFId() != null) {
            object = pSSysUniStateBase.getKey6PSDEFId();
            xmlNode.setAttribute(FIELD_KEY6PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getKey6PSDEFName() != null) {
            object = pSSysUniStateBase.getKey6PSDEFName();
            xmlNode.setAttribute(FIELD_KEY6PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getKey7PSDEFId() != null) {
            object = pSSysUniStateBase.getKey7PSDEFId();
            xmlNode.setAttribute(FIELD_KEY7PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getKey7PSDEFName() != null) {
            object = pSSysUniStateBase.getKey7PSDEFName();
            xmlNode.setAttribute(FIELD_KEY7PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getKey8PSDEFId() != null) {
            object = pSSysUniStateBase.getKey8PSDEFId();
            xmlNode.setAttribute(FIELD_KEY8PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getKey8PSDEFName() != null) {
            object = pSSysUniStateBase.getKey8PSDEFName();
            xmlNode.setAttribute(FIELD_KEY8PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getKey9PSDEFId() != null) {
            object = pSSysUniStateBase.getKey9PSDEFId();
            xmlNode.setAttribute(FIELD_KEY9PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getKey9PSDEFName() != null) {
            object = pSSysUniStateBase.getKey9PSDEFName();
            xmlNode.setAttribute(FIELD_KEY9PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getKeyFormat() != null) {
            object = pSSysUniStateBase.getKeyFormat();
            xmlNode.setAttribute(FIELD_KEYFORMAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getKeyPSDEFId() != null) {
            object = pSSysUniStateBase.getKeyPSDEFId();
            xmlNode.setAttribute(FIELD_KEYPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getKeyPSDEFName() != null) {
            object = pSSysUniStateBase.getKeyPSDEFName();
            xmlNode.setAttribute(FIELD_KEYPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getLockFlag() != null) {
            object = pSSysUniStateBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysUniStateBase.getMemo() != null) {
            object = pSSysUniStateBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getMonitorFormat() != null) {
            object = pSSysUniStateBase.getMonitorFormat();
            xmlNode.setAttribute(FIELD_MONITORFORMAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getOnChangePSDELogicId() != null) {
            object = pSSysUniStateBase.getOnChangePSDELogicId();
            xmlNode.setAttribute(FIELD_ONCHANGEPSDELOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getOnChangePSDELogicName() != null) {
            object = pSSysUniStateBase.getOnChangePSDELogicName();
            xmlNode.setAttribute(FIELD_ONCHANGEPSDELOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getOnDeletePSDELogicId() != null) {
            object = pSSysUniStateBase.getOnDeletePSDELogicId();
            xmlNode.setAttribute(FIELD_ONDELETEPSDELOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getOnDeletePSDELogicName() != null) {
            object = pSSysUniStateBase.getOnDeletePSDELogicName();
            xmlNode.setAttribute(FIELD_ONDELETEPSDELOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getPSDEDataSetId() != null) {
            object = pSSysUniStateBase.getPSDEDataSetId();
            xmlNode.setAttribute(FIELD_PSDEDATASETID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getPSDEDataSetName() != null) {
            object = pSSysUniStateBase.getPSDEDataSetName();
            xmlNode.setAttribute(FIELD_PSDEDATASETNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getPSDEId() != null) {
            object = pSSysUniStateBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getPSDEName() != null) {
            object = pSSysUniStateBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getPSModuleId() != null) {
            object = pSSysUniStateBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getPSModuleName() != null) {
            object = pSSysUniStateBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getPSSysSFPluginId() != null) {
            object = pSSysUniStateBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getPSSysSFPluginName() != null) {
            object = pSSysUniStateBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getPSSystemId() != null) {
            object = pSSysUniStateBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getPSSystemName() != null) {
            object = pSSysUniStateBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getPSSysUniStateId() != null) {
            object = pSSysUniStateBase.getPSSysUniStateId();
            xmlNode.setAttribute(FIELD_PSSYSUNISTATEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getPSSysUniStateName() != null) {
            object = pSSysUniStateBase.getPSSysUniStateName();
            xmlNode.setAttribute(FIELD_PSSYSUNISTATENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getPSSysUtilDEId() != null) {
            object = pSSysUniStateBase.getPSSysUtilDEId();
            xmlNode.setAttribute(FIELD_PSSYSUTILDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getPSSysUtilDEName() != null) {
            object = pSSysUniStateBase.getPSSysUtilDEName();
            xmlNode.setAttribute(FIELD_PSSYSUTILDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getReloadTimer() != null) {
            object = pSSysUniStateBase.getReloadTimer();
            xmlNode.setAttribute(FIELD_RELOADTIMER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysUniStateBase.getState2PSDEFId() != null) {
            object = pSSysUniStateBase.getState2PSDEFId();
            xmlNode.setAttribute(FIELD_STATE2PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getState2PSDEFName() != null) {
            object = pSSysUniStateBase.getState2PSDEFName();
            xmlNode.setAttribute(FIELD_STATE2PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getState3PSDEFId() != null) {
            object = pSSysUniStateBase.getState3PSDEFId();
            xmlNode.setAttribute(FIELD_STATE3PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getState3PSDEFName() != null) {
            object = pSSysUniStateBase.getState3PSDEFName();
            xmlNode.setAttribute(FIELD_STATE3PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getState4PSDEFId() != null) {
            object = pSSysUniStateBase.getState4PSDEFId();
            xmlNode.setAttribute(FIELD_STATE4PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getState4PSDEFName() != null) {
            object = pSSysUniStateBase.getState4PSDEFName();
            xmlNode.setAttribute(FIELD_STATE4PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getState5PSDEFId() != null) {
            object = pSSysUniStateBase.getState5PSDEFId();
            xmlNode.setAttribute(FIELD_STATE5PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getState5PSDEFName() != null) {
            object = pSSysUniStateBase.getState5PSDEFName();
            xmlNode.setAttribute(FIELD_STATE5PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getState6PSDEFId() != null) {
            object = pSSysUniStateBase.getState6PSDEFId();
            xmlNode.setAttribute(FIELD_STATE6PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getState6PSDEFName() != null) {
            object = pSSysUniStateBase.getState6PSDEFName();
            xmlNode.setAttribute(FIELD_STATE6PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getState7PSDEFId() != null) {
            object = pSSysUniStateBase.getState7PSDEFId();
            xmlNode.setAttribute(FIELD_STATE7PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getState7PSDEFName() != null) {
            object = pSSysUniStateBase.getState7PSDEFName();
            xmlNode.setAttribute(FIELD_STATE7PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getState8PSDEFId() != null) {
            object = pSSysUniStateBase.getState8PSDEFId();
            xmlNode.setAttribute(FIELD_STATE8PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getState8PSDEFName() != null) {
            object = pSSysUniStateBase.getState8PSDEFName();
            xmlNode.setAttribute(FIELD_STATE8PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getStatePSDEFId() != null) {
            object = pSSysUniStateBase.getStatePSDEFId();
            xmlNode.setAttribute(FIELD_STATEPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getStatePSDEFName() != null) {
            object = pSSysUniStateBase.getStatePSDEFName();
            xmlNode.setAttribute(FIELD_STATEPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getUniqueTag() != null) {
            object = pSSysUniStateBase.getUniqueTag();
            xmlNode.setAttribute(FIELD_UNIQUETAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getUniStateMode() != null) {
            object = pSSysUniStateBase.getUniStateMode();
            xmlNode.setAttribute(FIELD_UNISTATEMODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getUniStateParams() != null) {
            object = pSSysUniStateBase.getUniStateParams();
            xmlNode.setAttribute(FIELD_UNISTATEPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getUniStateTag() != null) {
            object = pSSysUniStateBase.getUniStateTag();
            xmlNode.setAttribute(FIELD_UNISTATETAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getUniStateTag2() != null) {
            object = pSSysUniStateBase.getUniStateTag2();
            xmlNode.setAttribute(FIELD_UNISTATETAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getUniStateType() != null) {
            object = pSSysUniStateBase.getUniStateType();
            xmlNode.setAttribute(FIELD_UNISTATETYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getUpdateDate() != null) {
            object = pSSysUniStateBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysUniStateBase.getUpdateMan() != null) {
            object = pSSysUniStateBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getUserCat() != null) {
            object = pSSysUniStateBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getUserTag() != null) {
            object = pSSysUniStateBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getUserTag2() != null) {
            object = pSSysUniStateBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getUserTag3() != null) {
            object = pSSysUniStateBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getUserTag4() != null) {
            object = pSSysUniStateBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniStateBase.getValidFlag() != null) {
            object = pSSysUniStateBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysUniStateBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysUniStateBase pSSysUniStateBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysUniStateBase.isAllDataFlagDirty() && (bl || pSSysUniStateBase.getAllDataFlag() != null)) {
            iDataObject.set(FIELD_ALLDATAFLAG, (Object)pSSysUniStateBase.getAllDataFlag());
        }
        if (pSSysUniStateBase.isCacheCatDirty() && (bl || pSSysUniStateBase.getCacheCat() != null)) {
            iDataObject.set(FIELD_CACHECAT, (Object)pSSysUniStateBase.getCacheCat());
        }
        if (pSSysUniStateBase.isCacheScopeDirty() && (bl || pSSysUniStateBase.getCacheScope() != null)) {
            iDataObject.set(FIELD_CACHESCOPE, (Object)pSSysUniStateBase.getCacheScope());
        }
        if (pSSysUniStateBase.isCacheTimeoutDirty() && (bl || pSSysUniStateBase.getCacheTimeout() != null)) {
            iDataObject.set(FIELD_CACHETIMEOUT, (Object)pSSysUniStateBase.getCacheTimeout());
        }
        if (pSSysUniStateBase.isCreateDateDirty() && (bl || pSSysUniStateBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysUniStateBase.getCreateDate());
        }
        if (pSSysUniStateBase.isCreateManDirty() && (bl || pSSysUniStateBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysUniStateBase.getCreateMan());
        }
        if (pSSysUniStateBase.isCustomCodeDirty() && (bl || pSSysUniStateBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSSysUniStateBase.getCustomCode());
        }
        if (pSSysUniStateBase.isCustomModeDirty() && (bl || pSSysUniStateBase.getCustomMode() != null)) {
            iDataObject.set(FIELD_CUSTOMMODE, (Object)pSSysUniStateBase.getCustomMode());
        }
        if (pSSysUniStateBase.isDEDefaultFlagDirty() && (bl || pSSysUniStateBase.getDEDefaultFlag() != null)) {
            iDataObject.set(FIELD_DEDEFAULTFLAG, (Object)pSSysUniStateBase.getDEDefaultFlag());
        }
        if (pSSysUniStateBase.isDeleteAsUpdateDirty() && (bl || pSSysUniStateBase.getDeleteAsUpdate() != null)) {
            iDataObject.set(FIELD_DELETEASUPDATE, (Object)pSSysUniStateBase.getDeleteAsUpdate());
        }
        if (pSSysUniStateBase.isInitPSDELogicIdDirty() && (bl || pSSysUniStateBase.getInitPSDELogicId() != null)) {
            iDataObject.set(FIELD_INITPSDELOGICID, (Object)pSSysUniStateBase.getInitPSDELogicId());
        }
        if (pSSysUniStateBase.isInitPSDELogicNameDirty() && (bl || pSSysUniStateBase.getInitPSDELogicName() != null)) {
            iDataObject.set(FIELD_INITPSDELOGICNAME, (Object)pSSysUniStateBase.getInitPSDELogicName());
        }
        if (pSSysUniStateBase.isKey2PSDEFIdDirty() && (bl || pSSysUniStateBase.getKey2PSDEFId() != null)) {
            iDataObject.set(FIELD_KEY2PSDEFID, (Object)pSSysUniStateBase.getKey2PSDEFId());
        }
        if (pSSysUniStateBase.isKey2PSDEFNameDirty() && (bl || pSSysUniStateBase.getKey2PSDEFName() != null)) {
            iDataObject.set(FIELD_KEY2PSDEFNAME, (Object)pSSysUniStateBase.getKey2PSDEFName());
        }
        if (pSSysUniStateBase.isKey3PSDEFIdDirty() && (bl || pSSysUniStateBase.getKey3PSDEFId() != null)) {
            iDataObject.set(FIELD_KEY3PSDEFID, (Object)pSSysUniStateBase.getKey3PSDEFId());
        }
        if (pSSysUniStateBase.isKey3PSDEFNameDirty() && (bl || pSSysUniStateBase.getKey3PSDEFName() != null)) {
            iDataObject.set(FIELD_KEY3PSDEFNAME, (Object)pSSysUniStateBase.getKey3PSDEFName());
        }
        if (pSSysUniStateBase.isKey4PSDEFIdDirty() && (bl || pSSysUniStateBase.getKey4PSDEFId() != null)) {
            iDataObject.set(FIELD_KEY4PSDEFID, (Object)pSSysUniStateBase.getKey4PSDEFId());
        }
        if (pSSysUniStateBase.isKey4PSDEFNameDirty() && (bl || pSSysUniStateBase.getKey4PSDEFName() != null)) {
            iDataObject.set(FIELD_KEY4PSDEFNAME, (Object)pSSysUniStateBase.getKey4PSDEFName());
        }
        if (pSSysUniStateBase.isKey5PSDEFIdDirty() && (bl || pSSysUniStateBase.getKey5PSDEFId() != null)) {
            iDataObject.set(FIELD_KEY5PSDEFID, (Object)pSSysUniStateBase.getKey5PSDEFId());
        }
        if (pSSysUniStateBase.isKey5PSDEFNameDirty() && (bl || pSSysUniStateBase.getKey5PSDEFName() != null)) {
            iDataObject.set(FIELD_KEY5PSDEFNAME, (Object)pSSysUniStateBase.getKey5PSDEFName());
        }
        if (pSSysUniStateBase.isKey6PSDEFIdDirty() && (bl || pSSysUniStateBase.getKey6PSDEFId() != null)) {
            iDataObject.set(FIELD_KEY6PSDEFID, (Object)pSSysUniStateBase.getKey6PSDEFId());
        }
        if (pSSysUniStateBase.isKey6PSDEFNameDirty() && (bl || pSSysUniStateBase.getKey6PSDEFName() != null)) {
            iDataObject.set(FIELD_KEY6PSDEFNAME, (Object)pSSysUniStateBase.getKey6PSDEFName());
        }
        if (pSSysUniStateBase.isKey7PSDEFIdDirty() && (bl || pSSysUniStateBase.getKey7PSDEFId() != null)) {
            iDataObject.set(FIELD_KEY7PSDEFID, (Object)pSSysUniStateBase.getKey7PSDEFId());
        }
        if (pSSysUniStateBase.isKey7PSDEFNameDirty() && (bl || pSSysUniStateBase.getKey7PSDEFName() != null)) {
            iDataObject.set(FIELD_KEY7PSDEFNAME, (Object)pSSysUniStateBase.getKey7PSDEFName());
        }
        if (pSSysUniStateBase.isKey8PSDEFIdDirty() && (bl || pSSysUniStateBase.getKey8PSDEFId() != null)) {
            iDataObject.set(FIELD_KEY8PSDEFID, (Object)pSSysUniStateBase.getKey8PSDEFId());
        }
        if (pSSysUniStateBase.isKey8PSDEFNameDirty() && (bl || pSSysUniStateBase.getKey8PSDEFName() != null)) {
            iDataObject.set(FIELD_KEY8PSDEFNAME, (Object)pSSysUniStateBase.getKey8PSDEFName());
        }
        if (pSSysUniStateBase.isKey9PSDEFIdDirty() && (bl || pSSysUniStateBase.getKey9PSDEFId() != null)) {
            iDataObject.set(FIELD_KEY9PSDEFID, (Object)pSSysUniStateBase.getKey9PSDEFId());
        }
        if (pSSysUniStateBase.isKey9PSDEFNameDirty() && (bl || pSSysUniStateBase.getKey9PSDEFName() != null)) {
            iDataObject.set(FIELD_KEY9PSDEFNAME, (Object)pSSysUniStateBase.getKey9PSDEFName());
        }
        if (pSSysUniStateBase.isKeyFormatDirty() && (bl || pSSysUniStateBase.getKeyFormat() != null)) {
            iDataObject.set(FIELD_KEYFORMAT, (Object)pSSysUniStateBase.getKeyFormat());
        }
        if (pSSysUniStateBase.isKeyPSDEFIdDirty() && (bl || pSSysUniStateBase.getKeyPSDEFId() != null)) {
            iDataObject.set(FIELD_KEYPSDEFID, (Object)pSSysUniStateBase.getKeyPSDEFId());
        }
        if (pSSysUniStateBase.isKeyPSDEFNameDirty() && (bl || pSSysUniStateBase.getKeyPSDEFName() != null)) {
            iDataObject.set(FIELD_KEYPSDEFNAME, (Object)pSSysUniStateBase.getKeyPSDEFName());
        }
        if (pSSysUniStateBase.isLockFlagDirty() && (bl || pSSysUniStateBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSSysUniStateBase.getLockFlag());
        }
        if (pSSysUniStateBase.isMemoDirty() && (bl || pSSysUniStateBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysUniStateBase.getMemo());
        }
        if (pSSysUniStateBase.isMonitorFormatDirty() && (bl || pSSysUniStateBase.getMonitorFormat() != null)) {
            iDataObject.set(FIELD_MONITORFORMAT, (Object)pSSysUniStateBase.getMonitorFormat());
        }
        if (pSSysUniStateBase.isOnChangePSDELogicIdDirty() && (bl || pSSysUniStateBase.getOnChangePSDELogicId() != null)) {
            iDataObject.set(FIELD_ONCHANGEPSDELOGICID, (Object)pSSysUniStateBase.getOnChangePSDELogicId());
        }
        if (pSSysUniStateBase.isOnChangePSDELogicNameDirty() && (bl || pSSysUniStateBase.getOnChangePSDELogicName() != null)) {
            iDataObject.set(FIELD_ONCHANGEPSDELOGICNAME, (Object)pSSysUniStateBase.getOnChangePSDELogicName());
        }
        if (pSSysUniStateBase.isOnDeletePSDELogicIdDirty() && (bl || pSSysUniStateBase.getOnDeletePSDELogicId() != null)) {
            iDataObject.set(FIELD_ONDELETEPSDELOGICID, (Object)pSSysUniStateBase.getOnDeletePSDELogicId());
        }
        if (pSSysUniStateBase.isOnDeletePSDELogicNameDirty() && (bl || pSSysUniStateBase.getOnDeletePSDELogicName() != null)) {
            iDataObject.set(FIELD_ONDELETEPSDELOGICNAME, (Object)pSSysUniStateBase.getOnDeletePSDELogicName());
        }
        if (pSSysUniStateBase.isPSDEDataSetIdDirty() && (bl || pSSysUniStateBase.getPSDEDataSetId() != null)) {
            iDataObject.set(FIELD_PSDEDATASETID, (Object)pSSysUniStateBase.getPSDEDataSetId());
        }
        if (pSSysUniStateBase.isPSDEDataSetNameDirty() && (bl || pSSysUniStateBase.getPSDEDataSetName() != null)) {
            iDataObject.set(FIELD_PSDEDATASETNAME, (Object)pSSysUniStateBase.getPSDEDataSetName());
        }
        if (pSSysUniStateBase.isPSDEIdDirty() && (bl || pSSysUniStateBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSSysUniStateBase.getPSDEId());
        }
        if (pSSysUniStateBase.isPSDENameDirty() && (bl || pSSysUniStateBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSSysUniStateBase.getPSDEName());
        }
        if (pSSysUniStateBase.isPSModuleIdDirty() && (bl || pSSysUniStateBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSSysUniStateBase.getPSModuleId());
        }
        if (pSSysUniStateBase.isPSModuleNameDirty() && (bl || pSSysUniStateBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSSysUniStateBase.getPSModuleName());
        }
        if (pSSysUniStateBase.isPSSysSFPluginIdDirty() && (bl || pSSysUniStateBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSSysUniStateBase.getPSSysSFPluginId());
        }
        if (pSSysUniStateBase.isPSSysSFPluginNameDirty() && (bl || pSSysUniStateBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSSysUniStateBase.getPSSysSFPluginName());
        }
        if (pSSysUniStateBase.isPSSystemIdDirty() && (bl || pSSysUniStateBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysUniStateBase.getPSSystemId());
        }
        if (pSSysUniStateBase.isPSSystemNameDirty() && (bl || pSSysUniStateBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysUniStateBase.getPSSystemName());
        }
        if (pSSysUniStateBase.isPSSysUniStateIdDirty() && (bl || pSSysUniStateBase.getPSSysUniStateId() != null)) {
            iDataObject.set(FIELD_PSSYSUNISTATEID, (Object)pSSysUniStateBase.getPSSysUniStateId());
        }
        if (pSSysUniStateBase.isPSSysUniStateNameDirty() && (bl || pSSysUniStateBase.getPSSysUniStateName() != null)) {
            iDataObject.set(FIELD_PSSYSUNISTATENAME, (Object)pSSysUniStateBase.getPSSysUniStateName());
        }
        if (pSSysUniStateBase.isPSSysUtilDEIdDirty() && (bl || pSSysUniStateBase.getPSSysUtilDEId() != null)) {
            iDataObject.set(FIELD_PSSYSUTILDEID, (Object)pSSysUniStateBase.getPSSysUtilDEId());
        }
        if (pSSysUniStateBase.isPSSysUtilDENameDirty() && (bl || pSSysUniStateBase.getPSSysUtilDEName() != null)) {
            iDataObject.set(FIELD_PSSYSUTILDENAME, (Object)pSSysUniStateBase.getPSSysUtilDEName());
        }
        if (pSSysUniStateBase.isReloadTimerDirty() && (bl || pSSysUniStateBase.getReloadTimer() != null)) {
            iDataObject.set(FIELD_RELOADTIMER, (Object)pSSysUniStateBase.getReloadTimer());
        }
        if (pSSysUniStateBase.isState2PSDEFIdDirty() && (bl || pSSysUniStateBase.getState2PSDEFId() != null)) {
            iDataObject.set(FIELD_STATE2PSDEFID, (Object)pSSysUniStateBase.getState2PSDEFId());
        }
        if (pSSysUniStateBase.isState2PSDEFNameDirty() && (bl || pSSysUniStateBase.getState2PSDEFName() != null)) {
            iDataObject.set(FIELD_STATE2PSDEFNAME, (Object)pSSysUniStateBase.getState2PSDEFName());
        }
        if (pSSysUniStateBase.isState3PSDEFIdDirty() && (bl || pSSysUniStateBase.getState3PSDEFId() != null)) {
            iDataObject.set(FIELD_STATE3PSDEFID, (Object)pSSysUniStateBase.getState3PSDEFId());
        }
        if (pSSysUniStateBase.isState3PSDEFNameDirty() && (bl || pSSysUniStateBase.getState3PSDEFName() != null)) {
            iDataObject.set(FIELD_STATE3PSDEFNAME, (Object)pSSysUniStateBase.getState3PSDEFName());
        }
        if (pSSysUniStateBase.isState4PSDEFIdDirty() && (bl || pSSysUniStateBase.getState4PSDEFId() != null)) {
            iDataObject.set(FIELD_STATE4PSDEFID, (Object)pSSysUniStateBase.getState4PSDEFId());
        }
        if (pSSysUniStateBase.isState4PSDEFNameDirty() && (bl || pSSysUniStateBase.getState4PSDEFName() != null)) {
            iDataObject.set(FIELD_STATE4PSDEFNAME, (Object)pSSysUniStateBase.getState4PSDEFName());
        }
        if (pSSysUniStateBase.isState5PSDEFIdDirty() && (bl || pSSysUniStateBase.getState5PSDEFId() != null)) {
            iDataObject.set(FIELD_STATE5PSDEFID, (Object)pSSysUniStateBase.getState5PSDEFId());
        }
        if (pSSysUniStateBase.isState5PSDEFNameDirty() && (bl || pSSysUniStateBase.getState5PSDEFName() != null)) {
            iDataObject.set(FIELD_STATE5PSDEFNAME, (Object)pSSysUniStateBase.getState5PSDEFName());
        }
        if (pSSysUniStateBase.isState6PSDEFIdDirty() && (bl || pSSysUniStateBase.getState6PSDEFId() != null)) {
            iDataObject.set(FIELD_STATE6PSDEFID, (Object)pSSysUniStateBase.getState6PSDEFId());
        }
        if (pSSysUniStateBase.isState6PSDEFNameDirty() && (bl || pSSysUniStateBase.getState6PSDEFName() != null)) {
            iDataObject.set(FIELD_STATE6PSDEFNAME, (Object)pSSysUniStateBase.getState6PSDEFName());
        }
        if (pSSysUniStateBase.isState7PSDEFIdDirty() && (bl || pSSysUniStateBase.getState7PSDEFId() != null)) {
            iDataObject.set(FIELD_STATE7PSDEFID, (Object)pSSysUniStateBase.getState7PSDEFId());
        }
        if (pSSysUniStateBase.isState7PSDEFNameDirty() && (bl || pSSysUniStateBase.getState7PSDEFName() != null)) {
            iDataObject.set(FIELD_STATE7PSDEFNAME, (Object)pSSysUniStateBase.getState7PSDEFName());
        }
        if (pSSysUniStateBase.isState8PSDEFIdDirty() && (bl || pSSysUniStateBase.getState8PSDEFId() != null)) {
            iDataObject.set(FIELD_STATE8PSDEFID, (Object)pSSysUniStateBase.getState8PSDEFId());
        }
        if (pSSysUniStateBase.isState8PSDEFNameDirty() && (bl || pSSysUniStateBase.getState8PSDEFName() != null)) {
            iDataObject.set(FIELD_STATE8PSDEFNAME, (Object)pSSysUniStateBase.getState8PSDEFName());
        }
        if (pSSysUniStateBase.isStatePSDEFIdDirty() && (bl || pSSysUniStateBase.getStatePSDEFId() != null)) {
            iDataObject.set(FIELD_STATEPSDEFID, (Object)pSSysUniStateBase.getStatePSDEFId());
        }
        if (pSSysUniStateBase.isStatePSDEFNameDirty() && (bl || pSSysUniStateBase.getStatePSDEFName() != null)) {
            iDataObject.set(FIELD_STATEPSDEFNAME, (Object)pSSysUniStateBase.getStatePSDEFName());
        }
        if (pSSysUniStateBase.isUniqueTagDirty() && (bl || pSSysUniStateBase.getUniqueTag() != null)) {
            iDataObject.set(FIELD_UNIQUETAG, (Object)pSSysUniStateBase.getUniqueTag());
        }
        if (pSSysUniStateBase.isUniStateModeDirty() && (bl || pSSysUniStateBase.getUniStateMode() != null)) {
            iDataObject.set(FIELD_UNISTATEMODE, (Object)pSSysUniStateBase.getUniStateMode());
        }
        if (pSSysUniStateBase.isUniStateParamsDirty() && (bl || pSSysUniStateBase.getUniStateParams() != null)) {
            iDataObject.set(FIELD_UNISTATEPARAMS, (Object)pSSysUniStateBase.getUniStateParams());
        }
        if (pSSysUniStateBase.isUniStateTagDirty() && (bl || pSSysUniStateBase.getUniStateTag() != null)) {
            iDataObject.set(FIELD_UNISTATETAG, (Object)pSSysUniStateBase.getUniStateTag());
        }
        if (pSSysUniStateBase.isUniStateTag2Dirty() && (bl || pSSysUniStateBase.getUniStateTag2() != null)) {
            iDataObject.set(FIELD_UNISTATETAG2, (Object)pSSysUniStateBase.getUniStateTag2());
        }
        if (pSSysUniStateBase.isUniStateTypeDirty() && (bl || pSSysUniStateBase.getUniStateType() != null)) {
            iDataObject.set(FIELD_UNISTATETYPE, (Object)pSSysUniStateBase.getUniStateType());
        }
        if (pSSysUniStateBase.isUpdateDateDirty() && (bl || pSSysUniStateBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysUniStateBase.getUpdateDate());
        }
        if (pSSysUniStateBase.isUpdateManDirty() && (bl || pSSysUniStateBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysUniStateBase.getUpdateMan());
        }
        if (pSSysUniStateBase.isUserCatDirty() && (bl || pSSysUniStateBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysUniStateBase.getUserCat());
        }
        if (pSSysUniStateBase.isUserTagDirty() && (bl || pSSysUniStateBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysUniStateBase.getUserTag());
        }
        if (pSSysUniStateBase.isUserTag2Dirty() && (bl || pSSysUniStateBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysUniStateBase.getUserTag2());
        }
        if (pSSysUniStateBase.isUserTag3Dirty() && (bl || pSSysUniStateBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysUniStateBase.getUserTag3());
        }
        if (pSSysUniStateBase.isUserTag4Dirty() && (bl || pSSysUniStateBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysUniStateBase.getUserTag4());
        }
        if (pSSysUniStateBase.isValidFlagDirty() && (bl || pSSysUniStateBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysUniStateBase.getValidFlag());
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
        return PSSysUniStateBase.remove(this, n);
    }

    private static boolean remove(PSSysUniStateBase pSSysUniStateBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysUniStateBase.resetAllDataFlag();
                return true;
            }
            case 1: {
                pSSysUniStateBase.resetCacheCat();
                return true;
            }
            case 2: {
                pSSysUniStateBase.resetCacheScope();
                return true;
            }
            case 3: {
                pSSysUniStateBase.resetCacheTimeout();
                return true;
            }
            case 4: {
                pSSysUniStateBase.resetCreateDate();
                return true;
            }
            case 5: {
                pSSysUniStateBase.resetCreateMan();
                return true;
            }
            case 6: {
                pSSysUniStateBase.resetCustomCode();
                return true;
            }
            case 7: {
                pSSysUniStateBase.resetCustomMode();
                return true;
            }
            case 8: {
                pSSysUniStateBase.resetDEDefaultFlag();
                return true;
            }
            case 9: {
                pSSysUniStateBase.resetDeleteAsUpdate();
                return true;
            }
            case 10: {
                pSSysUniStateBase.resetInitPSDELogicId();
                return true;
            }
            case 11: {
                pSSysUniStateBase.resetInitPSDELogicName();
                return true;
            }
            case 12: {
                pSSysUniStateBase.resetKey2PSDEFId();
                return true;
            }
            case 13: {
                pSSysUniStateBase.resetKey2PSDEFName();
                return true;
            }
            case 14: {
                pSSysUniStateBase.resetKey3PSDEFId();
                return true;
            }
            case 15: {
                pSSysUniStateBase.resetKey3PSDEFName();
                return true;
            }
            case 16: {
                pSSysUniStateBase.resetKey4PSDEFId();
                return true;
            }
            case 17: {
                pSSysUniStateBase.resetKey4PSDEFName();
                return true;
            }
            case 18: {
                pSSysUniStateBase.resetKey5PSDEFId();
                return true;
            }
            case 19: {
                pSSysUniStateBase.resetKey5PSDEFName();
                return true;
            }
            case 20: {
                pSSysUniStateBase.resetKey6PSDEFId();
                return true;
            }
            case 21: {
                pSSysUniStateBase.resetKey6PSDEFName();
                return true;
            }
            case 22: {
                pSSysUniStateBase.resetKey7PSDEFId();
                return true;
            }
            case 23: {
                pSSysUniStateBase.resetKey7PSDEFName();
                return true;
            }
            case 24: {
                pSSysUniStateBase.resetKey8PSDEFId();
                return true;
            }
            case 25: {
                pSSysUniStateBase.resetKey8PSDEFName();
                return true;
            }
            case 26: {
                pSSysUniStateBase.resetKey9PSDEFId();
                return true;
            }
            case 27: {
                pSSysUniStateBase.resetKey9PSDEFName();
                return true;
            }
            case 28: {
                pSSysUniStateBase.resetKeyFormat();
                return true;
            }
            case 29: {
                pSSysUniStateBase.resetKeyPSDEFId();
                return true;
            }
            case 30: {
                pSSysUniStateBase.resetKeyPSDEFName();
                return true;
            }
            case 31: {
                pSSysUniStateBase.resetLockFlag();
                return true;
            }
            case 32: {
                pSSysUniStateBase.resetMemo();
                return true;
            }
            case 33: {
                pSSysUniStateBase.resetMonitorFormat();
                return true;
            }
            case 34: {
                pSSysUniStateBase.resetOnChangePSDELogicId();
                return true;
            }
            case 35: {
                pSSysUniStateBase.resetOnChangePSDELogicName();
                return true;
            }
            case 36: {
                pSSysUniStateBase.resetOnDeletePSDELogicId();
                return true;
            }
            case 37: {
                pSSysUniStateBase.resetOnDeletePSDELogicName();
                return true;
            }
            case 38: {
                pSSysUniStateBase.resetPSDEDataSetId();
                return true;
            }
            case 39: {
                pSSysUniStateBase.resetPSDEDataSetName();
                return true;
            }
            case 40: {
                pSSysUniStateBase.resetPSDEId();
                return true;
            }
            case 41: {
                pSSysUniStateBase.resetPSDEName();
                return true;
            }
            case 42: {
                pSSysUniStateBase.resetPSModuleId();
                return true;
            }
            case 43: {
                pSSysUniStateBase.resetPSModuleName();
                return true;
            }
            case 44: {
                pSSysUniStateBase.resetPSSysSFPluginId();
                return true;
            }
            case 45: {
                pSSysUniStateBase.resetPSSysSFPluginName();
                return true;
            }
            case 46: {
                pSSysUniStateBase.resetPSSystemId();
                return true;
            }
            case 47: {
                pSSysUniStateBase.resetPSSystemName();
                return true;
            }
            case 48: {
                pSSysUniStateBase.resetPSSysUniStateId();
                return true;
            }
            case 49: {
                pSSysUniStateBase.resetPSSysUniStateName();
                return true;
            }
            case 50: {
                pSSysUniStateBase.resetPSSysUtilDEId();
                return true;
            }
            case 51: {
                pSSysUniStateBase.resetPSSysUtilDEName();
                return true;
            }
            case 52: {
                pSSysUniStateBase.resetReloadTimer();
                return true;
            }
            case 53: {
                pSSysUniStateBase.resetState2PSDEFId();
                return true;
            }
            case 54: {
                pSSysUniStateBase.resetState2PSDEFName();
                return true;
            }
            case 55: {
                pSSysUniStateBase.resetState3PSDEFId();
                return true;
            }
            case 56: {
                pSSysUniStateBase.resetState3PSDEFName();
                return true;
            }
            case 57: {
                pSSysUniStateBase.resetState4PSDEFId();
                return true;
            }
            case 58: {
                pSSysUniStateBase.resetState4PSDEFName();
                return true;
            }
            case 59: {
                pSSysUniStateBase.resetState5PSDEFId();
                return true;
            }
            case 60: {
                pSSysUniStateBase.resetState5PSDEFName();
                return true;
            }
            case 61: {
                pSSysUniStateBase.resetState6PSDEFId();
                return true;
            }
            case 62: {
                pSSysUniStateBase.resetState6PSDEFName();
                return true;
            }
            case 63: {
                pSSysUniStateBase.resetState7PSDEFId();
                return true;
            }
            case 64: {
                pSSysUniStateBase.resetState7PSDEFName();
                return true;
            }
            case 65: {
                pSSysUniStateBase.resetState8PSDEFId();
                return true;
            }
            case 66: {
                pSSysUniStateBase.resetState8PSDEFName();
                return true;
            }
            case 67: {
                pSSysUniStateBase.resetStatePSDEFId();
                return true;
            }
            case 68: {
                pSSysUniStateBase.resetStatePSDEFName();
                return true;
            }
            case 69: {
                pSSysUniStateBase.resetUniqueTag();
                return true;
            }
            case 70: {
                pSSysUniStateBase.resetUniStateMode();
                return true;
            }
            case 71: {
                pSSysUniStateBase.resetUniStateParams();
                return true;
            }
            case 72: {
                pSSysUniStateBase.resetUniStateTag();
                return true;
            }
            case 73: {
                pSSysUniStateBase.resetUniStateTag2();
                return true;
            }
            case 74: {
                pSSysUniStateBase.resetUniStateType();
                return true;
            }
            case 75: {
                pSSysUniStateBase.resetUpdateDate();
                return true;
            }
            case 76: {
                pSSysUniStateBase.resetUpdateMan();
                return true;
            }
            case 77: {
                pSSysUniStateBase.resetUserCat();
                return true;
            }
            case 78: {
                pSSysUniStateBase.resetUserTag();
                return true;
            }
            case 79: {
                pSSysUniStateBase.resetUserTag2();
                return true;
            }
            case 80: {
                pSSysUniStateBase.resetUserTag3();
                return true;
            }
            case 81: {
                pSSysUniStateBase.resetUserTag4();
                return true;
            }
            case 82: {
                pSSysUniStateBase.resetValidFlag();
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
    public PSDEDataSet getPSDEDataSet() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataSet();
        }
        if (this.getPSDEDataSetId() == null) {
            return null;
        }
        Integer n = this.objPSDEDataSetLock;
        synchronized (n) {
            if (this.psdedataset != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEDataSetId(), (Object)this.psdedataset.getPSDEDataSetId()) != 0L) {
                this.psdedataset = null;
            }
            if (this.psdedataset == null) {
                PSDEDataSet pSDEDataSet = new PSDEDataSet();
                pSDEDataSet.setPSDEDataSetId(this.getPSDEDataSetId());
                PSDEDataSetService pSDEDataSetService = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataSetService.autoGet(pSDEDataSet);
                this.psdedataset = pSDEDataSet;
            }
            return this.psdedataset;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getKey2PSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getKey2PSDEF();
        }
        if (this.getKey2PSDEFId() == null) {
            return null;
        }
        Integer n = this.objKey2PSDEFLock;
        synchronized (n) {
            if (this.key2psdef != null && DataTypeHelper.compare((int)25, (Object)this.getKey2PSDEFId(), (Object)this.key2psdef.getPSDEFieldId()) != 0L) {
                this.key2psdef = null;
            }
            if (this.key2psdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getKey2PSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.key2psdef = pSDEField;
            }
            return this.key2psdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getKey3PSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getKey3PSDEF();
        }
        if (this.getKey3PSDEFId() == null) {
            return null;
        }
        Integer n = this.objKey3PSDEFLock;
        synchronized (n) {
            if (this.key3psdef != null && DataTypeHelper.compare((int)25, (Object)this.getKey3PSDEFId(), (Object)this.key3psdef.getPSDEFieldId()) != 0L) {
                this.key3psdef = null;
            }
            if (this.key3psdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getKey3PSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.key3psdef = pSDEField;
            }
            return this.key3psdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getKey4PSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getKey4PSDEF();
        }
        if (this.getKey4PSDEFId() == null) {
            return null;
        }
        Integer n = this.objKey4PSDEFLock;
        synchronized (n) {
            if (this.key4psdef != null && DataTypeHelper.compare((int)25, (Object)this.getKey4PSDEFId(), (Object)this.key4psdef.getPSDEFieldId()) != 0L) {
                this.key4psdef = null;
            }
            if (this.key4psdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getKey4PSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.key4psdef = pSDEField;
            }
            return this.key4psdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getKey5PSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getKey5PSDEF();
        }
        if (this.getKey5PSDEFId() == null) {
            return null;
        }
        Integer n = this.objKey5PSDEFLock;
        synchronized (n) {
            if (this.key5psdef != null && DataTypeHelper.compare((int)25, (Object)this.getKey5PSDEFId(), (Object)this.key5psdef.getPSDEFieldId()) != 0L) {
                this.key5psdef = null;
            }
            if (this.key5psdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getKey5PSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.key5psdef = pSDEField;
            }
            return this.key5psdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getKey6PSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getKey6PSDEF();
        }
        if (this.getKey6PSDEFId() == null) {
            return null;
        }
        Integer n = this.objKey6PSDEFLock;
        synchronized (n) {
            if (this.key6psdef != null && DataTypeHelper.compare((int)25, (Object)this.getKey6PSDEFId(), (Object)this.key6psdef.getPSDEFieldId()) != 0L) {
                this.key6psdef = null;
            }
            if (this.key6psdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getKey6PSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.key6psdef = pSDEField;
            }
            return this.key6psdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getKey7PSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getKey7PSDEF();
        }
        if (this.getKey7PSDEFId() == null) {
            return null;
        }
        Integer n = this.objKey7PSDEFLock;
        synchronized (n) {
            if (this.key7psdef != null && DataTypeHelper.compare((int)25, (Object)this.getKey7PSDEFId(), (Object)this.key7psdef.getPSDEFieldId()) != 0L) {
                this.key7psdef = null;
            }
            if (this.key7psdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getKey7PSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.key7psdef = pSDEField;
            }
            return this.key7psdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getKey8PSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getKey8PSDEF();
        }
        if (this.getKey8PSDEFId() == null) {
            return null;
        }
        Integer n = this.objKey8PSDEFLock;
        synchronized (n) {
            if (this.key8psdef != null && DataTypeHelper.compare((int)25, (Object)this.getKey8PSDEFId(), (Object)this.key8psdef.getPSDEFieldId()) != 0L) {
                this.key8psdef = null;
            }
            if (this.key8psdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getKey8PSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.key8psdef = pSDEField;
            }
            return this.key8psdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getKey9PSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getKey9PSDEF();
        }
        if (this.getKey9PSDEFId() == null) {
            return null;
        }
        Integer n = this.objKey9PSDEFLock;
        synchronized (n) {
            if (this.key9psdef != null && DataTypeHelper.compare((int)25, (Object)this.getKey9PSDEFId(), (Object)this.key9psdef.getPSDEFieldId()) != 0L) {
                this.key9psdef = null;
            }
            if (this.key9psdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getKey9PSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.key9psdef = pSDEField;
            }
            return this.key9psdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getKeyPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getKeyPSDEF();
        }
        if (this.getKeyPSDEFId() == null) {
            return null;
        }
        Integer n = this.objKeyPSDEFLock;
        synchronized (n) {
            if (this.keypsdef != null && DataTypeHelper.compare((int)25, (Object)this.getKeyPSDEFId(), (Object)this.keypsdef.getPSDEFieldId()) != 0L) {
                this.keypsdef = null;
            }
            if (this.keypsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getKeyPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.keypsdef = pSDEField;
            }
            return this.keypsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getState2PSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getState2PSDEF();
        }
        if (this.getState2PSDEFId() == null) {
            return null;
        }
        Integer n = this.objState2PSDEFLock;
        synchronized (n) {
            if (this.state2psdef != null && DataTypeHelper.compare((int)25, (Object)this.getState2PSDEFId(), (Object)this.state2psdef.getPSDEFieldId()) != 0L) {
                this.state2psdef = null;
            }
            if (this.state2psdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getState2PSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.state2psdef = pSDEField;
            }
            return this.state2psdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getState3PSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getState3PSDEF();
        }
        if (this.getState3PSDEFId() == null) {
            return null;
        }
        Integer n = this.objState3PSDEFLock;
        synchronized (n) {
            if (this.state3psdef != null && DataTypeHelper.compare((int)25, (Object)this.getState3PSDEFId(), (Object)this.state3psdef.getPSDEFieldId()) != 0L) {
                this.state3psdef = null;
            }
            if (this.state3psdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getState3PSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.state3psdef = pSDEField;
            }
            return this.state3psdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getState4PSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getState4PSDEF();
        }
        if (this.getState4PSDEFId() == null) {
            return null;
        }
        Integer n = this.objState4PSDEFLock;
        synchronized (n) {
            if (this.state4psdef != null && DataTypeHelper.compare((int)25, (Object)this.getState4PSDEFId(), (Object)this.state4psdef.getPSDEFieldId()) != 0L) {
                this.state4psdef = null;
            }
            if (this.state4psdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getState4PSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.state4psdef = pSDEField;
            }
            return this.state4psdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getState5PSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getState5PSDEF();
        }
        if (this.getState5PSDEFId() == null) {
            return null;
        }
        Integer n = this.objState5PSDEFLock;
        synchronized (n) {
            if (this.state5psdef != null && DataTypeHelper.compare((int)25, (Object)this.getState5PSDEFId(), (Object)this.state5psdef.getPSDEFieldId()) != 0L) {
                this.state5psdef = null;
            }
            if (this.state5psdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getState5PSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.state5psdef = pSDEField;
            }
            return this.state5psdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getState6PSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getState6PSDEF();
        }
        if (this.getState6PSDEFId() == null) {
            return null;
        }
        Integer n = this.objState6PSDEFLock;
        synchronized (n) {
            if (this.state6psdef != null && DataTypeHelper.compare((int)25, (Object)this.getState6PSDEFId(), (Object)this.state6psdef.getPSDEFieldId()) != 0L) {
                this.state6psdef = null;
            }
            if (this.state6psdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getState6PSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.state6psdef = pSDEField;
            }
            return this.state6psdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getState7PSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getState7PSDEF();
        }
        if (this.getState7PSDEFId() == null) {
            return null;
        }
        Integer n = this.objState7PSDEFLock;
        synchronized (n) {
            if (this.state7psdef != null && DataTypeHelper.compare((int)25, (Object)this.getState7PSDEFId(), (Object)this.state7psdef.getPSDEFieldId()) != 0L) {
                this.state7psdef = null;
            }
            if (this.state7psdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getState7PSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.state7psdef = pSDEField;
            }
            return this.state7psdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getState8PSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getState8PSDEF();
        }
        if (this.getState8PSDEFId() == null) {
            return null;
        }
        Integer n = this.objState8PSDEFLock;
        synchronized (n) {
            if (this.state8psdef != null && DataTypeHelper.compare((int)25, (Object)this.getState8PSDEFId(), (Object)this.state8psdef.getPSDEFieldId()) != 0L) {
                this.state8psdef = null;
            }
            if (this.state8psdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getState8PSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.state8psdef = pSDEField;
            }
            return this.state8psdef;
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
    public PSDELogic getInitPSDELogic() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInitPSDELogic();
        }
        if (this.getInitPSDELogicId() == null) {
            return null;
        }
        Integer n = this.objInitPSDELogicLock;
        synchronized (n) {
            if (this.initpsdelogic != null && DataTypeHelper.compare((int)25, (Object)this.getInitPSDELogicId(), (Object)this.initpsdelogic.getPSDELogicId()) != 0L) {
                this.initpsdelogic = null;
            }
            if (this.initpsdelogic == null) {
                PSDELogic pSDELogic = new PSDELogic();
                pSDELogic.setPSDELogicId(this.getInitPSDELogicId());
                PSDELogicService pSDELogicService = (PSDELogicService)ServiceGlobal.getService(PSDELogicService.class, (SessionFactory)this.getSessionFactory());
                pSDELogicService.autoGet(pSDELogic);
                this.initpsdelogic = pSDELogic;
            }
            return this.initpsdelogic;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDELogic getOnChangePSDELogic() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOnChangePSDELogic();
        }
        if (this.getOnChangePSDELogicId() == null) {
            return null;
        }
        Integer n = this.objOnChangePSDELogicLock;
        synchronized (n) {
            if (this.onchangepsdelogic != null && DataTypeHelper.compare((int)25, (Object)this.getOnChangePSDELogicId(), (Object)this.onchangepsdelogic.getPSDELogicId()) != 0L) {
                this.onchangepsdelogic = null;
            }
            if (this.onchangepsdelogic == null) {
                PSDELogic pSDELogic = new PSDELogic();
                pSDELogic.setPSDELogicId(this.getOnChangePSDELogicId());
                PSDELogicService pSDELogicService = (PSDELogicService)ServiceGlobal.getService(PSDELogicService.class, (SessionFactory)this.getSessionFactory());
                pSDELogicService.autoGet(pSDELogic);
                this.onchangepsdelogic = pSDELogic;
            }
            return this.onchangepsdelogic;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDELogic getOnDeletePSDELogic() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOnDeletePSDELogic();
        }
        if (this.getOnDeletePSDELogicId() == null) {
            return null;
        }
        Integer n = this.objOnDeletePSDELogicLock;
        synchronized (n) {
            if (this.ondeletepsdelogic != null && DataTypeHelper.compare((int)25, (Object)this.getOnDeletePSDELogicId(), (Object)this.ondeletepsdelogic.getPSDELogicId()) != 0L) {
                this.ondeletepsdelogic = null;
            }
            if (this.ondeletepsdelogic == null) {
                PSDELogic pSDELogic = new PSDELogic();
                pSDELogic.setPSDELogicId(this.getOnDeletePSDELogicId());
                PSDELogicService pSDELogicService = (PSDELogicService)ServiceGlobal.getService(PSDELogicService.class, (SessionFactory)this.getSessionFactory());
                pSDELogicService.autoGet(pSDELogic);
                this.ondeletepsdelogic = pSDELogic;
            }
            return this.ondeletepsdelogic;
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
    public PSSysUtilDE getPSSysUtilDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUtilDE();
        }
        if (this.getPSSysUtilDEId() == null) {
            return null;
        }
        Integer n = this.objPSSysUtilDELock;
        synchronized (n) {
            if (this.pssysutilde != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysUtilDEId(), (Object)this.pssysutilde.getPSSysUtilDEId()) != 0L) {
                this.pssysutilde = null;
            }
            if (this.pssysutilde == null) {
                PSSysUtilDE pSSysUtilDE = new PSSysUtilDE();
                pSSysUtilDE.setPSSysUtilDEId(this.getPSSysUtilDEId());
                PSSysUtilDEService pSSysUtilDEService = (PSSysUtilDEService)ServiceGlobal.getService(PSSysUtilDEService.class, (SessionFactory)this.getSessionFactory());
                pSSysUtilDEService.autoGet(pSSysUtilDE);
                this.pssysutilde = pSSysUtilDE;
            }
            return this.pssysutilde;
        }
    }

    private PSSysUniStateBase getProxyEntity() {
        return this.proxyPSSysUniStateBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysUniStateBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysUniStateBase) {
            this.proxyPSSysUniStateBase = (PSSysUniStateBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysUniStateService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ALLDATAFLAG, 0);
        fieldIndexMap.put(FIELD_CACHECAT, 1);
        fieldIndexMap.put(FIELD_CACHESCOPE, 2);
        fieldIndexMap.put(FIELD_CACHETIMEOUT, 3);
        fieldIndexMap.put(FIELD_CREATEDATE, 4);
        fieldIndexMap.put(FIELD_CREATEMAN, 5);
        fieldIndexMap.put(FIELD_CUSTOMCODE, 6);
        fieldIndexMap.put(FIELD_CUSTOMMODE, 7);
        fieldIndexMap.put(FIELD_DEDEFAULTFLAG, 8);
        fieldIndexMap.put(FIELD_DELETEASUPDATE, 9);
        fieldIndexMap.put(FIELD_INITPSDELOGICID, 10);
        fieldIndexMap.put(FIELD_INITPSDELOGICNAME, 11);
        fieldIndexMap.put(FIELD_KEY2PSDEFID, 12);
        fieldIndexMap.put(FIELD_KEY2PSDEFNAME, 13);
        fieldIndexMap.put(FIELD_KEY3PSDEFID, 14);
        fieldIndexMap.put(FIELD_KEY3PSDEFNAME, 15);
        fieldIndexMap.put(FIELD_KEY4PSDEFID, 16);
        fieldIndexMap.put(FIELD_KEY4PSDEFNAME, 17);
        fieldIndexMap.put(FIELD_KEY5PSDEFID, 18);
        fieldIndexMap.put(FIELD_KEY5PSDEFNAME, 19);
        fieldIndexMap.put(FIELD_KEY6PSDEFID, 20);
        fieldIndexMap.put(FIELD_KEY6PSDEFNAME, 21);
        fieldIndexMap.put(FIELD_KEY7PSDEFID, 22);
        fieldIndexMap.put(FIELD_KEY7PSDEFNAME, 23);
        fieldIndexMap.put(FIELD_KEY8PSDEFID, 24);
        fieldIndexMap.put(FIELD_KEY8PSDEFNAME, 25);
        fieldIndexMap.put(FIELD_KEY9PSDEFID, 26);
        fieldIndexMap.put(FIELD_KEY9PSDEFNAME, 27);
        fieldIndexMap.put(FIELD_KEYFORMAT, 28);
        fieldIndexMap.put(FIELD_KEYPSDEFID, 29);
        fieldIndexMap.put(FIELD_KEYPSDEFNAME, 30);
        fieldIndexMap.put(FIELD_LOCKFLAG, 31);
        fieldIndexMap.put(FIELD_MEMO, 32);
        fieldIndexMap.put(FIELD_MONITORFORMAT, 33);
        fieldIndexMap.put(FIELD_ONCHANGEPSDELOGICID, 34);
        fieldIndexMap.put(FIELD_ONCHANGEPSDELOGICNAME, 35);
        fieldIndexMap.put(FIELD_ONDELETEPSDELOGICID, 36);
        fieldIndexMap.put(FIELD_ONDELETEPSDELOGICNAME, 37);
        fieldIndexMap.put(FIELD_PSDEDATASETID, 38);
        fieldIndexMap.put(FIELD_PSDEDATASETNAME, 39);
        fieldIndexMap.put(FIELD_PSDEID, 40);
        fieldIndexMap.put(FIELD_PSDENAME, 41);
        fieldIndexMap.put(FIELD_PSMODULEID, 42);
        fieldIndexMap.put(FIELD_PSMODULENAME, 43);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 44);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 45);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 46);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 47);
        fieldIndexMap.put(FIELD_PSSYSUNISTATEID, 48);
        fieldIndexMap.put(FIELD_PSSYSUNISTATENAME, 49);
        fieldIndexMap.put(FIELD_PSSYSUTILDEID, 50);
        fieldIndexMap.put(FIELD_PSSYSUTILDENAME, 51);
        fieldIndexMap.put(FIELD_RELOADTIMER, 52);
        fieldIndexMap.put(FIELD_STATE2PSDEFID, 53);
        fieldIndexMap.put(FIELD_STATE2PSDEFNAME, 54);
        fieldIndexMap.put(FIELD_STATE3PSDEFID, 55);
        fieldIndexMap.put(FIELD_STATE3PSDEFNAME, 56);
        fieldIndexMap.put(FIELD_STATE4PSDEFID, 57);
        fieldIndexMap.put(FIELD_STATE4PSDEFNAME, 58);
        fieldIndexMap.put(FIELD_STATE5PSDEFID, 59);
        fieldIndexMap.put(FIELD_STATE5PSDEFNAME, 60);
        fieldIndexMap.put(FIELD_STATE6PSDEFID, 61);
        fieldIndexMap.put(FIELD_STATE6PSDEFNAME, 62);
        fieldIndexMap.put(FIELD_STATE7PSDEFID, 63);
        fieldIndexMap.put(FIELD_STATE7PSDEFNAME, 64);
        fieldIndexMap.put(FIELD_STATE8PSDEFID, 65);
        fieldIndexMap.put(FIELD_STATE8PSDEFNAME, 66);
        fieldIndexMap.put(FIELD_STATEPSDEFID, 67);
        fieldIndexMap.put(FIELD_STATEPSDEFNAME, 68);
        fieldIndexMap.put(FIELD_UNIQUETAG, 69);
        fieldIndexMap.put(FIELD_UNISTATEMODE, 70);
        fieldIndexMap.put(FIELD_UNISTATEPARAMS, 71);
        fieldIndexMap.put(FIELD_UNISTATETAG, 72);
        fieldIndexMap.put(FIELD_UNISTATETAG2, 73);
        fieldIndexMap.put(FIELD_UNISTATETYPE, 74);
        fieldIndexMap.put(FIELD_UPDATEDATE, 75);
        fieldIndexMap.put(FIELD_UPDATEMAN, 76);
        fieldIndexMap.put(FIELD_USERCAT, 77);
        fieldIndexMap.put(FIELD_USERTAG, 78);
        fieldIndexMap.put(FIELD_USERTAG2, 79);
        fieldIndexMap.put(FIELD_USERTAG3, 80);
        fieldIndexMap.put(FIELD_USERTAG4, 81);
        fieldIndexMap.put(FIELD_VALIDFLAG, 82);
    }
}

