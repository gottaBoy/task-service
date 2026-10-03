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
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnTempl;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnTemplService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnTemplRefBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevSlnTemplRefBase.class);
    public static final String FIELD_ACCESSTOKEN = "ACCESSTOKEN";
    public static final String FIELD_BEGINTIME = "BEGINTIME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ENDTIME = "ENDTIME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSDEVSLNTEMPLID = "PSDEVSLNTEMPLID";
    public static final String FIELD_PSDEVSLNTEMPLNAME = "PSDEVSLNTEMPLNAME";
    public static final String FIELD_PSDEVSLNTEMPLREFID = "PSDEVSLNTEMPLREFID";
    public static final String FIELD_PSDEVSLNTEMPLREFNAME = "PSDEVSLNTEMPLREFNAME";
    public static final String FIELD_REFPSDEVSLNTEMPLID = "REFPSDEVSLNTEMPLID";
    public static final String FIELD_REFPSDEVSLNTEMPLNAME = "REFPSDEVSLNTEMPLNAME";
    public static final String FIELD_REFREPMSG = "REFREPMSG";
    public static final String FIELD_REFREQMSG = "REFREQMSG";
    public static final String FIELD_REFSTATE = "REFSTATE";
    public static final String FIELD_REFSTATEINFO = "REFSTATEINFO";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_ACCESSTOKEN = 0;
    private static final int INDEX_BEGINTIME = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_ENDTIME = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_PSDEVCENTERNAME = 6;
    private static final int INDEX_PSDEVSLNTEMPLID = 7;
    private static final int INDEX_PSDEVSLNTEMPLNAME = 8;
    private static final int INDEX_PSDEVSLNTEMPLREFID = 9;
    private static final int INDEX_PSDEVSLNTEMPLREFNAME = 10;
    private static final int INDEX_REFPSDEVSLNTEMPLID = 11;
    private static final int INDEX_REFPSDEVSLNTEMPLNAME = 12;
    private static final int INDEX_REFREPMSG = 13;
    private static final int INDEX_REFREQMSG = 14;
    private static final int INDEX_REFSTATE = 15;
    private static final int INDEX_REFSTATEINFO = 16;
    private static final int INDEX_UPDATEDATE = 17;
    private static final int INDEX_UPDATEMAN = 18;
    private static final int INDEX_VALIDFLAG = 19;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevSlnTemplRefBase proxyPSDevSlnTemplRefBase = null;
    private boolean accesstokenDirtyFlag = false;
    private boolean begintimeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean endtimeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psdevslntemplidDirtyFlag = false;
    private boolean psdevslntemplnameDirtyFlag = false;
    private boolean psdevslntemplrefidDirtyFlag = false;
    private boolean psdevslntemplrefnameDirtyFlag = false;
    private boolean refpsdevslntemplidDirtyFlag = false;
    private boolean refpsdevslntemplnameDirtyFlag = false;
    private boolean refrepmsgDirtyFlag = false;
    private boolean refreqmsgDirtyFlag = false;
    private boolean refstateDirtyFlag = false;
    private boolean refstateinfoDirtyFlag = false;
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
    @Column(name="memo")
    private String memo;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="psdevslntemplid")
    private String psdevslntemplid;
    @Column(name="psdevslntemplname")
    private String psdevslntemplname;
    @Column(name="psdevslntemplrefid")
    private String psdevslntemplrefid;
    @Column(name="psdevslntemplrefname")
    private String psdevslntemplrefname;
    @Column(name="refpsdevslntemplid")
    private String refpsdevslntemplid;
    @Column(name="refpsdevslntemplname")
    private String refpsdevslntemplname;
    @Column(name="refrepmsg")
    private String refrepmsg;
    @Column(name="refreqmsg")
    private String refreqmsg;
    @Column(name="refstate")
    private Integer refstate;
    @Column(name="refstateinfo")
    private String refstateinfo;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSDevSlnTemplLock = new Integer(1);
    private PSDevSlnTempl psdevslntempl = null;
    private Integer objRefPSDevSlnTemplLock = new Integer(1);
    private PSDevSlnTempl refpsdevslntempl = null;

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

    public void setPSDevSlnTemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnTemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslntemplid = string;
        this.psdevslntemplidDirtyFlag = true;
    }

    public String getPSDevSlnTemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnTemplId();
        }
        return this.psdevslntemplid;
    }

    public boolean isPSDevSlnTemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnTemplIdDirty();
        }
        return this.psdevslntemplidDirtyFlag;
    }

    public void resetPSDevSlnTemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnTemplId();
            return;
        }
        this.psdevslntemplidDirtyFlag = false;
        this.psdevslntemplid = null;
    }

    public void setPSDevSlnTemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnTemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslntemplname = string;
        this.psdevslntemplnameDirtyFlag = true;
    }

    public String getPSDevSlnTemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnTemplName();
        }
        return this.psdevslntemplname;
    }

    public boolean isPSDevSlnTemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnTemplNameDirty();
        }
        return this.psdevslntemplnameDirtyFlag;
    }

    public void resetPSDevSlnTemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnTemplName();
            return;
        }
        this.psdevslntemplnameDirtyFlag = false;
        this.psdevslntemplname = null;
    }

    public void setPSDevSlnTemplRefId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnTemplRefId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslntemplrefid = string;
        this.psdevslntemplrefidDirtyFlag = true;
    }

    public String getPSDevSlnTemplRefId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnTemplRefId();
        }
        return this.psdevslntemplrefid;
    }

    public boolean isPSDevSlnTemplRefIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnTemplRefIdDirty();
        }
        return this.psdevslntemplrefidDirtyFlag;
    }

    public void resetPSDevSlnTemplRefId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnTemplRefId();
            return;
        }
        this.psdevslntemplrefidDirtyFlag = false;
        this.psdevslntemplrefid = null;
    }

    public void setPSDevSlnTemplRefName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnTemplRefName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslntemplrefname = string;
        this.psdevslntemplrefnameDirtyFlag = true;
    }

    public String getPSDevSlnTemplRefName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnTemplRefName();
        }
        return this.psdevslntemplrefname;
    }

    public boolean isPSDevSlnTemplRefNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnTemplRefNameDirty();
        }
        return this.psdevslntemplrefnameDirtyFlag;
    }

    public void resetPSDevSlnTemplRefName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnTemplRefName();
            return;
        }
        this.psdevslntemplrefnameDirtyFlag = false;
        this.psdevslntemplrefname = null;
    }

    public void setRefPSDevSlnTemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSDevSlnTemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpsdevslntemplid = string;
        this.refpsdevslntemplidDirtyFlag = true;
    }

    public String getRefPSDevSlnTemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDevSlnTemplId();
        }
        return this.refpsdevslntemplid;
    }

    public boolean isRefPSDevSlnTemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSDevSlnTemplIdDirty();
        }
        return this.refpsdevslntemplidDirtyFlag;
    }

    public void resetRefPSDevSlnTemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSDevSlnTemplId();
            return;
        }
        this.refpsdevslntemplidDirtyFlag = false;
        this.refpsdevslntemplid = null;
    }

    public void setRefPSDevSlnTemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSDevSlnTemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpsdevslntemplname = string;
        this.refpsdevslntemplnameDirtyFlag = true;
    }

    public String getRefPSDevSlnTemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDevSlnTemplName();
        }
        return this.refpsdevslntemplname;
    }

    public boolean isRefPSDevSlnTemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSDevSlnTemplNameDirty();
        }
        return this.refpsdevslntemplnameDirtyFlag;
    }

    public void resetRefPSDevSlnTemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSDevSlnTemplName();
            return;
        }
        this.refpsdevslntemplnameDirtyFlag = false;
        this.refpsdevslntemplname = null;
    }

    public void setRefRepMsg(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefRepMsg(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refrepmsg = string;
        this.refrepmsgDirtyFlag = true;
    }

    public String getRefRepMsg() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefRepMsg();
        }
        return this.refrepmsg;
    }

    public boolean isRefRepMsgDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefRepMsgDirty();
        }
        return this.refrepmsgDirtyFlag;
    }

    public void resetRefRepMsg() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefRepMsg();
            return;
        }
        this.refrepmsgDirtyFlag = false;
        this.refrepmsg = null;
    }

    public void setRefReqMsg(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefReqMsg(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refreqmsg = string;
        this.refreqmsgDirtyFlag = true;
    }

    public String getRefReqMsg() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefReqMsg();
        }
        return this.refreqmsg;
    }

    public boolean isRefReqMsgDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefReqMsgDirty();
        }
        return this.refreqmsgDirtyFlag;
    }

    public void resetRefReqMsg() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefReqMsg();
            return;
        }
        this.refreqmsgDirtyFlag = false;
        this.refreqmsg = null;
    }

    public void setRefState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefState(n);
            return;
        }
        this.refstate = n;
        this.refstateDirtyFlag = true;
    }

    public Integer getRefState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefState();
        }
        return this.refstate;
    }

    public boolean isRefStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefStateDirty();
        }
        return this.refstateDirtyFlag;
    }

    public void resetRefState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefState();
            return;
        }
        this.refstateDirtyFlag = false;
        this.refstate = null;
    }

    public void setRefStateInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefStateInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refstateinfo = string;
        this.refstateinfoDirtyFlag = true;
    }

    public String getRefStateInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefStateInfo();
        }
        return this.refstateinfo;
    }

    public boolean isRefStateInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefStateInfoDirty();
        }
        return this.refstateinfoDirtyFlag;
    }

    public void resetRefStateInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefStateInfo();
            return;
        }
        this.refstateinfoDirtyFlag = false;
        this.refstateinfo = null;
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
        PSDevSlnTemplRefBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevSlnTemplRefBase pSDevSlnTemplRefBase) {
        pSDevSlnTemplRefBase.resetAccessToken();
        pSDevSlnTemplRefBase.resetBeginTime();
        pSDevSlnTemplRefBase.resetCreateDate();
        pSDevSlnTemplRefBase.resetCreateMan();
        pSDevSlnTemplRefBase.resetEndTime();
        pSDevSlnTemplRefBase.resetMemo();
        pSDevSlnTemplRefBase.resetPSDevCenterName();
        pSDevSlnTemplRefBase.resetPSDevSlnTemplId();
        pSDevSlnTemplRefBase.resetPSDevSlnTemplName();
        pSDevSlnTemplRefBase.resetPSDevSlnTemplRefId();
        pSDevSlnTemplRefBase.resetPSDevSlnTemplRefName();
        pSDevSlnTemplRefBase.resetRefPSDevSlnTemplId();
        pSDevSlnTemplRefBase.resetRefPSDevSlnTemplName();
        pSDevSlnTemplRefBase.resetRefRepMsg();
        pSDevSlnTemplRefBase.resetRefReqMsg();
        pSDevSlnTemplRefBase.resetRefState();
        pSDevSlnTemplRefBase.resetRefStateInfo();
        pSDevSlnTemplRefBase.resetUpdateDate();
        pSDevSlnTemplRefBase.resetUpdateMan();
        pSDevSlnTemplRefBase.resetValidFlag();
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
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSDevSlnTemplIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNTEMPLID, this.getPSDevSlnTemplId());
        }
        if (!bl || this.isPSDevSlnTemplNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNTEMPLNAME, this.getPSDevSlnTemplName());
        }
        if (!bl || this.isPSDevSlnTemplRefIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNTEMPLREFID, this.getPSDevSlnTemplRefId());
        }
        if (!bl || this.isPSDevSlnTemplRefNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNTEMPLREFNAME, this.getPSDevSlnTemplRefName());
        }
        if (!bl || this.isRefPSDevSlnTemplIdDirty()) {
            hashMap.put(FIELD_REFPSDEVSLNTEMPLID, this.getRefPSDevSlnTemplId());
        }
        if (!bl || this.isRefPSDevSlnTemplNameDirty()) {
            hashMap.put(FIELD_REFPSDEVSLNTEMPLNAME, this.getRefPSDevSlnTemplName());
        }
        if (!bl || this.isRefRepMsgDirty()) {
            hashMap.put(FIELD_REFREPMSG, this.getRefRepMsg());
        }
        if (!bl || this.isRefReqMsgDirty()) {
            hashMap.put(FIELD_REFREQMSG, this.getRefReqMsg());
        }
        if (!bl || this.isRefStateDirty()) {
            hashMap.put(FIELD_REFSTATE, this.getRefState());
        }
        if (!bl || this.isRefStateInfoDirty()) {
            hashMap.put(FIELD_REFSTATEINFO, this.getRefStateInfo());
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
        return PSDevSlnTemplRefBase.get(this, n);
    }

    private static Object get(PSDevSlnTemplRefBase pSDevSlnTemplRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnTemplRefBase.getAccessToken();
            }
            case 1: {
                return pSDevSlnTemplRefBase.getBeginTime();
            }
            case 2: {
                return pSDevSlnTemplRefBase.getCreateDate();
            }
            case 3: {
                return pSDevSlnTemplRefBase.getCreateMan();
            }
            case 4: {
                return pSDevSlnTemplRefBase.getEndTime();
            }
            case 5: {
                return pSDevSlnTemplRefBase.getMemo();
            }
            case 6: {
                return pSDevSlnTemplRefBase.getPSDevCenterName();
            }
            case 7: {
                return pSDevSlnTemplRefBase.getPSDevSlnTemplId();
            }
            case 8: {
                return pSDevSlnTemplRefBase.getPSDevSlnTemplName();
            }
            case 9: {
                return pSDevSlnTemplRefBase.getPSDevSlnTemplRefId();
            }
            case 10: {
                return pSDevSlnTemplRefBase.getPSDevSlnTemplRefName();
            }
            case 11: {
                return pSDevSlnTemplRefBase.getRefPSDevSlnTemplId();
            }
            case 12: {
                return pSDevSlnTemplRefBase.getRefPSDevSlnTemplName();
            }
            case 13: {
                return pSDevSlnTemplRefBase.getRefRepMsg();
            }
            case 14: {
                return pSDevSlnTemplRefBase.getRefReqMsg();
            }
            case 15: {
                return pSDevSlnTemplRefBase.getRefState();
            }
            case 16: {
                return pSDevSlnTemplRefBase.getRefStateInfo();
            }
            case 17: {
                return pSDevSlnTemplRefBase.getUpdateDate();
            }
            case 18: {
                return pSDevSlnTemplRefBase.getUpdateMan();
            }
            case 19: {
                return pSDevSlnTemplRefBase.getValidFlag();
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
        PSDevSlnTemplRefBase.set(this, n, object);
    }

    private static void set(PSDevSlnTemplRefBase pSDevSlnTemplRefBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnTemplRefBase.setAccessToken(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDevSlnTemplRefBase.setBeginTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDevSlnTemplRefBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSDevSlnTemplRefBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDevSlnTemplRefBase.setEndTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 5: {
                pSDevSlnTemplRefBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDevSlnTemplRefBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDevSlnTemplRefBase.setPSDevSlnTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDevSlnTemplRefBase.setPSDevSlnTemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDevSlnTemplRefBase.setPSDevSlnTemplRefId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDevSlnTemplRefBase.setPSDevSlnTemplRefName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDevSlnTemplRefBase.setRefPSDevSlnTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDevSlnTemplRefBase.setRefPSDevSlnTemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDevSlnTemplRefBase.setRefRepMsg(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDevSlnTemplRefBase.setRefReqMsg(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDevSlnTemplRefBase.setRefState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSDevSlnTemplRefBase.setRefStateInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDevSlnTemplRefBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 18: {
                pSDevSlnTemplRefBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDevSlnTemplRefBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDevSlnTemplRefBase.isNull(this, n);
    }

    private static boolean isNull(PSDevSlnTemplRefBase pSDevSlnTemplRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnTemplRefBase.getAccessToken() == null;
            }
            case 1: {
                return pSDevSlnTemplRefBase.getBeginTime() == null;
            }
            case 2: {
                return pSDevSlnTemplRefBase.getCreateDate() == null;
            }
            case 3: {
                return pSDevSlnTemplRefBase.getCreateMan() == null;
            }
            case 4: {
                return pSDevSlnTemplRefBase.getEndTime() == null;
            }
            case 5: {
                return pSDevSlnTemplRefBase.getMemo() == null;
            }
            case 6: {
                return pSDevSlnTemplRefBase.getPSDevCenterName() == null;
            }
            case 7: {
                return pSDevSlnTemplRefBase.getPSDevSlnTemplId() == null;
            }
            case 8: {
                return pSDevSlnTemplRefBase.getPSDevSlnTemplName() == null;
            }
            case 9: {
                return pSDevSlnTemplRefBase.getPSDevSlnTemplRefId() == null;
            }
            case 10: {
                return pSDevSlnTemplRefBase.getPSDevSlnTemplRefName() == null;
            }
            case 11: {
                return pSDevSlnTemplRefBase.getRefPSDevSlnTemplId() == null;
            }
            case 12: {
                return pSDevSlnTemplRefBase.getRefPSDevSlnTemplName() == null;
            }
            case 13: {
                return pSDevSlnTemplRefBase.getRefRepMsg() == null;
            }
            case 14: {
                return pSDevSlnTemplRefBase.getRefReqMsg() == null;
            }
            case 15: {
                return pSDevSlnTemplRefBase.getRefState() == null;
            }
            case 16: {
                return pSDevSlnTemplRefBase.getRefStateInfo() == null;
            }
            case 17: {
                return pSDevSlnTemplRefBase.getUpdateDate() == null;
            }
            case 18: {
                return pSDevSlnTemplRefBase.getUpdateMan() == null;
            }
            case 19: {
                return pSDevSlnTemplRefBase.getValidFlag() == null;
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
        return PSDevSlnTemplRefBase.contains(this, n);
    }

    private static boolean contains(PSDevSlnTemplRefBase pSDevSlnTemplRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnTemplRefBase.isAccessTokenDirty();
            }
            case 1: {
                return pSDevSlnTemplRefBase.isBeginTimeDirty();
            }
            case 2: {
                return pSDevSlnTemplRefBase.isCreateDateDirty();
            }
            case 3: {
                return pSDevSlnTemplRefBase.isCreateManDirty();
            }
            case 4: {
                return pSDevSlnTemplRefBase.isEndTimeDirty();
            }
            case 5: {
                return pSDevSlnTemplRefBase.isMemoDirty();
            }
            case 6: {
                return pSDevSlnTemplRefBase.isPSDevCenterNameDirty();
            }
            case 7: {
                return pSDevSlnTemplRefBase.isPSDevSlnTemplIdDirty();
            }
            case 8: {
                return pSDevSlnTemplRefBase.isPSDevSlnTemplNameDirty();
            }
            case 9: {
                return pSDevSlnTemplRefBase.isPSDevSlnTemplRefIdDirty();
            }
            case 10: {
                return pSDevSlnTemplRefBase.isPSDevSlnTemplRefNameDirty();
            }
            case 11: {
                return pSDevSlnTemplRefBase.isRefPSDevSlnTemplIdDirty();
            }
            case 12: {
                return pSDevSlnTemplRefBase.isRefPSDevSlnTemplNameDirty();
            }
            case 13: {
                return pSDevSlnTemplRefBase.isRefRepMsgDirty();
            }
            case 14: {
                return pSDevSlnTemplRefBase.isRefReqMsgDirty();
            }
            case 15: {
                return pSDevSlnTemplRefBase.isRefStateDirty();
            }
            case 16: {
                return pSDevSlnTemplRefBase.isRefStateInfoDirty();
            }
            case 17: {
                return pSDevSlnTemplRefBase.isUpdateDateDirty();
            }
            case 18: {
                return pSDevSlnTemplRefBase.isUpdateManDirty();
            }
            case 19: {
                return pSDevSlnTemplRefBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevSlnTemplRefBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevSlnTemplRefBase pSDevSlnTemplRefBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevSlnTemplRefBase.getAccessToken() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"accesstoken", (Object)PSDevSlnTemplRefBase.getJSONValue((Object)pSDevSlnTemplRefBase.getAccessToken()), (boolean)false);
        }
        if (bl || pSDevSlnTemplRefBase.getBeginTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"begintime", (Object)PSDevSlnTemplRefBase.getJSONValue((Object)pSDevSlnTemplRefBase.getBeginTime()), (boolean)false);
        }
        if (bl || pSDevSlnTemplRefBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevSlnTemplRefBase.getJSONValue((Object)pSDevSlnTemplRefBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevSlnTemplRefBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevSlnTemplRefBase.getJSONValue((Object)pSDevSlnTemplRefBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevSlnTemplRefBase.getEndTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"endtime", (Object)PSDevSlnTemplRefBase.getJSONValue((Object)pSDevSlnTemplRefBase.getEndTime()), (boolean)false);
        }
        if (bl || pSDevSlnTemplRefBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDevSlnTemplRefBase.getJSONValue((Object)pSDevSlnTemplRefBase.getMemo()), (boolean)false);
        }
        if (bl || pSDevSlnTemplRefBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDevSlnTemplRefBase.getJSONValue((Object)pSDevSlnTemplRefBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDevSlnTemplRefBase.getPSDevSlnTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslntemplid", (Object)PSDevSlnTemplRefBase.getJSONValue((Object)pSDevSlnTemplRefBase.getPSDevSlnTemplId()), (boolean)false);
        }
        if (bl || pSDevSlnTemplRefBase.getPSDevSlnTemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslntemplname", (Object)PSDevSlnTemplRefBase.getJSONValue((Object)pSDevSlnTemplRefBase.getPSDevSlnTemplName()), (boolean)false);
        }
        if (bl || pSDevSlnTemplRefBase.getPSDevSlnTemplRefId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslntemplrefid", (Object)PSDevSlnTemplRefBase.getJSONValue((Object)pSDevSlnTemplRefBase.getPSDevSlnTemplRefId()), (boolean)false);
        }
        if (bl || pSDevSlnTemplRefBase.getPSDevSlnTemplRefName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslntemplrefname", (Object)PSDevSlnTemplRefBase.getJSONValue((Object)pSDevSlnTemplRefBase.getPSDevSlnTemplRefName()), (boolean)false);
        }
        if (bl || pSDevSlnTemplRefBase.getRefPSDevSlnTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdevslntemplid", (Object)PSDevSlnTemplRefBase.getJSONValue((Object)pSDevSlnTemplRefBase.getRefPSDevSlnTemplId()), (boolean)false);
        }
        if (bl || pSDevSlnTemplRefBase.getRefPSDevSlnTemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdevslntemplname", (Object)PSDevSlnTemplRefBase.getJSONValue((Object)pSDevSlnTemplRefBase.getRefPSDevSlnTemplName()), (boolean)false);
        }
        if (bl || pSDevSlnTemplRefBase.getRefRepMsg() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refrepmsg", (Object)PSDevSlnTemplRefBase.getJSONValue((Object)pSDevSlnTemplRefBase.getRefRepMsg()), (boolean)false);
        }
        if (bl || pSDevSlnTemplRefBase.getRefReqMsg() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refreqmsg", (Object)PSDevSlnTemplRefBase.getJSONValue((Object)pSDevSlnTemplRefBase.getRefReqMsg()), (boolean)false);
        }
        if (bl || pSDevSlnTemplRefBase.getRefState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refstate", (Object)PSDevSlnTemplRefBase.getJSONValue((Object)pSDevSlnTemplRefBase.getRefState()), (boolean)false);
        }
        if (bl || pSDevSlnTemplRefBase.getRefStateInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refstateinfo", (Object)PSDevSlnTemplRefBase.getJSONValue((Object)pSDevSlnTemplRefBase.getRefStateInfo()), (boolean)false);
        }
        if (bl || pSDevSlnTemplRefBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevSlnTemplRefBase.getJSONValue((Object)pSDevSlnTemplRefBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevSlnTemplRefBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevSlnTemplRefBase.getJSONValue((Object)pSDevSlnTemplRefBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDevSlnTemplRefBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDevSlnTemplRefBase.getJSONValue((Object)pSDevSlnTemplRefBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevSlnTemplRefBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevSlnTemplRefBase pSDevSlnTemplRefBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevSlnTemplRefBase.getAccessToken() != null) {
            object = pSDevSlnTemplRefBase.getAccessToken();
            xmlNode.setAttribute(FIELD_ACCESSTOKEN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnTemplRefBase.getBeginTime() != null) {
            object = pSDevSlnTemplRefBase.getBeginTime();
            xmlNode.setAttribute(FIELD_BEGINTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnTemplRefBase.getCreateDate() != null) {
            object = pSDevSlnTemplRefBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnTemplRefBase.getCreateMan() != null) {
            object = pSDevSlnTemplRefBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnTemplRefBase.getEndTime() != null) {
            object = pSDevSlnTemplRefBase.getEndTime();
            xmlNode.setAttribute(FIELD_ENDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnTemplRefBase.getMemo() != null) {
            object = pSDevSlnTemplRefBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnTemplRefBase.getPSDevCenterName() != null) {
            object = pSDevSlnTemplRefBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnTemplRefBase.getPSDevSlnTemplId() != null) {
            object = pSDevSlnTemplRefBase.getPSDevSlnTemplId();
            xmlNode.setAttribute(FIELD_PSDEVSLNTEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnTemplRefBase.getPSDevSlnTemplName() != null) {
            object = pSDevSlnTemplRefBase.getPSDevSlnTemplName();
            xmlNode.setAttribute(FIELD_PSDEVSLNTEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnTemplRefBase.getPSDevSlnTemplRefId() != null) {
            object = pSDevSlnTemplRefBase.getPSDevSlnTemplRefId();
            xmlNode.setAttribute(FIELD_PSDEVSLNTEMPLREFID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnTemplRefBase.getPSDevSlnTemplRefName() != null) {
            object = pSDevSlnTemplRefBase.getPSDevSlnTemplRefName();
            xmlNode.setAttribute(FIELD_PSDEVSLNTEMPLREFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnTemplRefBase.getRefPSDevSlnTemplId() != null) {
            object = pSDevSlnTemplRefBase.getRefPSDevSlnTemplId();
            xmlNode.setAttribute(FIELD_REFPSDEVSLNTEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnTemplRefBase.getRefPSDevSlnTemplName() != null) {
            object = pSDevSlnTemplRefBase.getRefPSDevSlnTemplName();
            xmlNode.setAttribute(FIELD_REFPSDEVSLNTEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnTemplRefBase.getRefRepMsg() != null) {
            object = pSDevSlnTemplRefBase.getRefRepMsg();
            xmlNode.setAttribute(FIELD_REFREPMSG, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnTemplRefBase.getRefReqMsg() != null) {
            object = pSDevSlnTemplRefBase.getRefReqMsg();
            xmlNode.setAttribute(FIELD_REFREQMSG, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnTemplRefBase.getRefState() != null) {
            object = pSDevSlnTemplRefBase.getRefState();
            xmlNode.setAttribute(FIELD_REFSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnTemplRefBase.getRefStateInfo() != null) {
            object = pSDevSlnTemplRefBase.getRefStateInfo();
            xmlNode.setAttribute(FIELD_REFSTATEINFO, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnTemplRefBase.getUpdateDate() != null) {
            object = pSDevSlnTemplRefBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnTemplRefBase.getUpdateMan() != null) {
            object = pSDevSlnTemplRefBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnTemplRefBase.getValidFlag() != null) {
            object = pSDevSlnTemplRefBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevSlnTemplRefBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevSlnTemplRefBase pSDevSlnTemplRefBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevSlnTemplRefBase.isAccessTokenDirty() && (bl || pSDevSlnTemplRefBase.getAccessToken() != null)) {
            iDataObject.set(FIELD_ACCESSTOKEN, (Object)pSDevSlnTemplRefBase.getAccessToken());
        }
        if (pSDevSlnTemplRefBase.isBeginTimeDirty() && (bl || pSDevSlnTemplRefBase.getBeginTime() != null)) {
            iDataObject.set(FIELD_BEGINTIME, (Object)pSDevSlnTemplRefBase.getBeginTime());
        }
        if (pSDevSlnTemplRefBase.isCreateDateDirty() && (bl || pSDevSlnTemplRefBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevSlnTemplRefBase.getCreateDate());
        }
        if (pSDevSlnTemplRefBase.isCreateManDirty() && (bl || pSDevSlnTemplRefBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevSlnTemplRefBase.getCreateMan());
        }
        if (pSDevSlnTemplRefBase.isEndTimeDirty() && (bl || pSDevSlnTemplRefBase.getEndTime() != null)) {
            iDataObject.set(FIELD_ENDTIME, (Object)pSDevSlnTemplRefBase.getEndTime());
        }
        if (pSDevSlnTemplRefBase.isMemoDirty() && (bl || pSDevSlnTemplRefBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDevSlnTemplRefBase.getMemo());
        }
        if (pSDevSlnTemplRefBase.isPSDevCenterNameDirty() && (bl || pSDevSlnTemplRefBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDevSlnTemplRefBase.getPSDevCenterName());
        }
        if (pSDevSlnTemplRefBase.isPSDevSlnTemplIdDirty() && (bl || pSDevSlnTemplRefBase.getPSDevSlnTemplId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNTEMPLID, (Object)pSDevSlnTemplRefBase.getPSDevSlnTemplId());
        }
        if (pSDevSlnTemplRefBase.isPSDevSlnTemplNameDirty() && (bl || pSDevSlnTemplRefBase.getPSDevSlnTemplName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNTEMPLNAME, (Object)pSDevSlnTemplRefBase.getPSDevSlnTemplName());
        }
        if (pSDevSlnTemplRefBase.isPSDevSlnTemplRefIdDirty() && (bl || pSDevSlnTemplRefBase.getPSDevSlnTemplRefId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNTEMPLREFID, (Object)pSDevSlnTemplRefBase.getPSDevSlnTemplRefId());
        }
        if (pSDevSlnTemplRefBase.isPSDevSlnTemplRefNameDirty() && (bl || pSDevSlnTemplRefBase.getPSDevSlnTemplRefName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNTEMPLREFNAME, (Object)pSDevSlnTemplRefBase.getPSDevSlnTemplRefName());
        }
        if (pSDevSlnTemplRefBase.isRefPSDevSlnTemplIdDirty() && (bl || pSDevSlnTemplRefBase.getRefPSDevSlnTemplId() != null)) {
            iDataObject.set(FIELD_REFPSDEVSLNTEMPLID, (Object)pSDevSlnTemplRefBase.getRefPSDevSlnTemplId());
        }
        if (pSDevSlnTemplRefBase.isRefPSDevSlnTemplNameDirty() && (bl || pSDevSlnTemplRefBase.getRefPSDevSlnTemplName() != null)) {
            iDataObject.set(FIELD_REFPSDEVSLNTEMPLNAME, (Object)pSDevSlnTemplRefBase.getRefPSDevSlnTemplName());
        }
        if (pSDevSlnTemplRefBase.isRefRepMsgDirty() && (bl || pSDevSlnTemplRefBase.getRefRepMsg() != null)) {
            iDataObject.set(FIELD_REFREPMSG, (Object)pSDevSlnTemplRefBase.getRefRepMsg());
        }
        if (pSDevSlnTemplRefBase.isRefReqMsgDirty() && (bl || pSDevSlnTemplRefBase.getRefReqMsg() != null)) {
            iDataObject.set(FIELD_REFREQMSG, (Object)pSDevSlnTemplRefBase.getRefReqMsg());
        }
        if (pSDevSlnTemplRefBase.isRefStateDirty() && (bl || pSDevSlnTemplRefBase.getRefState() != null)) {
            iDataObject.set(FIELD_REFSTATE, (Object)pSDevSlnTemplRefBase.getRefState());
        }
        if (pSDevSlnTemplRefBase.isRefStateInfoDirty() && (bl || pSDevSlnTemplRefBase.getRefStateInfo() != null)) {
            iDataObject.set(FIELD_REFSTATEINFO, (Object)pSDevSlnTemplRefBase.getRefStateInfo());
        }
        if (pSDevSlnTemplRefBase.isUpdateDateDirty() && (bl || pSDevSlnTemplRefBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevSlnTemplRefBase.getUpdateDate());
        }
        if (pSDevSlnTemplRefBase.isUpdateManDirty() && (bl || pSDevSlnTemplRefBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevSlnTemplRefBase.getUpdateMan());
        }
        if (pSDevSlnTemplRefBase.isValidFlagDirty() && (bl || pSDevSlnTemplRefBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDevSlnTemplRefBase.getValidFlag());
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
        return PSDevSlnTemplRefBase.remove(this, n);
    }

    private static boolean remove(PSDevSlnTemplRefBase pSDevSlnTemplRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnTemplRefBase.resetAccessToken();
                return true;
            }
            case 1: {
                pSDevSlnTemplRefBase.resetBeginTime();
                return true;
            }
            case 2: {
                pSDevSlnTemplRefBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSDevSlnTemplRefBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSDevSlnTemplRefBase.resetEndTime();
                return true;
            }
            case 5: {
                pSDevSlnTemplRefBase.resetMemo();
                return true;
            }
            case 6: {
                pSDevSlnTemplRefBase.resetPSDevCenterName();
                return true;
            }
            case 7: {
                pSDevSlnTemplRefBase.resetPSDevSlnTemplId();
                return true;
            }
            case 8: {
                pSDevSlnTemplRefBase.resetPSDevSlnTemplName();
                return true;
            }
            case 9: {
                pSDevSlnTemplRefBase.resetPSDevSlnTemplRefId();
                return true;
            }
            case 10: {
                pSDevSlnTemplRefBase.resetPSDevSlnTemplRefName();
                return true;
            }
            case 11: {
                pSDevSlnTemplRefBase.resetRefPSDevSlnTemplId();
                return true;
            }
            case 12: {
                pSDevSlnTemplRefBase.resetRefPSDevSlnTemplName();
                return true;
            }
            case 13: {
                pSDevSlnTemplRefBase.resetRefRepMsg();
                return true;
            }
            case 14: {
                pSDevSlnTemplRefBase.resetRefReqMsg();
                return true;
            }
            case 15: {
                pSDevSlnTemplRefBase.resetRefState();
                return true;
            }
            case 16: {
                pSDevSlnTemplRefBase.resetRefStateInfo();
                return true;
            }
            case 17: {
                pSDevSlnTemplRefBase.resetUpdateDate();
                return true;
            }
            case 18: {
                pSDevSlnTemplRefBase.resetUpdateMan();
                return true;
            }
            case 19: {
                pSDevSlnTemplRefBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnTempl getPSDevSlnTempl() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnTempl();
        }
        if (this.getPSDevSlnTemplId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnTemplLock;
        synchronized (n) {
            if (this.psdevslntempl != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnTemplId(), (Object)this.psdevslntempl.getPSDevSlnTemplId()) != 0L) {
                this.psdevslntempl = null;
            }
            if (this.psdevslntempl == null) {
                PSDevSlnTempl pSDevSlnTempl = new PSDevSlnTempl();
                pSDevSlnTempl.setPSDevSlnTemplId(this.getPSDevSlnTemplId());
                PSDevSlnTemplService pSDevSlnTemplService = (PSDevSlnTemplService)ServiceGlobal.getService(PSDevSlnTemplService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnTemplService.autoGet(pSDevSlnTempl);
                this.psdevslntempl = pSDevSlnTempl;
            }
            return this.psdevslntempl;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnTempl getRefPSDevSlnTempl() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDevSlnTempl();
        }
        if (this.getRefPSDevSlnTemplId() == null) {
            return null;
        }
        Integer n = this.objRefPSDevSlnTemplLock;
        synchronized (n) {
            if (this.refpsdevslntempl != null && DataTypeHelper.compare((int)25, (Object)this.getRefPSDevSlnTemplId(), (Object)this.refpsdevslntempl.getPSDevSlnTemplId()) != 0L) {
                this.refpsdevslntempl = null;
            }
            if (this.refpsdevslntempl == null) {
                PSDevSlnTempl pSDevSlnTempl = new PSDevSlnTempl();
                pSDevSlnTempl.setPSDevSlnTemplId(this.getRefPSDevSlnTemplId());
                PSDevSlnTemplService pSDevSlnTemplService = (PSDevSlnTemplService)ServiceGlobal.getService(PSDevSlnTemplService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnTemplService.autoGet(pSDevSlnTempl);
                this.refpsdevslntempl = pSDevSlnTempl;
            }
            return this.refpsdevslntempl;
        }
    }

    private PSDevSlnTemplRefBase getProxyEntity() {
        return this.proxyPSDevSlnTemplRefBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevSlnTemplRefBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevSlnTemplRefBase) {
            this.proxyPSDevSlnTemplRefBase = (PSDevSlnTemplRefBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnTemplRefService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ACCESSTOKEN, 0);
        fieldIndexMap.put(FIELD_BEGINTIME, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_ENDTIME, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 6);
        fieldIndexMap.put(FIELD_PSDEVSLNTEMPLID, 7);
        fieldIndexMap.put(FIELD_PSDEVSLNTEMPLNAME, 8);
        fieldIndexMap.put(FIELD_PSDEVSLNTEMPLREFID, 9);
        fieldIndexMap.put(FIELD_PSDEVSLNTEMPLREFNAME, 10);
        fieldIndexMap.put(FIELD_REFPSDEVSLNTEMPLID, 11);
        fieldIndexMap.put(FIELD_REFPSDEVSLNTEMPLNAME, 12);
        fieldIndexMap.put(FIELD_REFREPMSG, 13);
        fieldIndexMap.put(FIELD_REFREQMSG, 14);
        fieldIndexMap.put(FIELD_REFSTATE, 15);
        fieldIndexMap.put(FIELD_REFSTATEINFO, 16);
        fieldIndexMap.put(FIELD_UPDATEDATE, 17);
        fieldIndexMap.put(FIELD_UPDATEMAN, 18);
        fieldIndexMap.put(FIELD_VALIDFLAG, 19);
    }
}

