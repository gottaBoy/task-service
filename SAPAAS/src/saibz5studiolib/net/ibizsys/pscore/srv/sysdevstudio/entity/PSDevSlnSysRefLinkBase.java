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
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysRef;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysSrv;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysRefService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysSrvService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnSysRefLinkBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevSlnSysRefLinkBase.class);
    public static final String FIELD_ACCESSTOKEN = "ACCESSTOKEN";
    public static final String FIELD_BEGINTIME = "BEGINTIME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ENDTIME = "ENDTIME";
    public static final String FIELD_LINKPSDEVCENTERID = "LINKPSDEVCENTERID";
    public static final String FIELD_LINKPSDEVCENTERNAME = "LINKPSDEVCENTERNAME";
    public static final String FIELD_LINKREPMSG = "LINKREPMSG";
    public static final String FIELD_LINKREQMSG = "LINKREQMSG";
    public static final String FIELD_LINKSTATE = "LINKSTATE";
    public static final String FIELD_LINKSTATEINFO = "LINKSTATEINFO";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEVSLNID = "PSDEVSLNID";
    public static final String FIELD_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String FIELD_PSDEVSLNSYSNAME = "PSDEVSLNSYSNAME";
    public static final String FIELD_PSDEVSLNSYSREFID = "PSDEVSLNSYSREFID";
    public static final String FIELD_PSDEVSLNSYSREFLINKID = "PSDEVSLNSYSREFLINKID";
    public static final String FIELD_PSDEVSLNSYSREFLINKNAME = "PSDEVSLNSYSREFLINKNAME";
    public static final String FIELD_PSDEVSLNSYSREFNAME = "PSDEVSLNSYSREFNAME";
    public static final String FIELD_PSDEVSLNSYSSRVID = "PSDEVSLNSYSSRVID";
    public static final String FIELD_PSDEVSLNSYSSRVNAME = "PSDEVSLNSYSSRVNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_ACCESSTOKEN = 0;
    private static final int INDEX_BEGINTIME = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_ENDTIME = 4;
    private static final int INDEX_LINKPSDEVCENTERID = 5;
    private static final int INDEX_LINKPSDEVCENTERNAME = 6;
    private static final int INDEX_LINKREPMSG = 7;
    private static final int INDEX_LINKREQMSG = 8;
    private static final int INDEX_LINKSTATE = 9;
    private static final int INDEX_LINKSTATEINFO = 10;
    private static final int INDEX_MEMO = 11;
    private static final int INDEX_PSDEVSLNID = 12;
    private static final int INDEX_PSDEVSLNSYSID = 13;
    private static final int INDEX_PSDEVSLNSYSNAME = 14;
    private static final int INDEX_PSDEVSLNSYSREFID = 15;
    private static final int INDEX_PSDEVSLNSYSREFLINKID = 16;
    private static final int INDEX_PSDEVSLNSYSREFLINKNAME = 17;
    private static final int INDEX_PSDEVSLNSYSREFNAME = 18;
    private static final int INDEX_PSDEVSLNSYSSRVID = 19;
    private static final int INDEX_PSDEVSLNSYSSRVNAME = 20;
    private static final int INDEX_UPDATEDATE = 21;
    private static final int INDEX_UPDATEMAN = 22;
    private static final int INDEX_VALIDFLAG = 23;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevSlnSysRefLinkBase proxyPSDevSlnSysRefLinkBase = null;
    private boolean accesstokenDirtyFlag = false;
    private boolean begintimeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean endtimeDirtyFlag = false;
    private boolean linkpsdevcenteridDirtyFlag = false;
    private boolean linkpsdevcenternameDirtyFlag = false;
    private boolean linkrepmsgDirtyFlag = false;
    private boolean linkreqmsgDirtyFlag = false;
    private boolean linkstateDirtyFlag = false;
    private boolean linkstateinfoDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdevslnidDirtyFlag = false;
    private boolean psdevslnsysidDirtyFlag = false;
    private boolean psdevslnsysnameDirtyFlag = false;
    private boolean psdevslnsysrefidDirtyFlag = false;
    private boolean psdevslnsysreflinkidDirtyFlag = false;
    private boolean psdevslnsysreflinknameDirtyFlag = false;
    private boolean psdevslnsysrefnameDirtyFlag = false;
    private boolean psdevslnsyssrvidDirtyFlag = false;
    private boolean psdevslnsyssrvnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="accesstoken")
    private String accesstoken;
    @Column(name="begintime")
    private Timestamp begintime;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="endtime")
    private Timestamp endtime;
    @Column(name="linkpsdevcenterid")
    private String linkpsdevcenterid;
    @Column(name="linkpsdevcentername")
    private String linkpsdevcentername;
    @Column(name="linkrepmsg")
    private String linkrepmsg;
    @Column(name="linkreqmsg")
    private String linkreqmsg;
    @Column(name="linkstate")
    private Integer linkstate;
    @Column(name="linkstateinfo")
    private String linkstateinfo;
    @Column(name="memo")
    private String memo;
    @Column(name="psdevslnid")
    private String psdevslnid;
    @Column(name="psdevslnsysid")
    private String psdevslnsysid;
    @Column(name="psdevslnsysname")
    private String psdevslnsysname;
    @Column(name="psdevslnsysrefid")
    private String psdevslnsysrefid;
    @Column(name="psdevslnsysreflinkid")
    private String psdevslnsysreflinkid;
    @Column(name="psdevslnsysreflinkname")
    private String psdevslnsysreflinkname;
    @Column(name="psdevslnsysrefname")
    private String psdevslnsysrefname;
    @Column(name="psdevslnsyssrvid")
    private String psdevslnsyssrvid;
    @Column(name="psdevslnsyssrvname")
    private String psdevslnsyssrvname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objLinkPSDevcCenterLock = new Integer(1);
    private PSDevCenter linkpsdevccenter = null;
    private Integer objPSDevSlnSysRefLock = new Integer(1);
    private PSDevSlnSysRef psdevslnsysref = null;
    private Integer objPSDevSlnSysSrvLock = new Integer(1);
    private PSDevSlnSysSrv psdevslnsyssrv = null;
    private Integer objPSDevSlnSysLock = new Integer(1);
    private PSDevSlnSys psdevslnsys = null;

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

    public void setBeginTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBeginTime(timestamp);
            return;
        }
        this.begintime = timestamp;
        this.begintimeDirtyFlag = true;
    }

    public Timestamp getBeginTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBeginTime();
        }
        return this.begintime;
    }

    public boolean isBeginTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBeginTimeDirty();
        }
        return this.begintimeDirtyFlag;
    }

    public void resetBeginTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBeginTime();
            return;
        }
        this.begintimeDirtyFlag = false;
        this.begintime = null;
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

    public void setEndTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEndTime(timestamp);
            return;
        }
        this.endtime = timestamp;
        this.endtimeDirtyFlag = true;
    }

    public Timestamp getEndTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEndTime();
        }
        return this.endtime;
    }

    public boolean isEndTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEndTimeDirty();
        }
        return this.endtimeDirtyFlag;
    }

    public void resetEndTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEndTime();
            return;
        }
        this.endtimeDirtyFlag = false;
        this.endtime = null;
    }

    public void setLinkPSDevCenterId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLinkPSDevCenterId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.linkpsdevcenterid = string;
        this.linkpsdevcenteridDirtyFlag = true;
    }

    public String getLinkPSDevCenterId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLinkPSDevCenterId();
        }
        return this.linkpsdevcenterid;
    }

    public boolean isLinkPSDevCenterIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLinkPSDevCenterIdDirty();
        }
        return this.linkpsdevcenteridDirtyFlag;
    }

    public void resetLinkPSDevCenterId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLinkPSDevCenterId();
            return;
        }
        this.linkpsdevcenteridDirtyFlag = false;
        this.linkpsdevcenterid = null;
    }

    public void setLinkPSDevCenterName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLinkPSDevCenterName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.linkpsdevcentername = string;
        this.linkpsdevcenternameDirtyFlag = true;
    }

    public String getLinkPSDevCenterName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLinkPSDevCenterName();
        }
        return this.linkpsdevcentername;
    }

    public boolean isLinkPSDevCenterNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLinkPSDevCenterNameDirty();
        }
        return this.linkpsdevcenternameDirtyFlag;
    }

    public void resetLinkPSDevCenterName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLinkPSDevCenterName();
            return;
        }
        this.linkpsdevcenternameDirtyFlag = false;
        this.linkpsdevcentername = null;
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

    public void setLinkState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLinkState(n);
            return;
        }
        this.linkstate = n;
        this.linkstateDirtyFlag = true;
    }

    public Integer getLinkState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLinkState();
        }
        return this.linkstate;
    }

    public boolean isLinkStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLinkStateDirty();
        }
        return this.linkstateDirtyFlag;
    }

    public void resetLinkState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLinkState();
            return;
        }
        this.linkstateDirtyFlag = false;
        this.linkstate = null;
    }

    public void setLinkStateInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLinkStateInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.linkstateinfo = string;
        this.linkstateinfoDirtyFlag = true;
    }

    public String getLinkStateInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLinkStateInfo();
        }
        return this.linkstateinfo;
    }

    public boolean isLinkStateInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLinkStateInfoDirty();
        }
        return this.linkstateinfoDirtyFlag;
    }

    public void resetLinkStateInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLinkStateInfo();
            return;
        }
        this.linkstateinfoDirtyFlag = false;
        this.linkstateinfo = null;
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

    public void setPSDevSlnSysRefId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysRefId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysrefid = string;
        this.psdevslnsysrefidDirtyFlag = true;
    }

    public String getPSDevSlnSysRefId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysRefId();
        }
        return this.psdevslnsysrefid;
    }

    public boolean isPSDevSlnSysRefIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysRefIdDirty();
        }
        return this.psdevslnsysrefidDirtyFlag;
    }

    public void resetPSDevSlnSysRefId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysRefId();
            return;
        }
        this.psdevslnsysrefidDirtyFlag = false;
        this.psdevslnsysrefid = null;
    }

    public void setPSDevSlnSysRefLinkId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysRefLinkId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysreflinkid = string;
        this.psdevslnsysreflinkidDirtyFlag = true;
    }

    public String getPSDevSlnSysRefLinkId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysRefLinkId();
        }
        return this.psdevslnsysreflinkid;
    }

    public boolean isPSDevSlnSysRefLinkIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysRefLinkIdDirty();
        }
        return this.psdevslnsysreflinkidDirtyFlag;
    }

    public void resetPSDevSlnSysRefLinkId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysRefLinkId();
            return;
        }
        this.psdevslnsysreflinkidDirtyFlag = false;
        this.psdevslnsysreflinkid = null;
    }

    public void setPSDevSlnSysRefLinkName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysRefLinkName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysreflinkname = string;
        this.psdevslnsysreflinknameDirtyFlag = true;
    }

    public String getPSDevSlnSysRefLinkName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysRefLinkName();
        }
        return this.psdevslnsysreflinkname;
    }

    public boolean isPSDevSlnSysRefLinkNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysRefLinkNameDirty();
        }
        return this.psdevslnsysreflinknameDirtyFlag;
    }

    public void resetPSDevSlnSysRefLinkName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysRefLinkName();
            return;
        }
        this.psdevslnsysreflinknameDirtyFlag = false;
        this.psdevslnsysreflinkname = null;
    }

    public void setPSDevSlnSysRefName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysRefName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysrefname = string;
        this.psdevslnsysrefnameDirtyFlag = true;
    }

    public String getPSDevSlnSysRefName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysRefName();
        }
        return this.psdevslnsysrefname;
    }

    public boolean isPSDevSlnSysRefNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysRefNameDirty();
        }
        return this.psdevslnsysrefnameDirtyFlag;
    }

    public void resetPSDevSlnSysRefName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysRefName();
            return;
        }
        this.psdevslnsysrefnameDirtyFlag = false;
        this.psdevslnsysrefname = null;
    }

    public void setPSDevSlnSysSrvId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysSrvId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsyssrvid = string;
        this.psdevslnsyssrvidDirtyFlag = true;
    }

    public String getPSDevSlnSysSrvId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysSrvId();
        }
        return this.psdevslnsyssrvid;
    }

    public boolean isPSDevSlnSysSrvIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysSrvIdDirty();
        }
        return this.psdevslnsyssrvidDirtyFlag;
    }

    public void resetPSDevSlnSysSrvId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysSrvId();
            return;
        }
        this.psdevslnsyssrvidDirtyFlag = false;
        this.psdevslnsyssrvid = null;
    }

    public void setPSDevSlnSysSrvName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysSrvName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsyssrvname = string;
        this.psdevslnsyssrvnameDirtyFlag = true;
    }

    public String getPSDevSlnSysSrvName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysSrvName();
        }
        return this.psdevslnsyssrvname;
    }

    public boolean isPSDevSlnSysSrvNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysSrvNameDirty();
        }
        return this.psdevslnsyssrvnameDirtyFlag;
    }

    public void resetPSDevSlnSysSrvName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysSrvName();
            return;
        }
        this.psdevslnsyssrvnameDirtyFlag = false;
        this.psdevslnsyssrvname = null;
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
        PSDevSlnSysRefLinkBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevSlnSysRefLinkBase pSDevSlnSysRefLinkBase) {
        pSDevSlnSysRefLinkBase.resetAccessToken();
        pSDevSlnSysRefLinkBase.resetBeginTime();
        pSDevSlnSysRefLinkBase.resetCreateDate();
        pSDevSlnSysRefLinkBase.resetCreateMan();
        pSDevSlnSysRefLinkBase.resetEndTime();
        pSDevSlnSysRefLinkBase.resetLinkPSDevCenterId();
        pSDevSlnSysRefLinkBase.resetLinkPSDevCenterName();
        pSDevSlnSysRefLinkBase.resetLinkRepMsg();
        pSDevSlnSysRefLinkBase.resetLinkReqMsg();
        pSDevSlnSysRefLinkBase.resetLinkState();
        pSDevSlnSysRefLinkBase.resetLinkStateInfo();
        pSDevSlnSysRefLinkBase.resetMemo();
        pSDevSlnSysRefLinkBase.resetPSDevSlnId();
        pSDevSlnSysRefLinkBase.resetPSDevSlnSysId();
        pSDevSlnSysRefLinkBase.resetPSDevSlnSysName();
        pSDevSlnSysRefLinkBase.resetPSDevSlnSysRefId();
        pSDevSlnSysRefLinkBase.resetPSDevSlnSysRefLinkId();
        pSDevSlnSysRefLinkBase.resetPSDevSlnSysRefLinkName();
        pSDevSlnSysRefLinkBase.resetPSDevSlnSysRefName();
        pSDevSlnSysRefLinkBase.resetPSDevSlnSysSrvId();
        pSDevSlnSysRefLinkBase.resetPSDevSlnSysSrvName();
        pSDevSlnSysRefLinkBase.resetUpdateDate();
        pSDevSlnSysRefLinkBase.resetUpdateMan();
        pSDevSlnSysRefLinkBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAccessTokenDirty()) {
            hashMap.put(FIELD_ACCESSTOKEN, this.getAccessToken());
        }
        if (!bl || this.isBeginTimeDirty()) {
            hashMap.put(FIELD_BEGINTIME, this.getBeginTime());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isEndTimeDirty()) {
            hashMap.put(FIELD_ENDTIME, this.getEndTime());
        }
        if (!bl || this.isLinkPSDevCenterIdDirty()) {
            hashMap.put(FIELD_LINKPSDEVCENTERID, this.getLinkPSDevCenterId());
        }
        if (!bl || this.isLinkPSDevCenterNameDirty()) {
            hashMap.put(FIELD_LINKPSDEVCENTERNAME, this.getLinkPSDevCenterName());
        }
        if (!bl || this.isLinkRepMsgDirty()) {
            hashMap.put(FIELD_LINKREPMSG, this.getLinkRepMsg());
        }
        if (!bl || this.isLinkReqMsgDirty()) {
            hashMap.put(FIELD_LINKREQMSG, this.getLinkReqMsg());
        }
        if (!bl || this.isLinkStateDirty()) {
            hashMap.put(FIELD_LINKSTATE, this.getLinkState());
        }
        if (!bl || this.isLinkStateInfoDirty()) {
            hashMap.put(FIELD_LINKSTATEINFO, this.getLinkStateInfo());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDevSlnIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNID, this.getPSDevSlnId());
        }
        if (!bl || this.isPSDevSlnSysIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSID, this.getPSDevSlnSysId());
        }
        if (!bl || this.isPSDevSlnSysNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSNAME, this.getPSDevSlnSysName());
        }
        if (!bl || this.isPSDevSlnSysRefIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSREFID, this.getPSDevSlnSysRefId());
        }
        if (!bl || this.isPSDevSlnSysRefLinkIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSREFLINKID, this.getPSDevSlnSysRefLinkId());
        }
        if (!bl || this.isPSDevSlnSysRefLinkNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSREFLINKNAME, this.getPSDevSlnSysRefLinkName());
        }
        if (!bl || this.isPSDevSlnSysRefNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSREFNAME, this.getPSDevSlnSysRefName());
        }
        if (!bl || this.isPSDevSlnSysSrvIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSSRVID, this.getPSDevSlnSysSrvId());
        }
        if (!bl || this.isPSDevSlnSysSrvNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSSRVNAME, this.getPSDevSlnSysSrvName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
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
        return PSDevSlnSysRefLinkBase.get(this, n);
    }

    private static Object get(PSDevSlnSysRefLinkBase pSDevSlnSysRefLinkBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysRefLinkBase.getAccessToken();
            }
            case 1: {
                return pSDevSlnSysRefLinkBase.getBeginTime();
            }
            case 2: {
                return pSDevSlnSysRefLinkBase.getCreateDate();
            }
            case 3: {
                return pSDevSlnSysRefLinkBase.getCreateMan();
            }
            case 4: {
                return pSDevSlnSysRefLinkBase.getEndTime();
            }
            case 5: {
                return pSDevSlnSysRefLinkBase.getLinkPSDevCenterId();
            }
            case 6: {
                return pSDevSlnSysRefLinkBase.getLinkPSDevCenterName();
            }
            case 7: {
                return pSDevSlnSysRefLinkBase.getLinkRepMsg();
            }
            case 8: {
                return pSDevSlnSysRefLinkBase.getLinkReqMsg();
            }
            case 9: {
                return pSDevSlnSysRefLinkBase.getLinkState();
            }
            case 10: {
                return pSDevSlnSysRefLinkBase.getLinkStateInfo();
            }
            case 11: {
                return pSDevSlnSysRefLinkBase.getMemo();
            }
            case 12: {
                return pSDevSlnSysRefLinkBase.getPSDevSlnId();
            }
            case 13: {
                return pSDevSlnSysRefLinkBase.getPSDevSlnSysId();
            }
            case 14: {
                return pSDevSlnSysRefLinkBase.getPSDevSlnSysName();
            }
            case 15: {
                return pSDevSlnSysRefLinkBase.getPSDevSlnSysRefId();
            }
            case 16: {
                return pSDevSlnSysRefLinkBase.getPSDevSlnSysRefLinkId();
            }
            case 17: {
                return pSDevSlnSysRefLinkBase.getPSDevSlnSysRefLinkName();
            }
            case 18: {
                return pSDevSlnSysRefLinkBase.getPSDevSlnSysRefName();
            }
            case 19: {
                return pSDevSlnSysRefLinkBase.getPSDevSlnSysSrvId();
            }
            case 20: {
                return pSDevSlnSysRefLinkBase.getPSDevSlnSysSrvName();
            }
            case 21: {
                return pSDevSlnSysRefLinkBase.getUpdateDate();
            }
            case 22: {
                return pSDevSlnSysRefLinkBase.getUpdateMan();
            }
            case 23: {
                return pSDevSlnSysRefLinkBase.getValidFlag();
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
        PSDevSlnSysRefLinkBase.set(this, n, object);
    }

    private static void set(PSDevSlnSysRefLinkBase pSDevSlnSysRefLinkBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnSysRefLinkBase.setAccessToken(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDevSlnSysRefLinkBase.setBeginTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDevSlnSysRefLinkBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSDevSlnSysRefLinkBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDevSlnSysRefLinkBase.setEndTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 5: {
                pSDevSlnSysRefLinkBase.setLinkPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDevSlnSysRefLinkBase.setLinkPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDevSlnSysRefLinkBase.setLinkRepMsg(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDevSlnSysRefLinkBase.setLinkReqMsg(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDevSlnSysRefLinkBase.setLinkState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSDevSlnSysRefLinkBase.setLinkStateInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDevSlnSysRefLinkBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDevSlnSysRefLinkBase.setPSDevSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDevSlnSysRefLinkBase.setPSDevSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDevSlnSysRefLinkBase.setPSDevSlnSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDevSlnSysRefLinkBase.setPSDevSlnSysRefId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDevSlnSysRefLinkBase.setPSDevSlnSysRefLinkId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDevSlnSysRefLinkBase.setPSDevSlnSysRefLinkName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDevSlnSysRefLinkBase.setPSDevSlnSysRefName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDevSlnSysRefLinkBase.setPSDevSlnSysSrvId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDevSlnSysRefLinkBase.setPSDevSlnSysSrvName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDevSlnSysRefLinkBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 22: {
                pSDevSlnSysRefLinkBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDevSlnSysRefLinkBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDevSlnSysRefLinkBase.isNull(this, n);
    }

    private static boolean isNull(PSDevSlnSysRefLinkBase pSDevSlnSysRefLinkBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysRefLinkBase.getAccessToken() == null;
            }
            case 1: {
                return pSDevSlnSysRefLinkBase.getBeginTime() == null;
            }
            case 2: {
                return pSDevSlnSysRefLinkBase.getCreateDate() == null;
            }
            case 3: {
                return pSDevSlnSysRefLinkBase.getCreateMan() == null;
            }
            case 4: {
                return pSDevSlnSysRefLinkBase.getEndTime() == null;
            }
            case 5: {
                return pSDevSlnSysRefLinkBase.getLinkPSDevCenterId() == null;
            }
            case 6: {
                return pSDevSlnSysRefLinkBase.getLinkPSDevCenterName() == null;
            }
            case 7: {
                return pSDevSlnSysRefLinkBase.getLinkRepMsg() == null;
            }
            case 8: {
                return pSDevSlnSysRefLinkBase.getLinkReqMsg() == null;
            }
            case 9: {
                return pSDevSlnSysRefLinkBase.getLinkState() == null;
            }
            case 10: {
                return pSDevSlnSysRefLinkBase.getLinkStateInfo() == null;
            }
            case 11: {
                return pSDevSlnSysRefLinkBase.getMemo() == null;
            }
            case 12: {
                return pSDevSlnSysRefLinkBase.getPSDevSlnId() == null;
            }
            case 13: {
                return pSDevSlnSysRefLinkBase.getPSDevSlnSysId() == null;
            }
            case 14: {
                return pSDevSlnSysRefLinkBase.getPSDevSlnSysName() == null;
            }
            case 15: {
                return pSDevSlnSysRefLinkBase.getPSDevSlnSysRefId() == null;
            }
            case 16: {
                return pSDevSlnSysRefLinkBase.getPSDevSlnSysRefLinkId() == null;
            }
            case 17: {
                return pSDevSlnSysRefLinkBase.getPSDevSlnSysRefLinkName() == null;
            }
            case 18: {
                return pSDevSlnSysRefLinkBase.getPSDevSlnSysRefName() == null;
            }
            case 19: {
                return pSDevSlnSysRefLinkBase.getPSDevSlnSysSrvId() == null;
            }
            case 20: {
                return pSDevSlnSysRefLinkBase.getPSDevSlnSysSrvName() == null;
            }
            case 21: {
                return pSDevSlnSysRefLinkBase.getUpdateDate() == null;
            }
            case 22: {
                return pSDevSlnSysRefLinkBase.getUpdateMan() == null;
            }
            case 23: {
                return pSDevSlnSysRefLinkBase.getValidFlag() == null;
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
        return PSDevSlnSysRefLinkBase.contains(this, n);
    }

    private static boolean contains(PSDevSlnSysRefLinkBase pSDevSlnSysRefLinkBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysRefLinkBase.isAccessTokenDirty();
            }
            case 1: {
                return pSDevSlnSysRefLinkBase.isBeginTimeDirty();
            }
            case 2: {
                return pSDevSlnSysRefLinkBase.isCreateDateDirty();
            }
            case 3: {
                return pSDevSlnSysRefLinkBase.isCreateManDirty();
            }
            case 4: {
                return pSDevSlnSysRefLinkBase.isEndTimeDirty();
            }
            case 5: {
                return pSDevSlnSysRefLinkBase.isLinkPSDevCenterIdDirty();
            }
            case 6: {
                return pSDevSlnSysRefLinkBase.isLinkPSDevCenterNameDirty();
            }
            case 7: {
                return pSDevSlnSysRefLinkBase.isLinkRepMsgDirty();
            }
            case 8: {
                return pSDevSlnSysRefLinkBase.isLinkReqMsgDirty();
            }
            case 9: {
                return pSDevSlnSysRefLinkBase.isLinkStateDirty();
            }
            case 10: {
                return pSDevSlnSysRefLinkBase.isLinkStateInfoDirty();
            }
            case 11: {
                return pSDevSlnSysRefLinkBase.isMemoDirty();
            }
            case 12: {
                return pSDevSlnSysRefLinkBase.isPSDevSlnIdDirty();
            }
            case 13: {
                return pSDevSlnSysRefLinkBase.isPSDevSlnSysIdDirty();
            }
            case 14: {
                return pSDevSlnSysRefLinkBase.isPSDevSlnSysNameDirty();
            }
            case 15: {
                return pSDevSlnSysRefLinkBase.isPSDevSlnSysRefIdDirty();
            }
            case 16: {
                return pSDevSlnSysRefLinkBase.isPSDevSlnSysRefLinkIdDirty();
            }
            case 17: {
                return pSDevSlnSysRefLinkBase.isPSDevSlnSysRefLinkNameDirty();
            }
            case 18: {
                return pSDevSlnSysRefLinkBase.isPSDevSlnSysRefNameDirty();
            }
            case 19: {
                return pSDevSlnSysRefLinkBase.isPSDevSlnSysSrvIdDirty();
            }
            case 20: {
                return pSDevSlnSysRefLinkBase.isPSDevSlnSysSrvNameDirty();
            }
            case 21: {
                return pSDevSlnSysRefLinkBase.isUpdateDateDirty();
            }
            case 22: {
                return pSDevSlnSysRefLinkBase.isUpdateManDirty();
            }
            case 23: {
                return pSDevSlnSysRefLinkBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevSlnSysRefLinkBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevSlnSysRefLinkBase pSDevSlnSysRefLinkBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevSlnSysRefLinkBase.getAccessToken() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"accesstoken", (Object)PSDevSlnSysRefLinkBase.getJSONValue((Object)pSDevSlnSysRefLinkBase.getAccessToken()), (boolean)false);
        }
        if (bl || pSDevSlnSysRefLinkBase.getBeginTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"begintime", (Object)PSDevSlnSysRefLinkBase.getJSONValue((Object)pSDevSlnSysRefLinkBase.getBeginTime()), (boolean)false);
        }
        if (bl || pSDevSlnSysRefLinkBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevSlnSysRefLinkBase.getJSONValue((Object)pSDevSlnSysRefLinkBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevSlnSysRefLinkBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevSlnSysRefLinkBase.getJSONValue((Object)pSDevSlnSysRefLinkBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevSlnSysRefLinkBase.getEndTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"endtime", (Object)PSDevSlnSysRefLinkBase.getJSONValue((Object)pSDevSlnSysRefLinkBase.getEndTime()), (boolean)false);
        }
        if (bl || pSDevSlnSysRefLinkBase.getLinkPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"linkpsdevcenterid", (Object)PSDevSlnSysRefLinkBase.getJSONValue((Object)pSDevSlnSysRefLinkBase.getLinkPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDevSlnSysRefLinkBase.getLinkPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"linkpsdevcentername", (Object)PSDevSlnSysRefLinkBase.getJSONValue((Object)pSDevSlnSysRefLinkBase.getLinkPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDevSlnSysRefLinkBase.getLinkRepMsg() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"linkrepmsg", (Object)PSDevSlnSysRefLinkBase.getJSONValue((Object)pSDevSlnSysRefLinkBase.getLinkRepMsg()), (boolean)false);
        }
        if (bl || pSDevSlnSysRefLinkBase.getLinkReqMsg() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"linkreqmsg", (Object)PSDevSlnSysRefLinkBase.getJSONValue((Object)pSDevSlnSysRefLinkBase.getLinkReqMsg()), (boolean)false);
        }
        if (bl || pSDevSlnSysRefLinkBase.getLinkState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"linkstate", (Object)PSDevSlnSysRefLinkBase.getJSONValue((Object)pSDevSlnSysRefLinkBase.getLinkState()), (boolean)false);
        }
        if (bl || pSDevSlnSysRefLinkBase.getLinkStateInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"linkstateinfo", (Object)PSDevSlnSysRefLinkBase.getJSONValue((Object)pSDevSlnSysRefLinkBase.getLinkStateInfo()), (boolean)false);
        }
        if (bl || pSDevSlnSysRefLinkBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDevSlnSysRefLinkBase.getJSONValue((Object)pSDevSlnSysRefLinkBase.getMemo()), (boolean)false);
        }
        if (bl || pSDevSlnSysRefLinkBase.getPSDevSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnid", (Object)PSDevSlnSysRefLinkBase.getJSONValue((Object)pSDevSlnSysRefLinkBase.getPSDevSlnId()), (boolean)false);
        }
        if (bl || pSDevSlnSysRefLinkBase.getPSDevSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysid", (Object)PSDevSlnSysRefLinkBase.getJSONValue((Object)pSDevSlnSysRefLinkBase.getPSDevSlnSysId()), (boolean)false);
        }
        if (bl || pSDevSlnSysRefLinkBase.getPSDevSlnSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysname", (Object)PSDevSlnSysRefLinkBase.getJSONValue((Object)pSDevSlnSysRefLinkBase.getPSDevSlnSysName()), (boolean)false);
        }
        if (bl || pSDevSlnSysRefLinkBase.getPSDevSlnSysRefId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysrefid", (Object)PSDevSlnSysRefLinkBase.getJSONValue((Object)pSDevSlnSysRefLinkBase.getPSDevSlnSysRefId()), (boolean)false);
        }
        if (bl || pSDevSlnSysRefLinkBase.getPSDevSlnSysRefLinkId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysreflinkid", (Object)PSDevSlnSysRefLinkBase.getJSONValue((Object)pSDevSlnSysRefLinkBase.getPSDevSlnSysRefLinkId()), (boolean)false);
        }
        if (bl || pSDevSlnSysRefLinkBase.getPSDevSlnSysRefLinkName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysreflinkname", (Object)PSDevSlnSysRefLinkBase.getJSONValue((Object)pSDevSlnSysRefLinkBase.getPSDevSlnSysRefLinkName()), (boolean)false);
        }
        if (bl || pSDevSlnSysRefLinkBase.getPSDevSlnSysRefName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysrefname", (Object)PSDevSlnSysRefLinkBase.getJSONValue((Object)pSDevSlnSysRefLinkBase.getPSDevSlnSysRefName()), (boolean)false);
        }
        if (bl || pSDevSlnSysRefLinkBase.getPSDevSlnSysSrvId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsyssrvid", (Object)PSDevSlnSysRefLinkBase.getJSONValue((Object)pSDevSlnSysRefLinkBase.getPSDevSlnSysSrvId()), (boolean)false);
        }
        if (bl || pSDevSlnSysRefLinkBase.getPSDevSlnSysSrvName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsyssrvname", (Object)PSDevSlnSysRefLinkBase.getJSONValue((Object)pSDevSlnSysRefLinkBase.getPSDevSlnSysSrvName()), (boolean)false);
        }
        if (bl || pSDevSlnSysRefLinkBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevSlnSysRefLinkBase.getJSONValue((Object)pSDevSlnSysRefLinkBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevSlnSysRefLinkBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevSlnSysRefLinkBase.getJSONValue((Object)pSDevSlnSysRefLinkBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDevSlnSysRefLinkBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDevSlnSysRefLinkBase.getJSONValue((Object)pSDevSlnSysRefLinkBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevSlnSysRefLinkBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevSlnSysRefLinkBase pSDevSlnSysRefLinkBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevSlnSysRefLinkBase.getAccessToken() != null) {
            object = pSDevSlnSysRefLinkBase.getAccessToken();
            xmlNode.setAttribute(FIELD_ACCESSTOKEN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysRefLinkBase.getBeginTime() != null) {
            object = pSDevSlnSysRefLinkBase.getBeginTime();
            xmlNode.setAttribute(FIELD_BEGINTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysRefLinkBase.getCreateDate() != null) {
            object = pSDevSlnSysRefLinkBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysRefLinkBase.getCreateMan() != null) {
            object = pSDevSlnSysRefLinkBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysRefLinkBase.getEndTime() != null) {
            object = pSDevSlnSysRefLinkBase.getEndTime();
            xmlNode.setAttribute(FIELD_ENDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysRefLinkBase.getLinkPSDevCenterId() != null) {
            object = pSDevSlnSysRefLinkBase.getLinkPSDevCenterId();
            xmlNode.setAttribute(FIELD_LINKPSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysRefLinkBase.getLinkPSDevCenterName() != null) {
            object = pSDevSlnSysRefLinkBase.getLinkPSDevCenterName();
            xmlNode.setAttribute(FIELD_LINKPSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysRefLinkBase.getLinkRepMsg() != null) {
            object = pSDevSlnSysRefLinkBase.getLinkRepMsg();
            xmlNode.setAttribute(FIELD_LINKREPMSG, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysRefLinkBase.getLinkReqMsg() != null) {
            object = pSDevSlnSysRefLinkBase.getLinkReqMsg();
            xmlNode.setAttribute(FIELD_LINKREQMSG, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysRefLinkBase.getLinkState() != null) {
            object = pSDevSlnSysRefLinkBase.getLinkState();
            xmlNode.setAttribute(FIELD_LINKSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnSysRefLinkBase.getLinkStateInfo() != null) {
            object = pSDevSlnSysRefLinkBase.getLinkStateInfo();
            xmlNode.setAttribute(FIELD_LINKSTATEINFO, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysRefLinkBase.getMemo() != null) {
            object = pSDevSlnSysRefLinkBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysRefLinkBase.getPSDevSlnId() != null) {
            object = pSDevSlnSysRefLinkBase.getPSDevSlnId();
            xmlNode.setAttribute(FIELD_PSDEVSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysRefLinkBase.getPSDevSlnSysId() != null) {
            object = pSDevSlnSysRefLinkBase.getPSDevSlnSysId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysRefLinkBase.getPSDevSlnSysName() != null) {
            object = pSDevSlnSysRefLinkBase.getPSDevSlnSysName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysRefLinkBase.getPSDevSlnSysRefId() != null) {
            object = pSDevSlnSysRefLinkBase.getPSDevSlnSysRefId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSREFID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysRefLinkBase.getPSDevSlnSysRefLinkId() != null) {
            object = pSDevSlnSysRefLinkBase.getPSDevSlnSysRefLinkId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSREFLINKID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysRefLinkBase.getPSDevSlnSysRefLinkName() != null) {
            object = pSDevSlnSysRefLinkBase.getPSDevSlnSysRefLinkName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSREFLINKNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysRefLinkBase.getPSDevSlnSysRefName() != null) {
            object = pSDevSlnSysRefLinkBase.getPSDevSlnSysRefName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSREFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysRefLinkBase.getPSDevSlnSysSrvId() != null) {
            object = pSDevSlnSysRefLinkBase.getPSDevSlnSysSrvId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSSRVID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysRefLinkBase.getPSDevSlnSysSrvName() != null) {
            object = pSDevSlnSysRefLinkBase.getPSDevSlnSysSrvName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSSRVNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysRefLinkBase.getUpdateDate() != null) {
            object = pSDevSlnSysRefLinkBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysRefLinkBase.getUpdateMan() != null) {
            object = pSDevSlnSysRefLinkBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysRefLinkBase.getValidFlag() != null) {
            object = pSDevSlnSysRefLinkBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevSlnSysRefLinkBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevSlnSysRefLinkBase pSDevSlnSysRefLinkBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevSlnSysRefLinkBase.isAccessTokenDirty() && (bl || pSDevSlnSysRefLinkBase.getAccessToken() != null)) {
            iDataObject.set(FIELD_ACCESSTOKEN, (Object)pSDevSlnSysRefLinkBase.getAccessToken());
        }
        if (pSDevSlnSysRefLinkBase.isBeginTimeDirty() && (bl || pSDevSlnSysRefLinkBase.getBeginTime() != null)) {
            iDataObject.set(FIELD_BEGINTIME, (Object)pSDevSlnSysRefLinkBase.getBeginTime());
        }
        if (pSDevSlnSysRefLinkBase.isCreateDateDirty() && (bl || pSDevSlnSysRefLinkBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevSlnSysRefLinkBase.getCreateDate());
        }
        if (pSDevSlnSysRefLinkBase.isCreateManDirty() && (bl || pSDevSlnSysRefLinkBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevSlnSysRefLinkBase.getCreateMan());
        }
        if (pSDevSlnSysRefLinkBase.isEndTimeDirty() && (bl || pSDevSlnSysRefLinkBase.getEndTime() != null)) {
            iDataObject.set(FIELD_ENDTIME, (Object)pSDevSlnSysRefLinkBase.getEndTime());
        }
        if (pSDevSlnSysRefLinkBase.isLinkPSDevCenterIdDirty() && (bl || pSDevSlnSysRefLinkBase.getLinkPSDevCenterId() != null)) {
            iDataObject.set(FIELD_LINKPSDEVCENTERID, (Object)pSDevSlnSysRefLinkBase.getLinkPSDevCenterId());
        }
        if (pSDevSlnSysRefLinkBase.isLinkPSDevCenterNameDirty() && (bl || pSDevSlnSysRefLinkBase.getLinkPSDevCenterName() != null)) {
            iDataObject.set(FIELD_LINKPSDEVCENTERNAME, (Object)pSDevSlnSysRefLinkBase.getLinkPSDevCenterName());
        }
        if (pSDevSlnSysRefLinkBase.isLinkRepMsgDirty() && (bl || pSDevSlnSysRefLinkBase.getLinkRepMsg() != null)) {
            iDataObject.set(FIELD_LINKREPMSG, (Object)pSDevSlnSysRefLinkBase.getLinkRepMsg());
        }
        if (pSDevSlnSysRefLinkBase.isLinkReqMsgDirty() && (bl || pSDevSlnSysRefLinkBase.getLinkReqMsg() != null)) {
            iDataObject.set(FIELD_LINKREQMSG, (Object)pSDevSlnSysRefLinkBase.getLinkReqMsg());
        }
        if (pSDevSlnSysRefLinkBase.isLinkStateDirty() && (bl || pSDevSlnSysRefLinkBase.getLinkState() != null)) {
            iDataObject.set(FIELD_LINKSTATE, (Object)pSDevSlnSysRefLinkBase.getLinkState());
        }
        if (pSDevSlnSysRefLinkBase.isLinkStateInfoDirty() && (bl || pSDevSlnSysRefLinkBase.getLinkStateInfo() != null)) {
            iDataObject.set(FIELD_LINKSTATEINFO, (Object)pSDevSlnSysRefLinkBase.getLinkStateInfo());
        }
        if (pSDevSlnSysRefLinkBase.isMemoDirty() && (bl || pSDevSlnSysRefLinkBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDevSlnSysRefLinkBase.getMemo());
        }
        if (pSDevSlnSysRefLinkBase.isPSDevSlnIdDirty() && (bl || pSDevSlnSysRefLinkBase.getPSDevSlnId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNID, (Object)pSDevSlnSysRefLinkBase.getPSDevSlnId());
        }
        if (pSDevSlnSysRefLinkBase.isPSDevSlnSysIdDirty() && (bl || pSDevSlnSysRefLinkBase.getPSDevSlnSysId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSID, (Object)pSDevSlnSysRefLinkBase.getPSDevSlnSysId());
        }
        if (pSDevSlnSysRefLinkBase.isPSDevSlnSysNameDirty() && (bl || pSDevSlnSysRefLinkBase.getPSDevSlnSysName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSNAME, (Object)pSDevSlnSysRefLinkBase.getPSDevSlnSysName());
        }
        if (pSDevSlnSysRefLinkBase.isPSDevSlnSysRefIdDirty() && (bl || pSDevSlnSysRefLinkBase.getPSDevSlnSysRefId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSREFID, (Object)pSDevSlnSysRefLinkBase.getPSDevSlnSysRefId());
        }
        if (pSDevSlnSysRefLinkBase.isPSDevSlnSysRefLinkIdDirty() && (bl || pSDevSlnSysRefLinkBase.getPSDevSlnSysRefLinkId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSREFLINKID, (Object)pSDevSlnSysRefLinkBase.getPSDevSlnSysRefLinkId());
        }
        if (pSDevSlnSysRefLinkBase.isPSDevSlnSysRefLinkNameDirty() && (bl || pSDevSlnSysRefLinkBase.getPSDevSlnSysRefLinkName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSREFLINKNAME, (Object)pSDevSlnSysRefLinkBase.getPSDevSlnSysRefLinkName());
        }
        if (pSDevSlnSysRefLinkBase.isPSDevSlnSysRefNameDirty() && (bl || pSDevSlnSysRefLinkBase.getPSDevSlnSysRefName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSREFNAME, (Object)pSDevSlnSysRefLinkBase.getPSDevSlnSysRefName());
        }
        if (pSDevSlnSysRefLinkBase.isPSDevSlnSysSrvIdDirty() && (bl || pSDevSlnSysRefLinkBase.getPSDevSlnSysSrvId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSSRVID, (Object)pSDevSlnSysRefLinkBase.getPSDevSlnSysSrvId());
        }
        if (pSDevSlnSysRefLinkBase.isPSDevSlnSysSrvNameDirty() && (bl || pSDevSlnSysRefLinkBase.getPSDevSlnSysSrvName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSSRVNAME, (Object)pSDevSlnSysRefLinkBase.getPSDevSlnSysSrvName());
        }
        if (pSDevSlnSysRefLinkBase.isUpdateDateDirty() && (bl || pSDevSlnSysRefLinkBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevSlnSysRefLinkBase.getUpdateDate());
        }
        if (pSDevSlnSysRefLinkBase.isUpdateManDirty() && (bl || pSDevSlnSysRefLinkBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevSlnSysRefLinkBase.getUpdateMan());
        }
        if (pSDevSlnSysRefLinkBase.isValidFlagDirty() && (bl || pSDevSlnSysRefLinkBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDevSlnSysRefLinkBase.getValidFlag());
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
        return PSDevSlnSysRefLinkBase.remove(this, n);
    }

    private static boolean remove(PSDevSlnSysRefLinkBase pSDevSlnSysRefLinkBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnSysRefLinkBase.resetAccessToken();
                return true;
            }
            case 1: {
                pSDevSlnSysRefLinkBase.resetBeginTime();
                return true;
            }
            case 2: {
                pSDevSlnSysRefLinkBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSDevSlnSysRefLinkBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSDevSlnSysRefLinkBase.resetEndTime();
                return true;
            }
            case 5: {
                pSDevSlnSysRefLinkBase.resetLinkPSDevCenterId();
                return true;
            }
            case 6: {
                pSDevSlnSysRefLinkBase.resetLinkPSDevCenterName();
                return true;
            }
            case 7: {
                pSDevSlnSysRefLinkBase.resetLinkRepMsg();
                return true;
            }
            case 8: {
                pSDevSlnSysRefLinkBase.resetLinkReqMsg();
                return true;
            }
            case 9: {
                pSDevSlnSysRefLinkBase.resetLinkState();
                return true;
            }
            case 10: {
                pSDevSlnSysRefLinkBase.resetLinkStateInfo();
                return true;
            }
            case 11: {
                pSDevSlnSysRefLinkBase.resetMemo();
                return true;
            }
            case 12: {
                pSDevSlnSysRefLinkBase.resetPSDevSlnId();
                return true;
            }
            case 13: {
                pSDevSlnSysRefLinkBase.resetPSDevSlnSysId();
                return true;
            }
            case 14: {
                pSDevSlnSysRefLinkBase.resetPSDevSlnSysName();
                return true;
            }
            case 15: {
                pSDevSlnSysRefLinkBase.resetPSDevSlnSysRefId();
                return true;
            }
            case 16: {
                pSDevSlnSysRefLinkBase.resetPSDevSlnSysRefLinkId();
                return true;
            }
            case 17: {
                pSDevSlnSysRefLinkBase.resetPSDevSlnSysRefLinkName();
                return true;
            }
            case 18: {
                pSDevSlnSysRefLinkBase.resetPSDevSlnSysRefName();
                return true;
            }
            case 19: {
                pSDevSlnSysRefLinkBase.resetPSDevSlnSysSrvId();
                return true;
            }
            case 20: {
                pSDevSlnSysRefLinkBase.resetPSDevSlnSysSrvName();
                return true;
            }
            case 21: {
                pSDevSlnSysRefLinkBase.resetUpdateDate();
                return true;
            }
            case 22: {
                pSDevSlnSysRefLinkBase.resetUpdateMan();
                return true;
            }
            case 23: {
                pSDevSlnSysRefLinkBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenter getLinkPSDevcCenter() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLinkPSDevcCenter();
        }
        if (this.getLinkPSDevCenterId() == null) {
            return null;
        }
        Integer n = this.objLinkPSDevcCenterLock;
        synchronized (n) {
            if (this.linkpsdevccenter != null && DataTypeHelper.compare((int)25, (Object)this.getLinkPSDevCenterId(), (Object)this.linkpsdevccenter.getPSDevCenterId()) != 0L) {
                this.linkpsdevccenter = null;
            }
            if (this.linkpsdevccenter == null) {
                PSDevCenter pSDevCenter = new PSDevCenter();
                pSDevCenter.setPSDevCenterId(this.getLinkPSDevCenterId());
                PSDevCenterService pSDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterService.autoGet(pSDevCenter);
                this.linkpsdevccenter = pSDevCenter;
            }
            return this.linkpsdevccenter;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnSysRef getPSDevSlnSysRef() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysRef();
        }
        if (this.getPSDevSlnSysRefId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnSysRefLock;
        synchronized (n) {
            if (this.psdevslnsysref != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnSysRefId(), (Object)this.psdevslnsysref.getPSDevSlnSysRefId()) != 0L) {
                this.psdevslnsysref = null;
            }
            if (this.psdevslnsysref == null) {
                PSDevSlnSysRef pSDevSlnSysRef = new PSDevSlnSysRef();
                pSDevSlnSysRef.setPSDevSlnSysRefId(this.getPSDevSlnSysRefId());
                PSDevSlnSysRefService pSDevSlnSysRefService = (PSDevSlnSysRefService)ServiceGlobal.getService(PSDevSlnSysRefService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnSysRefService.autoGet(pSDevSlnSysRef);
                this.psdevslnsysref = pSDevSlnSysRef;
            }
            return this.psdevslnsysref;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnSysSrv getPSDevSlnSysSrv() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysSrv();
        }
        if (this.getPSDevSlnSysSrvId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnSysSrvLock;
        synchronized (n) {
            if (this.psdevslnsyssrv != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnSysSrvId(), (Object)this.psdevslnsyssrv.getPSDevSlnSysSrvId()) != 0L) {
                this.psdevslnsyssrv = null;
            }
            if (this.psdevslnsyssrv == null) {
                PSDevSlnSysSrv pSDevSlnSysSrv = new PSDevSlnSysSrv();
                pSDevSlnSysSrv.setPSDevSlnSysSrvId(this.getPSDevSlnSysSrvId());
                PSDevSlnSysSrvService pSDevSlnSysSrvService = (PSDevSlnSysSrvService)ServiceGlobal.getService(PSDevSlnSysSrvService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnSysSrvService.autoGet(pSDevSlnSysSrv);
                this.psdevslnsyssrv = pSDevSlnSysSrv;
            }
            return this.psdevslnsyssrv;
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

    private PSDevSlnSysRefLinkBase getProxyEntity() {
        return this.proxyPSDevSlnSysRefLinkBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevSlnSysRefLinkBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevSlnSysRefLinkBase) {
            this.proxyPSDevSlnSysRefLinkBase = (PSDevSlnSysRefLinkBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysRefLinkService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ACCESSTOKEN, 0);
        fieldIndexMap.put(FIELD_BEGINTIME, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_ENDTIME, 4);
        fieldIndexMap.put(FIELD_LINKPSDEVCENTERID, 5);
        fieldIndexMap.put(FIELD_LINKPSDEVCENTERNAME, 6);
        fieldIndexMap.put(FIELD_LINKREPMSG, 7);
        fieldIndexMap.put(FIELD_LINKREQMSG, 8);
        fieldIndexMap.put(FIELD_LINKSTATE, 9);
        fieldIndexMap.put(FIELD_LINKSTATEINFO, 10);
        fieldIndexMap.put(FIELD_MEMO, 11);
        fieldIndexMap.put(FIELD_PSDEVSLNID, 12);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSID, 13);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSNAME, 14);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSREFID, 15);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSREFLINKID, 16);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSREFLINKNAME, 17);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSREFNAME, 18);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSSRVID, 19);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSSRVNAME, 20);
        fieldIndexMap.put(FIELD_UPDATEDATE, 21);
        fieldIndexMap.put(FIELD_UPDATEMAN, 22);
        fieldIndexMap.put(FIELD_VALIDFLAG, 23);
    }
}

