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
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDevSlnSysBak;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysBakService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnSysBakLinkBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevSlnSysBakLinkBase.class);
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
    public static final String FIELD_PSDEVSLNSYSBAKID = "PSDEVSLNSYSBAKID";
    public static final String FIELD_PSDEVSLNSYSBAKLINKID = "PSDEVSLNSYSBAKLINKID";
    public static final String FIELD_PSDEVSLNSYSBAKLINKNAME = "PSDEVSLNSYSBAKLINKNAME";
    public static final String FIELD_PSDEVSLNSYSBAKNAME = "PSDEVSLNSYSBAKNAME";
    public static final String FIELD_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String FIELD_PSDEVSLNSYSNAME = "PSDEVSLNSYSNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_BEGINTIME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_ENDTIME = 3;
    private static final int INDEX_LINKPSDEVCENTERID = 4;
    private static final int INDEX_LINKPSDEVCENTERNAME = 5;
    private static final int INDEX_LINKREPMSG = 6;
    private static final int INDEX_LINKREQMSG = 7;
    private static final int INDEX_LINKSTATE = 8;
    private static final int INDEX_LINKSTATEINFO = 9;
    private static final int INDEX_MEMO = 10;
    private static final int INDEX_PSDEVSLNID = 11;
    private static final int INDEX_PSDEVSLNSYSBAKID = 12;
    private static final int INDEX_PSDEVSLNSYSBAKLINKID = 13;
    private static final int INDEX_PSDEVSLNSYSBAKLINKNAME = 14;
    private static final int INDEX_PSDEVSLNSYSBAKNAME = 15;
    private static final int INDEX_PSDEVSLNSYSID = 16;
    private static final int INDEX_PSDEVSLNSYSNAME = 17;
    private static final int INDEX_UPDATEDATE = 18;
    private static final int INDEX_UPDATEMAN = 19;
    private static final int INDEX_VALIDFLAG = 20;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevSlnSysBakLinkBase proxyPSDevSlnSysBakLinkBase = null;
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
    private boolean psdevslnsysbakidDirtyFlag = false;
    private boolean psdevslnsysbaklinkidDirtyFlag = false;
    private boolean psdevslnsysbaklinknameDirtyFlag = false;
    private boolean psdevslnsysbaknameDirtyFlag = false;
    private boolean psdevslnsysidDirtyFlag = false;
    private boolean psdevslnsysnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
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
    @Column(name="psdevslnsysbakid")
    private String psdevslnsysbakid;
    @Column(name="psdevslnsysbaklinkid")
    private String psdevslnsysbaklinkid;
    @Column(name="psdevslnsysbaklinkname")
    private String psdevslnsysbaklinkname;
    @Column(name="psdevslnsysbakname")
    private String psdevslnsysbakname;
    @Column(name="psdevslnsysid")
    private String psdevslnsysid;
    @Column(name="psdevslnsysname")
    private String psdevslnsysname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objLinkPSDevCenterLock = new Integer(1);
    private PSDevCenter linkpsdevcenter = null;
    private Integer objPSDevSlnSysBakLock = new Integer(1);
    private PSDevSlnSysBak psdevslnsysbak = null;
    private Integer objPSDevSlnSysLock = new Integer(1);
    private PSDevSlnSys psdevslnsys = null;

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

    public void setPSDevSlnSysBakLinkId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysBakLinkId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysbaklinkid = string;
        this.psdevslnsysbaklinkidDirtyFlag = true;
    }

    public String getPSDevSlnSysBakLinkId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysBakLinkId();
        }
        return this.psdevslnsysbaklinkid;
    }

    public boolean isPSDevSlnSysBakLinkIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysBakLinkIdDirty();
        }
        return this.psdevslnsysbaklinkidDirtyFlag;
    }

    public void resetPSDevSlnSysBakLinkId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysBakLinkId();
            return;
        }
        this.psdevslnsysbaklinkidDirtyFlag = false;
        this.psdevslnsysbaklinkid = null;
    }

    public void setPSDevSlnSysBakLinkName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysBakLinkName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysbaklinkname = string;
        this.psdevslnsysbaklinknameDirtyFlag = true;
    }

    public String getPSDevSlnSysBakLinkName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysBakLinkName();
        }
        return this.psdevslnsysbaklinkname;
    }

    public boolean isPSDevSlnSysBakLinkNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysBakLinkNameDirty();
        }
        return this.psdevslnsysbaklinknameDirtyFlag;
    }

    public void resetPSDevSlnSysBakLinkName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysBakLinkName();
            return;
        }
        this.psdevslnsysbaklinknameDirtyFlag = false;
        this.psdevslnsysbaklinkname = null;
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
        PSDevSlnSysBakLinkBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevSlnSysBakLinkBase pSDevSlnSysBakLinkBase) {
        pSDevSlnSysBakLinkBase.resetBeginTime();
        pSDevSlnSysBakLinkBase.resetCreateDate();
        pSDevSlnSysBakLinkBase.resetCreateMan();
        pSDevSlnSysBakLinkBase.resetEndTime();
        pSDevSlnSysBakLinkBase.resetLinkPSDevCenterId();
        pSDevSlnSysBakLinkBase.resetLinkPSDevCenterName();
        pSDevSlnSysBakLinkBase.resetLinkRepMsg();
        pSDevSlnSysBakLinkBase.resetLinkReqMsg();
        pSDevSlnSysBakLinkBase.resetLinkState();
        pSDevSlnSysBakLinkBase.resetLinkStateInfo();
        pSDevSlnSysBakLinkBase.resetMemo();
        pSDevSlnSysBakLinkBase.resetPSDevSlnId();
        pSDevSlnSysBakLinkBase.resetPSDevSlnSysBakId();
        pSDevSlnSysBakLinkBase.resetPSDevSlnSysBakLinkId();
        pSDevSlnSysBakLinkBase.resetPSDevSlnSysBakLinkName();
        pSDevSlnSysBakLinkBase.resetPSDevSlnSysBakName();
        pSDevSlnSysBakLinkBase.resetPSDevSlnSysId();
        pSDevSlnSysBakLinkBase.resetPSDevSlnSysName();
        pSDevSlnSysBakLinkBase.resetUpdateDate();
        pSDevSlnSysBakLinkBase.resetUpdateMan();
        pSDevSlnSysBakLinkBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
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
        if (!bl || this.isPSDevSlnSysBakIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSBAKID, this.getPSDevSlnSysBakId());
        }
        if (!bl || this.isPSDevSlnSysBakLinkIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSBAKLINKID, this.getPSDevSlnSysBakLinkId());
        }
        if (!bl || this.isPSDevSlnSysBakLinkNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSBAKLINKNAME, this.getPSDevSlnSysBakLinkName());
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
        return PSDevSlnSysBakLinkBase.get(this, n);
    }

    private static Object get(PSDevSlnSysBakLinkBase pSDevSlnSysBakLinkBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysBakLinkBase.getBeginTime();
            }
            case 1: {
                return pSDevSlnSysBakLinkBase.getCreateDate();
            }
            case 2: {
                return pSDevSlnSysBakLinkBase.getCreateMan();
            }
            case 3: {
                return pSDevSlnSysBakLinkBase.getEndTime();
            }
            case 4: {
                return pSDevSlnSysBakLinkBase.getLinkPSDevCenterId();
            }
            case 5: {
                return pSDevSlnSysBakLinkBase.getLinkPSDevCenterName();
            }
            case 6: {
                return pSDevSlnSysBakLinkBase.getLinkRepMsg();
            }
            case 7: {
                return pSDevSlnSysBakLinkBase.getLinkReqMsg();
            }
            case 8: {
                return pSDevSlnSysBakLinkBase.getLinkState();
            }
            case 9: {
                return pSDevSlnSysBakLinkBase.getLinkStateInfo();
            }
            case 10: {
                return pSDevSlnSysBakLinkBase.getMemo();
            }
            case 11: {
                return pSDevSlnSysBakLinkBase.getPSDevSlnId();
            }
            case 12: {
                return pSDevSlnSysBakLinkBase.getPSDevSlnSysBakId();
            }
            case 13: {
                return pSDevSlnSysBakLinkBase.getPSDevSlnSysBakLinkId();
            }
            case 14: {
                return pSDevSlnSysBakLinkBase.getPSDevSlnSysBakLinkName();
            }
            case 15: {
                return pSDevSlnSysBakLinkBase.getPSDevSlnSysBakName();
            }
            case 16: {
                return pSDevSlnSysBakLinkBase.getPSDevSlnSysId();
            }
            case 17: {
                return pSDevSlnSysBakLinkBase.getPSDevSlnSysName();
            }
            case 18: {
                return pSDevSlnSysBakLinkBase.getUpdateDate();
            }
            case 19: {
                return pSDevSlnSysBakLinkBase.getUpdateMan();
            }
            case 20: {
                return pSDevSlnSysBakLinkBase.getValidFlag();
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
        PSDevSlnSysBakLinkBase.set(this, n, object);
    }

    private static void set(PSDevSlnSysBakLinkBase pSDevSlnSysBakLinkBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnSysBakLinkBase.setBeginTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDevSlnSysBakLinkBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDevSlnSysBakLinkBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDevSlnSysBakLinkBase.setEndTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSDevSlnSysBakLinkBase.setLinkPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDevSlnSysBakLinkBase.setLinkPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDevSlnSysBakLinkBase.setLinkRepMsg(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDevSlnSysBakLinkBase.setLinkReqMsg(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDevSlnSysBakLinkBase.setLinkState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSDevSlnSysBakLinkBase.setLinkStateInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDevSlnSysBakLinkBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDevSlnSysBakLinkBase.setPSDevSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDevSlnSysBakLinkBase.setPSDevSlnSysBakId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDevSlnSysBakLinkBase.setPSDevSlnSysBakLinkId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDevSlnSysBakLinkBase.setPSDevSlnSysBakLinkName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDevSlnSysBakLinkBase.setPSDevSlnSysBakName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDevSlnSysBakLinkBase.setPSDevSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDevSlnSysBakLinkBase.setPSDevSlnSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDevSlnSysBakLinkBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 19: {
                pSDevSlnSysBakLinkBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDevSlnSysBakLinkBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDevSlnSysBakLinkBase.isNull(this, n);
    }

    private static boolean isNull(PSDevSlnSysBakLinkBase pSDevSlnSysBakLinkBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysBakLinkBase.getBeginTime() == null;
            }
            case 1: {
                return pSDevSlnSysBakLinkBase.getCreateDate() == null;
            }
            case 2: {
                return pSDevSlnSysBakLinkBase.getCreateMan() == null;
            }
            case 3: {
                return pSDevSlnSysBakLinkBase.getEndTime() == null;
            }
            case 4: {
                return pSDevSlnSysBakLinkBase.getLinkPSDevCenterId() == null;
            }
            case 5: {
                return pSDevSlnSysBakLinkBase.getLinkPSDevCenterName() == null;
            }
            case 6: {
                return pSDevSlnSysBakLinkBase.getLinkRepMsg() == null;
            }
            case 7: {
                return pSDevSlnSysBakLinkBase.getLinkReqMsg() == null;
            }
            case 8: {
                return pSDevSlnSysBakLinkBase.getLinkState() == null;
            }
            case 9: {
                return pSDevSlnSysBakLinkBase.getLinkStateInfo() == null;
            }
            case 10: {
                return pSDevSlnSysBakLinkBase.getMemo() == null;
            }
            case 11: {
                return pSDevSlnSysBakLinkBase.getPSDevSlnId() == null;
            }
            case 12: {
                return pSDevSlnSysBakLinkBase.getPSDevSlnSysBakId() == null;
            }
            case 13: {
                return pSDevSlnSysBakLinkBase.getPSDevSlnSysBakLinkId() == null;
            }
            case 14: {
                return pSDevSlnSysBakLinkBase.getPSDevSlnSysBakLinkName() == null;
            }
            case 15: {
                return pSDevSlnSysBakLinkBase.getPSDevSlnSysBakName() == null;
            }
            case 16: {
                return pSDevSlnSysBakLinkBase.getPSDevSlnSysId() == null;
            }
            case 17: {
                return pSDevSlnSysBakLinkBase.getPSDevSlnSysName() == null;
            }
            case 18: {
                return pSDevSlnSysBakLinkBase.getUpdateDate() == null;
            }
            case 19: {
                return pSDevSlnSysBakLinkBase.getUpdateMan() == null;
            }
            case 20: {
                return pSDevSlnSysBakLinkBase.getValidFlag() == null;
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
        return PSDevSlnSysBakLinkBase.contains(this, n);
    }

    private static boolean contains(PSDevSlnSysBakLinkBase pSDevSlnSysBakLinkBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysBakLinkBase.isBeginTimeDirty();
            }
            case 1: {
                return pSDevSlnSysBakLinkBase.isCreateDateDirty();
            }
            case 2: {
                return pSDevSlnSysBakLinkBase.isCreateManDirty();
            }
            case 3: {
                return pSDevSlnSysBakLinkBase.isEndTimeDirty();
            }
            case 4: {
                return pSDevSlnSysBakLinkBase.isLinkPSDevCenterIdDirty();
            }
            case 5: {
                return pSDevSlnSysBakLinkBase.isLinkPSDevCenterNameDirty();
            }
            case 6: {
                return pSDevSlnSysBakLinkBase.isLinkRepMsgDirty();
            }
            case 7: {
                return pSDevSlnSysBakLinkBase.isLinkReqMsgDirty();
            }
            case 8: {
                return pSDevSlnSysBakLinkBase.isLinkStateDirty();
            }
            case 9: {
                return pSDevSlnSysBakLinkBase.isLinkStateInfoDirty();
            }
            case 10: {
                return pSDevSlnSysBakLinkBase.isMemoDirty();
            }
            case 11: {
                return pSDevSlnSysBakLinkBase.isPSDevSlnIdDirty();
            }
            case 12: {
                return pSDevSlnSysBakLinkBase.isPSDevSlnSysBakIdDirty();
            }
            case 13: {
                return pSDevSlnSysBakLinkBase.isPSDevSlnSysBakLinkIdDirty();
            }
            case 14: {
                return pSDevSlnSysBakLinkBase.isPSDevSlnSysBakLinkNameDirty();
            }
            case 15: {
                return pSDevSlnSysBakLinkBase.isPSDevSlnSysBakNameDirty();
            }
            case 16: {
                return pSDevSlnSysBakLinkBase.isPSDevSlnSysIdDirty();
            }
            case 17: {
                return pSDevSlnSysBakLinkBase.isPSDevSlnSysNameDirty();
            }
            case 18: {
                return pSDevSlnSysBakLinkBase.isUpdateDateDirty();
            }
            case 19: {
                return pSDevSlnSysBakLinkBase.isUpdateManDirty();
            }
            case 20: {
                return pSDevSlnSysBakLinkBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevSlnSysBakLinkBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevSlnSysBakLinkBase pSDevSlnSysBakLinkBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevSlnSysBakLinkBase.getBeginTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"begintime", (Object)PSDevSlnSysBakLinkBase.getJSONValue((Object)pSDevSlnSysBakLinkBase.getBeginTime()), (boolean)false);
        }
        if (bl || pSDevSlnSysBakLinkBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevSlnSysBakLinkBase.getJSONValue((Object)pSDevSlnSysBakLinkBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevSlnSysBakLinkBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevSlnSysBakLinkBase.getJSONValue((Object)pSDevSlnSysBakLinkBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevSlnSysBakLinkBase.getEndTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"endtime", (Object)PSDevSlnSysBakLinkBase.getJSONValue((Object)pSDevSlnSysBakLinkBase.getEndTime()), (boolean)false);
        }
        if (bl || pSDevSlnSysBakLinkBase.getLinkPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"linkpsdevcenterid", (Object)PSDevSlnSysBakLinkBase.getJSONValue((Object)pSDevSlnSysBakLinkBase.getLinkPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDevSlnSysBakLinkBase.getLinkPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"linkpsdevcentername", (Object)PSDevSlnSysBakLinkBase.getJSONValue((Object)pSDevSlnSysBakLinkBase.getLinkPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDevSlnSysBakLinkBase.getLinkRepMsg() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"linkrepmsg", (Object)PSDevSlnSysBakLinkBase.getJSONValue((Object)pSDevSlnSysBakLinkBase.getLinkRepMsg()), (boolean)false);
        }
        if (bl || pSDevSlnSysBakLinkBase.getLinkReqMsg() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"linkreqmsg", (Object)PSDevSlnSysBakLinkBase.getJSONValue((Object)pSDevSlnSysBakLinkBase.getLinkReqMsg()), (boolean)false);
        }
        if (bl || pSDevSlnSysBakLinkBase.getLinkState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"linkstate", (Object)PSDevSlnSysBakLinkBase.getJSONValue((Object)pSDevSlnSysBakLinkBase.getLinkState()), (boolean)false);
        }
        if (bl || pSDevSlnSysBakLinkBase.getLinkStateInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"linkstateinfo", (Object)PSDevSlnSysBakLinkBase.getJSONValue((Object)pSDevSlnSysBakLinkBase.getLinkStateInfo()), (boolean)false);
        }
        if (bl || pSDevSlnSysBakLinkBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDevSlnSysBakLinkBase.getJSONValue((Object)pSDevSlnSysBakLinkBase.getMemo()), (boolean)false);
        }
        if (bl || pSDevSlnSysBakLinkBase.getPSDevSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnid", (Object)PSDevSlnSysBakLinkBase.getJSONValue((Object)pSDevSlnSysBakLinkBase.getPSDevSlnId()), (boolean)false);
        }
        if (bl || pSDevSlnSysBakLinkBase.getPSDevSlnSysBakId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysbakid", (Object)PSDevSlnSysBakLinkBase.getJSONValue((Object)pSDevSlnSysBakLinkBase.getPSDevSlnSysBakId()), (boolean)false);
        }
        if (bl || pSDevSlnSysBakLinkBase.getPSDevSlnSysBakLinkId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysbaklinkid", (Object)PSDevSlnSysBakLinkBase.getJSONValue((Object)pSDevSlnSysBakLinkBase.getPSDevSlnSysBakLinkId()), (boolean)false);
        }
        if (bl || pSDevSlnSysBakLinkBase.getPSDevSlnSysBakLinkName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysbaklinkname", (Object)PSDevSlnSysBakLinkBase.getJSONValue((Object)pSDevSlnSysBakLinkBase.getPSDevSlnSysBakLinkName()), (boolean)false);
        }
        if (bl || pSDevSlnSysBakLinkBase.getPSDevSlnSysBakName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysbakname", (Object)PSDevSlnSysBakLinkBase.getJSONValue((Object)pSDevSlnSysBakLinkBase.getPSDevSlnSysBakName()), (boolean)false);
        }
        if (bl || pSDevSlnSysBakLinkBase.getPSDevSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysid", (Object)PSDevSlnSysBakLinkBase.getJSONValue((Object)pSDevSlnSysBakLinkBase.getPSDevSlnSysId()), (boolean)false);
        }
        if (bl || pSDevSlnSysBakLinkBase.getPSDevSlnSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysname", (Object)PSDevSlnSysBakLinkBase.getJSONValue((Object)pSDevSlnSysBakLinkBase.getPSDevSlnSysName()), (boolean)false);
        }
        if (bl || pSDevSlnSysBakLinkBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevSlnSysBakLinkBase.getJSONValue((Object)pSDevSlnSysBakLinkBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevSlnSysBakLinkBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevSlnSysBakLinkBase.getJSONValue((Object)pSDevSlnSysBakLinkBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDevSlnSysBakLinkBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDevSlnSysBakLinkBase.getJSONValue((Object)pSDevSlnSysBakLinkBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevSlnSysBakLinkBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevSlnSysBakLinkBase pSDevSlnSysBakLinkBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevSlnSysBakLinkBase.getBeginTime() != null) {
            object = pSDevSlnSysBakLinkBase.getBeginTime();
            xmlNode.setAttribute(FIELD_BEGINTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysBakLinkBase.getCreateDate() != null) {
            object = pSDevSlnSysBakLinkBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysBakLinkBase.getCreateMan() != null) {
            object = pSDevSlnSysBakLinkBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBakLinkBase.getEndTime() != null) {
            object = pSDevSlnSysBakLinkBase.getEndTime();
            xmlNode.setAttribute(FIELD_ENDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysBakLinkBase.getLinkPSDevCenterId() != null) {
            object = pSDevSlnSysBakLinkBase.getLinkPSDevCenterId();
            xmlNode.setAttribute(FIELD_LINKPSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBakLinkBase.getLinkPSDevCenterName() != null) {
            object = pSDevSlnSysBakLinkBase.getLinkPSDevCenterName();
            xmlNode.setAttribute(FIELD_LINKPSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBakLinkBase.getLinkRepMsg() != null) {
            object = pSDevSlnSysBakLinkBase.getLinkRepMsg();
            xmlNode.setAttribute(FIELD_LINKREPMSG, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBakLinkBase.getLinkReqMsg() != null) {
            object = pSDevSlnSysBakLinkBase.getLinkReqMsg();
            xmlNode.setAttribute(FIELD_LINKREQMSG, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBakLinkBase.getLinkState() != null) {
            object = pSDevSlnSysBakLinkBase.getLinkState();
            xmlNode.setAttribute(FIELD_LINKSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnSysBakLinkBase.getLinkStateInfo() != null) {
            object = pSDevSlnSysBakLinkBase.getLinkStateInfo();
            xmlNode.setAttribute(FIELD_LINKSTATEINFO, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBakLinkBase.getMemo() != null) {
            object = pSDevSlnSysBakLinkBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBakLinkBase.getPSDevSlnId() != null) {
            object = pSDevSlnSysBakLinkBase.getPSDevSlnId();
            xmlNode.setAttribute(FIELD_PSDEVSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBakLinkBase.getPSDevSlnSysBakId() != null) {
            object = pSDevSlnSysBakLinkBase.getPSDevSlnSysBakId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSBAKID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBakLinkBase.getPSDevSlnSysBakLinkId() != null) {
            object = pSDevSlnSysBakLinkBase.getPSDevSlnSysBakLinkId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSBAKLINKID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBakLinkBase.getPSDevSlnSysBakLinkName() != null) {
            object = pSDevSlnSysBakLinkBase.getPSDevSlnSysBakLinkName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSBAKLINKNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBakLinkBase.getPSDevSlnSysBakName() != null) {
            object = pSDevSlnSysBakLinkBase.getPSDevSlnSysBakName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSBAKNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBakLinkBase.getPSDevSlnSysId() != null) {
            object = pSDevSlnSysBakLinkBase.getPSDevSlnSysId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBakLinkBase.getPSDevSlnSysName() != null) {
            object = pSDevSlnSysBakLinkBase.getPSDevSlnSysName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBakLinkBase.getUpdateDate() != null) {
            object = pSDevSlnSysBakLinkBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysBakLinkBase.getUpdateMan() != null) {
            object = pSDevSlnSysBakLinkBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysBakLinkBase.getValidFlag() != null) {
            object = pSDevSlnSysBakLinkBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevSlnSysBakLinkBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevSlnSysBakLinkBase pSDevSlnSysBakLinkBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevSlnSysBakLinkBase.isBeginTimeDirty() && (bl || pSDevSlnSysBakLinkBase.getBeginTime() != null)) {
            iDataObject.set(FIELD_BEGINTIME, (Object)pSDevSlnSysBakLinkBase.getBeginTime());
        }
        if (pSDevSlnSysBakLinkBase.isCreateDateDirty() && (bl || pSDevSlnSysBakLinkBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevSlnSysBakLinkBase.getCreateDate());
        }
        if (pSDevSlnSysBakLinkBase.isCreateManDirty() && (bl || pSDevSlnSysBakLinkBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevSlnSysBakLinkBase.getCreateMan());
        }
        if (pSDevSlnSysBakLinkBase.isEndTimeDirty() && (bl || pSDevSlnSysBakLinkBase.getEndTime() != null)) {
            iDataObject.set(FIELD_ENDTIME, (Object)pSDevSlnSysBakLinkBase.getEndTime());
        }
        if (pSDevSlnSysBakLinkBase.isLinkPSDevCenterIdDirty() && (bl || pSDevSlnSysBakLinkBase.getLinkPSDevCenterId() != null)) {
            iDataObject.set(FIELD_LINKPSDEVCENTERID, (Object)pSDevSlnSysBakLinkBase.getLinkPSDevCenterId());
        }
        if (pSDevSlnSysBakLinkBase.isLinkPSDevCenterNameDirty() && (bl || pSDevSlnSysBakLinkBase.getLinkPSDevCenterName() != null)) {
            iDataObject.set(FIELD_LINKPSDEVCENTERNAME, (Object)pSDevSlnSysBakLinkBase.getLinkPSDevCenterName());
        }
        if (pSDevSlnSysBakLinkBase.isLinkRepMsgDirty() && (bl || pSDevSlnSysBakLinkBase.getLinkRepMsg() != null)) {
            iDataObject.set(FIELD_LINKREPMSG, (Object)pSDevSlnSysBakLinkBase.getLinkRepMsg());
        }
        if (pSDevSlnSysBakLinkBase.isLinkReqMsgDirty() && (bl || pSDevSlnSysBakLinkBase.getLinkReqMsg() != null)) {
            iDataObject.set(FIELD_LINKREQMSG, (Object)pSDevSlnSysBakLinkBase.getLinkReqMsg());
        }
        if (pSDevSlnSysBakLinkBase.isLinkStateDirty() && (bl || pSDevSlnSysBakLinkBase.getLinkState() != null)) {
            iDataObject.set(FIELD_LINKSTATE, (Object)pSDevSlnSysBakLinkBase.getLinkState());
        }
        if (pSDevSlnSysBakLinkBase.isLinkStateInfoDirty() && (bl || pSDevSlnSysBakLinkBase.getLinkStateInfo() != null)) {
            iDataObject.set(FIELD_LINKSTATEINFO, (Object)pSDevSlnSysBakLinkBase.getLinkStateInfo());
        }
        if (pSDevSlnSysBakLinkBase.isMemoDirty() && (bl || pSDevSlnSysBakLinkBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDevSlnSysBakLinkBase.getMemo());
        }
        if (pSDevSlnSysBakLinkBase.isPSDevSlnIdDirty() && (bl || pSDevSlnSysBakLinkBase.getPSDevSlnId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNID, (Object)pSDevSlnSysBakLinkBase.getPSDevSlnId());
        }
        if (pSDevSlnSysBakLinkBase.isPSDevSlnSysBakIdDirty() && (bl || pSDevSlnSysBakLinkBase.getPSDevSlnSysBakId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSBAKID, (Object)pSDevSlnSysBakLinkBase.getPSDevSlnSysBakId());
        }
        if (pSDevSlnSysBakLinkBase.isPSDevSlnSysBakLinkIdDirty() && (bl || pSDevSlnSysBakLinkBase.getPSDevSlnSysBakLinkId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSBAKLINKID, (Object)pSDevSlnSysBakLinkBase.getPSDevSlnSysBakLinkId());
        }
        if (pSDevSlnSysBakLinkBase.isPSDevSlnSysBakLinkNameDirty() && (bl || pSDevSlnSysBakLinkBase.getPSDevSlnSysBakLinkName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSBAKLINKNAME, (Object)pSDevSlnSysBakLinkBase.getPSDevSlnSysBakLinkName());
        }
        if (pSDevSlnSysBakLinkBase.isPSDevSlnSysBakNameDirty() && (bl || pSDevSlnSysBakLinkBase.getPSDevSlnSysBakName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSBAKNAME, (Object)pSDevSlnSysBakLinkBase.getPSDevSlnSysBakName());
        }
        if (pSDevSlnSysBakLinkBase.isPSDevSlnSysIdDirty() && (bl || pSDevSlnSysBakLinkBase.getPSDevSlnSysId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSID, (Object)pSDevSlnSysBakLinkBase.getPSDevSlnSysId());
        }
        if (pSDevSlnSysBakLinkBase.isPSDevSlnSysNameDirty() && (bl || pSDevSlnSysBakLinkBase.getPSDevSlnSysName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSNAME, (Object)pSDevSlnSysBakLinkBase.getPSDevSlnSysName());
        }
        if (pSDevSlnSysBakLinkBase.isUpdateDateDirty() && (bl || pSDevSlnSysBakLinkBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevSlnSysBakLinkBase.getUpdateDate());
        }
        if (pSDevSlnSysBakLinkBase.isUpdateManDirty() && (bl || pSDevSlnSysBakLinkBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevSlnSysBakLinkBase.getUpdateMan());
        }
        if (pSDevSlnSysBakLinkBase.isValidFlagDirty() && (bl || pSDevSlnSysBakLinkBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDevSlnSysBakLinkBase.getValidFlag());
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
        return PSDevSlnSysBakLinkBase.remove(this, n);
    }

    private static boolean remove(PSDevSlnSysBakLinkBase pSDevSlnSysBakLinkBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnSysBakLinkBase.resetBeginTime();
                return true;
            }
            case 1: {
                pSDevSlnSysBakLinkBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDevSlnSysBakLinkBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDevSlnSysBakLinkBase.resetEndTime();
                return true;
            }
            case 4: {
                pSDevSlnSysBakLinkBase.resetLinkPSDevCenterId();
                return true;
            }
            case 5: {
                pSDevSlnSysBakLinkBase.resetLinkPSDevCenterName();
                return true;
            }
            case 6: {
                pSDevSlnSysBakLinkBase.resetLinkRepMsg();
                return true;
            }
            case 7: {
                pSDevSlnSysBakLinkBase.resetLinkReqMsg();
                return true;
            }
            case 8: {
                pSDevSlnSysBakLinkBase.resetLinkState();
                return true;
            }
            case 9: {
                pSDevSlnSysBakLinkBase.resetLinkStateInfo();
                return true;
            }
            case 10: {
                pSDevSlnSysBakLinkBase.resetMemo();
                return true;
            }
            case 11: {
                pSDevSlnSysBakLinkBase.resetPSDevSlnId();
                return true;
            }
            case 12: {
                pSDevSlnSysBakLinkBase.resetPSDevSlnSysBakId();
                return true;
            }
            case 13: {
                pSDevSlnSysBakLinkBase.resetPSDevSlnSysBakLinkId();
                return true;
            }
            case 14: {
                pSDevSlnSysBakLinkBase.resetPSDevSlnSysBakLinkName();
                return true;
            }
            case 15: {
                pSDevSlnSysBakLinkBase.resetPSDevSlnSysBakName();
                return true;
            }
            case 16: {
                pSDevSlnSysBakLinkBase.resetPSDevSlnSysId();
                return true;
            }
            case 17: {
                pSDevSlnSysBakLinkBase.resetPSDevSlnSysName();
                return true;
            }
            case 18: {
                pSDevSlnSysBakLinkBase.resetUpdateDate();
                return true;
            }
            case 19: {
                pSDevSlnSysBakLinkBase.resetUpdateMan();
                return true;
            }
            case 20: {
                pSDevSlnSysBakLinkBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenter getLinkPSDevCenter() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLinkPSDevCenter();
        }
        if (this.getLinkPSDevCenterId() == null) {
            return null;
        }
        Integer n = this.objLinkPSDevCenterLock;
        synchronized (n) {
            if (this.linkpsdevcenter != null && DataTypeHelper.compare((int)25, (Object)this.getLinkPSDevCenterId(), (Object)this.linkpsdevcenter.getPSDevCenterId()) != 0L) {
                this.linkpsdevcenter = null;
            }
            if (this.linkpsdevcenter == null) {
                PSDevCenter pSDevCenter = new PSDevCenter();
                pSDevCenter.setPSDevCenterId(this.getLinkPSDevCenterId());
                PSDevCenterService pSDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterService.autoGet((IEntity)pSDevCenter);
                this.linkpsdevcenter = pSDevCenter;
            }
            return this.linkpsdevcenter;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnSysBak getPSDevSlnSysBak() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysBak();
        }
        if (this.getPSDevSlnSysBakId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnSysBakLock;
        synchronized (n) {
            if (this.psdevslnsysbak != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnSysBakId(), (Object)this.psdevslnsysbak.getPSDevSlnSysBakId()) != 0L) {
                this.psdevslnsysbak = null;
            }
            if (this.psdevslnsysbak == null) {
                PSDevSlnSysBak pSDevSlnSysBak = new PSDevSlnSysBak();
                pSDevSlnSysBak.setPSDevSlnSysBakId(this.getPSDevSlnSysBakId());
                PSDevSlnSysBakService pSDevSlnSysBakService = (PSDevSlnSysBakService)ServiceGlobal.getService(PSDevSlnSysBakService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnSysBakService.autoGet((IEntity)pSDevSlnSysBak);
                this.psdevslnsysbak = pSDevSlnSysBak;
            }
            return this.psdevslnsysbak;
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
                pSDevSlnSysService.autoGet((IEntity)pSDevSlnSys);
                this.psdevslnsys = pSDevSlnSys;
            }
            return this.psdevslnsys;
        }
    }

    private PSDevSlnSysBakLinkBase getProxyEntity() {
        return this.proxyPSDevSlnSysBakLinkBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevSlnSysBakLinkBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevSlnSysBakLinkBase) {
            this.proxyPSDevSlnSysBakLinkBase = (PSDevSlnSysBakLinkBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysBakLinkService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BEGINTIME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_ENDTIME, 3);
        fieldIndexMap.put(FIELD_LINKPSDEVCENTERID, 4);
        fieldIndexMap.put(FIELD_LINKPSDEVCENTERNAME, 5);
        fieldIndexMap.put(FIELD_LINKREPMSG, 6);
        fieldIndexMap.put(FIELD_LINKREQMSG, 7);
        fieldIndexMap.put(FIELD_LINKSTATE, 8);
        fieldIndexMap.put(FIELD_LINKSTATEINFO, 9);
        fieldIndexMap.put(FIELD_MEMO, 10);
        fieldIndexMap.put(FIELD_PSDEVSLNID, 11);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSBAKID, 12);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSBAKLINKID, 13);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSBAKLINKNAME, 14);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSBAKNAME, 15);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSID, 16);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSNAME, 17);
        fieldIndexMap.put(FIELD_UPDATEDATE, 18);
        fieldIndexMap.put(FIELD_UPDATEMAN, 19);
        fieldIndexMap.put(FIELD_VALIDFLAG, 20);
    }
}

