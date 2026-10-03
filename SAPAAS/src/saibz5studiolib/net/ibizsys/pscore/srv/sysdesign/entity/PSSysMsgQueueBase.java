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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUtilDE;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUtilDEService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysMsgQueueBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysMsgQueueBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CONTENTPSDEFID = "CONTENTPSDEFID";
    public static final String FIELD_CONTENTPSDEFNAME = "CONTENTPSDEFNAME";
    public static final String FIELD_CONTENTTYPEPSDEFID = "CONTENTTYPEPSDEFID";
    public static final String FIELD_CONTENTTYPEPSDEFNAME = "CONTENTTYPEPSDEFNAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMCODE = "CUSTOMCODE";
    public static final String FIELD_CUSTOMMODE = "CUSTOMMODE";
    public static final String FIELD_DDCONTENTPSDEFID = "DDCONTENTPSDEFID";
    public static final String FIELD_DDCONTENTPSDEFNAME = "DDCONTENTPSDEFNAME";
    public static final String FIELD_FILEPSDEFID = "FILEPSDEFID";
    public static final String FIELD_FILEPSDEFNAME = "FILEPSDEFNAME";
    public static final String FIELD_IMCONTENTPSDEFID = "IMCONTENTPSDEFID";
    public static final String FIELD_IMCONTENTPSDEFNAME = "IMCONTENTPSDEFNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MOBTASKURLPSDEFID = "MOBTASKURLPSDEFID";
    public static final String FIELD_MOBTASKURLPSDEFNAME = "MOBTASKURLPSDEFNAME";
    public static final String FIELD_MSGQUEUEPARAMS = "MSGQUEUEPARAMS";
    public static final String FIELD_MSGQUEUETAG = "MSGQUEUETAG";
    public static final String FIELD_MSGQUEUETAG2 = "MSGQUEUETAG2";
    public static final String FIELD_MSGQUEUETYPE = "MSGQUEUETYPE";
    public static final String FIELD_MSGTYPEPSDEFID = "MSGTYPEPSDEFID";
    public static final String FIELD_MSGTYPEPSDEFNAME = "MSGTYPEPSDEFNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String FIELD_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String FIELD_PSSYSMSGQUEUEID = "PSSYSMSGQUEUEID";
    public static final String FIELD_PSSYSMSGQUEUENAME = "PSSYSMSGQUEUENAME";
    public static final String FIELD_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String FIELD_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_PSSYSUTILDEID = "PSSYSUTILDEID";
    public static final String FIELD_PSSYSUTILDENAME = "PSSYSUTILDENAME";
    public static final String FIELD_QUEUEPARAMS = "QUEUEPARAMS";
    public static final String FIELD_SENDTIMEPSDEFID = "SENDTIMEPSDEFID";
    public static final String FIELD_SENDTIMEPSDEFNAME = "SENDTIMEPSDEFNAME";
    public static final String FIELD_SMSCONTENTPSDEFID = "SMSCONTENTPSDEFID";
    public static final String FIELD_SMSCONTENTPSDEFNAME = "SMSCONTENTPSDEFNAME";
    public static final String FIELD_STATEPSDEFID = "STATEPSDEFID";
    public static final String FIELD_STATEPSDEFNAME = "STATEPSDEFNAME";
    public static final String FIELD_TAG2PSDEFID = "TAG2PSDEFID";
    public static final String FIELD_TAG2PSDEFNAME = "TAG2PSDEFNAME";
    public static final String FIELD_TAGPSDEFID = "TAGPSDEFID";
    public static final String FIELD_TAGPSDEFNAME = "TAGPSDEFNAME";
    public static final String FIELD_TARGETPSDEFID = "TARGETPSDEFID";
    public static final String FIELD_TARGETPSDEFNAME = "TARGETPSDEFNAME";
    public static final String FIELD_TARGETTYPEPSDEFID = "TARGETTYPEPSDEFID";
    public static final String FIELD_TARGETTYPEPSDEFNAME = "TARGETTYPEPSDEFNAME";
    public static final String FIELD_TASKURLPSDEFID = "TASKURLPSDEFID";
    public static final String FIELD_TASKURLPSDEFNAME = "TASKURLPSDEFNAME";
    public static final String FIELD_TITLEPSDEFID = "TITLEPSDEFID";
    public static final String FIELD_TITLEPSDEFNAME = "TITLEPSDEFNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USER2PSDEFID = "USER2PSDEFID";
    public static final String FIELD_USER2PSDEFNAME = "USER2PSDEFNAME";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERPSDEFID = "USERPSDEFID";
    public static final String FIELD_USERPSDEFNAME = "USERPSDEFNAME";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    public static final String FIELD_WXCONTENTPSDEFID = "WXCONTENTPSDEFID";
    public static final String FIELD_WXCONTENTPSDEFNAME = "WXCONTENTPSDEFNAME";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CONTENTPSDEFID = 1;
    private static final int INDEX_CONTENTPSDEFNAME = 2;
    private static final int INDEX_CONTENTTYPEPSDEFID = 3;
    private static final int INDEX_CONTENTTYPEPSDEFNAME = 4;
    private static final int INDEX_CREATEDATE = 5;
    private static final int INDEX_CREATEMAN = 6;
    private static final int INDEX_CUSTOMCODE = 7;
    private static final int INDEX_CUSTOMMODE = 8;
    private static final int INDEX_DDCONTENTPSDEFID = 9;
    private static final int INDEX_DDCONTENTPSDEFNAME = 10;
    private static final int INDEX_FILEPSDEFID = 11;
    private static final int INDEX_FILEPSDEFNAME = 12;
    private static final int INDEX_IMCONTENTPSDEFID = 13;
    private static final int INDEX_IMCONTENTPSDEFNAME = 14;
    private static final int INDEX_MEMO = 15;
    private static final int INDEX_MOBTASKURLPSDEFID = 16;
    private static final int INDEX_MOBTASKURLPSDEFNAME = 17;
    private static final int INDEX_MSGQUEUEPARAMS = 18;
    private static final int INDEX_MSGQUEUETAG = 19;
    private static final int INDEX_MSGQUEUETAG2 = 20;
    private static final int INDEX_MSGQUEUETYPE = 21;
    private static final int INDEX_MSGTYPEPSDEFID = 22;
    private static final int INDEX_MSGTYPEPSDEFNAME = 23;
    private static final int INDEX_PSDEID = 24;
    private static final int INDEX_PSDENAME = 25;
    private static final int INDEX_PSMODULEID = 26;
    private static final int INDEX_PSMODULENAME = 27;
    private static final int INDEX_PSSYSDYNAMODELID = 28;
    private static final int INDEX_PSSYSDYNAMODELNAME = 29;
    private static final int INDEX_PSSYSMSGQUEUEID = 30;
    private static final int INDEX_PSSYSMSGQUEUENAME = 31;
    private static final int INDEX_PSSYSSFPLUGINID = 32;
    private static final int INDEX_PSSYSSFPLUGINNAME = 33;
    private static final int INDEX_PSSYSTEMID = 34;
    private static final int INDEX_PSSYSTEMNAME = 35;
    private static final int INDEX_PSSYSUTILDEID = 36;
    private static final int INDEX_PSSYSUTILDENAME = 37;
    private static final int INDEX_QUEUEPARAMS = 38;
    private static final int INDEX_SENDTIMEPSDEFID = 39;
    private static final int INDEX_SENDTIMEPSDEFNAME = 40;
    private static final int INDEX_SMSCONTENTPSDEFID = 41;
    private static final int INDEX_SMSCONTENTPSDEFNAME = 42;
    private static final int INDEX_STATEPSDEFID = 43;
    private static final int INDEX_STATEPSDEFNAME = 44;
    private static final int INDEX_TAG2PSDEFID = 45;
    private static final int INDEX_TAG2PSDEFNAME = 46;
    private static final int INDEX_TAGPSDEFID = 47;
    private static final int INDEX_TAGPSDEFNAME = 48;
    private static final int INDEX_TARGETPSDEFID = 49;
    private static final int INDEX_TARGETPSDEFNAME = 50;
    private static final int INDEX_TARGETTYPEPSDEFID = 51;
    private static final int INDEX_TARGETTYPEPSDEFNAME = 52;
    private static final int INDEX_TASKURLPSDEFID = 53;
    private static final int INDEX_TASKURLPSDEFNAME = 54;
    private static final int INDEX_TITLEPSDEFID = 55;
    private static final int INDEX_TITLEPSDEFNAME = 56;
    private static final int INDEX_UPDATEDATE = 57;
    private static final int INDEX_UPDATEMAN = 58;
    private static final int INDEX_USER2PSDEFID = 59;
    private static final int INDEX_USER2PSDEFNAME = 60;
    private static final int INDEX_USERCAT = 61;
    private static final int INDEX_USERPSDEFID = 62;
    private static final int INDEX_USERPSDEFNAME = 63;
    private static final int INDEX_USERTAG = 64;
    private static final int INDEX_USERTAG2 = 65;
    private static final int INDEX_USERTAG3 = 66;
    private static final int INDEX_USERTAG4 = 67;
    private static final int INDEX_VALIDFLAG = 68;
    private static final int INDEX_WXCONTENTPSDEFID = 69;
    private static final int INDEX_WXCONTENTPSDEFNAME = 70;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysMsgQueueBase proxyPSSysMsgQueueBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean contentpsdefidDirtyFlag = false;
    private boolean contentpsdefnameDirtyFlag = false;
    private boolean contenttypepsdefidDirtyFlag = false;
    private boolean contenttypepsdefnameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customcodeDirtyFlag = false;
    private boolean custommodeDirtyFlag = false;
    private boolean ddcontentpsdefidDirtyFlag = false;
    private boolean ddcontentpsdefnameDirtyFlag = false;
    private boolean filepsdefidDirtyFlag = false;
    private boolean filepsdefnameDirtyFlag = false;
    private boolean imcontentpsdefidDirtyFlag = false;
    private boolean imcontentpsdefnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean mobtaskurlpsdefidDirtyFlag = false;
    private boolean mobtaskurlpsdefnameDirtyFlag = false;
    private boolean msgqueueparamsDirtyFlag = false;
    private boolean msgqueuetagDirtyFlag = false;
    private boolean msgqueuetag2DirtyFlag = false;
    private boolean msgqueuetypeDirtyFlag = false;
    private boolean msgtypepsdefidDirtyFlag = false;
    private boolean msgtypepsdefnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssysdynamodelidDirtyFlag = false;
    private boolean pssysdynamodelnameDirtyFlag = false;
    private boolean pssysmsgqueueidDirtyFlag = false;
    private boolean pssysmsgqueuenameDirtyFlag = false;
    private boolean pssyssfpluginidDirtyFlag = false;
    private boolean pssyssfpluginnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean pssysutildeidDirtyFlag = false;
    private boolean pssysutildenameDirtyFlag = false;
    private boolean queueparamsDirtyFlag = false;
    private boolean sendtimepsdefidDirtyFlag = false;
    private boolean sendtimepsdefnameDirtyFlag = false;
    private boolean smscontentpsdefidDirtyFlag = false;
    private boolean smscontentpsdefnameDirtyFlag = false;
    private boolean statepsdefidDirtyFlag = false;
    private boolean statepsdefnameDirtyFlag = false;
    private boolean tag2psdefidDirtyFlag = false;
    private boolean tag2psdefnameDirtyFlag = false;
    private boolean tagpsdefidDirtyFlag = false;
    private boolean tagpsdefnameDirtyFlag = false;
    private boolean targetpsdefidDirtyFlag = false;
    private boolean targetpsdefnameDirtyFlag = false;
    private boolean targettypepsdefidDirtyFlag = false;
    private boolean targettypepsdefnameDirtyFlag = false;
    private boolean taskurlpsdefidDirtyFlag = false;
    private boolean taskurlpsdefnameDirtyFlag = false;
    private boolean titlepsdefidDirtyFlag = false;
    private boolean titlepsdefnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean user2psdefidDirtyFlag = false;
    private boolean user2psdefnameDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean userpsdefidDirtyFlag = false;
    private boolean userpsdefnameDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    private boolean wxcontentpsdefidDirtyFlag = false;
    private boolean wxcontentpsdefnameDirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="contentpsdefid")
    private String contentpsdefid;
    @Column(name="contentpsdefname")
    private String contentpsdefname;
    @Column(name="contenttypepsdefid")
    private String contenttypepsdefid;
    @Column(name="contenttypepsdefname")
    private String contenttypepsdefname;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="customcode")
    private String customcode;
    @Column(name="custommode")
    private Integer custommode;
    @Column(name="ddcontentpsdefid")
    private String ddcontentpsdefid;
    @Column(name="ddcontentpsdefname")
    private String ddcontentpsdefname;
    @Column(name="filepsdefid")
    private String filepsdefid;
    @Column(name="filepsdefname")
    private String filepsdefname;
    @Column(name="imcontentpsdefid")
    private String imcontentpsdefid;
    @Column(name="imcontentpsdefname")
    private String imcontentpsdefname;
    @Column(name="memo")
    private String memo;
    @Column(name="mobtaskurlpsdefid")
    private String mobtaskurlpsdefid;
    @Column(name="mobtaskurlpsdefname")
    private String mobtaskurlpsdefname;
    @Column(name="msgqueueparams")
    private String msgqueueparams;
    @Column(name="msgqueuetag")
    private String msgqueuetag;
    @Column(name="msgqueuetag2")
    private String msgqueuetag2;
    @Column(name="msgqueuetype")
    private String msgqueuetype;
    @Column(name="msgtypepsdefid")
    private String msgtypepsdefid;
    @Column(name="msgtypepsdefname")
    private String msgtypepsdefname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssysdynamodelid")
    private String pssysdynamodelid;
    @Column(name="pssysdynamodelname")
    private String pssysdynamodelname;
    @Column(name="pssysmsgqueueid")
    private String pssysmsgqueueid;
    @Column(name="pssysmsgqueuename")
    private String pssysmsgqueuename;
    @Column(name="pssyssfpluginid")
    private String pssyssfpluginid;
    @Column(name="pssyssfpluginname")
    private String pssyssfpluginname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="pssysutildeid")
    private String pssysutildeid;
    @Column(name="pssysutildename")
    private String pssysutildename;
    @Column(name="queueparams")
    private String queueparams;
    @Column(name="sendtimepsdefid")
    private String sendtimepsdefid;
    @Column(name="sendtimepsdefname")
    private String sendtimepsdefname;
    @Column(name="smscontentpsdefid")
    private String smscontentpsdefid;
    @Column(name="smscontentpsdefname")
    private String smscontentpsdefname;
    @Column(name="statepsdefid")
    private String statepsdefid;
    @Column(name="statepsdefname")
    private String statepsdefname;
    @Column(name="tag2psdefid")
    private String tag2psdefid;
    @Column(name="tag2psdefname")
    private String tag2psdefname;
    @Column(name="tagpsdefid")
    private String tagpsdefid;
    @Column(name="tagpsdefname")
    private String tagpsdefname;
    @Column(name="targetpsdefid")
    private String targetpsdefid;
    @Column(name="targetpsdefname")
    private String targetpsdefname;
    @Column(name="targettypepsdefid")
    private String targettypepsdefid;
    @Column(name="targettypepsdefname")
    private String targettypepsdefname;
    @Column(name="taskurlpsdefid")
    private String taskurlpsdefid;
    @Column(name="taskurlpsdefname")
    private String taskurlpsdefname;
    @Column(name="titlepsdefid")
    private String titlepsdefid;
    @Column(name="titlepsdefname")
    private String titlepsdefname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="user2psdefid")
    private String user2psdefid;
    @Column(name="user2psdefname")
    private String user2psdefname;
    @Column(name="usercat")
    private String usercat;
    @Column(name="userpsdefid")
    private String userpsdefid;
    @Column(name="userpsdefname")
    private String userpsdefname;
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
    @Column(name="wxcontentpsdefid")
    private String wxcontentpsdefid;
    @Column(name="wxcontentpsdefname")
    private String wxcontentpsdefname;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objContentPSDEFLock = new Integer(1);
    private PSDEField contentpsdef = null;
    private Integer objContentTypePSDEFLock = new Integer(1);
    private PSDEField contenttypepsdef = null;
    private Integer objDDContentPSDEFLock = new Integer(1);
    private PSDEField ddcontentpsdef = null;
    private Integer objFilePSDEFLock = new Integer(1);
    private PSDEField filepsdef = null;
    private Integer objIMContentPSDEFLock = new Integer(1);
    private PSDEField imcontentpsdef = null;
    private Integer objMobTaskUrlPSDEFLock = new Integer(1);
    private PSDEField mobtaskurlpsdef = null;
    private Integer objMsgTypePSDEFLock = new Integer(1);
    private PSDEField msgtypepsdef = null;
    private Integer objSendTimePSDEFLock = new Integer(1);
    private PSDEField sendtimepsdef = null;
    private Integer objSMSContentPSDEFLock = new Integer(1);
    private PSDEField smscontentpsdef = null;
    private Integer objStatePSDEFLock = new Integer(1);
    private PSDEField statepsdef = null;
    private Integer objTagPSDEFLock = new Integer(1);
    private PSDEField tagpsdef = null;
    private Integer objTag2PSDEFLock = new Integer(1);
    private PSDEField tag2psdef = null;
    private Integer objTargetPSDEFLock = new Integer(1);
    private PSDEField targetpsdef = null;
    private Integer objTargetTypePSDEFLock = new Integer(1);
    private PSDEField targettypepsdef = null;
    private Integer objTaskUrlPSDEFLock = new Integer(1);
    private PSDEField taskurlpsdef = null;
    private Integer objTitlePSDEFLock = new Integer(1);
    private PSDEField titlepsdef = null;
    private Integer objUser2PSDEFLock = new Integer(1);
    private PSDEField user2psdef = null;
    private Integer objUserPSDEFLock = new Integer(1);
    private PSDEField userpsdef = null;
    private Integer objWXContentPSDEFLock = new Integer(1);
    private PSDEField wxcontentpsdef = null;
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel pssysdynamodel = null;
    private Integer objPSSysSFPluginLock = new Integer(1);
    private PSSysSFPlugin pssyssfplugin = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSSysUtilDELock = new Integer(1);
    private PSSysUtilDE pssysutilde = null;

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

    public void setContentPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setContentPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.contentpsdefid = string;
        this.contentpsdefidDirtyFlag = true;
    }

    public String getContentPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContentPSDEFId();
        }
        return this.contentpsdefid;
    }

    public boolean isContentPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isContentPSDEFIdDirty();
        }
        return this.contentpsdefidDirtyFlag;
    }

    public void resetContentPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetContentPSDEFId();
            return;
        }
        this.contentpsdefidDirtyFlag = false;
        this.contentpsdefid = null;
    }

    public void setContentPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setContentPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.contentpsdefname = string;
        this.contentpsdefnameDirtyFlag = true;
    }

    public String getContentPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContentPSDEFName();
        }
        return this.contentpsdefname;
    }

    public boolean isContentPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isContentPSDEFNameDirty();
        }
        return this.contentpsdefnameDirtyFlag;
    }

    public void resetContentPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetContentPSDEFName();
            return;
        }
        this.contentpsdefnameDirtyFlag = false;
        this.contentpsdefname = null;
    }

    public void setContentTypePSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setContentTypePSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.contenttypepsdefid = string;
        this.contenttypepsdefidDirtyFlag = true;
    }

    public String getContentTypePSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContentTypePSDEFId();
        }
        return this.contenttypepsdefid;
    }

    public boolean isContentTypePSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isContentTypePSDEFIdDirty();
        }
        return this.contenttypepsdefidDirtyFlag;
    }

    public void resetContentTypePSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetContentTypePSDEFId();
            return;
        }
        this.contenttypepsdefidDirtyFlag = false;
        this.contenttypepsdefid = null;
    }

    public void setContentTypePSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setContentTypePSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.contenttypepsdefname = string;
        this.contenttypepsdefnameDirtyFlag = true;
    }

    public String getContentTypePSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContentTypePSDEFName();
        }
        return this.contenttypepsdefname;
    }

    public boolean isContentTypePSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isContentTypePSDEFNameDirty();
        }
        return this.contenttypepsdefnameDirtyFlag;
    }

    public void resetContentTypePSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetContentTypePSDEFName();
            return;
        }
        this.contenttypepsdefnameDirtyFlag = false;
        this.contenttypepsdefname = null;
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

    public void setDDContentPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDDContentPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ddcontentpsdefid = string;
        this.ddcontentpsdefidDirtyFlag = true;
    }

    public String getDDContentPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDDContentPSDEFId();
        }
        return this.ddcontentpsdefid;
    }

    public boolean isDDContentPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDDContentPSDEFIdDirty();
        }
        return this.ddcontentpsdefidDirtyFlag;
    }

    public void resetDDContentPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDDContentPSDEFId();
            return;
        }
        this.ddcontentpsdefidDirtyFlag = false;
        this.ddcontentpsdefid = null;
    }

    public void setDDContentPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDDContentPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ddcontentpsdefname = string;
        this.ddcontentpsdefnameDirtyFlag = true;
    }

    public String getDDContentPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDDContentPSDEFName();
        }
        return this.ddcontentpsdefname;
    }

    public boolean isDDContentPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDDContentPSDEFNameDirty();
        }
        return this.ddcontentpsdefnameDirtyFlag;
    }

    public void resetDDContentPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDDContentPSDEFName();
            return;
        }
        this.ddcontentpsdefnameDirtyFlag = false;
        this.ddcontentpsdefname = null;
    }

    public void setFilePSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFilePSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.filepsdefid = string;
        this.filepsdefidDirtyFlag = true;
    }

    public String getFilePSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFilePSDEFId();
        }
        return this.filepsdefid;
    }

    public boolean isFilePSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFilePSDEFIdDirty();
        }
        return this.filepsdefidDirtyFlag;
    }

    public void resetFilePSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFilePSDEFId();
            return;
        }
        this.filepsdefidDirtyFlag = false;
        this.filepsdefid = null;
    }

    public void setFilePSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFilePSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.filepsdefname = string;
        this.filepsdefnameDirtyFlag = true;
    }

    public String getFilePSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFilePSDEFName();
        }
        return this.filepsdefname;
    }

    public boolean isFilePSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFilePSDEFNameDirty();
        }
        return this.filepsdefnameDirtyFlag;
    }

    public void resetFilePSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFilePSDEFName();
            return;
        }
        this.filepsdefnameDirtyFlag = false;
        this.filepsdefname = null;
    }

    public void setIMContentPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIMContentPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.imcontentpsdefid = string;
        this.imcontentpsdefidDirtyFlag = true;
    }

    public String getIMContentPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIMContentPSDEFId();
        }
        return this.imcontentpsdefid;
    }

    public boolean isIMContentPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIMContentPSDEFIdDirty();
        }
        return this.imcontentpsdefidDirtyFlag;
    }

    public void resetIMContentPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIMContentPSDEFId();
            return;
        }
        this.imcontentpsdefidDirtyFlag = false;
        this.imcontentpsdefid = null;
    }

    public void setIMContentPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIMContentPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.imcontentpsdefname = string;
        this.imcontentpsdefnameDirtyFlag = true;
    }

    public String getIMContentPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIMContentPSDEFName();
        }
        return this.imcontentpsdefname;
    }

    public boolean isIMContentPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIMContentPSDEFNameDirty();
        }
        return this.imcontentpsdefnameDirtyFlag;
    }

    public void resetIMContentPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIMContentPSDEFName();
            return;
        }
        this.imcontentpsdefnameDirtyFlag = false;
        this.imcontentpsdefname = null;
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

    public void setMobTaskUrlPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobTaskUrlPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mobtaskurlpsdefid = string;
        this.mobtaskurlpsdefidDirtyFlag = true;
    }

    public String getMobTaskUrlPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobTaskUrlPSDEFId();
        }
        return this.mobtaskurlpsdefid;
    }

    public boolean isMobTaskUrlPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobTaskUrlPSDEFIdDirty();
        }
        return this.mobtaskurlpsdefidDirtyFlag;
    }

    public void resetMobTaskUrlPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobTaskUrlPSDEFId();
            return;
        }
        this.mobtaskurlpsdefidDirtyFlag = false;
        this.mobtaskurlpsdefid = null;
    }

    public void setMobTaskUrlPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobTaskUrlPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mobtaskurlpsdefname = string;
        this.mobtaskurlpsdefnameDirtyFlag = true;
    }

    public String getMobTaskUrlPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobTaskUrlPSDEFName();
        }
        return this.mobtaskurlpsdefname;
    }

    public boolean isMobTaskUrlPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobTaskUrlPSDEFNameDirty();
        }
        return this.mobtaskurlpsdefnameDirtyFlag;
    }

    public void resetMobTaskUrlPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobTaskUrlPSDEFName();
            return;
        }
        this.mobtaskurlpsdefnameDirtyFlag = false;
        this.mobtaskurlpsdefname = null;
    }

    public void setMsgQueueParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMsgQueueParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.msgqueueparams = string;
        this.msgqueueparamsDirtyFlag = true;
    }

    public String getMsgQueueParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMsgQueueParams();
        }
        return this.msgqueueparams;
    }

    public boolean isMsgQueueParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMsgQueueParamsDirty();
        }
        return this.msgqueueparamsDirtyFlag;
    }

    public void resetMsgQueueParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMsgQueueParams();
            return;
        }
        this.msgqueueparamsDirtyFlag = false;
        this.msgqueueparams = null;
    }

    public void setMsgQueueTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMsgQueueTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.msgqueuetag = string;
        this.msgqueuetagDirtyFlag = true;
    }

    public String getMsgQueueTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMsgQueueTag();
        }
        return this.msgqueuetag;
    }

    public boolean isMsgQueueTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMsgQueueTagDirty();
        }
        return this.msgqueuetagDirtyFlag;
    }

    public void resetMsgQueueTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMsgQueueTag();
            return;
        }
        this.msgqueuetagDirtyFlag = false;
        this.msgqueuetag = null;
    }

    public void setMsgQueueTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMsgQueueTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.msgqueuetag2 = string;
        this.msgqueuetag2DirtyFlag = true;
    }

    public String getMsgQueueTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMsgQueueTag2();
        }
        return this.msgqueuetag2;
    }

    public boolean isMsgQueueTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMsgQueueTag2Dirty();
        }
        return this.msgqueuetag2DirtyFlag;
    }

    public void resetMsgQueueTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMsgQueueTag2();
            return;
        }
        this.msgqueuetag2DirtyFlag = false;
        this.msgqueuetag2 = null;
    }

    public void setMsgQueueType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMsgQueueType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.msgqueuetype = string;
        this.msgqueuetypeDirtyFlag = true;
    }

    public String getMsgQueueType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMsgQueueType();
        }
        return this.msgqueuetype;
    }

    public boolean isMsgQueueTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMsgQueueTypeDirty();
        }
        return this.msgqueuetypeDirtyFlag;
    }

    public void resetMsgQueueType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMsgQueueType();
            return;
        }
        this.msgqueuetypeDirtyFlag = false;
        this.msgqueuetype = null;
    }

    public void setMsgTypePSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMsgTypePSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.msgtypepsdefid = string;
        this.msgtypepsdefidDirtyFlag = true;
    }

    public String getMsgTypePSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMsgTypePSDEFId();
        }
        return this.msgtypepsdefid;
    }

    public boolean isMsgTypePSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMsgTypePSDEFIdDirty();
        }
        return this.msgtypepsdefidDirtyFlag;
    }

    public void resetMsgTypePSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMsgTypePSDEFId();
            return;
        }
        this.msgtypepsdefidDirtyFlag = false;
        this.msgtypepsdefid = null;
    }

    public void setMsgTypePSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMsgTypePSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.msgtypepsdefname = string;
        this.msgtypepsdefnameDirtyFlag = true;
    }

    public String getMsgTypePSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMsgTypePSDEFName();
        }
        return this.msgtypepsdefname;
    }

    public boolean isMsgTypePSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMsgTypePSDEFNameDirty();
        }
        return this.msgtypepsdefnameDirtyFlag;
    }

    public void resetMsgTypePSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMsgTypePSDEFName();
            return;
        }
        this.msgtypepsdefnameDirtyFlag = false;
        this.msgtypepsdefname = null;
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

    public void setPSSysMsgQueueId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysMsgQueueId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmsgqueueid = string;
        this.pssysmsgqueueidDirtyFlag = true;
    }

    public String getPSSysMsgQueueId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysMsgQueueId();
        }
        return this.pssysmsgqueueid;
    }

    public boolean isPSSysMsgQueueIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysMsgQueueIdDirty();
        }
        return this.pssysmsgqueueidDirtyFlag;
    }

    public void resetPSSysMsgQueueId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysMsgQueueId();
            return;
        }
        this.pssysmsgqueueidDirtyFlag = false;
        this.pssysmsgqueueid = null;
    }

    public void setPSSysMsgQueueName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysMsgQueueName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmsgqueuename = string;
        this.pssysmsgqueuenameDirtyFlag = true;
    }

    public String getPSSysMsgQueueName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysMsgQueueName();
        }
        return this.pssysmsgqueuename;
    }

    public boolean isPSSysMsgQueueNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysMsgQueueNameDirty();
        }
        return this.pssysmsgqueuenameDirtyFlag;
    }

    public void resetPSSysMsgQueueName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysMsgQueueName();
            return;
        }
        this.pssysmsgqueuenameDirtyFlag = false;
        this.pssysmsgqueuename = null;
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

    public void setQueueParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setQueueParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.queueparams = string;
        this.queueparamsDirtyFlag = true;
    }

    public String getQueueParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getQueueParams();
        }
        return this.queueparams;
    }

    public boolean isQueueParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isQueueParamsDirty();
        }
        return this.queueparamsDirtyFlag;
    }

    public void resetQueueParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetQueueParams();
            return;
        }
        this.queueparamsDirtyFlag = false;
        this.queueparams = null;
    }

    public void setSendTimePSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSendTimePSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sendtimepsdefid = string;
        this.sendtimepsdefidDirtyFlag = true;
    }

    public String getSendTimePSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSendTimePSDEFId();
        }
        return this.sendtimepsdefid;
    }

    public boolean isSendTimePSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSendTimePSDEFIdDirty();
        }
        return this.sendtimepsdefidDirtyFlag;
    }

    public void resetSendTimePSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSendTimePSDEFId();
            return;
        }
        this.sendtimepsdefidDirtyFlag = false;
        this.sendtimepsdefid = null;
    }

    public void setSendTimePSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSendTimePSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sendtimepsdefname = string;
        this.sendtimepsdefnameDirtyFlag = true;
    }

    public String getSendTimePSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSendTimePSDEFName();
        }
        return this.sendtimepsdefname;
    }

    public boolean isSendTimePSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSendTimePSDEFNameDirty();
        }
        return this.sendtimepsdefnameDirtyFlag;
    }

    public void resetSendTimePSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSendTimePSDEFName();
            return;
        }
        this.sendtimepsdefnameDirtyFlag = false;
        this.sendtimepsdefname = null;
    }

    public void setSMSContentPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSMSContentPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.smscontentpsdefid = string;
        this.smscontentpsdefidDirtyFlag = true;
    }

    public String getSMSContentPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSMSContentPSDEFId();
        }
        return this.smscontentpsdefid;
    }

    public boolean isSMSContentPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSMSContentPSDEFIdDirty();
        }
        return this.smscontentpsdefidDirtyFlag;
    }

    public void resetSMSContentPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSMSContentPSDEFId();
            return;
        }
        this.smscontentpsdefidDirtyFlag = false;
        this.smscontentpsdefid = null;
    }

    public void setSMSContentPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSMSContentPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.smscontentpsdefname = string;
        this.smscontentpsdefnameDirtyFlag = true;
    }

    public String getSMSContentPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSMSContentPSDEFName();
        }
        return this.smscontentpsdefname;
    }

    public boolean isSMSContentPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSMSContentPSDEFNameDirty();
        }
        return this.smscontentpsdefnameDirtyFlag;
    }

    public void resetSMSContentPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSMSContentPSDEFName();
            return;
        }
        this.smscontentpsdefnameDirtyFlag = false;
        this.smscontentpsdefname = null;
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

    public void setTag2PSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTag2PSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tag2psdefid = string;
        this.tag2psdefidDirtyFlag = true;
    }

    public String getTag2PSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTag2PSDEFId();
        }
        return this.tag2psdefid;
    }

    public boolean isTag2PSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTag2PSDEFIdDirty();
        }
        return this.tag2psdefidDirtyFlag;
    }

    public void resetTag2PSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTag2PSDEFId();
            return;
        }
        this.tag2psdefidDirtyFlag = false;
        this.tag2psdefid = null;
    }

    public void setTag2PSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTag2PSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tag2psdefname = string;
        this.tag2psdefnameDirtyFlag = true;
    }

    public String getTag2PSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTag2PSDEFName();
        }
        return this.tag2psdefname;
    }

    public boolean isTag2PSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTag2PSDEFNameDirty();
        }
        return this.tag2psdefnameDirtyFlag;
    }

    public void resetTag2PSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTag2PSDEFName();
            return;
        }
        this.tag2psdefnameDirtyFlag = false;
        this.tag2psdefname = null;
    }

    public void setTagPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTagPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tagpsdefid = string;
        this.tagpsdefidDirtyFlag = true;
    }

    public String getTagPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTagPSDEFId();
        }
        return this.tagpsdefid;
    }

    public boolean isTagPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTagPSDEFIdDirty();
        }
        return this.tagpsdefidDirtyFlag;
    }

    public void resetTagPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTagPSDEFId();
            return;
        }
        this.tagpsdefidDirtyFlag = false;
        this.tagpsdefid = null;
    }

    public void setTagPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTagPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tagpsdefname = string;
        this.tagpsdefnameDirtyFlag = true;
    }

    public String getTagPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTagPSDEFName();
        }
        return this.tagpsdefname;
    }

    public boolean isTagPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTagPSDEFNameDirty();
        }
        return this.tagpsdefnameDirtyFlag;
    }

    public void resetTagPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTagPSDEFName();
            return;
        }
        this.tagpsdefnameDirtyFlag = false;
        this.tagpsdefname = null;
    }

    public void setTargetPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTargetPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.targetpsdefid = string;
        this.targetpsdefidDirtyFlag = true;
    }

    public String getTargetPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTargetPSDEFId();
        }
        return this.targetpsdefid;
    }

    public boolean isTargetPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTargetPSDEFIdDirty();
        }
        return this.targetpsdefidDirtyFlag;
    }

    public void resetTargetPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTargetPSDEFId();
            return;
        }
        this.targetpsdefidDirtyFlag = false;
        this.targetpsdefid = null;
    }

    public void setTargetPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTargetPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.targetpsdefname = string;
        this.targetpsdefnameDirtyFlag = true;
    }

    public String getTargetPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTargetPSDEFName();
        }
        return this.targetpsdefname;
    }

    public boolean isTargetPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTargetPSDEFNameDirty();
        }
        return this.targetpsdefnameDirtyFlag;
    }

    public void resetTargetPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTargetPSDEFName();
            return;
        }
        this.targetpsdefnameDirtyFlag = false;
        this.targetpsdefname = null;
    }

    public void setTargetTypePSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTargetTypePSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.targettypepsdefid = string;
        this.targettypepsdefidDirtyFlag = true;
    }

    public String getTargetTypePSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTargetTypePSDEFId();
        }
        return this.targettypepsdefid;
    }

    public boolean isTargetTypePSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTargetTypePSDEFIdDirty();
        }
        return this.targettypepsdefidDirtyFlag;
    }

    public void resetTargetTypePSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTargetTypePSDEFId();
            return;
        }
        this.targettypepsdefidDirtyFlag = false;
        this.targettypepsdefid = null;
    }

    public void setTargetTypePSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTargetTypePSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.targettypepsdefname = string;
        this.targettypepsdefnameDirtyFlag = true;
    }

    public String getTargetTypePSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTargetTypePSDEFName();
        }
        return this.targettypepsdefname;
    }

    public boolean isTargetTypePSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTargetTypePSDEFNameDirty();
        }
        return this.targettypepsdefnameDirtyFlag;
    }

    public void resetTargetTypePSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTargetTypePSDEFName();
            return;
        }
        this.targettypepsdefnameDirtyFlag = false;
        this.targettypepsdefname = null;
    }

    public void setTaskUrlPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTaskUrlPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.taskurlpsdefid = string;
        this.taskurlpsdefidDirtyFlag = true;
    }

    public String getTaskUrlPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTaskUrlPSDEFId();
        }
        return this.taskurlpsdefid;
    }

    public boolean isTaskUrlPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTaskUrlPSDEFIdDirty();
        }
        return this.taskurlpsdefidDirtyFlag;
    }

    public void resetTaskUrlPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTaskUrlPSDEFId();
            return;
        }
        this.taskurlpsdefidDirtyFlag = false;
        this.taskurlpsdefid = null;
    }

    public void setTaskUrlPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTaskUrlPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.taskurlpsdefname = string;
        this.taskurlpsdefnameDirtyFlag = true;
    }

    public String getTaskUrlPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTaskUrlPSDEFName();
        }
        return this.taskurlpsdefname;
    }

    public boolean isTaskUrlPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTaskUrlPSDEFNameDirty();
        }
        return this.taskurlpsdefnameDirtyFlag;
    }

    public void resetTaskUrlPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTaskUrlPSDEFName();
            return;
        }
        this.taskurlpsdefnameDirtyFlag = false;
        this.taskurlpsdefname = null;
    }

    public void setTitlePSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTitlePSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.titlepsdefid = string;
        this.titlepsdefidDirtyFlag = true;
    }

    public String getTitlePSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTitlePSDEFId();
        }
        return this.titlepsdefid;
    }

    public boolean isTitlePSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTitlePSDEFIdDirty();
        }
        return this.titlepsdefidDirtyFlag;
    }

    public void resetTitlePSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTitlePSDEFId();
            return;
        }
        this.titlepsdefidDirtyFlag = false;
        this.titlepsdefid = null;
    }

    public void setTitlePSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTitlePSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.titlepsdefname = string;
        this.titlepsdefnameDirtyFlag = true;
    }

    public String getTitlePSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTitlePSDEFName();
        }
        return this.titlepsdefname;
    }

    public boolean isTitlePSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTitlePSDEFNameDirty();
        }
        return this.titlepsdefnameDirtyFlag;
    }

    public void resetTitlePSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTitlePSDEFName();
            return;
        }
        this.titlepsdefnameDirtyFlag = false;
        this.titlepsdefname = null;
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

    public void setUser2PSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUser2PSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.user2psdefid = string;
        this.user2psdefidDirtyFlag = true;
    }

    public String getUser2PSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUser2PSDEFId();
        }
        return this.user2psdefid;
    }

    public boolean isUser2PSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUser2PSDEFIdDirty();
        }
        return this.user2psdefidDirtyFlag;
    }

    public void resetUser2PSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUser2PSDEFId();
            return;
        }
        this.user2psdefidDirtyFlag = false;
        this.user2psdefid = null;
    }

    public void setUser2PSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUser2PSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.user2psdefname = string;
        this.user2psdefnameDirtyFlag = true;
    }

    public String getUser2PSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUser2PSDEFName();
        }
        return this.user2psdefname;
    }

    public boolean isUser2PSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUser2PSDEFNameDirty();
        }
        return this.user2psdefnameDirtyFlag;
    }

    public void resetUser2PSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUser2PSDEFName();
            return;
        }
        this.user2psdefnameDirtyFlag = false;
        this.user2psdefname = null;
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

    public void setUserPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userpsdefid = string;
        this.userpsdefidDirtyFlag = true;
    }

    public String getUserPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserPSDEFId();
        }
        return this.userpsdefid;
    }

    public boolean isUserPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserPSDEFIdDirty();
        }
        return this.userpsdefidDirtyFlag;
    }

    public void resetUserPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserPSDEFId();
            return;
        }
        this.userpsdefidDirtyFlag = false;
        this.userpsdefid = null;
    }

    public void setUserPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userpsdefname = string;
        this.userpsdefnameDirtyFlag = true;
    }

    public String getUserPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserPSDEFName();
        }
        return this.userpsdefname;
    }

    public boolean isUserPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserPSDEFNameDirty();
        }
        return this.userpsdefnameDirtyFlag;
    }

    public void resetUserPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserPSDEFName();
            return;
        }
        this.userpsdefnameDirtyFlag = false;
        this.userpsdefname = null;
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

    public void setWXContentPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWXContentPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wxcontentpsdefid = string;
        this.wxcontentpsdefidDirtyFlag = true;
    }

    public String getWXContentPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWXContentPSDEFId();
        }
        return this.wxcontentpsdefid;
    }

    public boolean isWXContentPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWXContentPSDEFIdDirty();
        }
        return this.wxcontentpsdefidDirtyFlag;
    }

    public void resetWXContentPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWXContentPSDEFId();
            return;
        }
        this.wxcontentpsdefidDirtyFlag = false;
        this.wxcontentpsdefid = null;
    }

    public void setWXContentPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWXContentPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wxcontentpsdefname = string;
        this.wxcontentpsdefnameDirtyFlag = true;
    }

    public String getWXContentPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWXContentPSDEFName();
        }
        return this.wxcontentpsdefname;
    }

    public boolean isWXContentPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWXContentPSDEFNameDirty();
        }
        return this.wxcontentpsdefnameDirtyFlag;
    }

    public void resetWXContentPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWXContentPSDEFName();
            return;
        }
        this.wxcontentpsdefnameDirtyFlag = false;
        this.wxcontentpsdefname = null;
    }

    protected void onReset() {
        PSSysMsgQueueBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysMsgQueueBase pSSysMsgQueueBase) {
        pSSysMsgQueueBase.resetCodeName();
        pSSysMsgQueueBase.resetContentPSDEFId();
        pSSysMsgQueueBase.resetContentPSDEFName();
        pSSysMsgQueueBase.resetContentTypePSDEFId();
        pSSysMsgQueueBase.resetContentTypePSDEFName();
        pSSysMsgQueueBase.resetCreateDate();
        pSSysMsgQueueBase.resetCreateMan();
        pSSysMsgQueueBase.resetCustomCode();
        pSSysMsgQueueBase.resetCustomMode();
        pSSysMsgQueueBase.resetDDContentPSDEFId();
        pSSysMsgQueueBase.resetDDContentPSDEFName();
        pSSysMsgQueueBase.resetFilePSDEFId();
        pSSysMsgQueueBase.resetFilePSDEFName();
        pSSysMsgQueueBase.resetIMContentPSDEFId();
        pSSysMsgQueueBase.resetIMContentPSDEFName();
        pSSysMsgQueueBase.resetMemo();
        pSSysMsgQueueBase.resetMobTaskUrlPSDEFId();
        pSSysMsgQueueBase.resetMobTaskUrlPSDEFName();
        pSSysMsgQueueBase.resetMsgQueueParams();
        pSSysMsgQueueBase.resetMsgQueueTag();
        pSSysMsgQueueBase.resetMsgQueueTag2();
        pSSysMsgQueueBase.resetMsgQueueType();
        pSSysMsgQueueBase.resetMsgTypePSDEFId();
        pSSysMsgQueueBase.resetMsgTypePSDEFName();
        pSSysMsgQueueBase.resetPSDEId();
        pSSysMsgQueueBase.resetPSDEName();
        pSSysMsgQueueBase.resetPSModuleId();
        pSSysMsgQueueBase.resetPSModuleName();
        pSSysMsgQueueBase.resetPSSysDynaModelId();
        pSSysMsgQueueBase.resetPSSysDynaModelName();
        pSSysMsgQueueBase.resetPSSysMsgQueueId();
        pSSysMsgQueueBase.resetPSSysMsgQueueName();
        pSSysMsgQueueBase.resetPSSysSFPluginId();
        pSSysMsgQueueBase.resetPSSysSFPluginName();
        pSSysMsgQueueBase.resetPSSystemId();
        pSSysMsgQueueBase.resetPSSystemName();
        pSSysMsgQueueBase.resetPSSysUtilDEId();
        pSSysMsgQueueBase.resetPSSysUtilDEName();
        pSSysMsgQueueBase.resetQueueParams();
        pSSysMsgQueueBase.resetSendTimePSDEFId();
        pSSysMsgQueueBase.resetSendTimePSDEFName();
        pSSysMsgQueueBase.resetSMSContentPSDEFId();
        pSSysMsgQueueBase.resetSMSContentPSDEFName();
        pSSysMsgQueueBase.resetStatePSDEFId();
        pSSysMsgQueueBase.resetStatePSDEFName();
        pSSysMsgQueueBase.resetTag2PSDEFId();
        pSSysMsgQueueBase.resetTag2PSDEFName();
        pSSysMsgQueueBase.resetTagPSDEFId();
        pSSysMsgQueueBase.resetTagPSDEFName();
        pSSysMsgQueueBase.resetTargetPSDEFId();
        pSSysMsgQueueBase.resetTargetPSDEFName();
        pSSysMsgQueueBase.resetTargetTypePSDEFId();
        pSSysMsgQueueBase.resetTargetTypePSDEFName();
        pSSysMsgQueueBase.resetTaskUrlPSDEFId();
        pSSysMsgQueueBase.resetTaskUrlPSDEFName();
        pSSysMsgQueueBase.resetTitlePSDEFId();
        pSSysMsgQueueBase.resetTitlePSDEFName();
        pSSysMsgQueueBase.resetUpdateDate();
        pSSysMsgQueueBase.resetUpdateMan();
        pSSysMsgQueueBase.resetUser2PSDEFId();
        pSSysMsgQueueBase.resetUser2PSDEFName();
        pSSysMsgQueueBase.resetUserCat();
        pSSysMsgQueueBase.resetUserPSDEFId();
        pSSysMsgQueueBase.resetUserPSDEFName();
        pSSysMsgQueueBase.resetUserTag();
        pSSysMsgQueueBase.resetUserTag2();
        pSSysMsgQueueBase.resetUserTag3();
        pSSysMsgQueueBase.resetUserTag4();
        pSSysMsgQueueBase.resetValidFlag();
        pSSysMsgQueueBase.resetWXContentPSDEFId();
        pSSysMsgQueueBase.resetWXContentPSDEFName();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isContentPSDEFIdDirty()) {
            hashMap.put(FIELD_CONTENTPSDEFID, this.getContentPSDEFId());
        }
        if (!bl || this.isContentPSDEFNameDirty()) {
            hashMap.put(FIELD_CONTENTPSDEFNAME, this.getContentPSDEFName());
        }
        if (!bl || this.isContentTypePSDEFIdDirty()) {
            hashMap.put(FIELD_CONTENTTYPEPSDEFID, this.getContentTypePSDEFId());
        }
        if (!bl || this.isContentTypePSDEFNameDirty()) {
            hashMap.put(FIELD_CONTENTTYPEPSDEFNAME, this.getContentTypePSDEFName());
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
        if (!bl || this.isDDContentPSDEFIdDirty()) {
            hashMap.put(FIELD_DDCONTENTPSDEFID, this.getDDContentPSDEFId());
        }
        if (!bl || this.isDDContentPSDEFNameDirty()) {
            hashMap.put(FIELD_DDCONTENTPSDEFNAME, this.getDDContentPSDEFName());
        }
        if (!bl || this.isFilePSDEFIdDirty()) {
            hashMap.put(FIELD_FILEPSDEFID, this.getFilePSDEFId());
        }
        if (!bl || this.isFilePSDEFNameDirty()) {
            hashMap.put(FIELD_FILEPSDEFNAME, this.getFilePSDEFName());
        }
        if (!bl || this.isIMContentPSDEFIdDirty()) {
            hashMap.put(FIELD_IMCONTENTPSDEFID, this.getIMContentPSDEFId());
        }
        if (!bl || this.isIMContentPSDEFNameDirty()) {
            hashMap.put(FIELD_IMCONTENTPSDEFNAME, this.getIMContentPSDEFName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMobTaskUrlPSDEFIdDirty()) {
            hashMap.put(FIELD_MOBTASKURLPSDEFID, this.getMobTaskUrlPSDEFId());
        }
        if (!bl || this.isMobTaskUrlPSDEFNameDirty()) {
            hashMap.put(FIELD_MOBTASKURLPSDEFNAME, this.getMobTaskUrlPSDEFName());
        }
        if (!bl || this.isMsgQueueParamsDirty()) {
            hashMap.put(FIELD_MSGQUEUEPARAMS, this.getMsgQueueParams());
        }
        if (!bl || this.isMsgQueueTagDirty()) {
            hashMap.put(FIELD_MSGQUEUETAG, this.getMsgQueueTag());
        }
        if (!bl || this.isMsgQueueTag2Dirty()) {
            hashMap.put(FIELD_MSGQUEUETAG2, this.getMsgQueueTag2());
        }
        if (!bl || this.isMsgQueueTypeDirty()) {
            hashMap.put(FIELD_MSGQUEUETYPE, this.getMsgQueueType());
        }
        if (!bl || this.isMsgTypePSDEFIdDirty()) {
            hashMap.put(FIELD_MSGTYPEPSDEFID, this.getMsgTypePSDEFId());
        }
        if (!bl || this.isMsgTypePSDEFNameDirty()) {
            hashMap.put(FIELD_MSGTYPEPSDEFNAME, this.getMsgTypePSDEFName());
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
        if (!bl || this.isPSSysDynaModelIdDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELID, this.getPSSysDynaModelId());
        }
        if (!bl || this.isPSSysDynaModelNameDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELNAME, this.getPSSysDynaModelName());
        }
        if (!bl || this.isPSSysMsgQueueIdDirty()) {
            hashMap.put(FIELD_PSSYSMSGQUEUEID, this.getPSSysMsgQueueId());
        }
        if (!bl || this.isPSSysMsgQueueNameDirty()) {
            hashMap.put(FIELD_PSSYSMSGQUEUENAME, this.getPSSysMsgQueueName());
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
        if (!bl || this.isPSSysUtilDEIdDirty()) {
            hashMap.put(FIELD_PSSYSUTILDEID, this.getPSSysUtilDEId());
        }
        if (!bl || this.isPSSysUtilDENameDirty()) {
            hashMap.put(FIELD_PSSYSUTILDENAME, this.getPSSysUtilDEName());
        }
        if (!bl || this.isQueueParamsDirty()) {
            hashMap.put(FIELD_QUEUEPARAMS, this.getQueueParams());
        }
        if (!bl || this.isSendTimePSDEFIdDirty()) {
            hashMap.put(FIELD_SENDTIMEPSDEFID, this.getSendTimePSDEFId());
        }
        if (!bl || this.isSendTimePSDEFNameDirty()) {
            hashMap.put(FIELD_SENDTIMEPSDEFNAME, this.getSendTimePSDEFName());
        }
        if (!bl || this.isSMSContentPSDEFIdDirty()) {
            hashMap.put(FIELD_SMSCONTENTPSDEFID, this.getSMSContentPSDEFId());
        }
        if (!bl || this.isSMSContentPSDEFNameDirty()) {
            hashMap.put(FIELD_SMSCONTENTPSDEFNAME, this.getSMSContentPSDEFName());
        }
        if (!bl || this.isStatePSDEFIdDirty()) {
            hashMap.put(FIELD_STATEPSDEFID, this.getStatePSDEFId());
        }
        if (!bl || this.isStatePSDEFNameDirty()) {
            hashMap.put(FIELD_STATEPSDEFNAME, this.getStatePSDEFName());
        }
        if (!bl || this.isTag2PSDEFIdDirty()) {
            hashMap.put(FIELD_TAG2PSDEFID, this.getTag2PSDEFId());
        }
        if (!bl || this.isTag2PSDEFNameDirty()) {
            hashMap.put(FIELD_TAG2PSDEFNAME, this.getTag2PSDEFName());
        }
        if (!bl || this.isTagPSDEFIdDirty()) {
            hashMap.put(FIELD_TAGPSDEFID, this.getTagPSDEFId());
        }
        if (!bl || this.isTagPSDEFNameDirty()) {
            hashMap.put(FIELD_TAGPSDEFNAME, this.getTagPSDEFName());
        }
        if (!bl || this.isTargetPSDEFIdDirty()) {
            hashMap.put(FIELD_TARGETPSDEFID, this.getTargetPSDEFId());
        }
        if (!bl || this.isTargetPSDEFNameDirty()) {
            hashMap.put(FIELD_TARGETPSDEFNAME, this.getTargetPSDEFName());
        }
        if (!bl || this.isTargetTypePSDEFIdDirty()) {
            hashMap.put(FIELD_TARGETTYPEPSDEFID, this.getTargetTypePSDEFId());
        }
        if (!bl || this.isTargetTypePSDEFNameDirty()) {
            hashMap.put(FIELD_TARGETTYPEPSDEFNAME, this.getTargetTypePSDEFName());
        }
        if (!bl || this.isTaskUrlPSDEFIdDirty()) {
            hashMap.put(FIELD_TASKURLPSDEFID, this.getTaskUrlPSDEFId());
        }
        if (!bl || this.isTaskUrlPSDEFNameDirty()) {
            hashMap.put(FIELD_TASKURLPSDEFNAME, this.getTaskUrlPSDEFName());
        }
        if (!bl || this.isTitlePSDEFIdDirty()) {
            hashMap.put(FIELD_TITLEPSDEFID, this.getTitlePSDEFId());
        }
        if (!bl || this.isTitlePSDEFNameDirty()) {
            hashMap.put(FIELD_TITLEPSDEFNAME, this.getTitlePSDEFName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUser2PSDEFIdDirty()) {
            hashMap.put(FIELD_USER2PSDEFID, this.getUser2PSDEFId());
        }
        if (!bl || this.isUser2PSDEFNameDirty()) {
            hashMap.put(FIELD_USER2PSDEFNAME, this.getUser2PSDEFName());
        }
        if (!bl || this.isUserCatDirty()) {
            hashMap.put(FIELD_USERCAT, this.getUserCat());
        }
        if (!bl || this.isUserPSDEFIdDirty()) {
            hashMap.put(FIELD_USERPSDEFID, this.getUserPSDEFId());
        }
        if (!bl || this.isUserPSDEFNameDirty()) {
            hashMap.put(FIELD_USERPSDEFNAME, this.getUserPSDEFName());
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
        if (!bl || this.isWXContentPSDEFIdDirty()) {
            hashMap.put(FIELD_WXCONTENTPSDEFID, this.getWXContentPSDEFId());
        }
        if (!bl || this.isWXContentPSDEFNameDirty()) {
            hashMap.put(FIELD_WXCONTENTPSDEFNAME, this.getWXContentPSDEFName());
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
        return PSSysMsgQueueBase.get(this, n);
    }

    private static Object get(PSSysMsgQueueBase pSSysMsgQueueBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysMsgQueueBase.getCodeName();
            }
            case 1: {
                return pSSysMsgQueueBase.getContentPSDEFId();
            }
            case 2: {
                return pSSysMsgQueueBase.getContentPSDEFName();
            }
            case 3: {
                return pSSysMsgQueueBase.getContentTypePSDEFId();
            }
            case 4: {
                return pSSysMsgQueueBase.getContentTypePSDEFName();
            }
            case 5: {
                return pSSysMsgQueueBase.getCreateDate();
            }
            case 6: {
                return pSSysMsgQueueBase.getCreateMan();
            }
            case 7: {
                return pSSysMsgQueueBase.getCustomCode();
            }
            case 8: {
                return pSSysMsgQueueBase.getCustomMode();
            }
            case 9: {
                return pSSysMsgQueueBase.getDDContentPSDEFId();
            }
            case 10: {
                return pSSysMsgQueueBase.getDDContentPSDEFName();
            }
            case 11: {
                return pSSysMsgQueueBase.getFilePSDEFId();
            }
            case 12: {
                return pSSysMsgQueueBase.getFilePSDEFName();
            }
            case 13: {
                return pSSysMsgQueueBase.getIMContentPSDEFId();
            }
            case 14: {
                return pSSysMsgQueueBase.getIMContentPSDEFName();
            }
            case 15: {
                return pSSysMsgQueueBase.getMemo();
            }
            case 16: {
                return pSSysMsgQueueBase.getMobTaskUrlPSDEFId();
            }
            case 17: {
                return pSSysMsgQueueBase.getMobTaskUrlPSDEFName();
            }
            case 18: {
                return pSSysMsgQueueBase.getMsgQueueParams();
            }
            case 19: {
                return pSSysMsgQueueBase.getMsgQueueTag();
            }
            case 20: {
                return pSSysMsgQueueBase.getMsgQueueTag2();
            }
            case 21: {
                return pSSysMsgQueueBase.getMsgQueueType();
            }
            case 22: {
                return pSSysMsgQueueBase.getMsgTypePSDEFId();
            }
            case 23: {
                return pSSysMsgQueueBase.getMsgTypePSDEFName();
            }
            case 24: {
                return pSSysMsgQueueBase.getPSDEId();
            }
            case 25: {
                return pSSysMsgQueueBase.getPSDEName();
            }
            case 26: {
                return pSSysMsgQueueBase.getPSModuleId();
            }
            case 27: {
                return pSSysMsgQueueBase.getPSModuleName();
            }
            case 28: {
                return pSSysMsgQueueBase.getPSSysDynaModelId();
            }
            case 29: {
                return pSSysMsgQueueBase.getPSSysDynaModelName();
            }
            case 30: {
                return pSSysMsgQueueBase.getPSSysMsgQueueId();
            }
            case 31: {
                return pSSysMsgQueueBase.getPSSysMsgQueueName();
            }
            case 32: {
                return pSSysMsgQueueBase.getPSSysSFPluginId();
            }
            case 33: {
                return pSSysMsgQueueBase.getPSSysSFPluginName();
            }
            case 34: {
                return pSSysMsgQueueBase.getPSSystemId();
            }
            case 35: {
                return pSSysMsgQueueBase.getPSSystemName();
            }
            case 36: {
                return pSSysMsgQueueBase.getPSSysUtilDEId();
            }
            case 37: {
                return pSSysMsgQueueBase.getPSSysUtilDEName();
            }
            case 38: {
                return pSSysMsgQueueBase.getQueueParams();
            }
            case 39: {
                return pSSysMsgQueueBase.getSendTimePSDEFId();
            }
            case 40: {
                return pSSysMsgQueueBase.getSendTimePSDEFName();
            }
            case 41: {
                return pSSysMsgQueueBase.getSMSContentPSDEFId();
            }
            case 42: {
                return pSSysMsgQueueBase.getSMSContentPSDEFName();
            }
            case 43: {
                return pSSysMsgQueueBase.getStatePSDEFId();
            }
            case 44: {
                return pSSysMsgQueueBase.getStatePSDEFName();
            }
            case 45: {
                return pSSysMsgQueueBase.getTag2PSDEFId();
            }
            case 46: {
                return pSSysMsgQueueBase.getTag2PSDEFName();
            }
            case 47: {
                return pSSysMsgQueueBase.getTagPSDEFId();
            }
            case 48: {
                return pSSysMsgQueueBase.getTagPSDEFName();
            }
            case 49: {
                return pSSysMsgQueueBase.getTargetPSDEFId();
            }
            case 50: {
                return pSSysMsgQueueBase.getTargetPSDEFName();
            }
            case 51: {
                return pSSysMsgQueueBase.getTargetTypePSDEFId();
            }
            case 52: {
                return pSSysMsgQueueBase.getTargetTypePSDEFName();
            }
            case 53: {
                return pSSysMsgQueueBase.getTaskUrlPSDEFId();
            }
            case 54: {
                return pSSysMsgQueueBase.getTaskUrlPSDEFName();
            }
            case 55: {
                return pSSysMsgQueueBase.getTitlePSDEFId();
            }
            case 56: {
                return pSSysMsgQueueBase.getTitlePSDEFName();
            }
            case 57: {
                return pSSysMsgQueueBase.getUpdateDate();
            }
            case 58: {
                return pSSysMsgQueueBase.getUpdateMan();
            }
            case 59: {
                return pSSysMsgQueueBase.getUser2PSDEFId();
            }
            case 60: {
                return pSSysMsgQueueBase.getUser2PSDEFName();
            }
            case 61: {
                return pSSysMsgQueueBase.getUserCat();
            }
            case 62: {
                return pSSysMsgQueueBase.getUserPSDEFId();
            }
            case 63: {
                return pSSysMsgQueueBase.getUserPSDEFName();
            }
            case 64: {
                return pSSysMsgQueueBase.getUserTag();
            }
            case 65: {
                return pSSysMsgQueueBase.getUserTag2();
            }
            case 66: {
                return pSSysMsgQueueBase.getUserTag3();
            }
            case 67: {
                return pSSysMsgQueueBase.getUserTag4();
            }
            case 68: {
                return pSSysMsgQueueBase.getValidFlag();
            }
            case 69: {
                return pSSysMsgQueueBase.getWXContentPSDEFId();
            }
            case 70: {
                return pSSysMsgQueueBase.getWXContentPSDEFName();
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
        PSSysMsgQueueBase.set(this, n, object);
    }

    private static void set(PSSysMsgQueueBase pSSysMsgQueueBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysMsgQueueBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysMsgQueueBase.setContentPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysMsgQueueBase.setContentPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysMsgQueueBase.setContentTypePSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysMsgQueueBase.setContentTypePSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysMsgQueueBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 6: {
                pSSysMsgQueueBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysMsgQueueBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysMsgQueueBase.setCustomMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSSysMsgQueueBase.setDDContentPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysMsgQueueBase.setDDContentPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysMsgQueueBase.setFilePSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysMsgQueueBase.setFilePSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysMsgQueueBase.setIMContentPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysMsgQueueBase.setIMContentPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysMsgQueueBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysMsgQueueBase.setMobTaskUrlPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysMsgQueueBase.setMobTaskUrlPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysMsgQueueBase.setMsgQueueParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysMsgQueueBase.setMsgQueueTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysMsgQueueBase.setMsgQueueTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysMsgQueueBase.setMsgQueueType(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysMsgQueueBase.setMsgTypePSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysMsgQueueBase.setMsgTypePSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysMsgQueueBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysMsgQueueBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysMsgQueueBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysMsgQueueBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysMsgQueueBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSysMsgQueueBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysMsgQueueBase.setPSSysMsgQueueId(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSSysMsgQueueBase.setPSSysMsgQueueName(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSysMsgQueueBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSSysMsgQueueBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSSysMsgQueueBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSSysMsgQueueBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSSysMsgQueueBase.setPSSysUtilDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSSysMsgQueueBase.setPSSysUtilDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSSysMsgQueueBase.setQueueParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSSysMsgQueueBase.setSendTimePSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSSysMsgQueueBase.setSendTimePSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSSysMsgQueueBase.setSMSContentPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSSysMsgQueueBase.setSMSContentPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSSysMsgQueueBase.setStatePSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSSysMsgQueueBase.setStatePSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSSysMsgQueueBase.setTag2PSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSSysMsgQueueBase.setTag2PSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSSysMsgQueueBase.setTagPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSSysMsgQueueBase.setTagPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSSysMsgQueueBase.setTargetPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSSysMsgQueueBase.setTargetPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSSysMsgQueueBase.setTargetTypePSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSSysMsgQueueBase.setTargetTypePSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 53: {
                pSSysMsgQueueBase.setTaskUrlPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 54: {
                pSSysMsgQueueBase.setTaskUrlPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 55: {
                pSSysMsgQueueBase.setTitlePSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 56: {
                pSSysMsgQueueBase.setTitlePSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 57: {
                pSSysMsgQueueBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 58: {
                pSSysMsgQueueBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 59: {
                pSSysMsgQueueBase.setUser2PSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 60: {
                pSSysMsgQueueBase.setUser2PSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 61: {
                pSSysMsgQueueBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 62: {
                pSSysMsgQueueBase.setUserPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 63: {
                pSSysMsgQueueBase.setUserPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 64: {
                pSSysMsgQueueBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 65: {
                pSSysMsgQueueBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 66: {
                pSSysMsgQueueBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 67: {
                pSSysMsgQueueBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 68: {
                pSSysMsgQueueBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 69: {
                pSSysMsgQueueBase.setWXContentPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 70: {
                pSSysMsgQueueBase.setWXContentPSDEFName(DataObject.getStringValue((Object)object));
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
        return PSSysMsgQueueBase.isNull(this, n);
    }

    private static boolean isNull(PSSysMsgQueueBase pSSysMsgQueueBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysMsgQueueBase.getCodeName() == null;
            }
            case 1: {
                return pSSysMsgQueueBase.getContentPSDEFId() == null;
            }
            case 2: {
                return pSSysMsgQueueBase.getContentPSDEFName() == null;
            }
            case 3: {
                return pSSysMsgQueueBase.getContentTypePSDEFId() == null;
            }
            case 4: {
                return pSSysMsgQueueBase.getContentTypePSDEFName() == null;
            }
            case 5: {
                return pSSysMsgQueueBase.getCreateDate() == null;
            }
            case 6: {
                return pSSysMsgQueueBase.getCreateMan() == null;
            }
            case 7: {
                return pSSysMsgQueueBase.getCustomCode() == null;
            }
            case 8: {
                return pSSysMsgQueueBase.getCustomMode() == null;
            }
            case 9: {
                return pSSysMsgQueueBase.getDDContentPSDEFId() == null;
            }
            case 10: {
                return pSSysMsgQueueBase.getDDContentPSDEFName() == null;
            }
            case 11: {
                return pSSysMsgQueueBase.getFilePSDEFId() == null;
            }
            case 12: {
                return pSSysMsgQueueBase.getFilePSDEFName() == null;
            }
            case 13: {
                return pSSysMsgQueueBase.getIMContentPSDEFId() == null;
            }
            case 14: {
                return pSSysMsgQueueBase.getIMContentPSDEFName() == null;
            }
            case 15: {
                return pSSysMsgQueueBase.getMemo() == null;
            }
            case 16: {
                return pSSysMsgQueueBase.getMobTaskUrlPSDEFId() == null;
            }
            case 17: {
                return pSSysMsgQueueBase.getMobTaskUrlPSDEFName() == null;
            }
            case 18: {
                return pSSysMsgQueueBase.getMsgQueueParams() == null;
            }
            case 19: {
                return pSSysMsgQueueBase.getMsgQueueTag() == null;
            }
            case 20: {
                return pSSysMsgQueueBase.getMsgQueueTag2() == null;
            }
            case 21: {
                return pSSysMsgQueueBase.getMsgQueueType() == null;
            }
            case 22: {
                return pSSysMsgQueueBase.getMsgTypePSDEFId() == null;
            }
            case 23: {
                return pSSysMsgQueueBase.getMsgTypePSDEFName() == null;
            }
            case 24: {
                return pSSysMsgQueueBase.getPSDEId() == null;
            }
            case 25: {
                return pSSysMsgQueueBase.getPSDEName() == null;
            }
            case 26: {
                return pSSysMsgQueueBase.getPSModuleId() == null;
            }
            case 27: {
                return pSSysMsgQueueBase.getPSModuleName() == null;
            }
            case 28: {
                return pSSysMsgQueueBase.getPSSysDynaModelId() == null;
            }
            case 29: {
                return pSSysMsgQueueBase.getPSSysDynaModelName() == null;
            }
            case 30: {
                return pSSysMsgQueueBase.getPSSysMsgQueueId() == null;
            }
            case 31: {
                return pSSysMsgQueueBase.getPSSysMsgQueueName() == null;
            }
            case 32: {
                return pSSysMsgQueueBase.getPSSysSFPluginId() == null;
            }
            case 33: {
                return pSSysMsgQueueBase.getPSSysSFPluginName() == null;
            }
            case 34: {
                return pSSysMsgQueueBase.getPSSystemId() == null;
            }
            case 35: {
                return pSSysMsgQueueBase.getPSSystemName() == null;
            }
            case 36: {
                return pSSysMsgQueueBase.getPSSysUtilDEId() == null;
            }
            case 37: {
                return pSSysMsgQueueBase.getPSSysUtilDEName() == null;
            }
            case 38: {
                return pSSysMsgQueueBase.getQueueParams() == null;
            }
            case 39: {
                return pSSysMsgQueueBase.getSendTimePSDEFId() == null;
            }
            case 40: {
                return pSSysMsgQueueBase.getSendTimePSDEFName() == null;
            }
            case 41: {
                return pSSysMsgQueueBase.getSMSContentPSDEFId() == null;
            }
            case 42: {
                return pSSysMsgQueueBase.getSMSContentPSDEFName() == null;
            }
            case 43: {
                return pSSysMsgQueueBase.getStatePSDEFId() == null;
            }
            case 44: {
                return pSSysMsgQueueBase.getStatePSDEFName() == null;
            }
            case 45: {
                return pSSysMsgQueueBase.getTag2PSDEFId() == null;
            }
            case 46: {
                return pSSysMsgQueueBase.getTag2PSDEFName() == null;
            }
            case 47: {
                return pSSysMsgQueueBase.getTagPSDEFId() == null;
            }
            case 48: {
                return pSSysMsgQueueBase.getTagPSDEFName() == null;
            }
            case 49: {
                return pSSysMsgQueueBase.getTargetPSDEFId() == null;
            }
            case 50: {
                return pSSysMsgQueueBase.getTargetPSDEFName() == null;
            }
            case 51: {
                return pSSysMsgQueueBase.getTargetTypePSDEFId() == null;
            }
            case 52: {
                return pSSysMsgQueueBase.getTargetTypePSDEFName() == null;
            }
            case 53: {
                return pSSysMsgQueueBase.getTaskUrlPSDEFId() == null;
            }
            case 54: {
                return pSSysMsgQueueBase.getTaskUrlPSDEFName() == null;
            }
            case 55: {
                return pSSysMsgQueueBase.getTitlePSDEFId() == null;
            }
            case 56: {
                return pSSysMsgQueueBase.getTitlePSDEFName() == null;
            }
            case 57: {
                return pSSysMsgQueueBase.getUpdateDate() == null;
            }
            case 58: {
                return pSSysMsgQueueBase.getUpdateMan() == null;
            }
            case 59: {
                return pSSysMsgQueueBase.getUser2PSDEFId() == null;
            }
            case 60: {
                return pSSysMsgQueueBase.getUser2PSDEFName() == null;
            }
            case 61: {
                return pSSysMsgQueueBase.getUserCat() == null;
            }
            case 62: {
                return pSSysMsgQueueBase.getUserPSDEFId() == null;
            }
            case 63: {
                return pSSysMsgQueueBase.getUserPSDEFName() == null;
            }
            case 64: {
                return pSSysMsgQueueBase.getUserTag() == null;
            }
            case 65: {
                return pSSysMsgQueueBase.getUserTag2() == null;
            }
            case 66: {
                return pSSysMsgQueueBase.getUserTag3() == null;
            }
            case 67: {
                return pSSysMsgQueueBase.getUserTag4() == null;
            }
            case 68: {
                return pSSysMsgQueueBase.getValidFlag() == null;
            }
            case 69: {
                return pSSysMsgQueueBase.getWXContentPSDEFId() == null;
            }
            case 70: {
                return pSSysMsgQueueBase.getWXContentPSDEFName() == null;
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
        return PSSysMsgQueueBase.contains(this, n);
    }

    private static boolean contains(PSSysMsgQueueBase pSSysMsgQueueBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysMsgQueueBase.isCodeNameDirty();
            }
            case 1: {
                return pSSysMsgQueueBase.isContentPSDEFIdDirty();
            }
            case 2: {
                return pSSysMsgQueueBase.isContentPSDEFNameDirty();
            }
            case 3: {
                return pSSysMsgQueueBase.isContentTypePSDEFIdDirty();
            }
            case 4: {
                return pSSysMsgQueueBase.isContentTypePSDEFNameDirty();
            }
            case 5: {
                return pSSysMsgQueueBase.isCreateDateDirty();
            }
            case 6: {
                return pSSysMsgQueueBase.isCreateManDirty();
            }
            case 7: {
                return pSSysMsgQueueBase.isCustomCodeDirty();
            }
            case 8: {
                return pSSysMsgQueueBase.isCustomModeDirty();
            }
            case 9: {
                return pSSysMsgQueueBase.isDDContentPSDEFIdDirty();
            }
            case 10: {
                return pSSysMsgQueueBase.isDDContentPSDEFNameDirty();
            }
            case 11: {
                return pSSysMsgQueueBase.isFilePSDEFIdDirty();
            }
            case 12: {
                return pSSysMsgQueueBase.isFilePSDEFNameDirty();
            }
            case 13: {
                return pSSysMsgQueueBase.isIMContentPSDEFIdDirty();
            }
            case 14: {
                return pSSysMsgQueueBase.isIMContentPSDEFNameDirty();
            }
            case 15: {
                return pSSysMsgQueueBase.isMemoDirty();
            }
            case 16: {
                return pSSysMsgQueueBase.isMobTaskUrlPSDEFIdDirty();
            }
            case 17: {
                return pSSysMsgQueueBase.isMobTaskUrlPSDEFNameDirty();
            }
            case 18: {
                return pSSysMsgQueueBase.isMsgQueueParamsDirty();
            }
            case 19: {
                return pSSysMsgQueueBase.isMsgQueueTagDirty();
            }
            case 20: {
                return pSSysMsgQueueBase.isMsgQueueTag2Dirty();
            }
            case 21: {
                return pSSysMsgQueueBase.isMsgQueueTypeDirty();
            }
            case 22: {
                return pSSysMsgQueueBase.isMsgTypePSDEFIdDirty();
            }
            case 23: {
                return pSSysMsgQueueBase.isMsgTypePSDEFNameDirty();
            }
            case 24: {
                return pSSysMsgQueueBase.isPSDEIdDirty();
            }
            case 25: {
                return pSSysMsgQueueBase.isPSDENameDirty();
            }
            case 26: {
                return pSSysMsgQueueBase.isPSModuleIdDirty();
            }
            case 27: {
                return pSSysMsgQueueBase.isPSModuleNameDirty();
            }
            case 28: {
                return pSSysMsgQueueBase.isPSSysDynaModelIdDirty();
            }
            case 29: {
                return pSSysMsgQueueBase.isPSSysDynaModelNameDirty();
            }
            case 30: {
                return pSSysMsgQueueBase.isPSSysMsgQueueIdDirty();
            }
            case 31: {
                return pSSysMsgQueueBase.isPSSysMsgQueueNameDirty();
            }
            case 32: {
                return pSSysMsgQueueBase.isPSSysSFPluginIdDirty();
            }
            case 33: {
                return pSSysMsgQueueBase.isPSSysSFPluginNameDirty();
            }
            case 34: {
                return pSSysMsgQueueBase.isPSSystemIdDirty();
            }
            case 35: {
                return pSSysMsgQueueBase.isPSSystemNameDirty();
            }
            case 36: {
                return pSSysMsgQueueBase.isPSSysUtilDEIdDirty();
            }
            case 37: {
                return pSSysMsgQueueBase.isPSSysUtilDENameDirty();
            }
            case 38: {
                return pSSysMsgQueueBase.isQueueParamsDirty();
            }
            case 39: {
                return pSSysMsgQueueBase.isSendTimePSDEFIdDirty();
            }
            case 40: {
                return pSSysMsgQueueBase.isSendTimePSDEFNameDirty();
            }
            case 41: {
                return pSSysMsgQueueBase.isSMSContentPSDEFIdDirty();
            }
            case 42: {
                return pSSysMsgQueueBase.isSMSContentPSDEFNameDirty();
            }
            case 43: {
                return pSSysMsgQueueBase.isStatePSDEFIdDirty();
            }
            case 44: {
                return pSSysMsgQueueBase.isStatePSDEFNameDirty();
            }
            case 45: {
                return pSSysMsgQueueBase.isTag2PSDEFIdDirty();
            }
            case 46: {
                return pSSysMsgQueueBase.isTag2PSDEFNameDirty();
            }
            case 47: {
                return pSSysMsgQueueBase.isTagPSDEFIdDirty();
            }
            case 48: {
                return pSSysMsgQueueBase.isTagPSDEFNameDirty();
            }
            case 49: {
                return pSSysMsgQueueBase.isTargetPSDEFIdDirty();
            }
            case 50: {
                return pSSysMsgQueueBase.isTargetPSDEFNameDirty();
            }
            case 51: {
                return pSSysMsgQueueBase.isTargetTypePSDEFIdDirty();
            }
            case 52: {
                return pSSysMsgQueueBase.isTargetTypePSDEFNameDirty();
            }
            case 53: {
                return pSSysMsgQueueBase.isTaskUrlPSDEFIdDirty();
            }
            case 54: {
                return pSSysMsgQueueBase.isTaskUrlPSDEFNameDirty();
            }
            case 55: {
                return pSSysMsgQueueBase.isTitlePSDEFIdDirty();
            }
            case 56: {
                return pSSysMsgQueueBase.isTitlePSDEFNameDirty();
            }
            case 57: {
                return pSSysMsgQueueBase.isUpdateDateDirty();
            }
            case 58: {
                return pSSysMsgQueueBase.isUpdateManDirty();
            }
            case 59: {
                return pSSysMsgQueueBase.isUser2PSDEFIdDirty();
            }
            case 60: {
                return pSSysMsgQueueBase.isUser2PSDEFNameDirty();
            }
            case 61: {
                return pSSysMsgQueueBase.isUserCatDirty();
            }
            case 62: {
                return pSSysMsgQueueBase.isUserPSDEFIdDirty();
            }
            case 63: {
                return pSSysMsgQueueBase.isUserPSDEFNameDirty();
            }
            case 64: {
                return pSSysMsgQueueBase.isUserTagDirty();
            }
            case 65: {
                return pSSysMsgQueueBase.isUserTag2Dirty();
            }
            case 66: {
                return pSSysMsgQueueBase.isUserTag3Dirty();
            }
            case 67: {
                return pSSysMsgQueueBase.isUserTag4Dirty();
            }
            case 68: {
                return pSSysMsgQueueBase.isValidFlagDirty();
            }
            case 69: {
                return pSSysMsgQueueBase.isWXContentPSDEFIdDirty();
            }
            case 70: {
                return pSSysMsgQueueBase.isWXContentPSDEFNameDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysMsgQueueBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysMsgQueueBase pSSysMsgQueueBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysMsgQueueBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysMsgQueueBase.getJSONValue((Object)pSSysMsgQueueBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysMsgQueueBase.getContentPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"contentpsdefid", (Object)PSSysMsgQueueBase.getJSONValue((Object)pSSysMsgQueueBase.getContentPSDEFId()), (boolean)false);
        }
        if (bl || pSSysMsgQueueBase.getContentPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"contentpsdefname", (Object)PSSysMsgQueueBase.getJSONValue((Object)pSSysMsgQueueBase.getContentPSDEFName()), (boolean)false);
        }
        if (bl || pSSysMsgQueueBase.getContentTypePSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"contenttypepsdefid", (Object)PSSysMsgQueueBase.getJSONValue((Object)pSSysMsgQueueBase.getContentTypePSDEFId()), (boolean)false);
        }
        if (bl || pSSysMsgQueueBase.getContentTypePSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"contenttypepsdefname", (Object)PSSysMsgQueueBase.getJSONValue((Object)pSSysMsgQueueBase.getContentTypePSDEFName()), (boolean)false);
        }
        if (bl || pSSysMsgQueueBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysMsgQueueBase.getJSONValue((Object)pSSysMsgQueueBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysMsgQueueBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysMsgQueueBase.getJSONValue((Object)pSSysMsgQueueBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysMsgQueueBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSSysMsgQueueBase.getJSONValue((Object)pSSysMsgQueueBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSSysMsgQueueBase.getCustomMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"custommode", (Object)PSSysMsgQueueBase.getJSONValue((Object)pSSysMsgQueueBase.getCustomMode()), (boolean)false);
        }
        if (bl || pSSysMsgQueueBase.getDDContentPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ddcontentpsdefid", (Object)PSSysMsgQueueBase.getJSONValue((Object)pSSysMsgQueueBase.getDDContentPSDEFId()), (boolean)false);
        }
        if (bl || pSSysMsgQueueBase.getDDContentPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ddcontentpsdefname", (Object)PSSysMsgQueueBase.getJSONValue((Object)pSSysMsgQueueBase.getDDContentPSDEFName()), (boolean)false);
        }
        if (bl || pSSysMsgQueueBase.getFilePSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"filepsdefid", (Object)PSSysMsgQueueBase.getJSONValue((Object)pSSysMsgQueueBase.getFilePSDEFId()), (boolean)false);
        }
        if (bl || pSSysMsgQueueBase.getFilePSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"filepsdefname", (Object)PSSysMsgQueueBase.getJSONValue((Object)pSSysMsgQueueBase.getFilePSDEFName()), (boolean)false);
        }
        if (bl || pSSysMsgQueueBase.getIMContentPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"imcontentpsdefid", (Object)PSSysMsgQueueBase.getJSONValue((Object)pSSysMsgQueueBase.getIMContentPSDEFId()), (boolean)false);
        }
        if (bl || pSSysMsgQueueBase.getIMContentPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"imcontentpsdefname", (Object)PSSysMsgQueueBase.getJSONValue((Object)pSSysMsgQueueBase.getIMContentPSDEFName()), (boolean)false);
        }
        if (bl || pSSysMsgQueueBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysMsgQueueBase.getJSONValue((Object)pSSysMsgQueueBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysMsgQueueBase.getMobTaskUrlPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobtaskurlpsdefid", (Object)PSSysMsgQueueBase.getJSONValue((Object)pSSysMsgQueueBase.getMobTaskUrlPSDEFId()), (boolean)false);
        }
        if (bl || pSSysMsgQueueBase.getMobTaskUrlPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobtaskurlpsdefname", (Object)PSSysMsgQueueBase.getJSONValue((Object)pSSysMsgQueueBase.getMobTaskUrlPSDEFName()), (boolean)false);
        }
        if (bl || pSSysMsgQueueBase.getMsgQueueParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"msgqueueparams", (Object)PSSysMsgQueueBase.getJSONValue((Object)pSSysMsgQueueBase.getMsgQueueParams()), (boolean)false);
        }
        if (bl || pSSysMsgQueueBase.getMsgQueueTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"msgqueuetag", (Object)PSSysMsgQueueBase.getJSONValue((Object)pSSysMsgQueueBase.getMsgQueueTag()), (boolean)false);
        }
        if (bl || pSSysMsgQueueBase.getMsgQueueTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"msgqueuetag2", (Object)PSSysMsgQueueBase.getJSONValue((Object)pSSysMsgQueueBase.getMsgQueueTag2()), (boolean)false);
        }
        if (bl || pSSysMsgQueueBase.getMsgQueueType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"msgqueuetype", (Object)PSSysMsgQueueBase.getJSONValue((Object)pSSysMsgQueueBase.getMsgQueueType()), (boolean)false);
        }
        if (bl || pSSysMsgQueueBase.getMsgTypePSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"msgtypepsdefid", (Object)PSSysMsgQueueBase.getJSONValue((Object)pSSysMsgQueueBase.getMsgTypePSDEFId()), (boolean)false);
        }
        if (bl || pSSysMsgQueueBase.getMsgTypePSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"msgtypepsdefname", (Object)PSSysMsgQueueBase.getJSONValue((Object)pSSysMsgQueueBase.getMsgTypePSDEFName()), (boolean)false);
        }
        if (bl || pSSysMsgQueueBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSSysMsgQueueBase.getJSONValue((Object)pSSysMsgQueueBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSSysMsgQueueBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSSysMsgQueueBase.getJSONValue((Object)pSSysMsgQueueBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSSysMsgQueueBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSSysMsgQueueBase.getJSONValue((Object)pSSysMsgQueueBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSSysMsgQueueBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSSysMsgQueueBase.getJSONValue((Object)pSSysMsgQueueBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSSysMsgQueueBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSSysMsgQueueBase.getJSONValue((Object)pSSysMsgQueueBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSSysMsgQueueBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSSysMsgQueueBase.getJSONValue((Object)pSSysMsgQueueBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSSysMsgQueueBase.getPSSysMsgQueueId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmsgqueueid", (Object)PSSysMsgQueueBase.getJSONValue((Object)pSSysMsgQueueBase.getPSSysMsgQueueId()), (boolean)false);
        }
        if (bl || pSSysMsgQueueBase.getPSSysMsgQueueName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmsgqueuename", (Object)PSSysMsgQueueBase.getJSONValue((Object)pSSysMsgQueueBase.getPSSysMsgQueueName()), (boolean)false);
        }
        if (bl || pSSysMsgQueueBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSSysMsgQueueBase.getJSONValue((Object)pSSysMsgQueueBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSSysMsgQueueBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSSysMsgQueueBase.getJSONValue((Object)pSSysMsgQueueBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSSysMsgQueueBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysMsgQueueBase.getJSONValue((Object)pSSysMsgQueueBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysMsgQueueBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysMsgQueueBase.getJSONValue((Object)pSSysMsgQueueBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysMsgQueueBase.getPSSysUtilDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysutildeid", (Object)PSSysMsgQueueBase.getJSONValue((Object)pSSysMsgQueueBase.getPSSysUtilDEId()), (boolean)false);
        }
        if (bl || pSSysMsgQueueBase.getPSSysUtilDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysutildename", (Object)PSSysMsgQueueBase.getJSONValue((Object)pSSysMsgQueueBase.getPSSysUtilDEName()), (boolean)false);
        }
        if (bl || pSSysMsgQueueBase.getQueueParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"queueparams", (Object)PSSysMsgQueueBase.getJSONValue((Object)pSSysMsgQueueBase.getQueueParams()), (boolean)false);
        }
        if (bl || pSSysMsgQueueBase.getSendTimePSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sendtimepsdefid", (Object)PSSysMsgQueueBase.getJSONValue((Object)pSSysMsgQueueBase.getSendTimePSDEFId()), (boolean)false);
        }
        if (bl || pSSysMsgQueueBase.getSendTimePSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sendtimepsdefname", (Object)PSSysMsgQueueBase.getJSONValue((Object)pSSysMsgQueueBase.getSendTimePSDEFName()), (boolean)false);
        }
        if (bl || pSSysMsgQueueBase.getSMSContentPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"smscontentpsdefid", (Object)PSSysMsgQueueBase.getJSONValue((Object)pSSysMsgQueueBase.getSMSContentPSDEFId()), (boolean)false);
        }
        if (bl || pSSysMsgQueueBase.getSMSContentPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"smscontentpsdefname", (Object)PSSysMsgQueueBase.getJSONValue((Object)pSSysMsgQueueBase.getSMSContentPSDEFName()), (boolean)false);
        }
        if (bl || pSSysMsgQueueBase.getStatePSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"statepsdefid", (Object)PSSysMsgQueueBase.getJSONValue((Object)pSSysMsgQueueBase.getStatePSDEFId()), (boolean)false);
        }
        if (bl || pSSysMsgQueueBase.getStatePSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"statepsdefname", (Object)PSSysMsgQueueBase.getJSONValue((Object)pSSysMsgQueueBase.getStatePSDEFName()), (boolean)false);
        }
        if (bl || pSSysMsgQueueBase.getTag2PSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tag2psdefid", (Object)PSSysMsgQueueBase.getJSONValue((Object)pSSysMsgQueueBase.getTag2PSDEFId()), (boolean)false);
        }
        if (bl || pSSysMsgQueueBase.getTag2PSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tag2psdefname", (Object)PSSysMsgQueueBase.getJSONValue((Object)pSSysMsgQueueBase.getTag2PSDEFName()), (boolean)false);
        }
        if (bl || pSSysMsgQueueBase.getTagPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tagpsdefid", (Object)PSSysMsgQueueBase.getJSONValue((Object)pSSysMsgQueueBase.getTagPSDEFId()), (boolean)false);
        }
        if (bl || pSSysMsgQueueBase.getTagPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tagpsdefname", (Object)PSSysMsgQueueBase.getJSONValue((Object)pSSysMsgQueueBase.getTagPSDEFName()), (boolean)false);
        }
        if (bl || pSSysMsgQueueBase.getTargetPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"targetpsdefid", (Object)PSSysMsgQueueBase.getJSONValue((Object)pSSysMsgQueueBase.getTargetPSDEFId()), (boolean)false);
        }
        if (bl || pSSysMsgQueueBase.getTargetPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"targetpsdefname", (Object)PSSysMsgQueueBase.getJSONValue((Object)pSSysMsgQueueBase.getTargetPSDEFName()), (boolean)false);
        }
        if (bl || pSSysMsgQueueBase.getTargetTypePSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"targettypepsdefid", (Object)PSSysMsgQueueBase.getJSONValue((Object)pSSysMsgQueueBase.getTargetTypePSDEFId()), (boolean)false);
        }
        if (bl || pSSysMsgQueueBase.getTargetTypePSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"targettypepsdefname", (Object)PSSysMsgQueueBase.getJSONValue((Object)pSSysMsgQueueBase.getTargetTypePSDEFName()), (boolean)false);
        }
        if (bl || pSSysMsgQueueBase.getTaskUrlPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"taskurlpsdefid", (Object)PSSysMsgQueueBase.getJSONValue((Object)pSSysMsgQueueBase.getTaskUrlPSDEFId()), (boolean)false);
        }
        if (bl || pSSysMsgQueueBase.getTaskUrlPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"taskurlpsdefname", (Object)PSSysMsgQueueBase.getJSONValue((Object)pSSysMsgQueueBase.getTaskUrlPSDEFName()), (boolean)false);
        }
        if (bl || pSSysMsgQueueBase.getTitlePSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"titlepsdefid", (Object)PSSysMsgQueueBase.getJSONValue((Object)pSSysMsgQueueBase.getTitlePSDEFId()), (boolean)false);
        }
        if (bl || pSSysMsgQueueBase.getTitlePSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"titlepsdefname", (Object)PSSysMsgQueueBase.getJSONValue((Object)pSSysMsgQueueBase.getTitlePSDEFName()), (boolean)false);
        }
        if (bl || pSSysMsgQueueBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysMsgQueueBase.getJSONValue((Object)pSSysMsgQueueBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysMsgQueueBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysMsgQueueBase.getJSONValue((Object)pSSysMsgQueueBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysMsgQueueBase.getUser2PSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"user2psdefid", (Object)PSSysMsgQueueBase.getJSONValue((Object)pSSysMsgQueueBase.getUser2PSDEFId()), (boolean)false);
        }
        if (bl || pSSysMsgQueueBase.getUser2PSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"user2psdefname", (Object)PSSysMsgQueueBase.getJSONValue((Object)pSSysMsgQueueBase.getUser2PSDEFName()), (boolean)false);
        }
        if (bl || pSSysMsgQueueBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysMsgQueueBase.getJSONValue((Object)pSSysMsgQueueBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysMsgQueueBase.getUserPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userpsdefid", (Object)PSSysMsgQueueBase.getJSONValue((Object)pSSysMsgQueueBase.getUserPSDEFId()), (boolean)false);
        }
        if (bl || pSSysMsgQueueBase.getUserPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userpsdefname", (Object)PSSysMsgQueueBase.getJSONValue((Object)pSSysMsgQueueBase.getUserPSDEFName()), (boolean)false);
        }
        if (bl || pSSysMsgQueueBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysMsgQueueBase.getJSONValue((Object)pSSysMsgQueueBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysMsgQueueBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysMsgQueueBase.getJSONValue((Object)pSSysMsgQueueBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysMsgQueueBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysMsgQueueBase.getJSONValue((Object)pSSysMsgQueueBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysMsgQueueBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysMsgQueueBase.getJSONValue((Object)pSSysMsgQueueBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysMsgQueueBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysMsgQueueBase.getJSONValue((Object)pSSysMsgQueueBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSSysMsgQueueBase.getWXContentPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wxcontentpsdefid", (Object)PSSysMsgQueueBase.getJSONValue((Object)pSSysMsgQueueBase.getWXContentPSDEFId()), (boolean)false);
        }
        if (bl || pSSysMsgQueueBase.getWXContentPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wxcontentpsdefname", (Object)PSSysMsgQueueBase.getJSONValue((Object)pSSysMsgQueueBase.getWXContentPSDEFName()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysMsgQueueBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysMsgQueueBase pSSysMsgQueueBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysMsgQueueBase.getCodeName() != null) {
            object = pSSysMsgQueueBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, (String)(object == null ? "" : object));
        }
        if (bl || pSSysMsgQueueBase.getContentPSDEFId() != null) {
            object = pSSysMsgQueueBase.getContentPSDEFId();
            xmlNode.setAttribute(FIELD_CONTENTPSDEFID, (String)(object == null ? "" : object));
        }
        if (bl || pSSysMsgQueueBase.getContentPSDEFName() != null) {
            object = pSSysMsgQueueBase.getContentPSDEFName();
            xmlNode.setAttribute(FIELD_CONTENTPSDEFNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSSysMsgQueueBase.getContentTypePSDEFId() != null) {
            object = pSSysMsgQueueBase.getContentTypePSDEFId();
            xmlNode.setAttribute(FIELD_CONTENTTYPEPSDEFID, (String)(object == null ? "" : object));
        }
        if (bl || pSSysMsgQueueBase.getContentTypePSDEFName() != null) {
            object = pSSysMsgQueueBase.getContentTypePSDEFName();
            xmlNode.setAttribute(FIELD_CONTENTTYPEPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgQueueBase.getCreateDate() != null) {
            object = pSSysMsgQueueBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysMsgQueueBase.getCreateMan() != null) {
            object = pSSysMsgQueueBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgQueueBase.getCustomCode() != null) {
            object = pSSysMsgQueueBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgQueueBase.getCustomMode() != null) {
            object = pSSysMsgQueueBase.getCustomMode();
            xmlNode.setAttribute(FIELD_CUSTOMMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysMsgQueueBase.getDDContentPSDEFId() != null) {
            object = pSSysMsgQueueBase.getDDContentPSDEFId();
            xmlNode.setAttribute(FIELD_DDCONTENTPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgQueueBase.getDDContentPSDEFName() != null) {
            object = pSSysMsgQueueBase.getDDContentPSDEFName();
            xmlNode.setAttribute(FIELD_DDCONTENTPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgQueueBase.getFilePSDEFId() != null) {
            object = pSSysMsgQueueBase.getFilePSDEFId();
            xmlNode.setAttribute(FIELD_FILEPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgQueueBase.getFilePSDEFName() != null) {
            object = pSSysMsgQueueBase.getFilePSDEFName();
            xmlNode.setAttribute(FIELD_FILEPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgQueueBase.getIMContentPSDEFId() != null) {
            object = pSSysMsgQueueBase.getIMContentPSDEFId();
            xmlNode.setAttribute(FIELD_IMCONTENTPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgQueueBase.getIMContentPSDEFName() != null) {
            object = pSSysMsgQueueBase.getIMContentPSDEFName();
            xmlNode.setAttribute(FIELD_IMCONTENTPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgQueueBase.getMemo() != null) {
            object = pSSysMsgQueueBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgQueueBase.getMobTaskUrlPSDEFId() != null) {
            object = pSSysMsgQueueBase.getMobTaskUrlPSDEFId();
            xmlNode.setAttribute(FIELD_MOBTASKURLPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgQueueBase.getMobTaskUrlPSDEFName() != null) {
            object = pSSysMsgQueueBase.getMobTaskUrlPSDEFName();
            xmlNode.setAttribute(FIELD_MOBTASKURLPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgQueueBase.getMsgQueueParams() != null) {
            object = pSSysMsgQueueBase.getMsgQueueParams();
            xmlNode.setAttribute(FIELD_MSGQUEUEPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgQueueBase.getMsgQueueTag() != null) {
            object = pSSysMsgQueueBase.getMsgQueueTag();
            xmlNode.setAttribute(FIELD_MSGQUEUETAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgQueueBase.getMsgQueueTag2() != null) {
            object = pSSysMsgQueueBase.getMsgQueueTag2();
            xmlNode.setAttribute(FIELD_MSGQUEUETAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgQueueBase.getMsgQueueType() != null) {
            object = pSSysMsgQueueBase.getMsgQueueType();
            xmlNode.setAttribute(FIELD_MSGQUEUETYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgQueueBase.getMsgTypePSDEFId() != null) {
            object = pSSysMsgQueueBase.getMsgTypePSDEFId();
            xmlNode.setAttribute(FIELD_MSGTYPEPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgQueueBase.getMsgTypePSDEFName() != null) {
            object = pSSysMsgQueueBase.getMsgTypePSDEFName();
            xmlNode.setAttribute(FIELD_MSGTYPEPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgQueueBase.getPSDEId() != null) {
            object = pSSysMsgQueueBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgQueueBase.getPSDEName() != null) {
            object = pSSysMsgQueueBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgQueueBase.getPSModuleId() != null) {
            object = pSSysMsgQueueBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgQueueBase.getPSModuleName() != null) {
            object = pSSysMsgQueueBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgQueueBase.getPSSysDynaModelId() != null) {
            object = pSSysMsgQueueBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgQueueBase.getPSSysDynaModelName() != null) {
            object = pSSysMsgQueueBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgQueueBase.getPSSysMsgQueueId() != null) {
            object = pSSysMsgQueueBase.getPSSysMsgQueueId();
            xmlNode.setAttribute(FIELD_PSSYSMSGQUEUEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgQueueBase.getPSSysMsgQueueName() != null) {
            object = pSSysMsgQueueBase.getPSSysMsgQueueName();
            xmlNode.setAttribute(FIELD_PSSYSMSGQUEUENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgQueueBase.getPSSysSFPluginId() != null) {
            object = pSSysMsgQueueBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgQueueBase.getPSSysSFPluginName() != null) {
            object = pSSysMsgQueueBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgQueueBase.getPSSystemId() != null) {
            object = pSSysMsgQueueBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgQueueBase.getPSSystemName() != null) {
            object = pSSysMsgQueueBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgQueueBase.getPSSysUtilDEId() != null) {
            object = pSSysMsgQueueBase.getPSSysUtilDEId();
            xmlNode.setAttribute(FIELD_PSSYSUTILDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgQueueBase.getPSSysUtilDEName() != null) {
            object = pSSysMsgQueueBase.getPSSysUtilDEName();
            xmlNode.setAttribute(FIELD_PSSYSUTILDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgQueueBase.getQueueParams() != null) {
            object = pSSysMsgQueueBase.getQueueParams();
            xmlNode.setAttribute(FIELD_QUEUEPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgQueueBase.getSendTimePSDEFId() != null) {
            object = pSSysMsgQueueBase.getSendTimePSDEFId();
            xmlNode.setAttribute(FIELD_SENDTIMEPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgQueueBase.getSendTimePSDEFName() != null) {
            object = pSSysMsgQueueBase.getSendTimePSDEFName();
            xmlNode.setAttribute(FIELD_SENDTIMEPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgQueueBase.getSMSContentPSDEFId() != null) {
            object = pSSysMsgQueueBase.getSMSContentPSDEFId();
            xmlNode.setAttribute(FIELD_SMSCONTENTPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgQueueBase.getSMSContentPSDEFName() != null) {
            object = pSSysMsgQueueBase.getSMSContentPSDEFName();
            xmlNode.setAttribute(FIELD_SMSCONTENTPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgQueueBase.getStatePSDEFId() != null) {
            object = pSSysMsgQueueBase.getStatePSDEFId();
            xmlNode.setAttribute(FIELD_STATEPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgQueueBase.getStatePSDEFName() != null) {
            object = pSSysMsgQueueBase.getStatePSDEFName();
            xmlNode.setAttribute(FIELD_STATEPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgQueueBase.getTag2PSDEFId() != null) {
            object = pSSysMsgQueueBase.getTag2PSDEFId();
            xmlNode.setAttribute(FIELD_TAG2PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgQueueBase.getTag2PSDEFName() != null) {
            object = pSSysMsgQueueBase.getTag2PSDEFName();
            xmlNode.setAttribute(FIELD_TAG2PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgQueueBase.getTagPSDEFId() != null) {
            object = pSSysMsgQueueBase.getTagPSDEFId();
            xmlNode.setAttribute(FIELD_TAGPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgQueueBase.getTagPSDEFName() != null) {
            object = pSSysMsgQueueBase.getTagPSDEFName();
            xmlNode.setAttribute(FIELD_TAGPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgQueueBase.getTargetPSDEFId() != null) {
            object = pSSysMsgQueueBase.getTargetPSDEFId();
            xmlNode.setAttribute(FIELD_TARGETPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgQueueBase.getTargetPSDEFName() != null) {
            object = pSSysMsgQueueBase.getTargetPSDEFName();
            xmlNode.setAttribute(FIELD_TARGETPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgQueueBase.getTargetTypePSDEFId() != null) {
            object = pSSysMsgQueueBase.getTargetTypePSDEFId();
            xmlNode.setAttribute(FIELD_TARGETTYPEPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgQueueBase.getTargetTypePSDEFName() != null) {
            object = pSSysMsgQueueBase.getTargetTypePSDEFName();
            xmlNode.setAttribute(FIELD_TARGETTYPEPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgQueueBase.getTaskUrlPSDEFId() != null) {
            object = pSSysMsgQueueBase.getTaskUrlPSDEFId();
            xmlNode.setAttribute(FIELD_TASKURLPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgQueueBase.getTaskUrlPSDEFName() != null) {
            object = pSSysMsgQueueBase.getTaskUrlPSDEFName();
            xmlNode.setAttribute(FIELD_TASKURLPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgQueueBase.getTitlePSDEFId() != null) {
            object = pSSysMsgQueueBase.getTitlePSDEFId();
            xmlNode.setAttribute(FIELD_TITLEPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgQueueBase.getTitlePSDEFName() != null) {
            object = pSSysMsgQueueBase.getTitlePSDEFName();
            xmlNode.setAttribute(FIELD_TITLEPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgQueueBase.getUpdateDate() != null) {
            object = pSSysMsgQueueBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysMsgQueueBase.getUpdateMan() != null) {
            object = pSSysMsgQueueBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgQueueBase.getUser2PSDEFId() != null) {
            object = pSSysMsgQueueBase.getUser2PSDEFId();
            xmlNode.setAttribute(FIELD_USER2PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgQueueBase.getUser2PSDEFName() != null) {
            object = pSSysMsgQueueBase.getUser2PSDEFName();
            xmlNode.setAttribute(FIELD_USER2PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgQueueBase.getUserCat() != null) {
            object = pSSysMsgQueueBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgQueueBase.getUserPSDEFId() != null) {
            object = pSSysMsgQueueBase.getUserPSDEFId();
            xmlNode.setAttribute(FIELD_USERPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgQueueBase.getUserPSDEFName() != null) {
            object = pSSysMsgQueueBase.getUserPSDEFName();
            xmlNode.setAttribute(FIELD_USERPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgQueueBase.getUserTag() != null) {
            object = pSSysMsgQueueBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgQueueBase.getUserTag2() != null) {
            object = pSSysMsgQueueBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgQueueBase.getUserTag3() != null) {
            object = pSSysMsgQueueBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgQueueBase.getUserTag4() != null) {
            object = pSSysMsgQueueBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgQueueBase.getValidFlag() != null) {
            object = pSSysMsgQueueBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysMsgQueueBase.getWXContentPSDEFId() != null) {
            object = pSSysMsgQueueBase.getWXContentPSDEFId();
            xmlNode.setAttribute(FIELD_WXCONTENTPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgQueueBase.getWXContentPSDEFName() != null) {
            object = pSSysMsgQueueBase.getWXContentPSDEFName();
            xmlNode.setAttribute(FIELD_WXCONTENTPSDEFNAME, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysMsgQueueBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysMsgQueueBase pSSysMsgQueueBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysMsgQueueBase.isCodeNameDirty() && (bl || pSSysMsgQueueBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysMsgQueueBase.getCodeName());
        }
        if (pSSysMsgQueueBase.isContentPSDEFIdDirty() && (bl || pSSysMsgQueueBase.getContentPSDEFId() != null)) {
            iDataObject.set(FIELD_CONTENTPSDEFID, (Object)pSSysMsgQueueBase.getContentPSDEFId());
        }
        if (pSSysMsgQueueBase.isContentPSDEFNameDirty() && (bl || pSSysMsgQueueBase.getContentPSDEFName() != null)) {
            iDataObject.set(FIELD_CONTENTPSDEFNAME, (Object)pSSysMsgQueueBase.getContentPSDEFName());
        }
        if (pSSysMsgQueueBase.isContentTypePSDEFIdDirty() && (bl || pSSysMsgQueueBase.getContentTypePSDEFId() != null)) {
            iDataObject.set(FIELD_CONTENTTYPEPSDEFID, (Object)pSSysMsgQueueBase.getContentTypePSDEFId());
        }
        if (pSSysMsgQueueBase.isContentTypePSDEFNameDirty() && (bl || pSSysMsgQueueBase.getContentTypePSDEFName() != null)) {
            iDataObject.set(FIELD_CONTENTTYPEPSDEFNAME, (Object)pSSysMsgQueueBase.getContentTypePSDEFName());
        }
        if (pSSysMsgQueueBase.isCreateDateDirty() && (bl || pSSysMsgQueueBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysMsgQueueBase.getCreateDate());
        }
        if (pSSysMsgQueueBase.isCreateManDirty() && (bl || pSSysMsgQueueBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysMsgQueueBase.getCreateMan());
        }
        if (pSSysMsgQueueBase.isCustomCodeDirty() && (bl || pSSysMsgQueueBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSSysMsgQueueBase.getCustomCode());
        }
        if (pSSysMsgQueueBase.isCustomModeDirty() && (bl || pSSysMsgQueueBase.getCustomMode() != null)) {
            iDataObject.set(FIELD_CUSTOMMODE, (Object)pSSysMsgQueueBase.getCustomMode());
        }
        if (pSSysMsgQueueBase.isDDContentPSDEFIdDirty() && (bl || pSSysMsgQueueBase.getDDContentPSDEFId() != null)) {
            iDataObject.set(FIELD_DDCONTENTPSDEFID, (Object)pSSysMsgQueueBase.getDDContentPSDEFId());
        }
        if (pSSysMsgQueueBase.isDDContentPSDEFNameDirty() && (bl || pSSysMsgQueueBase.getDDContentPSDEFName() != null)) {
            iDataObject.set(FIELD_DDCONTENTPSDEFNAME, (Object)pSSysMsgQueueBase.getDDContentPSDEFName());
        }
        if (pSSysMsgQueueBase.isFilePSDEFIdDirty() && (bl || pSSysMsgQueueBase.getFilePSDEFId() != null)) {
            iDataObject.set(FIELD_FILEPSDEFID, (Object)pSSysMsgQueueBase.getFilePSDEFId());
        }
        if (pSSysMsgQueueBase.isFilePSDEFNameDirty() && (bl || pSSysMsgQueueBase.getFilePSDEFName() != null)) {
            iDataObject.set(FIELD_FILEPSDEFNAME, (Object)pSSysMsgQueueBase.getFilePSDEFName());
        }
        if (pSSysMsgQueueBase.isIMContentPSDEFIdDirty() && (bl || pSSysMsgQueueBase.getIMContentPSDEFId() != null)) {
            iDataObject.set(FIELD_IMCONTENTPSDEFID, (Object)pSSysMsgQueueBase.getIMContentPSDEFId());
        }
        if (pSSysMsgQueueBase.isIMContentPSDEFNameDirty() && (bl || pSSysMsgQueueBase.getIMContentPSDEFName() != null)) {
            iDataObject.set(FIELD_IMCONTENTPSDEFNAME, (Object)pSSysMsgQueueBase.getIMContentPSDEFName());
        }
        if (pSSysMsgQueueBase.isMemoDirty() && (bl || pSSysMsgQueueBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysMsgQueueBase.getMemo());
        }
        if (pSSysMsgQueueBase.isMobTaskUrlPSDEFIdDirty() && (bl || pSSysMsgQueueBase.getMobTaskUrlPSDEFId() != null)) {
            iDataObject.set(FIELD_MOBTASKURLPSDEFID, (Object)pSSysMsgQueueBase.getMobTaskUrlPSDEFId());
        }
        if (pSSysMsgQueueBase.isMobTaskUrlPSDEFNameDirty() && (bl || pSSysMsgQueueBase.getMobTaskUrlPSDEFName() != null)) {
            iDataObject.set(FIELD_MOBTASKURLPSDEFNAME, (Object)pSSysMsgQueueBase.getMobTaskUrlPSDEFName());
        }
        if (pSSysMsgQueueBase.isMsgQueueParamsDirty() && (bl || pSSysMsgQueueBase.getMsgQueueParams() != null)) {
            iDataObject.set(FIELD_MSGQUEUEPARAMS, (Object)pSSysMsgQueueBase.getMsgQueueParams());
        }
        if (pSSysMsgQueueBase.isMsgQueueTagDirty() && (bl || pSSysMsgQueueBase.getMsgQueueTag() != null)) {
            iDataObject.set(FIELD_MSGQUEUETAG, (Object)pSSysMsgQueueBase.getMsgQueueTag());
        }
        if (pSSysMsgQueueBase.isMsgQueueTag2Dirty() && (bl || pSSysMsgQueueBase.getMsgQueueTag2() != null)) {
            iDataObject.set(FIELD_MSGQUEUETAG2, (Object)pSSysMsgQueueBase.getMsgQueueTag2());
        }
        if (pSSysMsgQueueBase.isMsgQueueTypeDirty() && (bl || pSSysMsgQueueBase.getMsgQueueType() != null)) {
            iDataObject.set(FIELD_MSGQUEUETYPE, (Object)pSSysMsgQueueBase.getMsgQueueType());
        }
        if (pSSysMsgQueueBase.isMsgTypePSDEFIdDirty() && (bl || pSSysMsgQueueBase.getMsgTypePSDEFId() != null)) {
            iDataObject.set(FIELD_MSGTYPEPSDEFID, (Object)pSSysMsgQueueBase.getMsgTypePSDEFId());
        }
        if (pSSysMsgQueueBase.isMsgTypePSDEFNameDirty() && (bl || pSSysMsgQueueBase.getMsgTypePSDEFName() != null)) {
            iDataObject.set(FIELD_MSGTYPEPSDEFNAME, (Object)pSSysMsgQueueBase.getMsgTypePSDEFName());
        }
        if (pSSysMsgQueueBase.isPSDEIdDirty() && (bl || pSSysMsgQueueBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSSysMsgQueueBase.getPSDEId());
        }
        if (pSSysMsgQueueBase.isPSDENameDirty() && (bl || pSSysMsgQueueBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSSysMsgQueueBase.getPSDEName());
        }
        if (pSSysMsgQueueBase.isPSModuleIdDirty() && (bl || pSSysMsgQueueBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSSysMsgQueueBase.getPSModuleId());
        }
        if (pSSysMsgQueueBase.isPSModuleNameDirty() && (bl || pSSysMsgQueueBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSSysMsgQueueBase.getPSModuleName());
        }
        if (pSSysMsgQueueBase.isPSSysDynaModelIdDirty() && (bl || pSSysMsgQueueBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSSysMsgQueueBase.getPSSysDynaModelId());
        }
        if (pSSysMsgQueueBase.isPSSysDynaModelNameDirty() && (bl || pSSysMsgQueueBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSSysMsgQueueBase.getPSSysDynaModelName());
        }
        if (pSSysMsgQueueBase.isPSSysMsgQueueIdDirty() && (bl || pSSysMsgQueueBase.getPSSysMsgQueueId() != null)) {
            iDataObject.set(FIELD_PSSYSMSGQUEUEID, (Object)pSSysMsgQueueBase.getPSSysMsgQueueId());
        }
        if (pSSysMsgQueueBase.isPSSysMsgQueueNameDirty() && (bl || pSSysMsgQueueBase.getPSSysMsgQueueName() != null)) {
            iDataObject.set(FIELD_PSSYSMSGQUEUENAME, (Object)pSSysMsgQueueBase.getPSSysMsgQueueName());
        }
        if (pSSysMsgQueueBase.isPSSysSFPluginIdDirty() && (bl || pSSysMsgQueueBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSSysMsgQueueBase.getPSSysSFPluginId());
        }
        if (pSSysMsgQueueBase.isPSSysSFPluginNameDirty() && (bl || pSSysMsgQueueBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSSysMsgQueueBase.getPSSysSFPluginName());
        }
        if (pSSysMsgQueueBase.isPSSystemIdDirty() && (bl || pSSysMsgQueueBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysMsgQueueBase.getPSSystemId());
        }
        if (pSSysMsgQueueBase.isPSSystemNameDirty() && (bl || pSSysMsgQueueBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysMsgQueueBase.getPSSystemName());
        }
        if (pSSysMsgQueueBase.isPSSysUtilDEIdDirty() && (bl || pSSysMsgQueueBase.getPSSysUtilDEId() != null)) {
            iDataObject.set(FIELD_PSSYSUTILDEID, (Object)pSSysMsgQueueBase.getPSSysUtilDEId());
        }
        if (pSSysMsgQueueBase.isPSSysUtilDENameDirty() && (bl || pSSysMsgQueueBase.getPSSysUtilDEName() != null)) {
            iDataObject.set(FIELD_PSSYSUTILDENAME, (Object)pSSysMsgQueueBase.getPSSysUtilDEName());
        }
        if (pSSysMsgQueueBase.isQueueParamsDirty() && (bl || pSSysMsgQueueBase.getQueueParams() != null)) {
            iDataObject.set(FIELD_QUEUEPARAMS, (Object)pSSysMsgQueueBase.getQueueParams());
        }
        if (pSSysMsgQueueBase.isSendTimePSDEFIdDirty() && (bl || pSSysMsgQueueBase.getSendTimePSDEFId() != null)) {
            iDataObject.set(FIELD_SENDTIMEPSDEFID, (Object)pSSysMsgQueueBase.getSendTimePSDEFId());
        }
        if (pSSysMsgQueueBase.isSendTimePSDEFNameDirty() && (bl || pSSysMsgQueueBase.getSendTimePSDEFName() != null)) {
            iDataObject.set(FIELD_SENDTIMEPSDEFNAME, (Object)pSSysMsgQueueBase.getSendTimePSDEFName());
        }
        if (pSSysMsgQueueBase.isSMSContentPSDEFIdDirty() && (bl || pSSysMsgQueueBase.getSMSContentPSDEFId() != null)) {
            iDataObject.set(FIELD_SMSCONTENTPSDEFID, (Object)pSSysMsgQueueBase.getSMSContentPSDEFId());
        }
        if (pSSysMsgQueueBase.isSMSContentPSDEFNameDirty() && (bl || pSSysMsgQueueBase.getSMSContentPSDEFName() != null)) {
            iDataObject.set(FIELD_SMSCONTENTPSDEFNAME, (Object)pSSysMsgQueueBase.getSMSContentPSDEFName());
        }
        if (pSSysMsgQueueBase.isStatePSDEFIdDirty() && (bl || pSSysMsgQueueBase.getStatePSDEFId() != null)) {
            iDataObject.set(FIELD_STATEPSDEFID, (Object)pSSysMsgQueueBase.getStatePSDEFId());
        }
        if (pSSysMsgQueueBase.isStatePSDEFNameDirty() && (bl || pSSysMsgQueueBase.getStatePSDEFName() != null)) {
            iDataObject.set(FIELD_STATEPSDEFNAME, (Object)pSSysMsgQueueBase.getStatePSDEFName());
        }
        if (pSSysMsgQueueBase.isTag2PSDEFIdDirty() && (bl || pSSysMsgQueueBase.getTag2PSDEFId() != null)) {
            iDataObject.set(FIELD_TAG2PSDEFID, (Object)pSSysMsgQueueBase.getTag2PSDEFId());
        }
        if (pSSysMsgQueueBase.isTag2PSDEFNameDirty() && (bl || pSSysMsgQueueBase.getTag2PSDEFName() != null)) {
            iDataObject.set(FIELD_TAG2PSDEFNAME, (Object)pSSysMsgQueueBase.getTag2PSDEFName());
        }
        if (pSSysMsgQueueBase.isTagPSDEFIdDirty() && (bl || pSSysMsgQueueBase.getTagPSDEFId() != null)) {
            iDataObject.set(FIELD_TAGPSDEFID, (Object)pSSysMsgQueueBase.getTagPSDEFId());
        }
        if (pSSysMsgQueueBase.isTagPSDEFNameDirty() && (bl || pSSysMsgQueueBase.getTagPSDEFName() != null)) {
            iDataObject.set(FIELD_TAGPSDEFNAME, (Object)pSSysMsgQueueBase.getTagPSDEFName());
        }
        if (pSSysMsgQueueBase.isTargetPSDEFIdDirty() && (bl || pSSysMsgQueueBase.getTargetPSDEFId() != null)) {
            iDataObject.set(FIELD_TARGETPSDEFID, (Object)pSSysMsgQueueBase.getTargetPSDEFId());
        }
        if (pSSysMsgQueueBase.isTargetPSDEFNameDirty() && (bl || pSSysMsgQueueBase.getTargetPSDEFName() != null)) {
            iDataObject.set(FIELD_TARGETPSDEFNAME, (Object)pSSysMsgQueueBase.getTargetPSDEFName());
        }
        if (pSSysMsgQueueBase.isTargetTypePSDEFIdDirty() && (bl || pSSysMsgQueueBase.getTargetTypePSDEFId() != null)) {
            iDataObject.set(FIELD_TARGETTYPEPSDEFID, (Object)pSSysMsgQueueBase.getTargetTypePSDEFId());
        }
        if (pSSysMsgQueueBase.isTargetTypePSDEFNameDirty() && (bl || pSSysMsgQueueBase.getTargetTypePSDEFName() != null)) {
            iDataObject.set(FIELD_TARGETTYPEPSDEFNAME, (Object)pSSysMsgQueueBase.getTargetTypePSDEFName());
        }
        if (pSSysMsgQueueBase.isTaskUrlPSDEFIdDirty() && (bl || pSSysMsgQueueBase.getTaskUrlPSDEFId() != null)) {
            iDataObject.set(FIELD_TASKURLPSDEFID, (Object)pSSysMsgQueueBase.getTaskUrlPSDEFId());
        }
        if (pSSysMsgQueueBase.isTaskUrlPSDEFNameDirty() && (bl || pSSysMsgQueueBase.getTaskUrlPSDEFName() != null)) {
            iDataObject.set(FIELD_TASKURLPSDEFNAME, (Object)pSSysMsgQueueBase.getTaskUrlPSDEFName());
        }
        if (pSSysMsgQueueBase.isTitlePSDEFIdDirty() && (bl || pSSysMsgQueueBase.getTitlePSDEFId() != null)) {
            iDataObject.set(FIELD_TITLEPSDEFID, (Object)pSSysMsgQueueBase.getTitlePSDEFId());
        }
        if (pSSysMsgQueueBase.isTitlePSDEFNameDirty() && (bl || pSSysMsgQueueBase.getTitlePSDEFName() != null)) {
            iDataObject.set(FIELD_TITLEPSDEFNAME, (Object)pSSysMsgQueueBase.getTitlePSDEFName());
        }
        if (pSSysMsgQueueBase.isUpdateDateDirty() && (bl || pSSysMsgQueueBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysMsgQueueBase.getUpdateDate());
        }
        if (pSSysMsgQueueBase.isUpdateManDirty() && (bl || pSSysMsgQueueBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysMsgQueueBase.getUpdateMan());
        }
        if (pSSysMsgQueueBase.isUser2PSDEFIdDirty() && (bl || pSSysMsgQueueBase.getUser2PSDEFId() != null)) {
            iDataObject.set(FIELD_USER2PSDEFID, (Object)pSSysMsgQueueBase.getUser2PSDEFId());
        }
        if (pSSysMsgQueueBase.isUser2PSDEFNameDirty() && (bl || pSSysMsgQueueBase.getUser2PSDEFName() != null)) {
            iDataObject.set(FIELD_USER2PSDEFNAME, (Object)pSSysMsgQueueBase.getUser2PSDEFName());
        }
        if (pSSysMsgQueueBase.isUserCatDirty() && (bl || pSSysMsgQueueBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysMsgQueueBase.getUserCat());
        }
        if (pSSysMsgQueueBase.isUserPSDEFIdDirty() && (bl || pSSysMsgQueueBase.getUserPSDEFId() != null)) {
            iDataObject.set(FIELD_USERPSDEFID, (Object)pSSysMsgQueueBase.getUserPSDEFId());
        }
        if (pSSysMsgQueueBase.isUserPSDEFNameDirty() && (bl || pSSysMsgQueueBase.getUserPSDEFName() != null)) {
            iDataObject.set(FIELD_USERPSDEFNAME, (Object)pSSysMsgQueueBase.getUserPSDEFName());
        }
        if (pSSysMsgQueueBase.isUserTagDirty() && (bl || pSSysMsgQueueBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysMsgQueueBase.getUserTag());
        }
        if (pSSysMsgQueueBase.isUserTag2Dirty() && (bl || pSSysMsgQueueBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysMsgQueueBase.getUserTag2());
        }
        if (pSSysMsgQueueBase.isUserTag3Dirty() && (bl || pSSysMsgQueueBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysMsgQueueBase.getUserTag3());
        }
        if (pSSysMsgQueueBase.isUserTag4Dirty() && (bl || pSSysMsgQueueBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysMsgQueueBase.getUserTag4());
        }
        if (pSSysMsgQueueBase.isValidFlagDirty() && (bl || pSSysMsgQueueBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysMsgQueueBase.getValidFlag());
        }
        if (pSSysMsgQueueBase.isWXContentPSDEFIdDirty() && (bl || pSSysMsgQueueBase.getWXContentPSDEFId() != null)) {
            iDataObject.set(FIELD_WXCONTENTPSDEFID, (Object)pSSysMsgQueueBase.getWXContentPSDEFId());
        }
        if (pSSysMsgQueueBase.isWXContentPSDEFNameDirty() && (bl || pSSysMsgQueueBase.getWXContentPSDEFName() != null)) {
            iDataObject.set(FIELD_WXCONTENTPSDEFNAME, (Object)pSSysMsgQueueBase.getWXContentPSDEFName());
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
        return PSSysMsgQueueBase.remove(this, n);
    }

    private static boolean remove(PSSysMsgQueueBase pSSysMsgQueueBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysMsgQueueBase.resetCodeName();
                return true;
            }
            case 1: {
                pSSysMsgQueueBase.resetContentPSDEFId();
                return true;
            }
            case 2: {
                pSSysMsgQueueBase.resetContentPSDEFName();
                return true;
            }
            case 3: {
                pSSysMsgQueueBase.resetContentTypePSDEFId();
                return true;
            }
            case 4: {
                pSSysMsgQueueBase.resetContentTypePSDEFName();
                return true;
            }
            case 5: {
                pSSysMsgQueueBase.resetCreateDate();
                return true;
            }
            case 6: {
                pSSysMsgQueueBase.resetCreateMan();
                return true;
            }
            case 7: {
                pSSysMsgQueueBase.resetCustomCode();
                return true;
            }
            case 8: {
                pSSysMsgQueueBase.resetCustomMode();
                return true;
            }
            case 9: {
                pSSysMsgQueueBase.resetDDContentPSDEFId();
                return true;
            }
            case 10: {
                pSSysMsgQueueBase.resetDDContentPSDEFName();
                return true;
            }
            case 11: {
                pSSysMsgQueueBase.resetFilePSDEFId();
                return true;
            }
            case 12: {
                pSSysMsgQueueBase.resetFilePSDEFName();
                return true;
            }
            case 13: {
                pSSysMsgQueueBase.resetIMContentPSDEFId();
                return true;
            }
            case 14: {
                pSSysMsgQueueBase.resetIMContentPSDEFName();
                return true;
            }
            case 15: {
                pSSysMsgQueueBase.resetMemo();
                return true;
            }
            case 16: {
                pSSysMsgQueueBase.resetMobTaskUrlPSDEFId();
                return true;
            }
            case 17: {
                pSSysMsgQueueBase.resetMobTaskUrlPSDEFName();
                return true;
            }
            case 18: {
                pSSysMsgQueueBase.resetMsgQueueParams();
                return true;
            }
            case 19: {
                pSSysMsgQueueBase.resetMsgQueueTag();
                return true;
            }
            case 20: {
                pSSysMsgQueueBase.resetMsgQueueTag2();
                return true;
            }
            case 21: {
                pSSysMsgQueueBase.resetMsgQueueType();
                return true;
            }
            case 22: {
                pSSysMsgQueueBase.resetMsgTypePSDEFId();
                return true;
            }
            case 23: {
                pSSysMsgQueueBase.resetMsgTypePSDEFName();
                return true;
            }
            case 24: {
                pSSysMsgQueueBase.resetPSDEId();
                return true;
            }
            case 25: {
                pSSysMsgQueueBase.resetPSDEName();
                return true;
            }
            case 26: {
                pSSysMsgQueueBase.resetPSModuleId();
                return true;
            }
            case 27: {
                pSSysMsgQueueBase.resetPSModuleName();
                return true;
            }
            case 28: {
                pSSysMsgQueueBase.resetPSSysDynaModelId();
                return true;
            }
            case 29: {
                pSSysMsgQueueBase.resetPSSysDynaModelName();
                return true;
            }
            case 30: {
                pSSysMsgQueueBase.resetPSSysMsgQueueId();
                return true;
            }
            case 31: {
                pSSysMsgQueueBase.resetPSSysMsgQueueName();
                return true;
            }
            case 32: {
                pSSysMsgQueueBase.resetPSSysSFPluginId();
                return true;
            }
            case 33: {
                pSSysMsgQueueBase.resetPSSysSFPluginName();
                return true;
            }
            case 34: {
                pSSysMsgQueueBase.resetPSSystemId();
                return true;
            }
            case 35: {
                pSSysMsgQueueBase.resetPSSystemName();
                return true;
            }
            case 36: {
                pSSysMsgQueueBase.resetPSSysUtilDEId();
                return true;
            }
            case 37: {
                pSSysMsgQueueBase.resetPSSysUtilDEName();
                return true;
            }
            case 38: {
                pSSysMsgQueueBase.resetQueueParams();
                return true;
            }
            case 39: {
                pSSysMsgQueueBase.resetSendTimePSDEFId();
                return true;
            }
            case 40: {
                pSSysMsgQueueBase.resetSendTimePSDEFName();
                return true;
            }
            case 41: {
                pSSysMsgQueueBase.resetSMSContentPSDEFId();
                return true;
            }
            case 42: {
                pSSysMsgQueueBase.resetSMSContentPSDEFName();
                return true;
            }
            case 43: {
                pSSysMsgQueueBase.resetStatePSDEFId();
                return true;
            }
            case 44: {
                pSSysMsgQueueBase.resetStatePSDEFName();
                return true;
            }
            case 45: {
                pSSysMsgQueueBase.resetTag2PSDEFId();
                return true;
            }
            case 46: {
                pSSysMsgQueueBase.resetTag2PSDEFName();
                return true;
            }
            case 47: {
                pSSysMsgQueueBase.resetTagPSDEFId();
                return true;
            }
            case 48: {
                pSSysMsgQueueBase.resetTagPSDEFName();
                return true;
            }
            case 49: {
                pSSysMsgQueueBase.resetTargetPSDEFId();
                return true;
            }
            case 50: {
                pSSysMsgQueueBase.resetTargetPSDEFName();
                return true;
            }
            case 51: {
                pSSysMsgQueueBase.resetTargetTypePSDEFId();
                return true;
            }
            case 52: {
                pSSysMsgQueueBase.resetTargetTypePSDEFName();
                return true;
            }
            case 53: {
                pSSysMsgQueueBase.resetTaskUrlPSDEFId();
                return true;
            }
            case 54: {
                pSSysMsgQueueBase.resetTaskUrlPSDEFName();
                return true;
            }
            case 55: {
                pSSysMsgQueueBase.resetTitlePSDEFId();
                return true;
            }
            case 56: {
                pSSysMsgQueueBase.resetTitlePSDEFName();
                return true;
            }
            case 57: {
                pSSysMsgQueueBase.resetUpdateDate();
                return true;
            }
            case 58: {
                pSSysMsgQueueBase.resetUpdateMan();
                return true;
            }
            case 59: {
                pSSysMsgQueueBase.resetUser2PSDEFId();
                return true;
            }
            case 60: {
                pSSysMsgQueueBase.resetUser2PSDEFName();
                return true;
            }
            case 61: {
                pSSysMsgQueueBase.resetUserCat();
                return true;
            }
            case 62: {
                pSSysMsgQueueBase.resetUserPSDEFId();
                return true;
            }
            case 63: {
                pSSysMsgQueueBase.resetUserPSDEFName();
                return true;
            }
            case 64: {
                pSSysMsgQueueBase.resetUserTag();
                return true;
            }
            case 65: {
                pSSysMsgQueueBase.resetUserTag2();
                return true;
            }
            case 66: {
                pSSysMsgQueueBase.resetUserTag3();
                return true;
            }
            case 67: {
                pSSysMsgQueueBase.resetUserTag4();
                return true;
            }
            case 68: {
                pSSysMsgQueueBase.resetValidFlag();
                return true;
            }
            case 69: {
                pSSysMsgQueueBase.resetWXContentPSDEFId();
                return true;
            }
            case 70: {
                pSSysMsgQueueBase.resetWXContentPSDEFName();
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
    public PSDEField getContentPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContentPSDEF();
        }
        if (this.getContentPSDEFId() == null) {
            return null;
        }
        Integer n = this.objContentPSDEFLock;
        synchronized (n) {
            if (this.contentpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getContentPSDEFId(), (Object)this.contentpsdef.getPSDEFieldId()) != 0L) {
                this.contentpsdef = null;
            }
            if (this.contentpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getContentPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.contentpsdef = pSDEField;
            }
            return this.contentpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getContentTypePSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContentTypePSDEF();
        }
        if (this.getContentTypePSDEFId() == null) {
            return null;
        }
        Integer n = this.objContentTypePSDEFLock;
        synchronized (n) {
            if (this.contenttypepsdef != null && DataTypeHelper.compare((int)25, (Object)this.getContentTypePSDEFId(), (Object)this.contenttypepsdef.getPSDEFieldId()) != 0L) {
                this.contenttypepsdef = null;
            }
            if (this.contenttypepsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getContentTypePSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.contenttypepsdef = pSDEField;
            }
            return this.contenttypepsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getDDContentPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDDContentPSDEF();
        }
        if (this.getDDContentPSDEFId() == null) {
            return null;
        }
        Integer n = this.objDDContentPSDEFLock;
        synchronized (n) {
            if (this.ddcontentpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getDDContentPSDEFId(), (Object)this.ddcontentpsdef.getPSDEFieldId()) != 0L) {
                this.ddcontentpsdef = null;
            }
            if (this.ddcontentpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getDDContentPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.ddcontentpsdef = pSDEField;
            }
            return this.ddcontentpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getFilePSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFilePSDEF();
        }
        if (this.getFilePSDEFId() == null) {
            return null;
        }
        Integer n = this.objFilePSDEFLock;
        synchronized (n) {
            if (this.filepsdef != null && DataTypeHelper.compare((int)25, (Object)this.getFilePSDEFId(), (Object)this.filepsdef.getPSDEFieldId()) != 0L) {
                this.filepsdef = null;
            }
            if (this.filepsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getFilePSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.filepsdef = pSDEField;
            }
            return this.filepsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getIMContentPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIMContentPSDEF();
        }
        if (this.getIMContentPSDEFId() == null) {
            return null;
        }
        Integer n = this.objIMContentPSDEFLock;
        synchronized (n) {
            if (this.imcontentpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getIMContentPSDEFId(), (Object)this.imcontentpsdef.getPSDEFieldId()) != 0L) {
                this.imcontentpsdef = null;
            }
            if (this.imcontentpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getIMContentPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.imcontentpsdef = pSDEField;
            }
            return this.imcontentpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getMobTaskUrlPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobTaskUrlPSDEF();
        }
        if (this.getMobTaskUrlPSDEFId() == null) {
            return null;
        }
        Integer n = this.objMobTaskUrlPSDEFLock;
        synchronized (n) {
            if (this.mobtaskurlpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getMobTaskUrlPSDEFId(), (Object)this.mobtaskurlpsdef.getPSDEFieldId()) != 0L) {
                this.mobtaskurlpsdef = null;
            }
            if (this.mobtaskurlpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getMobTaskUrlPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.mobtaskurlpsdef = pSDEField;
            }
            return this.mobtaskurlpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getMsgTypePSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMsgTypePSDEF();
        }
        if (this.getMsgTypePSDEFId() == null) {
            return null;
        }
        Integer n = this.objMsgTypePSDEFLock;
        synchronized (n) {
            if (this.msgtypepsdef != null && DataTypeHelper.compare((int)25, (Object)this.getMsgTypePSDEFId(), (Object)this.msgtypepsdef.getPSDEFieldId()) != 0L) {
                this.msgtypepsdef = null;
            }
            if (this.msgtypepsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getMsgTypePSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.msgtypepsdef = pSDEField;
            }
            return this.msgtypepsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getSendTimePSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSendTimePSDEF();
        }
        if (this.getSendTimePSDEFId() == null) {
            return null;
        }
        Integer n = this.objSendTimePSDEFLock;
        synchronized (n) {
            if (this.sendtimepsdef != null && DataTypeHelper.compare((int)25, (Object)this.getSendTimePSDEFId(), (Object)this.sendtimepsdef.getPSDEFieldId()) != 0L) {
                this.sendtimepsdef = null;
            }
            if (this.sendtimepsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getSendTimePSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.sendtimepsdef = pSDEField;
            }
            return this.sendtimepsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getSMSContentPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSMSContentPSDEF();
        }
        if (this.getSMSContentPSDEFId() == null) {
            return null;
        }
        Integer n = this.objSMSContentPSDEFLock;
        synchronized (n) {
            if (this.smscontentpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getSMSContentPSDEFId(), (Object)this.smscontentpsdef.getPSDEFieldId()) != 0L) {
                this.smscontentpsdef = null;
            }
            if (this.smscontentpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getSMSContentPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.smscontentpsdef = pSDEField;
            }
            return this.smscontentpsdef;
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
    public PSDEField getTagPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTagPSDEF();
        }
        if (this.getTag2PSDEFId() == null) {
            return null;
        }
        Integer n = this.objTagPSDEFLock;
        synchronized (n) {
            if (this.tagpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getTag2PSDEFId(), (Object)this.tagpsdef.getPSDEFieldId()) != 0L) {
                this.tagpsdef = null;
            }
            if (this.tagpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getTag2PSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.tagpsdef = pSDEField;
            }
            return this.tagpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getTag2PSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTag2PSDEF();
        }
        if (this.getTagPSDEFId() == null) {
            return null;
        }
        Integer n = this.objTag2PSDEFLock;
        synchronized (n) {
            if (this.tag2psdef != null && DataTypeHelper.compare((int)25, (Object)this.getTagPSDEFId(), (Object)this.tag2psdef.getPSDEFieldId()) != 0L) {
                this.tag2psdef = null;
            }
            if (this.tag2psdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getTagPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.tag2psdef = pSDEField;
            }
            return this.tag2psdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getTargetPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTargetPSDEF();
        }
        if (this.getTargetPSDEFId() == null) {
            return null;
        }
        Integer n = this.objTargetPSDEFLock;
        synchronized (n) {
            if (this.targetpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getTargetPSDEFId(), (Object)this.targetpsdef.getPSDEFieldId()) != 0L) {
                this.targetpsdef = null;
            }
            if (this.targetpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getTargetPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.targetpsdef = pSDEField;
            }
            return this.targetpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getTargetTypePSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTargetTypePSDEF();
        }
        if (this.getTargetTypePSDEFId() == null) {
            return null;
        }
        Integer n = this.objTargetTypePSDEFLock;
        synchronized (n) {
            if (this.targettypepsdef != null && DataTypeHelper.compare((int)25, (Object)this.getTargetTypePSDEFId(), (Object)this.targettypepsdef.getPSDEFieldId()) != 0L) {
                this.targettypepsdef = null;
            }
            if (this.targettypepsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getTargetTypePSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.targettypepsdef = pSDEField;
            }
            return this.targettypepsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getTaskUrlPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTaskUrlPSDEF();
        }
        if (this.getTaskUrlPSDEFId() == null) {
            return null;
        }
        Integer n = this.objTaskUrlPSDEFLock;
        synchronized (n) {
            if (this.taskurlpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getTaskUrlPSDEFId(), (Object)this.taskurlpsdef.getPSDEFieldId()) != 0L) {
                this.taskurlpsdef = null;
            }
            if (this.taskurlpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getTaskUrlPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.taskurlpsdef = pSDEField;
            }
            return this.taskurlpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getTitlePSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTitlePSDEF();
        }
        if (this.getTitlePSDEFId() == null) {
            return null;
        }
        Integer n = this.objTitlePSDEFLock;
        synchronized (n) {
            if (this.titlepsdef != null && DataTypeHelper.compare((int)25, (Object)this.getTitlePSDEFId(), (Object)this.titlepsdef.getPSDEFieldId()) != 0L) {
                this.titlepsdef = null;
            }
            if (this.titlepsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getTitlePSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.titlepsdef = pSDEField;
            }
            return this.titlepsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getUser2PSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUser2PSDEF();
        }
        if (this.getUser2PSDEFId() == null) {
            return null;
        }
        Integer n = this.objUser2PSDEFLock;
        synchronized (n) {
            if (this.user2psdef != null && DataTypeHelper.compare((int)25, (Object)this.getUser2PSDEFId(), (Object)this.user2psdef.getPSDEFieldId()) != 0L) {
                this.user2psdef = null;
            }
            if (this.user2psdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getUser2PSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.user2psdef = pSDEField;
            }
            return this.user2psdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getUserPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserPSDEF();
        }
        if (this.getUserPSDEFId() == null) {
            return null;
        }
        Integer n = this.objUserPSDEFLock;
        synchronized (n) {
            if (this.userpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getUserPSDEFId(), (Object)this.userpsdef.getPSDEFieldId()) != 0L) {
                this.userpsdef = null;
            }
            if (this.userpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getUserPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.userpsdef = pSDEField;
            }
            return this.userpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getWXContentPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWXContentPSDEF();
        }
        if (this.getWXContentPSDEFId() == null) {
            return null;
        }
        Integer n = this.objWXContentPSDEFLock;
        synchronized (n) {
            if (this.wxcontentpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getWXContentPSDEFId(), (Object)this.wxcontentpsdef.getPSDEFieldId()) != 0L) {
                this.wxcontentpsdef = null;
            }
            if (this.wxcontentpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getWXContentPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.wxcontentpsdef = pSDEField;
            }
            return this.wxcontentpsdef;
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

    private PSSysMsgQueueBase getProxyEntity() {
        return this.proxyPSSysMsgQueueBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysMsgQueueBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysMsgQueueBase) {
            this.proxyPSSysMsgQueueBase = (PSSysMsgQueueBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysMsgQueueService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CONTENTPSDEFID, 1);
        fieldIndexMap.put(FIELD_CONTENTPSDEFNAME, 2);
        fieldIndexMap.put(FIELD_CONTENTTYPEPSDEFID, 3);
        fieldIndexMap.put(FIELD_CONTENTTYPEPSDEFNAME, 4);
        fieldIndexMap.put(FIELD_CREATEDATE, 5);
        fieldIndexMap.put(FIELD_CREATEMAN, 6);
        fieldIndexMap.put(FIELD_CUSTOMCODE, 7);
        fieldIndexMap.put(FIELD_CUSTOMMODE, 8);
        fieldIndexMap.put(FIELD_DDCONTENTPSDEFID, 9);
        fieldIndexMap.put(FIELD_DDCONTENTPSDEFNAME, 10);
        fieldIndexMap.put(FIELD_FILEPSDEFID, 11);
        fieldIndexMap.put(FIELD_FILEPSDEFNAME, 12);
        fieldIndexMap.put(FIELD_IMCONTENTPSDEFID, 13);
        fieldIndexMap.put(FIELD_IMCONTENTPSDEFNAME, 14);
        fieldIndexMap.put(FIELD_MEMO, 15);
        fieldIndexMap.put(FIELD_MOBTASKURLPSDEFID, 16);
        fieldIndexMap.put(FIELD_MOBTASKURLPSDEFNAME, 17);
        fieldIndexMap.put(FIELD_MSGQUEUEPARAMS, 18);
        fieldIndexMap.put(FIELD_MSGQUEUETAG, 19);
        fieldIndexMap.put(FIELD_MSGQUEUETAG2, 20);
        fieldIndexMap.put(FIELD_MSGQUEUETYPE, 21);
        fieldIndexMap.put(FIELD_MSGTYPEPSDEFID, 22);
        fieldIndexMap.put(FIELD_MSGTYPEPSDEFNAME, 23);
        fieldIndexMap.put(FIELD_PSDEID, 24);
        fieldIndexMap.put(FIELD_PSDENAME, 25);
        fieldIndexMap.put(FIELD_PSMODULEID, 26);
        fieldIndexMap.put(FIELD_PSMODULENAME, 27);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 28);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 29);
        fieldIndexMap.put(FIELD_PSSYSMSGQUEUEID, 30);
        fieldIndexMap.put(FIELD_PSSYSMSGQUEUENAME, 31);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 32);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 33);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 34);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 35);
        fieldIndexMap.put(FIELD_PSSYSUTILDEID, 36);
        fieldIndexMap.put(FIELD_PSSYSUTILDENAME, 37);
        fieldIndexMap.put(FIELD_QUEUEPARAMS, 38);
        fieldIndexMap.put(FIELD_SENDTIMEPSDEFID, 39);
        fieldIndexMap.put(FIELD_SENDTIMEPSDEFNAME, 40);
        fieldIndexMap.put(FIELD_SMSCONTENTPSDEFID, 41);
        fieldIndexMap.put(FIELD_SMSCONTENTPSDEFNAME, 42);
        fieldIndexMap.put(FIELD_STATEPSDEFID, 43);
        fieldIndexMap.put(FIELD_STATEPSDEFNAME, 44);
        fieldIndexMap.put(FIELD_TAG2PSDEFID, 45);
        fieldIndexMap.put(FIELD_TAG2PSDEFNAME, 46);
        fieldIndexMap.put(FIELD_TAGPSDEFID, 47);
        fieldIndexMap.put(FIELD_TAGPSDEFNAME, 48);
        fieldIndexMap.put(FIELD_TARGETPSDEFID, 49);
        fieldIndexMap.put(FIELD_TARGETPSDEFNAME, 50);
        fieldIndexMap.put(FIELD_TARGETTYPEPSDEFID, 51);
        fieldIndexMap.put(FIELD_TARGETTYPEPSDEFNAME, 52);
        fieldIndexMap.put(FIELD_TASKURLPSDEFID, 53);
        fieldIndexMap.put(FIELD_TASKURLPSDEFNAME, 54);
        fieldIndexMap.put(FIELD_TITLEPSDEFID, 55);
        fieldIndexMap.put(FIELD_TITLEPSDEFNAME, 56);
        fieldIndexMap.put(FIELD_UPDATEDATE, 57);
        fieldIndexMap.put(FIELD_UPDATEMAN, 58);
        fieldIndexMap.put(FIELD_USER2PSDEFID, 59);
        fieldIndexMap.put(FIELD_USER2PSDEFNAME, 60);
        fieldIndexMap.put(FIELD_USERCAT, 61);
        fieldIndexMap.put(FIELD_USERPSDEFID, 62);
        fieldIndexMap.put(FIELD_USERPSDEFNAME, 63);
        fieldIndexMap.put(FIELD_USERTAG, 64);
        fieldIndexMap.put(FIELD_USERTAG2, 65);
        fieldIndexMap.put(FIELD_USERTAG3, 66);
        fieldIndexMap.put(FIELD_USERTAG4, 67);
        fieldIndexMap.put(FIELD_VALIDFLAG, 68);
        fieldIndexMap.put(FIELD_WXCONTENTPSDEFID, 69);
        fieldIndexMap.put(FIELD_WXCONTENTPSDEFNAME, 70);
    }
}

