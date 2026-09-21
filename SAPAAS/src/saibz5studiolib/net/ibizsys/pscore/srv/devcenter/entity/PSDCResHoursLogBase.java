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
package net.ibizsys.pscore.srv.devcenter.entity;

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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCResHours;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDCResHoursService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCResHoursLogBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCResHoursLogBase.class);
    public static final String FIELD_BEGINTIME = "BEGINTIME";
    public static final String FIELD_CANCELFLAG = "CANCELFLAG";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ENDTIME = "ENDTIME";
    public static final String FIELD_HOURS = "HOURS";
    public static final String FIELD_LOGINFO = "LOGINFO";
    public static final String FIELD_LOGLEVEL2 = "LOGLEVEL2";
    public static final String FIELD_PSDCRESHOURSID = "PSDCRESHOURSID";
    public static final String FIELD_PSDCRESHOURSLOGID = "PSDCRESHOURSLOGID";
    public static final String FIELD_PSDCRESHOURSLOGNAME = "PSDCRESHOURSLOGNAME";
    public static final String FIELD_PSDCRESHOURSNAME = "PSDCRESHOURSNAME";
    public static final String FIELD_PSDCRESID = "PSDCRESID";
    public static final String FIELD_PSDCRESNAME = "PSDCRESNAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSRESID = "PSRESID";
    public static final String FIELD_PSRESNAME = "PSRESNAME";
    public static final String FIELD_RESSPEC = "RESSPEC";
    public static final String FIELD_RESTYPE = "RESTYPE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_BEGINTIME = 0;
    private static final int INDEX_CANCELFLAG = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_ENDTIME = 4;
    private static final int INDEX_HOURS = 5;
    private static final int INDEX_LOGINFO = 6;
    private static final int INDEX_LOGLEVEL2 = 7;
    private static final int INDEX_PSDCRESHOURSID = 8;
    private static final int INDEX_PSDCRESHOURSLOGID = 9;
    private static final int INDEX_PSDCRESHOURSLOGNAME = 10;
    private static final int INDEX_PSDCRESHOURSNAME = 11;
    private static final int INDEX_PSDCRESID = 12;
    private static final int INDEX_PSDCRESNAME = 13;
    private static final int INDEX_PSDEVCENTERID = 14;
    private static final int INDEX_PSDEVCENTERNAME = 15;
    private static final int INDEX_PSRESID = 16;
    private static final int INDEX_PSRESNAME = 17;
    private static final int INDEX_RESSPEC = 18;
    private static final int INDEX_RESTYPE = 19;
    private static final int INDEX_UPDATEDATE = 20;
    private static final int INDEX_UPDATEMAN = 21;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCResHoursLogBase proxyPSDCResHoursLogBase = null;
    private boolean begintimeDirtyFlag = false;
    private boolean cancelflagDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean endtimeDirtyFlag = false;
    private boolean hoursDirtyFlag = false;
    private boolean loginfoDirtyFlag = false;
    private boolean loglevel2DirtyFlag = false;
    private boolean psdcreshoursidDirtyFlag = false;
    private boolean psdcreshourslogidDirtyFlag = false;
    private boolean psdcreshourslognameDirtyFlag = false;
    private boolean psdcreshoursnameDirtyFlag = false;
    private boolean psdcresidDirtyFlag = false;
    private boolean psdcresnameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psresidDirtyFlag = false;
    private boolean psresnameDirtyFlag = false;
    private boolean resspecDirtyFlag = false;
    private boolean restypeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="begintime")
    private Timestamp begintime;
    @Column(name="cancelflag")
    private Integer cancelflag;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="endtime")
    private Timestamp endtime;
    @Column(name="hours")
    private Integer hours;
    @Column(name="loginfo")
    private String loginfo;
    @Column(name="loglevel2")
    private Integer loglevel2;
    @Column(name="psdcreshoursid")
    private String psdcreshoursid;
    @Column(name="psdcreshourslogid")
    private String psdcreshourslogid;
    @Column(name="psdcreshourslogname")
    private String psdcreshourslogname;
    @Column(name="psdcreshoursname")
    private String psdcreshoursname;
    @Column(name="psdcresid")
    private String psdcresid;
    @Column(name="psdcresname")
    private String psdcresname;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="psresid")
    private String psresid;
    @Column(name="psresname")
    private String psresname;
    @Column(name="resspec")
    private String resspec;
    @Column(name="restype")
    private String restype;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDCResHoursLock = new Integer(1);
    private PSDCResHours psdcreshours = null;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;

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

    public void setCancelFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCancelFlag(n);
            return;
        }
        this.cancelflag = n;
        this.cancelflagDirtyFlag = true;
    }

    public Integer getCancelFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCancelFlag();
        }
        return this.cancelflag;
    }

    public boolean isCancelFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCancelFlagDirty();
        }
        return this.cancelflagDirtyFlag;
    }

    public void resetCancelFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCancelFlag();
            return;
        }
        this.cancelflagDirtyFlag = false;
        this.cancelflag = null;
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

    public void setHours(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHours(n);
            return;
        }
        this.hours = n;
        this.hoursDirtyFlag = true;
    }

    public Integer getHours() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHours();
        }
        return this.hours;
    }

    public boolean isHoursDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHoursDirty();
        }
        return this.hoursDirtyFlag;
    }

    public void resetHours() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHours();
            return;
        }
        this.hoursDirtyFlag = false;
        this.hours = null;
    }

    public void setLogInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.loginfo = string;
        this.loginfoDirtyFlag = true;
    }

    public String getLogInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogInfo();
        }
        return this.loginfo;
    }

    public boolean isLogInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogInfoDirty();
        }
        return this.loginfoDirtyFlag;
    }

    public void resetLogInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogInfo();
            return;
        }
        this.loginfoDirtyFlag = false;
        this.loginfo = null;
    }

    public void setLogLevel2(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogLevel2(n);
            return;
        }
        this.loglevel2 = n;
        this.loglevel2DirtyFlag = true;
    }

    public Integer getLogLevel2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogLevel2();
        }
        return this.loglevel2;
    }

    public boolean isLogLevel2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogLevel2Dirty();
        }
        return this.loglevel2DirtyFlag;
    }

    public void resetLogLevel2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogLevel2();
            return;
        }
        this.loglevel2DirtyFlag = false;
        this.loglevel2 = null;
    }

    public void setPSDCResHoursId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCResHoursId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcreshoursid = string;
        this.psdcreshoursidDirtyFlag = true;
    }

    public String getPSDCResHoursId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCResHoursId();
        }
        return this.psdcreshoursid;
    }

    public boolean isPSDCResHoursIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCResHoursIdDirty();
        }
        return this.psdcreshoursidDirtyFlag;
    }

    public void resetPSDCResHoursId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCResHoursId();
            return;
        }
        this.psdcreshoursidDirtyFlag = false;
        this.psdcreshoursid = null;
    }

    public void setPSDCResHoursLogId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCResHoursLogId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcreshourslogid = string;
        this.psdcreshourslogidDirtyFlag = true;
    }

    public String getPSDCResHoursLogId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCResHoursLogId();
        }
        return this.psdcreshourslogid;
    }

    public boolean isPSDCResHoursLogIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCResHoursLogIdDirty();
        }
        return this.psdcreshourslogidDirtyFlag;
    }

    public void resetPSDCResHoursLogId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCResHoursLogId();
            return;
        }
        this.psdcreshourslogidDirtyFlag = false;
        this.psdcreshourslogid = null;
    }

    public void setPSDCResHoursLogName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCResHoursLogName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcreshourslogname = string;
        this.psdcreshourslognameDirtyFlag = true;
    }

    public String getPSDCResHoursLogName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCResHoursLogName();
        }
        return this.psdcreshourslogname;
    }

    public boolean isPSDCResHoursLogNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCResHoursLogNameDirty();
        }
        return this.psdcreshourslognameDirtyFlag;
    }

    public void resetPSDCResHoursLogName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCResHoursLogName();
            return;
        }
        this.psdcreshourslognameDirtyFlag = false;
        this.psdcreshourslogname = null;
    }

    public void setPSDCResHoursName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCResHoursName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcreshoursname = string;
        this.psdcreshoursnameDirtyFlag = true;
    }

    public String getPSDCResHoursName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCResHoursName();
        }
        return this.psdcreshoursname;
    }

    public boolean isPSDCResHoursNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCResHoursNameDirty();
        }
        return this.psdcreshoursnameDirtyFlag;
    }

    public void resetPSDCResHoursName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCResHoursName();
            return;
        }
        this.psdcreshoursnameDirtyFlag = false;
        this.psdcreshoursname = null;
    }

    public void setPSDCResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcresid = string;
        this.psdcresidDirtyFlag = true;
    }

    public String getPSDCResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCResId();
        }
        return this.psdcresid;
    }

    public boolean isPSDCResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCResIdDirty();
        }
        return this.psdcresidDirtyFlag;
    }

    public void resetPSDCResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCResId();
            return;
        }
        this.psdcresidDirtyFlag = false;
        this.psdcresid = null;
    }

    public void setPSDCResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcresname = string;
        this.psdcresnameDirtyFlag = true;
    }

    public String getPSDCResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCResName();
        }
        return this.psdcresname;
    }

    public boolean isPSDCResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCResNameDirty();
        }
        return this.psdcresnameDirtyFlag;
    }

    public void resetPSDCResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCResName();
            return;
        }
        this.psdcresnameDirtyFlag = false;
        this.psdcresname = null;
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

    public void setPSResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psresid = string;
        this.psresidDirtyFlag = true;
    }

    public String getPSResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSResId();
        }
        return this.psresid;
    }

    public boolean isPSResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSResIdDirty();
        }
        return this.psresidDirtyFlag;
    }

    public void resetPSResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSResId();
            return;
        }
        this.psresidDirtyFlag = false;
        this.psresid = null;
    }

    public void setPSResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psresname = string;
        this.psresnameDirtyFlag = true;
    }

    public String getPSResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSResName();
        }
        return this.psresname;
    }

    public boolean isPSResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSResNameDirty();
        }
        return this.psresnameDirtyFlag;
    }

    public void resetPSResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSResName();
            return;
        }
        this.psresnameDirtyFlag = false;
        this.psresname = null;
    }

    public void setResSpec(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResSpec(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.resspec = string;
        this.resspecDirtyFlag = true;
    }

    public String getResSpec() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResSpec();
        }
        return this.resspec;
    }

    public boolean isResSpecDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResSpecDirty();
        }
        return this.resspecDirtyFlag;
    }

    public void resetResSpec() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResSpec();
            return;
        }
        this.resspecDirtyFlag = false;
        this.resspec = null;
    }

    public void setResType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.restype = string;
        this.restypeDirtyFlag = true;
    }

    public String getResType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResType();
        }
        return this.restype;
    }

    public boolean isResTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResTypeDirty();
        }
        return this.restypeDirtyFlag;
    }

    public void resetResType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResType();
            return;
        }
        this.restypeDirtyFlag = false;
        this.restype = null;
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
        PSDCResHoursLogBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCResHoursLogBase pSDCResHoursLogBase) {
        pSDCResHoursLogBase.resetBeginTime();
        pSDCResHoursLogBase.resetCancelFlag();
        pSDCResHoursLogBase.resetCreateDate();
        pSDCResHoursLogBase.resetCreateMan();
        pSDCResHoursLogBase.resetEndTime();
        pSDCResHoursLogBase.resetHours();
        pSDCResHoursLogBase.resetLogInfo();
        pSDCResHoursLogBase.resetLogLevel2();
        pSDCResHoursLogBase.resetPSDCResHoursId();
        pSDCResHoursLogBase.resetPSDCResHoursLogId();
        pSDCResHoursLogBase.resetPSDCResHoursLogName();
        pSDCResHoursLogBase.resetPSDCResHoursName();
        pSDCResHoursLogBase.resetPSDCResId();
        pSDCResHoursLogBase.resetPSDCResName();
        pSDCResHoursLogBase.resetPSDevCenterId();
        pSDCResHoursLogBase.resetPSDevCenterName();
        pSDCResHoursLogBase.resetPSResId();
        pSDCResHoursLogBase.resetPSResName();
        pSDCResHoursLogBase.resetResSpec();
        pSDCResHoursLogBase.resetResType();
        pSDCResHoursLogBase.resetUpdateDate();
        pSDCResHoursLogBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isBeginTimeDirty()) {
            hashMap.put(FIELD_BEGINTIME, this.getBeginTime());
        }
        if (!bl || this.isCancelFlagDirty()) {
            hashMap.put(FIELD_CANCELFLAG, this.getCancelFlag());
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
        if (!bl || this.isHoursDirty()) {
            hashMap.put(FIELD_HOURS, this.getHours());
        }
        if (!bl || this.isLogInfoDirty()) {
            hashMap.put(FIELD_LOGINFO, this.getLogInfo());
        }
        if (!bl || this.isLogLevel2Dirty()) {
            hashMap.put(FIELD_LOGLEVEL2, this.getLogLevel2());
        }
        if (!bl || this.isPSDCResHoursIdDirty()) {
            hashMap.put(FIELD_PSDCRESHOURSID, this.getPSDCResHoursId());
        }
        if (!bl || this.isPSDCResHoursLogIdDirty()) {
            hashMap.put(FIELD_PSDCRESHOURSLOGID, this.getPSDCResHoursLogId());
        }
        if (!bl || this.isPSDCResHoursLogNameDirty()) {
            hashMap.put(FIELD_PSDCRESHOURSLOGNAME, this.getPSDCResHoursLogName());
        }
        if (!bl || this.isPSDCResHoursNameDirty()) {
            hashMap.put(FIELD_PSDCRESHOURSNAME, this.getPSDCResHoursName());
        }
        if (!bl || this.isPSDCResIdDirty()) {
            hashMap.put(FIELD_PSDCRESID, this.getPSDCResId());
        }
        if (!bl || this.isPSDCResNameDirty()) {
            hashMap.put(FIELD_PSDCRESNAME, this.getPSDCResName());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSResIdDirty()) {
            hashMap.put(FIELD_PSRESID, this.getPSResId());
        }
        if (!bl || this.isPSResNameDirty()) {
            hashMap.put(FIELD_PSRESNAME, this.getPSResName());
        }
        if (!bl || this.isResSpecDirty()) {
            hashMap.put(FIELD_RESSPEC, this.getResSpec());
        }
        if (!bl || this.isResTypeDirty()) {
            hashMap.put(FIELD_RESTYPE, this.getResType());
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
        return PSDCResHoursLogBase.get(this, n);
    }

    private static Object get(PSDCResHoursLogBase pSDCResHoursLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCResHoursLogBase.getBeginTime();
            }
            case 1: {
                return pSDCResHoursLogBase.getCancelFlag();
            }
            case 2: {
                return pSDCResHoursLogBase.getCreateDate();
            }
            case 3: {
                return pSDCResHoursLogBase.getCreateMan();
            }
            case 4: {
                return pSDCResHoursLogBase.getEndTime();
            }
            case 5: {
                return pSDCResHoursLogBase.getHours();
            }
            case 6: {
                return pSDCResHoursLogBase.getLogInfo();
            }
            case 7: {
                return pSDCResHoursLogBase.getLogLevel2();
            }
            case 8: {
                return pSDCResHoursLogBase.getPSDCResHoursId();
            }
            case 9: {
                return pSDCResHoursLogBase.getPSDCResHoursLogId();
            }
            case 10: {
                return pSDCResHoursLogBase.getPSDCResHoursLogName();
            }
            case 11: {
                return pSDCResHoursLogBase.getPSDCResHoursName();
            }
            case 12: {
                return pSDCResHoursLogBase.getPSDCResId();
            }
            case 13: {
                return pSDCResHoursLogBase.getPSDCResName();
            }
            case 14: {
                return pSDCResHoursLogBase.getPSDevCenterId();
            }
            case 15: {
                return pSDCResHoursLogBase.getPSDevCenterName();
            }
            case 16: {
                return pSDCResHoursLogBase.getPSResId();
            }
            case 17: {
                return pSDCResHoursLogBase.getPSResName();
            }
            case 18: {
                return pSDCResHoursLogBase.getResSpec();
            }
            case 19: {
                return pSDCResHoursLogBase.getResType();
            }
            case 20: {
                return pSDCResHoursLogBase.getUpdateDate();
            }
            case 21: {
                return pSDCResHoursLogBase.getUpdateMan();
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
        PSDCResHoursLogBase.set(this, n, object);
    }

    private static void set(PSDCResHoursLogBase pSDCResHoursLogBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCResHoursLogBase.setBeginTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDCResHoursLogBase.setCancelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 2: {
                pSDCResHoursLogBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSDCResHoursLogBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDCResHoursLogBase.setEndTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 5: {
                pSDCResHoursLogBase.setHours(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSDCResHoursLogBase.setLogInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDCResHoursLogBase.setLogLevel2(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSDCResHoursLogBase.setPSDCResHoursId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDCResHoursLogBase.setPSDCResHoursLogId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDCResHoursLogBase.setPSDCResHoursLogName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDCResHoursLogBase.setPSDCResHoursName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDCResHoursLogBase.setPSDCResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDCResHoursLogBase.setPSDCResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDCResHoursLogBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDCResHoursLogBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDCResHoursLogBase.setPSResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDCResHoursLogBase.setPSResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDCResHoursLogBase.setResSpec(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDCResHoursLogBase.setResType(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDCResHoursLogBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 21: {
                pSDCResHoursLogBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDCResHoursLogBase.isNull(this, n);
    }

    private static boolean isNull(PSDCResHoursLogBase pSDCResHoursLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCResHoursLogBase.getBeginTime() == null;
            }
            case 1: {
                return pSDCResHoursLogBase.getCancelFlag() == null;
            }
            case 2: {
                return pSDCResHoursLogBase.getCreateDate() == null;
            }
            case 3: {
                return pSDCResHoursLogBase.getCreateMan() == null;
            }
            case 4: {
                return pSDCResHoursLogBase.getEndTime() == null;
            }
            case 5: {
                return pSDCResHoursLogBase.getHours() == null;
            }
            case 6: {
                return pSDCResHoursLogBase.getLogInfo() == null;
            }
            case 7: {
                return pSDCResHoursLogBase.getLogLevel2() == null;
            }
            case 8: {
                return pSDCResHoursLogBase.getPSDCResHoursId() == null;
            }
            case 9: {
                return pSDCResHoursLogBase.getPSDCResHoursLogId() == null;
            }
            case 10: {
                return pSDCResHoursLogBase.getPSDCResHoursLogName() == null;
            }
            case 11: {
                return pSDCResHoursLogBase.getPSDCResHoursName() == null;
            }
            case 12: {
                return pSDCResHoursLogBase.getPSDCResId() == null;
            }
            case 13: {
                return pSDCResHoursLogBase.getPSDCResName() == null;
            }
            case 14: {
                return pSDCResHoursLogBase.getPSDevCenterId() == null;
            }
            case 15: {
                return pSDCResHoursLogBase.getPSDevCenterName() == null;
            }
            case 16: {
                return pSDCResHoursLogBase.getPSResId() == null;
            }
            case 17: {
                return pSDCResHoursLogBase.getPSResName() == null;
            }
            case 18: {
                return pSDCResHoursLogBase.getResSpec() == null;
            }
            case 19: {
                return pSDCResHoursLogBase.getResType() == null;
            }
            case 20: {
                return pSDCResHoursLogBase.getUpdateDate() == null;
            }
            case 21: {
                return pSDCResHoursLogBase.getUpdateMan() == null;
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
        return PSDCResHoursLogBase.contains(this, n);
    }

    private static boolean contains(PSDCResHoursLogBase pSDCResHoursLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCResHoursLogBase.isBeginTimeDirty();
            }
            case 1: {
                return pSDCResHoursLogBase.isCancelFlagDirty();
            }
            case 2: {
                return pSDCResHoursLogBase.isCreateDateDirty();
            }
            case 3: {
                return pSDCResHoursLogBase.isCreateManDirty();
            }
            case 4: {
                return pSDCResHoursLogBase.isEndTimeDirty();
            }
            case 5: {
                return pSDCResHoursLogBase.isHoursDirty();
            }
            case 6: {
                return pSDCResHoursLogBase.isLogInfoDirty();
            }
            case 7: {
                return pSDCResHoursLogBase.isLogLevel2Dirty();
            }
            case 8: {
                return pSDCResHoursLogBase.isPSDCResHoursIdDirty();
            }
            case 9: {
                return pSDCResHoursLogBase.isPSDCResHoursLogIdDirty();
            }
            case 10: {
                return pSDCResHoursLogBase.isPSDCResHoursLogNameDirty();
            }
            case 11: {
                return pSDCResHoursLogBase.isPSDCResHoursNameDirty();
            }
            case 12: {
                return pSDCResHoursLogBase.isPSDCResIdDirty();
            }
            case 13: {
                return pSDCResHoursLogBase.isPSDCResNameDirty();
            }
            case 14: {
                return pSDCResHoursLogBase.isPSDevCenterIdDirty();
            }
            case 15: {
                return pSDCResHoursLogBase.isPSDevCenterNameDirty();
            }
            case 16: {
                return pSDCResHoursLogBase.isPSResIdDirty();
            }
            case 17: {
                return pSDCResHoursLogBase.isPSResNameDirty();
            }
            case 18: {
                return pSDCResHoursLogBase.isResSpecDirty();
            }
            case 19: {
                return pSDCResHoursLogBase.isResTypeDirty();
            }
            case 20: {
                return pSDCResHoursLogBase.isUpdateDateDirty();
            }
            case 21: {
                return pSDCResHoursLogBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCResHoursLogBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCResHoursLogBase pSDCResHoursLogBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCResHoursLogBase.getBeginTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"begintime", (Object)PSDCResHoursLogBase.getJSONValue((Object)pSDCResHoursLogBase.getBeginTime()), (boolean)false);
        }
        if (bl || pSDCResHoursLogBase.getCancelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cancelflag", (Object)PSDCResHoursLogBase.getJSONValue((Object)pSDCResHoursLogBase.getCancelFlag()), (boolean)false);
        }
        if (bl || pSDCResHoursLogBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCResHoursLogBase.getJSONValue((Object)pSDCResHoursLogBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCResHoursLogBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCResHoursLogBase.getJSONValue((Object)pSDCResHoursLogBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCResHoursLogBase.getEndTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"endtime", (Object)PSDCResHoursLogBase.getJSONValue((Object)pSDCResHoursLogBase.getEndTime()), (boolean)false);
        }
        if (bl || pSDCResHoursLogBase.getHours() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"hours", (Object)PSDCResHoursLogBase.getJSONValue((Object)pSDCResHoursLogBase.getHours()), (boolean)false);
        }
        if (bl || pSDCResHoursLogBase.getLogInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"loginfo", (Object)PSDCResHoursLogBase.getJSONValue((Object)pSDCResHoursLogBase.getLogInfo()), (boolean)false);
        }
        if (bl || pSDCResHoursLogBase.getLogLevel2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"loglevel2", (Object)PSDCResHoursLogBase.getJSONValue((Object)pSDCResHoursLogBase.getLogLevel2()), (boolean)false);
        }
        if (bl || pSDCResHoursLogBase.getPSDCResHoursId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcreshoursid", (Object)PSDCResHoursLogBase.getJSONValue((Object)pSDCResHoursLogBase.getPSDCResHoursId()), (boolean)false);
        }
        if (bl || pSDCResHoursLogBase.getPSDCResHoursLogId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcreshourslogid", (Object)PSDCResHoursLogBase.getJSONValue((Object)pSDCResHoursLogBase.getPSDCResHoursLogId()), (boolean)false);
        }
        if (bl || pSDCResHoursLogBase.getPSDCResHoursLogName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcreshourslogname", (Object)PSDCResHoursLogBase.getJSONValue((Object)pSDCResHoursLogBase.getPSDCResHoursLogName()), (boolean)false);
        }
        if (bl || pSDCResHoursLogBase.getPSDCResHoursName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcreshoursname", (Object)PSDCResHoursLogBase.getJSONValue((Object)pSDCResHoursLogBase.getPSDCResHoursName()), (boolean)false);
        }
        if (bl || pSDCResHoursLogBase.getPSDCResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcresid", (Object)PSDCResHoursLogBase.getJSONValue((Object)pSDCResHoursLogBase.getPSDCResId()), (boolean)false);
        }
        if (bl || pSDCResHoursLogBase.getPSDCResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcresname", (Object)PSDCResHoursLogBase.getJSONValue((Object)pSDCResHoursLogBase.getPSDCResName()), (boolean)false);
        }
        if (bl || pSDCResHoursLogBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDCResHoursLogBase.getJSONValue((Object)pSDCResHoursLogBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDCResHoursLogBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDCResHoursLogBase.getJSONValue((Object)pSDCResHoursLogBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDCResHoursLogBase.getPSResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psresid", (Object)PSDCResHoursLogBase.getJSONValue((Object)pSDCResHoursLogBase.getPSResId()), (boolean)false);
        }
        if (bl || pSDCResHoursLogBase.getPSResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psresname", (Object)PSDCResHoursLogBase.getJSONValue((Object)pSDCResHoursLogBase.getPSResName()), (boolean)false);
        }
        if (bl || pSDCResHoursLogBase.getResSpec() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resspec", (Object)PSDCResHoursLogBase.getJSONValue((Object)pSDCResHoursLogBase.getResSpec()), (boolean)false);
        }
        if (bl || pSDCResHoursLogBase.getResType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"restype", (Object)PSDCResHoursLogBase.getJSONValue((Object)pSDCResHoursLogBase.getResType()), (boolean)false);
        }
        if (bl || pSDCResHoursLogBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCResHoursLogBase.getJSONValue((Object)pSDCResHoursLogBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCResHoursLogBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCResHoursLogBase.getJSONValue((Object)pSDCResHoursLogBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCResHoursLogBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCResHoursLogBase pSDCResHoursLogBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCResHoursLogBase.getBeginTime() != null) {
            object = pSDCResHoursLogBase.getBeginTime();
            xmlNode.setAttribute(FIELD_BEGINTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCResHoursLogBase.getCancelFlag() != null) {
            object = pSDCResHoursLogBase.getCancelFlag();
            xmlNode.setAttribute(FIELD_CANCELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCResHoursLogBase.getCreateDate() != null) {
            object = pSDCResHoursLogBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCResHoursLogBase.getCreateMan() != null) {
            object = pSDCResHoursLogBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCResHoursLogBase.getEndTime() != null) {
            object = pSDCResHoursLogBase.getEndTime();
            xmlNode.setAttribute(FIELD_ENDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCResHoursLogBase.getHours() != null) {
            object = pSDCResHoursLogBase.getHours();
            xmlNode.setAttribute(FIELD_HOURS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCResHoursLogBase.getLogInfo() != null) {
            object = pSDCResHoursLogBase.getLogInfo();
            xmlNode.setAttribute(FIELD_LOGINFO, object == null ? "" : (String)object);
        }
        if (bl || pSDCResHoursLogBase.getLogLevel2() != null) {
            object = pSDCResHoursLogBase.getLogLevel2();
            xmlNode.setAttribute(FIELD_LOGLEVEL2, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCResHoursLogBase.getPSDCResHoursId() != null) {
            object = pSDCResHoursLogBase.getPSDCResHoursId();
            xmlNode.setAttribute(FIELD_PSDCRESHOURSID, object == null ? "" : (String)object);
        }
        if (bl || pSDCResHoursLogBase.getPSDCResHoursLogId() != null) {
            object = pSDCResHoursLogBase.getPSDCResHoursLogId();
            xmlNode.setAttribute(FIELD_PSDCRESHOURSLOGID, object == null ? "" : (String)object);
        }
        if (bl || pSDCResHoursLogBase.getPSDCResHoursLogName() != null) {
            object = pSDCResHoursLogBase.getPSDCResHoursLogName();
            xmlNode.setAttribute(FIELD_PSDCRESHOURSLOGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCResHoursLogBase.getPSDCResHoursName() != null) {
            object = pSDCResHoursLogBase.getPSDCResHoursName();
            xmlNode.setAttribute(FIELD_PSDCRESHOURSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCResHoursLogBase.getPSDCResId() != null) {
            object = pSDCResHoursLogBase.getPSDCResId();
            xmlNode.setAttribute(FIELD_PSDCRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDCResHoursLogBase.getPSDCResName() != null) {
            object = pSDCResHoursLogBase.getPSDCResName();
            xmlNode.setAttribute(FIELD_PSDCRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCResHoursLogBase.getPSDevCenterId() != null) {
            object = pSDCResHoursLogBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCResHoursLogBase.getPSDevCenterName() != null) {
            object = pSDCResHoursLogBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCResHoursLogBase.getPSResId() != null) {
            object = pSDCResHoursLogBase.getPSResId();
            xmlNode.setAttribute(FIELD_PSRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDCResHoursLogBase.getPSResName() != null) {
            object = pSDCResHoursLogBase.getPSResName();
            xmlNode.setAttribute(FIELD_PSRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCResHoursLogBase.getResSpec() != null) {
            object = pSDCResHoursLogBase.getResSpec();
            xmlNode.setAttribute(FIELD_RESSPEC, object == null ? "" : (String)object);
        }
        if (bl || pSDCResHoursLogBase.getResType() != null) {
            object = pSDCResHoursLogBase.getResType();
            xmlNode.setAttribute(FIELD_RESTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDCResHoursLogBase.getUpdateDate() != null) {
            object = pSDCResHoursLogBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCResHoursLogBase.getUpdateMan() != null) {
            object = pSDCResHoursLogBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCResHoursLogBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCResHoursLogBase pSDCResHoursLogBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCResHoursLogBase.isBeginTimeDirty() && (bl || pSDCResHoursLogBase.getBeginTime() != null)) {
            iDataObject.set(FIELD_BEGINTIME, (Object)pSDCResHoursLogBase.getBeginTime());
        }
        if (pSDCResHoursLogBase.isCancelFlagDirty() && (bl || pSDCResHoursLogBase.getCancelFlag() != null)) {
            iDataObject.set(FIELD_CANCELFLAG, (Object)pSDCResHoursLogBase.getCancelFlag());
        }
        if (pSDCResHoursLogBase.isCreateDateDirty() && (bl || pSDCResHoursLogBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCResHoursLogBase.getCreateDate());
        }
        if (pSDCResHoursLogBase.isCreateManDirty() && (bl || pSDCResHoursLogBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCResHoursLogBase.getCreateMan());
        }
        if (pSDCResHoursLogBase.isEndTimeDirty() && (bl || pSDCResHoursLogBase.getEndTime() != null)) {
            iDataObject.set(FIELD_ENDTIME, (Object)pSDCResHoursLogBase.getEndTime());
        }
        if (pSDCResHoursLogBase.isHoursDirty() && (bl || pSDCResHoursLogBase.getHours() != null)) {
            iDataObject.set(FIELD_HOURS, (Object)pSDCResHoursLogBase.getHours());
        }
        if (pSDCResHoursLogBase.isLogInfoDirty() && (bl || pSDCResHoursLogBase.getLogInfo() != null)) {
            iDataObject.set(FIELD_LOGINFO, (Object)pSDCResHoursLogBase.getLogInfo());
        }
        if (pSDCResHoursLogBase.isLogLevel2Dirty() && (bl || pSDCResHoursLogBase.getLogLevel2() != null)) {
            iDataObject.set(FIELD_LOGLEVEL2, (Object)pSDCResHoursLogBase.getLogLevel2());
        }
        if (pSDCResHoursLogBase.isPSDCResHoursIdDirty() && (bl || pSDCResHoursLogBase.getPSDCResHoursId() != null)) {
            iDataObject.set(FIELD_PSDCRESHOURSID, (Object)pSDCResHoursLogBase.getPSDCResHoursId());
        }
        if (pSDCResHoursLogBase.isPSDCResHoursLogIdDirty() && (bl || pSDCResHoursLogBase.getPSDCResHoursLogId() != null)) {
            iDataObject.set(FIELD_PSDCRESHOURSLOGID, (Object)pSDCResHoursLogBase.getPSDCResHoursLogId());
        }
        if (pSDCResHoursLogBase.isPSDCResHoursLogNameDirty() && (bl || pSDCResHoursLogBase.getPSDCResHoursLogName() != null)) {
            iDataObject.set(FIELD_PSDCRESHOURSLOGNAME, (Object)pSDCResHoursLogBase.getPSDCResHoursLogName());
        }
        if (pSDCResHoursLogBase.isPSDCResHoursNameDirty() && (bl || pSDCResHoursLogBase.getPSDCResHoursName() != null)) {
            iDataObject.set(FIELD_PSDCRESHOURSNAME, (Object)pSDCResHoursLogBase.getPSDCResHoursName());
        }
        if (pSDCResHoursLogBase.isPSDCResIdDirty() && (bl || pSDCResHoursLogBase.getPSDCResId() != null)) {
            iDataObject.set(FIELD_PSDCRESID, (Object)pSDCResHoursLogBase.getPSDCResId());
        }
        if (pSDCResHoursLogBase.isPSDCResNameDirty() && (bl || pSDCResHoursLogBase.getPSDCResName() != null)) {
            iDataObject.set(FIELD_PSDCRESNAME, (Object)pSDCResHoursLogBase.getPSDCResName());
        }
        if (pSDCResHoursLogBase.isPSDevCenterIdDirty() && (bl || pSDCResHoursLogBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDCResHoursLogBase.getPSDevCenterId());
        }
        if (pSDCResHoursLogBase.isPSDevCenterNameDirty() && (bl || pSDCResHoursLogBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDCResHoursLogBase.getPSDevCenterName());
        }
        if (pSDCResHoursLogBase.isPSResIdDirty() && (bl || pSDCResHoursLogBase.getPSResId() != null)) {
            iDataObject.set(FIELD_PSRESID, (Object)pSDCResHoursLogBase.getPSResId());
        }
        if (pSDCResHoursLogBase.isPSResNameDirty() && (bl || pSDCResHoursLogBase.getPSResName() != null)) {
            iDataObject.set(FIELD_PSRESNAME, (Object)pSDCResHoursLogBase.getPSResName());
        }
        if (pSDCResHoursLogBase.isResSpecDirty() && (bl || pSDCResHoursLogBase.getResSpec() != null)) {
            iDataObject.set(FIELD_RESSPEC, (Object)pSDCResHoursLogBase.getResSpec());
        }
        if (pSDCResHoursLogBase.isResTypeDirty() && (bl || pSDCResHoursLogBase.getResType() != null)) {
            iDataObject.set(FIELD_RESTYPE, (Object)pSDCResHoursLogBase.getResType());
        }
        if (pSDCResHoursLogBase.isUpdateDateDirty() && (bl || pSDCResHoursLogBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCResHoursLogBase.getUpdateDate());
        }
        if (pSDCResHoursLogBase.isUpdateManDirty() && (bl || pSDCResHoursLogBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCResHoursLogBase.getUpdateMan());
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
        return PSDCResHoursLogBase.remove(this, n);
    }

    private static boolean remove(PSDCResHoursLogBase pSDCResHoursLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCResHoursLogBase.resetBeginTime();
                return true;
            }
            case 1: {
                pSDCResHoursLogBase.resetCancelFlag();
                return true;
            }
            case 2: {
                pSDCResHoursLogBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSDCResHoursLogBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSDCResHoursLogBase.resetEndTime();
                return true;
            }
            case 5: {
                pSDCResHoursLogBase.resetHours();
                return true;
            }
            case 6: {
                pSDCResHoursLogBase.resetLogInfo();
                return true;
            }
            case 7: {
                pSDCResHoursLogBase.resetLogLevel2();
                return true;
            }
            case 8: {
                pSDCResHoursLogBase.resetPSDCResHoursId();
                return true;
            }
            case 9: {
                pSDCResHoursLogBase.resetPSDCResHoursLogId();
                return true;
            }
            case 10: {
                pSDCResHoursLogBase.resetPSDCResHoursLogName();
                return true;
            }
            case 11: {
                pSDCResHoursLogBase.resetPSDCResHoursName();
                return true;
            }
            case 12: {
                pSDCResHoursLogBase.resetPSDCResId();
                return true;
            }
            case 13: {
                pSDCResHoursLogBase.resetPSDCResName();
                return true;
            }
            case 14: {
                pSDCResHoursLogBase.resetPSDevCenterId();
                return true;
            }
            case 15: {
                pSDCResHoursLogBase.resetPSDevCenterName();
                return true;
            }
            case 16: {
                pSDCResHoursLogBase.resetPSResId();
                return true;
            }
            case 17: {
                pSDCResHoursLogBase.resetPSResName();
                return true;
            }
            case 18: {
                pSDCResHoursLogBase.resetResSpec();
                return true;
            }
            case 19: {
                pSDCResHoursLogBase.resetResType();
                return true;
            }
            case 20: {
                pSDCResHoursLogBase.resetUpdateDate();
                return true;
            }
            case 21: {
                pSDCResHoursLogBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCResHours getPSDCResHours() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCResHours();
        }
        if (this.getPSDCResHoursId() == null) {
            return null;
        }
        Integer n = this.objPSDCResHoursLock;
        synchronized (n) {
            if (this.psdcreshours != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCResHoursId(), (Object)this.psdcreshours.getPSDCResHoursId()) != 0L) {
                this.psdcreshours = null;
            }
            if (this.psdcreshours == null) {
                PSDCResHours pSDCResHours = new PSDCResHours();
                pSDCResHours.setPSDCResHoursId(this.getPSDCResHoursId());
                PSDCResHoursService pSDCResHoursService = (PSDCResHoursService)ServiceGlobal.getService(PSDCResHoursService.class, (SessionFactory)this.getSessionFactory());
                pSDCResHoursService.autoGet((IEntity)pSDCResHours);
                this.psdcreshours = pSDCResHours;
            }
            return this.psdcreshours;
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

    private PSDCResHoursLogBase getProxyEntity() {
        return this.proxyPSDCResHoursLogBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCResHoursLogBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCResHoursLogBase) {
            this.proxyPSDCResHoursLogBase = (PSDCResHoursLogBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCResHoursLogService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BEGINTIME, 0);
        fieldIndexMap.put(FIELD_CANCELFLAG, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_ENDTIME, 4);
        fieldIndexMap.put(FIELD_HOURS, 5);
        fieldIndexMap.put(FIELD_LOGINFO, 6);
        fieldIndexMap.put(FIELD_LOGLEVEL2, 7);
        fieldIndexMap.put(FIELD_PSDCRESHOURSID, 8);
        fieldIndexMap.put(FIELD_PSDCRESHOURSLOGID, 9);
        fieldIndexMap.put(FIELD_PSDCRESHOURSLOGNAME, 10);
        fieldIndexMap.put(FIELD_PSDCRESHOURSNAME, 11);
        fieldIndexMap.put(FIELD_PSDCRESID, 12);
        fieldIndexMap.put(FIELD_PSDCRESNAME, 13);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 14);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 15);
        fieldIndexMap.put(FIELD_PSRESID, 16);
        fieldIndexMap.put(FIELD_PSRESNAME, 17);
        fieldIndexMap.put(FIELD_RESSPEC, 18);
        fieldIndexMap.put(FIELD_RESTYPE, 19);
        fieldIndexMap.put(FIELD_UPDATEDATE, 20);
        fieldIndexMap.put(FIELD_UPDATEMAN, 21);
    }
}

