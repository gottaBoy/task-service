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
package net.ibizsys.pscore.srv.sysdevstudio.entity;

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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServer;
import net.ibizsys.pscore.srv.paasmgr.service.PSTaskServerService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDevSlnSysBakLink;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysBakLinkService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnSysBakBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevSlnSysBakBase.class);
    public static final String FIELD_ACCESSTOKEN = "ACCESSTOKEN";
    public static final String FIELD_BACKUPFILEPATH = "BACKUPFILEPATH";
    public static final String FIELD_BACKUPSIZE = "BACKUPSIZE";
    public static final String FIELD_BACKUPSTATE = "BACKUPSTATE";
    public static final String FIELD_BACKUPTIME = "BACKUPTIME";
    public static final String FIELD_BEGINBACKUPTIME = "BEGINBACKUPTIME";
    public static final String FIELD_BACKUPMODE = "BKMODE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ENABLELINK = "ENABLELINK";
    public static final String FIELD_ENDBACKUPTIME = "ENDBACKUPTIME";
    public static final String FIELD_LINKCODE = "LINKCODE";
    public static final String FIELD_LINKFLAG = "LINKFLAG";
    public static final String FIELD_LINKREPMSG = "LINKREPMSG";
    public static final String FIELD_LINKREQMSG = "LINKREQMSG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MODELVER = "MODELVER";
    public static final String FIELD_OFFLINEFLAG = "OFFLINEFLAG";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSDEVSLNID = "PSDEVSLNID";
    public static final String FIELD_PSDEVSLNSYSBAKID = "PSDEVSLNSYSBAKID";
    public static final String FIELD_PSDEVSLNSYSBAKNAME = "PSDEVSLNSYSBAKNAME";
    public static final String FIELD_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String FIELD_PSDEVSLNSYSNAME = "PSDEVSLNSYSNAME";
    public static final String FIELD_PSSYSMODELINSTID = "PSSYSMODELINSTID";
    public static final String FIELD_PSTASKSERVERID = "PSTASKSERVERID";
    public static final String FIELD_PSTASKSERVERNAME = "PSTASKSERVERNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_ACCESSTOKEN = 0;
    private static final int INDEX_BACKUPFILEPATH = 1;
    private static final int INDEX_BACKUPSIZE = 2;
    private static final int INDEX_BACKUPSTATE = 3;
    private static final int INDEX_BACKUPTIME = 4;
    private static final int INDEX_BEGINBACKUPTIME = 5;
    private static final int INDEX_BACKUPMODE = 6;
    private static final int INDEX_CREATEDATE = 7;
    private static final int INDEX_CREATEMAN = 8;
    private static final int INDEX_ENABLELINK = 9;
    private static final int INDEX_ENDBACKUPTIME = 10;
    private static final int INDEX_LINKCODE = 11;
    private static final int INDEX_LINKFLAG = 12;
    private static final int INDEX_LINKREPMSG = 13;
    private static final int INDEX_LINKREQMSG = 14;
    private static final int INDEX_MEMO = 15;
    private static final int INDEX_MODELVER = 16;
    private static final int INDEX_OFFLINEFLAG = 17;
    private static final int INDEX_PSDEVCENTERID = 18;
    private static final int INDEX_PSDEVCENTERNAME = 19;
    private static final int INDEX_PSDEVSLNID = 20;
    private static final int INDEX_PSDEVSLNSYSBAKID = 21;
    private static final int INDEX_PSDEVSLNSYSBAKNAME = 22;
    private static final int INDEX_PSDEVSLNSYSID = 23;
    private static final int INDEX_PSDEVSLNSYSNAME = 24;
    private static final int INDEX_PSSYSMODELINSTID = 25;
    private static final int INDEX_PSTASKSERVERID = 26;
    private static final int INDEX_PSTASKSERVERNAME = 27;
    private static final int INDEX_UPDATEDATE = 28;
    private static final int INDEX_UPDATEMAN = 29;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevSlnSysBakBase proxyPSDevSlnSysBakBase = null;
    private boolean accesstokenDirtyFlag = false;
    private boolean backupfilepathDirtyFlag = false;
    private boolean backupsizeDirtyFlag = false;
    private boolean backupstateDirtyFlag = false;
    private boolean backuptimeDirtyFlag = false;
    private boolean beginbackuptimeDirtyFlag = false;
    private boolean backupmodeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean enablelinkDirtyFlag = false;
    private boolean endbackuptimeDirtyFlag = false;
    private boolean linkcodeDirtyFlag = false;
    private boolean linkflagDirtyFlag = false;
    private boolean linkrepmsgDirtyFlag = false;
    private boolean linkreqmsgDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean modelverDirtyFlag = false;
    private boolean offlineflagDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psdevslnidDirtyFlag = false;
    private boolean psdevslnsysbakidDirtyFlag = false;
    private boolean psdevslnsysbaknameDirtyFlag = false;
    private boolean psdevslnsysidDirtyFlag = false;
    private boolean psdevslnsysnameDirtyFlag = false;
    private boolean pssysmodelinstidDirtyFlag = false;
    private boolean pstaskserveridDirtyFlag = false;
    private boolean pstaskservernameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="accesstoken")
    private String accesstoken;
    @Column(name="backupfilepath")
    private String backupfilepath;
    @Column(name="backupsize")
    private Integer backupsize;
    @Column(name="backupstate")
    private Integer backupstate;
    @Column(name="backuptime")
    private Timestamp backuptime;
    @Column(name="beginbackuptime")
    private Timestamp beginbackuptime;
    @Column(name="backupmode")
    private String backupmode;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="enablelink")
    private Integer enablelink;
    @Column(name="endbackuptime")
    private Timestamp endbackuptime;
    @Column(name="linkcode")
    private String linkcode;
    @Column(name="linkflag")
    private Integer linkflag;
    @Column(name="linkrepmsg")
    private String linkrepmsg;
    @Column(name="linkreqmsg")
    private String linkreqmsg;
    @Column(name="memo")
    private String memo;
    @Column(name="modelver")
    private Integer modelver;
    @Column(name="offlineflag")
    private Integer offlineflag;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="psdevslnid")
    private String psdevslnid;
    @Column(name="psdevslnsysbakid")
    private String psdevslnsysbakid;
    @Column(name="psdevslnsysbakname")
    private String psdevslnsysbakname;
    @Column(name="psdevslnsysid")
    private String psdevslnsysid;
    @Column(name="psdevslnsysname")
    private String psdevslnsysname;
    @Column(name="pssysmodelinstid")
    private String pssysmodelinstid;
    @Column(name="pstaskserverid")
    private String pstaskserverid;
    @Column(name="pstaskservername")
    private String pstaskservername;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objPSDevSlnSysLock = new Integer(1);
    private PSDevSlnSys psdevslnsys = null;
    private Integer objPSTaskServerLock = new Integer(1);
    private PSTaskServer pstaskserver = null;
    private Integer objPSDevSlnSysBakLinksLock = new Integer(1);
    private ArrayList<PSDevSlnSysBakLink> psdevslnsysbaklinks = null;

    public void setAccessToken(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAccessToken(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.accesstoken = string;
        this.accesstokenDirtyFlag = true;
    }

    public String getAccessToken() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAccessToken();
        }
        return this.accesstoken;
    }

    public boolean isAccessTokenDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAccessTokenDirty();
        }
        return this.accesstokenDirtyFlag;
    }

    public void resetAccessToken() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAccessToken();
            return;
        }
        this.accesstokenDirtyFlag = false;
        this.accesstoken = null;
    }

    public void setBackupFilePath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBackupFilePath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.backupfilepath = string;
        this.backupfilepathDirtyFlag = true;
    }

    public String getBackupFilePath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBackupFilePath();
        }
        return this.backupfilepath;
    }

    public boolean isBackupFilePathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBackupFilePathDirty();
        }
        return this.backupfilepathDirtyFlag;
    }

    public void resetBackupFilePath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBackupFilePath();
            return;
        }
        this.backupfilepathDirtyFlag = false;
        this.backupfilepath = null;
    }

    public void setBackupSize(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBackupSize(n);
            return;
        }
        this.backupsize = n;
        this.backupsizeDirtyFlag = true;
    }

    public Integer getBackupSize() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBackupSize();
        }
        return this.backupsize;
    }

    public boolean isBackupSizeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBackupSizeDirty();
        }
        return this.backupsizeDirtyFlag;
    }

    public void resetBackupSize() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBackupSize();
            return;
        }
        this.backupsizeDirtyFlag = false;
        this.backupsize = null;
    }

    public void setBackupState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBackupState(n);
            return;
        }
        this.backupstate = n;
        this.backupstateDirtyFlag = true;
    }

    public Integer getBackupState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBackupState();
        }
        return this.backupstate;
    }

    public boolean isBackupStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBackupStateDirty();
        }
        return this.backupstateDirtyFlag;
    }

    public void resetBackupState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBackupState();
            return;
        }
        this.backupstateDirtyFlag = false;
        this.backupstate = null;
    }

    public void setBackupTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBackupTime(timestamp);
            return;
        }
        this.backuptime = timestamp;
        this.backuptimeDirtyFlag = true;
    }

    public Timestamp getBackupTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBackupTime();
        }
        return this.backuptime;
    }

    public boolean isBackupTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBackupTimeDirty();
        }
        return this.backuptimeDirtyFlag;
    }

    public void resetBackupTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBackupTime();
            return;
        }
        this.backuptimeDirtyFlag = false;
        this.backuptime = null;
    }

    public void setBeginBackupTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBeginBackupTime(timestamp);
            return;
        }
        this.beginbackuptime = timestamp;
        this.beginbackuptimeDirtyFlag = true;
    }

    public Timestamp getBeginBackupTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBeginBackupTime();
        }
        return this.beginbackuptime;
    }

    public boolean isBeginBackupTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBeginBackupTimeDirty();
        }
        return this.beginbackuptimeDirtyFlag;
    }

    public void resetBeginBackupTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBeginBackupTime();
            return;
        }
        this.beginbackuptimeDirtyFlag = false;
        this.beginbackuptime = null;
    }

    public void setBackupMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBackupMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.backupmode = string;
        this.backupmodeDirtyFlag = true;
    }

    public String getBackupMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBackupMode();
        }
        return this.backupmode;
    }

    public boolean isBackupModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBackupModeDirty();
        }
        return this.backupmodeDirtyFlag;
    }

    public void resetBackupMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBackupMode();
            return;
        }
        this.backupmodeDirtyFlag = false;
        this.backupmode = null;
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

    public void setEnableLink(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableLink(n);
            return;
        }
        this.enablelink = n;
        this.enablelinkDirtyFlag = true;
    }

    public Integer getEnableLink() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableLink();
        }
        return this.enablelink;
    }

    public boolean isEnableLinkDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableLinkDirty();
        }
        return this.enablelinkDirtyFlag;
    }

    public void resetEnableLink() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableLink();
            return;
        }
        this.enablelinkDirtyFlag = false;
        this.enablelink = null;
    }

    public void setEndBackupTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEndBackupTime(timestamp);
            return;
        }
        this.endbackuptime = timestamp;
        this.endbackuptimeDirtyFlag = true;
    }

    public Timestamp getEndBackupTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEndBackupTime();
        }
        return this.endbackuptime;
    }

    public boolean isEndBackupTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEndBackupTimeDirty();
        }
        return this.endbackuptimeDirtyFlag;
    }

    public void resetEndBackupTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEndBackupTime();
            return;
        }
        this.endbackuptimeDirtyFlag = false;
        this.endbackuptime = null;
    }

    public void setLinkCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLinkCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.linkcode = string;
        this.linkcodeDirtyFlag = true;
    }

    public String getLinkCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLinkCode();
        }
        return this.linkcode;
    }

    public boolean isLinkCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLinkCodeDirty();
        }
        return this.linkcodeDirtyFlag;
    }

    public void resetLinkCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLinkCode();
            return;
        }
        this.linkcodeDirtyFlag = false;
        this.linkcode = null;
    }

    public void setLinkFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLinkFlag(n);
            return;
        }
        this.linkflag = n;
        this.linkflagDirtyFlag = true;
    }

    public Integer getLinkFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLinkFlag();
        }
        return this.linkflag;
    }

    public boolean isLinkFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLinkFlagDirty();
        }
        return this.linkflagDirtyFlag;
    }

    public void resetLinkFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLinkFlag();
            return;
        }
        this.linkflagDirtyFlag = false;
        this.linkflag = null;
    }

    public void setLinkRepMsg(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLinkRepMsg(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.linkrepmsg = string;
        this.linkrepmsgDirtyFlag = true;
    }

    public String getLinkRepMsg() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLinkRepMsg();
        }
        return this.linkrepmsg;
    }

    public boolean isLinkRepMsgDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLinkRepMsgDirty();
        }
        return this.linkrepmsgDirtyFlag;
    }

    public void resetLinkRepMsg() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLinkRepMsg();
            return;
        }
        this.linkrepmsgDirtyFlag = false;
        this.linkrepmsg = null;
    }

    public void setLinkReqMsg(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLinkReqMsg(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.linkreqmsg = string;
        this.linkreqmsgDirtyFlag = true;
    }

    public String getLinkReqMsg() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLinkReqMsg();
        }
        return this.linkreqmsg;
    }

    public boolean isLinkReqMsgDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLinkReqMsgDirty();
        }
        return this.linkreqmsgDirtyFlag;
    }

    public void resetLinkReqMsg() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLinkReqMsg();
            return;
        }
        this.linkreqmsgDirtyFlag = false;
        this.linkreqmsg = null;
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

    public void setModelVer(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelVer(n);
            return;
        }
        this.modelver = n;
        this.modelverDirtyFlag = true;
    }

    public Integer getModelVer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelVer();
        }
        return this.modelver;
    }

    public boolean isModelVerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelVerDirty();
        }
        return this.modelverDirtyFlag;
    }

    public void resetModelVer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelVer();
            return;
        }
        this.modelverDirtyFlag = false;
        this.modelver = null;
    }

    public void setOfflineFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOfflineFlag(n);
            return;
        }
        this.offlineflag = n;
        this.offlineflagDirtyFlag = true;
    }

    public Integer getOfflineFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOfflineFlag();
        }
        return this.offlineflag;
    }

    public boolean isOfflineFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOfflineFlagDirty();
        }
        return this.offlineflagDirtyFlag;
    }

    public void resetOfflineFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOfflineFlag();
            return;
        }
        this.offlineflagDirtyFlag = false;
        this.offlineflag = null;
    }

    public void setPSDevCenterId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterid = string;
        this.psdevcenteridDirtyFlag = true;
    }

    public String getPSDevCenterId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterId();
        }
        return this.psdevcenterid;
    }

    public boolean isPSDevCenterIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterIdDirty();
        }
        return this.psdevcenteridDirtyFlag;
    }

    public void resetPSDevCenterId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterId();
            return;
        }
        this.psdevcenteridDirtyFlag = false;
        this.psdevcenterid = null;
    }

    public void setPSDevCenterName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcentername = string;
        this.psdevcenternameDirtyFlag = true;
    }

    public String getPSDevCenterName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterName();
        }
        return this.psdevcentername;
    }

    public boolean isPSDevCenterNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterNameDirty();
        }
        return this.psdevcenternameDirtyFlag;
    }

    public void resetPSDevCenterName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterName();
            return;
        }
        this.psdevcenternameDirtyFlag = false;
        this.psdevcentername = null;
    }

    public void setPSDevSlnId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnid = string;
        this.psdevslnidDirtyFlag = true;
    }

    public String getPSDevSlnId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnId();
        }
        return this.psdevslnid;
    }

    public boolean isPSDevSlnIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnIdDirty();
        }
        return this.psdevslnidDirtyFlag;
    }

    public void resetPSDevSlnId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnId();
            return;
        }
        this.psdevslnidDirtyFlag = false;
        this.psdevslnid = null;
    }

    public void setPSDevSlnSysBakId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysBakId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysbakid = string;
        this.psdevslnsysbakidDirtyFlag = true;
    }

    public String getPSDevSlnSysBakId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysBakId();
        }
        return this.psdevslnsysbakid;
    }

    public boolean isPSDevSlnSysBakIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysBakIdDirty();
        }
        return this.psdevslnsysbakidDirtyFlag;
    }

    public void resetPSDevSlnSysBakId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysBakId();
            return;
        }
        this.psdevslnsysbakidDirtyFlag = false;
        this.psdevslnsysbakid = null;
    }

    public void setPSDevSlnSysBakName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysBakName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysbakname = string;
        this.psdevslnsysbaknameDirtyFlag = true;
    }

    public String getPSDevSlnSysBakName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysBakName();
        }
        return this.psdevslnsysbakname;
    }

    public boolean isPSDevSlnSysBakNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysBakNameDirty();
        }
        return this.psdevslnsysbaknameDirtyFlag;
    }

    public void resetPSDevSlnSysBakName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysBakName();
            return;
        }
        this.psdevslnsysbaknameDirtyFlag = false;
        this.psdevslnsysbakname = null;
    }

    public void setPSDevSlnSysId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysid = string;
        this.psdevslnsysidDirtyFlag = true;
    }

    public String getPSDevSlnSysId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysId();
        }
        return this.psdevslnsysid;
    }

    public boolean isPSDevSlnSysIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysIdDirty();
        }
        return this.psdevslnsysidDirtyFlag;
    }

    public void resetPSDevSlnSysId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysId();
            return;
        }
        this.psdevslnsysidDirtyFlag = false;
        this.psdevslnsysid = null;
    }

    public void setPSDevSlnSysName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysname = string;
        this.psdevslnsysnameDirtyFlag = true;
    }

    public String getPSDevSlnSysName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysName();
        }
        return this.psdevslnsysname;
    }

    public boolean isPSDevSlnSysNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysNameDirty();
        }
        return this.psdevslnsysnameDirtyFlag;
    }

    public void resetPSDevSlnSysName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysName();
            return;
        }
        this.psdevslnsysnameDirtyFlag = false;
        this.psdevslnsysname = null;
    }

    public void setPSSysModelInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysModelInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmodelinstid = string;
        this.pssysmodelinstidDirtyFlag = true;
    }

    public String getPSSysModelInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelInstId();
        }
        return this.pssysmodelinstid;
    }

    public boolean isPSSysModelInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysModelInstIdDirty();
        }
        return this.pssysmodelinstidDirtyFlag;
    }

    public void resetPSSysModelInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysModelInstId();
            return;
        }
        this.pssysmodelinstidDirtyFlag = false;
        this.pssysmodelinstid = null;
    }

    public void setPSTaskServerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSTaskServerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pstaskserverid = string;
        this.pstaskserveridDirtyFlag = true;
    }

    public String getPSTaskServerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSTaskServerId();
        }
        return this.pstaskserverid;
    }

    public boolean isPSTaskServerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSTaskServerIdDirty();
        }
        return this.pstaskserveridDirtyFlag;
    }

    public void resetPSTaskServerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSTaskServerId();
            return;
        }
        this.pstaskserveridDirtyFlag = false;
        this.pstaskserverid = null;
    }

    public void setPSTaskServerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSTaskServerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pstaskservername = string;
        this.pstaskservernameDirtyFlag = true;
    }

    public String getPSTaskServerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSTaskServerName();
        }
        return this.pstaskservername;
    }

    public boolean isPSTaskServerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSTaskServerNameDirty();
        }
        return this.pstaskservernameDirtyFlag;
    }

    public void resetPSTaskServerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSTaskServerName();
            return;
        }
        this.pstaskservernameDirtyFlag = false;
        this.pstaskservername = null;
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

    protected void onReset() {
        PSDevSlnSysBakBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevSlnSysBakBase pSDevSlnSysBakBase) {
        pSDevSlnSysBakBase.resetAccessToken();
        pSDevSlnSysBakBase.resetBackupFilePath();
        pSDevSlnSysBakBase.resetBackupSize();
        pSDevSlnSysBakBase.resetBackupState();
        pSDevSlnSysBakBase.resetBackupTime();
        pSDevSlnSysBakBase.resetBeginBackupTime();
        pSDevSlnSysBakBase.resetBackupMode();
        pSDevSlnSysBakBase.resetCreateDate();
        pSDevSlnSysBakBase.resetCreateMan();
        pSDevSlnSysBakBase.resetEnableLink();
        pSDevSlnSysBakBase.resetEndBackupTime();
        pSDevSlnSysBakBase.resetLinkCode();
        pSDevSlnSysBakBase.resetLinkFlag();
        pSDevSlnSysBakBase.resetLinkRepMsg();
        pSDevSlnSysBakBase.resetLinkReqMsg();
        pSDevSlnSysBakBase.resetMemo();
        pSDevSlnSysBakBase.resetModelVer();
        pSDevSlnSysBakBase.resetOfflineFlag();
        pSDevSlnSysBakBase.resetPSDevCenterId();
        pSDevSlnSysBakBase.resetPSDevCenterName();
        pSDevSlnSysBakBase.resetPSDevSlnId();
        pSDevSlnSysBakBase.resetPSDevSlnSysBakId();
        pSDevSlnSysBakBase.resetPSDevSlnSysBakName();
        pSDevSlnSysBakBase.resetPSDevSlnSysId();
        pSDevSlnSysBakBase.resetPSDevSlnSysName();
        pSDevSlnSysBakBase.resetPSSysModelInstId();
        pSDevSlnSysBakBase.resetPSTaskServerId();
        pSDevSlnSysBakBase.resetPSTaskServerName();
        pSDevSlnSysBakBase.resetUpdateDate();
        pSDevSlnSysBakBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAccessTokenDirty()) {
            hashMap.put(FIELD_ACCESSTOKEN, this.getAccessToken());
        }
        if (!bl || this.isBackupFilePathDirty()) {
            hashMap.put(FIELD_BACKUPFILEPATH, this.getBackupFilePath());
        }
        if (!bl || this.isBackupSizeDirty()) {
            hashMap.put(FIELD_BACKUPSIZE, this.getBackupSize());
        }
        if (!bl || this.isBackupStateDirty()) {
            hashMap.put(FIELD_BACKUPSTATE, this.getBackupState());
        }
        if (!bl || this.isBackupTimeDirty()) {
            hashMap.put(FIELD_BACKUPTIME, this.getBackupTime());
        }
        if (!bl || this.isBeginBackupTimeDirty()) {
            hashMap.put(FIELD_BEGINBACKUPTIME, this.getBeginBackupTime());
        }
        if (!bl || this.isBackupModeDirty()) {
            hashMap.put(FIELD_BACKUPMODE, this.getBackupMode());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isEnableLinkDirty()) {
            hashMap.put(FIELD_ENABLELINK, this.getEnableLink());
        }
        if (!bl || this.isEndBackupTimeDirty()) {
            hashMap.put(FIELD_ENDBACKUPTIME, this.getEndBackupTime());
        }
        if (!bl || this.isLinkCodeDirty()) {
            hashMap.put(FIELD_LINKCODE, this.getLinkCode());
        }
        if (!bl || this.isLinkFlagDirty()) {
            hashMap.put(FIELD_LINKFLAG, this.getLinkFlag());
        }
        if (!bl || this.isLinkRepMsgDirty()) {
            hashMap.put(FIELD_LINKREPMSG, this.getLinkRepMsg());
        }
        if (!bl || this.isLinkReqMsgDirty()) {
            hashMap.put(FIELD_LINKREQMSG, this.getLinkReqMsg());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isModelVerDirty()) {
            hashMap.put(FIELD_MODELVER, this.getModelVer());
        }
        if (!bl || this.isOfflineFlagDirty()) {
            hashMap.put(FIELD_OFFLINEFLAG, this.getOfflineFlag());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSDevSlnIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNID, this.getPSDevSlnId());
        }
        if (!bl || this.isPSDevSlnSysBakIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSBAKID, this.getPSDevSlnSysBakId());
        }
        if (!bl || this.isPSDevSlnSysBakNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSBAKNAME, this.getPSDevSlnSysBakName());
        }
        if (!bl || this.isPSDevSlnSysIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSID, this.getPSDevSlnSysId());
        }
        if (!bl || this.isPSDevSlnSysNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSNAME, this.getPSDevSlnSysName());
        }
        if (!bl || this.isPSSysModelInstIdDirty()) {
            hashMap.put(FIELD_PSSYSMODELINSTID, this.getPSSysModelInstId());
        }
        if (!bl || this.isPSTaskServerIdDirty()) {
            hashMap.put(FIELD_PSTASKSERVERID, this.getPSTaskServerId());
        }
        if (!bl || this.isPSTaskServerNameDirty()) {
            hashMap.put(FIELD_PSTASKSERVERNAME, this.getPSTaskServerName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
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
        return PSDevSlnSysBakBase.get(this, n);
    }

    private static Object get(PSDevSlnSysBakBase pSDevSlnSysBakBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysBakBase.getAccessToken();
            }
            case 1: {
                return pSDevSlnSysBakBase.getBackupFilePath();
            }
            case 2: {
                return pSDevSlnSysBakBase.getBackupSize();
            }
            case 3: {
                return pSDevSlnSysBakBase.getBackupState();
            }
            case 4: {
                return pSDevSlnSysBakBase.getBackupTime();
            }
            case 5: {
                return pSDevSlnSysBakBase.getBeginBackupTime();
            }
            case 6: {
                return pSDevSlnSysBakBase.getBackupMode();
            }
            case 7: {
                return pSDevSlnSysBakBase.getCreateDate();
            }
            case 8: {
                return pSDevSlnSysBakBase.getCreateMan();
            }
            case 9: {
                return pSDevSlnSysBakBase.getEnableLink();
            }
            case 10: {
                return pSDevSlnSysBakBase.getEndBackupTime();
            }
            case 11: {
                return pSDevSlnSysBakBase.getLinkCode();
            }
            case 12: {
                return pSDevSlnSysBakBase.getLinkFlag();
            }
            case 13: {
                return pSDevSlnSysBakBase.getLinkRepMsg();
            }
            case 14: {
                return pSDevSlnSysBakBase.getLinkReqMsg();
            }
            case 15: {
                return pSDevSlnSysBakBase.getMemo();
            }
            case 16: {
                return pSDevSlnSysBakBase.getModelVer();
            }
            case 17: {
                return pSDevSlnSysBakBase.getOfflineFlag();
            }
            case 18: {
                return pSDevSlnSysBakBase.getPSDevCenterId();
            }
            case 19: {
                return pSDevSlnSysBakBase.getPSDevCenterName();
            }
            case 20: {
                return pSDevSlnSysBakBase.getPSDevSlnId();
            }
            case 21: {
                return pSDevSlnSysBakBase.getPSDevSlnSysBakId();
            }
            case 22: {
                return pSDevSlnSysBakBase.getPSDevSlnSysBakName();
            }
            case 23: {
                return pSDevSlnSysBakBase.getPSDevSlnSysId();
            }
            case 24: {
                return pSDevSlnSysBakBase.getPSDevSlnSysName();
            }
            case 25: {
                return pSDevSlnSysBakBase.getPSSysModelInstId();
            }
            case 26: {
                return pSDevSlnSysBakBase.getPSTaskServerId();
            }
            case 27: {
                return pSDevSlnSysBakBase.getPSTaskServerName();
            }
            case 28: {
                return pSDevSlnSysBakBase.getUpdateDate();
            }
            case 29: {
                return pSDevSlnSysBakBase.getUpdateMan();
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
        PSDevSlnSysBakBase.set(this, n, object);
    }

    private static void set(PSDevSlnSysBakBase pSDevSlnSysBakBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnSysBakBase.setAccessToken(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDevSlnSysBakBase.setBackupFilePath(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDevSlnSysBakBase.setBackupSize(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSDevSlnSysBakBase.setBackupState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSDevSlnSysBakBase.setBackupTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 5: {
                pSDevSlnSysBakBase.setBeginBackupTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 6: {
                pSDevSlnSysBakBase.setBackupMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDevSlnSysBakBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 8: {
                pSDevSlnSysBakBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDevSlnSysBakBase.setEnableLink(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSDevSlnSysBakBase.setEndBackupTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSDevSlnSysBakBase.setLinkCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDevSlnSysBakBase.setLinkFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSDevSlnSysBakBase.setLinkRepMsg(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDevSlnSysBakBase.setLinkReqMsg(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDevSlnSysBakBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDevSlnSysBakBase.setModelVer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSDevSlnSysBakBase.setOfflineFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 18: {
                pSDevSlnSysBakBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDevSlnSysBakBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDevSlnSysBakBase.setPSDevSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDevSlnSysBakBase.setPSDevSlnSysBakId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDevSlnSysBakBase.setPSDevSlnSysBakName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDevSlnSysBakBase.setPSDevSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDevSlnSysBakBase.setPSDevSlnSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDevSlnSysBakBase.setPSSysModelInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDevSlnSysBakBase.setPSTaskServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDevSlnSysBakBase.setPSTaskServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDevSlnSysBakBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 29: {
                pSDevSlnSysBakBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDevSlnSysBakBase.isNull(this, n);
    }

    private static boolean isNull(PSDevSlnSysBakBase pSDevSlnSysBakBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysBakBase.getAccessToken() == null;
            }
            case 1: {
                return pSDevSlnSysBakBase.getBackupFilePath() == null;
            }
            case 2: {
                return pSDevSlnSysBakBase.getBackupSize() == null;
            }
            case 3: {
                return pSDevSlnSysBakBase.getBackupState() == null;
            }
            case 4: {
                return pSDevSlnSysBakBase.getBackupTime() == null;
            }
            case 5: {
                return pSDevSlnSysBakBase.getBeginBackupTime() == null;
            }
            case 6: {
                return pSDevSlnSysBakBase.getBackupMode() == null;
            }
            case 7: {
                return pSDevSlnSysBakBase.getCreateDate() == null;
            }
            case 8: {
                return pSDevSlnSysBakBase.getCreateMan() == null;
            }
            case 9: {
                return pSDevSlnSysBakBase.getEnableLink() == null;
            }
            case 10: {
                return pSDevSlnSysBakBase.getEndBackupTime() == null;
            }
            case 11: {
                return pSDevSlnSysBakBase.getLinkCode() == null;
            }
            case 12: {
                return pSDevSlnSysBakBase.getLinkFlag() == null;
            }
            case 13: {
                return pSDevSlnSysBakBase.getLinkRepMsg() == null;
            }
            case 14: {
                return pSDevSlnSysBakBase.getLinkReqMsg() == null;
            }
            case 15: {
                return pSDevSlnSysBakBase.getMemo() == null;
            }
            case 16: {
                return pSDevSlnSysBakBase.getModelVer() == null;
            }
            case 17: {
                return pSDevSlnSysBakBase.getOfflineFlag() == null;
            }
            case 18: {
                return pSDevSlnSysBakBase.getPSDevCenterId() == null;
            }
            case 19: {
                return pSDevSlnSysBakBase.getPSDevCenterName() == null;
            }
            case 20: {
                return pSDevSlnSysBakBase.getPSDevSlnId() == null;
            }
            case 21: {
                return pSDevSlnSysBakBase.getPSDevSlnSysBakId() == null;
            }
            case 22: {
                return pSDevSlnSysBakBase.getPSDevSlnSysBakName() == null;
            }
            case 23: {
                return pSDevSlnSysBakBase.getPSDevSlnSysId() == null;
            }
            case 24: {
                return pSDevSlnSysBakBase.getPSDevSlnSysName() == null;
            }
            case 25: {
                return pSDevSlnSysBakBase.getPSSysModelInstId() == null;
            }
            case 26: {
                return pSDevSlnSysBakBase.getPSTaskServerId() == null;
            }
            case 27: {
                return pSDevSlnSysBakBase.getPSTaskServerName() == null;
            }
            case 28: {
                return pSDevSlnSysBakBase.getUpdateDate() == null;
            }
            case 29: {
                return pSDevSlnSysBakBase.getUpdateMan() == null;
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
        return PSDevSlnSysBakBase.contains(this, n);
    }

    private static boolean contains(PSDevSlnSysBakBase pSDevSlnSysBakBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysBakBase.isAccessTokenDirty();
            }
            case 1: {
                return pSDevSlnSysBakBase.isBackupFilePathDirty();
            }
            case 2: {
                return pSDevSlnSysBakBase.isBackupSizeDirty();
            }
            case 3: {
                return pSDevSlnSysBakBase.isBackupStateDirty();
            }
            case 4: {
                return pSDevSlnSysBakBase.isBackupTimeDirty();
            }
            case 5: {
                return pSDevSlnSysBakBase.isBeginBackupTimeDirty();
            }
            case 6: {
                return pSDevSlnSysBakBase.isBackupModeDirty();
            }
            case 7: {
                return pSDevSlnSysBakBase.isCreateDateDirty();
            }
            case 8: {
                return pSDevSlnSysBakBase.isCreateManDirty();
            }
            case 9: {
                return pSDevSlnSysBakBase.isEnableLinkDirty();
            }
            case 10: {
                return pSDevSlnSysBakBase.isEndBackupTimeDirty();
            }
            case 11: {
                return pSDevSlnSysBakBase.isLinkCodeDirty();
            }
            case 12: {
                return pSDevSlnSysBakBase.isLinkFlagDirty();
            }
            case 13: {
                return pSDevSlnSysBakBase.isLinkRepMsgDirty();
            }
            case 14: {
                return pSDevSlnSysBakBase.isLinkReqMsgDirty();
            }
            case 15: {
                return pSDevSlnSysBakBase.isMemoDirty();
            }
            case 16: {
                return pSDevSlnSysBakBase.isModelVerDirty();
            }
            case 17: {
                return pSDevSlnSysBakBase.isOfflineFlagDirty();
            }
            case 18: {
                return pSDevSlnSysBakBase.isPSDevCenterIdDirty();
            }
            case 19: {
                return pSDevSlnSysBakBase.isPSDevCenterNameDirty();
            }
            case 20: {
                return pSDevSlnSysBakBase.isPSDevSlnIdDirty();
            }
            case 21: {
                return pSDevSlnSysBakBase.isPSDevSlnSysBakIdDirty();
            }
            case 22: {
                return pSDevSlnSysBakBase.isPSDevSlnSysBakNameDirty();
            }
            case 23: {
                return pSDevSlnSysBakBase.isPSDevSlnSysIdDirty();
            }
            case 24: {
                return pSDevSlnSysBakBase.isPSDevSlnSysNameDirty();
            }
            case 25: {
                return pSDevSlnSysBakBase.isPSSysModelInstIdDirty();
            }
            case 26: {
                return pSDevSlnSysBakBase.isPSTaskServerIdDirty();
            }
            case 27: {
                return pSDevSlnSysBakBase.isPSTaskServerNameDirty();
            }
            case 28: {
                return pSDevSlnSysBakBase.isUpdateDateDirty();
            }
            case 29: {
                return pSDevSlnSysBakBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevSlnSysBakBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevSlnSysBakBase pSDevSlnSysBakBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevSlnSysBakBase.getAccessToken() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"accesstoken", (Object)PSDevSlnSysBakBase.getJSONValue((Object)pSDevSlnSysBakBase.getAccessToken()), (boolean)false);
        }
        if (bl || pSDevSlnSysBakBase.getBackupFilePath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"backupfilepath", (Object)PSDevSlnSysBakBase.getJSONValue((Object)pSDevSlnSysBakBase.getBackupFilePath()), (boolean)false);
        }
        if (bl || pSDevSlnSysBakBase.getBackupSize() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"backupsize", (Object)PSDevSlnSysBakBase.getJSONValue((Object)pSDevSlnSysBakBase.getBackupSize()), (boolean)false);
        }
        if (bl || pSDevSlnSysBakBase.getBackupState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"backupstate", (Object)PSDevSlnSysBakBase.getJSONValue((Object)pSDevSlnSysBakBase.getBackupState()), (boolean)false);
        }
        if (bl || pSDevSlnSysBakBase.getBackupTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"backuptime", (Object)PSDevSlnSysBakBase.getJSONValue((Object)pSDevSlnSysBakBase.getBackupTime()), (boolean)false);
        }
        if (bl || pSDevSlnSysBakBase.getBeginBackupTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"beginbackuptime", (Object)PSDevSlnSysBakBase.getJSONValue((Object)pSDevSlnSysBakBase.getBeginBackupTime()), (boolean)false);
        }
        if (bl || pSDevSlnSysBakBase.getBackupMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bkmode", (Object)PSDevSlnSysBakBase.getJSONValue((Object)pSDevSlnSysBakBase.getBackupMode()), (boolean)false);
        }
        if (bl || pSDevSlnSysBakBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevSlnSysBakBase.getJSONValue((Object)pSDevSlnSysBakBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevSlnSysBakBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevSlnSysBakBase.getJSONValue((Object)pSDevSlnSysBakBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevSlnSysBakBase.getEnableLink() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablelink", (Object)PSDevSlnSysBakBase.getJSONValue((Object)pSDevSlnSysBakBase.getEnableLink()), (boolean)false);
        }
        if (bl || pSDevSlnSysBakBase.getEndBackupTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"endbackuptime", (Object)PSDevSlnSysBakBase.getJSONValue((Object)pSDevSlnSysBakBase.getEndBackupTime()), (boolean)false);
        }
        if (bl || pSDevSlnSysBakBase.getLinkCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"linkcode", (Object)PSDevSlnSysBakBase.getJSONValue((Object)pSDevSlnSysBakBase.getLinkCode()), (boolean)false);
        }
        if (bl || pSDevSlnSysBakBase.getLinkFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"linkflag", (Object)PSDevSlnSysBakBase.getJSONValue((Object)pSDevSlnSysBakBase.getLinkFlag()), (boolean)false);
        }
        if (bl || pSDevSlnSysBakBase.getLinkRepMsg() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"linkrepmsg", (Object)PSDevSlnSysBakBase.getJSONValue((Object)pSDevSlnSysBakBase.getLinkRepMsg()), (boolean)false);
        }
        if (bl || pSDevSlnSysBakBase.getLinkReqMsg() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"linkreqmsg", (Object)PSDevSlnSysBakBase.getJSONValue((Object)pSDevSlnSysBakBase.getLinkReqMsg()), (boolean)false);
        }
        if (bl || pSDevSlnSysBakBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDevSlnSysBakBase.getJSONValue((Object)pSDevSlnSysBakBase.getMemo()), (boolean)false);
        }
        if (bl || pSDevSlnSysBakBase.getModelVer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modelver", (Object)PSDevSlnSysBakBase.getJSONValue((Object)pSDevSlnSysBakBase.getModelVer()), (boolean)false);
        }
        if (bl || pSDevSlnSysBakBase.getOfflineFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"offlineflag", (Object)PSDevSlnSysBakBase.getJSONValue((Object)pSDevSlnSysBakBase.getOfflineFlag()), (boolean)false);
        }
        if (bl || pSDevSlnSysBakBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDevSlnSysBakBase.getJSONValue((Object)pSDevSlnSysBakBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDevSlnSysBakBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDevSlnSysBakBase.getJSONValue((Object)pSDevSlnSysBakBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDevSlnSysBakBase.getPSDevSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnid", (Object)PSDevSlnSysBakBase.getJSONValue((Object)pSDevSlnSysBakBase.getPSDevSlnId()), (boolean)false);
        }
        if (bl || pSDevSlnSysBakBase.getPSDevSlnSysBakId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysbakid", (Object)PSDevSlnSysBakBase.getJSONValue((Object)pSDevSlnSysBakBase.getPSDevSlnSysBakId()), (boolean)false);
        }
        if (bl || pSDevSlnSysBakBase.getPSDevSlnSysBakName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysbakname", (Object)PSDevSlnSysBakBase.getJSONValue((Object)pSDevSlnSysBakBase.getPSDevSlnSysBakName()), (boolean)false);
        }
        if (bl || pSDevSlnSysBakBase.getPSDevSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysid", (Object)PSDevSlnSysBakBase.getJSONValue((Object)pSDevSlnSysBakBase.getPSDevSlnSysId()), (boolean)false);
        }
        if (bl || pSDevSlnSysBakBase.getPSDevSlnSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysname", (Object)PSDevSlnSysBakBase.getJSONValue((Object)pSDevSlnSysBakBase.getPSDevSlnSysName()), (boolean)false);
        }
        if (bl || pSDevSlnSysBakBase.getPSSysModelInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelinstid", (Object)PSDevSlnSysBakBase.getJSONValue((Object)pSDevSlnSysBakBase.getPSSysModelInstId()), (boolean)false);
        }
        if (bl || pSDevSlnSysBakBase.getPSTaskServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstaskserverid", (Object)PSDevSlnSysBakBase.getJSONValue((Object)pSDevSlnSysBakBase.getPSTaskServerId()), (boolean)false);
        }
        if (bl || pSDevSlnSysBakBase.getPSTaskServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstaskservername", (Object)PSDevSlnSysBakBase.getJSONValue((Object)pSDevSlnSysBakBase.getPSTaskServerName()), (boolean)false);
        }
        if (bl || pSDevSlnSysBakBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevSlnSysBakBase.getJSONValue((Object)pSDevSlnSysBakBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevSlnSysBakBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevSlnSysBakBase.getJSONValue((Object)pSDevSlnSysBakBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevSlnSysBakBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevSlnSysBakBase pSDevSlnSysBakBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevSlnSysBakBase.getAccessToken() != null) {
            object = pSDevSlnSysBakBase.getAccessToken();
            xmlNode.setAttribute(FIELD_ACCESSTOKEN, (String)(object == null ? "" : object));
        }
        if (bl || pSDevSlnSysBakBase.getBackupFilePath() != null) {
            object = pSDevSlnSysBakBase.getBackupFilePath();
            xmlNode.setAttribute(FIELD_BACKUPFILEPATH, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBakBase.getBackupSize() != null) {
            object = pSDevSlnSysBakBase.getBackupSize();
            xmlNode.setAttribute(FIELD_BACKUPSIZE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnSysBakBase.getBackupState() != null) {
            object = pSDevSlnSysBakBase.getBackupState();
            xmlNode.setAttribute(FIELD_BACKUPSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnSysBakBase.getBackupTime() != null) {
            object = pSDevSlnSysBakBase.getBackupTime();
            xmlNode.setAttribute(FIELD_BACKUPTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysBakBase.getBeginBackupTime() != null) {
            object = pSDevSlnSysBakBase.getBeginBackupTime();
            xmlNode.setAttribute(FIELD_BEGINBACKUPTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysBakBase.getBackupMode() != null) {
            object = pSDevSlnSysBakBase.getBackupMode();
            xmlNode.setAttribute("BACKUPMODE", object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBakBase.getCreateDate() != null) {
            object = pSDevSlnSysBakBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysBakBase.getCreateMan() != null) {
            object = pSDevSlnSysBakBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBakBase.getEnableLink() != null) {
            object = pSDevSlnSysBakBase.getEnableLink();
            xmlNode.setAttribute(FIELD_ENABLELINK, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnSysBakBase.getEndBackupTime() != null) {
            object = pSDevSlnSysBakBase.getEndBackupTime();
            xmlNode.setAttribute(FIELD_ENDBACKUPTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysBakBase.getLinkCode() != null) {
            object = pSDevSlnSysBakBase.getLinkCode();
            xmlNode.setAttribute(FIELD_LINKCODE, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBakBase.getLinkFlag() != null) {
            object = pSDevSlnSysBakBase.getLinkFlag();
            xmlNode.setAttribute(FIELD_LINKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnSysBakBase.getLinkRepMsg() != null) {
            object = pSDevSlnSysBakBase.getLinkRepMsg();
            xmlNode.setAttribute(FIELD_LINKREPMSG, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBakBase.getLinkReqMsg() != null) {
            object = pSDevSlnSysBakBase.getLinkReqMsg();
            xmlNode.setAttribute(FIELD_LINKREQMSG, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBakBase.getMemo() != null) {
            object = pSDevSlnSysBakBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBakBase.getModelVer() != null) {
            object = pSDevSlnSysBakBase.getModelVer();
            xmlNode.setAttribute(FIELD_MODELVER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnSysBakBase.getOfflineFlag() != null) {
            object = pSDevSlnSysBakBase.getOfflineFlag();
            xmlNode.setAttribute(FIELD_OFFLINEFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnSysBakBase.getPSDevCenterId() != null) {
            object = pSDevSlnSysBakBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBakBase.getPSDevCenterName() != null) {
            object = pSDevSlnSysBakBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBakBase.getPSDevSlnId() != null) {
            object = pSDevSlnSysBakBase.getPSDevSlnId();
            xmlNode.setAttribute(FIELD_PSDEVSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBakBase.getPSDevSlnSysBakId() != null) {
            object = pSDevSlnSysBakBase.getPSDevSlnSysBakId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSBAKID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBakBase.getPSDevSlnSysBakName() != null) {
            object = pSDevSlnSysBakBase.getPSDevSlnSysBakName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSBAKNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBakBase.getPSDevSlnSysId() != null) {
            object = pSDevSlnSysBakBase.getPSDevSlnSysId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBakBase.getPSDevSlnSysName() != null) {
            object = pSDevSlnSysBakBase.getPSDevSlnSysName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBakBase.getPSSysModelInstId() != null) {
            object = pSDevSlnSysBakBase.getPSSysModelInstId();
            xmlNode.setAttribute(FIELD_PSSYSMODELINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBakBase.getPSTaskServerId() != null) {
            object = pSDevSlnSysBakBase.getPSTaskServerId();
            xmlNode.setAttribute(FIELD_PSTASKSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBakBase.getPSTaskServerName() != null) {
            object = pSDevSlnSysBakBase.getPSTaskServerName();
            xmlNode.setAttribute(FIELD_PSTASKSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBakBase.getUpdateDate() != null) {
            object = pSDevSlnSysBakBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysBakBase.getUpdateMan() != null) {
            object = pSDevSlnSysBakBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevSlnSysBakBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevSlnSysBakBase pSDevSlnSysBakBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevSlnSysBakBase.isAccessTokenDirty() && (bl || pSDevSlnSysBakBase.getAccessToken() != null)) {
            iDataObject.set(FIELD_ACCESSTOKEN, (Object)pSDevSlnSysBakBase.getAccessToken());
        }
        if (pSDevSlnSysBakBase.isBackupFilePathDirty() && (bl || pSDevSlnSysBakBase.getBackupFilePath() != null)) {
            iDataObject.set(FIELD_BACKUPFILEPATH, (Object)pSDevSlnSysBakBase.getBackupFilePath());
        }
        if (pSDevSlnSysBakBase.isBackupSizeDirty() && (bl || pSDevSlnSysBakBase.getBackupSize() != null)) {
            iDataObject.set(FIELD_BACKUPSIZE, (Object)pSDevSlnSysBakBase.getBackupSize());
        }
        if (pSDevSlnSysBakBase.isBackupStateDirty() && (bl || pSDevSlnSysBakBase.getBackupState() != null)) {
            iDataObject.set(FIELD_BACKUPSTATE, (Object)pSDevSlnSysBakBase.getBackupState());
        }
        if (pSDevSlnSysBakBase.isBackupTimeDirty() && (bl || pSDevSlnSysBakBase.getBackupTime() != null)) {
            iDataObject.set(FIELD_BACKUPTIME, (Object)pSDevSlnSysBakBase.getBackupTime());
        }
        if (pSDevSlnSysBakBase.isBeginBackupTimeDirty() && (bl || pSDevSlnSysBakBase.getBeginBackupTime() != null)) {
            iDataObject.set(FIELD_BEGINBACKUPTIME, (Object)pSDevSlnSysBakBase.getBeginBackupTime());
        }
        if (pSDevSlnSysBakBase.isBackupModeDirty() && (bl || pSDevSlnSysBakBase.getBackupMode() != null)) {
            iDataObject.set(FIELD_BACKUPMODE, (Object)pSDevSlnSysBakBase.getBackupMode());
        }
        if (pSDevSlnSysBakBase.isCreateDateDirty() && (bl || pSDevSlnSysBakBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevSlnSysBakBase.getCreateDate());
        }
        if (pSDevSlnSysBakBase.isCreateManDirty() && (bl || pSDevSlnSysBakBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevSlnSysBakBase.getCreateMan());
        }
        if (pSDevSlnSysBakBase.isEnableLinkDirty() && (bl || pSDevSlnSysBakBase.getEnableLink() != null)) {
            iDataObject.set(FIELD_ENABLELINK, (Object)pSDevSlnSysBakBase.getEnableLink());
        }
        if (pSDevSlnSysBakBase.isEndBackupTimeDirty() && (bl || pSDevSlnSysBakBase.getEndBackupTime() != null)) {
            iDataObject.set(FIELD_ENDBACKUPTIME, (Object)pSDevSlnSysBakBase.getEndBackupTime());
        }
        if (pSDevSlnSysBakBase.isLinkCodeDirty() && (bl || pSDevSlnSysBakBase.getLinkCode() != null)) {
            iDataObject.set(FIELD_LINKCODE, (Object)pSDevSlnSysBakBase.getLinkCode());
        }
        if (pSDevSlnSysBakBase.isLinkFlagDirty() && (bl || pSDevSlnSysBakBase.getLinkFlag() != null)) {
            iDataObject.set(FIELD_LINKFLAG, (Object)pSDevSlnSysBakBase.getLinkFlag());
        }
        if (pSDevSlnSysBakBase.isLinkRepMsgDirty() && (bl || pSDevSlnSysBakBase.getLinkRepMsg() != null)) {
            iDataObject.set(FIELD_LINKREPMSG, (Object)pSDevSlnSysBakBase.getLinkRepMsg());
        }
        if (pSDevSlnSysBakBase.isLinkReqMsgDirty() && (bl || pSDevSlnSysBakBase.getLinkReqMsg() != null)) {
            iDataObject.set(FIELD_LINKREQMSG, (Object)pSDevSlnSysBakBase.getLinkReqMsg());
        }
        if (pSDevSlnSysBakBase.isMemoDirty() && (bl || pSDevSlnSysBakBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDevSlnSysBakBase.getMemo());
        }
        if (pSDevSlnSysBakBase.isModelVerDirty() && (bl || pSDevSlnSysBakBase.getModelVer() != null)) {
            iDataObject.set(FIELD_MODELVER, (Object)pSDevSlnSysBakBase.getModelVer());
        }
        if (pSDevSlnSysBakBase.isOfflineFlagDirty() && (bl || pSDevSlnSysBakBase.getOfflineFlag() != null)) {
            iDataObject.set(FIELD_OFFLINEFLAG, (Object)pSDevSlnSysBakBase.getOfflineFlag());
        }
        if (pSDevSlnSysBakBase.isPSDevCenterIdDirty() && (bl || pSDevSlnSysBakBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDevSlnSysBakBase.getPSDevCenterId());
        }
        if (pSDevSlnSysBakBase.isPSDevCenterNameDirty() && (bl || pSDevSlnSysBakBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDevSlnSysBakBase.getPSDevCenterName());
        }
        if (pSDevSlnSysBakBase.isPSDevSlnIdDirty() && (bl || pSDevSlnSysBakBase.getPSDevSlnId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNID, (Object)pSDevSlnSysBakBase.getPSDevSlnId());
        }
        if (pSDevSlnSysBakBase.isPSDevSlnSysBakIdDirty() && (bl || pSDevSlnSysBakBase.getPSDevSlnSysBakId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSBAKID, (Object)pSDevSlnSysBakBase.getPSDevSlnSysBakId());
        }
        if (pSDevSlnSysBakBase.isPSDevSlnSysBakNameDirty() && (bl || pSDevSlnSysBakBase.getPSDevSlnSysBakName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSBAKNAME, (Object)pSDevSlnSysBakBase.getPSDevSlnSysBakName());
        }
        if (pSDevSlnSysBakBase.isPSDevSlnSysIdDirty() && (bl || pSDevSlnSysBakBase.getPSDevSlnSysId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSID, (Object)pSDevSlnSysBakBase.getPSDevSlnSysId());
        }
        if (pSDevSlnSysBakBase.isPSDevSlnSysNameDirty() && (bl || pSDevSlnSysBakBase.getPSDevSlnSysName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSNAME, (Object)pSDevSlnSysBakBase.getPSDevSlnSysName());
        }
        if (pSDevSlnSysBakBase.isPSSysModelInstIdDirty() && (bl || pSDevSlnSysBakBase.getPSSysModelInstId() != null)) {
            iDataObject.set(FIELD_PSSYSMODELINSTID, (Object)pSDevSlnSysBakBase.getPSSysModelInstId());
        }
        if (pSDevSlnSysBakBase.isPSTaskServerIdDirty() && (bl || pSDevSlnSysBakBase.getPSTaskServerId() != null)) {
            iDataObject.set(FIELD_PSTASKSERVERID, (Object)pSDevSlnSysBakBase.getPSTaskServerId());
        }
        if (pSDevSlnSysBakBase.isPSTaskServerNameDirty() && (bl || pSDevSlnSysBakBase.getPSTaskServerName() != null)) {
            iDataObject.set(FIELD_PSTASKSERVERNAME, (Object)pSDevSlnSysBakBase.getPSTaskServerName());
        }
        if (pSDevSlnSysBakBase.isUpdateDateDirty() && (bl || pSDevSlnSysBakBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevSlnSysBakBase.getUpdateDate());
        }
        if (pSDevSlnSysBakBase.isUpdateManDirty() && (bl || pSDevSlnSysBakBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevSlnSysBakBase.getUpdateMan());
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
        return PSDevSlnSysBakBase.remove(this, n);
    }

    private static boolean remove(PSDevSlnSysBakBase pSDevSlnSysBakBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnSysBakBase.resetAccessToken();
                return true;
            }
            case 1: {
                pSDevSlnSysBakBase.resetBackupFilePath();
                return true;
            }
            case 2: {
                pSDevSlnSysBakBase.resetBackupSize();
                return true;
            }
            case 3: {
                pSDevSlnSysBakBase.resetBackupState();
                return true;
            }
            case 4: {
                pSDevSlnSysBakBase.resetBackupTime();
                return true;
            }
            case 5: {
                pSDevSlnSysBakBase.resetBeginBackupTime();
                return true;
            }
            case 6: {
                pSDevSlnSysBakBase.resetBackupMode();
                return true;
            }
            case 7: {
                pSDevSlnSysBakBase.resetCreateDate();
                return true;
            }
            case 8: {
                pSDevSlnSysBakBase.resetCreateMan();
                return true;
            }
            case 9: {
                pSDevSlnSysBakBase.resetEnableLink();
                return true;
            }
            case 10: {
                pSDevSlnSysBakBase.resetEndBackupTime();
                return true;
            }
            case 11: {
                pSDevSlnSysBakBase.resetLinkCode();
                return true;
            }
            case 12: {
                pSDevSlnSysBakBase.resetLinkFlag();
                return true;
            }
            case 13: {
                pSDevSlnSysBakBase.resetLinkRepMsg();
                return true;
            }
            case 14: {
                pSDevSlnSysBakBase.resetLinkReqMsg();
                return true;
            }
            case 15: {
                pSDevSlnSysBakBase.resetMemo();
                return true;
            }
            case 16: {
                pSDevSlnSysBakBase.resetModelVer();
                return true;
            }
            case 17: {
                pSDevSlnSysBakBase.resetOfflineFlag();
                return true;
            }
            case 18: {
                pSDevSlnSysBakBase.resetPSDevCenterId();
                return true;
            }
            case 19: {
                pSDevSlnSysBakBase.resetPSDevCenterName();
                return true;
            }
            case 20: {
                pSDevSlnSysBakBase.resetPSDevSlnId();
                return true;
            }
            case 21: {
                pSDevSlnSysBakBase.resetPSDevSlnSysBakId();
                return true;
            }
            case 22: {
                pSDevSlnSysBakBase.resetPSDevSlnSysBakName();
                return true;
            }
            case 23: {
                pSDevSlnSysBakBase.resetPSDevSlnSysId();
                return true;
            }
            case 24: {
                pSDevSlnSysBakBase.resetPSDevSlnSysName();
                return true;
            }
            case 25: {
                pSDevSlnSysBakBase.resetPSSysModelInstId();
                return true;
            }
            case 26: {
                pSDevSlnSysBakBase.resetPSTaskServerId();
                return true;
            }
            case 27: {
                pSDevSlnSysBakBase.resetPSTaskServerName();
                return true;
            }
            case 28: {
                pSDevSlnSysBakBase.resetUpdateDate();
                return true;
            }
            case 29: {
                pSDevSlnSysBakBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenter getPSDevCenter() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenter();
        }
        if (this.getPSDevCenterId() == null) {
            return null;
        }
        Integer n = this.objPSDevCenterLock;
        synchronized (n) {
            if (this.psdevcenter != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevCenterId(), (Object)this.psdevcenter.getPSDevCenterId()) != 0L) {
                this.psdevcenter = null;
            }
            if (this.psdevcenter == null) {
                PSDevCenter pSDevCenter = new PSDevCenter();
                pSDevCenter.setPSDevCenterId(this.getPSDevCenterId());
                PSDevCenterService pSDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterService.autoGet(pSDevCenter);
                this.psdevcenter = pSDevCenter;
            }
            return this.psdevcenter;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnSys getPSDevSlnSys() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSys();
        }
        if (this.getPSDevSlnSysId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnSysLock;
        synchronized (n) {
            if (this.psdevslnsys != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnSysId(), (Object)this.psdevslnsys.getPSDevSlnSysId()) != 0L) {
                this.psdevslnsys = null;
            }
            if (this.psdevslnsys == null) {
                PSDevSlnSys pSDevSlnSys = new PSDevSlnSys();
                pSDevSlnSys.setPSDevSlnSysId(this.getPSDevSlnSysId());
                PSDevSlnSysService pSDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnSysService.autoGet(pSDevSlnSys);
                this.psdevslnsys = pSDevSlnSys;
            }
            return this.psdevslnsys;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSTaskServer getPSTaskServer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSTaskServer();
        }
        if (this.getPSTaskServerId() == null) {
            return null;
        }
        Integer n = this.objPSTaskServerLock;
        synchronized (n) {
            if (this.pstaskserver != null && DataTypeHelper.compare((int)25, (Object)this.getPSTaskServerId(), (Object)this.pstaskserver.getPSTaskServerId()) != 0L) {
                this.pstaskserver = null;
            }
            if (this.pstaskserver == null) {
                PSTaskServer pSTaskServer = new PSTaskServer();
                pSTaskServer.setPSTaskServerId(this.getPSTaskServerId());
                PSTaskServerService pSTaskServerService = (PSTaskServerService)ServiceGlobal.getService(PSTaskServerService.class, (SessionFactory)this.getSessionFactory());
                pSTaskServerService.autoGet(pSTaskServer);
                this.pstaskserver = pSTaskServer;
            }
            return this.pstaskserver;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDevSlnSysBakLink> getPSDevSlnSysBakLinks() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysBakLinks();
        }
        if (this.getPSDevSlnSysBakId() == null) {
            return null;
        }
        PSDevSlnSysBakLinkService pSDevSlnSysBakLinkService = (PSDevSlnSysBakLinkService)ServiceGlobal.getService(PSDevSlnSysBakLinkService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDevSlnSysBakLinksLock;
        synchronized (n) {
            if (this.psdevslnsysbaklinks == null) {
                this.psdevslnsysbaklinks = pSDevSlnSysBakLinkService.selectByPSDevSlnSysBak(this);
            }
            return this.psdevslnsysbaklinks;
        }
    }

    private PSDevSlnSysBakBase getProxyEntity() {
        return this.proxyPSDevSlnSysBakBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevSlnSysBakBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevSlnSysBakBase) {
            this.proxyPSDevSlnSysBakBase = (PSDevSlnSysBakBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysBakService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ACCESSTOKEN, 0);
        fieldIndexMap.put(FIELD_BACKUPFILEPATH, 1);
        fieldIndexMap.put(FIELD_BACKUPSIZE, 2);
        fieldIndexMap.put(FIELD_BACKUPSTATE, 3);
        fieldIndexMap.put(FIELD_BACKUPTIME, 4);
        fieldIndexMap.put(FIELD_BEGINBACKUPTIME, 5);
        fieldIndexMap.put(FIELD_BACKUPMODE, 6);
        fieldIndexMap.put(FIELD_CREATEDATE, 7);
        fieldIndexMap.put(FIELD_CREATEMAN, 8);
        fieldIndexMap.put(FIELD_ENABLELINK, 9);
        fieldIndexMap.put(FIELD_ENDBACKUPTIME, 10);
        fieldIndexMap.put(FIELD_LINKCODE, 11);
        fieldIndexMap.put(FIELD_LINKFLAG, 12);
        fieldIndexMap.put(FIELD_LINKREPMSG, 13);
        fieldIndexMap.put(FIELD_LINKREQMSG, 14);
        fieldIndexMap.put(FIELD_MEMO, 15);
        fieldIndexMap.put(FIELD_MODELVER, 16);
        fieldIndexMap.put(FIELD_OFFLINEFLAG, 17);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 18);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 19);
        fieldIndexMap.put(FIELD_PSDEVSLNID, 20);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSBAKID, 21);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSBAKNAME, 22);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSID, 23);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSNAME, 24);
        fieldIndexMap.put(FIELD_PSSYSMODELINSTID, 25);
        fieldIndexMap.put(FIELD_PSTASKSERVERID, 26);
        fieldIndexMap.put(FIELD_PSTASKSERVERNAME, 27);
        fieldIndexMap.put(FIELD_UPDATEDATE, 28);
        fieldIndexMap.put(FIELD_UPDATEMAN, 29);
    }
}

