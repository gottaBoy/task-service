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
package net.ibizsys.pscore.srv.config.entity;

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
import net.ibizsys.pscore.srv.config.entity.PSSFStyle;
import net.ibizsys.pscore.srv.config.entity.PSSFVerCode;
import net.ibizsys.pscore.srv.config.service.PSSFStyleService;
import net.ibizsys.pscore.srv.config.service.PSSFVerCodeService;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterSVN;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterSVNService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSFStyleVerBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSFStyleVerBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_LASTIMPTIME = "LASTIMPTIME";
    public static final String FIELD_MAJOR = "MAJOR";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MINOR = "MINOR";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSDEVCENTERSVNID = "PSDEVCENTERSVNID";
    public static final String FIELD_PSDEVCENTERSVNNAME = "PSDEVCENTERSVNNAME";
    public static final String FIELD_PSSFID = "PSSFID";
    public static final String FIELD_PSSFSTYLEID = "PSSFSTYLEID";
    public static final String FIELD_PSSFSTYLENAME = "PSSFSTYLENAME";
    public static final String FIELD_PSSFSTYLEVERID = "PSSFSTYLEVERID";
    public static final String FIELD_PSSFSTYLEVERNAME = "PSSFSTYLEVERNAME";
    public static final String FIELD_PUBMODE = "PUBMODE";
    public static final String FIELD_TEMPLINFO = "TEMPLINFO";
    public static final String FIELD_TEMPLSTATE = "TEMPLSTATE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    public static final String FIELD_VERSION = "VERSION";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_LASTIMPTIME = 2;
    private static final int INDEX_MAJOR = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_MINOR = 5;
    private static final int INDEX_PSDEVCENTERID = 6;
    private static final int INDEX_PSDEVCENTERNAME = 7;
    private static final int INDEX_PSDEVCENTERSVNID = 8;
    private static final int INDEX_PSDEVCENTERSVNNAME = 9;
    private static final int INDEX_PSSFID = 10;
    private static final int INDEX_PSSFSTYLEID = 11;
    private static final int INDEX_PSSFSTYLENAME = 12;
    private static final int INDEX_PSSFSTYLEVERID = 13;
    private static final int INDEX_PSSFSTYLEVERNAME = 14;
    private static final int INDEX_PUBMODE = 15;
    private static final int INDEX_TEMPLINFO = 16;
    private static final int INDEX_TEMPLSTATE = 17;
    private static final int INDEX_UPDATEDATE = 18;
    private static final int INDEX_UPDATEMAN = 19;
    private static final int INDEX_VALIDFLAG = 20;
    private static final int INDEX_VERSION = 21;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSFStyleVerBase proxyPSSFStyleVerBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean lastimptimeDirtyFlag = false;
    private boolean majorDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean minorDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psdevcentersvnidDirtyFlag = false;
    private boolean psdevcentersvnnameDirtyFlag = false;
    private boolean pssfidDirtyFlag = false;
    private boolean pssfstyleidDirtyFlag = false;
    private boolean pssfstylenameDirtyFlag = false;
    private boolean pssfstyleveridDirtyFlag = false;
    private boolean pssfstylevernameDirtyFlag = false;
    private boolean pubmodeDirtyFlag = false;
    private boolean templinfoDirtyFlag = false;
    private boolean templstateDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    private boolean versionDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="lastimptime")
    private Timestamp lastimptime;
    @Column(name="major")
    private Integer major;
    @Column(name="memo")
    private String memo;
    @Column(name="minor")
    private Integer minor;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="psdevcentersvnid")
    private String psdevcentersvnid;
    @Column(name="psdevcentersvnname")
    private String psdevcentersvnname;
    @Column(name="pssfid")
    private String pssfid;
    @Column(name="pssfstyleid")
    private String pssfstyleid;
    @Column(name="pssfstylename")
    private String pssfstylename;
    @Column(name="pssfstyleverid")
    private String pssfstyleverid;
    @Column(name="pssfstylevername")
    private String pssfstylevername;
    @Column(name="pubmode")
    private Integer pubmode;
    @Column(name="templinfo")
    private String templinfo;
    @Column(name="templstate")
    private Integer templstate;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    @Column(name="version")
    private String version;
    private Integer objPSDevCenterSVNLock = new Integer(1);
    private PSDevCenterSVN psdevcentersvn = null;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objPSSFStyleLock = new Integer(1);
    private PSSFStyle pssfstyle = null;
    private Integer objPSSFVerCodesLock = new Integer(1);
    private ArrayList<PSSFVerCode> pssfvercodes = null;

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

    public void setLastImpTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLastImpTime(timestamp);
            return;
        }
        this.lastimptime = timestamp;
        this.lastimptimeDirtyFlag = true;
    }

    public Timestamp getLastImpTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLastImpTime();
        }
        return this.lastimptime;
    }

    public boolean isLastImpTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLastImpTimeDirty();
        }
        return this.lastimptimeDirtyFlag;
    }

    public void resetLastImpTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLastImpTime();
            return;
        }
        this.lastimptimeDirtyFlag = false;
        this.lastimptime = null;
    }

    public void setMajor(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMajor(n);
            return;
        }
        this.major = n;
        this.majorDirtyFlag = true;
    }

    public Integer getMajor() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMajor();
        }
        return this.major;
    }

    public boolean isMajorDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMajorDirty();
        }
        return this.majorDirtyFlag;
    }

    public void resetMajor() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMajor();
            return;
        }
        this.majorDirtyFlag = false;
        this.major = null;
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

    public void setMinor(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinor(n);
            return;
        }
        this.minor = n;
        this.minorDirtyFlag = true;
    }

    public Integer getMinor() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinor();
        }
        return this.minor;
    }

    public boolean isMinorDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinorDirty();
        }
        return this.minorDirtyFlag;
    }

    public void resetMinor() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinor();
            return;
        }
        this.minorDirtyFlag = false;
        this.minor = null;
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

    public void setPSDevCenterSVNId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterSVNId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcentersvnid = string;
        this.psdevcentersvnidDirtyFlag = true;
    }

    public String getPSDevCenterSVNId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterSVNId();
        }
        return this.psdevcentersvnid;
    }

    public boolean isPSDevCenterSVNIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterSVNIdDirty();
        }
        return this.psdevcentersvnidDirtyFlag;
    }

    public void resetPSDevCenterSVNId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterSVNId();
            return;
        }
        this.psdevcentersvnidDirtyFlag = false;
        this.psdevcentersvnid = null;
    }

    public void setPSDevCenterSVNName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterSVNName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcentersvnname = string;
        this.psdevcentersvnnameDirtyFlag = true;
    }

    public String getPSDevCenterSVNName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterSVNName();
        }
        return this.psdevcentersvnname;
    }

    public boolean isPSDevCenterSVNNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterSVNNameDirty();
        }
        return this.psdevcentersvnnameDirtyFlag;
    }

    public void resetPSDevCenterSVNName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterSVNName();
            return;
        }
        this.psdevcentersvnnameDirtyFlag = false;
        this.psdevcentersvnname = null;
    }

    public void setPSSFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfid = string;
        this.pssfidDirtyFlag = true;
    }

    public String getPSSFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFId();
        }
        return this.pssfid;
    }

    public boolean isPSSFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFIdDirty();
        }
        return this.pssfidDirtyFlag;
    }

    public void resetPSSFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFId();
            return;
        }
        this.pssfidDirtyFlag = false;
        this.pssfid = null;
    }

    public void setPSSFStyleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFStyleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfstyleid = string;
        this.pssfstyleidDirtyFlag = true;
    }

    public String getPSSFStyleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStyleId();
        }
        return this.pssfstyleid;
    }

    public boolean isPSSFStyleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFStyleIdDirty();
        }
        return this.pssfstyleidDirtyFlag;
    }

    public void resetPSSFStyleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFStyleId();
            return;
        }
        this.pssfstyleidDirtyFlag = false;
        this.pssfstyleid = null;
    }

    public void setPSSFStyleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFStyleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfstylename = string;
        this.pssfstylenameDirtyFlag = true;
    }

    public String getPSSFStyleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStyleName();
        }
        return this.pssfstylename;
    }

    public boolean isPSSFStyleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFStyleNameDirty();
        }
        return this.pssfstylenameDirtyFlag;
    }

    public void resetPSSFStyleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFStyleName();
            return;
        }
        this.pssfstylenameDirtyFlag = false;
        this.pssfstylename = null;
    }

    public void setPSSFStyleVerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFStyleVerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfstyleverid = string;
        this.pssfstyleveridDirtyFlag = true;
    }

    public String getPSSFStyleVerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStyleVerId();
        }
        return this.pssfstyleverid;
    }

    public boolean isPSSFStyleVerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFStyleVerIdDirty();
        }
        return this.pssfstyleveridDirtyFlag;
    }

    public void resetPSSFStyleVerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFStyleVerId();
            return;
        }
        this.pssfstyleveridDirtyFlag = false;
        this.pssfstyleverid = null;
    }

    public void setPSSFStyleVerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFStyleVerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfstylevername = string;
        this.pssfstylevernameDirtyFlag = true;
    }

    public String getPSSFStyleVerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStyleVerName();
        }
        return this.pssfstylevername;
    }

    public boolean isPSSFStyleVerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFStyleVerNameDirty();
        }
        return this.pssfstylevernameDirtyFlag;
    }

    public void resetPSSFStyleVerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFStyleVerName();
            return;
        }
        this.pssfstylevernameDirtyFlag = false;
        this.pssfstylevername = null;
    }

    public void setPubMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPubMode(n);
            return;
        }
        this.pubmode = n;
        this.pubmodeDirtyFlag = true;
    }

    public Integer getPubMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPubMode();
        }
        return this.pubmode;
    }

    public boolean isPubModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPubModeDirty();
        }
        return this.pubmodeDirtyFlag;
    }

    public void resetPubMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPubMode();
            return;
        }
        this.pubmodeDirtyFlag = false;
        this.pubmode = null;
    }

    public void setTemplInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.templinfo = string;
        this.templinfoDirtyFlag = true;
    }

    public String getTemplInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplInfo();
        }
        return this.templinfo;
    }

    public boolean isTemplInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplInfoDirty();
        }
        return this.templinfoDirtyFlag;
    }

    public void resetTemplInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplInfo();
            return;
        }
        this.templinfoDirtyFlag = false;
        this.templinfo = null;
    }

    public void setTemplState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplState(n);
            return;
        }
        this.templstate = n;
        this.templstateDirtyFlag = true;
    }

    public Integer getTemplState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplState();
        }
        return this.templstate;
    }

    public boolean isTemplStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplStateDirty();
        }
        return this.templstateDirtyFlag;
    }

    public void resetTemplState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplState();
            return;
        }
        this.templstateDirtyFlag = false;
        this.templstate = null;
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

    public void setVersion(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVersion(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.version = string;
        this.versionDirtyFlag = true;
    }

    public String getVersion() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVersion();
        }
        return this.version;
    }

    public boolean isVersionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVersionDirty();
        }
        return this.versionDirtyFlag;
    }

    public void resetVersion() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVersion();
            return;
        }
        this.versionDirtyFlag = false;
        this.version = null;
    }

    protected void onReset() {
        PSSFStyleVerBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSFStyleVerBase pSSFStyleVerBase) {
        pSSFStyleVerBase.resetCreateDate();
        pSSFStyleVerBase.resetCreateMan();
        pSSFStyleVerBase.resetLastImpTime();
        pSSFStyleVerBase.resetMajor();
        pSSFStyleVerBase.resetMemo();
        pSSFStyleVerBase.resetMinor();
        pSSFStyleVerBase.resetPSDevCenterId();
        pSSFStyleVerBase.resetPSDevCenterName();
        pSSFStyleVerBase.resetPSDevCenterSVNId();
        pSSFStyleVerBase.resetPSDevCenterSVNName();
        pSSFStyleVerBase.resetPSSFId();
        pSSFStyleVerBase.resetPSSFStyleId();
        pSSFStyleVerBase.resetPSSFStyleName();
        pSSFStyleVerBase.resetPSSFStyleVerId();
        pSSFStyleVerBase.resetPSSFStyleVerName();
        pSSFStyleVerBase.resetPubMode();
        pSSFStyleVerBase.resetTemplInfo();
        pSSFStyleVerBase.resetTemplState();
        pSSFStyleVerBase.resetUpdateDate();
        pSSFStyleVerBase.resetUpdateMan();
        pSSFStyleVerBase.resetValidFlag();
        pSSFStyleVerBase.resetVersion();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isLastImpTimeDirty()) {
            hashMap.put(FIELD_LASTIMPTIME, this.getLastImpTime());
        }
        if (!bl || this.isMajorDirty()) {
            hashMap.put(FIELD_MAJOR, this.getMajor());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMinorDirty()) {
            hashMap.put(FIELD_MINOR, this.getMinor());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSDevCenterSVNIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERSVNID, this.getPSDevCenterSVNId());
        }
        if (!bl || this.isPSDevCenterSVNNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERSVNNAME, this.getPSDevCenterSVNName());
        }
        if (!bl || this.isPSSFIdDirty()) {
            hashMap.put(FIELD_PSSFID, this.getPSSFId());
        }
        if (!bl || this.isPSSFStyleIdDirty()) {
            hashMap.put(FIELD_PSSFSTYLEID, this.getPSSFStyleId());
        }
        if (!bl || this.isPSSFStyleNameDirty()) {
            hashMap.put(FIELD_PSSFSTYLENAME, this.getPSSFStyleName());
        }
        if (!bl || this.isPSSFStyleVerIdDirty()) {
            hashMap.put(FIELD_PSSFSTYLEVERID, this.getPSSFStyleVerId());
        }
        if (!bl || this.isPSSFStyleVerNameDirty()) {
            hashMap.put(FIELD_PSSFSTYLEVERNAME, this.getPSSFStyleVerName());
        }
        if (!bl || this.isPubModeDirty()) {
            hashMap.put(FIELD_PUBMODE, this.getPubMode());
        }
        if (!bl || this.isTemplInfoDirty()) {
            hashMap.put(FIELD_TEMPLINFO, this.getTemplInfo());
        }
        if (!bl || this.isTemplStateDirty()) {
            hashMap.put(FIELD_TEMPLSTATE, this.getTemplState());
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
        if (!bl || this.isVersionDirty()) {
            hashMap.put(FIELD_VERSION, this.getVersion());
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
        return PSSFStyleVerBase.get(this, n);
    }

    private static Object get(PSSFStyleVerBase pSSFStyleVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFStyleVerBase.getCreateDate();
            }
            case 1: {
                return pSSFStyleVerBase.getCreateMan();
            }
            case 2: {
                return pSSFStyleVerBase.getLastImpTime();
            }
            case 3: {
                return pSSFStyleVerBase.getMajor();
            }
            case 4: {
                return pSSFStyleVerBase.getMemo();
            }
            case 5: {
                return pSSFStyleVerBase.getMinor();
            }
            case 6: {
                return pSSFStyleVerBase.getPSDevCenterId();
            }
            case 7: {
                return pSSFStyleVerBase.getPSDevCenterName();
            }
            case 8: {
                return pSSFStyleVerBase.getPSDevCenterSVNId();
            }
            case 9: {
                return pSSFStyleVerBase.getPSDevCenterSVNName();
            }
            case 10: {
                return pSSFStyleVerBase.getPSSFId();
            }
            case 11: {
                return pSSFStyleVerBase.getPSSFStyleId();
            }
            case 12: {
                return pSSFStyleVerBase.getPSSFStyleName();
            }
            case 13: {
                return pSSFStyleVerBase.getPSSFStyleVerId();
            }
            case 14: {
                return pSSFStyleVerBase.getPSSFStyleVerName();
            }
            case 15: {
                return pSSFStyleVerBase.getPubMode();
            }
            case 16: {
                return pSSFStyleVerBase.getTemplInfo();
            }
            case 17: {
                return pSSFStyleVerBase.getTemplState();
            }
            case 18: {
                return pSSFStyleVerBase.getUpdateDate();
            }
            case 19: {
                return pSSFStyleVerBase.getUpdateMan();
            }
            case 20: {
                return pSSFStyleVerBase.getValidFlag();
            }
            case 21: {
                return pSSFStyleVerBase.getVersion();
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
        PSSFStyleVerBase.set(this, n, object);
    }

    private static void set(PSSFStyleVerBase pSSFStyleVerBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSFStyleVerBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSFStyleVerBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSFStyleVerBase.setLastImpTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSSFStyleVerBase.setMajor(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSSFStyleVerBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSFStyleVerBase.setMinor(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSSFStyleVerBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSFStyleVerBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSFStyleVerBase.setPSDevCenterSVNId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSFStyleVerBase.setPSDevCenterSVNName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSFStyleVerBase.setPSSFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSFStyleVerBase.setPSSFStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSFStyleVerBase.setPSSFStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSFStyleVerBase.setPSSFStyleVerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSFStyleVerBase.setPSSFStyleVerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSFStyleVerBase.setPubMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSSFStyleVerBase.setTemplInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSFStyleVerBase.setTemplState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 18: {
                pSSFStyleVerBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 19: {
                pSSFStyleVerBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSFStyleVerBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 21: {
                pSSFStyleVerBase.setVersion(DataObject.getStringValue((Object)object));
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
        return PSSFStyleVerBase.isNull(this, n);
    }

    private static boolean isNull(PSSFStyleVerBase pSSFStyleVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFStyleVerBase.getCreateDate() == null;
            }
            case 1: {
                return pSSFStyleVerBase.getCreateMan() == null;
            }
            case 2: {
                return pSSFStyleVerBase.getLastImpTime() == null;
            }
            case 3: {
                return pSSFStyleVerBase.getMajor() == null;
            }
            case 4: {
                return pSSFStyleVerBase.getMemo() == null;
            }
            case 5: {
                return pSSFStyleVerBase.getMinor() == null;
            }
            case 6: {
                return pSSFStyleVerBase.getPSDevCenterId() == null;
            }
            case 7: {
                return pSSFStyleVerBase.getPSDevCenterName() == null;
            }
            case 8: {
                return pSSFStyleVerBase.getPSDevCenterSVNId() == null;
            }
            case 9: {
                return pSSFStyleVerBase.getPSDevCenterSVNName() == null;
            }
            case 10: {
                return pSSFStyleVerBase.getPSSFId() == null;
            }
            case 11: {
                return pSSFStyleVerBase.getPSSFStyleId() == null;
            }
            case 12: {
                return pSSFStyleVerBase.getPSSFStyleName() == null;
            }
            case 13: {
                return pSSFStyleVerBase.getPSSFStyleVerId() == null;
            }
            case 14: {
                return pSSFStyleVerBase.getPSSFStyleVerName() == null;
            }
            case 15: {
                return pSSFStyleVerBase.getPubMode() == null;
            }
            case 16: {
                return pSSFStyleVerBase.getTemplInfo() == null;
            }
            case 17: {
                return pSSFStyleVerBase.getTemplState() == null;
            }
            case 18: {
                return pSSFStyleVerBase.getUpdateDate() == null;
            }
            case 19: {
                return pSSFStyleVerBase.getUpdateMan() == null;
            }
            case 20: {
                return pSSFStyleVerBase.getValidFlag() == null;
            }
            case 21: {
                return pSSFStyleVerBase.getVersion() == null;
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
        return PSSFStyleVerBase.contains(this, n);
    }

    private static boolean contains(PSSFStyleVerBase pSSFStyleVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFStyleVerBase.isCreateDateDirty();
            }
            case 1: {
                return pSSFStyleVerBase.isCreateManDirty();
            }
            case 2: {
                return pSSFStyleVerBase.isLastImpTimeDirty();
            }
            case 3: {
                return pSSFStyleVerBase.isMajorDirty();
            }
            case 4: {
                return pSSFStyleVerBase.isMemoDirty();
            }
            case 5: {
                return pSSFStyleVerBase.isMinorDirty();
            }
            case 6: {
                return pSSFStyleVerBase.isPSDevCenterIdDirty();
            }
            case 7: {
                return pSSFStyleVerBase.isPSDevCenterNameDirty();
            }
            case 8: {
                return pSSFStyleVerBase.isPSDevCenterSVNIdDirty();
            }
            case 9: {
                return pSSFStyleVerBase.isPSDevCenterSVNNameDirty();
            }
            case 10: {
                return pSSFStyleVerBase.isPSSFIdDirty();
            }
            case 11: {
                return pSSFStyleVerBase.isPSSFStyleIdDirty();
            }
            case 12: {
                return pSSFStyleVerBase.isPSSFStyleNameDirty();
            }
            case 13: {
                return pSSFStyleVerBase.isPSSFStyleVerIdDirty();
            }
            case 14: {
                return pSSFStyleVerBase.isPSSFStyleVerNameDirty();
            }
            case 15: {
                return pSSFStyleVerBase.isPubModeDirty();
            }
            case 16: {
                return pSSFStyleVerBase.isTemplInfoDirty();
            }
            case 17: {
                return pSSFStyleVerBase.isTemplStateDirty();
            }
            case 18: {
                return pSSFStyleVerBase.isUpdateDateDirty();
            }
            case 19: {
                return pSSFStyleVerBase.isUpdateManDirty();
            }
            case 20: {
                return pSSFStyleVerBase.isValidFlagDirty();
            }
            case 21: {
                return pSSFStyleVerBase.isVersionDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSFStyleVerBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSFStyleVerBase pSSFStyleVerBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSFStyleVerBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSFStyleVerBase.getJSONValue((Object)pSSFStyleVerBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSFStyleVerBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSFStyleVerBase.getJSONValue((Object)pSSFStyleVerBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSFStyleVerBase.getLastImpTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lastimptime", (Object)PSSFStyleVerBase.getJSONValue((Object)pSSFStyleVerBase.getLastImpTime()), (boolean)false);
        }
        if (bl || pSSFStyleVerBase.getMajor() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"major", (Object)PSSFStyleVerBase.getJSONValue((Object)pSSFStyleVerBase.getMajor()), (boolean)false);
        }
        if (bl || pSSFStyleVerBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSFStyleVerBase.getJSONValue((Object)pSSFStyleVerBase.getMemo()), (boolean)false);
        }
        if (bl || pSSFStyleVerBase.getMinor() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minor", (Object)PSSFStyleVerBase.getJSONValue((Object)pSSFStyleVerBase.getMinor()), (boolean)false);
        }
        if (bl || pSSFStyleVerBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSSFStyleVerBase.getJSONValue((Object)pSSFStyleVerBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSSFStyleVerBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSSFStyleVerBase.getJSONValue((Object)pSSFStyleVerBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSSFStyleVerBase.getPSDevCenterSVNId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentersvnid", (Object)PSSFStyleVerBase.getJSONValue((Object)pSSFStyleVerBase.getPSDevCenterSVNId()), (boolean)false);
        }
        if (bl || pSSFStyleVerBase.getPSDevCenterSVNName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentersvnname", (Object)PSSFStyleVerBase.getJSONValue((Object)pSSFStyleVerBase.getPSDevCenterSVNName()), (boolean)false);
        }
        if (bl || pSSFStyleVerBase.getPSSFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfid", (Object)PSSFStyleVerBase.getJSONValue((Object)pSSFStyleVerBase.getPSSFId()), (boolean)false);
        }
        if (bl || pSSFStyleVerBase.getPSSFStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfstyleid", (Object)PSSFStyleVerBase.getJSONValue((Object)pSSFStyleVerBase.getPSSFStyleId()), (boolean)false);
        }
        if (bl || pSSFStyleVerBase.getPSSFStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfstylename", (Object)PSSFStyleVerBase.getJSONValue((Object)pSSFStyleVerBase.getPSSFStyleName()), (boolean)false);
        }
        if (bl || pSSFStyleVerBase.getPSSFStyleVerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfstyleverid", (Object)PSSFStyleVerBase.getJSONValue((Object)pSSFStyleVerBase.getPSSFStyleVerId()), (boolean)false);
        }
        if (bl || pSSFStyleVerBase.getPSSFStyleVerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfstylevername", (Object)PSSFStyleVerBase.getJSONValue((Object)pSSFStyleVerBase.getPSSFStyleVerName()), (boolean)false);
        }
        if (bl || pSSFStyleVerBase.getPubMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pubmode", (Object)PSSFStyleVerBase.getJSONValue((Object)pSSFStyleVerBase.getPubMode()), (boolean)false);
        }
        if (bl || pSSFStyleVerBase.getTemplInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templinfo", (Object)PSSFStyleVerBase.getJSONValue((Object)pSSFStyleVerBase.getTemplInfo()), (boolean)false);
        }
        if (bl || pSSFStyleVerBase.getTemplState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templstate", (Object)PSSFStyleVerBase.getJSONValue((Object)pSSFStyleVerBase.getTemplState()), (boolean)false);
        }
        if (bl || pSSFStyleVerBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSFStyleVerBase.getJSONValue((Object)pSSFStyleVerBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSFStyleVerBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSFStyleVerBase.getJSONValue((Object)pSSFStyleVerBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSFStyleVerBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSFStyleVerBase.getJSONValue((Object)pSSFStyleVerBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSSFStyleVerBase.getVersion() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"version", (Object)PSSFStyleVerBase.getJSONValue((Object)pSSFStyleVerBase.getVersion()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSFStyleVerBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSFStyleVerBase pSSFStyleVerBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSFStyleVerBase.getCreateDate() != null) {
            object = pSSFStyleVerBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSFStyleVerBase.getCreateMan() != null) {
            object = pSSFStyleVerBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleVerBase.getLastImpTime() != null) {
            object = pSSFStyleVerBase.getLastImpTime();
            xmlNode.setAttribute(FIELD_LASTIMPTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSFStyleVerBase.getMajor() != null) {
            object = pSSFStyleVerBase.getMajor();
            xmlNode.setAttribute(FIELD_MAJOR, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSFStyleVerBase.getMemo() != null) {
            object = pSSFStyleVerBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleVerBase.getMinor() != null) {
            object = pSSFStyleVerBase.getMinor();
            xmlNode.setAttribute(FIELD_MINOR, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSFStyleVerBase.getPSDevCenterId() != null) {
            object = pSSFStyleVerBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleVerBase.getPSDevCenterName() != null) {
            object = pSSFStyleVerBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleVerBase.getPSDevCenterSVNId() != null) {
            object = pSSFStyleVerBase.getPSDevCenterSVNId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERSVNID, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleVerBase.getPSDevCenterSVNName() != null) {
            object = pSSFStyleVerBase.getPSDevCenterSVNName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERSVNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleVerBase.getPSSFId() != null) {
            object = pSSFStyleVerBase.getPSSFId();
            xmlNode.setAttribute(FIELD_PSSFID, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleVerBase.getPSSFStyleId() != null) {
            object = pSSFStyleVerBase.getPSSFStyleId();
            xmlNode.setAttribute(FIELD_PSSFSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleVerBase.getPSSFStyleName() != null) {
            object = pSSFStyleVerBase.getPSSFStyleName();
            xmlNode.setAttribute(FIELD_PSSFSTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleVerBase.getPSSFStyleVerId() != null) {
            object = pSSFStyleVerBase.getPSSFStyleVerId();
            xmlNode.setAttribute(FIELD_PSSFSTYLEVERID, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleVerBase.getPSSFStyleVerName() != null) {
            object = pSSFStyleVerBase.getPSSFStyleVerName();
            xmlNode.setAttribute(FIELD_PSSFSTYLEVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleVerBase.getPubMode() != null) {
            object = pSSFStyleVerBase.getPubMode();
            xmlNode.setAttribute(FIELD_PUBMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSFStyleVerBase.getTemplInfo() != null) {
            object = pSSFStyleVerBase.getTemplInfo();
            xmlNode.setAttribute(FIELD_TEMPLINFO, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleVerBase.getTemplState() != null) {
            object = pSSFStyleVerBase.getTemplState();
            xmlNode.setAttribute(FIELD_TEMPLSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSFStyleVerBase.getUpdateDate() != null) {
            object = pSSFStyleVerBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSFStyleVerBase.getUpdateMan() != null) {
            object = pSSFStyleVerBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleVerBase.getValidFlag() != null) {
            object = pSSFStyleVerBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSFStyleVerBase.getVersion() != null) {
            object = pSSFStyleVerBase.getVersion();
            xmlNode.setAttribute(FIELD_VERSION, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSFStyleVerBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSFStyleVerBase pSSFStyleVerBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSFStyleVerBase.isCreateDateDirty() && (bl || pSSFStyleVerBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSFStyleVerBase.getCreateDate());
        }
        if (pSSFStyleVerBase.isCreateManDirty() && (bl || pSSFStyleVerBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSFStyleVerBase.getCreateMan());
        }
        if (pSSFStyleVerBase.isLastImpTimeDirty() && (bl || pSSFStyleVerBase.getLastImpTime() != null)) {
            iDataObject.set(FIELD_LASTIMPTIME, (Object)pSSFStyleVerBase.getLastImpTime());
        }
        if (pSSFStyleVerBase.isMajorDirty() && (bl || pSSFStyleVerBase.getMajor() != null)) {
            iDataObject.set(FIELD_MAJOR, (Object)pSSFStyleVerBase.getMajor());
        }
        if (pSSFStyleVerBase.isMemoDirty() && (bl || pSSFStyleVerBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSFStyleVerBase.getMemo());
        }
        if (pSSFStyleVerBase.isMinorDirty() && (bl || pSSFStyleVerBase.getMinor() != null)) {
            iDataObject.set(FIELD_MINOR, (Object)pSSFStyleVerBase.getMinor());
        }
        if (pSSFStyleVerBase.isPSDevCenterIdDirty() && (bl || pSSFStyleVerBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSSFStyleVerBase.getPSDevCenterId());
        }
        if (pSSFStyleVerBase.isPSDevCenterNameDirty() && (bl || pSSFStyleVerBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSSFStyleVerBase.getPSDevCenterName());
        }
        if (pSSFStyleVerBase.isPSDevCenterSVNIdDirty() && (bl || pSSFStyleVerBase.getPSDevCenterSVNId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERSVNID, (Object)pSSFStyleVerBase.getPSDevCenterSVNId());
        }
        if (pSSFStyleVerBase.isPSDevCenterSVNNameDirty() && (bl || pSSFStyleVerBase.getPSDevCenterSVNName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERSVNNAME, (Object)pSSFStyleVerBase.getPSDevCenterSVNName());
        }
        if (pSSFStyleVerBase.isPSSFIdDirty() && (bl || pSSFStyleVerBase.getPSSFId() != null)) {
            iDataObject.set(FIELD_PSSFID, (Object)pSSFStyleVerBase.getPSSFId());
        }
        if (pSSFStyleVerBase.isPSSFStyleIdDirty() && (bl || pSSFStyleVerBase.getPSSFStyleId() != null)) {
            iDataObject.set(FIELD_PSSFSTYLEID, (Object)pSSFStyleVerBase.getPSSFStyleId());
        }
        if (pSSFStyleVerBase.isPSSFStyleNameDirty() && (bl || pSSFStyleVerBase.getPSSFStyleName() != null)) {
            iDataObject.set(FIELD_PSSFSTYLENAME, (Object)pSSFStyleVerBase.getPSSFStyleName());
        }
        if (pSSFStyleVerBase.isPSSFStyleVerIdDirty() && (bl || pSSFStyleVerBase.getPSSFStyleVerId() != null)) {
            iDataObject.set(FIELD_PSSFSTYLEVERID, (Object)pSSFStyleVerBase.getPSSFStyleVerId());
        }
        if (pSSFStyleVerBase.isPSSFStyleVerNameDirty() && (bl || pSSFStyleVerBase.getPSSFStyleVerName() != null)) {
            iDataObject.set(FIELD_PSSFSTYLEVERNAME, (Object)pSSFStyleVerBase.getPSSFStyleVerName());
        }
        if (pSSFStyleVerBase.isPubModeDirty() && (bl || pSSFStyleVerBase.getPubMode() != null)) {
            iDataObject.set(FIELD_PUBMODE, (Object)pSSFStyleVerBase.getPubMode());
        }
        if (pSSFStyleVerBase.isTemplInfoDirty() && (bl || pSSFStyleVerBase.getTemplInfo() != null)) {
            iDataObject.set(FIELD_TEMPLINFO, (Object)pSSFStyleVerBase.getTemplInfo());
        }
        if (pSSFStyleVerBase.isTemplStateDirty() && (bl || pSSFStyleVerBase.getTemplState() != null)) {
            iDataObject.set(FIELD_TEMPLSTATE, (Object)pSSFStyleVerBase.getTemplState());
        }
        if (pSSFStyleVerBase.isUpdateDateDirty() && (bl || pSSFStyleVerBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSFStyleVerBase.getUpdateDate());
        }
        if (pSSFStyleVerBase.isUpdateManDirty() && (bl || pSSFStyleVerBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSFStyleVerBase.getUpdateMan());
        }
        if (pSSFStyleVerBase.isValidFlagDirty() && (bl || pSSFStyleVerBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSFStyleVerBase.getValidFlag());
        }
        if (pSSFStyleVerBase.isVersionDirty() && (bl || pSSFStyleVerBase.getVersion() != null)) {
            iDataObject.set(FIELD_VERSION, (Object)pSSFStyleVerBase.getVersion());
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
        return PSSFStyleVerBase.remove(this, n);
    }

    private static boolean remove(PSSFStyleVerBase pSSFStyleVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSFStyleVerBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSFStyleVerBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSFStyleVerBase.resetLastImpTime();
                return true;
            }
            case 3: {
                pSSFStyleVerBase.resetMajor();
                return true;
            }
            case 4: {
                pSSFStyleVerBase.resetMemo();
                return true;
            }
            case 5: {
                pSSFStyleVerBase.resetMinor();
                return true;
            }
            case 6: {
                pSSFStyleVerBase.resetPSDevCenterId();
                return true;
            }
            case 7: {
                pSSFStyleVerBase.resetPSDevCenterName();
                return true;
            }
            case 8: {
                pSSFStyleVerBase.resetPSDevCenterSVNId();
                return true;
            }
            case 9: {
                pSSFStyleVerBase.resetPSDevCenterSVNName();
                return true;
            }
            case 10: {
                pSSFStyleVerBase.resetPSSFId();
                return true;
            }
            case 11: {
                pSSFStyleVerBase.resetPSSFStyleId();
                return true;
            }
            case 12: {
                pSSFStyleVerBase.resetPSSFStyleName();
                return true;
            }
            case 13: {
                pSSFStyleVerBase.resetPSSFStyleVerId();
                return true;
            }
            case 14: {
                pSSFStyleVerBase.resetPSSFStyleVerName();
                return true;
            }
            case 15: {
                pSSFStyleVerBase.resetPubMode();
                return true;
            }
            case 16: {
                pSSFStyleVerBase.resetTemplInfo();
                return true;
            }
            case 17: {
                pSSFStyleVerBase.resetTemplState();
                return true;
            }
            case 18: {
                pSSFStyleVerBase.resetUpdateDate();
                return true;
            }
            case 19: {
                pSSFStyleVerBase.resetUpdateMan();
                return true;
            }
            case 20: {
                pSSFStyleVerBase.resetValidFlag();
                return true;
            }
            case 21: {
                pSSFStyleVerBase.resetVersion();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterSVN getPSDevCenterSVN() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterSVN();
        }
        if (this.getPSDevCenterSVNId() == null) {
            return null;
        }
        Integer n = this.objPSDevCenterSVNLock;
        synchronized (n) {
            if (this.psdevcentersvn != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevCenterSVNId(), (Object)this.psdevcentersvn.getPSDevCenterSVNId()) != 0L) {
                this.psdevcentersvn = null;
            }
            if (this.psdevcentersvn == null) {
                PSDevCenterSVN pSDevCenterSVN = new PSDevCenterSVN();
                pSDevCenterSVN.setPSDevCenterSVNId(this.getPSDevCenterSVNId());
                PSDevCenterSVNService pSDevCenterSVNService = (PSDevCenterSVNService)ServiceGlobal.getService(PSDevCenterSVNService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterSVNService.autoGet((IEntity)pSDevCenterSVN);
                this.psdevcentersvn = pSDevCenterSVN;
            }
            return this.psdevcentersvn;
        }
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
                pSDevCenterService.autoGet((IEntity)pSDevCenter);
                this.psdevcenter = pSDevCenter;
            }
            return this.psdevcenter;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSFStyle getPSSFStyle() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStyle();
        }
        if (this.getPSSFStyleId() == null) {
            return null;
        }
        Integer n = this.objPSSFStyleLock;
        synchronized (n) {
            if (this.pssfstyle != null && DataTypeHelper.compare((int)25, (Object)this.getPSSFStyleId(), (Object)this.pssfstyle.getPSSFStyleId()) != 0L) {
                this.pssfstyle = null;
            }
            if (this.pssfstyle == null) {
                PSSFStyle pSSFStyle = new PSSFStyle();
                pSSFStyle.setPSSFStyleId(this.getPSSFStyleId());
                PSSFStyleService pSSFStyleService = (PSSFStyleService)ServiceGlobal.getService(PSSFStyleService.class, (SessionFactory)this.getSessionFactory());
                pSSFStyleService.autoGet((IEntity)pSSFStyle);
                this.pssfstyle = pSSFStyle;
            }
            return this.pssfstyle;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSFVerCode> getPSSFVerCodes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFVerCodes();
        }
        if (this.getPSSFStyleVerId() == null) {
            return null;
        }
        PSSFVerCodeService pSSFVerCodeService = (PSSFVerCodeService)ServiceGlobal.getService(PSSFVerCodeService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSFVerCodesLock;
        synchronized (n) {
            if (this.pssfvercodes == null) {
                this.pssfvercodes = pSSFVerCodeService.selectByPSSFStyleVer(this);
            }
            return this.pssfvercodes;
        }
    }

    private PSSFStyleVerBase getProxyEntity() {
        return this.proxyPSSFStyleVerBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSFStyleVerBase = null;
        if (iDataObject != null && iDataObject instanceof PSSFStyleVerBase) {
            this.proxyPSSFStyleVerBase = (PSSFStyleVerBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFStyleVerService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_LASTIMPTIME, 2);
        fieldIndexMap.put(FIELD_MAJOR, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_MINOR, 5);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 6);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 7);
        fieldIndexMap.put(FIELD_PSDEVCENTERSVNID, 8);
        fieldIndexMap.put(FIELD_PSDEVCENTERSVNNAME, 9);
        fieldIndexMap.put(FIELD_PSSFID, 10);
        fieldIndexMap.put(FIELD_PSSFSTYLEID, 11);
        fieldIndexMap.put(FIELD_PSSFSTYLENAME, 12);
        fieldIndexMap.put(FIELD_PSSFSTYLEVERID, 13);
        fieldIndexMap.put(FIELD_PSSFSTYLEVERNAME, 14);
        fieldIndexMap.put(FIELD_PUBMODE, 15);
        fieldIndexMap.put(FIELD_TEMPLINFO, 16);
        fieldIndexMap.put(FIELD_TEMPLSTATE, 17);
        fieldIndexMap.put(FIELD_UPDATEDATE, 18);
        fieldIndexMap.put(FIELD_UPDATEMAN, 19);
        fieldIndexMap.put(FIELD_VALIDFLAG, 20);
        fieldIndexMap.put(FIELD_VERSION, 21);
    }
}

